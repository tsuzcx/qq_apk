package com.tencent.mm.plugin.appbrand.jsapi.bizvideochannel;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.brandservice.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.HashMap;
import kotlin.l;
import kotlin.t;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/bizvideochannel/JsApiOpenWebViewUseFastLoad;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "callback", "", "env", "callbackId", "", "resultJson", "", "invoke", "data", "Lorg/json/JSONObject;", "Companion", "OpenWebViewUseFastLoad", "plugin-appbrand-integration_release"})
public final class JsApiOpenWebViewUseFastLoad
  extends d<f>
{
  private static final int CTRL_INDEX = 764;
  private static final String NAME = "openWebViewUseFastLoad";
  public static final a lKI;
  
  static
  {
    AppMethodBeat.i(175164);
    lKI = new a((byte)0);
    NAME = "openWebViewUseFastLoad";
    CTRL_INDEX = 764;
    AppMethodBeat.o(175164);
  }
  
  private static void a(f paramf, int paramInt, String paramString)
  {
    AppMethodBeat.i(175163);
    if (paramf != null)
    {
      paramf.i(paramInt, paramString);
      AppMethodBeat.o(175163);
      return;
    }
    AppMethodBeat.o(175163);
  }
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    Object localObject2 = null;
    AppMethodBeat.i(175162);
    if (paramJSONObject != null) {}
    for (Object localObject1 = paramJSONObject.toString();; localObject1 = null)
    {
      Log.d("MicroMsg.JsApiOpenWebViewUseFastLoad", "alvinluo openWebViewUseFastLoad data: %s", new Object[] { localObject1 });
      if (((b)g.af(b.class)).CR(5)) {
        break;
      }
      Log.e("MicroMsg.JsApiOpenWebViewUseFastLoad", "alvinluo openWebViewUseFastLoad abtest closed");
      paramJSONObject = Zf("fail: abtest closed");
      kotlin.g.b.p.g(paramJSONObject, "makeReturnJson(\"fail: abtest closed\")");
      a(paramf, paramInt, paramJSONObject);
      AppMethodBeat.o(175162);
      return;
    }
    if (paramJSONObject == null)
    {
      paramJSONObject = Zf("fail: invalid param");
      kotlin.g.b.p.g(paramJSONObject, "makeReturnJson(\"fail: invalid param\")");
      a(paramf, paramInt, paramJSONObject);
      AppMethodBeat.o(175162);
      return;
    }
    if (!paramJSONObject.has("url"))
    {
      paramJSONObject = Zf("fail: invalid url");
      kotlin.g.b.p.g(paramJSONObject, "makeReturnJson(\"fail: invalid url\")");
      a(paramf, paramInt, paramJSONObject);
      AppMethodBeat.o(175162);
      return;
    }
    if (!paramJSONObject.has("item_show_type"))
    {
      paramJSONObject = Zf("fail: invalid item_show_type");
      kotlin.g.b.p.g(paramJSONObject, "makeReturnJson(\"fail: invalid item_show_type\")");
      a(paramf, paramInt, paramJSONObject);
      AppMethodBeat.o(175162);
      return;
    }
    if (!paramJSONObject.has("scene"))
    {
      paramJSONObject = Zf("fail: invalid scene");
      kotlin.g.b.p.g(paramJSONObject, "makeReturnJson(\"fail: invalid scene\")");
      a(paramf, paramInt, paramJSONObject);
      AppMethodBeat.o(175162);
      return;
    }
    if (!paramJSONObject.has("openType"))
    {
      paramJSONObject = Zf("fail: invalid openType");
      kotlin.g.b.p.g(paramJSONObject, "makeReturnJson(\"fail: invalid openType\")");
      a(paramf, paramInt, paramJSONObject);
      AppMethodBeat.o(175162);
      return;
    }
    HashMap localHashMap = new HashMap();
    b localb = (b)g.af(b.class);
    localObject1 = localObject2;
    if (paramf != null) {
      localObject1 = paramf.getContext();
    }
    localb.a((Context)localObject1, paramJSONObject, localHashMap);
    boolean bool = kotlin.g.b.p.j(localHashMap.get("success"), Boolean.TRUE);
    paramJSONObject = localHashMap.get("desc");
    if (paramJSONObject != null)
    {
      if (paramJSONObject == null)
      {
        paramf = new t("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(175162);
        throw paramf;
      }
      localObject1 = (String)paramJSONObject;
      paramJSONObject = (JSONObject)localObject1;
      if (localObject1 != null) {}
    }
    else
    {
      paramJSONObject = "";
    }
    if (bool)
    {
      Log.i("MicroMsg.JsApiOpenWebViewUseFastLoad", "alvinluo openWebViewUseFastLoad success");
      paramJSONObject = Zf("ok");
      kotlin.g.b.p.g(paramJSONObject, "makeReturnJson(\"ok\")");
      a(paramf, paramInt, paramJSONObject);
      AppMethodBeat.o(175162);
      return;
    }
    Log.e("MicroMsg.JsApiOpenWebViewUseFastLoad", "alvinluo openWebViewUseFastLoad failed %s", new Object[] { paramJSONObject });
    paramJSONObject = Zf("fail: ".concat(String.valueOf(paramJSONObject)));
    kotlin.g.b.p.g(paramJSONObject, "makeReturnJson(\"fail: $errMsg\")");
    a(paramf, paramInt, paramJSONObject);
    AppMethodBeat.o(175162);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/bizvideochannel/JsApiOpenWebViewUseFastLoad$OpenWebViewUseFastLoad;", "Lcom/tencent/mm/plugin/appbrand/ipc/MainProcessTask;", "()V", "api", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;", "service", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "callbackId", "", "data", "Lorg/json/JSONObject;", "(Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;ILorg/json/JSONObject;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "errMsg", "", "jsapi", "success", "", "describeContents", "parseFromParcel", "", "src", "runInClientProcess", "runInMainProcess", "writeToParcel", "flags", "CREATOR", "plugin-appbrand-integration_release"})
  static final class OpenWebViewUseFastLoad
    extends MainProcessTask
  {
    public static final a CREATOR;
    private String errMsg = "";
    private f lAx;
    private com.tencent.mm.plugin.appbrand.jsapi.p lKG;
    private JSONObject lnV;
    private int lqe;
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
      f(paramParcel);
      AppMethodBeat.o(175160);
    }
    
    public final void bjj()
    {
      AppMethodBeat.i(175156);
      if (!((b)g.af(b.class)).CR(5))
      {
        Log.e("MicroMsg.JsApiOpenWebViewUseFastLoad", "alvinluo openWebViewUseFastLoad abtest closed");
        this.success = false;
        this.errMsg = "abtest closed";
        bDU();
        AppMethodBeat.o(175156);
        return;
      }
      Object localObject = new HashMap();
      ((b)g.af(b.class)).a(MMApplicationContext.getContext(), this.lnV, (HashMap)localObject);
      this.success = kotlin.g.b.p.j(((HashMap)localObject).get("success"), Boolean.TRUE);
      localObject = ((HashMap)localObject).get("desc");
      if (localObject != null)
      {
        if (localObject == null)
        {
          localObject = new t("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(175156);
          throw ((Throwable)localObject);
        }
        localObject = (String)localObject;
        if (localObject != null) {}
      }
      else
      {
        localObject = "";
      }
      for (;;)
      {
        this.errMsg = ((String)localObject);
        bDU();
        AppMethodBeat.o(175156);
        return;
      }
    }
    
    public final void bjk()
    {
      f localf = null;
      Object localObject1 = null;
      AppMethodBeat.i(175157);
      super.bjk();
      bDK();
      int i;
      if (this.success)
      {
        Log.i("MicroMsg.JsApiOpenWebViewUseFastLoad", "alvinluo openWebViewUseFastLoad success");
        localf = this.lAx;
        if (localf != null)
        {
          i = this.lqe;
          localObject2 = this.lKG;
          if (localObject2 != null) {
            localObject1 = ((com.tencent.mm.plugin.appbrand.jsapi.p)localObject2).Zf("ok");
          }
          localf.i(i, (String)localObject1);
          AppMethodBeat.o(175157);
          return;
        }
        AppMethodBeat.o(175157);
        return;
      }
      Log.e("MicroMsg.JsApiOpenWebViewUseFastLoad", "alvinluo openWebViewUseFastLoad failed %s", new Object[] { this.errMsg });
      Object localObject2 = this.lAx;
      if (localObject2 != null)
      {
        i = this.lqe;
        com.tencent.mm.plugin.appbrand.jsapi.p localp = this.lKG;
        localObject1 = localf;
        if (localp != null) {
          localObject1 = localp.Zf("failed: " + this.errMsg);
        }
        ((f)localObject2).i(i, (String)localObject1);
        AppMethodBeat.o(175157);
        return;
      }
      AppMethodBeat.o(175157);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void f(Parcel paramParcel)
    {
      AppMethodBeat.i(175158);
      super.f(paramParcel);
      String str1;
      if (paramParcel != null)
      {
        String str2 = paramParcel.readString();
        str1 = str2;
        if (str2 != null) {}
      }
      else
      {
        str1 = "";
      }
      kotlin.g.b.p.g(str1, "src?.readString() ?: \"\"");
      this.lnV = new JSONObject(str1);
      if ((paramParcel != null) && (paramParcel.readInt() == 1)) {}
      for (boolean bool = true;; bool = false)
      {
        this.success = bool;
        if (paramParcel != null)
        {
          str1 = paramParcel.readString();
          paramParcel = str1;
          if (str1 != null) {}
        }
        else
        {
          paramParcel = "";
        }
        this.errMsg = paramParcel;
        AppMethodBeat.o(175158);
        return;
      }
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(175159);
      kotlin.g.b.p.h(paramParcel, "parcel");
      super.writeToParcel(paramParcel, paramInt);
      Object localObject = this.lnV;
      if (localObject != null)
      {
        String str = ((JSONObject)localObject).toString();
        localObject = str;
        if (str != null) {}
      }
      else
      {
        localObject = "";
      }
      paramParcel.writeString((String)localObject);
      if (this.success) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.errMsg);
        AppMethodBeat.o(175159);
        return;
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/bizvideochannel/JsApiOpenWebViewUseFastLoad$OpenWebViewUseFastLoad$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/bizvideochannel/JsApiOpenWebViewUseFastLoad$OpenWebViewUseFastLoad;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/bizvideochannel/JsApiOpenWebViewUseFastLoad$OpenWebViewUseFastLoad;", "plugin-appbrand-integration_release"})
    public static final class a
      implements Parcelable.Creator<JsApiOpenWebViewUseFastLoad.OpenWebViewUseFastLoad>
    {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/bizvideochannel/JsApiOpenWebViewUseFastLoad$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bizvideochannel.JsApiOpenWebViewUseFastLoad
 * JD-Core Version:    0.7.0.1
 */