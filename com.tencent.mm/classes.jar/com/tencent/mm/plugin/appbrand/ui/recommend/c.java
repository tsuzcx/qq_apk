package com.tencent.mm.plugin.appbrand.ui.recommend;

import android.app.Activity;
import android.app.Dialog;
import android.database.Cursor;
import android.os.HandlerThread;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.appusage.a.a;
import com.tencent.mm.plugin.appbrand.appusage.a.a.a;
import com.tencent.mm.plugin.appbrand.ui.recents.f;
import com.tencent.mm.plugin.appbrand.ui.recents.g;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView.a;
import com.tencent.mm.plugin.appbrand.y.g;
import com.tencent.mm.plugin.appbrand.y.h;
import com.tencent.mm.protocal.c.bjt;
import com.tencent.mm.protocal.c.mk;
import com.tencent.mm.protocal.c.mm;
import com.tencent.mm.protocal.c.wh;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class c
{
  Activity bMV;
  volatile int fKx = 0;
  mk fKy = null;
  private final ai hgc = new ai("AppBrandLauncherUI#AppBrandLauncherRecommendsList");
  private Dialog hhG = null;
  final AtomicBoolean hhg = new AtomicBoolean(false);
  LoadMoreRecyclerView hhj;
  f hhs;
  boolean hhw = false;
  LinkedList<bjt> hkd = new LinkedList();
  LinearLayoutManager hkq;
  b hkr;
  volatile int hks = 0;
  final AtomicBoolean hkt = new AtomicBoolean(false);
  private g hku;
  private a hkv;
  private final c.b hkw = new c.b(this, (byte)0);
  long hkx = 0L;
  boolean hky = false;
  HashMap<String, Integer> hkz = new HashMap();
  
  public c(Activity paramActivity)
  {
    this.bMV = paramActivity;
  }
  
  private boolean aqi()
  {
    return this.hkz.size() > 0;
  }
  
  abstract void F(Runnable paramRunnable);
  
  final void Wa()
  {
    if (this.hhG != null) {
      this.hhG.dismiss();
    }
    this.hhG = null;
  }
  
  public abstract long aqa();
  
  public abstract boolean aqb();
  
  public abstract String aqc();
  
  public abstract boolean aqd();
  
  public abstract mm aqe();
  
  abstract boolean aqf();
  
  final boolean aqh()
  {
    return this.hks > 0;
  }
  
  final int aqj()
  {
    if (this.hky) {
      return 1;
    }
    return 0;
  }
  
  final LinkedList<wh> aqk()
  {
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.hkz.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      wh localwh = new wh();
      localwh.username = str;
      localwh.count = ((Integer)this.hkz.get(str)).intValue();
      localLinkedList.add(localwh);
    }
    y.d("MicroMsg.AppBrandRecommendUILogic", "exposureNodeMap size:%d, exposureNodeList size:%d", new Object[] { Integer.valueOf(this.hkz.size()), Integer.valueOf(localLinkedList.size()) });
    return localLinkedList;
  }
  
  final void aql()
  {
    if (!aqi())
    {
      y.e("MicroMsg.AppBrandRecommendUILogic", "none data need report");
      return;
    }
    y.i("MicroMsg.AppBrandRecommendUILogic", "doReportExposureNodeData");
    long l1 = bk.UX();
    long l2 = this.hkx;
    com.tencent.mm.plugin.appbrand.appusage.a.d.a(aqa(), aqk(), null, aqj(), (int)(l1 - l2));
    aqm();
  }
  
  final void aqm()
  {
    this.hkx = bk.UX();
    this.hky = false;
    this.hkz.clear();
  }
  
  public abstract View getContentView();
  
  public abstract int getFilterType();
  
  public abstract void init();
  
  public final void initView()
  {
    init();
    y.i("MicroMsg.AppBrandRecommendUILogic", "initView filterType:%d", new Object[] { Integer.valueOf(getFilterType()) });
    this.hkq = new c.1(this);
    this.hhj = new c.2(this, this.bMV);
    ((FrameLayout)getContentView()).addView(this.hhj, new ViewGroup.LayoutParams(-1, -1));
    this.hkr = new b();
    this.hkr.hO();
    this.hkr.a(this.hkw);
    this.hhj.setAdapter(this.hkr);
    this.hkr.hkf = aqf();
    this.hkr.hkg = new c.c(this);
    if (aqb())
    {
      this.hku = new g(this.bMV, this.hhj, true);
      this.hhj.addHeaderView(this.hku.gVj);
      this.hku.gVj.setVisibility(8);
      this.hku.apJ();
    }
    Object localObject = LayoutInflater.from(this.bMV).inflate(y.h.app_brand_recommend_list_header_view, null);
    this.hhj.addHeaderView((View)localObject);
    ((TextView)((View)localObject).findViewById(y.g.header_view_tv)).setText(aqc());
    this.hhs = new f(this.bMV, this.hhj);
    this.hhs.setLoading(true);
    this.hhj.setLoadingView(this.hhs.aie);
    this.hhj.dZ(false);
    this.hhj.setOnLoadingStateChangedListener(new LoadMoreRecyclerView.a()
    {
      public final void apj()
      {
        if (!c.this.hhs.apS()) {
          return;
        }
        c.a(c.this);
      }
    });
    this.hhj.a(new c.d(this, (byte)0));
    this.hhj.setOnItemClickListener(new c.4(this));
    if (aqe() != null)
    {
      this.fKy = new mk();
      this.fKy.sJi = aqe().sJi;
    }
    localObject = a.adA();
    a locala = new a();
    this.hkv = locala;
    if (!((a)localObject).fKm.contains(locala)) {
      ((a)localObject).fKm.add(locala);
    }
    Wa();
    this.hhG = com.tencent.mm.plugin.appbrand.ui.d.cw(this.bMV);
    this.hhG.show();
    this.hgc.R(new Runnable()
    {
      public final void run()
      {
        Object localObject1;
        Object localObject2;
        long l;
        int j;
        int k;
        if (c.this.aqd())
        {
          y.i("MicroMsg.AppBrandRecommendUILogic", "load data from db");
          localObject1 = (com.tencent.mm.plugin.appbrand.appusage.a.c)com.tencent.mm.plugin.appbrand.app.e.G(com.tencent.mm.plugin.appbrand.appusage.a.c.class);
          localObject2 = new StringBuilder("select * from AppBrandRecommendWxa");
          ((StringBuilder)localObject2).append(" LIMIT 100");
          localObject2 = ((com.tencent.mm.plugin.appbrand.appusage.a.c)localObject1).dXw.rawQuery(((StringBuilder)localObject2).toString(), null);
          if (localObject2 == null)
          {
            localObject1 = null;
            c.this.runOnUiThread(new c.5.1(this, (LinkedList)localObject1));
          }
        }
        else
        {
          l = c.this.aqa();
          j = c.this.getFilterType();
          k = c.this.fKx;
          if (c.this.fKy != null) {
            break label382;
          }
        }
        label382:
        for (int i = 0;; i = c.this.fKy.sJi)
        {
          y.i("MicroMsg.AppBrandRecommendUILogic", "fetch first page, filterType:%d, pageNum:%d, sessionId:%d, cate_id:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Long.valueOf(l), Integer.valueOf(i) });
          a.adA().a(c.this.fKx, c.this.getFilterType(), c.this.fKy, l);
          return;
          y.i("MicroMsg.AppBrandRecommendWxaStorage", "getRecommendWxaList()");
          localObject1 = new LinkedList();
          while (((Cursor)localObject2).moveToNext())
          {
            com.tencent.mm.plugin.appbrand.appusage.a.b localb = new com.tencent.mm.plugin.appbrand.appusage.a.b();
            localb.d((Cursor)localObject2);
            bjt localbjt = new bjt();
            localbjt.bOL = localb.field_appId;
            localbjt.username = localb.field_userName;
            localbjt.nickname = localb.field_nickName;
            localbjt.mTc = localb.field_logo;
            localbjt.bah = localb.field_sessionId;
            localbjt.tDy = localb.field_descInfo;
            localbjt.tDz = localb.field_evaluateScore;
            localbjt.tDB = localb.field_words;
            if (localb.field_recommendWxa != null)
            {
              localbjt.tDA = localb.field_recommendWxa.tDA;
              localbjt.tDC = localb.field_recommendWxa.tDC;
            }
            ((LinkedList)localObject1).add(localbjt);
          }
          ((Cursor)localObject2).close();
          break;
        }
      }
    });
    this.hkx = bk.UX();
    this.hky = false;
    this.hkz.clear();
  }
  
  public final void onDestroyView()
  {
    this.hgc.mnU.quit();
    a locala = a.adA();
    a locala1 = this.hkv;
    if ((locala1 != null) && (locala.fKm.contains(locala1))) {
      locala.fKm.remove(locala1);
    }
    if (this.hku != null) {
      this.hku.onDetached();
    }
    if (this.hhs != null) {
      this.hhs.onDetached();
    }
    if (aqi()) {
      aql();
    }
  }
  
  public final void runOnUiThread(Runnable paramRunnable)
  {
    this.bMV.runOnUiThread(paramRunnable);
  }
  
  final class a
    implements a.a
  {
    a() {}
    
    public final void a(int paramInt1, int paramInt2, LinkedList<bjt> paramLinkedList, int paramInt3)
    {
      if (paramInt2 != c.this.getFilterType())
      {
        y.i("MicroMsg.AppBrandRecommendUILogic", "onFetchFinish, fetch for category");
        return;
      }
      if (paramLinkedList == null) {}
      for (int i = 0;; i = paramLinkedList.size())
      {
        y.i("MicroMsg.AppBrandRecommendUILogic", "onFetchFinish, filterType:%d, remain_count:%d, size:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(i) });
        c.this.hhg.set(false);
        c.this.runOnUiThread(new c.a.1(this, paramInt1, paramInt3, paramLinkedList));
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.c
 * JD-Core Version:    0.7.0.1
 */