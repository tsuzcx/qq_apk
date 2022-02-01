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
import com.tencent.mm.aw.a.a.c;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.aw.o;
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
import com.tencent.mm.protocal.protobuf.qp;
import com.tencent.mm.protocal.protobuf.qq;
import com.tencent.mm.protocal.protobuf.qr;
import com.tencent.mm.protocal.protobuf.qs;
import com.tencent.mm.protocal.protobuf.qt;
import com.tencent.mm.protocal.protobuf.qw;
import com.tencent.mm.protocal.protobuf.qx;
import com.tencent.mm.protocal.protobuf.qz;
import com.tencent.mm.protocal.protobuf.ra;
import com.tencent.mm.protocal.protobuf.rc;
import com.tencent.mm.protocal.protobuf.rk;
import com.tencent.mm.protocal.protobuf.rl;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
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
@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI;", "Lcom/tencent/mm/plugin/card/ui/v2/CardNewBaseUI;", "()V", "cardSortInfoList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/CardSortInfo;", "Lkotlin/collections/ArrayList;", "cardTitleModel", "Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$CardListModel;", "clickArea", "", "clickedCardHomePageElement", "Lcom/tencent/mm/protocal/protobuf/CardHomePageElement;", "emptyModel", "faqItem", "Lcom/tencent/mm/protocal/protobuf/CardHomePageFAQItem;", "firstLoad", "", "getCardHomePageScene", "Lcom/tencent/mm/plugin/card/model/v2/CgiGetMktCardHomePage;", "isAll", "isGotoItem", "isLoading", "mDivider", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "mHomePageAdapter", "Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageAdapter;", "mLoadingView", "Landroid/view/ViewGroup;", "mLoadingView2", "mRecyclerView", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "markReloadHomePage", "needReloadHomePage", "offset", "reqNum", "scene", "shouldShowTicket", "showSort", "sortType", "storeModelList", "ticketModel", "ticketNum", "", "tipsDialog", "Landroid/app/Dialog;", "titleSectionModel", "topCellList", "underModelList", "cardSortInfo", "doDeleteMchInList", "", "merchantId", "doGetCardHomePage", "doGetMchInfo", "lastReceiveTime", "", "getLayoutId", "initFirstScreen", "initView", "loadSnapshot", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinishLocationThings", "ret", "isLocationOk", "onResume", "saveSnapshot", "setFaqIconMenu", "showSortSheet", "updateModelList", "storePageList", "Lcom/tencent/mm/protocal/protobuf/CardHomePageStoreList;", "underPageList", "Lcom/tencent/mm/protocal/protobuf/CardHomePageUnderList;", "_topCellList", "Lcom/tencent/mm/protocal/protobuf/CardHomePageTopCellList;", "CardListModel", "CardSpan", "Companion", "HomePageAdapter", "HomePageVH", "plugin-card_release"})
public final class CardHomePageNewUI
  extends CardNewBaseUI
{
  private static final int cRL;
  private static final int gpa;
  private static final int nEC;
  public static final CardHomePageNewUI.c nED;
  private boolean fLX;
  private Dialog ibM;
  private boolean isLoading;
  private boolean nEA;
  private com.tencent.mm.plugin.card.model.a.g nEB;
  private LoadMoreRecyclerView nEd;
  private d nEe;
  private ViewGroup nEf;
  private RecyclerView.h nEg;
  private ViewGroup nEh;
  private int nEi;
  private boolean nEj;
  private String nEk;
  private final ArrayList<a> nEl;
  private final ArrayList<a> nEm;
  private final ArrayList<a> nEn;
  private a nEo;
  private a nEp;
  private a nEq;
  private a nEr;
  private boolean nEs;
  private int nEt;
  private boolean nEu;
  private int nEv;
  private ArrayList<rk> nEw;
  private boolean nEx;
  private qt nEy;
  private qs nEz;
  private int nuP;
  private int offset;
  private int scene;
  
  static
  {
    AppMethodBeat.i(112470);
    nED = new CardHomePageNewUI.c((byte)0);
    cRL = com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 40);
    gpa = com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 1);
    nEC = com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 16);
    AppMethodBeat.o(112470);
  }
  
  public CardHomePageNewUI()
  {
    AppMethodBeat.i(112469);
    this.nEi = 10;
    this.nEk = "";
    this.nEl = new ArrayList();
    this.nEm = new ArrayList();
    this.nEn = new ArrayList();
    this.fLX = true;
    this.nEt = -1;
    this.nEu = true;
    this.nEw = new ArrayList();
    this.nEy = new qt();
    AppMethodBeat.o(112469);
  }
  
  private final void bMc()
  {
    AppMethodBeat.i(112468);
    ad.i("MicroMsg.CardHomePageNewUI", "do get card Home page: %s, %s", new Object[] { Boolean.valueOf(this.nEj), Boolean.valueOf(this.isLoading) });
    Object localObject;
    if ((this.nEA) || ((!this.nEj) && (!this.isLoading)))
    {
      this.isLoading = true;
      if (this.nEA)
      {
        localObject = this.nEh;
        if (localObject == null) {
          d.g.b.k.aPZ("mLoadingView2");
        }
        ((ViewGroup)localObject).setVisibility(0);
        if (this.nEq != null)
        {
          localObject = this.nEh;
          if (localObject == null) {
            d.g.b.k.aPZ("mLoadingView2");
          }
          localObject = ((ViewGroup)localObject).getLayoutParams();
          if (localObject == null)
          {
            localObject = new v("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            AppMethodBeat.o(112468);
            throw ((Throwable)localObject);
          }
          localObject = (RelativeLayout.LayoutParams)localObject;
          ((RelativeLayout.LayoutParams)localObject).topMargin = com.tencent.mm.cd.a.fromDPToPix((Context)getContext(), 80);
          ViewGroup localViewGroup = this.nEh;
          if (localViewGroup == null) {
            d.g.b.k.aPZ("mLoadingView2");
          }
          localViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
      localObject = bMb();
      if (localObject == null) {
        break label358;
      }
    }
    label358:
    for (int i = ((rk)localObject).CRt;; i = 10)
    {
      this.nEi = i;
      if (this.ibM != null)
      {
        localObject = this.ibM;
        if (localObject == null) {
          d.g.b.k.fvU();
        }
        ((Dialog)localObject).dismiss();
      }
      if (this.nEm.isEmpty())
      {
        localObject = (Context)getContext();
        getContext().getString(2131755726);
        this.ibM = ((Dialog)com.tencent.mm.ui.base.h.b((Context)localObject, getContext().getString(2131760709), true, null));
      }
      this.nEB = new com.tencent.mm.plugin.card.model.a.g(this.offset, this.nEi, this.dpb, this.dqQ, this.nuP);
      localObject = this.nEB;
      if (localObject == null) {
        d.g.b.k.fvU();
      }
      ((com.tencent.mm.plugin.card.model.a.g)localObject).auK().b((com.tencent.mm.vending.c.a)new g(this)).a((com.tencent.mm.vending.e.b)this);
      AppMethodBeat.o(112468);
      return;
    }
  }
  
  public final void V(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(112465);
    ad.i("MicroMsg.CardHomePageNewUI", "location finish: [%s, %s], ret: %s, isOk: %s", new Object[] { Float.valueOf(this.dpb), Float.valueOf(this.dqQ), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    if (this.fLX)
    {
      if ((this.nEv == 1) && (paramInt < 0) && (this.nuP == 1))
      {
        this.nuP = 0;
        if (paramInt == -2) {
          com.tencent.mm.plugin.report.service.h.vKh.f(16322, new Object[] { Integer.valueOf(30) });
        }
      }
      bMc();
      AppMethodBeat.o(112465);
      return;
    }
    if (!paramBoolean) {
      bMl();
    }
    AppMethodBeat.o(112465);
  }
  
  public final void a(qw paramqw, ra paramra, qz paramqz)
  {
    int j = 0;
    AppMethodBeat.i(112467);
    Object localObject;
    int i;
    if (paramqw != null)
    {
      localObject = paramqw.CQJ;
      d.g.b.k.g(localObject, "card_home_page_element");
      if (!((Collection)localObject).isEmpty()) {}
      for (i = 1; i != 0; i = 0)
      {
        paramqw = paramqw.CQJ.iterator();
        while (paramqw.hasNext())
        {
          localObject = (qs)paramqw.next();
          a locala = new a();
          locala.nEE = ((qs)localObject);
          locala.type = 0;
          this.nEm.add(locala);
        }
      }
    }
    if (paramra != null)
    {
      paramqw = paramra.CQJ;
      d.g.b.k.g(paramqw, "card_home_page_element");
      if (!((Collection)paramqw).isEmpty()) {}
      for (i = 1; i != 0; i = 0)
      {
        if (bt.isNullOrNil(paramra.CQV)) {
          paramra.CQV = getString(2131756875);
        }
        if (this.nEp == null)
        {
          this.nEp = new a();
          paramqw = this.nEp;
          if (paramqw == null) {
            d.g.b.k.fvU();
          }
          paramqw.type = 1;
        }
        paramqw = this.nEp;
        if (paramqw == null) {
          d.g.b.k.fvU();
        }
        localObject = paramra.CQV;
        d.g.b.k.g(localObject, "section_title");
        paramqw.QT((String)localObject);
        paramqw = paramra.CQJ.iterator();
        while (paramqw.hasNext())
        {
          paramra = (qs)paramqw.next();
          localObject = new a();
          ((a)localObject).nEE = paramra;
          ((a)localObject).type = 2;
          this.nEn.add(localObject);
        }
      }
    }
    if (paramqz != null)
    {
      paramqw = paramqz.CQU;
      d.g.b.k.g(paramqw, "card_home_page_top_cell");
      if (!((Collection)paramqw).isEmpty()) {}
      for (i = 1; i != 0; i = 0)
      {
        paramqw = paramqz.CQU;
        d.g.b.k.g(paramqw, "card_home_page_top_cell");
        paramqw = ((Iterable)paramqw).iterator();
        i = 0;
        while (paramqw.hasNext())
        {
          paramra = (qx)paramqw.next();
          localObject = new a();
          ((a)localObject).nEI = paramra;
          ((a)localObject).type = 6;
          if (i == paramqz.CQU.size() - 1) {
            ((a)localObject).nEJ = true;
          }
          this.nEl.add(localObject);
          i += 1;
        }
      }
    }
    this.nEr = new a();
    paramqw = this.nEr;
    if (paramqw == null) {
      d.g.b.k.fvU();
    }
    paramqw.type = 5;
    if ((this.nEm.isEmpty()) && (this.nEn.isEmpty()))
    {
      i = j;
      if (!((Collection)this.nEl).isEmpty()) {
        i = 1;
      }
      if (i != 0)
      {
        this.nEo = new a();
        paramqw = this.nEo;
        if (paramqw == null) {
          d.g.b.k.fvU();
        }
        paramqw.type = 7;
        AppMethodBeat.o(112467);
        return;
      }
    }
    this.nEo = null;
    AppMethodBeat.o(112467);
  }
  
  public final void bMa()
  {
    AppMethodBeat.i(112461);
    qt localqt = this.nEy;
    if (localqt != null)
    {
      if (!bt.isNullOrNil(localqt.CQD))
      {
        removeAllOptionMenu();
        addIconOptionMenu(0, 0, 2131690603, (MenuItem.OnMenuItemClickListener)new n(localqt, this));
      }
      AppMethodBeat.o(112461);
      return;
    }
    AppMethodBeat.o(112461);
  }
  
  public final rk bMb()
  {
    AppMethodBeat.i(112466);
    Iterator localIterator = this.nEw.iterator();
    while (localIterator.hasNext())
    {
      rk localrk = (rk)localIterator.next();
      if (localrk.CRs == this.nuP)
      {
        AppMethodBeat.o(112466);
        return localrk;
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
    this.nEd = ((LoadMoreRecyclerView)localObject1);
    localObject1 = this.nEd;
    if (localObject1 == null) {
      d.g.b.k.aPZ("mRecyclerView");
    }
    getContext();
    ((LoadMoreRecyclerView)localObject1).setLayoutManager((RecyclerView.i)new LinearLayoutManager());
    this.nEe = new d();
    localObject1 = this.nEd;
    if (localObject1 == null) {
      d.g.b.k.aPZ("mRecyclerView");
    }
    Object localObject2 = this.nEe;
    if (localObject2 == null) {
      d.g.b.k.aPZ("mHomePageAdapter");
    }
    ((LoadMoreRecyclerView)localObject1).setAdapter((RecyclerView.a)localObject2);
    localObject1 = LayoutInflater.from((Context)this);
    localObject2 = this.nEd;
    if (localObject2 == null) {
      d.g.b.k.aPZ("mRecyclerView");
    }
    localObject1 = ((LayoutInflater)localObject1).inflate(2131493294, (ViewGroup)localObject2, false);
    if (localObject1 == null)
    {
      localObject1 = new v("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(112464);
      throw ((Throwable)localObject1);
    }
    this.nEf = ((ViewGroup)localObject1);
    localObject1 = findViewById(2131298312);
    d.g.b.k.g(localObject1, "findViewById(R.id.chpu_loading_layout)");
    this.nEh = ((ViewGroup)localObject1);
    localObject1 = this.nEd;
    if (localObject1 == null) {
      d.g.b.k.aPZ("mRecyclerView");
    }
    localObject2 = this.nEf;
    if (localObject2 == null) {
      d.g.b.k.aPZ("mLoadingView");
    }
    ((LoadMoreRecyclerView)localObject1).setLoadingView((View)localObject2);
    this.nEg = ((RecyclerView.h)new i(this));
    localObject1 = this.nEd;
    if (localObject1 == null) {
      d.g.b.k.aPZ("mRecyclerView");
    }
    localObject2 = this.nEg;
    if (localObject2 == null) {
      d.g.b.k.aPZ("mDivider");
    }
    ((LoadMoreRecyclerView)localObject1).b((RecyclerView.h)localObject2);
    localObject1 = this.nEd;
    if (localObject1 == null) {
      d.g.b.k.aPZ("mRecyclerView");
    }
    ((LoadMoreRecyclerView)localObject1).setOnLoadingStateChangedListener((LoadMoreRecyclerView.a)new j(this));
    localObject1 = this.nEd;
    if (localObject1 == null) {
      d.g.b.k.aPZ("mRecyclerView");
    }
    ((LoadMoreRecyclerView)localObject1).setOnItemClickListener((MRecyclerView.a)new k(this));
    localObject1 = this.nEd;
    if (localObject1 == null) {
      d.g.b.k.aPZ("mRecyclerView");
    }
    ((LoadMoreRecyclerView)localObject1).setOnItemLongClickListener((MRecyclerView.b)new l(this));
    localObject1 = new qw();
    localObject2 = new ra();
    qz localqz = new qz();
    rl localrl = new rl();
    Object localObject3 = com.tencent.mm.plugin.card.model.a.a.nuE;
    localObject3 = this.nEy;
    d.g.b.k.h(localObject1, "storeList");
    d.g.b.k.h(localObject2, "underList");
    d.g.b.k.h(localqz, "topList");
    d.g.b.k.h(localrl, "cardSortInfoList");
    ad.i(com.tencent.mm.plugin.card.model.a.a.access$getTAG$cp(), "load home page snapshot");
    Object localObject4 = com.tencent.mm.kernel.g.afB();
    d.g.b.k.g(localObject4, "MMKernel.storage()");
    localObject4 = (String)((com.tencent.mm.kernel.e)localObject4).afk().i(ae.a.Fui);
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
      ((qw)localObject1).parseFrom((byte[])localObject4);
      i = 1;
    }
    localObject4 = com.tencent.mm.kernel.g.afB();
    d.g.b.k.g(localObject4, "MMKernel.storage()");
    localObject4 = (String)((com.tencent.mm.kernel.e)localObject4).afk().i(ae.a.Fuj);
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
      ((ra)localObject2).parseFrom((byte[])localObject4);
      i = 1;
    }
    localObject4 = com.tencent.mm.kernel.g.afB();
    d.g.b.k.g(localObject4, "MMKernel.storage()");
    localObject4 = (String)((com.tencent.mm.kernel.e)localObject4).afk().i(ae.a.Fuk);
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
      localqz.parseFrom((byte[])localObject4);
      i = 1;
    }
    localObject4 = com.tencent.mm.kernel.g.afB();
    d.g.b.k.g(localObject4, "MMKernel.storage()");
    localObject4 = (String)((com.tencent.mm.kernel.e)localObject4).afk().i(ae.a.Ful);
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
      localrl.parseFrom((byte[])localObject4);
      i = 1;
    }
    localObject4 = com.tencent.mm.kernel.g.afB();
    d.g.b.k.g(localObject4, "MMKernel.storage()");
    localObject4 = (String)((com.tencent.mm.kernel.e)localObject4).afk().i(ae.a.Fum);
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
        ((qt)localObject3).parseFrom((byte[])localObject4);
        i = j;
      }
    }
    for (;;)
    {
      this.nEw.clear();
      this.nEw.addAll((Collection)localrl.CRv);
      a((qw)localObject1, (ra)localObject2, localqz);
      if ((i == 0) && (this.nEm.isEmpty()) && (this.nEn.isEmpty()))
      {
        ad.i("MicroMsg.CardHomePageNewUI", "show init view");
        localObject1 = new a();
        ((a)localObject1).type = 3;
        localObject2 = new a();
        ((a)localObject2).type = 3;
        this.nEm.add(localObject1);
        this.nEm.add(localObject2);
      }
      bMa();
      localObject1 = this.nEd;
      if (localObject1 == null) {
        d.g.b.k.aPZ("mRecyclerView");
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
    this.nEv = 1;
    paramBundle = com.tencent.mm.kernel.g.afB();
    d.g.b.k.g(paramBundle, "MMKernel.storage()");
    this.nuP = paramBundle.afk().getInt(ae.a.Fuz, 1);
    if (this.nuP == 0) {
      this.nuP = 1;
    }
    if (this.nEv == 1) {
      com.tencent.mm.plugin.report.service.h.vKh.f(16322, new Object[] { Integer.valueOf(14) });
    }
    ad.i("MicroMsg.CardHomePageNewUI", "on create, scene: %s", new Object[] { Integer.valueOf(this.scene) });
    setBackBtn((MenuItem.OnMenuItemClickListener)new CardHomePageNewUI.m(this));
    com.tencent.mm.plugin.report.service.h.vKh.f(16322, new Object[] { Integer.valueOf(4) });
    ((com.tencent.mm.pluginsdk.wallet.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.b.class)).gf(8, 2);
    AppMethodBeat.o(112460);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(112462);
    super.onDestroy();
    Object localObject1 = com.tencent.mm.kernel.g.afB();
    d.g.b.k.g(localObject1, "MMKernel.storage()");
    ((com.tencent.mm.kernel.e)localObject1).afk().set(ae.a.Fuz, Integer.valueOf(this.nuP));
    if (this.nEB != null)
    {
      localObject1 = this.nEB;
      if (localObject1 == null) {
        d.g.b.k.fvU();
      }
      ((com.tencent.mm.plugin.card.model.a.g)localObject1).cancel();
      this.nEB = null;
    }
    com.tencent.mm.plugin.card.b.k.bIK();
    ad.i("MicroMsg.CardHomePageNewUI", "do save snap shot");
    Object localObject3 = new qw();
    ((qw)localObject3).CQJ = new LinkedList();
    localObject1 = this.nEm.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((a)((Iterator)localObject1).next()).nEE;
      if (localObject2 != null) {
        ((qw)localObject3).CQJ.add(localObject2);
      }
    }
    Object localObject2 = new ra();
    localObject1 = this.nEp;
    if (localObject1 != null) {}
    for (localObject1 = ((a)localObject1).bMf();; localObject1 = null)
    {
      ((ra)localObject2).CQV = ((String)localObject1);
      ((ra)localObject2).CQJ = new LinkedList();
      localObject1 = this.nEn.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject4 = ((a)((Iterator)localObject1).next()).nEE;
        if (localObject4 != null) {
          ((ra)localObject2).CQJ.add(localObject4);
        }
      }
    }
    qz localqz = new qz();
    localObject1 = this.nEl.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject4 = ((a)((Iterator)localObject1).next()).nEI;
      if (localObject4 != null) {
        localqz.CQU.add(localObject4);
      }
    }
    Object localObject4 = new rl();
    ((rl)localObject4).CRv.addAll((Collection)this.nEw);
    localObject1 = com.tencent.mm.plugin.card.model.a.a.nuE;
    localObject1 = this.nEy;
    d.g.b.k.h(localObject3, "storeList");
    d.g.b.k.h(localObject2, "underList");
    d.g.b.k.h(localqz, "topList");
    d.g.b.k.h(localObject4, "sortInfoList");
    ad.i(com.tencent.mm.plugin.card.model.a.a.access$getTAG$cp(), "save home page snapshot");
    localObject3 = ((qw)localObject3).toByteArray();
    d.g.b.k.g(localObject3, "storeList.toByteArray()");
    localObject3 = new String((byte[])localObject3, d.n.d.ISO_8859_1);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.afB();
    d.g.b.k.g(locale, "MMKernel.storage()");
    locale.afk().set(ae.a.Fui, localObject3);
    localObject2 = ((ra)localObject2).toByteArray();
    d.g.b.k.g(localObject2, "underList.toByteArray()");
    localObject2 = new String((byte[])localObject2, d.n.d.ISO_8859_1);
    localObject3 = com.tencent.mm.kernel.g.afB();
    d.g.b.k.g(localObject3, "MMKernel.storage()");
    ((com.tencent.mm.kernel.e)localObject3).afk().set(ae.a.Fuj, localObject2);
    localObject2 = localqz.toByteArray();
    d.g.b.k.g(localObject2, "topList.toByteArray()");
    localObject2 = new String((byte[])localObject2, d.n.d.ISO_8859_1);
    localObject3 = com.tencent.mm.kernel.g.afB();
    d.g.b.k.g(localObject3, "MMKernel.storage()");
    ((com.tencent.mm.kernel.e)localObject3).afk().set(ae.a.Fuk, localObject2);
    localObject2 = ((rl)localObject4).toByteArray();
    d.g.b.k.g(localObject2, "sortInfoList.toByteArray()");
    localObject2 = new String((byte[])localObject2, d.n.d.ISO_8859_1);
    localObject3 = com.tencent.mm.kernel.g.afB();
    d.g.b.k.g(localObject3, "MMKernel.storage()");
    ((com.tencent.mm.kernel.e)localObject3).afk().set(ae.a.Ful, localObject2);
    if (localObject1 != null)
    {
      localObject1 = ((qt)localObject1).toByteArray();
      d.g.b.k.g(localObject1, "faqItem.toByteArray()");
      localObject1 = new String((byte[])localObject1, d.n.d.ISO_8859_1);
      localObject2 = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(localObject2, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject2).afk().set(ae.a.Fum, localObject1);
    }
    AppMethodBeat.o(112462);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(112463);
    super.onResume();
    if ((this.nEs) && (this.nEz != null) && (this.nEt != -1))
    {
      Object localObject = this.nEz;
      if (localObject == null) {
        d.g.b.k.fvU();
      }
      localObject = ((qs)localObject).CQp;
      d.g.b.k.g(localObject, "clickedCardHomePageElement!!.card_pack_merchant_id");
      qs localqs = this.nEz;
      if (localqs == null) {
        d.g.b.k.fvU();
      }
      long l = localqs.CQC;
      ad.i("MicroMsg.CardHomePageNewUI", "do get mch infoset: %s", new Object[] { localObject });
      new com.tencent.mm.plugin.card.model.a.f((String)localObject, l, this.dpb, this.dqQ, this.nuP).auK().b((com.tencent.mm.vending.c.a)new h(this, (String)localObject));
      this.nEs = false;
      this.nEz = null;
      AppMethodBeat.o(112463);
      return;
    }
    if (this.nEx)
    {
      this.nEA = true;
      this.offset = 0;
      this.nEx = false;
      bMc();
    }
    AppMethodBeat.o(112463);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$CardListModel;", "", "(Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI;)V", "element", "Lcom/tencent/mm/protocal/protobuf/CardHomePageElement;", "getElement", "()Lcom/tencent/mm/protocal/protobuf/CardHomePageElement;", "setElement", "(Lcom/tencent/mm/protocal/protobuf/CardHomePageElement;)V", "expandState", "", "getExpandState", "()Z", "setExpandState", "(Z)V", "hasRender", "getHasRender", "setHasRender", "sectionTitle", "", "getSectionTitle", "()Ljava/lang/String;", "setSectionTitle", "(Ljava/lang/String;)V", "showDivider", "getShowDivider", "setShowDivider", "topElement", "Lcom/tencent/mm/protocal/protobuf/CardHomePageTopCell;", "getTopElement", "()Lcom/tencent/mm/protocal/protobuf/CardHomePageTopCell;", "setTopElement", "(Lcom/tencent/mm/protocal/protobuf/CardHomePageTopCell;)V", "type", "", "getType", "()I", "setType", "(I)V", "plugin-card_release"})
  public final class a
  {
    qs nEE;
    public String nEF;
    boolean nEG;
    boolean nEH;
    qx nEI;
    boolean nEJ;
    int type;
    
    public final void QT(String paramString)
    {
      AppMethodBeat.i(112405);
      d.g.b.k.h(paramString, "<set-?>");
      this.nEF = paramString;
      AppMethodBeat.o(112405);
    }
    
    public final String bMf()
    {
      AppMethodBeat.i(112404);
      String str = this.nEF;
      if (str == null) {
        d.g.b.k.aPZ("sectionTitle");
      }
      AppMethodBeat.o(112404);
      return str;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH;", "Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI;", "(Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI;)V", "appendUnderList", "", "model", "Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$CardListModel;", "getItemCount", "", "getItemViewType", "position", "getModelByPos", "getPosByMerchantId", "merchantId", "", "moveStoreToUnderList", "", "element", "Lcom/tencent/mm/protocal/protobuf/CardHomePageElement;", "onBindViewHolder", "holder", "payloads", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "removeModelByMId", "removeTitleSection", "replaceModelByMId", "mchInfo", "plugin-card_release"})
  public final class d
    extends RecyclerView.a<CardHomePageNewUI.e>
  {
    private int QV(String paramString)
    {
      int k = 0;
      AppMethodBeat.i(112415);
      d.g.b.k.h(paramString, "merchantId");
      if (CardHomePageNewUI.g(this.nEK) != null) {}
      for (int i = 1;; i = 0)
      {
        if (CardHomePageNewUI.f(this.nEK) != null) {
          i += 1;
        }
        for (;;)
        {
          Iterator localIterator = ((Iterable)CardHomePageNewUI.a(this.nEK)).iterator();
          int j = 0;
          Object localObject;
          while (localIterator.hasNext())
          {
            localObject = ((CardHomePageNewUI.a)localIterator.next()).nEE;
            if (localObject != null) {}
            for (localObject = ((qs)localObject).CQp; d.g.b.k.g(localObject, paramString); localObject = null)
            {
              AppMethodBeat.o(112415);
              return i + j;
            }
            j += 1;
          }
          i = CardHomePageNewUI.a(this.nEK).size() + i - 1;
          if (CardHomePageNewUI.c(this.nEK) != null) {
            i += 1;
          }
          for (;;)
          {
            localIterator = ((Iterable)CardHomePageNewUI.b(this.nEK)).iterator();
            j = k;
            while (localIterator.hasNext())
            {
              localObject = ((CardHomePageNewUI.a)localIterator.next()).nEE;
              if (localObject != null) {}
              for (localObject = ((qs)localObject).CQp; d.g.b.k.g(localObject, paramString); localObject = null)
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
    
    public final void QU(String paramString)
    {
      AppMethodBeat.i(112414);
      d.g.b.k.h(paramString, "merchantId");
      Iterator localIterator = CardHomePageNewUI.a(this.nEK).iterator();
      CardHomePageNewUI.a locala;
      Object localObject;
      while (localIterator.hasNext())
      {
        locala = (CardHomePageNewUI.a)localIterator.next();
        localObject = locala.nEE;
        if (localObject != null) {}
        for (localObject = ((qs)localObject).CQp; d.g.b.k.g(localObject, paramString); localObject = null)
        {
          CardHomePageNewUI.a(this.nEK).remove(locala);
          paramString = CardHomePageNewUI.j(this.nEK).getAdapter();
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
      localIterator = CardHomePageNewUI.b(this.nEK).iterator();
      while (localIterator.hasNext())
      {
        locala = (CardHomePageNewUI.a)localIterator.next();
        localObject = locala.nEE;
        if (localObject != null) {}
        for (localObject = ((qs)localObject).CQp; d.g.b.k.g(localObject, paramString); localObject = null)
        {
          CardHomePageNewUI.b(this.nEK).remove(locala);
          if (CardHomePageNewUI.b(this.nEK).size() != 0) {
            break label231;
          }
          CardHomePageNewUI.d(this.nEK);
          paramString = CardHomePageNewUI.j(this.nEK).getAdapter();
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
    
    public final void a(String paramString, qs paramqs)
    {
      AppMethodBeat.i(112416);
      d.g.b.k.h(paramString, "merchantId");
      d.g.b.k.h(paramqs, "mchInfo");
      Iterator localIterator = CardHomePageNewUI.a(this.nEK).iterator();
      CardHomePageNewUI.a locala;
      Object localObject;
      int i;
      while (localIterator.hasNext())
      {
        locala = (CardHomePageNewUI.a)localIterator.next();
        localObject = locala.nEE;
        if (localObject != null) {}
        for (localObject = ((qs)localObject).CQp; d.g.b.k.g(localObject, paramString); localObject = null)
        {
          locala.nEE = paramqs;
          i = QV(paramString);
          if (i < 0) {
            break label130;
          }
          paramString = CardHomePageNewUI.j(this.nEK).getAdapter();
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
      localIterator = CardHomePageNewUI.b(this.nEK).iterator();
      while (localIterator.hasNext())
      {
        locala = (CardHomePageNewUI.a)localIterator.next();
        localObject = locala.nEE;
        if (localObject != null) {}
        for (localObject = ((qs)localObject).CQp; d.g.b.k.g(localObject, paramString); localObject = null)
        {
          locala.nEE = paramqs;
          i = QV(paramString);
          if (i < 0) {
            break label249;
          }
          paramString = CardHomePageNewUI.j(this.nEK).getAdapter();
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
      ArrayList localArrayList = CardHomePageNewUI.a(this.nEK);
      int i;
      int j;
      if (localArrayList != null)
      {
        i = localArrayList.size();
        localArrayList = CardHomePageNewUI.b(this.nEK);
        if (localArrayList == null) {
          break label145;
        }
        j = localArrayList.size();
        label48:
        if (CardHomePageNewUI.c(this.nEK) == null) {
          break label174;
        }
      }
      label145:
      label156:
      label174:
      for (int k = 1;; k = 0)
      {
        if (CardHomePageNewUI.e(this.nEK) != null) {}
        for (int m = 1;; m = 0)
        {
          if (CardHomePageNewUI.f(this.nEK) != null) {}
          for (int n = 1;; n = 0)
          {
            localArrayList = CardHomePageNewUI.g(this.nEK);
            int i1;
            if (localArrayList != null)
            {
              i1 = localArrayList.size();
              label107:
              if (CardHomePageNewUI.h(this.nEK) == null) {
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
      CardHomePageNewUI.a locala = zh(paramInt);
      if (locala != null)
      {
        paramInt = locala.type;
        AppMethodBeat.o(112410);
        return paramInt;
      }
      AppMethodBeat.o(112410);
      return 3;
    }
    
    public final CardHomePageNewUI.a zh(int paramInt)
    {
      int j = 0;
      AppMethodBeat.i(112413);
      Object localObject1 = CardHomePageNewUI.a(this.nEK);
      Object localObject2;
      if (localObject1 != null)
      {
        localObject1 = Integer.valueOf(((ArrayList)localObject1).size());
        localObject2 = CardHomePageNewUI.a(this.nEK);
        if (localObject2 == null) {
          break label159;
        }
        localObject2 = Integer.valueOf(((ArrayList)localObject2).size());
        label56:
        if (CardHomePageNewUI.c(this.nEK) == null) {
          break label165;
        }
      }
      label159:
      label165:
      for (boolean bool = true;; bool = false)
      {
        ad.d("MicroMsg.CardHomePageNewUI", "pos: %s, sSize: %s, uSize: %s, title: %s", new Object[] { Integer.valueOf(paramInt), localObject1, localObject2, Boolean.valueOf(bool) });
        localObject1 = CardHomePageNewUI.g(this.nEK);
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
      localObject1 = CardHomePageNewUI.f(this.nEK);
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
      localObject1 = CardHomePageNewUI.h(this.nEK);
      if ((localObject1 != null) && (paramInt == i))
      {
        AppMethodBeat.o(112413);
        return localObject1;
      }
      localObject1 = CardHomePageNewUI.a(this.nEK);
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
      if (CardHomePageNewUI.c(this.nEK) != null)
      {
        j += 1;
        i = j;
        if (paramInt == j)
        {
          localObject1 = CardHomePageNewUI.c(this.nEK);
          AppMethodBeat.o(112413);
          return localObject1;
        }
      }
      localObject1 = CardHomePageNewUI.b(this.nEK);
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
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "viewType", "", "(Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI;Landroid/view/View;I)V", "chpiCouponLayout", "Landroid/widget/LinearLayout;", "getChpiCouponLayout", "()Landroid/widget/LinearLayout;", "setChpiCouponLayout", "(Landroid/widget/LinearLayout;)V", "chpiDescTv", "Landroid/widget/TextView;", "getChpiDescTv", "()Landroid/widget/TextView;", "setChpiDescTv", "(Landroid/widget/TextView;)V", "chpiExpandIv", "Landroid/widget/ImageView;", "getChpiExpandIv", "()Landroid/widget/ImageView;", "setChpiExpandIv", "(Landroid/widget/ImageView;)V", "chpiExpandLayout", "getChpiExpandLayout", "setChpiExpandLayout", "chpiExpandTv", "getChpiExpandTv", "setChpiExpandTv", "chpiHeaderLayout", "getChpiHeaderLayout", "setChpiHeaderLayout", "chpiLabelLayout", "getChpiLabelLayout", "setChpiLabelLayout", "chpiLogoIv", "Lcom/tencent/mm/pluginsdk/ui/applet/CdnImageView;", "getChpiLogoIv", "()Lcom/tencent/mm/pluginsdk/ui/applet/CdnImageView;", "setChpiLogoIv", "(Lcom/tencent/mm/pluginsdk/ui/applet/CdnImageView;)V", "chpiMchLabelTv", "Lcom/tencent/mm/plugin/card/ui/v2/CardLabelTextView;", "getChpiMchLabelTv", "()Lcom/tencent/mm/plugin/card/ui/v2/CardLabelTextView;", "setChpiMchLabelTv", "(Lcom/tencent/mm/plugin/card/ui/v2/CardLabelTextView;)V", "chpiNameTv", "getChpiNameTv", "setChpiNameTv", "chtiDescTv", "getChtiDescTv", "setChtiDescTv", "chtiDivider", "getChtiDivider", "()Landroid/view/View;", "setChtiDivider", "(Landroid/view/View;)V", "chtiIconIv", "getChtiIconIv", "setChtiIconIv", "chtiNewTv", "getChtiNewTv", "setChtiNewTv", "chtiRedDotIv", "getChtiRedDotIv", "setChtiRedDotIv", "chtiRightIv", "getChtiRightIv", "setChtiRightIv", "chtiTitleTv", "getChtiTitleTv", "setChtiTitleTv", "model", "Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$CardListModel;", "Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI;", "getModel", "()Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$CardListModel;", "setModel", "(Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$CardListModel;)V", "sectionTitleTv", "getSectionTitleTv", "setSectionTitleTv", "addCouponView", "", "view", "appendCouponView", "offset", "len", "position", "collapseCouponLayout", "expandCouponLayout", "gotoCardDetailUI", "cardId", "", "setCardBg", "imageView", "url", "radius", "", "defaultRes", "setIcon", "useBackendExpandState", "", "showCollapseLayout", "showExpandLayout", "showMiniAppLayout", "updateCardLabelLayout", "couponLabelList", "", "Lcom/tencent/mm/protocal/protobuf/CardElementCouponLabel;", "labelLayout", "labelList", "Lcom/tencent/mm/protocal/protobuf/CardElementMchLabel;", "updateExpandLayout", "isExpended", "plugin-card_release"})
  public final class e
    extends RecyclerView.v
  {
    public TextView nEL;
    public CdnImageView nEM;
    public TextView nEN;
    public TextView nEO;
    public LinearLayout nEP;
    public LinearLayout nEQ;
    public LinearLayout nER;
    public LinearLayout nES;
    public TextView nET;
    public ImageView nEU;
    public CardLabelTextView nEV;
    public ImageView nEW;
    public TextView nEX;
    public TextView nEY;
    public ImageView nEZ;
    public ImageView nFa;
    public TextView nFb;
    public View nFc;
    CardHomePageNewUI.a nFd;
    
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
        this.nEM = ((CdnImageView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298303);
        d.g.b.k.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_username_tv)");
        this.nEN = ((TextView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298293);
        d.g.b.k.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_desc_tv)");
        this.nEO = ((TextView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298298);
        d.g.b.k.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_label_layout)");
        this.nEQ = ((LinearLayout)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298292);
        d.g.b.k.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_coupon_layout)");
        this.nER = ((LinearLayout)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298295);
        d.g.b.k.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_expand_layout)");
        this.nES = ((LinearLayout)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298294);
        d.g.b.k.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_expand_iv)");
        this.nEU = ((ImageView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298296);
        d.g.b.k.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_expand_tv)");
        this.nET = ((TextView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298300);
        d.g.b.k.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_mch_label_tv)");
        this.nEV = ((CardLabelTextView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298297);
        d.g.b.k.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_header_layout)");
        this.nEP = ((LinearLayout)CardHomePageNewUI.this);
        AppMethodBeat.o(112438);
        return;
        this$1 = paramInt.findViewById(2131298301);
        d.g.b.k.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_section_title)");
        this.nEL = ((TextView)CardHomePageNewUI.this);
        AppMethodBeat.o(112438);
        return;
        this$1 = paramInt.findViewById(2131298299);
        d.g.b.k.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_logo_iv)");
        this.nEM = ((CdnImageView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298303);
        d.g.b.k.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_username_tv)");
        this.nEN = ((TextView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298293);
        d.g.b.k.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_desc_tv)");
        this.nEO = ((TextView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298300);
        d.g.b.k.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_mch_label_tv)");
        this.nEV = ((CardLabelTextView)CardHomePageNewUI.this);
        AppMethodBeat.o(112438);
        return;
        this$1 = paramInt.findViewById(2131298299);
        d.g.b.k.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_logo_iv)");
        this.nEM = ((CdnImageView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298303);
        d.g.b.k.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_username_tv)");
        this.nEN = ((TextView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298293);
        d.g.b.k.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_desc_tv)");
        this.nEO = ((TextView)CardHomePageNewUI.this);
        AppMethodBeat.o(112438);
        return;
        this$1 = paramInt.findViewById(2131298332);
        d.g.b.k.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_icon_iv)");
        this.nEW = ((ImageView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298336);
        d.g.b.k.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_title_tv)");
        this.nEX = ((TextView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298330);
        d.g.b.k.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_desc_tv)");
        this.nEY = ((TextView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298335);
        d.g.b.k.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_right_iv)");
        this.nEZ = ((ImageView)CardHomePageNewUI.this);
        AppMethodBeat.o(112438);
        return;
        this$1 = paramInt.findViewById(2131298332);
        d.g.b.k.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_icon_iv)");
        this.nEW = ((ImageView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298336);
        d.g.b.k.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_title_tv)");
        this.nEX = ((TextView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298330);
        d.g.b.k.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_desc_tv)");
        this.nEY = ((TextView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298335);
        d.g.b.k.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_right_iv)");
        this.nEZ = ((ImageView)CardHomePageNewUI.this);
        AppMethodBeat.o(112438);
        return;
        this$1 = paramInt.findViewById(2131298332);
        d.g.b.k.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_icon_iv)");
        this.nEW = ((ImageView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298336);
        d.g.b.k.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_title_tv)");
        this.nEX = ((TextView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298330);
        d.g.b.k.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_desc_tv)");
        this.nEY = ((TextView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298335);
        d.g.b.k.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_right_iv)");
        this.nEZ = ((ImageView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298334);
        d.g.b.k.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_reddot_iv)");
        this.nFa = ((ImageView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298333);
        d.g.b.k.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_new_tv)");
        this.nFb = ((TextView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298331);
        d.g.b.k.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_divider)");
        this.nFc = CardHomePageNewUI.this;
      }
    }
    
    private final void R(int paramInt1, int paramInt2, final int paramInt3)
    {
      AppMethodBeat.i(112428);
      Object localObject1 = this.nFd;
      if (localObject1 == null) {
        d.g.b.k.fvU();
      }
      localObject1 = ((CardHomePageNewUI.a)localObject1).nEE;
      if (localObject1 == null) {
        d.g.b.k.fvU();
      }
      Object localObject2 = ((qs)localObject1).CQu;
      d.g.b.k.g(localObject2, "el!!.card_element_coupon_list");
      localObject2 = ((Iterable)localObject2).iterator();
      int k = 0;
      int i = 0;
      if (((Iterator)localObject2).hasNext())
      {
        final qq localqq = (qq)((Iterator)localObject2).next();
        int j = i;
        if (k >= paramInt1)
        {
          if (localqq.CPX != 1) {
            break label487;
          }
          localObject3 = this.nER;
          if (localObject3 == null) {
            d.g.b.k.aPZ("chpiCouponLayout");
          }
          localObject3 = LayoutInflater.from(((LinearLayout)localObject3).getContext());
          localLinearLayout = this.nER;
          if (localLinearLayout == null) {
            d.g.b.k.aPZ("chpiCouponLayout");
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
          if (!bt.isNullOrNil(localqq.CQa)) {
            ((TextView)localObject4).setTextColor(com.tencent.mm.plugin.card.d.l.cC(localqq.CQa, localqq.CQb));
          }
          d.g.b.k.g(localObject4, "titleTv");
          ((TextView)localObject4).setText((CharSequence)localqq.CPR);
          ((CdnImageView)localObject5).setUrl(localqq.CPY);
          if (!bt.isNullOrNil(localqq.CQc)) {
            ((TextView)localObject6).setTextColor(com.tencent.mm.plugin.card.d.l.cC(localqq.CQc, localqq.CQd));
          }
          d.g.b.k.g(localObject6, "descTv");
          ((TextView)localObject6).setText((CharSequence)localqq.CPS);
          localObject4 = localqq.CPW;
          d.g.b.k.g(localObject4, "coupon.coupon_label");
          localObject4 = (List)localObject4;
          d.g.b.k.g(localLinearLayout, "labelLayout");
          a((List)localObject4, localLinearLayout);
          localLinearLayout = this.nER;
          if (localLinearLayout == null) {
            d.g.b.k.aPZ("chpiCouponLayout");
          }
          ((ViewGroup)localObject3).setOnClickListener((View.OnClickListener)new a(this, (qs)localObject1, localqq, localLinearLayout.getChildCount(), paramInt3));
          dD((View)localObject3);
        }
        label487:
        while (localqq.CPX != 2)
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
        Object localObject3 = this.nER;
        if (localObject3 == null) {
          d.g.b.k.aPZ("chpiCouponLayout");
        }
        localObject3 = LayoutInflater.from(((LinearLayout)localObject3).getContext());
        LinearLayout localLinearLayout = this.nER;
        if (localLinearLayout == null) {
          d.g.b.k.aPZ("chpiCouponLayout");
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
        if (!bt.isNullOrNil(localqq.CQa)) {
          ((TextView)localObject5).setTextColor(com.tencent.mm.plugin.card.d.l.cC(localqq.CQa, localqq.CQb));
        }
        d.g.b.k.g(localObject5, "titleTv");
        ((TextView)localObject5).setText((CharSequence)localqq.CPR);
        d.g.b.k.g(localObject6, "descTv");
        ((TextView)localObject6).setText((CharSequence)localqq.CPS);
        d.g.b.k.g(localObject7, "bgIv");
        ((MemberCardTopCropImageView)localObject7).setRadius(com.tencent.mm.cd.a.fromDPToPix(((MemberCardTopCropImageView)localObject7).getContext(), 2));
        if (!bt.isNullOrNil(localqq.CPV))
        {
          localObject5 = (ImageView)localObject7;
          localObject6 = localqq.CPV;
          d.g.b.k.g(localObject6, "coupon.coupon_back_url");
          d.g.b.k.h(localObject5, "imageView");
          d.g.b.k.h(localObject6, "url");
          localObject7 = new c.a();
          ((c.a)localObject7).yw(com.tencent.mm.loader.j.b.aih());
          ((c.a)localObject7).a(o.ayK());
          ((c.a)localObject7).yv(m.Qy((String)localObject6));
          ((c.a)localObject7).ayY();
          ((c.a)localObject7).azb();
          ((c.a)localObject7).ayX();
          ((c.a)localObject7).oq(2131231461);
          ((c.a)localObject7).op(com.tencent.mm.cd.a.fromDPToPix(((ImageView)localObject5).getContext(), 84));
          ((c.a)localObject7).oo(com.tencent.mm.cd.a.hV(((ImageView)localObject5).getContext()));
          localObject7 = ((c.a)localObject7).azc();
          o.ayJ().a((String)localObject6, (ImageView)localObject5, (c)localObject7);
          ((ImageView)localObject5).setImageMatrix(new Matrix());
          d.g.b.k.g(localObject4, "shadowBgIv");
          ((ImageView)localObject4).setVisibility(0);
        }
        for (;;)
        {
          localObject4 = localqq.CPW;
          d.g.b.k.g(localObject4, "coupon.coupon_label");
          localObject4 = (List)localObject4;
          d.g.b.k.g(localLinearLayout, "labelLayout");
          a((List)localObject4, localLinearLayout);
          localLinearLayout = this.nER;
          if (localLinearLayout == null) {
            d.g.b.k.aPZ("chpiCouponLayout");
          }
          ((ViewGroup)localObject3).setOnClickListener((View.OnClickListener)new b(this, (qs)localObject1, localqq, localLinearLayout.getChildCount(), paramInt3));
          dD((View)localObject3);
          break;
          if (!bt.isNullOrNil(localqq.CPU))
          {
            ((MemberCardTopCropImageView)localObject7).setImageDrawable((Drawable)new ColorDrawable(Color.parseColor(localqq.CPU)));
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
      ((c.a)localObject).yw(com.tencent.mm.loader.j.b.aih());
      ((c.a)localObject).a(o.ayK());
      ((c.a)localObject).yv(m.Qy(paramString));
      ((c.a)localObject).ayY();
      ((c.a)localObject).aza();
      ((c.a)localObject).azb();
      ((c.a)localObject).ayX();
      ((c.a)localObject).oq(2131689865);
      localObject = ((c.a)localObject).azc();
      o.ayJ().a(paramString, paramImageView, (c)localObject);
      AppMethodBeat.o(112433);
    }
    
    private void a(List<? extends qp> paramList, LinearLayout paramLinearLayout)
    {
      AppMethodBeat.i(112432);
      d.g.b.k.h(paramList, "couponLabelList");
      d.g.b.k.h(paramLinearLayout, "labelLayout");
      paramList = paramList.iterator();
      if (paramList.hasNext())
      {
        qp localqp = (qp)paramList.next();
        Object localObject1 = this.nER;
        if (localObject1 == null) {
          d.g.b.k.aPZ("chpiCouponLayout");
        }
        localObject1 = new CardTagTextView(((LinearLayout)localObject1).getContext());
        Object localObject2 = this.nER;
        if (localObject2 == null) {
          d.g.b.k.aPZ("chpiCouponLayout");
        }
        localObject2 = ((LinearLayout)localObject2).getContext();
        ((CardTagTextView)localObject1).setMinHeight(com.tencent.mm.cd.a.fromDPToPix((Context)localObject2, 18));
        ((CardTagTextView)localObject1).setMinWidth(com.tencent.mm.cd.a.fromDPToPix((Context)localObject2, 56));
        int i = com.tencent.mm.cd.a.fromDPToPix((Context)localObject2, 8);
        int j = com.tencent.mm.cd.a.fromDPToPix((Context)localObject2, 4);
        ((CardTagTextView)localObject1).setPadding(i, j, i, j);
        ((CardTagTextView)localObject1).setText((CharSequence)localqp.CPL);
        ((CardTagTextView)localObject1).setTextSize(1, 10.0F);
        if (!bt.isNullOrNil(localqp.CPM))
        {
          ((CardTagTextView)localObject1).setTextColor(Color.parseColor(localqp.CPM));
          label199:
          if (bt.isNullOrNil(localqp.CPN)) {
            break label249;
          }
          ((CardTagTextView)localObject1).setFillColor(com.tencent.mm.plugin.card.d.l.cC(localqp.CPN, localqp.CPQ));
        }
        for (;;)
        {
          paramLinearLayout.addView((View)localObject1);
          break;
          ((CardTagTextView)localObject1).setTextColor(-1);
          break label199;
          label249:
          ((CardTagTextView)localObject1).setFillColor(com.tencent.mm.plugin.card.d.l.eO(-16777216, 26));
        }
      }
      AppMethodBeat.o(112432);
    }
    
    private void cB(List<? extends qr> paramList)
    {
      AppMethodBeat.i(112431);
      d.g.b.k.h(paramList, "labelList");
      Object localObject1 = this.nEQ;
      if (localObject1 == null) {
        d.g.b.k.aPZ("chpiLabelLayout");
      }
      ((LinearLayout)localObject1).removeAllViews();
      if (paramList.isEmpty())
      {
        paramList = this.nEQ;
        if (paramList == null) {
          d.g.b.k.aPZ("chpiLabelLayout");
        }
        paramList.setVisibility(8);
        AppMethodBeat.o(112431);
        return;
      }
      paramList = ((Iterable)paramList).iterator();
      int i = 0;
      if (paramList.hasNext())
      {
        Object localObject2 = (qr)paramList.next();
        localObject1 = this.nEQ;
        if (localObject1 == null) {
          d.g.b.k.aPZ("chpiLabelLayout");
        }
        localObject1 = ((LinearLayout)localObject1).getContext();
        d.g.b.k.g(localObject1, "chpiLabelLayout.context");
        localObject1 = new CardLabelTextView((Context)localObject1);
        Object localObject3 = this.nEQ;
        if (localObject3 == null) {
          d.g.b.k.aPZ("chpiLabelLayout");
        }
        localObject3 = ((LinearLayout)localObject3).getContext();
        ((CardLabelTextView)localObject1).setTextSize(1, 12.0F);
        ((CardLabelTextView)localObject1).setText((CharSequence)((qr)localObject2).CQj);
        int j = com.tencent.mm.cd.a.fromDPToPix((Context)localObject3, 4);
        ((CardLabelTextView)localObject1).setPadding(j, 0, j, 0);
        ((CardLabelTextView)localObject1).setGravity(16);
        if (!bt.isNullOrNil(((qr)localObject2).CQk))
        {
          ((CardLabelTextView)localObject1).setTextColor(Color.parseColor(((qr)localObject2).CQk));
          label240:
          if (bt.isNullOrNil(((qr)localObject2).CQl)) {
            break label359;
          }
          ((CardLabelTextView)localObject1).setFillColor(com.tencent.mm.plugin.card.d.l.cC(((qr)localObject2).CQl, ((qr)localObject2).CQo));
          label269:
          if (i <= 0) {
            break label368;
          }
          localObject2 = new ViewGroup.MarginLayoutParams(-2, -2);
          ((ViewGroup.MarginLayoutParams)localObject2).leftMargin = com.tencent.mm.cd.a.fromDPToPix((Context)localObject3, 4);
          localObject2 = (ViewGroup.MarginLayoutParams)new LinearLayout.LayoutParams((ViewGroup.MarginLayoutParams)localObject2);
          localObject3 = this.nEQ;
          if (localObject3 == null) {
            d.g.b.k.aPZ("chpiLabelLayout");
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
          localObject2 = this.nEQ;
          if (localObject2 == null) {
            d.g.b.k.aPZ("chpiLabelLayout");
          }
          ((LinearLayout)localObject2).addView((View)localObject1);
        }
      }
      paramList = this.nEQ;
      if (paramList == null) {
        d.g.b.k.aPZ("chpiLabelLayout");
      }
      paramList.setVisibility(0);
      AppMethodBeat.o(112431);
    }
    
    private void dD(View paramView)
    {
      AppMethodBeat.i(112430);
      d.g.b.k.h(paramView, "view");
      Object localObject = this.nER;
      if (localObject == null) {
        d.g.b.k.aPZ("chpiCouponLayout");
      }
      if (((LinearLayout)localObject).getChildCount() == 0)
      {
        localObject = this.nER;
        if (localObject == null) {
          d.g.b.k.aPZ("chpiCouponLayout");
        }
        ((LinearLayout)localObject).addView(paramView);
        AppMethodBeat.o(112430);
        return;
      }
      localObject = this.nER;
      if (localObject == null) {
        d.g.b.k.aPZ("chpiCouponLayout");
      }
      localObject = new ViewGroup.MarginLayoutParams(-1, com.tencent.mm.cd.a.fromDPToPix(((LinearLayout)localObject).getContext(), 84));
      LinearLayout localLinearLayout = this.nER;
      if (localLinearLayout == null) {
        d.g.b.k.aPZ("chpiCouponLayout");
      }
      ((ViewGroup.MarginLayoutParams)localObject).topMargin = com.tencent.mm.cd.a.fromDPToPix(localLinearLayout.getContext(), 8);
      localObject = (ViewGroup.MarginLayoutParams)new LinearLayout.LayoutParams((ViewGroup.MarginLayoutParams)localObject);
      localLinearLayout = this.nER;
      if (localLinearLayout == null) {
        d.g.b.k.aPZ("chpiCouponLayout");
      }
      localLinearLayout.addView(paramView, (ViewGroup.LayoutParams)localObject);
      AppMethodBeat.o(112430);
    }
    
    private final void z(boolean paramBoolean, int paramInt)
    {
      AppMethodBeat.i(112437);
      Object localObject = this.nFd;
      if (localObject == null) {
        d.g.b.k.fvU();
      }
      localObject = ((CardHomePageNewUI.a)localObject).nEE;
      if (paramBoolean)
      {
        if (localObject != null) {}
        for (localObject = ((qs)localObject).CQv; !bt.isNullOrNil((String)localObject); localObject = null)
        {
          zi(paramInt);
          AppMethodBeat.o(112437);
          return;
        }
        zk(paramInt);
        AppMethodBeat.o(112437);
        return;
      }
      zj(paramInt);
      AppMethodBeat.o(112437);
    }
    
    private final void zi(final int paramInt)
    {
      AppMethodBeat.i(112434);
      Object localObject1 = this.nFd;
      if (localObject1 == null) {
        d.g.b.k.fvU();
      }
      localObject1 = ((CardHomePageNewUI.a)localObject1).nEE;
      if (localObject1 == null) {
        d.g.b.k.fvU();
      }
      if (!bt.isNullOrNil(((qs)localObject1).CQv))
      {
        if (!bt.isNullOrNil(((qs)localObject1).CQw))
        {
          localObject2 = this.nET;
          if (localObject2 == null) {
            d.g.b.k.aPZ("chpiExpandTv");
          }
          ((TextView)localObject2).setTextColor(Color.parseColor(((qs)localObject1).CQw));
        }
        Object localObject2 = this.nET;
        if (localObject2 == null) {
          d.g.b.k.aPZ("chpiExpandTv");
        }
        ((TextView)localObject2).setText((CharSequence)((qs)localObject1).CQv);
        localObject2 = this.nEU;
        if (localObject2 == null) {
          d.g.b.k.aPZ("chpiExpandIv");
        }
        ((ImageView)localObject2).setImageResource(2131231436);
        localObject2 = this.nES;
        if (localObject2 == null) {
          d.g.b.k.aPZ("chpiExpandLayout");
        }
        ((LinearLayout)localObject2).setOnClickListener((View.OnClickListener)new i((qs)localObject1, this, paramInt));
      }
      AppMethodBeat.o(112434);
    }
    
    private final void zj(final int paramInt)
    {
      AppMethodBeat.i(112435);
      Object localObject1 = this.nFd;
      if (localObject1 == null) {
        d.g.b.k.fvU();
      }
      localObject1 = ((CardHomePageNewUI.a)localObject1).nEE;
      Object localObject2 = this.nET;
      if (localObject2 == null) {
        d.g.b.k.aPZ("chpiExpandTv");
      }
      Resources localResources = aj.getResources();
      if (localObject1 == null) {
        d.g.b.k.fvU();
      }
      ((TextView)localObject2).setText((CharSequence)localResources.getString(2131756876, new Object[] { Integer.valueOf(((qs)localObject1).CQA - ((qs)localObject1).CQB) }));
      localObject2 = this.nES;
      if (localObject2 == null) {
        d.g.b.k.aPZ("chpiExpandLayout");
      }
      ((LinearLayout)localObject2).setOnClickListener((View.OnClickListener)new h(this, paramInt, (qs)localObject1));
      localObject1 = this.nEU;
      if (localObject1 == null) {
        d.g.b.k.aPZ("chpiExpandIv");
      }
      ((ImageView)localObject1).setImageResource(2131231497);
      localObject1 = this.nEU;
      if (localObject1 == null) {
        d.g.b.k.aPZ("chpiExpandIv");
      }
      ((ImageView)localObject1).setVisibility(0);
      AppMethodBeat.o(112435);
    }
    
    private final void zk(final int paramInt)
    {
      AppMethodBeat.i(112436);
      Object localObject1 = this.nFd;
      if (localObject1 == null) {
        d.g.b.k.fvU();
      }
      localObject1 = ((CardHomePageNewUI.a)localObject1).nEE;
      Object localObject2 = this.nET;
      if (localObject2 == null) {
        d.g.b.k.aPZ("chpiExpandTv");
      }
      ((TextView)localObject2).setText((CharSequence)aj.getResources().getString(2131756874));
      localObject2 = this.nES;
      if (localObject2 == null) {
        d.g.b.k.aPZ("chpiExpandLayout");
      }
      ((LinearLayout)localObject2).setOnClickListener((View.OnClickListener)new g(this, paramInt, (qs)localObject1));
      localObject1 = this.nEU;
      if (localObject1 == null) {
        d.g.b.k.aPZ("chpiExpandIv");
      }
      ((ImageView)localObject1).setImageResource(2131231498);
      localObject1 = this.nEU;
      if (localObject1 == null) {
        d.g.b.k.aPZ("chpiExpandIv");
      }
      ((ImageView)localObject1).setVisibility(0);
      AppMethodBeat.o(112436);
    }
    
    public final void QW(String paramString)
    {
      AppMethodBeat.i(112429);
      d.g.b.k.h(paramString, "cardId");
      ad.i("MicroMsg.CardHomePageNewUI", "go to card detail: %s", new Object[] { paramString });
      Object localObject = this.arI;
      d.g.b.k.g(localObject, "itemView");
      localObject = new Intent(((View)localObject).getContext(), CardDetailUI.class);
      ((Intent)localObject).putExtra("key_card_id", paramString);
      ((Intent)localObject).addFlags(131072);
      ((Intent)localObject).putExtra("key_from_scene", 3);
      paramString = this.arI;
      d.g.b.k.g(paramString, "itemView");
      paramString = paramString.getContext();
      localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH", "gotoCardDetailUI", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH", "gotoCardDetailUI", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(112429);
    }
    
    public final void a(final CardHomePageNewUI.a parama, final int paramInt)
    {
      AppMethodBeat.i(112426);
      d.g.b.k.h(parama, "model");
      this.nFd = parama;
      Object localObject1 = parama.nEE;
      switch (parama.type)
      {
      }
      for (;;)
      {
        parama.nEG = true;
        AppMethodBeat.o(112426);
        return;
        if (localObject1 == null) {
          d.g.b.k.fvU();
        }
        Object localObject2 = this.nEM;
        if (localObject2 == null) {
          d.g.b.k.aPZ("chpiLogoIv");
        }
        ((CdnImageView)localObject2).setRoundCorner(true);
        Object localObject3;
        label172:
        int i;
        label511:
        boolean bool;
        if (!bt.isNullOrNil(((qs)localObject1).CQq))
        {
          localObject2 = this.nEM;
          if (localObject2 == null) {
            d.g.b.k.aPZ("chpiLogoIv");
          }
          localObject2 = (ImageView)localObject2;
          localObject3 = ((qs)localObject1).CQq;
          d.g.b.k.g(localObject3, "card_element_mch_icon");
          a((ImageView)localObject2, (String)localObject3);
          localObject2 = (View.OnClickListener)new c((qs)localObject1, this, (qs)localObject1, paramInt, parama);
          localObject3 = this.nEM;
          if (localObject3 == null) {
            d.g.b.k.aPZ("chpiLogoIv");
          }
          ((CdnImageView)localObject3).setOnClickListener((View.OnClickListener)localObject2);
          localObject3 = CardHomePageNewUI.this;
          Object localObject4 = CardHomePageNewUI.this.getContext();
          d.g.b.k.g(localObject4, "context");
          i = ((AppCompatActivity)localObject4).getResources().getColor(2131100711);
          localObject4 = CardHomePageNewUI.this.getContext();
          d.g.b.k.g(localObject4, "context");
          localObject4 = new CardHomePageNewUI.b((CardHomePageNewUI)localObject3, i, ((AppCompatActivity)localObject4).getResources().getColor(2131100913), (com.tencent.mm.pluginsdk.ui.span.i)new CardHomePageNewUI.e.d((View.OnClickListener)localObject2));
          localObject3 = new SpannableString((CharSequence)((qs)localObject1).CQr);
          ((SpannableString)localObject3).setSpan(localObject4, 0, ((SpannableString)localObject3).length(), 18);
          localObject4 = this.nEN;
          if (localObject4 == null) {
            d.g.b.k.aPZ("chpiNameTv");
          }
          ((TextView)localObject4).setClickable(true);
          localObject4 = this.nEN;
          if (localObject4 == null) {
            d.g.b.k.aPZ("chpiNameTv");
          }
          ((TextView)localObject4).setOnTouchListener((View.OnTouchListener)new n((Context)CardHomePageNewUI.this));
          localObject4 = this.nEN;
          if (localObject4 == null) {
            d.g.b.k.aPZ("chpiNameTv");
          }
          ((TextView)localObject4).setText((CharSequence)localObject3);
          if (bt.isNullOrNil(((qs)localObject1).CQs)) {
            break label912;
          }
          localObject3 = this.nEO;
          if (localObject3 == null) {
            d.g.b.k.aPZ("chpiDescTv");
          }
          ((TextView)localObject3).setText((CharSequence)((qs)localObject1).CQs);
          localObject3 = this.nEO;
          if (localObject3 == null) {
            d.g.b.k.aPZ("chpiDescTv");
          }
          ((TextView)localObject3).setVisibility(0);
          localObject3 = this.nEO;
          if (localObject3 == null) {
            d.g.b.k.aPZ("chpiDescTv");
          }
          ((TextView)localObject3).setOnClickListener((View.OnClickListener)localObject2);
          if (((qs)localObject1).CQy == null) {
            break label1030;
          }
          if (bt.isNullOrNil(((qs)localObject1).CQy.CQj)) {
            break label1003;
          }
          localObject2 = this.nEV;
          if (localObject2 == null) {
            d.g.b.k.aPZ("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject2).setText((CharSequence)((qs)localObject1).CQy.CQj);
          if (bt.isNullOrNil(((qs)localObject1).CQy.CQk)) {
            break label939;
          }
          localObject2 = this.nEV;
          if (localObject2 == null) {
            d.g.b.k.aPZ("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject2).setTextColor(Color.parseColor(((qs)localObject1).CQy.CQk));
          label613:
          if (bt.isNullOrNil(((qs)localObject1).CQy.CQl)) {
            break label977;
          }
          localObject2 = this.nEV;
          if (localObject2 == null) {
            d.g.b.k.aPZ("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject2).setFillColor(com.tencent.mm.plugin.card.d.l.cC(((qs)localObject1).CQy.CQl, ((qs)localObject1).CQy.CQo));
          label668:
          localObject2 = this.nEV;
          if (localObject2 == null) {
            d.g.b.k.aPZ("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject2).setVisibility(0);
          label691:
          localObject2 = this.nER;
          if (localObject2 == null) {
            d.g.b.k.aPZ("chpiCouponLayout");
          }
          ((LinearLayout)localObject2).removeAllViews();
          if (parama.nEG) {
            break label1091;
          }
          if (((qs)localObject1).CQz != 1) {
            break label1085;
          }
          bool = true;
          label732:
          if (!bool) {
            break label1183;
          }
          localObject2 = ((qs)localObject1).CQu;
          d.g.b.k.g(localObject2, "card_element_coupon_list");
          if (((Collection)localObject2).isEmpty()) {
            break label1100;
          }
          i = 1;
          label767:
          if (i == 0) {
            break label1105;
          }
          R(-1, ((qs)localObject1).CQu.size(), paramInt);
          localObject2 = this.nER;
          if (localObject2 == null) {
            d.g.b.k.aPZ("chpiCouponLayout");
          }
          ((LinearLayout)localObject2).setVisibility(0);
          parama.nEH = true;
          label813:
          if (bt.isNullOrNil(((qs)localObject1).CQv)) {
            break label1132;
          }
          zi(paramInt);
          localObject2 = this.nES;
          if (localObject2 == null) {
            d.g.b.k.aPZ("chpiExpandLayout");
          }
          ((LinearLayout)localObject2).setVisibility(0);
        }
        label912:
        label939:
        label1085:
        label1213:
        for (;;)
        {
          localObject1 = ((qs)localObject1).CQt;
          d.g.b.k.g(localObject1, "card_element_mch_label");
          cB((List)localObject1);
          localObject1 = y.JfV;
          break;
          localObject2 = this.nEM;
          if (localObject2 == null) {
            d.g.b.k.aPZ("chpiLogoIv");
          }
          ((CdnImageView)localObject2).setImageResource(2131689865);
          break label172;
          localObject2 = this.nEO;
          if (localObject2 == null) {
            d.g.b.k.aPZ("chpiDescTv");
          }
          ((TextView)localObject2).setVisibility(8);
          break label511;
          localObject2 = this.nEV;
          if (localObject2 == null) {
            d.g.b.k.aPZ("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject2).setTextColor(CardHomePageNewUI.this.getResources().getColor(2131101179));
          break label613;
          label977:
          localObject2 = this.nEV;
          if (localObject2 == null) {
            d.g.b.k.aPZ("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject2).setFillColor(0);
          break label668;
          label1003:
          localObject2 = this.nEV;
          if (localObject2 == null) {
            d.g.b.k.aPZ("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject2).setVisibility(8);
          break label691;
          localObject2 = this.nEV;
          if (localObject2 == null) {
            d.g.b.k.aPZ("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject2).setText((CharSequence)"");
          localObject2 = this.nEV;
          if (localObject2 == null) {
            d.g.b.k.aPZ("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject2).setVisibility(8);
          break label691;
          bool = false;
          break label732;
          label1091:
          bool = parama.nEH;
          break label732;
          label1100:
          i = 0;
          break label767;
          label1105:
          localObject2 = this.nER;
          if (localObject2 == null) {
            d.g.b.k.aPZ("chpiCouponLayout");
          }
          ((LinearLayout)localObject2).setVisibility(8);
          break label813;
          label1132:
          if (((qs)localObject1).CQB < ((qs)localObject1).CQu.size())
          {
            zk(paramInt);
          }
          else
          {
            localObject2 = this.nES;
            if (localObject2 == null) {
              d.g.b.k.aPZ("chpiExpandLayout");
            }
            ((LinearLayout)localObject2).setVisibility(8);
            continue;
            localObject2 = ((qs)localObject1).CQu;
            d.g.b.k.g(localObject2, "card_element_coupon_list");
            if (!((Collection)localObject2).isEmpty())
            {
              i = 1;
              if (i == 0) {
                break label1319;
              }
              R(-1, ((qs)localObject1).CQB, paramInt);
              localObject2 = this.nER;
              if (localObject2 == null) {
                d.g.b.k.aPZ("chpiCouponLayout");
              }
              ((LinearLayout)localObject2).setVisibility(0);
              parama.nEH = false;
            }
            for (;;)
            {
              if (((qs)localObject1).CQB >= ((qs)localObject1).CQu.size())
              {
                if (!bt.isNullOrNil(((qs)localObject1).CQv))
                {
                  zi(paramInt);
                  localObject2 = this.nES;
                  if (localObject2 == null) {
                    d.g.b.k.aPZ("chpiExpandLayout");
                  }
                  ((LinearLayout)localObject2).setVisibility(0);
                  break;
                  i = 0;
                  break label1213;
                  localObject2 = this.nER;
                  if (localObject2 == null) {
                    d.g.b.k.aPZ("chpiCouponLayout");
                  }
                  ((LinearLayout)localObject2).setVisibility(8);
                  continue;
                }
                localObject2 = this.nES;
                if (localObject2 == null) {
                  d.g.b.k.aPZ("chpiExpandLayout");
                }
                ((LinearLayout)localObject2).setVisibility(8);
                break;
              }
            }
            zj(paramInt);
            localObject2 = this.nES;
            if (localObject2 == null) {
              d.g.b.k.aPZ("chpiExpandLayout");
            }
            ((LinearLayout)localObject2).setVisibility(0);
          }
        }
        label1030:
        label1183:
        label1319:
        localObject1 = this.nEL;
        if (localObject1 == null) {
          d.g.b.k.aPZ("sectionTitleTv");
        }
        ((TextView)localObject1).setText((CharSequence)parama.bMf());
        continue;
        if (localObject1 == null) {
          d.g.b.k.fvU();
        }
        localObject2 = this.nEM;
        if (localObject2 == null) {
          d.g.b.k.aPZ("chpiLogoIv");
        }
        ((CdnImageView)localObject2).setRoundCorner(true);
        localObject2 = this.nEM;
        if (localObject2 == null) {
          d.g.b.k.aPZ("chpiLogoIv");
        }
        ((CdnImageView)localObject2).setUrl(((qs)localObject1).CQq);
        localObject2 = this.nEN;
        if (localObject2 == null) {
          d.g.b.k.aPZ("chpiNameTv");
        }
        ((TextView)localObject2).setText((CharSequence)((qs)localObject1).CQr);
        if (!bt.isNullOrNil(((qs)localObject1).CQs))
        {
          localObject2 = this.nEO;
          if (localObject2 == null) {
            d.g.b.k.aPZ("chpiDescTv");
          }
          ((TextView)localObject2).setText((CharSequence)((qs)localObject1).CQs);
          localObject2 = this.nEO;
          if (localObject2 == null) {
            d.g.b.k.aPZ("chpiDescTv");
          }
          ((TextView)localObject2).setVisibility(0);
          label1588:
          if (((qs)localObject1).CQy == null) {
            break label1894;
          }
          if (bt.isNullOrNil(((qs)localObject1).CQy.CQj)) {
            break label1867;
          }
          localObject2 = this.nEV;
          if (localObject2 == null) {
            d.g.b.k.aPZ("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject2).setText((CharSequence)((qs)localObject1).CQy.CQj);
          if (bt.isNullOrNil(((qs)localObject1).CQy.CQk)) {
            break label1803;
          }
          localObject2 = this.nEV;
          if (localObject2 == null) {
            d.g.b.k.aPZ("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject2).setTextColor(Color.parseColor(((qs)localObject1).CQy.CQk));
          label1690:
          if (bt.isNullOrNil(((qs)localObject1).CQy.CQl)) {
            break label1841;
          }
          localObject2 = this.nEV;
          if (localObject2 == null) {
            d.g.b.k.aPZ("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject2).setFillColor(com.tencent.mm.plugin.card.d.l.cC(((qs)localObject1).CQy.CQl, ((qs)localObject1).CQy.CQo));
          label1745:
          localObject1 = this.nEV;
          if (localObject1 == null) {
            d.g.b.k.aPZ("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject1).setVisibility(0);
        }
        for (;;)
        {
          localObject1 = y.JfV;
          break;
          localObject2 = this.nEO;
          if (localObject2 == null) {
            d.g.b.k.aPZ("chpiDescTv");
          }
          ((TextView)localObject2).setVisibility(8);
          break label1588;
          label1803:
          localObject2 = this.nEV;
          if (localObject2 == null) {
            d.g.b.k.aPZ("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject2).setTextColor(CardHomePageNewUI.this.getResources().getColor(2131101179));
          break label1690;
          label1841:
          localObject1 = this.nEV;
          if (localObject1 == null) {
            d.g.b.k.aPZ("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject1).setFillColor(0);
          break label1745;
          label1867:
          localObject1 = this.nEV;
          if (localObject1 == null) {
            d.g.b.k.aPZ("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject1).setVisibility(8);
          continue;
          label1894:
          localObject1 = this.nEV;
          if (localObject1 == null) {
            d.g.b.k.aPZ("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject1).setText((CharSequence)"");
          localObject1 = this.nEV;
          if (localObject1 == null) {
            d.g.b.k.aPZ("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject1).setVisibility(8);
        }
        localObject1 = this.nEM;
        if (localObject1 == null) {
          d.g.b.k.aPZ("chpiLogoIv");
        }
        ((CdnImageView)localObject1).setRoundCorner(true);
        localObject1 = this.nEM;
        if (localObject1 == null) {
          d.g.b.k.aPZ("chpiLogoIv");
        }
        ((CdnImageView)localObject1).setImageResource(2131689865);
        localObject1 = this.nEN;
        if (localObject1 == null) {
          d.g.b.k.aPZ("chpiNameTv");
        }
        ((TextView)localObject1).setText((CharSequence)aj.getResources().getString(2131756877));
        localObject1 = this.nEO;
        if (localObject1 == null) {
          d.g.b.k.aPZ("chpiDescTv");
        }
        ((TextView)localObject1).setVisibility(8);
        continue;
        localObject1 = this.nEX;
        if (localObject1 == null) {
          d.g.b.k.aPZ("chtiTitleTv");
        }
        ((TextView)localObject1).setText(2131764415);
        if (CardHomePageNewUI.n(CardHomePageNewUI.this) != null)
        {
          localObject1 = this.nEY;
          if (localObject1 == null) {
            d.g.b.k.aPZ("chtiDescTv");
          }
          ((TextView)localObject1).setText((CharSequence)CardHomePageNewUI.n(CardHomePageNewUI.this));
          localObject1 = y.JfV;
          continue;
          localObject1 = this.nEX;
          if (localObject1 == null) {
            d.g.b.k.aPZ("chtiTitleTv");
          }
          ((TextView)localObject1).setText(2131756948);
          if (CardHomePageNewUI.o(CardHomePageNewUI.this) == 1)
          {
            localObject1 = this.nEY;
            if (localObject1 == null) {
              d.g.b.k.aPZ("chtiDescTv");
            }
            ((TextView)localObject1).setVisibility(0);
            localObject1 = this.nEZ;
            if (localObject1 == null) {
              d.g.b.k.aPZ("chtiRightIv");
            }
            ((ImageView)localObject1).setVisibility(0);
            localObject1 = CardHomePageNewUI.this.bMb();
            if (localObject1 == null)
            {
              localObject1 = this.nEY;
              if (localObject1 == null) {
                d.g.b.k.aPZ("chtiDescTv");
              }
              ((TextView)localObject1).setText((CharSequence)"");
            }
            for (;;)
            {
              localObject1 = this.nEY;
              if (localObject1 == null) {
                d.g.b.k.aPZ("chtiDescTv");
              }
              ((TextView)localObject1).setOnClickListener((View.OnClickListener)new e(this));
              localObject1 = this.nEZ;
              if (localObject1 == null) {
                d.g.b.k.aPZ("chtiRightIv");
              }
              ((ImageView)localObject1).setOnClickListener((View.OnClickListener)new f(this));
              localObject1 = this.nEZ;
              if (localObject1 == null) {
                d.g.b.k.aPZ("chtiRightIv");
              }
              bt.n((View)localObject1, 50, 50, 50, 50);
              break;
              localObject2 = this.nEY;
              if (localObject2 == null) {
                d.g.b.k.aPZ("chtiDescTv");
              }
              ((TextView)localObject2).setText((CharSequence)((rk)localObject1).CRu);
            }
          }
          localObject1 = this.nEY;
          if (localObject1 == null) {
            d.g.b.k.aPZ("chtiDescTv");
          }
          ((TextView)localObject1).setVisibility(8);
          localObject1 = this.nEZ;
          if (localObject1 == null) {
            d.g.b.k.aPZ("chtiRightIv");
          }
          ((ImageView)localObject1).setVisibility(8);
          continue;
          localObject1 = parama.nEI;
          if (localObject1 != null)
          {
            localObject2 = this.nEX;
            if (localObject2 == null) {
              d.g.b.k.aPZ("chtiTitleTv");
            }
            ((TextView)localObject2).setText((CharSequence)((qx)localObject1).CQL);
            localObject2 = this.nEY;
            if (localObject2 == null) {
              d.g.b.k.aPZ("chtiDescTv");
            }
            ((TextView)localObject2).setText((CharSequence)((qx)localObject1).CQM);
            localObject2 = this.nEW;
            if (localObject2 == null) {
              d.g.b.k.aPZ("chtiIconIv");
            }
            localObject3 = ((qx)localObject1).CQK;
            d.g.b.k.g(localObject3, "card_top_cell_icon");
            a((ImageView)localObject2, (String)localObject3);
            localObject2 = this.nFb;
            if (localObject2 == null) {
              d.g.b.k.aPZ("chtiNewTv");
            }
            if (((qx)localObject1).CQS != 1) {
              break label2659;
            }
            paramInt = 0;
            label2581:
            ((TextView)localObject2).setVisibility(paramInt);
            localObject2 = this.nFa;
            if (localObject2 == null) {
              d.g.b.k.aPZ("chtiRedDotIv");
            }
            if (((qx)localObject1).CQR != 1) {
              break label2665;
            }
          }
          label2659:
          label2665:
          for (paramInt = 0;; paramInt = 8)
          {
            ((ImageView)localObject2).setVisibility(paramInt);
            localObject1 = y.JfV;
            if (!parama.nEJ) {
              break label2671;
            }
            localObject1 = this.nFc;
            if (localObject1 == null) {
              d.g.b.k.aPZ("chtiDivider");
            }
            ((View)localObject1).setVisibility(0);
            break;
            paramInt = 8;
            break label2581;
          }
          label2671:
          localObject1 = this.nFc;
          if (localObject1 == null) {
            d.g.b.k.aPZ("chtiDivider");
          }
          ((View)localObject1).setVisibility(8);
        }
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(CardHomePageNewUI.e parame, qs paramqs, qq paramqq, int paramInt1, int paramInt2) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(112417);
        CardHomePageNewUI.k(this.nFe.nEK);
        CardHomePageNewUI.a(this.nFe.nEK, 0);
        CardHomePageNewUI.a(this.nFe.nEK, this.nFf);
        paramView = this.nFe;
        String str = localqq.CuA;
        d.g.b.k.g(str, "coupon.user_card_id");
        paramView.QW(str);
        com.tencent.mm.plugin.report.service.h.vKh.f(16324, new Object[] { Integer.valueOf(1), this.nFf.CQp, Integer.valueOf(this.mYS), localqq.CuA, Integer.valueOf(2), Integer.valueOf(paramInt3), Integer.valueOf(CardHomePageNewUI.m(this.nFe.nEK)) });
        AppMethodBeat.o(112417);
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b
      implements View.OnClickListener
    {
      b(CardHomePageNewUI.e parame, qs paramqs, qq paramqq, int paramInt1, int paramInt2) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(112418);
        CardHomePageNewUI.k(this.nFe.nEK);
        CardHomePageNewUI.a(this.nFe.nEK, 0);
        CardHomePageNewUI.a(this.nFe.nEK, this.nFf);
        paramView = this.nFe;
        String str = localqq.CuA;
        d.g.b.k.g(str, "coupon.user_card_id");
        paramView.QW(str);
        com.tencent.mm.plugin.report.service.h.vKh.f(16324, new Object[] { Integer.valueOf(1), this.nFf.CQp, Integer.valueOf(this.mYS), localqq.CuA, Integer.valueOf(2), Integer.valueOf(paramInt3), Integer.valueOf(CardHomePageNewUI.m(this.nFe.nEK)) });
        AppMethodBeat.o(112418);
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$setModel$1$headerClickListener$1"})
    static final class c
      implements View.OnClickListener
    {
      c(qs paramqs1, CardHomePageNewUI.e parame, qs paramqs2, int paramInt, CardHomePageNewUI.a parama) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(112419);
        ad.i("MicroMsg.CardHomePageNewUI", "click header");
        CardHomePageNewUI.k(jdField_this.nEK);
        CardHomePageNewUI.a(jdField_this.nEK, 0);
        CardHomePageNewUI.a(jdField_this.nEK, this.nFi);
        switch (this.nFh.CQf)
        {
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.h.vKh.f(16324, new Object[] { Integer.valueOf(1), this.nFh.CQp, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(paramInt), Integer.valueOf(CardHomePageNewUI.m(jdField_this.nEK)) });
          AppMethodBeat.o(112419);
          return;
          paramView = jdField_this.arI;
          d.g.b.k.g(paramView, "itemView");
          paramView = paramView.getContext();
          if (paramView == null)
          {
            paramView = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(112419);
            throw paramView;
          }
          com.tencent.mm.plugin.card.d.b.a((MMActivity)paramView, this.nFh.CQg);
          continue;
          paramView = this.nFh.CQh;
          com.tencent.mm.plugin.card.d.b.G(paramView.zHs, paramView.zHt, paramView.Aoy);
        }
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class e
      implements View.OnClickListener
    {
      e(CardHomePageNewUI.e parame) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(112421);
        CardHomePageNewUI.p(this.nFe.nEK);
        AppMethodBeat.o(112421);
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class f
      implements View.OnClickListener
    {
      f(CardHomePageNewUI.e parame) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(112422);
        CardHomePageNewUI.p(this.nFe.nEK);
        AppMethodBeat.o(112422);
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class g
      implements View.OnClickListener
    {
      g(CardHomePageNewUI.e parame, int paramInt, qs paramqs) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(112423);
        ad.d("MicroMsg.CardHomePageNewUI", "do collapse coupon layout");
        CardHomePageNewUI.e.b(this.nFe, paramInt);
        paramView = this.nFe.nFd;
        if (paramView != null) {
          paramView.nEH = false;
        }
        paramView = com.tencent.mm.plugin.report.service.h.vKh;
        qs localqs = this.nFf;
        if (localqs == null) {
          d.g.b.k.fvU();
        }
        paramView.f(16324, new Object[] { Integer.valueOf(1), localqs.CQp, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(5), Integer.valueOf(paramInt), Integer.valueOf(CardHomePageNewUI.m(this.nFe.nEK)) });
        AppMethodBeat.o(112423);
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class h
      implements View.OnClickListener
    {
      h(CardHomePageNewUI.e parame, int paramInt, qs paramqs) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(112424);
        ad.d("MicroMsg.CardHomePageNewUI", "do expand coupon layout");
        CardHomePageNewUI.e.a(this.nFe, paramInt);
        paramView = this.nFe.nFd;
        if (paramView != null) {
          paramView.nEH = true;
        }
        paramView = com.tencent.mm.plugin.report.service.h.vKh;
        qs localqs = this.nFf;
        if (localqs == null) {
          d.g.b.k.fvU();
        }
        paramView.f(16324, new Object[] { Integer.valueOf(1), localqs.CQp, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(4), Integer.valueOf(paramInt), Integer.valueOf(CardHomePageNewUI.m(this.nFe.nEK)) });
        AppMethodBeat.o(112424);
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$showMiniAppLayout$1$1"})
    static final class i
      implements View.OnClickListener
    {
      i(qs paramqs, CardHomePageNewUI.e parame, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(112425);
        if (this.nFh.CQx != null) {
          if (this.nFh.CQx == null) {
            break label225;
          }
        }
        label225:
        for (boolean bool = true;; bool = false)
        {
          ad.i("MicroMsg.CardHomePageNewUI", "detail goto mini app %s", new Object[] { Boolean.valueOf(bool) });
          CardHomePageNewUI.k(jdField_this.nEK);
          CardHomePageNewUI.a(jdField_this.nEK, 0);
          CardHomePageNewUI.a(jdField_this.nEK, this.nFh);
          com.tencent.mm.plugin.card.d.b.G(this.nFh.CQx.zHs, this.nFh.CQx.zHt, this.nFh.CQx.Aoy);
          paramView = com.tencent.mm.plugin.report.service.h.vKh;
          Object localObject = jdField_this.nFd;
          if (localObject == null) {
            d.g.b.k.fvU();
          }
          localObject = ((CardHomePageNewUI.a)localObject).nEE;
          if (localObject == null) {
            d.g.b.k.fvU();
          }
          paramView.f(16324, new Object[] { Integer.valueOf(1), ((qs)localObject).CQp, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(6), Integer.valueOf(paramInt), Integer.valueOf(CardHomePageNewUI.m(jdField_this.nEK)) });
          AppMethodBeat.o(112425);
          return;
        }
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "kotlin.jvm.PlatformType", "it", "Lcom/tencent/mm/modelbase/DeprecatedCgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/DeleteMchInListResponse;", "call"})
  static final class f<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    f(CardHomePageNewUI paramCardHomePageNewUI, String paramString) {}
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "kotlin.jvm.PlatformType", "it", "Lcom/tencent/mm/modelbase/DeprecatedCgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetMktCardHomePageResponse;", "call"})
  static final class g<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    g(CardHomePageNewUI paramCardHomePageNewUI) {}
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/DeprecatedCgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetCardPkgMchInfoResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class h<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    h(CardHomePageNewUI paramCardHomePageNewUI, String paramString) {}
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$initView$1", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "paint", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "paint2", "getPaint2", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "onDraw", "c", "Landroid/graphics/Canvas;", "plugin-card_release"})
  public static final class i
    extends RecyclerView.h
  {
    private final Paint nFn;
    private final Paint paint;
    
    i()
    {
      AppMethodBeat.i(112446);
      this.paint = new Paint();
      this.nFn = new Paint();
      this.paint.setColor(localObject.getResources().getColor(2131100886));
      this.paint.setStyle(Paint.Style.FILL);
      this.paint.setFlags(1);
      this.nFn.setColor(localObject.getResources().getColor(2131101179));
      this.nFn.setStyle(Paint.Style.FILL);
      this.nFn.setFlags(1);
      AppMethodBeat.o(112446);
    }
    
    public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(112445);
      d.g.b.k.h(paramCanvas, "c");
      d.g.b.k.h(paramRecyclerView, "parent");
      d.g.b.k.h(params, "state");
      super.a(paramCanvas, paramRecyclerView, params);
      paramRecyclerView = CardHomePageNewUI.j(this.nEK);
      if (paramRecyclerView != null)
      {
        int i = paramRecyclerView.getPaddingLeft();
        params = CardHomePageNewUI.nED;
        int k = i + CardHomePageNewUI.bMe();
        int m = paramRecyclerView.getWidth();
        int n = paramRecyclerView.getPaddingRight();
        int i1 = paramRecyclerView.getChildCount();
        i = 0;
        if (i < i1 - 1)
        {
          params = paramRecyclerView.getChildAt(i);
          d.g.b.k.g(params, "child");
          Object localObject = params.getLayoutParams();
          if (localObject == null)
          {
            paramCanvas = new v("null cannot be cast to non-null type android.support.v7.widget.RecyclerView.LayoutParams");
            AppMethodBeat.o(112445);
            throw paramCanvas;
          }
          localObject = (RecyclerView.LayoutParams)localObject;
          int i2 = params.getBottom() + ((RecyclerView.LayoutParams)localObject).bottomMargin;
          if (i == i1 - 1) {
            params = CardHomePageNewUI.nED;
          }
          for (int j = CardHomePageNewUI.bMd();; j = 1)
          {
            j = i2 + j;
            if (paramCanvas != null) {
              paramCanvas.drawRect(k, i2, m - n, j, this.paint);
            }
            if (paramCanvas != null) {
              paramCanvas.drawRect(0.0F, i2, k, j, this.nFn);
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
      d.g.b.k.h(paramRect, "outRect");
      d.g.b.k.h(paramView, "view");
      d.g.b.k.h(paramRecyclerView, "parent");
      d.g.b.k.h(params, "state");
      super.a(paramRect, paramView, paramRecyclerView, params);
      if (RecyclerView.bw(paramView) == CardHomePageNewUI.q(this.nEK).getItemCount() - 1)
      {
        ad.d("MicroMsg.CardHomePageNewUI", "is last");
        paramView = CardHomePageNewUI.nED;
        paramRect.bottom = CardHomePageNewUI.bMd();
        AppMethodBeat.o(112444);
        return;
      }
      paramRect.bottom = 1;
      AppMethodBeat.o(112444);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "parent", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "kotlin.jvm.PlatformType", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "onLoadMore"})
  static final class j
    implements LoadMoreRecyclerView.a
  {
    j(CardHomePageNewUI paramCardHomePageNewUI) {}
    
    public final void bpD()
    {
      AppMethodBeat.i(112447);
      CardHomePageNewUI.r(this.nEK);
      AppMethodBeat.o(112447);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "parent", "Landroid/support/v7/widget/RecyclerView;", "kotlin.jvm.PlatformType", "view", "Landroid/view/View;", "position", "", "id", "", "onItemClick"})
  static final class k
    implements MRecyclerView.a
  {
    k(CardHomePageNewUI paramCardHomePageNewUI) {}
    
    public final void S(View paramView, int paramInt)
    {
      AppMethodBeat.i(112448);
      paramView = CardHomePageNewUI.q(this.nEK).zh(paramInt);
      if (paramView != null)
      {
        ad.i("MicroMsg.CardHomePageNewUI", "click type: %s", new Object[] { Integer.valueOf(paramView.type) });
        Object localObject2;
        switch (paramView.type)
        {
        case 3: 
        default: 
          AppMethodBeat.o(112448);
          return;
        case 2: 
          CardHomePageNewUI.k(this.nEK);
          CardHomePageNewUI.a(this.nEK, 1);
          CardHomePageNewUI.a(this.nEK, paramView.nEE);
          localObject1 = paramView.nEE;
          if (localObject1 == null) {
            d.g.b.k.fvU();
          }
          switch (((qs)localObject1).CQf)
          {
          }
          for (;;)
          {
            localObject1 = com.tencent.mm.plugin.report.service.h.vKh;
            paramView = paramView.nEE;
            if (paramView == null) {
              d.g.b.k.fvU();
            }
            ((com.tencent.mm.plugin.report.service.h)localObject1).f(16324, new Object[] { Integer.valueOf(2), paramView.CQp, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(paramInt), Integer.valueOf(CardHomePageNewUI.m(this.nEK)) });
            AppMethodBeat.o(112448);
            return;
            localObject1 = (MMActivity)this.nEK;
            localObject2 = paramView.nEE;
            if (localObject2 == null) {
              d.g.b.k.fvU();
            }
            com.tencent.mm.plugin.card.d.b.a((MMActivity)localObject1, ((qs)localObject2).CQg);
            continue;
            localObject1 = paramView.nEE;
            if (localObject1 == null) {
              d.g.b.k.fvU();
            }
            localObject1 = ((qs)localObject1).CQh;
            com.tencent.mm.plugin.card.d.b.G(((rc)localObject1).zHs, ((rc)localObject1).zHt, ((rc)localObject1).Aoy);
          }
        case 4: 
          ad.i("MicroMsg.CardHomePageNewUI", "click ticket item");
          localObject1 = new Intent((Context)this.nEK, CardTicketListUI.class);
          paramView = this.nEK;
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject1);
          com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject1).adn(), "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$initView$3", "onItemClick", "(Landroid/support/v7/widget/RecyclerView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$initView$3", "onItemClick", "(Landroid/support/v7/widget/RecyclerView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.plugin.report.service.h.vKh.f(16322, new Object[] { Integer.valueOf(5) });
          AppMethodBeat.o(112448);
          return;
        case 5: 
          com.tencent.mm.plugin.report.service.h.vKh.f(16322, new Object[] { Integer.valueOf(13) });
          AppMethodBeat.o(112448);
          return;
        }
        Object localObject1 = paramView.nEI;
        if (localObject1 == null) {
          d.g.b.k.fvU();
        }
        switch (((qx)localObject1).CQN)
        {
        }
        for (;;)
        {
          localObject1 = paramView.nEI;
          if (localObject1 == null) {
            d.g.b.k.fvU();
          }
          ((qx)localObject1).CQS = 0;
          paramView = paramView.nEI;
          if (paramView == null) {
            d.g.b.k.fvU();
          }
          paramView.CQR = 0;
          CardHomePageNewUI.q(this.nEK).ck(paramInt);
          break;
          localObject1 = (MMActivity)this.nEK;
          localObject2 = paramView.nEI;
          if (localObject2 == null) {
            d.g.b.k.fvU();
          }
          com.tencent.mm.plugin.card.d.b.a((MMActivity)localObject1, ((qx)localObject2).CQO);
          CardHomePageNewUI.s(this.nEK);
          continue;
          localObject1 = paramView.nEI;
          if (localObject1 == null) {
            d.g.b.k.fvU();
          }
          localObject1 = ((qx)localObject1).CQP;
          com.tencent.mm.plugin.card.d.b.G(((rc)localObject1).zHs, ((rc)localObject1).zHt, ((rc)localObject1).Aoy);
          CardHomePageNewUI.s(this.nEK);
          continue;
          localObject1 = new StringBuilder("click native url: ");
          localObject2 = paramView.nEI;
          if (localObject2 == null) {
            d.g.b.k.fvU();
          }
          ad.i("MicroMsg.CardHomePageNewUI", ((qx)localObject2).CQQ);
          localObject1 = paramView.nEI;
          if (localObject1 == null) {
            d.g.b.k.fvU();
          }
          if (d.g.b.k.g("weixin://mktcard/cert", ((qx)localObject1).CQQ))
          {
            localObject2 = new Intent((Context)this.nEK, CardTicketListUI.class);
            localObject1 = this.nEK;
            localObject2 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject2);
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).adn(), "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$initView$3", "onItemClick", "(Landroid/support/v7/widget/RecyclerView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((CardHomePageNewUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lS(0));
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$initView$3", "onItemClick", "(Landroid/support/v7/widget/RecyclerView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            CardHomePageNewUI.s(this.nEK);
          }
        }
      }
      AppMethodBeat.o(112448);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "parent", "Landroid/support/v7/widget/RecyclerView;", "kotlin.jvm.PlatformType", "view", "Landroid/view/View;", "position", "", "id", "", "onItemLongClick"})
  static final class l
    implements MRecyclerView.b
  {
    l(CardHomePageNewUI paramCardHomePageNewUI) {}
    
    public final boolean T(View paramView, final int paramInt)
    {
      AppMethodBeat.i(112452);
      paramView = CardHomePageNewUI.q(this.nEK).zh(paramInt);
      if (paramView != null)
      {
        ad.i("MicroMsg.CardHomePageNewUI", "long click type: %s", new Object[] { Integer.valueOf(paramView.type) });
        switch (paramView.type)
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(112452);
        return false;
        Object localObject = new com.tencent.mm.ui.tools.l((Context)this.nEK.getContext());
        ((com.tencent.mm.ui.tools.l)localObject).a((n.c)new a(this, paramInt));
        ((com.tencent.mm.ui.tools.l)localObject).a((n.d)new b(paramView, this, paramInt));
        ((com.tencent.mm.ui.tools.l)localObject).fdQ();
        localObject = com.tencent.mm.plugin.report.service.h.vKh;
        paramView = paramView.nEE;
        if (paramView == null) {
          d.g.b.k.fvU();
        }
        ((com.tencent.mm.plugin.report.service.h)localObject).f(16324, new Object[] { Integer.valueOf(2), paramView.CQp, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(7), Integer.valueOf(paramInt), Integer.valueOf(CardHomePageNewUI.m(this.nEK)) });
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu", "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$initView$4$1$1"})
    static final class a
      implements n.c
    {
      a(CardHomePageNewUI.l paraml, int paramInt) {}
      
      public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
      {
        AppMethodBeat.i(112449);
        paraml.c(1, (CharSequence)this.nFo.nEK.getString(2131755707));
        AppMethodBeat.o(112449);
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected", "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$initView$4$1$2"})
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
          com.tencent.mm.ui.base.h.a((Context)jdField_this.nEK.getContext(), jdField_this.nEK.getString(2131756898), "", false, (DialogInterface.OnClickListener)new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(112450);
              Object localObject1 = this.nFq.nFo.nEK;
              Object localObject2 = this.nFq.nFp.nEE;
              if (localObject2 == null) {
                d.g.b.k.fvU();
              }
              localObject2 = ((qs)localObject2).CQp;
              d.g.b.k.g(localObject2, "element!!.card_pack_merchant_id");
              d.g.b.k.h(localObject2, "merchantId");
              ad.i("MicroMsg.CardHomePageNewUI", "do delete merchant: %s", new Object[] { localObject2 });
              new com.tencent.mm.plugin.card.model.a.d((String)localObject2).auK().b((com.tencent.mm.vending.c.a)new CardHomePageNewUI.f((CardHomePageNewUI)localObject1, (String)localObject2));
              paramAnonymousDialogInterface.dismiss();
              paramAnonymousDialogInterface = com.tencent.mm.plugin.report.service.h.vKh;
              localObject1 = this.nFq.nFp.nEE;
              if (localObject1 == null) {
                d.g.b.k.fvU();
              }
              paramAnonymousDialogInterface.f(16324, new Object[] { Integer.valueOf(2), ((qs)localObject1).CQp, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(9), Integer.valueOf(this.nFq.lKu), Integer.valueOf(CardHomePageNewUI.m(this.nFq.nFo.nEK)) });
              AppMethodBeat.o(112450);
            }
          });
          paramMenuItem = com.tencent.mm.plugin.report.service.h.vKh;
          qs localqs = this.nFp.nEE;
          if (localqs == null) {
            d.g.b.k.fvU();
          }
          paramMenuItem.f(16324, new Object[] { Integer.valueOf(2), localqs.CQp, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(8), Integer.valueOf(paramInt), Integer.valueOf(CardHomePageNewUI.m(jdField_this.nEK)) });
        }
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick", "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$setFaqIconMenu$1$1"})
  static final class n
    implements MenuItem.OnMenuItemClickListener
  {
    n(qt paramqt, CardHomePageNewUI paramCardHomePageNewUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(112456);
      paramMenuItem = new com.tencent.mm.ui.widget.a.e((Context)jdField_this.getContext(), 1, false);
      paramMenuItem.a((n.c)new n.c()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
        {
          AppMethodBeat.i(112454);
          paramAnonymousl.add(0, 0, 1, (CharSequence)this.nFs.nFr.CQD);
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
            switch (this.nFs.nFr.CQE)
            {
            }
          }
          for (;;)
          {
            AppMethodBeat.o(112455);
            return;
            com.tencent.mm.plugin.card.d.b.a((MMActivity)this.nFs.nEK, this.nFs.nFr.CQF);
            AppMethodBeat.o(112455);
            return;
            paramAnonymousMenuItem = this.nFs.nFr.CQG;
            com.tencent.mm.plugin.card.d.b.G(paramAnonymousMenuItem.zHs, paramAnonymousMenuItem.zHt, paramAnonymousMenuItem.Aoy);
          }
        }
      });
      paramMenuItem.csG();
      AppMethodBeat.o(112456);
      return false;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu", "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$showSortSheet$1$1"})
  static final class o
    implements n.c
  {
    o(CardHomePageNewUI paramCardHomePageNewUI) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
    {
      AppMethodBeat.i(112457);
      Iterator localIterator = ((Iterable)CardHomePageNewUI.y(this.nEK)).iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        paraml.add(0, i, 1, (CharSequence)((rk)localIterator.next()).CRu);
        i += 1;
      }
      AppMethodBeat.o(112457);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected", "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$showSortSheet$1$2"})
  static final class p
    implements n.d
  {
    p(CardHomePageNewUI paramCardHomePageNewUI) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(112459);
      d.g.b.k.g(paramMenuItem, "menuItem");
      paramInt = paramMenuItem.getItemId();
      ad.i("MicroMsg.CardHomePageNewUI", "click item: %s, sortType: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(CardHomePageNewUI.m(this.nEK)) });
      paramMenuItem = CardHomePageNewUI.y(this.nEK).get(paramInt);
      d.g.b.k.g(paramMenuItem, "cardSortInfoList[itemId]");
      paramMenuItem = (rk)paramMenuItem;
      CardHomePageNewUI.d(this.nEK, paramMenuItem.CRt);
      if ((paramMenuItem.CRs == 1) && (CardHomePageNewUI.m(this.nEK) != 1))
      {
        if (!this.nEK.nFG)
        {
          com.tencent.mm.ui.base.h.a((Context)this.nEK.getContext(), this.nEK.getString(2131756893), this.nEK.getString(2131761885), this.nEK.getString(2131760598), this.nEK.getString(2131757558), false, (DialogInterface.OnClickListener)new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(112458);
              this.nFt.nEK.startActivityForResult(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"), 564);
              AppMethodBeat.o(112458);
            }
          }, null);
          AppMethodBeat.o(112459);
          return;
        }
        CardHomePageNewUI.b(this.nEK, true);
        CardHomePageNewUI.c(this.nEK, 0);
        CardHomePageNewUI.b(this.nEK, 1);
        CardHomePageNewUI.r(this.nEK);
        com.tencent.mm.plugin.report.service.h.vKh.f(16322, new Object[] { Integer.valueOf(15) });
        AppMethodBeat.o(112459);
        return;
      }
      if ((paramMenuItem.CRs == 2) && (CardHomePageNewUI.m(this.nEK) != 2))
      {
        CardHomePageNewUI.b(this.nEK, true);
        CardHomePageNewUI.c(this.nEK, 0);
        CardHomePageNewUI.b(this.nEK, 2);
        CardHomePageNewUI.r(this.nEK);
        com.tencent.mm.plugin.report.service.h.vKh.f(16322, new Object[] { Integer.valueOf(16) });
        AppMethodBeat.o(112459);
        return;
      }
      if ((paramMenuItem.CRs == 3) && (CardHomePageNewUI.m(this.nEK) != 3))
      {
        CardHomePageNewUI.b(this.nEK, true);
        CardHomePageNewUI.c(this.nEK, 0);
        CardHomePageNewUI.b(this.nEK, 3);
        CardHomePageNewUI.r(this.nEK);
        com.tencent.mm.plugin.report.service.h.vKh.f(16322, new Object[] { Integer.valueOf(17) });
      }
      AppMethodBeat.o(112459);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v2.CardHomePageNewUI
 * JD-Core Version:    0.7.0.1
 */