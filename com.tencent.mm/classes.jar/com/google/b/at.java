package com.google.b;

import java.lang.reflect.Constructor;

final class at
{
  private static final aq<?> bWk = new as();
  private static final aq<?> bWl = HL();
  
  private static aq<?> HL()
  {
    try
    {
      aq localaq = (aq)Class.forName("com.google.b.ar").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
      return localaq;
    }
    catch (Exception localException) {}
    return null;
  }
  
  static aq<?> HM()
  {
    return bWk;
  }
  
  static aq<?> HN()
  {
    if (bWl == null) {
      throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }
    return bWl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.b.at
 * JD-Core Version:    0.7.0.1
 */