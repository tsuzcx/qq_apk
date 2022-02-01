package com.tencent.mm.plugin.emoji.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e.a;
import com.tencent.mm.al.e.c;
import com.tencent.mm.model.cd.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.emotion.c;
import java.util.Map;

public final class e
  implements cd.a
{
  public final void a(e.a parama)
  {
    AppMethodBeat.i(108736);
    parama = parama.gqE;
    if (parama.ugm == 10002)
    {
      parama = z.a(parama.Fvk);
      if (bt.isNullOrNil(parama))
      {
        ad.w("MicroMsg.emoji.EmojiRecommnedSysCmdMsgListener", "msg content is null");
        AppMethodBeat.o(108736);
        return;
      }
      Object localObject = bw.M(parama, "sysmsg");
      if ((localObject != null) && (((Map)localObject).size() > 0))
      {
        localObject = (String)((Map)localObject).get(".sysmsg.$type");
        if ((!bt.isNullOrNil((String)localObject)) && (((String)localObject).equalsIgnoreCase("NewRecommendEmotion")))
        {
          parama = d.abV(parama);
          k.getEmojiStorageMgr().ILo.fsX();
          k.getEmojiStorageMgr().ILo.aR(parama);
          AppMethodBeat.o(108736);
          return;
        }
        ad.e("MicroMsg.emoji.EmojiRecommnedSysCmdMsgListener", "not emoji message type :".concat(String.valueOf(localObject)));
      }
      AppMethodBeat.o(108736);
      return;
    }
    ad.i("MicroMsg.emoji.EmojiRecommnedSysCmdMsgListener", "not new xml type:%d ", new Object[] { Integer.valueOf(parama.ugm) });
    AppMethodBeat.o(108736);
  }
  
  public final void a(e.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.g.e
 * JD-Core Version:    0.7.0.1
 */