package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.t;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.statusbar.b;

public class d
  extends b
{
  private boolean kZc = true;
  private int lRa = 0;
  private boolean lRs = false;
  private int lRt;
  private boolean lRu = false;
  private Integer lRv = null;
  
  public d(Context paramContext)
  {
    super(paramContext);
  }
  
  private f getActionBar()
  {
    AppMethodBeat.i(194545);
    if (getChildCount() <= 0)
    {
      AppMethodBeat.o(194545);
      return null;
    }
    f localf = (f)getChildAt(0);
    AppMethodBeat.o(194545);
    return localf;
  }
  
  public final void L(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(135452);
    this.lRa = paramInt;
    this.lRs = paramBoolean;
    if (!this.kZc)
    {
      if (!this.lRu) {
        super.h(paramInt, paramBoolean, false);
      }
      AppMethodBeat.o(135452);
      return;
    }
    super.h(paramInt, paramBoolean, true);
    AppMethodBeat.o(135452);
  }
  
  public final void av(Context paramContext)
  {
    AppMethodBeat.i(135458);
    if ((getContext() instanceof MutableContextWrapper)) {
      ((MutableContextWrapper)getContext()).setBaseContext(paramContext);
    }
    if (this.lRv != null) {
      sG(0);
    }
    AppMethodBeat.o(135458);
  }
  
  public final void brj()
  {
    AppMethodBeat.i(135453);
    ad.d("Luggage.WXA.AppBrandActionBarContainer", "resetStatusBarForegroundStyle hash[%d] color[%d] foregroundDark[%b] mActuallyVisible[%b] mDeferStatusBarHeightChange[%b]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.lRa), Boolean.valueOf(this.lRs), Boolean.valueOf(this.kZc), Boolean.valueOf(this.lRu) });
    L(this.lRa, this.lRs);
    AppMethodBeat.o(135453);
  }
  
  public final void brk()
  {
    AppMethodBeat.i(194546);
    super.sG(this.lRt);
    AppMethodBeat.o(194546);
  }
  
  protected boolean canAnimate()
  {
    return false;
  }
  
  public void dispatchSystemUiVisibilityChanged(int paramInt)
  {
    AppMethodBeat.i(135449);
    super.dispatchSystemUiVisibilityChanged(paramInt);
    if ((this.kZc) && (t.aC(this)) && (Hln) && ((getWindowSystemUiVisibility() & 0x4) == 0))
    {
      ad.d("Luggage.WXA.AppBrandActionBarContainer", "dispatchSystemUiVisibilityChanged resetStatusBarForegroundStyle, hash[%d]", new Object[] { Integer.valueOf(hashCode()) });
      brj();
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
  
  public final void sG(int paramInt)
  {
    AppMethodBeat.i(135456);
    ad.d("Luggage.WXA.AppBrandActionBarContainer", "onStatusBarHeightChange: newHeight = ".concat(String.valueOf(paramInt)));
    if (this.lRv != null)
    {
      paramInt = this.lRv.intValue();
      this.lRt = paramInt;
      super.sG(paramInt);
      AppMethodBeat.o(135456);
      return;
    }
    this.lRt = paramInt;
    if (this.lRu)
    {
      AppMethodBeat.o(135456);
      return;
    }
    super.sG(paramInt);
    AppMethodBeat.o(135456);
  }
  
  public void setActuallyVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(135454);
    if (paramBoolean != this.kZc) {}
    for (int i = 1;; i = 0)
    {
      this.kZc = paramBoolean;
      if ((i != 0) && (paramBoolean))
      {
        brj();
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
    if (paramBoolean != this.lRu) {}
    for (int i = 1;; i = 0)
    {
      this.lRu = paramBoolean;
      if ((i != 0) && (!paramBoolean)) {
        super.sG(this.lRt);
      }
      AppMethodBeat.o(135455);
      return;
    }
  }
  
  public void setForceTopInsetsHeight(int paramInt)
  {
    AppMethodBeat.i(135457);
    this.lRv = Integer.valueOf(paramInt);
    AppMethodBeat.o(135457);
  }
  
  public void setStatusBarColor(int paramInt)
  {
    AppMethodBeat.i(135451);
    L(paramInt, this.lRs);
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
  
  final class a
    extends ColorDrawable
  {
    a()
    {
      super();
    }
    
    private void brl()
    {
      AppMethodBeat.i(135446);
      d.this.setStatusBarColor(getColor());
      AppMethodBeat.o(135446);
    }
    
    public final void setAlpha(int paramInt)
    {
      AppMethodBeat.i(135445);
      super.setAlpha(paramInt);
      brl();
      AppMethodBeat.o(135445);
    }
    
    public final void setColor(int paramInt)
    {
      AppMethodBeat.i(135444);
      super.setColor(paramInt);
      brl();
      AppMethodBeat.o(135444);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.actionbar.d
 * JD-Core Version:    0.7.0.1
 */