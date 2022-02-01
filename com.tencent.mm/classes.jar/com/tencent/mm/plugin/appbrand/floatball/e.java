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
import com.tencent.mm.sdk.platformtools.ac;

public class e
  extends com.tencent.mm.plugin.ball.a.e
{
  private o jPx;
  
  public e(Activity paramActivity, o paramo)
  {
    super(paramActivity);
    this.jPx = paramo;
  }
  
  public final boolean bcV()
  {
    return false;
  }
  
  public boolean bdi()
  {
    AppMethodBeat.i(44979);
    if (this.jPx != null) {}
    for (boolean bool = this.jPx.CC(); bool; bool = false)
    {
      AppMethodBeat.o(44979);
      return false;
    }
    if (p.otZ.ouA)
    {
      AppMethodBeat.o(44979);
      return false;
    }
    bool = super.bdi();
    AppMethodBeat.o(44979);
    return bool;
  }
  
  public final void gb(boolean paramBoolean)
  {
    AppMethodBeat.i(44978);
    AppBrandUI localAppBrandUI;
    if (this.jPx != null) {
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
      localAppBrandUI.meC = paramBoolean;
      this.jPx.aTM();
      AppMethodBeat.o(44978);
      return;
    }
  }
  
  public final Bitmap getBitmap()
  {
    AppMethodBeat.i(44977);
    try
    {
      if ((this.jPx != null) && (this.jPx.aTT() != null) && (this.jPx.aTT().getCurrentPage() != null) && (this.jPx.aTT().getCurrentPage().getCurrentPageView() != null))
      {
        Bitmap localBitmap1 = this.jPx.aTT().getCurrentPage().getCurrentPageView().bqN();
        AppMethodBeat.o(44977);
        return localBitmap1;
      }
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.AppBrandFloatBallPageAdapter", localException, "appbrand getBitmap fail exception:%s", new Object[] { localException.getMessage() });
      Bitmap localBitmap2 = super.getBitmap();
      AppMethodBeat.o(44977);
      return localBitmap2;
    }
  }
  
  public final View getContentView()
  {
    if (this.jPx != null) {
      return this.jPx.jdA;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.floatball.e
 * JD-Core Version:    0.7.0.1
 */