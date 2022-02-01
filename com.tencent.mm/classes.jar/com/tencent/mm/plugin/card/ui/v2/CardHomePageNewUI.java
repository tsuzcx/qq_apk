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
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.t;
import android.support.v7.widget.RecyclerView.w;
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
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.q;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView.a;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.a;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.b;
import com.tencent.mm.plugin.card.b.k;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.plugin.card.ui.CardDetailUI;
import com.tencent.mm.plugin.card.widget.CardTagTextView;
import com.tencent.mm.plugin.card.widget.MemberCardTopCropImageView;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.n;
import com.tencent.mm.protocal.protobuf.su;
import com.tencent.mm.protocal.protobuf.sv;
import com.tencent.mm.protocal.protobuf.sw;
import com.tencent.mm.protocal.protobuf.sy;
import com.tencent.mm.protocal.protobuf.sz;
import com.tencent.mm.protocal.protobuf.tc;
import com.tencent.mm.protocal.protobuf.td;
import com.tencent.mm.protocal.protobuf.tf;
import com.tencent.mm.protocal.protobuf.tg;
import com.tencent.mm.protocal.protobuf.ti;
import com.tencent.mm.protocal.protobuf.tq;
import com.tencent.mm.protocal.protobuf.tr;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import d.g.b.p;
import d.v;
import d.z;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.kernel.i
@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI;", "Lcom/tencent/mm/plugin/card/ui/v2/CardNewBaseUI;", "()V", "cardSortInfoList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/CardSortInfo;", "Lkotlin/collections/ArrayList;", "cardTitleModel", "Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$CardListModel;", "clickArea", "", "clickedCardHomePageElement", "Lcom/tencent/mm/protocal/protobuf/CardHomePageElement;", "emptyModel", "faqItem", "Lcom/tencent/mm/protocal/protobuf/CardHomePageFAQItem;", "firstLoad", "", "getCardHomePageScene", "Lcom/tencent/mm/plugin/card/model/v2/CgiGetMktCardHomePage;", "isAll", "isGotoItem", "isLoading", "mDivider", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "mHomePageAdapter", "Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageAdapter;", "mLoadingView", "Landroid/view/ViewGroup;", "mLoadingView2", "mRecyclerView", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "markReloadHomePage", "needReloadHomePage", "offset", "reqNum", "scene", "shouldShowTicket", "showSort", "sortType", "storeModelList", "ticketModel", "ticketNum", "", "tipsDialog", "Landroid/app/Dialog;", "titleSectionModel", "topCellList", "underModelList", "cardSortInfo", "doDeleteMchInList", "", "merchantId", "doGetCardHomePage", "doGetMchInfo", "lastReceiveTime", "", "getLayoutId", "initFirstScreen", "initView", "loadSnapshot", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinishLocationThings", "ret", "isLocationOk", "onResume", "saveSnapshot", "setFaqIconMenu", "showSortSheet", "updateModelList", "storePageList", "Lcom/tencent/mm/protocal/protobuf/CardHomePageStoreList;", "underPageList", "Lcom/tencent/mm/protocal/protobuf/CardHomePageUnderList;", "_topCellList", "Lcom/tencent/mm/protocal/protobuf/CardHomePageTopCellList;", "CardListModel", "CardSpan", "Companion", "HomePageAdapter", "HomePageVH", "plugin-card_release"})
public final class CardHomePageNewUI
  extends CardNewBaseUI
{
  private static final int dby;
  public static final CardHomePageNewUI.c oRA;
  private static final int oRy;
  private static final int oRz;
  private boolean glB;
  private Dialog iXW;
  private boolean isLoading;
  private int oHL;
  private LoadMoreRecyclerView oQZ;
  private d oRa;
  private ViewGroup oRb;
  private RecyclerView.h oRc;
  private ViewGroup oRd;
  private int oRe;
  private boolean oRf;
  private String oRg;
  private final ArrayList<a> oRh;
  private final ArrayList<a> oRi;
  private final ArrayList<a> oRj;
  private a oRk;
  private a oRl;
  private a oRm;
  private a oRn;
  private boolean oRo;
  private int oRp;
  private boolean oRq;
  private int oRr;
  private ArrayList<tq> oRs;
  private boolean oRt;
  private sz oRu;
  private sy oRv;
  private boolean oRw;
  private com.tencent.mm.plugin.card.model.a.g oRx;
  private int offset;
  private int scene;
  
  static
  {
    AppMethodBeat.i(112470);
    oRA = new CardHomePageNewUI.c((byte)0);
    dby = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 40);
    oRy = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 1);
    oRz = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 16);
    AppMethodBeat.o(112470);
  }
  
  public CardHomePageNewUI()
  {
    AppMethodBeat.i(112469);
    this.oRe = 10;
    this.oRg = "";
    this.oRh = new ArrayList();
    this.oRi = new ArrayList();
    this.oRj = new ArrayList();
    this.glB = true;
    this.oRp = -1;
    this.oRq = true;
    this.oRs = new ArrayList();
    this.oRu = new sz();
    AppMethodBeat.o(112469);
  }
  
  private final void bZj()
  {
    AppMethodBeat.i(112468);
    ae.i("MicroMsg.CardHomePageNewUI", "do get card Home page: %s, %s", new Object[] { Boolean.valueOf(this.oRf), Boolean.valueOf(this.isLoading) });
    Object localObject;
    if ((this.oRw) || ((!this.oRf) && (!this.isLoading)))
    {
      this.isLoading = true;
      if (this.oRw)
      {
        localObject = this.oRd;
        if (localObject == null) {
          p.bdF("mLoadingView2");
        }
        ((ViewGroup)localObject).setVisibility(0);
        if (this.oRm != null)
        {
          localObject = this.oRd;
          if (localObject == null) {
            p.bdF("mLoadingView2");
          }
          localObject = ((ViewGroup)localObject).getLayoutParams();
          if (localObject == null)
          {
            localObject = new v("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            AppMethodBeat.o(112468);
            throw ((Throwable)localObject);
          }
          localObject = (RelativeLayout.LayoutParams)localObject;
          ((RelativeLayout.LayoutParams)localObject).topMargin = com.tencent.mm.cb.a.fromDPToPix((Context)getContext(), 80);
          ViewGroup localViewGroup = this.oRd;
          if (localViewGroup == null) {
            p.bdF("mLoadingView2");
          }
          localViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
      localObject = bZi();
      if (localObject == null) {
        break label361;
      }
    }
    label361:
    for (int i = ((tq)localObject).GjM;; i = 10)
    {
      this.oRe = i;
      if (this.iXW != null)
      {
        localObject = this.iXW;
        if (localObject == null) {
          p.gkB();
        }
        ((Dialog)localObject).dismiss();
      }
      if (this.oRi.isEmpty())
      {
        localObject = (Context)getContext();
        getContext().getString(2131755726);
        this.iXW = ((Dialog)h.b((Context)localObject, getContext().getString(2131760709), true, null));
      }
      this.oRx = new com.tencent.mm.plugin.card.model.a.g(this.offset, this.oRe, this.dzE, this.dBu, this.oHL);
      localObject = this.oRx;
      if (localObject == null) {
        p.gkB();
      }
      ((com.tencent.mm.plugin.card.model.a.g)localObject).aES().aET().b((com.tencent.mm.vending.c.a)new g(this)).a((com.tencent.mm.vending.e.b)this);
      AppMethodBeat.o(112468);
      return;
    }
  }
  
  public final void X(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(112465);
    ae.i("MicroMsg.CardHomePageNewUI", "location finish: [%s, %s], ret: %s, isOk: %s", new Object[] { Float.valueOf(this.dzE), Float.valueOf(this.dBu), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    if (this.glB)
    {
      if ((this.oRr == 1) && (paramInt < 0) && (this.oHL == 1))
      {
        this.oHL = 0;
        if (paramInt == -2) {
          com.tencent.mm.plugin.report.service.g.yxI.f(16322, new Object[] { Integer.valueOf(30) });
        }
      }
      bZj();
      AppMethodBeat.o(112465);
      return;
    }
    if (!paramBoolean) {
      bZs();
    }
    AppMethodBeat.o(112465);
  }
  
  public final void a(tc paramtc, tg paramtg, tf paramtf)
  {
    int j = 0;
    AppMethodBeat.i(112467);
    Object localObject;
    int i;
    if (paramtc != null)
    {
      localObject = paramtc.Gjd;
      p.g(localObject, "card_home_page_element");
      if (!((Collection)localObject).isEmpty()) {}
      for (i = 1; i != 0; i = 0)
      {
        paramtc = paramtc.Gjd.iterator();
        while (paramtc.hasNext())
        {
          localObject = (sy)paramtc.next();
          a locala = new a();
          locala.oRB = ((sy)localObject);
          locala.type = 0;
          this.oRi.add(locala);
        }
      }
    }
    if (paramtg != null)
    {
      paramtc = paramtg.Gjd;
      p.g(paramtc, "card_home_page_element");
      if (!((Collection)paramtc).isEmpty()) {}
      for (i = 1; i != 0; i = 0)
      {
        if (bu.isNullOrNil(paramtg.Gjp)) {
          paramtg.Gjp = getString(2131756875);
        }
        if (this.oRl == null)
        {
          this.oRl = new a();
          paramtc = this.oRl;
          if (paramtc == null) {
            p.gkB();
          }
          paramtc.type = 1;
        }
        paramtc = this.oRl;
        if (paramtc == null) {
          p.gkB();
        }
        localObject = paramtg.Gjp;
        p.g(localObject, "section_title");
        paramtc.ZF((String)localObject);
        paramtc = paramtg.Gjd.iterator();
        while (paramtc.hasNext())
        {
          paramtg = (sy)paramtc.next();
          localObject = new a();
          ((a)localObject).oRB = paramtg;
          ((a)localObject).type = 2;
          this.oRj.add(localObject);
        }
      }
    }
    if (paramtf != null)
    {
      paramtc = paramtf.Gjo;
      p.g(paramtc, "card_home_page_top_cell");
      if (!((Collection)paramtc).isEmpty()) {}
      for (i = 1; i != 0; i = 0)
      {
        paramtc = paramtf.Gjo;
        p.g(paramtc, "card_home_page_top_cell");
        paramtc = ((Iterable)paramtc).iterator();
        i = 0;
        while (paramtc.hasNext())
        {
          paramtg = (td)paramtc.next();
          localObject = new a();
          ((a)localObject).oRF = paramtg;
          ((a)localObject).type = 6;
          if (i == paramtf.Gjo.size() - 1) {
            ((a)localObject).oRG = true;
          }
          this.oRh.add(localObject);
          i += 1;
        }
      }
    }
    this.oRn = new a();
    paramtc = this.oRn;
    if (paramtc == null) {
      p.gkB();
    }
    paramtc.type = 5;
    if ((this.oRi.isEmpty()) && (this.oRj.isEmpty()))
    {
      i = j;
      if (!((Collection)this.oRh).isEmpty()) {
        i = 1;
      }
      if (i != 0)
      {
        this.oRk = new a();
        paramtc = this.oRk;
        if (paramtc == null) {
          p.gkB();
        }
        paramtc.type = 7;
        AppMethodBeat.o(112467);
        return;
      }
    }
    this.oRk = null;
    AppMethodBeat.o(112467);
  }
  
  public final void bZh()
  {
    AppMethodBeat.i(112461);
    sz localsz = this.oRu;
    if (localsz != null)
    {
      if (!bu.isNullOrNil(localsz.GiX))
      {
        removeAllOptionMenu();
        addIconOptionMenu(0, 0, 2131690603, (MenuItem.OnMenuItemClickListener)new n(localsz, this));
      }
      AppMethodBeat.o(112461);
      return;
    }
    AppMethodBeat.o(112461);
  }
  
  public final tq bZi()
  {
    AppMethodBeat.i(112466);
    Iterator localIterator = this.oRs.iterator();
    while (localIterator.hasNext())
    {
      tq localtq = (tq)localIterator.next();
      if (localtq.GjL == this.oHL)
      {
        AppMethodBeat.o(112466);
        return localtq;
      }
    }
    AppMethodBeat.o(112466);
    return null;
  }
  
  public final int getLayoutId()
  {
    return 2131493297;
  }
  
  public final void initView()
  {
    int i = 0;
    int j = 1;
    AppMethodBeat.i(112464);
    Object localObject1 = findViewById(2131298313);
    p.g(localObject1, "findViewById(R.id.chpu_rv)");
    this.oQZ = ((LoadMoreRecyclerView)localObject1);
    localObject1 = this.oQZ;
    if (localObject1 == null) {
      p.bdF("mRecyclerView");
    }
    getContext();
    ((LoadMoreRecyclerView)localObject1).setLayoutManager((RecyclerView.i)new LinearLayoutManager());
    this.oRa = new d();
    localObject1 = this.oQZ;
    if (localObject1 == null) {
      p.bdF("mRecyclerView");
    }
    Object localObject2 = this.oRa;
    if (localObject2 == null) {
      p.bdF("mHomePageAdapter");
    }
    ((LoadMoreRecyclerView)localObject1).setAdapter((RecyclerView.a)localObject2);
    localObject1 = LayoutInflater.from((Context)this);
    localObject2 = this.oQZ;
    if (localObject2 == null) {
      p.bdF("mRecyclerView");
    }
    localObject1 = ((LayoutInflater)localObject1).inflate(2131493294, (ViewGroup)localObject2, false);
    if (localObject1 == null)
    {
      localObject1 = new v("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(112464);
      throw ((Throwable)localObject1);
    }
    this.oRb = ((ViewGroup)localObject1);
    localObject1 = findViewById(2131298312);
    p.g(localObject1, "findViewById(R.id.chpu_loading_layout)");
    this.oRd = ((ViewGroup)localObject1);
    localObject1 = this.oQZ;
    if (localObject1 == null) {
      p.bdF("mRecyclerView");
    }
    localObject2 = this.oRb;
    if (localObject2 == null) {
      p.bdF("mLoadingView");
    }
    ((LoadMoreRecyclerView)localObject1).setLoadingView((View)localObject2);
    this.oRc = ((RecyclerView.h)new i(this));
    localObject1 = this.oQZ;
    if (localObject1 == null) {
      p.bdF("mRecyclerView");
    }
    localObject2 = this.oRc;
    if (localObject2 == null) {
      p.bdF("mDivider");
    }
    ((LoadMoreRecyclerView)localObject1).b((RecyclerView.h)localObject2);
    localObject1 = this.oQZ;
    if (localObject1 == null) {
      p.bdF("mRecyclerView");
    }
    ((LoadMoreRecyclerView)localObject1).setOnLoadingStateChangedListener((LoadMoreRecyclerView.a)new j(this));
    localObject1 = this.oQZ;
    if (localObject1 == null) {
      p.bdF("mRecyclerView");
    }
    ((LoadMoreRecyclerView)localObject1).setOnItemClickListener((MRecyclerView.a)new k(this));
    localObject1 = this.oQZ;
    if (localObject1 == null) {
      p.bdF("mRecyclerView");
    }
    ((LoadMoreRecyclerView)localObject1).setOnItemLongClickListener((MRecyclerView.b)new l(this));
    localObject1 = new tc();
    localObject2 = new tg();
    tf localtf = new tf();
    tr localtr = new tr();
    Object localObject3 = com.tencent.mm.plugin.card.model.a.a.oHA;
    localObject3 = this.oRu;
    p.h(localObject1, "storeList");
    p.h(localObject2, "underList");
    p.h(localtf, "topList");
    p.h(localtr, "cardSortInfoList");
    ae.i(com.tencent.mm.plugin.card.model.a.a.access$getTAG$cp(), "load home page snapshot");
    Object localObject4 = com.tencent.mm.kernel.g.ajR();
    p.g(localObject4, "MMKernel.storage()");
    localObject4 = (String)((com.tencent.mm.kernel.e)localObject4).ajA().i(am.a.IZg);
    Charset localCharset;
    if (localObject4 != null)
    {
      localCharset = d.n.d.ISO_8859_1;
      if (localObject4 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(112464);
        throw ((Throwable)localObject1);
      }
      localObject4 = ((String)localObject4).getBytes(localCharset);
      p.g(localObject4, "(this as java.lang.String).getBytes(charset)");
      ((tc)localObject1).parseFrom((byte[])localObject4);
      i = 1;
    }
    localObject4 = com.tencent.mm.kernel.g.ajR();
    p.g(localObject4, "MMKernel.storage()");
    localObject4 = (String)((com.tencent.mm.kernel.e)localObject4).ajA().i(am.a.IZh);
    if (localObject4 != null)
    {
      localCharset = d.n.d.ISO_8859_1;
      if (localObject4 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(112464);
        throw ((Throwable)localObject1);
      }
      localObject4 = ((String)localObject4).getBytes(localCharset);
      p.g(localObject4, "(this as java.lang.String).getBytes(charset)");
      ((tg)localObject2).parseFrom((byte[])localObject4);
      i = 1;
    }
    localObject4 = com.tencent.mm.kernel.g.ajR();
    p.g(localObject4, "MMKernel.storage()");
    localObject4 = (String)((com.tencent.mm.kernel.e)localObject4).ajA().i(am.a.IZi);
    if (localObject4 != null)
    {
      localCharset = d.n.d.ISO_8859_1;
      if (localObject4 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(112464);
        throw ((Throwable)localObject1);
      }
      localObject4 = ((String)localObject4).getBytes(localCharset);
      p.g(localObject4, "(this as java.lang.String).getBytes(charset)");
      localtf.parseFrom((byte[])localObject4);
      i = 1;
    }
    localObject4 = com.tencent.mm.kernel.g.ajR();
    p.g(localObject4, "MMKernel.storage()");
    localObject4 = (String)((com.tencent.mm.kernel.e)localObject4).ajA().i(am.a.IZj);
    if (localObject4 != null)
    {
      localCharset = d.n.d.ISO_8859_1;
      if (localObject4 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(112464);
        throw ((Throwable)localObject1);
      }
      localObject4 = ((String)localObject4).getBytes(localCharset);
      p.g(localObject4, "(this as java.lang.String).getBytes(charset)");
      localtr.parseFrom((byte[])localObject4);
      i = 1;
    }
    localObject4 = com.tencent.mm.kernel.g.ajR();
    p.g(localObject4, "MMKernel.storage()");
    localObject4 = (String)((com.tencent.mm.kernel.e)localObject4).ajA().i(am.a.IZk);
    if (localObject4 != null)
    {
      i = j;
      if (localObject3 != null)
      {
        localCharset = d.n.d.ISO_8859_1;
        if (localObject4 == null)
        {
          localObject1 = new v("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(112464);
          throw ((Throwable)localObject1);
        }
        localObject4 = ((String)localObject4).getBytes(localCharset);
        p.g(localObject4, "(this as java.lang.String).getBytes(charset)");
        ((sz)localObject3).parseFrom((byte[])localObject4);
        i = j;
      }
    }
    for (;;)
    {
      this.oRs.clear();
      this.oRs.addAll((Collection)localtr.GjO);
      a((tc)localObject1, (tg)localObject2, localtf);
      if ((i == 0) && (this.oRi.isEmpty()) && (this.oRj.isEmpty()))
      {
        ae.i("MicroMsg.CardHomePageNewUI", "show init view");
        localObject1 = new a();
        ((a)localObject1).type = 3;
        localObject2 = new a();
        ((a)localObject2).type = 3;
        this.oRi.add(localObject1);
        this.oRi.add(localObject2);
      }
      bZh();
      localObject1 = this.oQZ;
      if (localObject1 == null) {
        p.bdF("mRecyclerView");
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
    setMMTitle(2131756891);
    this.scene = getIntent().getIntExtra("key_home_page_from_scene", 0);
    initView();
    this.oRr = 1;
    paramBundle = com.tencent.mm.kernel.g.ajR();
    p.g(paramBundle, "MMKernel.storage()");
    this.oHL = paramBundle.ajA().getInt(am.a.IZy, 1);
    if (this.oHL == 0) {
      this.oHL = 1;
    }
    if (this.oRr == 1) {
      com.tencent.mm.plugin.report.service.g.yxI.f(16322, new Object[] { Integer.valueOf(14) });
    }
    ae.i("MicroMsg.CardHomePageNewUI", "on create, scene: %s", new Object[] { Integer.valueOf(this.scene) });
    setBackBtn((MenuItem.OnMenuItemClickListener)new m(this));
    com.tencent.mm.plugin.report.service.g.yxI.f(16322, new Object[] { Integer.valueOf(4) });
    ((com.tencent.mm.pluginsdk.wallet.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.b.class)).gD(8, 2);
    AppMethodBeat.o(112460);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(112462);
    super.onDestroy();
    Object localObject1 = com.tencent.mm.kernel.g.ajR();
    p.g(localObject1, "MMKernel.storage()");
    ((com.tencent.mm.kernel.e)localObject1).ajA().set(am.a.IZy, Integer.valueOf(this.oHL));
    if (this.oRx != null)
    {
      localObject1 = this.oRx;
      if (localObject1 == null) {
        p.gkB();
      }
      ((com.tencent.mm.plugin.card.model.a.g)localObject1).cancel();
      this.oRx = null;
    }
    k.bVR();
    ae.i("MicroMsg.CardHomePageNewUI", "do save snap shot");
    Object localObject3 = new tc();
    ((tc)localObject3).Gjd = new LinkedList();
    localObject1 = this.oRi.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((a)((Iterator)localObject1).next()).oRB;
      if (localObject2 != null) {
        ((tc)localObject3).Gjd.add(localObject2);
      }
    }
    Object localObject2 = new tg();
    localObject1 = this.oRl;
    if (localObject1 != null) {}
    for (localObject1 = ((a)localObject1).bZm();; localObject1 = null)
    {
      ((tg)localObject2).Gjp = ((String)localObject1);
      ((tg)localObject2).Gjd = new LinkedList();
      localObject1 = this.oRj.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject4 = ((a)((Iterator)localObject1).next()).oRB;
        if (localObject4 != null) {
          ((tg)localObject2).Gjd.add(localObject4);
        }
      }
    }
    tf localtf = new tf();
    localObject1 = this.oRh.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject4 = ((a)((Iterator)localObject1).next()).oRF;
      if (localObject4 != null) {
        localtf.Gjo.add(localObject4);
      }
    }
    Object localObject4 = new tr();
    ((tr)localObject4).GjO.addAll((Collection)this.oRs);
    localObject1 = com.tencent.mm.plugin.card.model.a.a.oHA;
    localObject1 = this.oRu;
    p.h(localObject3, "storeList");
    p.h(localObject2, "underList");
    p.h(localtf, "topList");
    p.h(localObject4, "sortInfoList");
    ae.i(com.tencent.mm.plugin.card.model.a.a.access$getTAG$cp(), "save home page snapshot");
    localObject3 = ((tc)localObject3).toByteArray();
    p.g(localObject3, "storeList.toByteArray()");
    localObject3 = new String((byte[])localObject3, d.n.d.ISO_8859_1);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.ajR();
    p.g(locale, "MMKernel.storage()");
    locale.ajA().set(am.a.IZg, localObject3);
    localObject2 = ((tg)localObject2).toByteArray();
    p.g(localObject2, "underList.toByteArray()");
    localObject2 = new String((byte[])localObject2, d.n.d.ISO_8859_1);
    localObject3 = com.tencent.mm.kernel.g.ajR();
    p.g(localObject3, "MMKernel.storage()");
    ((com.tencent.mm.kernel.e)localObject3).ajA().set(am.a.IZh, localObject2);
    localObject2 = localtf.toByteArray();
    p.g(localObject2, "topList.toByteArray()");
    localObject2 = new String((byte[])localObject2, d.n.d.ISO_8859_1);
    localObject3 = com.tencent.mm.kernel.g.ajR();
    p.g(localObject3, "MMKernel.storage()");
    ((com.tencent.mm.kernel.e)localObject3).ajA().set(am.a.IZi, localObject2);
    localObject2 = ((tr)localObject4).toByteArray();
    p.g(localObject2, "sortInfoList.toByteArray()");
    localObject2 = new String((byte[])localObject2, d.n.d.ISO_8859_1);
    localObject3 = com.tencent.mm.kernel.g.ajR();
    p.g(localObject3, "MMKernel.storage()");
    ((com.tencent.mm.kernel.e)localObject3).ajA().set(am.a.IZj, localObject2);
    if (localObject1 != null)
    {
      localObject1 = ((sz)localObject1).toByteArray();
      p.g(localObject1, "faqItem.toByteArray()");
      localObject1 = new String((byte[])localObject1, d.n.d.ISO_8859_1);
      localObject2 = com.tencent.mm.kernel.g.ajR();
      p.g(localObject2, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject2).ajA().set(am.a.IZk, localObject1);
    }
    AppMethodBeat.o(112462);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(112463);
    super.onResume();
    if ((this.oRo) && (this.oRv != null) && (this.oRp != -1))
    {
      Object localObject = this.oRv;
      if (localObject == null) {
        p.gkB();
      }
      localObject = ((sy)localObject).GiJ;
      p.g(localObject, "clickedCardHomePageElement!!.card_pack_merchant_id");
      sy localsy = this.oRv;
      if (localsy == null) {
        p.gkB();
      }
      long l = localsy.GiW;
      ae.i("MicroMsg.CardHomePageNewUI", "do get mch infoset: %s", new Object[] { localObject });
      new com.tencent.mm.plugin.card.model.a.f((String)localObject, l, this.dzE, this.dBu, this.oHL).aET().b((com.tencent.mm.vending.c.a)new h(this, (String)localObject));
      this.oRo = false;
      this.oRv = null;
      AppMethodBeat.o(112463);
      return;
    }
    if (this.oRt)
    {
      this.oRw = true;
      this.offset = 0;
      this.oRt = false;
      bZj();
    }
    AppMethodBeat.o(112463);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$CardListModel;", "", "(Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI;)V", "element", "Lcom/tencent/mm/protocal/protobuf/CardHomePageElement;", "getElement", "()Lcom/tencent/mm/protocal/protobuf/CardHomePageElement;", "setElement", "(Lcom/tencent/mm/protocal/protobuf/CardHomePageElement;)V", "expandState", "", "getExpandState", "()Z", "setExpandState", "(Z)V", "hasRender", "getHasRender", "setHasRender", "sectionTitle", "", "getSectionTitle", "()Ljava/lang/String;", "setSectionTitle", "(Ljava/lang/String;)V", "showDivider", "getShowDivider", "setShowDivider", "topElement", "Lcom/tencent/mm/protocal/protobuf/CardHomePageTopCell;", "getTopElement", "()Lcom/tencent/mm/protocal/protobuf/CardHomePageTopCell;", "setTopElement", "(Lcom/tencent/mm/protocal/protobuf/CardHomePageTopCell;)V", "type", "", "getType", "()I", "setType", "(I)V", "plugin-card_release"})
  public final class a
  {
    sy oRB;
    public String oRC;
    boolean oRD;
    boolean oRE;
    td oRF;
    boolean oRG;
    int type;
    
    public final void ZF(String paramString)
    {
      AppMethodBeat.i(112405);
      p.h(paramString, "<set-?>");
      this.oRC = paramString;
      AppMethodBeat.o(112405);
    }
    
    public final String bZm()
    {
      AppMethodBeat.i(112404);
      String str = this.oRC;
      if (str == null) {
        p.bdF("sectionTitle");
      }
      AppMethodBeat.o(112404);
      return str;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH;", "Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI;", "(Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI;)V", "appendUnderList", "", "model", "Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$CardListModel;", "getItemCount", "", "getItemViewType", "position", "getModelByPos", "getPosByMerchantId", "merchantId", "", "moveStoreToUnderList", "", "element", "Lcom/tencent/mm/protocal/protobuf/CardHomePageElement;", "onBindViewHolder", "holder", "payloads", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "removeModelByMId", "removeTitleSection", "replaceModelByMId", "mchInfo", "plugin-card_release"})
  public final class d
    extends RecyclerView.a<CardHomePageNewUI.e>
  {
    private int ZH(String paramString)
    {
      int k = 0;
      AppMethodBeat.i(112415);
      p.h(paramString, "merchantId");
      if (CardHomePageNewUI.g(this.oRH) != null) {}
      for (int i = 1;; i = 0)
      {
        if (CardHomePageNewUI.f(this.oRH) != null) {
          i += 1;
        }
        for (;;)
        {
          Iterator localIterator = ((Iterable)CardHomePageNewUI.a(this.oRH)).iterator();
          int j = 0;
          Object localObject;
          while (localIterator.hasNext())
          {
            localObject = ((CardHomePageNewUI.a)localIterator.next()).oRB;
            if (localObject != null) {}
            for (localObject = ((sy)localObject).GiJ; p.i(localObject, paramString); localObject = null)
            {
              AppMethodBeat.o(112415);
              return i + j;
            }
            j += 1;
          }
          i = CardHomePageNewUI.a(this.oRH).size() + i - 1;
          if (CardHomePageNewUI.c(this.oRH) != null) {
            i += 1;
          }
          for (;;)
          {
            localIterator = ((Iterable)CardHomePageNewUI.b(this.oRH)).iterator();
            j = k;
            while (localIterator.hasNext())
            {
              localObject = ((CardHomePageNewUI.a)localIterator.next()).oRB;
              if (localObject != null) {}
              for (localObject = ((sy)localObject).GiJ; p.i(localObject, paramString); localObject = null)
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
    
    public final CardHomePageNewUI.a AS(int paramInt)
    {
      int j = 0;
      AppMethodBeat.i(112413);
      Object localObject1 = CardHomePageNewUI.a(this.oRH);
      Object localObject2;
      if (localObject1 != null)
      {
        localObject1 = Integer.valueOf(((ArrayList)localObject1).size());
        localObject2 = CardHomePageNewUI.a(this.oRH);
        if (localObject2 == null) {
          break label156;
        }
        localObject2 = Integer.valueOf(((ArrayList)localObject2).size());
        label55:
        if (CardHomePageNewUI.c(this.oRH) == null) {
          break label162;
        }
      }
      label156:
      label162:
      for (boolean bool = true;; bool = false)
      {
        ae.d("MicroMsg.CardHomePageNewUI", "pos: %s, sSize: %s, uSize: %s, title: %s", new Object[] { Integer.valueOf(paramInt), localObject1, localObject2, Boolean.valueOf(bool) });
        localObject1 = CardHomePageNewUI.g(this.oRH);
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
      localObject1 = CardHomePageNewUI.f(this.oRH);
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
      localObject1 = CardHomePageNewUI.h(this.oRH);
      if ((localObject1 != null) && (paramInt == i))
      {
        AppMethodBeat.o(112413);
        return localObject1;
      }
      localObject1 = CardHomePageNewUI.a(this.oRH);
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
      if (CardHomePageNewUI.c(this.oRH) != null)
      {
        j += 1;
        i = j;
        if (paramInt == j)
        {
          localObject1 = CardHomePageNewUI.c(this.oRH);
          AppMethodBeat.o(112413);
          return localObject1;
        }
      }
      localObject1 = CardHomePageNewUI.b(this.oRH);
      if ((localObject1 != null) && (paramInt > i) && (paramInt <= ((ArrayList)localObject1).size() + i))
      {
        localObject1 = (CardHomePageNewUI.a)((ArrayList)localObject1).get(paramInt - i - 1);
        AppMethodBeat.o(112413);
        return localObject1;
      }
      AppMethodBeat.o(112413);
      return null;
    }
    
    public final void ZG(String paramString)
    {
      AppMethodBeat.i(112414);
      p.h(paramString, "merchantId");
      Iterator localIterator = CardHomePageNewUI.a(this.oRH).iterator();
      CardHomePageNewUI.a locala;
      Object localObject;
      while (localIterator.hasNext())
      {
        locala = (CardHomePageNewUI.a)localIterator.next();
        localObject = locala.oRB;
        if (localObject != null) {}
        for (localObject = ((sy)localObject).GiJ; p.i(localObject, paramString); localObject = null)
        {
          CardHomePageNewUI.a(this.oRH).remove(locala);
          paramString = CardHomePageNewUI.j(this.oRH).getAdapter();
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
      localIterator = CardHomePageNewUI.b(this.oRH).iterator();
      while (localIterator.hasNext())
      {
        locala = (CardHomePageNewUI.a)localIterator.next();
        localObject = locala.oRB;
        if (localObject != null) {}
        for (localObject = ((sy)localObject).GiJ; p.i(localObject, paramString); localObject = null)
        {
          CardHomePageNewUI.b(this.oRH).remove(locala);
          if (CardHomePageNewUI.b(this.oRH).size() != 0) {
            break label231;
          }
          CardHomePageNewUI.d(this.oRH);
          paramString = CardHomePageNewUI.j(this.oRH).getAdapter();
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
    
    public final void a(String paramString, sy paramsy)
    {
      AppMethodBeat.i(112416);
      p.h(paramString, "merchantId");
      p.h(paramsy, "mchInfo");
      Iterator localIterator = CardHomePageNewUI.a(this.oRH).iterator();
      CardHomePageNewUI.a locala;
      Object localObject;
      int i;
      while (localIterator.hasNext())
      {
        locala = (CardHomePageNewUI.a)localIterator.next();
        localObject = locala.oRB;
        if (localObject != null) {}
        for (localObject = ((sy)localObject).GiJ; p.i(localObject, paramString); localObject = null)
        {
          locala.oRB = paramsy;
          i = ZH(paramString);
          if (i < 0) {
            break label130;
          }
          paramString = CardHomePageNewUI.j(this.oRH).getAdapter();
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
      localIterator = CardHomePageNewUI.b(this.oRH).iterator();
      while (localIterator.hasNext())
      {
        locala = (CardHomePageNewUI.a)localIterator.next();
        localObject = locala.oRB;
        if (localObject != null) {}
        for (localObject = ((sy)localObject).GiJ; p.i(localObject, paramString); localObject = null)
        {
          locala.oRB = paramsy;
          i = ZH(paramString);
          if (i < 0) {
            break label249;
          }
          paramString = CardHomePageNewUI.j(this.oRH).getAdapter();
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
    
    public final int getItemCount()
    {
      int i2 = 1;
      AppMethodBeat.i(112409);
      ArrayList localArrayList = CardHomePageNewUI.a(this.oRH);
      int i;
      int j;
      if (localArrayList != null)
      {
        i = localArrayList.size();
        localArrayList = CardHomePageNewUI.b(this.oRH);
        if (localArrayList == null) {
          break label147;
        }
        j = localArrayList.size();
        label49:
        if (CardHomePageNewUI.c(this.oRH) == null) {
          break label176;
        }
      }
      label147:
      label158:
      label176:
      for (int k = 1;; k = 0)
      {
        if (CardHomePageNewUI.e(this.oRH) != null) {}
        for (int m = 1;; m = 0)
        {
          if (CardHomePageNewUI.f(this.oRH) != null) {}
          for (int n = 1;; n = 0)
          {
            localArrayList = CardHomePageNewUI.g(this.oRH);
            int i1;
            if (localArrayList != null)
            {
              i1 = localArrayList.size();
              label108:
              if (CardHomePageNewUI.h(this.oRH) == null) {
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
      CardHomePageNewUI.a locala = AS(paramInt);
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
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "viewType", "", "(Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI;Landroid/view/View;I)V", "chpiCouponLayout", "Landroid/widget/LinearLayout;", "getChpiCouponLayout", "()Landroid/widget/LinearLayout;", "setChpiCouponLayout", "(Landroid/widget/LinearLayout;)V", "chpiDescTv", "Landroid/widget/TextView;", "getChpiDescTv", "()Landroid/widget/TextView;", "setChpiDescTv", "(Landroid/widget/TextView;)V", "chpiExpandIv", "Landroid/widget/ImageView;", "getChpiExpandIv", "()Landroid/widget/ImageView;", "setChpiExpandIv", "(Landroid/widget/ImageView;)V", "chpiExpandLayout", "getChpiExpandLayout", "setChpiExpandLayout", "chpiExpandTv", "getChpiExpandTv", "setChpiExpandTv", "chpiHeaderLayout", "getChpiHeaderLayout", "setChpiHeaderLayout", "chpiLabelLayout", "getChpiLabelLayout", "setChpiLabelLayout", "chpiLogoIv", "Lcom/tencent/mm/pluginsdk/ui/applet/CdnImageView;", "getChpiLogoIv", "()Lcom/tencent/mm/pluginsdk/ui/applet/CdnImageView;", "setChpiLogoIv", "(Lcom/tencent/mm/pluginsdk/ui/applet/CdnImageView;)V", "chpiMchLabelTv", "Lcom/tencent/mm/plugin/card/ui/v2/CardLabelTextView;", "getChpiMchLabelTv", "()Lcom/tencent/mm/plugin/card/ui/v2/CardLabelTextView;", "setChpiMchLabelTv", "(Lcom/tencent/mm/plugin/card/ui/v2/CardLabelTextView;)V", "chpiNameTv", "getChpiNameTv", "setChpiNameTv", "chtiDescTv", "getChtiDescTv", "setChtiDescTv", "chtiDivider", "getChtiDivider", "()Landroid/view/View;", "setChtiDivider", "(Landroid/view/View;)V", "chtiIconIv", "getChtiIconIv", "setChtiIconIv", "chtiNewTv", "getChtiNewTv", "setChtiNewTv", "chtiRedDotIv", "getChtiRedDotIv", "setChtiRedDotIv", "chtiRightIv", "getChtiRightIv", "setChtiRightIv", "chtiTitleTv", "getChtiTitleTv", "setChtiTitleTv", "model", "Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$CardListModel;", "Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI;", "getModel", "()Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$CardListModel;", "setModel", "(Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$CardListModel;)V", "sectionTitleTv", "getSectionTitleTv", "setSectionTitleTv", "addCouponView", "", "view", "appendCouponView", "offset", "len", "position", "collapseCouponLayout", "expandCouponLayout", "gotoCardDetailUI", "cardId", "", "setCardBg", "imageView", "url", "radius", "", "defaultRes", "setIcon", "useBackendExpandState", "", "showCollapseLayout", "showExpandLayout", "showMiniAppLayout", "updateCardLabelLayout", "couponLabelList", "", "Lcom/tencent/mm/protocal/protobuf/CardElementCouponLabel;", "labelLayout", "labelList", "Lcom/tencent/mm/protocal/protobuf/CardElementMchLabel;", "updateExpandLayout", "isExpended", "plugin-card_release"})
  public final class e
    extends RecyclerView.w
  {
    public TextView oRI;
    public CdnImageView oRJ;
    public TextView oRK;
    public TextView oRL;
    public LinearLayout oRM;
    public LinearLayout oRN;
    public LinearLayout oRO;
    public LinearLayout oRP;
    public TextView oRQ;
    public ImageView oRR;
    public CardLabelTextView oRS;
    public ImageView oRT;
    public TextView oRU;
    public TextView oRV;
    public ImageView oRW;
    public ImageView oRX;
    public TextView oRY;
    public View oRZ;
    CardHomePageNewUI.a oSa;
    
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
        this$1 = paramInt.findViewById(2131298299);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_logo_iv)");
        this.oRJ = ((CdnImageView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298303);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_username_tv)");
        this.oRK = ((TextView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298293);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_desc_tv)");
        this.oRL = ((TextView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298298);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_label_layout)");
        this.oRN = ((LinearLayout)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298292);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_coupon_layout)");
        this.oRO = ((LinearLayout)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298295);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_expand_layout)");
        this.oRP = ((LinearLayout)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298294);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_expand_iv)");
        this.oRR = ((ImageView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298296);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_expand_tv)");
        this.oRQ = ((TextView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298300);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_mch_label_tv)");
        this.oRS = ((CardLabelTextView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298297);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_header_layout)");
        this.oRM = ((LinearLayout)CardHomePageNewUI.this);
        AppMethodBeat.o(112438);
        return;
        this$1 = paramInt.findViewById(2131298301);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_section_title)");
        this.oRI = ((TextView)CardHomePageNewUI.this);
        AppMethodBeat.o(112438);
        return;
        this$1 = paramInt.findViewById(2131298299);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_logo_iv)");
        this.oRJ = ((CdnImageView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298303);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_username_tv)");
        this.oRK = ((TextView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298293);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_desc_tv)");
        this.oRL = ((TextView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298300);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_mch_label_tv)");
        this.oRS = ((CardLabelTextView)CardHomePageNewUI.this);
        AppMethodBeat.o(112438);
        return;
        this$1 = paramInt.findViewById(2131298299);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_logo_iv)");
        this.oRJ = ((CdnImageView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298303);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_username_tv)");
        this.oRK = ((TextView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298293);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_desc_tv)");
        this.oRL = ((TextView)CardHomePageNewUI.this);
        AppMethodBeat.o(112438);
        return;
        this$1 = paramInt.findViewById(2131298332);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_icon_iv)");
        this.oRT = ((ImageView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298336);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_title_tv)");
        this.oRU = ((TextView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298330);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_desc_tv)");
        this.oRV = ((TextView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298335);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_right_iv)");
        this.oRW = ((ImageView)CardHomePageNewUI.this);
        AppMethodBeat.o(112438);
        return;
        this$1 = paramInt.findViewById(2131298332);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_icon_iv)");
        this.oRT = ((ImageView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298336);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_title_tv)");
        this.oRU = ((TextView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298330);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_desc_tv)");
        this.oRV = ((TextView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298335);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_right_iv)");
        this.oRW = ((ImageView)CardHomePageNewUI.this);
        AppMethodBeat.o(112438);
        return;
        this$1 = paramInt.findViewById(2131298332);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_icon_iv)");
        this.oRT = ((ImageView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298336);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_title_tv)");
        this.oRU = ((TextView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298330);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_desc_tv)");
        this.oRV = ((TextView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298335);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_right_iv)");
        this.oRW = ((ImageView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298334);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_reddot_iv)");
        this.oRX = ((ImageView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298333);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_new_tv)");
        this.oRY = ((TextView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298331);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_divider)");
        this.oRZ = CardHomePageNewUI.this;
      }
    }
    
    private final void AT(final int paramInt)
    {
      AppMethodBeat.i(112434);
      Object localObject1 = this.oSa;
      if (localObject1 == null) {
        p.gkB();
      }
      localObject1 = ((CardHomePageNewUI.a)localObject1).oRB;
      if (localObject1 == null) {
        p.gkB();
      }
      if (!bu.isNullOrNil(((sy)localObject1).GiP))
      {
        if (!bu.isNullOrNil(((sy)localObject1).GiQ))
        {
          localObject2 = this.oRQ;
          if (localObject2 == null) {
            p.bdF("chpiExpandTv");
          }
          ((TextView)localObject2).setTextColor(Color.parseColor(((sy)localObject1).GiQ));
        }
        Object localObject2 = this.oRQ;
        if (localObject2 == null) {
          p.bdF("chpiExpandTv");
        }
        ((TextView)localObject2).setText((CharSequence)((sy)localObject1).GiP);
        localObject2 = this.oRR;
        if (localObject2 == null) {
          p.bdF("chpiExpandIv");
        }
        ((ImageView)localObject2).setImageResource(2131231436);
        localObject2 = this.oRP;
        if (localObject2 == null) {
          p.bdF("chpiExpandLayout");
        }
        ((LinearLayout)localObject2).setOnClickListener((View.OnClickListener)new i((sy)localObject1, this, paramInt));
      }
      AppMethodBeat.o(112434);
    }
    
    private final void AU(final int paramInt)
    {
      AppMethodBeat.i(112435);
      Object localObject1 = this.oSa;
      if (localObject1 == null) {
        p.gkB();
      }
      localObject1 = ((CardHomePageNewUI.a)localObject1).oRB;
      Object localObject2 = this.oRQ;
      if (localObject2 == null) {
        p.bdF("chpiExpandTv");
      }
      Resources localResources = ak.getResources();
      if (localObject1 == null) {
        p.gkB();
      }
      ((TextView)localObject2).setText((CharSequence)localResources.getString(2131756876, new Object[] { Integer.valueOf(((sy)localObject1).GiU - ((sy)localObject1).GiV) }));
      localObject2 = this.oRP;
      if (localObject2 == null) {
        p.bdF("chpiExpandLayout");
      }
      ((LinearLayout)localObject2).setOnClickListener((View.OnClickListener)new h(this, paramInt, (sy)localObject1));
      localObject1 = this.oRR;
      if (localObject1 == null) {
        p.bdF("chpiExpandIv");
      }
      ((ImageView)localObject1).setImageResource(2131231497);
      localObject1 = this.oRR;
      if (localObject1 == null) {
        p.bdF("chpiExpandIv");
      }
      ((ImageView)localObject1).setVisibility(0);
      AppMethodBeat.o(112435);
    }
    
    private final void AV(final int paramInt)
    {
      AppMethodBeat.i(112436);
      Object localObject1 = this.oSa;
      if (localObject1 == null) {
        p.gkB();
      }
      localObject1 = ((CardHomePageNewUI.a)localObject1).oRB;
      Object localObject2 = this.oRQ;
      if (localObject2 == null) {
        p.bdF("chpiExpandTv");
      }
      ((TextView)localObject2).setText((CharSequence)ak.getResources().getString(2131756874));
      localObject2 = this.oRP;
      if (localObject2 == null) {
        p.bdF("chpiExpandLayout");
      }
      ((LinearLayout)localObject2).setOnClickListener((View.OnClickListener)new g(this, paramInt, (sy)localObject1));
      localObject1 = this.oRR;
      if (localObject1 == null) {
        p.bdF("chpiExpandIv");
      }
      ((ImageView)localObject1).setImageResource(2131231498);
      localObject1 = this.oRR;
      if (localObject1 == null) {
        p.bdF("chpiExpandIv");
      }
      ((ImageView)localObject1).setVisibility(0);
      AppMethodBeat.o(112436);
    }
    
    private final void B(boolean paramBoolean, int paramInt)
    {
      AppMethodBeat.i(112437);
      Object localObject = this.oSa;
      if (localObject == null) {
        p.gkB();
      }
      localObject = ((CardHomePageNewUI.a)localObject).oRB;
      if (paramBoolean)
      {
        if (localObject != null) {}
        for (localObject = ((sy)localObject).GiP; !bu.isNullOrNil((String)localObject); localObject = null)
        {
          AT(paramInt);
          AppMethodBeat.o(112437);
          return;
        }
        AV(paramInt);
        AppMethodBeat.o(112437);
        return;
      }
      AU(paramInt);
      AppMethodBeat.o(112437);
    }
    
    private final void U(int paramInt1, int paramInt2, final int paramInt3)
    {
      AppMethodBeat.i(112428);
      Object localObject1 = this.oSa;
      if (localObject1 == null) {
        p.gkB();
      }
      localObject1 = ((CardHomePageNewUI.a)localObject1).oRB;
      if (localObject1 == null) {
        p.gkB();
      }
      Object localObject2 = ((sy)localObject1).GiO;
      p.g(localObject2, "el!!.card_element_coupon_list");
      localObject2 = ((Iterable)localObject2).iterator();
      int k = 0;
      int i = 0;
      if (((Iterator)localObject2).hasNext())
      {
        final sv localsv = (sv)((Iterator)localObject2).next();
        int j = i;
        if (k >= paramInt1)
        {
          if (localsv.Gir != 1) {
            break label487;
          }
          localObject3 = this.oRO;
          if (localObject3 == null) {
            p.bdF("chpiCouponLayout");
          }
          localObject3 = LayoutInflater.from(((LinearLayout)localObject3).getContext());
          localLinearLayout = this.oRO;
          if (localLinearLayout == null) {
            p.bdF("chpiCouponLayout");
          }
          localObject3 = ((LayoutInflater)localObject3).inflate(2131493289, (ViewGroup)localLinearLayout, false);
          if (localObject3 == null)
          {
            localObject1 = new v("null cannot be cast to non-null type android.view.ViewGroup");
            AppMethodBeat.o(112428);
            throw ((Throwable)localObject1);
          }
          localObject3 = (ViewGroup)localObject3;
          localObject4 = (TextView)((ViewGroup)localObject3).findViewById(2131298279);
          localObject5 = (CdnImageView)((ViewGroup)localObject3).findViewById(2131298276);
          localObject6 = (TextView)((ViewGroup)localObject3).findViewById(2131298277);
          localLinearLayout = (LinearLayout)((ViewGroup)localObject3).findViewById(2131298278);
          if (!bu.isNullOrNil(localsv.Giu)) {
            ((TextView)localObject4).setTextColor(com.tencent.mm.plugin.card.d.l.cO(localsv.Giu, localsv.Giv));
          }
          p.g(localObject4, "titleTv");
          ((TextView)localObject4).setText((CharSequence)localsv.Gil);
          ((CdnImageView)localObject5).setUrl(localsv.Gis);
          if (!bu.isNullOrNil(localsv.Giw)) {
            ((TextView)localObject6).setTextColor(com.tencent.mm.plugin.card.d.l.cO(localsv.Giw, localsv.Gix));
          }
          p.g(localObject6, "descTv");
          ((TextView)localObject6).setText((CharSequence)localsv.Gim);
          localObject4 = localsv.Giq;
          p.g(localObject4, "coupon.coupon_label");
          localObject4 = (List)localObject4;
          p.g(localLinearLayout, "labelLayout");
          a((List)localObject4, localLinearLayout);
          localLinearLayout = this.oRO;
          if (localLinearLayout == null) {
            p.bdF("chpiCouponLayout");
          }
          ((ViewGroup)localObject3).setOnClickListener((View.OnClickListener)new a(this, (sy)localObject1, localsv, localLinearLayout.getChildCount(), paramInt3));
          dI((View)localObject3);
        }
        label487:
        while (localsv.Gir != 2)
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
        Object localObject3 = this.oRO;
        if (localObject3 == null) {
          p.bdF("chpiCouponLayout");
        }
        localObject3 = LayoutInflater.from(((LinearLayout)localObject3).getContext());
        LinearLayout localLinearLayout = this.oRO;
        if (localLinearLayout == null) {
          p.bdF("chpiCouponLayout");
        }
        localObject3 = ((LayoutInflater)localObject3).inflate(2131493288, (ViewGroup)localLinearLayout, false);
        if (localObject3 == null)
        {
          localObject1 = new v("null cannot be cast to non-null type android.view.ViewGroup");
          AppMethodBeat.o(112428);
          throw ((Throwable)localObject1);
        }
        localObject3 = (ViewGroup)localObject3;
        Object localObject5 = (TextView)((ViewGroup)localObject3).findViewById(2131298279);
        Object localObject6 = (TextView)((ViewGroup)localObject3).findViewById(2131298277);
        localLinearLayout = (LinearLayout)((ViewGroup)localObject3).findViewById(2131298278);
        Object localObject7 = (MemberCardTopCropImageView)((ViewGroup)localObject3).findViewById(2131298274);
        Object localObject4 = (ImageView)((ViewGroup)localObject3).findViewById(2131298275);
        if (!bu.isNullOrNil(localsv.Giu)) {
          ((TextView)localObject5).setTextColor(com.tencent.mm.plugin.card.d.l.cO(localsv.Giu, localsv.Giv));
        }
        p.g(localObject5, "titleTv");
        ((TextView)localObject5).setText((CharSequence)localsv.Gil);
        p.g(localObject6, "descTv");
        ((TextView)localObject6).setText((CharSequence)localsv.Gim);
        p.g(localObject7, "bgIv");
        ((MemberCardTopCropImageView)localObject7).setRadius(com.tencent.mm.cb.a.fromDPToPix(((MemberCardTopCropImageView)localObject7).getContext(), 2));
        if (!bu.isNullOrNil(localsv.Gip))
        {
          localObject5 = (ImageView)localObject7;
          localObject6 = localsv.Gip;
          p.g(localObject6, "coupon.coupon_back_url");
          p.h(localObject5, "imageView");
          p.h(localObject6, "url");
          localObject7 = new c.a();
          ((c.a)localObject7).Gh(com.tencent.mm.loader.j.b.asj());
          ((c.a)localObject7).a(q.aJc());
          ((c.a)localObject7).Gg(m.Zk((String)localObject6));
          ((c.a)localObject7).aJq();
          ((c.a)localObject7).aJt();
          ((c.a)localObject7).aJp();
          ((c.a)localObject7).pK(2131231461);
          ((c.a)localObject7).pJ(com.tencent.mm.cb.a.fromDPToPix(((ImageView)localObject5).getContext(), 84));
          ((c.a)localObject7).pI(com.tencent.mm.cb.a.iu(((ImageView)localObject5).getContext()));
          localObject7 = ((c.a)localObject7).aJu();
          q.aJb().a((String)localObject6, (ImageView)localObject5, (c)localObject7);
          ((ImageView)localObject5).setImageMatrix(new Matrix());
          p.g(localObject4, "shadowBgIv");
          ((ImageView)localObject4).setVisibility(0);
        }
        for (;;)
        {
          localObject4 = localsv.Giq;
          p.g(localObject4, "coupon.coupon_label");
          localObject4 = (List)localObject4;
          p.g(localLinearLayout, "labelLayout");
          a((List)localObject4, localLinearLayout);
          localLinearLayout = this.oRO;
          if (localLinearLayout == null) {
            p.bdF("chpiCouponLayout");
          }
          ((ViewGroup)localObject3).setOnClickListener((View.OnClickListener)new b(this, (sy)localObject1, localsv, localLinearLayout.getChildCount(), paramInt3));
          dI((View)localObject3);
          break;
          if (!bu.isNullOrNil(localsv.Gio))
          {
            ((MemberCardTopCropImageView)localObject7).setImageDrawable((Drawable)new ColorDrawable(Color.parseColor(localsv.Gio)));
            p.g(localObject4, "shadowBgIv");
            ((ImageView)localObject4).setVisibility(0);
          }
        }
      }
      label1081:
      AppMethodBeat.o(112428);
    }
    
    private static void a(ImageView paramImageView, String paramString)
    {
      AppMethodBeat.i(112433);
      p.h(paramImageView, "imageView");
      p.h(paramString, "url");
      Object localObject = new c.a();
      ((c.a)localObject).Gh(com.tencent.mm.loader.j.b.asj());
      ((c.a)localObject).a(q.aJc());
      ((c.a)localObject).Gg(m.Zk(paramString));
      ((c.a)localObject).aJq();
      ((c.a)localObject).aJs();
      ((c.a)localObject).aJt();
      ((c.a)localObject).aJp();
      ((c.a)localObject).pK(2131689865);
      localObject = ((c.a)localObject).aJu();
      q.aJb().a(paramString, paramImageView, (c)localObject);
      AppMethodBeat.o(112433);
    }
    
    private void a(List<? extends su> paramList, LinearLayout paramLinearLayout)
    {
      AppMethodBeat.i(112432);
      p.h(paramList, "couponLabelList");
      p.h(paramLinearLayout, "labelLayout");
      paramList = paramList.iterator();
      if (paramList.hasNext())
      {
        su localsu = (su)paramList.next();
        Object localObject1 = this.oRO;
        if (localObject1 == null) {
          p.bdF("chpiCouponLayout");
        }
        localObject1 = new CardTagTextView(((LinearLayout)localObject1).getContext());
        Object localObject2 = this.oRO;
        if (localObject2 == null) {
          p.bdF("chpiCouponLayout");
        }
        localObject2 = ((LinearLayout)localObject2).getContext();
        ((CardTagTextView)localObject1).setMinHeight(com.tencent.mm.cb.a.fromDPToPix((Context)localObject2, 18));
        ((CardTagTextView)localObject1).setMinWidth(com.tencent.mm.cb.a.fromDPToPix((Context)localObject2, 56));
        int i = com.tencent.mm.cb.a.fromDPToPix((Context)localObject2, 8);
        int j = com.tencent.mm.cb.a.fromDPToPix((Context)localObject2, 4);
        ((CardTagTextView)localObject1).setPadding(i, j, i, j);
        ((CardTagTextView)localObject1).setText((CharSequence)localsu.Gif);
        ((CardTagTextView)localObject1).setTextSize(1, 10.0F);
        if (!bu.isNullOrNil(localsu.Gig))
        {
          ((CardTagTextView)localObject1).setTextColor(Color.parseColor(localsu.Gig));
          label199:
          if (bu.isNullOrNil(localsu.Gih)) {
            break label249;
          }
          ((CardTagTextView)localObject1).setFillColor(com.tencent.mm.plugin.card.d.l.cO(localsu.Gih, localsu.Gik));
        }
        for (;;)
        {
          paramLinearLayout.addView((View)localObject1);
          break;
          ((CardTagTextView)localObject1).setTextColor(-1);
          break label199;
          label249:
          ((CardTagTextView)localObject1).setFillColor(com.tencent.mm.plugin.card.d.l.eW(-16777216, 26));
        }
      }
      AppMethodBeat.o(112432);
    }
    
    private void cH(List<? extends sw> paramList)
    {
      AppMethodBeat.i(112431);
      p.h(paramList, "labelList");
      Object localObject1 = this.oRN;
      if (localObject1 == null) {
        p.bdF("chpiLabelLayout");
      }
      ((LinearLayout)localObject1).removeAllViews();
      if (paramList.isEmpty())
      {
        paramList = this.oRN;
        if (paramList == null) {
          p.bdF("chpiLabelLayout");
        }
        paramList.setVisibility(8);
        AppMethodBeat.o(112431);
        return;
      }
      paramList = ((Iterable)paramList).iterator();
      int i = 0;
      if (paramList.hasNext())
      {
        Object localObject2 = (sw)paramList.next();
        localObject1 = this.oRN;
        if (localObject1 == null) {
          p.bdF("chpiLabelLayout");
        }
        localObject1 = ((LinearLayout)localObject1).getContext();
        p.g(localObject1, "chpiLabelLayout.context");
        localObject1 = new CardLabelTextView((Context)localObject1);
        Object localObject3 = this.oRN;
        if (localObject3 == null) {
          p.bdF("chpiLabelLayout");
        }
        localObject3 = ((LinearLayout)localObject3).getContext();
        ((CardLabelTextView)localObject1).setTextSize(1, 12.0F);
        ((CardLabelTextView)localObject1).setText((CharSequence)((sw)localObject2).GiD);
        int j = com.tencent.mm.cb.a.fromDPToPix((Context)localObject3, 4);
        ((CardLabelTextView)localObject1).setPadding(j, 0, j, 0);
        ((CardLabelTextView)localObject1).setGravity(16);
        if (!bu.isNullOrNil(((sw)localObject2).GiE))
        {
          ((CardLabelTextView)localObject1).setTextColor(Color.parseColor(((sw)localObject2).GiE));
          label240:
          if (bu.isNullOrNil(((sw)localObject2).GiF)) {
            break label359;
          }
          ((CardLabelTextView)localObject1).setFillColor(com.tencent.mm.plugin.card.d.l.cO(((sw)localObject2).GiF, ((sw)localObject2).GiI));
          label269:
          if (i <= 0) {
            break label368;
          }
          localObject2 = new ViewGroup.MarginLayoutParams(-2, -2);
          ((ViewGroup.MarginLayoutParams)localObject2).leftMargin = com.tencent.mm.cb.a.fromDPToPix((Context)localObject3, 4);
          localObject2 = (ViewGroup.MarginLayoutParams)new LinearLayout.LayoutParams((ViewGroup.MarginLayoutParams)localObject2);
          localObject3 = this.oRN;
          if (localObject3 == null) {
            p.bdF("chpiLabelLayout");
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
          localObject2 = this.oRN;
          if (localObject2 == null) {
            p.bdF("chpiLabelLayout");
          }
          ((LinearLayout)localObject2).addView((View)localObject1);
        }
      }
      paramList = this.oRN;
      if (paramList == null) {
        p.bdF("chpiLabelLayout");
      }
      paramList.setVisibility(0);
      AppMethodBeat.o(112431);
    }
    
    private void dI(View paramView)
    {
      AppMethodBeat.i(112430);
      p.h(paramView, "view");
      Object localObject = this.oRO;
      if (localObject == null) {
        p.bdF("chpiCouponLayout");
      }
      if (((LinearLayout)localObject).getChildCount() == 0)
      {
        localObject = this.oRO;
        if (localObject == null) {
          p.bdF("chpiCouponLayout");
        }
        ((LinearLayout)localObject).addView(paramView);
        AppMethodBeat.o(112430);
        return;
      }
      localObject = this.oRO;
      if (localObject == null) {
        p.bdF("chpiCouponLayout");
      }
      localObject = new ViewGroup.MarginLayoutParams(-1, com.tencent.mm.cb.a.fromDPToPix(((LinearLayout)localObject).getContext(), 84));
      LinearLayout localLinearLayout = this.oRO;
      if (localLinearLayout == null) {
        p.bdF("chpiCouponLayout");
      }
      ((ViewGroup.MarginLayoutParams)localObject).topMargin = com.tencent.mm.cb.a.fromDPToPix(localLinearLayout.getContext(), 8);
      localObject = (ViewGroup.MarginLayoutParams)new LinearLayout.LayoutParams((ViewGroup.MarginLayoutParams)localObject);
      localLinearLayout = this.oRO;
      if (localLinearLayout == null) {
        p.bdF("chpiCouponLayout");
      }
      localLinearLayout.addView(paramView, (ViewGroup.LayoutParams)localObject);
      AppMethodBeat.o(112430);
    }
    
    public final void ZI(String paramString)
    {
      AppMethodBeat.i(112429);
      p.h(paramString, "cardId");
      ae.i("MicroMsg.CardHomePageNewUI", "go to card detail: %s", new Object[] { paramString });
      Object localObject = this.auu;
      p.g(localObject, "itemView");
      localObject = new Intent(((View)localObject).getContext(), CardDetailUI.class);
      ((Intent)localObject).putExtra("key_card_id", paramString);
      ((Intent)localObject).addFlags(131072);
      ((Intent)localObject).putExtra("key_from_scene", 3);
      paramString = this.auu;
      p.g(paramString, "itemView");
      paramString = paramString.getContext();
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH", "gotoCardDetailUI", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH", "gotoCardDetailUI", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(112429);
    }
    
    public final void a(final CardHomePageNewUI.a parama, final int paramInt)
    {
      AppMethodBeat.i(112426);
      p.h(parama, "model");
      this.oSa = parama;
      Object localObject1 = parama.oRB;
      switch (parama.type)
      {
      }
      for (;;)
      {
        parama.oRD = true;
        AppMethodBeat.o(112426);
        return;
        if (localObject1 == null) {
          p.gkB();
        }
        Object localObject2 = this.oRJ;
        if (localObject2 == null) {
          p.bdF("chpiLogoIv");
        }
        ((CdnImageView)localObject2).setRoundCorner(true);
        Object localObject3;
        label172:
        int i;
        label511:
        boolean bool;
        if (!bu.isNullOrNil(((sy)localObject1).GiK))
        {
          localObject2 = this.oRJ;
          if (localObject2 == null) {
            p.bdF("chpiLogoIv");
          }
          localObject2 = (ImageView)localObject2;
          localObject3 = ((sy)localObject1).GiK;
          p.g(localObject3, "card_element_mch_icon");
          a((ImageView)localObject2, (String)localObject3);
          localObject2 = (View.OnClickListener)new c((sy)localObject1, this, (sy)localObject1, paramInt, parama);
          localObject3 = this.oRJ;
          if (localObject3 == null) {
            p.bdF("chpiLogoIv");
          }
          ((CdnImageView)localObject3).setOnClickListener((View.OnClickListener)localObject2);
          localObject3 = CardHomePageNewUI.this;
          Object localObject4 = CardHomePageNewUI.this.getContext();
          p.g(localObject4, "context");
          i = ((AppCompatActivity)localObject4).getResources().getColor(2131100711);
          localObject4 = CardHomePageNewUI.this.getContext();
          p.g(localObject4, "context");
          localObject4 = new CardHomePageNewUI.b((CardHomePageNewUI)localObject3, i, ((AppCompatActivity)localObject4).getResources().getColor(2131100913), (com.tencent.mm.pluginsdk.ui.span.i)new CardHomePageNewUI.e.d((View.OnClickListener)localObject2));
          localObject3 = new SpannableString((CharSequence)((sy)localObject1).GiL);
          ((SpannableString)localObject3).setSpan(localObject4, 0, ((SpannableString)localObject3).length(), 18);
          localObject4 = this.oRK;
          if (localObject4 == null) {
            p.bdF("chpiNameTv");
          }
          ((TextView)localObject4).setClickable(true);
          localObject4 = this.oRK;
          if (localObject4 == null) {
            p.bdF("chpiNameTv");
          }
          ((TextView)localObject4).setOnTouchListener((View.OnTouchListener)new n((Context)CardHomePageNewUI.this));
          localObject4 = this.oRK;
          if (localObject4 == null) {
            p.bdF("chpiNameTv");
          }
          ((TextView)localObject4).setText((CharSequence)localObject3);
          if (bu.isNullOrNil(((sy)localObject1).GiM)) {
            break label912;
          }
          localObject3 = this.oRL;
          if (localObject3 == null) {
            p.bdF("chpiDescTv");
          }
          ((TextView)localObject3).setText((CharSequence)((sy)localObject1).GiM);
          localObject3 = this.oRL;
          if (localObject3 == null) {
            p.bdF("chpiDescTv");
          }
          ((TextView)localObject3).setVisibility(0);
          localObject3 = this.oRL;
          if (localObject3 == null) {
            p.bdF("chpiDescTv");
          }
          ((TextView)localObject3).setOnClickListener((View.OnClickListener)localObject2);
          if (((sy)localObject1).GiS == null) {
            break label1030;
          }
          if (bu.isNullOrNil(((sy)localObject1).GiS.GiD)) {
            break label1003;
          }
          localObject2 = this.oRS;
          if (localObject2 == null) {
            p.bdF("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject2).setText((CharSequence)((sy)localObject1).GiS.GiD);
          if (bu.isNullOrNil(((sy)localObject1).GiS.GiE)) {
            break label939;
          }
          localObject2 = this.oRS;
          if (localObject2 == null) {
            p.bdF("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject2).setTextColor(Color.parseColor(((sy)localObject1).GiS.GiE));
          label613:
          if (bu.isNullOrNil(((sy)localObject1).GiS.GiF)) {
            break label977;
          }
          localObject2 = this.oRS;
          if (localObject2 == null) {
            p.bdF("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject2).setFillColor(com.tencent.mm.plugin.card.d.l.cO(((sy)localObject1).GiS.GiF, ((sy)localObject1).GiS.GiI));
          label668:
          localObject2 = this.oRS;
          if (localObject2 == null) {
            p.bdF("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject2).setVisibility(0);
          label691:
          localObject2 = this.oRO;
          if (localObject2 == null) {
            p.bdF("chpiCouponLayout");
          }
          ((LinearLayout)localObject2).removeAllViews();
          if (parama.oRD) {
            break label1091;
          }
          if (((sy)localObject1).GiT != 1) {
            break label1085;
          }
          bool = true;
          label732:
          if (!bool) {
            break label1183;
          }
          localObject2 = ((sy)localObject1).GiO;
          p.g(localObject2, "card_element_coupon_list");
          if (((Collection)localObject2).isEmpty()) {
            break label1100;
          }
          i = 1;
          label767:
          if (i == 0) {
            break label1105;
          }
          U(-1, ((sy)localObject1).GiO.size(), paramInt);
          localObject2 = this.oRO;
          if (localObject2 == null) {
            p.bdF("chpiCouponLayout");
          }
          ((LinearLayout)localObject2).setVisibility(0);
          parama.oRE = true;
          label813:
          if (bu.isNullOrNil(((sy)localObject1).GiP)) {
            break label1132;
          }
          AT(paramInt);
          localObject2 = this.oRP;
          if (localObject2 == null) {
            p.bdF("chpiExpandLayout");
          }
          ((LinearLayout)localObject2).setVisibility(0);
        }
        label912:
        label939:
        label1085:
        label1213:
        for (;;)
        {
          localObject1 = ((sy)localObject1).GiN;
          p.g(localObject1, "card_element_mch_label");
          cH((List)localObject1);
          localObject1 = z.Nhr;
          break;
          localObject2 = this.oRJ;
          if (localObject2 == null) {
            p.bdF("chpiLogoIv");
          }
          ((CdnImageView)localObject2).setImageResource(2131689865);
          break label172;
          localObject2 = this.oRL;
          if (localObject2 == null) {
            p.bdF("chpiDescTv");
          }
          ((TextView)localObject2).setVisibility(8);
          break label511;
          localObject2 = this.oRS;
          if (localObject2 == null) {
            p.bdF("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject2).setTextColor(CardHomePageNewUI.this.getResources().getColor(2131101179));
          break label613;
          label977:
          localObject2 = this.oRS;
          if (localObject2 == null) {
            p.bdF("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject2).setFillColor(0);
          break label668;
          label1003:
          localObject2 = this.oRS;
          if (localObject2 == null) {
            p.bdF("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject2).setVisibility(8);
          break label691;
          localObject2 = this.oRS;
          if (localObject2 == null) {
            p.bdF("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject2).setText((CharSequence)"");
          localObject2 = this.oRS;
          if (localObject2 == null) {
            p.bdF("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject2).setVisibility(8);
          break label691;
          bool = false;
          break label732;
          label1091:
          bool = parama.oRE;
          break label732;
          label1100:
          i = 0;
          break label767;
          label1105:
          localObject2 = this.oRO;
          if (localObject2 == null) {
            p.bdF("chpiCouponLayout");
          }
          ((LinearLayout)localObject2).setVisibility(8);
          break label813;
          label1132:
          if (((sy)localObject1).GiV < ((sy)localObject1).GiO.size())
          {
            AV(paramInt);
          }
          else
          {
            localObject2 = this.oRP;
            if (localObject2 == null) {
              p.bdF("chpiExpandLayout");
            }
            ((LinearLayout)localObject2).setVisibility(8);
            continue;
            localObject2 = ((sy)localObject1).GiO;
            p.g(localObject2, "card_element_coupon_list");
            if (!((Collection)localObject2).isEmpty())
            {
              i = 1;
              if (i == 0) {
                break label1319;
              }
              U(-1, ((sy)localObject1).GiV, paramInt);
              localObject2 = this.oRO;
              if (localObject2 == null) {
                p.bdF("chpiCouponLayout");
              }
              ((LinearLayout)localObject2).setVisibility(0);
              parama.oRE = false;
            }
            for (;;)
            {
              if (((sy)localObject1).GiV >= ((sy)localObject1).GiO.size())
              {
                if (!bu.isNullOrNil(((sy)localObject1).GiP))
                {
                  AT(paramInt);
                  localObject2 = this.oRP;
                  if (localObject2 == null) {
                    p.bdF("chpiExpandLayout");
                  }
                  ((LinearLayout)localObject2).setVisibility(0);
                  break;
                  i = 0;
                  break label1213;
                  localObject2 = this.oRO;
                  if (localObject2 == null) {
                    p.bdF("chpiCouponLayout");
                  }
                  ((LinearLayout)localObject2).setVisibility(8);
                  continue;
                }
                localObject2 = this.oRP;
                if (localObject2 == null) {
                  p.bdF("chpiExpandLayout");
                }
                ((LinearLayout)localObject2).setVisibility(8);
                break;
              }
            }
            AU(paramInt);
            localObject2 = this.oRP;
            if (localObject2 == null) {
              p.bdF("chpiExpandLayout");
            }
            ((LinearLayout)localObject2).setVisibility(0);
          }
        }
        label1030:
        label1183:
        label1319:
        localObject1 = this.oRI;
        if (localObject1 == null) {
          p.bdF("sectionTitleTv");
        }
        ((TextView)localObject1).setText((CharSequence)parama.bZm());
        continue;
        if (localObject1 == null) {
          p.gkB();
        }
        localObject2 = this.oRJ;
        if (localObject2 == null) {
          p.bdF("chpiLogoIv");
        }
        ((CdnImageView)localObject2).setRoundCorner(true);
        localObject2 = this.oRJ;
        if (localObject2 == null) {
          p.bdF("chpiLogoIv");
        }
        ((CdnImageView)localObject2).setUrl(((sy)localObject1).GiK);
        localObject2 = this.oRK;
        if (localObject2 == null) {
          p.bdF("chpiNameTv");
        }
        ((TextView)localObject2).setText((CharSequence)((sy)localObject1).GiL);
        if (!bu.isNullOrNil(((sy)localObject1).GiM))
        {
          localObject2 = this.oRL;
          if (localObject2 == null) {
            p.bdF("chpiDescTv");
          }
          ((TextView)localObject2).setText((CharSequence)((sy)localObject1).GiM);
          localObject2 = this.oRL;
          if (localObject2 == null) {
            p.bdF("chpiDescTv");
          }
          ((TextView)localObject2).setVisibility(0);
          label1588:
          if (((sy)localObject1).GiS == null) {
            break label1894;
          }
          if (bu.isNullOrNil(((sy)localObject1).GiS.GiD)) {
            break label1867;
          }
          localObject2 = this.oRS;
          if (localObject2 == null) {
            p.bdF("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject2).setText((CharSequence)((sy)localObject1).GiS.GiD);
          if (bu.isNullOrNil(((sy)localObject1).GiS.GiE)) {
            break label1803;
          }
          localObject2 = this.oRS;
          if (localObject2 == null) {
            p.bdF("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject2).setTextColor(Color.parseColor(((sy)localObject1).GiS.GiE));
          label1690:
          if (bu.isNullOrNil(((sy)localObject1).GiS.GiF)) {
            break label1841;
          }
          localObject2 = this.oRS;
          if (localObject2 == null) {
            p.bdF("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject2).setFillColor(com.tencent.mm.plugin.card.d.l.cO(((sy)localObject1).GiS.GiF, ((sy)localObject1).GiS.GiI));
          label1745:
          localObject1 = this.oRS;
          if (localObject1 == null) {
            p.bdF("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject1).setVisibility(0);
        }
        for (;;)
        {
          localObject1 = z.Nhr;
          break;
          localObject2 = this.oRL;
          if (localObject2 == null) {
            p.bdF("chpiDescTv");
          }
          ((TextView)localObject2).setVisibility(8);
          break label1588;
          label1803:
          localObject2 = this.oRS;
          if (localObject2 == null) {
            p.bdF("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject2).setTextColor(CardHomePageNewUI.this.getResources().getColor(2131101179));
          break label1690;
          label1841:
          localObject1 = this.oRS;
          if (localObject1 == null) {
            p.bdF("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject1).setFillColor(0);
          break label1745;
          label1867:
          localObject1 = this.oRS;
          if (localObject1 == null) {
            p.bdF("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject1).setVisibility(8);
          continue;
          label1894:
          localObject1 = this.oRS;
          if (localObject1 == null) {
            p.bdF("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject1).setText((CharSequence)"");
          localObject1 = this.oRS;
          if (localObject1 == null) {
            p.bdF("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject1).setVisibility(8);
        }
        localObject1 = this.oRJ;
        if (localObject1 == null) {
          p.bdF("chpiLogoIv");
        }
        ((CdnImageView)localObject1).setRoundCorner(true);
        localObject1 = this.oRJ;
        if (localObject1 == null) {
          p.bdF("chpiLogoIv");
        }
        ((CdnImageView)localObject1).setImageResource(2131689865);
        localObject1 = this.oRK;
        if (localObject1 == null) {
          p.bdF("chpiNameTv");
        }
        ((TextView)localObject1).setText((CharSequence)ak.getResources().getString(2131756877));
        localObject1 = this.oRL;
        if (localObject1 == null) {
          p.bdF("chpiDescTv");
        }
        ((TextView)localObject1).setVisibility(8);
        continue;
        localObject1 = this.oRU;
        if (localObject1 == null) {
          p.bdF("chtiTitleTv");
        }
        ((TextView)localObject1).setText(2131764415);
        if (CardHomePageNewUI.n(CardHomePageNewUI.this) != null)
        {
          localObject1 = this.oRV;
          if (localObject1 == null) {
            p.bdF("chtiDescTv");
          }
          ((TextView)localObject1).setText((CharSequence)CardHomePageNewUI.n(CardHomePageNewUI.this));
          localObject1 = z.Nhr;
          continue;
          localObject1 = this.oRU;
          if (localObject1 == null) {
            p.bdF("chtiTitleTv");
          }
          ((TextView)localObject1).setText(2131756948);
          if (CardHomePageNewUI.o(CardHomePageNewUI.this) == 1)
          {
            localObject1 = this.oRV;
            if (localObject1 == null) {
              p.bdF("chtiDescTv");
            }
            ((TextView)localObject1).setVisibility(0);
            localObject1 = this.oRW;
            if (localObject1 == null) {
              p.bdF("chtiRightIv");
            }
            ((ImageView)localObject1).setVisibility(0);
            localObject1 = CardHomePageNewUI.this.bZi();
            if (localObject1 == null)
            {
              localObject1 = this.oRV;
              if (localObject1 == null) {
                p.bdF("chtiDescTv");
              }
              ((TextView)localObject1).setText((CharSequence)"");
            }
            for (;;)
            {
              localObject1 = this.oRV;
              if (localObject1 == null) {
                p.bdF("chtiDescTv");
              }
              ((TextView)localObject1).setOnClickListener((View.OnClickListener)new e(this));
              localObject1 = this.oRW;
              if (localObject1 == null) {
                p.bdF("chtiRightIv");
              }
              ((ImageView)localObject1).setOnClickListener((View.OnClickListener)new f(this));
              localObject1 = this.oRW;
              if (localObject1 == null) {
                p.bdF("chtiRightIv");
              }
              bu.n((View)localObject1, 50, 50, 50, 50);
              break;
              localObject2 = this.oRV;
              if (localObject2 == null) {
                p.bdF("chtiDescTv");
              }
              ((TextView)localObject2).setText((CharSequence)((tq)localObject1).GjN);
            }
          }
          localObject1 = this.oRV;
          if (localObject1 == null) {
            p.bdF("chtiDescTv");
          }
          ((TextView)localObject1).setVisibility(8);
          localObject1 = this.oRW;
          if (localObject1 == null) {
            p.bdF("chtiRightIv");
          }
          ((ImageView)localObject1).setVisibility(8);
          continue;
          localObject1 = parama.oRF;
          if (localObject1 != null)
          {
            localObject2 = this.oRU;
            if (localObject2 == null) {
              p.bdF("chtiTitleTv");
            }
            ((TextView)localObject2).setText((CharSequence)((td)localObject1).Gjf);
            localObject2 = this.oRV;
            if (localObject2 == null) {
              p.bdF("chtiDescTv");
            }
            ((TextView)localObject2).setText((CharSequence)((td)localObject1).Gjg);
            localObject2 = this.oRT;
            if (localObject2 == null) {
              p.bdF("chtiIconIv");
            }
            localObject3 = ((td)localObject1).Gje;
            p.g(localObject3, "card_top_cell_icon");
            a((ImageView)localObject2, (String)localObject3);
            localObject2 = this.oRY;
            if (localObject2 == null) {
              p.bdF("chtiNewTv");
            }
            if (((td)localObject1).Gjm != 1) {
              break label2659;
            }
            paramInt = 0;
            label2581:
            ((TextView)localObject2).setVisibility(paramInt);
            localObject2 = this.oRX;
            if (localObject2 == null) {
              p.bdF("chtiRedDotIv");
            }
            if (((td)localObject1).Gjl != 1) {
              break label2665;
            }
          }
          label2659:
          label2665:
          for (paramInt = 0;; paramInt = 8)
          {
            ((ImageView)localObject2).setVisibility(paramInt);
            localObject1 = z.Nhr;
            if (!parama.oRG) {
              break label2671;
            }
            localObject1 = this.oRZ;
            if (localObject1 == null) {
              p.bdF("chtiDivider");
            }
            ((View)localObject1).setVisibility(0);
            break;
            paramInt = 8;
            break label2581;
          }
          label2671:
          localObject1 = this.oRZ;
          if (localObject1 == null) {
            p.bdF("chtiDivider");
          }
          ((View)localObject1).setVisibility(8);
        }
      }
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(CardHomePageNewUI.e parame, sy paramsy, sv paramsv, int paramInt1, int paramInt2) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(112417);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$appendCouponView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        CardHomePageNewUI.k(this.oSb.oRH);
        CardHomePageNewUI.a(this.oSb.oRH, 0);
        CardHomePageNewUI.a(this.oSb.oRH, this.oSc);
        paramView = this.oSb;
        localObject = localsv.FKu;
        p.g(localObject, "coupon.user_card_id");
        paramView.ZI((String)localObject);
        com.tencent.mm.plugin.report.service.g.yxI.f(16324, new Object[] { Integer.valueOf(1), this.oSc.GiJ, Integer.valueOf(this.ojd), localsv.FKu, Integer.valueOf(2), Integer.valueOf(paramInt3), Integer.valueOf(CardHomePageNewUI.m(this.oSb.oRH)) });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$appendCouponView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(112417);
      }
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b
      implements View.OnClickListener
    {
      b(CardHomePageNewUI.e parame, sy paramsy, sv paramsv, int paramInt1, int paramInt2) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(112418);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$appendCouponView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        CardHomePageNewUI.k(this.oSb.oRH);
        CardHomePageNewUI.a(this.oSb.oRH, 0);
        CardHomePageNewUI.a(this.oSb.oRH, this.oSc);
        paramView = this.oSb;
        localObject = localsv.FKu;
        p.g(localObject, "coupon.user_card_id");
        paramView.ZI((String)localObject);
        com.tencent.mm.plugin.report.service.g.yxI.f(16324, new Object[] { Integer.valueOf(1), this.oSc.GiJ, Integer.valueOf(this.ojd), localsv.FKu, Integer.valueOf(2), Integer.valueOf(paramInt3), Integer.valueOf(CardHomePageNewUI.m(this.oSb.oRH)) });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$appendCouponView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(112418);
      }
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$setModel$1$headerClickListener$1"})
    static final class c
      implements View.OnClickListener
    {
      c(sy paramsy1, CardHomePageNewUI.e parame, sy paramsy2, int paramInt, CardHomePageNewUI.a parama) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(112419);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$setModel$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        ae.i("MicroMsg.CardHomePageNewUI", "click header");
        CardHomePageNewUI.k(jdField_this.oRH);
        CardHomePageNewUI.a(jdField_this.oRH, 0);
        CardHomePageNewUI.a(jdField_this.oRH, this.oSf);
        switch (this.oSe.Giz)
        {
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.g.yxI.f(16324, new Object[] { Integer.valueOf(1), this.oSe.GiJ, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(paramInt), Integer.valueOf(CardHomePageNewUI.m(jdField_this.oRH)) });
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$setModel$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(112419);
          return;
          paramView = jdField_this.auu;
          p.g(paramView, "itemView");
          paramView = paramView.getContext();
          if (paramView == null)
          {
            paramView = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(112419);
            throw paramView;
          }
          com.tencent.mm.plugin.card.d.b.a((MMActivity)paramView, this.oSe.GiA);
          continue;
          paramView = this.oSe.GiB;
          com.tencent.mm.plugin.card.d.b.I(paramView.CRv, paramView.CRw, paramView.DyO);
        }
      }
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class e
      implements View.OnClickListener
    {
      e(CardHomePageNewUI.e parame) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(112421);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$setModel$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        CardHomePageNewUI.p(this.oSb.oRH);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$setModel$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(112421);
      }
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class f
      implements View.OnClickListener
    {
      f(CardHomePageNewUI.e parame) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(112422);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$setModel$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        CardHomePageNewUI.p(this.oSb.oRH);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$setModel$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(112422);
      }
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class g
      implements View.OnClickListener
    {
      g(CardHomePageNewUI.e parame, int paramInt, sy paramsy) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(112423);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$showCollapseLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        ae.d("MicroMsg.CardHomePageNewUI", "do collapse coupon layout");
        CardHomePageNewUI.e.b(this.oSb, paramInt);
        paramView = this.oSb.oSa;
        if (paramView != null) {
          paramView.oRE = false;
        }
        paramView = com.tencent.mm.plugin.report.service.g.yxI;
        localObject = this.oSc;
        if (localObject == null) {
          p.gkB();
        }
        paramView.f(16324, new Object[] { Integer.valueOf(1), ((sy)localObject).GiJ, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(5), Integer.valueOf(paramInt), Integer.valueOf(CardHomePageNewUI.m(this.oSb.oRH)) });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$showCollapseLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(112423);
      }
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class h
      implements View.OnClickListener
    {
      h(CardHomePageNewUI.e parame, int paramInt, sy paramsy) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(112424);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$showExpandLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        ae.d("MicroMsg.CardHomePageNewUI", "do expand coupon layout");
        CardHomePageNewUI.e.a(this.oSb, paramInt);
        paramView = this.oSb.oSa;
        if (paramView != null) {
          paramView.oRE = true;
        }
        paramView = com.tencent.mm.plugin.report.service.g.yxI;
        localObject = this.oSc;
        if (localObject == null) {
          p.gkB();
        }
        paramView.f(16324, new Object[] { Integer.valueOf(1), ((sy)localObject).GiJ, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(4), Integer.valueOf(paramInt), Integer.valueOf(CardHomePageNewUI.m(this.oSb.oRH)) });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$showExpandLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(112424);
      }
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$showMiniAppLayout$1$1"})
    static final class i
      implements View.OnClickListener
    {
      i(sy paramsy, CardHomePageNewUI.e parame, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(112425);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$showMiniAppLayout$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        if (this.oSe.GiR != null) {
          if (this.oSe.GiR == null) {
            break label266;
          }
        }
        label266:
        for (boolean bool = true;; bool = false)
        {
          ae.i("MicroMsg.CardHomePageNewUI", "detail goto mini app %s", new Object[] { Boolean.valueOf(bool) });
          CardHomePageNewUI.k(jdField_this.oRH);
          CardHomePageNewUI.a(jdField_this.oRH, 0);
          CardHomePageNewUI.a(jdField_this.oRH, this.oSe);
          com.tencent.mm.plugin.card.d.b.I(this.oSe.GiR.CRv, this.oSe.GiR.CRw, this.oSe.GiR.DyO);
          paramView = com.tencent.mm.plugin.report.service.g.yxI;
          localObject = jdField_this.oSa;
          if (localObject == null) {
            p.gkB();
          }
          localObject = ((CardHomePageNewUI.a)localObject).oRB;
          if (localObject == null) {
            p.gkB();
          }
          paramView.f(16324, new Object[] { Integer.valueOf(1), ((sy)localObject).GiJ, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(6), Integer.valueOf(paramInt), Integer.valueOf(CardHomePageNewUI.m(jdField_this.oRH)) });
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$showMiniAppLayout$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(112425);
          return;
        }
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "kotlin.jvm.PlatformType", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/DeleteMchInListResponse;", "call"})
  static final class f<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    f(CardHomePageNewUI paramCardHomePageNewUI, String paramString) {}
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "kotlin.jvm.PlatformType", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetMktCardHomePageResponse;", "call"})
  static final class g<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    g(CardHomePageNewUI paramCardHomePageNewUI) {}
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetCardPkgMchInfoResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class h<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    h(CardHomePageNewUI paramCardHomePageNewUI, String paramString) {}
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$initView$1", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "paint", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "paint2", "getPaint2", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "onDraw", "c", "Landroid/graphics/Canvas;", "plugin-card_release"})
  public static final class i
    extends RecyclerView.h
  {
    private final Paint oSk;
    private final Paint paint;
    
    i()
    {
      AppMethodBeat.i(112446);
      this.paint = new Paint();
      this.oSk = new Paint();
      this.paint.setColor(localObject.getResources().getColor(2131100886));
      this.paint.setStyle(Paint.Style.FILL);
      this.paint.setFlags(1);
      this.oSk.setColor(localObject.getResources().getColor(2131101179));
      this.oSk.setStyle(Paint.Style.FILL);
      this.oSk.setFlags(1);
      AppMethodBeat.o(112446);
    }
    
    public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.t paramt)
    {
      AppMethodBeat.i(112445);
      p.h(paramCanvas, "c");
      p.h(paramRecyclerView, "parent");
      p.h(paramt, "state");
      super.a(paramCanvas, paramRecyclerView, paramt);
      paramRecyclerView = CardHomePageNewUI.j(this.oRH);
      if (paramRecyclerView != null)
      {
        int i = paramRecyclerView.getPaddingLeft();
        paramt = CardHomePageNewUI.oRA;
        int k = i + CardHomePageNewUI.bZl();
        int m = paramRecyclerView.getWidth();
        int n = paramRecyclerView.getPaddingRight();
        int i1 = paramRecyclerView.getChildCount();
        i = 0;
        if (i < i1 - 1)
        {
          paramt = paramRecyclerView.getChildAt(i);
          p.g(paramt, "child");
          Object localObject = paramt.getLayoutParams();
          if (localObject == null)
          {
            paramCanvas = new v("null cannot be cast to non-null type android.support.v7.widget.RecyclerView.LayoutParams");
            AppMethodBeat.o(112445);
            throw paramCanvas;
          }
          localObject = (RecyclerView.LayoutParams)localObject;
          int i2 = paramt.getBottom() + ((RecyclerView.LayoutParams)localObject).bottomMargin;
          if (i == i1 - 1) {
            paramt = CardHomePageNewUI.oRA;
          }
          for (int j = CardHomePageNewUI.bZk();; j = 1)
          {
            j = i2 + j;
            if (paramCanvas != null) {
              paramCanvas.drawRect(k, i2, m - n, j, this.paint);
            }
            if (paramCanvas != null) {
              paramCanvas.drawRect(0.0F, i2, k, j, this.oSk);
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
    
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.t paramt)
    {
      AppMethodBeat.i(112444);
      p.h(paramRect, "outRect");
      p.h(paramView, "view");
      p.h(paramRecyclerView, "parent");
      p.h(paramt, "state");
      super.a(paramRect, paramView, paramRecyclerView, paramt);
      if (RecyclerView.bw(paramView) == CardHomePageNewUI.q(this.oRH).getItemCount() - 1)
      {
        ae.d("MicroMsg.CardHomePageNewUI", "is last");
        paramView = CardHomePageNewUI.oRA;
        paramRect.bottom = CardHomePageNewUI.bZk();
        AppMethodBeat.o(112444);
        return;
      }
      paramRect.bottom = 1;
      AppMethodBeat.o(112444);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "parent", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "kotlin.jvm.PlatformType", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "onLoadMore"})
  static final class j
    implements LoadMoreRecyclerView.a
  {
    j(CardHomePageNewUI paramCardHomePageNewUI) {}
    
    public final void bBz()
    {
      AppMethodBeat.i(112447);
      CardHomePageNewUI.r(this.oRH);
      AppMethodBeat.o(112447);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "parent", "Landroid/support/v7/widget/RecyclerView;", "kotlin.jvm.PlatformType", "view", "Landroid/view/View;", "position", "", "id", "", "onItemClick"})
  static final class k
    implements MRecyclerView.a
  {
    k(CardHomePageNewUI paramCardHomePageNewUI) {}
    
    public final void T(View paramView, int paramInt)
    {
      AppMethodBeat.i(112448);
      paramView = CardHomePageNewUI.q(this.oRH).AS(paramInt);
      if (paramView != null)
      {
        ae.i("MicroMsg.CardHomePageNewUI", "click type: %s", new Object[] { Integer.valueOf(paramView.type) });
        Object localObject2;
        switch (paramView.type)
        {
        case 3: 
        default: 
          AppMethodBeat.o(112448);
          return;
        case 2: 
          CardHomePageNewUI.k(this.oRH);
          CardHomePageNewUI.a(this.oRH, 1);
          CardHomePageNewUI.a(this.oRH, paramView.oRB);
          localObject1 = paramView.oRB;
          if (localObject1 == null) {
            p.gkB();
          }
          switch (((sy)localObject1).Giz)
          {
          }
          for (;;)
          {
            localObject1 = com.tencent.mm.plugin.report.service.g.yxI;
            paramView = paramView.oRB;
            if (paramView == null) {
              p.gkB();
            }
            ((com.tencent.mm.plugin.report.service.g)localObject1).f(16324, new Object[] { Integer.valueOf(2), paramView.GiJ, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(paramInt), Integer.valueOf(CardHomePageNewUI.m(this.oRH)) });
            AppMethodBeat.o(112448);
            return;
            localObject1 = (MMActivity)this.oRH;
            localObject2 = paramView.oRB;
            if (localObject2 == null) {
              p.gkB();
            }
            com.tencent.mm.plugin.card.d.b.a((MMActivity)localObject1, ((sy)localObject2).GiA);
            continue;
            localObject1 = paramView.oRB;
            if (localObject1 == null) {
              p.gkB();
            }
            localObject1 = ((sy)localObject1).GiB;
            com.tencent.mm.plugin.card.d.b.I(((ti)localObject1).CRv, ((ti)localObject1).CRw, ((ti)localObject1).DyO);
          }
        case 4: 
          ae.i("MicroMsg.CardHomePageNewUI", "click ticket item");
          localObject1 = new Intent((Context)this.oRH, CardTicketListUI.class);
          paramView = this.oRH;
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
          com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahE(), "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$initView$3", "onItemClick", "(Landroid/support/v7/widget/RecyclerView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$initView$3", "onItemClick", "(Landroid/support/v7/widget/RecyclerView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.plugin.report.service.g.yxI.f(16322, new Object[] { Integer.valueOf(5) });
          AppMethodBeat.o(112448);
          return;
        case 5: 
          com.tencent.mm.plugin.report.service.g.yxI.f(16322, new Object[] { Integer.valueOf(13) });
          AppMethodBeat.o(112448);
          return;
        }
        Object localObject1 = paramView.oRF;
        if (localObject1 == null) {
          p.gkB();
        }
        switch (((td)localObject1).Gjh)
        {
        }
        for (;;)
        {
          localObject1 = paramView.oRF;
          if (localObject1 == null) {
            p.gkB();
          }
          ((td)localObject1).Gjm = 0;
          paramView = paramView.oRF;
          if (paramView == null) {
            p.gkB();
          }
          paramView.Gjl = 0;
          CardHomePageNewUI.q(this.oRH).cj(paramInt);
          break;
          localObject1 = (MMActivity)this.oRH;
          localObject2 = paramView.oRF;
          if (localObject2 == null) {
            p.gkB();
          }
          com.tencent.mm.plugin.card.d.b.a((MMActivity)localObject1, ((td)localObject2).Gji);
          CardHomePageNewUI.s(this.oRH);
          continue;
          localObject1 = paramView.oRF;
          if (localObject1 == null) {
            p.gkB();
          }
          localObject1 = ((td)localObject1).Gjj;
          com.tencent.mm.plugin.card.d.b.I(((ti)localObject1).CRv, ((ti)localObject1).CRw, ((ti)localObject1).DyO);
          CardHomePageNewUI.s(this.oRH);
          continue;
          localObject1 = new StringBuilder("click native url: ");
          localObject2 = paramView.oRF;
          if (localObject2 == null) {
            p.gkB();
          }
          ae.i("MicroMsg.CardHomePageNewUI", ((td)localObject2).Gjk);
          localObject1 = paramView.oRF;
          if (localObject1 == null) {
            p.gkB();
          }
          if (p.i("weixin://mktcard/cert", ((td)localObject1).Gjk))
          {
            localObject2 = new Intent((Context)this.oRH, CardTicketListUI.class);
            localObject1 = this.oRH;
            localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahE(), "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$initView$3", "onItemClick", "(Landroid/support/v7/widget/RecyclerView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((CardHomePageNewUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mt(0));
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$initView$3", "onItemClick", "(Landroid/support/v7/widget/RecyclerView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            CardHomePageNewUI.s(this.oRH);
          }
        }
      }
      AppMethodBeat.o(112448);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "parent", "Landroid/support/v7/widget/RecyclerView;", "kotlin.jvm.PlatformType", "view", "Landroid/view/View;", "position", "", "id", "", "onItemLongClick"})
  static final class l
    implements MRecyclerView.b
  {
    l(CardHomePageNewUI paramCardHomePageNewUI) {}
    
    public final boolean U(View paramView, final int paramInt)
    {
      AppMethodBeat.i(112452);
      paramView = CardHomePageNewUI.q(this.oRH).AS(paramInt);
      if (paramView != null)
      {
        ae.i("MicroMsg.CardHomePageNewUI", "long click type: %s", new Object[] { Integer.valueOf(paramView.type) });
        switch (paramView.type)
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(112452);
        return false;
        Object localObject = new com.tencent.mm.ui.tools.l((Context)this.oRH.getContext());
        ((com.tencent.mm.ui.tools.l)localObject).a((n.d)new a(this, paramInt));
        ((com.tencent.mm.ui.tools.l)localObject).a((n.e)new b(paramView, this, paramInt));
        ((com.tencent.mm.ui.tools.l)localObject).fOP();
        localObject = com.tencent.mm.plugin.report.service.g.yxI;
        paramView = paramView.oRB;
        if (paramView == null) {
          p.gkB();
        }
        ((com.tencent.mm.plugin.report.service.g)localObject).f(16324, new Object[] { Integer.valueOf(2), paramView.GiJ, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(7), Integer.valueOf(paramInt), Integer.valueOf(CardHomePageNewUI.m(this.oRH)) });
      }
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu", "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$initView$4$1$1"})
    static final class a
      implements n.d
    {
      a(CardHomePageNewUI.l paraml, int paramInt) {}
      
      public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
      {
        AppMethodBeat.i(112449);
        paraml.d(1, (CharSequence)this.oSl.oRH.getString(2131755707));
        AppMethodBeat.o(112449);
      }
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected", "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$initView$4$1$2"})
    static final class b
      implements n.e
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
          h.a((Context)jdField_this.oRH.getContext(), jdField_this.oRH.getString(2131756898), "", false, (DialogInterface.OnClickListener)new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(112450);
              Object localObject1 = this.oSn.oSl.oRH;
              Object localObject2 = this.oSn.oSm.oRB;
              if (localObject2 == null) {
                p.gkB();
              }
              localObject2 = ((sy)localObject2).GiJ;
              p.g(localObject2, "element!!.card_pack_merchant_id");
              p.h(localObject2, "merchantId");
              ae.i("MicroMsg.CardHomePageNewUI", "do delete merchant: %s", new Object[] { localObject2 });
              new com.tencent.mm.plugin.card.model.a.d((String)localObject2).aET().b((com.tencent.mm.vending.c.a)new CardHomePageNewUI.f((CardHomePageNewUI)localObject1, (String)localObject2));
              paramAnonymousDialogInterface.dismiss();
              paramAnonymousDialogInterface = com.tencent.mm.plugin.report.service.g.yxI;
              localObject1 = this.oSn.oSm.oRB;
              if (localObject1 == null) {
                p.gkB();
              }
              paramAnonymousDialogInterface.f(16324, new Object[] { Integer.valueOf(2), ((sy)localObject1).GiJ, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(9), Integer.valueOf(this.oSn.mRW), Integer.valueOf(CardHomePageNewUI.m(this.oSn.oSl.oRH)) });
              AppMethodBeat.o(112450);
            }
          });
          paramMenuItem = com.tencent.mm.plugin.report.service.g.yxI;
          sy localsy = this.oSm.oRB;
          if (localsy == null) {
            p.gkB();
          }
          paramMenuItem.f(16324, new Object[] { Integer.valueOf(2), localsy.GiJ, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(8), Integer.valueOf(paramInt), Integer.valueOf(CardHomePageNewUI.m(jdField_this.oRH)) });
        }
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class m
    implements MenuItem.OnMenuItemClickListener
  {
    m(CardHomePageNewUI paramCardHomePageNewUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(112453);
      this.oRH.finish();
      AppMethodBeat.o(112453);
      return false;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick", "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$setFaqIconMenu$1$1"})
  static final class n
    implements MenuItem.OnMenuItemClickListener
  {
    n(sz paramsz, CardHomePageNewUI paramCardHomePageNewUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(112456);
      paramMenuItem = new com.tencent.mm.ui.widget.a.e((Context)jdField_this.getContext(), 1, false);
      paramMenuItem.a((n.d)new n.d()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
        {
          AppMethodBeat.i(112454);
          paramAnonymousl.add(0, 0, 1, (CharSequence)this.oSp.oSo.GiX);
          AppMethodBeat.o(112454);
        }
      });
      paramMenuItem.a((n.e)new n.e()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(112455);
          p.g(paramAnonymousMenuItem, "menuItem");
          if (paramAnonymousMenuItem.getItemId() == 0) {
            switch (this.oSp.oSo.GiY)
            {
            }
          }
          for (;;)
          {
            AppMethodBeat.o(112455);
            return;
            com.tencent.mm.plugin.card.d.b.a((MMActivity)this.oSp.oRH, this.oSp.oSo.GiZ);
            AppMethodBeat.o(112455);
            return;
            paramAnonymousMenuItem = this.oSp.oSo.Gja;
            com.tencent.mm.plugin.card.d.b.I(paramAnonymousMenuItem.CRv, paramAnonymousMenuItem.CRw, paramAnonymousMenuItem.DyO);
          }
        }
      });
      paramMenuItem.cPF();
      AppMethodBeat.o(112456);
      return false;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu", "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$showSortSheet$1$1"})
  static final class o
    implements n.d
  {
    o(CardHomePageNewUI paramCardHomePageNewUI) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
    {
      AppMethodBeat.i(112457);
      Iterator localIterator = ((Iterable)CardHomePageNewUI.y(this.oRH)).iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        paraml.add(0, i, 1, (CharSequence)((tq)localIterator.next()).GjN);
        i += 1;
      }
      AppMethodBeat.o(112457);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected", "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$showSortSheet$1$2"})
  static final class p
    implements n.e
  {
    p(CardHomePageNewUI paramCardHomePageNewUI) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(112459);
      p.g(paramMenuItem, "menuItem");
      paramInt = paramMenuItem.getItemId();
      ae.i("MicroMsg.CardHomePageNewUI", "click item: %s, sortType: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(CardHomePageNewUI.m(this.oRH)) });
      paramMenuItem = CardHomePageNewUI.y(this.oRH).get(paramInt);
      p.g(paramMenuItem, "cardSortInfoList[itemId]");
      paramMenuItem = (tq)paramMenuItem;
      CardHomePageNewUI.d(this.oRH, paramMenuItem.GjM);
      if ((paramMenuItem.GjL == 1) && (CardHomePageNewUI.m(this.oRH) != 1))
      {
        if (!this.oRH.oSD)
        {
          h.a((Context)this.oRH.getContext(), this.oRH.getString(2131756893), this.oRH.getString(2131761885), this.oRH.getString(2131760598), this.oRH.getString(2131757558), false, (DialogInterface.OnClickListener)new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(112458);
              this.oSq.oRH.startActivityForResult(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"), 564);
              AppMethodBeat.o(112458);
            }
          }, null);
          AppMethodBeat.o(112459);
          return;
        }
        CardHomePageNewUI.b(this.oRH, true);
        CardHomePageNewUI.c(this.oRH, 0);
        CardHomePageNewUI.b(this.oRH, 1);
        CardHomePageNewUI.r(this.oRH);
        com.tencent.mm.plugin.report.service.g.yxI.f(16322, new Object[] { Integer.valueOf(15) });
        AppMethodBeat.o(112459);
        return;
      }
      if ((paramMenuItem.GjL == 2) && (CardHomePageNewUI.m(this.oRH) != 2))
      {
        CardHomePageNewUI.b(this.oRH, true);
        CardHomePageNewUI.c(this.oRH, 0);
        CardHomePageNewUI.b(this.oRH, 2);
        CardHomePageNewUI.r(this.oRH);
        com.tencent.mm.plugin.report.service.g.yxI.f(16322, new Object[] { Integer.valueOf(16) });
        AppMethodBeat.o(112459);
        return;
      }
      if ((paramMenuItem.GjL == 3) && (CardHomePageNewUI.m(this.oRH) != 3))
      {
        CardHomePageNewUI.b(this.oRH, true);
        CardHomePageNewUI.c(this.oRH, 0);
        CardHomePageNewUI.b(this.oRH, 3);
        CardHomePageNewUI.r(this.oRH);
        com.tencent.mm.plugin.report.service.g.yxI.f(16322, new Object[] { Integer.valueOf(17) });
      }
      AppMethodBeat.o(112459);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v2.CardHomePageNewUI
 * JD-Core Version:    0.7.0.1
 */