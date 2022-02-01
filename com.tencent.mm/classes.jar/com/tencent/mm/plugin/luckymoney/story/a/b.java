package com.tencent.mm.plugin.luckymoney.story.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.c.a;
import com.tencent.mm.plugin.luckymoney.story.b.d;
import com.tencent.mm.protocal.protobuf.azt;
import com.tencent.mm.protocal.protobuf.cic;
import com.tencent.mm.protocal.protobuf.cyg;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.LinkedList;

public final class b
  extends com.tencent.mm.wallet_core.c.a<azt, a>
{
  public final void c(c.a<azt> parama)
  {
    AppMethodBeat.i(182472);
    ad.i("MicroMsg.RedPacketStoryInfoAsyncLoader", "errType: %s, errCode: %s", new Object[] { Integer.valueOf(parama.errCode), Integer.valueOf(parama.errType) });
    if ((parama.errType == 0) && (parama.errCode == 0) && (((azt)parama.gUK).Dyf != null))
    {
      Object localObject = new com.tencent.mm.plugin.luckymoney.story.b.a();
      ((com.tencent.mm.plugin.luckymoney.story.b.a)localObject).field_packet_id = ((a)this.gVa).thF;
      boolean bool = com.tencent.mm.plugin.luckymoney.b.a.cKP().cKN().get((com.tencent.mm.sdk.e.c)localObject, new String[0]);
      ad.i("MicroMsg.RedPacketStoryInfoAsyncLoader", "get story info: %s, %s", new Object[] { ((a)this.gVa).thF, Boolean.valueOf(bool) });
      com.tencent.mm.plugin.luckymoney.story.b.a.a((com.tencent.mm.plugin.luckymoney.story.b.a)localObject, ((azt)parama.gUK).Dyf, ((a)this.gVa).thF);
      ((com.tencent.mm.plugin.luckymoney.story.b.a)localObject).field_update_time = System.currentTimeMillis();
      String str;
      int i;
      if (bool)
      {
        com.tencent.mm.plugin.luckymoney.b.a.cKP().cKN().update((com.tencent.mm.sdk.e.c)localObject, new String[0]);
        localObject = com.tencent.mm.plugin.luckymoney.b.a.cKP().cKO();
        str = ((a)this.gVa).thF;
        if (!bt.isNullOrNil(str)) {
          break label371;
        }
        i = -1;
        label217:
        ad.i("MicroMsg.RedPacketStoryInfoAsyncLoader", "delete story detail: %s", new Object[] { Integer.valueOf(i) });
        if (((azt)parama.gUK).Dyf.Edv.isEmpty()) {
          break label457;
        }
        localObject = com.tencent.mm.plugin.luckymoney.b.a.cKP().cKO();
        if (((d)localObject).db == null) {
          break label414;
        }
      }
      label414:
      for (long l = ((f)((d)localObject).db).rb(Thread.currentThread().getId());; l = -1L)
      {
        parama = ((azt)parama.gUK).Dyf.Edv.iterator();
        while (parama.hasNext())
        {
          localObject = com.tencent.mm.plugin.luckymoney.story.b.c.a((cyg)parama.next(), ((a)this.gVa).thF);
          com.tencent.mm.plugin.luckymoney.b.a.cKP().cKO().insert((com.tencent.mm.sdk.e.c)localObject);
        }
        com.tencent.mm.plugin.luckymoney.b.a.cKP().cKN().insert((com.tencent.mm.sdk.e.c)localObject);
        break;
        label371:
        ad.i("MicroMsg.LocalRedPacketStoryInfoStorage", "delete story detail: %s", new Object[] { str });
        i = ((d)localObject).db.delete("LocalStoryDetail", "packet_id=?", new String[] { str });
        break label217;
      }
      parama = com.tencent.mm.plugin.luckymoney.b.a.cKP().cKO();
      if (parama.db != null) {
        ((f)parama.db).mX(l);
      }
      AppMethodBeat.o(182472);
      return;
      label457:
      ad.w("MicroMsg.RedPacketStoryInfoAsyncLoader", "story detail is empty!!");
    }
    AppMethodBeat.o(182472);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.story.a.b
 * JD-Core Version:    0.7.0.1
 */