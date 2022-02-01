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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import java.util.HashSet;
import java.util.List;

public class k
  extends com.tencent.mm.plugin.fts.ui.a
{
  protected boolean sFZ = false;
  
  public k(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
  }
  
  public com.tencent.mm.plugin.fts.a.a.a a(ao paramao, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112203);
    this.sFZ = false;
    j localj = new j();
    localj.query = this.query;
    localj.syG = paramHashSet;
    localj.syI = this;
    localj.handler = paramao;
    localj.jwR = 1;
    localj.syF = 3;
    paramao = ((n)g.ad(n.class)).search(3, localj);
    AppMethodBeat.o(112203);
    return paramao;
  }
  
  public com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112205);
    int i = paramInt - parama.szm;
    if (parama.szn) {
      i -= 1;
    }
    for (;;)
    {
      com.tencent.mm.plugin.fts.a.a.m localm = null;
      Object localObject = localm;
      boolean bool;
      if (i < parama.lnk.size())
      {
        localObject = localm;
        if (i >= 0)
        {
          localm = (com.tencent.mm.plugin.fts.a.a.m)parama.lnk.get(i);
          if (!localm.sxG.equals("create_talker_message​")) {
            break label174;
          }
          localObject = new i(paramInt);
          if (parama.lnk.size() != 1) {
            break label168;
          }
          bool = true;
          ((i)localObject).sEw = bool;
          this.sFZ = true;
        }
      }
      for (;;)
      {
        if (localObject != null)
        {
          ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).szv = (i + 1);
          ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).sxM = parama.sxM;
          if (i == parama.lnk.size() - 1) {
            ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).szt = false;
          }
        }
        AppMethodBeat.o(112205);
        return localObject;
        label168:
        bool = false;
        break;
        label174:
        localObject = new com.tencent.mm.plugin.fts.ui.a.m(paramInt);
        ((com.tencent.mm.plugin.fts.ui.a.m)localObject).jPN = localm;
        ((com.tencent.mm.plugin.fts.ui.a.m)localObject).fP(localm.type, localm.sxF);
      }
    }
  }
  
  public void a(com.tencent.mm.plugin.fts.a.a.k paramk, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112204);
    if (dJ(paramk.syK))
    {
      paramHashSet = new e.a();
      paramHashSet.businessType = -2;
      paramHashSet.sxM = paramk.sxM;
      paramHashSet.lnk = paramk.syK;
      if (paramHashSet.lnk.size() <= 3) {
        break label142;
      }
      if (!((com.tencent.mm.plugin.fts.a.a.m)paramk.syK.get(3)).sxG.equals("create_talker_message​")) {
        break label119;
      }
      paramHashSet.qYO = false;
      paramHashSet.lnk = paramHashSet.lnk.subList(0, 4);
    }
    for (;;)
    {
      this.sBx.add(paramHashSet);
      AppMethodBeat.o(112204);
      return;
      label119:
      paramHashSet.qYO = true;
      paramHashSet.lnk = paramHashSet.lnk.subList(0, 3);
      continue;
      label142:
      if ((paramk.syK.size() == 1) && (((com.tencent.mm.plugin.fts.a.a.m)paramk.syK.get(0)).sxG.equals("create_talker_message​"))) {
        paramHashSet.szn = false;
      }
    }
  }
  
  public boolean a(View paramView, com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(112206);
    int i;
    if ((parama instanceof com.tencent.mm.plugin.fts.ui.a.m))
    {
      i = cLz();
      paramBoolean = this.sFZ;
      if (parama.szz != 65536) {}
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
      k = parama.cKJ();
      if (!paramBoolean) {
        break;
      }
    }
    for (int j = 1;; j = 0)
    {
      paramView = String.format("%s,%s,%s", new Object[] { Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(j) });
      ac.v("MicroMsg.FTS.FTSReportLogic", "reportFTSGlobalMsgResultClick: %d, %s", new Object[] { Integer.valueOf(14756), paramView });
      h.wUl.kvStat(14756, paramView);
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
    if (paramInt < parama.lnk.size())
    {
      localObject1 = localObject2;
      if (paramInt >= 0)
      {
        localObject1 = (com.tencent.mm.plugin.fts.a.a.m)parama.lnk.get(paramInt);
        parama = new c();
        parama.dpt = String.valueOf(localObject1.hashCode());
        if (!((com.tencent.mm.plugin.fts.a.a.m)localObject1).sxG.equals("create_talker_message​")) {
          break label91;
        }
        parama.dpE = 22;
      }
    }
    for (localObject1 = parama;; localObject1 = parama)
    {
      AppMethodBeat.o(112207);
      return localObject1;
      label91:
      parama.dpE = 11;
    }
  }
  
  protected int cLz()
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