package com.google.d;

import java.lang.reflect.Constructor;

final class ca
{
  private static final bx dTT = ;
  private static final bx dTU = new bz();
  
  static bx aiP()
  {
    return dTT;
  }
  
  static bx aiQ()
  {
    return dTU;
  }
  
  private static bx aiR()
  {
    try
    {
      bx localbx = (bx)Class.forName("com.google.d.by").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
      return localbx;
    }
    catch (Exception localException) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.d.ca
 * JD-Core Version:    0.7.0.1
 */