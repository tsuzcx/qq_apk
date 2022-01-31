package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyTransparentUI;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyTransparentUIProcessTask;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.protocal.c.arb;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;

final class JsApiLaunchApplication$1$1
  implements Runnable
{
  JsApiLaunchApplication$1$1(JsApiLaunchApplication.1 param1, int paramInt1, int paramInt2, b paramb) {}
  
  public final void run()
  {
    if ((this.bEf != 0) || (this.bEg != 0)) {
      this.ggi.gcp.C(this.ggi.dIS, this.ggi.ggh.h("fail:check fail", null));
    }
    Object localObject1;
    do
    {
      return;
      localObject2 = (arb)this.eew.ecF.ecN;
      switch (((arb)localObject2).bLB)
      {
      case 1: 
      default: 
        this.ggi.gcp.C(this.ggi.dIS, this.ggi.ggh.h("fail:check fail 1", null));
        return;
      case 2: 
        this.ggi.gcp.C(this.ggi.dIS, this.ggi.ggh.h("fail:check fail forbidden scene 2", null));
        return;
      }
      JsApiLaunchApplication.a locala = new JsApiLaunchApplication.a(new JsApiLaunchApplication.1.1.1(this));
      y.i("MicroMsg.JsApiLaunchApplication", "launchApplication check result(showType : %d, errCode : %d)", new Object[] { Integer.valueOf(((arb)localObject2).tmN), Integer.valueOf(((arb)localObject2).bLB) });
      if (!bk.bl(this.ggi.ggc))
      {
        Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(this.ggi.ggc));
        localIntent.addFlags(268435456);
        localObject1 = bk.A(this.ggi.gcp.getContext(), localIntent);
        if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
        {
          if ((TextUtils.isEmpty(localIntent.getPackage())) && (((List)localObject1).size() == 1)) {}
          for (localObject1 = g.b((ResolveInfo)((List)localObject1).get(0)); !bk.pm(ae.getPackageName()).equals(localObject1); localObject1 = localIntent.getPackage())
          {
            ai.d(new JsApiLaunchApplication.1.1.2(this, localIntent, (arb)localObject2, locala));
            return;
          }
        }
      }
      localObject1 = new JsApiLaunchApplication.LaunchApplicationTask((MMActivity)this.ggi.gcp.getContext());
      ((JsApiLaunchApplication.LaunchApplicationTask)localObject1).appId = this.ggi.gge;
      ((JsApiLaunchApplication.LaunchApplicationTask)localObject1).ggn = this.ggi.ggf;
      ((JsApiLaunchApplication.LaunchApplicationTask)localObject1).extInfo = this.ggi.ggg;
      ((JsApiLaunchApplication.LaunchApplicationTask)localObject1).bIo = this.ggi.ggd;
      ((JsApiLaunchApplication.LaunchApplicationTask)localObject1).showType = ((arb)localObject2).tmN;
      ((JsApiLaunchApplication.LaunchApplicationTask)localObject1).gfD = new JsApiLaunchApplication.1.1.3(this, (JsApiLaunchApplication.LaunchApplicationTask)localObject1);
      ((JsApiLaunchApplication.LaunchApplicationTask)localObject1).ahC();
    } while (((AppBrandProxyTransparentUIProcessTask)localObject1).mContext == null);
    AppBrandProxyTransparentUIProcessTask.gdL.put(((AppBrandProxyTransparentUIProcessTask)localObject1).gep, new WeakReference(localObject1));
    Object localObject2 = new Intent();
    ((Intent)localObject2).setClass(((AppBrandProxyTransparentUIProcessTask)localObject1).mContext, AppBrandProxyTransparentUI.class);
    ((Intent)localObject2).putExtra("task_object", (Parcelable)localObject1);
    ((Intent)localObject2).putExtra("task_class_name", localObject1.getClass().getName());
    ((Intent)localObject2).putExtra("task_id", ((AppBrandProxyTransparentUIProcessTask)localObject1).gep);
    ((Intent)localObject2).putExtra("orientation", ((AppBrandProxyTransparentUIProcessTask)localObject1).gen);
    if ((((AppBrandProxyTransparentUIProcessTask)localObject1).mContext instanceof MMActivity))
    {
      ((AppBrandProxyTransparentUIProcessTask)localObject1).ahC();
      ((MMActivity)((AppBrandProxyTransparentUIProcessTask)localObject1).mContext).gJb = ((AppBrandProxyTransparentUIProcessTask)localObject1).geo;
      ((MMActivity)((AppBrandProxyTransparentUIProcessTask)localObject1).mContext).startActivityForResult((Intent)localObject2, localObject1.hashCode() & 0xFFFF);
      return;
    }
    ((Intent)localObject2).addFlags(268435456);
    ((AppBrandProxyTransparentUIProcessTask)localObject1).mContext.startActivity((Intent)localObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplication.1.1
 * JD-Core Version:    0.7.0.1
 */