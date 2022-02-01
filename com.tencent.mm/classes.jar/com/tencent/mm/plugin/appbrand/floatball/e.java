package com.tencent.mm.plugin.appbrand.floatball;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.sdk.platformtools.ae;

public class e
  extends com.tencent.mm.plugin.ball.a.e
{
  private com.tencent.mm.plugin.appbrand.p kmX;
  
  public e(Activity paramActivity, com.tencent.mm.plugin.appbrand.p paramp)
  {
    super(paramActivity);
    this.kmX = paramp;
  }
  
  public final boolean bhh()
  {
    return false;
  }
  
  public boolean bhu()
  {
    AppMethodBeat.i(44979);
    if (this.kmX != null) {}
    for (boolean bool = this.kmX.Ee(); bool; bool = false)
    {
      AppMethodBeat.o(44979);
      return false;
    }
    if (com.tencent.mm.plugin.cloudvoip.cloudvoice.d.p.pdY.pey)
    {
      AppMethodBeat.o(44979);
      return false;
    }
    bool = super.bhu();
    AppMethodBeat.o(44979);
    return bool;
  }
  
  public final void ge(boolean paramBoolean)
  {
    AppMethodBeat.i(44978);
    AppBrandUI localAppBrandUI;
    if (this.kmX != null) {
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
      localAppBrandUI.mKa = paramBoolean;
      this.kmX.aXr();
      AppMethodBeat.o(44978);
      return;
    }
  }
  
  public final Bitmap getBitmap()
  {
    AppMethodBeat.i(44977);
    try
    {
      if ((this.kmX != null) && (this.kmX.aXy() != null) && (this.kmX.aXy().getCurrentPage() != null) && (this.kmX.aXy().getCurrentPage().getCurrentPageView() != null))
      {
        Bitmap localBitmap1 = this.kmX.aXy().getCurrentPage().getCurrentPageView().bvz();
        AppMethodBeat.o(44977);
        return localBitmap1;
      }
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.AppBrandFloatBallPageAdapter", localException, "appbrand getBitmap fail exception:%s", new Object[] { localException.getMessage() });
      Bitmap localBitmap2 = super.getBitmap();
      AppMethodBeat.o(44977);
      return localBitmap2;
    }
  }
  
  public final View getContentView()
  {
    if (this.kmX != null) {
      return this.kmX.jzF;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.floatball.e
 * JD-Core Version:    0.7.0.1
 */