package com.tencent.mm.plugin.appbrand.jsapi.rencentusage;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.NoSuchElementException;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/service/AppBrandServiceWC;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "printW", "", "append", "Companion", "plugin-appbrand-integration_release"})
public final class JsApiOperateRecentUsageList
  extends com.tencent.mm.plugin.appbrand.jsapi.c<com.tencent.mm.plugin.appbrand.service.c>
{
  public static final int CTRL_INDEX = 854;
  public static final String NAME = "operateRecentUsageList";
  public static final JsApiOperateRecentUsageList.Companion pmJ;
  
  static
  {
    AppMethodBeat.i(275507);
    pmJ = new JsApiOperateRecentUsageList.Companion((byte)0);
    AppMethodBeat.o(275507);
  }
  
  private static String dQ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(275504);
    Log.w("MicroMsg.operateRecentUsageList", paramString1 + paramString2);
    AppMethodBeat.o(275504);
    return paramString1;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$Result;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "success", "", "errorCode", "Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$ErrorCode;", "errorMsg", "", "(ZLcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$ErrorCode;Ljava/lang/String;)V", "getErrorCode", "()Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$ErrorCode;", "getErrorMsg", "()Ljava/lang/String;", "getSuccess", "()Z", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "flags", "Companion", "plugin-appbrand-integration_release"})
  public static final class Companion$Result
    implements Parcelable
  {
    public static final Parcelable.Creator<Result> CREATOR;
    private static final Result pmW;
    private static final Result pmX;
    public static final JsApiOperateRecentUsageList.Companion.Result.a pmY;
    final String errorMsg;
    final JsApiOperateRecentUsageList.Companion.b pmV;
    final boolean success;
    
    static
    {
      AppMethodBeat.i(269482);
      pmY = new JsApiOperateRecentUsageList.Companion.Result.a((byte)0);
      CREATOR = (Parcelable.Creator)new b();
      pmW = new Result(true, JsApiOperateRecentUsageList.Companion.b.pmP);
      pmX = new Result(false, JsApiOperateRecentUsageList.Companion.b.pmQ);
      AppMethodBeat.o(269482);
    }
    
    public Companion$Result(Parcel paramParcel) {}
    
    public Companion$Result(boolean paramBoolean, JsApiOperateRecentUsageList.Companion.b paramb, String paramString)
    {
      AppMethodBeat.i(269475);
      this.success = paramBoolean;
      this.pmV = paramb;
      this.errorMsg = paramString;
      AppMethodBeat.o(269475);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(269486);
      if (this != paramObject)
      {
        if ((paramObject instanceof Result))
        {
          paramObject = (Result)paramObject;
          if ((this.success != paramObject.success) || (!p.h(this.pmV, paramObject.pmV)) || (!p.h(this.errorMsg, paramObject.errorMsg))) {}
        }
      }
      else
      {
        AppMethodBeat.o(269486);
        return true;
      }
      AppMethodBeat.o(269486);
      return false;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(269484);
      String str = "Result(success=" + this.success + ", errorCode=" + this.pmV + ", errorMsg=" + this.errorMsg + ")";
      AppMethodBeat.o(269484);
      return str;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(269473);
      p.k(paramParcel, "parcel");
      if (this.success) {}
      for (byte b = 1;; b = 0)
      {
        paramParcel.writeByte(b);
        paramParcel.writeString(this.pmV.name());
        paramParcel.writeString(this.errorMsg);
        AppMethodBeat.o(269473);
        return;
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$Result$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$Result;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$Result;", "plugin-appbrand-integration_release"})
    public static final class b
      implements Parcelable.Creator<JsApiOperateRecentUsageList.Companion.Result>
    {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$Result$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$Result;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$Result;", "plugin-appbrand-integration_release"})
  public static final class Companion$Result$b
    implements Parcelable.Creator<JsApiOperateRecentUsageList.Companion.Result>
  {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$ActionType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "REMOVE_FROM_RECENT_USAGE_LIST", "ADD_TO_MY_COLLECTION", "REMOVE_FROM_MY_COLLECTION", "Companion", "plugin-appbrand-integration_release"})
  public static enum Companion$a
  {
    public static final a pmO;
    final int type;
    
    static
    {
      AppMethodBeat.i(252166);
      a locala1 = new a("REMOVE_FROM_RECENT_USAGE_LIST", 0, 0);
      pmK = locala1;
      a locala2 = new a("ADD_TO_MY_COLLECTION", 1, 1);
      pmL = locala2;
      a locala3 = new a("REMOVE_FROM_MY_COLLECTION", 2, 2);
      pmM = locala3;
      pmN = new a[] { locala1, locala2, locala3 };
      pmO = new a((byte)0);
      AppMethodBeat.o(252166);
    }
    
    private Companion$a(int paramInt)
    {
      this.type = paramInt;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$ActionType$Companion;", "", "()V", "obtain", "Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$ActionType;", "type", "", "plugin-appbrand-integration_release"})
    public static final class a
    {
      public static JsApiOperateRecentUsageList.Companion.a AJ(int paramInt)
      {
        AppMethodBeat.i(273382);
        Object localObject = JsApiOperateRecentUsageList.Companion.a.values();
        int k = localObject.length;
        int i = 0;
        while (i < k)
        {
          JsApiOperateRecentUsageList.Companion.a locala = localObject[i];
          if (locala.type == paramInt) {}
          for (int j = 1; j != 0; j = 0)
          {
            AppMethodBeat.o(273382);
            return locala;
          }
          i += 1;
        }
        localObject = (Throwable)new NoSuchElementException("Array contains no element matching the predicate.");
        AppMethodBeat.o(273382);
        throw ((Throwable)localObject);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$ActionType$Companion;", "", "()V", "obtain", "Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$ActionType;", "type", "", "plugin-appbrand-integration_release"})
  public static final class Companion$a$a
  {
    public static JsApiOperateRecentUsageList.Companion.a AJ(int paramInt)
    {
      AppMethodBeat.i(273382);
      Object localObject = JsApiOperateRecentUsageList.Companion.a.values();
      int k = localObject.length;
      int i = 0;
      while (i < k)
      {
        JsApiOperateRecentUsageList.Companion.a locala = localObject[i];
        if (locala.type == paramInt) {}
        for (int j = 1; j != 0; j = 0)
        {
          AppMethodBeat.o(273382);
          return locala;
        }
        i += 1;
      }
      localObject = (Throwable)new NoSuchElementException("Array contains no element matching the predicate.");
      AppMethodBeat.o(273382);
      throw ((Throwable)localObject);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$ErrorCode;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "OK", "FAIL_OTHER", "FAIL_ADD_STAR_REACHED_MAXIMUM_LIMIT", "FAIL_ADD_STAR_BLOCKED", "plugin-appbrand-integration_release"})
  public static enum Companion$b
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(269143);
      b localb1 = new b("OK", 0, 0);
      pmP = localb1;
      b localb2 = new b("FAIL_OTHER", 1, 1);
      pmQ = localb2;
      b localb3 = new b("FAIL_ADD_STAR_REACHED_MAXIMUM_LIMIT", 2, 2);
      pmR = localb3;
      b localb4 = new b("FAIL_ADD_STAR_BLOCKED", 3, 3);
      pmS = localb4;
      pmT = new b[] { localb1, localb2, localb3, localb4 };
      AppMethodBeat.o(269143);
    }
    
    private Companion$b(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$Task;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$Parameter;", "Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$Result;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-appbrand-integration_release"})
  public static final class Companion$c
    implements d<JsApiOperateRecentUsageList.Companion.Parameter, JsApiOperateRecentUsageList.Companion.Result>
  {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$Result;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class a<T>
    implements f<ResultType>
  {
    a(JsApiOperateRecentUsageList paramJsApiOperateRecentUsageList, com.tencent.mm.plugin.appbrand.service.c paramc, int paramInt) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.rencentusage.JsApiOperateRecentUsageList
 * JD-Core Version:    0.7.0.1
 */