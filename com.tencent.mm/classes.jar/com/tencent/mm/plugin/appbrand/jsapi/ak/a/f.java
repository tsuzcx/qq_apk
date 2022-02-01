package com.tencent.mm.plugin.appbrand.jsapi.ak.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

public final class f
{
  public String ppp = "ok";
  public List<e> sNM = null;
  
  public final JSONArray cyg()
  {
    AppMethodBeat.i(144697);
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = this.sNM.iterator();
    while (localIterator.hasNext()) {
      localJSONArray.put(((e)localIterator.next()).aZh());
    }
    AppMethodBeat.o(144697);
    return localJSONArray;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(144696);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("mErrorMsg:");
    ((StringBuilder)localObject).append(this.ppp);
    ((StringBuilder)localObject).append(" mWifiList:");
    Iterator localIterator;
    if ((this.sNM != null) && (this.sNM.size() > 0)) {
      localIterator = this.sNM.iterator();
    }
    while (localIterator.hasNext())
    {
      e locale = (e)localIterator.next();
      ((StringBuilder)localObject).append(" WiFiItem:");
      ((StringBuilder)localObject).append(locale);
      continue;
      ((StringBuilder)localObject).append("null:");
    }
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(144696);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ak.a.f
 * JD-Core Version:    0.7.0.1
 */