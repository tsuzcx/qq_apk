package com.tencent.mm.plugin.appbrand.jsapi.bizvideochannel;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.az;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.plugin.brandservice.a.c.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/bizvideochannel/JsApiHandleMpChannelAction;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "operateType", "", "callback", "", "env", "callbackId", "", "resultJson", "getChannelFeeds", "invoke", "data", "Lorg/json/JSONObject;", "updateChannelFeeds", "Companion", "GetChannelFeedsTask", "UpdateChannelFeedsTask", "plugin-appbrand-integration_release"})
public final class JsApiHandleMpChannelAction
  extends com.tencent.mm.plugin.appbrand.jsapi.c<e>
{
  private static final int CTRL_INDEX = 766;
  private static final String NAME = "handleMPChannelAction";
  public static final a oGR;
  private String oGQ = "";
  
  static
  {
    AppMethodBeat.i(175154);
    oGR = new a((byte)0);
    NAME = "handleMPChannelAction";
    CTRL_INDEX = 766;
    AppMethodBeat.o(175154);
  }
  
  private static void a(e parame, int paramInt, String paramString)
  {
    AppMethodBeat.i(175153);
    if (parame != null)
    {
      parame.j(paramInt, paramString);
      AppMethodBeat.o(175153);
      return;
    }
    AppMethodBeat.o(175153);
  }
  
  public final void a(e parame, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(175152);
    if (paramJSONObject != null)
    {
      String str = paramJSONObject.optString("operateType");
      paramJSONObject = str;
      if (str != null) {}
    }
    else
    {
      paramJSONObject = "";
    }
    this.oGQ = paramJSONObject;
    Log.i("MicroMsg.JsApiHandleMpChannelAction", "alvinluo handleMPChannelAction operateType: %s", new Object[] { this.oGQ });
    if (((CharSequence)this.oGQ).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.e("MicroMsg.JsApiHandleMpChannelAction", "alvinluo handleMPChannelAction operateType empty");
      paramJSONObject = agS("fail: operationType empty");
      p.j(paramJSONObject, "makeReturnJson(\"fail: operationType empty\")");
      a(parame, paramInt, paramJSONObject);
      AppMethodBeat.o(175152);
      return;
    }
    if (this.oGQ.equals("getChannelFeeds"))
    {
      Log.i("MicroMsg.JsApiHandleMpChannelAction", "alvinluo getChannelFeeds");
      new GetChannelFeedsTask((o)this, parame, paramInt).bsM();
      AppMethodBeat.o(175152);
      return;
    }
    if (this.oGQ.equals("updateChannelFeeds"))
    {
      Log.i("MicroMsg.JsApiHandleMpChannelAction", "alvinluo updateChannelFeeds");
      new UpdateChannelFeedsTask(parame).bsM();
      paramJSONObject = agS("ok");
      p.j(paramJSONObject, "makeReturnJson(\"ok\")");
      a(parame, paramInt, paramJSONObject);
      AppMethodBeat.o(175152);
      return;
    }
    Log.e("MicroMsg.JsApiHandleMpChannelAction", "alvinluo handleMPChannelAction operateType invalid");
    paramJSONObject = agS("fail: operationType error");
    p.j(paramJSONObject, "makeReturnJson(\"fail: operationType error\")");
    a(parame, paramInt, paramJSONObject);
    AppMethodBeat.o(175152);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/bizvideochannel/JsApiHandleMpChannelAction$GetChannelFeedsTask;", "Lcom/tencent/mm/plugin/appbrand/ipc/MainProcessTask;", "()V", "api", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;", "service", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "callbackId", "", "(Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;I)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "channelFeedsData", "", "jsapi", "describeContents", "parseFromParcel", "", "src", "runInClientProcess", "runInMainProcess", "writeToParcel", "flags", "CREATOR", "plugin-appbrand-integration_release"})
  static final class GetChannelFeedsTask
    extends MainProcessTask
  {
    public static final a CREATOR;
    private String oGS = "";
    private o oGT;
    private int okO;
    private e ovO;
    
    static
    {
      AppMethodBeat.i(175141);
      CREATOR = new a((byte)0);
      AppMethodBeat.o(175141);
    }
    
    public GetChannelFeedsTask() {}
    
    public GetChannelFeedsTask(Parcel paramParcel)
    {
      this();
      AppMethodBeat.i(175140);
      f(paramParcel);
      AppMethodBeat.o(175140);
    }
    
    public GetChannelFeedsTask(o paramo, e parame, int paramInt)
    {
      this.oGT = paramo;
      this.ovO = parame;
      this.okO = paramInt;
    }
    
    public final void RW()
    {
      AppMethodBeat.i(175136);
      String str = ((com.tencent.mm.plugin.brandservice.a.c)h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).cyI();
      p.j(str, "MMKernel.service(IBrandS…s.java).getChannelFeeds()");
      this.oGS = str;
      Log.i("MicroMsg.JsApiHandleMpChannelAction", "alvinluo GetChannelFeedsTask channelFeedsData: %s", new Object[] { this.oGS });
      bPt();
      AppMethodBeat.o(175136);
    }
    
    public final void bsK()
    {
      Object localObject = null;
      AppMethodBeat.i(175137);
      super.bsK();
      bPk();
      int i;
      if (((CharSequence)this.oGS).length() == 0)
      {
        i = 1;
        if (i == 0) {
          break label103;
        }
        Log.e("MicroMsg.JsApiHandleMpChannelAction", "alvinluo getChannelFeeds error: data empty");
        locale = this.ovO;
        if (locale == null) {
          break label97;
        }
        i = this.okO;
        localObject = this.oGT;
        if (localObject == null) {
          break label92;
        }
      }
      label92:
      for (localObject = ((o)localObject).agS("fail: no channel feeds");; localObject = null)
      {
        locale.j(i, (String)localObject);
        AppMethodBeat.o(175137);
        return;
        i = 0;
        break;
      }
      label97:
      AppMethodBeat.o(175137);
      return;
      label103:
      HashMap localHashMap = new HashMap();
      ((Map)localHashMap).put("errCode", Integer.valueOf(0));
      ((Map)localHashMap).put("channelFeedsData", this.oGS);
      Log.i("MicroMsg.JsApiHandleMpChannelAction", "alvinluo getChannelFeeds success");
      e locale = this.ovO;
      if (locale != null)
      {
        i = this.okO;
        o localo = this.oGT;
        if (localo != null) {
          localObject = localo.m("ok", (Map)localHashMap);
        }
        locale.j(i, (String)localObject);
        AppMethodBeat.o(175137);
        return;
      }
      AppMethodBeat.o(175137);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void f(Parcel paramParcel)
    {
      AppMethodBeat.i(175138);
      super.f(paramParcel);
      if (paramParcel != null)
      {
        String str = paramParcel.readString();
        paramParcel = str;
        if (str != null) {}
      }
      else
      {
        paramParcel = "";
      }
      this.oGS = paramParcel;
      AppMethodBeat.o(175138);
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(175139);
      p.k(paramParcel, "parcel");
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeString(this.oGS);
      AppMethodBeat.o(175139);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/bizvideochannel/JsApiHandleMpChannelAction$GetChannelFeedsTask$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/bizvideochannel/JsApiHandleMpChannelAction$GetChannelFeedsTask;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/bizvideochannel/JsApiHandleMpChannelAction$GetChannelFeedsTask;", "plugin-appbrand-integration_release"})
    public static final class a
      implements Parcelable.Creator<JsApiHandleMpChannelAction.GetChannelFeedsTask>
    {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/bizvideochannel/JsApiHandleMpChannelAction$UpdateChannelFeedsTask;", "Lcom/tencent/mm/plugin/appbrand/ipc/MainProcessTask;", "()V", "service", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "(Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "channelFeedsData", "", "success", "", "describeContents", "", "parseFromParcel", "", "src", "runInClientProcess", "runInMainProcess", "writeToParcel", "flags", "CREATOR", "plugin-appbrand-integration_release"})
  static final class UpdateChannelFeedsTask
    extends MainProcessTask
  {
    public static final a CREATOR;
    private String oGS = "";
    private e ovO;
    private boolean success;
    
    static
    {
      AppMethodBeat.i(175150);
      CREATOR = new a((byte)0);
      AppMethodBeat.o(175150);
    }
    
    public UpdateChannelFeedsTask() {}
    
    public UpdateChannelFeedsTask(Parcel paramParcel)
    {
      this();
      AppMethodBeat.i(175149);
      f(paramParcel);
      AppMethodBeat.o(175149);
    }
    
    public UpdateChannelFeedsTask(e parame)
    {
      this();
      this.ovO = parame;
    }
    
    public final void RW()
    {
      AppMethodBeat.i(175146);
      ((com.tencent.mm.plugin.brandservice.a.c)h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).a((c.b)new b(this));
      AppMethodBeat.o(175146);
    }
    
    public final void bsK()
    {
      AppMethodBeat.i(175147);
      super.bsK();
      bPk();
      Log.i("MicroMsg.JsApiHandleMpChannelAction", "alvinluo updateChannelFeeds end and dispatch onUpdateChannelFeeds, success: %b", new Object[] { Boolean.valueOf(this.success) });
      a locala = new a();
      e locale = this.ovO;
      boolean bool = this.success;
      String str = this.oGS;
      p.k(str, "channelFeedsData");
      Log.i("MicroMsg.JsApiEventOnUpdateChannelFeeds", "alvinluo onUpdateChannelFeeds dispatch success: %b, channelFeedsData: %s", new Object[] { Boolean.valueOf(bool), str });
      HashMap localHashMap = new HashMap();
      int i;
      if (bool) {
        if (((CharSequence)str).length() > 0)
        {
          i = 1;
          if (i == 0) {
            break label196;
          }
          ((Map)localHashMap).put("errCode", Integer.valueOf(0));
          ((Map)localHashMap).put("errMsg", "ok");
          ((Map)localHashMap).put("channelFeedsData", str);
        }
      }
      for (;;)
      {
        locala.j(locale).E((Map)localHashMap).bPO();
        AppMethodBeat.o(175147);
        return;
        i = 0;
        break;
        label196:
        ((Map)localHashMap).put("errMsg", "no channel feeds");
        continue;
        ((Map)localHashMap).put("errMsg", "update channel feeds failed");
      }
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void f(Parcel paramParcel)
    {
      AppMethodBeat.i(175145);
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
      this.oGS = str1;
      if ((paramParcel != null) && (paramParcel.readInt() == 1)) {}
      for (boolean bool = true;; bool = false)
      {
        this.success = bool;
        AppMethodBeat.o(175145);
        return;
      }
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(175148);
      p.k(paramParcel, "parcel");
      paramParcel.writeString(this.oGS);
      if (this.success) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        AppMethodBeat.o(175148);
        return;
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/bizvideochannel/JsApiHandleMpChannelAction$UpdateChannelFeedsTask$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/bizvideochannel/JsApiHandleMpChannelAction$UpdateChannelFeedsTask;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/bizvideochannel/JsApiHandleMpChannelAction$UpdateChannelFeedsTask;", "plugin-appbrand-integration_release"})
    public static final class a
      implements Parcelable.Creator<JsApiHandleMpChannelAction.UpdateChannelFeedsTask>
    {}
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/jsapi/bizvideochannel/JsApiHandleMpChannelAction$UpdateChannelFeedsTask$runInMainProcess$1", "Lcom/tencent/mm/plugin/brandservice/api/IBrandService$UpdateChannelFeedsCallback;", "onFailed", "", "errType", "", "errCode", "errMsg", "", "onSuccess", "channelFeeds", "plugin-appbrand-integration_release"})
    public static final class b
      implements c.b
    {
      public final void onSuccess(String paramString)
      {
        AppMethodBeat.i(175143);
        Log.i("MicroMsg.JsApiHandleMpChannelAction", "alvinluo updateChannelFeeds onSuccess %s", new Object[] { paramString });
        JsApiHandleMpChannelAction.UpdateChannelFeedsTask localUpdateChannelFeedsTask = this.oGU;
        String str = paramString;
        if (paramString == null) {
          str = "";
        }
        JsApiHandleMpChannelAction.UpdateChannelFeedsTask.a(localUpdateChannelFeedsTask, str);
        JsApiHandleMpChannelAction.UpdateChannelFeedsTask.a(this.oGU, true);
        JsApiHandleMpChannelAction.UpdateChannelFeedsTask.a(this.oGU);
        AppMethodBeat.o(175143);
      }
      
      public final void p(int paramInt1, int paramInt2, String paramString)
      {
        AppMethodBeat.i(175144);
        Log.e("MicroMsg.JsApiHandleMpChannelAction", "alvinluo updateChannelFeeds onFailed errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        JsApiHandleMpChannelAction.UpdateChannelFeedsTask.a(this.oGU, false);
        JsApiHandleMpChannelAction.UpdateChannelFeedsTask.a(this.oGU);
        AppMethodBeat.o(175144);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/bizvideochannel/JsApiHandleMpChannelAction$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "OPERATE_TYPE_GET", "OPERATE_TYPE_UPDATE", "TAG", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bizvideochannel.JsApiHandleMpChannelAction
 * JD-Core Version:    0.7.0.1
 */