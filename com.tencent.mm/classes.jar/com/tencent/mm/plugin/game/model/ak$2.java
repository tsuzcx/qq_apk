package com.tencent.mm.plugin.game.model;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.a.c;
import com.tencent.mm.plugin.game.d.bf;
import com.tencent.mm.sdk.platformtools.y;

final class ak$2
  implements ak.b
{
  ak$2(bf parambf) {}
  
  public final void onComplete()
  {
    y.i("MicroMsg.NetSceneGameIndex4TabNav", "nav icon download complete! save nav data");
    ((c)g.r(c.class)).aYg().b("game_index4_tab_nav", this.kRg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.ak.2
 * JD-Core Version:    0.7.0.1
 */