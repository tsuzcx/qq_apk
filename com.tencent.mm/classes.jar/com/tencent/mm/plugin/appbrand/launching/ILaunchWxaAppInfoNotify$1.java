package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.plugin.appbrand.permission.AppRuntimeApiPermissionBundle;

final class ILaunchWxaAppInfoNotify$1
  implements ILaunchWxaAppInfoNotify
{
  public final void a(String paramString1, int paramInt, String paramString2, t paramt)
  {
    Object localObject = d.uS(paramString2);
    if (localObject != null)
    {
      ((d)localObject).a(paramString1, paramInt, paramString2, paramt);
      return;
    }
    paramString2 = new ILaunchWxaAppInfoNotify.LaunchInfoIpcWrapper();
    paramString2.appId = paramString1;
    paramString2.fJy = paramInt;
    paramString2.fPW = new AppRuntimeApiPermissionBundle(paramt.field_jsapiInfo);
    localObject = AppBrandLaunchErrorAction.CREATOR;
    paramString2.gKt = AppBrandLaunchErrorAction.a.a(paramString1, paramInt, paramt);
    com.tencent.mm.plugin.appbrand.ipc.d.a(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ILaunchWxaAppInfoNotify.1
 * JD-Core Version:    0.7.0.1
 */