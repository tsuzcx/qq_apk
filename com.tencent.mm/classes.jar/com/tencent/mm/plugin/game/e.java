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
  private com.tencent.mm.plugin.game.model.b HSt;
  private r HSu;
  
  public final com.tencent.mm.plugin.game.model.b fCf()
  {
    AppMethodBeat.i(40843);
    h.baC().aZJ();
    if (this.HSt == null) {
      this.HSt = new com.tencent.mm.plugin.game.model.b();
    }
    com.tencent.mm.plugin.game.model.b localb = this.HSt;
    AppMethodBeat.o(40843);
    return localb;
  }
  
  public final r fCg()
  {
    AppMethodBeat.i(40845);
    h.baC().aZJ();
    if (this.HSu == null) {
      this.HSu = new r();
    }
    r localr = this.HSu;
    AppMethodBeat.o(40845);
    return localr;
  }
  
  public final void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(40841);
    Log.i("MicroMsg.GameService", "GameService onAccountInitialized");
    this.HSt = new com.tencent.mm.plugin.game.model.b();
    this.HSu = new r();
    AppMethodBeat.o(40841);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(40842);
    Log.i("MicroMsg.GameService", "GameService onAccountRelease");
    AppMethodBeat.o(40842);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.e
 * JD-Core Version:    0.7.0.1
 */