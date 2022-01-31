package com.tencent.mm.cf.a;

import android.database.CursorIndexOutOfBoundsException;
import android.util.SparseArray;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteDirectQuery;
import com.tencent.wcdb.database.SQLiteException;
import com.tencent.wcdb.support.CancellationSignal;
import com.tencent.wcdb.support.Log;

public final class h
  extends SQLiteDirectQuery
{
  h(SQLiteDatabase paramSQLiteDatabase, String paramString, CancellationSignal paramCancellationSignal)
  {
    super(paramSQLiteDatabase, paramString, null, paramCancellationSignal);
  }
  
  final int a(b paramb, int paramInt1, int paramInt2)
  {
    int k = 1;
    acquireReference();
    paramb.acquireReference();
    if (paramInt1 > 0) {}
    int i;
    int j;
    for (;;)
    {
      try
      {
        i = step(paramInt1);
        if (i < paramInt1)
        {
          Log.w("WCDB.SQLiteNewQuery", "startPos %d > actual rows %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(i) });
          return i;
        }
        int m = getColumnNames().length;
        i = paramInt1;
        if (i >= paramInt2 + paramInt1) {
          break label398;
        }
        j = k;
        if (step(1) != 1) {
          break;
        }
        paramb.uEE = paramb.cxi();
        j = 0;
        if (j >= m) {
          break label337;
        }
        switch (getType(j))
        {
        case 3: 
          label156:
          paramb.fi(i, 1);
          throw new SQLiteException("Unknown column type when filling window.");
        }
      }
      catch (SQLiteException localSQLiteException)
      {
        Log.e("WCDB.SQLiteNewQuery", "exception: " + localSQLiteException.getMessage() + "; query: " + getSql());
        checkCorruption(localSQLiteException);
        throw localSQLiteException;
      }
      finally
      {
        paramb.releaseReference();
        releaseReference();
      }
      Object localObject2 = getString(j);
      if (paramb.uEE == null) {
        break label389;
      }
      paramb.uEE.bc(j, (String)localObject2);
      break label389;
      long l = getLong(j);
      if (paramb.uEE == null) {
        break label389;
      }
      paramb.uEE.V(j, l);
      break label389;
      getDouble(j);
      break label389;
      localObject2 = getBlob(j);
      if (paramb.uEE == null) {
        break label389;
      }
      paramb.uEE.q(j, (byte[])localObject2);
      break label389;
      label337:
      paramb.fi(i, 0);
      i += 1;
    }
    for (;;)
    {
      paramInt1 = i;
      if (j == 0) {
        paramInt1 = i + step(2147483647);
      }
      reset(true);
      paramb.releaseReference();
      releaseReference();
      return paramInt1;
      break label156;
      label389:
      j += 1;
      break;
      label398:
      j = 0;
    }
  }
  
  final int a(c paramc, int paramInt1, int paramInt2)
  {
    acquireReference();
    if (paramInt1 > 0) {}
    int i;
    Object localObject;
    for (;;)
    {
      c.a locala;
      try
      {
        i = step(paramInt1);
        if (i < paramInt1)
        {
          Log.w("WCDB.SQLiteNewQuery", "startPos %d > actual rows %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(i) });
          return i;
        }
        int k = getColumnNames().length;
        i = paramInt1;
        if (i >= paramInt2 + paramInt1) {
          break;
        }
        if (step(1) != 1) {
          break label490;
        }
        j = i / paramc.uEG;
        if (paramc.uEF.indexOfKey(j) < 0)
        {
          localObject = new Object[paramc.uEG * paramc.columnCount];
          paramc.uEF.put(j, localObject);
          j = paramc.uEG;
          m = paramc.columnCount * (i % j);
          int n = paramc.columnCount;
          j = i + 1;
          if (j <= paramc.uEH) {
            break label318;
          }
          paramc.uEH = j;
          locala = new c.a(paramc, m, m + n, (Object[])localObject);
          j = 0;
          if (j >= k) {
            break label481;
          }
          switch (getType(j))
          {
          case 3: 
            label240:
            throw new SQLiteException("Unknown column type when filling window.");
          }
        }
      }
      catch (SQLiteException paramc)
      {
        Log.e("WCDB.SQLiteNewQuery", "exception: " + paramc.getMessage() + "; query: " + getSql());
        checkCorruption(paramc);
        throw paramc;
      }
      finally
      {
        releaseReference();
      }
      localObject = (Object[])paramc.uEF.get(j);
      continue;
      label318:
      int j = paramc.uEH;
      continue;
      localObject = getString(j);
      label335:
      while (locala.index == locala.endIndex)
      {
        throw new CursorIndexOutOfBoundsException("No more columns left.");
        localObject = Long.valueOf(getLong(j));
        continue;
        localObject = Double.valueOf(getDouble(j));
        continue;
        localObject = getBlob(j);
      }
      Object[] arrayOfObject = locala.uEI;
      int m = locala.index;
      locala.index = (m + 1);
      arrayOfObject[m] = localObject;
      j += 1;
    }
    for (;;)
    {
      if (paramInt1 == 0) {}
      for (paramInt1 = step(2147483647) + i;; paramInt1 = i)
      {
        reset(true);
        releaseReference();
        return paramInt1;
      }
      paramInt1 = 0;
      continue;
      break label240;
      localObject = null;
      break label335;
      label481:
      i += 1;
      break;
      label490:
      paramInt1 = 1;
    }
  }
  
  public final String toString()
  {
    return "SQLiteNewQuery: " + getSql();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.cf.a.h
 * JD-Core Version:    0.7.0.1
 */