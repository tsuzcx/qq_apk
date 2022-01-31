package com.tencent.mm.plugin.appbrand.launching;

import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;
import com.tencent.mm.plugin.appbrand.ipc.d;
import com.tencent.mm.plugin.appbrand.permission.AppRuntimeApiPermissionBundle;
import com.tencent.mm.protocal.protobuf.se;
import java.util.Locale;

final class ILaunchWxaAppInfoNotify$1
  implements ILaunchWxaAppInfoNotify
{
  private final String TAG = "MicroMsg.AppBrand.ILaunchWxaAppInfoNotify.INSTANCE[permission]";
  
  private static String a(ab paramab)
  {
    AppMethodBeat.i(131820);
    if (paramab == null)
    {
      AppMethodBeat.o(131820);
      return "NULL";
    }
    try
    {
      paramab = String.format(Locale.US, "bytes[%d]", new Object[] { Integer.valueOf(paramab.field_jsapiInfo.wKA.pW.length) });
      AppMethodBeat.o(131820);
      return paramab;
    }
    catch (Exception paramab)
    {
      paramab = String.format(Locale.US, "Exception[%s]", new Object[] { paramab });
      AppMethodBeat.o(131820);
    }
    return paramab;
  }
  
  public final void a(String paramString1, int paramInt, String paramString2, ab paramab)
  {
    AppMethodBeat.i(131819);
    Object localObject = g.Dl(paramString2);
    if (localObject != null)
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.AppBrand.ILaunchWxaAppInfoNotify.INSTANCE[permission]", "notifyLaunchInfoUpdate [update deferred process] appId[%s], type[%d], sessionId[%s], %s", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2, a(paramab) });
      ((g)localObject).a(paramString1, paramInt, paramString2, paramab);
    }
    try
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.AppBrand.ILaunchWxaAppInfoNotify.INSTANCE[permission]", "notifyLaunchInfoUpdate [update remote] appId[%s], type[%d], sessionId[%s], %s", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2, a(paramab) });
      localObject = new ILaunchWxaAppInfoNotify.LaunchInfoIpcWrapper();
      ((ILaunchWxaAppInfoNotify.LaunchInfoIpcWrapper)localObject).appId = paramString1;
      ((ILaunchWxaAppInfoNotify.LaunchInfoIpcWrapper)localObject).hcr = paramInt;
      ((ILaunchWxaAppInfoNotify.LaunchInfoIpcWrapper)localObject).bDn = new AppRuntimeApiPermissionBundle(paramab.field_jsapiInfo);
      AppBrandLaunchErrorAction.a locala = AppBrandLaunchErrorAction.CREATOR;
      ((ILaunchWxaAppInfoNotify.LaunchInfoIpcWrapper)localObject).ilk = AppBrandLaunchErrorAction.a.a(paramString1, paramInt, paramab);
      d.a(paramString1, (Parcelable)localObject);
      AppMethodBeat.o(131819);
      return;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.AppBrand.ILaunchWxaAppInfoNotify.INSTANCE[permission]", localThrowable, "notifyLaunchInfoUpdate [update remote] appId[%s], type[%d], sessionId[%s], %s", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2, a(paramab) });
      AppMethodBeat.o(131819);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ILaunchWxaAppInfoNotify.1
 * JD-Core Version:    0.7.0.1
 */