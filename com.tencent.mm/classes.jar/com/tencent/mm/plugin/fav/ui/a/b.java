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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ki;
import com.tencent.mm.plugin.fav.a.ae;
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
import com.tencent.mm.protocal.protobuf.acs;
import com.tencent.mm.protocal.protobuf.add;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
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
  private com.tencent.mm.sdk.b.c hCe;
  public int kbN;
  private boolean mzk;
  public List<com.tencent.mm.plugin.fav.a.g> mzl;
  private List<com.tencent.mm.plugin.fav.a.g> mzm;
  private List<com.tencent.mm.plugin.fav.a.g> mzn;
  public List<Long> mzo;
  public boolean mzp;
  private Map<Long, com.tencent.mm.plugin.fav.a.g> mzq;
  private List<Integer> mzr;
  private List<String> mzs;
  private List<String> mzt;
  private SparseArray<com.tencent.mm.plugin.fav.ui.d.a> mzu;
  private boolean mzv;
  public a.c mzw;
  public boolean mzx;
  public boolean mzy;
  public ListView mzz;
  public String query;
  public int scene;
  
  public b(com.tencent.mm.plugin.fav.ui.l paraml, boolean paramBoolean)
  {
    AppMethodBeat.i(74294);
    this.mzk = false;
    this.mzl = new ArrayList();
    this.mzm = new ArrayList();
    this.mzn = new LinkedList();
    this.mzo = new ArrayList();
    this.mzp = false;
    this.mzq = new TreeMap();
    this.mzr = new ArrayList();
    this.mzs = new LinkedList();
    this.mzt = new LinkedList();
    this.mzu = new SparseArray();
    this.mzv = false;
    this.mzx = false;
    this.mzy = false;
    this.query = "";
    this.hCe = new com.tencent.mm.sdk.b.c() {};
    this.type = -1;
    this.mzu.put(1, new m(paraml));
    this.mzu.put(2, new d(paraml));
    this.mzu.put(3, new q(paraml));
    this.mzu.put(4, new p(paraml));
    this.mzu.put(5, new o(paraml));
    this.mzu.put(6, new e(paraml));
    this.mzu.put(7, new com.tencent.mm.plugin.fav.ui.d.g(paraml));
    this.mzu.put(8, new com.tencent.mm.plugin.fav.ui.d.c(paraml));
    this.mzu.put(10, new i(paraml));
    this.mzu.put(12, new com.tencent.mm.plugin.fav.ui.d.l(paraml));
    this.mzu.put(15, new com.tencent.mm.plugin.fav.ui.d.l(paraml));
    this.mzu.put(11, new f(paraml));
    this.mzu.put(14, new j(paraml));
    this.mzu.put(16, new k(paraml));
    this.mzu.put(17, new com.tencent.mm.plugin.fav.ui.d.b(paraml));
    this.mzu.put(18, new com.tencent.mm.plugin.fav.ui.d.h(paraml));
    this.mzu.put(-2, new n(paraml));
    if (paramBoolean != this.mzx)
    {
      this.mzx = paramBoolean;
      if (paramBoolean) {
        this.mzq.clear();
      }
    }
    if (!this.mzx) {
      bxO();
    }
    bxP();
    notifyDataSetChanged();
    com.tencent.mm.sdk.b.a.ymk.d(this.hCe);
    com.tencent.mm.sdk.b.a.ymk.c(this.hCe);
    AppMethodBeat.o(74294);
  }
  
  private void bM(List<com.tencent.mm.plugin.fav.a.g> paramList)
  {
    AppMethodBeat.i(74299);
    if (paramList == null)
    {
      AppMethodBeat.o(74299);
      return;
    }
    ab.d("MicroMsg.FavoriteAdapter", "before do recycle, need recycle list size[%d]", new Object[] { Integer.valueOf(paramList.size()) });
    ab.d("MicroMsg.FavoriteAdapter", "after do recycle, current can reused list size[%d]", new Object[] { Integer.valueOf(this.mzn.size()) });
    paramList.clear();
    AppMethodBeat.o(74299);
  }
  
  private void bxQ()
  {
    AppMethodBeat.i(74298);
    setSubScene(0);
    this.mzo = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().bwQ();
    AppMethodBeat.o(74298);
  }
  
  private boolean bxR()
  {
    AppMethodBeat.i(74300);
    if ((!this.mzs.isEmpty()) || (!this.mzt.isEmpty()) || (!this.mzr.isEmpty()))
    {
      AppMethodBeat.o(74300);
      return true;
    }
    AppMethodBeat.o(74300);
    return false;
  }
  
  private static List<com.tencent.mm.plugin.fav.a.g> h(List<com.tencent.mm.plugin.fav.a.g> paramList, List<Long> paramList1)
  {
    int k = 0;
    AppMethodBeat.i(74297);
    ArrayList localArrayList = new ArrayList();
    if (paramList1 == null)
    {
      AppMethodBeat.o(74297);
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
          paramList = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().kb(((Long)paramList1.get(j)).longValue());
          if (paramList != null) {
            localArrayList.add(paramList);
          }
          j += 1;
        }
      }
      j += 1;
    }
    AppMethodBeat.o(74297);
    return localArrayList;
  }
  
  private void setSubScene(int paramInt)
  {
    int i = this.kbN;
    if (paramInt == 0) {
      this.kbN = 0;
    }
    do
    {
      return;
      if (i == 0)
      {
        this.kbN = paramInt;
        return;
      }
    } while (i == paramInt);
    this.kbN = 4;
  }
  
  public final void a(boolean paramBoolean, com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(74301);
    if (paramBoolean == this.mzp)
    {
      AppMethodBeat.o(74301);
      return;
    }
    this.mzp = paramBoolean;
    if (paramBoolean)
    {
      this.mzq.clear();
      if (paramg != null)
      {
        paramg = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().kb(paramg.field_localId);
        if (paramg != null) {
          this.mzq.put(Long.valueOf(paramg.field_localId), paramg);
        }
      }
    }
    notifyDataSetChanged();
    AppMethodBeat.o(74301);
  }
  
  public final void bxO()
  {
    AppMethodBeat.i(74296);
    if (bxR())
    {
      ab.v("MicroMsg.FavoriteAdapter", "searching, do not load more data");
      AppMethodBeat.o(74296);
      return;
    }
    if (com.tencent.mm.plugin.fav.a.b.bwg())
    {
      ab.w("MicroMsg.FavoriteAdapter", "want to load more data, but now doing batchget");
      AppMethodBeat.o(74296);
      return;
    }
    if (!this.mzx) {
      try
      {
        this.lastUpdateTime = com.tencent.mm.plugin.fav.a.b.s(this.lastUpdateTime, this.type);
        AppMethodBeat.o(74296);
        return;
      }
      catch (Exception localException)
      {
        ab.printErrStackTrace("MicroMsg.FavoriteAdapter", localException, "", new Object[0]);
        AppMethodBeat.o(74296);
        return;
      }
    }
    this.mzm = h(this.mzl, this.mzo);
    this.mzk = true;
    AppMethodBeat.o(74296);
  }
  
  public final void bxP()
  {
    AppMethodBeat.i(74306);
    ab.v("MicroMsg.FavoriteAdapter", "reset data list beg");
    this.mzk = false;
    bM(this.mzm);
    if (!bxR())
    {
      ab.i("MicroMsg.FavoriteAdapter", "on reset data list, last update time is %d, type is %d", new Object[] { Long.valueOf(this.lastUpdateTime), Integer.valueOf(this.type) });
      if (!this.mzx)
      {
        this.mzm = com.tencent.mm.plugin.fav.a.b.a(this.lastUpdateTime, this.type, this.mzh, this.mzi);
        if ((this.mzm != null) && (this.lastUpdateTime == 0L) && (this.mzm.size() > 0)) {
          this.lastUpdateTime = ((com.tencent.mm.plugin.fav.a.g)this.mzm.get(this.mzm.size() - 1)).field_updateTime;
        }
      }
      for (;;)
      {
        if (this.mzm == null)
        {
          ab.w("MicroMsg.FavoriteAdapter", "reset data list fail, get null list, new empty one");
          this.mzm = new ArrayList();
        }
        if ((!this.mzx) && (!bxR()) && (this.mzm.size() < 20) && (!((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().v(this.lastUpdateTime, this.type)))
        {
          ab.v("MicroMsg.FavoriteAdapter", "least than page count, loadMoreData");
          bxO();
        }
        this.mzk = true;
        ab.v("MicroMsg.FavoriteAdapter", "reset data list end");
        AppMethodBeat.o(74306);
        return;
        bxQ();
        this.mzm = h(null, this.mzo);
      }
    }
    ab.i("MicroMsg.FavoriteAdapter", "on reset data list, do search, searchStr:%s, tagStr:%s, searchTypes:%s", new Object[] { this.mzs, this.mzt, this.mzr });
    this.mzm = com.tencent.mm.plugin.fav.a.b.a(this.mzs, this.mzt, this.mzr, this.mzn, this.mzh, this.mzi);
    if (this.mzm == null) {}
    for (int i = 0;; i = this.mzm.size())
    {
      com.tencent.mm.plugin.report.service.h.qsU.e(10649, new Object[] { Integer.valueOf(i) });
      break;
    }
  }
  
  public final int bxS()
  {
    AppMethodBeat.i(74303);
    int i = this.mzq.size();
    AppMethodBeat.o(74303);
    return i;
  }
  
  public final long bxT()
  {
    AppMethodBeat.i(74304);
    Iterator localIterator = this.mzq.values().iterator();
    long l = 0L;
    if (localIterator.hasNext())
    {
      com.tencent.mm.plugin.fav.a.g localg = (com.tencent.mm.plugin.fav.a.g)localIterator.next();
      if (localg == null) {
        break label67;
      }
      l = localg.field_datatotalsize + l;
    }
    label67:
    for (;;)
    {
      break;
      AppMethodBeat.o(74304);
      return l;
    }
  }
  
  public final void c(List<Integer> paramList, List<String> paramList1, List<String> paramList2)
  {
    AppMethodBeat.i(74305);
    setSubScene(0);
    this.mzr.clear();
    if (paramList != null)
    {
      this.mzr.addAll(paramList);
      if (!paramList.isEmpty()) {
        setSubScene(2);
      }
    }
    this.mzs.clear();
    if (paramList1 != null)
    {
      this.mzs.addAll(paramList1);
      if (!paramList1.isEmpty()) {
        setSubScene(3);
      }
    }
    this.mzt.clear();
    if (paramList2 != null)
    {
      this.mzt.addAll(paramList2);
      if (!paramList2.isEmpty()) {
        setSubScene(1);
      }
    }
    this.mzv = true;
    bxP();
    this.mzv = false;
    AppMethodBeat.o(74305);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(74295);
    com.tencent.mm.sdk.b.a.ymk.d(this.hCe);
    AppMethodBeat.o(74295);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(74313);
    int i = this.mzl.size();
    AppMethodBeat.o(74313);
    return i + 1;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(74309);
    if (paramInt == 0)
    {
      AppMethodBeat.o(74309);
      return 0;
    }
    com.tencent.mm.plugin.fav.a.g localg = vZ(paramInt - 1);
    switch (localg.field_type)
    {
    case 9: 
    case 13: 
    default: 
      ab.w("MicroMsg.FavoriteAdapter", "get item view type unknown, %d", new Object[] { Integer.valueOf(localg.field_type) });
      AppMethodBeat.o(74309);
      return -2;
    }
    paramInt = localg.field_type;
    AppMethodBeat.o(74309);
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(74311);
    if (paramInt == 0)
    {
      paramView = new View(paramViewGroup.getContext());
      paramView.setLayoutParams(new AbsListView.LayoutParams(0, 0));
      paramView.setBackgroundResource(2131690052);
      paramView.setPadding(0, 0, 0, 0);
      paramView.setEnabled(false);
      AppMethodBeat.o(74311);
      return paramView;
    }
    com.tencent.mm.plugin.fav.a.g localg = vZ(paramInt - 1);
    com.tencent.mm.plugin.fav.ui.d.a locala = (com.tencent.mm.plugin.fav.ui.d.a)this.mzu.get(localg.field_type);
    if (locala == null)
    {
      ab.w("MicroMsg.FavoriteAdapter", "unknown type %d, use unknown item creator", new Object[] { Integer.valueOf(localg.field_type) });
      locala = (com.tencent.mm.plugin.fav.ui.d.a)this.mzu.get(-2);
      bxN();
      paramView = locala.a(paramView, paramViewGroup, localg);
      AppMethodBeat.o(74311);
      return paramView;
    }
    locala.mCS.jTS = bxR();
    locala.mCS.lastUpdateTime = this.lastUpdateTime;
    locala.mCS.mzp = this.mzp;
    locala.mCS.mzq = this.mzq;
    locala.mCS.mCU = this.mzw;
    locala.mCS.mzx = this.mzx;
    paramView = locala.a(paramView, paramViewGroup, localg);
    AppMethodBeat.o(74311);
    return paramView;
  }
  
  public final int getViewTypeCount()
  {
    AppMethodBeat.i(74310);
    int i = this.mzu.size();
    AppMethodBeat.o(74310);
    return i + 4;
  }
  
  public final List<com.tencent.mm.plugin.fav.a.g> hB(boolean paramBoolean)
  {
    AppMethodBeat.i(74302);
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.mzq.values().iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.fav.a.g localg = (com.tencent.mm.plugin.fav.a.g)localIterator.next();
      if (localg != null) {
        localLinkedList.add(localg);
      }
    }
    if (paramBoolean) {
      this.mzq.clear();
    }
    AppMethodBeat.o(74302);
    return localLinkedList;
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(74307);
    boolean bool = this.mzl.isEmpty();
    AppMethodBeat.o(74307);
    return bool;
  }
  
  public final int kh(long paramLong)
  {
    int j = 0;
    int i = 0;
    AppMethodBeat.i(74314);
    Object localObject = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().kb(paramLong);
    if (localObject == null)
    {
      AppMethodBeat.o(74314);
      return -1;
    }
    if (this.mzq.size() >= 30)
    {
      ab.w("MicroMsg.FavoriteAdapter", "call select item, match max select count %d", new Object[] { Integer.valueOf(30) });
      com.tencent.mm.ui.base.h.bO(ah.getContext(), ah.getContext().getResources().getString(2131299755, new Object[] { Integer.valueOf(30) }));
      AppMethodBeat.o(74314);
      return -1;
    }
    this.mzq.put(Long.valueOf(paramLong), localObject);
    if (((com.tencent.mm.plugin.fav.a.g)localObject).field_updateTime < this.lastUpdateTime)
    {
      this.lastUpdateTime = ((com.tencent.mm.plugin.fav.a.g)localObject).field_updateTime;
      bxP();
      localObject = this.mzm.iterator();
      while (((Iterator)localObject).hasNext())
      {
        if (((com.tencent.mm.plugin.fav.a.g)((Iterator)localObject).next()).field_localId == paramLong)
        {
          notifyDataSetChanged();
          AppMethodBeat.o(74314);
          return i;
        }
        i += 1;
      }
      notifyDataSetChanged();
    }
    for (;;)
    {
      AppMethodBeat.o(74314);
      return -1;
      localObject = this.mzl.iterator();
      i = j;
      while (((Iterator)localObject).hasNext())
      {
        if (((com.tencent.mm.plugin.fav.a.g)((Iterator)localObject).next()).field_localId == paramLong)
        {
          notifyDataSetChanged();
          AppMethodBeat.o(74314);
          return i;
        }
        i += 1;
      }
    }
  }
  
  public final void notifyDataSetChanged()
  {
    AppMethodBeat.i(74308);
    ab.v("MicroMsg.FavoriteAdapter", "on notify data set changed requset, can exchange tempList[%B]", new Object[] { Boolean.valueOf(this.mzk) });
    if (this.mzk)
    {
      if ((this.mzx) && (this.mzm != null) && (this.mzl != null) && (this.mzm.size() == this.mzl.size())) {
        this.mzy = true;
      }
      List localList = this.mzl;
      this.mzl = this.mzm;
      this.mzm = localList;
      this.mzk = false;
    }
    ab.v("MicroMsg.FavoriteAdapter", "on notify data set changed end");
    super.notifyDataSetChanged();
    AppMethodBeat.o(74308);
  }
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(74315);
    paramAdapterView = (a.b)paramView.getTag();
    if (paramAdapterView == null)
    {
      ab.w("MicroMsg.FavoriteAdapter", "on item click, holder is null");
      AppMethodBeat.o(74315);
      return;
    }
    if (paramAdapterView.muk == null)
    {
      ab.w("MicroMsg.FavoriteAdapter", "on item click, info is null");
      AppMethodBeat.o(74315);
      return;
    }
    if ((this.mzp) || (this.mzx))
    {
      if ((!paramAdapterView.gpN.isChecked()) && (this.mzq.size() >= 30))
      {
        ab.w("MicroMsg.FavoriteAdapter", "call select item, match max select count %d", new Object[] { Integer.valueOf(30) });
        com.tencent.mm.ui.base.h.bO(ah.getContext(), ah.getContext().getResources().getString(2131299755, new Object[] { Integer.valueOf(30) }));
        AppMethodBeat.o(74315);
        return;
      }
      paramView = paramAdapterView.gpN;
      if (!paramAdapterView.gpN.isChecked()) {}
      for (boolean bool = true;; bool = false)
      {
        paramView.setChecked(bool);
        AppMethodBeat.o(74315);
        return;
      }
    }
    com.tencent.mm.plugin.fav.ui.d.a locala = (com.tencent.mm.plugin.fav.ui.d.a)this.mzu.get(paramAdapterView.muk.field_type);
    StringBuilder localStringBuilder;
    Object localObject;
    String str;
    if (locala != null)
    {
      localStringBuilder = new StringBuilder();
      localObject = paramAdapterView.muk;
      str = ((com.tencent.mm.plugin.fav.a.g)localObject).field_id + "_" + System.currentTimeMillis() / 1000L;
      localObject = ((com.tencent.mm.plugin.fav.a.g)localObject).field_tagProto.wVq;
      if (!bo.es((List)localObject))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          localStringBuilder.append((String)((Iterator)localObject).next()).append(";");
        }
      }
      localObject = new acs();
      ((acs)localObject).scene = this.scene;
      ((acs)localObject).kbN = this.kbN;
      if (this.mzz == null) {
        break label439;
      }
    }
    label439:
    for (((acs)localObject).index = (paramInt - this.mzz.getHeaderViewsCount());; ((acs)localObject).index = paramInt)
    {
      ((acs)localObject).query = this.query;
      ((acs)localObject).cpW = str;
      ((acs)localObject).mtm = localStringBuilder.toString();
      locala.a(paramView, (acs)localObject);
      ab.d("MicroMsg.FavoriteAdapter", "item click type %s", new Object[] { Integer.valueOf(paramAdapterView.muk.field_type) });
      AppMethodBeat.o(74315);
      return;
    }
  }
  
  public final com.tencent.mm.plugin.fav.a.g vZ(int paramInt)
  {
    AppMethodBeat.i(74312);
    if ((paramInt < 0) || (paramInt >= this.mzl.size()))
    {
      ab.e("MicroMsg.FavoriteAdapter", "get item, but position error");
      localg = new com.tencent.mm.plugin.fav.a.g();
      AppMethodBeat.o(74312);
      return localg;
    }
    com.tencent.mm.plugin.fav.a.g localg = (com.tencent.mm.plugin.fav.a.g)this.mzl.get(paramInt);
    AppMethodBeat.o(74312);
    return localg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.a.b
 * JD-Core Version:    0.7.0.1
 */