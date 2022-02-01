package com.tencent.mm.plugin.appbrand.jsapi.rencentusage;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.plugin.appbrand.appusage.j.a;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.a.m;
import d.g.b.k;
import d.y;
import org.json.JSONObject;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiGetRecentUsageList;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "plugin-appbrand-integration_release"})
public final class JsApiGetRecentUsageList
  extends a<c>
{
  public static final int CTRL_INDEX = 853;
  public static final String NAME = "getRecentUsageList";
  public static final Companion kIL;
  
  static
  {
    AppMethodBeat.i(187243);
    kIL = new Companion((byte)0);
    AppMethodBeat.o(187243);
  }
  
  public final void a(final c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(187242);
    if (paramc == null)
    {
      AppMethodBeat.o(187242);
      return;
    }
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(187242);
      return;
    }
    ac.i("MicroMsg.JsApiGetRecentUsageList", "data=".concat(String.valueOf(paramJSONObject)));
    int i = paramJSONObject.optInt("count", 2147483647);
    if (i < 0)
    {
      paramc.h(paramInt, LM("fail:illegal count"));
      AppMethodBeat.o(187242);
      return;
    }
    int j = paramJSONObject.optInt("requestId", 2147483647);
    if (j == 2147483647)
    {
      paramc.h(paramInt, LM("fail:illegal requestId"));
      AppMethodBeat.o(187242);
      return;
    }
    long l = paramJSONObject.optLong("lastUpdateTime", 9223372036854775807L);
    if (l < 0L)
    {
      paramc.h(paramInt, LM("fail:illegal lastUpdateTime"));
      AppMethodBeat.o(187242);
      return;
    }
    paramc.h(paramInt, LM("ok"));
    h.a("com.tencent.mm", (Parcelable)new JsApiGetRecentUsageList.Companion.Parameter(i, l, j), JsApiGetRecentUsageList.Companion.a.class, (d)new a(j, paramc));
    AppMethodBeat.o(187242);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiGetRecentUsageList$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "UPDATE_TIME_FOR_FIRST_PAGE", "", "Parameter", "Task", "plugin-appbrand-integration_release"})
  public static final class Companion
  {
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiGetRecentUsageList$Companion$Parameter;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "count", "", "lastUpdateTime", "", "requestId", "(IJI)V", "getCount", "()I", "getLastUpdateTime", "()J", "getRequestId", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "flags", "CREATOR", "plugin-appbrand-integration_release"})
    public static final class Parameter
      implements Parcelable
    {
      public static final a CREATOR;
      final int count;
      final long lastUpdateTime;
      final int requestId;
      
      static
      {
        AppMethodBeat.i(187234);
        CREATOR = new a((byte)0);
        AppMethodBeat.o(187234);
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
        AppMethodBeat.i(187233);
        AppMethodBeat.o(187233);
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
        AppMethodBeat.i(187235);
        String str = "Parameter(count=" + this.count + ", lastUpdateTime=" + this.lastUpdateTime + ", requestId=" + this.requestId + ")";
        AppMethodBeat.o(187235);
        return str;
      }
      
      public final void writeToParcel(Parcel paramParcel, int paramInt)
      {
        AppMethodBeat.i(187232);
        k.h(paramParcel, "parcel");
        paramParcel.writeInt(this.count);
        paramParcel.writeLong(this.lastUpdateTime);
        paramParcel.writeInt(this.requestId);
        AppMethodBeat.o(187232);
      }
      
      @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiGetRecentUsageList$Companion$Parameter$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiGetRecentUsageList$Companion$Parameter;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiGetRecentUsageList$Companion$Parameter;", "plugin-appbrand-integration_release"})
      public static final class a
        implements Parcelable.Creator<JsApiGetRecentUsageList.Companion.Parameter>
      {}
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiGetRecentUsageList$Companion$Task;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiGetRecentUsageList$Companion$Parameter;", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "toJsonObject", "Lorg/json/JSONObject;", "Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandRecentTaskInfo;", "plugin-appbrand-integration_release"})
    public static final class a
      implements com.tencent.mm.ipcinvoker.b<JsApiGetRecentUsageList.Companion.Parameter, IPCString>
    {
      @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<no name provided>", "", "lastUpdateTime", "", "invoke"})
      static final class a
        extends d.g.b.l
        implements d.g.a.b<Long, y>
      {
        a(JsApiGetRecentUsageList.Companion.a parama, JsApiGetRecentUsageList.Companion.Parameter paramParameter, d paramd)
        {
          super();
        }
      }
      
      @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<no name provided>", "", "firstPage", "", "lastUpdateTime", "", "invoke"})
      static final class b
        extends d.g.b.l
        implements m<Boolean, Long, y>
      {
        b(JsApiGetRecentUsageList.Companion.Parameter paramParameter, d.g.a.b paramb)
        {
          super();
        }
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "ret", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class a<T>
    implements d<ResultType>
  {
    a(int paramInt, c paramc) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.rencentusage.JsApiGetRecentUsageList
 * JD-Core Version:    0.7.0.1
 */