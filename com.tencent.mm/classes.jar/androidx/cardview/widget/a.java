package androidx.cardview.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a
  extends c
{
  public final void initStatic()
  {
    AppMethodBeat.i(188123);
    g.ze = new g.a()
    {
      public final void a(Canvas paramAnonymousCanvas, RectF paramAnonymousRectF, float paramAnonymousFloat, Paint paramAnonymousPaint)
      {
        AppMethodBeat.i(188116);
        paramAnonymousCanvas.drawRoundRect(paramAnonymousRectF, paramAnonymousFloat, paramAnonymousFloat, paramAnonymousPaint);
        AppMethodBeat.o(188116);
      }
    };
    AppMethodBeat.o(188123);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.cardview.widget.a
 * JD-Core Version:    0.7.0.1
 */