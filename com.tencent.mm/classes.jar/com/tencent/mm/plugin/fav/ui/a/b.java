package com.tencent.mm.plugin.fav.ui.a;

import android.content.Context;
import android.content.res.Resources;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ListView;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.ui.d.a.b;
import com.tencent.mm.plugin.fav.ui.d.a.c;
import com.tencent.mm.plugin.fav.ui.d.d;
import com.tencent.mm.plugin.fav.ui.d.e;
import com.tencent.mm.plugin.fav.ui.d.f;
import com.tencent.mm.plugin.fav.ui.d.i;
import com.tencent.mm.plugin.fav.ui.d.j;
import com.tencent.mm.plugin.fav.ui.d.k;
import com.tencent.mm.plugin.fav.ui.d.m;
import com.tencent.mm.plugin.fav.ui.d.n;
import com.tencent.mm.plugin.fav.ui.d.o;
import com.tencent.mm.plugin.fav.ui.d.p;
import com.tencent.mm.plugin.fav.ui.d.q;
import com.tencent.mm.plugin.fav.ui.n.b;
import com.tencent.mm.plugin.fav.ui.n.i;
import com.tencent.mm.protocal.c.yl;
import com.tencent.mm.protocal.c.yw;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public final class b
  extends a
{
  public String bVk = "";
  private com.tencent.mm.sdk.b.c giK = new b.1(this);
  public int jYS;
  private boolean keB = false;
  public List<com.tencent.mm.plugin.fav.a.g> keC = new ArrayList();
  private List<com.tencent.mm.plugin.fav.a.g> keD = new ArrayList();
  private List<com.tencent.mm.plugin.fav.a.g> keE = new LinkedList();
  public List<Long> keF = new ArrayList();
  public boolean keG = false;
  private Map<Long, com.tencent.mm.plugin.fav.a.g> keH = new TreeMap();
  private List<Integer> keI = new ArrayList();
  private List<String> keJ = new LinkedList();
  private List<String> keK = new LinkedList();
  private SparseArray<com.tencent.mm.plugin.fav.ui.d.a> keL = new SparseArray();
  private boolean keM = false;
  public a.c keN;
  public boolean keO = false;
  public boolean keP = false;
  public ListView keQ;
  public int scene;
  
  public b(com.tencent.mm.plugin.fav.ui.l paraml, boolean paramBoolean)
  {
    this.type = -1;
    this.keL.put(1, new m(paraml));
    this.keL.put(2, new d(paraml));
    this.keL.put(3, new q(paraml));
    this.keL.put(4, new p(paraml));
    this.keL.put(5, new o(paraml));
    this.keL.put(6, new e(paraml));
    this.keL.put(7, new com.tencent.mm.plugin.fav.ui.d.g(paraml));
    this.keL.put(8, new com.tencent.mm.plugin.fav.ui.d.c(paraml));
    this.keL.put(10, new i(paraml));
    this.keL.put(12, new com.tencent.mm.plugin.fav.ui.d.l(paraml));
    this.keL.put(15, new com.tencent.mm.plugin.fav.ui.d.l(paraml));
    this.keL.put(11, new f(paraml));
    this.keL.put(14, new j(paraml));
    this.keL.put(16, new k(paraml));
    this.keL.put(17, new com.tencent.mm.plugin.fav.ui.d.b(paraml));
    this.keL.put(18, new com.tencent.mm.plugin.fav.ui.d.h(paraml));
    this.keL.put(-2, new n(paraml));
    if (paramBoolean != this.keO)
    {
      this.keO = paramBoolean;
      if (paramBoolean) {
        this.keH.clear();
      }
    }
    if (!this.keO) {
      aRz();
    }
    aRA();
    notifyDataSetChanged();
    com.tencent.mm.sdk.b.a.udP.d(this.giK);
    com.tencent.mm.sdk.b.a.udP.c(this.giK);
  }
  
  private boolean aRB()
  {
    return (!this.keJ.isEmpty()) || (!this.keK.isEmpty()) || (!this.keI.isEmpty());
  }
  
  private static List<com.tencent.mm.plugin.fav.a.g> f(List<com.tencent.mm.plugin.fav.a.g> paramList, List<Long> paramList1)
  {
    int k = 0;
    ArrayList localArrayList = new ArrayList();
    if (paramList1 == null) {
      return localArrayList;
    }
    int i = k;
    long l;
    int j;
    if (paramList != null)
    {
      i = k;
      if (paramList.size() > 0)
      {
        localArrayList.addAll(paramList);
        l = ((com.tencent.mm.plugin.fav.a.g)paramList.get(paramList.size() - 1)).field_localId;
        j = 0;
      }
    }
    for (;;)
    {
      i = k;
      if (j < paramList1.size())
      {
        if (Long.valueOf(l).equals(paramList1.get(j))) {
          i = j + 1;
        }
      }
      else
      {
        j = i;
        while ((j < i + 20) && (j < paramList1.size()))
        {
          paramList = ((com.tencent.mm.plugin.fav.a.ae)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.fav.a.ae.class)).getFavItemInfoStorage().eE(((Long)paramList1.get(j)).longValue());
          if (paramList != null) {
            localArrayList.add(paramList);
          }
          j += 1;
        }
      }
      j += 1;
    }
    return localArrayList;
  }
  
  private void rc(int paramInt)
  {
    int i = this.jYS;
    if (paramInt == 0) {
      this.jYS = 0;
    }
    do
    {
      return;
      if (i == 0)
      {
        this.jYS = paramInt;
        return;
      }
    } while (i == paramInt);
    this.jYS = 4;
  }
  
  public final void a(boolean paramBoolean, com.tencent.mm.plugin.fav.a.g paramg)
  {
    if (paramBoolean == this.keG) {
      return;
    }
    this.keG = paramBoolean;
    if (paramBoolean)
    {
      this.keH.clear();
      if (paramg != null)
      {
        paramg = ((com.tencent.mm.plugin.fav.a.ae)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.fav.a.ae.class)).getFavItemInfoStorage().eE(paramg.field_localId);
        if (paramg != null) {
          this.keH.put(Long.valueOf(paramg.field_localId), paramg);
        }
      }
    }
    notifyDataSetChanged();
  }
  
  public final void aRA()
  {
    y.v("MicroMsg.FavoriteAdapter", "reset data list beg");
    this.keB = false;
    List localList = this.keD;
    if (localList != null)
    {
      y.d("MicroMsg.FavoriteAdapter", "before do recycle, need recycle list size[%d]", new Object[] { Integer.valueOf(localList.size()) });
      y.d("MicroMsg.FavoriteAdapter", "after do recycle, current can reused list size[%d]", new Object[] { Integer.valueOf(this.keE.size()) });
      localList.clear();
    }
    if (!aRB())
    {
      y.i("MicroMsg.FavoriteAdapter", "on reset data list, last update time is %d, type is %d", new Object[] { Long.valueOf(this.lastUpdateTime), Integer.valueOf(this.type) });
      if (!this.keO)
      {
        this.keD = com.tencent.mm.plugin.fav.a.b.a(this.lastUpdateTime, this.type, this.kex, this.kez);
        if ((this.keD != null) && (this.lastUpdateTime == 0L) && (this.keD.size() > 0)) {
          this.lastUpdateTime = ((com.tencent.mm.plugin.fav.a.g)this.keD.get(this.keD.size() - 1)).field_updateTime;
        }
      }
      for (;;)
      {
        if (this.keD == null)
        {
          y.w("MicroMsg.FavoriteAdapter", "reset data list fail, get null list, new empty one");
          this.keD = new ArrayList();
        }
        if ((!this.keO) && (!aRB()) && (this.keD.size() < 20) && (!((com.tencent.mm.plugin.fav.a.ae)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.fav.a.ae.class)).getFavItemInfoStorage().q(this.lastUpdateTime, this.type)))
        {
          y.v("MicroMsg.FavoriteAdapter", "least than page count, loadMoreData");
          aRz();
        }
        this.keB = true;
        y.v("MicroMsg.FavoriteAdapter", "reset data list end");
        return;
        rc(0);
        this.keF = ((com.tencent.mm.plugin.fav.a.ae)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.fav.a.ae.class)).getFavItemInfoStorage().aQB();
        this.keD = f(null, this.keF);
      }
    }
    y.i("MicroMsg.FavoriteAdapter", "on reset data list, do search, searchStr:%s, tagStr:%s, searchTypes:%s", new Object[] { this.keJ, this.keK, this.keI });
    this.keD = com.tencent.mm.plugin.fav.a.b.a(this.keJ, this.keK, this.keI, this.keE, this.kex, this.kez);
    if (this.keD == null) {}
    for (int i = 0;; i = this.keD.size())
    {
      com.tencent.mm.plugin.report.service.h.nFQ.f(10649, new Object[] { Integer.valueOf(i) });
      break;
    }
  }
  
  public final int aRC()
  {
    return this.keH.size();
  }
  
  public final long aRD()
  {
    Iterator localIterator = this.keH.values().iterator();
    long l = 0L;
    if (localIterator.hasNext())
    {
      com.tencent.mm.plugin.fav.a.g localg = (com.tencent.mm.plugin.fav.a.g)localIterator.next();
      if (localg == null) {
        break label55;
      }
      l = localg.field_datatotalsize + l;
    }
    label55:
    for (;;)
    {
      break;
      return l;
    }
  }
  
  public final void aRz()
  {
    if (aRB())
    {
      y.v("MicroMsg.FavoriteAdapter", "searching, do not load more data");
      return;
    }
    if (com.tencent.mm.plugin.fav.a.b.aPS())
    {
      y.w("MicroMsg.FavoriteAdapter", "want to load more data, but now doing batchget");
      return;
    }
    if (!this.keO) {
      try
      {
        this.lastUpdateTime = com.tencent.mm.plugin.fav.a.b.n(this.lastUpdateTime, this.type);
        return;
      }
      catch (Exception localException)
      {
        y.printErrStackTrace("MicroMsg.FavoriteAdapter", localException, "", new Object[0]);
        return;
      }
    }
    this.keD = f(this.keC, this.keF);
    this.keB = true;
  }
  
  public final void b(List<Integer> paramList, List<String> paramList1, List<String> paramList2)
  {
    rc(0);
    this.keI.clear();
    if (paramList != null)
    {
      this.keI.addAll(paramList);
      if (!paramList.isEmpty()) {
        rc(2);
      }
    }
    this.keJ.clear();
    if (paramList1 != null)
    {
      this.keJ.addAll(paramList1);
      if (!paramList1.isEmpty()) {
        rc(3);
      }
    }
    this.keK.clear();
    if (paramList2 != null)
    {
      this.keK.addAll(paramList2);
      if (!paramList2.isEmpty()) {
        rc(1);
      }
    }
    this.keM = true;
    aRA();
    this.keM = false;
  }
  
  public final int eJ(long paramLong)
  {
    int j = 0;
    int i = 0;
    Object localObject = ((com.tencent.mm.plugin.fav.a.ae)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.fav.a.ae.class)).getFavItemInfoStorage().eE(paramLong);
    if (localObject == null) {
      return -1;
    }
    if (this.keH.size() >= 30)
    {
      y.w("MicroMsg.FavoriteAdapter", "call select item, match max select count %d", new Object[] { Integer.valueOf(30) });
      com.tencent.mm.ui.base.h.bC(com.tencent.mm.sdk.platformtools.ae.getContext(), com.tencent.mm.sdk.platformtools.ae.getContext().getResources().getString(n.i.favorite_max_selected_tips, new Object[] { Integer.valueOf(30) }));
      return -1;
    }
    this.keH.put(Long.valueOf(paramLong), localObject);
    if (((com.tencent.mm.plugin.fav.a.g)localObject).field_updateTime < this.lastUpdateTime)
    {
      this.lastUpdateTime = ((com.tencent.mm.plugin.fav.a.g)localObject).field_updateTime;
      aRA();
      localObject = this.keD.iterator();
      while (((Iterator)localObject).hasNext())
      {
        if (((com.tencent.mm.plugin.fav.a.g)((Iterator)localObject).next()).field_localId == paramLong)
        {
          notifyDataSetChanged();
          return i;
        }
        i += 1;
      }
      notifyDataSetChanged();
    }
    for (;;)
    {
      return -1;
      localObject = this.keC.iterator();
      i = j;
      while (((Iterator)localObject).hasNext())
      {
        if (((com.tencent.mm.plugin.fav.a.g)((Iterator)localObject).next()).field_localId == paramLong)
        {
          notifyDataSetChanged();
          return i;
        }
        i += 1;
      }
    }
  }
  
  public final List<com.tencent.mm.plugin.fav.a.g> fX(boolean paramBoolean)
  {
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.keH.values().iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.fav.a.g localg = (com.tencent.mm.plugin.fav.a.g)localIterator.next();
      if (localg != null) {
        localLinkedList.add(localg);
      }
    }
    if (paramBoolean) {
      this.keH.clear();
    }
    return localLinkedList;
  }
  
  public final void finish()
  {
    com.tencent.mm.sdk.b.a.udP.d(this.giK);
  }
  
  public final int getCount()
  {
    return this.keC.size() + 1;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final int getItemViewType(int paramInt)
  {
    if (paramInt == 0) {
      return 0;
    }
    com.tencent.mm.plugin.fav.a.g localg = rd(paramInt - 1);
    switch (localg.field_type)
    {
    case 9: 
    case 13: 
    default: 
      y.w("MicroMsg.FavoriteAdapter", "get item view type unknown, %d", new Object[] { Integer.valueOf(localg.field_type) });
      return -2;
    }
    return localg.field_type;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramInt == 0)
    {
      paramView = new View(paramViewGroup.getContext());
      paramView.setLayoutParams(new AbsListView.LayoutParams(0, 0));
      paramView.setBackgroundResource(n.b.fav_listitem_divider_bg);
      paramView.setPadding(0, 0, 0, 0);
      paramView.setEnabled(false);
      return paramView;
    }
    com.tencent.mm.plugin.fav.a.g localg = rd(paramInt - 1);
    com.tencent.mm.plugin.fav.ui.d.a locala = (com.tencent.mm.plugin.fav.ui.d.a)this.keL.get(localg.field_type);
    if (locala == null)
    {
      y.w("MicroMsg.FavoriteAdapter", "unknown type %d, use unknown item creator", new Object[] { Integer.valueOf(localg.field_type) });
      locala = (com.tencent.mm.plugin.fav.ui.d.a)this.keL.get(-2);
      aRy();
      return locala.a(paramView, paramViewGroup, localg);
    }
    locala.kio.idd = aRB();
    locala.kio.lastUpdateTime = this.lastUpdateTime;
    locala.kio.keG = this.keG;
    locala.kio.keH = this.keH;
    locala.kio.kiq = this.keN;
    locala.kio.keO = this.keO;
    return locala.a(paramView, paramViewGroup, localg);
  }
  
  public final int getViewTypeCount()
  {
    return this.keL.size() + 4;
  }
  
  public final boolean isEmpty()
  {
    return this.keC.isEmpty();
  }
  
  public final void notifyDataSetChanged()
  {
    y.v("MicroMsg.FavoriteAdapter", "on notify data set changed requset, can exchange tempList[%B]", new Object[] { Boolean.valueOf(this.keB) });
    if (this.keB)
    {
      if ((this.keO) && (this.keD != null) && (this.keC != null) && (this.keD.size() == this.keC.size())) {
        this.keP = true;
      }
      List localList = this.keC;
      this.keC = this.keD;
      this.keD = localList;
      this.keB = false;
    }
    y.v("MicroMsg.FavoriteAdapter", "on notify data set changed end");
    super.notifyDataSetChanged();
  }
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (a.b)paramView.getTag();
    if (paramAdapterView == null) {
      y.w("MicroMsg.FavoriteAdapter", "on item click, holder is null");
    }
    com.tencent.mm.plugin.fav.ui.d.a locala;
    do
    {
      return;
      if (paramAdapterView.jZN == null)
      {
        y.w("MicroMsg.FavoriteAdapter", "on item click, info is null");
        return;
      }
      if ((this.keG) || (this.keO))
      {
        if ((!paramAdapterView.eXQ.isChecked()) && (this.keH.size() >= 30))
        {
          y.w("MicroMsg.FavoriteAdapter", "call select item, match max select count %d", new Object[] { Integer.valueOf(30) });
          com.tencent.mm.ui.base.h.bC(com.tencent.mm.sdk.platformtools.ae.getContext(), com.tencent.mm.sdk.platformtools.ae.getContext().getResources().getString(n.i.favorite_max_selected_tips, new Object[] { Integer.valueOf(30) }));
          return;
        }
        paramView = paramAdapterView.eXQ;
        if (!paramAdapterView.eXQ.isChecked()) {}
        for (boolean bool = true;; bool = false)
        {
          paramView.setChecked(bool);
          return;
        }
      }
      locala = (com.tencent.mm.plugin.fav.ui.d.a)this.keL.get(paramAdapterView.jZN.field_type);
    } while (locala == null);
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = paramAdapterView.jZN;
    String str = ((com.tencent.mm.plugin.fav.a.g)localObject).field_id + "_" + System.currentTimeMillis() / 1000L;
    localObject = ((com.tencent.mm.plugin.fav.a.g)localObject).field_tagProto.sXq;
    if (!bk.dk((List)localObject))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localStringBuilder.append((String)((Iterator)localObject).next()).append(";");
      }
    }
    localObject = new yl();
    ((yl)localObject).scene = this.scene;
    ((yl)localObject).jYS = this.jYS;
    if (this.keQ != null) {}
    for (((yl)localObject).index = (paramInt - this.keQ.getHeaderViewsCount());; ((yl)localObject).index = paramInt)
    {
      ((yl)localObject).bVk = this.bVk;
      ((yl)localObject).bIB = str;
      ((yl)localObject).jYU = localStringBuilder.toString();
      locala.a(paramView, (yl)localObject);
      y.d("MicroMsg.FavoriteAdapter", "item click type %s", new Object[] { Integer.valueOf(paramAdapterView.jZN.field_type) });
      return;
    }
  }
  
  public final com.tencent.mm.plugin.fav.a.g rd(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.keC.size()))
    {
      y.e("MicroMsg.FavoriteAdapter", "get item, but position error");
      return new com.tencent.mm.plugin.fav.a.g();
    }
    return (com.tencent.mm.plugin.fav.a.g)this.keC.get(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.a.b
 * JD-Core Version:    0.7.0.1
 */