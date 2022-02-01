package com.tencent.mm.plugin.fts.ui;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ss;
import com.tencent.mm.g.a.ss.b;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.appbrand.service.f;
import com.tencent.mm.plugin.fts.a.d.e.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.ui.a.i;
import com.tencent.mm.plugin.fts.ui.b.l;
import com.tencent.mm.plugin.sns.c.o;
import com.tencent.mm.protocal.protobuf.afi;
import com.tencent.mm.protocal.protobuf.dab;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class j
  extends d
  implements e.b
{
  private boolean lSE;
  private ap rsS;
  public boolean rtQ;
  public boolean rtZ;
  List<com.tencent.mm.plugin.fts.a.d.e> ruc;
  private com.tencent.mm.plugin.fts.ui.d.n rud;
  public com.tencent.mm.plugin.fts.ui.c.b rue;
  com.tencent.mm.plugin.fts.ui.widget.d ruf;
  private boolean rug;
  private long ruh;
  private long rui;
  private long ruj;
  private long ruk;
  private ap rul;
  private int rum;
  private boolean run;
  boolean ruo;
  
  public j(e parame, int paramInt, com.tencent.mm.plugin.fts.ui.widget.d paramd)
  {
    super(parame);
    AppMethodBeat.i(184530);
    this.rul = new ap(Looper.getMainLooper())
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
          if ((!j.h(j.this)) && (j.this.getCount() > 0))
          {
            ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSImageLoader().cwY();
            o.wzG.start();
            j.this.notifyDataSetChanged();
          }
        }
      }
    };
    this.rsS = new ap(Looper.getMainLooper());
    this.rum = -1;
    this.ruf = paramd;
    this.rue = new com.tencent.mm.plugin.fts.ui.c.b();
    parame = new HashSet();
    parame.add(Integer.valueOf(16));
    parame.add(Integer.valueOf(32));
    parame.add(Integer.valueOf(48));
    parame.add(Integer.valueOf(64));
    parame.add(Integer.valueOf(128));
    parame.add(Integer.valueOf(96));
    parame.add(Integer.valueOf(112));
    if (com.tencent.mm.kernel.g.afw())
    {
      paramd = new ss();
      com.tencent.mm.sdk.b.a.ESL.l(paramd);
      com.tencent.mm.storage.c localc = com.tencent.mm.model.c.d.aty().qu("100193");
      if ((!localc.isValid()) || (!"1".equals(localc.eJy().get("isOpenLocalSearch"))) || (!paramd.dyi.dyk)) {}
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        parame.add(Integer.valueOf(144));
      }
      this.ruc = ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).createFTSUIUnitList(parame, getContext(), this, paramInt);
      this.rud = ((com.tencent.mm.plugin.fts.ui.d.n)new l().a(getContext(), this, paramInt));
      AppMethodBeat.o(184530);
      return;
    }
  }
  
  private void c(HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(111956);
    this.rum += 1;
    if (this.rum < this.ruc.size()) {
      ((com.tencent.mm.plugin.fts.a.d.e)this.ruc.get(this.rum)).a(this.query, this.rsS, paramHashSet, com.tencent.mm.plugin.fts.a.e.roc);
    }
    AppMethodBeat.o(111956);
  }
  
  protected final com.tencent.mm.plugin.fts.a.d.a.a DG(int paramInt)
  {
    AppMethodBeat.i(111948);
    long l = 0L;
    com.tencent.mm.plugin.fts.a.d.a.a locala = null;
    Object localObject1 = this.ruc.iterator();
    for (;;)
    {
      Object localObject2;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.tencent.mm.plugin.fts.a.d.e)((Iterator)localObject1).next();
        locala = ((com.tencent.mm.plugin.fts.a.d.e)localObject2).DG(paramInt);
        l = ((com.tencent.mm.plugin.fts.a.d.e)localObject2).cxu();
        if (locala == null) {}
      }
      else
      {
        for (;;)
        {
          if (locala == null)
          {
            locala = this.rud.DG(paramInt);
            l = this.rud.rqH;
          }
          for (;;)
          {
            if (locala != null)
            {
              localObject1 = new LinkedList();
              localObject2 = this.ruc.iterator();
              while (((Iterator)localObject2).hasNext()) {
                ((LinkedList)localObject1).addAll(((com.tencent.mm.plugin.fts.a.d.e)((Iterator)localObject2).next()).cxs());
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
              locala.rqA = i;
              locala.pageType = 1;
              locala.rqH = l;
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
  
  public final void DJ(int paramInt)
  {
    this.rue.rwY = paramInt;
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.d.e parame, String paramString)
  {
    AppMethodBeat.i(111955);
    if ((parame instanceof a))
    {
      Object localObject = (a)parame;
      if (paramString.equals(this.query)) {
        c(((a)localObject).rpM);
      }
      if ((((a)localObject).cxL() > 0) && (this.ruh == 0L))
      {
        this.ruh = (System.currentTimeMillis() - this.rty);
        k.af(9, this.ruh);
        ad.i("MicroMsg.FTS.FTSMainAdapter", "firstItemTime=%d", new Object[] { Long.valueOf(this.ruh) });
      }
      switch (((a)localObject).getType())
      {
      default: 
        label140:
        localb = this.rue;
        localObject = ((a)localObject).rsD.iterator();
      }
      for (;;)
      {
        if (!((Iterator)localObject).hasNext()) {
          break label571;
        }
        e.a locala = (e.a)((Iterator)localObject).next();
        int j = locala.kLN.size();
        if (locala.qpI) {}
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
            localb.rwO = i;
            break;
            if (this.rui != 0L) {
              break label140;
            }
            this.rui = (System.currentTimeMillis() - this.rty);
            ad.i("MicroMsg.FTS.FTSMainAdapter", "firstGetTopHitsTime=%d", new Object[] { Long.valueOf(this.rui) });
            k.af(0, this.rui);
            break label140;
            if (this.ruj != 0L) {
              break label140;
            }
            this.ruj = (System.currentTimeMillis() - this.rty);
            ad.i("MicroMsg.FTS.FTSMainAdapter", "firstGetContactTime=%d", new Object[] { Long.valueOf(this.ruj) });
            k.af(3, this.ruj);
            break label140;
            if (this.ruk != 0L) {
              break label140;
            }
            this.ruk = (System.currentTimeMillis() - this.rty);
            ad.i("MicroMsg.FTS.FTSMainAdapter", "firstGetChatroomTime=%d", new Object[] { Long.valueOf(this.ruk) });
            k.af(6, this.ruk);
            break label140;
          }
        }
        localb.rwL = i;
        continue;
        localb.rwI = i;
        continue;
        localb.rwM = i;
        continue;
        localb.rwJ = i;
        continue;
        localb.favCount = i;
        continue;
        localb.rwN = i;
        continue;
        localb.rwK = i;
        continue;
        localb.rwH = i;
      }
    }
    com.tencent.mm.plugin.fts.ui.c.b localb = this.rue;
    if (parame.cxt() > 0)
    {
      if (parame.cxq() != 2) {
        break label602;
      }
      localb.rwQ = parame.cxt();
    }
    for (;;)
    {
      label571:
      this.rue.rxb = cxt();
      new a(parame, paramString).run();
      AppMethodBeat.o(111955);
      return;
      label602:
      localb.rwP = parame.cxt();
    }
  }
  
  protected final boolean a(View paramView, com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(111954);
    Iterator localIterator = this.ruc.iterator();
    boolean bool;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      bool = ((com.tencent.mm.plugin.fts.a.d.e)localIterator.next()).a(paramView, parama, paramBoolean);
      paramBoolean = bool;
    } while (!bool);
    if ((!this.rtQ) && (!(parama instanceof com.tencent.mm.plugin.fts.ui.a.n)))
    {
      k.a(this.query, true, cxt(), 0, this.rue);
      this.rtQ = true;
    }
    if (parama.rqI)
    {
      ad.d("MicroMsg.FTS.FTSMainAdapter", "searchType=%d | searchScene=%d | kvPosition=%d | kvSubPosition=%d | kvSearchId=%s | kvDocId=%d", new Object[] { Integer.valueOf(parama.oEL), Integer.valueOf(parama.kme), Integer.valueOf(parama.rqA), Integer.valueOf(parama.rqB), parama.rqC, Long.valueOf(parama.rqD) });
      this.ruf.DR(1);
      this.rue.b(parama);
      k.a(parama, this.rue);
      AppMethodBeat.o(111954);
      return true;
    }
    if ((parama instanceof com.tencent.mm.plugin.fts.ui.a.h))
    {
      this.rtZ = true;
      this.ruf.DR(1);
      this.rue.b(parama);
      k.a(parama, this.rue);
    }
    for (;;)
    {
      AppMethodBeat.o(111954);
      return false;
      if ((parama instanceof i))
      {
        k.a(parama, this.rue);
        this.rue.b(parama);
      }
    }
  }
  
  protected final void b(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a parama)
  {
    AppMethodBeat.i(111949);
    super.b(paramContext, parama);
    paramContext = this.rue;
    Iterator localIterator;
    switch (parama.nBH)
    {
    default: 
      localIterator = paramContext.rxd.iterator();
    }
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.fts.a.a.c localc = (com.tencent.mm.plugin.fts.a.a.c)localIterator.next();
      if (localc.position == parama.position)
      {
        localc.exposeTime = (System.currentTimeMillis() - paramContext.rty);
        AppMethodBeat.o(111949);
        return;
        AppMethodBeat.o(111949);
        return;
      }
    }
    AppMethodBeat.o(111949);
  }
  
  protected final void clearCache()
  {
    AppMethodBeat.i(111952);
    super.clearCache();
    Iterator localIterator = this.ruc.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.fts.a.d.e locale = (com.tencent.mm.plugin.fts.a.d.e)localIterator.next();
      locale.cxr();
      locale.clearData();
    }
    this.rud.cxr();
    this.rud.clearData();
    AppMethodBeat.o(111952);
  }
  
  protected final void cxM()
  {
    int i = 1;
    AppMethodBeat.i(111950);
    if ((!bt.isNullOrNil(this.rue.query)) && (!this.rug) && (this.rue.rwG != 0L))
    {
      k.a(this.rue);
      k.b(this.rue);
      this.rug = true;
    }
    this.rug = false;
    this.rtQ = false;
    this.rtZ = false;
    this.rum = -1;
    this.ruo = false;
    this.run = false;
    this.rue.reset();
    com.tencent.mm.plugin.fts.a.e.roc = com.tencent.mm.plugin.fts.a.d.DB(3);
    this.rue.rwG = com.tencent.mm.plugin.fts.a.e.roc;
    this.rue.query = this.query;
    this.rue.rty = System.currentTimeMillis();
    this.ruh = 0L;
    this.rui = 0L;
    this.ruj = 0L;
    this.ruk = 0L;
    HashSet localHashSet = new HashSet();
    localHashSet.add("filehelper");
    boolean bool = u.arn();
    if (!bool) {
      if (bt.getInt(com.tencent.mm.m.g.Zd().getValue("BindQQSwitch"), 1) != 1) {}
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
      if (com.tencent.mm.ax.b.yL((String)com.tencent.mm.kernel.g.afB().afk().get(274436, null)))
      {
        ad.i("MicroMsg.FTS.FTSMainAdapter", "checkLookVisibility EuropeanUnionCountry");
        localHashSet.add("65");
      }
      if (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).bBQ()) {
        localHashSet.add("63");
      }
      for (;;)
      {
        if (!((f)com.tencent.mm.kernel.g.ab(f.class)).bnd()) {
          localHashSet.add("69");
        }
        if (!((com.tencent.mm.plugin.appbrand.service.h)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.h.class)).bnd()) {
          localHashSet.add("71");
        }
        c(localHashSet);
        this.rud.a(this.query, this.rsS, null, com.tencent.mm.plugin.fts.a.e.roc);
        AppMethodBeat.o(111950);
        return;
        i = 0;
        break;
        localHashSet.add("67");
      }
      i = bool;
    }
  }
  
  protected final int cxt()
  {
    AppMethodBeat.i(111959);
    Iterator localIterator = this.ruc.iterator();
    for (int i = 0; localIterator.hasNext(); i = ((com.tencent.mm.plugin.fts.a.d.e)localIterator.next()).cxt() + i) {}
    int j = this.rud.cxt();
    AppMethodBeat.o(111959);
    return j + i;
  }
  
  public final boolean cya()
  {
    return (this.ruo) && (this.run);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(111951);
    if (!this.rtQ)
    {
      this.rtQ = true;
      if (!this.rtZ) {
        k.a(this.query, false, cxt(), 0, this.rue);
      }
    }
    if (!this.rug)
    {
      this.rug = true;
      k.a(this.rue);
      k.b(this.rue);
    }
    this.rue.reset();
    super.finish();
    AppMethodBeat.o(111951);
  }
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(111957);
    super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    Object localObject1 = (FTSMainUI)this.rtw;
    paramInt1 = ((ListView)paramAbsListView).getHeaderViewsCount();
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if ((((FTSMainUI)localObject1).ruI == 1) && (paramAbsListView.getLastVisiblePosition() >= paramInt1 + ((FTSMainUI)localObject1).ruy.getCount()) && (((FTSMainUI)localObject1).ruy.cya()) && (((FTSMainUI)localObject1).ruA.getVisibility() == 0))
    {
      ((FTSMainUI)localObject1).ruI = 2;
      localObject2 = ((FTSMainUI)localObject1).ruy.rue;
      localObject3 = ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).rxd.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (com.tencent.mm.plugin.fts.a.a.c)((Iterator)localObject3).next();
        if ("SearchContactBar".equals(((com.tencent.mm.plugin.fts.a.a.c)localObject4).drI)) {
          ((com.tencent.mm.plugin.fts.a.a.c)localObject4).exposeTime = (System.currentTimeMillis() - ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).rty);
        }
      }
    }
    localObject1 = ((FTSMainUI)localObject1).ruw;
    paramInt1 = ((ListView)paramAbsListView).getHeaderViewsCount();
    if ((paramAbsListView.getLastVisiblePosition() >= ((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).ryk.ruy.getCount() + paramInt1) && (((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).ryk.ruy.cya()) && (((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).rti == 1) && (((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).rzd.getVisibility() == 0))
    {
      ad.i("MicroMsg.FTS.PardusSearchLogic", "onScroll webEntry hasResult:%s hasSug:%s", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).dcq), Boolean.valueOf(((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).ryT) });
      if (!((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).dcq)
      {
        ((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).rti = 2;
        localObject2 = ((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).ryk.ruy.rue;
        localObject3 = ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).rxd.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (com.tencent.mm.plugin.fts.a.a.c)((Iterator)localObject3).next();
          if ("SOSBar".equals(((com.tencent.mm.plugin.fts.a.a.c)localObject4).drI)) {
            ((com.tencent.mm.plugin.fts.a.a.c)localObject4).exposeTime = (System.currentTimeMillis() - ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).rty);
          }
        }
      }
    }
    if ((paramAbsListView.getLastVisiblePosition() >= paramInt1 + ((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).ryk.ruy.getCount()) && (((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).ryk.ruy.cya()) && (((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).rzf.getVisibility() == 0) && (!((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).ryT))
    {
      paramInt3 = com.tencent.mm.cd.a.hW(((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).ryk);
      paramInt1 = 0;
      if (paramInt1 < ((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).rzf.getChildCount())
      {
        paramAbsListView = ((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).rzf.getChildAt(paramInt1);
        localObject2 = new int[2];
        paramAbsListView.getLocationOnScreen((int[])localObject2);
        paramInt2 = paramAbsListView.getMeasuredHeight();
        int i = localObject2[1];
        paramAbsListView = (afi)paramAbsListView.getTag();
        if (i + paramInt2 <= paramInt3)
        {
          localObject2 = ((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).ryk.ruy.rue;
          localObject3 = paramAbsListView.Dfi;
          localObject3 = "SOSRelevant-" + ((dab)localObject3).DUZ;
          localObject4 = ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).rxd.iterator();
          while (((Iterator)localObject4).hasNext())
          {
            com.tencent.mm.plugin.fts.a.a.c localc = (com.tencent.mm.plugin.fts.a.a.c)((Iterator)localObject4).next();
            if ((((String)localObject3).equals(localc.drI)) && (localc.exposeTime == 0L)) {
              localc.exposeTime = (System.currentTimeMillis() - ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).rty);
            }
          }
        }
        for (paramInt2 = 1;; paramInt2 = 0)
        {
          if (paramInt2 != 0) {
            ((com.tencent.mm.plugin.fts.ui.widget.d)localObject1).e(0, "", "", "", paramAbsListView.Dfi.DUZ);
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
      this.lSE = true;
      ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSImageLoader().cwW();
      o.wzG.pause();
      AppMethodBeat.o(111958);
      return;
    }
    this.lSE = false;
    if (!((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSImageLoader().cwX())
    {
      this.rul.removeMessages(1);
      this.rul.sendEmptyMessageDelayed(1, 200L);
    }
    AppMethodBeat.o(111958);
  }
  
  public final void stopSearch()
  {
    AppMethodBeat.i(111953);
    this.rul.removeMessages(1);
    super.stopSearch();
    AppMethodBeat.o(111953);
  }
  
  final class a
    implements Runnable
  {
    private String query;
    private com.tencent.mm.plugin.fts.a.d.e ruq;
    
    a(com.tencent.mm.plugin.fts.a.d.e parame, String paramString)
    {
      this.query = paramString;
      this.ruq = parame;
    }
    
    public final void run()
    {
      AppMethodBeat.i(111946);
      if ((!j.a(j.this)) && (((com.tencent.mm.plugin.fts.a.d.e)j.b(j.this).get(j.b(j.this).size() - 1)).getType() == this.ruq.getType())) {
        j.c(j.this);
      }
      if ((!j.d(j.this)) && (this.ruq.getType() == 256)) {
        j.e(j.this);
      }
      j.f(j.this).rxa = j.this.cya();
      Object localObject1 = j.b(j.this).iterator();
      for (int i = 0; ((Iterator)localObject1).hasNext(); i = ((com.tencent.mm.plugin.fts.a.d.e)((Iterator)localObject1).next()).DF(i)) {}
      i = j.g(j.this).DF(i);
      j.this.setCount(i);
      j.this.notifyDataSetChanged();
      localObject1 = j.this;
      ((j)localObject1).ae(i, ((j)localObject1).cya());
      if (j.this.cya()) {
        j.f(j.this).rwE = System.currentTimeMillis();
      }
      localObject1 = j.f(j.this);
      Object localObject2 = this.ruq;
      ((com.tencent.mm.plugin.fts.ui.c.b)localObject1).rxd.addAll(((com.tencent.mm.plugin.fts.a.d.e)localObject2).qR(((com.tencent.mm.plugin.fts.ui.c.b)localObject1).rty));
      localObject1 = j.f(j.this);
      ((com.tencent.mm.plugin.fts.ui.c.b)localObject1).rwX = i;
      localObject2 = ((com.tencent.mm.plugin.fts.ui.c.b)localObject1).rxd.iterator();
      com.tencent.mm.plugin.fts.a.a.c localc;
      while (((Iterator)localObject2).hasNext())
      {
        localc = (com.tencent.mm.plugin.fts.a.a.c)((Iterator)localObject2).next();
        if ("SearchContactBar".equals(localc.drI)) {
          localc.position = (((com.tencent.mm.plugin.fts.ui.c.b)localObject1).rwX + 1);
        }
      }
      localObject2 = ((com.tencent.mm.plugin.fts.ui.c.b)localObject1).rxd.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localc = (com.tencent.mm.plugin.fts.a.a.c)((Iterator)localObject2).next();
        if ("SOSBar".equals(localc.drI)) {
          if ((((com.tencent.mm.plugin.fts.ui.c.b)localObject1).rwT > 0) || (((com.tencent.mm.plugin.fts.ui.c.b)localObject1).rwU > 0)) {
            localc.position = (((com.tencent.mm.plugin.fts.ui.c.b)localObject1).rwX + 2);
          } else {
            localc.position = (((com.tencent.mm.plugin.fts.ui.c.b)localObject1).rwX + 1);
          }
        }
      }
      if ((((com.tencent.mm.plugin.fts.ui.c.b)localObject1).rwT > 0) || (((com.tencent.mm.plugin.fts.ui.c.b)localObject1).rwU > 0)) {}
      for (i = ((com.tencent.mm.plugin.fts.ui.c.b)localObject1).rwX + 3;; i = ((com.tencent.mm.plugin.fts.ui.c.b)localObject1).rwX + 2)
      {
        localObject1 = ((com.tencent.mm.plugin.fts.ui.c.b)localObject1).rxd.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (com.tencent.mm.plugin.fts.a.a.c)((Iterator)localObject1).next();
          if (((com.tencent.mm.plugin.fts.a.a.c)localObject2).drI.startsWith("SOSRelevant")) {
            ((com.tencent.mm.plugin.fts.a.a.c)localObject2).position = i;
          }
        }
      }
      AppMethodBeat.o(111946);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.j
 * JD-Core Version:    0.7.0.1
 */