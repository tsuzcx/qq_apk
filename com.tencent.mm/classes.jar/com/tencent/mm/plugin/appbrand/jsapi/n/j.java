package com.tencent.mm.plugin.appbrand.jsapi.n;

import android.widget.NumberPicker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandTimePicker;
import com.tencent.mm.plugin.appbrand.widget.picker.a;
import com.tencent.mm.plugin.appbrand.widget.picker.b;
import com.tencent.mm.plugin.appbrand.widget.picker.d.a;
import com.tencent.mm.plugin.appbrand.widget.picker.f;
import com.tencent.mm.sdk.platformtools.al;
import org.json.JSONObject;

final class j
  extends d
{
  int hWY = -1;
  int hWZ = -1;
  int hXa = 2147483647;
  int hXb = 2147483647;
  int hXc = -1;
  int hXd = -1;
  
  final void H(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(126368);
    Object localObject2 = paramJSONObject.optJSONObject("range");
    if (localObject2 != null)
    {
      Object localObject1 = ((JSONObject)localObject2).optString("start");
      localObject2 = ((JSONObject)localObject2).optString("end");
      localObject1 = f.FV((String)localObject1);
      if (localObject1 != null)
      {
        this.hWY = localObject1[0];
        this.hWZ = localObject1[1];
      }
      localObject1 = f.FV((String)localObject2);
      if (localObject1 != null)
      {
        this.hXa = localObject1[0];
        this.hXb = localObject1[1];
      }
    }
    this.hWY = Math.max(this.hWY, 0);
    this.hWZ = Math.max(this.hWZ, 0);
    this.hXa = Math.min(this.hXa, 23);
    this.hXb = Math.min(this.hXb, 59);
    paramJSONObject = f.FV(paramJSONObject.optString("current"));
    if (paramJSONObject != null)
    {
      this.hXc = paramJSONObject[0];
      this.hXd = paramJSONObject[1];
    }
    al.d(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126366);
        j localj = j.this;
        AppBrandTimePicker localAppBrandTimePicker = (AppBrandTimePicker)localj.ah(AppBrandTimePicker.class);
        if (localAppBrandTimePicker == null)
        {
          localj.l("fail cant init view", null);
          AppMethodBeat.o(126366);
          return;
        }
        a locala = localj.jrY;
        int i = localj.hWY;
        int j = localj.hWZ;
        localAppBrandTimePicker.hWY = i;
        localAppBrandTimePicker.hWZ = j;
        if ((f.qL(localAppBrandTimePicker.hWY)) && (localAppBrandTimePicker.jsD != null)) {
          localAppBrandTimePicker.jsD.setMinValue(localAppBrandTimePicker.hWY);
        }
        i = localj.hXa;
        j = localj.hXb;
        localAppBrandTimePicker.hXa = i;
        localAppBrandTimePicker.hXb = j;
        if ((f.qL(localAppBrandTimePicker.hXa)) && (localAppBrandTimePicker.jsD != null)) {
          localAppBrandTimePicker.jsD.setMaxValue(localAppBrandTimePicker.hXa);
        }
        i = localj.hXc;
        j = localj.hXd;
        if ((f.qL(i)) && (f.qK(j)))
        {
          localAppBrandTimePicker.setCurrentHour(Integer.valueOf(i));
          localAppBrandTimePicker.setCurrentMinute(Integer.valueOf(j));
        }
        localAppBrandTimePicker.aRT();
        locala.setOnResultListener(new j.2(localj));
        locala.show();
        AppMethodBeat.o(126366);
      }
    });
    AppMethodBeat.o(126368);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.n.j
 * JD-Core Version:    0.7.0.1
 */