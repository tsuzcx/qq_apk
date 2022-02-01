package com.google.b;

import java.lang.reflect.Constructor;

final class cg
{
  private static final cd caj = ;
  private static final cd cak = new cf();
  
  static cd IJ()
  {
    return caj;
  }
  
  static cd IK()
  {
    return cak;
  }
  
  private static cd IL()
  {
    try
    {
      cd localcd = (cd)Class.forName("com.google.b.ce").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
      return localcd;
    }
    catch (Exception localException) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.b.cg
 * JD-Core Version:    0.7.0.1
 */