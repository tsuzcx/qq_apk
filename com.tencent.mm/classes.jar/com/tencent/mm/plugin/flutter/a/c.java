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
  public String til;
  public String tim;
  public HashMap<String, Object> tin;
  public int tio = 0;
  public boolean tip = false;
  
  public c() {}
  
  public c(String paramString1, String paramString2, HashMap<String, Object> paramHashMap)
  {
    this.til = paramString1;
    this.tim = paramString2;
    this.params = paramHashMap;
  }
  
  public final String aYt()
  {
    AppMethodBeat.i(123738);
    Object localObject = new i();
    Iterator localIterator;
    Map.Entry localEntry;
    try
    {
      ((i)localObject).h("plugin", this.til);
      ((i)localObject).h("entry", this.tim);
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
      if (this.tin != null)
      {
        i locali2 = new i();
        localIterator = this.tin.entrySet().iterator();
        while (localIterator.hasNext())
        {
          localEntry = (Map.Entry)localIterator.next();
          locali2.h((String)localEntry.getKey(), localEntry.getValue());
        }
        ((i)localObject).h("initParams", locali2);
      }
      ((i)localObject).R("parentPageType", this.tio);
      ((i)localObject).v("isInitRoute", this.tip);
    }
  }
  
  public final c ajt(String paramString)
  {
    AppMethodBeat.i(123737);
    i locali;
    Iterator localIterator;
    String str;
    Object localObject;
    try
    {
      paramString = new i(paramString);
      this.til = paramString.optString("plugin");
      this.tim = paramString.optString("entry");
      locali = paramString.wP("params");
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
      locali = paramString.wP("initParams");
      if (locali != null)
      {
        this.tin = new HashMap();
        localIterator = locali.keys();
        while (localIterator.hasNext())
        {
          str = (String)localIterator.next();
          localObject = locali.opt(str);
          this.tin.put(str, localObject);
        }
      }
      this.tio = paramString.optInt("parentPageType");
      this.tip = paramString.optBoolean("isInitRoute");
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(123739);
    String str = aYt();
    AppMethodBeat.o(123739);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.a.c
 * JD-Core Version:    0.7.0.1
 */