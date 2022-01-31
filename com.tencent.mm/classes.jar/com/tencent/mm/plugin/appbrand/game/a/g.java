package com.tencent.mm.plugin.appbrand.game.a;

import android.content.Context;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.c.d;
import com.tencent.mm.plugin.fts.a.d.e.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class g
  extends com.tencent.mm.plugin.fts.ui.a
{
  public g(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
  }
  
  protected final com.tencent.mm.plugin.fts.a.a.a a(ah paramah, HashSet<String> paramHashSet)
  {
    i locali = new i();
    locali.bVk = this.bVk;
    locali.kxe = d.kxG;
    locali.kxf = this;
    locali.handler = paramah;
    locali.kxd = paramHashSet;
    locali.kxe = h.gaK;
    return ((n)com.tencent.mm.kernel.g.t(n.class)).search(10, locali);
  }
  
  protected final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    int i = paramInt - parama.kxK - 1;
    l locall = null;
    Object localObject = locall;
    if (i < parama.kxO.size())
    {
      localObject = locall;
      if (i >= 0)
      {
        locall = (l)parama.kxO.get(i);
        localObject = new c(paramInt);
        ((c)localObject).fYx = locall;
        ((c)localObject).kwi = parama.kwi;
        ((c)localObject).cU(locall.type, locall.kwf);
      }
    }
    if (localObject != null) {
      ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).kxW = (i + 1);
    }
    return localObject;
  }
  
  protected final void a(j paramj, HashSet<String> paramHashSet)
  {
    if (bA(paramj.kxh))
    {
      e.a locala = new e.a();
      locala.businessType = -15;
      locala.kxO = paramj.kxh;
      locala.kwi = paramj.kwi;
      paramj = paramj.kxh.iterator();
      while (paramj.hasNext()) {
        paramHashSet.add(((l)paramj.next()).kwg);
      }
      if (locala.kxO.size() > 3)
      {
        locala.kxN = true;
        locala.kxO = locala.kxO.subList(0, 3);
      }
      this.kzW.add(locala);
    }
  }
  
  public final int getType()
  {
    return 208;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.a.g
 * JD-Core Version:    0.7.0.1
 */