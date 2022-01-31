package com.tencent.c.a.a;

import android.content.Context;
import android.util.DisplayMetrics;
import org.json.JSONArray;
import org.json.JSONObject;

final class m
{
  private int btF = 0;
  private JSONObject btG = null;
  protected Context context = null;
  
  m(Context paramContext, JSONObject paramJSONObject)
  {
    this.context = paramContext;
    this.btF = ((int)(System.currentTimeMillis() / 1000L));
    this.btG = paramJSONObject;
  }
  
  final JSONObject rB()
  {
    JSONObject localJSONObject1 = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject1.put("ky", "AVF4T76RVR81");
        localJSONObject1.put("et", 2);
        localJSONObject1.put("ts", this.btF);
        localJSONObject1.put("si", this.btF);
        s.a(localJSONObject1, "ui", s.getImei(this.context));
        s.a(localJSONObject1, "mc", s.ar(this.context));
        localObject1 = i.an(this.context).rz();
        if (s.bG((String)localObject1))
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
        return localJSONObject1;
      }
      try
      {
        if (b.bte != null)
        {
          b.a locala = b.bte;
          localJSONObject2.put("sr", locala.btj.widthPixels + "*" + locala.btj.heightPixels);
          s.a(localJSONObject2, "av", locala.bth);
          s.a(localJSONObject2, "ch", locala.channel);
          s.a(localJSONObject2, "mf", locala.btl);
          s.a(localJSONObject2, "sv", locala.bti);
          s.a(localJSONObject2, "ov", Integer.toString(locala.btk));
          localJSONObject2.put("os", 1);
          s.a(localJSONObject2, "op", locala.btm);
          s.a(localJSONObject2, "lg", locala.auI);
          s.a(localJSONObject2, "md", locala.model);
          s.a(localJSONObject2, "tz", locala.timezone);
          if (locala.btp != 0) {
            localJSONObject2.put("jb", locala.btp);
          }
          s.a(localJSONObject2, "sd", locala.bto);
          s.a(localJSONObject2, "apn", locala.packageName);
          if (s.aq(locala.ctx))
          {
            localObject2 = new JSONObject();
            s.a((JSONObject)localObject2, "bs", s.as(locala.ctx));
            s.a((JSONObject)localObject2, "ss", s.at(locala.ctx));
            if (((JSONObject)localObject2).length() > 0) {
              s.a(localJSONObject2, "wf", ((JSONObject)localObject2).toString());
            }
          }
          Object localObject2 = s.au(locala.ctx);
          if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0)) {
            s.a(localJSONObject2, "wflist", ((JSONArray)localObject2).toString());
          }
          s.a(localJSONObject2, "ram", locala.btq);
          s.a(localJSONObject2, "rom", locala.btr);
          s.a(localJSONObject2, "im", locala.imsi);
        }
        s.a(localJSONObject2, "cn", ((b)localObject1).btg);
        if (((b)localObject1).btf != null) {
          localJSONObject2.put("tn", ((b)localObject1).btf);
        }
        localJSONObject1.put("ev", localJSONObject2);
      }
      catch (Throwable localThrowable2)
      {
        continue;
      }
      if (this.btG == null) {
        return localJSONObject1;
      }
      localJSONObject1.put("ext", this.btG);
      return localJSONObject1;
      localJSONObject1.put("mid", "0");
    }
    return localJSONObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.c.a.a.m
 * JD-Core Version:    0.7.0.1
 */