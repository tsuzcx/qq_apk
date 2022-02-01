package com.google.a;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class r
{
  private static volatile boolean bUg = false;
  private static final Class<?> bUh = Gb();
  private static volatile r bUi;
  static final r bUj = new r((byte)0);
  private final Map<Object, Object<?, ?>> bUk;
  
  r()
  {
    this.bUk = new HashMap();
  }
  
  private r(byte paramByte)
  {
    this.bUk = Collections.emptyMap();
  }
  
  r(r paramr)
  {
    if (paramr == bUj)
    {
      this.bUk = Collections.emptyMap();
      return;
    }
    this.bUk = Collections.unmodifiableMap(paramr.bUk);
  }
  
  private static Class<?> Gb()
  {
    try
    {
      Class localClass = Class.forName("com.google.a.n");
      return localClass;
    }
    catch (ClassNotFoundException localClassNotFoundException) {}
    return null;
  }
  
  public static boolean Gc()
  {
    return bUg;
  }
  
  public static r Gd()
  {
    Object localObject = bUi;
    if (localObject == null) {
      try
      {
        r localr2 = bUi;
        localObject = localr2;
        if (localr2 == null)
        {
          localObject = q.Ga();
          bUi = (r)localObject;
        }
        return localObject;
      }
      finally {}
    }
    return localr1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.a.r
 * JD-Core Version:    0.7.0.1
 */