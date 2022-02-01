package com.tencent.mm.plugin.appbrand.af;

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
import com.tencent.mm.plugin.appbrand.ac.m;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.launching.e.d;
import com.tencent.mm.plugin.appbrand.launching.e.g;
import com.tencent.mm.plugin.appbrand.ui.y;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class a
  extends ContextWrapper
  implements g
{
  private FrameLayout cIL;
  private IListener<f> lEE;
  private int lvW;
  private ImageView ojE;
  private d ojF;
  
  public a(AppBrandLaunchProxyUI paramAppBrandLaunchProxyUI)
  {
    super(paramAppBrandLaunchProxyUI);
    AppMethodBeat.i(49323);
    this.lvW = 0;
    this.lEE = new IListener() {};
    AppMethodBeat.o(49323);
  }
  
  private void eO(String paramString1, final String paramString2)
  {
    AppMethodBeat.i(49327);
    Log.i("MicroMsg.AppBrandThumbFromMMProxyUI", "loadThumbImage:%s", new Object[] { paramString1 });
    b.aXY().a(new b.k()
    {
      public final void I(Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(49321);
        Log.i("MicroMsg.AppBrandThumbFromMMProxyUI", "proxy thumb loaded");
        a.a(a.this, paramAnonymousBitmap);
        AppMethodBeat.o(49321);
      }
      
      public final String Lb()
      {
        return "AppBrandThumbFromMMProxyUI#THUMB";
      }
      
      public final void aYg() {}
      
      public final void oD()
      {
        AppMethodBeat.i(49322);
        Log.e("MicroMsg.AppBrandThumbFromMMProxyUI", "proxy thumb loaded fail");
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
    y.a(((AppBrandLaunchProxyUI)super.getBaseContext()).getWindow(), true, false);
    Object localObject = d.acl(paramIntent.getStringExtra("extra_entry_token"));
    if (localObject == null)
    {
      finish();
      AppMethodBeat.o(49326);
      return;
    }
    ((d)localObject).setBaseContext((AppBrandLaunchProxyUI)super.getBaseContext());
    this.ojF = ((d)localObject);
    localObject = ((AppBrandLaunchProxyUI)super.getBaseContext()).getLayoutInflater().inflate(2131493044, null);
    this.cIL = ((FrameLayout)((View)localObject).findViewById(2131299180));
    this.ojE = ((ImageView)((View)localObject).findViewById(2131309067));
    ((AppBrandLaunchProxyUI)super.getBaseContext()).setContentView((View)localObject);
    if (paramIntent != null)
    {
      localObject = paramIntent.getStringExtra("extra_launch_thumb_url");
      paramIntent = paramIntent.getStringExtra("extra_launch_thumb_path");
      Log.i("MicroMsg.AppBrandThumbFromMMProxyUI", "showLaunchThumb, thumbUrl:%s, thumbPath:%s", new Object[] { localObject, paramIntent });
      if (Util.isNullOrNil((String)localObject)) {
        break label193;
      }
      eO((String)localObject, "file://".concat(String.valueOf(paramIntent)));
    }
    for (;;)
    {
      this.lEE.alive();
      Log.i("MicroMsg.AppBrandThumbFromMMProxyUI", "AppBrandThumbFromMMProxyUI onCreate");
      AppMethodBeat.o(49326);
      return;
      label193:
      if (!Util.isNullOrNil(paramIntent)) {
        eO("file://".concat(String.valueOf(paramIntent)), null);
      }
    }
  }
  
  public final boolean bOi()
  {
    return false;
  }
  
  public final AppBrandLaunchProxyUI bZP()
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
      m.runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(49320);
          AppBrandLaunchProxyUI localAppBrandLaunchProxyUI = a.this.bZP();
          if ((localAppBrandLaunchProxyUI != null) && (!localAppBrandLaunchProxyUI.isFinishing()) && (!localAppBrandLaunchProxyUI.isDestroyed()))
          {
            Log.i("MicroMsg.AppBrandThumbFromMMProxyUI", "finish, baseContext:%s", new Object[] { localAppBrandLaunchProxyUI.getClass().getSimpleName() });
            if (a.a(a.this) != null)
            {
              Log.i("MicroMsg.AppBrandThumbFromMMProxyUI", "finish, make decorView invisible");
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
    Log.i("MicroMsg.AppBrandThumbFromMMProxyUI", "finish, no baseContext");
    AppMethodBeat.o(49325);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(49330);
    Log.i("MicroMsg.AppBrandThumbFromMMProxyUI", "AppBrandThumbFromMMProxyUI onDestroy");
    if (this.lEE != null) {
      this.lEE.dead();
    }
    if (this.ojF != null) {
      this.ojF.bOc();
    }
    AppMethodBeat.o(49330);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(49329);
    Log.i("MicroMsg.AppBrandThumbFromMMProxyUI", "AppBrandThumbFromMMProxyUI onPause");
    AppMethodBeat.o(49329);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(49328);
    this.lvW += 1;
    Log.i("MicroMsg.AppBrandThumbFromMMProxyUI", "AppBrandThumbFromMMProxyUI onResume, resume count:%d", new Object[] { Integer.valueOf(this.lvW) });
    if (this.lvW > 1)
    {
      Log.i("MicroMsg.AppBrandThumbFromMMProxyUI", "AppBrandThumbFromMMProxyUI onResume, finish when resume again");
      finish();
    }
    AppMethodBeat.o(49328);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.af.a
 * JD-Core Version:    0.7.0.1
 */