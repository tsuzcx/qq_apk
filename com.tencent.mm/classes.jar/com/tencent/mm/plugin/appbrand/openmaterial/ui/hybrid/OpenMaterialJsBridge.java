package com.tencent.mm.plugin.appbrand.openmaterial.ui.hybrid;

import android.support.annotation.Keep;
import android.webkit.ValueCallback;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialDetailModel;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;
import org.json.JSONArray;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/hybrid/OpenMaterialJsBridge;", "", "webView", "Lcom/tencent/mm/ui/widget/MMWebView;", "(Lcom/tencent/mm/ui/widget/MMWebView;)V", "launchWeAppDelegate", "Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/hybrid/ILaunchWeAppDelegate;", "getLaunchWeAppDelegate", "()Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/hybrid/ILaunchWeAppDelegate;", "setLaunchWeAppDelegate", "(Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/hybrid/ILaunchWeAppDelegate;)V", "weAppExposureDelegate", "Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/hybrid/IWeAppExposureDelegate;", "getWeAppExposureDelegate", "()Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/hybrid/IWeAppExposureDelegate;", "setWeAppExposureDelegate", "(Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/hybrid/IWeAppExposureDelegate;)V", "attachMyOpenMaterials2Template", "", "htmlTemplateContent", "openMaterialDetailModels", "", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialDetailModel;", "launchWeApp", "", "launchJsonStr", "", "onWeAppExposure", "weAppJsonStr", "onWindowHeightChange", "newHeight", "", "plugin-appbrand-integration_release"})
@Keep
public final class OpenMaterialJsBridge
{
  private c launchWeAppDelegate;
  private d weAppExposureDelegate;
  private final MMWebView webView;
  
  public OpenMaterialJsBridge(MMWebView paramMMWebView)
  {
    AppMethodBeat.i(229230);
    this.webView = paramMMWebView;
    AppMethodBeat.o(229230);
  }
  
  public final byte[] attachMyOpenMaterials2Template(byte[] paramArrayOfByte, List<? extends AppBrandOpenMaterialDetailModel> paramList)
  {
    AppMethodBeat.i(229226);
    p.h(paramArrayOfByte, "htmlTemplateContent");
    p.h(paramList, "openMaterialDetailModels");
    Log.i("MicroMsg.AppBrand.OpenMaterialJsBridge", "attachMyOpenMaterials2Template");
    JSONArray localJSONArray1 = new JSONArray();
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      AppBrandOpenMaterialDetailModel localAppBrandOpenMaterialDetailModel = (AppBrandOpenMaterialDetailModel)paramList.next();
      JSONObject localJSONObject = new JSONObject();
      JSONArray localJSONArray2;
      try
      {
        localJSONObject.put("appId", localAppBrandOpenMaterialDetailModel.appId);
        localJSONObject.put("versionType", localAppBrandOpenMaterialDetailModel.iOo);
        localJSONObject.put("enterPath", localAppBrandOpenMaterialDetailModel.kHw);
        localJSONObject.put("iconUrl", localAppBrandOpenMaterialDetailModel.iconUrl);
        localJSONObject.put("functionName", localAppBrandOpenMaterialDetailModel.nlH);
        localJSONObject.put("functionDesc", localAppBrandOpenMaterialDetailModel.nlG);
        localJSONArray2 = new JSONArray();
        Object localObject = localAppBrandOpenMaterialDetailModel.lgE;
        p.g(localObject, "openMaterialDetailModel.categories");
        localObject = ((Iterable)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          localJSONArray2.put((String)((Iterator)localObject).next());
        }
      }
      catch (Exception localException)
      {
        Log.w("MicroMsg.AppBrand.OpenMaterialJsBridge", "attachMyOpenMaterials2Template, " + localAppBrandOpenMaterialDetailModel + " to json fail since " + localException);
      }
      localException.put("functionCategories", localJSONArray2);
      localException.put("score", Float.valueOf(localAppBrandOpenMaterialDetailModel.score));
      localJSONArray1.put(localException);
    }
    paramList = localJSONArray1.toString();
    p.g(paramList, "openMaterialDetailsJson.toString()");
    paramArrayOfByte = n.j(new String(paramArrayOfByte, kotlin.n.d.UTF_8), "###preloadObjFeedsData###", paramList, false);
    paramList = kotlin.n.d.UTF_8;
    if (paramArrayOfByte == null)
    {
      paramArrayOfByte = new t("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(229226);
      throw paramArrayOfByte;
    }
    paramArrayOfByte = paramArrayOfByte.getBytes(paramList);
    p.g(paramArrayOfByte, "(this as java.lang.String).getBytes(charset)");
    AppMethodBeat.o(229226);
    return paramArrayOfByte;
  }
  
  public final c getLaunchWeAppDelegate()
  {
    return this.launchWeAppDelegate;
  }
  
  public final d getWeAppExposureDelegate()
  {
    return this.weAppExposureDelegate;
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void launchWeApp(String paramString)
  {
    AppMethodBeat.i(229227);
    p.h(paramString, "launchJsonStr");
    Log.i("MicroMsg.AppBrand.OpenMaterialJsBridge", "launchWeApp, launchJsonStr: ".concat(String.valueOf(paramString)));
    c localc = this.launchWeAppDelegate;
    if (localc == null)
    {
      Log.w("MicroMsg.AppBrand.OpenMaterialJsBridge", "launchWeApp, launchWeAppDelegateSnapshot is null");
      AppMethodBeat.o(229227);
      return;
    }
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).getString("appId");
      int i = ((JSONObject)localObject).getInt("versionType");
      localObject = ((JSONObject)localObject).getString("enterPath");
      p.g(paramString, "appId");
      p.g(localObject, "enterPath");
      localc.B(paramString, i, (String)localObject);
      AppMethodBeat.o(229227);
      return;
    }
    catch (Exception paramString)
    {
      Log.w("MicroMsg.AppBrand.OpenMaterialJsBridge", "launchWeApp, fail since ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(229227);
    }
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void onWeAppExposure(String paramString)
  {
    AppMethodBeat.i(229229);
    p.h(paramString, "weAppJsonStr");
    Log.i("MicroMsg.AppBrand.OpenMaterialJsBridge", "onWeAppExposure, weAppJsonStr: ".concat(String.valueOf(paramString)));
    d locald = this.weAppExposureDelegate;
    if (locald == null)
    {
      Log.w("MicroMsg.AppBrand.OpenMaterialJsBridge", "onWeAppExposure, weAppExposureDelegateSnapshot is null");
      AppMethodBeat.o(229229);
      return;
    }
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).getString("appId");
      int i = ((JSONObject)localObject).getInt("versionType");
      localObject = ((JSONObject)localObject).getString("enterPath");
      p.g(paramString, "appId");
      p.g(localObject, "enterPath");
      locald.C(paramString, i, (String)localObject);
      AppMethodBeat.o(229229);
      return;
    }
    catch (Exception paramString)
    {
      Log.w("MicroMsg.AppBrand.OpenMaterialJsBridge", "onWeAppExposure, fail since ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(229229);
    }
  }
  
  public final void onWindowHeightChange(int paramInt)
  {
    AppMethodBeat.i(229228);
    Log.i("MicroMsg.AppBrand.OpenMaterialJsBridge", "onWindowHeightChange, newHeight: ".concat(String.valueOf(paramInt)));
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("height", paramInt);
      localObject = ((JSONObject)localObject).toString();
      p.g(localObject, "json.toString()");
      h.RTc.aV((Runnable)new a(this, (String)localObject));
      AppMethodBeat.o(229228);
      return;
    }
    catch (Exception localException)
    {
      Log.w("MicroMsg.AppBrand.OpenMaterialJsBridge", "onWindowHeightChange, fail since ".concat(String.valueOf(localException)));
      AppMethodBeat.o(229228);
    }
  }
  
  public final void setLaunchWeAppDelegate(c paramc)
  {
    this.launchWeAppDelegate = paramc;
  }
  
  public final void setWeAppExposureDelegate(d paramd)
  {
    this.weAppExposureDelegate = paramd;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(OpenMaterialJsBridge paramOpenMaterialJsBridge, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(229225);
      String str = String.format("javascript:OpenMaterialJsApi['%s'] && OpenMaterialJsApi.%s(%s)", Arrays.copyOf(new Object[] { "onWindowHeightChange", "onWindowHeightChange", this.nmU }, 3));
      p.g(str, "java.lang.String.format(this, *args)");
      OpenMaterialJsBridge.access$getWebView$p(this.nmT).evaluateJavascript(str, (ValueCallback)1.nmV);
      AppMethodBeat.o(229225);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.ui.hybrid.OpenMaterialJsBridge
 * JD-Core Version:    0.7.0.1
 */