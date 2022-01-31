package com.tencent.mm.plugin.appbrand.j.b;

import com.tencent.mm.plugin.appbrand.d.b;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class m
  implements b
{
  private List<b> gMT = new LinkedList();
  
  public m()
  {
    this.gMT.add(new n());
    this.gMT.add(new k());
  }
  
  public final boolean a(c paramc, String paramString)
  {
    if ((paramc == null) || (paramString == null) || (paramString.length() == 0)) {
      return false;
    }
    Iterator localIterator = this.gMT.iterator();
    while (localIterator.hasNext()) {
      if (((b)localIterator.next()).a(paramc, paramString)) {
        return true;
      }
    }
    return false;
  }
  
  public final String b(c paramc, String paramString)
  {
    if ((paramc == null) || (paramString == null) || (paramString.length() == 0)) {}
    b localb;
    do
    {
      Iterator localIterator;
      while (!localIterator.hasNext())
      {
        return paramString;
        localIterator = this.gMT.iterator();
      }
      localb = (b)localIterator.next();
    } while (!localb.a(paramc, paramString));
    return localb.b(paramc, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.j.b.m
 * JD-Core Version:    0.7.0.1
 */