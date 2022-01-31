package com.tencent.mm.plugin.game.model;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.a.c;
import com.tencent.mm.protocal.c.aol;
import com.tencent.mm.sdk.platformtools.y;

final class g$2
  implements g.a
{
  g$2(String paramString, aol paramaol) {}
  
  public final void onComplete()
  {
    y.i("MicroMsg.GameCommOpertionProcessor", "menu icon download complete! save menu data. appid:%s", new Object[] { this.gge });
    ((c)g.r(c.class)).aYg().b("pb_game_hv_menu_" + this.gge, this.kOz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.g.2
 * JD-Core Version:    0.7.0.1
 */