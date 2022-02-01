package androidx.core.g;

import android.os.Build.VERSION;
import android.view.ViewGroup;
import androidx.core.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ab
{
  public static int c(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(195742);
    if (Build.VERSION.SDK_INT >= 18)
    {
      int i = paramViewGroup.getLayoutMode();
      AppMethodBeat.o(195742);
      return i;
    }
    AppMethodBeat.o(195742);
    return 0;
  }
  
  public static boolean d(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(195755);
    if (Build.VERSION.SDK_INT >= 21)
    {
      boolean bool = paramViewGroup.isTransitionGroup();
      AppMethodBeat.o(195755);
      return bool;
    }
    Boolean localBoolean = (Boolean)paramViewGroup.getTag(a.c.tag_transition_group);
    if (((localBoolean != null) && (localBoolean.booleanValue())) || (paramViewGroup.getBackground() != null) || (z.ai(paramViewGroup) != null))
    {
      AppMethodBeat.o(195755);
      return true;
    }
    AppMethodBeat.o(195755);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.core.g.ab
 * JD-Core Version:    0.7.0.1
 */