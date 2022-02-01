package com.tencent.mm.plugin.expt.edge.config;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.edge.e.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import org.apache.commons.c.i;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a
{
  private static String a(Map<String, String> paramMap, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(299827);
    if ((i.hm(paramString1)) || (i.hm(paramString2)))
    {
      AppMethodBeat.o(299827);
      return paramString3;
    }
    paramString1 = paramString1 + "_" + paramString2;
    if ((paramMap == null) || (!paramMap.containsKey(paramString1)))
    {
      AppMethodBeat.o(299827);
      return paramString3;
    }
    paramMap = (String)paramMap.get(paramString1);
    AppMethodBeat.o(299827);
    return paramMap;
  }
  
  public static c b(String paramString, com.tencent.mm.plugin.expt.e.a parama)
  {
    AppMethodBeat.i(299801);
    if ((i.hm(paramString)) || (parama == null))
    {
      AppMethodBeat.o(299801);
      return null;
    }
    com.tencent.mm.plugin.expt.edge.b.hf("EdgeComputingConfigParser", "[EdgeComputingConfigParser] parseNewSqlExptConfig configID : ".concat(String.valueOf(paramString)));
    try
    {
      int i = Integer.parseInt(a(parama.cache, "ECReportID", paramString, "0"));
      String str1 = a(parama.cache, "ECScriptUrl", paramString, "");
      String str2 = a(parama.cache, "ECDbPath", paramString, "");
      String str3 = a(parama.cache, "ECScriptMD5", paramString, "");
      int j = Integer.parseInt(a(parama.cache, "ECReportMethod", paramString, "0"));
      if ((i > 0) && (!i.hm(str1)))
      {
        boolean bool = i.hm(str3);
        if (!bool) {}
      }
      else
      {
        AppMethodBeat.o(299801);
        return null;
      }
      parama = new c();
      parama.zzS = paramString;
      parama.dbPath = str2;
      parama.zAh = str1;
      parama.zAi = str3;
      parama.zzX = i;
      parama.zAd = j;
      com.tencent.mm.plugin.expt.edge.f.a.oF(true);
      AppMethodBeat.o(299801);
      return parama;
    }
    catch (Exception paramString)
    {
      com.tencent.mm.plugin.expt.edge.f.a.oF(false);
      Log.e("EdgeComputingConfigParser", "[EdgeComputingConfigParser] parseSqlJsonConfig throw Exception : " + paramString.getMessage());
      AppMethodBeat.o(299801);
    }
    return null;
  }
  
  private static com.tencent.mm.plugin.expt.edge.e.a.a ba(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(299798);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(299798);
      return null;
    }
    com.tencent.mm.plugin.expt.edge.b.hf("EdgeComputingConfigParser", "[EdgeComputingConfigParser] parseNewScriptFieldConfig fieldConfigJson : " + paramJSONObject.toString());
    for (;;)
    {
      com.tencent.mm.plugin.expt.edge.e.a.a locala;
      try
      {
        int i = paramJSONObject.optInt("id", 0);
        String str1 = paramJSONObject.optString("name", "");
        String str2 = paramJSONObject.optString("type", "");
        if (!i.hm(str1))
        {
          boolean bool = i.hm(str2);
          if ((!bool) && (i > 21)) {}
        }
        else
        {
          AppMethodBeat.o(299798);
          return null;
        }
        locala = new com.tencent.mm.plugin.expt.edge.e.a.a();
        locala.index = (i - 21);
        locala.name = i.bLi(str1);
        if ((i.qA("unsigned int", str2)) || (i.qA("long long", str2)))
        {
          locala.type = 2;
          AppMethodBeat.o(299798);
          return locala;
        }
        if (i.qA("char[1024]", str2))
        {
          locala.type = 0;
          continue;
        }
        if (!i.qA("int", str2)) {
          continue;
        }
      }
      catch (Exception localException)
      {
        Log.e("EdgeComputingConfigParser", "[EdgeComputingConfigParser] parseNewScriptFieldConfig throw Exception : " + localException.getMessage() + ", fieldConfigJson : " + paramJSONObject.toString());
        AppMethodBeat.o(299798);
        return null;
      }
      locala.type = 1;
    }
  }
  
  private static com.tencent.mm.plugin.expt.edge.e.a.a bb(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(299808);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(299808);
      return null;
    }
    com.tencent.mm.plugin.expt.edge.b.hf("EdgeComputingConfigParser", "[EdgeComputingConfigParser] parseScriptFieldConfig fieldConfigJson : " + paramJSONObject.toString());
    try
    {
      int i = paramJSONObject.optInt("index", 0);
      String str = paramJSONObject.optString("name", "");
      int j = paramJSONObject.optInt("type", 0);
      boolean bool = i.hm(str);
      if (bool)
      {
        AppMethodBeat.o(299808);
        return null;
      }
      com.tencent.mm.plugin.expt.edge.e.a.a locala = new com.tencent.mm.plugin.expt.edge.e.a.a();
      locala.index = i;
      locala.name = i.bLi(str);
      locala.type = j;
      AppMethodBeat.o(299808);
      return locala;
    }
    catch (Exception localException)
    {
      Log.e("EdgeComputingConfigParser", "[EdgeComputingConfigParser] parseScriptFieldConfig throw Exception : " + localException.getMessage() + ", fieldConfigJson : " + paramJSONObject.toString());
      AppMethodBeat.o(299808);
    }
    return null;
  }
  
  public static c hh(String paramString1, String paramString2)
  {
    AppMethodBeat.i(299818);
    if ((i.hm(paramString1)) || (i.hm(paramString2)))
    {
      AppMethodBeat.o(299818);
      return null;
    }
    com.tencent.mm.plugin.expt.edge.b.hf("EdgeComputingConfigParser", "[EdgeComputingConfigParser] parseSqlJsonConfig configID : " + paramString1 + ", json : " + paramString2);
    try
    {
      Object localObject = new JSONObject(paramString2);
      int i = ((JSONObject)localObject).optInt("reportID", 0);
      String str1 = ((JSONObject)localObject).optString("sql", "");
      String str2 = ((JSONObject)localObject).optString("dbPath", "");
      String str3 = ((JSONObject)localObject).optString("sqlMD5", "");
      int j = ((JSONObject)localObject).optInt("reportMethod", 0);
      if ((i > 0) && (!i.hm(str1)))
      {
        boolean bool = i.hm(str3);
        if (!bool) {}
      }
      else
      {
        AppMethodBeat.o(299818);
        return null;
      }
      localObject = new c();
      ((c)localObject).zzS = paramString1;
      ((c)localObject).dbPath = str2;
      ((c)localObject).sql = str1;
      ((c)localObject).zAi = str3;
      ((c)localObject).zzX = i;
      ((c)localObject).zAd = j;
      ((c)localObject).zAf = paramString2;
      com.tencent.mm.plugin.expt.edge.f.a.oF(true);
      AppMethodBeat.o(299818);
      return localObject;
    }
    catch (Exception paramString1)
    {
      com.tencent.mm.plugin.expt.edge.f.a.oF(false);
      Log.e("EdgeComputingConfigParser", "[EdgeComputingConfigParser] parseSqlJsonConfig throw Exception : " + paramString1.getMessage() + ", json : " + paramString2);
      AppMethodBeat.o(299818);
    }
    return null;
  }
  
  public final com.tencent.mm.plugin.expt.edge.e.a.b a(String paramString, com.tencent.mm.plugin.expt.e.a parama)
  {
    AppMethodBeat.i(299838);
    if ((i.hm(paramString)) || (parama == null))
    {
      AppMethodBeat.o(299838);
      return null;
    }
    com.tencent.mm.plugin.expt.edge.b.hf("EdgeComputingConfigParser", "[EdgeComputingConfigParser] parseNewScriptExptConfig configID : ".concat(String.valueOf(paramString)));
    for (;;)
    {
      int i;
      try
      {
        i = Integer.parseInt(a(parama.cache, "ECDataSourceType", paramString, "0"));
        int j = Integer.parseInt(a(parama.cache, "ECDataSourceID", paramString, "0"));
        int k = Integer.parseInt(a(parama.cache, "ECReportID", paramString, "0"));
        int m = Integer.parseInt(a(parama.cache, "ECIsInstantReport", paramString, "0"));
        int n = Integer.parseInt(a(parama.cache, "ECIsRepeat", paramString, "1"));
        int i1 = Integer.parseInt(a(parama.cache, "ECRunPeriod", paramString, "0"));
        int i2 = Integer.parseInt(a(parama.cache, "ECDbExpireTime", paramString, "0"));
        String str1 = a(parama.cache, "ECScriptMD5", paramString, "");
        String str2 = a(parama.cache, "ECScriptUrl", paramString, "");
        int i3 = Integer.parseInt(a(parama.cache, "ECReportMethod", paramString, "0"));
        parama = new JSONArray(a(parama.cache, "ECFields", paramString, ""));
        if (!i.hm(str2))
        {
          boolean bool = i.hm(str1);
          if (!bool) {}
        }
        else
        {
          AppMethodBeat.o(299838);
          return null;
        }
        com.tencent.mm.plugin.expt.edge.e.a.b localb = new com.tencent.mm.plugin.expt.edge.e.a.b();
        localb.zzS = paramString;
        localb.zzV = i;
        localb.zzW = j;
        localb.zzX = k;
        localb.zzZ = m;
        localb.zAa = n;
        localb.zAb = i1;
        localb.zAc = i2;
        localb.zAg = str1;
        localb.zAe = str2;
        localb.zAd = i3;
        localb.zzY = new ArrayList();
        if (parama.length() > 0)
        {
          paramString = new com.tencent.mm.plugin.expt.edge.e.a.a();
          paramString.index = 0;
          paramString.name = "report_time_ec";
          paramString.type = 2;
          localb.zzY.add(paramString);
          i = 0;
          if (i < parama.length())
          {
            paramString = ba(parama.getJSONObject(i));
            if (paramString != null) {
              localb.zzY.add(paramString);
            }
          }
          else
          {
            Collections.sort(localb.zzY, new Comparator() {});
          }
        }
        else
        {
          com.tencent.mm.plugin.expt.edge.f.a.oE(true);
          AppMethodBeat.o(299838);
          return localb;
        }
      }
      catch (Exception paramString)
      {
        com.tencent.mm.plugin.expt.edge.f.a.oE(false);
        Log.e("EdgeComputingConfigParser", "[EdgeComputingConfigParser] parseScriptJsonConfig throw Exception : " + paramString.getMessage());
        AppMethodBeat.o(299838);
        return null;
      }
      i += 1;
    }
  }
  
  public final com.tencent.mm.plugin.expt.edge.e.a.b hg(String paramString1, String paramString2)
  {
    AppMethodBeat.i(299849);
    if ((i.hm(paramString1)) || (i.hm(paramString2)))
    {
      AppMethodBeat.o(299849);
      return null;
    }
    com.tencent.mm.plugin.expt.edge.b.hf("EdgeComputingConfigParser", "[EdgeComputingConfigParser] parseScriptJsonConfig configID : " + paramString1 + ", json : " + paramString2);
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
        int i3 = ((JSONObject)localObject).optInt("reportMethod", 0);
        String str1 = ((JSONObject)localObject).optString("scriptMD5", "");
        String str2 = ((JSONObject)localObject).optString("script", "");
        localObject = ((JSONObject)localObject).optJSONArray("fields");
        if (!i.hm(str2))
        {
          boolean bool = i.hm(str1);
          if (!bool) {}
        }
        else
        {
          AppMethodBeat.o(299849);
          return null;
        }
        com.tencent.mm.plugin.expt.edge.e.a.b localb = new com.tencent.mm.plugin.expt.edge.e.a.b();
        localb.zzS = paramString1;
        localb.zzV = i;
        localb.zzW = j;
        localb.zzX = k;
        localb.zzZ = m;
        localb.zAa = n;
        localb.zAb = i1;
        localb.zAc = i2;
        localb.zAd = i3;
        localb.zAg = str1;
        localb.script = new String(Base64.decode(str2, 0), "UTF-8");
        localb.zAf = paramString2;
        localb.zzY = new ArrayList();
        if ((localObject != null) && (((JSONArray)localObject).length() > 0))
        {
          paramString1 = new com.tencent.mm.plugin.expt.edge.e.a.a();
          paramString1.index = 0;
          paramString1.name = "report_time_ec";
          paramString1.type = 2;
          localb.zzY.add(paramString1);
          i = 0;
          if (i < ((JSONArray)localObject).length())
          {
            paramString1 = bb(((JSONArray)localObject).getJSONObject(i));
            if (paramString1 != null) {
              localb.zzY.add(paramString1);
            }
          }
          else
          {
            Collections.sort(localb.zzY, new Comparator() {});
          }
        }
        else
        {
          com.tencent.mm.plugin.expt.edge.f.a.oE(true);
          AppMethodBeat.o(299849);
          return localb;
        }
      }
      catch (Exception paramString1)
      {
        com.tencent.mm.plugin.expt.edge.f.a.oE(false);
        Log.e("EdgeComputingConfigParser", "[EdgeComputingConfigParser] parseScriptJsonConfig throw Exception : " + paramString1.getMessage() + ", json : " + paramString2);
        AppMethodBeat.o(299849);
        return null;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.edge.config.a
 * JD-Core Version:    0.7.0.1
 */