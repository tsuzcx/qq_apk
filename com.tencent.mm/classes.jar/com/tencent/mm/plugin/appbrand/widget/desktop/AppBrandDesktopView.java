package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.GridLayoutManager.b;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.appusage.ag;
import com.tencent.mm.plugin.appbrand.appusage.ah;
import com.tencent.mm.plugin.appbrand.au.c;
import com.tencent.mm.plugin.appbrand.au.d;
import com.tencent.mm.plugin.appbrand.au.f;
import com.tencent.mm.plugin.appbrand.au.g;
import com.tencent.mm.plugin.appbrand.au.i;
import com.tencent.mm.plugin.appbrand.widget.recent.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import java.util.ArrayList;
import java.util.List;
import kotlin.x;

public class AppBrandDesktopView
  extends DragRecyclerView
{
  public static final int rpG;
  private int aIj;
  private int aIk;
  private RecyclerView.a afJ;
  public int ahF;
  private RecyclerView.l iZi;
  private boolean isLoadingMore;
  private boolean lsi;
  private Context mContext;
  private ArrayList<a> mDataList;
  private Interpolator mInterpolator;
  private int mTouchSlop;
  private int rec;
  private ThreeDotsLoadingView rfc;
  private c rpH;
  private f rpI;
  private boolean rpJ;
  private Toast rpK;
  private AppBrandDesktopDragView rpL;
  private int rpM;
  private int rpN;
  private int rpO;
  private int rpP;
  private View rpQ;
  private String rpR;
  private AppBrandDesktopDragView.a rpS;
  private float rpT;
  private float rpU;
  private boolean rpV;
  private boolean rpW;
  private b rpu;
  
  static
  {
    AppMethodBeat.i(264304);
    rpG = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 100);
    AppMethodBeat.o(264304);
  }
  
  public AppBrandDesktopView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(49604);
    this.ahF = 4;
    this.mDataList = new ArrayList();
    this.rpI = null;
    this.rpJ = true;
    this.isLoadingMore = false;
    this.aIj = 0;
    this.aIk = 0;
    this.rpM = -1;
    this.rpN = -1;
    this.rpP = com.tencent.mm.ci.a.aZ(getContext(), au.d.Edge_10A);
    this.rpR = "";
    this.rpS = new AppBrandDesktopDragView.a()
    {
      public final void Q(float paramAnonymousFloat1, float paramAnonymousFloat2) {}
      
      public final void cT(Object paramAnonymousObject)
      {
        AppMethodBeat.i(49564);
        if (!(paramAnonymousObject instanceof AppBrandDesktopView.a))
        {
          AppMethodBeat.o(49564);
          return;
        }
        com.tencent.mm.plugin.appbrand.widget.recent.b localb = com.tencent.mm.plugin.appbrand.widget.recent.c.rEB.cqf();
        paramAnonymousObject = ((AppBrandDesktopView.a)paramAnonymousObject).rqa;
        if ((localb == null) || (paramAnonymousObject == null))
        {
          AppMethodBeat.o(49564);
          return;
        }
        Log.i("MicroMsg.AppBrandDesktopView", "desktop addCollection %s", new Object[] { paramAnonymousObject.nickname });
        int i = localb.bz(paramAnonymousObject.username, paramAnonymousObject.cBU);
        if (i == 0)
        {
          AppBrandDesktopView.a(AppBrandDesktopView.this, true);
          AppBrandDesktopView.a(AppBrandDesktopView.this).a(true, paramAnonymousObject, 0, true, 2);
          AppMethodBeat.o(49564);
          return;
        }
        if (i == -2)
        {
          i = ((ag)com.tencent.mm.kernel.h.ae(ag.class)).bIW();
          paramAnonymousObject = com.tencent.mm.ui.base.h.a(AppBrandDesktopView.this.getContext(), AppBrandDesktopView.this.getContext().getResources().getString(au.i.app_brand_desktop_add_collection_over_limit, new Object[] { Integer.valueOf(i) }), "", AppBrandDesktopView.this.getContext().getResources().getString(au.i.app_ok), null);
          if (paramAnonymousObject != null)
          {
            paramAnonymousObject.HD(true);
            paramAnonymousObject.setCanceledOnTouchOutside(false);
            paramAnonymousObject.show();
          }
          AppMethodBeat.o(49564);
          return;
        }
        if (i == -3)
        {
          paramAnonymousObject = com.tencent.mm.ui.base.h.a(AppBrandDesktopView.this.getContext(), AppBrandDesktopView.this.getContext().getResources().getString(au.i.app_brand_add_collection_blocked), "", AppBrandDesktopView.this.getContext().getResources().getString(au.i.app_ok), null);
          if (paramAnonymousObject != null)
          {
            paramAnonymousObject.HD(true);
            paramAnonymousObject.setCanceledOnTouchOutside(false);
            paramAnonymousObject.show();
          }
          AppMethodBeat.o(49564);
          return;
        }
        Toast.makeText(AppBrandDesktopView.this.getContext(), AppBrandDesktopView.this.getContext().getString(au.i.app_brand_collection_add_failed), 0).show();
        AppMethodBeat.o(49564);
      }
      
      public final void d(int paramAnonymousInt, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2) {}
      
      public final void g(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
      {
        AppMethodBeat.i(49567);
        Log.i("MicroMsg.AppBrandDesktopView", "alvinluo collection reorderCollection result: %b, startPos: %d, endPos: %d", new Object[] { Boolean.valueOf(AppBrandDesktopView.c(AppBrandDesktopView.this)), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        paramAnonymousObject = (AppBrandDesktopView.a)paramAnonymousObject;
        if (paramAnonymousInt1 != paramAnonymousInt2) {
          AppBrandDesktopView.a(AppBrandDesktopView.this).a(paramAnonymousObject.rqa, paramAnonymousInt1 - 1, paramAnonymousInt2 - 1);
        }
        AppBrandDesktopView.b(AppBrandDesktopView.this);
        AppMethodBeat.o(49567);
      }
      
      public final void l(Object paramAnonymousObject, int paramAnonymousInt)
      {
        AppMethodBeat.i(244261);
        if (paramAnonymousObject == null)
        {
          AppMethodBeat.o(244261);
          return;
        }
        if ((paramAnonymousObject instanceof AppBrandDesktopView.a))
        {
          paramAnonymousObject = (AppBrandDesktopView.a)paramAnonymousObject;
          if ((paramAnonymousObject.type == 2) && (paramAnonymousObject.rqa != null))
          {
            Log.i("MicroMsg.AppBrandDesktopView", "desktop removeCollection %s", new Object[] { paramAnonymousObject.rqa.nickname });
            com.tencent.mm.plugin.appbrand.widget.recent.b localb = com.tencent.mm.plugin.appbrand.widget.recent.c.rEB.cqf();
            if (localb == null)
            {
              AppMethodBeat.o(244261);
              return;
            }
            if (localb.bA(paramAnonymousObject.rqa.username, paramAnonymousObject.rqa.cBU))
            {
              AppBrandDesktopView.a(AppBrandDesktopView.this, false);
              AppBrandDesktopView.a(AppBrandDesktopView.this).a(false, paramAnonymousObject.rqa, paramAnonymousInt, true, 3);
              AppBrandDesktopView.b(AppBrandDesktopView.this);
            }
          }
        }
        AppMethodBeat.o(244261);
      }
      
      public final void m(Object paramAnonymousObject, int paramAnonymousInt)
      {
        AppMethodBeat.i(244262);
        if (paramAnonymousObject == null)
        {
          AppMethodBeat.o(244262);
          return;
        }
        paramAnonymousObject = (AppBrandDesktopView.a)paramAnonymousObject;
        if (paramAnonymousObject.rqa != null)
        {
          Log.i("MicroMsg.AppBrandDesktopView", "alvinluo AppBrandDesktopView removeUsage username: %s, versionType: %d", new Object[] { paramAnonymousObject.rqa.username, Integer.valueOf(paramAnonymousObject.rqa.cBU) });
          i locali = com.tencent.mm.plugin.appbrand.widget.recent.c.rEB.cqe();
          if ((locali != null) && (locali.bB(paramAnonymousObject.rqa.username, paramAnonymousObject.rqa.cBU)))
          {
            AppBrandDesktopView.a(AppBrandDesktopView.this, false);
            AppBrandDesktopView.a(AppBrandDesktopView.this).a(false, paramAnonymousObject.rqa, paramAnonymousInt, false, 2);
          }
        }
        AppMethodBeat.o(244262);
      }
    };
    this.mTouchSlop = ViewConfiguration.get(MMApplicationContext.getContext()).getScaledTouchSlop();
    this.rpT = 0.0F;
    this.rpU = 0.0F;
    this.rpV = false;
    this.rpW = false;
    this.mInterpolator = new DecelerateInterpolator();
    this.iZi = new AppBrandDesktopView.2(this);
    init(paramContext);
    AppMethodBeat.o(49604);
  }
  
  public AppBrandDesktopView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(49605);
    this.ahF = 4;
    this.mDataList = new ArrayList();
    this.rpI = null;
    this.rpJ = true;
    this.isLoadingMore = false;
    this.aIj = 0;
    this.aIk = 0;
    this.rpM = -1;
    this.rpN = -1;
    this.rpP = com.tencent.mm.ci.a.aZ(getContext(), au.d.Edge_10A);
    this.rpR = "";
    this.rpS = new AppBrandDesktopDragView.a()
    {
      public final void Q(float paramAnonymousFloat1, float paramAnonymousFloat2) {}
      
      public final void cT(Object paramAnonymousObject)
      {
        AppMethodBeat.i(49564);
        if (!(paramAnonymousObject instanceof AppBrandDesktopView.a))
        {
          AppMethodBeat.o(49564);
          return;
        }
        com.tencent.mm.plugin.appbrand.widget.recent.b localb = com.tencent.mm.plugin.appbrand.widget.recent.c.rEB.cqf();
        paramAnonymousObject = ((AppBrandDesktopView.a)paramAnonymousObject).rqa;
        if ((localb == null) || (paramAnonymousObject == null))
        {
          AppMethodBeat.o(49564);
          return;
        }
        Log.i("MicroMsg.AppBrandDesktopView", "desktop addCollection %s", new Object[] { paramAnonymousObject.nickname });
        int i = localb.bz(paramAnonymousObject.username, paramAnonymousObject.cBU);
        if (i == 0)
        {
          AppBrandDesktopView.a(AppBrandDesktopView.this, true);
          AppBrandDesktopView.a(AppBrandDesktopView.this).a(true, paramAnonymousObject, 0, true, 2);
          AppMethodBeat.o(49564);
          return;
        }
        if (i == -2)
        {
          i = ((ag)com.tencent.mm.kernel.h.ae(ag.class)).bIW();
          paramAnonymousObject = com.tencent.mm.ui.base.h.a(AppBrandDesktopView.this.getContext(), AppBrandDesktopView.this.getContext().getResources().getString(au.i.app_brand_desktop_add_collection_over_limit, new Object[] { Integer.valueOf(i) }), "", AppBrandDesktopView.this.getContext().getResources().getString(au.i.app_ok), null);
          if (paramAnonymousObject != null)
          {
            paramAnonymousObject.HD(true);
            paramAnonymousObject.setCanceledOnTouchOutside(false);
            paramAnonymousObject.show();
          }
          AppMethodBeat.o(49564);
          return;
        }
        if (i == -3)
        {
          paramAnonymousObject = com.tencent.mm.ui.base.h.a(AppBrandDesktopView.this.getContext(), AppBrandDesktopView.this.getContext().getResources().getString(au.i.app_brand_add_collection_blocked), "", AppBrandDesktopView.this.getContext().getResources().getString(au.i.app_ok), null);
          if (paramAnonymousObject != null)
          {
            paramAnonymousObject.HD(true);
            paramAnonymousObject.setCanceledOnTouchOutside(false);
            paramAnonymousObject.show();
          }
          AppMethodBeat.o(49564);
          return;
        }
        Toast.makeText(AppBrandDesktopView.this.getContext(), AppBrandDesktopView.this.getContext().getString(au.i.app_brand_collection_add_failed), 0).show();
        AppMethodBeat.o(49564);
      }
      
      public final void d(int paramAnonymousInt, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2) {}
      
      public final void g(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
      {
        AppMethodBeat.i(49567);
        Log.i("MicroMsg.AppBrandDesktopView", "alvinluo collection reorderCollection result: %b, startPos: %d, endPos: %d", new Object[] { Boolean.valueOf(AppBrandDesktopView.c(AppBrandDesktopView.this)), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        paramAnonymousObject = (AppBrandDesktopView.a)paramAnonymousObject;
        if (paramAnonymousInt1 != paramAnonymousInt2) {
          AppBrandDesktopView.a(AppBrandDesktopView.this).a(paramAnonymousObject.rqa, paramAnonymousInt1 - 1, paramAnonymousInt2 - 1);
        }
        AppBrandDesktopView.b(AppBrandDesktopView.this);
        AppMethodBeat.o(49567);
      }
      
      public final void l(Object paramAnonymousObject, int paramAnonymousInt)
      {
        AppMethodBeat.i(244261);
        if (paramAnonymousObject == null)
        {
          AppMethodBeat.o(244261);
          return;
        }
        if ((paramAnonymousObject instanceof AppBrandDesktopView.a))
        {
          paramAnonymousObject = (AppBrandDesktopView.a)paramAnonymousObject;
          if ((paramAnonymousObject.type == 2) && (paramAnonymousObject.rqa != null))
          {
            Log.i("MicroMsg.AppBrandDesktopView", "desktop removeCollection %s", new Object[] { paramAnonymousObject.rqa.nickname });
            com.tencent.mm.plugin.appbrand.widget.recent.b localb = com.tencent.mm.plugin.appbrand.widget.recent.c.rEB.cqf();
            if (localb == null)
            {
              AppMethodBeat.o(244261);
              return;
            }
            if (localb.bA(paramAnonymousObject.rqa.username, paramAnonymousObject.rqa.cBU))
            {
              AppBrandDesktopView.a(AppBrandDesktopView.this, false);
              AppBrandDesktopView.a(AppBrandDesktopView.this).a(false, paramAnonymousObject.rqa, paramAnonymousInt, true, 3);
              AppBrandDesktopView.b(AppBrandDesktopView.this);
            }
          }
        }
        AppMethodBeat.o(244261);
      }
      
      public final void m(Object paramAnonymousObject, int paramAnonymousInt)
      {
        AppMethodBeat.i(244262);
        if (paramAnonymousObject == null)
        {
          AppMethodBeat.o(244262);
          return;
        }
        paramAnonymousObject = (AppBrandDesktopView.a)paramAnonymousObject;
        if (paramAnonymousObject.rqa != null)
        {
          Log.i("MicroMsg.AppBrandDesktopView", "alvinluo AppBrandDesktopView removeUsage username: %s, versionType: %d", new Object[] { paramAnonymousObject.rqa.username, Integer.valueOf(paramAnonymousObject.rqa.cBU) });
          i locali = com.tencent.mm.plugin.appbrand.widget.recent.c.rEB.cqe();
          if ((locali != null) && (locali.bB(paramAnonymousObject.rqa.username, paramAnonymousObject.rqa.cBU)))
          {
            AppBrandDesktopView.a(AppBrandDesktopView.this, false);
            AppBrandDesktopView.a(AppBrandDesktopView.this).a(false, paramAnonymousObject.rqa, paramAnonymousInt, false, 2);
          }
        }
        AppMethodBeat.o(244262);
      }
    };
    this.mTouchSlop = ViewConfiguration.get(MMApplicationContext.getContext()).getScaledTouchSlop();
    this.rpT = 0.0F;
    this.rpU = 0.0F;
    this.rpV = false;
    this.rpW = false;
    this.mInterpolator = new DecelerateInterpolator();
    this.iZi = new AppBrandDesktopView.2(this);
    init(paramContext);
    AppMethodBeat.o(49605);
  }
  
  private void DD(int paramInt)
  {
    AppMethodBeat.i(264284);
    com.tencent.mm.plugin.appbrand.widget.desktop.b.a.a(this, com.tencent.mm.ci.a.fromDPToPix(getContext(), 37), paramInt, com.tencent.mm.ci.a.aZ(getContext(), au.d.Edge_3_5_A), cnr(), com.tencent.mm.ci.a.aZ(getContext(), au.d.Edge_4A));
    AppMethodBeat.o(264284);
  }
  
  private int cnr()
  {
    if (this.rpJ) {
      return 1;
    }
    return 0;
  }
  
  private void cns()
  {
    AppMethodBeat.i(264283);
    Log.i("MicroMsg.AppBrandDesktopView", "checkTriggerLoadMore");
    if ((this.rpH.aDl()) && (this.rpI.kL() == this.mDataList.size() - 1)) {
      cny();
    }
    AppMethodBeat.o(264283);
  }
  
  @SuppressLint({"NotifyDataSetChanged"})
  private void cnv()
  {
    AppMethodBeat.i(264288);
    Log.i("MicroMsg.AppBrandDesktopView", "notifyDataChanged");
    if (this.afJ != null) {
      this.afJ.alc.notifyChanged();
    }
    AppMethodBeat.o(264288);
  }
  
  private void cnw()
  {
    AppMethodBeat.i(49614);
    setVerticalFadingEdgeEnabled(false);
    setNestedScrollingEnabled(true);
    setBackgroundColor(getContext().getResources().getColor(au.c.transparent));
    AppMethodBeat.o(49614);
  }
  
  private void cnx()
  {
    AppMethodBeat.i(264291);
    if (this.rpH.aDl())
    {
      Log.i("MicroMsg.AppBrandDesktopView", "add more footer");
      this.mDataList.add(new a(6));
      AppMethodBeat.o(264291);
      return;
    }
    Log.i("MicroMsg.AppBrandDesktopView", "add normal footer");
    this.mDataList.add(new a(3));
    AppMethodBeat.o(264291);
  }
  
  private void cny()
  {
    AppMethodBeat.i(264292);
    Log.i("MicroMsg.AppBrandDesktopView", "start load more hasMore:%b isLoading:%b", new Object[] { Boolean.valueOf(this.rpH.aDl()), Boolean.valueOf(this.isLoadingMore) });
    if ((!this.rpH.aDl()) || (this.isLoadingMore))
    {
      AppMethodBeat.o(264292);
      return;
    }
    this.isLoadingMore = true;
    this.rpH.z(new kotlin.g.a.b() {});
    AppMethodBeat.o(264292);
  }
  
  private int getCollectionDataSize()
  {
    AppMethodBeat.i(49617);
    int i = this.mDataList.size();
    int j = cnr();
    AppMethodBeat.o(49617);
    return i - j - 1;
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(49611);
    this.mContext = paramContext;
    cnt();
    cnu();
    a.init(this.mContext);
    cnw();
    this.rpI = new f(this.ahF);
    this.rpI.ahK = new GridLayoutManager.b()
    {
      public final int cx(int paramAnonymousInt)
      {
        AppMethodBeat.i(277907);
        paramAnonymousInt = AppBrandDesktopView.this.getAdapter().getItemViewType(paramAnonymousInt);
        if ((paramAnonymousInt == 3) || (paramAnonymousInt == 4) || (paramAnonymousInt == 6))
        {
          paramAnonymousInt = AppBrandDesktopView.this.ahF;
          AppMethodBeat.o(277907);
          return paramAnonymousInt;
        }
        AppMethodBeat.o(277907);
        return 1;
      }
    };
    setLayoutManager(this.rpI);
    setOverScrollMode(2);
    a(this.iZi);
    this.afJ = new d((byte)0);
    setAdapter(this.afJ);
    Log.i("MicroMsg.AppBrandDesktopView", "alvinluo DesktopView init %d", new Object[] { Integer.valueOf(hashCode()) });
    DD(com.tencent.mm.ci.a.kr(getContext()));
    AppMethodBeat.o(49611);
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(264281);
    Log.i("MicroMsg.AppBrandDesktopView", "desktop show:%d", new Object[] { Integer.valueOf(paramc.cnA()) });
    this.rpH = paramc;
    if (this.rpL == null)
    {
      localObject = getRootView();
      if (localObject != null) {
        this.rpL = ((AppBrandDesktopDragView)((View)localObject).findViewById(au.f.drag_feature_view));
      }
    }
    else
    {
      Log.i("MicroMsg.AppBrandDesktopView", "configDragFeatureView");
      this.rpL.setRecyclerView(this);
      this.rpL.setList(this.mDataList);
      this.rpL.setAppBrandDragCallback(this.rpS);
      this.rpL.setViewWidth(this.aIj);
      this.rpL.setCanMyWeAppMove(true);
      this.rpL.setShouldDoDeleteAnimation(true);
      k(this.rpL);
    }
    Object localObject = this.rpL;
    if (paramc.cnA() == 1)
    {
      bool = true;
      ((AppBrandDesktopDragView)localObject).kh(bool);
      if (this.rpH != null)
      {
        this.mDataList.clear();
        if (this.rpJ) {
          this.mDataList.add(new a(4));
        }
        paramc = this.rpH.cnB();
        this.mDataList.addAll(paramc);
        cnx();
        cnv();
        localObject = this.rpu;
        if (this.rpH.cnA() != 2) {
          break label298;
        }
      }
    }
    label298:
    for (boolean bool = true;; bool = false)
    {
      ((b)localObject).z(bool, paramc.size());
      Log.i("MicroMsg.AppBrandDesktopView", "make data, search:%b count:%d", new Object[] { Boolean.valueOf(this.rpJ), Integer.valueOf(paramc.size()) });
      AppMethodBeat.o(264281);
      return;
      bool = false;
      break;
    }
  }
  
  public final void cnt()
  {
    AppMethodBeat.i(264285);
    this.lsi = ((com.tencent.mm.plugin.teenmode.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.teenmode.a.b.class)).ZM();
    this.rec = ((com.tencent.mm.plugin.teenmode.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.teenmode.a.b.class)).gks();
    Log.i("MicroMsg.AppBrandDesktopView", "alvinluo updateTeenModeStatus isTeenMode: %b, miniProgramOption: %d", new Object[] { Boolean.valueOf(this.lsi), Integer.valueOf(this.rec) });
    AppMethodBeat.o(264285);
  }
  
  public final void cnu()
  {
    AppMethodBeat.i(264286);
    if ((!this.lsi) || (this.rec == 1)) {}
    for (boolean bool = true;; bool = false)
    {
      this.rpJ = bool;
      Log.i("MicroMsg.AppBrandDesktopView", "alvinluo updateShowSearchStatus showSearch: %b", new Object[] { Boolean.valueOf(this.rpJ) });
      if (!this.rpJ) {
        break label169;
      }
      if (this.mDataList.size() != 0) {
        break;
      }
      Log.i("MicroMsg.AppBrandDesktopView", "showSearch, dataListSize = 0");
      this.mDataList.add(0, new a(4));
      cnv();
      AppMethodBeat.o(264286);
      return;
    }
    a locala = (a)this.mDataList.get(0);
    if ((locala == null) || (locala.type != 4))
    {
      Log.i("MicroMsg.AppBrandDesktopView", "showSearch, insert search");
      this.mDataList.add(0, new a(4));
      cnv();
    }
    AppMethodBeat.o(264286);
    return;
    label169:
    if (this.mDataList.size() > 0)
    {
      locala = (a)this.mDataList.get(0);
      if ((locala != null) && (locala.type == 4))
      {
        Log.i("MicroMsg.AppBrandDesktopView", "remove search");
        this.mDataList.remove(0);
        cnv();
      }
    }
    AppMethodBeat.o(264286);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = 0;
    AppMethodBeat.i(49607);
    boolean bool;
    if (this.rqI)
    {
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(49607);
      return bool;
    }
    switch (paramMotionEvent.getAction())
    {
    default: 
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(49607);
      return bool;
    case 0: 
      this.rpT = paramMotionEvent.getRawY();
    }
    for (;;)
    {
      this.rpU = 0.0F;
      this.rpV = false;
      this.rpW = false;
      break;
      int i = j;
      if (this.rpI != null)
      {
        i = j;
        if (this.mDataList != null)
        {
          i = j;
          if (this.rpI.kM() == this.mDataList.size() - 1) {
            i = 1;
          }
        }
      }
      if ((i != 0) && (!this.rpV))
      {
        if (this.rpH.aDl()) {
          break;
        }
        if (!this.rpW)
        {
          this.rpT = paramMotionEvent.getRawY();
          this.rpU = 0.0F;
          this.rpW = true;
          break;
        }
        this.rpU = ((paramMotionEvent.getRawY() - this.rpT) * 0.55F);
        if (this.rpU >= -this.mTouchSlop) {
          break;
        }
        this.rpV = true;
        break;
      }
      if (!this.rpV) {
        break;
      }
      this.rpU = ((paramMotionEvent.getRawY() - this.rpT) * 0.55F);
      if (this.rpU > 0.0F)
      {
        bool = super.dispatchTouchEvent(paramMotionEvent);
        AppMethodBeat.o(49607);
        return bool;
      }
      setTranslationY(-(int)Math.abs(this.rpU));
      AppMethodBeat.o(49607);
      return true;
      cns();
      if (this.rpV) {
        if (Math.abs(this.rpU) >= rpG)
        {
          Log.i("MicroMsg.AppBrandDesktopView", "alvinluo checkAndClose closeHeader because of pull up bottom");
          this.rpu.DC(15);
        }
        else
        {
          animate().translationY(0.0F).setDuration(300L).setInterpolator(this.mInterpolator).start();
        }
      }
    }
  }
  
  public RecyclerView getRecyclerView()
  {
    return this;
  }
  
  protected float getTopFadingEdgeStrength()
  {
    return 0.0F;
  }
  
  public c getViewModel()
  {
    return this.rpH;
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(49616);
    super.onMeasure(paramInt1, paramInt2);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    View.MeasureSpec.getSize(paramInt2);
    if (paramInt1 != this.aIj)
    {
      this.aIj = paramInt1;
      DD(this.aIj);
    }
    if (this.rpL != null) {
      this.rpL.setViewWidth(this.aIj);
    }
    AppMethodBeat.o(49616);
  }
  
  public final void reset(boolean paramBoolean)
  {
    AppMethodBeat.i(264282);
    Log.i("MicroMsg.AppBrandDesktopView", "reset");
    if (this.rpL != null) {
      this.rpL.cnE();
    }
    this.rpM = -1;
    this.rpN = -1;
    com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.b(this, locala.aFh(), "com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView", "reset", "(Z)V", "Undefined", "scrollToPosition", "(I)V");
    scrollToPosition(((Integer)locala.sf(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView", "reset", "(Z)V", "Undefined", "scrollToPosition", "(I)V");
    setTranslationY(0.0F);
    if (this.rpu != null) {
      this.rpu.ke(paramBoolean);
    }
    AppMethodBeat.o(264282);
  }
  
  public void setCallback(b paramb)
  {
    this.rpu = paramb;
  }
  
  public static final class a
  {
    public LocalUsageInfo rqa;
    int type;
    
    public a(int paramInt)
    {
      this.type = paramInt;
    }
    
    public a(LocalUsageInfo paramLocalUsageInfo, int paramInt)
    {
      this.rqa = paramLocalUsageInfo;
      this.type = paramInt;
    }
    
    public a(a parama)
    {
      this.rqa = parama.rqa;
      this.type = parama.type;
    }
    
    public final LocalUsageInfo cnz()
    {
      return this.rqa;
    }
    
    public final void g(LocalUsageInfo paramLocalUsageInfo)
    {
      this.rqa = paramLocalUsageInfo;
    }
  }
  
  public static abstract interface b
  {
    public abstract void DC(int paramInt);
    
    public abstract void a(int paramInt, AppBrandDesktopView.a parama, boolean paramBoolean1, boolean paramBoolean2);
    
    public abstract void a(LocalUsageInfo paramLocalUsageInfo, int paramInt1, int paramInt2);
    
    public abstract void a(LocalUsageInfo paramLocalUsageInfo, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3);
    
    public abstract void a(boolean paramBoolean1, LocalUsageInfo paramLocalUsageInfo, int paramInt1, boolean paramBoolean2, int paramInt2);
    
    public abstract void c(int paramInt, boolean paramBoolean1, boolean paramBoolean2);
    
    public abstract void ke(boolean paramBoolean);
    
    public abstract void z(boolean paramBoolean, int paramInt);
  }
  
  public final class c
    extends RecyclerView.v
  {
    public c(View paramView)
    {
      super();
    }
  }
  
  final class d
    extends RecyclerView.a
  {
    private d() {}
    
    private AppBrandDesktopView.a DE(int paramInt)
    {
      AppMethodBeat.i(49593);
      if ((paramInt < AppBrandDesktopView.e(AppBrandDesktopView.this).size()) && (paramInt >= 0))
      {
        AppBrandDesktopView.a locala = (AppBrandDesktopView.a)AppBrandDesktopView.e(AppBrandDesktopView.this).get(paramInt);
        AppMethodBeat.o(49593);
        return locala;
      }
      AppMethodBeat.o(49593);
      return null;
    }
    
    public final void a(RecyclerView.v paramv, int paramInt, List paramList)
    {
      AppMethodBeat.i(273872);
      if (paramList.size() == 0) {
        d(paramv, paramInt);
      }
      AppMethodBeat.o(273872);
    }
    
    public final RecyclerView.v b(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(273871);
      if ((paramInt == 2) || (paramInt == 1))
      {
        paramViewGroup = new d(ad.kS(AppBrandDesktopView.this.getContext()).inflate(au.g.appbrand_preview_item, paramViewGroup, false));
        AppMethodBeat.o(273871);
        return paramViewGroup;
      }
      if (paramInt == 3)
      {
        paramViewGroup = new View(AppBrandDesktopView.this.getContext());
        paramViewGroup.setLayoutParams(new RecyclerView.LayoutParams(-1, AppBrandDesktopView.j(AppBrandDesktopView.this)));
        paramViewGroup = new AppBrandDesktopView.c(AppBrandDesktopView.this, paramViewGroup);
        AppMethodBeat.o(273871);
        return paramViewGroup;
      }
      if (paramInt == 4)
      {
        AppBrandDesktopView.a(AppBrandDesktopView.this, ad.kS(AppBrandDesktopView.this.getContext()).inflate(au.g.app_brand_desktop_search_item, paramViewGroup, false));
        paramViewGroup = new AppBrandDesktopView.e(AppBrandDesktopView.this, AppBrandDesktopView.k(AppBrandDesktopView.this));
        AppMethodBeat.o(273871);
        return paramViewGroup;
      }
      if (paramInt == 6)
      {
        paramViewGroup = ad.kS(AppBrandDesktopView.this.getContext()).inflate(au.g.app_brand_desktop_load_more_footer, paramViewGroup, false);
        AppBrandDesktopView.a(AppBrandDesktopView.this, (ThreeDotsLoadingView)paramViewGroup.findViewById(au.f.loading_view));
        paramViewGroup = new AppBrandDesktopView.c(AppBrandDesktopView.this, paramViewGroup);
        AppMethodBeat.o(273871);
        return paramViewGroup;
      }
      paramViewGroup = ad.kS(AppBrandDesktopView.this.getContext()).inflate(au.g.my_appbrand_title_item, paramViewGroup, false);
      paramViewGroup = new AppBrandDesktopView.c(AppBrandDesktopView.this, paramViewGroup);
      AppMethodBeat.o(273871);
      return paramViewGroup;
    }
    
    public final void d(RecyclerView.v paramv, @SuppressLint({"RecyclerView"}) int paramInt)
    {
      AppMethodBeat.i(273873);
      final int i = paramv.amo;
      Object localObject1;
      if (i == 3)
      {
        paramv.amk.setVisibility(4);
        localObject1 = (RecyclerView.LayoutParams)paramv.amk.getLayoutParams();
        ((RecyclerView.LayoutParams)localObject1).height = AppBrandDesktopView.j(AppBrandDesktopView.this);
        paramv.amk.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        AppMethodBeat.o(273873);
        return;
      }
      if ((i == 6) && (AppBrandDesktopView.l(AppBrandDesktopView.this) != null)) {
        AppBrandDesktopView.l(AppBrandDesktopView.this).hZX();
      }
      if (i == 4)
      {
        AppBrandDesktopView.b(AppBrandDesktopView.this, paramv.amk);
        AppMethodBeat.o(273873);
        return;
      }
      Object localObject2;
      if ((i == 1) || (i == 2))
      {
        localObject2 = (d)paramv;
        localObject1 = DE(paramInt);
        if (localObject1 == null)
        {
          AppMethodBeat.o(273873);
          return;
        }
        ((d)localObject2).rqn = ((AppBrandDesktopView.a)localObject1);
        ((d)localObject2).b(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(252379);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$ItemAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
            if (AppBrandDesktopView.this.rqI)
            {
              Log.i("MicroMsg.AppBrandDesktopView", "inLongPress, return");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$ItemAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(252379);
              return;
            }
            paramAnonymousView = AppBrandDesktopView.a(AppBrandDesktopView.this);
            int i = this.rqb.md();
            int j = AppBrandDesktopView.m(AppBrandDesktopView.this);
            localObject = this.rqc;
            if (i == 2) {}
            for (boolean bool = true;; bool = false)
            {
              paramAnonymousView.a(i - j, (AppBrandDesktopView.a)localObject, bool, true);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$ItemAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(252379);
              return;
            }
          }
        });
        if (AppBrandDesktopView.n(AppBrandDesktopView.this) == 0)
        {
          localObject2 = paramv.amk;
          ((View)localObject2).measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
          Log.i("MicroMsg.AppBrandDesktopView", "alvinluo onBindViewHolder itemHeight: %d, itemWidth: %d", new Object[] { Integer.valueOf(((View)localObject2).getMeasuredHeight()), Integer.valueOf(((View)localObject2).getMeasuredWidth()) });
          AppBrandDesktopView.b(AppBrandDesktopView.this, ((View)localObject2).getMeasuredHeight());
        }
        localObject2 = AppBrandDesktopView.this;
        if (i != 2) {
          break label315;
        }
      }
      label315:
      for (boolean bool = true;; bool = false)
      {
        AppBrandDesktopView.a((AppBrandDesktopView)localObject2, bool, (AppBrandDesktopView.a)localObject1, paramInt);
        if ((AppBrandDesktopView.this.getDragRubbishView() != null) && (AppBrandDesktopView.this.getDragRubbishView().getRecyclerView() == AppBrandDesktopView.this)) {
          AppBrandDesktopView.this.getDragRubbishView().d(paramv, paramInt);
        }
        AppMethodBeat.o(273873);
        return;
      }
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(49592);
      int i = AppBrandDesktopView.e(AppBrandDesktopView.this).size();
      AppMethodBeat.o(49592);
      return i;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(49590);
      AppBrandDesktopView.a locala = DE(paramInt);
      if (locala != null)
      {
        paramInt = locala.type;
        AppMethodBeat.o(49590);
        return paramInt;
      }
      AppMethodBeat.o(49590);
      return 0;
    }
  }
  
  public final class e
    extends RecyclerView.v
  {
    private View.OnClickListener bwV;
    protected TextView rqf;
    
    public e(View paramView)
    {
      super();
      AppMethodBeat.i(49596);
      this.bwV = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(49595);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$SearchViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          Log.i("MicroMsg.AppBrandDesktopView", "alvinluo AppbrandDesktop search jump to AppBrandSearchUI");
          System.currentTimeMillis();
          paramAnonymousView = (com.tencent.mm.plugin.websearch.api.h)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.websearch.api.h.class);
          if (paramAnonymousView != null)
          {
            localObject = AppBrandDesktopView.a(AppBrandDesktopView.this);
            if (AppBrandDesktopView.o(AppBrandDesktopView.this).cnA() != 2) {
              break label146;
            }
          }
          label146:
          for (boolean bool = true;; bool = false)
          {
            ((AppBrandDesktopView.b)localObject).c(12, true, bool);
            paramAnonymousView.b(AppBrandDesktopView.p(AppBrandDesktopView.this), 42, AppBrandDesktopView.q(AppBrandDesktopView.this), "");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$SearchViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(49595);
            return;
          }
        }
      };
      this.rqf = ((TextView)paramView.findViewById(au.f.app_brand_desktop_search_edit_text));
      if (this.rqf != null)
      {
        this.rqf.setFocusable(false);
        this.rqf.setOnClickListener(this.bwV);
      }
      paramView.setOnClickListener(this.bwV);
      AppMethodBeat.o(49596);
    }
  }
  
  static final class f
    extends GridLayoutManager
  {
    public f(int paramInt)
    {
      super(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView
 * JD-Core Version:    0.7.0.1
 */