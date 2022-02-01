package com.tencent.mm.plugin.appbrand.widget.input.panel;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.i;
import com.tencent.mm.plugin.appbrand.ui.b;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.ui.base.MMDotView;

public class AppBrandSmileyPanelBase
  extends LinearLayout
  implements ViewPager.OnPageChangeListener, AppBrandSmileyViewPager.b
{
  private Activity mActivity;
  private View mContentView;
  private boolean mdi;
  private c mfD;
  private f mfP;
  private AppBrandSmileyViewPager mfQ;
  private MMDotView mfR;
  private boolean mfS;
  
  public AppBrandSmileyPanelBase(Context paramContext)
  {
    super(paramContext, null);
    AppMethodBeat.i(49941);
    this.mdi = false;
    this.mContentView = null;
    this.mfQ = null;
    this.mfS = true;
    init();
    AppMethodBeat.o(49941);
  }
  
  public AppBrandSmileyPanelBase(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(49942);
    this.mdi = false;
    this.mContentView = null;
    this.mfQ = null;
    this.mfS = true;
    init();
    AppMethodBeat.o(49942);
  }
  
  private void bud()
  {
    AppMethodBeat.i(49950);
    this.mContentView.setVisibility(0);
    AppMethodBeat.o(49950);
  }
  
  private void bue()
  {
    AppMethodBeat.i(49952);
    if (this.mfR == null)
    {
      AppMethodBeat.o(49952);
      return;
    }
    boolean bool = i.ip(getContext());
    RelativeLayout.LayoutParams localLayoutParams;
    if (bool != this.mfS)
    {
      if (!bool) {
        break label106;
      }
      this.mfR.setPadding(0, 0, 0, getContext().getResources().getDimensionPixelSize(2131165500));
      localLayoutParams = (RelativeLayout.LayoutParams)this.mfR.getLayoutParams();
      localLayoutParams.bottomMargin = getContext().getResources().getDimensionPixelSize(2131166250);
      this.mfR.setLayoutParams(localLayoutParams);
    }
    for (;;)
    {
      this.mfS = bool;
      AppMethodBeat.o(49952);
      return;
      label106:
      this.mfR.setPadding(0, 0, 0, getContext().getResources().getDimensionPixelSize(2131165490));
      localLayoutParams = (RelativeLayout.LayoutParams)this.mfR.getLayoutParams();
      localLayoutParams.bottomMargin = 0;
      this.mfR.setLayoutParams(localLayoutParams);
    }
  }
  
  private void init()
  {
    AppMethodBeat.i(49946);
    this.mActivity = com.tencent.mm.sdk.f.a.iV(getContext());
    this.mfD = btx();
    this.mfD.mfC = getContext();
    this.mfD.mfV = this.mfP;
    AppMethodBeat.o(49946);
  }
  
  protected c btx()
  {
    AppMethodBeat.i(49947);
    c localc = new c();
    AppMethodBeat.o(49947);
    return localc;
  }
  
  public final void bua()
  {
    AppMethodBeat.i(49937);
    if (this.mfQ == null)
    {
      AppMethodBeat.o(49937);
      return;
    }
    this.mfD.mfS = i.ip(getContext());
    AppBrandSmileyViewPager.a locala = (AppBrandSmileyViewPager.a)this.mfQ.getAdapter();
    if (locala != null)
    {
      locala.mgc.clear();
      locala.mfD = this.mfD;
      locala.notifyDataSetChanged();
    }
    for (;;)
    {
      this.mfQ.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(49935);
          AppBrandSmileyPanelBase.this.onPageSelected(AppBrandSmileyPanelBase.a(AppBrandSmileyPanelBase.this).getCurrentItem());
          AppMethodBeat.o(49935);
        }
      });
      AppMethodBeat.o(49937);
      return;
      locala = new AppBrandSmileyViewPager.a();
      locala.mfD = this.mfD;
      this.mfQ.setAdapter(locala);
    }
  }
  
  public final void bub()
  {
    AppMethodBeat.i(49944);
    if (this.mContentView != null) {
      this.mContentView.setVisibility(0);
    }
    AppMethodBeat.o(49944);
  }
  
  public final void buc()
  {
    AppMethodBeat.i(49945);
    if (this.mContentView != null) {
      this.mContentView.setVisibility(4);
    }
    AppMethodBeat.o(49945);
  }
  
  @SuppressLint({"WrongCall"})
  protected final void eu(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(49940);
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(49940);
  }
  
  protected final c getManager()
  {
    return this.mfD;
  }
  
  protected final void initView()
  {
    AppMethodBeat.i(49951);
    if ((this.mContentView != null) && (getChildCount() > 0))
    {
      bud();
      AppMethodBeat.o(49951);
      return;
    }
    if (this.mContentView == null) {
      this.mContentView = View.inflate(aj.getContext(), 2131493106, null);
    }
    for (;;)
    {
      this.mfQ = ((AppBrandSmileyViewPager)this.mContentView.findViewById(2131304873));
      this.mfQ.setOnPageChangeListener(this);
      this.mfQ.setPanelManager(this.mfD);
      this.mfQ.setOnSizeChangedListener(this);
      this.mfR = ((MMDotView)this.mContentView.findViewById(2131304870));
      this.mfR.setDotCount(1);
      bue();
      addView(this.mContentView, new LinearLayout.LayoutParams(-1, -1));
      AppMethodBeat.o(49951);
      return;
      if (this.mContentView.getParent() != null) {
        ((ViewGroup)this.mContentView.getParent()).removeView(this.mContentView);
      }
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(49943);
    c localc = this.mfD;
    localc.mfU = null;
    localc.mfC = null;
    if (this.mContentView != null)
    {
      ((ViewGroup)this.mContentView.getParent()).removeView(this.mContentView);
      ((ViewGroup)this.mContentView).removeAllViews();
      this.mContentView = null;
    }
    this.mActivity = null;
    AppMethodBeat.o(49943);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(49939);
    if (this.mdi)
    {
      super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(0, -2147483648));
      AppMethodBeat.o(49939);
      return;
    }
    i.ip(getContext());
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(49939);
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    AppMethodBeat.i(49936);
    a locala = this.mfD.buf();
    int i = locala.getPageCount();
    int j = locala.mfE;
    if (i <= 1)
    {
      this.mfR.setVisibility(4);
      AppMethodBeat.o(49936);
      return;
    }
    this.mfR.setVisibility(0);
    this.mfR.setDotCount(i);
    this.mfR.setSelectedDot(paramInt - j);
    AppMethodBeat.o(49936);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(49938);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    bue();
    AppMethodBeat.o(49938);
  }
  
  public void setOnTextOperationListener(f paramf)
  {
    this.mfP = paramf;
    this.mfD.mfV = this.mfP;
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(49948);
    if (paramInt == 0) {}
    for (this.mdi = false;; this.mdi = true)
    {
      super.setVisibility(paramInt);
      if (!this.mdi)
      {
        b.F(this.mActivity);
        initView();
      }
      AppMethodBeat.o(49948);
      return;
    }
  }
  
  protected final void uZ(int paramInt)
  {
    AppMethodBeat.i(49949);
    super.setVisibility(paramInt);
    AppMethodBeat.o(49949);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.panel.AppBrandSmileyPanelBase
 * JD-Core Version:    0.7.0.1
 */