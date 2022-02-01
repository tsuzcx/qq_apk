package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.t;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.statusbar.b;

public class d
  extends b
{
  private boolean lAM = true;
  private int mtd = 0;
  private boolean mtv = false;
  private int mtw;
  private boolean mtx = false;
  private Integer mty = null;
  
  public d(Context paramContext)
  {
    super(paramContext);
  }
  
  private f getActionBar()
  {
    AppMethodBeat.i(193547);
    if (getChildCount() <= 0)
    {
      AppMethodBeat.o(193547);
      return null;
    }
    f localf = (f)getChildAt(0);
    AppMethodBeat.o(193547);
    return localf;
  }
  
  public final void L(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(135452);
    this.mtd = paramInt;
    this.mtv = paramBoolean;
    if (!this.lAM)
    {
      if (!this.mtx) {
        super.h(paramInt, paramBoolean, false);
      }
      AppMethodBeat.o(135452);
      return;
    }
    super.h(paramInt, paramBoolean, true);
    AppMethodBeat.o(135452);
  }
  
  public final void aw(Context paramContext)
  {
    AppMethodBeat.i(135458);
    if ((getContext() instanceof MutableContextWrapper)) {
      ((MutableContextWrapper)getContext()).setBaseContext(paramContext);
    }
    if (this.mty != null) {
      tx(0);
    }
    AppMethodBeat.o(135458);
  }
  
  public final void byj()
  {
    AppMethodBeat.i(135453);
    ac.d("Luggage.WXA.AppBrandActionBarContainer", "resetStatusBarForegroundStyle hash[%d] color[%d] foregroundDark[%b] mActuallyVisible[%b] mDeferStatusBarHeightChange[%b]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.mtd), Boolean.valueOf(this.mtv), Boolean.valueOf(this.lAM), Boolean.valueOf(this.mtx) });
    L(this.mtd, this.mtv);
    AppMethodBeat.o(135453);
  }
  
  public final void byk()
  {
    AppMethodBeat.i(193548);
    super.tx(this.mtw);
    AppMethodBeat.o(193548);
  }
  
  protected boolean canAnimate()
  {
    return false;
  }
  
  public void dispatchSystemUiVisibilityChanged(int paramInt)
  {
    AppMethodBeat.i(135449);
    super.dispatchSystemUiVisibilityChanged(paramInt);
    if ((this.lAM) && (t.aC(this)) && (ILI) && ((getWindowSystemUiVisibility() & 0x4) == 0))
    {
      ac.d("Luggage.WXA.AppBrandActionBarContainer", "dispatchSystemUiVisibilityChanged resetStatusBarForegroundStyle, hash[%d]", new Object[] { Integer.valueOf(hashCode()) });
      byj();
    }
    AppMethodBeat.o(135449);
  }
  
  public boolean hasOverlappingRendering()
  {
    return false;
  }
  
  public void onViewAdded(View paramView)
  {
    AppMethodBeat.i(135447);
    super.onViewAdded(paramView);
    if (!(paramView instanceof f))
    {
      paramView = new IllegalAccessError("Cant add non ActionBar instance here");
      AppMethodBeat.o(135447);
      throw paramView;
    }
    paramView.setBackground(new a());
    AppMethodBeat.o(135447);
  }
  
  public void setActuallyVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(135454);
    if (paramBoolean != this.lAM) {}
    for (int i = 1;; i = 0)
    {
      this.lAM = paramBoolean;
      if ((i != 0) && (paramBoolean))
      {
        byj();
        setDeferStatusBarHeightChange(false);
        setWillNotDraw(false);
      }
      if ((i != 0) && (!paramBoolean)) {
        setDeferStatusBarHeightChange(true);
      }
      AppMethodBeat.o(135454);
      return;
    }
  }
  
  public void setDeferStatusBarHeightChange(boolean paramBoolean)
  {
    AppMethodBeat.i(135455);
    if (paramBoolean != this.mtx) {}
    for (int i = 1;; i = 0)
    {
      this.mtx = paramBoolean;
      if ((i != 0) && (!paramBoolean)) {
        super.tx(this.mtw);
      }
      AppMethodBeat.o(135455);
      return;
    }
  }
  
  public void setForceTopInsetsHeight(int paramInt)
  {
    AppMethodBeat.i(135457);
    this.mty = Integer.valueOf(paramInt);
    AppMethodBeat.o(135457);
  }
  
  public void setStatusBarColor(int paramInt)
  {
    AppMethodBeat.i(135451);
    L(paramInt, this.mtv);
    AppMethodBeat.o(135451);
  }
  
  public void setStatusBarForegroundStyle(boolean paramBoolean)
  {
    AppMethodBeat.i(135450);
    if (getActionBar() == null)
    {
      AppMethodBeat.o(135450);
      return;
    }
    L(getActionBar().getBackgroundColor(), paramBoolean);
    AppMethodBeat.o(135450);
  }
  
  public final void tx(int paramInt)
  {
    AppMethodBeat.i(135456);
    ac.d("Luggage.WXA.AppBrandActionBarContainer", "onStatusBarHeightChange: newHeight = ".concat(String.valueOf(paramInt)));
    if (this.mty != null)
    {
      paramInt = this.mty.intValue();
      this.mtw = paramInt;
      super.tx(paramInt);
      AppMethodBeat.o(135456);
      return;
    }
    this.mtw = paramInt;
    if (this.mtx)
    {
      AppMethodBeat.o(135456);
      return;
    }
    super.tx(paramInt);
    AppMethodBeat.o(135456);
  }
  
  final class a
    extends ColorDrawable
  {
    a()
    {
      super();
    }
    
    private void byl()
    {
      AppMethodBeat.i(135446);
      d.this.setStatusBarColor(getColor());
      AppMethodBeat.o(135446);
    }
    
    public final void setAlpha(int paramInt)
    {
      AppMethodBeat.i(135445);
      super.setAlpha(paramInt);
      byl();
      AppMethodBeat.o(135445);
    }
    
    public final void setColor(int paramInt)
    {
      AppMethodBeat.i(135444);
      super.setColor(paramInt);
      byl();
      AppMethodBeat.o(135444);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.actionbar.d
 * JD-Core Version:    0.7.0.1
 */