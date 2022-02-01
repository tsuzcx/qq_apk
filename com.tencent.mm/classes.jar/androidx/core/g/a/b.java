package androidx.core.g.a;

import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public static void a(AccessibilityEvent paramAccessibilityEvent, int paramInt)
  {
    AppMethodBeat.i(195963);
    if (Build.VERSION.SDK_INT >= 19) {
      paramAccessibilityEvent.setContentChangeTypes(paramInt);
    }
    AppMethodBeat.o(195963);
  }
  
  public static int b(AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(195969);
    if (Build.VERSION.SDK_INT >= 19)
    {
      int i = paramAccessibilityEvent.getContentChangeTypes();
      AppMethodBeat.o(195969);
      return i;
    }
    AppMethodBeat.o(195969);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.core.g.a.b
 * JD-Core Version:    0.7.0.1
 */