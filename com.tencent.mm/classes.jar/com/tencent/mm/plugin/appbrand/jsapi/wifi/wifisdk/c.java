package com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

public final class c
{
  public String hBF = "ok";
  public List<b> ihJ = null;
  
  public final JSONArray aGq()
  {
    AppMethodBeat.i(94382);
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = this.ihJ.iterator();
    while (localIterator.hasNext()) {
      localJSONArray.put(((b)localIterator.next()).toJSONObject());
    }
    AppMethodBeat.o(94382);
    return localJSONArray;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(94381);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("mErrorMsg:");
    ((StringBuilder)localObject).append(this.hBF);
    ((StringBuilder)localObject).append(" mWifiList:");
    Iterator localIterator;
    if ((this.ihJ != null) && (this.ihJ.size() > 0)) {
      localIterator = this.ihJ.iterator();
    }
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      ((StringBuilder)localObject).append(" WiFiItem:");
      ((StringBuilder)localObject).append(localb);
      continue;
      ((StringBuilder)localObject).append("null:");
    }
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(94381);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.c
 * JD-Core Version:    0.7.0.1
 */