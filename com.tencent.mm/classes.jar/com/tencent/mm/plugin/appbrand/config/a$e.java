package com.tencent.mm.plugin.appbrand.config;

import com.tencent.luggage.j.g;
import java.util.ArrayList;
import java.util.Iterator;

public final class a$e
{
  public ArrayList<a.f> bTS = new ArrayList();
  public String color;
  public String fNP;
  public String fNQ;
  public String fNR;
  public String fNS;
  
  public final boolean sf(String paramString)
  {
    Iterator localIterator = this.bTS.iterator();
    while (localIterator.hasNext()) {
      if (((a.f)localIterator.next()).url.equals(g.bi(paramString))) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.a.e
 * JD-Core Version:    0.7.0.1
 */