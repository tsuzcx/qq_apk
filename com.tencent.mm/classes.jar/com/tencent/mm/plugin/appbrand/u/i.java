package com.tencent.mm.plugin.appbrand.u;

import java.util.HashSet;
import java.util.Set;

public final class i
{
  private static final Set<Object> geC = new HashSet();
  
  public static <T> T aU(T paramT)
  {
    if (paramT != null) {
      geC.add(paramT);
    }
    return paramT;
  }
  
  public static void aa(Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    geC.remove(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.u.i
 * JD-Core Version:    0.7.0.1
 */