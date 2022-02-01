package com.tencent.mm.console;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.xweb.c;

class b$a
  implements com.tencent.mm.ipcinvoker.d
{
  public void invoke(Object paramObject, f paramf)
  {
    AppMethodBeat.i(196629);
    com.tencent.xweb.d.my(MMApplicationContext.getContext());
    Log.i("MicroMsg.CommandProcessor", "ClearGameA8keyCookie before, cookie : %s", new Object[] { c.ivX().getCookie("." + WeChatHosts.domainString(R.l.host_game_weixin_qq_com)) });
    c.ivX().setCookie("." + WeChatHosts.domainString(R.l.host_game_weixin_qq_com), "cookie_passkey=; max-age=0");
    c.ivX().setCookie("." + WeChatHosts.domainString(R.l.host_game_weixin_qq_com), "uin=; max-age=0; httponly");
    c.ivX().setCookie("." + WeChatHosts.domainString(R.l.host_game_weixin_qq_com), "key=; max-age=0; httponly");
    c.ivX().setCookie("." + WeChatHosts.domainString(R.l.host_game_weixin_qq_com), "pass_ticket=; max-age=0; httponly");
    com.tencent.xweb.d.ivZ();
    com.tencent.xweb.d.sync();
    Log.i("MicroMsg.CommandProcessor", "ClearGameA8keyCookie end, cookie : %s", new Object[] { c.ivX().getCookie("." + WeChatHosts.domainString(R.l.host_game_weixin_qq_com)) });
    AppMethodBeat.o(196629);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.console.b.a
 * JD-Core Version:    0.7.0.1
 */