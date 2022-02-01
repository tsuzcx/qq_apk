package com.tencent.mapsdk.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class pp
  extends View
{
  po a;
  
  public pp(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(225782);
    this.a = new po();
    if (Build.VERSION.SDK_INT < 16) {
      setBackgroundDrawable(this.a);
    }
    for (;;)
    {
      this.a.a(1.0F * getResources().getDisplayMetrics().density);
      AppMethodBeat.o(225782);
      return;
      setBackground(this.a);
    }
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(225790);
    super.onDraw(paramCanvas);
    AppMethodBeat.o(225790);
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(225800);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.a.setBounds(0, 0, paramInt3 - paramInt1, paramInt4 - paramInt2);
    AppMethodBeat.o(225800);
  }
  
  public final void setActivate(boolean paramBoolean)
  {
    AppMethodBeat.i(225804);
    if (this.a == null)
    {
      AppMethodBeat.o(225804);
      return;
    }
    this.a.a = paramBoolean;
    postInvalidate();
    AppMethodBeat.o(225804);
  }
  
  public final void setArrowStrokeWidth(float paramFloat)
  {
    AppMethodBeat.i(225814);
    if (this.a == null)
    {
      AppMethodBeat.o(225814);
      return;
    }
    this.a.a(paramFloat);
    postInvalidate();
    AppMethodBeat.o(225814);
  }
  
  public final void setDarkStyle(boolean paramBoolean)
  {
    AppMethodBeat.i(225819);
    this.a.b = paramBoolean;
    invalidate();
    AppMethodBeat.o(225819);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mapsdk.internal.pp
 * JD-Core Version:    0.7.0.1
 */