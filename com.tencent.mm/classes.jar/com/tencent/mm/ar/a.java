package com.tencent.mm.ar;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ao.af;
import com.tencent.mm.ao.f;
import com.tencent.mm.api.c.b;
import com.tencent.mm.model.at;
import com.tencent.mm.model.bh;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a
  extends at
{
  public final String getTag()
  {
    return "MicroMsg.App.BizInfoDataTransfer";
  }
  
  public final void uP(int paramInt)
  {
    AppMethodBeat.i(20475);
    Log.d("MicroMsg.App.BizInfoDataTransfer", "the previous version is %d", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt != 0) && (paramInt < 604372991))
    {
      com.tencent.mm.plugin.report.service.h.IzE.el(336, 12);
      bh.beI();
      Object localObject2 = com.tencent.mm.model.c.getDataDB();
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("select BizInfo.username, BizInfo.extInfo");
      ((StringBuilder)localObject3).append(" from rcontact , BizInfo");
      ((StringBuilder)localObject3).append(" where rcontact.username = BizInfo.username");
      ((StringBuilder)localObject3).append(" and (rcontact.type & 1 ) != 0 ");
      ((StringBuilder)localObject3).append(" and ( rcontact.verifyFlag & 8 ) != 0 ");
      String str = ((StringBuilder)localObject3).toString();
      Object localObject1 = new ArrayList();
      Log.d("MicroMsg.App.BizInfoDataTransfer", "sql %s", new Object[] { str });
      localObject2 = ((com.tencent.mm.storagebase.h)localObject2).rawQuery(((StringBuilder)localObject3).toString(), null, 2);
      if (localObject2 != null)
      {
        while (((Cursor)localObject2).moveToNext())
        {
          localObject3 = new com.tencent.mm.api.c();
          ((com.tencent.mm.api.c)localObject3).convertFrom((Cursor)localObject2);
          if (((com.tencent.mm.api.c)localObject3).dc(false).getServiceType() == 1) {
            ((List)localObject1).add(((com.tencent.mm.api.c)localObject3).field_username);
          }
        }
        ((Cursor)localObject2).close();
      }
      if (((List)localObject1).size() > 0)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Update BizInfo set type = 1 where 1 !=1 ");
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (String)((Iterator)localObject1).next();
          ((StringBuilder)localObject2).append(" or username = '").append((String)localObject3).append("'");
        }
        localObject1 = ((StringBuilder)localObject2).toString();
        Log.d("MicroMsg.App.BizInfoDataTransfer", "update sql %s", new Object[] { localObject1 });
        af.bjv().execSQL("BizInfo", (String)localObject1);
      }
    }
    AppMethodBeat.o(20475);
  }
  
  public final boolean uQ(int paramInt)
  {
    return (paramInt != 0) && (paramInt < 604372991);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ar.a
 * JD-Core Version:    0.7.0.1
 */