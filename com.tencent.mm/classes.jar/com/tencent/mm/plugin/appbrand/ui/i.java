package com.tencent.mm.plugin.appbrand.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.modelappbrand.a.f;
import com.tencent.mm.plugin.appbrand.config.a.d;
import com.tencent.mm.plugin.appbrand.widget.actionbar.c;
import com.tencent.mm.plugin.appbrand.widget.actionbar.d;
import com.tencent.mm.plugin.appbrand.widget.actionbar.d.a;
import com.tencent.mm.plugin.appbrand.y.g;
import com.tencent.mm.plugin.appbrand.y.h;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;

@SuppressLint({"ViewConstructor"})
final class i
  extends com.tencent.mm.ui.statusbar.b
  implements n
{
  private ImageView cR;
  private com.tencent.mm.plugin.appbrand.i fzT;
  private ThreeDotsLoadingView haZ;
  private TextView hcC;
  private LinearLayout hcD;
  private d hcE;
  private View hes;
  private View het;
  
  public i(Context paramContext, com.tencent.mm.plugin.appbrand.i parami)
  {
    super(paramContext);
    this.fzT = parami;
    setClickable(true);
    setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    LayoutInflater.from(getContext()).inflate(y.h.app_brand_splash_ui, this);
    this.cR = ((ImageView)findViewById(y.g.app_brand_loading_avatar));
    this.cR.setImageDrawable(com.tencent.mm.modelappbrand.a.a.JC());
    this.hcC = ((TextView)findViewById(y.g.app_brand_loading_name));
    this.haZ = ((ThreeDotsLoadingView)findViewById(y.g.app_brand_loading_view));
    this.hcD = ((LinearLayout)findViewById(y.g.app_brand_loading_fake_ab_container));
    this.het = findViewById(y.g.app_brand_loading_top_area);
    this.hes = findViewById(y.g.app_brand_loading_root);
    this.hcE = d.a.c(getContext(), this.fzT);
    this.hcD.addView(this.hcE.getActionView());
    int i = com.tencent.mm.plugin.appbrand.widget.a.cD(getContext());
    this.hcC.getLayoutParams().height = i;
    av(-1, true);
    this.hcE.setBackgroundColor(0);
    this.hcE.setForegroundStyle("black");
    this.hcE.setNavBackOrClose(false);
    paramContext = new i.2(this);
    this.hcE.setCloseButtonClickListener(paramContext);
    this.hcE.setBackButtonClickListener(paramContext);
    if ((this.hcE instanceof c)) {
      ((c)this.hcE).arb();
    }
    this.haZ.cKb();
  }
  
  public final void a(a.d paramd) {}
  
  public final void aoS()
  {
    post(new i.1(this));
  }
  
  public final void aoT()
  {
    this.hcE.setNavHidden(true);
  }
  
  public final void cd(String paramString1, String paramString2)
  {
    com.tencent.mm.modelappbrand.a.b.JD().a(this.cR, paramString1, null, f.eaL);
    this.hcC.setText(paramString2);
  }
  
  public final View getView()
  {
    return this;
  }
  
  public final boolean hasOverlappingRendering()
  {
    return false;
  }
  
  protected final void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if ((getContext() instanceof Activity)) {
      l.c(((Activity)getContext()).getWindow(), false);
    }
  }
  
  public final void setProgress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.i
 * JD-Core Version:    0.7.0.1
 */