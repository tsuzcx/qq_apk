package com.tencent.mm.am;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.d;
import com.tencent.mm.aj.d.b;
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.z;
import com.tencent.mm.model.ai;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a
  extends ai
{
  public final String getTag()
  {
    return "MicroMsg.App.BizInfoDataTransfer";
  }
  
  public final boolean kv(int paramInt)
  {
    return (paramInt != 0) && (paramInt < 604372991);
  }
  
  public final void transfer(int paramInt)
  {
    AppMethodBeat.i(16429);
    ab.d("MicroMsg.App.BizInfoDataTransfer", "the previous version is %d", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt != 0) && (paramInt < 604372991))
    {
      com.tencent.mm.plugin.report.service.h.qsU.cT(336, 12);
      aw.aaz();
      Object localObject2 = c.Rq();
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("select BizInfo.username, BizInfo.extInfo");
      ((StringBuilder)localObject3).append(" from rcontact , BizInfo");
      ((StringBuilder)localObject3).append(" where rcontact.username = BizInfo.username");
      ((StringBuilder)localObject3).append(" and (rcontact.type & 1 ) != 0 ");
      ((StringBuilder)localObject3).append(" and ( rcontact.verifyFlag & 8 ) != 0 ");
      String str = ((StringBuilder)localObject3).toString();
      Object localObject1 = new ArrayList();
      ab.d("MicroMsg.App.BizInfoDataTransfer", "sql %s", new Object[] { str });
      localObject2 = ((com.tencent.mm.cg.h)localObject2).a(((StringBuilder)localObject3).toString(), null, 2);
      if (localObject2 != null)
      {
        while (((Cursor)localObject2).moveToNext())
        {
          localObject3 = new d();
          ((d)localObject3).convertFrom((Cursor)localObject2);
          if (((d)localObject3).cU(false).getServiceType() == 1) {
            ((List)localObject1).add(((d)localObject3).field_username);
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
        ab.d("MicroMsg.App.BizInfoDataTransfer", "update sql %s", new Object[] { localObject1 });
        z.afi().execSQL("BizInfo", (String)localObject1);
      }
    }
    AppMethodBeat.o(16429);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.am.a
 * JD-Core Version:    0.7.0.1
 */