package com.tencent.mm.ao;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.as;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.Log;

public final class g
  extends as
{
  public final String getTag()
  {
    return "MicroMsg.App.SyncTopConversation";
  }
  
  public final boolean rT(int paramInt)
  {
    return (paramInt != 0) && (paramInt < 620758015);
  }
  
  public final void transfer(int paramInt)
  {
    AppMethodBeat.i(20482);
    Log.d("MicroMsg.App.SyncTopConversation", "the previous version is %d", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.mm.plugin.report.service.h.CyF.dN(336, 15);
    bg.aVF();
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
        ab.E((String)localObject2, false);
      }
      ((Cursor)localObject1).close();
    }
    AppMethodBeat.o(20482);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ao.g
 * JD-Core Version:    0.7.0.1
 */