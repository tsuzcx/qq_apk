package com.tencent.mm.plugin.flutter.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.g;
import com.tencent.mm.ad.i;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

public final class c
{
  public String BCt;
  public HashMap<String, Object> BCu;
  public int BCv = 0;
  public boolean BCw = false;
  public String fEX;
  public LinkedHashMap<String, Object> pyo;
  
  public c() {}
  
  public c(String paramString1, String paramString2, LinkedHashMap<String, Object> paramLinkedHashMap)
  {
    this.BCt = paramString1;
    this.fEX = paramString2;
    this.pyo = paramLinkedHashMap;
  }
  
  public final String bFa()
  {
    AppMethodBeat.i(123738);
    Object localObject = new i();
    Iterator localIterator;
    Map.Entry localEntry;
    try
    {
      ((i)localObject).g("plugin", this.BCt);
      ((i)localObject).g("entry", this.fEX);
      if (this.pyo != null)
      {
        i locali1 = new i();
        localIterator = this.pyo.entrySet().iterator();
        while (localIterator.hasNext())
        {
          localEntry = (Map.Entry)localIterator.next();
          locali1.g((String)localEntry.getKey(), localEntry.getValue());
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
      ((i)localObject).g("params", localg);
      if (this.BCu != null)
      {
        i locali2 = new i();
        localIterator = this.BCu.entrySet().iterator();
        while (localIterator.hasNext())
        {
          localEntry = (Map.Entry)localIterator.next();
          locali2.g((String)localEntry.getKey(), localEntry.getValue());
        }
        ((i)localObject).g("initParams", locali2);
      }
      ((i)localObject).al("parentPageType", this.BCv);
      ((i)localObject).y("isInitRoute", this.BCw);
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(123739);
    String str = bFa();
    AppMethodBeat.o(123739);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.a.c
 * JD-Core Version:    0.7.0.1
 */