package com.tencent.b.a.a;

import android.content.Context;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONArray;
import org.json.JSONObject;

final class m
{
  protected Context context;
  private int dfV;
  private JSONObject dfW;
  
  m(Context paramContext, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(87661);
    this.context = null;
    this.dfV = 0;
    this.dfW = null;
    this.context = paramContext;
    this.dfV = ((int)(System.currentTimeMillis() / 1000L));
    this.dfW = paramJSONObject;
    AppMethodBeat.o(87661);
  }
  
  final JSONObject toJSONObject()
  {
    AppMethodBeat.i(87662);
    JSONObject localJSONObject1 = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject1.put("ky", "AVF4T76RVR81");
        localJSONObject1.put("et", 2);
        localJSONObject1.put("ts", this.dfV);
        localJSONObject1.put("si", this.dfV);
        s.a(localJSONObject1, "ui", s.bu(this.context));
        s.a(localJSONObject1, "mc", s.bv(this.context));
        localObject1 = i.bq(this.context).Ua();
        if (s.eZ((String)localObject1))
        {
          localJSONObject1.put("mid", localObject1);
          localObject1 = new b(this.context);
          localJSONObject2 = new JSONObject();
        }
      }
      catch (Throwable localThrowable1)
      {
        Object localObject1;
        JSONObject localJSONObject2;
        s.Ug();
        continue;
      }
      try
      {
        if (b.dfv != null)
        {
          b.a locala = b.dfv;
          localJSONObject2.put("sr", locala.dfz.widthPixels + "*" + locala.dfz.heightPixels);
          s.a(localJSONObject2, "av", locala.appVersion);
          s.a(localJSONObject2, "ch", locala.dfC);
          s.a(localJSONObject2, "mf", locala.dfB);
          s.a(localJSONObject2, "sv", locala.dfy);
          s.a(localJSONObject2, "ov", Integer.toString(locala.dfA));
          localJSONObject2.put("os", 1);
          s.a(localJSONObject2, "op", locala.dfD);
          s.a(localJSONObject2, "lg", locala.language);
          s.a(localJSONObject2, "md", locala.model);
          s.a(localJSONObject2, "tz", locala.timezone);
          if (locala.dfF != 0) {
            localJSONObject2.put("jb", locala.dfF);
          }
          s.a(localJSONObject2, "sd", locala.dfE);
          s.a(localJSONObject2, "apn", locala.packageName);
          if (s.bt(locala.ctx))
          {
            localObject2 = new JSONObject();
            s.a((JSONObject)localObject2, "bs", s.bw(locala.ctx));
            s.a((JSONObject)localObject2, "ss", s.bx(locala.ctx));
            if (((JSONObject)localObject2).length() > 0) {
              s.a(localJSONObject2, "wf", ((JSONObject)localObject2).toString());
            }
          }
          Object localObject2 = s.by(locala.ctx);
          if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0)) {
            s.a(localJSONObject2, "wflist", ((JSONArray)localObject2).toString());
          }
          s.a(localJSONObject2, "ram", locala.dfG);
          s.a(localJSONObject2, "rom", locala.dfH);
          s.a(localJSONObject2, "im", locala.imsi);
        }
        s.a(localJSONObject2, "cn", ((b)localObject1).dfx);
        if (((b)localObject1).dfw != null) {
          localJSONObject2.put("tn", ((b)localObject1).dfw);
        }
        localJSONObject1.put("ev", localJSONObject2);
      }
      catch (Throwable localThrowable2)
      {
        s.Ug();
        continue;
      }
      if (this.dfW != null) {
        localJSONObject1.put("ext", this.dfW);
      }
      AppMethodBeat.o(87662);
      return localJSONObject1;
      localJSONObject1.put("mid", "0");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.b.a.a.m
 * JD-Core Version:    0.7.0.1
 */