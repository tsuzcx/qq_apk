package com.tencent.mm.plugin.game.luggage;

import com.tencent.xweb.n;

final class c$3
  implements Runnable
{
  c$3(c paramc) {}
  
  public final void run()
  {
    c localc = this.kMw;
    localc.getSettings().setBlockNetworkImage(true);
    localc.setWebViewClientProxy(new c.b(localc));
    localc.setWebChromeClientProxy(new c.a(localc));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.c.3
 * JD-Core Version:    0.7.0.1
 */