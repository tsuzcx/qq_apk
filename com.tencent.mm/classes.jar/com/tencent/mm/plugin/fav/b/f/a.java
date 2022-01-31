package com.tencent.mm.plugin.fav.b.f;

import android.database.Cursor;
import com.tencent.mm.plugin.fav.a.c;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.p;
import com.tencent.mm.plugin.fav.a.q;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends i<c>
  implements q
{
  private List<p> aLS = new LinkedList();
  private e dXw;
  
  public a(e parame)
  {
    super(parame, c.buS, "FavCdnInfo", null);
    this.dXw = parame;
  }
  
  public final c CN(String paramString)
  {
    Object localObject = null;
    if (bk.bl(paramString)) {
      y.e("MicroMsg.FavCdnStorage", "md5 null");
    }
    Cursor localCursor;
    do
    {
      return null;
      paramString = "select * from FavCdnInfo where dataId = '" + paramString + "'";
      localCursor = this.dXw.a(paramString, null, 2);
    } while (localCursor == null);
    paramString = localObject;
    if (localCursor.moveToFirst())
    {
      paramString = new c();
      paramString.d(localCursor);
    }
    localCursor.close();
    return paramString;
  }
  
  public final void a(p paramp)
  {
    if (paramp != null) {
      this.aLS.add(paramp);
    }
  }
  
  public final boolean a(c paramc, String... paramVarArgs)
  {
    boolean bool = false;
    int i = 0;
    if (super.c(paramc, paramVarArgs))
    {
      paramVarArgs = new p[this.aLS.size()];
      this.aLS.toArray(paramVarArgs);
      int j = paramVarArgs.length;
      while (i < j)
      {
        String str = paramVarArgs[i];
        if (str != null) {
          str.d(paramc);
        }
        i += 1;
      }
      bool = true;
    }
    return bool;
  }
  
  public final void aQn()
  {
    this.dXw.gk("FavCdnInfo", "update FavCdnInfo set status = 1 where status <> 3");
  }
  
  public final LinkedList<c> aQo()
  {
    Object localObject = "select * from FavCdnInfo where status = 1 order by modifyTime desc " + " limit 1";
    localObject = this.dXw.a((String)localObject, null, 2);
    if (localObject == null) {
      return null;
    }
    if (!((Cursor)localObject).moveToFirst())
    {
      ((Cursor)localObject).close();
      return null;
    }
    LinkedList localLinkedList = new LinkedList();
    do
    {
      c localc = new c();
      localc.d((Cursor)localObject);
      localLinkedList.add(localc);
    } while (((Cursor)localObject).moveToNext());
    ((Cursor)localObject).close();
    return localLinkedList;
  }
  
  public final Cursor aQp()
  {
    return this.dXw.rawQuery("select * from FavCdnInfo where type = 0 and status = 1", null);
  }
  
  public final Cursor aQq()
  {
    return this.dXw.rawQuery("select * from FavCdnInfo where type = 1 and status = 1", null);
  }
  
  public final void b(p paramp)
  {
    if (paramp != null) {
      this.aLS.remove(paramp);
    }
  }
  
  public final boolean b(c paramc, String... paramVarArgs)
  {
    boolean bool = false;
    int i = 0;
    if (super.a(paramc, paramVarArgs))
    {
      paramVarArgs = new p[this.aLS.size()];
      this.aLS.toArray(paramVarArgs);
      int j = paramVarArgs.length;
      while (i < j)
      {
        String str = paramVarArgs[i];
        if (str != null) {
          str.d(paramc);
        }
        i += 1;
      }
      bool = true;
    }
    return bool;
  }
  
  public final boolean e(c paramc)
  {
    int i = 0;
    if (paramc == null) {}
    while (!super.b(paramc)) {
      return false;
    }
    p[] arrayOfp = new p[this.aLS.size()];
    this.aLS.toArray(arrayOfp);
    int j = arrayOfp.length;
    while (i < j)
    {
      p localp = arrayOfp[i];
      if (localp != null) {
        localp.d(paramc);
      }
      i += 1;
    }
    return true;
  }
  
  public final List<c> eA(long paramLong)
  {
    LinkedList localLinkedList = new LinkedList();
    Object localObject = "select * from FavCdnInfo where favLocalId = " + paramLong + " and type = 0 and status = 3";
    localObject = this.dXw.a((String)localObject, null, 2);
    if ((localObject != null) && (((Cursor)localObject).moveToFirst())) {
      do
      {
        c localc = new c();
        localc.d((Cursor)localObject);
        localLinkedList.add(localc);
      } while (((Cursor)localObject).moveToNext());
    }
    if (localObject != null) {
      ((Cursor)localObject).close();
    }
    y.v("MicroMsg.FavCdnStorage", "getUploadedInfos size:%d", new Object[] { Integer.valueOf(localLinkedList.size()) });
    return localLinkedList;
  }
  
  public final void eB(long paramLong)
  {
    String str = String.format("delete from %s where %s = %d and %s = %d", new Object[] { "FavCdnInfo", "favLocalId", Long.valueOf(paramLong), "type", Integer.valueOf(0) });
    this.dXw.gk("FavCdnInfo", str);
  }
  
  public final boolean eC(long paramLong)
  {
    c localc = new c();
    localc.field_favLocalId = paramLong;
    return b(localc, new String[] { "favLocalId" });
  }
  
  public final List<c> ez(long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = "select * from FavCdnInfo where favLocalId = " + paramLong;
    localObject = this.dXw.a((String)localObject, null, 2);
    if (localObject != null)
    {
      while (((Cursor)localObject).moveToNext())
      {
        c localc = new c();
        localc.d((Cursor)localObject);
        localArrayList.add(localc);
      }
      ((Cursor)localObject).close();
    }
    y.v("MicroMsg.FavCdnStorage", "getInfos size:%d", new Object[] { Integer.valueOf(localArrayList.size()) });
    return localArrayList;
  }
  
  public final int o(long paramLong, int paramInt)
  {
    Object localObject = "select status from FavCdnInfo where favLocalId = " + paramLong + " and type = " + paramInt;
    localObject = this.dXw.a((String)localObject, null, 2);
    if (localObject == null) {
      return 3;
    }
    if (!((Cursor)localObject).moveToFirst())
    {
      ((Cursor)localObject).close();
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
    if (m != 0) {
      return 2;
    }
    if (k != 0) {
      return 4;
    }
    if (n != 0) {
      return 3;
    }
    return 0;
  }
  
  public final void x(g paramg)
  {
    long l = bk.UY();
    paramg = "update FavCdnInfo set status = 1,modifyTime = " + l + " where favLocalId = " + paramg.field_localId + " and type = 0 and status <> 3";
    this.dXw.gk("FavCdnInfo", paramg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.b.f.a
 * JD-Core Version:    0.7.0.1
 */