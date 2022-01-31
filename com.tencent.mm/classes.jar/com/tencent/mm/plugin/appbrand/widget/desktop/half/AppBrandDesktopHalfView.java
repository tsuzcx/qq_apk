package com.tencent.mm.plugin.appbrand.widget.desktop.half;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import com.tencent.mm.plugin.appbrand.appusage.af;
import com.tencent.mm.plugin.appbrand.report.h;
import com.tencent.mm.plugin.appbrand.widget.desktop.c;
import com.tencent.mm.plugin.appbrand.widget.header.a.a.a;
import com.tencent.mm.plugin.appbrand.widget.header.a.a.b;
import com.tencent.mm.plugin.appbrand.widget.header.c.a;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.d;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.e;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.f;
import com.tencent.mm.plugin.appbrand.widget.recentview.ConversationAppBrandRecentView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AppBrandDesktopHalfView
  extends LinearLayout
  implements com.tencent.mm.plugin.appbrand.widget.header.a.a, c.a
{
  boolean cvo;
  private int iAy;
  private int jdO;
  private boolean jeL;
  private com.tencent.mm.plugin.appbrand.widget.recentview.b jhK;
  private AppBrandDesktopHalfItemView jhZ;
  private AppBrandDesktopHalfItemView jia;
  private LinearLayout jib;
  private LinearLayout jic;
  private boolean jid;
  private boolean jie;
  private AppBrandRecentView.e jif;
  private AppBrandRecentView.e jig;
  private int jih;
  private c jii;
  private String jij;
  private boolean jik;
  private boolean jil;
  private a.a jim;
  private Context mContext;
  
  public AppBrandDesktopHalfView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(134183);
    this.jid = false;
    this.jie = false;
    this.jdO = 0;
    this.jif = null;
    this.jig = null;
    com.tencent.mm.plugin.appbrand.widget.desktop.b.aPh();
    this.jih = 1;
    this.jii = null;
    this.jhK = null;
    this.jij = null;
    this.jik = true;
    this.jeL = false;
    this.iAy = 0;
    this.jil = true;
    this.cvo = false;
    init(paramContext);
    AppMethodBeat.o(134183);
  }
  
  public AppBrandDesktopHalfView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(134184);
    this.jid = false;
    this.jie = false;
    this.jdO = 0;
    this.jif = null;
    this.jig = null;
    com.tencent.mm.plugin.appbrand.widget.desktop.b.aPh();
    this.jih = 1;
    this.jii = null;
    this.jhK = null;
    this.jij = null;
    this.jik = true;
    this.jeL = false;
    this.iAy = 0;
    this.jil = true;
    this.cvo = false;
    init(paramContext);
    AppMethodBeat.o(134184);
  }
  
  public AppBrandDesktopHalfView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(134185);
    this.jid = false;
    this.jie = false;
    this.jdO = 0;
    this.jif = null;
    this.jig = null;
    com.tencent.mm.plugin.appbrand.widget.desktop.b.aPh();
    this.jih = 1;
    this.jii = null;
    this.jhK = null;
    this.jij = null;
    this.jik = true;
    this.jeL = false;
    this.iAy = 0;
    this.jil = true;
    this.cvo = false;
    init(paramContext);
    AppMethodBeat.o(134185);
  }
  
  private void fl(boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(134188);
    ab.i("MicroMsg.AppBrandDesktopHalfView", "alvinluo showEmptyView show: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    LinearLayout localLinearLayout;
    if (paramBoolean)
    {
      if ((this.jib.getVisibility() != 0) && (this.jim != null)) {
        this.jim.fn(true);
      }
      localLinearLayout = this.jib;
      if (!paramBoolean) {
        break label109;
      }
    }
    for (;;)
    {
      localLinearLayout.setVisibility(i);
      AppMethodBeat.o(134188);
      return;
      if ((this.jib.getVisibility() != 0) || (this.jim == null)) {
        break;
      }
      this.jim.fn(false);
      break;
      label109:
      i = 4;
    }
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(134187);
    this.mContext = paramContext;
    com.tencent.mm.plugin.appbrand.widget.desktop.b.init(this.mContext);
    this.jdO = getItemPadding();
    ab.i("MicroMsg.AppBrandDesktopHalfView", "alvinluo init itemPadding: %d", new Object[] { Integer.valueOf(this.jdO) });
    paramContext = w.hM(this.mContext).inflate(2130968676, this);
    this.jib = ((LinearLayout)paramContext.findViewById(2131821191));
    this.jic = ((LinearLayout)paramContext.findViewById(2131821192));
    this.jhZ = ((AppBrandDesktopHalfItemView)paramContext.findViewById(2131821193));
    this.jhZ.a(AppBrandRecentView.f.juq);
    this.jhZ.setItemPadding(this.jdO);
    this.jhZ.setTitlePaddingLeft(this.jdO + com.tencent.mm.cb.a.fromDPToPix(this.mContext, 8));
    this.jhZ.getRecentView().a(new a(this.jdO));
    this.jhZ.setRefreshListener(new AppBrandDesktopHalfView.1(this));
    this.jhZ.setOnDataChangedListener(new AppBrandRecentView.d()
    {
      public final void aQm()
      {
        AppMethodBeat.i(134169);
        AppBrandDesktopHalfView.b(AppBrandDesktopHalfView.this);
        AppMethodBeat.o(134169);
      }
    });
    this.jhZ.jhI = new AppBrandDesktopHalfView.16(this);
    this.jhZ.setCreateContextMenuListener(new AppBrandDesktopHalfView.17(this));
    this.jhZ.setMenuItemSelectedListener(new AppBrandDesktopHalfView.18(this));
    this.jhZ.setOnItemClickListener(new AppBrandDesktopHalfView.19(this));
    this.jia = ((AppBrandDesktopHalfItemView)paramContext.findViewById(2131821194));
    this.jia.a(AppBrandRecentView.f.jur);
    this.jia.setItemPadding(this.jdO);
    this.jia.setTitlePaddingLeft(this.jdO + com.tencent.mm.cb.a.fromDPToPix(this.mContext, 8));
    this.jia.getRecentView().a(new a(this.jdO));
    this.jia.setRefreshListener(new AppBrandDesktopHalfView.20(this));
    this.jia.setOnDataChangedListener(new AppBrandDesktopHalfView.21(this));
    this.jia.jhI = new AppBrandDesktopHalfView.22(this);
    this.jia.setCreateContextMenuListener(new View.OnCreateContextMenuListener()
    {
      public final void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(134161);
        if (paramAnonymousView != null)
        {
          AppBrandDesktopHalfView.c(AppBrandDesktopHalfView.this).getRecentView();
          int i = ConversationAppBrandRecentView.bq(paramAnonymousView);
          ab.d("MicroMsg.AppBrandDesktopHalfView", "alvinluo menu current pos: %d", new Object[] { Integer.valueOf(i) });
          if (i > AppBrandDesktopHalfView.l(AppBrandDesktopHalfView.this)) {
            paramAnonymousContextMenu.add(0, 12, 0, AppBrandDesktopHalfView.this.getContext().getResources().getString(2131296616));
          }
        }
        AppMethodBeat.o(134161);
      }
    });
    this.jia.setMenuItemSelectedListener(new AppBrandDesktopHalfView.3(this));
    this.jia.setOnItemClickListener(new AppBrandDesktopHalfView.4(this));
    this.jhZ.setEnableDataCache(true);
    this.jia.setEnableDataCache(false);
    AppMethodBeat.o(134187);
  }
  
  private static void l(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(134196);
    Object localObject = (LinearLayoutManager)paramRecyclerView.getLayoutManager();
    int i = ((LinearLayoutManager)localObject).it();
    int j = ((LinearLayoutManager)localObject).iv();
    ab.i("MicroMsg.AppBrandDesktopHalfView", "alvinluo checkAlphaChange firstPos: %d, lastPos: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    if (i <= j)
    {
      localObject = paramRecyclerView.bQ(i);
      if ((localObject != null) && (((RecyclerView.v)localObject).aku != null))
      {
        ((RecyclerView.v)localObject).aku.setScaleX(1.0F);
        ((RecyclerView.v)localObject).aku.setScaleY(1.0F);
        if (i != j) {
          break label110;
        }
        ((RecyclerView.v)localObject).aku.setAlpha(0.3F);
      }
      for (;;)
      {
        i += 1;
        break;
        label110:
        ((RecyclerView.v)localObject).aku.setAlpha(1.0F);
      }
    }
    AppMethodBeat.o(134196);
  }
  
  private void qk(int paramInt)
  {
    AppMethodBeat.i(134189);
    Object localObject = this.jia.getPreviewList();
    ArrayList localArrayList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      LocalUsageInfo localLocalUsageInfo = ((com.tencent.mm.plugin.appbrand.widget.recentview.a)((Iterator)localObject).next()).jfk;
      if (localLocalUsageInfo != null)
      {
        ab.d("MicroMsg.AppBrandDesktopHalfView", "alvinluo reorderCollection info: %s, %d", new Object[] { localLocalUsageInfo.nickname, Integer.valueOf(localLocalUsageInfo.hcr) });
        localArrayList.add(localLocalUsageInfo);
      }
    }
    if (paramInt == 1) {
      this.jia.getRecentView().setIgnoreNotify(false);
    }
    for (;;)
    {
      ((af)g.E(af.class)).g(localArrayList, paramInt);
      AppMethodBeat.o(134189);
      return;
      this.jia.getRecentView().setIgnoreNotify(true);
    }
  }
  
  public final void aPx() {}
  
  public final void aPy() {}
  
  public final void aQi()
  {
    AppMethodBeat.i(134193);
    if (this.jia != null) {
      this.jia.aQi();
    }
    if (this.jhZ != null) {
      this.jhZ.aQi();
    }
    AppMethodBeat.o(134193);
  }
  
  public final void aQj()
  {
    AppMethodBeat.i(134191);
    ab.d("MicroMsg.AppBrandDesktopHalfView", "alvinluo HalfView onOpen");
    this.jeL = true;
    ((af)g.E(af.class)).awQ();
    String str = h.aKY();
    this.jij = str;
    h.EF(str);
    AppMethodBeat.o(134191);
  }
  
  public final void aQk()
  {
    AppMethodBeat.i(134201);
    ab.i("MicroMsg.AppBrandDesktopHalfView", "alvinluo checkReportNameDuplicated");
    com.tencent.mm.sdk.g.d.post(new AppBrandDesktopHalfView.15(this), "checkReportNameDuplicated");
    AppMethodBeat.o(134201);
  }
  
  public final void b(Configuration paramConfiguration)
  {
    AppMethodBeat.i(134197);
    onConfigurationChanged(paramConfiguration);
    ab.i("MicroMsg.AppBrandDesktopHalfView", "alvinluo HalfView onConfigurationChanged orientation: %d", new Object[] { Integer.valueOf(paramConfiguration.orientation) });
    int i = getItemPadding();
    if ((this.iAy != paramConfiguration.orientation) || (i != this.jdO))
    {
      this.iAy = paramConfiguration.orientation;
      com.tencent.mm.plugin.appbrand.widget.desktop.b.init(getContext());
      this.jdO = i;
      if (this.jhZ != null) {
        this.jhZ.setTitlePaddingLeft(this.jdO + com.tencent.mm.cb.a.fromDPToPix(this.mContext, 8));
      }
      if (this.jia != null) {
        this.jia.setTitlePaddingLeft(this.jdO + com.tencent.mm.cb.a.fromDPToPix(this.mContext, 8));
      }
      if (this.jhZ != null) {
        this.jhZ.b(paramConfiguration);
      }
      if (this.jia != null) {
        this.jia.b(paramConfiguration);
      }
    }
    AppMethodBeat.o(134197);
  }
  
  public int getItemPadding()
  {
    AppMethodBeat.i(134186);
    int i = com.tencent.mm.plugin.appbrand.widget.desktop.d.jdMethod_do(getContext());
    AppMethodBeat.o(134186);
    return i;
  }
  
  public int getRecentAppBrandCount()
  {
    AppMethodBeat.i(134198);
    if (this.jhZ != null)
    {
      int i = this.jhZ.getDataCount();
      int j = this.jhZ.getCustomCount();
      AppMethodBeat.o(134198);
      return i - j;
    }
    AppMethodBeat.o(134198);
    return 0;
  }
  
  public int getStarAppBrandCount()
  {
    AppMethodBeat.i(134199);
    if (this.jia != null)
    {
      int i = this.jia.getDataCount();
      int j = this.jia.getCustomCount();
      AppMethodBeat.o(134199);
      return i - j;
    }
    AppMethodBeat.o(134199);
    return 0;
  }
  
  public final void qb(int paramInt)
  {
    AppMethodBeat.i(134190);
    ab.i("MicroMsg.AppBrandDesktopHalfView", "alvinluo onCloseHeader");
    postDelayed(new AppBrandDesktopHalfView.13(this), 500L);
    AppMethodBeat.o(134190);
  }
  
  public final void qc(int paramInt)
  {
    AppMethodBeat.i(134194);
    qb(paramInt);
    AppMethodBeat.o(134194);
  }
  
  public final void ql(int paramInt)
  {
    AppMethodBeat.i(134192);
    ab.i("MicroMsg.AppBrandDesktopHalfView", "alvinluo HalfView onClose type: %d, isHeaderOpen: %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.jeL) });
    if (this.jeL)
    {
      this.jeL = false;
      qk(1);
    }
    AppMethodBeat.o(134192);
  }
  
  public final void refresh()
  {
    AppMethodBeat.i(134203);
    ab.i("MicroMsg.AppBrandDesktopHalfView", "alvinluo refresh data");
    this.jie = true;
    this.jia.jeb.refresh();
    this.jid = true;
    this.jhZ.jeb.refresh();
    AppMethodBeat.o(134203);
  }
  
  public void setCollectionRefreshListener(AppBrandRecentView.e parame)
  {
    this.jig = parame;
  }
  
  public void setIOnLaunchUIListener(a.b paramb)
  {
    AppMethodBeat.i(134202);
    if (this.jhZ != null) {
      this.jhZ.setOnLaunchUIListener(paramb);
    }
    if (this.jia != null) {
      this.jia.setOnLaunchUIListener(paramb);
    }
    AppMethodBeat.o(134202);
  }
  
  public void setLayoutFrozen(boolean paramBoolean)
  {
    AppMethodBeat.i(134195);
    if ((this.jhZ != null) && (this.jhZ.getRecentView() != null)) {
      this.jhZ.getRecentView().setLayoutFrozen(paramBoolean);
    }
    if ((this.jia != null) && (this.jia.getRecentView() != null)) {
      this.jia.getRecentView().setLayoutFrozen(paramBoolean);
    }
    AppMethodBeat.o(134195);
  }
  
  public void setMyRefreshListener(AppBrandRecentView.e parame)
  {
    this.jig = parame;
  }
  
  public void setNeedScrollToFirstPageWhenResume(boolean paramBoolean)
  {
    this.jik = paramBoolean;
  }
  
  public void setOnEmptyViewListener(a.a parama)
  {
    this.jim = parama;
  }
  
  public void setRecentRefreshListener(AppBrandRecentView.e parame)
  {
    this.jif = parame;
  }
  
  public void setReporter(com.tencent.mm.plugin.appbrand.widget.recentview.b paramb)
  {
    AppMethodBeat.i(134200);
    this.jhK = paramb;
    if (this.jhZ != null) {
      this.jhZ.setReporter(paramb);
    }
    if (this.jia != null) {
      this.jia.setReporter(paramb);
    }
    AppMethodBeat.o(134200);
  }
  
  public void setUsageRefreshListener(AppBrandRecentView.e parame)
  {
    this.jif = parame;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.half.AppBrandDesktopHalfView
 * JD-Core Version:    0.7.0.1
 */