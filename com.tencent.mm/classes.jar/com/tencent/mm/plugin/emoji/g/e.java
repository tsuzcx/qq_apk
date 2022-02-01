package com.tencent.mm.plugin.emoji.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f.a;
import com.tencent.mm.ak.f.c;
import com.tencent.mm.model.cc.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.emotion.c;
import java.util.Map;

public final class e
  implements cc.a
{
  public final void a(f.a parama)
  {
    AppMethodBeat.i(108736);
    parama = parama.fXi;
    if (parama.tit == 10002)
    {
      parama = z.a(parama.DPV);
      if (bs.isNullOrNil(parama))
      {
        ac.w("MicroMsg.emoji.EmojiRecommnedSysCmdMsgListener", "msg content is null");
        AppMethodBeat.o(108736);
        return;
      }
      Object localObject = bv.L(parama, "sysmsg");
      if ((localObject != null) && (((Map)localObject).size() > 0))
      {
        localObject = (String)((Map)localObject).get(".sysmsg.$type");
        if ((!bs.isNullOrNil((String)localObject)) && (((String)localObject).equalsIgnoreCase("NewRecommendEmotion")))
        {
          parama = d.Yp(parama);
          k.getEmojiStorageMgr().GYa.fcQ();
          k.getEmojiStorageMgr().GYa.aU(parama);
          AppMethodBeat.o(108736);
          return;
        }
        ac.e("MicroMsg.emoji.EmojiRecommnedSysCmdMsgListener", "not emoji message type :".concat(String.valueOf(localObject)));
      }
      AppMethodBeat.o(108736);
      return;
    }
    ac.i("MicroMsg.emoji.EmojiRecommnedSysCmdMsgListener", "not new xml type:%d ", new Object[] { Integer.valueOf(parama.tit) });
    AppMethodBeat.o(108736);
  }
  
  public final void a(f.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.g.e
 * JD-Core Version:    0.7.0.1
 */