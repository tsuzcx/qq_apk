package com.tencent.mm.plugin.appbrand.ui.recents;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.appusage.l;
import com.tencent.mm.plugin.appbrand.appusage.l.b;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Set;

final class j
  extends a
  implements l.b, h.b
{
  Activity fyk;
  private j.a hjg = new j.a((byte)0);
  h hjh;
  private boolean hji = false;
  private View.OnClickListener hjj = null;
  volatile boolean mFinished = false;
  
  j(Activity paramActivity, ViewGroup paramViewGroup)
  {
    this.hjh = new h(paramViewGroup, y.j.app_brand_launcher_head_wxagame);
    this.hjh.hiz = this;
    this.fyk = paramActivity;
  }
  
  private static Integer wA(String paramString)
  {
    try
    {
      int i = Color.parseColor(paramString);
      return Integer.valueOf(i);
    }
    catch (Exception paramString) {}
    return null;
  }
  
  public final void a(h.c paramc, View paramView)
  {
    if ((paramc == null) || (paramc == h.c.hiI) || (paramc == h.c.hiH)) {
      y.v("MicroMsg.AppBrandListRecentsListWAGameHeader", "onClick ");
    }
    do
    {
      do
      {
        do
        {
          return;
          if (paramc == h.c.hiK)
          {
            this.hjh.apT();
            l.acW().refresh();
            return;
          }
        } while ((paramc != h.c.hiJ) || (this.hjj == null));
        this.hjj.onClick(paramView);
      } while (!this.hji);
      paramc = this.hjh;
    } while (paramc.hiB.hiP == null);
    paramc.hiB.hiP.animate().alpha(0.0F).setDuration(200L).start();
  }
  
  public final void acX()
  {
    y.i("MicroMsg.AppBrandListRecentsListWAGameHeader", "AppBrandListRecentsListWAGameHeader.onWAGameDataUpdate");
    l.acW();
    if (!l.enabled()) {}
    View localView;
    do
    {
      do
      {
        return;
      } while (this.mFinished);
      localView = this.hjh.hiB.aie;
    } while (localView == null);
    localView.post(new j.1(this));
  }
  
  public final void apJ()
  {
    l locall = l.acW();
    dF(l.enabled());
    if (!l.enabled()) {
      return;
    }
    if (this != null) {}
    synchronized (locall.mLock)
    {
      locall.fIt.add(this);
      locall.refresh();
      this.hjh.apT();
      this.mFinished = false;
      return;
    }
  }
  
  public final View apK()
  {
    return this.hjh.hiB.aie;
  }
  
  public final void onDetached()
  {
    this.mFinished = true;
    l locall = l.acW();
    if (this != null) {
      synchronized (locall.mLock)
      {
        locall.fIt.remove(this);
        return;
      }
    }
  }
  
  public final void onResume() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.j
 * JD-Core Version:    0.7.0.1
 */