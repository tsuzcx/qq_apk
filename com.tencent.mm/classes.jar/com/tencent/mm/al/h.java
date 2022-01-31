package com.tencent.mm.al;

import android.database.Cursor;
import com.tencent.mm.model.ah;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.sdk.platformtools.y;

public final class h
  extends ah
{
  public final String getTag()
  {
    return "MicroMsg.App.SyncTopConversation";
  }
  
  public final boolean hJ(int paramInt)
  {
    return (paramInt != 0) && (paramInt < 620758015);
  }
  
  public final void transfer(int paramInt)
  {
    y.d("MicroMsg.App.SyncTopConversation", "the previous version is %d", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.mm.plugin.report.service.h.nFQ.h(336L, 15L, 1L);
    au.Hx();
    Object localObject1 = c.Dv();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("select username from rconversation");
    ((StringBuilder)localObject2).append(" where flag & 4611686018427387904 != 0");
    y.d("MicroMsg.App.SyncTopConversation", "sql:%s", new Object[] { localObject2 });
    localObject1 = ((com.tencent.mm.cf.h)localObject1).a(((StringBuilder)localObject2).toString(), null, 2);
    if (localObject1 != null)
    {
      while (((Cursor)localObject1).moveToNext())
      {
        localObject2 = ((Cursor)localObject1).getString(0);
        y.v("MicroMsg.App.SyncTopConversation", "userName %s", new Object[] { localObject2 });
        s.t((String)localObject2, false);
      }
      ((Cursor)localObject1).close();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.al.h
 * JD-Core Version:    0.7.0.1
 */