package com.tencent.mm.cf.a;

import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.DataSetObserver;
import android.util.SparseArray;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.wcdb.AbstractCursor;
import com.tencent.wcdb.Cursor;
import com.tencent.wcdb.DatabaseUtils;
import com.tencent.wcdb.database.SQLiteCursorDriver;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteDatabase.CursorFactory;
import com.tencent.wcdb.database.SQLiteProgram;
import com.tencent.wcdb.support.CancellationSignal;
import com.tencent.wcdb.support.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class f
  extends AbstractCursor
  implements d
{
  public static final SQLiteDatabase.CursorFactory FACTORY = new SQLiteDatabase.CursorFactory()
  {
    public final Cursor newCursor(SQLiteDatabase paramAnonymousSQLiteDatabase, SQLiteCursorDriver paramAnonymousSQLiteCursorDriver, String paramAnonymousString, SQLiteProgram paramAnonymousSQLiteProgram)
    {
      return new f(paramAnonymousSQLiteCursorDriver, paramAnonymousString, (h)paramAnonymousSQLiteProgram);
    }
    
    public final SQLiteProgram newQuery(SQLiteDatabase paramAnonymousSQLiteDatabase, String paramAnonymousString, Object[] paramAnonymousArrayOfObject, CancellationSignal paramAnonymousCancellationSignal)
    {
      return new h(paramAnonymousSQLiteDatabase, paramAnonymousString, paramAnonymousCancellationSignal);
    }
  };
  private Map<String, Integer> mColumnNameMap;
  private final String[] mColumns;
  private int mCount = -1;
  private final SQLiteCursorDriver mDriver;
  private final String mEditTable;
  private final Throwable mStackTrace;
  private int pageSize = 3000;
  private final h uEN;
  public a uEO;
  private boolean uEP;
  private b<a> uEQ;
  c uER;
  private boolean uES;
  
  public f(SQLiteCursorDriver paramSQLiteCursorDriver, String paramString, h paramh)
  {
    if (paramh == null) {
      throw new IllegalArgumentException("query object cannot be null");
    }
    this.mStackTrace = null;
    this.mDriver = paramSQLiteCursorDriver;
    this.mEditTable = paramString;
    this.mColumnNameMap = null;
    this.uEN = paramh;
    this.mColumns = paramh.getColumnNames();
    this.mRowIdColumnIndex = DatabaseUtils.findRowIdColumnIndex(this.mColumns);
  }
  
  private int FF(int paramInt)
  {
    if (this.uEP)
    {
      if (this.uEQ == null) {
        this.uEQ = new b()
        {
          public final ArrayList<a> ag(ArrayList<Object> paramAnonymousArrayList)
          {
            f localf = f.this;
            if (localf.uEO != null) {
              return localf.uEO.ag(paramAnonymousArrayList);
            }
            return null;
          }
          
          public final a cxi()
          {
            f localf = f.this;
            if (localf.uEO != null) {
              return localf.uEO.cxi();
            }
            return null;
          }
        };
      }
      this.uEQ.mStartPos = paramInt;
      return this.uEN.a(this.uEQ, paramInt, this.pageSize);
    }
    cxj();
    return this.uEN.a(this.uER, paramInt, this.pageSize);
  }
  
  private void cxj()
  {
    if (this.uER == null) {
      this.uER = new c(this.mColumns, (byte)0);
    }
  }
  
  public final boolean FB(int paramInt)
  {
    if (!this.uEP) {}
    b localb;
    do
    {
      do
      {
        return false;
        localb = this.uEQ;
      } while (paramInt > 50);
      if (localb.uEB < 10) {
        return true;
      }
    } while (paramInt / localb.uEB >= 0.1D);
    return true;
  }
  
  public final a FC(int paramInt)
  {
    Object localObject1 = null;
    int i = 0;
    b localb;
    if (this.uEQ != null)
    {
      localb = this.uEQ;
      if (!localb.FE(paramInt)) {
        break label223;
      }
      Object localObject2 = localb.uEA.get(paramInt);
      a locala = (a)localb.uEC.get(localObject2);
      localObject1 = locala;
      if (locala == null)
      {
        y.i("MicroMsg.CursorDataWindow", "get data null %s", new Object[] { localObject2 });
        if (localb.uED.size() != 0)
        {
          localObject1 = localb.ag(localb.uED);
          if (localObject1 != null) {
            if (i < ((ArrayList)localObject1).size())
            {
              locala = (a)((ArrayList)localObject1).get(i);
              if (locala != null) {
                localb.b(locala.getKey(), locala);
              }
              for (;;)
              {
                i += 1;
                break;
                y.e("MicroMsg.CursorDataWindow", "newcursor obj is null");
              }
            }
          }
          localb.uED.clear();
        }
        locala = (a)localb.uEC.get(localObject2);
        localObject1 = locala;
        if (locala == null)
        {
          y.e("MicroMsg.CursorDataWindow", "newcursor error obj : " + localObject2 + "pos:" + paramInt);
          localObject1 = locala;
        }
      }
    }
    return localObject1;
    label223:
    y.e("MicroMsg.CursorDataWindow", "newcursor cursor getItem error: pos " + paramInt + " loaded num :" + localb.uEA.size());
    return null;
  }
  
  public final void FD(int paramInt)
  {
    if ((paramInt <= 15000) && (paramInt >= 2000)) {
      this.pageSize = paramInt;
    }
  }
  
  public final void a(a parama)
  {
    this.uEO = parama;
  }
  
  public final boolean a(Object paramObject, a parama)
  {
    if ((this.uEP) && (this.uEQ != null))
    {
      if ((!this.uES) && ((paramObject instanceof Object[])) && (this.uEQ.bY(paramObject)))
      {
        this.mCount -= ((Object[])paramObject).length;
        this.pageSize -= ((Object[])paramObject).length;
      }
      localb = this.uEQ;
      if (parama != null)
      {
        y.v("MicroMsg.CursorDataWindow", "newcursor cursor update Memory key : " + paramObject + "values : " + parama);
        localb.b(paramObject, parama);
      }
    }
    while (this.uEP)
    {
      b localb;
      return false;
      if ((paramObject instanceof Object[]))
      {
        paramObject = (Object[])paramObject;
        int j = paramObject.length;
        int i = 0;
        while (i < j)
        {
          parama = paramObject[i];
          localb.uEC.remove(parama);
          i += 1;
        }
        localb.v(paramObject);
        return false;
      }
      if (localb.uED == null) {
        localb.uED = new ArrayList();
      }
      if (!localb.uED.contains(paramObject))
      {
        localb.uED.add(paramObject);
        y.i("MicroMsg.CursorDataWindow", "newcursor cursor clearData : " + paramObject);
      }
      localb.uEC.remove(paramObject);
      return false;
    }
    paramObject = this.uER;
    paramObject.mPos = 0;
    paramObject.uEF.clear();
    return false;
  }
  
  public final boolean bY(Object paramObject)
  {
    if (!this.uEP) {}
    while (this.uEQ == null) {
      return false;
    }
    return this.uEQ.bY(paramObject);
  }
  
  public final a bZ(Object paramObject)
  {
    if (!this.uEP) {
      Log.e("WCDB.SQLiteNewCursor", "newcursor getItemByKey error " + paramObject);
    }
    b localb;
    do
    {
      return null;
      if (this.uEQ == null)
      {
        Log.e("WCDB.SQLiteNewCursor", "newcursor error getItemByKey window is null");
        return null;
      }
      localb = this.uEQ;
    } while (localb.uEC == null);
    return (a)localb.uEC.get(paramObject);
  }
  
  protected final void checkPosition()
  {
    super.checkPosition();
  }
  
  public final void close()
  {
    super.close();
    try
    {
      this.uEN.close();
      this.mDriver.cursorClosed();
      return;
    }
    finally {}
  }
  
  public final void copyStringToBuffer(int paramInt, CharArrayBuffer paramCharArrayBuffer) {}
  
  public final SparseArray<Object>[] cwY()
  {
    if (!this.uEP) {
      return null;
    }
    return new SparseArray[] { this.uEQ.uEA };
  }
  
  public final HashMap cwZ()
  {
    return this.uEQ.uEC;
  }
  
  public final boolean cxa()
  {
    return this.uES;
  }
  
  public final void deactivate()
  {
    super.deactivate();
    this.mDriver.cursorDeactivated();
  }
  
  protected final void finalize()
  {
    try
    {
      if (this.uEQ != null) {
        close();
      }
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  public final byte[] getBlob(int paramInt)
  {
    if (!this.uEP) {
      return this.uER.getBlob(paramInt);
    }
    return null;
  }
  
  public final int getColumnIndex(String paramString)
  {
    if (this.mColumnNameMap == null)
    {
      localObject = this.mColumns;
      int j = localObject.length;
      HashMap localHashMap = new HashMap(j, 1.0F);
      i = 0;
      while (i < j)
      {
        localHashMap.put(localObject[i], Integer.valueOf(i));
        i += 1;
      }
      this.mColumnNameMap = localHashMap;
    }
    int i = paramString.lastIndexOf('.');
    Object localObject = paramString;
    if (i != -1)
    {
      localObject = new Exception();
      Log.e("WCDB.SQLiteNewCursor", "requesting column name with table name -- " + paramString, new Object[] { localObject });
      localObject = paramString.substring(i + 1);
    }
    paramString = (Integer)this.mColumnNameMap.get(localObject);
    if (paramString != null) {
      return paramString.intValue();
    }
    return -1;
  }
  
  public final String[] getColumnNames()
  {
    return this.mColumns;
  }
  
  public final int getCount()
  {
    if (this.mCount == -1)
    {
      this.mCount = FF(0);
      if (this.uEQ != null) {
        if ((this.mCount == -1) || (this.mCount != this.uEQ.uEA.size())) {
          break label79;
        }
      }
    }
    label79:
    for (boolean bool = true;; bool = false)
    {
      this.uES = bool;
      if ((!this.uEP) || (!this.uES)) {
        break label95;
      }
      if (this.uEQ != null) {
        break;
      }
      return 0;
    }
    return this.uEQ.uEA.size();
    label95:
    return this.mCount;
  }
  
  public final double getDouble(int paramInt)
  {
    if (!this.uEP) {
      return this.uER.getDouble(paramInt);
    }
    return 0.0D;
  }
  
  public final float getFloat(int paramInt)
  {
    if (!this.uEP) {
      return this.uER.getFloat(paramInt);
    }
    return 0.0F;
  }
  
  public final int getInt(int paramInt)
  {
    if (!this.uEP) {
      return this.uER.getInt(paramInt);
    }
    return 0;
  }
  
  public final long getLong(int paramInt)
  {
    if (!this.uEP) {
      return this.uER.getLong(paramInt);
    }
    return 0L;
  }
  
  public final short getShort(int paramInt)
  {
    if (!this.uEP) {
      return this.uER.getShort(paramInt);
    }
    return 0;
  }
  
  public final String getString(int paramInt)
  {
    if (!this.uEP) {
      return this.uER.getString(paramInt);
    }
    return null;
  }
  
  public final boolean isNull(int paramInt)
  {
    if (!this.uEP) {
      return this.uER.isNull(paramInt);
    }
    return false;
  }
  
  public final void mD(boolean paramBoolean)
  {
    this.uEP = paramBoolean;
  }
  
  public final boolean onMove(int paramInt1, int paramInt2)
  {
    if (this.uEP)
    {
      if ((this.uEQ == null) || (!this.uEQ.FE(paramInt2))) {
        FF(paramInt2 / this.pageSize * this.pageSize);
      }
      return true;
    }
    if (this.uER == null) {
      cxj();
    }
    c localc = this.uER;
    paramInt1 = paramInt2 / localc.uEG;
    if (localc.uEF.indexOfKey(paramInt1) >= 0)
    {
      int i = localc.uEG;
      int j = localc.columnCount;
      if (((Object[])localc.uEF.get(paramInt1))[(paramInt2 % i * j)] == null) {}
    }
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (paramInt1 == 0) {
        FF(paramInt2 / this.pageSize * this.pageSize);
      }
      this.uER.moveToPosition(paramInt2);
      return true;
    }
  }
  
  public final void registerContentObserver(ContentObserver paramContentObserver) {}
  
  public final void registerDataSetObserver(DataSetObserver paramDataSetObserver) {}
  
  public final boolean requery()
  {
    if (isClosed()) {
      return false;
    }
    try
    {
      if (!this.uEN.getDatabase().isOpen()) {
        return false;
      }
    }
    finally {}
    if (this.uEQ != null) {
      this.uEQ.adg();
    }
    this.mPos = -1;
    this.mCount = -1;
    this.mDriver.cursorRequeried(this);
    try
    {
      boolean bool = super.requery();
      return bool;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      Log.w("WCDB.SQLiteNewCursor", "requery() failed " + localIllegalStateException.getMessage(), new Object[] { localIllegalStateException });
    }
    return false;
  }
  
  public final void unregisterContentObserver(ContentObserver paramContentObserver) {}
  
  public final void unregisterDataSetObserver(DataSetObserver paramDataSetObserver) {}
  
  public static abstract interface a
  {
    public abstract ArrayList<a> ag(ArrayList<Object> paramArrayList);
    
    public abstract a cxi();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.cf.a.f
 * JD-Core Version:    0.7.0.1
 */