package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.model.gdpr.b;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.r;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bu;
import kotlinx.coroutines.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/miniprogram_navigator/NavigatorInterceptor;", "", "()V", "checkGdprPolicy", "", "context", "Landroid/content/Context;", "toAppId", "", "(Landroid/content/Context;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkIsActiveMiniGame", "Lkotlin/Pair;", "", "toVersionType", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleIntercept", "", "service", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "args", "Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;", "callback", "Lcom/tencent/mm/plugin/appbrand/jsapi/miniprogram_navigator/IMiniProgramNavigator$NavigationHandler;", "CheckIsActiveMiniGameIPCArgs", "CheckIsActiveMiniGameIPCResult", "MMLaunchEntryProxyRequest", "MMLaunchEntryProxyTask", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class NavigatorInterceptor
{
  public static final NavigatorInterceptor siH;
  
  static
  {
    AppMethodBeat.i(326285);
    siH = new NavigatorInterceptor();
    AppMethodBeat.o(326285);
  }
  
  public static void b(g paramg, LaunchParcel paramLaunchParcel, c.b paramb)
  {
    AppMethodBeat.i(326264);
    s.u(paramg, "service");
    s.u(paramLaunchParcel, "args");
    s.u(paramb, "callback");
    j.a((aq)bu.ajwo, null, null, (m)new NavigatorInterceptor.e(paramg, paramLaunchParcel, paramb, null), 3);
    AppMethodBeat.o(326264);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/miniprogram_navigator/NavigatorInterceptor$CheckIsActiveMiniGameIPCArgs;", "Landroid/os/Parcelable;", "appId", "", "versionType", "", "(Ljava/lang/String;I)V", "getAppId", "()Ljava/lang/String;", "getVersionType", "()I", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class CheckIsActiveMiniGameIPCArgs
    implements Parcelable
  {
    public static final Parcelable.Creator<CheckIsActiveMiniGameIPCArgs> CREATOR;
    final String appId;
    final int euz;
    
    static
    {
      AppMethodBeat.i(326257);
      CREATOR = (Parcelable.Creator)new a();
      AppMethodBeat.o(326257);
    }
    
    public CheckIsActiveMiniGameIPCArgs(String paramString, int paramInt)
    {
      AppMethodBeat.i(326253);
      this.appId = paramString;
      this.euz = paramInt;
      AppMethodBeat.o(326253);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(326277);
      if (this == paramObject)
      {
        AppMethodBeat.o(326277);
        return true;
      }
      if (!(paramObject instanceof CheckIsActiveMiniGameIPCArgs))
      {
        AppMethodBeat.o(326277);
        return false;
      }
      paramObject = (CheckIsActiveMiniGameIPCArgs)paramObject;
      if (!s.p(this.appId, paramObject.appId))
      {
        AppMethodBeat.o(326277);
        return false;
      }
      if (this.euz != paramObject.euz)
      {
        AppMethodBeat.o(326277);
        return false;
      }
      AppMethodBeat.o(326277);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(326269);
      int i = this.appId.hashCode();
      int j = this.euz;
      AppMethodBeat.o(326269);
      return i * 31 + j;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(326262);
      String str = "CheckIsActiveMiniGameIPCArgs(appId=" + this.appId + ", versionType=" + this.euz + ')';
      AppMethodBeat.o(326262);
      return str;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(326287);
      s.u(paramParcel, "out");
      paramParcel.writeString(this.appId);
      paramParcel.writeInt(this.euz);
      AppMethodBeat.o(326287);
    }
    
    @Metadata(k=3, mv={1, 5, 1}, xi=48)
    public static final class a
      implements Parcelable.Creator<NavigatorInterceptor.CheckIsActiveMiniGameIPCArgs>
    {}
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/miniprogram_navigator/NavigatorInterceptor$CheckIsActiveMiniGameIPCResult;", "Landroid/os/Parcelable;", "isAlive", "", "isGame", "(ZZ)V", "()Z", "component1", "component2", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class CheckIsActiveMiniGameIPCResult
    implements Parcelable
  {
    public static final Parcelable.Creator<CheckIsActiveMiniGameIPCResult> CREATOR;
    final boolean ekt;
    final boolean fez;
    
    static
    {
      AppMethodBeat.i(326273);
      CREATOR = (Parcelable.Creator)new a();
      AppMethodBeat.o(326273);
    }
    
    public CheckIsActiveMiniGameIPCResult(boolean paramBoolean1, boolean paramBoolean2)
    {
      this.fez = paramBoolean1;
      this.ekt = paramBoolean2;
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if (!(paramObject instanceof CheckIsActiveMiniGameIPCResult)) {
          return false;
        }
        paramObject = (CheckIsActiveMiniGameIPCResult)paramObject;
        if (this.fez != paramObject.fez) {
          return false;
        }
      } while (this.ekt == paramObject.ekt);
      return false;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(326283);
      String str = "CheckIsActiveMiniGameIPCResult(isAlive=" + this.fez + ", isGame=" + this.ekt + ')';
      AppMethodBeat.o(326283);
      return str;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      int i = 1;
      AppMethodBeat.i(326301);
      s.u(paramParcel, "out");
      if (this.fez)
      {
        paramInt = 1;
        paramParcel.writeInt(paramInt);
        if (!this.ekt) {
          break label52;
        }
      }
      label52:
      for (paramInt = i;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        AppMethodBeat.o(326301);
        return;
        paramInt = 0;
        break;
      }
    }
    
    @Metadata(k=3, mv={1, 5, 1}, xi=48)
    public static final class a
      implements Parcelable.Creator<NavigatorInterceptor.CheckIsActiveMiniGameIPCResult>
    {}
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "ret", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    implements b
  {
    b(kotlin.d.d<? super Integer> paramd) {}
    
    public final void onPermissionReturn(int paramInt)
    {
      AppMethodBeat.i(326261);
      kotlin.d.d locald = this.msc;
      Result.Companion localCompanion = Result.Companion;
      locald.resumeWith(Result.constructor-impl(Integer.valueOf(paramInt)));
      AppMethodBeat.o(326261);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "data", "Lcom/tencent/mm/plugin/appbrand/jsapi/miniprogram_navigator/NavigatorInterceptor$CheckIsActiveMiniGameIPCArgs;", "kotlin.jvm.PlatformType", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/plugin/appbrand/jsapi/miniprogram_navigator/NavigatorInterceptor$CheckIsActiveMiniGameIPCResult;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c<InputType, ResultType>
    implements com.tencent.mm.ipcinvoker.d
  {
    public static final c<InputType, ResultType> siJ;
    
    static
    {
      AppMethodBeat.i(326268);
      siJ = new c();
      AppMethodBeat.o(326268);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "<name for destructuring parameter 0>", "Lcom/tencent/mm/plugin/appbrand/jsapi/miniprogram_navigator/NavigatorInterceptor$CheckIsActiveMiniGameIPCResult;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d<T>
    implements f
  {
    d(kotlin.d.d<? super r<Boolean, Boolean>> paramd) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.NavigatorInterceptor
 * JD-Core Version:    0.7.0.1
 */