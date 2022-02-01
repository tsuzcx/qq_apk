package androidx.core.g;

import android.os.Build.VERSION;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class y
{
  public static int b(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(251804);
    if (Build.VERSION.SDK_INT >= 18)
    {
      int i = paramViewGroup.getLayoutMode();
      AppMethodBeat.o(251804);
      return i;
    }
    AppMethodBeat.o(251804);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.core.g.y
 * JD-Core Version:    0.7.0.1
 */