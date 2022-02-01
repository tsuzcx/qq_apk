package com.tencent.mm.plugin.fav.ui.adapter;

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
import com.tencent.mm.plugin.fav.a.ah;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.a.z;
import com.tencent.mm.plugin.fav.ui.FavoriteImageServer;
import com.tencent.mm.plugin.fav.ui.d.b.b;
import com.tencent.mm.plugin.fav.ui.d.b.c;
import com.tencent.mm.plugin.fav.ui.d.c;
import com.tencent.mm.plugin.fav.ui.d.d;
import com.tencent.mm.plugin.fav.ui.d.e;
import com.tencent.mm.plugin.fav.ui.d.i;
import com.tencent.mm.plugin.fav.ui.d.j;
import com.tencent.mm.plugin.fav.ui.d.l;
import com.tencent.mm.plugin.fav.ui.d.m;
import com.tencent.mm.plugin.fav.ui.d.n;
import com.tencent.mm.plugin.fav.ui.d.o;
import com.tencent.mm.plugin.fav.ui.d.p;
import com.tencent.mm.plugin.fav.ui.d.q;
import com.tencent.mm.plugin.fav.ui.d.r;
import com.tencent.mm.plugin.fav.ui.d.s;
import com.tencent.mm.plugin.fav.ui.d.t;
import com.tencent.mm.plugin.fav.ui.q.b;
import com.tencent.mm.plugin.fav.ui.q.i;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.protocal.protobuf.arx;
import com.tencent.mm.protocal.protobuf.asb;
import com.tencent.mm.protocal.protobuf.asi;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
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
  public int AcJ;
  private boolean AjZ;
  public List<com.tencent.mm.plugin.fav.a.g> Aka;
  private List<com.tencent.mm.plugin.fav.a.g> Akb;
  private List<com.tencent.mm.plugin.fav.a.g> Akc;
  public List<Long> Akd;
  public boolean Ake;
  private Map<String, com.tencent.mm.plugin.fav.a.g> Akf;
  private List<Integer> Akg;
  private List<String> Akh;
  private List<String> Aki;
  private SparseArray<com.tencent.mm.plugin.fav.ui.d.b> Akj;
  private boolean Akk;
  public b.c Akl;
  public boolean Akm;
  public boolean Akn;
  public ListView Ako;
  private IListener Akp;
  public String query;
  private IListener rDF;
  public int scene;
  
  public b(FavoriteImageServer paramFavoriteImageServer, boolean paramBoolean)
  {
    AppMethodBeat.i(107086);
    this.AjZ = false;
    this.Aka = new ArrayList();
    this.Akb = new ArrayList();
    this.Akc = new LinkedList();
    this.Akd = new ArrayList();
    this.Ake = false;
    this.Akf = new TreeMap();
    this.Akg = new ArrayList();
    this.Akh = new LinkedList();
    this.Aki = new LinkedList();
    this.Akj = new SparseArray();
    this.Akk = false;
    this.Akm = false;
    this.Akn = false;
    this.query = "";
    this.rDF = new FavoriteNormalAdapter.1(this, com.tencent.mm.app.f.hfK);
    this.Akp = new FavoriteNormalAdapter.2(this, com.tencent.mm.app.f.hfK);
    this.type = -1;
    this.Akj.put(1, new p(paramFavoriteImageServer));
    this.Akj.put(2, new com.tencent.mm.plugin.fav.ui.d.f(paramFavoriteImageServer));
    this.Akj.put(3, new t(paramFavoriteImageServer));
    this.Akj.put(4, new s(paramFavoriteImageServer));
    this.Akj.put(5, new r(paramFavoriteImageServer));
    this.Akj.put(6, new com.tencent.mm.plugin.fav.ui.d.g(paramFavoriteImageServer));
    this.Akj.put(7, new i(paramFavoriteImageServer));
    this.Akj.put(21, new j(paramFavoriteImageServer));
    this.Akj.put(8, new d(paramFavoriteImageServer));
    this.Akj.put(10, new l(paramFavoriteImageServer));
    this.Akj.put(12, new o(paramFavoriteImageServer));
    this.Akj.put(15, new o(paramFavoriteImageServer));
    this.Akj.put(11, new com.tencent.mm.plugin.fav.ui.d.h(paramFavoriteImageServer));
    this.Akj.put(14, new m(paramFavoriteImageServer));
    this.Akj.put(16, new n(paramFavoriteImageServer));
    this.Akj.put(17, new c(paramFavoriteImageServer));
    this.Akj.put(18, new com.tencent.mm.plugin.fav.ui.d.k(paramFavoriteImageServer));
    this.Akj.put(20, new e(paramFavoriteImageServer));
    this.Akj.put(19, new com.tencent.mm.plugin.fav.ui.d.a(paramFavoriteImageServer));
    this.Akj.put(-2, new q(paramFavoriteImageServer));
    if (paramBoolean != this.Akm)
    {
      this.Akm = paramBoolean;
      if (paramBoolean) {
        this.Akf.clear();
      }
    }
    if (!this.Akm) {
      bXB();
    }
    dSj();
    notifyDataSetChanged();
    AppMethodBeat.o(107086);
  }
  
  private void dSk()
  {
    AppMethodBeat.i(107090);
    setSubScene(0);
    this.Akd = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().dQN();
    AppMethodBeat.o(107090);
  }
  
  private boolean dSl()
  {
    AppMethodBeat.i(107092);
    if ((!this.Akh.isEmpty()) || (!this.Aki.isEmpty()) || (!this.Akg.isEmpty()))
    {
      AppMethodBeat.o(107092);
      return true;
    }
    AppMethodBeat.o(107092);
    return false;
  }
  
  private void fK(List<com.tencent.mm.plugin.fav.a.g> paramList)
  {
    AppMethodBeat.i(107091);
    if (paramList == null)
    {
      AppMethodBeat.o(107091);
      return;
    }
    Log.d("MicroMsg.FavoriteAdapter", "before do recycle, need recycle list size[%d]", new Object[] { Integer.valueOf(paramList.size()) });
    Log.d("MicroMsg.FavoriteAdapter", "after do recycle, current can reused list size[%d]", new Object[] { Integer.valueOf(this.Akc.size()) });
    paramList.clear();
    AppMethodBeat.o(107091);
  }
  
  private void setSubScene(int paramInt)
  {
    int i = this.AcJ;
    if (paramInt == 0) {
      this.AcJ = 0;
    }
    do
    {
      return;
      if (i == 0)
      {
        this.AcJ = paramInt;
        return;
      }
    } while (i == paramInt);
    this.AcJ = 4;
  }
  
  private static List<com.tencent.mm.plugin.fav.a.g> t(List<com.tencent.mm.plugin.fav.a.g> paramList, List<Long> paramList1)
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
          paramList = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().mK(((Long)paramList1.get(j)).longValue());
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
  
  public final int A(long paramLong, String paramString)
  {
    int i = 1;
    int k = 0;
    int j = 0;
    AppMethodBeat.i(107106);
    Object localObject = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().mK(paramLong);
    if (localObject == null)
    {
      AppMethodBeat.o(107106);
      return -1;
    }
    if (this.Akf.size() >= 30)
    {
      Log.w("MicroMsg.FavoriteAdapter", "call select item, match max select count %d", new Object[] { Integer.valueOf(30) });
      com.tencent.mm.ui.base.k.cZ(MMApplicationContext.getContext(), MMApplicationContext.getContext().getResources().getString(q.i.favorite_max_selected_tips, new Object[] { Integer.valueOf(30) }));
      AppMethodBeat.o(107106);
      return -1;
    }
    com.tencent.mm.plugin.fav.a.g localg;
    if (!Util.isNullOrNil(paramString))
    {
      Iterator localIterator = this.Aka.iterator();
      while (localIterator.hasNext())
      {
        localg = (com.tencent.mm.plugin.fav.a.g)localIterator.next();
        if (Util.isEqual(localg.hIG, paramString))
        {
          localg.Acr = ((com.tencent.mm.plugin.fav.a.g)localObject);
          localObject = localg;
        }
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        this.Akf.put(paramString, localObject);
        if (((com.tencent.mm.plugin.fav.a.g)localObject).field_updateTime < this.lastUpdateTime)
        {
          this.lastUpdateTime = ((com.tencent.mm.plugin.fav.a.g)localObject).field_updateTime;
          dSj();
          localObject = this.Akb.iterator();
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
          if (Util.isNullOrNil(paramString))
          {
            if (localg.field_localId != paramLong) {
              break label353;
            }
            notifyDataSetChanged();
            AppMethodBeat.o(107106);
            return i;
            this.Akf.put(Util.notNullToString(Long.valueOf(paramLong)), localObject);
            break;
          }
          if ((localg.field_localId == paramLong) && (Util.isEqual(paramString, localg.hIG)))
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
        localObject = this.Aka.iterator();
        i = k;
        while (((Iterator)localObject).hasNext())
        {
          localg = (com.tencent.mm.plugin.fav.a.g)((Iterator)localObject).next();
          if (Util.isNullOrNil(paramString))
          {
            if (localg.field_localId == paramLong)
            {
              notifyDataSetChanged();
              AppMethodBeat.o(107106);
              return i;
            }
          }
          else if ((localg.field_localId == paramLong) && (Util.isEqual(paramString, localg.hIG)))
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
  
  public final com.tencent.mm.plugin.fav.a.g MK(int paramInt)
  {
    AppMethodBeat.i(107104);
    if ((paramInt < 0) || (paramInt >= this.Aka.size()))
    {
      Log.e("MicroMsg.FavoriteAdapter", "get item, but position error");
      localg = new com.tencent.mm.plugin.fav.a.g();
      AppMethodBeat.o(107104);
      return localg;
    }
    com.tencent.mm.plugin.fav.a.g localg = (com.tencent.mm.plugin.fav.a.g)this.Aka.get(paramInt);
    AppMethodBeat.o(107104);
    return localg;
  }
  
  public final void a(View paramView, com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(107108);
    if (paramg == null)
    {
      Log.w("MicroMsg.FavoriteAdapter", "goFavDetail() favItemInfo is null");
      AppMethodBeat.o(107108);
      return;
    }
    if ((!paramg.Acq) || (paramg.Acr == null))
    {
      Log.w("MicroMsg.FavoriteAdapter", "goFavDetail() originInfo not exist");
      AppMethodBeat.o(107108);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = paramg.Acr;
    String str = ((com.tencent.mm.plugin.fav.a.g)localObject).field_id + "_" + System.currentTimeMillis() / 1000L;
    localObject = ((com.tencent.mm.plugin.fav.a.g)localObject).field_tagProto.ZBH;
    if (!Util.isNullOrNil((List)localObject))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localStringBuilder.append((String)((Iterator)localObject).next()).append(";");
      }
    }
    localObject = new arx();
    ((arx)localObject).scene = this.scene;
    ((arx)localObject).AcJ = this.AcJ;
    ((arx)localObject).query = this.query;
    ((arx)localObject).sessionId = str;
    ((arx)localObject).AcL = localStringBuilder.toString();
    if (paramView != null) {}
    for (paramView = paramView.getContext();; paramView = MMApplicationContext.getContext())
    {
      paramg.Acr.Acs = paramg.Acs;
      ((z)com.tencent.mm.kernel.h.ax(z.class)).a(paramView, paramg.Acr, (arx)localObject);
      Log.d("MicroMsg.FavoriteAdapter", "goFavDetail type %s %s", new Object[] { Integer.valueOf(paramg.Acr.field_type), paramg.Acs, Integer.valueOf(paramg.field_type) });
      AppMethodBeat.o(107108);
      return;
    }
  }
  
  public final void a(boolean paramBoolean, com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(107093);
    if (paramBoolean == this.Ake)
    {
      AppMethodBeat.o(107093);
      return;
    }
    this.Ake = paramBoolean;
    com.tencent.mm.plugin.fav.a.g localg;
    if (paramBoolean)
    {
      this.Akf.clear();
      if (paramg != null)
      {
        localg = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().mK(paramg.field_localId);
        if (localg != null)
        {
          if (!paramg.Acq) {
            break label103;
          }
          this.Akf.put(paramg.hIG, paramg);
        }
      }
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(107093);
      return;
      label103:
      this.Akf.put(Util.notNullToString(Long.valueOf(localg.field_localId)), localg);
    }
  }
  
  public final void bXB()
  {
    AppMethodBeat.i(107088);
    if (dSl())
    {
      Log.v("MicroMsg.FavoriteAdapter", "searching, do not load more data");
      AppMethodBeat.o(107088);
      return;
    }
    if (com.tencent.mm.plugin.fav.a.b.dQf())
    {
      Log.w("MicroMsg.FavoriteAdapter", "want to load more data, but now doing batchget");
      AppMethodBeat.o(107088);
      return;
    }
    if (!this.Akm) {
      try
      {
        this.lastUpdateTime = com.tencent.mm.plugin.fav.a.b.H(this.lastUpdateTime, this.type);
        AppMethodBeat.o(107088);
        return;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.FavoriteAdapter", localException, "", new Object[0]);
        AppMethodBeat.o(107088);
        return;
      }
    }
    this.Akb = t(this.Aka, this.Akd);
    this.AjZ = true;
    AppMethodBeat.o(107088);
  }
  
  public final void c(List<Integer> paramList, List<String> paramList1, List<String> paramList2)
  {
    AppMethodBeat.i(107097);
    setSubScene(0);
    this.Akg.clear();
    if (paramList != null)
    {
      this.Akg.addAll(paramList);
      if (!paramList.isEmpty()) {
        setSubScene(2);
      }
    }
    this.Akh.clear();
    if (paramList1 != null)
    {
      this.Akh.addAll(paramList1);
      if (!paramList1.isEmpty()) {
        setSubScene(3);
      }
    }
    this.Aki.clear();
    if (paramList2 != null)
    {
      this.Aki.addAll(paramList2);
      if (!paramList2.isEmpty()) {
        setSubScene(1);
      }
    }
    this.Akk = true;
    dSj();
    this.Akk = false;
    AppMethodBeat.o(107097);
  }
  
  public final void dSj()
  {
    AppMethodBeat.i(107098);
    Log.v("MicroMsg.FavoriteAdapter", "reset data list beg");
    this.AjZ = false;
    fK(this.Akb);
    if (!dSl())
    {
      Log.i("MicroMsg.FavoriteAdapter", "on reset data list, last update time is %d, type is %d", new Object[] { Long.valueOf(this.lastUpdateTime), Integer.valueOf(this.type) });
      if (!this.Akm)
      {
        this.Akb = com.tencent.mm.plugin.fav.a.b.a(this.lastUpdateTime, this.type, this.AjW, this.AjX);
        if ((this.Akb != null) && (this.lastUpdateTime == 0L) && (this.Akb.size() > 0)) {
          this.lastUpdateTime = ((com.tencent.mm.plugin.fav.a.g)this.Akb.get(this.Akb.size() - 1)).field_updateTime;
        }
      }
      for (;;)
      {
        if (this.Akb == null)
        {
          Log.w("MicroMsg.FavoriteAdapter", "reset data list fail, get null list, new empty one");
          this.Akb = new ArrayList();
        }
        if ((!this.Akm) && (!dSl()) && (this.Akb.size() < 20) && (!((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().L(this.lastUpdateTime, this.type)))
        {
          Log.v("MicroMsg.FavoriteAdapter", "least than page count, loadMoreData");
          bXB();
        }
        this.AjZ = true;
        Log.v("MicroMsg.FavoriteAdapter", "reset data list end");
        AppMethodBeat.o(107098);
        return;
        dSk();
        this.Akb = t(null, this.Akd);
      }
    }
    Log.i("MicroMsg.FavoriteAdapter", "on reset data list, do search, searchStr:%s, tagStr:%s, searchTypes:%s", new Object[] { this.Akh, this.Aki, this.Akg });
    if ((this.Akh != null) && (this.Akh.contains("::fail"))) {
      this.Akb = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getAllUploadFailItem();
    }
    int i;
    for (;;)
    {
      if (this.Akb == null)
      {
        i = 0;
        label369:
        com.tencent.mm.plugin.report.service.h.OAn.b(10649, new Object[] { Integer.valueOf(i) });
        break;
        if ((this.Akg != null) && (this.Akg.size() != 1)) {
          this.Akb = com.tencent.mm.plugin.fav.a.b.a(this.Akh, this.Aki, this.Akg, this.Akc, this.AjW, this.AjX);
        } else {
          if (this.Akg == null) {
            break label514;
          }
        }
      }
    }
    label514:
    for (Integer localInteger = (Integer)this.Akg.get(0);; localInteger = null)
    {
      this.Akb = com.tencent.mm.plugin.fav.a.b.a(this.Akh, this.Aki, localInteger.intValue(), this.Akc, this.AjW, this.AjX);
      break;
      i = this.Akb.size();
      break label369;
    }
  }
  
  public final int dSm()
  {
    AppMethodBeat.i(107095);
    int i = this.Akf.size();
    AppMethodBeat.o(107095);
    return i;
  }
  
  public final long dSn()
  {
    AppMethodBeat.i(107096);
    Iterator localIterator = this.Akf.values().iterator();
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
  
  public final int getCount()
  {
    AppMethodBeat.i(107105);
    int i = this.Aka.size();
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
    com.tencent.mm.plugin.fav.a.g localg = MK(paramInt - 1);
    switch (localg.field_type)
    {
    case 9: 
    case 13: 
    default: 
      Log.w("MicroMsg.FavoriteAdapter", "get item view type unknown, %d", new Object[] { Integer.valueOf(localg.field_type) });
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
      paramView.setBackgroundResource(q.b.fav_listitem_divider_bg);
      paramView.setPadding(0, 0, 0, 0);
      paramView.setEnabled(false);
      AppMethodBeat.o(107103);
      return paramView;
    }
    com.tencent.mm.plugin.fav.a.g localg = MK(paramInt - 1);
    Object localObject1;
    if (7 == localg.field_type)
    {
      Object localObject2 = "";
      localObject1 = localObject2;
      if (localg != null)
      {
        localObject1 = localObject2;
        if (localg.field_favProto != null)
        {
          localObject1 = localObject2;
          if (localg.field_favProto.ZBt != null) {
            localObject1 = localg.field_favProto.ZBt.appId;
          }
        }
      }
      localObject2 = com.tencent.mm.plugin.comm.a.xeG;
      if (!com.tencent.mm.plugin.comm.a.aml((String)localObject1)) {
        break label236;
      }
      localg.field_type = 21;
    }
    for (;;)
    {
      localObject1 = (com.tencent.mm.plugin.fav.ui.d.b)this.Akj.get(localg.field_type);
      if (localObject1 != null) {
        break;
      }
      Log.w("MicroMsg.FavoriteAdapter", "unknown type %d, use unknown item creator", new Object[] { Integer.valueOf(localg.field_type) });
      localObject1 = (com.tencent.mm.plugin.fav.ui.d.b)this.Akj.get(-2);
      dSi();
      paramView = ((com.tencent.mm.plugin.fav.ui.d.b)localObject1).a(paramView, paramViewGroup, localg);
      AppMethodBeat.o(107103);
      return paramView;
      label236:
      localObject1 = com.tencent.mm.plugin.comm.a.xeG;
      if (!com.tencent.mm.plugin.comm.a.dsO()) {
        localg.field_type = 7;
      } else {
        localg.field_type = 5;
      }
    }
    ((com.tencent.mm.plugin.fav.ui.d.b)localObject1).Aof.vDm = dSl();
    ((com.tencent.mm.plugin.fav.ui.d.b)localObject1).Aof.lastUpdateTime = this.lastUpdateTime;
    ((com.tencent.mm.plugin.fav.ui.d.b)localObject1).Aof.Ake = this.Ake;
    ((com.tencent.mm.plugin.fav.ui.d.b)localObject1).Aof.Akf = this.Akf;
    ((com.tencent.mm.plugin.fav.ui.d.b)localObject1).Aof.Aoh = this.Akl;
    ((com.tencent.mm.plugin.fav.ui.d.b)localObject1).Aof.Akm = this.Akm;
    paramView = ((com.tencent.mm.plugin.fav.ui.d.b)localObject1).a(paramView, paramViewGroup, localg);
    AppMethodBeat.o(107103);
    return paramView;
  }
  
  public final int getViewTypeCount()
  {
    AppMethodBeat.i(107102);
    int i = this.Akj.size();
    AppMethodBeat.o(107102);
    return i + 4;
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(107099);
    boolean bool = this.Aka.isEmpty();
    AppMethodBeat.o(107099);
    return bool;
  }
  
  public final void notifyDataSetChanged()
  {
    AppMethodBeat.i(107100);
    Log.v("MicroMsg.FavoriteAdapter", "on notify data set changed requset, can exchange tempList[%B]", new Object[] { Boolean.valueOf(this.AjZ) });
    if (this.AjZ)
    {
      if ((this.Akm) && (this.Akb != null) && (this.Aka != null) && (this.Akb.size() == this.Aka.size())) {
        this.Akn = true;
      }
      List localList = this.Aka;
      this.Aka = this.Akb;
      this.Akb = localList;
      this.AjZ = false;
    }
    Log.v("MicroMsg.FavoriteAdapter", "on notify data set changed end");
    super.notifyDataSetChanged();
    AppMethodBeat.o(107100);
  }
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(107107);
    paramAdapterView = (b.b)paramView.getTag();
    if (paramAdapterView == null)
    {
      Log.w("MicroMsg.FavoriteAdapter", "on item click, holder is null");
      AppMethodBeat.o(107107);
      return;
    }
    if (paramAdapterView.AdF == null)
    {
      Log.w("MicroMsg.FavoriteAdapter", "on item click, info is null");
      AppMethodBeat.o(107107);
      return;
    }
    if ((this.Ake) || (this.Akm))
    {
      if ((!paramAdapterView.pJL.isChecked()) && (this.Akf.size() >= 30))
      {
        Log.w("MicroMsg.FavoriteAdapter", "call select item, match max select count %d", new Object[] { Integer.valueOf(30) });
        com.tencent.mm.ui.base.k.cZ(MMApplicationContext.getContext(), MMApplicationContext.getContext().getResources().getString(q.i.favorite_max_selected_tips, new Object[] { Integer.valueOf(30) }));
        AppMethodBeat.o(107107);
        return;
      }
      paramView = paramAdapterView.pJL;
      if (!paramAdapterView.pJL.isChecked()) {}
      for (boolean bool = true;; bool = false)
      {
        paramView.setChecked(bool);
        AppMethodBeat.o(107107);
        return;
      }
    }
    com.tencent.mm.plugin.fav.ui.d.b localb = (com.tencent.mm.plugin.fav.ui.d.b)this.Akj.get(paramAdapterView.AdF.field_type);
    StringBuilder localStringBuilder;
    Object localObject;
    String str;
    if (localb != null)
    {
      localStringBuilder = new StringBuilder();
      localObject = paramAdapterView.AdF;
      str = ((com.tencent.mm.plugin.fav.a.g)localObject).field_id + "_" + System.currentTimeMillis() / 1000L;
      localObject = ((com.tencent.mm.plugin.fav.a.g)localObject).field_tagProto.ZBH;
      if (!Util.isNullOrNil((List)localObject))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          localStringBuilder.append((String)((Iterator)localObject).next()).append(";");
        }
      }
      localObject = new arx();
      ((arx)localObject).scene = this.scene;
      ((arx)localObject).AcJ = this.AcJ;
      if (this.Ako == null) {
        break label439;
      }
    }
    label439:
    for (((arx)localObject).index = (paramInt - this.Ako.getHeaderViewsCount());; ((arx)localObject).index = paramInt)
    {
      ((arx)localObject).query = this.query;
      ((arx)localObject).sessionId = str;
      ((arx)localObject).AcL = localStringBuilder.toString();
      localb.a(paramView, (arx)localObject);
      Log.d("MicroMsg.FavoriteAdapter", "item click type %s", new Object[] { Integer.valueOf(paramAdapterView.AdF.field_type) });
      AppMethodBeat.o(107107);
      return;
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(274451);
    this.rDF.dead();
    this.Akp.dead();
    AppMethodBeat.o(274451);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(274450);
    this.rDF.alive();
    this.Akp.alive();
    AppMethodBeat.o(274450);
  }
  
  public final List<com.tencent.mm.plugin.fav.a.g> ps(boolean paramBoolean)
  {
    AppMethodBeat.i(107094);
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.Akf.values().iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.fav.a.g localg = (com.tencent.mm.plugin.fav.a.g)localIterator.next();
      if (localg != null) {
        localLinkedList.add(localg);
      }
    }
    if (paramBoolean) {
      this.Akf.clear();
    }
    AppMethodBeat.o(107094);
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.adapter.b
 * JD-Core Version:    0.7.0.1
 */