package com.tencent.mm.plugin.card.ui.v2;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
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
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.s;
import android.support.v7.widget.RecyclerView.v;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.q;
import com.tencent.mm.kernel.i;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView.a;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.a;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.b;
import com.tencent.mm.plugin.card.b.k;
import com.tencent.mm.plugin.card.ui.CardDetailUI;
import com.tencent.mm.plugin.card.widget.CardTagTextView;
import com.tencent.mm.plugin.card.widget.MemberCardTopCropImageView;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.j;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.protocal.protobuf.tz;
import com.tencent.mm.protocal.protobuf.ua;
import com.tencent.mm.protocal.protobuf.ub;
import com.tencent.mm.protocal.protobuf.ud;
import com.tencent.mm.protocal.protobuf.ue;
import com.tencent.mm.protocal.protobuf.uh;
import com.tencent.mm.protocal.protobuf.ui;
import com.tencent.mm.protocal.protobuf.uk;
import com.tencent.mm.protocal.protobuf.ul;
import com.tencent.mm.protocal.protobuf.un;
import com.tencent.mm.protocal.protobuf.uv;
import com.tencent.mm.protocal.protobuf.uw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.t;
import kotlin.x;

@i
@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI;", "Lcom/tencent/mm/plugin/card/ui/v2/CardNewBaseUI;", "()V", "cardSortInfoList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/CardSortInfo;", "Lkotlin/collections/ArrayList;", "cardTitleModel", "Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$CardListModel;", "clickArea", "", "clickedCardHomePageElement", "Lcom/tencent/mm/protocal/protobuf/CardHomePageElement;", "emptyModel", "faqItem", "Lcom/tencent/mm/protocal/protobuf/CardHomePageFAQItem;", "firstLoad", "", "getCardHomePageScene", "Lcom/tencent/mm/plugin/card/model/v2/CgiGetMktCardHomePage;", "isAll", "isGotoItem", "isLoading", "mDivider", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "mHomePageAdapter", "Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageAdapter;", "mLoadingView", "Landroid/view/ViewGroup;", "mLoadingView2", "mRecyclerView", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "markReloadHomePage", "needReloadHomePage", "offset", "reqNum", "scene", "shouldShowTicket", "showSort", "sortType", "storeModelList", "ticketModel", "ticketNum", "", "tipsDialog", "Landroid/app/Dialog;", "titleSectionModel", "topCellList", "underModelList", "cardSortInfo", "doDeleteMchInList", "", "merchantId", "doGetCardHomePage", "doGetMchInfo", "lastReceiveTime", "", "getLayoutId", "initFirstScreen", "initView", "loadSnapshot", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinishLocationThings", "ret", "isLocationOk", "onResume", "saveSnapshot", "setFaqIconMenu", "showSortSheet", "updateModelList", "storePageList", "Lcom/tencent/mm/protocal/protobuf/CardHomePageStoreList;", "underPageList", "Lcom/tencent/mm/protocal/protobuf/CardHomePageUnderList;", "_topCellList", "Lcom/tencent/mm/protocal/protobuf/CardHomePageTopCellList;", "CardListModel", "CardSpan", "Companion", "HomePageAdapter", "HomePageVH", "plugin-card_release"})
public final class CardHomePageNewUI
  extends CardNewBaseUI
{
  private static final int dse;
  private static final int qfm;
  private static final int qfn;
  public static final CardHomePageNewUI.c qfo;
  private boolean gWt;
  private boolean isLoading;
  private Dialog jUV;
  private int offset;
  private int pVu;
  private LoadMoreRecyclerView qeN;
  private d qeO;
  private ViewGroup qeP;
  private RecyclerView.h qeQ;
  private ViewGroup qeR;
  private int qeS;
  private boolean qeT;
  private String qeU;
  private final ArrayList<a> qeV;
  private final ArrayList<a> qeW;
  private final ArrayList<a> qeX;
  private a qeY;
  private a qeZ;
  private a qfa;
  private a qfb;
  private boolean qfc;
  private int qfd;
  private boolean qfe;
  private int qff;
  private ArrayList<uv> qfg;
  private boolean qfh;
  private ue qfi;
  private ud qfj;
  private boolean qfk;
  private com.tencent.mm.plugin.card.model.a.g qfl;
  private int scene;
  
  static
  {
    AppMethodBeat.i(112470);
    qfo = new CardHomePageNewUI.c((byte)0);
    dse = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 40);
    qfm = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 1);
    qfn = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 16);
    AppMethodBeat.o(112470);
  }
  
  public CardHomePageNewUI()
  {
    AppMethodBeat.i(112469);
    this.qeS = 10;
    this.qeU = "";
    this.qeV = new ArrayList();
    this.qeW = new ArrayList();
    this.qeX = new ArrayList();
    this.gWt = true;
    this.qfd = -1;
    this.qfe = true;
    this.qfg = new ArrayList();
    this.qfi = new ue();
    AppMethodBeat.o(112469);
  }
  
  private final void cwZ()
  {
    AppMethodBeat.i(112468);
    Log.i("MicroMsg.CardHomePageNewUI", "do get card Home page: %s, %s", new Object[] { Boolean.valueOf(this.qeT), Boolean.valueOf(this.isLoading) });
    Object localObject;
    if ((this.qfk) || ((!this.qeT) && (!this.isLoading)))
    {
      this.isLoading = true;
      if (this.qfk)
      {
        localObject = this.qeR;
        if (localObject == null) {
          p.btv("mLoadingView2");
        }
        ((ViewGroup)localObject).setVisibility(0);
        if (this.qfa != null)
        {
          localObject = this.qeR;
          if (localObject == null) {
            p.btv("mLoadingView2");
          }
          localObject = ((ViewGroup)localObject).getLayoutParams();
          if (localObject == null)
          {
            localObject = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            AppMethodBeat.o(112468);
            throw ((Throwable)localObject);
          }
          localObject = (RelativeLayout.LayoutParams)localObject;
          ((RelativeLayout.LayoutParams)localObject).topMargin = com.tencent.mm.cb.a.fromDPToPix((Context)getContext(), 80);
          ViewGroup localViewGroup = this.qeR;
          if (localViewGroup == null) {
            p.btv("mLoadingView2");
          }
          localViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
      localObject = cwY();
      if (localObject == null) {
        break label361;
      }
    }
    label361:
    for (int i = ((uv)localObject).Ler;; i = 10)
    {
      this.qeS = i;
      if (this.jUV != null)
      {
        localObject = this.jUV;
        if (localObject == null) {
          p.hyc();
        }
        ((Dialog)localObject).dismiss();
      }
      if (this.qeW.isEmpty())
      {
        localObject = (Context)getContext();
        getContext().getString(2131755797);
        this.jUV = ((Dialog)com.tencent.mm.ui.base.h.a((Context)localObject, getContext().getString(2131762446), true, null));
      }
      this.qfl = new com.tencent.mm.plugin.card.model.a.g(this.offset, this.qeS, this.latitude, this.dTj, this.pVu);
      localObject = this.qfl;
      if (localObject == null) {
        p.hyc();
      }
      ((com.tencent.mm.plugin.card.model.a.g)localObject).aYH().aYI().b((com.tencent.mm.vending.c.a)new g(this)).a((com.tencent.mm.vending.e.b)this);
      AppMethodBeat.o(112468);
      return;
    }
  }
  
  public final void a(uh paramuh, ul paramul, uk paramuk)
  {
    int j = 0;
    AppMethodBeat.i(112467);
    Object localObject;
    int i;
    if (paramuh != null)
    {
      localObject = paramuh.LdI;
      p.g(localObject, "card_home_page_element");
      if (!((Collection)localObject).isEmpty()) {}
      for (i = 1; i != 0; i = 0)
      {
        paramuh = paramuh.LdI.iterator();
        while (paramuh.hasNext())
        {
          localObject = (ud)paramuh.next();
          a locala = new a();
          locala.qfp = ((ud)localObject);
          locala.type = 0;
          this.qeW.add(locala);
        }
      }
    }
    if (paramul != null)
    {
      paramuh = paramul.LdI;
      p.g(paramuh, "card_home_page_element");
      if (!((Collection)paramuh).isEmpty()) {}
      for (i = 1; i != 0; i = 0)
      {
        if (Util.isNullOrNil(paramul.LdU)) {
          paramul.LdU = getString(2131757040);
        }
        if (this.qeZ == null)
        {
          this.qeZ = new a();
          paramuh = this.qeZ;
          if (paramuh == null) {
            p.hyc();
          }
          paramuh.type = 1;
        }
        paramuh = this.qeZ;
        if (paramuh == null) {
          p.hyc();
        }
        localObject = paramul.LdU;
        p.g(localObject, "section_title");
        paramuh.ajK((String)localObject);
        paramuh = paramul.LdI.iterator();
        while (paramuh.hasNext())
        {
          paramul = (ud)paramuh.next();
          localObject = new a();
          ((a)localObject).qfp = paramul;
          ((a)localObject).type = 2;
          this.qeX.add(localObject);
        }
      }
    }
    if (paramuk != null)
    {
      paramuh = paramuk.LdT;
      p.g(paramuh, "card_home_page_top_cell");
      if (!((Collection)paramuh).isEmpty()) {}
      for (i = 1; i != 0; i = 0)
      {
        paramuh = paramuk.LdT;
        p.g(paramuh, "card_home_page_top_cell");
        paramuh = ((Iterable)paramuh).iterator();
        i = 0;
        while (paramuh.hasNext())
        {
          paramul = (ui)paramuh.next();
          localObject = new a();
          ((a)localObject).qft = paramul;
          ((a)localObject).type = 6;
          if (i == paramuk.LdT.size() - 1) {
            ((a)localObject).qfu = true;
          }
          this.qeV.add(localObject);
          i += 1;
        }
      }
    }
    this.qfb = new a();
    paramuh = this.qfb;
    if (paramuh == null) {
      p.hyc();
    }
    paramuh.type = 5;
    if ((this.qeW.isEmpty()) && (this.qeX.isEmpty()))
    {
      i = j;
      if (!((Collection)this.qeV).isEmpty()) {
        i = 1;
      }
      if (i != 0)
      {
        this.qeY = new a();
        paramuh = this.qeY;
        if (paramuh == null) {
          p.hyc();
        }
        paramuh.type = 7;
        AppMethodBeat.o(112467);
        return;
      }
    }
    this.qeY = null;
    AppMethodBeat.o(112467);
  }
  
  public final void ad(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(112465);
    Log.i("MicroMsg.CardHomePageNewUI", "location finish: [%s, %s], ret: %s, isOk: %s", new Object[] { Float.valueOf(this.latitude), Float.valueOf(this.dTj), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    if (this.gWt)
    {
      if ((this.qff == 1) && (paramInt < 0) && (this.pVu == 1))
      {
        this.pVu = 0;
        if (paramInt == -2) {
          com.tencent.mm.plugin.report.service.h.CyF.a(16322, new Object[] { Integer.valueOf(30) });
        }
      }
      cwZ();
      AppMethodBeat.o(112465);
      return;
    }
    if (!paramBoolean) {
      cxi();
    }
    AppMethodBeat.o(112465);
  }
  
  public final void cwX()
  {
    AppMethodBeat.i(112461);
    ue localue = this.qfi;
    if (localue != null)
    {
      if (!Util.isNullOrNil(localue.LdB))
      {
        removeAllOptionMenu();
        addIconOptionMenu(0, 0, 2131690843, (MenuItem.OnMenuItemClickListener)new n(localue, this));
      }
      AppMethodBeat.o(112461);
      return;
    }
    AppMethodBeat.o(112461);
  }
  
  public final uv cwY()
  {
    AppMethodBeat.i(112466);
    Iterator localIterator = this.qfg.iterator();
    while (localIterator.hasNext())
    {
      uv localuv = (uv)localIterator.next();
      if (localuv.Leq == this.pVu)
      {
        AppMethodBeat.o(112466);
        return localuv;
      }
    }
    AppMethodBeat.o(112466);
    return null;
  }
  
  public final int getLayoutId()
  {
    return 2131493387;
  }
  
  public final void initView()
  {
    int i = 0;
    int j = 1;
    AppMethodBeat.i(112464);
    Object localObject1 = findViewById(2131298705);
    p.g(localObject1, "findViewById(R.id.chpu_rv)");
    this.qeN = ((LoadMoreRecyclerView)localObject1);
    localObject1 = this.qeN;
    if (localObject1 == null) {
      p.btv("mRecyclerView");
    }
    getContext();
    ((LoadMoreRecyclerView)localObject1).setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    this.qeO = new d();
    localObject1 = this.qeN;
    if (localObject1 == null) {
      p.btv("mRecyclerView");
    }
    Object localObject2 = this.qeO;
    if (localObject2 == null) {
      p.btv("mHomePageAdapter");
    }
    ((LoadMoreRecyclerView)localObject1).setAdapter((RecyclerView.a)localObject2);
    localObject1 = LayoutInflater.from((Context)this);
    localObject2 = this.qeN;
    if (localObject2 == null) {
      p.btv("mRecyclerView");
    }
    localObject1 = ((LayoutInflater)localObject1).inflate(2131493384, (ViewGroup)localObject2, false);
    if (localObject1 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(112464);
      throw ((Throwable)localObject1);
    }
    this.qeP = ((ViewGroup)localObject1);
    localObject1 = findViewById(2131298704);
    p.g(localObject1, "findViewById(R.id.chpu_loading_layout)");
    this.qeR = ((ViewGroup)localObject1);
    localObject1 = this.qeN;
    if (localObject1 == null) {
      p.btv("mRecyclerView");
    }
    localObject2 = this.qeP;
    if (localObject2 == null) {
      p.btv("mLoadingView");
    }
    ((LoadMoreRecyclerView)localObject1).setLoadingView((View)localObject2);
    this.qeQ = ((RecyclerView.h)new i(this));
    localObject1 = this.qeN;
    if (localObject1 == null) {
      p.btv("mRecyclerView");
    }
    localObject2 = this.qeQ;
    if (localObject2 == null) {
      p.btv("mDivider");
    }
    ((LoadMoreRecyclerView)localObject1).b((RecyclerView.h)localObject2);
    localObject1 = this.qeN;
    if (localObject1 == null) {
      p.btv("mRecyclerView");
    }
    ((LoadMoreRecyclerView)localObject1).setOnLoadingStateChangedListener((LoadMoreRecyclerView.a)new j(this));
    localObject1 = this.qeN;
    if (localObject1 == null) {
      p.btv("mRecyclerView");
    }
    ((LoadMoreRecyclerView)localObject1).setOnItemClickListener((MRecyclerView.a)new k(this));
    localObject1 = this.qeN;
    if (localObject1 == null) {
      p.btv("mRecyclerView");
    }
    ((LoadMoreRecyclerView)localObject1).setOnItemLongClickListener((MRecyclerView.b)new l(this));
    localObject1 = new uh();
    localObject2 = new ul();
    uk localuk = new uk();
    uw localuw = new uw();
    Object localObject3 = com.tencent.mm.plugin.card.model.a.a.pVg;
    localObject3 = this.qfi;
    p.h(localObject1, "storeList");
    p.h(localObject2, "underList");
    p.h(localuk, "topList");
    p.h(localuw, "cardSortInfoList");
    Log.i(com.tencent.mm.plugin.card.model.a.a.access$getTAG$cp(), "load home page snapshot");
    Object localObject4 = com.tencent.mm.kernel.g.aAh();
    p.g(localObject4, "MMKernel.storage()");
    localObject4 = (String)((com.tencent.mm.kernel.e)localObject4).azQ().i(ar.a.OhC);
    Charset localCharset;
    if (localObject4 != null)
    {
      localCharset = kotlin.n.d.ISO_8859_1;
      if (localObject4 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(112464);
        throw ((Throwable)localObject1);
      }
      localObject4 = ((String)localObject4).getBytes(localCharset);
      p.g(localObject4, "(this as java.lang.String).getBytes(charset)");
      ((uh)localObject1).parseFrom((byte[])localObject4);
      i = 1;
    }
    localObject4 = com.tencent.mm.kernel.g.aAh();
    p.g(localObject4, "MMKernel.storage()");
    localObject4 = (String)((com.tencent.mm.kernel.e)localObject4).azQ().i(ar.a.OhD);
    if (localObject4 != null)
    {
      localCharset = kotlin.n.d.ISO_8859_1;
      if (localObject4 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(112464);
        throw ((Throwable)localObject1);
      }
      localObject4 = ((String)localObject4).getBytes(localCharset);
      p.g(localObject4, "(this as java.lang.String).getBytes(charset)");
      ((ul)localObject2).parseFrom((byte[])localObject4);
      i = 1;
    }
    localObject4 = com.tencent.mm.kernel.g.aAh();
    p.g(localObject4, "MMKernel.storage()");
    localObject4 = (String)((com.tencent.mm.kernel.e)localObject4).azQ().i(ar.a.OhE);
    if (localObject4 != null)
    {
      localCharset = kotlin.n.d.ISO_8859_1;
      if (localObject4 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(112464);
        throw ((Throwable)localObject1);
      }
      localObject4 = ((String)localObject4).getBytes(localCharset);
      p.g(localObject4, "(this as java.lang.String).getBytes(charset)");
      localuk.parseFrom((byte[])localObject4);
      i = 1;
    }
    localObject4 = com.tencent.mm.kernel.g.aAh();
    p.g(localObject4, "MMKernel.storage()");
    localObject4 = (String)((com.tencent.mm.kernel.e)localObject4).azQ().i(ar.a.OhF);
    if (localObject4 != null)
    {
      localCharset = kotlin.n.d.ISO_8859_1;
      if (localObject4 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(112464);
        throw ((Throwable)localObject1);
      }
      localObject4 = ((String)localObject4).getBytes(localCharset);
      p.g(localObject4, "(this as java.lang.String).getBytes(charset)");
      localuw.parseFrom((byte[])localObject4);
      i = 1;
    }
    localObject4 = com.tencent.mm.kernel.g.aAh();
    p.g(localObject4, "MMKernel.storage()");
    localObject4 = (String)((com.tencent.mm.kernel.e)localObject4).azQ().i(ar.a.OhG);
    if (localObject4 != null)
    {
      i = j;
      if (localObject3 != null)
      {
        localCharset = kotlin.n.d.ISO_8859_1;
        if (localObject4 == null)
        {
          localObject1 = new t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(112464);
          throw ((Throwable)localObject1);
        }
        localObject4 = ((String)localObject4).getBytes(localCharset);
        p.g(localObject4, "(this as java.lang.String).getBytes(charset)");
        ((ue)localObject3).parseFrom((byte[])localObject4);
        i = j;
      }
    }
    for (;;)
    {
      this.qfg.clear();
      this.qfg.addAll((Collection)localuw.Let);
      a((uh)localObject1, (ul)localObject2, localuk);
      if ((i == 0) && (this.qeW.isEmpty()) && (this.qeX.isEmpty()))
      {
        Log.i("MicroMsg.CardHomePageNewUI", "show init view");
        localObject1 = new a();
        ((a)localObject1).type = 3;
        localObject2 = new a();
        ((a)localObject2).type = 3;
        this.qeW.add(localObject1);
        this.qeW.add(localObject2);
      }
      cwX();
      localObject1 = this.qeN;
      if (localObject1 == null) {
        p.btv("mRecyclerView");
      }
      localObject1 = ((LoadMoreRecyclerView)localObject1).getAdapter();
      if (localObject1 == null) {
        break;
      }
      ((RecyclerView.a)localObject1).notifyDataSetChanged();
      AppMethodBeat.o(112464);
      return;
    }
    AppMethodBeat.o(112464);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(112460);
    fixStatusbar(true);
    super.onCreate(paramBundle);
    hideActionbarLine();
    setMMTitle(2131757061);
    this.scene = getIntent().getIntExtra("key_home_page_from_scene", 0);
    initView();
    this.qff = 1;
    paramBundle = com.tencent.mm.kernel.g.aAh();
    p.g(paramBundle, "MMKernel.storage()");
    this.pVu = paramBundle.azQ().getInt(ar.a.Oid, 1);
    if (this.pVu == 0) {
      this.pVu = 1;
    }
    if (this.qff == 1) {
      com.tencent.mm.plugin.report.service.h.CyF.a(16322, new Object[] { Integer.valueOf(14) });
    }
    Log.i("MicroMsg.CardHomePageNewUI", "on create, scene: %s", new Object[] { Integer.valueOf(this.scene) });
    setBackBtn((MenuItem.OnMenuItemClickListener)new m(this));
    com.tencent.mm.plugin.report.service.h.CyF.a(16322, new Object[] { Integer.valueOf(4) });
    ((com.tencent.mm.pluginsdk.wallet.b)com.tencent.mm.kernel.g.af(com.tencent.mm.pluginsdk.wallet.b.class)).he(8, 2);
    AppMethodBeat.o(112460);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(112462);
    super.onDestroy();
    Object localObject1 = com.tencent.mm.kernel.g.aAh();
    p.g(localObject1, "MMKernel.storage()");
    ((com.tencent.mm.kernel.e)localObject1).azQ().set(ar.a.Oid, Integer.valueOf(this.pVu));
    if (this.qfl != null)
    {
      localObject1 = this.qfl;
      if (localObject1 == null) {
        p.hyc();
      }
      ((com.tencent.mm.plugin.card.model.a.g)localObject1).cancel();
      this.qfl = null;
    }
    k.ctF();
    Log.i("MicroMsg.CardHomePageNewUI", "do save snap shot");
    Object localObject3 = new uh();
    ((uh)localObject3).LdI = new LinkedList();
    localObject1 = this.qeW.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((a)((Iterator)localObject1).next()).qfp;
      if (localObject2 != null) {
        ((uh)localObject3).LdI.add(localObject2);
      }
    }
    Object localObject2 = new ul();
    localObject1 = this.qeZ;
    if (localObject1 != null) {}
    for (localObject1 = ((a)localObject1).cxc();; localObject1 = null)
    {
      ((ul)localObject2).LdU = ((String)localObject1);
      ((ul)localObject2).LdI = new LinkedList();
      localObject1 = this.qeX.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject4 = ((a)((Iterator)localObject1).next()).qfp;
        if (localObject4 != null) {
          ((ul)localObject2).LdI.add(localObject4);
        }
      }
    }
    uk localuk = new uk();
    localObject1 = this.qeV.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject4 = ((a)((Iterator)localObject1).next()).qft;
      if (localObject4 != null) {
        localuk.LdT.add(localObject4);
      }
    }
    Object localObject4 = new uw();
    ((uw)localObject4).Let.addAll((Collection)this.qfg);
    localObject1 = com.tencent.mm.plugin.card.model.a.a.pVg;
    localObject1 = this.qfi;
    p.h(localObject3, "storeList");
    p.h(localObject2, "underList");
    p.h(localuk, "topList");
    p.h(localObject4, "sortInfoList");
    Log.i(com.tencent.mm.plugin.card.model.a.a.access$getTAG$cp(), "save home page snapshot");
    localObject3 = ((uh)localObject3).toByteArray();
    p.g(localObject3, "storeList.toByteArray()");
    localObject3 = new String((byte[])localObject3, kotlin.n.d.ISO_8859_1);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.aAh();
    p.g(locale, "MMKernel.storage()");
    locale.azQ().set(ar.a.OhC, localObject3);
    localObject2 = ((ul)localObject2).toByteArray();
    p.g(localObject2, "underList.toByteArray()");
    localObject2 = new String((byte[])localObject2, kotlin.n.d.ISO_8859_1);
    localObject3 = com.tencent.mm.kernel.g.aAh();
    p.g(localObject3, "MMKernel.storage()");
    ((com.tencent.mm.kernel.e)localObject3).azQ().set(ar.a.OhD, localObject2);
    localObject2 = localuk.toByteArray();
    p.g(localObject2, "topList.toByteArray()");
    localObject2 = new String((byte[])localObject2, kotlin.n.d.ISO_8859_1);
    localObject3 = com.tencent.mm.kernel.g.aAh();
    p.g(localObject3, "MMKernel.storage()");
    ((com.tencent.mm.kernel.e)localObject3).azQ().set(ar.a.OhE, localObject2);
    localObject2 = ((uw)localObject4).toByteArray();
    p.g(localObject2, "sortInfoList.toByteArray()");
    localObject2 = new String((byte[])localObject2, kotlin.n.d.ISO_8859_1);
    localObject3 = com.tencent.mm.kernel.g.aAh();
    p.g(localObject3, "MMKernel.storage()");
    ((com.tencent.mm.kernel.e)localObject3).azQ().set(ar.a.OhF, localObject2);
    if (localObject1 != null)
    {
      localObject1 = ((ue)localObject1).toByteArray();
      p.g(localObject1, "faqItem.toByteArray()");
      localObject1 = new String((byte[])localObject1, kotlin.n.d.ISO_8859_1);
      localObject2 = com.tencent.mm.kernel.g.aAh();
      p.g(localObject2, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject2).azQ().set(ar.a.OhG, localObject1);
    }
    AppMethodBeat.o(112462);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(112463);
    super.onResume();
    if ((this.qfc) && (this.qfj != null) && (this.qfd != -1))
    {
      Object localObject = this.qfj;
      if (localObject == null) {
        p.hyc();
      }
      localObject = ((ud)localObject).Ldn;
      p.g(localObject, "clickedCardHomePageElement!!.card_pack_merchant_id");
      ud localud = this.qfj;
      if (localud == null) {
        p.hyc();
      }
      long l = localud.LdA;
      Log.i("MicroMsg.CardHomePageNewUI", "do get mch infoset: %s", new Object[] { localObject });
      new com.tencent.mm.plugin.card.model.a.f((String)localObject, l, this.latitude, this.dTj, this.pVu).aYI().b((com.tencent.mm.vending.c.a)new h(this, (String)localObject));
      this.qfc = false;
      this.qfj = null;
      AppMethodBeat.o(112463);
      return;
    }
    if (this.qfh)
    {
      this.qfk = true;
      this.offset = 0;
      this.qfh = false;
      cwZ();
    }
    AppMethodBeat.o(112463);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$CardListModel;", "", "(Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI;)V", "element", "Lcom/tencent/mm/protocal/protobuf/CardHomePageElement;", "getElement", "()Lcom/tencent/mm/protocal/protobuf/CardHomePageElement;", "setElement", "(Lcom/tencent/mm/protocal/protobuf/CardHomePageElement;)V", "expandState", "", "getExpandState", "()Z", "setExpandState", "(Z)V", "hasRender", "getHasRender", "setHasRender", "sectionTitle", "", "getSectionTitle", "()Ljava/lang/String;", "setSectionTitle", "(Ljava/lang/String;)V", "showDivider", "getShowDivider", "setShowDivider", "topElement", "Lcom/tencent/mm/protocal/protobuf/CardHomePageTopCell;", "getTopElement", "()Lcom/tencent/mm/protocal/protobuf/CardHomePageTopCell;", "setTopElement", "(Lcom/tencent/mm/protocal/protobuf/CardHomePageTopCell;)V", "type", "", "getType", "()I", "setType", "(I)V", "plugin-card_release"})
  public final class a
  {
    ud qfp;
    public String qfq;
    boolean qfr;
    boolean qfs;
    ui qft;
    boolean qfu;
    int type;
    
    public final void ajK(String paramString)
    {
      AppMethodBeat.i(112405);
      p.h(paramString, "<set-?>");
      this.qfq = paramString;
      AppMethodBeat.o(112405);
    }
    
    public final String cxc()
    {
      AppMethodBeat.i(112404);
      String str = this.qfq;
      if (str == null) {
        p.btv("sectionTitle");
      }
      AppMethodBeat.o(112404);
      return str;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH;", "Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI;", "(Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI;)V", "appendUnderList", "", "model", "Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$CardListModel;", "getItemCount", "", "getItemViewType", "position", "getModelByPos", "getPosByMerchantId", "merchantId", "", "moveStoreToUnderList", "", "element", "Lcom/tencent/mm/protocal/protobuf/CardHomePageElement;", "onBindViewHolder", "holder", "payloads", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "removeModelByMId", "removeTitleSection", "replaceModelByMId", "mchInfo", "plugin-card_release"})
  public final class d
    extends RecyclerView.a<CardHomePageNewUI.e>
  {
    private int ajM(String paramString)
    {
      int k = 0;
      AppMethodBeat.i(112415);
      p.h(paramString, "merchantId");
      if (CardHomePageNewUI.g(this.qfv) != null) {}
      for (int i = 1;; i = 0)
      {
        if (CardHomePageNewUI.f(this.qfv) != null) {
          i += 1;
        }
        for (;;)
        {
          Iterator localIterator = ((Iterable)CardHomePageNewUI.a(this.qfv)).iterator();
          int j = 0;
          Object localObject;
          while (localIterator.hasNext())
          {
            localObject = ((CardHomePageNewUI.a)localIterator.next()).qfp;
            if (localObject != null) {}
            for (localObject = ((ud)localObject).Ldn; p.j(localObject, paramString); localObject = null)
            {
              AppMethodBeat.o(112415);
              return i + j;
            }
            j += 1;
          }
          i = CardHomePageNewUI.a(this.qfv).size() + i - 1;
          if (CardHomePageNewUI.c(this.qfv) != null) {
            i += 1;
          }
          for (;;)
          {
            localIterator = ((Iterable)CardHomePageNewUI.b(this.qfv)).iterator();
            j = k;
            while (localIterator.hasNext())
            {
              localObject = ((CardHomePageNewUI.a)localIterator.next()).qfp;
              if (localObject != null) {}
              for (localObject = ((ud)localObject).Ldn; p.j(localObject, paramString); localObject = null)
              {
                AppMethodBeat.o(112415);
                return i + j + 1;
              }
              j += 1;
            }
            AppMethodBeat.o(112415);
            return -1;
          }
        }
      }
    }
    
    public final CardHomePageNewUI.a Ex(int paramInt)
    {
      int j = 0;
      AppMethodBeat.i(112413);
      Object localObject1 = CardHomePageNewUI.a(this.qfv);
      Object localObject2;
      if (localObject1 != null)
      {
        localObject1 = Integer.valueOf(((ArrayList)localObject1).size());
        localObject2 = CardHomePageNewUI.a(this.qfv);
        if (localObject2 == null) {
          break label156;
        }
        localObject2 = Integer.valueOf(((ArrayList)localObject2).size());
        label55:
        if (CardHomePageNewUI.c(this.qfv) == null) {
          break label162;
        }
      }
      label156:
      label162:
      for (boolean bool = true;; bool = false)
      {
        Log.d("MicroMsg.CardHomePageNewUI", "pos: %s, sSize: %s, uSize: %s, title: %s", new Object[] { Integer.valueOf(paramInt), localObject1, localObject2, Boolean.valueOf(bool) });
        localObject1 = CardHomePageNewUI.g(this.qfv);
        if (localObject1 == null) {
          break label174;
        }
        if (paramInt + 0 >= ((ArrayList)localObject1).size()) {
          break label168;
        }
        localObject1 = (CardHomePageNewUI.a)((ArrayList)localObject1).get(paramInt + 0);
        AppMethodBeat.o(112413);
        return localObject1;
        localObject1 = null;
        break;
        localObject2 = null;
        break label55;
      }
      label168:
      j = ((ArrayList)localObject1).size();
      label174:
      localObject1 = CardHomePageNewUI.f(this.qfv);
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
      localObject1 = CardHomePageNewUI.h(this.qfv);
      if ((localObject1 != null) && (paramInt == i))
      {
        AppMethodBeat.o(112413);
        return localObject1;
      }
      localObject1 = CardHomePageNewUI.a(this.qfv);
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
      if (CardHomePageNewUI.c(this.qfv) != null)
      {
        j += 1;
        i = j;
        if (paramInt == j)
        {
          localObject1 = CardHomePageNewUI.c(this.qfv);
          AppMethodBeat.o(112413);
          return localObject1;
        }
      }
      localObject1 = CardHomePageNewUI.b(this.qfv);
      if ((localObject1 != null) && (paramInt > i) && (paramInt <= ((ArrayList)localObject1).size() + i))
      {
        localObject1 = (CardHomePageNewUI.a)((ArrayList)localObject1).get(paramInt - i - 1);
        AppMethodBeat.o(112413);
        return localObject1;
      }
      AppMethodBeat.o(112413);
      return null;
    }
    
    public final void a(String paramString, ud paramud)
    {
      AppMethodBeat.i(112416);
      p.h(paramString, "merchantId");
      p.h(paramud, "mchInfo");
      Iterator localIterator = CardHomePageNewUI.a(this.qfv).iterator();
      CardHomePageNewUI.a locala;
      Object localObject;
      int i;
      while (localIterator.hasNext())
      {
        locala = (CardHomePageNewUI.a)localIterator.next();
        localObject = locala.qfp;
        if (localObject != null) {}
        for (localObject = ((ud)localObject).Ldn; p.j(localObject, paramString); localObject = null)
        {
          locala.qfp = paramud;
          i = ajM(paramString);
          if (i < 0) {
            break label130;
          }
          paramString = CardHomePageNewUI.j(this.qfv).getAdapter();
          if (paramString == null) {
            break label130;
          }
          paramString.b(i, Boolean.TRUE);
          AppMethodBeat.o(112416);
          return;
        }
        continue;
        label130:
        AppMethodBeat.o(112416);
        return;
      }
      localIterator = CardHomePageNewUI.b(this.qfv).iterator();
      while (localIterator.hasNext())
      {
        locala = (CardHomePageNewUI.a)localIterator.next();
        localObject = locala.qfp;
        if (localObject != null) {}
        for (localObject = ((ud)localObject).Ldn; p.j(localObject, paramString); localObject = null)
        {
          locala.qfp = paramud;
          i = ajM(paramString);
          if (i < 0) {
            break label249;
          }
          paramString = CardHomePageNewUI.j(this.qfv).getAdapter();
          if (paramString == null) {
            break label249;
          }
          paramString.b(i, Boolean.TRUE);
          AppMethodBeat.o(112416);
          return;
        }
        continue;
        label249:
        AppMethodBeat.o(112416);
        return;
      }
      AppMethodBeat.o(112416);
    }
    
    public final void ajL(String paramString)
    {
      AppMethodBeat.i(112414);
      p.h(paramString, "merchantId");
      Iterator localIterator = CardHomePageNewUI.a(this.qfv).iterator();
      CardHomePageNewUI.a locala;
      Object localObject;
      while (localIterator.hasNext())
      {
        locala = (CardHomePageNewUI.a)localIterator.next();
        localObject = locala.qfp;
        if (localObject != null) {}
        for (localObject = ((ud)localObject).Ldn; p.j(localObject, paramString); localObject = null)
        {
          CardHomePageNewUI.a(this.qfv).remove(locala);
          paramString = CardHomePageNewUI.j(this.qfv).getAdapter();
          if (paramString == null) {
            break label108;
          }
          paramString.notifyDataSetChanged();
          AppMethodBeat.o(112414);
          return;
        }
        continue;
        label108:
        AppMethodBeat.o(112414);
        return;
      }
      localIterator = CardHomePageNewUI.b(this.qfv).iterator();
      while (localIterator.hasNext())
      {
        locala = (CardHomePageNewUI.a)localIterator.next();
        localObject = locala.qfp;
        if (localObject != null) {}
        for (localObject = ((ud)localObject).Ldn; p.j(localObject, paramString); localObject = null)
        {
          CardHomePageNewUI.b(this.qfv).remove(locala);
          if (CardHomePageNewUI.b(this.qfv).size() != 0) {
            break label231;
          }
          CardHomePageNewUI.d(this.qfv);
          paramString = CardHomePageNewUI.j(this.qfv).getAdapter();
          if (paramString == null) {
            break label231;
          }
          paramString.notifyDataSetChanged();
          AppMethodBeat.o(112414);
          return;
        }
        continue;
        label231:
        AppMethodBeat.o(112414);
        return;
      }
      AppMethodBeat.o(112414);
    }
    
    public final int getItemCount()
    {
      int i2 = 1;
      AppMethodBeat.i(112409);
      ArrayList localArrayList = CardHomePageNewUI.a(this.qfv);
      int i;
      int j;
      if (localArrayList != null)
      {
        i = localArrayList.size();
        localArrayList = CardHomePageNewUI.b(this.qfv);
        if (localArrayList == null) {
          break label147;
        }
        j = localArrayList.size();
        label49:
        if (CardHomePageNewUI.c(this.qfv) == null) {
          break label176;
        }
      }
      label147:
      label158:
      label176:
      for (int k = 1;; k = 0)
      {
        if (CardHomePageNewUI.e(this.qfv) != null) {}
        for (int m = 1;; m = 0)
        {
          if (CardHomePageNewUI.f(this.qfv) != null) {}
          for (int n = 1;; n = 0)
          {
            localArrayList = CardHomePageNewUI.g(this.qfv);
            int i1;
            if (localArrayList != null)
            {
              i1 = localArrayList.size();
              label108:
              if (CardHomePageNewUI.h(this.qfv) == null) {
                break label158;
              }
            }
            for (;;)
            {
              AppMethodBeat.o(112409);
              return i + j + k + m + n + i1 + i2;
              i = 0;
              break;
              j = 0;
              break label49;
              i1 = 0;
              break label108;
              i2 = 0;
            }
          }
        }
      }
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(112410);
      CardHomePageNewUI.a locala = Ex(paramInt);
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
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "viewType", "", "(Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI;Landroid/view/View;I)V", "chpiCouponLayout", "Landroid/widget/LinearLayout;", "getChpiCouponLayout", "()Landroid/widget/LinearLayout;", "setChpiCouponLayout", "(Landroid/widget/LinearLayout;)V", "chpiDescTv", "Landroid/widget/TextView;", "getChpiDescTv", "()Landroid/widget/TextView;", "setChpiDescTv", "(Landroid/widget/TextView;)V", "chpiExpandIv", "Landroid/widget/ImageView;", "getChpiExpandIv", "()Landroid/widget/ImageView;", "setChpiExpandIv", "(Landroid/widget/ImageView;)V", "chpiExpandLayout", "getChpiExpandLayout", "setChpiExpandLayout", "chpiExpandTv", "getChpiExpandTv", "setChpiExpandTv", "chpiHeaderLayout", "getChpiHeaderLayout", "setChpiHeaderLayout", "chpiLabelLayout", "getChpiLabelLayout", "setChpiLabelLayout", "chpiLogoIv", "Lcom/tencent/mm/pluginsdk/ui/applet/CdnImageView;", "getChpiLogoIv", "()Lcom/tencent/mm/pluginsdk/ui/applet/CdnImageView;", "setChpiLogoIv", "(Lcom/tencent/mm/pluginsdk/ui/applet/CdnImageView;)V", "chpiMchLabelTv", "Lcom/tencent/mm/plugin/card/ui/v2/CardLabelTextView;", "getChpiMchLabelTv", "()Lcom/tencent/mm/plugin/card/ui/v2/CardLabelTextView;", "setChpiMchLabelTv", "(Lcom/tencent/mm/plugin/card/ui/v2/CardLabelTextView;)V", "chpiNameTv", "getChpiNameTv", "setChpiNameTv", "chtiDescTv", "getChtiDescTv", "setChtiDescTv", "chtiDivider", "getChtiDivider", "()Landroid/view/View;", "setChtiDivider", "(Landroid/view/View;)V", "chtiIconIv", "getChtiIconIv", "setChtiIconIv", "chtiNewTv", "getChtiNewTv", "setChtiNewTv", "chtiRedDotIv", "getChtiRedDotIv", "setChtiRedDotIv", "chtiRightIv", "getChtiRightIv", "setChtiRightIv", "chtiTitleTv", "getChtiTitleTv", "setChtiTitleTv", "model", "Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$CardListModel;", "Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI;", "getModel", "()Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$CardListModel;", "setModel", "(Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$CardListModel;)V", "sectionTitleTv", "getSectionTitleTv", "setSectionTitleTv", "addCouponView", "", "view", "appendCouponView", "offset", "len", "position", "collapseCouponLayout", "expandCouponLayout", "gotoCardDetailUI", "cardId", "", "setCardBg", "imageView", "url", "radius", "", "defaultRes", "setIcon", "useBackendExpandState", "", "showCollapseLayout", "showExpandLayout", "showMiniAppLayout", "updateCardLabelLayout", "couponLabelList", "", "Lcom/tencent/mm/protocal/protobuf/CardElementCouponLabel;", "labelLayout", "labelList", "Lcom/tencent/mm/protocal/protobuf/CardElementMchLabel;", "updateExpandLayout", "isExpended", "plugin-card_release"})
  public final class e
    extends RecyclerView.v
  {
    public LinearLayout qfA;
    public LinearLayout qfB;
    public LinearLayout qfC;
    public LinearLayout qfD;
    public TextView qfE;
    public ImageView qfF;
    public CardLabelTextView qfG;
    public ImageView qfH;
    public TextView qfI;
    public TextView qfJ;
    public ImageView qfK;
    public ImageView qfL;
    public TextView qfM;
    public View qfN;
    CardHomePageNewUI.a qfO;
    public TextView qfw;
    public CdnImageView qfx;
    public TextView qfy;
    public TextView qfz;
    
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
        this$1 = paramInt.findViewById(2131298690);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_logo_iv)");
        this.qfx = ((CdnImageView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298694);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_username_tv)");
        this.qfy = ((TextView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298684);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_desc_tv)");
        this.qfz = ((TextView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298689);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_label_layout)");
        this.qfB = ((LinearLayout)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298683);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_coupon_layout)");
        this.qfC = ((LinearLayout)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298686);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_expand_layout)");
        this.qfD = ((LinearLayout)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298685);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_expand_iv)");
        this.qfF = ((ImageView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298687);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_expand_tv)");
        this.qfE = ((TextView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298691);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_mch_label_tv)");
        this.qfG = ((CardLabelTextView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298688);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_header_layout)");
        this.qfA = ((LinearLayout)CardHomePageNewUI.this);
        AppMethodBeat.o(112438);
        return;
        this$1 = paramInt.findViewById(2131298692);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_section_title)");
        this.qfw = ((TextView)CardHomePageNewUI.this);
        AppMethodBeat.o(112438);
        return;
        this$1 = paramInt.findViewById(2131298690);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_logo_iv)");
        this.qfx = ((CdnImageView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298694);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_username_tv)");
        this.qfy = ((TextView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298684);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_desc_tv)");
        this.qfz = ((TextView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298691);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_mch_label_tv)");
        this.qfG = ((CardLabelTextView)CardHomePageNewUI.this);
        AppMethodBeat.o(112438);
        return;
        this$1 = paramInt.findViewById(2131298690);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_logo_iv)");
        this.qfx = ((CdnImageView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298694);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_username_tv)");
        this.qfy = ((TextView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298684);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_desc_tv)");
        this.qfz = ((TextView)CardHomePageNewUI.this);
        AppMethodBeat.o(112438);
        return;
        this$1 = paramInt.findViewById(2131298724);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_icon_iv)");
        this.qfH = ((ImageView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298728);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_title_tv)");
        this.qfI = ((TextView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298722);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_desc_tv)");
        this.qfJ = ((TextView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298727);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_right_iv)");
        this.qfK = ((ImageView)CardHomePageNewUI.this);
        AppMethodBeat.o(112438);
        return;
        this$1 = paramInt.findViewById(2131298724);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_icon_iv)");
        this.qfH = ((ImageView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298728);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_title_tv)");
        this.qfI = ((TextView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298722);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_desc_tv)");
        this.qfJ = ((TextView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298727);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_right_iv)");
        this.qfK = ((ImageView)CardHomePageNewUI.this);
        AppMethodBeat.o(112438);
        return;
        this$1 = paramInt.findViewById(2131298724);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_icon_iv)");
        this.qfH = ((ImageView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298728);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_title_tv)");
        this.qfI = ((TextView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298722);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_desc_tv)");
        this.qfJ = ((TextView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298727);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_right_iv)");
        this.qfK = ((ImageView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298726);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_reddot_iv)");
        this.qfL = ((ImageView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298725);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_new_tv)");
        this.qfM = ((TextView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298723);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_divider)");
        this.qfN = CardHomePageNewUI.this;
      }
    }
    
    private final void C(boolean paramBoolean, int paramInt)
    {
      AppMethodBeat.i(112437);
      Object localObject = this.qfO;
      if (localObject == null) {
        p.hyc();
      }
      localObject = ((CardHomePageNewUI.a)localObject).qfp;
      if (paramBoolean)
      {
        if (localObject != null) {}
        for (localObject = ((ud)localObject).Ldt; !Util.isNullOrNil((String)localObject); localObject = null)
        {
          Ey(paramInt);
          AppMethodBeat.o(112437);
          return;
        }
        EA(paramInt);
        AppMethodBeat.o(112437);
        return;
      }
      Ez(paramInt);
      AppMethodBeat.o(112437);
    }
    
    private final void EA(final int paramInt)
    {
      AppMethodBeat.i(112436);
      Object localObject1 = this.qfO;
      if (localObject1 == null) {
        p.hyc();
      }
      localObject1 = ((CardHomePageNewUI.a)localObject1).qfp;
      Object localObject2 = this.qfE;
      if (localObject2 == null) {
        p.btv("chpiExpandTv");
      }
      ((TextView)localObject2).setText((CharSequence)MMApplicationContext.getResources().getString(2131757039));
      localObject2 = this.qfD;
      if (localObject2 == null) {
        p.btv("chpiExpandLayout");
      }
      ((LinearLayout)localObject2).setOnClickListener((View.OnClickListener)new g(this, paramInt, (ud)localObject1));
      localObject1 = this.qfF;
      if (localObject1 == null) {
        p.btv("chpiExpandIv");
      }
      ((ImageView)localObject1).setImageResource(2131231562);
      localObject1 = this.qfF;
      if (localObject1 == null) {
        p.btv("chpiExpandIv");
      }
      ((ImageView)localObject1).setVisibility(0);
      AppMethodBeat.o(112436);
    }
    
    private final void Ey(final int paramInt)
    {
      AppMethodBeat.i(112434);
      Object localObject1 = this.qfO;
      if (localObject1 == null) {
        p.hyc();
      }
      localObject1 = ((CardHomePageNewUI.a)localObject1).qfp;
      if (localObject1 == null) {
        p.hyc();
      }
      if (!Util.isNullOrNil(((ud)localObject1).Ldt))
      {
        if (!Util.isNullOrNil(((ud)localObject1).Ldu))
        {
          localObject2 = this.qfE;
          if (localObject2 == null) {
            p.btv("chpiExpandTv");
          }
          ((TextView)localObject2).setTextColor(Color.parseColor(((ud)localObject1).Ldu));
        }
        Object localObject2 = this.qfE;
        if (localObject2 == null) {
          p.btv("chpiExpandTv");
        }
        ((TextView)localObject2).setText((CharSequence)((ud)localObject1).Ldt);
        localObject2 = this.qfF;
        if (localObject2 == null) {
          p.btv("chpiExpandIv");
        }
        ((ImageView)localObject2).setImageResource(2131231500);
        localObject2 = this.qfD;
        if (localObject2 == null) {
          p.btv("chpiExpandLayout");
        }
        ((LinearLayout)localObject2).setOnClickListener((View.OnClickListener)new i((ud)localObject1, this, paramInt));
      }
      AppMethodBeat.o(112434);
    }
    
    private final void Ez(final int paramInt)
    {
      AppMethodBeat.i(112435);
      Object localObject1 = this.qfO;
      if (localObject1 == null) {
        p.hyc();
      }
      localObject1 = ((CardHomePageNewUI.a)localObject1).qfp;
      Object localObject2 = this.qfE;
      if (localObject2 == null) {
        p.btv("chpiExpandTv");
      }
      Resources localResources = MMApplicationContext.getResources();
      if (localObject1 == null) {
        p.hyc();
      }
      ((TextView)localObject2).setText((CharSequence)localResources.getString(2131757041, new Object[] { Integer.valueOf(((ud)localObject1).Ldy - ((ud)localObject1).Ldz) }));
      localObject2 = this.qfD;
      if (localObject2 == null) {
        p.btv("chpiExpandLayout");
      }
      ((LinearLayout)localObject2).setOnClickListener((View.OnClickListener)new h(this, paramInt, (ud)localObject1));
      localObject1 = this.qfF;
      if (localObject1 == null) {
        p.btv("chpiExpandIv");
      }
      ((ImageView)localObject1).setImageResource(2131231561);
      localObject1 = this.qfF;
      if (localObject1 == null) {
        p.btv("chpiExpandIv");
      }
      ((ImageView)localObject1).setVisibility(0);
      AppMethodBeat.o(112435);
    }
    
    private final void V(int paramInt1, int paramInt2, final int paramInt3)
    {
      AppMethodBeat.i(112428);
      Object localObject1 = this.qfO;
      if (localObject1 == null) {
        p.hyc();
      }
      localObject1 = ((CardHomePageNewUI.a)localObject1).qfp;
      if (localObject1 == null) {
        p.hyc();
      }
      Object localObject2 = ((ud)localObject1).Lds;
      p.g(localObject2, "el!!.card_element_coupon_list");
      localObject2 = ((Iterable)localObject2).iterator();
      int k = 0;
      int i = 0;
      if (((Iterator)localObject2).hasNext())
      {
        final ua localua = (ua)((Iterator)localObject2).next();
        int j = i;
        if (k >= paramInt1)
        {
          if (localua.LcU != 1) {
            break label487;
          }
          localObject3 = this.qfC;
          if (localObject3 == null) {
            p.btv("chpiCouponLayout");
          }
          localObject3 = LayoutInflater.from(((LinearLayout)localObject3).getContext());
          localLinearLayout = this.qfC;
          if (localLinearLayout == null) {
            p.btv("chpiCouponLayout");
          }
          localObject3 = ((LayoutInflater)localObject3).inflate(2131493379, (ViewGroup)localLinearLayout, false);
          if (localObject3 == null)
          {
            localObject1 = new t("null cannot be cast to non-null type android.view.ViewGroup");
            AppMethodBeat.o(112428);
            throw ((Throwable)localObject1);
          }
          localObject3 = (ViewGroup)localObject3;
          localObject4 = (TextView)((ViewGroup)localObject3).findViewById(2131298669);
          localObject5 = (CdnImageView)((ViewGroup)localObject3).findViewById(2131298666);
          localObject6 = (TextView)((ViewGroup)localObject3).findViewById(2131298667);
          localLinearLayout = (LinearLayout)((ViewGroup)localObject3).findViewById(2131298668);
          if (!Util.isNullOrNil(localua.LcX)) {
            ((TextView)localObject4).setTextColor(com.tencent.mm.plugin.card.d.l.cT(localua.LcX, localua.LcY));
          }
          p.g(localObject4, "titleTv");
          ((TextView)localObject4).setText((CharSequence)localua.LcO);
          ((CdnImageView)localObject5).setUrl(localua.LcV);
          if (!Util.isNullOrNil(localua.LcZ)) {
            ((TextView)localObject6).setTextColor(com.tencent.mm.plugin.card.d.l.cT(localua.LcZ, localua.Lda));
          }
          p.g(localObject6, "descTv");
          ((TextView)localObject6).setText((CharSequence)localua.LcP);
          localObject4 = localua.LcT;
          p.g(localObject4, "coupon.coupon_label");
          localObject4 = (List)localObject4;
          p.g(localLinearLayout, "labelLayout");
          a((List)localObject4, localLinearLayout);
          localLinearLayout = this.qfC;
          if (localLinearLayout == null) {
            p.btv("chpiCouponLayout");
          }
          ((ViewGroup)localObject3).setOnClickListener((View.OnClickListener)new a(this, (ud)localObject1, localua, localLinearLayout.getChildCount(), paramInt3));
          dA((View)localObject3);
        }
        label487:
        while (localua.LcU != 2)
        {
          j = i;
          if (paramInt2 > 0)
          {
            j = i + 1;
            if (j >= paramInt2) {
              break label1081;
            }
          }
          k += 1;
          i = j;
          break;
        }
        Object localObject3 = this.qfC;
        if (localObject3 == null) {
          p.btv("chpiCouponLayout");
        }
        localObject3 = LayoutInflater.from(((LinearLayout)localObject3).getContext());
        LinearLayout localLinearLayout = this.qfC;
        if (localLinearLayout == null) {
          p.btv("chpiCouponLayout");
        }
        localObject3 = ((LayoutInflater)localObject3).inflate(2131493378, (ViewGroup)localLinearLayout, false);
        if (localObject3 == null)
        {
          localObject1 = new t("null cannot be cast to non-null type android.view.ViewGroup");
          AppMethodBeat.o(112428);
          throw ((Throwable)localObject1);
        }
        localObject3 = (ViewGroup)localObject3;
        Object localObject5 = (TextView)((ViewGroup)localObject3).findViewById(2131298669);
        Object localObject6 = (TextView)((ViewGroup)localObject3).findViewById(2131298667);
        localLinearLayout = (LinearLayout)((ViewGroup)localObject3).findViewById(2131298668);
        Object localObject7 = (MemberCardTopCropImageView)((ViewGroup)localObject3).findViewById(2131298664);
        Object localObject4 = (ImageView)((ViewGroup)localObject3).findViewById(2131298665);
        if (!Util.isNullOrNil(localua.LcX)) {
          ((TextView)localObject5).setTextColor(com.tencent.mm.plugin.card.d.l.cT(localua.LcX, localua.LcY));
        }
        p.g(localObject5, "titleTv");
        ((TextView)localObject5).setText((CharSequence)localua.LcO);
        p.g(localObject6, "descTv");
        ((TextView)localObject6).setText((CharSequence)localua.LcP);
        p.g(localObject7, "bgIv");
        ((MemberCardTopCropImageView)localObject7).setRadius(com.tencent.mm.cb.a.fromDPToPix(((MemberCardTopCropImageView)localObject7).getContext(), 2));
        if (!Util.isNullOrNil(localua.LcS))
        {
          localObject5 = (ImageView)localObject7;
          localObject6 = localua.LcS;
          p.g(localObject6, "coupon.coupon_back_url");
          p.h(localObject5, "imageView");
          p.h(localObject6, "url");
          localObject7 = new c.a();
          ((c.a)localObject7).OT(com.tencent.mm.loader.j.b.aKJ());
          ((c.a)localObject7).a(q.bcW());
          ((c.a)localObject7).OS(com.tencent.mm.plugin.card.model.m.ajp((String)localObject6));
          ((c.a)localObject7).bdp();
          ((c.a)localObject7).bdu();
          ((c.a)localObject7).bdo();
          ((c.a)localObject7).ty(2131231525);
          ((c.a)localObject7).tx(com.tencent.mm.cb.a.fromDPToPix(((ImageView)localObject5).getContext(), 84));
          ((c.a)localObject7).tw(com.tencent.mm.cb.a.jn(((ImageView)localObject5).getContext()));
          localObject7 = ((c.a)localObject7).bdv();
          q.bcV().a((String)localObject6, (ImageView)localObject5, (com.tencent.mm.av.a.a.c)localObject7);
          ((ImageView)localObject5).setImageMatrix(new Matrix());
          p.g(localObject4, "shadowBgIv");
          ((ImageView)localObject4).setVisibility(0);
        }
        for (;;)
        {
          localObject4 = localua.LcT;
          p.g(localObject4, "coupon.coupon_label");
          localObject4 = (List)localObject4;
          p.g(localLinearLayout, "labelLayout");
          a((List)localObject4, localLinearLayout);
          localLinearLayout = this.qfC;
          if (localLinearLayout == null) {
            p.btv("chpiCouponLayout");
          }
          ((ViewGroup)localObject3).setOnClickListener((View.OnClickListener)new b(this, (ud)localObject1, localua, localLinearLayout.getChildCount(), paramInt3));
          dA((View)localObject3);
          break;
          if (!Util.isNullOrNil(localua.LcR))
          {
            ((MemberCardTopCropImageView)localObject7).setImageDrawable((Drawable)new ColorDrawable(Color.parseColor(localua.LcR)));
            p.g(localObject4, "shadowBgIv");
            ((ImageView)localObject4).setVisibility(0);
          }
        }
      }
      label1081:
      AppMethodBeat.o(112428);
    }
    
    private void a(List<? extends tz> paramList, LinearLayout paramLinearLayout)
    {
      AppMethodBeat.i(112432);
      p.h(paramList, "couponLabelList");
      p.h(paramLinearLayout, "labelLayout");
      paramList = paramList.iterator();
      if (paramList.hasNext())
      {
        tz localtz = (tz)paramList.next();
        Object localObject1 = this.qfC;
        if (localObject1 == null) {
          p.btv("chpiCouponLayout");
        }
        localObject1 = new CardTagTextView(((LinearLayout)localObject1).getContext());
        Object localObject2 = this.qfC;
        if (localObject2 == null) {
          p.btv("chpiCouponLayout");
        }
        localObject2 = ((LinearLayout)localObject2).getContext();
        ((CardTagTextView)localObject1).setMinHeight(com.tencent.mm.cb.a.fromDPToPix((Context)localObject2, 18));
        ((CardTagTextView)localObject1).setMinWidth(com.tencent.mm.cb.a.fromDPToPix((Context)localObject2, 56));
        int i = com.tencent.mm.cb.a.fromDPToPix((Context)localObject2, 8);
        int j = com.tencent.mm.cb.a.fromDPToPix((Context)localObject2, 4);
        ((CardTagTextView)localObject1).setPadding(i, j, i, j);
        ((CardTagTextView)localObject1).setText((CharSequence)localtz.LcI);
        ((CardTagTextView)localObject1).setTextSize(1, 10.0F);
        if (!Util.isNullOrNil(localtz.LcJ))
        {
          ((CardTagTextView)localObject1).setTextColor(Color.parseColor(localtz.LcJ));
          label199:
          if (Util.isNullOrNil(localtz.LcK)) {
            break label249;
          }
          ((CardTagTextView)localObject1).setFillColor(com.tencent.mm.plugin.card.d.l.cT(localtz.LcK, localtz.LcN));
        }
        for (;;)
        {
          paramLinearLayout.addView((View)localObject1);
          break;
          ((CardTagTextView)localObject1).setTextColor(-1);
          break label199;
          label249:
          ((CardTagTextView)localObject1).setFillColor(com.tencent.mm.plugin.card.d.l.fj(-16777216, 26));
        }
      }
      AppMethodBeat.o(112432);
    }
    
    private static void b(ImageView paramImageView, String paramString)
    {
      AppMethodBeat.i(112433);
      p.h(paramImageView, "imageView");
      p.h(paramString, "url");
      Object localObject = new c.a();
      ((c.a)localObject).OT(com.tencent.mm.loader.j.b.aKJ());
      ((c.a)localObject).a(q.bcW());
      ((c.a)localObject).OS(com.tencent.mm.plugin.card.model.m.ajp(paramString));
      ((c.a)localObject).bdp();
      ((c.a)localObject).bdt();
      ((c.a)localObject).bdu();
      ((c.a)localObject).bdo();
      ((c.a)localObject).ty(2131689880);
      localObject = ((c.a)localObject).bdv();
      q.bcV().a(paramString, paramImageView, (com.tencent.mm.av.a.a.c)localObject);
      AppMethodBeat.o(112433);
    }
    
    private void cV(List<? extends ub> paramList)
    {
      AppMethodBeat.i(112431);
      p.h(paramList, "labelList");
      Object localObject1 = this.qfB;
      if (localObject1 == null) {
        p.btv("chpiLabelLayout");
      }
      ((LinearLayout)localObject1).removeAllViews();
      if (paramList.isEmpty())
      {
        paramList = this.qfB;
        if (paramList == null) {
          p.btv("chpiLabelLayout");
        }
        paramList.setVisibility(8);
        AppMethodBeat.o(112431);
        return;
      }
      paramList = ((Iterable)paramList).iterator();
      int i = 0;
      if (paramList.hasNext())
      {
        Object localObject2 = (ub)paramList.next();
        localObject1 = this.qfB;
        if (localObject1 == null) {
          p.btv("chpiLabelLayout");
        }
        localObject1 = ((LinearLayout)localObject1).getContext();
        p.g(localObject1, "chpiLabelLayout.context");
        localObject1 = new CardLabelTextView((Context)localObject1);
        Object localObject3 = this.qfB;
        if (localObject3 == null) {
          p.btv("chpiLabelLayout");
        }
        localObject3 = ((LinearLayout)localObject3).getContext();
        ((CardLabelTextView)localObject1).setTextSize(1, 12.0F);
        ((CardLabelTextView)localObject1).setText((CharSequence)((ub)localObject2).Ldh);
        int j = com.tencent.mm.cb.a.fromDPToPix((Context)localObject3, 4);
        ((CardLabelTextView)localObject1).setPadding(j, 0, j, 0);
        ((CardLabelTextView)localObject1).setGravity(16);
        if (!Util.isNullOrNil(((ub)localObject2).Ldi))
        {
          ((CardLabelTextView)localObject1).setTextColor(Color.parseColor(((ub)localObject2).Ldi));
          label240:
          if (Util.isNullOrNil(((ub)localObject2).Ldj)) {
            break label359;
          }
          ((CardLabelTextView)localObject1).setFillColor(com.tencent.mm.plugin.card.d.l.cT(((ub)localObject2).Ldj, ((ub)localObject2).Ldm));
          label269:
          if (i <= 0) {
            break label368;
          }
          localObject2 = new ViewGroup.MarginLayoutParams(-2, -2);
          ((ViewGroup.MarginLayoutParams)localObject2).leftMargin = com.tencent.mm.cb.a.fromDPToPix((Context)localObject3, 4);
          localObject2 = (ViewGroup.MarginLayoutParams)new LinearLayout.LayoutParams((ViewGroup.MarginLayoutParams)localObject2);
          localObject3 = this.qfB;
          if (localObject3 == null) {
            p.btv("chpiLabelLayout");
          }
          ((LinearLayout)localObject3).addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
        }
        for (;;)
        {
          i += 1;
          break;
          ((CardLabelTextView)localObject1).setTextColor(-1);
          break label240;
          label359:
          ((CardLabelTextView)localObject1).setFillColor(0);
          break label269;
          label368:
          localObject2 = this.qfB;
          if (localObject2 == null) {
            p.btv("chpiLabelLayout");
          }
          ((LinearLayout)localObject2).addView((View)localObject1);
        }
      }
      paramList = this.qfB;
      if (paramList == null) {
        p.btv("chpiLabelLayout");
      }
      paramList.setVisibility(0);
      AppMethodBeat.o(112431);
    }
    
    private void dA(View paramView)
    {
      AppMethodBeat.i(112430);
      p.h(paramView, "view");
      Object localObject = this.qfC;
      if (localObject == null) {
        p.btv("chpiCouponLayout");
      }
      if (((LinearLayout)localObject).getChildCount() == 0)
      {
        localObject = this.qfC;
        if (localObject == null) {
          p.btv("chpiCouponLayout");
        }
        ((LinearLayout)localObject).addView(paramView);
        AppMethodBeat.o(112430);
        return;
      }
      localObject = this.qfC;
      if (localObject == null) {
        p.btv("chpiCouponLayout");
      }
      localObject = new ViewGroup.MarginLayoutParams(-1, com.tencent.mm.cb.a.fromDPToPix(((LinearLayout)localObject).getContext(), 84));
      LinearLayout localLinearLayout = this.qfC;
      if (localLinearLayout == null) {
        p.btv("chpiCouponLayout");
      }
      ((ViewGroup.MarginLayoutParams)localObject).topMargin = com.tencent.mm.cb.a.fromDPToPix(localLinearLayout.getContext(), 8);
      localObject = (ViewGroup.MarginLayoutParams)new LinearLayout.LayoutParams((ViewGroup.MarginLayoutParams)localObject);
      localLinearLayout = this.qfC;
      if (localLinearLayout == null) {
        p.btv("chpiCouponLayout");
      }
      localLinearLayout.addView(paramView, (ViewGroup.LayoutParams)localObject);
      AppMethodBeat.o(112430);
    }
    
    public final void a(final CardHomePageNewUI.a parama, final int paramInt)
    {
      AppMethodBeat.i(112426);
      p.h(parama, "model");
      this.qfO = parama;
      Object localObject1 = parama.qfp;
      switch (parama.type)
      {
      }
      for (;;)
      {
        parama.qfr = true;
        AppMethodBeat.o(112426);
        return;
        if (localObject1 == null) {
          p.hyc();
        }
        Object localObject2 = this.qfx;
        if (localObject2 == null) {
          p.btv("chpiLogoIv");
        }
        ((CdnImageView)localObject2).setRoundCorner(true);
        Object localObject3;
        label172:
        int i;
        label512:
        label614:
        boolean bool;
        if (!Util.isNullOrNil(((ud)localObject1).Ldo))
        {
          localObject2 = this.qfx;
          if (localObject2 == null) {
            p.btv("chpiLogoIv");
          }
          localObject2 = (ImageView)localObject2;
          localObject3 = ((ud)localObject1).Ldo;
          p.g(localObject3, "card_element_mch_icon");
          b((ImageView)localObject2, (String)localObject3);
          localObject2 = (View.OnClickListener)new c((ud)localObject1, this, (ud)localObject1, paramInt, false, parama);
          localObject3 = this.qfx;
          if (localObject3 == null) {
            p.btv("chpiLogoIv");
          }
          ((CdnImageView)localObject3).setOnClickListener((View.OnClickListener)localObject2);
          localObject3 = CardHomePageNewUI.this;
          Object localObject4 = CardHomePageNewUI.this.getContext();
          p.g(localObject4, "context");
          i = ((AppCompatActivity)localObject4).getResources().getColor(2131100904);
          localObject4 = CardHomePageNewUI.this.getContext();
          p.g(localObject4, "context");
          localObject4 = new CardHomePageNewUI.b((CardHomePageNewUI)localObject3, i, ((AppCompatActivity)localObject4).getResources().getColor(2131101130), (j)new CardHomePageNewUI.e.d((View.OnClickListener)localObject2));
          localObject3 = new SpannableString((CharSequence)((ud)localObject1).Ldp);
          ((SpannableString)localObject3).setSpan(localObject4, 0, ((SpannableString)localObject3).length(), 18);
          localObject4 = this.qfy;
          if (localObject4 == null) {
            p.btv("chpiNameTv");
          }
          ((TextView)localObject4).setClickable(true);
          localObject4 = this.qfy;
          if (localObject4 == null) {
            p.btv("chpiNameTv");
          }
          ((TextView)localObject4).setOnTouchListener((View.OnTouchListener)new o((Context)CardHomePageNewUI.this));
          localObject4 = this.qfy;
          if (localObject4 == null) {
            p.btv("chpiNameTv");
          }
          ((TextView)localObject4).setText((CharSequence)localObject3);
          if (Util.isNullOrNil(((ud)localObject1).Ldq)) {
            break label913;
          }
          localObject3 = this.qfz;
          if (localObject3 == null) {
            p.btv("chpiDescTv");
          }
          ((TextView)localObject3).setText((CharSequence)((ud)localObject1).Ldq);
          localObject3 = this.qfz;
          if (localObject3 == null) {
            p.btv("chpiDescTv");
          }
          ((TextView)localObject3).setVisibility(0);
          localObject3 = this.qfz;
          if (localObject3 == null) {
            p.btv("chpiDescTv");
          }
          ((TextView)localObject3).setOnClickListener((View.OnClickListener)localObject2);
          if (((ud)localObject1).Ldw == null) {
            break label1031;
          }
          if (Util.isNullOrNil(((ud)localObject1).Ldw.Ldh)) {
            break label1004;
          }
          localObject2 = this.qfG;
          if (localObject2 == null) {
            p.btv("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject2).setText((CharSequence)((ud)localObject1).Ldw.Ldh);
          if (Util.isNullOrNil(((ud)localObject1).Ldw.Ldi)) {
            break label940;
          }
          localObject2 = this.qfG;
          if (localObject2 == null) {
            p.btv("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject2).setTextColor(Color.parseColor(((ud)localObject1).Ldw.Ldi));
          if (Util.isNullOrNil(((ud)localObject1).Ldw.Ldj)) {
            break label978;
          }
          localObject2 = this.qfG;
          if (localObject2 == null) {
            p.btv("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject2).setFillColor(com.tencent.mm.plugin.card.d.l.cT(((ud)localObject1).Ldw.Ldj, ((ud)localObject1).Ldw.Ldm));
          label669:
          localObject2 = this.qfG;
          if (localObject2 == null) {
            p.btv("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject2).setVisibility(0);
          label692:
          localObject2 = this.qfC;
          if (localObject2 == null) {
            p.btv("chpiCouponLayout");
          }
          ((LinearLayout)localObject2).removeAllViews();
          if (parama.qfr) {
            break label1092;
          }
          if (((ud)localObject1).Ldx != 1) {
            break label1086;
          }
          bool = true;
          label733:
          if (!bool) {
            break label1184;
          }
          localObject2 = ((ud)localObject1).Lds;
          p.g(localObject2, "card_element_coupon_list");
          if (((Collection)localObject2).isEmpty()) {
            break label1101;
          }
          i = 1;
          label768:
          if (i == 0) {
            break label1106;
          }
          V(-1, ((ud)localObject1).Lds.size(), paramInt);
          localObject2 = this.qfC;
          if (localObject2 == null) {
            p.btv("chpiCouponLayout");
          }
          ((LinearLayout)localObject2).setVisibility(0);
          parama.qfs = true;
          label814:
          if (Util.isNullOrNil(((ud)localObject1).Ldt)) {
            break label1133;
          }
          Ey(paramInt);
          localObject2 = this.qfD;
          if (localObject2 == null) {
            p.btv("chpiExpandLayout");
          }
          ((LinearLayout)localObject2).setVisibility(0);
        }
        label913:
        label940:
        label1086:
        label1214:
        for (;;)
        {
          localObject1 = ((ud)localObject1).Ldr;
          p.g(localObject1, "card_element_mch_label");
          cV((List)localObject1);
          localObject1 = x.SXb;
          break;
          localObject2 = this.qfx;
          if (localObject2 == null) {
            p.btv("chpiLogoIv");
          }
          ((CdnImageView)localObject2).setImageResource(2131689880);
          break label172;
          localObject2 = this.qfz;
          if (localObject2 == null) {
            p.btv("chpiDescTv");
          }
          ((TextView)localObject2).setVisibility(8);
          break label512;
          localObject2 = this.qfG;
          if (localObject2 == null) {
            p.btv("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject2).setTextColor(CardHomePageNewUI.this.getResources().getColor(2131101424));
          break label614;
          label978:
          localObject2 = this.qfG;
          if (localObject2 == null) {
            p.btv("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject2).setFillColor(0);
          break label669;
          label1004:
          localObject2 = this.qfG;
          if (localObject2 == null) {
            p.btv("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject2).setVisibility(8);
          break label692;
          localObject2 = this.qfG;
          if (localObject2 == null) {
            p.btv("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject2).setText((CharSequence)"");
          localObject2 = this.qfG;
          if (localObject2 == null) {
            p.btv("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject2).setVisibility(8);
          break label692;
          bool = false;
          break label733;
          label1092:
          bool = parama.qfs;
          break label733;
          label1101:
          i = 0;
          break label768;
          label1106:
          localObject2 = this.qfC;
          if (localObject2 == null) {
            p.btv("chpiCouponLayout");
          }
          ((LinearLayout)localObject2).setVisibility(8);
          break label814;
          label1133:
          if (((ud)localObject1).Ldz < ((ud)localObject1).Lds.size())
          {
            EA(paramInt);
          }
          else
          {
            localObject2 = this.qfD;
            if (localObject2 == null) {
              p.btv("chpiExpandLayout");
            }
            ((LinearLayout)localObject2).setVisibility(8);
            continue;
            localObject2 = ((ud)localObject1).Lds;
            p.g(localObject2, "card_element_coupon_list");
            if (!((Collection)localObject2).isEmpty())
            {
              i = 1;
              if (i == 0) {
                break label1320;
              }
              V(-1, ((ud)localObject1).Ldz, paramInt);
              localObject2 = this.qfC;
              if (localObject2 == null) {
                p.btv("chpiCouponLayout");
              }
              ((LinearLayout)localObject2).setVisibility(0);
              parama.qfs = false;
            }
            for (;;)
            {
              if (((ud)localObject1).Ldz >= ((ud)localObject1).Lds.size())
              {
                if (!Util.isNullOrNil(((ud)localObject1).Ldt))
                {
                  Ey(paramInt);
                  localObject2 = this.qfD;
                  if (localObject2 == null) {
                    p.btv("chpiExpandLayout");
                  }
                  ((LinearLayout)localObject2).setVisibility(0);
                  break;
                  i = 0;
                  break label1214;
                  localObject2 = this.qfC;
                  if (localObject2 == null) {
                    p.btv("chpiCouponLayout");
                  }
                  ((LinearLayout)localObject2).setVisibility(8);
                  continue;
                }
                localObject2 = this.qfD;
                if (localObject2 == null) {
                  p.btv("chpiExpandLayout");
                }
                ((LinearLayout)localObject2).setVisibility(8);
                break;
              }
            }
            Ez(paramInt);
            localObject2 = this.qfD;
            if (localObject2 == null) {
              p.btv("chpiExpandLayout");
            }
            ((LinearLayout)localObject2).setVisibility(0);
          }
        }
        label1031:
        label1184:
        label1320:
        localObject1 = this.qfw;
        if (localObject1 == null) {
          p.btv("sectionTitleTv");
        }
        ((TextView)localObject1).setText((CharSequence)parama.cxc());
        continue;
        if (localObject1 == null) {
          p.hyc();
        }
        localObject2 = this.qfx;
        if (localObject2 == null) {
          p.btv("chpiLogoIv");
        }
        ((CdnImageView)localObject2).setRoundCorner(true);
        localObject2 = this.qfx;
        if (localObject2 == null) {
          p.btv("chpiLogoIv");
        }
        ((CdnImageView)localObject2).setUrl(((ud)localObject1).Ldo);
        localObject2 = this.qfy;
        if (localObject2 == null) {
          p.btv("chpiNameTv");
        }
        ((TextView)localObject2).setText((CharSequence)((ud)localObject1).Ldp);
        if (!Util.isNullOrNil(((ud)localObject1).Ldq))
        {
          localObject2 = this.qfz;
          if (localObject2 == null) {
            p.btv("chpiDescTv");
          }
          ((TextView)localObject2).setText((CharSequence)((ud)localObject1).Ldq);
          localObject2 = this.qfz;
          if (localObject2 == null) {
            p.btv("chpiDescTv");
          }
          ((TextView)localObject2).setVisibility(0);
          label1589:
          if (((ud)localObject1).Ldw == null) {
            break label1895;
          }
          if (Util.isNullOrNil(((ud)localObject1).Ldw.Ldh)) {
            break label1868;
          }
          localObject2 = this.qfG;
          if (localObject2 == null) {
            p.btv("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject2).setText((CharSequence)((ud)localObject1).Ldw.Ldh);
          if (Util.isNullOrNil(((ud)localObject1).Ldw.Ldi)) {
            break label1804;
          }
          localObject2 = this.qfG;
          if (localObject2 == null) {
            p.btv("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject2).setTextColor(Color.parseColor(((ud)localObject1).Ldw.Ldi));
          label1691:
          if (Util.isNullOrNil(((ud)localObject1).Ldw.Ldj)) {
            break label1842;
          }
          localObject2 = this.qfG;
          if (localObject2 == null) {
            p.btv("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject2).setFillColor(com.tencent.mm.plugin.card.d.l.cT(((ud)localObject1).Ldw.Ldj, ((ud)localObject1).Ldw.Ldm));
          label1746:
          localObject1 = this.qfG;
          if (localObject1 == null) {
            p.btv("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject1).setVisibility(0);
        }
        for (;;)
        {
          localObject1 = x.SXb;
          break;
          localObject2 = this.qfz;
          if (localObject2 == null) {
            p.btv("chpiDescTv");
          }
          ((TextView)localObject2).setVisibility(8);
          break label1589;
          label1804:
          localObject2 = this.qfG;
          if (localObject2 == null) {
            p.btv("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject2).setTextColor(CardHomePageNewUI.this.getResources().getColor(2131101424));
          break label1691;
          label1842:
          localObject1 = this.qfG;
          if (localObject1 == null) {
            p.btv("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject1).setFillColor(0);
          break label1746;
          label1868:
          localObject1 = this.qfG;
          if (localObject1 == null) {
            p.btv("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject1).setVisibility(8);
          continue;
          label1895:
          localObject1 = this.qfG;
          if (localObject1 == null) {
            p.btv("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject1).setText((CharSequence)"");
          localObject1 = this.qfG;
          if (localObject1 == null) {
            p.btv("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject1).setVisibility(8);
        }
        localObject1 = this.qfx;
        if (localObject1 == null) {
          p.btv("chpiLogoIv");
        }
        ((CdnImageView)localObject1).setRoundCorner(true);
        localObject1 = this.qfx;
        if (localObject1 == null) {
          p.btv("chpiLogoIv");
        }
        ((CdnImageView)localObject1).setImageResource(2131689880);
        localObject1 = this.qfy;
        if (localObject1 == null) {
          p.btv("chpiNameTv");
        }
        ((TextView)localObject1).setText((CharSequence)MMApplicationContext.getResources().getString(2131757042));
        localObject1 = this.qfz;
        if (localObject1 == null) {
          p.btv("chpiDescTv");
        }
        ((TextView)localObject1).setVisibility(8);
        continue;
        localObject1 = this.qfI;
        if (localObject1 == null) {
          p.btv("chtiTitleTv");
        }
        ((TextView)localObject1).setText(2131766758);
        if (CardHomePageNewUI.n(CardHomePageNewUI.this) != null)
        {
          localObject1 = this.qfJ;
          if (localObject1 == null) {
            p.btv("chtiDescTv");
          }
          ((TextView)localObject1).setText((CharSequence)CardHomePageNewUI.n(CardHomePageNewUI.this));
          localObject1 = x.SXb;
          continue;
          localObject1 = this.qfI;
          if (localObject1 == null) {
            p.btv("chtiTitleTv");
          }
          ((TextView)localObject1).setText(2131757118);
          if (CardHomePageNewUI.o(CardHomePageNewUI.this) == 1)
          {
            localObject1 = this.qfJ;
            if (localObject1 == null) {
              p.btv("chtiDescTv");
            }
            ((TextView)localObject1).setVisibility(0);
            localObject1 = this.qfK;
            if (localObject1 == null) {
              p.btv("chtiRightIv");
            }
            ((ImageView)localObject1).setVisibility(0);
            localObject1 = CardHomePageNewUI.this.cwY();
            if (localObject1 == null)
            {
              localObject1 = this.qfJ;
              if (localObject1 == null) {
                p.btv("chtiDescTv");
              }
              ((TextView)localObject1).setText((CharSequence)"");
            }
            for (;;)
            {
              localObject1 = this.qfJ;
              if (localObject1 == null) {
                p.btv("chtiDescTv");
              }
              ((TextView)localObject1).setOnClickListener((View.OnClickListener)new e(this));
              localObject1 = this.qfK;
              if (localObject1 == null) {
                p.btv("chtiRightIv");
              }
              ((ImageView)localObject1).setOnClickListener((View.OnClickListener)new f(this));
              localObject1 = this.qfK;
              if (localObject1 == null) {
                p.btv("chtiRightIv");
              }
              Util.expandViewTouchArea((View)localObject1, 50, 50, 50, 50);
              break;
              localObject2 = this.qfJ;
              if (localObject2 == null) {
                p.btv("chtiDescTv");
              }
              ((TextView)localObject2).setText((CharSequence)((uv)localObject1).Les);
            }
          }
          localObject1 = this.qfJ;
          if (localObject1 == null) {
            p.btv("chtiDescTv");
          }
          ((TextView)localObject1).setVisibility(8);
          localObject1 = this.qfK;
          if (localObject1 == null) {
            p.btv("chtiRightIv");
          }
          ((ImageView)localObject1).setVisibility(8);
          continue;
          localObject1 = parama.qft;
          if (localObject1 != null)
          {
            localObject2 = this.qfI;
            if (localObject2 == null) {
              p.btv("chtiTitleTv");
            }
            ((TextView)localObject2).setText((CharSequence)((ui)localObject1).LdK);
            localObject2 = this.qfJ;
            if (localObject2 == null) {
              p.btv("chtiDescTv");
            }
            ((TextView)localObject2).setText((CharSequence)((ui)localObject1).LdL);
            localObject2 = this.qfH;
            if (localObject2 == null) {
              p.btv("chtiIconIv");
            }
            localObject3 = ((ui)localObject1).LdJ;
            p.g(localObject3, "card_top_cell_icon");
            b((ImageView)localObject2, (String)localObject3);
            localObject2 = this.qfM;
            if (localObject2 == null) {
              p.btv("chtiNewTv");
            }
            if (((ui)localObject1).LdR != 1) {
              break label2660;
            }
            paramInt = 0;
            label2582:
            ((TextView)localObject2).setVisibility(paramInt);
            localObject2 = this.qfL;
            if (localObject2 == null) {
              p.btv("chtiRedDotIv");
            }
            if (((ui)localObject1).LdQ != 1) {
              break label2666;
            }
          }
          label2660:
          label2666:
          for (paramInt = 0;; paramInt = 8)
          {
            ((ImageView)localObject2).setVisibility(paramInt);
            localObject1 = x.SXb;
            if (!parama.qfu) {
              break label2672;
            }
            localObject1 = this.qfN;
            if (localObject1 == null) {
              p.btv("chtiDivider");
            }
            ((View)localObject1).setVisibility(0);
            break;
            paramInt = 8;
            break label2582;
          }
          label2672:
          localObject1 = this.qfN;
          if (localObject1 == null) {
            p.btv("chtiDivider");
          }
          ((View)localObject1).setVisibility(8);
        }
      }
    }
    
    public final void ajN(String paramString)
    {
      AppMethodBeat.i(112429);
      p.h(paramString, "cardId");
      Log.i("MicroMsg.CardHomePageNewUI", "go to card detail: %s", new Object[] { paramString });
      Object localObject = this.aus;
      p.g(localObject, "itemView");
      localObject = new Intent(((View)localObject).getContext(), CardDetailUI.class);
      ((Intent)localObject).putExtra("key_card_id", paramString);
      ((Intent)localObject).addFlags(131072);
      ((Intent)localObject).putExtra("key_from_scene", 3);
      paramString = this.aus;
      p.g(paramString, "itemView");
      paramString = paramString.getContext();
      localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH", "gotoCardDetailUI", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH", "gotoCardDetailUI", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(112429);
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(CardHomePageNewUI.e parame, ud paramud, ua paramua, int paramInt1, int paramInt2) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(112417);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$appendCouponView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        CardHomePageNewUI.k(this.qfP.qfv);
        CardHomePageNewUI.a(this.qfP.qfv, 0);
        CardHomePageNewUI.a(this.qfP.qfv, this.qfQ);
        paramView = this.qfP;
        localObject = localua.KDM;
        p.g(localObject, "coupon.user_card_id");
        paramView.ajN((String)localObject);
        com.tencent.mm.plugin.report.service.h.CyF.a(16324, new Object[] { Integer.valueOf(1), this.qfQ.Ldn, Integer.valueOf(this.puW), localua.KDM, Integer.valueOf(2), Integer.valueOf(paramInt3), Integer.valueOf(CardHomePageNewUI.m(this.qfP.qfv)) });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$appendCouponView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(112417);
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b
      implements View.OnClickListener
    {
      b(CardHomePageNewUI.e parame, ud paramud, ua paramua, int paramInt1, int paramInt2) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(112418);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$appendCouponView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        CardHomePageNewUI.k(this.qfP.qfv);
        CardHomePageNewUI.a(this.qfP.qfv, 0);
        CardHomePageNewUI.a(this.qfP.qfv, this.qfQ);
        paramView = this.qfP;
        localObject = localua.KDM;
        p.g(localObject, "coupon.user_card_id");
        paramView.ajN((String)localObject);
        com.tencent.mm.plugin.report.service.h.CyF.a(16324, new Object[] { Integer.valueOf(1), this.qfQ.Ldn, Integer.valueOf(this.puW), localua.KDM, Integer.valueOf(2), Integer.valueOf(paramInt3), Integer.valueOf(CardHomePageNewUI.m(this.qfP.qfv)) });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$appendCouponView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(112418);
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$setModel$1$headerClickListener$1"})
    static final class c
      implements View.OnClickListener
    {
      c(ud paramud1, CardHomePageNewUI.e parame, ud paramud2, int paramInt, boolean paramBoolean, CardHomePageNewUI.a parama) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(112419);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$setModel$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        Log.i("MicroMsg.CardHomePageNewUI", "click header");
        CardHomePageNewUI.k(jdField_this.qfv);
        CardHomePageNewUI.a(jdField_this.qfv, 0);
        CardHomePageNewUI.a(jdField_this.qfv, this.qfT);
        switch (this.qfS.Ldc)
        {
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.h.CyF.a(16324, new Object[] { Integer.valueOf(1), this.qfS.Ldn, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(paramInt), Integer.valueOf(CardHomePageNewUI.m(jdField_this.qfv)) });
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$setModel$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(112419);
          return;
          paramView = jdField_this.aus;
          p.g(paramView, "itemView");
          paramView = paramView.getContext();
          if (paramView == null)
          {
            paramView = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(112419);
            throw paramView;
          }
          com.tencent.mm.plugin.card.d.b.a((MMActivity)paramView, this.qfS.Ldd);
          continue;
          paramView = this.qfS.Lde;
          com.tencent.mm.plugin.card.d.b.H(paramView.Hwr, paramView.Hws, paramView.IhZ);
        }
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class e
      implements View.OnClickListener
    {
      e(CardHomePageNewUI.e parame) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(112421);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$setModel$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        CardHomePageNewUI.p(this.qfP.qfv);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$setModel$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(112421);
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class f
      implements View.OnClickListener
    {
      f(CardHomePageNewUI.e parame) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(112422);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$setModel$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        CardHomePageNewUI.p(this.qfP.qfv);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$setModel$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(112422);
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class g
      implements View.OnClickListener
    {
      g(CardHomePageNewUI.e parame, int paramInt, ud paramud) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(112423);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$showCollapseLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        Log.d("MicroMsg.CardHomePageNewUI", "do collapse coupon layout");
        CardHomePageNewUI.e.b(this.qfP, paramInt);
        paramView = this.qfP.qfO;
        if (paramView != null) {
          paramView.qfs = false;
        }
        paramView = com.tencent.mm.plugin.report.service.h.CyF;
        localObject = this.qfQ;
        if (localObject == null) {
          p.hyc();
        }
        paramView.a(16324, new Object[] { Integer.valueOf(1), ((ud)localObject).Ldn, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(5), Integer.valueOf(paramInt), Integer.valueOf(CardHomePageNewUI.m(this.qfP.qfv)) });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$showCollapseLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(112423);
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class h
      implements View.OnClickListener
    {
      h(CardHomePageNewUI.e parame, int paramInt, ud paramud) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(112424);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$showExpandLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        Log.d("MicroMsg.CardHomePageNewUI", "do expand coupon layout");
        CardHomePageNewUI.e.a(this.qfP, paramInt);
        paramView = this.qfP.qfO;
        if (paramView != null) {
          paramView.qfs = true;
        }
        paramView = com.tencent.mm.plugin.report.service.h.CyF;
        localObject = this.qfQ;
        if (localObject == null) {
          p.hyc();
        }
        paramView.a(16324, new Object[] { Integer.valueOf(1), ((ud)localObject).Ldn, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(4), Integer.valueOf(paramInt), Integer.valueOf(CardHomePageNewUI.m(this.qfP.qfv)) });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$showExpandLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(112424);
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$showMiniAppLayout$1$1"})
    static final class i
      implements View.OnClickListener
    {
      i(ud paramud, CardHomePageNewUI.e parame, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(112425);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$showMiniAppLayout$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        if (this.qfS.Ldv != null) {
          if (this.qfS.Ldv == null) {
            break label266;
          }
        }
        label266:
        for (boolean bool = true;; bool = false)
        {
          Log.i("MicroMsg.CardHomePageNewUI", "detail goto mini app %s", new Object[] { Boolean.valueOf(bool) });
          CardHomePageNewUI.k(jdField_this.qfv);
          CardHomePageNewUI.a(jdField_this.qfv, 0);
          CardHomePageNewUI.a(jdField_this.qfv, this.qfS);
          com.tencent.mm.plugin.card.d.b.H(this.qfS.Ldv.Hwr, this.qfS.Ldv.Hws, this.qfS.Ldv.IhZ);
          paramView = com.tencent.mm.plugin.report.service.h.CyF;
          localObject = jdField_this.qfO;
          if (localObject == null) {
            p.hyc();
          }
          localObject = ((CardHomePageNewUI.a)localObject).qfp;
          if (localObject == null) {
            p.hyc();
          }
          paramView.a(16324, new Object[] { Integer.valueOf(1), ((ud)localObject).Ldn, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(6), Integer.valueOf(paramInt), Integer.valueOf(CardHomePageNewUI.m(jdField_this.qfv)) });
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$showMiniAppLayout$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(112425);
          return;
        }
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "kotlin.jvm.PlatformType", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/DeleteMchInListResponse;", "call"})
  static final class f<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    f(CardHomePageNewUI paramCardHomePageNewUI, String paramString) {}
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "kotlin.jvm.PlatformType", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetMktCardHomePageResponse;", "call"})
  static final class g<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    g(CardHomePageNewUI paramCardHomePageNewUI) {}
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetCardPkgMchInfoResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class h<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    h(CardHomePageNewUI paramCardHomePageNewUI, String paramString) {}
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$initView$1", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "paint", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "paint2", "getPaint2", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "onDraw", "c", "Landroid/graphics/Canvas;", "plugin-card_release"})
  public static final class i
    extends RecyclerView.h
  {
    private final Paint paint;
    private final Paint qfY;
    
    i()
    {
      AppMethodBeat.i(112446);
      this.paint = new Paint();
      this.qfY = new Paint();
      this.paint.setColor(localObject.getResources().getColor(2131101085));
      this.paint.setStyle(Paint.Style.FILL);
      this.paint.setFlags(1);
      this.qfY.setColor(localObject.getResources().getColor(2131101424));
      this.qfY.setStyle(Paint.Style.FILL);
      this.qfY.setFlags(1);
      AppMethodBeat.o(112446);
    }
    
    public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(112445);
      p.h(paramCanvas, "c");
      p.h(paramRecyclerView, "parent");
      p.h(params, "state");
      super.a(paramCanvas, paramRecyclerView, params);
      paramRecyclerView = CardHomePageNewUI.j(this.qfv);
      if (paramRecyclerView != null)
      {
        int i = paramRecyclerView.getPaddingLeft();
        params = CardHomePageNewUI.qfo;
        int k = i + CardHomePageNewUI.cxb();
        int m = paramRecyclerView.getWidth();
        int n = paramRecyclerView.getPaddingRight();
        int i1 = paramRecyclerView.getChildCount();
        i = 0;
        if (i < i1 - 1)
        {
          params = paramRecyclerView.getChildAt(i);
          p.g(params, "child");
          Object localObject = params.getLayoutParams();
          if (localObject == null)
          {
            paramCanvas = new t("null cannot be cast to non-null type android.support.v7.widget.RecyclerView.LayoutParams");
            AppMethodBeat.o(112445);
            throw paramCanvas;
          }
          localObject = (RecyclerView.LayoutParams)localObject;
          int i2 = params.getBottom() + ((RecyclerView.LayoutParams)localObject).bottomMargin;
          if (i == i1 - 1) {
            params = CardHomePageNewUI.qfo;
          }
          for (int j = CardHomePageNewUI.cxa();; j = 1)
          {
            j = i2 + j;
            if (paramCanvas != null) {
              paramCanvas.drawRect(k, i2, m - n, j, this.paint);
            }
            if (paramCanvas != null) {
              paramCanvas.drawRect(0.0F, i2, k, j, this.qfY);
            }
            i += 1;
            break;
          }
        }
        AppMethodBeat.o(112445);
        return;
      }
      AppMethodBeat.o(112445);
    }
    
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(112444);
      p.h(paramRect, "outRect");
      p.h(paramView, "view");
      p.h(paramRecyclerView, "parent");
      p.h(params, "state");
      super.a(paramRect, paramView, paramRecyclerView, params);
      if (RecyclerView.bw(paramView) == CardHomePageNewUI.q(this.qfv).getItemCount() - 1)
      {
        Log.d("MicroMsg.CardHomePageNewUI", "is last");
        paramView = CardHomePageNewUI.qfo;
        paramRect.bottom = CardHomePageNewUI.cxa();
        AppMethodBeat.o(112444);
        return;
      }
      paramRect.bottom = 1;
      AppMethodBeat.o(112444);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "parent", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "kotlin.jvm.PlatformType", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "onLoadMore"})
  static final class j
    implements LoadMoreRecyclerView.a
  {
    j(CardHomePageNewUI paramCardHomePageNewUI) {}
    
    public final void bYy()
    {
      AppMethodBeat.i(112447);
      CardHomePageNewUI.r(this.qfv);
      AppMethodBeat.o(112447);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "parent", "Landroid/support/v7/widget/RecyclerView;", "kotlin.jvm.PlatformType", "view", "Landroid/view/View;", "position", "", "id", "", "onItemClick"})
  static final class k
    implements MRecyclerView.a
  {
    k(CardHomePageNewUI paramCardHomePageNewUI) {}
    
    public final void S(View paramView, int paramInt)
    {
      AppMethodBeat.i(112448);
      paramView = CardHomePageNewUI.q(this.qfv).Ex(paramInt);
      if (paramView != null)
      {
        Log.i("MicroMsg.CardHomePageNewUI", "click type: %s", new Object[] { Integer.valueOf(paramView.type) });
        Object localObject2;
        switch (paramView.type)
        {
        case 3: 
        default: 
          AppMethodBeat.o(112448);
          return;
        case 2: 
          CardHomePageNewUI.k(this.qfv);
          CardHomePageNewUI.a(this.qfv, 1);
          CardHomePageNewUI.a(this.qfv, paramView.qfp);
          localObject1 = paramView.qfp;
          if (localObject1 == null) {
            p.hyc();
          }
          switch (((ud)localObject1).Ldc)
          {
          }
          for (;;)
          {
            localObject1 = com.tencent.mm.plugin.report.service.h.CyF;
            paramView = paramView.qfp;
            if (paramView == null) {
              p.hyc();
            }
            ((com.tencent.mm.plugin.report.service.h)localObject1).a(16324, new Object[] { Integer.valueOf(2), paramView.Ldn, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(paramInt), Integer.valueOf(CardHomePageNewUI.m(this.qfv)) });
            AppMethodBeat.o(112448);
            return;
            localObject1 = (MMActivity)this.qfv;
            localObject2 = paramView.qfp;
            if (localObject2 == null) {
              p.hyc();
            }
            com.tencent.mm.plugin.card.d.b.a((MMActivity)localObject1, ((ud)localObject2).Ldd);
            continue;
            localObject1 = paramView.qfp;
            if (localObject1 == null) {
              p.hyc();
            }
            localObject1 = ((ud)localObject1).Lde;
            com.tencent.mm.plugin.card.d.b.H(((un)localObject1).Hwr, ((un)localObject1).Hws, ((un)localObject1).IhZ);
          }
        case 4: 
          Log.i("MicroMsg.CardHomePageNewUI", "click ticket item");
          localObject1 = new Intent((Context)this.qfv, CardTicketListUI.class);
          paramView = this.qfv;
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject1);
          com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject1).axQ(), "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$initView$3", "onItemClick", "(Landroid/support/v7/widget/RecyclerView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$initView$3", "onItemClick", "(Landroid/support/v7/widget/RecyclerView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.plugin.report.service.h.CyF.a(16322, new Object[] { Integer.valueOf(5) });
          AppMethodBeat.o(112448);
          return;
        case 5: 
          com.tencent.mm.plugin.report.service.h.CyF.a(16322, new Object[] { Integer.valueOf(13) });
          AppMethodBeat.o(112448);
          return;
        }
        Object localObject1 = paramView.qft;
        if (localObject1 == null) {
          p.hyc();
        }
        switch (((ui)localObject1).LdM)
        {
        }
        for (;;)
        {
          localObject1 = paramView.qft;
          if (localObject1 == null) {
            p.hyc();
          }
          ((ui)localObject1).LdR = 0;
          paramView = paramView.qft;
          if (paramView == null) {
            p.hyc();
          }
          paramView.LdQ = 0;
          CardHomePageNewUI.q(this.qfv).ci(paramInt);
          break;
          localObject1 = (MMActivity)this.qfv;
          localObject2 = paramView.qft;
          if (localObject2 == null) {
            p.hyc();
          }
          com.tencent.mm.plugin.card.d.b.a((MMActivity)localObject1, ((ui)localObject2).LdN);
          CardHomePageNewUI.s(this.qfv);
          continue;
          localObject1 = paramView.qft;
          if (localObject1 == null) {
            p.hyc();
          }
          localObject1 = ((ui)localObject1).LdO;
          com.tencent.mm.plugin.card.d.b.H(((un)localObject1).Hwr, ((un)localObject1).Hws, ((un)localObject1).IhZ);
          CardHomePageNewUI.s(this.qfv);
          continue;
          localObject1 = new StringBuilder("click native url: ");
          localObject2 = paramView.qft;
          if (localObject2 == null) {
            p.hyc();
          }
          Log.i("MicroMsg.CardHomePageNewUI", ((ui)localObject2).LdP);
          localObject1 = paramView.qft;
          if (localObject1 == null) {
            p.hyc();
          }
          if (p.j("weixin://mktcard/cert", ((ui)localObject1).LdP))
          {
            localObject2 = new Intent((Context)this.qfv, CardTicketListUI.class);
            localObject1 = this.qfv;
            localObject2 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject2);
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$initView$3", "onItemClick", "(Landroid/support/v7/widget/RecyclerView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((CardHomePageNewUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$initView$3", "onItemClick", "(Landroid/support/v7/widget/RecyclerView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            CardHomePageNewUI.s(this.qfv);
          }
        }
      }
      AppMethodBeat.o(112448);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "parent", "Landroid/support/v7/widget/RecyclerView;", "kotlin.jvm.PlatformType", "view", "Landroid/view/View;", "position", "", "id", "", "onItemLongClick"})
  static final class l
    implements MRecyclerView.b
  {
    l(CardHomePageNewUI paramCardHomePageNewUI) {}
    
    public final boolean T(View paramView, final int paramInt)
    {
      AppMethodBeat.i(112452);
      paramView = CardHomePageNewUI.q(this.qfv).Ex(paramInt);
      if (paramView != null)
      {
        Log.i("MicroMsg.CardHomePageNewUI", "long click type: %s", new Object[] { Integer.valueOf(paramView.type) });
        switch (paramView.type)
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(112452);
        return false;
        Object localObject = new com.tencent.mm.ui.tools.l((Context)this.qfv.getContext());
        ((com.tencent.mm.ui.tools.l)localObject).a((o.f)new a(this, paramInt));
        ((com.tencent.mm.ui.tools.l)localObject).a((o.g)new b(paramView, this, paramInt));
        ((com.tencent.mm.ui.tools.l)localObject).gXI();
        localObject = com.tencent.mm.plugin.report.service.h.CyF;
        paramView = paramView.qfp;
        if (paramView == null) {
          p.hyc();
        }
        ((com.tencent.mm.plugin.report.service.h)localObject).a(16324, new Object[] { Integer.valueOf(2), paramView.Ldn, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(7), Integer.valueOf(paramInt), Integer.valueOf(CardHomePageNewUI.m(this.qfv)) });
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu", "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$initView$4$1$1"})
    static final class a
      implements o.f
    {
      a(CardHomePageNewUI.l paraml, int paramInt) {}
      
      public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramm)
      {
        AppMethodBeat.i(112449);
        paramm.d(1, (CharSequence)this.qfZ.qfv.getString(2131755778));
        AppMethodBeat.o(112449);
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected", "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$initView$4$1$2"})
    static final class b
      implements o.g
    {
      b(CardHomePageNewUI.a parama, CardHomePageNewUI.l paraml, int paramInt) {}
      
      public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
      {
        AppMethodBeat.i(112451);
        p.g(paramMenuItem, "menuItem");
        switch (paramMenuItem.getItemId())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(112451);
          return;
          com.tencent.mm.ui.base.h.a((Context)jdField_this.qfv.getContext(), jdField_this.qfv.getString(2131757068), "", false, (DialogInterface.OnClickListener)new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(112450);
              Object localObject1 = this.qgb.qfZ.qfv;
              Object localObject2 = this.qgb.qga.qfp;
              if (localObject2 == null) {
                p.hyc();
              }
              localObject2 = ((ud)localObject2).Ldn;
              p.g(localObject2, "element!!.card_pack_merchant_id");
              p.h(localObject2, "merchantId");
              Log.i("MicroMsg.CardHomePageNewUI", "do delete merchant: %s", new Object[] { localObject2 });
              new com.tencent.mm.plugin.card.model.a.d((String)localObject2).aYI().b((com.tencent.mm.vending.c.a)new CardHomePageNewUI.f((CardHomePageNewUI)localObject1, (String)localObject2));
              paramAnonymousDialogInterface.dismiss();
              paramAnonymousDialogInterface = com.tencent.mm.plugin.report.service.h.CyF;
              localObject1 = this.qgb.qga.qfp;
              if (localObject1 == null) {
                p.hyc();
              }
              paramAnonymousDialogInterface.a(16324, new Object[] { Integer.valueOf(2), ((ud)localObject1).Ldn, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(9), Integer.valueOf(this.qgb.oeZ), Integer.valueOf(CardHomePageNewUI.m(this.qgb.qfZ.qfv)) });
              AppMethodBeat.o(112450);
            }
          });
          paramMenuItem = com.tencent.mm.plugin.report.service.h.CyF;
          ud localud = this.qga.qfp;
          if (localud == null) {
            p.hyc();
          }
          paramMenuItem.a(16324, new Object[] { Integer.valueOf(2), localud.Ldn, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(8), Integer.valueOf(paramInt), Integer.valueOf(CardHomePageNewUI.m(jdField_this.qfv)) });
        }
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class m
    implements MenuItem.OnMenuItemClickListener
  {
    m(CardHomePageNewUI paramCardHomePageNewUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(112453);
      this.qfv.finish();
      AppMethodBeat.o(112453);
      return false;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick", "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$setFaqIconMenu$1$1"})
  static final class n
    implements MenuItem.OnMenuItemClickListener
  {
    n(ue paramue, CardHomePageNewUI paramCardHomePageNewUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(112456);
      paramMenuItem = new com.tencent.mm.ui.widget.a.e((Context)jdField_this.getContext(), 1, false);
      paramMenuItem.a((o.f)new o.f()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramAnonymousm)
        {
          AppMethodBeat.i(112454);
          paramAnonymousm.add(0, 0, 1, (CharSequence)this.qgd.qgc.LdB);
          AppMethodBeat.o(112454);
        }
      });
      paramMenuItem.a((o.g)new o.g()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(112455);
          p.g(paramAnonymousMenuItem, "menuItem");
          if (paramAnonymousMenuItem.getItemId() == 0) {
            switch (this.qgd.qgc.LdC)
            {
            }
          }
          for (;;)
          {
            AppMethodBeat.o(112455);
            return;
            com.tencent.mm.plugin.card.d.b.a((MMActivity)this.qgd.qfv, this.qgd.qgc.LdD);
            AppMethodBeat.o(112455);
            return;
            paramAnonymousMenuItem = this.qgd.qgc.LdE;
            com.tencent.mm.plugin.card.d.b.H(paramAnonymousMenuItem.Hwr, paramAnonymousMenuItem.Hws, paramAnonymousMenuItem.IhZ);
          }
        }
      });
      paramMenuItem.dGm();
      AppMethodBeat.o(112456);
      return false;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu", "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$showSortSheet$1$1"})
  static final class o
    implements o.f
  {
    o(CardHomePageNewUI paramCardHomePageNewUI) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramm)
    {
      AppMethodBeat.i(112457);
      Iterator localIterator = ((Iterable)CardHomePageNewUI.y(this.qfv)).iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        paramm.add(0, i, 1, (CharSequence)((uv)localIterator.next()).Les);
        i += 1;
      }
      AppMethodBeat.o(112457);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected", "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$showSortSheet$1$2"})
  static final class p
    implements o.g
  {
    p(CardHomePageNewUI paramCardHomePageNewUI) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(112459);
      p.g(paramMenuItem, "menuItem");
      paramInt = paramMenuItem.getItemId();
      Log.i("MicroMsg.CardHomePageNewUI", "click item: %s, sortType: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(CardHomePageNewUI.m(this.qfv)) });
      paramMenuItem = CardHomePageNewUI.y(this.qfv).get(paramInt);
      p.g(paramMenuItem, "cardSortInfoList[itemId]");
      paramMenuItem = (uv)paramMenuItem;
      CardHomePageNewUI.d(this.qfv, paramMenuItem.Ler);
      if ((paramMenuItem.Leq == 1) && (CardHomePageNewUI.m(this.qfv) != 1))
      {
        if (!this.qfv.qgs)
        {
          com.tencent.mm.ui.base.h.a((Context)this.qfv.getContext(), this.qfv.getString(2131757063), this.qfv.getString(2131763890), this.qfv.getString(2131762043), this.qfv.getString(2131757785), false, (DialogInterface.OnClickListener)new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(112458);
              this.qge.qfv.startActivityForResult(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"), 564);
              AppMethodBeat.o(112458);
            }
          }, null);
          AppMethodBeat.o(112459);
          return;
        }
        CardHomePageNewUI.b(this.qfv, true);
        CardHomePageNewUI.c(this.qfv, 0);
        CardHomePageNewUI.b(this.qfv, 1);
        CardHomePageNewUI.r(this.qfv);
        com.tencent.mm.plugin.report.service.h.CyF.a(16322, new Object[] { Integer.valueOf(15) });
        AppMethodBeat.o(112459);
        return;
      }
      if ((paramMenuItem.Leq == 2) && (CardHomePageNewUI.m(this.qfv) != 2))
      {
        CardHomePageNewUI.b(this.qfv, true);
        CardHomePageNewUI.c(this.qfv, 0);
        CardHomePageNewUI.b(this.qfv, 2);
        CardHomePageNewUI.r(this.qfv);
        com.tencent.mm.plugin.report.service.h.CyF.a(16322, new Object[] { Integer.valueOf(16) });
        AppMethodBeat.o(112459);
        return;
      }
      if ((paramMenuItem.Leq == 3) && (CardHomePageNewUI.m(this.qfv) != 3))
      {
        CardHomePageNewUI.b(this.qfv, true);
        CardHomePageNewUI.c(this.qfv, 0);
        CardHomePageNewUI.b(this.qfv, 3);
        CardHomePageNewUI.r(this.qfv);
        com.tencent.mm.plugin.report.service.h.CyF.a(16322, new Object[] { Integer.valueOf(17) });
      }
      AppMethodBeat.o(112459);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v2.CardHomePageNewUI
 * JD-Core Version:    0.7.0.1
 */