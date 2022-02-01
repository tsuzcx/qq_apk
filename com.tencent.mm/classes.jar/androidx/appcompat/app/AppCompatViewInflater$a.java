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
  private final View ic;
  private final String ie;
  private Method jdField_if;
  private Context ig;
  
  public AppCompatViewInflater$a(View paramView, String paramString)
  {
    this.ic = paramView;
    this.ie = paramString;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(200434);
    Context localContext;
    if (this.jdField_if == null) {
      localContext = this.ic.getContext();
    }
    while (localContext != null) {
      try
      {
        if (!localContext.isRestricted())
        {
          Method localMethod = localContext.getClass().getMethod(this.ie, new Class[] { View.class });
          if (localMethod != null)
          {
            this.jdField_if = localMethod;
            this.ig = localContext;
          }
        }
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        try
        {
          this.jdField_if.invoke(this.ig, new Object[] { paramView });
          AppMethodBeat.o(200434);
          return;
        }
        catch (IllegalAccessException paramView)
        {
          int i;
          paramView = new IllegalStateException("Could not execute non-public method for android:onClick", paramView);
          AppMethodBeat.o(200434);
          throw paramView;
        }
        catch (InvocationTargetException paramView)
        {
          paramView = new IllegalStateException("Could not execute method for android:onClick", paramView);
          AppMethodBeat.o(200434);
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
    i = this.ic.getId();
    if (i == -1) {}
    for (paramView = "";; paramView = " with id '" + this.ic.getContext().getResources().getResourceEntryName(i) + "'")
    {
      paramView = new IllegalStateException("Could not find method " + this.ie + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + this.ic.getClass() + paramView);
      AppMethodBeat.o(200434);
      throw paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     androidx.appcompat.app.AppCompatViewInflater.a
 * JD-Core Version:    0.7.0.1
 */