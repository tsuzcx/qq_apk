package com.tencent.mm.audio.mix.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.a.e;
import java.util.ArrayList;

public class d
{
  private static d dds;
  private ArrayList<e> ddr;
  private Object sLock;
  
  private d()
  {
    AppMethodBeat.i(136735);
    this.ddr = new ArrayList();
    this.sLock = new Object();
    AppMethodBeat.o(136735);
  }
  
  public static d Oq()
  {
    AppMethodBeat.i(136736);
    if (dds == null) {}
    try
    {
      if (dds == null) {
        dds = new d();
      }
      d locald = dds;
      AppMethodBeat.o(136736);
      return locald;
    }
    finally
    {
      AppMethodBeat.o(136736);
    }
  }
  
  public final e Op()
  {
    AppMethodBeat.i(136737);
    synchronized (this.sLock)
    {
      if (this.ddr.size() > 0)
      {
        e locale = (e)this.ddr.remove(this.ddr.size() - 1);
        AppMethodBeat.o(136737);
        return locale;
      }
      ??? = new e();
      AppMethodBeat.o(136737);
      return ???;
    }
  }
  
  public final long Or()
  {
    try
    {
      AppMethodBeat.i(136739);
      long l = this.ddr.size() * 3536;
      AppMethodBeat.o(136739);
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void b(e parame)
  {
    AppMethodBeat.i(136738);
    if ((parame == null) || (parame.dcZ == null))
    {
      AppMethodBeat.o(136738);
      return;
    }
    parame.reset();
    synchronized (this.sLock)
    {
      this.ddr.add(0, parame);
      AppMethodBeat.o(136738);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.audio.mix.b.d
 * JD-Core Version:    0.7.0.1
 */