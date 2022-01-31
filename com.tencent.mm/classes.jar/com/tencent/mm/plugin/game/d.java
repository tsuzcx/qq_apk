package com.tencent.mm.plugin.game;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.model.b;
import com.tencent.mm.plugin.game.model.q;
import com.tencent.mm.plugin.game.model.t;
import com.tencent.mm.sdk.platformtools.ab;

public final class d
  implements c, com.tencent.mm.plugin.game.api.d
{
  private b niq;
  private t nir;
  private q nis;
  
  public final b bEP()
  {
    AppMethodBeat.i(111169);
    g.RJ().QQ();
    if (this.niq == null) {
      this.niq = new b();
    }
    b localb = this.niq;
    AppMethodBeat.o(111169);
    return localb;
  }
  
  public final t bEQ()
  {
    AppMethodBeat.i(111170);
    g.RJ().QQ();
    if (this.nir == null) {
      this.nir = new t();
    }
    t localt = this.nir;
    AppMethodBeat.o(111170);
    return localt;
  }
  
  public final q bER()
  {
    AppMethodBeat.i(111171);
    g.RJ().QQ();
    if (this.nis == null) {
      this.nis = new q();
    }
    q localq = this.nis;
    AppMethodBeat.o(111171);
    return localq;
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(111167);
    ab.i("MicroMsg.GameService", "GameService onAccountInitialized");
    this.niq = new b();
    this.nir = new t();
    this.nis = new q();
    AppMethodBeat.o(111167);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(111168);
    ab.i("MicroMsg.GameService", "GameService onAccountRelease");
    if (this.nir != null)
    {
      t localt = this.nir;
      g.Rc().b(1223, localt);
    }
    AppMethodBeat.o(111168);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d
 * JD-Core Version:    0.7.0.1
 */