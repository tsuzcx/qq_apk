package com.tencent.mm.plugin.eggspring.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/eggspring/model/LuckyBagInfo;", "", "keyword", "", "traceId", "appId", "hasLuckyBag", "", "interval", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZI)V", "getAppId", "()Ljava/lang/String;", "setAppId", "(Ljava/lang/String;)V", "getHasLuckyBag", "()Z", "getInterval", "()I", "getKeyword", "getTraceId", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "Companion", "plugin-eggspring_release"})
public final class c
{
  public static final a qVf;
  public String appId;
  public final String dDv;
  public final int gTn;
  public final String kZe;
  private final boolean qVe;
  
  static
  {
    AppMethodBeat.i(108152);
    qVf = new a((byte)0);
    AppMethodBeat.o(108152);
  }
  
  public c(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(194571);
    this.dDv = paramString1;
    this.kZe = paramString2;
    this.appId = paramString3;
    this.qVe = true;
    this.gTn = paramInt;
    AppMethodBeat.o(194571);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(194573);
    if (this != paramObject)
    {
      if ((paramObject instanceof c))
      {
        paramObject = (c)paramObject;
        if ((!p.j(this.dDv, paramObject.dDv)) || (!p.j(this.kZe, paramObject.kZe)) || (!p.j(this.appId, paramObject.appId)) || (this.qVe != paramObject.qVe) || (this.gTn != paramObject.gTn)) {}
      }
    }
    else
    {
      AppMethodBeat.o(194573);
      return true;
    }
    AppMethodBeat.o(194573);
    return false;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(108151);
    String str = "LuckyBagInfo(keyword=" + this.dDv + ", traceId=" + this.kZe + ", appId=" + this.appId + ", hasLuckyBag=" + this.qVe + ", interval=" + this.gTn + ")";
    AppMethodBeat.o(108151);
    return str;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/eggspring/model/LuckyBagInfo$Companion;", "", "()V", "HAS_LUCKY_BAG", "", "NO_LUCKY_BAG", "plugin-eggspring_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.eggspring.c.c
 * JD-Core Version:    0.7.0.1
 */