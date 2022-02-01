package com.tencent.mm.plugin.card.ui.v2;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.s;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.modelimage.loader.a.c;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import com.tencent.mm.plugin.card.a.a;
import com.tencent.mm.plugin.card.a.c;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.a.f;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.mgr.j;
import com.tencent.mm.plugin.card.model.a.g;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.plugin.card.ui.CardDetailUI;
import com.tencent.mm.plugin.card.widget.CardTagTextView;
import com.tencent.mm.plugin.card.widget.MemberCardTopCropImageView;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.n;
import com.tencent.mm.protocal.protobuf.ajq;
import com.tencent.mm.protocal.protobuf.cgq;
import com.tencent.mm.protocal.protobuf.cnl;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.protocal.protobuf.vs;
import com.tencent.mm.protocal.protobuf.vt;
import com.tencent.mm.protocal.protobuf.vu;
import com.tencent.mm.protocal.protobuf.vw;
import com.tencent.mm.protocal.protobuf.vx;
import com.tencent.mm.protocal.protobuf.wa;
import com.tencent.mm.protocal.protobuf.wb;
import com.tencent.mm.protocal.protobuf.wd;
import com.tencent.mm.protocal.protobuf.we;
import com.tencent.mm.protocal.protobuf.wg;
import com.tencent.mm.protocal.protobuf.wo;
import com.tencent.mm.protocal.protobuf.wp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;

@com.tencent.mm.kernel.k
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI;", "Lcom/tencent/mm/plugin/card/ui/v2/CardNewBaseUI;", "()V", "cardSortInfoList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/CardSortInfo;", "Lkotlin/collections/ArrayList;", "cardTitleModel", "Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$CardListModel;", "clickArea", "", "clickedCardHomePageElement", "Lcom/tencent/mm/protocal/protobuf/CardHomePageElement;", "emptyModel", "faqItem", "Lcom/tencent/mm/protocal/protobuf/CardHomePageFAQItem;", "firstLoad", "", "getCardHomePageScene", "Lcom/tencent/mm/plugin/card/model/v2/CgiGetMktCardHomePage;", "isAll", "isGotoItem", "isLoading", "mDivider", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "mHomePageAdapter", "Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageAdapter;", "mLoadingView", "Landroid/view/ViewGroup;", "mLoadingView2", "mRecyclerView", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "markReloadHomePage", "needReloadHomePage", "offset", "reqNum", "scene", "shouldShowTicket", "showSort", "sortType", "storeModelList", "ticketModel", "ticketNum", "", "tipsDialog", "Landroid/app/Dialog;", "titleSectionModel", "topCellList", "underModelList", "cardSortInfo", "doDeleteMchInList", "", "merchantId", "doGetCardHomePage", "doGetMchInfo", "lastReceiveTime", "", "getLayoutId", "initFirstScreen", "initView", "loadSnapshot", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinishLocationThings", "ret", "isLocationOk", "onResume", "saveSnapshot", "setFaqIconMenu", "showSortSheet", "updateModelList", "storePageList", "Lcom/tencent/mm/protocal/protobuf/CardHomePageStoreList;", "underPageList", "Lcom/tencent/mm/protocal/protobuf/CardHomePageUnderList;", "_topCellList", "Lcom/tencent/mm/protocal/protobuf/CardHomePageTopCellList;", "CardListModel", "CardSpan", "Companion", "HomePageAdapter", "HomePageVH", "plugin-card_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class CardHomePageNewUI
  extends CardNewBaseUI
{
  private static final int hpe;
  private static final int wFI;
  private static final int wFJ;
  public static final CardHomePageNewUI.c wFi;
  private boolean isLoading;
  private boolean mgS;
  private int offset;
  private Dialog pIQ;
  private int scene;
  private boolean wFA;
  private int wFB;
  private ArrayList<wo> wFC;
  private boolean wFD;
  private vx wFE;
  private vw wFF;
  private boolean wFG;
  private g wFH;
  private LoadMoreRecyclerView wFj;
  private d wFk;
  private ViewGroup wFl;
  private RecyclerView.h wFm;
  private ViewGroup wFn;
  private int wFo;
  private boolean wFp;
  private String wFq;
  private final ArrayList<a> wFr;
  private final ArrayList<a> wFs;
  private final ArrayList<a> wFt;
  private a wFu;
  private a wFv;
  private a wFw;
  private a wFx;
  private boolean wFy;
  private int wFz;
  private int wvU;
  
  static
  {
    AppMethodBeat.i(112470);
    wFi = new CardHomePageNewUI.c((byte)0);
    hpe = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 40);
    wFI = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 1);
    wFJ = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 16);
    AppMethodBeat.o(112470);
  }
  
  public CardHomePageNewUI()
  {
    AppMethodBeat.i(112469);
    this.wFo = 10;
    this.wFq = "";
    this.wFr = new ArrayList();
    this.wFs = new ArrayList();
    this.wFt = new ArrayList();
    this.mgS = true;
    this.wFz = -1;
    this.wFA = true;
    this.wFC = new ArrayList();
    this.wFE = new vx();
    AppMethodBeat.o(112469);
  }
  
  private static final Object a(CardHomePageNewUI paramCardHomePageNewUI, b.a parama)
  {
    Object localObject2 = null;
    AppMethodBeat.i(294141);
    kotlin.g.b.s.u(paramCardHomePageNewUI, "this$0");
    Log.i("MicroMsg.CardHomePageNewUI", "errtype: %s, errcode: %s", new Object[] { Integer.valueOf(parama.errType), Integer.valueOf(parama.errCode) });
    if (paramCardHomePageNewUI.pIQ != null)
    {
      localObject1 = paramCardHomePageNewUI.pIQ;
      kotlin.g.b.s.checkNotNull(localObject1);
      ((Dialog)localObject1).dismiss();
    }
    paramCardHomePageNewUI.wFH = null;
    Object localObject3 = paramCardHomePageNewUI.wFn;
    Object localObject1 = localObject3;
    if (localObject3 == null)
    {
      kotlin.g.b.s.bIx("mLoadingView2");
      localObject1 = null;
    }
    ((ViewGroup)localObject1).setVisibility(8);
    paramCardHomePageNewUI.isLoading = false;
    if ((parama.errType == 0) && (parama.errCode == 0))
    {
      localObject3 = parama.ott;
      cnl localcnl = (cnl)localObject3;
      Log.i("MicroMsg.CardHomePageNewUI", "retCode: %s", new Object[] { Integer.valueOf(localcnl.wuz) });
      boolean bool;
      if (localcnl.wuz == 0)
      {
        paramCardHomePageNewUI.offset = localcnl.xlj;
        if (localcnl.aaqL == 1)
        {
          bool = true;
          paramCardHomePageNewUI.wFp = bool;
          paramCardHomePageNewUI.wFC.clear();
          if (localcnl.aaqR != null) {
            paramCardHomePageNewUI.wFC.addAll((Collection)localcnl.aaqR.ZdB);
          }
          if (!Util.isNullOrNil(localcnl.aauP)) {
            paramCardHomePageNewUI.wFq = localcnl.aauP;
          }
          if (!paramCardHomePageNewUI.wFp) {
            break label445;
          }
          localObject1 = paramCardHomePageNewUI.wFj;
          parama = (b.a)localObject1;
          if (localObject1 == null)
          {
            kotlin.g.b.s.bIx("mRecyclerView");
            parama = null;
          }
          parama.showLoading(false);
          paramCardHomePageNewUI.wFE = localcnl.aauO;
          paramCardHomePageNewUI.dnQ();
          label289:
          if ((!paramCardHomePageNewUI.mgS) && (!paramCardHomePageNewUI.wFG)) {
            break label472;
          }
          paramCardHomePageNewUI.wFs.clear();
          paramCardHomePageNewUI.wFt.clear();
          paramCardHomePageNewUI.wFr.clear();
          paramCardHomePageNewUI.wFv = null;
          if (paramCardHomePageNewUI.mgS) {
            paramCardHomePageNewUI.mgS = false;
          }
          paramCardHomePageNewUI.wFG = false;
          label346:
          paramCardHomePageNewUI.a(localcnl.aaqM, localcnl.aauN, localcnl.aauQ);
          parama = paramCardHomePageNewUI.wFj;
          if (parama != null) {
            break label481;
          }
          kotlin.g.b.s.bIx("mRecyclerView");
          parama = localObject2;
          label383:
          parama = parama.getAdapter();
          if (parama != null) {
            parama.bZE.notifyChanged();
          }
        }
      }
      for (;;)
      {
        if (localcnl.aaqP == 1)
        {
          paramCardHomePageNewUI.wFG = true;
          paramCardHomePageNewUI.offset = 0;
          paramCardHomePageNewUI.wvU = localcnl.aaqQ;
          paramCardHomePageNewUI.dnS();
        }
        AppMethodBeat.o(294141);
        return localObject3;
        bool = false;
        break;
        label445:
        localObject1 = paramCardHomePageNewUI.wFj;
        parama = (b.a)localObject1;
        if (localObject1 == null)
        {
          kotlin.g.b.s.bIx("mRecyclerView");
          parama = null;
        }
        parama.showLoading(true);
        break label289;
        label472:
        localcnl.aauQ = null;
        break label346;
        label481:
        break label383;
        if (paramCardHomePageNewUI.mgS) {
          paramCardHomePageNewUI.mgS = false;
        }
        com.tencent.mm.plugin.card.c.l.ar((Context)paramCardHomePageNewUI, localcnl.wuA);
        com.tencent.mm.plugin.report.service.h.OAn.b(16322, new Object[] { Integer.valueOf(31) });
      }
    }
    paramCardHomePageNewUI.wvU = 0;
    if (paramCardHomePageNewUI.mgS) {
      paramCardHomePageNewUI.mgS = false;
    }
    com.tencent.mm.plugin.card.c.l.as((Context)paramCardHomePageNewUI, "");
    com.tencent.mm.plugin.report.service.h.OAn.b(16322, new Object[] { Integer.valueOf(31) });
    paramCardHomePageNewUI = ah.aiuX;
    AppMethodBeat.o(294141);
    return paramCardHomePageNewUI;
  }
  
  private static final ah a(CardHomePageNewUI paramCardHomePageNewUI, String paramString, b.a parama)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    AppMethodBeat.i(294120);
    kotlin.g.b.s.u(paramCardHomePageNewUI, "this$0");
    kotlin.g.b.s.u(paramString, "$merchantId");
    Log.i("MicroMsg.CardHomePageNewUI", "errtype: %s, errcode: %s", new Object[] { Integer.valueOf(parama.errType), Integer.valueOf(parama.errCode) });
    cgq localcgq;
    if ((parama.errType == 0) && (parama.errCode == 0))
    {
      localcgq = (cgq)parama.ott;
      Log.i("MicroMsg.CardHomePageNewUI", "retCode: %s, refresh: %s", new Object[] { Integer.valueOf(localcgq.wuz), Integer.valueOf(localcgq.aapA) });
      if (localcgq.wuz == 0) {
        if (localcgq.aapA == 1)
        {
          paramCardHomePageNewUI.wFG = true;
          paramCardHomePageNewUI.offset = 0;
          paramCardHomePageNewUI.dnS();
        }
      }
    }
    for (;;)
    {
      paramCardHomePageNewUI.wFz = -1;
      paramCardHomePageNewUI = ah.aiuX;
      AppMethodBeat.o(294120);
      return paramCardHomePageNewUI;
      if (paramCardHomePageNewUI.wFz == 0)
      {
        if (localcgq.aapz.ZcB.size() == 0)
        {
          localObject1 = paramCardHomePageNewUI.wFk;
          parama = (b.a)localObject1;
          if (localObject1 == null)
          {
            kotlin.g.b.s.bIx("mHomePageAdapter");
            parama = null;
          }
          parama.alc(paramString);
        }
        else
        {
          parama = paramCardHomePageNewUI.wFk;
          if (parama == null)
          {
            kotlin.g.b.s.bIx("mHomePageAdapter");
            parama = (b.a)localObject1;
          }
          for (;;)
          {
            localObject1 = localcgq.aapz;
            kotlin.g.b.s.s(localObject1, "card_pkg_mch_info");
            parama.a(paramString, (vw)localObject1);
            break;
          }
        }
      }
      else
      {
        parama = paramCardHomePageNewUI.wFk;
        if (parama == null)
        {
          kotlin.g.b.s.bIx("mHomePageAdapter");
          parama = localObject2;
        }
        for (;;)
        {
          localObject1 = localcgq.aapz;
          kotlin.g.b.s.s(localObject1, "card_pkg_mch_info");
          parama.a(paramString, (vw)localObject1);
          break;
        }
        com.tencent.mm.plugin.card.c.l.ar((Context)paramCardHomePageNewUI, localcgq.wuA);
        continue;
        com.tencent.mm.plugin.card.c.l.as((Context)paramCardHomePageNewUI, "");
      }
    }
  }
  
  private static final void a(CardHomePageNewUI paramCardHomePageNewUI, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(294152);
    kotlin.g.b.s.u(paramCardHomePageNewUI, "this$0");
    com.tencent.mm.pluginsdk.permission.b.bG((Activity)paramCardHomePageNewUI.getContext());
    AppMethodBeat.o(294152);
  }
  
  private static final void a(CardHomePageNewUI paramCardHomePageNewUI, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(294166);
    kotlin.g.b.s.u(paramCardHomePageNewUI, "this$0");
    paramInt = paramMenuItem.getItemId();
    Log.i("MicroMsg.CardHomePageNewUI", "click item: %s, sortType: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramCardHomePageNewUI.wvU) });
    paramMenuItem = paramCardHomePageNewUI.wFC.get(paramInt);
    kotlin.g.b.s.s(paramMenuItem, "cardSortInfoList[itemId]");
    paramMenuItem = (wo)paramMenuItem;
    paramCardHomePageNewUI.wFo = paramMenuItem.Zdz;
    if ((paramMenuItem.Zdy == 1) && (paramCardHomePageNewUI.wvU != 1))
    {
      if (!paramCardHomePageNewUI.dom())
      {
        com.tencent.mm.ui.base.k.a((Context)paramCardHomePageNewUI.getContext(), paramCardHomePageNewUI.getString(a.g.woY), paramCardHomePageNewUI.getString(a.g.permission_tips_title), paramCardHomePageNewUI.getString(a.g.jump_to_settings), paramCardHomePageNewUI.getString(a.g.confirm_dialog_cancel), false, new CardHomePageNewUI..ExternalSyntheticLambda0(paramCardHomePageNewUI), null);
        AppMethodBeat.o(294166);
        return;
      }
      paramCardHomePageNewUI.wFG = true;
      paramCardHomePageNewUI.offset = 0;
      paramCardHomePageNewUI.wvU = 1;
      paramCardHomePageNewUI.dnS();
      com.tencent.mm.plugin.report.service.h.OAn.b(16322, new Object[] { Integer.valueOf(15) });
      AppMethodBeat.o(294166);
      return;
    }
    if ((paramMenuItem.Zdy == 2) && (paramCardHomePageNewUI.wvU != 2))
    {
      paramCardHomePageNewUI.wFG = true;
      paramCardHomePageNewUI.offset = 0;
      paramCardHomePageNewUI.wvU = 2;
      paramCardHomePageNewUI.dnS();
      com.tencent.mm.plugin.report.service.h.OAn.b(16322, new Object[] { Integer.valueOf(16) });
      AppMethodBeat.o(294166);
      return;
    }
    if ((paramMenuItem.Zdy == 3) && (paramCardHomePageNewUI.wvU != 3))
    {
      paramCardHomePageNewUI.wFG = true;
      paramCardHomePageNewUI.offset = 0;
      paramCardHomePageNewUI.wvU = 3;
      paramCardHomePageNewUI.dnS();
      com.tencent.mm.plugin.report.service.h.OAn.b(16322, new Object[] { Integer.valueOf(17) });
    }
    AppMethodBeat.o(294166);
  }
  
  private static final void a(CardHomePageNewUI paramCardHomePageNewUI, RecyclerView paramRecyclerView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(294078);
    kotlin.g.b.s.u(paramCardHomePageNewUI, "this$0");
    paramView = paramCardHomePageNewUI.wFk;
    paramRecyclerView = paramView;
    if (paramView == null)
    {
      kotlin.g.b.s.bIx("mHomePageAdapter");
      paramRecyclerView = null;
    }
    paramRecyclerView = paramRecyclerView.IA(paramInt);
    if (paramRecyclerView != null) {
      Log.i("MicroMsg.CardHomePageNewUI", "click type: %s", new Object[] { Integer.valueOf(paramRecyclerView.type) });
    }
    Object localObject;
    switch (paramRecyclerView.type)
    {
    case 3: 
    default: 
      AppMethodBeat.o(294078);
      return;
    case 2: 
      paramCardHomePageNewUI.wFy = true;
      paramCardHomePageNewUI.wFz = 1;
      paramCardHomePageNewUI.wFF = paramRecyclerView.wFK;
      paramView = paramRecyclerView.wFK;
      kotlin.g.b.s.checkNotNull(paramView);
      switch (paramView.Zcl)
      {
      }
      for (;;)
      {
        paramView = com.tencent.mm.plugin.report.service.h.OAn;
        paramRecyclerView = paramRecyclerView.wFK;
        kotlin.g.b.s.checkNotNull(paramRecyclerView);
        paramView.b(16324, new Object[] { Integer.valueOf(2), paramRecyclerView.Zcw, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(paramInt), Integer.valueOf(paramCardHomePageNewUI.wvU) });
        AppMethodBeat.o(294078);
        return;
        paramView = (MMActivity)paramCardHomePageNewUI;
        localObject = paramRecyclerView.wFK;
        kotlin.g.b.s.checkNotNull(localObject);
        com.tencent.mm.plugin.card.c.b.a(paramView, ((vw)localObject).Zcm, 0);
        continue;
        paramView = paramRecyclerView.wFK;
        kotlin.g.b.s.checkNotNull(paramView);
        paramView = paramView.Zcn;
        com.tencent.mm.plugin.card.c.b.S(paramView.VcU, paramView.VcV, paramView.VQU);
      }
    case 4: 
      Log.i("MicroMsg.CardHomePageNewUI", "click ticket item");
      paramRecyclerView = new Intent((Context)paramCardHomePageNewUI, CardTicketListUI.class);
      paramRecyclerView = new com.tencent.mm.hellhoundlib.b.a().cG(paramRecyclerView);
      com.tencent.mm.hellhoundlib.a.a.b(paramCardHomePageNewUI, paramRecyclerView.aYi(), "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI", "initView$lambda-7", "(Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI;Landroidx/recyclerview/widget/RecyclerView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramCardHomePageNewUI.startActivity((Intent)paramRecyclerView.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramCardHomePageNewUI, "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI", "initView$lambda-7", "(Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI;Landroidx/recyclerview/widget/RecyclerView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.plugin.report.service.h.OAn.b(16322, new Object[] { Integer.valueOf(5) });
      AppMethodBeat.o(294078);
      return;
    case 5: 
      com.tencent.mm.plugin.report.service.h.OAn.b(16322, new Object[] { Integer.valueOf(13) });
      AppMethodBeat.o(294078);
      return;
    }
    paramView = paramRecyclerView.wFO;
    kotlin.g.b.s.checkNotNull(paramView);
    switch (paramView.ZcU)
    {
    }
    for (;;)
    {
      paramView = paramRecyclerView.wFO;
      kotlin.g.b.s.checkNotNull(paramView);
      paramView.ZcZ = 0;
      paramRecyclerView = paramRecyclerView.wFO;
      kotlin.g.b.s.checkNotNull(paramRecyclerView);
      paramRecyclerView.ZcY = 0;
      paramRecyclerView = paramCardHomePageNewUI.wFk;
      paramCardHomePageNewUI = paramRecyclerView;
      if (paramRecyclerView == null)
      {
        kotlin.g.b.s.bIx("mHomePageAdapter");
        paramCardHomePageNewUI = null;
      }
      paramCardHomePageNewUI.fV(paramInt);
      break;
      paramView = (MMActivity)paramCardHomePageNewUI;
      localObject = paramRecyclerView.wFO;
      kotlin.g.b.s.checkNotNull(localObject);
      com.tencent.mm.plugin.card.c.b.a(paramView, ((wb)localObject).ZcV, 0);
      paramCardHomePageNewUI.wFD = true;
      continue;
      paramView = paramRecyclerView.wFO;
      kotlin.g.b.s.checkNotNull(paramView);
      paramView = paramView.ZcW;
      com.tencent.mm.plugin.card.c.b.S(paramView.VcU, paramView.VcV, paramView.VQU);
      paramCardHomePageNewUI.wFD = true;
      continue;
      paramView = paramRecyclerView.wFO;
      kotlin.g.b.s.checkNotNull(paramView);
      Log.i("MicroMsg.CardHomePageNewUI", kotlin.g.b.s.X("click native url: ", paramView.ZcX));
      paramView = paramRecyclerView.wFO;
      kotlin.g.b.s.checkNotNull(paramView);
      if (kotlin.g.b.s.p("weixin://mktcard/cert", paramView.ZcX))
      {
        paramView = new Intent((Context)paramCardHomePageNewUI, CardTicketListUI.class);
        paramView = new com.tencent.mm.hellhoundlib.b.a().cG(paramView);
        com.tencent.mm.hellhoundlib.a.a.b(paramCardHomePageNewUI, paramView.aYi(), "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI", "initView$lambda-7", "(Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI;Landroidx/recyclerview/widget/RecyclerView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramCardHomePageNewUI.startActivity((Intent)paramView.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramCardHomePageNewUI, "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI", "initView$lambda-7", "(Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI;Landroidx/recyclerview/widget/RecyclerView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramCardHomePageNewUI.wFD = true;
      }
    }
  }
  
  private static final void a(CardHomePageNewUI paramCardHomePageNewUI, LoadMoreRecyclerView paramLoadMoreRecyclerView, RecyclerView.a parama)
  {
    AppMethodBeat.i(294065);
    kotlin.g.b.s.u(paramCardHomePageNewUI, "this$0");
    paramCardHomePageNewUI.dnS();
    AppMethodBeat.o(294065);
  }
  
  private static final void a(CardHomePageNewUI paramCardHomePageNewUI, a parama, int paramInt1, DialogInterface paramDialogInterface, int paramInt2)
  {
    AppMethodBeat.i(294094);
    kotlin.g.b.s.u(paramCardHomePageNewUI, "this$0");
    kotlin.g.b.s.u(parama, "$this_apply");
    Object localObject = parama.wFK;
    kotlin.g.b.s.checkNotNull(localObject);
    localObject = ((vw)localObject).Zcw;
    kotlin.g.b.s.s(localObject, "element!!.card_pack_merchant_id");
    kotlin.g.b.s.u(localObject, "merchantId");
    Log.i("MicroMsg.CardHomePageNewUI", "do delete merchant: %s", new Object[] { localObject });
    new com.tencent.mm.plugin.card.model.a.d((String)localObject).bFJ().b(new CardHomePageNewUI..ExternalSyntheticLambda15(paramCardHomePageNewUI, (String)localObject));
    paramDialogInterface.dismiss();
    paramDialogInterface = com.tencent.mm.plugin.report.service.h.OAn;
    parama = parama.wFK;
    kotlin.g.b.s.checkNotNull(parama);
    paramDialogInterface.b(16324, new Object[] { Integer.valueOf(2), parama.Zcw, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(9), Integer.valueOf(paramInt1), Integer.valueOf(paramCardHomePageNewUI.wvU) });
    AppMethodBeat.o(294094);
  }
  
  private static final void a(CardHomePageNewUI paramCardHomePageNewUI, a parama, int paramInt1, MenuItem paramMenuItem, int paramInt2)
  {
    AppMethodBeat.i(294101);
    kotlin.g.b.s.u(paramCardHomePageNewUI, "this$0");
    kotlin.g.b.s.u(parama, "$this_apply");
    if (paramMenuItem.getItemId() == 1)
    {
      com.tencent.mm.ui.base.k.a((Context)paramCardHomePageNewUI.getContext(), paramCardHomePageNewUI.getString(a.g.wpd), "", false, new CardHomePageNewUI..ExternalSyntheticLambda1(paramCardHomePageNewUI, parama, paramInt1));
      paramMenuItem = com.tencent.mm.plugin.report.service.h.OAn;
      parama = parama.wFK;
      kotlin.g.b.s.checkNotNull(parama);
      paramMenuItem.b(16324, new Object[] { Integer.valueOf(2), parama.Zcw, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(8), Integer.valueOf(paramInt1), Integer.valueOf(paramCardHomePageNewUI.wvU) });
    }
    AppMethodBeat.o(294101);
  }
  
  private static final void a(CardHomePageNewUI paramCardHomePageNewUI, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(294085);
    kotlin.g.b.s.u(paramCardHomePageNewUI, "this$0");
    params.c(1, (CharSequence)paramCardHomePageNewUI.getString(a.g.app_delete));
    AppMethodBeat.o(294085);
  }
  
  private static final void a(vx paramvx, CardHomePageNewUI paramCardHomePageNewUI, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(294059);
    kotlin.g.b.s.u(paramvx, "$this_apply");
    kotlin.g.b.s.u(paramCardHomePageNewUI, "this$0");
    if (paramMenuItem.getItemId() == 0) {
      switch (paramvx.ZcL)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(294059);
      return;
      com.tencent.mm.plugin.card.c.b.a((MMActivity)paramCardHomePageNewUI, paramvx.ZcM, 0);
      AppMethodBeat.o(294059);
      return;
      paramvx = paramvx.ZcN;
      com.tencent.mm.plugin.card.c.b.S(paramvx.VcU, paramvx.VcV, paramvx.VQU);
    }
  }
  
  private static final void a(vx paramvx, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(294054);
    kotlin.g.b.s.u(paramvx, "$this_apply");
    params.add(0, 0, 1, (CharSequence)paramvx.ZcK);
    AppMethodBeat.o(294054);
  }
  
  private void a(wa paramwa, we paramwe, wd paramwd)
  {
    int j = 0;
    AppMethodBeat.i(112467);
    Object localObject;
    int i;
    if (paramwa != null)
    {
      localObject = paramwa.ZcQ;
      kotlin.g.b.s.s(localObject, "card_home_page_element");
      if (!((Collection)localObject).isEmpty()) {}
      for (i = 1; i != 0; i = 0)
      {
        paramwa = paramwa.ZcQ.iterator();
        while (paramwa.hasNext())
        {
          localObject = (vw)paramwa.next();
          a locala = new a();
          locala.wFK = ((vw)localObject);
          locala.type = 0;
          this.wFs.add(locala);
        }
      }
    }
    if (paramwe != null)
    {
      paramwa = paramwe.ZcQ;
      kotlin.g.b.s.s(paramwa, "card_home_page_element");
      if (!((Collection)paramwa).isEmpty()) {}
      for (i = 1; i != 0; i = 0)
      {
        if (Util.isNullOrNil(paramwe.Zdc)) {
          paramwe.Zdc = getString(a.g.woP);
        }
        if (this.wFv == null)
        {
          this.wFv = new a();
          paramwa = this.wFv;
          kotlin.g.b.s.checkNotNull(paramwa);
          paramwa.type = 1;
        }
        paramwa = this.wFv;
        kotlin.g.b.s.checkNotNull(paramwa);
        localObject = paramwe.Zdc;
        kotlin.g.b.s.s(localObject, "section_title");
        kotlin.g.b.s.u(localObject, "<set-?>");
        paramwa.wFL = ((String)localObject);
        paramwa = paramwe.ZcQ.iterator();
        while (paramwa.hasNext())
        {
          paramwe = (vw)paramwa.next();
          localObject = new a();
          ((a)localObject).wFK = paramwe;
          ((a)localObject).type = 2;
          this.wFt.add(localObject);
        }
      }
    }
    if (paramwd != null)
    {
      paramwa = paramwd.Zdb;
      kotlin.g.b.s.s(paramwa, "card_home_page_top_cell");
      if (!((Collection)paramwa).isEmpty()) {}
      for (i = 1; i != 0; i = 0)
      {
        paramwa = paramwd.Zdb.iterator();
        i = 0;
        while (paramwa.hasNext())
        {
          paramwe = (wb)paramwa.next();
          localObject = new a();
          ((a)localObject).wFO = paramwe;
          ((a)localObject).type = 6;
          if (i == paramwd.Zdb.size() - 1) {
            ((a)localObject).wFP = true;
          }
          this.wFr.add(localObject);
          i += 1;
        }
      }
    }
    this.wFx = new a();
    paramwa = this.wFx;
    kotlin.g.b.s.checkNotNull(paramwa);
    paramwa.type = 5;
    if ((this.wFs.isEmpty()) && (this.wFt.isEmpty()))
    {
      i = j;
      if (!((Collection)this.wFr).isEmpty()) {
        i = 1;
      }
      if (i != 0)
      {
        this.wFu = new a();
        paramwa = this.wFu;
        kotlin.g.b.s.checkNotNull(paramwa);
        paramwa.type = 7;
        AppMethodBeat.o(112467);
        return;
      }
    }
    this.wFu = null;
    AppMethodBeat.o(112467);
  }
  
  private static final boolean a(CardHomePageNewUI paramCardHomePageNewUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(294050);
    kotlin.g.b.s.u(paramCardHomePageNewUI, "this$0");
    paramCardHomePageNewUI.finish();
    AppMethodBeat.o(294050);
    return false;
  }
  
  private static final boolean a(CardHomePageNewUI paramCardHomePageNewUI, vx paramvx, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(294063);
    kotlin.g.b.s.u(paramCardHomePageNewUI, "this$0");
    kotlin.g.b.s.u(paramvx, "$this_apply");
    paramMenuItem = new com.tencent.mm.ui.widget.a.f((Context)paramCardHomePageNewUI.getContext(), 1, false);
    paramMenuItem.Vtg = new CardHomePageNewUI..ExternalSyntheticLambda9(paramvx);
    paramMenuItem.GAC = new CardHomePageNewUI..ExternalSyntheticLambda12(paramvx, paramCardHomePageNewUI);
    paramMenuItem.dDn();
    AppMethodBeat.o(294063);
    return false;
  }
  
  private static final Object b(CardHomePageNewUI paramCardHomePageNewUI, String paramString, b.a parama)
  {
    AppMethodBeat.i(294131);
    kotlin.g.b.s.u(paramCardHomePageNewUI, "this$0");
    kotlin.g.b.s.u(paramString, "$merchantId");
    Log.i("MicroMsg.CardHomePageNewUI", "errtype: %s, errcode: %s", new Object[] { Integer.valueOf(parama.errType), Integer.valueOf(parama.errCode) });
    if ((parama.errType == 0) && (parama.errCode == 0))
    {
      esc localesc = parama.ott;
      parama = (ajq)localesc;
      Log.i("MicroMsg.CardHomePageNewUI", "retCode: %s", new Object[] { Integer.valueOf(parama.wuz) });
      if (parama.wuz == 0)
      {
        parama = paramCardHomePageNewUI.wFk;
        paramCardHomePageNewUI = parama;
        if (parama == null)
        {
          kotlin.g.b.s.bIx("mHomePageAdapter");
          paramCardHomePageNewUI = null;
        }
        paramCardHomePageNewUI.alc(paramString);
      }
      for (;;)
      {
        AppMethodBeat.o(294131);
        return localesc;
        com.tencent.mm.plugin.card.c.l.ar((Context)paramCardHomePageNewUI, parama.wuA);
      }
    }
    com.tencent.mm.plugin.card.c.l.as((Context)paramCardHomePageNewUI, "");
    paramCardHomePageNewUI = ah.aiuX;
    AppMethodBeat.o(294131);
    return paramCardHomePageNewUI;
  }
  
  private static final void b(CardHomePageNewUI paramCardHomePageNewUI, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(294147);
    kotlin.g.b.s.u(paramCardHomePageNewUI, "this$0");
    paramCardHomePageNewUI = paramCardHomePageNewUI.wFC.iterator();
    int i = 0;
    while (paramCardHomePageNewUI.hasNext())
    {
      params.add(0, i, 1, (CharSequence)((wo)paramCardHomePageNewUI.next()).ZdA);
      i += 1;
    }
    AppMethodBeat.o(294147);
  }
  
  private static final boolean b(CardHomePageNewUI paramCardHomePageNewUI, RecyclerView paramRecyclerView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(294113);
    kotlin.g.b.s.u(paramCardHomePageNewUI, "this$0");
    paramView = paramCardHomePageNewUI.wFk;
    paramRecyclerView = paramView;
    if (paramView == null)
    {
      kotlin.g.b.s.bIx("mHomePageAdapter");
      paramRecyclerView = null;
    }
    paramRecyclerView = paramRecyclerView.IA(paramInt);
    if (paramRecyclerView != null)
    {
      Log.i("MicroMsg.CardHomePageNewUI", "long click type: %s", new Object[] { Integer.valueOf(paramRecyclerView.type) });
      if (paramRecyclerView.type == 2)
      {
        paramView = new com.tencent.mm.ui.tools.l((Context)paramCardHomePageNewUI.getContext());
        paramView.Vtg = new CardHomePageNewUI..ExternalSyntheticLambda8(paramCardHomePageNewUI);
        paramView.GAC = new CardHomePageNewUI..ExternalSyntheticLambda11(paramCardHomePageNewUI, paramRecyclerView, paramInt);
        paramView.jDd();
        paramView = com.tencent.mm.plugin.report.service.h.OAn;
        paramRecyclerView = paramRecyclerView.wFK;
        kotlin.g.b.s.checkNotNull(paramRecyclerView);
        paramView.b(16324, new Object[] { Integer.valueOf(2), paramRecyclerView.Zcw, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(7), Integer.valueOf(paramInt), Integer.valueOf(paramCardHomePageNewUI.wvU) });
      }
    }
    AppMethodBeat.o(294113);
    return false;
  }
  
  private void dnQ()
  {
    AppMethodBeat.i(112461);
    vx localvx = this.wFE;
    if ((localvx != null) && (!Util.isNullOrNil(localvx.ZcK)))
    {
      removeAllOptionMenu();
      addIconOptionMenu(0, 0, a.f.icons_outlined_more, new CardHomePageNewUI..ExternalSyntheticLambda3(this, localvx));
    }
    AppMethodBeat.o(112461);
  }
  
  private final void dnS()
  {
    AppMethodBeat.i(112468);
    Log.i("MicroMsg.CardHomePageNewUI", "do get card Home page: %s, %s", new Object[] { Boolean.valueOf(this.wFp), Boolean.valueOf(this.isLoading) });
    Object localObject;
    if ((this.wFG) || ((!this.wFp) && (!this.isLoading)))
    {
      this.isLoading = true;
      if (this.wFG)
      {
        ViewGroup localViewGroup = this.wFn;
        localObject = localViewGroup;
        if (localViewGroup == null)
        {
          kotlin.g.b.s.bIx("mLoadingView2");
          localObject = null;
        }
        ((ViewGroup)localObject).setVisibility(0);
        if (this.wFw != null)
        {
          localViewGroup = this.wFn;
          localObject = localViewGroup;
          if (localViewGroup == null)
          {
            kotlin.g.b.s.bIx("mLoadingView2");
            localObject = null;
          }
          localObject = ((ViewGroup)localObject).getLayoutParams();
          if (localObject == null)
          {
            localObject = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            AppMethodBeat.o(112468);
            throw ((Throwable)localObject);
          }
          RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localObject;
          localLayoutParams.topMargin = com.tencent.mm.cd.a.fromDPToPix((Context)getContext(), 80);
          localViewGroup = this.wFn;
          localObject = localViewGroup;
          if (localViewGroup == null)
          {
            kotlin.g.b.s.bIx("mLoadingView2");
            localObject = null;
          }
          ((ViewGroup)localObject).setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
        }
      }
      localObject = dnR();
      if (localObject != null) {
        break label367;
      }
    }
    label367:
    for (int i = 10;; i = ((wo)localObject).Zdz)
    {
      this.wFo = i;
      if (this.pIQ != null)
      {
        localObject = this.pIQ;
        kotlin.g.b.s.checkNotNull(localObject);
        ((Dialog)localObject).dismiss();
      }
      if (this.wFs.isEmpty())
      {
        localObject = (Context)getContext();
        getContext().getString(a.g.app_empty_string);
        this.pIQ = ((Dialog)com.tencent.mm.ui.base.k.a((Context)localObject, getContext().getString(a.g.loading_tips), true, null));
      }
      this.wFH = new g(this.offset, this.wFo, getLatitude(), getLongitude(), this.wvU);
      localObject = this.wFH;
      kotlin.g.b.s.checkNotNull(localObject);
      ((com.tencent.mm.am.b)localObject).otr = true;
      ((com.tencent.mm.am.b)localObject).bFJ().b(new CardHomePageNewUI..ExternalSyntheticLambda13(this)).a((com.tencent.mm.vending.e.b)this);
      AppMethodBeat.o(112468);
      return;
    }
  }
  
  public final void at(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(112465);
    Log.i("MicroMsg.CardHomePageNewUI", "location finish: [%s, %s], ret: %s, isOk: %s", new Object[] { Float.valueOf(getLatitude()), Float.valueOf(getLongitude()), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    if (this.mgS)
    {
      if ((this.wFB == 1) && (paramInt < 0) && (this.wvU == 1))
      {
        this.wvU = 0;
        if (paramInt == -2) {
          com.tencent.mm.plugin.report.service.h.OAn.b(16322, new Object[] { Integer.valueOf(30) });
        }
      }
      dnS();
      AppMethodBeat.o(112465);
      return;
    }
    if (!paramBoolean) {
      doo();
    }
    AppMethodBeat.o(112465);
  }
  
  public final wo dnR()
  {
    AppMethodBeat.i(112466);
    Iterator localIterator = this.wFC.iterator();
    while (localIterator.hasNext())
    {
      wo localwo = (wo)localIterator.next();
      if (localwo.Zdy == this.wvU)
      {
        AppMethodBeat.o(112466);
        return localwo;
      }
    }
    AppMethodBeat.o(112466);
    return null;
  }
  
  public final int getLayoutId()
  {
    return a.e.wmS;
  }
  
  public final void initView()
  {
    int j = 1;
    Object localObject3 = null;
    AppMethodBeat.i(112464);
    Object localObject1 = findViewById(a.d.wiP);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.chpu_rv)");
    this.wFj = ((LoadMoreRecyclerView)localObject1);
    localObject1 = this.wFj;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("mRecyclerView");
      localObject1 = null;
      getContext();
      ((LoadMoreRecyclerView)localObject1).setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
      this.wFk = new d();
      localObject1 = this.wFj;
      if (localObject1 != null) {
        break label205;
      }
      kotlin.g.b.s.bIx("mRecyclerView");
      localObject1 = null;
    }
    Object localObject4;
    Object localObject2;
    label205:
    for (;;)
    {
      localObject4 = this.wFk;
      localObject2 = localObject4;
      if (localObject4 == null)
      {
        kotlin.g.b.s.bIx("mHomePageAdapter");
        localObject2 = null;
      }
      ((LoadMoreRecyclerView)localObject1).setAdapter((RecyclerView.a)localObject2);
      localObject4 = LayoutInflater.from((Context)this);
      i = a.e.wmP;
      localObject2 = this.wFj;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("mRecyclerView");
        localObject1 = null;
      }
      localObject1 = ((LayoutInflater)localObject4).inflate(i, (ViewGroup)localObject1, false);
      if (localObject1 != null) {
        break label208;
      }
      localObject1 = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(112464);
      throw ((Throwable)localObject1);
      break;
    }
    label208:
    this.wFl = ((ViewGroup)localObject1);
    localObject1 = findViewById(a.d.wiO);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.chpu_loading_layout)");
    this.wFn = ((ViewGroup)localObject1);
    localObject1 = this.wFj;
    wp localwp;
    Object localObject5;
    Object localObject6;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("mRecyclerView");
      localObject1 = null;
      localObject4 = this.wFl;
      localObject2 = localObject4;
      if (localObject4 == null)
      {
        kotlin.g.b.s.bIx("mLoadingView");
        localObject2 = null;
      }
      ((LoadMoreRecyclerView)localObject1).setLoadingView((View)localObject2);
      this.wFm = ((RecyclerView.h)new f(this));
      localObject2 = this.wFj;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("mRecyclerView");
        localObject1 = null;
      }
      localObject4 = this.wFm;
      localObject2 = localObject4;
      if (localObject4 == null)
      {
        kotlin.g.b.s.bIx("mDivider");
        localObject2 = null;
      }
      ((RecyclerView)localObject1).a((RecyclerView.h)localObject2);
      localObject2 = this.wFj;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("mRecyclerView");
        localObject1 = null;
      }
      ((LoadMoreRecyclerView)localObject1).setOnLoadingStateChangedListener(new CardHomePageNewUI..ExternalSyntheticLambda4(this));
      localObject2 = this.wFj;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("mRecyclerView");
        localObject1 = null;
      }
      ((LoadMoreRecyclerView)localObject1).setOnItemClickListener(new CardHomePageNewUI..ExternalSyntheticLambda5(this));
      localObject2 = this.wFj;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("mRecyclerView");
        localObject1 = null;
      }
      ((LoadMoreRecyclerView)localObject1).setOnItemLongClickListener(new CardHomePageNewUI..ExternalSyntheticLambda6(this));
      localObject1 = new wa();
      localObject2 = new we();
      localObject4 = new wd();
      localwp = new wp();
      localObject5 = com.tencent.mm.plugin.card.model.a.a.wvG;
      localObject5 = this.wFE;
      kotlin.g.b.s.u(localObject1, "storeList");
      kotlin.g.b.s.u(localObject2, "underList");
      kotlin.g.b.s.u(localObject4, "topList");
      kotlin.g.b.s.u(localwp, "cardSortInfoList");
      Log.i(com.tencent.mm.plugin.card.model.a.a.access$getTAG$cp(), "load home page snapshot");
      localObject6 = (String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acXC, null);
      if (localObject6 == null) {
        break label973;
      }
      localObject6 = ((String)localObject6).getBytes(kotlin.n.d.ISO_8859_1);
      kotlin.g.b.s.s(localObject6, "(this as java.lang.String).getBytes(charset)");
      ((wa)localObject1).parseFrom((byte[])localObject6);
    }
    label973:
    for (int i = 1;; i = 0)
    {
      localObject6 = (String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acXD, null);
      if (localObject6 != null)
      {
        localObject6 = ((String)localObject6).getBytes(kotlin.n.d.ISO_8859_1);
        kotlin.g.b.s.s(localObject6, "(this as java.lang.String).getBytes(charset)");
        ((we)localObject2).parseFrom((byte[])localObject6);
        i = 1;
      }
      localObject6 = (String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acXE, null);
      if (localObject6 != null)
      {
        localObject6 = ((String)localObject6).getBytes(kotlin.n.d.ISO_8859_1);
        kotlin.g.b.s.s(localObject6, "(this as java.lang.String).getBytes(charset)");
        ((wd)localObject4).parseFrom((byte[])localObject6);
        i = 1;
      }
      localObject6 = (String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acXF, null);
      if (localObject6 != null)
      {
        localObject6 = ((String)localObject6).getBytes(kotlin.n.d.ISO_8859_1);
        kotlin.g.b.s.s(localObject6, "(this as java.lang.String).getBytes(charset)");
        localwp.parseFrom((byte[])localObject6);
        i = 1;
      }
      localObject6 = (String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acXG, null);
      if (localObject6 != null)
      {
        i = j;
        if (localObject5 != null)
        {
          localObject6 = ((String)localObject6).getBytes(kotlin.n.d.ISO_8859_1);
          kotlin.g.b.s.s(localObject6, "(this as java.lang.String).getBytes(charset)");
          ((vx)localObject5).parseFrom((byte[])localObject6);
          i = j;
        }
      }
      for (;;)
      {
        this.wFC.clear();
        this.wFC.addAll((Collection)localwp.ZdB);
        a((wa)localObject1, (we)localObject2, (wd)localObject4);
        if ((i == 0) && (this.wFs.isEmpty()) && (this.wFt.isEmpty()))
        {
          Log.i("MicroMsg.CardHomePageNewUI", "show init view");
          localObject1 = new a();
          ((a)localObject1).type = 3;
          localObject2 = new a();
          ((a)localObject2).type = 3;
          this.wFs.add(localObject1);
          this.wFs.add(localObject2);
        }
        dnQ();
        localObject1 = this.wFj;
        if (localObject1 == null)
        {
          kotlin.g.b.s.bIx("mRecyclerView");
          localObject1 = localObject3;
        }
        for (;;)
        {
          localObject1 = ((LoadMoreRecyclerView)localObject1).getAdapter();
          if (localObject1 != null) {
            ((RecyclerView.a)localObject1).bZE.notifyChanged();
          }
          AppMethodBeat.o(112464);
          return;
          break;
        }
      }
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(112460);
    fixStatusbar(true);
    super.onCreate(paramBundle);
    hideActionbarLine();
    setMMTitle(a.g.woX);
    this.scene = getIntent().getIntExtra("key_home_page_from_scene", 0);
    initView();
    this.wFB = 1;
    this.wvU = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.acYe, 1);
    if (this.wvU == 0) {
      this.wvU = 1;
    }
    if (this.wFB == 1) {
      com.tencent.mm.plugin.report.service.h.OAn.b(16322, new Object[] { Integer.valueOf(14) });
    }
    Log.i("MicroMsg.CardHomePageNewUI", "on create, scene: %s", new Object[] { Integer.valueOf(this.scene) });
    setBackBtn(new CardHomePageNewUI..ExternalSyntheticLambda2(this));
    com.tencent.mm.plugin.report.service.h.OAn.b(16322, new Object[] { Integer.valueOf(4) });
    ((com.tencent.mm.pluginsdk.wallet.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.pluginsdk.wallet.b.class)).jO(8, 2);
    AppMethodBeat.o(112460);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(112462);
    super.onDestroy();
    com.tencent.mm.kernel.h.baE().ban().set(at.a.acYe, Integer.valueOf(this.wvU));
    if (this.wFH != null)
    {
      localObject1 = this.wFH;
      kotlin.g.b.s.checkNotNull(localObject1);
      ((g)localObject1).cancel();
      this.wFH = null;
    }
    j.dky();
    Log.i("MicroMsg.CardHomePageNewUI", "do save snap shot");
    Object localObject2 = new wa();
    ((wa)localObject2).ZcQ = new LinkedList();
    Object localObject1 = this.wFs.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = ((a)((Iterator)localObject1).next()).wFK;
      if (localObject3 != null) {
        ((wa)localObject2).ZcQ.add(localObject3);
      }
    }
    Object localObject3 = new we();
    localObject1 = this.wFv;
    if (localObject1 == null) {}
    for (localObject1 = null;; localObject1 = ((a)localObject1).dnV())
    {
      ((we)localObject3).Zdc = ((String)localObject1);
      ((we)localObject3).ZcQ = new LinkedList();
      localObject1 = this.wFt.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject4 = ((a)((Iterator)localObject1).next()).wFK;
        if (localObject4 != null) {
          ((we)localObject3).ZcQ.add(localObject4);
        }
      }
    }
    Object localObject4 = new wd();
    localObject1 = this.wFr.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject5 = ((a)((Iterator)localObject1).next()).wFO;
      if (localObject5 != null) {
        ((wd)localObject4).Zdb.add(localObject5);
      }
    }
    Object localObject5 = new wp();
    ((wp)localObject5).ZdB.addAll((Collection)this.wFC);
    localObject1 = com.tencent.mm.plugin.card.model.a.a.wvG;
    localObject1 = this.wFE;
    kotlin.g.b.s.u(localObject2, "storeList");
    kotlin.g.b.s.u(localObject3, "underList");
    kotlin.g.b.s.u(localObject4, "topList");
    kotlin.g.b.s.u(localObject5, "sortInfoList");
    Log.i(com.tencent.mm.plugin.card.model.a.a.access$getTAG$cp(), "save home page snapshot");
    localObject2 = ((wa)localObject2).toByteArray();
    kotlin.g.b.s.s(localObject2, "storeList.toByteArray()");
    localObject2 = new String((byte[])localObject2, kotlin.n.d.ISO_8859_1);
    com.tencent.mm.kernel.h.baE().ban().set(at.a.acXC, localObject2);
    localObject2 = ((we)localObject3).toByteArray();
    kotlin.g.b.s.s(localObject2, "underList.toByteArray()");
    localObject2 = new String((byte[])localObject2, kotlin.n.d.ISO_8859_1);
    com.tencent.mm.kernel.h.baE().ban().set(at.a.acXD, localObject2);
    localObject2 = ((wd)localObject4).toByteArray();
    kotlin.g.b.s.s(localObject2, "topList.toByteArray()");
    localObject2 = new String((byte[])localObject2, kotlin.n.d.ISO_8859_1);
    com.tencent.mm.kernel.h.baE().ban().set(at.a.acXE, localObject2);
    localObject2 = ((wp)localObject5).toByteArray();
    kotlin.g.b.s.s(localObject2, "sortInfoList.toByteArray()");
    localObject2 = new String((byte[])localObject2, kotlin.n.d.ISO_8859_1);
    com.tencent.mm.kernel.h.baE().ban().set(at.a.acXF, localObject2);
    if (localObject1 != null)
    {
      localObject1 = ((vx)localObject1).toByteArray();
      kotlin.g.b.s.s(localObject1, "faqItem.toByteArray()");
      localObject1 = new String((byte[])localObject1, kotlin.n.d.ISO_8859_1);
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acXG, localObject1);
    }
    AppMethodBeat.o(112462);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(112463);
    super.onResume();
    if ((this.wFy) && (this.wFF != null) && (this.wFz != -1))
    {
      Object localObject = this.wFF;
      kotlin.g.b.s.checkNotNull(localObject);
      localObject = ((vw)localObject).Zcw;
      kotlin.g.b.s.s(localObject, "clickedCardHomePageElement!!.card_pack_merchant_id");
      vw localvw = this.wFF;
      kotlin.g.b.s.checkNotNull(localvw);
      long l = localvw.ZcJ;
      Log.i("MicroMsg.CardHomePageNewUI", "do get mch infoset: %s", new Object[] { localObject });
      new com.tencent.mm.plugin.card.model.a.f((String)localObject, l, getLatitude(), getLongitude(), this.wvU).bFJ().b(new CardHomePageNewUI..ExternalSyntheticLambda14(this, (String)localObject));
      this.wFy = false;
      this.wFF = null;
      AppMethodBeat.o(112463);
      return;
    }
    if (this.wFD)
    {
      this.wFG = true;
      this.offset = 0;
      this.wFD = false;
      dnS();
    }
    AppMethodBeat.o(112463);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$CardListModel;", "", "(Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI;)V", "element", "Lcom/tencent/mm/protocal/protobuf/CardHomePageElement;", "getElement", "()Lcom/tencent/mm/protocal/protobuf/CardHomePageElement;", "setElement", "(Lcom/tencent/mm/protocal/protobuf/CardHomePageElement;)V", "expandState", "", "getExpandState", "()Z", "setExpandState", "(Z)V", "hasRender", "getHasRender", "setHasRender", "sectionTitle", "", "getSectionTitle", "()Ljava/lang/String;", "setSectionTitle", "(Ljava/lang/String;)V", "showDivider", "getShowDivider", "setShowDivider", "topElement", "Lcom/tencent/mm/protocal/protobuf/CardHomePageTopCell;", "getTopElement", "()Lcom/tencent/mm/protocal/protobuf/CardHomePageTopCell;", "setTopElement", "(Lcom/tencent/mm/protocal/protobuf/CardHomePageTopCell;)V", "type", "", "getType", "()I", "setType", "(I)V", "plugin-card_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class a
  {
    int type;
    vw wFK;
    public String wFL;
    boolean wFM;
    boolean wFN;
    wb wFO;
    boolean wFP;
    
    public a()
    {
      AppMethodBeat.i(294060);
      AppMethodBeat.o(294060);
    }
    
    public final String dnV()
    {
      AppMethodBeat.i(112404);
      String str = this.wFL;
      if (str != null)
      {
        AppMethodBeat.o(112404);
        return str;
      }
      kotlin.g.b.s.bIx("sectionTitle");
      AppMethodBeat.o(112404);
      return null;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH;", "Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI;", "(Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI;)V", "appendUnderList", "", "model", "Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$CardListModel;", "getItemCount", "", "getItemViewType", "position", "getModelByPos", "getPosByMerchantId", "merchantId", "", "moveStoreToUnderList", "", "element", "Lcom/tencent/mm/protocal/protobuf/CardHomePageElement;", "onBindViewHolder", "holder", "payloads", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "removeModelByMId", "removeTitleSection", "replaceModelByMId", "mchInfo", "plugin-card_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class d
    extends RecyclerView.a<CardHomePageNewUI.e>
  {
    public d()
    {
      AppMethodBeat.i(294052);
      AppMethodBeat.o(294052);
    }
    
    private int ald(String paramString)
    {
      int k = 0;
      AppMethodBeat.i(112415);
      kotlin.g.b.s.u(paramString, "merchantId");
      if (CardHomePageNewUI.h(this.wFQ) != null) {}
      for (int i = 1;; i = 0)
      {
        if (CardHomePageNewUI.g(this.wFQ) != null) {
          i += 1;
        }
        for (;;)
        {
          Iterator localIterator = CardHomePageNewUI.c(this.wFQ).iterator();
          int j = 0;
          for (;;)
          {
            Object localObject;
            if (localIterator.hasNext())
            {
              localObject = ((CardHomePageNewUI.a)localIterator.next()).wFK;
              if (localObject == null) {}
              for (localObject = null; kotlin.g.b.s.p(localObject, paramString); localObject = ((vw)localObject).Zcw)
              {
                AppMethodBeat.o(112415);
                return i + j;
              }
            }
            i = CardHomePageNewUI.c(this.wFQ).size() + i - 1;
            if (CardHomePageNewUI.e(this.wFQ) != null) {
              i += 1;
            }
            for (;;)
            {
              localIterator = CardHomePageNewUI.d(this.wFQ).iterator();
              j = k;
              for (;;)
              {
                if (localIterator.hasNext())
                {
                  localObject = ((CardHomePageNewUI.a)localIterator.next()).wFK;
                  if (localObject == null) {}
                  for (localObject = null; kotlin.g.b.s.p(localObject, paramString); localObject = ((vw)localObject).Zcw)
                  {
                    AppMethodBeat.o(112415);
                    return i + j + 1;
                  }
                }
                AppMethodBeat.o(112415);
                return -1;
                j += 1;
              }
            }
            j += 1;
          }
        }
      }
    }
    
    public final CardHomePageNewUI.a IA(int paramInt)
    {
      int j = 0;
      AppMethodBeat.i(112413);
      Object localObject1 = CardHomePageNewUI.c(this.wFQ);
      Object localObject2;
      if (localObject1 == null)
      {
        localObject1 = null;
        localObject2 = CardHomePageNewUI.c(this.wFQ);
        if (localObject2 != null) {
          break label149;
        }
        localObject2 = null;
        label41:
        if (CardHomePageNewUI.e(this.wFQ) == null) {
          break label162;
        }
      }
      label149:
      label162:
      for (boolean bool = true;; bool = false)
      {
        Log.d("MicroMsg.CardHomePageNewUI", "pos: %s, sSize: %s, uSize: %s, title: %s", new Object[] { Integer.valueOf(paramInt), localObject1, localObject2, Boolean.valueOf(bool) });
        localObject1 = CardHomePageNewUI.h(this.wFQ);
        if (localObject1 == null) {
          break label174;
        }
        if (paramInt + 0 >= ((ArrayList)localObject1).size()) {
          break label168;
        }
        localObject1 = (CardHomePageNewUI.a)((ArrayList)localObject1).get(paramInt + 0);
        AppMethodBeat.o(112413);
        return localObject1;
        localObject1 = Integer.valueOf(((ArrayList)localObject1).size());
        break;
        localObject2 = Integer.valueOf(((ArrayList)localObject2).size());
        break label41;
      }
      label168:
      j = ((ArrayList)localObject1).size();
      label174:
      localObject1 = CardHomePageNewUI.g(this.wFQ);
      int i = j;
      if (localObject1 != null)
      {
        if (paramInt == j)
        {
          AppMethodBeat.o(112413);
          return localObject1;
        }
        i = j + 1;
      }
      localObject1 = CardHomePageNewUI.i(this.wFQ);
      if ((localObject1 != null) && (paramInt == i))
      {
        AppMethodBeat.o(112413);
        return localObject1;
      }
      localObject1 = CardHomePageNewUI.c(this.wFQ);
      j = i;
      if (localObject1 != null)
      {
        if (paramInt - i < ((ArrayList)localObject1).size())
        {
          localObject1 = (CardHomePageNewUI.a)((ArrayList)localObject1).get(paramInt - i);
          AppMethodBeat.o(112413);
          return localObject1;
        }
        j = ((ArrayList)localObject1).size() - 1;
      }
      i = j;
      if (CardHomePageNewUI.e(this.wFQ) != null)
      {
        localObject1 = this.wFQ;
        j += 1;
        i = j;
        if (paramInt == j)
        {
          localObject1 = CardHomePageNewUI.e((CardHomePageNewUI)localObject1);
          AppMethodBeat.o(112413);
          return localObject1;
        }
      }
      localObject1 = CardHomePageNewUI.d(this.wFQ);
      if ((localObject1 != null) && (paramInt > i) && (paramInt <= ((ArrayList)localObject1).size() + i))
      {
        localObject1 = (CardHomePageNewUI.a)((ArrayList)localObject1).get(paramInt - i - 1);
        AppMethodBeat.o(112413);
        return localObject1;
      }
      AppMethodBeat.o(112413);
      return null;
    }
    
    public final void a(String paramString, vw paramvw)
    {
      Object localObject2 = null;
      Iterator localIterator = null;
      AppMethodBeat.i(112416);
      kotlin.g.b.s.u(paramString, "merchantId");
      kotlin.g.b.s.u(paramvw, "mchInfo");
      Object localObject3 = CardHomePageNewUI.c(this.wFQ).iterator();
      Object localObject1;
      label72:
      int i;
      if (((Iterator)localObject3).hasNext())
      {
        CardHomePageNewUI.a locala = (CardHomePageNewUI.a)((Iterator)localObject3).next();
        localObject1 = locala.wFK;
        if (localObject1 == null)
        {
          localObject1 = null;
          if (!kotlin.g.b.s.p(localObject1, paramString)) {
            break label148;
          }
          locala.wFK = paramvw;
          i = ald(paramString);
          if (i >= 0)
          {
            paramString = CardHomePageNewUI.b(this.wFQ);
            if (paramString != null) {
              break label150;
            }
            kotlin.g.b.s.bIx("mRecyclerView");
            paramString = localIterator;
          }
        }
        label148:
        label150:
        for (;;)
        {
          paramString = paramString.getAdapter();
          if (paramString != null) {
            paramString.t(i, Boolean.TRUE);
          }
          AppMethodBeat.o(112416);
          return;
          localObject1 = ((vw)localObject1).Zcw;
          break label72;
          break;
        }
      }
      localIterator = CardHomePageNewUI.d(this.wFQ).iterator();
      if (localIterator.hasNext())
      {
        localObject3 = (CardHomePageNewUI.a)localIterator.next();
        localObject1 = ((CardHomePageNewUI.a)localObject3).wFK;
        if (localObject1 == null)
        {
          localObject1 = null;
          label202:
          if (!kotlin.g.b.s.p(localObject1, paramString)) {
            break label278;
          }
          ((CardHomePageNewUI.a)localObject3).wFK = paramvw;
          i = ald(paramString);
          if (i >= 0)
          {
            paramString = CardHomePageNewUI.b(this.wFQ);
            if (paramString != null) {
              break label280;
            }
            kotlin.g.b.s.bIx("mRecyclerView");
            paramString = localObject2;
          }
        }
        label278:
        label280:
        for (;;)
        {
          paramString = paramString.getAdapter();
          if (paramString != null) {
            paramString.t(i, Boolean.TRUE);
          }
          AppMethodBeat.o(112416);
          return;
          localObject1 = ((vw)localObject1).Zcw;
          break label202;
          break;
        }
      }
      AppMethodBeat.o(112416);
    }
    
    public final void alc(String paramString)
    {
      Object localObject2 = null;
      Iterator localIterator = null;
      AppMethodBeat.i(112414);
      kotlin.g.b.s.u(paramString, "merchantId");
      Object localObject3 = CardHomePageNewUI.c(this.wFQ).iterator();
      Object localObject1;
      if (((Iterator)localObject3).hasNext())
      {
        CardHomePageNewUI.a locala = (CardHomePageNewUI.a)((Iterator)localObject3).next();
        localObject1 = locala.wFK;
        if (localObject1 == null)
        {
          localObject1 = null;
          label62:
          if (!kotlin.g.b.s.p(localObject1, paramString)) {
            break label131;
          }
          CardHomePageNewUI.c(this.wFQ).remove(locala);
          paramString = CardHomePageNewUI.b(this.wFQ);
          if (paramString != null) {
            break label133;
          }
          kotlin.g.b.s.bIx("mRecyclerView");
          paramString = localIterator;
        }
        label131:
        label133:
        for (;;)
        {
          paramString = paramString.getAdapter();
          if (paramString != null) {
            paramString.bZE.notifyChanged();
          }
          AppMethodBeat.o(112414);
          return;
          localObject1 = ((vw)localObject1).Zcw;
          break label62;
          break;
        }
      }
      localIterator = CardHomePageNewUI.d(this.wFQ).iterator();
      if (localIterator.hasNext())
      {
        localObject3 = (CardHomePageNewUI.a)localIterator.next();
        localObject1 = ((CardHomePageNewUI.a)localObject3).wFK;
        if (localObject1 == null)
        {
          localObject1 = null;
          label182:
          if (!kotlin.g.b.s.p(localObject1, paramString)) {
            break label270;
          }
          CardHomePageNewUI.d(this.wFQ).remove(localObject3);
          if (CardHomePageNewUI.d(this.wFQ).size() == 0)
          {
            CardHomePageNewUI.j(this.wFQ);
            paramString = CardHomePageNewUI.b(this.wFQ);
            if (paramString != null) {
              break label272;
            }
            kotlin.g.b.s.bIx("mRecyclerView");
            paramString = localObject2;
          }
        }
        label270:
        label272:
        for (;;)
        {
          paramString = paramString.getAdapter();
          if (paramString != null) {
            paramString.bZE.notifyChanged();
          }
          AppMethodBeat.o(112414);
          return;
          localObject1 = ((vw)localObject1).Zcw;
          break label182;
          break;
        }
      }
      AppMethodBeat.o(112414);
    }
    
    public final int getItemCount()
    {
      int i2 = 1;
      AppMethodBeat.i(112409);
      ArrayList localArrayList = CardHomePageNewUI.c(this.wFQ);
      if (localArrayList != null) {}
      for (int i = localArrayList.size();; i = 0)
      {
        localArrayList = CardHomePageNewUI.d(this.wFQ);
        if (localArrayList != null) {}
        for (int j = localArrayList.size();; j = 0)
        {
          if (CardHomePageNewUI.e(this.wFQ) != null) {}
          for (int k = 1;; k = 0)
          {
            if (CardHomePageNewUI.f(this.wFQ) != null) {}
            for (int m = 1;; m = 0)
            {
              if (CardHomePageNewUI.g(this.wFQ) != null) {}
              for (int n = 1;; n = 0)
              {
                localArrayList = CardHomePageNewUI.h(this.wFQ);
                if (localArrayList != null) {}
                for (int i1 = localArrayList.size();; i1 = 0)
                {
                  if (CardHomePageNewUI.i(this.wFQ) != null) {}
                  for (;;)
                  {
                    AppMethodBeat.o(112409);
                    return i + j + k + m + n + i1 + i2;
                    i2 = 0;
                  }
                }
              }
            }
          }
        }
      }
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(112410);
      CardHomePageNewUI.a locala = IA(paramInt);
      if (locala != null)
      {
        paramInt = locala.type;
        AppMethodBeat.o(112410);
        return paramInt;
      }
      AppMethodBeat.o(112410);
      return 3;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "viewType", "", "(Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI;Landroid/view/View;I)V", "chpiCouponLayout", "Landroid/widget/LinearLayout;", "getChpiCouponLayout", "()Landroid/widget/LinearLayout;", "setChpiCouponLayout", "(Landroid/widget/LinearLayout;)V", "chpiDescTv", "Landroid/widget/TextView;", "getChpiDescTv", "()Landroid/widget/TextView;", "setChpiDescTv", "(Landroid/widget/TextView;)V", "chpiExpandIv", "Landroid/widget/ImageView;", "getChpiExpandIv", "()Landroid/widget/ImageView;", "setChpiExpandIv", "(Landroid/widget/ImageView;)V", "chpiExpandLayout", "getChpiExpandLayout", "setChpiExpandLayout", "chpiExpandTv", "getChpiExpandTv", "setChpiExpandTv", "chpiHeaderLayout", "getChpiHeaderLayout", "setChpiHeaderLayout", "chpiLabelLayout", "getChpiLabelLayout", "setChpiLabelLayout", "chpiLogoIv", "Lcom/tencent/mm/pluginsdk/ui/applet/CdnImageView;", "getChpiLogoIv", "()Lcom/tencent/mm/pluginsdk/ui/applet/CdnImageView;", "setChpiLogoIv", "(Lcom/tencent/mm/pluginsdk/ui/applet/CdnImageView;)V", "chpiMchLabelTv", "Lcom/tencent/mm/plugin/card/ui/v2/CardLabelTextView;", "getChpiMchLabelTv", "()Lcom/tencent/mm/plugin/card/ui/v2/CardLabelTextView;", "setChpiMchLabelTv", "(Lcom/tencent/mm/plugin/card/ui/v2/CardLabelTextView;)V", "chpiNameTv", "getChpiNameTv", "setChpiNameTv", "chtiDescTv", "getChtiDescTv", "setChtiDescTv", "chtiDivider", "getChtiDivider", "()Landroid/view/View;", "setChtiDivider", "(Landroid/view/View;)V", "chtiIconIv", "getChtiIconIv", "setChtiIconIv", "chtiNewTv", "getChtiNewTv", "setChtiNewTv", "chtiRedDotIv", "getChtiRedDotIv", "setChtiRedDotIv", "chtiRightIv", "getChtiRightIv", "setChtiRightIv", "chtiTitleTv", "getChtiTitleTv", "setChtiTitleTv", "model", "Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$CardListModel;", "Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI;", "getModel", "()Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$CardListModel;", "setModel", "(Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$CardListModel;)V", "sectionTitleTv", "getSectionTitleTv", "setSectionTitleTv", "addCouponView", "", "view", "appendCouponView", "offset", "len", "position", "collapseCouponLayout", "expandCouponLayout", "gotoCardDetailUI", "cardId", "", "setCardBg", "imageView", "url", "radius", "", "defaultRes", "setIcon", "useBackendExpandState", "", "showCollapseLayout", "showExpandLayout", "showMiniAppLayout", "updateCardLabelLayout", "couponLabelList", "", "Lcom/tencent/mm/protocal/protobuf/CardElementCouponLabel;", "labelLayout", "labelList", "Lcom/tencent/mm/protocal/protobuf/CardElementMchLabel;", "updateExpandLayout", "isExpended", "plugin-card_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class e
    extends RecyclerView.v
  {
    public TextView wFR;
    public CdnImageView wFS;
    public TextView wFT;
    public TextView wFU;
    public LinearLayout wFV;
    public LinearLayout wFW;
    public LinearLayout wFX;
    public LinearLayout wFY;
    public TextView wFZ;
    public ImageView wGa;
    public CardLabelTextView wGb;
    public ImageView wGc;
    public TextView wGd;
    public TextView wGe;
    public ImageView wGf;
    public ImageView wGg;
    public TextView wGh;
    public View wGi;
    private CardHomePageNewUI.a wGj;
    
    public e(int paramInt)
    {
      super();
      AppMethodBeat.i(112438);
      int i;
      switch (i)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(112438);
        return;
        this$1 = paramInt.findViewById(a.d.wiB);
        kotlin.g.b.s.s(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_logo_iv)");
        a((CdnImageView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(a.d.wiE);
        kotlin.g.b.s.s(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_username_tv)");
        m((TextView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(a.d.wiv);
        kotlin.g.b.s.s(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_desc_tv)");
        n((TextView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(a.d.wiA);
        kotlin.g.b.s.s(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_label_layout)");
        this$1 = (LinearLayout)CardHomePageNewUI.this;
        kotlin.g.b.s.u(CardHomePageNewUI.this, "<set-?>");
        this.wFW = CardHomePageNewUI.this;
        this$1 = paramInt.findViewById(a.d.wiu);
        kotlin.g.b.s.s(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_coupon_layout)");
        this$1 = (LinearLayout)CardHomePageNewUI.this;
        kotlin.g.b.s.u(CardHomePageNewUI.this, "<set-?>");
        this.wFX = CardHomePageNewUI.this;
        this$1 = paramInt.findViewById(a.d.wix);
        kotlin.g.b.s.s(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_expand_layout)");
        this$1 = (LinearLayout)CardHomePageNewUI.this;
        kotlin.g.b.s.u(CardHomePageNewUI.this, "<set-?>");
        this.wFY = CardHomePageNewUI.this;
        this$1 = paramInt.findViewById(a.d.wiw);
        kotlin.g.b.s.s(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_expand_iv)");
        this$1 = (ImageView)CardHomePageNewUI.this;
        kotlin.g.b.s.u(CardHomePageNewUI.this, "<set-?>");
        this.wGa = CardHomePageNewUI.this;
        this$1 = paramInt.findViewById(a.d.wiy);
        kotlin.g.b.s.s(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_expand_tv)");
        this$1 = (TextView)CardHomePageNewUI.this;
        kotlin.g.b.s.u(CardHomePageNewUI.this, "<set-?>");
        this.wFZ = CardHomePageNewUI.this;
        this$1 = paramInt.findViewById(a.d.wiC);
        kotlin.g.b.s.s(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_mch_label_tv)");
        a((CardLabelTextView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(a.d.wiz);
        kotlin.g.b.s.s(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_header_layout)");
        this$1 = (LinearLayout)CardHomePageNewUI.this;
        kotlin.g.b.s.u(CardHomePageNewUI.this, "<set-?>");
        this.wFV = CardHomePageNewUI.this;
        AppMethodBeat.o(112438);
        return;
        this$1 = paramInt.findViewById(a.d.wiD);
        kotlin.g.b.s.s(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_section_title)");
        this$1 = (TextView)CardHomePageNewUI.this;
        kotlin.g.b.s.u(CardHomePageNewUI.this, "<set-?>");
        this.wFR = CardHomePageNewUI.this;
        AppMethodBeat.o(112438);
        return;
        this$1 = paramInt.findViewById(a.d.wiB);
        kotlin.g.b.s.s(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_logo_iv)");
        a((CdnImageView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(a.d.wiE);
        kotlin.g.b.s.s(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_username_tv)");
        m((TextView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(a.d.wiv);
        kotlin.g.b.s.s(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_desc_tv)");
        n((TextView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(a.d.wiC);
        kotlin.g.b.s.s(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_mch_label_tv)");
        a((CardLabelTextView)CardHomePageNewUI.this);
        AppMethodBeat.o(112438);
        return;
        this$1 = paramInt.findViewById(a.d.wiB);
        kotlin.g.b.s.s(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_logo_iv)");
        a((CdnImageView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(a.d.wiE);
        kotlin.g.b.s.s(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_username_tv)");
        m((TextView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(a.d.wiv);
        kotlin.g.b.s.s(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_desc_tv)");
        n((TextView)CardHomePageNewUI.this);
        AppMethodBeat.o(112438);
        return;
        this$1 = paramInt.findViewById(a.d.wjh);
        kotlin.g.b.s.s(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_icon_iv)");
        g((ImageView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(a.d.wjl);
        kotlin.g.b.s.s(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_title_tv)");
        o((TextView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(a.d.wjf);
        kotlin.g.b.s.s(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_desc_tv)");
        p((TextView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(a.d.wjk);
        kotlin.g.b.s.s(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_right_iv)");
        h((ImageView)CardHomePageNewUI.this);
        AppMethodBeat.o(112438);
        return;
        this$1 = paramInt.findViewById(a.d.wjh);
        kotlin.g.b.s.s(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_icon_iv)");
        g((ImageView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(a.d.wjl);
        kotlin.g.b.s.s(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_title_tv)");
        o((TextView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(a.d.wjf);
        kotlin.g.b.s.s(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_desc_tv)");
        p((TextView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(a.d.wjk);
        kotlin.g.b.s.s(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_right_iv)");
        h((ImageView)CardHomePageNewUI.this);
        AppMethodBeat.o(112438);
        return;
        this$1 = paramInt.findViewById(a.d.wjh);
        kotlin.g.b.s.s(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_icon_iv)");
        g((ImageView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(a.d.wjl);
        kotlin.g.b.s.s(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_title_tv)");
        o((TextView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(a.d.wjf);
        kotlin.g.b.s.s(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_desc_tv)");
        p((TextView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(a.d.wjk);
        kotlin.g.b.s.s(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_right_iv)");
        h((ImageView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(a.d.wjj);
        kotlin.g.b.s.s(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_reddot_iv)");
        this$1 = (ImageView)CardHomePageNewUI.this;
        kotlin.g.b.s.u(CardHomePageNewUI.this, "<set-?>");
        this.wGg = CardHomePageNewUI.this;
        this$1 = paramInt.findViewById(a.d.wji);
        kotlin.g.b.s.s(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_new_tv)");
        this$1 = (TextView)CardHomePageNewUI.this;
        kotlin.g.b.s.u(CardHomePageNewUI.this, "<set-?>");
        this.wGh = CardHomePageNewUI.this;
        this$1 = paramInt.findViewById(a.d.wjg);
        kotlin.g.b.s.s(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_divider)");
        kotlin.g.b.s.u(CardHomePageNewUI.this, "<set-?>");
        this.wGi = CardHomePageNewUI.this;
      }
    }
    
    private final void E(boolean paramBoolean, int paramInt)
    {
      AppMethodBeat.i(112437);
      Object localObject = this.wGj;
      kotlin.g.b.s.checkNotNull(localObject);
      localObject = ((CardHomePageNewUI.a)localObject).wFK;
      if (paramBoolean)
      {
        if (localObject == null) {}
        for (localObject = null; !Util.isNullOrNil((String)localObject); localObject = ((vw)localObject).ZcC)
        {
          IB(paramInt);
          AppMethodBeat.o(112437);
          return;
        }
        ID(paramInt);
        AppMethodBeat.o(112437);
        return;
      }
      IC(paramInt);
      AppMethodBeat.o(112437);
    }
    
    private final void IB(int paramInt)
    {
      AppMethodBeat.i(112434);
      Object localObject = this.wGj;
      kotlin.g.b.s.checkNotNull(localObject);
      localObject = ((CardHomePageNewUI.a)localObject).wFK;
      kotlin.g.b.s.checkNotNull(localObject);
      CardHomePageNewUI localCardHomePageNewUI = CardHomePageNewUI.this;
      if (!Util.isNullOrNil(((vw)localObject).ZcC))
      {
        if (!Util.isNullOrNil(((vw)localObject).ZcD)) {
          doc().setTextColor(Color.parseColor(((vw)localObject).ZcD));
        }
        doc().setText((CharSequence)((vw)localObject).ZcC);
        dod().setImageResource(a.c.wel);
        dob().setOnClickListener(new CardHomePageNewUI.e..ExternalSyntheticLambda7((vw)localObject, localCardHomePageNewUI, this, paramInt));
      }
      AppMethodBeat.o(112434);
    }
    
    private final void IC(int paramInt)
    {
      AppMethodBeat.i(112435);
      Object localObject = this.wGj;
      kotlin.g.b.s.checkNotNull(localObject);
      localObject = ((CardHomePageNewUI.a)localObject).wFK;
      TextView localTextView = doc();
      Resources localResources = MMApplicationContext.getResources();
      int i = a.g.woQ;
      kotlin.g.b.s.checkNotNull(localObject);
      localTextView.setText((CharSequence)localResources.getString(i, new Object[] { Integer.valueOf(((vw)localObject).ZcH - ((vw)localObject).ZcI) }));
      dob().setOnClickListener(new CardHomePageNewUI.e..ExternalSyntheticLambda1(this, paramInt, (vw)localObject, CardHomePageNewUI.this));
      dod().setImageResource(a.c.wet);
      dod().setVisibility(0);
      AppMethodBeat.o(112435);
    }
    
    private final void ID(int paramInt)
    {
      AppMethodBeat.i(112436);
      Object localObject = this.wGj;
      kotlin.g.b.s.checkNotNull(localObject);
      localObject = ((CardHomePageNewUI.a)localObject).wFK;
      doc().setText((CharSequence)MMApplicationContext.getResources().getString(a.g.woO));
      dob().setOnClickListener(new CardHomePageNewUI.e..ExternalSyntheticLambda0(this, paramInt, (vw)localObject, CardHomePageNewUI.this));
      dod().setImageResource(a.c.weu);
      dod().setVisibility(0);
      AppMethodBeat.o(112436);
    }
    
    private final void IE(int paramInt)
    {
      AppMethodBeat.i(294259);
      Object localObject = this.wGj;
      kotlin.g.b.s.checkNotNull(localObject);
      localObject = ((CardHomePageNewUI.a)localObject).wFK;
      int i = doa().getChildCount();
      kotlin.g.b.s.checkNotNull(localObject);
      if (i >= ((vw)localObject).ZcH)
      {
        AppMethodBeat.o(294259);
        return;
      }
      an(((vw)localObject).ZcI, -1, paramInt);
      if (((vw)localObject).ZcI >= ((vw)localObject).ZcH)
      {
        dob().setVisibility(8);
        AppMethodBeat.o(294259);
        return;
      }
      E(true, paramInt);
      AppMethodBeat.o(294259);
    }
    
    private final void IF(int paramInt)
    {
      AppMethodBeat.i(294264);
      Object localObject = this.wGj;
      kotlin.g.b.s.checkNotNull(localObject);
      localObject = ((CardHomePageNewUI.a)localObject).wFK;
      int i = doa().getChildCount();
      kotlin.g.b.s.checkNotNull(localObject);
      int j;
      if (i > ((vw)localObject).ZcI)
      {
        Log.d("MicroMsg.CardHomePageNewUI", "collapse count: %s, limit: %s", new Object[] { Integer.valueOf(doa().getChildCount()), Integer.valueOf(((vw)localObject).ZcI) });
        i = doa().getChildCount() - 1;
        j = ((vw)localObject).ZcI;
        if (j > i) {}
      }
      for (;;)
      {
        doa().removeViewAt(i);
        if (i == j)
        {
          E(false, paramInt);
          AppMethodBeat.o(294264);
          return;
        }
        i -= 1;
      }
    }
    
    private static final void a(e parame, int paramInt, vw paramvw, CardHomePageNewUI paramCardHomePageNewUI, View paramView)
    {
      AppMethodBeat.i(294321);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(parame);
      localb.sc(paramInt);
      localb.cH(paramvw);
      localb.cH(paramCardHomePageNewUI);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      kotlin.g.b.s.u(parame, "this$0");
      kotlin.g.b.s.u(paramCardHomePageNewUI, "this$1");
      Log.d("MicroMsg.CardHomePageNewUI", "do expand coupon layout");
      parame.IE(paramInt);
      parame = parame.wGj;
      if (parame != null) {
        parame.wFN = true;
      }
      parame = com.tencent.mm.plugin.report.service.h.OAn;
      kotlin.g.b.s.checkNotNull(paramvw);
      parame.b(16324, new Object[] { Integer.valueOf(1), paramvw.Zcw, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(4), Integer.valueOf(paramInt), Integer.valueOf(CardHomePageNewUI.o(paramCardHomePageNewUI)) });
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(294321);
    }
    
    private static final void a(CardHomePageNewUI paramCardHomePageNewUI, View paramView)
    {
      AppMethodBeat.i(294280);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramCardHomePageNewUI);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      kotlin.g.b.s.u(paramCardHomePageNewUI, "this$0");
      CardHomePageNewUI.p(paramCardHomePageNewUI);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(294280);
    }
    
    private static final void a(CardHomePageNewUI paramCardHomePageNewUI, vw paramvw, e parame, vt paramvt, int paramInt1, int paramInt2, View paramView)
    {
      AppMethodBeat.i(294295);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramCardHomePageNewUI);
      localb.cH(paramvw);
      localb.cH(parame);
      localb.cH(paramvt);
      localb.sc(paramInt1);
      localb.sc(paramInt2);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      kotlin.g.b.s.u(paramCardHomePageNewUI, "this$0");
      kotlin.g.b.s.u(parame, "this$1");
      CardHomePageNewUI.m(paramCardHomePageNewUI);
      CardHomePageNewUI.n(paramCardHomePageNewUI);
      CardHomePageNewUI.a(paramCardHomePageNewUI, paramvw);
      paramView = paramvt.YBH;
      kotlin.g.b.s.s(paramView, "coupon.user_card_id");
      parame.ale(paramView);
      com.tencent.mm.plugin.report.service.h.OAn.b(16324, new Object[] { Integer.valueOf(1), paramvw.Zcw, Integer.valueOf(paramInt1), paramvt.YBH, Integer.valueOf(2), Integer.valueOf(paramInt2), Integer.valueOf(CardHomePageNewUI.o(paramCardHomePageNewUI)) });
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(294295);
    }
    
    private static final void a(CardHomePageNewUI paramCardHomePageNewUI, vw paramvw1, vw paramvw2, e parame, int paramInt, View paramView)
    {
      AppMethodBeat.i(294273);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramCardHomePageNewUI);
      localb.cH(paramvw1);
      localb.cH(paramvw2);
      localb.cH(parame);
      localb.sc(paramInt);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      kotlin.g.b.s.u(paramCardHomePageNewUI, "this$0");
      kotlin.g.b.s.u(paramvw2, "$this_apply");
      kotlin.g.b.s.u(parame, "this$1");
      Log.i("MicroMsg.CardHomePageNewUI", "click header");
      CardHomePageNewUI.m(paramCardHomePageNewUI);
      CardHomePageNewUI.n(paramCardHomePageNewUI);
      CardHomePageNewUI.a(paramCardHomePageNewUI, paramvw1);
      switch (paramvw2.Zcl)
      {
      }
      for (;;)
      {
        com.tencent.mm.plugin.report.service.h.OAn.b(16324, new Object[] { Integer.valueOf(1), paramvw2.Zcw, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(paramInt), Integer.valueOf(CardHomePageNewUI.o(paramCardHomePageNewUI)) });
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(294273);
        return;
        paramvw1 = parame.caK.getContext();
        if (paramvw1 == null)
        {
          paramCardHomePageNewUI = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
          AppMethodBeat.o(294273);
          throw paramCardHomePageNewUI;
        }
        com.tencent.mm.plugin.card.c.b.a((MMActivity)paramvw1, paramvw2.Zcm, 0);
        continue;
        paramvw1 = paramvw2.Zcn;
        com.tencent.mm.plugin.card.c.b.S(paramvw1.VcU, paramvw1.VcV, paramvw1.VQU);
      }
    }
    
    private void a(CardLabelTextView paramCardLabelTextView)
    {
      AppMethodBeat.i(294142);
      kotlin.g.b.s.u(paramCardLabelTextView, "<set-?>");
      this.wGb = paramCardLabelTextView;
      AppMethodBeat.o(294142);
    }
    
    private void a(CdnImageView paramCdnImageView)
    {
      AppMethodBeat.i(294081);
      kotlin.g.b.s.u(paramCdnImageView, "<set-?>");
      this.wFS = paramCdnImageView;
      AppMethodBeat.o(294081);
    }
    
    private static final void a(vw paramvw, CardHomePageNewUI paramCardHomePageNewUI, e parame, int paramInt, View paramView)
    {
      AppMethodBeat.i(294314);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramvw);
      localb.cH(paramCardHomePageNewUI);
      localb.cH(parame);
      localb.sc(paramInt);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      kotlin.g.b.s.u(paramvw, "$this_apply");
      kotlin.g.b.s.u(paramCardHomePageNewUI, "this$0");
      kotlin.g.b.s.u(parame, "this$1");
      if (paramvw.ZcE != null) {
        if (paramvw.ZcE == null) {
          break label289;
        }
      }
      label289:
      for (boolean bool = true;; bool = false)
      {
        Log.i("MicroMsg.CardHomePageNewUI", "detail goto mini app %s", new Object[] { Boolean.valueOf(bool) });
        CardHomePageNewUI.m(paramCardHomePageNewUI);
        CardHomePageNewUI.n(paramCardHomePageNewUI);
        CardHomePageNewUI.a(paramCardHomePageNewUI, paramvw);
        com.tencent.mm.plugin.card.c.b.S(paramvw.ZcE.VcU, paramvw.ZcE.VcV, paramvw.ZcE.VQU);
        paramvw = com.tencent.mm.plugin.report.service.h.OAn;
        parame = parame.wGj;
        kotlin.g.b.s.checkNotNull(parame);
        parame = parame.wFK;
        kotlin.g.b.s.checkNotNull(parame);
        paramvw.b(16324, new Object[] { Integer.valueOf(1), parame.Zcw, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(6), Integer.valueOf(paramInt), Integer.valueOf(CardHomePageNewUI.o(paramCardHomePageNewUI)) });
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(294314);
        return;
      }
    }
    
    private void a(List<? extends vs> paramList, LinearLayout paramLinearLayout)
    {
      AppMethodBeat.i(112432);
      kotlin.g.b.s.u(paramList, "couponLabelList");
      kotlin.g.b.s.u(paramLinearLayout, "labelLayout");
      paramList = paramList.iterator();
      if (paramList.hasNext())
      {
        vs localvs = (vs)paramList.next();
        CardTagTextView localCardTagTextView = new CardTagTextView(doa().getContext());
        Context localContext = doa().getContext();
        localCardTagTextView.setMinHeight(com.tencent.mm.cd.a.fromDPToPix(localContext, 18));
        localCardTagTextView.setMinWidth(com.tencent.mm.cd.a.fromDPToPix(localContext, 56));
        int i = com.tencent.mm.cd.a.fromDPToPix(localContext, 8);
        int j = com.tencent.mm.cd.a.fromDPToPix(localContext, 4);
        localCardTagTextView.setPadding(i, j, i, j);
        localCardTagTextView.setText((CharSequence)localvs.ZbR);
        localCardTagTextView.setTextSize(1, 10.0F);
        if (!Util.isNullOrNil(localvs.ZbS))
        {
          localCardTagTextView.setTextColor(Color.parseColor(localvs.ZbS));
          label169:
          if (Util.isNullOrNil(localvs.ZbT)) {
            break label219;
          }
          localCardTagTextView.setFillColor(com.tencent.mm.plugin.card.c.l.dO(localvs.ZbT, localvs.ZbW));
        }
        for (;;)
        {
          paramLinearLayout.addView((View)localCardTagTextView);
          break;
          localCardTagTextView.setTextColor(-1);
          break label169;
          label219:
          localCardTagTextView.setFillColor(com.tencent.mm.plugin.card.c.l.gy(-16777216, 26));
        }
      }
      AppMethodBeat.o(112432);
    }
    
    private void ale(String paramString)
    {
      AppMethodBeat.i(112429);
      kotlin.g.b.s.u(paramString, "cardId");
      Log.i("MicroMsg.CardHomePageNewUI", "go to card detail: %s", new Object[] { paramString });
      Object localObject = new Intent(this.caK.getContext(), CardDetailUI.class);
      ((Intent)localObject).putExtra("key_card_id", paramString);
      ((Intent)localObject).addFlags(131072);
      ((Intent)localObject).putExtra("key_from_scene", 3);
      paramString = this.caK.getContext();
      localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH", "gotoCardDetailUI", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramString, "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH", "gotoCardDetailUI", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(112429);
    }
    
    private final void an(int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(112428);
      Object localObject1 = this.wGj;
      kotlin.g.b.s.checkNotNull(localObject1);
      localObject1 = ((CardHomePageNewUI.a)localObject1).wFK;
      kotlin.g.b.s.checkNotNull(localObject1);
      Iterator localIterator = ((vw)localObject1).ZcB.iterator();
      int i = 0;
      int j = 0;
      for (;;)
      {
        int k;
        vt localvt;
        Object localObject2;
        Object localObject3;
        Object localObject4;
        Object localObject5;
        LinearLayout localLinearLayout;
        if (localIterator.hasNext())
        {
          k = i + 1;
          localvt = (vt)localIterator.next();
          if (i < paramInt1) {
            break label919;
          }
          if (localvt.Zcd != 1) {
            break label396;
          }
          localObject2 = LayoutInflater.from(doa().getContext()).inflate(a.e.wmM, (ViewGroup)doa(), false);
          if (localObject2 == null)
          {
            localObject1 = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
            AppMethodBeat.o(112428);
            throw ((Throwable)localObject1);
          }
          localObject2 = (ViewGroup)localObject2;
          localObject3 = (TextView)((ViewGroup)localObject2).findViewById(a.d.wif);
          localObject4 = (CdnImageView)((ViewGroup)localObject2).findViewById(a.d.wic);
          localObject5 = (TextView)((ViewGroup)localObject2).findViewById(a.d.wid);
          localLinearLayout = (LinearLayout)((ViewGroup)localObject2).findViewById(a.d.wie);
          if (!Util.isNullOrNil(localvt.Zcg)) {
            ((TextView)localObject3).setTextColor(com.tencent.mm.plugin.card.c.l.dO(localvt.Zcg, localvt.Zch));
          }
          ((TextView)localObject3).setText((CharSequence)localvt.ZbX);
          ((CdnImageView)localObject4).setUrl(localvt.Zce);
          if (!Util.isNullOrNil(localvt.Zci)) {
            ((TextView)localObject5).setTextColor(com.tencent.mm.plugin.card.c.l.dO(localvt.Zci, localvt.Zcj));
          }
          ((TextView)localObject5).setText((CharSequence)localvt.ZbY);
          localObject3 = localvt.Zcc;
          kotlin.g.b.s.s(localObject3, "coupon.coupon_label");
          localObject3 = (List)localObject3;
          kotlin.g.b.s.s(localLinearLayout, "labelLayout");
          a((List)localObject3, localLinearLayout);
          i = doa().getChildCount();
          ((ViewGroup)localObject2).setOnClickListener(new CardHomePageNewUI.e..ExternalSyntheticLambda4(CardHomePageNewUI.this, (vw)localObject1, this, localvt, i, paramInt3));
          eM((View)localObject2);
        }
        for (;;)
        {
          if (paramInt2 > 0)
          {
            j += 1;
            if (j >= paramInt2)
            {
              AppMethodBeat.o(112428);
              return;
              label396:
              if (localvt.Zcd == 2)
              {
                localObject2 = LayoutInflater.from(doa().getContext()).inflate(a.e.wmL, (ViewGroup)doa(), false);
                if (localObject2 == null)
                {
                  localObject1 = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
                  AppMethodBeat.o(112428);
                  throw ((Throwable)localObject1);
                }
                localObject2 = (ViewGroup)localObject2;
                localObject4 = (TextView)((ViewGroup)localObject2).findViewById(a.d.wif);
                localObject5 = (TextView)((ViewGroup)localObject2).findViewById(a.d.wid);
                localLinearLayout = (LinearLayout)((ViewGroup)localObject2).findViewById(a.d.wie);
                Object localObject6 = (MemberCardTopCropImageView)((ViewGroup)localObject2).findViewById(a.d.wia);
                localObject3 = (ImageView)((ViewGroup)localObject2).findViewById(a.d.wib);
                if (!Util.isNullOrNil(localvt.Zcg)) {
                  ((TextView)localObject4).setTextColor(com.tencent.mm.plugin.card.c.l.dO(localvt.Zcg, localvt.Zch));
                }
                ((TextView)localObject4).setText((CharSequence)localvt.ZbX);
                ((TextView)localObject5).setText((CharSequence)localvt.ZbY);
                ((MemberCardTopCropImageView)localObject6).setRadius(com.tencent.mm.cd.a.fromDPToPix(((MemberCardTopCropImageView)localObject6).getContext(), 2));
                if (!Util.isNullOrNil(localvt.Zcb))
                {
                  kotlin.g.b.s.s(localObject6, "bgIv");
                  localObject4 = (ImageView)localObject6;
                  localObject5 = localvt.Zcb;
                  kotlin.g.b.s.s(localObject5, "coupon.coupon_back_url");
                  i = a.c.wep;
                  kotlin.g.b.s.u(localObject4, "imageView");
                  kotlin.g.b.s.u(localObject5, "url");
                  localObject6 = new c.a();
                  ((c.a)localObject6).prefixPath = com.tencent.mm.loader.i.b.bmz();
                  ((c.a)localObject6).oKH = r.bKf();
                  ((c.a)localObject6).fullPath = m.akH((String)localObject5);
                  ((c.a)localObject6).oKp = true;
                  ((c.a)localObject6).oKJ = true;
                  ((c.a)localObject6).oKn = true;
                  ((c.a)localObject6).oKB = i;
                  ((c.a)localObject6).npV = com.tencent.mm.cd.a.fromDPToPix(((ImageView)localObject4).getContext(), 84);
                  ((c.a)localObject6).npU = com.tencent.mm.cd.a.ms(((ImageView)localObject4).getContext());
                  localObject6 = ((c.a)localObject6).bKx();
                  r.bKe().a((String)localObject5, (ImageView)localObject4, (c)localObject6);
                  ((ImageView)localObject4).setImageMatrix(new Matrix());
                  ((ImageView)localObject3).setVisibility(0);
                }
                for (;;)
                {
                  localObject3 = localvt.Zcc;
                  kotlin.g.b.s.s(localObject3, "coupon.coupon_label");
                  localObject3 = (List)localObject3;
                  kotlin.g.b.s.s(localLinearLayout, "labelLayout");
                  a((List)localObject3, localLinearLayout);
                  i = doa().getChildCount();
                  ((ViewGroup)localObject2).setOnClickListener(new CardHomePageNewUI.e..ExternalSyntheticLambda5(CardHomePageNewUI.this, (vw)localObject1, this, localvt, i, paramInt3));
                  eM((View)localObject2);
                  break;
                  if (!Util.isNullOrNil(localvt.Zca))
                  {
                    ((MemberCardTopCropImageView)localObject6).setImageDrawable((Drawable)new ColorDrawable(Color.parseColor(localvt.Zca)));
                    ((ImageView)localObject3).setVisibility(0);
                  }
                }
              }
            }
            else
            {
              i = k;
              break;
            }
          }
        }
        label919:
        i = k;
      }
    }
    
    private static final void b(e parame, int paramInt, vw paramvw, CardHomePageNewUI paramCardHomePageNewUI, View paramView)
    {
      AppMethodBeat.i(294332);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(parame);
      localb.sc(paramInt);
      localb.cH(paramvw);
      localb.cH(paramCardHomePageNewUI);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      kotlin.g.b.s.u(parame, "this$0");
      kotlin.g.b.s.u(paramCardHomePageNewUI, "this$1");
      Log.d("MicroMsg.CardHomePageNewUI", "do collapse coupon layout");
      parame.IF(paramInt);
      parame = parame.wGj;
      if (parame != null) {
        parame.wFN = false;
      }
      parame = com.tencent.mm.plugin.report.service.h.OAn;
      kotlin.g.b.s.checkNotNull(paramvw);
      parame.b(16324, new Object[] { Integer.valueOf(1), paramvw.Zcw, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(5), Integer.valueOf(paramInt), Integer.valueOf(CardHomePageNewUI.o(paramCardHomePageNewUI)) });
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(294332);
    }
    
    private static final void b(CardHomePageNewUI paramCardHomePageNewUI, View paramView)
    {
      AppMethodBeat.i(294285);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramCardHomePageNewUI);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      kotlin.g.b.s.u(paramCardHomePageNewUI, "this$0");
      CardHomePageNewUI.p(paramCardHomePageNewUI);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(294285);
    }
    
    private static final void b(CardHomePageNewUI paramCardHomePageNewUI, vw paramvw, e parame, vt paramvt, int paramInt1, int paramInt2, View paramView)
    {
      AppMethodBeat.i(294302);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramCardHomePageNewUI);
      localb.cH(paramvw);
      localb.cH(parame);
      localb.cH(paramvt);
      localb.sc(paramInt1);
      localb.sc(paramInt2);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      kotlin.g.b.s.u(paramCardHomePageNewUI, "this$0");
      kotlin.g.b.s.u(parame, "this$1");
      CardHomePageNewUI.m(paramCardHomePageNewUI);
      CardHomePageNewUI.n(paramCardHomePageNewUI);
      CardHomePageNewUI.a(paramCardHomePageNewUI, paramvw);
      paramView = paramvt.YBH;
      kotlin.g.b.s.s(paramView, "coupon.user_card_id");
      parame.ale(paramView);
      com.tencent.mm.plugin.report.service.h.OAn.b(16324, new Object[] { Integer.valueOf(1), paramvw.Zcw, Integer.valueOf(paramInt1), paramvt.YBH, Integer.valueOf(2), Integer.valueOf(paramInt2), Integer.valueOf(CardHomePageNewUI.o(paramCardHomePageNewUI)) });
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(294302);
    }
    
    private CdnImageView dnW()
    {
      AppMethodBeat.i(294076);
      CdnImageView localCdnImageView = this.wFS;
      if (localCdnImageView != null)
      {
        AppMethodBeat.o(294076);
        return localCdnImageView;
      }
      kotlin.g.b.s.bIx("chpiLogoIv");
      AppMethodBeat.o(294076);
      return null;
    }
    
    private TextView dnX()
    {
      AppMethodBeat.i(294087);
      TextView localTextView = this.wFT;
      if (localTextView != null)
      {
        AppMethodBeat.o(294087);
        return localTextView;
      }
      kotlin.g.b.s.bIx("chpiNameTv");
      AppMethodBeat.o(294087);
      return null;
    }
    
    private TextView dnY()
    {
      AppMethodBeat.i(294100);
      TextView localTextView = this.wFU;
      if (localTextView != null)
      {
        AppMethodBeat.o(294100);
        return localTextView;
      }
      kotlin.g.b.s.bIx("chpiDescTv");
      AppMethodBeat.o(294100);
      return null;
    }
    
    private LinearLayout dnZ()
    {
      AppMethodBeat.i(294112);
      LinearLayout localLinearLayout = this.wFW;
      if (localLinearLayout != null)
      {
        AppMethodBeat.o(294112);
        return localLinearLayout;
      }
      kotlin.g.b.s.bIx("chpiLabelLayout");
      AppMethodBeat.o(294112);
      return null;
    }
    
    private LinearLayout doa()
    {
      AppMethodBeat.i(294116);
      LinearLayout localLinearLayout = this.wFX;
      if (localLinearLayout != null)
      {
        AppMethodBeat.o(294116);
        return localLinearLayout;
      }
      kotlin.g.b.s.bIx("chpiCouponLayout");
      AppMethodBeat.o(294116);
      return null;
    }
    
    private LinearLayout dob()
    {
      AppMethodBeat.i(294121);
      LinearLayout localLinearLayout = this.wFY;
      if (localLinearLayout != null)
      {
        AppMethodBeat.o(294121);
        return localLinearLayout;
      }
      kotlin.g.b.s.bIx("chpiExpandLayout");
      AppMethodBeat.o(294121);
      return null;
    }
    
    private TextView doc()
    {
      AppMethodBeat.i(294127);
      TextView localTextView = this.wFZ;
      if (localTextView != null)
      {
        AppMethodBeat.o(294127);
        return localTextView;
      }
      kotlin.g.b.s.bIx("chpiExpandTv");
      AppMethodBeat.o(294127);
      return null;
    }
    
    private ImageView dod()
    {
      AppMethodBeat.i(294132);
      ImageView localImageView = this.wGa;
      if (localImageView != null)
      {
        AppMethodBeat.o(294132);
        return localImageView;
      }
      kotlin.g.b.s.bIx("chpiExpandIv");
      AppMethodBeat.o(294132);
      return null;
    }
    
    private CardLabelTextView doe()
    {
      AppMethodBeat.i(294138);
      CardLabelTextView localCardLabelTextView = this.wGb;
      if (localCardLabelTextView != null)
      {
        AppMethodBeat.o(294138);
        return localCardLabelTextView;
      }
      kotlin.g.b.s.bIx("chpiMchLabelTv");
      AppMethodBeat.o(294138);
      return null;
    }
    
    private TextView dof()
    {
      AppMethodBeat.i(294153);
      TextView localTextView = this.wGd;
      if (localTextView != null)
      {
        AppMethodBeat.o(294153);
        return localTextView;
      }
      kotlin.g.b.s.bIx("chtiTitleTv");
      AppMethodBeat.o(294153);
      return null;
    }
    
    private TextView dog()
    {
      AppMethodBeat.i(294167);
      TextView localTextView = this.wGe;
      if (localTextView != null)
      {
        AppMethodBeat.o(294167);
        return localTextView;
      }
      kotlin.g.b.s.bIx("chtiDescTv");
      AppMethodBeat.o(294167);
      return null;
    }
    
    private ImageView doh()
    {
      AppMethodBeat.i(294174);
      ImageView localImageView = this.wGf;
      if (localImageView != null)
      {
        AppMethodBeat.o(294174);
        return localImageView;
      }
      kotlin.g.b.s.bIx("chtiRightIv");
      AppMethodBeat.o(294174);
      return null;
    }
    
    private View doi()
    {
      AppMethodBeat.i(294186);
      View localView = this.wGi;
      if (localView != null)
      {
        AppMethodBeat.o(294186);
        return localView;
      }
      kotlin.g.b.s.bIx("chtiDivider");
      AppMethodBeat.o(294186);
      return null;
    }
    
    private static void e(ImageView paramImageView, String paramString)
    {
      AppMethodBeat.i(112433);
      kotlin.g.b.s.u(paramImageView, "imageView");
      kotlin.g.b.s.u(paramString, "url");
      Object localObject = new c.a();
      ((c.a)localObject).prefixPath = com.tencent.mm.loader.i.b.bmz();
      ((c.a)localObject).oKH = r.bKf();
      ((c.a)localObject).fullPath = m.akH(paramString);
      ((c.a)localObject).oKp = true;
      ((c.a)localObject).nrc = true;
      ((c.a)localObject).oKJ = true;
      ((c.a)localObject).oKn = true;
      ((c.a)localObject).oKB = a.f.card_default_merchant_icon;
      localObject = ((c.a)localObject).bKx();
      r.bKe().a(paramString, paramImageView, (c)localObject);
      AppMethodBeat.o(112433);
    }
    
    private void eM(View paramView)
    {
      AppMethodBeat.i(112430);
      kotlin.g.b.s.u(paramView, "view");
      if (doa().getChildCount() == 0)
      {
        doa().addView(paramView);
        AppMethodBeat.o(112430);
        return;
      }
      ViewGroup.MarginLayoutParams localMarginLayoutParams = new ViewGroup.MarginLayoutParams(-1, com.tencent.mm.cd.a.fromDPToPix(doa().getContext(), 84));
      localMarginLayoutParams.topMargin = com.tencent.mm.cd.a.fromDPToPix(doa().getContext(), 8);
      localMarginLayoutParams = (ViewGroup.MarginLayoutParams)new LinearLayout.LayoutParams(localMarginLayoutParams);
      doa().addView(paramView, (ViewGroup.LayoutParams)localMarginLayoutParams);
      AppMethodBeat.o(112430);
    }
    
    private void eN(List<? extends vu> paramList)
    {
      AppMethodBeat.i(112431);
      kotlin.g.b.s.u(paramList, "labelList");
      dnZ().removeAllViews();
      if (paramList.isEmpty())
      {
        dnZ().setVisibility(8);
        AppMethodBeat.o(112431);
        return;
      }
      paramList = paramList.iterator();
      int i = 0;
      while (paramList.hasNext())
      {
        int j = i + 1;
        Object localObject2 = (vu)paramList.next();
        Object localObject1 = dnZ().getContext();
        kotlin.g.b.s.s(localObject1, "chpiLabelLayout.context");
        localObject1 = new CardLabelTextView((Context)localObject1);
        Context localContext = dnZ().getContext();
        ((CardLabelTextView)localObject1).setTextSize(1, 12.0F);
        ((CardLabelTextView)localObject1).setText((CharSequence)((vu)localObject2).Zcq);
        int k = com.tencent.mm.cd.a.fromDPToPix(localContext, 4);
        ((CardLabelTextView)localObject1).setPadding(k, 0, k, 0);
        ((CardLabelTextView)localObject1).setGravity(16);
        if (!Util.isNullOrNil(((vu)localObject2).Zcr))
        {
          ((CardLabelTextView)localObject1).setTextColor(Color.parseColor(((vu)localObject2).Zcr));
          label187:
          if (Util.isNullOrNil(((vu)localObject2).Zcs)) {
            break label289;
          }
          ((CardLabelTextView)localObject1).setFillColor(com.tencent.mm.plugin.card.c.l.dO(((vu)localObject2).Zcs, ((vu)localObject2).Zcv));
        }
        for (;;)
        {
          if (i <= 0) {
            break label298;
          }
          localObject2 = new ViewGroup.MarginLayoutParams(-2, -2);
          ((ViewGroup.MarginLayoutParams)localObject2).leftMargin = com.tencent.mm.cd.a.fromDPToPix(localContext, 4);
          localObject2 = (ViewGroup.MarginLayoutParams)new LinearLayout.LayoutParams((ViewGroup.MarginLayoutParams)localObject2);
          dnZ().addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
          i = j;
          break;
          ((CardLabelTextView)localObject1).setTextColor(-1);
          break label187;
          label289:
          ((CardLabelTextView)localObject1).setFillColor(0);
        }
        label298:
        dnZ().addView((View)localObject1);
        i = j;
      }
      dnZ().setVisibility(0);
      AppMethodBeat.o(112431);
    }
    
    private void g(ImageView paramImageView)
    {
      AppMethodBeat.i(294149);
      kotlin.g.b.s.u(paramImageView, "<set-?>");
      this.wGc = paramImageView;
      AppMethodBeat.o(294149);
    }
    
    private void h(ImageView paramImageView)
    {
      AppMethodBeat.i(294180);
      kotlin.g.b.s.u(paramImageView, "<set-?>");
      this.wGf = paramImageView;
      AppMethodBeat.o(294180);
    }
    
    private void m(TextView paramTextView)
    {
      AppMethodBeat.i(294093);
      kotlin.g.b.s.u(paramTextView, "<set-?>");
      this.wFT = paramTextView;
      AppMethodBeat.o(294093);
    }
    
    private void n(TextView paramTextView)
    {
      AppMethodBeat.i(294104);
      kotlin.g.b.s.u(paramTextView, "<set-?>");
      this.wFU = paramTextView;
      AppMethodBeat.o(294104);
    }
    
    private void o(TextView paramTextView)
    {
      AppMethodBeat.i(294160);
      kotlin.g.b.s.u(paramTextView, "<set-?>");
      this.wGd = paramTextView;
      AppMethodBeat.o(294160);
    }
    
    private void p(TextView paramTextView)
    {
      AppMethodBeat.i(294171);
      kotlin.g.b.s.u(paramTextView, "<set-?>");
      this.wGe = paramTextView;
      AppMethodBeat.o(294171);
    }
    
    public final void a(CardHomePageNewUI.a parama, int paramInt)
    {
      Object localObject2 = null;
      Object localObject1 = null;
      AppMethodBeat.i(112426);
      kotlin.g.b.s.u(parama, "model");
      this.wGj = parama;
      Object localObject3 = parama.wFK;
      switch (parama.type)
      {
      }
      for (;;)
      {
        parama.wFM = true;
        AppMethodBeat.o(112426);
        return;
        kotlin.g.b.s.checkNotNull(localObject3);
        localObject1 = CardHomePageNewUI.this;
        dnW().setRoundCorner(true);
        Object localObject4;
        label149:
        label343:
        boolean bool;
        label415:
        label455:
        label463:
        label489:
        int i;
        if (!Util.isNullOrNil(((vw)localObject3).Zcx))
        {
          localObject2 = (ImageView)dnW();
          localObject4 = ((vw)localObject3).Zcx;
          kotlin.g.b.s.s(localObject4, "card_element_mch_icon");
          e((ImageView)localObject2, (String)localObject4);
          localObject2 = new CardHomePageNewUI.e..ExternalSyntheticLambda6((CardHomePageNewUI)localObject1, (vw)localObject3, (vw)localObject3, this, paramInt);
          dnW().setOnClickListener((View.OnClickListener)localObject2);
          localObject4 = new CardHomePageNewUI.b((CardHomePageNewUI)localObject1, ((CardHomePageNewUI)localObject1).getContext().getResources().getColor(a.a.normal_text_color), ((CardHomePageNewUI)localObject1).getContext().getResources().getColor(a.a.sns_link_bg_color), (n)new CardHomePageNewUI.e.a((View.OnClickListener)localObject2));
          SpannableString localSpannableString = new SpannableString((CharSequence)((vw)localObject3).Zcy);
          localSpannableString.setSpan(localObject4, 0, localSpannableString.length(), 18);
          dnX().setClickable(true);
          dnX().setOnTouchListener((View.OnTouchListener)new com.tencent.mm.pluginsdk.ui.span.s((Context)localObject1));
          dnX().setText((CharSequence)localSpannableString);
          if (Util.isNullOrNil(((vw)localObject3).Zcz)) {
            break label619;
          }
          dnY().setText((CharSequence)((vw)localObject3).Zcz);
          dnY().setVisibility(0);
          dnY().setOnClickListener((View.OnClickListener)localObject2);
          if (((vw)localObject3).ZcF == null) {
            break label675;
          }
          if (Util.isNullOrNil(((vw)localObject3).ZcF.Zcq)) {
            break label663;
          }
          doe().setText((CharSequence)((vw)localObject3).ZcF.Zcq);
          if (Util.isNullOrNil(((vw)localObject3).ZcF.Zcr)) {
            break label631;
          }
          doe().setTextColor(Color.parseColor(((vw)localObject3).ZcF.Zcr));
          if (Util.isNullOrNil(((vw)localObject3).ZcF.Zcs)) {
            break label652;
          }
          doe().setFillColor(com.tencent.mm.plugin.card.c.l.dO(((vw)localObject3).ZcF.Zcs, ((vw)localObject3).ZcF.Zcv));
          doe().setVisibility(0);
          doa().removeAllViews();
          if (parama.wFM) {
            break label706;
          }
          if (((vw)localObject3).ZcG != 1) {
            break label700;
          }
          bool = true;
          if (!bool) {
            break label768;
          }
          localObject1 = ((vw)localObject3).ZcB;
          kotlin.g.b.s.s(localObject1, "card_element_coupon_list");
          if (((Collection)localObject1).isEmpty()) {
            break label715;
          }
          i = 1;
          label524:
          if (i == 0) {
            break label720;
          }
          an(-1, ((vw)localObject3).ZcB.size(), paramInt);
          doa().setVisibility(0);
          parama.wFN = true;
          label555:
          if (Util.isNullOrNil(((vw)localObject3).ZcC)) {
            break label732;
          }
          IB(paramInt);
          dob().setVisibility(0);
        }
        label652:
        label663:
        label798:
        for (;;)
        {
          localObject1 = ((vw)localObject3).ZcA;
          kotlin.g.b.s.s(localObject1, "card_element_mch_label");
          eN((List)localObject1);
          break;
          dnW().setImageResource(a.f.card_default_merchant_icon);
          break label149;
          label619:
          dnY().setVisibility(8);
          break label343;
          label631:
          doe().setTextColor(((CardHomePageNewUI)localObject1).getResources().getColor(a.a.white));
          break label415;
          doe().setFillColor(0);
          break label455;
          doe().setVisibility(8);
          break label463;
          label675:
          doe().setText((CharSequence)"");
          doe().setVisibility(8);
          break label463;
          label700:
          bool = false;
          break label489;
          label706:
          bool = parama.wFN;
          break label489;
          label715:
          i = 0;
          break label524;
          label720:
          doa().setVisibility(8);
          break label555;
          label732:
          if (((vw)localObject3).ZcI < ((vw)localObject3).ZcB.size())
          {
            ID(paramInt);
          }
          else
          {
            dob().setVisibility(8);
            continue;
            localObject1 = ((vw)localObject3).ZcB;
            kotlin.g.b.s.s(localObject1, "card_element_coupon_list");
            if (!((Collection)localObject1).isEmpty())
            {
              i = 1;
              if (i == 0) {
                break label874;
              }
              an(-1, ((vw)localObject3).ZcI, paramInt);
              doa().setVisibility(0);
              parama.wFN = false;
            }
            for (;;)
            {
              if (((vw)localObject3).ZcI >= ((vw)localObject3).ZcB.size())
              {
                if (!Util.isNullOrNil(((vw)localObject3).ZcC))
                {
                  IB(paramInt);
                  dob().setVisibility(0);
                  break;
                  i = 0;
                  break label798;
                  label874:
                  doa().setVisibility(8);
                  continue;
                }
                dob().setVisibility(8);
                break;
              }
            }
            IC(paramInt);
            dob().setVisibility(0);
          }
        }
        label768:
        localObject2 = this.wFR;
        if (localObject2 != null) {
          localObject1 = localObject2;
        }
        for (;;)
        {
          ((TextView)localObject1).setText((CharSequence)parama.dnV());
          break;
          kotlin.g.b.s.bIx("sectionTitleTv");
        }
        kotlin.g.b.s.checkNotNull(localObject3);
        localObject1 = CardHomePageNewUI.this;
        dnW().setRoundCorner(true);
        dnW().setUrl(((vw)localObject3).Zcx);
        dnX().setText((CharSequence)((vw)localObject3).Zcy);
        if (!Util.isNullOrNil(((vw)localObject3).Zcz))
        {
          dnY().setText((CharSequence)((vw)localObject3).Zcz);
          dnY().setVisibility(0);
          label1033:
          if (((vw)localObject3).ZcF == null) {
            break label1212;
          }
          if (Util.isNullOrNil(((vw)localObject3).ZcF.Zcq)) {
            break label1200;
          }
          doe().setText((CharSequence)((vw)localObject3).ZcF.Zcq);
          if (Util.isNullOrNil(((vw)localObject3).ZcF.Zcr)) {
            break label1168;
          }
          doe().setTextColor(Color.parseColor(((vw)localObject3).ZcF.Zcr));
          label1105:
          if (Util.isNullOrNil(((vw)localObject3).ZcF.Zcs)) {
            break label1189;
          }
          doe().setFillColor(com.tencent.mm.plugin.card.c.l.dO(((vw)localObject3).ZcF.Zcs, ((vw)localObject3).ZcF.Zcv));
        }
        for (;;)
        {
          doe().setVisibility(0);
          break;
          dnY().setVisibility(8);
          break label1033;
          label1168:
          doe().setTextColor(((CardHomePageNewUI)localObject1).getResources().getColor(a.a.white));
          break label1105;
          label1189:
          doe().setFillColor(0);
        }
        label1200:
        doe().setVisibility(8);
        continue;
        label1212:
        doe().setText((CharSequence)"");
        doe().setVisibility(8);
        continue;
        dnW().setRoundCorner(true);
        dnW().setImageResource(a.f.card_default_merchant_icon);
        dnX().setText((CharSequence)MMApplicationContext.getResources().getString(a.g.woR));
        dnY().setVisibility(8);
        continue;
        dof().setText(a.g.wqO);
        if (CardHomePageNewUI.k(CardHomePageNewUI.this) != null)
        {
          localObject1 = CardHomePageNewUI.this;
          dog().setText((CharSequence)CardHomePageNewUI.k((CardHomePageNewUI)localObject1));
          continue;
          dof().setText(a.g.wpH);
          if (CardHomePageNewUI.l(CardHomePageNewUI.this) == 1)
          {
            dog().setVisibility(0);
            doh().setVisibility(0);
            localObject1 = CardHomePageNewUI.this.dnR();
            if (localObject1 == null) {
              dog().setText((CharSequence)"");
            }
            for (;;)
            {
              dog().setOnClickListener(new CardHomePageNewUI.e..ExternalSyntheticLambda2(CardHomePageNewUI.this));
              doh().setOnClickListener(new CardHomePageNewUI.e..ExternalSyntheticLambda3(CardHomePageNewUI.this));
              Util.expandViewTouchArea((View)doh(), 50, 50, 50, 50);
              break;
              dog().setText((CharSequence)((wo)localObject1).ZdA);
            }
          }
          dog().setVisibility(8);
          doh().setVisibility(8);
          continue;
          localObject3 = parama.wFO;
          if (localObject3 != null)
          {
            dof().setText((CharSequence)((wb)localObject3).ZcS);
            dog().setText((CharSequence)((wb)localObject3).ZcT);
            localObject1 = this.wGc;
            if (localObject1 == null) {
              break label1638;
            }
            label1542:
            localObject4 = ((wb)localObject3).ZcR;
            kotlin.g.b.s.s(localObject4, "card_top_cell_icon");
            e((ImageView)localObject1, (String)localObject4);
            localObject1 = this.wGh;
            if (localObject1 == null) {
              break label1650;
            }
            label1575:
            if (((wb)localObject3).ZcZ != 1) {
              break label1662;
            }
            paramInt = 0;
            label1586:
            ((TextView)localObject1).setVisibility(paramInt);
            localObject1 = this.wGg;
            if (localObject1 == null) {
              break label1668;
            }
            label1603:
            if (((wb)localObject3).ZcY != 1) {
              break label1681;
            }
          }
          label1668:
          label1681:
          for (paramInt = 0;; paramInt = 8)
          {
            ((ImageView)localObject1).setVisibility(paramInt);
            if (!parama.wFP) {
              break label1687;
            }
            doi().setVisibility(0);
            break;
            label1638:
            kotlin.g.b.s.bIx("chtiIconIv");
            localObject1 = null;
            break label1542;
            label1650:
            kotlin.g.b.s.bIx("chtiNewTv");
            localObject1 = null;
            break label1575;
            label1662:
            paramInt = 8;
            break label1586;
            kotlin.g.b.s.bIx("chtiRedDotIv");
            localObject1 = localObject2;
            break label1603;
          }
          label1687:
          doi().setVisibility(8);
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$initView$1", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "paint", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "paint2", "getPaint2", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "onDraw", "c", "Landroid/graphics/Canvas;", "plugin-card_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    extends RecyclerView.h
  {
    private final Paint paint;
    private final Paint wGl;
    
    f(CardHomePageNewUI paramCardHomePageNewUI)
    {
      AppMethodBeat.i(112446);
      this.paint = new Paint();
      this.wGl = new Paint();
      this.paint.setColor(this.wFQ.getResources().getColor(a.a.small_line_color));
      this.paint.setStyle(Paint.Style.FILL);
      this.paint.setFlags(1);
      this.wGl.setColor(this.wFQ.getResources().getColor(a.a.white));
      this.wGl.setStyle(Paint.Style.FILL);
      this.wGl.setFlags(1);
      AppMethodBeat.o(112446);
    }
    
    public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(294062);
      kotlin.g.b.s.u(paramCanvas, "c");
      kotlin.g.b.s.u(paramRecyclerView, "parent");
      kotlin.g.b.s.u(params, "state");
      super.a(paramCanvas, paramRecyclerView, params);
      paramRecyclerView = CardHomePageNewUI.b(this.wFQ);
      if (paramRecyclerView == null)
      {
        kotlin.g.b.s.bIx("mRecyclerView");
        paramRecyclerView = null;
      }
      int i;
      int k;
      int m;
      int n;
      int i1;
      for (;;)
      {
        i = paramRecyclerView.getPaddingLeft();
        params = CardHomePageNewUI.wFi;
        k = i + CardHomePageNewUI.dnU();
        m = paramRecyclerView.getWidth();
        n = paramRecyclerView.getPaddingRight();
        i1 = paramRecyclerView.getChildCount();
        i = 0;
        if (i >= i1 - 1) {
          break label235;
        }
        params = paramRecyclerView.getChildAt(i);
        localObject = params.getLayoutParams();
        if (localObject != null) {
          break;
        }
        paramCanvas = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        AppMethodBeat.o(294062);
        throw paramCanvas;
      }
      Object localObject = (RecyclerView.LayoutParams)localObject;
      int i2 = params.getBottom() + ((RecyclerView.LayoutParams)localObject).bottomMargin;
      if (i == i1 - 1) {
        params = CardHomePageNewUI.wFi;
      }
      for (int j = CardHomePageNewUI.dnT();; j = 1)
      {
        j = i2 + j;
        paramCanvas.drawRect(k, i2, m - n, j, this.paint);
        paramCanvas.drawRect(0.0F, i2, k, j, this.wGl);
        i += 1;
        break;
      }
      label235:
      AppMethodBeat.o(294062);
    }
    
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(294053);
      kotlin.g.b.s.u(paramRect, "outRect");
      kotlin.g.b.s.u(paramView, "view");
      kotlin.g.b.s.u(paramRecyclerView, "parent");
      kotlin.g.b.s.u(params, "state");
      super.a(paramRect, paramView, paramRecyclerView, params);
      int i = RecyclerView.bA(paramView);
      paramRecyclerView = CardHomePageNewUI.a(this.wFQ);
      paramView = paramRecyclerView;
      if (paramRecyclerView == null)
      {
        kotlin.g.b.s.bIx("mHomePageAdapter");
        paramView = null;
      }
      if (i == paramView.getItemCount() - 1)
      {
        Log.d("MicroMsg.CardHomePageNewUI", "is last");
        paramView = CardHomePageNewUI.wFi;
        paramRect.bottom = CardHomePageNewUI.dnT();
        AppMethodBeat.o(294053);
        return;
      }
      paramRect.bottom = 1;
      AppMethodBeat.o(294053);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v2.CardHomePageNewUI
 * JD-Core Version:    0.7.0.1
 */