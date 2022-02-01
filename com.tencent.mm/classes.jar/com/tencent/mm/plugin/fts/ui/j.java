package com.tencent.mm.plugin.fts.ui;

import android.content.Context;
import android.os.Looper;
import android.view.View;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.tb;
import com.tencent.mm.g.a.tb.b;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.fts.a.d.e.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.ui.a.i;
import com.tencent.mm.plugin.fts.ui.b.l;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.dfn;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class j
  extends d
  implements e.b
{
  private boolean muG;
  private ao sBM;
  public boolean sCJ;
  public boolean sCS;
  List<com.tencent.mm.plugin.fts.a.d.e> sCV;
  private com.tencent.mm.plugin.fts.ui.d.n sCW;
  public com.tencent.mm.plugin.fts.ui.c.b sCX;
  com.tencent.mm.plugin.fts.ui.widget.d sCY;
  private long sCZ;
  private long sDa;
  private long sDb;
  private long sDc;
  private ao sDd;
  private int sDe;
  private boolean sDf;
  boolean sDg;
  private boolean sau;
  
  public j(e parame, int paramInt, com.tencent.mm.plugin.fts.ui.widget.d paramd)
  {
    super(parame);
    AppMethodBeat.i(184530);
    this.sDd = new j.1(this, Looper.getMainLooper());
    this.sBM = new ao(Looper.getMainLooper());
    this.sDe = -1;
    this.sCY = paramd;
    this.sCX = new com.tencent.mm.plugin.fts.ui.c.b();
    parame = new HashSet();
    parame.add(Integer.valueOf(16));
    parame.add(Integer.valueOf(32));
    parame.add(Integer.valueOf(48));
    parame.add(Integer.valueOf(64));
    parame.add(Integer.valueOf(128));
    parame.add(Integer.valueOf(96));
    parame.add(Integer.valueOf(112));
    if (com.tencent.mm.kernel.g.agM())
    {
      paramd = new tb();
      com.tencent.mm.sdk.b.a.GpY.l(paramd);
      com.tencent.mm.storage.c localc = com.tencent.mm.model.c.d.aAp().tJ("100193");
      if ((!localc.isValid()) || (!"1".equals(localc.eYV().get("isOpenLocalSearch"))) || (!paramd.dvU.dvW)) {}
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        parame.add(Integer.valueOf(144));
      }
      this.sCV = ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).createFTSUIUnitList(parame, getContext(), this, paramInt);
      this.sCW = ((com.tencent.mm.plugin.fts.ui.d.n)new l().a(getContext(), this, paramInt));
      AppMethodBeat.o(184530);
      return;
    }
  }
  
  private void c(HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(111956);
    this.sDe += 1;
    if (this.sDe < this.sCV.size()) {
      ((com.tencent.mm.plugin.fts.a.d.e)this.sCV.get(this.sDe)).a(this.query, this.sBM, paramHashSet, com.tencent.mm.plugin.fts.a.e.swW);
    }
    AppMethodBeat.o(111956);
  }
  
  protected final com.tencent.mm.plugin.fts.a.d.a.a FC(int paramInt)
  {
    AppMethodBeat.i(111948);
    long l = 0L;
    com.tencent.mm.plugin.fts.a.d.a.a locala = null;
    Object localObject1 = this.sCV.iterator();
    for (;;)
    {
      Object localObject2;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.tencent.mm.plugin.fts.a.d.e)((Iterator)localObject1).next();
        locala = ((com.tencent.mm.plugin.fts.a.d.e)localObject2).FC(paramInt);
        l = ((com.tencent.mm.plugin.fts.a.d.e)localObject2).cKG();
        if (locala == null) {}
      }
      else
      {
        for (;;)
        {
          if (locala == null)
          {
            locala = this.sCW.FC(paramInt);
            l = this.sCW.szB;
          }
          for (;;)
          {
            if (locala != null)
            {
              localObject1 = new LinkedList();
              localObject2 = this.sCV.iterator();
              while (((Iterator)localObject2).hasNext()) {
                ((LinkedList)localObject1).addAll(((com.tencent.mm.plugin.fts.a.d.e)((Iterator)localObject2).next()).cKE());
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
              locala.szu = i;
              locala.pageType = 1;
              locala.szB = l;
              if (locala == null) {
                ac.e("MicroMsg.FTS.FTSMainAdapter", "Create Data Item Error: getCount-%d position-%d", new Object[] { Integer.valueOf(getCount()), Integer.valueOf(paramInt) });
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
  
  public final void FF(int paramInt)
  {
    this.sCX.sFQ = paramInt;
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.d.e parame, String paramString)
  {
    AppMethodBeat.i(111955);
    if ((parame instanceof a))
    {
      Object localObject = (a)parame;
      if (paramString.equals(this.query)) {
        c(((a)localObject).syG);
      }
      if ((((a)localObject).cKX() > 0) && (this.sCZ == 0L))
      {
        this.sCZ = (System.currentTimeMillis() - this.sCr);
        k.ae(9, this.sCZ);
        ac.i("MicroMsg.FTS.FTSMainAdapter", "firstItemTime=%d", new Object[] { Long.valueOf(this.sCZ) });
      }
      switch (((a)localObject).getType())
      {
      default: 
        label140:
        localb = this.sCX;
        localObject = ((a)localObject).sBx.iterator();
      }
      for (;;)
      {
        if (!((Iterator)localObject).hasNext()) {
          break label571;
        }
        e.a locala = (e.a)((Iterator)localObject).next();
        int j = locala.lnk.size();
        if (locala.qYO) {}
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
            localb.sFG = i;
            break;
            if (this.sDa != 0L) {
              break label140;
            }
            this.sDa = (System.currentTimeMillis() - this.sCr);
            ac.i("MicroMsg.FTS.FTSMainAdapter", "firstGetTopHitsTime=%d", new Object[] { Long.valueOf(this.sDa) });
            k.ae(0, this.sDa);
            break label140;
            if (this.sDb != 0L) {
              break label140;
            }
            this.sDb = (System.currentTimeMillis() - this.sCr);
            ac.i("MicroMsg.FTS.FTSMainAdapter", "firstGetContactTime=%d", new Object[] { Long.valueOf(this.sDb) });
            k.ae(3, this.sDb);
            break label140;
            if (this.sDc != 0L) {
              break label140;
            }
            this.sDc = (System.currentTimeMillis() - this.sCr);
            ac.i("MicroMsg.FTS.FTSMainAdapter", "firstGetChatroomTime=%d", new Object[] { Long.valueOf(this.sDc) });
            k.ae(6, this.sDc);
            break label140;
          }
        }
        localb.sFD = i;
        continue;
        localb.sFA = i;
        continue;
        localb.sFE = i;
        continue;
        localb.sFB = i;
        continue;
        localb.favCount = i;
        continue;
        localb.sFF = i;
        continue;
        localb.sFC = i;
        continue;
        localb.sFz = i;
      }
    }
    com.tencent.mm.plugin.fts.ui.c.b localb = this.sCX;
    if (parame.cKF() > 0)
    {
      if (parame.cKC() != 2) {
        break label602;
      }
      localb.sFI = parame.cKF();
    }
    for (;;)
    {
      label571:
      this.sCX.sFT = cKF();
      new a(parame, paramString).run();
      AppMethodBeat.o(111955);
      return;
      label602:
      localb.sFH = parame.cKF();
    }
  }
  
  protected final boolean a(View paramView, com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(111954);
    Iterator localIterator = this.sCV.iterator();
    boolean bool;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      bool = ((com.tencent.mm.plugin.fts.a.d.e)localIterator.next()).a(paramView, parama, paramBoolean);
      paramBoolean = bool;
    } while (!bool);
    if ((!this.sCJ) && (!(parama instanceof com.tencent.mm.plugin.fts.ui.a.n)))
    {
      k.a(this.query, true, cKF(), 0, this.sCX);
      this.sCJ = true;
    }
    if (parama.szC)
    {
      ac.d("MicroMsg.FTS.FTSMainAdapter", "searchType=%d | searchScene=%d | kvPosition=%d | kvSubPosition=%d | kvSearchId=%s | kvDocId=%d", new Object[] { Integer.valueOf(parama.pil), Integer.valueOf(parama.kNw), Integer.valueOf(parama.szu), Integer.valueOf(parama.szv), parama.szw, Long.valueOf(parama.szx) });
      this.sCY.FN(1);
      this.sCX.b(parama);
      k.a(parama, this.sCX);
      AppMethodBeat.o(111954);
      return true;
    }
    if ((parama instanceof com.tencent.mm.plugin.fts.ui.a.h))
    {
      this.sCS = true;
      this.sCY.FN(1);
      this.sCX.b(parama);
      k.a(parama, this.sCX);
    }
    for (;;)
    {
      AppMethodBeat.o(111954);
      return false;
      if ((parama instanceof i))
      {
        k.a(parama, this.sCX);
        this.sCX.b(parama);
      }
    }
  }
  
  protected final void b(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a parama)
  {
    AppMethodBeat.i(111949);
    super.b(paramContext, parama);
    paramContext = this.sCX;
    Iterator localIterator;
    switch (parama.oeH)
    {
    default: 
      localIterator = paramContext.sFV.iterator();
    }
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.fts.a.a.c localc = (com.tencent.mm.plugin.fts.a.a.c)localIterator.next();
      if (localc.position == parama.position)
      {
        localc.sxH = (System.currentTimeMillis() - paramContext.sCr);
        AppMethodBeat.o(111949);
        return;
        AppMethodBeat.o(111949);
        return;
      }
    }
    AppMethodBeat.o(111949);
  }
  
  protected final int cKF()
  {
    AppMethodBeat.i(111959);
    Iterator localIterator = this.sCV.iterator();
    for (int i = 0; localIterator.hasNext(); i = ((com.tencent.mm.plugin.fts.a.d.e)localIterator.next()).cKF() + i) {}
    int j = this.sCW.cKF();
    AppMethodBeat.o(111959);
    return j + i;
  }
  
  protected final void cKY()
  {
    int i = 1;
    AppMethodBeat.i(111950);
    if ((!bs.isNullOrNil(this.sCX.query)) && (!this.sau) && (this.sCX.sFy != 0L))
    {
      k.a(this.sCX);
      k.b(this.sCX);
      this.sau = true;
    }
    this.sau = false;
    this.sCJ = false;
    this.sCS = false;
    this.sDe = -1;
    this.sDg = false;
    this.sDf = false;
    this.sCX.reset();
    com.tencent.mm.plugin.fts.a.e.swW = com.tencent.mm.plugin.fts.a.d.Fx(3);
    this.sCX.sFy = com.tencent.mm.plugin.fts.a.e.swW;
    this.sCX.query = this.query;
    this.sCX.sCr = System.currentTimeMillis();
    this.sCZ = 0L;
    this.sDa = 0L;
    this.sDb = 0L;
    this.sDc = 0L;
    HashSet localHashSet = new HashSet();
    localHashSet.add("filehelper");
    boolean bool = u.ayd();
    if (!bool) {
      if (bs.getInt(com.tencent.mm.m.g.ZY().getValue("BindQQSwitch"), 1) != 1) {}
    }
    for (;;)
    {
      if (i == 0)
      {
        ac.i("MicroMsg.FTS.FTSMainAdapter", "summerqq BindQQSwitch off");
        localHashSet.add("22");
        localHashSet.add("23");
      }
      localHashSet.add("62");
      if (com.tencent.mm.aw.b.CQ((String)com.tencent.mm.kernel.g.agR().agA().get(274436, null)))
      {
        ac.i("MicroMsg.FTS.FTSMainAdapter", "checkLookVisibility EuropeanUnionCountry");
        localHashSet.add("65");
      }
      if (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).bIO()) {
        localHashSet.add("63");
      }
      for (;;)
      {
        if (!((com.tencent.mm.plugin.appbrand.service.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.e.class)).btZ()) {
          localHashSet.add("69");
        }
        if (!((com.tencent.mm.plugin.appbrand.service.h)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.h.class)).btZ()) {
          localHashSet.add("71");
        }
        c(localHashSet);
        this.sCW.a(this.query, this.sBM, null, com.tencent.mm.plugin.fts.a.e.swW);
        AppMethodBeat.o(111950);
        return;
        i = 0;
        break;
        localHashSet.add("67");
      }
      i = bool;
    }
  }
  
  public final boolean cLm()
  {
    return (this.sDg) && (this.sDf);
  }
  
  protected final void clearCache()
  {
    AppMethodBeat.i(111952);
    super.clearCache();
    Iterator localIterator = this.sCV.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.fts.a.d.e locale = (com.tencent.mm.plugin.fts.a.d.e)localIterator.next();
      locale.cKD();
      locale.clearData();
    }
    this.sCW.cKD();
    this.sCW.clearData();
    AppMethodBeat.o(111952);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(111951);
    if (!this.sCJ)
    {
      this.sCJ = true;
      if (!this.sCS) {
        k.a(this.query, false, cKF(), 0, this.sCX);
      }
    }
    if (!this.sau)
    {
      this.sau = true;
      k.a(this.sCX);
      k.b(this.sCX);
    }
    this.sCX.reset();
    super.finish();
    AppMethodBeat.o(111951);
  }
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(111957);
    super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    Object localObject1 = (FTSMainUI)this.sCp;
    paramInt1 = ((ListView)paramAbsListView).getHeaderViewsCount();
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if ((((FTSMainUI)localObject1).sDA == 1) && (paramAbsListView.getLastVisiblePosition() >= paramInt1 + ((FTSMainUI)localObject1).sDq.getCount()) && (((FTSMainUI)localObject1).sDq.cLm()) && (((FTSMainUI)localObject1).sDs.getVisibility() == 0))
    {
      ((FTSMainUI)localObject1).sDA = 2;
      localObject2 = ((FTSMainUI)localObject1).sDq.sCX;
      localObject3 = ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).sFV.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (com.tencent.mm.plugin.fts.a.a.c)((Iterator)localObject3).next();
        if ("SearchContactBar".equals(((com.tencent.mm.plugin.fts.a.a.c)localObject4).dpt)) {
          ((com.tencent.mm.plugin.fts.a.a.c)localObject4).sxH = (System.currentTimeMillis() - ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).sCr);
        }
      }
    }
    localObject1 = ((FTSMainUI)localObject1).sDo;
    paramInt1 = ((ListView)paramAbsListView).getHeaderViewsCount();
    if ((paramAbsListView.getLastVisiblePosition() >= ((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).sHc.sDq.getCount() + paramInt1) && (((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).sHc.sDq.cLm()) && (((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).sCc == 1) && (((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).sHV.getVisibility() == 0))
    {
      ac.i("MicroMsg.FTS.PardusSearchLogic", "onScroll webEntry hasResult:%s hasSug:%s", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).cZP), Boolean.valueOf(((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).sHL) });
      if (!((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).cZP)
      {
        ((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).sCc = 2;
        localObject2 = ((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).sHc.sDq.sCX;
        localObject3 = ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).sFV.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (com.tencent.mm.plugin.fts.a.a.c)((Iterator)localObject3).next();
          if ("SOSBar".equals(((com.tencent.mm.plugin.fts.a.a.c)localObject4).dpt)) {
            ((com.tencent.mm.plugin.fts.a.a.c)localObject4).sxH = (System.currentTimeMillis() - ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).sCr);
          }
        }
      }
    }
    if ((paramAbsListView.getLastVisiblePosition() >= paramInt1 + ((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).sHc.sDq.getCount()) && (((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).sHc.sDq.cLm()) && (((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).sHX.getVisibility() == 0) && (!((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).sHL))
    {
      paramInt3 = com.tencent.mm.cc.a.ih(((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).sHc);
      paramInt1 = 0;
      if (paramInt1 < ((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).sHX.getChildCount())
      {
        paramAbsListView = ((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).sHX.getChildAt(paramInt1);
        localObject2 = new int[2];
        paramAbsListView.getLocationOnScreen((int[])localObject2);
        paramInt2 = paramAbsListView.getMeasuredHeight();
        int i = localObject2[1];
        paramAbsListView = (agh)paramAbsListView.getTag();
        if (i + paramInt2 <= paramInt3)
        {
          localObject2 = ((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).sHc.sDq.sCX;
          localObject3 = paramAbsListView.Eyo;
          localObject3 = "SOSRelevant-" + ((dfn)localObject3).FrN;
          localObject4 = ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).sFV.iterator();
          while (((Iterator)localObject4).hasNext())
          {
            com.tencent.mm.plugin.fts.a.a.c localc = (com.tencent.mm.plugin.fts.a.a.c)((Iterator)localObject4).next();
            if ((((String)localObject3).equals(localc.dpt)) && (localc.sxH == 0L)) {
              localc.sxH = (System.currentTimeMillis() - ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).sCr);
            }
          }
        }
        for (paramInt2 = 1;; paramInt2 = 0)
        {
          if (paramInt2 != 0) {
            ((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).e(0, "", "", "", paramAbsListView.Eyo.FrN);
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
      this.muG = true;
      ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSImageLoader().cKi();
      o.xMa.pause();
      AppMethodBeat.o(111958);
      return;
    }
    this.muG = false;
    if (!((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSImageLoader().cKj())
    {
      this.sDd.removeMessages(1);
      this.sDd.sendEmptyMessageDelayed(1, 200L);
    }
    AppMethodBeat.o(111958);
  }
  
  public final void stopSearch()
  {
    AppMethodBeat.i(111953);
    this.sDd.removeMessages(1);
    super.stopSearch();
    AppMethodBeat.o(111953);
  }
  
  final class a
    implements Runnable
  {
    private String query;
    private com.tencent.mm.plugin.fts.a.d.e sDi;
    
    a(com.tencent.mm.plugin.fts.a.d.e parame, String paramString)
    {
      this.query = paramString;
      this.sDi = parame;
    }
    
    public final void run()
    {
      AppMethodBeat.i(111946);
      if ((!j.a(j.this)) && (((com.tencent.mm.plugin.fts.a.d.e)j.b(j.this).get(j.b(j.this).size() - 1)).getType() == this.sDi.getType())) {
        j.c(j.this);
      }
      if ((!j.d(j.this)) && (this.sDi.getType() == 256)) {
        j.e(j.this);
      }
      j.f(j.this).sFS = j.this.cLm();
      Object localObject1 = j.b(j.this).iterator();
      for (int i = 0; ((Iterator)localObject1).hasNext(); i = ((com.tencent.mm.plugin.fts.a.d.e)((Iterator)localObject1).next()).FB(i)) {}
      i = j.g(j.this).FB(i);
      j.this.setCount(i);
      j.this.notifyDataSetChanged();
      localObject1 = j.this;
      ((j)localObject1).ah(i, ((j)localObject1).cLm());
      if (j.this.cLm()) {
        j.f(j.this).sFw = System.currentTimeMillis();
      }
      localObject1 = j.f(j.this);
      Object localObject2 = this.sDi;
      ((com.tencent.mm.plugin.fts.ui.c.b)localObject1).sFV.addAll(((com.tencent.mm.plugin.fts.a.d.e)localObject2).vu(((com.tencent.mm.plugin.fts.ui.c.b)localObject1).sCr));
      localObject1 = j.f(j.this);
      ((com.tencent.mm.plugin.fts.ui.c.b)localObject1).sFP = i;
      localObject2 = ((com.tencent.mm.plugin.fts.ui.c.b)localObject1).sFV.iterator();
      com.tencent.mm.plugin.fts.a.a.c localc;
      while (((Iterator)localObject2).hasNext())
      {
        localc = (com.tencent.mm.plugin.fts.a.a.c)((Iterator)localObject2).next();
        if ("SearchContactBar".equals(localc.dpt)) {
          localc.position = (((com.tencent.mm.plugin.fts.ui.c.b)localObject1).sFP + 1);
        }
      }
      localObject2 = ((com.tencent.mm.plugin.fts.ui.c.b)localObject1).sFV.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localc = (com.tencent.mm.plugin.fts.a.a.c)((Iterator)localObject2).next();
        if ("SOSBar".equals(localc.dpt)) {
          if ((((com.tencent.mm.plugin.fts.ui.c.b)localObject1).sFL > 0) || (((com.tencent.mm.plugin.fts.ui.c.b)localObject1).sFM > 0)) {
            localc.position = (((com.tencent.mm.plugin.fts.ui.c.b)localObject1).sFP + 2);
          } else {
            localc.position = (((com.tencent.mm.plugin.fts.ui.c.b)localObject1).sFP + 1);
          }
        }
      }
      if ((((com.tencent.mm.plugin.fts.ui.c.b)localObject1).sFL > 0) || (((com.tencent.mm.plugin.fts.ui.c.b)localObject1).sFM > 0)) {}
      for (i = ((com.tencent.mm.plugin.fts.ui.c.b)localObject1).sFP + 3;; i = ((com.tencent.mm.plugin.fts.ui.c.b)localObject1).sFP + 2)
      {
        localObject1 = ((com.tencent.mm.plugin.fts.ui.c.b)localObject1).sFV.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (com.tencent.mm.plugin.fts.a.a.c)((Iterator)localObject1).next();
          if (((com.tencent.mm.plugin.fts.a.a.c)localObject2).dpt.startsWith("SOSRelevant")) {
            ((com.tencent.mm.plugin.fts.a.a.c)localObject2).position = i;
          }
        }
      }
      AppMethodBeat.o(111946);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.j
 * JD-Core Version:    0.7.0.1
 */