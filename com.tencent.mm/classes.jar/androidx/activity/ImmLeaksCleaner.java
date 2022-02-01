package androidx.activity;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.lifecycle.j.a;
import androidx.lifecycle.o;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;

final class ImmLeaksCleaner
  implements o
{
  private static int es = 0;
  private static Field et;
  private static Field eu;
  private static Field ev;
  private Activity mActivity;
  
  ImmLeaksCleaner(Activity paramActivity)
  {
    this.mActivity = paramActivity;
  }
  
  public final void onStateChanged(q paramq, j.a parama)
  {
    AppMethodBeat.i(199190);
    if (parama != j.a.ON_DESTROY)
    {
      AppMethodBeat.o(199190);
      return;
    }
    if (es == 0) {}
    try
    {
      es = 2;
      paramq = InputMethodManager.class.getDeclaredField("mServedView");
      eu = paramq;
      paramq.setAccessible(true);
      paramq = InputMethodManager.class.getDeclaredField("mNextServedView");
      ev = paramq;
      paramq.setAccessible(true);
      paramq = InputMethodManager.class.getDeclaredField("mH");
      et = paramq;
      paramq.setAccessible(true);
      es = 1;
      label83:
      if (es == 1)
      {
        parama = (InputMethodManager)this.mActivity.getSystemService("input_method");
        try
        {
          paramq = et.get(parama);
          if (paramq == null)
          {
            AppMethodBeat.o(199190);
            return;
          }
        }
        catch (IllegalAccessException paramq)
        {
          AppMethodBeat.o(199190);
          return;
        }
      }
      try
      {
        localView = (View)eu.get(parama);
        if (localView == null) {
          return;
        }
      }
      catch (IllegalAccessException parama) {}catch (ClassCastException parama)
      {
        View localView;
        return;
        if (localView.isAttachedToWindow()) {
          return;
        }
        try
        {
          ev.set(parama, null);
          parama.isActive();
          AppMethodBeat.o(199190);
          return;
        }
        catch (IllegalAccessException parama) {}
      }
      finally
      {
        AppMethodBeat.o(199190);
      }
    }
    catch (NoSuchFieldException paramq)
    {
      break label83;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     androidx.activity.ImmLeaksCleaner
 * JD-Core Version:    0.7.0.1
 */