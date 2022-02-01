package com.tencent.mm.plugin.eggspring.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/eggspring/model/LuckyBagInfo;", "", "()V", "appId", "", "getAppId", "()Ljava/lang/String;", "setAppId", "(Ljava/lang/String;)V", "hasLuckyBag", "", "getHasLuckyBag", "()Z", "setHasLuckyBag", "(Z)V", "interval", "", "getInterval", "()I", "setInterval", "(I)V", "keyWord", "getKeyWord", "setKeyWord", "traceId", "getTraceId", "setTraceId", "toString", "Companion", "plugin-eggspring_release"})
public final class c
{
  public static final c.a oVz;
  public String appId;
  public int gbd = 10;
  public String hPI;
  public String jyU;
  public boolean oVy;
  
  static
  {
    AppMethodBeat.i(108152);
    oVz = new c.a((byte)0);
    AppMethodBeat.o(108152);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(108151);
    String str = "LuckyBagInfo(hasLuckyBag=" + this.oVy + ", traceId=" + this.jyU + ", interval=" + this.gbd + ", keyWord=" + this.hPI + ", appId=" + this.appId + ')';
    AppMethodBeat.o(108151);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.eggspring.b.c
 * JD-Core Version:    0.7.0.1
 */