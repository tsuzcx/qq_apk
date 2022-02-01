package androidx.core.graphics;

import android.graphics.Bitmap;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public static int j(Bitmap paramBitmap)
  {
    AppMethodBeat.i(196068);
    if (Build.VERSION.SDK_INT >= 19)
    {
      i = paramBitmap.getAllocationByteCount();
      AppMethodBeat.o(196068);
      return i;
    }
    int i = paramBitmap.getByteCount();
    AppMethodBeat.o(196068);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     androidx.core.graphics.a
 * JD-Core Version:    0.7.0.1
 */