package com.google.d;

import java.lang.reflect.Constructor;

final class ax
{
  private static final au<?> dPY = new aw();
  private static final au<?> dPZ = ahN();
  
  private static au<?> ahN()
  {
    try
    {
      au localau = (au)Class.forName("com.google.d.av").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
      return localau;
    }
    catch (Exception localException) {}
    return null;
  }
  
  static au<?> ahO()
  {
    return dPY;
  }
  
  static au<?> ahP()
  {
    if (dPZ == null) {
      throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }
    return dPZ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.d.ax
 * JD-Core Version:    0.7.0.1
 */