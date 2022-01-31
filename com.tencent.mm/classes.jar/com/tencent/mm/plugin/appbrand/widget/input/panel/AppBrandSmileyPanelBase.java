package com.tencent.mm.plugin.appbrand.widget.input.panel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.ViewPager.e;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.plugin.appbrand.y.e;
import com.tencent.mm.plugin.appbrand.y.g;
import com.tencent.mm.plugin.appbrand.y.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMDotView;

public class AppBrandSmileyPanelBase
  extends LinearLayout
  implements ViewPager.e, AppBrandSmileyViewPager.b
{
  private View QR = null;
  private boolean hvi = false;
  private c hxA;
  private f hxM;
  private MMActivity hxN;
  private AppBrandSmileyViewPager hxO = null;
  private MMDotView hxP;
  private boolean hxQ = true;
  
  public AppBrandSmileyPanelBase(Context paramContext)
  {
    super(paramContext, null);
    init();
  }
  
  public AppBrandSmileyPanelBase(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  private void asI()
  {
    if (this.hxP == null) {}
    boolean bool;
    do
    {
      return;
      bool = j.fA(getContext());
    } while (bool == this.hxQ);
    RelativeLayout.LayoutParams localLayoutParams;
    if (bool)
    {
      this.hxP.setPadding(0, 0, 0, getContext().getResources().getDimensionPixelSize(y.e.MiddlePadding));
      localLayoutParams = (RelativeLayout.LayoutParams)this.hxP.getLayoutParams();
      localLayoutParams.bottomMargin = getContext().getResources().getDimensionPixelSize(y.e.emoji_panel_tab_height);
      this.hxP.setLayoutParams(localLayoutParams);
    }
    for (;;)
    {
      this.hxQ = bool;
      return;
      this.hxP.setPadding(0, 0, 0, getContext().getResources().getDimensionPixelSize(y.e.LittlePadding));
      localLayoutParams = (RelativeLayout.LayoutParams)this.hxP.getLayoutParams();
      localLayoutParams.bottomMargin = 0;
      this.hxP.setLayoutParams(localLayoutParams);
    }
  }
  
  private void init()
  {
    this.hxN = ((MMActivity)getContext());
    this.hxA = asc();
    this.hxA.hxz = getContext();
    this.hxA.hxT = this.hxM;
  }
  
  public final void Q(int paramInt) {}
  
  public final void R(int paramInt)
  {
    a locala = this.hxA.asJ();
    int i = locala.getPageCount();
    int j = locala.hxB;
    if (i <= 1)
    {
      this.hxP.setVisibility(4);
      return;
    }
    this.hxP.setVisibility(0);
    this.hxP.setDotCount(i);
    this.hxP.setSelectedDot(paramInt - j);
  }
  
  public final void a(int paramInt1, float paramFloat, int paramInt2) {}
  
  public final void asF()
  {
    if (this.hxO == null) {
      return;
    }
    this.hxA.hxQ = j.fA(getContext());
    AppBrandSmileyViewPager.a locala = (AppBrandSmileyViewPager.a)this.hxO.getAdapter();
    if (locala != null)
    {
      locala.hya.clear();
      locala.hxA = this.hxA;
      locala.notifyDataSetChanged();
    }
    for (;;)
    {
      this.hxO.post(new Runnable()
      {
        public final void run()
        {
          AppBrandSmileyPanelBase.this.R(AppBrandSmileyPanelBase.a(AppBrandSmileyPanelBase.this).getCurrentItem());
        }
      });
      return;
      locala = new AppBrandSmileyViewPager.a();
      locala.hxA = this.hxA;
      this.hxO.setAdapter(locala);
    }
  }
  
  public final void asG()
  {
    if (this.QR != null) {
      this.QR.setVisibility(0);
    }
  }
  
  public final void asH()
  {
    if (this.QR != null) {
      this.QR.setVisibility(4);
    }
  }
  
  public c asc()
  {
    return new c();
  }
  
  @SuppressLint({"WrongCall"})
  public final void cl(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public final c getManager()
  {
    return this.hxA;
  }
  
  public final void initView()
  {
    if ((this.QR != null) && (getChildCount() > 0))
    {
      this.QR.setVisibility(0);
      return;
    }
    if (this.QR == null) {
      this.QR = View.inflate(ae.getContext(), y.h.appbrand_smiley_panel, null);
    }
    for (;;)
    {
      this.hxO = ((AppBrandSmileyViewPager)this.QR.findViewById(y.g.smiley_panel_view_pager));
      this.hxO.setOnPageChangeListener(this);
      this.hxO.setPanelManager(this.hxA);
      this.hxO.setOnSizeChangedListener(this);
      this.hxP = ((MMDotView)this.QR.findViewById(y.g.smiley_panel_dot));
      this.hxP.setDotCount(1);
      asI();
      addView(this.QR, new LinearLayout.LayoutParams(-1, -1));
      return;
      if (this.QR.getParent() != null) {
        ((ViewGroup)this.QR.getParent()).removeView(this.QR);
      }
    }
  }
  
  public final void mT(int paramInt)
  {
    super.setVisibility(paramInt);
  }
  
  public final void onDestroy()
  {
    c localc = this.hxA;
    localc.hxS = null;
    localc.hxz = null;
    if (this.QR != null)
    {
      ((ViewGroup)this.QR.getParent()).removeView(this.QR);
      ((ViewGroup)this.QR).removeAllViews();
      this.QR = null;
    }
    this.hxN = null;
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.hvi)
    {
      super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(0, -2147483648));
      return;
    }
    j.fA(getContext());
    super.onMeasure(paramInt1, paramInt2);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    asI();
  }
  
  public void setOnTextOperationListener(f paramf)
  {
    this.hxM = paramf;
    this.hxA.hxT = this.hxM;
  }
  
  public void setVisibility(int paramInt)
  {
    if (paramInt == 0) {}
    for (this.hvi = false;; this.hvi = true)
    {
      super.setVisibility(paramInt);
      if (!this.hvi)
      {
        this.hxN.XM();
        initView();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.panel.AppBrandSmileyPanelBase
 * JD-Core Version:    0.7.0.1
 */