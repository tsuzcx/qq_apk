package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.compatible.util.i;
import com.tencent.mm.plugin.appbrand.widget.input.panel.AppBrandSmileyPanelBase;
import com.tencent.mm.plugin.appbrand.widget.input.panel.c;
import com.tencent.mm.plugin.appbrand.widget.input.panel.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.z;

public final class AppBrandSmileyPanel
  extends AppBrandSmileyPanelBase
  implements e
{
  private boolean mInLayout = false;
  private int nfl = -1;
  private int nfm = -1;
  
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
    AppMethodBeat.i(49897);
    if (this.nfl < 0) {
      this.nfl = z.iI(getContext());
    }
    if (this.nfl > 0)
    {
      i = this.nfl;
      AppMethodBeat.o(49897);
      return i;
    }
    getManager();
    int[] arrayOfInt = c.bFh();
    int i = Math.max(arrayOfInt[0], arrayOfInt[1]) / 2 - getContext().getResources().getDimensionPixelSize(2131165224);
    this.nfl = i;
    AppMethodBeat.o(49897);
    return i;
  }
  
  private int getPanelHeightInLandscape()
  {
    AppMethodBeat.i(49896);
    getManager();
    int[] arrayOfInt = c.bFh();
    if ((this.nfm > 0) && (this.nfm < arrayOfInt[1]))
    {
      i = this.nfm;
      AppMethodBeat.o(49896);
      return i;
    }
    int i = Math.min(arrayOfInt[0], arrayOfInt[1]) / 2;
    int j = getContext().getResources().getDimensionPixelSize(2131165224);
    AppMethodBeat.o(49896);
    return i - j;
  }
  
  public final boolean bEA()
  {
    AppMethodBeat.i(49903);
    if (d.ly(18))
    {
      bool = super.isInLayout();
      AppMethodBeat.o(49903);
      return bool;
    }
    boolean bool = this.mInLayout;
    AppMethodBeat.o(49903);
    return bool;
  }
  
  public final boolean bEw()
  {
    AppMethodBeat.i(49904);
    ad.d("MicroMsg.AppBrandSmileyPanel", "[scrollUp] isRealHeightSettled, mForcePanelHeight %d, height %d, measuredHeight %d", new Object[] { Integer.valueOf(this.nfm), Integer.valueOf(getHeight()), Integer.valueOf(getMeasuredHeight()) });
    if ((this.nfm > 0) && (this.nfm == getMeasuredHeight()))
    {
      AppMethodBeat.o(49904);
      return true;
    }
    AppMethodBeat.o(49904);
    return false;
  }
  
  public final c bEz()
  {
    AppMethodBeat.i(49899);
    ak localak = new ak();
    AppMethodBeat.o(49899);
    return localak;
  }
  
  public final int getAppropriateHeightInPort()
  {
    AppMethodBeat.i(49898);
    if (this.nfm > 0)
    {
      i = this.nfm;
      AppMethodBeat.o(49898);
      return i;
    }
    int i = getPanelDefaultHeightInPort();
    AppMethodBeat.o(49898);
    return i;
  }
  
  public final int getForcedPanelHeight()
  {
    return this.nfm;
  }
  
  public final View getPanelView()
  {
    return this;
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(49902);
    this.mInLayout = true;
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.mInLayout = false;
    AppMethodBeat.o(49902);
  }
  
  public final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(49900);
    if (!isShown())
    {
      ez(paramInt1, View.MeasureSpec.makeMeasureSpec(0, -2147483648));
      AppMethodBeat.o(49900);
      return;
    }
    if (!i.iK(getContext())) {}
    for (paramInt2 = getPanelHeightInLandscape();; paramInt2 = getAppropriateHeightInPort())
    {
      ez(paramInt1, View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824));
      AppMethodBeat.o(49900);
      return;
    }
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(49901);
    wv(paramInt);
    if (paramInt == 0) {
      initView();
    }
    AppMethodBeat.o(49901);
  }
  
  public final boolean ws(int paramInt)
  {
    if ((paramInt > 0) && (this.nfm != paramInt))
    {
      this.nfm = paramInt;
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.AppBrandSmileyPanel
 * JD-Core Version:    0.7.0.1
 */