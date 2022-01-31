package com.tencent.mm.plugin.appbrand.widget.desktop.half;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.widget.LinearLayout;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.appusage.af;
import com.tencent.mm.plugin.appbrand.widget.desktop.c;
import com.tencent.mm.plugin.appbrand.widget.header.a.a.b;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.a;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.b;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.e;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.f;
import com.tencent.mm.plugin.appbrand.widget.recentview.ConversationAppBrandRecentView;
import com.tencent.mm.plugin.appbrand.widget.recentview.e.b;
import com.tencent.mm.plugin.appbrand.y.g;
import com.tencent.mm.plugin.appbrand.y.h;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AppBrandDesktopHalfView
  extends LinearLayout
  implements com.tencent.mm.plugin.appbrand.widget.header.a.a, com.tencent.mm.plugin.appbrand.widget.header.a.a
{
  boolean bNW;
  private AppBrandDesktopHalfItemView hrC;
  private AppBrandDesktopHalfItemView hrD;
  private LinearLayout hrE;
  private LinearLayout hrF;
  private boolean hrG = false;
  private boolean hrH = false;
  private AppBrandRecentView.e hrI = null;
  private AppBrandRecentView.e hrJ = null;
  private int hrK;
  private c hrL;
  private String hrM;
  private boolean hrN;
  private boolean hrO;
  private boolean hrP;
  private com.tencent.mm.plugin.appbrand.widget.header.a.a.a hrQ;
  private int hrb = 0;
  private com.tencent.mm.plugin.appbrand.widget.recentview.b hrl;
  private int hrw;
  private Context mContext;
  
  public AppBrandDesktopHalfView(Context paramContext)
  {
    super(paramContext);
    com.tencent.mm.plugin.appbrand.widget.desktop.b.ark();
    this.hrK = 1;
    this.hrL = null;
    this.hrl = null;
    this.hrM = null;
    this.hrN = true;
    this.hrO = false;
    this.hrw = 0;
    this.hrP = true;
    this.bNW = false;
    init(paramContext);
  }
  
  public AppBrandDesktopHalfView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    com.tencent.mm.plugin.appbrand.widget.desktop.b.ark();
    this.hrK = 1;
    this.hrL = null;
    this.hrl = null;
    this.hrM = null;
    this.hrN = true;
    this.hrO = false;
    this.hrw = 0;
    this.hrP = true;
    this.bNW = false;
    init(paramContext);
  }
  
  public AppBrandDesktopHalfView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    com.tencent.mm.plugin.appbrand.widget.desktop.b.ark();
    this.hrK = 1;
    this.hrL = null;
    this.hrl = null;
    this.hrM = null;
    this.hrN = true;
    this.hrO = false;
    this.hrw = 0;
    this.hrP = true;
    this.bNW = false;
    init(paramContext);
  }
  
  private void dR(boolean paramBoolean)
  {
    int i = 0;
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.AppBrandDesktopHalfView", "alvinluo showEmptyView show: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    LinearLayout localLinearLayout;
    if (paramBoolean)
    {
      if ((this.hrE.getVisibility() != 0) && (this.hrQ != null)) {
        this.hrQ.dS(true);
      }
      localLinearLayout = this.hrE;
      if (!paramBoolean) {
        break label97;
      }
    }
    for (;;)
    {
      localLinearLayout.setVisibility(i);
      return;
      if ((this.hrE.getVisibility() != 0) || (this.hrQ == null)) {
        break;
      }
      this.hrQ.dS(false);
      break;
      label97:
      i = 4;
    }
  }
  
  private static void h(RecyclerView paramRecyclerView)
  {
    Object localObject = (LinearLayoutManager)paramRecyclerView.getLayoutManager();
    int i = ((LinearLayoutManager)localObject).gY();
    int j = ((LinearLayoutManager)localObject).ha();
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.AppBrandDesktopHalfView", "alvinluo checkAlphaChange firstPos: %d, lastPos: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    if (i <= j)
    {
      localObject = paramRecyclerView.bK(i);
      if ((localObject != null) && (((RecyclerView.v)localObject).aie != null))
      {
        ((RecyclerView.v)localObject).aie.setScaleX(1.0F);
        ((RecyclerView.v)localObject).aie.setScaleY(1.0F);
        if (i != j) {
          break label104;
        }
        ((RecyclerView.v)localObject).aie.setAlpha(0.3F);
      }
      for (;;)
      {
        i += 1;
        break;
        label104:
        ((RecyclerView.v)localObject).aie.setAlpha(1.0F);
      }
    }
  }
  
  private void init(Context paramContext)
  {
    this.mContext = paramContext;
    com.tencent.mm.plugin.appbrand.widget.desktop.b.init(this.mContext);
    this.hrb = getItemPadding();
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.AppBrandDesktopHalfView", "alvinluo init itemPadding: %d", new Object[] { Integer.valueOf(this.hrb) });
    paramContext = com.tencent.mm.ui.y.gt(this.mContext).inflate(y.h.app_brand_desktop_half_view_layout, this);
    this.hrE = ((LinearLayout)paramContext.findViewById(y.g.app_brand_desktop_empty_layout));
    this.hrF = ((LinearLayout)paramContext.findViewById(y.g.app_brand_desktop_data_layout));
    this.hrC = ((AppBrandDesktopHalfItemView)paramContext.findViewById(y.g.app_brand_desktop_recent_item));
    this.hrC.a(AppBrandRecentView.f.hBX);
    this.hrC.setItemPadding(this.hrb);
    this.hrC.setTitlePaddingLeft(this.hrb + com.tencent.mm.cb.a.fromDPToPix(this.mContext, 8));
    this.hrC.getRecentView().a(new a(this.hrb));
    this.hrC.setRefreshListener(new AppBrandDesktopHalfView.1(this));
    this.hrC.setOnDataChangedListener(new AppBrandDesktopHalfView.10(this));
    this.hrC.hrj = new AppBrandDesktopHalfView.16(this);
    this.hrC.setCreateContextMenuListener(new AppBrandDesktopHalfView.17(this));
    this.hrC.setMenuItemSelectedListener(new AppBrandRecentView.a() {});
    this.hrC.setOnItemClickListener(new AppBrandRecentView.b()
    {
      public final boolean a(View paramAnonymousView, com.tencent.mm.plugin.appbrand.widget.recentview.a paramAnonymousa, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppBrandDesktopHalfView.this.setLayoutFrozen(true);
        if ((AppBrandDesktopHalfView.g(AppBrandDesktopHalfView.this) != null) && (paramAnonymousa != null) && (paramAnonymousa.hqw != null) && (!bk.bl(paramAnonymousa.hqw.appId)))
        {
          AppBrandDesktopHalfView.d(AppBrandDesktopHalfView.this).getRecentView();
          int i = RecyclerView.bg(paramAnonymousView);
          if (i != -1)
          {
            AppBrandDesktopHalfView.h(AppBrandDesktopHalfView.this);
            paramAnonymousView = AppBrandDesktopHalfView.g(AppBrandDesktopHalfView.this);
            paramAnonymousa = paramAnonymousa.hqw.appId;
            com.tencent.mm.sdk.platformtools.y.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo openRecentAppBrand id: %s, pos: %d", new Object[] { paramAnonymousa, Integer.valueOf(i) });
            paramAnonymousView.hCi.append(paramAnonymousa + ":");
            paramAnonymousView.hCk.append(i + ":");
          }
          AppBrandDesktopHalfView.i(AppBrandDesktopHalfView.this);
        }
        return false;
      }
      
      public final boolean b(View paramAnonymousView, com.tencent.mm.plugin.appbrand.widget.recentview.a paramAnonymousa, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        return false;
      }
    });
    this.hrD = ((AppBrandDesktopHalfItemView)paramContext.findViewById(y.g.app_brand_desktop_my_item));
    this.hrD.a(AppBrandRecentView.f.hBY);
    this.hrD.setItemPadding(this.hrb);
    this.hrD.setTitlePaddingLeft(this.hrb + com.tencent.mm.cb.a.fromDPToPix(this.mContext, 8));
    this.hrD.getRecentView().a(new a(this.hrb));
    this.hrD.setRefreshListener(new AppBrandDesktopHalfView.20(this));
    this.hrD.setOnDataChangedListener(new AppBrandDesktopHalfView.21(this));
    this.hrD.hrj = new AppBrandDesktopHalfView.22(this);
    this.hrD.setCreateContextMenuListener(new View.OnCreateContextMenuListener()
    {
      public final void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        if (paramAnonymousView != null)
        {
          AppBrandDesktopHalfView.c(AppBrandDesktopHalfView.this).getRecentView();
          int i = ConversationAppBrandRecentView.bg(paramAnonymousView);
          com.tencent.mm.sdk.platformtools.y.d("MicroMsg.AppBrandDesktopHalfView", "alvinluo menu current pos: %d", new Object[] { Integer.valueOf(i) });
          if (i > AppBrandDesktopHalfView.l(AppBrandDesktopHalfView.this)) {
            paramAnonymousContextMenu.add(0, 12, 0, AppBrandDesktopHalfView.this.getContext().getResources().getString(y.j.app_brand_desktop_menu_move_to_first));
          }
        }
      }
    });
    this.hrD.setMenuItemSelectedListener(new AppBrandRecentView.a() {});
    this.hrD.setOnItemClickListener(new AppBrandRecentView.b()
    {
      public final boolean a(View paramAnonymousView, com.tencent.mm.plugin.appbrand.widget.recentview.a paramAnonymousa, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppBrandDesktopHalfView.this.setLayoutFrozen(true);
        if ((AppBrandDesktopHalfView.g(AppBrandDesktopHalfView.this) != null) && (paramAnonymousa != null) && (paramAnonymousa.hqw != null) && (!bk.bl(paramAnonymousa.hqw.appId)))
        {
          AppBrandDesktopHalfView.c(AppBrandDesktopHalfView.this).getRecentView();
          int i = RecyclerView.bg(paramAnonymousView);
          if (i != -1)
          {
            AppBrandDesktopHalfView.h(AppBrandDesktopHalfView.this);
            paramAnonymousView = AppBrandDesktopHalfView.g(AppBrandDesktopHalfView.this);
            paramAnonymousa = paramAnonymousa.hqw.appId;
            com.tencent.mm.sdk.platformtools.y.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo openStarAppBrand id: %s, pos: %d", new Object[] { paramAnonymousa, Integer.valueOf(i) });
            paramAnonymousView.hCr.append(paramAnonymousa + ":");
            paramAnonymousView.hCu.append(i + ":");
          }
          AppBrandDesktopHalfView.i(AppBrandDesktopHalfView.this);
        }
        return false;
      }
      
      public final boolean b(View paramAnonymousView, com.tencent.mm.plugin.appbrand.widget.recentview.a paramAnonymousa, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        return false;
      }
    });
    this.hrC.setEnableDataCache(true);
    this.hrD.setEnableDataCache(false);
  }
  
  private void mI(int paramInt)
  {
    Object localObject = this.hrD.getPreviewList();
    ArrayList localArrayList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      LocalUsageInfo localLocalUsageInfo = ((com.tencent.mm.plugin.appbrand.widget.recentview.a)((Iterator)localObject).next()).hqw;
      if (localLocalUsageInfo != null)
      {
        com.tencent.mm.sdk.platformtools.y.d("MicroMsg.AppBrandDesktopHalfView", "alvinluo reorderCollection info: %s, %d", new Object[] { localLocalUsageInfo.nickname, Integer.valueOf(localLocalUsageInfo.fJy) });
        localArrayList.add(localLocalUsageInfo);
      }
    }
    if (paramInt == 1) {
      this.hrD.getRecentView().setIgnoreNotify(false);
    }
    for (;;)
    {
      ((af)g.r(af.class)).d(localArrayList, paramInt);
      return;
      this.hrD.getRecentView().setIgnoreNotify(true);
    }
  }
  
  public final void a(Configuration paramConfiguration)
  {
    onConfigurationChanged(paramConfiguration);
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.AppBrandDesktopHalfView", "alvinluo HalfView onConfigurationChanged orientation: %d", new Object[] { Integer.valueOf(paramConfiguration.orientation) });
    if (this.hrw != paramConfiguration.orientation)
    {
      this.hrw = paramConfiguration.orientation;
      com.tencent.mm.plugin.appbrand.widget.desktop.b.init(getContext());
      this.hrb = getItemPadding();
      if (this.hrC != null) {
        this.hrC.setTitlePaddingLeft(this.hrb + com.tencent.mm.cb.a.fromDPToPix(this.mContext, 8));
      }
      if (this.hrD != null) {
        this.hrD.setTitlePaddingLeft(this.hrb + com.tencent.mm.cb.a.fromDPToPix(this.mContext, 8));
      }
      if (this.hrC != null) {
        this.hrC.a(paramConfiguration);
      }
      if (this.hrD != null) {
        this.hrD.a(paramConfiguration);
      }
    }
  }
  
  public final void arr() {}
  
  public final void ars()
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.AppBrandDesktopHalfView", "alvinluo onCloseHeader");
    postDelayed(new AppBrandDesktopHalfView.13(this), 500L);
  }
  
  public final void art()
  {
    ars();
  }
  
  public final void aru() {}
  
  public final void arw()
  {
    if (this.hrD != null) {
      this.hrD.arw();
    }
    if (this.hrC != null) {
      this.hrC.arw();
    }
  }
  
  public final void arx()
  {
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.AppBrandDesktopHalfView", "alvinluo HalfView onOpen");
    this.hrO = true;
    if (com.tencent.mm.sdk.platformtools.d.IS_FLAVOR_RED)
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.AppBrandDesktopHalfView", "alvinluo refreshOnPullDownOpen on FLAVOR_RED");
      ((af)g.r(af.class)).acK();
    }
    String str = com.tencent.mm.plugin.appbrand.report.e.aoa();
    this.hrM = str;
    com.tencent.mm.plugin.appbrand.report.e.wa(str);
  }
  
  public final void ary()
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.AppBrandDesktopHalfView", "alvinluo checkReportNameDuplicated");
    com.tencent.mm.sdk.f.e.post(new AppBrandDesktopHalfView.15(this), "checkReportNameDuplicated");
  }
  
  public final void arz()
  {
    if (this.hrP)
    {
      ((com.tencent.mm.plugin.appbrand.widget.recentview.d)g.r(com.tencent.mm.plugin.appbrand.widget.recentview.d.class)).ci(10, 0);
      return;
    }
    this.hrP = true;
  }
  
  public int getItemPadding()
  {
    return com.tencent.mm.plugin.appbrand.widget.desktop.d.c(getContext(), com.tencent.mm.plugin.appbrand.widget.desktop.b.getShowCountPerPage());
  }
  
  public int getRecentAppBrandCount()
  {
    if (this.hrC != null) {
      return this.hrC.getDataCount() - this.hrC.getCustomCount();
    }
    return 0;
  }
  
  public int getStarAppBrandCount()
  {
    if (this.hrD != null) {
      return this.hrD.getDataCount() - this.hrD.getCustomCount();
    }
    return 0;
  }
  
  public final void mJ(int paramInt)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.AppBrandDesktopHalfView", "alvinluo HalfView onClose type: %d, isHeaderOpen: %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.hrO) });
    if (this.hrO)
    {
      this.hrO = false;
      mI(1);
    }
  }
  
  public final void onDestroy()
  {
    if (this.hrC != null) {
      this.hrC.release();
    }
    if (this.hrD != null) {
      this.hrD.release();
    }
  }
  
  public final void refresh()
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.AppBrandDesktopHalfView", "alvinluo refresh data");
    this.hrH = true;
    this.hrD.hpU.refresh();
    this.hrG = true;
    this.hrC.hpU.refresh();
  }
  
  public void setCollectionRefreshListener(AppBrandRecentView.e parame)
  {
    this.hrJ = parame;
  }
  
  public void setIOnLaunchUIListener(a.b paramb)
  {
    if (this.hrC != null) {
      this.hrC.setOnLaunchUIListener(paramb);
    }
    if (this.hrD != null) {
      this.hrD.setOnLaunchUIListener(paramb);
    }
  }
  
  public void setLayoutFrozen(boolean paramBoolean)
  {
    if ((this.hrC != null) && (this.hrC.getRecentView() != null)) {
      this.hrC.getRecentView().setLayoutFrozen(paramBoolean);
    }
    if ((this.hrD != null) && (this.hrD.getRecentView() != null)) {
      this.hrD.getRecentView().setLayoutFrozen(paramBoolean);
    }
  }
  
  public void setMyRefreshListener(AppBrandRecentView.e parame)
  {
    this.hrJ = parame;
  }
  
  public void setNeedScrollToFirstPageWhenResume(boolean paramBoolean)
  {
    this.hrN = paramBoolean;
  }
  
  public void setOnEmptyViewListener(com.tencent.mm.plugin.appbrand.widget.header.a.a.a parama)
  {
    this.hrQ = parama;
  }
  
  public void setRecentRefreshListener(AppBrandRecentView.e parame)
  {
    this.hrI = parame;
  }
  
  public void setReporter(com.tencent.mm.plugin.appbrand.widget.recentview.b paramb)
  {
    this.hrl = paramb;
    if (this.hrC != null) {
      this.hrC.setReporter(paramb);
    }
    if (this.hrD != null) {
      this.hrD.setReporter(paramb);
    }
  }
  
  public void setUsageRefreshListener(AppBrandRecentView.e parame)
  {
    this.hrI = parame;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.half.AppBrandDesktopHalfView
 * JD-Core Version:    0.7.0.1
 */