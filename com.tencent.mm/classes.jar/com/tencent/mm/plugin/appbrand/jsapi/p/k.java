package com.tencent.mm.plugin.appbrand.jsapi.p;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.picker.c.a;
import org.json.JSONObject;

final class k
  extends e
{
  private int lhP = -1;
  private int lhQ = -1;
  private int mMaxTimeHour = 2147483647;
  private int mMaxTimeMinute = 2147483647;
  private int mMinTimeHour = -1;
  private int mMinTimeMinute = -1;
  
  final void T(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137619);
    super.T(paramJSONObject);
    AppMethodBeat.o(137619);
  }
  
  final void U(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137620);
    Object localObject2 = paramJSONObject.optJSONObject("range");
    if (localObject2 != null)
    {
      Object localObject1 = ((JSONObject)localObject2).optString("start");
      localObject2 = ((JSONObject)localObject2).optString("end");
      localObject1 = com.tencent.mm.plugin.appbrand.widget.picker.e.Wk((String)localObject1);
      if (localObject1 != null)
      {
        this.mMinTimeHour = localObject1[0];
        this.mMinTimeMinute = localObject1[1];
      }
      localObject1 = com.tencent.mm.plugin.appbrand.widget.picker.e.Wk((String)localObject2);
      if (localObject1 != null)
      {
        this.mMaxTimeHour = localObject1[0];
        this.mMaxTimeMinute = localObject1[1];
      }
    }
    this.mMinTimeHour = Math.max(this.mMinTimeHour, 0);
    this.mMinTimeMinute = Math.max(this.mMinTimeMinute, 0);
    this.mMaxTimeHour = Math.min(this.mMaxTimeHour, 23);
    this.mMaxTimeMinute = Math.min(this.mMaxTimeMinute, 59);
    paramJSONObject = com.tencent.mm.plugin.appbrand.widget.picker.e.Wk(paramJSONObject.optString("current"));
    if (paramJSONObject != null)
    {
      this.lhP = paramJSONObject[0];
      this.lhQ = paramJSONObject[1];
    }
    K(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(137615);
        k.a(k.this);
        AppMethodBeat.o(137615);
      }
    });
    AppMethodBeat.o(137620);
  }
  
  final void V(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137621);
    Object localObject2 = paramJSONObject.optJSONObject("range");
    if (localObject2 != null)
    {
      Object localObject1 = ((JSONObject)localObject2).optString("start");
      localObject2 = ((JSONObject)localObject2).optString("end");
      localObject1 = com.tencent.mm.plugin.appbrand.widget.picker.e.Wk((String)localObject1);
      if (localObject1 != null)
      {
        this.mMinTimeHour = localObject1[0];
        this.mMinTimeMinute = localObject1[1];
      }
      localObject1 = com.tencent.mm.plugin.appbrand.widget.picker.e.Wk((String)localObject2);
      if (localObject1 != null)
      {
        this.mMaxTimeHour = localObject1[0];
        this.mMaxTimeMinute = localObject1[1];
      }
    }
    this.mMinTimeHour = Math.max(this.mMinTimeHour, 0);
    this.mMinTimeMinute = Math.max(this.mMinTimeMinute, 0);
    this.mMaxTimeHour = Math.min(this.mMaxTimeHour, 23);
    this.mMaxTimeMinute = Math.min(this.mMaxTimeMinute, 59);
    paramJSONObject = com.tencent.mm.plugin.appbrand.widget.picker.e.Wk(paramJSONObject.optString("current"));
    if (paramJSONObject != null)
    {
      this.lhP = paramJSONObject[0];
      this.lhQ = paramJSONObject[1];
    }
    K(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(137616);
        k.b(k.this);
        AppMethodBeat.o(137616);
      }
    });
    AppMethodBeat.o(137621);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.p.k
 * JD-Core Version:    0.7.0.1
 */