package com.tencent.mm.plugin.favorite;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.g.a.gg;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.b.a;
import java.util.HashMap;

public final class f
  implements at
{
  private com.tencent.mm.sdk.b.c mEH;
  
  public f()
  {
    AppMethodBeat.i(20537);
    this.mEH = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(20537);
  }
  
  public final void clearPluginData(int paramInt) {}
  
  public final HashMap<Integer, h.d> getBaseDBFactories()
  {
    return null;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(20538);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.Fav.SubCoreFav", "onAccountPostReset updated:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    a.ymk.b(this.mEH);
    g.b(y.class, new c());
    g.b(com.tencent.mm.plugin.fav.a.ab.class, new e());
    AppMethodBeat.o(20538);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(20539);
    a.ymk.d(this.mEH);
    ((n)g.G(n.class)).unregisterFTSUILogic(128);
    ((n)g.G(n.class)).unregisterFTSUILogic(4192);
    AppMethodBeat.o(20539);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.favorite.f
 * JD-Core Version:    0.7.0.1
 */