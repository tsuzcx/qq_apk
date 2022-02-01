package com.tencent.mm.plugin.game;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.model.b;
import com.tencent.mm.plugin.game.model.r;
import com.tencent.mm.sdk.platformtools.ad;

public final class d
  implements c, com.tencent.mm.plugin.game.api.d
{
  private b rNm;
  private r rNn;
  
  public final b cBb()
  {
    AppMethodBeat.i(40843);
    g.afz().aeD();
    if (this.rNm == null) {
      this.rNm = new b();
    }
    b localb = this.rNm;
    AppMethodBeat.o(40843);
    return localb;
  }
  
  public final r cBc()
  {
    AppMethodBeat.i(40845);
    g.afz().aeD();
    if (this.rNn == null) {
      this.rNn = new r();
    }
    r localr = this.rNn;
    AppMethodBeat.o(40845);
    return localr;
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(40841);
    ad.i("MicroMsg.GameService", "GameService onAccountInitialized");
    this.rNm = new b();
    this.rNn = new r();
    AppMethodBeat.o(40841);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(40842);
    ad.i("MicroMsg.GameService", "GameService onAccountRelease");
    AppMethodBeat.o(40842);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d
 * JD-Core Version:    0.7.0.1
 */