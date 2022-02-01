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
    AppMethodBeat.i(192418);
    g.Rt = new g.a()
    {
      public final void a(Canvas paramAnonymousCanvas, RectF paramAnonymousRectF, float paramAnonymousFloat, Paint paramAnonymousPaint)
      {
        AppMethodBeat.i(192435);
        paramAnonymousCanvas.drawRoundRect(paramAnonymousRectF, paramAnonymousFloat, paramAnonymousFloat, paramAnonymousPaint);
        AppMethodBeat.o(192435);
      }
    };
    AppMethodBeat.o(192418);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.cardview.widget.a
 * JD-Core Version:    0.7.0.1
 */