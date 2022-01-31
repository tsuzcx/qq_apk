package com.tencent.mm.plugin.fts.ui.d;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.d.e.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.a.m;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.HashSet;
import java.util.List;

public class k
  extends com.tencent.mm.plugin.fts.ui.a
{
  protected boolean naH = false;
  
  public k(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
  }
  
  public com.tencent.mm.plugin.fts.a.a.a a(ak paramak, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(62088);
    this.naH = false;
    com.tencent.mm.plugin.fts.a.a.i locali = new com.tencent.mm.plugin.fts.a.a.i();
    locali.query = this.query;
    locali.mSS = paramHashSet;
    locali.mSU = this;
    locali.handler = paramak;
    locali.hdl = 1;
    locali.mSR = 3;
    paramak = ((n)g.G(n.class)).search(3, locali);
    AppMethodBeat.o(62088);
    return paramak;
  }
  
  public com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(62090);
    int i = paramInt - parama.mTy;
    if (parama.mTz) {
      i -= 1;
    }
    for (;;)
    {
      l locall = null;
      Object localObject = locall;
      boolean bool;
      if (i < parama.mTC.size())
      {
        localObject = locall;
        if (i >= 0)
        {
          locall = (l)parama.mTC.get(i);
          if (!locall.mRV.equals("create_talker_message​")) {
            break label174;
          }
          localObject = new com.tencent.mm.plugin.fts.ui.a.i(paramInt);
          if (parama.mTC.size() != 1) {
            break label168;
          }
          bool = true;
          ((com.tencent.mm.plugin.fts.ui.a.i)localObject).mZf = bool;
          this.naH = true;
        }
      }
      for (;;)
      {
        if (localObject != null)
        {
          ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).mTJ = (i + 1);
          ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).mRX = parama.mRX;
          if (i == parama.mTC.size() - 1) {
            ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).mTH = false;
          }
        }
        AppMethodBeat.o(62090);
        return localObject;
        label168:
        bool = false;
        break;
        label174:
        localObject = new m(paramInt);
        ((m)localObject).hrL = locall;
        ((m)localObject).es(locall.type, locall.mRU);
      }
    }
  }
  
  public void a(j paramj, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(62089);
    if (bU(paramj.mSW))
    {
      paramHashSet = new e.a();
      paramHashSet.businessType = -2;
      paramHashSet.mRX = paramj.mRX;
      paramHashSet.mTC = paramj.mSW;
      if (paramHashSet.mTC.size() <= 3) {
        break label142;
      }
      if (!((l)paramj.mSW.get(3)).mRV.equals("create_talker_message​")) {
        break label119;
      }
      paramHashSet.mTB = false;
      paramHashSet.mTC = paramHashSet.mTC.subList(0, 4);
    }
    for (;;)
    {
      this.mVO.add(paramHashSet);
      AppMethodBeat.o(62089);
      return;
      label119:
      paramHashSet.mTB = true;
      paramHashSet.mTC = paramHashSet.mTC.subList(0, 3);
      continue;
      label142:
      if ((paramj.mSW.size() == 1) && (((l)paramj.mSW.get(0)).mRV.equals("create_talker_message​"))) {
        paramHashSet.mTz = false;
      }
    }
  }
  
  public boolean a(View paramView, com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(62091);
    int i;
    if ((parama instanceof m))
    {
      i = bDc();
      paramBoolean = this.naH;
      if (parama.mTN != 65536) {}
    }
    label85:
    int k;
    switch (parama.pageType)
    {
    default: 
      AppMethodBeat.o(62091);
      return false;
    case 1: 
    case 2: 
    case 3: 
    case 4: 
      i = parama.pageType;
      k = parama.bCj();
      if (!paramBoolean) {
        break;
      }
    }
    for (int j = 1;; j = 0)
    {
      paramView = String.format("%s,%s,%s", new Object[] { Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(j) });
      ab.v("MicroMsg.FTS.FTSReportLogic", "reportFTSGlobalMsgResultClick: %d, %s", new Object[] { Integer.valueOf(14756), paramView });
      h.qsU.kvStat(14756, paramView);
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
  
  protected int bDc()
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