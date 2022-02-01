package androidx.core.g.a;

import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public static void a(AccessibilityEvent paramAccessibilityEvent, int paramInt)
  {
    AppMethodBeat.i(252020);
    if (Build.VERSION.SDK_INT >= 19) {
      paramAccessibilityEvent.setContentChangeTypes(paramInt);
    }
    AppMethodBeat.o(252020);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.core.g.a.b
 * JD-Core Version:    0.7.0.1
 */