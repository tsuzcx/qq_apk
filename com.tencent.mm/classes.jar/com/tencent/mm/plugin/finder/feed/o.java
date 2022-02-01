package com.tencent.mm.plugin.finder.feed;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.j;
import androidx.lifecycle.p;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.event.base.h;
import com.tencent.mm.plugin.finder.feed.model.b;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.upload.action.i;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.plugin.findersdk.a.ar;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.a;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderFeedSnsAdHandler;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedScrollBaseHandler;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "adFeedFollowDismissRunnable", "Ljava/lang/Runnable;", "adFeedUiActionListener", "com/tencent/mm/plugin/finder/feed/FinderFeedSnsAdHandler$adFeedUiActionListener$1", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedSnsAdHandler$adFeedUiActionListener$1;", "animatedItemView", "Landroid/view/View;", "feedUpdateListener", "com/tencent/mm/plugin/finder/feed/FinderFeedSnsAdHandler$feedUpdateListener$1", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedSnsAdHandler$feedUpdateListener$1;", "isFollowOnLeavePage", "", "lifecycleObserver", "com/tencent/mm/plugin/finder/feed/FinderFeedSnsAdHandler$lifecycleObserver$1", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedSnsAdHandler$lifecycleObserver$1;", "originAdHintTranslateY", "", "originFooterTranslateY", "originSeekBarTranslateY", "seekLayoutId", "", "userContact", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "cancelAdAnimView", "", "changeAdFollowView", "finderViewHolderWithItemId", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "feedId", "", "isFollowed", "contact", "notifyAdFinish", "notifyOtherFollowBtnDismiss", "onAttach", "recycler", "Landroidx/recyclerview/widget/RecyclerView;", "onCenterFeedChange", "ev", "Lcom/tencent/mm/plugin/finder/event/base/ScrollEvent;", "onDetach", "onVideoPlayOneMinute", "onVideoReplay", "postAdFeedFollowDismissTask", "reportAdClick", "id", "iconType", "actionType", "duration", "curPos", "reportAdExpose", "centerFeed", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "setUserContact", "startAdAnimView", "AdFollowDismissRunnable", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class o
  extends n
{
  public static final b AVs;
  private final FinderFeedSnsAdHandler.adFeedUiActionListener.1 AVA;
  private final FinderFeedSnsAdHandler.feedUpdateListener.1 AVB;
  private final FinderFeedSnsAdHandler.lifecycleObserver.1 AVC;
  private View AVD;
  private final int AVt;
  public FinderContact AVu;
  private boolean AVv;
  private float AVw;
  private float AVx;
  private float AVy;
  private Runnable AVz;
  
  static
  {
    AppMethodBeat.i(362867);
    AVs = new b((byte)0);
    AppMethodBeat.o(362867);
  }
  
  public o(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
    AppMethodBeat.i(362700);
    this.AVt = e.e.finder_seek_bar_footer_layout;
    this.AVA = new FinderFeedSnsAdHandler.adFeedUiActionListener.1(this, f.hfK);
    this.AVB = new FinderFeedSnsAdHandler.feedUpdateListener.1(this, f.hfK);
    this.AVC = new FinderFeedSnsAdHandler.lifecycleObserver.1(this);
    AppMethodBeat.o(362700);
  }
  
  private final void a(long paramLong, FeedData paramFeedData)
  {
    Object localObject2 = null;
    AppMethodBeat.i(362767);
    Object localObject1 = k.aeZF;
    localObject1 = ((ar)k.d((AppCompatActivity)getActivity()).cq(ar.class)).eiJ().nE(paramLong);
    label67:
    label72:
    label77:
    int i;
    if ((localObject1 instanceof b))
    {
      localObject1 = (b)localObject1;
      if (localObject1 != null) {
        break label164;
      }
      localObject1 = null;
      if (localObject1 != null) {
        break label177;
      }
      if (localObject1 != null) {
        break label300;
      }
      i = 0;
      label80:
      Log.i("Finder.FeedAdHandler", "reportAdExpose userContact " + this.AVu + ' ');
      if (i <= 0) {
        break label324;
      }
      paramFeedData = z.FrZ;
      paramFeedData = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
      paramFeedData = as.a.hu((Context)getActivity());
      if (paramFeedData != null) {
        break label316;
      }
    }
    label164:
    label177:
    label316:
    for (paramFeedData = localObject2;; paramFeedData = paramFeedData.fou())
    {
      z.a(paramLong, i, 1, 0, 0, "", paramFeedData);
      AppMethodBeat.o(362767);
      return;
      localObject1 = null;
      break;
      localObject1 = Integer.valueOf(((b)localObject1).type);
      break label67;
      if (((Integer)localObject1).intValue() != 8) {
        break label72;
      }
      i locali;
      if (this.AVu == null)
      {
        localObject1 = i.Gde;
        locali = i.fej();
        if (paramFeedData == null) {
          paramFeedData = "";
        }
      }
      label211:
      for (boolean bool = i.a(locali, paramFeedData, false, false, 6);; bool = f(this.AVu))
      {
        Log.i("Finder.FeedAdHandler", "reportAdExpose isFollowCur " + bool + ' ');
        if (bool) {
          break label294;
        }
        i = 3;
        break;
        localObject1 = paramFeedData.getUserName();
        paramFeedData = (FeedData)localObject1;
        if (localObject1 != null) {
          break label211;
        }
        paramFeedData = "";
        break label211;
      }
      i = 0;
      break label80;
      if (((Integer)localObject1).intValue() != 9) {
        break label77;
      }
      i = 2;
      break label80;
    }
    label294:
    label300:
    label324:
    Log.i("Finder.FeedAdHandler", s.X("iconType error: ", Integer.valueOf(i)));
    AppMethodBeat.o(362767);
  }
  
  private static final void a(o paramo)
  {
    int i = 0;
    AppMethodBeat.i(362776);
    s.u(paramo, "this$0");
    if (paramo.AVn - 1 >= 0)
    {
      localObject = paramo.mkw;
      if (localObject != null)
      {
        localObject = ((RecyclerView)localObject).getAdapter();
        if (localObject != null) {
          ((RecyclerView.a)localObject).e(0, paramo.AVn, new r(Integer.valueOf(25), Integer.valueOf(1)));
        }
      }
    }
    Object localObject = paramo.mkw;
    if (localObject == null) {}
    for (;;)
    {
      i -= paramo.AVn + 1;
      if (i > 0)
      {
        localObject = paramo.mkw;
        if (localObject != null)
        {
          localObject = ((RecyclerView)localObject).getAdapter();
          if (localObject != null) {
            ((RecyclerView.a)localObject).e(paramo.AVn + 1, i, new r(Integer.valueOf(25), Integer.valueOf(1)));
          }
        }
      }
      AppMethodBeat.o(362776);
      return;
      localObject = ((RecyclerView)localObject).getAdapter();
      if (localObject != null) {
        i = ((RecyclerView.a)localObject).getItemCount();
      }
    }
  }
  
  private final void ece()
  {
    AppMethodBeat.i(362741);
    Log.i("Finder.FeedAdHandler", "cancelAdAnimView invoke");
    Object localObject2 = this.AVD;
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = ((View)localObject2).findViewById(e.e.finder_ad_feed_hint_container);
      if (localObject1 != null)
      {
        Log.i("Finder.FeedAdHandler", "cancelAdAnimView");
        Object localObject3 = ((View)localObject2).findViewById(e.e.finder_feed_full_footer_layout);
        if (localObject3 != null)
        {
          Log.i("Finder.FeedAdHandler", "cancelAdAnimView footer translationY " + ((View)localObject3).getTranslationY() + " footer :" + this.AVw);
          ViewPropertyAnimator localViewPropertyAnimator = ((View)localObject3).animate();
          if (localViewPropertyAnimator != null) {
            localViewPropertyAnimator.cancel();
          }
          ((View)localObject3).setTranslationY(0.0F);
        }
        localObject2 = ((View)localObject2).findViewById(this.AVt);
        if (localObject2 != null)
        {
          Log.i("Finder.FeedAdHandler", "cancelAdAnimView seekLayoutId translationY " + ((View)localObject2).getTranslationY() + " seekLayoutId :" + this.AVw);
          localObject3 = ((View)localObject2).animate();
          if (localObject3 != null) {
            ((ViewPropertyAnimator)localObject3).cancel();
          }
          ((View)localObject2).setTranslationY(0.0F);
        }
        Log.i("Finder.FeedAdHandler", "cancelAdAnimView adTip translationY " + ((View)localObject1).getTranslationY() + " adTip :" + this.AVw);
        localObject2 = ((View)localObject1).animate();
        if (localObject2 != null) {
          ((ViewPropertyAnimator)localObject2).cancel();
        }
        ((View)localObject1).setTranslationY(0.0F);
      }
    }
    if (f(this.AVu))
    {
      Log.i("Finder.FeedAdHandler", "cancelAdAnimView isFollowed notify adTip gone");
      localObject1 = this.AVD;
      if (localObject1 != null)
      {
        localObject2 = this.mkw;
        if (localObject2 != null)
        {
          localObject1 = ((RecyclerView)localObject2).by((View)localObject1);
          if (localObject1 != null)
          {
            localObject2 = this.mkw;
            if (localObject2 != null)
            {
              localObject2 = ((RecyclerView)localObject2).getAdapter();
              if (localObject2 != null) {
                ((RecyclerView.a)localObject2).t(((RecyclerView.v)localObject1).KJ(), new r(Integer.valueOf(25), Integer.valueOf(6)));
              }
            }
          }
        }
      }
    }
    this.AVD = null;
    AppMethodBeat.o(362741);
  }
  
  private final void ecf()
  {
    AppMethodBeat.i(362746);
    RecyclerView localRecyclerView = this.mkw;
    if (localRecyclerView != null) {
      localRecyclerView.post(new o..ExternalSyntheticLambda0(this));
    }
    AppMethodBeat.o(362746);
  }
  
  private static boolean f(FinderContact paramFinderContact)
  {
    AppMethodBeat.i(362756);
    Object localObject = i.Gde;
    i locali = i.fej();
    if (paramFinderContact == null) {
      paramFinderContact = "";
    }
    for (;;)
    {
      boolean bool = i.a(locali, paramFinderContact, false, true, 2);
      AppMethodBeat.o(362756);
      return bool;
      localObject = paramFinderContact.username;
      paramFinderContact = (FinderContact)localObject;
      if (localObject == null) {
        paramFinderContact = "";
      }
    }
  }
  
  private final void nt(long paramLong)
  {
    AppMethodBeat.i(362712);
    Object localObject = this.AVz;
    if (localObject != null)
    {
      RecyclerView localRecyclerView = this.mkw;
      if (localRecyclerView != null) {
        localRecyclerView.removeCallbacks((Runnable)localObject);
      }
    }
    this.AVz = ((Runnable)new a(paramLong));
    localObject = this.mkw;
    if (localObject != null) {
      ((RecyclerView)localObject).postDelayed(this.AVz, 1000L);
    }
    AppMethodBeat.o(362712);
  }
  
  private final RecyclerView.v nu(long paramLong)
  {
    AppMethodBeat.i(362725);
    Object localObject = this.mkw;
    label35:
    int i;
    label57:
    int j;
    if (localObject == null)
    {
      localObject = null;
      if (!(localObject instanceof WxRecyclerAdapter)) {
        break label128;
      }
      localObject = (WxRecyclerAdapter)localObject;
      if (localObject == null) {
        break label169;
      }
      localObject = ((List)((WxRecyclerAdapter)localObject).data).iterator();
      i = 0;
      if (!((Iterator)localObject).hasNext()) {
        break label147;
      }
      if (((a)((Iterator)localObject).next()).bZA() != paramLong) {
        break label134;
      }
      j = 1;
      label90:
      if (j == 0) {
        break label140;
      }
    }
    for (;;)
    {
      if (i >= 0)
      {
        localObject = this.mkw;
        if (localObject == null)
        {
          AppMethodBeat.o(362725);
          return null;
          localObject = ((RecyclerView)localObject).getAdapter();
          break;
          label128:
          localObject = null;
          break label35;
          label134:
          j = 0;
          break label90;
          label140:
          i += 1;
          break label57;
          label147:
          i = -1;
          continue;
        }
        localObject = ((RecyclerView)localObject).fU(i);
        AppMethodBeat.o(362725);
        return localObject;
      }
    }
    label169:
    AppMethodBeat.o(362725);
    return null;
  }
  
  private final void nv(long paramLong)
  {
    AppMethodBeat.i(362751);
    RecyclerView.v localv = nu(paramLong);
    if ((localv != null) && (localv.KJ() >= 0))
    {
      Object localObject = this.mkw;
      if (localObject != null)
      {
        localObject = ((RecyclerView)localObject).getAdapter();
        if (localObject != null) {
          ((RecyclerView.a)localObject).t(localv.KJ(), new r(Integer.valueOf(24), Integer.valueOf(3)));
        }
      }
    }
    AppMethodBeat.o(362751);
  }
  
  public final void a(h paramh)
  {
    AppMethodBeat.i(362881);
    s.u(paramh, "ev");
    Log.i("Finder.FeedAdHandler", "onCenterFeedChange");
    if (this.AVn == 0)
    {
      RecyclerView localRecyclerView = this.mkw;
      if (localRecyclerView != null) {
        localRecyclerView.removeCallbacks(this.AVz);
      }
      ece();
    }
    if (paramh.AOw == 0) {
      a(paramh.AOv, paramh.AOy);
    }
    this.AVp = false;
    AppMethodBeat.o(362881);
  }
  
  public final void nr(long paramLong)
  {
    AppMethodBeat.i(362887);
    if ((paramLong == this.AVm) && (!this.AVp)) {
      nv(paramLong);
    }
    super.nr(paramLong);
    AppMethodBeat.o(362887);
  }
  
  public final void ns(long paramLong)
  {
    AppMethodBeat.i(362895);
    Log.i("Finder.FeedAdHandler", "onVideoPlayOneMinute");
    if ((paramLong == this.AVm) && (this.AVn == 0) && (!this.AVp))
    {
      Log.i("Finder.FeedAdHandler", s.X("onVideoPlayOneMinute feedId:", Long.valueOf(paramLong)));
      nv(paramLong);
    }
    super.ns(paramLong);
    AppMethodBeat.o(362895);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(362910);
    super.onDetach();
    this.AVA.dead();
    this.AVB.dead();
    getActivity().getLifecycle().removeObserver((p)this.AVC);
    AppMethodBeat.o(362910);
  }
  
  public final void q(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(362904);
    super.q(paramRecyclerView);
    this.AVA.alive();
    this.AVB.alive();
    getActivity().getLifecycle().addObserver((p)this.AVC);
    AppMethodBeat.o(362904);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderFeedSnsAdHandler$AdFollowDismissRunnable;", "Ljava/lang/Runnable;", "feedId", "", "(Lcom/tencent/mm/plugin/finder/feed/FinderFeedSnsAdHandler;J)V", "run", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class a
    implements Runnable
  {
    private final long feedId;
    
    public a()
    {
      AppMethodBeat.i(363841);
      Object localObject;
      this.feedId = localObject;
      AppMethodBeat.o(363841);
    }
    
    public final void run()
    {
      AppMethodBeat.i(363856);
      o.a(o.this, this.feedId);
      o.b(o.this);
      AppMethodBeat.o(363856);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderFeedSnsAdHandler$Companion;", "", "()V", "AD_HINT_DELAY_TIME", "", "AD_HINT_DISMISS_DURATION", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/FinderFeedSnsAdHandler$startAdAnimView$1$1$3", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends AnimatorListenerAdapter
  {
    c(o paramo) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(363727);
      o.c(this.AVE);
      AppMethodBeat.o(363727);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.o
 * JD-Core Version:    0.7.0.1
 */