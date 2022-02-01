package com.tencent.mm.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.g;
import com.tencent.mm.sdk.platformtools.aj;

final class WeChatSplashStartup$8
  implements g
{
  WeChatSplashStartup$8(WeChatSplashStartup paramWeChatSplashStartup) {}
  
  public final void MP()
  {
    AppMethodBeat.i(160071);
    if (!aj.fkH()) {
      ag.a.cVi.MD();
    }
    if (aj.cmR()) {
      x.execute();
    }
    AppMethodBeat.o(160071);
  }
  
  public final void cg(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.WeChatSplashStartup.8
 * JD-Core Version:    0.7.0.1
 */