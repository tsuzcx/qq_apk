package com.tencent.mm.plugin.appbrand.widget.input.panel;

import android.annotation.SuppressLint;
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
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMDotView;

public class AppBrandSmileyPanelBase
  extends LinearLayout
  implements ViewPager.OnPageChangeListener, AppBrandSmileyViewPager.b
{
  private View Qz;
  private boolean jnt;
  private c jpK;
  private f jpW;
  private MMActivity jpX;
  private AppBrandSmileyViewPager jpY;
  private MMDotView jpZ;
  private boolean jqa;
  
  public AppBrandSmileyPanelBase(Context paramContext)
  {
    super(paramContext, null);
    AppMethodBeat.i(134318);
    this.jnt = false;
    this.Qz = null;
    this.jpY = null;
    this.jqa = true;
    init();
    AppMethodBeat.o(134318);
  }
  
  public AppBrandSmileyPanelBase(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(134319);
    this.jnt = false;
    this.Qz = null;
    this.jpY = null;
    this.jqa = true;
    init();
    AppMethodBeat.o(134319);
  }
  
  private void aRM()
  {
    AppMethodBeat.i(134327);
    this.Qz.setVisibility(0);
    AppMethodBeat.o(134327);
  }
  
  private void aRN()
  {
    AppMethodBeat.i(134329);
    if (this.jpZ == null)
    {
      AppMethodBeat.o(134329);
      return;
    }
    boolean bool = j.gN(getContext());
    RelativeLayout.LayoutParams localLayoutParams;
    if (bool != this.jqa)
    {
      if (!bool) {
        break label106;
      }
      this.jpZ.setPadding(0, 0, 0, getContext().getResources().getDimensionPixelSize(2131427792));
      localLayoutParams = (RelativeLayout.LayoutParams)this.jpZ.getLayoutParams();
      localLayoutParams.bottomMargin = getContext().getResources().getDimensionPixelSize(2131428385);
      this.jpZ.setLayoutParams(localLayoutParams);
    }
    for (;;)
    {
      this.jqa = bool;
      AppMethodBeat.o(134329);
      return;
      label106:
      this.jpZ.setPadding(0, 0, 0, getContext().getResources().getDimensionPixelSize(2131427782));
      localLayoutParams = (RelativeLayout.LayoutParams)this.jpZ.getLayoutParams();
      localLayoutParams.bottomMargin = 0;
      this.jpZ.setLayoutParams(localLayoutParams);
    }
  }
  
  private void init()
  {
    AppMethodBeat.i(134323);
    this.jpX = ((MMActivity)com.tencent.mm.sdk.f.a.hr(getContext()));
    this.jpK = aRg();
    this.jpK.jpJ = getContext();
    this.jpK.jqd = this.jpW;
    AppMethodBeat.o(134323);
  }
  
  public final void aRJ()
  {
    AppMethodBeat.i(134314);
    if (this.jpY == null)
    {
      AppMethodBeat.o(134314);
      return;
    }
    this.jpK.jqa = j.gN(getContext());
    AppBrandSmileyViewPager.a locala = (AppBrandSmileyViewPager.a)this.jpY.getAdapter();
    if (locala != null)
    {
      locala.jqk.clear();
      locala.jpK = this.jpK;
      locala.notifyDataSetChanged();
    }
    for (;;)
    {
      this.jpY.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(134312);
          AppBrandSmileyPanelBase.this.onPageSelected(AppBrandSmileyPanelBase.a(AppBrandSmileyPanelBase.this).getCurrentItem());
          AppMethodBeat.o(134312);
        }
      });
      AppMethodBeat.o(134314);
      return;
      locala = new AppBrandSmileyViewPager.a();
      locala.jpK = this.jpK;
      this.jpY.setAdapter(locala);
    }
  }
  
  public final void aRK()
  {
    AppMethodBeat.i(134321);
    if (this.Qz != null) {
      this.Qz.setVisibility(0);
    }
    AppMethodBeat.o(134321);
  }
  
  public final void aRL()
  {
    AppMethodBeat.i(134322);
    if (this.Qz != null) {
      this.Qz.setVisibility(4);
    }
    AppMethodBeat.o(134322);
  }
  
  protected c aRg()
  {
    AppMethodBeat.i(134324);
    c localc = new c();
    AppMethodBeat.o(134324);
    return localc;
  }
  
  @SuppressLint({"WrongCall"})
  protected final void dz(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(134317);
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(134317);
  }
  
  protected final c getManager()
  {
    return this.jpK;
  }
  
  protected final void initView()
  {
    AppMethodBeat.i(134328);
    if ((this.Qz != null) && (getChildCount() > 0))
    {
      aRM();
      AppMethodBeat.o(134328);
      return;
    }
    if (this.Qz == null) {
      this.Qz = View.inflate(ah.getContext(), 2130968777, null);
    }
    for (;;)
    {
      this.jpY = ((AppBrandSmileyViewPager)this.Qz.findViewById(2131821544));
      this.jpY.setOnPageChangeListener(this);
      this.jpY.setPanelManager(this.jpK);
      this.jpY.setOnSizeChangedListener(this);
      this.jpZ = ((MMDotView)this.Qz.findViewById(2131821543));
      this.jpZ.setDotCount(1);
      aRN();
      addView(this.Qz, new LinearLayout.LayoutParams(-1, -1));
      AppMethodBeat.o(134328);
      return;
      if (this.Qz.getParent() != null) {
        ((ViewGroup)this.Qz.getParent()).removeView(this.Qz);
      }
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(134320);
    c localc = this.jpK;
    localc.jqc = null;
    localc.jpJ = null;
    if (this.Qz != null)
    {
      ((ViewGroup)this.Qz.getParent()).removeView(this.Qz);
      ((ViewGroup)this.Qz).removeAllViews();
      this.Qz = null;
    }
    this.jpX = null;
    AppMethodBeat.o(134320);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(134316);
    if (this.jnt)
    {
      super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(0, -2147483648));
      AppMethodBeat.o(134316);
      return;
    }
    j.gN(getContext());
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(134316);
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    AppMethodBeat.i(134313);
    a locala = this.jpK.aRO();
    int i = locala.getPageCount();
    int j = locala.jpL;
    if (i <= 1)
    {
      this.jpZ.setVisibility(4);
      AppMethodBeat.o(134313);
      return;
    }
    this.jpZ.setVisibility(0);
    this.jpZ.setDotCount(i);
    this.jpZ.setSelectedDot(paramInt - j);
    AppMethodBeat.o(134313);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(134315);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    aRN();
    AppMethodBeat.o(134315);
  }
  
  protected final void qx(int paramInt)
  {
    AppMethodBeat.i(134326);
    super.setVisibility(paramInt);
    AppMethodBeat.o(134326);
  }
  
  public void setOnTextOperationListener(f paramf)
  {
    this.jpW = paramf;
    this.jpK.jqd = this.jpW;
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(134325);
    if (paramInt == 0) {}
    for (this.jnt = false;; this.jnt = true)
    {
      super.setVisibility(paramInt);
      if (!this.jnt)
      {
        this.jpX.hideVKB();
        initView();
      }
      AppMethodBeat.o(134325);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.panel.AppBrandSmileyPanelBase
 * JD-Core Version:    0.7.0.1
 */