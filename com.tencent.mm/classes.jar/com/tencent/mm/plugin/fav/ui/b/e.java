package com.tencent.mm.plugin.fav.ui.b;

import android.content.Context;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.d.e.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.HashSet;
import java.util.List;

public final class e
  extends com.tencent.mm.plugin.fts.ui.a
{
  public e(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
  }
  
  protected final com.tencent.mm.plugin.fts.a.a.a a(ah paramah, HashSet<String> paramHashSet)
  {
    i locali = new i();
    locali.kwX = 1;
    locali.bVk = this.bVk;
    locali.kxc = 1;
    locali.kxd = paramHashSet;
    locali.handler = paramah;
    locali.kxf = this;
    return ((n)g.t(n.class)).search(6, locali);
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
        localObject = new a(paramInt);
        ((a)localObject).fYx = locall;
        ((a)localObject).kwi = parama.kwi;
        ((a)localObject).cU(locall.type, locall.kwf);
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
      paramHashSet = new e.a();
      paramHashSet.businessType = -1;
      paramHashSet.kwi = paramj.kwi;
      paramHashSet.kxO = paramj.kxh;
      if (paramHashSet.kxO.size() > 1)
      {
        paramHashSet.kxN = true;
        paramHashSet.kxO = paramHashSet.kxO.subList(0, 1);
      }
      this.kzW.add(paramHashSet);
    }
  }
  
  public final int getType()
  {
    return 128;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.b.e
 * JD-Core Version:    0.7.0.1
 */