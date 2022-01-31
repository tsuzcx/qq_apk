package com.tencent.mm.plugin.appbrand.jsapi.m;

import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Calendar;
import java.util.Date;
import org.json.JSONObject;

final class a
  extends d
{
  volatile int gzA = -1;
  volatile a.a gzv;
  volatile Long gzw = null;
  volatile Long gzx = null;
  volatile int gzy = -1;
  volatile int gzz = -1;
  
  final void z(JSONObject paramJSONObject)
  {
    this.gzv = a.a.uA(paramJSONObject.optString("fields"));
    Object localObject2 = paramJSONObject.optJSONObject("range");
    if (localObject2 != null)
    {
      localObject1 = ((JSONObject)localObject2).optString("start", "");
      localObject1 = this.gzv.parse((String)localObject1);
      localObject2 = ((JSONObject)localObject2).optString("end", "");
      localObject2 = this.gzv.parse((String)localObject2);
      if (localObject1 != null) {
        this.gzw = Long.valueOf(((Date)localObject1).getTime());
      }
      if (localObject2 != null) {
        this.gzx = Long.valueOf(((Date)localObject2).getTime());
      }
    }
    if (this.gzw == null)
    {
      localObject1 = Calendar.getInstance(x.ueU);
      ((Calendar)localObject1).set(1900, 0, 1);
      this.gzw = Long.valueOf(((Calendar)localObject1).getTimeInMillis());
    }
    if (this.gzx == null)
    {
      localObject1 = Calendar.getInstance(x.ueU);
      ((Calendar)localObject1).set(2100, 11, 31);
      this.gzx = Long.valueOf(((Calendar)localObject1).getTimeInMillis());
    }
    paramJSONObject = paramJSONObject.optString("current", "");
    Object localObject1 = this.gzv.parse(paramJSONObject);
    paramJSONObject = (JSONObject)localObject1;
    if (localObject1 == null)
    {
      paramJSONObject = new Date(System.currentTimeMillis());
      localObject1 = new Date(this.gzx.longValue());
      localObject2 = new Date(this.gzw.longValue());
      if (!paramJSONObject.after((Date)localObject1)) {
        break label277;
      }
      paramJSONObject = (JSONObject)localObject1;
    }
    for (;;)
    {
      this.gzy = (paramJSONObject.getYear() + 1900);
      this.gzz = (paramJSONObject.getMonth() + 1);
      this.gzA = paramJSONObject.getDate();
      ai.d(new a.1(this));
      return;
      label277:
      if (paramJSONObject.before((Date)localObject2)) {
        paramJSONObject = (JSONObject)localObject2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.m.a
 * JD-Core Version:    0.7.0.1
 */