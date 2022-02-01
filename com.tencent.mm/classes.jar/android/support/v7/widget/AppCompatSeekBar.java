package android.support.v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;

public class AppCompatSeekBar
  extends SeekBar
{
  private final k aiK = new k(this);
  
  public AppCompatSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130969430);
  }
  
  public AppCompatSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.aiK.a(paramAttributeSet, paramInt);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    k localk = this.aiK;
    Drawable localDrawable = localk.aiM;
    if ((localDrawable != null) && (localDrawable.isStateful()) && (localDrawable.setState(localk.aiL.getDrawableState()))) {
      localk.aiL.invalidateDrawable(localDrawable);
    }
  }
  
  public void jumpDrawablesToCurrentState()
  {
    super.jumpDrawablesToCurrentState();
    k localk = this.aiK;
    if (localk.aiM != null) {
      localk.aiM.jumpToCurrentState();
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
        k localk = this.aiK;
        if (localk.aiM != null)
        {
          int k = localk.aiL.getMax();
          if (k > 1)
          {
            i = localk.aiM.getIntrinsicWidth();
            int m = localk.aiM.getIntrinsicHeight();
            if (i < 0) {
              break label200;
            }
            i /= 2;
            if (m >= 0) {
              j = m / 2;
            }
            localk.aiM.setBounds(-i, -j, i, j);
            float f = (localk.aiL.getWidth() - localk.aiL.getPaddingLeft() - localk.aiL.getPaddingRight()) / k;
            j = paramCanvas.save();
            paramCanvas.translate(localk.aiL.getPaddingLeft(), localk.aiL.getHeight() / 2);
            i = 0;
            if (i <= k)
            {
              localk.aiM.draw(paramCanvas);
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