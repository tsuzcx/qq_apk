package com.tencent.mm.plugin.fts.ui;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.us;
import com.tencent.mm.g.a.us.b;
import com.tencent.mm.model.z;
import com.tencent.mm.n.f;
import com.tencent.mm.plugin.fts.a.d.e.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.protocal.protobuf.alv;
import com.tencent.mm.protocal.protobuf.efk;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class k
  extends d
  implements e.b
{
  private boolean wrW;
  private MMHandler xad;
  List<com.tencent.mm.plugin.fts.a.d.e> xbB;
  private com.tencent.mm.plugin.fts.ui.d.n xbC;
  public com.tencent.mm.plugin.fts.ui.c.b xbD;
  com.tencent.mm.plugin.fts.ui.widget.i xbE;
  private long xbF;
  private long xbG;
  private long xbH;
  private long xbI;
  private MMHandler xbJ;
  private int xbK;
  private boolean xbL;
  boolean xbM;
  public boolean xbo;
  private boolean xbw;
  public boolean xby;
  
  public k(e parame, int paramInt, com.tencent.mm.plugin.fts.ui.widget.i parami)
  {
    super(parame);
    AppMethodBeat.i(184530);
    this.xbJ = new MMHandler(Looper.getMainLooper())
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
            ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.fts.a.n.class)).getFTSImageLoader().dOn();
            o.DCM.start();
            k.this.notifyDataSetChanged();
          }
        }
      }
    };
    this.xad = new MMHandler(Looper.getMainLooper());
    this.xbK = -1;
    this.xbE = parami;
    this.xbD = new com.tencent.mm.plugin.fts.ui.c.b();
    parame = new HashSet();
    parame.add(Integer.valueOf(16));
    parame.add(Integer.valueOf(32));
    parame.add(Integer.valueOf(48));
    parame.add(Integer.valueOf(64));
    parame.add(Integer.valueOf(128));
    parame.add(Integer.valueOf(96));
    parame.add(Integer.valueOf(112));
    if (com.tencent.mm.kernel.g.aAc())
    {
      parami = new us();
      EventCenter.instance.publish(parami);
      com.tencent.mm.storage.c localc = com.tencent.mm.model.c.d.aXu().Fu("100193");
      if ((!localc.isValid()) || (!"1".equals(localc.gzz().get("isOpenLocalSearch"))) || (!parami.eaV.eaX)) {}
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        parame.add(Integer.valueOf(144));
      }
      this.xbB = ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.fts.a.n.class)).createFTSUIUnitList(parame, getContext(), this, paramInt);
      this.xbC = ((com.tencent.mm.plugin.fts.ui.d.n)new com.tencent.mm.plugin.fts.ui.b.l().a(getContext(), this, paramInt));
      AppMethodBeat.o(184530);
      return;
    }
  }
  
  private void b(HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(111956);
    this.xbK += 1;
    if (this.xbK < this.xbB.size()) {
      ((com.tencent.mm.plugin.fts.a.d.e)this.xbB.get(this.xbK)).a(this.query, this.xad, paramHashSet, com.tencent.mm.plugin.fts.a.e.wVn);
    }
    AppMethodBeat.o(111956);
  }
  
  protected final com.tencent.mm.plugin.fts.a.d.a.a No(int paramInt)
  {
    AppMethodBeat.i(111948);
    long l = 0L;
    com.tencent.mm.plugin.fts.a.d.a.a locala = null;
    Object localObject1 = this.xbB.iterator();
    for (;;)
    {
      Object localObject2;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.tencent.mm.plugin.fts.a.d.e)((Iterator)localObject1).next();
        locala = ((com.tencent.mm.plugin.fts.a.d.e)localObject2).No(paramInt);
        l = ((com.tencent.mm.plugin.fts.a.d.e)localObject2).dOJ();
        if (locala == null) {}
      }
      else
      {
        for (;;)
        {
          if (locala == null)
          {
            locala = this.xbC.No(paramInt);
            l = this.xbC.wXS;
          }
          for (;;)
          {
            if (locala != null)
            {
              localObject1 = new LinkedList();
              localObject2 = this.xbB.iterator();
              while (((Iterator)localObject2).hasNext()) {
                ((LinkedList)localObject1).addAll(((com.tencent.mm.plugin.fts.a.d.e)((Iterator)localObject2).next()).dOH());
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
              locala.wXL = i;
              locala.pageType = 1;
              locala.wXS = l;
              if (locala == null) {
                Log.e("MicroMsg.FTS.FTSMainAdapter", "Create Data Item Error: getCount-%d position-%d", new Object[] { Integer.valueOf(getCount()), Integer.valueOf(paramInt) });
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
  
  public final void Nr(int paramInt)
  {
    this.xbD.xeB = paramInt;
  }
  
  protected final void a(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a parama)
  {
    AppMethodBeat.i(111949);
    super.a(paramContext, parama);
    paramContext = this.xbD;
    Iterator localIterator;
    switch (parama.qcr)
    {
    default: 
      localIterator = paramContext.xeG.iterator();
    }
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.fts.a.a.c localc = (com.tencent.mm.plugin.fts.a.a.c)localIterator.next();
      if (localc.position == parama.position)
      {
        localc.wVY = (System.currentTimeMillis() - paramContext.xaI);
        AppMethodBeat.o(111949);
        return;
        AppMethodBeat.o(111949);
        return;
      }
    }
    AppMethodBeat.o(111949);
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.d.e parame, String paramString)
  {
    AppMethodBeat.i(111955);
    if ((parame instanceof a))
    {
      Object localObject = (a)parame;
      if (paramString.equals(this.query)) {
        b(((a)localObject).wWX);
      }
      if ((((a)localObject).dPa() > 0) && (this.xbF == 0L))
      {
        this.xbF = (System.currentTimeMillis() - this.xaI);
        l.ao(9, this.xbF);
        Log.i("MicroMsg.FTS.FTSMainAdapter", "firstItemTime=%d", new Object[] { Long.valueOf(this.xbF) });
      }
      switch (((a)localObject).getType())
      {
      default: 
        label140:
        localb = this.xbD;
        localObject = ((a)localObject).wZO.iterator();
      }
      for (;;)
      {
        if (!((Iterator)localObject).hasNext()) {
          break label571;
        }
        e.a locala = (e.a)((Iterator)localObject).next();
        int j = locala.mWl.size();
        if (locala.tuG) {}
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
            localb.xer = i;
            break;
            if (this.xbG != 0L) {
              break label140;
            }
            this.xbG = (System.currentTimeMillis() - this.xaI);
            Log.i("MicroMsg.FTS.FTSMainAdapter", "firstGetTopHitsTime=%d", new Object[] { Long.valueOf(this.xbG) });
            l.ao(0, this.xbG);
            break label140;
            if (this.xbH != 0L) {
              break label140;
            }
            this.xbH = (System.currentTimeMillis() - this.xaI);
            Log.i("MicroMsg.FTS.FTSMainAdapter", "firstGetContactTime=%d", new Object[] { Long.valueOf(this.xbH) });
            l.ao(3, this.xbH);
            break label140;
            if (this.xbI != 0L) {
              break label140;
            }
            this.xbI = (System.currentTimeMillis() - this.xaI);
            Log.i("MicroMsg.FTS.FTSMainAdapter", "firstGetChatroomTime=%d", new Object[] { Long.valueOf(this.xbI) });
            l.ao(6, this.xbI);
            break label140;
          }
        }
        localb.xeo = i;
        continue;
        localb.xel = i;
        continue;
        localb.xep = i;
        continue;
        localb.xem = i;
        continue;
        localb.favCount = i;
        continue;
        localb.xeq = i;
        continue;
        localb.xen = i;
        continue;
        localb.xek = i;
      }
    }
    com.tencent.mm.plugin.fts.ui.c.b localb = this.xbD;
    if (parame.dOI() > 0)
    {
      if (parame.dOF() != 2) {
        break label602;
      }
      localb.xet = parame.dOI();
    }
    for (;;)
    {
      label571:
      this.xbD.xeE = dOI();
      new a(parame, paramString).run();
      AppMethodBeat.o(111955);
      return;
      label602:
      localb.xes = parame.dOI();
    }
  }
  
  protected final boolean a(View paramView, com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(111954);
    Iterator localIterator = this.xbB.iterator();
    boolean bool;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      bool = ((com.tencent.mm.plugin.fts.a.d.e)localIterator.next()).a(paramView, parama, paramBoolean);
      paramBoolean = bool;
    } while (!bool);
    if ((!this.xbo) && (!(parama instanceof com.tencent.mm.plugin.fts.ui.a.n)))
    {
      l.a(this.query, true, dOI(), 0, this.xbD);
      this.xbo = true;
    }
    if (parama.wXT)
    {
      Log.d("MicroMsg.FTS.FTSMainAdapter", "searchType=%d | searchScene=%d | kvPosition=%d | kvSubPosition=%d | kvSearchId=%s | kvDocId=%d", new Object[] { Integer.valueOf(parama.rjr), Integer.valueOf(parama.mve), Integer.valueOf(parama.wXL), Integer.valueOf(parama.wXM), parama.wXN, Long.valueOf(parama.wXO) });
      this.xbE.Nz(1);
      this.xbD.b(parama);
      l.a(parama, this.xbD);
      AppMethodBeat.o(111954);
      return true;
    }
    if ((parama instanceof com.tencent.mm.plugin.fts.ui.a.h))
    {
      this.xby = true;
      this.xbE.Nz(1);
      this.xbD.b(parama);
      l.a(parama, this.xbD);
    }
    for (;;)
    {
      AppMethodBeat.o(111954);
      return false;
      if ((parama instanceof com.tencent.mm.plugin.fts.ui.a.i))
      {
        l.a(parama, this.xbD);
        this.xbD.b(parama);
      }
    }
  }
  
  protected final void clearCache()
  {
    AppMethodBeat.i(111952);
    super.clearCache();
    Iterator localIterator = this.xbB.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.fts.a.d.e locale = (com.tencent.mm.plugin.fts.a.d.e)localIterator.next();
      locale.dOG();
      locale.clearData();
    }
    this.xbC.dOG();
    this.xbC.clearData();
    AppMethodBeat.o(111952);
  }
  
  protected final int dOI()
  {
    AppMethodBeat.i(111959);
    Iterator localIterator = this.xbB.iterator();
    for (int i = 0; localIterator.hasNext(); i = ((com.tencent.mm.plugin.fts.a.d.e)localIterator.next()).dOI() + i) {}
    int j = this.xbC.dOI();
    AppMethodBeat.o(111959);
    return j + i;
  }
  
  protected final void dPb()
  {
    int i = 1;
    AppMethodBeat.i(111950);
    if ((!Util.isNullOrNil(this.xbD.query)) && (!this.wrW) && (this.xbD.xej != 0L))
    {
      l.a(this.xbD);
      l.b(this.xbD);
      this.wrW = true;
    }
    this.wrW = false;
    this.xbo = false;
    this.xby = false;
    this.xbK = -1;
    this.xbM = false;
    this.xbL = false;
    this.xbD.reset();
    com.tencent.mm.plugin.fts.a.e.wVn = com.tencent.mm.plugin.fts.a.d.Ni(3);
    this.xbD.xej = com.tencent.mm.plugin.fts.a.e.wVn;
    this.xbD.query = this.query;
    this.xbD.xaI = System.currentTimeMillis();
    this.xbF = 0L;
    this.xbG = 0L;
    this.xbH = 0L;
    this.xbI = 0L;
    HashSet localHashSet = new HashSet();
    localHashSet.add("filehelper");
    boolean bool = z.aUM();
    if (!bool) {
      if (Util.getInt(com.tencent.mm.n.h.aqJ().getValue("BindQQSwitch"), 1) != 1) {}
    }
    for (;;)
    {
      if (i == 0)
      {
        Log.i("MicroMsg.FTS.FTSMainAdapter", "summerqq BindQQSwitch off");
        localHashSet.add("22");
        localHashSet.add("23");
      }
      localHashSet.add("62");
      if (com.tencent.mm.aw.b.Pi((String)com.tencent.mm.kernel.g.aAh().azQ().get(274436, null)))
      {
        Log.i("MicroMsg.FTS.FTSMainAdapter", "checkLookVisibility EuropeanUnionCountry");
        localHashSet.add("65");
      }
      if (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).clc()) {
        localHashSet.add("63");
      }
      for (;;)
      {
        if (!((com.tencent.mm.plugin.appbrand.service.e)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.service.e.class)).bVr()) {
          localHashSet.add("69");
        }
        if (!((com.tencent.mm.plugin.appbrand.service.h)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.service.h.class)).bVr()) {
          localHashSet.add("71");
        }
        b(localHashSet);
        this.xbC.a(this.query, this.xad, null, com.tencent.mm.plugin.fts.a.e.wVn);
        AppMethodBeat.o(111950);
        return;
        i = 0;
        break;
        localHashSet.add("67");
      }
      i = bool;
    }
  }
  
  public final boolean dPt()
  {
    return (this.xbM) && (this.xbL);
  }
  
  public final void dPu()
  {
    this.xby = true;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(111951);
    if (!this.xbo)
    {
      this.xbo = true;
      if (!this.xby) {
        l.a(this.query, false, dOI(), 0, this.xbD);
      }
    }
    if (!this.wrW)
    {
      this.wrW = true;
      l.a(this.xbD);
      l.b(this.xbD);
    }
    this.xbD.reset();
    super.finish();
    AppMethodBeat.o(111951);
  }
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(111957);
    super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    Object localObject1 = (FTSMainUI)this.xaG;
    paramInt1 = ((ListView)paramAbsListView).getHeaderViewsCount();
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if ((((FTSMainUI)localObject1).xch == 1) && (paramAbsListView.getLastVisiblePosition() >= paramInt1 + ((FTSMainUI)localObject1).xbX.getCount()) && (((FTSMainUI)localObject1).xbX.dPt()) && (((FTSMainUI)localObject1).xbZ.getVisibility() == 0))
    {
      ((FTSMainUI)localObject1).xch = 2;
      localObject2 = ((FTSMainUI)localObject1).xbX.xbD;
      localObject3 = ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).xeG.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (com.tencent.mm.plugin.fts.a.a.c)((Iterator)localObject3).next();
        if ("SearchContactBar".equals(((com.tencent.mm.plugin.fts.a.a.c)localObject4).dUb)) {
          ((com.tencent.mm.plugin.fts.a.a.c)localObject4).wVY = (System.currentTimeMillis() - ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).xaI);
        }
      }
    }
    localObject1 = ((FTSMainUI)localObject1).xbV;
    paramInt1 = ((ListView)paramAbsListView).getHeaderViewsCount();
    if ((paramAbsListView.getLastVisiblePosition() >= ((com.tencent.mm.plugin.fts.ui.widget.i)localObject1).xfV.xbX.getCount() + paramInt1) && (((com.tencent.mm.plugin.fts.ui.widget.i)localObject1).xfV.xbX.dPt()) && (((com.tencent.mm.plugin.fts.ui.widget.i)localObject1).xat == 1) && (((com.tencent.mm.plugin.fts.ui.widget.i)localObject1).xaY.getVisibility() == 0))
    {
      Log.i("MicroMsg.FTS.PardusSearchLogic", "onScroll webEntry hasResult:%s hasSug:%s", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.fts.ui.widget.i)localObject1).dDz), Boolean.valueOf(((com.tencent.mm.plugin.fts.ui.widget.i)localObject1).xgF) });
      if (!((com.tencent.mm.plugin.fts.ui.widget.i)localObject1).dDz)
      {
        ((com.tencent.mm.plugin.fts.ui.widget.i)localObject1).xat = 2;
        localObject2 = ((com.tencent.mm.plugin.fts.ui.widget.i)localObject1).xfV.xbX.xbD;
        localObject3 = ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).xeG.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (com.tencent.mm.plugin.fts.a.a.c)((Iterator)localObject3).next();
          if ("SOSBar".equals(((com.tencent.mm.plugin.fts.a.a.c)localObject4).dUb)) {
            ((com.tencent.mm.plugin.fts.a.a.c)localObject4).wVY = (System.currentTimeMillis() - ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).xaI);
          }
        }
      }
    }
    if ((paramAbsListView.getLastVisiblePosition() >= paramInt1 + ((com.tencent.mm.plugin.fts.ui.widget.i)localObject1).xfV.xbX.getCount()) && (((com.tencent.mm.plugin.fts.ui.widget.i)localObject1).xfV.xbX.dPt()) && (((com.tencent.mm.plugin.fts.ui.widget.i)localObject1).xba.getVisibility() == 0) && (!((com.tencent.mm.plugin.fts.ui.widget.i)localObject1).xgF))
    {
      paramInt3 = com.tencent.mm.cb.a.jo(((com.tencent.mm.plugin.fts.ui.widget.i)localObject1).xfV);
      paramInt1 = 0;
      if (paramInt1 < ((com.tencent.mm.plugin.fts.ui.widget.i)localObject1).xba.getChildCount())
      {
        paramAbsListView = ((com.tencent.mm.plugin.fts.ui.widget.i)localObject1).xba.getChildAt(paramInt1);
        localObject2 = new int[2];
        paramAbsListView.getLocationOnScreen((int[])localObject2);
        paramInt2 = paramAbsListView.getMeasuredHeight();
        int i = localObject2[1];
        paramAbsListView = (alv)paramAbsListView.getTag();
        if (i + paramInt2 <= paramInt3)
        {
          localObject2 = ((com.tencent.mm.plugin.fts.ui.widget.i)localObject1).xfV.xbX.xbD;
          localObject3 = paramAbsListView.Lux;
          localObject3 = "SOSRelevant-" + ((efk)localObject3).MEq;
          localObject4 = ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).xeG.iterator();
          while (((Iterator)localObject4).hasNext())
          {
            com.tencent.mm.plugin.fts.a.a.c localc = (com.tencent.mm.plugin.fts.a.a.c)((Iterator)localObject4).next();
            if ((((String)localObject3).equals(localc.dUb)) && (localc.wVY == 0L)) {
              localc.wVY = (System.currentTimeMillis() - ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).xaI);
            }
          }
        }
        for (paramInt2 = 1;; paramInt2 = 0)
        {
          if (paramInt2 != 0) {
            ((com.tencent.mm.plugin.fts.ui.widget.i)localObject1).e(0, "", "", "", paramAbsListView.Lux.MEq);
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
      this.xbw = true;
      ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.fts.a.n.class)).getFTSImageLoader().dOl();
      o.DCM.pause();
      AppMethodBeat.o(111958);
      return;
    }
    this.xbw = false;
    if (!((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.fts.a.n.class)).getFTSImageLoader().dOm())
    {
      this.xbJ.removeMessages(1);
      this.xbJ.sendEmptyMessageDelayed(1, 200L);
    }
    AppMethodBeat.o(111958);
  }
  
  public final void stopSearch()
  {
    AppMethodBeat.i(111953);
    this.xbJ.removeMessages(1);
    super.stopSearch();
    AppMethodBeat.o(111953);
  }
  
  final class a
    implements Runnable
  {
    private String query;
    private com.tencent.mm.plugin.fts.a.d.e xbO;
    
    a(com.tencent.mm.plugin.fts.a.d.e parame, String paramString)
    {
      this.query = paramString;
      this.xbO = parame;
    }
    
    public final void run()
    {
      AppMethodBeat.i(111946);
      if ((!k.a(k.this)) && (((com.tencent.mm.plugin.fts.a.d.e)k.b(k.this).get(k.b(k.this).size() - 1)).getType() == this.xbO.getType())) {
        k.c(k.this);
      }
      if ((!k.d(k.this)) && (this.xbO.getType() == 256)) {
        k.e(k.this);
      }
      k.f(k.this).xeD = k.this.dPt();
      Object localObject1 = k.b(k.this).iterator();
      for (int i = 0; ((Iterator)localObject1).hasNext(); i = ((com.tencent.mm.plugin.fts.a.d.e)((Iterator)localObject1).next()).Nn(i)) {}
      i = k.g(k.this).Nn(i);
      k.this.setCount(i);
      k.this.notifyDataSetChanged();
      localObject1 = k.this;
      ((k)localObject1).ax(i, ((k)localObject1).dPt());
      if (k.this.dPt()) {
        k.f(k.this).xeh = System.currentTimeMillis();
      }
      localObject1 = k.f(k.this);
      Object localObject2 = this.xbO;
      ((com.tencent.mm.plugin.fts.ui.c.b)localObject1).xeG.addAll(((com.tencent.mm.plugin.fts.a.d.e)localObject2).GE(((com.tencent.mm.plugin.fts.ui.c.b)localObject1).xaI));
      localObject1 = k.f(k.this);
      ((com.tencent.mm.plugin.fts.ui.c.b)localObject1).xeA = i;
      localObject2 = ((com.tencent.mm.plugin.fts.ui.c.b)localObject1).xeG.iterator();
      com.tencent.mm.plugin.fts.a.a.c localc;
      while (((Iterator)localObject2).hasNext())
      {
        localc = (com.tencent.mm.plugin.fts.a.a.c)((Iterator)localObject2).next();
        if ("SearchContactBar".equals(localc.dUb)) {
          localc.position = (((com.tencent.mm.plugin.fts.ui.c.b)localObject1).xeA + 1);
        }
      }
      localObject2 = ((com.tencent.mm.plugin.fts.ui.c.b)localObject1).xeG.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localc = (com.tencent.mm.plugin.fts.a.a.c)((Iterator)localObject2).next();
        if ("SOSBar".equals(localc.dUb)) {
          if ((((com.tencent.mm.plugin.fts.ui.c.b)localObject1).xew > 0) || (((com.tencent.mm.plugin.fts.ui.c.b)localObject1).xex > 0)) {
            localc.position = (((com.tencent.mm.plugin.fts.ui.c.b)localObject1).xeA + 2);
          } else {
            localc.position = (((com.tencent.mm.plugin.fts.ui.c.b)localObject1).xeA + 1);
          }
        }
      }
      if ((((com.tencent.mm.plugin.fts.ui.c.b)localObject1).xew > 0) || (((com.tencent.mm.plugin.fts.ui.c.b)localObject1).xex > 0)) {}
      for (i = ((com.tencent.mm.plugin.fts.ui.c.b)localObject1).xeA + 3;; i = ((com.tencent.mm.plugin.fts.ui.c.b)localObject1).xeA + 2)
      {
        localObject1 = ((com.tencent.mm.plugin.fts.ui.c.b)localObject1).xeG.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (com.tencent.mm.plugin.fts.a.a.c)((Iterator)localObject1).next();
          if (((com.tencent.mm.plugin.fts.a.a.c)localObject2).dUb.startsWith("SOSRelevant")) {
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