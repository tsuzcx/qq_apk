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
import com.tencent.mm.aw.a.a.c;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.aw.q;
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
import com.tencent.mm.protocal.protobuf.ss;
import com.tencent.mm.protocal.protobuf.st;
import com.tencent.mm.protocal.protobuf.su;
import com.tencent.mm.protocal.protobuf.sw;
import com.tencent.mm.protocal.protobuf.sx;
import com.tencent.mm.protocal.protobuf.ta;
import com.tencent.mm.protocal.protobuf.tb;
import com.tencent.mm.protocal.protobuf.td;
import com.tencent.mm.protocal.protobuf.te;
import com.tencent.mm.protocal.protobuf.tg;
import com.tencent.mm.protocal.protobuf.to;
import com.tencent.mm.protocal.protobuf.tp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
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
@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI;", "Lcom/tencent/mm/plugin/card/ui/v2/CardNewBaseUI;", "()V", "cardSortInfoList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/CardSortInfo;", "Lkotlin/collections/ArrayList;", "cardTitleModel", "Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$CardListModel;", "clickArea", "", "clickedCardHomePageElement", "Lcom/tencent/mm/protocal/protobuf/CardHomePageElement;", "emptyModel", "faqItem", "Lcom/tencent/mm/protocal/protobuf/CardHomePageFAQItem;", "firstLoad", "", "getCardHomePageScene", "Lcom/tencent/mm/plugin/card/model/v2/CgiGetMktCardHomePage;", "isAll", "isGotoItem", "isLoading", "mDivider", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "mHomePageAdapter", "Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageAdapter;", "mLoadingView", "Landroid/view/ViewGroup;", "mLoadingView2", "mRecyclerView", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "markReloadHomePage", "needReloadHomePage", "offset", "reqNum", "scene", "shouldShowTicket", "showSort", "sortType", "storeModelList", "ticketModel", "ticketNum", "", "tipsDialog", "Landroid/app/Dialog;", "titleSectionModel", "topCellList", "underModelList", "cardSortInfo", "doDeleteMchInList", "", "merchantId", "doGetCardHomePage", "doGetMchInfo", "lastReceiveTime", "", "getLayoutId", "initFirstScreen", "initView", "loadSnapshot", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinishLocationThings", "ret", "isLocationOk", "onResume", "saveSnapshot", "setFaqIconMenu", "showSortSheet", "updateModelList", "storePageList", "Lcom/tencent/mm/protocal/protobuf/CardHomePageStoreList;", "underPageList", "Lcom/tencent/mm/protocal/protobuf/CardHomePageUnderList;", "_topCellList", "Lcom/tencent/mm/protocal/protobuf/CardHomePageTopCellList;", "CardListModel", "CardSpan", "Companion", "HomePageAdapter", "HomePageVH", "plugin-card_release"})
public final class CardHomePageNewUI
  extends CardNewBaseUI
{
  private static final int daw;
  private static final int oKW;
  private static final int oKX;
  public static final CardHomePageNewUI.c oKY;
  private boolean gjj;
  private Dialog iVd;
  private boolean isLoading;
  private int oBj;
  private RecyclerView.h oKA;
  private ViewGroup oKB;
  private int oKC;
  private boolean oKD;
  private String oKE;
  private final ArrayList<a> oKF;
  private final ArrayList<a> oKG;
  private final ArrayList<a> oKH;
  private a oKI;
  private a oKJ;
  private a oKK;
  private a oKL;
  private boolean oKM;
  private int oKN;
  private boolean oKO;
  private int oKP;
  private ArrayList<to> oKQ;
  private boolean oKR;
  private sx oKS;
  private sw oKT;
  private boolean oKU;
  private com.tencent.mm.plugin.card.model.a.g oKV;
  private LoadMoreRecyclerView oKx;
  private d oKy;
  private ViewGroup oKz;
  private int offset;
  private int scene;
  
  static
  {
    AppMethodBeat.i(112470);
    oKY = new CardHomePageNewUI.c((byte)0);
    daw = com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 40);
    oKW = com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 1);
    oKX = com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 16);
    AppMethodBeat.o(112470);
  }
  
  public CardHomePageNewUI()
  {
    AppMethodBeat.i(112469);
    this.oKC = 10;
    this.oKE = "";
    this.oKF = new ArrayList();
    this.oKG = new ArrayList();
    this.oKH = new ArrayList();
    this.gjj = true;
    this.oKN = -1;
    this.oKO = true;
    this.oKQ = new ArrayList();
    this.oKS = new sx();
    AppMethodBeat.o(112469);
  }
  
  private final void bXU()
  {
    AppMethodBeat.i(112468);
    ad.i("MicroMsg.CardHomePageNewUI", "do get card Home page: %s, %s", new Object[] { Boolean.valueOf(this.oKD), Boolean.valueOf(this.isLoading) });
    Object localObject;
    if ((this.oKU) || ((!this.oKD) && (!this.isLoading)))
    {
      this.isLoading = true;
      if (this.oKU)
      {
        localObject = this.oKB;
        if (localObject == null) {
          p.bcb("mLoadingView2");
        }
        ((ViewGroup)localObject).setVisibility(0);
        if (this.oKK != null)
        {
          localObject = this.oKB;
          if (localObject == null) {
            p.bcb("mLoadingView2");
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
          ViewGroup localViewGroup = this.oKB;
          if (localViewGroup == null) {
            p.bcb("mLoadingView2");
          }
          localViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
      localObject = bXT();
      if (localObject == null) {
        break label361;
      }
    }
    label361:
    for (int i = ((to)localObject).FRn;; i = 10)
    {
      this.oKC = i;
      if (this.iVd != null)
      {
        localObject = this.iVd;
        if (localObject == null) {
          p.gfZ();
        }
        ((Dialog)localObject).dismiss();
      }
      if (this.oKG.isEmpty())
      {
        localObject = (Context)getContext();
        getContext().getString(2131755726);
        this.iVd = ((Dialog)h.b((Context)localObject, getContext().getString(2131760709), true, null));
      }
      this.oKV = new com.tencent.mm.plugin.card.model.a.g(this.offset, this.oKC, this.dyz, this.dAp, this.oBj);
      localObject = this.oKV;
      if (localObject == null) {
        p.gfZ();
      }
      ((com.tencent.mm.plugin.card.model.a.g)localObject).aEC().aED().b((com.tencent.mm.vending.c.a)new g(this)).a((com.tencent.mm.vending.e.b)this);
      AppMethodBeat.o(112468);
      return;
    }
  }
  
  public final void V(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(112465);
    ad.i("MicroMsg.CardHomePageNewUI", "location finish: [%s, %s], ret: %s, isOk: %s", new Object[] { Float.valueOf(this.dyz), Float.valueOf(this.dAp), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    if (this.gjj)
    {
      if ((this.oKP == 1) && (paramInt < 0) && (this.oBj == 1))
      {
        this.oBj = 0;
        if (paramInt == -2) {
          com.tencent.mm.plugin.report.service.g.yhR.f(16322, new Object[] { Integer.valueOf(30) });
        }
      }
      bXU();
      AppMethodBeat.o(112465);
      return;
    }
    if (!paramBoolean) {
      bYd();
    }
    AppMethodBeat.o(112465);
  }
  
  public final void a(ta paramta, te paramte, td paramtd)
  {
    int j = 0;
    AppMethodBeat.i(112467);
    Object localObject;
    int i;
    if (paramta != null)
    {
      localObject = paramta.FQE;
      p.g(localObject, "card_home_page_element");
      if (!((Collection)localObject).isEmpty()) {}
      for (i = 1; i != 0; i = 0)
      {
        paramta = paramta.FQE.iterator();
        while (paramta.hasNext())
        {
          localObject = (sw)paramta.next();
          a locala = new a();
          locala.oKZ = ((sw)localObject);
          locala.type = 0;
          this.oKG.add(locala);
        }
      }
    }
    if (paramte != null)
    {
      paramta = paramte.FQE;
      p.g(paramta, "card_home_page_element");
      if (!((Collection)paramta).isEmpty()) {}
      for (i = 1; i != 0; i = 0)
      {
        if (bt.isNullOrNil(paramte.FQQ)) {
          paramte.FQQ = getString(2131756875);
        }
        if (this.oKJ == null)
        {
          this.oKJ = new a();
          paramta = this.oKJ;
          if (paramta == null) {
            p.gfZ();
          }
          paramta.type = 1;
        }
        paramta = this.oKJ;
        if (paramta == null) {
          p.gfZ();
        }
        localObject = paramte.FQQ;
        p.g(localObject, "section_title");
        paramta.YO((String)localObject);
        paramta = paramte.FQE.iterator();
        while (paramta.hasNext())
        {
          paramte = (sw)paramta.next();
          localObject = new a();
          ((a)localObject).oKZ = paramte;
          ((a)localObject).type = 2;
          this.oKH.add(localObject);
        }
      }
    }
    if (paramtd != null)
    {
      paramta = paramtd.FQP;
      p.g(paramta, "card_home_page_top_cell");
      if (!((Collection)paramta).isEmpty()) {}
      for (i = 1; i != 0; i = 0)
      {
        paramta = paramtd.FQP;
        p.g(paramta, "card_home_page_top_cell");
        paramta = ((Iterable)paramta).iterator();
        i = 0;
        while (paramta.hasNext())
        {
          paramte = (tb)paramta.next();
          localObject = new a();
          ((a)localObject).oLd = paramte;
          ((a)localObject).type = 6;
          if (i == paramtd.FQP.size() - 1) {
            ((a)localObject).oLe = true;
          }
          this.oKF.add(localObject);
          i += 1;
        }
      }
    }
    this.oKL = new a();
    paramta = this.oKL;
    if (paramta == null) {
      p.gfZ();
    }
    paramta.type = 5;
    if ((this.oKG.isEmpty()) && (this.oKH.isEmpty()))
    {
      i = j;
      if (!((Collection)this.oKF).isEmpty()) {
        i = 1;
      }
      if (i != 0)
      {
        this.oKI = new a();
        paramta = this.oKI;
        if (paramta == null) {
          p.gfZ();
        }
        paramta.type = 7;
        AppMethodBeat.o(112467);
        return;
      }
    }
    this.oKI = null;
    AppMethodBeat.o(112467);
  }
  
  public final void bXS()
  {
    AppMethodBeat.i(112461);
    sx localsx = this.oKS;
    if (localsx != null)
    {
      if (!bt.isNullOrNil(localsx.FQy))
      {
        removeAllOptionMenu();
        addIconOptionMenu(0, 0, 2131690603, (MenuItem.OnMenuItemClickListener)new n(localsx, this));
      }
      AppMethodBeat.o(112461);
      return;
    }
    AppMethodBeat.o(112461);
  }
  
  public final to bXT()
  {
    AppMethodBeat.i(112466);
    Iterator localIterator = this.oKQ.iterator();
    while (localIterator.hasNext())
    {
      to localto = (to)localIterator.next();
      if (localto.FRm == this.oBj)
      {
        AppMethodBeat.o(112466);
        return localto;
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
    this.oKx = ((LoadMoreRecyclerView)localObject1);
    localObject1 = this.oKx;
    if (localObject1 == null) {
      p.bcb("mRecyclerView");
    }
    getContext();
    ((LoadMoreRecyclerView)localObject1).setLayoutManager((RecyclerView.i)new LinearLayoutManager());
    this.oKy = new d();
    localObject1 = this.oKx;
    if (localObject1 == null) {
      p.bcb("mRecyclerView");
    }
    Object localObject2 = this.oKy;
    if (localObject2 == null) {
      p.bcb("mHomePageAdapter");
    }
    ((LoadMoreRecyclerView)localObject1).setAdapter((RecyclerView.a)localObject2);
    localObject1 = LayoutInflater.from((Context)this);
    localObject2 = this.oKx;
    if (localObject2 == null) {
      p.bcb("mRecyclerView");
    }
    localObject1 = ((LayoutInflater)localObject1).inflate(2131493294, (ViewGroup)localObject2, false);
    if (localObject1 == null)
    {
      localObject1 = new v("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(112464);
      throw ((Throwable)localObject1);
    }
    this.oKz = ((ViewGroup)localObject1);
    localObject1 = findViewById(2131298312);
    p.g(localObject1, "findViewById(R.id.chpu_loading_layout)");
    this.oKB = ((ViewGroup)localObject1);
    localObject1 = this.oKx;
    if (localObject1 == null) {
      p.bcb("mRecyclerView");
    }
    localObject2 = this.oKz;
    if (localObject2 == null) {
      p.bcb("mLoadingView");
    }
    ((LoadMoreRecyclerView)localObject1).setLoadingView((View)localObject2);
    this.oKA = ((RecyclerView.h)new i(this));
    localObject1 = this.oKx;
    if (localObject1 == null) {
      p.bcb("mRecyclerView");
    }
    localObject2 = this.oKA;
    if (localObject2 == null) {
      p.bcb("mDivider");
    }
    ((LoadMoreRecyclerView)localObject1).b((RecyclerView.h)localObject2);
    localObject1 = this.oKx;
    if (localObject1 == null) {
      p.bcb("mRecyclerView");
    }
    ((LoadMoreRecyclerView)localObject1).setOnLoadingStateChangedListener((LoadMoreRecyclerView.a)new j(this));
    localObject1 = this.oKx;
    if (localObject1 == null) {
      p.bcb("mRecyclerView");
    }
    ((LoadMoreRecyclerView)localObject1).setOnItemClickListener((MRecyclerView.a)new k(this));
    localObject1 = this.oKx;
    if (localObject1 == null) {
      p.bcb("mRecyclerView");
    }
    ((LoadMoreRecyclerView)localObject1).setOnItemLongClickListener((MRecyclerView.b)new l(this));
    localObject1 = new ta();
    localObject2 = new te();
    td localtd = new td();
    tp localtp = new tp();
    Object localObject3 = com.tencent.mm.plugin.card.model.a.a.oAY;
    localObject3 = this.oKS;
    p.h(localObject1, "storeList");
    p.h(localObject2, "underList");
    p.h(localtd, "topList");
    p.h(localtp, "cardSortInfoList");
    ad.i(com.tencent.mm.plugin.card.model.a.a.access$getTAG$cp(), "load home page snapshot");
    Object localObject4 = com.tencent.mm.kernel.g.ajC();
    p.g(localObject4, "MMKernel.storage()");
    localObject4 = (String)((com.tencent.mm.kernel.e)localObject4).ajl().i(al.a.IEG);
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
      ((ta)localObject1).parseFrom((byte[])localObject4);
      i = 1;
    }
    localObject4 = com.tencent.mm.kernel.g.ajC();
    p.g(localObject4, "MMKernel.storage()");
    localObject4 = (String)((com.tencent.mm.kernel.e)localObject4).ajl().i(al.a.IEH);
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
      ((te)localObject2).parseFrom((byte[])localObject4);
      i = 1;
    }
    localObject4 = com.tencent.mm.kernel.g.ajC();
    p.g(localObject4, "MMKernel.storage()");
    localObject4 = (String)((com.tencent.mm.kernel.e)localObject4).ajl().i(al.a.IEI);
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
      localtd.parseFrom((byte[])localObject4);
      i = 1;
    }
    localObject4 = com.tencent.mm.kernel.g.ajC();
    p.g(localObject4, "MMKernel.storage()");
    localObject4 = (String)((com.tencent.mm.kernel.e)localObject4).ajl().i(al.a.IEJ);
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
      localtp.parseFrom((byte[])localObject4);
      i = 1;
    }
    localObject4 = com.tencent.mm.kernel.g.ajC();
    p.g(localObject4, "MMKernel.storage()");
    localObject4 = (String)((com.tencent.mm.kernel.e)localObject4).ajl().i(al.a.IEK);
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
        ((sx)localObject3).parseFrom((byte[])localObject4);
        i = j;
      }
    }
    for (;;)
    {
      this.oKQ.clear();
      this.oKQ.addAll((Collection)localtp.FRp);
      a((ta)localObject1, (te)localObject2, localtd);
      if ((i == 0) && (this.oKG.isEmpty()) && (this.oKH.isEmpty()))
      {
        ad.i("MicroMsg.CardHomePageNewUI", "show init view");
        localObject1 = new a();
        ((a)localObject1).type = 3;
        localObject2 = new a();
        ((a)localObject2).type = 3;
        this.oKG.add(localObject1);
        this.oKG.add(localObject2);
      }
      bXS();
      localObject1 = this.oKx;
      if (localObject1 == null) {
        p.bcb("mRecyclerView");
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
    this.oKP = 1;
    paramBundle = com.tencent.mm.kernel.g.ajC();
    p.g(paramBundle, "MMKernel.storage()");
    this.oBj = paramBundle.ajl().getInt(al.a.IEY, 1);
    if (this.oBj == 0) {
      this.oBj = 1;
    }
    if (this.oKP == 1) {
      com.tencent.mm.plugin.report.service.g.yhR.f(16322, new Object[] { Integer.valueOf(14) });
    }
    ad.i("MicroMsg.CardHomePageNewUI", "on create, scene: %s", new Object[] { Integer.valueOf(this.scene) });
    setBackBtn((MenuItem.OnMenuItemClickListener)new CardHomePageNewUI.m(this));
    com.tencent.mm.plugin.report.service.g.yhR.f(16322, new Object[] { Integer.valueOf(4) });
    ((com.tencent.mm.pluginsdk.wallet.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.b.class)).gD(8, 2);
    AppMethodBeat.o(112460);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(112462);
    super.onDestroy();
    Object localObject1 = com.tencent.mm.kernel.g.ajC();
    p.g(localObject1, "MMKernel.storage()");
    ((com.tencent.mm.kernel.e)localObject1).ajl().set(al.a.IEY, Integer.valueOf(this.oBj));
    if (this.oKV != null)
    {
      localObject1 = this.oKV;
      if (localObject1 == null) {
        p.gfZ();
      }
      ((com.tencent.mm.plugin.card.model.a.g)localObject1).cancel();
      this.oKV = null;
    }
    k.bUC();
    ad.i("MicroMsg.CardHomePageNewUI", "do save snap shot");
    Object localObject3 = new ta();
    ((ta)localObject3).FQE = new LinkedList();
    localObject1 = this.oKG.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((a)((Iterator)localObject1).next()).oKZ;
      if (localObject2 != null) {
        ((ta)localObject3).FQE.add(localObject2);
      }
    }
    Object localObject2 = new te();
    localObject1 = this.oKJ;
    if (localObject1 != null) {}
    for (localObject1 = ((a)localObject1).bXX();; localObject1 = null)
    {
      ((te)localObject2).FQQ = ((String)localObject1);
      ((te)localObject2).FQE = new LinkedList();
      localObject1 = this.oKH.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject4 = ((a)((Iterator)localObject1).next()).oKZ;
        if (localObject4 != null) {
          ((te)localObject2).FQE.add(localObject4);
        }
      }
    }
    td localtd = new td();
    localObject1 = this.oKF.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject4 = ((a)((Iterator)localObject1).next()).oLd;
      if (localObject4 != null) {
        localtd.FQP.add(localObject4);
      }
    }
    Object localObject4 = new tp();
    ((tp)localObject4).FRp.addAll((Collection)this.oKQ);
    localObject1 = com.tencent.mm.plugin.card.model.a.a.oAY;
    localObject1 = this.oKS;
    p.h(localObject3, "storeList");
    p.h(localObject2, "underList");
    p.h(localtd, "topList");
    p.h(localObject4, "sortInfoList");
    ad.i(com.tencent.mm.plugin.card.model.a.a.access$getTAG$cp(), "save home page snapshot");
    localObject3 = ((ta)localObject3).toByteArray();
    p.g(localObject3, "storeList.toByteArray()");
    localObject3 = new String((byte[])localObject3, d.n.d.ISO_8859_1);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.ajC();
    p.g(locale, "MMKernel.storage()");
    locale.ajl().set(al.a.IEG, localObject3);
    localObject2 = ((te)localObject2).toByteArray();
    p.g(localObject2, "underList.toByteArray()");
    localObject2 = new String((byte[])localObject2, d.n.d.ISO_8859_1);
    localObject3 = com.tencent.mm.kernel.g.ajC();
    p.g(localObject3, "MMKernel.storage()");
    ((com.tencent.mm.kernel.e)localObject3).ajl().set(al.a.IEH, localObject2);
    localObject2 = localtd.toByteArray();
    p.g(localObject2, "topList.toByteArray()");
    localObject2 = new String((byte[])localObject2, d.n.d.ISO_8859_1);
    localObject3 = com.tencent.mm.kernel.g.ajC();
    p.g(localObject3, "MMKernel.storage()");
    ((com.tencent.mm.kernel.e)localObject3).ajl().set(al.a.IEI, localObject2);
    localObject2 = ((tp)localObject4).toByteArray();
    p.g(localObject2, "sortInfoList.toByteArray()");
    localObject2 = new String((byte[])localObject2, d.n.d.ISO_8859_1);
    localObject3 = com.tencent.mm.kernel.g.ajC();
    p.g(localObject3, "MMKernel.storage()");
    ((com.tencent.mm.kernel.e)localObject3).ajl().set(al.a.IEJ, localObject2);
    if (localObject1 != null)
    {
      localObject1 = ((sx)localObject1).toByteArray();
      p.g(localObject1, "faqItem.toByteArray()");
      localObject1 = new String((byte[])localObject1, d.n.d.ISO_8859_1);
      localObject2 = com.tencent.mm.kernel.g.ajC();
      p.g(localObject2, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject2).ajl().set(al.a.IEK, localObject1);
    }
    AppMethodBeat.o(112462);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(112463);
    super.onResume();
    if ((this.oKM) && (this.oKT != null) && (this.oKN != -1))
    {
      Object localObject = this.oKT;
      if (localObject == null) {
        p.gfZ();
      }
      localObject = ((sw)localObject).FQk;
      p.g(localObject, "clickedCardHomePageElement!!.card_pack_merchant_id");
      sw localsw = this.oKT;
      if (localsw == null) {
        p.gfZ();
      }
      long l = localsw.FQx;
      ad.i("MicroMsg.CardHomePageNewUI", "do get mch infoset: %s", new Object[] { localObject });
      new com.tencent.mm.plugin.card.model.a.f((String)localObject, l, this.dyz, this.dAp, this.oBj).aED().b((com.tencent.mm.vending.c.a)new h(this, (String)localObject));
      this.oKM = false;
      this.oKT = null;
      AppMethodBeat.o(112463);
      return;
    }
    if (this.oKR)
    {
      this.oKU = true;
      this.offset = 0;
      this.oKR = false;
      bXU();
    }
    AppMethodBeat.o(112463);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$CardListModel;", "", "(Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI;)V", "element", "Lcom/tencent/mm/protocal/protobuf/CardHomePageElement;", "getElement", "()Lcom/tencent/mm/protocal/protobuf/CardHomePageElement;", "setElement", "(Lcom/tencent/mm/protocal/protobuf/CardHomePageElement;)V", "expandState", "", "getExpandState", "()Z", "setExpandState", "(Z)V", "hasRender", "getHasRender", "setHasRender", "sectionTitle", "", "getSectionTitle", "()Ljava/lang/String;", "setSectionTitle", "(Ljava/lang/String;)V", "showDivider", "getShowDivider", "setShowDivider", "topElement", "Lcom/tencent/mm/protocal/protobuf/CardHomePageTopCell;", "getTopElement", "()Lcom/tencent/mm/protocal/protobuf/CardHomePageTopCell;", "setTopElement", "(Lcom/tencent/mm/protocal/protobuf/CardHomePageTopCell;)V", "type", "", "getType", "()I", "setType", "(I)V", "plugin-card_release"})
  public final class a
  {
    sw oKZ;
    public String oLa;
    boolean oLb;
    boolean oLc;
    tb oLd;
    boolean oLe;
    int type;
    
    public final void YO(String paramString)
    {
      AppMethodBeat.i(112405);
      p.h(paramString, "<set-?>");
      this.oLa = paramString;
      AppMethodBeat.o(112405);
    }
    
    public final String bXX()
    {
      AppMethodBeat.i(112404);
      String str = this.oLa;
      if (str == null) {
        p.bcb("sectionTitle");
      }
      AppMethodBeat.o(112404);
      return str;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH;", "Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI;", "(Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI;)V", "appendUnderList", "", "model", "Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$CardListModel;", "getItemCount", "", "getItemViewType", "position", "getModelByPos", "getPosByMerchantId", "merchantId", "", "moveStoreToUnderList", "", "element", "Lcom/tencent/mm/protocal/protobuf/CardHomePageElement;", "onBindViewHolder", "holder", "payloads", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "removeModelByMId", "removeTitleSection", "replaceModelByMId", "mchInfo", "plugin-card_release"})
  public final class d
    extends RecyclerView.a<CardHomePageNewUI.e>
  {
    private int YQ(String paramString)
    {
      int k = 0;
      AppMethodBeat.i(112415);
      p.h(paramString, "merchantId");
      if (CardHomePageNewUI.g(this.oLf) != null) {}
      for (int i = 1;; i = 0)
      {
        if (CardHomePageNewUI.f(this.oLf) != null) {
          i += 1;
        }
        for (;;)
        {
          Iterator localIterator = ((Iterable)CardHomePageNewUI.a(this.oLf)).iterator();
          int j = 0;
          Object localObject;
          while (localIterator.hasNext())
          {
            localObject = ((CardHomePageNewUI.a)localIterator.next()).oKZ;
            if (localObject != null) {}
            for (localObject = ((sw)localObject).FQk; p.i(localObject, paramString); localObject = null)
            {
              AppMethodBeat.o(112415);
              return i + j;
            }
            j += 1;
          }
          i = CardHomePageNewUI.a(this.oLf).size() + i - 1;
          if (CardHomePageNewUI.c(this.oLf) != null) {
            i += 1;
          }
          for (;;)
          {
            localIterator = ((Iterable)CardHomePageNewUI.b(this.oLf)).iterator();
            j = k;
            while (localIterator.hasNext())
            {
              localObject = ((CardHomePageNewUI.a)localIterator.next()).oKZ;
              if (localObject != null) {}
              for (localObject = ((sw)localObject).FQk; p.i(localObject, paramString); localObject = null)
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
    
    public final CardHomePageNewUI.a AG(int paramInt)
    {
      int j = 0;
      AppMethodBeat.i(112413);
      Object localObject1 = CardHomePageNewUI.a(this.oLf);
      Object localObject2;
      if (localObject1 != null)
      {
        localObject1 = Integer.valueOf(((ArrayList)localObject1).size());
        localObject2 = CardHomePageNewUI.a(this.oLf);
        if (localObject2 == null) {
          break label156;
        }
        localObject2 = Integer.valueOf(((ArrayList)localObject2).size());
        label55:
        if (CardHomePageNewUI.c(this.oLf) == null) {
          break label162;
        }
      }
      label156:
      label162:
      for (boolean bool = true;; bool = false)
      {
        ad.d("MicroMsg.CardHomePageNewUI", "pos: %s, sSize: %s, uSize: %s, title: %s", new Object[] { Integer.valueOf(paramInt), localObject1, localObject2, Boolean.valueOf(bool) });
        localObject1 = CardHomePageNewUI.g(this.oLf);
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
      localObject1 = CardHomePageNewUI.f(this.oLf);
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
      localObject1 = CardHomePageNewUI.h(this.oLf);
      if ((localObject1 != null) && (paramInt == i))
      {
        AppMethodBeat.o(112413);
        return localObject1;
      }
      localObject1 = CardHomePageNewUI.a(this.oLf);
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
      if (CardHomePageNewUI.c(this.oLf) != null)
      {
        j += 1;
        i = j;
        if (paramInt == j)
        {
          localObject1 = CardHomePageNewUI.c(this.oLf);
          AppMethodBeat.o(112413);
          return localObject1;
        }
      }
      localObject1 = CardHomePageNewUI.b(this.oLf);
      if ((localObject1 != null) && (paramInt > i) && (paramInt <= ((ArrayList)localObject1).size() + i))
      {
        localObject1 = (CardHomePageNewUI.a)((ArrayList)localObject1).get(paramInt - i - 1);
        AppMethodBeat.o(112413);
        return localObject1;
      }
      AppMethodBeat.o(112413);
      return null;
    }
    
    public final void YP(String paramString)
    {
      AppMethodBeat.i(112414);
      p.h(paramString, "merchantId");
      Iterator localIterator = CardHomePageNewUI.a(this.oLf).iterator();
      CardHomePageNewUI.a locala;
      Object localObject;
      while (localIterator.hasNext())
      {
        locala = (CardHomePageNewUI.a)localIterator.next();
        localObject = locala.oKZ;
        if (localObject != null) {}
        for (localObject = ((sw)localObject).FQk; p.i(localObject, paramString); localObject = null)
        {
          CardHomePageNewUI.a(this.oLf).remove(locala);
          paramString = CardHomePageNewUI.j(this.oLf).getAdapter();
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
      localIterator = CardHomePageNewUI.b(this.oLf).iterator();
      while (localIterator.hasNext())
      {
        locala = (CardHomePageNewUI.a)localIterator.next();
        localObject = locala.oKZ;
        if (localObject != null) {}
        for (localObject = ((sw)localObject).FQk; p.i(localObject, paramString); localObject = null)
        {
          CardHomePageNewUI.b(this.oLf).remove(locala);
          if (CardHomePageNewUI.b(this.oLf).size() != 0) {
            break label231;
          }
          CardHomePageNewUI.d(this.oLf);
          paramString = CardHomePageNewUI.j(this.oLf).getAdapter();
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
    
    public final void a(String paramString, sw paramsw)
    {
      AppMethodBeat.i(112416);
      p.h(paramString, "merchantId");
      p.h(paramsw, "mchInfo");
      Iterator localIterator = CardHomePageNewUI.a(this.oLf).iterator();
      CardHomePageNewUI.a locala;
      Object localObject;
      int i;
      while (localIterator.hasNext())
      {
        locala = (CardHomePageNewUI.a)localIterator.next();
        localObject = locala.oKZ;
        if (localObject != null) {}
        for (localObject = ((sw)localObject).FQk; p.i(localObject, paramString); localObject = null)
        {
          locala.oKZ = paramsw;
          i = YQ(paramString);
          if (i < 0) {
            break label130;
          }
          paramString = CardHomePageNewUI.j(this.oLf).getAdapter();
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
      localIterator = CardHomePageNewUI.b(this.oLf).iterator();
      while (localIterator.hasNext())
      {
        locala = (CardHomePageNewUI.a)localIterator.next();
        localObject = locala.oKZ;
        if (localObject != null) {}
        for (localObject = ((sw)localObject).FQk; p.i(localObject, paramString); localObject = null)
        {
          locala.oKZ = paramsw;
          i = YQ(paramString);
          if (i < 0) {
            break label249;
          }
          paramString = CardHomePageNewUI.j(this.oLf).getAdapter();
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
      ArrayList localArrayList = CardHomePageNewUI.a(this.oLf);
      int i;
      int j;
      if (localArrayList != null)
      {
        i = localArrayList.size();
        localArrayList = CardHomePageNewUI.b(this.oLf);
        if (localArrayList == null) {
          break label147;
        }
        j = localArrayList.size();
        label49:
        if (CardHomePageNewUI.c(this.oLf) == null) {
          break label176;
        }
      }
      label147:
      label158:
      label176:
      for (int k = 1;; k = 0)
      {
        if (CardHomePageNewUI.e(this.oLf) != null) {}
        for (int m = 1;; m = 0)
        {
          if (CardHomePageNewUI.f(this.oLf) != null) {}
          for (int n = 1;; n = 0)
          {
            localArrayList = CardHomePageNewUI.g(this.oLf);
            int i1;
            if (localArrayList != null)
            {
              i1 = localArrayList.size();
              label108:
              if (CardHomePageNewUI.h(this.oLf) == null) {
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
      CardHomePageNewUI.a locala = AG(paramInt);
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
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "viewType", "", "(Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI;Landroid/view/View;I)V", "chpiCouponLayout", "Landroid/widget/LinearLayout;", "getChpiCouponLayout", "()Landroid/widget/LinearLayout;", "setChpiCouponLayout", "(Landroid/widget/LinearLayout;)V", "chpiDescTv", "Landroid/widget/TextView;", "getChpiDescTv", "()Landroid/widget/TextView;", "setChpiDescTv", "(Landroid/widget/TextView;)V", "chpiExpandIv", "Landroid/widget/ImageView;", "getChpiExpandIv", "()Landroid/widget/ImageView;", "setChpiExpandIv", "(Landroid/widget/ImageView;)V", "chpiExpandLayout", "getChpiExpandLayout", "setChpiExpandLayout", "chpiExpandTv", "getChpiExpandTv", "setChpiExpandTv", "chpiHeaderLayout", "getChpiHeaderLayout", "setChpiHeaderLayout", "chpiLabelLayout", "getChpiLabelLayout", "setChpiLabelLayout", "chpiLogoIv", "Lcom/tencent/mm/pluginsdk/ui/applet/CdnImageView;", "getChpiLogoIv", "()Lcom/tencent/mm/pluginsdk/ui/applet/CdnImageView;", "setChpiLogoIv", "(Lcom/tencent/mm/pluginsdk/ui/applet/CdnImageView;)V", "chpiMchLabelTv", "Lcom/tencent/mm/plugin/card/ui/v2/CardLabelTextView;", "getChpiMchLabelTv", "()Lcom/tencent/mm/plugin/card/ui/v2/CardLabelTextView;", "setChpiMchLabelTv", "(Lcom/tencent/mm/plugin/card/ui/v2/CardLabelTextView;)V", "chpiNameTv", "getChpiNameTv", "setChpiNameTv", "chtiDescTv", "getChtiDescTv", "setChtiDescTv", "chtiDivider", "getChtiDivider", "()Landroid/view/View;", "setChtiDivider", "(Landroid/view/View;)V", "chtiIconIv", "getChtiIconIv", "setChtiIconIv", "chtiNewTv", "getChtiNewTv", "setChtiNewTv", "chtiRedDotIv", "getChtiRedDotIv", "setChtiRedDotIv", "chtiRightIv", "getChtiRightIv", "setChtiRightIv", "chtiTitleTv", "getChtiTitleTv", "setChtiTitleTv", "model", "Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$CardListModel;", "Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI;", "getModel", "()Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$CardListModel;", "setModel", "(Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$CardListModel;)V", "sectionTitleTv", "getSectionTitleTv", "setSectionTitleTv", "addCouponView", "", "view", "appendCouponView", "offset", "len", "position", "collapseCouponLayout", "expandCouponLayout", "gotoCardDetailUI", "cardId", "", "setCardBg", "imageView", "url", "radius", "", "defaultRes", "setIcon", "useBackendExpandState", "", "showCollapseLayout", "showExpandLayout", "showMiniAppLayout", "updateCardLabelLayout", "couponLabelList", "", "Lcom/tencent/mm/protocal/protobuf/CardElementCouponLabel;", "labelLayout", "labelList", "Lcom/tencent/mm/protocal/protobuf/CardElementMchLabel;", "updateExpandLayout", "isExpended", "plugin-card_release"})
  public final class e
    extends RecyclerView.w
  {
    public TextView oLg;
    public CdnImageView oLh;
    public TextView oLi;
    public TextView oLj;
    public LinearLayout oLk;
    public LinearLayout oLl;
    public LinearLayout oLm;
    public LinearLayout oLn;
    public TextView oLo;
    public ImageView oLp;
    public CardLabelTextView oLq;
    public ImageView oLr;
    public TextView oLs;
    public TextView oLt;
    public ImageView oLu;
    public ImageView oLv;
    public TextView oLw;
    public View oLx;
    CardHomePageNewUI.a oLy;
    
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
        this.oLh = ((CdnImageView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298303);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_username_tv)");
        this.oLi = ((TextView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298293);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_desc_tv)");
        this.oLj = ((TextView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298298);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_label_layout)");
        this.oLl = ((LinearLayout)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298292);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_coupon_layout)");
        this.oLm = ((LinearLayout)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298295);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_expand_layout)");
        this.oLn = ((LinearLayout)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298294);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_expand_iv)");
        this.oLp = ((ImageView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298296);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_expand_tv)");
        this.oLo = ((TextView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298300);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_mch_label_tv)");
        this.oLq = ((CardLabelTextView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298297);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_header_layout)");
        this.oLk = ((LinearLayout)CardHomePageNewUI.this);
        AppMethodBeat.o(112438);
        return;
        this$1 = paramInt.findViewById(2131298301);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_section_title)");
        this.oLg = ((TextView)CardHomePageNewUI.this);
        AppMethodBeat.o(112438);
        return;
        this$1 = paramInt.findViewById(2131298299);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_logo_iv)");
        this.oLh = ((CdnImageView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298303);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_username_tv)");
        this.oLi = ((TextView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298293);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_desc_tv)");
        this.oLj = ((TextView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298300);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_mch_label_tv)");
        this.oLq = ((CardLabelTextView)CardHomePageNewUI.this);
        AppMethodBeat.o(112438);
        return;
        this$1 = paramInt.findViewById(2131298299);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_logo_iv)");
        this.oLh = ((CdnImageView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298303);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_username_tv)");
        this.oLi = ((TextView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298293);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_desc_tv)");
        this.oLj = ((TextView)CardHomePageNewUI.this);
        AppMethodBeat.o(112438);
        return;
        this$1 = paramInt.findViewById(2131298332);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_icon_iv)");
        this.oLr = ((ImageView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298336);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_title_tv)");
        this.oLs = ((TextView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298330);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_desc_tv)");
        this.oLt = ((TextView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298335);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_right_iv)");
        this.oLu = ((ImageView)CardHomePageNewUI.this);
        AppMethodBeat.o(112438);
        return;
        this$1 = paramInt.findViewById(2131298332);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_icon_iv)");
        this.oLr = ((ImageView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298336);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_title_tv)");
        this.oLs = ((TextView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298330);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_desc_tv)");
        this.oLt = ((TextView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298335);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_right_iv)");
        this.oLu = ((ImageView)CardHomePageNewUI.this);
        AppMethodBeat.o(112438);
        return;
        this$1 = paramInt.findViewById(2131298332);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_icon_iv)");
        this.oLr = ((ImageView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298336);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_title_tv)");
        this.oLs = ((TextView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298330);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_desc_tv)");
        this.oLt = ((TextView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298335);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_right_iv)");
        this.oLu = ((ImageView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298334);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_reddot_iv)");
        this.oLv = ((ImageView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298333);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_new_tv)");
        this.oLw = ((TextView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(2131298331);
        p.g(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_divider)");
        this.oLx = CardHomePageNewUI.this;
      }
    }
    
    private final void A(boolean paramBoolean, int paramInt)
    {
      AppMethodBeat.i(112437);
      Object localObject = this.oLy;
      if (localObject == null) {
        p.gfZ();
      }
      localObject = ((CardHomePageNewUI.a)localObject).oKZ;
      if (paramBoolean)
      {
        if (localObject != null) {}
        for (localObject = ((sw)localObject).FQq; !bt.isNullOrNil((String)localObject); localObject = null)
        {
          AH(paramInt);
          AppMethodBeat.o(112437);
          return;
        }
        AJ(paramInt);
        AppMethodBeat.o(112437);
        return;
      }
      AI(paramInt);
      AppMethodBeat.o(112437);
    }
    
    private final void AH(final int paramInt)
    {
      AppMethodBeat.i(112434);
      Object localObject1 = this.oLy;
      if (localObject1 == null) {
        p.gfZ();
      }
      localObject1 = ((CardHomePageNewUI.a)localObject1).oKZ;
      if (localObject1 == null) {
        p.gfZ();
      }
      if (!bt.isNullOrNil(((sw)localObject1).FQq))
      {
        if (!bt.isNullOrNil(((sw)localObject1).FQr))
        {
          localObject2 = this.oLo;
          if (localObject2 == null) {
            p.bcb("chpiExpandTv");
          }
          ((TextView)localObject2).setTextColor(Color.parseColor(((sw)localObject1).FQr));
        }
        Object localObject2 = this.oLo;
        if (localObject2 == null) {
          p.bcb("chpiExpandTv");
        }
        ((TextView)localObject2).setText((CharSequence)((sw)localObject1).FQq);
        localObject2 = this.oLp;
        if (localObject2 == null) {
          p.bcb("chpiExpandIv");
        }
        ((ImageView)localObject2).setImageResource(2131231436);
        localObject2 = this.oLn;
        if (localObject2 == null) {
          p.bcb("chpiExpandLayout");
        }
        ((LinearLayout)localObject2).setOnClickListener((View.OnClickListener)new i((sw)localObject1, this, paramInt));
      }
      AppMethodBeat.o(112434);
    }
    
    private final void AI(final int paramInt)
    {
      AppMethodBeat.i(112435);
      Object localObject1 = this.oLy;
      if (localObject1 == null) {
        p.gfZ();
      }
      localObject1 = ((CardHomePageNewUI.a)localObject1).oKZ;
      Object localObject2 = this.oLo;
      if (localObject2 == null) {
        p.bcb("chpiExpandTv");
      }
      Resources localResources = aj.getResources();
      if (localObject1 == null) {
        p.gfZ();
      }
      ((TextView)localObject2).setText((CharSequence)localResources.getString(2131756876, new Object[] { Integer.valueOf(((sw)localObject1).FQv - ((sw)localObject1).FQw) }));
      localObject2 = this.oLn;
      if (localObject2 == null) {
        p.bcb("chpiExpandLayout");
      }
      ((LinearLayout)localObject2).setOnClickListener((View.OnClickListener)new h(this, paramInt, (sw)localObject1));
      localObject1 = this.oLp;
      if (localObject1 == null) {
        p.bcb("chpiExpandIv");
      }
      ((ImageView)localObject1).setImageResource(2131231497);
      localObject1 = this.oLp;
      if (localObject1 == null) {
        p.bcb("chpiExpandIv");
      }
      ((ImageView)localObject1).setVisibility(0);
      AppMethodBeat.o(112435);
    }
    
    private final void AJ(final int paramInt)
    {
      AppMethodBeat.i(112436);
      Object localObject1 = this.oLy;
      if (localObject1 == null) {
        p.gfZ();
      }
      localObject1 = ((CardHomePageNewUI.a)localObject1).oKZ;
      Object localObject2 = this.oLo;
      if (localObject2 == null) {
        p.bcb("chpiExpandTv");
      }
      ((TextView)localObject2).setText((CharSequence)aj.getResources().getString(2131756874));
      localObject2 = this.oLn;
      if (localObject2 == null) {
        p.bcb("chpiExpandLayout");
      }
      ((LinearLayout)localObject2).setOnClickListener((View.OnClickListener)new g(this, paramInt, (sw)localObject1));
      localObject1 = this.oLp;
      if (localObject1 == null) {
        p.bcb("chpiExpandIv");
      }
      ((ImageView)localObject1).setImageResource(2131231498);
      localObject1 = this.oLp;
      if (localObject1 == null) {
        p.bcb("chpiExpandIv");
      }
      ((ImageView)localObject1).setVisibility(0);
      AppMethodBeat.o(112436);
    }
    
    private final void U(int paramInt1, int paramInt2, final int paramInt3)
    {
      AppMethodBeat.i(112428);
      Object localObject1 = this.oLy;
      if (localObject1 == null) {
        p.gfZ();
      }
      localObject1 = ((CardHomePageNewUI.a)localObject1).oKZ;
      if (localObject1 == null) {
        p.gfZ();
      }
      Object localObject2 = ((sw)localObject1).FQp;
      p.g(localObject2, "el!!.card_element_coupon_list");
      localObject2 = ((Iterable)localObject2).iterator();
      int k = 0;
      int i = 0;
      if (((Iterator)localObject2).hasNext())
      {
        final st localst = (st)((Iterator)localObject2).next();
        int j = i;
        if (k >= paramInt1)
        {
          if (localst.FPS != 1) {
            break label487;
          }
          localObject3 = this.oLm;
          if (localObject3 == null) {
            p.bcb("chpiCouponLayout");
          }
          localObject3 = LayoutInflater.from(((LinearLayout)localObject3).getContext());
          localLinearLayout = this.oLm;
          if (localLinearLayout == null) {
            p.bcb("chpiCouponLayout");
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
          if (!bt.isNullOrNil(localst.FPV)) {
            ((TextView)localObject4).setTextColor(com.tencent.mm.plugin.card.d.l.cK(localst.FPV, localst.FPW));
          }
          p.g(localObject4, "titleTv");
          ((TextView)localObject4).setText((CharSequence)localst.FPM);
          ((CdnImageView)localObject5).setUrl(localst.FPT);
          if (!bt.isNullOrNil(localst.FPX)) {
            ((TextView)localObject6).setTextColor(com.tencent.mm.plugin.card.d.l.cK(localst.FPX, localst.FPY));
          }
          p.g(localObject6, "descTv");
          ((TextView)localObject6).setText((CharSequence)localst.FPN);
          localObject4 = localst.FPR;
          p.g(localObject4, "coupon.coupon_label");
          localObject4 = (List)localObject4;
          p.g(localLinearLayout, "labelLayout");
          a((List)localObject4, localLinearLayout);
          localLinearLayout = this.oLm;
          if (localLinearLayout == null) {
            p.bcb("chpiCouponLayout");
          }
          ((ViewGroup)localObject3).setOnClickListener((View.OnClickListener)new a(this, (sw)localObject1, localst, localLinearLayout.getChildCount(), paramInt3));
          dI((View)localObject3);
        }
        label487:
        while (localst.FPS != 2)
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
        Object localObject3 = this.oLm;
        if (localObject3 == null) {
          p.bcb("chpiCouponLayout");
        }
        localObject3 = LayoutInflater.from(((LinearLayout)localObject3).getContext());
        LinearLayout localLinearLayout = this.oLm;
        if (localLinearLayout == null) {
          p.bcb("chpiCouponLayout");
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
        if (!bt.isNullOrNil(localst.FPV)) {
          ((TextView)localObject5).setTextColor(com.tencent.mm.plugin.card.d.l.cK(localst.FPV, localst.FPW));
        }
        p.g(localObject5, "titleTv");
        ((TextView)localObject5).setText((CharSequence)localst.FPM);
        p.g(localObject6, "descTv");
        ((TextView)localObject6).setText((CharSequence)localst.FPN);
        p.g(localObject7, "bgIv");
        ((MemberCardTopCropImageView)localObject7).setRadius(com.tencent.mm.cc.a.fromDPToPix(((MemberCardTopCropImageView)localObject7).getContext(), 2));
        if (!bt.isNullOrNil(localst.FPQ))
        {
          localObject5 = (ImageView)localObject7;
          localObject6 = localst.FPQ;
          p.g(localObject6, "coupon.coupon_back_url");
          p.h(localObject5, "imageView");
          p.h(localObject6, "url");
          localObject7 = new c.a();
          ((c.a)localObject7).FF(com.tencent.mm.loader.j.b.arU());
          ((c.a)localObject7).a(q.aIK());
          ((c.a)localObject7).FE(m.Yt((String)localObject6));
          ((c.a)localObject7).aIY();
          ((c.a)localObject7).aJb();
          ((c.a)localObject7).aIX();
          ((c.a)localObject7).pH(2131231461);
          ((c.a)localObject7).pG(com.tencent.mm.cc.a.fromDPToPix(((ImageView)localObject5).getContext(), 84));
          ((c.a)localObject7).pF(com.tencent.mm.cc.a.ip(((ImageView)localObject5).getContext()));
          localObject7 = ((c.a)localObject7).aJc();
          q.aIJ().a((String)localObject6, (ImageView)localObject5, (c)localObject7);
          ((ImageView)localObject5).setImageMatrix(new Matrix());
          p.g(localObject4, "shadowBgIv");
          ((ImageView)localObject4).setVisibility(0);
        }
        for (;;)
        {
          localObject4 = localst.FPR;
          p.g(localObject4, "coupon.coupon_label");
          localObject4 = (List)localObject4;
          p.g(localLinearLayout, "labelLayout");
          a((List)localObject4, localLinearLayout);
          localLinearLayout = this.oLm;
          if (localLinearLayout == null) {
            p.bcb("chpiCouponLayout");
          }
          ((ViewGroup)localObject3).setOnClickListener((View.OnClickListener)new b(this, (sw)localObject1, localst, localLinearLayout.getChildCount(), paramInt3));
          dI((View)localObject3);
          break;
          if (!bt.isNullOrNil(localst.FPP))
          {
            ((MemberCardTopCropImageView)localObject7).setImageDrawable((Drawable)new ColorDrawable(Color.parseColor(localst.FPP)));
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
      ((c.a)localObject).FF(com.tencent.mm.loader.j.b.arU());
      ((c.a)localObject).a(q.aIK());
      ((c.a)localObject).FE(m.Yt(paramString));
      ((c.a)localObject).aIY();
      ((c.a)localObject).aJa();
      ((c.a)localObject).aJb();
      ((c.a)localObject).aIX();
      ((c.a)localObject).pH(2131689865);
      localObject = ((c.a)localObject).aJc();
      q.aIJ().a(paramString, paramImageView, (c)localObject);
      AppMethodBeat.o(112433);
    }
    
    private void a(List<? extends ss> paramList, LinearLayout paramLinearLayout)
    {
      AppMethodBeat.i(112432);
      p.h(paramList, "couponLabelList");
      p.h(paramLinearLayout, "labelLayout");
      paramList = paramList.iterator();
      if (paramList.hasNext())
      {
        ss localss = (ss)paramList.next();
        Object localObject1 = this.oLm;
        if (localObject1 == null) {
          p.bcb("chpiCouponLayout");
        }
        localObject1 = new CardTagTextView(((LinearLayout)localObject1).getContext());
        Object localObject2 = this.oLm;
        if (localObject2 == null) {
          p.bcb("chpiCouponLayout");
        }
        localObject2 = ((LinearLayout)localObject2).getContext();
        ((CardTagTextView)localObject1).setMinHeight(com.tencent.mm.cc.a.fromDPToPix((Context)localObject2, 18));
        ((CardTagTextView)localObject1).setMinWidth(com.tencent.mm.cc.a.fromDPToPix((Context)localObject2, 56));
        int i = com.tencent.mm.cc.a.fromDPToPix((Context)localObject2, 8);
        int j = com.tencent.mm.cc.a.fromDPToPix((Context)localObject2, 4);
        ((CardTagTextView)localObject1).setPadding(i, j, i, j);
        ((CardTagTextView)localObject1).setText((CharSequence)localss.FPG);
        ((CardTagTextView)localObject1).setTextSize(1, 10.0F);
        if (!bt.isNullOrNil(localss.FPH))
        {
          ((CardTagTextView)localObject1).setTextColor(Color.parseColor(localss.FPH));
          label199:
          if (bt.isNullOrNil(localss.FPI)) {
            break label249;
          }
          ((CardTagTextView)localObject1).setFillColor(com.tencent.mm.plugin.card.d.l.cK(localss.FPI, localss.FPL));
        }
        for (;;)
        {
          paramLinearLayout.addView((View)localObject1);
          break;
          ((CardTagTextView)localObject1).setTextColor(-1);
          break label199;
          label249:
          ((CardTagTextView)localObject1).setFillColor(com.tencent.mm.plugin.card.d.l.eV(-16777216, 26));
        }
      }
      AppMethodBeat.o(112432);
    }
    
    private void cE(List<? extends su> paramList)
    {
      AppMethodBeat.i(112431);
      p.h(paramList, "labelList");
      Object localObject1 = this.oLl;
      if (localObject1 == null) {
        p.bcb("chpiLabelLayout");
      }
      ((LinearLayout)localObject1).removeAllViews();
      if (paramList.isEmpty())
      {
        paramList = this.oLl;
        if (paramList == null) {
          p.bcb("chpiLabelLayout");
        }
        paramList.setVisibility(8);
        AppMethodBeat.o(112431);
        return;
      }
      paramList = ((Iterable)paramList).iterator();
      int i = 0;
      if (paramList.hasNext())
      {
        Object localObject2 = (su)paramList.next();
        localObject1 = this.oLl;
        if (localObject1 == null) {
          p.bcb("chpiLabelLayout");
        }
        localObject1 = ((LinearLayout)localObject1).getContext();
        p.g(localObject1, "chpiLabelLayout.context");
        localObject1 = new CardLabelTextView((Context)localObject1);
        Object localObject3 = this.oLl;
        if (localObject3 == null) {
          p.bcb("chpiLabelLayout");
        }
        localObject3 = ((LinearLayout)localObject3).getContext();
        ((CardLabelTextView)localObject1).setTextSize(1, 12.0F);
        ((CardLabelTextView)localObject1).setText((CharSequence)((su)localObject2).FQe);
        int j = com.tencent.mm.cc.a.fromDPToPix((Context)localObject3, 4);
        ((CardLabelTextView)localObject1).setPadding(j, 0, j, 0);
        ((CardLabelTextView)localObject1).setGravity(16);
        if (!bt.isNullOrNil(((su)localObject2).FQf))
        {
          ((CardLabelTextView)localObject1).setTextColor(Color.parseColor(((su)localObject2).FQf));
          label240:
          if (bt.isNullOrNil(((su)localObject2).FQg)) {
            break label359;
          }
          ((CardLabelTextView)localObject1).setFillColor(com.tencent.mm.plugin.card.d.l.cK(((su)localObject2).FQg, ((su)localObject2).FQj));
          label269:
          if (i <= 0) {
            break label368;
          }
          localObject2 = new ViewGroup.MarginLayoutParams(-2, -2);
          ((ViewGroup.MarginLayoutParams)localObject2).leftMargin = com.tencent.mm.cc.a.fromDPToPix((Context)localObject3, 4);
          localObject2 = (ViewGroup.MarginLayoutParams)new LinearLayout.LayoutParams((ViewGroup.MarginLayoutParams)localObject2);
          localObject3 = this.oLl;
          if (localObject3 == null) {
            p.bcb("chpiLabelLayout");
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
          localObject2 = this.oLl;
          if (localObject2 == null) {
            p.bcb("chpiLabelLayout");
          }
          ((LinearLayout)localObject2).addView((View)localObject1);
        }
      }
      paramList = this.oLl;
      if (paramList == null) {
        p.bcb("chpiLabelLayout");
      }
      paramList.setVisibility(0);
      AppMethodBeat.o(112431);
    }
    
    private void dI(View paramView)
    {
      AppMethodBeat.i(112430);
      p.h(paramView, "view");
      Object localObject = this.oLm;
      if (localObject == null) {
        p.bcb("chpiCouponLayout");
      }
      if (((LinearLayout)localObject).getChildCount() == 0)
      {
        localObject = this.oLm;
        if (localObject == null) {
          p.bcb("chpiCouponLayout");
        }
        ((LinearLayout)localObject).addView(paramView);
        AppMethodBeat.o(112430);
        return;
      }
      localObject = this.oLm;
      if (localObject == null) {
        p.bcb("chpiCouponLayout");
      }
      localObject = new ViewGroup.MarginLayoutParams(-1, com.tencent.mm.cc.a.fromDPToPix(((LinearLayout)localObject).getContext(), 84));
      LinearLayout localLinearLayout = this.oLm;
      if (localLinearLayout == null) {
        p.bcb("chpiCouponLayout");
      }
      ((ViewGroup.MarginLayoutParams)localObject).topMargin = com.tencent.mm.cc.a.fromDPToPix(localLinearLayout.getContext(), 8);
      localObject = (ViewGroup.MarginLayoutParams)new LinearLayout.LayoutParams((ViewGroup.MarginLayoutParams)localObject);
      localLinearLayout = this.oLm;
      if (localLinearLayout == null) {
        p.bcb("chpiCouponLayout");
      }
      localLinearLayout.addView(paramView, (ViewGroup.LayoutParams)localObject);
      AppMethodBeat.o(112430);
    }
    
    public final void YR(String paramString)
    {
      AppMethodBeat.i(112429);
      p.h(paramString, "cardId");
      ad.i("MicroMsg.CardHomePageNewUI", "go to card detail: %s", new Object[] { paramString });
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
      com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH", "gotoCardDetailUI", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH", "gotoCardDetailUI", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(112429);
    }
    
    public final void a(final CardHomePageNewUI.a parama, final int paramInt)
    {
      AppMethodBeat.i(112426);
      p.h(parama, "model");
      this.oLy = parama;
      Object localObject1 = parama.oKZ;
      switch (parama.type)
      {
      }
      for (;;)
      {
        parama.oLb = true;
        AppMethodBeat.o(112426);
        return;
        if (localObject1 == null) {
          p.gfZ();
        }
        Object localObject2 = this.oLh;
        if (localObject2 == null) {
          p.bcb("chpiLogoIv");
        }
        ((CdnImageView)localObject2).setRoundCorner(true);
        Object localObject3;
        label172:
        int i;
        label511:
        boolean bool;
        if (!bt.isNullOrNil(((sw)localObject1).FQl))
        {
          localObject2 = this.oLh;
          if (localObject2 == null) {
            p.bcb("chpiLogoIv");
          }
          localObject2 = (ImageView)localObject2;
          localObject3 = ((sw)localObject1).FQl;
          p.g(localObject3, "card_element_mch_icon");
          a((ImageView)localObject2, (String)localObject3);
          localObject2 = (View.OnClickListener)new c((sw)localObject1, this, (sw)localObject1, paramInt, parama);
          localObject3 = this.oLh;
          if (localObject3 == null) {
            p.bcb("chpiLogoIv");
          }
          ((CdnImageView)localObject3).setOnClickListener((View.OnClickListener)localObject2);
          localObject3 = CardHomePageNewUI.this;
          Object localObject4 = CardHomePageNewUI.this.getContext();
          p.g(localObject4, "context");
          i = ((AppCompatActivity)localObject4).getResources().getColor(2131100711);
          localObject4 = CardHomePageNewUI.this.getContext();
          p.g(localObject4, "context");
          localObject4 = new CardHomePageNewUI.b((CardHomePageNewUI)localObject3, i, ((AppCompatActivity)localObject4).getResources().getColor(2131100913), (com.tencent.mm.pluginsdk.ui.span.i)new CardHomePageNewUI.e.d((View.OnClickListener)localObject2));
          localObject3 = new SpannableString((CharSequence)((sw)localObject1).FQm);
          ((SpannableString)localObject3).setSpan(localObject4, 0, ((SpannableString)localObject3).length(), 18);
          localObject4 = this.oLi;
          if (localObject4 == null) {
            p.bcb("chpiNameTv");
          }
          ((TextView)localObject4).setClickable(true);
          localObject4 = this.oLi;
          if (localObject4 == null) {
            p.bcb("chpiNameTv");
          }
          ((TextView)localObject4).setOnTouchListener((View.OnTouchListener)new n((Context)CardHomePageNewUI.this));
          localObject4 = this.oLi;
          if (localObject4 == null) {
            p.bcb("chpiNameTv");
          }
          ((TextView)localObject4).setText((CharSequence)localObject3);
          if (bt.isNullOrNil(((sw)localObject1).FQn)) {
            break label912;
          }
          localObject3 = this.oLj;
          if (localObject3 == null) {
            p.bcb("chpiDescTv");
          }
          ((TextView)localObject3).setText((CharSequence)((sw)localObject1).FQn);
          localObject3 = this.oLj;
          if (localObject3 == null) {
            p.bcb("chpiDescTv");
          }
          ((TextView)localObject3).setVisibility(0);
          localObject3 = this.oLj;
          if (localObject3 == null) {
            p.bcb("chpiDescTv");
          }
          ((TextView)localObject3).setOnClickListener((View.OnClickListener)localObject2);
          if (((sw)localObject1).FQt == null) {
            break label1030;
          }
          if (bt.isNullOrNil(((sw)localObject1).FQt.FQe)) {
            break label1003;
          }
          localObject2 = this.oLq;
          if (localObject2 == null) {
            p.bcb("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject2).setText((CharSequence)((sw)localObject1).FQt.FQe);
          if (bt.isNullOrNil(((sw)localObject1).FQt.FQf)) {
            break label939;
          }
          localObject2 = this.oLq;
          if (localObject2 == null) {
            p.bcb("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject2).setTextColor(Color.parseColor(((sw)localObject1).FQt.FQf));
          label613:
          if (bt.isNullOrNil(((sw)localObject1).FQt.FQg)) {
            break label977;
          }
          localObject2 = this.oLq;
          if (localObject2 == null) {
            p.bcb("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject2).setFillColor(com.tencent.mm.plugin.card.d.l.cK(((sw)localObject1).FQt.FQg, ((sw)localObject1).FQt.FQj));
          label668:
          localObject2 = this.oLq;
          if (localObject2 == null) {
            p.bcb("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject2).setVisibility(0);
          label691:
          localObject2 = this.oLm;
          if (localObject2 == null) {
            p.bcb("chpiCouponLayout");
          }
          ((LinearLayout)localObject2).removeAllViews();
          if (parama.oLb) {
            break label1091;
          }
          if (((sw)localObject1).FQu != 1) {
            break label1085;
          }
          bool = true;
          label732:
          if (!bool) {
            break label1183;
          }
          localObject2 = ((sw)localObject1).FQp;
          p.g(localObject2, "card_element_coupon_list");
          if (((Collection)localObject2).isEmpty()) {
            break label1100;
          }
          i = 1;
          label767:
          if (i == 0) {
            break label1105;
          }
          U(-1, ((sw)localObject1).FQp.size(), paramInt);
          localObject2 = this.oLm;
          if (localObject2 == null) {
            p.bcb("chpiCouponLayout");
          }
          ((LinearLayout)localObject2).setVisibility(0);
          parama.oLc = true;
          label813:
          if (bt.isNullOrNil(((sw)localObject1).FQq)) {
            break label1132;
          }
          AH(paramInt);
          localObject2 = this.oLn;
          if (localObject2 == null) {
            p.bcb("chpiExpandLayout");
          }
          ((LinearLayout)localObject2).setVisibility(0);
        }
        label912:
        label939:
        label1085:
        label1213:
        for (;;)
        {
          localObject1 = ((sw)localObject1).FQo;
          p.g(localObject1, "card_element_mch_label");
          cE((List)localObject1);
          localObject1 = z.MKo;
          break;
          localObject2 = this.oLh;
          if (localObject2 == null) {
            p.bcb("chpiLogoIv");
          }
          ((CdnImageView)localObject2).setImageResource(2131689865);
          break label172;
          localObject2 = this.oLj;
          if (localObject2 == null) {
            p.bcb("chpiDescTv");
          }
          ((TextView)localObject2).setVisibility(8);
          break label511;
          localObject2 = this.oLq;
          if (localObject2 == null) {
            p.bcb("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject2).setTextColor(CardHomePageNewUI.this.getResources().getColor(2131101179));
          break label613;
          label977:
          localObject2 = this.oLq;
          if (localObject2 == null) {
            p.bcb("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject2).setFillColor(0);
          break label668;
          label1003:
          localObject2 = this.oLq;
          if (localObject2 == null) {
            p.bcb("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject2).setVisibility(8);
          break label691;
          localObject2 = this.oLq;
          if (localObject2 == null) {
            p.bcb("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject2).setText((CharSequence)"");
          localObject2 = this.oLq;
          if (localObject2 == null) {
            p.bcb("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject2).setVisibility(8);
          break label691;
          bool = false;
          break label732;
          label1091:
          bool = parama.oLc;
          break label732;
          label1100:
          i = 0;
          break label767;
          label1105:
          localObject2 = this.oLm;
          if (localObject2 == null) {
            p.bcb("chpiCouponLayout");
          }
          ((LinearLayout)localObject2).setVisibility(8);
          break label813;
          label1132:
          if (((sw)localObject1).FQw < ((sw)localObject1).FQp.size())
          {
            AJ(paramInt);
          }
          else
          {
            localObject2 = this.oLn;
            if (localObject2 == null) {
              p.bcb("chpiExpandLayout");
            }
            ((LinearLayout)localObject2).setVisibility(8);
            continue;
            localObject2 = ((sw)localObject1).FQp;
            p.g(localObject2, "card_element_coupon_list");
            if (!((Collection)localObject2).isEmpty())
            {
              i = 1;
              if (i == 0) {
                break label1319;
              }
              U(-1, ((sw)localObject1).FQw, paramInt);
              localObject2 = this.oLm;
              if (localObject2 == null) {
                p.bcb("chpiCouponLayout");
              }
              ((LinearLayout)localObject2).setVisibility(0);
              parama.oLc = false;
            }
            for (;;)
            {
              if (((sw)localObject1).FQw >= ((sw)localObject1).FQp.size())
              {
                if (!bt.isNullOrNil(((sw)localObject1).FQq))
                {
                  AH(paramInt);
                  localObject2 = this.oLn;
                  if (localObject2 == null) {
                    p.bcb("chpiExpandLayout");
                  }
                  ((LinearLayout)localObject2).setVisibility(0);
                  break;
                  i = 0;
                  break label1213;
                  localObject2 = this.oLm;
                  if (localObject2 == null) {
                    p.bcb("chpiCouponLayout");
                  }
                  ((LinearLayout)localObject2).setVisibility(8);
                  continue;
                }
                localObject2 = this.oLn;
                if (localObject2 == null) {
                  p.bcb("chpiExpandLayout");
                }
                ((LinearLayout)localObject2).setVisibility(8);
                break;
              }
            }
            AI(paramInt);
            localObject2 = this.oLn;
            if (localObject2 == null) {
              p.bcb("chpiExpandLayout");
            }
            ((LinearLayout)localObject2).setVisibility(0);
          }
        }
        label1030:
        label1183:
        label1319:
        localObject1 = this.oLg;
        if (localObject1 == null) {
          p.bcb("sectionTitleTv");
        }
        ((TextView)localObject1).setText((CharSequence)parama.bXX());
        continue;
        if (localObject1 == null) {
          p.gfZ();
        }
        localObject2 = this.oLh;
        if (localObject2 == null) {
          p.bcb("chpiLogoIv");
        }
        ((CdnImageView)localObject2).setRoundCorner(true);
        localObject2 = this.oLh;
        if (localObject2 == null) {
          p.bcb("chpiLogoIv");
        }
        ((CdnImageView)localObject2).setUrl(((sw)localObject1).FQl);
        localObject2 = this.oLi;
        if (localObject2 == null) {
          p.bcb("chpiNameTv");
        }
        ((TextView)localObject2).setText((CharSequence)((sw)localObject1).FQm);
        if (!bt.isNullOrNil(((sw)localObject1).FQn))
        {
          localObject2 = this.oLj;
          if (localObject2 == null) {
            p.bcb("chpiDescTv");
          }
          ((TextView)localObject2).setText((CharSequence)((sw)localObject1).FQn);
          localObject2 = this.oLj;
          if (localObject2 == null) {
            p.bcb("chpiDescTv");
          }
          ((TextView)localObject2).setVisibility(0);
          label1588:
          if (((sw)localObject1).FQt == null) {
            break label1894;
          }
          if (bt.isNullOrNil(((sw)localObject1).FQt.FQe)) {
            break label1867;
          }
          localObject2 = this.oLq;
          if (localObject2 == null) {
            p.bcb("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject2).setText((CharSequence)((sw)localObject1).FQt.FQe);
          if (bt.isNullOrNil(((sw)localObject1).FQt.FQf)) {
            break label1803;
          }
          localObject2 = this.oLq;
          if (localObject2 == null) {
            p.bcb("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject2).setTextColor(Color.parseColor(((sw)localObject1).FQt.FQf));
          label1690:
          if (bt.isNullOrNil(((sw)localObject1).FQt.FQg)) {
            break label1841;
          }
          localObject2 = this.oLq;
          if (localObject2 == null) {
            p.bcb("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject2).setFillColor(com.tencent.mm.plugin.card.d.l.cK(((sw)localObject1).FQt.FQg, ((sw)localObject1).FQt.FQj));
          label1745:
          localObject1 = this.oLq;
          if (localObject1 == null) {
            p.bcb("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject1).setVisibility(0);
        }
        for (;;)
        {
          localObject1 = z.MKo;
          break;
          localObject2 = this.oLj;
          if (localObject2 == null) {
            p.bcb("chpiDescTv");
          }
          ((TextView)localObject2).setVisibility(8);
          break label1588;
          label1803:
          localObject2 = this.oLq;
          if (localObject2 == null) {
            p.bcb("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject2).setTextColor(CardHomePageNewUI.this.getResources().getColor(2131101179));
          break label1690;
          label1841:
          localObject1 = this.oLq;
          if (localObject1 == null) {
            p.bcb("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject1).setFillColor(0);
          break label1745;
          label1867:
          localObject1 = this.oLq;
          if (localObject1 == null) {
            p.bcb("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject1).setVisibility(8);
          continue;
          label1894:
          localObject1 = this.oLq;
          if (localObject1 == null) {
            p.bcb("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject1).setText((CharSequence)"");
          localObject1 = this.oLq;
          if (localObject1 == null) {
            p.bcb("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject1).setVisibility(8);
        }
        localObject1 = this.oLh;
        if (localObject1 == null) {
          p.bcb("chpiLogoIv");
        }
        ((CdnImageView)localObject1).setRoundCorner(true);
        localObject1 = this.oLh;
        if (localObject1 == null) {
          p.bcb("chpiLogoIv");
        }
        ((CdnImageView)localObject1).setImageResource(2131689865);
        localObject1 = this.oLi;
        if (localObject1 == null) {
          p.bcb("chpiNameTv");
        }
        ((TextView)localObject1).setText((CharSequence)aj.getResources().getString(2131756877));
        localObject1 = this.oLj;
        if (localObject1 == null) {
          p.bcb("chpiDescTv");
        }
        ((TextView)localObject1).setVisibility(8);
        continue;
        localObject1 = this.oLs;
        if (localObject1 == null) {
          p.bcb("chtiTitleTv");
        }
        ((TextView)localObject1).setText(2131764415);
        if (CardHomePageNewUI.n(CardHomePageNewUI.this) != null)
        {
          localObject1 = this.oLt;
          if (localObject1 == null) {
            p.bcb("chtiDescTv");
          }
          ((TextView)localObject1).setText((CharSequence)CardHomePageNewUI.n(CardHomePageNewUI.this));
          localObject1 = z.MKo;
          continue;
          localObject1 = this.oLs;
          if (localObject1 == null) {
            p.bcb("chtiTitleTv");
          }
          ((TextView)localObject1).setText(2131756948);
          if (CardHomePageNewUI.o(CardHomePageNewUI.this) == 1)
          {
            localObject1 = this.oLt;
            if (localObject1 == null) {
              p.bcb("chtiDescTv");
            }
            ((TextView)localObject1).setVisibility(0);
            localObject1 = this.oLu;
            if (localObject1 == null) {
              p.bcb("chtiRightIv");
            }
            ((ImageView)localObject1).setVisibility(0);
            localObject1 = CardHomePageNewUI.this.bXT();
            if (localObject1 == null)
            {
              localObject1 = this.oLt;
              if (localObject1 == null) {
                p.bcb("chtiDescTv");
              }
              ((TextView)localObject1).setText((CharSequence)"");
            }
            for (;;)
            {
              localObject1 = this.oLt;
              if (localObject1 == null) {
                p.bcb("chtiDescTv");
              }
              ((TextView)localObject1).setOnClickListener((View.OnClickListener)new e(this));
              localObject1 = this.oLu;
              if (localObject1 == null) {
                p.bcb("chtiRightIv");
              }
              ((ImageView)localObject1).setOnClickListener((View.OnClickListener)new f(this));
              localObject1 = this.oLu;
              if (localObject1 == null) {
                p.bcb("chtiRightIv");
              }
              bt.n((View)localObject1, 50, 50, 50, 50);
              break;
              localObject2 = this.oLt;
              if (localObject2 == null) {
                p.bcb("chtiDescTv");
              }
              ((TextView)localObject2).setText((CharSequence)((to)localObject1).FRo);
            }
          }
          localObject1 = this.oLt;
          if (localObject1 == null) {
            p.bcb("chtiDescTv");
          }
          ((TextView)localObject1).setVisibility(8);
          localObject1 = this.oLu;
          if (localObject1 == null) {
            p.bcb("chtiRightIv");
          }
          ((ImageView)localObject1).setVisibility(8);
          continue;
          localObject1 = parama.oLd;
          if (localObject1 != null)
          {
            localObject2 = this.oLs;
            if (localObject2 == null) {
              p.bcb("chtiTitleTv");
            }
            ((TextView)localObject2).setText((CharSequence)((tb)localObject1).FQG);
            localObject2 = this.oLt;
            if (localObject2 == null) {
              p.bcb("chtiDescTv");
            }
            ((TextView)localObject2).setText((CharSequence)((tb)localObject1).FQH);
            localObject2 = this.oLr;
            if (localObject2 == null) {
              p.bcb("chtiIconIv");
            }
            localObject3 = ((tb)localObject1).FQF;
            p.g(localObject3, "card_top_cell_icon");
            a((ImageView)localObject2, (String)localObject3);
            localObject2 = this.oLw;
            if (localObject2 == null) {
              p.bcb("chtiNewTv");
            }
            if (((tb)localObject1).FQN != 1) {
              break label2659;
            }
            paramInt = 0;
            label2581:
            ((TextView)localObject2).setVisibility(paramInt);
            localObject2 = this.oLv;
            if (localObject2 == null) {
              p.bcb("chtiRedDotIv");
            }
            if (((tb)localObject1).FQM != 1) {
              break label2665;
            }
          }
          label2659:
          label2665:
          for (paramInt = 0;; paramInt = 8)
          {
            ((ImageView)localObject2).setVisibility(paramInt);
            localObject1 = z.MKo;
            if (!parama.oLe) {
              break label2671;
            }
            localObject1 = this.oLx;
            if (localObject1 == null) {
              p.bcb("chtiDivider");
            }
            ((View)localObject1).setVisibility(0);
            break;
            paramInt = 8;
            break label2581;
          }
          label2671:
          localObject1 = this.oLx;
          if (localObject1 == null) {
            p.bcb("chtiDivider");
          }
          ((View)localObject1).setVisibility(8);
        }
      }
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(CardHomePageNewUI.e parame, sw paramsw, st paramst, int paramInt1, int paramInt2) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(112417);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$appendCouponView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        CardHomePageNewUI.k(this.oLz.oLf);
        CardHomePageNewUI.a(this.oLz.oLf, 0);
        CardHomePageNewUI.a(this.oLz.oLf, this.oLA);
        paramView = this.oLz;
        localObject = localst.FrW;
        p.g(localObject, "coupon.user_card_id");
        paramView.YR((String)localObject);
        com.tencent.mm.plugin.report.service.g.yhR.f(16324, new Object[] { Integer.valueOf(1), this.oLA.FQk, Integer.valueOf(this.odp), localst.FrW, Integer.valueOf(2), Integer.valueOf(paramInt3), Integer.valueOf(CardHomePageNewUI.m(this.oLz.oLf)) });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$appendCouponView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(112417);
      }
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b
      implements View.OnClickListener
    {
      b(CardHomePageNewUI.e parame, sw paramsw, st paramst, int paramInt1, int paramInt2) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(112418);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$appendCouponView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        CardHomePageNewUI.k(this.oLz.oLf);
        CardHomePageNewUI.a(this.oLz.oLf, 0);
        CardHomePageNewUI.a(this.oLz.oLf, this.oLA);
        paramView = this.oLz;
        localObject = localst.FrW;
        p.g(localObject, "coupon.user_card_id");
        paramView.YR((String)localObject);
        com.tencent.mm.plugin.report.service.g.yhR.f(16324, new Object[] { Integer.valueOf(1), this.oLA.FQk, Integer.valueOf(this.odp), localst.FrW, Integer.valueOf(2), Integer.valueOf(paramInt3), Integer.valueOf(CardHomePageNewUI.m(this.oLz.oLf)) });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$appendCouponView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(112418);
      }
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$setModel$1$headerClickListener$1"})
    static final class c
      implements View.OnClickListener
    {
      c(sw paramsw1, CardHomePageNewUI.e parame, sw paramsw2, int paramInt, CardHomePageNewUI.a parama) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(112419);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$setModel$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        ad.i("MicroMsg.CardHomePageNewUI", "click header");
        CardHomePageNewUI.k(jdField_this.oLf);
        CardHomePageNewUI.a(jdField_this.oLf, 0);
        CardHomePageNewUI.a(jdField_this.oLf, this.oLD);
        switch (this.oLC.FQa)
        {
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.g.yhR.f(16324, new Object[] { Integer.valueOf(1), this.oLC.FQk, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(paramInt), Integer.valueOf(CardHomePageNewUI.m(jdField_this.oLf)) });
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
          com.tencent.mm.plugin.card.d.b.a((MMActivity)paramView, this.oLC.FQb);
          continue;
          paramView = this.oLC.FQc;
          com.tencent.mm.plugin.card.d.b.I(paramView.CzQ, paramView.CzR, paramView.Dhk);
        }
      }
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class e
      implements View.OnClickListener
    {
      e(CardHomePageNewUI.e parame) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(112421);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$setModel$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        CardHomePageNewUI.p(this.oLz.oLf);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$setModel$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(112421);
      }
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class f
      implements View.OnClickListener
    {
      f(CardHomePageNewUI.e parame) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(112422);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$setModel$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        CardHomePageNewUI.p(this.oLz.oLf);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$setModel$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(112422);
      }
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class g
      implements View.OnClickListener
    {
      g(CardHomePageNewUI.e parame, int paramInt, sw paramsw) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(112423);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$showCollapseLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        ad.d("MicroMsg.CardHomePageNewUI", "do collapse coupon layout");
        CardHomePageNewUI.e.b(this.oLz, paramInt);
        paramView = this.oLz.oLy;
        if (paramView != null) {
          paramView.oLc = false;
        }
        paramView = com.tencent.mm.plugin.report.service.g.yhR;
        localObject = this.oLA;
        if (localObject == null) {
          p.gfZ();
        }
        paramView.f(16324, new Object[] { Integer.valueOf(1), ((sw)localObject).FQk, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(5), Integer.valueOf(paramInt), Integer.valueOf(CardHomePageNewUI.m(this.oLz.oLf)) });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$showCollapseLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(112423);
      }
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class h
      implements View.OnClickListener
    {
      h(CardHomePageNewUI.e parame, int paramInt, sw paramsw) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(112424);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$showExpandLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        ad.d("MicroMsg.CardHomePageNewUI", "do expand coupon layout");
        CardHomePageNewUI.e.a(this.oLz, paramInt);
        paramView = this.oLz.oLy;
        if (paramView != null) {
          paramView.oLc = true;
        }
        paramView = com.tencent.mm.plugin.report.service.g.yhR;
        localObject = this.oLA;
        if (localObject == null) {
          p.gfZ();
        }
        paramView.f(16324, new Object[] { Integer.valueOf(1), ((sw)localObject).FQk, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(4), Integer.valueOf(paramInt), Integer.valueOf(CardHomePageNewUI.m(this.oLz.oLf)) });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$showExpandLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(112424);
      }
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$showMiniAppLayout$1$1"})
    static final class i
      implements View.OnClickListener
    {
      i(sw paramsw, CardHomePageNewUI.e parame, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(112425);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$showMiniAppLayout$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        if (this.oLC.FQs != null) {
          if (this.oLC.FQs == null) {
            break label266;
          }
        }
        label266:
        for (boolean bool = true;; bool = false)
        {
          ad.i("MicroMsg.CardHomePageNewUI", "detail goto mini app %s", new Object[] { Boolean.valueOf(bool) });
          CardHomePageNewUI.k(jdField_this.oLf);
          CardHomePageNewUI.a(jdField_this.oLf, 0);
          CardHomePageNewUI.a(jdField_this.oLf, this.oLC);
          com.tencent.mm.plugin.card.d.b.I(this.oLC.FQs.CzQ, this.oLC.FQs.CzR, this.oLC.FQs.Dhk);
          paramView = com.tencent.mm.plugin.report.service.g.yhR;
          localObject = jdField_this.oLy;
          if (localObject == null) {
            p.gfZ();
          }
          localObject = ((CardHomePageNewUI.a)localObject).oKZ;
          if (localObject == null) {
            p.gfZ();
          }
          paramView.f(16324, new Object[] { Integer.valueOf(1), ((sw)localObject).FQk, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(6), Integer.valueOf(paramInt), Integer.valueOf(CardHomePageNewUI.m(jdField_this.oLf)) });
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$showMiniAppLayout$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(112425);
          return;
        }
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "kotlin.jvm.PlatformType", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/DeleteMchInListResponse;", "call"})
  static final class f<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    f(CardHomePageNewUI paramCardHomePageNewUI, String paramString) {}
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "kotlin.jvm.PlatformType", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetMktCardHomePageResponse;", "call"})
  static final class g<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    g(CardHomePageNewUI paramCardHomePageNewUI) {}
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetCardPkgMchInfoResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class h<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    h(CardHomePageNewUI paramCardHomePageNewUI, String paramString) {}
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$initView$1", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "paint", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "paint2", "getPaint2", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "onDraw", "c", "Landroid/graphics/Canvas;", "plugin-card_release"})
  public static final class i
    extends RecyclerView.h
  {
    private final Paint oLI;
    private final Paint paint;
    
    i()
    {
      AppMethodBeat.i(112446);
      this.paint = new Paint();
      this.oLI = new Paint();
      this.paint.setColor(localObject.getResources().getColor(2131100886));
      this.paint.setStyle(Paint.Style.FILL);
      this.paint.setFlags(1);
      this.oLI.setColor(localObject.getResources().getColor(2131101179));
      this.oLI.setStyle(Paint.Style.FILL);
      this.oLI.setFlags(1);
      AppMethodBeat.o(112446);
    }
    
    public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.t paramt)
    {
      AppMethodBeat.i(112445);
      p.h(paramCanvas, "c");
      p.h(paramRecyclerView, "parent");
      p.h(paramt, "state");
      super.a(paramCanvas, paramRecyclerView, paramt);
      paramRecyclerView = CardHomePageNewUI.j(this.oLf);
      if (paramRecyclerView != null)
      {
        int i = paramRecyclerView.getPaddingLeft();
        paramt = CardHomePageNewUI.oKY;
        int k = i + CardHomePageNewUI.bXW();
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
            paramt = CardHomePageNewUI.oKY;
          }
          for (int j = CardHomePageNewUI.bXV();; j = 1)
          {
            j = i2 + j;
            if (paramCanvas != null) {
              paramCanvas.drawRect(k, i2, m - n, j, this.paint);
            }
            if (paramCanvas != null) {
              paramCanvas.drawRect(0.0F, i2, k, j, this.oLI);
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
      if (RecyclerView.bw(paramView) == CardHomePageNewUI.q(this.oLf).getItemCount() - 1)
      {
        ad.d("MicroMsg.CardHomePageNewUI", "is last");
        paramView = CardHomePageNewUI.oKY;
        paramRect.bottom = CardHomePageNewUI.bXV();
        AppMethodBeat.o(112444);
        return;
      }
      paramRect.bottom = 1;
      AppMethodBeat.o(112444);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "parent", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "kotlin.jvm.PlatformType", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "onLoadMore"})
  static final class j
    implements LoadMoreRecyclerView.a
  {
    j(CardHomePageNewUI paramCardHomePageNewUI) {}
    
    public final void bAF()
    {
      AppMethodBeat.i(112447);
      CardHomePageNewUI.r(this.oLf);
      AppMethodBeat.o(112447);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "parent", "Landroid/support/v7/widget/RecyclerView;", "kotlin.jvm.PlatformType", "view", "Landroid/view/View;", "position", "", "id", "", "onItemClick"})
  static final class k
    implements MRecyclerView.a
  {
    k(CardHomePageNewUI paramCardHomePageNewUI) {}
    
    public final void T(View paramView, int paramInt)
    {
      AppMethodBeat.i(112448);
      paramView = CardHomePageNewUI.q(this.oLf).AG(paramInt);
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
          CardHomePageNewUI.k(this.oLf);
          CardHomePageNewUI.a(this.oLf, 1);
          CardHomePageNewUI.a(this.oLf, paramView.oKZ);
          localObject1 = paramView.oKZ;
          if (localObject1 == null) {
            p.gfZ();
          }
          switch (((sw)localObject1).FQa)
          {
          }
          for (;;)
          {
            localObject1 = com.tencent.mm.plugin.report.service.g.yhR;
            paramView = paramView.oKZ;
            if (paramView == null) {
              p.gfZ();
            }
            ((com.tencent.mm.plugin.report.service.g)localObject1).f(16324, new Object[] { Integer.valueOf(2), paramView.FQk, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(paramInt), Integer.valueOf(CardHomePageNewUI.m(this.oLf)) });
            AppMethodBeat.o(112448);
            return;
            localObject1 = (MMActivity)this.oLf;
            localObject2 = paramView.oKZ;
            if (localObject2 == null) {
              p.gfZ();
            }
            com.tencent.mm.plugin.card.d.b.a((MMActivity)localObject1, ((sw)localObject2).FQb);
            continue;
            localObject1 = paramView.oKZ;
            if (localObject1 == null) {
              p.gfZ();
            }
            localObject1 = ((sw)localObject1).FQc;
            com.tencent.mm.plugin.card.d.b.I(((tg)localObject1).CzQ, ((tg)localObject1).CzR, ((tg)localObject1).Dhk);
          }
        case 4: 
          ad.i("MicroMsg.CardHomePageNewUI", "click ticket item");
          localObject1 = new Intent((Context)this.oLf, CardTicketListUI.class);
          paramView = this.oLf;
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
          com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahp(), "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$initView$3", "onItemClick", "(Landroid/support/v7/widget/RecyclerView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$initView$3", "onItemClick", "(Landroid/support/v7/widget/RecyclerView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.plugin.report.service.g.yhR.f(16322, new Object[] { Integer.valueOf(5) });
          AppMethodBeat.o(112448);
          return;
        case 5: 
          com.tencent.mm.plugin.report.service.g.yhR.f(16322, new Object[] { Integer.valueOf(13) });
          AppMethodBeat.o(112448);
          return;
        }
        Object localObject1 = paramView.oLd;
        if (localObject1 == null) {
          p.gfZ();
        }
        switch (((tb)localObject1).FQI)
        {
        }
        for (;;)
        {
          localObject1 = paramView.oLd;
          if (localObject1 == null) {
            p.gfZ();
          }
          ((tb)localObject1).FQN = 0;
          paramView = paramView.oLd;
          if (paramView == null) {
            p.gfZ();
          }
          paramView.FQM = 0;
          CardHomePageNewUI.q(this.oLf).cj(paramInt);
          break;
          localObject1 = (MMActivity)this.oLf;
          localObject2 = paramView.oLd;
          if (localObject2 == null) {
            p.gfZ();
          }
          com.tencent.mm.plugin.card.d.b.a((MMActivity)localObject1, ((tb)localObject2).FQJ);
          CardHomePageNewUI.s(this.oLf);
          continue;
          localObject1 = paramView.oLd;
          if (localObject1 == null) {
            p.gfZ();
          }
          localObject1 = ((tb)localObject1).FQK;
          com.tencent.mm.plugin.card.d.b.I(((tg)localObject1).CzQ, ((tg)localObject1).CzR, ((tg)localObject1).Dhk);
          CardHomePageNewUI.s(this.oLf);
          continue;
          localObject1 = new StringBuilder("click native url: ");
          localObject2 = paramView.oLd;
          if (localObject2 == null) {
            p.gfZ();
          }
          ad.i("MicroMsg.CardHomePageNewUI", ((tb)localObject2).FQL);
          localObject1 = paramView.oLd;
          if (localObject1 == null) {
            p.gfZ();
          }
          if (p.i("weixin://mktcard/cert", ((tb)localObject1).FQL))
          {
            localObject2 = new Intent((Context)this.oLf, CardTicketListUI.class);
            localObject1 = this.oLf;
            localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahp(), "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$initView$3", "onItemClick", "(Landroid/support/v7/widget/RecyclerView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((CardHomePageNewUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mq(0));
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$initView$3", "onItemClick", "(Landroid/support/v7/widget/RecyclerView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            CardHomePageNewUI.s(this.oLf);
          }
        }
      }
      AppMethodBeat.o(112448);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "parent", "Landroid/support/v7/widget/RecyclerView;", "kotlin.jvm.PlatformType", "view", "Landroid/view/View;", "position", "", "id", "", "onItemLongClick"})
  static final class l
    implements MRecyclerView.b
  {
    l(CardHomePageNewUI paramCardHomePageNewUI) {}
    
    public final boolean U(View paramView, final int paramInt)
    {
      AppMethodBeat.i(112452);
      paramView = CardHomePageNewUI.q(this.oLf).AG(paramInt);
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
        Object localObject = new com.tencent.mm.ui.tools.l((Context)this.oLf.getContext());
        ((com.tencent.mm.ui.tools.l)localObject).a((n.d)new a(this, paramInt));
        ((com.tencent.mm.ui.tools.l)localObject).a((n.e)new b(paramView, this, paramInt));
        ((com.tencent.mm.ui.tools.l)localObject).fKy();
        localObject = com.tencent.mm.plugin.report.service.g.yhR;
        paramView = paramView.oKZ;
        if (paramView == null) {
          p.gfZ();
        }
        ((com.tencent.mm.plugin.report.service.g)localObject).f(16324, new Object[] { Integer.valueOf(2), paramView.FQk, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(7), Integer.valueOf(paramInt), Integer.valueOf(CardHomePageNewUI.m(this.oLf)) });
      }
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu", "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$initView$4$1$1"})
    static final class a
      implements n.d
    {
      a(CardHomePageNewUI.l paraml, int paramInt) {}
      
      public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
      {
        AppMethodBeat.i(112449);
        paraml.c(1, (CharSequence)this.oLJ.oLf.getString(2131755707));
        AppMethodBeat.o(112449);
      }
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected", "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$initView$4$1$2"})
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
          h.a((Context)jdField_this.oLf.getContext(), jdField_this.oLf.getString(2131756898), "", false, (DialogInterface.OnClickListener)new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(112450);
              Object localObject1 = this.oLL.oLJ.oLf;
              Object localObject2 = this.oLL.oLK.oKZ;
              if (localObject2 == null) {
                p.gfZ();
              }
              localObject2 = ((sw)localObject2).FQk;
              p.g(localObject2, "element!!.card_pack_merchant_id");
              p.h(localObject2, "merchantId");
              ad.i("MicroMsg.CardHomePageNewUI", "do delete merchant: %s", new Object[] { localObject2 });
              new com.tencent.mm.plugin.card.model.a.d((String)localObject2).aED().b((com.tencent.mm.vending.c.a)new CardHomePageNewUI.f((CardHomePageNewUI)localObject1, (String)localObject2));
              paramAnonymousDialogInterface.dismiss();
              paramAnonymousDialogInterface = com.tencent.mm.plugin.report.service.g.yhR;
              localObject1 = this.oLL.oLK.oKZ;
              if (localObject1 == null) {
                p.gfZ();
              }
              paramAnonymousDialogInterface.f(16324, new Object[] { Integer.valueOf(2), ((sw)localObject1).FQk, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(9), Integer.valueOf(this.oLL.mMT), Integer.valueOf(CardHomePageNewUI.m(this.oLL.oLJ.oLf)) });
              AppMethodBeat.o(112450);
            }
          });
          paramMenuItem = com.tencent.mm.plugin.report.service.g.yhR;
          sw localsw = this.oLK.oKZ;
          if (localsw == null) {
            p.gfZ();
          }
          paramMenuItem.f(16324, new Object[] { Integer.valueOf(2), localsw.FQk, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(8), Integer.valueOf(paramInt), Integer.valueOf(CardHomePageNewUI.m(jdField_this.oLf)) });
        }
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick", "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$setFaqIconMenu$1$1"})
  static final class n
    implements MenuItem.OnMenuItemClickListener
  {
    n(sx paramsx, CardHomePageNewUI paramCardHomePageNewUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(112456);
      paramMenuItem = new com.tencent.mm.ui.widget.a.e((Context)jdField_this.getContext(), 1, false);
      paramMenuItem.a((n.d)new n.d()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
        {
          AppMethodBeat.i(112454);
          paramAnonymousl.add(0, 0, 1, (CharSequence)this.oLN.oLM.FQy);
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
            switch (this.oLN.oLM.FQz)
            {
            }
          }
          for (;;)
          {
            AppMethodBeat.o(112455);
            return;
            com.tencent.mm.plugin.card.d.b.a((MMActivity)this.oLN.oLf, this.oLN.oLM.FQA);
            AppMethodBeat.o(112455);
            return;
            paramAnonymousMenuItem = this.oLN.oLM.FQB;
            com.tencent.mm.plugin.card.d.b.I(paramAnonymousMenuItem.CzQ, paramAnonymousMenuItem.CzR, paramAnonymousMenuItem.Dhk);
          }
        }
      });
      paramMenuItem.cMW();
      AppMethodBeat.o(112456);
      return false;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected", "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$showSortSheet$1$2"})
  static final class p
    implements n.e
  {
    p(CardHomePageNewUI paramCardHomePageNewUI) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(112459);
      p.g(paramMenuItem, "menuItem");
      paramInt = paramMenuItem.getItemId();
      ad.i("MicroMsg.CardHomePageNewUI", "click item: %s, sortType: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(CardHomePageNewUI.m(this.oLf)) });
      paramMenuItem = CardHomePageNewUI.y(this.oLf).get(paramInt);
      p.g(paramMenuItem, "cardSortInfoList[itemId]");
      paramMenuItem = (to)paramMenuItem;
      CardHomePageNewUI.d(this.oLf, paramMenuItem.FRn);
      if ((paramMenuItem.FRm == 1) && (CardHomePageNewUI.m(this.oLf) != 1))
      {
        if (!this.oLf.oMb)
        {
          h.a((Context)this.oLf.getContext(), this.oLf.getString(2131756893), this.oLf.getString(2131761885), this.oLf.getString(2131760598), this.oLf.getString(2131757558), false, (DialogInterface.OnClickListener)new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(112458);
              this.oLO.oLf.startActivityForResult(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"), 564);
              AppMethodBeat.o(112458);
            }
          }, null);
          AppMethodBeat.o(112459);
          return;
        }
        CardHomePageNewUI.b(this.oLf, true);
        CardHomePageNewUI.c(this.oLf, 0);
        CardHomePageNewUI.b(this.oLf, 1);
        CardHomePageNewUI.r(this.oLf);
        com.tencent.mm.plugin.report.service.g.yhR.f(16322, new Object[] { Integer.valueOf(15) });
        AppMethodBeat.o(112459);
        return;
      }
      if ((paramMenuItem.FRm == 2) && (CardHomePageNewUI.m(this.oLf) != 2))
      {
        CardHomePageNewUI.b(this.oLf, true);
        CardHomePageNewUI.c(this.oLf, 0);
        CardHomePageNewUI.b(this.oLf, 2);
        CardHomePageNewUI.r(this.oLf);
        com.tencent.mm.plugin.report.service.g.yhR.f(16322, new Object[] { Integer.valueOf(16) });
        AppMethodBeat.o(112459);
        return;
      }
      if ((paramMenuItem.FRm == 3) && (CardHomePageNewUI.m(this.oLf) != 3))
      {
        CardHomePageNewUI.b(this.oLf, true);
        CardHomePageNewUI.c(this.oLf, 0);
        CardHomePageNewUI.b(this.oLf, 3);
        CardHomePageNewUI.r(this.oLf);
        com.tencent.mm.plugin.report.service.g.yhR.f(16322, new Object[] { Integer.valueOf(17) });
      }
      AppMethodBeat.o(112459);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v2.CardHomePageNewUI
 * JD-Core Version:    0.7.0.1
 */