package androidx.core.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Outline;
import android.graphics.Rect;
import android.view.Gravity;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class c
  extends b
{
  protected c(Resources paramResources, Bitmap paramBitmap)
  {
    super(paramResources, paramBitmap);
  }
  
  final void a(int paramInt1, int paramInt2, int paramInt3, Rect paramRect1, Rect paramRect2)
  {
    AppMethodBeat.i(196189);
    Gravity.apply(paramInt1, paramInt2, paramInt3, paramRect1, paramRect2, 0);
    AppMethodBeat.o(196189);
  }
  
  public final void getOutline(Outline paramOutline)
  {
    AppMethodBeat.i(196178);
    DK();
    paramOutline.setRoundRect(this.bre, getCornerRadius());
    AppMethodBeat.o(196178);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.core.graphics.drawable.c
 * JD-Core Version:    0.7.0.1
 */