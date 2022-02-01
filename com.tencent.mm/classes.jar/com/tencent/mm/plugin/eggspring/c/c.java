package com.tencent.mm.plugin.eggspring.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/eggspring/model/LuckyBagInfo;", "", "keyword", "", "traceId", "appId", "hasLuckyBag", "", "interval", "", "url", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZILjava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "setAppId", "(Ljava/lang/String;)V", "getHasLuckyBag", "()Z", "getInterval", "()I", "getKeyword", "getTraceId", "getUrl", "setUrl", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "Companion", "plugin-eggspring_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final a xEC;
  public String appId;
  public final String hAB;
  private final int interval;
  public final String qTb;
  public String url;
  private final boolean xED;
  
  static
  {
    AppMethodBeat.i(108152);
    xEC = new a((byte)0);
    AppMethodBeat.o(108152);
  }
  
  public c()
  {
    this(null, null, null, false, 0, 63);
  }
  
  private c(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(266504);
    this.hAB = paramString1;
    this.qTb = paramString2;
    this.appId = paramString3;
    this.xED = paramBoolean;
    this.interval = paramInt;
    this.url = null;
    AppMethodBeat.o(266504);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(266527);
    if (this == paramObject)
    {
      AppMethodBeat.o(266527);
      return true;
    }
    if (!(paramObject instanceof c))
    {
      AppMethodBeat.o(266527);
      return false;
    }
    paramObject = (c)paramObject;
    if (!s.p(this.hAB, paramObject.hAB))
    {
      AppMethodBeat.o(266527);
      return false;
    }
    if (!s.p(this.qTb, paramObject.qTb))
    {
      AppMethodBeat.o(266527);
      return false;
    }
    if (!s.p(this.appId, paramObject.appId))
    {
      AppMethodBeat.o(266527);
      return false;
    }
    if (this.xED != paramObject.xED)
    {
      AppMethodBeat.o(266527);
      return false;
    }
    if (this.interval != paramObject.interval)
    {
      AppMethodBeat.o(266527);
      return false;
    }
    if (!s.p(this.url, paramObject.url))
    {
      AppMethodBeat.o(266527);
      return false;
    }
    AppMethodBeat.o(266527);
    return true;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(108151);
    String str = "LuckyBagInfo(keyword=" + this.hAB + ", traceId=" + this.qTb + ", appId=" + this.appId + ", hasLuckyBag=" + this.xED + ", interval=" + this.interval + ", url=" + this.url + ')';
    AppMethodBeat.o(108151);
    return str;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/eggspring/model/LuckyBagInfo$Companion;", "", "()V", "HAS_LUCKY_BAG", "", "NO_LUCKY_BAG", "plugin-eggspring_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.eggspring.c.c
 * JD-Core Version:    0.7.0.1
 */