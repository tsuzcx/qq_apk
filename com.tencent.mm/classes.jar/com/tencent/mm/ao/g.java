package com.tencent.mm.ao;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.al;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.model.w;
import com.tencent.mm.sdk.platformtools.ac;

public final class g
  extends al
{
  public final String getTag()
  {
    return "MicroMsg.App.SyncTopConversation";
  }
  
  public final boolean nP(int paramInt)
  {
    return (paramInt != 0) && (paramInt < 620758015);
  }
  
  public final void transfer(int paramInt)
  {
    AppMethodBeat.i(20482);
    ac.d("MicroMsg.App.SyncTopConversation", "the previous version is %d", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.mm.plugin.report.service.h.wUl.dB(336, 15);
    az.ayM();
    Object localObject1 = c.agw();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("select username from rconversation");
    ((StringBuilder)localObject2).append(" where flag & 4611686018427387904 != 0");
    ac.d("MicroMsg.App.SyncTopConversation", "sql:%s", new Object[] { localObject2 });
    localObject1 = ((com.tencent.mm.storagebase.h)localObject1).a(((StringBuilder)localObject2).toString(), null, 2);
    if (localObject1 != null)
    {
      while (((Cursor)localObject1).moveToNext())
      {
        localObject2 = ((Cursor)localObject1).getString(0);
        ac.v("MicroMsg.App.SyncTopConversation", "userName %s", new Object[] { localObject2 });
        w.D((String)localObject2, false);
      }
      ((Cursor)localObject1).close();
    }
    AppMethodBeat.o(20482);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ao.g
 * JD-Core Version:    0.7.0.1
 */