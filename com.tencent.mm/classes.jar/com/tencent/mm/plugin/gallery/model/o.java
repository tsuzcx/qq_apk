package com.tencent.mm.plugin.gallery.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashSet;
import java.util.LinkedList;

public final class o
{
  public int kXg;
  HashSet<i.a> tRW;
  public HashSet<i.a> tRX;
  public HashSet<i.c> tRY;
  public HashSet<i.b> tRZ;
  public i tSa;
  public int tSb;
  
  public o()
  {
    AppMethodBeat.i(111350);
    this.kXg = 3;
    this.tSb = 1;
    this.tRW = new HashSet();
    this.tRX = new HashSet();
    this.tRY = new HashSet();
    this.tRZ = new HashSet();
    AppMethodBeat.o(111350);
  }
  
  private void cXV()
  {
    AppMethodBeat.i(111352);
    ae.i("MicroMsg.MediaQueryService", "initQueryType: %d", new Object[] { Integer.valueOf(this.tSb) });
    switch (this.tSb)
    {
    default: 
      this.tSa = new a();
      AppMethodBeat.o(111352);
      return;
    case 1: 
      this.tSa = new k();
      AppMethodBeat.o(111352);
      return;
    }
    this.tSa = new u();
    AppMethodBeat.o(111352);
  }
  
  public final void E(final String paramString, final int paramInt, final long paramLong)
  {
    AppMethodBeat.i(111358);
    if (this.tSa == null)
    {
      ae.e("MicroMsg.MediaQueryService", "media query not init, init again");
      cXV();
    }
    ae.i("MicroMsg.MediaQueryService", "queryMediaInAlbums, albumName: %s ticket: %d, stack: %s.", new Object[] { paramString, Long.valueOf(paramLong), bu.fpN().toString() });
    this.tSa.cXe();
    e.cXs().ak(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(111348);
        try
        {
          ae.i("MicroMsg.MediaQueryService", "queryMediaItemsInAlbum Begin...");
          o.this.tSa.a(paramString, paramInt, new i.c()
          {
            public final void b(LinkedList<GalleryItem.MediaItem> paramAnonymous2LinkedList, long paramAnonymous2Long, boolean paramAnonymous2Boolean)
            {
              AppMethodBeat.i(111347);
              ae.i("MicroMsg.MediaQueryService", "queryMediaItemsInAlbum callback, size: %d.", new Object[] { Integer.valueOf(paramAnonymous2LinkedList.size()) });
              o.a(o.this, paramAnonymous2LinkedList, paramAnonymous2Long, paramAnonymous2Boolean);
              AppMethodBeat.o(111347);
            }
          }, paramLong);
          AppMethodBeat.o(111348);
          return;
        }
        catch (SecurityException localSecurityException)
        {
          ae.printErrStackTrace("MicroMsg.MediaQueryService", localSecurityException, "", new Object[0]);
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
    this.tRW.add(parama);
    AppMethodBeat.o(111354);
  }
  
  public final void a(i.c paramc)
  {
    AppMethodBeat.i(111353);
    this.tRY.add(paramc);
    AppMethodBeat.o(111353);
  }
  
  public final void ax(String paramString, long paramLong)
  {
    AppMethodBeat.i(111357);
    E(paramString, this.tSb, paramLong);
    AppMethodBeat.o(111357);
  }
  
  public final void b(i.a parama)
  {
    AppMethodBeat.i(111355);
    this.tRW.remove(parama);
    AppMethodBeat.o(111355);
  }
  
  public final void c(i.a parama)
  {
    AppMethodBeat.i(173739);
    this.tRX.remove(parama);
    AppMethodBeat.o(173739);
  }
  
  public final int cXW()
  {
    return this.kXg;
  }
  
  public final int cXX()
  {
    return this.tSb;
  }
  
  public final void cXY()
  {
    AppMethodBeat.i(111356);
    ae.i("MicroMsg.MediaQueryService", "queryAlbums, %s.", new Object[] { this });
    if (this.tSa == null)
    {
      ae.f("MicroMsg.MediaQueryService", "media query not init, init again");
      cXV();
    }
    e.cXs().aj(new o.1(this));
    AppMethodBeat.o(111356);
  }
  
  public final void cXZ()
  {
    AppMethodBeat.i(173740);
    if (this.tSa != null) {
      this.tSa.cXe();
    }
    AppMethodBeat.o(173740);
  }
  
  public final void release()
  {
    AppMethodBeat.i(164768);
    if (this.tRW != null) {
      this.tRW.clear();
    }
    if (this.tRY != null) {
      this.tRY.clear();
    }
    if (this.tRZ != null) {
      this.tRZ.clear();
    }
    AppMethodBeat.o(164768);
  }
  
  public final void setQueryType(int paramInt)
  {
    AppMethodBeat.i(111351);
    this.tSb = paramInt;
    cXV();
    AppMethodBeat.o(111351);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.o
 * JD-Core Version:    0.7.0.1
 */