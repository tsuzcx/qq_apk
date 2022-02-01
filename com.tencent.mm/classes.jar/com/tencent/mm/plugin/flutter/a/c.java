package com.tencent.mm.plugin.flutter.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.g;
import com.tencent.mm.ab.i;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public final class c
{
  public HashMap<String, Object> params;
  public String slI;
  public String slJ;
  public HashMap<String, Object> slK;
  public int slL = 0;
  public boolean slM = false;
  
  public c() {}
  
  public c(String paramString1, String paramString2, HashMap<String, Object> paramHashMap)
  {
    this.slI = paramString1;
    this.slJ = paramString2;
    this.params = paramHashMap;
  }
  
  public final String aUZ()
  {
    AppMethodBeat.i(123738);
    Object localObject = new i();
    Iterator localIterator;
    Map.Entry localEntry;
    try
    {
      ((i)localObject).i("plugin", this.slI);
      ((i)localObject).i("entry", this.slJ);
      if (this.params != null)
      {
        i locali1 = new i();
        localIterator = this.params.entrySet().iterator();
        while (localIterator.hasNext())
        {
          localEntry = (Map.Entry)localIterator.next();
          locali1.i((String)localEntry.getKey(), localEntry.getValue());
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
      ((i)localObject).i("params", localg);
      if (this.slK != null)
      {
        i locali2 = new i();
        localIterator = this.slK.entrySet().iterator();
        while (localIterator.hasNext())
        {
          localEntry = (Map.Entry)localIterator.next();
          locali2.i((String)localEntry.getKey(), localEntry.getValue());
        }
        ((i)localObject).i("initParams", locali2);
      }
      ((i)localObject).O("parentPageType", this.slL);
      ((i)localObject).v("isInitRoute", this.slM);
    }
  }
  
  public final c aeV(String paramString)
  {
    AppMethodBeat.i(123737);
    i locali;
    Iterator localIterator;
    String str;
    Object localObject;
    try
    {
      paramString = new i(paramString);
      this.slI = paramString.optString("plugin");
      this.slJ = paramString.optString("entry");
      locali = paramString.tZ("params");
      if (locali != null)
      {
        this.params = new HashMap();
        localIterator = locali.keys();
        while (localIterator.hasNext())
        {
          str = (String)localIterator.next();
          localObject = locali.opt(str);
          this.params.put(str, localObject);
          continue;
          AppMethodBeat.o(123737);
        }
      }
    }
    catch (Exception paramString) {}
    for (;;)
    {
      return this;
      locali = paramString.tZ("initParams");
      if (locali != null)
      {
        this.slK = new HashMap();
        localIterator = locali.keys();
        while (localIterator.hasNext())
        {
          str = (String)localIterator.next();
          localObject = locali.opt(str);
          this.slK.put(str, localObject);
        }
      }
      this.slL = paramString.optInt("parentPageType");
      this.slM = paramString.optBoolean("isInitRoute");
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(123739);
    String str = aUZ();
    AppMethodBeat.o(123739);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.a.c
 * JD-Core Version:    0.7.0.1
 */