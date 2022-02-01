package com.tencent.mm.plugin.appbrand.ab;

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
import com.tencent.mm.plugin.appbrand.ui.s;
import com.tencent.mm.plugin.appbrand.z.m;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class a
  extends ContextWrapper
  implements g
{
  private FrameLayout cuk;
  private int koW;
  private c<f> kwW;
  private ImageView mRw;
  private d mRx;
  
  public a(AppBrandLaunchProxyUI paramAppBrandLaunchProxyUI)
  {
    super(paramAppBrandLaunchProxyUI);
    AppMethodBeat.i(49323);
    this.koW = 0;
    this.kwW = new c() {};
    AppMethodBeat.o(49323);
  }
  
  private void et(String paramString1, final String paramString2)
  {
    AppMethodBeat.i(49327);
    ad.i("MicroMsg.AppBrandThumbFromMMProxyUI", "loadThumbImage:%s", new Object[] { paramString1 });
    b.aDV().a(new b.k()
    {
      public final String BM()
      {
        return "AppBrandThumbFromMMProxyUI#THUMB";
      }
      
      public final void E(Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(49321);
        ad.i("MicroMsg.AppBrandThumbFromMMProxyUI", "proxy thumb loaded");
        a.a(a.this, paramAnonymousBitmap);
        AppMethodBeat.o(49321);
      }
      
      public final void aEd() {}
      
      public final void ox()
      {
        AppMethodBeat.i(49322);
        ad.e("MicroMsg.AppBrandThumbFromMMProxyUI", "proxy thumb loaded fail");
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
    s.a(((AppBrandLaunchProxyUI)super.getBaseContext()).getWindow(), true, false);
    Object localObject = d.RY(paramIntent.getStringExtra("extra_entry_token"));
    if (localObject == null)
    {
      finish();
      AppMethodBeat.o(49326);
      return;
    }
    ((d)localObject).setBaseContext((AppBrandLaunchProxyUI)super.getBaseContext());
    this.mRx = ((d)localObject);
    localObject = ((AppBrandLaunchProxyUI)super.getBaseContext()).getLayoutInflater().inflate(2131493006, null);
    this.cuk = ((FrameLayout)((View)localObject).findViewById(2131298739));
    this.mRw = ((ImageView)((View)localObject).findViewById(2131305792));
    ((AppBrandLaunchProxyUI)super.getBaseContext()).setContentView((View)localObject);
    if (paramIntent != null)
    {
      localObject = paramIntent.getStringExtra("extra_launch_thumb_url");
      paramIntent = paramIntent.getStringExtra("extra_launch_thumb_path");
      ad.i("MicroMsg.AppBrandThumbFromMMProxyUI", "showLaunchThumb, thumbUrl:%s, thumbPath:%s", new Object[] { localObject, paramIntent });
      if (bt.isNullOrNil((String)localObject)) {
        break label193;
      }
      et((String)localObject, "file://".concat(String.valueOf(paramIntent)));
    }
    for (;;)
    {
      this.kwW.alive();
      ad.i("MicroMsg.AppBrandThumbFromMMProxyUI", "AppBrandThumbFromMMProxyUI onCreate");
      AppMethodBeat.o(49326);
      return;
      label193:
      if (!bt.isNullOrNil(paramIntent)) {
        et("file://".concat(String.valueOf(paramIntent)), null);
      }
    }
  }
  
  public final AppBrandLaunchProxyUI bBS()
  {
    AppMethodBeat.i(49324);
    AppBrandLaunchProxyUI localAppBrandLaunchProxyUI = (AppBrandLaunchProxyUI)super.getBaseContext();
    AppMethodBeat.o(49324);
    return localAppBrandLaunchProxyUI;
  }
  
  public final boolean bsa()
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
          AppBrandLaunchProxyUI localAppBrandLaunchProxyUI = a.this.bBS();
          if ((localAppBrandLaunchProxyUI != null) && (!localAppBrandLaunchProxyUI.isFinishing()) && (!localAppBrandLaunchProxyUI.isDestroyed()))
          {
            ad.i("MicroMsg.AppBrandThumbFromMMProxyUI", "finish, baseContext:%s", new Object[] { localAppBrandLaunchProxyUI.getClass().getSimpleName() });
            if (a.a(a.this) != null)
            {
              ad.i("MicroMsg.AppBrandThumbFromMMProxyUI", "finish, make decorView invisible");
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
    ad.i("MicroMsg.AppBrandThumbFromMMProxyUI", "finish, no baseContext");
    AppMethodBeat.o(49325);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(49330);
    ad.i("MicroMsg.AppBrandThumbFromMMProxyUI", "AppBrandThumbFromMMProxyUI onDestroy");
    if (this.kwW != null) {
      this.kwW.dead();
    }
    if (this.mRx != null) {
      this.mRx.brV();
    }
    AppMethodBeat.o(49330);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(49329);
    ad.i("MicroMsg.AppBrandThumbFromMMProxyUI", "AppBrandThumbFromMMProxyUI onPause");
    AppMethodBeat.o(49329);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(49328);
    this.koW += 1;
    ad.i("MicroMsg.AppBrandThumbFromMMProxyUI", "AppBrandThumbFromMMProxyUI onResume, resume count:%d", new Object[] { Integer.valueOf(this.koW) });
    if (this.koW > 1)
    {
      ad.i("MicroMsg.AppBrandThumbFromMMProxyUI", "AppBrandThumbFromMMProxyUI onResume, finish when resume again");
      finish();
    }
    AppMethodBeat.o(49328);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ab.a
 * JD-Core Version:    0.7.0.1
 */