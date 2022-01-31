package com.tencent.mm.plugin.fts.ui.d;

import android.content.Context;
import android.view.View;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.d.e.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.a.m;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashSet;
import java.util.List;

public class k
  extends com.tencent.mm.plugin.fts.ui.a
{
  protected boolean kEo = false;
  
  public k(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
  }
  
  protected com.tencent.mm.plugin.fts.a.a.a a(ah paramah, HashSet<String> paramHashSet)
  {
    this.kEo = false;
    com.tencent.mm.plugin.fts.a.a.i locali = new com.tencent.mm.plugin.fts.a.a.i();
    locali.bVk = this.bVk;
    locali.kxd = paramHashSet;
    locali.kxf = this;
    locali.handler = paramah;
    locali.kwX = 1;
    locali.kxc = 3;
    return ((n)g.t(n.class)).search(3, locali);
  }
  
  protected com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    int i = paramInt - parama.kxK;
    if (parama.kxL) {
      i -= 1;
    }
    for (;;)
    {
      l locall = null;
      Object localObject = locall;
      boolean bool;
      if (i < parama.kxO.size())
      {
        localObject = locall;
        if (i >= 0)
        {
          locall = (l)parama.kxO.get(i);
          if (!locall.kwg.equals("create_talker_message​")) {
            break label143;
          }
          localObject = new com.tencent.mm.plugin.fts.ui.a.i(paramInt);
          if (parama.kxO.size() != 1) {
            break label137;
          }
          bool = true;
          ((com.tencent.mm.plugin.fts.ui.a.i)localObject).kDj = bool;
          this.kEo = true;
        }
      }
      for (;;)
      {
        if (localObject != null)
        {
          ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).kxW = (i + 1);
          ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).kwi = parama.kwi;
        }
        return localObject;
        label137:
        bool = false;
        break;
        label143:
        localObject = new m(paramInt);
        ((m)localObject).fYx = locall;
        ((m)localObject).cU(locall.type, locall.kwf);
      }
    }
  }
  
  protected void a(j paramj, HashSet<String> paramHashSet)
  {
    if (bA(paramj.kxh))
    {
      paramHashSet = new e.a();
      paramHashSet.businessType = -2;
      paramHashSet.kwi = paramj.kwi;
      paramHashSet.kxO = paramj.kxh;
      if (paramHashSet.kxO.size() <= 3) {
        break label132;
      }
      if (!((l)paramj.kxh.get(3)).kwg.equals("create_talker_message​")) {
        break label109;
      }
      paramHashSet.kxN = false;
      paramHashSet.kxO = paramHashSet.kxO.subList(0, 4);
    }
    for (;;)
    {
      this.kzW.add(paramHashSet);
      return;
      label109:
      paramHashSet.kxN = true;
      paramHashSet.kxO = paramHashSet.kxO.subList(0, 3);
      continue;
      label132:
      if ((paramj.kxh.size() == 1) && (((l)paramj.kxh.get(0)).kwg.equals("create_talker_message​"))) {
        paramHashSet.kxL = false;
      }
    }
  }
  
  public boolean a(View paramView, com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean)
  {
    int i;
    if ((parama instanceof m))
    {
      i = aWv();
      paramBoolean = this.kEo;
      if (parama.kya != 65536) {}
    }
    label72:
    int k;
    switch (parama.pageType)
    {
    default: 
      return false;
    case 1: 
    case 2: 
    case 3: 
    case 4: 
      i = parama.pageType;
      k = parama.aVH();
      if (!paramBoolean) {
        break;
      }
    }
    for (int j = 1;; j = 0)
    {
      paramView = String.format("%s,%s,%s", new Object[] { Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(j) });
      y.v("MicroMsg.FTS.FTSReportLogic", "reportFTSGlobalMsgResultClick: %d, %s", new Object[] { Integer.valueOf(14756), paramView });
      h.nFQ.aC(14756, paramView);
      return false;
      if (i == 1)
      {
        i = 6;
        break label72;
      }
      if (i != 2) {
        break;
      }
      i = 5;
      break label72;
    }
  }
  
  protected int aWv()
  {
    return 0;
  }
  
  public int getType()
  {
    return 112;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.d.k
 * JD-Core Version:    0.7.0.1
 */