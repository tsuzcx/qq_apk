package com.tencent.mm.audio.mix.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.a.e;
import com.tencent.mm.audio.mix.h.b;
import java.util.ArrayList;

public final class d
{
  private static d hrf;
  private int count;
  private ArrayList<e> hqW;
  private long hre;
  private Object sLock;
  private int size;
  
  private d()
  {
    AppMethodBeat.i(136731);
    this.hqW = new ArrayList();
    this.sLock = new Object();
    this.hre = 3000000L;
    this.size = 0;
    this.count = 0;
    AppMethodBeat.o(136731);
  }
  
  public static d aFn()
  {
    AppMethodBeat.i(136732);
    if (hrf == null) {}
    try
    {
      if (hrf == null) {
        hrf = new d();
      }
      d locald = hrf;
      AppMethodBeat.o(136732);
      return locald;
    }
    finally
    {
      AppMethodBeat.o(136732);
    }
  }
  
  public final e aFo()
  {
    AppMethodBeat.i(136733);
    synchronized (this.sLock)
    {
      if (this.hqW.size() > 0)
      {
        e locale = (e)this.hqW.remove(this.hqW.size() - 1);
        AppMethodBeat.o(136733);
        return locale;
      }
      if (this.size >= this.hre)
      {
        b.e("MicroMsg.Mix.AudioPcmDataTrackFixedSizePool", "size >= FIX_SIZE, size:%d", new Object[] { Integer.valueOf(this.size) });
        AppMethodBeat.o(136733);
        return null;
      }
      this.count += 1;
      this.size = (this.count * 3536);
      b.i("MicroMsg.Mix.AudioPcmDataTrackFixedSizePool", "pool tract count:%d", new Object[] { Integer.valueOf(this.count) });
      ??? = new e();
      ((e)???).hqU = true;
      AppMethodBeat.o(136733);
      return ???;
    }
  }
  
  public final void b(e parame)
  {
    AppMethodBeat.i(136734);
    if ((parame == null) || (parame.hqJ == null))
    {
      AppMethodBeat.o(136734);
      return;
    }
    if (!parame.hqU)
    {
      AppMethodBeat.o(136734);
      return;
    }
    parame.reset();
    synchronized (this.sLock)
    {
      this.hqW.add(0, parame);
      AppMethodBeat.o(136734);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.audio.mix.b.d
 * JD-Core Version:    0.7.0.1
 */