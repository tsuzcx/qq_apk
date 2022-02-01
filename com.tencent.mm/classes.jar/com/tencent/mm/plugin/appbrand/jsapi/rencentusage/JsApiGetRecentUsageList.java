package com.tencent.mm.plugin.appbrand.jsapi.rencentusage;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.u;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiGetRecentUsageList;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class JsApiGetRecentUsageList
  extends com.tencent.mm.plugin.appbrand.jsapi.c<com.tencent.mm.plugin.appbrand.jsapi.f>
{
  public static final int CTRL_INDEX = 853;
  public static final String NAME = "getRecentUsageList";
  public static final JsApiGetRecentUsageList.Companion srv;
  
  static
  {
    AppMethodBeat.i(327393);
    srv = new JsApiGetRecentUsageList.Companion((byte)0);
    AppMethodBeat.o(327393);
  }
  
  private static final void a(com.tencent.mm.plugin.appbrand.jsapi.f paramf, int paramInt, Companion.Result paramResult)
  {
    AppMethodBeat.i(327388);
    Object localObject = a.srA;
    kotlin.g.b.s.s(paramResult, "ret");
    kotlin.g.b.s.u(paramf, "component");
    kotlin.g.b.s.u(paramResult, "recentUsageInfo");
    localObject = new JSONObject();
    ((JSONObject)localObject).put("requestId", paramInt);
    ((JSONObject)localObject).put("recentUsageInfo", new JSONArray(paramResult.data));
    ((JSONObject)localObject).put("errorCode", paramResult.errorCode);
    String str = ((JSONObject)localObject).put("errorMsg", paramResult.errorMsg).toString();
    kotlin.g.b.s.s(str, "with(JSONObject()) {\n   …\n            }.toString()");
    StringBuilder localStringBuilder = new StringBuilder();
    if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG)) {}
    for (localObject = "data=" + str + '\n';; localObject = "******")
    {
      Log.i("MicroMsg.JsApiOnGetRecentUsageListResultEvent", (String)localObject + "errorCode=" + paramResult.errorCode + "\nerrorMsg=" + paramResult.errorMsg);
      new a((byte)0).h(paramf).ZQ(str).cpV();
      AppMethodBeat.o(327388);
      return;
    }
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(327405);
    if (paramf == null)
    {
      AppMethodBeat.o(327405);
      return;
    }
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(327405);
      return;
    }
    Log.i("MicroMsg.JsApiGetRecentUsageList", kotlin.g.b.s.X("data=", paramJSONObject));
    int i = paramJSONObject.optInt("count", 2147483647);
    if (i < 0)
    {
      paramf.callback(paramInt, ZP("fail:illegal count"));
      AppMethodBeat.o(327405);
      return;
    }
    int j = paramJSONObject.optInt("requestId", 2147483647);
    if (j == 2147483647)
    {
      paramf.callback(paramInt, ZP("fail:illegal requestId"));
      AppMethodBeat.o(327405);
      return;
    }
    long l = paramJSONObject.optLong("lastUpdateTime", 9223372036854775807L);
    if (l < 0L)
    {
      paramf.callback(paramInt, ZP("fail:illegal lastUpdateTime"));
      AppMethodBeat.o(327405);
      return;
    }
    paramf.callback(paramInt, ZP("ok"));
    j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)new JsApiGetRecentUsageList.Companion.Parameter(i, l, j), Companion.a.class, new JsApiGetRecentUsageList..ExternalSyntheticLambda0(paramf, j));
    AppMethodBeat.o(327405);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiGetRecentUsageList$Companion$Result;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "data", "", "errorCode", "", "errorMsg", "(Ljava/lang/String;ILjava/lang/String;)V", "getData", "()Ljava/lang/String;", "getErrorCode", "()I", "getErrorMsg", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "flags", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class Companion$Result
    implements Parcelable
  {
    public static final Parcelable.Creator<Result> CREATOR;
    public static final JsApiGetRecentUsageList.Companion.Result.a srw;
    final String data;
    final int errorCode;
    final String errorMsg;
    
    static
    {
      AppMethodBeat.i(327396);
      srw = new JsApiGetRecentUsageList.Companion.Result.a((byte)0);
      CREATOR = (Parcelable.Creator)new b();
      AppMethodBeat.o(327396);
    }
    
    public Companion$Result(Parcel paramParcel)
    {
      this(str, i, paramParcel);
      AppMethodBeat.i(327392);
      AppMethodBeat.o(327392);
    }
    
    public Companion$Result(String paramString1, int paramInt, String paramString2)
    {
      AppMethodBeat.i(327381);
      this.data = paramString1;
      this.errorCode = paramInt;
      this.errorMsg = paramString2;
      AppMethodBeat.o(327381);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(327415);
      if (this == paramObject)
      {
        AppMethodBeat.o(327415);
        return true;
      }
      if (!(paramObject instanceof Result))
      {
        AppMethodBeat.o(327415);
        return false;
      }
      paramObject = (Result)paramObject;
      if (!kotlin.g.b.s.p(this.data, paramObject.data))
      {
        AppMethodBeat.o(327415);
        return false;
      }
      if (this.errorCode != paramObject.errorCode)
      {
        AppMethodBeat.o(327415);
        return false;
      }
      if (!kotlin.g.b.s.p(this.errorMsg, paramObject.errorMsg))
      {
        AppMethodBeat.o(327415);
        return false;
      }
      AppMethodBeat.o(327415);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(327412);
      int i = this.data.hashCode();
      int j = this.errorCode;
      int k = this.errorMsg.hashCode();
      AppMethodBeat.o(327412);
      return (i * 31 + j) * 31 + k;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(327409);
      String str = "Result(data=" + this.data + ", errorCode=" + this.errorCode + ", errorMsg=" + this.errorMsg + ')';
      AppMethodBeat.o(327409);
      return str;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(327400);
      kotlin.g.b.s.u(paramParcel, "parcel");
      paramParcel.writeString(this.data);
      paramParcel.writeInt(this.errorCode);
      paramParcel.writeString(this.errorMsg);
      AppMethodBeat.o(327400);
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiGetRecentUsageList$Companion$Result$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiGetRecentUsageList$Companion$Result;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiGetRecentUsageList$Companion$Result;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class b
      implements Parcelable.Creator<JsApiGetRecentUsageList.Companion.Result>
    {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiGetRecentUsageList$Companion$Result$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiGetRecentUsageList$Companion$Result;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiGetRecentUsageList$Companion$Result;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class Companion$Result$b
    implements Parcelable.Creator<JsApiGetRecentUsageList.Companion.Result>
  {}
  
  @com.tencent.mm.ipcinvoker.c.a
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiGetRecentUsageList$Companion$Task;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeCallbackOnceTask;", "Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiGetRecentUsageList$Companion$Parameter;", "Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiGetRecentUsageList$Companion$Result;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "toJsonObject", "Lorg/json/JSONObject;", "Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandRecentTaskInfo;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class Companion$a
    implements com.tencent.mm.ipcinvoker.c<JsApiGetRecentUsageList.Companion.Parameter, JsApiGetRecentUsageList.Companion.Result>
  {
    @Metadata(d1={""}, d2={"<no name provided>", "", "lastUpdateTime", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements b<Long, ah>
    {
      a(JsApiGetRecentUsageList.Companion.Parameter paramParameter, com.tencent.mm.ipcinvoker.f<JsApiGetRecentUsageList.Companion.Result> paramf, JsApiGetRecentUsageList.Companion.a parama)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<no name provided>", "", "firstPage", "", "lastUpdateTime", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends u
      implements m<Boolean, Long, ah>
    {
      b(JsApiGetRecentUsageList.Companion.Parameter paramParameter, b<? super Long, ah> paramb, com.tencent.mm.ipcinvoker.f<JsApiGetRecentUsageList.Companion.Result> paramf)
      {
        super();
      }
      
      private static final void a(b paramb, long paramLong, com.tencent.mm.ipcinvoker.f paramf, boolean paramBoolean, String paramString)
      {
        AppMethodBeat.i(327411);
        kotlin.g.b.s.u(paramb, "$requestDb");
        Log.i("MicroMsg.JsApiGetRecentUsageList", "fetchNextPageFromServer  success=" + paramBoolean + " errorMsg=" + paramString);
        if (paramBoolean)
        {
          paramb.invoke(Long.valueOf(paramLong));
          AppMethodBeat.o(327411);
          return;
        }
        kotlin.g.b.s.s(paramString, "errorMsg");
        paramf.onCallback(new JsApiGetRecentUsageList.Companion.Result("", -1000, paramString));
        AppMethodBeat.o(327411);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<no name provided>", "", "lastUpdateTime", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class Companion$a$a
    extends u
    implements b<Long, ah>
  {
    Companion$a$a(JsApiGetRecentUsageList.Companion.Parameter paramParameter, com.tencent.mm.ipcinvoker.f<JsApiGetRecentUsageList.Companion.Result> paramf, JsApiGetRecentUsageList.Companion.a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<no name provided>", "", "firstPage", "", "lastUpdateTime", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class Companion$a$b
    extends u
    implements m<Boolean, Long, ah>
  {
    Companion$a$b(JsApiGetRecentUsageList.Companion.Parameter paramParameter, b<? super Long, ah> paramb, com.tencent.mm.ipcinvoker.f<JsApiGetRecentUsageList.Companion.Result> paramf)
    {
      super();
    }
    
    private static final void a(b paramb, long paramLong, com.tencent.mm.ipcinvoker.f paramf, boolean paramBoolean, String paramString)
    {
      AppMethodBeat.i(327411);
      kotlin.g.b.s.u(paramb, "$requestDb");
      Log.i("MicroMsg.JsApiGetRecentUsageList", "fetchNextPageFromServer  success=" + paramBoolean + " errorMsg=" + paramString);
      if (paramBoolean)
      {
        paramb.invoke(Long.valueOf(paramLong));
        AppMethodBeat.o(327411);
        return;
      }
      kotlin.g.b.s.s(paramString, "errorMsg");
      paramf.onCallback(new JsApiGetRecentUsageList.Companion.Result("", -1000, paramString));
      AppMethodBeat.o(327411);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.rencentusage.JsApiGetRecentUsageList
 * JD-Core Version:    0.7.0.1
 */