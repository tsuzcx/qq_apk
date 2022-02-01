package com.tencent.b.a.a;

import android.content.Context;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONArray;
import org.json.JSONObject;

final class m
{
  private int cOM;
  private JSONObject cON;
  protected Context context;
  
  m(Context paramContext, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(87661);
    this.context = null;
    this.cOM = 0;
    this.cON = null;
    this.context = paramContext;
    this.cOM = ((int)(System.currentTimeMillis() / 1000L));
    this.cON = paramJSONObject;
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
        localJSONObject1.put("ts", this.cOM);
        localJSONObject1.put("si", this.cOM);
        s.a(localJSONObject1, "ui", s.aZ(this.context));
        s.a(localJSONObject1, "mc", s.ba(this.context));
        localObject1 = i.aV(this.context).JF();
        if (s.el((String)localObject1))
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
        s.JL();
        continue;
      }
      try
      {
        if (b.cOm != null)
        {
          b.a locala = b.cOm;
          localJSONObject2.put("sr", locala.cOq.widthPixels + "*" + locala.cOq.heightPixels);
          s.a(localJSONObject2, "av", locala.appVersion);
          s.a(localJSONObject2, "ch", locala.cOt);
          s.a(localJSONObject2, "mf", locala.cOs);
          s.a(localJSONObject2, "sv", locala.cOp);
          s.a(localJSONObject2, "ov", Integer.toString(locala.cOr));
          localJSONObject2.put("os", 1);
          s.a(localJSONObject2, "op", locala.cOu);
          s.a(localJSONObject2, "lg", locala.language);
          s.a(localJSONObject2, "md", locala.model);
          s.a(localJSONObject2, "tz", locala.timezone);
          if (locala.cOw != 0) {
            localJSONObject2.put("jb", locala.cOw);
          }
          s.a(localJSONObject2, "sd", locala.cOv);
          s.a(localJSONObject2, "apn", locala.packageName);
          if (s.aY(locala.ctx))
          {
            localObject2 = new JSONObject();
            s.a((JSONObject)localObject2, "bs", s.bb(locala.ctx));
            s.a((JSONObject)localObject2, "ss", s.bc(locala.ctx));
            if (((JSONObject)localObject2).length() > 0) {
              s.a(localJSONObject2, "wf", ((JSONObject)localObject2).toString());
            }
          }
          Object localObject2 = s.bd(locala.ctx);
          if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0)) {
            s.a(localJSONObject2, "wflist", ((JSONArray)localObject2).toString());
          }
          s.a(localJSONObject2, "ram", locala.cOx);
          s.a(localJSONObject2, "rom", locala.cOy);
          s.a(localJSONObject2, "im", locala.imsi);
        }
        s.a(localJSONObject2, "cn", ((b)localObject1).cOo);
        if (((b)localObject1).cOn != null) {
          localJSONObject2.put("tn", ((b)localObject1).cOn);
        }
        localJSONObject1.put("ev", localJSONObject2);
      }
      catch (Throwable localThrowable2)
      {
        s.JL();
        continue;
      }
      if (this.cON != null) {
        localJSONObject1.put("ext", this.cON);
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