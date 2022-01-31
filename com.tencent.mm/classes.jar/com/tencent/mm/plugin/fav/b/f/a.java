package com.tencent.mm.plugin.fav.b.f;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.c;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.p;
import com.tencent.mm.plugin.fav.a.q;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public final class a
  extends j<c>
  implements q
{
  private List<p> aTm;
  private e db;
  
  public a(e parame)
  {
    super(parame, c.info, "FavCdnInfo", null);
    AppMethodBeat.i(5404);
    this.aTm = new CopyOnWriteArrayList();
    this.db = parame;
    AppMethodBeat.o(5404);
  }
  
  public final c NP(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(5409);
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.FavCdnStorage", "md5 null");
      AppMethodBeat.o(5409);
      return null;
    }
    paramString = "select * from FavCdnInfo where dataId = '" + paramString + "'";
    Cursor localCursor = this.db.a(paramString, null, 2);
    if (localCursor == null)
    {
      AppMethodBeat.o(5409);
      return null;
    }
    paramString = localObject;
    if (localCursor.moveToFirst())
    {
      paramString = new c();
      paramString.convertFrom(localCursor);
    }
    localCursor.close();
    AppMethodBeat.o(5409);
    return paramString;
  }
  
  public final void a(p paramp)
  {
    AppMethodBeat.i(5402);
    if (paramp != null) {
      this.aTm.add(paramp);
    }
    AppMethodBeat.o(5402);
  }
  
  public final boolean a(c paramc, String... paramVarArgs)
  {
    AppMethodBeat.i(5407);
    if (super.update(paramc, paramVarArgs))
    {
      paramVarArgs = this.aTm.iterator();
      while (paramVarArgs.hasNext())
      {
        p localp = (p)paramVarArgs.next();
        if (localp != null) {
          localp.d(paramc);
        }
      }
      AppMethodBeat.o(5407);
      return true;
    }
    AppMethodBeat.o(5407);
    return false;
  }
  
  public final void b(p paramp)
  {
    AppMethodBeat.i(5403);
    if (paramp != null) {
      this.aTm.remove(paramp);
    }
    AppMethodBeat.o(5403);
  }
  
  public final boolean b(c paramc, String... paramVarArgs)
  {
    AppMethodBeat.i(5408);
    if (super.delete(paramc, paramVarArgs))
    {
      paramVarArgs = this.aTm.iterator();
      while (paramVarArgs.hasNext())
      {
        p localp = (p)paramVarArgs.next();
        if (localp != null) {
          localp.d(paramc);
        }
      }
      AppMethodBeat.o(5408);
      return true;
    }
    AppMethodBeat.o(5408);
    return false;
  }
  
  public final LinkedList<c> bwD()
  {
    AppMethodBeat.i(5411);
    Object localObject = "select * from FavCdnInfo where status = 1 order by modifyTime desc " + " limit 1";
    localObject = this.db.a((String)localObject, null, 2);
    if (localObject == null)
    {
      AppMethodBeat.o(5411);
      return null;
    }
    if (!((Cursor)localObject).moveToFirst())
    {
      ((Cursor)localObject).close();
      AppMethodBeat.o(5411);
      return null;
    }
    LinkedList localLinkedList = new LinkedList();
    do
    {
      c localc = new c();
      localc.convertFrom((Cursor)localObject);
      localLinkedList.add(localc);
    } while (((Cursor)localObject).moveToNext());
    ((Cursor)localObject).close();
    AppMethodBeat.o(5411);
    return localLinkedList;
  }
  
  public final Cursor bwE()
  {
    AppMethodBeat.i(5416);
    Cursor localCursor = this.db.rawQuery("select * from FavCdnInfo where type = 0 and status = 1", null);
    AppMethodBeat.o(5416);
    return localCursor;
  }
  
  public final Cursor bwF()
  {
    AppMethodBeat.i(5417);
    Cursor localCursor = this.db.rawQuery("select * from FavCdnInfo where type = 1 and status = 1", null);
    AppMethodBeat.o(5417);
    return localCursor;
  }
  
  public final boolean e(c paramc)
  {
    AppMethodBeat.i(5406);
    if (paramc == null)
    {
      AppMethodBeat.o(5406);
      return false;
    }
    if (super.insert(paramc))
    {
      Iterator localIterator = this.aTm.iterator();
      while (localIterator.hasNext())
      {
        p localp = (p)localIterator.next();
        if (localp != null) {
          localp.d(paramc);
        }
      }
      AppMethodBeat.o(5406);
      return true;
    }
    AppMethodBeat.o(5406);
    return false;
  }
  
  public final List<c> jW(long paramLong)
  {
    AppMethodBeat.i(5412);
    ArrayList localArrayList = new ArrayList();
    Object localObject = "select * from FavCdnInfo where favLocalId = ".concat(String.valueOf(paramLong));
    localObject = this.db.a((String)localObject, null, 2);
    if (localObject != null)
    {
      while (((Cursor)localObject).moveToNext())
      {
        c localc = new c();
        localc.convertFrom((Cursor)localObject);
        localArrayList.add(localc);
      }
      ((Cursor)localObject).close();
    }
    ab.v("MicroMsg.FavCdnStorage", "getInfos size:%d", new Object[] { Integer.valueOf(localArrayList.size()) });
    AppMethodBeat.o(5412);
    return localArrayList;
  }
  
  public final List<c> jX(long paramLong)
  {
    AppMethodBeat.i(5413);
    LinkedList localLinkedList = new LinkedList();
    Object localObject = "select * from FavCdnInfo where favLocalId = " + paramLong + " and type = 0 and status = 3";
    localObject = this.db.a((String)localObject, null, 2);
    if ((localObject != null) && (((Cursor)localObject).moveToFirst())) {
      do
      {
        c localc = new c();
        localc.convertFrom((Cursor)localObject);
        localLinkedList.add(localc);
      } while (((Cursor)localObject).moveToNext());
    }
    if (localObject != null) {
      ((Cursor)localObject).close();
    }
    ab.v("MicroMsg.FavCdnStorage", "getUploadedInfos size:%d", new Object[] { Integer.valueOf(localLinkedList.size()) });
    AppMethodBeat.o(5413);
    return localLinkedList;
  }
  
  public final void jY(long paramLong)
  {
    AppMethodBeat.i(5414);
    String str = String.format("delete from %s where %s = %d and %s = %d", new Object[] { "FavCdnInfo", "favLocalId", Long.valueOf(paramLong), "type", Integer.valueOf(0) });
    this.db.execSQL("FavCdnInfo", str);
    AppMethodBeat.o(5414);
  }
  
  public final boolean jZ(long paramLong)
  {
    AppMethodBeat.i(5418);
    c localc = new c();
    localc.field_favLocalId = paramLong;
    boolean bool = b(localc, new String[] { "favLocalId" });
    AppMethodBeat.o(5418);
    return bool;
  }
  
  public final void startAll()
  {
    AppMethodBeat.i(5405);
    this.db.execSQL("FavCdnInfo", "update FavCdnInfo set status = 1 where status <> 3");
    AppMethodBeat.o(5405);
  }
  
  public final int t(long paramLong, int paramInt)
  {
    AppMethodBeat.i(5415);
    Object localObject = "select status from FavCdnInfo where favLocalId = " + paramLong + " and type = " + paramInt;
    localObject = this.db.a((String)localObject, null, 2);
    if (localObject == null)
    {
      AppMethodBeat.o(5415);
      return 3;
    }
    if (!((Cursor)localObject).moveToFirst())
    {
      ((Cursor)localObject).close();
      AppMethodBeat.o(5415);
      return 3;
    }
    paramInt = 1;
    int i = 1;
    int j = 1;
    int k;
    int m;
    int n;
    do
    {
      int i1 = ((Cursor)localObject).getInt(0);
      if (i1 == 1)
      {
        ((Cursor)localObject).close();
        AppMethodBeat.o(5415);
        return 1;
      }
      k = j;
      if (i1 != 4) {
        k = 0;
      }
      m = i;
      if (i1 != 2) {
        m = 0;
      }
      n = paramInt;
      if (i1 != 3) {
        n = 0;
      }
      paramInt = n;
      i = m;
      j = k;
    } while (((Cursor)localObject).moveToNext());
    ((Cursor)localObject).close();
    if (m != 0)
    {
      AppMethodBeat.o(5415);
      return 2;
    }
    if (k != 0)
    {
      AppMethodBeat.o(5415);
      return 4;
    }
    if (n != 0)
    {
      AppMethodBeat.o(5415);
      return 3;
    }
    AppMethodBeat.o(5415);
    return 0;
  }
  
  public final void x(g paramg)
  {
    AppMethodBeat.i(5410);
    long l = bo.aoy();
    paramg = "update FavCdnInfo set status = 1,modifyTime = " + l + " where favLocalId = " + paramg.field_localId + " and type = 0 and status <> 3";
    this.db.execSQL("FavCdnInfo", paramg);
    AppMethodBeat.o(5410);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.b.f.a
 * JD-Core Version:    0.7.0.1
 */