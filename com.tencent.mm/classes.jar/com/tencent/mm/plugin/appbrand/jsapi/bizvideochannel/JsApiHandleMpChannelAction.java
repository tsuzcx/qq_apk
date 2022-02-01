package com.tencent.mm.plugin.appbrand.jsapi.bizvideochannel;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.brandservice.api.c.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/bizvideochannel/JsApiHandleMpChannelAction;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "operateType", "", "callback", "", "env", "callbackId", "", "resultJson", "getChannelFeeds", "invoke", "data", "Lorg/json/JSONObject;", "updateChannelFeeds", "Companion", "GetChannelFeedsTask", "UpdateChannelFeedsTask", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class JsApiHandleMpChannelAction
  extends com.tencent.mm.plugin.appbrand.jsapi.c<f>
{
  private static final int CTRL_INDEX;
  private static final String NAME;
  public static final a rJP;
  private String rJQ = "";
  
  static
  {
    AppMethodBeat.i(175154);
    rJP = new a((byte)0);
    NAME = "handleMPChannelAction";
    CTRL_INDEX = 766;
    AppMethodBeat.o(175154);
  }
  
  private static void a(f paramf, int paramInt, String paramString)
  {
    AppMethodBeat.i(175153);
    if (paramf != null) {
      paramf.callback(paramInt, paramString);
    }
    AppMethodBeat.o(175153);
  }
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(175152);
    if (paramJSONObject == null)
    {
      paramJSONObject = "";
      this.rJQ = paramJSONObject;
      Log.i("MicroMsg.JsApiHandleMpChannelAction", "alvinluo handleMPChannelAction operateType: %s", new Object[] { this.rJQ });
      if (((CharSequence)this.rJQ).length() != 0) {
        break label112;
      }
    }
    label112:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label118;
      }
      Log.e("MicroMsg.JsApiHandleMpChannelAction", "alvinluo handleMPChannelAction operateType empty");
      paramJSONObject = ZP("fail: operationType empty");
      s.s(paramJSONObject, "makeReturnJson(\"fail: operationType empty\")");
      a(paramf, paramInt, paramJSONObject);
      AppMethodBeat.o(175152);
      return;
      String str = paramJSONObject.optString("operateType");
      paramJSONObject = str;
      if (str != null) {
        break;
      }
      paramJSONObject = "";
      break;
    }
    label118:
    if (this.rJQ.equals("getChannelFeeds"))
    {
      Log.i("MicroMsg.JsApiHandleMpChannelAction", "alvinluo getChannelFeeds");
      new GetChannelFeedsTask((p)this, paramf, paramInt).bQt();
      AppMethodBeat.o(175152);
      return;
    }
    if (this.rJQ.equals("updateChannelFeeds"))
    {
      Log.i("MicroMsg.JsApiHandleMpChannelAction", "alvinluo updateChannelFeeds");
      new UpdateChannelFeedsTask(paramf).bQt();
      paramJSONObject = ZP("ok");
      s.s(paramJSONObject, "makeReturnJson(\"ok\")");
      a(paramf, paramInt, paramJSONObject);
      AppMethodBeat.o(175152);
      return;
    }
    Log.e("MicroMsg.JsApiHandleMpChannelAction", "alvinluo handleMPChannelAction operateType invalid");
    paramJSONObject = ZP("fail: operationType error");
    s.s(paramJSONObject, "makeReturnJson(\"fail: operationType error\")");
    a(paramf, paramInt, paramJSONObject);
    AppMethodBeat.o(175152);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/bizvideochannel/JsApiHandleMpChannelAction$GetChannelFeedsTask;", "Lcom/tencent/mm/plugin/appbrand/ipc/MainProcessTask;", "()V", "api", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;", "service", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "callbackId", "", "(Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;I)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "channelFeedsData", "", "jsapi", "describeContents", "parseFromParcel", "", "src", "runInClientProcess", "runInMainProcess", "writeToParcel", "flags", "CREATOR", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class GetChannelFeedsTask
    extends MainProcessTask
  {
    public static final a CREATOR;
    private String rJR = "";
    private p rJS;
    private int ror;
    private f rzi;
    
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
      h(paramParcel);
      AppMethodBeat.o(175140);
    }
    
    public GetChannelFeedsTask(p paramp, f paramf, int paramInt)
    {
      this.rJS = paramp;
      this.rzi = paramf;
      this.ror = paramInt;
    }
    
    public final void asn()
    {
      AppMethodBeat.i(175136);
      String str = ((com.tencent.mm.plugin.brandservice.api.c)h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).dbF();
      s.s(str, "service(IBrandService::c…s.java).getChannelFeeds()");
      this.rJR = str;
      Log.i("MicroMsg.JsApiHandleMpChannelAction", "alvinluo GetChannelFeedsTask channelFeedsData: %s", new Object[] { this.rJR });
      cpA();
      AppMethodBeat.o(175136);
    }
    
    public final void bQr()
    {
      Object localObject = null;
      AppMethodBeat.i(175137);
      super.bQr();
      cpx();
      int i;
      if (((CharSequence)this.rJR).length() == 0)
      {
        i = 1;
        if (i == 0) {
          break label97;
        }
        Log.e("MicroMsg.JsApiHandleMpChannelAction", "alvinluo getChannelFeeds error: data empty");
        localf = this.rzi;
        if (localf == null) {
          break label180;
        }
        i = this.ror;
        localObject = this.rJS;
        if (localObject != null) {
          break label87;
        }
      }
      label87:
      for (localObject = null;; localObject = ((p)localObject).ZP("fail: no channel feeds"))
      {
        localf.callback(i, (String)localObject);
        AppMethodBeat.o(175137);
        return;
        i = 0;
        break;
      }
      label97:
      HashMap localHashMap = new HashMap();
      ((Map)localHashMap).put("errCode", Integer.valueOf(0));
      ((Map)localHashMap).put("channelFeedsData", this.rJR);
      Log.i("MicroMsg.JsApiHandleMpChannelAction", "alvinluo getChannelFeeds success");
      f localf = this.rzi;
      p localp;
      if (localf != null)
      {
        i = this.ror;
        localp = this.rJS;
        if (localp != null) {
          break label186;
        }
      }
      for (;;)
      {
        localf.callback(i, (String)localObject);
        label180:
        AppMethodBeat.o(175137);
        return;
        label186:
        localObject = localp.m("ok", (Map)localHashMap);
      }
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void h(Parcel paramParcel)
    {
      AppMethodBeat.i(175138);
      super.h(paramParcel);
      if (paramParcel == null) {
        paramParcel = "";
      }
      for (;;)
      {
        this.rJR = paramParcel;
        AppMethodBeat.o(175138);
        return;
        String str = paramParcel.readString();
        paramParcel = str;
        if (str == null) {
          paramParcel = "";
        }
      }
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(175139);
      s.u(paramParcel, "parcel");
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeString(this.rJR);
      AppMethodBeat.o(175139);
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/bizvideochannel/JsApiHandleMpChannelAction$GetChannelFeedsTask$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/bizvideochannel/JsApiHandleMpChannelAction$GetChannelFeedsTask;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/bizvideochannel/JsApiHandleMpChannelAction$GetChannelFeedsTask;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements Parcelable.Creator<JsApiHandleMpChannelAction.GetChannelFeedsTask>
    {}
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/bizvideochannel/JsApiHandleMpChannelAction$UpdateChannelFeedsTask;", "Lcom/tencent/mm/plugin/appbrand/ipc/MainProcessTask;", "()V", "service", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "(Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "channelFeedsData", "", "success", "", "describeContents", "", "parseFromParcel", "", "src", "runInClientProcess", "runInMainProcess", "writeToParcel", "flags", "CREATOR", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class UpdateChannelFeedsTask
    extends MainProcessTask
  {
    public static final a CREATOR;
    private String rJR = "";
    private f rzi;
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
      h(paramParcel);
      AppMethodBeat.o(175149);
    }
    
    public UpdateChannelFeedsTask(f paramf)
    {
      this();
      this.rzi = paramf;
    }
    
    public final void asn()
    {
      AppMethodBeat.i(175146);
      ((com.tencent.mm.plugin.brandservice.api.c)h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).a((c.b)new b(this));
      AppMethodBeat.o(175146);
    }
    
    public final void bQr()
    {
      AppMethodBeat.i(175147);
      super.bQr();
      cpx();
      Log.i("MicroMsg.JsApiHandleMpChannelAction", "alvinluo updateChannelFeeds end and dispatch onUpdateChannelFeeds, success: %b", new Object[] { Boolean.valueOf(this.success) });
      a locala = new a();
      f localf = this.rzi;
      boolean bool = this.success;
      String str = this.rJR;
      s.u(str, "channelFeedsData");
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
        locala.i(localf).L((Map)localHashMap).cpV();
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
    
    public final void h(Parcel paramParcel)
    {
      AppMethodBeat.i(175145);
      super.h(paramParcel);
      Object localObject;
      if (paramParcel == null)
      {
        localObject = "";
        this.rJR = ((String)localObject);
        if ((paramParcel == null) || (paramParcel.readInt() != 1)) {
          break label67;
        }
      }
      label67:
      for (boolean bool = true;; bool = false)
      {
        this.success = bool;
        AppMethodBeat.o(175145);
        return;
        String str = paramParcel.readString();
        localObject = str;
        if (str != null) {
          break;
        }
        localObject = "";
        break;
      }
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(175148);
      s.u(paramParcel, "parcel");
      paramParcel.writeString(this.rJR);
      if (this.success) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        AppMethodBeat.o(175148);
        return;
      }
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/bizvideochannel/JsApiHandleMpChannelAction$UpdateChannelFeedsTask$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/bizvideochannel/JsApiHandleMpChannelAction$UpdateChannelFeedsTask;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/bizvideochannel/JsApiHandleMpChannelAction$UpdateChannelFeedsTask;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements Parcelable.Creator<JsApiHandleMpChannelAction.UpdateChannelFeedsTask>
    {}
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/bizvideochannel/JsApiHandleMpChannelAction$UpdateChannelFeedsTask$runInMainProcess$1", "Lcom/tencent/mm/plugin/brandservice/api/IBrandService$UpdateChannelFeedsCallback;", "onFailed", "", "errType", "", "errCode", "errMsg", "", "onSuccess", "channelFeeds", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class b
      implements c.b
    {
      b(JsApiHandleMpChannelAction.UpdateChannelFeedsTask paramUpdateChannelFeedsTask) {}
      
      public final void onSuccess(String paramString)
      {
        AppMethodBeat.i(175143);
        Log.i("MicroMsg.JsApiHandleMpChannelAction", "alvinluo updateChannelFeeds onSuccess %s", new Object[] { paramString });
        JsApiHandleMpChannelAction.UpdateChannelFeedsTask localUpdateChannelFeedsTask = this.rJT;
        String str = paramString;
        if (paramString == null) {
          str = "";
        }
        JsApiHandleMpChannelAction.UpdateChannelFeedsTask.a(localUpdateChannelFeedsTask, str);
        JsApiHandleMpChannelAction.UpdateChannelFeedsTask.a(this.rJT, true);
        JsApiHandleMpChannelAction.UpdateChannelFeedsTask.a(this.rJT);
        AppMethodBeat.o(175143);
      }
      
      public final void s(int paramInt1, int paramInt2, String paramString)
      {
        AppMethodBeat.i(175144);
        Log.e("MicroMsg.JsApiHandleMpChannelAction", "alvinluo updateChannelFeeds onFailed errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        JsApiHandleMpChannelAction.UpdateChannelFeedsTask.a(this.rJT, false);
        JsApiHandleMpChannelAction.UpdateChannelFeedsTask.a(this.rJT);
        AppMethodBeat.o(175144);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/bizvideochannel/JsApiHandleMpChannelAction$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "OPERATE_TYPE_GET", "OPERATE_TYPE_UPDATE", "TAG", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bizvideochannel.JsApiHandleMpChannelAction
 * JD-Core Version:    0.7.0.1
 */