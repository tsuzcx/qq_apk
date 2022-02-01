package com.tencent.mm.plugin.appbrand.jsapi.m;

import android.widget.NumberPicker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandDatePicker;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandDatePickerV2;
import com.tencent.mm.plugin.appbrand.widget.picker.a;
import com.tencent.mm.plugin.appbrand.widget.picker.c.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Calendar;
import java.util.Date;
import org.json.JSONObject;

final class b
  extends e
{
  volatile b.a kHf;
  volatile Long kHg = null;
  volatile Long kHh = null;
  volatile int kHi = -1;
  volatile int kHj = -1;
  volatile int kHk = -1;
  
  final void R(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137575);
    super.R(paramJSONObject);
    AppMethodBeat.o(137575);
  }
  
  final void S(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137576);
    this.kHf = b.a.MV(paramJSONObject.optString("fields"));
    Object localObject2 = paramJSONObject.optJSONObject("range");
    if (localObject2 != null)
    {
      localObject1 = ((JSONObject)localObject2).optString("start", "");
      localObject1 = this.kHf.parse((String)localObject1);
      localObject2 = ((JSONObject)localObject2).optString("end", "");
      localObject2 = this.kHf.parse((String)localObject2);
      if (localObject1 != null) {
        this.kHg = Long.valueOf(((Date)localObject1).getTime());
      }
      if (localObject2 != null) {
        this.kHh = Long.valueOf(((Date)localObject2).getTime());
      }
    }
    if (this.kHg == null)
    {
      localObject1 = Calendar.getInstance(ab.Grx);
      ((Calendar)localObject1).set(1900, 0, 1);
      this.kHg = Long.valueOf(((Calendar)localObject1).getTimeInMillis());
    }
    if (this.kHh == null)
    {
      localObject1 = Calendar.getInstance(ab.Grx);
      ((Calendar)localObject1).set(2100, 11, 31);
      this.kHh = Long.valueOf(((Calendar)localObject1).getTimeInMillis());
    }
    paramJSONObject = paramJSONObject.optString("current", "");
    Object localObject1 = this.kHf.parse(paramJSONObject);
    paramJSONObject = (JSONObject)localObject1;
    if (localObject1 == null)
    {
      paramJSONObject = new Date(System.currentTimeMillis());
      localObject1 = new Date(this.kHh.longValue());
      localObject2 = new Date(this.kHg.longValue());
      if (!paramJSONObject.after((Date)localObject1)) {
        break label288;
      }
      paramJSONObject = (JSONObject)localObject1;
    }
    for (;;)
    {
      this.kHi = (paramJSONObject.getYear() + 1900);
      this.kHj = (paramJSONObject.getMonth() + 1);
      this.kHk = paramJSONObject.getDate();
      N(new Runnable()
      {
        public final void run()
        {
          boolean bool3 = true;
          int j = 0;
          AppMethodBeat.i(137566);
          Object localObject2 = b.this;
          Object localObject1 = (AppBrandDatePicker)((b)localObject2).aK(AppBrandDatePicker.class);
          if (localObject1 == null)
          {
            ((e)localObject2).n("fail cant init view", null);
            AppMethodBeat.o(137566);
            return;
          }
          a locala = ((com.tencent.mm.plugin.appbrand.widget.picker.b)localObject2).mJP;
          locala.setOnResultListener(new b.4((b)localObject2));
          if (((b)localObject2).kHg != null) {
            ((AppBrandDatePicker)localObject1).setMinDate(((b)localObject2).kHg.longValue());
          }
          if (((b)localObject2).kHh != null) {
            ((AppBrandDatePicker)localObject1).setMaxDate(((b)localObject2).kHh.longValue());
          }
          ((AppBrandDatePicker)localObject1).a(((b)localObject2).kHi, ((b)localObject2).kHj, ((b)localObject2).kHk, null);
          boolean bool1;
          boolean bool2;
          if (((b)localObject2).kHf.ordinal() >= b.a.kHm.ordinal())
          {
            bool1 = true;
            if (((b)localObject2).kHf.ordinal() < b.a.kHn.ordinal()) {
              break label335;
            }
            bool2 = true;
            label170:
            if (((b)localObject2).kHf.ordinal() < b.a.kHo.ordinal()) {
              break label341;
            }
            label187:
            ((AppBrandDatePicker)localObject1).mJQ = bool1;
            ((AppBrandDatePicker)localObject1).mJR = bool2;
            ((AppBrandDatePicker)localObject1).mJS = bool3;
            if (((AppBrandDatePicker)localObject1).mJT != null)
            {
              ((AppBrandDatePicker)localObject1).mJT.setEnabled(bool1);
              localObject2 = ((AppBrandDatePicker)localObject1).mJT;
              if (!bool1) {
                break label347;
              }
              i = 0;
              label237:
              ((NumberPicker)localObject2).setVisibility(i);
            }
            if (((AppBrandDatePicker)localObject1).mJU != null)
            {
              ((AppBrandDatePicker)localObject1).mJU.setEnabled(bool2);
              localObject2 = ((AppBrandDatePicker)localObject1).mJU;
              if (!bool2) {
                break label353;
              }
              i = 0;
              label275:
              ((NumberPicker)localObject2).setVisibility(i);
            }
            if (((AppBrandDatePicker)localObject1).mJV != null)
            {
              ((AppBrandDatePicker)localObject1).mJV.setEnabled(bool3);
              localObject1 = ((AppBrandDatePicker)localObject1).mJV;
              if (!bool3) {
                break label359;
              }
            }
          }
          label335:
          label341:
          label347:
          label353:
          label359:
          for (int i = j;; i = 8)
          {
            ((NumberPicker)localObject1).setVisibility(i);
            locala.show();
            AppMethodBeat.o(137566);
            return;
            bool1 = false;
            break;
            bool2 = false;
            break label170;
            bool3 = false;
            break label187;
            i = 8;
            break label237;
            i = 8;
            break label275;
          }
        }
      });
      AppMethodBeat.o(137576);
      return;
      label288:
      if (paramJSONObject.before((Date)localObject2)) {
        paramJSONObject = (JSONObject)localObject2;
      }
    }
  }
  
  final void T(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137577);
    this.kHf = b.a.MV(paramJSONObject.optString("fields"));
    Object localObject2 = paramJSONObject.optJSONObject("range");
    if (localObject2 != null)
    {
      localObject1 = ((JSONObject)localObject2).optString("start", "");
      localObject1 = this.kHf.parse((String)localObject1);
      localObject2 = ((JSONObject)localObject2).optString("end", "");
      localObject2 = this.kHf.parse((String)localObject2);
      if (localObject1 != null) {
        this.kHg = Long.valueOf(((Date)localObject1).getTime());
      }
      if (localObject2 != null) {
        this.kHh = Long.valueOf(((Date)localObject2).getTime());
      }
    }
    if (this.kHg == null)
    {
      localObject1 = Calendar.getInstance(ab.Grx);
      ((Calendar)localObject1).set(1900, 0, 1);
      this.kHg = Long.valueOf(((Calendar)localObject1).getTimeInMillis());
    }
    if (this.kHh == null)
    {
      localObject1 = Calendar.getInstance(ab.Grx);
      ((Calendar)localObject1).set(2100, 11, 31);
      this.kHh = Long.valueOf(((Calendar)localObject1).getTimeInMillis());
    }
    paramJSONObject = paramJSONObject.optString("current", "");
    Object localObject1 = this.kHf.parse(paramJSONObject);
    paramJSONObject = (JSONObject)localObject1;
    if (localObject1 == null)
    {
      paramJSONObject = new Date(System.currentTimeMillis());
      localObject1 = new Date(this.kHh.longValue());
      localObject2 = new Date(this.kHg.longValue());
      if (!paramJSONObject.after((Date)localObject1)) {
        break label288;
      }
      paramJSONObject = (JSONObject)localObject1;
    }
    for (;;)
    {
      this.kHi = (paramJSONObject.getYear() + 1900);
      this.kHj = (paramJSONObject.getMonth() + 1);
      this.kHk = paramJSONObject.getDate();
      N(new Runnable()
      {
        public final void run()
        {
          boolean bool3 = true;
          AppMethodBeat.i(137567);
          b localb = b.this;
          AppBrandDatePickerV2 localAppBrandDatePickerV2 = (AppBrandDatePickerV2)localb.aK(AppBrandDatePickerV2.class);
          if (localAppBrandDatePickerV2 == null)
          {
            localb.n("fail cant init view", null);
            AppMethodBeat.o(137567);
            return;
          }
          a locala = localb.mJP;
          locala.setOnResultListener(new b.3(localb));
          if (localb.kHg != null) {
            localAppBrandDatePickerV2.mJW = new Date(localb.kHg.longValue());
          }
          if (localb.kHh != null) {
            localAppBrandDatePickerV2.mJX = new Date(localb.kHh.longValue());
          }
          int i = localb.kHi;
          int j = localb.kHj;
          int k = localb.kHk;
          boolean bool1;
          boolean bool2;
          if (localb.kHf.ordinal() >= b.a.kHm.ordinal())
          {
            bool1 = true;
            if (localb.kHf.ordinal() < b.a.kHn.ordinal()) {
              break label238;
            }
            bool2 = true;
            label180:
            if (localb.kHf.ordinal() < b.a.kHo.ordinal()) {
              break label244;
            }
          }
          for (;;)
          {
            localAppBrandDatePickerV2.a(i, j, k, bool1, bool2, bool3);
            locala.setHeader(localb.kHt);
            locala.show();
            AppMethodBeat.o(137567);
            return;
            bool1 = false;
            break;
            label238:
            bool2 = false;
            break label180;
            label244:
            bool3 = false;
          }
        }
      });
      AppMethodBeat.o(137577);
      return;
      label288:
      if (paramJSONObject.before((Date)localObject2)) {
        paramJSONObject = (JSONObject)localObject2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.m.b
 * JD-Core Version:    0.7.0.1
 */