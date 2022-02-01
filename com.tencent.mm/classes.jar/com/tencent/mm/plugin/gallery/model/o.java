package com.tencent.mm.plugin.gallery.model;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.net.Uri.Builder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public final class o
{
  public int jWF;
  HashSet<i.a> rBB;
  public HashSet<i.a> rBC;
  public HashSet<i.c> rBD;
  public HashSet<i.b> rBE;
  public i rBF;
  public int rBG;
  
  public o()
  {
    AppMethodBeat.i(111350);
    this.jWF = 3;
    this.rBG = 1;
    this.rBB = new HashSet();
    this.rBC = new HashSet();
    this.rBD = new HashSet();
    this.rBE = new HashSet();
    AppMethodBeat.o(111350);
  }
  
  private void czM()
  {
    AppMethodBeat.i(111352);
    ad.i("MicroMsg.MediaQueryService", "initQueryType: %d", new Object[] { Integer.valueOf(this.rBG) });
    switch (this.rBG)
    {
    default: 
      this.rBF = new a();
      AppMethodBeat.o(111352);
      return;
    case 1: 
      this.rBF = new k();
      AppMethodBeat.o(111352);
      return;
    }
    this.rBF = new u();
    AppMethodBeat.o(111352);
  }
  
  public final void a(i.a parama)
  {
    AppMethodBeat.i(111354);
    this.rBB.add(parama);
    AppMethodBeat.o(111354);
  }
  
  public final void a(i.c paramc)
  {
    AppMethodBeat.i(111353);
    this.rBD.add(paramc);
    AppMethodBeat.o(111353);
  }
  
  public final void as(String paramString, long paramLong)
  {
    AppMethodBeat.i(111357);
    j(paramString, this.rBG, paramLong);
    AppMethodBeat.o(111357);
  }
  
  public final void b(i.a parama)
  {
    AppMethodBeat.i(111355);
    this.rBB.remove(parama);
    AppMethodBeat.o(111355);
  }
  
  public final void c(i.a parama)
  {
    AppMethodBeat.i(173739);
    this.rBC.remove(parama);
    AppMethodBeat.o(173739);
  }
  
  public final int czN()
  {
    return this.jWF;
  }
  
  public final int czO()
  {
    return this.rBG;
  }
  
  public final void czP()
  {
    AppMethodBeat.i(111356);
    ad.i("MicroMsg.MediaQueryService", "queryAlbums, %s.", new Object[] { this });
    if (this.rBF == null)
    {
      ad.f("MicroMsg.MediaQueryService", "media query not init, init again");
      czM();
    }
    e.czi().ak(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(111345);
        ad.i("MicroMsg.MediaQueryService", "real run, %s.", new Object[] { this });
        Object localObject1 = o.this.rBF.cyR();
        Object localObject2 = o.this;
        Object localObject3 = new i.a[((o)localObject2).rBB.size()];
        ((o)localObject2).rBB.toArray((Object[])localObject3);
        int j = localObject3.length;
        int i = 0;
        while (i < j)
        {
          localObject3[i].ah((LinkedList)localObject1);
          i += 1;
        }
        localObject2 = s.czT();
        localObject1 = new ArrayList();
        localObject3 = s.BASE_URI.buildUpon().appendEncodedPath("private").build();
        localObject2 = ((s)localObject2).hTQ.query((Uri)localObject3, s.czU(), null, null, null);
        if (localObject2 != null)
        {
          i = ((Cursor)localObject2).getColumnIndex("categoryID");
          j = ((Cursor)localObject2).getColumnIndex("categoryName");
          int k = ((Cursor)localObject2).getColumnIndex("albumID");
          int m = ((Cursor)localObject2).getColumnIndex("albumName");
          int n = ((Cursor)localObject2).getColumnIndex("albumCapacity");
          int i1 = ((Cursor)localObject2).getColumnIndex("coverID");
          int i2 = ((Cursor)localObject2).getColumnIndex("coverData");
          int i3 = ((Cursor)localObject2).getColumnIndex("albumTag");
          while (((Cursor)localObject2).moveToNext())
          {
            localObject3 = new s.a();
            if ((i != -1) && (j != -1)) {
              ((s.a)localObject3).gp(((Cursor)localObject2).getString(i), ((Cursor)localObject2).getString(j));
            }
            ((s.a)localObject3).rCc = ((Cursor)localObject2).getString(k);
            ((s.a)localObject3).rBh = ((Cursor)localObject2).getString(m);
            ((s.a)localObject3).rCd = bt.aGh(((Cursor)localObject2).getString(n));
            ((s.a)localObject3).rCe = bt.aGi(((Cursor)localObject2).getString(i1));
            ((s.a)localObject3).rCf = ((Cursor)localObject2).getString(i2);
            if (i3 != -1)
            {
              String str = ((Cursor)localObject2).getString(i3);
              if (!bt.isNullOrNil(str)) {
                ((s.a)localObject3).rCg = s.go(str, ((s.a)localObject3).rCc);
              }
            }
            ((ArrayList)localObject1).add(localObject3);
          }
          ((Cursor)localObject2).close();
        }
        localObject1 = s.R((ArrayList)localObject1);
        o.a(o.this, (LinkedList)localObject1);
        AppMethodBeat.o(111345);
      }
      
      public final String toString()
      {
        AppMethodBeat.i(111346);
        String str = super.toString() + "|queryAlbums";
        AppMethodBeat.o(111346);
        return str;
      }
    });
    AppMethodBeat.o(111356);
  }
  
  public final void czQ()
  {
    AppMethodBeat.i(173740);
    if (this.rBF != null) {
      this.rBF.cyU();
    }
    AppMethodBeat.o(173740);
  }
  
  public final void j(final String paramString, final int paramInt, final long paramLong)
  {
    AppMethodBeat.i(111358);
    if (this.rBF == null)
    {
      ad.e("MicroMsg.MediaQueryService", "media query not init, init again");
      czM();
    }
    ad.i("MicroMsg.MediaQueryService", "queryMediaInAlbums, albumName: %s ticket: %d, stack: %s.", new Object[] { paramString, Long.valueOf(paramLong), bt.eGN().toString() });
    this.rBF.cyU();
    e.czi().al(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(111348);
        try
        {
          ad.i("MicroMsg.MediaQueryService", "queryMediaItemsInAlbum Begin...");
          o.this.rBF.a(paramString, paramInt, new i.c()
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
  
  public final void release()
  {
    AppMethodBeat.i(164768);
    if (this.rBB != null) {
      this.rBB.clear();
    }
    if (this.rBD != null) {
      this.rBD.clear();
    }
    if (this.rBE != null) {
      this.rBE.clear();
    }
    AppMethodBeat.o(164768);
  }
  
  public final void setQueryType(int paramInt)
  {
    AppMethodBeat.i(111351);
    this.rBG = paramInt;
    czM();
    AppMethodBeat.o(111351);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.o
 * JD-Core Version:    0.7.0.1
 */