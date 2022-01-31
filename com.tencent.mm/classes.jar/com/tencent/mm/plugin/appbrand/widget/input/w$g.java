package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class w$g
  extends FrameLayout
  implements w.a
{
  private boolean jnt;
  
  public w$g(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(123778);
    this.jnt = false;
    LayoutInflater.from(paramContext).inflate(2130968779, this);
    AppMethodBeat.o(123778);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(123780);
    if ((this.jnt) || (!isShown()))
    {
      paramInt1 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
      paramInt2 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
    }
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(123780);
  }
  
  public final void setIsHide(boolean paramBoolean)
  {
    AppMethodBeat.i(123779);
    if (paramBoolean != this.jnt) {}
    for (int i = 1;; i = 0)
    {
      this.jnt = paramBoolean;
      if ((i != 0) && ((Build.VERSION.SDK_INT < 18) || (!isInLayout()))) {
        requestLayout();
      }
      AppMethodBeat.o(123779);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.w.g
 * JD-Core Version:    0.7.0.1
 */