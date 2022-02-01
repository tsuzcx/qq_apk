package com.tencent.mm.plugin.luckymoney.story.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c.a;
import com.tencent.mm.plugin.luckymoney.story.b.d;
import com.tencent.mm.protocal.protobuf.bdl;
import com.tencent.mm.protocal.protobuf.cng;
import com.tencent.mm.protocal.protobuf.dds;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.f;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Iterator;
import java.util.LinkedList;

public final class b
  extends com.tencent.mm.wallet_core.c.a<bdl, a>
{
  public final void c(c.a<bdl> parama)
  {
    AppMethodBeat.i(182472);
    ac.i("MicroMsg.RedPacketStoryInfoAsyncLoader", "errType: %s, errCode: %s", new Object[] { Integer.valueOf(parama.errCode), Integer.valueOf(parama.errType) });
    if ((parama.errType == 0) && (parama.errCode == 0) && (((bdl)parama.hvj).ETB != null))
    {
      Object localObject = new com.tencent.mm.plugin.luckymoney.story.b.a();
      ((com.tencent.mm.plugin.luckymoney.story.b.a)localObject).field_packet_id = ((a)this.hvz).upV;
      boolean bool = com.tencent.mm.plugin.luckymoney.b.a.cYv().cYs().get((com.tencent.mm.sdk.e.c)localObject, new String[0]);
      ac.i("MicroMsg.RedPacketStoryInfoAsyncLoader", "get story info: %s, %s", new Object[] { ((a)this.hvz).upV, Boolean.valueOf(bool) });
      com.tencent.mm.plugin.luckymoney.story.b.a.a((com.tencent.mm.plugin.luckymoney.story.b.a)localObject, ((bdl)parama.hvj).ETB, ((a)this.hvz).upV);
      ((com.tencent.mm.plugin.luckymoney.story.b.a)localObject).field_update_time = System.currentTimeMillis();
      String str;
      int i;
      if (bool)
      {
        com.tencent.mm.plugin.luckymoney.b.a.cYv().cYs().update((com.tencent.mm.sdk.e.c)localObject, new String[0]);
        localObject = com.tencent.mm.plugin.luckymoney.b.a.cYv().cYt();
        str = ((a)this.hvz).upV;
        if (!bs.isNullOrNil(str)) {
          break label371;
        }
        i = -1;
        label217:
        ac.i("MicroMsg.RedPacketStoryInfoAsyncLoader", "delete story detail: %s", new Object[] { Integer.valueOf(i) });
        if (((bdl)parama.hvj).ETB.FAs.isEmpty()) {
          break label457;
        }
        localObject = com.tencent.mm.plugin.luckymoney.b.a.cYv().cYt();
        if (((d)localObject).db == null) {
          break label414;
        }
      }
      label414:
      for (long l = ((f)((d)localObject).db).vE(Thread.currentThread().getId());; l = -1L)
      {
        parama = ((bdl)parama.hvj).ETB.FAs.iterator();
        while (parama.hasNext())
        {
          localObject = com.tencent.mm.plugin.luckymoney.story.b.c.a((dds)parama.next(), ((a)this.hvz).upV);
          com.tencent.mm.plugin.luckymoney.b.a.cYv().cYt().insert((com.tencent.mm.sdk.e.c)localObject);
        }
        com.tencent.mm.plugin.luckymoney.b.a.cYv().cYs().insert((com.tencent.mm.sdk.e.c)localObject);
        break;
        label371:
        ac.i("MicroMsg.LocalRedPacketStoryInfoStorage", "delete story detail: %s", new Object[] { str });
        i = ((d)localObject).db.delete("LocalStoryDetail", "packet_id=?", new String[] { str });
        break label217;
      }
      parama = com.tencent.mm.plugin.luckymoney.b.a.cYv().cYt();
      if (parama.db != null) {
        ((f)parama.db).qL(l);
      }
      AppMethodBeat.o(182472);
      return;
      label457:
      ac.w("MicroMsg.RedPacketStoryInfoAsyncLoader", "story detail is empty!!");
    }
    AppMethodBeat.o(182472);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.story.a.b
 * JD-Core Version:    0.7.0.1
 */