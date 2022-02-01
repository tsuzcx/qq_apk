package com.tencent.mm.plugin.appbrand.page;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.view.t;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.a.d;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b.b;
import com.tencent.mm.plugin.appbrand.widget.actionbar.d;
import com.tencent.mm.plugin.appbrand.z.g;
import com.tencent.mm.ui.ao;

@SuppressLint({"ViewConstructor"})
public final class bm
  extends FrameLayout
  implements b.b
{
  private aa ckN;
  d mbU;
  private b mbV;
  boolean mfy;
  
  public bm(Context paramContext, aa paramaa)
  {
    super(paramContext);
    AppMethodBeat.i(147502);
    this.mfy = false;
    this.ckN = paramaa;
    paramContext = this.ckN.getPageConfig();
    if (paramContext == null)
    {
      AppMethodBeat.o(147502);
      return;
    }
    if (paramContext.bdO())
    {
      this.mbU = new d(getContext());
      this.mbU.setActuallyVisible(false);
      this.mbV = ((b)this.ckN.lQu.c(getContext(), b.class));
      this.mbV.setFullscreenMode(false);
      this.mbV.hK(false);
      bvx();
      this.mbU.addView(this.mbV);
      addView(this.mbU, -1, -2);
    }
    setBackgroundColor(g.cg(paramContext.jVX, -1));
    AppMethodBeat.o(147502);
  }
  
  private void bvy()
  {
    AppMethodBeat.i(147505);
    if (this.mbV != null)
    {
      if ((getVisibility() == 0) && (t.aC(this)))
      {
        this.mbV.setLoadingIconVisibility(true);
        this.mbU.setActuallyVisible(true);
        AppMethodBeat.o(147505);
        return;
      }
      this.mbV.setLoadingIconVisibility(false);
      this.mbU.setActuallyVisible(false);
    }
    AppMethodBeat.o(147505);
  }
  
  final void bvx()
  {
    AppMethodBeat.i(147503);
    if (this.mbV == null)
    {
      AppMethodBeat.o(147503);
      return;
    }
    if (!TextUtils.isEmpty(this.ckN.bux().getMainTitle())) {
      this.mbV.setMainTitle(this.ckN.bux().getMainTitle());
    }
    for (;;)
    {
      this.mbV.setNavHidden(this.ckN.bux().bCm());
      AppMethodBeat.o(147503);
      return;
      this.mbV.setMainTitle(getContext().getString(2131755293));
    }
  }
  
  public final void hm(boolean paramBoolean)
  {
    this.mfy = paramBoolean;
  }
  
  protected final void onAttachedToWindow()
  {
    AppMethodBeat.i(147507);
    super.onAttachedToWindow();
    bvy();
    AppMethodBeat.o(147507);
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(147508);
    super.onDetachedFromWindow();
    bvy();
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
    if (this.mbV != null)
    {
      this.mbV.setBackgroundAlpha(1.0D);
      this.mbV.setBackgroundColor(paramInt);
      if (ao.abX(paramInt)) {
        break label81;
      }
    }
    for (;;)
    {
      this.mbV.setForegroundStyle(bool);
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
    bvy();
    AppMethodBeat.o(147506);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.bm
 * JD-Core Version:    0.7.0.1
 */