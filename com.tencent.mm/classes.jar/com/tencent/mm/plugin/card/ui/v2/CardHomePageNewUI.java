package com.tencent.mm.plugin.card.ui.v2;

import a.f.b.j;
import a.l;
import a.l.d;
import a.v;
import a.y;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cm.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.i;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView.a;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.a;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.b;
import com.tencent.mm.pluginsdk.wallet.c;
import com.tencent.mm.protocal.protobuf.ol;
import com.tencent.mm.protocal.protobuf.on;
import com.tencent.mm.protocal.protobuf.op;
import com.tencent.mm.protocal.protobuf.oq;
import com.tencent.mm.protocal.protobuf.or;
import com.tencent.mm.protocal.protobuf.os;
import com.tencent.mm.protocal.protobuf.pc;
import com.tencent.mm.protocal.protobuf.pd;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI;", "Lcom/tencent/mm/plugin/card/ui/v2/CardNewBaseUI;", "()V", "adjustFooterTask", "Lkotlin/Function0;", "", "cardSortInfoList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/CardSortInfo;", "Lkotlin/collections/ArrayList;", "cardTitleModel", "Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$CardListModel;", "clickArea", "", "clickedCardHomePageElement", "Lcom/tencent/mm/protocal/protobuf/CardHomePageElement;", "firstLoad", "", "getCardHomePageScene", "Lcom/tencent/mm/plugin/card/model/v2/CgiGetMktCardHomePage;", "isAll", "isGotoItem", "isLoading", "mDivider", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "mEmptyView", "Landroid/view/ViewGroup;", "mFooterView", "mHomePageAdapter", "Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageAdapter;", "mLoadingView", "mLoadingView2", "mRecyclerView", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "markReloadHomePage", "needReloadHomePage", "offset", "reqNum", "scene", "shouldShowTicket", "showSort", "sortType", "storeModelList", "ticketModel", "ticketNum", "", "tipsDialog", "Landroid/app/Dialog;", "titleSectionModel", "topCellList", "underModelList", "cardSortInfo", "doDeleteMchInList", "merchantId", "doGetCardHomePage", "doGetMchInfo", "lastReceiveTime", "", "getLayoutId", "initFirstScreen", "initView", "loadSnapshot", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinishLocationThings", "ret", "isLocationOk", "onResume", "saveSnapshot", "showSortSheet", "updateModelList", "storePageList", "Lcom/tencent/mm/protocal/protobuf/CardHomePageStoreList;", "underPageList", "Lcom/tencent/mm/protocal/protobuf/CardHomePageUnderList;", "_topCellList", "Lcom/tencent/mm/protocal/protobuf/CardHomePageTopCellList;", "CardListModel", "CardSpan", "Companion", "HomePageAdapter", "HomePageVH", "plugin-card_release"})
@i
public final class CardHomePageNewUI
  extends CardNewBaseUI
{
  private static final int cde;
  private static final int eSW;
  private static final int kzk;
  public static final CardHomePageNewUI.c kzl;
  private boolean evP;
  private Dialog gpx;
  private boolean isLoading;
  private int kpz;
  private LoadMoreRecyclerView kyK;
  private CardHomePageNewUI.d kyL;
  private ViewGroup kyM;
  private ViewGroup kyN;
  private ViewGroup kyO;
  private RecyclerView.h kyP;
  private ViewGroup kyQ;
  private int kyR;
  private boolean kyS;
  private String kyT;
  private final ArrayList<CardHomePageNewUI.a> kyU;
  private final ArrayList<CardHomePageNewUI.a> kyV;
  private final ArrayList<CardHomePageNewUI.a> kyW;
  private CardHomePageNewUI.a kyX;
  private CardHomePageNewUI.a kyY;
  private CardHomePageNewUI.a kyZ;
  private boolean kza;
  private int kzb;
  private boolean kzc;
  private int kzd;
  private ArrayList<pc> kze;
  private boolean kzf;
  private on kzg;
  private boolean kzh;
  private final a.f.a.a<y> kzi;
  private com.tencent.mm.plugin.card.model.a.h kzj;
  private int offset;
  private int scene;
  
  static
  {
    AppMethodBeat.i(89244);
    kzl = new CardHomePageNewUI.c((byte)0);
    cde = com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), 40);
    eSW = com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), 1);
    kzk = com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), 16);
    AppMethodBeat.o(89244);
  }
  
  public CardHomePageNewUI()
  {
    AppMethodBeat.i(89243);
    this.kyR = 10;
    this.kyT = "";
    this.kyU = new ArrayList();
    this.kyV = new ArrayList();
    this.kyW = new ArrayList();
    this.evP = true;
    this.kzb = -1;
    this.kzc = true;
    this.kze = new ArrayList();
    this.kzi = ((a.f.a.a)new f(this));
    AppMethodBeat.o(89243);
  }
  
  private final void bff()
  {
    AppMethodBeat.i(89242);
    ab.i("MicroMsg.CardHomePageNewUI", "do get card Home page: %s, %s", new Object[] { Boolean.valueOf(this.kyS), Boolean.valueOf(this.isLoading) });
    Object localObject;
    if ((this.kzh) || ((!this.kyS) && (!this.isLoading)))
    {
      this.isLoading = true;
      if (this.kzh)
      {
        localObject = this.kyQ;
        if (localObject == null) {
          j.ays("mLoadingView2");
        }
        ((ViewGroup)localObject).setVisibility(0);
        if (this.kyY != null)
        {
          localObject = this.kyQ;
          if (localObject == null) {
            j.ays("mLoadingView2");
          }
          localObject = ((ViewGroup)localObject).getLayoutParams();
          if (localObject == null)
          {
            localObject = new v("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            AppMethodBeat.o(89242);
            throw ((Throwable)localObject);
          }
          localObject = (RelativeLayout.LayoutParams)localObject;
          ((RelativeLayout.LayoutParams)localObject).topMargin = com.tencent.mm.cb.a.fromDPToPix((Context)getContext(), 80);
          ViewGroup localViewGroup = this.kyQ;
          if (localViewGroup == null) {
            j.ays("mLoadingView2");
          }
          localViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
      localObject = bfe();
      if (localObject == null) {
        break label346;
      }
    }
    label346:
    for (int i = ((pc)localObject).wvk;; i = 10)
    {
      this.kyR = i;
      if (this.gpx != null)
      {
        localObject = this.gpx;
        if (localObject == null) {
          j.ebi();
        }
        ((Dialog)localObject).dismiss();
      }
      if (this.kyV.isEmpty())
      {
        localObject = (Context)getContext();
        getContext().getString(2131296919);
        this.gpx = ((Dialog)com.tencent.mm.ui.base.h.b((Context)localObject, getContext().getString(2131301086), true, null));
      }
      this.kzj = new com.tencent.mm.plugin.card.model.a.h(this.offset, this.kyR, this.cyV, this.cAH, this.kpz);
      localObject = this.kzj;
      if (localObject == null) {
        j.ebi();
      }
      ((com.tencent.mm.plugin.card.model.a.h)localObject).adl().b((com.tencent.mm.vending.c.a)new h(this));
      AppMethodBeat.o(89242);
      return;
    }
  }
  
  public final void R(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(89238);
    ab.i("MicroMsg.CardHomePageNewUI", "location finish: [%s, %s], ret: %s, isOk: %s", new Object[] { Float.valueOf(this.cyV), Float.valueOf(this.cAH), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    if (this.evP)
    {
      if ((this.kzd == 1) && (paramInt < 0) && (this.kpz == 1))
      {
        this.kpz = 0;
        if (paramInt == -2) {
          com.tencent.mm.plugin.report.service.h.qsU.e(16322, new Object[] { Integer.valueOf(30) });
        }
      }
      bff();
      AppMethodBeat.o(89238);
      return;
    }
    if (!paramBoolean) {
      bfn();
    }
    AppMethodBeat.o(89238);
  }
  
  public final void a(op paramop, os paramos, or paramor)
  {
    AppMethodBeat.i(152213);
    Object localObject;
    int i;
    if (paramop != null)
    {
      localObject = paramop.wFf;
      j.p(localObject, "card_home_page_element");
      if (!((Collection)localObject).isEmpty()) {}
      for (i = 1; i != 0; i = 0)
      {
        paramop = paramop.wFf.iterator();
        while (paramop.hasNext())
        {
          localObject = (on)paramop.next();
          CardHomePageNewUI.a locala = new CardHomePageNewUI.a(this);
          locala.kzm = ((on)localObject);
          locala.type = 0;
          this.kyV.add(locala);
        }
      }
    }
    if (paramos != null)
    {
      paramop = paramos.wFf;
      j.p(paramop, "card_home_page_element");
      if (!((Collection)paramop).isEmpty()) {}
      for (i = 1; i != 0; i = 0)
      {
        if (bo.isNullOrNil(paramos.wFq)) {
          paramos.wFq = getString(2131297943);
        }
        if (this.kyX == null)
        {
          this.kyX = new CardHomePageNewUI.a(this);
          paramop = this.kyX;
          if (paramop == null) {
            j.ebi();
          }
          paramop.type = 1;
        }
        paramop = this.kyX;
        if (paramop == null) {
          j.ebi();
        }
        localObject = paramos.wFq;
        j.p(localObject, "section_title");
        paramop.Ij((String)localObject);
        paramop = paramos.wFf.iterator();
        while (paramop.hasNext())
        {
          paramos = (on)paramop.next();
          localObject = new CardHomePageNewUI.a(this);
          ((CardHomePageNewUI.a)localObject).kzm = paramos;
          ((CardHomePageNewUI.a)localObject).type = 2;
          this.kyW.add(localObject);
        }
      }
    }
    if (paramor != null)
    {
      paramop = paramor.wFp;
      j.p(paramop, "card_home_page_top_cell");
      if (!((Collection)paramop).isEmpty()) {}
      for (i = 1; i != 0; i = 0)
      {
        paramop = paramor.wFp;
        j.p(paramop, "card_home_page_top_cell");
        paramop = ((Iterable)paramop).iterator();
        i = 0;
        while (paramop.hasNext())
        {
          paramos = (oq)paramop.next();
          localObject = new CardHomePageNewUI.a(this);
          ((CardHomePageNewUI.a)localObject).kzq = paramos;
          ((CardHomePageNewUI.a)localObject).type = 6;
          if (i == paramor.wFp.size() - 1) {
            ((CardHomePageNewUI.a)localObject).kzr = true;
          }
          this.kyU.add(localObject);
          i += 1;
        }
      }
    }
    if (this.scene == 0)
    {
      if (((Collection)this.kyV).isEmpty()) {
        break label601;
      }
      i = 1;
      if (i != 0)
      {
        this.kyZ = new CardHomePageNewUI.a(this);
        paramop = this.kyZ;
        if (paramop == null) {
          j.ebi();
        }
        paramop.type = 5;
      }
    }
    if ((this.kyV.isEmpty()) && (this.kyW.isEmpty()))
    {
      if (!((Collection)this.kyU).isEmpty()) {
        i = 1;
      }
      for (;;)
      {
        if (i != 0)
        {
          paramop = this.kyO;
          if (paramop == null) {
            j.ays("mEmptyView");
          }
          paramop = paramop.getLayoutParams();
          if (paramop == null)
          {
            paramop = new v("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            AppMethodBeat.o(152213);
            throw paramop;
            label601:
            i = 0;
            break;
            i = 0;
            continue;
          }
          paramop = (RelativeLayout.LayoutParams)paramop;
          paramop.topMargin = com.tencent.mm.cb.a.fromDPToPix((Context)getContext(), this.kyU.size() * 64 + 14);
          paramos = this.kyO;
          if (paramos == null) {
            j.ays("mEmptyView");
          }
          paramos.setLayoutParams((ViewGroup.LayoutParams)paramop);
          paramop = this.kyO;
          if (paramop == null) {
            j.ays("mEmptyView");
          }
          paramop.setVisibility(0);
          AppMethodBeat.o(152213);
          return;
        }
      }
    }
    paramop = this.kyO;
    if (paramop == null) {
      j.ays("mEmptyView");
    }
    paramop.setVisibility(8);
    AppMethodBeat.o(152213);
  }
  
  public final pc bfe()
  {
    AppMethodBeat.i(152212);
    Iterator localIterator = this.kze.iterator();
    while (localIterator.hasNext())
    {
      pc localpc = (pc)localIterator.next();
      if (localpc.wFN == this.kpz)
      {
        AppMethodBeat.o(152212);
        return localpc;
      }
    }
    AppMethodBeat.o(152212);
    return null;
  }
  
  public final int getLayoutId()
  {
    return 2130968955;
  }
  
  public final void initView()
  {
    int i = 0;
    int j = 1;
    AppMethodBeat.i(89237);
    Object localObject1 = findViewById(2131822233);
    j.p(localObject1, "findViewById(R.id.chpu_rv)");
    this.kyK = ((LoadMoreRecyclerView)localObject1);
    localObject1 = this.kyK;
    if (localObject1 == null) {
      j.ays("mRecyclerView");
    }
    getContext();
    ((LoadMoreRecyclerView)localObject1).setLayoutManager((RecyclerView.i)new LinearLayoutManager());
    this.kyL = new CardHomePageNewUI.d(this);
    localObject1 = this.kyK;
    if (localObject1 == null) {
      j.ays("mRecyclerView");
    }
    Object localObject2 = this.kyL;
    if (localObject2 == null) {
      j.ays("mHomePageAdapter");
    }
    ((LoadMoreRecyclerView)localObject1).setAdapter((RecyclerView.a)localObject2);
    localObject1 = findViewById(2131822219);
    j.p(localObject1, "findViewById(R.id.chpe_root_layout)");
    this.kyO = ((ViewGroup)localObject1);
    localObject1 = LayoutInflater.from((Context)this);
    localObject2 = this.kyK;
    if (localObject2 == null) {
      j.ays("mRecyclerView");
    }
    localObject1 = ((LayoutInflater)localObject1).inflate(2130968952, (ViewGroup)localObject2, false);
    if (localObject1 == null)
    {
      localObject1 = new v("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(89237);
      throw ((Throwable)localObject1);
    }
    this.kyM = ((ViewGroup)localObject1);
    localObject1 = LayoutInflater.from((Context)this);
    localObject2 = this.kyK;
    if (localObject2 == null) {
      j.ays("mRecyclerView");
    }
    localObject1 = ((LayoutInflater)localObject1).inflate(2130968950, (ViewGroup)localObject2, false);
    if (localObject1 == null)
    {
      localObject1 = new v("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(89237);
      throw ((Throwable)localObject1);
    }
    this.kyN = ((ViewGroup)localObject1);
    localObject1 = findViewById(2131822234);
    j.p(localObject1, "findViewById(R.id.chpu_loading_layout)");
    this.kyQ = ((ViewGroup)localObject1);
    localObject1 = this.kyK;
    if (localObject1 == null) {
      j.ays("mRecyclerView");
    }
    localObject2 = this.kyM;
    if (localObject2 == null) {
      j.ays("mLoadingView");
    }
    ((LoadMoreRecyclerView)localObject1).setLoadingView((View)localObject2);
    localObject1 = this.kyK;
    if (localObject1 == null) {
      j.ays("mRecyclerView");
    }
    localObject2 = this.kyN;
    if (localObject2 == null) {
      j.ays("mFooterView");
    }
    ((LoadMoreRecyclerView)localObject1).addFooterView((View)localObject2);
    localObject1 = this.kyN;
    if (localObject1 == null) {
      j.ays("mFooterView");
    }
    ((ViewGroup)localObject1).setVisibility(8);
    this.kyP = ((RecyclerView.h)new CardHomePageNewUI.j(this));
    localObject1 = this.kyK;
    if (localObject1 == null) {
      j.ays("mRecyclerView");
    }
    localObject2 = this.kyP;
    if (localObject2 == null) {
      j.ays("mDivider");
    }
    ((LoadMoreRecyclerView)localObject1).b((RecyclerView.h)localObject2);
    localObject1 = this.kyK;
    if (localObject1 == null) {
      j.ays("mRecyclerView");
    }
    ((LoadMoreRecyclerView)localObject1).setOnLoadingStateChangedListener((LoadMoreRecyclerView.a)new CardHomePageNewUI.k(this));
    localObject1 = this.kyK;
    if (localObject1 == null) {
      j.ays("mRecyclerView");
    }
    ((LoadMoreRecyclerView)localObject1).setOnItemClickListener((MRecyclerView.a)new CardHomePageNewUI.l(this));
    localObject1 = this.kyK;
    if (localObject1 == null) {
      j.ays("mRecyclerView");
    }
    ((LoadMoreRecyclerView)localObject1).setOnItemLongClickListener((MRecyclerView.b)new CardHomePageNewUI.m(this));
    localObject1 = new op();
    localObject2 = new os();
    or localor = new or();
    pd localpd = new pd();
    Object localObject3 = com.tencent.mm.plugin.card.model.a.a.kpr;
    j.q(localObject1, "storeList");
    j.q(localObject2, "underList");
    j.q(localor, "topList");
    j.q(localpd, "cardSortInfoList");
    ab.i(com.tencent.mm.plugin.card.model.a.a.access$getTAG$cp(), "load home page snapshot");
    localObject3 = com.tencent.mm.kernel.g.RL();
    j.p(localObject3, "MMKernel.storage()");
    localObject3 = (String)((e)localObject3).Ru().i(ac.a.yKV);
    Charset localCharset;
    if (localObject3 != null)
    {
      localCharset = d.ISO_8859_1;
      if (localObject3 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(89237);
        throw ((Throwable)localObject1);
      }
      localObject3 = ((String)localObject3).getBytes(localCharset);
      j.p(localObject3, "(this as java.lang.String).getBytes(charset)");
      ((op)localObject1).parseFrom((byte[])localObject3);
      i = 1;
    }
    localObject3 = com.tencent.mm.kernel.g.RL();
    j.p(localObject3, "MMKernel.storage()");
    localObject3 = (String)((e)localObject3).Ru().i(ac.a.yKW);
    if (localObject3 != null)
    {
      localCharset = d.ISO_8859_1;
      if (localObject3 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(89237);
        throw ((Throwable)localObject1);
      }
      localObject3 = ((String)localObject3).getBytes(localCharset);
      j.p(localObject3, "(this as java.lang.String).getBytes(charset)");
      ((os)localObject2).parseFrom((byte[])localObject3);
      i = 1;
    }
    localObject3 = com.tencent.mm.kernel.g.RL();
    j.p(localObject3, "MMKernel.storage()");
    localObject3 = (String)((e)localObject3).Ru().i(ac.a.yKX);
    if (localObject3 != null)
    {
      localCharset = d.ISO_8859_1;
      if (localObject3 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(89237);
        throw ((Throwable)localObject1);
      }
      localObject3 = ((String)localObject3).getBytes(localCharset);
      j.p(localObject3, "(this as java.lang.String).getBytes(charset)");
      localor.parseFrom((byte[])localObject3);
      i = 1;
    }
    localObject3 = com.tencent.mm.kernel.g.RL();
    j.p(localObject3, "MMKernel.storage()");
    localObject3 = (String)((e)localObject3).Ru().i(ac.a.yKY);
    if (localObject3 != null)
    {
      localCharset = d.ISO_8859_1;
      if (localObject3 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(89237);
        throw ((Throwable)localObject1);
      }
      localObject3 = ((String)localObject3).getBytes(localCharset);
      j.p(localObject3, "(this as java.lang.String).getBytes(charset)");
      localpd.parseFrom((byte[])localObject3);
      i = j;
    }
    for (;;)
    {
      this.kze.clear();
      this.kze.addAll((Collection)localpd.wFP);
      a((op)localObject1, (os)localObject2, localor);
      if ((i == 0) && (this.kyV.isEmpty()) && (this.kyW.isEmpty()))
      {
        ab.i("MicroMsg.CardHomePageNewUI", "show init view");
        localObject1 = new CardHomePageNewUI.a(this);
        ((CardHomePageNewUI.a)localObject1).type = 3;
        localObject2 = new CardHomePageNewUI.a(this);
        ((CardHomePageNewUI.a)localObject2).type = 3;
        this.kyV.add(localObject1);
        this.kyV.add(localObject2);
      }
      localObject1 = this.kyK;
      if (localObject1 == null) {
        j.ays("mRecyclerView");
      }
      ((LoadMoreRecyclerView)localObject1).getAdapter().notifyDataSetChanged();
      AppMethodBeat.o(89237);
      return;
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(89234);
    fixStatusbar(true);
    super.onCreate(paramBundle);
    setActionbarColor(Color.parseColor("#ededed"));
    hideActionbarLine();
    setMMTitle(2131297950);
    this.scene = getIntent().getIntExtra("key_home_page_from_scene", 0);
    initView();
    paramBundle = com.tencent.mm.kernel.g.RL();
    j.p(paramBundle, "MMKernel.storage()");
    this.kzd = paramBundle.Ru().getInt(ac.a.yLf, 0);
    paramBundle = com.tencent.mm.kernel.g.RL();
    j.p(paramBundle, "MMKernel.storage()");
    this.kpz = paramBundle.Ru().getInt(ac.a.yLg, 1);
    if (this.kpz == 0) {
      this.kpz = 1;
    }
    if (this.kzd == 1) {
      com.tencent.mm.plugin.report.service.h.qsU.e(16322, new Object[] { Integer.valueOf(14) });
    }
    ab.i("MicroMsg.CardHomePageNewUI", "on create, scene: %s", new Object[] { Integer.valueOf(this.scene) });
    setBackBtn((MenuItem.OnMenuItemClickListener)new CardHomePageNewUI.n(this));
    if ((this.scene == 1) && (this.kzd == 1)) {
      addTextOptionMenu(0, getString(2131297947), (MenuItem.OnMenuItemClickListener)new o(this));
    }
    com.tencent.mm.plugin.report.service.h.qsU.e(16322, new Object[] { Integer.valueOf(4) });
    ((c)com.tencent.mm.kernel.g.E(c.class)).eJ(8, 2);
    AppMethodBeat.o(89234);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(89235);
    super.onDestroy();
    Object localObject1 = com.tencent.mm.kernel.g.RL();
    j.p(localObject1, "MMKernel.storage()");
    ((e)localObject1).Ru().set(ac.a.yLg, Integer.valueOf(this.kpz));
    if (this.kzj != null)
    {
      localObject1 = this.kzj;
      if (localObject1 == null) {
        j.ebi();
      }
      ((com.tencent.mm.plugin.card.model.a.h)localObject1).cancel();
      this.kzj = null;
    }
    Object localObject2 = this.kyK;
    if (localObject2 == null) {
      j.ays("mRecyclerView");
    }
    localObject1 = this.kzi;
    if (localObject1 != null) {
      localObject1 = new b((a.f.a.a)localObject1);
    }
    for (;;)
    {
      ((LoadMoreRecyclerView)localObject2).removeCallbacks((Runnable)localObject1);
      com.tencent.mm.plugin.card.b.k.bbS();
      ab.i("MicroMsg.CardHomePageNewUI", "do save snap shot");
      Object localObject3 = new op();
      ((op)localObject3).wFf = new LinkedList();
      localObject1 = this.kyV.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((CardHomePageNewUI.a)((Iterator)localObject1).next()).kzm;
        if (localObject2 != null) {
          ((op)localObject3).wFf.add(localObject2);
        }
      }
      localObject2 = new os();
      localObject1 = this.kyX;
      if (localObject1 != null) {}
      for (localObject1 = ((CardHomePageNewUI.a)localObject1).bfi();; localObject1 = null)
      {
        ((os)localObject2).wFq = ((String)localObject1);
        ((os)localObject2).wFf = new LinkedList();
        localObject1 = this.kyW.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject4 = ((CardHomePageNewUI.a)((Iterator)localObject1).next()).kzm;
          if (localObject4 != null) {
            ((os)localObject2).wFf.add(localObject4);
          }
        }
      }
      Object localObject4 = new or();
      localObject1 = this.kyU.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject5 = ((CardHomePageNewUI.a)((Iterator)localObject1).next()).kzq;
        if (localObject5 != null) {
          ((or)localObject4).wFp.add(localObject5);
        }
      }
      localObject1 = new pd();
      ((pd)localObject1).wFP.addAll((Collection)this.kze);
      Object localObject5 = com.tencent.mm.plugin.card.model.a.a.kpr;
      j.q(localObject3, "storeList");
      j.q(localObject2, "underList");
      j.q(localObject4, "topList");
      j.q(localObject1, "sortInfoList");
      ab.i(com.tencent.mm.plugin.card.model.a.a.access$getTAG$cp(), "save home page snapshot");
      localObject3 = ((op)localObject3).toByteArray();
      j.p(localObject3, "storeList.toByteArray()");
      localObject3 = new String((byte[])localObject3, d.ISO_8859_1);
      localObject5 = com.tencent.mm.kernel.g.RL();
      j.p(localObject5, "MMKernel.storage()");
      ((e)localObject5).Ru().set(ac.a.yKV, localObject3);
      localObject2 = ((os)localObject2).toByteArray();
      j.p(localObject2, "underList.toByteArray()");
      localObject2 = new String((byte[])localObject2, d.ISO_8859_1);
      localObject3 = com.tencent.mm.kernel.g.RL();
      j.p(localObject3, "MMKernel.storage()");
      ((e)localObject3).Ru().set(ac.a.yKW, localObject2);
      localObject2 = ((or)localObject4).toByteArray();
      j.p(localObject2, "topList.toByteArray()");
      localObject2 = new String((byte[])localObject2, d.ISO_8859_1);
      localObject3 = com.tencent.mm.kernel.g.RL();
      j.p(localObject3, "MMKernel.storage()");
      ((e)localObject3).Ru().set(ac.a.yKX, localObject2);
      localObject1 = ((pd)localObject1).toByteArray();
      j.p(localObject1, "sortInfoList.toByteArray()");
      localObject1 = new String((byte[])localObject1, d.ISO_8859_1);
      localObject2 = com.tencent.mm.kernel.g.RL();
      j.p(localObject2, "MMKernel.storage()");
      ((e)localObject2).Ru().set(ac.a.yKY, localObject1);
      AppMethodBeat.o(89235);
      return;
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(89236);
    super.onResume();
    if ((this.kza) && (this.kzg != null) && (this.kzb != -1))
    {
      Object localObject = this.kzg;
      if (localObject == null) {
        j.ebi();
      }
      localObject = ((on)localObject).wEJ;
      j.p(localObject, "clickedCardHomePageElement!!.card_pack_merchant_id");
      on localon = this.kzg;
      if (localon == null) {
        j.ebi();
      }
      long l = localon.wFa;
      ab.i("MicroMsg.CardHomePageNewUI", "do get mch infoset: %s", new Object[] { localObject });
      new com.tencent.mm.plugin.card.model.a.g((String)localObject, l, this.cyV, this.cAH, this.kpz).adl().b((com.tencent.mm.vending.c.a)new CardHomePageNewUI.i(this, (String)localObject));
      this.kza = false;
      this.kzg = null;
      AppMethodBeat.o(89236);
      return;
    }
    if (this.kzf)
    {
      this.kzh = true;
      this.offset = 0;
      this.kzf = false;
      bff();
    }
    AppMethodBeat.o(89236);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e$a
    implements View.OnClickListener
  {
    e$a(CardHomePageNewUI.e parame, on paramon, ol paramol, int paramInt1, int paramInt2) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(89191);
      CardHomePageNewUI.j(this.kzM.kzs);
      CardHomePageNewUI.a(this.kzM.kzs, 0);
      CardHomePageNewUI.a(this.kzM.kzs, this.kzN);
      paramView = this.kzM;
      String str = this.kzO.wmm;
      j.p(str, "coupon.user_card_id");
      paramView.Im(str);
      com.tencent.mm.plugin.report.service.h.qsU.e(16324, new Object[] { Integer.valueOf(1), this.kzN.wEJ, Integer.valueOf(this.kzP), this.kzO.wmm, Integer.valueOf(2), Integer.valueOf(this.euX), Integer.valueOf(CardHomePageNewUI.l(this.kzM.kzs)) });
      AppMethodBeat.o(89191);
    }
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e$b
    implements View.OnClickListener
  {
    e$b(CardHomePageNewUI.e parame, on paramon, ol paramol, int paramInt1, int paramInt2) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(89192);
      CardHomePageNewUI.j(this.kzM.kzs);
      CardHomePageNewUI.a(this.kzM.kzs, 0);
      CardHomePageNewUI.a(this.kzM.kzs, this.kzN);
      paramView = this.kzM;
      String str = this.kzO.wmm;
      j.p(str, "coupon.user_card_id");
      paramView.Im(str);
      com.tencent.mm.plugin.report.service.h.qsU.e(16324, new Object[] { Integer.valueOf(1), this.kzN.wEJ, Integer.valueOf(this.kzP), this.kzO.wmm, Integer.valueOf(2), Integer.valueOf(this.euX), Integer.valueOf(CardHomePageNewUI.l(this.kzM.kzs)) });
      AppMethodBeat.o(89192);
    }
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e$f
    implements View.OnClickListener
  {
    e$f(CardHomePageNewUI.e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(154782);
      CardHomePageNewUI.o(this.kzM.kzs);
      AppMethodBeat.o(154782);
    }
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "invoke"})
  static final class f
    extends a.f.b.k
    implements a.f.a.a<y>
  {
    f(CardHomePageNewUI paramCardHomePageNewUI)
    {
      super();
    }
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "kotlin.jvm.PlatformType", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetMktCardHomePageResponse;", "call"})
  static final class h<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    h(CardHomePageNewUI paramCardHomePageNewUI) {}
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class o
    implements MenuItem.OnMenuItemClickListener
  {
    o(CardHomePageNewUI paramCardHomePageNewUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(89228);
      ab.i("MicroMsg.CardHomePageNewUI", "click sort menu");
      CardHomePageNewUI.o(this.kzs);
      AppMethodBeat.o(89228);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v2.CardHomePageNewUI
 * JD-Core Version:    0.7.0.1
 */