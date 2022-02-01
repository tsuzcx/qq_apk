package com.tencent.mm.plugin.collect.model.voice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class a$b
  implements c
{
  private a.c tWl;
  private ConcurrentLinkedQueue<a.a> tWm;
  
  public a$b(a parama, a.c paramc)
  {
    AppMethodBeat.i(63864);
    this.tWm = new ConcurrentLinkedQueue();
    this.tWl = paramc;
    AppMethodBeat.o(63864);
  }
  
  public final void a(a.a parama)
  {
    AppMethodBeat.i(63865);
    this.tWm.add(parama);
    AppMethodBeat.o(63865);
  }
  
  public final void p(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(63866);
    if (this.tWl == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.F2fRcvVoiceOffLineLogic.Listener", "onGetResult() errorCode:%s (voiceLlistener == null):%s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool) });
      if (this.tWl != null)
      {
        a.a locala = (a.a)this.tWm.poll();
        this.tWl.a(paramInt, locala.fyd, locala.fye, locala.fyf, locala.fee, a.cOg().cOn(), paramArrayOfByte);
        if (paramInt < 0) {
          h.IzE.idkeyStat(1143L, 20L, 1L, false);
        }
      }
      AppMethodBeat.o(63866);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.voice.a.b
 * JD-Core Version:    0.7.0.1
 */