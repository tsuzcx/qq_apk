package com.tencent.mm.plugin.appbrand.jsapi.m;

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
  int kHK = -1;
  int kHL = -1;
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
      localObject1 = com.tencent.mm.plugin.appbrand.widget.picker.e.Sb((String)localObject1);
      if (localObject1 != null)
      {
        this.mMinTimeHour = localObject1[0];
        this.mMinTimeMinute = localObject1[1];
      }
      localObject1 = com.tencent.mm.plugin.appbrand.widget.picker.e.Sb((String)localObject2);
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
    paramJSONObject = com.tencent.mm.plugin.appbrand.widget.picker.e.Sb(paramJSONObject.optString("current"));
    if (paramJSONObject != null)
    {
      this.kHK = paramJSONObject[0];
      this.kHL = paramJSONObject[1];
    }
    N(new Runnable()
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
        a locala = localk.mJP;
        int i = localk.mMinTimeHour;
        int j = localk.mMinTimeMinute;
        localAppBrandTimePicker.mMinTimeHour = i;
        localAppBrandTimePicker.mMinTimeMinute = j;
        if ((com.tencent.mm.plugin.appbrand.widget.picker.e.wf(localAppBrandTimePicker.mMinTimeHour)) && (localAppBrandTimePicker.mKG != null)) {
          localAppBrandTimePicker.mKG.setMinValue(localAppBrandTimePicker.mMinTimeHour);
        }
        i = localk.mMaxTimeHour;
        j = localk.mMaxTimeMinute;
        localAppBrandTimePicker.mMaxTimeHour = i;
        localAppBrandTimePicker.mMaxTimeMinute = j;
        if ((com.tencent.mm.plugin.appbrand.widget.picker.e.wf(localAppBrandTimePicker.mMaxTimeHour)) && (localAppBrandTimePicker.mKG != null)) {
          localAppBrandTimePicker.mKG.setMaxValue(localAppBrandTimePicker.mMaxTimeHour);
        }
        i = localk.kHK;
        j = localk.kHL;
        if ((com.tencent.mm.plugin.appbrand.widget.picker.e.wf(i)) && (com.tencent.mm.plugin.appbrand.widget.picker.e.we(j)))
        {
          localAppBrandTimePicker.setCurrentHour(Integer.valueOf(i));
          localAppBrandTimePicker.setCurrentMinute(Integer.valueOf(j));
        }
        localAppBrandTimePicker.bAe();
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
      localObject1 = com.tencent.mm.plugin.appbrand.widget.picker.e.Sb((String)localObject1);
      if (localObject1 != null)
      {
        this.mMinTimeHour = localObject1[0];
        this.mMinTimeMinute = localObject1[1];
      }
      localObject1 = com.tencent.mm.plugin.appbrand.widget.picker.e.Sb((String)localObject2);
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
    paramJSONObject = com.tencent.mm.plugin.appbrand.widget.picker.e.Sb(paramJSONObject.optString("current"));
    if (paramJSONObject != null)
    {
      this.kHK = paramJSONObject[0];
      this.kHL = paramJSONObject[1];
    }
    N(new Runnable()
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
        a locala = localk.mJP;
        localAppBrandTimePickerV2.setMinTime(localk.mMinTimeHour, localk.mMinTimeMinute);
        localAppBrandTimePickerV2.setMaxTime(localk.mMaxTimeHour, localk.mMaxTimeMinute);
        localAppBrandTimePickerV2.init(localk.kHK, localk.kHL);
        locala.setOnResultListener(new k.4(localk));
        locala.setHeader(localk.kHt);
        locala.show();
        AppMethodBeat.o(137616);
      }
    });
    AppMethodBeat.o(137621);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.m.k
 * JD-Core Version:    0.7.0.1
 */