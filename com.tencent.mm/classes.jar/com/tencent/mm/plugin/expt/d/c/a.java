package com.tencent.mm.plugin.expt.d.c;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.d.f.a.b;
import com.tencent.mm.plugin.expt.d.f.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import org.apache.commons.b.g;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a
{
  private static String a(Map<String, String> paramMap, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(250727);
    if ((g.fK(paramString1)) || (g.fK(paramString2)))
    {
      AppMethodBeat.o(250727);
      return paramString3;
    }
    paramString1 = paramString1 + "_" + paramString2;
    if ((paramMap == null) || (!paramMap.containsKey(paramString1)))
    {
      AppMethodBeat.o(250727);
      return paramString3;
    }
    paramMap = (String)paramMap.get(paramString1);
    AppMethodBeat.o(250727);
    return paramMap;
  }
  
  private static com.tencent.mm.plugin.expt.d.f.a.a aP(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(250718);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(250718);
      return null;
    }
    Log.d("EdgeComputingConfigParser", "[EdgeComputingConfigParser] parseNewScriptFieldConfig fieldConfigJson : " + paramJSONObject.toString());
    for (;;)
    {
      com.tencent.mm.plugin.expt.d.f.a.a locala;
      try
      {
        int i = paramJSONObject.optInt("id", 0);
        String str1 = paramJSONObject.optString("name", "");
        String str2 = paramJSONObject.optString("type", "");
        if (!g.fK(str1))
        {
          boolean bool = g.fK(str2);
          if ((!bool) && (i > 21)) {}
        }
        else
        {
          AppMethodBeat.o(250718);
          return null;
        }
        locala = new com.tencent.mm.plugin.expt.d.f.a.a();
        locala.index = (i - 21);
        locala.name = g.bIn(str1);
        if ((g.oC("unsigned int", str2)) || (g.oC("long long", str2)))
        {
          locala.type = 2;
          AppMethodBeat.o(250718);
          return locala;
        }
        if (g.oC("char[1024]", str2))
        {
          locala.type = 0;
          continue;
        }
        if (!g.oC("int", str2)) {
          continue;
        }
      }
      catch (Exception localException)
      {
        Log.e("EdgeComputingConfigParser", "[EdgeComputingConfigParser] parseNewScriptFieldConfig throw Exception : " + localException.getMessage() + ", fieldConfigJson : " + paramJSONObject.toString());
        AppMethodBeat.o(250718);
        return null;
      }
      locala.type = 1;
    }
  }
  
  private static com.tencent.mm.plugin.expt.d.f.a.a aQ(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(250725);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(250725);
      return null;
    }
    Log.d("EdgeComputingConfigParser", "[EdgeComputingConfigParser] parseScriptFieldConfig fieldConfigJson : " + paramJSONObject.toString());
    try
    {
      int i = paramJSONObject.optInt("index", 0);
      String str = paramJSONObject.optString("name", "");
      int j = paramJSONObject.optInt("type", 0);
      boolean bool = g.fK(str);
      if (bool)
      {
        AppMethodBeat.o(250725);
        return null;
      }
      com.tencent.mm.plugin.expt.d.f.a.a locala = new com.tencent.mm.plugin.expt.d.f.a.a();
      locala.index = i;
      locala.name = g.bIn(str);
      locala.type = j;
      AppMethodBeat.o(250725);
      return locala;
    }
    catch (Exception localException)
    {
      Log.e("EdgeComputingConfigParser", "[EdgeComputingConfigParser] parseScriptFieldConfig throw Exception : " + localException.getMessage() + ", fieldConfigJson : " + paramJSONObject.toString());
      AppMethodBeat.o(250725);
    }
    return null;
  }
  
  public static c b(String paramString, com.tencent.mm.plugin.expt.h.a parama)
  {
    AppMethodBeat.i(250720);
    if ((g.fK(paramString)) || (parama == null))
    {
      AppMethodBeat.o(250720);
      return null;
    }
    Log.d("EdgeComputingConfigParser", "[EdgeComputingConfigParser] parseNewSqlExptConfig configID : ".concat(String.valueOf(paramString)));
    try
    {
      int i = Integer.parseInt(a(parama.cache, "ECReportID", paramString, "0"));
      String str1 = a(parama.cache, "ECScriptUrl", paramString, "");
      String str2 = a(parama.cache, "ECDbPath", paramString, "");
      String str3 = a(parama.cache, "ECScriptMD5", paramString, "");
      int j = Integer.parseInt(a(parama.cache, "ECReportMethod", paramString, "0"));
      if ((i > 0) && (!g.fK(str1)))
      {
        boolean bool = g.fK(str3);
        if (!bool) {}
      }
      else
      {
        AppMethodBeat.o(250720);
        return null;
      }
      parama = new c();
      parama.wdY = paramString;
      parama.dbPath = str2;
      parama.wen = str1;
      parama.weo = str3;
      parama.wed = i;
      parama.wej = j;
      com.tencent.mm.plugin.expt.d.g.a.nf(true);
      AppMethodBeat.o(250720);
      return parama;
    }
    catch (Exception paramString)
    {
      com.tencent.mm.plugin.expt.d.g.a.nf(false);
      Log.e("EdgeComputingConfigParser", "[EdgeComputingConfigParser] parseSqlJsonConfig throw Exception : " + paramString.getMessage());
      AppMethodBeat.o(250720);
    }
    return null;
  }
  
  public static c gA(String paramString1, String paramString2)
  {
    AppMethodBeat.i(250726);
    if ((g.fK(paramString1)) || (g.fK(paramString2)))
    {
      AppMethodBeat.o(250726);
      return null;
    }
    Log.d("EdgeComputingConfigParser", "[EdgeComputingConfigParser] parseSqlJsonConfig configID : " + paramString1 + ", json : " + paramString2);
    try
    {
      Object localObject = new JSONObject(paramString2);
      int i = ((JSONObject)localObject).optInt("reportID", 0);
      String str1 = ((JSONObject)localObject).optString("sql", "");
      String str2 = ((JSONObject)localObject).optString("dbPath", "");
      String str3 = ((JSONObject)localObject).optString("sqlMD5", "");
      int j = ((JSONObject)localObject).optInt("reportMethod", 0);
      if ((i > 0) && (!g.fK(str1)))
      {
        boolean bool = g.fK(str3);
        if (!bool) {}
      }
      else
      {
        AppMethodBeat.o(250726);
        return null;
      }
      localObject = new c();
      ((c)localObject).wdY = paramString1;
      ((c)localObject).dbPath = str2;
      ((c)localObject).sql = str1;
      ((c)localObject).weo = str3;
      ((c)localObject).wed = i;
      ((c)localObject).wej = j;
      ((c)localObject).wel = paramString2;
      com.tencent.mm.plugin.expt.d.g.a.nf(true);
      AppMethodBeat.o(250726);
      return localObject;
    }
    catch (Exception paramString1)
    {
      com.tencent.mm.plugin.expt.d.g.a.nf(false);
      Log.e("EdgeComputingConfigParser", "[EdgeComputingConfigParser] parseSqlJsonConfig throw Exception : " + paramString1.getMessage() + ", json : " + paramString2);
      AppMethodBeat.o(250726);
    }
    return null;
  }
  
  public final b a(String paramString, com.tencent.mm.plugin.expt.h.a parama)
  {
    AppMethodBeat.i(250717);
    if ((g.fK(paramString)) || (parama == null))
    {
      AppMethodBeat.o(250717);
      return null;
    }
    Log.d("EdgeComputingConfigParser", "[EdgeComputingConfigParser] parseNewScriptExptConfig configID : ".concat(String.valueOf(paramString)));
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
        if (!g.fK(str2))
        {
          boolean bool = g.fK(str1);
          if (!bool) {}
        }
        else
        {
          AppMethodBeat.o(250717);
          return null;
        }
        b localb = new b();
        localb.wdY = paramString;
        localb.web = i;
        localb.wec = j;
        localb.wed = k;
        localb.wef = m;
        localb.weg = n;
        localb.weh = i1;
        localb.wei = i2;
        localb.wem = str1;
        localb.wek = str2;
        localb.wej = i3;
        localb.wee = new ArrayList();
        if (parama.length() > 0)
        {
          paramString = new com.tencent.mm.plugin.expt.d.f.a.a();
          paramString.index = 0;
          paramString.name = "report_time_ec";
          paramString.type = 2;
          localb.wee.add(paramString);
          i = 0;
          if (i < parama.length())
          {
            paramString = aP(parama.getJSONObject(i));
            if (paramString != null) {
              localb.wee.add(paramString);
            }
          }
          else
          {
            Collections.sort(localb.wee, new Comparator() {});
          }
        }
        else
        {
          com.tencent.mm.plugin.expt.d.g.a.ne(true);
          AppMethodBeat.o(250717);
          return localb;
        }
      }
      catch (Exception paramString)
      {
        com.tencent.mm.plugin.expt.d.g.a.ne(false);
        Log.e("EdgeComputingConfigParser", "[EdgeComputingConfigParser] parseScriptJsonConfig throw Exception : " + paramString.getMessage());
        AppMethodBeat.o(250717);
        return null;
      }
      i += 1;
    }
  }
  
  public final b gz(String paramString1, String paramString2)
  {
    AppMethodBeat.i(250723);
    if ((g.fK(paramString1)) || (g.fK(paramString2)))
    {
      AppMethodBeat.o(250723);
      return null;
    }
    Log.d("EdgeComputingConfigParser", "[EdgeComputingConfigParser] parseScriptJsonConfig configID : " + paramString1 + ", json : " + paramString2);
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
        if (!g.fK(str2))
        {
          boolean bool = g.fK(str1);
          if (!bool) {}
        }
        else
        {
          AppMethodBeat.o(250723);
          return null;
        }
        b localb = new b();
        localb.wdY = paramString1;
        localb.web = i;
        localb.wec = j;
        localb.wed = k;
        localb.wef = m;
        localb.weg = n;
        localb.weh = i1;
        localb.wei = i2;
        localb.wej = i3;
        localb.wem = str1;
        localb.script = new String(Base64.decode(str2, 0), "UTF-8");
        localb.wel = paramString2;
        localb.wee = new ArrayList();
        if ((localObject != null) && (((JSONArray)localObject).length() > 0))
        {
          paramString1 = new com.tencent.mm.plugin.expt.d.f.a.a();
          paramString1.index = 0;
          paramString1.name = "report_time_ec";
          paramString1.type = 2;
          localb.wee.add(paramString1);
          i = 0;
          if (i < ((JSONArray)localObject).length())
          {
            paramString1 = aQ(((JSONArray)localObject).getJSONObject(i));
            if (paramString1 != null) {
              localb.wee.add(paramString1);
            }
          }
          else
          {
            Collections.sort(localb.wee, new Comparator() {});
          }
        }
        else
        {
          com.tencent.mm.plugin.expt.d.g.a.ne(true);
          AppMethodBeat.o(250723);
          return localb;
        }
      }
      catch (Exception paramString1)
      {
        com.tencent.mm.plugin.expt.d.g.a.ne(false);
        Log.e("EdgeComputingConfigParser", "[EdgeComputingConfigParser] parseScriptJsonConfig throw Exception : " + paramString1.getMessage() + ", json : " + paramString2);
        AppMethodBeat.o(250723);
        return null;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.d.c.a
 * JD-Core Version:    0.7.0.1
 */