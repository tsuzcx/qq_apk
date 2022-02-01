package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.support.v4.view.t;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.statusbar.b;

public class d
  extends b
{
  private int mTJ = 0;
  private boolean mUb = false;
  private int mUc;
  private boolean mUd = false;
  private Integer mUe = null;
  private boolean mal = true;
  
  public d(Context paramContext)
  {
    super(paramContext);
  }
  
  private f getActionBar()
  {
    AppMethodBeat.i(197469);
    if (getChildCount() <= 0)
    {
      AppMethodBeat.o(197469);
      return null;
    }
    f localf = (f)getChildAt(0);
    AppMethodBeat.o(197469);
    return localf;
  }
  
  public final void L(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(135452);
    this.mTJ = paramInt;
    this.mUb = paramBoolean;
    if (!this.mal)
    {
      if (!this.mUd) {
        super.j(paramInt, paramBoolean, false);
      }
      AppMethodBeat.o(135452);
      return;
    }
    super.j(paramInt, paramBoolean, true);
    AppMethodBeat.o(135452);
  }
  
  public final void aw(Context paramContext)
  {
    AppMethodBeat.i(135458);
    if ((getContext() instanceof MutableContextWrapper)) {
      ((MutableContextWrapper)getContext()).setBaseContext(paramContext);
    }
    if (this.mUe != null) {
      ua(0);
    }
    AppMethodBeat.o(135458);
  }
  
  public final void bCp()
  {
    AppMethodBeat.i(135453);
    ad.d("Luggage.WXA.AppBrandActionBarContainer", "resetStatusBarForegroundStyle hash[%d] color[%d] foregroundDark[%b] mActuallyVisible[%b] mDeferStatusBarHeightChange[%b]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.mTJ), Boolean.valueOf(this.mUb), Boolean.valueOf(this.mal), Boolean.valueOf(this.mUd) });
    L(this.mTJ, this.mUb);
    AppMethodBeat.o(135453);
  }
  
  protected boolean canAnimate()
  {
    return false;
  }
  
  public void dispatchSystemUiVisibilityChanged(int paramInt)
  {
    AppMethodBeat.i(135449);
    super.dispatchSystemUiVisibilityChanged(paramInt);
    if ((this.mal) && (t.aC(this)) && (KCP) && ((getWindowSystemUiVisibility() & 0x4) == 0))
    {
      ad.d("Luggage.WXA.AppBrandActionBarContainer", "dispatchSystemUiVisibilityChanged resetStatusBarForegroundStyle, hash[%d]", new Object[] { Integer.valueOf(hashCode()) });
      bCp();
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
    paramView.setBackground(new d.a(this));
    AppMethodBeat.o(135447);
  }
  
  public void setActuallyVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(135454);
    if (paramBoolean != this.mal) {}
    for (int i = 1;; i = 0)
    {
      this.mal = paramBoolean;
      if ((i != 0) && (paramBoolean))
      {
        bCp();
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
    if (paramBoolean != this.mUd) {}
    for (int i = 1;; i = 0)
    {
      this.mUd = paramBoolean;
      if ((i != 0) && (!paramBoolean)) {
        super.ua(this.mUc);
      }
      AppMethodBeat.o(135455);
      return;
    }
  }
  
  public void setForceTopInsetsHeight(int paramInt)
  {
    AppMethodBeat.i(135457);
    this.mUe = Integer.valueOf(paramInt);
    AppMethodBeat.o(135457);
  }
  
  public void setStatusBarColor(int paramInt)
  {
    AppMethodBeat.i(135451);
    L(paramInt, this.mUb);
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
  
  public final void ua(int paramInt)
  {
    AppMethodBeat.i(135456);
    ad.d("Luggage.WXA.AppBrandActionBarContainer", "onStatusBarHeightChange: newHeight = ".concat(String.valueOf(paramInt)));
    if (this.mUe != null)
    {
      paramInt = this.mUe.intValue();
      this.mUc = paramInt;
      super.ua(paramInt);
      AppMethodBeat.o(135456);
      return;
    }
    this.mUc = paramInt;
    if (this.mUd)
    {
      AppMethodBeat.o(135456);
      return;
    }
    super.ua(paramInt);
    AppMethodBeat.o(135456);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.actionbar.d
 * JD-Core Version:    0.7.0.1
 */