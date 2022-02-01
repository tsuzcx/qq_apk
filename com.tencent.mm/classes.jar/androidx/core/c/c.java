package androidx.core.c;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public final class c
{
  public static Handler b(Looper paramLooper)
  {
    AppMethodBeat.i(195432);
    if (Build.VERSION.SDK_INT >= 28)
    {
      paramLooper = Handler.createAsync(paramLooper);
      AppMethodBeat.o(195432);
      return paramLooper;
    }
    if (Build.VERSION.SDK_INT >= 17) {}
    try
    {
      Handler localHandler = (Handler)Handler.class.getDeclaredConstructor(new Class[] { Looper.class, Handler.Callback.class, Boolean.TYPE }).newInstance(new Object[] { paramLooper, null, Boolean.TRUE });
      AppMethodBeat.o(195432);
      return localHandler;
    }
    catch (InvocationTargetException paramLooper)
    {
      paramLooper = paramLooper.getCause();
      if ((paramLooper instanceof RuntimeException))
      {
        paramLooper = (RuntimeException)paramLooper;
        AppMethodBeat.o(195432);
        throw paramLooper;
      }
      if ((paramLooper instanceof Error))
      {
        paramLooper = (Error)paramLooper;
        AppMethodBeat.o(195432);
        throw paramLooper;
      }
      paramLooper = new RuntimeException(paramLooper);
      AppMethodBeat.o(195432);
      throw paramLooper;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      paramLooper = new Handler(paramLooper);
      AppMethodBeat.o(195432);
      return paramLooper;
    }
    catch (InstantiationException localInstantiationException)
    {
      break label151;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      label151:
      break label151;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.core.c.c
 * JD-Core Version:    0.7.0.1
 */