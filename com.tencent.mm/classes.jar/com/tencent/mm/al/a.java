package com.tencent.mm.al;

import android.database.Cursor;
import com.tencent.mm.ai.d;
import com.tencent.mm.ai.d.b;
import com.tencent.mm.ai.e;
import com.tencent.mm.ai.z;
import com.tencent.mm.model.ah;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a
  extends ah
{
  public final String getTag()
  {
    return "MicroMsg.App.BizInfoDataTransfer";
  }
  
  public final boolean hJ(int paramInt)
  {
    return (paramInt != 0) && (paramInt < 604372991);
  }
  
  public final void transfer(int paramInt)
  {
    y.d("MicroMsg.App.BizInfoDataTransfer", "the previous version is %d", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt != 0) && (paramInt < 604372991))
    {
      com.tencent.mm.plugin.report.service.h.nFQ.h(336L, 12L, 1L);
      au.Hx();
      Object localObject2 = c.Dv();
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("select BizInfo.username, BizInfo.extInfo");
      ((StringBuilder)localObject3).append(" from rcontact , BizInfo");
      ((StringBuilder)localObject3).append(" where rcontact.username = BizInfo.username");
      ((StringBuilder)localObject3).append(" and (rcontact.type & 1 ) != 0 ");
      ((StringBuilder)localObject3).append(" and ( rcontact.verifyFlag & 8 ) != 0 ");
      String str = ((StringBuilder)localObject3).toString();
      Object localObject1 = new ArrayList();
      y.d("MicroMsg.App.BizInfoDataTransfer", "sql %s", new Object[] { str });
      localObject2 = ((com.tencent.mm.cf.h)localObject2).a(((StringBuilder)localObject3).toString(), null, 2);
      if (localObject2 != null)
      {
        while (((Cursor)localObject2).moveToNext())
        {
          localObject3 = new d();
          ((d)localObject3).d((Cursor)localObject2);
          if (((d)localObject3).bS(false).LW() == 1) {
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
        y.d("MicroMsg.App.BizInfoDataTransfer", "update sql %s", new Object[] { localObject1 });
        z.My().gk("BizInfo", (String)localObject1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.al.a
 * JD-Core Version:    0.7.0.1
 */