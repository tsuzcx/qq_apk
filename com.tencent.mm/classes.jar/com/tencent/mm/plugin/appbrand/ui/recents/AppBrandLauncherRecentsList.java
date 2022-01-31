package com.tencent.mm.plugin.appbrand.ui.recents;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.MessageQueue;
import android.support.v4.app.FragmentActivity;
import android.support.v7.h.d;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.v;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.mm.plugin.appbrand.appusage.j;
import com.tencent.mm.plugin.appbrand.appusage.t;
import com.tencent.mm.plugin.appbrand.appusage.w;
import com.tencent.mm.plugin.appbrand.appusage.w.c;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI.Fragment;
import com.tencent.mm.plugin.appbrand.ui.d.1;
import com.tencent.mm.plugin.appbrand.ui.d.2;
import com.tencent.mm.plugin.appbrand.ui.d.a;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.bp;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.base.n.d;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

public final class AppBrandLauncherRecentsList
  extends AppBrandLauncherUI.Fragment
{
  private int hvP;
  private final com.tencent.mm.sdk.platformtools.al iRq;
  private final int iSA;
  private final boolean iSB;
  private final boolean iSC;
  private final boolean iSD;
  private final k iSE;
  private final Bundle iSF;
  private final AtomicLong iSG;
  private final AtomicLong iSH;
  private final AtomicBoolean iSI;
  private final AtomicLong iSJ;
  private final AtomicBoolean iSK;
  private LoadMoreRecyclerView iSL;
  private LinearLayoutManager iSM;
  private s iSN;
  private final m iSO;
  private final AppBrandLauncherRecentsList.a iSP;
  private final q iSQ;
  private AppBrandLauncherRecentsList.d iSR;
  private View iSS;
  private View iST;
  private a iSU;
  private e iSV;
  private final o iSW;
  private int iSX;
  private int iSY;
  private boolean iSZ;
  private boolean iTa;
  private String iTb;
  private final d iTc;
  private final AppBrandLauncherRecentsList.b iTd;
  private final k.a iTe;
  private final k.a iTf;
  private final k.a iTg;
  private final k.a iTh;
  private final AppBrandLauncherRecentsList.c iTi;
  private boolean iTj;
  private Dialog iTk;
  
  public AppBrandLauncherRecentsList()
  {
    this(true);
  }
  
  @SuppressLint({"ValidFragment"})
  public AppBrandLauncherRecentsList(boolean paramBoolean)
  {
    AppMethodBeat.i(133396);
    this.iSF = new Bundle();
    this.iSG = new AtomicLong(-1L);
    this.iSH = new AtomicLong(-1L);
    this.iSI = new AtomicBoolean(false);
    this.iSJ = new AtomicLong(9223372036854775807L);
    this.iSK = new AtomicBoolean(false);
    this.iSO = new m();
    this.iRq = new com.tencent.mm.sdk.platformtools.al("AppBrandLauncherUI#RecentsListUI");
    this.iSP = new AppBrandLauncherRecentsList.a(this);
    this.iSQ = new q();
    this.iSW = new o();
    this.iSX = 3;
    this.iSY = 0;
    this.iSZ = false;
    this.iTa = false;
    this.iTc = new AppBrandLauncherRecentsList.15(this);
    this.iTd = new AppBrandLauncherRecentsList.b(this, (byte)0);
    this.iTe = new AppBrandLauncherRecentsList.16(this);
    this.iTf = new AppBrandLauncherRecentsList.17(this);
    this.iTg = new AppBrandLauncherRecentsList.18(this);
    this.iTh = new AppBrandLauncherRecentsList.19(this);
    this.iTi = new AppBrandLauncherRecentsList.c(this, (byte)0);
    this.iTj = false;
    this.hvP = 0;
    this.iTk = null;
    Bundle localBundle = new Bundle(1);
    localBundle.putBoolean("showHeader", paramBoolean);
    setArguments(localBundle);
    this.iSB = t.axy();
    this.iSC = t.axz();
    if ((bp.dud()) && (com.tencent.mm.kernel.g.RL().Ru().getBoolean(ac.a.yCO, false)))
    {
      paramBoolean = true;
      this.iSD = paramBoolean;
      this.iSA = t.axA();
      if ((!this.iSB) || (this.iSC)) {
        break label377;
      }
    }
    label377:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      this.iSE = new k(paramBoolean);
      AppMethodBeat.o(133396);
      return;
      paramBoolean = false;
      break;
    }
  }
  
  private boolean aNh()
  {
    AppMethodBeat.i(133397);
    if (this.iSK.get())
    {
      AppMethodBeat.o(133397);
      return true;
    }
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity == null) || (localFragmentActivity.isFinishing()))
    {
      AppMethodBeat.o(133397);
      return true;
    }
    AppMethodBeat.o(133397);
    return false;
  }
  
  private void apz()
  {
    AppMethodBeat.i(133406);
    if (this.iTk != null) {
      this.iTk.dismiss();
    }
    this.iTk = null;
    AppMethodBeat.o(133406);
  }
  
  public final void aMd()
  {
    AppMethodBeat.i(133401);
    if (this.iSL != null) {
      this.iSL.smoothScrollToPosition(0);
    }
    AppMethodBeat.o(133401);
  }
  
  public final int getLayoutId()
  {
    return -1;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(133405);
    getActivity();
    this.iSM = new AppBrandLauncherRecentsList.3(this);
    this.iSM.ao(false);
    this.iSL = new AppBrandLauncherRecentsList.4(this, getContext());
    this.iSL.setVerticalScrollBarEnabled(true);
    ((FrameLayout)this.Qz).addView(this.iSL, new ViewGroup.LayoutParams(-1, -1));
    this.iSL.b(new AppBrandLauncherRecentsList.g(this, (byte)0));
    this.iSL.setItemAnimator(this.iSW);
    this.iSW.b(this.iTi);
    this.iSW.b(this.iTd);
    Object localObject1 = new s(this.iSO);
    Object localObject2 = new AppBrandLauncherRecentsList.d(this, (byte)0);
    this.iSR = ((AppBrandLauncherRecentsList.d)localObject2);
    ((s)localObject1).iVG.put(AppBrandRecentTaskInfo.class.hashCode(), localObject2);
    this.iSN = ((s)localObject1);
    this.iSN.jv();
    this.iSN.a(this.iTi);
    this.iSL.setAdapter(this.iSN);
    this.iSL.a(new f((byte)0));
    if ((getArguments() != null) && (!getArguments().getBoolean("showHeader", true)))
    {
      getActivity();
      this.iSU = new a.1();
    }
    for (;;)
    {
      this.iSV = new e(getContext(), this.iSL);
      this.iSV.eU(true);
      this.iSL.setLoadingView(this.iSV.aku);
      this.iSL.fv(false);
      this.iSL.setOnLoadingStateChangedListener(new AppBrandLauncherRecentsList.7(this));
      apz();
      localObject1 = getActivity();
      localObject2 = View.inflate((Context)localObject1, 2130968771, null);
      d.a locala = new d.a((Context)localObject1);
      locala.setContentView((View)localObject2);
      locala.setCancelable(true);
      locala.setCanceledOnTouchOutside(false);
      locala.setOnCancelListener(new d.1((Context)localObject1, locala));
      locala.setOnShowListener(new d.2(locala));
      this.iTk = locala;
      this.iTk.show();
      this.iSW.iVd = false;
      this.iSG.set(bo.aoy());
      this.iRq.ad(new AppBrandLauncherRecentsList.11(this));
      AppMethodBeat.o(133405);
      return;
      this.iSU = new f(getActivity(), this.iSL, false, false);
      this.iSL.addHeaderView(this.iSU.aNe());
      this.iSU.aNe().setVisibility(8);
      this.iSU.aNd();
      localObject1 = LayoutInflater.from(getContext()).inflate(2130968718, this.iSL, false);
      this.iSL.addHeaderView((View)localObject1);
      this.iSS = ((View)localObject1);
      this.iSS.setVisibility(8);
    }
  }
  
  public final void onActivityCreated(Bundle paramBundle)
  {
    AppMethodBeat.i(133404);
    super.onActivityCreated(paramBundle);
    if ((getActivity() != null) && (getActivity().getIntent() != null))
    {
      this.iSX = getActivity().getIntent().getIntExtra("extra_get_usage_reason", this.iSX);
      this.iSY = getActivity().getIntent().getIntExtra("extra_get_usage_prescene", this.iSY);
    }
    AppMethodBeat.o(133404);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(133403);
    super.onDestroy();
    apz();
    this.iSK.set(true);
    AppBrandLauncherRecentsList.a.b(this.iSP);
    AppMethodBeat.o(133403);
  }
  
  public final void onDestroyView()
  {
    AppMethodBeat.i(133400);
    super.onDestroyView();
    if (this.iSU != null) {
      this.iSU.onDetached();
    }
    if (this.iSV != null) {
      this.iSV.onDetached();
    }
    if (this.iSN != null) {
      this.iSN.b(this.iTi);
    }
    if (this.iSR != null)
    {
      this.iSR.iTC.clear();
      this.iSR = null;
    }
    if ((!com.tencent.mm.kernel.g.RJ().eHg) || (com.tencent.mm.kernel.a.QP())) {}
    for (;;)
    {
      this.iRq.oNc.quit();
      this.iSG.set(-1L);
      this.iSH.set(-1L);
      this.iSI.set(false);
      this.iSJ.set(9223372036854775807L);
      this.iSW.c(this.iTi);
      this.iSW.c(this.iTd);
      AppMethodBeat.o(133400);
      return;
      com.tencent.mm.plugin.appbrand.config.q.ayA().remove(this.iTg);
      com.tencent.mm.plugin.appbrand.app.g.auK().remove(this.iTf);
      ((com.tencent.mm.plugin.appbrand.appusage.s)com.tencent.mm.plugin.appbrand.app.g.w(com.tencent.mm.plugin.appbrand.appusage.s.class)).remove(this.iTe);
      j.axa().remove(this.iTh);
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(133399);
    this.iTj = false;
    super.onPause();
    try
    {
      if (this.iSL != null) {
        this.iSL.setLayoutFrozen(true);
      }
      AppMethodBeat.o(133399);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      Looper.myQueue().addIdleHandler(new AppBrandLauncherRecentsList.2(this));
      AppMethodBeat.o(133399);
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(133398);
    this.iTj = true;
    super.onResume();
    if (this.iSL != null) {
      this.iSL.setLayoutFrozen(false);
    }
    int i = this.hvP + 1;
    this.hvP = i;
    if (i > 1)
    {
      if (this.iSU != null) {
        this.iSU.onResume();
      }
      postOnUiThread(new AppBrandLauncherRecentsList.20(this));
    }
    AppMethodBeat.o(133398);
  }
  
  public final void setScene(int paramInt)
  {
    AppMethodBeat.i(133402);
    super.setScene(paramInt);
    this.iSF.putInt("launcher_ui_enter_scene", paramInt);
    AppMethodBeat.o(133402);
  }
  
  final class e
    extends RecyclerView.v
    implements View.OnClickListener, View.OnCreateContextMenuListener, n.d
  {
    View gqg;
    TextView iTD;
    TextView iTE;
    TextView iTF;
    TextView iTG;
    ImageView iTH;
    View iTI;
    com.tencent.mm.ui.widget.c.a iTJ;
    final int iTK;
    final int iTL;
    
    e(View paramView)
    {
      super();
      AppMethodBeat.i(133387);
      this.iTK = 1;
      this.iTL = 2;
      this.gqg = paramView.findViewById(2131821148);
      this.iTD = ((TextView)paramView.findViewById(2131820650));
      this.iTE = ((TextView)paramView.findViewById(2131821213));
      this.iTF = ((TextView)paramView.findViewById(2131821171));
      this.iTG = ((TextView)paramView.findViewById(2131821252));
      this.iTH = ((ImageView)paramView.findViewById(2131820929));
      this.iTI = paramView.findViewById(2131821251);
      paramView.setOnClickListener(this);
      this.iTJ = new com.tencent.mm.ui.widget.c.a(this.aku.getContext())
      {
        public final boolean dq(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(133382);
          if (AppBrandLauncherRecentsList.e.this.aku.getParent() != null) {
            AppBrandLauncherRecentsList.e.this.aku.getParent().requestDisallowInterceptTouchEvent(true);
          }
          boolean bool = super.dq(paramAnonymousInt1, paramAnonymousInt2);
          AppMethodBeat.o(133382);
          return bool;
        }
        
        public final void onDismiss()
        {
          AppMethodBeat.i(133383);
          if (AppBrandLauncherRecentsList.e.this.aku.getParent() != null) {
            AppBrandLauncherRecentsList.e.this.aku.getParent().requestDisallowInterceptTouchEvent(false);
          }
          super.onDismiss();
          AppMethodBeat.o(133383);
        }
      };
      this.iTJ.c(this.aku, this, this);
      AppMethodBeat.o(133387);
    }
    
    private int aNm()
    {
      AppMethodBeat.i(133388);
      int i = AppBrandLauncherRecentsList.d(AppBrandLauncherRecentsList.this).S(this);
      AppMethodBeat.o(133388);
      return i;
    }
    
    final AppBrandRecentTaskInfo aNn()
    {
      AppMethodBeat.i(133389);
      try
      {
        AppBrandRecentTaskInfo localAppBrandRecentTaskInfo = (AppBrandRecentTaskInfo)AppBrandLauncherRecentsList.b(AppBrandLauncherRecentsList.this).pJ(aNm());
        AppMethodBeat.o(133389);
        return localAppBrandRecentTaskInfo;
      }
      catch (Exception localException)
      {
        ab.printErrStackTrace("MicroMsg.AppBrandLauncherRecentsList", localException, "getAppInfo", new Object[0]);
        AppMethodBeat.o(133389);
      }
      return null;
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(133392);
      paramView = aNn();
      if (paramView == null)
      {
        AppMethodBeat.o(133392);
        return;
      }
      AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
      localAppBrandStatObject.scene = 1001;
      switch (AppBrandLauncherRecentsList.this.mScene)
      {
      }
      for (;;)
      {
        AppBrandLaunchProxyUI.a(AppBrandLauncherRecentsList.this.getActivity(), paramView.cmx, null, paramView.gXd, -1, localAppBrandStatObject, null, null);
        if ((AppBrandLauncherRecentsList.this.getActivity() != null) && ((AppBrandLauncherRecentsList.this.getActivity() instanceof AppBrandLauncherUI)))
        {
          paramView = ((AppBrandLauncherUI)AppBrandLauncherRecentsList.this.getActivity()).iMK;
          if (paramView != null) {
            paramView.hca[7] = "1";
          }
        }
        AppMethodBeat.o(133392);
        return;
        localAppBrandStatObject.cJb = 12;
        continue;
        localAppBrandStatObject.cJb = 11;
        continue;
        localAppBrandStatObject.cJb = 13;
      }
    }
    
    public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
    {
      AppMethodBeat.i(133390);
      paramView = aNn();
      if (paramView == null)
      {
        AppMethodBeat.o(133390);
        return;
      }
      if (AppBrandLauncherRecentsList.n(AppBrandLauncherRecentsList.this))
      {
        paramContextMenuInfo = this.aku.getContext();
        if (!paramView.hcd) {
          break label93;
        }
      }
      label93:
      for (int i = 2131296874;; i = 2131296871)
      {
        paramContextMenu.add(0, 1, 0, paramContextMenuInfo.getString(i));
        paramContextMenu.add(0, 2, 0, this.aku.getContext().getString(2131296720));
        AppMethodBeat.o(133390);
        return;
      }
    }
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(133391);
      AppBrandRecentTaskInfo localAppBrandRecentTaskInfo = aNn();
      if ((localAppBrandRecentTaskInfo == null) || (paramMenuItem == null))
      {
        AppMethodBeat.o(133391);
        return;
      }
      String str;
      switch (AppBrandLauncherRecentsList.this.getActivity().getIntent().getIntExtra("extra_get_usage_reason", 3))
      {
      default: 
        paramInt = 1;
        if (paramInt == 7) {
          str = com.tencent.mm.plugin.appbrand.report.h.aKZ();
        }
        break;
      }
      for (;;)
      {
        if (1 == paramMenuItem.getItemId())
        {
          if ((!AppBrandLauncherRecentsList.i(AppBrandLauncherRecentsList.this)) && (AppBrandLauncherRecentsList.a(AppBrandLauncherRecentsList.this).aNs().size() >= AppBrandLauncherRecentsList.A(AppBrandLauncherRecentsList.this)) && (!localAppBrandRecentTaskInfo.hcd))
          {
            if (AppBrandLauncherRecentsList.this.getActivity() != null) {
              com.tencent.mm.ui.base.h.a(AppBrandLauncherRecentsList.this.getActivity(), AppBrandLauncherRecentsList.this.getResources().getString(2131296612, new Object[] { Integer.valueOf(AppBrandLauncherRecentsList.A(AppBrandLauncherRecentsList.this)) }), "", AppBrandLauncherRecentsList.this.getResources().getString(2131297018), false, null);
            }
            AppMethodBeat.o(133391);
            return;
            paramInt = 7;
            break;
            if (TextUtils.isEmpty(AppBrandLauncherRecentsList.z(AppBrandLauncherRecentsList.this))) {
              AppBrandLauncherRecentsList.a(AppBrandLauncherRecentsList.this, com.tencent.mm.plugin.appbrand.report.h.aKY());
            }
            str = AppBrandLauncherRecentsList.z(AppBrandLauncherRecentsList.this);
            continue;
          }
          AppBrandLauncherRecentsList.B(AppBrandLauncherRecentsList.this).ac(new AppBrandLauncherRecentsList.e.2(this, localAppBrandRecentTaskInfo, paramInt, str));
          AppBrandLauncherRecentsList.h(AppBrandLauncherRecentsList.this).iVd = true;
          AppMethodBeat.o(133391);
          return;
        }
      }
      if (2 == paramMenuItem.getItemId())
      {
        if ((localAppBrandRecentTaskInfo.hcd) && (!AppBrandLauncherRecentsList.i(AppBrandLauncherRecentsList.this))) {
          AppBrandLauncherRecentsList.B(AppBrandLauncherRecentsList.this).ac(new AppBrandLauncherRecentsList.e.3(this, localAppBrandRecentTaskInfo, paramInt, str));
        }
        AppBrandLauncherRecentsList.a(AppBrandLauncherRecentsList.this).pI(aNm());
        AppBrandLauncherRecentsList.h(AppBrandLauncherRecentsList.this).iVd = true;
        AppBrandLauncherRecentsList.g(AppBrandLauncherRecentsList.this).aNl();
        AppBrandLauncherRecentsList.b(AppBrandLauncherRecentsList.this).bT(aNm());
        AppBrandLauncherRecentsList.c(AppBrandLauncherRecentsList.this);
        com.tencent.mm.plugin.appbrand.appusage.al.m(localAppBrandRecentTaskInfo.cmx, localAppBrandRecentTaskInfo.appId, localAppBrandRecentTaskInfo.gXd);
      }
      AppMethodBeat.o(133391);
    }
  }
  
  final class f
    extends RecyclerView.m
    implements Runnable
  {
    private f() {}
    
    public final void c(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(133393);
      paramRecyclerView = AppBrandLauncherRecentsList.this;
      if (paramInt == 2) {}
      for (boolean bool = true;; bool = false)
      {
        AppBrandLauncherRecentsList.a(paramRecyclerView, bool);
        if (paramInt == 0) {
          AppBrandLauncherRecentsList.this.postOnUiThread(this);
        }
        AppMethodBeat.o(133393);
        return;
      }
    }
    
    public final void run()
    {
      AppMethodBeat.i(133394);
      if ((AppBrandLauncherRecentsList.d(AppBrandLauncherRecentsList.this) != null) && (AppBrandLauncherRecentsList.q(AppBrandLauncherRecentsList.this) != null) && (AppBrandLauncherRecentsList.b(AppBrandLauncherRecentsList.this) != null) && (AppBrandLauncherRecentsList.E(AppBrandLauncherRecentsList.this) != null))
      {
        int i = AppBrandLauncherRecentsList.q(AppBrandLauncherRecentsList.this).it();
        int j = AppBrandLauncherRecentsList.q(AppBrandLauncherRecentsList.this).iv();
        while (i <= j)
        {
          RecyclerView.v localv = AppBrandLauncherRecentsList.d(AppBrandLauncherRecentsList.this).bQ(i);
          if ((localv instanceof AppBrandLauncherRecentsList.e))
          {
            AppBrandRecentTaskInfo localAppBrandRecentTaskInfo = ((AppBrandLauncherRecentsList.e)localv).aNn();
            if (localAppBrandRecentTaskInfo != null) {
              AppBrandLauncherRecentsList.E(AppBrandLauncherRecentsList.this).b((AppBrandLauncherRecentsList.e)localv, localAppBrandRecentTaskInfo.hcc);
            }
          }
          i += 1;
        }
      }
      AppMethodBeat.o(133394);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.AppBrandLauncherRecentsList
 * JD-Core Version:    0.7.0.1
 */