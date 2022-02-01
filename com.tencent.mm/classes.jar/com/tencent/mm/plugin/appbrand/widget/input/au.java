package com.tencent.mm.plugin.appbrand.widget.input;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.plugin.appbrand.widget.input.e.e;
import com.tencent.mm.plugin.appbrand.widget.input.e.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tenpay.miniapp.MiniAppSecureEditText;
import com.tenpay.ndk.FitScLibraryLoader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.ab;
import kotlin.g.a.b;
import kotlin.g.b.s;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/widget/input/SecureInputLogic;", "", "()V", "TAG", "", "encryptCompat", "secureInput", "Lcom/tenpay/miniapp/MiniAppSecureEditText;", "rawSafePasswordCompatList", "", "timeStamp", "", "nonce", "parseSafePasswordCompatList", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "Lcom/tencent/mm/plugin/appbrand/widget/input/CompatAction;", "prepareInvokeParams", "data", "Lorg/json/JSONObject;", "params", "Lcom/tencent/mm/plugin/appbrand/widget/input/params/UpdateParams;", "applyParams", "newParams", "luggage-wxa-app-input-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class au
{
  public static final au uJG;
  
  static
  {
    AppMethodBeat.i(324483);
    uJG = new au();
    FitScLibraryLoader.setLoader(au..ExternalSyntheticLambda0.INSTANCE);
    AppMethodBeat.o(324483);
  }
  
  public static String a(MiniAppSecureEditText paramMiniAppSecureEditText, List<String> paramList, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(324471);
    s.u(paramMiniAppSecureEditText, "secureInput");
    s.u(paramList, "rawSafePasswordCompatList");
    paramMiniAppSecureEditText.beginCustomHash();
    if (paramList.isEmpty()) {}
    ArrayList localArrayList;
    for (paramList = (List)ab.aivy;; paramList = (List)localArrayList)
    {
      paramList = ((Iterable)paramList).iterator();
      while (paramList.hasNext()) {
        ((b)paramList.next()).invoke(paramMiniAppSecureEditText);
      }
      int k = paramList.size();
      localArrayList = new ArrayList(k);
      int i = 0;
      if (i < k)
      {
        String str = (String)paramList.get(i);
        if (s.p("sm3", str)) {
          localArrayList.add(au.a.uJH);
        }
        for (;;)
        {
          i += 1;
          break;
          if (s.p("sha256", str))
          {
            localArrayList.add(au.b.uJI);
          }
          else if (s.p("sha1", str))
          {
            localArrayList.add(au.c.uJJ);
          }
          else if (s.p("md5", str))
          {
            localArrayList.add(au.d.uJK);
          }
          else if (s.p("addSaltBefore", str))
          {
            i += 1;
            localArrayList.add(new au.e((String)paramList.get(i)));
          }
          else
          {
            int j = i;
            if (s.p("addSaltAfter", str))
            {
              j = i + 1;
              localArrayList.add(new au.f((String)paramList.get(j)));
            }
            i = j;
          }
        }
      }
    }
    paramMiniAppSecureEditText = paramMiniAppSecureEditText.endCustomHashAndEncrypt(paramLong1, paramLong2);
    AppMethodBeat.o(324471);
    return paramMiniAppSecureEditText;
  }
  
  public static void a(h paramh1, h paramh2)
  {
    AppMethodBeat.i(324462);
    s.u(paramh1, "<this>");
    s.u(paramh2, "newParams");
    Object localObject = paramh2.uMi;
    if (localObject != null) {
      paramh1.uMi = ((Integer)localObject);
    }
    if (paramh2.uMj != null) {
      paramh1.uMj = paramh2.uMj;
    }
    if (paramh2.uMk != null) {
      paramh1.uMk = paramh2.uMk;
    }
    if (paramh2.uMl != null) {
      paramh1.uMl = paramh2.uMl;
    }
    localObject = paramh2.uMm;
    s.s(localObject, "newParams.safePasswordCompatList");
    if (!((Collection)localObject).isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        paramh1.uMm = paramh2.uMm;
      }
      AppMethodBeat.o(324462);
      return;
    }
  }
  
  public static final void a(JSONObject paramJSONObject, h paramh)
  {
    AppMethodBeat.i(324457);
    s.u(paramJSONObject, "data");
    s.u(paramh, "params");
    if ((paramh instanceof e))
    {
      if (!paramJSONObject.has("viewId")) {
        break label76;
      }
      ((e)paramh).uLy = Integer.valueOf(paramJSONObject.optInt("viewId"));
    }
    for (;;)
    {
      paramJSONObject = paramJSONObject.optJSONObject("safePassword");
      if (paramJSONObject != null) {
        break;
      }
      Log.i("MicroMsg.AppBrand.SecureInputLogic", "prepareInvokeParams, safePasswordJsonObj is null");
      AppMethodBeat.o(324457);
      return;
      label76:
      Log.e("MicroMsg.AppBrand.SecureInputLogic", "prepareInvokeParams, viewId is null");
    }
    if ((paramJSONObject.has("certPath")) && (!paramJSONObject.isNull("certPath"))) {
      paramh.uMh = paramJSONObject.optString("certPath");
    }
    if ((paramJSONObject.has("passwordLength")) && (!paramJSONObject.isNull("passwordLength"))) {
      paramh.uMi = Integer.valueOf(paramJSONObject.optInt("passwordLength"));
    }
    if ((paramJSONObject.has("salt")) && (!paramJSONObject.isNull("salt"))) {
      paramh.uMj = paramJSONObject.optString("salt");
    }
    if ((paramJSONObject.has("timestamp")) && (!paramJSONObject.isNull("timestamp"))) {
      paramh.uMk = Long.valueOf(paramJSONObject.optLong("timestamp"));
    }
    if ((paramJSONObject.has("nonce")) && (!paramJSONObject.isNull("nonce"))) {
      paramh.uMl = Long.valueOf(paramJSONObject.optLong("nonce"));
    }
    int k;
    List localList;
    int i;
    if (paramJSONObject.has("customHash"))
    {
      paramJSONObject = paramJSONObject.optJSONArray("customHash");
      if (paramJSONObject != null)
      {
        k = paramJSONObject.length();
        if (k > 0)
        {
          localList = (List)new ArrayList(k);
          i = 0;
          if (k <= 0) {}
        }
      }
    }
    for (;;)
    {
      int j = i + 1;
      String str = paramJSONObject.optString(i);
      if (!TextUtils.isEmpty((CharSequence)str))
      {
        s.s(str, "safePasswordCompat");
        localList.add(str);
      }
      if (j >= k)
      {
        paramh.uMm = localList;
        AppMethodBeat.o(324457);
        return;
      }
      i = j;
    }
  }
  
  private static final void aha(String paramString)
  {
    AppMethodBeat.i(324479);
    Log.d("MicroMsg.AppBrand.SecureInputLogic", s.X("loadLibrary, libName: ", paramString));
    k.load(paramString);
    AppMethodBeat.o(324479);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.au
 * JD-Core Version:    0.7.0.1
 */