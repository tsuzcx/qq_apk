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
import com.tencent.mm.ui.am;

@SuppressLint({"ViewConstructor"})
public final class bm
  extends FrameLayout
  implements b.b
{
  private aa caw;
  d lCt;
  private b lCu;
  boolean lFU;
  
  public bm(Context paramContext, aa paramaa)
  {
    super(paramContext);
    AppMethodBeat.i(147502);
    this.lFU = false;
    this.caw = paramaa;
    paramContext = this.caw.getPageConfig();
    if (paramContext == null)
    {
      AppMethodBeat.o(147502);
      return;
    }
    if (paramContext.bap())
    {
      this.lCt = new d(getContext());
      this.lCt.setActuallyVisible(false);
      this.lCu = ((b)this.caw.lrk.c(getContext(), b.class));
      this.lCu.setFullscreenMode(false);
      this.lCu.hA(false);
      brw();
      this.lCt.addView(this.lCu);
      addView(this.lCt, -1, -2);
    }
    setBackgroundColor(g.cd(paramContext.jBX, -1));
    AppMethodBeat.o(147502);
  }
  
  private void brx()
  {
    AppMethodBeat.i(147505);
    if (this.lCu != null)
    {
      if ((getVisibility() == 0) && (t.aC(this)))
      {
        this.lCu.setLoadingIconVisibility(true);
        this.lCt.setActuallyVisible(true);
        AppMethodBeat.o(147505);
        return;
      }
      this.lCu.setLoadingIconVisibility(false);
      this.lCt.setActuallyVisible(false);
    }
    AppMethodBeat.o(147505);
  }
  
  final void brw()
  {
    AppMethodBeat.i(147503);
    if (this.lCu == null)
    {
      AppMethodBeat.o(147503);
      return;
    }
    if (!TextUtils.isEmpty(this.caw.bqy().getMainTitle())) {
      this.lCu.setMainTitle(this.caw.bqy().getMainTitle());
    }
    for (;;)
    {
      this.lCu.setNavHidden(this.caw.bqy().byg());
      AppMethodBeat.o(147503);
      return;
      this.lCu.setMainTitle(getContext().getString(2131755293));
    }
  }
  
  public final void he(boolean paramBoolean)
  {
    this.lFU = paramBoolean;
  }
  
  protected final void onAttachedToWindow()
  {
    AppMethodBeat.i(147507);
    super.onAttachedToWindow();
    brx();
    AppMethodBeat.o(147507);
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(147508);
    super.onDetachedFromWindow();
    brx();
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
    if (this.lCu != null)
    {
      this.lCu.setBackgroundAlpha(1.0D);
      this.lCu.setBackgroundColor(paramInt);
      if (am.ZN(paramInt)) {
        break label81;
      }
    }
    for (;;)
    {
      this.lCu.setForegroundStyle(bool);
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
    brx();
    AppMethodBeat.o(147506);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.bm
 * JD-Core Version:    0.7.0.1
 */