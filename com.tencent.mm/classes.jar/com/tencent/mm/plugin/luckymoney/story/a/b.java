package com.tencent.mm.plugin.luckymoney.story.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c.a;
import com.tencent.mm.plugin.luckymoney.story.b.c;
import com.tencent.mm.plugin.luckymoney.story.b.d;
import com.tencent.mm.protocal.protobuf.cbz;
import com.tencent.mm.protocal.protobuf.dvl;
import com.tencent.mm.protocal.protobuf.eno;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.ISQLiteDatabaseEx;
import java.util.Iterator;
import java.util.LinkedList;

public final class b
  extends com.tencent.mm.wallet_core.c.a<cbz, a>
{
  public final void b(c.a<cbz> parama)
  {
    AppMethodBeat.i(182472);
    Log.i("MicroMsg.RedPacketStoryInfoAsyncLoader", "errType: %s, errCode: %s", new Object[] { Integer.valueOf(parama.errCode), Integer.valueOf(parama.errType) });
    if ((parama.errType == 0) && (parama.errCode == 0) && (((cbz)parama.lBJ).Tkp != null))
    {
      Object localObject = new com.tencent.mm.plugin.luckymoney.story.b.a();
      ((com.tencent.mm.plugin.luckymoney.story.b.a)localObject).field_packet_id = ((a)this.lBK).EDQ;
      ((cbz)parama.lBJ).Tkp.Tkq = ((cbz)parama.lBJ).Tkq;
      boolean bool = com.tencent.mm.plugin.luckymoney.b.a.eNR().eNO().get((IAutoDBItem)localObject, new String[0]);
      Log.i("MicroMsg.RedPacketStoryInfoAsyncLoader", "get story info: %s, %s", new Object[] { ((a)this.lBK).EDQ, Boolean.valueOf(bool) });
      com.tencent.mm.plugin.luckymoney.story.b.a.a((com.tencent.mm.plugin.luckymoney.story.b.a)localObject, ((cbz)parama.lBJ).Tkp, ((a)this.lBK).EDQ, ((cbz)parama.lBJ).Tkq);
      ((com.tencent.mm.plugin.luckymoney.story.b.a)localObject).field_update_time = System.currentTimeMillis();
      String str;
      int i;
      if (bool)
      {
        com.tencent.mm.plugin.luckymoney.b.a.eNR().eNO().update((IAutoDBItem)localObject, new String[0]);
        localObject = com.tencent.mm.plugin.luckymoney.b.a.eNR().eNP();
        str = ((a)this.lBK).EDQ;
        if (!Util.isNullOrNil(str)) {
          break label404;
        }
        i = -1;
        label250:
        Log.i("MicroMsg.RedPacketStoryInfoAsyncLoader", "delete story detail: %s", new Object[] { Integer.valueOf(i) });
        if (((cbz)parama.lBJ).Tkp.Ubq.isEmpty()) {
          break label490;
        }
        localObject = com.tencent.mm.plugin.luckymoney.b.a.eNR().eNP();
        if (((d)localObject).db == null) {
          break label447;
        }
      }
      label404:
      label447:
      for (long l = ((ISQLiteDatabaseEx)((d)localObject).db).beginTransaction(Thread.currentThread().getId());; l = -1L)
      {
        parama = ((cbz)parama.lBJ).Tkp.Ubq.iterator();
        while (parama.hasNext())
        {
          localObject = c.a((eno)parama.next(), ((a)this.lBK).EDQ);
          com.tencent.mm.plugin.luckymoney.b.a.eNR().eNP().insert((IAutoDBItem)localObject);
        }
        com.tencent.mm.plugin.luckymoney.b.a.eNR().eNO().insert((IAutoDBItem)localObject);
        break;
        Log.i("MicroMsg.LocalRedPacketStoryInfoStorage", "delete story detail: %s", new Object[] { str });
        i = ((d)localObject).db.delete("LocalStoryDetail", "packet_id=?", new String[] { str });
        break label250;
      }
      parama = com.tencent.mm.plugin.luckymoney.b.a.eNR().eNP();
      if (parama.db != null) {
        ((ISQLiteDatabaseEx)parama.db).endTransaction(l);
      }
      AppMethodBeat.o(182472);
      return;
      label490:
      Log.w("MicroMsg.RedPacketStoryInfoAsyncLoader", "story detail is empty!!");
    }
    AppMethodBeat.o(182472);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.story.a.b
 * JD-Core Version:    0.7.0.1
 */