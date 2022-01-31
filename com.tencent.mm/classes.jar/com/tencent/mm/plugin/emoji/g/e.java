package com.tencent.mm.plugin.emoji.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.model.bz.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.a;
import java.util.Map;

public final class e
  implements bz.a
{
  public final void a(e.a parama)
  {
    AppMethodBeat.i(53163);
    parama = parama.eyJ;
    if (parama.nqW == 10002)
    {
      parama = aa.a(parama.woR);
      if (bo.isNullOrNil(parama))
      {
        ab.w("MicroMsg.emoji.EmojiRecommnedSysCmdMsgListener", "msg content is null");
        AppMethodBeat.o(53163);
        return;
      }
      Object localObject = br.F(parama, "sysmsg");
      if ((localObject != null) && (((Map)localObject).size() > 0))
      {
        localObject = (String)((Map)localObject).get(".sysmsg.$type");
        if ((!bo.isNullOrNil((String)localObject)) && (((String)localObject).equalsIgnoreCase("NewRecommendEmotion")))
        {
          parama = d.KW(parama);
          i.getEmojiStorageMgr().yNo.dza();
          i.getEmojiStorageMgr().yNo.al(parama);
          AppMethodBeat.o(53163);
          return;
        }
        ab.e("MicroMsg.emoji.EmojiRecommnedSysCmdMsgListener", "not emoji message type :".concat(String.valueOf(localObject)));
      }
      AppMethodBeat.o(53163);
      return;
    }
    ab.i("MicroMsg.emoji.EmojiRecommnedSysCmdMsgListener", "not new xml type:%d ", new Object[] { Integer.valueOf(parama.nqW) });
    AppMethodBeat.o(53163);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.g.e
 * JD-Core Version:    0.7.0.1
 */