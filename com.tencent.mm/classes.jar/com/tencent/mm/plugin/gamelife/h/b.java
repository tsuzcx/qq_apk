package com.tencent.mm.plugin.gamelife.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.message.k;
import com.tencent.mm.plugin.gamelife.PluginGameLife;
import com.tencent.mm.pluginsdk.model.app.l.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelife/message/GameLifeAppMessageInterceptor;", "Lcom/tencent/mm/pluginsdk/model/app/AppMessageStorage$IAppMessageStorageInterceptor;", "()V", "get", "Lcom/tencent/mm/message/AppMessage;", "msgId", "", "insertNotify", "", "item", "isNotify", "replace", "shouldIntercept", "updateNotify", "keys", "", "", "(Lcom/tencent/mm/message/AppMessage;Z[Ljava/lang/String;)Z", "toGameLifeAppMessage", "Lcom/tencent/mm/plugin/gamelife/message/GameLifeAppMessage;", "Companion", "plugin-gamelife_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements l.b
{
  public static final b.a JbG;
  
  static
  {
    AppMethodBeat.i(267773);
    JbG = new b.a((byte)0);
    AppMethodBeat.o(267773);
  }
  
  private static a b(k paramk)
  {
    AppMethodBeat.i(267768);
    s.u(paramk, "<this>");
    a locala = new a();
    locala.field_appId = paramk.field_appId;
    locala.field_description = paramk.field_description;
    locala.field_msgId = paramk.field_msgId;
    locala.field_source = paramk.field_source;
    locala.field_title = paramk.field_title;
    locala.field_type = paramk.field_type;
    locala.field_xml = paramk.field_xml;
    AppMethodBeat.o(267768);
    return locala;
  }
  
  public final boolean a(k paramk, boolean paramBoolean)
  {
    AppMethodBeat.i(267780);
    if (paramk == null)
    {
      AppMethodBeat.o(267780);
      return false;
    }
    paramBoolean = ((PluginGameLife)h.az(PluginGameLife.class)).getAppMessageStorage().insertNotify((IAutoDBItem)b(paramk), paramBoolean);
    Log.i("GameLife.AppMessageInterceptor", "[insert ret:" + paramBoolean + "] appid:" + paramk.field_appId + " title:" + paramk.field_title + " desc:" + paramk.field_description + " type:" + paramk.field_type + " msgId:" + paramk.field_msgId);
    AppMethodBeat.o(267780);
    return paramBoolean;
  }
  
  public final boolean a(k paramk, boolean paramBoolean, String... paramVarArgs)
  {
    AppMethodBeat.i(267805);
    s.u(paramVarArgs, "keys");
    if (paramk == null)
    {
      AppMethodBeat.o(267805);
      return false;
    }
    paramBoolean = ((PluginGameLife)h.az(PluginGameLife.class)).getAppMessageStorage().updateNotify((IAutoDBItem)b(paramk), paramBoolean, (String[])Arrays.copyOf(paramVarArgs, paramVarArgs.length));
    Log.i("GameLife.AppMessageInterceptor", "[update ret:" + paramBoolean + "] appid:" + paramk.field_appId + " title:" + paramk.field_title + " desc:" + paramk.field_description + " type:" + paramk.field_type + " msgId:" + paramk.field_msgId);
    AppMethodBeat.o(267805);
    return paramBoolean;
  }
  
  public final boolean b(k paramk, boolean paramBoolean)
  {
    AppMethodBeat.i(267783);
    if (paramk == null)
    {
      AppMethodBeat.o(267783);
      return false;
    }
    paramBoolean = ((PluginGameLife)h.az(PluginGameLife.class)).getAppMessageStorage().replace((IAutoDBItem)b(paramk), paramBoolean);
    Log.i("GameLife.AppMessageInterceptor", "[replace ret:" + paramBoolean + "] appid:" + paramk.field_appId + " title:" + paramk.field_title + " desc:" + paramk.field_description + " type:" + paramk.field_type + " msgId:" + paramk.field_msgId);
    AppMethodBeat.o(267783);
    return paramBoolean;
  }
  
  public final k rI(long paramLong)
  {
    AppMethodBeat.i(267792);
    a locala = new a();
    locala.field_msgId = paramLong;
    if (!((PluginGameLife)h.az(PluginGameLife.class)).getAppMessageStorage().get((IAutoDBItem)locala, new String[0]))
    {
      Log.i("GameLife.AppMessageInterceptor", "[get] msg:" + paramLong + " not found!");
      AppMethodBeat.o(267792);
      return null;
    }
    Log.i("GameLife.AppMessageInterceptor", "[get] appId:" + locala.field_appId + " title:" + locala.field_title + " desc:" + locala.field_description + " type:" + locala.field_type + " msgId:" + locala.field_msgId);
    k localk = new k();
    localk.field_appId = locala.field_appId;
    localk.field_description = locala.field_description;
    localk.field_msgId = locala.field_msgId;
    localk.field_source = locala.field_source;
    localk.field_title = locala.field_title;
    localk.field_type = locala.field_type;
    localk.field_xml = locala.field_xml;
    AppMethodBeat.o(267792);
    return localk;
  }
  
  public final boolean rJ(long paramLong)
  {
    return ((paramLong >= 4500001L) && (paramLong <= 5000000L)) || ((paramLong >= 208000001L) && (paramLong <= 308000000L));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.h.b
 * JD-Core Version:    0.7.0.1
 */