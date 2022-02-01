package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class w$h
  extends FrameLayout
  implements w.a
{
  private boolean ouu;
  
  public w$h(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(136514);
    this.ouu = false;
    LayoutInflater.from(paramContext).inflate(2131493150, this);
    AppMethodBeat.o(136514);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(136516);
    if ((this.ouu) || (!isShown()))
    {
      paramInt1 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
      paramInt2 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
    }
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(136516);
  }
  
  public final void setIsHide(boolean paramBoolean)
  {
    AppMethodBeat.i(136515);
    if (paramBoolean != this.ouu) {}
    for (int i = 1;; i = 0)
    {
      this.ouu = paramBoolean;
      if ((i != 0) && ((Build.VERSION.SDK_INT < 18) || (!isInLayout()))) {
        requestLayout();
      }
      AppMethodBeat.o(136515);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.w.h
 * JD-Core Version:    0.7.0.1
 */