package com.tencent.mm.console;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.xweb.c;

class b$a
  implements b
{
  public void invoke(Object paramObject, com.tencent.mm.ipcinvoker.d paramd)
  {
    AppMethodBeat.i(231506);
    com.tencent.xweb.d.lA(MMApplicationContext.getContext());
    Log.i("MicroMsg.CommandProcessor", "ClearGameA8keyCookie before, cookie : %s", new Object[] { c.hsp().getCookie("." + WeChatHosts.domainString(2131761707)) });
    c.hsp().setCookie("." + WeChatHosts.domainString(2131761707), "cookie_passkey=; max-age=0");
    c.hsp().setCookie("." + WeChatHosts.domainString(2131761707), "uin=; max-age=0; httponly");
    c.hsp().setCookie("." + WeChatHosts.domainString(2131761707), "key=; max-age=0; httponly");
    c.hsp().setCookie("." + WeChatHosts.domainString(2131761707), "pass_ticket=; max-age=0; httponly");
    com.tencent.xweb.d.hsr();
    com.tencent.xweb.d.sync();
    Log.i("MicroMsg.CommandProcessor", "ClearGameA8keyCookie end, cookie : %s", new Object[] { c.hsp().getCookie("." + WeChatHosts.domainString(2131761707)) });
    AppMethodBeat.o(231506);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.console.b.a
 * JD-Core Version:    0.7.0.1
 */