package com.tencent.mm.plugin.fts.ui.d;

import android.content.Context;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.d.e.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.a.h;
import com.tencent.mm.plugin.fts.ui.a.q;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.HashSet;
import java.util.List;

public final class b
  extends com.tencent.mm.plugin.fts.ui.a
{
  public b(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
  }
  
  protected final com.tencent.mm.plugin.fts.a.a.a a(ah paramah, HashSet<String> paramHashSet)
  {
    i locali = new i();
    locali.kwX = 32;
    locali.bVk = this.bVk;
    locali.kxd = paramHashSet;
    locali.kxe = com.tencent.mm.plugin.fts.a.c.a.kxD;
    locali.kxf = this;
    locali.handler = paramah;
    return ((n)g.t(n.class)).search(2, locali);
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
        if (!locall.kwg.equals("create_chatroom​")) {
          break label100;
        }
        localObject = new h(paramInt);
        ((h)localObject).kwi = parama.kwi;
      }
    }
    for (;;)
    {
      if (localObject != null) {
        ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).kxW = (i + 1);
      }
      return localObject;
      label100:
      localObject = new q(paramInt);
      ((q)localObject).fYx = locall;
      ((q)localObject).kwi = parama.kwi;
      ((q)localObject).cU(locall.type, locall.kwf);
    }
  }
  
  protected final void a(j paramj, HashSet<String> paramHashSet)
  {
    if (bA(paramj.kxh))
    {
      paramHashSet = new e.a();
      paramHashSet.businessType = -3;
      paramHashSet.kxO = paramj.kxh;
      paramHashSet.kwi = paramj.kwi;
      paramHashSet.kxN = false;
      this.kzW.add(paramHashSet);
    }
  }
  
  public final int getType()
  {
    return 4128;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.d.b
 * JD-Core Version:    0.7.0.1
 */