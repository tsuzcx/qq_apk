package androidx.core.g;

import android.os.Build.VERSION;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h
{
  public static int a(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
  {
    AppMethodBeat.i(251457);
    if (Build.VERSION.SDK_INT >= 17)
    {
      i = paramMarginLayoutParams.getMarginStart();
      AppMethodBeat.o(251457);
      return i;
    }
    int i = paramMarginLayoutParams.leftMargin;
    AppMethodBeat.o(251457);
    return i;
  }
  
  public static void a(ViewGroup.MarginLayoutParams paramMarginLayoutParams, int paramInt)
  {
    AppMethodBeat.i(251460);
    if (Build.VERSION.SDK_INT >= 17)
    {
      paramMarginLayoutParams.setMarginEnd(paramInt);
      AppMethodBeat.o(251460);
      return;
    }
    paramMarginLayoutParams.rightMargin = paramInt;
    AppMethodBeat.o(251460);
  }
  
  public static int b(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
  {
    AppMethodBeat.i(251458);
    if (Build.VERSION.SDK_INT >= 17)
    {
      i = paramMarginLayoutParams.getMarginEnd();
      AppMethodBeat.o(251458);
      return i;
    }
    int i = paramMarginLayoutParams.rightMargin;
    AppMethodBeat.o(251458);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.core.g.h
 * JD-Core Version:    0.7.0.1
 */