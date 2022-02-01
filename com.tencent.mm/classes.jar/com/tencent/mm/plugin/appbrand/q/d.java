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
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.cd;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.page.y;
import com.tencent.mm.plugin.appbrand.platform.window.e.b;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.plugin.appbrand.utils.x;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.multitask.a.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import kotlin.g.b.p;

public final class d
  extends com.tencent.mm.plugin.multitask.a.b
{
  private final t olo;
  
  public d(t paramt)
  {
    super(null);
    this.olo = paramt;
  }
  
  public final void a(a.b paramb)
  {
    AppMethodBeat.i(281612);
    super.a(paramb);
    if ((x.es(getActivity())) && (getActivity().getResources().getConfiguration().orientation != 2)) {
      ((ViewGroup)getContentView().getParent()).setBackground(null);
    }
    AppMethodBeat.o(281612);
  }
  
  public final void a(boolean paramBoolean, com.tencent.mm.plugin.multitask.b.b paramb)
  {
    AppMethodBeat.i(281610);
    if (this.olo != null) {
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
      paramb.qYD = paramBoolean;
      this.olo.bDo();
      AppMethodBeat.o(281610);
      return;
    }
  }
  
  public final boolean bOd()
  {
    AppMethodBeat.i(281611);
    if (this.olo != null) {}
    for (boolean bool = this.olo.Qv(); bool; bool = false)
    {
      AppMethodBeat.o(281611);
      return false;
    }
    bool = super.bOd();
    AppMethodBeat.o(281611);
    return bool;
  }
  
  public final boolean cbM()
  {
    return true;
  }
  
  public final Activity getActivity()
  {
    AppMethodBeat.i(281604);
    Activity localActivity = AndroidContextUtil.castActivityOrNull(this.olo.mContext);
    AppMethodBeat.o(281604);
    return localActivity;
  }
  
  public final Bitmap getBitmap()
  {
    AppMethodBeat.i(281609);
    Object localObject1 = com.tencent.mm.plugin.multitask.f.c.FNB;
    if (com.tencent.mm.plugin.multitask.f.c.YO(1))
    {
      AppMethodBeat.o(281609);
      return null;
    }
    for (;;)
    {
      try
      {
        if ((this.olo == null) || (this.olo.bDz() == null) || (this.olo.bDz().getCurrentPage() == null) || (this.olo.bDz().getCurrentPage().getCurrentPageView() == null)) {
          continue;
        }
        localObject1 = this.olo.bDz().getCurrentPage().getCurrentPageView().ceo();
        if (Util.isNullOrNil((String)localObject1)) {
          break label628;
        }
        Log.i("MicroMsg.AppBrandMultiTaskPageAdapter", "appBrandRuntime orientation:%s,isGame:%b", new Object[] { localObject1, Boolean.valueOf(this.olo.Qv()) });
        if ("auto".equals(localObject1)) {
          break label628;
        }
        if (!e.b.qGw.name().equalsIgnoreCase((String)localObject1)) {
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
        AppMethodBeat.o(281609);
        return localObject2;
      }
      if (!this.olo.Qv())
      {
        localObject4 = this.olo;
        if (((AppBrandRuntime)localObject4).ntG != null)
        {
          localObject3 = ((AppBrandRuntime)localObject4).ntG;
          if (((com.tencent.mm.plugin.appbrand.page.capsulebar.e)localObject3).qxd != null)
          {
            localc = ((com.tencent.mm.plugin.appbrand.page.capsulebar.e)localObject3).qxd;
            if (localc == null) {
              p.bGy("capsuleBarContainerLayout");
            }
            ((com.tencent.mm.plugin.appbrand.page.capsulebar.e)localObject3).qxf = localc.getVisibility();
          }
          localObject3 = ((AppBrandRuntime)localObject4).ntG;
          if (((com.tencent.mm.plugin.appbrand.page.capsulebar.e)localObject3).qxd != null)
          {
            localObject3 = ((com.tencent.mm.plugin.appbrand.page.capsulebar.e)localObject3).qxd;
            if (localObject3 == null) {
              p.bGy("capsuleBarContainerLayout");
            }
            ((com.tencent.mm.plugin.appbrand.page.capsulebar.c)localObject3).setVisibility(4);
          }
        }
        localObject3 = cd.cW(((AppBrandRuntime)localObject4).ntC);
        if (((AppBrandRuntime)localObject4).ntG != null)
        {
          localObject4 = ((AppBrandRuntime)localObject4).ntG;
          if (((com.tencent.mm.plugin.appbrand.page.capsulebar.e)localObject4).qxd != null)
          {
            localc = ((com.tencent.mm.plugin.appbrand.page.capsulebar.e)localObject4).qxd;
            if (localc == null) {
              p.bGy("capsuleBarContainerLayout");
            }
            localc.setVisibility(((com.tencent.mm.plugin.appbrand.page.capsulebar.e)localObject4).qxf);
          }
        }
        if (localObject3 == null)
        {
          AppMethodBeat.o(281609);
          return null;
        }
      }
      else
      {
        if (((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vEO, 0) == 1)
        {
          bool = true;
          Log.i("MicroMsg.AppBrandMultiTaskPageAdapter", "closeGame:%b", new Object[] { Boolean.valueOf(bool) });
          if (bool)
          {
            AppMethodBeat.o(281609);
            return null;
          }
        }
        else
        {
          bool = false;
          continue;
        }
        localObject3 = this.olo.bDv();
        if (localObject3 == null)
        {
          Log.w("MicroMsg.AppBrandMultiTaskPageAdapter", "current page view released");
          AppMethodBeat.o(281609);
          return null;
        }
        localObject3 = (com.tencent.luggage.game.page.d)((ad)localObject3).R(com.tencent.luggage.game.page.d.class);
        if ((localObject3 == null) || (((com.tencent.luggage.game.page.d)localObject3).PI() == null))
        {
          Log.e("MicroMsg.AppBrandMultiTaskPageAdapter", "page is not game!");
          AppMethodBeat.o(281609);
          return null;
        }
        localObject3 = ((com.tencent.luggage.game.page.d)localObject3).PI().getMagicBrush().cMk.j(((com.tencent.luggage.game.page.d)localObject3).PI().getVirtualElementId(), -1, true);
        continue;
      }
      if ("portrait".equals(localObject1))
      {
        localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject3, (int)(((Bitmap)localObject3).getWidth() / 1.25F), (int)(((Bitmap)localObject3).getHeight() / 1.25F), true);
        ((Bitmap)localObject3).recycle();
        AppMethodBeat.o(281609);
        return localObject1;
      }
      localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject3, (int)(((Bitmap)localObject3).getWidth() / 1.25F), (int)(((Bitmap)localObject3).getHeight() / 1.25F), true);
      ((Bitmap)localObject3).recycle();
      localObject3 = new Matrix();
      ((Matrix)localObject3).postRotate(90.0F);
      localObject3 = Bitmap.createBitmap((Bitmap)localObject1, 0, 0, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight(), (Matrix)localObject3, true);
      ((Bitmap)localObject1).recycle();
      AppMethodBeat.o(281609);
      return localObject3;
      label625:
      continue;
      label628:
      Object localObject2 = "portrait";
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
    AppMethodBeat.i(281605);
    View localView = getContentView();
    AppMethodBeat.o(281605);
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.q.d
 * JD-Core Version:    0.7.0.1
 */