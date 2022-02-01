package com.tencent.mm.live.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/model/RoomLiveService$LiveFaceVerifyInfo;", "", "needFaceVerify", "", "verifyUrl", "", "isFromAnchor", "(ZLjava/lang/String;Z)V", "()Z", "setFromAnchor", "(Z)V", "getNeedFaceVerify", "setNeedFaceVerify", "getVerifyUrl", "()Ljava/lang/String;", "setVerifyUrl", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class u$b
{
  public boolean naf;
  public String nag;
  public boolean nah;
  
  private u$b(String paramString)
  {
    AppMethodBeat.i(246670);
    this.naf = false;
    this.nag = paramString;
    this.nah = true;
    AppMethodBeat.o(246670);
  }
  
  public final void Gu(String paramString)
  {
    AppMethodBeat.i(246685);
    s.u(paramString, "<set-?>");
    this.nag = paramString;
    AppMethodBeat.o(246685);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(246716);
    if (this == paramObject)
    {
      AppMethodBeat.o(246716);
      return true;
    }
    if (!(paramObject instanceof b))
    {
      AppMethodBeat.o(246716);
      return false;
    }
    paramObject = (b)paramObject;
    if (this.naf != paramObject.naf)
    {
      AppMethodBeat.o(246716);
      return false;
    }
    if (!s.p(this.nag, paramObject.nag))
    {
      AppMethodBeat.o(246716);
      return false;
    }
    if (this.nah != paramObject.nah)
    {
      AppMethodBeat.o(246716);
      return false;
    }
    AppMethodBeat.o(246716);
    return true;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(246698);
    String str = "LiveFaceVerifyInfo(needFaceVerify=" + this.naf + ", verifyUrl=" + this.nag + ", isFromAnchor=" + this.nah + ')';
    AppMethodBeat.o(246698);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.model.u.b
 * JD-Core Version:    0.7.0.1
 */