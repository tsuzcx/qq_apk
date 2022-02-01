package com.tencent.mm.plugin.appbrand.utils;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.AppBrandRuntimeWCAccessible;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.permission.j;
import com.tencent.mm.plugin.appbrand.permission.j.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sensitive.d;
import com.tencent.mm.sensitive.d.a;
import com.tencent.mm.sensitive.d.d;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/utils/AppBrandPermissionDelegateLogic$delegate$2$1", "Lcom/tencent/mm/plugin/appbrand/permission/ICheckPermissionDelegate;", "checkIsLimit", "", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "permission", "", "convertPermissionToLimitBit", "", "getBusiness", "isPermissionGranted", "activity", "Landroid/app/Activity;", "requestPermission", "", "permissionResultCallback", "Lcom/tencent/mm/plugin/appbrand/permission/ICheckPermissionDelegate$PermissionResultCallback;", "useDelegate", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j$a$1
  implements j
{
  private static int R(f paramf)
  {
    AppMethodBeat.i(317398);
    Object localObject = ((g)paramf).getRuntime().asG();
    if (localObject == null)
    {
      paramf = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC");
      AppMethodBeat.o(317398);
      throw paramf;
    }
    localObject = (AppBrandSysConfigWC)localObject;
    if (((AppBrandSysConfigWC)localObject).qZg <= 0)
    {
      if (AppBrandRuntimeWCAccessible.G(((g)paramf).getRuntime()))
      {
        i = d.a.actq.qDL;
        AppMethodBeat.o(317398);
        return i;
      }
      i = d.a.actp.qDL;
      AppMethodBeat.o(317398);
      return i;
    }
    int i = ((AppBrandSysConfigWC)localObject).qZg;
    AppMethodBeat.o(317398);
    return i;
  }
  
  private static final void a(f paramf, String paramString, int paramInt, j.a parama, d.d paramd)
  {
    int i = -1;
    AppMethodBeat.i(317406);
    s.u(paramf, "$component");
    s.u(paramString, "$permission");
    Log.i("MicroMsg.AppBrandPermissionDelegateLogic", "requestPermission appid:" + paramf.getAppId() + " permission:" + paramString + " business:" + paramInt + " grantResult:" + paramd);
    if (paramd == null) {}
    for (paramInt = -1;; paramInt = a.$EnumSwitchMapping$0[paramd.ordinal()])
    {
      if (paramInt == 1) {
        i = 0;
      }
      if (parama != null) {
        parama.onPermissionResult(i);
      }
      AppMethodBeat.o(317406);
      return;
    }
  }
  
  public final void a(Activity paramActivity, f paramf, String paramString, j.a parama)
  {
    AppMethodBeat.i(317430);
    s.u(paramf, "component");
    s.u(paramString, "permission");
    int j = R(paramf);
    int i;
    boolean bool;
    if (s.p(paramString, "android.permission.ACCESS_FINE_LOCATION"))
    {
      i = 1;
      if (i != 0) {
        break label128;
      }
      bool = false;
    }
    for (;;)
    {
      Log.i("MicroMsg.AppBrandPermissionDelegateLogic", "requestPermission appid:" + paramf.getAppId() + " permission:" + paramString + " business:" + j + " isLimit:" + bool);
      if (!bool) {
        break label265;
      }
      if (parama != null) {
        parama.onPermissionResult(-1);
      }
      AppMethodBeat.o(317430);
      return;
      i = 0;
      break;
      label128:
      Object localObject = ((g)paramf).getRuntime().asG();
      if (localObject == null)
      {
        paramActivity = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC");
        AppMethodBeat.o(317430);
        throw paramActivity;
      }
      localObject = (AppBrandSysConfigWC)localObject;
      if ((((AppBrandSysConfigWC)localObject).qZh & 0x1) == 0)
      {
        bool = false;
      }
      else
      {
        bool = ((d)h.az(d.class)).isFrequencyLimit(((g)paramf).getAppId(), paramString);
        if (bool) {
          Log.i("MicroMsg.AppBrandPermissionDelegateLogic", "hit limit appId:" + ((g)paramf).getAppId() + " permission:" + paramString + " flag:" + ((AppBrandSysConfigWC)localObject).qZh);
        }
      }
    }
    label265:
    ((d)h.az(d.class)).requestPermission(paramActivity, paramf.getAppId(), paramString, j, new j.a.1..ExternalSyntheticLambda0(paramf, paramString, j, parama));
    AppMethodBeat.o(317430);
  }
  
  public final boolean a(Activity paramActivity, f paramf, String paramString)
  {
    AppMethodBeat.i(317422);
    s.u(paramf, "component");
    int i = R(paramf);
    paramActivity = ((d)h.az(d.class)).isPermissionGranted(paramActivity, paramString, i);
    Log.i("MicroMsg.AppBrandPermissionDelegateLogic", "isPermissionGranted permission: business:" + i + ' ' + paramString + " ret:" + paramActivity);
    if (paramActivity == d.d.actF)
    {
      AppMethodBeat.o(317422);
      return true;
    }
    AppMethodBeat.o(317422);
    return false;
  }
  
  public final boolean cGU()
  {
    AppMethodBeat.i(317416);
    ((d)h.az(d.class)).isUsingOldPermissionDialog();
    AppMethodBeat.o(317416);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.j.a.1
 * JD-Core Version:    0.7.0.1
 */