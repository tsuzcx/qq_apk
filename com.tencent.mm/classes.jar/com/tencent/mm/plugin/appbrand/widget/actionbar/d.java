package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import androidx.core.g.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.i.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.statusbar.b;

public class d
  extends b
  implements i.b
{
  private boolean tvn = true;
  private int uyB = 0;
  private boolean uyV = false;
  private int uyW;
  private Integer uyX = null;
  
  public d(Context paramContext)
  {
    super(paramContext);
  }
  
  private f getActionBar()
  {
    AppMethodBeat.i(324154);
    if (getChildCount() <= 0)
    {
      AppMethodBeat.o(324154);
      return null;
    }
    f localf = (f)getChildAt(0);
    AppMethodBeat.o(324154);
    return localf;
  }
  
  public final void aj(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(135452);
    this.uyB = paramInt;
    this.uyV = paramBoolean;
    if (!this.tvn)
    {
      super.u(paramInt, paramBoolean, false);
      AppMethodBeat.o(135452);
      return;
    }
    super.u(paramInt, paramBoolean, true);
    AppMethodBeat.o(135452);
  }
  
  public final void bm(Context paramContext)
  {
    AppMethodBeat.i(135458);
    if ((getContext() instanceof MutableContextWrapper)) {
      ((MutableContextWrapper)getContext()).setBaseContext(paramContext);
    }
    if (this.uyX != null) {
      onStatusBarHeightChange(0);
    }
    AppMethodBeat.o(135458);
  }
  
  public final void cOY()
  {
    AppMethodBeat.i(135453);
    Log.d("Luggage.WXA.AppBrandActionBarContainer", "resetStatusBarForegroundStyle hash[%d] color[%d] foregroundDark[%b] mActuallyVisible[%b] isLayoutFrozen[%b]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.uyB), Boolean.valueOf(this.uyV), Boolean.valueOf(this.tvn), Boolean.valueOf(jCE()) });
    aj(this.uyB, this.uyV);
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
    if ((this.tvn) && (z.ay(this)) && (afCC) && ((getWindowSystemUiVisibility() & 0x4) == 0))
    {
      Log.d("Luggage.WXA.AppBrandActionBarContainer", "dispatchSystemUiVisibilityChanged resetStatusBarForegroundStyle, hash[%d]", new Object[] { Integer.valueOf(hashCode()) });
      cOY();
    }
    AppMethodBeat.o(135449);
  }
  
  public boolean hasOverlappingRendering()
  {
    return false;
  }
  
  public void onBackground()
  {
    AppMethodBeat.i(324194);
    setActuallyVisible(false);
    AppMethodBeat.o(324194);
  }
  
  public void onStatusBarHeightChange(int paramInt)
  {
    AppMethodBeat.i(135456);
    Log.i("Luggage.WXA.AppBrandActionBarContainer", "onStatusBarHeightChange: newHeight = ".concat(String.valueOf(paramInt)));
    if (this.uyX != null)
    {
      paramInt = this.uyX.intValue();
      this.uyW = paramInt;
      super.onStatusBarHeightChange(paramInt);
      AppMethodBeat.o(135456);
      return;
    }
    this.uyW = paramInt;
    if (jCE())
    {
      AppMethodBeat.o(135456);
      return;
    }
    super.onStatusBarHeightChange(paramInt);
    AppMethodBeat.o(135456);
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
    if (paramBoolean != this.tvn) {}
    for (int i = 1;; i = 0)
    {
      this.tvn = paramBoolean;
      if ((i != 0) && (paramBoolean))
      {
        setDeferStatusBarHeightChange(false);
        cOY();
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
    this.uyX = Integer.valueOf(paramInt);
    AppMethodBeat.o(135457);
  }
  
  public void setStatusBarColor(int paramInt)
  {
    AppMethodBeat.i(135451);
    aj(paramInt, this.uyV);
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
    aj(getActionBar().getBackgroundColor(), paramBoolean);
    AppMethodBeat.o(135450);
  }
  
  final class a
    extends ColorDrawable
  {
    a()
    {
      super();
    }
    
    private void cOZ()
    {
      AppMethodBeat.i(135446);
      d.this.setStatusBarColor(getColor());
      AppMethodBeat.o(135446);
    }
    
    public final void setAlpha(int paramInt)
    {
      AppMethodBeat.i(135445);
      super.setAlpha(paramInt);
      cOZ();
      AppMethodBeat.o(135445);
    }
    
    public final void setColor(int paramInt)
    {
      AppMethodBeat.i(135444);
      super.setColor(paramInt);
      cOZ();
      AppMethodBeat.o(135444);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.actionbar.d
 * JD-Core Version:    0.7.0.1
 */