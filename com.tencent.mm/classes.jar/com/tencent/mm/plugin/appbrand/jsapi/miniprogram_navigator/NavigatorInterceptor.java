package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.model.gdpr.b;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlinx.coroutines.ak;
import kotlinx.coroutines.br;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/miniprogram_navigator/NavigatorInterceptor;", "", "()V", "checkGdprPolicy", "", "context", "Landroid/content/Context;", "toAppId", "", "(Landroid/content/Context;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkIsActiveMiniGame", "Lkotlin/Pair;", "", "toVersionType", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleIntercept", "", "service", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "args", "Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;", "callback", "Lcom/tencent/mm/plugin/appbrand/jsapi/miniprogram_navigator/IMiniProgramNavigator$NavigationHandler;", "CheckIsActiveMiniGameIPCArgs", "CheckIsActiveMiniGameIPCResult", "MMLaunchEntryProxyRequest", "MMLaunchEntryProxyTask", "plugin-appbrand-integration_release"})
public final class NavigatorInterceptor
{
  public static final NavigatorInterceptor pdq;
  
  static
  {
    AppMethodBeat.i(269359);
    pdq = new NavigatorInterceptor();
    AppMethodBeat.o(269359);
  }
  
  public static void b(com.tencent.mm.plugin.appbrand.g paramg, LaunchParcel paramLaunchParcel, c.b paramb)
  {
    AppMethodBeat.i(269356);
    p.k(paramg, "service");
    p.k(paramLaunchParcel, "args");
    p.k(paramb, "callback");
    kotlinx.coroutines.g.b((ak)br.abxo, null, (m)new NavigatorInterceptor.e(paramg, paramLaunchParcel, paramb, null), 3);
    AppMethodBeat.o(269356);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/miniprogram_navigator/NavigatorInterceptor$CheckIsActiveMiniGameIPCArgs;", "Landroid/os/Parcelable;", "appId", "", "versionType", "", "(Ljava/lang/String;I)V", "getAppId", "()Ljava/lang/String;", "getVersionType", "()I", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-appbrand-integration_release"})
  public static final class CheckIsActiveMiniGameIPCArgs
    implements Parcelable
  {
    public static final Parcelable.Creator CREATOR;
    final String appId;
    final int cBU;
    
    static
    {
      AppMethodBeat.i(268676);
      CREATOR = new a();
      AppMethodBeat.o(268676);
    }
    
    public CheckIsActiveMiniGameIPCArgs(String paramString, int paramInt)
    {
      AppMethodBeat.i(268667);
      this.appId = paramString;
      this.cBU = paramInt;
      AppMethodBeat.o(268667);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(268674);
      if (this != paramObject)
      {
        if ((paramObject instanceof CheckIsActiveMiniGameIPCArgs))
        {
          paramObject = (CheckIsActiveMiniGameIPCArgs)paramObject;
          if ((!p.h(this.appId, paramObject.appId)) || (this.cBU != paramObject.cBU)) {}
        }
      }
      else
      {
        AppMethodBeat.o(268674);
        return true;
      }
      AppMethodBeat.o(268674);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(268673);
      String str = this.appId;
      if (str != null) {}
      for (int i = str.hashCode();; i = 0)
      {
        int j = this.cBU;
        AppMethodBeat.o(268673);
        return i * 31 + j;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(268670);
      String str = "CheckIsActiveMiniGameIPCArgs(appId=" + this.appId + ", versionType=" + this.cBU + ")";
      AppMethodBeat.o(268670);
      return str;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(268675);
      p.k(paramParcel, "parcel");
      paramParcel.writeString(this.appId);
      paramParcel.writeInt(this.cBU);
      AppMethodBeat.o(268675);
    }
    
    @l(iBK={1, 1, 16})
    public static final class a
      implements Parcelable.Creator
    {
      public final Object createFromParcel(Parcel paramParcel)
      {
        AppMethodBeat.i(254147);
        p.k(paramParcel, "in");
        paramParcel = new NavigatorInterceptor.CheckIsActiveMiniGameIPCArgs(paramParcel.readString(), paramParcel.readInt());
        AppMethodBeat.o(254147);
        return paramParcel;
      }
      
      public final Object[] newArray(int paramInt)
      {
        return new NavigatorInterceptor.CheckIsActiveMiniGameIPCArgs[paramInt];
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/miniprogram_navigator/NavigatorInterceptor$CheckIsActiveMiniGameIPCResult;", "Landroid/os/Parcelable;", "isAlive", "", "isGame", "(ZZ)V", "()Z", "component1", "component2", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-appbrand-integration_release"})
  public static final class CheckIsActiveMiniGameIPCResult
    implements Parcelable
  {
    public static final Parcelable.Creator CREATOR;
    final boolean csz;
    final boolean dfl;
    
    static
    {
      AppMethodBeat.i(276732);
      CREATOR = new a();
      AppMethodBeat.o(276732);
    }
    
    public CheckIsActiveMiniGameIPCResult(boolean paramBoolean1, boolean paramBoolean2)
    {
      this.dfl = paramBoolean1;
      this.csz = paramBoolean2;
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof CheckIsActiveMiniGameIPCResult))
        {
          paramObject = (CheckIsActiveMiniGameIPCResult)paramObject;
          if ((this.dfl != paramObject.dfl) || (this.csz != paramObject.csz)) {}
        }
      }
      else {
        return true;
      }
      return false;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(276729);
      String str = "CheckIsActiveMiniGameIPCResult(isAlive=" + this.dfl + ", isGame=" + this.csz + ")";
      AppMethodBeat.o(276729);
      return str;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    @l(iBK={1, 1, 16})
    public static final class a
      implements Parcelable.Creator
    {
      public final Object createFromParcel(Parcel paramParcel)
      {
        boolean bool2 = true;
        AppMethodBeat.i(268232);
        p.k(paramParcel, "in");
        boolean bool1;
        if (paramParcel.readInt() != 0)
        {
          bool1 = true;
          if (paramParcel.readInt() == 0) {
            break label51;
          }
        }
        for (;;)
        {
          paramParcel = new NavigatorInterceptor.CheckIsActiveMiniGameIPCResult(bool1, bool2);
          AppMethodBeat.o(268232);
          return paramParcel;
          bool1 = false;
          break;
          label51:
          bool2 = false;
        }
      }
      
      public final Object[] newArray(int paramInt)
      {
        return new NavigatorInterceptor.CheckIsActiveMiniGameIPCResult[paramInt];
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "ret", "", "onPermissionReturn"})
  static final class b
    implements b
  {
    b(kotlin.d.d paramd) {}
    
    public final void vu(int paramInt)
    {
      AppMethodBeat.i(273906);
      kotlin.d.d locald = this.oqC;
      Result.Companion localCompanion = Result.Companion;
      locald.resumeWith(Result.constructor-impl(Integer.valueOf(paramInt)));
      AppMethodBeat.o(273906);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "data", "Lcom/tencent/mm/plugin/appbrand/jsapi/miniprogram_navigator/NavigatorInterceptor$CheckIsActiveMiniGameIPCArgs;", "kotlin.jvm.PlatformType", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/plugin/appbrand/jsapi/miniprogram_navigator/NavigatorInterceptor$CheckIsActiveMiniGameIPCResult;", "invoke"})
  static final class c<InputType, ResultType>
    implements com.tencent.mm.ipcinvoker.d<NavigatorInterceptor.CheckIsActiveMiniGameIPCArgs, NavigatorInterceptor.CheckIsActiveMiniGameIPCResult>
  {
    public static final c pds;
    
    static
    {
      AppMethodBeat.i(281619);
      pds = new c();
      AppMethodBeat.o(281619);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<name for destructuring parameter 0>", "Lcom/tencent/mm/plugin/appbrand/jsapi/miniprogram_navigator/NavigatorInterceptor$CheckIsActiveMiniGameIPCResult;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class d<T>
    implements f<NavigatorInterceptor.CheckIsActiveMiniGameIPCResult>
  {
    d(kotlin.d.d paramd) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.NavigatorInterceptor
 * JD-Core Version:    0.7.0.1
 */