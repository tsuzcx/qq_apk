package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/appcache/WxaPluginCodeVersionInfoStorage;", "Lcom/tencent/mm/plugin/appbrand/storage/MAutoStorageWithMultiKey;", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPluginCodeVersionInfoRecord;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getPluginStringVersion", "", "id", "version", "", "setPluginStringVersion", "", "stringVersion", "data-storage_release"})
public final class bj
  extends com.tencent.mm.plugin.appbrand.z.c<bi>
{
  public bj(e parame)
  {
    super(parame, bi.gLr, "WxaPluginCodeVersionInfo", bi.INDEX_CREATE);
    AppMethodBeat.i(182795);
    AppMethodBeat.o(182795);
  }
  
  public final String aO(String paramString, int paramInt)
  {
    AppMethodBeat.i(182794);
    k.h(paramString, "id");
    bi localbi = new bi();
    localbi.field_pluginAppID = paramString;
    localbi.field_pluginAppVersion = paramInt;
    if (get((com.tencent.mm.sdk.e.c)localbi, new String[0]))
    {
      paramString = localbi.field_pluginStringVersion;
      AppMethodBeat.o(182794);
      return paramString;
    }
    AppMethodBeat.o(182794);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.bj
 * JD-Core Version:    0.7.0.1
 */