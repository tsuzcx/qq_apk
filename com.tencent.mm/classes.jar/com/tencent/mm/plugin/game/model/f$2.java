package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.api.e;
import com.tencent.mm.protocal.protobuf.aud;
import com.tencent.mm.sdk.platformtools.ab;

final class f$2
  implements f.a
{
  f$2(String paramString, aud paramaud) {}
  
  public final void onComplete()
  {
    AppMethodBeat.i(111237);
    ab.i("MicroMsg.GameCommOpertionProcessor", "menu icon download complete! save menu data. appid:%s", new Object[] { this.hye });
    ((e)g.E(e.class)).bET().b("pb_game_hv_menu_" + this.hye, this.nmw);
    AppMethodBeat.o(111237);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.f.2
 * JD-Core Version:    0.7.0.1
 */