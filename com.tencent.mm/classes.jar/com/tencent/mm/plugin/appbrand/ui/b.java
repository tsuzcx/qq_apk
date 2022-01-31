package com.tencent.mm.plugin.appbrand.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.modelappbrand.a.f;
import com.tencent.mm.plugin.appbrand.config.a.d;
import com.tencent.mm.plugin.appbrand.config.e;
import com.tencent.mm.plugin.appbrand.config.e.b;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.widget.actionbar.c;
import com.tencent.mm.plugin.appbrand.widget.actionbar.d;
import com.tencent.mm.plugin.appbrand.widget.actionbar.d.a;
import com.tencent.mm.plugin.appbrand.y.e;
import com.tencent.mm.plugin.appbrand.y.g;
import com.tencent.mm.plugin.appbrand.y.h;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import java.util.Timer;

@SuppressLint({"ViewConstructor"})
final class b
  extends com.tencent.mm.ui.statusbar.b
  implements n
{
  private ImageView cR;
  private i fzT;
  private ThreeDotsLoadingView haZ;
  private ImageView hcB;
  private TextView hcC;
  private LinearLayout hcD;
  private d hcE;
  private TextView hcF;
  private e.b hcG = e.b.fOq;
  
  public b(Context paramContext, i parami)
  {
    super(paramContext);
    this.fzT = parami;
    y.i("MicroMsg.AppBrandGameUILoadingSplash", "init");
    setClickable(true);
    setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    LayoutInflater.from(getContext()).inflate(y.h.app_brand_splash_game_ui, this);
    this.cR = ((ImageView)findViewById(y.g.app_brand_game_loading_avatar));
    this.cR.setImageDrawable(com.tencent.mm.modelappbrand.a.a.JC());
    this.hcC = ((TextView)findViewById(y.g.app_brand_game_loading_name));
    this.hcB = ((ImageView)findViewById(y.g.app_brand_game_wagame_name));
    this.haZ = ((ThreeDotsLoadingView)findViewById(y.g.app_brand_game_loading_view));
    this.hcD = ((LinearLayout)findViewById(y.g.app_brand_game_loading_ab_container));
    this.hcF = ((TextView)findViewById(y.g.app_brand_game_progress));
    paramContext = (RelativeLayout.LayoutParams)this.haZ.getLayoutParams();
    this.hcE = d.a.c(getContext(), this.fzT);
    parami = new LinearLayout.LayoutParams(-2, -2);
    parami.gravity = 21;
    parami.rightMargin = com.tencent.mm.cb.a.ab(getContext(), y.e.app_brand_game_mode_icon_margin_right);
    parami.topMargin = com.tencent.mm.cb.a.ab(getContext(), y.e.app_brand_game_mode_icon_margin_top);
    this.hcD.addView(this.hcE.getActionView(), parami);
    this.hcG = e.r(this.fzT.getContext()).cM(e.adY());
    y.i("MicroMsg.AppBrandGameUILoadingSplash", "mLastDeviceOrientation :%s", new Object[] { this.hcG });
    if ((this.hcG == e.b.fOs) || (this.hcG == e.b.fOt))
    {
      paramContext.topMargin = com.tencent.mm.cb.a.ab(getContext(), y.e.app_brand_game_splash_loading_landspace_top_margin);
      this.hcC.setPadding(0, 0, 0, 0);
      this.haZ.setLayoutParams(paramContext);
      av(-1, true);
      this.hcE.setBackgroundColor(0);
      this.hcE.setForegroundStyle("black");
      this.hcE.setNavBackOrClose(false);
      paramContext = new b.2(this);
      this.hcE.setCloseButtonClickListener(paramContext);
      this.hcE.setBackButtonClickListener(paramContext);
      if ((this.hcE instanceof c)) {
        ((c)this.hcE).arb();
      }
      if ((getContext() != null) && ((getContext() instanceof Activity))) {
        break label487;
      }
    }
    for (;;)
    {
      this.haZ.cKb();
      return;
      paramContext.topMargin = com.tencent.mm.cb.a.ab(getContext(), y.e.app_brand_game_splash_loading_portrait_top_margin);
      this.hcC.setPadding(0, 0, 0, com.tencent.mm.cb.a.ab(getContext(), y.e.app_brand_game_splash_icon_portrait_top_padding));
      this.haZ.setLayoutParams(paramContext);
      break;
      label487:
      paramContext = ((Activity)getContext()).getWindow();
      if (paramContext != null) {
        l.c(paramContext, true);
      }
    }
  }
  
  public final void a(a.d paramd) {}
  
  public final void aoS()
  {
    y.w("MicroMsg.AppBrandGameUILoadingSplash", "animateHide");
    post(new b.1(this));
  }
  
  public final void aoT() {}
  
  public final void cd(String paramString1, String paramString2)
  {
    com.tencent.mm.modelappbrand.a.b.JD().a(this.cR, paramString1, null, f.eaL);
    this.hcC.setText(paramString2);
  }
  
  public final View getView()
  {
    return this;
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    y.i("MicroMsg.AppBrandGameUILoadingSplash", "onLayout changed:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    e.b localb = e.r(this.fzT.getContext()).cM(e.adY());
    y.i("MicroMsg.AppBrandGameUILoadingSplash", "curDeviceOrientation: %s,mLastDeviceOrientation: %s", new Object[] { localb, this.hcG });
    RelativeLayout.LayoutParams localLayoutParams;
    if (localb != this.hcG)
    {
      this.hcG = localb;
      localLayoutParams = (RelativeLayout.LayoutParams)this.haZ.getLayoutParams();
      if ((localb != e.b.fOs) && (localb != e.b.fOt)) {
        break label155;
      }
      localLayoutParams.topMargin = com.tencent.mm.cb.a.ab(getContext(), y.e.app_brand_game_splash_loading_landspace_top_margin);
      this.hcC.setPadding(0, 0, 0, 0);
    }
    for (;;)
    {
      this.haZ.setLayoutParams(localLayoutParams);
      requestLayout();
      return;
      label155:
      localLayoutParams.topMargin = com.tencent.mm.cb.a.ab(getContext(), y.e.app_brand_game_splash_loading_portrait_top_margin);
      this.hcC.setPadding(0, 0, 0, com.tencent.mm.cb.a.ab(getContext(), y.e.app_brand_game_splash_icon_portrait_top_padding));
    }
  }
  
  public final void setProgress(int paramInt)
  {
    y.i("MicroMsg.AppBrandGameUILoadingSplash", "download progress");
    if (paramInt < 100)
    {
      this.hcF.setText(String.format("%d%%", new Object[] { Integer.valueOf(paramInt / 2) }));
      return;
    }
    new Timer(true).scheduleAtFixedRate(new b.a(this), 0L, 50L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.b
 * JD-Core Version:    0.7.0.1
 */