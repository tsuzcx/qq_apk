package com.tencent.mm.plugin.appbrand.jsapi.v;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.picker.c.a;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import org.json.JSONObject;

final class b
  extends e
{
  private volatile a spO;
  private volatile Long spP = null;
  private volatile Long spQ = null;
  private volatile int spR = -1;
  private volatile int spS = -1;
  private volatile int spT = -1;
  
  final void aq(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137575);
    super.aq(paramJSONObject);
    AppMethodBeat.o(137575);
  }
  
  final void ar(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137576);
    this.spO = a.abs(paramJSONObject.optString("fields"));
    Object localObject2 = paramJSONObject.optJSONObject("range");
    if (localObject2 != null)
    {
      localObject1 = ((JSONObject)localObject2).optString("start", "");
      localObject1 = this.spO.abt((String)localObject1);
      localObject2 = ((JSONObject)localObject2).optString("end", "");
      localObject2 = this.spO.abt((String)localObject2);
      if (localObject1 != null) {
        this.spP = Long.valueOf(((Date)localObject1).getTime());
      }
      if (localObject2 != null) {
        this.spQ = Long.valueOf(((Date)localObject2).getTime());
      }
    }
    if (this.spP == null)
    {
      localObject1 = Calendar.getInstance(LocaleUtil.sysDefaultLocale);
      ((Calendar)localObject1).set(1900, 0, 1);
      this.spP = Long.valueOf(((Calendar)localObject1).getTimeInMillis());
    }
    if (this.spQ == null)
    {
      localObject1 = Calendar.getInstance(LocaleUtil.sysDefaultLocale);
      ((Calendar)localObject1).set(2100, 11, 31);
      this.spQ = Long.valueOf(((Calendar)localObject1).getTimeInMillis());
    }
    paramJSONObject = paramJSONObject.optString("current", "");
    Object localObject1 = this.spO.abt(paramJSONObject);
    paramJSONObject = (JSONObject)localObject1;
    if (localObject1 == null)
    {
      paramJSONObject = new Date(System.currentTimeMillis());
      localObject1 = new Date(this.spQ.longValue());
      localObject2 = new Date(this.spP.longValue());
      if (!paramJSONObject.after((Date)localObject1)) {
        break label289;
      }
      paramJSONObject = (JSONObject)localObject1;
    }
    for (;;)
    {
      this.spR = (paramJSONObject.getYear() + 1900);
      this.spS = (paramJSONObject.getMonth() + 1);
      this.spT = paramJSONObject.getDate();
      V(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(137566);
          b.a(b.this);
          AppMethodBeat.o(137566);
        }
      });
      AppMethodBeat.o(137576);
      return;
      label289:
      if (paramJSONObject.before((Date)localObject2)) {
        paramJSONObject = (JSONObject)localObject2;
      }
    }
  }
  
  final void as(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137577);
    this.spO = a.abs(paramJSONObject.optString("fields"));
    Object localObject2 = paramJSONObject.optJSONObject("range");
    if (localObject2 != null)
    {
      localObject1 = ((JSONObject)localObject2).optString("start", "");
      localObject1 = this.spO.abt((String)localObject1);
      localObject2 = ((JSONObject)localObject2).optString("end", "");
      localObject2 = this.spO.abt((String)localObject2);
      if (localObject1 != null) {
        this.spP = Long.valueOf(((Date)localObject1).getTime());
      }
      if (localObject2 != null) {
        this.spQ = Long.valueOf(((Date)localObject2).getTime());
      }
    }
    if (this.spP == null)
    {
      localObject1 = Calendar.getInstance(LocaleUtil.sysDefaultLocale);
      ((Calendar)localObject1).set(1900, 0, 1);
      this.spP = Long.valueOf(((Calendar)localObject1).getTimeInMillis());
    }
    if (this.spQ == null)
    {
      localObject1 = Calendar.getInstance(LocaleUtil.sysDefaultLocale);
      ((Calendar)localObject1).set(2100, 11, 31);
      this.spQ = Long.valueOf(((Calendar)localObject1).getTimeInMillis());
    }
    paramJSONObject = paramJSONObject.optString("current", "");
    Object localObject1 = this.spO.abt(paramJSONObject);
    paramJSONObject = (JSONObject)localObject1;
    if (localObject1 == null)
    {
      paramJSONObject = new Date(System.currentTimeMillis());
      localObject1 = new Date(this.spQ.longValue());
      localObject2 = new Date(this.spP.longValue());
      if (!paramJSONObject.after((Date)localObject1)) {
        break label291;
      }
      paramJSONObject = (JSONObject)localObject1;
    }
    for (;;)
    {
      this.spR = (paramJSONObject.getYear() + 1900);
      this.spS = (paramJSONObject.getMonth() + 1);
      this.spT = paramJSONObject.getDate();
      V(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(137567);
          b.b(b.this);
          AppMethodBeat.o(137567);
        }
      });
      AppMethodBeat.o(137577);
      return;
      label291:
      if (paramJSONObject.before((Date)localObject2)) {
        paramJSONObject = (JSONObject)localObject2;
      }
    }
  }
  
  static enum a
  {
    final DateFormat dGB;
    
    static
    {
      AppMethodBeat.i(137574);
      spV = new a("YEAR", 0, new SimpleDateFormat("yyyy", Locale.US));
      spW = new a("MONTH", 1, new SimpleDateFormat("yyyy-MM", Locale.US));
      spX = new a("DAY", 2, new SimpleDateFormat("yyyy-MM-dd", Locale.US));
      spY = new a[] { spV, spW, spX };
      AppMethodBeat.o(137574);
    }
    
    private a(DateFormat paramDateFormat)
    {
      this.dGB = paramDateFormat;
    }
    
    static a abs(String paramString)
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
          paramString = spW;
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
      paramString = spV;
      AppMethodBeat.o(137572);
      return paramString;
      paramString = spW;
      AppMethodBeat.o(137572);
      return paramString;
      paramString = spX;
      AppMethodBeat.o(137572);
      return paramString;
    }
    
    final Date abt(String paramString)
    {
      AppMethodBeat.i(137573);
      try
      {
        paramString = this.dGB.parse(paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.v.b
 * JD-Core Version:    0.7.0.1
 */