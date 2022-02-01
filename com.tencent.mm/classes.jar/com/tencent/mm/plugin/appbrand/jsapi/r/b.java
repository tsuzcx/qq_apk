package com.tencent.mm.plugin.appbrand.jsapi.r;

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
  private volatile a mmF;
  private volatile Long mmG = null;
  private volatile Long mmH = null;
  private volatile int mmI = -1;
  private volatile int mmJ = -1;
  private volatile int mmK = -1;
  
  final void ac(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137575);
    super.ac(paramJSONObject);
    AppMethodBeat.o(137575);
  }
  
  final void ad(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137576);
    this.mmF = a.aaD(paramJSONObject.optString("fields"));
    Object localObject2 = paramJSONObject.optJSONObject("range");
    if (localObject2 != null)
    {
      localObject1 = ((JSONObject)localObject2).optString("start", "");
      localObject1 = this.mmF.parse((String)localObject1);
      localObject2 = ((JSONObject)localObject2).optString("end", "");
      localObject2 = this.mmF.parse((String)localObject2);
      if (localObject1 != null) {
        this.mmG = Long.valueOf(((Date)localObject1).getTime());
      }
      if (localObject2 != null) {
        this.mmH = Long.valueOf(((Date)localObject2).getTime());
      }
    }
    if (this.mmG == null)
    {
      localObject1 = Calendar.getInstance(LocaleUtil.sysDefaultLocale);
      ((Calendar)localObject1).set(1900, 0, 1);
      this.mmG = Long.valueOf(((Calendar)localObject1).getTimeInMillis());
    }
    if (this.mmH == null)
    {
      localObject1 = Calendar.getInstance(LocaleUtil.sysDefaultLocale);
      ((Calendar)localObject1).set(2100, 11, 31);
      this.mmH = Long.valueOf(((Calendar)localObject1).getTimeInMillis());
    }
    paramJSONObject = paramJSONObject.optString("current", "");
    Object localObject1 = this.mmF.parse(paramJSONObject);
    paramJSONObject = (JSONObject)localObject1;
    if (localObject1 == null)
    {
      paramJSONObject = new Date(System.currentTimeMillis());
      localObject1 = new Date(this.mmH.longValue());
      localObject2 = new Date(this.mmG.longValue());
      if (!paramJSONObject.after((Date)localObject1)) {
        break label289;
      }
      paramJSONObject = (JSONObject)localObject1;
    }
    for (;;)
    {
      this.mmI = (paramJSONObject.getYear() + 1900);
      this.mmJ = (paramJSONObject.getMonth() + 1);
      this.mmK = paramJSONObject.getDate();
      P(new Runnable()
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
  
  final void ae(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137577);
    this.mmF = a.aaD(paramJSONObject.optString("fields"));
    Object localObject2 = paramJSONObject.optJSONObject("range");
    if (localObject2 != null)
    {
      localObject1 = ((JSONObject)localObject2).optString("start", "");
      localObject1 = this.mmF.parse((String)localObject1);
      localObject2 = ((JSONObject)localObject2).optString("end", "");
      localObject2 = this.mmF.parse((String)localObject2);
      if (localObject1 != null) {
        this.mmG = Long.valueOf(((Date)localObject1).getTime());
      }
      if (localObject2 != null) {
        this.mmH = Long.valueOf(((Date)localObject2).getTime());
      }
    }
    if (this.mmG == null)
    {
      localObject1 = Calendar.getInstance(LocaleUtil.sysDefaultLocale);
      ((Calendar)localObject1).set(1900, 0, 1);
      this.mmG = Long.valueOf(((Calendar)localObject1).getTimeInMillis());
    }
    if (this.mmH == null)
    {
      localObject1 = Calendar.getInstance(LocaleUtil.sysDefaultLocale);
      ((Calendar)localObject1).set(2100, 11, 31);
      this.mmH = Long.valueOf(((Calendar)localObject1).getTimeInMillis());
    }
    paramJSONObject = paramJSONObject.optString("current", "");
    Object localObject1 = this.mmF.parse(paramJSONObject);
    paramJSONObject = (JSONObject)localObject1;
    if (localObject1 == null)
    {
      paramJSONObject = new Date(System.currentTimeMillis());
      localObject1 = new Date(this.mmH.longValue());
      localObject2 = new Date(this.mmG.longValue());
      if (!paramJSONObject.after((Date)localObject1)) {
        break label291;
      }
      paramJSONObject = (JSONObject)localObject1;
    }
    for (;;)
    {
      this.mmI = (paramJSONObject.getYear() + 1900);
      this.mmJ = (paramJSONObject.getMonth() + 1);
      this.mmK = paramJSONObject.getDate();
      P(new Runnable()
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
    final DateFormat mmP;
    
    static
    {
      AppMethodBeat.i(137574);
      mmM = new a("YEAR", 0, new SimpleDateFormat("yyyy", Locale.US));
      mmN = new a("MONTH", 1, new SimpleDateFormat("yyyy-MM", Locale.US));
      mmO = new a("DAY", 2, new SimpleDateFormat("yyyy-MM-dd", Locale.US));
      mmQ = new a[] { mmM, mmN, mmO };
      AppMethodBeat.o(137574);
    }
    
    private a(DateFormat paramDateFormat)
    {
      this.mmP = paramDateFormat;
    }
    
    static a aaD(String paramString)
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
          paramString = mmN;
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
      paramString = mmM;
      AppMethodBeat.o(137572);
      return paramString;
      paramString = mmN;
      AppMethodBeat.o(137572);
      return paramString;
      paramString = mmO;
      AppMethodBeat.o(137572);
      return paramString;
    }
    
    final Date parse(String paramString)
    {
      AppMethodBeat.i(137573);
      try
      {
        paramString = this.mmP.parse(paramString);
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.r.b
 * JD-Core Version:    0.7.0.1
 */