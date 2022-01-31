package com.tencent.mm.plugin.fts.ui;

import android.os.Looper;
import android.view.View;
import android.widget.AbsListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.qz;
import com.tencent.mm.g.a.qz.b;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.fts.a.d.e.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.ui.a.h;
import com.tencent.mm.plugin.fts.ui.a.i;
import com.tencent.mm.plugin.fts.ui.b.l;
import com.tencent.mm.plugin.fts.ui.c.b.a;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.websearch.api.an;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class j
  extends d
  implements e.b
{
  private boolean jcK;
  private ak mWd;
  int mWt;
  private boolean mXA;
  boolean mXb;
  boolean mXk;
  private List<com.tencent.mm.plugin.fts.a.d.e> mXn;
  private com.tencent.mm.plugin.fts.ui.d.n mXo;
  com.tencent.mm.plugin.fts.ui.c.b mXp;
  private j.b mXq;
  private boolean mXr;
  private long mXs;
  private long mXt;
  private long mXu;
  private long mXv;
  private ak mXw;
  private int mXx;
  private boolean mXy;
  boolean mXz;
  
  public j(e parame, int paramInt, j.b paramb)
  {
    super(parame);
    AppMethodBeat.i(61852);
    this.mXq = null;
    this.mWt = 1;
    this.mXw = new j.1(this, Looper.getMainLooper());
    this.mWd = new ak(Looper.getMainLooper());
    this.mXx = -1;
    this.mXp = new com.tencent.mm.plugin.fts.ui.c.b();
    parame = new HashSet();
    parame.add(Integer.valueOf(16));
    parame.add(Integer.valueOf(32));
    parame.add(Integer.valueOf(48));
    parame.add(Integer.valueOf(64));
    parame.add(Integer.valueOf(128));
    parame.add(Integer.valueOf(96));
    parame.add(Integer.valueOf(112));
    if (com.tencent.mm.kernel.g.RG())
    {
      qz localqz = new qz();
      com.tencent.mm.sdk.b.a.ymk.l(localqz);
      com.tencent.mm.storage.c localc = com.tencent.mm.model.c.c.abU().me("100193");
      if ((!localc.isValid()) || (!"1".equals(localc.dvN().get("isOpenLocalSearch"))) || (!localqz.cHt.cHv)) {}
    }
    for (;;)
    {
      if (i != 0) {
        parame.add(Integer.valueOf(144));
      }
      if (com.tencent.mm.modelappbrand.a.acg()) {
        parame.add(Integer.valueOf(208));
      }
      this.mXn = ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.fts.a.n.class)).createFTSUIUnitList(parame, getContext(), this, paramInt);
      this.mXo = ((com.tencent.mm.plugin.fts.ui.d.n)new l().a(getContext(), this, paramInt));
      this.mXq = paramb;
      AppMethodBeat.o(61852);
      return;
      i = 0;
    }
  }
  
  private boolean bCL()
  {
    return (this.mXz) && (this.mXy);
  }
  
  private void c(HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(61862);
    this.mXx += 1;
    if (this.mXx < this.mXn.size()) {
      ((com.tencent.mm.plugin.fts.a.d.e)this.mXn.get(this.mXx)).a(this.query, this.mWd, paramHashSet, com.tencent.mm.plugin.fts.a.e.mRl);
    }
    AppMethodBeat.o(61862);
  }
  
  private int wx(int paramInt)
  {
    AppMethodBeat.i(61859);
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.mXn.iterator();
    while (localIterator.hasNext()) {
      localArrayList.addAll(((com.tencent.mm.plugin.fts.a.d.e)localIterator.next()).bCe());
    }
    int j = localArrayList.size() - 1;
    if (j >= 0)
    {
      if (paramInt < ((Integer)localArrayList.get(j)).intValue()) {
        break label113;
      }
      i += 1;
    }
    label113:
    for (;;)
    {
      j -= 1;
      break;
      AppMethodBeat.o(61859);
      return i;
    }
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.d.e parame, String paramString)
  {
    AppMethodBeat.i(61861);
    if ((parame instanceof a))
    {
      Object localObject = (a)parame;
      if (paramString.equals(this.query)) {
        c(((a)localObject).mSS);
      }
      if ((((a)localObject).bCx() > 0) && (this.mXs == 0L))
      {
        this.mXs = (System.currentTimeMillis() - this.mWI);
        k.R(9, this.mXs);
        ab.i("MicroMsg.FTS.FTSMainAdapter", "firstItemTime=%d", new Object[] { Long.valueOf(this.mXs) });
      }
      com.tencent.mm.plugin.fts.ui.c.b localb;
      switch (((a)localObject).getType())
      {
      default: 
        localb = this.mXp;
        localObject = ((a)localObject).mVO.iterator();
      }
      for (;;)
      {
        if (!((Iterator)localObject).hasNext()) {
          break label629;
        }
        e.a locala = (e.a)((Iterator)localObject).next();
        switch (locala.businessType)
        {
        case -14: 
        case -12: 
        case -10: 
        case -9: 
        default: 
          break;
        case -15: 
          localb.nap = locala.mTC.size();
          continue;
          if (this.mXt != 0L) {
            break;
          }
          this.mXt = (System.currentTimeMillis() - this.mWI);
          ab.i("MicroMsg.FTS.FTSMainAdapter", "firstGetTopHitsTime=%d", new Object[] { Long.valueOf(this.mXt) });
          k.R(0, this.mXt);
          break;
          if (this.mXu != 0L) {
            break;
          }
          this.mXu = (System.currentTimeMillis() - this.mWI);
          ab.i("MicroMsg.FTS.FTSMainAdapter", "firstGetContactTime=%d", new Object[] { Long.valueOf(this.mXu) });
          k.R(3, this.mXu);
          break;
          if (this.mXv != 0L) {
            break;
          }
          this.mXv = (System.currentTimeMillis() - this.mWI);
          ab.i("MicroMsg.FTS.FTSMainAdapter", "firstGetChatroomTime=%d", new Object[] { Long.valueOf(this.mXv) });
          k.R(6, this.mXv);
          break;
        case -2: 
          localb.nal = locala.mTC.size();
          break;
        case -4: 
          localb.nai = locala.mTC.size();
          break;
        case -6: 
          localb.nam = locala.mTC.size();
          break;
        case -3: 
          localb.naj = locala.mTC.size();
          break;
        case -1: 
          localb.nan = locala.mTC.size();
          break;
        case -11: 
          localb.naq = locala.mTC.size();
          break;
        case -7: 
          localb.nak = locala.mTC.size();
          break;
        case -5: 
          localb.nao = locala.mTC.size();
          break;
        case -8: 
          localb.nah = locala.mTC.size();
          break;
        case -13: 
          localb.nar = locala.mTC.size();
        }
      }
    }
    this.mXp.nas = parame.bCf();
    label629:
    this.mXp.naz = bCf();
    new j.a(this, parame, paramString).run();
    AppMethodBeat.o(61861);
  }
  
  protected final boolean a(View paramView, com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(61858);
    Iterator localIterator = this.mXn.iterator();
    boolean bool;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      bool = ((com.tencent.mm.plugin.fts.a.d.e)localIterator.next()).a(paramView, parama, paramBoolean);
      paramBoolean = bool;
    } while (!bool);
    if ((!this.mXb) && (!(parama instanceof com.tencent.mm.plugin.fts.ui.a.n)))
    {
      k.a(this.query, true, bCf(), 0, this.mXp);
      this.mXb = true;
    }
    if (parama.mTP)
    {
      this.mXA = true;
      ab.d("MicroMsg.FTS.FTSMainAdapter", "searchType=%d | searchScene=%d | kvPosition=%d | kvSubPosition=%d | kvSearchId=%s | kvDocId=%d", new Object[] { Integer.valueOf(parama.lox), Integer.valueOf(parama.ibk), Integer.valueOf(parama.mTI), Integer.valueOf(parama.mTJ), parama.mTK, Long.valueOf(parama.mTL) });
      if (!bo.isNullOrNil(this.query)) {
        an.m(this.query, this.mWt, 1, 3);
      }
      this.mXp.nat = wx(parama.position);
      this.mXp.c(parama);
      k.a(parama, this.mXp);
      AppMethodBeat.o(61858);
      return true;
    }
    if ((parama instanceof h))
    {
      this.mXk = true;
      if (!bo.isNullOrNil(this.query)) {
        an.m(this.query, this.mWt, 1, 3);
      }
      this.mXp.nat = wx(parama.position);
      this.mXp.c(parama);
      k.a(parama, this.mXp);
    }
    for (;;)
    {
      AppMethodBeat.o(61858);
      return false;
      if ((parama instanceof i))
      {
        this.mXp.nat = wx(parama.position);
        k.a(parama, this.mXp);
        this.mXp.c(parama);
      }
    }
  }
  
  protected final int bCf()
  {
    AppMethodBeat.i(61865);
    Iterator localIterator = this.mXn.iterator();
    for (int i = 0; localIterator.hasNext(); i = ((com.tencent.mm.plugin.fts.a.d.e)localIterator.next()).bCf() + i) {}
    int j = this.mXo.bCf();
    AppMethodBeat.o(61865);
    return j + i;
  }
  
  protected final void bCy()
  {
    int i = 1;
    AppMethodBeat.i(61854);
    if ((!bo.isNullOrNil(this.mXp.query)) && (!this.mXr) && (this.mXp.nag != 0L))
    {
      k.a(this.mXp);
      k.b(this.mXp);
      this.mXr = true;
    }
    this.mXr = false;
    this.mXb = false;
    this.mXk = false;
    this.mXx = -1;
    this.mXz = false;
    this.mXy = false;
    this.mXp.reset();
    com.tencent.mm.plugin.fts.a.e.mRl = com.tencent.mm.plugin.fts.a.d.wp(3);
    this.mXp.nag = com.tencent.mm.plugin.fts.a.e.mRl;
    this.mXp.query = this.query;
    this.mXp.mWI = System.currentTimeMillis();
    this.mWt = 1;
    this.mXs = 0L;
    this.mXt = 0L;
    this.mXu = 0L;
    this.mXv = 0L;
    HashSet localHashSet = new HashSet();
    localHashSet.add("filehelper");
    boolean bool = r.ZT();
    if (!bool) {
      if (bo.getInt(com.tencent.mm.m.g.Nq().getValue("BindQQSwitch"), 1) != 1) {}
    }
    for (;;)
    {
      if (i == 0)
      {
        ab.i("MicroMsg.FTS.FTSMainAdapter", "summerqq BindQQSwitch off");
        localHashSet.add("22");
        localHashSet.add("23");
      }
      if (!com.tencent.mm.modelappbrand.a.acg()) {
        localHashSet.add("61");
      }
      localHashSet.add("62");
      if (com.tencent.mm.au.b.tM((String)com.tencent.mm.kernel.g.RL().Ru().get(274436, null)))
      {
        ab.i("MicroMsg.FTS.FTSMainAdapter", "checkLookVisibility EuropeanUnionCountry");
        localHashSet.add("65");
      }
      if (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.brandservice.a.b.class)).aWl()) {
        localHashSet.add("63");
      }
      for (;;)
      {
        c(localHashSet);
        this.mXo.a(this.query, this.mWd, null, com.tencent.mm.plugin.fts.a.e.mRl);
        AppMethodBeat.o(61854);
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
    AppMethodBeat.i(61856);
    super.clearCache();
    Iterator localIterator = this.mXn.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.fts.a.d.e locale = (com.tencent.mm.plugin.fts.a.d.e)localIterator.next();
      locale.bCd();
      locale.clearData();
    }
    this.mXo.bCd();
    this.mXo.clearData();
    AppMethodBeat.o(61856);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(61855);
    if (!this.mXb)
    {
      this.mXb = true;
      if (!this.mXk) {
        k.a(this.query, false, bCf(), 0, this.mXp);
      }
    }
    if (!this.mXr)
    {
      this.mXr = true;
      k.a(this.mXp);
      k.b(this.mXp);
    }
    if ((!this.mXk) && (!this.mXA)) {
      an.m(this.query, this.mWt, 3, 3);
    }
    this.mXp.reset();
    super.finish();
    AppMethodBeat.o(61855);
  }
  
  public final int getBlockCount()
  {
    AppMethodBeat.i(61860);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.mXn.iterator();
    while (localIterator.hasNext()) {
      localArrayList.addAll(((com.tencent.mm.plugin.fts.a.d.e)localIterator.next()).bCe());
    }
    int i = localArrayList.size();
    AppMethodBeat.o(61860);
    return i;
  }
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(61863);
    super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    if ((paramAbsListView.getLastVisiblePosition() == getCount()) && (bCL()))
    {
      this.mWt = 2;
      paramAbsListView = this.mXp;
      paramInt1 = getCount();
      long l = this.mXp.nae;
      b.a locala = new b.a(paramAbsListView);
      locala.position = (paramInt1 + 1);
      locala.itemType = 18;
      locala.mZT = (System.currentTimeMillis() - paramAbsListView.mWI);
      locala.naC = (l - paramAbsListView.mWI);
      locala.feA = "sosBar";
      if (!paramAbsListView.naB.contains(locala)) {
        paramAbsListView.naB.add(locala);
      }
      if (this.mXq != null)
      {
        this.mXq.bCM();
        this.mXq.bCN();
        AppMethodBeat.o(61863);
      }
    }
    else if (this.mXq != null)
    {
      this.mXq.bCO();
    }
    AppMethodBeat.o(61863);
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(61864);
    super.onScrollStateChanged(paramAbsListView, paramInt);
    if (paramInt == 2)
    {
      this.jcK = true;
      ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.fts.a.n.class)).getFTSImageLoader().bBJ();
      com.tencent.mm.plugin.sns.b.n.raQ.pause();
      AppMethodBeat.o(61864);
      return;
    }
    this.jcK = false;
    if (!((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.fts.a.n.class)).getFTSImageLoader().bBK())
    {
      this.mXw.removeMessages(1);
      this.mXw.sendEmptyMessageDelayed(1, 200L);
    }
    AppMethodBeat.o(61864);
  }
  
  public final void stopSearch()
  {
    AppMethodBeat.i(61857);
    this.mXw.removeMessages(1);
    super.stopSearch();
    AppMethodBeat.o(61857);
  }
  
  protected final com.tencent.mm.plugin.fts.a.d.a.a wu(int paramInt)
  {
    AppMethodBeat.i(61853);
    long l = 0L;
    com.tencent.mm.plugin.fts.a.d.a.a locala = null;
    Object localObject1 = this.mXn.iterator();
    for (;;)
    {
      Object localObject2;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.tencent.mm.plugin.fts.a.d.e)((Iterator)localObject1).next();
        locala = ((com.tencent.mm.plugin.fts.a.d.e)localObject2).wu(paramInt);
        l = ((com.tencent.mm.plugin.fts.a.d.e)localObject2).bCg();
        if (locala == null) {}
      }
      else
      {
        for (;;)
        {
          if (locala == null)
          {
            locala = this.mXo.wu(paramInt);
            l = this.mXo.mVN;
          }
          for (;;)
          {
            if (locala != null)
            {
              localObject1 = new LinkedList();
              localObject2 = this.mXn.iterator();
              while (((Iterator)localObject2).hasNext()) {
                ((LinkedList)localObject1).addAll(((com.tencent.mm.plugin.fts.a.d.e)((Iterator)localObject2).next()).bCe());
              }
              i = ((LinkedList)localObject1).size() - 1;
              if (i < 0) {
                break label333;
              }
              if (paramInt <= ((Integer)((LinkedList)localObject1).get(i)).intValue()) {
                break label326;
              }
            }
            label326:
            label333:
            for (int i = paramInt - i;; i = paramInt)
            {
              locala.mTI = i;
              locala.pageType = 1;
              localObject1 = this.mXp;
              localObject2 = new b.a((com.tencent.mm.plugin.fts.ui.c.b)localObject1);
              ((b.a)localObject2).position = locala.position;
              ((b.a)localObject2).itemType = k.b(locala);
              ((b.a)localObject2).mZT = (System.currentTimeMillis() - ((com.tencent.mm.plugin.fts.ui.c.b)localObject1).mWI);
              ((b.a)localObject2).naC = (l - ((com.tencent.mm.plugin.fts.ui.c.b)localObject1).mWI);
              ((b.a)localObject2).feA = String.valueOf(locala.hashCode());
              ((com.tencent.mm.plugin.fts.ui.c.b)localObject1).naB.add(localObject2);
              if (locala == null) {
                ab.e("MicroMsg.FTS.FTSMainAdapter", "Create Data Item Error: getCount-%d position-%d", new Object[] { Integer.valueOf(getCount()), Integer.valueOf(paramInt) });
              }
              AppMethodBeat.o(61853);
              return locala;
              i -= 1;
              break;
            }
          }
        }
      }
    }
  }
  
  public final void wy(int paramInt)
  {
    this.mXp.nau = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.j
 * JD-Core Version:    0.7.0.1
 */