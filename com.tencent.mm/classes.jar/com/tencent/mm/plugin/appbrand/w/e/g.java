package com.tencent.mm.plugin.appbrand.w.e;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

public class g
  implements c
{
  private byte[] content;
  private TreeMap<String, String> hnv = new TreeMap(String.CASE_INSENSITIVE_ORDER);
  
  public final Iterator<String> aqQ()
  {
    return Collections.unmodifiableSet(this.hnv.keySet()).iterator();
  }
  
  public final byte[] aqR()
  {
    return this.content;
  }
  
  public final void put(String paramString1, String paramString2)
  {
    this.hnv.put(paramString1, paramString2);
  }
  
  public final String wS(String paramString)
  {
    String str = (String)this.hnv.get(paramString);
    paramString = str;
    if (str == null) {
      paramString = "";
    }
    return paramString;
  }
  
  public final boolean wT(String paramString)
  {
    return this.hnv.containsKey(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.w.e.g
 * JD-Core Version:    0.7.0.1
 */