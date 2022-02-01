package com.tencent.mm.plugin.finder.feed.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.order.data.c.b;
import com.tencent.mm.plugin.finder.order.data.c.c;
import com.tencent.mm.plugin.finder.order.search.a.b;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.protocal.protobuf.alt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.FTSEditTextView.c;
import com.tencent.mm.ui.search.FTSEditTextView.d;
import com.tencent.mm.ui.search.FTSSearchView;
import com.tencent.mm.ui.search.FTSSearchView.b;
import com.tencent.mm.ui.search.FTSSearchView.c;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.b;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.a.ar;
import kotlin.ah;
import kotlin.g.b.u;
import kotlin.n.n;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI23;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/ui/search/FTSSearchView$FTSSearchViewListener;", "Lcom/tencent/mm/ui/search/FTSEditTextView$FTSEditTextListener;", "()V", "feedLoader", "Lcom/tencent/mm/plugin/finder/order/data/OrderSearchFeedLoader;", "hasMore", "", "historyLogic", "Lcom/tencent/mm/plugin/finder/order/search/FinderOrderSearchHistoryLogic;", "loadingView", "Landroid/view/View;", "mergeDataAndRefresh", "Lkotlin/Function5;", "", "Lcom/tencent/mm/protocal/protobuf/EcCustomerSearchOrderListResp;", "", "noResultView", "Landroid/widget/TextView;", "query", "", "recyclerView", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "retryView", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "searchView", "Lcom/tencent/mm/ui/search/FTSSearchView;", "getLayoutId", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "initContentView", "initSearchView", "onClickBackBtn", "view", "onClickCancelBtn", "onClickClearTextBtn", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onEditTextChange", "totalText", "inEditText", "tagList", "", "Lcom/tencent/mm/ui/search/FTSSearchView$IFTSTagModel;", "textChangeStatus", "Lcom/tencent/mm/ui/search/FTSEditTextView$TextChangeStatus;", "onEditTextFocusChange", "hasFocus", "onSearchKeyDown", "onTagClick", "index", "tag", "startSearch", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class OccupyFinderUI23
  extends MMFinderUI
  implements FTSEditTextView.c, FTSSearchView.b
{
  private RefreshLoadMoreLayout ATx;
  private WxRecyclerView AZd;
  private TextView BnA;
  private FTSSearchView Bny;
  private View BsS;
  private com.tencent.mm.plugin.finder.order.data.c BsT;
  private com.tencent.mm.plugin.finder.order.search.a BsU;
  private final kotlin.g.a.s<Integer, Integer, alt, Integer, Integer, ah> BsV;
  private boolean hasMore;
  private View njN;
  private String query;
  
  public OccupyFinderUI23()
  {
    AppMethodBeat.i(364234);
    this.hasMore = true;
    this.query = "";
    this.BsV = ((kotlin.g.a.s)new d(this));
    AppMethodBeat.o(364234);
  }
  
  private static final void a(OccupyFinderUI23 paramOccupyFinderUI23, View paramView)
  {
    AppMethodBeat.i(364243);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramOccupyFinderUI23);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI23", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramOccupyFinderUI23, "this$0");
    paramOccupyFinderUI23.awg(paramOccupyFinderUI23.query);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI23", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(364243);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final boolean aWU()
  {
    AppMethodBeat.i(364401);
    hideVKB();
    Object localObject2 = this.Bny;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("searchView");
      localObject1 = null;
    }
    localObject1 = ((FTSSearchView)localObject1).getFtsEditText().getTotalQuery();
    if (localObject1 == null) {
      localObject1 = "";
    }
    while (Util.isNullOrNil((String)localObject1))
    {
      AppMethodBeat.o(364401);
      return true;
      localObject2 = n.bq((CharSequence)localObject1).toString();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
    }
    awg((String)localObject1);
    localObject2 = this.BsU;
    if ((localObject2 != null) && (localObject1 != null))
    {
      a.b localb = a.b.ESH;
      a.b.azd((String)localObject1);
      ((com.tencent.mm.plugin.finder.order.search.a)localObject2).uiF.setVisibility(0);
    }
    AppMethodBeat.o(364401);
    return false;
  }
  
  public final void awg(String paramString)
  {
    AppMethodBeat.i(364360);
    kotlin.g.b.s.u(paramString, "query");
    Object localObject = this.BsT;
    if (localObject == null)
    {
      kotlin.g.b.s.bIx("feedLoader");
      localObject = null;
    }
    for (;;)
    {
      kotlin.g.b.s.u(paramString, "query");
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new c.c((com.tencent.mm.plugin.finder.order.data.c)localObject, paramString));
      localObject = this.njN;
      paramString = (String)localObject;
      if (localObject == null)
      {
        kotlin.g.b.s.bIx("loadingView");
        paramString = null;
      }
      paramString.setVisibility(0);
      localObject = this.BnA;
      paramString = (String)localObject;
      if (localObject == null)
      {
        kotlin.g.b.s.bIx("noResultView");
        paramString = null;
      }
      paramString.setVisibility(8);
      localObject = this.ATx;
      paramString = (String)localObject;
      if (localObject == null)
      {
        kotlin.g.b.s.bIx("rlLayout");
        paramString = null;
      }
      paramString.setVisibility(8);
      localObject = this.BsS;
      paramString = (String)localObject;
      if (localObject == null)
      {
        kotlin.g.b.s.bIx("retryView");
        paramString = null;
      }
      paramString.setVisibility(8);
      localObject = this.AZd;
      paramString = (String)localObject;
      if (localObject == null)
      {
        kotlin.g.b.s.bIx("recyclerView");
        paramString = null;
      }
      localObject = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI23", "startSearch", "(Ljava/lang/String;)V", "Undefined", "scrollToPosition", "(I)V");
      paramString.scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(paramString, "com/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI23", "startSearch", "(Ljava/lang/String;)V", "Undefined", "scrollToPosition", "(I)V");
      paramString = k.aeZF;
      ((com.tencent.mm.plugin.finder.order.report.a)k.d((AppCompatActivity)this).q(com.tencent.mm.plugin.finder.order.report.a.class)).w("go_to_search", ak.l(new r("current_page", "order_list")));
      AppMethodBeat.o(364360);
      return;
    }
  }
  
  public final void eeU() {}
  
  public final void fq(boolean paramBoolean) {}
  
  public final int getLayoutId()
  {
    return p.f.CeY;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(364321);
    Set localSet = ar.setOf(com.tencent.mm.plugin.finder.order.report.a.class);
    AppMethodBeat.o(364321);
    return localSet;
  }
  
  public final void onClickBackBtn(View paramView)
  {
    AppMethodBeat.i(364408);
    hideVKB();
    finish();
    AppMethodBeat.o(364408);
  }
  
  public final void onClickCancelBtn(View paramView)
  {
    AppMethodBeat.i(364416);
    hideVKB();
    finish();
    AppMethodBeat.o(364416);
  }
  
  public final void onClickClearTextBtn(View paramView)
  {
    AppMethodBeat.i(364392);
    FTSSearchView localFTSSearchView = this.Bny;
    paramView = localFTSSearchView;
    if (localFTSSearchView == null)
    {
      kotlin.g.b.s.bIx("searchView");
      paramView = null;
    }
    paramView.getFtsEditText().aWT();
    showVKB();
    AppMethodBeat.o(364392);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    Object localObject2 = null;
    AppMethodBeat.i(364337);
    super.onCreate(paramBundle);
    this.Bny = new FTSSearchView((Context)this, (byte)0);
    paramBundle = this.Bny;
    if (paramBundle == null)
    {
      kotlin.g.b.s.bIx("searchView");
      paramBundle = null;
    }
    for (;;)
    {
      paramBundle.setSearchViewListener((FTSSearchView.b)this);
      localObject1 = this.Bny;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("searchView");
        paramBundle = null;
      }
      paramBundle.getFtsEditText().setHint(getString(p.h.app_search));
      localObject1 = this.Bny;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("searchView");
        paramBundle = null;
      }
      paramBundle.getFtsEditText().setFtsEditTextListener((FTSEditTextView.c)this);
      localObject1 = this.Bny;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("searchView");
        paramBundle = null;
      }
      paramBundle.getFtsEditText().setCanDeleteTag(false);
      localObject1 = this.Bny;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("searchView");
        paramBundle = null;
      }
      paramBundle.getFtsEditText().jBL();
      localObject3 = getSupportActionBar();
      kotlin.g.b.s.checkNotNull(localObject3);
      localObject1 = this.Bny;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("searchView");
        paramBundle = null;
      }
      ((ActionBar)localObject3).setCustomView((View)paramBundle);
      this.query = "";
      localObject1 = this.Bny;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("searchView");
        paramBundle = null;
      }
      paramBundle.getFtsEditText().aWT();
      localObject1 = this.Bny;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("searchView");
        paramBundle = null;
      }
      paramBundle.getFtsEditText().aWS();
      this.BsU = new com.tencent.mm.plugin.finder.order.search.a((MMActivity)this, (kotlin.g.a.b)new b(this), (com.tencent.mm.plugin.finder.order.search.b)new c());
      paramBundle = getContext();
      if (paramBundle != null) {
        break;
      }
      paramBundle = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(364337);
      throw paramBundle;
    }
    this.BsT = new com.tencent.mm.plugin.finder.order.data.c((MMActivity)paramBundle, this.BsV);
    this.hasMore = true;
    paramBundle = findViewById(p.e.rl_layout);
    kotlin.g.b.s.s(paramBundle, "findViewById(R.id.rl_layout)");
    this.ATx = ((RefreshLoadMoreLayout)paramBundle);
    Object localObject1 = this.ATx;
    paramBundle = (Bundle)localObject1;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("rlLayout");
      paramBundle = null;
    }
    this.AZd = ((WxRecyclerView)paramBundle.getRecyclerView());
    paramBundle = findViewById(p.e.no_result_tv);
    kotlin.g.b.s.s(paramBundle, "findViewById(R.id.no_result_tv)");
    this.BnA = ((TextView)paramBundle);
    paramBundle = findViewById(p.e.loading_layout);
    kotlin.g.b.s.s(paramBundle, "findViewById(R.id.loading_layout)");
    this.njN = paramBundle;
    paramBundle = findViewById(p.e.retry_layout);
    kotlin.g.b.s.s(paramBundle, "findViewById(R.id.retry_layout)");
    this.BsS = paramBundle;
    localObject1 = this.BsS;
    paramBundle = (Bundle)localObject1;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("retryView");
      paramBundle = null;
    }
    paramBundle.setOnClickListener(new OccupyFinderUI23..ExternalSyntheticLambda0(this));
    paramBundle = com.tencent.mm.plugin.finder.order.ui.d.ESR;
    paramBundle = getContext();
    kotlin.g.b.s.s(paramBundle, "context");
    Context localContext = (Context)paramBundle;
    localObject1 = this.AZd;
    paramBundle = (Bundle)localObject1;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("recyclerView");
      paramBundle = null;
    }
    Object localObject3 = this.BsT;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      kotlin.g.b.s.bIx("feedLoader");
      localObject1 = null;
    }
    com.tencent.mm.plugin.finder.order.ui.d.a(localContext, paramBundle, ((com.tencent.mm.plugin.finder.order.data.c)localObject1).pUj);
    localObject1 = this.ATx;
    paramBundle = (Bundle)localObject1;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("rlLayout");
      paramBundle = null;
    }
    paramBundle.setEnablePullDownHeader(false);
    paramBundle = this.ATx;
    if (paramBundle == null)
    {
      kotlin.g.b.s.bIx("rlLayout");
      paramBundle = null;
      localObject1 = af.mU((Context)getContext()).inflate(p.f.load_more_footer, null);
      kotlin.g.b.s.s(localObject1, "getInflater(context).inf…t.load_more_footer, null)");
      paramBundle.setLoadMoreFooter((View)localObject1);
      paramBundle = this.ATx;
      if (paramBundle != null) {
        break label725;
      }
      kotlin.g.b.s.bIx("rlLayout");
      paramBundle = localObject2;
    }
    label725:
    for (;;)
    {
      paramBundle.setActionCallback((RefreshLoadMoreLayout.b)new a(this));
      paramBundle = k.aeZF;
      ((com.tencent.mm.plugin.finder.order.report.a)k.d((AppCompatActivity)this).q(com.tencent.mm.plugin.finder.order.report.a.class)).w("enter_search", ak.l(new r("current_page", "order_list")));
      AppMethodBeat.o(364337);
      return;
      break;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(364421);
    super.onDestroy();
    com.tencent.mm.plugin.finder.order.search.a locala = this.BsU;
    if (locala != null)
    {
      a.b localb = a.b.ESH;
      a.b.b((com.tencent.mm.plugin.finder.order.search.c)locala);
    }
    AppMethodBeat.o(364421);
  }
  
  public final void onEditTextChange(String paramString1, String paramString2, List<FTSSearchView.c> paramList, FTSEditTextView.d paramd)
  {
    paramList = null;
    AppMethodBeat.i(364370);
    if (paramString1 == null)
    {
      paramString1 = "";
      if (Util.isNullOrNil(paramString1))
      {
        paramd = this.njN;
        paramString2 = paramd;
        if (paramd == null)
        {
          kotlin.g.b.s.bIx("loadingView");
          paramString2 = null;
        }
        paramString2.setVisibility(8);
        paramd = this.BnA;
        paramString2 = paramd;
        if (paramd == null)
        {
          kotlin.g.b.s.bIx("noResultView");
          paramString2 = null;
        }
        paramString2.setVisibility(8);
        paramd = this.ATx;
        paramString2 = paramd;
        if (paramd == null)
        {
          kotlin.g.b.s.bIx("rlLayout");
          paramString2 = null;
        }
        paramString2.setVisibility(8);
        paramString2 = this.BsS;
        if (paramString2 != null) {
          break label184;
        }
        kotlin.g.b.s.bIx("retryView");
        paramString2 = paramList;
      }
    }
    label184:
    for (;;)
    {
      paramString2.setVisibility(8);
      paramString2 = this.BsU;
      if (paramString2 == null) {
        break label195;
      }
      if (Util.isNullOrNil(paramString1)) {
        break label187;
      }
      paramString2.ESD.setVisibility(8);
      AppMethodBeat.o(364370);
      return;
      paramString2 = n.bq((CharSequence)paramString1).toString();
      paramString1 = paramString2;
      if (paramString2 != null) {
        break;
      }
      paramString1 = "";
      break;
    }
    label187:
    paramString2.ESD.setVisibility(0);
    label195:
    AppMethodBeat.o(364370);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI23$initContentView$2", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback2;", "onLoadMoreBegin", "", "loadMoreType", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends RefreshLoadMoreLayout.b
  {
    a(OccupyFinderUI23 paramOccupyFinderUI23) {}
    
    public final void qI(int paramInt)
    {
      RefreshLoadMoreLayout localRefreshLoadMoreLayout2 = null;
      RefreshLoadMoreLayout localRefreshLoadMoreLayout1 = null;
      AppMethodBeat.i(364856);
      Log.i("MicroMsg.UIComponentFragment", "onLoadMoreBegin");
      if (OccupyFinderUI23.b(this.BsW))
      {
        localObject = OccupyFinderUI23.c(this.BsW);
        if (localObject == null)
        {
          kotlin.g.b.s.bIx("feedLoader");
          localObject = null;
          com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new c.b((com.tencent.mm.plugin.finder.order.data.c)localObject));
          localRefreshLoadMoreLayout2 = OccupyFinderUI23.d(this.BsW);
          localObject = localRefreshLoadMoreLayout2;
          if (localRefreshLoadMoreLayout2 == null)
          {
            kotlin.g.b.s.bIx("rlLayout");
            localObject = null;
          }
          localObject = ((RefreshLoadMoreLayout)localObject).getLoadMoreFooter();
          if (localObject != null)
          {
            localObject = (TextView)((View)localObject).findViewById(p.e.load_more_footer_tip_tv);
            if (localObject != null) {
              ((TextView)localObject).setText(p.h.finder_load_more_footer_tip);
            }
          }
          localRefreshLoadMoreLayout2 = OccupyFinderUI23.d(this.BsW);
          localObject = localRefreshLoadMoreLayout2;
          if (localRefreshLoadMoreLayout2 == null)
          {
            kotlin.g.b.s.bIx("rlLayout");
            localObject = null;
          }
          localObject = ((RefreshLoadMoreLayout)localObject).getLoadMoreFooter();
          if (localObject != null) {
            break label213;
          }
          localObject = null;
          label150:
          if (localObject != null) {
            ((TextView)localObject).setVisibility(0);
          }
          localRefreshLoadMoreLayout2 = OccupyFinderUI23.d(this.BsW);
          localObject = localRefreshLoadMoreLayout2;
          if (localRefreshLoadMoreLayout2 == null)
          {
            kotlin.g.b.s.bIx("rlLayout");
            localObject = null;
          }
          localObject = ((RefreshLoadMoreLayout)localObject).getLoadMoreFooter();
          if (localObject != null) {
            break label227;
          }
        }
        label213:
        label227:
        for (localObject = localRefreshLoadMoreLayout1;; localObject = ((View)localObject).findViewById(p.e.load_more_footer_end_layout))
        {
          if (localObject == null) {
            break label374;
          }
          ((View)localObject).setVisibility(8);
          AppMethodBeat.o(364856);
          return;
          break;
          localObject = (TextView)((View)localObject).findViewById(p.e.load_more_footer_tip_tv);
          break label150;
        }
      }
      localRefreshLoadMoreLayout1 = OccupyFinderUI23.d(this.BsW);
      Object localObject = localRefreshLoadMoreLayout1;
      if (localRefreshLoadMoreLayout1 == null)
      {
        kotlin.g.b.s.bIx("rlLayout");
        localObject = null;
      }
      localObject = ((RefreshLoadMoreLayout)localObject).getLoadMoreFooter();
      if (localObject != null)
      {
        localObject = (TextView)((View)localObject).findViewById(p.e.load_more_footer_tip_tv);
        if (localObject != null) {
          ((TextView)localObject).setText(p.h.finder_load_more_no_result_tip);
        }
      }
      localRefreshLoadMoreLayout1 = OccupyFinderUI23.d(this.BsW);
      localObject = localRefreshLoadMoreLayout1;
      if (localRefreshLoadMoreLayout1 == null)
      {
        kotlin.g.b.s.bIx("rlLayout");
        localObject = null;
      }
      localObject = ((RefreshLoadMoreLayout)localObject).getLoadMoreFooter();
      if (localObject == null)
      {
        localObject = null;
        if (localObject != null) {
          ((TextView)localObject).setVisibility(8);
        }
        localRefreshLoadMoreLayout1 = OccupyFinderUI23.d(this.BsW);
        localObject = localRefreshLoadMoreLayout1;
        if (localRefreshLoadMoreLayout1 == null)
        {
          kotlin.g.b.s.bIx("rlLayout");
          localObject = null;
        }
        localObject = ((RefreshLoadMoreLayout)localObject).getLoadMoreFooter();
        if (localObject != null) {
          break label394;
        }
      }
      label394:
      for (localObject = localRefreshLoadMoreLayout2;; localObject = ((View)localObject).findViewById(p.e.load_more_footer_end_layout))
      {
        if (localObject != null) {
          ((View)localObject).setVisibility(0);
        }
        label374:
        AppMethodBeat.o(364856);
        return;
        localObject = (TextView)((View)localObject).findViewById(p.e.load_more_footer_tip_tv);
        break;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "query", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<String, ah>
  {
    b(OccupyFinderUI23 paramOccupyFinderUI23)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI23$initSearchView$2", "Lcom/tencent/mm/plugin/finder/order/search/OnHistoryClearListener;", "onClear", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements com.tencent.mm.plugin.finder.order.search.b
  {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "errType", "", "errCode", "resp", "Lcom/tencent/mm/protocal/protobuf/EcCustomerSearchOrderListResp;", "originSize", "currentSize"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.s<Integer, Integer, alt, Integer, Integer, ah>
  {
    d(OccupyFinderUI23 paramOccupyFinderUI23)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI23
 * JD-Core Version:    0.7.0.1
 */