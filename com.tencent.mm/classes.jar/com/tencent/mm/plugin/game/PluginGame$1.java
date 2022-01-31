package com.tencent.mm.plugin.game;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.api.c;
import com.tencent.mm.plugin.game.api.e;
import com.tencent.mm.plugin.game.media.d;
import com.tencent.mm.plugin.game.media.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class PluginGame$1
  implements Runnable
{
  PluginGame$1(PluginGame paramPluginGame) {}
  
  public final void run()
  {
    AppMethodBeat.i(151788);
    Object localObject2;
    for (;;)
    {
      try
      {
        Object localObject1 = ((e)g.E(e.class)).bEV();
        localObject2 = String.format("select * from %s where %s=%d", new Object[] { "GameHaowanPublishEdition", "publishState", Integer.valueOf(0) });
        ab.i("MicroMsg.GameHaowanPublishStorage", "queryAllPublish: %s", new Object[] { localObject2 });
        localObject2 = ((f)localObject1).rawQuery((String)localObject2, new String[0]);
        if (localObject2 == null)
        {
          localObject1 = null;
          if (!bo.es((List)localObject1)) {
            break;
          }
          ab.i("MicroMsg.PluginGame", "checkHaowanPublishState none");
          AppMethodBeat.o(151788);
          return;
        }
        localObject1 = new LinkedList();
        if (((Cursor)localObject2).moveToNext())
        {
          d locald = new d();
          locald.convertFrom((Cursor)localObject2);
          ((LinkedList)localObject1).add(locald);
        }
        else
        {
          ((Cursor)localObject2).close();
        }
      }
      catch (Exception localException)
      {
        ab.printErrStackTrace("MicroMsg.PluginGame", localException, "", new Object[0]);
        AppMethodBeat.o(151788);
        return;
      }
    }
    Iterator localIterator = localException.iterator();
    while (localIterator.hasNext())
    {
      localObject2 = (d)localIterator.next();
      ab.i("MicroMsg.PluginGame", "checkHaowanPublishState, taskId = %s", new Object[] { ((d)localObject2).field_taskId });
      if (System.currentTimeMillis() / 1000L - ((d)localObject2).field_createTime > 600L)
      {
        ab.i("MicroMsg.PluginGame", "bigger than retry time, fail");
        ((e)g.E(e.class)).bEV().PZ(((d)localObject2).field_taskId);
      }
      else
      {
        ((c)g.E(c.class)).PM(((d)localObject2).field_taskId);
      }
    }
    AppMethodBeat.o(151788);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.PluginGame.1
 * JD-Core Version:    0.7.0.1
 */