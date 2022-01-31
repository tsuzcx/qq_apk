package com.tencent.mm.audio.mix.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.a.d;
import java.util.ArrayList;

public class c
{
  private static c ceE;
  private ArrayList<d> ceC;
  private Object sLock;
  
  private c()
  {
    AppMethodBeat.i(136987);
    this.ceC = new ArrayList();
    this.sLock = new Object();
    AppMethodBeat.o(136987);
  }
  
  public static c Dc()
  {
    AppMethodBeat.i(136988);
    if (ceE == null) {}
    try
    {
      if (ceE == null) {
        ceE = new c();
      }
      c localc = ceE;
      AppMethodBeat.o(136988);
      return localc;
    }
    finally
    {
      AppMethodBeat.o(136988);
    }
  }
  
  public final d Db()
  {
    AppMethodBeat.i(136989);
    synchronized (this.sLock)
    {
      if (this.ceC.size() > 0)
      {
        d locald = (d)this.ceC.remove(this.ceC.size() - 1);
        AppMethodBeat.o(136989);
        return locald;
      }
      ??? = new d();
      AppMethodBeat.o(136989);
      return ???;
    }
  }
  
  public final long Dd()
  {
    try
    {
      AppMethodBeat.i(136991);
      long l = this.ceC.size() * 3536;
      AppMethodBeat.o(136991);
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void b(d paramd)
  {
    AppMethodBeat.i(136990);
    if ((paramd == null) || (paramd.cem == null))
    {
      AppMethodBeat.o(136990);
      return;
    }
    paramd.reset();
    synchronized (this.sLock)
    {
      this.ceC.add(0, paramd);
      AppMethodBeat.o(136990);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.audio.mix.b.c
 * JD-Core Version:    0.7.0.1
 */