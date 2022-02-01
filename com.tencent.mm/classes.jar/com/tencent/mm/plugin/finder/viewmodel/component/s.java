package com.tencent.mm.plugin.finder.viewmodel.component;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.q;
import androidx.lifecycle.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.report.bb;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.r;
import com.tencent.mm.plugin.finder.view.FinderHotCommentLayout;
import com.tencent.mm.plugin.finder.view.HotCommentSpacingTextView;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.j;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFeedHotCommentUIC;", "Lcom/tencent/mm/plugin/finder/viewmodel/component/IFinderDescPanelItem;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderFeedHotCommentUIC;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "hotCommentLiveDataMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Landroidx/lifecycle/MutableLiveData;", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "isInnerHotCommentDrawer", "", "progressMap", "", "", "showingCommentId", "showingDuration", "showingFeedId", "startExposeTime", "animateHide", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "fromUser", "animateShow", "getContentView", "Landroid/view/View;", "hide", "hotCommentLiveData", "feedId", "isNeedShow", "onBindView", "feed", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "isSelf", "openDrawerListener", "Lkotlin/Function1;", "onCloseCommentDrawer", "onExposeHotComment", "onFocusFeed", "isFirstTime", "lastFeedId", "newFeedId", "onPause", "onResume", "reportClickHotComment", "reportEndExpose", "endType", "show", "updateProgress", "progressSec", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class s
  extends bh
  implements com.tencent.mm.plugin.findersdk.a.ah
{
  public static final a GPh;
  private final ConcurrentHashMap<Long, x<LinkedList<FinderCommentInfo>>> GPi;
  private long GPj;
  public long GPk;
  private long GPl;
  private long GPm;
  public boolean GPn;
  public Map<Long, Integer> GPo;
  
  static
  {
    AppMethodBeat.i(337813);
    GPh = new a((byte)0);
    AppMethodBeat.o(337813);
  }
  
  public s(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(337712);
    this.GPi = new ConcurrentHashMap();
    this.GPo = ((Map)new LinkedHashMap());
    AppMethodBeat.o(337712);
  }
  
  private final void T(j paramj)
  {
    long l2 = 0L;
    AppMethodBeat.i(337734);
    paramj = paramj.CSA;
    if ((paramj instanceof BaseFinderFeed)) {}
    for (paramj = (BaseFinderFeed)paramj; paramj == null; paramj = null)
    {
      AppMethodBeat.o(337734);
      return;
    }
    dji localdji = (dji)kotlin.a.p.oL((List)paramj.feedObject.getMediaList());
    long l1;
    long l3;
    if (localdji == null)
    {
      l1 = 0L;
      l3 = l1 / 1000L;
      this.GPk = paramj.bZA();
      paramj = (LinkedList)rg(paramj.bZA()).getValue();
      if (paramj != null) {
        break label195;
      }
      l1 = l2;
    }
    for (;;)
    {
      this.GPl = l1;
      this.GPm = l3;
      this.GPj = System.currentTimeMillis();
      Log.i("Finder.FeedHotCommentUIC", "hotcomment is expose, showingFeedId = " + this.GPk + " startExposeTime = " + this.GPj + " showingCommentId = " + this.GPl + " showingDuration = " + this.GPm);
      AppMethodBeat.o(337734);
      return;
      l1 = localdji.aaPh;
      break;
      label195:
      paramj = (FinderCommentInfo)kotlin.a.p.oL((List)paramj);
      l1 = l2;
      if (paramj != null) {
        l1 = paramj.commentId;
      }
    }
  }
  
  private static final void a(ViewGroup paramViewGroup, final s params, final j paramj)
  {
    AppMethodBeat.i(337800);
    kotlin.g.b.s.u(paramViewGroup, "$hotCommentLayout");
    kotlin.g.b.s.u(params, "this$0");
    kotlin.g.b.s.u(paramj, "$holder");
    paramViewGroup.setVisibility(0);
    paramViewGroup.setAlpha(0.0F);
    paramViewGroup.animate().alpha(1.0F).setDuration(250L).setListener((Animator.AnimatorListener)new c(paramViewGroup, params, paramj)).start();
    AppMethodBeat.o(337800);
  }
  
  private static final void a(FinderHotCommentLayout paramFinderHotCommentLayout, s params, kotlin.g.a.b paramb, LinkedList paramLinkedList)
  {
    AppMethodBeat.i(337788);
    kotlin.g.b.s.u(paramFinderHotCommentLayout, "$hotCommentLayout");
    kotlin.g.b.s.u(params, "this$0");
    kotlin.g.b.s.s(paramLinkedList, "commentList");
    FinderCommentInfo localFinderCommentInfo = (FinderCommentInfo)kotlin.a.p.oL((List)paramLinkedList);
    if (localFinderCommentInfo != null)
    {
      Context localContext = (Context)params.getContext();
      Object localObject = localFinderCommentInfo.content;
      paramLinkedList = (LinkedList)localObject;
      if (localObject == null) {
        paramLinkedList = "";
      }
      paramLinkedList = com.tencent.mm.pluginsdk.ui.span.p.b(localContext, (CharSequence)paramLinkedList);
      kotlin.g.b.s.s(paramLinkedList, "spanForSmiley(context, comment.content ?: \"\")");
      paramLinkedList = (CharSequence)paramLinkedList;
      int i = localFinderCommentInfo.likeCount;
      kotlin.g.b.s.u(paramLinkedList, "content");
      localObject = paramFinderHotCommentLayout.getHotCommentTagTv();
      kotlin.g.b.s.s(localObject, "hotCommentTagTv");
      paramFinderHotCommentLayout.GzW = FinderHotCommentLayout.gW((View)localObject);
      paramFinderHotCommentLayout.setMargin(paramLinkedList);
      paramFinderHotCommentLayout.getHotCommentLikeCountTv().setText((CharSequence)r.TP(Math.abs(i)));
      paramLinkedList = paramFinderHotCommentLayout.getHotCommentLikeFrame();
      kotlin.g.b.s.s(paramLinkedList, "hotCommentLikeFrame");
      paramFinderHotCommentLayout.GzX = kotlin.h.a.eH(FinderHotCommentLayout.gW(paramLinkedList) * 1.2F);
      Log.i("Finder.HotCommentLayout", "bindData likeFrameWidth = " + paramFinderHotCommentLayout.GzX + " tagWidth = " + paramFinderHotCommentLayout.GzW);
      paramFinderHotCommentLayout.getHotCommentContentTv().setExtraEllipsizeWidth(paramFinderHotCommentLayout.GzX);
      paramFinderHotCommentLayout.setOnClickListener(new s..ExternalSyntheticLambda0(paramb, localFinderCommentInfo, params));
    }
    AppMethodBeat.o(337788);
  }
  
  private static final void a(kotlin.g.a.b paramb, FinderCommentInfo paramFinderCommentInfo, s params, View paramView)
  {
    AppMethodBeat.i(337770);
    kotlin.g.b.s.u(paramFinderCommentInfo, "$comment");
    kotlin.g.b.s.u(params, "this$0");
    if (paramb != null) {
      paramb.invoke(paramFinderCommentInfo);
    }
    long l = params.GPk;
    paramView = new JSONObject();
    JSONObject localJSONObject = new JSONObject();
    paramFinderCommentInfo = params.GPo.get(Long.valueOf(l));
    paramb = paramFinderCommentInfo;
    if (paramFinderCommentInfo == null) {
      paramb = Long.valueOf(0L);
    }
    localJSONObject.put("cid", com.tencent.mm.plugin.expt.hellhound.core.b.hF(params.GPl));
    localJSONObject.put("current_play_sec", paramb);
    localJSONObject.put("video_duration", params.GPm);
    localJSONObject.put("expose_start_time", params.GPj);
    paramView.put("hot_comment", localJSONObject);
    paramb = as.GSQ;
    paramb = as.a.hu((Context)params.getContext());
    if (paramb == null) {}
    for (paramb = null;; paramb = paramb.fou())
    {
      paramFinderCommentInfo = bb.FuK;
      bb.a(paramb, "hot_comment", 1, paramView);
      params.ah(params.GPk, 2);
      params.GPn = true;
      AppMethodBeat.o(337770);
      return;
    }
  }
  
  private final void ah(long paramLong, int paramInt)
  {
    AppMethodBeat.i(337754);
    if (paramLong == 0L)
    {
      AppMethodBeat.o(337754);
      return;
    }
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    Object localObject2 = this.GPo.get(Long.valueOf(paramLong));
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = Long.valueOf(0L);
    }
    localJSONObject2.put("cid", com.tencent.mm.plugin.expt.hellhound.core.b.hF(this.GPl));
    localJSONObject2.put("current_play_sec", localObject1);
    localJSONObject2.put("video_duration", this.GPm);
    localJSONObject2.put("expose_start_time", this.GPj);
    localJSONObject2.put("expose_end_time", System.currentTimeMillis());
    localJSONObject2.put("expose_end_type", paramInt);
    localJSONObject1.put("hot_comment", localJSONObject2);
    localObject1 = as.GSQ;
    localObject1 = as.a.hu((Context)getContext());
    if (localObject1 == null) {}
    for (localObject1 = null;; localObject1 = ((as)localObject1).fou())
    {
      localObject2 = bb.FuK;
      bb.a((bui)localObject1, "hot_comment", 0, localJSONObject1);
      AppMethodBeat.o(337754);
      return;
    }
  }
  
  public final boolean R(j paramj)
  {
    AppMethodBeat.i(337931);
    kotlin.g.b.s.u(paramj, "holder");
    Object localObject = paramj.CSA;
    if ((localObject instanceof BaseFinderFeed)) {}
    for (localObject = (BaseFinderFeed)localObject; localObject == null; localObject = null)
    {
      AppMethodBeat.o(337931);
      return false;
    }
    localObject = (LinkedList)rg(((BaseFinderFeed)localObject).bZA()).getValue();
    if ((S(paramj) != null) && (!Util.isNullOrNil((List)localObject)))
    {
      AppMethodBeat.o(337931);
      return true;
    }
    AppMethodBeat.o(337931);
    return false;
  }
  
  public final View S(j paramj)
  {
    AppMethodBeat.i(337946);
    kotlin.g.b.s.u(paramj, "holder");
    paramj = paramj.UH(e.e.finder_hot_comment_layout);
    AppMethodBeat.o(337946);
    return paramj;
  }
  
  public final void a(cc paramcc, j paramj, kotlin.g.a.b<? super FinderCommentInfo, kotlin.ah> paramb)
  {
    AppMethodBeat.i(337963);
    kotlin.g.b.s.u(paramcc, "feed");
    kotlin.g.b.s.u(paramj, "holder");
    if (paramcc == null)
    {
      AppMethodBeat.o(337963);
      return;
    }
    FinderHotCommentLayout localFinderHotCommentLayout = (FinderHotCommentLayout)paramj.UH(e.e.finder_hot_comment_layout);
    if (localFinderHotCommentLayout == null)
    {
      AppMethodBeat.o(337963);
      return;
    }
    paramj = paramj.context;
    if ((paramj instanceof MMActivity)) {}
    for (paramj = (MMActivity)paramj; paramj == null; paramj = null)
    {
      AppMethodBeat.o(337963);
      return;
    }
    d.a((LiveData)rg(paramcc.bZA()), (q)paramj, new s..ExternalSyntheticLambda1(localFinderHotCommentLayout, this, paramb));
    AppMethodBeat.o(337963);
  }
  
  public final void b(j paramj, boolean paramBoolean, long paramLong1, long paramLong2)
  {
    int i = 1;
    AppMethodBeat.i(338003);
    kotlin.g.b.s.u(paramj, "holder");
    super.b(paramj, paramBoolean, paramLong1, paramLong2);
    if (!paramBoolean)
    {
      AppMethodBeat.o(338003);
      return;
    }
    if (this.GPk == paramLong1) {
      ah(paramLong1, 1);
    }
    View localView = S(paramj);
    if ((localView != null) && (localView.getVisibility() == 0)) {}
    while (i != 0)
    {
      T(paramj);
      AppMethodBeat.o(338003);
      return;
      i = 0;
    }
    this.GPk = 0L;
    this.GPl = 0L;
    this.GPm = 0L;
    this.GPj = 0L;
    this.GPn = false;
    AppMethodBeat.o(338003);
  }
  
  public final void d(j paramj, boolean paramBoolean)
  {
    AppMethodBeat.i(337878);
    kotlin.g.b.s.u(paramj, "holder");
    T(paramj);
    ViewGroup localViewGroup = (ViewGroup)paramj.UH(e.e.finder_hot_comment_layout);
    if (localViewGroup != null) {
      h.ahAA.o(new s..ExternalSyntheticLambda2(localViewGroup, this, paramj), 150L);
    }
    AppMethodBeat.o(337878);
  }
  
  public final void e(j paramj, boolean paramBoolean)
  {
    AppMethodBeat.i(337890);
    kotlin.g.b.s.u(paramj, "holder");
    paramj = (ViewGroup)paramj.UH(e.e.finder_hot_comment_layout);
    if (paramj != null)
    {
      paramj.setAlpha(1.0F);
      paramj.animate().alpha(0.0F).setDuration(250L).setListener((Animator.AnimatorListener)new b(paramj)).start();
    }
    AppMethodBeat.o(337890);
  }
  
  public final void fnz()
  {
    AppMethodBeat.i(337985);
    this.GPj = System.currentTimeMillis();
    Log.i("Finder.FeedHotCommentUIC", "hotcomment is expose, showingFeedId = " + this.GPk + " startExposeTime = " + this.GPj + " showingCommentId = " + this.GPl + " showingDuration = " + this.GPm);
    AppMethodBeat.o(337985);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(337903);
    super.onPause();
    if (this.GPk != 0L) {
      ah(this.GPk, 1);
    }
    AppMethodBeat.o(337903);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(337914);
    super.onResume();
    if (this.GPk != 0L) {
      fnz();
    }
    AppMethodBeat.o(337914);
  }
  
  public final x<LinkedList<FinderCommentInfo>> rg(long paramLong)
  {
    AppMethodBeat.i(337864);
    Object localObject2 = (ConcurrentMap)this.GPi;
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
      kotlin.g.b.s.s(localObject1, "hotCommentLiveDataMap.ge…Id) { MutableLiveData() }");
      localObject1 = (x)localObject1;
      AppMethodBeat.o(337864);
      return localObject1;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFeedHotCommentUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/viewmodel/component/FinderFeedHotCommentUIC$animateHide$1", "Lcom/tencent/mm/plugin/finder/animation/AnimatorEndListener;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends com.tencent.mm.plugin.finder.animation.a
  {
    b(ViewGroup paramViewGroup) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(338783);
      this.GPp.setAlpha(1.0F);
      this.GPp.setVisibility(8);
      AppMethodBeat.o(338783);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/viewmodel/component/FinderFeedHotCommentUIC$animateShow$1$1", "Lcom/tencent/mm/plugin/finder/animation/AnimatorEndListener;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends com.tencent.mm.plugin.finder.animation.a
  {
    c(ViewGroup paramViewGroup, s params, j paramj) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(338791);
      this.GPp.setAlpha(1.0F);
      params.ab(paramj);
      AppMethodBeat.o(338791);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.s
 * JD-Core Version:    0.7.0.1
 */