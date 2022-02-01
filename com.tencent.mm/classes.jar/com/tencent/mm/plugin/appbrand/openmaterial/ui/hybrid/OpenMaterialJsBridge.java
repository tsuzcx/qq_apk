package com.tencent.mm.plugin.appbrand.openmaterial.ui.hybrid;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialDetailModel;
import com.tencent.mm.plugin.appbrand.openmaterial.model.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.n.n;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/hybrid/OpenMaterialJsBridge;", "", "webView", "Lcom/tencent/mm/ui/widget/MMWebView;", "(Lcom/tencent/mm/ui/widget/MMWebView;)V", "launchWeAppDelegate", "Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/hybrid/ILaunchWeAppDelegate;", "getLaunchWeAppDelegate", "()Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/hybrid/ILaunchWeAppDelegate;", "setLaunchWeAppDelegate", "(Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/hybrid/ILaunchWeAppDelegate;)V", "weAppExposureDelegate", "Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/hybrid/IWeAppExposureDelegate;", "getWeAppExposureDelegate", "()Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/hybrid/IWeAppExposureDelegate;", "setWeAppExposureDelegate", "(Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/hybrid/IWeAppExposureDelegate;)V", "attachMyOpenMaterials2Template", "", "htmlTemplateContent", "scene", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialScene;", "openMaterialDetailModels", "", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialDetailModel;", "launchWeApp", "", "launchJsonStr", "", "onWeAppExposure", "weAppJsonStr", "onWindowHeightChange", "newHeight", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class OpenMaterialJsBridge
{
  private c launchWeAppDelegate;
  private d weAppExposureDelegate;
  private final MMWebView webView;
  
  public OpenMaterialJsBridge(MMWebView paramMMWebView)
  {
    AppMethodBeat.i(323693);
    this.webView = paramMMWebView;
    AppMethodBeat.o(323693);
  }
  
  private static final void onWindowHeightChange$lambda-5(String paramString, OpenMaterialJsBridge paramOpenMaterialJsBridge)
  {
    AppMethodBeat.i(323710);
    s.u(paramString, "$jsonStr");
    s.u(paramOpenMaterialJsBridge, "this$0");
    paramString = String.format("javascript:OpenMaterialJsApi['%s'] && OpenMaterialJsApi.%s(%s)", Arrays.copyOf(new Object[] { "onWindowHeightChange", "onWindowHeightChange", paramString }, 3));
    s.s(paramString, "java.lang.String.format(this, *args)");
    paramOpenMaterialJsBridge.webView.evaluateJavascript(paramString, OpenMaterialJsBridge..ExternalSyntheticLambda0.INSTANCE);
    AppMethodBeat.o(323710);
  }
  
  private static final void onWindowHeightChange$lambda-5$lambda-4(String paramString)
  {
    AppMethodBeat.i(323700);
    Log.i("MicroMsg.AppBrand.OpenMaterialJsBridge", s.X("onWindowHeightChange, result: ", paramString));
    AppMethodBeat.o(323700);
  }
  
  public final byte[] attachMyOpenMaterials2Template(byte[] paramArrayOfByte, b paramb, List<? extends AppBrandOpenMaterialDetailModel> paramList)
  {
    AppMethodBeat.i(323770);
    s.u(paramArrayOfByte, "htmlTemplateContent");
    s.u(paramb, "scene");
    s.u(paramList, "openMaterialDetailModels");
    Log.i("MicroMsg.AppBrand.OpenMaterialJsBridge", s.X("attachMyOpenMaterials2Template, scene: ", paramb.tsa));
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
        localJSONObject.put("versionType", localAppBrandOpenMaterialDetailModel.euz);
        localJSONObject.put("enterPath", localAppBrandOpenMaterialDetailModel.qAF);
        localJSONObject.put("iconUrl", localAppBrandOpenMaterialDetailModel.iconUrl);
        localJSONObject.put("functionName", localAppBrandOpenMaterialDetailModel.trR);
        localJSONObject.put("functionDesc", localAppBrandOpenMaterialDetailModel.trQ);
        localJSONArray2 = new JSONArray();
        localObject = localAppBrandOpenMaterialDetailModel.rbS;
        s.s(localObject, "openMaterialDetailModel.categories");
        localObject = ((Iterable)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          localJSONArray2.put((String)((Iterator)localObject).next());
        }
      }
      catch (Exception localException)
      {
        Log.w("MicroMsg.AppBrand.OpenMaterialJsBridge", "attachMyOpenMaterials2Template, " + localAppBrandOpenMaterialDetailModel + " to json fail since " + localException);
      }
      Object localObject = ah.aiuX;
      localException.put("functionCategories", localJSONArray2);
      localException.put("score", Float.valueOf(localAppBrandOpenMaterialDetailModel.score));
      localJSONArray1.put(localException);
    }
    paramList = localJSONArray1.toString();
    s.s(paramList, "openMaterialDetailsJson.toString()");
    paramArrayOfByte = new String(paramArrayOfByte, kotlin.n.d.UTF_8);
    paramb = paramb.tsa;
    s.s(paramb, "scene.myName");
    paramArrayOfByte = n.bV(n.bV(paramArrayOfByte, "###scene###", paramb), "###preloadObjFeedsData###", paramList);
    paramb = kotlin.n.d.UTF_8;
    if (paramArrayOfByte == null)
    {
      paramArrayOfByte = new NullPointerException("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(323770);
      throw paramArrayOfByte;
    }
    paramArrayOfByte = paramArrayOfByte.getBytes(paramb);
    s.s(paramArrayOfByte, "(this as java.lang.String).getBytes(charset)");
    AppMethodBeat.o(323770);
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
    AppMethodBeat.i(323781);
    s.u(paramString, "launchJsonStr");
    Log.i("MicroMsg.AppBrand.OpenMaterialJsBridge", s.X("launchWeApp, launchJsonStr: ", paramString));
    c localc = this.launchWeAppDelegate;
    if (localc == null)
    {
      Log.w("MicroMsg.AppBrand.OpenMaterialJsBridge", "launchWeApp, launchWeAppDelegateSnapshot is null");
      AppMethodBeat.o(323781);
      return;
    }
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).getString("appId");
      int i = ((JSONObject)localObject).getInt("versionType");
      localObject = ((JSONObject)localObject).getString("enterPath");
      s.s(paramString, "appId");
      s.s(localObject, "enterPath");
      localc.E(paramString, i, (String)localObject);
      AppMethodBeat.o(323781);
      return;
    }
    catch (Exception paramString)
    {
      Log.w("MicroMsg.AppBrand.OpenMaterialJsBridge", s.X("launchWeApp, fail since ", paramString));
      AppMethodBeat.o(323781);
    }
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void onWeAppExposure(String paramString)
  {
    AppMethodBeat.i(323800);
    s.u(paramString, "weAppJsonStr");
    Log.i("MicroMsg.AppBrand.OpenMaterialJsBridge", s.X("onWeAppExposure, weAppJsonStr: ", paramString));
    d locald = this.weAppExposureDelegate;
    if (locald == null)
    {
      Log.w("MicroMsg.AppBrand.OpenMaterialJsBridge", "onWeAppExposure, weAppExposureDelegateSnapshot is null");
      AppMethodBeat.o(323800);
      return;
    }
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).getString("appId");
      int i = ((JSONObject)localObject).getInt("versionType");
      localObject = ((JSONObject)localObject).getString("enterPath");
      s.s(paramString, "appId");
      s.s(localObject, "enterPath");
      locald.F(paramString, i, (String)localObject);
      AppMethodBeat.o(323800);
      return;
    }
    catch (Exception paramString)
    {
      Log.w("MicroMsg.AppBrand.OpenMaterialJsBridge", s.X("onWeAppExposure, fail since ", paramString));
      AppMethodBeat.o(323800);
    }
  }
  
  public final void onWindowHeightChange(int paramInt)
  {
    AppMethodBeat.i(323791);
    Log.i("MicroMsg.AppBrand.OpenMaterialJsBridge", s.X("onWindowHeightChange, newHeight: ", Integer.valueOf(paramInt)));
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("height", paramInt);
      localObject = ((JSONObject)localObject).toString();
      s.s(localObject, "json.toString()");
      h.ahAA.bk(new OpenMaterialJsBridge..ExternalSyntheticLambda1((String)localObject, this));
      AppMethodBeat.o(323791);
      return;
    }
    catch (Exception localException)
    {
      Log.w("MicroMsg.AppBrand.OpenMaterialJsBridge", s.X("onWindowHeightChange, fail since ", localException));
      AppMethodBeat.o(323791);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.ui.hybrid.OpenMaterialJsBridge
 * JD-Core Version:    0.7.0.1
 */