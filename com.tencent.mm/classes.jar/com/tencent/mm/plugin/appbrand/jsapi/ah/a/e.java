package com.tencent.mm.plugin.appbrand.jsapi.ah.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

public final class e
{
  public String mvQ = "ok";
  public List<d> pIS = null;
  
  public final JSONArray bXQ()
  {
    AppMethodBeat.i(144697);
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = this.pIS.iterator();
    while (localIterator.hasNext()) {
      localJSONArray.put(((d)localIterator.next()).toJSONObject());
    }
    AppMethodBeat.o(144697);
    return localJSONArray;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(144696);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("mErrorMsg:");
    ((StringBuilder)localObject).append(this.mvQ);
    ((StringBuilder)localObject).append(" mWifiList:");
    Iterator localIterator;
    if ((this.pIS != null) && (this.pIS.size() > 0)) {
      localIterator = this.pIS.iterator();
    }
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      ((StringBuilder)localObject).append(" WiFiItem:");
      ((StringBuilder)localObject).append(locald);
      continue;
      ((StringBuilder)localObject).append("null:");
    }
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(144696);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ah.a.e
 * JD-Core Version:    0.7.0.1
 */