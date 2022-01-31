package com.tencent.mm.plugin.game.model;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.d.bf;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;

final class ak$1
  implements f
{
  ak$1(ak.a parama) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    g.Dk().b(2641, this);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      y.i("MicroMsg.NetSceneGameIndex4TabNav", "pull gameIndexTabNav data success");
      ai.d(new ak.1.1(this, (bf)((ak)paramm).jvQ.ecF.ecN));
      return;
    }
    y.i("MicroMsg.NetSceneGameIndex4TabNav", "pull gameIndexTabNav data fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.ak.1
 * JD-Core Version:    0.7.0.1
 */