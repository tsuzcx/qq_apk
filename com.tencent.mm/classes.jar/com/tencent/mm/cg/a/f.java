package com.tencent.mm.cg.a;

import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.DataSetObserver;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
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
  public static final SQLiteDatabase.CursorFactory FACTORY;
  private Map<String, Integer> mColumnNameMap;
  private final String[] mColumns;
  private int mCount;
  private final SQLiteCursorDriver mDriver;
  private final String mEditTable;
  private final Throwable mStackTrace;
  private int pageSize;
  private boolean yRA;
  private final h yRv;
  public a yRw;
  private boolean yRx;
  private b<a> yRy;
  c yRz;
  
  static
  {
    AppMethodBeat.i(59204);
    FACTORY = new SQLiteDatabase.CursorFactory()
    {
      public final Cursor newCursor(SQLiteDatabase paramAnonymousSQLiteDatabase, SQLiteCursorDriver paramAnonymousSQLiteCursorDriver, String paramAnonymousString, SQLiteProgram paramAnonymousSQLiteProgram)
      {
        AppMethodBeat.i(59179);
        paramAnonymousSQLiteDatabase = new f(paramAnonymousSQLiteCursorDriver, paramAnonymousString, (h)paramAnonymousSQLiteProgram);
        AppMethodBeat.o(59179);
        return paramAnonymousSQLiteDatabase;
      }
      
      public final SQLiteProgram newQuery(SQLiteDatabase paramAnonymousSQLiteDatabase, String paramAnonymousString, Object[] paramAnonymousArrayOfObject, CancellationSignal paramAnonymousCancellationSignal)
      {
        AppMethodBeat.i(59180);
        paramAnonymousSQLiteDatabase = new h(paramAnonymousSQLiteDatabase, paramAnonymousString, paramAnonymousCancellationSignal);
        AppMethodBeat.o(59180);
        return paramAnonymousSQLiteDatabase;
      }
    };
    AppMethodBeat.o(59204);
  }
  
  public f(SQLiteCursorDriver paramSQLiteCursorDriver, String paramString, h paramh)
  {
    AppMethodBeat.i(59181);
    this.mCount = -1;
    this.pageSize = 3000;
    if (paramh == null)
    {
      paramSQLiteCursorDriver = new IllegalArgumentException("query object cannot be null");
      AppMethodBeat.o(59181);
      throw paramSQLiteCursorDriver;
    }
    this.mStackTrace = null;
    this.mDriver = paramSQLiteCursorDriver;
    this.mEditTable = paramString;
    this.mColumnNameMap = null;
    this.yRv = paramh;
    this.mColumns = paramh.getColumnNames();
    this.mRowIdColumnIndex = DatabaseUtils.findRowIdColumnIndex(this.mColumns);
    AppMethodBeat.o(59181);
  }
  
  private int NP(int paramInt)
  {
    AppMethodBeat.i(59186);
    if (this.yRx)
    {
      if (this.yRy == null) {
        this.yRy = new b()
        {
          public final ArrayList<a> ap(ArrayList<Object> paramAnonymousArrayList)
          {
            AppMethodBeat.i(59178);
            f localf = f.this;
            if (localf.yRw != null)
            {
              paramAnonymousArrayList = localf.yRw.ap(paramAnonymousArrayList);
              AppMethodBeat.o(59178);
              return paramAnonymousArrayList;
            }
            AppMethodBeat.o(59178);
            return null;
          }
          
          public final a dzX()
          {
            AppMethodBeat.i(59177);
            Object localObject = f.this;
            if (((f)localObject).yRw != null)
            {
              localObject = ((f)localObject).yRw.dzX();
              AppMethodBeat.o(59177);
              return localObject;
            }
            AppMethodBeat.o(59177);
            return null;
          }
        };
      }
      this.yRy.mStartPos = paramInt;
      paramInt = this.yRv.a(this.yRy, paramInt, this.pageSize);
      AppMethodBeat.o(59186);
      return paramInt;
    }
    dzY();
    paramInt = this.yRv.a(this.yRz, paramInt, this.pageSize);
    AppMethodBeat.o(59186);
    return paramInt;
  }
  
  private void dzY()
  {
    AppMethodBeat.i(59183);
    if (this.yRz == null) {
      this.yRz = new c(this.mColumns, (byte)0);
    }
    AppMethodBeat.o(59183);
  }
  
  public final boolean NL(int paramInt)
  {
    if (!this.yRx) {}
    b localb;
    do
    {
      do
      {
        return false;
        localb = this.yRy;
      } while (paramInt > 50);
      if (localb.yRj < 10) {
        return true;
      }
    } while (paramInt / localb.yRj >= 0.1D);
    return true;
  }
  
  public final a NM(int paramInt)
  {
    Object localObject1 = null;
    int i = 0;
    AppMethodBeat.i(59200);
    if (this.yRy != null)
    {
      b localb = this.yRy;
      if (localb.NO(paramInt))
      {
        Object localObject2 = localb.yRi.get(paramInt);
        a locala = (a)localb.yRk.get(localObject2);
        localObject1 = locala;
        if (locala == null)
        {
          ab.i("MicroMsg.CursorDataWindow", "get data null %s", new Object[] { localObject2 });
          if (localb.yRl.size() != 0)
          {
            localObject1 = localb.ap(localb.yRl);
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
                  ab.e("MicroMsg.CursorDataWindow", "newcursor obj is null");
                }
              }
            }
            localb.yRl.clear();
          }
          locala = (a)localb.yRk.get(localObject2);
          localObject1 = locala;
          if (locala == null)
          {
            ab.e("MicroMsg.CursorDataWindow", "newcursor error obj : " + localObject2 + "pos:" + paramInt);
            localObject1 = locala;
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(59200);
        return localObject1;
        ab.e("MicroMsg.CursorDataWindow", "newcursor cursor getItem error: pos " + paramInt + " loaded num :" + localb.yRi.size());
      }
    }
    AppMethodBeat.o(59200);
    return null;
  }
  
  public final void NN(int paramInt)
  {
    if ((paramInt <= 15000) && (paramInt >= 2000)) {
      this.pageSize = paramInt;
    }
  }
  
  public final void a(a parama)
  {
    this.yRw = parama;
  }
  
  public final boolean a(Object paramObject, a parama)
  {
    AppMethodBeat.i(59201);
    if ((this.yRx) && (this.yRy != null))
    {
      if ((!this.yRA) && ((paramObject instanceof Object[])) && (this.yRy.cD(paramObject)))
      {
        this.mCount -= ((Object[])paramObject).length;
        this.pageSize -= ((Object[])paramObject).length;
      }
      b localb = this.yRy;
      if (parama != null)
      {
        ab.v("MicroMsg.CursorDataWindow", "newcursor cursor update Memory key : " + paramObject + "values : " + parama);
        localb.b(paramObject, parama);
      }
      for (;;)
      {
        AppMethodBeat.o(59201);
        return false;
        if ((paramObject instanceof Object[]))
        {
          paramObject = (Object[])paramObject;
          int j = paramObject.length;
          int i = 0;
          while (i < j)
          {
            parama = paramObject[i];
            localb.yRk.remove(parama);
            i += 1;
          }
          localb.A(paramObject);
        }
        else
        {
          if (localb.yRl == null) {
            localb.yRl = new ArrayList();
          }
          if (!localb.yRl.contains(paramObject))
          {
            localb.yRl.add(paramObject);
            ab.i("MicroMsg.CursorDataWindow", "newcursor cursor clearData : ".concat(String.valueOf(paramObject)));
          }
          localb.yRk.remove(paramObject);
        }
      }
    }
    if (!this.yRx)
    {
      paramObject = this.yRz;
      paramObject.mPos = 0;
      paramObject.yRn.clear();
    }
    AppMethodBeat.o(59201);
    return false;
  }
  
  public final boolean cD(Object paramObject)
  {
    AppMethodBeat.i(59202);
    if (!this.yRx)
    {
      AppMethodBeat.o(59202);
      return false;
    }
    if (this.yRy == null)
    {
      AppMethodBeat.o(59202);
      return false;
    }
    boolean bool = this.yRy.cD(paramObject);
    AppMethodBeat.o(59202);
    return bool;
  }
  
  public final a cE(Object paramObject)
  {
    AppMethodBeat.i(59203);
    if (!this.yRx)
    {
      Log.e("WCDB.SQLiteNewCursor", "newcursor getItemByKey error ".concat(String.valueOf(paramObject)));
      AppMethodBeat.o(59203);
      return null;
    }
    if (this.yRy == null)
    {
      Log.e("WCDB.SQLiteNewCursor", "newcursor error getItemByKey window is null");
      AppMethodBeat.o(59203);
      return null;
    }
    b localb = this.yRy;
    if (localb.yRk == null)
    {
      AppMethodBeat.o(59203);
      return null;
    }
    paramObject = (a)localb.yRk.get(paramObject);
    AppMethodBeat.o(59203);
    return paramObject;
  }
  
  public final void checkPosition()
  {
    AppMethodBeat.i(59185);
    super.checkPosition();
    AppMethodBeat.o(59185);
  }
  
  public final void close()
  {
    AppMethodBeat.i(59189);
    super.close();
    try
    {
      this.yRv.close();
      this.mDriver.cursorClosed();
      return;
    }
    finally
    {
      AppMethodBeat.o(59189);
    }
  }
  
  public final void copyStringToBuffer(int paramInt, CharArrayBuffer paramCharArrayBuffer) {}
  
  public final void deactivate()
  {
    AppMethodBeat.i(59188);
    super.deactivate();
    this.mDriver.cursorDeactivated();
    AppMethodBeat.o(59188);
  }
  
  public final SparseArray<Object>[] dzK()
  {
    if (!this.yRx) {
      return null;
    }
    return new SparseArray[] { this.yRy.yRi };
  }
  
  public final HashMap dzL()
  {
    return this.yRy.yRk;
  }
  
  public final boolean dzM()
  {
    return this.yRA;
  }
  
  public final void finalize()
  {
    AppMethodBeat.i(59191);
    try
    {
      if (this.yRy != null) {
        close();
      }
      return;
    }
    finally
    {
      super.finalize();
      AppMethodBeat.o(59191);
    }
  }
  
  public final byte[] getBlob(int paramInt)
  {
    AppMethodBeat.i(59199);
    if (!this.yRx)
    {
      byte[] arrayOfByte = this.yRz.getBlob(paramInt);
      AppMethodBeat.o(59199);
      return arrayOfByte;
    }
    AppMethodBeat.o(59199);
    return null;
  }
  
  public final int getColumnIndex(String paramString)
  {
    AppMethodBeat.i(59187);
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
      Log.e("WCDB.SQLiteNewCursor", "requesting column name with table name -- ".concat(String.valueOf(paramString)), new Object[] { localObject });
      localObject = paramString.substring(i + 1);
    }
    paramString = (Integer)this.mColumnNameMap.get(localObject);
    if (paramString != null)
    {
      i = paramString.intValue();
      AppMethodBeat.o(59187);
      return i;
    }
    AppMethodBeat.o(59187);
    return -1;
  }
  
  public final String[] getColumnNames()
  {
    return this.mColumns;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(59184);
    if (this.mCount == -1)
    {
      this.mCount = NP(0);
      if (this.yRy != null) {
        if ((this.mCount == -1) || (this.mCount != this.yRy.yRi.size())) {
          break label91;
        }
      }
    }
    label91:
    for (boolean bool = true;; bool = false)
    {
      this.yRA = bool;
      if ((!this.yRx) || (!this.yRA)) {
        break label115;
      }
      if (this.yRy != null) {
        break;
      }
      AppMethodBeat.o(59184);
      return 0;
    }
    int i = this.yRy.yRi.size();
    AppMethodBeat.o(59184);
    return i;
    label115:
    i = this.mCount;
    AppMethodBeat.o(59184);
    return i;
  }
  
  public final double getDouble(int paramInt)
  {
    AppMethodBeat.i(59197);
    if (!this.yRx)
    {
      double d = this.yRz.getDouble(paramInt);
      AppMethodBeat.o(59197);
      return d;
    }
    AppMethodBeat.o(59197);
    return 0.0D;
  }
  
  public final float getFloat(int paramInt)
  {
    AppMethodBeat.i(59196);
    if (!this.yRx)
    {
      float f = this.yRz.getFloat(paramInt);
      AppMethodBeat.o(59196);
      return f;
    }
    AppMethodBeat.o(59196);
    return 0.0F;
  }
  
  public final int getInt(int paramInt)
  {
    AppMethodBeat.i(59194);
    if (!this.yRx)
    {
      paramInt = this.yRz.getInt(paramInt);
      AppMethodBeat.o(59194);
      return paramInt;
    }
    AppMethodBeat.o(59194);
    return 0;
  }
  
  public final long getLong(int paramInt)
  {
    AppMethodBeat.i(59195);
    if (!this.yRx)
    {
      long l = this.yRz.getLong(paramInt);
      AppMethodBeat.o(59195);
      return l;
    }
    AppMethodBeat.o(59195);
    return 0L;
  }
  
  public final short getShort(int paramInt)
  {
    AppMethodBeat.i(59193);
    if (!this.yRx)
    {
      short s = this.yRz.getShort(paramInt);
      AppMethodBeat.o(59193);
      return s;
    }
    AppMethodBeat.o(59193);
    return 0;
  }
  
  public final String getString(int paramInt)
  {
    AppMethodBeat.i(59192);
    if (!this.yRx)
    {
      String str = this.yRz.getString(paramInt);
      AppMethodBeat.o(59192);
      return str;
    }
    AppMethodBeat.o(59192);
    return null;
  }
  
  public final boolean isNull(int paramInt)
  {
    AppMethodBeat.i(59198);
    if (!this.yRx)
    {
      boolean bool = this.yRz.isNull(paramInt);
      AppMethodBeat.o(59198);
      return bool;
    }
    AppMethodBeat.o(59198);
    return false;
  }
  
  public final boolean onMove(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(59182);
    if (this.yRx)
    {
      if ((this.yRy == null) || (!this.yRy.NO(paramInt2))) {
        NP(paramInt2 / this.pageSize * this.pageSize);
      }
      AppMethodBeat.o(59182);
      return true;
    }
    if (this.yRz == null) {
      dzY();
    }
    c localc = this.yRz;
    paramInt1 = paramInt2 / localc.yRo;
    if (localc.yRn.indexOfKey(paramInt1) >= 0)
    {
      int i = localc.yRo;
      int j = localc.columnCount;
      if (((Object[])localc.yRn.get(paramInt1))[(paramInt2 % i * j)] == null) {}
    }
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (paramInt1 == 0) {
        NP(paramInt2 / this.pageSize * this.pageSize);
      }
      this.yRz.moveToPosition(paramInt2);
      break;
    }
  }
  
  public final void pV(boolean paramBoolean)
  {
    this.yRx = paramBoolean;
  }
  
  public final void registerContentObserver(ContentObserver paramContentObserver) {}
  
  public final void registerDataSetObserver(DataSetObserver paramDataSetObserver) {}
  
  /* Error */
  public final boolean requery()
  {
    // Byte code:
    //   0: ldc_w 441
    //   3: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokevirtual 444	com/tencent/mm/cg/a/f:isClosed	()Z
    //   10: ifeq +11 -> 21
    //   13: ldc_w 441
    //   16: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: iconst_0
    //   20: ireturn
    //   21: aload_0
    //   22: monitorenter
    //   23: aload_0
    //   24: getfield 83	com/tencent/mm/cg/a/f:yRv	Lcom/tencent/mm/cg/a/h;
    //   27: invokevirtual 448	com/tencent/mm/cg/a/h:getDatabase	()Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   30: invokevirtual 453	com/tencent/wcdb/database/SQLiteDatabase:isOpen	()Z
    //   33: ifne +13 -> 46
    //   36: aload_0
    //   37: monitorexit
    //   38: ldc_w 441
    //   41: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   44: iconst_0
    //   45: ireturn
    //   46: aload_0
    //   47: getfield 107	com/tencent/mm/cg/a/f:yRy	Lcom/tencent/mm/cg/a/b;
    //   50: ifnull +10 -> 60
    //   53: aload_0
    //   54: getfield 107	com/tencent/mm/cg/a/f:yRy	Lcom/tencent/mm/cg/a/b;
    //   57: invokevirtual 456	com/tencent/mm/cg/a/b:clearData	()V
    //   60: aload_0
    //   61: iconst_m1
    //   62: putfield 457	com/tencent/mm/cg/a/f:mPos	I
    //   65: aload_0
    //   66: iconst_m1
    //   67: putfield 64	com/tencent/mm/cg/a/f:mCount	I
    //   70: aload_0
    //   71: getfield 77	com/tencent/mm/cg/a/f:mDriver	Lcom/tencent/wcdb/database/SQLiteCursorDriver;
    //   74: aload_0
    //   75: invokeinterface 461 2 0
    //   80: aload_0
    //   81: monitorexit
    //   82: aload_0
    //   83: invokespecial 463	com/tencent/wcdb/AbstractCursor:requery	()Z
    //   86: istore_1
    //   87: ldc_w 441
    //   90: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   93: iload_1
    //   94: ireturn
    //   95: astore_2
    //   96: aload_0
    //   97: monitorexit
    //   98: ldc_w 441
    //   101: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   104: aload_2
    //   105: athrow
    //   106: astore_2
    //   107: ldc_w 297
    //   110: new 211	java/lang/StringBuilder
    //   113: dup
    //   114: ldc_w 465
    //   117: invokespecial 214	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   120: aload_2
    //   121: invokevirtual 468	java/lang/IllegalStateException:getMessage	()Ljava/lang/String;
    //   124: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: invokevirtual 230	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: iconst_1
    //   131: anewarray 172	java/lang/Object
    //   134: dup
    //   135: iconst_0
    //   136: aload_2
    //   137: aastore
    //   138: invokestatic 471	com/tencent/wcdb/support/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   141: ldc_w 441
    //   144: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   147: iconst_0
    //   148: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	149	0	this	f
    //   86	8	1	bool	boolean
    //   95	10	2	localObject	Object
    //   106	31	2	localIllegalStateException	java.lang.IllegalStateException
    // Exception table:
    //   from	to	target	type
    //   23	38	95	finally
    //   46	60	95	finally
    //   60	82	95	finally
    //   96	98	95	finally
    //   82	87	106	java/lang/IllegalStateException
  }
  
  public final void unregisterContentObserver(ContentObserver paramContentObserver) {}
  
  public final void unregisterDataSetObserver(DataSetObserver paramDataSetObserver) {}
  
  public static abstract interface a
  {
    public abstract ArrayList<a> ap(ArrayList<Object> paramArrayList);
    
    public abstract a dzX();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.cg.a.f
 * JD-Core Version:    0.7.0.1
 */