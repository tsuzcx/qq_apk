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
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.e.b.b;
import com.tencent.mm.plugin.fav.ui.e.b.c;
import com.tencent.mm.plugin.fav.ui.e.d;
import com.tencent.mm.plugin.fav.ui.e.e;
import com.tencent.mm.plugin.fav.ui.e.f;
import com.tencent.mm.plugin.fav.ui.e.i;
import com.tencent.mm.plugin.fav.ui.e.j;
import com.tencent.mm.plugin.fav.ui.e.k;
import com.tencent.mm.plugin.fav.ui.e.l;
import com.tencent.mm.plugin.fav.ui.e.m;
import com.tencent.mm.plugin.fav.ui.e.n;
import com.tencent.mm.plugin.fav.ui.e.p;
import com.tencent.mm.plugin.fav.ui.e.q;
import com.tencent.mm.plugin.fav.ui.e.r;
import com.tencent.mm.plugin.fav.ui.e.s;
import com.tencent.mm.protocal.protobuf.ahp;
import com.tencent.mm.protocal.protobuf.aia;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
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
  private com.tencent.mm.sdk.b.c kce;
  public int nLC;
  private boolean qPA;
  public b.c qPB;
  public boolean qPC;
  public boolean qPD;
  public ListView qPE;
  private boolean qPp;
  public List<com.tencent.mm.plugin.fav.a.g> qPq;
  private List<com.tencent.mm.plugin.fav.a.g> qPr;
  private List<com.tencent.mm.plugin.fav.a.g> qPs;
  public List<Long> qPt;
  public boolean qPu;
  private Map<String, com.tencent.mm.plugin.fav.a.g> qPv;
  private List<Integer> qPw;
  private List<String> qPx;
  private List<String> qPy;
  private SparseArray<com.tencent.mm.plugin.fav.ui.e.b> qPz;
  public String query;
  public int scene;
  
  public b(com.tencent.mm.plugin.fav.ui.o paramo, boolean paramBoolean)
  {
    AppMethodBeat.i(107086);
    this.qPp = false;
    this.qPq = new ArrayList();
    this.qPr = new ArrayList();
    this.qPs = new LinkedList();
    this.qPt = new ArrayList();
    this.qPu = false;
    this.qPv = new TreeMap();
    this.qPw = new ArrayList();
    this.qPx = new LinkedList();
    this.qPy = new LinkedList();
    this.qPz = new SparseArray();
    this.qPA = false;
    this.qPC = false;
    this.qPD = false;
    this.query = "";
    this.kce = new b.1(this);
    this.type = -1;
    this.qPz.put(1, new com.tencent.mm.plugin.fav.ui.e.o(paramo));
    this.qPz.put(2, new f(paramo));
    this.qPz.put(3, new s(paramo));
    this.qPz.put(4, new r(paramo));
    this.qPz.put(5, new q(paramo));
    this.qPz.put(6, new com.tencent.mm.plugin.fav.ui.e.g(paramo));
    this.qPz.put(7, new i(paramo));
    this.qPz.put(8, new d(paramo));
    this.qPz.put(10, new k(paramo));
    this.qPz.put(12, new n(paramo));
    this.qPz.put(15, new n(paramo));
    this.qPz.put(11, new com.tencent.mm.plugin.fav.ui.e.h(paramo));
    this.qPz.put(14, new l(paramo));
    this.qPz.put(16, new m(paramo));
    this.qPz.put(17, new com.tencent.mm.plugin.fav.ui.e.c(paramo));
    this.qPz.put(18, new j(paramo));
    this.qPz.put(20, new e(paramo));
    this.qPz.put(19, new com.tencent.mm.plugin.fav.ui.e.a(paramo));
    this.qPz.put(-2, new p(paramo));
    if (paramBoolean != this.qPC)
    {
      this.qPC = paramBoolean;
      if (paramBoolean) {
        this.qPv.clear();
      }
    }
    if (!this.qPC) {
      aQh();
    }
    cqX();
    notifyDataSetChanged();
    com.tencent.mm.sdk.b.a.GpY.d(this.kce);
    com.tencent.mm.sdk.b.a.GpY.c(this.kce);
    AppMethodBeat.o(107086);
  }
  
  private void cqY()
  {
    AppMethodBeat.i(107090);
    setSubScene(0);
    this.qPt = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().cpN();
    AppMethodBeat.o(107090);
  }
  
  private boolean cqZ()
  {
    AppMethodBeat.i(107092);
    if ((!this.qPx.isEmpty()) || (!this.qPy.isEmpty()) || (!this.qPw.isEmpty()))
    {
      AppMethodBeat.o(107092);
      return true;
    }
    AppMethodBeat.o(107092);
    return false;
  }
  
  private void dq(List<com.tencent.mm.plugin.fav.a.g> paramList)
  {
    AppMethodBeat.i(107091);
    if (paramList == null)
    {
      AppMethodBeat.o(107091);
      return;
    }
    ac.d("MicroMsg.FavoriteAdapter", "before do recycle, need recycle list size[%d]", new Object[] { Integer.valueOf(paramList.size()) });
    ac.d("MicroMsg.FavoriteAdapter", "after do recycle, current can reused list size[%d]", new Object[] { Integer.valueOf(this.qPs.size()) });
    paramList.clear();
    AppMethodBeat.o(107091);
  }
  
  private static List<com.tencent.mm.plugin.fav.a.g> k(List<com.tencent.mm.plugin.fav.a.g> paramList, List<Long> paramList1)
  {
    int k = 0;
    AppMethodBeat.i(107089);
    ArrayList localArrayList = new ArrayList();
    if (paramList1 == null)
    {
      AppMethodBeat.o(107089);
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
          paramList = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().tH(((Long)paramList1.get(j)).longValue());
          if (paramList != null) {
            localArrayList.add(paramList);
          }
          j += 1;
        }
      }
      j += 1;
    }
    AppMethodBeat.o(107089);
    return localArrayList;
  }
  
  private void setSubScene(int paramInt)
  {
    int i = this.nLC;
    if (paramInt == 0) {
      this.nLC = 0;
    }
    do
    {
      return;
      if (i == 0)
      {
        this.nLC = paramInt;
        return;
      }
    } while (i == paramInt);
    this.nLC = 4;
  }
  
  public final com.tencent.mm.plugin.fav.a.g Dm(int paramInt)
  {
    AppMethodBeat.i(107104);
    if ((paramInt < 0) || (paramInt >= this.qPq.size()))
    {
      ac.e("MicroMsg.FavoriteAdapter", "get item, but position error");
      localg = new com.tencent.mm.plugin.fav.a.g();
      AppMethodBeat.o(107104);
      return localg;
    }
    com.tencent.mm.plugin.fav.a.g localg = (com.tencent.mm.plugin.fav.a.g)this.qPq.get(paramInt);
    AppMethodBeat.o(107104);
    return localg;
  }
  
  public final void a(View paramView, com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(107108);
    if (paramg == null)
    {
      ac.w("MicroMsg.FavoriteAdapter", "goFavDetail() favItemInfo is null");
      AppMethodBeat.o(107108);
      return;
    }
    if ((!paramg.qIl) || (paramg.qIm == null))
    {
      ac.w("MicroMsg.FavoriteAdapter", "goFavDetail() originInfo not exist");
      AppMethodBeat.o(107108);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = paramg.qIm;
    String str = ((com.tencent.mm.plugin.fav.a.g)localObject).field_id + "_" + System.currentTimeMillis() / 1000L;
    localObject = ((com.tencent.mm.plugin.fav.a.g)localObject).field_tagProto.EBX;
    if (!bs.gY((List)localObject))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localStringBuilder.append((String)((Iterator)localObject).next()).append(";");
      }
    }
    localObject = new ahp();
    ((ahp)localObject).scene = this.scene;
    ((ahp)localObject).nLC = this.nLC;
    ((ahp)localObject).query = this.query;
    ((ahp)localObject).sessionId = str;
    ((ahp)localObject).qIF = localStringBuilder.toString();
    if (paramView != null) {}
    for (paramView = paramView.getContext();; paramView = ai.getContext())
    {
      paramg.qIm.qIn = paramg.qIn;
      ((y)com.tencent.mm.kernel.g.ab(y.class)).a(paramView, paramg.qIm, (ahp)localObject);
      ac.d("MicroMsg.FavoriteAdapter", "goFavDetail type %s %s", new Object[] { Integer.valueOf(paramg.qIm.field_type), paramg.qIn, Integer.valueOf(paramg.field_type) });
      AppMethodBeat.o(107108);
      return;
    }
  }
  
  public final void a(boolean paramBoolean, com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(107093);
    if (paramBoolean == this.qPu)
    {
      AppMethodBeat.o(107093);
      return;
    }
    this.qPu = paramBoolean;
    com.tencent.mm.plugin.fav.a.g localg;
    if (paramBoolean)
    {
      this.qPv.clear();
      if (paramg != null)
      {
        localg = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().tH(paramg.field_localId);
        if (localg != null)
        {
          if (!paramg.qIl) {
            break label103;
          }
          this.qPv.put(paramg.dhm, paramg);
        }
      }
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(107093);
      return;
      label103:
      this.qPv.put(bs.dQ(Long.valueOf(localg.field_localId)), localg);
    }
  }
  
  public final void aQh()
  {
    AppMethodBeat.i(107088);
    if (cqZ())
    {
      ac.v("MicroMsg.FavoriteAdapter", "searching, do not load more data");
      AppMethodBeat.o(107088);
      return;
    }
    if (com.tencent.mm.plugin.fav.a.b.cpf())
    {
      ac.w("MicroMsg.FavoriteAdapter", "want to load more data, but now doing batchget");
      AppMethodBeat.o(107088);
      return;
    }
    if (!this.qPC) {
      try
      {
        this.lastUpdateTime = com.tencent.mm.plugin.fav.a.b.x(this.lastUpdateTime, this.type);
        AppMethodBeat.o(107088);
        return;
      }
      catch (Exception localException)
      {
        ac.printErrStackTrace("MicroMsg.FavoriteAdapter", localException, "", new Object[0]);
        AppMethodBeat.o(107088);
        return;
      }
    }
    this.qPr = k(this.qPq, this.qPt);
    this.qPp = true;
    AppMethodBeat.o(107088);
  }
  
  public final void c(List<Integer> paramList, List<String> paramList1, List<String> paramList2)
  {
    AppMethodBeat.i(107097);
    setSubScene(0);
    this.qPw.clear();
    if (paramList != null)
    {
      this.qPw.addAll(paramList);
      if (!paramList.isEmpty()) {
        setSubScene(2);
      }
    }
    this.qPx.clear();
    if (paramList1 != null)
    {
      this.qPx.addAll(paramList1);
      if (!paramList1.isEmpty()) {
        setSubScene(3);
      }
    }
    this.qPy.clear();
    if (paramList2 != null)
    {
      this.qPy.addAll(paramList2);
      if (!paramList2.isEmpty()) {
        setSubScene(1);
      }
    }
    this.qPA = true;
    cqX();
    this.qPA = false;
    AppMethodBeat.o(107097);
  }
  
  public final void cqX()
  {
    AppMethodBeat.i(107098);
    ac.v("MicroMsg.FavoriteAdapter", "reset data list beg");
    this.qPp = false;
    dq(this.qPr);
    if (!cqZ())
    {
      ac.i("MicroMsg.FavoriteAdapter", "on reset data list, last update time is %d, type is %d", new Object[] { Long.valueOf(this.lastUpdateTime), Integer.valueOf(this.type) });
      if (!this.qPC)
      {
        this.qPr = com.tencent.mm.plugin.fav.a.b.a(this.lastUpdateTime, this.type, this.qPm, this.qPn);
        if ((this.qPr != null) && (this.lastUpdateTime == 0L) && (this.qPr.size() > 0)) {
          this.lastUpdateTime = ((com.tencent.mm.plugin.fav.a.g)this.qPr.get(this.qPr.size() - 1)).field_updateTime;
        }
      }
    }
    int i;
    for (;;)
    {
      if (this.qPr == null)
      {
        ac.w("MicroMsg.FavoriteAdapter", "reset data list fail, get null list, new empty one");
        this.qPr = new ArrayList();
      }
      if ((!this.qPC) && (!cqZ()) && (this.qPr.size() < 20) && (!((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().A(this.lastUpdateTime, this.type)))
      {
        ac.v("MicroMsg.FavoriteAdapter", "least than page count, loadMoreData");
        aQh();
      }
      this.qPp = true;
      ac.v("MicroMsg.FavoriteAdapter", "reset data list end");
      AppMethodBeat.o(107098);
      return;
      cqY();
      this.qPr = k(null, this.qPt);
      continue;
      ac.i("MicroMsg.FavoriteAdapter", "on reset data list, do search, searchStr:%s, tagStr:%s, searchTypes:%s", new Object[] { this.qPx, this.qPy, this.qPw });
      if ((this.qPw == null) || (this.qPw.size() == 1)) {
        break;
      }
      this.qPr = com.tencent.mm.plugin.fav.a.b.a(this.qPx, this.qPy, this.qPw, this.qPs, this.qPm, this.qPn);
      if (this.qPr != null) {
        break label459;
      }
      i = 0;
      label381:
      com.tencent.mm.plugin.report.service.h.wUl.f(10649, new Object[] { Integer.valueOf(i) });
    }
    if (this.qPw != null) {}
    for (Integer localInteger = (Integer)this.qPw.get(0);; localInteger = null)
    {
      this.qPr = com.tencent.mm.plugin.fav.a.b.a(this.qPx, this.qPy, localInteger.intValue(), this.qPs, this.qPm, this.qPn);
      break;
      label459:
      i = this.qPr.size();
      break label381;
    }
  }
  
  public final int cra()
  {
    AppMethodBeat.i(107095);
    int i = this.qPv.size();
    AppMethodBeat.o(107095);
    return i;
  }
  
  public final long crb()
  {
    AppMethodBeat.i(107096);
    Iterator localIterator = this.qPv.values().iterator();
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
      AppMethodBeat.o(107096);
      return l;
    }
  }
  
  public final void finish()
  {
    AppMethodBeat.i(107087);
    com.tencent.mm.sdk.b.a.GpY.d(this.kce);
    AppMethodBeat.o(107087);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(107105);
    int i = this.qPq.size();
    AppMethodBeat.o(107105);
    return i + 1;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(107101);
    if (paramInt == 0)
    {
      AppMethodBeat.o(107101);
      return 0;
    }
    com.tencent.mm.plugin.fav.a.g localg = Dm(paramInt - 1);
    switch (localg.field_type)
    {
    case 9: 
    case 13: 
    default: 
      ac.w("MicroMsg.FavoriteAdapter", "get item view type unknown, %d", new Object[] { Integer.valueOf(localg.field_type) });
      AppMethodBeat.o(107101);
      return -2;
    }
    paramInt = localg.field_type;
    AppMethodBeat.o(107101);
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(107103);
    if (paramInt == 0)
    {
      paramView = new View(paramViewGroup.getContext());
      paramView.setLayoutParams(new AbsListView.LayoutParams(0, 0));
      paramView.setBackgroundResource(2131100352);
      paramView.setPadding(0, 0, 0, 0);
      paramView.setEnabled(false);
      AppMethodBeat.o(107103);
      return paramView;
    }
    com.tencent.mm.plugin.fav.a.g localg = Dm(paramInt - 1);
    com.tencent.mm.plugin.fav.ui.e.b localb = (com.tencent.mm.plugin.fav.ui.e.b)this.qPz.get(localg.field_type);
    if (localb == null)
    {
      ac.w("MicroMsg.FavoriteAdapter", "unknown type %d, use unknown item creator", new Object[] { Integer.valueOf(localg.field_type) });
      localb = (com.tencent.mm.plugin.fav.ui.e.b)this.qPz.get(-2);
      cqW();
      paramView = localb.a(paramView, paramViewGroup, localg);
      AppMethodBeat.o(107103);
      return paramView;
    }
    localb.qTe.nwB = cqZ();
    localb.qTe.lastUpdateTime = this.lastUpdateTime;
    localb.qTe.qPu = this.qPu;
    localb.qTe.qPv = this.qPv;
    localb.qTe.qTg = this.qPB;
    localb.qTe.qPC = this.qPC;
    paramView = localb.a(paramView, paramViewGroup, localg);
    AppMethodBeat.o(107103);
    return paramView;
  }
  
  public final int getViewTypeCount()
  {
    AppMethodBeat.i(107102);
    int i = this.qPz.size();
    AppMethodBeat.o(107102);
    return i + 4;
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(107099);
    boolean bool = this.qPq.isEmpty();
    AppMethodBeat.o(107099);
    return bool;
  }
  
  public final List<com.tencent.mm.plugin.fav.a.g> li(boolean paramBoolean)
  {
    AppMethodBeat.i(107094);
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.qPv.values().iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.fav.a.g localg = (com.tencent.mm.plugin.fav.a.g)localIterator.next();
      if (localg != null) {
        localLinkedList.add(localg);
      }
    }
    if (paramBoolean) {
      this.qPv.clear();
    }
    AppMethodBeat.o(107094);
    return localLinkedList;
  }
  
  public final int n(long paramLong, String paramString)
  {
    int i = 1;
    int k = 0;
    int j = 0;
    AppMethodBeat.i(107106);
    Object localObject = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().tH(paramLong);
    if (localObject == null)
    {
      AppMethodBeat.o(107106);
      return -1;
    }
    if (this.qPv.size() >= 30)
    {
      ac.w("MicroMsg.FavoriteAdapter", "call select item, match max select count %d", new Object[] { Integer.valueOf(30) });
      com.tencent.mm.ui.base.h.cg(ai.getContext(), ai.getContext().getResources().getString(2131758927, new Object[] { Integer.valueOf(30) }));
      AppMethodBeat.o(107106);
      return -1;
    }
    com.tencent.mm.plugin.fav.a.g localg;
    if (!bs.isNullOrNil(paramString))
    {
      Iterator localIterator = this.qPq.iterator();
      while (localIterator.hasNext())
      {
        localg = (com.tencent.mm.plugin.fav.a.g)localIterator.next();
        if (bs.lr(localg.dhm, paramString))
        {
          localg.qIm = ((com.tencent.mm.plugin.fav.a.g)localObject);
          localObject = localg;
        }
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        this.qPv.put(paramString, localObject);
        if (((com.tencent.mm.plugin.fav.a.g)localObject).field_updateTime < this.lastUpdateTime)
        {
          this.lastUpdateTime = ((com.tencent.mm.plugin.fav.a.g)localObject).field_updateTime;
          cqX();
          localObject = this.qPr.iterator();
          i = j;
        }
      }
      else
      {
        for (;;)
        {
          if (!((Iterator)localObject).hasNext()) {
            break label362;
          }
          localg = (com.tencent.mm.plugin.fav.a.g)((Iterator)localObject).next();
          if (bs.isNullOrNil(paramString))
          {
            if (localg.field_localId != paramLong) {
              break label353;
            }
            notifyDataSetChanged();
            AppMethodBeat.o(107106);
            return i;
            this.qPv.put(bs.dQ(Long.valueOf(paramLong)), localObject);
            break;
          }
          if ((localg.field_localId == paramLong) && (bs.lr(paramString, localg.dhm)))
          {
            notifyDataSetChanged();
            AppMethodBeat.o(107106);
            return i;
          }
          label353:
          i += 1;
        }
        label362:
        notifyDataSetChanged();
      }
      for (;;)
      {
        AppMethodBeat.o(107106);
        return -1;
        localObject = this.qPq.iterator();
        i = k;
        while (((Iterator)localObject).hasNext())
        {
          localg = (com.tencent.mm.plugin.fav.a.g)((Iterator)localObject).next();
          if (bs.isNullOrNil(paramString))
          {
            if (localg.field_localId == paramLong)
            {
              notifyDataSetChanged();
              AppMethodBeat.o(107106);
              return i;
            }
          }
          else if ((localg.field_localId == paramLong) && (bs.lr(paramString, localg.dhm)))
          {
            notifyDataSetChanged();
            AppMethodBeat.o(107106);
            return i;
          }
          i += 1;
        }
      }
      i = 0;
    }
  }
  
  public final void notifyDataSetChanged()
  {
    AppMethodBeat.i(107100);
    ac.v("MicroMsg.FavoriteAdapter", "on notify data set changed requset, can exchange tempList[%B]", new Object[] { Boolean.valueOf(this.qPp) });
    if (this.qPp)
    {
      if ((this.qPC) && (this.qPr != null) && (this.qPq != null) && (this.qPr.size() == this.qPq.size())) {
        this.qPD = true;
      }
      List localList = this.qPq;
      this.qPq = this.qPr;
      this.qPr = localList;
      this.qPp = false;
    }
    ac.v("MicroMsg.FavoriteAdapter", "on notify data set changed end");
    super.notifyDataSetChanged();
    AppMethodBeat.o(107100);
  }
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(107107);
    paramAdapterView = (b.b)paramView.getTag();
    if (paramAdapterView == null)
    {
      ac.w("MicroMsg.FavoriteAdapter", "on item click, holder is null");
      AppMethodBeat.o(107107);
      return;
    }
    if (paramAdapterView.qJy == null)
    {
      ac.w("MicroMsg.FavoriteAdapter", "on item click, info is null");
      AppMethodBeat.o(107107);
      return;
    }
    if ((this.qPu) || (this.qPC))
    {
      if ((!paramAdapterView.iCi.isChecked()) && (this.qPv.size() >= 30))
      {
        ac.w("MicroMsg.FavoriteAdapter", "call select item, match max select count %d", new Object[] { Integer.valueOf(30) });
        com.tencent.mm.ui.base.h.cg(ai.getContext(), ai.getContext().getResources().getString(2131758927, new Object[] { Integer.valueOf(30) }));
        AppMethodBeat.o(107107);
        return;
      }
      paramView = paramAdapterView.iCi;
      if (!paramAdapterView.iCi.isChecked()) {}
      for (boolean bool = true;; bool = false)
      {
        paramView.setChecked(bool);
        AppMethodBeat.o(107107);
        return;
      }
    }
    com.tencent.mm.plugin.fav.ui.e.b localb = (com.tencent.mm.plugin.fav.ui.e.b)this.qPz.get(paramAdapterView.qJy.field_type);
    StringBuilder localStringBuilder;
    Object localObject;
    String str;
    if (localb != null)
    {
      localStringBuilder = new StringBuilder();
      localObject = paramAdapterView.qJy;
      str = ((com.tencent.mm.plugin.fav.a.g)localObject).field_id + "_" + System.currentTimeMillis() / 1000L;
      localObject = ((com.tencent.mm.plugin.fav.a.g)localObject).field_tagProto.EBX;
      if (!bs.gY((List)localObject))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          localStringBuilder.append((String)((Iterator)localObject).next()).append(";");
        }
      }
      localObject = new ahp();
      ((ahp)localObject).scene = this.scene;
      ((ahp)localObject).nLC = this.nLC;
      if (this.qPE == null) {
        break label439;
      }
    }
    label439:
    for (((ahp)localObject).index = (paramInt - this.qPE.getHeaderViewsCount());; ((ahp)localObject).index = paramInt)
    {
      ((ahp)localObject).query = this.query;
      ((ahp)localObject).sessionId = str;
      ((ahp)localObject).qIF = localStringBuilder.toString();
      localb.a(paramView, (ahp)localObject);
      ac.d("MicroMsg.FavoriteAdapter", "item click type %s", new Object[] { Integer.valueOf(paramAdapterView.qJy.field_type) });
      AppMethodBeat.o(107107);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.a.b
 * JD-Core Version:    0.7.0.1
 */