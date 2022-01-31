package com.tencent.mm.plugin.appbrand.config;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a
  implements j
{
  public a.b hgL;
  private Map<String, a.d> hgM;
  private Map<String, a.e> hgN;
  public a.f hgO;
  public a.c hgP;
  public a hgQ;
  public boolean hgR = true;
  public boolean hgS = true;
  public boolean hgT = false;
  public Set<String> hgU;
  public JSONArray hgV;
  public ArrayList<String> hgW;
  public boolean hgX = false;
  public JSONObject hgY;
  public String hgZ;
  
  private static <T extends a.h> T a(JSONObject paramJSONObject, T paramT, a.h paramh)
  {
    AppMethodBeat.i(86884);
    Object localObject = paramJSONObject;
    if (paramJSONObject == null) {
      localObject = a.h.hhx;
    }
    localObject = ((JSONObject)localObject).optJSONObject("window");
    paramJSONObject = (JSONObject)localObject;
    if (localObject == null) {
      paramJSONObject = a.h.hhx;
    }
    paramT.hhl = paramJSONObject.optString("navigationBarTitleText", paramh.hhl);
    paramT.hhm = paramJSONObject.optString("navigationBarTextStyle", paramh.hhm);
    paramT.hho = paramJSONObject.optString("navigationStyle", paramh.hho);
    paramT.hhp = paramJSONObject.optString("navigationBarBackgroundColor", paramh.hhp);
    paramT.hhh = paramJSONObject.optString("backgroundColor", paramh.hhh);
    paramT.hht = paramJSONObject.optBoolean("enablePullDownRefresh", paramh.hht);
    paramT.hhv = paramJSONObject.optString("backgroundTextStyle", paramh.hhv);
    paramT.hhs = paramJSONObject.optBoolean("enableFullScreen", paramh.hhs);
    JSONObject localJSONObject = paramJSONObject.optJSONObject("navigationBarRightButton");
    localObject = localJSONObject;
    if (localJSONObject == null) {
      localObject = a.h.hhx;
    }
    paramT.hhu = paramJSONObject.optBoolean("disableSwipeBack", paramh.hhu);
    paramT.hhr = ((JSONObject)localObject).optBoolean("hide", paramh.hhr);
    paramT.hhq = ((JSONObject)localObject).optString("customButtonIconData", paramh.hhq);
    paramT.hhw = paramJSONObject.optString("pageOrientation", paramh.hhw);
    AppMethodBeat.o(86884);
    return paramT;
  }
  
  private static Map<String, a.d> a(JSONObject paramJSONObject, a.b paramb)
  {
    AppMethodBeat.i(86885);
    HashMap localHashMap = new HashMap();
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(86885);
      return localHashMap;
    }
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localHashMap.put(str, b(paramJSONObject.optJSONObject(str), paramb));
    }
    AppMethodBeat.o(86885);
    return localHashMap;
  }
  
  private static a.d b(JSONObject paramJSONObject, a.b paramb)
  {
    AppMethodBeat.i(86887);
    paramJSONObject = (a.d)a(paramJSONObject, new a.d(), paramb);
    AppMethodBeat.o(86887);
    return paramJSONObject;
  }
  
  private static Set<String> i(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(86889);
    HashSet localHashSet = new HashSet();
    if (paramJSONArray == null)
    {
      AppMethodBeat.o(86889);
      return localHashSet;
    }
    int i = 0;
    while (i < paramJSONArray.length())
    {
      String str = paramJSONArray.optString(i);
      if (!bo.isNullOrNil(str)) {
        localHashSet.add(str);
      }
      i += 1;
    }
    AppMethodBeat.o(86889);
    return localHashSet;
  }
  
  private static ArrayList<String> j(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(86890);
    ArrayList localArrayList = new ArrayList();
    if (paramJSONArray == null)
    {
      AppMethodBeat.o(86890);
      return localArrayList;
    }
    int i = 0;
    while (i < paramJSONArray.length())
    {
      Object localObject1 = paramJSONArray.optJSONObject(i);
      if (localObject1 != null)
      {
        Object localObject2 = ((JSONObject)localObject1).optString("root");
        if (!bo.isNullOrNil((String)localObject2))
        {
          localObject1 = localObject2;
          if (!((String)localObject2).startsWith("/")) {
            localObject1 = "/".concat(String.valueOf(localObject2));
          }
          localObject2 = localObject1;
          if (!((String)localObject1).endsWith(".js"))
          {
            localObject2 = localObject1;
            if (!((String)localObject1).endsWith("/")) {
              localObject2 = (String)localObject1 + "/";
            }
          }
          localArrayList.add(localObject2);
        }
      }
      i += 1;
    }
    AppMethodBeat.o(86890);
    return localArrayList;
  }
  
  private static Map<String, a.e> q(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(86886);
    HashMap localHashMap = new HashMap();
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(86886);
      return localHashMap;
    }
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      JSONObject localJSONObject = paramJSONObject.optJSONObject(str);
      if (localJSONObject != null) {
        try
        {
          localHashMap.put(str, new a.e(str, localJSONObject));
        }
        catch (JSONException localJSONException)
        {
          ab.e("MicroMsg.AppBrandAppConfig", localJSONException.getMessage());
        }
      }
    }
    AppMethodBeat.o(86886);
    return localHashMap;
  }
  
  private static a.f r(JSONObject paramJSONObject)
  {
    int i = 0;
    AppMethodBeat.i(86888);
    Object localObject = paramJSONObject;
    if (paramJSONObject == null) {
      localObject = new JSONObject();
    }
    paramJSONObject = new a.f();
    paramJSONObject.hhf = ((JSONObject)localObject).optString("position");
    paramJSONObject.color = ((JSONObject)localObject).optString("color");
    paramJSONObject.hhg = ((JSONObject)localObject).optString("selectedColor");
    paramJSONObject.hhh = ((JSONObject)localObject).optString("backgroundColor");
    paramJSONObject.hhi = ((JSONObject)localObject).optString("borderStyle");
    paramJSONObject.hhj = ((JSONObject)localObject).optBoolean("custom", false);
    try
    {
      localObject = ((JSONObject)localObject).getJSONArray("list");
      while (i < ((JSONArray)localObject).length())
      {
        ArrayList localArrayList = paramJSONObject.cBy;
        JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i);
        a.g localg = new a.g();
        localg.url = localJSONObject.optString("pagePath");
        localg.text = localJSONObject.optString("text");
        localg.cDz = localJSONObject.optString("iconData");
        localg.hhk = localJSONObject.optString("selectedIconData");
        localArrayList.add(localg);
        i += 1;
      }
      return paramJSONObject;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.AppBrandAppConfig", localException.getMessage());
      AppMethodBeat.o(86888);
    }
  }
  
  public static a zV(String paramString)
  {
    AppMethodBeat.i(86883);
    a locala = new a();
    try
    {
      paramString = new JSONObject(paramString);
      locala.hgZ = paramString.optString("entryPagePath");
      locala.hgY = paramString;
      Object localObject1 = paramString.optJSONObject("global");
      Object localObject2 = new a.b();
      a((JSONObject)localObject1, (a.h)localObject2, (a.h)localObject2);
      locala.hgL = ((a.b)localObject2);
      locala.hgM = a(paramString.optJSONObject("page"), locala.hgL);
      locala.hgN = q(paramString.optJSONObject("permission"));
      locala.hgO = r(paramString.optJSONObject("tabBar"));
      localObject2 = paramString.optJSONObject("networkTimeout");
      a.c localc = new a.c();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new JSONObject();
      }
      localc.cMs = ((JSONObject)localObject1).optInt("request");
      localc.hhc = ((JSONObject)localObject1).optInt("connectSocket");
      localc.hhe = ((JSONObject)localObject1).optInt("downloadFile");
      localc.hhd = ((JSONObject)localObject1).optInt("uploadFile");
      locala.hgP = localc;
      localObject1 = new a();
      ((a)localObject1).hha = paramString.optString("deviceOrientation", "portrait");
      ((a)localObject1).hhb = paramString.optBoolean("showStatusBar", false);
      locala.hgQ = ((a)localObject1);
      locala.hgR = paramString.optBoolean("preloadEnabled", true);
      locala.hgT = paramString.has("useCommandBuffer");
      locala.hgS = paramString.optBoolean("useCommandBuffer", false);
      locala.hgU = i(paramString.optJSONArray("requiredBackgroundModes"));
      locala.hgV = paramString.optJSONArray("preloadResources");
      locala.hgW = j(paramString.optJSONArray("preloadSubpackages"));
      locala.hgX = paramString.optBoolean("manualHideSplashScreen", false);
      locala.hgS = paramString.optBoolean("useCommandBuffer", false);
      AppMethodBeat.o(86883);
      return locala;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ab.e("MicroMsg.AppBrandAppConfig", paramString.getMessage());
        paramString = new JSONObject();
      }
    }
  }
  
  public final String ayn()
  {
    AppMethodBeat.i(86882);
    if (!bo.isNullOrNil(this.hgZ))
    {
      String str = this.hgZ;
      AppMethodBeat.o(86882);
      return str;
    }
    AppMethodBeat.o(86882);
    return "index.html";
  }
  
  public final a.d zT(String paramString)
  {
    AppMethodBeat.i(86880);
    if ((!TextUtils.isEmpty(paramString)) && (this.hgM.containsKey(paramString)))
    {
      paramString = (a.d)this.hgM.get(paramString);
      AppMethodBeat.o(86880);
      return paramString;
    }
    paramString = b(null, this.hgL);
    AppMethodBeat.o(86880);
    return paramString;
  }
  
  public final a.e zU(String paramString)
  {
    AppMethodBeat.i(86881);
    paramString = (a.e)this.hgN.get(paramString);
    AppMethodBeat.o(86881);
    return paramString;
  }
  
  public static final class a
  {
    public String hha = "portrait";
    public boolean hhb = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.a
 * JD-Core Version:    0.7.0.1
 */