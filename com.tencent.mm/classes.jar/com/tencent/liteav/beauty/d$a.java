package com.tencent.liteav.beauty;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class d$a
{
  WeakReference<d> a;
  private HashMap<String, String> b;
  
  public d$a(d paramd)
  {
    AppMethodBeat.i(229748);
    this.b = new HashMap();
    this.a = new WeakReference(paramd);
    AppMethodBeat.o(229748);
  }
  
  public String a()
  {
    AppMethodBeat.i(229755);
    Iterator localIterator = this.b.keySet().iterator();
    String str2;
    for (String str1 = ""; localIterator.hasNext(); str1 = str1 + str2 + ":" + (String)this.b.get(str2) + " ") {
      str2 = (String)localIterator.next();
    }
    str1 = "{" + str1 + "}";
    AppMethodBeat.o(229755);
    return str1;
  }
  
  public void a(String paramString, int paramInt)
  {
    AppMethodBeat.i(229751);
    this.b.put(paramString, String.valueOf(paramInt));
    paramString = (d)this.a.get();
    if (paramString != null)
    {
      String str = paramString.getID();
      if ((str != null) && (str.length() > 0)) {
        paramString.setStatusValue(3001, a());
      }
    }
    AppMethodBeat.o(229751);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.liteav.beauty.d.a
 * JD-Core Version:    0.7.0.1
 */