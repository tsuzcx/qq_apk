package com.tencent.mm.plugin.gamelife.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.k;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.gamelife.PluginGameLife;
import com.tencent.mm.pluginsdk.model.app.l.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.util.Arrays;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gamelife/message/GameLifeAppMessageInterceptor;", "Lcom/tencent/mm/pluginsdk/model/app/AppMessageStorage$IAppMessageStorageInterceptor;", "()V", "get", "Lcom/tencent/mm/message/AppMessage;", "msgId", "", "insertNotify", "", "item", "isNotify", "replace", "shouldIntercept", "updateNotify", "keys", "", "", "(Lcom/tencent/mm/message/AppMessage;Z[Ljava/lang/String;)Z", "toGameLifeAppMessage", "Lcom/tencent/mm/plugin/gamelife/message/GameLifeAppMessage;", "Companion", "plugin-gamelife_release"})
public final class b
  implements l.b
{
  public static final b.a DhO;
  
  static
  {
    AppMethodBeat.i(204290);
    DhO = new b.a((byte)0);
    AppMethodBeat.o(204290);
  }
  
  private static a b(k paramk)
  {
    AppMethodBeat.i(204289);
    p.k(paramk, "$this$toGameLifeAppMessage");
    a locala = new a();
    locala.field_appId = paramk.field_appId;
    locala.field_description = paramk.field_description;
    locala.field_msgId = paramk.field_msgId;
    locala.field_source = paramk.field_source;
    locala.field_title = paramk.field_title;
    locala.field_type = paramk.field_type;
    locala.field_xml = paramk.field_xml;
    AppMethodBeat.o(204289);
    return locala;
  }
  
  public final k NR(long paramLong)
  {
    AppMethodBeat.i(204287);
    a locala = new a();
    locala.field_msgId = paramLong;
    if (!((PluginGameLife)h.ag(PluginGameLife.class)).getAppMessageStorage().get((IAutoDBItem)locala, new String[0]))
    {
      Log.i("GameLife.AppMessageInterceptor", "[get] msg:" + paramLong + " not found!");
      AppMethodBeat.o(204287);
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
    AppMethodBeat.o(204287);
    return localk;
  }
  
  public final boolean NS(long paramLong)
  {
    return ((paramLong >= 4500001L) && (paramLong <= 5000000L)) || ((paramLong >= 208000001L) && (paramLong <= 308000000L));
  }
  
  public final boolean a(k paramk, boolean paramBoolean)
  {
    AppMethodBeat.i(204284);
    if (paramk == null)
    {
      AppMethodBeat.o(204284);
      return false;
    }
    paramBoolean = ((PluginGameLife)h.ag(PluginGameLife.class)).getAppMessageStorage().insertNotify((IAutoDBItem)b(paramk), paramBoolean);
    Log.i("GameLife.AppMessageInterceptor", "[insert ret:" + paramBoolean + "] appid:" + paramk.field_appId + " title:" + paramk.field_title + " desc:" + paramk.field_description + ' ' + "type:" + paramk.field_type + " msgId:" + paramk.field_msgId);
    AppMethodBeat.o(204284);
    return paramBoolean;
  }
  
  public final boolean a(k paramk, boolean paramBoolean, String... paramVarArgs)
  {
    AppMethodBeat.i(204288);
    p.k(paramVarArgs, "keys");
    if (paramk == null)
    {
      AppMethodBeat.o(204288);
      return false;
    }
    paramBoolean = ((PluginGameLife)h.ag(PluginGameLife.class)).getAppMessageStorage().updateNotify((IAutoDBItem)b(paramk), paramBoolean, (String[])Arrays.copyOf(paramVarArgs, paramVarArgs.length));
    Log.i("GameLife.AppMessageInterceptor", "[update ret:" + paramBoolean + "] appid:" + paramk.field_appId + " title:" + paramk.field_title + " desc:" + paramk.field_description + ' ' + "type:" + paramk.field_type + " msgId:" + paramk.field_msgId);
    AppMethodBeat.o(204288);
    return paramBoolean;
  }
  
  public final boolean b(k paramk, boolean paramBoolean)
  {
    AppMethodBeat.i(204286);
    if (paramk == null)
    {
      AppMethodBeat.o(204286);
      return false;
    }
    paramBoolean = ((PluginGameLife)h.ag(PluginGameLife.class)).getAppMessageStorage().replace((IAutoDBItem)b(paramk), paramBoolean);
    Log.i("GameLife.AppMessageInterceptor", "[replace ret:" + paramBoolean + "] appid:" + paramk.field_appId + " title:" + paramk.field_title + " desc:" + paramk.field_description + ' ' + "type:" + paramk.field_type + " msgId:" + paramk.field_msgId);
    AppMethodBeat.o(204286);
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.g.b
 * JD-Core Version:    0.7.0.1
 */