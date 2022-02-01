package androidx.appcompat.view;

import android.view.InflateException;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;

final class g$a
  implements MenuItem.OnMenuItemClickListener
{
  private static final Class<?>[] jY = { MenuItem.class };
  private Object jX;
  private Method mMethod;
  
  public g$a(Object paramObject, String paramString)
  {
    AppMethodBeat.i(238970);
    this.jX = paramObject;
    Class localClass = paramObject.getClass();
    try
    {
      this.mMethod = localClass.getMethod(paramString, jY);
      AppMethodBeat.o(238970);
      return;
    }
    catch (Exception paramObject)
    {
      paramString = new InflateException("Couldn't resolve menu item onClick handler " + paramString + " in class " + localClass.getName());
      paramString.initCause(paramObject);
      AppMethodBeat.o(238970);
      throw paramString;
    }
  }
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(238972);
    try
    {
      if (this.mMethod.getReturnType() == Boolean.TYPE)
      {
        boolean bool = ((Boolean)this.mMethod.invoke(this.jX, new Object[] { paramMenuItem })).booleanValue();
        AppMethodBeat.o(238972);
        return bool;
      }
      this.mMethod.invoke(this.jX, new Object[] { paramMenuItem });
      AppMethodBeat.o(238972);
      return true;
    }
    catch (Exception paramMenuItem)
    {
      paramMenuItem = new RuntimeException(paramMenuItem);
      AppMethodBeat.o(238972);
      throw paramMenuItem;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     androidx.appcompat.view.g.a
 * JD-Core Version:    0.7.0.1
 */