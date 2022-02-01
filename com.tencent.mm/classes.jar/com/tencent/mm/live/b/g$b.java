package com.tencent.mm.live.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/model/LiveDataManager$LiveFaceVerifyInfo;", "", "needFaceVerify", "", "verifyUrl", "", "isFromAnchor", "(ZLjava/lang/String;Z)V", "()Z", "setFromAnchor", "(Z)V", "getNeedFaceVerify", "setNeedFaceVerify", "getVerifyUrl", "()Ljava/lang/String;", "setVerifyUrl", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "plugin-logic_release"})
public final class g$b
{
  public boolean gOw;
  public String gOx;
  public boolean gOy;
  
  private g$b(String paramString)
  {
    AppMethodBeat.i(212052);
    this.gOw = false;
    this.gOx = paramString;
    this.gOy = true;
    AppMethodBeat.o(212052);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(212056);
    if (this != paramObject)
    {
      if ((paramObject instanceof b))
      {
        paramObject = (b)paramObject;
        if ((this.gOw != paramObject.gOw) || (!p.i(this.gOx, paramObject.gOx)) || (this.gOy != paramObject.gOy)) {}
      }
    }
    else
    {
      AppMethodBeat.o(212056);
      return true;
    }
    AppMethodBeat.o(212056);
    return false;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(212054);
    String str = "LiveFaceVerifyInfo(needFaceVerify=" + this.gOw + ", verifyUrl=" + this.gOx + ", isFromAnchor=" + this.gOy + ")";
    AppMethodBeat.o(212054);
    return str;
  }
  
  public final void xK(String paramString)
  {
    AppMethodBeat.i(212051);
    p.h(paramString, "<set-?>");
    this.gOx = paramString;
    AppMethodBeat.o(212051);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.g.b
 * JD-Core Version:    0.7.0.1
 */