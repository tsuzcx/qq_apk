package androidx.core.g;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.Gravity;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
{
  public static void a(int paramInt1, int paramInt2, int paramInt3, Rect paramRect1, Rect paramRect2, int paramInt4)
  {
    AppMethodBeat.i(195702);
    if (Build.VERSION.SDK_INT >= 17)
    {
      Gravity.apply(paramInt1, paramInt2, paramInt3, paramRect1, paramRect2, paramInt4);
      AppMethodBeat.o(195702);
      return;
    }
    Gravity.apply(paramInt1, paramInt2, paramInt3, paramRect1, paramRect2);
    AppMethodBeat.o(195702);
  }
  
  public static int ay(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(195709);
    if (Build.VERSION.SDK_INT >= 17)
    {
      paramInt1 = Gravity.getAbsoluteGravity(paramInt1, paramInt2);
      AppMethodBeat.o(195709);
      return paramInt1;
    }
    AppMethodBeat.o(195709);
    return 0xFF7FFFFF & paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.core.g.e
 * JD-Core Version:    0.7.0.1
 */