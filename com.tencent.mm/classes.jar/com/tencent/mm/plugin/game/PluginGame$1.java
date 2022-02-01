package com.tencent.mm.plugin.game;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class PluginGame$1
  implements Runnable
{
  PluginGame$1(PluginGame paramPluginGame) {}
  
  public final void run()
  {
    AppMethodBeat.i(40854);
    Object localObject2;
    for (;;)
    {
      try
      {
        Object localObject1 = ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cOp();
        localObject2 = String.format("select * from %s where %s=%d", new Object[] { "GameHaowanPublishEdition", "publishState", Integer.valueOf(0) });
        ac.i("MicroMsg.Haowan.GameHaowanPublishStorage", "queryAllPublish: %s", new Object[] { localObject2 });
        localObject2 = ((com.tencent.mm.plugin.game.media.g)localObject1).rawQuery((String)localObject2, new String[0]);
        if (localObject2 == null)
        {
          localObject1 = null;
          if (!bs.gY((List)localObject1)) {
            break;
          }
          ac.i("MicroMsg.PluginGame", "checkHaowanPublishState none");
          AppMethodBeat.o(40854);
          return;
        }
        localObject1 = new LinkedList();
        if (((Cursor)localObject2).moveToNext())
        {
          com.tencent.mm.plugin.game.media.e locale = new com.tencent.mm.plugin.game.media.e();
          locale.convertFrom((Cursor)localObject2);
          ((LinkedList)localObject1).add(locale);
        }
        else
        {
          ((Cursor)localObject2).close();
        }
      }
      catch (Exception localException)
      {
        ac.printErrStackTrace("MicroMsg.PluginGame", localException, "", new Object[0]);
        AppMethodBeat.o(40854);
        return;
      }
    }
    Iterator localIterator = localException.iterator();
    while (localIterator.hasNext())
    {
      localObject2 = (com.tencent.mm.plugin.game.media.e)localIterator.next();
      ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cOp().ahh(((com.tencent.mm.plugin.game.media.e)localObject2).field_taskId);
    }
    AppMethodBeat.o(40854);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.PluginGame.1
 * JD-Core Version:    0.7.0.1
 */