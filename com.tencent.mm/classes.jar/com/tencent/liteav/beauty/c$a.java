package com.tencent.liteav.beauty;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class c$a
{
  WeakReference<c> a;
  private HashMap<String, String> b;
  
  public c$a(c paramc)
  {
    AppMethodBeat.i(66831);
    this.b = new HashMap();
    this.a = new WeakReference(paramc);
    AppMethodBeat.o(66831);
  }
  
  public String a()
  {
    AppMethodBeat.i(66833);
    Iterator localIterator = this.b.keySet().iterator();
    String str2;
    for (String str1 = ""; localIterator.hasNext(); str1 = str1 + str2 + ":" + (String)this.b.get(str2) + " ") {
      str2 = (String)localIterator.next();
    }
    str1 = "{" + str1 + "}";
    AppMethodBeat.o(66833);
    return str1;
  }
  
  public void a(String paramString, int paramInt)
  {
    AppMethodBeat.i(66832);
    this.b.put(paramString, String.valueOf(paramInt));
    paramString = (c)this.a.get();
    if (paramString != null)
    {
      String str = paramString.getID();
      if ((str != null) && (str.length() > 0)) {
        paramString.setStatusValue(3001, a());
      }
    }
    AppMethodBeat.o(66832);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.liteav.beauty.c.a
 * JD-Core Version:    0.7.0.1
 */