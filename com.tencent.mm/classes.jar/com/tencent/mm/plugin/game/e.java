package com.tencent.mm.plugin.game;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.model.b;
import com.tencent.mm.plugin.game.model.r;
import com.tencent.mm.sdk.platformtools.ae;

public final class e
  implements c, com.tencent.mm.plugin.game.api.e
{
  private b ucv;
  private r ucw;
  
  public final b cZj()
  {
    AppMethodBeat.i(40843);
    g.ajP().aiU();
    if (this.ucv == null) {
      this.ucv = new b();
    }
    b localb = this.ucv;
    AppMethodBeat.o(40843);
    return localb;
  }
  
  public final r cZk()
  {
    AppMethodBeat.i(40845);
    g.ajP().aiU();
    if (this.ucw == null) {
      this.ucw = new r();
    }
    r localr = this.ucw;
    AppMethodBeat.o(40845);
    return localr;
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(40841);
    ae.i("MicroMsg.GameService", "GameService onAccountInitialized");
    this.ucv = new b();
    this.ucw = new r();
    AppMethodBeat.o(40841);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(40842);
    ae.i("MicroMsg.GameService", "GameService onAccountRelease");
    AppMethodBeat.o(40842);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.e
 * JD-Core Version:    0.7.0.1
 */