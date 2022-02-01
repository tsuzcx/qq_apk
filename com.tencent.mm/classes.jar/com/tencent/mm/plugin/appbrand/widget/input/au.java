package com.tencent.mm.plugin.appbrand.widget.input;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.input.e.e;
import com.tencent.mm.plugin.appbrand.widget.input.e.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tenpay.miniapp.MiniAppSecureEditText;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.v;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;
import org.json.JSONArray;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/widget/input/SecureInputLogic;", "", "()V", "TAG", "", "encryptCompat", "secureInput", "Lcom/tenpay/miniapp/MiniAppSecureEditText;", "rawSafePasswordCompatList", "", "timeStamp", "", "nonce", "parseSafePasswordCompatList", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "Lcom/tencent/mm/plugin/appbrand/widget/input/CompatAction;", "prepareInvokeParams", "data", "Lorg/json/JSONObject;", "params", "Lcom/tencent/mm/plugin/appbrand/widget/input/params/UpdateParams;", "applyParams", "newParams", "luggage-wxa-app-input-ext_release"})
public final class au
{
  public static final au ryC;
  
  static
  {
    AppMethodBeat.i(215210);
    ryC = new au();
    AppMethodBeat.o(215210);
  }
  
  public static String a(MiniAppSecureEditText paramMiniAppSecureEditText, List<String> paramList, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(215205);
    p.k(paramMiniAppSecureEditText, "secureInput");
    p.k(paramList, "rawSafePasswordCompatList");
    paramMiniAppSecureEditText.beginCustomHash();
    if (paramList.isEmpty()) {}
    ArrayList localArrayList;
    for (paramList = (List)v.aaAd;; paramList = (List)localArrayList)
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
        if (p.h("sm3", str)) {
          localArrayList.add(a.ryD);
        }
        for (;;)
        {
          i += 1;
          break;
          if (p.h("sha256", str))
          {
            localArrayList.add(b.ryE);
          }
          else if (p.h("sha1", str))
          {
            localArrayList.add(c.ryF);
          }
          else if (p.h("md5", str))
          {
            localArrayList.add(d.ryG);
          }
          else if (p.h("addSaltBefore", str))
          {
            i += 1;
            localArrayList.add(new e((String)paramList.get(i)));
          }
          else
          {
            int j = i;
            if (p.h("addSaltAfter", str))
            {
              j = i + 1;
              localArrayList.add(new f((String)paramList.get(j)));
            }
            i = j;
          }
        }
      }
    }
    paramMiniAppSecureEditText = paramMiniAppSecureEditText.endCustomHashAndEncrypt(paramLong1, paramLong2);
    AppMethodBeat.o(215205);
    return paramMiniAppSecureEditText;
  }
  
  public static void a(h paramh1, h paramh2)
  {
    AppMethodBeat.i(215202);
    p.k(paramh1, "$this$applyParams");
    p.k(paramh2, "newParams");
    Object localObject = paramh2.rAS;
    if (localObject != null) {
      paramh1.rAS = ((Integer)localObject);
    }
    if (paramh2.rAT != null) {
      paramh1.rAT = paramh2.rAT;
    }
    if (paramh2.rAU != null) {
      paramh1.rAU = paramh2.rAU;
    }
    if (paramh2.rAV != null) {
      paramh1.rAV = paramh2.rAV;
    }
    localObject = paramh2.rAW;
    p.j(localObject, "newParams.safePasswordCompatList");
    if (!((Collection)localObject).isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        paramh1.rAW = paramh2.rAW;
      }
      AppMethodBeat.o(215202);
      return;
    }
  }
  
  public static final void a(JSONObject paramJSONObject, h paramh)
  {
    AppMethodBeat.i(215199);
    p.k(paramJSONObject, "data");
    p.k(paramh, "params");
    if ((paramh instanceof e))
    {
      if (!paramJSONObject.has("viewId")) {
        break label73;
      }
      ((e)paramh).rAh = Integer.valueOf(paramJSONObject.optInt("viewId"));
    }
    for (;;)
    {
      paramJSONObject = paramJSONObject.optJSONObject("safePassword");
      if (paramJSONObject != null) {
        break;
      }
      Log.i("MicroMsg.AppBrand.SecureInputLogic", "prepareInvokeParams, safePasswordJsonObj is null");
      AppMethodBeat.o(215199);
      return;
      label73:
      Log.e("MicroMsg.AppBrand.SecureInputLogic", "prepareInvokeParams, viewId is null");
    }
    if ((paramJSONObject.has("certPath")) && (!paramJSONObject.isNull("certPath"))) {
      paramh.rAR = paramJSONObject.optString("certPath");
    }
    if ((paramJSONObject.has("passwordLength")) && (!paramJSONObject.isNull("passwordLength"))) {
      paramh.rAS = Integer.valueOf(paramJSONObject.optInt("passwordLength"));
    }
    if ((paramJSONObject.has("salt")) && (!paramJSONObject.isNull("salt"))) {
      paramh.rAT = paramJSONObject.optString("salt");
    }
    if ((paramJSONObject.has("timestamp")) && (!paramJSONObject.isNull("timestamp"))) {
      paramh.rAU = Long.valueOf(paramJSONObject.optLong("timestamp"));
    }
    if ((paramJSONObject.has("nonce")) && (!paramJSONObject.isNull("nonce"))) {
      paramh.rAV = Long.valueOf(paramJSONObject.optLong("nonce"));
    }
    if (paramJSONObject.has("customHash"))
    {
      paramJSONObject = paramJSONObject.optJSONArray("customHash");
      if (paramJSONObject != null)
      {
        int j = paramJSONObject.length();
        if (j > 0)
        {
          List localList = (List)new ArrayList(j);
          int i = 0;
          while (i < j)
          {
            String str = paramJSONObject.optString(i);
            if (!TextUtils.isEmpty((CharSequence)str))
            {
              p.j(str, "safePasswordCompat");
              localList.add(str);
            }
            i += 1;
          }
          paramh.rAW = localList;
        }
      }
    }
    AppMethodBeat.o(215199);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tenpay/miniapp/MiniAppSecureEditText;", "invoke"})
  static final class a
    extends q
    implements b<MiniAppSecureEditText, x>
  {
    public static final a ryD;
    
    static
    {
      AppMethodBeat.i(214593);
      ryD = new a();
      AppMethodBeat.o(214593);
    }
    
    a()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tenpay/miniapp/MiniAppSecureEditText;", "invoke"})
  static final class b
    extends q
    implements b<MiniAppSecureEditText, x>
  {
    public static final b ryE;
    
    static
    {
      AppMethodBeat.i(214807);
      ryE = new b();
      AppMethodBeat.o(214807);
    }
    
    b()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tenpay/miniapp/MiniAppSecureEditText;", "invoke"})
  static final class c
    extends q
    implements b<MiniAppSecureEditText, x>
  {
    public static final c ryF;
    
    static
    {
      AppMethodBeat.i(214015);
      ryF = new c();
      AppMethodBeat.o(214015);
    }
    
    c()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tenpay/miniapp/MiniAppSecureEditText;", "invoke"})
  static final class d
    extends q
    implements b<MiniAppSecureEditText, x>
  {
    public static final d ryG;
    
    static
    {
      AppMethodBeat.i(213982);
      ryG = new d();
      AppMethodBeat.o(213982);
    }
    
    d()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tenpay/miniapp/MiniAppSecureEditText;", "invoke"})
  static final class e
    extends q
    implements b<MiniAppSecureEditText, x>
  {
    e(String paramString)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tenpay/miniapp/MiniAppSecureEditText;", "invoke"})
  static final class f
    extends q
    implements b<MiniAppSecureEditText, x>
  {
    f(String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.au
 * JD-Core Version:    0.7.0.1
 */