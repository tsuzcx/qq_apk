package androidx.core.graphics;

import android.graphics.Typeface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class i
  extends h
{
  protected final Method a(Class<?> paramClass)
  {
    AppMethodBeat.i(250764);
    paramClass = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", new Class[] { Array.newInstance(paramClass, 1).getClass(), String.class, Integer.TYPE, Integer.TYPE });
    paramClass.setAccessible(true);
    AppMethodBeat.o(250764);
    return paramClass;
  }
  
  protected final Typeface x(Object paramObject)
  {
    AppMethodBeat.i(250763);
    try
    {
      Object localObject = Array.newInstance(this.Kz, 1);
      Array.set(localObject, 0, paramObject);
      paramObject = (Typeface)this.KF.invoke(null, new Object[] { localObject, "sans-serif", Integer.valueOf(-1), Integer.valueOf(-1) });
      AppMethodBeat.o(250763);
      return paramObject;
    }
    catch (IllegalAccessException paramObject)
    {
      paramObject = new RuntimeException(paramObject);
      AppMethodBeat.o(250763);
      throw paramObject;
    }
    catch (InvocationTargetException paramObject)
    {
      label67:
      break label67;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     androidx.core.graphics.i
 * JD-Core Version:    0.7.0.1
 */