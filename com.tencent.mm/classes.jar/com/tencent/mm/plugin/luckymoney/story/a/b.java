package com.tencent.mm.plugin.luckymoney.story.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.plugin.luckymoney.story.b.c;
import com.tencent.mm.plugin.luckymoney.story.b.d;
import com.tencent.mm.protocal.protobuf.crg;
import com.tencent.mm.protocal.protobuf.eoh;
import com.tencent.mm.protocal.protobuf.fim;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.ISQLiteDatabaseEx;
import java.util.Iterator;
import java.util.LinkedList;

public final class b
  extends com.tencent.mm.wallet_core.model.a<crg, a>
{
  public final void b(b.a<crg> parama)
  {
    AppMethodBeat.i(182472);
    Log.i("MicroMsg.RedPacketStoryInfoAsyncLoader", "errType: %s, errCode: %s", new Object[] { Integer.valueOf(parama.errCode), Integer.valueOf(parama.errType) });
    if ((parama.errType == 0) && (parama.errCode == 0) && (((crg)parama.ott).aaxS != null))
    {
      Object localObject = new com.tencent.mm.plugin.luckymoney.story.b.a();
      ((com.tencent.mm.plugin.luckymoney.story.b.a)localObject).field_packet_id = ((a)this.otu).KwU;
      ((crg)parama.ott).aaxS.aaxT = ((crg)parama.ott).aaxT;
      boolean bool = com.tencent.mm.plugin.luckymoney.app.a.fWk().fWh().get((IAutoDBItem)localObject, new String[0]);
      Log.i("MicroMsg.RedPacketStoryInfoAsyncLoader", "get story info: %s, %s", new Object[] { ((a)this.otu).KwU, Boolean.valueOf(bool) });
      com.tencent.mm.plugin.luckymoney.story.b.a.a((com.tencent.mm.plugin.luckymoney.story.b.a)localObject, ((crg)parama.ott).aaxS, ((a)this.otu).KwU, ((crg)parama.ott).aaxT);
      ((com.tencent.mm.plugin.luckymoney.story.b.a)localObject).field_update_time = System.currentTimeMillis();
      String str;
      int i;
      if (bool)
      {
        com.tencent.mm.plugin.luckymoney.app.a.fWk().fWh().update((IAutoDBItem)localObject, new String[0]);
        localObject = com.tencent.mm.plugin.luckymoney.app.a.fWk().fWi();
        str = ((a)this.otu).KwU;
        if (!Util.isNullOrNil(str)) {
          break label404;
        }
        i = -1;
        label250:
        Log.i("MicroMsg.RedPacketStoryInfoAsyncLoader", "delete story detail: %s", new Object[] { Integer.valueOf(i) });
        if (((crg)parama.ott).aaxS.absw.isEmpty()) {
          break label490;
        }
        localObject = com.tencent.mm.plugin.luckymoney.app.a.fWk().fWi();
        if (((d)localObject).db == null) {
          break label447;
        }
      }
      label404:
      label447:
      for (long l = ((ISQLiteDatabaseEx)((d)localObject).db).beginTransaction(Thread.currentThread().getId());; l = -1L)
      {
        parama = ((crg)parama.ott).aaxS.absw.iterator();
        while (parama.hasNext())
        {
          localObject = c.a((fim)parama.next(), ((a)this.otu).KwU);
          com.tencent.mm.plugin.luckymoney.app.a.fWk().fWi().insert((IAutoDBItem)localObject);
        }
        com.tencent.mm.plugin.luckymoney.app.a.fWk().fWh().insert((IAutoDBItem)localObject);
        break;
        Log.i("MicroMsg.LocalRedPacketStoryInfoStorage", "delete story detail: %s", new Object[] { str });
        i = ((d)localObject).db.delete("LocalStoryDetail", "packet_id=?", new String[] { str });
        break label250;
      }
      parama = com.tencent.mm.plugin.luckymoney.app.a.fWk().fWi();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.story.a.b
 * JD-Core Version:    0.7.0.1
 */