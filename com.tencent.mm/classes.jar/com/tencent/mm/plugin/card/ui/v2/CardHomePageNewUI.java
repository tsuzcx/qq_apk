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
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.s;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.ay.q;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView.a;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.a;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.b;
import com.tencent.mm.plugin.card.a.a;
import com.tencent.mm.plugin.card.a.c;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.a.f;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.model.a.g;
import com.tencent.mm.plugin.card.ui.CardDetailUI;
import com.tencent.mm.plugin.card.widget.CardTagTextView;
import com.tencent.mm.plugin.card.widget.MemberCardTopCropImageView;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.j;
import com.tencent.mm.protocal.protobuf.ub;
import com.tencent.mm.protocal.protobuf.uc;
import com.tencent.mm.protocal.protobuf.ud;
import com.tencent.mm.protocal.protobuf.uf;
import com.tencent.mm.protocal.protobuf.ug;
import com.tencent.mm.protocal.protobuf.uj;
import com.tencent.mm.protocal.protobuf.uk;
import com.tencent.mm.protocal.protobuf.um;
import com.tencent.mm.protocal.protobuf.un;
import com.tencent.mm.protocal.protobuf.up;
import com.tencent.mm.protocal.protobuf.ux;
import com.tencent.mm.protocal.protobuf.uy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.widget.a.e;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.t;
import kotlin.x;

@com.tencent.mm.kernel.k
@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI;", "Lcom/tencent/mm/plugin/card/ui/v2/CardNewBaseUI;", "()V", "cardSortInfoList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/CardSortInfo;", "Lkotlin/collections/ArrayList;", "cardTitleModel", "Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$CardListModel;", "clickArea", "", "clickedCardHomePageElement", "Lcom/tencent/mm/protocal/protobuf/CardHomePageElement;", "emptyModel", "faqItem", "Lcom/tencent/mm/protocal/protobuf/CardHomePageFAQItem;", "firstLoad", "", "getCardHomePageScene", "Lcom/tencent/mm/plugin/card/model/v2/CgiGetMktCardHomePage;", "isAll", "isGotoItem", "isLoading", "mDivider", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "mHomePageAdapter", "Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageAdapter;", "mLoadingView", "Landroid/view/ViewGroup;", "mLoadingView2", "mRecyclerView", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "markReloadHomePage", "needReloadHomePage", "offset", "reqNum", "scene", "shouldShowTicket", "showSort", "sortType", "storeModelList", "ticketModel", "ticketNum", "", "tipsDialog", "Landroid/app/Dialog;", "titleSectionModel", "topCellList", "underModelList", "cardSortInfo", "doDeleteMchInList", "", "merchantId", "doGetCardHomePage", "doGetMchInfo", "lastReceiveTime", "", "getLayoutId", "initFirstScreen", "initView", "loadSnapshot", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinishLocationThings", "ret", "isLocationOk", "onResume", "saveSnapshot", "setFaqIconMenu", "showSortSheet", "updateModelList", "storePageList", "Lcom/tencent/mm/protocal/protobuf/CardHomePageStoreList;", "underPageList", "Lcom/tencent/mm/protocal/protobuf/CardHomePageUnderList;", "_topCellList", "Lcom/tencent/mm/protocal/protobuf/CardHomePageTopCellList;", "CardListModel", "CardSpan", "Companion", "HomePageAdapter", "HomePageVH", "plugin-card_release"})
public final class CardHomePageNewUI
  extends CardNewBaseUI
{
  private static final int fkR;
  private static final int tBj;
  private static final int tBk;
  public static final CardHomePageNewUI.c tBl;
  private boolean isLoading;
  private boolean jHo;
  private Dialog mMi;
  private int offset;
  private int scene;
  private LoadMoreRecyclerView tAK;
  private d tAL;
  private ViewGroup tAM;
  private RecyclerView.h tAN;
  private ViewGroup tAO;
  private int tAP;
  private boolean tAQ;
  private String tAR;
  private final ArrayList<a> tAS;
  private final ArrayList<a> tAT;
  private final ArrayList<a> tAU;
  private a tAV;
  private a tAW;
  private a tAX;
  private a tAY;
  private boolean tAZ;
  private int tBa;
  private boolean tBb;
  private int tBc;
  private ArrayList<ux> tBd;
  private boolean tBe;
  private ug tBf;
  private uf tBg;
  private boolean tBh;
  private g tBi;
  private int trv;
  
  static
  {
    AppMethodBeat.i(112470);
    tBl = new CardHomePageNewUI.c((byte)0);
    fkR = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 40);
    tBj = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 1);
    tBk = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 16);
    AppMethodBeat.o(112470);
  }
  
  public CardHomePageNewUI()
  {
    AppMethodBeat.i(112469);
    this.tAP = 10;
    this.tAR = "";
    this.tAS = new ArrayList();
    this.tAT = new ArrayList();
    this.tAU = new ArrayList();
    this.jHo = true;
    this.tBa = -1;
    this.tBb = true;
    this.tBd = new ArrayList();
    this.tBf = new ug();
    AppMethodBeat.o(112469);
  }
  
  private final void cKC()
  {
    AppMethodBeat.i(112468);
    Log.i("MicroMsg.CardHomePageNewUI", "do get card Home page: %s, %s", new Object[] { Boolean.valueOf(this.tAQ), Boolean.valueOf(this.isLoading) });
    Object localObject;
    if ((this.tBh) || ((!this.tAQ) && (!this.isLoading)))
    {
      this.isLoading = true;
      if (this.tBh)
      {
        localObject = this.tAO;
        if (localObject == null) {
          kotlin.g.b.p.bGy("mLoadingView2");
        }
        ((ViewGroup)localObject).setVisibility(0);
        if (this.tAX != null)
        {
          localObject = this.tAO;
          if (localObject == null) {
            kotlin.g.b.p.bGy("mLoadingView2");
          }
          localObject = ((ViewGroup)localObject).getLayoutParams();
          if (localObject == null)
          {
            localObject = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            AppMethodBeat.o(112468);
            throw ((Throwable)localObject);
          }
          localObject = (RelativeLayout.LayoutParams)localObject;
          ((RelativeLayout.LayoutParams)localObject).topMargin = com.tencent.mm.ci.a.fromDPToPix((Context)getContext(), 80);
          ViewGroup localViewGroup = this.tAO;
          if (localViewGroup == null) {
            kotlin.g.b.p.bGy("mLoadingView2");
          }
          localViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
      localObject = cKB();
      if (localObject == null) {
        break label361;
      }
    }
    label361:
    for (int i = ((ux)localObject).SfE;; i = 10)
    {
      this.tAP = i;
      if (this.mMi != null)
      {
        localObject = this.mMi;
        if (localObject == null) {
          kotlin.g.b.p.iCn();
        }
        ((Dialog)localObject).dismiss();
      }
      if (this.tAT.isEmpty())
      {
        localObject = (Context)getContext();
        getContext().getString(a.g.app_empty_string);
        this.mMi = ((Dialog)com.tencent.mm.ui.base.h.a((Context)localObject, getContext().getString(a.g.loading_tips), true, null));
      }
      this.tBi = new g(this.offset, this.tAP, this.latitude, this.longitude, this.trv);
      localObject = this.tBi;
      if (localObject == null) {
        kotlin.g.b.p.iCn();
      }
      ((g)localObject).bhV().bhW().b((com.tencent.mm.vending.c.a)new g(this)).a((com.tencent.mm.vending.e.b)this);
      AppMethodBeat.o(112468);
      return;
    }
  }
  
  public final void a(uj paramuj, un paramun, um paramum)
  {
    int j = 0;
    AppMethodBeat.i(112467);
    Object localObject;
    int i;
    if (paramuj != null)
    {
      localObject = paramuj.SeV;
      kotlin.g.b.p.j(localObject, "card_home_page_element");
      if (!((Collection)localObject).isEmpty()) {}
      for (i = 1; i != 0; i = 0)
      {
        paramuj = paramuj.SeV.iterator();
        while (paramuj.hasNext())
        {
          localObject = (uf)paramuj.next();
          a locala = new a();
          locala.tBm = ((uf)localObject);
          locala.type = 0;
          this.tAT.add(locala);
        }
      }
    }
    if (paramun != null)
    {
      paramuj = paramun.SeV;
      kotlin.g.b.p.j(paramuj, "card_home_page_element");
      if (!((Collection)paramuj).isEmpty()) {}
      for (i = 1; i != 0; i = 0)
      {
        if (Util.isNullOrNil(paramun.Sfh)) {
          paramun.Sfh = getString(a.g.tkr);
        }
        if (this.tAW == null)
        {
          this.tAW = new a();
          paramuj = this.tAW;
          if (paramuj == null) {
            kotlin.g.b.p.iCn();
          }
          paramuj.type = 1;
        }
        paramuj = this.tAW;
        if (paramuj == null) {
          kotlin.g.b.p.iCn();
        }
        localObject = paramun.Sfh;
        kotlin.g.b.p.j(localObject, "section_title");
        paramuj.arx((String)localObject);
        paramuj = paramun.SeV.iterator();
        while (paramuj.hasNext())
        {
          paramun = (uf)paramuj.next();
          localObject = new a();
          ((a)localObject).tBm = paramun;
          ((a)localObject).type = 2;
          this.tAU.add(localObject);
        }
      }
    }
    if (paramum != null)
    {
      paramuj = paramum.Sfg;
      kotlin.g.b.p.j(paramuj, "card_home_page_top_cell");
      if (!((Collection)paramuj).isEmpty()) {}
      for (i = 1; i != 0; i = 0)
      {
        paramuj = paramum.Sfg;
        kotlin.g.b.p.j(paramuj, "card_home_page_top_cell");
        paramuj = ((Iterable)paramuj).iterator();
        i = 0;
        while (paramuj.hasNext())
        {
          paramun = (uk)paramuj.next();
          localObject = new a();
          ((a)localObject).tBq = paramun;
          ((a)localObject).type = 6;
          if (i == paramum.Sfg.size() - 1) {
            ((a)localObject).tBr = true;
          }
          this.tAS.add(localObject);
          i += 1;
        }
      }
    }
    this.tAY = new a();
    paramuj = this.tAY;
    if (paramuj == null) {
      kotlin.g.b.p.iCn();
    }
    paramuj.type = 5;
    if ((this.tAT.isEmpty()) && (this.tAU.isEmpty()))
    {
      i = j;
      if (!((Collection)this.tAS).isEmpty()) {
        i = 1;
      }
      if (i != 0)
      {
        this.tAV = new a();
        paramuj = this.tAV;
        if (paramuj == null) {
          kotlin.g.b.p.iCn();
        }
        paramuj.type = 7;
        AppMethodBeat.o(112467);
        return;
      }
    }
    this.tAV = null;
    AppMethodBeat.o(112467);
  }
  
  public final void ac(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(112465);
    Log.i("MicroMsg.CardHomePageNewUI", "location finish: [%s, %s], ret: %s, isOk: %s", new Object[] { Float.valueOf(this.latitude), Float.valueOf(this.longitude), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    if (this.jHo)
    {
      if ((this.tBc == 1) && (paramInt < 0) && (this.trv == 1))
      {
        this.trv = 0;
        if (paramInt == -2) {
          com.tencent.mm.plugin.report.service.h.IzE.a(16322, new Object[] { Integer.valueOf(30) });
        }
      }
      cKC();
      AppMethodBeat.o(112465);
      return;
    }
    if (!paramBoolean) {
      cKL();
    }
    AppMethodBeat.o(112465);
  }
  
  public final void cKA()
  {
    AppMethodBeat.i(112461);
    ug localug = this.tBf;
    if (localug != null)
    {
      if (!Util.isNullOrNil(localug.SeO))
      {
        removeAllOptionMenu();
        addIconOptionMenu(0, 0, a.f.icons_outlined_more, (MenuItem.OnMenuItemClickListener)new n(localug, this));
      }
      AppMethodBeat.o(112461);
      return;
    }
    AppMethodBeat.o(112461);
  }
  
  public final ux cKB()
  {
    AppMethodBeat.i(112466);
    Iterator localIterator = this.tBd.iterator();
    while (localIterator.hasNext())
    {
      ux localux = (ux)localIterator.next();
      if (localux.SfD == this.trv)
      {
        AppMethodBeat.o(112466);
        return localux;
      }
    }
    AppMethodBeat.o(112466);
    return null;
  }
  
  public final int getLayoutId()
  {
    return a.e.tiv;
  }
  
  public final void initView()
  {
    int i = 0;
    int j = 1;
    AppMethodBeat.i(112464);
    Object localObject1 = findViewById(a.d.teA);
    kotlin.g.b.p.j(localObject1, "findViewById(R.id.chpu_rv)");
    this.tAK = ((LoadMoreRecyclerView)localObject1);
    localObject1 = this.tAK;
    if (localObject1 == null) {
      kotlin.g.b.p.bGy("mRecyclerView");
    }
    getContext();
    ((LoadMoreRecyclerView)localObject1).setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    this.tAL = new d();
    localObject1 = this.tAK;
    if (localObject1 == null) {
      kotlin.g.b.p.bGy("mRecyclerView");
    }
    Object localObject2 = this.tAL;
    if (localObject2 == null) {
      kotlin.g.b.p.bGy("mHomePageAdapter");
    }
    ((LoadMoreRecyclerView)localObject1).setAdapter((RecyclerView.a)localObject2);
    localObject1 = LayoutInflater.from((Context)this);
    int k = a.e.tis;
    localObject2 = this.tAK;
    if (localObject2 == null) {
      kotlin.g.b.p.bGy("mRecyclerView");
    }
    localObject1 = ((LayoutInflater)localObject1).inflate(k, (ViewGroup)localObject2, false);
    if (localObject1 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(112464);
      throw ((Throwable)localObject1);
    }
    this.tAM = ((ViewGroup)localObject1);
    localObject1 = findViewById(a.d.tez);
    kotlin.g.b.p.j(localObject1, "findViewById(R.id.chpu_loading_layout)");
    this.tAO = ((ViewGroup)localObject1);
    localObject1 = this.tAK;
    if (localObject1 == null) {
      kotlin.g.b.p.bGy("mRecyclerView");
    }
    localObject2 = this.tAM;
    if (localObject2 == null) {
      kotlin.g.b.p.bGy("mLoadingView");
    }
    ((LoadMoreRecyclerView)localObject1).setLoadingView((View)localObject2);
    this.tAN = ((RecyclerView.h)new i(this));
    localObject1 = this.tAK;
    if (localObject1 == null) {
      kotlin.g.b.p.bGy("mRecyclerView");
    }
    localObject2 = this.tAN;
    if (localObject2 == null) {
      kotlin.g.b.p.bGy("mDivider");
    }
    ((LoadMoreRecyclerView)localObject1).b((RecyclerView.h)localObject2);
    localObject1 = this.tAK;
    if (localObject1 == null) {
      kotlin.g.b.p.bGy("mRecyclerView");
    }
    ((LoadMoreRecyclerView)localObject1).setOnLoadingStateChangedListener((LoadMoreRecyclerView.a)new j(this));
    localObject1 = this.tAK;
    if (localObject1 == null) {
      kotlin.g.b.p.bGy("mRecyclerView");
    }
    ((LoadMoreRecyclerView)localObject1).setOnItemClickListener((MRecyclerView.a)new k(this));
    localObject1 = this.tAK;
    if (localObject1 == null) {
      kotlin.g.b.p.bGy("mRecyclerView");
    }
    ((LoadMoreRecyclerView)localObject1).setOnItemLongClickListener((MRecyclerView.b)new l(this));
    localObject1 = new uj();
    localObject2 = new un();
    um localum = new um();
    uy localuy = new uy();
    Object localObject3 = com.tencent.mm.plugin.card.model.a.a.trh;
    localObject3 = this.tBf;
    kotlin.g.b.p.k(localObject1, "storeList");
    kotlin.g.b.p.k(localObject2, "underList");
    kotlin.g.b.p.k(localum, "topList");
    kotlin.g.b.p.k(localuy, "cardSortInfoList");
    Log.i(com.tencent.mm.plugin.card.model.a.a.access$getTAG$cp(), "load home page snapshot");
    Object localObject4 = com.tencent.mm.kernel.h.aHG();
    kotlin.g.b.p.j(localObject4, "MMKernel.storage()");
    localObject4 = (String)((com.tencent.mm.kernel.f)localObject4).aHp().j(ar.a.VvS);
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
      kotlin.g.b.p.j(localObject4, "(this as java.lang.String).getBytes(charset)");
      ((uj)localObject1).parseFrom((byte[])localObject4);
      i = 1;
    }
    localObject4 = com.tencent.mm.kernel.h.aHG();
    kotlin.g.b.p.j(localObject4, "MMKernel.storage()");
    localObject4 = (String)((com.tencent.mm.kernel.f)localObject4).aHp().j(ar.a.VvT);
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
      kotlin.g.b.p.j(localObject4, "(this as java.lang.String).getBytes(charset)");
      ((un)localObject2).parseFrom((byte[])localObject4);
      i = 1;
    }
    localObject4 = com.tencent.mm.kernel.h.aHG();
    kotlin.g.b.p.j(localObject4, "MMKernel.storage()");
    localObject4 = (String)((com.tencent.mm.kernel.f)localObject4).aHp().j(ar.a.VvU);
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
      kotlin.g.b.p.j(localObject4, "(this as java.lang.String).getBytes(charset)");
      localum.parseFrom((byte[])localObject4);
      i = 1;
    }
    localObject4 = com.tencent.mm.kernel.h.aHG();
    kotlin.g.b.p.j(localObject4, "MMKernel.storage()");
    localObject4 = (String)((com.tencent.mm.kernel.f)localObject4).aHp().j(ar.a.VvV);
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
      kotlin.g.b.p.j(localObject4, "(this as java.lang.String).getBytes(charset)");
      localuy.parseFrom((byte[])localObject4);
      i = 1;
    }
    localObject4 = com.tencent.mm.kernel.h.aHG();
    kotlin.g.b.p.j(localObject4, "MMKernel.storage()");
    localObject4 = (String)((com.tencent.mm.kernel.f)localObject4).aHp().j(ar.a.VvW);
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
        kotlin.g.b.p.j(localObject4, "(this as java.lang.String).getBytes(charset)");
        ((ug)localObject3).parseFrom((byte[])localObject4);
        i = j;
      }
    }
    for (;;)
    {
      this.tBd.clear();
      this.tBd.addAll((Collection)localuy.SfG);
      a((uj)localObject1, (un)localObject2, localum);
      if ((i == 0) && (this.tAT.isEmpty()) && (this.tAU.isEmpty()))
      {
        Log.i("MicroMsg.CardHomePageNewUI", "show init view");
        localObject1 = new a();
        ((a)localObject1).type = 3;
        localObject2 = new a();
        ((a)localObject2).type = 3;
        this.tAT.add(localObject1);
        this.tAT.add(localObject2);
      }
      cKA();
      localObject1 = this.tAK;
      if (localObject1 == null) {
        kotlin.g.b.p.bGy("mRecyclerView");
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
    setMMTitle(a.g.tkz);
    this.scene = getIntent().getIntExtra("key_home_page_from_scene", 0);
    initView();
    this.tBc = 1;
    paramBundle = com.tencent.mm.kernel.h.aHG();
    kotlin.g.b.p.j(paramBundle, "MMKernel.storage()");
    this.trv = paramBundle.aHp().getInt(ar.a.Vwt, 1);
    if (this.trv == 0) {
      this.trv = 1;
    }
    if (this.tBc == 1) {
      com.tencent.mm.plugin.report.service.h.IzE.a(16322, new Object[] { Integer.valueOf(14) });
    }
    Log.i("MicroMsg.CardHomePageNewUI", "on create, scene: %s", new Object[] { Integer.valueOf(this.scene) });
    setBackBtn((MenuItem.OnMenuItemClickListener)new CardHomePageNewUI.m(this));
    com.tencent.mm.plugin.report.service.h.IzE.a(16322, new Object[] { Integer.valueOf(4) });
    ((com.tencent.mm.pluginsdk.wallet.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.pluginsdk.wallet.b.class)).ij(8, 2);
    AppMethodBeat.o(112460);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(112462);
    super.onDestroy();
    Object localObject1 = com.tencent.mm.kernel.h.aHG();
    kotlin.g.b.p.j(localObject1, "MMKernel.storage()");
    ((com.tencent.mm.kernel.f)localObject1).aHp().set(ar.a.Vwt, Integer.valueOf(this.trv));
    if (this.tBi != null)
    {
      localObject1 = this.tBi;
      if (localObject1 == null) {
        kotlin.g.b.p.iCn();
      }
      ((g)localObject1).cancel();
      this.tBi = null;
    }
    com.tencent.mm.plugin.card.b.k.cHh();
    Log.i("MicroMsg.CardHomePageNewUI", "do save snap shot");
    Object localObject3 = new uj();
    ((uj)localObject3).SeV = new LinkedList();
    localObject1 = this.tAT.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((a)((Iterator)localObject1).next()).tBm;
      if (localObject2 != null) {
        ((uj)localObject3).SeV.add(localObject2);
      }
    }
    Object localObject2 = new un();
    localObject1 = this.tAW;
    if (localObject1 != null) {}
    for (localObject1 = ((a)localObject1).cKF();; localObject1 = null)
    {
      ((un)localObject2).Sfh = ((String)localObject1);
      ((un)localObject2).SeV = new LinkedList();
      localObject1 = this.tAU.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject4 = ((a)((Iterator)localObject1).next()).tBm;
        if (localObject4 != null) {
          ((un)localObject2).SeV.add(localObject4);
        }
      }
    }
    um localum = new um();
    localObject1 = this.tAS.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject4 = ((a)((Iterator)localObject1).next()).tBq;
      if (localObject4 != null) {
        localum.Sfg.add(localObject4);
      }
    }
    Object localObject4 = new uy();
    ((uy)localObject4).SfG.addAll((Collection)this.tBd);
    localObject1 = com.tencent.mm.plugin.card.model.a.a.trh;
    localObject1 = this.tBf;
    kotlin.g.b.p.k(localObject3, "storeList");
    kotlin.g.b.p.k(localObject2, "underList");
    kotlin.g.b.p.k(localum, "topList");
    kotlin.g.b.p.k(localObject4, "sortInfoList");
    Log.i(com.tencent.mm.plugin.card.model.a.a.access$getTAG$cp(), "save home page snapshot");
    localObject3 = ((uj)localObject3).toByteArray();
    kotlin.g.b.p.j(localObject3, "storeList.toByteArray()");
    localObject3 = new String((byte[])localObject3, kotlin.n.d.ISO_8859_1);
    com.tencent.mm.kernel.f localf = com.tencent.mm.kernel.h.aHG();
    kotlin.g.b.p.j(localf, "MMKernel.storage()");
    localf.aHp().set(ar.a.VvS, localObject3);
    localObject2 = ((un)localObject2).toByteArray();
    kotlin.g.b.p.j(localObject2, "underList.toByteArray()");
    localObject2 = new String((byte[])localObject2, kotlin.n.d.ISO_8859_1);
    localObject3 = com.tencent.mm.kernel.h.aHG();
    kotlin.g.b.p.j(localObject3, "MMKernel.storage()");
    ((com.tencent.mm.kernel.f)localObject3).aHp().set(ar.a.VvT, localObject2);
    localObject2 = localum.toByteArray();
    kotlin.g.b.p.j(localObject2, "topList.toByteArray()");
    localObject2 = new String((byte[])localObject2, kotlin.n.d.ISO_8859_1);
    localObject3 = com.tencent.mm.kernel.h.aHG();
    kotlin.g.b.p.j(localObject3, "MMKernel.storage()");
    ((com.tencent.mm.kernel.f)localObject3).aHp().set(ar.a.VvU, localObject2);
    localObject2 = ((uy)localObject4).toByteArray();
    kotlin.g.b.p.j(localObject2, "sortInfoList.toByteArray()");
    localObject2 = new String((byte[])localObject2, kotlin.n.d.ISO_8859_1);
    localObject3 = com.tencent.mm.kernel.h.aHG();
    kotlin.g.b.p.j(localObject3, "MMKernel.storage()");
    ((com.tencent.mm.kernel.f)localObject3).aHp().set(ar.a.VvV, localObject2);
    if (localObject1 != null)
    {
      localObject1 = ((ug)localObject1).toByteArray();
      kotlin.g.b.p.j(localObject1, "faqItem.toByteArray()");
      localObject1 = new String((byte[])localObject1, kotlin.n.d.ISO_8859_1);
      localObject2 = com.tencent.mm.kernel.h.aHG();
      kotlin.g.b.p.j(localObject2, "MMKernel.storage()");
      ((com.tencent.mm.kernel.f)localObject2).aHp().set(ar.a.VvW, localObject1);
    }
    AppMethodBeat.o(112462);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(112463);
    super.onResume();
    if ((this.tAZ) && (this.tBg != null) && (this.tBa != -1))
    {
      Object localObject = this.tBg;
      if (localObject == null) {
        kotlin.g.b.p.iCn();
      }
      localObject = ((uf)localObject).SeA;
      kotlin.g.b.p.j(localObject, "clickedCardHomePageElement!!.card_pack_merchant_id");
      uf localuf = this.tBg;
      if (localuf == null) {
        kotlin.g.b.p.iCn();
      }
      long l = localuf.SeN;
      Log.i("MicroMsg.CardHomePageNewUI", "do get mch infoset: %s", new Object[] { localObject });
      new com.tencent.mm.plugin.card.model.a.f((String)localObject, l, this.latitude, this.longitude, this.trv).bhW().b((com.tencent.mm.vending.c.a)new h(this, (String)localObject));
      this.tAZ = false;
      this.tBg = null;
      AppMethodBeat.o(112463);
      return;
    }
    if (this.tBe)
    {
      this.tBh = true;
      this.offset = 0;
      this.tBe = false;
      cKC();
    }
    AppMethodBeat.o(112463);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$CardListModel;", "", "(Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI;)V", "element", "Lcom/tencent/mm/protocal/protobuf/CardHomePageElement;", "getElement", "()Lcom/tencent/mm/protocal/protobuf/CardHomePageElement;", "setElement", "(Lcom/tencent/mm/protocal/protobuf/CardHomePageElement;)V", "expandState", "", "getExpandState", "()Z", "setExpandState", "(Z)V", "hasRender", "getHasRender", "setHasRender", "sectionTitle", "", "getSectionTitle", "()Ljava/lang/String;", "setSectionTitle", "(Ljava/lang/String;)V", "showDivider", "getShowDivider", "setShowDivider", "topElement", "Lcom/tencent/mm/protocal/protobuf/CardHomePageTopCell;", "getTopElement", "()Lcom/tencent/mm/protocal/protobuf/CardHomePageTopCell;", "setTopElement", "(Lcom/tencent/mm/protocal/protobuf/CardHomePageTopCell;)V", "type", "", "getType", "()I", "setType", "(I)V", "plugin-card_release"})
  public final class a
  {
    uf tBm;
    public String tBn;
    boolean tBo;
    boolean tBp;
    uk tBq;
    boolean tBr;
    int type;
    
    public final void arx(String paramString)
    {
      AppMethodBeat.i(112405);
      kotlin.g.b.p.k(paramString, "<set-?>");
      this.tBn = paramString;
      AppMethodBeat.o(112405);
    }
    
    public final String cKF()
    {
      AppMethodBeat.i(112404);
      String str = this.tBn;
      if (str == null) {
        kotlin.g.b.p.bGy("sectionTitle");
      }
      AppMethodBeat.o(112404);
      return str;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$CardSpan;", "Lcom/tencent/mm/pluginsdk/ui/span/PressableClickSpan;", "linkColor", "", "bgColor", "listener", "Lcom/tencent/mm/pluginsdk/ui/span/MMSpanClickListener;", "(Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI;IILcom/tencent/mm/pluginsdk/ui/span/MMSpanClickListener;)V", "onClick", "", "widget", "Landroid/view/View;", "plugin-card_release"})
  public final class b
    extends com.tencent.mm.pluginsdk.ui.span.p
  {
    public b(int paramInt, j paramj)
    {
      super(paramj);
      AppMethodBeat.i(112407);
      this.mClickListener = localObject;
      AppMethodBeat.o(112407);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(112406);
      kotlin.g.b.p.k(paramView, "widget");
      if (this.mClickListener != null) {
        this.mClickListener.a(paramView, null);
      }
      AppMethodBeat.o(112406);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH;", "Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI;", "(Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI;)V", "appendUnderList", "", "model", "Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$CardListModel;", "getItemCount", "", "getItemViewType", "position", "getModelByPos", "getPosByMerchantId", "merchantId", "", "moveStoreToUnderList", "", "element", "Lcom/tencent/mm/protocal/protobuf/CardHomePageElement;", "onBindViewHolder", "holder", "payloads", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "removeModelByMId", "removeTitleSection", "replaceModelByMId", "mchInfo", "plugin-card_release"})
  public final class d
    extends RecyclerView.a<CardHomePageNewUI.e>
  {
    private int arz(String paramString)
    {
      int k = 0;
      AppMethodBeat.i(112415);
      kotlin.g.b.p.k(paramString, "merchantId");
      if (CardHomePageNewUI.g(this.tBs) != null) {}
      for (int i = 1;; i = 0)
      {
        if (CardHomePageNewUI.f(this.tBs) != null) {
          i += 1;
        }
        for (;;)
        {
          Iterator localIterator = ((Iterable)CardHomePageNewUI.a(this.tBs)).iterator();
          int j = 0;
          Object localObject;
          while (localIterator.hasNext())
          {
            localObject = ((CardHomePageNewUI.a)localIterator.next()).tBm;
            if (localObject != null) {}
            for (localObject = ((uf)localObject).SeA; kotlin.g.b.p.h(localObject, paramString); localObject = null)
            {
              AppMethodBeat.o(112415);
              return i + j;
            }
            j += 1;
          }
          i = CardHomePageNewUI.a(this.tBs).size() + i - 1;
          if (CardHomePageNewUI.c(this.tBs) != null) {
            i += 1;
          }
          for (;;)
          {
            localIterator = ((Iterable)CardHomePageNewUI.b(this.tBs)).iterator();
            j = k;
            while (localIterator.hasNext())
            {
              localObject = ((CardHomePageNewUI.a)localIterator.next()).tBm;
              if (localObject != null) {}
              for (localObject = ((uf)localObject).SeA; kotlin.g.b.p.h(localObject, paramString); localObject = null)
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
    
    public final CardHomePageNewUI.a HZ(int paramInt)
    {
      int j = 0;
      AppMethodBeat.i(112413);
      Object localObject1 = CardHomePageNewUI.a(this.tBs);
      Object localObject2;
      if (localObject1 != null)
      {
        localObject1 = Integer.valueOf(((ArrayList)localObject1).size());
        localObject2 = CardHomePageNewUI.a(this.tBs);
        if (localObject2 == null) {
          break label156;
        }
        localObject2 = Integer.valueOf(((ArrayList)localObject2).size());
        label55:
        if (CardHomePageNewUI.c(this.tBs) == null) {
          break label162;
        }
      }
      label156:
      label162:
      for (boolean bool = true;; bool = false)
      {
        Log.d("MicroMsg.CardHomePageNewUI", "pos: %s, sSize: %s, uSize: %s, title: %s", new Object[] { Integer.valueOf(paramInt), localObject1, localObject2, Boolean.valueOf(bool) });
        localObject1 = CardHomePageNewUI.g(this.tBs);
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
      localObject1 = CardHomePageNewUI.f(this.tBs);
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
      localObject1 = CardHomePageNewUI.h(this.tBs);
      if ((localObject1 != null) && (paramInt == i))
      {
        AppMethodBeat.o(112413);
        return localObject1;
      }
      localObject1 = CardHomePageNewUI.a(this.tBs);
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
      if (CardHomePageNewUI.c(this.tBs) != null)
      {
        j += 1;
        i = j;
        if (paramInt == j)
        {
          localObject1 = CardHomePageNewUI.c(this.tBs);
          AppMethodBeat.o(112413);
          return localObject1;
        }
      }
      localObject1 = CardHomePageNewUI.b(this.tBs);
      if ((localObject1 != null) && (paramInt > i) && (paramInt <= ((ArrayList)localObject1).size() + i))
      {
        localObject1 = (CardHomePageNewUI.a)((ArrayList)localObject1).get(paramInt - i - 1);
        AppMethodBeat.o(112413);
        return localObject1;
      }
      AppMethodBeat.o(112413);
      return null;
    }
    
    public final void a(String paramString, uf paramuf)
    {
      AppMethodBeat.i(112416);
      kotlin.g.b.p.k(paramString, "merchantId");
      kotlin.g.b.p.k(paramuf, "mchInfo");
      Iterator localIterator = CardHomePageNewUI.a(this.tBs).iterator();
      CardHomePageNewUI.a locala;
      Object localObject;
      int i;
      while (localIterator.hasNext())
      {
        locala = (CardHomePageNewUI.a)localIterator.next();
        localObject = locala.tBm;
        if (localObject != null) {}
        for (localObject = ((uf)localObject).SeA; kotlin.g.b.p.h(localObject, paramString); localObject = null)
        {
          locala.tBm = paramuf;
          i = arz(paramString);
          if (i < 0) {
            break label130;
          }
          paramString = CardHomePageNewUI.j(this.tBs).getAdapter();
          if (paramString == null) {
            break label130;
          }
          paramString.d(i, Boolean.TRUE);
          AppMethodBeat.o(112416);
          return;
        }
        continue;
        label130:
        AppMethodBeat.o(112416);
        return;
      }
      localIterator = CardHomePageNewUI.b(this.tBs).iterator();
      while (localIterator.hasNext())
      {
        locala = (CardHomePageNewUI.a)localIterator.next();
        localObject = locala.tBm;
        if (localObject != null) {}
        for (localObject = ((uf)localObject).SeA; kotlin.g.b.p.h(localObject, paramString); localObject = null)
        {
          locala.tBm = paramuf;
          i = arz(paramString);
          if (i < 0) {
            break label249;
          }
          paramString = CardHomePageNewUI.j(this.tBs).getAdapter();
          if (paramString == null) {
            break label249;
          }
          paramString.d(i, Boolean.TRUE);
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
    
    public final void ary(String paramString)
    {
      AppMethodBeat.i(112414);
      kotlin.g.b.p.k(paramString, "merchantId");
      Iterator localIterator = CardHomePageNewUI.a(this.tBs).iterator();
      CardHomePageNewUI.a locala;
      Object localObject;
      while (localIterator.hasNext())
      {
        locala = (CardHomePageNewUI.a)localIterator.next();
        localObject = locala.tBm;
        if (localObject != null) {}
        for (localObject = ((uf)localObject).SeA; kotlin.g.b.p.h(localObject, paramString); localObject = null)
        {
          CardHomePageNewUI.a(this.tBs).remove(locala);
          paramString = CardHomePageNewUI.j(this.tBs).getAdapter();
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
      localIterator = CardHomePageNewUI.b(this.tBs).iterator();
      while (localIterator.hasNext())
      {
        locala = (CardHomePageNewUI.a)localIterator.next();
        localObject = locala.tBm;
        if (localObject != null) {}
        for (localObject = ((uf)localObject).SeA; kotlin.g.b.p.h(localObject, paramString); localObject = null)
        {
          CardHomePageNewUI.b(this.tBs).remove(locala);
          if (CardHomePageNewUI.b(this.tBs).size() != 0) {
            break label231;
          }
          CardHomePageNewUI.d(this.tBs);
          paramString = CardHomePageNewUI.j(this.tBs).getAdapter();
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
      ArrayList localArrayList = CardHomePageNewUI.a(this.tBs);
      int i;
      int j;
      if (localArrayList != null)
      {
        i = localArrayList.size();
        localArrayList = CardHomePageNewUI.b(this.tBs);
        if (localArrayList == null) {
          break label147;
        }
        j = localArrayList.size();
        label49:
        if (CardHomePageNewUI.c(this.tBs) == null) {
          break label176;
        }
      }
      label147:
      label158:
      label176:
      for (int k = 1;; k = 0)
      {
        if (CardHomePageNewUI.e(this.tBs) != null) {}
        for (int m = 1;; m = 0)
        {
          if (CardHomePageNewUI.f(this.tBs) != null) {}
          for (int n = 1;; n = 0)
          {
            localArrayList = CardHomePageNewUI.g(this.tBs);
            int i1;
            if (localArrayList != null)
            {
              i1 = localArrayList.size();
              label108:
              if (CardHomePageNewUI.h(this.tBs) == null) {
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
      CardHomePageNewUI.a locala = HZ(paramInt);
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
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "viewType", "", "(Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI;Landroid/view/View;I)V", "chpiCouponLayout", "Landroid/widget/LinearLayout;", "getChpiCouponLayout", "()Landroid/widget/LinearLayout;", "setChpiCouponLayout", "(Landroid/widget/LinearLayout;)V", "chpiDescTv", "Landroid/widget/TextView;", "getChpiDescTv", "()Landroid/widget/TextView;", "setChpiDescTv", "(Landroid/widget/TextView;)V", "chpiExpandIv", "Landroid/widget/ImageView;", "getChpiExpandIv", "()Landroid/widget/ImageView;", "setChpiExpandIv", "(Landroid/widget/ImageView;)V", "chpiExpandLayout", "getChpiExpandLayout", "setChpiExpandLayout", "chpiExpandTv", "getChpiExpandTv", "setChpiExpandTv", "chpiHeaderLayout", "getChpiHeaderLayout", "setChpiHeaderLayout", "chpiLabelLayout", "getChpiLabelLayout", "setChpiLabelLayout", "chpiLogoIv", "Lcom/tencent/mm/pluginsdk/ui/applet/CdnImageView;", "getChpiLogoIv", "()Lcom/tencent/mm/pluginsdk/ui/applet/CdnImageView;", "setChpiLogoIv", "(Lcom/tencent/mm/pluginsdk/ui/applet/CdnImageView;)V", "chpiMchLabelTv", "Lcom/tencent/mm/plugin/card/ui/v2/CardLabelTextView;", "getChpiMchLabelTv", "()Lcom/tencent/mm/plugin/card/ui/v2/CardLabelTextView;", "setChpiMchLabelTv", "(Lcom/tencent/mm/plugin/card/ui/v2/CardLabelTextView;)V", "chpiNameTv", "getChpiNameTv", "setChpiNameTv", "chtiDescTv", "getChtiDescTv", "setChtiDescTv", "chtiDivider", "getChtiDivider", "()Landroid/view/View;", "setChtiDivider", "(Landroid/view/View;)V", "chtiIconIv", "getChtiIconIv", "setChtiIconIv", "chtiNewTv", "getChtiNewTv", "setChtiNewTv", "chtiRedDotIv", "getChtiRedDotIv", "setChtiRedDotIv", "chtiRightIv", "getChtiRightIv", "setChtiRightIv", "chtiTitleTv", "getChtiTitleTv", "setChtiTitleTv", "model", "Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$CardListModel;", "Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI;", "getModel", "()Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$CardListModel;", "setModel", "(Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$CardListModel;)V", "sectionTitleTv", "getSectionTitleTv", "setSectionTitleTv", "addCouponView", "", "view", "appendCouponView", "offset", "len", "position", "collapseCouponLayout", "expandCouponLayout", "gotoCardDetailUI", "cardId", "", "setCardBg", "imageView", "url", "radius", "", "defaultRes", "setIcon", "useBackendExpandState", "", "showCollapseLayout", "showExpandLayout", "showMiniAppLayout", "updateCardLabelLayout", "couponLabelList", "", "Lcom/tencent/mm/protocal/protobuf/CardElementCouponLabel;", "labelLayout", "labelList", "Lcom/tencent/mm/protocal/protobuf/CardElementMchLabel;", "updateExpandLayout", "isExpended", "plugin-card_release"})
  public final class e
    extends RecyclerView.v
  {
    public LinearLayout tBA;
    public TextView tBB;
    public ImageView tBC;
    public CardLabelTextView tBD;
    public ImageView tBE;
    public TextView tBF;
    public TextView tBG;
    public ImageView tBH;
    public ImageView tBI;
    public TextView tBJ;
    public View tBK;
    CardHomePageNewUI.a tBL;
    public TextView tBt;
    public CdnImageView tBu;
    public TextView tBv;
    public TextView tBw;
    public LinearLayout tBx;
    public LinearLayout tBy;
    public LinearLayout tBz;
    
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
        this$1 = paramInt.findViewById(a.d.ten);
        kotlin.g.b.p.j(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_logo_iv)");
        this.tBu = ((CdnImageView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(a.d.teq);
        kotlin.g.b.p.j(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_username_tv)");
        this.tBv = ((TextView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(a.d.teg);
        kotlin.g.b.p.j(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_desc_tv)");
        this.tBw = ((TextView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(a.d.tem);
        kotlin.g.b.p.j(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_label_layout)");
        this.tBy = ((LinearLayout)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(a.d.tef);
        kotlin.g.b.p.j(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_coupon_layout)");
        this.tBz = ((LinearLayout)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(a.d.tei);
        kotlin.g.b.p.j(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_expand_layout)");
        this.tBA = ((LinearLayout)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(a.d.teh);
        kotlin.g.b.p.j(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_expand_iv)");
        this.tBC = ((ImageView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(a.d.tej);
        kotlin.g.b.p.j(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_expand_tv)");
        this.tBB = ((TextView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(a.d.teo);
        kotlin.g.b.p.j(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_mch_label_tv)");
        this.tBD = ((CardLabelTextView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(a.d.tek);
        kotlin.g.b.p.j(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_header_layout)");
        this.tBx = ((LinearLayout)CardHomePageNewUI.this);
        AppMethodBeat.o(112438);
        return;
        this$1 = paramInt.findViewById(a.d.tep);
        kotlin.g.b.p.j(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_section_title)");
        this.tBt = ((TextView)CardHomePageNewUI.this);
        AppMethodBeat.o(112438);
        return;
        this$1 = paramInt.findViewById(a.d.ten);
        kotlin.g.b.p.j(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_logo_iv)");
        this.tBu = ((CdnImageView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(a.d.teq);
        kotlin.g.b.p.j(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_username_tv)");
        this.tBv = ((TextView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(a.d.teg);
        kotlin.g.b.p.j(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_desc_tv)");
        this.tBw = ((TextView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(a.d.teo);
        kotlin.g.b.p.j(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_mch_label_tv)");
        this.tBD = ((CardLabelTextView)CardHomePageNewUI.this);
        AppMethodBeat.o(112438);
        return;
        this$1 = paramInt.findViewById(a.d.ten);
        kotlin.g.b.p.j(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_logo_iv)");
        this.tBu = ((CdnImageView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(a.d.teq);
        kotlin.g.b.p.j(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_username_tv)");
        this.tBv = ((TextView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(a.d.teg);
        kotlin.g.b.p.j(CardHomePageNewUI.this, "itemView.findViewById(R.id.chpi_desc_tv)");
        this.tBw = ((TextView)CardHomePageNewUI.this);
        AppMethodBeat.o(112438);
        return;
        this$1 = paramInt.findViewById(a.d.teR);
        kotlin.g.b.p.j(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_icon_iv)");
        this.tBE = ((ImageView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(a.d.teV);
        kotlin.g.b.p.j(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_title_tv)");
        this.tBF = ((TextView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(a.d.teP);
        kotlin.g.b.p.j(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_desc_tv)");
        this.tBG = ((TextView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(a.d.teU);
        kotlin.g.b.p.j(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_right_iv)");
        this.tBH = ((ImageView)CardHomePageNewUI.this);
        AppMethodBeat.o(112438);
        return;
        this$1 = paramInt.findViewById(a.d.teR);
        kotlin.g.b.p.j(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_icon_iv)");
        this.tBE = ((ImageView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(a.d.teV);
        kotlin.g.b.p.j(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_title_tv)");
        this.tBF = ((TextView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(a.d.teP);
        kotlin.g.b.p.j(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_desc_tv)");
        this.tBG = ((TextView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(a.d.teU);
        kotlin.g.b.p.j(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_right_iv)");
        this.tBH = ((ImageView)CardHomePageNewUI.this);
        AppMethodBeat.o(112438);
        return;
        this$1 = paramInt.findViewById(a.d.teR);
        kotlin.g.b.p.j(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_icon_iv)");
        this.tBE = ((ImageView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(a.d.teV);
        kotlin.g.b.p.j(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_title_tv)");
        this.tBF = ((TextView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(a.d.teP);
        kotlin.g.b.p.j(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_desc_tv)");
        this.tBG = ((TextView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(a.d.teU);
        kotlin.g.b.p.j(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_right_iv)");
        this.tBH = ((ImageView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(a.d.teT);
        kotlin.g.b.p.j(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_reddot_iv)");
        this.tBI = ((ImageView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(a.d.teS);
        kotlin.g.b.p.j(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_new_tv)");
        this.tBJ = ((TextView)CardHomePageNewUI.this);
        this$1 = paramInt.findViewById(a.d.teQ);
        kotlin.g.b.p.j(CardHomePageNewUI.this, "itemView.findViewById(R.id.chti_divider)");
        this.tBK = CardHomePageNewUI.this;
      }
    }
    
    private final void G(boolean paramBoolean, int paramInt)
    {
      AppMethodBeat.i(112437);
      Object localObject = this.tBL;
      if (localObject == null) {
        kotlin.g.b.p.iCn();
      }
      localObject = ((CardHomePageNewUI.a)localObject).tBm;
      if (paramBoolean)
      {
        if (localObject != null) {}
        for (localObject = ((uf)localObject).SeG; !Util.isNullOrNil((String)localObject); localObject = null)
        {
          Ia(paramInt);
          AppMethodBeat.o(112437);
          return;
        }
        Ic(paramInt);
        AppMethodBeat.o(112437);
        return;
      }
      Ib(paramInt);
      AppMethodBeat.o(112437);
    }
    
    private final void Ia(final int paramInt)
    {
      AppMethodBeat.i(112434);
      Object localObject1 = this.tBL;
      if (localObject1 == null) {
        kotlin.g.b.p.iCn();
      }
      localObject1 = ((CardHomePageNewUI.a)localObject1).tBm;
      if (localObject1 == null) {
        kotlin.g.b.p.iCn();
      }
      if (!Util.isNullOrNil(((uf)localObject1).SeG))
      {
        if (!Util.isNullOrNil(((uf)localObject1).SeH))
        {
          localObject2 = this.tBB;
          if (localObject2 == null) {
            kotlin.g.b.p.bGy("chpiExpandTv");
          }
          ((TextView)localObject2).setTextColor(Color.parseColor(((uf)localObject1).SeH));
        }
        Object localObject2 = this.tBB;
        if (localObject2 == null) {
          kotlin.g.b.p.bGy("chpiExpandTv");
        }
        ((TextView)localObject2).setText((CharSequence)((uf)localObject1).SeG);
        localObject2 = this.tBC;
        if (localObject2 == null) {
          kotlin.g.b.p.bGy("chpiExpandIv");
        }
        ((ImageView)localObject2).setImageResource(a.c.tad);
        localObject2 = this.tBA;
        if (localObject2 == null) {
          kotlin.g.b.p.bGy("chpiExpandLayout");
        }
        ((LinearLayout)localObject2).setOnClickListener((View.OnClickListener)new i((uf)localObject1, this, paramInt));
      }
      AppMethodBeat.o(112434);
    }
    
    private final void Ib(final int paramInt)
    {
      AppMethodBeat.i(112435);
      Object localObject1 = this.tBL;
      if (localObject1 == null) {
        kotlin.g.b.p.iCn();
      }
      localObject1 = ((CardHomePageNewUI.a)localObject1).tBm;
      Object localObject2 = this.tBB;
      if (localObject2 == null) {
        kotlin.g.b.p.bGy("chpiExpandTv");
      }
      Resources localResources = MMApplicationContext.getResources();
      int i = a.g.tks;
      if (localObject1 == null) {
        kotlin.g.b.p.iCn();
      }
      ((TextView)localObject2).setText((CharSequence)localResources.getString(i, new Object[] { Integer.valueOf(((uf)localObject1).SeL - ((uf)localObject1).SeM) }));
      localObject2 = this.tBA;
      if (localObject2 == null) {
        kotlin.g.b.p.bGy("chpiExpandLayout");
      }
      ((LinearLayout)localObject2).setOnClickListener((View.OnClickListener)new h(this, paramInt, (uf)localObject1));
      localObject1 = this.tBC;
      if (localObject1 == null) {
        kotlin.g.b.p.bGy("chpiExpandIv");
      }
      ((ImageView)localObject1).setImageResource(a.c.tal);
      localObject1 = this.tBC;
      if (localObject1 == null) {
        kotlin.g.b.p.bGy("chpiExpandIv");
      }
      ((ImageView)localObject1).setVisibility(0);
      AppMethodBeat.o(112435);
    }
    
    private final void Ic(final int paramInt)
    {
      AppMethodBeat.i(112436);
      Object localObject1 = this.tBL;
      if (localObject1 == null) {
        kotlin.g.b.p.iCn();
      }
      localObject1 = ((CardHomePageNewUI.a)localObject1).tBm;
      Object localObject2 = this.tBB;
      if (localObject2 == null) {
        kotlin.g.b.p.bGy("chpiExpandTv");
      }
      ((TextView)localObject2).setText((CharSequence)MMApplicationContext.getResources().getString(a.g.tkq));
      localObject2 = this.tBA;
      if (localObject2 == null) {
        kotlin.g.b.p.bGy("chpiExpandLayout");
      }
      ((LinearLayout)localObject2).setOnClickListener((View.OnClickListener)new g(this, paramInt, (uf)localObject1));
      localObject1 = this.tBC;
      if (localObject1 == null) {
        kotlin.g.b.p.bGy("chpiExpandIv");
      }
      ((ImageView)localObject1).setImageResource(a.c.tam);
      localObject1 = this.tBC;
      if (localObject1 == null) {
        kotlin.g.b.p.bGy("chpiExpandIv");
      }
      ((ImageView)localObject1).setVisibility(0);
      AppMethodBeat.o(112436);
    }
    
    private final void W(int paramInt1, int paramInt2, final int paramInt3)
    {
      AppMethodBeat.i(112428);
      Object localObject1 = this.tBL;
      if (localObject1 == null) {
        kotlin.g.b.p.iCn();
      }
      localObject1 = ((CardHomePageNewUI.a)localObject1).tBm;
      if (localObject1 == null) {
        kotlin.g.b.p.iCn();
      }
      Object localObject2 = ((uf)localObject1).SeF;
      kotlin.g.b.p.j(localObject2, "el!!.card_element_coupon_list");
      localObject2 = ((Iterable)localObject2).iterator();
      int k = 0;
      int i = 0;
      if (((Iterator)localObject2).hasNext())
      {
        final uc localuc = (uc)((Iterator)localObject2).next();
        int j = i;
        if (k >= paramInt1)
        {
          if (localuc.Seh != 1) {
            break label491;
          }
          localObject3 = this.tBz;
          if (localObject3 == null) {
            kotlin.g.b.p.bGy("chpiCouponLayout");
          }
          localObject3 = LayoutInflater.from(((LinearLayout)localObject3).getContext());
          j = a.e.tio;
          localLinearLayout = this.tBz;
          if (localLinearLayout == null) {
            kotlin.g.b.p.bGy("chpiCouponLayout");
          }
          localObject3 = ((LayoutInflater)localObject3).inflate(j, (ViewGroup)localLinearLayout, false);
          if (localObject3 == null)
          {
            localObject1 = new t("null cannot be cast to non-null type android.view.ViewGroup");
            AppMethodBeat.o(112428);
            throw ((Throwable)localObject1);
          }
          localObject3 = (ViewGroup)localObject3;
          localObject4 = (TextView)((ViewGroup)localObject3).findViewById(a.d.tdR);
          localObject5 = (CdnImageView)((ViewGroup)localObject3).findViewById(a.d.tdO);
          localObject6 = (TextView)((ViewGroup)localObject3).findViewById(a.d.tdP);
          localLinearLayout = (LinearLayout)((ViewGroup)localObject3).findViewById(a.d.tdQ);
          if (!Util.isNullOrNil(localuc.Sek)) {
            ((TextView)localObject4).setTextColor(com.tencent.mm.plugin.card.d.l.dn(localuc.Sek, localuc.Sel));
          }
          kotlin.g.b.p.j(localObject4, "titleTv");
          ((TextView)localObject4).setText((CharSequence)localuc.Seb);
          ((CdnImageView)localObject5).setUrl(localuc.Sei);
          if (!Util.isNullOrNil(localuc.Sem)) {
            ((TextView)localObject6).setTextColor(com.tencent.mm.plugin.card.d.l.dn(localuc.Sem, localuc.Sen));
          }
          kotlin.g.b.p.j(localObject6, "descTv");
          ((TextView)localObject6).setText((CharSequence)localuc.Sec);
          localObject4 = localuc.Seg;
          kotlin.g.b.p.j(localObject4, "coupon.coupon_label");
          localObject4 = (List)localObject4;
          kotlin.g.b.p.j(localLinearLayout, "labelLayout");
          a((List)localObject4, localLinearLayout);
          localLinearLayout = this.tBz;
          if (localLinearLayout == null) {
            kotlin.g.b.p.bGy("chpiCouponLayout");
          }
          ((ViewGroup)localObject3).setOnClickListener((View.OnClickListener)new a(this, (uf)localObject1, localuc, localLinearLayout.getChildCount(), paramInt3));
          dY((View)localObject3);
        }
        label491:
        while (localuc.Seh != 2)
        {
          j = i;
          if (paramInt2 > 0)
          {
            j = i + 1;
            if (j >= paramInt2) {
              break label1094;
            }
          }
          k += 1;
          i = j;
          break;
        }
        Object localObject3 = this.tBz;
        if (localObject3 == null) {
          kotlin.g.b.p.bGy("chpiCouponLayout");
        }
        localObject3 = LayoutInflater.from(((LinearLayout)localObject3).getContext());
        j = a.e.tin;
        LinearLayout localLinearLayout = this.tBz;
        if (localLinearLayout == null) {
          kotlin.g.b.p.bGy("chpiCouponLayout");
        }
        localObject3 = ((LayoutInflater)localObject3).inflate(j, (ViewGroup)localLinearLayout, false);
        if (localObject3 == null)
        {
          localObject1 = new t("null cannot be cast to non-null type android.view.ViewGroup");
          AppMethodBeat.o(112428);
          throw ((Throwable)localObject1);
        }
        localObject3 = (ViewGroup)localObject3;
        Object localObject5 = (TextView)((ViewGroup)localObject3).findViewById(a.d.tdR);
        Object localObject6 = (TextView)((ViewGroup)localObject3).findViewById(a.d.tdP);
        localLinearLayout = (LinearLayout)((ViewGroup)localObject3).findViewById(a.d.tdQ);
        Object localObject7 = (MemberCardTopCropImageView)((ViewGroup)localObject3).findViewById(a.d.tdM);
        Object localObject4 = (ImageView)((ViewGroup)localObject3).findViewById(a.d.tdN);
        if (!Util.isNullOrNil(localuc.Sek)) {
          ((TextView)localObject5).setTextColor(com.tencent.mm.plugin.card.d.l.dn(localuc.Sek, localuc.Sel));
        }
        kotlin.g.b.p.j(localObject5, "titleTv");
        ((TextView)localObject5).setText((CharSequence)localuc.Seb);
        kotlin.g.b.p.j(localObject6, "descTv");
        ((TextView)localObject6).setText((CharSequence)localuc.Sec);
        kotlin.g.b.p.j(localObject7, "bgIv");
        ((MemberCardTopCropImageView)localObject7).setRadius(com.tencent.mm.ci.a.fromDPToPix(((MemberCardTopCropImageView)localObject7).getContext(), 2));
        if (!Util.isNullOrNil(localuc.Sef))
        {
          localObject5 = (ImageView)localObject7;
          localObject6 = localuc.Sef;
          kotlin.g.b.p.j(localObject6, "coupon.coupon_back_url");
          j = a.c.tai;
          kotlin.g.b.p.k(localObject5, "imageView");
          kotlin.g.b.p.k(localObject6, "url");
          localObject7 = new c.a();
          ((c.a)localObject7).Wr(com.tencent.mm.loader.j.b.aSL());
          ((c.a)localObject7).a(q.bmm());
          ((c.a)localObject7).Wq(com.tencent.mm.plugin.card.model.m.arc((String)localObject6));
          ((c.a)localObject7).bmF();
          ((c.a)localObject7).bmK();
          ((c.a)localObject7).gs(true);
          ((c.a)localObject7).wy(j);
          ((c.a)localObject7).wx(com.tencent.mm.ci.a.fromDPToPix(((ImageView)localObject5).getContext(), 84));
          ((c.a)localObject7).ww(com.tencent.mm.ci.a.kr(((ImageView)localObject5).getContext()));
          localObject7 = ((c.a)localObject7).bmL();
          q.bml().a((String)localObject6, (ImageView)localObject5, (com.tencent.mm.ay.a.a.c)localObject7);
          ((ImageView)localObject5).setImageMatrix(new Matrix());
          kotlin.g.b.p.j(localObject4, "shadowBgIv");
          ((ImageView)localObject4).setVisibility(0);
        }
        for (;;)
        {
          localObject4 = localuc.Seg;
          kotlin.g.b.p.j(localObject4, "coupon.coupon_label");
          localObject4 = (List)localObject4;
          kotlin.g.b.p.j(localLinearLayout, "labelLayout");
          a((List)localObject4, localLinearLayout);
          localLinearLayout = this.tBz;
          if (localLinearLayout == null) {
            kotlin.g.b.p.bGy("chpiCouponLayout");
          }
          ((ViewGroup)localObject3).setOnClickListener((View.OnClickListener)new b(this, (uf)localObject1, localuc, localLinearLayout.getChildCount(), paramInt3));
          dY((View)localObject3);
          break;
          if (!Util.isNullOrNil(localuc.See))
          {
            ((MemberCardTopCropImageView)localObject7).setImageDrawable((Drawable)new ColorDrawable(Color.parseColor(localuc.See)));
            kotlin.g.b.p.j(localObject4, "shadowBgIv");
            ((ImageView)localObject4).setVisibility(0);
          }
        }
      }
      label1094:
      AppMethodBeat.o(112428);
    }
    
    private void a(List<? extends ub> paramList, LinearLayout paramLinearLayout)
    {
      AppMethodBeat.i(112432);
      kotlin.g.b.p.k(paramList, "couponLabelList");
      kotlin.g.b.p.k(paramLinearLayout, "labelLayout");
      paramList = paramList.iterator();
      if (paramList.hasNext())
      {
        ub localub = (ub)paramList.next();
        Object localObject1 = this.tBz;
        if (localObject1 == null) {
          kotlin.g.b.p.bGy("chpiCouponLayout");
        }
        localObject1 = new CardTagTextView(((LinearLayout)localObject1).getContext());
        Object localObject2 = this.tBz;
        if (localObject2 == null) {
          kotlin.g.b.p.bGy("chpiCouponLayout");
        }
        localObject2 = ((LinearLayout)localObject2).getContext();
        ((CardTagTextView)localObject1).setMinHeight(com.tencent.mm.ci.a.fromDPToPix((Context)localObject2, 18));
        ((CardTagTextView)localObject1).setMinWidth(com.tencent.mm.ci.a.fromDPToPix((Context)localObject2, 56));
        int i = com.tencent.mm.ci.a.fromDPToPix((Context)localObject2, 8);
        int j = com.tencent.mm.ci.a.fromDPToPix((Context)localObject2, 4);
        ((CardTagTextView)localObject1).setPadding(i, j, i, j);
        ((CardTagTextView)localObject1).setText((CharSequence)localub.SdV);
        ((CardTagTextView)localObject1).setTextSize(1, 10.0F);
        if (!Util.isNullOrNil(localub.SdW))
        {
          ((CardTagTextView)localObject1).setTextColor(Color.parseColor(localub.SdW));
          label199:
          if (Util.isNullOrNil(localub.SdX)) {
            break label249;
          }
          ((CardTagTextView)localObject1).setFillColor(com.tencent.mm.plugin.card.d.l.dn(localub.SdX, localub.Sea));
        }
        for (;;)
        {
          paramLinearLayout.addView((View)localObject1);
          break;
          ((CardTagTextView)localObject1).setTextColor(-1);
          break label199;
          label249:
          ((CardTagTextView)localObject1).setFillColor(com.tencent.mm.plugin.card.d.l.fG(-16777216, 26));
        }
      }
      AppMethodBeat.o(112432);
    }
    
    private static void b(ImageView paramImageView, String paramString)
    {
      AppMethodBeat.i(112433);
      kotlin.g.b.p.k(paramImageView, "imageView");
      kotlin.g.b.p.k(paramString, "url");
      Object localObject = new c.a();
      ((c.a)localObject).Wr(com.tencent.mm.loader.j.b.aSL());
      ((c.a)localObject).a(q.bmm());
      ((c.a)localObject).Wq(com.tencent.mm.plugin.card.model.m.arc(paramString));
      ((c.a)localObject).bmF();
      ((c.a)localObject).bmJ();
      ((c.a)localObject).bmK();
      ((c.a)localObject).gs(true);
      ((c.a)localObject).wy(a.f.card_default_merchant_icon);
      localObject = ((c.a)localObject).bmL();
      q.bml().a(paramString, paramImageView, (com.tencent.mm.ay.a.a.c)localObject);
      AppMethodBeat.o(112433);
    }
    
    private void cS(List<? extends ud> paramList)
    {
      AppMethodBeat.i(112431);
      kotlin.g.b.p.k(paramList, "labelList");
      Object localObject1 = this.tBy;
      if (localObject1 == null) {
        kotlin.g.b.p.bGy("chpiLabelLayout");
      }
      ((LinearLayout)localObject1).removeAllViews();
      if (paramList.isEmpty())
      {
        paramList = this.tBy;
        if (paramList == null) {
          kotlin.g.b.p.bGy("chpiLabelLayout");
        }
        paramList.setVisibility(8);
        AppMethodBeat.o(112431);
        return;
      }
      paramList = ((Iterable)paramList).iterator();
      int i = 0;
      if (paramList.hasNext())
      {
        Object localObject2 = (ud)paramList.next();
        localObject1 = this.tBy;
        if (localObject1 == null) {
          kotlin.g.b.p.bGy("chpiLabelLayout");
        }
        localObject1 = ((LinearLayout)localObject1).getContext();
        kotlin.g.b.p.j(localObject1, "chpiLabelLayout.context");
        localObject1 = new CardLabelTextView((Context)localObject1);
        Object localObject3 = this.tBy;
        if (localObject3 == null) {
          kotlin.g.b.p.bGy("chpiLabelLayout");
        }
        localObject3 = ((LinearLayout)localObject3).getContext();
        ((CardLabelTextView)localObject1).setTextSize(1, 12.0F);
        ((CardLabelTextView)localObject1).setText((CharSequence)((ud)localObject2).Seu);
        int j = com.tencent.mm.ci.a.fromDPToPix((Context)localObject3, 4);
        ((CardLabelTextView)localObject1).setPadding(j, 0, j, 0);
        ((CardLabelTextView)localObject1).setGravity(16);
        if (!Util.isNullOrNil(((ud)localObject2).Sev))
        {
          ((CardLabelTextView)localObject1).setTextColor(Color.parseColor(((ud)localObject2).Sev));
          label240:
          if (Util.isNullOrNil(((ud)localObject2).Sew)) {
            break label359;
          }
          ((CardLabelTextView)localObject1).setFillColor(com.tencent.mm.plugin.card.d.l.dn(((ud)localObject2).Sew, ((ud)localObject2).Sez));
          label269:
          if (i <= 0) {
            break label368;
          }
          localObject2 = new ViewGroup.MarginLayoutParams(-2, -2);
          ((ViewGroup.MarginLayoutParams)localObject2).leftMargin = com.tencent.mm.ci.a.fromDPToPix((Context)localObject3, 4);
          localObject2 = (ViewGroup.MarginLayoutParams)new LinearLayout.LayoutParams((ViewGroup.MarginLayoutParams)localObject2);
          localObject3 = this.tBy;
          if (localObject3 == null) {
            kotlin.g.b.p.bGy("chpiLabelLayout");
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
          localObject2 = this.tBy;
          if (localObject2 == null) {
            kotlin.g.b.p.bGy("chpiLabelLayout");
          }
          ((LinearLayout)localObject2).addView((View)localObject1);
        }
      }
      paramList = this.tBy;
      if (paramList == null) {
        kotlin.g.b.p.bGy("chpiLabelLayout");
      }
      paramList.setVisibility(0);
      AppMethodBeat.o(112431);
    }
    
    private void dY(View paramView)
    {
      AppMethodBeat.i(112430);
      kotlin.g.b.p.k(paramView, "view");
      Object localObject = this.tBz;
      if (localObject == null) {
        kotlin.g.b.p.bGy("chpiCouponLayout");
      }
      if (((LinearLayout)localObject).getChildCount() == 0)
      {
        localObject = this.tBz;
        if (localObject == null) {
          kotlin.g.b.p.bGy("chpiCouponLayout");
        }
        ((LinearLayout)localObject).addView(paramView);
        AppMethodBeat.o(112430);
        return;
      }
      localObject = this.tBz;
      if (localObject == null) {
        kotlin.g.b.p.bGy("chpiCouponLayout");
      }
      localObject = new ViewGroup.MarginLayoutParams(-1, com.tencent.mm.ci.a.fromDPToPix(((LinearLayout)localObject).getContext(), 84));
      LinearLayout localLinearLayout = this.tBz;
      if (localLinearLayout == null) {
        kotlin.g.b.p.bGy("chpiCouponLayout");
      }
      ((ViewGroup.MarginLayoutParams)localObject).topMargin = com.tencent.mm.ci.a.fromDPToPix(localLinearLayout.getContext(), 8);
      localObject = (ViewGroup.MarginLayoutParams)new LinearLayout.LayoutParams((ViewGroup.MarginLayoutParams)localObject);
      localLinearLayout = this.tBz;
      if (localLinearLayout == null) {
        kotlin.g.b.p.bGy("chpiCouponLayout");
      }
      localLinearLayout.addView(paramView, (ViewGroup.LayoutParams)localObject);
      AppMethodBeat.o(112430);
    }
    
    public final void a(final CardHomePageNewUI.a parama, final int paramInt)
    {
      AppMethodBeat.i(112426);
      kotlin.g.b.p.k(parama, "model");
      this.tBL = parama;
      Object localObject1 = parama.tBm;
      switch (parama.type)
      {
      }
      for (;;)
      {
        parama.tBo = true;
        AppMethodBeat.o(112426);
        return;
        if (localObject1 == null) {
          kotlin.g.b.p.iCn();
        }
        Object localObject2 = this.tBu;
        if (localObject2 == null) {
          kotlin.g.b.p.bGy("chpiLogoIv");
        }
        ((CdnImageView)localObject2).setRoundCorner(true);
        Object localObject3;
        label172:
        int i;
        label512:
        label614:
        boolean bool;
        if (!Util.isNullOrNil(((uf)localObject1).SeB))
        {
          localObject2 = this.tBu;
          if (localObject2 == null) {
            kotlin.g.b.p.bGy("chpiLogoIv");
          }
          localObject2 = (ImageView)localObject2;
          localObject3 = ((uf)localObject1).SeB;
          kotlin.g.b.p.j(localObject3, "card_element_mch_icon");
          b((ImageView)localObject2, (String)localObject3);
          localObject2 = (View.OnClickListener)new c((uf)localObject1, this, (uf)localObject1, paramInt, false, parama);
          localObject3 = this.tBu;
          if (localObject3 == null) {
            kotlin.g.b.p.bGy("chpiLogoIv");
          }
          ((CdnImageView)localObject3).setOnClickListener((View.OnClickListener)localObject2);
          localObject3 = CardHomePageNewUI.this;
          Object localObject4 = CardHomePageNewUI.this.getContext();
          kotlin.g.b.p.j(localObject4, "context");
          i = ((AppCompatActivity)localObject4).getResources().getColor(a.a.normal_text_color);
          localObject4 = CardHomePageNewUI.this.getContext();
          kotlin.g.b.p.j(localObject4, "context");
          localObject4 = new CardHomePageNewUI.b((CardHomePageNewUI)localObject3, i, ((AppCompatActivity)localObject4).getResources().getColor(a.a.sns_link_bg_color), (j)new CardHomePageNewUI.e.d((View.OnClickListener)localObject2));
          localObject3 = new SpannableString((CharSequence)((uf)localObject1).SeC);
          ((SpannableString)localObject3).setSpan(localObject4, 0, ((SpannableString)localObject3).length(), 18);
          localObject4 = this.tBv;
          if (localObject4 == null) {
            kotlin.g.b.p.bGy("chpiNameTv");
          }
          ((TextView)localObject4).setClickable(true);
          localObject4 = this.tBv;
          if (localObject4 == null) {
            kotlin.g.b.p.bGy("chpiNameTv");
          }
          ((TextView)localObject4).setOnTouchListener((View.OnTouchListener)new com.tencent.mm.pluginsdk.ui.span.o((Context)CardHomePageNewUI.this));
          localObject4 = this.tBv;
          if (localObject4 == null) {
            kotlin.g.b.p.bGy("chpiNameTv");
          }
          ((TextView)localObject4).setText((CharSequence)localObject3);
          if (Util.isNullOrNil(((uf)localObject1).SeD)) {
            break label913;
          }
          localObject3 = this.tBw;
          if (localObject3 == null) {
            kotlin.g.b.p.bGy("chpiDescTv");
          }
          ((TextView)localObject3).setText((CharSequence)((uf)localObject1).SeD);
          localObject3 = this.tBw;
          if (localObject3 == null) {
            kotlin.g.b.p.bGy("chpiDescTv");
          }
          ((TextView)localObject3).setVisibility(0);
          localObject3 = this.tBw;
          if (localObject3 == null) {
            kotlin.g.b.p.bGy("chpiDescTv");
          }
          ((TextView)localObject3).setOnClickListener((View.OnClickListener)localObject2);
          if (((uf)localObject1).SeJ == null) {
            break label1031;
          }
          if (Util.isNullOrNil(((uf)localObject1).SeJ.Seu)) {
            break label1004;
          }
          localObject2 = this.tBD;
          if (localObject2 == null) {
            kotlin.g.b.p.bGy("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject2).setText((CharSequence)((uf)localObject1).SeJ.Seu);
          if (Util.isNullOrNil(((uf)localObject1).SeJ.Sev)) {
            break label940;
          }
          localObject2 = this.tBD;
          if (localObject2 == null) {
            kotlin.g.b.p.bGy("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject2).setTextColor(Color.parseColor(((uf)localObject1).SeJ.Sev));
          if (Util.isNullOrNil(((uf)localObject1).SeJ.Sew)) {
            break label978;
          }
          localObject2 = this.tBD;
          if (localObject2 == null) {
            kotlin.g.b.p.bGy("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject2).setFillColor(com.tencent.mm.plugin.card.d.l.dn(((uf)localObject1).SeJ.Sew, ((uf)localObject1).SeJ.Sez));
          label669:
          localObject2 = this.tBD;
          if (localObject2 == null) {
            kotlin.g.b.p.bGy("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject2).setVisibility(0);
          label692:
          localObject2 = this.tBz;
          if (localObject2 == null) {
            kotlin.g.b.p.bGy("chpiCouponLayout");
          }
          ((LinearLayout)localObject2).removeAllViews();
          if (parama.tBo) {
            break label1092;
          }
          if (((uf)localObject1).SeK != 1) {
            break label1086;
          }
          bool = true;
          label733:
          if (!bool) {
            break label1184;
          }
          localObject2 = ((uf)localObject1).SeF;
          kotlin.g.b.p.j(localObject2, "card_element_coupon_list");
          if (((Collection)localObject2).isEmpty()) {
            break label1101;
          }
          i = 1;
          label768:
          if (i == 0) {
            break label1106;
          }
          W(-1, ((uf)localObject1).SeF.size(), paramInt);
          localObject2 = this.tBz;
          if (localObject2 == null) {
            kotlin.g.b.p.bGy("chpiCouponLayout");
          }
          ((LinearLayout)localObject2).setVisibility(0);
          parama.tBp = true;
          label814:
          if (Util.isNullOrNil(((uf)localObject1).SeG)) {
            break label1133;
          }
          Ia(paramInt);
          localObject2 = this.tBA;
          if (localObject2 == null) {
            kotlin.g.b.p.bGy("chpiExpandLayout");
          }
          ((LinearLayout)localObject2).setVisibility(0);
        }
        label913:
        label940:
        label1086:
        label1214:
        for (;;)
        {
          localObject1 = ((uf)localObject1).SeE;
          kotlin.g.b.p.j(localObject1, "card_element_mch_label");
          cS((List)localObject1);
          localObject1 = x.aazN;
          break;
          localObject2 = this.tBu;
          if (localObject2 == null) {
            kotlin.g.b.p.bGy("chpiLogoIv");
          }
          ((CdnImageView)localObject2).setImageResource(a.f.card_default_merchant_icon);
          break label172;
          localObject2 = this.tBw;
          if (localObject2 == null) {
            kotlin.g.b.p.bGy("chpiDescTv");
          }
          ((TextView)localObject2).setVisibility(8);
          break label512;
          localObject2 = this.tBD;
          if (localObject2 == null) {
            kotlin.g.b.p.bGy("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject2).setTextColor(CardHomePageNewUI.this.getResources().getColor(a.a.white));
          break label614;
          label978:
          localObject2 = this.tBD;
          if (localObject2 == null) {
            kotlin.g.b.p.bGy("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject2).setFillColor(0);
          break label669;
          label1004:
          localObject2 = this.tBD;
          if (localObject2 == null) {
            kotlin.g.b.p.bGy("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject2).setVisibility(8);
          break label692;
          localObject2 = this.tBD;
          if (localObject2 == null) {
            kotlin.g.b.p.bGy("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject2).setText((CharSequence)"");
          localObject2 = this.tBD;
          if (localObject2 == null) {
            kotlin.g.b.p.bGy("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject2).setVisibility(8);
          break label692;
          bool = false;
          break label733;
          label1092:
          bool = parama.tBp;
          break label733;
          label1101:
          i = 0;
          break label768;
          label1106:
          localObject2 = this.tBz;
          if (localObject2 == null) {
            kotlin.g.b.p.bGy("chpiCouponLayout");
          }
          ((LinearLayout)localObject2).setVisibility(8);
          break label814;
          label1133:
          if (((uf)localObject1).SeM < ((uf)localObject1).SeF.size())
          {
            Ic(paramInt);
          }
          else
          {
            localObject2 = this.tBA;
            if (localObject2 == null) {
              kotlin.g.b.p.bGy("chpiExpandLayout");
            }
            ((LinearLayout)localObject2).setVisibility(8);
            continue;
            localObject2 = ((uf)localObject1).SeF;
            kotlin.g.b.p.j(localObject2, "card_element_coupon_list");
            if (!((Collection)localObject2).isEmpty())
            {
              i = 1;
              if (i == 0) {
                break label1320;
              }
              W(-1, ((uf)localObject1).SeM, paramInt);
              localObject2 = this.tBz;
              if (localObject2 == null) {
                kotlin.g.b.p.bGy("chpiCouponLayout");
              }
              ((LinearLayout)localObject2).setVisibility(0);
              parama.tBp = false;
            }
            for (;;)
            {
              if (((uf)localObject1).SeM >= ((uf)localObject1).SeF.size())
              {
                if (!Util.isNullOrNil(((uf)localObject1).SeG))
                {
                  Ia(paramInt);
                  localObject2 = this.tBA;
                  if (localObject2 == null) {
                    kotlin.g.b.p.bGy("chpiExpandLayout");
                  }
                  ((LinearLayout)localObject2).setVisibility(0);
                  break;
                  i = 0;
                  break label1214;
                  localObject2 = this.tBz;
                  if (localObject2 == null) {
                    kotlin.g.b.p.bGy("chpiCouponLayout");
                  }
                  ((LinearLayout)localObject2).setVisibility(8);
                  continue;
                }
                localObject2 = this.tBA;
                if (localObject2 == null) {
                  kotlin.g.b.p.bGy("chpiExpandLayout");
                }
                ((LinearLayout)localObject2).setVisibility(8);
                break;
              }
            }
            Ib(paramInt);
            localObject2 = this.tBA;
            if (localObject2 == null) {
              kotlin.g.b.p.bGy("chpiExpandLayout");
            }
            ((LinearLayout)localObject2).setVisibility(0);
          }
        }
        label1031:
        label1184:
        label1320:
        localObject1 = this.tBt;
        if (localObject1 == null) {
          kotlin.g.b.p.bGy("sectionTitleTv");
        }
        ((TextView)localObject1).setText((CharSequence)parama.cKF());
        continue;
        if (localObject1 == null) {
          kotlin.g.b.p.iCn();
        }
        localObject2 = this.tBu;
        if (localObject2 == null) {
          kotlin.g.b.p.bGy("chpiLogoIv");
        }
        ((CdnImageView)localObject2).setRoundCorner(true);
        localObject2 = this.tBu;
        if (localObject2 == null) {
          kotlin.g.b.p.bGy("chpiLogoIv");
        }
        ((CdnImageView)localObject2).setUrl(((uf)localObject1).SeB);
        localObject2 = this.tBv;
        if (localObject2 == null) {
          kotlin.g.b.p.bGy("chpiNameTv");
        }
        ((TextView)localObject2).setText((CharSequence)((uf)localObject1).SeC);
        if (!Util.isNullOrNil(((uf)localObject1).SeD))
        {
          localObject2 = this.tBw;
          if (localObject2 == null) {
            kotlin.g.b.p.bGy("chpiDescTv");
          }
          ((TextView)localObject2).setText((CharSequence)((uf)localObject1).SeD);
          localObject2 = this.tBw;
          if (localObject2 == null) {
            kotlin.g.b.p.bGy("chpiDescTv");
          }
          ((TextView)localObject2).setVisibility(0);
          label1589:
          if (((uf)localObject1).SeJ == null) {
            break label1895;
          }
          if (Util.isNullOrNil(((uf)localObject1).SeJ.Seu)) {
            break label1868;
          }
          localObject2 = this.tBD;
          if (localObject2 == null) {
            kotlin.g.b.p.bGy("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject2).setText((CharSequence)((uf)localObject1).SeJ.Seu);
          if (Util.isNullOrNil(((uf)localObject1).SeJ.Sev)) {
            break label1804;
          }
          localObject2 = this.tBD;
          if (localObject2 == null) {
            kotlin.g.b.p.bGy("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject2).setTextColor(Color.parseColor(((uf)localObject1).SeJ.Sev));
          label1691:
          if (Util.isNullOrNil(((uf)localObject1).SeJ.Sew)) {
            break label1842;
          }
          localObject2 = this.tBD;
          if (localObject2 == null) {
            kotlin.g.b.p.bGy("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject2).setFillColor(com.tencent.mm.plugin.card.d.l.dn(((uf)localObject1).SeJ.Sew, ((uf)localObject1).SeJ.Sez));
          label1746:
          localObject1 = this.tBD;
          if (localObject1 == null) {
            kotlin.g.b.p.bGy("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject1).setVisibility(0);
        }
        for (;;)
        {
          localObject1 = x.aazN;
          break;
          localObject2 = this.tBw;
          if (localObject2 == null) {
            kotlin.g.b.p.bGy("chpiDescTv");
          }
          ((TextView)localObject2).setVisibility(8);
          break label1589;
          label1804:
          localObject2 = this.tBD;
          if (localObject2 == null) {
            kotlin.g.b.p.bGy("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject2).setTextColor(CardHomePageNewUI.this.getResources().getColor(a.a.white));
          break label1691;
          label1842:
          localObject1 = this.tBD;
          if (localObject1 == null) {
            kotlin.g.b.p.bGy("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject1).setFillColor(0);
          break label1746;
          label1868:
          localObject1 = this.tBD;
          if (localObject1 == null) {
            kotlin.g.b.p.bGy("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject1).setVisibility(8);
          continue;
          label1895:
          localObject1 = this.tBD;
          if (localObject1 == null) {
            kotlin.g.b.p.bGy("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject1).setText((CharSequence)"");
          localObject1 = this.tBD;
          if (localObject1 == null) {
            kotlin.g.b.p.bGy("chpiMchLabelTv");
          }
          ((CardLabelTextView)localObject1).setVisibility(8);
        }
        localObject1 = this.tBu;
        if (localObject1 == null) {
          kotlin.g.b.p.bGy("chpiLogoIv");
        }
        ((CdnImageView)localObject1).setRoundCorner(true);
        localObject1 = this.tBu;
        if (localObject1 == null) {
          kotlin.g.b.p.bGy("chpiLogoIv");
        }
        ((CdnImageView)localObject1).setImageResource(a.f.card_default_merchant_icon);
        localObject1 = this.tBv;
        if (localObject1 == null) {
          kotlin.g.b.p.bGy("chpiNameTv");
        }
        ((TextView)localObject1).setText((CharSequence)MMApplicationContext.getResources().getString(a.g.tkt));
        localObject1 = this.tBw;
        if (localObject1 == null) {
          kotlin.g.b.p.bGy("chpiDescTv");
        }
        ((TextView)localObject1).setVisibility(8);
        continue;
        localObject1 = this.tBF;
        if (localObject1 == null) {
          kotlin.g.b.p.bGy("chtiTitleTv");
        }
        ((TextView)localObject1).setText(a.g.tmo);
        if (CardHomePageNewUI.n(CardHomePageNewUI.this) != null)
        {
          localObject1 = this.tBG;
          if (localObject1 == null) {
            kotlin.g.b.p.bGy("chtiDescTv");
          }
          ((TextView)localObject1).setText((CharSequence)CardHomePageNewUI.n(CardHomePageNewUI.this));
          localObject1 = x.aazN;
          continue;
          localObject1 = this.tBF;
          if (localObject1 == null) {
            kotlin.g.b.p.bGy("chtiTitleTv");
          }
          ((TextView)localObject1).setText(a.g.tli);
          if (CardHomePageNewUI.o(CardHomePageNewUI.this) == 1)
          {
            localObject1 = this.tBG;
            if (localObject1 == null) {
              kotlin.g.b.p.bGy("chtiDescTv");
            }
            ((TextView)localObject1).setVisibility(0);
            localObject1 = this.tBH;
            if (localObject1 == null) {
              kotlin.g.b.p.bGy("chtiRightIv");
            }
            ((ImageView)localObject1).setVisibility(0);
            localObject1 = CardHomePageNewUI.this.cKB();
            if (localObject1 == null)
            {
              localObject1 = this.tBG;
              if (localObject1 == null) {
                kotlin.g.b.p.bGy("chtiDescTv");
              }
              ((TextView)localObject1).setText((CharSequence)"");
            }
            for (;;)
            {
              localObject1 = this.tBG;
              if (localObject1 == null) {
                kotlin.g.b.p.bGy("chtiDescTv");
              }
              ((TextView)localObject1).setOnClickListener((View.OnClickListener)new e(this));
              localObject1 = this.tBH;
              if (localObject1 == null) {
                kotlin.g.b.p.bGy("chtiRightIv");
              }
              ((ImageView)localObject1).setOnClickListener((View.OnClickListener)new f(this));
              localObject1 = this.tBH;
              if (localObject1 == null) {
                kotlin.g.b.p.bGy("chtiRightIv");
              }
              Util.expandViewTouchArea((View)localObject1, 50, 50, 50, 50);
              break;
              localObject2 = this.tBG;
              if (localObject2 == null) {
                kotlin.g.b.p.bGy("chtiDescTv");
              }
              ((TextView)localObject2).setText((CharSequence)((ux)localObject1).SfF);
            }
          }
          localObject1 = this.tBG;
          if (localObject1 == null) {
            kotlin.g.b.p.bGy("chtiDescTv");
          }
          ((TextView)localObject1).setVisibility(8);
          localObject1 = this.tBH;
          if (localObject1 == null) {
            kotlin.g.b.p.bGy("chtiRightIv");
          }
          ((ImageView)localObject1).setVisibility(8);
          continue;
          localObject1 = parama.tBq;
          if (localObject1 != null)
          {
            localObject2 = this.tBF;
            if (localObject2 == null) {
              kotlin.g.b.p.bGy("chtiTitleTv");
            }
            ((TextView)localObject2).setText((CharSequence)((uk)localObject1).SeX);
            localObject2 = this.tBG;
            if (localObject2 == null) {
              kotlin.g.b.p.bGy("chtiDescTv");
            }
            ((TextView)localObject2).setText((CharSequence)((uk)localObject1).SeY);
            localObject2 = this.tBE;
            if (localObject2 == null) {
              kotlin.g.b.p.bGy("chtiIconIv");
            }
            localObject3 = ((uk)localObject1).SeW;
            kotlin.g.b.p.j(localObject3, "card_top_cell_icon");
            b((ImageView)localObject2, (String)localObject3);
            localObject2 = this.tBJ;
            if (localObject2 == null) {
              kotlin.g.b.p.bGy("chtiNewTv");
            }
            if (((uk)localObject1).Sfe != 1) {
              break label2660;
            }
            paramInt = 0;
            label2582:
            ((TextView)localObject2).setVisibility(paramInt);
            localObject2 = this.tBI;
            if (localObject2 == null) {
              kotlin.g.b.p.bGy("chtiRedDotIv");
            }
            if (((uk)localObject1).Sfd != 1) {
              break label2666;
            }
          }
          label2660:
          label2666:
          for (paramInt = 0;; paramInt = 8)
          {
            ((ImageView)localObject2).setVisibility(paramInt);
            localObject1 = x.aazN;
            if (!parama.tBr) {
              break label2672;
            }
            localObject1 = this.tBK;
            if (localObject1 == null) {
              kotlin.g.b.p.bGy("chtiDivider");
            }
            ((View)localObject1).setVisibility(0);
            break;
            paramInt = 8;
            break label2582;
          }
          label2672:
          localObject1 = this.tBK;
          if (localObject1 == null) {
            kotlin.g.b.p.bGy("chtiDivider");
          }
          ((View)localObject1).setVisibility(8);
        }
      }
    }
    
    public final void arA(String paramString)
    {
      AppMethodBeat.i(112429);
      kotlin.g.b.p.k(paramString, "cardId");
      Log.i("MicroMsg.CardHomePageNewUI", "go to card detail: %s", new Object[] { paramString });
      Object localObject = this.amk;
      kotlin.g.b.p.j(localObject, "itemView");
      localObject = new Intent(((View)localObject).getContext(), CardDetailUI.class);
      ((Intent)localObject).putExtra("key_card_id", paramString);
      ((Intent)localObject).addFlags(131072);
      ((Intent)localObject).putExtra("key_from_scene", 3);
      paramString = this.amk;
      kotlin.g.b.p.j(paramString, "itemView");
      paramString = paramString.getContext();
      localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH", "gotoCardDetailUI", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramString, "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH", "gotoCardDetailUI", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(112429);
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(CardHomePageNewUI.e parame, uf paramuf, uc paramuc, int paramInt1, int paramInt2) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(112417);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$appendCouponView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        CardHomePageNewUI.k(this.tBM.tBs);
        CardHomePageNewUI.a(this.tBM.tBs, 0);
        CardHomePageNewUI.a(this.tBM.tBs, this.tBN);
        paramView = this.tBM;
        localObject = localuc.RFf;
        kotlin.g.b.p.j(localObject, "coupon.user_card_id");
        paramView.arA((String)localObject);
        com.tencent.mm.plugin.report.service.h.IzE.a(16324, new Object[] { Integer.valueOf(1), this.tBN.SeA, Integer.valueOf(this.nmX), localuc.RFf, Integer.valueOf(2), Integer.valueOf(paramInt3), Integer.valueOf(CardHomePageNewUI.m(this.tBM.tBs)) });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$appendCouponView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(112417);
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b
      implements View.OnClickListener
    {
      b(CardHomePageNewUI.e parame, uf paramuf, uc paramuc, int paramInt1, int paramInt2) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(112418);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$appendCouponView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        CardHomePageNewUI.k(this.tBM.tBs);
        CardHomePageNewUI.a(this.tBM.tBs, 0);
        CardHomePageNewUI.a(this.tBM.tBs, this.tBN);
        paramView = this.tBM;
        localObject = localuc.RFf;
        kotlin.g.b.p.j(localObject, "coupon.user_card_id");
        paramView.arA((String)localObject);
        com.tencent.mm.plugin.report.service.h.IzE.a(16324, new Object[] { Integer.valueOf(1), this.tBN.SeA, Integer.valueOf(this.nmX), localuc.RFf, Integer.valueOf(2), Integer.valueOf(paramInt3), Integer.valueOf(CardHomePageNewUI.m(this.tBM.tBs)) });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$appendCouponView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(112418);
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$setModel$1$headerClickListener$1"})
    static final class c
      implements View.OnClickListener
    {
      c(uf paramuf1, CardHomePageNewUI.e parame, uf paramuf2, int paramInt, boolean paramBoolean, CardHomePageNewUI.a parama) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(112419);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$setModel$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        Log.i("MicroMsg.CardHomePageNewUI", "click header");
        CardHomePageNewUI.k(jdField_this.tBs);
        CardHomePageNewUI.a(jdField_this.tBs, 0);
        CardHomePageNewUI.a(jdField_this.tBs, this.tBQ);
        switch (this.tBP.Sep)
        {
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.h.IzE.a(16324, new Object[] { Integer.valueOf(1), this.tBP.SeA, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(paramInt), Integer.valueOf(CardHomePageNewUI.m(jdField_this.tBs)) });
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$setModel$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(112419);
          return;
          paramView = jdField_this.amk;
          kotlin.g.b.p.j(paramView, "itemView");
          paramView = paramView.getContext();
          if (paramView == null)
          {
            paramView = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(112419);
            throw paramView;
          }
          com.tencent.mm.plugin.card.d.b.a((MMActivity)paramView, this.tBP.Seq);
          continue;
          paramView = this.tBP.Ser;
          com.tencent.mm.plugin.card.d.b.L(paramView.Ooe, paramView.Oof, paramView.Paq);
        }
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class e
      implements View.OnClickListener
    {
      e(CardHomePageNewUI.e parame) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(112421);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$setModel$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        CardHomePageNewUI.p(this.tBM.tBs);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$setModel$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(112421);
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class f
      implements View.OnClickListener
    {
      f(CardHomePageNewUI.e parame) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(112422);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$setModel$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        CardHomePageNewUI.p(this.tBM.tBs);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$setModel$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(112422);
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class g
      implements View.OnClickListener
    {
      g(CardHomePageNewUI.e parame, int paramInt, uf paramuf) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(112423);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$showCollapseLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        Log.d("MicroMsg.CardHomePageNewUI", "do collapse coupon layout");
        CardHomePageNewUI.e.b(this.tBM, paramInt);
        paramView = this.tBM.tBL;
        if (paramView != null) {
          paramView.tBp = false;
        }
        paramView = com.tencent.mm.plugin.report.service.h.IzE;
        localObject = this.tBN;
        if (localObject == null) {
          kotlin.g.b.p.iCn();
        }
        paramView.a(16324, new Object[] { Integer.valueOf(1), ((uf)localObject).SeA, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(5), Integer.valueOf(paramInt), Integer.valueOf(CardHomePageNewUI.m(this.tBM.tBs)) });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$showCollapseLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(112423);
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class h
      implements View.OnClickListener
    {
      h(CardHomePageNewUI.e parame, int paramInt, uf paramuf) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(112424);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$showExpandLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        Log.d("MicroMsg.CardHomePageNewUI", "do expand coupon layout");
        CardHomePageNewUI.e.a(this.tBM, paramInt);
        paramView = this.tBM.tBL;
        if (paramView != null) {
          paramView.tBp = true;
        }
        paramView = com.tencent.mm.plugin.report.service.h.IzE;
        localObject = this.tBN;
        if (localObject == null) {
          kotlin.g.b.p.iCn();
        }
        paramView.a(16324, new Object[] { Integer.valueOf(1), ((uf)localObject).SeA, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(4), Integer.valueOf(paramInt), Integer.valueOf(CardHomePageNewUI.m(this.tBM.tBs)) });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$showExpandLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(112424);
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$showMiniAppLayout$1$1"})
    static final class i
      implements View.OnClickListener
    {
      i(uf paramuf, CardHomePageNewUI.e parame, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(112425);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$showMiniAppLayout$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        if (this.tBP.SeI != null) {
          if (this.tBP.SeI == null) {
            break label266;
          }
        }
        label266:
        for (boolean bool = true;; bool = false)
        {
          Log.i("MicroMsg.CardHomePageNewUI", "detail goto mini app %s", new Object[] { Boolean.valueOf(bool) });
          CardHomePageNewUI.k(jdField_this.tBs);
          CardHomePageNewUI.a(jdField_this.tBs, 0);
          CardHomePageNewUI.a(jdField_this.tBs, this.tBP);
          com.tencent.mm.plugin.card.d.b.L(this.tBP.SeI.Ooe, this.tBP.SeI.Oof, this.tBP.SeI.Paq);
          paramView = com.tencent.mm.plugin.report.service.h.IzE;
          localObject = jdField_this.tBL;
          if (localObject == null) {
            kotlin.g.b.p.iCn();
          }
          localObject = ((CardHomePageNewUI.a)localObject).tBm;
          if (localObject == null) {
            kotlin.g.b.p.iCn();
          }
          paramView.a(16324, new Object[] { Integer.valueOf(1), ((uf)localObject).SeA, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(6), Integer.valueOf(paramInt), Integer.valueOf(CardHomePageNewUI.m(jdField_this.tBs)) });
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$showMiniAppLayout$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(112425);
          return;
        }
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "kotlin.jvm.PlatformType", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/DeleteMchInListResponse;", "call"})
  static final class f<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    f(CardHomePageNewUI paramCardHomePageNewUI, String paramString) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "kotlin.jvm.PlatformType", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetMktCardHomePageResponse;", "call"})
  static final class g<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    g(CardHomePageNewUI paramCardHomePageNewUI) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetCardPkgMchInfoResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class h<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    h(CardHomePageNewUI paramCardHomePageNewUI, String paramString) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$initView$1", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "paint", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "paint2", "getPaint2", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "onDraw", "c", "Landroid/graphics/Canvas;", "plugin-card_release"})
  public static final class i
    extends RecyclerView.h
  {
    private final Paint paint;
    private final Paint tBV;
    
    i()
    {
      AppMethodBeat.i(112446);
      this.paint = new Paint();
      this.tBV = new Paint();
      this.paint.setColor(localObject.getResources().getColor(a.a.small_line_color));
      this.paint.setStyle(Paint.Style.FILL);
      this.paint.setFlags(1);
      this.tBV.setColor(localObject.getResources().getColor(a.a.white));
      this.tBV.setStyle(Paint.Style.FILL);
      this.tBV.setFlags(1);
      AppMethodBeat.o(112446);
    }
    
    public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(249527);
      kotlin.g.b.p.k(paramCanvas, "c");
      kotlin.g.b.p.k(paramRecyclerView, "parent");
      kotlin.g.b.p.k(params, "state");
      super.a(paramCanvas, paramRecyclerView, params);
      paramRecyclerView = CardHomePageNewUI.j(this.tBs);
      if (paramRecyclerView != null)
      {
        int i = paramRecyclerView.getPaddingLeft();
        params = CardHomePageNewUI.tBl;
        int k = i + CardHomePageNewUI.cKE();
        int m = paramRecyclerView.getWidth();
        int n = paramRecyclerView.getPaddingRight();
        int i1 = paramRecyclerView.getChildCount();
        i = 0;
        if (i < i1 - 1)
        {
          params = paramRecyclerView.getChildAt(i);
          kotlin.g.b.p.j(params, "child");
          Object localObject = params.getLayoutParams();
          if (localObject == null)
          {
            paramCanvas = new t("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
            AppMethodBeat.o(249527);
            throw paramCanvas;
          }
          localObject = (RecyclerView.LayoutParams)localObject;
          int i2 = params.getBottom() + ((RecyclerView.LayoutParams)localObject).bottomMargin;
          if (i == i1 - 1) {
            params = CardHomePageNewUI.tBl;
          }
          for (int j = CardHomePageNewUI.cKD();; j = 1)
          {
            j = i2 + j;
            if (paramCanvas != null) {
              paramCanvas.drawRect(k, i2, m - n, j, this.paint);
            }
            if (paramCanvas != null) {
              paramCanvas.drawRect(0.0F, i2, k, j, this.tBV);
            }
            i += 1;
            break;
          }
        }
        AppMethodBeat.o(249527);
        return;
      }
      AppMethodBeat.o(249527);
    }
    
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(249526);
      kotlin.g.b.p.k(paramRect, "outRect");
      kotlin.g.b.p.k(paramView, "view");
      kotlin.g.b.p.k(paramRecyclerView, "parent");
      kotlin.g.b.p.k(params, "state");
      super.a(paramRect, paramView, paramRecyclerView, params);
      if (RecyclerView.bh(paramView) == CardHomePageNewUI.q(this.tBs).getItemCount() - 1)
      {
        Log.d("MicroMsg.CardHomePageNewUI", "is last");
        paramView = CardHomePageNewUI.tBl;
        paramRect.bottom = CardHomePageNewUI.cKD();
        AppMethodBeat.o(249526);
        return;
      }
      paramRect.bottom = 1;
      AppMethodBeat.o(249526);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "parent", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "kotlin.jvm.PlatformType", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onLoadMore"})
  static final class j
    implements LoadMoreRecyclerView.a
  {
    j(CardHomePageNewUI paramCardHomePageNewUI) {}
    
    public final void clj()
    {
      AppMethodBeat.i(244742);
      CardHomePageNewUI.r(this.tBs);
      AppMethodBeat.o(244742);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "kotlin.jvm.PlatformType", "view", "Landroid/view/View;", "position", "", "id", "", "onItemClick"})
  static final class k
    implements MRecyclerView.a
  {
    k(CardHomePageNewUI paramCardHomePageNewUI) {}
    
    public final void U(View paramView, int paramInt)
    {
      AppMethodBeat.i(244565);
      paramView = CardHomePageNewUI.q(this.tBs).HZ(paramInt);
      if (paramView != null)
      {
        Log.i("MicroMsg.CardHomePageNewUI", "click type: %s", new Object[] { Integer.valueOf(paramView.type) });
        Object localObject2;
        switch (paramView.type)
        {
        case 3: 
        default: 
          AppMethodBeat.o(244565);
          return;
        case 2: 
          CardHomePageNewUI.k(this.tBs);
          CardHomePageNewUI.a(this.tBs, 1);
          CardHomePageNewUI.a(this.tBs, paramView.tBm);
          localObject1 = paramView.tBm;
          if (localObject1 == null) {
            kotlin.g.b.p.iCn();
          }
          switch (((uf)localObject1).Sep)
          {
          }
          for (;;)
          {
            localObject1 = com.tencent.mm.plugin.report.service.h.IzE;
            paramView = paramView.tBm;
            if (paramView == null) {
              kotlin.g.b.p.iCn();
            }
            ((com.tencent.mm.plugin.report.service.h)localObject1).a(16324, new Object[] { Integer.valueOf(2), paramView.SeA, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(paramInt), Integer.valueOf(CardHomePageNewUI.m(this.tBs)) });
            AppMethodBeat.o(244565);
            return;
            localObject1 = (MMActivity)this.tBs;
            localObject2 = paramView.tBm;
            if (localObject2 == null) {
              kotlin.g.b.p.iCn();
            }
            com.tencent.mm.plugin.card.d.b.a((MMActivity)localObject1, ((uf)localObject2).Seq);
            continue;
            localObject1 = paramView.tBm;
            if (localObject1 == null) {
              kotlin.g.b.p.iCn();
            }
            localObject1 = ((uf)localObject1).Ser;
            com.tencent.mm.plugin.card.d.b.L(((up)localObject1).Ooe, ((up)localObject1).Oof, ((up)localObject1).Paq);
          }
        case 4: 
          Log.i("MicroMsg.CardHomePageNewUI", "click ticket item");
          localObject1 = new Intent((Context)this.tBs, CardTicketListUI.class);
          paramView = this.tBs;
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject1);
          com.tencent.mm.hellhoundlib.a.a.b(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aFh(), "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$initView$3", "onItemClick", "(Landroidx/recyclerview/widget/RecyclerView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramView, "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$initView$3", "onItemClick", "(Landroidx/recyclerview/widget/RecyclerView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.plugin.report.service.h.IzE.a(16322, new Object[] { Integer.valueOf(5) });
          AppMethodBeat.o(244565);
          return;
        case 5: 
          com.tencent.mm.plugin.report.service.h.IzE.a(16322, new Object[] { Integer.valueOf(13) });
          AppMethodBeat.o(244565);
          return;
        }
        Object localObject1 = paramView.tBq;
        if (localObject1 == null) {
          kotlin.g.b.p.iCn();
        }
        switch (((uk)localObject1).SeZ)
        {
        }
        for (;;)
        {
          localObject1 = paramView.tBq;
          if (localObject1 == null) {
            kotlin.g.b.p.iCn();
          }
          ((uk)localObject1).Sfe = 0;
          paramView = paramView.tBq;
          if (paramView == null) {
            kotlin.g.b.p.iCn();
          }
          paramView.Sfd = 0;
          CardHomePageNewUI.q(this.tBs).cL(paramInt);
          break;
          localObject1 = (MMActivity)this.tBs;
          localObject2 = paramView.tBq;
          if (localObject2 == null) {
            kotlin.g.b.p.iCn();
          }
          com.tencent.mm.plugin.card.d.b.a((MMActivity)localObject1, ((uk)localObject2).Sfa);
          CardHomePageNewUI.s(this.tBs);
          continue;
          localObject1 = paramView.tBq;
          if (localObject1 == null) {
            kotlin.g.b.p.iCn();
          }
          localObject1 = ((uk)localObject1).Sfb;
          com.tencent.mm.plugin.card.d.b.L(((up)localObject1).Ooe, ((up)localObject1).Oof, ((up)localObject1).Paq);
          CardHomePageNewUI.s(this.tBs);
          continue;
          localObject1 = new StringBuilder("click native url: ");
          localObject2 = paramView.tBq;
          if (localObject2 == null) {
            kotlin.g.b.p.iCn();
          }
          Log.i("MicroMsg.CardHomePageNewUI", ((uk)localObject2).Sfc);
          localObject1 = paramView.tBq;
          if (localObject1 == null) {
            kotlin.g.b.p.iCn();
          }
          if (kotlin.g.b.p.h("weixin://mktcard/cert", ((uk)localObject1).Sfc))
          {
            localObject2 = new Intent((Context)this.tBs, CardTicketListUI.class);
            localObject1 = this.tBs;
            localObject2 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject2);
            com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$initView$3", "onItemClick", "(Landroidx/recyclerview/widget/RecyclerView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((CardHomePageNewUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0));
            com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$initView$3", "onItemClick", "(Landroidx/recyclerview/widget/RecyclerView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            CardHomePageNewUI.s(this.tBs);
          }
        }
      }
      AppMethodBeat.o(244565);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "kotlin.jvm.PlatformType", "view", "Landroid/view/View;", "position", "", "id", "", "onItemLongClick"})
  static final class l
    implements MRecyclerView.b
  {
    l(CardHomePageNewUI paramCardHomePageNewUI) {}
    
    public final boolean V(View paramView, final int paramInt)
    {
      AppMethodBeat.i(246025);
      paramView = CardHomePageNewUI.q(this.tBs).HZ(paramInt);
      if (paramView != null)
      {
        Log.i("MicroMsg.CardHomePageNewUI", "long click type: %s", new Object[] { Integer.valueOf(paramView.type) });
        switch (paramView.type)
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(246025);
        return false;
        Object localObject = new com.tencent.mm.ui.tools.m((Context)this.tBs.getContext());
        ((com.tencent.mm.ui.tools.m)localObject).a((q.f)new a(this, paramInt));
        ((com.tencent.mm.ui.tools.m)localObject).a((q.g)new b(paramView, this, paramInt));
        ((com.tencent.mm.ui.tools.m)localObject).hYu();
        localObject = com.tencent.mm.plugin.report.service.h.IzE;
        paramView = paramView.tBm;
        if (paramView == null) {
          kotlin.g.b.p.iCn();
        }
        ((com.tencent.mm.plugin.report.service.h)localObject).a(16324, new Object[] { Integer.valueOf(2), paramView.SeA, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(7), Integer.valueOf(paramInt), Integer.valueOf(CardHomePageNewUI.m(this.tBs)) });
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu", "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$initView$4$1$1"})
    static final class a
      implements q.f
    {
      a(CardHomePageNewUI.l paraml, int paramInt) {}
      
      public final void onCreateMMMenu(com.tencent.mm.ui.base.o paramo)
      {
        AppMethodBeat.i(112449);
        paramo.d(1, (CharSequence)this.tBW.tBs.getString(a.g.app_delete));
        AppMethodBeat.o(112449);
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected", "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$initView$4$1$2"})
    static final class b
      implements q.g
    {
      b(CardHomePageNewUI.a parama, CardHomePageNewUI.l paraml, int paramInt) {}
      
      public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
      {
        AppMethodBeat.i(112451);
        kotlin.g.b.p.j(paramMenuItem, "menuItem");
        switch (paramMenuItem.getItemId())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(112451);
          return;
          com.tencent.mm.ui.base.h.a((Context)jdField_this.tBs.getContext(), jdField_this.tBs.getString(a.g.tkF), "", false, (DialogInterface.OnClickListener)new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(112450);
              Object localObject1 = this.tBY.tBW.tBs;
              Object localObject2 = this.tBY.tBX.tBm;
              if (localObject2 == null) {
                kotlin.g.b.p.iCn();
              }
              localObject2 = ((uf)localObject2).SeA;
              kotlin.g.b.p.j(localObject2, "element!!.card_pack_merchant_id");
              kotlin.g.b.p.k(localObject2, "merchantId");
              Log.i("MicroMsg.CardHomePageNewUI", "do delete merchant: %s", new Object[] { localObject2 });
              new com.tencent.mm.plugin.card.model.a.d((String)localObject2).bhW().b((com.tencent.mm.vending.c.a)new CardHomePageNewUI.f((CardHomePageNewUI)localObject1, (String)localObject2));
              paramAnonymousDialogInterface.dismiss();
              paramAnonymousDialogInterface = com.tencent.mm.plugin.report.service.h.IzE;
              localObject1 = this.tBY.tBX.tBm;
              if (localObject1 == null) {
                kotlin.g.b.p.iCn();
              }
              paramAnonymousDialogInterface.a(16324, new Object[] { Integer.valueOf(2), ((uf)localObject1).SeA, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(9), Integer.valueOf(this.tBY.rgL), Integer.valueOf(CardHomePageNewUI.m(this.tBY.tBW.tBs)) });
              AppMethodBeat.o(112450);
            }
          });
          paramMenuItem = com.tencent.mm.plugin.report.service.h.IzE;
          uf localuf = this.tBX.tBm;
          if (localuf == null) {
            kotlin.g.b.p.iCn();
          }
          paramMenuItem.a(16324, new Object[] { Integer.valueOf(2), localuf.SeA, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(8), Integer.valueOf(paramInt), Integer.valueOf(CardHomePageNewUI.m(jdField_this.tBs)) });
        }
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick", "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$setFaqIconMenu$1$1"})
  static final class n
    implements MenuItem.OnMenuItemClickListener
  {
    n(ug paramug, CardHomePageNewUI paramCardHomePageNewUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(112456);
      paramMenuItem = new e((Context)jdField_this.getContext(), 1, false);
      paramMenuItem.a((q.f)new q.f()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.o paramAnonymouso)
        {
          AppMethodBeat.i(112454);
          paramAnonymouso.add(0, 0, 1, (CharSequence)this.tCa.tBZ.SeO);
          AppMethodBeat.o(112454);
        }
      });
      paramMenuItem.a((q.g)new q.g()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(112455);
          kotlin.g.b.p.j(paramAnonymousMenuItem, "menuItem");
          if (paramAnonymousMenuItem.getItemId() == 0) {
            switch (this.tCa.tBZ.SeP)
            {
            }
          }
          for (;;)
          {
            AppMethodBeat.o(112455);
            return;
            com.tencent.mm.plugin.card.d.b.a((MMActivity)this.tCa.tBs, this.tCa.tBZ.SeQ);
            AppMethodBeat.o(112455);
            return;
            paramAnonymousMenuItem = this.tCa.tBZ.SeR;
            com.tencent.mm.plugin.card.d.b.L(paramAnonymousMenuItem.Ooe, paramAnonymousMenuItem.Oof, paramAnonymousMenuItem.Paq);
          }
        }
      });
      paramMenuItem.eik();
      AppMethodBeat.o(112456);
      return false;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu", "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$showSortSheet$1$1"})
  static final class o
    implements q.f
  {
    o(CardHomePageNewUI paramCardHomePageNewUI) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.o paramo)
    {
      AppMethodBeat.i(112457);
      Iterator localIterator = ((Iterable)CardHomePageNewUI.y(this.tBs)).iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        paramo.add(0, i, 1, (CharSequence)((ux)localIterator.next()).SfF);
        i += 1;
      }
      AppMethodBeat.o(112457);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected", "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$showSortSheet$1$2"})
  static final class p
    implements q.g
  {
    p(CardHomePageNewUI paramCardHomePageNewUI) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(112459);
      kotlin.g.b.p.j(paramMenuItem, "menuItem");
      paramInt = paramMenuItem.getItemId();
      Log.i("MicroMsg.CardHomePageNewUI", "click item: %s, sortType: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(CardHomePageNewUI.m(this.tBs)) });
      paramMenuItem = CardHomePageNewUI.y(this.tBs).get(paramInt);
      kotlin.g.b.p.j(paramMenuItem, "cardSortInfoList[itemId]");
      paramMenuItem = (ux)paramMenuItem;
      CardHomePageNewUI.d(this.tBs, paramMenuItem.SfE);
      if ((paramMenuItem.SfD == 1) && (CardHomePageNewUI.m(this.tBs) != 1))
      {
        if (!this.tBs.tCo)
        {
          com.tencent.mm.ui.base.h.a((Context)this.tBs.getContext(), this.tBs.getString(a.g.tkA), this.tBs.getString(a.g.permission_tips_title), this.tBs.getString(a.g.jump_to_settings), this.tBs.getString(a.g.confirm_dialog_cancel), false, (DialogInterface.OnClickListener)new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(112458);
              this.tCb.tBs.startActivityForResult(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"), 564);
              AppMethodBeat.o(112458);
            }
          }, null);
          AppMethodBeat.o(112459);
          return;
        }
        CardHomePageNewUI.b(this.tBs, true);
        CardHomePageNewUI.c(this.tBs, 0);
        CardHomePageNewUI.b(this.tBs, 1);
        CardHomePageNewUI.r(this.tBs);
        com.tencent.mm.plugin.report.service.h.IzE.a(16322, new Object[] { Integer.valueOf(15) });
        AppMethodBeat.o(112459);
        return;
      }
      if ((paramMenuItem.SfD == 2) && (CardHomePageNewUI.m(this.tBs) != 2))
      {
        CardHomePageNewUI.b(this.tBs, true);
        CardHomePageNewUI.c(this.tBs, 0);
        CardHomePageNewUI.b(this.tBs, 2);
        CardHomePageNewUI.r(this.tBs);
        com.tencent.mm.plugin.report.service.h.IzE.a(16322, new Object[] { Integer.valueOf(16) });
        AppMethodBeat.o(112459);
        return;
      }
      if ((paramMenuItem.SfD == 3) && (CardHomePageNewUI.m(this.tBs) != 3))
      {
        CardHomePageNewUI.b(this.tBs, true);
        CardHomePageNewUI.c(this.tBs, 0);
        CardHomePageNewUI.b(this.tBs, 3);
        CardHomePageNewUI.r(this.tBs);
        com.tencent.mm.plugin.report.service.h.IzE.a(16322, new Object[] { Integer.valueOf(17) });
      }
      AppMethodBeat.o(112459);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v2.CardHomePageNewUI
 * JD-Core Version:    0.7.0.1
 */