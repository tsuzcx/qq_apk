package com.tencent.mm.plugin.appbrand.b;

import android.os.Handler;
import android.support.v4.f.a;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bf;

public final class c
{
  public final d fFN;
  public final a<c.a, c> fFO = new a();
  final i fzT;
  
  public c(i parami)
  {
    this.fzT = parami;
    this.fFN = new c.1(this, parami);
  }
  
  public final void a(c.a parama)
  {
    if ((parama == null) || (b.fFL == this.fFN.acz())) {
      return;
    }
    synchronized (this.fFO)
    {
      this.fFO.put(parama, this);
      return;
    }
  }
  
  public final boolean acx()
  {
    d locald = this.fFN;
    switch (d.7.fGc[locald.acz().ordinal()])
    {
    case 2: 
    case 3: 
    default: 
      return false;
    case 1: 
      return true;
    }
    return ((Boolean)new d.5(locald).b(new ah(locald.ujd.getLooper()))).booleanValue();
  }
  
  public final void b(c.a parama)
  {
    if ((parama == null) || (b.fFL == this.fFN.acz())) {
      return;
    }
    synchronized (this.fFO)
    {
      this.fFO.remove(parama);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.b.c
 * JD-Core Version:    0.7.0.1
 */