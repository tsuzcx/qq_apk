package androidx.transition;

import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Property;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ChangeBounds$1
  extends Property<Drawable, PointF>
{
  private Rect mBounds;
  
  ChangeBounds$1(Class paramClass, String paramString)
  {
    super(paramClass, paramString);
    AppMethodBeat.i(191685);
    this.mBounds = new Rect();
    AppMethodBeat.o(191685);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.transition.ChangeBounds.1
 * JD-Core Version:    0.7.0.1
 */