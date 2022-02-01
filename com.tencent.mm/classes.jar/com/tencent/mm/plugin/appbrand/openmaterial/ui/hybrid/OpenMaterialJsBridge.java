package com.tencent.mm.plugin.appbrand.openmaterial.ui.hybrid;

import android.webkit.ValueCallback;
import androidx.annotation.Keep;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialDetailModel;
import com.tencent.mm.plugin.appbrand.openmaterial.model.b;
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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/hybrid/OpenMaterialJsBridge;", "", "webView", "Lcom/tencent/mm/ui/widget/MMWebView;", "(Lcom/tencent/mm/ui/widget/MMWebView;)V", "launchWeAppDelegate", "Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/hybrid/ILaunchWeAppDelegate;", "getLaunchWeAppDelegate", "()Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/hybrid/ILaunchWeAppDelegate;", "setLaunchWeAppDelegate", "(Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/hybrid/ILaunchWeAppDelegate;)V", "weAppExposureDelegate", "Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/hybrid/IWeAppExposureDelegate;", "getWeAppExposureDelegate", "()Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/hybrid/IWeAppExposureDelegate;", "setWeAppExposureDelegate", "(Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/hybrid/IWeAppExposureDelegate;)V", "attachMyOpenMaterials2Template", "", "htmlTemplateContent", "scene", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialScene;", "openMaterialDetailModels", "", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialDetailModel;", "launchWeApp", "", "launchJsonStr", "", "onWeAppExposure", "weAppJsonStr", "onWindowHeightChange", "newHeight", "", "plugin-appbrand-integration_release"})
@Keep
public final class OpenMaterialJsBridge
{
  private c launchWeAppDelegate;
  private d weAppExposureDelegate;
  private final MMWebView webView;
  
  public OpenMaterialJsBridge(MMWebView paramMMWebView)
  {
    AppMethodBeat.i(248933);
    this.webView = paramMMWebView;
    AppMethodBeat.o(248933);
  }
  
  public final byte[] attachMyOpenMaterials2Template(byte[] paramArrayOfByte, b paramb, List<? extends AppBrandOpenMaterialDetailModel> paramList)
  {
    AppMethodBeat.i(248927);
    p.k(paramArrayOfByte, "htmlTemplateContent");
    p.k(paramb, "scene");
    p.k(paramList, "openMaterialDetailModels");
    Log.i("MicroMsg.AppBrand.OpenMaterialJsBridge", "attachMyOpenMaterials2Template, scene: " + paramb.qnt);
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
        localJSONObject.put("versionType", localAppBrandOpenMaterialDetailModel.cBU);
        localJSONObject.put("enterPath", localAppBrandOpenMaterialDetailModel.nBq);
        localJSONObject.put("iconUrl", localAppBrandOpenMaterialDetailModel.iconUrl);
        localJSONObject.put("functionName", localAppBrandOpenMaterialDetailModel.qnk);
        localJSONObject.put("functionDesc", localAppBrandOpenMaterialDetailModel.qnj);
        localJSONArray2 = new JSONArray();
        Object localObject = localAppBrandOpenMaterialDetailModel.obg;
        p.j(localObject, "openMaterialDetailModel.categories");
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
    p.j(paramList, "openMaterialDetailsJson.toString()");
    paramArrayOfByte = new String(paramArrayOfByte, kotlin.n.d.UTF_8);
    paramb = paramb.qnt;
    p.j(paramb, "scene.myName");
    paramArrayOfByte = n.l(n.l(paramArrayOfByte, "###scene###", paramb, false), "###preloadObjFeedsData###", paramList, false);
    paramb = kotlin.n.d.UTF_8;
    if (paramArrayOfByte == null)
    {
      paramArrayOfByte = new t("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(248927);
      throw paramArrayOfByte;
    }
    paramArrayOfByte = paramArrayOfByte.getBytes(paramb);
    p.j(paramArrayOfByte, "(this as java.lang.String).getBytes(charset)");
    AppMethodBeat.o(248927);
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
    AppMethodBeat.i(248928);
    p.k(paramString, "launchJsonStr");
    Log.i("MicroMsg.AppBrand.OpenMaterialJsBridge", "launchWeApp, launchJsonStr: ".concat(String.valueOf(paramString)));
    c localc = this.launchWeAppDelegate;
    if (localc == null)
    {
      Log.w("MicroMsg.AppBrand.OpenMaterialJsBridge", "launchWeApp, launchWeAppDelegateSnapshot is null");
      AppMethodBeat.o(248928);
      return;
    }
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).getString("appId");
      int i = ((JSONObject)localObject).getInt("versionType");
      localObject = ((JSONObject)localObject).getString("enterPath");
      p.j(paramString, "appId");
      p.j(localObject, "enterPath");
      localc.C(paramString, i, (String)localObject);
      AppMethodBeat.o(248928);
      return;
    }
    catch (Exception paramString)
    {
      Log.w("MicroMsg.AppBrand.OpenMaterialJsBridge", "launchWeApp, fail since ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(248928);
    }
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void onWeAppExposure(String paramString)
  {
    AppMethodBeat.i(248932);
    p.k(paramString, "weAppJsonStr");
    Log.i("MicroMsg.AppBrand.OpenMaterialJsBridge", "onWeAppExposure, weAppJsonStr: ".concat(String.valueOf(paramString)));
    d locald = this.weAppExposureDelegate;
    if (locald == null)
    {
      Log.w("MicroMsg.AppBrand.OpenMaterialJsBridge", "onWeAppExposure, weAppExposureDelegateSnapshot is null");
      AppMethodBeat.o(248932);
      return;
    }
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).getString("appId");
      int i = ((JSONObject)localObject).getInt("versionType");
      localObject = ((JSONObject)localObject).getString("enterPath");
      p.j(paramString, "appId");
      p.j(localObject, "enterPath");
      locald.D(paramString, i, (String)localObject);
      AppMethodBeat.o(248932);
      return;
    }
    catch (Exception paramString)
    {
      Log.w("MicroMsg.AppBrand.OpenMaterialJsBridge", "onWeAppExposure, fail since ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(248932);
    }
  }
  
  public final void onWindowHeightChange(int paramInt)
  {
    AppMethodBeat.i(248930);
    Log.i("MicroMsg.AppBrand.OpenMaterialJsBridge", "onWindowHeightChange, newHeight: ".concat(String.valueOf(paramInt)));
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("height", paramInt);
      localObject = ((JSONObject)localObject).toString();
      p.j(localObject, "json.toString()");
      h.ZvG.bc((Runnable)new a(this, (String)localObject));
      AppMethodBeat.o(248930);
      return;
    }
    catch (Exception localException)
    {
      Log.w("MicroMsg.AppBrand.OpenMaterialJsBridge", "onWindowHeightChange, fail since ".concat(String.valueOf(localException)));
      AppMethodBeat.o(248930);
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(OpenMaterialJsBridge paramOpenMaterialJsBridge, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(279299);
      String str = String.format("javascript:OpenMaterialJsApi['%s'] && OpenMaterialJsApi.%s(%s)", Arrays.copyOf(new Object[] { "onWindowHeightChange", "onWindowHeightChange", this.qoC }, 3));
      p.j(str, "java.lang.String.format(this, *args)");
      OpenMaterialJsBridge.access$getWebView$p(this.qoB).evaluateJavascript(str, (ValueCallback)1.qoD);
      AppMethodBeat.o(279299);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.ui.hybrid.OpenMaterialJsBridge
 * JD-Core Version:    0.7.0.1
 */