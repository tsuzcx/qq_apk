package androidx.core.g;

import android.os.Build.VERSION;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h
{
  public static int a(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
  {
    AppMethodBeat.i(195731);
    if (Build.VERSION.SDK_INT >= 17)
    {
      i = paramMarginLayoutParams.getMarginStart();
      AppMethodBeat.o(195731);
      return i;
    }
    int i = paramMarginLayoutParams.leftMargin;
    AppMethodBeat.o(195731);
    return i;
  }
  
  public static void a(ViewGroup.MarginLayoutParams paramMarginLayoutParams, int paramInt)
  {
    AppMethodBeat.i(195750);
    if (Build.VERSION.SDK_INT >= 17)
    {
      paramMarginLayoutParams.setMarginEnd(paramInt);
      AppMethodBeat.o(195750);
      return;
    }
    paramMarginLayoutParams.rightMargin = paramInt;
    AppMethodBeat.o(195750);
  }
  
  public static int b(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
  {
    AppMethodBeat.i(195738);
    if (Build.VERSION.SDK_INT >= 17)
    {
      i = paramMarginLayoutParams.getMarginEnd();
      AppMethodBeat.o(195738);
      return i;
    }
    int i = paramMarginLayoutParams.rightMargin;
    AppMethodBeat.o(195738);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.core.g.h
 * JD-Core Version:    0.7.0.1
 */