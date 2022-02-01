package com.tencent.mm.plugin.luckymoney.story.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c.a;
import com.tencent.mm.plugin.luckymoney.story.b.c;
import com.tencent.mm.plugin.luckymoney.story.b.d;
import com.tencent.mm.protocal.protobuf.buh;
import com.tencent.mm.protocal.protobuf.dlt;
import com.tencent.mm.protocal.protobuf.edn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.ISQLiteDatabaseEx;
import java.util.Iterator;
import java.util.LinkedList;

public final class b
  extends com.tencent.mm.wallet_core.c.a<buh, a>
{
  public final void b(c.a<buh> parama)
  {
    AppMethodBeat.i(182472);
    Log.i("MicroMsg.RedPacketStoryInfoAsyncLoader", "errType: %s, errCode: %s", new Object[] { Integer.valueOf(parama.errCode), Integer.valueOf(parama.errType) });
    if ((parama.errType == 0) && (parama.errCode == 0) && (((buh)parama.iLC).MaT != null))
    {
      Object localObject = new com.tencent.mm.plugin.luckymoney.story.b.a();
      ((com.tencent.mm.plugin.luckymoney.story.b.a)localObject).field_packet_id = ((a)this.iLD).yZF;
      boolean bool = com.tencent.mm.plugin.luckymoney.b.a.eex().eeu().get((IAutoDBItem)localObject, new String[0]);
      Log.i("MicroMsg.RedPacketStoryInfoAsyncLoader", "get story info: %s, %s", new Object[] { ((a)this.iLD).yZF, Boolean.valueOf(bool) });
      com.tencent.mm.plugin.luckymoney.story.b.a.a((com.tencent.mm.plugin.luckymoney.story.b.a)localObject, ((buh)parama.iLC).MaT, ((a)this.iLD).yZF);
      ((com.tencent.mm.plugin.luckymoney.story.b.a)localObject).field_update_time = System.currentTimeMillis();
      String str;
      int i;
      if (bool)
      {
        com.tencent.mm.plugin.luckymoney.b.a.eex().eeu().update((IAutoDBItem)localObject, new String[0]);
        localObject = com.tencent.mm.plugin.luckymoney.b.a.eex().eev();
        str = ((a)this.iLD).yZF;
        if (!Util.isNullOrNil(str)) {
          break label371;
        }
        i = -1;
        label217:
        Log.i("MicroMsg.RedPacketStoryInfoAsyncLoader", "delete story detail: %s", new Object[] { Integer.valueOf(i) });
        if (((buh)parama.iLC).MaT.MPo.isEmpty()) {
          break label457;
        }
        localObject = com.tencent.mm.plugin.luckymoney.b.a.eex().eev();
        if (((d)localObject).db == null) {
          break label414;
        }
      }
      label414:
      for (long l = ((ISQLiteDatabaseEx)((d)localObject).db).beginTransaction(Thread.currentThread().getId());; l = -1L)
      {
        parama = ((buh)parama.iLC).MaT.MPo.iterator();
        while (parama.hasNext())
        {
          localObject = c.a((edn)parama.next(), ((a)this.iLD).yZF);
          com.tencent.mm.plugin.luckymoney.b.a.eex().eev().insert((IAutoDBItem)localObject);
        }
        com.tencent.mm.plugin.luckymoney.b.a.eex().eeu().insert((IAutoDBItem)localObject);
        break;
        label371:
        Log.i("MicroMsg.LocalRedPacketStoryInfoStorage", "delete story detail: %s", new Object[] { str });
        i = ((d)localObject).db.delete("LocalStoryDetail", "packet_id=?", new String[] { str });
        break label217;
      }
      parama = com.tencent.mm.plugin.luckymoney.b.a.eex().eev();
      if (parama.db != null) {
        ((ISQLiteDatabaseEx)parama.db).endTransaction(l);
      }
      AppMethodBeat.o(182472);
      return;
      label457:
      Log.w("MicroMsg.RedPacketStoryInfoAsyncLoader", "story detail is empty!!");
    }
    AppMethodBeat.o(182472);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.story.a.b
 * JD-Core Version:    0.7.0.1
 */