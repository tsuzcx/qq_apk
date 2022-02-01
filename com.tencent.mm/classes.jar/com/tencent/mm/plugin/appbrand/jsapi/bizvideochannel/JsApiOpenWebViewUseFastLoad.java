package com.tencent.mm.plugin.appbrand.jsapi.bizvideochannel;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/bizvideochannel/JsApiOpenWebViewUseFastLoad;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "callback", "", "env", "callbackId", "", "resultJson", "", "invoke", "data", "Lorg/json/JSONObject;", "Companion", "OpenWebViewUseFastLoad", "plugin-appbrand-integration_release"})
public final class JsApiOpenWebViewUseFastLoad
  extends com.tencent.mm.plugin.appbrand.jsapi.c<e>
{
  private static final int CTRL_INDEX = 764;
  private static final String NAME = "openWebViewUseFastLoad";
  public static final a oGV;
  
  static
  {
    AppMethodBeat.i(175164);
    oGV = new a((byte)0);
    NAME = "openWebViewUseFastLoad";
    CTRL_INDEX = 764;
    AppMethodBeat.o(175164);
  }
  
  private static void a(e parame, int paramInt, String paramString)
  {
    AppMethodBeat.i(175163);
    if (parame != null)
    {
      parame.j(paramInt, paramString);
      AppMethodBeat.o(175163);
      return;
    }
    AppMethodBeat.o(175163);
  }
  
  public final void a(e parame, JSONObject paramJSONObject, int paramInt)
  {
    Object localObject2 = null;
    AppMethodBeat.i(175162);
    if (paramJSONObject != null) {}
    for (Object localObject1 = paramJSONObject.toString();; localObject1 = null)
    {
      Log.d("MicroMsg.JsApiOpenWebViewUseFastLoad", "alvinluo openWebViewUseFastLoad data: %s", new Object[] { localObject1 });
      if (((com.tencent.mm.plugin.brandservice.a.c)h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).Gw(5)) {
        break;
      }
      Log.e("MicroMsg.JsApiOpenWebViewUseFastLoad", "alvinluo openWebViewUseFastLoad abtest closed");
      paramJSONObject = agS("fail: abtest closed");
      p.j(paramJSONObject, "makeReturnJson(\"fail: abtest closed\")");
      a(parame, paramInt, paramJSONObject);
      AppMethodBeat.o(175162);
      return;
    }
    if (paramJSONObject == null)
    {
      paramJSONObject = agS("fail: invalid param");
      p.j(paramJSONObject, "makeReturnJson(\"fail: invalid param\")");
      a(parame, paramInt, paramJSONObject);
      AppMethodBeat.o(175162);
      return;
    }
    if (!paramJSONObject.has("url"))
    {
      paramJSONObject = agS("fail: invalid url");
      p.j(paramJSONObject, "makeReturnJson(\"fail: invalid url\")");
      a(parame, paramInt, paramJSONObject);
      AppMethodBeat.o(175162);
      return;
    }
    if (!paramJSONObject.has("item_show_type"))
    {
      paramJSONObject = agS("fail: invalid item_show_type");
      p.j(paramJSONObject, "makeReturnJson(\"fail: invalid item_show_type\")");
      a(parame, paramInt, paramJSONObject);
      AppMethodBeat.o(175162);
      return;
    }
    if (!paramJSONObject.has("scene"))
    {
      paramJSONObject = agS("fail: invalid scene");
      p.j(paramJSONObject, "makeReturnJson(\"fail: invalid scene\")");
      a(parame, paramInt, paramJSONObject);
      AppMethodBeat.o(175162);
      return;
    }
    if (!paramJSONObject.has("openType"))
    {
      paramJSONObject = agS("fail: invalid openType");
      p.j(paramJSONObject, "makeReturnJson(\"fail: invalid openType\")");
      a(parame, paramInt, paramJSONObject);
      AppMethodBeat.o(175162);
      return;
    }
    HashMap localHashMap = new HashMap();
    com.tencent.mm.plugin.brandservice.a.c localc = (com.tencent.mm.plugin.brandservice.a.c)h.ae(com.tencent.mm.plugin.brandservice.a.c.class);
    localObject1 = localObject2;
    if (parame != null) {
      localObject1 = parame.getContext();
    }
    localc.a((Context)localObject1, paramJSONObject, localHashMap);
    boolean bool = p.h(localHashMap.get("success"), Boolean.TRUE);
    paramJSONObject = localHashMap.get("desc");
    if (paramJSONObject != null)
    {
      if (paramJSONObject == null)
      {
        parame = new t("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(175162);
        throw parame;
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
      paramJSONObject = agS("ok");
      p.j(paramJSONObject, "makeReturnJson(\"ok\")");
      a(parame, paramInt, paramJSONObject);
      AppMethodBeat.o(175162);
      return;
    }
    Log.e("MicroMsg.JsApiOpenWebViewUseFastLoad", "alvinluo openWebViewUseFastLoad failed %s", new Object[] { paramJSONObject });
    paramJSONObject = agS("fail: ".concat(String.valueOf(paramJSONObject)));
    p.j(paramJSONObject, "makeReturnJson(\"fail: $errMsg\")");
    a(parame, paramInt, paramJSONObject);
    AppMethodBeat.o(175162);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/bizvideochannel/JsApiOpenWebViewUseFastLoad$OpenWebViewUseFastLoad;", "Lcom/tencent/mm/plugin/appbrand/ipc/MainProcessTask;", "()V", "api", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;", "service", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "callbackId", "", "data", "Lorg/json/JSONObject;", "(Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;ILorg/json/JSONObject;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "errMsg", "", "jsapi", "success", "", "describeContents", "parseFromParcel", "", "src", "runInClientProcess", "runInMainProcess", "writeToParcel", "flags", "CREATOR", "plugin-appbrand-integration_release"})
  static final class OpenWebViewUseFastLoad
    extends MainProcessTask
  {
    public static final a CREATOR;
    private String errMsg = "";
    private o oGT;
    private JSONObject oiG;
    private int okO;
    private e ovO;
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
    
    public final void RW()
    {
      AppMethodBeat.i(175156);
      if (!((com.tencent.mm.plugin.brandservice.a.c)h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).Gw(5))
      {
        Log.e("MicroMsg.JsApiOpenWebViewUseFastLoad", "alvinluo openWebViewUseFastLoad abtest closed");
        this.success = false;
        this.errMsg = "abtest closed";
        bPt();
        AppMethodBeat.o(175156);
        return;
      }
      Object localObject = new HashMap();
      ((com.tencent.mm.plugin.brandservice.a.c)h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).a(MMApplicationContext.getContext(), this.oiG, (HashMap)localObject);
      this.success = p.h(((HashMap)localObject).get("success"), Boolean.TRUE);
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
        bPt();
        AppMethodBeat.o(175156);
        return;
      }
    }
    
    public final void bsK()
    {
      e locale = null;
      Object localObject1 = null;
      AppMethodBeat.i(175157);
      super.bsK();
      bPk();
      int i;
      if (this.success)
      {
        Log.i("MicroMsg.JsApiOpenWebViewUseFastLoad", "alvinluo openWebViewUseFastLoad success");
        locale = this.ovO;
        if (locale != null)
        {
          i = this.okO;
          localObject2 = this.oGT;
          if (localObject2 != null) {
            localObject1 = ((o)localObject2).agS("ok");
          }
          locale.j(i, (String)localObject1);
          AppMethodBeat.o(175157);
          return;
        }
        AppMethodBeat.o(175157);
        return;
      }
      Log.e("MicroMsg.JsApiOpenWebViewUseFastLoad", "alvinluo openWebViewUseFastLoad failed %s", new Object[] { this.errMsg });
      Object localObject2 = this.ovO;
      if (localObject2 != null)
      {
        i = this.okO;
        o localo = this.oGT;
        localObject1 = locale;
        if (localo != null) {
          localObject1 = localo.agS("failed: " + this.errMsg);
        }
        ((e)localObject2).j(i, (String)localObject1);
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
      p.j(str1, "src?.readString() ?: \"\"");
      this.oiG = new JSONObject(str1);
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
      p.k(paramParcel, "parcel");
      super.writeToParcel(paramParcel, paramInt);
      Object localObject = this.oiG;
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
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/bizvideochannel/JsApiOpenWebViewUseFastLoad$OpenWebViewUseFastLoad$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/bizvideochannel/JsApiOpenWebViewUseFastLoad$OpenWebViewUseFastLoad;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/bizvideochannel/JsApiOpenWebViewUseFastLoad$OpenWebViewUseFastLoad;", "plugin-appbrand-integration_release"})
    public static final class a
      implements Parcelable.Creator<JsApiOpenWebViewUseFastLoad.OpenWebViewUseFastLoad>
    {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/bizvideochannel/JsApiOpenWebViewUseFastLoad$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bizvideochannel.JsApiOpenWebViewUseFastLoad
 * JD-Core Version:    0.7.0.1
 */