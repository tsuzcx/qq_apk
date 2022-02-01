package com.tencent.mm.plugin.game;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.commlib.util.b;
import com.tencent.mm.plugin.game.commlib.util.b.a;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.sdk.platformtools.WeChatPermissions;

public final class a
{
  public static final String xtm;
  public static final String xtn;
  public static final String xto;
  
  static
  {
    AppMethodBeat.i(40810);
    xtm = WeChatHosts.domainString(2131761707) + "/cgi-bin/h5/static/gamecenter/detail.html";
    xtn = WeChatPermissions.PERMISSION_MM_MESSAGE();
    xto = b.c(b.a.xvG) + "message/";
    AppMethodBeat.o(40810);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.a
 * JD-Core Version:    0.7.0.1
 */