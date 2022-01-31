package android.support.v7.app;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.support.v4.e.a;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public class AppCompatViewInflater
{
  private static final Class<?>[] PH = { Context.class, AttributeSet.class };
  static final int[] PI = { 16843375 };
  private static final String[] PJ = { "android.widget.", "android.view.", "android.webkit." };
  private static final Map<String, Constructor<? extends View>> PK = new a();
  private final Object[] PL = new Object[2];
  
  private View c(Context paramContext, String paramString1, String paramString2)
  {
    Constructor localConstructor = (Constructor)PK.get(paramString1);
    Object localObject = localConstructor;
    if (localConstructor == null) {}
    try
    {
      localObject = paramContext.getClassLoader();
      if (paramString2 != null) {}
      for (paramContext = paramString2 + paramString1;; paramContext = paramString1)
      {
        localObject = ((ClassLoader)localObject).loadClass(paramContext).asSubclass(View.class).getConstructor(PH);
        PK.put(paramString1, localObject);
        ((Constructor)localObject).setAccessible(true);
        paramContext = (View)((Constructor)localObject).newInstance(this.PL);
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
      this.PL[0] = paramContext;
      this.PL[1] = paramAttributeSet;
      if (-1 == str.indexOf('.'))
      {
        int i = 0;
        while (i < PJ.length)
        {
          paramString = c(paramContext, str, PJ[i]);
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
      this.PL[0] = null;
      this.PL[1] = null;
    }
  }
  
  static final class a
    implements View.OnClickListener
  {
    private final View PM;
    private final String PN;
    private Method PO;
    private Context PP;
    
    public a(View paramView, String paramString)
    {
      this.PM = paramView;
      this.PN = paramString;
    }
    
    public final void onClick(View paramView)
    {
      Context localContext;
      if (this.PO == null) {
        localContext = this.PM.getContext();
      }
      while (localContext != null) {
        try
        {
          if (!localContext.isRestricted())
          {
            Method localMethod = localContext.getClass().getMethod(this.PN, new Class[] { View.class });
            if (localMethod != null)
            {
              this.PO = localMethod;
              this.PP = localContext;
            }
          }
        }
        catch (NoSuchMethodException localNoSuchMethodException)
        {
          try
          {
            this.PO.invoke(this.PP, new Object[] { paramView });
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
      i = this.PM.getId();
      if (i == -1) {}
      for (paramView = "";; paramView = " with id '" + this.PM.getContext().getResources().getResourceEntryName(i) + "'") {
        throw new IllegalStateException("Could not find method " + this.PN + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + this.PM.getClass() + paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.app.AppCompatViewInflater
 * JD-Core Version:    0.7.0.1
 */