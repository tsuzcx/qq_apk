package com.tencent.mm.plugin.appbrand.jsapi.p;

import android.widget.NumberPicker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandDatePicker;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandDatePickerV2;
import com.tencent.mm.plugin.appbrand.widget.picker.a;
import com.tencent.mm.plugin.appbrand.widget.picker.c.a;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.Calendar;
import java.util.Date;
import org.json.JSONObject;

final class b
  extends e
{
  volatile Long ldA = null;
  volatile int ldB = -1;
  volatile int ldC = -1;
  volatile int ldD = -1;
  volatile b.a ldy;
  volatile Long ldz = null;
  
  final void T(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137575);
    super.T(paramJSONObject);
    AppMethodBeat.o(137575);
  }
  
  final void U(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137576);
    this.ldy = b.a.Qs(paramJSONObject.optString("fields"));
    Object localObject2 = paramJSONObject.optJSONObject("range");
    if (localObject2 != null)
    {
      localObject1 = ((JSONObject)localObject2).optString("start", "");
      localObject1 = this.ldy.parse((String)localObject1);
      localObject2 = ((JSONObject)localObject2).optString("end", "");
      localObject2 = this.ldy.parse((String)localObject2);
      if (localObject1 != null) {
        this.ldz = Long.valueOf(((Date)localObject1).getTime());
      }
      if (localObject2 != null) {
        this.ldA = Long.valueOf(((Date)localObject2).getTime());
      }
    }
    if (this.ldz == null)
    {
      localObject1 = Calendar.getInstance(ac.Idl);
      ((Calendar)localObject1).set(1900, 0, 1);
      this.ldz = Long.valueOf(((Calendar)localObject1).getTimeInMillis());
    }
    if (this.ldA == null)
    {
      localObject1 = Calendar.getInstance(ac.Idl);
      ((Calendar)localObject1).set(2100, 11, 31);
      this.ldA = Long.valueOf(((Calendar)localObject1).getTimeInMillis());
    }
    paramJSONObject = paramJSONObject.optString("current", "");
    Object localObject1 = this.ldy.parse(paramJSONObject);
    paramJSONObject = (JSONObject)localObject1;
    if (localObject1 == null)
    {
      paramJSONObject = new Date(System.currentTimeMillis());
      localObject1 = new Date(this.ldA.longValue());
      localObject2 = new Date(this.ldz.longValue());
      if (!paramJSONObject.after((Date)localObject1)) {
        break label288;
      }
      paramJSONObject = (JSONObject)localObject1;
    }
    for (;;)
    {
      this.ldB = (paramJSONObject.getYear() + 1900);
      this.ldC = (paramJSONObject.getMonth() + 1);
      this.ldD = paramJSONObject.getDate();
      M(new Runnable()
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
            ((e)localObject2).p("fail cant init view", null);
            AppMethodBeat.o(137566);
            return;
          }
          a locala = ((com.tencent.mm.plugin.appbrand.widget.picker.b)localObject2).nkl;
          locala.setOnResultListener(new b.4((b)localObject2));
          if (((b)localObject2).ldz != null) {
            ((AppBrandDatePicker)localObject1).setMinDate(((b)localObject2).ldz.longValue());
          }
          if (((b)localObject2).ldA != null) {
            ((AppBrandDatePicker)localObject1).setMaxDate(((b)localObject2).ldA.longValue());
          }
          ((AppBrandDatePicker)localObject1).a(((b)localObject2).ldB, ((b)localObject2).ldC, ((b)localObject2).ldD, null);
          boolean bool1;
          boolean bool2;
          if (((b)localObject2).ldy.ordinal() >= b.a.ldF.ordinal())
          {
            bool1 = true;
            if (((b)localObject2).ldy.ordinal() < b.a.ldG.ordinal()) {
              break label335;
            }
            bool2 = true;
            label170:
            if (((b)localObject2).ldy.ordinal() < b.a.ldH.ordinal()) {
              break label341;
            }
            label187:
            ((AppBrandDatePicker)localObject1).nkm = bool1;
            ((AppBrandDatePicker)localObject1).nkn = bool2;
            ((AppBrandDatePicker)localObject1).nko = bool3;
            if (((AppBrandDatePicker)localObject1).nkp != null)
            {
              ((AppBrandDatePicker)localObject1).nkp.setEnabled(bool1);
              localObject2 = ((AppBrandDatePicker)localObject1).nkp;
              if (!bool1) {
                break label347;
              }
              i = 0;
              label237:
              ((NumberPicker)localObject2).setVisibility(i);
            }
            if (((AppBrandDatePicker)localObject1).nkq != null)
            {
              ((AppBrandDatePicker)localObject1).nkq.setEnabled(bool2);
              localObject2 = ((AppBrandDatePicker)localObject1).nkq;
              if (!bool2) {
                break label353;
              }
              i = 0;
              label275:
              ((NumberPicker)localObject2).setVisibility(i);
            }
            if (((AppBrandDatePicker)localObject1).nkr != null)
            {
              ((AppBrandDatePicker)localObject1).nkr.setEnabled(bool3);
              localObject1 = ((AppBrandDatePicker)localObject1).nkr;
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
  
  final void V(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137577);
    this.ldy = b.a.Qs(paramJSONObject.optString("fields"));
    Object localObject2 = paramJSONObject.optJSONObject("range");
    if (localObject2 != null)
    {
      localObject1 = ((JSONObject)localObject2).optString("start", "");
      localObject1 = this.ldy.parse((String)localObject1);
      localObject2 = ((JSONObject)localObject2).optString("end", "");
      localObject2 = this.ldy.parse((String)localObject2);
      if (localObject1 != null) {
        this.ldz = Long.valueOf(((Date)localObject1).getTime());
      }
      if (localObject2 != null) {
        this.ldA = Long.valueOf(((Date)localObject2).getTime());
      }
    }
    if (this.ldz == null)
    {
      localObject1 = Calendar.getInstance(ac.Idl);
      ((Calendar)localObject1).set(1900, 0, 1);
      this.ldz = Long.valueOf(((Calendar)localObject1).getTimeInMillis());
    }
    if (this.ldA == null)
    {
      localObject1 = Calendar.getInstance(ac.Idl);
      ((Calendar)localObject1).set(2100, 11, 31);
      this.ldA = Long.valueOf(((Calendar)localObject1).getTimeInMillis());
    }
    paramJSONObject = paramJSONObject.optString("current", "");
    Object localObject1 = this.ldy.parse(paramJSONObject);
    paramJSONObject = (JSONObject)localObject1;
    if (localObject1 == null)
    {
      paramJSONObject = new Date(System.currentTimeMillis());
      localObject1 = new Date(this.ldA.longValue());
      localObject2 = new Date(this.ldz.longValue());
      if (!paramJSONObject.after((Date)localObject1)) {
        break label288;
      }
      paramJSONObject = (JSONObject)localObject1;
    }
    for (;;)
    {
      this.ldB = (paramJSONObject.getYear() + 1900);
      this.ldC = (paramJSONObject.getMonth() + 1);
      this.ldD = paramJSONObject.getDate();
      M(new Runnable()
      {
        public final void run()
        {
          boolean bool3 = true;
          AppMethodBeat.i(137567);
          b localb = b.this;
          AppBrandDatePickerV2 localAppBrandDatePickerV2 = (AppBrandDatePickerV2)localb.aK(AppBrandDatePickerV2.class);
          if (localAppBrandDatePickerV2 == null)
          {
            localb.p("fail cant init view", null);
            AppMethodBeat.o(137567);
            return;
          }
          a locala = localb.nkl;
          locala.setOnResultListener(new b.3(localb));
          if (localb.ldz != null) {
            localAppBrandDatePickerV2.nks = new Date(localb.ldz.longValue());
          }
          if (localb.ldA != null) {
            localAppBrandDatePickerV2.nkt = new Date(localb.ldA.longValue());
          }
          int i = localb.ldB;
          int j = localb.ldC;
          int k = localb.ldD;
          boolean bool1;
          boolean bool2;
          if (localb.ldy.ordinal() >= b.a.ldF.ordinal())
          {
            bool1 = true;
            if (localb.ldy.ordinal() < b.a.ldG.ordinal()) {
              break label238;
            }
            bool2 = true;
            label180:
            if (localb.ldy.ordinal() < b.a.ldH.ordinal()) {
              break label244;
            }
          }
          for (;;)
          {
            localAppBrandDatePickerV2.a(i, j, k, bool1, bool2, bool3);
            locala.setHeader(localb.ldM);
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.p.b
 * JD-Core Version:    0.7.0.1
 */