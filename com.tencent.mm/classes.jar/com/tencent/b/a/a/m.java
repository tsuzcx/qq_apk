package com.tencent.b.a.a;

import android.content.Context;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONArray;
import org.json.JSONObject;

final class m
{
  private JSONObject cGA;
  private int cGz;
  protected Context context;
  
  m(Context paramContext, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(87661);
    this.context = null;
    this.cGz = 0;
    this.cGA = null;
    this.context = paramContext;
    this.cGz = ((int)(System.currentTimeMillis() / 1000L));
    this.cGA = paramJSONObject;
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
        localJSONObject1.put("ts", this.cGz);
        localJSONObject1.put("si", this.cGz);
        s.a(localJSONObject1, "ui", s.aY(this.context));
        s.a(localJSONObject1, "mc", s.aZ(this.context));
        localObject1 = i.aU(this.context).Iw();
        if (s.dA((String)localObject1))
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
        s.IC();
        continue;
      }
      try
      {
        if (b.cFZ != null)
        {
          b.a locala = b.cFZ;
          localJSONObject2.put("sr", locala.cGd.widthPixels + "*" + locala.cGd.heightPixels);
          s.a(localJSONObject2, "av", locala.appVersion);
          s.a(localJSONObject2, "ch", locala.cGg);
          s.a(localJSONObject2, "mf", locala.cGf);
          s.a(localJSONObject2, "sv", locala.cGc);
          s.a(localJSONObject2, "ov", Integer.toString(locala.cGe));
          localJSONObject2.put("os", 1);
          s.a(localJSONObject2, "op", locala.cGh);
          s.a(localJSONObject2, "lg", locala.aSt);
          s.a(localJSONObject2, "md", locala.model);
          s.a(localJSONObject2, "tz", locala.timezone);
          if (locala.cGj != 0) {
            localJSONObject2.put("jb", locala.cGj);
          }
          s.a(localJSONObject2, "sd", locala.cGi);
          s.a(localJSONObject2, "apn", locala.packageName);
          if (s.aX(locala.ctx))
          {
            localObject2 = new JSONObject();
            s.a((JSONObject)localObject2, "bs", s.ba(locala.ctx));
            s.a((JSONObject)localObject2, "ss", s.bb(locala.ctx));
            if (((JSONObject)localObject2).length() > 0) {
              s.a(localJSONObject2, "wf", ((JSONObject)localObject2).toString());
            }
          }
          Object localObject2 = s.bc(locala.ctx);
          if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0)) {
            s.a(localJSONObject2, "wflist", ((JSONArray)localObject2).toString());
          }
          s.a(localJSONObject2, "ram", locala.cGk);
          s.a(localJSONObject2, "rom", locala.cGl);
          s.a(localJSONObject2, "im", locala.imsi);
        }
        s.a(localJSONObject2, "cn", ((b)localObject1).cGb);
        if (((b)localObject1).cGa != null) {
          localJSONObject2.put("tn", ((b)localObject1).cGa);
        }
        localJSONObject1.put("ev", localJSONObject2);
      }
      catch (Throwable localThrowable2)
      {
        s.IC();
        continue;
      }
      if (this.cGA != null) {
        localJSONObject1.put("ext", this.cGA);
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