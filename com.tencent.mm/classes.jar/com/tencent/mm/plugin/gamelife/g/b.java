package com.tencent.mm.plugin.gamelife.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.gamelife.PluginGameLife;
import com.tencent.mm.pluginsdk.model.app.l.b;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import java.util.Arrays;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/gamelife/message/GameLifeAppMessageInterceptor;", "Lcom/tencent/mm/pluginsdk/model/app/AppMessageStorage$IAppMessageStorageInterceptor;", "()V", "get", "Lcom/tencent/mm/message/AppMessage;", "msgId", "", "insertNotify", "", "item", "isNotify", "replace", "shouldIntercept", "updateNotify", "keys", "", "", "(Lcom/tencent/mm/message/AppMessage;Z[Ljava/lang/String;)Z", "toGameLifeAppMessage", "Lcom/tencent/mm/plugin/gamelife/message/GameLifeAppMessage;", "Companion", "plugin-gamelife_release"})
public final class b
  implements l.b
{
  public static final a uyo;
  
  static
  {
    AppMethodBeat.i(211383);
    uyo = new a((byte)0);
    AppMethodBeat.o(211383);
  }
  
  private static a b(k paramk)
  {
    AppMethodBeat.i(211382);
    p.h(paramk, "$this$toGameLifeAppMessage");
    a locala = new a();
    locala.field_appId = paramk.field_appId;
    locala.field_description = paramk.field_description;
    locala.field_msgId = paramk.field_msgId;
    locala.field_source = paramk.field_source;
    locala.field_title = paramk.field_title;
    locala.field_type = paramk.field_type;
    locala.field_xml = paramk.field_xml;
    AppMethodBeat.o(211382);
    return locala;
  }
  
  public final boolean a(k paramk, boolean paramBoolean)
  {
    AppMethodBeat.i(211378);
    if (paramk == null)
    {
      AppMethodBeat.o(211378);
      return false;
    }
    paramBoolean = ((PluginGameLife)g.ad(PluginGameLife.class)).getAppMessageStorage().insertNotify((com.tencent.mm.sdk.e.c)b(paramk), paramBoolean);
    ad.i("GameLife.AppMessageInterceptor", "[insert ret:" + paramBoolean + "] appid:" + paramk.field_appId + " title:" + paramk.field_title + " desc:" + paramk.field_description + ' ' + "type:" + paramk.field_type + " msgId:" + paramk.field_msgId);
    AppMethodBeat.o(211378);
    return paramBoolean;
  }
  
  public final boolean a(k paramk, boolean paramBoolean, String... paramVarArgs)
  {
    AppMethodBeat.i(211381);
    p.h(paramVarArgs, "keys");
    if (paramk == null)
    {
      AppMethodBeat.o(211381);
      return false;
    }
    paramBoolean = ((PluginGameLife)g.ad(PluginGameLife.class)).getAppMessageStorage().updateNotify((com.tencent.mm.sdk.e.c)b(paramk), paramBoolean, (String[])Arrays.copyOf(paramVarArgs, paramVarArgs.length));
    ad.i("GameLife.AppMessageInterceptor", "[update ret:" + paramBoolean + "] appid:" + paramk.field_appId + " title:" + paramk.field_title + " desc:" + paramk.field_description + ' ' + "type:" + paramk.field_type + " msgId:" + paramk.field_msgId);
    AppMethodBeat.o(211381);
    return paramBoolean;
  }
  
  public final boolean b(k paramk, boolean paramBoolean)
  {
    AppMethodBeat.i(211379);
    if (paramk == null)
    {
      AppMethodBeat.o(211379);
      return false;
    }
    paramBoolean = ((PluginGameLife)g.ad(PluginGameLife.class)).getAppMessageStorage().replace((com.tencent.mm.sdk.e.c)b(paramk), paramBoolean);
    ad.i("GameLife.AppMessageInterceptor", "[replace ret:" + paramBoolean + "] appid:" + paramk.field_appId + " title:" + paramk.field_title + " desc:" + paramk.field_description + ' ' + "type:" + paramk.field_type + " msgId:" + paramk.field_msgId);
    AppMethodBeat.o(211379);
    return paramBoolean;
  }
  
  public final k xH(long paramLong)
  {
    AppMethodBeat.i(211380);
    a locala = new a();
    locala.field_msgId = paramLong;
    if (!((PluginGameLife)g.ad(PluginGameLife.class)).getAppMessageStorage().get((com.tencent.mm.sdk.e.c)locala, new String[0]))
    {
      ad.i("GameLife.AppMessageInterceptor", "[get] msg:" + paramLong + " not found!");
      AppMethodBeat.o(211380);
      return null;
    }
    ad.i("GameLife.AppMessageInterceptor", "[get] appId:" + locala.field_appId + " title:" + locala.field_title + " desc:" + locala.field_description + " type:" + locala.field_type + " msgId:" + locala.field_msgId);
    k localk = new k();
    localk.field_appId = locala.field_appId;
    localk.field_description = locala.field_description;
    localk.field_msgId = locala.field_msgId;
    localk.field_source = locala.field_source;
    localk.field_title = locala.field_title;
    localk.field_type = locala.field_type;
    localk.field_xml = locala.field_xml;
    AppMethodBeat.o(211380);
    return localk;
  }
  
  public final boolean xI(long paramLong)
  {
    return ((paramLong >= 4500001L) && (paramLong <= 5000000L)) || ((paramLong >= 208000001L) && (paramLong <= 308000000L));
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/gamelife/message/GameLifeAppMessageInterceptor$Companion;", "", "()V", "TAG", "", "plugin-gamelife_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.g.b
 * JD-Core Version:    0.7.0.1
 */