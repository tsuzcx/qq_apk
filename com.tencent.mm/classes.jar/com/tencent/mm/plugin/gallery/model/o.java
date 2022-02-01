package com.tencent.mm.plugin.gallery.model;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.net.Uri.Builder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public final class o
{
  public int mcq;
  HashSet<i.a> xjj;
  public HashSet<i.a> xjk;
  private HashSet<i.c> xjl;
  public HashSet<i.b> xjm;
  public i xjn;
  public int xjo;
  
  public o()
  {
    AppMethodBeat.i(111350);
    this.mcq = 3;
    this.xjo = 1;
    this.xjj = new HashSet();
    this.xjk = new HashSet();
    this.xjl = new HashSet();
    this.xjm = new HashSet();
    AppMethodBeat.o(111350);
  }
  
  private void dRo()
  {
    AppMethodBeat.i(111352);
    Log.i("MicroMsg.MediaQueryService", "initQueryType: %d", new Object[] { Integer.valueOf(this.xjo) });
    switch (this.xjo)
    {
    default: 
      this.xjn = new a();
      AppMethodBeat.o(111352);
      return;
    case 1: 
      this.xjn = new k();
      AppMethodBeat.o(111352);
      return;
    }
    this.xjn = new u();
    AppMethodBeat.o(111352);
  }
  
  public final void D(final String paramString, final int paramInt, final long paramLong)
  {
    AppMethodBeat.i(111358);
    if (this.xjn == null)
    {
      Log.e("MicroMsg.MediaQueryService", "media query not init, init again");
      dRo();
    }
    Log.i("MicroMsg.MediaQueryService", "queryMediaInAlbums, albumName: %s ticket: %d, stack: %s.", new Object[] { paramString, Long.valueOf(paramLong), Util.getStack().toString() });
    this.xjn.dQx();
    e.dQL().as(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(111348);
        try
        {
          Log.i("MicroMsg.MediaQueryService", "queryMediaItemsInAlbum Begin...");
          o.this.xjn.a(paramString, paramInt, new i.c()
          {
            public final void b(LinkedList<GalleryItem.MediaItem> paramAnonymous2LinkedList, long paramAnonymous2Long, boolean paramAnonymous2Boolean)
            {
              AppMethodBeat.i(111347);
              Log.i("MicroMsg.MediaQueryService", "queryMediaItemsInAlbum callback, size: %d.", new Object[] { Integer.valueOf(paramAnonymous2LinkedList.size()) });
              o.a(o.this, paramAnonymous2LinkedList, paramAnonymous2Long, paramAnonymous2Boolean);
              AppMethodBeat.o(111347);
            }
          }, paramLong);
          AppMethodBeat.o(111348);
          return;
        }
        catch (SecurityException localSecurityException)
        {
          Log.printErrStackTrace("MicroMsg.MediaQueryService", localSecurityException, "", new Object[0]);
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
  
  public final void NG(int paramInt)
  {
    this.mcq = paramInt;
  }
  
  public final void a(i.a parama)
  {
    AppMethodBeat.i(111354);
    this.xjj.add(parama);
    AppMethodBeat.o(111354);
  }
  
  public final void a(i.c paramc)
  {
    AppMethodBeat.i(111353);
    this.xjl.add(paramc);
    AppMethodBeat.o(111353);
  }
  
  public final void ax(String paramString, long paramLong)
  {
    AppMethodBeat.i(111357);
    D(paramString, this.xjo, paramLong);
    AppMethodBeat.o(111357);
  }
  
  public final void b(i.a parama)
  {
    AppMethodBeat.i(111355);
    this.xjj.remove(parama);
    AppMethodBeat.o(111355);
  }
  
  public final void b(i.c paramc)
  {
    AppMethodBeat.i(257731);
    this.xjl.remove(paramc);
    AppMethodBeat.o(257731);
  }
  
  public final void c(i.a parama)
  {
    AppMethodBeat.i(173739);
    this.xjk.remove(parama);
    AppMethodBeat.o(173739);
  }
  
  public final int dRp()
  {
    return this.mcq;
  }
  
  public final int dRq()
  {
    return this.xjo;
  }
  
  public final void dRr()
  {
    AppMethodBeat.i(111356);
    Log.i("MicroMsg.MediaQueryService", "queryAlbums, %s.", new Object[] { this });
    if (this.xjn == null)
    {
      Log.f("MicroMsg.MediaQueryService", "media query not init, init again");
      dRo();
    }
    e.dQL().ar(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(111345);
        Log.i("MicroMsg.MediaQueryService", "real run, %s.", new Object[] { this });
        Object localObject1 = o.this.xjn.dQr();
        Object localObject2 = o.this;
        Object localObject3 = new i.a[((o)localObject2).xjj.size()];
        ((o)localObject2).xjj.toArray((Object[])localObject3);
        int j = localObject3.length;
        int i = 0;
        while (i < j)
        {
          localObject3[i].aL((LinkedList)localObject1);
          i += 1;
        }
        localObject2 = s.dRv();
        localObject1 = new ArrayList();
        localObject3 = s.BASE_URI.buildUpon().appendEncodedPath("private").build();
        localObject2 = ((s)localObject2).hwt.query((Uri)localObject3, s.dRw(), null, null, null);
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
              ((s.a)localObject3).hD(((Cursor)localObject2).getString(i), ((Cursor)localObject2).getString(j));
            }
            ((s.a)localObject3).xjJ = ((Cursor)localObject2).getString(k);
            ((s.a)localObject3).albumName = ((Cursor)localObject2).getString(m);
            ((s.a)localObject3).xjK = Util.safeParseInt(((Cursor)localObject2).getString(n));
            ((s.a)localObject3).xjL = Util.safeParseLong(((Cursor)localObject2).getString(i1));
            ((s.a)localObject3).xjM = ((Cursor)localObject2).getString(i2);
            if (i3 != -1)
            {
              String str = ((Cursor)localObject2).getString(i3);
              if (!Util.isNullOrNil(str)) {
                ((s.a)localObject3).xjN = s.hC(str, ((s.a)localObject3).xjJ);
              }
            }
            ((ArrayList)localObject1).add(localObject3);
          }
          ((Cursor)localObject2).close();
        }
        localObject1 = s.ap((ArrayList)localObject1);
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
  
  public final void dRs()
  {
    AppMethodBeat.i(173740);
    if (this.xjn != null) {
      this.xjn.dQx();
    }
    AppMethodBeat.o(173740);
  }
  
  public final void release()
  {
    AppMethodBeat.i(164768);
    if (this.xjj != null) {
      this.xjj.clear();
    }
    if (this.xjl != null) {
      this.xjl.clear();
    }
    if (this.xjm != null) {
      this.xjm.clear();
    }
    AppMethodBeat.o(164768);
  }
  
  public final void setQueryType(int paramInt)
  {
    AppMethodBeat.i(111351);
    this.xjo = paramInt;
    dRo();
    AppMethodBeat.o(111351);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.o
 * JD-Core Version:    0.7.0.1
 */