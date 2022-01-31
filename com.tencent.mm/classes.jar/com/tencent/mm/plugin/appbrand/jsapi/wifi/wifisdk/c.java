package com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk;

import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

public final class c
{
  public List<b> gHb = null;
  public String gio = "ok";
  
  public final JSONArray aln()
  {
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = this.gHb.iterator();
    while (localIterator.hasNext()) {
      localJSONArray.put(((b)localIterator.next()).rB());
    }
    return localJSONArray;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mErrorMsg:");
    localStringBuilder.append(this.gio);
    localStringBuilder.append(" mWifiList:");
    Iterator localIterator;
    if ((this.gHb != null) && (this.gHb.size() > 0)) {
      localIterator = this.gHb.iterator();
    }
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      localStringBuilder.append(" WiFiItem:");
      localStringBuilder.append(localb);
      continue;
      localStringBuilder.append("null:");
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.c
 * JD-Core Version:    0.7.0.1
 */