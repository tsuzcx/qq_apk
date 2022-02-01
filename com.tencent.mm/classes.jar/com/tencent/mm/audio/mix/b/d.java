package com.tencent.mm.audio.mix.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.a.e;
import java.util.ArrayList;

public class d
{
  private static d cTD;
  private ArrayList<e> cTC;
  private Object sLock;
  
  private d()
  {
    AppMethodBeat.i(136735);
    this.cTC = new ArrayList();
    this.sLock = new Object();
    AppMethodBeat.o(136735);
  }
  
  public static d ML()
  {
    AppMethodBeat.i(136736);
    if (cTD == null) {}
    try
    {
      if (cTD == null) {
        cTD = new d();
      }
      d locald = cTD;
      AppMethodBeat.o(136736);
      return locald;
    }
    finally
    {
      AppMethodBeat.o(136736);
    }
  }
  
  public final e MK()
  {
    AppMethodBeat.i(136737);
    synchronized (this.sLock)
    {
      if (this.cTC.size() > 0)
      {
        e locale = (e)this.cTC.remove(this.cTC.size() - 1);
        AppMethodBeat.o(136737);
        return locale;
      }
      ??? = new e();
      AppMethodBeat.o(136737);
      return ???;
    }
  }
  
  public final long MM()
  {
    try
    {
      AppMethodBeat.i(136739);
      long l = this.cTC.size() * 3536;
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
    if ((parame == null) || (parame.cTk == null))
    {
      AppMethodBeat.o(136738);
      return;
    }
    parame.reset();
    synchronized (this.sLock)
    {
      this.cTC.add(0, parame);
      AppMethodBeat.o(136738);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.audio.mix.b.d
 * JD-Core Version:    0.7.0.1
 */