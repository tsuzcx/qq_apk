package com.tencent.mm.network;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.j.b;
import com.tencent.mm.sdk.platformtools.WeChatHosts;

public final class c
{
  public static final String pnD;
  public static final int[] pnE;
  public static final String pnF;
  public static final int[] pnG;
  
  static
  {
    AppMethodBeat.i(241165);
    pnD = WeChatHosts.domainString(j.b.host_long_weixin_qq_com);
    pnE = new int[] { 8080, 80, 443 };
    pnF = WeChatHosts.domainString(j.b.host_short_weixin_qq_com);
    pnG = new int[] { 80 };
    AppMethodBeat.o(241165);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.network.c
 * JD-Core Version:    0.7.0.1
 */