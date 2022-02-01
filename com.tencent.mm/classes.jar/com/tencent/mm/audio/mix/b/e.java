package com.tencent.mm.audio.mix.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public class e
{
  private static e hrg;
  private ArrayList<com.tencent.mm.audio.mix.a.e> hqW;
  private Object sLock;
  
  private e()
  {
    AppMethodBeat.i(136735);
    this.hqW = new ArrayList();
    this.sLock = new Object();
    AppMethodBeat.o(136735);
  }
  
  public static e aFp()
  {
    AppMethodBeat.i(136736);
    if (hrg == null) {}
    try
    {
      if (hrg == null) {
        hrg = new e();
      }
      e locale = hrg;
      AppMethodBeat.o(136736);
      return locale;
    }
    finally
    {
      AppMethodBeat.o(136736);
    }
  }
  
  public final com.tencent.mm.audio.mix.a.e aFo()
  {
    AppMethodBeat.i(136737);
    synchronized (this.sLock)
    {
      if (this.hqW.size() > 0)
      {
        com.tencent.mm.audio.mix.a.e locale = (com.tencent.mm.audio.mix.a.e)this.hqW.remove(this.hqW.size() - 1);
        AppMethodBeat.o(136737);
        return locale;
      }
      ??? = new com.tencent.mm.audio.mix.a.e();
      AppMethodBeat.o(136737);
      return ???;
    }
  }
  
  public final long aFq()
  {
    try
    {
      AppMethodBeat.i(136739);
      long l = this.hqW.size() * 3536;
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
    if ((parame == null) || (parame.hqJ == null))
    {
      AppMethodBeat.o(136738);
      return;
    }
    parame.reset();
    synchronized (this.sLock)
    {
      this.hqW.add(0, parame);
      AppMethodBeat.o(136738);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.audio.mix.b.e
 * JD-Core Version:    0.7.0.1
 */