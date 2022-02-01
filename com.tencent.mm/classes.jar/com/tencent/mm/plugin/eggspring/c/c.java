package com.tencent.mm.plugin.eggspring.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/eggspring/model/LuckyBagInfo;", "", "keyword", "", "traceId", "appId", "hasLuckyBag", "", "interval", "", "url", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZILjava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "setAppId", "(Ljava/lang/String;)V", "getHasLuckyBag", "()Z", "getInterval", "()I", "getKeyword", "getTraceId", "getUrl", "setUrl", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "Companion", "plugin-eggspring_release"})
public final class c
{
  public static final a uxS;
  public String appId;
  public final String fwe;
  public final int interval;
  public final String nTp;
  public String url;
  public final boolean uxR;
  
  static
  {
    AppMethodBeat.i(108152);
    uxS = new a((byte)0);
    AppMethodBeat.o(108152);
  }
  
  public c()
  {
    this(null, null, null, false, 0, 63);
  }
  
  private c(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(249463);
    this.fwe = paramString1;
    this.nTp = paramString2;
    this.appId = paramString3;
    this.uxR = paramBoolean;
    this.interval = paramInt;
    this.url = null;
    AppMethodBeat.o(249463);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(249469);
    if (this != paramObject)
    {
      if ((paramObject instanceof c))
      {
        paramObject = (c)paramObject;
        if ((!p.h(this.fwe, paramObject.fwe)) || (!p.h(this.nTp, paramObject.nTp)) || (!p.h(this.appId, paramObject.appId)) || (this.uxR != paramObject.uxR) || (this.interval != paramObject.interval) || (!p.h(this.url, paramObject.url))) {}
      }
    }
    else
    {
      AppMethodBeat.o(249469);
      return true;
    }
    AppMethodBeat.o(249469);
    return false;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(108151);
    String str = "LuckyBagInfo(keyword=" + this.fwe + ", traceId=" + this.nTp + ", appId=" + this.appId + ", hasLuckyBag=" + this.uxR + ", interval=" + this.interval + ", url=" + this.url + ")";
    AppMethodBeat.o(108151);
    return str;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/eggspring/model/LuckyBagInfo$Companion;", "", "()V", "HAS_LUCKY_BAG", "", "NO_LUCKY_BAG", "plugin-eggspring_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.eggspring.c.c
 * JD-Core Version:    0.7.0.1
 */