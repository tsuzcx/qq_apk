package com.tencent.mm.plugin.game.luggage.d;

import android.os.Bundle;
import com.tencent.luggage.d.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.c.a.c;
import com.tencent.mm.plugin.game.luggage.c.b;
import com.tencent.mm.sdk.platformtools.bo;

final class d$1
  implements Runnable
{
  d$1(d paramd) {}
  
  public final void run()
  {
    AppMethodBeat.i(135918);
    if (bo.isNullOrNil(d.a(this.nkl).bzu.getString("game_hv_menu_appid")))
    {
      d.a(this.nkl, new b(d.a(this.nkl), this.nkl.getMenuHelp()));
      AppMethodBeat.o(135918);
      return;
    }
    d.a(this.nkl, new c(d.a(this.nkl), d.b(this.nkl)));
    AppMethodBeat.o(135918);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.d.d.1
 * JD-Core Version:    0.7.0.1
 */