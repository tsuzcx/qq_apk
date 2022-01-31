package com.tencent.mm.az;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.cg.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.openim.b.l;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class n$1
  implements ap.a
{
  n$1(n paramn) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(991);
    ab.d("MicroMsg.OplogService", "summeroplog pusherTry onTimerExpired tryStartNetscene");
    n localn = this.fLZ;
    long l = bo.aoy();
    if ((localn.frp) && (l - localn.frA > 10000L)) {
      localn.frp = false;
    }
    if (localn.frp) {
      ab.d("MicroMsg.OplogService", "summeroplog tryStartNetscene netSceneRunning, return.");
    }
    for (;;)
    {
      AppMethodBeat.o(991);
      return false;
      Object localObject1 = localn.fLY;
      ArrayList localArrayList = new ArrayList();
      localObject1 = ((i)localObject1).fnw.a("select oplog2.id,oplog2.inserTime,oplog2.cmdId,oplog2.buffer,oplog2.reserved1,oplog2.reserved2,oplog2.reserved3,oplog2.reserved4 from oplog2  order by inserTime asc limit ?", new String[] { "200" }, 0);
      if (localObject1 == null) {}
      Object localObject2;
      for (;;)
      {
        if (localArrayList.size() != 0) {
          break label308;
        }
        ab.d("MicroMsg.OplogService", "summeroplog tryStartNetscene list null ret");
        break;
        int j = ((Cursor)localObject1).getCount();
        if (j > 0)
        {
          int i = 0;
          while (i < j)
          {
            ((Cursor)localObject1).moveToPosition(i);
            localObject2 = new j.b(0);
            ((j.b)localObject2).id = ((Cursor)localObject1).getInt(0);
            ((j.b)localObject2).fCI = ((Cursor)localObject1).getLong(1);
            ((j.b)localObject2).cmdId = ((Cursor)localObject1).getInt(2);
            ((j.b)localObject2).buffer = ((Cursor)localObject1).getBlob(3);
            ((j.b)localObject2).oDV = ((Cursor)localObject1).getInt(4);
            ((j.b)localObject2).oDW = ((Cursor)localObject1).getLong(5);
            ((j.b)localObject2).oDX = ((Cursor)localObject1).getString(6);
            ((j.b)localObject2).oDY = ((Cursor)localObject1).getString(7);
            localArrayList.add(localObject2);
            i += 1;
          }
        }
        ((Cursor)localObject1).close();
      }
      label308:
      if ((!localn.frp) && (localArrayList.size() > 0))
      {
        localn.frA = l;
        localn.frp = true;
        localObject1 = new LinkedList();
        localObject2 = localArrayList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          j.b localb = (j.b)((Iterator)localObject2).next();
          if ((localb.getCmdId() == 0) && (localb.oDV > 0)) {
            ((List)localObject1).add(localb);
          }
        }
        localArrayList.removeAll((Collection)localObject1);
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (j.b)((Iterator)localObject1).next();
          if ("@openim".equals(((j.b)localObject2).oDX))
          {
            g.RM();
            g.RK().eHt.a(new l((j.b)localObject2), 0);
          }
          else
          {
            localn.fLY.b((j.b)localObject2);
          }
        }
        if (!localArrayList.isEmpty())
        {
          g.RM();
          g.RK().eHt.a(new b(localArrayList), 0);
        }
      }
      ab.d("MicroMsg.OplogService", "summeroplog tryStartNetscene ret ok lastNetscene: %d,  netSceneRunning:%B, take:%d ms. size %s", new Object[] { Long.valueOf(localn.frA), Boolean.valueOf(localn.frp), Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(localArrayList.size()) });
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(992);
    String str = super.toString() + "|pusherTry";
    AppMethodBeat.o(992);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.az.n.1
 * JD-Core Version:    0.7.0.1
 */