package com.tencent.mm.audio.mix.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.a.e;
import com.tencent.mm.audio.mix.h.b;
import java.util.ArrayList;

public final class c
{
  private static c ddq;
  private int count;
  private long ddp;
  private ArrayList<e> ddr;
  private Object sLock;
  private int size;
  
  private c()
  {
    AppMethodBeat.i(136731);
    this.ddr = new ArrayList();
    this.sLock = new Object();
    this.ddp = 3000000L;
    this.size = 0;
    this.count = 0;
    AppMethodBeat.o(136731);
  }
  
  public static c Oo()
  {
    AppMethodBeat.i(136732);
    if (ddq == null) {}
    try
    {
      if (ddq == null) {
        ddq = new c();
      }
      c localc = ddq;
      AppMethodBeat.o(136732);
      return localc;
    }
    finally
    {
      AppMethodBeat.o(136732);
    }
  }
  
  public final e Op()
  {
    AppMethodBeat.i(136733);
    synchronized (this.sLock)
    {
      if (this.ddr.size() > 0)
      {
        e locale = (e)this.ddr.remove(this.ddr.size() - 1);
        AppMethodBeat.o(136733);
        return locale;
      }
      if (this.size >= this.ddp)
      {
        b.e("MicroMsg.Mix.AudioPcmDataTrackFixedSizePool", "size >= FIX_SIZE, size:%d", new Object[] { Integer.valueOf(this.size) });
        AppMethodBeat.o(136733);
        return null;
      }
      this.count += 1;
      this.size = (this.count * 3536);
      b.i("MicroMsg.Mix.AudioPcmDataTrackFixedSizePool", "pool tract count:%d", new Object[] { Integer.valueOf(this.count) });
      ??? = new e();
      ((e)???).ddk = true;
      AppMethodBeat.o(136733);
      return ???;
    }
  }
  
  public final void b(e parame)
  {
    AppMethodBeat.i(136734);
    if ((parame == null) || (parame.dcZ == null))
    {
      AppMethodBeat.o(136734);
      return;
    }
    if (!parame.ddk)
    {
      AppMethodBeat.o(136734);
      return;
    }
    parame.reset();
    synchronized (this.sLock)
    {
      this.ddr.add(0, parame);
      AppMethodBeat.o(136734);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.audio.mix.b.c
 * JD-Core Version:    0.7.0.1
 */