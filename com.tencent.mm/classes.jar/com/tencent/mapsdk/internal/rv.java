package com.tencent.mapsdk.internal;

import java.io.File;

public abstract interface rv
  extends ry.a
{
  public abstract Class a(String paramString);
  
  public abstract <T> Class<? extends T> a(String paramString, Class<T> paramClass);
  
  public abstract Object a(Class paramClass, String paramString, Class[] paramArrayOfClass, Object[] paramArrayOfObject);
  
  public abstract <T> T a(Class<T> paramClass, Object... paramVarArgs);
  
  public abstract Object a(Object paramObject, String paramString, Class[] paramArrayOfClass, Object[] paramArrayOfObject);
  
  public abstract Object a(Object paramObject, String paramString, Object... paramVarArgs);
  
  public abstract ClassLoader b();
  
  public abstract Object b(String paramString);
  
  public abstract int c();
  
  public abstract File d();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.rv
 * JD-Core Version:    0.7.0.1
 */