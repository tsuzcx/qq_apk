package com.tencent.mm.plugin.appbrand.floatball;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ap;
import com.tencent.mm.plugin.appbrand.au;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.page.y;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.service.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.AndroidContextUtil;

public class e
  extends com.tencent.mm.plugin.ball.a.e
{
  w roX;
  
  public e(Activity paramActivity, w paramw)
  {
    super(paramActivity);
    AppMethodBeat.i(318237);
    this.roX = paramw;
    this.roX.a(new au()
    {
      public final void b(ap paramAnonymousap)
      {
        AppMethodBeat.i(318298);
        e.a(e.this, AndroidContextUtil.castActivityOrNull(e.this.roX.mContext));
        AppMethodBeat.o(318298);
      }
      
      public final void cdx()
      {
        AppMethodBeat.i(318304);
        e.a(e.this);
        AppMethodBeat.o(318304);
      }
    });
    AppMethodBeat.o(318237);
  }
  
  public final boolean bhU()
  {
    return false;
  }
  
  public boolean cor()
  {
    AppMethodBeat.i(44979);
    if (this.roX != null) {}
    for (boolean bool = this.roX.aqJ(); bool; bool = false)
    {
      AppMethodBeat.o(44979);
      return false;
    }
    if (q.wVc.wVE)
    {
      AppMethodBeat.o(44979);
      return false;
    }
    bool = super.cor();
    AppMethodBeat.o(44979);
    return bool;
  }
  
  public final Activity getActivity()
  {
    AppMethodBeat.i(318280);
    Activity localActivity = AndroidContextUtil.castActivityOrNull(this.roX.mContext);
    AppMethodBeat.o(318280);
    return localActivity;
  }
  
  public final Bitmap getBitmap()
  {
    AppMethodBeat.i(44977);
    try
    {
      if ((this.roX != null) && (this.roX.ccN() != null) && (this.roX.ccN().getCurrentPage() != null) && (this.roX.ccN().getCurrentPage().getCurrentPageView() != null))
      {
        Bitmap localBitmap1 = this.roX.ccN().getCurrentPage().getCurrentPageView().cEW();
        AppMethodBeat.o(44977);
        return localBitmap1;
      }
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.AppBrandFloatBallPageAdapter", localException, "appbrand getBitmap fail exception:%s", new Object[] { localException.getMessage() });
      Bitmap localBitmap2 = super.getBitmap();
      AppMethodBeat.o(44977);
      return localBitmap2;
    }
  }
  
  public final View getContentView()
  {
    if (this.roX != null) {
      return this.roX.qsk;
    }
    return null;
  }
  
  public final View getMaskView()
  {
    AppMethodBeat.i(44976);
    View localView = getContentView();
    AppMethodBeat.o(44976);
    return localView;
  }
  
  public final void iR(boolean paramBoolean)
  {
    AppMethodBeat.i(44978);
    AppBrandUI localAppBrandUI;
    if (this.roX != null) {
      if ((getActivity() instanceof AppBrandUI))
      {
        localAppBrandUI = (AppBrandUI)getActivity();
        if (paramBoolean) {
          break label54;
        }
      }
    }
    label54:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localAppBrandUI.ueC = paramBoolean;
      this.roX.ccD();
      AppMethodBeat.o(44978);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.floatball.e
 * JD-Core Version:    0.7.0.1
 */