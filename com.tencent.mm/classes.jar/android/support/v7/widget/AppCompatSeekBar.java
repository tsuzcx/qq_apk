package android.support.v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;

public class AppCompatSeekBar
  extends SeekBar
{
  private final k ahQ = new k(this);
  
  public AppCompatSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130969430);
  }
  
  public AppCompatSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.ahQ.a(paramAttributeSet, paramInt);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    k localk = this.ahQ;
    Drawable localDrawable = localk.ahS;
    if ((localDrawable != null) && (localDrawable.isStateful()) && (localDrawable.setState(localk.ahR.getDrawableState()))) {
      localk.ahR.invalidateDrawable(localDrawable);
    }
  }
  
  public void jumpDrawablesToCurrentState()
  {
    super.jumpDrawablesToCurrentState();
    k localk = this.ahQ;
    if (localk.ahS != null) {
      localk.ahS.jumpToCurrentState();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int j = 1;
    for (;;)
    {
      try
      {
        super.onDraw(paramCanvas);
        k localk = this.ahQ;
        if (localk.ahS != null)
        {
          int k = localk.ahR.getMax();
          if (k > 1)
          {
            i = localk.ahS.getIntrinsicWidth();
            int m = localk.ahS.getIntrinsicHeight();
            if (i < 0) {
              break label200;
            }
            i /= 2;
            if (m >= 0) {
              j = m / 2;
            }
            localk.ahS.setBounds(-i, -j, i, j);
            float f = (localk.ahR.getWidth() - localk.ahR.getPaddingLeft() - localk.ahR.getPaddingRight()) / k;
            j = paramCanvas.save();
            paramCanvas.translate(localk.ahR.getPaddingLeft(), localk.ahR.getHeight() / 2);
            i = 0;
            if (i <= k)
            {
              localk.ahS.draw(paramCanvas);
              paramCanvas.translate(f, 0.0F);
              i += 1;
              continue;
            }
            paramCanvas.restoreToCount(j);
          }
        }
        return;
      }
      finally {}
      label200:
      int i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.AppCompatSeekBar
 * JD-Core Version:    0.7.0.1
 */