package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.plugin.appbrand.widget.input.panel.AppBrandSmileyPanelBase;
import com.tencent.mm.plugin.appbrand.widget.input.panel.c;
import com.tencent.mm.plugin.appbrand.widget.input.panel.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.x;

public final class AppBrandSmileyPanel
  extends AppBrandSmileyPanelBase
  implements e
{
  private int jmY = -1;
  private int jmZ = -1;
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
    AppMethodBeat.i(134276);
    if (this.jmY < 0) {
      this.jmY = x.gL(getContext());
    }
    if (this.jmY > 0)
    {
      i = this.jmY;
      AppMethodBeat.o(134276);
      return i;
    }
    getManager();
    int[] arrayOfInt = c.aMu();
    int i = Math.max(arrayOfInt[0], arrayOfInt[1]) / 2 - getContext().getResources().getDimensionPixelSize(2131427531);
    this.jmY = i;
    AppMethodBeat.o(134276);
    return i;
  }
  
  private int getPanelHeightInLandscape()
  {
    AppMethodBeat.i(134275);
    getManager();
    int[] arrayOfInt = c.aMu();
    if ((this.jmZ > 0) && (this.jmZ < arrayOfInt[1]))
    {
      i = this.jmZ;
      AppMethodBeat.o(134275);
      return i;
    }
    int i = Math.min(arrayOfInt[0], arrayOfInt[1]) / 2;
    int j = getContext().getResources().getDimensionPixelSize(2131427531);
    AppMethodBeat.o(134275);
    return i - j;
  }
  
  public final boolean aRd()
  {
    AppMethodBeat.i(134283);
    ab.d("MicroMsg.AppBrandSmileyPanel", "[scrollUp] isRealHeightSettled, mForcePanelHeight %d, height %d, measuredHeight %d", new Object[] { Integer.valueOf(this.jmZ), Integer.valueOf(getHeight()), Integer.valueOf(getMeasuredHeight()) });
    if ((this.jmZ > 0) && (this.jmZ == getMeasuredHeight()))
    {
      AppMethodBeat.o(134283);
      return true;
    }
    AppMethodBeat.o(134283);
    return false;
  }
  
  public final c aRg()
  {
    AppMethodBeat.i(134278);
    ak localak = new ak();
    AppMethodBeat.o(134278);
    return localak;
  }
  
  public final boolean aRh()
  {
    AppMethodBeat.i(134282);
    if (d.fv(18))
    {
      bool = super.isInLayout();
      AppMethodBeat.o(134282);
      return bool;
    }
    boolean bool = this.mInLayout;
    AppMethodBeat.o(134282);
    return bool;
  }
  
  public final int getAppropriateHeightInPort()
  {
    AppMethodBeat.i(134277);
    if (this.jmZ > 0)
    {
      i = this.jmZ;
      AppMethodBeat.o(134277);
      return i;
    }
    int i = getPanelDefaultHeightInPort();
    AppMethodBeat.o(134277);
    return i;
  }
  
  public final int getForcedPanelHeight()
  {
    return this.jmZ;
  }
  
  public final View getPanelView()
  {
    return this;
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(134281);
    this.mInLayout = true;
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.mInLayout = false;
    AppMethodBeat.o(134281);
  }
  
  public final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(134279);
    if (!isShown())
    {
      dz(paramInt1, View.MeasureSpec.makeMeasureSpec(0, -2147483648));
      AppMethodBeat.o(134279);
      return;
    }
    if (!j.gN(getContext())) {}
    for (paramInt2 = getPanelHeightInLandscape();; paramInt2 = getAppropriateHeightInPort())
    {
      dz(paramInt1, View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824));
      AppMethodBeat.o(134279);
      return;
    }
  }
  
  public final boolean qu(int paramInt)
  {
    if ((paramInt > 0) && (this.jmZ != paramInt))
    {
      this.jmZ = paramInt;
      return true;
    }
    return false;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(134280);
    qx(paramInt);
    if (paramInt == 0) {
      initView();
    }
    AppMethodBeat.o(134280);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.AppBrandSmileyPanel
 * JD-Core Version:    0.7.0.1
 */