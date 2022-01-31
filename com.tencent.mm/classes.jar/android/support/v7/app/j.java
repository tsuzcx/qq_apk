package android.support.v7.app;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.support.v4.f.a;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public class j
{
  private static final Class<?>[] PZ = { Context.class, AttributeSet.class };
  static final int[] Qa = { 16843375 };
  private static final String[] Qb = { "android.widget.", "android.view.", "android.webkit." };
  private static final Map<String, Constructor<? extends View>> Qc = new a();
  private final Object[] Qd = new Object[2];
  
  private View c(Context paramContext, String paramString1, String paramString2)
  {
    Constructor localConstructor = (Constructor)Qc.get(paramString1);
    Object localObject = localConstructor;
    if (localConstructor == null) {}
    try
    {
      localObject = paramContext.getClassLoader();
      if (paramString2 != null) {}
      for (paramContext = paramString2 + paramString1;; paramContext = paramString1)
      {
        localObject = ((ClassLoader)localObject).loadClass(paramContext).asSubclass(View.class).getConstructor(PZ);
        Qc.put(paramString1, localObject);
        ((Constructor)localObject).setAccessible(true);
        paramContext = (View)((Constructor)localObject).newInstance(this.Qd);
        return paramContext;
      }
      return null;
    }
    catch (Exception paramContext) {}
  }
  
  final View a(Context paramContext, String paramString, AttributeSet paramAttributeSet)
  {
    String str = paramString;
    if (paramString.equals("view")) {
      str = paramAttributeSet.getAttributeValue(null, "class");
    }
    try
    {
      this.Qd[0] = paramContext;
      this.Qd[1] = paramAttributeSet;
      if (-1 == str.indexOf('.'))
      {
        int i = 0;
        while (i < Qb.length)
        {
          paramString = c(paramContext, str, Qb[i]);
          if (paramString != null) {
            return paramString;
          }
          i += 1;
        }
        return null;
      }
      paramContext = c(paramContext, str, null);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      return null;
    }
    finally
    {
      this.Qd[0] = null;
      this.Qd[1] = null;
    }
  }
  
  private static final class a
    implements View.OnClickListener
  {
    private final View Qe;
    private final String Qf;
    private Method Qg;
    private Context Qh;
    
    public a(View paramView, String paramString)
    {
      this.Qe = paramView;
      this.Qf = paramString;
    }
    
    public final void onClick(View paramView)
    {
      Context localContext;
      if (this.Qg == null) {
        localContext = this.Qe.getContext();
      }
      while (localContext != null) {
        try
        {
          if (!localContext.isRestricted())
          {
            Method localMethod = localContext.getClass().getMethod(this.Qf, new Class[] { View.class });
            if (localMethod != null)
            {
              this.Qg = localMethod;
              this.Qh = localContext;
            }
          }
        }
        catch (NoSuchMethodException localNoSuchMethodException)
        {
          try
          {
            this.Qg.invoke(this.Qh, new Object[] { paramView });
            return;
          }
          catch (IllegalAccessException paramView)
          {
            int i;
            throw new IllegalStateException("Could not execute non-public method for android:onClick", paramView);
          }
          catch (InvocationTargetException paramView)
          {
            throw new IllegalStateException("Could not execute method for android:onClick", paramView);
          }
          localNoSuchMethodException = localNoSuchMethodException;
          if ((localContext instanceof ContextWrapper)) {
            localContext = ((ContextWrapper)localContext).getBaseContext();
          } else {
            localContext = null;
          }
        }
      }
      i = this.Qe.getId();
      if (i == -1) {}
      for (paramView = "";; paramView = " with id '" + this.Qe.getContext().getResources().getResourceEntryName(i) + "'") {
        throw new IllegalStateException("Could not find method " + this.Qf + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + this.Qe.getClass() + paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.app.j
 * JD-Core Version:    0.7.0.1
 */