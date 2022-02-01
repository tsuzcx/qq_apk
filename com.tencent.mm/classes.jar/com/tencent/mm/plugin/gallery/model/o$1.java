package com.tencent.mm.plugin.gallery.model;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.net.Uri.Builder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

final class o$1
  implements Runnable
{
  o$1(o paramo) {}
  
  public final void run()
  {
    AppMethodBeat.i(111345);
    ae.i("MicroMsg.MediaQueryService", "real run, %s.", new Object[] { this });
    Object localObject1 = this.tSc.tSa.cXb();
    Object localObject2 = this.tSc;
    Object localObject3 = new i.a[((o)localObject2).tRW.size()];
    ((o)localObject2).tRW.toArray((Object[])localObject3);
    int j = localObject3.length;
    int i = 0;
    while (i < j)
    {
      localObject3[i].aq((LinkedList)localObject1);
      i += 1;
    }
    localObject2 = s.cYc();
    localObject1 = new ArrayList();
    localObject3 = s.BASE_URI.buildUpon().appendEncodedPath("private").build();
    localObject2 = ((s)localObject2).gJw.query((Uri)localObject3, s.cYd(), null, null, null);
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
          ((s.a)localObject3).gW(((Cursor)localObject2).getString(i), ((Cursor)localObject2).getString(j));
        }
        ((s.a)localObject3).tSw = ((Cursor)localObject2).getString(k);
        ((s.a)localObject3).tRB = ((Cursor)localObject2).getString(m);
        ((s.a)localObject3).tSx = bu.aSB(((Cursor)localObject2).getString(n));
        ((s.a)localObject3).tSy = bu.aSC(((Cursor)localObject2).getString(i1));
        ((s.a)localObject3).tSz = ((Cursor)localObject2).getString(i2);
        if (i3 != -1)
        {
          String str = ((Cursor)localObject2).getString(i3);
          if (!bu.isNullOrNil(str)) {
            ((s.a)localObject3).tSA = s.gV(str, ((s.a)localObject3).tSw);
          }
        }
        ((ArrayList)localObject1).add(localObject3);
      }
      ((Cursor)localObject2).close();
    }
    localObject1 = s.ab((ArrayList)localObject1);
    o.a(this.tSc, (LinkedList)localObject1);
    AppMethodBeat.o(111345);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(111346);
    String str = super.toString() + "|queryAlbums";
    AppMethodBeat.o(111346);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.o.1
 * JD-Core Version:    0.7.0.1
 */