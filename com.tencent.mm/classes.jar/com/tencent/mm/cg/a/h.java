package com.tencent.mm.cg.a;

import android.database.CursorIndexOutOfBoundsException;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
    AppMethodBeat.i(59207);
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
          break label430;
        }
        j = k;
        if (step(1) != 1) {
          break;
        }
        paramb.yRm = paramb.dzX();
        j = 0;
        if (j >= m) {
          break label364;
        }
        switch (getType(j))
        {
        case 3: 
          label164:
          paramb.hp(i, 1);
          SQLiteException localSQLiteException1 = new SQLiteException("Unknown column type when filling window.");
          AppMethodBeat.o(59207);
          throw localSQLiteException1;
        }
      }
      catch (SQLiteException localSQLiteException2)
      {
        Log.e("WCDB.SQLiteNewQuery", "exception: " + localSQLiteException2.getMessage() + "; query: " + getSql());
        checkCorruption(localSQLiteException2);
        AppMethodBeat.o(59207);
        throw localSQLiteException2;
      }
      finally
      {
        paramb.releaseReference();
        releaseReference();
        AppMethodBeat.o(59207);
      }
      Object localObject2 = getString(j);
      if (paramb.yRm == null) {
        break label421;
      }
      paramb.yRm.bJ(j, (String)localObject2);
      break label421;
      long l = getLong(j);
      if (paramb.yRm == null) {
        break label421;
      }
      paramb.yRm.ak(j, l);
      break label421;
      getDouble(j);
      break label421;
      localObject2 = getBlob(j);
      if (paramb.yRm == null) {
        break label421;
      }
      paramb.yRm.r(j, (byte[])localObject2);
      break label421;
      label364:
      paramb.hp(i, 0);
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
      AppMethodBeat.o(59207);
      return paramInt1;
      break label164;
      label421:
      j += 1;
      break;
      label430:
      j = 0;
    }
  }
  
  final int a(c paramc, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(59208);
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
          break label531;
        }
        j = i / paramc.yRo;
        if (paramc.yRn.indexOfKey(j) < 0)
        {
          localObject = new Object[paramc.yRo * paramc.columnCount];
          paramc.yRn.put(j, localObject);
          j = paramc.yRo;
          m = paramc.columnCount * (i % j);
          int n = paramc.columnCount;
          j = i + 1;
          if (j <= paramc.yRp) {
            break label347;
          }
          paramc.yRp = j;
          locala = new c.a(paramc, m, m + n, (Object[])localObject);
          j = 0;
          if (j >= k) {
            break label522;
          }
          switch (getType(j))
          {
          case 3: 
            label252:
            paramc = new SQLiteException("Unknown column type when filling window.");
            AppMethodBeat.o(59208);
            throw paramc;
          }
        }
      }
      catch (SQLiteException paramc)
      {
        Log.e("WCDB.SQLiteNewQuery", "exception: " + paramc.getMessage() + "; query: " + getSql());
        checkCorruption(paramc);
        AppMethodBeat.o(59208);
        throw paramc;
      }
      finally
      {
        releaseReference();
        AppMethodBeat.o(59208);
      }
      localObject = (Object[])paramc.yRn.get(j);
      continue;
      label347:
      int j = paramc.yRp;
      continue;
      localObject = getString(j);
      label364:
      while (locala.index == locala.endIndex)
      {
        paramc = new CursorIndexOutOfBoundsException("No more columns left.");
        AppMethodBeat.o(59208);
        throw paramc;
        localObject = Long.valueOf(getLong(j));
        continue;
        localObject = Double.valueOf(getDouble(j));
        continue;
        localObject = getBlob(j);
      }
      Object[] arrayOfObject = locala.yRq;
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
        AppMethodBeat.o(59208);
        return paramInt1;
      }
      paramInt1 = 0;
      continue;
      break label252;
      localObject = null;
      break label364;
      label522:
      i += 1;
      break;
      label531:
      paramInt1 = 1;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(59209);
    String str = "SQLiteNewQuery: " + getSql();
    AppMethodBeat.o(59209);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.cg.a.h
 * JD-Core Version:    0.7.0.1
 */