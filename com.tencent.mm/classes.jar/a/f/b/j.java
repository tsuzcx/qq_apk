package a.f.b;

import a.e;
import a.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.List;

public class j
{
  public static void ays(String paramString)
  {
    AppMethodBeat.i(55864);
    paramString = (x)o(new x("lateinit property " + paramString + " has not been initialized"));
    AppMethodBeat.o(55864);
    throw paramString;
  }
  
  static <T extends Throwable> T b(T paramT, String paramString)
  {
    AppMethodBeat.i(55869);
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
    AppMethodBeat.o(55869);
    return paramT;
  }
  
  public static int compare(int paramInt1, int paramInt2)
  {
    if (paramInt1 < paramInt2) {
      return -1;
    }
    if (paramInt1 == paramInt2) {
      return 0;
    }
    return 1;
  }
  
  public static boolean e(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(55867);
    if (paramObject1 == null)
    {
      if (paramObject2 == null)
      {
        AppMethodBeat.o(55867);
        return true;
      }
      AppMethodBeat.o(55867);
      return false;
    }
    boolean bool = paramObject1.equals(paramObject2);
    AppMethodBeat.o(55867);
    return bool;
  }
  
  public static void ebi()
  {
    AppMethodBeat.i(55863);
    e locale = (e)o(new e());
    AppMethodBeat.o(55863);
    throw locale;
  }
  
  private static <T extends Throwable> T o(T paramT)
  {
    AppMethodBeat.i(55868);
    paramT = b(paramT, j.class.getName());
    AppMethodBeat.o(55868);
    return paramT;
  }
  
  public static void p(Object paramObject, String paramString)
  {
    AppMethodBeat.i(55865);
    if (paramObject == null)
    {
      paramObject = (IllegalStateException)o(new IllegalStateException(paramString + " must not be null"));
      AppMethodBeat.o(55865);
      throw paramObject;
    }
    AppMethodBeat.o(55865);
  }
  
  public static void q(Object paramObject, String paramString)
  {
    AppMethodBeat.i(55866);
    if (paramObject == null)
    {
      Object localObject = java.lang.Thread.currentThread().getStackTrace()[3];
      paramObject = ((StackTraceElement)localObject).getClassName();
      localObject = ((StackTraceElement)localObject).getMethodName();
      paramObject = (IllegalArgumentException)o(new IllegalArgumentException("Parameter specified as non-null is null: method " + paramObject + "." + (String)localObject + ", parameter " + paramString));
      AppMethodBeat.o(55866);
      throw paramObject;
    }
    AppMethodBeat.o(55866);
  }
  
  public static String w(String paramString, Object paramObject)
  {
    AppMethodBeat.i(55862);
    paramString = paramString + paramObject;
    AppMethodBeat.o(55862);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     a.f.b.j
 * JD-Core Version:    0.7.0.1
 */