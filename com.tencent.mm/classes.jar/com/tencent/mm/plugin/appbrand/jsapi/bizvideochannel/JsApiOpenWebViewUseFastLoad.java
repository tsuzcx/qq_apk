package com.tencent.mm.plugin.appbrand.jsapi.bizvideochannel;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.webview.ui.tools.widget.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/bizvideochannel/JsApiOpenWebViewUseFastLoad;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "callback", "", "env", "callbackId", "", "resultJson", "", "invoke", "data", "Lorg/json/JSONObject;", "Companion", "OpenWebViewUseFastLoad", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class JsApiOpenWebViewUseFastLoad
  extends com.tencent.mm.plugin.appbrand.jsapi.c<f>
{
  private static final int CTRL_INDEX;
  private static final String NAME;
  public static final a rJU;
  
  static
  {
    AppMethodBeat.i(175164);
    rJU = new a((byte)0);
    NAME = "openWebViewUseFastLoad";
    CTRL_INDEX = 764;
    AppMethodBeat.o(175164);
  }
  
  private static void a(f paramf, int paramInt, String paramString)
  {
    AppMethodBeat.i(175163);
    if (paramf != null) {
      paramf.callback(paramInt, paramString);
    }
    AppMethodBeat.o(175163);
  }
  
  private static final void a(f paramf, String paramString1, double paramDouble, String paramString2, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, boolean paramBoolean3, int paramInt2)
  {
    AppMethodBeat.i(327261);
    if (paramf != null)
    {
      paramf = paramf.getContext();
      if (paramf != null)
      {
        s.s(paramString1, "url");
        new a(paramf, paramString1, new com.tencent.mm.plugin.webview.ui.tools.widget.c((float)paramDouble, paramString2, paramBoolean1, paramBoolean2, paramInt1, paramBoolean3, paramInt2), 4).show();
      }
    }
    AppMethodBeat.o(327261);
  }
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(175162);
    if (paramJSONObject == null) {}
    for (Object localObject = null;; localObject = paramJSONObject.toString())
    {
      Log.d("MicroMsg.JsApiOpenWebViewUseFastLoad", "alvinluo openWebViewUseFastLoad data: %s", new Object[] { localObject });
      if (((com.tencent.mm.plugin.brandservice.api.c)h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).GV(5)) {
        break;
      }
      Log.e("MicroMsg.JsApiOpenWebViewUseFastLoad", "alvinluo openWebViewUseFastLoad abtest closed");
      paramJSONObject = ZP("fail: abtest closed");
      s.s(paramJSONObject, "makeReturnJson(\"fail: abtest closed\")");
      a(paramf, paramInt, paramJSONObject);
      AppMethodBeat.o(175162);
      return;
    }
    if (paramJSONObject == null)
    {
      paramJSONObject = ZP("fail: invalid param");
      s.s(paramJSONObject, "makeReturnJson(\"fail: invalid param\")");
      a(paramf, paramInt, paramJSONObject);
      AppMethodBeat.o(175162);
      return;
    }
    localObject = paramJSONObject.optString("url");
    s.s(localObject, "url");
    if (((CharSequence)localObject).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramJSONObject = ZP("fail: invalid url");
      s.s(paramJSONObject, "makeReturnJson(\"fail: invalid url\")");
      a(paramf, paramInt, paramJSONObject);
      AppMethodBeat.o(175162);
      return;
    }
    HashMap localHashMap = new HashMap();
    boolean bool1 = ((com.tencent.mm.plugin.brandservice.api.c)h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).isMpUrl((String)localObject);
    if (paramJSONObject.optBoolean("halfScreen"))
    {
      double d = paramJSONObject.optDouble("heightPercent", 0.75D);
      bool1 = paramJSONObject.optBoolean("reuseWebView", false);
      boolean bool2 = paramJSONObject.optBoolean("showMenu", false);
      MMHandlerThread.postToMainThread(new JsApiOpenWebViewUseFastLoad..ExternalSyntheticLambda0(paramf, (String)localObject, d, paramJSONObject.optString("extData"), bool1, bool2, paramJSONObject.optInt("backMode"), paramJSONObject.optBoolean("immersiveUIStyle"), paramJSONObject.optInt("openType")));
      s.p(localHashMap.get("success"), Boolean.TRUE);
      bool1 = s.p(localHashMap.get("success"), Boolean.TRUE);
      paramJSONObject = localHashMap.get("desc");
      if (paramJSONObject != null) {
        break label526;
      }
    }
    label526:
    for (paramJSONObject = "";; paramJSONObject = (String)paramJSONObject)
    {
      if (!bool1) {
        break label534;
      }
      Log.i("MicroMsg.JsApiOpenWebViewUseFastLoad", "alvinluo openWebViewUseFastLoad success");
      paramJSONObject = ZP("ok");
      s.s(paramJSONObject, "makeReturnJson(\"ok\")");
      a(paramf, paramInt, paramJSONObject);
      AppMethodBeat.o(175162);
      return;
      if (!bool1) {
        break;
      }
      if (!paramJSONObject.has("item_show_type"))
      {
        paramJSONObject = ZP("fail: invalid item_show_type");
        s.s(paramJSONObject, "makeReturnJson(\"fail: invalid item_show_type\")");
        a(paramf, paramInt, paramJSONObject);
        AppMethodBeat.o(175162);
        return;
      }
      if (!paramJSONObject.has("scene"))
      {
        paramJSONObject = ZP("fail: invalid scene");
        s.s(paramJSONObject, "makeReturnJson(\"fail: invalid scene\")");
        a(paramf, paramInt, paramJSONObject);
        AppMethodBeat.o(175162);
        return;
      }
      if (!paramJSONObject.has("openType"))
      {
        paramJSONObject = ZP("fail: invalid openType");
        s.s(paramJSONObject, "makeReturnJson(\"fail: invalid openType\")");
        a(paramf, paramInt, paramJSONObject);
        AppMethodBeat.o(175162);
        return;
      }
      com.tencent.mm.plugin.brandservice.api.c localc = (com.tencent.mm.plugin.brandservice.api.c)h.ax(com.tencent.mm.plugin.brandservice.api.c.class);
      if (paramf == null) {}
      for (localObject = null;; localObject = paramf.getContext())
      {
        localc.a((Context)localObject, paramJSONObject, localHashMap);
        break;
      }
    }
    label534:
    Log.e("MicroMsg.JsApiOpenWebViewUseFastLoad", "alvinluo openWebViewUseFastLoad failed %s", new Object[] { paramJSONObject });
    paramJSONObject = ZP(s.X("fail: ", paramJSONObject));
    s.s(paramJSONObject, "makeReturnJson(\"fail: $errMsg\")");
    a(paramf, paramInt, paramJSONObject);
    AppMethodBeat.o(175162);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/bizvideochannel/JsApiOpenWebViewUseFastLoad$OpenWebViewUseFastLoad;", "Lcom/tencent/mm/plugin/appbrand/ipc/MainProcessTask;", "()V", "api", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;", "service", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "callbackId", "", "data", "Lorg/json/JSONObject;", "(Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;ILorg/json/JSONObject;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "errMsg", "", "jsapi", "success", "", "describeContents", "parseFromParcel", "", "src", "runInClientProcess", "runInMainProcess", "writeToParcel", "flags", "CREATOR", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class OpenWebViewUseFastLoad
    extends MainProcessTask
  {
    public static final a CREATOR;
    private String errMsg = "";
    private p rJS;
    private JSONObject rmi;
    private int ror;
    private f rzi;
    private boolean success;
    
    static
    {
      AppMethodBeat.i(175161);
      CREATOR = new a((byte)0);
      AppMethodBeat.o(175161);
    }
    
    public OpenWebViewUseFastLoad() {}
    
    public OpenWebViewUseFastLoad(Parcel paramParcel)
    {
      this();
      AppMethodBeat.i(175160);
      h(paramParcel);
      AppMethodBeat.o(175160);
    }
    
    public final void asn()
    {
      AppMethodBeat.i(175156);
      if (!((com.tencent.mm.plugin.brandservice.api.c)h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).GV(5))
      {
        Log.e("MicroMsg.JsApiOpenWebViewUseFastLoad", "alvinluo openWebViewUseFastLoad abtest closed");
        this.success = false;
        this.errMsg = "abtest closed";
        cpA();
        AppMethodBeat.o(175156);
        return;
      }
      Object localObject = new HashMap();
      ((com.tencent.mm.plugin.brandservice.api.c)h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).a(MMApplicationContext.getContext(), this.rmi, (HashMap)localObject);
      this.success = s.p(((HashMap)localObject).get("success"), Boolean.TRUE);
      localObject = ((HashMap)localObject).get("desc");
      if (localObject == null) {}
      for (localObject = "";; localObject = (String)localObject)
      {
        this.errMsg = ((String)localObject);
        cpA();
        AppMethodBeat.o(175156);
        return;
      }
    }
    
    public final void bQr()
    {
      f localf = null;
      Object localObject1 = null;
      AppMethodBeat.i(175157);
      super.bQr();
      cpx();
      int i;
      Object localObject2;
      if (this.success)
      {
        Log.i("MicroMsg.JsApiOpenWebViewUseFastLoad", "alvinluo openWebViewUseFastLoad success");
        localf = this.rzi;
        if (localf != null)
        {
          i = this.ror;
          localObject2 = this.rJS;
          if (localObject2 == null) {}
          for (;;)
          {
            localf.callback(i, (String)localObject1);
            AppMethodBeat.o(175157);
            return;
            localObject1 = ((p)localObject2).ZP("ok");
          }
        }
      }
      else
      {
        Log.e("MicroMsg.JsApiOpenWebViewUseFastLoad", "alvinluo openWebViewUseFastLoad failed %s", new Object[] { this.errMsg });
        localObject2 = this.rzi;
        if (localObject2 != null)
        {
          i = this.ror;
          localObject1 = this.rJS;
          if (localObject1 != null) {
            break label141;
          }
        }
      }
      label141:
      for (localObject1 = localf;; localObject1 = ((p)localObject1).ZP(s.X("failed: ", this.errMsg)))
      {
        ((f)localObject2).callback(i, (String)localObject1);
        AppMethodBeat.o(175157);
        return;
      }
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void h(Parcel paramParcel)
    {
      AppMethodBeat.i(175158);
      super.h(paramParcel);
      Object localObject;
      boolean bool;
      if (paramParcel == null)
      {
        localObject = "";
        this.rmi = new JSONObject((String)localObject);
        if ((paramParcel == null) || (paramParcel.readInt() != 1)) {
          break label86;
        }
        bool = true;
        label43:
        this.success = bool;
        if (paramParcel != null) {
          break label91;
        }
        paramParcel = "";
      }
      for (;;)
      {
        this.errMsg = paramParcel;
        AppMethodBeat.o(175158);
        return;
        String str = paramParcel.readString();
        localObject = str;
        if (str != null) {
          break;
        }
        localObject = "";
        break;
        label86:
        bool = false;
        break label43;
        label91:
        localObject = paramParcel.readString();
        paramParcel = (Parcel)localObject;
        if (localObject == null) {
          paramParcel = "";
        }
      }
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(175159);
      s.u(paramParcel, "parcel");
      super.writeToParcel(paramParcel, paramInt);
      Object localObject = this.rmi;
      if (localObject == null)
      {
        localObject = "";
        paramParcel.writeString((String)localObject);
        if (!this.success) {
          break label82;
        }
      }
      label82:
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.errMsg);
        AppMethodBeat.o(175159);
        return;
        String str = ((JSONObject)localObject).toString();
        localObject = str;
        if (str != null) {
          break;
        }
        localObject = "";
        break;
      }
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/bizvideochannel/JsApiOpenWebViewUseFastLoad$OpenWebViewUseFastLoad$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/bizvideochannel/JsApiOpenWebViewUseFastLoad$OpenWebViewUseFastLoad;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/bizvideochannel/JsApiOpenWebViewUseFastLoad$OpenWebViewUseFastLoad;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements Parcelable.Creator<JsApiOpenWebViewUseFastLoad.OpenWebViewUseFastLoad>
    {}
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/bizvideochannel/JsApiOpenWebViewUseFastLoad$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bizvideochannel.JsApiOpenWebViewUseFastLoad
 * JD-Core Version:    0.7.0.1
 */