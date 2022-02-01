package com.tencent.matrix.resource.analyzer.model;

import java.lang.ref.PhantomReference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.EnumSet;
import java.util.Iterator;

public enum c
{
  private c() {}
  
  public static d.a n(int paramInt, String paramString)
  {
    Object localObject1 = EnumSet.allOf(c.class);
    d.b localb1 = new d.b();
    localObject1 = ((EnumSet)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (c)((Iterator)localObject1).next();
      if (((c)localObject2).o(paramInt, paramString))
      {
        ((c)localObject2).a(localb1);
        d.b localb2 = (d.b)localb1;
        localObject2 = ((c)localObject2).name();
        localb2.dbS.name = ((String)localObject2);
      }
    }
    return localb1;
  }
  
  abstract void a(d.a parama);
  
  boolean o(int paramInt, String paramString)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.matrix.resource.analyzer.model.c
 * JD-Core Version:    0.7.0.1
 */