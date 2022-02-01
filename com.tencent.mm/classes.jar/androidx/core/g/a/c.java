package androidx.core.g.a;

import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityManager;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  public static boolean a(AccessibilityManager paramAccessibilityManager, c.a parama)
  {
    AppMethodBeat.i(195968);
    if (Build.VERSION.SDK_INT >= 19)
    {
      if (parama == null)
      {
        AppMethodBeat.o(195968);
        return false;
      }
      boolean bool = paramAccessibilityManager.addTouchExplorationStateChangeListener(new c.b(parama));
      AppMethodBeat.o(195968);
      return bool;
    }
    AppMethodBeat.o(195968);
    return false;
  }
  
  public static boolean b(AccessibilityManager paramAccessibilityManager, c.a parama)
  {
    AppMethodBeat.i(195976);
    if (Build.VERSION.SDK_INT >= 19)
    {
      if (parama == null)
      {
        AppMethodBeat.o(195976);
        return false;
      }
      boolean bool = paramAccessibilityManager.removeTouchExplorationStateChangeListener(new c.b(parama));
      AppMethodBeat.o(195976);
      return bool;
    }
    AppMethodBeat.o(195976);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.core.g.a.c
 * JD-Core Version:    0.7.0.1
 */