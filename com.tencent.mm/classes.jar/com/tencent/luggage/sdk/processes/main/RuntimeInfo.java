package com.tencent.luggage.sdk.processes.main;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/luggage/sdk/processes/main/RuntimeInfo;", "Landroid/os/Parcelable;", "processIndex", "", "appId", "", "versionType", "isGame", "", "appType", "instanceId", "userName", "initConfig", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfig;", "isPersistentApp", "stackTrace", "(ILjava/lang/String;IZILjava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfig;ZLjava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getAppType", "()I", "getInitConfig", "()Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfig;", "getInstanceId", "()Z", "getProcessIndex", "getStackTrace", "getUserName", "getVersionType", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class RuntimeInfo
  implements Parcelable
{
  public static final Parcelable.Creator<RuntimeInfo> CREATOR;
  public final String appId;
  private final int appType;
  private final boolean ekt;
  final int epc;
  final boolean epd;
  public final AppBrandInitConfig euK;
  private final String euL;
  public final String eup;
  public final int euz;
  public final String userName;
  
  static
  {
    AppMethodBeat.i(220517);
    CREATOR = (Parcelable.Creator)new a();
    AppMethodBeat.o(220517);
  }
  
  public RuntimeInfo(int paramInt1, String paramString1, int paramInt2, boolean paramBoolean1, int paramInt3, String paramString2, String paramString3, AppBrandInitConfig paramAppBrandInitConfig, boolean paramBoolean2, String paramString4)
  {
    AppMethodBeat.i(220510);
    this.epc = paramInt1;
    this.appId = paramString1;
    this.euz = paramInt2;
    this.ekt = paramBoolean1;
    this.appType = paramInt3;
    this.eup = paramString2;
    this.userName = paramString3;
    this.euK = paramAppBrandInitConfig;
    this.epd = paramBoolean2;
    this.euL = paramString4;
    AppMethodBeat.o(220510);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(220529);
    if (this == paramObject)
    {
      AppMethodBeat.o(220529);
      return true;
    }
    if (!(paramObject instanceof RuntimeInfo))
    {
      AppMethodBeat.o(220529);
      return false;
    }
    paramObject = (RuntimeInfo)paramObject;
    if (this.epc != paramObject.epc)
    {
      AppMethodBeat.o(220529);
      return false;
    }
    if (!s.p(this.appId, paramObject.appId))
    {
      AppMethodBeat.o(220529);
      return false;
    }
    if (this.euz != paramObject.euz)
    {
      AppMethodBeat.o(220529);
      return false;
    }
    if (this.ekt != paramObject.ekt)
    {
      AppMethodBeat.o(220529);
      return false;
    }
    if (this.appType != paramObject.appType)
    {
      AppMethodBeat.o(220529);
      return false;
    }
    if (!s.p(this.eup, paramObject.eup))
    {
      AppMethodBeat.o(220529);
      return false;
    }
    if (!s.p(this.userName, paramObject.userName))
    {
      AppMethodBeat.o(220529);
      return false;
    }
    if (!s.p(this.euK, paramObject.euK))
    {
      AppMethodBeat.o(220529);
      return false;
    }
    if (this.epd != paramObject.epd)
    {
      AppMethodBeat.o(220529);
      return false;
    }
    if (!s.p(this.euL, paramObject.euL))
    {
      AppMethodBeat.o(220529);
      return false;
    }
    AppMethodBeat.o(220529);
    return true;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(220521);
    String str = "RuntimeInfo(processIndex=" + this.epc + ", appId=" + this.appId + ", versionType=" + this.euz + ", isGame=" + this.ekt + ", appType=" + this.appType + ", instanceId=" + this.eup + ", userName=" + this.userName + ", initConfig=" + this.euK + ", isPersistentApp=" + this.epd + ", stackTrace=" + this.euL + ')';
    AppMethodBeat.o(220521);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int j = 1;
    AppMethodBeat.i(220541);
    s.u(paramParcel, "out");
    paramParcel.writeInt(this.epc);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.euz);
    int i;
    if (this.ekt)
    {
      i = 1;
      paramParcel.writeInt(i);
      paramParcel.writeInt(this.appType);
      paramParcel.writeString(this.eup);
      paramParcel.writeString(this.userName);
      paramParcel.writeParcelable((Parcelable)this.euK, paramInt);
      if (!this.epd) {
        break label122;
      }
    }
    label122:
    for (paramInt = j;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.euL);
      AppMethodBeat.o(220541);
      return;
      i = 0;
      break;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Parcelable.Creator<RuntimeInfo>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.sdk.processes.main.RuntimeInfo
 * JD-Core Version:    0.7.0.1
 */