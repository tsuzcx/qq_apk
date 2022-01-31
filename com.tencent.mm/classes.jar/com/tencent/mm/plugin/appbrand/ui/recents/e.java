package com.tencent.mm.plugin.appbrand.ui.recents;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.HandlerThread;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.mm.plugin.appbrand.appusage.af.a;
import com.tencent.mm.plugin.appbrand.appusage.j;
import com.tencent.mm.plugin.appbrand.appusage.t;
import com.tencent.mm.plugin.appbrand.appusage.w;
import com.tencent.mm.plugin.appbrand.appusage.w.c;
import com.tencent.mm.plugin.appbrand.config.r;
import com.tencent.mm.plugin.appbrand.report.c;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI.a;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import com.tencent.mm.plugin.appbrand.y.h;
import com.tencent.mm.protocal.c.ang;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

public final class e
  extends AppBrandLauncherUI.a
{
  private int gdS = 0;
  private final int hgY;
  private final boolean hgZ;
  private final ai hgc = new ai("AppBrandLauncherUI#RecentsListUI");
  private final e.a hhA = new e.a(this, (byte)0);
  private final j.a hhB = new e.15(this);
  private final j.a hhC = new e.16(this);
  private final j.a hhD = new e.17(this);
  private final j.a hhE = new e.18(this);
  private final e.b hhF = new e.b(this, (byte)0);
  private Dialog hhG = null;
  private final boolean hha;
  private final boolean hhb;
  private final k hhc;
  private final Bundle hhd = new Bundle();
  private final AtomicLong hhe = new AtomicLong(-1L);
  private final AtomicLong hhf = new AtomicLong(-1L);
  private final AtomicBoolean hhg = new AtomicBoolean(false);
  private final AtomicLong hhh = new AtomicLong(9223372036854775807L);
  private final AtomicBoolean hhi = new AtomicBoolean(false);
  private LoadMoreRecyclerView hhj;
  private LinearLayoutManager hhk;
  private s hhl;
  private final l hhm = new l();
  private final q hhn = new q();
  private e.c hho;
  private View hhp;
  private View hhq;
  private a hhr;
  private f hhs;
  private final o hht = new o();
  private int hhu = 3;
  private int hhv = 0;
  private boolean hhw = false;
  private boolean hhx = false;
  private String hhy;
  private final android.support.v7.g.d hhz = new e.14(this);
  
  public e()
  {
    this(true);
  }
  
  @SuppressLint({"ValidFragment"})
  public e(boolean paramBoolean)
  {
    Bundle localBundle = new Bundle(1);
    localBundle.putBoolean("showHeader", paramBoolean);
    setArguments(localBundle);
    this.hgZ = t.adq();
    this.hha = t.adr();
    if ((bl.csf()) && (com.tencent.mm.kernel.g.DP().Dz().getBoolean(ac.a.usO, false)))
    {
      paramBoolean = true;
      this.hhb = paramBoolean;
      this.hgY = t.ads();
      if ((!this.hgZ) || (this.hha)) {
        break label350;
      }
    }
    label350:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      this.hhc = new k(paramBoolean);
      return;
      paramBoolean = false;
      break;
    }
  }
  
  private void Wa()
  {
    if (this.hhG != null) {
      this.hhG.dismiss();
    }
    this.hhG = null;
  }
  
  private boolean apN()
  {
    if (this.hhi.get()) {}
    FragmentActivity localFragmentActivity;
    do
    {
      return true;
      localFragmentActivity = getActivity();
    } while ((localFragmentActivity == null) || (localFragmentActivity.isFinishing()));
    return false;
  }
  
  public final void aoV()
  {
    if (this.hhj != null) {
      this.hhj.smoothScrollToPosition(0);
    }
  }
  
  public final int getLayoutId()
  {
    return -1;
  }
  
  public final void initView()
  {
    getActivity();
    this.hhk = new e.2(this);
    this.hhk.af(false);
    this.hhj = new e.3(this, getContext());
    this.hhj.setVerticalScrollBarEnabled(true);
    ((FrameLayout)this.QR).addView(this.hhj, new ViewGroup.LayoutParams(-1, -1));
    this.hhj.a(new e.f(this, (byte)0));
    this.hhj.setItemAnimator(this.hht);
    this.hht.b(this.hhF);
    this.hht.b(this.hhA);
    Object localObject = new s(this.hhm);
    e.c localc = new e.c(this, (byte)0);
    this.hho = localc;
    ((s)localObject).hjZ.put(AppBrandRecentTaskInfo.class.hashCode(), localc);
    this.hhl = ((s)localObject);
    this.hhl.hO();
    this.hhl.a(this.hhF);
    this.hhj.setAdapter(this.hhl);
    this.hhj.a(new e.e(this, (byte)0));
    if ((getArguments() != null) && (!getArguments().getBoolean("showHeader", true)))
    {
      getActivity();
      this.hhr = new a.1();
    }
    for (;;)
    {
      this.hhs = new f(getContext(), this.hhj);
      this.hhs.setLoading(true);
      this.hhj.setLoadingView(this.hhs.aie);
      this.hhj.dZ(false);
      this.hhj.setOnLoadingStateChangedListener(new e.6(this));
      Wa();
      this.hhG = com.tencent.mm.plugin.appbrand.ui.d.cw(getActivity());
      this.hhG.show();
      this.hht.hjw = false;
      this.hhe.set(bk.UY());
      this.hgc.R(new Runnable()
      {
        public final void run()
        {
          Object localObject3 = null;
          ArrayList localArrayList = e.l(e.this).n(com.tencent.mm.plugin.appbrand.app.e.aaZ().fJw.cu(9223372036854775807L));
          e.r(e.this);
          int m = e.this.fzn;
          String str = e.this.hda;
          Object localObject1;
          Object localObject2;
          int i;
          if ((localArrayList == null) || (localArrayList.size() <= 0))
          {
            localObject1 = null;
            localObject2 = "";
            ang localang = com.tencent.mm.plugin.appbrand.appusage.q.ade();
            if (localang == null) {
              break label336;
            }
            i = localang.hHm;
            localObject2 = localang.tjb;
          }
          for (;;)
          {
            c.a(m, "", (String)localObject1, i, (String)localObject2, str);
            if (e.g(e.this)) {
              localObject1 = new ArrayList(0);
            }
            for (;;)
            {
              e.this.runOnUiThread(new e.10.1(this, (ArrayList)localObject1, localArrayList));
              j.acU().a(e.h(e.this).get(), true, e.t(e.this), e.u(e.this), e.v(e.this));
              e.w(e.this).set(true);
              return;
              localObject1 = new StringBuilder();
              i = 0;
              int k;
              for (int j = 0; i < localArrayList.size(); j = k)
              {
                localObject2 = localArrayList.get(i);
                k = j;
                if ((localObject2 instanceof AppBrandRecentTaskInfo))
                {
                  localObject2 = (AppBrandRecentTaskInfo)localObject2;
                  k = j + 1;
                  ((StringBuilder)localObject1).append(((AppBrandRecentTaskInfo)localObject2).appId);
                  if ((k == 20) || (k >= localArrayList.size())) {
                    break;
                  }
                  ((StringBuilder)localObject1).append(":#:");
                }
                i += 1;
              }
              localObject1 = ((StringBuilder)localObject1).toString();
              break;
              localObject1 = localObject3;
              if (e.m(e.this)) {
                localObject1 = ((com.tencent.mm.plugin.appbrand.appusage.s)com.tencent.mm.plugin.appbrand.app.e.G(com.tencent.mm.plugin.appbrand.appusage.s.class)).a(af.a.fJU);
              }
            }
            label336:
            i = 0;
          }
        }
      });
      return;
      this.hhr = new g(getActivity(), this.hhj, false);
      this.hhj.addHeaderView(this.hhr.apK());
      this.hhr.apK().setVisibility(8);
      this.hhr.apJ();
      localObject = LayoutInflater.from(getContext()).inflate(y.h.app_brand_recents_list_header_recent_tag, this.hhj, false);
      this.hhj.addHeaderView((View)localObject);
      this.hhp = ((View)localObject);
      this.hhp.setVisibility(8);
    }
  }
  
  public final void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    if ((getActivity() != null) && (getActivity().getIntent() != null))
    {
      this.hhu = getActivity().getIntent().getIntExtra("extra_get_usage_reason", this.hhu);
      this.hhv = getActivity().getIntent().getIntExtra("extra_get_usage_prescene", this.hhv);
    }
  }
  
  public final void onDestroy()
  {
    super.onDestroy();
    this.hhi.set(true);
  }
  
  public final void onDestroyView()
  {
    super.onDestroyView();
    if (this.hhr != null) {
      this.hhr.onDetached();
    }
    if (this.hhs != null) {
      this.hhs.onDetached();
    }
    if (this.hhl != null) {
      this.hhl.b(this.hhF);
    }
    if (this.hho != null)
    {
      this.hho.hhX.clear();
      this.hho = null;
    }
    if ((!com.tencent.mm.kernel.g.DN().dJH) || (com.tencent.mm.kernel.a.CW())) {}
    for (;;)
    {
      this.hgc.mnU.quit();
      this.hhe.set(-1L);
      this.hhf.set(-1L);
      this.hhg.set(false);
      this.hhh.set(9223372036854775807L);
      this.hht.c(this.hhF);
      this.hht.c(this.hhA);
      return;
      r.aem().d(this.hhD);
      com.tencent.mm.plugin.appbrand.app.e.aaZ().d(this.hhC);
      ((com.tencent.mm.plugin.appbrand.appusage.s)com.tencent.mm.plugin.appbrand.app.e.G(com.tencent.mm.plugin.appbrand.appusage.s.class)).d(this.hhB);
      j.acU().d(this.hhE);
    }
  }
  
  public final void onPause()
  {
    super.onPause();
    if (this.hhj != null) {
      this.hhj.setLayoutFrozen(true);
    }
  }
  
  public final void onResume()
  {
    super.onResume();
    if (this.hhj != null) {
      this.hhj.setLayoutFrozen(false);
    }
    int i = this.gdS + 1;
    this.gdS = i;
    if (i > 1)
    {
      if (this.hhr != null) {
        this.hhr.onResume();
      }
      F(new e.19(this));
    }
  }
  
  public final void setScene(int paramInt)
  {
    super.setScene(paramInt);
    this.hhd.putInt("launcher_ui_enter_scene", paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.e
 * JD-Core Version:    0.7.0.1
 */