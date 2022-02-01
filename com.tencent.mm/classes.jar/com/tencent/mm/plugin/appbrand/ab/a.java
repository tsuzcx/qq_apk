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
import com.tencent.mm.plugin.appbrand.ui.r;
import com.tencent.mm.plugin.appbrand.z.l;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class a
  extends ContextWrapper
  implements g
{
  private int jUI;
  private c<f> kcx;
  private ImageView mqQ;
  private FrameLayout mqR;
  private d mqS;
  
  public a(AppBrandLaunchProxyUI paramAppBrandLaunchProxyUI)
  {
    super(paramAppBrandLaunchProxyUI);
    AppMethodBeat.i(49323);
    this.jUI = 0;
    this.kcx = new c() {};
    AppMethodBeat.o(49323);
  }
  
  private void ek(String paramString1, final String paramString2)
  {
    AppMethodBeat.i(49327);
    ac.i("MicroMsg.AppBrandThumbFromMMProxyUI", "loadThumbImage:%s", new Object[] { paramString1 });
    b.aAS().a(new b.k()
    {
      public final String Ap()
      {
        return "AppBrandThumbFromMMProxyUI#THUMB";
      }
      
      public final void E(Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(49321);
        ac.i("MicroMsg.AppBrandThumbFromMMProxyUI", "proxy thumb loaded");
        a.a(a.this, paramAnonymousBitmap);
        AppMethodBeat.o(49321);
      }
      
      public final void aBa() {}
      
      public final void of()
      {
        AppMethodBeat.i(49322);
        ac.e("MicroMsg.AppBrandThumbFromMMProxyUI", "proxy thumb loaded fail");
        if (paramString2 != null) {
          a.a(a.this, paramString2);
        }
        AppMethodBeat.o(49322);
      }
    }, paramString1, null, null);
    AppMethodBeat.o(49327);
  }
  
  public final void G(Intent paramIntent)
  {
    AppMethodBeat.i(49326);
    r.a(((AppBrandLaunchProxyUI)super.getBaseContext()).getWindow(), true, false);
    Object localObject = d.Oz(paramIntent.getStringExtra("extra_entry_token"));
    if (localObject == null)
    {
      finish();
      AppMethodBeat.o(49326);
      return;
    }
    ((d)localObject).setBaseContext((AppBrandLaunchProxyUI)super.getBaseContext());
    this.mqS = ((d)localObject);
    localObject = ((AppBrandLaunchProxyUI)super.getBaseContext()).getLayoutInflater().inflate(2131493006, null);
    this.mqR = ((FrameLayout)((View)localObject).findViewById(2131298739));
    this.mqQ = ((ImageView)((View)localObject).findViewById(2131305792));
    ((AppBrandLaunchProxyUI)super.getBaseContext()).setContentView((View)localObject);
    if (paramIntent != null)
    {
      localObject = paramIntent.getStringExtra("extra_launch_thumb_url");
      paramIntent = paramIntent.getStringExtra("extra_launch_thumb_path");
      ac.i("MicroMsg.AppBrandThumbFromMMProxyUI", "showLaunchThumb, thumbUrl:%s, thumbPath:%s", new Object[] { localObject, paramIntent });
      if (bs.isNullOrNil((String)localObject)) {
        break label193;
      }
      ek((String)localObject, "file://".concat(String.valueOf(paramIntent)));
    }
    for (;;)
    {
      this.kcx.alive();
      ac.i("MicroMsg.AppBrandThumbFromMMProxyUI", "AppBrandThumbFromMMProxyUI onCreate");
      AppMethodBeat.o(49326);
      return;
      label193:
      if (!bs.isNullOrNil(paramIntent)) {
        ek("file://".concat(String.valueOf(paramIntent)), null);
      }
    }
  }
  
  public final boolean boh()
  {
    return false;
  }
  
  public final AppBrandLaunchProxyUI bxN()
  {
    AppMethodBeat.i(49324);
    AppBrandLaunchProxyUI localAppBrandLaunchProxyUI = (AppBrandLaunchProxyUI)super.getBaseContext();
    AppMethodBeat.o(49324);
    return localAppBrandLaunchProxyUI;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(49325);
    if ((AppBrandLaunchProxyUI)super.getBaseContext() != null)
    {
      l.runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(49320);
          AppBrandLaunchProxyUI localAppBrandLaunchProxyUI = a.this.bxN();
          if ((localAppBrandLaunchProxyUI != null) && (!localAppBrandLaunchProxyUI.isFinishing()) && (!localAppBrandLaunchProxyUI.isDestroyed()))
          {
            ac.i("MicroMsg.AppBrandThumbFromMMProxyUI", "finish, baseContext:%s", new Object[] { localAppBrandLaunchProxyUI.getClass().getSimpleName() });
            if (a.a(a.this) != null)
            {
              ac.i("MicroMsg.AppBrandThumbFromMMProxyUI", "finish, make decorView invisible");
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
    ac.i("MicroMsg.AppBrandThumbFromMMProxyUI", "finish, no baseContext");
    AppMethodBeat.o(49325);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(49330);
    ac.i("MicroMsg.AppBrandThumbFromMMProxyUI", "AppBrandThumbFromMMProxyUI onDestroy");
    if (this.kcx != null) {
      this.kcx.dead();
    }
    if (this.mqS != null) {
      this.mqS.boc();
    }
    AppMethodBeat.o(49330);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(49329);
    ac.i("MicroMsg.AppBrandThumbFromMMProxyUI", "AppBrandThumbFromMMProxyUI onPause");
    AppMethodBeat.o(49329);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(49328);
    this.jUI += 1;
    ac.i("MicroMsg.AppBrandThumbFromMMProxyUI", "AppBrandThumbFromMMProxyUI onResume, resume count:%d", new Object[] { Integer.valueOf(this.jUI) });
    if (this.jUI > 1)
    {
      ac.i("MicroMsg.AppBrandThumbFromMMProxyUI", "AppBrandThumbFromMMProxyUI onResume, finish when resume again");
      finish();
    }
    AppMethodBeat.o(49328);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ab.a
 * JD-Core Version:    0.7.0.1
 */