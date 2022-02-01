package com.tencent.mm.plugin.emoji.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.ak.h.c;
import com.tencent.mm.model.cj.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.c;
import java.util.Map;

public final class e
  implements cj.a
{
  public final void a(h.a parama)
  {
    AppMethodBeat.i(108736);
    parama = parama.heO;
    if (parama.xKb == 10002)
    {
      parama = z.a(parama.KHn);
      if (Util.isNullOrNil(parama))
      {
        Log.w("MicroMsg.emoji.EmojiRecommnedSysCmdMsgListener", "msg content is null");
        AppMethodBeat.o(108736);
        return;
      }
      Object localObject = XmlParser.parseXml(parama, "sysmsg", null);
      if ((localObject != null) && (((Map)localObject).size() > 0))
      {
        localObject = (String)((Map)localObject).get(".sysmsg.$type");
        if ((!Util.isNullOrNil((String)localObject)) && (((String)localObject).equalsIgnoreCase("NewRecommendEmotion")))
        {
          parama = d.amT(parama);
          k.getEmojiStorageMgr().OpO.gEK();
          k.getEmojiStorageMgr().OpO.bk(parama);
          AppMethodBeat.o(108736);
          return;
        }
        Log.e("MicroMsg.emoji.EmojiRecommnedSysCmdMsgListener", "not emoji message type :".concat(String.valueOf(localObject)));
      }
      AppMethodBeat.o(108736);
      return;
    }
    Log.i("MicroMsg.emoji.EmojiRecommnedSysCmdMsgListener", "not new xml type:%d ", new Object[] { Integer.valueOf(parama.xKb) });
    AppMethodBeat.o(108736);
  }
  
  public final void a(h.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.g.e
 * JD-Core Version:    0.7.0.1
 */