package androidx.compose.ui.g.a;

import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/input/key/KeyEvent;", "", "nativeKeyEvent", "Landroid/view/KeyEvent;", "Landroidx/compose/ui/input/key/NativeKeyEvent;", "constructor-impl", "(Landroid/view/KeyEvent;)Landroid/view/KeyEvent;", "getNativeKeyEvent", "()Landroid/view/KeyEvent;", "equals", "", "other", "equals-impl", "(Landroid/view/KeyEvent;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Landroid/view/KeyEvent;)I", "toString", "", "toString-impl", "(Landroid/view/KeyEvent;)Ljava/lang/String;", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public final KeyEvent aKk;
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(205713);
    KeyEvent localKeyEvent = this.aKk;
    if (!(paramObject instanceof b))
    {
      AppMethodBeat.o(205713);
      return false;
    }
    if (!s.p(localKeyEvent, ((b)paramObject).aKk))
    {
      AppMethodBeat.o(205713);
      return false;
    }
    AppMethodBeat.o(205713);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(205709);
    int i = this.aKk.hashCode();
    AppMethodBeat.o(205709);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(205704);
    Object localObject = this.aKk;
    localObject = "KeyEvent(nativeKeyEvent=" + localObject + ')';
    AppMethodBeat.o(205704);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     androidx.compose.ui.g.a.b
 * JD-Core Version:    0.7.0.1
 */