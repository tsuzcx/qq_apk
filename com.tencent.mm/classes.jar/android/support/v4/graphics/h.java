package android.support.v4.graphics;

import android.graphics.Typeface;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class h
  extends g
{
  protected final Method h(Class paramClass)
  {
    paramClass = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", new Class[] { Array.newInstance(paramClass, 1).getClass(), String.class, Integer.TYPE, Integer.TYPE });
    paramClass.setAccessible(true);
    return paramClass;
  }
  
  protected final Typeface p(Object paramObject)
  {
    try
    {
      Object localObject = Array.newInstance(this.HY, 1);
      Array.set(localObject, 0, paramObject);
      paramObject = (Typeface)this.If.invoke(null, new Object[] { localObject, "sans-serif", Integer.valueOf(-1), Integer.valueOf(-1) });
      return paramObject;
    }
    catch (IllegalAccessException paramObject)
    {
      throw new RuntimeException(paramObject);
    }
    catch (InvocationTargetException paramObject)
    {
      label57:
      break label57;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.graphics.h
 * JD-Core Version:    0.7.0.1
 */