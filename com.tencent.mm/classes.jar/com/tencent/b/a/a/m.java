package com.tencent.b.a.a;

import android.content.Context;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONArray;
import org.json.JSONObject;

final class m
{
  private int cPw;
  private JSONObject cPx;
  protected Context context;
  
  m(Context paramContext, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(87661);
    this.context = null;
    this.cPw = 0;
    this.cPx = null;
    this.context = paramContext;
    this.cPw = ((int)(System.currentTimeMillis() / 1000L));
    this.cPx = paramJSONObject;
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
        localJSONObject1.put("ts", this.cPw);
        localJSONObject1.put("si", this.cPw);
        s.a(localJSONObject1, "ui", s.ba(this.context));
        s.a(localJSONObject1, "mc", s.bb(this.context));
        localObject1 = i.aW(this.context).JN();
        if (s.eq((String)localObject1))
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
        s.JT();
        continue;
      }
      try
      {
        if (b.cOW != null)
        {
          b.a locala = b.cOW;
          localJSONObject2.put("sr", locala.cPa.widthPixels + "*" + locala.cPa.heightPixels);
          s.a(localJSONObject2, "av", locala.appVersion);
          s.a(localJSONObject2, "ch", locala.cPd);
          s.a(localJSONObject2, "mf", locala.cPc);
          s.a(localJSONObject2, "sv", locala.cOZ);
          s.a(localJSONObject2, "ov", Integer.toString(locala.cPb));
          localJSONObject2.put("os", 1);
          s.a(localJSONObject2, "op", locala.cPe);
          s.a(localJSONObject2, "lg", locala.language);
          s.a(localJSONObject2, "md", locala.model);
          s.a(localJSONObject2, "tz", locala.timezone);
          if (locala.cPg != 0) {
            localJSONObject2.put("jb", locala.cPg);
          }
          s.a(localJSONObject2, "sd", locala.cPf);
          s.a(localJSONObject2, "apn", locala.packageName);
          if (s.aZ(locala.ctx))
          {
            localObject2 = new JSONObject();
            s.a((JSONObject)localObject2, "bs", s.bc(locala.ctx));
            s.a((JSONObject)localObject2, "ss", s.bd(locala.ctx));
            if (((JSONObject)localObject2).length() > 0) {
              s.a(localJSONObject2, "wf", ((JSONObject)localObject2).toString());
            }
          }
          Object localObject2 = s.be(locala.ctx);
          if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0)) {
            s.a(localJSONObject2, "wflist", ((JSONArray)localObject2).toString());
          }
          s.a(localJSONObject2, "ram", locala.cPh);
          s.a(localJSONObject2, "rom", locala.cPi);
          s.a(localJSONObject2, "im", locala.imsi);
        }
        s.a(localJSONObject2, "cn", ((b)localObject1).cOY);
        if (((b)localObject1).cOX != null) {
          localJSONObject2.put("tn", ((b)localObject1).cOX);
        }
        localJSONObject1.put("ev", localJSONObject2);
      }
      catch (Throwable localThrowable2)
      {
        s.JT();
        continue;
      }
      if (this.cPx != null) {
        localJSONObject1.put("ext", this.cPx);
      }
      AppMethodBeat.o(87662);
      return localJSONObject1;
      localJSONObject1.put("mid", "0");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.b.a.a.m
 * JD-Core Version:    0.7.0.1
 */