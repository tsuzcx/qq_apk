package com.tencent.mm.plugin.appbrand.page;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.view.t;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.aa.g;
import com.tencent.mm.plugin.appbrand.config.a.d;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b.b;
import com.tencent.mm.plugin.appbrand.widget.actionbar.d;
import com.tencent.mm.ui.am;

@SuppressLint({"ViewConstructor"})
public final class br
  extends FrameLayout
  implements b.b
{
  private aa cdz;
  d laU;
  private b laV;
  boolean lga;
  
  public br(Context paramContext, aa paramaa)
  {
    super(paramContext);
    AppMethodBeat.i(147502);
    this.lga = false;
    this.cdz = paramaa;
    paramContext = this.cdz.getPageConfig();
    if (paramContext == null)
    {
      AppMethodBeat.o(147502);
      return;
    }
    if (paramContext.aTr())
    {
      this.laU = new d(getContext());
      this.laU.setActuallyVisible(false);
      this.laV = ((b)this.cdz.kPL.c(getContext(), b.class));
      this.laV.setFullscreenMode(false);
      this.laV.hd(false);
      bkH();
      this.laU.addView(this.laV);
      addView(this.laU, -1, -2);
    }
    setBackgroundColor(g.bY(paramContext.jbK, -1));
    AppMethodBeat.o(147502);
  }
  
  private void bkI()
  {
    AppMethodBeat.i(147505);
    if (this.laV != null)
    {
      if ((getVisibility() == 0) && (t.aC(this)))
      {
        this.laV.setLoadingIconVisibility(true);
        this.laU.setActuallyVisible(true);
        AppMethodBeat.o(147505);
        return;
      }
      this.laV.setLoadingIconVisibility(false);
      this.laU.setActuallyVisible(false);
    }
    AppMethodBeat.o(147505);
  }
  
  final void bkH()
  {
    AppMethodBeat.i(147503);
    if (this.laV == null)
    {
      AppMethodBeat.o(147503);
      return;
    }
    if (!TextUtils.isEmpty(this.cdz.bjH().getMainTitle())) {
      this.laV.setMainTitle(this.cdz.bjH().getMainTitle());
    }
    for (;;)
    {
      this.laV.setNavHidden(this.cdz.bjH().brg());
      AppMethodBeat.o(147503);
      return;
      this.laV.setMainTitle(getContext().getString(2131755293));
    }
  }
  
  public final void gK(boolean paramBoolean)
  {
    this.lga = paramBoolean;
  }
  
  protected final void onAttachedToWindow()
  {
    AppMethodBeat.i(147507);
    super.onAttachedToWindow();
    bkI();
    AppMethodBeat.o(147507);
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(147508);
    super.onDetachedFromWindow();
    bkI();
    AppMethodBeat.o(147508);
  }
  
  public final void setBackgroundColor(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(147504);
    if (paramInt == 0)
    {
      setWillNotDraw(true);
      AppMethodBeat.o(147504);
      return;
    }
    paramInt = 0xFF000000 | paramInt;
    setWillNotDraw(false);
    super.setBackgroundColor(paramInt);
    if (this.laV != null)
    {
      this.laV.setBackgroundAlpha(1.0D);
      this.laV.setBackgroundColor(paramInt);
      if (am.XC(paramInt)) {
        break label81;
      }
    }
    for (;;)
    {
      this.laV.setForegroundStyle(bool);
      AppMethodBeat.o(147504);
      return;
      label81:
      bool = false;
    }
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(147506);
    super.setVisibility(paramInt);
    bkI();
    AppMethodBeat.o(147506);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.br
 * JD-Core Version:    0.7.0.1
 */