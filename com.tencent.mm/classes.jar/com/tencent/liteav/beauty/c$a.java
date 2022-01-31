package com.tencent.liteav.beauty;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class c$a
{
  WeakReference<c> a;
  private HashMap<String, String> b = new HashMap();
  
  public c$a(c paramc)
  {
    this.a = new WeakReference(paramc);
  }
  
  public String a()
  {
    Iterator localIterator = this.b.keySet().iterator();
    String str2;
    for (String str1 = ""; localIterator.hasNext(); str1 = str1 + str2 + ":" + (String)this.b.get(str2) + " ") {
      str2 = (String)localIterator.next();
    }
    return "{" + str1 + "}";
  }
  
  public void a(String paramString, int paramInt)
  {
    this.b.put(paramString, String.valueOf(paramInt));
    paramString = (c)this.a.get();
    if (paramString != null)
    {
      String str = paramString.getID();
      if ((str != null) && (str.length() > 0)) {
        paramString.setStatusValue(3001, a());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.liteav.beauty.c.a
 * JD-Core Version:    0.7.0.1
 */