package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionModuleInfo;

public final class ak
{
  public static ModulePkgInfo a(WxaAttributes.WxaVersionModuleInfo paramWxaVersionModuleInfo)
  {
    AppMethodBeat.i(101712);
    ModulePkgInfo localModulePkgInfo = new ModulePkgInfo();
    localModulePkgInfo.name = paramWxaVersionModuleInfo.name;
    localModulePkgInfo.cqq = paramWxaVersionModuleInfo.cqq;
    localModulePkgInfo.cnm = paramWxaVersionModuleInfo.cnm;
    localModulePkgInfo.gUz = paramWxaVersionModuleInfo.gUz;
    AppMethodBeat.o(101712);
    return localModulePkgInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ak
 * JD-Core Version:    0.7.0.1
 */