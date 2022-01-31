package com.tencent.mm.plugin.collect.model.voice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class a$b
  implements c
{
  private a.c kOq;
  private ConcurrentLinkedQueue<a.a> kOr;
  
  public a$b(a parama, a.c paramc)
  {
    AppMethodBeat.i(41009);
    this.kOr = new ConcurrentLinkedQueue();
    this.kOq = paramc;
    AppMethodBeat.o(41009);
  }
  
  public final void a(a.a parama)
  {
    AppMethodBeat.i(41010);
    this.kOr.add(parama);
    AppMethodBeat.o(41010);
  }
  
  public final void m(int paramInt, byte[] paramArrayOfByte)
  {
    boolean bool = false;
    AppMethodBeat.i(41011);
    if (this.kOq == null) {
      bool = true;
    }
    ab.i("MicroMsg.F2fRcvVoiceOffLineLogic.Listener", "onGetResult() errorCode:%s (voiceLlistener == null):%s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool) });
    if (this.kOq != null)
    {
      a.a locala = (a.a)this.kOr.poll();
      this.kOq.a(paramInt, locala.cpq, locala.cpr, locala.cpu, locala.cpo, a.bhJ().bhP(), paramArrayOfByte);
    }
    AppMethodBeat.o(41011);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.voice.a.b
 * JD-Core Version:    0.7.0.1
 */