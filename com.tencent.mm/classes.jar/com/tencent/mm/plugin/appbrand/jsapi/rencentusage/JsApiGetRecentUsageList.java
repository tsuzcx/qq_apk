package com.tencent.mm.plugin.appbrand.jsapi.rencentusage;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.plugin.appbrand.appusage.j.a;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.a.m;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;
import org.json.JSONObject;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiGetRecentUsageList;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "plugin-appbrand-integration_release"})
public final class JsApiGetRecentUsageList
  extends a<c>
{
  public static final int CTRL_INDEX = 853;
  public static final String NAME = "getRecentUsageList";
  public static final Companion liQ;
  
  static
  {
    AppMethodBeat.i(223444);
    liQ = new Companion((byte)0);
    AppMethodBeat.o(223444);
  }
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(223443);
    if (paramc == null)
    {
      AppMethodBeat.o(223443);
      return;
    }
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(223443);
      return;
    }
    ae.i("MicroMsg.JsApiGetRecentUsageList", "data=".concat(String.valueOf(paramJSONObject)));
    int i = paramJSONObject.optInt("count", 2147483647);
    if (i < 0)
    {
      paramc.h(paramInt, PO("fail:illegal count"));
      AppMethodBeat.o(223443);
      return;
    }
    final int j = paramJSONObject.optInt("requestId", 2147483647);
    if (j == 2147483647)
    {
      paramc.h(paramInt, PO("fail:illegal requestId"));
      AppMethodBeat.o(223443);
      return;
    }
    long l = paramJSONObject.optLong("lastUpdateTime", 9223372036854775807L);
    if (l < 0L)
    {
      paramc.h(paramInt, PO("fail:illegal lastUpdateTime"));
      AppMethodBeat.o(223443);
      return;
    }
    paramc.h(paramInt, PO("ok"));
    h.a("com.tencent.mm", (Parcelable)new JsApiGetRecentUsageList.Companion.Parameter(i, l, j), JsApiGetRecentUsageList.Companion.a.class, (d)new a(paramc, j));
    AppMethodBeat.o(223443);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiGetRecentUsageList$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "UPDATE_TIME_FOR_FIRST_PAGE", "", "Parameter", "Result", "Task", "plugin-appbrand-integration_release"})
  public static final class Companion
  {
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiGetRecentUsageList$Companion$Parameter;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "count", "", "lastUpdateTime", "", "requestId", "(IJI)V", "getCount", "()I", "getLastUpdateTime", "()J", "getRequestId", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "flags", "CREATOR", "plugin-appbrand-integration_release"})
    public static final class Parameter
      implements Parcelable
    {
      public static final a CREATOR;
      final int count;
      final long lastUpdateTime;
      final int requestId;
      
      static
      {
        AppMethodBeat.i(223426);
        CREATOR = new a((byte)0);
        AppMethodBeat.o(223426);
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
        AppMethodBeat.i(223425);
        AppMethodBeat.o(223425);
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
        AppMethodBeat.i(223427);
        String str = "Parameter(count=" + this.count + ", lastUpdateTime=" + this.lastUpdateTime + ", requestId=" + this.requestId + ")";
        AppMethodBeat.o(223427);
        return str;
      }
      
      public final void writeToParcel(Parcel paramParcel, int paramInt)
      {
        AppMethodBeat.i(223424);
        p.h(paramParcel, "parcel");
        paramParcel.writeInt(this.count);
        paramParcel.writeLong(this.lastUpdateTime);
        paramParcel.writeInt(this.requestId);
        AppMethodBeat.o(223424);
      }
      
      @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiGetRecentUsageList$Companion$Parameter$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiGetRecentUsageList$Companion$Parameter;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiGetRecentUsageList$Companion$Parameter;", "plugin-appbrand-integration_release"})
      public static final class a
        implements Parcelable.Creator<JsApiGetRecentUsageList.Companion.Parameter>
      {}
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiGetRecentUsageList$Companion$Result;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "data", "", "errorCode", "", "errorMsg", "(Ljava/lang/String;ILjava/lang/String;)V", "getData", "()Ljava/lang/String;", "getErrorCode", "()I", "getErrorMsg", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "flags", "Companion", "plugin-appbrand-integration_release"})
    public static final class Result
      implements Parcelable
    {
      public static final Parcelable.Creator<Result> CREATOR;
      public static final a liR;
      final String data;
      final int errorCode;
      final String errorMsg;
      
      static
      {
        AppMethodBeat.i(223433);
        liR = new a((byte)0);
        CREATOR = (Parcelable.Creator)new b();
        AppMethodBeat.o(223433);
      }
      
      public Result(Parcel paramParcel)
      {
        this(str, i, paramParcel);
        AppMethodBeat.i(223432);
        AppMethodBeat.o(223432);
      }
      
      public Result(String paramString1, int paramInt, String paramString2)
      {
        AppMethodBeat.i(223430);
        this.data = paramString1;
        this.errorCode = paramInt;
        this.errorMsg = paramString2;
        AppMethodBeat.o(223430);
      }
      
      public final int describeContents()
      {
        return 0;
      }
      
      public final boolean equals(Object paramObject)
      {
        AppMethodBeat.i(223436);
        if (this != paramObject)
        {
          if ((paramObject instanceof Result))
          {
            paramObject = (Result)paramObject;
            if ((!p.i(this.data, paramObject.data)) || (this.errorCode != paramObject.errorCode) || (!p.i(this.errorMsg, paramObject.errorMsg))) {}
          }
        }
        else
        {
          AppMethodBeat.o(223436);
          return true;
        }
        AppMethodBeat.o(223436);
        return false;
      }
      
      public final int hashCode()
      {
        int j = 0;
        AppMethodBeat.i(223435);
        String str = this.data;
        if (str != null) {}
        for (int i = str.hashCode();; i = 0)
        {
          int k = this.errorCode;
          str = this.errorMsg;
          if (str != null) {
            j = str.hashCode();
          }
          AppMethodBeat.o(223435);
          return (i * 31 + k) * 31 + j;
        }
      }
      
      public final String toString()
      {
        AppMethodBeat.i(223434);
        String str = "Result(data=" + this.data + ", errorCode=" + this.errorCode + ", errorMsg=" + this.errorMsg + ")";
        AppMethodBeat.o(223434);
        return str;
      }
      
      public final void writeToParcel(Parcel paramParcel, int paramInt)
      {
        AppMethodBeat.i(223429);
        p.h(paramParcel, "parcel");
        paramParcel.writeString(this.data);
        paramParcel.writeInt(this.errorCode);
        paramParcel.writeString(this.errorMsg);
        AppMethodBeat.o(223429);
      }
      
      @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiGetRecentUsageList$Companion$Result$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiGetRecentUsageList$Companion$Result;", "ERR_CODE_CGI_FAILED", "", "ERR_CODE_SUCCESS", "plugin-appbrand-integration_release"})
      public static final class a {}
      
      @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiGetRecentUsageList$Companion$Result$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiGetRecentUsageList$Companion$Result;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiGetRecentUsageList$Companion$Result;", "plugin-appbrand-integration_release"})
      public static final class b
        implements Parcelable.Creator<JsApiGetRecentUsageList.Companion.Result>
      {}
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiGetRecentUsageList$Companion$Task;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiGetRecentUsageList$Companion$Parameter;", "Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiGetRecentUsageList$Companion$Result;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "toJsonObject", "Lorg/json/JSONObject;", "Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandRecentTaskInfo;", "plugin-appbrand-integration_release"})
    public static final class a
      implements com.tencent.mm.ipcinvoker.b<JsApiGetRecentUsageList.Companion.Parameter, JsApiGetRecentUsageList.Companion.Result>
    {
      @l(gjZ={1, 1, 16}, gka={""}, gkb={"<no name provided>", "", "lastUpdateTime", "", "invoke"})
      static final class a
        extends q
        implements d.g.a.b<Long, z>
      {
        a(JsApiGetRecentUsageList.Companion.a parama, JsApiGetRecentUsageList.Companion.Parameter paramParameter, d paramd)
        {
          super();
        }
      }
      
      @l(gjZ={1, 1, 16}, gka={""}, gkb={"<no name provided>", "", "firstPage", "", "lastUpdateTime", "", "invoke"})
      static final class b
        extends q
        implements m<Boolean, Long, z>
      {
        b(JsApiGetRecentUsageList.Companion.Parameter paramParameter, d.g.a.b paramb, d paramd)
        {
          super();
        }
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "ret", "Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiGetRecentUsageList$Companion$Result;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class a<T>
    implements d<ResultType>
  {
    a(c paramc, int paramInt) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.rencentusage.JsApiGetRecentUsageList
 * JD-Core Version:    0.7.0.1
 */