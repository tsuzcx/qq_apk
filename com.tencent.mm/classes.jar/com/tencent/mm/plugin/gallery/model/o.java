package com.tencent.mm.plugin.gallery.model;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.net.Uri.Builder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public final class o
{
  public int kxr;
  HashSet<i.a> sKu;
  public HashSet<i.a> sKv;
  public HashSet<i.c> sKw;
  public HashSet<i.b> sKx;
  public i sKy;
  public int sKz;
  
  public o()
  {
    AppMethodBeat.i(111350);
    this.kxr = 3;
    this.sKz = 1;
    this.sKu = new HashSet();
    this.sKv = new HashSet();
    this.sKw = new HashSet();
    this.sKx = new HashSet();
    AppMethodBeat.o(111350);
  }
  
  private void cMY()
  {
    AppMethodBeat.i(111352);
    ac.i("MicroMsg.MediaQueryService", "initQueryType: %d", new Object[] { Integer.valueOf(this.sKz) });
    switch (this.sKz)
    {
    default: 
      this.sKy = new a();
      AppMethodBeat.o(111352);
      return;
    case 1: 
      this.sKy = new k();
      AppMethodBeat.o(111352);
      return;
    }
    this.sKy = new u();
    AppMethodBeat.o(111352);
  }
  
  public final void a(i.a parama)
  {
    AppMethodBeat.i(111354);
    this.sKu.add(parama);
    AppMethodBeat.o(111354);
  }
  
  public final void a(i.c paramc)
  {
    AppMethodBeat.i(111353);
    this.sKw.add(paramc);
    AppMethodBeat.o(111353);
  }
  
  public final void au(String paramString, long paramLong)
  {
    AppMethodBeat.i(111357);
    j(paramString, this.sKz, paramLong);
    AppMethodBeat.o(111357);
  }
  
  public final void b(i.a parama)
  {
    AppMethodBeat.i(111355);
    this.sKu.remove(parama);
    AppMethodBeat.o(111355);
  }
  
  public final void c(i.a parama)
  {
    AppMethodBeat.i(173739);
    this.sKv.remove(parama);
    AppMethodBeat.o(173739);
  }
  
  public final int cMZ()
  {
    return this.kxr;
  }
  
  public final int cNa()
  {
    return this.sKz;
  }
  
  public final void cNb()
  {
    AppMethodBeat.i(111356);
    ac.i("MicroMsg.MediaQueryService", "queryAlbums, %s.", new Object[] { this });
    if (this.sKy == null)
    {
      ac.f("MicroMsg.MediaQueryService", "media query not init, init again");
      cMY();
    }
    e.cMu().am(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(111345);
        ac.i("MicroMsg.MediaQueryService", "real run, %s.", new Object[] { this });
        Object localObject1 = o.this.sKy.cMd();
        Object localObject2 = o.this;
        Object localObject3 = new i.a[((o)localObject2).sKu.size()];
        ((o)localObject2).sKu.toArray((Object[])localObject3);
        int j = localObject3.length;
        int i = 0;
        while (i < j)
        {
          localObject3[i].ao((LinkedList)localObject1);
          i += 1;
        }
        localObject2 = s.cNf();
        localObject1 = new ArrayList();
        localObject3 = s.BASE_URI.buildUpon().appendEncodedPath("private").build();
        localObject2 = ((s)localObject2).gne.query((Uri)localObject3, s.cNg(), null, null, null);
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
              ((s.a)localObject3).gG(((Cursor)localObject2).getString(i), ((Cursor)localObject2).getString(j));
            }
            ((s.a)localObject3).sKV = ((Cursor)localObject2).getString(k);
            ((s.a)localObject3).sJZ = ((Cursor)localObject2).getString(m);
            ((s.a)localObject3).sKW = bs.aLy(((Cursor)localObject2).getString(n));
            ((s.a)localObject3).sKX = bs.aLz(((Cursor)localObject2).getString(i1));
            ((s.a)localObject3).sKY = ((Cursor)localObject2).getString(i2);
            if (i3 != -1)
            {
              String str = ((Cursor)localObject2).getString(i3);
              if (!bs.isNullOrNil(str)) {
                ((s.a)localObject3).sKZ = s.gF(str, ((s.a)localObject3).sKV);
              }
            }
            ((ArrayList)localObject1).add(localObject3);
          }
          ((Cursor)localObject2).close();
        }
        localObject1 = s.ac((ArrayList)localObject1);
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
  
  public final void cNc()
  {
    AppMethodBeat.i(173740);
    if (this.sKy != null) {
      this.sKy.cMg();
    }
    AppMethodBeat.o(173740);
  }
  
  public final void j(final String paramString, final int paramInt, final long paramLong)
  {
    AppMethodBeat.i(111358);
    if (this.sKy == null)
    {
      ac.e("MicroMsg.MediaQueryService", "media query not init, init again");
      cMY();
    }
    ac.i("MicroMsg.MediaQueryService", "queryMediaInAlbums, albumName: %s ticket: %d, stack: %s.", new Object[] { paramString, Long.valueOf(paramLong), bs.eWi().toString() });
    this.sKy.cMg();
    e.cMu().an(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(111348);
        try
        {
          ac.i("MicroMsg.MediaQueryService", "queryMediaItemsInAlbum Begin...");
          o.this.sKy.a(paramString, paramInt, new i.c()
          {
            public final void b(LinkedList<GalleryItem.MediaItem> paramAnonymous2LinkedList, long paramAnonymous2Long, boolean paramAnonymous2Boolean)
            {
              AppMethodBeat.i(111347);
              ac.i("MicroMsg.MediaQueryService", "queryMediaItemsInAlbum callback, size: %d.", new Object[] { Integer.valueOf(paramAnonymous2LinkedList.size()) });
              o.a(o.this, paramAnonymous2LinkedList, paramAnonymous2Long, paramAnonymous2Boolean);
              AppMethodBeat.o(111347);
            }
          }, paramLong);
          AppMethodBeat.o(111348);
          return;
        }
        catch (SecurityException localSecurityException)
        {
          ac.printErrStackTrace("MicroMsg.MediaQueryService", localSecurityException, "", new Object[0]);
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
    if (this.sKu != null) {
      this.sKu.clear();
    }
    if (this.sKw != null) {
      this.sKw.clear();
    }
    if (this.sKx != null) {
      this.sKx.clear();
    }
    AppMethodBeat.o(164768);
  }
  
  public final void setQueryType(int paramInt)
  {
    AppMethodBeat.i(111351);
    this.sKz = paramInt;
    cMY();
    AppMethodBeat.o(111351);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.o
 * JD-Core Version:    0.7.0.1
 */