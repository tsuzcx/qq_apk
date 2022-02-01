package com.tencent.mm.plugin.dbbackup;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.ui.base.p;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteStatement;

final class c$9
  implements Runnable
{
  c$9(c paramc, String paramString, p paramp, Context paramContext) {}
  
  public final void run()
  {
    AppMethodBeat.i(193205);
    try
    {
      int i = g.ajC().gBq.ftT().compileStatement(this.geT).executeUpdateDelete();
      str = "成功更新 " + i + " 条记录";
      ad.i("MicroMsg.DBCommand", "SQL executed, changes: %d, SQL: %s", new Object[] { Integer.valueOf(i), this.geT });
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(193204);
          if (c.9.this.pgW != null) {
            c.9.this.pgW.dismiss();
          }
          com.tencent.mm.ui.base.h.c(c.9.this.val$context, str, "", true);
          AppMethodBeat.o(193204);
        }
      });
      AppMethodBeat.o(193205);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      for (;;)
      {
        final String str = "Execution failed: " + localRuntimeException.getMessage();
        ad.printErrStackTrace("MicroMsg.DBCommand", localRuntimeException, "Failed executing SQL: %s", new Object[] { this.geT });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.dbbackup.c.9
 * JD-Core Version:    0.7.0.1
 */