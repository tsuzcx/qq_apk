package com.google.a;

import java.lang.reflect.Method;

final class q
{
  static final Class<?> bUf = ;
  
  private static Class<?> FZ()
  {
    try
    {
      Class localClass = Class.forName("com.google.a.p");
      return localClass;
    }
    catch (ClassNotFoundException localClassNotFoundException) {}
    return null;
  }
  
  public static r Ga()
  {
    if (bUf != null) {
      try
      {
        r localr = (r)bUf.getDeclaredMethod("getEmptyRegistry", new Class[0]).invoke(null, new Object[0]);
        return localr;
      }
      catch (Exception localException) {}
    }
    return r.bUj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.a.q
 * JD-Core Version:    0.7.0.1
 */