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
  private final i rU;
  
  public AppCompatRatingBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, a.a.ratingBarStyle);
  }
  
  public AppCompatRatingBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(199296);
    this.rU = new i(this);
    this.rU.a(paramAttributeSet, paramInt);
    AppMethodBeat.o(199296);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    try
    {
      AppMethodBeat.i(199305);
      super.onMeasure(paramInt1, paramInt2);
      Bitmap localBitmap = this.rU.rT;
      if (localBitmap != null) {
        setMeasuredDimension(View.resolveSizeAndState(localBitmap.getWidth() * getNumStars(), paramInt1, 0), getMeasuredHeight());
      }
      AppMethodBeat.o(199305);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.appcompat.widget.AppCompatRatingBar
 * JD-Core Version:    0.7.0.1
 */