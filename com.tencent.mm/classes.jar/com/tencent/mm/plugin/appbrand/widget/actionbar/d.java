package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.u;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.statusbar.b;

public class d
  extends b
{
  private boolean noY = true;
  private int olS = 0;
  private boolean omm = false;
  private int omn;
  private boolean omo = false;
  private Integer omp = null;
  
  public d(Context paramContext)
  {
    super(paramContext);
  }
  
  private e getActionBar()
  {
    AppMethodBeat.i(219625);
    if (getChildCount() <= 0)
    {
      AppMethodBeat.o(219625);
      return null;
    }
    e locale = (e)getChildAt(0);
    AppMethodBeat.o(219625);
    return locale;
  }
  
  public final void S(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(135452);
    this.olS = paramInt;
    this.omm = paramBoolean;
    if (!this.noY)
    {
      if (!this.omo) {
        super.l(paramInt, paramBoolean, false);
      }
      AppMethodBeat.o(135452);
      return;
    }
    super.l(paramInt, paramBoolean, true);
    AppMethodBeat.o(135452);
  }
  
  public final void aG(Context paramContext)
  {
    AppMethodBeat.i(135458);
    if ((getContext() instanceof MutableContextWrapper)) {
      ((MutableContextWrapper)getContext()).setBaseContext(paramContext);
    }
    if (this.omp != null) {
      yf(0);
    }
    AppMethodBeat.o(135458);
  }
  
  public final void cah()
  {
    AppMethodBeat.i(135453);
    Log.d("Luggage.WXA.AppBrandActionBarContainer", "resetStatusBarForegroundStyle hash[%d] color[%d] foregroundDark[%b] mActuallyVisible[%b] mDeferStatusBarHeightChange[%b]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.olS), Boolean.valueOf(this.omm), Boolean.valueOf(this.noY), Boolean.valueOf(this.omo) });
    S(this.olS, this.omm);
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
    if ((this.noY) && (u.aD(this)) && (Qoi) && ((getWindowSystemUiVisibility() & 0x4) == 0))
    {
      Log.d("Luggage.WXA.AppBrandActionBarContainer", "dispatchSystemUiVisibilityChanged resetStatusBarForegroundStyle, hash[%d]", new Object[] { Integer.valueOf(hashCode()) });
      cah();
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
    if (paramBoolean != this.noY) {}
    for (int i = 1;; i = 0)
    {
      this.noY = paramBoolean;
      if ((i != 0) && (paramBoolean))
      {
        cah();
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
    if (paramBoolean != this.omo) {}
    for (int i = 1;; i = 0)
    {
      this.omo = paramBoolean;
      if ((i != 0) && (!paramBoolean)) {
        super.yf(this.omn);
      }
      AppMethodBeat.o(135455);
      return;
    }
  }
  
  public void setForceTopInsetsHeight(int paramInt)
  {
    AppMethodBeat.i(135457);
    this.omp = Integer.valueOf(paramInt);
    AppMethodBeat.o(135457);
  }
  
  public void setStatusBarColor(int paramInt)
  {
    AppMethodBeat.i(135451);
    S(paramInt, this.omm);
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
    S(getActionBar().getBackgroundColor(), paramBoolean);
    AppMethodBeat.o(135450);
  }
  
  public final void yf(int paramInt)
  {
    AppMethodBeat.i(135456);
    Log.i("Luggage.WXA.AppBrandActionBarContainer", "onStatusBarHeightChange: newHeight = ".concat(String.valueOf(paramInt)));
    if (this.omp != null)
    {
      paramInt = this.omp.intValue();
      this.omn = paramInt;
      super.yf(paramInt);
      AppMethodBeat.o(135456);
      return;
    }
    this.omn = paramInt;
    if (this.omo)
    {
      AppMethodBeat.o(135456);
      return;
    }
    super.yf(paramInt);
    AppMethodBeat.o(135456);
  }
  
  final class a
    extends ColorDrawable
  {
    a()
    {
      super();
    }
    
    private void cai()
    {
      AppMethodBeat.i(135446);
      d.this.setStatusBarColor(getColor());
      AppMethodBeat.o(135446);
    }
    
    public final void setAlpha(int paramInt)
    {
      AppMethodBeat.i(135445);
      super.setAlpha(paramInt);
      cai();
      AppMethodBeat.o(135445);
    }
    
    public final void setColor(int paramInt)
    {
      AppMethodBeat.i(135444);
      super.setColor(paramInt);
      cai();
      AppMethodBeat.o(135444);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.actionbar.d
 * JD-Core Version:    0.7.0.1
 */