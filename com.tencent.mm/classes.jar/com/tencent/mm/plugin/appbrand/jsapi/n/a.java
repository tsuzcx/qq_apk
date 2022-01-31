package com.tencent.mm.plugin.appbrand.jsapi.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.al;
import java.util.Calendar;
import java.util.Date;
import org.json.JSONObject;

final class a
  extends d
{
  volatile int hWA = -1;
  volatile int hWB = -1;
  volatile a.a hWw;
  volatile Long hWx = null;
  volatile Long hWy = null;
  volatile int hWz = -1;
  
  final void H(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(126343);
    this.hWw = a.a.CL(paramJSONObject.optString("fields"));
    Object localObject2 = paramJSONObject.optJSONObject("range");
    if (localObject2 != null)
    {
      localObject1 = ((JSONObject)localObject2).optString("start", "");
      localObject1 = this.hWw.parse((String)localObject1);
      localObject2 = ((JSONObject)localObject2).optString("end", "");
      localObject2 = this.hWw.parse((String)localObject2);
      if (localObject1 != null) {
        this.hWx = Long.valueOf(((Date)localObject1).getTime());
      }
      if (localObject2 != null) {
        this.hWy = Long.valueOf(((Date)localObject2).getTime());
      }
    }
    if (this.hWx == null)
    {
      localObject1 = Calendar.getInstance(aa.ynv);
      ((Calendar)localObject1).set(1900, 0, 1);
      this.hWx = Long.valueOf(((Calendar)localObject1).getTimeInMillis());
    }
    if (this.hWy == null)
    {
      localObject1 = Calendar.getInstance(aa.ynv);
      ((Calendar)localObject1).set(2100, 11, 31);
      this.hWy = Long.valueOf(((Calendar)localObject1).getTimeInMillis());
    }
    paramJSONObject = paramJSONObject.optString("current", "");
    Object localObject1 = this.hWw.parse(paramJSONObject);
    paramJSONObject = (JSONObject)localObject1;
    if (localObject1 == null)
    {
      paramJSONObject = new Date(System.currentTimeMillis());
      localObject1 = new Date(this.hWy.longValue());
      localObject2 = new Date(this.hWx.longValue());
      if (!paramJSONObject.after((Date)localObject1)) {
        break label287;
      }
      paramJSONObject = (JSONObject)localObject1;
    }
    for (;;)
    {
      this.hWz = (paramJSONObject.getYear() + 1900);
      this.hWA = (paramJSONObject.getMonth() + 1);
      this.hWB = paramJSONObject.getDate();
      al.d(new a.1(this));
      AppMethodBeat.o(126343);
      return;
      label287:
      if (paramJSONObject.before((Date)localObject2)) {
        paramJSONObject = (JSONObject)localObject2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.n.a
 * JD-Core Version:    0.7.0.1
 */