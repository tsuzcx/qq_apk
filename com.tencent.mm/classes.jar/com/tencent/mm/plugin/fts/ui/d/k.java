package com.tencent.mm.plugin.fts.ui.d;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.c;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.d.e.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.a.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.HashSet;
import java.util.List;

public class k
  extends com.tencent.mm.plugin.fts.ui.a
{
  protected boolean rxh = false;
  
  public k(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
  }
  
  public com.tencent.mm.plugin.fts.a.a.a a(ap paramap, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112203);
    this.rxh = false;
    j localj = new j();
    localj.query = this.query;
    localj.rpM = paramHashSet;
    localj.rpO = this;
    localj.handler = paramap;
    localj.iWB = 1;
    localj.rpL = 3;
    paramap = ((n)g.ad(n.class)).search(3, localj);
    AppMethodBeat.o(112203);
    return paramap;
  }
  
  public com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112205);
    int i = paramInt - parama.rqs;
    if (parama.rqt) {
      i -= 1;
    }
    for (;;)
    {
      com.tencent.mm.plugin.fts.a.a.m localm = null;
      Object localObject = localm;
      boolean bool;
      if (i < parama.kLN.size())
      {
        localObject = localm;
        if (i >= 0)
        {
          localm = (com.tencent.mm.plugin.fts.a.a.m)parama.kLN.get(i);
          if (!localm.roN.equals("create_talker_message​")) {
            break label174;
          }
          localObject = new i(paramInt);
          if (parama.kLN.size() != 1) {
            break label168;
          }
          bool = true;
          ((i)localObject).rvE = bool;
          this.rxh = true;
        }
      }
      for (;;)
      {
        if (localObject != null)
        {
          ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).rqB = (i + 1);
          ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).roS = parama.roS;
          if (i == parama.kLN.size() - 1) {
            ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).rqz = false;
          }
        }
        AppMethodBeat.o(112205);
        return localObject;
        label168:
        bool = false;
        break;
        label174:
        localObject = new com.tencent.mm.plugin.fts.ui.a.m(paramInt);
        ((com.tencent.mm.plugin.fts.ui.a.m)localObject).jpy = localm;
        ((com.tencent.mm.plugin.fts.ui.a.m)localObject).fI(localm.type, localm.roM);
      }
    }
  }
  
  public void a(com.tencent.mm.plugin.fts.a.a.k paramk, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112204);
    if (dF(paramk.rpQ))
    {
      paramHashSet = new e.a();
      paramHashSet.businessType = -2;
      paramHashSet.roS = paramk.roS;
      paramHashSet.kLN = paramk.rpQ;
      if (paramHashSet.kLN.size() <= 3) {
        break label142;
      }
      if (!((com.tencent.mm.plugin.fts.a.a.m)paramk.rpQ.get(3)).roN.equals("create_talker_message​")) {
        break label119;
      }
      paramHashSet.qpI = false;
      paramHashSet.kLN = paramHashSet.kLN.subList(0, 4);
    }
    for (;;)
    {
      this.rsD.add(paramHashSet);
      AppMethodBeat.o(112204);
      return;
      label119:
      paramHashSet.qpI = true;
      paramHashSet.kLN = paramHashSet.kLN.subList(0, 3);
      continue;
      label142:
      if ((paramk.rpQ.size() == 1) && (((com.tencent.mm.plugin.fts.a.a.m)paramk.rpQ.get(0)).roN.equals("create_talker_message​"))) {
        paramHashSet.rqt = false;
      }
    }
  }
  
  public boolean a(View paramView, com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(112206);
    int i;
    if ((parama instanceof com.tencent.mm.plugin.fts.ui.a.m))
    {
      i = cyn();
      paramBoolean = this.rxh;
      if (parama.rqF != 65536) {}
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
      k = parama.cxx();
      if (!paramBoolean) {
        break;
      }
    }
    for (int j = 1;; j = 0)
    {
      paramView = String.format("%s,%s,%s", new Object[] { Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(j) });
      ad.v("MicroMsg.FTS.FTSReportLogic", "reportFTSGlobalMsgResultClick: %d, %s", new Object[] { Integer.valueOf(14756), paramView });
      h.vKh.kvStat(14756, paramView);
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
    if (paramInt < parama.kLN.size())
    {
      localObject1 = localObject2;
      if (paramInt >= 0)
      {
        localObject1 = (com.tencent.mm.plugin.fts.a.a.m)parama.kLN.get(paramInt);
        parama = new c();
        parama.drI = String.valueOf(localObject1.hashCode());
        if (!((com.tencent.mm.plugin.fts.a.a.m)localObject1).roN.equals("create_talker_message​")) {
          break label91;
        }
        parama.drT = 22;
      }
    }
    for (localObject1 = parama;; localObject1 = parama)
    {
      AppMethodBeat.o(112207);
      return localObject1;
      label91:
      parama.drT = 11;
    }
  }
  
  protected int cyn()
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