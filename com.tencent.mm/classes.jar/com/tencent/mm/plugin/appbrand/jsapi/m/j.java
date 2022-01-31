package com.tencent.mm.plugin.appbrand.jsapi.m;

import com.tencent.mm.plugin.appbrand.widget.picker.f;
import com.tencent.mm.sdk.platformtools.ai;
import org.json.JSONObject;

final class j
  extends d
{
  int gAa = 2147483647;
  int gAb = -1;
  int gAc = -1;
  int gzX = -1;
  int gzY = -1;
  int gzZ = 2147483647;
  
  final void z(JSONObject paramJSONObject)
  {
    Object localObject2 = paramJSONObject.optJSONObject("range");
    if (localObject2 != null)
    {
      Object localObject1 = ((JSONObject)localObject2).optString("start");
      localObject2 = ((JSONObject)localObject2).optString("end");
      localObject1 = f.xi((String)localObject1);
      if (localObject1 != null)
      {
        this.gzX = localObject1[0];
        this.gzY = localObject1[1];
      }
      localObject1 = f.xi((String)localObject2);
      if (localObject1 != null)
      {
        this.gzZ = localObject1[0];
        this.gAa = localObject1[1];
      }
    }
    this.gzX = Math.max(this.gzX, 0);
    this.gzY = Math.max(this.gzY, 0);
    this.gzZ = Math.min(this.gzZ, 23);
    this.gAa = Math.min(this.gAa, 59);
    paramJSONObject = f.xi(paramJSONObject.optString("current"));
    if (paramJSONObject != null)
    {
      this.gAb = paramJSONObject[0];
      this.gAc = paramJSONObject[1];
    }
    ai.d(new j.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.m.j
 * JD-Core Version:    0.7.0.1
 */