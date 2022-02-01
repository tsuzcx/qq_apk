package androidx.fragment.app;

import androidx.b.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class f
{
  private static final g<ClassLoader, g<String, Class<?>>> bCI;
  
  static
  {
    AppMethodBeat.i(193838);
    bCI = new g();
    AppMethodBeat.o(193838);
  }
  
  private static Class<?> a(ClassLoader paramClassLoader, String paramString)
  {
    AppMethodBeat.i(193801);
    g localg = (g)bCI.get(paramClassLoader);
    if (localg == null)
    {
      localg = new g();
      bCI.put(paramClassLoader, localg);
    }
    for (;;)
    {
      Class localClass2 = (Class)localg.get(paramString);
      Class localClass1 = localClass2;
      if (localClass2 == null)
      {
        localClass1 = Class.forName(paramString, false, paramClassLoader);
        localg.put(paramString, localClass1);
      }
      AppMethodBeat.o(193801);
      return localClass1;
    }
  }
  
  static boolean b(ClassLoader paramClassLoader, String paramString)
  {
    AppMethodBeat.i(193810);
    try
    {
      boolean bool = Fragment.class.isAssignableFrom(a(paramClassLoader, paramString));
      AppMethodBeat.o(193810);
      return bool;
    }
    catch (ClassNotFoundException paramClassLoader)
    {
      AppMethodBeat.o(193810);
    }
    return false;
  }
  
  public static Class<? extends Fragment> c(ClassLoader paramClassLoader, String paramString)
  {
    AppMethodBeat.i(193826);
    try
    {
      paramClassLoader = a(paramClassLoader, paramString);
      AppMethodBeat.o(193826);
      return paramClassLoader;
    }
    catch (ClassNotFoundException paramClassLoader)
    {
      paramClassLoader = new Fragment.b("Unable to instantiate fragment " + paramString + ": make sure class name exists", paramClassLoader);
      AppMethodBeat.o(193826);
      throw paramClassLoader;
    }
    catch (ClassCastException paramClassLoader)
    {
      paramClassLoader = new Fragment.b("Unable to instantiate fragment " + paramString + ": make sure class is a valid subclass of Fragment", paramClassLoader);
      AppMethodBeat.o(193826);
      throw paramClassLoader;
    }
  }
  
  public Fragment d(ClassLoader paramClassLoader, String paramString)
  {
    AppMethodBeat.i(193849);
    try
    {
      paramClassLoader = (Fragment)c(paramClassLoader, paramString).getConstructor(new Class[0]).newInstance(new Object[0]);
      AppMethodBeat.o(193849);
      return paramClassLoader;
    }
    catch (InstantiationException paramClassLoader)
    {
      paramClassLoader = new Fragment.b("Unable to instantiate fragment " + paramString + ": make sure class name exists, is public, and has an empty constructor that is public", paramClassLoader);
      AppMethodBeat.o(193849);
      throw paramClassLoader;
    }
    catch (IllegalAccessException paramClassLoader)
    {
      paramClassLoader = new Fragment.b("Unable to instantiate fragment " + paramString + ": make sure class name exists, is public, and has an empty constructor that is public", paramClassLoader);
      AppMethodBeat.o(193849);
      throw paramClassLoader;
    }
    catch (NoSuchMethodException paramClassLoader)
    {
      paramClassLoader = new Fragment.b("Unable to instantiate fragment " + paramString + ": could not find Fragment constructor", paramClassLoader);
      AppMethodBeat.o(193849);
      throw paramClassLoader;
    }
    catch (InvocationTargetException paramClassLoader)
    {
      paramClassLoader = new Fragment.b("Unable to instantiate fragment " + paramString + ": calling Fragment constructor caused an exception", paramClassLoader);
      AppMethodBeat.o(193849);
      throw paramClassLoader;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.fragment.app.f
 * JD-Core Version:    0.7.0.1
 */