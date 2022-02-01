package com.tencent.mm.plugin.eggspring.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/eggspring/model/LuckyBagInfo;", "", "()V", "appId", "", "getAppId", "()Ljava/lang/String;", "setAppId", "(Ljava/lang/String;)V", "hasLuckyBag", "", "getHasLuckyBag", "()Z", "setHasLuckyBag", "(Z)V", "interval", "", "getInterval", "()I", "setInterval", "(I)V", "keyWord", "getKeyWord", "setKeyWord", "traceId", "getTraceId", "setTraceId", "toString", "Companion", "plugin-eggspring_release"})
public final class c
{
  public static final a pzj;
  public String appId;
  public int guN = 10;
  public String iiW;
  public String jSR;
  public boolean pzi;
  
  static
  {
    AppMethodBeat.i(108152);
    pzj = new a((byte)0);
    AppMethodBeat.o(108152);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(108151);
    String str = "LuckyBagInfo(hasLuckyBag=" + this.pzi + ", traceId=" + this.jSR + ", interval=" + this.guN + ", keyWord=" + this.iiW + ", appId=" + this.appId + ')';
    AppMethodBeat.o(108151);
    return str;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/eggspring/model/LuckyBagInfo$Companion;", "", "()V", "HAS_LUCKY_BAG", "", "NO_LUCKY_BAG", "plugin-eggspring_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.eggspring.b.c
 * JD-Core Version:    0.7.0.1
 */