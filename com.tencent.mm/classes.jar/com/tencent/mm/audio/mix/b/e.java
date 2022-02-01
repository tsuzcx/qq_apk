package com.tencent.mm.audio.mix.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public class e
{
  private static e dun;
  private ArrayList<com.tencent.mm.audio.mix.a.e> dud;
  private Object sLock;
  
  private e()
  {
    AppMethodBeat.i(136735);
    this.dud = new ArrayList();
    this.sLock = new Object();
    AppMethodBeat.o(136735);
  }
  
  public static e YJ()
  {
    AppMethodBeat.i(136736);
    if (dun == null) {}
    try
    {
      if (dun == null) {
        dun = new e();
      }
      e locale = dun;
      AppMethodBeat.o(136736);
      return locale;
    }
    finally
    {
      AppMethodBeat.o(136736);
    }
  }
  
  public final com.tencent.mm.audio.mix.a.e YI()
  {
    AppMethodBeat.i(136737);
    synchronized (this.sLock)
    {
      if (this.dud.size() > 0)
      {
        com.tencent.mm.audio.mix.a.e locale = (com.tencent.mm.audio.mix.a.e)this.dud.remove(this.dud.size() - 1);
        AppMethodBeat.o(136737);
        return locale;
      }
      ??? = new com.tencent.mm.audio.mix.a.e();
      AppMethodBeat.o(136737);
      return ???;
    }
  }
  
  public final long YK()
  {
    try
    {
      AppMethodBeat.i(136739);
      long l = this.dud.size() * 3536;
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
    if ((parame == null) || (parame.dtQ == null))
    {
      AppMethodBeat.o(136738);
      return;
    }
    parame.reset();
    synchronized (this.sLock)
    {
      this.dud.add(0, parame);
      AppMethodBeat.o(136738);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.audio.mix.b.e
 * JD-Core Version:    0.7.0.1
 */