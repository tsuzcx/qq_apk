package com.tencent.mm.plugin.game.luggage;

import android.os.Bundle;
import com.tencent.luggage.e.n;
import com.tencent.mm.plugin.game.luggage.c.a.c;
import com.tencent.mm.sdk.platformtools.bk;

final class b$1
  implements Runnable
{
  b$1(b paramb) {}
  
  public final void run()
  {
    if (bk.bl(b.a(this.kMp).biV.getString("game_hv_menu_appid")))
    {
      b.a(this.kMp, new com.tencent.mm.plugin.game.luggage.c.b(b.a(this.kMp), this.kMp.getMenuHelp()));
      return;
    }
    b.a(this.kMp, new c(b.a(this.kMp), b.b(this.kMp)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.1
 * JD-Core Version:    0.7.0.1
 */