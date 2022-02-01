package com.tencent.mm.plugin.collect.model.voice;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.sz;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;

class F2fRcvVoiceOffLineLogic$2
  extends IListener<sz>
{
  F2fRcvVoiceOffLineLogic$2(a parama, q paramq)
  {
    super(paramq);
    AppMethodBeat.i(293551);
    this.__eventId = sz.class.getName().hashCode();
    AppMethodBeat.o(293551);
  }
  
  private boolean drT()
  {
    AppMethodBeat.i(63860);
    Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "ReInitVoiceOffLineSynthesizerEvent");
    synchronized (a.a(this.wZB))
    {
      com.tencent.mm.plugin.collect.app.a.dru();
      com.tencent.mm.plugin.collect.app.a.drw();
      a.b(this.wZB);
      AppMethodBeat.o(63860);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.voice.F2fRcvVoiceOffLineLogic.2
 * JD-Core Version:    0.7.0.1
 */