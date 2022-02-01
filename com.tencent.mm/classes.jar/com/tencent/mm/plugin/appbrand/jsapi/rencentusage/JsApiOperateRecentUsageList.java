package com.tencent.mm.plugin.appbrand.jsapi.rencentusage;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;
import java.util.NoSuchElementException;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/service/AppBrandServiceWC;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "printW", "", "append", "Companion", "plugin-appbrand-integration_release"})
public final class JsApiOperateRecentUsageList
  extends a<c>
{
  public static final int CTRL_INDEX = 854;
  public static final String NAME = "operateRecentUsageList";
  public static final Companion kIT;
  
  static
  {
    AppMethodBeat.i(187275);
    kIT = new Companion((byte)0);
    AppMethodBeat.o(187275);
  }
  
  private static String dm(String paramString1, String paramString2)
  {
    AppMethodBeat.i(187273);
    ac.w("MicroMsg.operateRecentUsageList", paramString1 + paramString2);
    AppMethodBeat.o(187273);
    return paramString1;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "ActionType", "ErrorCode", "Parameter", "Result", "Task", "plugin-appbrand-integration_release"})
  public static final class Companion
  {
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$Parameter;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "actionType", "Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$ActionType;", "username", "", "appId", "versionType", "", "(Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$ActionType;Ljava/lang/String;Ljava/lang/String;I)V", "getActionType", "()Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$ActionType;", "getAppId", "()Ljava/lang/String;", "getUsername", "getVersionType", "()I", "component1", "component2", "component3", "component4", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "flags", "CREATOR", "plugin-appbrand-integration_release"})
    public static final class Parameter
      implements Parcelable
    {
      public static final a CREATOR;
      final String appId;
      final int hxM;
      final JsApiOperateRecentUsageList.Companion.a kJe;
      final String username;
      
      static
      {
        AppMethodBeat.i(187256);
        CREATOR = new a((byte)0);
        AppMethodBeat.o(187256);
      }
      
      public Parameter(Parcel paramParcel)
      {
        this((JsApiOperateRecentUsageList.Companion.a)localObject, str1, str2, paramParcel.readInt());
        AppMethodBeat.i(187255);
        AppMethodBeat.o(187255);
      }
      
      public Parameter(JsApiOperateRecentUsageList.Companion.a parama, String paramString1, String paramString2, int paramInt)
      {
        AppMethodBeat.i(187254);
        this.kJe = parama;
        this.username = paramString1;
        this.appId = paramString2;
        this.hxM = paramInt;
        AppMethodBeat.o(187254);
      }
      
      public final int describeContents()
      {
        return 0;
      }
      
      public final boolean equals(Object paramObject)
      {
        AppMethodBeat.i(187259);
        if (this != paramObject)
        {
          if ((paramObject instanceof Parameter))
          {
            paramObject = (Parameter)paramObject;
            if ((!k.g(this.kJe, paramObject.kJe)) || (!k.g(this.username, paramObject.username)) || (!k.g(this.appId, paramObject.appId)) || (this.hxM != paramObject.hxM)) {}
          }
        }
        else
        {
          AppMethodBeat.o(187259);
          return true;
        }
        AppMethodBeat.o(187259);
        return false;
      }
      
      public final int hashCode()
      {
        int k = 0;
        AppMethodBeat.i(187258);
        Object localObject = this.kJe;
        int i;
        if (localObject != null)
        {
          i = localObject.hashCode();
          localObject = this.username;
          if (localObject == null) {
            break label92;
          }
        }
        label92:
        for (int j = localObject.hashCode();; j = 0)
        {
          localObject = this.appId;
          if (localObject != null) {
            k = localObject.hashCode();
          }
          int m = this.hxM;
          AppMethodBeat.o(187258);
          return ((j + i * 31) * 31 + k) * 31 + m;
          i = 0;
          break;
        }
      }
      
      public final String toString()
      {
        AppMethodBeat.i(187257);
        String str = "Parameter(actionType=" + this.kJe + ", username=" + this.username + ", appId=" + this.appId + ", versionType=" + this.hxM + ")";
        AppMethodBeat.o(187257);
        return str;
      }
      
      public final void writeToParcel(Parcel paramParcel, int paramInt)
      {
        AppMethodBeat.i(187253);
        k.h(paramParcel, "parcel");
        paramParcel.writeString(this.kJe.name());
        paramParcel.writeString(this.username);
        paramParcel.writeString(this.appId);
        paramParcel.writeInt(this.hxM);
        AppMethodBeat.o(187253);
      }
      
      @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$Parameter$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$Parameter;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$Parameter;", "plugin-appbrand-integration_release"})
      public static final class a
        implements Parcelable.Creator<JsApiOperateRecentUsageList.Companion.Parameter>
      {}
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$Result;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "success", "", "errorCode", "Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$ErrorCode;", "errorMsg", "", "(ZLcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$ErrorCode;Ljava/lang/String;)V", "getErrorCode", "()Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$ErrorCode;", "getErrorMsg", "()Ljava/lang/String;", "getSuccess", "()Z", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "flags", "Companion", "plugin-appbrand-integration_release"})
    public static final class Result
      implements Parcelable
    {
      public static final Parcelable.Creator<Result> CREATOR;
      private static final Result kJg;
      private static final Result kJh;
      public static final a kJi;
      final String errorMsg;
      final JsApiOperateRecentUsageList.Companion.b kJf;
      final boolean success;
      
      static
      {
        AppMethodBeat.i(187265);
        kJi = new a((byte)0);
        CREATOR = (Parcelable.Creator)new b();
        kJg = new Result(true, JsApiOperateRecentUsageList.Companion.b.kIZ);
        kJh = new Result(false, JsApiOperateRecentUsageList.Companion.b.kJa);
        AppMethodBeat.o(187265);
      }
      
      public Result(Parcel paramParcel) {}
      
      public Result(boolean paramBoolean, JsApiOperateRecentUsageList.Companion.b paramb, String paramString)
      {
        AppMethodBeat.i(187262);
        this.success = paramBoolean;
        this.kJf = paramb;
        this.errorMsg = paramString;
        AppMethodBeat.o(187262);
      }
      
      public final int describeContents()
      {
        return 0;
      }
      
      public final boolean equals(Object paramObject)
      {
        AppMethodBeat.i(187268);
        if (this != paramObject)
        {
          if ((paramObject instanceof Result))
          {
            paramObject = (Result)paramObject;
            if ((this.success != paramObject.success) || (!k.g(this.kJf, paramObject.kJf)) || (!k.g(this.errorMsg, paramObject.errorMsg))) {}
          }
        }
        else
        {
          AppMethodBeat.o(187268);
          return true;
        }
        AppMethodBeat.o(187268);
        return false;
      }
      
      public final int hashCode()
      {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
      }
      
      public final String toString()
      {
        AppMethodBeat.i(187266);
        String str = "Result(success=" + this.success + ", errorCode=" + this.kJf + ", errorMsg=" + this.errorMsg + ")";
        AppMethodBeat.o(187266);
        return str;
      }
      
      public final void writeToParcel(Parcel paramParcel, int paramInt)
      {
        AppMethodBeat.i(187261);
        k.h(paramParcel, "parcel");
        if (this.success) {}
        for (byte b = 1;; b = 0)
        {
          paramParcel.writeByte(b);
          paramParcel.writeString(this.kJf.name());
          paramParcel.writeString(this.errorMsg);
          AppMethodBeat.o(187261);
          return;
        }
      }
      
      @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$Result$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$Result;", "FAIL", "getFAIL", "()Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$Result;", "OK", "getOK", "plugin-appbrand-integration_release"})
      public static final class a {}
      
      @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$Result$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$Result;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$Result;", "plugin-appbrand-integration_release"})
      public static final class b
        implements Parcelable.Creator<JsApiOperateRecentUsageList.Companion.Result>
      {}
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$ActionType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "REMOVE_FROM_RECENT_USAGE_LIST", "ADD_TO_MY_COLLECTION", "REMOVE_FROM_MY_COLLECTION", "Companion", "plugin-appbrand-integration_release"})
    public static enum a
    {
      public static final a kIY;
      final int type;
      
      static
      {
        AppMethodBeat.i(187246);
        a locala1 = new a("REMOVE_FROM_RECENT_USAGE_LIST", 0, 0);
        kIU = locala1;
        a locala2 = new a("ADD_TO_MY_COLLECTION", 1, 1);
        kIV = locala2;
        a locala3 = new a("REMOVE_FROM_MY_COLLECTION", 2, 2);
        kIW = locala3;
        kIX = new a[] { locala1, locala2, locala3 };
        kIY = new a((byte)0);
        AppMethodBeat.o(187246);
      }
      
      private a(int paramInt)
      {
        this.type = paramInt;
      }
      
      @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$ActionType$Companion;", "", "()V", "obtain", "Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$ActionType;", "type", "", "plugin-appbrand-integration_release"})
      public static final class a
      {
        public static JsApiOperateRecentUsageList.Companion.a sK(int paramInt)
        {
          AppMethodBeat.i(187245);
          Object localObject = JsApiOperateRecentUsageList.Companion.a.values();
          int k = localObject.length;
          int i = 0;
          while (i < k)
          {
            JsApiOperateRecentUsageList.Companion.a locala = localObject[i];
            if (locala.type == paramInt) {}
            for (int j = 1; j != 0; j = 0)
            {
              AppMethodBeat.o(187245);
              return locala;
            }
            i += 1;
          }
          localObject = (Throwable)new NoSuchElementException("Array contains no element matching the predicate.");
          AppMethodBeat.o(187245);
          throw ((Throwable)localObject);
        }
      }
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$ErrorCode;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "OK", "FAIL_OTHER", "FAIL_ADD_STAR_REACHED_MAXIMUM_LIMIT", "FAIL_ADD_STAR_BLOCKED", "plugin-appbrand-integration_release"})
    public static enum b
    {
      final int value;
      
      static
      {
        AppMethodBeat.i(187249);
        b localb1 = new b("OK", 0, 0);
        kIZ = localb1;
        b localb2 = new b("FAIL_OTHER", 1, 1);
        kJa = localb2;
        b localb3 = new b("FAIL_ADD_STAR_REACHED_MAXIMUM_LIMIT", 2, 2);
        kJb = localb3;
        b localb4 = new b("FAIL_ADD_STAR_BLOCKED", 3, 3);
        kJc = localb4;
        kJd = new b[] { localb1, localb2, localb3, localb4 };
        AppMethodBeat.o(187249);
      }
      
      private b(int paramInt)
      {
        this.value = paramInt;
      }
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$Task;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$Parameter;", "Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$Result;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-appbrand-integration_release"})
    public static final class c
      implements b<JsApiOperateRecentUsageList.Companion.Parameter, JsApiOperateRecentUsageList.Companion.Result>
    {}
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$Result;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class a<T>
    implements d<ResultType>
  {
    a(JsApiOperateRecentUsageList paramJsApiOperateRecentUsageList, c paramc, int paramInt) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.rencentusage.JsApiOperateRecentUsageList
 * JD-Core Version:    0.7.0.1
 */