package com.tencent.mm.audio.mix.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public class e
{
  private static e fmV;
  private ArrayList<com.tencent.mm.audio.mix.a.e> fmL;
  private Object sLock;
  
  private e()
  {
    AppMethodBeat.i(136735);
    this.fmL = new ArrayList();
    this.sLock = new Object();
    AppMethodBeat.o(136735);
  }
  
  public static e adq()
  {
    AppMethodBeat.i(136736);
    if (fmV == null) {}
    try
    {
      if (fmV == null) {
        fmV = new e();
      }
      e locale = fmV;
      AppMethodBeat.o(136736);
      return locale;
    }
    finally
    {
      AppMethodBeat.o(136736);
    }
  }
  
  public final com.tencent.mm.audio.mix.a.e adp()
  {
    AppMethodBeat.i(136737);
    synchronized (this.sLock)
    {
      if (this.fmL.size() > 0)
      {
        com.tencent.mm.audio.mix.a.e locale = (com.tencent.mm.audio.mix.a.e)this.fmL.remove(this.fmL.size() - 1);
        AppMethodBeat.o(136737);
        return locale;
      }
      ??? = new com.tencent.mm.audio.mix.a.e();
      AppMethodBeat.o(136737);
      return ???;
    }
  }
  
  public final long adr()
  {
    try
    {
      AppMethodBeat.i(136739);
      long l = this.fmL.size() * 3536;
      AppMethodBeat.o(136739);
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void b(com.tencent.mm.audio.mix.a.e parame)
  {
    AppMethodBeat.i(136738);
    if ((parame == null) || (parame.fmy == null))
    {
      AppMethodBeat.o(136738);
      return;
    }
    parame.reset();
    synchronized (this.sLock)
    {
      this.fmL.add(0, parame);
      AppMethodBeat.o(136738);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.audio.mix.b.e
 * JD-Core Version:    0.7.0.1
 */