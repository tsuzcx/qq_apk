package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.ih;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.feed.model.b;
import com.tencent.mm.plugin.finder.live.component.y;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.upload.action.i;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/FinderFeedSnsAdHandler;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedScrollBaseHandler;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "adFeedFollowDismissRunnable", "Ljava/lang/Runnable;", "adFeedUiActionListener", "com/tencent/mm/plugin/finder/feed/FinderFeedSnsAdHandler$adFeedUiActionListener$1", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedSnsAdHandler$adFeedUiActionListener$1;", "isFollowOnLeavePage", "", "lifecycleObserver", "com/tencent/mm/plugin/finder/feed/FinderFeedSnsAdHandler$lifecycleObserver$1", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedSnsAdHandler$lifecycleObserver$1;", "originAdHintTranslateY", "", "originFooterTranslateY", "originSeekBarTranslateY", "seekLayoutId", "", "userContact", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "cancelAdAnimView", "", "changeAdFollowView", "isFollowed", "contact", "notifyAdFinish", "onAttach", "recycler", "Landroidx/recyclerview/widget/RecyclerView;", "onCenterFeedChange", "ev", "Lcom/tencent/mm/plugin/finder/event/base/ScrollEvent;", "onDetach", "onVideoReplay", "feedId", "", "reportAdClick", "id", "iconType", "actionType", "duration", "curPos", "reportAdExpose", "centerFeed", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "setUserContact", "startAdAnimView", "Companion", "plugin-finder_release"})
public final class p
  extends o
{
  public static final a xyC;
  private final c xyA;
  private final FinderFeedSnsAdHandler.lifecycleObserver.1 xyB;
  private final int xyt;
  public FinderContact xyu;
  private boolean xyv;
  private float xyw;
  private float xyx;
  private float xyy;
  private final Runnable xyz;
  
  static
  {
    AppMethodBeat.i(287242);
    xyC = new a((byte)0);
    AppMethodBeat.o(287242);
  }
  
  public p(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
    AppMethodBeat.i(287241);
    this.xyt = b.f.finder_seek_bar_footer_layout;
    this.xyz = ((Runnable)new b(this));
    this.xyA = new c(this);
    this.xyB = new FinderFeedSnsAdHandler.lifecycleObserver.1(this);
    AppMethodBeat.o(287241);
  }
  
  private final void a(long paramLong, FeedData paramFeedData)
  {
    int i = 2;
    AppMethodBeat.i(287240);
    Object localObject1 = g.Xox;
    Object localObject2 = ((y)g.b((AppCompatActivity)getActivity()).i(y.class)).yci.I(paramLong, 2);
    localObject1 = localObject2;
    if (!(localObject2 instanceof b)) {
      localObject1 = null;
    }
    localObject1 = (b)localObject1;
    if (localObject1 != null)
    {
      localObject1 = Integer.valueOf(((b)localObject1).type);
      if (localObject1 != null) {
        break label177;
      }
      label83:
      if (localObject1 != null) {
        break label290;
      }
      label88:
      i = 0;
      label91:
      Log.i("Finder.FeedAdHandler", "reportAdExpose userContact " + this.xyu + ' ');
      if (i <= 0) {
        break label308;
      }
      paramFeedData = n.zWF;
      paramFeedData = aj.Bnu;
      paramFeedData = aj.a.fZ((Context)getActivity());
      if (paramFeedData == null) {
        break label303;
      }
    }
    label284:
    label290:
    label303:
    for (paramFeedData = paramFeedData.ekY();; paramFeedData = null)
    {
      n.a(paramLong, i, 1, 0, 0, "", paramFeedData);
      AppMethodBeat.o(287240);
      return;
      localObject1 = null;
      break;
      label177:
      if (((Integer)localObject1).intValue() != 8) {
        break label83;
      }
      if (this.xyu == null)
      {
        localObject1 = i.ACa;
        localObject2 = i.ecE();
        if (paramFeedData != null)
        {
          localObject1 = paramFeedData.getUserName();
          paramFeedData = (FeedData)localObject1;
          if (localObject1 != null) {}
        }
        else
        {
          paramFeedData = "";
        }
      }
      for (boolean bool = ((i)localObject2).aAN(paramFeedData);; bool = c(this.xyu))
      {
        Log.i("Finder.FeedAdHandler", "reportAdExpose isFollowCur " + bool + ' ');
        if (bool) {
          break label284;
        }
        i = 3;
        break;
      }
      i = 0;
      break label91;
      if (((Integer)localObject1).intValue() != 9) {
        break label88;
      }
      break label91;
    }
    label308:
    Log.i("Finder.FeedAdHandler", "iconType error: ".concat(String.valueOf(i)));
    AppMethodBeat.o(287240);
  }
  
  private static boolean c(FinderContact paramFinderContact)
  {
    AppMethodBeat.i(287239);
    Object localObject = i.ACa;
    i locali = i.ecE();
    if (paramFinderContact != null)
    {
      localObject = paramFinderContact.username;
      paramFinderContact = (FinderContact)localObject;
      if (localObject != null) {}
    }
    else
    {
      paramFinderContact = "";
    }
    boolean bool = locali.aAN(paramFinderContact);
    AppMethodBeat.o(287239);
    return bool;
  }
  
  private final void dte()
  {
    AppMethodBeat.i(287238);
    Log.i("Finder.FeedAdHandler", "cancelAdAnimView invoke");
    Object localObject1 = this.jLl;
    if (localObject1 != null)
    {
      localObject1 = ((RecyclerView)localObject1).cK(0);
      if (localObject1 != null)
      {
        Object localObject2 = ((RecyclerView.v)localObject1).amk;
        if (localObject2 != null)
        {
          localObject1 = ((View)localObject2).findViewById(b.f.finder_ad_feed_hint_container);
          if (localObject1 != null)
          {
            Log.i("Finder.FeedAdHandler", "cancelAdAnimView");
            Object localObject3 = ((View)localObject2).findViewById(b.f.finder_feed_full_footer_layout);
            if (localObject3 != null)
            {
              Log.i("Finder.FeedAdHandler", "cancelAdAnimView footer translationY " + ((View)localObject3).getTranslationY() + " footer :" + this.xyw);
              ViewPropertyAnimator localViewPropertyAnimator = ((View)localObject3).animate();
              if (localViewPropertyAnimator != null) {
                localViewPropertyAnimator.cancel();
              }
              ((View)localObject3).setTranslationY(0.0F);
            }
            localObject2 = ((View)localObject2).findViewById(this.xyt);
            if (localObject2 != null)
            {
              Log.i("Finder.FeedAdHandler", "cancelAdAnimView seekLayoutId translationY " + ((View)localObject2).getTranslationY() + " seekLayoutId :" + this.xyw);
              localObject3 = ((View)localObject2).animate();
              if (localObject3 != null) {
                ((ViewPropertyAnimator)localObject3).cancel();
              }
              ((View)localObject2).setTranslationY(0.0F);
            }
            Log.i("Finder.FeedAdHandler", "cancelAdAnimView adTip translationY " + ((View)localObject1).getTranslationY() + " adTip :" + this.xyw);
            localObject2 = ((View)localObject1).animate();
            if (localObject2 != null) {
              ((ViewPropertyAnimator)localObject2).cancel();
            }
            ((View)localObject1).setTranslationY(0.0F);
          }
        }
      }
    }
    if (c(this.xyu))
    {
      Log.i("Finder.FeedAdHandler", "cancelAdAnimView isFollowed notify adTip gone");
      localObject1 = this.jLl;
      if (localObject1 != null)
      {
        localObject1 = ((RecyclerView)localObject1).getAdapter();
        if (localObject1 != null)
        {
          ((RecyclerView.a)localObject1).d(0, new kotlin.o(Integer.valueOf(25), Integer.valueOf(6)));
          AppMethodBeat.o(287238);
          return;
        }
      }
    }
    AppMethodBeat.o(287238);
  }
  
  public final void KS(long paramLong)
  {
    AppMethodBeat.i(287234);
    if ((paramLong == this.xym) && (this.xyn == 0) && (!this.xyp))
    {
      Object localObject = this.jLl;
      if (localObject != null)
      {
        localObject = ((RecyclerView)localObject).getAdapter();
        if (localObject != null) {
          ((RecyclerView.a)localObject).d(0, new kotlin.o(Integer.valueOf(24), Integer.valueOf(3)));
        }
      }
    }
    super.KS(paramLong);
    AppMethodBeat.o(287234);
  }
  
  public final void a(com.tencent.mm.plugin.finder.event.base.h paramh)
  {
    AppMethodBeat.i(287232);
    kotlin.g.b.p.k(paramh, "ev");
    Log.i("Finder.FeedAdHandler", "onCenterFeedChange");
    if (this.xyn == 0)
    {
      RecyclerView localRecyclerView = this.jLl;
      if (localRecyclerView != null) {
        localRecyclerView.removeCallbacks(this.xyz);
      }
      dte();
    }
    if (paramh.xrm == 0) {
      a(paramh.xrl, paramh.xro);
    }
    this.xyp = false;
    AppMethodBeat.o(287232);
  }
  
  public final void m(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(287236);
    super.m(paramRecyclerView);
    this.xyA.alive();
    getActivity().getLifecycle().a((androidx.lifecycle.k)this.xyB);
    AppMethodBeat.o(287236);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(287237);
    super.onDetach();
    this.xyA.dead();
    getActivity().getLifecycle().b((androidx.lifecycle.k)this.xyB);
    AppMethodBeat.o(287237);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/FinderFeedSnsAdHandler$Companion;", "", "()V", "AD_HINT_DELAY_TIME", "", "AD_HINT_DISMISS_DURATION", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(p paramp) {}
    
    public final void run()
    {
      AppMethodBeat.i(287704);
      p.a(this.xyD);
      AppMethodBeat.o(287704);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/FinderFeedSnsAdHandler$adFeedUiActionListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderFeedUiActionEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class c
    extends IListener<ih>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.p
 * JD-Core Version:    0.7.0.1
 */