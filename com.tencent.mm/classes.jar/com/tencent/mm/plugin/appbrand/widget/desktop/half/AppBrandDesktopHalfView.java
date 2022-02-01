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
import android.support.v7.widget.RecyclerView.v;
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
import com.tencent.mm.plugin.appbrand.report.k;
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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AppBrandDesktopHalfView
  extends LinearLayout
  implements com.tencent.mm.plugin.appbrand.widget.header.a.a, c.a
{
  boolean dkt;
  private int lTO;
  private boolean lUP;
  private com.tencent.mm.plugin.appbrand.widget.recentview.b lWJ;
  private AppBrandDesktopHalfItemView lWY;
  private AppBrandDesktopHalfItemView lWZ;
  private LinearLayout lXa;
  private LinearLayout lXb;
  private boolean lXc;
  private boolean lXd;
  private AppBrandRecentView.e lXe;
  private AppBrandRecentView.e lXf;
  private c lXg;
  private String lXh;
  private boolean lXi;
  private boolean lXj;
  private a.a lXk;
  private int lgU;
  private Context mContext;
  private int startIndex;
  
  public AppBrandDesktopHalfView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(49793);
    this.lXc = false;
    this.lXd = false;
    this.lTO = 0;
    this.lXe = null;
    this.lXf = null;
    com.tencent.mm.plugin.appbrand.widget.desktop.b.brD();
    this.startIndex = 1;
    this.lXg = null;
    this.lWJ = null;
    this.lXh = null;
    this.lXi = true;
    this.lUP = false;
    this.lgU = 0;
    this.lXj = true;
    this.dkt = false;
    init(paramContext);
    AppMethodBeat.o(49793);
  }
  
  public AppBrandDesktopHalfView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(49794);
    this.lXc = false;
    this.lXd = false;
    this.lTO = 0;
    this.lXe = null;
    this.lXf = null;
    com.tencent.mm.plugin.appbrand.widget.desktop.b.brD();
    this.startIndex = 1;
    this.lXg = null;
    this.lWJ = null;
    this.lXh = null;
    this.lXi = true;
    this.lUP = false;
    this.lgU = 0;
    this.lXj = true;
    this.dkt = false;
    init(paramContext);
    AppMethodBeat.o(49794);
  }
  
  public AppBrandDesktopHalfView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(49795);
    this.lXc = false;
    this.lXd = false;
    this.lTO = 0;
    this.lXe = null;
    this.lXf = null;
    com.tencent.mm.plugin.appbrand.widget.desktop.b.brD();
    this.startIndex = 1;
    this.lXg = null;
    this.lWJ = null;
    this.lXh = null;
    this.lXi = true;
    this.lUP = false;
    this.lgU = 0;
    this.lXj = true;
    this.dkt = false;
    init(paramContext);
    AppMethodBeat.o(49795);
  }
  
  private void hx(boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(49798);
    ad.i("MicroMsg.AppBrandDesktopHalfView", "alvinluo showEmptyView show: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    LinearLayout localLinearLayout;
    if (paramBoolean)
    {
      if ((this.lXa.getVisibility() != 0) && (this.lXk != null)) {
        this.lXk.hz(true);
      }
      localLinearLayout = this.lXa;
      if (!paramBoolean) {
        break label109;
      }
    }
    for (;;)
    {
      localLinearLayout.setVisibility(i);
      AppMethodBeat.o(49798);
      return;
      if ((this.lXa.getVisibility() != 0) || (this.lXk == null)) {
        break;
      }
      this.lXk.hz(false);
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
    this.lTO = getItemPadding();
    ad.i("MicroMsg.AppBrandDesktopHalfView", "alvinluo init itemPadding: %d", new Object[] { Integer.valueOf(this.lTO) });
    paramContext = y.js(this.mContext).inflate(2131492986, this);
    this.lXa = ((LinearLayout)paramContext.findViewById(2131296698));
    this.lXb = ((LinearLayout)paramContext.findViewById(2131296697));
    this.lWY = ((AppBrandDesktopHalfItemView)paramContext.findViewById(2131296707));
    this.lWY.a(AppBrandRecentView.f.mkw);
    this.lWY.setItemPadding(this.lTO);
    this.lWY.setTitlePaddingLeft(this.lTO + com.tencent.mm.cd.a.fromDPToPix(this.mContext, 8));
    this.lWY.getRecentView().a(new a(this.lTO));
    this.lWY.setRefreshListener(new AppBrandRecentView.e()
    {
      public final void tu(int paramAnonymousInt)
      {
        int i = 0;
        AppMethodBeat.i(49770);
        ad.i("MicroMsg.AppBrandDesktopHalfView", "alvinluo refresh RecentData onDone size: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
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
            locale.tu(i);
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
    this.lWY.setOnDataChangedListener(new AppBrandRecentView.d()
    {
      public final void bst()
      {
        AppMethodBeat.i(49779);
        AppBrandDesktopHalfView.b(AppBrandDesktopHalfView.this);
        AppMethodBeat.o(49779);
      }
    });
    this.lWY.lWH = new RecyclerView.c()
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
    this.lWY.setCreateContextMenuListener(new View.OnCreateContextMenuListener()
    {
      public final void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(49787);
        paramAnonymousContextMenu.add(0, 11, 0, AppBrandDesktopHalfView.this.getContext().getResources().getString(2131755383));
        AppMethodBeat.o(49787);
      }
    });
    this.lWY.setMenuItemSelectedListener(new AppBrandRecentView.a() {});
    this.lWY.setOnItemClickListener(new AppBrandRecentView.b()
    {
      public final boolean a(View paramAnonymousView, com.tencent.mm.plugin.appbrand.widget.recentview.a paramAnonymousa, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(49789);
        AppBrandDesktopHalfView.this.setLayoutFrozen(true);
        if ((AppBrandDesktopHalfView.g(AppBrandDesktopHalfView.this) != null) && (paramAnonymousa != null) && (paramAnonymousa.lVq != null) && (!bt.isNullOrNil(paramAnonymousa.lVq.appId)))
        {
          AppBrandDesktopHalfView.d(AppBrandDesktopHalfView.this).getRecentView();
          int i = RecyclerView.bw(paramAnonymousView);
          if (i != -1)
          {
            AppBrandDesktopHalfView.h(AppBrandDesktopHalfView.this);
            AppBrandDesktopHalfView.g(AppBrandDesktopHalfView.this).bZ(paramAnonymousa.lVq.appId, i);
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
    this.lWZ = ((AppBrandDesktopHalfItemView)paramContext.findViewById(2131296706));
    this.lWZ.a(AppBrandRecentView.f.mkx);
    this.lWZ.setItemPadding(this.lTO);
    this.lWZ.setTitlePaddingLeft(this.lTO + com.tencent.mm.cd.a.fromDPToPix(this.mContext, 8));
    this.lWZ.getRecentView().a(new a(this.lTO));
    this.lWZ.setRefreshListener(new AppBrandRecentView.e()
    {
      public final void tu(int paramAnonymousInt)
      {
        int i = 0;
        AppMethodBeat.i(49790);
        ad.i("MicroMsg.AppBrandDesktopHalfView", "alvinluo refresh CollectionData onDone size: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
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
            locale.tu(i);
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
    this.lWZ.setOnDataChangedListener(new AppBrandRecentView.d()
    {
      public final void bst()
      {
        AppMethodBeat.i(49791);
        AppBrandDesktopHalfView.b(AppBrandDesktopHalfView.this);
        AppMethodBeat.o(49791);
      }
    });
    this.lWZ.lWH = new RecyclerView.c()
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
    this.lWZ.setCreateContextMenuListener(new View.OnCreateContextMenuListener()
    {
      public final void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(49771);
        if (paramAnonymousView != null)
        {
          AppBrandDesktopHalfView.c(AppBrandDesktopHalfView.this).getRecentView();
          int i = ConversationAppBrandRecentView.bw(paramAnonymousView);
          ad.d("MicroMsg.AppBrandDesktopHalfView", "alvinluo menu current pos: %d", new Object[] { Integer.valueOf(i) });
          if (i > AppBrandDesktopHalfView.l(AppBrandDesktopHalfView.this)) {
            paramAnonymousContextMenu.add(0, 12, 0, AppBrandDesktopHalfView.this.getContext().getResources().getString(2131755384));
          }
        }
        AppMethodBeat.o(49771);
      }
    });
    this.lWZ.setMenuItemSelectedListener(new AppBrandRecentView.a() {});
    this.lWZ.setOnItemClickListener(new AppBrandRecentView.b()
    {
      public final boolean a(View paramAnonymousView, com.tencent.mm.plugin.appbrand.widget.recentview.a paramAnonymousa, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(49773);
        AppBrandDesktopHalfView.this.setLayoutFrozen(true);
        if ((AppBrandDesktopHalfView.g(AppBrandDesktopHalfView.this) != null) && (paramAnonymousa != null) && (paramAnonymousa.lVq != null) && (!bt.isNullOrNil(paramAnonymousa.lVq.appId)))
        {
          AppBrandDesktopHalfView.c(AppBrandDesktopHalfView.this).getRecentView();
          int i = RecyclerView.bw(paramAnonymousView);
          if (i != -1)
          {
            AppBrandDesktopHalfView.h(AppBrandDesktopHalfView.this);
            AppBrandDesktopHalfView.g(AppBrandDesktopHalfView.this).ca(paramAnonymousa.lVq.appId, i);
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
    this.lWY.setEnableDataCache(true);
    this.lWZ.setEnableDataCache(false);
    AppMethodBeat.o(49797);
  }
  
  private static void l(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(49806);
    Object localObject = (LinearLayoutManager)paramRecyclerView.getLayoutManager();
    int i = ((LinearLayoutManager)localObject).jO();
    int j = ((LinearLayoutManager)localObject).jQ();
    ad.i("MicroMsg.AppBrandDesktopHalfView", "alvinluo checkAlphaChange firstPos: %d, lastPos: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    if (i <= j)
    {
      localObject = paramRecyclerView.cj(i);
      if ((localObject != null) && (((RecyclerView.v)localObject).arI != null))
      {
        ((RecyclerView.v)localObject).arI.setScaleX(1.0F);
        ((RecyclerView.v)localObject).arI.setScaleY(1.0F);
        if (i != j) {
          break label110;
        }
        ((RecyclerView.v)localObject).arI.setAlpha(0.3F);
      }
      for (;;)
      {
        i += 1;
        break;
        label110:
        ((RecyclerView.v)localObject).arI.setAlpha(1.0F);
      }
    }
    AppMethodBeat.o(49806);
  }
  
  private void uL(int paramInt)
  {
    AppMethodBeat.i(49799);
    Object localObject = this.lWZ.getPreviewList();
    ArrayList localArrayList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      LocalUsageInfo localLocalUsageInfo = ((com.tencent.mm.plugin.appbrand.widget.recentview.a)((Iterator)localObject).next()).lVq;
      if (localLocalUsageInfo != null)
      {
        ad.d("MicroMsg.AppBrandDesktopHalfView", "alvinluo reorderCollection info: %s, %d", new Object[] { localLocalUsageInfo.nickname, Integer.valueOf(localLocalUsageInfo.gXn) });
        localArrayList.add(localLocalUsageInfo);
      }
    }
    if (paramInt == 1) {
      this.lWZ.getRecentView().setIgnoreNotify(false);
    }
    for (;;)
    {
      ((ah)g.ab(ah.class)).g(localArrayList, paramInt);
      AppMethodBeat.o(49799);
      return;
      this.lWZ.getRecentView().setIgnoreNotify(true);
    }
  }
  
  public final void brW() {}
  
  public final void brX() {}
  
  public final void bsp()
  {
    AppMethodBeat.i(49803);
    if (this.lWZ != null) {
      this.lWZ.bsp();
    }
    if (this.lWY != null) {
      this.lWY.bsp();
    }
    AppMethodBeat.o(49803);
  }
  
  public final void bsq()
  {
    AppMethodBeat.i(49801);
    ad.d("MicroMsg.AppBrandDesktopHalfView", "alvinluo HalfView onOpen");
    this.lUP = true;
    g.ab(ah.class);
    String str = k.bmk();
    this.lXh = str;
    k.Mv(str);
    AppMethodBeat.o(49801);
  }
  
  public final void bsr()
  {
    AppMethodBeat.i(49811);
    ad.i("MicroMsg.AppBrandDesktopHalfView", "alvinluo checkReportNameDuplicated");
    com.tencent.mm.sdk.g.b.c(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(49785);
        try
        {
          long l = System.currentTimeMillis();
          com.tencent.mm.plugin.appbrand.widget.recentview.b.j(AppBrandDesktopHalfView.d(AppBrandDesktopHalfView.this).getPreviewList(), AppBrandDesktopHalfView.c(AppBrandDesktopHalfView.this).getPreviewList());
          ad.i("MicroMsg.AppBrandDesktopHalfView", "alvinluo computeNameDuplicatedResults cost: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
          AppMethodBeat.o(49785);
          return;
        }
        catch (Exception localException)
        {
          ad.printErrStackTrace("MicroMsg.AppBrandDesktopHalfView", localException, "alvinluo checkReportNameDuplicated", new Object[0]);
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
    ad.i("MicroMsg.AppBrandDesktopHalfView", "alvinluo HalfView onConfigurationChanged orientation: %d", new Object[] { Integer.valueOf(paramConfiguration.orientation) });
    int i = getItemPadding();
    if ((this.lgU != paramConfiguration.orientation) || (i != this.lTO))
    {
      this.lgU = paramConfiguration.orientation;
      com.tencent.mm.plugin.appbrand.widget.desktop.b.init(getContext());
      this.lTO = i;
      if (this.lWY != null) {
        this.lWY.setTitlePaddingLeft(this.lTO + com.tencent.mm.cd.a.fromDPToPix(this.mContext, 8));
      }
      if (this.lWZ != null) {
        this.lWZ.setTitlePaddingLeft(this.lTO + com.tencent.mm.cd.a.fromDPToPix(this.mContext, 8));
      }
      if (this.lWY != null) {
        this.lWY.e(paramConfiguration);
      }
      if (this.lWZ != null) {
        this.lWZ.e(paramConfiguration);
      }
    }
    AppMethodBeat.o(49807);
  }
  
  public int getItemPadding()
  {
    AppMethodBeat.i(49796);
    int i = d.dQ(getContext());
    AppMethodBeat.o(49796);
    return i;
  }
  
  public int getRecentAppBrandCount()
  {
    AppMethodBeat.i(49808);
    if (this.lWY != null)
    {
      int i = this.lWY.getDataCount();
      int j = this.lWY.getCustomCount();
      AppMethodBeat.o(49808);
      return i - j;
    }
    AppMethodBeat.o(49808);
    return 0;
  }
  
  public int getStarAppBrandCount()
  {
    AppMethodBeat.i(49809);
    if (this.lWZ != null)
    {
      int i = this.lWZ.getDataCount();
      int j = this.lWZ.getCustomCount();
      AppMethodBeat.o(49809);
      return i - j;
    }
    AppMethodBeat.o(49809);
    return 0;
  }
  
  public final void refresh()
  {
    AppMethodBeat.i(49813);
    ad.i("MicroMsg.AppBrandDesktopHalfView", "alvinluo refresh data");
    this.lXd = true;
    this.lWZ.lUb.refresh();
    this.lXc = true;
    this.lWY.lUb.refresh();
    AppMethodBeat.o(49813);
  }
  
  public void setCollectionRefreshListener(AppBrandRecentView.e parame)
  {
    this.lXf = parame;
  }
  
  public void setIOnLaunchUIListener(a.b paramb)
  {
    AppMethodBeat.i(49812);
    if (this.lWY != null) {
      this.lWY.setOnLaunchUIListener(paramb);
    }
    if (this.lWZ != null) {
      this.lWZ.setOnLaunchUIListener(paramb);
    }
    AppMethodBeat.o(49812);
  }
  
  public void setLayoutFrozen(boolean paramBoolean)
  {
    AppMethodBeat.i(49805);
    if ((this.lWY != null) && (this.lWY.getRecentView() != null)) {
      this.lWY.getRecentView().setLayoutFrozen(paramBoolean);
    }
    if ((this.lWZ != null) && (this.lWZ.getRecentView() != null)) {
      this.lWZ.getRecentView().setLayoutFrozen(paramBoolean);
    }
    AppMethodBeat.o(49805);
  }
  
  public void setMyRefreshListener(AppBrandRecentView.e parame)
  {
    this.lXf = parame;
  }
  
  public void setNeedScrollToFirstPageWhenResume(boolean paramBoolean)
  {
    this.lXi = paramBoolean;
  }
  
  public void setOnEmptyViewListener(a.a parama)
  {
    this.lXk = parama;
  }
  
  public void setRecentRefreshListener(AppBrandRecentView.e parame)
  {
    this.lXe = parame;
  }
  
  public void setReporter(com.tencent.mm.plugin.appbrand.widget.recentview.b paramb)
  {
    AppMethodBeat.i(49810);
    this.lWJ = paramb;
    if (this.lWY != null) {
      this.lWY.setReporter(paramb);
    }
    if (this.lWZ != null) {
      this.lWZ.setReporter(paramb);
    }
    AppMethodBeat.o(49810);
  }
  
  public void setUsageRefreshListener(AppBrandRecentView.e parame)
  {
    this.lXe = parame;
  }
  
  public final void uF(int paramInt)
  {
    AppMethodBeat.i(49800);
    ad.i("MicroMsg.AppBrandDesktopHalfView", "alvinluo onCloseHeader");
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
  
  public final void uG(int paramInt)
  {
    AppMethodBeat.i(49804);
    uF(paramInt);
    AppMethodBeat.o(49804);
  }
  
  public final void uM(int paramInt)
  {
    AppMethodBeat.i(49802);
    ad.i("MicroMsg.AppBrandDesktopHalfView", "alvinluo HalfView onClose type: %d, isHeaderOpen: %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.lUP) });
    if (this.lUP)
    {
      this.lUP = false;
      uL(1);
    }
    AppMethodBeat.o(49802);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.half.AppBrandDesktopHalfView
 * JD-Core Version:    0.7.0.1
 */