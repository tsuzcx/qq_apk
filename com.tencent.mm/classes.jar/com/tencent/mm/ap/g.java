package com.tencent.mm.ap;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.Log;

public final class g
  extends au
{
  public final String getTag()
  {
    return "MicroMsg.App.SyncTopConversation";
  }
  
  public final void vb(int paramInt)
  {
    AppMethodBeat.i(20482);
    Log.d("MicroMsg.App.SyncTopConversation", "the previous version is %d", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.mm.plugin.report.service.h.OAn.kJ(336, 15);
    bh.bCz();
    Object localObject1 = c.getDataDB();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("select username from rconversation");
    ((StringBuilder)localObject2).append(" where flag & 4611686018427387904 != 0");
    Log.d("MicroMsg.App.SyncTopConversation", "sql:%s", new Object[] { localObject2 });
    localObject1 = ((com.tencent.mm.storagebase.h)localObject1).rawQuery(((StringBuilder)localObject2).toString(), null, 2);
    if (localObject1 != null)
    {
      while (((Cursor)localObject1).moveToNext())
      {
        localObject2 = ((Cursor)localObject1).getString(0);
        Log.v("MicroMsg.App.SyncTopConversation", "userName %s", new Object[] { localObject2 });
        ab.K((String)localObject2, false);
      }
      ((Cursor)localObject1).close();
    }
    AppMethodBeat.o(20482);
  }
  
  public final boolean vc(int paramInt)
  {
    return (paramInt != 0) && (paramInt < 620758015);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ap.g
 * JD-Core Version:    0.7.0.1
 */