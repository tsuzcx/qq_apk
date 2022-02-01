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
import com.tencent.mm.ui.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AppBrandDesktopHalfView
  extends LinearLayout
  implements com.tencent.mm.plugin.appbrand.widget.header.a.a, c.a
{
  boolean dtm;
  private int gOl;
  private Context mContext;
  private int mWv;
  private boolean mXv;
  private AppBrandDesktopHalfItemView mZI;
  private AppBrandDesktopHalfItemView mZJ;
  private LinearLayout mZK;
  private LinearLayout mZL;
  private boolean mZM;
  private boolean mZN;
  private AppBrandRecentView.e mZO;
  private AppBrandRecentView.e mZP;
  private c mZQ;
  private String mZR;
  private boolean mZS;
  private boolean mZT;
  private a.a mZU;
  private com.tencent.mm.plugin.appbrand.widget.recentview.b mZt;
  private int startIndex;
  
  public AppBrandDesktopHalfView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(49793);
    this.mZM = false;
    this.mZN = false;
    this.mWv = 0;
    this.mZO = null;
    this.mZP = null;
    com.tencent.mm.plugin.appbrand.widget.desktop.b.bCI();
    this.startIndex = 1;
    this.mZQ = null;
    this.mZt = null;
    this.mZR = null;
    this.mZS = true;
    this.mXv = false;
    this.gOl = 0;
    this.mZT = true;
    this.dtm = false;
    init(paramContext);
    AppMethodBeat.o(49793);
  }
  
  public AppBrandDesktopHalfView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(49794);
    this.mZM = false;
    this.mZN = false;
    this.mWv = 0;
    this.mZO = null;
    this.mZP = null;
    com.tencent.mm.plugin.appbrand.widget.desktop.b.bCI();
    this.startIndex = 1;
    this.mZQ = null;
    this.mZt = null;
    this.mZR = null;
    this.mZS = true;
    this.mXv = false;
    this.gOl = 0;
    this.mZT = true;
    this.dtm = false;
    init(paramContext);
    AppMethodBeat.o(49794);
  }
  
  public AppBrandDesktopHalfView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(49795);
    this.mZM = false;
    this.mZN = false;
    this.mWv = 0;
    this.mZO = null;
    this.mZP = null;
    com.tencent.mm.plugin.appbrand.widget.desktop.b.bCI();
    this.startIndex = 1;
    this.mZQ = null;
    this.mZt = null;
    this.mZR = null;
    this.mZS = true;
    this.mXv = false;
    this.gOl = 0;
    this.mZT = true;
    this.dtm = false;
    init(paramContext);
    AppMethodBeat.o(49795);
  }
  
  private void jdMethod_if(boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(49798);
    ad.i("MicroMsg.AppBrandDesktopHalfView", "alvinluo showEmptyView show: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    LinearLayout localLinearLayout;
    if (paramBoolean)
    {
      if ((this.mZK.getVisibility() != 0) && (this.mZU != null)) {
        this.mZU.ig(true);
      }
      localLinearLayout = this.mZK;
      if (!paramBoolean) {
        break label109;
      }
    }
    for (;;)
    {
      localLinearLayout.setVisibility(i);
      AppMethodBeat.o(49798);
      return;
      if ((this.mZK.getVisibility() != 0) || (this.mZU == null)) {
        break;
      }
      this.mZU.ig(false);
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
    this.mWv = getItemPadding();
    ad.i("MicroMsg.AppBrandDesktopHalfView", "alvinluo init itemPadding: %d", new Object[] { Integer.valueOf(this.mWv) });
    paramContext = z.jO(this.mContext).inflate(2131492986, this);
    this.mZK = ((LinearLayout)paramContext.findViewById(2131296698));
    this.mZL = ((LinearLayout)paramContext.findViewById(2131296697));
    this.mZI = ((AppBrandDesktopHalfItemView)paramContext.findViewById(2131296707));
    this.mZI.a(AppBrandRecentView.f.nmT);
    this.mZI.setItemPadding(this.mWv);
    this.mZI.setTitlePaddingLeft(this.mWv + com.tencent.mm.cc.a.fromDPToPix(this.mContext, 8));
    this.mZI.getRecentView().a(new a(this.mWv));
    this.mZI.setRefreshListener(new AppBrandRecentView.e()
    {
      public final void uP(int paramAnonymousInt)
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
            locale.uP(i);
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
    this.mZI.setOnDataChangedListener(new AppBrandRecentView.d()
    {
      public final void bDx()
      {
        AppMethodBeat.i(49779);
        AppBrandDesktopHalfView.b(AppBrandDesktopHalfView.this);
        AppMethodBeat.o(49779);
      }
    });
    this.mZI.mZr = new RecyclerView.c()
    {
      public final void av(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(49786);
        super.av(paramAnonymousInt1, paramAnonymousInt2);
        if (AppBrandDesktopHalfView.d(AppBrandDesktopHalfView.this).getDataCount() <= AppBrandDesktopHalfView.d(AppBrandDesktopHalfView.this).getCustomCount()) {
          AppBrandDesktopHalfView.d(AppBrandDesktopHalfView.this).setVisibility(8);
        }
        AppMethodBeat.o(49786);
      }
    };
    this.mZI.setCreateContextMenuListener(new View.OnCreateContextMenuListener()
    {
      public final void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(49787);
        paramAnonymousContextMenu.add(0, 11, 0, AppBrandDesktopHalfView.this.getContext().getResources().getString(2131755383));
        AppMethodBeat.o(49787);
      }
    });
    this.mZI.setMenuItemSelectedListener(new AppBrandRecentView.a() {});
    this.mZI.setOnItemClickListener(new AppBrandRecentView.b()
    {
      public final boolean a(View paramAnonymousView, com.tencent.mm.plugin.appbrand.widget.recentview.a paramAnonymousa, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(49789);
        AppBrandDesktopHalfView.this.setLayoutFrozen(true);
        if ((AppBrandDesktopHalfView.g(AppBrandDesktopHalfView.this) != null) && (paramAnonymousa != null) && (paramAnonymousa.mXW != null) && (!bt.isNullOrNil(paramAnonymousa.mXW.appId)))
        {
          AppBrandDesktopHalfView.d(AppBrandDesktopHalfView.this).getRecentView();
          int i = RecyclerView.bw(paramAnonymousView);
          if (i != -1)
          {
            AppBrandDesktopHalfView.h(AppBrandDesktopHalfView.this);
            AppBrandDesktopHalfView.g(AppBrandDesktopHalfView.this).ch(paramAnonymousa.mXW.appId, i);
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
    this.mZJ = ((AppBrandDesktopHalfItemView)paramContext.findViewById(2131296706));
    this.mZJ.a(AppBrandRecentView.f.nmU);
    this.mZJ.setItemPadding(this.mWv);
    this.mZJ.setTitlePaddingLeft(this.mWv + com.tencent.mm.cc.a.fromDPToPix(this.mContext, 8));
    this.mZJ.getRecentView().a(new a(this.mWv));
    this.mZJ.setRefreshListener(new AppBrandRecentView.e()
    {
      public final void uP(int paramAnonymousInt)
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
            locale.uP(i);
          }
          i = AppBrandDesktopHalfView.c(AppBrandDesktopHalfView.this).getRecentView().getAdapter().getItemCount();
          AppBrandDesktopHalfView.c(AppBrandDesktopHalfView.this).getRecentView().getAdapter().ap(paramAnonymousInt - 1, i - paramAnonymousInt);
          AppMethodBeat.o(49790);
          return;
          AppBrandDesktopHalfView.e(AppBrandDesktopHalfView.this).setVisibility(0);
          AppBrandDesktopHalfView.c(AppBrandDesktopHalfView.this).setVisibility(0);
        }
      }
    });
    this.mZJ.setOnDataChangedListener(new AppBrandRecentView.d()
    {
      public final void bDx()
      {
        AppMethodBeat.i(49791);
        AppBrandDesktopHalfView.b(AppBrandDesktopHalfView.this);
        AppMethodBeat.o(49791);
      }
    });
    this.mZJ.mZr = new RecyclerView.c()
    {
      public final void av(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(49792);
        super.av(paramAnonymousInt1, paramAnonymousInt2);
        if (AppBrandDesktopHalfView.c(AppBrandDesktopHalfView.this).getDataCount() <= AppBrandDesktopHalfView.c(AppBrandDesktopHalfView.this).getCustomCount()) {
          AppBrandDesktopHalfView.c(AppBrandDesktopHalfView.this).setVisibility(8);
        }
        AppMethodBeat.o(49792);
      }
    };
    this.mZJ.setCreateContextMenuListener(new View.OnCreateContextMenuListener()
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
    this.mZJ.setMenuItemSelectedListener(new AppBrandRecentView.a() {});
    this.mZJ.setOnItemClickListener(new AppBrandRecentView.b()
    {
      public final boolean a(View paramAnonymousView, com.tencent.mm.plugin.appbrand.widget.recentview.a paramAnonymousa, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(49773);
        AppBrandDesktopHalfView.this.setLayoutFrozen(true);
        if ((AppBrandDesktopHalfView.g(AppBrandDesktopHalfView.this) != null) && (paramAnonymousa != null) && (paramAnonymousa.mXW != null) && (!bt.isNullOrNil(paramAnonymousa.mXW.appId)))
        {
          AppBrandDesktopHalfView.c(AppBrandDesktopHalfView.this).getRecentView();
          int i = RecyclerView.bw(paramAnonymousView);
          if (i != -1)
          {
            AppBrandDesktopHalfView.h(AppBrandDesktopHalfView.this);
            AppBrandDesktopHalfView.g(AppBrandDesktopHalfView.this).ci(paramAnonymousa.mXW.appId, i);
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
    this.mZI.setEnableDataCache(true);
    this.mZJ.setEnableDataCache(false);
    AppMethodBeat.o(49797);
  }
  
  private static void l(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(49806);
    Object localObject = (LinearLayoutManager)paramRecyclerView.getLayoutManager();
    int i = ((LinearLayoutManager)localObject).km();
    int j = ((LinearLayoutManager)localObject).ko();
    ad.i("MicroMsg.AppBrandDesktopHalfView", "alvinluo checkAlphaChange firstPos: %d, lastPos: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    if (i <= j)
    {
      localObject = paramRecyclerView.ci(i);
      if ((localObject != null) && (((RecyclerView.w)localObject).auu != null))
      {
        ((RecyclerView.w)localObject).auu.setScaleX(1.0F);
        ((RecyclerView.w)localObject).auu.setScaleY(1.0F);
        if (i != j) {
          break label110;
        }
        ((RecyclerView.w)localObject).auu.setAlpha(0.3F);
      }
      for (;;)
      {
        i += 1;
        break;
        label110:
        ((RecyclerView.w)localObject).auu.setAlpha(1.0F);
      }
    }
    AppMethodBeat.o(49806);
  }
  
  private void wi(int paramInt)
  {
    AppMethodBeat.i(49799);
    Object localObject = this.mZJ.getPreviewList();
    ArrayList localArrayList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      LocalUsageInfo localLocalUsageInfo = ((com.tencent.mm.plugin.appbrand.widget.recentview.a)((Iterator)localObject).next()).mXW;
      if (localLocalUsageInfo != null)
      {
        ad.d("MicroMsg.AppBrandDesktopHalfView", "alvinluo reorderCollection info: %s, %d", new Object[] { localLocalUsageInfo.nickname, Integer.valueOf(localLocalUsageInfo.hQh) });
        localArrayList.add(localLocalUsageInfo);
      }
    }
    if (paramInt == 1) {
      this.mZJ.getRecentView().setIgnoreNotify(false);
    }
    for (;;)
    {
      ((ah)g.ab(ah.class)).g(localArrayList, paramInt);
      AppMethodBeat.o(49799);
      return;
      this.mZJ.getRecentView().setIgnoreNotify(true);
    }
  }
  
  public final void bCZ() {}
  
  public final void bDa() {}
  
  public final void bDt()
  {
    AppMethodBeat.i(49803);
    if (this.mZJ != null) {
      this.mZJ.bDt();
    }
    if (this.mZI != null) {
      this.mZI.bDt();
    }
    AppMethodBeat.o(49803);
  }
  
  public final void bDu()
  {
    AppMethodBeat.i(49801);
    ad.d("MicroMsg.AppBrandDesktopHalfView", "alvinluo HalfView onOpen");
    this.mXv = true;
    g.ab(ah.class);
    String str = k.bxl();
    this.mZR = str;
    k.Uk(str);
    AppMethodBeat.o(49801);
  }
  
  public final void bDv()
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
    if ((this.gOl != paramConfiguration.orientation) || (i != this.mWv))
    {
      this.gOl = paramConfiguration.orientation;
      com.tencent.mm.plugin.appbrand.widget.desktop.b.init(getContext());
      this.mWv = i;
      if (this.mZI != null) {
        this.mZI.setTitlePaddingLeft(this.mWv + com.tencent.mm.cc.a.fromDPToPix(this.mContext, 8));
      }
      if (this.mZJ != null) {
        this.mZJ.setTitlePaddingLeft(this.mWv + com.tencent.mm.cc.a.fromDPToPix(this.mContext, 8));
      }
      if (this.mZI != null) {
        this.mZI.e(paramConfiguration);
      }
      if (this.mZJ != null) {
        this.mZJ.e(paramConfiguration);
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
    if (this.mZI != null)
    {
      int i = this.mZI.getDataCount();
      int j = this.mZI.getCustomCount();
      AppMethodBeat.o(49808);
      return i - j;
    }
    AppMethodBeat.o(49808);
    return 0;
  }
  
  public int getStarAppBrandCount()
  {
    AppMethodBeat.i(49809);
    if (this.mZJ != null)
    {
      int i = this.mZJ.getDataCount();
      int j = this.mZJ.getCustomCount();
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
    this.mZN = true;
    this.mZJ.mWI.refresh();
    this.mZM = true;
    this.mZI.mWI.refresh();
    AppMethodBeat.o(49813);
  }
  
  public void setCollectionRefreshListener(AppBrandRecentView.e parame)
  {
    this.mZP = parame;
  }
  
  public void setIOnLaunchUIListener(a.b paramb)
  {
    AppMethodBeat.i(49812);
    if (this.mZI != null) {
      this.mZI.setOnLaunchUIListener(paramb);
    }
    if (this.mZJ != null) {
      this.mZJ.setOnLaunchUIListener(paramb);
    }
    AppMethodBeat.o(49812);
  }
  
  public void setLayoutFrozen(boolean paramBoolean)
  {
    AppMethodBeat.i(49805);
    if ((this.mZI != null) && (this.mZI.getRecentView() != null)) {
      this.mZI.getRecentView().setLayoutFrozen(paramBoolean);
    }
    if ((this.mZJ != null) && (this.mZJ.getRecentView() != null)) {
      this.mZJ.getRecentView().setLayoutFrozen(paramBoolean);
    }
    AppMethodBeat.o(49805);
  }
  
  public void setMyRefreshListener(AppBrandRecentView.e parame)
  {
    this.mZP = parame;
  }
  
  public void setNeedScrollToFirstPageWhenResume(boolean paramBoolean)
  {
    this.mZS = paramBoolean;
  }
  
  public void setOnEmptyViewListener(a.a parama)
  {
    this.mZU = parama;
  }
  
  public void setRecentRefreshListener(AppBrandRecentView.e parame)
  {
    this.mZO = parame;
  }
  
  public void setReporter(com.tencent.mm.plugin.appbrand.widget.recentview.b paramb)
  {
    AppMethodBeat.i(49810);
    this.mZt = paramb;
    if (this.mZI != null) {
      this.mZI.setReporter(paramb);
    }
    if (this.mZJ != null) {
      this.mZJ.setReporter(paramb);
    }
    AppMethodBeat.o(49810);
  }
  
  public void setUsageRefreshListener(AppBrandRecentView.e parame)
  {
    this.mZO = parame;
  }
  
  public final void wc(int paramInt)
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
  
  public final void wd(int paramInt)
  {
    AppMethodBeat.i(49804);
    wc(paramInt);
    AppMethodBeat.o(49804);
  }
  
  public final void wj(int paramInt)
  {
    AppMethodBeat.i(49802);
    ad.i("MicroMsg.AppBrandDesktopHalfView", "alvinluo HalfView onClose type: %d, isHeaderOpen: %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.mXv) });
    if (this.mXv)
    {
      this.mXv = false;
      wi(1);
    }
    AppMethodBeat.o(49802);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.half.AppBrandDesktopHalfView
 * JD-Core Version:    0.7.0.1
 */