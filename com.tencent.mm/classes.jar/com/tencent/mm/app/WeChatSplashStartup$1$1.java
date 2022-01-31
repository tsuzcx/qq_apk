package com.tencent.mm.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class WeChatSplashStartup$1$1
  implements Runnable
{
  WeChatSplashStartup$1$1(WeChatSplashStartup.1 param1) {}
  
  public final void run()
  {
    AppMethodBeat.i(138003);
    ab.i("MicroMsg.WeChatSplashStartup", "Replay pending messages, so early.");
    q.Bw();
    AppMethodBeat.o(138003);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.app.WeChatSplashStartup.1.1
 * JD-Core Version:    0.7.0.1
 */