package androidx.appcompat.view;

import android.view.InflateException;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;

final class g$a
  implements MenuItem.OnMenuItemClickListener
{
  private static final Class<?>[] kU = { MenuItem.class };
  private Object kT;
  private Method mMethod;
  
  public g$a(Object paramObject, String paramString)
  {
    AppMethodBeat.i(200714);
    this.kT = paramObject;
    Class localClass = paramObject.getClass();
    try
    {
      this.mMethod = localClass.getMethod(paramString, kU);
      AppMethodBeat.o(200714);
      return;
    }
    catch (Exception paramObject)
    {
      paramString = new InflateException("Couldn't resolve menu item onClick handler " + paramString + " in class " + localClass.getName());
      paramString.initCause(paramObject);
      AppMethodBeat.o(200714);
      throw paramString;
    }
  }
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(200739);
    try
    {
      if (this.mMethod.getReturnType() == Boolean.TYPE)
      {
        boolean bool = ((Boolean)this.mMethod.invoke(this.kT, new Object[] { paramMenuItem })).booleanValue();
        AppMethodBeat.o(200739);
        return bool;
      }
      this.mMethod.invoke(this.kT, new Object[] { paramMenuItem });
      AppMethodBeat.o(200739);
      return true;
    }
    catch (Exception paramMenuItem)
    {
      paramMenuItem = new RuntimeException(paramMenuItem);
      AppMethodBeat.o(200739);
      throw paramMenuItem;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.appcompat.view.g.a
 * JD-Core Version:    0.7.0.1
 */