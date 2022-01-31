package com.tencent.mm.plugin.appbrand.b;

import android.os.Handler;
import android.support.v4.e.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bj;

public final class c
{
  final i gRG;
  public final d gYj;
  public final a<c.a, c> gYk;
  
  public c(i parami)
  {
    AppMethodBeat.i(86833);
    this.gYk = new a();
    this.gRG = parami;
    this.gYj = new c.1(this, parami);
    AppMethodBeat.o(86833);
  }
  
  public final void a(c.a parama)
  {
    AppMethodBeat.i(86834);
    if ((parama == null) || (b.gYh == this.gYj.awr()))
    {
      AppMethodBeat.o(86834);
      return;
    }
    synchronized (this.gYk)
    {
      this.gYk.put(parama, this);
      AppMethodBeat.o(86834);
      return;
    }
  }
  
  public final boolean awp()
  {
    AppMethodBeat.i(86836);
    d locald = this.gYj;
    switch (d.7.gYx[locald.awr().ordinal()])
    {
    default: 
      AppMethodBeat.o(86836);
      return false;
    case 1: 
      AppMethodBeat.o(86836);
      return true;
    case 2: 
    case 3: 
      AppMethodBeat.o(86836);
      return false;
    }
    boolean bool = ((Boolean)new d.5(locald).b(new ak(locald.yrd.getLooper()))).booleanValue();
    AppMethodBeat.o(86836);
    return bool;
  }
  
  public final void b(c.a parama)
  {
    AppMethodBeat.i(86835);
    if ((parama == null) || (b.gYh == this.gYj.awr()))
    {
      AppMethodBeat.o(86835);
      return;
    }
    synchronized (this.gYk)
    {
      this.gYk.remove(parama);
      AppMethodBeat.o(86835);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.b.c
 * JD-Core Version:    0.7.0.1
 */