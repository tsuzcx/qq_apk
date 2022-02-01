package com.tencent.mm.console;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.xweb.ao;

class a$b
  implements d
{
  public void invoke(Object paramObject, f paramf)
  {
    AppMethodBeat.i(231942);
    ao.oQ(MMApplicationContext.getContext());
    Log.i("MicroMsg.CommandProcessor", "ClearGameA8keyCookie before, cookie : %s", new Object[] { ao.getCookie("." + WeChatHosts.domainString(R.l.host_game_weixin_qq_com)) });
    ao.setCookie("." + WeChatHosts.domainString(R.l.host_game_weixin_qq_com), "cookie_passkey=; max-age=0");
    ao.setCookie("." + WeChatHosts.domainString(R.l.host_game_weixin_qq_com), "uin=; max-age=0; httponly");
    ao.setCookie("." + WeChatHosts.domainString(R.l.host_game_weixin_qq_com), "key=; max-age=0; httponly");
    ao.setCookie("." + WeChatHosts.domainString(R.l.host_game_weixin_qq_com), "pass_ticket=; max-age=0; httponly");
    ao.kgo();
    Log.i("MicroMsg.CommandProcessor", "ClearGameA8keyCookie end, cookie : %s", new Object[] { ao.getCookie("." + WeChatHosts.domainString(R.l.host_game_weixin_qq_com)) });
    AppMethodBeat.o(231942);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.console.a.b
 * JD-Core Version:    0.7.0.1
 */