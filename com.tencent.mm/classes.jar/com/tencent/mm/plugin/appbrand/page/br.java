package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.g.z;
import com.tencent.luggage.m.a.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.af.i;
import com.tencent.mm.plugin.appbrand.page.capsulebar.AppBrandCapsuleBarPlaceHolderView;
import com.tencent.mm.plugin.appbrand.page.capsulebar.e;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b;
import com.tencent.mm.ui.bb;
import kotlin.g.b.s;

public final class br
  extends FrameLayout
  implements com.tencent.mm.plugin.appbrand.widget.actionbar.b.d
{
  private ad enm;
  boolean tAX;
  com.tencent.mm.plugin.appbrand.widget.actionbar.d txb;
  private b txc;
  
  public br(Context paramContext, ad paramad)
  {
    super(paramContext);
    AppMethodBeat.i(147502);
    this.tAX = false;
    this.enm = paramad;
    com.tencent.mm.plugin.appbrand.config.b.d locald = this.enm.getPageConfig();
    if (locald == null)
    {
      AppMethodBeat.o(147502);
      return;
    }
    if (locald.cky())
    {
      this.txb = new com.tencent.mm.plugin.appbrand.widget.actionbar.d(getContext());
      this.txb.setActuallyVisible(false);
      this.txc = ((b)this.enm.tvz.e(getContext(), b.class));
      this.txc.setFullscreenMode(false);
      this.txc.hZ(true);
    }
    try
    {
      paramContext = this.enm.getRuntime().qsp;
      AppBrandCapsuleBarPlaceHolderView localAppBrandCapsuleBarPlaceHolderView = this.txc.getCapsuleView();
      if (localAppBrandCapsuleBarPlaceHolderView != null)
      {
        paramad = paramContext.tCd;
        paramContext = paramad;
        if (paramad == null)
        {
          s.bIx("capsuleBarView");
          paramContext = null;
        }
        localAppBrandCapsuleBarPlaceHolderView.setFixedWidth(paramContext.getCapsuleContentAreaView().getMeasuredWidth());
      }
    }
    catch (NullPointerException paramContext)
    {
      label164:
      break label164;
    }
    cGb();
    this.txb.addView(this.txc);
    addView(this.txb, -1, -2);
    setBackgroundColor(i.dq(locald.qWk, -1));
    AppMethodBeat.o(147502);
  }
  
  private void cGc()
  {
    AppMethodBeat.i(147505);
    if (this.txc != null)
    {
      if ((getVisibility() == 0) && (z.ay(this)))
      {
        this.txc.setLoadingIconVisibility(true);
        this.txb.setActuallyVisible(true);
        AppMethodBeat.o(147505);
        return;
      }
      this.txc.setLoadingIconVisibility(false);
      this.txb.setActuallyVisible(false);
    }
    AppMethodBeat.o(147505);
  }
  
  final void cGb()
  {
    AppMethodBeat.i(147503);
    if (this.txc == null)
    {
      AppMethodBeat.o(147503);
      return;
    }
    if (!TextUtils.isEmpty(this.enm.cEC().getMainTitle())) {
      this.txc.setMainTitle(this.enm.cEC().getMainTitle());
    }
    for (;;)
    {
      this.txc.setNavHidden(this.enm.cEC().cOU());
      AppMethodBeat.o(147503);
      return;
      this.txc.setMainTitle(getContext().getString(a.g.app_brand_action_plugin_splash_loading));
    }
  }
  
  public final void kw(boolean paramBoolean)
  {
    this.tAX = paramBoolean;
  }
  
  protected final void onAttachedToWindow()
  {
    AppMethodBeat.i(147507);
    super.onAttachedToWindow();
    cGc();
    AppMethodBeat.o(147507);
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(147508);
    super.onDetachedFromWindow();
    cGc();
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
    if (this.txc != null)
    {
      this.txc.setBackgroundAlpha(1.0D);
      this.txc.setBackgroundColor(paramInt);
      if (bb.aAF(paramInt)) {
        break label81;
      }
    }
    for (;;)
    {
      this.txc.setForegroundStyle(bool);
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
    cGc();
    AppMethodBeat.o(147506);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.br
 * JD-Core Version:    0.7.0.1
 */