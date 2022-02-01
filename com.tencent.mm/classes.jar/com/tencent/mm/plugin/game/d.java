package com.tencent.mm.plugin.game;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.model.b;
import com.tencent.mm.plugin.game.model.r;
import com.tencent.mm.sdk.platformtools.ac;

public final class d
  implements c, com.tencent.mm.plugin.game.api.d
{
  private b sVb;
  private r sVc;
  
  public final b cOk()
  {
    AppMethodBeat.i(40843);
    g.agP().afT();
    if (this.sVb == null) {
      this.sVb = new b();
    }
    b localb = this.sVb;
    AppMethodBeat.o(40843);
    return localb;
  }
  
  public final r cOl()
  {
    AppMethodBeat.i(40845);
    g.agP().afT();
    if (this.sVc == null) {
      this.sVc = new r();
    }
    r localr = this.sVc;
    AppMethodBeat.o(40845);
    return localr;
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(40841);
    ac.i("MicroMsg.GameService", "GameService onAccountInitialized");
    this.sVb = new b();
    this.sVc = new r();
    AppMethodBeat.o(40841);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(40842);
    ac.i("MicroMsg.GameService", "GameService onAccountRelease");
    AppMethodBeat.o(40842);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d
 * JD-Core Version:    0.7.0.1
 */