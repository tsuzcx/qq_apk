package com.tencent.luggage.sdk.processes.main;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/luggage/sdk/processes/main/RuntimeInfo;", "Landroid/os/Parcelable;", "processIndex", "", "appId", "", "versionType", "isGame", "", "appType", "instanceId", "userName", "initConfig", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfig;", "isPersistentApp", "stackTrace", "(ILjava/lang/String;IZILjava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfig;ZLjava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getAppType", "()I", "getInitConfig", "()Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfig;", "getInstanceId", "()Z", "getProcessIndex", "getStackTrace", "getUserName", "getVersionType", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "luggage-wechat-full-sdk_release"})
public final class RuntimeInfo
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR;
  public final String appId;
  private final int appType;
  public final String cBH;
  final int cBU;
  public final AppBrandInitConfig cCf;
  private final String cCg;
  private final boolean csz;
  final int cxa;
  final boolean cxb;
  public final String userName;
  
  static
  {
    AppMethodBeat.i(233963);
    CREATOR = new a();
    AppMethodBeat.o(233963);
  }
  
  public RuntimeInfo(int paramInt1, String paramString1, int paramInt2, boolean paramBoolean1, int paramInt3, String paramString2, String paramString3, AppBrandInitConfig paramAppBrandInitConfig, boolean paramBoolean2, String paramString4)
  {
    AppMethodBeat.i(233953);
    this.cxa = paramInt1;
    this.appId = paramString1;
    this.cBU = paramInt2;
    this.csz = paramBoolean1;
    this.appType = paramInt3;
    this.cBH = paramString2;
    this.userName = paramString3;
    this.cCf = paramAppBrandInitConfig;
    this.cxb = paramBoolean2;
    this.cCg = paramString4;
    AppMethodBeat.o(233953);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(233957);
    if (this != paramObject)
    {
      if ((paramObject instanceof RuntimeInfo))
      {
        paramObject = (RuntimeInfo)paramObject;
        if ((this.cxa != paramObject.cxa) || (!p.h(this.appId, paramObject.appId)) || (this.cBU != paramObject.cBU) || (this.csz != paramObject.csz) || (this.appType != paramObject.appType) || (!p.h(this.cBH, paramObject.cBH)) || (!p.h(this.userName, paramObject.userName)) || (!p.h(this.cCf, paramObject.cCf)) || (this.cxb != paramObject.cxb) || (!p.h(this.cCg, paramObject.cCg))) {}
      }
    }
    else
    {
      AppMethodBeat.o(233957);
      return true;
    }
    AppMethodBeat.o(233957);
    return false;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(233954);
    String str = "RuntimeInfo(processIndex=" + this.cxa + ", appId=" + this.appId + ", versionType=" + this.cBU + ", isGame=" + this.csz + ", appType=" + this.appType + ", instanceId=" + this.cBH + ", userName=" + this.userName + ", initConfig=" + this.cCf + ", isPersistentApp=" + this.cxb + ", stackTrace=" + this.cCg + ")";
    AppMethodBeat.o(233954);
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
      AppMethodBeat.i(249499);
      p.k(paramParcel, "in");
      int i = paramParcel.readInt();
      String str1 = paramParcel.readString();
      int j = paramParcel.readInt();
      boolean bool1;
      int k;
      String str2;
      String str3;
      AppBrandInitConfig localAppBrandInitConfig;
      if (paramParcel.readInt() != 0)
      {
        bool1 = true;
        k = paramParcel.readInt();
        str2 = paramParcel.readString();
        str3 = paramParcel.readString();
        localAppBrandInitConfig = (AppBrandInitConfig)paramParcel.readParcelable(RuntimeInfo.class.getClassLoader());
        if (paramParcel.readInt() == 0) {
          break label120;
        }
      }
      for (;;)
      {
        paramParcel = new RuntimeInfo(i, str1, j, bool1, k, str2, str3, localAppBrandInitConfig, bool2, paramParcel.readString());
        AppMethodBeat.o(249499);
        return paramParcel;
        bool1 = false;
        break;
        label120:
        bool2 = false;
      }
    }
    
    public final Object[] newArray(int paramInt)
    {
      return new RuntimeInfo[paramInt];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.sdk.processes.main.RuntimeInfo
 * JD-Core Version:    0.7.0.1
 */