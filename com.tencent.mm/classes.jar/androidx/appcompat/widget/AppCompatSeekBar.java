package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.appcompat.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AppCompatSeekBar
  extends SeekBar
{
  private final j qY;
  
  public AppCompatSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, a.a.seekBarStyle);
  }
  
  public AppCompatSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(240948);
    this.qY = new j(this);
    this.qY.a(paramAttributeSet, paramInt);
    AppMethodBeat.o(240948);
  }
  
  protected void drawableStateChanged()
  {
    AppMethodBeat.i(240950);
    super.drawableStateChanged();
    j localj = this.qY;
    Drawable localDrawable = localj.ra;
    if ((localDrawable != null) && (localDrawable.isStateful()) && (localDrawable.setState(localj.qZ.getDrawableState()))) {
      localj.qZ.invalidateDrawable(localDrawable);
    }
    AppMethodBeat.o(240950);
  }
  
  public void jumpDrawablesToCurrentState()
  {
    AppMethodBeat.i(240951);
    super.jumpDrawablesToCurrentState();
    j localj = this.qY;
    if (localj.ra != null) {
      localj.ra.jumpToCurrentState();
    }
    AppMethodBeat.o(240951);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int j = 1;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(240949);
        super.onDraw(paramCanvas);
        j localj = this.qY;
        if (localj.ra != null)
        {
          int k = localj.qZ.getMax();
          if (k > 1)
          {
            i = localj.ra.getIntrinsicWidth();
            int m = localj.ra.getIntrinsicHeight();
            if (i < 0) {
              break label210;
            }
            i /= 2;
            if (m >= 0) {
              j = m / 2;
            }
            localj.ra.setBounds(-i, -j, i, j);
            float f = (localj.qZ.getWidth() - localj.qZ.getPaddingLeft() - localj.qZ.getPaddingRight()) / k;
            j = paramCanvas.save();
            paramCanvas.translate(localj.qZ.getPaddingLeft(), localj.qZ.getHeight() / 2);
            i = 0;
            if (i <= k)
            {
              localj.ra.draw(paramCanvas);
              paramCanvas.translate(f, 0.0F);
              i += 1;
              continue;
            }
            paramCanvas.restoreToCount(j);
          }
        }
        AppMethodBeat.o(240949);
        return;
      }
      finally {}
      label210:
      int i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.appcompat.widget.AppCompatSeekBar
 * JD-Core Version:    0.7.0.1
 */