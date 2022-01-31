package com.tencent.c.a.a;

import android.content.Context;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONArray;
import org.json.JSONObject;

final class m
{
  private int bUP;
  private JSONObject bUQ;
  protected Context context;
  
  m(Context paramContext, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(125779);
    this.context = null;
    this.bUP = 0;
    this.bUQ = null;
    this.context = paramContext;
    this.bUP = ((int)(System.currentTimeMillis() / 1000L));
    this.bUQ = paramJSONObject;
    AppMethodBeat.o(125779);
  }
  
  final JSONObject toJSONObject()
  {
    AppMethodBeat.i(125780);
    JSONObject localJSONObject1 = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject1.put("ky", "AVF4T76RVR81");
        localJSONObject1.put("et", 2);
        localJSONObject1.put("ts", this.bUP);
        localJSONObject1.put("si", this.bUP);
        s.a(localJSONObject1, "ui", s.getImei(this.context));
        s.a(localJSONObject1, "mc", s.aP(this.context));
        localObject1 = i.aL(this.context).zP();
        if (s.cJ((String)localObject1))
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
        s.zV();
        continue;
      }
      try
      {
        if (b.bUq != null)
        {
          b.a locala = b.bUq;
          localJSONObject2.put("sr", locala.bUu.widthPixels + "*" + locala.bUu.heightPixels);
          s.a(localJSONObject2, "av", locala.appVersion);
          s.a(localJSONObject2, "ch", locala.channel);
          s.a(localJSONObject2, "mf", locala.bUw);
          s.a(localJSONObject2, "sv", locala.bUt);
          s.a(localJSONObject2, "ov", Integer.toString(locala.bUv));
          localJSONObject2.put("os", 1);
          s.a(localJSONObject2, "op", locala.bUx);
          s.a(localJSONObject2, "lg", locala.axa);
          s.a(localJSONObject2, "md", locala.model);
          s.a(localJSONObject2, "tz", locala.timezone);
          if (locala.bUz != 0) {
            localJSONObject2.put("jb", locala.bUz);
          }
          s.a(localJSONObject2, "sd", locala.bUy);
          s.a(localJSONObject2, "apn", locala.packageName);
          if (s.aO(locala.ctx))
          {
            localObject2 = new JSONObject();
            s.a((JSONObject)localObject2, "bs", s.aQ(locala.ctx));
            s.a((JSONObject)localObject2, "ss", s.aR(locala.ctx));
            if (((JSONObject)localObject2).length() > 0) {
              s.a(localJSONObject2, "wf", ((JSONObject)localObject2).toString());
            }
          }
          Object localObject2 = s.aS(locala.ctx);
          if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0)) {
            s.a(localJSONObject2, "wflist", ((JSONArray)localObject2).toString());
          }
          s.a(localJSONObject2, "ram", locala.bUA);
          s.a(localJSONObject2, "rom", locala.bUB);
          s.a(localJSONObject2, "im", locala.imsi);
        }
        s.a(localJSONObject2, "cn", ((b)localObject1).bUs);
        if (((b)localObject1).bUr != null) {
          localJSONObject2.put("tn", ((b)localObject1).bUr);
        }
        localJSONObject1.put("ev", localJSONObject2);
      }
      catch (Throwable localThrowable2)
      {
        s.zV();
        continue;
      }
      if (this.bUQ != null) {
        localJSONObject1.put("ext", this.bUQ);
      }
      AppMethodBeat.o(125780);
      return localJSONObject1;
      localJSONObject1.put("mid", "0");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.c.a.a.m
 * JD-Core Version:    0.7.0.1
 */