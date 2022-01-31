package com.tencent.mm.plugin.game;

import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.a.b;
import com.tencent.mm.plugin.game.model.r;
import com.tencent.mm.plugin.game.model.u;
import com.tencent.mm.sdk.platformtools.y;

public final class d
  implements com.tencent.mm.kernel.api.bucket.c, b
{
  private com.tencent.mm.plugin.game.model.c kLM;
  private u kLN;
  private r kLO;
  
  public final com.tencent.mm.plugin.game.model.c aYc()
  {
    g.DN().CX();
    if (this.kLM == null) {
      this.kLM = new com.tencent.mm.plugin.game.model.c();
    }
    return this.kLM;
  }
  
  public final u aYd()
  {
    g.DN().CX();
    if (this.kLN == null) {
      this.kLN = new u();
    }
    return this.kLN;
  }
  
  public final r aYe()
  {
    g.DN().CX();
    if (this.kLO == null) {
      this.kLO = new r();
    }
    return this.kLO;
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    y.i("MicroMsg.GameService", "GameService onAccountInitialized");
    this.kLM = new com.tencent.mm.plugin.game.model.c();
    this.kLN = new u();
    this.kLO = new r();
  }
  
  public final void onAccountRelease()
  {
    y.i("MicroMsg.GameService", "GameService onAccountRelease");
    if (this.kLN != null)
    {
      u localu = this.kLN;
      g.Dk().b(1223, localu);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d
 * JD-Core Version:    0.7.0.1
 */