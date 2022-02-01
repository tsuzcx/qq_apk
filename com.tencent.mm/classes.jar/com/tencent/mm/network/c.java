package com.tencent.mm.network;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.j.b;
import com.tencent.mm.sdk.platformtools.WeChatHosts;

public final class c
{
  public static final String kRi;
  public static final String muj;
  public static final int[] muk;
  public static final String mul;
  public static final int[] mum;
  
  static
  {
    AppMethodBeat.i(193870);
    muj = WeChatHosts.domainString(j.b.host_long_weixin_qq_com);
    kRi = com.tencent.mm.loader.j.c.kRi;
    muk = new int[] { 8080, 80, 443 };
    mul = WeChatHosts.domainString(j.b.host_short_weixin_qq_com);
    mum = new int[] { 80 };
    AppMethodBeat.o(193870);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.network.c
 * JD-Core Version:    0.7.0.1
 */