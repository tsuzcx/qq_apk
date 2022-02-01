package com.tencent.mm.plugin.fts.ui;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.vv;
import com.tencent.mm.f.a.vv.b;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.fts.a.d.e.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.sns.b.p;
import com.tencent.mm.protocal.protobuf.amw;
import com.tencent.mm.protocal.protobuf.epl;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.bv;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class k
  extends d
  implements e.b
{
  private MMHandler BMc;
  List<com.tencent.mm.plugin.fts.a.d.e> BNB;
  private com.tencent.mm.plugin.fts.ui.d.n BNC;
  public com.tencent.mm.plugin.fts.ui.c.b BND;
  com.tencent.mm.plugin.fts.ui.widget.i BNE;
  private long BNF;
  private long BNG;
  private long BNH;
  private long BNI;
  private MMHandler BNJ;
  private int BNK;
  private boolean BNL;
  boolean BNM;
  public boolean BNo;
  private boolean BNw;
  public boolean BNy;
  private boolean Bek;
  
  public k(e parame, int paramInt, com.tencent.mm.plugin.fts.ui.widget.i parami)
  {
    super(parame);
    AppMethodBeat.i(184530);
    this.BNJ = new MMHandler(Looper.getMainLooper())
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
            ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.fts.a.n.class)).getFTSImageLoader().eqB();
            p.JPc.start();
            k.this.notifyDataSetChanged();
          }
        }
      }
    };
    this.BMc = new MMHandler(Looper.getMainLooper());
    this.BNK = -1;
    this.BNE = parami;
    this.BND = new com.tencent.mm.plugin.fts.ui.c.b();
    parame = new HashSet();
    parame.add(Integer.valueOf(16));
    parame.add(Integer.valueOf(32));
    parame.add(Integer.valueOf(48));
    parame.add(Integer.valueOf(64));
    parame.add(Integer.valueOf(128));
    parame.add(Integer.valueOf(96));
    parame.add(Integer.valueOf(112));
    if (com.tencent.mm.kernel.h.aHB())
    {
      parami = new vv();
      EventCenter.instance.publish(parami);
      if (!parami.fUS.fUU) {}
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        parame.add(Integer.valueOf(144));
      }
      this.BNB = ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.fts.a.n.class)).createFTSUIUnitList(parame, getContext(), this, paramInt);
      this.BNC = ((com.tencent.mm.plugin.fts.ui.d.n)new com.tencent.mm.plugin.fts.ui.b.n().a(getContext(), this, paramInt));
      AppMethodBeat.o(184530);
      return;
    }
  }
  
  private void b(HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(111956);
    this.BNK += 1;
    if (this.BNK < this.BNB.size()) {
      ((com.tencent.mm.plugin.fts.a.d.e)this.BNB.get(this.BNK)).a(getQuery(), this.BMc, paramHashSet, com.tencent.mm.plugin.fts.a.e.BHj);
    }
    AppMethodBeat.o(111956);
  }
  
  protected final com.tencent.mm.plugin.fts.a.d.a.a SC(int paramInt)
  {
    AppMethodBeat.i(111948);
    long l = 0L;
    com.tencent.mm.plugin.fts.a.d.a.a locala = null;
    Object localObject1 = this.BNB.iterator();
    for (;;)
    {
      Object localObject2;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.tencent.mm.plugin.fts.a.d.e)((Iterator)localObject1).next();
        locala = ((com.tencent.mm.plugin.fts.a.d.e)localObject2).SC(paramInt);
        l = ((com.tencent.mm.plugin.fts.a.d.e)localObject2).erc();
        if (locala == null) {}
      }
      else
      {
        for (;;)
        {
          if (locala == null)
          {
            locala = this.BNC.SC(paramInt);
            l = this.BNC.BJO;
          }
          for (;;)
          {
            if (locala != null)
            {
              localObject1 = new LinkedList();
              localObject2 = this.BNB.iterator();
              while (((Iterator)localObject2).hasNext()) {
                ((LinkedList)localObject1).addAll(((com.tencent.mm.plugin.fts.a.d.e)((Iterator)localObject2).next()).era());
              }
              i = ((LinkedList)localObject1).size() - 1;
              if (i < 0) {
                break label246;
              }
              if (paramInt <= ((Integer)((LinkedList)localObject1).get(i)).intValue()) {
                break label239;
              }
            }
            label239:
            label246:
            for (int i = paramInt - i;; i = paramInt)
            {
              locala.BJH = i;
              locala.pageType = 1;
              locala.BJO = l;
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
  
  public final void SF(int paramInt)
  {
    this.BND.BQK = paramInt;
  }
  
  protected final void a(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a parama)
  {
    AppMethodBeat.i(111949);
    super.a(paramContext, parama);
    paramContext = this.BND;
    Iterator localIterator;
    switch (parama.viewType)
    {
    default: 
      localIterator = paramContext.BQP.iterator();
    }
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.fts.a.a.c localc = (com.tencent.mm.plugin.fts.a.a.c)localIterator.next();
      if (localc.position == parama.position)
      {
        localc.BHT = (System.currentTimeMillis() - paramContext.BMI);
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
      if (paramString.equals(getQuery())) {
        b(((a)localObject).BIS);
      }
      if ((((a)localObject).eru() > 0) && (this.BNF == 0L))
      {
        this.BNF = (System.currentTimeMillis() - erC());
        l.av(9, this.BNF);
        Log.i("MicroMsg.FTS.FTSMainAdapter", "firstItemTime=%d", new Object[] { Long.valueOf(this.BNF) });
      }
      switch (((a)localObject).getType())
      {
      default: 
        label140:
        localb = this.BND;
        localObject = ((a)localObject).BLN.iterator();
      }
      for (;;)
      {
        if (!((Iterator)localObject).hasNext()) {
          break label568;
        }
        e.a locala = (e.a)((Iterator)localObject).next();
        int j = locala.pWR.size();
        if (locala.xcp) {}
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
            localb.BQA = i;
            break;
            if (this.BNG != 0L) {
              break label140;
            }
            this.BNG = (System.currentTimeMillis() - erC());
            Log.i("MicroMsg.FTS.FTSMainAdapter", "firstGetTopHitsTime=%d", new Object[] { Long.valueOf(this.BNG) });
            l.av(0, this.BNG);
            break label140;
            if (this.BNH != 0L) {
              break label140;
            }
            this.BNH = (System.currentTimeMillis() - erC());
            Log.i("MicroMsg.FTS.FTSMainAdapter", "firstGetContactTime=%d", new Object[] { Long.valueOf(this.BNH) });
            l.av(3, this.BNH);
            break label140;
            if (this.BNI != 0L) {
              break label140;
            }
            this.BNI = (System.currentTimeMillis() - erC());
            Log.i("MicroMsg.FTS.FTSMainAdapter", "firstGetChatroomTime=%d", new Object[] { Long.valueOf(this.BNI) });
            l.av(6, this.BNI);
            break label140;
          }
        }
        localb.BQx = i;
        continue;
        localb.BQu = i;
        continue;
        localb.BQy = i;
        continue;
        localb.BQv = i;
        continue;
        localb.favCount = i;
        continue;
        localb.BQz = i;
        continue;
        localb.BQw = i;
        continue;
        localb.BQt = i;
      }
    }
    com.tencent.mm.plugin.fts.ui.c.b localb = this.BND;
    if (parame.erb() > 0)
    {
      if (parame.eqW() != 2) {
        break label599;
      }
      localb.BQC = parame.erb();
    }
    for (;;)
    {
      label568:
      this.BND.BQN = erb();
      new a(parame, paramString).run();
      AppMethodBeat.o(111955);
      return;
      label599:
      localb.BQB = parame.erb();
    }
  }
  
  protected final boolean a(View paramView, com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(111954);
    Iterator localIterator = this.BNB.iterator();
    boolean bool;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      bool = ((com.tencent.mm.plugin.fts.a.d.e)localIterator.next()).a(paramView, parama, paramBoolean);
      paramBoolean = bool;
    } while (!bool);
    if ((!this.BNo) && (!(parama instanceof com.tencent.mm.plugin.fts.ui.a.n)))
    {
      l.a(getQuery(), true, erb(), 0, this.BND);
      this.BNo = true;
    }
    if (parama.BJP)
    {
      Log.d("MicroMsg.FTS.FTSMainAdapter", "searchType=%d | searchScene=%d | kvPosition=%d | kvSubPosition=%d | kvSearchId=%s | kvDocId=%d", new Object[] { Integer.valueOf(parama.uMD), Integer.valueOf(parama.ptD), Integer.valueOf(parama.BJH), Integer.valueOf(parama.BJI), parama.BJJ, Long.valueOf(parama.BJK) });
      this.BNE.SN(1);
      this.BND.b(parama);
      l.a(parama, this.BND);
      AppMethodBeat.o(111954);
      return true;
    }
    if ((parama instanceof com.tencent.mm.plugin.fts.ui.a.h))
    {
      this.BNy = true;
      this.BNE.SN(1);
      this.BND.b(parama);
      l.a(parama, this.BND);
    }
    for (;;)
    {
      AppMethodBeat.o(111954);
      return false;
      if ((parama instanceof com.tencent.mm.plugin.fts.ui.a.i))
      {
        l.a(parama, this.BND);
        this.BND.b(parama);
      }
    }
  }
  
  protected final void clearCache()
  {
    AppMethodBeat.i(111952);
    super.clearCache();
    Iterator localIterator = this.BNB.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.fts.a.d.e locale = (com.tencent.mm.plugin.fts.a.d.e)localIterator.next();
      locale.eqZ();
      locale.clearData();
    }
    this.BNC.eqZ();
    this.BNC.clearData();
    AppMethodBeat.o(111952);
  }
  
  public final boolean erP()
  {
    return (this.BNM) && (this.BNL);
  }
  
  public final void erQ()
  {
    this.BNy = true;
  }
  
  protected final int erb()
  {
    AppMethodBeat.i(111959);
    Iterator localIterator = this.BNB.iterator();
    for (int i = 0; localIterator.hasNext(); i = ((com.tencent.mm.plugin.fts.a.d.e)localIterator.next()).erb() + i) {}
    int j = this.BNC.erb();
    AppMethodBeat.o(111959);
    return j + i;
  }
  
  protected final void erv()
  {
    int i = 1;
    AppMethodBeat.i(111950);
    if ((!Util.isNullOrNil(this.BND.query)) && (!this.Bek) && (this.BND.BQs != 0L))
    {
      l.a(this.BND);
      l.b(this.BND);
      this.Bek = true;
    }
    this.Bek = false;
    this.BNo = false;
    this.BNy = false;
    this.BNK = -1;
    this.BNM = false;
    this.BNL = false;
    this.BND.reset();
    com.tencent.mm.plugin.fts.a.e.BHj = com.tencent.mm.plugin.fts.a.d.Sw(3);
    this.BND.BQs = com.tencent.mm.plugin.fts.a.e.BHj;
    this.BND.query = getQuery();
    this.BND.BMI = System.currentTimeMillis();
    this.BNF = 0L;
    this.BNG = 0L;
    this.BNH = 0L;
    this.BNI = 0L;
    HashSet localHashSet = new HashSet();
    localHashSet.add("filehelper");
    boolean bool = z.bdO();
    if (!bool) {
      if (Util.getInt(com.tencent.mm.n.h.axc().getValue("BindQQSwitch"), 1) != 1) {}
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
      if (com.tencent.mm.az.b.WF((String)com.tencent.mm.kernel.h.aHG().aHp().b(274436, null)))
      {
        Log.i("MicroMsg.FTS.FTSMainAdapter", "checkLookVisibility EuropeanUnionCountry");
        localHashSet.add("65");
      }
      com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class);
      localHashSet.add("63");
      if (!((com.tencent.mm.plugin.appbrand.service.e)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.service.e.class)).ciC()) {
        localHashSet.add("69");
      }
      if (!((com.tencent.mm.plugin.appbrand.service.h)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.service.h.class)).ciC()) {
        localHashSet.add("71");
      }
      if (!com.tencent.mm.contact.d.rk(((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().RG("gh_b4af18eac3d5").field_type)) {
        localHashSet.add("73");
      }
      b(localHashSet);
      this.BNC.a(getQuery(), this.BMc, null, com.tencent.mm.plugin.fts.a.e.BHj);
      AppMethodBeat.o(111950);
      return;
      i = 0;
      continue;
      i = bool;
    }
  }
  
  public final void erx()
  {
    AppMethodBeat.i(111953);
    this.BNJ.removeMessages(1);
    super.erx();
    AppMethodBeat.o(111953);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(111951);
    if (!this.BNo)
    {
      this.BNo = true;
      if (!this.BNy) {
        l.a(getQuery(), false, erb(), 0, this.BND);
      }
    }
    if (!this.Bek)
    {
      this.Bek = true;
      l.a(this.BND);
      l.b(this.BND);
    }
    this.BND.reset();
    super.finish();
    AppMethodBeat.o(111951);
  }
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(111957);
    super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    Object localObject1 = (FTSMainUI)erB();
    paramInt1 = ((ListView)paramAbsListView).getHeaderViewsCount();
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if ((((FTSMainUI)localObject1).BOh == 1) && (paramAbsListView.getLastVisiblePosition() >= paramInt1 + ((FTSMainUI)localObject1).BNX.getCount()) && (((FTSMainUI)localObject1).BNX.erP()) && (((FTSMainUI)localObject1).BNZ.getVisibility() == 0))
    {
      ((FTSMainUI)localObject1).BOh = 2;
      localObject2 = ((FTSMainUI)localObject1).BNX.BND;
      localObject3 = ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).BQP.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (com.tencent.mm.plugin.fts.a.a.c)((Iterator)localObject3).next();
        if ("SearchContactBar".equals(((com.tencent.mm.plugin.fts.a.a.c)localObject4).fND)) {
          ((com.tencent.mm.plugin.fts.a.a.c)localObject4).BHT = (System.currentTimeMillis() - ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).BMI);
        }
      }
    }
    localObject1 = ((FTSMainUI)localObject1).BNV;
    paramInt1 = ((ListView)paramAbsListView).getHeaderViewsCount();
    if ((paramAbsListView.getLastVisiblePosition() >= ((com.tencent.mm.plugin.fts.ui.widget.i)localObject1).BSg.BNX.getCount() + paramInt1) && (((com.tencent.mm.plugin.fts.ui.widget.i)localObject1).BSg.BNX.erP()) && (((com.tencent.mm.plugin.fts.ui.widget.i)localObject1).BMs == 1) && (((com.tencent.mm.plugin.fts.ui.widget.i)localObject1).BMY.getVisibility() == 0))
    {
      Log.i("MicroMsg.FTS.PardusSearchLogic", "onScroll webEntry hasResult:%s hasSug:%s", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.fts.ui.widget.i)localObject1).fwi), Boolean.valueOf(((com.tencent.mm.plugin.fts.ui.widget.i)localObject1).BSQ) });
      if (!((com.tencent.mm.plugin.fts.ui.widget.i)localObject1).fwi)
      {
        ((com.tencent.mm.plugin.fts.ui.widget.i)localObject1).BMs = 2;
        localObject2 = ((com.tencent.mm.plugin.fts.ui.widget.i)localObject1).BSg.BNX.BND;
        localObject3 = ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).BQP.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (com.tencent.mm.plugin.fts.a.a.c)((Iterator)localObject3).next();
          if ("SOSBar".equals(((com.tencent.mm.plugin.fts.a.a.c)localObject4).fND)) {
            ((com.tencent.mm.plugin.fts.a.a.c)localObject4).BHT = (System.currentTimeMillis() - ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).BMI);
          }
        }
      }
    }
    if ((paramAbsListView.getLastVisiblePosition() >= paramInt1 + ((com.tencent.mm.plugin.fts.ui.widget.i)localObject1).BSg.BNX.getCount()) && (((com.tencent.mm.plugin.fts.ui.widget.i)localObject1).BSg.BNX.erP()) && (((com.tencent.mm.plugin.fts.ui.widget.i)localObject1).BNa.getVisibility() == 0) && (!((com.tencent.mm.plugin.fts.ui.widget.i)localObject1).BSQ))
    {
      paramInt3 = com.tencent.mm.ci.a.ks(((com.tencent.mm.plugin.fts.ui.widget.i)localObject1).BSg);
      paramInt1 = 0;
      if (paramInt1 < ((com.tencent.mm.plugin.fts.ui.widget.i)localObject1).BNa.getChildCount())
      {
        paramAbsListView = ((com.tencent.mm.plugin.fts.ui.widget.i)localObject1).BNa.getChildAt(paramInt1);
        localObject2 = new int[2];
        paramAbsListView.getLocationOnScreen((int[])localObject2);
        paramInt2 = paramAbsListView.getMeasuredHeight();
        int i = localObject2[1];
        paramAbsListView = (amw)paramAbsListView.getTag();
        if (i + paramInt2 <= paramInt3)
        {
          localObject2 = ((com.tencent.mm.plugin.fts.ui.widget.i)localObject1).BSg.BNX.BND;
          localObject3 = paramAbsListView.SwV;
          localObject3 = "SOSRelevant-" + ((epl)localObject3).TPZ;
          localObject4 = ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).BQP.iterator();
          while (((Iterator)localObject4).hasNext())
          {
            com.tencent.mm.plugin.fts.a.a.c localc = (com.tencent.mm.plugin.fts.a.a.c)((Iterator)localObject4).next();
            if ((((String)localObject3).equals(localc.fND)) && (localc.BHT == 0L)) {
              localc.BHT = (System.currentTimeMillis() - ((com.tencent.mm.plugin.fts.ui.c.b)localObject2).BMI);
            }
          }
        }
        for (paramInt2 = 1;; paramInt2 = 0)
        {
          if (paramInt2 != 0) {
            ((com.tencent.mm.plugin.fts.ui.widget.i)localObject1).g(0, "", "", "", paramAbsListView.SwV.TPZ);
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
      this.BNw = true;
      ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.fts.a.n.class)).getFTSImageLoader().eqz();
      p.JPc.pause();
      AppMethodBeat.o(111958);
      return;
    }
    this.BNw = false;
    if (!((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.fts.a.n.class)).getFTSImageLoader().eqA())
    {
      this.BNJ.removeMessages(1);
      this.BNJ.sendEmptyMessageDelayed(1, 200L);
    }
    AppMethodBeat.o(111958);
  }
  
  final class a
    implements Runnable
  {
    private com.tencent.mm.plugin.fts.a.d.e BNO;
    private String query;
    
    a(com.tencent.mm.plugin.fts.a.d.e parame, String paramString)
    {
      this.query = paramString;
      this.BNO = parame;
    }
    
    public final void run()
    {
      AppMethodBeat.i(111946);
      if ((!k.a(k.this)) && (((com.tencent.mm.plugin.fts.a.d.e)k.b(k.this).get(k.b(k.this).size() - 1)).getType() == this.BNO.getType())) {
        k.c(k.this);
      }
      if ((!k.d(k.this)) && (this.BNO.getType() == 256)) {
        k.e(k.this);
      }
      k.f(k.this).BQM = k.this.erP();
      Object localObject1 = k.b(k.this).iterator();
      for (int i = 0; ((Iterator)localObject1).hasNext(); i = ((com.tencent.mm.plugin.fts.a.d.e)((Iterator)localObject1).next()).SB(i)) {}
      i = k.g(k.this).SB(i);
      k.this.setCount(i);
      k.this.notifyDataSetChanged();
      localObject1 = k.this;
      ((k)localObject1).aB(i, ((k)localObject1).erP());
      if (k.this.erP()) {
        k.f(k.this).BQq = System.currentTimeMillis();
      }
      localObject1 = k.f(k.this);
      Object localObject2 = this.BNO;
      ((com.tencent.mm.plugin.fts.ui.c.b)localObject1).BQP.addAll(((com.tencent.mm.plugin.fts.a.d.e)localObject2).NG(((com.tencent.mm.plugin.fts.ui.c.b)localObject1).BMI));
      localObject1 = k.f(k.this);
      ((com.tencent.mm.plugin.fts.ui.c.b)localObject1).BQJ = i;
      localObject2 = ((com.tencent.mm.plugin.fts.ui.c.b)localObject1).BQP.iterator();
      com.tencent.mm.plugin.fts.a.a.c localc;
      while (((Iterator)localObject2).hasNext())
      {
        localc = (com.tencent.mm.plugin.fts.a.a.c)((Iterator)localObject2).next();
        if ("SearchContactBar".equals(localc.fND)) {
          localc.position = (((com.tencent.mm.plugin.fts.ui.c.b)localObject1).BQJ + 1);
        }
      }
      localObject2 = ((com.tencent.mm.plugin.fts.ui.c.b)localObject1).BQP.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localc = (com.tencent.mm.plugin.fts.a.a.c)((Iterator)localObject2).next();
        if ("SOSBar".equals(localc.fND)) {
          if ((((com.tencent.mm.plugin.fts.ui.c.b)localObject1).BQF > 0) || (((com.tencent.mm.plugin.fts.ui.c.b)localObject1).BQG > 0)) {
            localc.position = (((com.tencent.mm.plugin.fts.ui.c.b)localObject1).BQJ + 2);
          } else {
            localc.position = (((com.tencent.mm.plugin.fts.ui.c.b)localObject1).BQJ + 1);
          }
        }
      }
      if ((((com.tencent.mm.plugin.fts.ui.c.b)localObject1).BQF > 0) || (((com.tencent.mm.plugin.fts.ui.c.b)localObject1).BQG > 0)) {}
      for (i = ((com.tencent.mm.plugin.fts.ui.c.b)localObject1).BQJ + 3;; i = ((com.tencent.mm.plugin.fts.ui.c.b)localObject1).BQJ + 2)
      {
        localObject1 = ((com.tencent.mm.plugin.fts.ui.c.b)localObject1).BQP.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (com.tencent.mm.plugin.fts.a.a.c)((Iterator)localObject1).next();
          if (((com.tencent.mm.plugin.fts.a.a.c)localObject2).fND.startsWith("SOSRelevant")) {
            ((com.tencent.mm.plugin.fts.a.a.c)localObject2).position = i;
          }
        }
      }
      AppMethodBeat.o(111946);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.k
 * JD-Core Version:    0.7.0.1
 */