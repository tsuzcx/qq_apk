package com.google.android.gms.dynamite;

import com.tencent.matrix.trace.core.AppMethodBeat;
import dalvik.system.PathClassLoader;

final class zzh
  extends PathClassLoader
{
  zzh(String paramString, ClassLoader paramClassLoader)
  {
    super(paramString, paramClassLoader);
  }
  
  protected final Class<?> loadClass(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(90456);
    if ((!paramString.startsWith("java.")) && (!paramString.startsWith("android."))) {
      try
      {
        Class localClass = findClass(paramString);
        AppMethodBeat.o(90456);
        return localClass;
      }
      catch (ClassNotFoundException localClassNotFoundException) {}
    }
    paramString = super.loadClass(paramString, paramBoolean);
    AppMethodBeat.o(90456);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.dynamite.zzh
 * JD-Core Version:    0.7.0.1
 */