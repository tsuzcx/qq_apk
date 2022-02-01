package com.tencent.mapsdk.internal;

import android.content.Context;
import com.tencent.map.tools.Util;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

final class u$1
  implements rv
{
  u$1(u paramu) {}
  
  public final Class a(String paramString)
  {
    AppMethodBeat.i(223523);
    paramString = Util.findClass(paramString, getClass().getClassLoader());
    AppMethodBeat.o(223523);
    return paramString;
  }
  
  public final <T> Class<? extends T> a(String paramString, Class<T> paramClass)
  {
    AppMethodBeat.i(223531);
    paramString = Util.findClass(paramString, paramClass, getClass().getClassLoader());
    AppMethodBeat.o(223531);
    return paramString;
  }
  
  public final Object a(Class paramClass, String paramString, Class[] paramArrayOfClass, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(223575);
    paramClass = Util.invokeStaticMethod(paramClass, paramString, paramArrayOfClass, paramArrayOfObject);
    AppMethodBeat.o(223575);
    return paramClass;
  }
  
  public final <T> T a(Class<T> paramClass, Object... paramVarArgs)
  {
    AppMethodBeat.i(223546);
    paramClass = Util.newInstance(paramClass, paramVarArgs);
    AppMethodBeat.o(223546);
    return paramClass;
  }
  
  public final Object a(Object paramObject, String paramString, Class[] paramArrayOfClass, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(223568);
    paramObject = Util.invokeMethod(paramObject, paramString, paramArrayOfClass, paramArrayOfObject);
    AppMethodBeat.o(223568);
    return paramObject;
  }
  
  public final Object a(Object paramObject, String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(223560);
    paramObject = Util.invokeMethod(paramObject, paramString, paramVarArgs);
    AppMethodBeat.o(223560);
    return paramObject;
  }
  
  public final void a(Context paramContext, String paramString) {}
  
  public final ClassLoader b()
  {
    AppMethodBeat.i(223554);
    ClassLoader localClassLoader = getClass().getClassLoader();
    AppMethodBeat.o(223554);
    return localClassLoader;
  }
  
  public final Object b(String paramString)
  {
    AppMethodBeat.i(223537);
    paramString = Util.newInstance(a(paramString), new Object[0]);
    AppMethodBeat.o(223537);
    return paramString;
  }
  
  public final int c()
  {
    return 0;
  }
  
  public final File d()
  {
    return null;
  }
  
  public final void i() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mapsdk.internal.u.1
 * JD-Core Version:    0.7.0.1
 */