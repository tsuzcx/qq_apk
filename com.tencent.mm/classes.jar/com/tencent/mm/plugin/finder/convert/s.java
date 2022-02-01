package com.tencent.mm.plugin.finder.convert;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.q;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.d;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.extension.reddot.i;
import com.tencent.mm.plugin.finder.extension.reddot.l;
import com.tencent.mm.plugin.finder.extension.reddot.l.a;
import com.tencent.mm.plugin.finder.feed.bg;
import com.tencent.mm.plugin.finder.model.al;
import com.tencent.mm.plugin.finder.model.bz;
import com.tencent.mm.plugin.finder.report.bb;
import com.tencent.mm.plugin.finder.view.FinderHomeTabRedDotTipsBubbleView;
import com.tencent.mm.plugin.finder.view.FinderHomeTabRedDotTipsBubbleView.b;
import com.tencent.mm.plugin.finder.viewmodel.component.af.b;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.protocal.protobuf.FinderTipsShowEntranceExtInfo;
import com.tencent.mm.protocal.protobuf.btx;
import com.tencent.mm.protocal.protobuf.bwk;
import com.tencent.mm.protocal.protobuf.bxq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.recyclerview.j;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.a.ab;
import kotlin.ah;
import kotlin.g.b.ah.a;
import kotlin.g.b.ah.f;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedFullMergedHeaderConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderHeaderFullMergedData;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelinePresenter;", "(Lcom/tencent/mm/plugin/finder/feed/FinderTimelinePresenter;)V", "dismissHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "dismissTask", "Ljava/lang/Runnable;", "feedCommentFailedNotifyConvert", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedCommentFailedNotifyConvert;", "feedMsgNotifyConvert", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedMsgNotifyConvert;", "feedMsgNotifyHolder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "privateMsgNotifyConvert", "Lcom/tencent/mm/plugin/finder/convert/FinderPrivateMsgNotifyConvert;", "privateMsgNotifyHolder", "tabTipsBubbleView", "Lcom/tencent/mm/plugin/finder/view/FinderHomeTabRedDotTipsBubbleView;", "addFriendCollapsedTips", "", "context", "Landroid/app/Activity;", "holder", "adjustTipsBubbleLayout", "tipsLayout", "Landroid/view/View;", "isFollowBubble", "", "getLayoutId", "", "getReportJson", "Lorg/json/JSONObject;", "path", "", "handleCommentFailed", "parent", "Landroid/view/ViewGroup;", "item", "position", "type", "isHotPatch", "payloads", "", "", "handleTabTipsBubble", "tipsShowInfo", "Lcom/tencent/mm/protocal/protobuf/FinderStreamTipsShowInfo;", "onBindViewHolder", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onDetachedFromRecyclerView", "setVisibleOtherBubble", "isShow", "withAnim", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class s
  extends com.tencent.mm.view.recyclerview.f<al>
{
  public static final a AJw;
  private final k AJA;
  private j AJB;
  private j AJC;
  private Runnable AJD;
  private final MMHandler AJE;
  private FinderHomeTabRedDotTipsBubbleView AJF;
  private final bg AJx;
  private final z AJy;
  private final by AJz;
  
  static
  {
    AppMethodBeat.i(350643);
    AJw = new a((byte)0);
    AppMethodBeat.o(350643);
  }
  
  public s(bg parambg)
  {
    AppMethodBeat.i(350597);
    this.AJx = parambg;
    this.AJy = new z();
    this.AJz = new by();
    this.AJA = new k();
    this.AJE = new MMHandler(Looper.getMainLooper());
    AppMethodBeat.o(350597);
  }
  
  private static final void a(s params, FinderHomeTabRedDotTipsBubbleView paramFinderHomeTabRedDotTipsBubbleView, al paramal)
  {
    AppMethodBeat.i(370811);
    kotlin.g.b.s.u(params, "this$0");
    kotlin.g.b.s.u(paramFinderHomeTabRedDotTipsBubbleView, "$it");
    kotlin.g.b.s.u(paramal, "$item");
    Object localObject = (View)paramFinderHomeTabRedDotTipsBubbleView;
    params = paramal.ECT.Bjn;
    boolean bool;
    int k;
    Context localContext;
    label105:
    int[] arrayOfInt;
    int j;
    int i;
    label149:
    int m;
    if ((params != null) && (params.aaft == 2))
    {
      bool = true;
      k = ((View)localObject).getWidth();
      localContext = ((View)localObject).getContext();
      params = com.tencent.mm.ui.component.k.aeZF;
      params = ((View)localObject).getContext();
      kotlin.g.b.s.s(params, "tipsLayout.context");
      params = ((com.tencent.mm.plugin.finder.viewmodel.component.af)com.tencent.mm.ui.component.k.nq(params).q(com.tencent.mm.plugin.finder.viewmodel.component.af.class)).Vh(3);
      if (params != null) {
        break label286;
      }
      params = null;
      arrayOfInt = new int[2];
      if (params != null) {
        params.getLocationInWindow(arrayOfInt);
      }
      j = (int)localContext.getResources().getDimension(e.c.Edge_2A);
      if (arrayOfInt[0] <= 0) {
        break label294;
      }
      i = arrayOfInt[0] + j;
      m = i - k / 2;
      if ((!bool) || (k / 2 <= i)) {
        break label310;
      }
      i -= j * 2;
    }
    for (;;)
    {
      Log.i("Finder.FeedFullMergedHeaderConvert", "[adjustTipsBubbleLayout] width=" + k + " isFollowBubble=" + bool + " startPadding=" + m + " arrowPaddingStart=" + i + " values=" + arrayOfInt[0]);
      params = ((View)localObject).findViewById(e.e.v_arrow).getLayoutParams();
      if (params != null) {
        break label315;
      }
      params = new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
      AppMethodBeat.o(370811);
      throw params;
      bool = false;
      break;
      label286:
      params = params.titleTv;
      break label105;
      label294:
      i = (int)localContext.getResources().getDimension(e.c.Edge_17A);
      break label149;
      label310:
      i = 0;
    }
    label315:
    params = (LinearLayout.LayoutParams)params;
    if (i > 0)
    {
      params.gravity = 51;
      params.leftMargin = i;
    }
    for (;;)
    {
      i = bf.getStatusBarHeight(localContext);
      ((View)localObject).setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-2, -2));
      params = ((View)localObject).getLayoutParams();
      if (params != null) {
        break;
      }
      params = new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
      AppMethodBeat.o(370811);
      throw params;
      params.leftMargin = 0;
      params.gravity = 49;
    }
    params = (FrameLayout.LayoutParams)params;
    params.topMargin = (i + ((int)localContext.getResources().getDimension(e.c.Edge_0_2_5_A) + (int)localContext.getResources().getDimension(e.c.DefaultActionbarHeightPort)));
    if (!bool)
    {
      params.gravity = 49;
      params.setMarginStart(0);
      ((View)localObject).requestLayout();
      paramal = paramal.ECT.Bjn;
      localObject = new StringBuilder("[show] show_reddot=");
      if (paramal != null) {
        break label670;
      }
      params = null;
      label485:
      localObject = ((StringBuilder)localObject).append(params).append(", show_type=");
      if (paramal != null) {
        break label681;
      }
      params = null;
      label505:
      ((StringBuilder)localObject).append(params);
      com.tencent.e.f.h.jXD();
      paramFinderHomeTabRedDotTipsBubbleView.Bjn = paramal;
      paramFinderHomeTabRedDotTipsBubbleView.GzP = paramFinderHomeTabRedDotTipsBubbleView.getReportJson();
      if (paramFinderHomeTabRedDotTipsBubbleView.getVisibility() != 0)
      {
        paramFinderHomeTabRedDotTipsBubbleView.setVisibility(0);
        paramFinderHomeTabRedDotTipsBubbleView.setAlpha(0.0F);
        params = paramFinderHomeTabRedDotTipsBubbleView.animate();
        if (params != null) {
          params.cancel();
        }
        paramFinderHomeTabRedDotTipsBubbleView.animate().alpha(1.0F).setDuration(250L).setListener(null).start();
        params = com.tencent.mm.ui.component.k.aeZF;
        params = paramFinderHomeTabRedDotTipsBubbleView.getContext();
        kotlin.g.b.s.s(params, "context");
        params = ((as)com.tencent.mm.ui.component.k.nq(params).q(as.class)).fou();
        if (!paramFinderHomeTabRedDotTipsBubbleView.fkI()) {
          break label706;
        }
        paramal = bb.FuK;
        bb.a(params, "followtab_tl_bubble", 0, paramFinderHomeTabRedDotTipsBubbleView.GzP);
      }
    }
    for (;;)
    {
      paramFinderHomeTabRedDotTipsBubbleView.a(paramFinderHomeTabRedDotTipsBubbleView.Bjn);
      AppMethodBeat.o(370811);
      return;
      params.gravity = 8388659;
      params.leftMargin = Math.max(m, j);
      break;
      label670:
      params = Integer.valueOf(paramal.aaft);
      break label485;
      label681:
      params = paramal.aafu;
      if (params == null)
      {
        params = null;
        break label505;
      }
      params = Integer.valueOf(params.show_type);
      break label505;
      label706:
      paramal = bb.FuK;
      bb.a(params, "friendtab_tl_bubble", 0, paramFinderHomeTabRedDotTipsBubbleView.GzP);
    }
  }
  
  private static final void a(al paramal, s params)
  {
    AppMethodBeat.i(370812);
    kotlin.g.b.s.u(paramal, "$item");
    kotlin.g.b.s.u(params, "this$0");
    paramal.ECT.state = -1;
    paramal = params.AJF;
    if (paramal != null) {
      FinderHomeTabRedDotTipsBubbleView.a(paramal);
    }
    AppMethodBeat.o(370812);
  }
  
  private static final void a(ah.a parama, Activity paramActivity, ah.f paramf, s params, l.a parama1)
  {
    AppMethodBeat.i(370813);
    kotlin.g.b.s.u(parama, "$isFriendShow");
    kotlin.g.b.s.u(paramActivity, "$context");
    kotlin.g.b.s.u(paramf, "$friendsTipsReport");
    kotlin.g.b.s.u(params, "this$0");
    params = FinderHomeTabRedDotTipsBubbleView.GzN;
    boolean bool = FinderHomeTabRedDotTipsBubbleView.kLC();
    Log.i("Finder.FeedFullMergedHeaderConvert", "[observeWithNotify] isShow=" + parama1.hBY + " isFriendShow=" + parama.aiwY + " isClickBubble=" + bool);
    if ((parama1.hBY) && (!parama.aiwY))
    {
      params = com.tencent.mm.ui.component.k.aeZF;
      paramActivity = ((as)com.tencent.mm.ui.component.k.nq((Context)paramActivity).q(as.class)).Vl(4);
      parama.aiwY = true;
      paramf.aqH = avm("TLRecommendTab");
      parama = bb.FuK;
      bb.a(paramActivity, "friendtab_tl_reddot_withouthead", 0, (JSONObject)paramf.aqH);
      AppMethodBeat.o(370813);
      return;
    }
    if ((!parama1.hBY) && (parama.aiwY))
    {
      params = com.tencent.mm.ui.component.k.aeZF;
      paramActivity = ((as)com.tencent.mm.ui.component.k.nq((Context)paramActivity).q(as.class)).Vl(1);
      parama.aiwY = false;
      if (!bool)
      {
        parama = bb.FuK;
        bb.a(paramActivity, "friendtab_tl_reddot_withouthead", 1, (JSONObject)paramf.aqH);
      }
      parama = FinderHomeTabRedDotTipsBubbleView.GzN;
      FinderHomeTabRedDotTipsBubbleView.kLB();
    }
    AppMethodBeat.o(370813);
  }
  
  private static JSONObject avm(String paramString)
  {
    Object localObject2 = null;
    AppMethodBeat.i(350611);
    JSONObject localJSONObject = new JSONObject();
    com.tencent.mm.plugin.finder.extension.reddot.p localp = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().Su(paramString);
    Object localObject1;
    label50:
    label69:
    label116:
    Object localObject3;
    label148:
    int i;
    if (localp == null)
    {
      localObject1 = null;
      if (localObject1 != null) {
        break label269;
      }
      paramString = "";
      localJSONObject.put("wording", paramString);
      if (localp != null) {
        break label290;
      }
      paramString = "";
      localJSONObject.put("tipsid", paramString);
      if (localp != null)
      {
        paramString = localp.ASz;
        if (paramString != null) {
          localJSONObject.put("feedid", com.tencent.mm.ae.d.hF(paramString.object_id));
        }
      }
      if (localObject1 != null) {
        break label312;
      }
      paramString = null;
      if ((paramString == null) || (((bxq)localObject1).aagr != 1)) {
        break label413;
      }
      localObject3 = new FinderTipsShowEntranceExtInfo();
      paramString = ((bxq)localObject1).aags;
      if (paramString != null) {
        break label320;
      }
      paramString = localObject2;
      ((FinderTipsShowEntranceExtInfo)localObject3).parseFrom(paramString);
      paramString = (CharSequence)((FinderTipsShowEntranceExtInfo)localObject3).username;
      if ((paramString != null) && (paramString.length() != 0)) {
        break label328;
      }
      i = 1;
    }
    label269:
    label290:
    for (;;)
    {
      label179:
      if (i != 0)
      {
        paramString = ((FinderTipsShowEntranceExtInfo)localObject3).multi_username;
        kotlin.g.b.s.s(paramString, "ext.multi_username");
        localObject1 = (Iterable)paramString;
        paramString = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject1, 10));
        localObject1 = ((Iterable)localObject1).iterator();
        for (;;)
        {
          if (((Iterator)localObject1).hasNext())
          {
            paramString.add(kotlin.g.b.s.X((String)((Iterator)localObject1).next(), "|"));
            continue;
            localObject1 = localp.avK(paramString);
            break;
            localObject3 = ((bxq)localObject1).title;
            paramString = (String)localObject3;
            if (localObject3 != null) {
              break label50;
            }
            paramString = "";
            break label50;
            localObject3 = localp.field_tipsId;
            paramString = (String)localObject3;
            if (localObject3 != null) {
              break label69;
            }
            paramString = "";
            break label69;
            label312:
            paramString = ((bxq)localObject1).aags;
            break label116;
            label320:
            paramString = paramString.toByteArray();
            break label148;
            label328:
            i = 0;
            break label179;
          }
        }
        paramString = (List)paramString;
        if (!paramString.isEmpty())
        {
          localObject1 = paramString.listIterator(paramString.size());
          while (((ListIterator)localObject1).hasPrevious()) {
            if (!kotlin.g.b.s.p((String)((ListIterator)localObject1).previous(), "|"))
            {
              paramString = kotlin.a.p.c((Iterable)paramString, ((ListIterator)localObject1).nextIndex() + 1);
              localJSONObject.put("friendusername", paramString);
            }
          }
        }
      }
    }
    for (;;)
    {
      label413:
      AppMethodBeat.o(350611);
      return localJSONObject;
      paramString = (List)ab.aivy;
      break;
      localJSONObject.put("friendusername", String.valueOf(((FinderTipsShowEntranceExtInfo)localObject3).username));
    }
  }
  
  private static void b(j paramj, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(370808);
    Log.d("Finder.FeedFullMergedHeaderConvert", "[setVisibleOtherBubble] isShow=" + paramBoolean1 + " withAnim=" + paramBoolean2);
    paramj = (ViewGroup)paramj.caK;
    int i = 0;
    int k = paramj.getChildCount();
    if (k > 0) {}
    for (;;)
    {
      int j = i + 1;
      paramj.getChildAt(i).animate().cancel();
      if (paramBoolean2) {
        if (paramBoolean1) {
          if (paramj.getAlpha() < 1.0F) {
            paramj.animate().alpha(1.0F).setDuration(260L).start();
          }
        }
      }
      while (j >= k)
      {
        AppMethodBeat.o(370808);
        return;
        paramj.animate().alpha(0.0F).setDuration(260L).start();
        continue;
        if (paramBoolean1) {
          paramj.setAlpha(1.0F);
        } else {
          paramj.setAlpha(0.0F);
        }
      }
      i = j;
    }
  }
  
  private static final void b(ah.a parama, Activity paramActivity, ah.f paramf, s params, l.a parama1)
  {
    AppMethodBeat.i(370814);
    kotlin.g.b.s.u(parama, "$isFollowShow");
    kotlin.g.b.s.u(paramActivity, "$context");
    kotlin.g.b.s.u(paramf, "$followTipsReport");
    kotlin.g.b.s.u(params, "this$0");
    params = FinderHomeTabRedDotTipsBubbleView.GzN;
    boolean bool = FinderHomeTabRedDotTipsBubbleView.kLA();
    Log.i("Finder.FeedFullMergedHeaderConvert", "[observeWithNotify] isShow=" + parama1.hBY + " isFollowShow=" + parama.aiwY + " isClickBubble=" + bool);
    if ((parama1.hBY) && (!parama.aiwY))
    {
      params = com.tencent.mm.ui.component.k.aeZF;
      paramActivity = ((as)com.tencent.mm.ui.component.k.nq((Context)paramActivity).q(as.class)).Vl(4);
      parama.aiwY = true;
      paramf.aqH = avm("TLFollow");
      parama = bb.FuK;
      bb.a(paramActivity, "followtab_tl_reddot_withouthead", 0, (JSONObject)paramf.aqH);
      AppMethodBeat.o(370814);
      return;
    }
    if ((!parama1.hBY) && (parama.aiwY))
    {
      params = com.tencent.mm.ui.component.k.aeZF;
      paramActivity = ((as)com.tencent.mm.ui.component.k.nq((Context)paramActivity).q(as.class)).Vl(3);
      parama.aiwY = false;
      if (!bool)
      {
        parama = bb.FuK;
        bb.a(paramActivity, "followtab_tl_reddot_withouthead", 1, (JSONObject)paramf.aqH);
      }
      parama = FinderHomeTabRedDotTipsBubbleView.GzN;
      FinderHomeTabRedDotTipsBubbleView.kLB();
    }
    AppMethodBeat.o(370814);
  }
  
  public final void a(RecyclerView paramRecyclerView, final j paramj, int paramInt)
  {
    AppMethodBeat.i(350680);
    kotlin.g.b.s.u(paramRecyclerView, "recyclerView");
    kotlin.g.b.s.u(paramj, "holder");
    paramInt = com.tencent.mm.view.d.e(paramRecyclerView.getContext(), 6.0F);
    View localView = com.tencent.mm.ui.af.mU(paramj.context).inflate(e.f._feed_header_msg_notify_item, (ViewGroup)paramj.caK, false);
    Object localObject2 = com.tencent.mm.ui.af.mU(paramj.context).inflate(e.f._feed_header_private_msg_notify_item, (ViewGroup)paramj.caK, false);
    Object localObject1 = localView.findViewById(e.e.msg_layout);
    Object localObject3;
    if (localObject1 != null)
    {
      localObject3 = ((View)localObject1).getLayoutParams();
      if (localObject3 == null)
      {
        paramRecyclerView = new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        AppMethodBeat.o(350680);
        throw paramRecyclerView;
      }
      localObject3 = (FrameLayout.LayoutParams)localObject3;
      ((FrameLayout.LayoutParams)localObject3).topMargin = paramInt;
      ((FrameLayout.LayoutParams)localObject3).bottomMargin = paramInt;
      ((View)localObject1).setBackgroundResource(e.d.feed_full_msg_layout_selector);
    }
    localObject1 = ((View)localObject2).findViewById(e.e.msg_layout);
    if (localObject1 != null)
    {
      localObject3 = ((View)localObject1).getLayoutParams();
      if (localObject3 == null)
      {
        paramRecyclerView = new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        AppMethodBeat.o(350680);
        throw paramRecyclerView;
      }
      localObject3 = (FrameLayout.LayoutParams)localObject3;
      ((FrameLayout.LayoutParams)localObject3).topMargin = paramInt;
      ((FrameLayout.LayoutParams)localObject3).bottomMargin = paramInt;
      ((View)localObject1).setBackgroundResource(e.d.feed_full_msg_layout_selector);
    }
    ((ViewGroup)paramj.caK).addView(localView);
    ((ViewGroup)paramj.caK).addView((View)localObject2);
    if (this.AJx.hJx == 4)
    {
      localObject1 = paramj.context;
      if (localObject1 == null)
      {
        paramRecyclerView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(350680);
        throw paramRecyclerView;
      }
      localObject3 = (Activity)localObject1;
      if (this.AJF == null)
      {
        localObject1 = ((Activity)localObject3).findViewById(e.e.viewPager).getParent();
        if ((localObject1 instanceof FrameLayout)) {
          localObject1 = (FrameLayout)localObject1;
        }
        while (localObject1 != null)
        {
          ah.a locala = new ah.a();
          ah.f localf = new ah.f();
          Object localObject4 = l.ARA;
          localObject4 = (LiveData)l.dZJ();
          Context localContext = paramj.context;
          if (localContext == null)
          {
            paramRecyclerView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(350680);
            throw paramRecyclerView;
            localObject1 = null;
          }
          else
          {
            com.tencent.mm.ae.d.a((LiveData)localObject4, (q)localContext, new s..ExternalSyntheticLambda0(locala, (Activity)localObject3, localf, this));
            locala = new ah.a();
            localf = new ah.f();
            localObject4 = l.ARA;
            localObject4 = (LiveData)l.dZI();
            localContext = paramj.context;
            if (localContext == null)
            {
              paramRecyclerView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
              AppMethodBeat.o(350680);
              throw paramRecyclerView;
            }
            com.tencent.mm.ae.d.a((LiveData)localObject4, (q)localContext, new s..ExternalSyntheticLambda1(locala, (Activity)localObject3, localf, this));
            localObject3 = new FinderHomeTabRedDotTipsBubbleView((Context)localObject3);
            ((FinderHomeTabRedDotTipsBubbleView)localObject3).setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-2, -2));
            ((FrameLayout)localObject1).addView((View)localObject3);
            ((FinderHomeTabRedDotTipsBubbleView)localObject3).setVisibilityListener((FinderHomeTabRedDotTipsBubbleView.b)new b((FinderHomeTabRedDotTipsBubbleView)localObject3, this, paramj));
            ((FinderHomeTabRedDotTipsBubbleView)localObject3).Qa(false);
            b(paramj, false, false);
            this.AJF = ((FinderHomeTabRedDotTipsBubbleView)localObject3);
          }
        }
      }
      paramRecyclerView.a((RecyclerView.l)new c(paramRecyclerView, paramj, this));
    }
    paramj = new j(localView);
    paramj.mkw = paramRecyclerView;
    localObject1 = ah.aiuX;
    this.AJB = paramj;
    paramj = new j((View)localObject2);
    paramj.mkw = paramRecyclerView;
    localObject1 = ah.aiuX;
    this.AJC = paramj;
    localObject2 = this.AJy;
    localObject1 = this.AJB;
    paramj = (j)localObject1;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("feedMsgNotifyHolder");
      paramj = null;
    }
    ((z)localObject2).a(paramRecyclerView, paramj, -5);
    localObject2 = this.AJz;
    localObject1 = this.AJC;
    paramj = (j)localObject1;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("privateMsgNotifyHolder");
      paramj = null;
    }
    ((by)localObject2).a(paramRecyclerView, paramj, -6);
    AppMethodBeat.o(350680);
  }
  
  public final void a(j paramj, al paramal, int paramInt)
  {
    AppMethodBeat.i(350696);
    kotlin.g.b.s.u(paramj, "holder");
    kotlin.g.b.s.u(paramal, "item");
    Object localObject2 = this.AJB;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("feedMsgNotifyHolder");
      localObject1 = null;
    }
    ((j)localObject1).CSA = paramal.msgNotifyData;
    localObject2 = this.AJC;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("privateMsgNotifyHolder");
      localObject1 = null;
    }
    ((j)localObject1).CSA = paramal.Ban;
    localObject2 = this.AJB;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("feedMsgNotifyHolder");
      localObject1 = null;
    }
    z.a((j)localObject1, paramal.msgNotifyData);
    Object localObject3 = this.AJz;
    localObject2 = this.AJC;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("privateMsgNotifyHolder");
      localObject1 = null;
    }
    ((by)localObject3).a((j)localObject1, paramal.Ban, paramInt);
    localObject1 = (ViewGroup)paramj.caK;
    localObject2 = new HashSet();
    paramInt = 0;
    int j = ((ViewGroup)localObject1).getChildCount();
    if (j > 0) {}
    for (;;)
    {
      int i = paramInt + 1;
      localObject3 = ((ViewGroup)localObject1).getChildAt(paramInt);
      if (((View)localObject3).getId() == e.e.comment_failed_notify_layout) {
        ((HashSet)localObject2).add(localObject3);
      }
      if (i >= j)
      {
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((ViewGroup)localObject1).removeView((View)((Iterator)localObject2).next());
        }
        paramInt = com.tencent.mm.view.d.e(((ViewGroup)localObject1).getContext(), 6.0F);
        localObject2 = ((Iterable)paramal.Bar).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (com.tencent.mm.plugin.finder.model.f)((Iterator)localObject2).next();
          if (((com.tencent.mm.plugin.finder.model.f)localObject3).ECj != 1)
          {
            Object localObject4 = com.tencent.mm.ui.af.mU(paramj.context).inflate(e.f._feed_header_comment_failed_notify_item, (ViewGroup)localObject1, false);
            Object localObject5 = ((View)localObject4).findViewById(e.e.msg_layout);
            if (localObject5 != null)
            {
              localObject6 = ((View)localObject5).getLayoutParams();
              if (localObject6 == null)
              {
                paramj = new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                AppMethodBeat.o(350696);
                throw paramj;
              }
              localObject6 = (FrameLayout.LayoutParams)localObject6;
              ((FrameLayout.LayoutParams)localObject6).topMargin = paramInt;
              ((FrameLayout.LayoutParams)localObject6).bottomMargin = paramInt;
              ((View)localObject5).setBackgroundResource(e.d.feed_full_msg_layout_selector);
            }
            ((ViewGroup)paramj.caK).addView((View)localObject4);
            localObject4 = new j((View)localObject4);
            ((j)localObject4).mkw = paramj.getRecyclerView();
            ((j)localObject4).CSA = localObject3;
            localObject5 = this.AJA;
            Object localObject6 = ((j)localObject4).getRecyclerView();
            kotlin.g.b.s.s(localObject6, "h.recyclerView");
            ((k)localObject5).a((RecyclerView)localObject6, (j)localObject4, -4);
            localObject5 = this.AJA;
            kotlin.g.b.s.s(localObject3, "data");
            ((k)localObject5).a((j)localObject4, (com.tencent.mm.plugin.finder.model.f)localObject3);
          }
        }
        if (paramal.ECT.state == 1)
        {
          paramj = this.AJF;
          if (paramj != null)
          {
            paramj.setVisibility(4);
            paramj.a(paramal.ECT.Bjn);
            paramj.post(new s..ExternalSyntheticLambda2(this, paramj, paramal));
          }
          paramj = this.AJD;
          if (paramj != null) {
            this.AJE.removeCallbacks(paramj);
          }
          this.AJD = new s..ExternalSyntheticLambda3(paramal, this);
          paramj = paramal.ECT.Bjn;
          if (paramj == null) {}
          for (long l1 = 0L;; l1 = paramj.aafv)
          {
            long l2 = l1 * 1000L;
            l1 = l2;
            if (l2 <= 0L) {
              l1 = 5000L;
            }
            this.AJE.postDelayed(this.AJD, l1);
            AppMethodBeat.o(350696);
            return;
          }
        }
        if (paramal.ECT.state == -1)
        {
          paramal = this.AJF;
          if (paramal != null) {
            FinderHomeTabRedDotTipsBubbleView.a(paramal);
          }
          f(paramj, true);
          AppMethodBeat.o(350696);
          return;
        }
        if (paramal.ECT.state == -100)
        {
          f(paramj, true);
          AppMethodBeat.o(350696);
          return;
        }
        if (paramal.ECT.state == -200) {
          b(paramj, false, false);
        }
        AppMethodBeat.o(350696);
        return;
      }
      paramInt = i;
    }
  }
  
  public final void e(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(350704);
    kotlin.g.b.s.u(paramRecyclerView, "recyclerView");
    super.e(paramRecyclerView);
    this.AJE.removeCallbacksAndMessages(null);
    AppMethodBeat.o(350704);
  }
  
  public final int getLayoutId()
  {
    return e.f._feed_full_merged_header_layout;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedFullMergedHeaderConvert$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/convert/FinderFeedFullMergedHeaderConvert$addFriendCollapsedTips$3", "Lcom/tencent/mm/plugin/finder/view/FinderHomeTabRedDotTipsBubbleView$IVisibilityListener;", "onVisibilityChange", "", "isShow", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements FinderHomeTabRedDotTipsBubbleView.b
  {
    b(FinderHomeTabRedDotTipsBubbleView paramFinderHomeTabRedDotTipsBubbleView, s params, j paramj) {}
    
    private static final void a(boolean paramBoolean, s params, j paramj)
    {
      AppMethodBeat.i(370793);
      kotlin.g.b.s.u(params, "this$0");
      kotlin.g.b.s.u(paramj, "$holder");
      if (paramBoolean)
      {
        s.f(paramj, false);
        AppMethodBeat.o(370793);
        return;
      }
      s.f(paramj, true);
      AppMethodBeat.o(370793);
    }
    
    public final void onVisibilityChange(boolean paramBoolean)
    {
      AppMethodBeat.i(370797);
      this.DDh.post(new s.b..ExternalSyntheticLambda0(paramBoolean, jdField_this, paramj));
      AppMethodBeat.o(370797);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/convert/FinderFeedFullMergedHeaderConvert$onCreateViewHolder$3", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "getLayoutManager", "()Landroidx/recyclerview/widget/LinearLayoutManager;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends RecyclerView.l
  {
    private final LinearLayoutManager AJH;
    
    c(RecyclerView paramRecyclerView, j paramj, s params)
    {
      AppMethodBeat.i(370792);
      paramRecyclerView = this.AJl.getLayoutManager();
      if (paramRecyclerView == null)
      {
        paramRecyclerView = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        AppMethodBeat.o(370792);
        throw paramRecyclerView;
      }
      this.AJH = ((LinearLayoutManager)paramRecyclerView);
      AppMethodBeat.o(370792);
    }
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(370794);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt);
      a.c("com/tencent/mm/plugin/finder/convert/FinderFeedFullMergedHeaderConvert$onCreateViewHolder$3", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
      kotlin.g.b.s.u(paramRecyclerView, "recyclerView");
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      switch (paramInt)
      {
      }
      for (;;)
      {
        a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedFullMergedHeaderConvert$onCreateViewHolder$3", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
        AppMethodBeat.o(370794);
        return;
        paramRecyclerView = (al)paramj.CSA;
        if ((paramRecyclerView.ECT.position == -1) && (paramRecyclerView.ECT.state == 1))
        {
          paramRecyclerView.ECT.position = this.AJH.Ju();
          continue;
          paramRecyclerView = (al)paramj.CSA;
          if ((paramRecyclerView.ECT.position != -1) && (paramRecyclerView.ECT.position != this.AJH.Ju()))
          {
            paramRecyclerView.ECT.state = -1;
            paramRecyclerView = s.a(jdField_this);
            if (paramRecyclerView != null) {
              FinderHomeTabRedDotTipsBubbleView.a(paramRecyclerView);
            }
          }
        }
      }
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(370796);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt1);
      localb.sc(paramInt2);
      a.c("com/tencent/mm/plugin/finder/convert/FinderFeedFullMergedHeaderConvert$onCreateViewHolder$3", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedFullMergedHeaderConvert$onCreateViewHolder$3", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(370796);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.s
 * JD-Core Version:    0.7.0.1
 */