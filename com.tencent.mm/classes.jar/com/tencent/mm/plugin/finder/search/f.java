package com.tencent.mm.plugin.finder.search;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.s;
import android.support.v7.widget.RecyclerView.v;
import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.e.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.convert.cb;
import com.tencent.mm.plugin.finder.convert.cb.a;
import com.tencent.mm.plugin.finder.convert.cb.b;
import com.tencent.mm.plugin.finder.convert.cb.c;
import com.tencent.mm.plugin.finder.loader.m.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.report.live.s.p;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.g;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.view.FinderLiveOnliveWidget;
import com.tencent.mm.plugin.finder.view.FinderPostProgressView;
import com.tencent.mm.plugin.finder.view.manager.FinderStaggeredGridLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.plugin.sns.ui.view.ImageIndicatorView;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.azu;
import com.tencent.mm.protocal.protobuf.bbz;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.protocal.protobuf.cjm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.z.f;
import kotlin.t;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback;", "Lcom/tencent/mm/plugin/finder/search/FinderMixSearchUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/search/FinderMixSearchUIContract$Presenter;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/search/FinderMixSearchUIContract$Presenter;)V", "TAG", "", "loadingView", "Landroid/view/View;", "noResultView", "Landroid/widget/TextView;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "setRecyclerView", "(Landroid/support/v7/widget/RecyclerView;)V", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "dismissSearchResult", "", "getActivity", "getItemSpace", "", "getPresenter", "getShowContactListSize", "contactListSize", "feedListSize", "isShowing", "", "notifyItemChanged", "position", "onSearchCallback", "originContactListSize", "originFeedListSize", "onStartSearch", "onTextChange", "query", "showSearchResult", "Companion", "MixSearchProfileAdapter", "SpacesItemDecoration", "plugin-finder_release"})
public final class f
  implements e.b
{
  public static final a vuD;
  private final String TAG;
  private MMActivity gte;
  View hSw;
  RecyclerView hak;
  private RefreshLoadMoreLayout tLS;
  TextView vtJ;
  private e.a vuC;
  
  static
  {
    AppMethodBeat.i(251337);
    vuD = new a((byte)0);
    AppMethodBeat.o(251337);
  }
  
  public f(MMActivity paramMMActivity, final e.a parama)
  {
    AppMethodBeat.i(166842);
    this.TAG = "Finder.FinderMixSearchViewCallback";
    this.gte = paramMMActivity;
    this.vuC = parama;
    Object localObject = paramMMActivity.findViewById(2131307118);
    kotlin.g.b.p.g(localObject, "context.findViewById(R.id.rl_layout)");
    this.tLS = ((RefreshLoadMoreLayout)localObject);
    localObject = paramMMActivity.findViewById(2131305461);
    kotlin.g.b.p.g(localObject, "context.findViewById(R.id.no_result_tv)");
    this.vtJ = ((TextView)localObject);
    localObject = paramMMActivity.findViewById(2131303706);
    kotlin.g.b.p.g(localObject, "context.findViewById(R.id.loading_layout)");
    this.hSw = ((View)localObject);
    this.hak = this.tLS.getRecyclerView();
    localObject = new FinderStaggeredGridLayoutManager(2);
    this.hak.setLayoutManager((RecyclerView.LayoutManager)localObject);
    localObject = new b();
    this.hak.setAdapter((RecyclerView.a)localObject);
    localObject = this.gte.getResources();
    if (localObject == null) {
      kotlin.g.b.p.hyc();
    }
    localObject = new c((int)((Resources)localObject).getDimension(2131165277));
    this.hak.b((RecyclerView.h)localObject);
    this.tLS.setEnablePullDownHeader(false);
    localObject = this.tLS;
    View localView = aa.jQ((Context)paramMMActivity).inflate(2131495297, null);
    kotlin.g.b.p.g(localView, "MMLayoutInflater.getInfl…t.load_more_footer, null)");
    ((RefreshLoadMoreLayout)localObject).setLoadMoreFooter(localView);
    this.tLS.setActionCallback((RefreshLoadMoreLayout.a)new RefreshLoadMoreLayout.a()
    {
      public final void ED(int paramAnonymousInt)
      {
        AppMethodBeat.i(251326);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.pH(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.axR());
        super.ED(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
        AppMethodBeat.o(251326);
      }
      
      public final void a(RefreshLoadMoreLayout.c paramAnonymousc)
      {
        AppMethodBeat.i(251328);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousc);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.axR());
        super.a(paramAnonymousc);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
        AppMethodBeat.o(251328);
      }
      
      public final void cxo()
      {
        AppMethodBeat.i(166828);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
        f.d(this.vuE);
        h.hkS();
        Object localObject;
        if (parama.dpC())
        {
          localObject = f.e(this.vuE).getLoadMoreFooter();
          if (localObject != null)
          {
            localObject = (TextView)((View)localObject).findViewById(2131303685);
            if (localObject != null) {
              ((TextView)localObject).setText(2131760234);
            }
          }
          localObject = f.e(this.vuE).getLoadMoreFooter();
          if (localObject != null)
          {
            localObject = (TextView)((View)localObject).findViewById(2131303685);
            if (localObject != null) {
              ((TextView)localObject).setVisibility(0);
            }
          }
          localObject = f.e(this.vuE).getLoadMoreFooter();
          if (localObject != null)
          {
            localObject = ((View)localObject).findViewById(2131303684);
            if (localObject != null) {
              ((View)localObject).setVisibility(8);
            }
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
          AppMethodBeat.o(166828);
          return;
          localObject = f.e(this.vuE).getLoadMoreFooter();
          if (localObject != null)
          {
            localObject = (TextView)((View)localObject).findViewById(2131303685);
            if (localObject != null) {
              ((TextView)localObject).setText(2131760235);
            }
          }
          localObject = f.e(this.vuE).getLoadMoreFooter();
          if (localObject != null)
          {
            localObject = (TextView)((View)localObject).findViewById(2131303685);
            if (localObject != null) {
              ((TextView)localObject).setVisibility(8);
            }
          }
          localObject = f.e(this.vuE).getLoadMoreFooter();
          if (localObject != null)
          {
            localObject = ((View)localObject).findViewById(2131303684);
            if (localObject != null) {
              ((View)localObject).setVisibility(0);
            }
          }
        }
      }
      
      public final void onRefreshEnd(RefreshLoadMoreLayout.c paramAnonymousc)
      {
        AppMethodBeat.i(251327);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousc);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.axR());
        super.onRefreshEnd(paramAnonymousc);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
        AppMethodBeat.o(251327);
      }
    });
    parama = FinderReporterUIC.wzC;
    paramMMActivity = FinderReporterUIC.a.fH((Context)paramMMActivity);
    if (paramMMActivity != null)
    {
      paramMMActivity = FinderReporterUIC.d(paramMMActivity);
      if (paramMMActivity != null)
      {
        paramMMActivity.m(this.hak);
        AppMethodBeat.o(166842);
        return;
      }
    }
    AppMethodBeat.o(166842);
  }
  
  private static int gh(int paramInt1, int paramInt2)
  {
    if ((paramInt1 > 3) && (paramInt2 > 0)) {
      return 4;
    }
    if (paramInt1 > 0) {
      return paramInt1 + 1;
    }
    return 0;
  }
  
  public final void ci(int paramInt)
  {
    AppMethodBeat.i(251336);
    RecyclerView.a locala = this.hak.getAdapter();
    if (locala != null)
    {
      locala.ci(paramInt);
      AppMethodBeat.o(251336);
      return;
    }
    AppMethodBeat.o(251336);
  }
  
  public final void dpE()
  {
    AppMethodBeat.i(166841);
    this.hak.setVisibility(8);
    this.vtJ.setVisibility(8);
    this.hSw.setVisibility(0);
    RecyclerView localRecyclerView = this.hak;
    com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, locala.axQ(), "com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback", "onStartSearch", "()V", "Undefined", "scrollToPosition", "(I)V");
    localRecyclerView.scrollToPosition(((Integer)locala.pG(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, "com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback", "onStartSearch", "()V", "Undefined", "scrollToPosition", "(I)V");
    AppMethodBeat.o(166841);
  }
  
  public final void dpF()
  {
    AppMethodBeat.i(251333);
    this.tLS.setVisibility(0);
    AppMethodBeat.o(251333);
  }
  
  public final void dpG()
  {
    AppMethodBeat.i(251334);
    this.tLS.setVisibility(4);
    AppMethodBeat.o(251334);
  }
  
  public final void gg(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(166840);
    int j = this.vuC.dpA().size();
    int i = this.vuC.cYD().size();
    dpF();
    RecyclerView.a locala;
    if ((j > 0) || (i > 0))
    {
      this.vtJ.setVisibility(8);
      this.hSw.setVisibility(8);
      this.hak.setVisibility(0);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label147;
      }
      locala = this.hak.getAdapter();
      if (locala != null) {
        locala.notifyDataSetChanged();
      }
    }
    for (;;)
    {
      this.tLS.apT(0);
      AppMethodBeat.o(166840);
      return;
      this.vtJ.setVisibility(0);
      this.hSw.setVisibility(8);
      this.hak.setVisibility(8);
      break;
      label147:
      paramInt1 = gh(paramInt1, paramInt2);
      j = gh(j, i);
      locala = this.hak.getAdapter();
      if (locala != null) {
        locala.as(paramInt1 + paramInt2, j + i);
      }
    }
  }
  
  public final boolean isShowing()
  {
    AppMethodBeat.i(251335);
    if (this.tLS.getVisibility() == 0)
    {
      AppMethodBeat.o(251335);
      return true;
    }
    AppMethodBeat.o(251335);
    return false;
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$Companion;", "", "()V", "VT_CONTACT_HEADER", "", "VT_CONTACT_ITEM", "VT_FEDD_PLAIN_TEXT", "VT_FEED_HEADER", "VT_FEED_MEDIA", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$MixSearchProfileAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "(Lcom/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback;)V", "bindData", "", "holder", "position", "", "bindImage", "", "getContactList", "", "Lcom/tencent/mm/protocal/protobuf/FinderSearchInfo;", "getData", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getFeedPosition", "getItemCount", "getItemViewType", "needShowContactMore", "onBindViewHolder", "payloads", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onViewAttachedToWindow", "plugin-finder_release"})
  public final class b
    extends RecyclerView.a<RecyclerView.v>
  {
    private final void i(RecyclerView.v paramv, final int paramInt)
    {
      AppMethodBeat.i(166837);
      Object localObject1;
      label184:
      label189:
      Object localObject2;
      switch (getItemViewType(paramInt))
      {
      case 3: 
      default: 
        AppMethodBeat.o(166837);
        return;
      case 1: 
        if (paramv == null)
        {
          paramv = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.search.FinderMixSearchContactHeaderHolder");
          AppMethodBeat.o(166837);
          throw paramv;
        }
        paramv = (b)paramv;
        if (f.a(this.vuE).dpA().size() > 3) {
          if (!((Collection)f.a(this.vuE).cYD()).isEmpty())
          {
            paramInt = 1;
            if (paramInt == 0) {
              break label184;
            }
          }
        }
        for (paramInt = 1;; paramInt = 0)
        {
          localObject1 = (View.OnClickListener)new a(this);
          kotlin.g.b.p.h(localObject1, "moreClickListener");
          if (paramInt == 0) {
            break label189;
          }
          paramv.vui.setVisibility(0);
          paramv.vuj.setVisibility(0);
          paramv.aus.setOnClickListener((View.OnClickListener)localObject1);
          AppMethodBeat.o(166837);
          return;
          paramInt = 0;
          break;
        }
        paramv.vui.setVisibility(8);
        paramv.vuj.setVisibility(8);
        paramv.aus.setOnClickListener(null);
        AppMethodBeat.o(166837);
        return;
      case 2: 
        localObject3 = (bbz)f.a(this.vuE).dpA().get(paramInt - 1);
        localObject4 = f.a(this.vuE);
        localObject1 = ((bbz)localObject3).contact;
        if (localObject1 != null)
        {
          localObject2 = ((FinderContact)localObject1).username;
          localObject1 = localObject2;
          if (localObject2 != null) {}
        }
        else
        {
          localObject1 = "";
        }
        ((e.a)localObject4).ae((String)localObject1, paramInt - 1, 1);
        if (paramv == null)
        {
          paramv = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.search.FinderMixSearchContactItemHolder");
          AppMethodBeat.o(166837);
          throw paramv;
        }
        c.a((c)paramv, (bbz)localObject3, (View.OnClickListener)new b(this, paramInt), false, 12);
        AppMethodBeat.o(166837);
        return;
      }
      Object localObject3 = (BaseFinderFeed)f.a(this.vuE).cYD().get(paramInt - f.b(this.vuE) - 1);
      f.a(this.vuE).K(((BaseFinderFeed)localObject3).lT(), paramInt - f.b(this.vuE) - 1);
      if (paramv == null)
      {
        paramv = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.convert.FinderProfileUIMediaViewHolder");
        AppMethodBeat.o(166837);
        throw paramv;
      }
      Object localObject4 = (cb)paramv;
      Object localObject5 = (kotlin.g.a.b)new c(this, (BaseFinderFeed)localObject3, paramInt);
      kotlin.g.b.p.h(localObject3, "feed");
      kotlin.g.b.p.h(localObject5, "itemClickListener");
      if (Util.isNullOrNil(((BaseFinderFeed)localObject3).feedObject.getDescription()))
      {
        paramv = (CharSequence)"";
        localObject1 = ((cb)localObject4).tFv;
        if (localObject1 != null) {
          ((WeImageView)localObject1).setVisibility(0);
        }
        ((cb)localObject4).hOf.setVisibility(0);
        localObject1 = ((cb)localObject4).readFeedId;
        if (localObject1 != null)
        {
          if (((Number)localObject1).longValue() == ((BaseFinderFeed)localObject3).lT())
          {
            localObject1 = ((cb)localObject4).tFF;
            if (localObject1 != null)
            {
              ((TextView)localObject1).setVisibility(0);
              localObject1 = kotlin.x.SXb;
            }
          }
          localObject1 = kotlin.x.SXb;
        }
        if (!((BaseFinderFeed)localObject3).feedObject.getMediaList().isEmpty()) {
          break label726;
        }
        Log.i(((cb)localObject4).TAG, "invalid item id " + ((BaseFinderFeed)localObject3).feedObject.getId());
        if (Util.isNullOrNil(((BaseFinderFeed)localObject3).feedObject.getDescription())) {
          break label713;
        }
        ((cb)localObject4).hPW.setVisibility(0);
        ((cb)localObject4).hPW.setText(paramv);
      }
      for (;;)
      {
        ((cb)localObject4).tFC.setVisibility(0);
        ((cb)localObject4).thM.setVisibility(8);
        ((cb)localObject4).hOf.setText((CharSequence)String.valueOf(((BaseFinderFeed)localObject3).feedObject.getLikeCount()));
        AppMethodBeat.o(166837);
        return;
        paramv = (CharSequence)((BaseFinderFeed)localObject3).feedObject.getDescriptionSpan();
        break;
        label713:
        ((cb)localObject4).hPW.setVisibility(8);
      }
      label726:
      label756:
      int i;
      label788:
      label927:
      label972:
      Object localObject6;
      label1033:
      Object localObject7;
      if (((BaseFinderFeed)localObject3).feedObject.isLiveFeed())
      {
        localObject1 = (cjl)j.ks((List)((BaseFinderFeed)localObject3).feedObject.getLiveMediaList());
        paramv = ((cb)localObject4).dKU.getLayoutParams();
        paramInt = ((cb)localObject4).cZM().x;
        i = ((cb)localObject4).cZM().y;
        if (i < paramInt) {
          break label2173;
        }
        paramInt /= 2;
        localObject2 = y.vXH;
        i = y.a((BaseFinderFeed)localObject3, (cjl)localObject1, paramInt);
        if (i <= 0) {
          break label2204;
        }
        paramv.height = i;
        Log.i(((cb)localObject4).TAG, "onBindViewHolder " + ((cb)localObject4).lR() + " lpWidth:" + paramv.width + ", lpHeight:" + paramv.height + ", width:" + paramInt + ", height:" + i + ", mediaWidth:" + ((cjl)localObject1).width + ", mediaHeight:" + ((cjl)localObject1).height);
        ((cb)localObject4).dKU.setLayoutParams(paramv);
        ((cb)localObject4).tFA.setVisibility(8);
        if (((BaseFinderFeed)localObject3).feedObject.getRefObjectFlag() != 2L) {
          break label2286;
        }
        ((cb)localObject4).dKU.setImageResource(2131099657);
        ((cb)localObject4).tFA.setVisibility(0);
        ((cb)localObject4).tFX.setVisibility(0);
        localObject6 = new z.f();
        ((z.f)localObject6).SYG = ((BaseFinderFeed)localObject3).feedObject.getFeedObject().contact;
        paramv = com.tencent.mm.plugin.finder.loader.m.uJa;
        localObject2 = com.tencent.mm.plugin.finder.loader.m.dka();
        paramv = (FinderContact)((z.f)localObject6).SYG;
        if (paramv == null) {
          break label2621;
        }
        paramv = paramv.headUrl;
        paramv = new com.tencent.mm.plugin.finder.loader.a(paramv);
        localObject7 = ((cb)localObject4).gyr;
        Object localObject8 = com.tencent.mm.plugin.finder.loader.m.uJa;
        ((com.tencent.mm.loader.d)localObject2).a(paramv, (ImageView)localObject7, com.tencent.mm.plugin.finder.loader.m.a(m.a.uJe));
        localObject7 = ((cb)localObject4).pIN;
        localObject8 = MMApplicationContext.getContext();
        paramv = i.vvu;
        paramv = (FinderContact)((z.f)localObject6).SYG;
        if (paramv != null)
        {
          localObject2 = paramv.nickname;
          paramv = (RecyclerView.v)localObject2;
          if (localObject2 != null) {}
        }
        else
        {
          paramv = "";
        }
        ((TextView)localObject7).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.d((Context)localObject8, (CharSequence)i.auZ(paramv), ((cb)localObject4).pIN.getTextSize()));
        ao.a((Paint)((cb)localObject4).pIN.getPaint(), 0.8F);
        ((cb)localObject4).gyr.setOnClickListener((View.OnClickListener)new cb.a((z.f)localObject6, (BaseFinderFeed)localObject3, (cb)localObject4));
        paramv = kotlin.x.SXb;
        if (Util.isNullOrNil(((BaseFinderFeed)localObject3).feedObject.getDescription())) {
          break label2626;
        }
        ((cb)localObject4).hPW.setVisibility(0);
        paramv = ((cb)localObject4).hPW;
        localObject2 = MMApplicationContext.getContext();
        localObject6 = i.vvu;
        localObject6 = ((BaseFinderFeed)localObject3).feedObject.getDescription();
        localObject7 = ((cb)localObject4).hPW.getPaint();
        kotlin.g.b.p.g(localObject7, "descTv.paint");
        localObject8 = i.vvu;
        paramv.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.d((Context)localObject2, (CharSequence)i.a((String)localObject6, (TextPaint)localObject7, i.dpZ() / 2), 0.0F));
        label1287:
        if (((BaseFinderFeed)localObject3).feedObject.getLikeCount() <= 0) {
          break label2639;
        }
        paramv = com.tencent.mm.plugin.finder.utils.k.gm(2, ((BaseFinderFeed)localObject3).feedObject.getLikeCount());
        label1311:
        ((cb)localObject4).hOf.setText((CharSequence)paramv);
        ((cb)localObject4).tFx.setVisibility(8);
        ((cb)localObject4).tFy.setVisibility(8);
        ((cb)localObject4).tFw.setVisibility(8);
        i = ((BaseFinderFeed)localObject3).feedObject.getMediaType();
        if (i != 2) {
          break label2646;
        }
        ((cb)localObject4).tFw.setVisibility(0);
        ((cb)localObject4).tFw.aan(((BaseFinderFeed)localObject3).feedObject.getMediaList().size());
        label1395:
        if (!((cb)localObject4).h((BaseFinderFeed)localObject3)) {
          break label2659;
        }
        paramv = ((cb)localObject4).tFv;
        if (paramv != null)
        {
          paramv.setImageResource(2131690550);
          paramv = kotlin.x.SXb;
        }
        paramv = ((cb)localObject4).tFv;
        if (paramv != null)
        {
          localObject2 = ((cb)localObject4).aus;
          kotlin.g.b.p.g(localObject2, "itemView");
          localObject2 = ((View)localObject2).getContext();
          kotlin.g.b.p.g(localObject2, "itemView.context");
          paramv.setIconColor(((Context)localObject2).getResources().getColor(2131100042));
          paramv = kotlin.x.SXb;
        }
        paramInt = ((BaseFinderFeed)localObject3).feedObject.getReadCount();
        ((cb)localObject4).hOf.setText((CharSequence)com.tencent.mm.plugin.finder.utils.k.Lx(paramInt));
        paramv = ((cb)localObject4).hOf;
        localObject2 = ((cb)localObject4).aus;
        kotlin.g.b.p.g(localObject2, "itemView");
        localObject2 = ((View)localObject2).getContext();
        kotlin.g.b.p.g(localObject2, "itemView.context");
        paramv.setTextColor(((Context)localObject2).getResources().getColor(2131100042));
        paramv = ((cb)localObject4).tFD;
        localObject2 = ((cb)localObject4).aus;
        kotlin.g.b.p.g(localObject2, "itemView");
        paramv.setBackground(((View)localObject2).getContext().getDrawable(2131232730));
        label1596:
        if (((BaseFinderFeed)localObject3).feedObject.getRefObjectFlag() <= 0L) {
          break label3006;
        }
        ((cb)localObject4).tFz.setVisibility(0);
        label1618:
        ((cb)localObject4).aus.setOnClickListener((View.OnClickListener)new cb.b((kotlin.g.a.b)localObject5, i));
        ((cb)localObject4).tFD.setVisibility(0);
        paramv = ((cb)localObject4).luz;
        if (paramv != null)
        {
          paramv.cancel();
          paramv = kotlin.x.SXb;
        }
        if (!((BaseFinderFeed)localObject3).feedObject.isPostFailed()) {
          break label3019;
        }
        ((cb)localObject4).tFC.setVisibility(0);
        ((cb)localObject4).thM.setVisibility(8);
        ((cb)localObject4).tFD.setVisibility(8);
        label1706:
        if ((((cb)localObject4).tFC.getVisibility() == 8) && (((cb)localObject4).thM.getVisibility() == 8)) {
          ((cb)localObject4).hPW.getVisibility();
        }
        ((cb)localObject4).tFE.setVisibility(0);
        if (!((cb)localObject4).h((BaseFinderFeed)localObject3)) {
          break label3205;
        }
        paramv = ((cb)localObject4).tFG;
        if (paramv != null) {
          paramv.setVisibility(8);
        }
        if (!((BaseFinderFeed)localObject3).feedObject.isPrivate()) {
          break label3193;
        }
        localObject2 = ((cb)localObject4).tFH;
        if (localObject2 != null)
        {
          paramv = ((cb)localObject4).tFH;
          if (paramv == null) {
            break label3183;
          }
          paramv = paramv.getContext();
          label1814:
          localObject5 = ((cb)localObject4).tFH;
          if (localObject5 == null) {
            break label3188;
          }
          localObject5 = ((ImageView)localObject5).getContext();
          if (localObject5 == null) {
            break label3188;
          }
          localObject5 = ((Context)localObject5).getResources();
          if (localObject5 == null) {
            break label3188;
          }
          paramInt = ((Resources)localObject5).getColor(2131100042);
          label1859:
          ((ImageView)localObject2).setImageDrawable(ar.m(paramv, 2131690590, paramInt));
          paramv = kotlin.x.SXb;
        }
        paramv = ((cb)localObject4).tFG;
        if (paramv != null) {
          paramv.setVisibility(0);
        }
        label1891:
        paramv = y.vXH;
        if (y.w((BaseFinderFeed)localObject3))
        {
          paramv = ((BaseFinderFeed)localObject3).feedObject.getLiveInfo();
          if ((paramv == null) || (paramv.liveStatus != 1)) {
            break label3261;
          }
          ((cb)localObject4).tFx.setVisibility(0);
          ((cb)localObject4).tFy.setVisibility(8);
          paramv = ((cb)localObject4).tFv;
          if (paramv != null) {
            paramv.setVisibility(8);
          }
          paramv = ((BaseFinderFeed)localObject3).feedObject.getLiveInfo();
          if (paramv == null) {
            break label3233;
          }
          paramInt = paramv.LCy;
          label1977:
          if (paramInt <= 0) {
            break label3238;
          }
          paramv = ((cb)localObject4).hOf;
          localObject2 = ((cb)localObject4).aus;
          kotlin.g.b.p.g(localObject2, "itemView");
          paramv.setText((CharSequence)((View)localObject2).getContext().getString(2131760081, new Object[] { com.tencent.mm.plugin.finder.utils.k.gm(2, paramInt) }));
          label2032:
          ((cb)localObject4).hPW.setVisibility(8);
        }
        localObject2 = ((cb)localObject4).TAG;
        localObject1 = new StringBuilder("mediaType:").append(((cjl)localObject1).mediaType).append(",liveStatus:");
        paramv = ((BaseFinderFeed)localObject3).feedObject.getLiveInfo();
        if (paramv == null) {
          break label3283;
        }
        paramv = Integer.valueOf(paramv.liveStatus);
        label2096:
        localObject1 = ((StringBuilder)localObject1).append(paramv).append(",contact liveStatus:");
        paramv = ((BaseFinderFeed)localObject3).feedObject.getRefObjectContact();
        if (paramv == null) {
          break label3288;
        }
      }
      label2204:
      label2621:
      label2626:
      label2639:
      label2646:
      label3288:
      for (paramv = Integer.valueOf(paramv.liveStatus);; paramv = null)
      {
        Log.i((String)localObject2, paramv.intValue());
        break;
        localObject1 = (cjl)j.ks((List)((BaseFinderFeed)localObject3).feedObject.getMediaList());
        break label756;
        label2173:
        localObject2 = MMApplicationContext.getContext().getResources();
        if (localObject2 == null) {
          kotlin.g.b.p.hyc();
        }
        paramInt = i - (int)((Resources)localObject2).getDimension(2131165303);
        break label788;
        Log.i(((cb)localObject4).TAG, "onBindViewHolder " + ((cb)localObject4).lR() + " width invalid:" + paramInt + ", " + ((cb)localObject4).dKU.getLayoutParams().width + ", " + ((cb)localObject4).dKU.getLayoutParams().height);
        break label927;
        label2286:
        if (((cjl)localObject1).mediaType == 4)
        {
          if (Util.isNullOrNil(((cjl)localObject1).coverUrl))
          {
            paramv = new com.tencent.mm.plugin.finder.loader.k((cjl)localObject1, com.tencent.mm.plugin.finder.storage.x.vEo, null, null, 12);
            localObject2 = com.tencent.mm.plugin.finder.loader.m.uJa;
            localObject2 = com.tencent.mm.plugin.finder.loader.m.djY();
            localObject6 = ((cb)localObject4).dKU;
            localObject7 = com.tencent.mm.plugin.finder.loader.m.uJa;
            ((com.tencent.mm.loader.d)localObject2).a(paramv, (ImageView)localObject6, com.tencent.mm.plugin.finder.loader.m.a(m.a.uJb));
            break label972;
          }
          paramv = new com.tencent.mm.plugin.finder.loader.q((cjl)localObject1, com.tencent.mm.plugin.finder.storage.x.vEn);
          localObject2 = com.tencent.mm.plugin.finder.loader.m.uJa;
          localObject2 = com.tencent.mm.plugin.finder.loader.m.djY();
          localObject6 = ((cb)localObject4).dKU;
          localObject7 = com.tencent.mm.plugin.finder.loader.m.uJa;
          ((com.tencent.mm.loader.d)localObject2).a(paramv, (ImageView)localObject6, com.tencent.mm.plugin.finder.loader.m.a(m.a.uJb));
          break label972;
        }
        if (((cjl)localObject1).mediaType == 9)
        {
          localObject2 = ((cjl)localObject1).coverUrl;
          paramv = (RecyclerView.v)localObject2;
          if (localObject2 == null) {
            paramv = "";
          }
          kotlin.g.b.p.g(paramv, "mediaObj.coverUrl ?: \"\"");
          localObject2 = paramv;
          if (Util.isNullOrNil(paramv)) {
            localObject2 = kotlin.g.b.p.I(((cjl)localObject1).thumbUrl, Util.nullAsNil(((cjl)localObject1).thumb_url_token));
          }
          paramv = ((BaseFinderFeed)localObject3).feedObject.getLiveInfo();
          if ((paramv != null) && (paramv.liveStatus == 1))
          {
            paramv = com.tencent.mm.plugin.finder.loader.m.uJa;
            paramv = com.tencent.mm.plugin.finder.loader.m.djY();
            localObject2 = new com.tencent.mm.plugin.finder.loader.p((String)localObject2, com.tencent.mm.plugin.finder.storage.x.vEn);
            localObject6 = ((cb)localObject4).dKU;
            localObject7 = com.tencent.mm.plugin.finder.loader.m.uJa;
            paramv.a(localObject2, (ImageView)localObject6, com.tencent.mm.plugin.finder.loader.m.a(m.a.uJb));
            break label972;
          }
          paramv = com.tencent.mm.plugin.finder.utils.m.vVH;
          com.tencent.mm.plugin.finder.utils.m.h(((cb)localObject4).dKU, (String)localObject2);
          break label972;
        }
        paramv = com.tencent.mm.plugin.finder.loader.m.uJa;
        paramv = com.tencent.mm.plugin.finder.loader.m.djY();
        localObject2 = new com.tencent.mm.plugin.finder.loader.k((cjl)localObject1, com.tencent.mm.plugin.finder.storage.x.vEo, null, null, 12);
        localObject6 = ((cb)localObject4).dKU;
        localObject7 = com.tencent.mm.plugin.finder.loader.m.uJa;
        paramv.a(localObject2, (ImageView)localObject6, com.tencent.mm.plugin.finder.loader.m.a(m.a.uJb));
        break label972;
        paramv = null;
        break label1033;
        ((cb)localObject4).hPW.setVisibility(8);
        break label1287;
        paramv = "0";
        break label1311;
        ((cb)localObject4).tFw.setVisibility(8);
        break label1395;
        label2659:
        paramv = g.vGW;
        localObject2 = g.Lj(((BaseFinderFeed)localObject3).feedObject.getFeedObject().objectType);
        if (localObject2 != null)
        {
          paramv = (CharSequence)((azu)localObject2).LJF;
          if ((paramv != null) && (paramv.length() != 0)) {
            break label2861;
          }
        }
        for (paramInt = 1;; paramInt = 0)
        {
          if (paramInt == 0) {
            break label2866;
          }
          paramv = ((cb)localObject4).tFv;
          if (paramv != null)
          {
            localObject2 = ((cb)localObject4).aus;
            kotlin.g.b.p.g(localObject2, "itemView");
            localObject2 = ((View)localObject2).getContext();
            kotlin.g.b.p.g(localObject2, "itemView.context");
            paramv.setIconColor(((Context)localObject2).getResources().getColor(2131099844));
            paramv = kotlin.x.SXb;
          }
          paramv = ((cb)localObject4).tFD;
          localObject2 = ((cb)localObject4).aus;
          kotlin.g.b.p.g(localObject2, "itemView");
          paramv.setBackground(((View)localObject2).getContext().getDrawable(2131232729));
          paramv = ((cb)localObject4).hOf;
          localObject2 = ((cb)localObject4).aus;
          kotlin.g.b.p.g(localObject2, "itemView");
          localObject2 = ((View)localObject2).getContext();
          kotlin.g.b.p.g(localObject2, "itemView.context");
          paramv.setTextColor(((Context)localObject2).getResources().getColor(2131099844));
          break;
        }
        localObject6 = ((cb)localObject4).tFv;
        if (localObject6 != null)
        {
          paramv = com.tencent.mm.plugin.finder.loader.m.uJa;
          paramv = com.tencent.mm.plugin.finder.loader.m.djY();
          localObject2 = new com.tencent.mm.plugin.finder.loader.p(((azu)localObject2).LJF, com.tencent.mm.plugin.finder.storage.x.vEn);
          if (localObject6 == null)
          {
            paramv = new t("null cannot be cast to non-null type android.widget.ImageView");
            AppMethodBeat.o(166837);
            throw paramv;
          }
          localObject6 = (ImageView)localObject6;
          localObject7 = com.tencent.mm.plugin.finder.loader.m.uJa;
          paramv.a(localObject2, (ImageView)localObject6, com.tencent.mm.plugin.finder.loader.m.a(m.a.uJb));
          paramv = kotlin.x.SXb;
        }
        paramv = ((cb)localObject4).tFv;
        if (paramv == null) {
          break label1596;
        }
        localObject2 = ((cb)localObject4).aus;
        kotlin.g.b.p.g(localObject2, "itemView");
        paramv.setColorFilter(com.tencent.mm.cb.a.n(((View)localObject2).getContext(), 2131099844), PorterDuff.Mode.SRC_ATOP);
        paramv = kotlin.x.SXb;
        break label1596;
        ((cb)localObject4).tFz.setVisibility(8);
        break label1618;
        if (((BaseFinderFeed)localObject3).feedObject.isPostFinish())
        {
          ((cb)localObject4).tFC.setVisibility(8);
          ((cb)localObject4).thM.setVisibility(8);
          break label1706;
        }
        ((cb)localObject4).tFC.setVisibility(8);
        ((cb)localObject4).tFD.setVisibility(8);
        ((cb)localObject4).thM.setVisibility(0);
        ((cb)localObject4).luz = ValueAnimator.ofInt(new int[] { ((cb)localObject4).tFB.getProgress(), ((BaseFinderFeed)localObject3).feedObject.getPostInfo().Mpc });
        paramv = ((cb)localObject4).luz;
        if (paramv == null) {
          kotlin.g.b.p.hyc();
        }
        paramv.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new cb.c((cb)localObject4));
        paramv = ((cb)localObject4).luz;
        if (paramv == null) {
          kotlin.g.b.p.hyc();
        }
        paramv = paramv.setDuration(400L);
        if (paramv == null) {
          break label1706;
        }
        paramv.start();
        paramv = kotlin.x.SXb;
        break label1706;
        label3183:
        paramv = null;
        break label1814;
        label3188:
        paramInt = 0;
        break label1859;
        label3193:
        ((BaseFinderFeed)localObject3).feedObject.getStickyTime();
        break label1891;
        paramv = ((cb)localObject4).tFG;
        if (paramv != null) {
          paramv.setVisibility(8);
        }
        ((BaseFinderFeed)localObject3).feedObject.getStickyTime();
        break label1891;
        paramInt = 0;
        break label1977;
        ((cb)localObject4).hOf.setVisibility(8);
        ((cb)localObject4).tFD.setVisibility(8);
        break label2032;
        ((cb)localObject4).tFx.setVisibility(8);
        ((cb)localObject4).tFy.setVisibility(0);
        break label2032;
        paramv = null;
        break label2096;
      }
    }
    
    public final int KL(int paramInt)
    {
      AppMethodBeat.i(251331);
      int i = f.b(this.vuE);
      if (paramInt < i)
      {
        AppMethodBeat.o(251331);
        return -1;
      }
      if (paramInt == i)
      {
        AppMethodBeat.o(251331);
        return -1;
      }
      AppMethodBeat.o(251331);
      return paramInt - i - 1;
    }
    
    public final RecyclerView.v a(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(166835);
      kotlin.g.b.p.h(paramViewGroup, "parent");
      MMActivity localMMActivity;
      switch (paramInt)
      {
      default: 
        paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131494513, paramViewGroup, false);
        kotlin.g.b.p.g(paramViewGroup, "convertView");
        paramViewGroup = (RecyclerView.v)new cb(paramViewGroup);
        AppMethodBeat.o(166835);
        return paramViewGroup;
      case 1: 
        localMMActivity = f.c(this.vuE);
        if (localMMActivity == null) {
          kotlin.g.b.p.hyc();
        }
        paramViewGroup = localMMActivity.getLayoutInflater().inflate(2131494512, paramViewGroup, false);
        kotlin.g.b.p.g(paramViewGroup, "headerLayout");
        paramViewGroup = (RecyclerView.v)new b(paramViewGroup);
        AppMethodBeat.o(166835);
        return paramViewGroup;
      case 2: 
        localMMActivity = f.c(this.vuE);
        if (localMMActivity == null) {
          kotlin.g.b.p.hyc();
        }
        paramViewGroup = localMMActivity.getLayoutInflater().inflate(2131494224, paramViewGroup, false);
        kotlin.g.b.p.g(paramViewGroup, "contactLayout");
        paramViewGroup = (RecyclerView.v)new c(paramViewGroup);
        AppMethodBeat.o(166835);
        return paramViewGroup;
      }
      paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131494304, paramViewGroup, false);
      kotlin.g.b.p.g(paramViewGroup, "convertView");
      paramViewGroup = (RecyclerView.v)new d(paramViewGroup);
      AppMethodBeat.o(166835);
      return paramViewGroup;
    }
    
    public final void a(RecyclerView.v paramv, int paramInt)
    {
      AppMethodBeat.i(166838);
      kotlin.g.b.p.h(paramv, "holder");
      i(paramv, paramInt);
      AppMethodBeat.o(166838);
    }
    
    public final void a(RecyclerView.v paramv, int paramInt, List<Object> paramList)
    {
      AppMethodBeat.i(166836);
      kotlin.g.b.p.h(paramv, "holder");
      kotlin.g.b.p.h(paramList, "payloads");
      i(paramv, paramInt);
      AppMethodBeat.o(166836);
    }
    
    public final List<BaseFinderFeed> dpH()
    {
      AppMethodBeat.i(251330);
      List localList = f.a(this.vuE).cYD();
      AppMethodBeat.o(251330);
      return localList;
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(166832);
      if (!((Collection)f.a(this.vuE).cYD()).isEmpty()) {}
      for (int i = 1; i != 0; i = 0)
      {
        i = f.b(this.vuE);
        int j = f.a(this.vuE).cYD().size();
        AppMethodBeat.o(166832);
        return i + j + 1;
      }
      i = f.b(this.vuE);
      AppMethodBeat.o(166832);
      return i;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(166833);
      if (f.a(this.vuE) == null) {
        kotlin.g.b.p.hyc();
      }
      int i = f.b(this.vuE);
      if (paramInt < i)
      {
        if (paramInt == 0)
        {
          AppMethodBeat.o(166833);
          return 1;
        }
        AppMethodBeat.o(166833);
        return 2;
      }
      if (paramInt == i)
      {
        AppMethodBeat.o(166833);
        return 3;
      }
      AppMethodBeat.o(166833);
      return 4;
    }
    
    public final void k(RecyclerView.v paramv)
    {
      boolean bool2 = true;
      AppMethodBeat.i(166834);
      kotlin.g.b.p.h(paramv, "holder");
      super.k(paramv);
      Object localObject = paramv.aus;
      kotlin.g.b.p.g(localObject, "holder.itemView");
      localObject = ((View)localObject).getLayoutParams();
      if ((localObject != null) && ((localObject instanceof StaggeredGridLayoutManager.LayoutParams)))
      {
        localObject = (StaggeredGridLayoutManager.LayoutParams)localObject;
        bool1 = bool2;
        if (paramv.lU() != 1)
        {
          bool1 = bool2;
          if (paramv.lU() != 2) {
            if (paramv.lU() != 3) {
              break label104;
            }
          }
        }
      }
      label104:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        ((StaggeredGridLayoutManager.LayoutParams)localObject).aC(bool1);
        AppMethodBeat.o(166834);
        return;
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(f.b paramb) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(166829);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$MixSearchProfileAdapter$bindData$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        f.a(this.vuG.vuE).dpB();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$MixSearchProfileAdapter$bindData$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(166829);
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b
      implements View.OnClickListener
    {
      b(f.b paramb, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(166830);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$MixSearchProfileAdapter$bindData$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        kotlin.g.b.p.g(paramView, "it");
        paramView = paramView.getTag();
        if (paramView == null)
        {
          paramView = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSearchInfo");
          AppMethodBeat.o(166830);
          throw paramView;
        }
        bbz localbbz = (bbz)paramView;
        paramView = localbbz.contact;
        if ((paramView != null) && (paramView.liveStatus == 1))
        {
          com.tencent.mm.plugin.finder.report.live.k localk = com.tencent.mm.plugin.finder.report.live.k.vkd;
          paramView = localbbz.contact;
          if (paramView != null)
          {
            localObject = paramView.username;
            paramView = (View)localObject;
            if (localObject != null) {}
          }
          else
          {
            paramView = "";
          }
          localk.a(null, paramView, paramInt, s.p.voC, "23");
        }
        f.a(this.vuG.vuE).a(localbbz, paramInt - 1);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$MixSearchProfileAdapter$bindData$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(166830);
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "invoke"})
    static final class c
      extends kotlin.g.b.q
      implements kotlin.g.a.b<Integer, kotlin.x>
    {
      c(f.b paramb, BaseFinderFeed paramBaseFinderFeed, int paramInt)
      {
        super();
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$SpacesItemDecoration;", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "space", "", "(Lcom/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback;I)V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "setFeedDecoration", "holder", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "plugin-finder_release"})
  public final class c
    extends RecyclerView.h
  {
    private final int tCv;
    
    public c()
    {
      int i;
      this.tCv = i;
    }
    
    private final void a(Rect paramRect, RecyclerView.v paramv)
    {
      AppMethodBeat.i(251332);
      int i = (int)(this.tCv / 2.0F);
      paramRect.top = this.tCv;
      paramv = paramv.aus;
      kotlin.g.b.p.g(paramv, "holder.itemView");
      paramv = paramv.getLayoutParams();
      if ((paramv != null) && ((paramv instanceof StaggeredGridLayoutManager.LayoutParams)))
      {
        if (((StaggeredGridLayoutManager.LayoutParams)paramv).kj() == 0)
        {
          paramRect.left = this.tCv;
          paramRect.right = i;
          AppMethodBeat.o(251332);
          return;
        }
        paramRect.left = i;
        paramRect.right = this.tCv;
        AppMethodBeat.o(251332);
        return;
      }
      paramRect.left = this.tCv;
      paramRect.right = this.tCv;
      AppMethodBeat.o(251332);
    }
    
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(166839);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramRect);
      localb.bm(paramView);
      localb.bm(paramRecyclerView);
      localb.bm(params);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$SpacesItemDecoration", "com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$SpacesItemDecorationandroid/support/v7/widget/RecyclerView$ItemDecoration", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroid/support/v7/widget/RecyclerView;Landroid/support/v7/widget/RecyclerView$State;)V", this, localb.axR());
      kotlin.g.b.p.h(paramRect, "outRect");
      kotlin.g.b.p.h(paramView, "view");
      kotlin.g.b.p.h(paramRecyclerView, "parent");
      kotlin.g.b.p.h(params, "state");
      int i = RecyclerView.bw(paramView);
      paramView = paramRecyclerView.bi(paramView);
      paramRecyclerView = f.this.hak.getAdapter();
      if (paramRecyclerView == null) {
        kotlin.g.b.p.hyc();
      }
      kotlin.g.b.p.g(paramRecyclerView, "recyclerView.adapter!!");
      if (i != paramRecyclerView.getItemCount() - 1)
      {
        paramRecyclerView = f.this.hak.getAdapter();
        if (paramRecyclerView == null) {
          kotlin.g.b.p.hyc();
        }
        kotlin.g.b.p.g(paramRecyclerView, "recyclerView.adapter!!");
        if (i != paramRecyclerView.getItemCount() - 2) {}
      }
      else
      {
        paramRect.bottom = (this.tCv * 2);
        if (f.b(f.this) != 0) {
          break label249;
        }
        if (i != 0) {
          break label234;
        }
        paramRect.right = 0;
        paramRect.top = 0;
        paramRect.left = 0;
        paramRect.bottom = 0;
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$SpacesItemDecoration", "com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$SpacesItemDecorationandroid/support/v7/widget/RecyclerView$ItemDecoration", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroid/support/v7/widget/RecyclerView;Landroid/support/v7/widget/RecyclerView$State;)V");
        AppMethodBeat.o(166839);
        return;
        paramRect.bottom = 0;
        break;
        label234:
        kotlin.g.b.p.g(paramView, "holder");
        a(paramRect, paramView);
        continue;
        label249:
        if (i <= f.b(f.this))
        {
          paramRect.right = 0;
          paramRect.top = 0;
          paramRect.left = 0;
          paramRect.bottom = 0;
        }
        else
        {
          kotlin.g.b.p.g(paramView, "holder");
          a(paramRect, paramView);
          if (i <= f.b(f.this) + 2) {
            paramRect.top = 0;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.search.f
 * JD-Core Version:    0.7.0.1
 */