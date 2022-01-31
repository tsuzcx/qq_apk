package com.tencent.mm.plugin.fts.ui.d;

import android.content.Context;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.c.e;
import com.tencent.mm.plugin.fts.a.d.e.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.a.f;
import com.tencent.mm.plugin.fts.ui.a.k;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.HashSet;
import java.util.List;

public final class g
  extends l
{
  public String kwY;
  public int showType;
  public String talker;
  
  public g(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
  }
  
  protected final com.tencent.mm.plugin.fts.a.a.a a(ah paramah, HashSet<String> paramHashSet)
  {
    this.kEo = false;
    paramHashSet = new i();
    paramHashSet.bVk = this.bVk;
    paramHashSet.kxe = e.kxH;
    paramHashSet.kwY = this.kwY;
    paramHashSet.kwZ = this.kwZ;
    paramHashSet.talker = this.talker;
    paramHashSet.kxf = this;
    paramHashSet.handler = paramah;
    paramHashSet.kwX = 11;
    return ((n)com.tencent.mm.kernel.g.t(n.class)).search(3, paramHashSet);
  }
  
  protected final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    Object localObject2 = null;
    if (parama.kxL) {}
    for (int i = paramInt - parama.kxK - 1;; i = paramInt - parama.kxK)
    {
      localObject1 = localObject2;
      if (i >= 0)
      {
        localObject1 = localObject2;
        if (i < parama.kxO.size())
        {
          parama = (com.tencent.mm.plugin.fts.a.a.l)parama.kxO.get(i);
          if (!parama.kwg.equals("no_result​")) {
            break;
          }
          localObject1 = new com.tencent.mm.plugin.fts.ui.a.l(paramInt);
        }
      }
      return localObject1;
    }
    Object localObject1 = new com.tencent.mm.plugin.fts.ui.a.g(paramInt);
    ((com.tencent.mm.plugin.fts.ui.a.g)localObject1).fYx = parama;
    ((com.tencent.mm.plugin.fts.ui.a.g)localObject1).kwi = ((com.tencent.mm.plugin.fts.ui.a.g)localObject1).fYx.kwi;
    ((com.tencent.mm.plugin.fts.ui.a.g)localObject1).cU(parama.type, parama.kwf);
    return localObject1;
  }
  
  public final int aWv()
  {
    return this.showType;
  }
  
  protected final k b(int paramInt, e.a parama)
  {
    f localf = new f(paramInt);
    localf.kCT = parama.kxQ;
    localf.kwY = this.kwY;
    return localf;
  }
  
  public final int getType()
  {
    return 192;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.d.g
 * JD-Core Version:    0.7.0.1
 */