package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.content.Context;
import android.graphics.PointF;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;
import com.tencent.mm.h.a.cz;
import com.tencent.mm.plugin.appbrand.widget.header.GyroView;
import com.tencent.mm.plugin.appbrand.widget.header.HeaderContainer;
import com.tencent.mm.plugin.appbrand.y.g;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.y;

public final class a
  extends com.tencent.mm.plugin.appbrand.widget.header.a
{
  private ListView Nn;
  private View amL;
  private View heP;
  private boolean hpA = false;
  private boolean hpB = true;
  private HeaderContainer hph;
  private float hpi = 0.2F;
  private float hpj = 0.05F;
  private int hpk = 0;
  private int hpl = 0;
  private Vibrator hpm;
  private int hpn;
  private boolean hpo = false;
  private boolean hpp = false;
  private Runnable hpq;
  private int hpr = com.tencent.mm.cb.a.fromDPToPix(ae.getContext(), 72);
  private boolean hps;
  private PointF hpt = new PointF();
  private PointF hpu = new PointF();
  private boolean hpv = false;
  private boolean hpw = true;
  private GyroView hpx;
  private View hpy;
  private boolean hpz = true;
  private Context mContext;
  
  public a(Context paramContext, ListView paramListView, HeaderContainer paramHeaderContainer)
  {
    this.mContext = paramContext;
    this.Nn = paramListView;
    this.hph = paramHeaderContainer;
    this.hpm = ((Vibrator)paramContext.getSystemService("vibrator"));
    paramListView.post(new a.1(this));
  }
  
  private boolean are()
  {
    int i = this.hph.getTop();
    if (!arg()) {
      if (i <= -(this.hph.getHeight() - arh())) {}
    }
    do
    {
      return true;
      return false;
      if (this.hpl == 0) {
        this.hpl = ((int)(this.hph.getHeight() * this.hpj));
      }
    } while (i >= -this.hpl);
    return false;
  }
  
  private boolean arf()
  {
    return this.hph.getBottom() >= this.hpn + 6;
  }
  
  private boolean arg()
  {
    return this.hpu.y < this.hpt.y;
  }
  
  private int arh()
  {
    if (this.hpk == 0) {
      this.hpk = ((int)(this.hph.getHeight() * this.hpi));
    }
    return this.hpk;
  }
  
  private void ari()
  {
    if (this.hpy != null)
    {
      this.hpy.setTranslationY(arh() * 2);
      this.hpy.setAlpha(0.0F);
    }
    this.hpB = true;
    this.hpz = true;
  }
  
  private void dP(boolean paramBoolean)
  {
    if (this.hph.isFullScreen())
    {
      y.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo enableBottomTabSwitch enable: %b, last: %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.hpw) });
      if (paramBoolean != this.hpw)
      {
        this.hpw = paramBoolean;
        cz localcz = new cz();
        localcz.bJf.bIU = paramBoolean;
        com.tencent.mm.sdk.b.a.udP.m(localcz);
      }
    }
  }
  
  public final void ard()
  {
    if (!arf()) {
      return;
    }
    this.hpo = true;
    this.Nn.removeCallbacks(this.hpq);
    ListView localListView = this.Nn;
    a.3 local3 = new a.3(this);
    this.hpq = local3;
    localListView.post(local3);
  }
  
  public final void ce(View paramView)
  {
    this.amL = paramView;
  }
  
  public final void cf(View paramView)
  {
    this.heP = paramView;
  }
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.hpp) && (!this.hpo) && (this.hps) && (paramInt1 == 0) && (arf()))
    {
      y.i("MicroMsg.AppBrandDesktopAnimController", "[onScroll] stop fling!");
      this.Nn.scrollBy(0, 0);
      ard();
    }
    float f1;
    if ((!this.hpp) && (paramInt1 == 0) && (this.hph != null))
    {
      paramInt1 = this.hph.getBottom();
      if ((!b.arj()) && (this.heP != null))
      {
        float f2 = (paramInt1 - this.hpn) * 1.0F / (this.hph.getHeight() - this.hpn);
        f1 = f2;
        if (f2 < 0.0F) {
          f1 = 0.0F;
        }
        this.heP.setTranslationY(-this.heP.getHeight() * f1);
        this.amL.setTranslationY(this.amL.getHeight() * f1);
        if (Math.abs(1.0F - f1) > 0.01D) {
          break label292;
        }
        this.heP.setVisibility(4);
        this.amL.setVisibility(4);
      }
    }
    if (!arf())
    {
      this.hpp = true;
      if ((arf()) && (!are())) {
        s(false, true);
      }
      label230:
      if (arf()) {
        break label343;
      }
      ari();
      this.hpv = arf();
      if ((this.hpn <= 0) || (this.hph.getBottom() < this.hpn + com.tencent.mm.cb.a.fromDPToPix(this.mContext, 50))) {
        break label662;
      }
    }
    label662:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (paramInt1 == 0) {
        break label667;
      }
      dP(false);
      return;
      label292:
      this.heP.setVisibility(0);
      this.amL.setVisibility(0);
      break;
      this.hpp = false;
      if ((this.hpv == arf()) || (!are())) {
        break label230;
      }
      s(true, true);
      break label230;
      label343:
      paramInt1 = arh();
      if (this.hpx == null) {
        this.hpx = ((GyroView)this.hph.findViewById(y.g.gyro_view));
      }
      if (this.hpy == null)
      {
        this.hpy = this.hph.findViewById(y.g.app_brand_desktop_view);
        this.hpy.setTranslationY(paramInt1 * 2);
      }
      paramInt2 = this.hph.getBottom() - this.hpn;
      if (paramInt1 >= paramInt2)
      {
        this.hpx.b(paramInt2, paramInt1);
        this.hpx.setTranslationY(-paramInt2 / 2 + this.hpx.getHeight() / 2 + this.hph.getPaddingBottom());
      }
      for (;;)
      {
        if (this.hpz)
        {
          f1 = this.hph.getHeight() - this.hpn;
          paramInt3 = (int)(paramInt1 * 2 * 1.0F * paramInt2 / f1);
          this.hpy.setTranslationY(paramInt1 * 2 - paramInt3);
          y.i("MicroMsg.AppBrandDesktopAnimController", "[transHeader] TranY:" + (paramInt1 * 2 - paramInt3));
          f1 = (paramInt2 - paramInt1) * 1.0F / (f1 - paramInt1);
          if (paramInt2 >= paramInt1) {
            this.hpy.setAlpha(f1);
          }
          this.hpx.setAlpha((1.2F * paramInt1 - paramInt2) / paramInt1);
        }
        if ((paramInt1 <= paramInt2) && (this.hpB))
        {
          this.hpm.vibrate(10L);
          this.hpB = false;
        }
        if (this.hpy.getTranslationY() <= 0.0F) {
          this.hpz = false;
        }
        if (paramInt2 >= this.hpn + 10) {
          break;
        }
        ari();
        break;
        this.hpx.b(paramInt1, paramInt1);
      }
    }
    label667:
    dP(true);
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      this.hps = false;
      if (this.hpo)
      {
        y.i("MicroMsg.AppBrandDesktopAnimController", "isScrollingByAnim True!!!");
        this.hpo = false;
      }
    }
    do
    {
      do
      {
        return;
        if (!are()) {
          break;
        }
      } while (!arf());
      if ((this.hpz) && (this.hpA)) {
        au.ak(this.mContext, y.j.app_brand_recent_view_down_sound_path);
      }
      this.hpo = true;
      this.Nn.removeCallbacks(this.hpq);
      paramAbsListView = this.Nn;
      a.2 local2 = new a.2(this);
      this.hpq = local2;
      paramAbsListView.post(local2);
      return;
      ard();
      return;
      if (paramInt == 2)
      {
        this.hps = true;
        return;
      }
    } while ((paramInt != 1) || (!arg()));
    this.hps = false;
  }
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      this.Nn.removeCallbacks(this.hpq);
      this.hpt.set(paramMotionEvent.getRawX(), paramMotionEvent.getRawY());
    }
    while ((paramMotionEvent.getAction() != 3) && (paramMotionEvent.getAction() != 1)) {
      return false;
    }
    this.hpu.set(paramMotionEvent.getRawX(), paramMotionEvent.getRawY());
    onScrollStateChanged(this.Nn, 0);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.a
 * JD-Core Version:    0.7.0.1
 */