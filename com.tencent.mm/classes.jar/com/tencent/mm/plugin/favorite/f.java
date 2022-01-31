package com.tencent.mm.plugin.favorite;

import com.tencent.mm.cf.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.plugin.fav.a.ab;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.b.a;
import java.util.HashMap;

public final class f
  implements ar
{
  private com.tencent.mm.sdk.b.c kkc = new f.1(this);
  
  public final void bh(boolean paramBoolean)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.Fav.SubCoreFav", "onAccountPostReset updated:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    a.udP.b(this.kkc);
    g.a(com.tencent.mm.plugin.fav.a.y.class, new c());
    g.a(ab.class, new e());
  }
  
  public final void bi(boolean paramBoolean) {}
  
  public final void gf(int paramInt) {}
  
  public final void onAccountRelease()
  {
    a.udP.d(this.kkc);
    ((n)g.t(n.class)).unregisterFTSUILogic(128);
    ((n)g.t(n.class)).unregisterFTSUILogic(4192);
  }
  
  public final HashMap<Integer, h.d> xe()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.favorite.f
 * JD-Core Version:    0.7.0.1
 */