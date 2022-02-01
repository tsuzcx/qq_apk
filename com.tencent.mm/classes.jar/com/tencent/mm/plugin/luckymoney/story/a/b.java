package com.tencent.mm.plugin.luckymoney.story.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a.a;
import com.tencent.mm.plugin.luckymoney.story.b.d;
import com.tencent.mm.protocal.protobuf.bhr;
import com.tencent.mm.protocal.protobuf.csj;
import com.tencent.mm.protocal.protobuf.djf;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.LinkedList;

public final class b
  extends com.tencent.mm.wallet_core.c.a<bhr, a>
{
  public final void c(a.a<bhr> parama)
  {
    AppMethodBeat.i(182472);
    ad.i("MicroMsg.RedPacketStoryInfoAsyncLoader", "errType: %s, errCode: %s", new Object[] { Integer.valueOf(parama.errCode), Integer.valueOf(parama.errType) });
    if ((parama.errType == 0) && (parama.errCode == 0) && (((bhr)parama.hNC).GCV != null))
    {
      Object localObject = new com.tencent.mm.plugin.luckymoney.story.b.a();
      ((com.tencent.mm.plugin.luckymoney.story.b.a)localObject).field_packet_id = ((a)this.hND).vsz;
      boolean bool = com.tencent.mm.plugin.luckymoney.b.a.dhH().dhE().get((com.tencent.mm.sdk.e.c)localObject, new String[0]);
      ad.i("MicroMsg.RedPacketStoryInfoAsyncLoader", "get story info: %s, %s", new Object[] { ((a)this.hND).vsz, Boolean.valueOf(bool) });
      com.tencent.mm.plugin.luckymoney.story.b.a.a((com.tencent.mm.plugin.luckymoney.story.b.a)localObject, ((bhr)parama.hNC).GCV, ((a)this.hND).vsz);
      ((com.tencent.mm.plugin.luckymoney.story.b.a)localObject).field_update_time = System.currentTimeMillis();
      String str;
      int i;
      if (bool)
      {
        com.tencent.mm.plugin.luckymoney.b.a.dhH().dhE().update((com.tencent.mm.sdk.e.c)localObject, new String[0]);
        localObject = com.tencent.mm.plugin.luckymoney.b.a.dhH().dhF();
        str = ((a)this.hND).vsz;
        if (!bt.isNullOrNil(str)) {
          break label371;
        }
        i = -1;
        label217:
        ad.i("MicroMsg.RedPacketStoryInfoAsyncLoader", "delete story detail: %s", new Object[] { Integer.valueOf(i) });
        if (((bhr)parama.hNC).GCV.HkG.isEmpty()) {
          break label457;
        }
        localObject = com.tencent.mm.plugin.luckymoney.b.a.dhH().dhF();
        if (((d)localObject).db == null) {
          break label414;
        }
      }
      label414:
      for (long l = ((f)((d)localObject).db).xO(Thread.currentThread().getId());; l = -1L)
      {
        parama = ((bhr)parama.hNC).GCV.HkG.iterator();
        while (parama.hasNext())
        {
          localObject = com.tencent.mm.plugin.luckymoney.story.b.c.a((djf)parama.next(), ((a)this.hND).vsz);
          com.tencent.mm.plugin.luckymoney.b.a.dhH().dhF().insert((com.tencent.mm.sdk.e.c)localObject);
        }
        com.tencent.mm.plugin.luckymoney.b.a.dhH().dhE().insert((com.tencent.mm.sdk.e.c)localObject);
        break;
        label371:
        ad.i("MicroMsg.LocalRedPacketStoryInfoStorage", "delete story detail: %s", new Object[] { str });
        i = ((d)localObject).db.delete("LocalStoryDetail", "packet_id=?", new String[] { str });
        break label217;
      }
      parama = com.tencent.mm.plugin.luckymoney.b.a.dhH().dhF();
      if (parama.db != null) {
        ((f)parama.db).sJ(l);
      }
      AppMethodBeat.o(182472);
      return;
      label457:
      ad.w("MicroMsg.RedPacketStoryInfoAsyncLoader", "story detail is empty!!");
    }
    AppMethodBeat.o(182472);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.story.a.b
 * JD-Core Version:    0.7.0.1
 */