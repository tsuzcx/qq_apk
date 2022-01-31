package com.tencent.mm.plugin.appbrand.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import com.tencent.mm.plugin.appbrand.config.a;
import com.tencent.mm.plugin.appbrand.config.a.b;
import com.tencent.mm.plugin.appbrand.config.a.d;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.widget.actionbar.d;
import com.tencent.mm.plugin.appbrand.widget.actionbar.d.a;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.statusbar.b;

@SuppressLint({"ViewConstructor"})
final class f
  extends b
  implements n
{
  private i fzT;
  private d hdk;
  private Runnable hdl;
  
  public f(Context paramContext, i parami)
  {
    super(paramContext);
    this.fzT = parami;
    this.hdk = d.a.c(getContext(), this.fzT);
    addView(this.hdk.getActionView());
    this.hdk.dO(false);
    paramContext = new f.1(this);
    this.hdk.setCloseButtonClickListener(paramContext);
    this.hdk.setBackButtonClickListener(paramContext);
    n(ae.getContext().getString(y.j.app_brand_action_plugin_splash_loading), -1, "black");
    setBackgroundColor(-1);
  }
  
  private void n(String paramString1, int paramInt, String paramString2)
  {
    this.hdk.setMainTitle(paramString1);
    this.hdk.setBackgroundColor(paramInt);
    this.hdk.setForegroundStyle(paramString2);
    this.hdk.setNavBackOrClose(true);
    this.hdk.setLoadingIconVisibility(true);
    av(paramInt, "black".equals(paramString2));
  }
  
  public final void a(a.d paramd)
  {
    if (this.fzT.getAppConfig().fNB.adW()) {
      return;
    }
    n(paramd.fNU, l.bb(paramd.fNY, -1), paramd.fNV);
    setBackgroundColor(l.bb(paramd.fNR, -1));
  }
  
  public final void aoS()
  {
    removeCallbacks(this.hdl);
    post(new f.3(this));
  }
  
  public final void aoT()
  {
    this.hdk.setNavHidden(true);
  }
  
  public final void cd(String paramString1, String paramString2)
  {
    this.hdk.setMainTitle(ae.getContext().getString(y.j.app_brand_action_plugin_splash_loading));
  }
  
  public final View getView()
  {
    return this;
  }
  
  protected final void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.hdl == null)
    {
      this.hdl = new Runnable()
      {
        public final void run()
        {
          if (f.b(f.this) != null) {
            f.b(f.this).setLoadingIconVisibility(true);
          }
        }
      };
      postDelayed(this.hdl, 1500L);
    }
  }
  
  protected final void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    removeCallbacks(this.hdl);
  }
  
  public final void setProgress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.f
 * JD-Core Version:    0.7.0.1
 */