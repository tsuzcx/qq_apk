package com.tencent.mm.plugin.ai.data.business.trigger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.eg;
import com.tencent.mm.autogen.a.su;
import com.tencent.mm.plugin.ai.d.e;
import com.tencent.mm.plugin.ai.d.g;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
  implements c
{
  String qmQ;
  String qmR;
  private IListener<su> qmS;
  private IListener<eg> qmT;
  
  protected a()
  {
    AppMethodBeat.i(267692);
    this.qmS = new FindMoreFriendsUIReporter.1(this, com.tencent.mm.app.f.hfK);
    this.qmT = new FindMoreFriendsUIReporter.2(this, com.tencent.mm.app.f.hfK);
    AppMethodBeat.o(267692);
  }
  
  public final void aoW()
  {
    AppMethodBeat.i(267697);
    this.qmS.alive();
    this.qmT.alive();
    AppMethodBeat.o(267697);
  }
  
  public final void unRegister()
  {
    AppMethodBeat.i(267700);
    this.qmS.dead();
    this.qmT.dead();
    AppMethodBeat.o(267700);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.data.business.trigger.a
 * JD-Core Version:    0.7.0.1
 */