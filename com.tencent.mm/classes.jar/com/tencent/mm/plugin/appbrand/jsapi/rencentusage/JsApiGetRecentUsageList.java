package com.tencent.mm.plugin.appbrand.jsapi.rencentusage;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.c.a;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.appbrand.appusage.j.a;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiGetRecentUsageList;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "plugin-appbrand-integration_release"})
public final class JsApiGetRecentUsageList
  extends com.tencent.mm.plugin.appbrand.jsapi.c<e>
{
  public static final int CTRL_INDEX = 853;
  public static final String NAME = "getRecentUsageList";
  public static final Companion pmB;
  
  static
  {
    AppMethodBeat.i(280300);
    pmB = new Companion((byte)0);
    AppMethodBeat.o(280300);
  }
  
  public final void a(e parame, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(280299);
    if (parame == null)
    {
      AppMethodBeat.o(280299);
      return;
    }
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(280299);
      return;
    }
    Log.i("MicroMsg.JsApiGetRecentUsageList", "data=".concat(String.valueOf(paramJSONObject)));
    int i = paramJSONObject.optInt("count", 2147483647);
    if (i < 0)
    {
      parame.j(paramInt, agS("fail:illegal count"));
      AppMethodBeat.o(280299);
      return;
    }
    final int j = paramJSONObject.optInt("requestId", 2147483647);
    if (j == 2147483647)
    {
      parame.j(paramInt, agS("fail:illegal requestId"));
      AppMethodBeat.o(280299);
      return;
    }
    long l = paramJSONObject.optLong("lastUpdateTime", 9223372036854775807L);
    if (l < 0L)
    {
      parame.j(paramInt, agS("fail:illegal lastUpdateTime"));
      AppMethodBeat.o(280299);
      return;
    }
    parame.j(paramInt, agS("ok"));
    j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)new JsApiGetRecentUsageList.Companion.Parameter(i, l, j), JsApiGetRecentUsageList.Companion.a.class, (f)new a(parame, j));
    AppMethodBeat.o(280299);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiGetRecentUsageList$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "UPDATE_TIME_FOR_FIRST_PAGE", "", "Parameter", "Result", "Task", "plugin-appbrand-integration_release"})
  public static final class Companion
  {
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiGetRecentUsageList$Companion$Parameter;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "count", "", "lastUpdateTime", "", "requestId", "(IJI)V", "getCount", "()I", "getLastUpdateTime", "()J", "getRequestId", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "flags", "CREATOR", "plugin-appbrand-integration_release"})
    public static final class Parameter
      implements Parcelable
    {
      public static final a CREATOR;
      final int count;
      final long lastUpdateTime;
      final int requestId;
      
      static
      {
        AppMethodBeat.i(278528);
        CREATOR = new a((byte)0);
        AppMethodBeat.o(278528);
      }
      
      public Parameter(int paramInt1, long paramLong, int paramInt2)
      {
        this.count = paramInt1;
        this.lastUpdateTime = paramLong;
        this.requestId = paramInt2;
      }
      
      public Parameter(Parcel paramParcel)
      {
        this(paramParcel.readInt(), paramParcel.readLong(), paramParcel.readInt());
        AppMethodBeat.i(278526);
        AppMethodBeat.o(278526);
      }
      
      public final int describeContents()
      {
        return 0;
      }
      
      public final boolean equals(Object paramObject)
      {
        if (this != paramObject)
        {
          if ((paramObject instanceof Parameter))
          {
            paramObject = (Parameter)paramObject;
            if ((this.count != paramObject.count) || (this.lastUpdateTime != paramObject.lastUpdateTime) || (this.requestId != paramObject.requestId)) {}
          }
        }
        else {
          return true;
        }
        return false;
      }
      
      public final int hashCode()
      {
        int i = this.count;
        long l = this.lastUpdateTime;
        return (i * 31 + (int)(l ^ l >>> 32)) * 31 + this.requestId;
      }
      
      public final String toString()
      {
        AppMethodBeat.i(278530);
        String str = "Parameter(count=" + this.count + ", lastUpdateTime=" + this.lastUpdateTime + ", requestId=" + this.requestId + ")";
        AppMethodBeat.o(278530);
        return str;
      }
      
      public final void writeToParcel(Parcel paramParcel, int paramInt)
      {
        AppMethodBeat.i(278523);
        p.k(paramParcel, "parcel");
        paramParcel.writeInt(this.count);
        paramParcel.writeLong(this.lastUpdateTime);
        paramParcel.writeInt(this.requestId);
        AppMethodBeat.o(278523);
      }
      
      @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiGetRecentUsageList$Companion$Parameter$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiGetRecentUsageList$Companion$Parameter;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiGetRecentUsageList$Companion$Parameter;", "plugin-appbrand-integration_release"})
      public static final class a
        implements Parcelable.Creator<JsApiGetRecentUsageList.Companion.Parameter>
      {}
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiGetRecentUsageList$Companion$Result;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "data", "", "errorCode", "", "errorMsg", "(Ljava/lang/String;ILjava/lang/String;)V", "getData", "()Ljava/lang/String;", "getErrorCode", "()I", "getErrorMsg", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "flags", "Companion", "plugin-appbrand-integration_release"})
    public static final class Result
      implements Parcelable
    {
      public static final Parcelable.Creator<Result> CREATOR;
      public static final a pmC;
      final String data;
      final int errorCode;
      final String errorMsg;
      
      static
      {
        AppMethodBeat.i(242784);
        pmC = new a((byte)0);
        CREATOR = (Parcelable.Creator)new b();
        AppMethodBeat.o(242784);
      }
      
      public Result(Parcel paramParcel)
      {
        this(str, i, paramParcel);
        AppMethodBeat.i(242783);
        AppMethodBeat.o(242783);
      }
      
      public Result(String paramString1, int paramInt, String paramString2)
      {
        AppMethodBeat.i(242781);
        this.data = paramString1;
        this.errorCode = paramInt;
        this.errorMsg = paramString2;
        AppMethodBeat.o(242781);
      }
      
      public final int describeContents()
      {
        return 0;
      }
      
      public final boolean equals(Object paramObject)
      {
        AppMethodBeat.i(242788);
        if (this != paramObject)
        {
          if ((paramObject instanceof Result))
          {
            paramObject = (Result)paramObject;
            if ((!p.h(this.data, paramObject.data)) || (this.errorCode != paramObject.errorCode) || (!p.h(this.errorMsg, paramObject.errorMsg))) {}
          }
        }
        else
        {
          AppMethodBeat.o(242788);
          return true;
        }
        AppMethodBeat.o(242788);
        return false;
      }
      
      public final int hashCode()
      {
        int j = 0;
        AppMethodBeat.i(242786);
        String str = this.data;
        if (str != null) {}
        for (int i = str.hashCode();; i = 0)
        {
          int k = this.errorCode;
          str = this.errorMsg;
          if (str != null) {
            j = str.hashCode();
          }
          AppMethodBeat.o(242786);
          return (i * 31 + k) * 31 + j;
        }
      }
      
      public final String toString()
      {
        AppMethodBeat.i(242785);
        String str = "Result(data=" + this.data + ", errorCode=" + this.errorCode + ", errorMsg=" + this.errorMsg + ")";
        AppMethodBeat.o(242785);
        return str;
      }
      
      public final void writeToParcel(Parcel paramParcel, int paramInt)
      {
        AppMethodBeat.i(242780);
        p.k(paramParcel, "parcel");
        paramParcel.writeString(this.data);
        paramParcel.writeInt(this.errorCode);
        paramParcel.writeString(this.errorMsg);
        AppMethodBeat.o(242780);
      }
      
      @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiGetRecentUsageList$Companion$Result$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiGetRecentUsageList$Companion$Result;", "ERR_CODE_CGI_FAILED", "", "ERR_CODE_SUCCESS", "plugin-appbrand-integration_release"})
      public static final class a {}
      
      @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiGetRecentUsageList$Companion$Result$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiGetRecentUsageList$Companion$Result;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiGetRecentUsageList$Companion$Result;", "plugin-appbrand-integration_release"})
      public static final class b
        implements Parcelable.Creator<JsApiGetRecentUsageList.Companion.Result>
      {}
    }
    
    @a
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiGetRecentUsageList$Companion$Task;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeCallbackOnceTask;", "Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiGetRecentUsageList$Companion$Parameter;", "Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiGetRecentUsageList$Companion$Result;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "toJsonObject", "Lorg/json/JSONObject;", "Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandRecentTaskInfo;", "plugin-appbrand-integration_release"})
    public static final class a
      implements com.tencent.mm.ipcinvoker.c<JsApiGetRecentUsageList.Companion.Parameter, JsApiGetRecentUsageList.Companion.Result>
    {
      @l(iBK={1, 1, 16}, iBL={""}, iBM={"<no name provided>", "", "lastUpdateTime", "", "invoke"})
      static final class a
        extends q
        implements b<Long, x>
      {
        a(JsApiGetRecentUsageList.Companion.a parama, JsApiGetRecentUsageList.Companion.Parameter paramParameter, f paramf)
        {
          super();
        }
      }
      
      @l(iBK={1, 1, 16}, iBL={""}, iBM={"<no name provided>", "", "firstPage", "", "lastUpdateTime", "", "invoke"})
      static final class b
        extends q
        implements m<Boolean, Long, x>
      {
        b(JsApiGetRecentUsageList.Companion.Parameter paramParameter, b paramb, f paramf)
        {
          super();
        }
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "ret", "Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiGetRecentUsageList$Companion$Result;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class a<T>
    implements f<ResultType>
  {
    a(e parame, int paramInt) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.rencentusage.JsApiGetRecentUsageList
 * JD-Core Version:    0.7.0.1
 */