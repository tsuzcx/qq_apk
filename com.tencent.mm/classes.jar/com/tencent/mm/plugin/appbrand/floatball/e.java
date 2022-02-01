package com.tencent.mm.plugin.appbrand.floatball;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.sdk.platformtools.ad;

public final class e
  extends com.tencent.mm.plugin.ball.a.e
{
  private o jpk;
  
  public e(Activity paramActivity, o paramo)
  {
    super(paramActivity);
    this.jpk = paramo;
  }
  
  public final boolean aVX()
  {
    return false;
  }
  
  public final boolean aWk()
  {
    AppMethodBeat.i(44979);
    if (this.jpk != null) {}
    for (boolean bool = this.jpk.CZ(); bool; bool = false)
    {
      AppMethodBeat.o(44979);
      return false;
    }
    bool = super.aWk();
    AppMethodBeat.o(44979);
    return bool;
  }
  
  public final void fF(boolean paramBoolean)
  {
    AppMethodBeat.i(44978);
    AppBrandUI localAppBrandUI;
    if (this.jpk != null) {
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
      localAppBrandUI.lCI = paramBoolean;
      this.jpk.aMW();
      AppMethodBeat.o(44978);
      return;
    }
  }
  
  public final Bitmap getBitmap()
  {
    AppMethodBeat.i(44977);
    try
    {
      if ((this.jpk != null) && (this.jpk.aNd() != null) && (this.jpk.aNd().getCurrentPage() != null) && (this.jpk.aNd().getCurrentPage().getCurrentPageView() != null))
      {
        Bitmap localBitmap1 = this.jpk.aNd().getCurrentPage().getCurrentPageView().bjW();
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
    if (this.jpk != null) {
      return this.jpk.iDA;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.floatball.e
 * JD-Core Version:    0.7.0.1
 */