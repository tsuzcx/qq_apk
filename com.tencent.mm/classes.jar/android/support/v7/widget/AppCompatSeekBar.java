package android.support.v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.a.a.a;
import android.util.AttributeSet;
import android.widget.SeekBar;

public class AppCompatSeekBar
  extends SeekBar
{
  private final l aaa = new l(this);
  
  public AppCompatSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, a.a.seekBarStyle);
  }
  
  public AppCompatSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.aaa.b(paramAttributeSet, paramInt);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    l locall = this.aaa;
    Drawable localDrawable = locall.aac;
    if ((localDrawable != null) && (localDrawable.isStateful()) && (localDrawable.setState(locall.aab.getDrawableState()))) {
      locall.aab.invalidateDrawable(localDrawable);
    }
  }
  
  public void jumpDrawablesToCurrentState()
  {
    super.jumpDrawablesToCurrentState();
    l locall = this.aaa;
    if (locall.aac != null) {
      locall.aac.jumpToCurrentState();
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
        l locall = this.aaa;
        if (locall.aac != null)
        {
          int k = locall.aab.getMax();
          if (k > 1)
          {
            i = locall.aac.getIntrinsicWidth();
            int m = locall.aac.getIntrinsicHeight();
            if (i < 0) {
              break label200;
            }
            i /= 2;
            if (m >= 0) {
              j = m / 2;
            }
            locall.aac.setBounds(-i, -j, i, j);
            float f = (locall.aab.getWidth() - locall.aab.getPaddingLeft() - locall.aab.getPaddingRight()) / k;
            j = paramCanvas.save();
            paramCanvas.translate(locall.aab.getPaddingLeft(), locall.aab.getHeight() / 2);
            i = 0;
            if (i <= k)
            {
              locall.aac.draw(paramCanvas);
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