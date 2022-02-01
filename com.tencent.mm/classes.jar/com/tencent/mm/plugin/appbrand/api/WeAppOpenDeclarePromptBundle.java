package com.tencent.mm.plugin.appbrand.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenDeclarePromptBundle;", "Landroid/os/Parcelable;", "bizType", "", "funcId", "", "promptTitle", "promptMessage", "promptOkBtnText", "cancelable", "", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getBizType", "()I", "setBizType", "(I)V", "getCancelable", "()Z", "setCancelable", "(Z)V", "getFuncId", "()Ljava/lang/String;", "setFuncId", "(Ljava/lang/String;)V", "getPromptMessage", "setPromptMessage", "getPromptOkBtnText", "setPromptOkBtnText", "getPromptTitle", "setPromptTitle", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "PromptBizType", "api-protocol_release"})
public final class WeAppOpenDeclarePromptBundle
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR;
  public int eRn;
  public String jFZ;
  public String jGa;
  public String jGb;
  public String jGc;
  public boolean ov;
  
  static
  {
    AppMethodBeat.i(200279);
    CREATOR = new a();
    AppMethodBeat.o(200279);
  }
  
  public WeAppOpenDeclarePromptBundle(byte paramByte)
  {
    this();
  }
  
  public WeAppOpenDeclarePromptBundle(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    this.eRn = paramInt;
    this.jFZ = paramString1;
    this.jGa = paramString2;
    this.jGb = paramString3;
    this.jGc = paramString4;
    this.ov = paramBoolean;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(200277);
    if (this != paramObject)
    {
      if ((paramObject instanceof WeAppOpenDeclarePromptBundle))
      {
        paramObject = (WeAppOpenDeclarePromptBundle)paramObject;
        if ((this.eRn != paramObject.eRn) || (!p.i(this.jFZ, paramObject.jFZ)) || (!p.i(this.jGa, paramObject.jGa)) || (!p.i(this.jGb, paramObject.jGb)) || (!p.i(this.jGc, paramObject.jGc)) || (this.ov != paramObject.ov)) {}
      }
    }
    else
    {
      AppMethodBeat.o(200277);
      return true;
    }
    AppMethodBeat.o(200277);
    return false;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(200275);
    String str = "WeAppOpenDeclarePromptBundle(bizType=" + this.eRn + ", funcI=" + this.jFZ + ", promptTitle=" + bu.bI(this.jGa, "") + ", promptMessage=" + bu.bI(this.jGb, "") + ", promptOkBtnText=" + bu.bI(this.jGc, "") + ", cancelabl=" + bu.a(Boolean.valueOf(this.ov), false);
    AppMethodBeat.o(200275);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  @l(gjZ={1, 1, 16})
  public static final class a
    implements Parcelable.Creator
  {
    public final Object createFromParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(200274);
      p.h(paramParcel, "in");
      int i = paramParcel.readInt();
      String str1 = paramParcel.readString();
      String str2 = paramParcel.readString();
      String str3 = paramParcel.readString();
      String str4 = paramParcel.readString();
      if (paramParcel.readInt() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        paramParcel = new WeAppOpenDeclarePromptBundle(i, str1, str2, str3, str4, bool);
        AppMethodBeat.o(200274);
        return paramParcel;
      }
    }
    
    public final Object[] newArray(int paramInt)
    {
      return new WeAppOpenDeclarePromptBundle[paramInt];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.api.WeAppOpenDeclarePromptBundle
 * JD-Core Version:    0.7.0.1
 */