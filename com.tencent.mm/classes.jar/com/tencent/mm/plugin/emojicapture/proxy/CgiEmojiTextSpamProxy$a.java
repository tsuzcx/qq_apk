package com.tencent.mm.plugin.emojicapture.proxy;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cm.f;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class CgiEmojiTextSpamProxy$a
  implements Runnable
{
  CgiEmojiTextSpamProxy$a(CgiEmojiTextSpamProxy paramCgiEmojiTextSpamProxy, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(2799);
    new com.tencent.mm.plugin.emojicapture.a.a(this.lwB).adl().g((com.tencent.mm.vending.c.a)new CgiEmojiTextSpamProxy.a.1(this));
    AppMethodBeat.o(2799);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.proxy.CgiEmojiTextSpamProxy.a
 * JD-Core Version:    0.7.0.1
 */