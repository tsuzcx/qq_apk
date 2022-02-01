package com.tencent.mm.plugin.appbrand.aa;

import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.a.b.k;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.launching.e.d;
import com.tencent.mm.plugin.appbrand.launching.e.g;
import com.tencent.mm.plugin.appbrand.ui.t;
import com.tencent.mm.plugin.appbrand.y.m;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class a
  extends ContextWrapper
  implements g
{
  private FrameLayout cuN;
  private c<f> kAl;
  private int ksm;
  private ImageView mWF;
  private d mWG;
  
  public a(AppBrandLaunchProxyUI paramAppBrandLaunchProxyUI)
  {
    super(paramAppBrandLaunchProxyUI);
    AppMethodBeat.i(49323);
    this.ksm = 0;
    this.kAl = new c() {};
    AppMethodBeat.o(49323);
  }
  
  private void ew(String paramString1, final String paramString2)
  {
    AppMethodBeat.i(49327);
    ae.i("MicroMsg.AppBrandThumbFromMMProxyUI", "loadThumbImage:%s", new Object[] { paramString1 });
    b.aEl().a(new b.k()
    {
      public final String BN()
      {
        return "AppBrandThumbFromMMProxyUI#THUMB";
      }
      
      public final void F(Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(49321);
        ae.i("MicroMsg.AppBrandThumbFromMMProxyUI", "proxy thumb loaded");
        a.a(a.this, paramAnonymousBitmap);
        AppMethodBeat.o(49321);
      }
      
      public final void aEt() {}
      
      public final void ox()
      {
        AppMethodBeat.i(49322);
        ae.e("MicroMsg.AppBrandThumbFromMMProxyUI", "proxy thumb loaded fail");
        if (paramString2 != null) {
          a.a(a.this, paramString2);
        }
        AppMethodBeat.o(49322);
      }
    }, paramString1, null, null);
    AppMethodBeat.o(49327);
  }
  
  public final void H(Intent paramIntent)
  {
    AppMethodBeat.i(49326);
    t.a(((AppBrandLaunchProxyUI)super.getBaseContext()).getWindow(), true, false);
    Object localObject = d.SH(paramIntent.getStringExtra("extra_entry_token"));
    if (localObject == null)
    {
      finish();
      AppMethodBeat.o(49326);
      return;
    }
    ((d)localObject).setBaseContext((AppBrandLaunchProxyUI)super.getBaseContext());
    this.mWG = ((d)localObject);
    localObject = ((AppBrandLaunchProxyUI)super.getBaseContext()).getLayoutInflater().inflate(2131493006, null);
    this.cuN = ((FrameLayout)((View)localObject).findViewById(2131298739));
    this.mWF = ((ImageView)((View)localObject).findViewById(2131305792));
    ((AppBrandLaunchProxyUI)super.getBaseContext()).setContentView((View)localObject);
    if (paramIntent != null)
    {
      localObject = paramIntent.getStringExtra("extra_launch_thumb_url");
      paramIntent = paramIntent.getStringExtra("extra_launch_thumb_path");
      ae.i("MicroMsg.AppBrandThumbFromMMProxyUI", "showLaunchThumb, thumbUrl:%s, thumbPath:%s", new Object[] { localObject, paramIntent });
      if (bu.isNullOrNil((String)localObject)) {
        break label193;
      }
      ew((String)localObject, "file://".concat(String.valueOf(paramIntent)));
    }
    for (;;)
    {
      this.kAl.alive();
      ae.i("MicroMsg.AppBrandThumbFromMMProxyUI", "AppBrandThumbFromMMProxyUI onCreate");
      AppMethodBeat.o(49326);
      return;
      label193:
      if (!bu.isNullOrNil(paramIntent)) {
        ew("file://".concat(String.valueOf(paramIntent)), null);
      }
    }
  }
  
  public final AppBrandLaunchProxyUI bCM()
  {
    AppMethodBeat.i(49324);
    AppBrandLaunchProxyUI localAppBrandLaunchProxyUI = (AppBrandLaunchProxyUI)super.getBaseContext();
    AppMethodBeat.o(49324);
    return localAppBrandLaunchProxyUI;
  }
  
  public final boolean bsL()
  {
    return false;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(49325);
    if ((AppBrandLaunchProxyUI)super.getBaseContext() != null)
    {
      m.runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(49320);
          AppBrandLaunchProxyUI localAppBrandLaunchProxyUI = a.this.bCM();
          if ((localAppBrandLaunchProxyUI != null) && (!localAppBrandLaunchProxyUI.isFinishing()) && (!localAppBrandLaunchProxyUI.isDestroyed()))
          {
            ae.i("MicroMsg.AppBrandThumbFromMMProxyUI", "finish, baseContext:%s", new Object[] { localAppBrandLaunchProxyUI.getClass().getSimpleName() });
            if (a.a(a.this) != null)
            {
              ae.i("MicroMsg.AppBrandThumbFromMMProxyUI", "finish, make decorView invisible");
              a.a(a.this).removeAllViews();
              a.a(a.this).setBackgroundColor(0);
            }
            localAppBrandLaunchProxyUI.finish();
          }
          AppMethodBeat.o(49320);
        }
      });
      AppMethodBeat.o(49325);
      return;
    }
    ae.i("MicroMsg.AppBrandThumbFromMMProxyUI", "finish, no baseContext");
    AppMethodBeat.o(49325);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(49330);
    ae.i("MicroMsg.AppBrandThumbFromMMProxyUI", "AppBrandThumbFromMMProxyUI onDestroy");
    if (this.kAl != null) {
      this.kAl.dead();
    }
    if (this.mWG != null) {
      this.mWG.bsG();
    }
    AppMethodBeat.o(49330);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(49329);
    ae.i("MicroMsg.AppBrandThumbFromMMProxyUI", "AppBrandThumbFromMMProxyUI onPause");
    AppMethodBeat.o(49329);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(49328);
    this.ksm += 1;
    ae.i("MicroMsg.AppBrandThumbFromMMProxyUI", "AppBrandThumbFromMMProxyUI onResume, resume count:%d", new Object[] { Integer.valueOf(this.ksm) });
    if (this.ksm > 1)
    {
      ae.i("MicroMsg.AppBrandThumbFromMMProxyUI", "AppBrandThumbFromMMProxyUI onResume, finish when resume again");
      finish();
    }
    AppMethodBeat.o(49328);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.aa.a
 * JD-Core Version:    0.7.0.1
 */