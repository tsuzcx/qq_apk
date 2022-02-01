package com.google.b;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ap
{
  private static volatile boolean bWe = false;
  private static final Class<?> bWf = HH();
  private static volatile ap bWg;
  static final ap bWh = new ap((byte)0);
  private final Map<Object, Object<?, ?>> bWi;
  
  ap()
  {
    this.bWi = new HashMap();
  }
  
  private ap(byte paramByte)
  {
    this.bWi = Collections.emptyMap();
  }
  
  ap(ap paramap)
  {
    if (paramap == bWh)
    {
      this.bWi = Collections.emptyMap();
      return;
    }
    this.bWi = Collections.unmodifiableMap(paramap.bWi);
  }
  
  private static Class<?> HH()
  {
    try
    {
      Class localClass = Class.forName("com.google.b.al");
      return localClass;
    }
    catch (ClassNotFoundException localClassNotFoundException) {}
    return null;
  }
  
  public static boolean HI()
  {
    return bWe;
  }
  
  public static ap HJ()
  {
    ap localap2 = bWg;
    ap localap1 = localap2;
    if (localap2 == null) {}
    try
    {
      localap2 = bWg;
      localap1 = localap2;
      if (localap2 == null)
      {
        localap1 = ao.HG();
        bWg = localap1;
      }
      return localap1;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.b.ap
 * JD-Core Version:    0.7.0.1
 */