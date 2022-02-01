package com.tencent.mm.plugin.gallery.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashSet;
import java.util.LinkedList;

public final class o
{
  public int kTx;
  HashSet<i.a> tHf;
  public HashSet<i.a> tHg;
  public HashSet<i.c> tHh;
  public HashSet<i.b> tHi;
  public i tHj;
  public int tHk;
  
  public o()
  {
    AppMethodBeat.i(111350);
    this.kTx = 3;
    this.tHk = 1;
    this.tHf = new HashSet();
    this.tHg = new HashSet();
    this.tHh = new HashSet();
    this.tHi = new HashSet();
    AppMethodBeat.o(111350);
  }
  
  private void cVq()
  {
    AppMethodBeat.i(111352);
    ad.i("MicroMsg.MediaQueryService", "initQueryType: %d", new Object[] { Integer.valueOf(this.tHk) });
    switch (this.tHk)
    {
    default: 
      this.tHj = new a();
      AppMethodBeat.o(111352);
      return;
    case 1: 
      this.tHj = new k();
      AppMethodBeat.o(111352);
      return;
    }
    this.tHj = new u();
    AppMethodBeat.o(111352);
  }
  
  public final void F(final String paramString, final int paramInt, final long paramLong)
  {
    AppMethodBeat.i(111358);
    if (this.tHj == null)
    {
      ad.e("MicroMsg.MediaQueryService", "media query not init, init again");
      cVq();
    }
    ad.i("MicroMsg.MediaQueryService", "queryMediaInAlbums, albumName: %s ticket: %d, stack: %s.", new Object[] { paramString, Long.valueOf(paramLong), bt.flS().toString() });
    this.tHj.cUz();
    e.cUN().am(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(111348);
        try
        {
          ad.i("MicroMsg.MediaQueryService", "queryMediaItemsInAlbum Begin...");
          o.this.tHj.a(paramString, paramInt, new i.c()
          {
            public final void b(LinkedList<GalleryItem.MediaItem> paramAnonymous2LinkedList, long paramAnonymous2Long, boolean paramAnonymous2Boolean)
            {
              AppMethodBeat.i(111347);
              ad.i("MicroMsg.MediaQueryService", "queryMediaItemsInAlbum callback, size: %d.", new Object[] { Integer.valueOf(paramAnonymous2LinkedList.size()) });
              o.a(o.this, paramAnonymous2LinkedList, paramAnonymous2Long, paramAnonymous2Boolean);
              AppMethodBeat.o(111347);
            }
          }, paramLong);
          AppMethodBeat.o(111348);
          return;
        }
        catch (SecurityException localSecurityException)
        {
          ad.printErrStackTrace("MicroMsg.MediaQueryService", localSecurityException, "", new Object[0]);
          o.a(o.this, new LinkedList(), paramLong, false);
          AppMethodBeat.o(111348);
        }
      }
      
      public final String toString()
      {
        AppMethodBeat.i(111349);
        String str = super.toString() + "|queryMediaInAlbums";
        AppMethodBeat.o(111349);
        return str;
      }
    });
    AppMethodBeat.o(111358);
  }
  
  public final void a(i.a parama)
  {
    AppMethodBeat.i(111354);
    this.tHf.add(parama);
    AppMethodBeat.o(111354);
  }
  
  public final void a(i.c paramc)
  {
    AppMethodBeat.i(111353);
    this.tHh.add(paramc);
    AppMethodBeat.o(111353);
  }
  
  public final void ax(String paramString, long paramLong)
  {
    AppMethodBeat.i(111357);
    F(paramString, this.tHk, paramLong);
    AppMethodBeat.o(111357);
  }
  
  public final void b(i.a parama)
  {
    AppMethodBeat.i(111355);
    this.tHf.remove(parama);
    AppMethodBeat.o(111355);
  }
  
  public final void c(i.a parama)
  {
    AppMethodBeat.i(173739);
    this.tHg.remove(parama);
    AppMethodBeat.o(173739);
  }
  
  public final int cVr()
  {
    return this.kTx;
  }
  
  public final int cVs()
  {
    return this.tHk;
  }
  
  public final void cVt()
  {
    AppMethodBeat.i(111356);
    ad.i("MicroMsg.MediaQueryService", "queryAlbums, %s.", new Object[] { this });
    if (this.tHj == null)
    {
      ad.f("MicroMsg.MediaQueryService", "media query not init, init again");
      cVq();
    }
    e.cUN().al(new o.1(this));
    AppMethodBeat.o(111356);
  }
  
  public final void cVu()
  {
    AppMethodBeat.i(173740);
    if (this.tHj != null) {
      this.tHj.cUz();
    }
    AppMethodBeat.o(173740);
  }
  
  public final void release()
  {
    AppMethodBeat.i(164768);
    if (this.tHf != null) {
      this.tHf.clear();
    }
    if (this.tHh != null) {
      this.tHh.clear();
    }
    if (this.tHi != null) {
      this.tHi.clear();
    }
    AppMethodBeat.o(164768);
  }
  
  public final void setQueryType(int paramInt)
  {
    AppMethodBeat.i(111351);
    this.tHk = paramInt;
    cVq();
    AppMethodBeat.o(111351);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.o
 * JD-Core Version:    0.7.0.1
 */