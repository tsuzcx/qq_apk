package androidx.transition;

import android.os.Build.VERSION;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ac
{
  static void c(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    AppMethodBeat.i(201603);
    if (Build.VERSION.SDK_INT >= 18)
    {
      ae.c(paramViewGroup, paramBoolean);
      AppMethodBeat.o(201603);
      return;
    }
    ad.c(paramViewGroup, paramBoolean);
    AppMethodBeat.o(201603);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     androidx.transition.ac
 * JD-Core Version:    0.7.0.1
 */