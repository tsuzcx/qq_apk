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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import java.util.HashSet;
import java.util.List;

public class k
  extends com.tencent.mm.plugin.fts.ui.a
{
  protected boolean tNK = false;
  
  public k(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
  }
  
  public com.tencent.mm.plugin.fts.a.a.a a(aq paramaq, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112203);
    this.tNK = false;
    j localj = new j();
    localj.query = this.query;
    localj.tFY = paramHashSet;
    localj.tGa = this;
    localj.handler = paramaq;
    localj.jUf = 1;
    localj.tFX = 3;
    paramaq = ((n)com.tencent.mm.kernel.g.ad(n.class)).search(3, localj);
    AppMethodBeat.o(112203);
    return paramaq;
  }
  
  public com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112205);
    int i = paramInt - parama.tGE;
    if (parama.tGF) {
      i -= 1;
    }
    for (;;)
    {
      com.tencent.mm.plugin.fts.a.a.m localm = null;
      Object localObject = localm;
      boolean bool;
      if (i < parama.lPc.size())
      {
        localObject = localm;
        if (i >= 0)
        {
          localm = (com.tencent.mm.plugin.fts.a.a.m)parama.lPc.get(i);
          if (!localm.tEY.equals("create_talker_message​")) {
            break label174;
          }
          localObject = new i(paramInt);
          if (parama.lPc.size() != 1) {
            break label168;
          }
          bool = true;
          ((i)localObject).tMe = bool;
          this.tNK = true;
        }
      }
      for (;;)
      {
        if (localObject != null)
        {
          ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).tGN = (i + 1);
          ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).tFe = parama.tFe;
          if (i == parama.lPc.size() - 1) {
            ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).tGL = false;
          }
        }
        AppMethodBeat.o(112205);
        return localObject;
        label168:
        bool = false;
        break;
        label174:
        localObject = new com.tencent.mm.plugin.fts.ui.a.m(paramInt);
        ((com.tencent.mm.plugin.fts.ui.a.m)localObject).kno = localm;
        ((com.tencent.mm.plugin.fts.ui.a.m)localObject).gf(localm.type, localm.tEX);
      }
    }
  }
  
  public void a(com.tencent.mm.plugin.fts.a.a.k paramk, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112204);
    if (dX(paramk.tGc))
    {
      paramHashSet = new e.a();
      paramHashSet.businessType = -2;
      paramHashSet.tFe = paramk.tFe;
      paramHashSet.lPc = paramk.tGc;
      if (paramHashSet.lPc.size() <= 3) {
        break label142;
      }
      if (!((com.tencent.mm.plugin.fts.a.a.m)paramk.tGc.get(3)).tEY.equals("create_talker_message​")) {
        break label119;
      }
      paramHashSet.rRg = false;
      paramHashSet.lPc = paramHashSet.lPc.subList(0, 4);
    }
    for (;;)
    {
      this.tIP.add(paramHashSet);
      AppMethodBeat.o(112204);
      return;
      label119:
      paramHashSet.rRg = true;
      paramHashSet.lPc = paramHashSet.lPc.subList(0, 3);
      continue;
      label142:
      if ((paramk.tGc.size() == 1) && (((com.tencent.mm.plugin.fts.a.a.m)paramk.tGc.get(0)).tEY.equals("create_talker_message​"))) {
        paramHashSet.tGF = false;
      }
    }
  }
  
  public boolean a(View paramView, com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(112206);
    int i;
    if ((parama instanceof com.tencent.mm.plugin.fts.ui.a.m))
    {
      i = cWx();
      paramBoolean = this.tNK;
      if (parama.tGR != 65536) {}
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
      k = parama.cVD();
      if (!paramBoolean) {
        break;
      }
    }
    for (int j = 1;; j = 0)
    {
      paramView = String.format("%s,%s,%s", new Object[] { Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(j) });
      ae.v("MicroMsg.FTS.FTSReportLogic", "reportFTSGlobalMsgResultClick: %d, %s", new Object[] { Integer.valueOf(14756), paramView });
      com.tencent.mm.plugin.report.service.g.yxI.kvStat(14756, paramView);
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
    if (paramInt < parama.lPc.size())
    {
      localObject1 = localObject2;
      if (paramInt >= 0)
      {
        localObject1 = (com.tencent.mm.plugin.fts.a.a.m)parama.lPc.get(paramInt);
        parama = new c();
        parama.dCl = String.valueOf(localObject1.hashCode());
        if (!((com.tencent.mm.plugin.fts.a.a.m)localObject1).tEY.equals("create_talker_message​")) {
          break label91;
        }
        parama.dCw = 22;
      }
    }
    for (localObject1 = parama;; localObject1 = parama)
    {
      AppMethodBeat.o(112207);
      return localObject1;
      label91:
      parama.dCw = 11;
    }
  }
  
  protected int cWx()
  {
    return 0;
  }
  
  public int getType()
  {
    return 112;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.d.k
 * JD-Core Version:    0.7.0.1
 */