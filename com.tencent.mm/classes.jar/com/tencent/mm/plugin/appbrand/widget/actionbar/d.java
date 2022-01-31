package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.support.v4.view.t;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class d
  extends com.tencent.mm.ui.statusbar.b
{
  private boolean iwg = true;
  private Integer jbA = null;
  private int jbh = 0;
  private boolean jbx = false;
  private int jby;
  private boolean jbz = false;
  
  public d(Context paramContext)
  {
    super(paramContext);
  }
  
  private b getActionBar()
  {
    AppMethodBeat.i(87488);
    if (getChildCount() <= 0)
    {
      AppMethodBeat.o(87488);
      return null;
    }
    b localb = (b)getChildAt(0);
    AppMethodBeat.o(87488);
    return localb;
  }
  
  public final void K(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(87491);
    this.jbh = paramInt;
    this.jbx = paramBoolean;
    if (!this.iwg)
    {
      if (!this.jbz) {
        super.a(paramInt, paramBoolean, false);
      }
      AppMethodBeat.o(87491);
      return;
    }
    super.a(paramInt, paramBoolean, true);
    AppMethodBeat.o(87491);
  }
  
  public final void aON()
  {
    AppMethodBeat.i(87492);
    K(this.jbh, this.jbx);
    AppMethodBeat.o(87492);
  }
  
  public final void ap(Context paramContext)
  {
    AppMethodBeat.i(141723);
    if ((getContext() instanceof MutableContextWrapper)) {
      ((MutableContextWrapper)getContext()).setBaseContext(paramContext);
    }
    if (this.jbA != null) {
      pB(0);
    }
    AppMethodBeat.o(141723);
  }
  
  protected boolean canAnimate()
  {
    return false;
  }
  
  public void dispatchSystemUiVisibilityChanged(int paramInt)
  {
    AppMethodBeat.i(141722);
    super.dispatchSystemUiVisibilityChanged(paramInt);
    if ((isShown()) && (t.aw(this)) && (Apy) && ((getWindowSystemUiVisibility() & 0x4) == 0)) {
      aON();
    }
    AppMethodBeat.o(141722);
  }
  
  public boolean hasOverlappingRendering()
  {
    return false;
  }
  
  public void onViewAdded(View paramView)
  {
    AppMethodBeat.i(87487);
    super.onViewAdded(paramView);
    if (!(paramView instanceof b))
    {
      paramView = new IllegalAccessError("Cant add non ActionBar instance here");
      AppMethodBeat.o(87487);
      throw paramView;
    }
    paramView.setBackground(new d.a(this));
    AppMethodBeat.o(87487);
  }
  
  public final void pB(int paramInt)
  {
    AppMethodBeat.i(87495);
    if (this.jbA != null)
    {
      paramInt = this.jbA.intValue();
      this.jby = paramInt;
      super.pB(paramInt);
      AppMethodBeat.o(87495);
      return;
    }
    this.jby = paramInt;
    if (this.jbz)
    {
      AppMethodBeat.o(87495);
      return;
    }
    super.pB(paramInt);
    AppMethodBeat.o(87495);
  }
  
  public void setActuallyVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(87493);
    if (paramBoolean != this.iwg) {}
    for (int i = 1;; i = 0)
    {
      this.iwg = paramBoolean;
      if ((i != 0) && (paramBoolean))
      {
        aON();
        setDeferStatusBarHeightChange(false);
        setWillNotDraw(false);
      }
      if ((i != 0) && (!paramBoolean)) {
        setDeferStatusBarHeightChange(true);
      }
      AppMethodBeat.o(87493);
      return;
    }
  }
  
  public void setDeferStatusBarHeightChange(boolean paramBoolean)
  {
    AppMethodBeat.i(87494);
    if (paramBoolean != this.jbz) {}
    for (int i = 1;; i = 0)
    {
      this.jbz = paramBoolean;
      if ((i != 0) && (!paramBoolean)) {
        super.pB(this.jby);
      }
      AppMethodBeat.o(87494);
      return;
    }
  }
  
  public void setForceTopInsetsHeight(int paramInt)
  {
    AppMethodBeat.i(87496);
    this.jbA = Integer.valueOf(paramInt);
    AppMethodBeat.o(87496);
  }
  
  public void setStatusBarColor(int paramInt)
  {
    AppMethodBeat.i(87490);
    K(paramInt, this.jbx);
    AppMethodBeat.o(87490);
  }
  
  public void setStatusBarForegroundStyle(boolean paramBoolean)
  {
    AppMethodBeat.i(87489);
    if (getActionBar() == null)
    {
      AppMethodBeat.o(87489);
      return;
    }
    K(getActionBar().getBackgroundColor(), paramBoolean);
    AppMethodBeat.o(87489);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.actionbar.d
 * JD-Core Version:    0.7.0.1
 */