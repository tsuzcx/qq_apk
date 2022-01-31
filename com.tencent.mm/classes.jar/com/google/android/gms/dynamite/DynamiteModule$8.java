package com.google.android.gms.dynamite;

import dalvik.system.PathClassLoader;

final class DynamiteModule$8
  extends PathClassLoader
{
  DynamiteModule$8(String paramString, ClassLoader paramClassLoader)
  {
    super(paramString, paramClassLoader);
  }
  
  protected final Class<?> loadClass(String paramString, boolean paramBoolean)
  {
    if ((!paramString.startsWith("java.")) && (!paramString.startsWith("android."))) {
      try
      {
        Class localClass = findClass(paramString);
        return localClass;
      }
      catch (ClassNotFoundException localClassNotFoundException) {}
    }
    return super.loadClass(paramString, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.dynamite.DynamiteModule.8
 * JD-Core Version:    0.7.0.1
 */