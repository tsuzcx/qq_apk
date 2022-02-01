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
  private final j rV;
  
  public AppCompatSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, a.a.seekBarStyle);
  }
  
  public AppCompatSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(200270);
    this.rV = new j(this);
    this.rV.a(paramAttributeSet, paramInt);
    AppMethodBeat.o(200270);
  }
  
  protected void drawableStateChanged()
  {
    AppMethodBeat.i(200282);
    super.drawableStateChanged();
    j localj = this.rV;
    Drawable localDrawable = localj.rX;
    if ((localDrawable != null) && (localDrawable.isStateful()) && (localDrawable.setState(localj.rW.getDrawableState()))) {
      localj.rW.invalidateDrawable(localDrawable);
    }
    AppMethodBeat.o(200282);
  }
  
  public void jumpDrawablesToCurrentState()
  {
    AppMethodBeat.i(200292);
    super.jumpDrawablesToCurrentState();
    j localj = this.rV;
    if (localj.rX != null) {
      localj.rX.jumpToCurrentState();
    }
    AppMethodBeat.o(200292);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int j = 1;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(200277);
        super.onDraw(paramCanvas);
        j localj = this.rV;
        if (localj.rX != null)
        {
          int k = localj.rW.getMax();
          if (k > 1)
          {
            i = localj.rX.getIntrinsicWidth();
            int m = localj.rX.getIntrinsicHeight();
            if (i < 0) {
              break label210;
            }
            i /= 2;
            if (m >= 0) {
              j = m / 2;
            }
            localj.rX.setBounds(-i, -j, i, j);
            float f = (localj.rW.getWidth() - localj.rW.getPaddingLeft() - localj.rW.getPaddingRight()) / k;
            j = paramCanvas.save();
            paramCanvas.translate(localj.rW.getPaddingLeft(), localj.rW.getHeight() / 2);
            i = 0;
            if (i <= k)
            {
              localj.rX.draw(paramCanvas);
              paramCanvas.translate(f, 0.0F);
              i += 1;
              continue;
            }
            paramCanvas.restoreToCount(j);
          }
        }
        AppMethodBeat.o(200277);
        return;
      }
      finally {}
      label210:
      int i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.appcompat.widget.AppCompatSeekBar
 * JD-Core Version:    0.7.0.1
 */