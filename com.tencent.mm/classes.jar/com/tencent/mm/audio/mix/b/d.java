package com.tencent.mm.audio.mix.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.a.e;
import java.util.ArrayList;

public class d
{
  private static d dcq;
  private ArrayList<e> dcp;
  private Object sLock;
  
  private d()
  {
    AppMethodBeat.i(136735);
    this.dcp = new ArrayList();
    this.sLock = new Object();
    AppMethodBeat.o(136735);
  }
  
  public static d Os()
  {
    AppMethodBeat.i(136736);
    if (dcq == null) {}
    try
    {
      if (dcq == null) {
        dcq = new d();
      }
      d locald = dcq;
      AppMethodBeat.o(136736);
      return locald;
    }
    finally
    {
      AppMethodBeat.o(136736);
    }
  }
  
  public final e Or()
  {
    AppMethodBeat.i(136737);
    synchronized (this.sLock)
    {
      if (this.dcp.size() > 0)
      {
        e locale = (e)this.dcp.remove(this.dcp.size() - 1);
        AppMethodBeat.o(136737);
        return locale;
      }
      ??? = new e();
      AppMethodBeat.o(136737);
      return ???;
    }
  }
  
  public final long Ot()
  {
    try
    {
      AppMethodBeat.i(136739);
      long l = this.dcp.size() * 3536;
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
    if ((parame == null) || (parame.dbX == null))
    {
      AppMethodBeat.o(136738);
      return;
    }
    parame.reset();
    synchronized (this.sLock)
    {
      this.dcp.add(0, parame);
      AppMethodBeat.o(136738);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.audio.mix.b.d
 * JD-Core Version:    0.7.0.1
 */