package com.tencent.mm.plugin.flutter.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.g;
import com.tencent.mm.ac.i;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public final class c
{
  public HashMap<String, Object> params;
  public String rdo;
  public String rdp;
  public HashMap<String, Object> rdr;
  public int rds = 0;
  public boolean rdt = false;
  
  public c() {}
  
  public c(String paramString1, String paramString2, HashMap<String, Object> paramHashMap)
  {
    this.rdo = paramString1;
    this.rdp = paramString2;
    this.params = paramHashMap;
  }
  
  public final String aOj()
  {
    AppMethodBeat.i(123738);
    Object localObject = new i();
    Iterator localIterator;
    Map.Entry localEntry;
    try
    {
      ((i)localObject).j("plugin", this.rdo);
      ((i)localObject).j("entry", this.rdp);
      if (this.params != null)
      {
        i locali1 = new i();
        localIterator = this.params.entrySet().iterator();
        while (localIterator.hasNext())
        {
          localEntry = (Map.Entry)localIterator.next();
          locali1.j((String)localEntry.getKey(), localEntry.getValue());
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
      ((i)localObject).j("params", localg);
      if (this.rdr != null)
      {
        i locali2 = new i();
        localIterator = this.rdr.entrySet().iterator();
        while (localIterator.hasNext())
        {
          localEntry = (Map.Entry)localIterator.next();
          locali2.j((String)localEntry.getKey(), localEntry.getValue());
        }
        ((i)localObject).j("initParams", locali2);
      }
      ((i)localObject).O("parentPageType", this.rds);
      ((i)localObject).v("isInitRoute", this.rdt);
    }
  }
  
  public final c aag(String paramString)
  {
    AppMethodBeat.i(123737);
    i locali;
    Iterator localIterator;
    String str;
    Object localObject;
    try
    {
      paramString = new i(paramString);
      this.rdo = paramString.optString("plugin");
      this.rdp = paramString.optString("entry");
      locali = paramString.qK("params");
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
      locali = paramString.qK("initParams");
      if (locali != null)
      {
        this.rdr = new HashMap();
        localIterator = locali.keys();
        while (localIterator.hasNext())
        {
          str = (String)localIterator.next();
          localObject = locali.opt(str);
          this.rdr.put(str, localObject);
        }
      }
      this.rds = paramString.optInt("parentPageType");
      this.rdt = paramString.optBoolean("isInitRoute");
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(123739);
    String str = aOj();
    AppMethodBeat.o(123739);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.a.c
 * JD-Core Version:    0.7.0.1
 */