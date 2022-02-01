package com.tencent.mm.plugin.finder.viewmodel.component;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.x;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.g;
import com.tencent.mm.plugin.finder.feed.component.d.a;
import com.tencent.mm.plugin.finder.feed.flow.FlowLayoutManager;
import com.tencent.mm.plugin.finder.feed.model.n;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.report.bb;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.upload.action.o;
import com.tencent.mm.plugin.finder.upload.action.o.a;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.view.FinderWordingLayout;
import com.tencent.mm.plugin.finder.view.FinderWordingLayout.b;
import com.tencent.mm.protocal.protobuf.ayj;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.to;
import com.tencent.mm.protocal.protobuf.tp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.e;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.i.c;
import com.tencent.mm.view.recyclerview.j;
import com.tencent.threadpool.h;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.a.p;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.l;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFeedWordingUIC;", "Lcom/tencent/mm/plugin/finder/viewmodel/component/IFinderDescPanelItem;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderWordingUIC;", "Lcom/tencent/mm/plugin/finder/feed/component/IFeedInfoAsyncLoader;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "buzzwordLiveDataMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mm/protocal/protobuf/BuzzwordInfo;", "favFeedCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "", "wordingLayoutRef", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/finder/view/FinderWordingLayout;", "animateWordingHide", "holder", "wordingLayout", "Landroid/view/View;", "fromUser", "", "animateWordingShow", "buzzwordLiveData", "feedId", "cancelAllLike", "changeData", "feed", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "buzzwordId", "likeOp", "", "disableStar", "enableStar", "getContentView", "hide", "hideWordingLayout", "withAnimate", "isNeedShow", "onBackPressed", "onBindView", "isSelf", "onCreateBefore", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFocusFeed", "isFirstTime", "lastFeedId", "newFeedId", "onInterceptFinish", "onPause", "onResume", "refreshDeleteStatus", "refreshWordingItem", "request", "feedList", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "show", "showWordingLayout", "tryGetWordingLayout", "Companion", "WordingClickListener", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class v
  extends bh
  implements com.tencent.mm.plugin.finder.feed.component.i, com.tencent.mm.plugin.findersdk.a.cc
{
  public static final a GPE;
  private final ConcurrentHashMap<Long, x<tp>> GPF;
  private WeakReference<FinderWordingLayout> GPG;
  private kotlin.g.a.b<? super j, ah> GPH;
  
  static
  {
    AppMethodBeat.i(338121);
    GPE = new a((byte)0);
    AppMethodBeat.o(338121);
  }
  
  public v(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(338009);
    this.GPF = new ConcurrentHashMap();
    AppMethodBeat.o(338009);
  }
  
  public static void V(j paramj)
  {
    AppMethodBeat.i(338025);
    s.u(paramj, "holder");
    paramj = W(paramj);
    if (paramj == null)
    {
      AppMethodBeat.o(338025);
      return;
    }
    paramj = ((Iterable)paramj.getDataList()).iterator();
    while (paramj.hasNext())
    {
      n localn = (n)paramj.next();
      o.a locala = o.Gds;
      if (o.fel().a(localn))
      {
        locala = o.Gds;
        o.fel().a(localn, false);
      }
    }
    AppMethodBeat.o(338025);
  }
  
  private static FinderWordingLayout W(j paramj)
  {
    AppMethodBeat.i(338033);
    paramj = (FinderWordingLayout)paramj.UH(e.e.finder_feed_wording_attribute_layout);
    AppMethodBeat.o(338033);
    return paramj;
  }
  
  private static final void a(View paramView, boolean paramBoolean, final v paramv, final j paramj)
  {
    AppMethodBeat.i(338095);
    s.u(paramView, "$wordingLayout");
    s.u(paramv, "this$0");
    s.u(paramj, "$holder");
    ViewPropertyAnimator localViewPropertyAnimator = paramView.animate().alpha(1.0F);
    if (paramBoolean)
    {
      paramView.setPivotX(paramView.getWidth() / 2.0F);
      paramView.setPivotY(paramView.getHeight() * 1.0F);
      paramView.setScaleX(0.0F);
      paramView.setScaleY(0.0F);
      localViewPropertyAnimator.scaleX(1.0F).scaleY(1.0F);
    }
    localViewPropertyAnimator.setDuration(250L).setListener((Animator.AnimatorListener)new d(paramView, paramv, paramj)).start();
    AppMethodBeat.o(338095);
  }
  
  public static void a(com.tencent.mm.plugin.finder.model.cc paramcc, j paramj, long paramLong)
  {
    AppMethodBeat.i(338045);
    s.u(paramcc, "feed");
    s.u(paramj, "holder");
    if ((paramcc instanceof BaseFinderFeed)) {}
    for (paramcc = (BaseFinderFeed)paramcc; paramcc == null; paramcc = null)
    {
      AppMethodBeat.o(338045);
      return;
    }
    paramj = (FinderWordingLayout)paramj.UH(e.e.finder_feed_wording_attribute_layout);
    if (paramj == null)
    {
      AppMethodBeat.o(338045);
      return;
    }
    long l = paramcc.bZA();
    Object localObject1 = ((Iterable)paramj.pUj).iterator();
    Object localObject2;
    int i;
    if (((Iterator)localObject1).hasNext())
    {
      paramcc = ((Iterator)localObject1).next();
      localObject2 = (n)paramcc;
      if ((((n)localObject2).feedId == l) && (((n)localObject2).YZe == paramLong))
      {
        i = 1;
        label137:
        if (i == 0) {
          break label280;
        }
      }
    }
    for (;;)
    {
      paramcc = (n)paramcc;
      if (paramcc == null) {
        break label324;
      }
      s.u(paramcc, "item");
      localObject1 = ((Iterable)paramj.pUj).iterator();
      i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        if (i < 0) {
          p.kkW();
        }
        if (((n)localObject2).YZe == paramcc.YZe)
        {
          if ((i > 0) && (i < paramj.getDataList().size())) {
            paramj.getDataList().set(i, paramcc);
          }
          localObject2 = paramj.getRecyclerView().getAdapter();
          if (localObject2 != null) {
            ((RecyclerView.a)localObject2).fV(i);
          }
        }
        i += 1;
      }
      i = 0;
      break label137;
      label280:
      break;
      paramcc = null;
    }
    localObject1 = o.Gds;
    if (!o.fel().qC(paramcc.feedId))
    {
      localObject1 = o.Gds;
      o.fel().qD(paramcc.feedId);
      paramj.notifyDataSetChanged();
    }
    label324:
    AppMethodBeat.o(338045);
  }
  
  private static final void a(final FinderWordingLayout paramFinderWordingLayout, BaseFinderFeed paramBaseFinderFeed, final v paramv, final j paramj, boolean paramBoolean, tp paramtp)
  {
    AppMethodBeat.i(338085);
    s.u(paramFinderWordingLayout, "$wordingLayout");
    s.u(paramBaseFinderFeed, "$item");
    s.u(paramv, "this$0");
    s.u(paramj, "$holder");
    i.c localc = (i.c)new b(paramv, paramBaseFinderFeed, paramj);
    s.u(paramBaseFinderFeed, "item");
    Object localObject1;
    Object localObject2;
    label102:
    int i;
    if (paramtp == null)
    {
      localObject1 = null;
      paramFinderWordingLayout.AUZ = paramBaseFinderFeed;
      paramFinderWordingLayout.GDV = paramtp;
      paramFinderWordingLayout.AXX = paramBoolean;
      localObject2 = paramFinderWordingLayout.getRecyclerView().getLayoutManager();
      if (!(localObject2 instanceof FlowLayoutManager)) {
        break label284;
      }
      localObject2 = (FlowLayoutManager)localObject2;
      if (localObject2 != null)
      {
        if (!paramFinderWordingLayout.AXX) {
          break label290;
        }
        i = 2147483647;
        label119:
        ((FlowLayoutManager)localObject2).maxLines = i;
      }
      if ((paramtp == null) || (Util.isNullOrNil((List)localObject1))) {
        break label528;
      }
      FinderWordingLayout.a(paramFinderWordingLayout);
      if (!paramFinderWordingLayout.AXX) {
        break label296;
      }
      localObject2 = av.GiL;
      if (!av.e(paramBaseFinderFeed)) {
        break label296;
      }
      i = 1;
      label168:
      if (i == 0) {
        break label302;
      }
      paramFinderWordingLayout.getManageBtn().setVisibility(0);
    }
    for (;;)
    {
      s.checkNotNull(localObject1);
      localObject2 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        to localto = (to)((Iterator)localObject2).next();
        s.s(localto, "it");
        ((Collection)localObject1).add(new n(paramBaseFinderFeed, localto, paramBoolean));
      }
      localObject1 = paramtp.nUC;
      break;
      label284:
      localObject2 = null;
      break label102;
      label290:
      i = 3;
      break label119;
      label296:
      i = 0;
      break label168;
      label302:
      paramFinderWordingLayout.getManageBtn().setVisibility(8);
    }
    paramFinderWordingLayout.setWordingList((List)localObject1);
    paramFinderWordingLayout.setItemClickListener(localc);
    if ((paramBoolean) && (!Util.isNullOrNil((List)paramtp.nUC)))
    {
      paramBaseFinderFeed = com.tencent.mm.svg.a.a.i(paramj.context.getResources(), e.g.finder_icons_filled_star_self);
      i = com.tencent.mm.cd.a.w(paramj.context, e.b.hot_tab_BW_100_Alpha_0_8);
      localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.eXJ().bmg()).intValue() == 1)
      {
        localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
        if (((Number)com.tencent.mm.plugin.finder.storage.d.eXK().bmg()).intValue() != 0) {
          break label542;
        }
        ((TextView)paramj.UH(e.e.star_count_tv)).setTextColor(i);
        ((WeImageView)paramj.UH(e.e.icon_feed_star)).setImageDrawable(paramBaseFinderFeed);
        ((WeImageView)paramj.UH(e.e.icon_feed_star)).setIconColor(i);
        paramj.UH(e.e.star_icon_container).setEnabled(true);
      }
    }
    for (;;)
    {
      paramFinderWordingLayout.setSizeChangeListener((kotlin.g.a.a)new e(paramv, paramj));
      paramFinderWordingLayout.setItemRemoveListener((kotlin.g.a.b)new f(paramtp, paramFinderWordingLayout, paramv, paramj));
      paramFinderWordingLayout.setOnModeChangeListener((m)new g(paramj, paramv));
      AppMethodBeat.o(338085);
      return;
      label528:
      paramFinderWordingLayout.setVisibility(8);
      paramFinderWordingLayout.setItemClickListener(null);
      break;
      label542:
      ((TextView)paramj.UH(e.e.star_count_tv_first)).setTextColor(i);
      ((WeImageView)paramj.UH(e.e.icon_feed_star_first)).setImageDrawable(paramBaseFinderFeed);
      ((WeImageView)paramj.UH(e.e.icon_feed_star_first)).setIconColor(i);
      paramj.UH(e.e.star_icon_container_first).setEnabled(true);
    }
  }
  
  public static void b(com.tencent.mm.plugin.finder.model.cc paramcc, j paramj, long paramLong)
  {
    AppMethodBeat.i(338056);
    s.u(paramcc, "feed");
    s.u(paramj, "holder");
    if ((paramcc instanceof BaseFinderFeed)) {}
    for (paramcc = (BaseFinderFeed)paramcc; paramcc == null; paramcc = null)
    {
      AppMethodBeat.o(338056);
      return;
    }
    paramj = (FinderWordingLayout)paramj.UH(e.e.finder_feed_wording_attribute_layout);
    if (paramj == null)
    {
      AppMethodBeat.o(338056);
      return;
    }
    long l = paramcc.bZA();
    paramcc = ((List)paramj.pUj).iterator();
    int i = 0;
    Object localObject;
    int j;
    if (paramcc.hasNext())
    {
      localObject = (n)paramcc.next();
      if ((((n)localObject).feedId == l) && (((n)localObject).YZe == paramLong))
      {
        j = 1;
        label135:
        if (j == 0) {
          break label249;
        }
      }
    }
    for (;;)
    {
      if (i >= 0)
      {
        paramcc = paramj.pUj.remove(i);
        s.s(paramcc, "dataList.removeAt(index)");
        paramcc = (n)paramcc;
        localObject = paramj.getRecyclerView().getAdapter();
        if (localObject != null) {
          ((RecyclerView.a)localObject).fX(i);
        }
        localObject = paramj.getRecyclerView().getAdapter();
        if (localObject != null) {
          ((RecyclerView.a)localObject).by(i, paramj.pUj.size() - i);
        }
        paramj = paramj.getItemRemoveListener();
        if (paramj != null) {
          paramj.invoke(paramcc);
        }
      }
      AppMethodBeat.o(338056);
      return;
      j = 0;
      break label135;
      label249:
      i += 1;
      break;
      i = -1;
    }
  }
  
  private final FinderWordingLayout fnA()
  {
    AppMethodBeat.i(338062);
    Object localObject = this.GPG;
    if (localObject == null)
    {
      AppMethodBeat.o(338062);
      return null;
    }
    localObject = (FinderWordingLayout)((WeakReference)localObject).get();
    AppMethodBeat.o(338062);
    return localObject;
  }
  
  private final x<tp> rh(long paramLong)
  {
    AppMethodBeat.i(338016);
    Object localObject2 = (ConcurrentMap)this.GPF;
    Long localLong = Long.valueOf(paramLong);
    Object localObject1 = ((ConcurrentMap)localObject2).get(localLong);
    if (localObject1 == null)
    {
      x localx = new x();
      localObject2 = ((ConcurrentMap)localObject2).putIfAbsent(localLong, localx);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = localx;
      }
    }
    for (;;)
    {
      s.s(localObject1, "buzzwordLiveDataMap.getO…Id) { MutableLiveData() }");
      localObject1 = (x)localObject1;
      AppMethodBeat.o(338016);
      return localObject1;
    }
  }
  
  public final boolean R(j paramj)
  {
    AppMethodBeat.i(338180);
    s.u(paramj, "holder");
    Object localObject = paramj.CSA;
    if ((localObject instanceof BaseFinderFeed)) {}
    for (localObject = (BaseFinderFeed)localObject; localObject == null; localObject = null)
    {
      AppMethodBeat.o(338180);
      return false;
    }
    localObject = (tp)rh(((BaseFinderFeed)localObject).bZA()).getValue();
    if (localObject == null)
    {
      AppMethodBeat.o(338180);
      return false;
    }
    if ((W(paramj) != null) && (!Util.isNullOrNil((List)((tp)localObject).nUC)))
    {
      AppMethodBeat.o(338180);
      return true;
    }
    AppMethodBeat.o(338180);
    return false;
  }
  
  public final View S(j paramj)
  {
    AppMethodBeat.i(338192);
    s.u(paramj, "holder");
    paramj = (View)W(paramj);
    AppMethodBeat.o(338192);
    return paramj;
  }
  
  public final void a(com.tencent.mm.plugin.finder.model.cc paramcc, j paramj, long paramLong, int paramInt)
  {
    AppMethodBeat.i(338261);
    s.u(paramcc, "feed");
    s.u(paramj, "holder");
    if ((paramcc instanceof BaseFinderFeed)) {}
    for (Object localObject = (BaseFinderFeed)paramcc; localObject == null; localObject = null)
    {
      AppMethodBeat.o(338261);
      return;
    }
    paramcc = (tp)rh(((BaseFinderFeed)localObject).bZA()).getValue();
    if (paramcc == null) {
      paramcc = null;
    }
    while (paramcc == null)
    {
      AppMethodBeat.o(338261);
      return;
      paramcc = paramcc.nUC;
      if (paramcc == null)
      {
        paramcc = null;
      }
      else
      {
        Iterator localIterator = ((Iterable)paramcc).iterator();
        label108:
        if (localIterator.hasNext())
        {
          paramcc = localIterator.next();
          if (((to)paramcc).YZe == paramLong)
          {
            i = 1;
            if (i == 0) {
              break label158;
            }
          }
        }
        for (;;)
        {
          label141:
          paramcc = (to)paramcc;
          break;
          i = 0;
          break label141;
          label158:
          break label108;
          paramcc = null;
        }
      }
    }
    if (paramInt == 1)
    {
      l = paramcc.YZf;
      if (paramcc.hJr == 1) {}
      for (i = 0;; i = 1)
      {
        paramcc.YZf = (l + i);
        paramcc.hJr = paramInt;
        paramcc = (FinderWordingLayout)paramj.UH(e.e.finder_feed_wording_attribute_layout);
        if (paramcc != null) {
          break;
        }
        AppMethodBeat.o(338261);
        return;
      }
    }
    long l = paramcc.YZf;
    if (paramcc.hJr == 1) {}
    for (int i = -1;; i = 0)
    {
      paramcc.YZf = (l + i);
      break;
    }
    l = ((BaseFinderFeed)localObject).bZA();
    paramj = ((Iterable)paramcc.pUj).iterator();
    if (paramj.hasNext())
    {
      paramcc = paramj.next();
      localObject = (n)paramcc;
      if ((((n)localObject).feedId == l) && (((n)localObject).YZe == paramLong))
      {
        i = 1;
        label334:
        if (i == 0) {
          break label396;
        }
        label339:
        paramcc = (n)paramcc;
        if (paramcc != null)
        {
          if (paramInt != 1) {
            break label409;
          }
          paramLong = paramcc.YZf;
          if (paramcc.hJr != 1) {
            break label403;
          }
        }
      }
    }
    label396:
    label403:
    for (i = 0;; i = 1)
    {
      paramcc.YZf = (paramLong + i);
      paramcc.hJr = paramInt;
      AppMethodBeat.o(338261);
      return;
      i = 0;
      break label334;
      break;
      paramcc = null;
      break label339;
    }
    label409:
    paramLong = paramcc.YZf;
    if (paramcc.hJr == 1) {}
    for (i = -1;; i = 0)
    {
      paramcc.YZf = (paramLong + i);
      break;
    }
  }
  
  public final void a(com.tencent.mm.plugin.finder.model.cc paramcc, j paramj, boolean paramBoolean, kotlin.g.a.b<? super j, ah> paramb)
  {
    MMActivity localMMActivity = null;
    AppMethodBeat.i(338241);
    s.u(paramcc, "feed");
    s.u(paramj, "holder");
    s.u(paramb, "favFeedCallback");
    if ((paramcc instanceof BaseFinderFeed)) {}
    for (paramcc = (BaseFinderFeed)paramcc; paramcc == null; paramcc = null)
    {
      AppMethodBeat.o(338241);
      return;
    }
    FinderWordingLayout localFinderWordingLayout = W(paramj);
    if (localFinderWordingLayout == null)
    {
      AppMethodBeat.o(338241);
      return;
    }
    Object localObject = paramj.context;
    if ((localObject instanceof MMActivity)) {
      localMMActivity = (MMActivity)localObject;
    }
    if (localMMActivity == null)
    {
      AppMethodBeat.o(338241);
      return;
    }
    localFinderWordingLayout.setVisibility(8);
    int i;
    if (paramBoolean)
    {
      localObject = com.tencent.mm.svg.a.a.i(paramj.context.getResources(), e.g.finder_icons_filled_star);
      i = com.tencent.mm.cd.a.w(paramj.context, e.b.finder_btn_fullscreen_disable_color);
      com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.eXJ().bmg()).intValue() == 1)
      {
        locald = com.tencent.mm.plugin.finder.storage.d.FAy;
        if (((Number)com.tencent.mm.plugin.finder.storage.d.eXK().bmg()).intValue() != 0) {
          break label289;
        }
        ((TextView)paramj.UH(e.e.star_count_tv)).setTextColor(i);
        ((WeImageView)paramj.UH(e.e.icon_feed_star)).setImageDrawable((Drawable)localObject);
        ((WeImageView)paramj.UH(e.e.icon_feed_star)).setIconColor(i);
        paramj.UH(e.e.star_icon_container).setEnabled(false);
      }
    }
    for (;;)
    {
      this.GPH = paramb;
      com.tencent.mm.ae.d.a((LiveData)rh(paramcc.bZA()), (androidx.lifecycle.q)localMMActivity, new v..ExternalSyntheticLambda0(localFinderWordingLayout, paramcc, this, paramj, paramBoolean));
      AppMethodBeat.o(338241);
      return;
      label289:
      ((TextView)paramj.UH(e.e.star_count_tv_first)).setTextColor(i);
      ((WeImageView)paramj.UH(e.e.icon_feed_star_first)).setImageDrawable((Drawable)localObject);
      ((WeImageView)paramj.UH(e.e.icon_feed_star_first)).setIconColor(i);
      paramj.UH(e.e.star_icon_container_first).setEnabled(false);
    }
  }
  
  public final void b(j paramj, boolean paramBoolean, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(338248);
    s.u(paramj, "holder");
    paramj = W(paramj);
    if (paramj == null)
    {
      AppMethodBeat.o(338248);
      return;
    }
    this.GPG = new WeakReference(paramj);
    AppMethodBeat.o(338248);
  }
  
  public final void d(j paramj, boolean paramBoolean)
  {
    AppMethodBeat.i(338161);
    s.u(paramj, "holder");
    FinderWordingLayout localFinderWordingLayout = W(paramj);
    Object localObject1;
    int i;
    if ((localFinderWordingLayout != null) && (localFinderWordingLayout.getVisibility() != 0))
    {
      localObject1 = paramj.CSA;
      if ((localObject1 instanceof BaseFinderFeed)) {
        localObject1 = (BaseFinderFeed)localObject1;
      }
      while (localObject1 != null)
      {
        Object localObject3 = (tp)rh(((BaseFinderFeed)localObject1).bZA()).getValue();
        if (localObject3 != null) {
          if (Util.isNullOrNil((List)((tp)localObject3).nUC))
          {
            localFinderWordingLayout.setVisibility(8);
            AppMethodBeat.o(338161);
            return;
            localObject1 = null;
          }
          else
          {
            Object localObject2 = new JSONArray();
            localObject3 = ((tp)localObject3).nUC;
            s.s(localObject3, "buzzwordItem.items");
            Object localObject4 = (Iterable)localObject3;
            localObject3 = (Collection)new ArrayList(p.a((Iterable)localObject4, 10));
            localObject4 = ((Iterable)localObject4).iterator();
            while (((Iterator)localObject4).hasNext())
            {
              to localto = (to)((Iterator)localObject4).next();
              ((Collection)localObject3).add(localto.wording + '|' + localto.YZf);
            }
            localObject3 = ((Iterable)localObject3).iterator();
            while (((Iterator)localObject3).hasNext()) {
              ((JSONArray)localObject2).put((String)((Iterator)localObject3).next());
            }
            localObject3 = new JSONObject();
            ((JSONObject)localObject3).put("feedid", com.tencent.mm.plugin.expt.hellhound.core.b.hF(((BaseFinderFeed)localObject1).bZA()));
            ((JSONObject)localObject3).put("buzz_words", localObject2);
            if (!paramBoolean) {
              break label451;
            }
            i = 1;
            ((JSONObject)localObject3).put("expose_type", i);
            localObject1 = as.GSQ;
            localObject1 = paramj.context;
            s.s(localObject1, "holder.context");
            localObject1 = as.a.hu((Context)localObject1);
            if (localObject1 != null) {
              break label456;
            }
            localObject1 = null;
            label367:
            localObject2 = bb.FuK;
            bb.a((bui)localObject1, "buzz_bar", false, (JSONObject)localObject3);
            localObject1 = (View)localFinderWordingLayout;
            ((View)localObject1).setVisibility(0);
            ((View)localObject1).setAlpha(0.0F);
            ((View)localObject1).setScaleX(1.0F);
            ((View)localObject1).setScaleY(1.0F);
            if (!paramBoolean) {
              break label466;
            }
          }
        }
      }
    }
    label451:
    label456:
    label466:
    for (long l = 0L;; l = 150L)
    {
      h.ahAA.o(new v..ExternalSyntheticLambda1((View)localObject1, paramBoolean, this, paramj), l);
      AppMethodBeat.o(338161);
      return;
      i = 0;
      break;
      localObject1 = ((as)localObject1).fou();
      break label367;
    }
  }
  
  public final void e(j paramj, boolean paramBoolean)
  {
    AppMethodBeat.i(338168);
    s.u(paramj, "holder");
    paramj = W(paramj);
    if ((paramj != null) && (paramj.getVisibility() == 0))
    {
      paramj = (View)paramj;
      ViewPropertyAnimator localViewPropertyAnimator = paramj.animate().alpha(0.0F);
      if (paramBoolean)
      {
        paramj.setPivotX(paramj.getWidth() / 2.0F);
        paramj.setPivotY(paramj.getHeight() * 1.0F);
        paramj.setScaleX(1.0F);
        paramj.setScaleY(1.0F);
        localViewPropertyAnimator.scaleX(0.0F).scaleY(0.0F);
      }
      localViewPropertyAnimator.setDuration(250L).setListener((Animator.AnimatorListener)new c(paramj)).start();
      AppMethodBeat.o(338168);
      return;
    }
    AppMethodBeat.o(338168);
  }
  
  public final void gb(List<? extends FinderItem> paramList)
  {
    AppMethodBeat.i(338287);
    s.u(paramList, "feedList");
    Object localObject = (Iterable)paramList;
    paramList = (Collection)new ArrayList(p.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramList.add(Long.valueOf(((FinderItem)((Iterator)localObject).next()).getId()));
    }
    paramList = (List)paramList;
    e.launch$default((e)this, null, null, (m)new h(paramList, this, null), 3, null);
    AppMethodBeat.o(338287);
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(338277);
    Object localObject = fnA();
    if (localObject == null) {}
    for (localObject = null; localObject == FinderWordingLayout.b.GDY; localObject = ((FinderWordingLayout)localObject).getCurrMode())
    {
      AppMethodBeat.o(338277);
      return true;
    }
    AppMethodBeat.o(338277);
    return false;
  }
  
  public final void onCreateBefore(Bundle paramBundle)
  {
    AppMethodBeat.i(338203);
    super.onCreateBefore(paramBundle);
    paramBundle = com.tencent.mm.plugin.finder.feed.component.d.Bca;
    paramBundle = d.a.edf();
    com.tencent.mm.plugin.finder.feed.component.i locali = (com.tencent.mm.plugin.finder.feed.component.i)this;
    s.u(locali, "loader");
    if (!paramBundle.Bcb.contains(locali))
    {
      paramBundle.Bcb.add(locali);
      AppMethodBeat.o(338203);
      return;
    }
    ((Map)paramBundle.Bcc).put(locali, Boolean.TRUE);
    AppMethodBeat.o(338203);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(338231);
    super.onDestroy();
    Object localObject = com.tencent.mm.plugin.finder.feed.component.d.Bca;
    localObject = d.a.edf();
    com.tencent.mm.plugin.finder.feed.component.i locali = (com.tencent.mm.plugin.finder.feed.component.i)this;
    s.u(locali, "loader");
    ((com.tencent.mm.plugin.finder.feed.component.d)localObject).Bcc.remove(locali);
    ((com.tencent.mm.plugin.finder.feed.component.d)localObject).Bcb.remove(locali);
    AppMethodBeat.o(338231);
  }
  
  public final boolean onInterceptFinish()
  {
    AppMethodBeat.i(338269);
    Object localObject = fnA();
    if (localObject == null) {}
    for (localObject = null; localObject == FinderWordingLayout.b.GDY; localObject = ((FinderWordingLayout)localObject).getCurrMode())
    {
      AppMethodBeat.o(338269);
      return true;
    }
    AppMethodBeat.o(338269);
    return false;
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(338223);
    super.onPause();
    Object localObject = com.tencent.mm.plugin.finder.feed.component.d.Bca;
    localObject = d.a.edf();
    com.tencent.mm.plugin.finder.feed.component.i locali = (com.tencent.mm.plugin.finder.feed.component.i)this;
    s.u(locali, "loader");
    ((Map)((com.tencent.mm.plugin.finder.feed.component.d)localObject).Bcc).put(locali, Boolean.FALSE);
    AppMethodBeat.o(338223);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(338217);
    super.onResume();
    Object localObject = com.tencent.mm.plugin.finder.feed.component.d.Bca;
    localObject = d.a.edf();
    com.tencent.mm.plugin.finder.feed.component.i locali = (com.tencent.mm.plugin.finder.feed.component.i)this;
    s.u(locali, "loader");
    ((Map)((com.tencent.mm.plugin.finder.feed.component.d)localObject).Bcc).put(locali, Boolean.TRUE);
    AppMethodBeat.o(338217);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFeedWordingUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFeedWordingUIC$WordingClickListener;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "feedHolder", "(Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFeedWordingUIC;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;)V", "wordingLayout", "Lcom/tencent/mm/plugin/finder/view/FinderWordingLayout;", "getWordingLayout", "()Lcom/tencent/mm/plugin/finder/view/FinderWordingLayout;", "onItemClick", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    implements i.c<j>
  {
    private final BaseFinderFeed GPI;
    private final j GPJ;
    private final FinderWordingLayout GPK;
    
    public b(j paramj)
    {
      AppMethodBeat.i(337630);
      this.GPI = paramj;
      this.GPJ = localObject;
      this.GPK = ((FinderWordingLayout)this.GPJ.UH(e.e.finder_feed_wording_attribute_layout));
      AppMethodBeat.o(337630);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/viewmodel/component/FinderFeedWordingUIC$animateWordingHide$1", "Lcom/tencent/mm/plugin/finder/animation/AnimatorEndListener;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends com.tencent.mm.plugin.finder.animation.a
  {
    c(View paramView) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(337662);
      this.GPM.setAlpha(0.0F);
      this.GPM.setScaleX(1.0F);
      this.GPM.setScaleY(1.0F);
      this.GPM.setVisibility(8);
      AppMethodBeat.o(337662);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/viewmodel/component/FinderFeedWordingUIC$animateWordingShow$1$1", "Lcom/tencent/mm/plugin/finder/animation/AnimatorEndListener;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends com.tencent.mm.plugin.finder.animation.a
  {
    d(View paramView, v paramv, j paramj) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(337666);
      this.GPM.setAlpha(1.0F);
      paramv.ab(paramj);
      AppMethodBeat.o(337666);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<ah>
  {
    e(v paramv, j paramj)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/FinderWordingItem;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.b<n, ah>
  {
    f(tp paramtp, FinderWordingLayout paramFinderWordingLayout, v paramv, j paramj)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "from", "Lcom/tencent/mm/plugin/finder/view/FinderWordingLayout$Mode;", "to"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements m<FinderWordingLayout.b, FinderWordingLayout.b, ah>
  {
    g(j paramj, v paramv)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    h(List<Long> paramList, v paramv, kotlin.d.d<? super h> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(337664);
      paramObject = (kotlin.d.d)new h(this.GPR, jdField_this, paramd);
      AppMethodBeat.o(337664);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(337659);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(337659);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
      }
      try
      {
        paramObject = (com.tencent.mm.am.b)new com.tencent.mm.plugin.finder.cgi.q(new LinkedList((Collection)this.GPR));
        localObject = (kotlin.d.d)this;
        this.label = 1;
        paramObject = com.tencent.mm.af.b.a(paramObject, (kotlin.d.d)localObject);
        localObject = paramObject;
        if (paramObject == locala)
        {
          AppMethodBeat.o(337659);
          return locala;
          ResultKt.throwOnFailure(paramObject);
          localObject = paramObject;
        }
        paramObject = (ayj)localObject;
      }
      catch (com.tencent.mm.af.a paramObject)
      {
        for (;;)
        {
          Object localObject;
          kotlin.d.d locald;
          Log.e("Finder.FeedWordingLogic", "request CgiFinderGetBuzzword fail, errType=" + paramObject.hDx + " errCode=" + paramObject.errorCode + " fail:" + paramObject.getLocalizedMessage());
          paramObject = null;
          continue;
          paramObject = paramObject.ZJd;
        }
        ResultKt.throwOnFailure(paramObject);
        paramObject = ah.aiuX;
        AppMethodBeat.o(337659);
      }
      if (paramObject == null)
      {
        paramObject = null;
        if (paramObject != null) {
          break label301;
        }
        paramObject = new LinkedList();
        Log.d("Finder.FeedWordingLogic", "request idList.size = " + this.GPR.size() + ", buzzInfoList.size = " + paramObject.size());
        localObject = (f)bg.kCh();
        paramObject = (m)new k(paramObject, jdField_this)
        {
          int label;
          
          public final kotlin.d.d<ah> create(Object paramAnonymousObject, kotlin.d.d<?> paramAnonymousd)
          {
            AppMethodBeat.i(338772);
            paramAnonymousObject = (kotlin.d.d)new 1(this.GPT, this.GPL, paramAnonymousd);
            AppMethodBeat.o(338772);
            return paramAnonymousObject;
          }
          
          public final Object invokeSuspend(Object paramAnonymousObject)
          {
            AppMethodBeat.i(338765);
            Object localObject = kotlin.d.a.a.aiwj;
            switch (this.label)
            {
            default: 
              paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
              AppMethodBeat.o(338765);
              throw paramAnonymousObject;
            }
            ResultKt.throwOnFailure(paramAnonymousObject);
            localObject = (Iterable)this.GPT;
            paramAnonymousObject = this.GPL;
            localObject = ((Iterable)localObject).iterator();
            while (((Iterator)localObject).hasNext())
            {
              tp localtp = (tp)((Iterator)localObject).next();
              v.a(paramAnonymousObject, localtp.object_id).t(localtp);
            }
            paramAnonymousObject = ah.aiuX;
            AppMethodBeat.o(338765);
            return paramAnonymousObject;
          }
        };
        locald = (kotlin.d.d)this;
        this.label = 2;
        if (l.a((f)localObject, paramObject, locald) != locala) {
          break label308;
        }
        AppMethodBeat.o(337659);
        return locala;
      }
      label301:
      label308:
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.v
 * JD-Core Version:    0.7.0.1
 */