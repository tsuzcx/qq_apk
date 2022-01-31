package android.support.v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;

public class AppCompatSeekBar
  extends SeekBar
{
  private final k aaK = new k(this);
  
  public AppCompatSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130772234);
  }
  
  public AppCompatSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.aaK.a(paramAttributeSet, paramInt);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    k localk = this.aaK;
    Drawable localDrawable = localk.aaM;
    if ((localDrawable != null) && (localDrawable.isStateful()) && (localDrawable.setState(localk.aaL.getDrawableState()))) {
      localk.aaL.invalidateDrawable(localDrawable);
    }
  }
  
  public void jumpDrawablesToCurrentState()
  {
    super.jumpDrawablesToCurrentState();
    k localk = this.aaK;
    if (localk.aaM != null) {
      localk.aaM.jumpToCurrentState();
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
        k localk = this.aaK;
        if (localk.aaM != null)
        {
          int k = localk.aaL.getMax();
          if (k > 1)
          {
            i = localk.aaM.getIntrinsicWidth();
            int m = localk.aaM.getIntrinsicHeight();
            if (i < 0) {
              break label200;
            }
            i /= 2;
            if (m >= 0) {
              j = m / 2;
            }
            localk.aaM.setBounds(-i, -j, i, j);
            float f = (localk.aaL.getWidth() - localk.aaL.getPaddingLeft() - localk.aaL.getPaddingRight()) / k;
            j = paramCanvas.save();
            paramCanvas.translate(localk.aaL.getPaddingLeft(), localk.aaL.getHeight() / 2);
            i = 0;
            if (i <= k)
            {
              localk.aaM.draw(paramCanvas);
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