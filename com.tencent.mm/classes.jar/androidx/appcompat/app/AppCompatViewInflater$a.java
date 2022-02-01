package androidx.appcompat.app;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class AppCompatViewInflater$a
  implements View.OnClickListener
{
  private final View hh;
  private final String hi;
  private Method hj;
  private Context hk;
  
  public AppCompatViewInflater$a(View paramView, String paramString)
  {
    this.hh = paramView;
    this.hi = paramString;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(238366);
    Context localContext;
    if (this.hj == null) {
      localContext = this.hh.getContext();
    }
    while (localContext != null) {
      try
      {
        if (!localContext.isRestricted())
        {
          Method localMethod = localContext.getClass().getMethod(this.hi, new Class[] { View.class });
          if (localMethod != null)
          {
            this.hj = localMethod;
            this.hk = localContext;
          }
        }
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        try
        {
          this.hj.invoke(this.hk, new Object[] { paramView });
          AppMethodBeat.o(238366);
          return;
        }
        catch (IllegalAccessException paramView)
        {
          int i;
          paramView = new IllegalStateException("Could not execute non-public method for android:onClick", paramView);
          AppMethodBeat.o(238366);
          throw paramView;
        }
        catch (InvocationTargetException paramView)
        {
          paramView = new IllegalStateException("Could not execute method for android:onClick", paramView);
          AppMethodBeat.o(238366);
          throw paramView;
        }
        localNoSuchMethodException = localNoSuchMethodException;
        if ((localContext instanceof ContextWrapper)) {
          localContext = ((ContextWrapper)localContext).getBaseContext();
        } else {
          localContext = null;
        }
      }
    }
    i = this.hh.getId();
    if (i == -1) {}
    for (paramView = "";; paramView = " with id '" + this.hh.getContext().getResources().getResourceEntryName(i) + "'")
    {
      paramView = new IllegalStateException("Could not find method " + this.hi + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + this.hh.getClass() + paramView);
      AppMethodBeat.o(238366);
      throw paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     androidx.appcompat.app.AppCompatViewInflater.a
 * JD-Core Version:    0.7.0.1
 */