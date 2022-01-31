package com.tencent.mm.blink;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

public class FirstScreenFrameLayout
  extends FrameLayout
{
  public FirstScreenFrameLayout.a dYt;
  
  public FirstScreenFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public FirstScreenFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(57721);
    super.dispatchDraw(paramCanvas);
    if (this.dYt != null) {
      new ak(Looper.getMainLooper()).postAtFrontOfQueueV2(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(57720);
          if (FirstScreenFrameLayout.a(FirstScreenFrameLayout.this) != null)
          {
            FirstScreenFrameLayout.a(FirstScreenFrameLayout.this).HZ();
            FirstScreenFrameLayout.b(FirstScreenFrameLayout.this);
          }
          AppMethodBeat.o(57720);
        }
      });
    }
    AppMethodBeat.o(57721);
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(57722);
    super.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(57722);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.blink.FirstScreenFrameLayout
 * JD-Core Version:    0.7.0.1
 */