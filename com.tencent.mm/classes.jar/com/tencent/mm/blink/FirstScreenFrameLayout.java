package com.tencent.mm.blink;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.mm.sdk.platformtools.ah;

public class FirstScreenFrameLayout
  extends FrameLayout
{
  public FirstScreenFrameLayout.a dhh;
  
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
    super.dispatchDraw(paramCanvas);
    if (this.dhh != null) {
      new ah(Looper.getMainLooper()).postAtFrontOfQueueV2(new Runnable()
      {
        public final void run()
        {
          if (FirstScreenFrameLayout.a(FirstScreenFrameLayout.this) != null)
          {
            FirstScreenFrameLayout.a(FirstScreenFrameLayout.this).vQ();
            FirstScreenFrameLayout.b(FirstScreenFrameLayout.this);
          }
        }
      });
    }
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.blink.FirstScreenFrameLayout
 * JD-Core Version:    0.7.0.1
 */