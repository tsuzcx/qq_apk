package com.tencent.mm.plugin.gallery.model;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.net.Uri.Builder;
import com.tencent.luggage.l.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public final class q
{
  public HashSet<l.a> HHV;
  public HashSet<l.a> HHW;
  public HashSet<l.c> HHX;
  public HashSet<l.b> HHY;
  public l HHZ;
  public int HIa;
  public int sfB;
  
  public q()
  {
    AppMethodBeat.i(111350);
    this.sfB = 3;
    this.HIa = 1;
    this.HHV = new HashSet();
    this.HHW = new HashSet();
    this.HHX = new HashSet();
    this.HHY = new HashSet();
    AppMethodBeat.o(111350);
  }
  
  private void fAQ()
  {
    AppMethodBeat.i(111352);
    Log.i("MicroMsg.MediaQueryService", "initQueryType: %d", new Object[] { Integer.valueOf(this.HIa) });
    switch (this.HIa)
    {
    default: 
      this.HHZ = new a();
      AppMethodBeat.o(111352);
      return;
    case 1: 
      this.HHZ = new n();
      AppMethodBeat.o(111352);
      return;
    }
    this.HHZ = new v();
    AppMethodBeat.o(111352);
  }
  
  public final void F(final String paramString, final int paramInt, final long paramLong)
  {
    AppMethodBeat.i(111358);
    if (this.HHZ == null)
    {
      Log.e("MicroMsg.MediaQueryService", "media query not init, init again");
      fAQ();
    }
    Log.i("MicroMsg.MediaQueryService", "queryMediaInAlbums, albumName: %s ticket: %d, stack: %s.", new Object[] { paramString, Long.valueOf(paramLong), Util.getStack().toString() });
    this.HHZ.fAa();
    e.fAo().aH(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(111348);
        try
        {
          Log.i("MicroMsg.MediaQueryService", "queryMediaItemsInAlbum Begin...");
          q.this.HHZ.a(paramString, paramInt, new l.c()
          {
            public final void b(LinkedList<GalleryItem.MediaItem> paramAnonymous2LinkedList, long paramAnonymous2Long, boolean paramAnonymous2Boolean)
            {
              AppMethodBeat.i(111347);
              Log.i("MicroMsg.MediaQueryService", "queryMediaItemsInAlbum callback, size: %d.", new Object[] { Integer.valueOf(paramAnonymous2LinkedList.size()) });
              q.a(q.this, paramAnonymous2LinkedList, paramAnonymous2Long, paramAnonymous2Boolean);
              AppMethodBeat.o(111347);
            }
          }, paramLong);
          AppMethodBeat.o(111348);
          return;
        }
        catch (SecurityException localSecurityException)
        {
          Log.printErrStackTrace("MicroMsg.MediaQueryService", localSecurityException, "", new Object[0]);
          q.a(q.this, new LinkedList(), paramLong, false);
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
  
  public final void a(l.a parama)
  {
    AppMethodBeat.i(111354);
    this.HHV.add(parama);
    AppMethodBeat.o(111354);
  }
  
  public final void a(l.c paramc)
  {
    AppMethodBeat.i(111353);
    this.HHX.add(paramc);
    AppMethodBeat.o(111353);
  }
  
  public final void aI(String paramString, long paramLong)
  {
    AppMethodBeat.i(111357);
    F(paramString, this.HIa, paramLong);
    AppMethodBeat.o(111357);
  }
  
  public final void b(l.a parama)
  {
    AppMethodBeat.i(111355);
    this.HHV.remove(parama);
    AppMethodBeat.o(111355);
  }
  
  public final void b(l.c paramc)
  {
    AppMethodBeat.i(289602);
    this.HHX.remove(paramc);
    AppMethodBeat.o(289602);
  }
  
  public final void c(l.a parama)
  {
    AppMethodBeat.i(173739);
    this.HHW.remove(parama);
    AppMethodBeat.o(173739);
  }
  
  public final void fAR()
  {
    AppMethodBeat.i(111356);
    Log.i("MicroMsg.MediaQueryService", "queryAlbums, %s.", new Object[] { this });
    if (this.HHZ == null)
    {
      Log.f("MicroMsg.MediaQueryService", "media query not init, init again");
      fAQ();
    }
    e.fAo().aG(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(111345);
        Log.i("MicroMsg.MediaQueryService", "real run, %s.", new Object[] { this });
        Object localObject1 = q.this.HHZ.fzT();
        Object localObject2 = q.this;
        Object localObject3 = new l.a[((q)localObject2).HHV.size()];
        ((q)localObject2).HHV.toArray((Object[])localObject3);
        int j = localObject3.length;
        int i = 0;
        while (i < j)
        {
          localObject3[i].bm((LinkedList)localObject1);
          i += 1;
        }
        localObject2 = t.fAV();
        localObject1 = new ArrayList();
        if (!i.s(MMApplicationContext.getContext(), "android.permission.READ_EXTERNAL_STORAGE")) {
          Log.i("MicroMsg.SmartGalleryQueryUtil", "queryAlbum without READ_EXTERNAL_STORAGE.");
        }
        for (;;)
        {
          localObject1 = t.aK((ArrayList)localObject1);
          q.a(q.this, (LinkedList)localObject1);
          AppMethodBeat.o(111345);
          return;
          Log.i("MicroMsg.SmartGalleryQueryUtil", "has permiss.");
          localObject3 = t.dYo.buildUpon().appendEncodedPath("private").build();
          localObject2 = ((t)localObject2).mJn.query((Uri)localObject3, t.fAW(), null, null, null);
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
              localObject3 = new t.a();
              if ((i != -1) && (j != -1)) {
                ((t.a)localObject3).iM(((Cursor)localObject2).getString(i), ((Cursor)localObject2).getString(j));
              }
              ((t.a)localObject3).HIx = ((Cursor)localObject2).getString(k);
              ((t.a)localObject3).albumName = ((Cursor)localObject2).getString(m);
              ((t.a)localObject3).HIy = Util.safeParseInt(((Cursor)localObject2).getString(n));
              ((t.a)localObject3).HIz = Util.safeParseLong(((Cursor)localObject2).getString(i1));
              ((t.a)localObject3).HIA = ((Cursor)localObject2).getString(i2);
              if (i3 != -1)
              {
                String str = ((Cursor)localObject2).getString(i3);
                if (!Util.isNullOrNil(str)) {
                  ((t.a)localObject3).HIB = t.iL(str, ((t.a)localObject3).HIx);
                }
              }
              ((ArrayList)localObject1).add(localObject3);
            }
            ((Cursor)localObject2).close();
          }
        }
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
  
  public final void fAS()
  {
    AppMethodBeat.i(173740);
    if (this.HHZ != null) {
      this.HHZ.fAa();
    }
    AppMethodBeat.o(173740);
  }
  
  public final void setQueryType(int paramInt)
  {
    AppMethodBeat.i(111351);
    this.HIa = paramInt;
    fAQ();
    AppMethodBeat.o(111351);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.q
 * JD-Core Version:    0.7.0.1
 */