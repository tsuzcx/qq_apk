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
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.ui.base.MMDotView;

public class AppBrandSmileyPanelBase
  extends LinearLayout
  implements ViewPager.OnPageChangeListener, AppBrandSmileyViewPager.b
{
  private Activity mActivity;
  private View mContentView;
  private boolean ouu;
  private c owP;
  private f oxa;
  private AppBrandSmileyViewPager oxb;
  private MMDotView oxc;
  private boolean oxd;
  
  public AppBrandSmileyPanelBase(Context paramContext)
  {
    super(paramContext, null);
    AppMethodBeat.i(49941);
    this.ouu = false;
    this.mContentView = null;
    this.oxb = null;
    this.oxd = true;
    init();
    AppMethodBeat.o(49941);
  }
  
  public AppBrandSmileyPanelBase(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(49942);
    this.ouu = false;
    this.mContentView = null;
    this.oxb = null;
    this.oxd = true;
    init();
    AppMethodBeat.o(49942);
  }
  
  private void ccm()
  {
    AppMethodBeat.i(49950);
    this.mContentView.setVisibility(0);
    AppMethodBeat.o(49950);
  }
  
  private void ccn()
  {
    AppMethodBeat.i(49952);
    if (this.oxc == null)
    {
      AppMethodBeat.o(49952);
      return;
    }
    boolean bool = i.isPortOrientation(getContext());
    RelativeLayout.LayoutParams localLayoutParams;
    if (bool != this.oxd)
    {
      if (!bool) {
        break label106;
      }
      this.oxc.setPadding(0, 0, 0, getContext().getResources().getDimensionPixelSize(2131165518));
      localLayoutParams = (RelativeLayout.LayoutParams)this.oxc.getLayoutParams();
      localLayoutParams.bottomMargin = getContext().getResources().getDimensionPixelSize(2131166293);
      this.oxc.setLayoutParams(localLayoutParams);
    }
    for (;;)
    {
      this.oxd = bool;
      AppMethodBeat.o(49952);
      return;
      label106:
      this.oxc.setPadding(0, 0, 0, getContext().getResources().getDimensionPixelSize(2131165508));
      localLayoutParams = (RelativeLayout.LayoutParams)this.oxc.getLayoutParams();
      localLayoutParams.bottomMargin = 0;
      this.oxc.setLayoutParams(localLayoutParams);
    }
  }
  
  private void init()
  {
    AppMethodBeat.i(49946);
    this.mActivity = AndroidContextUtil.castActivityOrNull(getContext());
    this.owP = cbG();
    this.owP.owO = getContext();
    this.owP.oxg = this.oxa;
    AppMethodBeat.o(49946);
  }
  
  protected final void Ai(int paramInt)
  {
    AppMethodBeat.i(49949);
    super.setVisibility(paramInt);
    AppMethodBeat.o(49949);
  }
  
  protected c cbG()
  {
    AppMethodBeat.i(49947);
    c localc = new c();
    AppMethodBeat.o(49947);
    return localc;
  }
  
  public final void ccj()
  {
    AppMethodBeat.i(49937);
    if (this.oxb == null)
    {
      AppMethodBeat.o(49937);
      return;
    }
    this.owP.oxd = i.isPortOrientation(getContext());
    AppBrandSmileyViewPager.a locala = (AppBrandSmileyViewPager.a)this.oxb.getAdapter();
    if (locala != null)
    {
      locala.oxn.clear();
      locala.owP = this.owP;
      locala.notifyDataSetChanged();
    }
    for (;;)
    {
      this.oxb.post(new Runnable()
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
      locala.owP = this.owP;
      this.oxb.setAdapter(locala);
    }
  }
  
  public final void cck()
  {
    AppMethodBeat.i(49944);
    if (this.mContentView != null) {
      this.mContentView.setVisibility(0);
    }
    AppMethodBeat.o(49944);
  }
  
  public final void ccl()
  {
    AppMethodBeat.i(49945);
    if (this.mContentView != null) {
      this.mContentView.setVisibility(4);
    }
    AppMethodBeat.o(49945);
  }
  
  @SuppressLint({"WrongCall"})
  protected final void eM(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(49940);
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(49940);
  }
  
  protected final c getManager()
  {
    return this.owP;
  }
  
  protected final void initView()
  {
    AppMethodBeat.i(49951);
    if ((this.mContentView != null) && (getChildCount() > 0))
    {
      ccm();
      AppMethodBeat.o(49951);
      return;
    }
    if (this.mContentView == null) {
      this.mContentView = View.inflate(MMApplicationContext.getContext(), 2131493148, null);
    }
    for (;;)
    {
      this.oxb = ((AppBrandSmileyViewPager)this.mContentView.findViewById(2131307959));
      this.oxb.setOnPageChangeListener(this);
      this.oxb.setPanelManager(this.owP);
      this.oxb.setOnSizeChangedListener(this);
      this.oxc = ((MMDotView)this.mContentView.findViewById(2131307956));
      this.oxc.setDotCount(1);
      ccn();
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
    c localc = this.owP;
    localc.oxf = null;
    localc.owO = null;
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
    if (this.ouu)
    {
      super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(0, -2147483648));
      AppMethodBeat.o(49939);
      return;
    }
    i.isPortOrientation(getContext());
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(49939);
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    AppMethodBeat.i(49936);
    a locala = this.owP.cco();
    int i = locala.getPageCount();
    int j = locala.owQ;
    if (i <= 1)
    {
      this.oxc.setVisibility(4);
      AppMethodBeat.o(49936);
      return;
    }
    this.oxc.setVisibility(0);
    this.oxc.setDotCount(i);
    this.oxc.setSelectedDot(paramInt - j);
    AppMethodBeat.o(49936);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(49938);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    ccn();
    AppMethodBeat.o(49938);
  }
  
  public void setOnTextOperationListener(f paramf)
  {
    this.oxa = paramf;
    this.owP.oxg = this.oxa;
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(49948);
    if (paramInt == 0) {}
    for (this.ouu = false;; this.ouu = true)
    {
      super.setVisibility(paramInt);
      if (!this.ouu)
      {
        b.G(this.mActivity);
        initView();
      }
      AppMethodBeat.o(49948);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.panel.AppBrandSmileyPanelBase
 * JD-Core Version:    0.7.0.1
 */