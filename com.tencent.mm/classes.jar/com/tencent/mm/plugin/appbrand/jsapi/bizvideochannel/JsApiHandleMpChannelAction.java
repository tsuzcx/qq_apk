package com.tencent.mm.plugin.appbrand.jsapi.bizvideochannel;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.ar;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.brandservice.a.b;
import com.tencent.mm.plugin.brandservice.a.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/bizvideochannel/JsApiHandleMpChannelAction;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "operateType", "", "callback", "", "env", "callbackId", "", "resultJson", "getChannelFeeds", "invoke", "data", "Lorg/json/JSONObject;", "updateChannelFeeds", "Companion", "GetChannelFeedsTask", "UpdateChannelFeedsTask", "plugin-appbrand-integration_release"})
public final class JsApiHandleMpChannelAction
  extends com.tencent.mm.plugin.appbrand.jsapi.a<c>
{
  private static final int CTRL_INDEX = 766;
  private static final String NAME = "handleMPChannelAction";
  public static final a khV;
  private String khU = "";
  
  static
  {
    AppMethodBeat.i(175154);
    khV = new a((byte)0);
    NAME = "handleMPChannelAction";
    CTRL_INDEX = 766;
    AppMethodBeat.o(175154);
  }
  
  private static void a(c paramc, int paramInt, String paramString)
  {
    AppMethodBeat.i(175153);
    if (paramc != null)
    {
      paramc.h(paramInt, paramString);
      AppMethodBeat.o(175153);
      return;
    }
    AppMethodBeat.o(175153);
  }
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
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
    this.khU = paramJSONObject;
    ac.i("MicroMsg.JsApiHandleMpChannelAction", "alvinluo handleMPChannelAction operateType: %s", new Object[] { this.khU });
    if (((CharSequence)this.khU).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      ac.e("MicroMsg.JsApiHandleMpChannelAction", "alvinluo handleMPChannelAction operateType empty");
      paramJSONObject = LM("fail: operationType empty");
      k.g(paramJSONObject, "makeReturnJson(\"fail: operationType empty\")");
      a(paramc, paramInt, paramJSONObject);
      AppMethodBeat.o(175152);
      return;
    }
    if (this.khU.equals("getChannelFeeds"))
    {
      ac.i("MicroMsg.JsApiHandleMpChannelAction", "alvinluo getChannelFeeds");
      paramc = new GetChannelFeedsTask((m)this, paramc, paramInt);
      paramc.bej();
      paramc.aLt();
      AppMethodBeat.o(175152);
      return;
    }
    if (this.khU.equals("updateChannelFeeds"))
    {
      ac.i("MicroMsg.JsApiHandleMpChannelAction", "alvinluo updateChannelFeeds");
      paramJSONObject = new UpdateChannelFeedsTask(paramc);
      paramJSONObject.bej();
      paramJSONObject.aLt();
      paramJSONObject = LM("ok");
      k.g(paramJSONObject, "makeReturnJson(\"ok\")");
      a(paramc, paramInt, paramJSONObject);
      AppMethodBeat.o(175152);
      return;
    }
    ac.e("MicroMsg.JsApiHandleMpChannelAction", "alvinluo handleMPChannelAction operateType invalid");
    paramJSONObject = LM("fail: operationType error");
    k.g(paramJSONObject, "makeReturnJson(\"fail: operationType error\")");
    a(paramc, paramInt, paramJSONObject);
    AppMethodBeat.o(175152);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/bizvideochannel/JsApiHandleMpChannelAction$GetChannelFeedsTask;", "Lcom/tencent/mm/plugin/appbrand/ipc/MainProcessTask;", "()V", "api", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;", "service", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "callbackId", "", "(Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;I)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "channelFeedsData", "", "jsapi", "describeContents", "parseFromParcel", "", "src", "runInClientProcess", "runInMainProcess", "writeToParcel", "flags", "CREATOR", "plugin-appbrand-integration_release"})
  static final class GetChannelFeedsTask
    extends MainProcessTask
  {
    public static final a CREATOR;
    private int jOT;
    private c jYG;
    private String khW = "";
    private m khX;
    
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
      e(paramParcel);
      AppMethodBeat.o(175140);
    }
    
    public GetChannelFeedsTask(m paramm, c paramc, int paramInt)
    {
      this.khX = paramm;
      this.jYG = paramc;
      this.jOT = paramInt;
    }
    
    public final void aLq()
    {
      AppMethodBeat.i(175136);
      String str = ((b)g.ab(b.class)).bIT();
      k.g(str, "MMKernel.service(IBrandS…s.java).getChannelFeeds()");
      this.khW = str;
      ac.i("MicroMsg.JsApiHandleMpChannelAction", "alvinluo GetChannelFeedsTask channelFeedsData: %s", new Object[] { this.khW });
      bet();
      AppMethodBeat.o(175136);
    }
    
    public final void aLr()
    {
      Object localObject = null;
      AppMethodBeat.i(175137);
      super.aLr();
      bek();
      int i;
      if (((CharSequence)this.khW).length() == 0)
      {
        i = 1;
        if (i == 0) {
          break label103;
        }
        ac.e("MicroMsg.JsApiHandleMpChannelAction", "alvinluo getChannelFeeds error: data empty");
        localc = this.jYG;
        if (localc == null) {
          break label97;
        }
        i = this.jOT;
        localObject = this.khX;
        if (localObject == null) {
          break label92;
        }
      }
      label92:
      for (localObject = ((m)localObject).LM("fail: no channel feeds");; localObject = null)
      {
        localc.h(i, (String)localObject);
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
      ((Map)localHashMap).put("channelFeedsData", this.khW);
      ac.i("MicroMsg.JsApiHandleMpChannelAction", "alvinluo getChannelFeeds success");
      c localc = this.jYG;
      if (localc != null)
      {
        i = this.jOT;
        m localm = this.khX;
        if (localm != null) {
          localObject = localm.k("ok", (Map)localHashMap);
        }
        localc.h(i, (String)localObject);
        AppMethodBeat.o(175137);
        return;
      }
      AppMethodBeat.o(175137);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void e(Parcel paramParcel)
    {
      AppMethodBeat.i(175138);
      super.e(paramParcel);
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
      this.khW = paramParcel;
      AppMethodBeat.o(175138);
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(175139);
      k.h(paramParcel, "parcel");
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeString(this.khW);
      AppMethodBeat.o(175139);
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/bizvideochannel/JsApiHandleMpChannelAction$GetChannelFeedsTask$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/bizvideochannel/JsApiHandleMpChannelAction$GetChannelFeedsTask;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/bizvideochannel/JsApiHandleMpChannelAction$GetChannelFeedsTask;", "plugin-appbrand-integration_release"})
    public static final class a
      implements Parcelable.Creator<JsApiHandleMpChannelAction.GetChannelFeedsTask>
    {}
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/bizvideochannel/JsApiHandleMpChannelAction$UpdateChannelFeedsTask;", "Lcom/tencent/mm/plugin/appbrand/ipc/MainProcessTask;", "()V", "service", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "(Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "channelFeedsData", "", "success", "", "describeContents", "", "parseFromParcel", "", "src", "runInClientProcess", "runInMainProcess", "writeToParcel", "flags", "CREATOR", "plugin-appbrand-integration_release"})
  static final class UpdateChannelFeedsTask
    extends MainProcessTask
  {
    public static final a CREATOR;
    private c jYG;
    private String khW = "";
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
      e(paramParcel);
      AppMethodBeat.o(175149);
    }
    
    public UpdateChannelFeedsTask(c paramc)
    {
      this();
      this.jYG = paramc;
    }
    
    public final void aLq()
    {
      AppMethodBeat.i(175146);
      ((b)g.ab(b.class)).a((b.b)new b(this));
      AppMethodBeat.o(175146);
    }
    
    public final void aLr()
    {
      AppMethodBeat.i(175147);
      super.aLr();
      bek();
      ac.i("MicroMsg.JsApiHandleMpChannelAction", "alvinluo updateChannelFeeds end and dispatch onUpdateChannelFeeds, success: %b", new Object[] { Boolean.valueOf(this.success) });
      a locala = new a();
      c localc = this.jYG;
      boolean bool = this.success;
      String str = this.khW;
      k.h(str, "channelFeedsData");
      ac.i("MicroMsg.JsApiEventOnUpdateChannelFeeds", "alvinluo onUpdateChannelFeeds dispatch success: %b, channelFeedsData: %s", new Object[] { Boolean.valueOf(bool), str });
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
        locala.h(localc).B((Map)localHashMap).beN();
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
    
    public final void e(Parcel paramParcel)
    {
      AppMethodBeat.i(175145);
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
      this.khW = str1;
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
      k.h(paramParcel, "parcel");
      paramParcel.writeString(this.khW);
      if (this.success) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        AppMethodBeat.o(175148);
        return;
      }
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/bizvideochannel/JsApiHandleMpChannelAction$UpdateChannelFeedsTask$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/bizvideochannel/JsApiHandleMpChannelAction$UpdateChannelFeedsTask;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/bizvideochannel/JsApiHandleMpChannelAction$UpdateChannelFeedsTask;", "plugin-appbrand-integration_release"})
    public static final class a
      implements Parcelable.Creator<JsApiHandleMpChannelAction.UpdateChannelFeedsTask>
    {}
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/appbrand/jsapi/bizvideochannel/JsApiHandleMpChannelAction$UpdateChannelFeedsTask$runInMainProcess$1", "Lcom/tencent/mm/plugin/brandservice/api/IBrandService$UpdateChannelFeedsCallback;", "onFailed", "", "errType", "", "errCode", "errMsg", "", "onSuccess", "channelFeeds", "plugin-appbrand-integration_release"})
    public static final class b
      implements b.b
    {
      public final void onSuccess(String paramString)
      {
        AppMethodBeat.i(175143);
        ac.i("MicroMsg.JsApiHandleMpChannelAction", "alvinluo updateChannelFeeds onSuccess %s", new Object[] { paramString });
        JsApiHandleMpChannelAction.UpdateChannelFeedsTask localUpdateChannelFeedsTask = this.khY;
        String str = paramString;
        if (paramString == null) {
          str = "";
        }
        JsApiHandleMpChannelAction.UpdateChannelFeedsTask.a(localUpdateChannelFeedsTask, str);
        JsApiHandleMpChannelAction.UpdateChannelFeedsTask.a(this.khY, true);
        JsApiHandleMpChannelAction.UpdateChannelFeedsTask.a(this.khY);
        AppMethodBeat.o(175143);
      }
      
      public final void p(int paramInt1, int paramInt2, String paramString)
      {
        AppMethodBeat.i(175144);
        ac.e("MicroMsg.JsApiHandleMpChannelAction", "alvinluo updateChannelFeeds onFailed errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        JsApiHandleMpChannelAction.UpdateChannelFeedsTask.a(this.khY, false);
        JsApiHandleMpChannelAction.UpdateChannelFeedsTask.a(this.khY);
        AppMethodBeat.o(175144);
      }
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/bizvideochannel/JsApiHandleMpChannelAction$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "OPERATE_TYPE_GET", "OPERATE_TYPE_UPDATE", "TAG", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bizvideochannel.JsApiHandleMpChannelAction
 * JD-Core Version:    0.7.0.1
 */