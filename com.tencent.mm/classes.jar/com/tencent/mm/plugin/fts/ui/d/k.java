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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.HashSet;
import java.util.List;

public class k
  extends com.tencent.mm.plugin.fts.ui.a
{
  protected boolean BQU = false;
  
  public k(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
  }
  
  public com.tencent.mm.plugin.fts.a.a.a a(MMHandler paramMMHandler, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112203);
    this.BQU = false;
    j localj = new j();
    localj.query = getQuery();
    localj.BIS = paramHashSet;
    localj.BIU = this;
    localj.handler = paramMMHandler;
    localj.nRn = 1;
    localj.BIR = 3;
    paramMMHandler = ((n)com.tencent.mm.kernel.h.ag(n.class)).search(3, localj);
    AppMethodBeat.o(112203);
    return paramMMHandler;
  }
  
  public com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112205);
    int i = paramInt - parama.BJz;
    if (parama.BJA) {
      i -= 1;
    }
    for (;;)
    {
      com.tencent.mm.plugin.fts.a.a.m localm = null;
      Object localObject = localm;
      boolean bool;
      if (i < parama.pWR.size())
      {
        localObject = localm;
        if (i >= 0)
        {
          localm = (com.tencent.mm.plugin.fts.a.a.m)parama.pWR.get(i);
          if (!localm.BHS.equals("create_talker_message​")) {
            break label174;
          }
          localObject = new i(paramInt);
          if (parama.pWR.size() != 1) {
            break label168;
          }
          bool = true;
          ((i)localObject).BPd = bool;
          this.BQU = true;
        }
      }
      for (;;)
      {
        if (localObject != null)
        {
          ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).BJI = (i + 1);
          ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).BHY = parama.BHY;
          if (i == parama.pWR.size() - 1) {
            ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).BJG = false;
          }
        }
        AppMethodBeat.o(112205);
        return localObject;
        label168:
        bool = false;
        break;
        label174:
        localObject = new com.tencent.mm.plugin.fts.ui.a.m(paramInt);
        ((com.tencent.mm.plugin.fts.ui.a.m)localObject).olG = localm;
        ((com.tencent.mm.plugin.fts.ui.a.m)localObject).hx(localm.type, localm.BHR);
      }
    }
  }
  
  public void a(com.tencent.mm.plugin.fts.a.a.k paramk, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112204);
    if (ff(paramk.BIW))
    {
      paramHashSet = new e.a();
      paramHashSet.businessType = -2;
      paramHashSet.BHY = paramk.BHY;
      paramHashSet.pWR = paramk.BIW;
      if (paramHashSet.pWR.size() <= 3) {
        break label142;
      }
      if (!((com.tencent.mm.plugin.fts.a.a.m)paramk.BIW.get(3)).BHS.equals("create_talker_message​")) {
        break label119;
      }
      paramHashSet.xcp = false;
      paramHashSet.pWR = paramHashSet.pWR.subList(0, 4);
    }
    for (;;)
    {
      this.BLN.add(paramHashSet);
      AppMethodBeat.o(112204);
      return;
      label119:
      paramHashSet.xcp = true;
      paramHashSet.pWR = paramHashSet.pWR.subList(0, 3);
      continue;
      label142:
      if ((paramk.BIW.size() == 1) && (((com.tencent.mm.plugin.fts.a.a.m)paramk.BIW.get(0)).BHS.equals("create_talker_message​"))) {
        paramHashSet.BJA = false;
      }
    }
  }
  
  public boolean a(View paramView, com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(112206);
    int i;
    if ((parama instanceof com.tencent.mm.plugin.fts.ui.a.m))
    {
      i = esh();
      paramBoolean = this.BQU;
      if (parama.BJM != 65536) {}
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
      k = parama.erf();
      if (!paramBoolean) {
        break;
      }
    }
    for (int j = 1;; j = 0)
    {
      paramView = String.format("%s,%s,%s", new Object[] { Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(j) });
      Log.v("MicroMsg.FTS.FTSReportLogic", "reportFTSGlobalMsgResultClick: %d, %s", new Object[] { Integer.valueOf(14756), paramView });
      com.tencent.mm.plugin.report.service.h.IzE.kvStat(14756, paramView);
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
    if (paramInt < parama.pWR.size())
    {
      localObject1 = localObject2;
      if (paramInt >= 0)
      {
        localObject1 = (com.tencent.mm.plugin.fts.a.a.m)parama.pWR.get(paramInt);
        parama = new c();
        parama.fND = String.valueOf(localObject1.hashCode());
        if (!((com.tencent.mm.plugin.fts.a.a.m)localObject1).BHS.equals("create_talker_message​")) {
          break label91;
        }
        parama.fNO = 22;
      }
    }
    for (localObject1 = parama;; localObject1 = parama)
    {
      AppMethodBeat.o(112207);
      return localObject1;
      label91:
      parama.fNO = 11;
    }
  }
  
  protected int esh()
  {
    return 0;
  }
  
  public int getType()
  {
    return 112;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.d.k
 * JD-Core Version:    0.7.0.1
 */