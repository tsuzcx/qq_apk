package a.d.b;

import a.a;
import a.m;
import java.util.Arrays;
import java.util.List;

public class g
{
  public static void ahh(String paramString)
  {
    throw ((m)m(new m("lateinit property " + paramString + " has not been initialized")));
  }
  
  static <T extends Throwable> T b(T paramT, String paramString)
  {
    StackTraceElement[] arrayOfStackTraceElement = paramT.getStackTrace();
    int k = arrayOfStackTraceElement.length;
    int j = -1;
    int i = 0;
    while (i < k)
    {
      if (paramString.equals(arrayOfStackTraceElement[i].getClassName())) {
        j = i;
      }
      i += 1;
    }
    paramString = Arrays.asList(arrayOfStackTraceElement).subList(j + 1, k);
    paramT.setStackTrace((StackTraceElement[])paramString.toArray(new StackTraceElement[paramString.size()]));
    return paramT;
  }
  
  public static void cUk()
  {
    throw ((a)m(new a()));
  }
  
  public static boolean e(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == null) {
      return paramObject2 == null;
    }
    return paramObject1.equals(paramObject2);
  }
  
  public static void j(Object paramObject, String paramString)
  {
    if (paramObject == null) {
      throw ((IllegalStateException)m(new IllegalStateException(paramString + " must not be null")));
    }
  }
  
  public static void k(Object paramObject, String paramString)
  {
    if (paramObject == null)
    {
      Object localObject = java.lang.Thread.currentThread().getStackTrace()[3];
      paramObject = ((StackTraceElement)localObject).getClassName();
      localObject = ((StackTraceElement)localObject).getMethodName();
      throw ((IllegalArgumentException)m(new IllegalArgumentException("Parameter specified as non-null is null: method " + paramObject + "." + (String)localObject + ", parameter " + paramString)));
    }
  }
  
  private static <T extends Throwable> T m(T paramT)
  {
    return b(paramT, g.class.getName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     a.d.b.g
 * JD-Core Version:    0.7.0.1
 */