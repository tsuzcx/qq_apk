package com.tencent.mm.plugin.emoji.g;

import com.tencent.mm.ah.e.a;
import com.tencent.mm.model.bx.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.a;
import java.util.Map;

public final class e
  implements bx.a
{
  public final void a(e.a parama)
  {
    parama = parama.dBs;
    if (parama.kSW == 10002)
    {
      parama = aa.a(parama.svH);
      if (bk.bl(parama)) {
        y.w("MicroMsg.emoji.EmojiRecommnedSysCmdMsgListener", "msg content is null");
      }
      do
      {
        return;
        localObject = bn.s(parama, "sysmsg");
      } while ((localObject == null) || (((Map)localObject).size() <= 0));
      Object localObject = (String)((Map)localObject).get(".sysmsg.$type");
      if ((!bk.bl((String)localObject)) && (((String)localObject).equalsIgnoreCase("NewRecommendEmotion")))
      {
        parama = d.AU(parama);
        localObject = i.getEmojiStorageMgr().uBc;
        String str = EmojiGroupInfo.uCN;
        ((a)localObject).dXw.delete("EmojiGroupInfo", "recommand=? and type!=? and status!=?", new String[] { "1", str, "7" });
        localObject = i.getEmojiStorageMgr().uBc;
        y.i("MicroMsg.emoji.EmojiGroupInfoStorage", "[insertRecommendEmojiGroupInfo]");
        ((a)localObject).dH(parama);
        return;
      }
      y.e("MicroMsg.emoji.EmojiRecommnedSysCmdMsgListener", "not emoji message type :" + (String)localObject);
      return;
    }
    y.i("MicroMsg.emoji.EmojiRecommnedSysCmdMsgListener", "not new xml type:%d ", new Object[] { Integer.valueOf(parama.kSW) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.g.e
 * JD-Core Version:    0.7.0.1
 */