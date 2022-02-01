package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/appcache/WxaPluginCodeVersionInfoStorage;", "Lcom/tencent/mm/plugin/appbrand/storage/MAutoStorageWithMultiKey;", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPluginCodeVersionInfoRecord;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getPluginStringVersion", "", "id", "version", "", "setPluginStringVersion", "", "stringVersion", "Companion", "data-storage_release"})
public final class bk
  extends com.tencent.mm.plugin.appbrand.y.c<bj>
{
  @Deprecated
  public static final a jJe;
  
  static
  {
    AppMethodBeat.i(190883);
    jJe = new a((byte)0);
    AppMethodBeat.o(190883);
  }
  
  public bk(e parame)
  {
    super(parame, bj.hEe, "WxaPluginCodeVersionInfo", bj.INDEX_CREATE);
    AppMethodBeat.i(182795);
    AppMethodBeat.o(182795);
  }
  
  public final String aU(String paramString, int paramInt)
  {
    AppMethodBeat.i(182794);
    p.h(paramString, "id");
    bj localbj = new bj();
    localbj.field_pluginAppID = paramString;
    localbj.field_pluginAppVersion = paramInt;
    if (get((com.tencent.mm.sdk.e.c)localbj, new String[0]))
    {
      paramString = localbj.field_pluginStringVersion;
      AppMethodBeat.o(182794);
      return paramString;
    }
    AppMethodBeat.o(182794);
    return null;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/appcache/WxaPluginCodeVersionInfoStorage$Companion;", "", "()V", "TAG", "", "data-storage_release"})
  static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.bk
 * JD-Core Version:    0.7.0.1
 */