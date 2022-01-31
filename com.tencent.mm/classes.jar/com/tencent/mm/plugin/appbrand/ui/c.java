package com.tencent.mm.plugin.appbrand.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.a.f;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.a.a.b;
import com.tencent.mm.plugin.appbrand.game.preload.e;
import com.tencent.mm.plugin.appbrand.game.preload.ui.BootstrapProgressBar;
import com.tencent.mm.plugin.appbrand.launching.j;
import com.tencent.mm.plugin.appbrand.widget.actionbar.f.a;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import java.util.Timer;

@SuppressLint({"ViewConstructor"})
final class c
  extends com.tencent.mm.ui.statusbar.b
  implements j, r
{
  private ImageView dV;
  private com.tencent.mm.plugin.appbrand.o gQn;
  private ThreeDotsLoadingView iJJ;
  private ImageView iLS;
  private ImageView iLT;
  private TextView iLU;
  private LinearLayout iLV;
  private com.tencent.mm.plugin.appbrand.widget.actionbar.b iLW;
  private TextView iLX;
  private a.b iLY;
  private TextView iLZ;
  private boolean iMa;
  private Runnable iMb;
  private RelativeLayout iMc;
  private boolean iMd;
  private boolean iMe;
  private boolean iMf;
  private int iMg;
  private boolean iMh;
  private int iMi;
  private RelativeLayout iMj;
  private ImageView iMk;
  private BootstrapProgressBar iMl;
  private boolean iMm;
  private boolean iMn;
  
  public c(Context paramContext, com.tencent.mm.plugin.appbrand.o paramo)
  {
    super(paramContext);
    AppMethodBeat.i(132947);
    this.iLY = a.b.hkD;
    this.iMb = null;
    this.iMd = false;
    this.iMe = false;
    this.iMf = false;
    this.iMh = false;
    this.iMi = 30;
    this.gQn = paramo;
    ab.i("MicroMsg.AppBrandGameUILoadingSplash", "init");
    setClickable(true);
    setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    LayoutInflater.from(getContext()).inflate(2130968740, this);
    this.iMj = ((RelativeLayout)findViewById(2131821416));
    this.iMk = ((ImageView)findViewById(2131821417));
    this.iMl = ((BootstrapProgressBar)findViewById(2131821418));
    e.aAT().de(999, 1);
    label297:
    RelativeLayout.LayoutParams localLayoutParams;
    Object localObject;
    if ((((com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lWc, false)) && (this.gQn != null))
    {
      long l = bo.yB();
      paramContext = this.gQn.atS();
      paramo = paramContext.hiF;
      if (!bo.isNullOrNil(paramo))
      {
        this.iMd = true;
        ab.i("MicroMsg.AppBrandGameUILoadingSplash", "loadingImgUrl:%s", new Object[] { paramo });
        e.aAT().de(1000, 1);
        com.tencent.mm.ch.a.post(new c.2(this, paramo, new c.1(this, l)));
        if (bo.isNullOrNil(paramContext.hiG)) {
          break label891;
        }
        this.iMg = Color.parseColor(paramContext.hiG);
        this.iMl.setProgressColor(this.iMg);
        ab.i("MicroMsg.AppBrandGameUILoadingSplash", "loadingProgressBarColor:%s", new Object[] { Integer.valueOf(this.iMg) });
        al.p(new c.3(this), 1000L);
        al.p(new c.4(this), 2000L);
      }
    }
    else
    {
      this.iMc = ((RelativeLayout)findViewById(2131821407));
      this.dV = ((ImageView)findViewById(2131821413));
      this.dV.setImageDrawable(com.tencent.mm.modelappbrand.a.a.acC());
      this.iLU = ((TextView)findViewById(2131821408));
      this.iLS = ((ImageView)findViewById(2131821415));
      this.iJJ = ((ThreeDotsLoadingView)findViewById(2131821410));
      this.iLT = ((ImageView)findViewById(2131821409));
      this.iLV = ((LinearLayout)findViewById(2131821406));
      this.iLX = ((TextView)findViewById(2131821411));
      this.iLZ = ((TextView)findViewById(2131821412));
      paramContext = (RelativeLayout.LayoutParams)this.iJJ.getLayoutParams();
      paramo = (RelativeLayout.LayoutParams)this.iLT.getLayoutParams();
      localLayoutParams = (RelativeLayout.LayoutParams)this.iLS.getLayoutParams();
      this.iLW = f.a.dl(getContext());
      localObject = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject).gravity = 21;
      ((LinearLayout.LayoutParams)localObject).rightMargin = com.tencent.mm.cb.a.ap(getContext(), 2131428001);
      ((LinearLayout.LayoutParams)localObject).topMargin = com.tencent.mm.cb.a.ap(getContext(), 2131428002);
      this.iLV.addView(this.iLW.getActionView(), (ViewGroup.LayoutParams)localObject);
      if (this.gQn.atS().hix != 1) {
        break label922;
      }
      this.iLT.setVisibility(0);
      label594:
      localObject = (RelativeLayout.LayoutParams)this.iMl.getLayoutParams();
      this.iLY = com.tencent.mm.plugin.appbrand.config.a.a.s(this.gQn.atV()).dQ(com.tencent.mm.plugin.appbrand.config.a.a.ayK());
      ab.i("MicroMsg.AppBrandGameUILoadingSplash", "mLastDeviceOrientation :%s", new Object[] { this.iLY });
      if ((this.iLY != a.b.hkF) && (this.iLY != a.b.hkG) && (this.iLY != a.b.hkH) && (this.iLY != a.b.hkI)) {
        break label966;
      }
      if (this.iLT.getVisibility() != 0) {
        break label934;
      }
      paramContext.topMargin = com.tencent.mm.cb.a.ap(getContext(), 2131428007);
      localLayoutParams.bottomMargin = com.tencent.mm.cb.a.ap(getContext(), 2131428003);
      paramo.topMargin = com.tencent.mm.cb.a.ap(getContext(), 2131428010);
      this.iLT.setLayoutParams(paramo);
    }
    for (;;)
    {
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = com.tencent.mm.cb.a.ap(getContext(), 2131427997);
      ((RelativeLayout.LayoutParams)localObject).width = com.tencent.mm.cb.a.ap(getContext(), 2131427998);
      this.iJJ.setLayoutParams(paramContext);
      this.iMl.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.iLS.setLayoutParams(localLayoutParams);
      K(-1, true);
      this.iLW.setBackgroundColor(0);
      this.iLW.setForegroundStyle("black");
      paramContext = new c.7(this);
      this.iLW.setCloseButtonClickListener(paramContext);
      this.iLW.setBackButtonClickListener(paramContext);
      o.de(getContext());
      if (this.iMd) {
        break label1092;
      }
      this.iJJ.dOV();
      AppMethodBeat.o(132947);
      return;
      e.aAT().de(1000, 0);
      break;
      label891:
      this.iMg = getContext().getResources().getColor(2131689687);
      this.iMl.setProgressColor(this.iMg);
      break label297;
      label922:
      this.iLT.setVisibility(8);
      break label594;
      label934:
      paramContext.topMargin = com.tencent.mm.cb.a.ap(getContext(), 2131428011);
      localLayoutParams.bottomMargin = com.tencent.mm.cb.a.ap(getContext(), 2131428004);
    }
    label966:
    if (this.iLT.getVisibility() == 0)
    {
      paramContext.topMargin = com.tencent.mm.cb.a.ap(getContext(), 2131428009);
      localLayoutParams.bottomMargin = com.tencent.mm.cb.a.ap(getContext(), 2131428004);
      paramo.topMargin = com.tencent.mm.cb.a.ap(getContext(), 2131428012);
      this.iLT.setLayoutParams(paramo);
    }
    for (;;)
    {
      ((RelativeLayout.LayoutParams)localObject).width = com.tencent.mm.cb.a.ap(getContext(), 2131428000);
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = com.tencent.mm.cb.a.ap(getContext(), 2131427999);
      break;
      paramContext.topMargin = com.tencent.mm.cb.a.ap(getContext(), 2131428008);
      localLayoutParams.bottomMargin = com.tencent.mm.cb.a.ap(getContext(), 2131428004);
    }
    label1092:
    this.iJJ.setVisibility(4);
    this.iLX.setVisibility(4);
    AppMethodBeat.o(132947);
  }
  
  public final void aHA()
  {
    AppMethodBeat.i(132949);
    ab.w("MicroMsg.AppBrandGameUILoadingSplash", "animateHide");
    post(new c.5(this));
    AppMethodBeat.o(132949);
  }
  
  public final void aHB() {}
  
  public final void cD(String paramString1, String paramString2)
  {
    AppMethodBeat.i(132948);
    com.tencent.mm.modelappbrand.a.b.acD().a(this.dV, paramString1, null, f.fqU);
    this.iLU.setText(paramString2);
    AppMethodBeat.o(132948);
  }
  
  public final View getView()
  {
    return this;
  }
  
  public final void ng(final int paramInt)
  {
    AppMethodBeat.i(132952);
    al.d(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(132941);
        ab.i("MicroMsg.AppBrandGameUILoadingSplash", "onDataTransferState  state=" + paramInt);
        if (paramInt == 3)
        {
          if (c.m(c.this))
          {
            c.n(c.this).setVisibility(0);
            c.n(c.this).setText(2131297121);
            c.k(c.this).setVisibility(4);
            AppMethodBeat.o(132941);
            return;
          }
          c.a(c.this, this);
        }
        AppMethodBeat.o(132941);
      }
    });
    AppMethodBeat.o(132952);
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(132950);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    a.b localb = com.tencent.mm.plugin.appbrand.config.a.a.s(this.gQn.atV()).dQ(com.tencent.mm.plugin.appbrand.config.a.a.ayK());
    RelativeLayout.LayoutParams localLayoutParams1;
    RelativeLayout.LayoutParams localLayoutParams2;
    RelativeLayout.LayoutParams localLayoutParams3;
    RelativeLayout.LayoutParams localLayoutParams4;
    if (localb != this.iLY)
    {
      this.iLY = localb;
      localLayoutParams1 = (RelativeLayout.LayoutParams)this.iJJ.getLayoutParams();
      localLayoutParams2 = (RelativeLayout.LayoutParams)this.iLT.getLayoutParams();
      localLayoutParams3 = (RelativeLayout.LayoutParams)this.iMl.getLayoutParams();
      localLayoutParams4 = (RelativeLayout.LayoutParams)this.iLS.getLayoutParams();
      if ((localb != a.b.hkF) && (localb != a.b.hkG) && (localb != a.b.hkH) && (localb != a.b.hkI)) {
        break label295;
      }
      if (this.iLT.getVisibility() != 0) {
        break label262;
      }
      localLayoutParams1.topMargin = com.tencent.mm.cb.a.ap(getContext(), 2131428007);
      localLayoutParams4.bottomMargin = com.tencent.mm.cb.a.ap(getContext(), 2131428003);
      localLayoutParams2.topMargin = com.tencent.mm.cb.a.ap(getContext(), 2131428010);
      this.iLT.setLayoutParams(localLayoutParams2);
    }
    for (;;)
    {
      localLayoutParams3.width = com.tencent.mm.cb.a.ap(getContext(), 2131427998);
      localLayoutParams3.bottomMargin = com.tencent.mm.cb.a.ap(getContext(), 2131427997);
      this.iMl.setLayoutParams(localLayoutParams3);
      this.iJJ.setLayoutParams(localLayoutParams1);
      this.iLS.setLayoutParams(localLayoutParams4);
      requestLayout();
      AppMethodBeat.o(132950);
      return;
      label262:
      localLayoutParams1.topMargin = com.tencent.mm.cb.a.ap(getContext(), 2131428011);
      localLayoutParams4.bottomMargin = com.tencent.mm.cb.a.ap(getContext(), 2131428004);
    }
    label295:
    if (this.iLT.getVisibility() == 0)
    {
      localLayoutParams1.topMargin = com.tencent.mm.cb.a.ap(getContext(), 2131428009);
      localLayoutParams4.bottomMargin = com.tencent.mm.cb.a.ap(getContext(), 2131428004);
      localLayoutParams2.topMargin = com.tencent.mm.cb.a.ap(getContext(), 2131428012);
      this.iLT.setLayoutParams(localLayoutParams2);
    }
    for (;;)
    {
      localLayoutParams3.width = com.tencent.mm.cb.a.ap(getContext(), 2131428000);
      localLayoutParams3.bottomMargin = com.tencent.mm.cb.a.ap(getContext(), 2131427999);
      break;
      localLayoutParams1.topMargin = com.tencent.mm.cb.a.ap(getContext(), 2131428008);
      localLayoutParams4.bottomMargin = com.tencent.mm.cb.a.ap(getContext(), 2131428004);
    }
  }
  
  public final void setProgress(int paramInt)
  {
    AppMethodBeat.i(132951);
    if (!this.iMd)
    {
      if (paramInt < 100)
      {
        this.iLX.setText(String.format("%d%%", new Object[] { Integer.valueOf(paramInt / 2) }));
        AppMethodBeat.o(132951);
        return;
      }
      if (!this.iMm)
      {
        this.iMm = true;
        new Timer(true).scheduleAtFixedRate(new c.b(this), 0L, 50L);
        AppMethodBeat.o(132951);
      }
    }
    else if ((!this.iMe) && (this.iMh))
    {
      if (paramInt < 100)
      {
        this.iLX.setText(String.format("%d%%", new Object[] { Integer.valueOf(paramInt / 2) }));
        AppMethodBeat.o(132951);
        return;
      }
      if (!this.iMm)
      {
        this.iMm = true;
        new Timer(true).scheduleAtFixedRate(new c.b(this), 0L, 100L);
        AppMethodBeat.o(132951);
      }
    }
    else if (paramInt < 100)
    {
      if (this.iMj.getVisibility() == 0)
      {
        this.iMl.setProgress(paramInt / 2);
        AppMethodBeat.o(132951);
      }
    }
    else if (!this.iMn)
    {
      this.iMn = true;
      new Timer(true).scheduleAtFixedRate(new c.a(this), 0L, 1000 / this.iMi);
    }
    AppMethodBeat.o(132951);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.c
 * JD-Core Version:    0.7.0.1
 */