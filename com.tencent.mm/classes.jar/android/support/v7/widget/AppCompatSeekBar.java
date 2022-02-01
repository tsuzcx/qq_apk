package android.support.v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;

public class AppCompatSeekBar
  extends SeekBar
{
  private final k akO = new k(this);
  
  public AppCompatSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130969512);
  }
  
  public AppCompatSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.akO.a(paramAttributeSet, paramInt);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    k localk = this.akO;
    Drawable localDrawable = localk.akQ;
    if ((localDrawable != null) && (localDrawable.isStateful()) && (localDrawable.setState(localk.akP.getDrawableState()))) {
      localk.akP.invalidateDrawable(localDrawable);
    }
  }
  
  public void jumpDrawablesToCurrentState()
  {
    super.jumpDrawablesToCurrentState();
    k localk = this.akO;
    if (localk.akQ != null) {
      localk.akQ.jumpToCurrentState();
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
        k localk = this.akO;
        if (localk.akQ != null)
        {
          int k = localk.akP.getMax();
          if (k > 1)
          {
            i = localk.akQ.getIntrinsicWidth();
            int m = localk.akQ.getIntrinsicHeight();
            if (i < 0) {
              break label200;
            }
            i /= 2;
            if (m >= 0) {
              j = m / 2;
            }
            localk.akQ.setBounds(-i, -j, i, j);
            float f = (localk.akP.getWidth() - localk.akP.getPaddingLeft() - localk.akP.getPaddingRight()) / k;
            j = paramCanvas.save();
            paramCanvas.translate(localk.akP.getPaddingLeft(), localk.akP.getHeight() / 2);
            i = 0;
            if (i <= k)
            {
              localk.akQ.draw(paramCanvas);
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