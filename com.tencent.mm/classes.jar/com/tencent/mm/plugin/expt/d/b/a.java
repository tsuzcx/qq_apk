package com.tencent.mm.plugin.expt.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.d.e.a.b;
import com.tencent.mm.plugin.expt.d.e.a.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.tmassistantsdk.util.Base64;
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
    AppMethodBeat.i(210228);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(210228);
      return null;
    }
    ad.d("EdgeComputingConfigParser", "[EdgeComputingConfigParser] parseScriptFieldConfig fieldConfigJson : " + paramJSONObject.toString());
    try
    {
      int i = paramJSONObject.optInt("index", 0);
      String str = paramJSONObject.optString("name", "");
      int j = paramJSONObject.optInt("type", 0);
      boolean bool = g.ea(str);
      if (bool)
      {
        AppMethodBeat.o(210228);
        return null;
      }
      com.tencent.mm.plugin.expt.d.e.a.a locala = new com.tencent.mm.plugin.expt.d.e.a.a();
      locala.index = i;
      locala.name = str;
      locala.type = j;
      AppMethodBeat.o(210228);
      return locala;
    }
    catch (Exception localException)
    {
      ad.e("EdgeComputingConfigParser", "[EdgeComputingConfigParser] parseScriptFieldConfig throw Exception : " + localException.getMessage() + ", fieldConfigJson : " + paramJSONObject.toString());
      AppMethodBeat.o(210228);
    }
    return null;
  }
  
  public static c fP(String paramString1, String paramString2)
  {
    AppMethodBeat.i(210229);
    if ((g.ea(paramString1)) || (g.ea(paramString2)))
    {
      AppMethodBeat.o(210229);
      return null;
    }
    ad.d("EdgeComputingConfigParser", "[EdgeComputingConfigParser] parseSqlJsonConfig configID : " + paramString1 + ", json : " + paramString2);
    try
    {
      Object localObject2 = new JSONObject(paramString2);
      int i = ((JSONObject)localObject2).optInt("reportID", 0);
      Object localObject1 = ((JSONObject)localObject2).optString("sql", "");
      String str = ((JSONObject)localObject2).optString("dbName", "");
      localObject2 = ((JSONObject)localObject2).optString("tableName", "");
      if ((i != 0) && (!g.ea((String)localObject1)) && (!g.ea(str)))
      {
        boolean bool = g.ea((String)localObject2);
        if (!bool) {}
      }
      else
      {
        AppMethodBeat.o(210229);
        return null;
      }
      localObject1 = new c();
      ((c)localObject1).qQf = paramString1;
      ((c)localObject1).qQi = i;
      ((c)localObject1).dbName = str;
      ((c)localObject1).owc = ((String)localObject2);
      ((c)localObject1).qQm = paramString2;
      com.tencent.mm.plugin.expt.d.f.a.kS(true);
      AppMethodBeat.o(210229);
      return localObject1;
    }
    catch (Exception paramString1)
    {
      com.tencent.mm.plugin.expt.d.f.a.kS(false);
      ad.e("EdgeComputingConfigParser", "[EdgeComputingConfigParser] parseSqlJsonConfig throw Exception : " + paramString1.getMessage() + ", json : " + paramString2);
      AppMethodBeat.o(210229);
    }
    return null;
  }
  
  public final b fO(String paramString1, String paramString2)
  {
    AppMethodBeat.i(210227);
    if ((g.ea(paramString1)) || (g.ea(paramString2)))
    {
      AppMethodBeat.o(210227);
      return null;
    }
    ad.d("EdgeComputingConfigParser", "[EdgeComputingConfigParser] parseScriptJsonConfig configID : " + paramString1 + ", json : " + paramString2);
    for (;;)
    {
      int i;
      try
      {
        Object localObject = new JSONObject(paramString2);
        i = ((JSONObject)localObject).optInt("dataSourceType", 0);
        int j = ((JSONObject)localObject).optInt("dataSourceID", 0);
        String str1 = ((JSONObject)localObject).optString("dataSourceDB", "");
        String str2 = ((JSONObject)localObject).optString("dataSourceSQL", "");
        int k = ((JSONObject)localObject).optInt("reportID", 0);
        int m = ((JSONObject)localObject).optInt("isInstantReport", 0);
        int n = ((JSONObject)localObject).optInt("dbExpireTime", 0);
        String str3 = ((JSONObject)localObject).optString("script", "");
        localObject = ((JSONObject)localObject).optJSONArray("fields");
        if ((i != 0) && (!g.ea(str3)) && (localObject != null))
        {
          int i1 = ((JSONArray)localObject).length();
          if (i1 > 0) {}
        }
        else
        {
          AppMethodBeat.o(210227);
          return null;
        }
        b localb = new b();
        localb.qQf = paramString1;
        localb.qQb = i;
        localb.qQc = j;
        localb.qQg = str1;
        localb.qQh = str2;
        localb.qQi = k;
        localb.qQk = m;
        localb.qQl = n;
        localb.script = new String(Base64.decode(str3, 0), "UTF-8");
        localb.qQm = paramString2;
        localb.qQj = new ArrayList();
        paramString1 = new com.tencent.mm.plugin.expt.d.e.a.a();
        paramString1.index = 0;
        paramString1.name = "report_time_ec";
        paramString1.type = 2;
        localb.qQj.add(paramString1);
        i = 0;
        if (i < ((JSONArray)localObject).length())
        {
          paramString1 = as(((JSONArray)localObject).getJSONObject(i));
          if (paramString1 != null) {
            localb.qQj.add(paramString1);
          }
        }
        else
        {
          Collections.sort(localb.qQj, new Comparator() {});
          com.tencent.mm.plugin.expt.d.f.a.kR(true);
          AppMethodBeat.o(210227);
          return localb;
        }
      }
      catch (Exception paramString1)
      {
        com.tencent.mm.plugin.expt.d.f.a.kR(false);
        ad.e("EdgeComputingConfigParser", "[EdgeComputingConfigParser] parseScriptJsonConfig throw Exception : " + paramString1.getMessage() + ", json : " + paramString2);
        AppMethodBeat.o(210227);
        return null;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.d.b.a
 * JD-Core Version:    0.7.0.1
 */