package com.tencent.mm.plugin.finder.search;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.s;
import androidx.recyclerview.widget.RecyclerView.v;
import androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams;
import com.tencent.d.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.e;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.i;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.convert.cg;
import com.tencent.mm.plugin.finder.convert.ch;
import com.tencent.mm.plugin.finder.convert.ch.a;
import com.tencent.mm.plugin.finder.convert.ch.b;
import com.tencent.mm.plugin.finder.convert.ch.c;
import com.tencent.mm.plugin.finder.event.base.f;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.live.report.s.t;
import com.tencent.mm.plugin.finder.loader.r;
import com.tencent.mm.plugin.finder.loader.t.a;
import com.tencent.mm.plugin.finder.loader.y;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.u;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.plugin.finder.view.FinderLiveOnliveWidget;
import com.tencent.mm.plugin.finder.view.FinderPostProgressView;
import com.tencent.mm.plugin.finder.view.manager.FinderStaggeredGridLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.plugin.sns.ui.view.ImageIndicatorView;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.protocal.protobuf.bfz;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.protocal.protobuf.csh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.aa.f;
import kotlin.g.b.p;
import kotlin.g.b.q;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback;", "Lcom/tencent/mm/plugin/finder/search/FinderMixSearchUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/search/FinderMixSearchUIContract$Presenter;", "searchScene", "", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/search/FinderMixSearchUIContract$Presenter;I)V", "TAG", "", "loadingView", "Landroid/view/View;", "noResultView", "Landroid/widget/TextView;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "dismissSearchResult", "", "getActivity", "getItemSpace", "getPresenter", "getShowContactListSize", "contactListSize", "feedListSize", "isFinderLiveSearch", "", "isShowing", "notifyItemChanged", "position", "onSearchCallback", "originContactListSize", "originFeedListSize", "onStartSearch", "onTextChange", "query", "showSearchResult", "Companion", "MixSearchProfileAdapter", "SpacesItemDecoration", "plugin-finder_release"})
public final class g
  implements f.b
{
  public static final a AbA;
  private f.a Abz;
  private final String TAG;
  private MMActivity iXq;
  RecyclerView jLl;
  View kGT;
  private int ptD;
  TextView xND;
  private RefreshLoadMoreLayout xvJ;
  
  static
  {
    AppMethodBeat.i(290801);
    AbA = new a((byte)0);
    AppMethodBeat.o(290801);
  }
  
  public g(MMActivity paramMMActivity, final f.a parama, int paramInt)
  {
    AppMethodBeat.i(290800);
    this.TAG = "Finder.FinderMixSearchViewCallback";
    this.iXq = paramMMActivity;
    this.Abz = parama;
    this.ptD = paramInt;
    Object localObject1 = paramMMActivity.findViewById(b.f.rl_layout);
    p.j(localObject1, "context.findViewById(R.id.rl_layout)");
    this.xvJ = ((RefreshLoadMoreLayout)localObject1);
    localObject1 = paramMMActivity.findViewById(b.f.no_result_tv);
    p.j(localObject1, "context.findViewById(R.id.no_result_tv)");
    this.xND = ((TextView)localObject1);
    localObject1 = paramMMActivity.findViewById(b.f.loading_layout);
    p.j(localObject1, "context.findViewById(R.id.loading_layout)");
    this.kGT = ((View)localObject1);
    this.jLl = this.xvJ.getRecyclerView();
    if (dpJ())
    {
      localObject1 = paramMMActivity.findViewById(b.f.main_rv);
      if (localObject1 == null)
      {
        paramMMActivity = new kotlin.t("null cannot be cast to non-null type android.view.View");
        AppMethodBeat.o(290800);
        throw paramMMActivity;
      }
      this.xvJ.setBackgroundColor(paramMMActivity.getResources().getColor(b.c.Dark_0));
      ((View)localObject1).setBackgroundColor(paramMMActivity.getResources().getColor(b.c.Dark_0));
    }
    localObject1 = new FinderStaggeredGridLayoutManager(2);
    this.jLl.setLayoutManager((RecyclerView.LayoutManager)localObject1);
    localObject1 = new b(dpJ());
    this.jLl.setAdapter((RecyclerView.a)localObject1);
    Object localObject2;
    if (dpJ())
    {
      localObject1 = this.iXq.getResources();
      if (localObject1 == null) {
        p.iCn();
      }
      paramInt = (int)((Resources)localObject1).getDimension(b.d.Edge_1_5_A);
      localObject1 = new c(paramInt);
      this.jLl.b((RecyclerView.h)localObject1);
      this.xvJ.setEnablePullDownHeader(false);
      localObject1 = this.xvJ;
      localObject2 = ad.kS((Context)paramMMActivity);
      if (!dpJ()) {
        break label446;
      }
    }
    label446:
    for (paramInt = b.g.load_more_footer_night_mode;; paramInt = b.g.load_more_footer)
    {
      localObject2 = ((LayoutInflater)localObject2).inflate(paramInt, null);
      p.j(localObject2, "MMLayoutInflater.getInfl…oter\n            }, null)");
      ((RefreshLoadMoreLayout)localObject1).setLoadMoreFooter((View)localObject2);
      this.xvJ.setActionCallback((RefreshLoadMoreLayout.a)new RefreshLoadMoreLayout.a()
      {
        public final void Ie(int paramAnonymousInt)
        {
          AppMethodBeat.i(276901);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.sg(paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.aFi());
          super.Ie(paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
          AppMethodBeat.o(276901);
        }
        
        public final void a(RefreshLoadMoreLayout.c paramAnonymousc)
        {
          AppMethodBeat.i(276903);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousc);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.aFi());
          super.a(paramAnonymousc);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
          AppMethodBeat.o(276903);
        }
        
        public final void cKQ()
        {
          AppMethodBeat.i(166828);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
          g.f(this.AbB);
          h.ioq();
          Object localObject;
          if (parama.dQQ())
          {
            localObject = g.g(this.AbB).getLoadMoreFooter();
            if (localObject != null)
            {
              localObject = (TextView)((View)localObject).findViewById(b.f.load_more_footer_tip_tv);
              if (localObject != null) {
                ((TextView)localObject).setText(b.j.finder_load_more_footer_tip);
              }
            }
            localObject = g.g(this.AbB).getLoadMoreFooter();
            if (localObject != null)
            {
              localObject = (TextView)((View)localObject).findViewById(b.f.load_more_footer_tip_tv);
              if (localObject != null) {
                ((TextView)localObject).setVisibility(0);
              }
            }
            localObject = g.g(this.AbB).getLoadMoreFooter();
            if (localObject != null)
            {
              localObject = ((View)localObject).findViewById(b.f.load_more_footer_end_layout);
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
            localObject = g.g(this.AbB).getLoadMoreFooter();
            if (localObject != null)
            {
              localObject = (TextView)((View)localObject).findViewById(b.f.load_more_footer_tip_tv);
              if (localObject != null) {
                ((TextView)localObject).setText(b.j.finder_load_more_no_result_tip);
              }
            }
            localObject = g.g(this.AbB).getLoadMoreFooter();
            if (localObject != null)
            {
              localObject = (TextView)((View)localObject).findViewById(b.f.load_more_footer_tip_tv);
              if (localObject != null) {
                ((TextView)localObject).setVisibility(8);
              }
            }
            localObject = g.g(this.AbB).getLoadMoreFooter();
            if (localObject != null)
            {
              localObject = ((View)localObject).findViewById(b.f.load_more_footer_end_layout);
              if (localObject != null) {
                ((View)localObject).setVisibility(0);
              }
            }
          }
        }
        
        public final void onRefreshEnd(RefreshLoadMoreLayout.c paramAnonymousc)
        {
          AppMethodBeat.i(276902);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousc);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.aFi());
          super.onRefreshEnd(paramAnonymousc);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
          AppMethodBeat.o(276902);
        }
      });
      parama = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
      paramMMActivity = aj.a.fZ((Context)paramMMActivity);
      if (paramMMActivity == null) {
        break label453;
      }
      paramMMActivity = com.tencent.mm.plugin.finder.viewmodel.component.aj.d(paramMMActivity);
      if (paramMMActivity == null) {
        break label453;
      }
      paramMMActivity.k(this.jLl);
      AppMethodBeat.o(290800);
      return;
      localObject1 = this.iXq.getResources();
      if (localObject1 == null) {
        p.iCn();
      }
      paramInt = (int)((Resources)localObject1).getDimension(b.d.Edge_0_5_A);
      break;
    }
    label453:
    AppMethodBeat.o(290800);
  }
  
  private final boolean dpJ()
  {
    return this.ptD == 13;
  }
  
  private static int gT(int paramInt1, int paramInt2)
  {
    if ((paramInt1 > 3) && (paramInt2 > 0)) {
      return 4;
    }
    if (paramInt1 > 0) {
      return paramInt1 + 1;
    }
    return 0;
  }
  
  public final void cL(int paramInt)
  {
    AppMethodBeat.i(290798);
    RecyclerView.a locala = this.jLl.getAdapter();
    if (locala != null)
    {
      locala.cL(paramInt);
      AppMethodBeat.o(290798);
      return;
    }
    AppMethodBeat.o(290798);
  }
  
  public final void dQR()
  {
    AppMethodBeat.i(166841);
    this.jLl.setVisibility(8);
    this.xND.setVisibility(8);
    this.kGT.setVisibility(0);
    RecyclerView localRecyclerView = this.jLl;
    com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.b(localRecyclerView, locala.aFh(), "com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback", "onStartSearch", "()V", "Undefined", "scrollToPosition", "(I)V");
    localRecyclerView.scrollToPosition(((Integer)locala.sf(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(localRecyclerView, "com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback", "onStartSearch", "()V", "Undefined", "scrollToPosition", "(I)V");
    AppMethodBeat.o(166841);
  }
  
  public final void dQS()
  {
    AppMethodBeat.i(290797);
    this.xvJ.setVisibility(0);
    AppMethodBeat.o(290797);
  }
  
  public final void gS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(166840);
    int j = this.Abz.dQN().size();
    int i = this.Abz.dor().size();
    dQS();
    RecyclerView.a locala;
    if ((j > 0) || (i > 0))
    {
      this.xND.setVisibility(8);
      this.kGT.setVisibility(8);
      this.jLl.setVisibility(0);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label147;
      }
      locala = this.jLl.getAdapter();
      if (locala != null) {
        locala.notifyDataSetChanged();
      }
    }
    for (;;)
    {
      this.xvJ.azs(0);
      AppMethodBeat.o(166840);
      return;
      this.xND.setVisibility(0);
      this.kGT.setVisibility(8);
      this.jLl.setVisibility(8);
      break;
      label147:
      paramInt1 = gT(paramInt1, paramInt2);
      j = gT(j, i);
      locala = this.jLl.getAdapter();
      if (locala != null) {
        locala.aG(paramInt1 + paramInt2, j + i);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$Companion;", "", "()V", "VT_CONTACT_HEADER", "", "VT_CONTACT_HEADER_LIVE", "VT_CONTACT_ITEM", "VT_FEDD_PLAIN_TEXT", "VT_FEED_HEADER", "VT_FEED_LIVE_HEADER", "VT_FEED_MEDIA", "VT_FEED_MEDIA_LIVE", "VT_SAFETY_HINT", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$MixSearchProfileAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "isFinderLiveSearch", "", "(Lcom/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback;Z)V", "()Z", "bindData", "", "holder", "position", "", "bindImage", "getContactList", "", "Lcom/tencent/mm/protocal/protobuf/FinderSearchInfo;", "getData", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getFeedPosition", "getItemCount", "getItemViewType", "adapterPosition", "getSafetyHint", "", "needShowContactMore", "onBindViewHolder", "payloads", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onViewAttachedToWindow", "plugin-finder_release"})
  public final class b
    extends RecyclerView.a<RecyclerView.v>
  {
    private final boolean AbD;
    
    public b()
    {
      boolean bool;
      this.AbD = bool;
    }
    
    private String dQO()
    {
      AppMethodBeat.i(270458);
      String str = g.a(g.this).dQO();
      AppMethodBeat.o(270458);
      return str;
    }
    
    private final void i(RecyclerView.v paramv, final int paramInt)
    {
      AppMethodBeat.i(270463);
      label144:
      label218:
      label223:
      Object localObject4;
      label904:
      label2825:
      label3469:
      switch (getItemViewType(paramInt))
      {
      case 5: 
      default: 
        AppMethodBeat.o(270463);
        return;
      case 1: 
      case 8: 
        if (paramv == null)
        {
          paramv = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.search.FinderMixSearchContactHeaderHolder");
          AppMethodBeat.o(270463);
          throw paramv;
        }
        paramv = (b)paramv;
        if (g.a(g.this).dQN().size() > 3) {
          if (!((Collection)g.a(g.this).dor()).isEmpty())
          {
            paramInt = 1;
            if (paramInt == 0) {
              break label218;
            }
            paramInt = 1;
            localObject1 = (View.OnClickListener)new a(this);
            p.k(localObject1, "moreClickListener");
            if (paramInt == 0) {
              break label223;
            }
            paramv.Aba.setVisibility(0);
            paramv.Abb.setVisibility(0);
            paramv.amk.setOnClickListener((View.OnClickListener)localObject1);
          }
        }
        for (;;)
        {
          paramv.kEs.setText((CharSequence)paramv.Abc);
          AppMethodBeat.o(270463);
          return;
          paramInt = 0;
          break;
          paramInt = 0;
          break label144;
          paramv.Aba.setVisibility(8);
          paramv.Abb.setVisibility(8);
          paramv.amk.setOnClickListener(null);
        }
      case 2: 
        localObject3 = (bip)g.a(g.this).dQN().get(paramInt - 1);
        localObject4 = g.a(g.this);
        localObject1 = ((bip)localObject3).contact;
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
        ((f.a)localObject4).ah((String)localObject1, paramInt - 1, 1);
        if (paramv == null)
        {
          paramv = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.search.FinderMixSearchContactItemHolder");
          AppMethodBeat.o(270463);
          throw paramv;
        }
        c.a((c)paramv, (bip)localObject3, (View.OnClickListener)new b(this, paramInt), false, 12);
        AppMethodBeat.o(270463);
        return;
      case 3: 
      case 6: 
        if (paramv == null)
        {
          paramv = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.search.FinderMixSearchFeedHeaderHolder");
          AppMethodBeat.o(270463);
          throw paramv;
        }
        paramv = (d)paramv;
        if (paramInt != 0)
        {
          paramInt = 1;
          if (paramInt == 0) {
            break label451;
          }
          paramv.mND.setVisibility(0);
        }
        for (;;)
        {
          paramv.kEs.setText((CharSequence)paramv.Abc);
          AppMethodBeat.o(270463);
          return;
          paramInt = 0;
          break;
          paramv.mND.setVisibility(8);
        }
      case 9: 
        if (paramv == null)
        {
          paramv = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.search.FinderMixSearchSafetyHintHolder");
          AppMethodBeat.o(270463);
          throw paramv;
        }
        paramv = (e)paramv;
        localObject1 = dQO();
        p.k(localObject1, "safetyHint");
        paramv.Abs.setText((CharSequence)localObject1);
        AppMethodBeat.o(270463);
        return;
      case 4: 
        label451:
        localObject3 = (BaseFinderFeed)g.a(g.this).dor().get(paramInt - g.b(g.this) - 1);
        g.a(g.this).k(((BaseFinderFeed)localObject3).mf(), paramInt - g.b(g.this) - 1, 2);
        if (paramv == null)
        {
          paramv = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.convert.FinderProfileUIMediaViewHolder");
          AppMethodBeat.o(270463);
          throw paramv;
        }
        localObject4 = (ch)paramv;
        ((ch)paramv).mc();
        Object localObject5 = (kotlin.g.a.b)new c(this, (BaseFinderFeed)localObject3, paramInt);
        p.k(localObject3, "feed");
        p.k(localObject5, "itemClickListener");
        if (Util.isNullOrNil(((BaseFinderFeed)localObject3).feedObject.getDescription()))
        {
          paramv = (CharSequence)"";
          localObject1 = ((ch)localObject4).xoe;
          if (localObject1 != null) {
            ((WeImageView)localObject1).setVisibility(0);
          }
          ((ch)localObject4).kCB.setVisibility(0);
          localObject1 = ((ch)localObject4).readFeedId;
          if (localObject1 != null)
          {
            if (((Number)localObject1).longValue() == ((BaseFinderFeed)localObject3).mf())
            {
              localObject1 = ((ch)localObject4).xoo;
              if (localObject1 != null)
              {
                ((TextView)localObject1).setVisibility(0);
                localObject1 = kotlin.x.aazN;
              }
            }
            localObject1 = kotlin.x.aazN;
          }
          if (!((BaseFinderFeed)localObject3).feedObject.getMediaList().isEmpty()) {
            break label904;
          }
          Log.i(((ch)localObject4).TAG, "invalid item id " + ((BaseFinderFeed)localObject3).feedObject.getId());
          if (Util.isNullOrNil(((BaseFinderFeed)localObject3).feedObject.getDescription())) {
            break label891;
          }
          ((ch)localObject4).kEs.setVisibility(0);
          ((ch)localObject4).kEs.setText(paramv);
        }
        for (;;)
        {
          ((ch)localObject4).xol.setVisibility(0);
          ((ch)localObject4).wOd.setVisibility(8);
          ((ch)localObject4).kCB.setText((CharSequence)String.valueOf(((BaseFinderFeed)localObject3).feedObject.getLikeCount()));
          AppMethodBeat.o(270463);
          return;
          paramv = (CharSequence)((BaseFinderFeed)localObject3).feedObject.getDescriptionSpan();
          break;
          label891:
          ((ch)localObject4).kEs.setVisibility(8);
        }
        int i;
        label966:
        label1105:
        label1150:
        Object localObject6;
        label1211:
        Object localObject7;
        if (((BaseFinderFeed)localObject3).feedObject.isLiveFeed())
        {
          localObject1 = (csg)kotlin.a.j.lo((List)((BaseFinderFeed)localObject3).feedObject.getLiveMediaList());
          paramv = ((ch)localObject4).fDJ.getLayoutParams();
          paramInt = ((ch)localObject4).dpI().x;
          i = ((ch)localObject4).dpI().y;
          if (i < paramInt) {
            break label2359;
          }
          paramInt /= 2;
          localObject2 = com.tencent.mm.plugin.finder.utils.aj.AGc;
          i = com.tencent.mm.plugin.finder.utils.aj.a((BaseFinderFeed)localObject3, (csg)localObject1, paramInt);
          if (i <= 0) {
            break label2390;
          }
          paramv.height = i;
          Log.i(((ch)localObject4).TAG, "onBindViewHolder " + ((ch)localObject4).md() + " lpWidth:" + paramv.width + ", lpHeight:" + paramv.height + ", width:" + paramInt + ", height:" + i + ", mediaWidth:" + ((csg)localObject1).width + ", mediaHeight:" + ((csg)localObject1).height);
          ((ch)localObject4).fDJ.setLayoutParams(paramv);
          ((ch)localObject4).xoj.setVisibility(8);
          if (((BaseFinderFeed)localObject3).feedObject.getRefObjectFlag() != 2L) {
            break label2472;
          }
          ((ch)localObject4).fDJ.setImageResource(b.c.BW_0_Alpha_0_1);
          ((ch)localObject4).xoj.setVisibility(0);
          ((ch)localObject4).xoJ.setVisibility(0);
          localObject6 = new aa.f();
          ((aa.f)localObject6).aaBC = ((BaseFinderFeed)localObject3).feedObject.getFeedObject().contact;
          paramv = com.tencent.mm.plugin.finder.loader.t.ztT;
          localObject2 = com.tencent.mm.plugin.finder.loader.t.dJh();
          paramv = (FinderContact)((aa.f)localObject6).aaBC;
          if (paramv == null) {
            break label2807;
          }
          paramv = paramv.headUrl;
          paramv = new com.tencent.mm.plugin.finder.loader.e(paramv, u.AlQ);
          localObject7 = ((ch)localObject4).jiu;
          Object localObject8 = com.tencent.mm.plugin.finder.loader.t.ztT;
          ((com.tencent.mm.loader.d)localObject2).a(paramv, (ImageView)localObject7, com.tencent.mm.plugin.finder.loader.t.a(t.a.ztX));
          localObject7 = ((ch)localObject4).xoK;
          localObject8 = MMApplicationContext.getContext();
          paramv = j.Acs;
          paramv = (FinderContact)((aa.f)localObject6).aaBC;
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
          ((TextView)localObject7).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.d((Context)localObject8, (CharSequence)j.aEo(paramv), ((ch)localObject4).xoK.getTextSize()));
          ar.a((Paint)((ch)localObject4).xoK.getPaint(), 0.8F);
          ((ch)localObject4).jiu.setOnClickListener((View.OnClickListener)new ch.a((aa.f)localObject6, (BaseFinderFeed)localObject3, (ch)localObject4));
          paramv = kotlin.x.aazN;
          if (Util.isNullOrNil(((BaseFinderFeed)localObject3).feedObject.getDescription())) {
            break label2812;
          }
          ((ch)localObject4).kEs.setVisibility(0);
          paramv = ((ch)localObject4).kEs;
          localObject2 = MMApplicationContext.getContext();
          localObject6 = j.Acs;
          localObject6 = ((BaseFinderFeed)localObject3).feedObject.getDescription();
          localObject7 = ((ch)localObject4).kEs.getPaint();
          p.j(localObject7, "descTv.paint");
          localObject8 = j.Acs;
          paramv.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.d((Context)localObject2, (CharSequence)j.a((String)localObject6, (TextPaint)localObject7, j.dRg() / 2), 0.0F));
          label1468:
          if (((BaseFinderFeed)localObject3).feedObject.getLikeCount() <= 0) {
            break label2825;
          }
          paramv = m.gY(2, ((BaseFinderFeed)localObject3).feedObject.getLikeCount());
          label1492:
          ((ch)localObject4).kCB.setText((CharSequence)paramv);
          ((ch)localObject4).xog.setVisibility(8);
          ((ch)localObject4).xoh.setVisibility(8);
          ((ch)localObject4).xof.setVisibility(8);
          i = ((BaseFinderFeed)localObject3).feedObject.getMediaType();
          if (i != 2) {
            break label2832;
          }
          ((ch)localObject4).xof.setVisibility(0);
          ((ch)localObject4).xof.ahH(((BaseFinderFeed)localObject3).feedObject.getMediaList().size());
          label1576:
          if (!((ch)localObject4).j((BaseFinderFeed)localObject3)) {
            break label2845;
          }
          paramv = ((ch)localObject4).xoe;
          if (paramv != null)
          {
            paramv.setImageResource(b.i.icons_filled_eyes_on);
            paramv = kotlin.x.aazN;
          }
          paramv = ((ch)localObject4).xoe;
          if (paramv != null)
          {
            localObject2 = ((ch)localObject4).amk;
            p.j(localObject2, "itemView");
            localObject2 = ((View)localObject2).getContext();
            p.j(localObject2, "itemView.context");
            paramv.setIconColor(((Context)localObject2).getResources().getColor(b.c.black));
            paramv = kotlin.x.aazN;
          }
          paramInt = ((BaseFinderFeed)localObject3).feedObject.getReadCount();
          ((ch)localObject4).kCB.setText((CharSequence)m.QH(paramInt));
          paramv = ((ch)localObject4).kCB;
          localObject2 = ((ch)localObject4).amk;
          p.j(localObject2, "itemView");
          localObject2 = ((View)localObject2).getContext();
          p.j(localObject2, "itemView.context");
          paramv.setTextColor(((Context)localObject2).getResources().getColor(b.c.black));
          paramv = ((ch)localObject4).xom;
          localObject2 = ((ch)localObject4).amk;
          p.j(localObject2, "itemView");
          paramv.setBackground(((View)localObject2).getContext().getDrawable(b.e.finder_stagged_feed_float_sef_bg));
          label1777:
          if (((BaseFinderFeed)localObject3).feedObject.getRefObjectFlag() <= 0L) {
            break label3192;
          }
          ((ch)localObject4).xoi.setVisibility(0);
          ((ch)localObject4).amk.setOnClickListener((View.OnClickListener)new ch.b((kotlin.g.a.b)localObject5, i));
          ((ch)localObject4).xom.setVisibility(0);
          paramv = ((ch)localObject4).opx;
          if (paramv != null)
          {
            paramv.cancel();
            paramv = kotlin.x.aazN;
          }
          if (!((BaseFinderFeed)localObject3).feedObject.isPostFailed()) {
            break label3205;
          }
          ((ch)localObject4).xol.setVisibility(0);
          ((ch)localObject4).wOd.setVisibility(8);
          ((ch)localObject4).xom.setVisibility(8);
          label1887:
          if ((((ch)localObject4).xol.getVisibility() == 8) && (((ch)localObject4).wOd.getVisibility() == 8)) {
            ((ch)localObject4).kEs.getVisibility();
          }
          ((ch)localObject4).xon.setVisibility(0);
          if (!((ch)localObject4).j((BaseFinderFeed)localObject3)) {
            break label3391;
          }
          paramv = ((ch)localObject4).xop;
          if (paramv != null) {
            paramv.setVisibility(8);
          }
          if (!((BaseFinderFeed)localObject3).feedObject.isPrivate()) {
            break label3379;
          }
          localObject2 = ((ch)localObject4).xoq;
          if (localObject2 != null)
          {
            paramv = ((ch)localObject4).xoq;
            if (paramv == null) {
              break label3369;
            }
            paramv = paramv.getContext();
            label1995:
            i = b.i.icons_filled_lock;
            localObject5 = ((ch)localObject4).xoq;
            if (localObject5 == null) {
              break label3374;
            }
            localObject5 = ((ImageView)localObject5).getContext();
            if (localObject5 == null) {
              break label3374;
            }
            localObject5 = ((Context)localObject5).getResources();
            if (localObject5 == null) {
              break label3374;
            }
            paramInt = ((Resources)localObject5).getColor(b.c.black);
            label2044:
            ((ImageView)localObject2).setImageDrawable(au.o(paramv, i, paramInt));
            paramv = kotlin.x.aazN;
          }
          paramv = ((ch)localObject4).xop;
          if (paramv != null) {
            paramv.setVisibility(0);
          }
          label2074:
          paramv = com.tencent.mm.plugin.finder.utils.aj.AGc;
          if (com.tencent.mm.plugin.finder.utils.aj.w((BaseFinderFeed)localObject3))
          {
            paramv = ((BaseFinderFeed)localObject3).feedObject.getLiveInfo();
            if ((paramv == null) || (paramv.liveStatus != 1)) {
              break label3447;
            }
            ((ch)localObject4).xog.setVisibility(0);
            ((ch)localObject4).xoh.setVisibility(8);
            paramv = ((ch)localObject4).xoe;
            if (paramv != null) {
              paramv.setVisibility(8);
            }
            paramv = ((BaseFinderFeed)localObject3).feedObject.getLiveInfo();
            if (paramv == null) {
              break label3419;
            }
            paramInt = paramv.SFG;
            label2160:
            if (paramInt <= 0) {
              break label3424;
            }
            paramv = ((ch)localObject4).kCB;
            localObject2 = ((ch)localObject4).amk;
            p.j(localObject2, "itemView");
            paramv.setText((CharSequence)((View)localObject2).getContext().getString(b.j.finder_live_members_total_tip, new Object[] { m.gY(2, paramInt) }));
            label2215:
            ((ch)localObject4).kEs.setVisibility(8);
          }
          localObject2 = ((ch)localObject4).TAG;
          localObject1 = new StringBuilder("mediaType:").append(((csg)localObject1).mediaType).append(",liveStatus:");
          paramv = ((BaseFinderFeed)localObject3).feedObject.getLiveInfo();
          if (paramv == null) {
            break label3469;
          }
          paramv = Integer.valueOf(paramv.liveStatus);
          label2279:
          localObject1 = ((StringBuilder)localObject1).append(paramv).append(",contact liveStatus:");
          paramv = ((BaseFinderFeed)localObject3).feedObject.getRefObjectContact();
          if (paramv == null) {
            break label3474;
          }
        }
        label2832:
        label3474:
        for (paramv = Integer.valueOf(paramv.liveStatus);; paramv = null)
        {
          Log.i((String)localObject2, paramv.intValue());
          AppMethodBeat.o(270463);
          return;
          localObject1 = (csg)kotlin.a.j.lo((List)((BaseFinderFeed)localObject3).feedObject.getMediaList());
          break;
          label2359:
          localObject2 = MMApplicationContext.getContext().getResources();
          if (localObject2 == null) {
            p.iCn();
          }
          paramInt = i - (int)((Resources)localObject2).getDimension(b.d.Edge_4A);
          break label966;
          label2390:
          Log.i(((ch)localObject4).TAG, "onBindViewHolder " + ((ch)localObject4).md() + " width invalid:" + paramInt + ", " + ((ch)localObject4).fDJ.getLayoutParams().width + ", " + ((ch)localObject4).fDJ.getLayoutParams().height);
          break label1105;
          label2472:
          if (((csg)localObject1).mediaType == 4)
          {
            if (Util.isNullOrNil(((csg)localObject1).coverUrl))
            {
              paramv = new r((csg)localObject1, u.Alz, null, null, 12);
              localObject2 = com.tencent.mm.plugin.finder.loader.t.ztT;
              localObject2 = com.tencent.mm.plugin.finder.loader.t.dJe();
              localObject6 = ((ch)localObject4).fDJ;
              localObject7 = com.tencent.mm.plugin.finder.loader.t.ztT;
              ((com.tencent.mm.loader.d)localObject2).a(paramv, (ImageView)localObject6, com.tencent.mm.plugin.finder.loader.t.a(t.a.ztU));
              break label1150;
            }
            paramv = new y((csg)localObject1, u.Aly);
            localObject2 = com.tencent.mm.plugin.finder.loader.t.ztT;
            localObject2 = com.tencent.mm.plugin.finder.loader.t.dJe();
            localObject6 = ((ch)localObject4).fDJ;
            localObject7 = com.tencent.mm.plugin.finder.loader.t.ztT;
            ((com.tencent.mm.loader.d)localObject2).a(paramv, (ImageView)localObject6, com.tencent.mm.plugin.finder.loader.t.a(t.a.ztU));
            break label1150;
          }
          if (((csg)localObject1).mediaType == 9)
          {
            localObject2 = ((csg)localObject1).coverUrl;
            paramv = (RecyclerView.v)localObject2;
            if (localObject2 == null) {
              paramv = "";
            }
            p.j(paramv, "mediaObj.coverUrl ?: \"\"");
            localObject2 = paramv;
            if (Util.isNullOrNil(paramv)) {
              localObject2 = p.I(((csg)localObject1).thumbUrl, Util.nullAsNil(((csg)localObject1).thumb_url_token));
            }
            paramv = ((BaseFinderFeed)localObject3).feedObject.getLiveInfo();
            if ((paramv != null) && (paramv.liveStatus == 1))
            {
              paramv = com.tencent.mm.plugin.finder.loader.t.ztT;
              paramv = com.tencent.mm.plugin.finder.loader.t.dJe();
              localObject2 = new com.tencent.mm.plugin.finder.loader.x((String)localObject2, u.Aly);
              localObject6 = ((ch)localObject4).fDJ;
              localObject7 = com.tencent.mm.plugin.finder.loader.t.ztT;
              paramv.a(localObject2, (ImageView)localObject6, com.tencent.mm.plugin.finder.loader.t.a(t.a.ztU));
              break label1150;
            }
            paramv = com.tencent.mm.plugin.finder.live.utils.a.yRm;
            com.tencent.mm.plugin.finder.live.utils.a.g(((ch)localObject4).fDJ, (String)localObject2);
            break label1150;
          }
          paramv = com.tencent.mm.plugin.finder.loader.t.ztT;
          paramv = com.tencent.mm.plugin.finder.loader.t.dJe();
          localObject2 = new r((csg)localObject1, u.Alz, null, null, 12);
          localObject6 = ((ch)localObject4).fDJ;
          localObject7 = com.tencent.mm.plugin.finder.loader.t.ztT;
          paramv.a(localObject2, (ImageView)localObject6, com.tencent.mm.plugin.finder.loader.t.a(t.a.ztU));
          break label1150;
          label2807:
          paramv = null;
          break label1211;
          label2812:
          ((ch)localObject4).kEs.setVisibility(8);
          break label1468;
          paramv = "0";
          break label1492;
          ((ch)localObject4).xof.setVisibility(8);
          break label1576;
          label2845:
          paramv = com.tencent.mm.plugin.finder.storage.logic.g.AnT;
          localObject2 = com.tencent.mm.plugin.finder.storage.logic.g.Qt(((BaseFinderFeed)localObject3).feedObject.getFeedObject().objectType);
          if (localObject2 != null)
          {
            paramv = (CharSequence)((bfz)localObject2).SQL;
            if ((paramv != null) && (paramv.length() != 0)) {
              break label3047;
            }
          }
          label3047:
          for (paramInt = 1;; paramInt = 0)
          {
            if (paramInt == 0) {
              break label3052;
            }
            paramv = ((ch)localObject4).xoe;
            if (paramv != null)
            {
              localObject2 = ((ch)localObject4).amk;
              p.j(localObject2, "itemView");
              localObject2 = ((View)localObject2).getContext();
              p.j(localObject2, "itemView.context");
              paramv.setIconColor(((Context)localObject2).getResources().getColor(b.c.White));
              paramv = kotlin.x.aazN;
            }
            paramv = ((ch)localObject4).xom;
            localObject2 = ((ch)localObject4).amk;
            p.j(localObject2, "itemView");
            paramv.setBackground(((View)localObject2).getContext().getDrawable(b.e.finder_stagged_feed_float_bg));
            paramv = ((ch)localObject4).kCB;
            localObject2 = ((ch)localObject4).amk;
            p.j(localObject2, "itemView");
            localObject2 = ((View)localObject2).getContext();
            p.j(localObject2, "itemView.context");
            paramv.setTextColor(((Context)localObject2).getResources().getColor(b.c.White));
            break;
          }
          label3052:
          localObject6 = ((ch)localObject4).xoe;
          if (localObject6 != null)
          {
            paramv = com.tencent.mm.plugin.finder.loader.t.ztT;
            paramv = com.tencent.mm.plugin.finder.loader.t.dJe();
            localObject2 = new com.tencent.mm.plugin.finder.loader.x(((bfz)localObject2).SQL, u.Aly);
            if (localObject6 == null)
            {
              paramv = new kotlin.t("null cannot be cast to non-null type android.widget.ImageView");
              AppMethodBeat.o(270463);
              throw paramv;
            }
            localObject6 = (ImageView)localObject6;
            localObject7 = com.tencent.mm.plugin.finder.loader.t.ztT;
            paramv.a(localObject2, (ImageView)localObject6, com.tencent.mm.plugin.finder.loader.t.a(t.a.ztU));
            paramv = kotlin.x.aazN;
          }
          paramv = ((ch)localObject4).xoe;
          if (paramv == null) {
            break label1777;
          }
          localObject2 = ((ch)localObject4).amk;
          p.j(localObject2, "itemView");
          paramv.setColorFilter(com.tencent.mm.ci.a.w(((View)localObject2).getContext(), b.c.White), PorterDuff.Mode.SRC_ATOP);
          paramv = kotlin.x.aazN;
          break label1777;
          label3192:
          ((ch)localObject4).xoi.setVisibility(8);
          break label1799;
          if (((BaseFinderFeed)localObject3).feedObject.isPostFinish())
          {
            ((ch)localObject4).xol.setVisibility(8);
            ((ch)localObject4).wOd.setVisibility(8);
            break label1887;
          }
          ((ch)localObject4).xol.setVisibility(8);
          ((ch)localObject4).xom.setVisibility(8);
          ((ch)localObject4).wOd.setVisibility(0);
          ((ch)localObject4).opx = ValueAnimator.ofInt(new int[] { ((ch)localObject4).xok.getProgress(), ((BaseFinderFeed)localObject3).feedObject.getPostInfo().TAi });
          paramv = ((ch)localObject4).opx;
          if (paramv == null) {
            p.iCn();
          }
          paramv.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new ch.c((ch)localObject4));
          paramv = ((ch)localObject4).opx;
          if (paramv == null) {
            p.iCn();
          }
          paramv = paramv.setDuration(400L);
          if (paramv == null) {
            break label1887;
          }
          paramv.start();
          paramv = kotlin.x.aazN;
          break label1887;
          label3369:
          paramv = null;
          break label1995;
          label3374:
          paramInt = 0;
          break label2044;
          label3379:
          ((BaseFinderFeed)localObject3).feedObject.getStickyTime();
          break label2074;
          label3391:
          paramv = ((ch)localObject4).xop;
          if (paramv != null) {
            paramv.setVisibility(8);
          }
          ((BaseFinderFeed)localObject3).feedObject.getStickyTime();
          break label2074;
          label3419:
          paramInt = 0;
          break label2160;
          label3424:
          ((ch)localObject4).kCB.setVisibility(8);
          ((ch)localObject4).xom.setVisibility(8);
          break label2215;
          label3447:
          ((ch)localObject4).xog.setVisibility(8);
          ((ch)localObject4).xoh.setVisibility(0);
          break label2215;
          paramv = null;
          break label2279;
        }
      }
      label1799:
      Object localObject2 = (BaseFinderFeed)g.a(g.this).dor().get(paramInt - g.b(g.this) - 1);
      label3205:
      g.a(g.this).k(((BaseFinderFeed)localObject2).mf(), paramInt - g.b(g.this) - 1, 3);
      if (paramv == null)
      {
        paramv = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.convert.FinderProfileUIMediaLiveViewHolder");
        AppMethodBeat.o(270463);
        throw paramv;
      }
      Object localObject3 = (cg)paramv;
      Object localObject1 = g.a(g.this).getQuery();
      if (localObject1 == null) {
        localObject1 = "";
      }
      for (;;)
      {
        ((cg)paramv).mc();
        ((cg)localObject3).a((String)localObject1, (BaseFinderFeed)localObject2, (kotlin.g.a.b)new d(this, (BaseFinderFeed)localObject2, paramInt));
        break;
      }
    }
    
    public final int PW(int paramInt)
    {
      AppMethodBeat.i(270459);
      int i = g.b(g.this);
      if (paramInt < i)
      {
        AppMethodBeat.o(270459);
        return -1;
      }
      if (paramInt == i)
      {
        AppMethodBeat.o(270459);
        return -1;
      }
      AppMethodBeat.o(270459);
      return paramInt - i - 1;
    }
    
    public final void a(RecyclerView.v paramv, int paramInt, List<Object> paramList)
    {
      AppMethodBeat.i(270462);
      p.k(paramv, "holder");
      p.k(paramList, "payloads");
      i(paramv, paramInt);
      AppMethodBeat.o(270462);
    }
    
    public final RecyclerView.v b(ViewGroup paramViewGroup, int paramInt)
    {
      boolean bool = false;
      AppMethodBeat.i(270461);
      p.k(paramViewGroup, "parent");
      switch (paramInt)
      {
      case 4: 
      case 5: 
      default: 
        paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(b.g.finder_mix_search_media_item, paramViewGroup, false);
        p.j(paramViewGroup, "convertView");
        paramViewGroup = (RecyclerView.v)new ch(paramViewGroup);
        AppMethodBeat.o(270461);
        return paramViewGroup;
      case 1: 
        localObject = g.d(g.this);
        if (localObject == null) {
          p.iCn();
        }
        localObject = ((MMActivity)localObject).getLayoutInflater();
        if (this.AbD) {}
        for (paramInt = b.g.finder_mix_search_contact_header_night_mode;; paramInt = b.g.finder_mix_search_contact_header)
        {
          localObject = ((LayoutInflater)localObject).inflate(paramInt, paramViewGroup, false);
          p.j(localObject, "headerLayout");
          paramViewGroup = paramViewGroup.getResources().getString(b.j.finder_search_contact_title);
          p.j(paramViewGroup, "parent.resources.getStri…der_search_contact_title)");
          paramViewGroup = (RecyclerView.v)new b((View)localObject, paramViewGroup);
          AppMethodBeat.o(270461);
          return paramViewGroup;
        }
      case 8: 
        localObject = g.d(g.this);
        if (localObject == null) {
          p.iCn();
        }
        localObject = ((MMActivity)localObject).getLayoutInflater();
        if (this.AbD) {}
        for (paramInt = b.g.finder_mix_search_contact_header_night_mode;; paramInt = b.g.finder_mix_search_contact_header)
        {
          localObject = ((LayoutInflater)localObject).inflate(paramInt, paramViewGroup, false);
          p.j(localObject, "headerLayout");
          paramViewGroup = paramViewGroup.getResources().getString(b.j.finder_search_live_contact_title);
          p.j(paramViewGroup, "parent.resources.getStri…earch_live_contact_title)");
          paramViewGroup = (RecyclerView.v)new b((View)localObject, paramViewGroup);
          AppMethodBeat.o(270461);
          return paramViewGroup;
        }
      case 2: 
        localObject = g.d(g.this);
        if (localObject == null) {
          p.iCn();
        }
        localObject = ((MMActivity)localObject).getLayoutInflater();
        if (this.AbD) {}
        for (paramInt = b.g.finder_contact_search_item_night_mode;; paramInt = b.g.finder_contact_search_item)
        {
          paramViewGroup = ((LayoutInflater)localObject).inflate(paramInt, paramViewGroup, false);
          p.j(paramViewGroup, "contactLayout");
          if (!this.AbD) {
            bool = true;
          }
          paramViewGroup = (RecyclerView.v)new c(paramViewGroup, bool);
          AppMethodBeat.o(270461);
          return paramViewGroup;
        }
      case 3: 
        localObject = LayoutInflater.from(paramViewGroup.getContext()).inflate(b.g.finder_feed_search_header_item, paramViewGroup, false);
        p.j(localObject, "convertView");
        paramViewGroup = paramViewGroup.getResources().getString(b.j.finder_search_feed_header);
        p.j(paramViewGroup, "parent.resources.getStri…inder_search_feed_header)");
        paramViewGroup = (RecyclerView.v)new d((View)localObject, paramViewGroup);
        AppMethodBeat.o(270461);
        return paramViewGroup;
      case 9: 
        paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(b.g.finder_feed_search_safety_hint, paramViewGroup, false);
        p.j(paramViewGroup, "convertView");
        paramViewGroup = (RecyclerView.v)new e(paramViewGroup);
        AppMethodBeat.o(270461);
        return paramViewGroup;
      case 6: 
        localObject = LayoutInflater.from(paramViewGroup.getContext());
        if (this.AbD) {}
        for (paramInt = b.g.finder_feed_search_header_item_night;; paramInt = b.g.finder_feed_search_header_item)
        {
          localObject = ((LayoutInflater)localObject).inflate(paramInt, paramViewGroup, false);
          p.j(localObject, "convertView");
          paramViewGroup = paramViewGroup.getResources().getString(b.j.finder_search_feed_live_header);
          p.j(paramViewGroup, "parent.resources.getStri…_search_feed_live_header)");
          paramViewGroup = (RecyclerView.v)new d((View)localObject, paramViewGroup);
          AppMethodBeat.o(270461);
          return paramViewGroup;
        }
      }
      Object localObject = LayoutInflater.from(paramViewGroup.getContext());
      if (this.AbD) {}
      for (paramInt = b.g.nearby_feed_live_friends_item_night_mode;; paramInt = b.g.nearby_feed_live_friends_item)
      {
        paramViewGroup = ((LayoutInflater)localObject).inflate(paramInt, paramViewGroup, false);
        p.j(paramViewGroup, "convertView");
        paramViewGroup = (RecyclerView.v)new cg(paramViewGroup, g.e(g.this));
        AppMethodBeat.o(270461);
        return paramViewGroup;
      }
    }
    
    public final void d(RecyclerView.v paramv, int paramInt)
    {
      AppMethodBeat.i(270464);
      p.k(paramv, "holder");
      i(paramv, paramInt);
      AppMethodBeat.o(270464);
    }
    
    public final List<BaseFinderFeed> dQT()
    {
      AppMethodBeat.i(270457);
      List localList = g.a(g.this).dor();
      AppMethodBeat.o(270457);
      return localList;
    }
    
    public final int getItemCount()
    {
      int j = 1;
      AppMethodBeat.i(166832);
      int i;
      if (Util.isNullOrNil(dQO()))
      {
        i = 0;
        if (((Collection)g.a(g.this).dor()).isEmpty()) {
          break label92;
        }
      }
      for (;;)
      {
        if (j == 0) {
          break label97;
        }
        j = g.b(g.this);
        int k = g.a(g.this).dor().size();
        AppMethodBeat.o(166832);
        return j + k + 1 + i;
        i = 1;
        break;
        label92:
        j = 0;
      }
      label97:
      j = g.b(g.this);
      AppMethodBeat.o(166832);
      return j + i;
    }
    
    public final int getItemViewType(int paramInt)
    {
      int i = 0;
      AppMethodBeat.i(166833);
      f.a locala = g.a(g.this);
      if (locala == null) {
        p.iCn();
      }
      locala.dor();
      int k = g.b(g.this);
      int j;
      if (!Util.isNullOrNil(g.a(g.this).dQO()))
      {
        j = 1;
        if ((j == 0) || (paramInt != 0)) {
          break label92;
        }
      }
      for (;;)
      {
        if ((paramInt != 0) || (j == 0)) {
          break label108;
        }
        AppMethodBeat.o(166833);
        return 9;
        j = 0;
        break;
        label92:
        if (j != 0) {
          i = paramInt - 1;
        } else {
          i = paramInt;
        }
      }
      label108:
      if (i < k)
      {
        if (i == 0)
        {
          if (g.c(g.this))
          {
            AppMethodBeat.o(166833);
            return 8;
          }
          AppMethodBeat.o(166833);
          return 1;
        }
        AppMethodBeat.o(166833);
        return 2;
      }
      if (i == k)
      {
        if (g.c(g.this))
        {
          AppMethodBeat.o(166833);
          return 6;
        }
        AppMethodBeat.o(166833);
        return 3;
      }
      if (g.c(g.this))
      {
        AppMethodBeat.o(166833);
        return 7;
      }
      AppMethodBeat.o(166833);
      return 4;
    }
    
    public final void n(RecyclerView.v paramv)
    {
      boolean bool2 = true;
      AppMethodBeat.i(270460);
      p.k(paramv, "holder");
      super.n(paramv);
      Object localObject = paramv.amk;
      p.j(localObject, "holder.itemView");
      localObject = ((View)localObject).getLayoutParams();
      if ((localObject != null) && ((localObject instanceof StaggeredGridLayoutManager.LayoutParams)))
      {
        localObject = (StaggeredGridLayoutManager.LayoutParams)localObject;
        bool1 = bool2;
        if (paramv.mg() != 1)
        {
          bool1 = bool2;
          if (paramv.mg() != 8)
          {
            bool1 = bool2;
            if (paramv.mg() != 2)
            {
              bool1 = bool2;
              if (paramv.mg() != 3)
              {
                bool1 = bool2;
                if (paramv.mg() != 6) {
                  if (paramv.mg() != 9) {
                    break label137;
                  }
                }
              }
            }
          }
        }
      }
      label137:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        ((StaggeredGridLayoutManager.LayoutParams)localObject).aA(bool1);
        AppMethodBeat.o(270460);
        return;
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(g.b paramb) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(166829);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$MixSearchProfileAdapter$bindData$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        g.a(this.AbE.AbB).dQP();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$MixSearchProfileAdapter$bindData$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(166829);
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b
      implements View.OnClickListener
    {
      b(g.b paramb, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(166830);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$MixSearchProfileAdapter$bindData$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        p.j(paramView, "it");
        paramView = paramView.getTag();
        if (paramView == null)
        {
          paramView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSearchInfo");
          AppMethodBeat.o(166830);
          throw paramView;
        }
        bip localbip = (bip)paramView;
        paramView = localbip.contact;
        if ((paramView != null) && (paramView.liveStatus == 1))
        {
          k localk = k.yBj;
          paramView = localbip.contact;
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
          localk.a(null, paramView, paramInt, s.t.yGP, "23");
        }
        g.a(this.AbE.AbB).a(localbip, paramInt - 1);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$MixSearchProfileAdapter$bindData$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(166830);
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke"})
    static final class c
      extends q
      implements kotlin.g.a.b<Integer, kotlin.x>
    {
      c(g.b paramb, BaseFinderFeed paramBaseFinderFeed, int paramInt)
      {
        super();
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke"})
    static final class d
      extends q
      implements kotlin.g.a.b<Integer, kotlin.x>
    {
      d(g.b paramb, BaseFinderFeed paramBaseFinderFeed, int paramInt)
      {
        super();
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$SpacesItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "space", "", "(Lcom/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback;I)V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "setFeedDecoration", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "plugin-finder_release"})
  public final class c
    extends RecyclerView.h
  {
    private final int space;
    
    public c()
    {
      int i;
      this.space = i;
    }
    
    private final void a(Rect paramRect, RecyclerView.v paramv)
    {
      AppMethodBeat.i(281863);
      int i = (int)(this.space / 2.0F);
      paramRect.top = this.space;
      paramv = paramv.amk;
      p.j(paramv, "holder.itemView");
      paramv = paramv.getLayoutParams();
      if ((paramv != null) && ((paramv instanceof StaggeredGridLayoutManager.LayoutParams)))
      {
        if (((StaggeredGridLayoutManager.LayoutParams)paramv).kv() == 0)
        {
          paramRect.left = this.space;
          paramRect.right = i;
          AppMethodBeat.o(281863);
          return;
        }
        paramRect.left = i;
        paramRect.right = this.space;
        AppMethodBeat.o(281863);
        return;
      }
      paramRect.left = this.space;
      paramRect.right = this.space;
      AppMethodBeat.o(281863);
    }
    
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(281862);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramRect);
      localb.bn(paramView);
      localb.bn(paramRecyclerView);
      localb.bn(params);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$SpacesItemDecoration", "com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$SpacesItemDecorationandroidx/recyclerview/widget/RecyclerView$ItemDecoration", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V", this, localb.aFi());
      p.k(paramRect, "outRect");
      p.k(paramView, "view");
      p.k(paramRecyclerView, "parent");
      p.k(params, "state");
      int i = RecyclerView.bh(paramView);
      paramView = paramRecyclerView.aQ(paramView);
      paramRecyclerView = g.this.jLl.getAdapter();
      if (paramRecyclerView == null) {
        p.iCn();
      }
      p.j(paramRecyclerView, "recyclerView.adapter!!");
      if (i != paramRecyclerView.getItemCount() - 1)
      {
        paramRecyclerView = g.this.jLl.getAdapter();
        if (paramRecyclerView == null) {
          p.iCn();
        }
        p.j(paramRecyclerView, "recyclerView.adapter!!");
        if (i != paramRecyclerView.getItemCount() - 2) {}
      }
      else
      {
        paramRect.bottom = (this.space * 2);
        if (g.b(g.this) != 0) {
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
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$SpacesItemDecoration", "com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$SpacesItemDecorationandroidx/recyclerview/widget/RecyclerView$ItemDecoration", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V");
        AppMethodBeat.o(281862);
        return;
        paramRect.bottom = 0;
        break;
        label234:
        p.j(paramView, "holder");
        a(paramRect, paramView);
        continue;
        label249:
        if (i <= g.b(g.this))
        {
          paramRect.right = 0;
          paramRect.top = 0;
          paramRect.left = 0;
          paramRect.bottom = 0;
        }
        else
        {
          p.j(paramView, "holder");
          a(paramRect, paramView);
          if (i <= g.b(g.this) + 2) {
            paramRect.top = 0;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.search.g
 * JD-Core Version:    0.7.0.1
 */