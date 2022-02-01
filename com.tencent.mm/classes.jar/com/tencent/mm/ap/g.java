package com.tencent.mm.ap;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.am;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.model.w;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storagebase.h;

public final class g
  extends am
{
  public final String getTag()
  {
    return "MicroMsg.App.SyncTopConversation";
  }
  
  public final boolean op(int paramInt)
  {
    return (paramInt != 0) && (paramInt < 620758015);
  }
  
  public final void transfer(int paramInt)
  {
    AppMethodBeat.i(20482);
    ad.d("MicroMsg.App.SyncTopConversation", "the previous version is %d", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.mm.plugin.report.service.g.yhR.dD(336, 15);
    ba.aBQ();
    Object localObject1 = c.getDataDB();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("select username from rconversation");
    ((StringBuilder)localObject2).append(" where flag & 4611686018427387904 != 0");
    ad.d("MicroMsg.App.SyncTopConversation", "sql:%s", new Object[] { localObject2 });
    localObject1 = ((h)localObject1).a(((StringBuilder)localObject2).toString(), null, 2);
    if (localObject1 != null)
    {
      while (((Cursor)localObject1).moveToNext())
      {
        localObject2 = ((Cursor)localObject1).getString(0);
        ad.v("MicroMsg.App.SyncTopConversation", "userName %s", new Object[] { localObject2 });
        w.D((String)localObject2, false);
      }
      ((Cursor)localObject1).close();
    }
    AppMethodBeat.o(20482);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ap.g
 * JD-Core Version:    0.7.0.1
 */