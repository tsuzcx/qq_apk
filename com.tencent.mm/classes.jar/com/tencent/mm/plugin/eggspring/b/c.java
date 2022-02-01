package com.tencent.mm.plugin.eggspring.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/eggspring/model/LuckyBagInfo;", "", "()V", "appId", "", "getAppId", "()Ljava/lang/String;", "setAppId", "(Ljava/lang/String;)V", "hasLuckyBag", "", "getHasLuckyBag", "()Z", "setHasLuckyBag", "(Z)V", "interval", "", "getInterval", "()I", "setInterval", "(I)V", "keyWord", "getKeyWord", "setKeyWord", "traceId", "getTraceId", "setTraceId", "toString", "Companion", "plugin-eggspring_release"})
public final class c
{
  public static final a orZ;
  public String appId;
  public int fWw = 10;
  public String hpg;
  public String iYE;
  public boolean orY;
  
  static
  {
    AppMethodBeat.i(108152);
    orZ = new a((byte)0);
    AppMethodBeat.o(108152);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(108151);
    String str = "LuckyBagInfo(hasLuckyBag=" + this.orY + ", traceId=" + this.iYE + ", interval=" + this.fWw + ", keyWord=" + this.hpg + ", appId=" + this.appId + ')';
    AppMethodBeat.o(108151);
    return str;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/eggspring/model/LuckyBagInfo$Companion;", "", "()V", "HAS_LUCKY_BAG", "", "NO_LUCKY_BAG", "plugin-eggspring_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.eggspring.b.c
 * JD-Core Version:    0.7.0.1
 */