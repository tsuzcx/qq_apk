package com.tencent.mm.plugin.appbrand.weishi;

import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.a.b.i;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.launching.precondition.d;
import com.tencent.mm.plugin.appbrand.launching.precondition.g;
import com.tencent.mm.plugin.appbrand.ui.o;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class a
  extends ContextWrapper
  implements g
{
  private c<f> hCx;
  private int hvP;
  private ImageView jab;
  
  public a(AppBrandLaunchProxyUI paramAppBrandLaunchProxyUI)
  {
    super(paramAppBrandLaunchProxyUI);
    AppMethodBeat.i(133613);
    this.hvP = 0;
    this.hCx = new a.1(this);
    AppMethodBeat.o(133613);
  }
  
  private void cX(String paramString1, final String paramString2)
  {
    AppMethodBeat.i(133616);
    ab.i("MicroMsg.AppBrandThumbFromMMProxyUI", "loadThumbImage:%s", new Object[] { paramString1 });
    b.acD().a(new b.i()
    {
      public final void acG() {}
      
      public final void acH()
      {
        AppMethodBeat.i(133612);
        ab.e("MicroMsg.AppBrandThumbFromMMProxyUI", "proxy thumb loaded fail");
        if (paramString2 != null) {
          a.a(a.this, paramString2);
        }
        AppMethodBeat.o(133612);
      }
      
      public final String tX()
      {
        return "AppBrandThumbFromMMProxyUI#THUMB";
      }
      
      public final void w(Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(133611);
        ab.i("MicroMsg.AppBrandThumbFromMMProxyUI", "proxy thumb loaded");
        a.a(a.this, paramAnonymousBitmap);
        AppMethodBeat.o(133611);
      }
    }, paramString1, null, null);
    AppMethodBeat.o(133616);
  }
  
  public final void F(Intent paramIntent)
  {
    AppMethodBeat.i(133615);
    o.c(((AppBrandLaunchProxyUI)super.getBaseContext()).getWindow(), true);
    Object localObject = ((AppBrandLaunchProxyUI)super.getBaseContext()).getLayoutInflater().inflate(2130968693, null);
    this.jab = ((ImageView)((View)localObject).findViewById(2131821245));
    ((AppBrandLaunchProxyUI)super.getBaseContext()).setContentView((View)localObject);
    localObject = d.Dr(paramIntent.getStringExtra("extra_entry_token"));
    if (localObject == null)
    {
      finish();
      AppMethodBeat.o(133615);
      return;
    }
    ((d)localObject).setBaseContext((AppBrandLaunchProxyUI)super.getBaseContext());
    if (paramIntent != null)
    {
      localObject = paramIntent.getStringExtra("extra_launch_thumb_url");
      paramIntent = paramIntent.getStringExtra("extra_launch_thumb_path");
      ab.i("MicroMsg.AppBrandThumbFromMMProxyUI", "showLaunchThumb, thumbUrl:%s, thumbPath:%s", new Object[] { localObject, paramIntent });
      if (bo.isNullOrNil((String)localObject)) {
        break label170;
      }
      cX((String)localObject, "file://".concat(String.valueOf(paramIntent)));
    }
    for (;;)
    {
      com.tencent.mm.sdk.b.a.ymk.b(this.hCx);
      AppMethodBeat.o(133615);
      return;
      label170:
      if (!bo.isNullOrNil(paramIntent)) {
        cX("file://".concat(String.valueOf(paramIntent)), null);
      }
    }
  }
  
  public final boolean aHw()
  {
    return false;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(133614);
    if (((AppBrandLaunchProxyUI)super.getBaseContext() != null) && (!((AppBrandLaunchProxyUI)super.getBaseContext()).isFinishing())) {
      ((AppBrandLaunchProxyUI)super.getBaseContext()).finish();
    }
    AppMethodBeat.o(133614);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(133619);
    ab.i("MicroMsg.AppBrandThumbFromMMProxyUI", "onDestroy");
    AppMethodBeat.o(133619);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(133618);
    ab.i("MicroMsg.AppBrandThumbFromMMProxyUI", "onPause");
    AppMethodBeat.o(133618);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(133617);
    this.hvP += 1;
    ab.i("MicroMsg.AppBrandThumbFromMMProxyUI", "onResume, resume count:%d", new Object[] { Integer.valueOf(this.hvP) });
    if (this.hvP > 1)
    {
      ab.i("MicroMsg.AppBrandThumbFromMMProxyUI", "onResume, finish when resume again");
      finish();
    }
    AppMethodBeat.o(133617);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.weishi.a
 * JD-Core Version:    0.7.0.1
 */