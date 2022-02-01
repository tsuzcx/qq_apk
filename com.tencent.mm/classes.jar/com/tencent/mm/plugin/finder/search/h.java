package com.tencent.mm.plugin.finder.search;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.RecyclerView.s;
import androidx.recyclerview.widget.RecyclerView.v;
import androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.convert.cg;
import com.tencent.mm.plugin.finder.convert.ch;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.live.report.q.w;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.view.manager.FinderStaggeredGridLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.plugin.findersdk.a.ce;
import com.tencent.mm.plugin.findersdk.a.cj;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.buy;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.af;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.b;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback;", "Lcom/tencent/mm/plugin/finder/search/FinderMixSearchUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/search/FinderMixSearchUIContract$Presenter;", "searchScene", "", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/search/FinderMixSearchUIContract$Presenter;I)V", "TAG", "", "loadingView", "Landroid/view/View;", "noResultView", "Landroid/widget/TextView;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "dismissSearchResult", "", "getActivity", "getItemSpace", "getPresenter", "getShowContactListSize", "contactListSize", "feedListSize", "isFinderLiveSearch", "", "isShowing", "notifyItemChanged", "position", "onSearchCallback", "originContactListSize", "originFeedListSize", "onStartSearch", "onTextChange", "query", "showSearchResult", "Companion", "MixSearchProfileAdapter", "SpacesItemDecoration", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  implements g.b
{
  public static final a Fxo;
  private static final int Fxq;
  private static final int Fxr;
  private static final int Fxs;
  private static final int Fxt;
  private static final int Fxu;
  private static final int Fxv;
  private static final int Fxw;
  private static final int Fxx;
  private static final int Fxy;
  private RefreshLoadMoreLayout ATx;
  TextView BnA;
  private g.a Fxp;
  private final String TAG;
  private MMActivity lzt;
  RecyclerView mkw;
  View njN;
  private int syO;
  
  static
  {
    AppMethodBeat.i(342840);
    Fxo = new a((byte)0);
    Fxq = 1;
    Fxr = 2;
    Fxs = 3;
    Fxt = 4;
    Fxu = 5;
    Fxv = 6;
    Fxw = 7;
    Fxx = 8;
    Fxy = 9;
    AppMethodBeat.o(342840);
  }
  
  public h(MMActivity paramMMActivity, final g.a parama, int paramInt)
  {
    AppMethodBeat.i(342749);
    this.TAG = "Finder.FinderMixSearchViewCallback";
    this.lzt = paramMMActivity;
    this.Fxp = parama;
    this.syO = paramInt;
    Object localObject1 = paramMMActivity.findViewById(e.e.rl_layout);
    s.s(localObject1, "context.findViewById(R.id.rl_layout)");
    this.ATx = ((RefreshLoadMoreLayout)localObject1);
    localObject1 = paramMMActivity.findViewById(e.e.no_result_tv);
    s.s(localObject1, "context.findViewById(R.id.no_result_tv)");
    this.BnA = ((TextView)localObject1);
    localObject1 = paramMMActivity.findViewById(e.e.loading_layout);
    s.s(localObject1, "context.findViewById(R.id.loading_layout)");
    this.njN = ((View)localObject1);
    this.mkw = this.ATx.getRecyclerView();
    if (dXY())
    {
      localObject1 = paramMMActivity.findViewById(e.e.main_rv);
      if (localObject1 == null)
      {
        paramMMActivity = new NullPointerException("null cannot be cast to non-null type android.view.View");
        AppMethodBeat.o(342749);
        throw paramMMActivity;
      }
      this.ATx.setBackgroundColor(paramMMActivity.getResources().getColor(e.b.Dark_0));
      ((View)localObject1).setBackgroundColor(paramMMActivity.getResources().getColor(e.b.Dark_0));
    }
    localObject1 = new FinderStaggeredGridLayoutManager(2, 1);
    this.mkw.setLayoutManager((RecyclerView.LayoutManager)localObject1);
    localObject1 = new b(dXY());
    this.mkw.setAdapter((RecyclerView.a)localObject1);
    Object localObject2;
    if (dXY())
    {
      localObject1 = this.lzt.getResources();
      s.checkNotNull(localObject1);
      paramInt = (int)((Resources)localObject1).getDimension(e.c.Edge_1_5_A);
      localObject1 = new c(paramInt);
      this.mkw.a((RecyclerView.h)localObject1);
      this.ATx.setEnablePullDownHeader(false);
      localObject1 = this.ATx;
      localObject2 = af.mU((Context)paramMMActivity);
      if (!dXY()) {
        break label486;
      }
    }
    label486:
    for (paramInt = e.f.load_more_footer_night_mode;; paramInt = e.f.load_more_footer)
    {
      localObject2 = ((LayoutInflater)localObject2).inflate(paramInt, null);
      s.s(localObject2, "getInflater(context).inf…oter\n            }, null)");
      ((RefreshLoadMoreLayout)localObject1).setLoadMoreFooter((View)localObject2);
      this.ATx.setActionCallback((RefreshLoadMoreLayout.b)new RefreshLoadMoreLayout.b()
      {
        public final void qI(int paramAnonymousInt)
        {
          Object localObject2 = null;
          AppMethodBeat.i(342308);
          h.a(this.Fxz);
          com.tencent.e.f.h.jXD();
          if (parama.eOK())
          {
            localObject1 = h.b(this.Fxz).getLoadMoreFooter();
            if (localObject1 != null) {
              ((View)localObject1).setVisibility(0);
            }
            localObject1 = h.b(this.Fxz).getLoadMoreFooter();
            if (localObject1 != null)
            {
              localObject1 = (TextView)((View)localObject1).findViewById(e.e.load_more_footer_tip_tv);
              if (localObject1 != null) {
                ((TextView)localObject1).setText(e.h.finder_load_more_footer_tip);
              }
            }
            localObject1 = h.b(this.Fxz).getLoadMoreFooter();
            if (localObject1 == null)
            {
              localObject1 = null;
              if (localObject1 != null) {
                ((TextView)localObject1).setVisibility(0);
              }
              localObject1 = h.b(this.Fxz).getLoadMoreFooter();
              if (localObject1 != null) {
                break label160;
              }
            }
            label160:
            for (localObject1 = localObject2;; localObject1 = ((View)localObject1).findViewById(e.e.load_more_footer_end_layout))
            {
              if (localObject1 == null) {
                break label281;
              }
              ((View)localObject1).setVisibility(8);
              AppMethodBeat.o(342308);
              return;
              localObject1 = (TextView)((View)localObject1).findViewById(e.e.load_more_footer_tip_tv);
              break;
            }
          }
          Object localObject1 = h.b(this.Fxz).getLoadMoreFooter();
          if (localObject1 != null) {
            ((View)localObject1).setVisibility(0);
          }
          localObject1 = h.b(this.Fxz).getLoadMoreFooter();
          if (localObject1 != null)
          {
            localObject1 = (TextView)((View)localObject1).findViewById(e.e.load_more_footer_tip_tv);
            if (localObject1 != null) {
              ((TextView)localObject1).setText(e.h.finder_load_more_no_result_tip);
            }
          }
          localObject1 = h.b(this.Fxz).getLoadMoreFooter();
          if (localObject1 == null)
          {
            localObject1 = null;
            if (localObject1 != null) {
              ((TextView)localObject1).setVisibility(8);
            }
            localObject1 = h.b(this.Fxz).getLoadMoreFooter();
            if (localObject1 != null) {
              break label301;
            }
          }
          label281:
          label301:
          for (localObject1 = null;; localObject1 = ((View)localObject1).findViewById(e.e.load_more_footer_end_layout))
          {
            if (localObject1 != null) {
              ((View)localObject1).setVisibility(0);
            }
            AppMethodBeat.o(342308);
            return;
            localObject1 = (TextView)((View)localObject1).findViewById(e.e.load_more_footer_tip_tv);
            break;
          }
        }
      });
      parama = as.GSQ;
      paramMMActivity = as.a.hu((Context)paramMMActivity);
      if (paramMMActivity != null)
      {
        paramMMActivity = as.b(paramMMActivity);
        if (paramMMActivity != null) {
          paramMMActivity.o(this.mkw);
        }
      }
      paramMMActivity = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.eWk().bmg()).intValue() == 1) {
        this.mkw.a((RecyclerView.l)new com.tencent.mm.plugin.finder.feed.component.h(this.TAG, this.ATx));
      }
      AppMethodBeat.o(342749);
      return;
      localObject1 = this.lzt.getResources();
      s.checkNotNull(localObject1);
      paramInt = (int)((Resources)localObject1).getDimension(e.c.Edge_0_5_A);
      break;
    }
  }
  
  private final boolean dXY()
  {
    return this.syO == 13;
  }
  
  private static int ij(int paramInt1, int paramInt2)
  {
    if ((paramInt1 > 3) && (paramInt2 > 0)) {
      return 4;
    }
    if (paramInt1 > 0) {
      return paramInt1 + 1;
    }
    return 0;
  }
  
  public final void eOL()
  {
    AppMethodBeat.i(166841);
    this.mkw.setVisibility(8);
    this.BnA.setVisibility(8);
    this.njN.setVisibility(0);
    Object localObject = this.ATx.getLoadMoreFooter();
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = this.mkw;
    com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback", "onStartSearch", "()V", "Undefined", "scrollToPosition", "(I)V");
    ((RecyclerView)localObject).scrollToPosition(((Integer)locala.sb(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback", "onStartSearch", "()V", "Undefined", "scrollToPosition", "(I)V");
    AppMethodBeat.o(166841);
  }
  
  public final void eOM()
  {
    AppMethodBeat.i(342841);
    this.ATx.setVisibility(0);
    AppMethodBeat.o(342841);
  }
  
  public final void fV(int paramInt)
  {
    AppMethodBeat.i(342844);
    RecyclerView.a locala = this.mkw.getAdapter();
    if (locala != null) {
      locala.fV(paramInt);
    }
    AppMethodBeat.o(342844);
  }
  
  public final void ii(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(166840);
    int k = this.Fxp.eOH().size();
    int j = this.Fxp.dWd().size();
    eOM();
    int i;
    label95:
    RecyclerView.a locala;
    if (!Util.isNullOrNil(this.Fxp.eOI()))
    {
      i = 1;
      if ((k <= 0) && (j <= 0)) {
        break label145;
      }
      this.BnA.setVisibility(8);
      this.njN.setVisibility(8);
      this.mkw.setVisibility(0);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label206;
      }
      locala = this.mkw.getAdapter();
      if (locala != null) {
        locala.bZE.notifyChanged();
      }
    }
    for (;;)
    {
      this.ATx.aFW(0);
      AppMethodBeat.o(166840);
      return;
      i = 0;
      break;
      label145:
      if (i != 0)
      {
        this.BnA.setVisibility(0);
        this.njN.setVisibility(8);
        this.mkw.setVisibility(0);
        break label95;
      }
      this.BnA.setVisibility(0);
      this.njN.setVisibility(8);
      this.mkw.setVisibility(8);
      break label95;
      label206:
      paramInt1 = ij(paramInt1, paramInt2);
      i = ij(k, j);
      locala = this.mkw.getAdapter();
      if (locala != null) {
        locala.bA(paramInt1 + paramInt2, i + j);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$Companion;", "", "()V", "VT_CONTACT_HEADER", "", "getVT_CONTACT_HEADER", "()I", "VT_CONTACT_HEADER_LIVE", "getVT_CONTACT_HEADER_LIVE", "VT_CONTACT_ITEM", "getVT_CONTACT_ITEM", "VT_FEDD_PLAIN_TEXT", "getVT_FEDD_PLAIN_TEXT", "VT_FEED_HEADER", "getVT_FEED_HEADER", "VT_FEED_LIVE_HEADER", "getVT_FEED_LIVE_HEADER", "VT_FEED_MEDIA", "getVT_FEED_MEDIA", "VT_FEED_MEDIA_LIVE", "getVT_FEED_MEDIA_LIVE", "VT_SAFETY_HINT", "getVT_SAFETY_HINT", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$MixSearchProfileAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mm/plugin/findersdk/api/IMixSearchProfileAdapter;", "isFinderLiveSearch", "", "(Lcom/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback;Z)V", "()Z", "bindData", "", "holder", "position", "", "viewType", "bindImage", "getContactList", "", "Lcom/tencent/mm/protocal/protobuf/FinderSearchInfo;", "getData", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getFeedPosition", "getItemCount", "getItemIndexPosition", "adapterPosition", "getItemViewType", "getSafetyHint", "", "needShowContactMore", "onBindViewHolder", "payloads", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "onViewAttachedToWindow", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    extends RecyclerView.a<RecyclerView.v>
    implements cj
  {
    private final boolean FxB;
    
    public b()
    {
      AppMethodBeat.i(342496);
      boolean bool;
      this.FxB = bool;
      AppMethodBeat.o(342496);
    }
    
    private final int Te(int paramInt)
    {
      AppMethodBeat.i(342507);
      if (!Util.isNullOrNil(h.c(h.this).eOI())) {}
      for (int i = 1; (i != 0) && (paramInt == 0); i = 0)
      {
        AppMethodBeat.o(342507);
        return 0;
      }
      if (i != 0)
      {
        AppMethodBeat.o(342507);
        return paramInt - 1;
      }
      AppMethodBeat.o(342507);
      return paramInt;
    }
    
    private static final void a(int paramInt, h paramh, View paramView)
    {
      AppMethodBeat.i(342535);
      Object localObject1 = new Object();
      Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject2).sc(paramInt);
      ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramh);
      ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$MixSearchProfileAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
      s.u(paramh, "this$0");
      paramView = paramView.getTag();
      if (paramView == null)
      {
        paramh = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSearchInfo");
        AppMethodBeat.o(342535);
        throw paramh;
      }
      localObject2 = (buy)paramView;
      paramView = ((buy)localObject2).contact;
      int i;
      ce localce;
      if ((paramView != null) && (paramView.liveStatus == 1))
      {
        i = 1;
        if (i != 0)
        {
          localce = (ce)com.tencent.mm.kernel.h.ax(ce.class);
          paramView = ((buy)localObject2).contact;
          if (paramView != null) {
            break label203;
          }
          paramView = "";
        }
      }
      for (;;)
      {
        localce.a(null, paramView, paramInt, q.w.DwR, "23");
        h.c(paramh).a((buy)localObject2, paramInt - 1);
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$MixSearchProfileAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(342535);
        return;
        i = 0;
        break;
        label203:
        localObject1 = paramView.username;
        paramView = (View)localObject1;
        if (localObject1 == null) {
          paramView = "";
        }
      }
    }
    
    private final void a(RecyclerView.v paramv, final int paramInt1, int paramInt2)
    {
      int j = 1;
      AppMethodBeat.i(342521);
      Object localObject1 = h.Fxo;
      int i;
      if (paramInt2 == h.eON())
      {
        i = 1;
        if (i == 0) {
          break label217;
        }
        paramv = (c)paramv;
        if (h.c(h.this).eOH().size() <= 3) {
          break label183;
        }
        if (((Collection)h.c(h.this).dWd()).isEmpty()) {
          break label178;
        }
        paramInt1 = 1;
        label79:
        if (paramInt1 == 0) {
          break label183;
        }
        paramInt1 = 1;
        label85:
        localObject1 = new h.b..ExternalSyntheticLambda1(h.this);
        s.u(localObject1, "moreClickListener");
        if (paramInt1 == 0) {
          break label188;
        }
        paramv.FwJ.setVisibility(0);
        paramv.FwK.setVisibility(0);
        paramv.caK.setOnClickListener((View.OnClickListener)localObject1);
      }
      for (;;)
      {
        paramv.descTv.setText((CharSequence)paramv.FwI);
        AppMethodBeat.o(342521);
        return;
        localObject1 = h.Fxo;
        if (paramInt2 == h.eOT())
        {
          i = 1;
          break;
        }
        i = 0;
        break;
        label178:
        paramInt1 = 0;
        break label79;
        label183:
        paramInt1 = 0;
        break label85;
        label188:
        paramv.FwJ.setVisibility(8);
        paramv.FwK.setVisibility(8);
        paramv.caK.setOnClickListener(null);
      }
      label217:
      localObject1 = h.Fxo;
      Object localObject3;
      Object localObject2;
      if (paramInt2 == h.eOO())
      {
        localObject3 = (buy)h.c(h.this).eOH().get(paramInt1 - 1);
        g.a locala = h.c(h.this);
        localObject1 = ((buy)localObject3).contact;
        if (localObject1 == null) {
          localObject1 = "";
        }
        for (;;)
        {
          locala.am((String)localObject1, paramInt1 - 1, 1);
          d.a((d)paramv, (buy)localObject3, new h.b..ExternalSyntheticLambda0(paramInt1, h.this), false, 12);
          AppMethodBeat.o(342521);
          return;
          localObject2 = ((FinderContact)localObject1).username;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
        }
      }
      localObject1 = h.Fxo;
      if (paramInt2 == h.eOP())
      {
        i = 1;
        if (i == 0) {
          break label450;
        }
        paramv = (e)paramv;
        if (paramInt1 == 0) {
          break label433;
        }
        paramInt1 = j;
        label377:
        if (paramInt1 == 0) {
          break label438;
        }
        paramv.pKl.setVisibility(0);
      }
      for (;;)
      {
        paramv.descTv.setText((CharSequence)paramv.FwI);
        AppMethodBeat.o(342521);
        return;
        localObject1 = h.Fxo;
        if (paramInt2 == h.eOR())
        {
          i = 1;
          break;
        }
        i = 0;
        break;
        label433:
        paramInt1 = 0;
        break label377;
        label438:
        paramv.pKl.setVisibility(8);
      }
      label450:
      localObject1 = h.Fxo;
      if (paramInt2 == h.eOU())
      {
        paramv = (f)paramv;
        localObject1 = eOI();
        s.u(localObject1, "safetyHint");
        paramv.Fxh.setText((CharSequence)localObject1);
        AppMethodBeat.o(342521);
        return;
      }
      localObject1 = h.Fxo;
      if (paramInt2 == h.eOQ())
      {
        localObject1 = (BaseFinderFeed)h.c(h.this).dWd().get(paramInt1 - h.d(h.this) - 1);
        h.c(h.this).s(((BaseFinderFeed)localObject1).bZA(), paramInt1 - h.d(h.this) - 1, 2);
        localObject2 = (ch)paramv;
        ((ch)paramv).KI();
        ((ch)localObject2).a((BaseFinderFeed)localObject1, true, (kotlin.g.a.b)new a((BaseFinderFeed)localObject1, paramInt1, h.this));
        AppMethodBeat.o(342521);
        return;
      }
      localObject1 = h.Fxo;
      if (paramInt2 == h.eOS())
      {
        localObject2 = (BaseFinderFeed)h.c(h.this).dWd().get(paramInt1 - h.d(h.this) - 1);
        h.c(h.this).s(((BaseFinderFeed)localObject2).bZA(), paramInt1 - h.d(h.this) - 1, 3);
        localObject3 = (cg)paramv;
        localObject1 = h.c(h.this).getQuery();
        if (localObject1 != null) {
          break label761;
        }
        localObject1 = "";
      }
      label761:
      for (;;)
      {
        ((cg)paramv).KI();
        ((cg)localObject3).a((String)localObject1, (BaseFinderFeed)localObject2, (kotlin.g.a.b)new b(h.this, (BaseFinderFeed)localObject2, paramInt1));
        AppMethodBeat.o(342521);
        return;
      }
    }
    
    private static final void a(h paramh, View paramView)
    {
      AppMethodBeat.i(342523);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramh);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$MixSearchProfileAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(paramh, "this$0");
      h.c(paramh).eOJ();
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$MixSearchProfileAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(342523);
    }
    
    private String eOI()
    {
      AppMethodBeat.i(342503);
      String str = h.c(h.this).eOI();
      AppMethodBeat.o(342503);
      return str;
    }
    
    public final int Td(int paramInt)
    {
      AppMethodBeat.i(342568);
      int i = h.d(h.this);
      if (paramInt < i)
      {
        AppMethodBeat.o(342568);
        return -1;
      }
      if (paramInt == i)
      {
        AppMethodBeat.o(342568);
        return -1;
      }
      AppMethodBeat.o(342568);
      return paramInt - i - 1;
    }
    
    public final void a(RecyclerView.v paramv, int paramInt, List<Object> paramList)
    {
      AppMethodBeat.i(342609);
      s.u(paramv, "holder");
      s.u(paramList, "payloads");
      h.a(h.this);
      s.X("onBindViewHolder position:", Integer.valueOf(paramInt));
      com.tencent.e.f.h.jXD();
      a(paramv, Te(paramInt), getItemViewType(paramInt));
      AppMethodBeat.o(342609);
    }
    
    public final RecyclerView.v b(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(342602);
      s.u(paramViewGroup, "parent");
      h.a(h.this);
      s.X("onCreateViewHolder viewType: ", Integer.valueOf(paramInt));
      com.tencent.e.f.h.jXD();
      Object localObject = h.Fxo;
      if (paramInt == h.eON())
      {
        localObject = h.f(h.this);
        s.checkNotNull(localObject);
        localObject = ((MMActivity)localObject).getLayoutInflater();
        if (this.FxB) {}
        for (paramInt = e.f.finder_mix_search_contact_header_night_mode;; paramInt = e.f.finder_mix_search_contact_header)
        {
          localObject = ((LayoutInflater)localObject).inflate(paramInt, paramViewGroup, false);
          s.s(localObject, "headerLayout");
          paramViewGroup = paramViewGroup.getResources().getString(e.h.finder_search_contact_title);
          s.s(paramViewGroup, "parent.resources.getStri…der_search_contact_title)");
          paramViewGroup = (RecyclerView.v)new c((View)localObject, paramViewGroup);
          AppMethodBeat.o(342602);
          return paramViewGroup;
        }
      }
      localObject = h.Fxo;
      if (paramInt == h.eOT())
      {
        localObject = h.f(h.this);
        s.checkNotNull(localObject);
        localObject = ((MMActivity)localObject).getLayoutInflater();
        if (this.FxB) {}
        for (paramInt = e.f.finder_mix_search_contact_header_night_mode;; paramInt = e.f.finder_mix_search_contact_header)
        {
          localObject = ((LayoutInflater)localObject).inflate(paramInt, paramViewGroup, false);
          s.s(localObject, "headerLayout");
          paramViewGroup = paramViewGroup.getResources().getString(e.h.finder_search_live_contact_title);
          s.s(paramViewGroup, "parent.resources.getStri…earch_live_contact_title)");
          paramViewGroup = (RecyclerView.v)new c((View)localObject, paramViewGroup);
          AppMethodBeat.o(342602);
          return paramViewGroup;
        }
      }
      localObject = h.Fxo;
      if (paramInt == h.eOO())
      {
        localObject = h.f(h.this);
        s.checkNotNull(localObject);
        localObject = ((MMActivity)localObject).getLayoutInflater();
        if (this.FxB) {}
        for (paramInt = e.f.finder_contact_search_item_night_mode;; paramInt = e.f.finder_contact_search_item)
        {
          paramViewGroup = ((LayoutInflater)localObject).inflate(paramInt, paramViewGroup, false);
          s.s(paramViewGroup, "contactLayout");
          paramViewGroup = (RecyclerView.v)new d(paramViewGroup);
          AppMethodBeat.o(342602);
          return paramViewGroup;
        }
      }
      localObject = h.Fxo;
      if (paramInt == h.eOP())
      {
        localObject = LayoutInflater.from(paramViewGroup.getContext()).inflate(e.f.finder_feed_search_header_item, paramViewGroup, false);
        s.s(localObject, "convertView");
        paramViewGroup = paramViewGroup.getResources().getString(e.h.finder_search_feed_header);
        s.s(paramViewGroup, "parent.resources.getStri…inder_search_feed_header)");
        paramViewGroup = (RecyclerView.v)new e((View)localObject, paramViewGroup);
        AppMethodBeat.o(342602);
        return paramViewGroup;
      }
      localObject = h.Fxo;
      if (paramInt == h.eOU())
      {
        paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(e.f.finder_feed_search_safety_hint, paramViewGroup, false);
        s.s(paramViewGroup, "convertView");
        paramViewGroup = (RecyclerView.v)new f(paramViewGroup);
        AppMethodBeat.o(342602);
        return paramViewGroup;
      }
      localObject = h.Fxo;
      if (paramInt == h.eOR())
      {
        localObject = LayoutInflater.from(paramViewGroup.getContext());
        if (this.FxB) {}
        for (paramInt = e.f.finder_feed_search_header_item_night;; paramInt = e.f.finder_feed_search_header_item)
        {
          localObject = ((LayoutInflater)localObject).inflate(paramInt, paramViewGroup, false);
          s.s(localObject, "convertView");
          paramViewGroup = paramViewGroup.getResources().getString(e.h.finder_search_feed_live_header);
          s.s(paramViewGroup, "parent.resources.getStri…_search_feed_live_header)");
          paramViewGroup = (RecyclerView.v)new e((View)localObject, paramViewGroup);
          AppMethodBeat.o(342602);
          return paramViewGroup;
        }
      }
      localObject = h.Fxo;
      if (paramInt == h.eOS())
      {
        localObject = LayoutInflater.from(paramViewGroup.getContext());
        if (this.FxB) {}
        for (paramInt = e.f.nearby_feed_live_friends_item_night_mode;; paramInt = e.f.nearby_feed_live_friends_item)
        {
          paramViewGroup = ((LayoutInflater)localObject).inflate(paramInt, paramViewGroup, false);
          s.s(paramViewGroup, "convertView");
          paramViewGroup = (RecyclerView.v)new cg(paramViewGroup, h.g(h.this));
          AppMethodBeat.o(342602);
          return paramViewGroup;
        }
      }
      paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(e.f.finder_mix_search_media_item, paramViewGroup, false);
      s.s(paramViewGroup, "convertView");
      paramViewGroup = (RecyclerView.v)new ch(paramViewGroup);
      AppMethodBeat.o(342602);
      return paramViewGroup;
    }
    
    public final void d(RecyclerView.v paramv, int paramInt)
    {
      AppMethodBeat.i(342616);
      s.u(paramv, "holder");
      a(paramv, Te(paramInt), getItemViewType(paramInt));
      AppMethodBeat.o(342616);
    }
    
    public final List<buy> eOH()
    {
      AppMethodBeat.i(342562);
      List localList = h.c(h.this).eOH();
      AppMethodBeat.o(342562);
      return localList;
    }
    
    public final List<BaseFinderFeed> getData()
    {
      AppMethodBeat.i(342556);
      List localList = h.c(h.this).dWd();
      AppMethodBeat.o(342556);
      return localList;
    }
    
    public final int getItemCount()
    {
      int j = 1;
      AppMethodBeat.i(166832);
      int i;
      if (Util.isNullOrNil(eOI()))
      {
        i = 0;
        if (((Collection)h.c(h.this).dWd()).isEmpty()) {
          break label92;
        }
      }
      for (;;)
      {
        if (j == 0) {
          break label97;
        }
        j = h.d(h.this);
        int k = h.c(h.this).dWd().size();
        AppMethodBeat.o(166832);
        return j + k + 1 + i;
        i = 1;
        break;
        label92:
        j = 0;
      }
      label97:
      j = h.d(h.this);
      AppMethodBeat.o(166832);
      return j + i;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(166833);
      Object localObject = h.c(h.this);
      s.checkNotNull(localObject);
      ((g.a)localObject).dWd();
      int j = h.d(h.this);
      if (!Util.isNullOrNil(h.c(h.this).eOI())) {}
      int k;
      for (int i = 1;; i = 0)
      {
        k = Te(paramInt);
        h.a(h.this);
        new StringBuilder("getItemViewType adapterPosition: ").append(paramInt).append("  position:").append(k);
        com.tencent.e.f.h.jXD();
        if ((paramInt != 0) || (i == 0)) {
          break;
        }
        localObject = h.Fxo;
        paramInt = h.eOU();
        AppMethodBeat.o(166833);
        return paramInt;
      }
      if (k < j)
      {
        if (k == 0)
        {
          if (h.e(h.this))
          {
            localObject = h.Fxo;
            paramInt = h.eOT();
            AppMethodBeat.o(166833);
            return paramInt;
          }
          localObject = h.Fxo;
          paramInt = h.eON();
          AppMethodBeat.o(166833);
          return paramInt;
        }
        localObject = h.Fxo;
        paramInt = h.eOO();
        AppMethodBeat.o(166833);
        return paramInt;
      }
      if (k == j)
      {
        if (h.e(h.this))
        {
          localObject = h.Fxo;
          paramInt = h.eOR();
          AppMethodBeat.o(166833);
          return paramInt;
        }
        localObject = h.Fxo;
        paramInt = h.eOP();
        AppMethodBeat.o(166833);
        return paramInt;
      }
      if (h.e(h.this))
      {
        localObject = h.Fxo;
        paramInt = h.eOS();
        AppMethodBeat.o(166833);
        return paramInt;
      }
      localObject = h.Fxo;
      paramInt = h.eOQ();
      AppMethodBeat.o(166833);
      return paramInt;
    }
    
    public final void o(RecyclerView.v paramv)
    {
      AppMethodBeat.i(342593);
      s.u(paramv, "holder");
      super.o(paramv);
      Object localObject = paramv.caK.getLayoutParams();
      if ((localObject != null) && ((localObject instanceof StaggeredGridLayoutManager.LayoutParams)))
      {
        localObject = (StaggeredGridLayoutManager.LayoutParams)localObject;
        int i = paramv.caO;
        h.a locala = h.Fxo;
        if (i != h.eON())
        {
          i = paramv.caO;
          locala = h.Fxo;
          if (i != h.eOT())
          {
            i = paramv.caO;
            locala = h.Fxo;
            if (i != h.eOO())
            {
              i = paramv.caO;
              locala = h.Fxo;
              if (i != h.eOP())
              {
                i = paramv.caO;
                locala = h.Fxo;
                if (i != h.eOR())
                {
                  i = paramv.caO;
                  paramv = h.Fxo;
                  if (i != h.eOU()) {
                    break label163;
                  }
                }
              }
            }
          }
        }
      }
      label163:
      for (boolean bool = true;; bool = false)
      {
        ((StaggeredGridLayoutManager.LayoutParams)localObject).cbB = bool;
        AppMethodBeat.o(342593);
        return;
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.b<Integer, ah>
    {
      a(BaseFinderFeed paramBaseFinderFeed, int paramInt, h paramh)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends u
      implements kotlin.g.a.b<Integer, ah>
    {
      b(h paramh, BaseFinderFeed paramBaseFinderFeed, int paramInt)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$SpacesItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "space", "", "(Lcom/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback;I)V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "setFeedDecoration", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class c
    extends RecyclerView.h
  {
    private final int space;
    
    public c()
    {
      AppMethodBeat.i(342485);
      int i;
      this.space = i;
      AppMethodBeat.o(342485);
    }
    
    private final void a(Rect paramRect, RecyclerView.v paramv)
    {
      AppMethodBeat.i(342491);
      int i = (int)(this.space / 2.0F);
      paramRect.top = this.space;
      paramv = paramv.caK.getLayoutParams();
      if ((paramv != null) && ((paramv instanceof StaggeredGridLayoutManager.LayoutParams)))
      {
        if (((StaggeredGridLayoutManager.LayoutParams)paramv).Lh() == 0)
        {
          paramRect.left = this.space;
          paramRect.right = i;
          AppMethodBeat.o(342491);
          return;
        }
        paramRect.left = i;
        paramRect.right = this.space;
        AppMethodBeat.o(342491);
        return;
      }
      paramRect.left = this.space;
      paramRect.right = this.space;
      AppMethodBeat.o(342491);
    }
    
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(342501);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRect);
      localb.cH(paramView);
      localb.cH(paramRecyclerView);
      localb.cH(params);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$SpacesItemDecoration", "com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$SpacesItemDecorationandroidx/recyclerview/widget/RecyclerView$ItemDecoration", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V", this, localb.aYj());
      s.u(paramRect, "outRect");
      s.u(paramView, "view");
      s.u(paramRecyclerView, "parent");
      s.u(params, "state");
      int i = RecyclerView.bA(paramView);
      paramView = paramRecyclerView.bj(paramView);
      paramRecyclerView = h.this.mkw.getAdapter();
      s.checkNotNull(paramRecyclerView);
      if (i != paramRecyclerView.getItemCount() - 1)
      {
        paramRecyclerView = h.this.mkw.getAdapter();
        s.checkNotNull(paramRecyclerView);
        if (i != paramRecyclerView.getItemCount() - 2) {}
      }
      else
      {
        paramRect.bottom = (this.space * 2);
        if (h.d(h.this) != 0) {
          break label231;
        }
        if (i != 0) {
          break label216;
        }
        paramRect.right = 0;
        paramRect.top = 0;
        paramRect.left = 0;
        paramRect.bottom = 0;
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$SpacesItemDecoration", "com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$SpacesItemDecorationandroidx/recyclerview/widget/RecyclerView$ItemDecoration", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V");
        AppMethodBeat.o(342501);
        return;
        paramRect.bottom = 0;
        break;
        label216:
        s.s(paramView, "holder");
        a(paramRect, paramView);
        continue;
        label231:
        if (i <= h.d(h.this))
        {
          paramRect.right = 0;
          paramRect.top = 0;
          paramRect.left = 0;
          paramRect.bottom = 0;
        }
        else
        {
          s.s(paramView, "holder");
          a(paramRect, paramView);
          if (i <= h.d(h.this) + 2) {
            paramRect.top = 0;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.search.h
 * JD-Core Version:    0.7.0.1
 */