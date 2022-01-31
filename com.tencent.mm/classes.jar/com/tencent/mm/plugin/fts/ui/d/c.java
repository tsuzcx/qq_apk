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

public final class c
  extends com.tencent.mm.plugin.fts.ui.a
{
  public c(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
  }
  
  protected final com.tencent.mm.plugin.fts.a.a.a a(ah paramah, HashSet<String> paramHashSet)
  {
    i locali = new i();
    locali.kwX = 96;
    locali.kxc = 3;
    locali.bVk = this.bVk;
    locali.kxd = paramHashSet;
    locali.kxe = com.tencent.mm.plugin.fts.a.c.a.kxD;
    locali.kxf = this;
    locali.handler = paramah;
    return ((n)g.t(n.class)).search(2, locali);
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt1, int paramInt2, l paraml, e.a parama)
  {
    q localq = new q(paramInt2);
    localq.fYx = paraml;
    localq.kwi = parama.kwi;
    localq.cU(paraml.type, paraml.kwf);
    return localq;
  }
  
  protected final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    int i = paramInt - parama.kxK - 1;
    Object localObject;
    if ((i < parama.kxO.size()) && (i >= 0))
    {
      localObject = (l)parama.kxO.get(i);
      if (((l)localObject).kwg.equals("create_chatroom​"))
      {
        localObject = new h(paramInt);
        ((h)localObject).kwi = parama.kwi;
        parama = (e.a)localObject;
      }
    }
    for (;;)
    {
      if (parama != null) {
        parama.kxW = (i + 1);
      }
      return parama;
      if (((l)localObject).type == 131075)
      {
        parama = a(131075, paramInt, (l)localObject, parama);
        parama.cU(((l)localObject).type, ((l)localObject).kwf);
      }
      else
      {
        parama = null;
      }
    }
  }
  
  protected final void a(j paramj, HashSet<String> paramHashSet)
  {
    boolean bool;
    if (bA(paramj.kxh))
    {
      paramHashSet = new e.a();
      paramHashSet.kxO = paramj.kxh;
      paramHashSet.businessType = -3;
      paramHashSet.kwi = paramj.kwi;
      if (paramHashSet.kxO.size() > 3)
      {
        if (!((l)paramHashSet.kxO.get(3)).kwg.equals("create_chatroom​")) {
          break label129;
        }
        if (paramHashSet.kxO.size() <= 4) {
          break label124;
        }
        bool = true;
        paramHashSet.kxN = bool;
      }
    }
    for (paramHashSet.kxO = paramHashSet.kxO.subList(0, 4);; paramHashSet.kxO = paramHashSet.kxO.subList(0, 3))
    {
      this.kzW.add(paramHashSet);
      return;
      label124:
      bool = false;
      break;
      label129:
      paramHashSet.kxN = true;
    }
  }
  
  public final int getType()
  {
    return 48;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.d.c
 * JD-Core Version:    0.7.0.1
 */