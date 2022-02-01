package com.tencent.mm.plugin.emoji.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.e.c;
import com.tencent.mm.model.cf.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.emotion.c;
import java.util.Map;

public final class e
  implements cf.a
{
  public final void a(e.a parama)
  {
    AppMethodBeat.i(108736);
    parama = parama.gte;
    if (parama.urJ == 10002)
    {
      parama = z.a(parama.FNI);
      if (bu.isNullOrNil(parama))
      {
        ae.w("MicroMsg.emoji.EmojiRecommnedSysCmdMsgListener", "msg content is null");
        AppMethodBeat.o(108736);
        return;
      }
      Object localObject = bx.M(parama, "sysmsg");
      if ((localObject != null) && (((Map)localObject).size() > 0))
      {
        localObject = (String)((Map)localObject).get(".sysmsg.$type");
        if ((!bu.isNullOrNil((String)localObject)) && (((String)localObject).equalsIgnoreCase("NewRecommendEmotion")))
        {
          parama = d.acM(parama);
          k.getEmojiStorageMgr().JfV.fwY();
          k.getEmojiStorageMgr().JfV.aS(parama);
          AppMethodBeat.o(108736);
          return;
        }
        ae.e("MicroMsg.emoji.EmojiRecommnedSysCmdMsgListener", "not emoji message type :".concat(String.valueOf(localObject)));
      }
      AppMethodBeat.o(108736);
      return;
    }
    ae.i("MicroMsg.emoji.EmojiRecommnedSysCmdMsgListener", "not new xml type:%d ", new Object[] { Integer.valueOf(parama.urJ) });
    AppMethodBeat.o(108736);
  }
  
  public final void a(e.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.g.e
 * JD-Core Version:    0.7.0.1
 */