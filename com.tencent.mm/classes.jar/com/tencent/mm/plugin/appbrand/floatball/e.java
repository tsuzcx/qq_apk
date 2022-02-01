package com.tencent.mm.plugin.appbrand.floatball;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.r;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.p;
import com.tencent.mm.sdk.platformtools.ad;

public class e
  extends com.tencent.mm.plugin.ball.a.e
{
  private o kjH;
  
  public e(Activity paramActivity, o paramo)
  {
    super(paramActivity);
    this.kjH = paramo;
  }
  
  public boolean bgM()
  {
    AppMethodBeat.i(44979);
    if (this.kjH != null) {}
    for (boolean bool = this.kjH.Eb(); bool; bool = false)
    {
      AppMethodBeat.o(44979);
      return false;
    }
    if (p.oXv.oXV)
    {
      AppMethodBeat.o(44979);
      return false;
    }
    bool = super.bgM();
    AppMethodBeat.o(44979);
    return bool;
  }
  
  public final boolean bgz()
  {
    return false;
  }
  
  public final Bitmap getBitmap()
  {
    AppMethodBeat.i(44977);
    try
    {
      if ((this.kjH != null) && (this.kjH.aXd() != null) && (this.kjH.aXd().getCurrentPage() != null) && (this.kjH.aXd().getCurrentPage().getCurrentPageView() != null))
      {
        Bitmap localBitmap1 = this.kjH.aXd().getCurrentPage().getCurrentPageView().buN();
        AppMethodBeat.o(44977);
        return localBitmap1;
      }
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.AppBrandFloatBallPageAdapter", localException, "appbrand getBitmap fail exception:%s", new Object[] { localException.getMessage() });
      Bitmap localBitmap2 = super.getBitmap();
      AppMethodBeat.o(44977);
      return localBitmap2;
    }
  }
  
  public final View getContentView()
  {
    if (this.kjH != null) {
      return this.kjH.jwJ;
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
  
  public final void gg(boolean paramBoolean)
  {
    AppMethodBeat.i(44978);
    AppBrandUI localAppBrandUI;
    if (this.kjH != null) {
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
      localAppBrandUI.mEV = paramBoolean;
      this.kjH.aWW();
      AppMethodBeat.o(44978);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.floatball.e
 * JD-Core Version:    0.7.0.1
 */