package com.tencent.mm.plugin.appbrand.jsapi.n;

import android.widget.NumberPicker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandTimePicker;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandTimePickerV2;
import com.tencent.mm.plugin.appbrand.widget.picker.a;
import com.tencent.mm.plugin.appbrand.widget.picker.b;
import com.tencent.mm.plugin.appbrand.widget.picker.c.a;
import org.json.JSONObject;

final class k
  extends e
{
  int kgU = -1;
  int kgV = -1;
  int mMaxTimeHour = 2147483647;
  int mMaxTimeMinute = 2147483647;
  int mMinTimeHour = -1;
  int mMinTimeMinute = -1;
  
  final void R(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137619);
    super.R(paramJSONObject);
    AppMethodBeat.o(137619);
  }
  
  final void S(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137620);
    Object localObject2 = paramJSONObject.optJSONObject("range");
    if (localObject2 != null)
    {
      Object localObject1 = ((JSONObject)localObject2).optString("start");
      localObject2 = ((JSONObject)localObject2).optString("end");
      localObject1 = com.tencent.mm.plugin.appbrand.widget.picker.e.NS((String)localObject1);
      if (localObject1 != null)
      {
        this.mMinTimeHour = localObject1[0];
        this.mMinTimeMinute = localObject1[1];
      }
      localObject1 = com.tencent.mm.plugin.appbrand.widget.picker.e.NS((String)localObject2);
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
    paramJSONObject = com.tencent.mm.plugin.appbrand.widget.picker.e.NS(paramJSONObject.optString("current"));
    if (paramJSONObject != null)
    {
      this.kgU = paramJSONObject[0];
      this.kgV = paramJSONObject[1];
    }
    L(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(137615);
        k localk = k.this;
        AppBrandTimePicker localAppBrandTimePicker = (AppBrandTimePicker)localk.aK(AppBrandTimePicker.class);
        if (localAppBrandTimePicker == null)
        {
          localk.n("fail cant init view", null);
          AppMethodBeat.o(137615);
          return;
        }
        a locala = localk.mhO;
        int i = localk.mMinTimeHour;
        int j = localk.mMinTimeMinute;
        localAppBrandTimePicker.mMinTimeHour = i;
        localAppBrandTimePicker.mMinTimeMinute = j;
        if ((com.tencent.mm.plugin.appbrand.widget.picker.e.vo(localAppBrandTimePicker.mMinTimeHour)) && (localAppBrandTimePicker.miG != null)) {
          localAppBrandTimePicker.miG.setMinValue(localAppBrandTimePicker.mMinTimeHour);
        }
        i = localk.mMaxTimeHour;
        j = localk.mMaxTimeMinute;
        localAppBrandTimePicker.mMaxTimeHour = i;
        localAppBrandTimePicker.mMaxTimeMinute = j;
        if ((com.tencent.mm.plugin.appbrand.widget.picker.e.vo(localAppBrandTimePicker.mMaxTimeHour)) && (localAppBrandTimePicker.miG != null)) {
          localAppBrandTimePicker.miG.setMaxValue(localAppBrandTimePicker.mMaxTimeHour);
        }
        i = localk.kgU;
        j = localk.kgV;
        if ((com.tencent.mm.plugin.appbrand.widget.picker.e.vo(i)) && (com.tencent.mm.plugin.appbrand.widget.picker.e.vn(j)))
        {
          localAppBrandTimePicker.setCurrentHour(Integer.valueOf(i));
          localAppBrandTimePicker.setCurrentMinute(Integer.valueOf(j));
        }
        localAppBrandTimePicker.fRk();
        locala.setOnResultListener(new k.3(localk));
        locala.show();
        AppMethodBeat.o(137615);
      }
    });
    AppMethodBeat.o(137620);
  }
  
  final void T(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137621);
    Object localObject2 = paramJSONObject.optJSONObject("range");
    if (localObject2 != null)
    {
      Object localObject1 = ((JSONObject)localObject2).optString("start");
      localObject2 = ((JSONObject)localObject2).optString("end");
      localObject1 = com.tencent.mm.plugin.appbrand.widget.picker.e.NS((String)localObject1);
      if (localObject1 != null)
      {
        this.mMinTimeHour = localObject1[0];
        this.mMinTimeMinute = localObject1[1];
      }
      localObject1 = com.tencent.mm.plugin.appbrand.widget.picker.e.NS((String)localObject2);
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
    paramJSONObject = com.tencent.mm.plugin.appbrand.widget.picker.e.NS(paramJSONObject.optString("current"));
    if (paramJSONObject != null)
    {
      this.kgU = paramJSONObject[0];
      this.kgV = paramJSONObject[1];
    }
    L(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(137616);
        k localk = k.this;
        AppBrandTimePickerV2 localAppBrandTimePickerV2 = (AppBrandTimePickerV2)localk.aK(AppBrandTimePickerV2.class);
        if (localAppBrandTimePickerV2 == null)
        {
          localk.n("fail cant init view", null);
          AppMethodBeat.o(137616);
          return;
        }
        a locala = localk.mhO;
        localAppBrandTimePickerV2.setMinTime(localk.mMinTimeHour, localk.mMinTimeMinute);
        localAppBrandTimePickerV2.setMaxTime(localk.mMaxTimeHour, localk.mMaxTimeMinute);
        localAppBrandTimePickerV2.init(localk.kgU, localk.kgV);
        locala.setOnResultListener(new k.4(localk));
        locala.setHeader(localk.kgD);
        locala.show();
        AppMethodBeat.o(137616);
      }
    });
    AppMethodBeat.o(137621);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.n.k
 * JD-Core Version:    0.7.0.1
 */