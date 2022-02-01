package com.tencent.mm.plugin.appbrand.q;

import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.ca;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.page.x;
import com.tencent.mm.plugin.appbrand.platform.window.e.b;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.plugin.appbrand.utils.ai;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.multitask.a.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import kotlin.g.b.p;

public final class d
  extends com.tencent.mm.plugin.multitask.a.b
{
  private q lqE;
  
  public d(Activity paramActivity, q paramq)
  {
    super(paramActivity);
    this.lqE = paramq;
  }
  
  public final void a(a.b paramb)
  {
    AppMethodBeat.i(227218);
    super.a(paramb);
    if ((ai.et(getActivity())) && (getActivity().getResources().getConfiguration().orientation != 2)) {
      ((ViewGroup)getContentView().getParent()).setBackground(null);
    }
    AppMethodBeat.o(227218);
  }
  
  public final void a(boolean paramBoolean, com.tencent.mm.plugin.multitask.b.b paramb)
  {
    AppMethodBeat.i(227216);
    if (this.lqE != null) {
      if ((getActivity() instanceof AppBrandUI))
      {
        paramb = (AppBrandUI)getActivity();
        if (paramBoolean) {
          break label54;
        }
      }
    }
    label54:
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramb.nXd = paramBoolean;
      this.lqE.bsu();
      AppMethodBeat.o(227216);
      return;
    }
  }
  
  public final boolean bCI()
  {
    AppMethodBeat.i(227217);
    if (this.lqE != null) {}
    for (boolean bool = this.lqE.NA(); bool; bool = false)
    {
      AppMethodBeat.o(227217);
      return false;
    }
    bool = super.bCI();
    AppMethodBeat.o(227217);
    return bool;
  }
  
  public final boolean bPv()
  {
    return true;
  }
  
  public final Activity getActivity()
  {
    AppMethodBeat.i(227213);
    Activity localActivity = AndroidContextUtil.castActivityOrNull(this.lqE.mContext);
    AppMethodBeat.o(227213);
    return localActivity;
  }
  
  public final Bitmap getBitmap()
  {
    AppMethodBeat.i(227215);
    Object localObject1 = com.tencent.mm.plugin.multitask.f.c.AgL;
    if (com.tencent.mm.plugin.multitask.f.c.Ss(1))
    {
      AppMethodBeat.o(227215);
      return null;
    }
    for (;;)
    {
      try
      {
        if ((this.lqE == null) || (this.lqE.bsD() == null) || (this.lqE.bsD().getCurrentPage() == null) || (this.lqE.bsD().getCurrentPage().getCurrentPageView() == null)) {
          continue;
        }
        localObject1 = this.lqE.bsD().getCurrentPage().getCurrentPageView().bRx();
        if (Util.isNullOrNil((String)localObject1)) {
          break label628;
        }
        Log.i("MicroMsg.AppBrandMultiTaskPageAdapter", "appBrandRuntime orientation:%s,isGame:%b", new Object[] { localObject1, Boolean.valueOf(this.lqE.NA()) });
        if ("auto".equals(localObject1)) {
          break label628;
        }
        if (!e.b.nEm.name().equalsIgnoreCase((String)localObject1)) {
          break label625;
        }
      }
      catch (Exception localException)
      {
        Object localObject4;
        Object localObject3;
        com.tencent.mm.plugin.appbrand.page.capsulebar.c localc;
        boolean bool;
        Log.printErrStackTrace("MicroMsg.AppBrandMultiTaskPageAdapter", localException, "appbrand getBitmap fail exception:%s", new Object[] { localException.getMessage() });
        localObject2 = super.getBitmap();
        AppMethodBeat.o(227215);
        return localObject2;
      }
      if (!this.lqE.NA())
      {
        localObject4 = this.lqE;
        if (((AppBrandRuntime)localObject4).kAx != null)
        {
          localObject3 = ((AppBrandRuntime)localObject4).kAx;
          if (((com.tencent.mm.plugin.appbrand.page.capsulebar.e)localObject3).nvh != null)
          {
            localc = ((com.tencent.mm.plugin.appbrand.page.capsulebar.e)localObject3).nvh;
            if (localc == null) {
              p.btv("capsuleBarContainerLayout");
            }
            ((com.tencent.mm.plugin.appbrand.page.capsulebar.e)localObject3).nvj = localc.getVisibility();
          }
          localObject3 = ((AppBrandRuntime)localObject4).kAx;
          if (((com.tencent.mm.plugin.appbrand.page.capsulebar.e)localObject3).nvh != null)
          {
            localObject3 = ((com.tencent.mm.plugin.appbrand.page.capsulebar.e)localObject3).nvh;
            if (localObject3 == null) {
              p.btv("capsuleBarContainerLayout");
            }
            ((com.tencent.mm.plugin.appbrand.page.capsulebar.c)localObject3).setVisibility(4);
          }
        }
        localObject3 = ca.cD(((AppBrandRuntime)localObject4).kAt);
        if (((AppBrandRuntime)localObject4).kAx != null)
        {
          localObject4 = ((AppBrandRuntime)localObject4).kAx;
          if (((com.tencent.mm.plugin.appbrand.page.capsulebar.e)localObject4).nvh != null)
          {
            localc = ((com.tencent.mm.plugin.appbrand.page.capsulebar.e)localObject4).nvh;
            if (localc == null) {
              p.btv("capsuleBarContainerLayout");
            }
            localc.setVisibility(((com.tencent.mm.plugin.appbrand.page.capsulebar.e)localObject4).nvj);
          }
        }
        if (localObject3 == null)
        {
          AppMethodBeat.o(227215);
          return null;
        }
      }
      else
      {
        if (((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rXY, 0) == 1)
        {
          bool = true;
          Log.i("MicroMsg.AppBrandMultiTaskPageAdapter", "closeGame:%b", new Object[] { Boolean.valueOf(bool) });
          if (bool)
          {
            AppMethodBeat.o(227215);
            return null;
          }
        }
        else
        {
          bool = false;
          continue;
        }
        localObject3 = this.lqE.bsz();
        if (localObject3 == null)
        {
          Log.w("MicroMsg.AppBrandMultiTaskPageAdapter", "current page view released");
          AppMethodBeat.o(227215);
          return null;
        }
        localObject3 = (com.tencent.luggage.game.page.d)((ac)localObject3).S(com.tencent.luggage.game.page.d.class);
        if ((localObject3 == null) || (((com.tencent.luggage.game.page.d)localObject3).MQ() == null))
        {
          Log.e("MicroMsg.AppBrandMultiTaskPageAdapter", "page is not game!");
          AppMethodBeat.o(227215);
          return null;
        }
        localObject3 = ((com.tencent.luggage.game.page.d)localObject3).MQ().getMagicBrush().cLA.h(((com.tencent.luggage.game.page.d)localObject3).MQ().getVirtualElementId(), -1, true);
        continue;
      }
      if ("portrait".equals(localObject1))
      {
        localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject3, (int)(((Bitmap)localObject3).getWidth() / 1.25F), (int)(((Bitmap)localObject3).getHeight() / 1.25F), true);
        ((Bitmap)localObject3).recycle();
        AppMethodBeat.o(227215);
        return localObject1;
      }
      localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject3, (int)(((Bitmap)localObject3).getWidth() / 1.25F), (int)(((Bitmap)localObject3).getHeight() / 1.25F), true);
      ((Bitmap)localObject3).recycle();
      localObject3 = new Matrix();
      ((Matrix)localObject3).postRotate(90.0F);
      localObject3 = Bitmap.createBitmap((Bitmap)localObject1, 0, 0, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight(), (Matrix)localObject3, true);
      ((Bitmap)localObject1).recycle();
      AppMethodBeat.o(227215);
      return localObject3;
      label625:
      continue;
      label628:
      Object localObject2 = "portrait";
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
    AppMethodBeat.i(227214);
    View localView = getContentView();
    AppMethodBeat.o(227214);
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.q.d
 * JD-Core Version:    0.7.0.1
 */