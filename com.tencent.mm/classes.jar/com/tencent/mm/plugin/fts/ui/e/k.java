package com.tencent.mm.plugin.fts.ui.e;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.c;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.a.o;
import com.tencent.mm.plugin.fts.a.d.e.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.b.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.HashSet;
import java.util.List;

public class k
  extends com.tencent.mm.plugin.fts.ui.a
{
  protected boolean HCE = false;
  
  public k(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
  }
  
  public c a(MMHandler paramMMHandler, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112203);
    this.HCE = false;
    l locall = new l();
    locall.query = getQuery();
    locall.HtA = paramHashSet;
    locall.HtC = this;
    locall.handler = paramMMHandler;
    locall.qRb = 1;
    locall.Htz = 3;
    paramMMHandler = ((n)com.tencent.mm.kernel.h.az(n.class)).search(3, locall);
    AppMethodBeat.o(112203);
    return paramMMHandler;
  }
  
  public com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112205);
    int i = paramInt - parama.Huj;
    if (parama.Huk) {
      i -= 1;
    }
    for (;;)
    {
      o localo = null;
      Object localObject = localo;
      boolean bool;
      if (i < parama.tbH.size())
      {
        localObject = localo;
        if (i >= 0)
        {
          localo = (o)parama.tbH.get(i);
          if (!localo.Hsz.equals("create_talker_message​")) {
            break label174;
          }
          localObject = new i(paramInt);
          if (parama.tbH.size() != 1) {
            break label168;
          }
          bool = true;
          ((i)localObject).HAS = bool;
          this.HCE = true;
        }
      }
      for (;;)
      {
        if (localObject != null)
        {
          ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).Hur = (i + 1);
          ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).FWt = parama.FWt;
          if (i == parama.tbH.size() - 1) {
            ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).Hup = false;
          }
        }
        AppMethodBeat.o(112205);
        return localObject;
        label168:
        bool = false;
        break;
        label174:
        localObject = new com.tencent.mm.plugin.fts.ui.b.m(paramInt);
        ((com.tencent.mm.plugin.fts.ui.b.m)localObject).rpp = localo;
        ((com.tencent.mm.plugin.fts.ui.b.m)localObject).iW(localo.type, localo.subtype);
      }
    }
  }
  
  public void a(com.tencent.mm.plugin.fts.a.a.m paramm, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112204);
    if (hS(paramm.HtF))
    {
      paramHashSet = new e.a();
      paramHashSet.businessType = -2;
      paramHashSet.FWt = paramm.FWt;
      paramHashSet.tbH = paramm.HtF;
      if (paramHashSet.tbH.size() <= 3) {
        break label142;
      }
      if (!((o)paramm.HtF.get(3)).Hsz.equals("create_talker_message​")) {
        break label119;
      }
      paramHashSet.ABD = false;
      paramHashSet.tbH = paramHashSet.tbH.subList(0, 4);
    }
    for (;;)
    {
      this.HwJ.add(paramHashSet);
      AppMethodBeat.o(112204);
      return;
      label119:
      paramHashSet.ABD = true;
      paramHashSet.tbH = paramHashSet.tbH.subList(0, 3);
      continue;
      label142:
      if ((paramm.HtF.size() == 1) && (((o)paramm.HtF.get(0)).Hsz.equals("create_talker_message​"))) {
        paramHashSet.Huk = false;
      }
    }
  }
  
  public boolean a(View paramView, com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(112206);
    int i;
    if ((parama instanceof com.tencent.mm.plugin.fts.ui.b.m))
    {
      i = fzf();
      paramBoolean = this.HCE;
      if (parama.Huv != 65536) {}
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
      k = parama.fxM();
      if (!paramBoolean) {
        break;
      }
    }
    for (int j = 1;; j = 0)
    {
      paramView = String.format("%s,%s,%s", new Object[] { Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(j) });
      Log.v("MicroMsg.FTS.FTSReportLogic", "reportFTSGlobalMsgResultClick: %d, %s", new Object[] { Integer.valueOf(14756), paramView });
      com.tencent.mm.plugin.report.service.h.OAn.kvStat(14756, paramView);
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
  
  public final e b(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112207);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt < parama.tbH.size())
    {
      localObject1 = localObject2;
      if (paramInt >= 0)
      {
        localObject1 = (o)parama.tbH.get(paramInt);
        parama = new e();
        parama.hTs = String.valueOf(localObject1.hashCode());
        if (!((o)localObject1).Hsz.equals("create_talker_message​")) {
          break label91;
        }
        parama.itemType = 22;
      }
    }
    for (localObject1 = parama;; localObject1 = parama)
    {
      AppMethodBeat.o(112207);
      return localObject1;
      label91:
      parama.itemType = 11;
    }
  }
  
  protected int fzf()
  {
    return 0;
  }
  
  public int getType()
  {
    return 112;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.e.k
 * JD-Core Version:    0.7.0.1
 */