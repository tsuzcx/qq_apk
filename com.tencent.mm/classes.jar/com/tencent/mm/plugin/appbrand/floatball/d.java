package com.tencent.mm.plugin.appbrand.floatball;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ak;
import com.tencent.mm.plugin.appbrand.ap;
import com.tencent.mm.plugin.appbrand.aw;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.page.y;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.plugin.ball.a.e;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import java.util.concurrent.ConcurrentSkipListSet;

public class d
  extends e
{
  t olo;
  
  public d(Activity paramActivity, t paramt)
  {
    super(paramActivity);
    AppMethodBeat.i(272791);
    this.olo = paramt;
    paramActivity = this.olo;
    paramt = new ap()
    {
      public final void b(ak paramAnonymousak)
      {
        AppMethodBeat.i(282500);
        d.a(d.this, AndroidContextUtil.castActivityOrNull(d.this.olo.mContext));
        AppMethodBeat.o(282500);
      }
      
      public final void bEn()
      {
        AppMethodBeat.i(282501);
        d.a(d.this);
        AppMethodBeat.o(282501);
      }
    };
    paramActivity.ntL.nzd.add(paramt);
    AppMethodBeat.o(272791);
  }
  
  public final boolean aOg()
  {
    return false;
  }
  
  public boolean bOd()
  {
    AppMethodBeat.i(44979);
    if (this.olo != null) {}
    for (boolean bool = this.olo.Qv(); bool; bool = false)
    {
      AppMethodBeat.o(44979);
      return false;
    }
    if (q.tRM.tSn)
    {
      AppMethodBeat.o(44979);
      return false;
    }
    bool = super.bOd();
    AppMethodBeat.o(44979);
    return bool;
  }
  
  public final Activity getActivity()
  {
    AppMethodBeat.i(272792);
    Activity localActivity = AndroidContextUtil.castActivityOrNull(this.olo.mContext);
    AppMethodBeat.o(272792);
    return localActivity;
  }
  
  public final Bitmap getBitmap()
  {
    AppMethodBeat.i(44977);
    try
    {
      if ((this.olo != null) && (this.olo.bDz() != null) && (this.olo.bDz().getCurrentPage() != null) && (this.olo.bDz().getCurrentPage().getCurrentPageView() != null))
      {
        Bitmap localBitmap1 = this.olo.bDz().getCurrentPage().getCurrentPageView().ces();
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
    if (this.olo != null) {
      return this.olo.ntC;
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
  
  public final void hS(boolean paramBoolean)
  {
    AppMethodBeat.i(44978);
    AppBrandUI localAppBrandUI;
    if (this.olo != null) {
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
      localAppBrandUI.qYD = paramBoolean;
      this.olo.bDo();
      AppMethodBeat.o(44978);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.floatball.d
 * JD-Core Version:    0.7.0.1
 */