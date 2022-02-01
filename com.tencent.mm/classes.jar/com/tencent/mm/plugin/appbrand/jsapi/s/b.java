package com.tencent.mm.plugin.appbrand.jsapi.s;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.picker.c.a;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.Calendar;
import java.util.Date;
import org.json.JSONObject;

final class b
  extends e
{
  private volatile b.a pkN;
  private volatile Long pkO = null;
  private volatile Long pkP = null;
  private volatile int pkQ = -1;
  private volatile int pkR = -1;
  private volatile int pkS = -1;
  
  final void ag(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137575);
    super.ag(paramJSONObject);
    AppMethodBeat.o(137575);
  }
  
  final void ah(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137576);
    this.pkN = b.a.aiu(paramJSONObject.optString("fields"));
    Object localObject2 = paramJSONObject.optJSONObject("range");
    if (localObject2 != null)
    {
      localObject1 = ((JSONObject)localObject2).optString("start", "");
      localObject1 = this.pkN.aiv((String)localObject1);
      localObject2 = ((JSONObject)localObject2).optString("end", "");
      localObject2 = this.pkN.aiv((String)localObject2);
      if (localObject1 != null) {
        this.pkO = Long.valueOf(((Date)localObject1).getTime());
      }
      if (localObject2 != null) {
        this.pkP = Long.valueOf(((Date)localObject2).getTime());
      }
    }
    if (this.pkO == null)
    {
      localObject1 = Calendar.getInstance(LocaleUtil.sysDefaultLocale);
      ((Calendar)localObject1).set(1900, 0, 1);
      this.pkO = Long.valueOf(((Calendar)localObject1).getTimeInMillis());
    }
    if (this.pkP == null)
    {
      localObject1 = Calendar.getInstance(LocaleUtil.sysDefaultLocale);
      ((Calendar)localObject1).set(2100, 11, 31);
      this.pkP = Long.valueOf(((Calendar)localObject1).getTimeInMillis());
    }
    paramJSONObject = paramJSONObject.optString("current", "");
    Object localObject1 = this.pkN.aiv(paramJSONObject);
    paramJSONObject = (JSONObject)localObject1;
    if (localObject1 == null)
    {
      paramJSONObject = new Date(System.currentTimeMillis());
      localObject1 = new Date(this.pkP.longValue());
      localObject2 = new Date(this.pkO.longValue());
      if (!paramJSONObject.after((Date)localObject1)) {
        break label289;
      }
      paramJSONObject = (JSONObject)localObject1;
    }
    for (;;)
    {
      this.pkQ = (paramJSONObject.getYear() + 1900);
      this.pkR = (paramJSONObject.getMonth() + 1);
      this.pkS = paramJSONObject.getDate();
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
  
  final void ai(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137577);
    this.pkN = b.a.aiu(paramJSONObject.optString("fields"));
    Object localObject2 = paramJSONObject.optJSONObject("range");
    if (localObject2 != null)
    {
      localObject1 = ((JSONObject)localObject2).optString("start", "");
      localObject1 = this.pkN.aiv((String)localObject1);
      localObject2 = ((JSONObject)localObject2).optString("end", "");
      localObject2 = this.pkN.aiv((String)localObject2);
      if (localObject1 != null) {
        this.pkO = Long.valueOf(((Date)localObject1).getTime());
      }
      if (localObject2 != null) {
        this.pkP = Long.valueOf(((Date)localObject2).getTime());
      }
    }
    if (this.pkO == null)
    {
      localObject1 = Calendar.getInstance(LocaleUtil.sysDefaultLocale);
      ((Calendar)localObject1).set(1900, 0, 1);
      this.pkO = Long.valueOf(((Calendar)localObject1).getTimeInMillis());
    }
    if (this.pkP == null)
    {
      localObject1 = Calendar.getInstance(LocaleUtil.sysDefaultLocale);
      ((Calendar)localObject1).set(2100, 11, 31);
      this.pkP = Long.valueOf(((Calendar)localObject1).getTimeInMillis());
    }
    paramJSONObject = paramJSONObject.optString("current", "");
    Object localObject1 = this.pkN.aiv(paramJSONObject);
    paramJSONObject = (JSONObject)localObject1;
    if (localObject1 == null)
    {
      paramJSONObject = new Date(System.currentTimeMillis());
      localObject1 = new Date(this.pkP.longValue());
      localObject2 = new Date(this.pkO.longValue());
      if (!paramJSONObject.after((Date)localObject1)) {
        break label291;
      }
      paramJSONObject = (JSONObject)localObject1;
    }
    for (;;)
    {
      this.pkQ = (paramJSONObject.getYear() + 1900);
      this.pkR = (paramJSONObject.getMonth() + 1);
      this.pkS = paramJSONObject.getDate();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.s.b
 * JD-Core Version:    0.7.0.1
 */