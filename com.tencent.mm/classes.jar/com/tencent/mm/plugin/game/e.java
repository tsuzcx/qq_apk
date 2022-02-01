package com.tencent.mm.plugin.game;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.game.model.r;
import com.tencent.mm.sdk.platformtools.Log;

public final class e
  implements c, com.tencent.mm.plugin.game.api.e
{
  private com.tencent.mm.plugin.game.model.b Cgk;
  private r Cgl;
  
  public final com.tencent.mm.plugin.game.model.b evm()
  {
    AppMethodBeat.i(40843);
    h.aHE().aGH();
    if (this.Cgk == null) {
      this.Cgk = new com.tencent.mm.plugin.game.model.b();
    }
    com.tencent.mm.plugin.game.model.b localb = this.Cgk;
    AppMethodBeat.o(40843);
    return localb;
  }
  
  public final r evn()
  {
    AppMethodBeat.i(40845);
    h.aHE().aGH();
    if (this.Cgl == null) {
      this.Cgl = new r();
    }
    r localr = this.Cgl;
    AppMethodBeat.o(40845);
    return localr;
  }
  
  public final void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(40841);
    Log.i("MicroMsg.GameService", "GameService onAccountInitialized");
    this.Cgk = new com.tencent.mm.plugin.game.model.b();
    this.Cgl = new r();
    AppMethodBeat.o(40841);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(40842);
    Log.i("MicroMsg.GameService", "GameService onAccountRelease");
    AppMethodBeat.o(40842);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.e
 * JD-Core Version:    0.7.0.1
 */