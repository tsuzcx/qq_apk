package com.tencent.mm.plugin.fts.ui;

import android.content.Context;
import android.os.Looper;
import android.view.View;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.tu;
import com.tencent.mm.g.a.tu.b;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.fts.a.d.e.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.ui.a.i;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.protocal.protobuf.ajh;
import com.tencent.mm.protocal.protobuf.dlx;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class k
  extends d
  implements e.b
{
  private boolean nat;
  private aq tJe;
  List<com.tencent.mm.plugin.fts.a.d.e> tKB;
  private com.tencent.mm.plugin.fts.ui.d.n tKC;
  public com.tencent.mm.plugin.fts.ui.c.b tKD;
  com.tencent.mm.plugin.fts.ui.widget.d tKE;
  private long tKF;
  private long tKG;
  private long tKH;
  private long tKI;
  private aq tKJ;
  private int tKK;
  private boolean tKL;
  boolean tKM;
  public boolean tKp;
  public boolean tKy;
  private boolean tiX;
  
  public k(e parame, int paramInt, com.tencent.mm.plugin.fts.ui.widget.d paramd)
  {
    super(parame);
    AppMethodBeat.i(184530);
    this.tKJ = new k.1(this, Looper.getMainLooper());
    this.tJe = new aq(Looper.getMainLooper());
    this.tKK = -1;
    this.tKE = paramd;
    this.tKD = new com.tencent.mm.plugin.fts.ui.c.b();
    parame = new HashSet();
    parame.add(Integer.valueOf(16));
    parame.add(Integer.valueOf(32));
    parame.add(Integer.valueOf(48));
    parame.add(Integer.valueOf(64));
    parame.add(Integer.valueOf(128));
    parame.add(Integer.valueOf(96));
    parame.add(Integer.valueOf(112));
    if (com.tencent.mm.kernel.g.ajM())
    {
      paramd = new tu();
      com.tencent.mm.sdk.b.a.IvT.l(paramd);
      com.tencent.mm.storage.c localc = com.tencent.mm.model.c.d.aDI().xi("100193");
      if ((!localc.isValid()) || (!"1".equals(localc.fsy().get("isOpenLocalSearch"))) || (!paramd.dJi.dJk)) {}
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        parame.add(Integer.valueOf(144));
      }
      this.tKB = ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).createFTSUIUnitList(parame, getContext(), this, paramInt);
      this.tKC = ((com.tencent.mm.plugin.fts.ui.d.n)new com.tencent.mm.plugin.fts.ui.b.l().a(getContext(), this, paramInt));
      AppMethodBeat.o(184530);
      return;
    }
  }
  
  private void c(HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(111956);
    this.tKK += 1;
    if (this.tKK < this.tKB.size()) {
      ((com.tencent.mm.plugin.fts.a.d.e)this.tKB.get(this.tKK)).a(this.query, this.tJe, paramHashSet, com.tencent.mm.plugin.fts.a.e.tEo);
    }
    AppMethodBeat.o(111956);
  }
  
  protected final com.tencent.mm.plugin.fts.a.d.a.a Ho(int paramInt)
  {
    AppMethodBeat.i(111948);
    long l = 0L;
    com.tencent.mm.plugin.fts.a.d.a.a locala = null;
    Object localObject1 = this.tKB.iterator();
    for (;;)
    {
      Object localObject2;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.tencent.mm.plugin.fts.a.d.e)((Iterator)localObject1).next();
        locala = ((com.tencent.mm.plugin.fts.a.d.e)localObject2).Ho(paramInt);
        l = ((com.tencent.mm.plugin.fts.a.d.e)localObject2).cVA();
        if (locala == null) {}
      }
      else
      {
        for (;;)
        {
          if (locala == null)
          {
            locala = this.tKC.Ho(paramInt);
            l = this.tKC.tGT;
          }
          for (;;)
          {
            if (locala != null)
            {
              localObject1 = new LinkedList();
              localObject2 = this.tKB.iterator();
              while (((Iterator)localObject2).hasNext()) {
                ((LinkedList)localObject1).addAll(((com.tencent.mm.plugin.fts.a.d.e)((Iterator)localObject2).next()).cVy());
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
              locala.tGM = i;
              locala.pageType = 1;
              locala.tGT = l;
              if (locala == null) {
                ae.e("MicroMsg.FTS.FTSMainAdapter", "Create Data Item Error: getCount-%d position-%d", new Object[] { Integer.valueOf(getCount()), Integer.valueOf(paramInt) });
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
  
  public final void Hr(int paramInt)
  {
    this.tKD.tNB = paramInt;
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.d.e parame, String paramString)
  {
    AppMethodBeat.i(111955);
    if ((parame instanceof a))
    {
      Object localObject = (a)parame;
      if (paramString.equals(this.query)) {
        c(((a)localObject).tFY);
      }
      if ((((a)localObject).cVR() > 0) && (this.tKF == 0L))
      {
        this.tKF = (System.currentTimeMillis() - this.tJJ);
        l.ai(9, this.tKF);
        ae.i("MicroMsg.FTS.FTSMainAdapter", "firstItemTime=%d", new Object[] { Long.valueOf(this.tKF) });
      }
      switch (((a)localObject).getType())
      {
      default: 
        label140:
        localb = this.tKD;
        localObject = ((a)localObject).tIP.iterator();
      }
      for (;;)
      {
        if (!((Iterator)localObject).hasNext()) {
          break label571;
        }
        e.a locala = (e.a)((Iterator)localObject).next();
        int j = locala.lPc.size();
        if (locala.rRg) {}
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
            localb.tNr = i;
            break;
            if (this.tKG != 0L) {
              break label140;
            }
            this.tKG = (System.currentTimeMillis() - this.tJJ);
            ae.i("MicroMsg.FTS.FTSMainAdapter", "firstGetTopHitsTime=%d", new Object[] { Long.valueOf(this.tKG) });
            l.ai(0, this.tKG);
            break label140;
            if (this.tKH != 0L) {
              break label140;
            }
            this.tKH = (System.currentTimeMillis() - this.tJJ);
            ae.i("MicroMsg.FTS.FTSMainAdapter", "firstGetContactTime=%d", new Object[] { Long.valueOf(this.tKH) });
            l.ai(3, this.tKH);
            break label140;
            if (this.tKI != 0L) {
              break label140;
            }
            this.tKI = (System.currentTimeMillis() - this.tJJ);
            ae.i("MicroMsg.FTS.FTSMainAdapter", "firstGetChatroomTime=%d", new Object[] { Long.valueOf(this.tKI) });
            l.ai(6, this.tKI);
            break label140;
          }
        }
        localb.tNo = i;
        continue;
        localb.tNl = i;
        continue;
        localb.tNp = i;
        continue;
        localb.tNm = i;
        continue;
        localb.favCount = i;
        continue;
        localb.tNq = i;
        continue;
        localb.tNn = i;
        continue;
        localb.tNk = i;
      }
    }
    com.tencent.mm.plugin.fts.ui.c.b localb = this.tKD;
    if (parame.cVz() > 0)
    {
      if (parame.cVw() != 2) {
        break label602;
      }
      localb.tNt = parame.cVz();
    }
    for (;;)
    {
      label571:
      this.tKD.tNE = cVz();
      new a(parame, paramString).run();
      AppMethodBeat.o(111955);
      return;
      label602:
      localb.tNs = parame.cVz();
    }
  }
  
  protected final boolean a(View paramView, com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(111954);
    Iterator localIterator = this.tKB.iterator();
    boolean bool;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      bool = ((com.tencent.mm.plugin.fts.a.d.e)localIterator.next()).a(paramView, parama, paramBoolean);
      paramBoolean = bool;
    } while (!bool);
    if ((!this.tKp) && (!(parama instanceof com.tencent.mm.plugin.fts.ui.a.n)))
    {
      l.a(this.query, true, cVz(), 0, this.tKD);
      this.tKp = true;
    }
    if (parama.tGU)
    {
      ae.d("MicroMsg.FTS.FTSMainAdapter", "searchType=%d | searchScene=%d | kvPosition=%d | kvSubPosition=%d | kvSearchId=%s | kvDocId=%d", new Object[] { Integer.valueOf(parama.pSr), Integer.valueOf(parama.lox), Integer.valueOf(parama.tGM), Integer.valueOf(parama.tGN), parama.tGO, Long.valueOf(parama.tGP) });
      this.tKE.Hz(1);
      this.tKD.b(parama);
      l.a(parama, this.tKD);
      AppMethodBeat.o(111954);
      return true;
    }
    if ((parama instanceof com.tencent.mm.plugin.fts.ui.a.h))
    {
      this.tKy = true;
      this.tKE.Hz(1);
      this.tKD.b(parama);
      l.a(parama, this.tKD);
    }
    for (;;)
    {
      AppMethodBeat.o(111954);
      return false;
      if ((parama instanceof i))
      {
        l.a(parama, this.tKD);
        this.tKD.b(parama);
      }
    }
  }
  
  protected final void b(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a parama)
  {
    AppMethodBeat.i(111949);
    super.b(paramContext, parama);
    paramContext = this.tKD;
    Iterator localIterator;
    switch (parama.oOD)
    {
    default: 
      localIterator = paramContext.tNG.iterator();
    }
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.fts.a.a.c localc = (com.tencent.mm.plugin.fts.a.a.c)localIterator.next();
      if (localc.position == parama.position)
      {
        localc.tEZ = (System.currentTimeMillis() - paramContext.tJJ);
        AppMethodBeat.o(111949);
        return;
        AppMethodBeat.o(111949);
        return;
      }
    }
    AppMethodBeat.o(111949);
  }
  
  protected final void cVS()
  {
    int i = 1;
    AppMethodBeat.i(111950);
    if ((!bu.isNullOrNil(this.tKD.query)) && (!this.tiX) && (this.tKD.tNj != 0L))
    {
      l.a(this.tKD);
      l.b(this.tKD);
      this.tiX = true;
    }
    this.tiX = false;
    this.tKp = false;
    this.tKy = false;
    this.tKK = -1;
    this.tKM = false;
    this.tKL = false;
    this.tKD.reset();
    com.tencent.mm.plugin.fts.a.e.tEo = com.tencent.mm.plugin.fts.a.d.Hj(3);
    this.tKD.tNj = com.tencent.mm.plugin.fts.a.e.tEo;
    this.tKD.query = this.query;
    this.tKD.tJJ = System.currentTimeMillis();
    this.tKF = 0L;
    this.tKG = 0L;
    this.tKH = 0L;
    this.tKI = 0L;
    HashSet localHashSet = new HashSet();
    localHashSet.add("filehelper");
    boolean bool = v.aBp();
    if (!bool) {
      if (bu.getInt(com.tencent.mm.n.g.acL().getValue("BindQQSwitch"), 1) != 1) {}
    }
    for (;;)
    {
      if (i == 0)
      {
        ae.i("MicroMsg.FTS.FTSMainAdapter", "summerqq BindQQSwitch off");
        localHashSet.add("22");
        localHashSet.add("23");
      }
      localHashSet.add("62");
      if (com.tencent.mm.aw.b.Gw((String)com.tencent.mm.kernel.g.ajR().ajA().get(274436, null)))
      {
        ae.i("MicroMsg.FTS.FTSMainAdapter", "checkLookVisibility EuropeanUnionCountry");
        localHashSet.add("65");
      }
      if (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).bOd()) {
        localHashSet.add("63");
      }
      for (;;)
      {
        if (!((com.tencent.mm.plugin.appbrand.service.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.e.class)).byX()) {
          localHashSet.add("69");
        }
        if (!((com.tencent.mm.plugin.appbrand.service.h)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.h.class)).byX()) {
          localHashSet.add("71");
        }
        c(localHashSet);
        this.tKC.a(this.query, this.tJe, null, com.tencent.mm.plugin.fts.a.e.tEo);
        AppMethodBeat.o(111950);
        return;
        i = 0;
        break;
        localHashSet.add("67");
      }
      i = bool;
    }
  }
  
  protected final int cVz()
  {
    AppMethodBeat.i(111959);
    Iterator localIterator = this.tKB.iterator();
    for (int i = 0; localIterator.hasNext(); i = ((com.tencent.mm.plugin.fts.a.d.e)localIterator.next()).cVz() + i) {}
    int j = this.tKC.cVz();
    AppMethodBeat.o(111959);
    return j + i;
  }
  
  public final boolean cWk()
  {
    return (this.tKM) && (this.tKL);
  }
  
  protected final void clearCache()
  {
    AppMethodBeat.i(111952);
    super.clearCache();
    Iterator localIterator = this.tKB.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.fts.a.d.e locale = (com.tencent.mm.plugin.fts.a.d.e)localIterator.next();
      locale.cVx();
      locale.clearData();
    }
    this.tKC.cVx();
    this.tKC.clearData();
    AppMethodBeat.o(111952);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(111951);
    if (!this.tKp)
    {
      this.tKp = true;
      if (!this.tKy) {
        l.a(this.query, false, cVz(), 0, this.tKD);
      }
    }
    if (!this.tiX)
    {
      this.tiX = true;
      l.a(this.tKD);
      l.b(this.tKD);
    }
    this.tKD.reset();
    super.finish();
    AppMethodBeat.o(111951);
  }
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(111957);
    super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    Object localObject1 = (FTSMainUI)this.tJH;
    paramInt1 = ((ListView)paramAbsListView).getHeaderViewsCount();
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if ((((FTSMainUI)localObject1).tLg == 1) && (paramAbsListView.getLastVisiblePosition() >= paramInt1 + ((FTSMainUI)localObject1).tKW.getCount()) && (((FTSMainUI)localObject1).tKW.cWk()) && (((FTSMainUI)localObject1).tKY.getVisibility() == 0))
    {
      ((FTSMainUI)localObject1).tLg = 2;
      localObject2 = ((FTSMainUI)localObject1).tKW.tKD;
      localObject3 = ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).tNG.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (com.tencent.mm.plugin.fts.a.a.c)((Iterator)localObject3).next();
        if ("SearchContactBar".equals(((com.tencent.mm.plugin.fts.a.a.c)localObject4).dCl)) {
          ((com.tencent.mm.plugin.fts.a.a.c)localObject4).tEZ = (System.currentTimeMillis() - ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).tJJ);
        }
      }
    }
    localObject1 = ((FTSMainUI)localObject1).tKU;
    paramInt1 = ((ListView)paramAbsListView).getHeaderViewsCount();
    if ((paramAbsListView.getLastVisiblePosition() >= ((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).tOM.tKW.getCount() + paramInt1) && (((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).tOM.tKW.cWk()) && (((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).tJu == 1) && (((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).tJZ.getVisibility() == 0))
    {
      ae.i("MicroMsg.FTS.PardusSearchLogic", "onScroll webEntry hasResult:%s hasSug:%s", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).dmj), Boolean.valueOf(((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).tPu) });
      if (!((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).dmj)
      {
        ((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).tJu = 2;
        localObject2 = ((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).tOM.tKW.tKD;
        localObject3 = ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).tNG.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (com.tencent.mm.plugin.fts.a.a.c)((Iterator)localObject3).next();
          if ("SOSBar".equals(((com.tencent.mm.plugin.fts.a.a.c)localObject4).dCl)) {
            ((com.tencent.mm.plugin.fts.a.a.c)localObject4).tEZ = (System.currentTimeMillis() - ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).tJJ);
          }
        }
      }
    }
    if ((paramAbsListView.getLastVisiblePosition() >= paramInt1 + ((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).tOM.tKW.getCount()) && (((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).tOM.tKW.cWk()) && (((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).tKb.getVisibility() == 0) && (!((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).tPu))
    {
      paramInt3 = com.tencent.mm.cb.a.iv(((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).tOM);
      paramInt1 = 0;
      if (paramInt1 < ((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).tKb.getChildCount())
      {
        paramAbsListView = ((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).tKb.getChildAt(paramInt1);
        localObject2 = new int[2];
        paramAbsListView.getLocationOnScreen((int[])localObject2);
        paramInt2 = paramAbsListView.getMeasuredHeight();
        int i = localObject2[1];
        paramAbsListView = (ajh)paramAbsListView.getTag();
        if (i + paramInt2 <= paramInt3)
        {
          localObject2 = ((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).tOM.tKW.tKD;
          localObject3 = paramAbsListView.GyJ;
          localObject3 = "SOSRelevant-" + ((dlx)localObject3).Hvr;
          localObject4 = ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).tNG.iterator();
          while (((Iterator)localObject4).hasNext())
          {
            com.tencent.mm.plugin.fts.a.a.c localc = (com.tencent.mm.plugin.fts.a.a.c)((Iterator)localObject4).next();
            if ((((String)localObject3).equals(localc.dCl)) && (localc.tEZ == 0L)) {
              localc.tEZ = (System.currentTimeMillis() - ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).tJJ);
            }
          }
        }
        for (paramInt2 = 1;; paramInt2 = 0)
        {
          if (paramInt2 != 0) {
            ((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).e(0, "", "", "", paramAbsListView.GyJ.Hvr);
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
      this.nat = true;
      ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSImageLoader().cVc();
      o.zsv.pause();
      AppMethodBeat.o(111958);
      return;
    }
    this.nat = false;
    if (!((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSImageLoader().cVd())
    {
      this.tKJ.removeMessages(1);
      this.tKJ.sendEmptyMessageDelayed(1, 200L);
    }
    AppMethodBeat.o(111958);
  }
  
  public final void stopSearch()
  {
    AppMethodBeat.i(111953);
    this.tKJ.removeMessages(1);
    super.stopSearch();
    AppMethodBeat.o(111953);
  }
  
  final class a
    implements Runnable
  {
    private String query;
    private com.tencent.mm.plugin.fts.a.d.e tKO;
    
    a(com.tencent.mm.plugin.fts.a.d.e parame, String paramString)
    {
      this.query = paramString;
      this.tKO = parame;
    }
    
    public final void run()
    {
      AppMethodBeat.i(111946);
      if ((!k.a(k.this)) && (((com.tencent.mm.plugin.fts.a.d.e)k.b(k.this).get(k.b(k.this).size() - 1)).getType() == this.tKO.getType())) {
        k.c(k.this);
      }
      if ((!k.d(k.this)) && (this.tKO.getType() == 256)) {
        k.e(k.this);
      }
      k.f(k.this).tND = k.this.cWk();
      Object localObject1 = k.b(k.this).iterator();
      for (int i = 0; ((Iterator)localObject1).hasNext(); i = ((com.tencent.mm.plugin.fts.a.d.e)((Iterator)localObject1).next()).Hn(i)) {}
      i = k.g(k.this).Hn(i);
      k.this.setCount(i);
      k.this.notifyDataSetChanged();
      localObject1 = k.this;
      ((k)localObject1).ao(i, ((k)localObject1).cWk());
      if (k.this.cWk()) {
        k.f(k.this).tNh = System.currentTimeMillis();
      }
      localObject1 = k.f(k.this);
      Object localObject2 = this.tKO;
      ((com.tencent.mm.plugin.fts.ui.c.b)localObject1).tNG.addAll(((com.tencent.mm.plugin.fts.a.d.e)localObject2).xU(((com.tencent.mm.plugin.fts.ui.c.b)localObject1).tJJ));
      localObject1 = k.f(k.this);
      ((com.tencent.mm.plugin.fts.ui.c.b)localObject1).tNA = i;
      localObject2 = ((com.tencent.mm.plugin.fts.ui.c.b)localObject1).tNG.iterator();
      com.tencent.mm.plugin.fts.a.a.c localc;
      while (((Iterator)localObject2).hasNext())
      {
        localc = (com.tencent.mm.plugin.fts.a.a.c)((Iterator)localObject2).next();
        if ("SearchContactBar".equals(localc.dCl)) {
          localc.position = (((com.tencent.mm.plugin.fts.ui.c.b)localObject1).tNA + 1);
        }
      }
      localObject2 = ((com.tencent.mm.plugin.fts.ui.c.b)localObject1).tNG.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localc = (com.tencent.mm.plugin.fts.a.a.c)((Iterator)localObject2).next();
        if ("SOSBar".equals(localc.dCl)) {
          if ((((com.tencent.mm.plugin.fts.ui.c.b)localObject1).tNw > 0) || (((com.tencent.mm.plugin.fts.ui.c.b)localObject1).tNx > 0)) {
            localc.position = (((com.tencent.mm.plugin.fts.ui.c.b)localObject1).tNA + 2);
          } else {
            localc.position = (((com.tencent.mm.plugin.fts.ui.c.b)localObject1).tNA + 1);
          }
        }
      }
      if ((((com.tencent.mm.plugin.fts.ui.c.b)localObject1).tNw > 0) || (((com.tencent.mm.plugin.fts.ui.c.b)localObject1).tNx > 0)) {}
      for (i = ((com.tencent.mm.plugin.fts.ui.c.b)localObject1).tNA + 3;; i = ((com.tencent.mm.plugin.fts.ui.c.b)localObject1).tNA + 2)
      {
        localObject1 = ((com.tencent.mm.plugin.fts.ui.c.b)localObject1).tNG.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (com.tencent.mm.plugin.fts.a.a.c)((Iterator)localObject1).next();
          if (((com.tencent.mm.plugin.fts.a.a.c)localObject2).dCl.startsWith("SOSRelevant")) {
            ((com.tencent.mm.plugin.fts.a.a.c)localObject2).position = i;
          }
        }
      }
      AppMethodBeat.o(111946);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.k
 * JD-Core Version:    0.7.0.1
 */