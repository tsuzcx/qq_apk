package com.tencent.mm.plugin.luckymoney.story.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a.a;
import com.tencent.mm.plugin.luckymoney.story.b.d;
import com.tencent.mm.protocal.protobuf.bih;
import com.tencent.mm.protocal.protobuf.ctd;
import com.tencent.mm.protocal.protobuf.dka;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.f;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Iterator;
import java.util.LinkedList;

public final class b
  extends com.tencent.mm.wallet_core.c.a<bih, a>
{
  public final void c(a.a<bih> parama)
  {
    AppMethodBeat.i(182472);
    ae.i("MicroMsg.RedPacketStoryInfoAsyncLoader", "errType: %s, errCode: %s", new Object[] { Integer.valueOf(parama.errCode), Integer.valueOf(parama.errType) });
    if ((parama.errType == 0) && (parama.errCode == 0) && (((bih)parama.hQv).GWv != null))
    {
      Object localObject = new com.tencent.mm.plugin.luckymoney.story.b.a();
      ((com.tencent.mm.plugin.luckymoney.story.b.a)localObject).field_packet_id = ((a)this.hQw).vEE;
      boolean bool = com.tencent.mm.plugin.luckymoney.b.a.dkG().dkD().get((com.tencent.mm.sdk.e.c)localObject, new String[0]);
      ae.i("MicroMsg.RedPacketStoryInfoAsyncLoader", "get story info: %s, %s", new Object[] { ((a)this.hQw).vEE, Boolean.valueOf(bool) });
      com.tencent.mm.plugin.luckymoney.story.b.a.a((com.tencent.mm.plugin.luckymoney.story.b.a)localObject, ((bih)parama.hQv).GWv, ((a)this.hQw).vEE);
      ((com.tencent.mm.plugin.luckymoney.story.b.a)localObject).field_update_time = System.currentTimeMillis();
      String str;
      int i;
      if (bool)
      {
        com.tencent.mm.plugin.luckymoney.b.a.dkG().dkD().update((com.tencent.mm.sdk.e.c)localObject, new String[0]);
        localObject = com.tencent.mm.plugin.luckymoney.b.a.dkG().dkE();
        str = ((a)this.hQw).vEE;
        if (!bu.isNullOrNil(str)) {
          break label371;
        }
        i = -1;
        label217:
        ae.i("MicroMsg.RedPacketStoryInfoAsyncLoader", "delete story detail: %s", new Object[] { Integer.valueOf(i) });
        if (((bih)parama.hQv).GWv.HEg.isEmpty()) {
          break label457;
        }
        localObject = com.tencent.mm.plugin.luckymoney.b.a.dkG().dkE();
        if (((d)localObject).db == null) {
          break label414;
        }
      }
      label414:
      for (long l = ((f)((d)localObject).db).yi(Thread.currentThread().getId());; l = -1L)
      {
        parama = ((bih)parama.hQv).GWv.HEg.iterator();
        while (parama.hasNext())
        {
          localObject = com.tencent.mm.plugin.luckymoney.story.b.c.a((dka)parama.next(), ((a)this.hQw).vEE);
          com.tencent.mm.plugin.luckymoney.b.a.dkG().dkE().insert((com.tencent.mm.sdk.e.c)localObject);
        }
        com.tencent.mm.plugin.luckymoney.b.a.dkG().dkD().insert((com.tencent.mm.sdk.e.c)localObject);
        break;
        label371:
        ae.i("MicroMsg.LocalRedPacketStoryInfoStorage", "delete story detail: %s", new Object[] { str });
        i = ((d)localObject).db.delete("LocalStoryDetail", "packet_id=?", new String[] { str });
        break label217;
      }
      parama = com.tencent.mm.plugin.luckymoney.b.a.dkG().dkE();
      if (parama.db != null) {
        ((f)parama.db).sW(l);
      }
      AppMethodBeat.o(182472);
      return;
      label457:
      ae.w("MicroMsg.RedPacketStoryInfoAsyncLoader", "story detail is empty!!");
    }
    AppMethodBeat.o(182472);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.story.a.b
 * JD-Core Version:    0.7.0.1
 */