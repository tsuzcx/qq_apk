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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AppBrandDesktopHalfView
  extends LinearLayout
  implements com.tencent.mm.plugin.appbrand.widget.header.a.a, c.a
{
  boolean dus;
  private int gQT;
  private Context mContext;
  private int nbB;
  private boolean ncC;
  private com.tencent.mm.plugin.appbrand.widget.recentview.b neB;
  private AppBrandDesktopHalfItemView neQ;
  private AppBrandDesktopHalfItemView neR;
  private LinearLayout neS;
  private LinearLayout neT;
  private boolean neU;
  private boolean neV;
  private AppBrandRecentView.e neW;
  private AppBrandRecentView.e neX;
  private c neY;
  private String neZ;
  private boolean nfa;
  private boolean nfb;
  private a.a nfc;
  private int startIndex;
  
  public AppBrandDesktopHalfView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(49793);
    this.neU = false;
    this.neV = false;
    this.nbB = 0;
    this.neW = null;
    this.neX = null;
    com.tencent.mm.plugin.appbrand.widget.desktop.b.bDA();
    this.startIndex = 1;
    this.neY = null;
    this.neB = null;
    this.neZ = null;
    this.nfa = true;
    this.ncC = false;
    this.gQT = 0;
    this.nfb = true;
    this.dus = false;
    init(paramContext);
    AppMethodBeat.o(49793);
  }
  
  public AppBrandDesktopHalfView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(49794);
    this.neU = false;
    this.neV = false;
    this.nbB = 0;
    this.neW = null;
    this.neX = null;
    com.tencent.mm.plugin.appbrand.widget.desktop.b.bDA();
    this.startIndex = 1;
    this.neY = null;
    this.neB = null;
    this.neZ = null;
    this.nfa = true;
    this.ncC = false;
    this.gQT = 0;
    this.nfb = true;
    this.dus = false;
    init(paramContext);
    AppMethodBeat.o(49794);
  }
  
  public AppBrandDesktopHalfView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(49795);
    this.neU = false;
    this.neV = false;
    this.nbB = 0;
    this.neW = null;
    this.neX = null;
    com.tencent.mm.plugin.appbrand.widget.desktop.b.bDA();
    this.startIndex = 1;
    this.neY = null;
    this.neB = null;
    this.neZ = null;
    this.nfa = true;
    this.ncC = false;
    this.gQT = 0;
    this.nfb = true;
    this.dus = false;
    init(paramContext);
    AppMethodBeat.o(49795);
  }
  
  private void id(boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(49798);
    ae.i("MicroMsg.AppBrandDesktopHalfView", "alvinluo showEmptyView show: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    LinearLayout localLinearLayout;
    if (paramBoolean)
    {
      if ((this.neS.getVisibility() != 0) && (this.nfc != null)) {
        this.nfc.ie(true);
      }
      localLinearLayout = this.neS;
      if (!paramBoolean) {
        break label109;
      }
    }
    for (;;)
    {
      localLinearLayout.setVisibility(i);
      AppMethodBeat.o(49798);
      return;
      if ((this.neS.getVisibility() != 0) || (this.nfc == null)) {
        break;
      }
      this.nfc.ie(false);
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
    this.nbB = getItemPadding();
    ae.i("MicroMsg.AppBrandDesktopHalfView", "alvinluo init itemPadding: %d", new Object[] { Integer.valueOf(this.nbB) });
    paramContext = z.jV(this.mContext).inflate(2131492986, this);
    this.neS = ((LinearLayout)paramContext.findViewById(2131296698));
    this.neT = ((LinearLayout)paramContext.findViewById(2131296697));
    this.neQ = ((AppBrandDesktopHalfItemView)paramContext.findViewById(2131296707));
    this.neQ.a(AppBrandRecentView.f.nsd);
    this.neQ.setItemPadding(this.nbB);
    this.neQ.setTitlePaddingLeft(this.nbB + com.tencent.mm.cb.a.fromDPToPix(this.mContext, 8));
    this.neQ.getRecentView().a(new a(this.nbB));
    this.neQ.setRefreshListener(new AppBrandRecentView.e()
    {
      public final void uT(int paramAnonymousInt)
      {
        int i = 0;
        AppMethodBeat.i(49770);
        ae.i("MicroMsg.AppBrandDesktopHalfView", "alvinluo refresh RecentData onDone size: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
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
            locale.uT(i);
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
    this.neQ.setOnDataChangedListener(new AppBrandRecentView.d()
    {
      public final void bEp()
      {
        AppMethodBeat.i(49779);
        AppBrandDesktopHalfView.b(AppBrandDesktopHalfView.this);
        AppMethodBeat.o(49779);
      }
    });
    this.neQ.nez = new RecyclerView.c()
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
    this.neQ.setCreateContextMenuListener(new View.OnCreateContextMenuListener()
    {
      public final void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(49787);
        paramAnonymousContextMenu.add(0, 11, 0, AppBrandDesktopHalfView.this.getContext().getResources().getString(2131755383));
        AppMethodBeat.o(49787);
      }
    });
    this.neQ.setMenuItemSelectedListener(new AppBrandRecentView.a() {});
    this.neQ.setOnItemClickListener(new AppBrandRecentView.b()
    {
      public final boolean a(View paramAnonymousView, com.tencent.mm.plugin.appbrand.widget.recentview.a paramAnonymousa, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(49789);
        AppBrandDesktopHalfView.this.setLayoutFrozen(true);
        if ((AppBrandDesktopHalfView.g(AppBrandDesktopHalfView.this) != null) && (paramAnonymousa != null) && (paramAnonymousa.ndd != null) && (!bu.isNullOrNil(paramAnonymousa.ndd.appId)))
        {
          AppBrandDesktopHalfView.d(AppBrandDesktopHalfView.this).getRecentView();
          int i = RecyclerView.bw(paramAnonymousView);
          if (i != -1)
          {
            AppBrandDesktopHalfView.h(AppBrandDesktopHalfView.this);
            AppBrandDesktopHalfView.g(AppBrandDesktopHalfView.this).cl(paramAnonymousa.ndd.appId, i);
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
    this.neR = ((AppBrandDesktopHalfItemView)paramContext.findViewById(2131296706));
    this.neR.a(AppBrandRecentView.f.nse);
    this.neR.setItemPadding(this.nbB);
    this.neR.setTitlePaddingLeft(this.nbB + com.tencent.mm.cb.a.fromDPToPix(this.mContext, 8));
    this.neR.getRecentView().a(new a(this.nbB));
    this.neR.setRefreshListener(new AppBrandRecentView.e()
    {
      public final void uT(int paramAnonymousInt)
      {
        int i = 0;
        AppMethodBeat.i(49790);
        ae.i("MicroMsg.AppBrandDesktopHalfView", "alvinluo refresh CollectionData onDone size: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
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
            locale.uT(i);
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
    this.neR.setOnDataChangedListener(new AppBrandRecentView.d()
    {
      public final void bEp()
      {
        AppMethodBeat.i(49791);
        AppBrandDesktopHalfView.b(AppBrandDesktopHalfView.this);
        AppMethodBeat.o(49791);
      }
    });
    this.neR.nez = new RecyclerView.c()
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
    this.neR.setCreateContextMenuListener(new View.OnCreateContextMenuListener()
    {
      public final void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(49771);
        if (paramAnonymousView != null)
        {
          AppBrandDesktopHalfView.c(AppBrandDesktopHalfView.this).getRecentView();
          int i = ConversationAppBrandRecentView.bw(paramAnonymousView);
          ae.d("MicroMsg.AppBrandDesktopHalfView", "alvinluo menu current pos: %d", new Object[] { Integer.valueOf(i) });
          if (i > AppBrandDesktopHalfView.l(AppBrandDesktopHalfView.this)) {
            paramAnonymousContextMenu.add(0, 12, 0, AppBrandDesktopHalfView.this.getContext().getResources().getString(2131755384));
          }
        }
        AppMethodBeat.o(49771);
      }
    });
    this.neR.setMenuItemSelectedListener(new AppBrandRecentView.a() {});
    this.neR.setOnItemClickListener(new AppBrandRecentView.b()
    {
      public final boolean a(View paramAnonymousView, com.tencent.mm.plugin.appbrand.widget.recentview.a paramAnonymousa, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(49773);
        AppBrandDesktopHalfView.this.setLayoutFrozen(true);
        if ((AppBrandDesktopHalfView.g(AppBrandDesktopHalfView.this) != null) && (paramAnonymousa != null) && (paramAnonymousa.ndd != null) && (!bu.isNullOrNil(paramAnonymousa.ndd.appId)))
        {
          AppBrandDesktopHalfView.c(AppBrandDesktopHalfView.this).getRecentView();
          int i = RecyclerView.bw(paramAnonymousView);
          if (i != -1)
          {
            AppBrandDesktopHalfView.h(AppBrandDesktopHalfView.this);
            AppBrandDesktopHalfView.g(AppBrandDesktopHalfView.this).cm(paramAnonymousa.ndd.appId, i);
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
    this.neQ.setEnableDataCache(true);
    this.neR.setEnableDataCache(false);
    AppMethodBeat.o(49797);
  }
  
  private static void l(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(49806);
    Object localObject = (LinearLayoutManager)paramRecyclerView.getLayoutManager();
    int i = ((LinearLayoutManager)localObject).km();
    int j = ((LinearLayoutManager)localObject).ko();
    ae.i("MicroMsg.AppBrandDesktopHalfView", "alvinluo checkAlphaChange firstPos: %d, lastPos: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
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
  
  private void wn(int paramInt)
  {
    AppMethodBeat.i(49799);
    Object localObject = this.neR.getPreviewList();
    ArrayList localArrayList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      LocalUsageInfo localLocalUsageInfo = ((com.tencent.mm.plugin.appbrand.widget.recentview.a)((Iterator)localObject).next()).ndd;
      if (localLocalUsageInfo != null)
      {
        ae.d("MicroMsg.AppBrandDesktopHalfView", "alvinluo reorderCollection info: %s, %d", new Object[] { localLocalUsageInfo.nickname, Integer.valueOf(localLocalUsageInfo.hSZ) });
        localArrayList.add(localLocalUsageInfo);
      }
    }
    if (paramInt == 1) {
      this.neR.getRecentView().setIgnoreNotify(false);
    }
    for (;;)
    {
      ((ah)g.ab(ah.class)).g(localArrayList, paramInt);
      AppMethodBeat.o(49799);
      return;
      this.neR.getRecentView().setIgnoreNotify(true);
    }
  }
  
  public final void bDR() {}
  
  public final void bDS() {}
  
  public final void bEl()
  {
    AppMethodBeat.i(49803);
    if (this.neR != null) {
      this.neR.bEl();
    }
    if (this.neQ != null) {
      this.neQ.bEl();
    }
    AppMethodBeat.o(49803);
  }
  
  public final void bEm()
  {
    AppMethodBeat.i(49801);
    ae.d("MicroMsg.AppBrandDesktopHalfView", "alvinluo HalfView onOpen");
    this.ncC = true;
    g.ab(ah.class);
    String str = k.bye();
    this.neZ = str;
    k.UV(str);
    AppMethodBeat.o(49801);
  }
  
  public final void bEn()
  {
    AppMethodBeat.i(49811);
    ae.i("MicroMsg.AppBrandDesktopHalfView", "alvinluo checkReportNameDuplicated");
    com.tencent.mm.sdk.g.b.c(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(49785);
        try
        {
          long l = System.currentTimeMillis();
          com.tencent.mm.plugin.appbrand.widget.recentview.b.j(AppBrandDesktopHalfView.d(AppBrandDesktopHalfView.this).getPreviewList(), AppBrandDesktopHalfView.c(AppBrandDesktopHalfView.this).getPreviewList());
          ae.i("MicroMsg.AppBrandDesktopHalfView", "alvinluo computeNameDuplicatedResults cost: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
          AppMethodBeat.o(49785);
          return;
        }
        catch (Exception localException)
        {
          ae.printErrStackTrace("MicroMsg.AppBrandDesktopHalfView", localException, "alvinluo checkReportNameDuplicated", new Object[0]);
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
    ae.i("MicroMsg.AppBrandDesktopHalfView", "alvinluo HalfView onConfigurationChanged orientation: %d", new Object[] { Integer.valueOf(paramConfiguration.orientation) });
    int i = getItemPadding();
    if ((this.gQT != paramConfiguration.orientation) || (i != this.nbB))
    {
      this.gQT = paramConfiguration.orientation;
      com.tencent.mm.plugin.appbrand.widget.desktop.b.init(getContext());
      this.nbB = i;
      if (this.neQ != null) {
        this.neQ.setTitlePaddingLeft(this.nbB + com.tencent.mm.cb.a.fromDPToPix(this.mContext, 8));
      }
      if (this.neR != null) {
        this.neR.setTitlePaddingLeft(this.nbB + com.tencent.mm.cb.a.fromDPToPix(this.mContext, 8));
      }
      if (this.neQ != null) {
        this.neQ.e(paramConfiguration);
      }
      if (this.neR != null) {
        this.neR.e(paramConfiguration);
      }
    }
    AppMethodBeat.o(49807);
  }
  
  public int getItemPadding()
  {
    AppMethodBeat.i(49796);
    int i = d.ec(getContext());
    AppMethodBeat.o(49796);
    return i;
  }
  
  public int getRecentAppBrandCount()
  {
    AppMethodBeat.i(49808);
    if (this.neQ != null)
    {
      int i = this.neQ.getDataCount();
      int j = this.neQ.getCustomCount();
      AppMethodBeat.o(49808);
      return i - j;
    }
    AppMethodBeat.o(49808);
    return 0;
  }
  
  public int getStarAppBrandCount()
  {
    AppMethodBeat.i(49809);
    if (this.neR != null)
    {
      int i = this.neR.getDataCount();
      int j = this.neR.getCustomCount();
      AppMethodBeat.o(49809);
      return i - j;
    }
    AppMethodBeat.o(49809);
    return 0;
  }
  
  public final void refresh()
  {
    AppMethodBeat.i(49813);
    ae.i("MicroMsg.AppBrandDesktopHalfView", "alvinluo refresh data");
    this.neV = true;
    this.neR.nbO.refresh();
    this.neU = true;
    this.neQ.nbO.refresh();
    AppMethodBeat.o(49813);
  }
  
  public void setCollectionRefreshListener(AppBrandRecentView.e parame)
  {
    this.neX = parame;
  }
  
  public void setIOnLaunchUIListener(a.b paramb)
  {
    AppMethodBeat.i(49812);
    if (this.neQ != null) {
      this.neQ.setOnLaunchUIListener(paramb);
    }
    if (this.neR != null) {
      this.neR.setOnLaunchUIListener(paramb);
    }
    AppMethodBeat.o(49812);
  }
  
  public void setLayoutFrozen(boolean paramBoolean)
  {
    AppMethodBeat.i(49805);
    if ((this.neQ != null) && (this.neQ.getRecentView() != null)) {
      this.neQ.getRecentView().setLayoutFrozen(paramBoolean);
    }
    if ((this.neR != null) && (this.neR.getRecentView() != null)) {
      this.neR.getRecentView().setLayoutFrozen(paramBoolean);
    }
    AppMethodBeat.o(49805);
  }
  
  public void setMyRefreshListener(AppBrandRecentView.e parame)
  {
    this.neX = parame;
  }
  
  public void setNeedScrollToFirstPageWhenResume(boolean paramBoolean)
  {
    this.nfa = paramBoolean;
  }
  
  public void setOnEmptyViewListener(a.a parama)
  {
    this.nfc = parama;
  }
  
  public void setRecentRefreshListener(AppBrandRecentView.e parame)
  {
    this.neW = parame;
  }
  
  public void setReporter(com.tencent.mm.plugin.appbrand.widget.recentview.b paramb)
  {
    AppMethodBeat.i(49810);
    this.neB = paramb;
    if (this.neQ != null) {
      this.neQ.setReporter(paramb);
    }
    if (this.neR != null) {
      this.neR.setReporter(paramb);
    }
    AppMethodBeat.o(49810);
  }
  
  public void setUsageRefreshListener(AppBrandRecentView.e parame)
  {
    this.neW = parame;
  }
  
  public final void wh(int paramInt)
  {
    AppMethodBeat.i(49800);
    ae.i("MicroMsg.AppBrandDesktopHalfView", "alvinluo onCloseHeader");
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
  
  public final void wi(int paramInt)
  {
    AppMethodBeat.i(49804);
    wh(paramInt);
    AppMethodBeat.o(49804);
  }
  
  public final void wo(int paramInt)
  {
    AppMethodBeat.i(49802);
    ae.i("MicroMsg.AppBrandDesktopHalfView", "alvinluo HalfView onClose type: %d, isHeaderOpen: %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.ncC) });
    if (this.ncC)
    {
      this.ncC = false;
      wn(1);
    }
    AppMethodBeat.o(49802);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.half.AppBrandDesktopHalfView
 * JD-Core Version:    0.7.0.1
 */