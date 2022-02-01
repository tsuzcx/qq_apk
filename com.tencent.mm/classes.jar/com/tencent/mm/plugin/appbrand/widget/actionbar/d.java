package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.t;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.statusbar.b;

public class d
  extends b
{
  private int mYN = 0;
  private boolean mZh = false;
  private int mZi;
  private boolean mZj = false;
  private Integer mZk = null;
  private boolean meE = true;
  
  public d(Context paramContext)
  {
    super(paramContext);
  }
  
  private e getActionBar()
  {
    AppMethodBeat.i(208018);
    if (getChildCount() <= 0)
    {
      AppMethodBeat.o(208018);
      return null;
    }
    e locale = (e)getChildAt(0);
    AppMethodBeat.o(208018);
    return locale;
  }
  
  public final void M(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(135452);
    this.mYN = paramInt;
    this.mZh = paramBoolean;
    if (!this.meE)
    {
      if (!this.mZj) {
        super.j(paramInt, paramBoolean, false);
      }
      AppMethodBeat.o(135452);
      return;
    }
    super.j(paramInt, paramBoolean, true);
    AppMethodBeat.o(135452);
  }
  
  public final void ax(Context paramContext)
  {
    AppMethodBeat.i(135458);
    if ((getContext() instanceof MutableContextWrapper)) {
      ((MutableContextWrapper)getContext()).setBaseContext(paramContext);
    }
    if (this.mZk != null) {
      ug(0);
    }
    AppMethodBeat.o(135458);
  }
  
  public final void bDh()
  {
    AppMethodBeat.i(135453);
    ae.d("Luggage.WXA.AppBrandActionBarContainer", "resetStatusBarForegroundStyle hash[%d] color[%d] foregroundDark[%b] mActuallyVisible[%b] mDeferStatusBarHeightChange[%b]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.mYN), Boolean.valueOf(this.mZh), Boolean.valueOf(this.meE), Boolean.valueOf(this.mZj) });
    M(this.mYN, this.mZh);
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
    if ((this.meE) && (t.aC(this)) && (KZj) && ((getWindowSystemUiVisibility() & 0x4) == 0))
    {
      ae.d("Luggage.WXA.AppBrandActionBarContainer", "dispatchSystemUiVisibilityChanged resetStatusBarForegroundStyle, hash[%d]", new Object[] { Integer.valueOf(hashCode()) });
      bDh();
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
    if (!(paramView instanceof e))
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
    if (paramBoolean != this.meE) {}
    for (int i = 1;; i = 0)
    {
      this.meE = paramBoolean;
      if ((i != 0) && (paramBoolean))
      {
        bDh();
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
    if (paramBoolean != this.mZj) {}
    for (int i = 1;; i = 0)
    {
      this.mZj = paramBoolean;
      if ((i != 0) && (!paramBoolean)) {
        super.ug(this.mZi);
      }
      AppMethodBeat.o(135455);
      return;
    }
  }
  
  public void setForceTopInsetsHeight(int paramInt)
  {
    AppMethodBeat.i(135457);
    this.mZk = Integer.valueOf(paramInt);
    AppMethodBeat.o(135457);
  }
  
  public void setStatusBarColor(int paramInt)
  {
    AppMethodBeat.i(135451);
    M(paramInt, this.mZh);
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
    M(getActionBar().getBackgroundColor(), paramBoolean);
    AppMethodBeat.o(135450);
  }
  
  public final void ug(int paramInt)
  {
    AppMethodBeat.i(135456);
    ae.d("Luggage.WXA.AppBrandActionBarContainer", "onStatusBarHeightChange: newHeight = ".concat(String.valueOf(paramInt)));
    if (this.mZk != null)
    {
      paramInt = this.mZk.intValue();
      this.mZi = paramInt;
      super.ug(paramInt);
      AppMethodBeat.o(135456);
      return;
    }
    this.mZi = paramInt;
    if (this.mZj)
    {
      AppMethodBeat.o(135456);
      return;
    }
    super.ug(paramInt);
    AppMethodBeat.o(135456);
  }
  
  final class a
    extends ColorDrawable
  {
    a()
    {
      super();
    }
    
    private void bDi()
    {
      AppMethodBeat.i(135446);
      d.this.setStatusBarColor(getColor());
      AppMethodBeat.o(135446);
    }
    
    public final void setAlpha(int paramInt)
    {
      AppMethodBeat.i(135445);
      super.setAlpha(paramInt);
      bDi();
      AppMethodBeat.o(135445);
    }
    
    public final void setColor(int paramInt)
    {
      AppMethodBeat.i(135444);
      super.setColor(paramInt);
      bDi();
      AppMethodBeat.o(135444);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.actionbar.d
 * JD-Core Version:    0.7.0.1
 */