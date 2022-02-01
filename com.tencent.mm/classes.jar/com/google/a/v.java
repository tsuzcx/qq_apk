package com.google.a;

import java.lang.reflect.Constructor;

final class v
{
  private static final s<?> bUm = new u();
  private static final s<?> bUn = Gf();
  
  private static s<?> Gf()
  {
    try
    {
      s locals = (s)Class.forName("com.google.a.t").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
      return locals;
    }
    catch (Exception localException) {}
    return null;
  }
  
  static s<?> Gg()
  {
    return bUm;
  }
  
  static s<?> Gh()
  {
    if (bUn == null) {
      throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }
    return bUn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.a.v
 * JD-Core Version:    0.7.0.1
 */