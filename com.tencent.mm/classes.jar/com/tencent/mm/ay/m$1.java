package com.tencent.mm.ay;

import android.database.Cursor;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.openim.b.l;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.b;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class m$1
  implements am.a
{
  m$1(m paramm) {}
  
  public final boolean tC()
  {
    y.d("MicroMsg.OplogService", "summeroplog pusherTry onTimerExpired tryStartNetscene");
    m localm = this.ewj;
    long l = bk.UY();
    if ((localm.ebb) && (l - localm.ebl > 10000L)) {
      localm.ebb = false;
    }
    if (localm.ebb) {
      y.d("MicroMsg.OplogService", "summeroplog tryStartNetscene netSceneRunning, return.");
    }
    for (;;)
    {
      return false;
      Object localObject1 = localm.ewi;
      ArrayList localArrayList = new ArrayList();
      localObject1 = ((h)localObject1).dXo.a("select oplog2.id,oplog2.inserTime,oplog2.cmdId,oplog2.buffer,oplog2.reserved1,oplog2.reserved2,oplog2.reserved3,oplog2.reserved4 from oplog2  order by inserTime asc limit ?", new String[] { "200" }, 0);
      if (localObject1 == null) {}
      Object localObject2;
      for (;;)
      {
        if (localArrayList.size() != 0) {
          break label296;
        }
        y.d("MicroMsg.OplogService", "summeroplog tryStartNetscene list null ret");
        break;
        int j = ((Cursor)localObject1).getCount();
        if (j > 0)
        {
          int i = 0;
          while (i < j)
          {
            ((Cursor)localObject1).moveToPosition(i);
            localObject2 = new i.b(0);
            ((i.b)localObject2).id = ((Cursor)localObject1).getInt(0);
            ((i.b)localObject2).eml = ((Cursor)localObject1).getLong(1);
            ((i.b)localObject2).cmdId = ((Cursor)localObject1).getInt(2);
            ((i.b)localObject2).buffer = ((Cursor)localObject1).getBlob(3);
            ((i.b)localObject2).mdz = ((Cursor)localObject1).getInt(4);
            ((i.b)localObject2).mdA = ((Cursor)localObject1).getLong(5);
            ((i.b)localObject2).mdB = ((Cursor)localObject1).getString(6);
            ((i.b)localObject2).mdC = ((Cursor)localObject1).getString(7);
            localArrayList.add(localObject2);
            i += 1;
          }
        }
        ((Cursor)localObject1).close();
      }
      label296:
      if ((!localm.ebb) && (localArrayList.size() > 0))
      {
        localm.ebl = l;
        localm.ebb = true;
        localObject1 = new LinkedList();
        localObject2 = localArrayList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          i.b localb = (i.b)((Iterator)localObject2).next();
          if ((localb.getCmdId() == 0) && (localb.mdz > 0)) {
            ((List)localObject1).add(localb);
          }
        }
        localArrayList.removeAll((Collection)localObject1);
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (i.b)((Iterator)localObject1).next();
          if ("@openim".equals(((i.b)localObject2).mdB))
          {
            g.DQ();
            g.DO().dJT.a(new l((i.b)localObject2), 0);
          }
          else
          {
            localm.ewi.a((i.b)localObject2);
          }
        }
        if (!localArrayList.isEmpty())
        {
          g.DQ();
          g.DO().dJT.a(new a(localArrayList), 0);
        }
      }
      y.d("MicroMsg.OplogService", "summeroplog tryStartNetscene ret ok lastNetscene: %d,  netSceneRunning:%B, take:%d ms. size %s", new Object[] { Long.valueOf(localm.ebl), Boolean.valueOf(localm.ebb), Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(localArrayList.size()) });
    }
  }
  
  public final String toString()
  {
    return super.toString() + "|pusherTry";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ay.m.1
 * JD-Core Version:    0.7.0.1
 */