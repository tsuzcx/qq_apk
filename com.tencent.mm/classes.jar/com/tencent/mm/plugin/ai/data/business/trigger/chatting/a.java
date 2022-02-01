package com.tencent.mm.plugin.ai.data.business.trigger.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.bq;
import com.tencent.mm.plugin.ai.data.business.trigger.c;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class a
  implements c
{
  private IListener<bq> qny;
  
  public a()
  {
    AppMethodBeat.i(267650);
    this.qny = new OnceForegroundChattingTrigger.1(this, f.hfK);
    AppMethodBeat.o(267650);
  }
  
  public final void aoW()
  {
    AppMethodBeat.i(267660);
    if (MMApplicationContext.isMainProcess()) {
      this.qny.alive();
    }
    AppMethodBeat.o(267660);
  }
  
  public final void unRegister()
  {
    AppMethodBeat.i(267670);
    if (MMApplicationContext.isMainProcess()) {
      this.qny.dead();
    }
    AppMethodBeat.o(267670);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.data.business.trigger.chatting.a
 * JD-Core Version:    0.7.0.1
 */