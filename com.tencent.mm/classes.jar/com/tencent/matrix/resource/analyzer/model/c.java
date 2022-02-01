package com.tencent.matrix.resource.analyzer.model;

import java.lang.ref.PhantomReference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.EnumSet;
import java.util.Iterator;

public enum c
{
  private c() {}
  
  private static d.a a(EnumSet<c> paramEnumSet, int paramInt, String paramString)
  {
    d.b localb = new d.b();
    paramEnumSet = paramEnumSet.iterator();
    while (paramEnumSet.hasNext())
    {
      c localc = (c)paramEnumSet.next();
      if (localc.m(paramInt, paramString))
      {
        localc.a(localb);
        ((d.b)localb).jdMethod_do(localc.name());
      }
    }
    return localb;
  }
  
  public static d.a k(int paramInt, String paramString)
  {
    return a(EnumSet.of(cyx, cyy, cyz, cyA), paramInt, paramString);
  }
  
  public static d.a l(int paramInt, String paramString)
  {
    return a(EnumSet.allOf(c.class), paramInt, paramString);
  }
  
  abstract void a(d.a parama);
  
  boolean m(int paramInt, String paramString)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.resource.analyzer.model.c
 * JD-Core Version:    0.7.0.1
 */