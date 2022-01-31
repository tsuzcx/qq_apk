package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.plugin.appbrand.widget.input.panel.AppBrandSmileyPanelBase;
import com.tencent.mm.plugin.appbrand.widget.input.panel.c;
import com.tencent.mm.plugin.appbrand.widget.input.panel.e;
import com.tencent.mm.plugin.appbrand.y.e;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.y;

public final class AppBrandSmileyPanel
  extends AppBrandSmileyPanelBase
  implements e
{
  private int huO = -1;
  private int huP = -1;
  private boolean mInLayout = false;
  
  public AppBrandSmileyPanel(Context paramContext)
  {
    super(paramContext);
  }
  
  public AppBrandSmileyPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private int getPanelDefaultHeightInPort()
  {
    if (this.huO < 0) {
      this.huO = u.fy(getContext());
    }
    if (this.huO > 0) {
      return this.huO;
    }
    getManager();
    int[] arrayOfInt = c.api();
    int i = Math.max(arrayOfInt[0], arrayOfInt[1]) / 2 - getContext().getResources().getDimensionPixelSize(y.e.ChattingFootEditMinHeigh);
    this.huO = i;
    return i;
  }
  
  private int getPanelHeightInLandscape()
  {
    getManager();
    int[] arrayOfInt = c.api();
    if ((this.huP > 0) && (this.huP < arrayOfInt[1])) {
      return this.huP;
    }
    return Math.min(arrayOfInt[0], arrayOfInt[1]) / 2 - getContext().getResources().getDimensionPixelSize(y.e.ChattingFootEditMinHeigh);
  }
  
  public final boolean arZ()
  {
    y.d("MicroMsg.AppBrandSmileyPanel", "[scrollUp] isRealHeightSettled, mForcePanelHeight %d, height %d, measuredHeight %d", new Object[] { Integer.valueOf(this.huP), Integer.valueOf(getHeight()), Integer.valueOf(getMeasuredHeight()) });
    return (this.huP > 0) && (this.huP == getMeasuredHeight());
  }
  
  protected final c asc()
  {
    return new aj();
  }
  
  public final boolean asd()
  {
    if (d.gF(18)) {
      return super.isInLayout();
    }
    return this.mInLayout;
  }
  
  public final int getAppropriateHeightInPort()
  {
    if (this.huP > 0) {
      return this.huP;
    }
    return getPanelDefaultHeightInPort();
  }
  
  public final int getForcedPanelHeight()
  {
    return this.huP;
  }
  
  public final View getPanelView()
  {
    return this;
  }
  
  public final boolean mQ(int paramInt)
  {
    if ((paramInt > 0) && (this.huP != paramInt))
    {
      this.huP = paramInt;
      return true;
    }
    return false;
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mInLayout = true;
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.mInLayout = false;
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    if (!isShown())
    {
      cl(paramInt1, View.MeasureSpec.makeMeasureSpec(0, -2147483648));
      return;
    }
    if (!j.fA(getContext())) {}
    for (paramInt2 = getPanelHeightInLandscape();; paramInt2 = getAppropriateHeightInPort())
    {
      cl(paramInt1, View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824));
      return;
    }
  }
  
  public final void setVisibility(int paramInt)
  {
    mT(paramInt);
    if (paramInt == 0) {
      initView();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.AppBrandSmileyPanel
 * JD-Core Version:    0.7.0.1
 */