package com.tencent.mm.plugin.expt.d.b;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.d.e.a.b;
import com.tencent.mm.plugin.expt.d.e.a.c;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.apache.commons.b.g;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a
{
  private static com.tencent.mm.plugin.expt.d.e.a.a as(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(195873);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(195873);
      return null;
    }
    ae.d("EdgeComputingConfigParser", "[EdgeComputingConfigParser] parseScriptFieldConfig fieldConfigJson : " + paramJSONObject.toString());
    try
    {
      int i = paramJSONObject.optInt("index", 0);
      String str = paramJSONObject.optString("name", "");
      int j = paramJSONObject.optInt("type", 0);
      boolean bool = g.ef(str);
      if (bool)
      {
        AppMethodBeat.o(195873);
        return null;
      }
      com.tencent.mm.plugin.expt.d.e.a.a locala = new com.tencent.mm.plugin.expt.d.e.a.a();
      locala.index = i;
      locala.name = str;
      locala.type = j;
      AppMethodBeat.o(195873);
      return locala;
    }
    catch (Exception localException)
    {
      ae.e("EdgeComputingConfigParser", "[EdgeComputingConfigParser] parseScriptFieldConfig throw Exception : " + localException.getMessage() + ", fieldConfigJson : " + paramJSONObject.toString());
      AppMethodBeat.o(195873);
    }
    return null;
  }
  
  public static c fT(String paramString1, String paramString2)
  {
    AppMethodBeat.i(195874);
    if ((g.ef(paramString1)) || (g.ef(paramString2)))
    {
      AppMethodBeat.o(195874);
      return null;
    }
    ae.d("EdgeComputingConfigParser", "[EdgeComputingConfigParser] parseSqlJsonConfig configID : " + paramString1 + ", json : " + paramString2);
    try
    {
      Object localObject = new JSONObject(paramString2);
      int i = ((JSONObject)localObject).optInt("reportID", 0);
      String str = ((JSONObject)localObject).optString("sql", "");
      localObject = ((JSONObject)localObject).optString("dbPath", "");
      if ((i > 0) && (!g.ef(str)))
      {
        boolean bool = g.ef((String)localObject);
        if (!bool) {}
      }
      else
      {
        AppMethodBeat.o(195874);
        return null;
      }
      c localc = new c();
      localc.qXW = paramString1;
      localc.dbPath = ((String)localObject);
      localc.sql = str;
      localc.qYb = i;
      localc.qYh = paramString2;
      com.tencent.mm.plugin.expt.d.f.a.kS(true);
      AppMethodBeat.o(195874);
      return localc;
    }
    catch (Exception paramString1)
    {
      com.tencent.mm.plugin.expt.d.f.a.kS(false);
      ae.e("EdgeComputingConfigParser", "[EdgeComputingConfigParser] parseSqlJsonConfig throw Exception : " + paramString1.getMessage() + ", json : " + paramString2);
      AppMethodBeat.o(195874);
    }
    return null;
  }
  
  public final b fS(String paramString1, String paramString2)
  {
    AppMethodBeat.i(195872);
    if ((g.ef(paramString1)) || (g.ef(paramString2)))
    {
      AppMethodBeat.o(195872);
      return null;
    }
    ae.d("EdgeComputingConfigParser", "[EdgeComputingConfigParser] parseScriptJsonConfig configID : " + paramString1 + ", json : " + paramString2);
    for (;;)
    {
      int i;
      try
      {
        Object localObject = new JSONObject(paramString2);
        i = ((JSONObject)localObject).optInt("dataSourceType", 0);
        int j = ((JSONObject)localObject).optInt("dataSourceID", 0);
        int k = ((JSONObject)localObject).optInt("reportID", 0);
        int m = ((JSONObject)localObject).optInt("isInstantReport", 0);
        int n = ((JSONObject)localObject).optInt("isRepeat", 1);
        int i1 = ((JSONObject)localObject).optInt("runPeriod", 0);
        int i2 = ((JSONObject)localObject).optInt("dbExpireTime", 0);
        String str = ((JSONObject)localObject).optString("script", "");
        localObject = ((JSONObject)localObject).optJSONArray("fields");
        boolean bool = g.ef(str);
        if (bool)
        {
          AppMethodBeat.o(195872);
          return null;
        }
        b localb = new b();
        localb.qXW = paramString1;
        localb.qXZ = i;
        localb.qYa = j;
        localb.qYb = k;
        localb.qYd = m;
        localb.qYe = n;
        localb.qYf = i1;
        localb.qYg = i2;
        localb.script = new String(Base64.decode(str, 0), "UTF-8");
        localb.qYh = paramString2;
        localb.qYc = new ArrayList();
        if ((localObject != null) && (((JSONArray)localObject).length() > 0))
        {
          paramString1 = new com.tencent.mm.plugin.expt.d.e.a.a();
          paramString1.index = 0;
          paramString1.name = "report_time_ec";
          paramString1.type = 2;
          localb.qYc.add(paramString1);
          i = 0;
          if (i < ((JSONArray)localObject).length())
          {
            paramString1 = as(((JSONArray)localObject).getJSONObject(i));
            if (paramString1 != null) {
              localb.qYc.add(paramString1);
            }
          }
          else
          {
            Collections.sort(localb.qYc, new Comparator() {});
          }
        }
        else
        {
          com.tencent.mm.plugin.expt.d.f.a.kR(true);
          AppMethodBeat.o(195872);
          return localb;
        }
      }
      catch (Exception paramString1)
      {
        com.tencent.mm.plugin.expt.d.f.a.kR(false);
        ae.e("EdgeComputingConfigParser", "[EdgeComputingConfigParser] parseScriptJsonConfig throw Exception : " + paramString1.getMessage() + ", json : " + paramString2);
        AppMethodBeat.o(195872);
        return null;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.d.b.a
 * JD-Core Version:    0.7.0.1
 */