package com.tencent.mm.console;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteDirectCursor;

final class Shell$2$1
  implements Runnable
{
  Shell$2$1(Shell.2 param2, String paramString) {}
  
  public final void run()
  {
    Object localObject4 = null;
    com.tencent.wcdb.Cursor localCursor = null;
    AppMethodBeat.i(16108);
    SQLiteDatabase localSQLiteDatabase = g.RL().eHS.dzV();
    Object localObject2 = localCursor;
    Object localObject1 = localObject4;
    for (;;)
    {
      long l;
      try
      {
        l = System.currentTimeMillis();
        localObject2 = localCursor;
        localObject1 = localObject4;
        localCursor = localSQLiteDatabase.rawQueryWithFactory(SQLiteDirectCursor.FACTORY, this.euo, null, null);
        localObject2 = localCursor;
        localObject1 = localCursor;
        localObject4 = localCursor.getColumnNames();
        if (localObject4 != null) {
          continue;
        }
        i = 0;
        localObject2 = localCursor;
        localObject1 = localCursor;
        ab.i("MicroMsg.Shell", "Executing SQL from shell: " + this.euo);
        if (i > 0)
        {
          localObject2 = localCursor;
          localObject1 = localCursor;
          ab.i("MicroMsg.Shell", " > " + TextUtils.join(" | ", (Object[])localObject4));
        }
        localObject2 = localCursor;
        localObject1 = localCursor;
        localObject4 = new StringBuilder(1024);
        localObject2 = localCursor;
        localObject1 = localCursor;
        if (!localCursor.moveToNext()) {
          break label465;
        }
        localObject2 = localCursor;
        localObject1 = localCursor;
        ((StringBuilder)localObject4).setLength(0);
        localObject2 = localCursor;
        localObject1 = localCursor;
        ((StringBuilder)localObject4).append(" > ");
        j = 0;
        if (j >= i) {
          break label444;
        }
        localObject2 = localCursor;
        localObject1 = localCursor;
        switch (localCursor.getType(j))
        {
        case 0: 
          localObject2 = localCursor;
          localObject1 = localCursor;
          ((StringBuilder)localObject4).append(localCursor.getString(j));
        }
      }
      catch (RuntimeException localRuntimeException2)
      {
        int i;
        int j;
        localObject1 = localObject2;
        ab.e("MicroMsg.Shell", "Failed to execute SQL '%s': %s", new Object[] { this.euo, localRuntimeException2.getMessage() });
        return;
        localObject2 = localRuntimeException2;
        localObject1 = localRuntimeException2;
        ((StringBuilder)localObject4).append("(blob)");
        continue;
      }
      finally
      {
        if (localObject1 == null) {
          continue;
        }
        ((android.database.Cursor)localObject1).close();
        AppMethodBeat.o(16108);
      }
      localObject2 = localCursor;
      localObject1 = localCursor;
      ((StringBuilder)localObject4).append(" | ");
      j += 1;
      continue;
      localObject2 = localCursor;
      localObject1 = localCursor;
      i = localObject4.length;
      continue;
      localObject2 = localCursor;
      localObject1 = localCursor;
      ((StringBuilder)localObject4).append("(null)");
      continue;
      label444:
      RuntimeException localRuntimeException1 = localRuntimeException2;
      localObject1 = localRuntimeException2;
      ab.i("MicroMsg.Shell", ((StringBuilder)localObject4).toString());
      continue;
      label465:
      localRuntimeException1 = localRuntimeException2;
      localObject1 = localRuntimeException2;
      ab.i("MicroMsg.Shell", "Finish executing SQL in %d ms: %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), this.euo });
      if (localRuntimeException2 != null)
      {
        localRuntimeException2.close();
        AppMethodBeat.o(16108);
        return;
      }
      AppMethodBeat.o(16108);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.console.Shell.2.1
 * JD-Core Version:    0.7.0.1
 */