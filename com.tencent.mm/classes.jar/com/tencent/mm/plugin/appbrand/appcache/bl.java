package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/appcache/WxaPluginCodeVersionInfoStorage;", "Lcom/tencent/mm/plugin/appbrand/storage/MAutoStorageWithMultiKey;", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPluginCodeVersionInfoRecord;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getPluginStringVersion", "", "id", "version", "", "setPluginStringVersion", "", "stringVersion", "Companion", "data-storage_release"})
public final class bl
  extends com.tencent.mm.plugin.appbrand.x.c<bk>
{
  @Deprecated
  public static final a jMf;
  
  static
  {
    AppMethodBeat.i(220746);
    jMf = new a((byte)0);
    AppMethodBeat.o(220746);
  }
  
  public bl(e parame)
  {
    super(parame, bk.hGW, "WxaPluginCodeVersionInfo", bk.INDEX_CREATE);
    AppMethodBeat.i(182795);
    AppMethodBeat.o(182795);
  }
  
  public final String aX(String paramString, int paramInt)
  {
    AppMethodBeat.i(182794);
    p.h(paramString, "id");
    bk localbk = new bk();
    localbk.field_pluginAppID = paramString;
    localbk.field_pluginAppVersion = paramInt;
    if (get((com.tencent.mm.sdk.e.c)localbk, new String[0]))
    {
      paramString = localbk.field_pluginStringVersion;
      AppMethodBeat.o(182794);
      return paramString;
    }
    AppMethodBeat.o(182794);
    return null;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/appcache/WxaPluginCodeVersionInfoStorage$Companion;", "", "()V", "TAG", "", "data-storage_release"})
  static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.bl
 * JD-Core Version:    0.7.0.1
 */