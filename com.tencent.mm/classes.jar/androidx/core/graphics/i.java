package androidx.core.graphics;

import android.graphics.Typeface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class i
  extends h
{
  protected final Typeface aw(Object paramObject)
  {
    AppMethodBeat.i(196062);
    try
    {
      Object localObject = Array.newInstance(this.bqH, 1);
      Array.set(localObject, 0, paramObject);
      paramObject = (Typeface)this.bqN.invoke(null, new Object[] { localObject, "sans-serif", Integer.valueOf(-1), Integer.valueOf(-1) });
      AppMethodBeat.o(196062);
      return paramObject;
    }
    catch (IllegalAccessException paramObject)
    {
      paramObject = new RuntimeException(paramObject);
      AppMethodBeat.o(196062);
      throw paramObject;
    }
    catch (InvocationTargetException paramObject)
    {
      label67:
      break label67;
    }
  }
  
  protected final Method i(Class<?> paramClass)
  {
    AppMethodBeat.i(196079);
    paramClass = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", new Class[] { Array.newInstance(paramClass, 1).getClass(), String.class, Integer.TYPE, Integer.TYPE });
    paramClass.setAccessible(true);
    AppMethodBeat.o(196079);
    return paramClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.core.graphics.i
 * JD-Core Version:    0.7.0.1
 */