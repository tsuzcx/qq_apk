package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.protocal.protobuf.bnw;
import com.tencent.mm.sdk.platformtools.ae;

final class f$2
  implements f.a
{
  f$2(String paramString, bnw parambnw) {}
  
  public final void onComplete()
  {
    AppMethodBeat.i(41399);
    ae.i("MicroMsg.GameCommOpertionProcessor", "menu icon download complete! save menu data. appid:%s", new Object[] { this.jEl });
    ((f)g.ab(f.class)).cZm().b("pb_game_hv_menu_" + this.jEl, this.umd);
    AppMethodBeat.o(41399);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.f.2
 * JD-Core Version:    0.7.0.1
 */