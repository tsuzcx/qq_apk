package com.tencent.mm.plugin.appbrand.jsapi.n;

import android.widget.NumberPicker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandDatePicker;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandDatePickerV2;
import com.tencent.mm.plugin.appbrand.widget.picker.a;
import com.tencent.mm.plugin.appbrand.widget.picker.c.a;
import com.tencent.mm.sdk.platformtools.ac;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import org.json.JSONObject;

final class b
  extends e
{
  volatile a kgp;
  volatile Long kgq = null;
  volatile Long kgr = null;
  volatile int kgs = -1;
  volatile int kgt = -1;
  volatile int kgu = -1;
  
  final void R(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137575);
    super.R(paramJSONObject);
    AppMethodBeat.o(137575);
  }
  
  final void S(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137576);
    this.kgp = a.IS(paramJSONObject.optString("fields"));
    Object localObject2 = paramJSONObject.optJSONObject("range");
    if (localObject2 != null)
    {
      localObject1 = ((JSONObject)localObject2).optString("start", "");
      localObject1 = this.kgp.parse((String)localObject1);
      localObject2 = ((JSONObject)localObject2).optString("end", "");
      localObject2 = this.kgp.parse((String)localObject2);
      if (localObject1 != null) {
        this.kgq = Long.valueOf(((Date)localObject1).getTime());
      }
      if (localObject2 != null) {
        this.kgr = Long.valueOf(((Date)localObject2).getTime());
      }
    }
    if (this.kgq == null)
    {
      localObject1 = Calendar.getInstance(ac.EUl);
      ((Calendar)localObject1).set(1900, 0, 1);
      this.kgq = Long.valueOf(((Calendar)localObject1).getTimeInMillis());
    }
    if (this.kgr == null)
    {
      localObject1 = Calendar.getInstance(ac.EUl);
      ((Calendar)localObject1).set(2100, 11, 31);
      this.kgr = Long.valueOf(((Calendar)localObject1).getTimeInMillis());
    }
    paramJSONObject = paramJSONObject.optString("current", "");
    Object localObject1 = this.kgp.parse(paramJSONObject);
    paramJSONObject = (JSONObject)localObject1;
    if (localObject1 == null)
    {
      paramJSONObject = new Date(System.currentTimeMillis());
      localObject1 = new Date(this.kgr.longValue());
      localObject2 = new Date(this.kgq.longValue());
      if (!paramJSONObject.after((Date)localObject1)) {
        break label288;
      }
      paramJSONObject = (JSONObject)localObject1;
    }
    for (;;)
    {
      this.kgs = (paramJSONObject.getYear() + 1900);
      this.kgt = (paramJSONObject.getMonth() + 1);
      this.kgu = paramJSONObject.getDate();
      L(new Runnable()
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
          a locala = ((com.tencent.mm.plugin.appbrand.widget.picker.b)localObject2).mhO;
          locala.setOnResultListener(new b.4((b)localObject2));
          if (((b)localObject2).kgq != null) {
            ((AppBrandDatePicker)localObject1).setMinDate(((b)localObject2).kgq.longValue());
          }
          if (((b)localObject2).kgr != null) {
            ((AppBrandDatePicker)localObject1).setMaxDate(((b)localObject2).kgr.longValue());
          }
          ((AppBrandDatePicker)localObject1).a(((b)localObject2).kgs, ((b)localObject2).kgt, ((b)localObject2).kgu, null);
          boolean bool1;
          boolean bool2;
          if (((b)localObject2).kgp.ordinal() >= b.a.kgw.ordinal())
          {
            bool1 = true;
            if (((b)localObject2).kgp.ordinal() < b.a.kgx.ordinal()) {
              break label335;
            }
            bool2 = true;
            label170:
            if (((b)localObject2).kgp.ordinal() < b.a.kgy.ordinal()) {
              break label341;
            }
            label187:
            ((AppBrandDatePicker)localObject1).mhP = bool1;
            ((AppBrandDatePicker)localObject1).mhQ = bool2;
            ((AppBrandDatePicker)localObject1).mhR = bool3;
            if (((AppBrandDatePicker)localObject1).mhS != null)
            {
              ((AppBrandDatePicker)localObject1).mhS.setEnabled(bool1);
              localObject2 = ((AppBrandDatePicker)localObject1).mhS;
              if (!bool1) {
                break label347;
              }
              i = 0;
              label237:
              ((NumberPicker)localObject2).setVisibility(i);
            }
            if (((AppBrandDatePicker)localObject1).mhT != null)
            {
              ((AppBrandDatePicker)localObject1).mhT.setEnabled(bool2);
              localObject2 = ((AppBrandDatePicker)localObject1).mhT;
              if (!bool2) {
                break label353;
              }
              i = 0;
              label275:
              ((NumberPicker)localObject2).setVisibility(i);
            }
            if (((AppBrandDatePicker)localObject1).mhU != null)
            {
              ((AppBrandDatePicker)localObject1).mhU.setEnabled(bool3);
              localObject1 = ((AppBrandDatePicker)localObject1).mhU;
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
    this.kgp = a.IS(paramJSONObject.optString("fields"));
    Object localObject2 = paramJSONObject.optJSONObject("range");
    if (localObject2 != null)
    {
      localObject1 = ((JSONObject)localObject2).optString("start", "");
      localObject1 = this.kgp.parse((String)localObject1);
      localObject2 = ((JSONObject)localObject2).optString("end", "");
      localObject2 = this.kgp.parse((String)localObject2);
      if (localObject1 != null) {
        this.kgq = Long.valueOf(((Date)localObject1).getTime());
      }
      if (localObject2 != null) {
        this.kgr = Long.valueOf(((Date)localObject2).getTime());
      }
    }
    if (this.kgq == null)
    {
      localObject1 = Calendar.getInstance(ac.EUl);
      ((Calendar)localObject1).set(1900, 0, 1);
      this.kgq = Long.valueOf(((Calendar)localObject1).getTimeInMillis());
    }
    if (this.kgr == null)
    {
      localObject1 = Calendar.getInstance(ac.EUl);
      ((Calendar)localObject1).set(2100, 11, 31);
      this.kgr = Long.valueOf(((Calendar)localObject1).getTimeInMillis());
    }
    paramJSONObject = paramJSONObject.optString("current", "");
    Object localObject1 = this.kgp.parse(paramJSONObject);
    paramJSONObject = (JSONObject)localObject1;
    if (localObject1 == null)
    {
      paramJSONObject = new Date(System.currentTimeMillis());
      localObject1 = new Date(this.kgr.longValue());
      localObject2 = new Date(this.kgq.longValue());
      if (!paramJSONObject.after((Date)localObject1)) {
        break label288;
      }
      paramJSONObject = (JSONObject)localObject1;
    }
    for (;;)
    {
      this.kgs = (paramJSONObject.getYear() + 1900);
      this.kgt = (paramJSONObject.getMonth() + 1);
      this.kgu = paramJSONObject.getDate();
      L(new Runnable()
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
          a locala = localb.mhO;
          locala.setOnResultListener(new b.3(localb));
          if (localb.kgq != null) {
            localAppBrandDatePickerV2.mhV = new Date(localb.kgq.longValue());
          }
          if (localb.kgr != null) {
            localAppBrandDatePickerV2.mhW = new Date(localb.kgr.longValue());
          }
          int i = localb.kgs;
          int j = localb.kgt;
          int k = localb.kgu;
          boolean bool1;
          boolean bool2;
          if (localb.kgp.ordinal() >= b.a.kgw.ordinal())
          {
            bool1 = true;
            if (localb.kgp.ordinal() < b.a.kgx.ordinal()) {
              break label238;
            }
            bool2 = true;
            label180:
            if (localb.kgp.ordinal() < b.a.kgy.ordinal()) {
              break label244;
            }
          }
          for (;;)
          {
            localAppBrandDatePickerV2.a(i, j, k, bool1, bool2, bool3);
            locala.setHeader(localb.kgD);
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
  
  static enum a
  {
    final DateFormat bHd;
    
    static
    {
      AppMethodBeat.i(137574);
      kgw = new a("YEAR", 0, new SimpleDateFormat("yyyy", Locale.US));
      kgx = new a("MONTH", 1, new SimpleDateFormat("yyyy-MM", Locale.US));
      kgy = new a("DAY", 2, new SimpleDateFormat("yyyy-MM-dd", Locale.US));
      kgz = new a[] { kgw, kgx, kgy };
      AppMethodBeat.o(137574);
    }
    
    private a(DateFormat paramDateFormat)
    {
      this.bHd = paramDateFormat;
    }
    
    static a IS(String paramString)
    {
      int i = 0;
      AppMethodBeat.i(137572);
      paramString = paramString.substring(0, Math.max(0, Math.min(paramString.length(), 5))).toLowerCase();
      switch (paramString.hashCode())
      {
      default: 
        label68:
        i = -1;
      }
      for (;;)
      {
        switch (i)
        {
        default: 
          paramString = kgx;
          AppMethodBeat.o(137572);
          return paramString;
          if (!paramString.equals("year")) {
            break label68;
          }
          continue;
          if (!paramString.equals("month")) {
            break label68;
          }
          i = 1;
          continue;
          if (!paramString.equals("day")) {
            break label68;
          }
          i = 2;
        }
      }
      paramString = kgw;
      AppMethodBeat.o(137572);
      return paramString;
      paramString = kgx;
      AppMethodBeat.o(137572);
      return paramString;
      paramString = kgy;
      AppMethodBeat.o(137572);
      return paramString;
    }
    
    final Date parse(String paramString)
    {
      AppMethodBeat.i(137573);
      try
      {
        paramString = this.bHd.parse(paramString);
        AppMethodBeat.o(137573);
        return paramString;
      }
      catch (Exception paramString)
      {
        AppMethodBeat.o(137573);
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.n.b
 * JD-Core Version:    0.7.0.1
 */