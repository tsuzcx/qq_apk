package com.tencent.mm.plugin.appbrand.page;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.view.u;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.page.capsulebar.AppBrandCapsuleBarPlaceHolderView;
import com.tencent.mm.plugin.appbrand.page.capsulebar.e;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b;
import com.tencent.mm.ui.ar;
import kotlin.g.b.p;

@SuppressLint({"ViewConstructor"})
public final class bp
  extends FrameLayout
  implements com.tencent.mm.plugin.appbrand.widget.actionbar.b.d
{
  private ac cwK;
  com.tencent.mm.plugin.appbrand.widget.actionbar.d nqL;
  private b nqM;
  boolean nuo;
  
  public bp(Context paramContext, ac paramac)
  {
    super(paramContext);
    AppMethodBeat.i(147502);
    this.nuo = false;
    this.cwK = paramac;
    paramContext = this.cwK.getPageConfig();
    if (paramContext == null)
    {
      AppMethodBeat.o(147502);
      return;
    }
    if (paramContext.bzL())
    {
      this.nqL = new com.tencent.mm.plugin.appbrand.widget.actionbar.d(getContext());
      this.nqL.setActuallyVisible(false);
      this.nqM = ((b)this.cwK.npk.d(getContext(), b.class));
      this.nqM.setFullscreenMode(false);
      this.nqM.gz(true);
    }
    try
    {
      Object localObject = this.cwK.getRuntime().kAx;
      paramac = this.nqM.getCapsuleView();
      if (paramac != null)
      {
        localObject = ((e)localObject).nvi;
        if (localObject == null) {
          p.btv("capsuleBarView");
        }
        localObject = ((com.tencent.mm.plugin.appbrand.page.capsulebar.d)localObject).getCapsuleContentAreaView();
        p.g(localObject, "this.capsuleBarView.capsuleContentAreaView");
        paramac.setFixedWidth(((View)localObject).getMeasuredWidth());
      }
    }
    catch (NullPointerException paramac)
    {
      label165:
      break label165;
    }
    bSo();
    this.nqL.addView(this.nqM);
    addView(this.nqL, -1, -2);
    setBackgroundColor(g.cu(paramContext.lco, -1));
    AppMethodBeat.o(147502);
  }
  
  private void bSp()
  {
    AppMethodBeat.i(147505);
    if (this.nqM != null)
    {
      if ((getVisibility() == 0) && (u.aD(this)))
      {
        this.nqM.setLoadingIconVisibility(true);
        this.nqL.setActuallyVisible(true);
        AppMethodBeat.o(147505);
        return;
      }
      this.nqM.setLoadingIconVisibility(false);
      this.nqL.setActuallyVisible(false);
    }
    AppMethodBeat.o(147505);
  }
  
  final void bSo()
  {
    AppMethodBeat.i(147503);
    if (this.nqM == null)
    {
      AppMethodBeat.o(147503);
      return;
    }
    if (!TextUtils.isEmpty(this.cwK.bRi().getMainTitle())) {
      this.nqM.setMainTitle(this.cwK.bRi().getMainTitle());
    }
    for (;;)
    {
      this.nqM.setNavHidden(this.cwK.bRi().cae());
      AppMethodBeat.o(147503);
      return;
      this.nqM.setMainTitle(getContext().getString(2131755329));
    }
  }
  
  public final void io(boolean paramBoolean)
  {
    this.nuo = paramBoolean;
  }
  
  protected final void onAttachedToWindow()
  {
    AppMethodBeat.i(147507);
    super.onAttachedToWindow();
    bSp();
    AppMethodBeat.o(147507);
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(147508);
    super.onDetachedFromWindow();
    bSp();
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
    if (this.nqM != null)
    {
      this.nqM.setBackgroundAlpha(1.0D);
      this.nqM.setBackgroundColor(paramInt);
      if (ar.aln(paramInt)) {
        break label81;
      }
    }
    for (;;)
    {
      this.nqM.setForegroundStyle(bool);
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
    bSp();
    AppMethodBeat.o(147506);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.bp
 * JD-Core Version:    0.7.0.1
 */