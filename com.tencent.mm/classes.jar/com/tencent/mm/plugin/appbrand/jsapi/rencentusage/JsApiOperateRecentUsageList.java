package com.tencent.mm.plugin.appbrand.jsapi.rencentusage;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.g.b.s;
import kotlin.r;
import kotlin.v;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/service/AppBrandServiceWC;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "printW", "", "append", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class JsApiOperateRecentUsageList
  extends com.tencent.mm.plugin.appbrand.jsapi.c<com.tencent.mm.plugin.appbrand.service.c>
{
  public static final int CTRL_INDEX = 854;
  public static final String NAME = "operateRecentUsageList";
  public static final JsApiOperateRecentUsageList.Companion srB;
  
  static
  {
    AppMethodBeat.i(327408);
    srB = new JsApiOperateRecentUsageList.Companion((byte)0);
    AppMethodBeat.o(327408);
  }
  
  private static final void a(com.tencent.mm.plugin.appbrand.service.c paramc, int paramInt, JsApiOperateRecentUsageList paramJsApiOperateRecentUsageList, Companion.Result paramResult)
  {
    AppMethodBeat.i(327402);
    s.u(paramJsApiOperateRecentUsageList, "this$0");
    if (paramResult.success)
    {
      paramc.callback(paramInt, paramJsApiOperateRecentUsageList.m("ok", (Map)ak.g(new r[] { v.Y("errorCode", Integer.valueOf(paramResult.srO.value)) })));
      AppMethodBeat.o(327402);
      return;
    }
    paramc.callback(paramInt, paramJsApiOperateRecentUsageList.m(abx(s.X("fail:", paramResult.errorMsg)), (Map)ak.g(new r[] { v.Y("errorCode", Integer.valueOf(paramResult.srO.value)) })));
    AppMethodBeat.o(327402);
  }
  
  private static String ej(String paramString1, String paramString2)
  {
    AppMethodBeat.i(327390);
    Log.w("MicroMsg.operateRecentUsageList", s.X(paramString1, paramString2));
    AppMethodBeat.o(327390);
    return paramString1;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$Result;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "success", "", "errorCode", "Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$ErrorCode;", "errorMsg", "", "(ZLcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$ErrorCode;Ljava/lang/String;)V", "getErrorCode", "()Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$ErrorCode;", "getErrorMsg", "()Ljava/lang/String;", "getSuccess", "()Z", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "flags", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class Companion$Result
    implements Parcelable
  {
    public static final Parcelable.Creator<Result> CREATOR;
    public static final JsApiOperateRecentUsageList.Companion.Result.a srN;
    private static final Result srP;
    private static final Result srQ;
    final String errorMsg;
    final JsApiOperateRecentUsageList.Companion.b srO;
    final boolean success;
    
    static
    {
      AppMethodBeat.i(327420);
      srN = new JsApiOperateRecentUsageList.Companion.Result.a((byte)0);
      CREATOR = (Parcelable.Creator)new b();
      srP = new Result(true, JsApiOperateRecentUsageList.Companion.b.srH);
      srQ = new Result(false, JsApiOperateRecentUsageList.Companion.b.srI);
      AppMethodBeat.o(327420);
    }
    
    public Companion$Result(Parcel paramParcel) {}
    
    public Companion$Result(boolean paramBoolean, JsApiOperateRecentUsageList.Companion.b paramb, String paramString)
    {
      AppMethodBeat.i(327384);
      this.success = paramBoolean;
      this.srO = paramb;
      this.errorMsg = paramString;
      AppMethodBeat.o(327384);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(327455);
      if (this == paramObject)
      {
        AppMethodBeat.o(327455);
        return true;
      }
      if (!(paramObject instanceof Result))
      {
        AppMethodBeat.o(327455);
        return false;
      }
      paramObject = (Result)paramObject;
      if (this.success != paramObject.success)
      {
        AppMethodBeat.o(327455);
        return false;
      }
      if (this.srO != paramObject.srO)
      {
        AppMethodBeat.o(327455);
        return false;
      }
      if (!s.p(this.errorMsg, paramObject.errorMsg))
      {
        AppMethodBeat.o(327455);
        return false;
      }
      AppMethodBeat.o(327455);
      return true;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(327438);
      String str = "Result(success=" + this.success + ", errorCode=" + this.srO + ", errorMsg=" + this.errorMsg + ')';
      AppMethodBeat.o(327438);
      return str;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(327427);
      s.u(paramParcel, "parcel");
      if (this.success) {}
      for (byte b = 1;; b = 0)
      {
        paramParcel.writeByte(b);
        paramParcel.writeString(this.srO.name());
        paramParcel.writeString(this.errorMsg);
        AppMethodBeat.o(327427);
        return;
      }
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$Result$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$Result;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$Result;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class b
      implements Parcelable.Creator<JsApiOperateRecentUsageList.Companion.Result>
    {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$Result$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$Result;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$Result;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class Companion$Result$b
    implements Parcelable.Creator<JsApiOperateRecentUsageList.Companion.Result>
  {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$ActionType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "REMOVE_FROM_RECENT_USAGE_LIST", "ADD_TO_MY_COLLECTION", "REMOVE_FROM_MY_COLLECTION", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum Companion$a
  {
    public static final a srC;
    final int type;
    
    static
    {
      AppMethodBeat.i(327389);
      srD = new a("REMOVE_FROM_RECENT_USAGE_LIST", 0, 0);
      srE = new a("ADD_TO_MY_COLLECTION", 1, 1);
      srF = new a("REMOVE_FROM_MY_COLLECTION", 2, 2);
      srG = new a[] { srD, srE, srF };
      srC = new a((byte)0);
      AppMethodBeat.o(327389);
    }
    
    private Companion$a(int paramInt)
    {
      this.type = paramInt;
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$ActionType$Companion;", "", "()V", "obtain", "Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$ActionType;", "type", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
    {
      public static JsApiOperateRecentUsageList.Companion.a AX(int paramInt)
      {
        AppMethodBeat.i(327377);
        Object localObject = JsApiOperateRecentUsageList.Companion.a.values();
        int k = localObject.length;
        int i = 0;
        while (i < k)
        {
          JsApiOperateRecentUsageList.Companion.a locala = localObject[i];
          if (locala.type == paramInt) {}
          for (int j = 1; j != 0; j = 0)
          {
            AppMethodBeat.o(327377);
            return locala;
          }
          i += 1;
        }
        localObject = (Throwable)new NoSuchElementException("Array contains no element matching the predicate.");
        AppMethodBeat.o(327377);
        throw ((Throwable)localObject);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$ActionType$Companion;", "", "()V", "obtain", "Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$ActionType;", "type", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class Companion$a$a
  {
    public static JsApiOperateRecentUsageList.Companion.a AX(int paramInt)
    {
      AppMethodBeat.i(327377);
      Object localObject = JsApiOperateRecentUsageList.Companion.a.values();
      int k = localObject.length;
      int i = 0;
      while (i < k)
      {
        JsApiOperateRecentUsageList.Companion.a locala = localObject[i];
        if (locala.type == paramInt) {}
        for (int j = 1; j != 0; j = 0)
        {
          AppMethodBeat.o(327377);
          return locala;
        }
        i += 1;
      }
      localObject = (Throwable)new NoSuchElementException("Array contains no element matching the predicate.");
      AppMethodBeat.o(327377);
      throw ((Throwable)localObject);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$ErrorCode;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "OK", "FAIL_OTHER", "FAIL_ADD_STAR_REACHED_MAXIMUM_LIMIT", "FAIL_ADD_STAR_BLOCKED", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum Companion$b
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(327413);
      srH = new b("OK", 0, 0);
      srI = new b("FAIL_OTHER", 1, 1);
      srJ = new b("FAIL_ADD_STAR_REACHED_MAXIMUM_LIMIT", 2, 2);
      srK = new b("FAIL_ADD_STAR_BLOCKED", 3, 3);
      srL = new b[] { srH, srI, srJ, srK };
      AppMethodBeat.o(327413);
    }
    
    private Companion$b(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$Task;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$Parameter;", "Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$Result;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class Companion$c
    implements d<JsApiOperateRecentUsageList.Companion.Parameter, JsApiOperateRecentUsageList.Companion.Result>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.rencentusage.JsApiOperateRecentUsageList
 * JD-Core Version:    0.7.0.1
 */