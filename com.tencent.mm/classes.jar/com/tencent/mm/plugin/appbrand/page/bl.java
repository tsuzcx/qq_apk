package com.tencent.mm.plugin.appbrand.page;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.view.t;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.a.d;
import com.tencent.mm.plugin.appbrand.page.capsulebar.AppBrandCapsuleBarPlaceHolderView;
import com.tencent.mm.plugin.appbrand.page.capsulebar.e;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b.c;
import com.tencent.mm.plugin.appbrand.y.g;
import com.tencent.mm.ui.ao;
import d.g.b.p;

@SuppressLint({"ViewConstructor"})
public final class bl
  extends FrameLayout
  implements b.c
{
  private z ckP;
  com.tencent.mm.plugin.appbrand.widget.actionbar.d mgn;
  private b mgo;
  boolean mjT;
  
  public bl(Context paramContext, z paramz)
  {
    super(paramContext);
    AppMethodBeat.i(147502);
    this.mjT = false;
    this.ckP = paramz;
    paramContext = this.ckP.getPageConfig();
    if (paramContext == null)
    {
      AppMethodBeat.o(147502);
      return;
    }
    if (paramContext.beu())
    {
      this.mgn = new com.tencent.mm.plugin.appbrand.widget.actionbar.d(getContext());
      this.mgn.setActuallyVisible(false);
      this.mgo = ((b)this.ckP.lUV.c(getContext(), b.class));
      this.mgo.setFullscreenMode(false);
      this.mgo.fE(true);
    }
    try
    {
      Object localObject = this.ckP.getRuntime().jzJ;
      paramz = this.mgo.getCapsuleView();
      if (paramz != null)
      {
        localObject = ((e)localObject).mkL;
        if (localObject == null) {
          p.bdF("capsuleBarView");
        }
        localObject = ((com.tencent.mm.plugin.appbrand.page.capsulebar.d)localObject).getCapsuleContentAreaView();
        p.g(localObject, "this.capsuleBarView.capsuleContentAreaView");
        paramz.setFixedWidth(((View)localObject).getMeasuredWidth());
      }
    }
    catch (NullPointerException paramz)
    {
      label165:
      break label165;
    }
    bwi();
    this.mgn.addView(this.mgo);
    addView(this.mgn, -1, -2);
    setBackgroundColor(g.ck(paramContext.jZm, -1));
    AppMethodBeat.o(147502);
  }
  
  private void bwj()
  {
    AppMethodBeat.i(147505);
    if (this.mgo != null)
    {
      if ((getVisibility() == 0) && (t.aC(this)))
      {
        this.mgo.setLoadingIconVisibility(true);
        this.mgn.setActuallyVisible(true);
        AppMethodBeat.o(147505);
        return;
      }
      this.mgo.setLoadingIconVisibility(false);
      this.mgn.setActuallyVisible(false);
    }
    AppMethodBeat.o(147505);
  }
  
  final void bwi()
  {
    AppMethodBeat.i(147503);
    if (this.mgo == null)
    {
      AppMethodBeat.o(147503);
      return;
    }
    if (!TextUtils.isEmpty(this.ckP.bvi().getMainTitle())) {
      this.mgo.setMainTitle(this.ckP.bvi().getMainTitle());
    }
    for (;;)
    {
      this.mgo.setNavHidden(this.ckP.bvi().bDe());
      AppMethodBeat.o(147503);
      return;
      this.mgo.setMainTitle(getContext().getString(2131755293));
    }
  }
  
  public final void hn(boolean paramBoolean)
  {
    this.mjT = paramBoolean;
  }
  
  protected final void onAttachedToWindow()
  {
    AppMethodBeat.i(147507);
    super.onAttachedToWindow();
    bwj();
    AppMethodBeat.o(147507);
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(147508);
    super.onDetachedFromWindow();
    bwj();
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
    if (this.mgo != null)
    {
      this.mgo.setBackgroundAlpha(1.0D);
      this.mgo.setBackgroundColor(paramInt);
      if (ao.acF(paramInt)) {
        break label81;
      }
    }
    for (;;)
    {
      this.mgo.setForegroundStyle(bool);
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
    bwj();
    AppMethodBeat.o(147506);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.bl
 * JD-Core Version:    0.7.0.1
 */