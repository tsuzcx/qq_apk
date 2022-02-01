package com.tencent.luggage.sdk.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.y;
import com.tencent.mm.plugin.appbrand.config.z;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/luggage/sdk/config/AppBrandInitWindowConfig;", "Landroid/os/Parcelable;", "isNavigationBarColorAssigned", "", "navigationBarColor", "", "windowOpacity", "Lcom/tencent/mm/plugin/appbrand/config/WindowOpacity;", "windowBackgroundImageFilePath", "", "windowScreenOrientationLocked", "enterAnimation", "Lcom/tencent/mm/plugin/appbrand/config/WindowAnimationStyle;", "exitAnimation", "(ZILcom/tencent/mm/plugin/appbrand/config/WindowOpacity;Ljava/lang/String;ZLcom/tencent/mm/plugin/appbrand/config/WindowAnimationStyle;Lcom/tencent/mm/plugin/appbrand/config/WindowAnimationStyle;)V", "getEnterAnimation", "()Lcom/tencent/mm/plugin/appbrand/config/WindowAnimationStyle;", "setEnterAnimation", "(Lcom/tencent/mm/plugin/appbrand/config/WindowAnimationStyle;)V", "getExitAnimation", "setExitAnimation", "()Z", "setNavigationBarColorAssigned", "(Z)V", "getNavigationBarColor", "()I", "setNavigationBarColor", "(I)V", "getWindowBackgroundImageFilePath", "()Ljava/lang/String;", "setWindowBackgroundImageFilePath", "(Ljava/lang/String;)V", "getWindowOpacity", "()Lcom/tencent/mm/plugin/appbrand/config/WindowOpacity;", "setWindowOpacity", "(Lcom/tencent/mm/plugin/appbrand/config/WindowOpacity;)V", "getWindowScreenOrientationLocked", "setWindowScreenOrientationLocked", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class AppBrandInitWindowConfig
  implements Parcelable
{
  public static final Parcelable.Creator<AppBrandInitWindowConfig> CREATOR;
  public boolean epo;
  public int epp;
  z epq;
  String epr;
  public boolean eps;
  y ept;
  y epu;
  
  static
  {
    AppMethodBeat.i(220239);
    CREATOR = (Parcelable.Creator)new a();
    AppMethodBeat.o(220239);
  }
  
  public AppBrandInitWindowConfig()
  {
    this(null, null, false, null, null, 127);
  }
  
  public AppBrandInitWindowConfig(boolean paramBoolean1, int paramInt, z paramz, String paramString, boolean paramBoolean2, y paramy1, y paramy2)
  {
    AppMethodBeat.i(220231);
    this.epo = paramBoolean1;
    this.epp = paramInt;
    this.epq = paramz;
    this.epr = paramString;
    this.eps = paramBoolean2;
    this.ept = paramy1;
    this.epu = paramy2;
    AppMethodBeat.o(220231);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(220250);
    if (this == paramObject)
    {
      AppMethodBeat.o(220250);
      return true;
    }
    if (!(paramObject instanceof AppBrandInitWindowConfig))
    {
      AppMethodBeat.o(220250);
      return false;
    }
    paramObject = (AppBrandInitWindowConfig)paramObject;
    if (this.epo != paramObject.epo)
    {
      AppMethodBeat.o(220250);
      return false;
    }
    if (this.epp != paramObject.epp)
    {
      AppMethodBeat.o(220250);
      return false;
    }
    if (this.epq != paramObject.epq)
    {
      AppMethodBeat.o(220250);
      return false;
    }
    if (!s.p(this.epr, paramObject.epr))
    {
      AppMethodBeat.o(220250);
      return false;
    }
    if (this.eps != paramObject.eps)
    {
      AppMethodBeat.o(220250);
      return false;
    }
    if (this.ept != paramObject.ept)
    {
      AppMethodBeat.o(220250);
      return false;
    }
    if (this.epu != paramObject.epu)
    {
      AppMethodBeat.o(220250);
      return false;
    }
    AppMethodBeat.o(220250);
    return true;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(220242);
    StringBuilder localStringBuilder;
    Object localObject;
    if (this.epo)
    {
      localStringBuilder = new StringBuilder("navigationBarColor:").append(this.epp);
      localObject = ", ";
    }
    for (;;)
    {
      localObject = s.X("AppBrandInitWindowConfig(", (String)localObject);
      AppMethodBeat.o(220242);
      return localObject;
      localStringBuilder = new StringBuilder("windowOpacity:").append(this.epq).append(", ");
      localObject = (CharSequence)this.epr;
      if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label135;
        }
        localObject = "windowBackgroundImageFilePath:" + this.epr + ", ";
        break;
      }
      label135:
      localObject = ")";
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(220255);
    s.u(paramParcel, "out");
    if (this.epo)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.epp);
      f localf = f.eqr;
      f.a(this.epq, paramParcel);
      paramParcel.writeString(this.epr);
      if (!this.eps) {
        break label103;
      }
    }
    label103:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.ept.name());
      paramParcel.writeString(this.epu.name());
      AppMethodBeat.o(220255);
      return;
      paramInt = 0;
      break;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Parcelable.Creator<AppBrandInitWindowConfig>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.sdk.config.AppBrandInitWindowConfig
 * JD-Core Version:    0.7.0.1
 */