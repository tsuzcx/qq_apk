package com.tencent.mm.plugin.appbrand.widget.desktop.half;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.c;
import android.support.v7.widget.RecyclerView.w;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.appusage.ah;
import com.tencent.mm.plugin.appbrand.report.j;
import com.tencent.mm.plugin.appbrand.widget.desktop.c;
import com.tencent.mm.plugin.appbrand.widget.desktop.d;
import com.tencent.mm.plugin.appbrand.widget.header.a.a.a;
import com.tencent.mm.plugin.appbrand.widget.header.a.a.b;
import com.tencent.mm.plugin.appbrand.widget.header.c.a;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.a;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.b;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.d;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.e;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.f;
import com.tencent.mm.plugin.appbrand.widget.recentview.ConversationAppBrandRecentView;
import com.tencent.mm.plugin.appbrand.widget.recentview.e.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AppBrandDesktopHalfView
  extends LinearLayout
  implements com.tencent.mm.plugin.appbrand.widget.header.a.a, c.a
{
  boolean dhO;
  private int guA;
  private Context mContext;
  private int mvQ;
  private boolean mwR;
  private com.tencent.mm.plugin.appbrand.widget.recentview.b myL;
  private AppBrandDesktopHalfItemView mza;
  private AppBrandDesktopHalfItemView mzb;
  private LinearLayout mzc;
  private LinearLayout mzd;
  private boolean mze;
  private boolean mzf;
  private AppBrandRecentView.e mzg;
  private AppBrandRecentView.e mzh;
  private c mzi;
  private String mzj;
  private boolean mzk;
  private boolean mzl;
  private a.a mzm;
  private int startIndex;
  
  public AppBrandDesktopHalfView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(49793);
    this.mze = false;
    this.mzf = false;
    this.mvQ = 0;
    this.mzg = null;
    this.mzh = null;
    com.tencent.mm.plugin.appbrand.widget.desktop.b.byD();
    this.startIndex = 1;
    this.mzi = null;
    this.myL = null;
    this.mzj = null;
    this.mzk = true;
    this.mwR = false;
    this.guA = 0;
    this.mzl = true;
    this.dhO = false;
    init(paramContext);
    AppMethodBeat.o(49793);
  }
  
  public AppBrandDesktopHalfView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(49794);
    this.mze = false;
    this.mzf = false;
    this.mvQ = 0;
    this.mzg = null;
    this.mzh = null;
    com.tencent.mm.plugin.appbrand.widget.desktop.b.byD();
    this.startIndex = 1;
    this.mzi = null;
    this.myL = null;
    this.mzj = null;
    this.mzk = true;
    this.mwR = false;
    this.guA = 0;
    this.mzl = true;
    this.dhO = false;
    init(paramContext);
    AppMethodBeat.o(49794);
  }
  
  public AppBrandDesktopHalfView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(49795);
    this.mze = false;
    this.mzf = false;
    this.mvQ = 0;
    this.mzg = null;
    this.mzh = null;
    com.tencent.mm.plugin.appbrand.widget.desktop.b.byD();
    this.startIndex = 1;
    this.mzi = null;
    this.myL = null;
    this.mzj = null;
    this.mzk = true;
    this.mwR = false;
    this.guA = 0;
    this.mzl = true;
    this.dhO = false;
    init(paramContext);
    AppMethodBeat.o(49795);
  }
  
  private void hV(boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(49798);
    ac.i("MicroMsg.AppBrandDesktopHalfView", "alvinluo showEmptyView show: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    LinearLayout localLinearLayout;
    if (paramBoolean)
    {
      if ((this.mzc.getVisibility() != 0) && (this.mzm != null)) {
        this.mzm.hX(true);
      }
      localLinearLayout = this.mzc;
      if (!paramBoolean) {
        break label109;
      }
    }
    for (;;)
    {
      localLinearLayout.setVisibility(i);
      AppMethodBeat.o(49798);
      return;
      if ((this.mzc.getVisibility() != 0) || (this.mzm == null)) {
        break;
      }
      this.mzm.hX(false);
      break;
      label109:
      i = 4;
    }
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(49797);
    this.mContext = paramContext;
    com.tencent.mm.plugin.appbrand.widget.desktop.b.init(this.mContext);
    this.mvQ = getItemPadding();
    ac.i("MicroMsg.AppBrandDesktopHalfView", "alvinluo init itemPadding: %d", new Object[] { Integer.valueOf(this.mvQ) });
    paramContext = z.jD(this.mContext).inflate(2131492986, this);
    this.mzc = ((LinearLayout)paramContext.findViewById(2131296698));
    this.mzd = ((LinearLayout)paramContext.findViewById(2131296697));
    this.mza = ((AppBrandDesktopHalfItemView)paramContext.findViewById(2131296707));
    this.mza.a(AppBrandRecentView.f.mMx);
    this.mza.setItemPadding(this.mvQ);
    this.mza.setTitlePaddingLeft(this.mvQ + com.tencent.mm.cc.a.fromDPToPix(this.mContext, 8));
    this.mza.getRecentView().a(new a(this.mvQ));
    this.mza.setRefreshListener(new AppBrandRecentView.e()
    {
      public final void ul(int paramAnonymousInt)
      {
        int i = 0;
        AppMethodBeat.i(49770);
        ac.i("MicroMsg.AppBrandDesktopHalfView", "alvinluo refresh RecentData onDone size: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        AppBrandDesktopHalfView.a(AppBrandDesktopHalfView.this);
        AppBrandDesktopHalfView.b(AppBrandDesktopHalfView.this);
        if (paramAnonymousInt <= AppBrandDesktopHalfView.c(AppBrandDesktopHalfView.this).getRecentView().getCustomItemCount()) {
          AppBrandDesktopHalfView.d(AppBrandDesktopHalfView.this).setVisibility(8);
        }
        for (;;)
        {
          if (AppBrandDesktopHalfView.f(AppBrandDesktopHalfView.this) != null)
          {
            AppBrandRecentView.e locale = AppBrandDesktopHalfView.f(AppBrandDesktopHalfView.this);
            if (paramAnonymousInt - AppBrandDesktopHalfView.d(AppBrandDesktopHalfView.this).getRecentView().getCustomItemCount() > 0) {
              i = paramAnonymousInt - AppBrandDesktopHalfView.d(AppBrandDesktopHalfView.this).getRecentView().getCustomItemCount();
            }
            locale.ul(i);
          }
          AppMethodBeat.o(49770);
          return;
          if (AppBrandDesktopHalfView.e(AppBrandDesktopHalfView.this).getVisibility() != 0) {
            AppBrandDesktopHalfView.e(AppBrandDesktopHalfView.this).setVisibility(0);
          }
          if (AppBrandDesktopHalfView.d(AppBrandDesktopHalfView.this).getVisibility() != 0) {
            AppBrandDesktopHalfView.d(AppBrandDesktopHalfView.this).setVisibility(0);
          }
        }
      }
    });
    this.mza.setOnDataChangedListener(new AppBrandRecentView.d()
    {
      public final void bzt()
      {
        AppMethodBeat.i(49779);
        AppBrandDesktopHalfView.b(AppBrandDesktopHalfView.this);
        AppMethodBeat.o(49779);
      }
    });
    this.mza.myJ = new RecyclerView.c()
    {
      public final void au(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(49786);
        super.au(paramAnonymousInt1, paramAnonymousInt2);
        if (AppBrandDesktopHalfView.d(AppBrandDesktopHalfView.this).getDataCount() <= AppBrandDesktopHalfView.d(AppBrandDesktopHalfView.this).getCustomCount()) {
          AppBrandDesktopHalfView.d(AppBrandDesktopHalfView.this).setVisibility(8);
        }
        AppMethodBeat.o(49786);
      }
    };
    this.mza.setCreateContextMenuListener(new View.OnCreateContextMenuListener()
    {
      public final void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(49787);
        paramAnonymousContextMenu.add(0, 11, 0, AppBrandDesktopHalfView.this.getContext().getResources().getString(2131755383));
        AppMethodBeat.o(49787);
      }
    });
    this.mza.setMenuItemSelectedListener(new AppBrandRecentView.a() {});
    this.mza.setOnItemClickListener(new AppBrandRecentView.b()
    {
      public final boolean a(View paramAnonymousView, com.tencent.mm.plugin.appbrand.widget.recentview.a paramAnonymousa, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(49789);
        AppBrandDesktopHalfView.this.setLayoutFrozen(true);
        if ((AppBrandDesktopHalfView.g(AppBrandDesktopHalfView.this) != null) && (paramAnonymousa != null) && (paramAnonymousa.mxs != null) && (!bs.isNullOrNil(paramAnonymousa.mxs.appId)))
        {
          AppBrandDesktopHalfView.d(AppBrandDesktopHalfView.this).getRecentView();
          int i = RecyclerView.bw(paramAnonymousView);
          if (i != -1)
          {
            AppBrandDesktopHalfView.h(AppBrandDesktopHalfView.this);
            AppBrandDesktopHalfView.g(AppBrandDesktopHalfView.this).ce(paramAnonymousa.mxs.appId, i);
          }
          AppBrandDesktopHalfView.i(AppBrandDesktopHalfView.this);
        }
        AppMethodBeat.o(49789);
        return false;
      }
      
      public final boolean b(View paramAnonymousView, com.tencent.mm.plugin.appbrand.widget.recentview.a paramAnonymousa, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        return false;
      }
    });
    this.mzb = ((AppBrandDesktopHalfItemView)paramContext.findViewById(2131296706));
    this.mzb.a(AppBrandRecentView.f.mMy);
    this.mzb.setItemPadding(this.mvQ);
    this.mzb.setTitlePaddingLeft(this.mvQ + com.tencent.mm.cc.a.fromDPToPix(this.mContext, 8));
    this.mzb.getRecentView().a(new a(this.mvQ));
    this.mzb.setRefreshListener(new AppBrandRecentView.e()
    {
      public final void ul(int paramAnonymousInt)
      {
        int i = 0;
        AppMethodBeat.i(49790);
        ac.i("MicroMsg.AppBrandDesktopHalfView", "alvinluo refresh CollectionData onDone size: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        AppBrandDesktopHalfView.j(AppBrandDesktopHalfView.this);
        AppBrandDesktopHalfView.b(AppBrandDesktopHalfView.this);
        if (paramAnonymousInt <= AppBrandDesktopHalfView.c(AppBrandDesktopHalfView.this).getRecentView().getCustomItemCount()) {
          AppBrandDesktopHalfView.c(AppBrandDesktopHalfView.this).setVisibility(8);
        }
        for (;;)
        {
          if (AppBrandDesktopHalfView.k(AppBrandDesktopHalfView.this) != null)
          {
            AppBrandRecentView.e locale = AppBrandDesktopHalfView.k(AppBrandDesktopHalfView.this);
            if (paramAnonymousInt - AppBrandDesktopHalfView.c(AppBrandDesktopHalfView.this).getRecentView().getCustomItemCount() > 0) {
              i = paramAnonymousInt - AppBrandDesktopHalfView.c(AppBrandDesktopHalfView.this).getRecentView().getCustomItemCount();
            }
            locale.ul(i);
          }
          i = AppBrandDesktopHalfView.c(AppBrandDesktopHalfView.this).getRecentView().getAdapter().getItemCount();
          AppBrandDesktopHalfView.c(AppBrandDesktopHalfView.this).getRecentView().getAdapter().ao(paramAnonymousInt - 1, i - paramAnonymousInt);
          AppMethodBeat.o(49790);
          return;
          AppBrandDesktopHalfView.e(AppBrandDesktopHalfView.this).setVisibility(0);
          AppBrandDesktopHalfView.c(AppBrandDesktopHalfView.this).setVisibility(0);
        }
      }
    });
    this.mzb.setOnDataChangedListener(new AppBrandRecentView.d()
    {
      public final void bzt()
      {
        AppMethodBeat.i(49791);
        AppBrandDesktopHalfView.b(AppBrandDesktopHalfView.this);
        AppMethodBeat.o(49791);
      }
    });
    this.mzb.myJ = new RecyclerView.c()
    {
      public final void au(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(49792);
        super.au(paramAnonymousInt1, paramAnonymousInt2);
        if (AppBrandDesktopHalfView.c(AppBrandDesktopHalfView.this).getDataCount() <= AppBrandDesktopHalfView.c(AppBrandDesktopHalfView.this).getCustomCount()) {
          AppBrandDesktopHalfView.c(AppBrandDesktopHalfView.this).setVisibility(8);
        }
        AppMethodBeat.o(49792);
      }
    };
    this.mzb.setCreateContextMenuListener(new View.OnCreateContextMenuListener()
    {
      public final void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(49771);
        if (paramAnonymousView != null)
        {
          AppBrandDesktopHalfView.c(AppBrandDesktopHalfView.this).getRecentView();
          int i = ConversationAppBrandRecentView.bw(paramAnonymousView);
          ac.d("MicroMsg.AppBrandDesktopHalfView", "alvinluo menu current pos: %d", new Object[] { Integer.valueOf(i) });
          if (i > AppBrandDesktopHalfView.l(AppBrandDesktopHalfView.this)) {
            paramAnonymousContextMenu.add(0, 12, 0, AppBrandDesktopHalfView.this.getContext().getResources().getString(2131755384));
          }
        }
        AppMethodBeat.o(49771);
      }
    });
    this.mzb.setMenuItemSelectedListener(new AppBrandRecentView.a() {});
    this.mzb.setOnItemClickListener(new AppBrandRecentView.b()
    {
      public final boolean a(View paramAnonymousView, com.tencent.mm.plugin.appbrand.widget.recentview.a paramAnonymousa, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(49773);
        AppBrandDesktopHalfView.this.setLayoutFrozen(true);
        if ((AppBrandDesktopHalfView.g(AppBrandDesktopHalfView.this) != null) && (paramAnonymousa != null) && (paramAnonymousa.mxs != null) && (!bs.isNullOrNil(paramAnonymousa.mxs.appId)))
        {
          AppBrandDesktopHalfView.c(AppBrandDesktopHalfView.this).getRecentView();
          int i = RecyclerView.bw(paramAnonymousView);
          if (i != -1)
          {
            AppBrandDesktopHalfView.h(AppBrandDesktopHalfView.this);
            AppBrandDesktopHalfView.g(AppBrandDesktopHalfView.this).cf(paramAnonymousa.mxs.appId, i);
          }
          AppBrandDesktopHalfView.i(AppBrandDesktopHalfView.this);
        }
        AppMethodBeat.o(49773);
        return false;
      }
      
      public final boolean b(View paramAnonymousView, com.tencent.mm.plugin.appbrand.widget.recentview.a paramAnonymousa, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        return false;
      }
    });
    this.mza.setEnableDataCache(true);
    this.mzb.setEnableDataCache(false);
    AppMethodBeat.o(49797);
  }
  
  private static void l(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(49806);
    Object localObject = (LinearLayoutManager)paramRecyclerView.getLayoutManager();
    int i = ((LinearLayoutManager)localObject).jW();
    int j = ((LinearLayoutManager)localObject).jY();
    ac.i("MicroMsg.AppBrandDesktopHalfView", "alvinluo checkAlphaChange firstPos: %d, lastPos: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    if (i <= j)
    {
      localObject = paramRecyclerView.ci(i);
      if ((localObject != null) && (((RecyclerView.w)localObject).asD != null))
      {
        ((RecyclerView.w)localObject).asD.setScaleX(1.0F);
        ((RecyclerView.w)localObject).asD.setScaleY(1.0F);
        if (i != j) {
          break label110;
        }
        ((RecyclerView.w)localObject).asD.setAlpha(0.3F);
      }
      for (;;)
      {
        i += 1;
        break;
        label110:
        ((RecyclerView.w)localObject).asD.setAlpha(1.0F);
      }
    }
    AppMethodBeat.o(49806);
  }
  
  private void vC(int paramInt)
  {
    AppMethodBeat.i(49799);
    Object localObject = this.mzb.getPreviewList();
    ArrayList localArrayList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      LocalUsageInfo localLocalUsageInfo = ((com.tencent.mm.plugin.appbrand.widget.recentview.a)((Iterator)localObject).next()).mxs;
      if (localLocalUsageInfo != null)
      {
        ac.d("MicroMsg.AppBrandDesktopHalfView", "alvinluo reorderCollection info: %s, %d", new Object[] { localLocalUsageInfo.nickname, Integer.valueOf(localLocalUsageInfo.hxM) });
        localArrayList.add(localLocalUsageInfo);
      }
    }
    if (paramInt == 1) {
      this.mzb.getRecentView().setIgnoreNotify(false);
    }
    for (;;)
    {
      ((ah)g.ab(ah.class)).g(localArrayList, paramInt);
      AppMethodBeat.o(49799);
      return;
      this.mzb.getRecentView().setIgnoreNotify(true);
    }
  }
  
  public final void byW() {}
  
  public final void byX() {}
  
  public final void bzp()
  {
    AppMethodBeat.i(49803);
    if (this.mzb != null) {
      this.mzb.bzp();
    }
    if (this.mza != null) {
      this.mza.bzp();
    }
    AppMethodBeat.o(49803);
  }
  
  public final void bzq()
  {
    AppMethodBeat.i(49801);
    ac.d("MicroMsg.AppBrandDesktopHalfView", "alvinluo HalfView onOpen");
    this.mwR = true;
    g.ab(ah.class);
    String str = j.btg();
    this.mzj = str;
    j.QE(str);
    AppMethodBeat.o(49801);
  }
  
  public final void bzr()
  {
    AppMethodBeat.i(49811);
    ac.i("MicroMsg.AppBrandDesktopHalfView", "alvinluo checkReportNameDuplicated");
    com.tencent.mm.sdk.g.b.c(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(49785);
        try
        {
          long l = System.currentTimeMillis();
          com.tencent.mm.plugin.appbrand.widget.recentview.b.j(AppBrandDesktopHalfView.d(AppBrandDesktopHalfView.this).getPreviewList(), AppBrandDesktopHalfView.c(AppBrandDesktopHalfView.this).getPreviewList());
          ac.i("MicroMsg.AppBrandDesktopHalfView", "alvinluo computeNameDuplicatedResults cost: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
          AppMethodBeat.o(49785);
          return;
        }
        catch (Exception localException)
        {
          ac.printErrStackTrace("MicroMsg.AppBrandDesktopHalfView", localException, "alvinluo checkReportNameDuplicated", new Object[0]);
          AppMethodBeat.o(49785);
        }
      }
    }, "checkReportNameDuplicated");
    AppMethodBeat.o(49811);
  }
  
  public final void e(Configuration paramConfiguration)
  {
    AppMethodBeat.i(49807);
    onConfigurationChanged(paramConfiguration);
    ac.i("MicroMsg.AppBrandDesktopHalfView", "alvinluo HalfView onConfigurationChanged orientation: %d", new Object[] { Integer.valueOf(paramConfiguration.orientation) });
    int i = getItemPadding();
    if ((this.guA != paramConfiguration.orientation) || (i != this.mvQ))
    {
      this.guA = paramConfiguration.orientation;
      com.tencent.mm.plugin.appbrand.widget.desktop.b.init(getContext());
      this.mvQ = i;
      if (this.mza != null) {
        this.mza.setTitlePaddingLeft(this.mvQ + com.tencent.mm.cc.a.fromDPToPix(this.mContext, 8));
      }
      if (this.mzb != null) {
        this.mzb.setTitlePaddingLeft(this.mvQ + com.tencent.mm.cc.a.fromDPToPix(this.mContext, 8));
      }
      if (this.mza != null) {
        this.mza.e(paramConfiguration);
      }
      if (this.mzb != null) {
        this.mzb.e(paramConfiguration);
      }
    }
    AppMethodBeat.o(49807);
  }
  
  public int getItemPadding()
  {
    AppMethodBeat.i(49796);
    int i = d.dY(getContext());
    AppMethodBeat.o(49796);
    return i;
  }
  
  public int getRecentAppBrandCount()
  {
    AppMethodBeat.i(49808);
    if (this.mza != null)
    {
      int i = this.mza.getDataCount();
      int j = this.mza.getCustomCount();
      AppMethodBeat.o(49808);
      return i - j;
    }
    AppMethodBeat.o(49808);
    return 0;
  }
  
  public int getStarAppBrandCount()
  {
    AppMethodBeat.i(49809);
    if (this.mzb != null)
    {
      int i = this.mzb.getDataCount();
      int j = this.mzb.getCustomCount();
      AppMethodBeat.o(49809);
      return i - j;
    }
    AppMethodBeat.o(49809);
    return 0;
  }
  
  public final void refresh()
  {
    AppMethodBeat.i(49813);
    ac.i("MicroMsg.AppBrandDesktopHalfView", "alvinluo refresh data");
    this.mzf = true;
    this.mzb.mwd.refresh();
    this.mze = true;
    this.mza.mwd.refresh();
    AppMethodBeat.o(49813);
  }
  
  public void setCollectionRefreshListener(AppBrandRecentView.e parame)
  {
    this.mzh = parame;
  }
  
  public void setIOnLaunchUIListener(a.b paramb)
  {
    AppMethodBeat.i(49812);
    if (this.mza != null) {
      this.mza.setOnLaunchUIListener(paramb);
    }
    if (this.mzb != null) {
      this.mzb.setOnLaunchUIListener(paramb);
    }
    AppMethodBeat.o(49812);
  }
  
  public void setLayoutFrozen(boolean paramBoolean)
  {
    AppMethodBeat.i(49805);
    if ((this.mza != null) && (this.mza.getRecentView() != null)) {
      this.mza.getRecentView().setLayoutFrozen(paramBoolean);
    }
    if ((this.mzb != null) && (this.mzb.getRecentView() != null)) {
      this.mzb.getRecentView().setLayoutFrozen(paramBoolean);
    }
    AppMethodBeat.o(49805);
  }
  
  public void setMyRefreshListener(AppBrandRecentView.e parame)
  {
    this.mzh = parame;
  }
  
  public void setNeedScrollToFirstPageWhenResume(boolean paramBoolean)
  {
    this.mzk = paramBoolean;
  }
  
  public void setOnEmptyViewListener(a.a parama)
  {
    this.mzm = parama;
  }
  
  public void setRecentRefreshListener(AppBrandRecentView.e parame)
  {
    this.mzg = parame;
  }
  
  public void setReporter(com.tencent.mm.plugin.appbrand.widget.recentview.b paramb)
  {
    AppMethodBeat.i(49810);
    this.myL = paramb;
    if (this.mza != null) {
      this.mza.setReporter(paramb);
    }
    if (this.mzb != null) {
      this.mzb.setReporter(paramb);
    }
    AppMethodBeat.o(49810);
  }
  
  public void setUsageRefreshListener(AppBrandRecentView.e parame)
  {
    this.mzg = parame;
  }
  
  public final void vD(int paramInt)
  {
    AppMethodBeat.i(49802);
    ac.i("MicroMsg.AppBrandDesktopHalfView", "alvinluo HalfView onClose type: %d, isHeaderOpen: %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.mwR) });
    if (this.mwR)
    {
      this.mwR = false;
      vC(1);
    }
    AppMethodBeat.o(49802);
  }
  
  public final void vw(int paramInt)
  {
    AppMethodBeat.i(49800);
    ac.i("MicroMsg.AppBrandDesktopHalfView", "alvinluo onCloseHeader");
    postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(49783);
        if (AppBrandDesktopHalfView.c(AppBrandDesktopHalfView.this) != null) {
          AppBrandDesktopHalfView.c(AppBrandDesktopHalfView.this).a(null);
        }
        if (AppBrandDesktopHalfView.d(AppBrandDesktopHalfView.this) != null) {
          AppBrandDesktopHalfView.d(AppBrandDesktopHalfView.this).a(null);
        }
        AppMethodBeat.o(49783);
      }
    }, 500L);
    AppMethodBeat.o(49800);
  }
  
  public final void vx(int paramInt)
  {
    AppMethodBeat.i(49804);
    vw(paramInt);
    AppMethodBeat.o(49804);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.half.AppBrandDesktopHalfView
 * JD-Core Version:    0.7.0.1
 */