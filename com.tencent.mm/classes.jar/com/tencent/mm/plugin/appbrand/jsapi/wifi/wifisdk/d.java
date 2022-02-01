package com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

public final class d
{
  public String iFQ = "ok";
  public List<c> lwr = null;
  
  public final JSONArray bpp()
  {
    AppMethodBeat.i(144697);
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = this.lwr.iterator();
    while (localIterator.hasNext()) {
      localJSONArray.put(((c)localIterator.next()).toJSONObject());
    }
    AppMethodBeat.o(144697);
    return localJSONArray;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(144696);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("mErrorMsg:");
    ((StringBuilder)localObject).append(this.iFQ);
    ((StringBuilder)localObject).append(" mWifiList:");
    Iterator localIterator;
    if ((this.lwr != null) && (this.lwr.size() > 0)) {
      localIterator = this.lwr.iterator();
    }
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      ((StringBuilder)localObject).append(" WiFiItem:");
      ((StringBuilder)localObject).append(localc);
      continue;
      ((StringBuilder)localObject).append("null:");
    }
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(144696);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.d
 * JD-Core Version:    0.7.0.1
 */