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
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.ui.base.MMDotView;

public class AppBrandSmileyPanelBase
  extends LinearLayout
  implements ViewPager.OnPageChangeListener, AppBrandSmileyViewPager.b
{
  private Activity mActivity;
  private View mContentView;
  private boolean mFh;
  private c mHC;
  private f mHO;
  private AppBrandSmileyViewPager mHP;
  private MMDotView mHQ;
  private boolean mHR;
  
  public AppBrandSmileyPanelBase(Context paramContext)
  {
    super(paramContext, null);
    AppMethodBeat.i(49941);
    this.mFh = false;
    this.mContentView = null;
    this.mHP = null;
    this.mHR = true;
    init();
    AppMethodBeat.o(49941);
  }
  
  public AppBrandSmileyPanelBase(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(49942);
    this.mFh = false;
    this.mContentView = null;
    this.mHP = null;
    this.mHR = true;
    init();
    AppMethodBeat.o(49942);
  }
  
  private void bBc()
  {
    AppMethodBeat.i(49950);
    this.mContentView.setVisibility(0);
    AppMethodBeat.o(49950);
  }
  
  private void bBd()
  {
    AppMethodBeat.i(49952);
    if (this.mHQ == null)
    {
      AppMethodBeat.o(49952);
      return;
    }
    boolean bool = i.iA(getContext());
    RelativeLayout.LayoutParams localLayoutParams;
    if (bool != this.mHR)
    {
      if (!bool) {
        break label106;
      }
      this.mHQ.setPadding(0, 0, 0, getContext().getResources().getDimensionPixelSize(2131165500));
      localLayoutParams = (RelativeLayout.LayoutParams)this.mHQ.getLayoutParams();
      localLayoutParams.bottomMargin = getContext().getResources().getDimensionPixelSize(2131166250);
      this.mHQ.setLayoutParams(localLayoutParams);
    }
    for (;;)
    {
      this.mHR = bool;
      AppMethodBeat.o(49952);
      return;
      label106:
      this.mHQ.setPadding(0, 0, 0, getContext().getResources().getDimensionPixelSize(2131165490));
      localLayoutParams = (RelativeLayout.LayoutParams)this.mHQ.getLayoutParams();
      localLayoutParams.bottomMargin = 0;
      this.mHQ.setLayoutParams(localLayoutParams);
    }
  }
  
  private void init()
  {
    AppMethodBeat.i(49946);
    this.mActivity = com.tencent.mm.sdk.f.a.jg(getContext());
    this.mHC = bAx();
    this.mHC.mHB = getContext();
    this.mHC.mHU = this.mHO;
    AppMethodBeat.o(49946);
  }
  
  public final void bAZ()
  {
    AppMethodBeat.i(49937);
    if (this.mHP == null)
    {
      AppMethodBeat.o(49937);
      return;
    }
    this.mHC.mHR = i.iA(getContext());
    AppBrandSmileyViewPager.a locala = (AppBrandSmileyViewPager.a)this.mHP.getAdapter();
    if (locala != null)
    {
      locala.mIb.clear();
      locala.mHC = this.mHC;
      locala.notifyDataSetChanged();
    }
    for (;;)
    {
      this.mHP.post(new Runnable()
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
      locala.mHC = this.mHC;
      this.mHP.setAdapter(locala);
    }
  }
  
  protected c bAx()
  {
    AppMethodBeat.i(49947);
    c localc = new c();
    AppMethodBeat.o(49947);
    return localc;
  }
  
  public final void bBa()
  {
    AppMethodBeat.i(49944);
    if (this.mContentView != null) {
      this.mContentView.setVisibility(0);
    }
    AppMethodBeat.o(49944);
  }
  
  public final void bBb()
  {
    AppMethodBeat.i(49945);
    if (this.mContentView != null) {
      this.mContentView.setVisibility(4);
    }
    AppMethodBeat.o(49945);
  }
  
  @SuppressLint({"WrongCall"})
  protected final void ex(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(49940);
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(49940);
  }
  
  protected final c getManager()
  {
    return this.mHC;
  }
  
  protected final void initView()
  {
    AppMethodBeat.i(49951);
    if ((this.mContentView != null) && (getChildCount() > 0))
    {
      bBc();
      AppMethodBeat.o(49951);
      return;
    }
    if (this.mContentView == null) {
      this.mContentView = View.inflate(ai.getContext(), 2131493106, null);
    }
    for (;;)
    {
      this.mHP = ((AppBrandSmileyViewPager)this.mContentView.findViewById(2131304873));
      this.mHP.setOnPageChangeListener(this);
      this.mHP.setPanelManager(this.mHC);
      this.mHP.setOnSizeChangedListener(this);
      this.mHQ = ((MMDotView)this.mContentView.findViewById(2131304870));
      this.mHQ.setDotCount(1);
      bBd();
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
    c localc = this.mHC;
    localc.mHT = null;
    localc.mHB = null;
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
    if (this.mFh)
    {
      super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(0, -2147483648));
      AppMethodBeat.o(49939);
      return;
    }
    i.iA(getContext());
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(49939);
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    AppMethodBeat.i(49936);
    a locala = this.mHC.bBe();
    int i = locala.getPageCount();
    int j = locala.mHD;
    if (i <= 1)
    {
      this.mHQ.setVisibility(4);
      AppMethodBeat.o(49936);
      return;
    }
    this.mHQ.setVisibility(0);
    this.mHQ.setDotCount(i);
    this.mHQ.setSelectedDot(paramInt - j);
    AppMethodBeat.o(49936);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(49938);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    bBd();
    AppMethodBeat.o(49938);
  }
  
  public void setOnTextOperationListener(f paramf)
  {
    this.mHO = paramf;
    this.mHC.mHU = this.mHO;
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(49948);
    if (paramInt == 0) {}
    for (this.mFh = false;; this.mFh = true)
    {
      super.setVisibility(paramInt);
      if (!this.mFh)
      {
        b.F(this.mActivity);
        initView();
      }
      AppMethodBeat.o(49948);
      return;
    }
  }
  
  protected final void vQ(int paramInt)
  {
    AppMethodBeat.i(49949);
    super.setVisibility(paramInt);
    AppMethodBeat.o(49949);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.panel.AppBrandSmileyPanelBase
 * JD-Core Version:    0.7.0.1
 */