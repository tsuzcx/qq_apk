package com.tencent.mm.plugin.gallery.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashSet;

public final class l
{
  public int hQK;
  HashSet<i.a> ndv;
  public HashSet<i.c> ndw;
  public HashSet<i.b> ndx;
  public i ndy;
  public int ndz;
  
  public l()
  {
    AppMethodBeat.i(21323);
    this.hQK = 3;
    this.ndz = 1;
    this.ndv = new HashSet();
    this.ndw = new HashSet();
    this.ndx = new HashSet();
    AppMethodBeat.o(21323);
  }
  
  private void bEk()
  {
    AppMethodBeat.i(21325);
    ab.i("MicroMsg.MediaQueryService", "initQueryType: %d", new Object[] { Integer.valueOf(this.ndz) });
    switch (this.ndz)
    {
    default: 
      this.ndy = new a();
      AppMethodBeat.o(21325);
      return;
    case 1: 
      this.ndy = new j();
      AppMethodBeat.o(21325);
      return;
    case 2: 
      this.ndy = new n();
      AppMethodBeat.o(21325);
      return;
    }
    this.ndy = new a();
    AppMethodBeat.o(21325);
  }
  
  public final void a(i.a parama)
  {
    AppMethodBeat.i(21326);
    this.ndv.add(parama);
    AppMethodBeat.o(21326);
  }
  
  public final void b(i.a parama)
  {
    AppMethodBeat.i(21327);
    this.ndv.remove(parama);
    AppMethodBeat.o(21327);
  }
  
  public final void bEl()
  {
    AppMethodBeat.i(21328);
    if (this.ndy == null)
    {
      ab.f("MicroMsg.MediaQueryService", "media query not init, init again");
      bEk();
    }
    e.bDR().T(new l.1(this));
    AppMethodBeat.o(21328);
  }
  
  public final void i(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(21329);
    if (this.ndy == null)
    {
      ab.e("MicroMsg.MediaQueryService", "media query not init, init again");
      bEk();
    }
    ab.i("MicroMsg.MediaQueryService", "queryMediaInAlbums %s", new Object[] { bo.dtY().toString() });
    e.bDR().bEe().removeCallbacksAndMessages(null);
    this.ndy.bDK();
    g localg = e.bDR();
    paramString = new l.2(this, paramString, paramInt, paramLong);
    localg.bEe().post(paramString);
    AppMethodBeat.o(21329);
  }
  
  public final void wM(int paramInt)
  {
    AppMethodBeat.i(21324);
    this.ndz = paramInt;
    bEk();
    AppMethodBeat.o(21324);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.l
 * JD-Core Version:    0.7.0.1
 */