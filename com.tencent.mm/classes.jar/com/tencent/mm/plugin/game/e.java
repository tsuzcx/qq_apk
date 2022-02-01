package com.tencent.mm.plugin.game;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.model.b;
import com.tencent.mm.plugin.game.model.r;
import com.tencent.mm.sdk.platformtools.ad;

public final class e
  implements c, com.tencent.mm.plugin.game.api.e
{
  private b tRE;
  private r tRF;
  
  public final b cWF()
  {
    AppMethodBeat.i(40843);
    g.ajA().aiF();
    if (this.tRE == null) {
      this.tRE = new b();
    }
    b localb = this.tRE;
    AppMethodBeat.o(40843);
    return localb;
  }
  
  public final r cWG()
  {
    AppMethodBeat.i(40845);
    g.ajA().aiF();
    if (this.tRF == null) {
      this.tRF = new r();
    }
    r localr = this.tRF;
    AppMethodBeat.o(40845);
    return localr;
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(40841);
    ad.i("MicroMsg.GameService", "GameService onAccountInitialized");
    this.tRE = new b();
    this.tRF = new r();
    AppMethodBeat.o(40841);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(40842);
    ad.i("MicroMsg.GameService", "GameService onAccountRelease");
    AppMethodBeat.o(40842);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.e
 * JD-Core Version:    0.7.0.1
 */