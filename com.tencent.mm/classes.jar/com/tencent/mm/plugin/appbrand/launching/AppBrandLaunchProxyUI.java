package com.tencent.mm.plugin.appbrand.launching;

import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import com.tencent.mm.modelappbrand.LaunchParamsOptional;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.launching.precondition.d;
import com.tencent.mm.plugin.appbrand.launching.precondition.f;
import com.tencent.mm.plugin.appbrand.launching.precondition.g;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.ui.l;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.p;

@a(7)
public final class AppBrandLaunchProxyUI
  extends MMBaseActivity
  implements k
{
  private p gIZ;
  private com.tencent.mm.plugin.appbrand.launching.precondition.h gJa;
  private MMActivity.a gJb = null;
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2, AppBrandStatObject paramAppBrandStatObject, AppBrandLaunchReferrer paramAppBrandLaunchReferrer, LaunchParamsOptional paramLaunchParamsOptional)
  {
    a(paramContext, paramString1, null, paramString2, paramInt1, paramInt2, paramAppBrandStatObject, paramAppBrandLaunchReferrer, paramLaunchParamsOptional);
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, AppBrandStatObject paramAppBrandStatObject, AppBrandLaunchReferrer paramAppBrandLaunchReferrer, LaunchParamsOptional paramLaunchParamsOptional)
  {
    if ((bk.bl(paramString1)) && (bk.bl(paramString2))) {
      return false;
    }
    return g.gMF.a(paramContext, paramString1, paramString2, paramString3, paramInt1, paramInt2, paramAppBrandStatObject, paramAppBrandLaunchReferrer, paramLaunchParamsOptional);
  }
  
  public static boolean o(Intent paramIntent)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramIntent != null) {
      bool1 = bool2;
    }
    try
    {
      if (paramIntent.getComponent() != null)
      {
        boolean bool3 = paramIntent.getComponent().getShortClassName().equals(".plugin.appbrand.launching.AppBrandLaunchProxyUI");
        bool1 = bool2;
        if (bool3) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (Exception paramIntent) {}
    return false;
  }
  
  public final void a(MMActivity.a parama, Intent paramIntent, int paramInt)
  {
    this.gJb = parama;
    startActivityForResult(paramIntent, paramInt);
  }
  
  public final boolean alB()
  {
    return !isFinishing();
  }
  
  protected final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.gJb != null) {
      this.gJb.c(paramInt1, paramInt2, paramIntent);
    }
    this.gJb = null;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (getIntent() == null) {
      finish();
    }
    label174:
    do
    {
      return;
      l.a(getWindow());
      l.a(getWindow(), true);
      if (!getIntent().getBooleanExtra("extra_from_mm", true)) {}
      for (paramBundle = new d(this);; paramBundle = new f(this))
      {
        this.gJa = paramBundle;
        if (this.gJa == null) {
          break label227;
        }
        y.i("MicroMsg.AppBrandLaunchProxyUI", "onCreate, uiDelegate %s", new Object[] { this.gJa.getClass().getSimpleName() });
        this.gJa.p(getIntent());
        if (isFinishing()) {
          break;
        }
        getString(y.j.app_tip);
        this.gIZ = com.tencent.mm.ui.base.h.b(this, getString(y.j.loading_tips), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppBrandLaunchProxyUI.this.finish();
          }
        });
        if (this.gIZ != null) {
          break label174;
        }
        y.e("MicroMsg.AppBrandLaunchProxyUI", "onCreate, get null progress dialog");
        finish();
        return;
      }
      this.gIZ.setOnDismissListener(new AppBrandLaunchProxyUI.2(this));
    } while (this.gIZ.getWindow() == null);
    paramBundle = this.gIZ.getWindow().getAttributes();
    paramBundle.dimAmount = 0.0F;
    this.gIZ.getWindow().setAttributes(paramBundle);
    return;
    label227:
    finish();
  }
  
  protected final void onDestroy()
  {
    super.onDestroy();
    if (this.gIZ != null)
    {
      this.gIZ.dismiss();
      this.gIZ = null;
    }
  }
  
  protected final void onPause()
  {
    super.onPause();
    if (this.gJa != null)
    {
      this.gJa.onPause();
      return;
    }
    super.finish();
  }
  
  protected final void onResume()
  {
    super.onResume();
    if (this.gJa != null)
    {
      this.gJa.onResume();
      return;
    }
    super.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI
 * JD-Core Version:    0.7.0.1
 */