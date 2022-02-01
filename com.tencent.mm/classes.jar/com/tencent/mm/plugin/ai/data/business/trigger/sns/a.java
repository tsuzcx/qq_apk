package com.tencent.mm.plugin.ai.data.business.trigger.sns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.ts;
import com.tencent.mm.plugin.ai.data.business.trigger.c;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class a
  implements c
{
  private IListener<ts> qob;
  
  public a()
  {
    AppMethodBeat.i(267606);
    this.qob = new OnceForegroundSnsTrigger.1(this, f.hfK);
    AppMethodBeat.o(267606);
  }
  
  public final void aoW()
  {
    AppMethodBeat.i(267616);
    if (MMApplicationContext.isMainProcess()) {
      this.qob.alive();
    }
    AppMethodBeat.o(267616);
  }
  
  public final void unRegister()
  {
    AppMethodBeat.i(267624);
    if (MMApplicationContext.isMainProcess()) {
      this.qob.dead();
    }
    AppMethodBeat.o(267624);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.data.business.trigger.sns.a
 * JD-Core Version:    0.7.0.1
 */