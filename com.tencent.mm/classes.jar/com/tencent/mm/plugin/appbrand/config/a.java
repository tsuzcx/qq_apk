package com.tencent.mm.plugin.appbrand.config;

import com.tencent.mm.plugin.appbrand.jsapi.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class a
  implements g
{
  public a.b fNB;
  private Map<String, a.d> fNC;
  public a.e fND;
  a.c fNE;
  public a.a fNF;
  public boolean fNG = true;
  public Set<String> fNH;
  public JSONObject fNI;
  public String fNJ;
  
  private static <T extends a.g> T a(JSONObject paramJSONObject, T paramT, a.g paramg)
  {
    Object localObject = paramJSONObject;
    if (paramJSONObject == null) {
      localObject = a.g.fOg;
    }
    localObject = ((JSONObject)localObject).optJSONObject("window");
    paramJSONObject = (JSONObject)localObject;
    if (localObject == null) {
      paramJSONObject = a.g.fOg;
    }
    paramT.fNU = paramJSONObject.optString("navigationBarTitleText", paramg.fNU);
    paramT.fNV = paramJSONObject.optString("navigationBarTextStyle", paramg.fNV);
    paramT.fNX = paramJSONObject.optString("navigationStyle", paramg.fNX);
    paramT.fNY = paramJSONObject.optString("navigationBarBackgroundColor", paramg.fNY);
    paramT.fNR = paramJSONObject.optString("backgroundColor", paramg.fNR);
    paramT.fOd = paramJSONObject.optBoolean("enablePullDownRefresh", paramg.fOd);
    paramT.fOe = paramJSONObject.optString("backgroundTextStyle", paramg.fOe);
    paramT.fOc = paramJSONObject.optBoolean("enableFullScreen", paramg.fOc);
    JSONObject localJSONObject = paramJSONObject.optJSONObject("navigationBarRightButton");
    localObject = localJSONObject;
    if (localJSONObject == null) {
      localObject = a.g.fOg;
    }
    paramT.fOb = ((JSONObject)localObject).optBoolean("hide", paramg.fOb);
    paramT.fNZ = ((JSONObject)localObject).optString("text", paramg.fNZ);
    paramT.fOa = ((JSONObject)localObject).optString("iconPath", paramg.fOa);
    paramT.fOf = paramJSONObject.optString("pageOrientation", paramg.fOf);
    y.i("MicroMsg.AppBrandAppConfig", "[parseWindow] pageOrientation = " + paramT.fOf);
    return paramT;
  }
  
  private static Map<String, a.d> a(JSONObject paramJSONObject, a.b paramb)
  {
    HashMap localHashMap = new HashMap();
    if (paramJSONObject == null) {
      return localHashMap;
    }
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localHashMap.put(str, b(paramJSONObject.optJSONObject(str), paramb));
    }
    return localHashMap;
  }
  
  private static a.d b(JSONObject paramJSONObject, a.b paramb)
  {
    return (a.d)a(paramJSONObject, new a.d(), paramb);
  }
  
  private static Set<String> h(JSONArray paramJSONArray)
  {
    HashSet localHashSet = new HashSet();
    if (paramJSONArray == null) {
      return localHashSet;
    }
    int i = 0;
    while (i < paramJSONArray.length())
    {
      String str = paramJSONArray.optString(i);
      if (!bk.bl(str)) {
        localHashSet.add(str);
      }
      i += 1;
    }
    return localHashSet;
  }
  
  private static a.e l(JSONObject paramJSONObject)
  {
    Object localObject = paramJSONObject;
    if (paramJSONObject == null) {
      localObject = new JSONObject();
    }
    paramJSONObject = new a.e();
    paramJSONObject.fNP = ((JSONObject)localObject).optString("position");
    paramJSONObject.color = ((JSONObject)localObject).optString("color");
    paramJSONObject.fNQ = ((JSONObject)localObject).optString("selectedColor");
    paramJSONObject.fNR = ((JSONObject)localObject).optString("backgroundColor");
    paramJSONObject.fNS = ((JSONObject)localObject).optString("borderStyle");
    try
    {
      localObject = ((JSONObject)localObject).getJSONArray("list");
      int i = 0;
      while (i < ((JSONArray)localObject).length())
      {
        ArrayList localArrayList = paramJSONObject.bTS;
        JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i);
        a.f localf = new a.f();
        localf.url = localJSONObject.optString("pagePath");
        localf.text = localJSONObject.optString("text");
        localf.bVO = localJSONObject.optString("iconData");
        localf.fNT = localJSONObject.optString("selectedIconData");
        localArrayList.add(localf);
        i += 1;
      }
      return paramJSONObject;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.AppBrandAppConfig", localException.getMessage());
    }
  }
  
  public static a se(String paramString)
  {
    a locala = new a();
    try
    {
      paramString = new JSONObject(paramString);
      locala.fNJ = paramString.optString("entryPagePath");
      locala.fNI = paramString;
      Object localObject1 = paramString.optJSONObject("global");
      Object localObject2 = new a.b();
      a((JSONObject)localObject1, (a.g)localObject2, (a.g)localObject2);
      locala.fNB = ((a.b)localObject2);
      locala.fNC = a(paramString.optJSONObject("page"), locala.fNB);
      locala.fND = l(paramString.optJSONObject("tabBar"));
      localObject2 = paramString.optJSONObject("networkTimeout");
      a.c localc = new a.c();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new JSONObject();
      }
      localc.cdI = ((JSONObject)localObject1).optInt("request");
      localc.fNM = ((JSONObject)localObject1).optInt("connectSocket");
      localc.fNO = ((JSONObject)localObject1).optInt("downloadFile");
      localc.fNN = ((JSONObject)localObject1).optInt("uploadFile");
      locala.fNE = localc;
      localObject1 = new a.a();
      ((a.a)localObject1).fNK = paramString.optString("deviceOrientation", "portrait");
      ((a.a)localObject1).fNL = paramString.optBoolean("showStatusBar", false);
      locala.fNF = ((a.a)localObject1);
      locala.fNG = paramString.optBoolean("preloadEnabled", true);
      locala.fNH = h(paramString.optJSONArray("requiredBackgroundModes"));
      return locala;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        y.e("MicroMsg.AppBrandAppConfig", paramString.getMessage());
        paramString = new JSONObject();
      }
    }
  }
  
  public final String adV()
  {
    if (!bk.bl(this.fNJ)) {
      return this.fNJ;
    }
    return "index.html";
  }
  
  public final a.d sd(String paramString)
  {
    if (this.fNC.containsKey(paramString)) {
      return (a.d)this.fNC.get(paramString);
    }
    return b(null, this.fNB);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.a
 * JD-Core Version:    0.7.0.1
 */