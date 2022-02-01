package com.facebook.soloader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import dalvik.system.BaseDexClassLoader;
import java.lang.reflect.Method;

final class n$a
{
  public static String Qe()
  {
    AppMethodBeat.i(208106);
    Object localObject = n.class.getClassLoader();
    if ((localObject != null) && (!(localObject instanceof BaseDexClassLoader)))
    {
      localObject = new IllegalStateException("ClassLoader " + localObject.getClass().getName() + " should be of type BaseDexClassLoader");
      AppMethodBeat.o(208106);
      throw ((Throwable)localObject);
    }
    try
    {
      localObject = (BaseDexClassLoader)localObject;
      localObject = (String)BaseDexClassLoader.class.getMethod("getLdLibraryPath", new Class[0]).invoke(localObject, new Object[0]);
      AppMethodBeat.o(208106);
      return localObject;
    }
    catch (Exception localException)
    {
      RuntimeException localRuntimeException = new RuntimeException("Cannot call getLdLibraryPath", localException);
      AppMethodBeat.o(208106);
      throw localRuntimeException;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.facebook.soloader.n.a
 * JD-Core Version:    0.7.0.1
 */