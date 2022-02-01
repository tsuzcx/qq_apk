package com.tencent.mm.plugin.appbrand.jsapi.bizvideochannel;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.brandservice.a.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import d.g.b.p;
import d.l;
import d.v;
import java.util.HashMap;
import org.json.JSONObject;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/bizvideochannel/JsApiOpenWebViewUseFastLoad;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "callback", "", "env", "callbackId", "", "resultJson", "", "invoke", "data", "Lorg/json/JSONObject;", "Companion", "OpenWebViewUseFastLoad", "plugin-appbrand-integration_release"})
public final class JsApiOpenWebViewUseFastLoad
  extends a<c>
{
  private static final int CTRL_INDEX = 764;
  private static final String NAME = "openWebViewUseFastLoad";
  public static final a kGh;
  
  static
  {
    AppMethodBeat.i(175164);
    kGh = new a((byte)0);
    NAME = "openWebViewUseFastLoad";
    CTRL_INDEX = 764;
    AppMethodBeat.o(175164);
  }
  
  private static void a(c paramc, int paramInt, String paramString)
  {
    AppMethodBeat.i(175163);
    if (paramc != null)
    {
      paramc.h(paramInt, paramString);
      AppMethodBeat.o(175163);
      return;
    }
    AppMethodBeat.o(175163);
  }
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    Object localObject2 = null;
    AppMethodBeat.i(175162);
    if (paramJSONObject != null) {}
    for (Object localObject1 = paramJSONObject.toString();; localObject1 = null)
    {
      ae.d("MicroMsg.JsApiOpenWebViewUseFastLoad", "alvinluo openWebViewUseFastLoad data: %s", new Object[] { localObject1 });
      if (((b)g.ab(b.class)).zl(5)) {
        break;
      }
      ae.e("MicroMsg.JsApiOpenWebViewUseFastLoad", "alvinluo openWebViewUseFastLoad abtest closed");
      paramJSONObject = PO("fail: abtest closed");
      p.g(paramJSONObject, "makeReturnJson(\"fail: abtest closed\")");
      a(paramc, paramInt, paramJSONObject);
      AppMethodBeat.o(175162);
      return;
    }
    if (paramJSONObject == null)
    {
      paramJSONObject = PO("fail: invalid param");
      p.g(paramJSONObject, "makeReturnJson(\"fail: invalid param\")");
      a(paramc, paramInt, paramJSONObject);
      AppMethodBeat.o(175162);
      return;
    }
    if (!paramJSONObject.has("url"))
    {
      paramJSONObject = PO("fail: invalid url");
      p.g(paramJSONObject, "makeReturnJson(\"fail: invalid url\")");
      a(paramc, paramInt, paramJSONObject);
      AppMethodBeat.o(175162);
      return;
    }
    if (!paramJSONObject.has("item_show_type"))
    {
      paramJSONObject = PO("fail: invalid item_show_type");
      p.g(paramJSONObject, "makeReturnJson(\"fail: invalid item_show_type\")");
      a(paramc, paramInt, paramJSONObject);
      AppMethodBeat.o(175162);
      return;
    }
    if (!paramJSONObject.has("scene"))
    {
      paramJSONObject = PO("fail: invalid scene");
      p.g(paramJSONObject, "makeReturnJson(\"fail: invalid scene\")");
      a(paramc, paramInt, paramJSONObject);
      AppMethodBeat.o(175162);
      return;
    }
    if (!paramJSONObject.has("openType"))
    {
      paramJSONObject = PO("fail: invalid openType");
      p.g(paramJSONObject, "makeReturnJson(\"fail: invalid openType\")");
      a(paramc, paramInt, paramJSONObject);
      AppMethodBeat.o(175162);
      return;
    }
    HashMap localHashMap = new HashMap();
    b localb = (b)g.ab(b.class);
    localObject1 = localObject2;
    if (paramc != null) {
      localObject1 = paramc.getContext();
    }
    localb.a((Context)localObject1, paramJSONObject, localHashMap);
    boolean bool = p.i(localHashMap.get("success"), Boolean.TRUE);
    paramJSONObject = localHashMap.get("desc");
    if (paramJSONObject != null)
    {
      if (paramJSONObject == null)
      {
        paramc = new v("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(175162);
        throw paramc;
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
      ae.i("MicroMsg.JsApiOpenWebViewUseFastLoad", "alvinluo openWebViewUseFastLoad success");
      paramJSONObject = PO("ok");
      p.g(paramJSONObject, "makeReturnJson(\"ok\")");
      a(paramc, paramInt, paramJSONObject);
      AppMethodBeat.o(175162);
      return;
    }
    ae.e("MicroMsg.JsApiOpenWebViewUseFastLoad", "alvinluo openWebViewUseFastLoad failed %s", new Object[] { paramJSONObject });
    paramJSONObject = PO("fail: ".concat(String.valueOf(paramJSONObject)));
    p.g(paramJSONObject, "makeReturnJson(\"fail: $errMsg\")");
    a(paramc, paramInt, paramJSONObject);
    AppMethodBeat.o(175162);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/bizvideochannel/JsApiOpenWebViewUseFastLoad$OpenWebViewUseFastLoad;", "Lcom/tencent/mm/plugin/appbrand/ipc/MainProcessTask;", "()V", "api", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;", "service", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "callbackId", "", "data", "Lorg/json/JSONObject;", "(Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;ILorg/json/JSONObject;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "errMsg", "", "jsapi", "success", "", "describeContents", "parseFromParcel", "", "src", "runInClientProcess", "runInMainProcess", "writeToParcel", "flags", "CREATOR", "plugin-appbrand-integration_release"})
  static final class OpenWebViewUseFastLoad
    extends MainProcessTask
  {
    public static final a CREATOR;
    private String errMsg = "";
    private m kGf;
    private JSONObject kkm;
    private int kmu;
    private c kws;
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
      e(paramParcel);
      AppMethodBeat.o(175160);
    }
    
    public final void aOX()
    {
      AppMethodBeat.i(175156);
      if (!((b)g.ab(b.class)).zl(5))
      {
        ae.e("MicroMsg.JsApiOpenWebViewUseFastLoad", "alvinluo openWebViewUseFastLoad abtest closed");
        this.success = false;
        this.errMsg = "abtest closed";
        biG();
        AppMethodBeat.o(175156);
        return;
      }
      Object localObject = new HashMap();
      ((b)g.ab(b.class)).a(ak.getContext(), this.kkm, (HashMap)localObject);
      this.success = p.i(((HashMap)localObject).get("success"), Boolean.TRUE);
      localObject = ((HashMap)localObject).get("desc");
      if (localObject != null)
      {
        if (localObject == null)
        {
          localObject = new v("null cannot be cast to non-null type kotlin.String");
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
        biG();
        AppMethodBeat.o(175156);
        return;
      }
    }
    
    public final void aOY()
    {
      c localc = null;
      Object localObject1 = null;
      AppMethodBeat.i(175157);
      super.aOY();
      bix();
      int i;
      if (this.success)
      {
        ae.i("MicroMsg.JsApiOpenWebViewUseFastLoad", "alvinluo openWebViewUseFastLoad success");
        localc = this.kws;
        if (localc != null)
        {
          i = this.kmu;
          localObject2 = this.kGf;
          if (localObject2 != null) {
            localObject1 = ((m)localObject2).PO("ok");
          }
          localc.h(i, (String)localObject1);
          AppMethodBeat.o(175157);
          return;
        }
        AppMethodBeat.o(175157);
        return;
      }
      ae.e("MicroMsg.JsApiOpenWebViewUseFastLoad", "alvinluo openWebViewUseFastLoad failed %s", new Object[] { this.errMsg });
      Object localObject2 = this.kws;
      if (localObject2 != null)
      {
        i = this.kmu;
        m localm = this.kGf;
        localObject1 = localc;
        if (localm != null) {
          localObject1 = localm.PO("failed: " + this.errMsg);
        }
        ((c)localObject2).h(i, (String)localObject1);
        AppMethodBeat.o(175157);
        return;
      }
      AppMethodBeat.o(175157);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void e(Parcel paramParcel)
    {
      AppMethodBeat.i(175158);
      super.e(paramParcel);
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
      this.kkm = new JSONObject(str1);
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
      p.h(paramParcel, "parcel");
      super.writeToParcel(paramParcel, paramInt);
      Object localObject = this.kkm;
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
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/bizvideochannel/JsApiOpenWebViewUseFastLoad$OpenWebViewUseFastLoad$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/bizvideochannel/JsApiOpenWebViewUseFastLoad$OpenWebViewUseFastLoad;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/bizvideochannel/JsApiOpenWebViewUseFastLoad$OpenWebViewUseFastLoad;", "plugin-appbrand-integration_release"})
    public static final class a
      implements Parcelable.Creator<JsApiOpenWebViewUseFastLoad.OpenWebViewUseFastLoad>
    {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/bizvideochannel/JsApiOpenWebViewUseFastLoad$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bizvideochannel.JsApiOpenWebViewUseFastLoad
 * JD-Core Version:    0.7.0.1
 */