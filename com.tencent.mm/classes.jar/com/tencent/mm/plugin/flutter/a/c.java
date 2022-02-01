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
  public String ttd;
  public String tte;
  public HashMap<String, Object> ttf;
  public int ttg = 0;
  public boolean tth = false;
  
  public c() {}
  
  public c(String paramString1, String paramString2, HashMap<String, Object> paramHashMap)
  {
    this.ttd = paramString1;
    this.tte = paramString2;
    this.params = paramHashMap;
  }
  
  public final String aYO()
  {
    AppMethodBeat.i(123738);
    Object localObject = new i();
    Iterator localIterator;
    Map.Entry localEntry;
    try
    {
      ((i)localObject).h("plugin", this.ttd);
      ((i)localObject).h("entry", this.tte);
      if (this.params != null)
      {
        i locali1 = new i();
        localIterator = this.params.entrySet().iterator();
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
      if (this.ttf != null)
      {
        i locali2 = new i();
        localIterator = this.ttf.entrySet().iterator();
        while (localIterator.hasNext())
        {
          localEntry = (Map.Entry)localIterator.next();
          locali2.h((String)localEntry.getKey(), localEntry.getValue());
        }
        ((i)localObject).h("initParams", locali2);
      }
      ((i)localObject).S("parentPageType", this.ttg);
      ((i)localObject).v("isInitRoute", this.tth);
    }
  }
  
  public final c akr(String paramString)
  {
    AppMethodBeat.i(123737);
    i locali;
    Iterator localIterator;
    String str;
    Object localObject;
    try
    {
      paramString = new i(paramString);
      this.ttd = paramString.optString("plugin");
      this.tte = paramString.optString("entry");
      locali = paramString.xy("params");
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
      locali = paramString.xy("initParams");
      if (locali != null)
      {
        this.ttf = new HashMap();
        localIterator = locali.keys();
        while (localIterator.hasNext())
        {
          str = (String)localIterator.next();
          localObject = locali.opt(str);
          this.ttf.put(str, localObject);
        }
      }
      this.ttg = paramString.optInt("parentPageType");
      this.tth = paramString.optBoolean("isInitRoute");
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(123739);
    String str = aYO();
    AppMethodBeat.o(123739);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.a.c
 * JD-Core Version:    0.7.0.1
 */