package com.tencent.mm.plugin.appbrand.jsapi.p;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.picker.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import org.json.JSONObject;

final class b
  extends e
{
  private volatile a lhj;
  private volatile Long lhk = null;
  private volatile Long lhl = null;
  private volatile int lhm = -1;
  private volatile int lhn = -1;
  private volatile int lho = -1;
  
  final void T(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137575);
    super.T(paramJSONObject);
    AppMethodBeat.o(137575);
  }
  
  final void U(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137576);
    this.lhj = a.Rb(paramJSONObject.optString("fields"));
    Object localObject2 = paramJSONObject.optJSONObject("range");
    if (localObject2 != null)
    {
      localObject1 = ((JSONObject)localObject2).optString("start", "");
      localObject1 = this.lhj.parse((String)localObject1);
      localObject2 = ((JSONObject)localObject2).optString("end", "");
      localObject2 = this.lhj.parse((String)localObject2);
      if (localObject1 != null) {
        this.lhk = Long.valueOf(((Date)localObject1).getTime());
      }
      if (localObject2 != null) {
        this.lhl = Long.valueOf(((Date)localObject2).getTime());
      }
    }
    if (this.lhk == null)
    {
      localObject1 = Calendar.getInstance(ad.Ixw);
      ((Calendar)localObject1).set(1900, 0, 1);
      this.lhk = Long.valueOf(((Calendar)localObject1).getTimeInMillis());
    }
    if (this.lhl == null)
    {
      localObject1 = Calendar.getInstance(ad.Ixw);
      ((Calendar)localObject1).set(2100, 11, 31);
      this.lhl = Long.valueOf(((Calendar)localObject1).getTimeInMillis());
    }
    paramJSONObject = paramJSONObject.optString("current", "");
    Object localObject1 = this.lhj.parse(paramJSONObject);
    paramJSONObject = (JSONObject)localObject1;
    if (localObject1 == null)
    {
      paramJSONObject = new Date(System.currentTimeMillis());
      localObject1 = new Date(this.lhl.longValue());
      localObject2 = new Date(this.lhk.longValue());
      if (!paramJSONObject.after((Date)localObject1)) {
        break label289;
      }
      paramJSONObject = (JSONObject)localObject1;
    }
    for (;;)
    {
      this.lhm = (paramJSONObject.getYear() + 1900);
      this.lhn = (paramJSONObject.getMonth() + 1);
      this.lho = paramJSONObject.getDate();
      K(new Runnable()
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
  
  final void V(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137577);
    this.lhj = a.Rb(paramJSONObject.optString("fields"));
    Object localObject2 = paramJSONObject.optJSONObject("range");
    if (localObject2 != null)
    {
      localObject1 = ((JSONObject)localObject2).optString("start", "");
      localObject1 = this.lhj.parse((String)localObject1);
      localObject2 = ((JSONObject)localObject2).optString("end", "");
      localObject2 = this.lhj.parse((String)localObject2);
      if (localObject1 != null) {
        this.lhk = Long.valueOf(((Date)localObject1).getTime());
      }
      if (localObject2 != null) {
        this.lhl = Long.valueOf(((Date)localObject2).getTime());
      }
    }
    if (this.lhk == null)
    {
      localObject1 = Calendar.getInstance(ad.Ixw);
      ((Calendar)localObject1).set(1900, 0, 1);
      this.lhk = Long.valueOf(((Calendar)localObject1).getTimeInMillis());
    }
    if (this.lhl == null)
    {
      localObject1 = Calendar.getInstance(ad.Ixw);
      ((Calendar)localObject1).set(2100, 11, 31);
      this.lhl = Long.valueOf(((Calendar)localObject1).getTimeInMillis());
    }
    paramJSONObject = paramJSONObject.optString("current", "");
    Object localObject1 = this.lhj.parse(paramJSONObject);
    paramJSONObject = (JSONObject)localObject1;
    if (localObject1 == null)
    {
      paramJSONObject = new Date(System.currentTimeMillis());
      localObject1 = new Date(this.lhl.longValue());
      localObject2 = new Date(this.lhk.longValue());
      if (!paramJSONObject.after((Date)localObject1)) {
        break label291;
      }
      paramJSONObject = (JSONObject)localObject1;
    }
    for (;;)
    {
      this.lhm = (paramJSONObject.getYear() + 1900);
      this.lhn = (paramJSONObject.getMonth() + 1);
      this.lho = paramJSONObject.getDate();
      K(new Runnable()
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
    final DateFormat bOZ;
    
    static
    {
      AppMethodBeat.i(137574);
      lhq = new a("YEAR", 0, new SimpleDateFormat("yyyy", Locale.US));
      lhr = new a("MONTH", 1, new SimpleDateFormat("yyyy-MM", Locale.US));
      lhs = new a("DAY", 2, new SimpleDateFormat("yyyy-MM-dd", Locale.US));
      lht = new a[] { lhq, lhr, lhs };
      AppMethodBeat.o(137574);
    }
    
    private a(DateFormat paramDateFormat)
    {
      this.bOZ = paramDateFormat;
    }
    
    static a Rb(String paramString)
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
          paramString = lhr;
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
      paramString = lhq;
      AppMethodBeat.o(137572);
      return paramString;
      paramString = lhr;
      AppMethodBeat.o(137572);
      return paramString;
      paramString = lhs;
      AppMethodBeat.o(137572);
      return paramString;
    }
    
    final Date parse(String paramString)
    {
      AppMethodBeat.i(137573);
      try
      {
        paramString = this.bOZ.parse(paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.p.b
 * JD-Core Version:    0.7.0.1
 */