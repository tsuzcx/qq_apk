package com.tencent.mm.console;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.xweb.c;

class b$a
  implements b
{
  public void invoke(Object paramObject, com.tencent.mm.ipcinvoker.d paramd)
  {
    AppMethodBeat.i(193104);
    com.tencent.xweb.d.lv(aj.getContext());
    ad.i("MicroMsg.CommandProcessor", "ClearGameA8keyCookie before, cookie : %s", new Object[] { c.gaw().getCookie(".game.weixin.qq.com") });
    c.gaw().setCookie(".game.weixin.qq.com", "cookie_passkey=; max-age=0");
    c.gaw().setCookie(".game.weixin.qq.com", "uin=; max-age=0; httponly");
    c.gaw().setCookie(".game.weixin.qq.com", "key=; max-age=0; httponly");
    c.gaw().setCookie(".game.weixin.qq.com", "pass_ticket=; max-age=0; httponly");
    com.tencent.xweb.d.gay();
    com.tencent.xweb.d.sync();
    ad.i("MicroMsg.CommandProcessor", "ClearGameA8keyCookie end, cookie : %s", new Object[] { c.gaw().getCookie(".game.weixin.qq.com") });
    AppMethodBeat.o(193104);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.console.b.a
 * JD-Core Version:    0.7.0.1
 */