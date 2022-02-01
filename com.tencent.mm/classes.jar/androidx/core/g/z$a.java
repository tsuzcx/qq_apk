package androidx.core.g;

import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;

final class z$a
  implements View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener
{
  private WeakHashMap<View, Boolean> btL;
  
  z$a()
  {
    AppMethodBeat.i(195817);
    this.btL = new WeakHashMap();
    AppMethodBeat.o(195817);
  }
  
  public final void onGlobalLayout()
  {
    AppMethodBeat.i(195831);
    if (Build.VERSION.SDK_INT < 28)
    {
      Iterator localIterator = this.btL.entrySet().iterator();
      if (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        View localView = (View)localEntry.getKey();
        boolean bool2 = ((Boolean)localEntry.getValue()).booleanValue();
        boolean bool1;
        if (localView.getVisibility() == 0)
        {
          bool1 = true;
          label85:
          if (bool2 == bool1) {
            break label123;
          }
          if (!bool1) {
            break label125;
          }
        }
        label123:
        label125:
        for (int i = 16;; i = 32)
        {
          z.x(localView, i);
          this.btL.put(localView, Boolean.valueOf(bool1));
          break;
          bool1 = false;
          break label85;
          break;
        }
      }
    }
    AppMethodBeat.o(195831);
  }
  
  public final void onViewAttachedToWindow(View paramView)
  {
    AppMethodBeat.i(195842);
    paramView.getViewTreeObserver().addOnGlobalLayoutListener(this);
    AppMethodBeat.o(195842);
  }
  
  public final void onViewDetachedFromWindow(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     androidx.core.g.z.a
 * JD-Core Version:    0.7.0.1
 */