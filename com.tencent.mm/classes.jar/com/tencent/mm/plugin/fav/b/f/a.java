package com.tencent.mm.plugin.fav.b.f;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.c;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.q;
import com.tencent.mm.plugin.fav.a.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public final class a
  extends MAutoStorage<c>
  implements r
{
  private ISQLiteDatabase db;
  private List<q> listeners;
  
  public a(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, c.info, "FavCdnInfo", null);
    AppMethodBeat.i(101664);
    this.listeners = new CopyOnWriteArrayList();
    this.db = paramISQLiteDatabase;
    AppMethodBeat.o(101664);
  }
  
  public final List<c> Kh(long paramLong)
  {
    AppMethodBeat.i(101672);
    ArrayList localArrayList = new ArrayList();
    Object localObject = "select * from FavCdnInfo where favLocalId = ".concat(String.valueOf(paramLong));
    localObject = this.db.rawQuery((String)localObject, null, 2);
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
    Log.v("MicroMsg.FavCdnStorage", "getInfos size:%d", new Object[] { Integer.valueOf(localArrayList.size()) });
    AppMethodBeat.o(101672);
    return localArrayList;
  }
  
  public final List<c> Ki(long paramLong)
  {
    AppMethodBeat.i(101673);
    LinkedList localLinkedList = new LinkedList();
    Object localObject = "select * from FavCdnInfo where favLocalId = " + paramLong + " and type = 0 and status = 3";
    localObject = this.db.rawQuery((String)localObject, null, 2);
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
    Log.v("MicroMsg.FavCdnStorage", "getUploadedInfos size:%d", new Object[] { Integer.valueOf(localLinkedList.size()) });
    AppMethodBeat.o(101673);
    return localLinkedList;
  }
  
  public final void Kj(long paramLong)
  {
    AppMethodBeat.i(101674);
    String str = String.format("delete from %s where %s = %d and %s = %d", new Object[] { "FavCdnInfo", "favLocalId", Long.valueOf(paramLong), "type", Integer.valueOf(0) });
    this.db.execSQL("FavCdnInfo", str);
    AppMethodBeat.o(101674);
  }
  
  public final boolean Kk(long paramLong)
  {
    AppMethodBeat.i(101678);
    c localc = new c();
    localc.field_favLocalId = paramLong;
    boolean bool = b(localc, new String[] { "favLocalId" });
    AppMethodBeat.o(101678);
    return bool;
  }
  
  public final void a(q paramq)
  {
    AppMethodBeat.i(101662);
    if (paramq != null) {
      this.listeners.add(paramq);
    }
    AppMethodBeat.o(101662);
  }
  
  public final boolean a(c paramc, String... paramVarArgs)
  {
    AppMethodBeat.i(101667);
    if (super.update(paramc, paramVarArgs))
    {
      paramVarArgs = this.listeners.iterator();
      while (paramVarArgs.hasNext())
      {
        q localq = (q)paramVarArgs.next();
        if (localq != null) {
          localq.e(paramc);
        }
      }
      AppMethodBeat.o(101667);
      return true;
    }
    AppMethodBeat.o(101667);
    return false;
  }
  
  public final c aAb(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(101669);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.FavCdnStorage", "md5 null");
      AppMethodBeat.o(101669);
      return null;
    }
    paramString = "select * from FavCdnInfo where dataId = '" + paramString + "'";
    Cursor localCursor = this.db.rawQuery(paramString, null, 2);
    if (localCursor == null)
    {
      AppMethodBeat.o(101669);
      return null;
    }
    paramString = localObject;
    if (localCursor.moveToFirst())
    {
      paramString = new c();
      paramString.convertFrom(localCursor);
    }
    localCursor.close();
    AppMethodBeat.o(101669);
    return paramString;
  }
  
  public final void b(q paramq)
  {
    AppMethodBeat.i(101663);
    if (paramq != null) {
      this.listeners.remove(paramq);
    }
    AppMethodBeat.o(101663);
  }
  
  public final boolean b(c paramc, String... paramVarArgs)
  {
    AppMethodBeat.i(101668);
    if (super.delete(paramc, paramVarArgs))
    {
      paramVarArgs = this.listeners.iterator();
      while (paramVarArgs.hasNext())
      {
        q localq = (q)paramVarArgs.next();
        if (localq != null) {
          localq.e(paramc);
        }
      }
      AppMethodBeat.o(101668);
      return true;
    }
    AppMethodBeat.o(101668);
    return false;
  }
  
  public final LinkedList<c> djQ()
  {
    AppMethodBeat.i(101671);
    Object localObject = "select * from FavCdnInfo where status = 1 order by modifyTime asc " + " limit 1";
    localObject = this.db.rawQuery((String)localObject, null, 2);
    if (localObject == null)
    {
      AppMethodBeat.o(101671);
      return null;
    }
    if (!((Cursor)localObject).moveToFirst())
    {
      ((Cursor)localObject).close();
      AppMethodBeat.o(101671);
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
    AppMethodBeat.o(101671);
    return localLinkedList;
  }
  
  public final Cursor djR()
  {
    AppMethodBeat.i(101676);
    Cursor localCursor = this.db.rawQuery("select * from FavCdnInfo where type = 0 and status = 1", null);
    AppMethodBeat.o(101676);
    return localCursor;
  }
  
  public final Cursor djS()
  {
    AppMethodBeat.i(101677);
    Cursor localCursor = this.db.rawQuery("select * from FavCdnInfo where type = 1 and status = 1", null);
    AppMethodBeat.o(101677);
    return localCursor;
  }
  
  public final boolean f(c paramc)
  {
    AppMethodBeat.i(101666);
    if (paramc == null)
    {
      AppMethodBeat.o(101666);
      return false;
    }
    if (super.insert(paramc))
    {
      Iterator localIterator = this.listeners.iterator();
      while (localIterator.hasNext())
      {
        q localq = (q)localIterator.next();
        if (localq != null) {
          localq.e(paramc);
        }
      }
      AppMethodBeat.o(101666);
      return true;
    }
    AppMethodBeat.o(101666);
    return false;
  }
  
  public final void startAll()
  {
    AppMethodBeat.i(101665);
    this.db.execSQL("FavCdnInfo", "update FavCdnInfo set status = 1 where status <> 3");
    AppMethodBeat.o(101665);
  }
  
  public final void y(g paramg)
  {
    AppMethodBeat.i(101670);
    long l = Util.nowMilliSecond();
    paramg = "update FavCdnInfo set status = 1,modifyTime = " + l + " where favLocalId = " + paramg.field_localId + " and type = 0 and status <> 3";
    this.db.execSQL("FavCdnInfo", paramg);
    AppMethodBeat.o(101670);
  }
  
  public final int z(long paramLong, int paramInt)
  {
    AppMethodBeat.i(101675);
    Object localObject = "select status from FavCdnInfo where favLocalId = " + paramLong + " and type = " + paramInt;
    localObject = this.db.rawQuery((String)localObject, null, 2);
    if (localObject == null)
    {
      AppMethodBeat.o(101675);
      return 3;
    }
    if (!((Cursor)localObject).moveToFirst())
    {
      ((Cursor)localObject).close();
      AppMethodBeat.o(101675);
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
        AppMethodBeat.o(101675);
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
      AppMethodBeat.o(101675);
      return 2;
    }
    if (k != 0)
    {
      AppMethodBeat.o(101675);
      return 4;
    }
    if (n != 0)
    {
      AppMethodBeat.o(101675);
      return 3;
    }
    AppMethodBeat.o(101675);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.b.f.a
 * JD-Core Version:    0.7.0.1
 */