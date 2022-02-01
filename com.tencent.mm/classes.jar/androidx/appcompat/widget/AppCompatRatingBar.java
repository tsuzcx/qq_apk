package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RatingBar;
import androidx.appcompat.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AppCompatRatingBar
  extends RatingBar
{
  private final i qX;
  
  public AppCompatRatingBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, a.a.ratingBarStyle);
  }
  
  public AppCompatRatingBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(240946);
    this.qX = new i(this);
    this.qX.a(paramAttributeSet, paramInt);
    AppMethodBeat.o(240946);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    try
    {
      AppMethodBeat.i(240947);
      super.onMeasure(paramInt1, paramInt2);
      Bitmap localBitmap = this.qX.qW;
      if (localBitmap != null) {
        setMeasuredDimension(View.resolveSizeAndState(localBitmap.getWidth() * getNumStars(), paramInt1, 0), getMeasuredHeight());
      }
      AppMethodBeat.o(240947);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.appcompat.widget.AppCompatRatingBar
 * JD-Core Version:    0.7.0.1
 */