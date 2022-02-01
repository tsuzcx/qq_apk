package com.tencent.mm.plugin.fts.ui;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.xl;
import com.tencent.mm.autogen.a.xl.b;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.model.cn;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.fts.a.d.e.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.sns.c.q;
import com.tencent.mm.protocal.protobuf.aqp;
import com.tencent.mm.protocal.protobuf.fkk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.bx;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class k
  extends d
  implements e.b
{
  private boolean EKW;
  private boolean GGH;
  private MMHandler HwY;
  public boolean HyH;
  public boolean HyQ;
  List<com.tencent.mm.plugin.fts.a.d.e> HyU;
  public com.tencent.mm.plugin.fts.ui.d.b HyV;
  com.tencent.mm.plugin.fts.ui.widget.k HyW;
  private long HyX;
  private long HyY;
  private long HyZ;
  private long Hza;
  private MMHandler Hzb;
  private int Hzc;
  public boolean Hzd;
  
  public k(e parame, int paramInt, com.tencent.mm.plugin.fts.ui.widget.k paramk)
  {
    super(parame);
    AppMethodBeat.i(184530);
    this.Hzb = new MMHandler(Looper.getMainLooper())
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
          if ((!k.e(k.this)) && (k.this.getCount() > 0))
          {
            ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fts.a.n.class)).getFTSImageLoader().fxg();
            q.Qkh.start();
            k.this.notifyDataSetChanged();
          }
        }
      }
    };
    this.HwY = new MMHandler(Looper.getMainLooper());
    this.Hzc = -1;
    this.HyW = paramk;
    this.HyV = new com.tencent.mm.plugin.fts.ui.d.b();
    parame = new HashSet();
    parame.add(Integer.valueOf(16));
    parame.add(Integer.valueOf(32));
    parame.add(Integer.valueOf(48));
    parame.add(Integer.valueOf(64));
    parame.add(Integer.valueOf(128));
    parame.add(Integer.valueOf(96));
    parame.add(Integer.valueOf(112));
    parame.add(Integer.valueOf(133));
    if (com.tencent.mm.kernel.h.baz())
    {
      paramk = new xl();
      paramk.publish();
      if (!paramk.iaP.iaR) {}
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        parame.add(Integer.valueOf(144));
      }
      this.HyU = ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fts.a.n.class)).createFTSUIUnitList(parame, getContext(), this, paramInt);
      AppMethodBeat.o(184530);
      return;
    }
  }
  
  private void d(HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(111956);
    this.Hzc += 1;
    if (this.Hzc < this.HyU.size())
    {
      com.tencent.mm.plugin.fts.a.d.e locale = (com.tencent.mm.plugin.fts.a.d.e)this.HyU.get(this.Hzc);
      String str = getQuery();
      MMHandler localMMHandler = this.HwY;
      long l = com.tencent.mm.plugin.fts.a.e.HrN;
      locale.a(str, localMMHandler, paramHashSet);
    }
    AppMethodBeat.o(111956);
  }
  
  protected final com.tencent.mm.plugin.fts.a.d.a.a Wj(int paramInt)
  {
    AppMethodBeat.i(111948);
    long l = 0L;
    com.tencent.mm.plugin.fts.a.d.a.a locala = null;
    Object localObject1 = this.HyU.iterator();
    for (;;)
    {
      Object localObject2;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.tencent.mm.plugin.fts.a.d.e)((Iterator)localObject1).next();
        locala = ((com.tencent.mm.plugin.fts.a.d.e)localObject2).Wj(paramInt);
        l = ((com.tencent.mm.plugin.fts.a.d.e)localObject2).fxJ();
        if (locala == null) {}
      }
      else
      {
        for (;;)
        {
          if (locala != null)
          {
            localObject1 = new LinkedList();
            localObject2 = this.HyU.iterator();
            while (((Iterator)localObject2).hasNext()) {
              ((LinkedList)localObject1).addAll(((com.tencent.mm.plugin.fts.a.d.e)((Iterator)localObject2).next()).fxH());
            }
            i = ((LinkedList)localObject1).size() - 1;
            if (i < 0) {
              break label223;
            }
            if (paramInt <= ((Integer)((LinkedList)localObject1).get(i)).intValue()) {
              break label216;
            }
          }
          label216:
          label223:
          for (int i = paramInt - i;; i = paramInt)
          {
            locala.Huq = i;
            locala.pageType = 1;
            locala.Hux = l;
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
  
  public final void Wn(int paramInt)
  {
    this.HyV.HCv = paramInt;
  }
  
  protected final void a(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a parama)
  {
    AppMethodBeat.i(111949);
    super.a(paramContext, parama);
    paramContext = this.HyV;
    long l;
    Iterator localIterator;
    switch (parama.viewType)
    {
    default: 
      l = cn.bDv();
      localIterator = paramContext.HCB.iterator();
    }
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.fts.a.a.e locale = (com.tencent.mm.plugin.fts.a.a.e)localIterator.next();
      if (locale.position == parama.position)
      {
        locale.HsA = (l - paramContext.HxE);
        locale.HsF = l;
        AppMethodBeat.o(111949);
        return;
        AppMethodBeat.o(111949);
        return;
      }
    }
    AppMethodBeat.o(111949);
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.d.e parame, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(265690);
    Object localObject = (a)parame;
    if (paramString.equals(getQuery())) {
      d(((a)localObject).HtA);
    }
    if ((((a)localObject).fyc() > 0) && (this.HyX == 0L))
    {
      this.HyX = (System.currentTimeMillis() - fyj());
      l.aC(9, this.HyX);
      Log.i("MicroMsg.FTS.FTSMainAdapter", "firstItemTime=%d", new Object[] { Long.valueOf(this.HyX) });
    }
    label132:
    com.tencent.mm.plugin.fts.ui.d.b localb;
    switch (((a)localObject).getType())
    {
    default: 
      localb = this.HyV;
      localObject = ((a)localObject).HwJ.iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject).hasNext()) {
        break label614;
      }
      e.a locala = (e.a)((Iterator)localObject).next();
      int j = locala.tbH.size();
      if (locala.ABD) {}
      for (int i = 1;; i = 0)
      {
        i += j;
        switch (locala.businessType)
        {
        case -22: 
        case -21: 
        case -20: 
        case -19: 
        case -18: 
        case -17: 
        case -16: 
        case -15: 
        case -14: 
        case -12: 
        case -10: 
        case -9: 
        case -5: 
        default: 
          break;
        case -23: 
          localb.HCf = i;
          localb.HCg = com.tencent.mm.plugin.fts.ui.d.b.a(locala);
          break;
          if (this.HyY != 0L) {
            break label132;
          }
          this.HyY = (System.currentTimeMillis() - fyj());
          Log.i("MicroMsg.FTS.FTSMainAdapter", "firstGetTopHitsTime=%d", new Object[] { Long.valueOf(this.HyY) });
          l.aC(0, this.HyY);
          break label132;
          if (this.HyZ != 0L) {
            break label132;
          }
          this.HyZ = (System.currentTimeMillis() - fyj());
          Log.i("MicroMsg.FTS.FTSMainAdapter", "firstGetContactTime=%d", new Object[] { Long.valueOf(this.HyZ) });
          l.aC(3, this.HyZ);
          break label132;
          if (this.Hza != 0L) {
            break label132;
          }
          this.Hza = (System.currentTimeMillis() - fyj());
          Log.i("MicroMsg.FTS.FTSMainAdapter", "firstGetChatroomTime=%d", new Object[] { Long.valueOf(this.Hza) });
          l.aC(6, this.Hza);
          break label132;
        }
      }
      localb.HCh = i;
      continue;
      localb.HCb = i;
      continue;
      localb.HCi = i;
      continue;
      localb.HCc = i;
      continue;
      localb.favCount = i;
      continue;
      localb.HCj = i;
      continue;
      localb.HCd = i;
      localb.HCe = com.tencent.mm.plugin.fts.ui.d.b.a(locala);
      continue;
      localb.HCa = i;
      continue;
      localb.HCk = i;
      localb.HCn = com.tencent.mm.plugin.fts.ui.d.b.a(locala);
    }
    label614:
    this.HyV.HCy = fxI();
    new a(parame, paramString).run();
    AppMethodBeat.o(265690);
  }
  
  protected final boolean a(View paramView, com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(111954);
    Iterator localIterator = this.HyU.iterator();
    boolean bool;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      bool = ((com.tencent.mm.plugin.fts.a.d.e)localIterator.next()).a(paramView, parama, paramBoolean);
      paramBoolean = bool;
    } while (!bool);
    if ((!this.HyH) && (!(parama instanceof com.tencent.mm.plugin.fts.ui.b.n)))
    {
      l.a(getQuery(), true, fxI(), 0, this.HyV);
      this.HyH = true;
    }
    if (parama.Huy)
    {
      Log.d("MicroMsg.FTS.FTSMainAdapter", "searchType=%d | searchScene=%d | kvPosition=%d | kvSubPosition=%d | kvSearchId=%s | kvDocId=%d", new Object[] { Integer.valueOf(parama.xVf), Integer.valueOf(parama.syO), Integer.valueOf(parama.Huq), Integer.valueOf(parama.Hur), parama.Hus, Long.valueOf(parama.Hut) });
      this.HyW.Wu(1);
      this.HyV.b(parama);
      l.a(parama, this.HyV);
      AppMethodBeat.o(111954);
      return true;
    }
    if ((parama instanceof com.tencent.mm.plugin.fts.ui.b.h))
    {
      this.HyQ = true;
      this.HyW.Wu(1);
      this.HyV.b(parama);
      l.a(parama, this.HyV);
    }
    for (;;)
    {
      AppMethodBeat.o(111954);
      return false;
      if ((parama instanceof com.tencent.mm.plugin.fts.ui.b.i))
      {
        l.a(parama, this.HyV);
        this.HyV.b(parama);
      }
    }
  }
  
  protected final void clearCache()
  {
    AppMethodBeat.i(111952);
    super.clearCache();
    Iterator localIterator = this.HyU.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.fts.a.d.e locale = (com.tencent.mm.plugin.fts.a.d.e)localIterator.next();
      locale.fxG();
      locale.clearData();
    }
    AppMethodBeat.o(111952);
  }
  
  public final void eui()
  {
    AppMethodBeat.i(111953);
    this.Hzb.removeMessages(1);
    super.eui();
    AppMethodBeat.o(111953);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(111951);
    if (!this.HyH)
    {
      this.HyH = true;
      if (!this.HyQ) {
        l.a(getQuery(), false, fxI(), 0, this.HyV);
      }
    }
    if (!this.GGH)
    {
      this.GGH = true;
      l.a(this.HyV);
      l.b(this.HyV);
    }
    this.HyV.reset();
    super.finish();
    AppMethodBeat.o(111951);
  }
  
  protected final int fxI()
  {
    AppMethodBeat.i(111959);
    Iterator localIterator = this.HyU.iterator();
    for (int i = 0; localIterator.hasNext(); i = ((com.tencent.mm.plugin.fts.a.d.e)localIterator.next()).fxI() + i) {}
    AppMethodBeat.o(111959);
    return i;
  }
  
  protected final void fyd()
  {
    int i = 1;
    AppMethodBeat.i(111950);
    if ((!Util.isNullOrNil(this.HyV.query)) && (!this.GGH) && (this.HyV.HBZ != 0L))
    {
      l.a(this.HyV);
      l.b(this.HyV);
      this.GGH = true;
    }
    this.GGH = false;
    this.HyH = false;
    this.HyQ = false;
    this.Hzc = -1;
    this.Hzd = false;
    this.HyV.reset();
    com.tencent.mm.plugin.fts.a.e.HrN = com.tencent.mm.plugin.fts.a.d.Wd(3);
    this.HyV.HBZ = com.tencent.mm.plugin.fts.a.e.HrN;
    this.HyV.query = getQuery();
    this.HyV.HxE = System.currentTimeMillis();
    this.HyX = 0L;
    this.HyY = 0L;
    this.HyZ = 0L;
    this.Hza = 0L;
    HashSet localHashSet = new HashSet();
    localHashSet.add("filehelper");
    boolean bool = z.bBG();
    if (!bool) {
      if (Util.getInt(com.tencent.mm.k.i.aRC().getValue("BindQQSwitch"), 1) != 1) {}
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
      if (com.tencent.mm.au.b.OE((String)com.tencent.mm.kernel.h.baE().ban().d(274436, null)))
      {
        Log.i("MicroMsg.FTS.FTSMainAdapter", "checkLookVisibility EuropeanUnionCountry");
        localHashSet.add("65");
      }
      if (((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).dbw()) {
        localHashSet.add("63");
      }
      for (;;)
      {
        if (!((com.tencent.mm.plugin.appbrand.service.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.f.class)).bRX()) {
          localHashSet.add("69");
        }
        if (!((com.tencent.mm.plugin.appbrand.service.i)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.i.class)).bRX()) {
          localHashSet.add("71");
        }
        if (!((com.tencent.mm.openim.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.openim.api.c.class)).bRX()) {
          localHashSet.add("74");
        }
        if (!com.tencent.mm.contact.d.rs(((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE("gh_b4af18eac3d5").field_type)) {
          localHashSet.add("73");
        }
        if (!com.tencent.mm.contact.d.rs(((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE("gh_e087bb5b95e6").field_type)) {
          localHashSet.add("76");
        }
        d(localHashSet);
        AppMethodBeat.o(111950);
        return;
        i = 0;
        break;
        localHashSet.add("67");
      }
      i = bool;
    }
  }
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(111957);
    super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    Object localObject1 = (FTSMainUI)fyi();
    paramInt1 = ((ListView)paramAbsListView).getHeaderViewsCount();
    Object localObject2;
    long l;
    Object localObject3;
    Object localObject4;
    if ((((FTSBaseMainUI)localObject1).HxY == 1) && (paramAbsListView.getLastVisiblePosition() >= paramInt1 + ((FTSBaseMainUI)localObject1).HxP.getCount()) && (((FTSBaseMainUI)localObject1).HxP.Hzd) && (((FTSBaseMainUI)localObject1).HxR.getVisibility() == 0))
    {
      ((FTSBaseMainUI)localObject1).HxY = 2;
      localObject2 = ((FTSBaseMainUI)localObject1).HxP.HyV;
      l = cn.bDv();
      localObject3 = ((com.tencent.mm.plugin.fts.ui.d.b)localObject2).HCB.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (com.tencent.mm.plugin.fts.a.a.e)((Iterator)localObject3).next();
        if ("SearchContactBar".equals(((com.tencent.mm.plugin.fts.a.a.e)localObject4).hTs))
        {
          ((com.tencent.mm.plugin.fts.a.a.e)localObject4).HsA = (l - ((com.tencent.mm.plugin.fts.ui.d.b)localObject2).HxE);
          ((com.tencent.mm.plugin.fts.a.a.e)localObject4).HsF = l;
        }
      }
    }
    localObject1 = ((FTSBaseMainUI)localObject1).HxL;
    paramInt1 = ((ListView)paramAbsListView).getHeaderViewsCount();
    if ((paramAbsListView.getLastVisiblePosition() >= ((com.tencent.mm.plugin.fts.ui.widget.k)localObject1).HDH.HxP.getCount() + paramInt1) && (((com.tencent.mm.plugin.fts.ui.widget.k)localObject1).HDH.HxP.Hzd) && (((com.tencent.mm.plugin.fts.ui.widget.k)localObject1).Hxo == 1) && (((com.tencent.mm.plugin.fts.ui.widget.k)localObject1).Hyp.getVisibility() == 0))
    {
      Log.i("MicroMsg.FTS.PardusSearchLogic", "onScroll webEntry hasResult:%s hasSug:%s", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.fts.ui.widget.k)localObject1).HEB), Boolean.valueOf(((com.tencent.mm.plugin.fts.ui.widget.k)localObject1).HEA) });
      if (!((com.tencent.mm.plugin.fts.ui.widget.k)localObject1).HEB)
      {
        ((com.tencent.mm.plugin.fts.ui.widget.k)localObject1).Hxo = 2;
        localObject2 = ((com.tencent.mm.plugin.fts.ui.widget.k)localObject1).HDH.HxP.HyV;
        l = cn.bDv();
        localObject3 = ((com.tencent.mm.plugin.fts.ui.d.b)localObject2).HCB.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (com.tencent.mm.plugin.fts.a.a.e)((Iterator)localObject3).next();
          if ("SOSBar".equals(((com.tencent.mm.plugin.fts.a.a.e)localObject4).hTs))
          {
            ((com.tencent.mm.plugin.fts.a.a.e)localObject4).HsA = (l - ((com.tencent.mm.plugin.fts.ui.d.b)localObject2).HxE);
            ((com.tencent.mm.plugin.fts.a.a.e)localObject4).HsF = l;
          }
        }
      }
    }
    if ((paramAbsListView.getLastVisiblePosition() >= paramInt1 + ((com.tencent.mm.plugin.fts.ui.widget.k)localObject1).HDH.HxP.getCount()) && (((com.tencent.mm.plugin.fts.ui.widget.k)localObject1).HDH.HxP.Hzd) && (((com.tencent.mm.plugin.fts.ui.widget.k)localObject1).Hyr.getVisibility() == 0) && (!((com.tencent.mm.plugin.fts.ui.widget.k)localObject1).HEA))
    {
      paramInt3 = com.tencent.mm.cd.a.mt(((com.tencent.mm.plugin.fts.ui.widget.k)localObject1).HDH);
      paramInt1 = 0;
      if (paramInt1 < ((com.tencent.mm.plugin.fts.ui.widget.k)localObject1).Hyr.getChildCount())
      {
        paramAbsListView = ((com.tencent.mm.plugin.fts.ui.widget.k)localObject1).Hyr.getChildAt(paramInt1);
        localObject2 = new int[2];
        paramAbsListView.getLocationOnScreen((int[])localObject2);
        paramInt2 = paramAbsListView.getMeasuredHeight();
        int i = localObject2[1];
        paramAbsListView = (aqp)paramAbsListView.getTag();
        if (i + paramInt2 <= paramInt3)
        {
          localObject2 = ((com.tencent.mm.plugin.fts.ui.widget.k)localObject1).HDH.HxP.HyV;
          localObject3 = paramAbsListView.ZxJ;
          localObject3 = "SOSRelevant-" + ((fkk)localObject3).abgw;
          l = cn.bDv();
          localObject4 = ((com.tencent.mm.plugin.fts.ui.d.b)localObject2).HCB.iterator();
          while (((Iterator)localObject4).hasNext())
          {
            com.tencent.mm.plugin.fts.a.a.e locale = (com.tencent.mm.plugin.fts.a.a.e)((Iterator)localObject4).next();
            if ((((String)localObject3).equals(locale.hTs)) && (locale.HsA == 0L))
            {
              locale.HsA = (l - ((com.tencent.mm.plugin.fts.ui.d.b)localObject2).HxE);
              locale.HsF = l;
            }
          }
        }
        for (paramInt2 = 1;; paramInt2 = 0)
        {
          if (paramInt2 != 0) {
            ((com.tencent.mm.plugin.fts.ui.widget.k)localObject1).g(0, "", "", "", paramAbsListView.ZxJ.abgw);
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
      this.EKW = true;
      ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fts.a.n.class)).getFTSImageLoader().fxe();
      q.Qkh.pause();
      AppMethodBeat.o(111958);
      return;
    }
    this.EKW = false;
    if (!((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fts.a.n.class)).getFTSImageLoader().fxf())
    {
      this.Hzb.removeMessages(1);
      this.Hzb.sendEmptyMessageDelayed(1, 200L);
    }
    AppMethodBeat.o(111958);
  }
  
  final class a
    implements Runnable
  {
    private com.tencent.mm.plugin.fts.a.d.e Hzf;
    private String query;
    
    a(com.tencent.mm.plugin.fts.a.d.e parame, String paramString)
    {
      this.query = paramString;
      this.Hzf = parame;
    }
    
    public final void run()
    {
      AppMethodBeat.i(111946);
      if ((!k.a(k.this)) && (((com.tencent.mm.plugin.fts.a.d.e)k.b(k.this).get(k.b(k.this).size() - 1)).getType() == this.Hzf.getType())) {
        k.c(k.this);
      }
      k.d(k.this).HCx = k.this.Hzd;
      Object localObject1 = k.b(k.this).iterator();
      for (int i = 0; ((Iterator)localObject1).hasNext(); i = ((com.tencent.mm.plugin.fts.a.d.e)((Iterator)localObject1).next()).Wi(i)) {}
      k.this.setCount(i);
      k.this.notifyDataSetChanged();
      localObject1 = k.this;
      ((k)localObject1).aZ(i, ((k)localObject1).Hzd);
      if (k.this.Hzd) {
        k.d(k.this).HBX = System.currentTimeMillis();
      }
      localObject1 = k.d(k.this);
      Object localObject2 = this.Hzf;
      ((com.tencent.mm.plugin.fts.ui.d.b)localObject1).HCB.addAll(((com.tencent.mm.plugin.fts.a.d.e)localObject2).rs(((com.tencent.mm.plugin.fts.ui.d.b)localObject1).HxE));
      localObject1 = k.d(k.this);
      ((com.tencent.mm.plugin.fts.ui.d.b)localObject1).HCu = i;
      localObject2 = ((com.tencent.mm.plugin.fts.ui.d.b)localObject1).HCB.iterator();
      com.tencent.mm.plugin.fts.a.a.e locale;
      while (((Iterator)localObject2).hasNext())
      {
        locale = (com.tencent.mm.plugin.fts.a.a.e)((Iterator)localObject2).next();
        if ("SearchContactBar".equals(locale.hTs)) {
          locale.position = (((com.tencent.mm.plugin.fts.ui.d.b)localObject1).HCu + 1);
        }
      }
      localObject2 = ((com.tencent.mm.plugin.fts.ui.d.b)localObject1).HCB.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        locale = (com.tencent.mm.plugin.fts.a.a.e)((Iterator)localObject2).next();
        if ("SOSBar".equals(locale.hTs)) {
          if ((((com.tencent.mm.plugin.fts.ui.d.b)localObject1).HCq > 0) || (((com.tencent.mm.plugin.fts.ui.d.b)localObject1).HCr > 0)) {
            locale.position = (((com.tencent.mm.plugin.fts.ui.d.b)localObject1).HCu + 2);
          } else {
            locale.position = (((com.tencent.mm.plugin.fts.ui.d.b)localObject1).HCu + 1);
          }
        }
      }
      if ((((com.tencent.mm.plugin.fts.ui.d.b)localObject1).HCq > 0) || (((com.tencent.mm.plugin.fts.ui.d.b)localObject1).HCr > 0)) {}
      for (i = ((com.tencent.mm.plugin.fts.ui.d.b)localObject1).HCu + 3;; i = ((com.tencent.mm.plugin.fts.ui.d.b)localObject1).HCu + 2)
      {
        localObject1 = ((com.tencent.mm.plugin.fts.ui.d.b)localObject1).HCB.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (com.tencent.mm.plugin.fts.a.a.e)((Iterator)localObject1).next();
          if (((com.tencent.mm.plugin.fts.a.a.e)localObject2).hTs.startsWith("SOSRelevant")) {
            ((com.tencent.mm.plugin.fts.a.a.e)localObject2).position = i;
          }
        }
      }
      AppMethodBeat.o(111946);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.k
 * JD-Core Version:    0.7.0.1
 */