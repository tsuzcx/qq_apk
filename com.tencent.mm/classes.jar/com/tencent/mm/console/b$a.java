package com.tencent.mm.console;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.xweb.c;

class b$a
  implements b
{
  public void invoke(Object paramObject, com.tencent.mm.ipcinvoker.d paramd)
  {
    AppMethodBeat.i(186343);
    com.tencent.xweb.d.lB(ak.getContext());
    ae.i("MicroMsg.CommandProcessor", "ClearGameA8keyCookie before, cookie : %s", new Object[] { c.geY().getCookie(".game.weixin.qq.com") });
    c.geY().setCookie(".game.weixin.qq.com", "cookie_passkey=; max-age=0");
    c.geY().setCookie(".game.weixin.qq.com", "uin=; max-age=0; httponly");
    c.geY().setCookie(".game.weixin.qq.com", "key=; max-age=0; httponly");
    c.geY().setCookie(".game.weixin.qq.com", "pass_ticket=; max-age=0; httponly");
    com.tencent.xweb.d.gfa();
    com.tencent.xweb.d.sync();
    ae.i("MicroMsg.CommandProcessor", "ClearGameA8keyCookie end, cookie : %s", new Object[] { c.geY().getCookie(".game.weixin.qq.com") });
    AppMethodBeat.o(186343);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.console.b.a
 * JD-Core Version:    0.7.0.1
 */