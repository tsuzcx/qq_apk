package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.accessibility.AccessibilityEvent;
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
import androidx.recyclerview.widget.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.appusage.ag;
import com.tencent.mm.plugin.appbrand.ba.c;
import com.tencent.mm.plugin.appbrand.ba.d;
import com.tencent.mm.plugin.appbrand.ba.f;
import com.tencent.mm.plugin.appbrand.ba.g;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import com.tencent.mm.ui.widget.a.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.ah;

public class AppBrandDesktopView
  extends DragRecyclerView
{
  public static final int uzS;
  RecyclerView.a bUp;
  public int bWl;
  private boolean epi;
  private boolean isLoadingMore;
  private RecyclerView.l lBe;
  private Context mContext;
  ArrayList<a> mDataList;
  private Interpolator mInterpolator;
  private int mTouchSlop;
  private int mViewHeight;
  int mViewWidth;
  private float puP;
  private int uAa;
  private int uAb;
  private View uAc;
  private String uAd;
  AppBrandDesktopDragView.a uAe;
  private float uAf;
  private boolean uAg;
  private boolean uAh;
  private ThreeDotsLoadingView uiD;
  private int umi;
  b uzG;
  c uzT;
  private f uzU;
  boolean uzV;
  private Toast uzW;
  AppBrandDesktopDragView uzX;
  private int uzY;
  private int uzZ;
  
  static
  {
    AppMethodBeat.i(324562);
    uzS = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 100);
    AppMethodBeat.o(324562);
  }
  
  public AppBrandDesktopView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(49604);
    this.bWl = 4;
    this.mDataList = new ArrayList();
    this.uzU = null;
    this.uzV = true;
    this.isLoadingMore = false;
    this.mViewWidth = 0;
    this.mViewHeight = 0;
    this.uzY = -1;
    this.uzZ = -1;
    this.uAb = com.tencent.mm.cd.a.bs(getContext(), ba.d.Edge_10A);
    this.uAd = "";
    this.uAe = new AppBrandDesktopDragView.a()
    {
      public final void aw(float paramAnonymousFloat1, float paramAnonymousFloat2) {}
      
      public final void d(int paramAnonymousInt, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2) {}
      
      public final void ep(Object paramAnonymousObject)
      {
        AppMethodBeat.i(49564);
        if (!(paramAnonymousObject instanceof AppBrandDesktopView.a))
        {
          AppMethodBeat.o(49564);
          return;
        }
        com.tencent.mm.plugin.appbrand.widget.recent.b localb = com.tencent.mm.plugin.appbrand.widget.recent.c.uPM.cSK();
        paramAnonymousObject = ((AppBrandDesktopView.a)paramAnonymousObject).uAl;
        if ((localb == null) || (paramAnonymousObject == null))
        {
          AppMethodBeat.o(49564);
          return;
        }
        Log.i("MicroMsg.AppBrandDesktopView", "desktop addCollection %s", new Object[] { paramAnonymousObject.nickname });
        int i = localb.bR(paramAnonymousObject.username, paramAnonymousObject.euz);
        if (i == 0)
        {
          AppBrandDesktopView.a(AppBrandDesktopView.this, true);
          AppBrandDesktopView.a(AppBrandDesktopView.this).a(true, paramAnonymousObject, 0, true, 2);
          AppMethodBeat.o(49564);
          return;
        }
        if (i == -2)
        {
          i = ((com.tencent.mm.plugin.appbrand.appusage.af)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.appusage.af.class)).ciA();
          paramAnonymousObject = k.a(AppBrandDesktopView.this.getContext(), AppBrandDesktopView.this.getContext().getResources().getString(ba.i.app_brand_desktop_add_collection_over_limit, new Object[] { Integer.valueOf(i) }), "", AppBrandDesktopView.this.getContext().getResources().getString(ba.i.app_ok), null);
          if (paramAnonymousObject != null)
          {
            paramAnonymousObject.Nz(true);
            paramAnonymousObject.setCanceledOnTouchOutside(false);
            paramAnonymousObject.show();
          }
          AppMethodBeat.o(49564);
          return;
        }
        if (i == -3)
        {
          paramAnonymousObject = k.a(AppBrandDesktopView.this.getContext(), AppBrandDesktopView.this.getContext().getResources().getString(ba.i.app_brand_add_collection_blocked), "", AppBrandDesktopView.this.getContext().getResources().getString(ba.i.app_ok), null);
          if (paramAnonymousObject != null)
          {
            paramAnonymousObject.Nz(true);
            paramAnonymousObject.setCanceledOnTouchOutside(false);
            paramAnonymousObject.show();
          }
          AppMethodBeat.o(49564);
          return;
        }
        Toast.makeText(AppBrandDesktopView.this.getContext(), AppBrandDesktopView.this.getContext().getString(ba.i.app_brand_collection_add_failed), 0).show();
        AppMethodBeat.o(49564);
      }
      
      public final void g(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
      {
        AppMethodBeat.i(49567);
        Log.i("MicroMsg.AppBrandDesktopView", "alvinluo collection reorderCollection result: %b, startPos: %d, endPos: %d", new Object[] { Boolean.valueOf(AppBrandDesktopView.c(AppBrandDesktopView.this)), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        paramAnonymousObject = (AppBrandDesktopView.a)paramAnonymousObject;
        if (paramAnonymousInt1 != paramAnonymousInt2) {
          AppBrandDesktopView.a(AppBrandDesktopView.this).a(paramAnonymousObject.uAl, paramAnonymousInt1 - 1, paramAnonymousInt2 - 1);
        }
        AppBrandDesktopView.b(AppBrandDesktopView.this);
        AppMethodBeat.o(49567);
      }
      
      public final void n(Object paramAnonymousObject, int paramAnonymousInt)
      {
        AppMethodBeat.i(324222);
        if (paramAnonymousObject == null)
        {
          AppMethodBeat.o(324222);
          return;
        }
        if ((paramAnonymousObject instanceof AppBrandDesktopView.a))
        {
          paramAnonymousObject = (AppBrandDesktopView.a)paramAnonymousObject;
          if ((paramAnonymousObject.type == 2) && (paramAnonymousObject.uAl != null))
          {
            Log.i("MicroMsg.AppBrandDesktopView", "desktop removeCollection %s", new Object[] { paramAnonymousObject.uAl.nickname });
            com.tencent.mm.plugin.appbrand.widget.recent.b localb = com.tencent.mm.plugin.appbrand.widget.recent.c.uPM.cSK();
            if (localb == null)
            {
              AppMethodBeat.o(324222);
              return;
            }
            if (localb.bS(paramAnonymousObject.uAl.username, paramAnonymousObject.uAl.euz))
            {
              AppBrandDesktopView.a(AppBrandDesktopView.this, false);
              AppBrandDesktopView.a(AppBrandDesktopView.this).a(false, paramAnonymousObject.uAl, paramAnonymousInt, true, 3);
              AppBrandDesktopView.b(AppBrandDesktopView.this);
            }
          }
        }
        AppMethodBeat.o(324222);
      }
      
      public final void o(Object paramAnonymousObject, int paramAnonymousInt)
      {
        AppMethodBeat.i(324225);
        if (paramAnonymousObject == null)
        {
          AppMethodBeat.o(324225);
          return;
        }
        paramAnonymousObject = (AppBrandDesktopView.a)paramAnonymousObject;
        if (paramAnonymousObject.uAl != null)
        {
          Log.i("MicroMsg.AppBrandDesktopView", "alvinluo AppBrandDesktopView removeUsage username: %s, versionType: %d", new Object[] { paramAnonymousObject.uAl.username, Integer.valueOf(paramAnonymousObject.uAl.euz) });
          com.tencent.mm.plugin.appbrand.widget.recent.i locali = com.tencent.mm.plugin.appbrand.widget.recent.c.uPM.cSJ();
          if ((locali != null) && (locali.bT(paramAnonymousObject.uAl.username, paramAnonymousObject.uAl.euz)))
          {
            AppBrandDesktopView.a(AppBrandDesktopView.this, false);
            AppBrandDesktopView.a(AppBrandDesktopView.this).a(false, paramAnonymousObject.uAl, paramAnonymousInt, false, 2);
          }
        }
        AppMethodBeat.o(324225);
      }
    };
    this.mTouchSlop = ViewConfiguration.get(MMApplicationContext.getContext()).getScaledTouchSlop();
    this.puP = 0.0F;
    this.uAf = 0.0F;
    this.uAg = false;
    this.uAh = false;
    this.mInterpolator = new DecelerateInterpolator();
    this.lBe = new AppBrandDesktopView.2(this);
    init(paramContext);
    AppMethodBeat.o(49604);
  }
  
  public AppBrandDesktopView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(49605);
    this.bWl = 4;
    this.mDataList = new ArrayList();
    this.uzU = null;
    this.uzV = true;
    this.isLoadingMore = false;
    this.mViewWidth = 0;
    this.mViewHeight = 0;
    this.uzY = -1;
    this.uzZ = -1;
    this.uAb = com.tencent.mm.cd.a.bs(getContext(), ba.d.Edge_10A);
    this.uAd = "";
    this.uAe = new AppBrandDesktopDragView.a()
    {
      public final void aw(float paramAnonymousFloat1, float paramAnonymousFloat2) {}
      
      public final void d(int paramAnonymousInt, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2) {}
      
      public final void ep(Object paramAnonymousObject)
      {
        AppMethodBeat.i(49564);
        if (!(paramAnonymousObject instanceof AppBrandDesktopView.a))
        {
          AppMethodBeat.o(49564);
          return;
        }
        com.tencent.mm.plugin.appbrand.widget.recent.b localb = com.tencent.mm.plugin.appbrand.widget.recent.c.uPM.cSK();
        paramAnonymousObject = ((AppBrandDesktopView.a)paramAnonymousObject).uAl;
        if ((localb == null) || (paramAnonymousObject == null))
        {
          AppMethodBeat.o(49564);
          return;
        }
        Log.i("MicroMsg.AppBrandDesktopView", "desktop addCollection %s", new Object[] { paramAnonymousObject.nickname });
        int i = localb.bR(paramAnonymousObject.username, paramAnonymousObject.euz);
        if (i == 0)
        {
          AppBrandDesktopView.a(AppBrandDesktopView.this, true);
          AppBrandDesktopView.a(AppBrandDesktopView.this).a(true, paramAnonymousObject, 0, true, 2);
          AppMethodBeat.o(49564);
          return;
        }
        if (i == -2)
        {
          i = ((com.tencent.mm.plugin.appbrand.appusage.af)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.appusage.af.class)).ciA();
          paramAnonymousObject = k.a(AppBrandDesktopView.this.getContext(), AppBrandDesktopView.this.getContext().getResources().getString(ba.i.app_brand_desktop_add_collection_over_limit, new Object[] { Integer.valueOf(i) }), "", AppBrandDesktopView.this.getContext().getResources().getString(ba.i.app_ok), null);
          if (paramAnonymousObject != null)
          {
            paramAnonymousObject.Nz(true);
            paramAnonymousObject.setCanceledOnTouchOutside(false);
            paramAnonymousObject.show();
          }
          AppMethodBeat.o(49564);
          return;
        }
        if (i == -3)
        {
          paramAnonymousObject = k.a(AppBrandDesktopView.this.getContext(), AppBrandDesktopView.this.getContext().getResources().getString(ba.i.app_brand_add_collection_blocked), "", AppBrandDesktopView.this.getContext().getResources().getString(ba.i.app_ok), null);
          if (paramAnonymousObject != null)
          {
            paramAnonymousObject.Nz(true);
            paramAnonymousObject.setCanceledOnTouchOutside(false);
            paramAnonymousObject.show();
          }
          AppMethodBeat.o(49564);
          return;
        }
        Toast.makeText(AppBrandDesktopView.this.getContext(), AppBrandDesktopView.this.getContext().getString(ba.i.app_brand_collection_add_failed), 0).show();
        AppMethodBeat.o(49564);
      }
      
      public final void g(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
      {
        AppMethodBeat.i(49567);
        Log.i("MicroMsg.AppBrandDesktopView", "alvinluo collection reorderCollection result: %b, startPos: %d, endPos: %d", new Object[] { Boolean.valueOf(AppBrandDesktopView.c(AppBrandDesktopView.this)), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        paramAnonymousObject = (AppBrandDesktopView.a)paramAnonymousObject;
        if (paramAnonymousInt1 != paramAnonymousInt2) {
          AppBrandDesktopView.a(AppBrandDesktopView.this).a(paramAnonymousObject.uAl, paramAnonymousInt1 - 1, paramAnonymousInt2 - 1);
        }
        AppBrandDesktopView.b(AppBrandDesktopView.this);
        AppMethodBeat.o(49567);
      }
      
      public final void n(Object paramAnonymousObject, int paramAnonymousInt)
      {
        AppMethodBeat.i(324222);
        if (paramAnonymousObject == null)
        {
          AppMethodBeat.o(324222);
          return;
        }
        if ((paramAnonymousObject instanceof AppBrandDesktopView.a))
        {
          paramAnonymousObject = (AppBrandDesktopView.a)paramAnonymousObject;
          if ((paramAnonymousObject.type == 2) && (paramAnonymousObject.uAl != null))
          {
            Log.i("MicroMsg.AppBrandDesktopView", "desktop removeCollection %s", new Object[] { paramAnonymousObject.uAl.nickname });
            com.tencent.mm.plugin.appbrand.widget.recent.b localb = com.tencent.mm.plugin.appbrand.widget.recent.c.uPM.cSK();
            if (localb == null)
            {
              AppMethodBeat.o(324222);
              return;
            }
            if (localb.bS(paramAnonymousObject.uAl.username, paramAnonymousObject.uAl.euz))
            {
              AppBrandDesktopView.a(AppBrandDesktopView.this, false);
              AppBrandDesktopView.a(AppBrandDesktopView.this).a(false, paramAnonymousObject.uAl, paramAnonymousInt, true, 3);
              AppBrandDesktopView.b(AppBrandDesktopView.this);
            }
          }
        }
        AppMethodBeat.o(324222);
      }
      
      public final void o(Object paramAnonymousObject, int paramAnonymousInt)
      {
        AppMethodBeat.i(324225);
        if (paramAnonymousObject == null)
        {
          AppMethodBeat.o(324225);
          return;
        }
        paramAnonymousObject = (AppBrandDesktopView.a)paramAnonymousObject;
        if (paramAnonymousObject.uAl != null)
        {
          Log.i("MicroMsg.AppBrandDesktopView", "alvinluo AppBrandDesktopView removeUsage username: %s, versionType: %d", new Object[] { paramAnonymousObject.uAl.username, Integer.valueOf(paramAnonymousObject.uAl.euz) });
          com.tencent.mm.plugin.appbrand.widget.recent.i locali = com.tencent.mm.plugin.appbrand.widget.recent.c.uPM.cSJ();
          if ((locali != null) && (locali.bT(paramAnonymousObject.uAl.username, paramAnonymousObject.uAl.euz)))
          {
            AppBrandDesktopView.a(AppBrandDesktopView.this, false);
            AppBrandDesktopView.a(AppBrandDesktopView.this).a(false, paramAnonymousObject.uAl, paramAnonymousInt, false, 2);
          }
        }
        AppMethodBeat.o(324225);
      }
    };
    this.mTouchSlop = ViewConfiguration.get(MMApplicationContext.getContext()).getScaledTouchSlop();
    this.puP = 0.0F;
    this.uAf = 0.0F;
    this.uAg = false;
    this.uAh = false;
    this.mInterpolator = new DecelerateInterpolator();
    this.lBe = new AppBrandDesktopView.2(this);
    init(paramContext);
    AppMethodBeat.o(49605);
  }
  
  private void Ec(int paramInt)
  {
    AppMethodBeat.i(324357);
    com.tencent.mm.plugin.appbrand.widget.desktop.b.a.a(this, com.tencent.mm.cd.a.fromDPToPix(getContext(), 37), paramInt, com.tencent.mm.cd.a.bs(getContext(), ba.d.Edge_3_5_A), cPt(), com.tencent.mm.cd.a.bs(getContext(), ba.d.Edge_4A));
    AppMethodBeat.o(324357);
  }
  
  private void cPB()
  {
    AppMethodBeat.i(324415);
    Log.i("MicroMsg.AppBrandDesktopView", "start load more hasMore:%b isLoading:%b", new Object[] { Boolean.valueOf(this.uzT.aWl()), Boolean.valueOf(this.isLoadingMore) });
    if ((!this.uzT.aWl()) || (this.isLoadingMore))
    {
      AppMethodBeat.o(324415);
      return;
    }
    this.isLoadingMore = true;
    this.uzT.ab(new kotlin.g.a.b() {});
    AppMethodBeat.o(324415);
  }
  
  private int cPt()
  {
    if (this.uzV) {
      return 1;
    }
    return 0;
  }
  
  private void cPu()
  {
    AppMethodBeat.i(324334);
    Log.i("MicroMsg.AppBrandDesktopView", "checkTriggerLoadMore");
    if ((this.uzT.aWl()) && (this.uzU.Jw() == this.mDataList.size() - 1)) {
      cPB();
    }
    AppMethodBeat.o(324334);
  }
  
  private void cPw()
  {
    AppMethodBeat.i(324368);
    this.epi = ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu();
    this.umi = ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).hEr();
    Log.i("MicroMsg.AppBrandDesktopView", "alvinluo updateTeenModeStatus isTeenMode: %b, miniProgramOption: %d", new Object[] { Boolean.valueOf(this.epi), Integer.valueOf(this.umi) });
    AppMethodBeat.o(324368);
  }
  
  private void cPx()
  {
    AppMethodBeat.i(324385);
    if (!this.epi) {}
    for (boolean bool = true;; bool = false)
    {
      this.uzV = bool;
      Log.i("MicroMsg.AppBrandDesktopView", "alvinluo updateShowSearchStatus showSearch: %b", new Object[] { Boolean.valueOf(this.uzV) });
      if (!this.uzV) {
        break label161;
      }
      if (this.mDataList.size() != 0) {
        break;
      }
      Log.i("MicroMsg.AppBrandDesktopView", "showSearch, dataListSize = 0");
      this.mDataList.add(0, new a(4));
      cPy();
      AppMethodBeat.o(324385);
      return;
    }
    a locala = (a)this.mDataList.get(0);
    if ((locala == null) || (locala.type != 4))
    {
      Log.i("MicroMsg.AppBrandDesktopView", "showSearch, insert search");
      this.mDataList.add(0, new a(4));
      cPy();
    }
    AppMethodBeat.o(324385);
    return;
    label161:
    if (this.mDataList.size() > 0)
    {
      locala = (a)this.mDataList.get(0);
      if ((locala != null) && (locala.type == 4))
      {
        Log.i("MicroMsg.AppBrandDesktopView", "remove search");
        this.mDataList.remove(0);
        cPy();
      }
    }
    AppMethodBeat.o(324385);
  }
  
  private void cPz()
  {
    AppMethodBeat.i(49614);
    setVerticalFadingEdgeEnabled(false);
    setNestedScrollingEnabled(true);
    setBackgroundColor(getContext().getResources().getColor(ba.c.transparent));
    AppMethodBeat.o(49614);
  }
  
  static String dL(List<a> paramList)
  {
    AppMethodBeat.i(324407);
    Iterator localIterator = paramList.iterator();
    a locala;
    for (paramList = ""; localIterator.hasNext(); paramList = paramList + locala.uAl.nickname + " ") {
      locala = (a)localIterator.next();
    }
    AppMethodBeat.o(324407);
    return paramList;
  }
  
  private int getCollectionDataSize()
  {
    AppMethodBeat.i(49617);
    int i = this.mDataList.size();
    int j = cPt();
    AppMethodBeat.o(49617);
    return i - j - 1;
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(49611);
    this.mContext = paramContext;
    cPw();
    cPx();
    a.init(this.mContext);
    cPz();
    this.uzU = new f(this.bWl);
    this.uzU.bWq = new GridLayoutManager.b()
    {
      public final int fJ(int paramAnonymousInt)
      {
        AppMethodBeat.i(324218);
        paramAnonymousInt = AppBrandDesktopView.this.getAdapter().getItemViewType(paramAnonymousInt);
        if ((paramAnonymousInt == 3) || (paramAnonymousInt == 4) || (paramAnonymousInt == 6))
        {
          paramAnonymousInt = AppBrandDesktopView.this.bWl;
          AppMethodBeat.o(324218);
          return paramAnonymousInt;
        }
        AppMethodBeat.o(324218);
        return 1;
      }
    };
    setLayoutManager(this.uzU);
    setOverScrollMode(2);
    a(this.lBe);
    this.bUp = new d((byte)0);
    setAdapter(this.bUp);
    Log.i("MicroMsg.AppBrandDesktopView", "alvinluo DesktopView init %d", new Object[] { Integer.valueOf(hashCode()) });
    Ec(com.tencent.mm.cd.a.ms(getContext()));
    AppMethodBeat.o(49611);
  }
  
  final void cPA()
  {
    AppMethodBeat.i(324610);
    if (this.uzT.aWl())
    {
      Log.i("MicroMsg.AppBrandDesktopView", "add more footer");
      this.mDataList.add(new a(6));
      AppMethodBeat.o(324610);
      return;
    }
    Log.i("MicroMsg.AppBrandDesktopView", "add normal footer");
    this.mDataList.add(new a(3));
    AppMethodBeat.o(324610);
  }
  
  public final void cPv()
  {
    AppMethodBeat.i(324603);
    if (!com.tencent.threadpool.h.ahAA.isShutdown()) {
      com.tencent.threadpool.h.ahAA.bk(new AppBrandDesktopView..ExternalSyntheticLambda0(this));
    }
    AppMethodBeat.o(324603);
  }
  
  final void cPy()
  {
    AppMethodBeat.i(324607);
    Log.i("MicroMsg.AppBrandDesktopView", "notifyDataChanged");
    if (this.bUp != null) {
      this.bUp.bZE.notifyChanged();
    }
    AppMethodBeat.o(324607);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = 0;
    AppMethodBeat.i(49607);
    boolean bool;
    if (this.uAR)
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
      this.puP = paramMotionEvent.getRawY();
    }
    for (;;)
    {
      this.uAf = 0.0F;
      this.uAg = false;
      this.uAh = false;
      break;
      int i = j;
      if (this.uzU != null)
      {
        i = j;
        if (this.mDataList != null)
        {
          i = j;
          if (this.uzU.Jx() == this.mDataList.size() - 1) {
            i = 1;
          }
        }
      }
      if ((i != 0) && (!this.uAg))
      {
        if (this.uzT.aWl()) {
          break;
        }
        if (!this.uAh)
        {
          this.puP = paramMotionEvent.getRawY();
          this.uAf = 0.0F;
          this.uAh = true;
          break;
        }
        this.uAf = ((paramMotionEvent.getRawY() - this.puP) * 0.55F);
        if (this.uAf >= -this.mTouchSlop) {
          break;
        }
        this.uAg = true;
        break;
      }
      if (!this.uAg) {
        break;
      }
      this.uAf = ((paramMotionEvent.getRawY() - this.puP) * 0.55F);
      if (this.uAf > 0.0F)
      {
        bool = super.dispatchTouchEvent(paramMotionEvent);
        AppMethodBeat.o(49607);
        return bool;
      }
      setTranslationY(-(int)Math.abs(this.uAf));
      AppMethodBeat.o(49607);
      return true;
      cPu();
      if (this.uAg) {
        if (Math.abs(this.uAf) >= uzS)
        {
          Log.i("MicroMsg.AppBrandDesktopView", "alvinluo checkAndClose closeHeader because of pull up bottom");
          this.uzG.Eb(15);
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
    return this.uzT;
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(49616);
    super.onMeasure(paramInt1, paramInt2);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    View.MeasureSpec.getSize(paramInt2);
    if (paramInt1 != this.mViewWidth)
    {
      this.mViewWidth = paramInt1;
      Ec(this.mViewWidth);
    }
    if (this.uzX != null) {
      this.uzX.setViewWidth(this.mViewWidth);
    }
    AppMethodBeat.o(49616);
  }
  
  public boolean onRequestSendAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(324599);
    com.tencent.mm.hellhoundlib.b.a locala;
    if (paramAccessibilityEvent.getEventType() == 32768)
    {
      if (bj(paramView).KJ() < this.uzU.Jw() - 4) {
        break label141;
      }
      locala = com.tencent.mm.hellhoundlib.b.c.a(this.uzU.Jw() + 1, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(this, locala.aYi(), "com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView", "onRequestSendAccessibilityEvent", "(Landroid/view/View;Landroid/view/accessibility/AccessibilityEvent;)Z", "Undefined", "scrollToPosition", "(I)V");
      scrollToPosition(((Integer)locala.sb(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView", "onRequestSendAccessibilityEvent", "(Landroid/view/View;Landroid/view/accessibility/AccessibilityEvent;)Z", "Undefined", "scrollToPosition", "(I)V");
      cPu();
    }
    for (;;)
    {
      boolean bool = super.onRequestSendAccessibilityEvent(paramView, paramAccessibilityEvent);
      AppMethodBeat.o(324599);
      return bool;
      label141:
      if (bj(paramView).KJ() == this.uzU.Ju())
      {
        locala = com.tencent.mm.hellhoundlib.b.c.a(this.uzU.Ju() - 1, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.b(this, locala.aYi(), "com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView", "onRequestSendAccessibilityEvent", "(Landroid/view/View;Landroid/view/accessibility/AccessibilityEvent;)Z", "Undefined", "scrollToPosition", "(I)V");
        scrollToPosition(((Integer)locala.sb(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView", "onRequestSendAccessibilityEvent", "(Landroid/view/View;Landroid/view/accessibility/AccessibilityEvent;)Z", "Undefined", "scrollToPosition", "(I)V");
      }
    }
  }
  
  public final void reset(boolean paramBoolean)
  {
    AppMethodBeat.i(324581);
    Log.i("MicroMsg.AppBrandDesktopView", "reset");
    if (this.uzX != null) {
      this.uzX.cPH();
    }
    this.uzY = -1;
    this.uzZ = -1;
    com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.b(this, locala.aYi(), "com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView", "reset", "(Z)V", "Undefined", "scrollToPosition", "(I)V");
    scrollToPosition(((Integer)locala.sb(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView", "reset", "(Z)V", "Undefined", "scrollToPosition", "(I)V");
    setTranslationY(0.0F);
    if (this.uzG != null) {
      this.uzG.lo(paramBoolean);
    }
    AppMethodBeat.o(324581);
  }
  
  public void setCallback(b paramb)
  {
    this.uzG = paramb;
  }
  
  public static final class a
  {
    int type;
    public LocalUsageInfo uAl;
    
    public a(int paramInt)
    {
      this.type = paramInt;
    }
    
    public a(LocalUsageInfo paramLocalUsageInfo, int paramInt)
    {
      this.uAl = paramLocalUsageInfo;
      this.type = paramInt;
    }
    
    public a(a parama)
    {
      this.uAl = parama.uAl;
      this.type = parama.type;
    }
    
    public final boolean a(a parama)
    {
      AppMethodBeat.i(324249);
      if (this.uAl == null)
      {
        AppMethodBeat.o(324249);
        return false;
      }
      if (parama.uAl == null)
      {
        AppMethodBeat.o(324249);
        return false;
      }
      if (Util.isNullOrNil(this.uAl.username))
      {
        AppMethodBeat.o(324249);
        return false;
      }
      if (Util.isNullOrNil(parama.uAl.username))
      {
        AppMethodBeat.o(324249);
        return false;
      }
      parama = parama.uAl;
      LocalUsageInfo localLocalUsageInfo = this.uAl;
      if ((localLocalUsageInfo != null) && (!Util.isNullOrNil(localLocalUsageInfo.username)) && (localLocalUsageInfo.username.equals(parama.username)) && (localLocalUsageInfo.euz == parama.euz)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(324249);
        return true;
      }
      AppMethodBeat.o(324249);
      return false;
    }
  }
  
  public static abstract interface b
  {
    public abstract void Eb(int paramInt);
    
    public abstract void a(int paramInt, AppBrandDesktopView.a parama, boolean paramBoolean1, boolean paramBoolean2);
    
    public abstract void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, String paramString);
    
    public abstract void a(LocalUsageInfo paramLocalUsageInfo, int paramInt1, int paramInt2);
    
    public abstract void a(LocalUsageInfo paramLocalUsageInfo, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3);
    
    public abstract void a(boolean paramBoolean1, LocalUsageInfo paramLocalUsageInfo, int paramInt1, boolean paramBoolean2, int paramInt2);
    
    public abstract void lo(boolean paramBoolean);
    
    public abstract void x(boolean paramBoolean, int paramInt);
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
    
    private AppBrandDesktopView.a Ed(int paramInt)
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
      AppMethodBeat.i(324278);
      if (paramList.size() == 0) {
        d(paramv, paramInt);
      }
      AppMethodBeat.o(324278);
    }
    
    public final RecyclerView.v b(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(324269);
      if ((paramInt == 2) || (paramInt == 1))
      {
        paramViewGroup = new d(com.tencent.mm.ui.af.mU(AppBrandDesktopView.this.getContext()).inflate(ba.g.appbrand_preview_item, paramViewGroup, false));
        AppMethodBeat.o(324269);
        return paramViewGroup;
      }
      if (paramInt == 3)
      {
        paramViewGroup = new View(AppBrandDesktopView.this.getContext());
        paramViewGroup.setLayoutParams(new RecyclerView.LayoutParams(-1, AppBrandDesktopView.j(AppBrandDesktopView.this)));
        paramViewGroup = new AppBrandDesktopView.c(AppBrandDesktopView.this, paramViewGroup);
        AppMethodBeat.o(324269);
        return paramViewGroup;
      }
      if (paramInt == 4)
      {
        AppBrandDesktopView.a(AppBrandDesktopView.this, com.tencent.mm.ui.af.mU(AppBrandDesktopView.this.getContext()).inflate(ba.g.app_brand_desktop_search_item, paramViewGroup, false));
        paramViewGroup = new AppBrandDesktopView.e(AppBrandDesktopView.this, AppBrandDesktopView.k(AppBrandDesktopView.this));
        AppMethodBeat.o(324269);
        return paramViewGroup;
      }
      if (paramInt == 6)
      {
        paramViewGroup = com.tencent.mm.ui.af.mU(AppBrandDesktopView.this.getContext()).inflate(ba.g.app_brand_desktop_load_more_footer, paramViewGroup, false);
        AppBrandDesktopView.a(AppBrandDesktopView.this, (ThreeDotsLoadingView)paramViewGroup.findViewById(ba.f.loading_view));
        paramViewGroup = new AppBrandDesktopView.c(AppBrandDesktopView.this, paramViewGroup);
        AppMethodBeat.o(324269);
        return paramViewGroup;
      }
      paramViewGroup = com.tencent.mm.ui.af.mU(AppBrandDesktopView.this.getContext()).inflate(ba.g.my_appbrand_title_item, paramViewGroup, false);
      paramViewGroup = new AppBrandDesktopView.c(AppBrandDesktopView.this, paramViewGroup);
      AppMethodBeat.o(324269);
      return paramViewGroup;
    }
    
    public final void d(RecyclerView.v paramv, int paramInt)
    {
      AppMethodBeat.i(324286);
      final int i = paramv.caO;
      Object localObject1;
      if (i == 3)
      {
        paramv.caK.setVisibility(4);
        localObject1 = (RecyclerView.LayoutParams)paramv.caK.getLayoutParams();
        ((RecyclerView.LayoutParams)localObject1).height = AppBrandDesktopView.j(AppBrandDesktopView.this);
        paramv.caK.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        AppMethodBeat.o(324286);
        return;
      }
      if ((i == 6) && (AppBrandDesktopView.l(AppBrandDesktopView.this) != null)) {
        AppBrandDesktopView.l(AppBrandDesktopView.this).jFe();
      }
      if (i == 4)
      {
        AppBrandDesktopView.b(AppBrandDesktopView.this, paramv.caK);
        AppMethodBeat.o(324286);
        return;
      }
      Object localObject2;
      if ((i == 1) || (i == 2))
      {
        localObject2 = (d)paramv;
        localObject1 = Ed(paramInt);
        if (localObject1 == null)
        {
          AppMethodBeat.o(324286);
          return;
        }
        ((d)localObject2).uAy = ((AppBrandDesktopView.a)localObject1);
        ((d)localObject2).b(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(324251);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$ItemAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
            if (AppBrandDesktopView.this.uAR)
            {
              Log.i("MicroMsg.AppBrandDesktopView", "inLongPress, return");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$ItemAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(324251);
              return;
            }
            paramAnonymousView = AppBrandDesktopView.a(AppBrandDesktopView.this);
            int i = this.uAm.KJ();
            int j = AppBrandDesktopView.m(AppBrandDesktopView.this);
            localObject = this.uAn;
            if (i == 2) {}
            for (boolean bool = true;; bool = false)
            {
              paramAnonymousView.a(i - j, (AppBrandDesktopView.a)localObject, bool, true);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$ItemAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(324251);
              return;
            }
          }
        });
        if (AppBrandDesktopView.n(AppBrandDesktopView.this) == 0)
        {
          localObject2 = paramv.caK;
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
        AppMethodBeat.o(324286);
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
      AppBrandDesktopView.a locala = Ed(paramInt);
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
    private View.OnClickListener dpY;
    protected TextView uAq;
    
    public e(View paramView)
    {
      super();
      AppMethodBeat.i(49596);
      this.dpY = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(49595);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$SearchViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
          Log.i("MicroMsg.AppBrandDesktopView", "alvinluo AppbrandDesktop search jump to AppBrandSearchUI");
          System.currentTimeMillis();
          if ((com.tencent.mm.plugin.websearch.api.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.websearch.api.h.class) != null)
          {
            paramAnonymousView = AppBrandDesktopView.a(AppBrandDesktopView.this);
            if (AppBrandDesktopView.o(AppBrandDesktopView.this).cPD() != 2) {
              break label155;
            }
          }
          label155:
          for (boolean bool = true;; bool = false)
          {
            paramAnonymousView.a(12, true, bool, null);
            paramAnonymousView = (com.tencent.mm.plugin.websearch.api.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.websearch.api.h.class);
            localObject = AppBrandDesktopView.p(AppBrandDesktopView.this);
            AppBrandDesktopView.q(AppBrandDesktopView.this);
            paramAnonymousView.bg((Context)localObject, 42);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$SearchViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(49595);
            return;
          }
        }
      };
      this.uAq = ((TextView)paramView.findViewById(ba.f.app_brand_desktop_search_edit_text));
      if (this.uAq != null)
      {
        this.uAq.setFocusable(false);
        this.uAq.setOnClickListener(this.dpY);
        this.uAq.setImportantForAccessibility(2);
        paramView.setImportantForAccessibility(1);
        paramView.setContentDescription(AppBrandDesktopView.this.getContext().getString(ba.i._accessibility_app_brand_desktop_search_edit_text_hint_bar));
      }
      paramView.setOnClickListener(this.dpY);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView
 * JD-Core Version:    0.7.0.1
 */