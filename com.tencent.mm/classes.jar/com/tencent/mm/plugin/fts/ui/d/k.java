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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.HashSet;
import java.util.List;

public class k
  extends com.tencent.mm.plugin.fts.ui.a
{
  protected boolean xeL = false;
  
  public k(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
  }
  
  public com.tencent.mm.plugin.fts.a.a.a a(MMHandler paramMMHandler, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112203);
    this.xeL = false;
    j localj = new j();
    localj.query = this.query;
    localj.wWX = paramHashSet;
    localj.wWZ = this;
    localj.handler = paramMMHandler;
    localj.kXb = 1;
    localj.wWW = 3;
    paramMMHandler = ((n)g.ah(n.class)).search(3, localj);
    AppMethodBeat.o(112203);
    return paramMMHandler;
  }
  
  public com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112205);
    int i = paramInt - parama.wXD;
    if (parama.wXE) {
      i -= 1;
    }
    for (;;)
    {
      com.tencent.mm.plugin.fts.a.a.m localm = null;
      Object localObject = localm;
      boolean bool;
      if (i < parama.mWl.size())
      {
        localObject = localm;
        if (i >= 0)
        {
          localm = (com.tencent.mm.plugin.fts.a.a.m)parama.mWl.get(i);
          if (!localm.wVX.equals("create_talker_message​")) {
            break label174;
          }
          localObject = new i(paramInt);
          if (parama.mWl.size() != 1) {
            break label168;
          }
          bool = true;
          ((i)localObject).xdf = bool;
          this.xeL = true;
        }
      }
      for (;;)
      {
        if (localObject != null)
        {
          ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).wXM = (i + 1);
          ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).wWd = parama.wWd;
          if (i == parama.mWl.size() - 1) {
            ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).wXK = false;
          }
        }
        AppMethodBeat.o(112205);
        return localObject;
        label168:
        bool = false;
        break;
        label174:
        localObject = new com.tencent.mm.plugin.fts.ui.a.m(paramInt);
        ((com.tencent.mm.plugin.fts.ui.a.m)localObject).lqW = localm;
        ((com.tencent.mm.plugin.fts.ui.a.m)localObject).gE(localm.type, localm.wVW);
      }
    }
  }
  
  public void a(com.tencent.mm.plugin.fts.a.a.k paramk, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112204);
    if (eP(paramk.wXb))
    {
      paramHashSet = new e.a();
      paramHashSet.businessType = -2;
      paramHashSet.wWd = paramk.wWd;
      paramHashSet.mWl = paramk.wXb;
      if (paramHashSet.mWl.size() <= 3) {
        break label142;
      }
      if (!((com.tencent.mm.plugin.fts.a.a.m)paramk.wXb.get(3)).wVX.equals("create_talker_message​")) {
        break label119;
      }
      paramHashSet.tuG = false;
      paramHashSet.mWl = paramHashSet.mWl.subList(0, 4);
    }
    for (;;)
    {
      this.wZO.add(paramHashSet);
      AppMethodBeat.o(112204);
      return;
      label119:
      paramHashSet.tuG = true;
      paramHashSet.mWl = paramHashSet.mWl.subList(0, 3);
      continue;
      label142:
      if ((paramk.wXb.size() == 1) && (((com.tencent.mm.plugin.fts.a.a.m)paramk.wXb.get(0)).wVX.equals("create_talker_message​"))) {
        paramHashSet.wXE = false;
      }
    }
  }
  
  public boolean a(View paramView, com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(112206);
    int i;
    if ((parama instanceof com.tencent.mm.plugin.fts.ui.a.m))
    {
      i = dPI();
      paramBoolean = this.xeL;
      if (parama.wXQ != 65536) {}
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
      k = parama.dOM();
      if (!paramBoolean) {
        break;
      }
    }
    for (int j = 1;; j = 0)
    {
      paramView = String.format("%s,%s,%s", new Object[] { Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(j) });
      Log.v("MicroMsg.FTS.FTSReportLogic", "reportFTSGlobalMsgResultClick: %d, %s", new Object[] { Integer.valueOf(14756), paramView });
      h.CyF.kvStat(14756, paramView);
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
    if (paramInt < parama.mWl.size())
    {
      localObject1 = localObject2;
      if (paramInt >= 0)
      {
        localObject1 = (com.tencent.mm.plugin.fts.a.a.m)parama.mWl.get(paramInt);
        parama = new c();
        parama.dUb = String.valueOf(localObject1.hashCode());
        if (!((com.tencent.mm.plugin.fts.a.a.m)localObject1).wVX.equals("create_talker_message​")) {
          break label91;
        }
        parama.dUm = 22;
      }
    }
    for (localObject1 = parama;; localObject1 = parama)
    {
      AppMethodBeat.o(112207);
      return localObject1;
      label91:
      parama.dUm = 11;
    }
  }
  
  protected int dPI()
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