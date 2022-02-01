package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.view.View;
import androidx.core.g.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.h.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.statusbar.b;

public class d
  extends b
  implements h.b
{
  private boolean qqK = true;
  private boolean roP = false;
  private int roQ;
  private Integer roR = null;
  private int rou = 0;
  
  public d(Context paramContext)
  {
    super(paramContext);
  }
  
  private f getActionBar()
  {
    AppMethodBeat.i(245754);
    if (getChildCount() <= 0)
    {
      AppMethodBeat.o(245754);
      return null;
    }
    f localf = (f)getChildAt(0);
    AppMethodBeat.o(245754);
    return localf;
  }
  
  public final void BF(int paramInt)
  {
    AppMethodBeat.i(135456);
    Log.i("Luggage.WXA.AppBrandActionBarContainer", "onStatusBarHeightChange: newHeight = ".concat(String.valueOf(paramInt)));
    if (this.roR != null)
    {
      paramInt = this.roR.intValue();
      this.roQ = paramInt;
      super.BF(paramInt);
      AppMethodBeat.o(135456);
      return;
    }
    this.roQ = paramInt;
    if (hXU())
    {
      AppMethodBeat.o(135456);
      return;
    }
    super.BF(paramInt);
    AppMethodBeat.o(135456);
  }
  
  public final void T(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(135452);
    this.rou = paramInt;
    this.roP = paramBoolean;
    if (!this.qqK)
    {
      super.o(paramInt, paramBoolean, false);
      AppMethodBeat.o(135452);
      return;
    }
    super.o(paramInt, paramBoolean, true);
    AppMethodBeat.o(135452);
  }
  
  public final void aD(Context paramContext)
  {
    AppMethodBeat.i(135458);
    if ((getContext() instanceof MutableContextWrapper)) {
      ((MutableContextWrapper)getContext()).setBaseContext(paramContext);
    }
    if (this.roR != null) {
      BF(0);
    }
    AppMethodBeat.o(135458);
  }
  
  protected boolean canAnimate()
  {
    return false;
  }
  
  public final void cnf()
  {
    AppMethodBeat.i(135453);
    Log.d("Luggage.WXA.AppBrandActionBarContainer", "resetStatusBarForegroundStyle hash[%d] color[%d] foregroundDark[%b] mActuallyVisible[%b] isLayoutFrozen[%b]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.rou), Boolean.valueOf(this.roP), Boolean.valueOf(this.qqK), Boolean.valueOf(hXU()) });
    T(this.rou, this.roP);
    AppMethodBeat.o(135453);
  }
  
  public void dispatchSystemUiVisibilityChanged(int paramInt)
  {
    AppMethodBeat.i(135449);
    super.dispatchSystemUiVisibilityChanged(paramInt);
    if ((this.qqK) && (w.al(this)) && (XMo) && ((getWindowSystemUiVisibility() & 0x4) == 0))
    {
      Log.d("Luggage.WXA.AppBrandActionBarContainer", "dispatchSystemUiVisibilityChanged resetStatusBarForegroundStyle, hash[%d]", new Object[] { Integer.valueOf(hashCode()) });
      cnf();
    }
    AppMethodBeat.o(135449);
  }
  
  public boolean hasOverlappingRendering()
  {
    return false;
  }
  
  public final void onBackground()
  {
    AppMethodBeat.i(245765);
    setActuallyVisible(false);
    AppMethodBeat.o(245765);
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
    paramView.setBackground(new d.a(this));
    AppMethodBeat.o(135447);
  }
  
  public void setActuallyVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(135454);
    if (paramBoolean != this.qqK) {}
    for (int i = 1;; i = 0)
    {
      this.qqK = paramBoolean;
      if ((i != 0) && (paramBoolean))
      {
        setDeferStatusBarHeightChange(false);
        cnf();
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
    super.setLayoutFrozen(paramBoolean);
    AppMethodBeat.o(135455);
  }
  
  public void setForceTopInsetsHeight(int paramInt)
  {
    AppMethodBeat.i(135457);
    this.roR = Integer.valueOf(paramInt);
    AppMethodBeat.o(135457);
  }
  
  public void setStatusBarColor(int paramInt)
  {
    AppMethodBeat.i(135451);
    T(paramInt, this.roP);
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
    T(getActionBar().getBackgroundColor(), paramBoolean);
    AppMethodBeat.o(135450);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.actionbar.d
 * JD-Core Version:    0.7.0.1
 */