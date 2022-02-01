package androidx.core.g;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;

final class w$a
  implements View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener
{
  private WeakHashMap<View, Boolean> NH;
  
  w$a()
  {
    AppMethodBeat.i(251593);
    this.NH = new WeakHashMap();
    AppMethodBeat.o(251593);
  }
  
  public final void onGlobalLayout()
  {
    AppMethodBeat.i(251594);
    Iterator localIterator = this.NH.entrySet().iterator();
    label108:
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      View localView = (View)localEntry.getKey();
      boolean bool2 = ((Boolean)localEntry.getValue()).booleanValue();
      if (localView.getVisibility() == 0) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        if (bool2 == bool1) {
          break label108;
        }
        if (bool1) {
          w.ar(localView);
        }
        this.NH.put(localView, Boolean.valueOf(bool1));
        break;
      }
    }
    AppMethodBeat.o(251594);
  }
  
  public final void onViewAttachedToWindow(View paramView)
  {
    AppMethodBeat.i(251597);
    paramView.getViewTreeObserver().addOnGlobalLayoutListener(this);
    AppMethodBeat.o(251597);
  }
  
  public final void onViewDetachedFromWindow(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     androidx.core.g.w.a
 * JD-Core Version:    0.7.0.1
 */