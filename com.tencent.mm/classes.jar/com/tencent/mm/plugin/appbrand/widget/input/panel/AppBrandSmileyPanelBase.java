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
  private boolean nfF;
  private c nia;
  private f nim;
  private AppBrandSmileyViewPager nin;
  private MMDotView nio;
  private boolean nip;
  
  public AppBrandSmileyPanelBase(Context paramContext)
  {
    super(paramContext, null);
    AppMethodBeat.i(49941);
    this.nfF = false;
    this.mContentView = null;
    this.nin = null;
    this.nip = true;
    init();
    AppMethodBeat.o(49941);
  }
  
  public AppBrandSmileyPanelBase(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(49942);
    this.nfF = false;
    this.mContentView = null;
    this.nin = null;
    this.nip = true;
    init();
    AppMethodBeat.o(49942);
  }
  
  private void bFe()
  {
    AppMethodBeat.i(49950);
    this.mContentView.setVisibility(0);
    AppMethodBeat.o(49950);
  }
  
  private void bFf()
  {
    AppMethodBeat.i(49952);
    if (this.nio == null)
    {
      AppMethodBeat.o(49952);
      return;
    }
    boolean bool = i.iK(getContext());
    RelativeLayout.LayoutParams localLayoutParams;
    if (bool != this.nip)
    {
      if (!bool) {
        break label106;
      }
      this.nio.setPadding(0, 0, 0, getContext().getResources().getDimensionPixelSize(2131165500));
      localLayoutParams = (RelativeLayout.LayoutParams)this.nio.getLayoutParams();
      localLayoutParams.bottomMargin = getContext().getResources().getDimensionPixelSize(2131166250);
      this.nio.setLayoutParams(localLayoutParams);
    }
    for (;;)
    {
      this.nip = bool;
      AppMethodBeat.o(49952);
      return;
      label106:
      this.nio.setPadding(0, 0, 0, getContext().getResources().getDimensionPixelSize(2131165490));
      localLayoutParams = (RelativeLayout.LayoutParams)this.nio.getLayoutParams();
      localLayoutParams.bottomMargin = 0;
      this.nio.setLayoutParams(localLayoutParams);
    }
  }
  
  private void init()
  {
    AppMethodBeat.i(49946);
    this.mActivity = com.tencent.mm.sdk.f.a.jq(getContext());
    this.nia = bEz();
    this.nia.nhZ = getContext();
    this.nia.nis = this.nim;
    AppMethodBeat.o(49946);
  }
  
  protected c bEz()
  {
    AppMethodBeat.i(49947);
    c localc = new c();
    AppMethodBeat.o(49947);
    return localc;
  }
  
  public final void bFb()
  {
    AppMethodBeat.i(49937);
    if (this.nin == null)
    {
      AppMethodBeat.o(49937);
      return;
    }
    this.nia.nip = i.iK(getContext());
    AppBrandSmileyViewPager.a locala = (AppBrandSmileyViewPager.a)this.nin.getAdapter();
    if (locala != null)
    {
      locala.niz.clear();
      locala.nia = this.nia;
      locala.notifyDataSetChanged();
    }
    for (;;)
    {
      this.nin.post(new Runnable()
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
      locala.nia = this.nia;
      this.nin.setAdapter(locala);
    }
  }
  
  public final void bFc()
  {
    AppMethodBeat.i(49944);
    if (this.mContentView != null) {
      this.mContentView.setVisibility(0);
    }
    AppMethodBeat.o(49944);
  }
  
  public final void bFd()
  {
    AppMethodBeat.i(49945);
    if (this.mContentView != null) {
      this.mContentView.setVisibility(4);
    }
    AppMethodBeat.o(49945);
  }
  
  @SuppressLint({"WrongCall"})
  protected final void ez(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(49940);
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(49940);
  }
  
  protected final c getManager()
  {
    return this.nia;
  }
  
  protected final void initView()
  {
    AppMethodBeat.i(49951);
    if ((this.mContentView != null) && (getChildCount() > 0))
    {
      bFe();
      AppMethodBeat.o(49951);
      return;
    }
    if (this.mContentView == null) {
      this.mContentView = View.inflate(aj.getContext(), 2131493106, null);
    }
    for (;;)
    {
      this.nin = ((AppBrandSmileyViewPager)this.mContentView.findViewById(2131304873));
      this.nin.setOnPageChangeListener(this);
      this.nin.setPanelManager(this.nia);
      this.nin.setOnSizeChangedListener(this);
      this.nio = ((MMDotView)this.mContentView.findViewById(2131304870));
      this.nio.setDotCount(1);
      bFf();
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
    c localc = this.nia;
    localc.nir = null;
    localc.nhZ = null;
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
    if (this.nfF)
    {
      super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(0, -2147483648));
      AppMethodBeat.o(49939);
      return;
    }
    i.iK(getContext());
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(49939);
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    AppMethodBeat.i(49936);
    a locala = this.nia.bFg();
    int i = locala.getPageCount();
    int j = locala.nib;
    if (i <= 1)
    {
      this.nio.setVisibility(4);
      AppMethodBeat.o(49936);
      return;
    }
    this.nio.setVisibility(0);
    this.nio.setDotCount(i);
    this.nio.setSelectedDot(paramInt - j);
    AppMethodBeat.o(49936);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(49938);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    bFf();
    AppMethodBeat.o(49938);
  }
  
  public void setOnTextOperationListener(f paramf)
  {
    this.nim = paramf;
    this.nia.nis = this.nim;
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(49948);
    if (paramInt == 0) {}
    for (this.nfF = false;; this.nfF = true)
    {
      super.setVisibility(paramInt);
      if (!this.nfF)
      {
        b.F(this.mActivity);
        initView();
      }
      AppMethodBeat.o(49948);
      return;
    }
  }
  
  protected final void wv(int paramInt)
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