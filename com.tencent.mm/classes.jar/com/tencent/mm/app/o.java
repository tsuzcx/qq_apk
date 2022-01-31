package com.tencent.mm.app;

import java.util.HashSet;
import java.util.Set;

public final class o
{
  private static final Set<String> bxb;
  
  static
  {
    HashSet localHashSet = new HashSet();
    bxb = localHashSet;
    localHashSet.add(":nospace");
    bxb.add(":cuploader");
    bxb.add(":dexopt");
    bxb.add(":recovery");
    bxb.add(":fallback");
  }
  
  public static boolean cp(String paramString)
  {
    int i = paramString.indexOf(':');
    if (i != -1) {}
    for (paramString = paramString.substring(i);; paramString = "") {
      return bxb.contains(paramString);
    }
  }
  
  public static boolean ta()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.o
 * JD-Core Version:    0.7.0.1
 */