package com.tencent.mm.plugin.fts.ui;

import android.os.Looper;
import android.view.View;
import android.widget.AbsListView;
import com.tencent.mm.h.a.ps;
import com.tencent.mm.h.a.ps.b;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.fts.a.d.e.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.ui.a.h;
import com.tencent.mm.plugin.fts.ui.a.i;
import com.tencent.mm.plugin.fts.ui.c.b;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.websearch.api.ao;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
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
  private boolean hps;
  int kAB = 1;
  private ah kAl = new ah(Looper.getMainLooper());
  private long kBA;
  private long kBB;
  private ah kBC = new j.1(this, Looper.getMainLooper());
  private int kBD = -1;
  boolean kBE;
  private boolean kBF;
  private boolean kBj;
  boolean kBs;
  private List<com.tencent.mm.plugin.fts.a.d.e> kBv;
  b kBw = new b();
  private j.b kBx = null;
  private long kBy;
  private long kBz;
  
  public j(e parame, int paramInt, j.b paramb)
  {
    super(parame);
    parame = new HashSet();
    parame.add(Integer.valueOf(16));
    parame.add(Integer.valueOf(32));
    parame.add(Integer.valueOf(48));
    parame.add(Integer.valueOf(64));
    parame.add(Integer.valueOf(128));
    parame.add(Integer.valueOf(96));
    parame.add(Integer.valueOf(112));
    if (com.tencent.mm.kernel.g.DK())
    {
      ps localps = new ps();
      com.tencent.mm.sdk.b.a.udP.m(localps);
      com.tencent.mm.storage.c localc = com.tencent.mm.model.c.c.IX().fJ("100193");
      if ((!localc.isValid()) || (!"1".equals(localc.ctr().get("isOpenLocalSearch"))) || (!localps.bZi.bZk)) {}
    }
    for (;;)
    {
      if (i != 0) {
        parame.add(Integer.valueOf(144));
      }
      if (com.tencent.mm.modelappbrand.a.Jj()) {
        parame.add(Integer.valueOf(208));
      }
      this.kBv = ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.fts.a.n.class)).createFTSUIUnitList(parame, getContext(), this, paramInt);
      this.kBx = paramb;
      return;
      i = 0;
    }
  }
  
  private void c(HashSet<String> paramHashSet)
  {
    this.kBD += 1;
    if (this.kBD < this.kBv.size()) {
      ((com.tencent.mm.plugin.fts.a.d.e)this.kBv.get(this.kBD)).a(this.bVk, this.kAl, paramHashSet);
    }
  }
  
  private int rB(int paramInt)
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.kBv.iterator();
    while (localIterator.hasNext()) {
      localArrayList.addAll(((com.tencent.mm.plugin.fts.a.d.e)localIterator.next()).aVD());
    }
    int j = localArrayList.size() - 1;
    if (j >= 0)
    {
      if (paramInt < ((Integer)localArrayList.get(j)).intValue()) {
        break label103;
      }
      i += 1;
    }
    label103:
    for (;;)
    {
      j -= 1;
      break;
      return i;
    }
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.d.e parame, String paramString)
  {
    Object localObject = (a)parame;
    if (paramString.equals(this.bVk)) {
      c(((a)localObject).kxd);
    }
    if ((((a)localObject).aVU() > 0) && (this.kBy == 0L))
    {
      this.kBy = (System.currentTimeMillis() - this.kAQ);
      k.A(9, this.kBy);
      y.i("MicroMsg.FTS.FTSMainAdapter", "firstItemTime=%d", new Object[] { Long.valueOf(this.kBy) });
    }
    b localb;
    switch (((a)localObject).getType())
    {
    default: 
      localb = this.kBw;
      localObject = ((a)localObject).kzW.iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject).hasNext()) {
        break label604;
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
        localb.kEf = locala.kxO.size();
        continue;
        if (this.kBz != 0L) {
          break;
        }
        this.kBz = (System.currentTimeMillis() - this.kAQ);
        y.i("MicroMsg.FTS.FTSMainAdapter", "firstGetTopHitsTime=%d", new Object[] { Long.valueOf(this.kBz) });
        k.A(0, this.kBz);
        break;
        if (this.kBA != 0L) {
          break;
        }
        this.kBA = (System.currentTimeMillis() - this.kAQ);
        y.i("MicroMsg.FTS.FTSMainAdapter", "firstGetContactTime=%d", new Object[] { Long.valueOf(this.kBA) });
        k.A(3, this.kBA);
        break;
        if (this.kBB != 0L) {
          break;
        }
        this.kBB = (System.currentTimeMillis() - this.kAQ);
        y.i("MicroMsg.FTS.FTSMainAdapter", "firstGetChatroomTime=%d", new Object[] { Long.valueOf(this.kBB) });
        k.A(6, this.kBB);
        break;
      case -2: 
        localb.kEb = locala.kxO.size();
        break;
      case -4: 
        localb.kDY = locala.kxO.size();
        break;
      case -6: 
        localb.kEc = locala.kxO.size();
        break;
      case -3: 
        localb.kDZ = locala.kxO.size();
        break;
      case -1: 
        localb.kEd = locala.kxO.size();
        break;
      case -11: 
        localb.kEg = locala.kxO.size();
        break;
      case -7: 
        localb.kEa = locala.kxO.size();
        break;
      case -5: 
        localb.kEe = locala.kxO.size();
        break;
      case -8: 
        localb.kDX = locala.kxO.size();
        break;
      case -13: 
        localb.kEh = locala.kxO.size();
      }
    }
    label604:
    new j.a(this, parame, paramString).run();
  }
  
  protected final boolean a(View paramView, com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean)
  {
    Iterator localIterator = this.kBv.iterator();
    boolean bool;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      bool = ((com.tencent.mm.plugin.fts.a.d.e)localIterator.next()).a(paramView, parama, paramBoolean);
      paramBoolean = bool;
    } while (!bool);
    if (parama.kyc)
    {
      this.kBF = true;
      y.d("MicroMsg.FTS.FTSMainAdapter", "searchType=%d | searchScene=%d | kvPosition=%d | kvSubPosition=%d | kvSearchId=%s | kvDocId=%d", new Object[] { Integer.valueOf(parama.kxU), Integer.valueOf(parama.kxJ), Integer.valueOf(parama.kxV), Integer.valueOf(parama.kxW), parama.kxX, Long.valueOf(parama.kxY) });
      if (!this.kBj)
      {
        k.a(this.bVk, true, aVE(), 0, this.kBw);
        this.kBj = true;
      }
      if (!bk.bl(this.bVk)) {
        ao.i(this.bVk, this.kAB, 1, 3);
      }
      this.kBw.kEi = rB(parama.position);
      k.a(parama, this.kBw);
      return true;
    }
    if ((parama instanceof h))
    {
      this.kBs = true;
      if (!bk.bl(this.bVk)) {
        ao.i(this.bVk, this.kAB, 1, 3);
      }
      this.kBw.kEi = rB(parama.position);
      k.a(parama, this.kBw);
    }
    for (;;)
    {
      return false;
      if ((parama instanceof i))
      {
        this.kBw.kEi = rB(parama.position);
        k.a(parama, this.kBw);
      }
    }
  }
  
  protected final int aVE()
  {
    Iterator localIterator = this.kBv.iterator();
    for (int i = 0; localIterator.hasNext(); i = ((com.tencent.mm.plugin.fts.a.d.e)localIterator.next()).aVE() + i) {}
    return i;
  }
  
  protected final void aVV()
  {
    this.kBj = false;
    this.kBs = false;
    this.kBD = -1;
    this.kBE = false;
    k.a(this.kBw);
    this.kBw.reset();
    this.kBw.bVk = this.bVk;
    this.kAB = 1;
    this.kBy = 0L;
    this.kBz = 0L;
    this.kBA = 0L;
    this.kBB = 0L;
    HashSet localHashSet = new HashSet();
    localHashSet.add("filehelper");
    boolean bool2 = q.GR();
    boolean bool1 = bool2;
    if (!bool2) {
      if (bk.getInt(com.tencent.mm.m.g.AA().getValue("BindQQSwitch"), 1) != 1) {
        break label195;
      }
    }
    label195:
    for (bool1 = true;; bool1 = false)
    {
      if (!bool1)
      {
        y.i("MicroMsg.FTS.FTSMainAdapter", "summerqq BindQQSwitch off");
        localHashSet.add("22");
        localHashSet.add("23");
      }
      if (!com.tencent.mm.modelappbrand.a.Jj()) {
        localHashSet.add("61");
      }
      localHashSet.add("62");
      y.d("MicroMsg.FTS.FTSMainAdapter", "summerqq doSearch blockSet[%d]", new Object[] { Integer.valueOf(localHashSet.size()) });
      c(localHashSet);
      return;
    }
  }
  
  protected final void clearCache()
  {
    super.clearCache();
    Iterator localIterator = this.kBv.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.fts.a.d.e locale = (com.tencent.mm.plugin.fts.a.d.e)localIterator.next();
      locale.aVC();
      locale.adg();
    }
  }
  
  public final void finish()
  {
    if (!this.kBj)
    {
      this.kBj = true;
      if (!this.kBs) {
        k.a(this.bVk, false, aVE(), 0, this.kBw);
      }
    }
    if ((!this.kBs) && (!this.kBF)) {
      ao.i(this.bVk, this.kAB, 3, 3);
    }
    this.kBw.reset();
    super.finish();
  }
  
  public final int getBlockCount()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.kBv.iterator();
    while (localIterator.hasNext()) {
      localArrayList.addAll(((com.tencent.mm.plugin.fts.a.d.e)localIterator.next()).aVD());
    }
    return localArrayList.size();
  }
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    if ((paramAbsListView.getLastVisiblePosition() == getCount()) && (this.kBE))
    {
      this.kAB = 2;
      if (this.kBx != null)
      {
        this.kBx.aWj();
        this.kBx.aWk();
      }
    }
    while (this.kBx == null) {
      return;
    }
    this.kBx.aWl();
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    super.onScrollStateChanged(paramAbsListView, paramInt);
    if (paramInt == 2)
    {
      this.hps = true;
      ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.fts.a.n.class)).getFTSImageLoader().aVk();
      com.tencent.mm.plugin.sns.b.n.omC.pause();
    }
    do
    {
      return;
      this.hps = false;
    } while (((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.fts.a.n.class)).getFTSImageLoader().aVl());
    this.kBC.removeMessages(1);
    this.kBC.sendEmptyMessageDelayed(1, 200L);
  }
  
  public final void rC(int paramInt)
  {
    this.kBw.kEj = paramInt;
  }
  
  protected final com.tencent.mm.plugin.fts.a.d.a.a ry(int paramInt)
  {
    Object localObject1 = null;
    Iterator localIterator = this.kBv.iterator();
    Object localObject2;
    while (localIterator.hasNext())
    {
      localObject2 = ((com.tencent.mm.plugin.fts.a.d.e)localIterator.next()).ry(paramInt);
      localObject1 = localObject2;
      if (localObject2 != null) {
        localObject1 = localObject2;
      }
    }
    if (localObject1 != null)
    {
      localObject2 = new LinkedList();
      localIterator = this.kBv.iterator();
      while (localIterator.hasNext()) {
        ((LinkedList)localObject2).addAll(((com.tencent.mm.plugin.fts.a.d.e)localIterator.next()).aVD());
      }
      i = ((LinkedList)localObject2).size() - 1;
      if (i < 0) {
        break label195;
      }
      if (paramInt <= ((Integer)((LinkedList)localObject2).get(i)).intValue()) {
        break label188;
      }
    }
    label188:
    label195:
    for (int i = paramInt - i;; i = paramInt)
    {
      localObject1.kxV = i;
      localObject1.pageType = 1;
      if (localObject1 == null) {
        y.e("MicroMsg.FTS.FTSMainAdapter", "Create Data Item Error: getCount-%d position-%d", new Object[] { Integer.valueOf(getCount()), Integer.valueOf(paramInt) });
      }
      return localObject1;
      i -= 1;
      break;
    }
  }
  
  public final void stopSearch()
  {
    this.kBC.removeMessages(1);
    super.stopSearch();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.j
 * JD-Core Version:    0.7.0.1
 */