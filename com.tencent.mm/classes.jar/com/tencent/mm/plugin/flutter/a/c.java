package com.tencent.mm.plugin.flutter.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.g;
import com.tencent.mm.ab.i;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

public final class c
{
  public LinkedHashMap<String, Object> mzT;
  public String wJd;
  public String wJe;
  public HashMap<String, Object> wJf;
  public int wJg = 0;
  public boolean wJh = false;
  
  public c() {}
  
  public c(String paramString1, String paramString2, LinkedHashMap<String, Object> paramLinkedHashMap)
  {
    this.wJd = paramString1;
    this.wJe = paramString2;
    this.mzT = paramLinkedHashMap;
  }
  
  public final String bua()
  {
    AppMethodBeat.i(123738);
    Object localObject = new i();
    Iterator localIterator;
    Map.Entry localEntry;
    try
    {
      ((i)localObject).h("plugin", this.wJd);
      ((i)localObject).h("entry", this.wJe);
      if (this.mzT != null)
      {
        i locali1 = new i();
        localIterator = this.mzT.entrySet().iterator();
        while (localIterator.hasNext())
        {
          localEntry = (Map.Entry)localIterator.next();
          locali1.h((String)localEntry.getKey(), localEntry.getValue());
          continue;
          localObject = ((i)localObject).toString();
        }
      }
    }
    catch (g localg) {}
    for (;;)
    {
      AppMethodBeat.o(123738);
      return localObject;
      ((i)localObject).h("params", localg);
      if (this.wJf != null)
      {
        i locali2 = new i();
        localIterator = this.wJf.entrySet().iterator();
        while (localIterator.hasNext())
        {
          localEntry = (Map.Entry)localIterator.next();
          locali2.h((String)localEntry.getKey(), localEntry.getValue());
        }
        ((i)localObject).h("initParams", locali2);
      }
      ((i)localObject).U("parentPageType", this.wJg);
      ((i)localObject).w("isInitRoute", this.wJh);
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(123739);
    String str = bua();
    AppMethodBeat.o(123739);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.a.c
 * JD-Core Version:    0.7.0.1
 */