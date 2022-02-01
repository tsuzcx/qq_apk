package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionModuleInfo;

public final class av
{
  public static ModulePkgInfo a(WxaAttributes.WxaVersionModuleInfo paramWxaVersionModuleInfo)
  {
    AppMethodBeat.i(146930);
    ModulePkgInfo localModulePkgInfo = new ModulePkgInfo();
    localModulePkgInfo.name = paramWxaVersionModuleInfo.name;
    localModulePkgInfo.md5 = paramWxaVersionModuleInfo.md5;
    localModulePkgInfo.independent = paramWxaVersionModuleInfo.independent;
    localModulePkgInfo.aliases = paramWxaVersionModuleInfo.aliases;
    AppMethodBeat.o(146930);
    return localModulePkgInfo;
  }
  
  public static abstract interface a<T>
  {
    public abstract T newInstance();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.av
 * JD-Core Version:    0.7.0.1
 */