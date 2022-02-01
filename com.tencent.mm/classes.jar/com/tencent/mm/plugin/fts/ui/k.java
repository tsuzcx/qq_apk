package com.tencent.mm.plugin.fts.ui;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.tt;
import com.tencent.mm.g.a.tt.b;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.fts.a.d.e.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.ui.a.i;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.protocal.protobuf.aix;
import com.tencent.mm.protocal.protobuf.dla;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class k
  extends d
  implements e.b
{
  private boolean mVn;
  private boolean sXJ;
  private ap tyn;
  public boolean tzH;
  List<com.tencent.mm.plugin.fts.a.d.e> tzK;
  private com.tencent.mm.plugin.fts.ui.d.n tzL;
  public com.tencent.mm.plugin.fts.ui.c.b tzM;
  com.tencent.mm.plugin.fts.ui.widget.d tzN;
  private long tzO;
  private long tzP;
  private long tzQ;
  private long tzR;
  private ap tzS;
  private int tzT;
  private boolean tzU;
  boolean tzV;
  public boolean tzy;
  
  public k(e parame, int paramInt, com.tencent.mm.plugin.fts.ui.widget.d paramd)
  {
    super(parame);
    AppMethodBeat.i(184530);
    this.tzS = new ap(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(111945);
        switch (paramAnonymousMessage.what)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(111945);
          return;
          if ((!k.h(k.this)) && (k.this.getCount() > 0))
          {
            ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSImageLoader().cSz();
            o.zbS.start();
            k.this.notifyDataSetChanged();
          }
        }
      }
    };
    this.tyn = new ap(Looper.getMainLooper());
    this.tzT = -1;
    this.tzN = paramd;
    this.tzM = new com.tencent.mm.plugin.fts.ui.c.b();
    parame = new HashSet();
    parame.add(Integer.valueOf(16));
    parame.add(Integer.valueOf(32));
    parame.add(Integer.valueOf(48));
    parame.add(Integer.valueOf(64));
    parame.add(Integer.valueOf(128));
    parame.add(Integer.valueOf(96));
    parame.add(Integer.valueOf(112));
    if (com.tencent.mm.kernel.g.ajx())
    {
      paramd = new tt();
      com.tencent.mm.sdk.b.a.IbL.l(paramd);
      com.tencent.mm.storage.c localc = com.tencent.mm.model.c.d.aDs().wz("100193");
      if ((!localc.isValid()) || (!"1".equals(localc.foF().get("isOpenLocalSearch"))) || (!paramd.dIe.dIg)) {}
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        parame.add(Integer.valueOf(144));
      }
      this.tzK = ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).createFTSUIUnitList(parame, getContext(), this, paramInt);
      this.tzL = ((com.tencent.mm.plugin.fts.ui.d.n)new com.tencent.mm.plugin.fts.ui.b.l().a(getContext(), this, paramInt));
      AppMethodBeat.o(184530);
      return;
    }
  }
  
  private void c(HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(111956);
    this.tzT += 1;
    if (this.tzT < this.tzK.size()) {
      ((com.tencent.mm.plugin.fts.a.d.e)this.tzK.get(this.tzT)).a(this.query, this.tyn, paramHashSet, com.tencent.mm.plugin.fts.a.e.ttx);
    }
    AppMethodBeat.o(111956);
  }
  
  protected final com.tencent.mm.plugin.fts.a.d.a.a GR(int paramInt)
  {
    AppMethodBeat.i(111948);
    long l = 0L;
    com.tencent.mm.plugin.fts.a.d.a.a locala = null;
    Object localObject1 = this.tzK.iterator();
    for (;;)
    {
      Object localObject2;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.tencent.mm.plugin.fts.a.d.e)((Iterator)localObject1).next();
        locala = ((com.tencent.mm.plugin.fts.a.d.e)localObject2).GR(paramInt);
        l = ((com.tencent.mm.plugin.fts.a.d.e)localObject2).cSV();
        if (locala == null) {}
      }
      else
      {
        for (;;)
        {
          if (locala == null)
          {
            locala = this.tzL.GR(paramInt);
            l = this.tzL.twc;
          }
          for (;;)
          {
            if (locala != null)
            {
              localObject1 = new LinkedList();
              localObject2 = this.tzK.iterator();
              while (((Iterator)localObject2).hasNext()) {
                ((LinkedList)localObject1).addAll(((com.tencent.mm.plugin.fts.a.d.e)((Iterator)localObject2).next()).cST());
              }
              i = ((LinkedList)localObject1).size() - 1;
              if (i < 0) {
                break label248;
              }
              if (paramInt <= ((Integer)((LinkedList)localObject1).get(i)).intValue()) {
                break label241;
              }
            }
            label241:
            label248:
            for (int i = paramInt - i;; i = paramInt)
            {
              locala.tvV = i;
              locala.pageType = 1;
              locala.twc = l;
              if (locala == null) {
                ad.e("MicroMsg.FTS.FTSMainAdapter", "Create Data Item Error: getCount-%d position-%d", new Object[] { Integer.valueOf(getCount()), Integer.valueOf(paramInt) });
              }
              AppMethodBeat.o(111948);
              return locala;
              i -= 1;
              break;
            }
          }
        }
      }
    }
  }
  
  public final void GU(int paramInt)
  {
    this.tzM.tCK = paramInt;
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.d.e parame, String paramString)
  {
    AppMethodBeat.i(111955);
    if ((parame instanceof a))
    {
      Object localObject = (a)parame;
      if (paramString.equals(this.query)) {
        c(((a)localObject).tvh);
      }
      if ((((a)localObject).cTm() > 0) && (this.tzO == 0L))
      {
        this.tzO = (System.currentTimeMillis() - this.tyS);
        l.ai(9, this.tzO);
        ad.i("MicroMsg.FTS.FTSMainAdapter", "firstItemTime=%d", new Object[] { Long.valueOf(this.tzO) });
      }
      switch (((a)localObject).getType())
      {
      default: 
        label140:
        localb = this.tzM;
        localObject = ((a)localObject).txY.iterator();
      }
      for (;;)
      {
        if (!((Iterator)localObject).hasNext()) {
          break label571;
        }
        e.a locala = (e.a)((Iterator)localObject).next();
        int j = locala.lKC.size();
        if (locala.rKf) {}
        for (int i = 1;; i = 0)
        {
          i += j;
          switch (locala.businessType)
          {
          case -12: 
          case -10: 
          case -9: 
          case -5: 
          default: 
            break;
          case -13: 
            localb.tCA = i;
            break;
            if (this.tzP != 0L) {
              break label140;
            }
            this.tzP = (System.currentTimeMillis() - this.tyS);
            ad.i("MicroMsg.FTS.FTSMainAdapter", "firstGetTopHitsTime=%d", new Object[] { Long.valueOf(this.tzP) });
            l.ai(0, this.tzP);
            break label140;
            if (this.tzQ != 0L) {
              break label140;
            }
            this.tzQ = (System.currentTimeMillis() - this.tyS);
            ad.i("MicroMsg.FTS.FTSMainAdapter", "firstGetContactTime=%d", new Object[] { Long.valueOf(this.tzQ) });
            l.ai(3, this.tzQ);
            break label140;
            if (this.tzR != 0L) {
              break label140;
            }
            this.tzR = (System.currentTimeMillis() - this.tyS);
            ad.i("MicroMsg.FTS.FTSMainAdapter", "firstGetChatroomTime=%d", new Object[] { Long.valueOf(this.tzR) });
            l.ai(6, this.tzR);
            break label140;
          }
        }
        localb.tCx = i;
        continue;
        localb.tCu = i;
        continue;
        localb.tCy = i;
        continue;
        localb.tCv = i;
        continue;
        localb.favCount = i;
        continue;
        localb.tCz = i;
        continue;
        localb.tCw = i;
        continue;
        localb.tCt = i;
      }
    }
    com.tencent.mm.plugin.fts.ui.c.b localb = this.tzM;
    if (parame.cSU() > 0)
    {
      if (parame.cSR() != 2) {
        break label602;
      }
      localb.tCC = parame.cSU();
    }
    for (;;)
    {
      label571:
      this.tzM.tCN = cSU();
      new a(parame, paramString).run();
      AppMethodBeat.o(111955);
      return;
      label602:
      localb.tCB = parame.cSU();
    }
  }
  
  protected final boolean a(View paramView, com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(111954);
    Iterator localIterator = this.tzK.iterator();
    boolean bool;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      bool = ((com.tencent.mm.plugin.fts.a.d.e)localIterator.next()).a(paramView, parama, paramBoolean);
      paramBoolean = bool;
    } while (!bool);
    if ((!this.tzy) && (!(parama instanceof com.tencent.mm.plugin.fts.ui.a.n)))
    {
      l.a(this.query, true, cSU(), 0, this.tzM);
      this.tzy = true;
    }
    if (parama.twd)
    {
      ad.d("MicroMsg.FTS.FTSMainAdapter", "searchType=%d | searchScene=%d | kvPosition=%d | kvSubPosition=%d | kvSearchId=%s | kvDocId=%d", new Object[] { Integer.valueOf(parama.pLM), Integer.valueOf(parama.ljZ), Integer.valueOf(parama.tvV), Integer.valueOf(parama.tvW), parama.tvX, Long.valueOf(parama.tvY) });
      this.tzN.Hc(1);
      this.tzM.b(parama);
      l.a(parama, this.tzM);
      AppMethodBeat.o(111954);
      return true;
    }
    if ((parama instanceof com.tencent.mm.plugin.fts.ui.a.h))
    {
      this.tzH = true;
      this.tzN.Hc(1);
      this.tzM.b(parama);
      l.a(parama, this.tzM);
    }
    for (;;)
    {
      AppMethodBeat.o(111954);
      return false;
      if ((parama instanceof i))
      {
        l.a(parama, this.tzM);
        this.tzM.b(parama);
      }
    }
  }
  
  protected final void b(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a parama)
  {
    AppMethodBeat.i(111949);
    super.b(paramContext, parama);
    paramContext = this.tzM;
    Iterator localIterator;
    switch (parama.oIb)
    {
    default: 
      localIterator = paramContext.tCP.iterator();
    }
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.fts.a.a.c localc = (com.tencent.mm.plugin.fts.a.a.c)localIterator.next();
      if (localc.position == parama.position)
      {
        localc.tui = (System.currentTimeMillis() - paramContext.tyS);
        AppMethodBeat.o(111949);
        return;
        AppMethodBeat.o(111949);
        return;
      }
    }
    AppMethodBeat.o(111949);
  }
  
  protected final int cSU()
  {
    AppMethodBeat.i(111959);
    Iterator localIterator = this.tzK.iterator();
    for (int i = 0; localIterator.hasNext(); i = ((com.tencent.mm.plugin.fts.a.d.e)localIterator.next()).cSU() + i) {}
    int j = this.tzL.cSU();
    AppMethodBeat.o(111959);
    return j + i;
  }
  
  public final boolean cTF()
  {
    return (this.tzV) && (this.tzU);
  }
  
  protected final void cTn()
  {
    int i = 1;
    AppMethodBeat.i(111950);
    if ((!bt.isNullOrNil(this.tzM.query)) && (!this.sXJ) && (this.tzM.tCs != 0L))
    {
      l.a(this.tzM);
      l.b(this.tzM);
      this.sXJ = true;
    }
    this.sXJ = false;
    this.tzy = false;
    this.tzH = false;
    this.tzT = -1;
    this.tzV = false;
    this.tzU = false;
    this.tzM.reset();
    com.tencent.mm.plugin.fts.a.e.ttx = com.tencent.mm.plugin.fts.a.d.GM(3);
    this.tzM.tCs = com.tencent.mm.plugin.fts.a.e.ttx;
    this.tzM.query = this.query;
    this.tzM.tyS = System.currentTimeMillis();
    this.tzO = 0L;
    this.tzP = 0L;
    this.tzQ = 0L;
    this.tzR = 0L;
    HashSet localHashSet = new HashSet();
    localHashSet.add("filehelper");
    boolean bool = u.aAZ();
    if (!bool) {
      if (bt.getInt(com.tencent.mm.n.g.acA().getValue("BindQQSwitch"), 1) != 1) {}
    }
    for (;;)
    {
      if (i == 0)
      {
        ad.i("MicroMsg.FTS.FTSMainAdapter", "summerqq BindQQSwitch off");
        localHashSet.add("22");
        localHashSet.add("23");
      }
      localHashSet.add("62");
      if (com.tencent.mm.ax.b.FU((String)com.tencent.mm.kernel.g.ajC().ajl().get(274436, null)))
      {
        ad.i("MicroMsg.FTS.FTSMainAdapter", "checkLookVisibility EuropeanUnionCountry");
        localHashSet.add("65");
      }
      if (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).bNf()) {
        localHashSet.add("63");
      }
      for (;;)
      {
        if (!((com.tencent.mm.plugin.appbrand.service.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.e.class)).bye()) {
          localHashSet.add("69");
        }
        if (!((com.tencent.mm.plugin.appbrand.service.h)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.h.class)).bye()) {
          localHashSet.add("71");
        }
        c(localHashSet);
        this.tzL.a(this.query, this.tyn, null, com.tencent.mm.plugin.fts.a.e.ttx);
        AppMethodBeat.o(111950);
        return;
        i = 0;
        break;
        localHashSet.add("67");
      }
      i = bool;
    }
  }
  
  protected final void clearCache()
  {
    AppMethodBeat.i(111952);
    super.clearCache();
    Iterator localIterator = this.tzK.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.fts.a.d.e locale = (com.tencent.mm.plugin.fts.a.d.e)localIterator.next();
      locale.cSS();
      locale.clearData();
    }
    this.tzL.cSS();
    this.tzL.clearData();
    AppMethodBeat.o(111952);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(111951);
    if (!this.tzy)
    {
      this.tzy = true;
      if (!this.tzH) {
        l.a(this.query, false, cSU(), 0, this.tzM);
      }
    }
    if (!this.sXJ)
    {
      this.sXJ = true;
      l.a(this.tzM);
      l.b(this.tzM);
    }
    this.tzM.reset();
    super.finish();
    AppMethodBeat.o(111951);
  }
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(111957);
    super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    Object localObject1 = (FTSMainUI)this.tyQ;
    paramInt1 = ((ListView)paramAbsListView).getHeaderViewsCount();
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if ((((FTSMainUI)localObject1).tAp == 1) && (paramAbsListView.getLastVisiblePosition() >= paramInt1 + ((FTSMainUI)localObject1).tAf.getCount()) && (((FTSMainUI)localObject1).tAf.cTF()) && (((FTSMainUI)localObject1).tAh.getVisibility() == 0))
    {
      ((FTSMainUI)localObject1).tAp = 2;
      localObject2 = ((FTSMainUI)localObject1).tAf.tzM;
      localObject3 = ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).tCP.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (com.tencent.mm.plugin.fts.a.a.c)((Iterator)localObject3).next();
        if ("SearchContactBar".equals(((com.tencent.mm.plugin.fts.a.a.c)localObject4).dBg)) {
          ((com.tencent.mm.plugin.fts.a.a.c)localObject4).tui = (System.currentTimeMillis() - ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).tyS);
        }
      }
    }
    localObject1 = ((FTSMainUI)localObject1).tAd;
    paramInt1 = ((ListView)paramAbsListView).getHeaderViewsCount();
    if ((paramAbsListView.getLastVisiblePosition() >= ((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).tDV.tAf.getCount() + paramInt1) && (((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).tDV.tAf.cTF()) && (((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).tyD == 1) && (((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).tzi.getVisibility() == 0))
    {
      ad.i("MicroMsg.FTS.PardusSearchLogic", "onScroll webEntry hasResult:%s hasSug:%s", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).dlh), Boolean.valueOf(((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).tED) });
      if (!((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).dlh)
      {
        ((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).tyD = 2;
        localObject2 = ((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).tDV.tAf.tzM;
        localObject3 = ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).tCP.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (com.tencent.mm.plugin.fts.a.a.c)((Iterator)localObject3).next();
          if ("SOSBar".equals(((com.tencent.mm.plugin.fts.a.a.c)localObject4).dBg)) {
            ((com.tencent.mm.plugin.fts.a.a.c)localObject4).tui = (System.currentTimeMillis() - ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).tyS);
          }
        }
      }
    }
    if ((paramAbsListView.getLastVisiblePosition() >= paramInt1 + ((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).tDV.tAf.getCount()) && (((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).tDV.tAf.cTF()) && (((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).tzk.getVisibility() == 0) && (!((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).tED))
    {
      paramInt3 = com.tencent.mm.cc.a.iq(((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).tDV);
      paramInt1 = 0;
      if (paramInt1 < ((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).tzk.getChildCount())
      {
        paramAbsListView = ((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).tzk.getChildAt(paramInt1);
        localObject2 = new int[2];
        paramAbsListView.getLocationOnScreen((int[])localObject2);
        paramInt2 = paramAbsListView.getMeasuredHeight();
        int i = localObject2[1];
        paramAbsListView = (aix)paramAbsListView.getTag();
        if (i + paramInt2 <= paramInt3)
        {
          localObject2 = ((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).tDV.tAf.tzM;
          localObject3 = paramAbsListView.Gga;
          localObject3 = "SOSRelevant-" + ((dla)localObject3).HbR;
          localObject4 = ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).tCP.iterator();
          while (((Iterator)localObject4).hasNext())
          {
            com.tencent.mm.plugin.fts.a.a.c localc = (com.tencent.mm.plugin.fts.a.a.c)((Iterator)localObject4).next();
            if ((((String)localObject3).equals(localc.dBg)) && (localc.tui == 0L)) {
              localc.tui = (System.currentTimeMillis() - ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).tyS);
            }
          }
        }
        for (paramInt2 = 1;; paramInt2 = 0)
        {
          if (paramInt2 != 0) {
            ((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).e(0, "", "", "", paramAbsListView.Gga.HbR);
          }
          paramInt1 += 1;
          break;
        }
      }
    }
    AppMethodBeat.o(111957);
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(111958);
    super.onScrollStateChanged(paramAbsListView, paramInt);
    if (paramInt == 2)
    {
      this.mVn = true;
      ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSImageLoader().cSx();
      o.zbS.pause();
      AppMethodBeat.o(111958);
      return;
    }
    this.mVn = false;
    if (!((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSImageLoader().cSy())
    {
      this.tzS.removeMessages(1);
      this.tzS.sendEmptyMessageDelayed(1, 200L);
    }
    AppMethodBeat.o(111958);
  }
  
  public final void stopSearch()
  {
    AppMethodBeat.i(111953);
    this.tzS.removeMessages(1);
    super.stopSearch();
    AppMethodBeat.o(111953);
  }
  
  final class a
    implements Runnable
  {
    private String query;
    private com.tencent.mm.plugin.fts.a.d.e tzX;
    
    a(com.tencent.mm.plugin.fts.a.d.e parame, String paramString)
    {
      this.query = paramString;
      this.tzX = parame;
    }
    
    public final void run()
    {
      AppMethodBeat.i(111946);
      if ((!k.a(k.this)) && (((com.tencent.mm.plugin.fts.a.d.e)k.b(k.this).get(k.b(k.this).size() - 1)).getType() == this.tzX.getType())) {
        k.c(k.this);
      }
      if ((!k.d(k.this)) && (this.tzX.getType() == 256)) {
        k.e(k.this);
      }
      k.f(k.this).tCM = k.this.cTF();
      Object localObject1 = k.b(k.this).iterator();
      for (int i = 0; ((Iterator)localObject1).hasNext(); i = ((com.tencent.mm.plugin.fts.a.d.e)((Iterator)localObject1).next()).GQ(i)) {}
      i = k.g(k.this).GQ(i);
      k.this.setCount(i);
      k.this.notifyDataSetChanged();
      localObject1 = k.this;
      ((k)localObject1).al(i, ((k)localObject1).cTF());
      if (k.this.cTF()) {
        k.f(k.this).tCq = System.currentTimeMillis();
      }
      localObject1 = k.f(k.this);
      Object localObject2 = this.tzX;
      ((com.tencent.mm.plugin.fts.ui.c.b)localObject1).tCP.addAll(((com.tencent.mm.plugin.fts.a.d.e)localObject2).xA(((com.tencent.mm.plugin.fts.ui.c.b)localObject1).tyS));
      localObject1 = k.f(k.this);
      ((com.tencent.mm.plugin.fts.ui.c.b)localObject1).tCJ = i;
      localObject2 = ((com.tencent.mm.plugin.fts.ui.c.b)localObject1).tCP.iterator();
      com.tencent.mm.plugin.fts.a.a.c localc;
      while (((Iterator)localObject2).hasNext())
      {
        localc = (com.tencent.mm.plugin.fts.a.a.c)((Iterator)localObject2).next();
        if ("SearchContactBar".equals(localc.dBg)) {
          localc.position = (((com.tencent.mm.plugin.fts.ui.c.b)localObject1).tCJ + 1);
        }
      }
      localObject2 = ((com.tencent.mm.plugin.fts.ui.c.b)localObject1).tCP.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localc = (com.tencent.mm.plugin.fts.a.a.c)((Iterator)localObject2).next();
        if ("SOSBar".equals(localc.dBg)) {
          if ((((com.tencent.mm.plugin.fts.ui.c.b)localObject1).tCF > 0) || (((com.tencent.mm.plugin.fts.ui.c.b)localObject1).tCG > 0)) {
            localc.position = (((com.tencent.mm.plugin.fts.ui.c.b)localObject1).tCJ + 2);
          } else {
            localc.position = (((com.tencent.mm.plugin.fts.ui.c.b)localObject1).tCJ + 1);
          }
        }
      }
      if ((((com.tencent.mm.plugin.fts.ui.c.b)localObject1).tCF > 0) || (((com.tencent.mm.plugin.fts.ui.c.b)localObject1).tCG > 0)) {}
      for (i = ((com.tencent.mm.plugin.fts.ui.c.b)localObject1).tCJ + 3;; i = ((com.tencent.mm.plugin.fts.ui.c.b)localObject1).tCJ + 2)
      {
        localObject1 = ((com.tencent.mm.plugin.fts.ui.c.b)localObject1).tCP.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (com.tencent.mm.plugin.fts.a.a.c)((Iterator)localObject1).next();
          if (((com.tencent.mm.plugin.fts.a.a.c)localObject2).dBg.startsWith("SOSRelevant")) {
            ((com.tencent.mm.plugin.fts.a.a.c)localObject2).position = i;
          }
        }
      }
      AppMethodBeat.o(111946);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.k
 * JD-Core Version:    0.7.0.1
 */