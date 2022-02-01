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
import com.tencent.mm.av.o;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView.a;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.a;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.b;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.plugin.card.ui.CardDetailUI;
import com.tencent.mm.plugin.card.widget.CardTagTextView;
import com.tencent.mm.plugin.card.widget.MemberCardTopCropImageView;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.n;
import com.tencent.mm.protocal.protobuf.qz;
import com.tencent.mm.protocal.protobuf.ra;
import com.tencent.mm.protocal.protobuf.rb;
import com.tencent.mm.protocal.protobuf.rc;
import com.tencent.mm.protocal.protobuf.rd;
import com.tencent.mm.protocal.protobuf.rg;
import com.tencent.mm.protocal.protobuf.rh;
import com.tencent.mm.protocal.protobuf.rj;
import com.tencent.mm.protocal.protobuf.rk;
import com.tencent.mm.protocal.protobuf.rm;
import com.tencent.mm.protocal.protobuf.ru;
import com.tencent.mm.protocal.protobuf.rv;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import d.v;
import d.y;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.kernel.i
@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI;", "Lcom/tencent/mm/plugin/card/ui/v2/CardNewBaseUI;", "()V", "cardSortInfoList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/CardSortInfo;", "Lkotlin/collections/ArrayList;", "cardTitleModel", "Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$CardListModel;", "clickArea", "", "clickedCardHomePageElement", "Lcom/tencent/mm/protocal/protobuf/CardHomePageElement;", "emptyModel", "faqItem", "Lcom/tencent/mm/protocal/protobuf/CardHomePageFAQItem;", "firstLoad", "", "getCardHomePageScene", "Lcom/tencent/mm/plugin/card/model/v2/CgiGetMktCardHomePage;", "isAll", "isGotoItem", "isLoading", "mDivider", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "mHomePageAdapter", "Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageAdapter;", "mLoadingView", "Landroid/view/ViewGroup;", "mLoadingView2", "mRecyclerView", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "markReloadHomePage", "needReloadHomePage", "offset", "reqNum", "scene", "shouldShowTicket", "showSort", "sortType", "storeModelList", "ticketModel", "ticketNum", "", "tipsDialog", "Landroid/app/Dialog;", "titleSectionModel", "topCellList", "underModelList", "cardSortInfo", "doDeleteMchInList", "", "merchantId", "doGetCardHomePage", "doGetMchInfo", "lastReceiveTime", "", "getLayoutId", "initFirstScreen", "initView", "loadSnapshot", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinishLocationThings", "ret", "isLocationOk", "onResume", "saveSnapshot", "setFaqIconMenu", "showSortSheet", "updateModelList", "storePageList", "Lcom/tencent/mm/protocal/protobuf/CardHomePageStoreList;", "underPageList", "Lcom/tencent/mm/protocal/protobuf/CardHomePageUnderList;", "_topCellList", "Lcom/tencent/mm/protocal/protobuf/CardHomePageTopCellList;", "CardListModel", "CardSpan", "Companion", "HomePageAdapter", "HomePageVH", "plugin-card_release"})
public final class CardHomePageNewUI
  extends CardNewBaseUI
{
  private static final int cPg;
  private static final int gPI;
  private static final int ohD;
  public static final CardHomePageNewUI.c ohE;
  private boolean fPJ;
  private Dialog iBT;
  private boolean isLoading;
  private int nXP;
  private int offset;
  private rc ohA;
  private boolean ohB;
  private com.tencent.mm.plugin.card.model.a.g ohC;
  private LoadMoreRecyclerView ohe;
  private d ohf;
  private ViewGroup ohg;
  private RecyclerView.h ohh;
  private ViewGroup ohi;
  private int ohj;
  private boolean ohk;
  private String ohl;
  private final ArrayList<a> ohm;
  private final ArrayList<a> ohn;
  private final ArrayList<a> oho;
  private a ohp;
  private a ohq;
  private a ohr;
  private a ohs;
  private boolean oht;
  private int ohu;
  private boolean ohv;
  private int ohw;
  private ArrayList<ru> ohx;
  private boolean ohy;
  private rd ohz;
  private int scene;
  
  static
  {
    AppMethodBeat.i(112470);
    ohE = new CardHomePageNewUI.c((byte)0);
    cPg = com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 40);
    gPI = com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 1);
    ohD = com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 16);
    AppMethodBeat.o(112470);
  }
  
  public CardHomePageNewUI()
  {
    AppMethodBeat.i(112469);
    this.ohj = 10;
    this.ohl = "";
    this.ohm = new ArrayList();
    this.ohn = new ArrayList();
    this.oho = new ArrayList();
    this.fPJ = true;
    this.ohu = -1;
    this.ohv = true;
    this.ohx = new ArrayList();
    this.ohz = new rd();
    AppMethodBeat.o(112469);
  }
  
  private final void bTp()
  {
    AppMethodBeat.i(112468);
    ac.i("MicroMsg.CardHomePageNewUI", "do get card Home page: %s, %s", new Object[] { Boolean.valueOf(this.ohk), Boolean.valueOf(this.isLoading) });
    Object localObject;
    if ((this.ohB) || ((!this.ohk) && (!this.isLoading)))
    {
      this.isLoading = true;
      if (this.ohB)
      {
        localObject = this.ohi;
        if (localObject == null) {
          d.g.b.k.aVY("mLoadingView2");
        }
        ((ViewGroup)localObject).setVisibility(0);
        if (this.ohr != null)
        {
          localObject = this.ohi;
          if (localObject == null) {
            d.g.b.k.aVY("mLoadingView2");
          }
          localObject = ((ViewGroup)localObject).getLayoutParams();
          if (localObject == null)
          {
            localObject = new v("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            AppMethodBeat.o(112468);
            throw ((Throwable)localObject);
          }
          localObject = (RelativeLayout.LayoutParams)localObject;
          ((RelativeLayout.LayoutParams)localObject).topMargin = com.tencent.mm.cc.a.fromDPToPix((Context)getContext(), 80);
          ViewGroup localViewGroup = this.ohi;
          if (localViewGroup == null) {
            d.g.b.k.aVY("mLoadingView2");
          }
          localViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
      localObject = bTo();
      if (localObject == null) {
        break label358;
      }
    }
    label358:
    for (int i = ((ru)localObject).Eke;; i = 10)
    {
      this.ohj = i;
      if (this.iBT != null)
      {
        localObject = this.iBT;
        if (localObject == null) {
          d.g.b.k.fOy();
        }
        ((Dialog)localObject).dismiss();
      }
      if (this.ohn.isEmpty())
      {
        localObject = (Context)getContext();
        getContext().getString(2131755726);
        this.iBT = ((Dialog)com.tencent.mm.ui.base.h.b((Context)localObject, getContext().getString(2131760709), true, null));
      }
      this.ohC = new com.tencent.mm.plugin.card.model.a.g(this.offset, this.ohj, this.dmL, this.doB, this.nXP);
      localObject = this.ohC;
      if (localObject == null) {
        d.g.b.k.fOy();
      }
      ((com.tencent.mm.plugin.card.model.a.g)localObject).aBB().b((com.tencent.mm.vending.c.a)new g(this)).a((com.tencent.mm.vending.e.b)this);
      AppMethodBeat.o(112468);
      return;
    }
  }
  
  public final void V(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(112465);
    ac.i("MicroMsg.CardHomePageNewUI", "location finish: [%s, %s], ret: %s, isOk: %s", new Object[] { Float.valueOf(this.dmL), Float.valueOf(this.doB), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    if (this.fPJ)
    {
      if ((this.ohw == 1) && (paramInt < 0) && (this.nXP == 1))
      {
        this.nXP = 0;
        if (paramInt == -2) {
          com.tencent.mm.plugin.report.service.h.wUl.f(16322, new Object[] { Integer.valueOf(30) });
        }
      }
      bTp();
      AppMethodBeat.o(112465);
      return;
    }
    if (!paramBoolean) {
      bTy();
    }
    AppMethodBeat.o(112465);
  }
  
  public final void a(rg paramrg, rk paramrk, rj paramrj)
  {
    int j = 0;
    AppMethodBeat.i(112467);
    Object localObject;
    int i;
    if (paramrg != null)
    {
      localObject = paramrg.Eju;
      d.g.b.k.g(localObject, "card_home_page_element");
      if (!((Collection)localObject).isEmpty()) {}
      for (i = 1; i != 0; i = 0)
      {
        paramrg = paramrg.Eju.iterator();
        while (paramrg.hasNext())
        {
          localObject = (rc)paramrg.next();
          a locala = new a();
          locala.ohF = ((rc)localObject);
          locala.type = 0;
          this.ohn.add(locala);
        }
      }
    }
    if (paramrk != null)
    {
      paramrg = paramrk.Eju;
      d.g.b.k.g(paramrg, "card_home_page_element");
      if (!((Collection)paramrg).isEmpty()) {}
      for (i = 1; i != 0; i = 0)
      {
        if (bs.isNullOrNil(paramrk.EjG)) {
          paramrk.EjG = getString(2131756875);
        }
        if (this.ohq == null)
        {
          this.ohq = new a();
          paramrg = this.ohq;
          if (paramrg == null) {
            d.g.b.k.fOy();
          }
          paramrg.type = 1;
        }
        paramrg = this.ohq;
        if (paramrg == null) {
          d.g.b.k.fOy();
        }
        localObject = paramrk.EjG;
        d.g.b.k.g(localObject, "section_title");
        paramrg.Vf((String)localObject);
        paramrg = paramrk.Eju.iterator();
        while (paramrg.hasNext())
        {
          paramrk = (rc)paramrg.next();
          localObject = new a();
          ((a)localObject).ohF = paramrk;
          ((a)localObject).type = 2;
          this.oho.add(localObject);
        }
      }
    }
    if (paramrj != null)
    {
      paramrg = paramrj.EjF;
      d.g.b.k.g(paramrg, "card_home_page_top_cell");
      if (!((Collection)paramrg).isEmpty()) {}
      for (i = 1; i != 0; i = 0)
      {
        paramrg = paramrj.EjF;
        d.g.b.k.g(paramrg, "card_home_page_top_cell");
        paramrg = ((Iterable)paramrg).iterator();
        i = 0;
        while (paramrg.hasNext())
        {
          paramrk = (rh)paramrg.next();
          localObject = new a();
          ((a)localObject).ohJ = paramrk;
          ((a)localObject).type = 6;
          if (i == paramrj.EjF.size() - 1) {
            ((a)localObject).ohK = true;
          }
          this.ohm.add(localObject);
          i += 1;
        }
      }
    }
    this.ohs = new a();
    paramrg = this.ohs;
    if (paramrg == null) {
      d.g.b.k.fOy();
    }
    paramrg.type = 5;
    if ((this.ohn.isEmpty()) && (this.oho.isEmpty()))
    {
      i = j;
      if (!((Collection)this.ohm).isEmpty()) {
        i = 1;
      }
      if (i != 0)
      {
        this.ohp = new a();
        paramrg = this.ohp;
        if (paramrg == null) {
          d.g.b.k.fOy();
        }
        paramrg.type = 7;
        AppMethodBeat.o(112467);
        return;
      }
    }
    this.ohp = null;
    AppMethodBeat.o(112467);
  }
  
  public final void bTn()
  {
    AppMethodBeat.i(112461);
    rd localrd = this.ohz;
    if (localrd != null)
    {
      if (!bs.isNullOrNil(localrd.Ejo))
      {
        removeAllOptionMenu();
        addIconOptionMenu(0, 0, 2131690603, (MenuItem.OnMenuItemClickListener)new n(localrd, this));
      }
      AppMethodBeat.o(112461);
      return;
    }
    AppMethodBeat.o(112461);
  }
  
  public final ru bTo()
  {
    AppMethodBeat.i(112466);
    Iterator localIterator = this.ohx.iterator();
    while (localIterator.hasNext())
    {
      ru localru = (ru)localIterator.next();
      if (localru.Ekd == this.nXP)
      {
        AppMethodBeat.o(112466);
        return localru;
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
    d.g.b.k.g(localObject1, "findViewById(R.id.chpu_rv)");
    this.ohe = ((LoadMoreRecyclerView)localObject1);
    localObject1 = this.ohe;
    if (localObject1 == null) {
      d.g.b.k.aVY("mRecyclerView");
    }
    getContext();
    ((LoadMoreRecyclerView)localObject1).setLayoutManager((RecyclerView.i)new LinearLayoutManager());
    this.ohf = new d();
    localObject1 = this.ohe;
    if (localObject1 == null) {
      d.g.b.k.aVY("mRecyclerView");
    }
    Object localObject2 = this.ohf;
    if (localObject2 == null) {
      d.g.b.k.aVY("mHomePageAdapter");
    }
    ((LoadMoreRecyclerView)localObject1).setAdapter((RecyclerView.a)localObject2);
    localObject1 = LayoutInflater.from((Context)this);
    localObject2 = this.ohe;
    if (localObject2 == null) {
      d.g.b.k.aVY("mRecyclerView");
    }
    localObject1 = ((LayoutInflater)localObject1).inflate(2131493294, (ViewGroup)localObject2, false);
    if (localObject1 == null)
    {
      localObject1 = new v("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(112464);
      throw ((Throwable)localObject1);
    }
    this.ohg = ((ViewGroup)localObject1);
    localObject1 = findViewById(2131298312);
    d.g.b.k.g(localObject1, "findViewById(R.id.chpu_loading_layout)");
    this.ohi = ((ViewGroup)localObject1);
    localObject1 = this.ohe;
    if (localObject1 == null) {
      d.g.b.k.aVY("mRecyclerView");
    }
    localObject2 = this.ohg;
    if (localObject2 == null) {
      d.g.b.k.aVY("mLoadingView");
    }
    ((LoadMoreRecyclerView)localObject1).setLoadingView((View)localObject2);
    this.ohh = ((RecyclerView.h)new i(this));
    localObject1 = this.ohe;
    if (localObject1 == null) {
      d.g.b.k.aVY("mRecyclerView");
    }
    localObject2 = this.ohh;
    if (localObject2 == null) {
      d.g.b.k.aVY("mDivider");
    }
    ((LoadMoreRecyclerView)localObject1).b((RecyclerView.h)localObject2);
    localObject1 = this.ohe;
    if (localObject1 == null) {
      d.g.b.k.aVY("mRecyclerView");
    }
    ((LoadMoreRecyclerView)localObject1).setOnLoadingStateChangedListener((LoadMoreRecyclerView.a)new j(this));
    localObject1 = this.ohe;
    if (localObject1 == null) {
      d.g.b.k.aVY("mRecyclerView");
    }
    ((LoadMoreRecyclerView)localObject1).setOnItemClickListener((MRecyclerView.a)new k(this));
    localObject1 = this.ohe;
    if (localObject1 == null) {
      d.g.b.k.aVY("mRecyclerView");
    }
    ((LoadMoreRecyclerView)localObject1).setOnItemLongClickListener((MRecyclerView.b)new l(this));
    localObject1 = new rg();
    localObject2 = new rk();
    rj localrj = new rj();
    rv localrv = new rv();
    Object localObject3 = com.tencent.mm.plugin.card.model.a.a.nXE;
    localObject3 = this.ohz;
    d.g.b.k.h(localObject1, "storeList");
    d.g.b.k.h(localObject2, "underList");
    d.g.b.k.h(localrj, "topList");
    d.g.b.k.h(localrv, "cardSortInfoList");
    ac.i(com.tencent.mm.plugin.card.model.a.a.access$getTAG$cp(), "load home page snapshot");
    Object localObject4 = com.tencent.mm.kernel.g.agR();
    d.g.b.k.g(localObject4, "MMKernel.storage()");
    localObject4 = (String)((com.tencent.mm.kernel.e)localObject4).agA().i(ah.a.GSc);
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
      d.g.b.k.g(localObject4, "(this as java.lang.String).getBytes(charset)");
      ((rg)localObject1).parseFrom((byte[])localObject4);
      i = 1;
    }
    localObject4 = com.tencent.mm.kernel.g.agR();
    d.g.b.k.g(localObject4, "MMKernel.storage()");
    localObject4 = (String)((com.tencent.mm.kernel.e)localObject4).agA().i(ah.a.GSd);
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
      d.g.b.k.g(localObject4, "(this as java.lang.String).getBytes(charset)");
      ((rk)localObject2).parseFrom((byte[])localObject4);
      i = 1;
    }
    localObject4 = com.tencent.mm.kernel.g.agR();
    d.g.b.k.g(localObject4, "MMKernel.storage()");
    localObject4 = (String)((com.tencent.mm.kernel.e)localObject4).agA().i(ah.a.GSe);
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
      d.g.b.k.g(localObject4, "(this as java.lang.String).getBytes(charset)");
      localrj.parseFrom((byte[])localObject4);
      i = 1;
    }
    localObject4 = com.tencent.mm.kernel.g.agR();
    d.g.b.k.g(localObject4, "MMKernel.storage()");
    localObject4 = (String)((com.tencent.mm.kernel.e)localObject4).agA().i(ah.a.GSf);
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
      d.g.b.k.g(localObject4, "(this as java.lang.String).getBytes(charset)");
      localrv.parseFrom((byte[])localObject4);
      i = 1;
    }
    localObject4 = com.tencent.mm.kernel.g.agR();
    d.g.b.k.g(localObject4, "MMKernel.storage()");
    localObject4 = (String)((com.tencent.mm.kernel.e)localObject4).agA().i(ah.a.GSg);
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
        d.g.b.k.g(localObject4, "(this as java.lang.String).getBytes(charset)");
        ((rd)localObject3).parseFrom((byte[])localObject4);
        i = j;
      }
    }
    for (;;)
    {
      this.ohx.clear();
      this.ohx.addAll((Collection)localrv.Ekg);
      a((rg)localObject1, (rk)localObject2, localrj);
      if ((i == 0) && (this.ohn.isEmpty()) && (this.oho.isEmpty()))
      {
        ac.i("MicroMsg.CardHomePageNewUI", "show init view");
        localObject1 = new a();
        ((a)localObject1).type = 3;
        localObject2 = new a();
        ((a)localObject2).type = 3;
        this.ohn.add(localObject1);
        this.ohn.add(localObject2);
      }
      bTn();
      localObject1 = this.ohe;
      if (localObject1 == null) {
        d.g.b.k.aVY("mRecyclerView");
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
    this.ohw = 1;
    paramBundle = com.tencent.mm.kernel.g.agR();
    d.g.b.k.g(paramBundle, "MMKernel.storage()");
    this.nXP = paramBundle.agA().getInt(ah.a.GSt, 1);
    if (this.nXP == 0) {
      this.nXP = 1;
    }
    if (this.ohw == 1) {
      com.tencent.mm.plugin.report.service.h.wUl.f(16322, new Object[] { Integer.valueOf(14) });
    }
    ac.i("MicroMsg.CardHomePageNewUI", "on create, scene: %s", new Object[] { Integer.valueOf(this.scene) });
    setBackBtn((MenuItem.OnMenuItemClickListener)new m(this));
    com.tencent.mm.plugin.report.service.h.wUl.f(16322, new Object[] { Integer.valueOf(4) });
    ((com.tencent.mm.pluginsdk.wallet.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.b.class)).gm(8, 2);
    AppMethodBeat.o(112460);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(112462);
    super.onDestroy();
    Object localObject1 = com.tencent.mm.kernel.g.agR();
    d.g.b.k.g(localObject1, "MMKernel.storage()");
    ((com.tencent.mm.kernel.e)localObject1).agA().set(ah.a.GSt, Integer.valueOf(this.nXP));
    if (this.ohC != null)
    {
      localObject1 = this.ohC;
      if (localObject1 == null) {
        d.g.b.k.fOy();
      }
      ((com.tencent.mm.plugin.card.model.a.g)localObject1).cancel();
      this.ohC = null;
    }
    com.tencent.mm.plugin.card.b.k.bPX();
    ac.i("MicroMsg.CardHomePageNewUI", "do save snap shot");
    Object localObject3 = new rg();
    ((rg)localObject3).Eju = new LinkedList();
    localObject1 = this.ohn.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((a)((Iterator)localObject1).next()).ohF;
      if (localObject2 != null) {
        ((rg)localObject3).Eju.add(localObject2);
      }
    }
    Object localObject2 = new rk();
    localObject1 = this.ohq;
    if (localObject1 != null) {}
    for (localObject1 = ((a)localObject1).bTs();; localObject1 = null)
    {
      ((rk)localObject2).EjG = ((String)localObject1);
      ((rk)localObject2).Eju = new LinkedList();
      localObject1 = this.oho.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject4 = ((a)((Iterator)localObject1).next()).ohF;
        if (localObject4 != null) {
          ((rk)localObject2).Eju.add(localObject4);
        }
      }
    }
    rj localrj = new rj();
    localObject1 = this.ohm.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject4 = ((a)((Iterator)localObject1).next()).ohJ;
      if (localObject4 != null) {
        localrj.EjF.add(localObject4);
      }
    }
    Object localObject4 = new rv();
    ((rv)localObject4).Ekg.addAll((Collection)this.ohx);
    localObject1 = com.tencent.mm.plugin.card.model.a.a.nXE;
    localObject1 = this.ohz;
    d.g.b.k.h(localObject3, "storeList");
    d.g.b.k.h(localObject2, "underList");
    d.g.b.k.h(localrj, "topList");
    d.g.b.k.h(localObject4, "sortInfoList");
    ac.i(com.tencent.mm.plugin.card.model.a.a.access$getTAG$cp(), "save home page snapshot");
    localObject3 = ((rg)localObject3).toByteArray();
    d.g.b.k.g(localObject3, "storeList.toByteArray()");
    localObject3 = new String((byte[])localObject3, d.n.d.ISO_8859_1);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.agR();
    d.g.b.k.g(locale, "MMKernel.storage()");
    locale.agA().set(ah.a.GSc, localObject3);
    localObject2 = ((rk)localObject2).toByteArray();
    d.g.b.k.g(localObject2, "underList.toByteArray()");
    localObject2 = new String((byte[])localObject2, d.n.d.ISO_8859_1);
    localObject3 = com.tencent.mm.kernel.g.agR();
    d.g.b.k.g(localObject3, "MMKernel.storage()");
    ((com.tencent.mm.kernel.e)localObject3).agA().set(ah.a.GSd, localObject2);
    localObject2 = localrj.toByteArray();
    d.g.b.k.g(localObject2, "topList.toByteArray()");
    localObject2 = new String((byte[])localObject2, d.n.d.ISO_8859_1);
    localObject3 = com.tencent.mm.kernel.g.agR();
    d.g.b.k.g(localObject3, "MMKernel.storage()");
    ((com.tencent.mm.kernel.e)localObject3).agA().set(ah.a.GSe, localObject2);
    localObject2 = ((rv)localObject4).toByteArray();
    d.g.b.k.g(localObject2, "sortInfoList.toByteArray()");
    localObject2 = new String((byte[])localObject2, d.n.d.ISO_8859_1);
    localObject3 = com.tencent.mm.kernel.g.agR();
    d.g.b.k.g(localObject3, "MMKernel.storage()");
    ((com.tencent.mm.kernel.e)localObject3).agA().set(ah.a.GSf, localObject2);
    if (localObject1 != null)
    {
      localObject1 = ((rd)localObject1).toByteArray();
      d.g.b.k.g(localObject1, "faqItem.toByteArray()");
      localObject1 = new String((byte[])localObject1, d.n.d.ISO_8859_1);
      localObject2 = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(localObject2, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject2).agA().set(ah.a.GSg, localObject1);
    }
    AppMethodBeat.o(112462);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(112463);
    super.onResume();
    if ((this.oht) && (this.ohA != null) && (this.ohu != -1))
    {
      Object localObject = this.ohA;
      if (localObject == null) {
        d.g.b.k.fOy();
      }
      localObject = ((rc)localObject).Eja;
      d.g.b.k.g(localObject, "clickedCardHomePageElement!!.card_pack_merchant_id");
      rc localrc = this.ohA;
      if (localrc == null) {
        d.g.b.k.fOy();
      }
      long l = localrc.Ejn;
      ac.i("MicroMsg.CardHomePageNewUI", "do get mch infoset: %s", new Object[] { localObject });
      new com.tencent.mm.plugin.card.model.a.f((String)localObject, l, this.dmL, this.doB, this.nXP).aBB().b((com.tencent.mm.vending.c.a)new h(this, (String)localObject));
      this.oht = false;
      this.ohA = null;
      AppMethodBeat.o(112463);
      return;
    }
    if (this.ohy)
    {
      this.ohB = true;
      this.offset = 0;
      this.ohy = false;
      bTp();
    }
    AppMethodBeat.o(112463);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$CardListModel;", "", "(Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI;)V", "element", "Lcom/tencent/mm/protocal/protobuf/CardHomePageElement;", "getElement", "()Lcom/tencent/mm/protocal/protobuf/CardHomePageElement;", "setElement", "(Lcom/tencent/mm/protocal/protobuf/CardHomePageElement;)V", "expandState", "", "getExpandState", "()Z", "setExpandState", "(Z)V", "hasRender", "getHasRender", "setHasRender", "sectionTitle", "", "getSectionTitle", "()Ljava/lang/String;", "setSectionTitle", "(Ljava/lang/String;)V", "showDivider", "getShowDivider", "setShowDivider", "topElement", "Lcom/tencent/mm/protocal/protobuf/CardHomePageTopCell;", "getTopElement", "()Lcom/tencent/mm/protocal/protobuf/CardHomePageTopCell;", "setTopElement", "(Lcom/tencent/mm/protocal/protobuf/CardHomePageTopCell;)V", "type", "", "getType", "()I", "setType", "(I)V", "plugin-card_release"})
  public final class a
  {
    rc ohF;
    public String ohG;
    boolean ohH;
    boolean ohI;
    rh ohJ;
    boolean ohK;
    int type;
    
    public final void Vf(String paramString)
    {
      AppMethodBeat.i(112405);
      d.g.b.k.h(paramString, "<set-?>");
      this.ohG = paramString;
      AppMethodBeat.o(112405);
    }
    
    public final String bTs()
    {
      AppMethodBeat.i(112404);
      String str = this.ohG;
      if (str == null) {
        d.g.b.k.aVY("sectionTitle");
      }
      AppMethodBeat.o(112404);
      return str;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH;", "Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI;", "(Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI;)V", "appendUnderList", "", "model", "Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$CardListModel;", "getItemCount", "", "getItemViewType", "position", "getModelByPos", "getPosByMerchantId", "merchantId", "", "moveStoreToUnderList", "", "element", "Lcom/tencent/mm/protocal/protobuf/CardHomePageElement;", "onBindViewHolder", "holder", "payloads", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "removeModelByMId", "removeTitleSection", "replaceModelByMId", "mchInfo", "plugin-card_release"})
  public final class d
    extends RecyclerView.a<CardHomePageNewUI.e>
  {
    private int Vh(String paramString)
    {
      int k = 0;
      AppMethodBeat.i(112415);
      d.g.b.k.h(paramString, "merchantId");
      if (CardHomePageNewUI.g(this.ohL) != null) {}
      for (int i = 1;; i = 0)
      {
        if (CardHomePageNewUI.f(this.ohL) != null) {
          i += 1;
        }
        for (;;)
        {
          Iterator localIterator = ((Iterable)CardHomePageNewUI.a(this.ohL)).iterator();
          int j = 0;
          Object localObject;
          while (localIterator.hasNext())
          {
            localObject = ((CardHomePageNewUI.a)localIterator.next()).ohF;
            if (localObject != null) {}
            for (localObject = ((rc)localObject).Eja; d.g.b.k.g(localObject, paramString); localObject = null)
            {
              AppMethodBeat.o(112415);
              return i + j;
            }
            j += 1;
          }
          i = CardHomePageNewUI.a(this.ohL).size() + i - 1;
          if (CardHomePageNewUI.c(this.ohL) != null) {
            i += 1;
          }
          for (;;)
          {
            localIterator = ((Iterable)CardHomePageNewUI.b(this.ohL)).iterator();
            j = k;
            while (localIterator.hasNext())
            {
              localObject = ((CardHomePageNewUI.a)localIterator.next()).ohF;
              if (localObject != null) {}
              for (localObject = ((rc)localObject).Eja; d.g.b.k.g(localObject, paramString); localObject = null)
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
    
    public final void Vg(String paramString)
    {
      AppMethodBeat.i(112414);
      d.g.b.k.h(paramString, "merchantId");
      Iterator localIterator = CardHomePageNewUI.a(this.ohL).iterator();
      CardHomePageNewUI.a locala;
      Object localObject;
      while (localIterator.hasNext())
      {
        locala = (CardHomePageNewUI.a)localIterator.next();
        localObject = locala.ohF;
        if (localObject != null) {}
        for (localObject = ((rc)localObject).Eja; d.g.b.k.g(localObject, paramString); localObject = null)
        {
          CardHomePageNewUI.a(this.ohL).remove(locala);
          paramString = CardHomePageNewUI.j(this.ohL).getAdapter();
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
      localIterator = CardHomePageNewUI.b(this.ohL).iterator();
      while (localIterator.hasNext())
      {
        locala = (CardHomePageNewUI.a)localIterator.next();
        localObject = locala.ohF;
        if (localObject != null) {}
        for (localObject = ((rc)localObject).Eja; d.g.b.k.g(localObject, paramString); localObject = null)
        {
          CardHomePageNewUI.b(this.ohL).remove(locala);
          if (CardHomePageNewUI.b(this.ohL).size() != 0) {
            break label231;
          }
          CardHomePageNewUI.d(this.ohL);
          paramString = CardHomePageNewUI.j(this.ohL).getAdapter();
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
    
    public final void a(String paramString, rc paramrc)
    {
      AppMethodBeat.i(112416);
      d.g.b.k.h(paramString, "merchantId");
      d.g.b.k.h(paramrc, "mchInfo");
      Iterator localIterator = CardHomePageNewUI.a(this.ohL).iterator();
      CardHomePageNewUI.a locala;
      Object localObject;
      int i;
      while (localIterator.hasNext())
      {
        locala = (CardHomePageNewUI.a)localIterator.next();
        localObject = locala.ohF;
        if (localObject != null) {}
        for (localObject = ((rc)localObject).Eja; d.g.b.k.g(localObject, paramString); localObject = null)
        {
          locala.ohF = paramrc;
          i = Vh(paramString);
          if (i < 0) {
            break label130;
          }
          paramString = CardHomePageNewUI.j(this.ohL).getAdapter();
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
      localIterator = CardHomePageNewUI.b(this.ohL).iterator();
      while (localIterator.hasNext())
      {
        locala = (CardHomePageNewUI.a)localIterator.next();
        localObject = locala.ohF;
        if (localObject != null) {}
        for (localObject = ((rc)localObject).Eja; d.g.b.k.g(localObject, paramString); localObject = null)
        {
          locala.ohF = paramrc;
          i = Vh(paramString);
          if (i < 0) {
            break label249;
          }
          paramString = CardHomePageNewUI.j(this.ohL).getAdapter();
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
      ArrayList localArrayList = CardHomePageNewUI.a(this.ohL);
      int i;
      int j;
      if (localArrayList != null)
      {
        i = localArrayList.size();
        localArrayList = CardHomePageNewUI.b(this.ohL);
        if (localArrayList == null) {
          break label145;
        }
        j = localArrayList.size();
        label48:
        if (CardHomePageNewUI.c(this.ohL) == null) {
          break label174;
        }
      }
      label145:
      label156:
      label174:
      for (int k = 1;; k = 0)
      {
        if (CardHomePageNewUI.e(this.ohL) != null) {}
        for (int m = 1;; m = 0)
        {
          if (CardHomePageNewUI.f(this.ohL) != null) {}
          for (int n = 1;; n = 0)
          {
            localArrayList = CardHomePageNewUI.g(this.ohL);
            int i1;
            if (localArrayList != null)
            {
              i1 = localArrayList.size();
              label107:
              if (CardHomePageNewUI.h(this.ohL) == null) {
                break label156;
              }
            }
            for (;;)
            {
              AppMethodBeat.o(112409);
              return i + j + k + m + n + i1 + i2;
              i = 0;
              break;
              j = 0;
              break label48;
              i1 = 0;
              break label107;
              i2 = 0;
            }
          }
        }
      }
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(112410);
      CardHomePageNewUI.a locala = zX(paramInt);
      if (locala != null)
      {
        paramInt = locala.type;
        AppMethodBeat.o(112410);
        return paramInt;
      }
      AppMethodBeat.o(112410);
      return 3;
    }
    
    public final CardHomePageNewUI.a zX(int paramInt)
    {
      int j = 0;
      AppMethodBeat.i(112413);
      Object localObject1 = CardHomePageNewUI.a(this.ohL);
      Object localObject2;
      if (localObject1 != null)
      {
        localObject1 = Integer.valueOf(((ArrayList)localObject1).size());
        localObject2 = CardHomePageNewUI.a(this.ohL);
        if (localObject2 == null) {
          break label159;
        }
        localObject2 = Integer.valueOf(((ArrayList)localObject2).size());
        label56:
        if (CardHomePageNewUI.c(this.ohL) == null) {
          break label165;
        }
      }
      label159:
      label165:
      for (boolean bool = true;; bool = false)
      {
        ac.d("MicroMsg.CardHomePageNewUI", "pos: %s, sSize: %s, uSize: %s, title: %s", new Object[] { Integer.valueOf(paramInt), localObject1, localObject2, Boolean.valueOf(bool) });
        localObject1 = CardHomePageNewUI.g(this.ohL);
        if (localObject1 == null) {
          break label177;
        }
        if (paramInt + 0 >= ((ArrayList)localObject1).size()) {
          break label171;
        }
        localObject1 = (CardHomePageNewUI.a)((ArrayList)localObject1).get(paramInt + 0);
        AppMethodBeat.o(112413);
        return localObject1;
        localObject1 = null;
        break;
        localObject2 = null;
        break label56;
      }
      label171:
      j = ((ArrayList)localObject1).size();
      label177:
      localObject1 = CardHomePageNewUI.f(this.ohL);
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
      localObject1 = CardHomePageNewUI.h(this.ohL);
      if ((localObject1 != null) && (paramInt == i))
      {
        AppMethodBeat.o(112413);
        return localObject1;
      }
      localObject1 = CardHomePageNewUI.a(this.ohL);
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
      if (CardHomePageNewUI.c(this.ohL) != null)
      {
        j += 1;
        i = j;
        if (paramInt == j)
        {
          localObject1 = CardHomePageNewUI.c(this.ohL);
          AppMethodBeat.o(112413);
          return localObject1;
        }
      }
      localObject1 = CardHomePageNewUI.b(this.ohL);
      if ((localObject1 != null) && (paramInt > i) && (paramInt <= ((ArrayList)localObject1).size() + i))
      {
        localObject1 = (CardHomePageNewUI.a)((ArrayList)localObject1).get(paramInt - i - 1);
        AppMethodBeat.o(112413);
        return localObject1;
      }
      AppMethodBeat.o(112413);
      return null;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "viewType", "", "(Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI;Landroid/view/View;I)V", "chpiCouponLayout", "Landroid/widget/LinearLayout;", "getChpiCouponLayout", "()Landroid/widget/LinearLayout;", "setChpiCouponLayout", "(Landroid/widget/LinearLayout;)V", "chpiDescTv", "Landroid/widget/TextView;", "getChpiDescTv", "()Landroid/widget/TextView;", "setChpiDescTv", "(Landroid/widget/TextView;)V", "chpiExpandIv", "Landroid/widget/ImageView;", "getChpiExpandIv", "()Landroid/widget/ImageView;", "setChpiExpandIv", "(Landroid/widget/ImageView;)V", "chpiExpandLayout", "getChpiExpandLayout", "setChpiExpandLayout", "chpiExpandTv", "getChpiExpandTv", "setChpiExpandTv", "chpiHeaderLayout", "getChpiHeaderLayout", "setChpiHeaderLayout", "chpiLabelLayout", "getChpiLabelLayout", "setChpiLabelLayout", "chpiLogoIv", "Lcom/tencent/mm/pluginsdk/ui/applet/CdnImageView;", "getChpiLogoIv", "()Lcom/tencent/mm/pluginsdk/ui/applet/CdnImageView;", "setChpiLogoIv", "(Lcom/tencent/mm/pluginsdk/ui/applet/CdnImageView;)V", "chpiMchLabelTv", "Lcom/tencent/mm/plugin/card/ui/v2/CardLabelTextView;", "getChpiMchLabelTv", "()Lcom/tencent/mm/plugin/card/ui/v2/CardLabelTextView;", "setChpiMchLabelTv", "(Lcom/tencent/mm/plugin/card/ui/v2/CardLabelTextView;)V", "chpiNameTv", "getChpiNameTv", "setChpiNameTv", "chtiDescTv", "getChtiDescTv", "setChtiDescTv", "chtiDivider", "getChtiDivider", "()Landroid/view/View;", "setChtiDivider", "(Landroid/view/View;)V", "chtiIconIv", "getChtiIconIv", "setChtiIconIv", "chtiNewTv", "getChtiNewTv", "setChtiNewTv", "chtiRedDotIv", "getChtiRedDotIv", "setChtiRedDotIv", "chtiRightIv", "getChtiRightIv", "setChtiRightIv", "chtiTitleTv", "getChtiTitleTv", "setChtiTitleTv", "model", "Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$CardListModel;", "Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI;", "getModel", "()Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$CardListModel;", "setModel", "(Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$CardListModel;)V", "sectionTitleTv", "getSectionTitleTv", "setSectionTitleTv", "addCouponView", "", "view", "appendCouponView", "offset", "len", "position", "collapseCouponLayout", "expandCouponLayout", "gotoCardDetailUI", "cardId", "", "setCardBg", "imageView", "url", "radius", "", "defaultRes", "setIcon", "useBackendExpandState", "", "showCollapseLayout", "showExpandLayout", "showMiniAppLayout", "updateCardLabelLayout", "couponLabelList", "", "Lcom/tencent/mm/protocal/protobuf/CardElementCouponLabel;", "labelLayout", "labelList", "Lcom/tencent/mm/protocal/protobuf/CardElementMchLabel;", "updateExpandLayout", "isExpended", "plugin-card_release"})
  public final class e
    extends RecyclerView.w
  {
    public TextView ohM;
    public CdnImageView ohN;
    public TextView ohO;
    public TextView ohP;
    public LinearLayout ohQ;
    public LinearLayout ohR;
    public LinearLayout ohS;
    public LinearLayout ohT;
    public TextView ohU;
    public ImageView ohV;
    public CardLabelTextView ohW;
    public ImageView ohX;
    public TextView ohY;
    public TextView ohZ;
    public ImageView oia;
    public ImageView oib;
    public TextView oic;
    public View oid;
    CardHomePageNewUI.a oie;
    
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
        d.g.b.k.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_logo_iv)");
        this.ohN = ((CdnImageView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298303);
        d.g.b.k.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_username_tv)");
        this.ohO = ((TextView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298293);
        d.g.b.k.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_desc_tv)");
        this.ohP = ((TextView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298298);
        d.g.b.k.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_label_layout)");
        this.ohR = ((LinearLayout)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298292);
        d.g.b.k.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_coupon_layout)");
        this.ohS = ((LinearLayout)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298295);
        d.g.b.k.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_expand_layout)");
        this.ohT = ((LinearLayout)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298294);
        d.g.b.k.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_expand_iv)");
        this.ohV = ((ImageView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298296);
        d.g.b.k.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_expand_tv)");
        this.ohU = ((TextView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298300);
        d.g.b.k.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_mch_label_tv)");
        this.ohW = ((CardLabelTextView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298297);
        d.g.b.k.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_header_layout)");
        this.ohQ = ((LinearLayout)CardHomePageNewUI.this);
        AppMethodBeat.o(112438);
        return;
        this$1 = paramInt.findViewById(2131298301);
        d.g.b.k.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_section_title)");
        this.ohM = ((TextView)CardHomePageNewUI.this);
        AppMethodBeat.o(112438);
        return;
        this$1 = paramInt.findViewById(2131298299);
        d.g.b.k.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_logo_iv)");
        this.ohN = ((CdnImageView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298303);
        d.g.b.k.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_username_tv)");
        this.ohO = ((TextView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298293);
        d.g.b.k.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_desc_tv)");
        this.ohP = ((TextView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298300);
        d.g.b.k.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_mch_label_tv)");
        this.ohW = ((CardLabelTextView)CardHomePageNewUI.this);
        AppMethodBeat.o(112438);
        return;
        this$1 = paramInt.findViewById(2131298299);
        d.g.b.k.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_logo_iv)");
        this.ohN = ((CdnImageView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298303);
        d.g.b.k.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_username_tv)");
        this.ohO = ((TextView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298293);
        d.g.b.k.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_desc_tv)");
        this.ohP = ((TextView)CardHomePageNewUI.this);
        AppMethodBeat.o(112438);
        return;
        this$1 = paramInt.findViewById(2131298332);
        d.g.b.k.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_icon_iv)");
        this.ohX = ((ImageView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298336);
        d.g.b.k.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_title_tv)");
        this.ohY = ((TextView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298330);
        d.g.b.k.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_desc_tv)");
        this.ohZ = ((TextView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298335);
        d.g.b.k.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_right_iv)");
        this.oia = ((ImageView)CardHomePageNewUI.this);
        AppMethodBeat.o(112438);
        return;
        this$1 = paramInt.findViewById(2131298332);
        d.g.b.k.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_icon_iv)");
        this.ohX = ((ImageView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298336);
        d.g.b.k.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_title_tv)");
        this.ohY = ((TextView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298330);
        d.g.b.k.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_desc_tv)");
        this.ohZ = ((TextView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298335);
        d.g.b.k.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_right_iv)");
        this.oia = ((ImageView)CardHomePageNewUI.this);
        AppMethodBeat.o(112438);
        return;
        this$1 = paramInt.findViewById(2131298332);
        d.g.b.k.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_icon_iv)");
        this.ohX = ((ImageView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298336);
        d.g.b.k.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_title_tv)");
        this.ohY = ((TextView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298330);
        d.g.b.k.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_desc_tv)");
        this.ohZ = ((TextView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298335);
        d.g.b.k.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_right_iv)");
        this.oia = ((ImageView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298334);
        d.g.b.k.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_reddot_iv)");
        this.oib = ((ImageView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298333);
        d.g.b.k.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_new_tv)");
        this.oic = ((TextView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298331);
        d.g.b.k.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_divider)");
        this.oid = CardHomePageNewUI.this;
      }
    }
    
    private final void A(boolean paramBoolean, int paramInt)
    {
      AppMethodBeat.i(112437);
      Object localObject = this.oie;
      if (localObject == null) {
        d.g.b.k.fOy();
      }
      localObject = ((CardHomePageNewUI.a)localObject).ohF;
      if (paramBoolean)
      {
        if (localObject != null) {}
        for (localObject = ((rc)localObject).Ejg; !bs.isNullOrNil((String)localObject); localObject = null)
        {
          zY(paramInt);
          AppMethodBeat.o(112437);
          return;
        }
        Aa(paramInt);
        AppMethodBeat.o(112437);
        return;
      }
      zZ(paramInt);
      AppMethodBeat.o(112437);
    }
    
    private final void Aa(final int paramInt)
    {
      AppMethodBeat.i(112436);
      Object localObject1 = this.oie;
      if (localObject1 == null) {
        d.g.b.k.fOy();
      }
      localObject1 = ((CardHomePageNewUI.a)localObject1).ohF;
      Object localObject2 = this.ohU;
      if (localObject2 == null) {
        d.g.b.k.aVY("chpiExpandTv");
      }
      ((TextView)localObject2).setText((CharSequence)ai.getResources().getString(2131756874));
      localObject2 = this.ohT;
      if (localObject2 == null) {
        d.g.b.k.aVY("chpiExpandLayout");
      }
      ((LinearLayout)localObject2).setOnClickListener((View.OnClickListener)new g(this, paramInt, (rc)localObject1));
      localObject1 = this.ohV;
      if (localObject1 == null) {
        d.g.b.k.aVY("chpiExpandIv");
      }
      ((ImageView)localObject1).setImageResource(2131231498);
      localObject1 = this.ohV;
      if (localObject1 == null) {
        d.g.b.k.aVY("chpiExpandIv");
      }
      ((ImageView)localObject1).setVisibility(0);
      AppMethodBeat.o(112436);
    }
    
    private final void S(int paramInt1, int paramInt2, final int paramInt3)
    {
      AppMethodBeat.i(112428);
      Object localObject1 = this.oie;
      if (localObject1 == null) {
        d.g.b.k.fOy();
      }
      localObject1 = ((CardHomePageNewUI.a)localObject1).ohF;
      if (localObject1 == null) {
        d.g.b.k.fOy();
      }
      Object localObject2 = ((rc)localObject1).Ejf;
      d.g.b.k.g(localObject2, "el!!.card_element_coupon_list");
      localObject2 = ((Iterable)localObject2).iterator();
      int k = 0;
      int i = 0;
      if (((Iterator)localObject2).hasNext())
      {
        final ra localra = (ra)((Iterator)localObject2).next();
        int j = i;
        if (k >= paramInt1)
        {
          if (localra.EiI != 1) {
            break label487;
          }
          localObject3 = this.ohS;
          if (localObject3 == null) {
            d.g.b.k.aVY("chpiCouponLayout");
          }
          localObject3 = LayoutInflater.from(((LinearLayout)localObject3).getContext());
          localLinearLayout = this.ohS;
          if (localLinearLayout == null) {
            d.g.b.k.aVY("chpiCouponLayout");
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
          if (!bs.isNullOrNil(localra.EiL)) {
            ((TextView)localObject4).setTextColor(com.tencent.mm.plugin.card.d.l.cH(localra.EiL, localra.EiM));
          }
          d.g.b.k.g(localObject4, "titleTv");
          ((TextView)localObject4).setText((CharSequence)localra.EiC);
          ((CdnImageView)localObject5).setUrl(localra.EiJ);
          if (!bs.isNullOrNil(localra.EiN)) {
            ((TextView)localObject6).setTextColor(com.tencent.mm.plugin.card.d.l.cH(localra.EiN, localra.EiO));
          }
          d.g.b.k.g(localObject6, "descTv");
          ((TextView)localObject6).setText((CharSequence)localra.EiD);
          localObject4 = localra.EiH;
          d.g.b.k.g(localObject4, "coupon.coupon_label");
          localObject4 = (List)localObject4;
          d.g.b.k.g(localLinearLayout, "labelLayout");
          a((List)localObject4, localLinearLayout);
          localLinearLayout = this.ohS;
          if (localLinearLayout == null) {
            d.g.b.k.aVY("chpiCouponLayout");
          }
          ((ViewGroup)localObject3).setOnClickListener((View.OnClickListener)new a(this, (rc)localObject1, localra, localLinearLayout.getChildCount(), paramInt3));
          dF((View)localObject3);
        }
        label487:
        while (localra.EiI != 2)
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
        Object localObject3 = this.ohS;
        if (localObject3 == null) {
          d.g.b.k.aVY("chpiCouponLayout");
        }
        localObject3 = LayoutInflater.from(((LinearLayout)localObject3).getContext());
        LinearLayout localLinearLayout = this.ohS;
        if (localLinearLayout == null) {
          d.g.b.k.aVY("chpiCouponLayout");
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
        if (!bs.isNullOrNil(localra.EiL)) {
          ((TextView)localObject5).setTextColor(com.tencent.mm.plugin.card.d.l.cH(localra.EiL, localra.EiM));
        }
        d.g.b.k.g(localObject5, "titleTv");
        ((TextView)localObject5).setText((CharSequence)localra.EiC);
        d.g.b.k.g(localObject6, "descTv");
        ((TextView)localObject6).setText((CharSequence)localra.EiD);
        d.g.b.k.g(localObject7, "bgIv");
        ((MemberCardTopCropImageView)localObject7).setRadius(com.tencent.mm.cc.a.fromDPToPix(((MemberCardTopCropImageView)localObject7).getContext(), 2));
        if (!bs.isNullOrNil(localra.EiG))
        {
          localObject5 = (ImageView)localObject7;
          localObject6 = localra.EiG;
          d.g.b.k.g(localObject6, "coupon.coupon_back_url");
          d.g.b.k.h(localObject5, "imageView");
          d.g.b.k.h(localObject6, "url");
          localObject7 = new c.a();
          ((c.a)localObject7).CB(com.tencent.mm.loader.j.b.aph());
          ((c.a)localObject7).a(o.aFC());
          ((c.a)localObject7).CA(m.UK((String)localObject6));
          ((c.a)localObject7).aFP();
          ((c.a)localObject7).aFS();
          ((c.a)localObject7).aFO();
          ((c.a)localObject7).pe(2131231461);
          ((c.a)localObject7).pd(com.tencent.mm.cc.a.fromDPToPix(((ImageView)localObject5).getContext(), 84));
          ((c.a)localObject7).pc(com.tencent.mm.cc.a.ig(((ImageView)localObject5).getContext()));
          localObject7 = ((c.a)localObject7).aFT();
          o.aFB().a((String)localObject6, (ImageView)localObject5, (c)localObject7);
          ((ImageView)localObject5).setImageMatrix(new Matrix());
          d.g.b.k.g(localObject4, "shadowBgIv");
          ((ImageView)localObject4).setVisibility(0);
        }
        for (;;)
        {
          localObject4 = localra.EiH;
          d.g.b.k.g(localObject4, "coupon.coupon_label");
          localObject4 = (List)localObject4;
          d.g.b.k.g(localLinearLayout, "labelLayout");
          a((List)localObject4, localLinearLayout);
          localLinearLayout = this.ohS;
          if (localLinearLayout == null) {
            d.g.b.k.aVY("chpiCouponLayout");
          }
          ((ViewGroup)localObject3).setOnClickListener((View.OnClickListener)new b(this, (rc)localObject1, localra, localLinearLayout.getChildCount(), paramInt3));
          dF((View)localObject3);
          break;
          if (!bs.isNullOrNil(localra.EiF))
          {
            ((MemberCardTopCropImageView)localObject7).setImageDrawable((Drawable)new ColorDrawable(Color.parseColor(localra.EiF)));
            d.g.b.k.g(localObject4, "shadowBgIv");
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
      d.g.b.k.h(paramImageView, "imageView");
      d.g.b.k.h(paramString, "url");
      Object localObject = new c.a();
      ((c.a)localObject).CB(com.tencent.mm.loader.j.b.aph());
      ((c.a)localObject).a(o.aFC());
      ((c.a)localObject).CA(m.UK(paramString));
      ((c.a)localObject).aFP();
      ((c.a)localObject).aFR();
      ((c.a)localObject).aFS();
      ((c.a)localObject).aFO();
      ((c.a)localObject).pe(2131689865);
      localObject = ((c.a)localObject).aFT();
      o.aFB().a(paramString, paramImageView, (c)localObject);
      AppMethodBeat.o(112433);
    }
    
    private void a(List<? extends qz> paramList, LinearLayout paramLinearLayout)
    {
      AppMethodBeat.i(112432);
      d.g.b.k.h(paramList, "couponLabelList");
      d.g.b.k.h(paramLinearLayout, "labelLayout");
      paramList = paramList.iterator();
      if (paramList.hasNext())
      {
        qz localqz = (qz)paramList.next();
        Object localObject1 = this.ohS;
        if (localObject1 == null) {
          d.g.b.k.aVY("chpiCouponLayout");
        }
        localObject1 = new CardTagTextView(((LinearLayout)localObject1).getContext());
        Object localObject2 = this.ohS;
        if (localObject2 == null) {
          d.g.b.k.aVY("chpiCouponLayout");
        }
        localObject2 = ((LinearLayout)localObject2).getContext();
        ((CardTagTextView)localObject1).setMinHeight(com.tencent.mm.cc.a.fromDPToPix((Context)localObject2, 18));
        ((CardTagTextView)localObject1).setMinWidth(com.tencent.mm.cc.a.fromDPToPix((Context)localObject2, 56));
        int i = com.tencent.mm.cc.a.fromDPToPix((Context)localObject2, 8);
        int j = com.tencent.mm.cc.a.fromDPToPix((Context)localObject2, 4);
        ((CardTagTextView)localObject1).setPadding(i, j, i, j);
        ((CardTagTextView)localObject1).setText((CharSequence)localqz.Eiw);
        ((CardTagTextView)localObject1).setTextSize(1, 10.0F);
        if (!bs.isNullOrNil(localqz.Eix))
        {
          ((CardTagTextView)localObject1).setTextColor(Color.parseColor(localqz.Eix));
          label199:
          if (bs.isNullOrNil(localqz.Eiy)) {
            break label249;
          }
          ((CardTagTextView)localObject1).setFillColor(com.tencent.mm.plugin.card.d.l.cH(localqz.Eiy, localqz.EiB));
        }
        for (;;)
        {
          paramLinearLayout.addView((View)localObject1);
          break;
          ((CardTagTextView)localObject1).setTextColor(-1);
          break label199;
          label249:
          ((CardTagTextView)localObject1).setFillColor(com.tencent.mm.plugin.card.d.l.eR(-16777216, 26));
        }
      }
      AppMethodBeat.o(112432);
    }
    
    private void cD(List<? extends rb> paramList)
    {
      AppMethodBeat.i(112431);
      d.g.b.k.h(paramList, "labelList");
      Object localObject1 = this.ohR;
      if (localObject1 == null) {
        d.g.b.k.aVY("chpiLabelLayout");
      }
      ((LinearLayout)localObject1).removeAllViews();
      if (paramList.isEmpty())
      {
        paramList = this.ohR;
        if (paramList == null) {
          d.g.b.k.aVY("chpiLabelLayout");
        }
        paramList.setVisibility(8);
        AppMethodBeat.o(112431);
        return;
      }
      paramList = ((Iterable)paramList).iterator();
      int i = 0;
      if (paramList.hasNext())
      {
        Object localObject2 = (rb)paramList.next();
        localObject1 = this.ohR;
        if (localObject1 == null) {
          d.g.b.k.aVY("chpiLabelLayout");
        }
        localObject1 = ((LinearLayout)localObject1).getContext();
        d.g.b.k.g(localObject1, "chpiLabelLayout.context");
        localObject1 = new CardLabelTextView((Context)localObject1);
        Object localObject3 = this.ohR;
        if (localObject3 == null) {
          d.g.b.k.aVY("chpiLabelLayout");
        }
        localObject3 = ((LinearLayout)localObject3).getContext();
        ((CardLabelTextView)localObject1).setTextSize(1, 12.0F);
        ((CardLabelTextView)localObject1).setText((CharSequence)((rb)localObject2).EiU);
        int j = com.tencent.mm.cc.a.fromDPToPix((Context)localObject3, 4);
        ((CardLabelTextView)localObject1).setPadding(j, 0, j, 0);
        ((CardLabelTextView)localObject1).setGravity(16);
        if (!bs.isNullOrNil(((rb)localObject2).EiV))
        {
          ((CardLabelTextView)localObject1).setTextColor(Color.parseColor(((rb)localObject2).EiV));
          label240:
          if (bs.isNullOrNil(((rb)localObject2).EiW)) {
            break label359;
          }
          ((CardLabelTextView)localObject1).setFillColor(com.tencent.mm.plugin.card.d.l.cH(((rb)localObject2).EiW, ((rb)localObject2).EiZ));
          label269:
          if (i <= 0) {
            break label368;
          }
          localObject2 = new ViewGroup.MarginLayoutParams(-2, -2);
          ((ViewGroup.MarginLayoutParams)localObject2).leftMargin = com.tencent.mm.cc.a.fromDPToPix((Context)localObject3, 4);
          localObject2 = (ViewGroup.MarginLayoutParams)new LinearLayout.LayoutParams((ViewGroup.MarginLayoutParams)localObject2);
          localObject3 = this.ohR;
          if (localObject3 == null) {
            d.g.b.k.aVY("chpiLabelLayout");
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
          localObject2 = this.ohR;
          if (localObject2 == null) {
            d.g.b.k.aVY("chpiLabelLayout");
          }
          ((LinearLayout)localObject2).addView((View)localObject1);
        }
      }
      paramList = this.ohR;
      if (paramList == null) {
        d.g.b.k.aVY("chpiLabelLayout");
      }
      paramList.setVisibility(0);
      AppMethodBeat.o(112431);
    }
    
    private void dF(View paramView)
    {
      AppMethodBeat.i(112430);
      d.g.b.k.h(paramView, "view");
      Object localObject = this.ohS;
      if (localObject == null) {
        d.g.b.k.aVY("chpiCouponLayout");
      }
      if (((LinearLayout)localObject).getChildCount() == 0)
      {
        localObject = this.ohS;
        if (localObject == null) {
          d.g.b.k.aVY("chpiCouponLayout");
        }
        ((LinearLayout)localObject).addView(paramView);
        AppMethodBeat.o(112430);
        return;
      }
      localObject = this.ohS;
      if (localObject == null) {
        d.g.b.k.aVY("chpiCouponLayout");
      }
      localObject = new ViewGroup.MarginLayoutParams(-1, com.tencent.mm.cc.a.fromDPToPix(((LinearLayout)localObject).getContext(), 84));
      LinearLayout localLinearLayout = this.ohS;
      if (localLinearLayout == null) {
        d.g.b.k.aVY("chpiCouponLayout");
      }
      ((ViewGroup.MarginLayoutParams)localObject).topMargin = com.tencent.mm.cc.a.fromDPToPix(localLinearLayout.getContext(), 8);
      localObject = (ViewGroup.MarginLayoutParams)new LinearLayout.LayoutParams((ViewGroup.MarginLayoutParams)localObject);
      localLinearLayout = this.ohS;
      if (localLinearLayout == null) {
        d.g.b.k.aVY("chpiCouponLayout");
      }
      localLinearLayout.addView(paramView, (ViewGroup.LayoutParams)localObject);
      AppMethodBeat.o(112430);
    }
    
    private final void zY(final int paramInt)
    {
      AppMethodBeat.i(112434);
      Object localObject1 = this.oie;
      if (localObject1 == null) {
        d.g.b.k.fOy();
      }
      localObject1 = ((CardHomePageNewUI.a)localObject1).ohF;
      if (localObject1 == null) {
        d.g.b.k.fOy();
      }
      if (!bs.isNullOrNil(((rc)localObject1).Ejg))
      {
        if (!bs.isNullOrNil(((rc)localObject1).Ejh))
        {
          localObject2 = this.ohU;
          if (localObject2 == null) {
            d.g.b.k.aVY("chpiExpandTv");
          }
          ((TextView)localObject2).setTextColor(Color.parseColor(((rc)localObject1).Ejh));
        }
        Object localObject2 = this.ohU;
        if (localObject2 == null) {
          d.g.b.k.aVY("chpiExpandTv");
        }
        ((TextView)localObject2).setText((CharSequence)((rc)localObject1).Ejg);
        localObject2 = this.ohV;
        if (localObject2 == null) {
          d.g.b.k.aVY("chpiExpandIv");
        }
        ((ImageView)localObject2).setImageResource(2131231436);
        localObject2 = this.ohT;
        if (localObject2 == null) {
          d.g.b.k.aVY("chpiExpandLayout");
        }
        ((LinearLayout)localObject2).setOnClickListener((View.OnClickListener)new i((rc)localObject1, this, paramInt));
      }
      AppMethodBeat.o(112434);
    }
    
    private final void zZ(final int paramInt)
    {
      AppMethodBeat.i(112435);
      Object localObject1 = this.oie;
      if (localObject1 == null) {
        d.g.b.k.fOy();
      }
      localObject1 = ((CardHomePageNewUI.a)localObject1).ohF;
      Object localObject2 = this.ohU;
      if (localObject2 == null) {
        d.g.b.k.aVY("chpiExpandTv");
      }
      Resources localResources = ai.getResources();
      if (localObject1 == null) {
        d.g.b.k.fOy();
      }
      ((TextView)localObject2).setText((CharSequence)localResources.getString(2131756876, new Object[] { Integer.valueOf(((rc)localObject1).Ejl - ((rc)localObject1).Ejm) }));
      localObject2 = this.ohT;
      if (localObject2 == null) {
        d.g.b.k.aVY("chpiExpandLayout");
      }
      ((LinearLayout)localObject2).setOnClickListener((View.OnClickListener)new h(this, paramInt, (rc)localObject1));
      localObject1 = this.ohV;
      if (localObject1 == null) {
        d.g.b.k.aVY("chpiExpandIv");
      }
      ((ImageView)localObject1).setImageResource(2131231497);
      localObject1 = this.ohV;
      if (localObject1 == null) {
        d.g.b.k.aVY("chpiExpandIv");
      }
      ((ImageView)localObject1).setVisibility(0);
      AppMethodBeat.o(112435);
    }
    
    public final void Vi(String paramString)
    {
      AppMethodBeat.i(112429);
      d.g.b.k.h(paramString, "cardId");
      ac.i("MicroMsg.CardHomePageNewUI", "go to card detail: %s", new Object[] { paramString });
      Object localObject = this.asD;
      d.g.b.k.g(localObject, "itemView");
      localObject = new Intent(((View)localObject).getContext(), CardDetailUI.class);
      ((Intent)localObject).putExtra("key_card_id", paramString);
      ((Intent)localObject).addFlags(131072);
      ((Intent)localObject).putExtra("key_from_scene", 3);
      paramString = this.asD;
      d.g.b.k.g(paramString, "itemView");
      paramString = paramString.getContext();
      localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH", "gotoCardDetailUI", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH", "gotoCardDetailUI", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(112429);
    }
    
    public final void a(final CardHomePageNewUI.a parama, final int paramInt)
    {
      AppMethodBeat.i(112426);
      d.g.b.k.h(parama, "model");
      this.oie = parama;
      Object localObject1 = parama.ohF;
      switch (parama.type)
      {
      }
      for (;;)
      {
        parama.ohH = true;
        AppMethodBeat.o(112426);
        return;
        if (localObject1 == null) {
          d.g.b.k.fOy();
        }
        Object localObject2 = this.ohN;
        if (localObject2 == null) {
          d.g.b.k.aVY("chpiLogoIv");
        }
        ((CdnImageView)localObject2).setRoundCorner(true);
        Object localObject3;
        label172:
        int i;
        label511:
        boolean bool;
        if (!bs.isNullOrNil(((rc)localObject1).Ejb))
        {
          localObject2 = this.ohN;
          if (localObject2 == null) {
            d.g.b.k.aVY("chpiLogoIv");
          }
          localObject2 = (ImageView)localObject2;
          localObject3 = ((rc)localObject1).Ejb;
          d.g.b.k.g(localObject3, "card_element_mch_icon");
          a((ImageView)localObject2, (String)localObject3);
          localObject2 = (View.OnClickListener)new c((rc)localObject1, this, (rc)localObject1, paramInt, parama);
          localObject3 = this.ohN;
          if (localObject3 == null) {
            d.g.b.k.aVY("chpiLogoIv");
          }
          ((CdnImageView)localObject3).setOnClickListener((View.OnClickListener)localObject2);
          localObject3 = CardHomePageNewUI.this;
          Object localObject4 = CardHomePageNewUI.this.getContext();
          d.g.b.k.g(localObject4, "context");
          i = ((AppCompatActivity)localObject4).getResources().getColor(2131100711);
          localObject4 = CardHomePageNewUI.this.getContext();
          d.g.b.k.g(localObject4, "context");
          localObject4 = new CardHomePageNewUI.b((CardHomePageNewUI)localObject3, i, ((AppCompatActivity)localObject4).getResources().getColor(2131100913), (com.tencent.mm.pluginsdk.ui.span.i)new CardHomePageNewUI.e.d((View.OnClickListener)localObject2));
          localObject3 = new SpannableString((CharSequence)((rc)localObject1).Ejc);
          ((SpannableString)localObject3).setSpan(localObject4, 0, ((SpannableString)localObject3).length(), 18);
          localObject4 = this.ohO;
          if (localObject4 == null) {
            d.g.b.k.aVY("chpiNameTv");
          }
          ((TextView)localObject4).setClickable(true);
          localObject4 = this.ohO;
          if (localObject4 == null) {
            d.g.b.k.aVY("chpiNameTv");
          }
          ((TextView)localObject4).setOnTouchListener((View.OnTouchListener)new n((Context)CardHomePageNewUI.this));
          localObject4 = this.ohO;
          if (localObject4 == null) {
            d.g.b.k.aVY("chpiNameTv");
          }
          ((TextView)localObject4).setText((CharSequence)localObject3);
          if (bs.isNullOrNil(((rc)localObject1).Ejd)) {
            break label912;
          }
          localObject3 = this.ohP;
          if (localObject3 == null) {
            d.g.b.k.aVY("chpiDescTv");
          }
          ((TextView)localObject3).setText((CharSequence)((rc)localObject1).Ejd);
          localObject3 = this.ohP;
          if (localObject3 == null) {
            d.g.b.k.aVY("chpiDescTv");
          }
          ((TextView)localObject3).setVisibility(0);
          localObject3 = this.ohP;
          if (localObject3 == null) {
            d.g.b.k.aVY("chpiDescTv");
          }
          ((TextView)localObject3).setOnClickListener((View.OnClickListener)localObject2);
          if (((rc)localObject1).Ejj == null) {
            break label1030;
          }
          if (bs.isNullOrNil(((rc)localObject1).Ejj.EiU)) {
            break label1003;
          }
          localObject2 = this.ohW;
          if (localObject2 == null) {
            d.g.b.k.aVY("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject2).setText((CharSequence)((rc)localObject1).Ejj.EiU);
          if (bs.isNullOrNil(((rc)localObject1).Ejj.EiV)) {
            break label939;
          }
          localObject2 = this.ohW;
          if (localObject2 == null) {
            d.g.b.k.aVY("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject2).setTextColor(Color.parseColor(((rc)localObject1).Ejj.EiV));
          label613:
          if (bs.isNullOrNil(((rc)localObject1).Ejj.EiW)) {
            break label977;
          }
          localObject2 = this.ohW;
          if (localObject2 == null) {
            d.g.b.k.aVY("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject2).setFillColor(com.tencent.mm.plugin.card.d.l.cH(((rc)localObject1).Ejj.EiW, ((rc)localObject1).Ejj.EiZ));
          label668:
          localObject2 = this.ohW;
          if (localObject2 == null) {
            d.g.b.k.aVY("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject2).setVisibility(0);
          label691:
          localObject2 = this.ohS;
          if (localObject2 == null) {
            d.g.b.k.aVY("chpiCouponLayout");
          }
          ((LinearLayout)localObject2).removeAllViews();
          if (parama.ohH) {
            break label1091;
          }
          if (((rc)localObject1).Ejk != 1) {
            break label1085;
          }
          bool = true;
          label732:
          if (!bool) {
            break label1183;
          }
          localObject2 = ((rc)localObject1).Ejf;
          d.g.b.k.g(localObject2, "card_element_coupon_list");
          if (((Collection)localObject2).isEmpty()) {
            break label1100;
          }
          i = 1;
          label767:
          if (i == 0) {
            break label1105;
          }
          S(-1, ((rc)localObject1).Ejf.size(), paramInt);
          localObject2 = this.ohS;
          if (localObject2 == null) {
            d.g.b.k.aVY("chpiCouponLayout");
          }
          ((LinearLayout)localObject2).setVisibility(0);
          parama.ohI = true;
          label813:
          if (bs.isNullOrNil(((rc)localObject1).Ejg)) {
            break label1132;
          }
          zY(paramInt);
          localObject2 = this.ohT;
          if (localObject2 == null) {
            d.g.b.k.aVY("chpiExpandLayout");
          }
          ((LinearLayout)localObject2).setVisibility(0);
        }
        label912:
        label939:
        label1085:
        label1213:
        for (;;)
        {
          localObject1 = ((rc)localObject1).Eje;
          d.g.b.k.g(localObject1, "card_element_mch_label");
          cD((List)localObject1);
          localObject1 = y.KTp;
          break;
          localObject2 = this.ohN;
          if (localObject2 == null) {
            d.g.b.k.aVY("chpiLogoIv");
          }
          ((CdnImageView)localObject2).setImageResource(2131689865);
          break label172;
          localObject2 = this.ohP;
          if (localObject2 == null) {
            d.g.b.k.aVY("chpiDescTv");
          }
          ((TextView)localObject2).setVisibility(8);
          break label511;
          localObject2 = this.ohW;
          if (localObject2 == null) {
            d.g.b.k.aVY("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject2).setTextColor(CardHomePageNewUI.this.getResources().getColor(2131101179));
          break label613;
          label977:
          localObject2 = this.ohW;
          if (localObject2 == null) {
            d.g.b.k.aVY("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject2).setFillColor(0);
          break label668;
          label1003:
          localObject2 = this.ohW;
          if (localObject2 == null) {
            d.g.b.k.aVY("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject2).setVisibility(8);
          break label691;
          localObject2 = this.ohW;
          if (localObject2 == null) {
            d.g.b.k.aVY("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject2).setText((CharSequence)"");
          localObject2 = this.ohW;
          if (localObject2 == null) {
            d.g.b.k.aVY("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject2).setVisibility(8);
          break label691;
          bool = false;
          break label732;
          label1091:
          bool = parama.ohI;
          break label732;
          label1100:
          i = 0;
          break label767;
          label1105:
          localObject2 = this.ohS;
          if (localObject2 == null) {
            d.g.b.k.aVY("chpiCouponLayout");
          }
          ((LinearLayout)localObject2).setVisibility(8);
          break label813;
          label1132:
          if (((rc)localObject1).Ejm < ((rc)localObject1).Ejf.size())
          {
            Aa(paramInt);
          }
          else
          {
            localObject2 = this.ohT;
            if (localObject2 == null) {
              d.g.b.k.aVY("chpiExpandLayout");
            }
            ((LinearLayout)localObject2).setVisibility(8);
            continue;
            localObject2 = ((rc)localObject1).Ejf;
            d.g.b.k.g(localObject2, "card_element_coupon_list");
            if (!((Collection)localObject2).isEmpty())
            {
              i = 1;
              if (i == 0) {
                break label1319;
              }
              S(-1, ((rc)localObject1).Ejm, paramInt);
              localObject2 = this.ohS;
              if (localObject2 == null) {
                d.g.b.k.aVY("chpiCouponLayout");
              }
              ((LinearLayout)localObject2).setVisibility(0);
              parama.ohI = false;
            }
            for (;;)
            {
              if (((rc)localObject1).Ejm >= ((rc)localObject1).Ejf.size())
              {
                if (!bs.isNullOrNil(((rc)localObject1).Ejg))
                {
                  zY(paramInt);
                  localObject2 = this.ohT;
                  if (localObject2 == null) {
                    d.g.b.k.aVY("chpiExpandLayout");
                  }
                  ((LinearLayout)localObject2).setVisibility(0);
                  break;
                  i = 0;
                  break label1213;
                  localObject2 = this.ohS;
                  if (localObject2 == null) {
                    d.g.b.k.aVY("chpiCouponLayout");
                  }
                  ((LinearLayout)localObject2).setVisibility(8);
                  continue;
                }
                localObject2 = this.ohT;
                if (localObject2 == null) {
                  d.g.b.k.aVY("chpiExpandLayout");
                }
                ((LinearLayout)localObject2).setVisibility(8);
                break;
              }
            }
            zZ(paramInt);
            localObject2 = this.ohT;
            if (localObject2 == null) {
              d.g.b.k.aVY("chpiExpandLayout");
            }
            ((LinearLayout)localObject2).setVisibility(0);
          }
        }
        label1030:
        label1183:
        label1319:
        localObject1 = this.ohM;
        if (localObject1 == null) {
          d.g.b.k.aVY("sectionTitleTv");
        }
        ((TextView)localObject1).setText((CharSequence)parama.bTs());
        continue;
        if (localObject1 == null) {
          d.g.b.k.fOy();
        }
        localObject2 = this.ohN;
        if (localObject2 == null) {
          d.g.b.k.aVY("chpiLogoIv");
        }
        ((CdnImageView)localObject2).setRoundCorner(true);
        localObject2 = this.ohN;
        if (localObject2 == null) {
          d.g.b.k.aVY("chpiLogoIv");
        }
        ((CdnImageView)localObject2).setUrl(((rc)localObject1).Ejb);
        localObject2 = this.ohO;
        if (localObject2 == null) {
          d.g.b.k.aVY("chpiNameTv");
        }
        ((TextView)localObject2).setText((CharSequence)((rc)localObject1).Ejc);
        if (!bs.isNullOrNil(((rc)localObject1).Ejd))
        {
          localObject2 = this.ohP;
          if (localObject2 == null) {
            d.g.b.k.aVY("chpiDescTv");
          }
          ((TextView)localObject2).setText((CharSequence)((rc)localObject1).Ejd);
          localObject2 = this.ohP;
          if (localObject2 == null) {
            d.g.b.k.aVY("chpiDescTv");
          }
          ((TextView)localObject2).setVisibility(0);
          label1588:
          if (((rc)localObject1).Ejj == null) {
            break label1894;
          }
          if (bs.isNullOrNil(((rc)localObject1).Ejj.EiU)) {
            break label1867;
          }
          localObject2 = this.ohW;
          if (localObject2 == null) {
            d.g.b.k.aVY("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject2).setText((CharSequence)((rc)localObject1).Ejj.EiU);
          if (bs.isNullOrNil(((rc)localObject1).Ejj.EiV)) {
            break label1803;
          }
          localObject2 = this.ohW;
          if (localObject2 == null) {
            d.g.b.k.aVY("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject2).setTextColor(Color.parseColor(((rc)localObject1).Ejj.EiV));
          label1690:
          if (bs.isNullOrNil(((rc)localObject1).Ejj.EiW)) {
            break label1841;
          }
          localObject2 = this.ohW;
          if (localObject2 == null) {
            d.g.b.k.aVY("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject2).setFillColor(com.tencent.mm.plugin.card.d.l.cH(((rc)localObject1).Ejj.EiW, ((rc)localObject1).Ejj.EiZ));
          label1745:
          localObject1 = this.ohW;
          if (localObject1 == null) {
            d.g.b.k.aVY("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject1).setVisibility(0);
        }
        for (;;)
        {
          localObject1 = y.KTp;
          break;
          localObject2 = this.ohP;
          if (localObject2 == null) {
            d.g.b.k.aVY("chpiDescTv");
          }
          ((TextView)localObject2).setVisibility(8);
          break label1588;
          label1803:
          localObject2 = this.ohW;
          if (localObject2 == null) {
            d.g.b.k.aVY("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject2).setTextColor(CardHomePageNewUI.this.getResources().getColor(2131101179));
          break label1690;
          label1841:
          localObject1 = this.ohW;
          if (localObject1 == null) {
            d.g.b.k.aVY("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject1).setFillColor(0);
          break label1745;
          label1867:
          localObject1 = this.ohW;
          if (localObject1 == null) {
            d.g.b.k.aVY("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject1).setVisibility(8);
          continue;
          label1894:
          localObject1 = this.ohW;
          if (localObject1 == null) {
            d.g.b.k.aVY("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject1).setText((CharSequence)"");
          localObject1 = this.ohW;
          if (localObject1 == null) {
            d.g.b.k.aVY("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject1).setVisibility(8);
        }
        localObject1 = this.ohN;
        if (localObject1 == null) {
          d.g.b.k.aVY("chpiLogoIv");
        }
        ((CdnImageView)localObject1).setRoundCorner(true);
        localObject1 = this.ohN;
        if (localObject1 == null) {
          d.g.b.k.aVY("chpiLogoIv");
        }
        ((CdnImageView)localObject1).setImageResource(2131689865);
        localObject1 = this.ohO;
        if (localObject1 == null) {
          d.g.b.k.aVY("chpiNameTv");
        }
        ((TextView)localObject1).setText((CharSequence)ai.getResources().getString(2131756877));
        localObject1 = this.ohP;
        if (localObject1 == null) {
          d.g.b.k.aVY("chpiDescTv");
        }
        ((TextView)localObject1).setVisibility(8);
        continue;
        localObject1 = this.ohY;
        if (localObject1 == null) {
          d.g.b.k.aVY("chtiTitleTv");
        }
        ((TextView)localObject1).setText(2131764415);
        if (CardHomePageNewUI.n(CardHomePageNewUI.this) != null)
        {
          localObject1 = this.ohZ;
          if (localObject1 == null) {
            d.g.b.k.aVY("chtiDescTv");
          }
          ((TextView)localObject1).setText((CharSequence)CardHomePageNewUI.n(CardHomePageNewUI.this));
          localObject1 = y.KTp;
          continue;
          localObject1 = this.ohY;
          if (localObject1 == null) {
            d.g.b.k.aVY("chtiTitleTv");
          }
          ((TextView)localObject1).setText(2131756948);
          if (CardHomePageNewUI.o(CardHomePageNewUI.this) == 1)
          {
            localObject1 = this.ohZ;
            if (localObject1 == null) {
              d.g.b.k.aVY("chtiDescTv");
            }
            ((TextView)localObject1).setVisibility(0);
            localObject1 = this.oia;
            if (localObject1 == null) {
              d.g.b.k.aVY("chtiRightIv");
            }
            ((ImageView)localObject1).setVisibility(0);
            localObject1 = CardHomePageNewUI.this.bTo();
            if (localObject1 == null)
            {
              localObject1 = this.ohZ;
              if (localObject1 == null) {
                d.g.b.k.aVY("chtiDescTv");
              }
              ((TextView)localObject1).setText((CharSequence)"");
            }
            for (;;)
            {
              localObject1 = this.ohZ;
              if (localObject1 == null) {
                d.g.b.k.aVY("chtiDescTv");
              }
              ((TextView)localObject1).setOnClickListener((View.OnClickListener)new e(this));
              localObject1 = this.oia;
              if (localObject1 == null) {
                d.g.b.k.aVY("chtiRightIv");
              }
              ((ImageView)localObject1).setOnClickListener((View.OnClickListener)new f(this));
              localObject1 = this.oia;
              if (localObject1 == null) {
                d.g.b.k.aVY("chtiRightIv");
              }
              bs.n((View)localObject1, 50, 50, 50, 50);
              break;
              localObject2 = this.ohZ;
              if (localObject2 == null) {
                d.g.b.k.aVY("chtiDescTv");
              }
              ((TextView)localObject2).setText((CharSequence)((ru)localObject1).Ekf);
            }
          }
          localObject1 = this.ohZ;
          if (localObject1 == null) {
            d.g.b.k.aVY("chtiDescTv");
          }
          ((TextView)localObject1).setVisibility(8);
          localObject1 = this.oia;
          if (localObject1 == null) {
            d.g.b.k.aVY("chtiRightIv");
          }
          ((ImageView)localObject1).setVisibility(8);
          continue;
          localObject1 = parama.ohJ;
          if (localObject1 != null)
          {
            localObject2 = this.ohY;
            if (localObject2 == null) {
              d.g.b.k.aVY("chtiTitleTv");
            }
            ((TextView)localObject2).setText((CharSequence)((rh)localObject1).Ejw);
            localObject2 = this.ohZ;
            if (localObject2 == null) {
              d.g.b.k.aVY("chtiDescTv");
            }
            ((TextView)localObject2).setText((CharSequence)((rh)localObject1).Ejx);
            localObject2 = this.ohX;
            if (localObject2 == null) {
              d.g.b.k.aVY("chtiIconIv");
            }
            localObject3 = ((rh)localObject1).Ejv;
            d.g.b.k.g(localObject3, "card_top_cell_icon");
            a((ImageView)localObject2, (String)localObject3);
            localObject2 = this.oic;
            if (localObject2 == null) {
              d.g.b.k.aVY("chtiNewTv");
            }
            if (((rh)localObject1).EjD != 1) {
              break label2659;
            }
            paramInt = 0;
            label2581:
            ((TextView)localObject2).setVisibility(paramInt);
            localObject2 = this.oib;
            if (localObject2 == null) {
              d.g.b.k.aVY("chtiRedDotIv");
            }
            if (((rh)localObject1).EjC != 1) {
              break label2665;
            }
          }
          label2659:
          label2665:
          for (paramInt = 0;; paramInt = 8)
          {
            ((ImageView)localObject2).setVisibility(paramInt);
            localObject1 = y.KTp;
            if (!parama.ohK) {
              break label2671;
            }
            localObject1 = this.oid;
            if (localObject1 == null) {
              d.g.b.k.aVY("chtiDivider");
            }
            ((View)localObject1).setVisibility(0);
            break;
            paramInt = 8;
            break label2581;
          }
          label2671:
          localObject1 = this.oid;
          if (localObject1 == null) {
            d.g.b.k.aVY("chtiDivider");
          }
          ((View)localObject1).setVisibility(8);
        }
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(CardHomePageNewUI.e parame, rc paramrc, ra paramra, int paramInt1, int paramInt2) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(112417);
        CardHomePageNewUI.k(this.oif.ohL);
        CardHomePageNewUI.a(this.oif.ohL, 0);
        CardHomePageNewUI.a(this.oif.ohL, this.oig);
        paramView = this.oif;
        String str = localra.DMR;
        d.g.b.k.g(str, "coupon.user_card_id");
        paramView.Vi(str);
        com.tencent.mm.plugin.report.service.h.wUl.f(16324, new Object[] { Integer.valueOf(1), this.oig.Eja, Integer.valueOf(this.nBr), localra.DMR, Integer.valueOf(2), Integer.valueOf(paramInt3), Integer.valueOf(CardHomePageNewUI.m(this.oif.ohL)) });
        AppMethodBeat.o(112417);
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b
      implements View.OnClickListener
    {
      b(CardHomePageNewUI.e parame, rc paramrc, ra paramra, int paramInt1, int paramInt2) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(112418);
        CardHomePageNewUI.k(this.oif.ohL);
        CardHomePageNewUI.a(this.oif.ohL, 0);
        CardHomePageNewUI.a(this.oif.ohL, this.oig);
        paramView = this.oif;
        String str = localra.DMR;
        d.g.b.k.g(str, "coupon.user_card_id");
        paramView.Vi(str);
        com.tencent.mm.plugin.report.service.h.wUl.f(16324, new Object[] { Integer.valueOf(1), this.oig.Eja, Integer.valueOf(this.nBr), localra.DMR, Integer.valueOf(2), Integer.valueOf(paramInt3), Integer.valueOf(CardHomePageNewUI.m(this.oif.ohL)) });
        AppMethodBeat.o(112418);
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$setModel$1$headerClickListener$1"})
    static final class c
      implements View.OnClickListener
    {
      c(rc paramrc1, CardHomePageNewUI.e parame, rc paramrc2, int paramInt, CardHomePageNewUI.a parama) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(112419);
        ac.i("MicroMsg.CardHomePageNewUI", "click header");
        CardHomePageNewUI.k(jdField_this.ohL);
        CardHomePageNewUI.a(jdField_this.ohL, 0);
        CardHomePageNewUI.a(jdField_this.ohL, this.oij);
        switch (this.oii.EiQ)
        {
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.h.wUl.f(16324, new Object[] { Integer.valueOf(1), this.oii.Eja, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(paramInt), Integer.valueOf(CardHomePageNewUI.m(jdField_this.ohL)) });
          AppMethodBeat.o(112419);
          return;
          paramView = jdField_this.asD;
          d.g.b.k.g(paramView, "itemView");
          paramView = paramView.getContext();
          if (paramView == null)
          {
            paramView = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(112419);
            throw paramView;
          }
          com.tencent.mm.plugin.card.d.b.a((MMActivity)paramView, this.oii.EiR);
          continue;
          paramView = this.oii.EiS;
          com.tencent.mm.plugin.card.d.b.H(paramView.AZE, paramView.AZF, paramView.BGS);
        }
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class e
      implements View.OnClickListener
    {
      e(CardHomePageNewUI.e parame) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(112421);
        CardHomePageNewUI.p(this.oif.ohL);
        AppMethodBeat.o(112421);
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class f
      implements View.OnClickListener
    {
      f(CardHomePageNewUI.e parame) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(112422);
        CardHomePageNewUI.p(this.oif.ohL);
        AppMethodBeat.o(112422);
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class g
      implements View.OnClickListener
    {
      g(CardHomePageNewUI.e parame, int paramInt, rc paramrc) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(112423);
        ac.d("MicroMsg.CardHomePageNewUI", "do collapse coupon layout");
        CardHomePageNewUI.e.b(this.oif, paramInt);
        paramView = this.oif.oie;
        if (paramView != null) {
          paramView.ohI = false;
        }
        paramView = com.tencent.mm.plugin.report.service.h.wUl;
        rc localrc = this.oig;
        if (localrc == null) {
          d.g.b.k.fOy();
        }
        paramView.f(16324, new Object[] { Integer.valueOf(1), localrc.Eja, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(5), Integer.valueOf(paramInt), Integer.valueOf(CardHomePageNewUI.m(this.oif.ohL)) });
        AppMethodBeat.o(112423);
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class h
      implements View.OnClickListener
    {
      h(CardHomePageNewUI.e parame, int paramInt, rc paramrc) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(112424);
        ac.d("MicroMsg.CardHomePageNewUI", "do expand coupon layout");
        CardHomePageNewUI.e.a(this.oif, paramInt);
        paramView = this.oif.oie;
        if (paramView != null) {
          paramView.ohI = true;
        }
        paramView = com.tencent.mm.plugin.report.service.h.wUl;
        rc localrc = this.oig;
        if (localrc == null) {
          d.g.b.k.fOy();
        }
        paramView.f(16324, new Object[] { Integer.valueOf(1), localrc.Eja, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(4), Integer.valueOf(paramInt), Integer.valueOf(CardHomePageNewUI.m(this.oif.ohL)) });
        AppMethodBeat.o(112424);
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$showMiniAppLayout$1$1"})
    static final class i
      implements View.OnClickListener
    {
      i(rc paramrc, CardHomePageNewUI.e parame, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(112425);
        if (this.oii.Eji != null) {
          if (this.oii.Eji == null) {
            break label225;
          }
        }
        label225:
        for (boolean bool = true;; bool = false)
        {
          ac.i("MicroMsg.CardHomePageNewUI", "detail goto mini app %s", new Object[] { Boolean.valueOf(bool) });
          CardHomePageNewUI.k(jdField_this.ohL);
          CardHomePageNewUI.a(jdField_this.ohL, 0);
          CardHomePageNewUI.a(jdField_this.ohL, this.oii);
          com.tencent.mm.plugin.card.d.b.H(this.oii.Eji.AZE, this.oii.Eji.AZF, this.oii.Eji.BGS);
          paramView = com.tencent.mm.plugin.report.service.h.wUl;
          Object localObject = jdField_this.oie;
          if (localObject == null) {
            d.g.b.k.fOy();
          }
          localObject = ((CardHomePageNewUI.a)localObject).ohF;
          if (localObject == null) {
            d.g.b.k.fOy();
          }
          paramView.f(16324, new Object[] { Integer.valueOf(1), ((rc)localObject).Eja, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(6), Integer.valueOf(paramInt), Integer.valueOf(CardHomePageNewUI.m(jdField_this.ohL)) });
          AppMethodBeat.o(112425);
          return;
        }
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "kotlin.jvm.PlatformType", "it", "Lcom/tencent/mm/modelbase/DeprecatedCgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/DeleteMchInListResponse;", "call"})
  static final class f<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    f(CardHomePageNewUI paramCardHomePageNewUI, String paramString) {}
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "kotlin.jvm.PlatformType", "it", "Lcom/tencent/mm/modelbase/DeprecatedCgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetMktCardHomePageResponse;", "call"})
  static final class g<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    g(CardHomePageNewUI paramCardHomePageNewUI) {}
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/DeprecatedCgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetCardPkgMchInfoResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class h<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    h(CardHomePageNewUI paramCardHomePageNewUI, String paramString) {}
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$initView$1", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "paint", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "paint2", "getPaint2", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "onDraw", "c", "Landroid/graphics/Canvas;", "plugin-card_release"})
  public static final class i
    extends RecyclerView.h
  {
    private final Paint oio;
    private final Paint paint;
    
    i()
    {
      AppMethodBeat.i(112446);
      this.paint = new Paint();
      this.oio = new Paint();
      this.paint.setColor(localObject.getResources().getColor(2131100886));
      this.paint.setStyle(Paint.Style.FILL);
      this.paint.setFlags(1);
      this.oio.setColor(localObject.getResources().getColor(2131101179));
      this.oio.setStyle(Paint.Style.FILL);
      this.oio.setFlags(1);
      AppMethodBeat.o(112446);
    }
    
    public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.t paramt)
    {
      AppMethodBeat.i(112445);
      d.g.b.k.h(paramCanvas, "c");
      d.g.b.k.h(paramRecyclerView, "parent");
      d.g.b.k.h(paramt, "state");
      super.a(paramCanvas, paramRecyclerView, paramt);
      paramRecyclerView = CardHomePageNewUI.j(this.ohL);
      if (paramRecyclerView != null)
      {
        int i = paramRecyclerView.getPaddingLeft();
        paramt = CardHomePageNewUI.ohE;
        int k = i + CardHomePageNewUI.bTr();
        int m = paramRecyclerView.getWidth();
        int n = paramRecyclerView.getPaddingRight();
        int i1 = paramRecyclerView.getChildCount();
        i = 0;
        if (i < i1 - 1)
        {
          paramt = paramRecyclerView.getChildAt(i);
          d.g.b.k.g(paramt, "child");
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
            paramt = CardHomePageNewUI.ohE;
          }
          for (int j = CardHomePageNewUI.bTq();; j = 1)
          {
            j = i2 + j;
            if (paramCanvas != null) {
              paramCanvas.drawRect(k, i2, m - n, j, this.paint);
            }
            if (paramCanvas != null) {
              paramCanvas.drawRect(0.0F, i2, k, j, this.oio);
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
      d.g.b.k.h(paramRect, "outRect");
      d.g.b.k.h(paramView, "view");
      d.g.b.k.h(paramRecyclerView, "parent");
      d.g.b.k.h(paramt, "state");
      super.a(paramRect, paramView, paramRecyclerView, paramt);
      if (RecyclerView.bw(paramView) == CardHomePageNewUI.q(this.ohL).getItemCount() - 1)
      {
        ac.d("MicroMsg.CardHomePageNewUI", "is last");
        paramView = CardHomePageNewUI.ohE;
        paramRect.bottom = CardHomePageNewUI.bTq();
        AppMethodBeat.o(112444);
        return;
      }
      paramRect.bottom = 1;
      AppMethodBeat.o(112444);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "parent", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "kotlin.jvm.PlatformType", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "onLoadMore"})
  static final class j
    implements LoadMoreRecyclerView.a
  {
    j(CardHomePageNewUI paramCardHomePageNewUI) {}
    
    public final void bwz()
    {
      AppMethodBeat.i(112447);
      CardHomePageNewUI.r(this.ohL);
      AppMethodBeat.o(112447);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "parent", "Landroid/support/v7/widget/RecyclerView;", "kotlin.jvm.PlatformType", "view", "Landroid/view/View;", "position", "", "id", "", "onItemClick"})
  static final class k
    implements MRecyclerView.a
  {
    k(CardHomePageNewUI paramCardHomePageNewUI) {}
    
    public final void T(View paramView, int paramInt)
    {
      AppMethodBeat.i(112448);
      paramView = CardHomePageNewUI.q(this.ohL).zX(paramInt);
      if (paramView != null)
      {
        ac.i("MicroMsg.CardHomePageNewUI", "click type: %s", new Object[] { Integer.valueOf(paramView.type) });
        Object localObject2;
        switch (paramView.type)
        {
        case 3: 
        default: 
          AppMethodBeat.o(112448);
          return;
        case 2: 
          CardHomePageNewUI.k(this.ohL);
          CardHomePageNewUI.a(this.ohL, 1);
          CardHomePageNewUI.a(this.ohL, paramView.ohF);
          localObject1 = paramView.ohF;
          if (localObject1 == null) {
            d.g.b.k.fOy();
          }
          switch (((rc)localObject1).EiQ)
          {
          }
          for (;;)
          {
            localObject1 = com.tencent.mm.plugin.report.service.h.wUl;
            paramView = paramView.ohF;
            if (paramView == null) {
              d.g.b.k.fOy();
            }
            ((com.tencent.mm.plugin.report.service.h)localObject1).f(16324, new Object[] { Integer.valueOf(2), paramView.Eja, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(paramInt), Integer.valueOf(CardHomePageNewUI.m(this.ohL)) });
            AppMethodBeat.o(112448);
            return;
            localObject1 = (MMActivity)this.ohL;
            localObject2 = paramView.ohF;
            if (localObject2 == null) {
              d.g.b.k.fOy();
            }
            com.tencent.mm.plugin.card.d.b.a((MMActivity)localObject1, ((rc)localObject2).EiR);
            continue;
            localObject1 = paramView.ohF;
            if (localObject1 == null) {
              d.g.b.k.fOy();
            }
            localObject1 = ((rc)localObject1).EiS;
            com.tencent.mm.plugin.card.d.b.H(((rm)localObject1).AZE, ((rm)localObject1).AZF, ((rm)localObject1).BGS);
          }
        case 4: 
          ac.i("MicroMsg.CardHomePageNewUI", "click ticket item");
          localObject1 = new Intent((Context)this.ohL, CardTicketListUI.class);
          paramView = this.ohL;
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject1);
          com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aeD(), "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$initView$3", "onItemClick", "(Landroid/support/v7/widget/RecyclerView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$initView$3", "onItemClick", "(Landroid/support/v7/widget/RecyclerView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.plugin.report.service.h.wUl.f(16322, new Object[] { Integer.valueOf(5) });
          AppMethodBeat.o(112448);
          return;
        case 5: 
          com.tencent.mm.plugin.report.service.h.wUl.f(16322, new Object[] { Integer.valueOf(13) });
          AppMethodBeat.o(112448);
          return;
        }
        Object localObject1 = paramView.ohJ;
        if (localObject1 == null) {
          d.g.b.k.fOy();
        }
        switch (((rh)localObject1).Ejy)
        {
        }
        for (;;)
        {
          localObject1 = paramView.ohJ;
          if (localObject1 == null) {
            d.g.b.k.fOy();
          }
          ((rh)localObject1).EjD = 0;
          paramView = paramView.ohJ;
          if (paramView == null) {
            d.g.b.k.fOy();
          }
          paramView.EjC = 0;
          CardHomePageNewUI.q(this.ohL).cj(paramInt);
          break;
          localObject1 = (MMActivity)this.ohL;
          localObject2 = paramView.ohJ;
          if (localObject2 == null) {
            d.g.b.k.fOy();
          }
          com.tencent.mm.plugin.card.d.b.a((MMActivity)localObject1, ((rh)localObject2).Ejz);
          CardHomePageNewUI.s(this.ohL);
          continue;
          localObject1 = paramView.ohJ;
          if (localObject1 == null) {
            d.g.b.k.fOy();
          }
          localObject1 = ((rh)localObject1).EjA;
          com.tencent.mm.plugin.card.d.b.H(((rm)localObject1).AZE, ((rm)localObject1).AZF, ((rm)localObject1).BGS);
          CardHomePageNewUI.s(this.ohL);
          continue;
          localObject1 = new StringBuilder("click native url: ");
          localObject2 = paramView.ohJ;
          if (localObject2 == null) {
            d.g.b.k.fOy();
          }
          ac.i("MicroMsg.CardHomePageNewUI", ((rh)localObject2).EjB);
          localObject1 = paramView.ohJ;
          if (localObject1 == null) {
            d.g.b.k.fOy();
          }
          if (d.g.b.k.g("weixin://mktcard/cert", ((rh)localObject1).EjB))
          {
            localObject2 = new Intent((Context)this.ohL, CardTicketListUI.class);
            localObject1 = this.ohL;
            localObject2 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject2);
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aeD(), "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$initView$3", "onItemClick", "(Landroid/support/v7/widget/RecyclerView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((CardHomePageNewUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$initView$3", "onItemClick", "(Landroid/support/v7/widget/RecyclerView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            CardHomePageNewUI.s(this.ohL);
          }
        }
      }
      AppMethodBeat.o(112448);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "parent", "Landroid/support/v7/widget/RecyclerView;", "kotlin.jvm.PlatformType", "view", "Landroid/view/View;", "position", "", "id", "", "onItemLongClick"})
  static final class l
    implements MRecyclerView.b
  {
    l(CardHomePageNewUI paramCardHomePageNewUI) {}
    
    public final boolean U(View paramView, final int paramInt)
    {
      AppMethodBeat.i(112452);
      paramView = CardHomePageNewUI.q(this.ohL).zX(paramInt);
      if (paramView != null)
      {
        ac.i("MicroMsg.CardHomePageNewUI", "long click type: %s", new Object[] { Integer.valueOf(paramView.type) });
        switch (paramView.type)
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(112452);
        return false;
        Object localObject = new com.tencent.mm.ui.tools.l((Context)this.ohL.getContext());
        ((com.tencent.mm.ui.tools.l)localObject).a((n.c)new a(this, paramInt));
        ((com.tencent.mm.ui.tools.l)localObject).a((n.d)new b(paramView, this, paramInt));
        ((com.tencent.mm.ui.tools.l)localObject).ftL();
        localObject = com.tencent.mm.plugin.report.service.h.wUl;
        paramView = paramView.ohF;
        if (paramView == null) {
          d.g.b.k.fOy();
        }
        ((com.tencent.mm.plugin.report.service.h)localObject).f(16324, new Object[] { Integer.valueOf(2), paramView.Eja, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(7), Integer.valueOf(paramInt), Integer.valueOf(CardHomePageNewUI.m(this.ohL)) });
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu", "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$initView$4$1$1"})
    static final class a
      implements n.c
    {
      a(CardHomePageNewUI.l paraml, int paramInt) {}
      
      public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
      {
        AppMethodBeat.i(112449);
        paraml.c(1, (CharSequence)this.oip.ohL.getString(2131755707));
        AppMethodBeat.o(112449);
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected", "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$initView$4$1$2"})
    static final class b
      implements n.d
    {
      b(CardHomePageNewUI.a parama, CardHomePageNewUI.l paraml, int paramInt) {}
      
      public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
      {
        AppMethodBeat.i(112451);
        d.g.b.k.g(paramMenuItem, "menuItem");
        switch (paramMenuItem.getItemId())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(112451);
          return;
          com.tencent.mm.ui.base.h.a((Context)jdField_this.ohL.getContext(), jdField_this.ohL.getString(2131756898), "", false, (DialogInterface.OnClickListener)new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(112450);
              Object localObject1 = this.oir.oip.ohL;
              Object localObject2 = this.oir.oiq.ohF;
              if (localObject2 == null) {
                d.g.b.k.fOy();
              }
              localObject2 = ((rc)localObject2).Eja;
              d.g.b.k.g(localObject2, "element!!.card_pack_merchant_id");
              d.g.b.k.h(localObject2, "merchantId");
              ac.i("MicroMsg.CardHomePageNewUI", "do delete merchant: %s", new Object[] { localObject2 });
              new com.tencent.mm.plugin.card.model.a.d((String)localObject2).aBB().b((com.tencent.mm.vending.c.a)new CardHomePageNewUI.f((CardHomePageNewUI)localObject1, (String)localObject2));
              paramAnonymousDialogInterface.dismiss();
              paramAnonymousDialogInterface = com.tencent.mm.plugin.report.service.h.wUl;
              localObject1 = this.oir.oiq.ohF;
              if (localObject1 == null) {
                d.g.b.k.fOy();
              }
              paramAnonymousDialogInterface.f(16324, new Object[] { Integer.valueOf(2), ((rc)localObject1).Eja, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(9), Integer.valueOf(this.oir.mmr), Integer.valueOf(CardHomePageNewUI.m(this.oir.oip.ohL)) });
              AppMethodBeat.o(112450);
            }
          });
          paramMenuItem = com.tencent.mm.plugin.report.service.h.wUl;
          rc localrc = this.oiq.ohF;
          if (localrc == null) {
            d.g.b.k.fOy();
          }
          paramMenuItem.f(16324, new Object[] { Integer.valueOf(2), localrc.Eja, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(8), Integer.valueOf(paramInt), Integer.valueOf(CardHomePageNewUI.m(jdField_this.ohL)) });
        }
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class m
    implements MenuItem.OnMenuItemClickListener
  {
    m(CardHomePageNewUI paramCardHomePageNewUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(112453);
      this.ohL.finish();
      AppMethodBeat.o(112453);
      return false;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick", "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$setFaqIconMenu$1$1"})
  static final class n
    implements MenuItem.OnMenuItemClickListener
  {
    n(rd paramrd, CardHomePageNewUI paramCardHomePageNewUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(112456);
      paramMenuItem = new com.tencent.mm.ui.widget.a.e((Context)jdField_this.getContext(), 1, false);
      paramMenuItem.a((n.c)new n.c()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
        {
          AppMethodBeat.i(112454);
          paramAnonymousl.add(0, 0, 1, (CharSequence)this.oit.ois.Ejo);
          AppMethodBeat.o(112454);
        }
      });
      paramMenuItem.a((n.d)new n.d()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(112455);
          d.g.b.k.g(paramAnonymousMenuItem, "menuItem");
          if (paramAnonymousMenuItem.getItemId() == 0) {
            switch (this.oit.ois.Ejp)
            {
            }
          }
          for (;;)
          {
            AppMethodBeat.o(112455);
            return;
            com.tencent.mm.plugin.card.d.b.a((MMActivity)this.oit.ohL, this.oit.ois.Ejq);
            AppMethodBeat.o(112455);
            return;
            paramAnonymousMenuItem = this.oit.ois.Ejr;
            com.tencent.mm.plugin.card.d.b.H(paramAnonymousMenuItem.AZE, paramAnonymousMenuItem.AZF, paramAnonymousMenuItem.BGS);
          }
        }
      });
      paramMenuItem.cED();
      AppMethodBeat.o(112456);
      return false;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu", "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$showSortSheet$1$1"})
  static final class o
    implements n.c
  {
    o(CardHomePageNewUI paramCardHomePageNewUI) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
    {
      AppMethodBeat.i(112457);
      Iterator localIterator = ((Iterable)CardHomePageNewUI.y(this.ohL)).iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        paraml.add(0, i, 1, (CharSequence)((ru)localIterator.next()).Ekf);
        i += 1;
      }
      AppMethodBeat.o(112457);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected", "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$showSortSheet$1$2"})
  static final class p
    implements n.d
  {
    p(CardHomePageNewUI paramCardHomePageNewUI) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(112459);
      d.g.b.k.g(paramMenuItem, "menuItem");
      paramInt = paramMenuItem.getItemId();
      ac.i("MicroMsg.CardHomePageNewUI", "click item: %s, sortType: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(CardHomePageNewUI.m(this.ohL)) });
      paramMenuItem = CardHomePageNewUI.y(this.ohL).get(paramInt);
      d.g.b.k.g(paramMenuItem, "cardSortInfoList[itemId]");
      paramMenuItem = (ru)paramMenuItem;
      CardHomePageNewUI.d(this.ohL, paramMenuItem.Eke);
      if ((paramMenuItem.Ekd == 1) && (CardHomePageNewUI.m(this.ohL) != 1))
      {
        if (!this.ohL.oiH)
        {
          com.tencent.mm.ui.base.h.a((Context)this.ohL.getContext(), this.ohL.getString(2131756893), this.ohL.getString(2131761885), this.ohL.getString(2131760598), this.ohL.getString(2131757558), false, (DialogInterface.OnClickListener)new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(112458);
              this.oiu.ohL.startActivityForResult(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"), 564);
              AppMethodBeat.o(112458);
            }
          }, null);
          AppMethodBeat.o(112459);
          return;
        }
        CardHomePageNewUI.b(this.ohL, true);
        CardHomePageNewUI.c(this.ohL, 0);
        CardHomePageNewUI.b(this.ohL, 1);
        CardHomePageNewUI.r(this.ohL);
        com.tencent.mm.plugin.report.service.h.wUl.f(16322, new Object[] { Integer.valueOf(15) });
        AppMethodBeat.o(112459);
        return;
      }
      if ((paramMenuItem.Ekd == 2) && (CardHomePageNewUI.m(this.ohL) != 2))
      {
        CardHomePageNewUI.b(this.ohL, true);
        CardHomePageNewUI.c(this.ohL, 0);
        CardHomePageNewUI.b(this.ohL, 2);
        CardHomePageNewUI.r(this.ohL);
        com.tencent.mm.plugin.report.service.h.wUl.f(16322, new Object[] { Integer.valueOf(16) });
        AppMethodBeat.o(112459);
        return;
      }
      if ((paramMenuItem.Ekd == 3) && (CardHomePageNewUI.m(this.ohL) != 3))
      {
        CardHomePageNewUI.b(this.ohL, true);
        CardHomePageNewUI.c(this.ohL, 0);
        CardHomePageNewUI.b(this.ohL, 3);
        CardHomePageNewUI.r(this.ohL);
        com.tencent.mm.plugin.report.service.h.wUl.f(16322, new Object[] { Integer.valueOf(17) });
      }
      AppMethodBeat.o(112459);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v2.CardHomePageNewUI
 * JD-Core Version:    0.7.0.1
 */