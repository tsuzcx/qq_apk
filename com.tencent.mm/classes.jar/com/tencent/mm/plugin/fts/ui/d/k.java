package com.tencent.mm.plugin.fts.ui.d;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.c;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.d.e.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.a.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.HashSet;
import java.util.List;

public class k
  extends com.tencent.mm.plugin.fts.ui.a
{
  protected boolean tCT = false;
  
  public k(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
  }
  
  public com.tencent.mm.plugin.fts.a.a.a a(ap paramap, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112203);
    this.tCT = false;
    j localj = new j();
    localj.query = this.query;
    localj.tvh = paramHashSet;
    localj.tvj = this;
    localj.handler = paramap;
    localj.jQN = 1;
    localj.tvg = 3;
    paramap = ((n)com.tencent.mm.kernel.g.ad(n.class)).search(3, localj);
    AppMethodBeat.o(112203);
    return paramap;
  }
  
  public com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112205);
    int i = paramInt - parama.tvN;
    if (parama.tvO) {
      i -= 1;
    }
    for (;;)
    {
      com.tencent.mm.plugin.fts.a.a.m localm = null;
      Object localObject = localm;
      boolean bool;
      if (i < parama.lKC.size())
      {
        localObject = localm;
        if (i >= 0)
        {
          localm = (com.tencent.mm.plugin.fts.a.a.m)parama.lKC.get(i);
          if (!localm.tuh.equals("create_talker_message​")) {
            break label174;
          }
          localObject = new i(paramInt);
          if (parama.lKC.size() != 1) {
            break label168;
          }
          bool = true;
          ((i)localObject).tBn = bool;
          this.tCT = true;
        }
      }
      for (;;)
      {
        if (localObject != null)
        {
          ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).tvW = (i + 1);
          ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).tun = parama.tun;
          if (i == parama.lKC.size() - 1) {
            ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).tvU = false;
          }
        }
        AppMethodBeat.o(112205);
        return localObject;
        label168:
        bool = false;
        break;
        label174:
        localObject = new com.tencent.mm.plugin.fts.ui.a.m(paramInt);
        ((com.tencent.mm.plugin.fts.ui.a.m)localObject).kjY = localm;
        ((com.tencent.mm.plugin.fts.ui.a.m)localObject).gf(localm.type, localm.tug);
      }
    }
  }
  
  public void a(com.tencent.mm.plugin.fts.a.a.k paramk, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112204);
    if (dT(paramk.tvl))
    {
      paramHashSet = new e.a();
      paramHashSet.businessType = -2;
      paramHashSet.tun = paramk.tun;
      paramHashSet.lKC = paramk.tvl;
      if (paramHashSet.lKC.size() <= 3) {
        break label142;
      }
      if (!((com.tencent.mm.plugin.fts.a.a.m)paramk.tvl.get(3)).tuh.equals("create_talker_message​")) {
        break label119;
      }
      paramHashSet.rKf = false;
      paramHashSet.lKC = paramHashSet.lKC.subList(0, 4);
    }
    for (;;)
    {
      this.txY.add(paramHashSet);
      AppMethodBeat.o(112204);
      return;
      label119:
      paramHashSet.rKf = true;
      paramHashSet.lKC = paramHashSet.lKC.subList(0, 3);
      continue;
      label142:
      if ((paramk.tvl.size() == 1) && (((com.tencent.mm.plugin.fts.a.a.m)paramk.tvl.get(0)).tuh.equals("create_talker_message​"))) {
        paramHashSet.tvO = false;
      }
    }
  }
  
  public boolean a(View paramView, com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(112206);
    int i;
    if ((parama instanceof com.tencent.mm.plugin.fts.ui.a.m))
    {
      i = cTS();
      paramBoolean = this.tCT;
      if (parama.twa != 65536) {}
    }
    label85:
    int k;
    switch (parama.pageType)
    {
    default: 
      AppMethodBeat.o(112206);
      return false;
    case 1: 
    case 2: 
    case 3: 
    case 4: 
      i = parama.pageType;
      k = parama.cSY();
      if (!paramBoolean) {
        break;
      }
    }
    for (int j = 1;; j = 0)
    {
      paramView = String.format("%s,%s,%s", new Object[] { Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(j) });
      ad.v("MicroMsg.FTS.FTSReportLogic", "reportFTSGlobalMsgResultClick: %d, %s", new Object[] { Integer.valueOf(14756), paramView });
      com.tencent.mm.plugin.report.service.g.yhR.kvStat(14756, paramView);
      break;
      if (i == 1)
      {
        i = 6;
        break label85;
      }
      if (i != 2) {
        break;
      }
      i = 5;
      break label85;
    }
  }
  
  public final c b(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112207);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt < parama.lKC.size())
    {
      localObject1 = localObject2;
      if (paramInt >= 0)
      {
        localObject1 = (com.tencent.mm.plugin.fts.a.a.m)parama.lKC.get(paramInt);
        parama = new c();
        parama.dBg = String.valueOf(localObject1.hashCode());
        if (!((com.tencent.mm.plugin.fts.a.a.m)localObject1).tuh.equals("create_talker_message​")) {
          break label91;
        }
        parama.dBr = 22;
      }
    }
    for (localObject1 = parama;; localObject1 = parama)
    {
      AppMethodBeat.o(112207);
      return localObject1;
      label91:
      parama.dBr = 11;
    }
  }
  
  protected int cTS()
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