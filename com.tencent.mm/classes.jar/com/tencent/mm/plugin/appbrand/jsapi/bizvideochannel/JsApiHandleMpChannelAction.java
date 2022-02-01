package com.tencent.mm.plugin.appbrand.jsapi.bizvideochannel;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.brandservice.a.b;
import com.tencent.mm.plugin.brandservice.a.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import kotlin.l;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/bizvideochannel/JsApiHandleMpChannelAction;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "operateType", "", "callback", "", "env", "callbackId", "", "resultJson", "getChannelFeeds", "invoke", "data", "Lorg/json/JSONObject;", "updateChannelFeeds", "Companion", "GetChannelFeedsTask", "UpdateChannelFeedsTask", "plugin-appbrand-integration_release"})
public final class JsApiHandleMpChannelAction
  extends d<f>
{
  private static final int CTRL_INDEX = 766;
  private static final String NAME = "handleMPChannelAction";
  public static final a lKE;
  private String lKD = "";
  
  static
  {
    AppMethodBeat.i(175154);
    lKE = new a((byte)0);
    NAME = "handleMPChannelAction";
    CTRL_INDEX = 766;
    AppMethodBeat.o(175154);
  }
  
  private static void a(f paramf, int paramInt, String paramString)
  {
    AppMethodBeat.i(175153);
    if (paramf != null)
    {
      paramf.i(paramInt, paramString);
      AppMethodBeat.o(175153);
      return;
    }
    AppMethodBeat.o(175153);
  }
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
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
    this.lKD = paramJSONObject;
    Log.i("MicroMsg.JsApiHandleMpChannelAction", "alvinluo handleMPChannelAction operateType: %s", new Object[] { this.lKD });
    if (((CharSequence)this.lKD).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.e("MicroMsg.JsApiHandleMpChannelAction", "alvinluo handleMPChannelAction operateType empty");
      paramJSONObject = Zf("fail: operationType empty");
      kotlin.g.b.p.g(paramJSONObject, "makeReturnJson(\"fail: operationType empty\")");
      a(paramf, paramInt, paramJSONObject);
      AppMethodBeat.o(175152);
      return;
    }
    if (this.lKD.equals("getChannelFeeds"))
    {
      Log.i("MicroMsg.JsApiHandleMpChannelAction", "alvinluo getChannelFeeds");
      paramf = new GetChannelFeedsTask((com.tencent.mm.plugin.appbrand.jsapi.p)this, paramf, paramInt);
      paramf.bDJ();
      paramf.bjm();
      AppMethodBeat.o(175152);
      return;
    }
    if (this.lKD.equals("updateChannelFeeds"))
    {
      Log.i("MicroMsg.JsApiHandleMpChannelAction", "alvinluo updateChannelFeeds");
      paramJSONObject = new UpdateChannelFeedsTask(paramf);
      paramJSONObject.bDJ();
      paramJSONObject.bjm();
      paramJSONObject = Zf("ok");
      kotlin.g.b.p.g(paramJSONObject, "makeReturnJson(\"ok\")");
      a(paramf, paramInt, paramJSONObject);
      AppMethodBeat.o(175152);
      return;
    }
    Log.e("MicroMsg.JsApiHandleMpChannelAction", "alvinluo handleMPChannelAction operateType invalid");
    paramJSONObject = Zf("fail: operationType error");
    kotlin.g.b.p.g(paramJSONObject, "makeReturnJson(\"fail: operationType error\")");
    a(paramf, paramInt, paramJSONObject);
    AppMethodBeat.o(175152);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/bizvideochannel/JsApiHandleMpChannelAction$GetChannelFeedsTask;", "Lcom/tencent/mm/plugin/appbrand/ipc/MainProcessTask;", "()V", "api", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;", "service", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "callbackId", "", "(Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;I)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "channelFeedsData", "", "jsapi", "describeContents", "parseFromParcel", "", "src", "runInClientProcess", "runInMainProcess", "writeToParcel", "flags", "CREATOR", "plugin-appbrand-integration_release"})
  static final class GetChannelFeedsTask
    extends MainProcessTask
  {
    public static final a CREATOR;
    private f lAx;
    private String lKF = "";
    private com.tencent.mm.plugin.appbrand.jsapi.p lKG;
    private int lqe;
    
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
    
    public GetChannelFeedsTask(com.tencent.mm.plugin.appbrand.jsapi.p paramp, f paramf, int paramInt)
    {
      this.lKG = paramp;
      this.lAx = paramf;
      this.lqe = paramInt;
    }
    
    public final void bjj()
    {
      AppMethodBeat.i(175136);
      String str = ((b)g.af(b.class)).cli();
      kotlin.g.b.p.g(str, "MMKernel.service(IBrandS…s.java).getChannelFeeds()");
      this.lKF = str;
      Log.i("MicroMsg.JsApiHandleMpChannelAction", "alvinluo GetChannelFeedsTask channelFeedsData: %s", new Object[] { this.lKF });
      bDU();
      AppMethodBeat.o(175136);
    }
    
    public final void bjk()
    {
      Object localObject = null;
      AppMethodBeat.i(175137);
      super.bjk();
      bDK();
      int i;
      if (((CharSequence)this.lKF).length() == 0)
      {
        i = 1;
        if (i == 0) {
          break label103;
        }
        Log.e("MicroMsg.JsApiHandleMpChannelAction", "alvinluo getChannelFeeds error: data empty");
        localf = this.lAx;
        if (localf == null) {
          break label97;
        }
        i = this.lqe;
        localObject = this.lKG;
        if (localObject == null) {
          break label92;
        }
      }
      label92:
      for (localObject = ((com.tencent.mm.plugin.appbrand.jsapi.p)localObject).Zf("fail: no channel feeds");; localObject = null)
      {
        localf.i(i, (String)localObject);
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
      ((Map)localHashMap).put("channelFeedsData", this.lKF);
      Log.i("MicroMsg.JsApiHandleMpChannelAction", "alvinluo getChannelFeeds success");
      f localf = this.lAx;
      if (localf != null)
      {
        i = this.lqe;
        com.tencent.mm.plugin.appbrand.jsapi.p localp = this.lKG;
        if (localp != null) {
          localObject = localp.n("ok", (Map)localHashMap);
        }
        localf.i(i, (String)localObject);
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
      this.lKF = paramParcel;
      AppMethodBeat.o(175138);
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(175139);
      kotlin.g.b.p.h(paramParcel, "parcel");
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeString(this.lKF);
      AppMethodBeat.o(175139);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/bizvideochannel/JsApiHandleMpChannelAction$GetChannelFeedsTask$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/bizvideochannel/JsApiHandleMpChannelAction$GetChannelFeedsTask;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/bizvideochannel/JsApiHandleMpChannelAction$GetChannelFeedsTask;", "plugin-appbrand-integration_release"})
    public static final class a
      implements Parcelable.Creator<JsApiHandleMpChannelAction.GetChannelFeedsTask>
    {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/bizvideochannel/JsApiHandleMpChannelAction$UpdateChannelFeedsTask;", "Lcom/tencent/mm/plugin/appbrand/ipc/MainProcessTask;", "()V", "service", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "(Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "channelFeedsData", "", "success", "", "describeContents", "", "parseFromParcel", "", "src", "runInClientProcess", "runInMainProcess", "writeToParcel", "flags", "CREATOR", "plugin-appbrand-integration_release"})
  static final class UpdateChannelFeedsTask
    extends MainProcessTask
  {
    public static final a CREATOR;
    private f lAx;
    private String lKF = "";
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
    
    public UpdateChannelFeedsTask(f paramf)
    {
      this();
      this.lAx = paramf;
    }
    
    public final void bjj()
    {
      AppMethodBeat.i(175146);
      ((b)g.af(b.class)).a((b.b)new b(this));
      AppMethodBeat.o(175146);
    }
    
    public final void bjk()
    {
      AppMethodBeat.i(175147);
      super.bjk();
      bDK();
      Log.i("MicroMsg.JsApiHandleMpChannelAction", "alvinluo updateChannelFeeds end and dispatch onUpdateChannelFeeds, success: %b", new Object[] { Boolean.valueOf(this.success) });
      a locala = new a();
      f localf = this.lAx;
      boolean bool = this.success;
      String str = this.lKF;
      kotlin.g.b.p.h(str, "channelFeedsData");
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
        locala.h(localf).L((Map)localHashMap).bEo();
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
      this.lKF = str1;
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
      kotlin.g.b.p.h(paramParcel, "parcel");
      paramParcel.writeString(this.lKF);
      if (this.success) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        AppMethodBeat.o(175148);
        return;
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/bizvideochannel/JsApiHandleMpChannelAction$UpdateChannelFeedsTask$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/bizvideochannel/JsApiHandleMpChannelAction$UpdateChannelFeedsTask;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/bizvideochannel/JsApiHandleMpChannelAction$UpdateChannelFeedsTask;", "plugin-appbrand-integration_release"})
    public static final class a
      implements Parcelable.Creator<JsApiHandleMpChannelAction.UpdateChannelFeedsTask>
    {}
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/jsapi/bizvideochannel/JsApiHandleMpChannelAction$UpdateChannelFeedsTask$runInMainProcess$1", "Lcom/tencent/mm/plugin/brandservice/api/IBrandService$UpdateChannelFeedsCallback;", "onFailed", "", "errType", "", "errCode", "errMsg", "", "onSuccess", "channelFeeds", "plugin-appbrand-integration_release"})
    public static final class b
      implements b.b
    {
      public final void onSuccess(String paramString)
      {
        AppMethodBeat.i(175143);
        Log.i("MicroMsg.JsApiHandleMpChannelAction", "alvinluo updateChannelFeeds onSuccess %s", new Object[] { paramString });
        JsApiHandleMpChannelAction.UpdateChannelFeedsTask localUpdateChannelFeedsTask = this.lKH;
        String str = paramString;
        if (paramString == null) {
          str = "";
        }
        JsApiHandleMpChannelAction.UpdateChannelFeedsTask.a(localUpdateChannelFeedsTask, str);
        JsApiHandleMpChannelAction.UpdateChannelFeedsTask.a(this.lKH, true);
        JsApiHandleMpChannelAction.UpdateChannelFeedsTask.a(this.lKH);
        AppMethodBeat.o(175143);
      }
      
      public final void p(int paramInt1, int paramInt2, String paramString)
      {
        AppMethodBeat.i(175144);
        Log.e("MicroMsg.JsApiHandleMpChannelAction", "alvinluo updateChannelFeeds onFailed errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        JsApiHandleMpChannelAction.UpdateChannelFeedsTask.a(this.lKH, false);
        JsApiHandleMpChannelAction.UpdateChannelFeedsTask.a(this.lKH);
        AppMethodBeat.o(175144);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/bizvideochannel/JsApiHandleMpChannelAction$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "OPERATE_TYPE_GET", "OPERATE_TYPE_UPDATE", "TAG", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bizvideochannel.JsApiHandleMpChannelAction
 * JD-Core Version:    0.7.0.1
 */