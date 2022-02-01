package com.tencent.mm.plugin.appbrand.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenDeclarePromptBundle;", "Landroid/os/Parcelable;", "bizType", "", "funcId", "", "promptTitle", "promptMessage", "promptOkBtnText", "cancelable", "", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getBizType", "()I", "setBizType", "(I)V", "getCancelable", "()Z", "setCancelable", "(Z)V", "getFuncId", "()Ljava/lang/String;", "setFuncId", "(Ljava/lang/String;)V", "getPromptMessage", "setPromptMessage", "getPromptOkBtnText", "setPromptOkBtnText", "getPromptTitle", "setPromptTitle", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "PromptBizType", "api-protocol_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class WeAppOpenDeclarePromptBundle
  implements Parcelable
{
  public static final Parcelable.Creator<WeAppOpenDeclarePromptBundle> CREATOR;
  public boolean dqR;
  public int hyY;
  public String qBb;
  public String qBc;
  public String qBd;
  public String qBe;
  
  static
  {
    AppMethodBeat.i(319293);
    CREATOR = (Parcelable.Creator)new a();
    AppMethodBeat.o(319293);
  }
  
  public WeAppOpenDeclarePromptBundle(byte paramByte)
  {
    this();
  }
  
  public WeAppOpenDeclarePromptBundle(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    this.hyY = paramInt;
    this.qBb = paramString1;
    this.qBc = paramString2;
    this.qBd = paramString3;
    this.qBe = paramString4;
    this.dqR = paramBoolean;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(319301);
    if (this == paramObject)
    {
      AppMethodBeat.o(319301);
      return true;
    }
    if (!(paramObject instanceof WeAppOpenDeclarePromptBundle))
    {
      AppMethodBeat.o(319301);
      return false;
    }
    paramObject = (WeAppOpenDeclarePromptBundle)paramObject;
    if (this.hyY != paramObject.hyY)
    {
      AppMethodBeat.o(319301);
      return false;
    }
    if (!s.p(this.qBb, paramObject.qBb))
    {
      AppMethodBeat.o(319301);
      return false;
    }
    if (!s.p(this.qBc, paramObject.qBc))
    {
      AppMethodBeat.o(319301);
      return false;
    }
    if (!s.p(this.qBd, paramObject.qBd))
    {
      AppMethodBeat.o(319301);
      return false;
    }
    if (!s.p(this.qBe, paramObject.qBe))
    {
      AppMethodBeat.o(319301);
      return false;
    }
    if (this.dqR != paramObject.dqR)
    {
      AppMethodBeat.o(319301);
      return false;
    }
    AppMethodBeat.o(319301);
    return true;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(319297);
    String str = "WeAppOpenDeclarePromptBundle(bizType=" + this.hyY + ", funcI=" + this.qBb + ", promptTitle=" + Util.nullAs(this.qBc, "") + ", promptMessage=" + Util.nullAs(this.qBd, "") + ", promptOkBtnText=" + Util.nullAs(this.qBe, "") + ", cancelabl=" + Util.nullAs(Boolean.valueOf(this.dqR), false);
    AppMethodBeat.o(319297);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(319305);
    s.u(paramParcel, "out");
    paramParcel.writeInt(this.hyY);
    paramParcel.writeString(this.qBb);
    paramParcel.writeString(this.qBc);
    paramParcel.writeString(this.qBd);
    paramParcel.writeString(this.qBe);
    if (this.dqR) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      AppMethodBeat.o(319305);
      return;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Parcelable.Creator<WeAppOpenDeclarePromptBundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.api.WeAppOpenDeclarePromptBundle
 * JD-Core Version:    0.7.0.1
 */