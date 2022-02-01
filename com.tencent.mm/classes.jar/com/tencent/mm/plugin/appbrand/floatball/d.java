package com.tencent.mm.plugin.appbrand.floatball;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ak;
import com.tencent.mm.plugin.appbrand.ao;
import com.tencent.mm.plugin.appbrand.au;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.page.x;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.plugin.ball.a.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import java.util.concurrent.ConcurrentSkipListSet;

public class d
  extends e
{
  com.tencent.mm.plugin.appbrand.q lqE;
  
  public d(Activity paramActivity, com.tencent.mm.plugin.appbrand.q paramq)
  {
    super(paramActivity);
    AppMethodBeat.i(226544);
    this.lqE = paramq;
    paramActivity = this.lqE;
    paramq = new ao()
    {
      public final void b(ak paramAnonymousak)
      {
        AppMethodBeat.i(226543);
        d.this.activity = AndroidContextUtil.castActivityOrNull(d.this.lqE.mContext);
        AppMethodBeat.o(226543);
      }
      
      public final void btq()
      {
        d.this.activity = null;
      }
    };
    paramActivity.kAB.kFx.add(paramq);
    AppMethodBeat.o(226544);
  }
  
  public final boolean aGg()
  {
    return false;
  }
  
  public boolean bCI()
  {
    AppMethodBeat.i(44979);
    if (this.lqE != null) {}
    for (boolean bool = this.lqE.NA(); bool; bool = false)
    {
      AppMethodBeat.o(44979);
      return false;
    }
    if (com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q.qta.qtB)
    {
      AppMethodBeat.o(44979);
      return false;
    }
    bool = super.bCI();
    AppMethodBeat.o(44979);
    return bool;
  }
  
  public final Activity getActivity()
  {
    AppMethodBeat.i(226545);
    Activity localActivity = AndroidContextUtil.castActivityOrNull(this.lqE.mContext);
    AppMethodBeat.o(226545);
    return localActivity;
  }
  
  public final Bitmap getBitmap()
  {
    AppMethodBeat.i(44977);
    try
    {
      if ((this.lqE != null) && (this.lqE.bsD() != null) && (this.lqE.bsD().getCurrentPage() != null) && (this.lqE.bsD().getCurrentPage().getCurrentPageView() != null))
      {
        Bitmap localBitmap1 = this.lqE.bsD().getCurrentPage().getCurrentPageView().bRB();
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
    if (this.lqE != null) {
      return this.lqE.kAt;
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
  
  public final void hb(boolean paramBoolean)
  {
    AppMethodBeat.i(44978);
    AppBrandUI localAppBrandUI;
    if (this.lqE != null) {
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
      localAppBrandUI.nXd = paramBoolean;
      this.lqE.bsu();
      AppMethodBeat.o(44978);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.floatball.d
 * JD-Core Version:    0.7.0.1
 */