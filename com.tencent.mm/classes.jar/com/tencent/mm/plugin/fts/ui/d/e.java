package com.tencent.mm.plugin.fts.ui.d;

import android.content.Context;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.d.e.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.a.r;
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
    locali.kwX = 64;
    locali.bVk = this.bVk;
    locali.kxa = new int[] { 131072, 131081 };
    locali.kxc = 3;
    locali.kxe = com.tencent.mm.plugin.fts.a.c.b.kxE;
    locali.kxd = paramHashSet;
    locali.kxf = this;
    locali.handler = paramah;
    return ((n)g.t(n.class)).search(2, locali);
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt1, int paramInt2, l paraml, e.a parama)
  {
    r localr = null;
    if ((paraml.type == 131072) || (paraml.type == 131081))
    {
      localr = new r(paramInt2);
      localr.fYx = paraml;
      localr.kwi = parama.kwi;
      localr.cU(paraml.type, paraml.kwf);
    }
    while ((paraml.type != 131073) && (paraml.type != 131074)) {
      return localr;
    }
    return ((com.tencent.mm.plugin.fts.ui.a)((n)g.t(n.class)).createFTSUIUnit(33, this.context, this.kxI, this.kxJ)).a(paramInt1, paramInt2, paraml, parama);
  }
  
  protected final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    Object localObject = null;
    l locall = null;
    int i = 0;
    if (parama.kxL)
    {
      i = paramInt - parama.kxK - 1;
      localObject = locall;
      if (i < parama.kxO.size())
      {
        localObject = locall;
        if (i >= 0)
        {
          locall = (l)parama.kxO.get(i);
          parama = a(locall.type, paramInt, locall, parama);
          localObject = parama;
          if (parama != null)
          {
            parama.cU(locall.type, locall.kwf);
            localObject = parama;
          }
        }
      }
    }
    if (localObject != null) {
      ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).kxW = (i + 1);
    }
    return localObject;
  }
  
  protected final void a(j paramj, HashSet<String> paramHashSet)
  {
    paramHashSet = new e.a();
    paramHashSet.businessType = -4;
    paramHashSet.kxO = paramj.kxh;
    paramHashSet.kxL = bA(paramj.kxh);
    paramHashSet.kwi = paramj.kwi;
    if (paramHashSet.kxO.size() > 3)
    {
      paramHashSet.kxN = true;
      paramHashSet.kxO = paramHashSet.kxO.subList(0, 3);
    }
    if (bA(paramj.kxh)) {
      this.kzW.add(paramHashSet);
    }
  }
  
  public final int getType()
  {
    return 32;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.d.e
 * JD-Core Version:    0.7.0.1
 */