package com.tencent.mm.plugin.appbrand.r;

import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.magicbrush.e;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.page.y;
import com.tencent.mm.plugin.appbrand.platform.window.e.b;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.plugin.appbrand.utils.ac;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.multitask.a.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidContextUtil;

public final class d
  extends com.tencent.mm.plugin.multitask.a.b
{
  private final w roX;
  
  public d(w paramw)
  {
    super(null);
    this.roX = paramw;
  }
  
  public final void a(a.b paramb)
  {
    AppMethodBeat.i(317629);
    super.a(paramb);
    if ((ac.fo(getActivity())) && (getActivity().getResources().getConfiguration().orientation != 2)) {
      ((ViewGroup)getContentView().getParent()).setBackground(null);
    }
    AppMethodBeat.o(317629);
  }
  
  public final void a(boolean paramBoolean, com.tencent.mm.plugin.multitask.b.b paramb)
  {
    AppMethodBeat.i(317626);
    if (this.roX != null) {
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
      paramb.ueC = paramBoolean;
      this.roX.ccD();
      AppMethodBeat.o(317626);
      return;
    }
  }
  
  public final boolean cCf()
  {
    return true;
  }
  
  public final boolean cor()
  {
    AppMethodBeat.i(317627);
    if (this.roX != null) {}
    for (boolean bool = this.roX.aqJ(); bool; bool = false)
    {
      AppMethodBeat.o(317627);
      return false;
    }
    bool = super.cor();
    AppMethodBeat.o(317627);
    return bool;
  }
  
  public final Activity getActivity()
  {
    AppMethodBeat.i(317612);
    Activity localActivity = AndroidContextUtil.castActivityOrNull(this.roX.mContext);
    AppMethodBeat.o(317612);
    return localActivity;
  }
  
  public final Bitmap getBitmap()
  {
    AppMethodBeat.i(317625);
    Object localObject1 = com.tencent.mm.plugin.multitask.f.c.LIw;
    if (com.tencent.mm.plugin.multitask.f.c.ada(1))
    {
      AppMethodBeat.o(317625);
      return null;
    }
    for (;;)
    {
      try
      {
        if ((this.roX == null) || (this.roX.ccN() == null) || (this.roX.ccN().getCurrentPage() == null) || (this.roX.ccN().getCurrentPage().getCurrentPageView() == null)) {
          continue;
        }
        localObject1 = this.roX.ccN().getCurrentPage().getCurrentPageView().cES();
        if (Util.isNullOrNil((String)localObject1)) {
          break label482;
        }
        Log.i("MicroMsg.AppBrandMultiTaskPageAdapter", "appBrandRuntime orientation:%s,isGame:%b", new Object[] { localObject1, Boolean.valueOf(this.roX.aqJ()) });
        if ("auto".equals(localObject1)) {
          break label482;
        }
        if (!e.b.tLi.name().equalsIgnoreCase((String)localObject1)) {
          break label479;
        }
      }
      catch (Exception localException)
      {
        Object localObject3;
        boolean bool;
        Log.printErrStackTrace("MicroMsg.AppBrandMultiTaskPageAdapter", localException, "appbrand getBitmap fail exception:%s", new Object[] { localException.getMessage() });
        localObject2 = super.getBitmap();
        AppMethodBeat.o(317625);
        return localObject2;
      }
      if (!this.roX.aqJ())
      {
        localObject3 = this.roX.ccY();
        if (localObject3 == null)
        {
          AppMethodBeat.o(317625);
          return null;
        }
      }
      else
      {
        if (((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yUj, 0) == 1)
        {
          bool = true;
          Log.i("MicroMsg.AppBrandMultiTaskPageAdapter", "closeGame:%b", new Object[] { Boolean.valueOf(bool) });
          if (bool)
          {
            AppMethodBeat.o(317625);
            return null;
          }
        }
        else
        {
          bool = false;
          continue;
        }
        localObject3 = this.roX.ccK();
        if (localObject3 == null)
        {
          Log.w("MicroMsg.AppBrandMultiTaskPageAdapter", "current page view released");
          AppMethodBeat.o(317625);
          return null;
        }
        localObject3 = (com.tencent.luggage.game.page.d)((ad)localObject3).aa(com.tencent.luggage.game.page.d.class);
        if ((localObject3 == null) || (((com.tencent.luggage.game.page.d)localObject3).apS() == null))
        {
          Log.e("MicroMsg.AppBrandMultiTaskPageAdapter", "page is not game!");
          AppMethodBeat.o(317625);
          return null;
        }
        localObject3 = ((com.tencent.luggage.game.page.d)localObject3).apS().getMagicBrush().eHE.j(((com.tencent.luggage.game.page.d)localObject3).apS().getVirtualElementId(), -1, true);
        continue;
      }
      if ("portrait".equals(localObject1))
      {
        localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject3, (int)(((Bitmap)localObject3).getWidth() / 1.25F), (int)(((Bitmap)localObject3).getHeight() / 1.25F), true);
        ((Bitmap)localObject3).recycle();
        AppMethodBeat.o(317625);
        return localObject1;
      }
      localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject3, (int)(((Bitmap)localObject3).getWidth() / 1.25F), (int)(((Bitmap)localObject3).getHeight() / 1.25F), true);
      ((Bitmap)localObject3).recycle();
      localObject3 = new Matrix();
      ((Matrix)localObject3).postRotate(90.0F);
      localObject3 = Bitmap.createBitmap((Bitmap)localObject1, 0, 0, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight(), (Matrix)localObject3, true);
      ((Bitmap)localObject1).recycle();
      AppMethodBeat.o(317625);
      return localObject3;
      label479:
      continue;
      label482:
      Object localObject2 = "portrait";
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
    AppMethodBeat.i(317618);
    View localView = getContentView();
    AppMethodBeat.o(317618);
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.r.d
 * JD-Core Version:    0.7.0.1
 */