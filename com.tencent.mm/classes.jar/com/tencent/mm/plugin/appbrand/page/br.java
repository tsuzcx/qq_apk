package com.tencent.mm.plugin.appbrand.page;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.g.w;
import com.tencent.luggage.l.a.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.page.capsulebar.AppBrandCapsuleBarPlaceHolderView;
import com.tencent.mm.plugin.appbrand.page.capsulebar.e;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b;
import com.tencent.mm.ui.au;
import kotlin.g.b.p;

@SuppressLint({"ViewConstructor"})
public final class br
  extends FrameLayout
  implements com.tencent.mm.plugin.appbrand.widget.actionbar.b.d
{
  private ad cvo;
  com.tencent.mm.plugin.appbrand.widget.actionbar.d qsx;
  private b qsy;
  boolean qwi;
  
  public br(Context paramContext, ad paramad)
  {
    super(paramContext);
    AppMethodBeat.i(147502);
    this.qwi = false;
    this.cvo = paramad;
    paramContext = this.cvo.getPageConfig();
    if (paramContext == null)
    {
      AppMethodBeat.o(147502);
      return;
    }
    if (paramContext.bLa())
    {
      this.qsx = new com.tencent.mm.plugin.appbrand.widget.actionbar.d(getContext());
      this.qsx.setActuallyVisible(false);
      this.qsy = ((b)this.cvo.qqW.d(getContext(), b.class));
      this.qsy.setFullscreenMode(false);
      this.qsy.hk(true);
    }
    try
    {
      Object localObject = this.cvo.getRuntime().ntG;
      paramad = this.qsy.getCapsuleView();
      if (paramad != null)
      {
        localObject = ((e)localObject).qxe;
        if (localObject == null) {
          p.bGy("capsuleBarView");
        }
        localObject = ((com.tencent.mm.plugin.appbrand.page.capsulebar.d)localObject).getCapsuleContentAreaView();
        p.j(localObject, "this.capsuleBarView.capsuleContentAreaView");
        paramad.setFixedWidth(((View)localObject).getMeasuredWidth());
      }
    }
    catch (NullPointerException paramad)
    {
      label165:
      break label165;
    }
    cfo();
    this.qsx.addView(this.qsy);
    addView(this.qsx, -1, -2);
    setBackgroundColor(g.cO(paramContext.nWx, -1));
    AppMethodBeat.o(147502);
  }
  
  private void cfp()
  {
    AppMethodBeat.i(147505);
    if (this.qsy != null)
    {
      if ((getVisibility() == 0) && (w.al(this)))
      {
        this.qsy.setLoadingIconVisibility(true);
        this.qsx.setActuallyVisible(true);
        AppMethodBeat.o(147505);
        return;
      }
      this.qsy.setLoadingIconVisibility(false);
      this.qsx.setActuallyVisible(false);
    }
    AppMethodBeat.o(147505);
  }
  
  final void cfo()
  {
    AppMethodBeat.i(147503);
    if (this.qsy == null)
    {
      AppMethodBeat.o(147503);
      return;
    }
    if (!TextUtils.isEmpty(this.cvo.cdY().getMainTitle())) {
      this.qsy.setMainTitle(this.cvo.cdY().getMainTitle());
    }
    for (;;)
    {
      this.qsy.setNavHidden(this.cvo.cdY().cnb());
      AppMethodBeat.o(147503);
      return;
      this.qsy.setMainTitle(getContext().getString(a.g.app_brand_action_plugin_splash_loading));
    }
  }
  
  public final void jl(boolean paramBoolean)
  {
    this.qwi = paramBoolean;
  }
  
  protected final void onAttachedToWindow()
  {
    AppMethodBeat.i(147507);
    super.onAttachedToWindow();
    cfp();
    AppMethodBeat.o(147507);
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(147508);
    super.onDetachedFromWindow();
    cfp();
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
    if (this.qsy != null)
    {
      this.qsy.setBackgroundAlpha(1.0D);
      this.qsy.setBackgroundColor(paramInt);
      if (au.auk(paramInt)) {
        break label81;
      }
    }
    for (;;)
    {
      this.qsy.setForegroundStyle(bool);
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
    cfp();
    AppMethodBeat.o(147506);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.br
 * JD-Core Version:    0.7.0.1
 */