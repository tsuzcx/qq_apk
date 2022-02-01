package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.video.FinderLongVideoPlayerSeekBar;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout.b;
import com.tencent.mm.plugin.finder.video.FinderVideoSeekBar;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.brq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.af;
import com.tencent.mm.view.HardTouchableLayout.b;
import com.tencent.mm.view.HardTouchableLayout.d;
import com.tencent.mm.view.HardTouchableLayout.g;
import com.tencent.mm.view.MediaBanner;
import com.tencent.mm.view.RecyclerHorizontalViewPager;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderMediaBanner;", "Lcom/tencent/mm/view/MediaBanner;", "Lcom/tencent/mm/ui/base/adapter/ViewWrapper;", "Lcom/tencent/mm/plugin/finder/view/FinderViewPager$CheckScrollHorizontally;", "Landroid/view/GestureDetector$OnGestureListener;", "Landroid/view/GestureDetector$OnDoubleTapListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "hideTextFuture", "Lcom/tencent/threadpool/runnable/FutureEx;", "value", "", "isFrozenRecyclerView", "()Z", "setFrozenRecyclerView", "(Z)V", "isNeedSpaceView", "setNeedSpaceView", "lastDownTime", "", "longVideoSeekBar", "Lcom/tencent/mm/plugin/finder/video/FinderLongVideoPlayerSeekBar;", "getLongVideoSeekBar", "()Lcom/tencent/mm/plugin/finder/video/FinderLongVideoPlayerSeekBar;", "setLongVideoSeekBar", "(Lcom/tencent/mm/plugin/finder/video/FinderLongVideoPlayerSeekBar;)V", "onDoubleClickListener", "Lcom/tencent/mm/view/HardTouchableLayout$OnDoubleClickListener;", "getOnDoubleClickListener", "()Lcom/tencent/mm/view/HardTouchableLayout$OnDoubleClickListener;", "setOnDoubleClickListener", "(Lcom/tencent/mm/view/HardTouchableLayout$OnDoubleClickListener;)V", "onLongClickListener", "Lcom/tencent/mm/view/HardTouchableLayout$OnLongClickListener;", "getOnLongClickListener", "()Lcom/tencent/mm/view/HardTouchableLayout$OnLongClickListener;", "setOnLongClickListener", "(Lcom/tencent/mm/view/HardTouchableLayout$OnLongClickListener;)V", "onSingleClickListener", "Lcom/tencent/mm/view/HardTouchableLayout$OnSingleClickListener;", "getOnSingleClickListener", "()Lcom/tencent/mm/view/HardTouchableLayout$OnSingleClickListener;", "setOnSingleClickListener", "(Lcom/tencent/mm/view/HardTouchableLayout$OnSingleClickListener;)V", "refDeleteTip", "Landroid/widget/TextView;", "refDeleteTipLayout", "Landroid/view/View;", "Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;", "refFeedInfo", "getRefFeedInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;", "setRefFeedInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;)V", "refFromTv", "refLayout", "seekBarLayout", "Lcom/tencent/mm/plugin/finder/video/FinderVideoSeekBar;", "spaceView", "getSpaceView", "()Landroid/view/View;", "topLayer", "touchDetector", "Landroid/view/GestureDetector;", "getTouchDetector", "()Landroid/view/GestureDetector;", "touchDetector$delegate", "Lkotlin/Lazy;", "typeIconIv", "Landroid/widget/ImageView;", "getTypeIconIv", "()Landroid/widget/ImageView;", "canScrollHorizontally", "direction", "parent", "Landroid/view/ViewGroup;", "x", "", "y", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "getContentDescription", "", "getLinearLayoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "onDoubleTap", "e", "onDoubleTapEvent", "onDown", "onFling", "e1", "e2", "velocityX", "velocityY", "onLongPress", "", "onScroll", "distanceX", "distanceY", "onShowPress", "onSingleTapConfirmed", "onSingleTapUp", "refreshRefUI", "removeSeekBar", "startLoopPlay", "stopLoopPlay", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public class FinderMediaBanner
  extends MediaBanner<com.tencent.mm.ui.base.a.b>
  implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, FinderViewPager.a
{
  private brq FSj;
  private final View GBf;
  private final View GBg;
  private final TextView GBh;
  private final View GBi;
  private final TextView GBj;
  private com.tencent.threadpool.i.d<?> GBk;
  private long GBl;
  private final ImageView GBm;
  private final View GBn;
  public final FinderVideoSeekBar GBo;
  private boolean GBp;
  private boolean GBq;
  private HardTouchableLayout.g GBr;
  private HardTouchableLayout.b GBs;
  private HardTouchableLayout.d GBt;
  private FinderLongVideoPlayerSeekBar GqC;
  private final j Gra;
  private final String TAG;
  
  public FinderMediaBanner(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(168377);
    this.TAG = "Finder.FinderMediaBanner";
    paramContext = LayoutInflater.from(getContext()).inflate(e.f.finder_feed_banner_top_layer, null);
    s.s(paramContext, "from(context).inflate(R.…d_banner_top_layer, null)");
    this.GBf = paramContext;
    this.GBl = -1L;
    this.GBm = new ImageView(getContext());
    this.GBn = new View(getContext());
    paramContext = getContext();
    s.s(paramContext, "context");
    this.GBo = new FinderVideoSeekBar(paramContext);
    this.GBp = true;
    setImportantForAccessibility(1);
    addView(this.GBf, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    paramContext = this.GBf.findViewById(e.e.reprint_layout);
    s.s(paramContext, "topLayer.findViewById(R.id.reprint_layout)");
    this.GBg = paramContext;
    setId(e.e.media_banner);
    paramContext = this.GBf.findViewById(e.e.reprint_from_tv);
    s.s(paramContext, "topLayer.findViewById(R.id.reprint_from_tv)");
    this.GBh = ((TextView)paramContext);
    paramContext = this.GBf.findViewById(e.e.deleted_tips_layout);
    s.s(paramContext, "topLayer.findViewById(R.id.deleted_tips_layout)");
    this.GBi = paramContext;
    paramContext = this.GBf.findViewById(e.e.deleted_tips_tv);
    s.s(paramContext, "topLayer.findViewById(R.id.deleted_tips_tv)");
    this.GBj = ((TextView)paramContext);
    fkZ();
    getPagerView().setOverScrollMode(0);
    getPagerView().setNestedScrollingEnabled(false);
    getPagerView().setImportantForAccessibility(2);
    paramContext = new FrameLayout.LayoutParams((int)getContext().getResources().getDimension(e.c.Edge_3A), (int)getContext().getResources().getDimension(e.c.Edge_3A));
    int i = (int)(getContext().getResources().getDimension(e.c.Edge_2A) + getContext().getResources().getDimension(e.c.Edge_0_5_A));
    paramContext.rightMargin = i;
    paramContext.topMargin = i;
    paramContext.gravity = 53;
    this.GBm.setVisibility(8);
    addView((View)this.GBm, (ViewGroup.LayoutParams)paramContext);
    this.GBo.setVisibility(8);
    addView((View)this.GBo);
    paramContext = af.mU(getContext()).inflate(e.f.finder_feed_fav_snake_bar, null);
    paramAttributeSet = new FrameLayout.LayoutParams(-1, -2);
    paramAttributeSet.gravity = 80;
    getPagerViewContainer().addView(paramContext, (ViewGroup.LayoutParams)paramAttributeSet);
    if (this.GBp)
    {
      this.GBn.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(0, com.tencent.mm.cd.a.fromDPToPix(getContext(), 10)));
      paramContext = getContainer();
      if (paramContext != null) {
        paramContext.addView(this.GBn);
      }
    }
    this.Gra = k.cm((kotlin.g.a.a)new a(this));
    AppMethodBeat.o(168377);
  }
  
  public FinderMediaBanner(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(168378);
    this.TAG = "Finder.FinderMediaBanner";
    paramContext = LayoutInflater.from(getContext()).inflate(e.f.finder_feed_banner_top_layer, null);
    s.s(paramContext, "from(context).inflate(R.…d_banner_top_layer, null)");
    this.GBf = paramContext;
    this.GBl = -1L;
    this.GBm = new ImageView(getContext());
    this.GBn = new View(getContext());
    paramContext = getContext();
    s.s(paramContext, "context");
    this.GBo = new FinderVideoSeekBar(paramContext);
    this.GBp = true;
    setImportantForAccessibility(1);
    addView(this.GBf, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    paramContext = this.GBf.findViewById(e.e.reprint_layout);
    s.s(paramContext, "topLayer.findViewById(R.id.reprint_layout)");
    this.GBg = paramContext;
    setId(e.e.media_banner);
    paramContext = this.GBf.findViewById(e.e.reprint_from_tv);
    s.s(paramContext, "topLayer.findViewById(R.id.reprint_from_tv)");
    this.GBh = ((TextView)paramContext);
    paramContext = this.GBf.findViewById(e.e.deleted_tips_layout);
    s.s(paramContext, "topLayer.findViewById(R.id.deleted_tips_layout)");
    this.GBi = paramContext;
    paramContext = this.GBf.findViewById(e.e.deleted_tips_tv);
    s.s(paramContext, "topLayer.findViewById(R.id.deleted_tips_tv)");
    this.GBj = ((TextView)paramContext);
    fkZ();
    getPagerView().setOverScrollMode(0);
    getPagerView().setNestedScrollingEnabled(false);
    getPagerView().setImportantForAccessibility(2);
    paramContext = new FrameLayout.LayoutParams((int)getContext().getResources().getDimension(e.c.Edge_3A), (int)getContext().getResources().getDimension(e.c.Edge_3A));
    paramInt = (int)(getContext().getResources().getDimension(e.c.Edge_2A) + getContext().getResources().getDimension(e.c.Edge_0_5_A));
    paramContext.rightMargin = paramInt;
    paramContext.topMargin = paramInt;
    paramContext.gravity = 53;
    this.GBm.setVisibility(8);
    addView((View)this.GBm, (ViewGroup.LayoutParams)paramContext);
    this.GBo.setVisibility(8);
    addView((View)this.GBo);
    paramContext = af.mU(getContext()).inflate(e.f.finder_feed_fav_snake_bar, null);
    paramAttributeSet = new FrameLayout.LayoutParams(-1, -2);
    paramAttributeSet.gravity = 80;
    getPagerViewContainer().addView(paramContext, (ViewGroup.LayoutParams)paramAttributeSet);
    if (this.GBp)
    {
      this.GBn.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(0, com.tencent.mm.cd.a.fromDPToPix(getContext(), 10)));
      paramContext = getContainer();
      if (paramContext != null) {
        paramContext.addView(this.GBn);
      }
    }
    this.Gra = k.cm((kotlin.g.a.a)new a(this));
    AppMethodBeat.o(168378);
  }
  
  private static final void a(FinderMediaBanner paramFinderMediaBanner)
  {
    AppMethodBeat.i(344018);
    s.u(paramFinderMediaBanner, "this$0");
    paramFinderMediaBanner.GBh.setVisibility(8);
    AppMethodBeat.o(344018);
  }
  
  private static final void a(FinderMediaBanner paramFinderMediaBanner, View paramView)
  {
    AppMethodBeat.i(344027);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramFinderMediaBanner);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderMediaBanner", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    s.u(paramFinderMediaBanner, "this$0");
    localObject2 = new Intent();
    paramView = paramFinderMediaBanner.getRefFeedInfo();
    s.checkNotNull(paramView);
    paramView = paramView.refObjectContact;
    if (paramView == null) {
      paramView = "";
    }
    for (;;)
    {
      ((Intent)localObject2).putExtra("finder_username", paramView);
      paramView = as.GSQ;
      paramView = paramFinderMediaBanner.getContext();
      s.s(paramView, "context");
      as.a.a(paramView, (Intent)localObject2, 0L, 0, false, 124);
      paramView = com.tencent.mm.plugin.finder.utils.a.GfO;
      paramFinderMediaBanner = paramFinderMediaBanner.getContext();
      s.s(paramFinderMediaBanner, "context");
      paramView.enterFinderProfileUI(paramFinderMediaBanner, (Intent)localObject2);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/view/FinderMediaBanner", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(344027);
      return;
      localObject1 = paramView.username;
      paramView = (View)localObject1;
      if (localObject1 == null) {
        paramView = "";
      }
    }
  }
  
  private static final void a(FinderMediaBanner paramFinderMediaBanner, boolean paramBoolean)
  {
    AppMethodBeat.i(344042);
    s.u(paramFinderMediaBanner, "this$0");
    paramFinderMediaBanner = paramFinderMediaBanner.getParentRecyclerView();
    if (paramFinderMediaBanner != null) {
      paramFinderMediaBanner.setLayoutFrozen(paramBoolean);
    }
    AppMethodBeat.o(344042);
  }
  
  private static final void b(FinderMediaBanner paramFinderMediaBanner, View paramView)
  {
    AppMethodBeat.i(344036);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramFinderMediaBanner);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderMediaBanner", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    s.u(paramFinderMediaBanner, "this$0");
    localObject2 = new Intent();
    paramView = paramFinderMediaBanner.getRefFeedInfo();
    s.checkNotNull(paramView);
    ((Intent)localObject2).putExtra("KEY_REF_OBJ_ID", paramView.refObjectId);
    paramView = paramFinderMediaBanner.getRefFeedInfo();
    s.checkNotNull(paramView);
    ((Intent)localObject2).putExtra("KEY_REF_OBJ_NONCE_ID", paramView.refObjectNonceId);
    paramView = paramFinderMediaBanner.getRefFeedInfo();
    s.checkNotNull(paramView);
    paramView = paramView.refObjectContact;
    if (paramView == null)
    {
      paramView = "";
      ((Intent)localObject2).putExtra("KEY_TARGET_USERNAME", paramView);
      paramView = paramFinderMediaBanner.getRefFeedInfo();
      s.checkNotNull(paramView);
      paramView = paramView.refObjectContact;
      if (paramView != null) {
        break label238;
      }
      paramView = "";
    }
    for (;;)
    {
      ((Intent)localObject2).putExtra("KEY_TARGET_NICKNAME", paramView);
      paramView = com.tencent.mm.plugin.finder.utils.a.GfO;
      paramFinderMediaBanner = paramFinderMediaBanner.getContext();
      s.s(paramFinderMediaBanner, "context");
      com.tencent.mm.plugin.finder.utils.a.aa(paramFinderMediaBanner, (Intent)localObject2);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/view/FinderMediaBanner", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(344036);
      return;
      localObject1 = paramView.username;
      paramView = (View)localObject1;
      if (localObject1 != null) {
        break;
      }
      paramView = "";
      break;
      label238:
      localObject1 = paramView.nickname;
      paramView = (View)localObject1;
      if (localObject1 == null) {
        paramView = "";
      }
    }
  }
  
  private void fkZ()
  {
    AppMethodBeat.i(168374);
    Object localObject1 = this.GBk;
    if (localObject1 != null) {
      ((com.tencent.threadpool.i.d)localObject1).cancel(false);
    }
    Object localObject2 = this.TAG;
    localObject1 = new StringBuilder("refreshRefUI ");
    boolean bool;
    if (this.FSj == null)
    {
      bool = true;
      localObject3 = ((StringBuilder)localObject1).append(bool).append(' ');
      localObject1 = this.FSj;
      if (localObject1 != null) {
        break label196;
      }
      localObject1 = null;
      label72:
      localObject1 = ((StringBuilder)localObject3).append(localObject1).append(' ');
      localObject3 = this.FSj;
      if ((localObject3 == null) || (((brq)localObject3).refObjectFlag != 0L)) {
        break label204;
      }
      bool = true;
      label107:
      Log.i((String)localObject2, bool);
      if (this.FSj != null)
      {
        localObject1 = this.FSj;
        if (localObject1 != null) {
          break label209;
        }
        localObject1 = null;
        label138:
        if (localObject1 != null)
        {
          localObject1 = this.FSj;
          if ((localObject1 == null) || (((brq)localObject1).refObjectFlag != 0L)) {
            break label217;
          }
        }
      }
    }
    label196:
    label204:
    label209:
    label217:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label222;
      }
      this.GBg.setVisibility(8);
      this.GBi.setVisibility(8);
      AppMethodBeat.o(168374);
      return;
      bool = false;
      break;
      localObject1 = ((brq)localObject1).refObjectContact;
      break label72;
      bool = false;
      break label107;
      localObject1 = ((brq)localObject1).refObjectContact;
      break label138;
    }
    label222:
    this.GBg.setVisibility(0);
    Object localObject3 = getContext();
    localObject1 = this.FSj;
    s.checkNotNull(localObject1);
    localObject1 = ((brq)localObject1).refObjectContact;
    if (localObject1 == null) {
      localObject1 = "";
    }
    for (;;)
    {
      localObject1 = p.b((Context)localObject3, (CharSequence)localObject1);
      localObject2 = getContext().getString(e.h.finder_reprint_from, new Object[] { localObject1 });
      s.s(localObject2, "context.getString(R.stri…r_reprint_from, fromName)");
      this.GBh.setText((CharSequence)localObject2);
      this.GBh.setVisibility(0);
      this.GBk = h.ahAA.o(new FinderMediaBanner..ExternalSyntheticLambda2(this), 3000L);
      localObject2 = this.FSj;
      s.checkNotNull(localObject2);
      if (((brq)localObject2).refObjectFlag != 2L) {
        break;
      }
      this.GBi.setVisibility(0);
      this.GBg.setVisibility(8);
      this.GBj.setText((CharSequence)localObject1);
      this.GBi.setOnClickListener(new FinderMediaBanner..ExternalSyntheticLambda0(this));
      AppMethodBeat.o(168374);
      return;
      localObject2 = ((FinderContact)localObject1).nickname;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
    }
    this.GBi.setVisibility(8);
    this.GBg.setOnClickListener(new FinderMediaBanner..ExternalSyntheticLambda1(this));
    AppMethodBeat.o(168374);
  }
  
  private final GestureDetector getTouchDetector()
  {
    AppMethodBeat.i(344012);
    GestureDetector localGestureDetector = (GestureDetector)this.Gra.getValue();
    AppMethodBeat.o(344012);
    return localGestureDetector;
  }
  
  public final boolean a(int paramInt, ViewGroup paramViewGroup, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(344154);
    s.u(paramViewGroup, "parent");
    if (!getManager().canScrollHorizontally())
    {
      AppMethodBeat.o(344154);
      return false;
    }
    int i = getManager().Ju();
    paramViewGroup = getAdapter();
    if ((paramViewGroup != null) && (i >= 0) && (i < paramViewGroup.getItemCount()) && (paramViewGroup.getItemViewType(i) == 2))
    {
      AppMethodBeat.o(344154);
      return true;
    }
    if (getManager().getItemCount() <= 1)
    {
      paramViewGroup = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.eSh().bmg()).intValue() != 1)
      {
        AppMethodBeat.o(344154);
        return true;
      }
      AppMethodBeat.o(344154);
      return false;
    }
    if ((paramInt > 0) && (getManager().Jx() == getManager().getItemCount() - 1))
    {
      paramViewGroup = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.eSh().bmg()).intValue() != 1)
      {
        AppMethodBeat.o(344154);
        return true;
      }
      AppMethodBeat.o(344154);
      return false;
    }
    if ((paramInt < 0) && (i == 0) && (getManager().Jv() == 0))
    {
      paramViewGroup = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.eSh().bmg()).intValue() != 1)
      {
        AppMethodBeat.o(344154);
        return true;
      }
      AppMethodBeat.o(344154);
      return false;
    }
    AppMethodBeat.o(344154);
    return true;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(344194);
    super.dispatchTouchEvent(paramMotionEvent);
    GestureDetector localGestureDetector = getTouchDetector();
    paramMotionEvent = new com.tencent.mm.hellhoundlib.b.a().cG(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b(localGestureDetector, paramMotionEvent.aYi(), "com/tencent/mm/plugin/finder/view/FinderMediaBanner", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)paramMotionEvent.sb(0)), "com/tencent/mm/plugin/finder/view/FinderMediaBanner", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(344194);
    return true;
  }
  
  public final void fla()
  {
    AppMethodBeat.i(344160);
    super.fla();
    setKeepScreenOn(true);
    AppMethodBeat.o(344160);
  }
  
  public final void flb()
  {
    AppMethodBeat.i(344166);
    super.flb();
    setKeepScreenOn(false);
    AppMethodBeat.o(344166);
  }
  
  public CharSequence getContentDescription()
  {
    AppMethodBeat.i(344120);
    Object localObject = getPagerView().fU(getFocusPosition());
    if (localObject != null)
    {
      localObject = (FinderVideoLayout)((RecyclerView.v)localObject).caK.findViewById(e.e.finder_banner_video_layout);
      if (localObject != null)
      {
        localObject = ((FinderVideoLayout)localObject).getPlayInfo();
        if ((localObject == null) || (((FinderVideoLayout.b)localObject).GqL != true)) {}
      }
      for (int i = 1; i != 0; i = 0)
      {
        localObject = getResources().getString(e.h.app_play);
        s.s(localObject, "{\n                resour…g.app_play)\n            }");
        localObject = (CharSequence)localObject;
        AppMethodBeat.o(344120);
        return localObject;
      }
      localObject = getResources().getString(e.h.app_pause);
      s.s(localObject, "{\n                resour….app_pause)\n            }");
      localObject = (CharSequence)localObject;
      AppMethodBeat.o(344120);
      return localObject;
    }
    localObject = (CharSequence)"";
    AppMethodBeat.o(344120);
    return localObject;
  }
  
  public final FinderLongVideoPlayerSeekBar getLongVideoSeekBar()
  {
    return this.GqC;
  }
  
  public final HardTouchableLayout.b getOnDoubleClickListener()
  {
    return this.GBs;
  }
  
  public final HardTouchableLayout.d getOnLongClickListener()
  {
    return this.GBt;
  }
  
  public final HardTouchableLayout.g getOnSingleClickListener()
  {
    return this.GBr;
  }
  
  public final brq getRefFeedInfo()
  {
    return this.FSj;
  }
  
  public final View getSpaceView()
  {
    return this.GBn;
  }
  
  public final ImageView getTypeIconIv()
  {
    return this.GBm;
  }
  
  public final LinearLayoutManager hr(Context paramContext)
  {
    AppMethodBeat.i(344143);
    s.u(paramContext, "context");
    paramContext = new FinderLinearLayoutManager(paramContext);
    paramContext.GGx = 50.0F;
    paramContext = (LinearLayoutManager)paramContext;
    AppMethodBeat.o(344143);
    return paramContext;
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(344236);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderMediaBanner", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
    s.u(paramMotionEvent, "e");
    long l = SystemClock.elapsedRealtime() - this.GBl;
    int i;
    if (211L <= l) {
      if (l < 300L) {
        i = 1;
      }
    }
    while (i != 0)
    {
      com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/finder/view/FinderMediaBanner", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(344236);
      return false;
      i = 0;
      continue;
      i = 0;
    }
    localObject = this.GBs;
    if (localObject != null) {
      ((HardTouchableLayout.b)localObject).c((View)this, paramMotionEvent);
    }
    com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/finder/view/FinderMediaBanner", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(344236);
    return true;
  }
  
  public boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(344212);
    this.GBl = SystemClock.elapsedRealtime();
    AppMethodBeat.o(344212);
    return true;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(344227);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderMediaBanner", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.aYj());
    paramMotionEvent = this.GBt;
    if (paramMotionEvent != null) {
      paramMotionEvent.ft((View)this);
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderMediaBanner", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
    AppMethodBeat.o(344227);
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(344247);
    paramMotionEvent = this.GBr;
    if (paramMotionEvent != null) {
      paramMotionEvent.fu((View)this);
    }
    AppMethodBeat.o(344247);
    return true;
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(344202);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderMediaBanner", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
    com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/finder/view/FinderMediaBanner", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(344202);
    return true;
  }
  
  public final void setFrozenRecyclerView(boolean paramBoolean)
  {
    AppMethodBeat.i(344134);
    this.GBq = paramBoolean;
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("[SET] isPassTouchEvent=").append(paramBoolean).append(" isInLayout=");
    Object localObject = getParentRecyclerView();
    if (localObject == null)
    {
      localObject = null;
      Log.i(str, localObject);
      localObject = getParentRecyclerView();
      if ((localObject == null) || (((RecyclerView)localObject).isInLayout() != true)) {
        break label128;
      }
    }
    label128:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label133;
      }
      localObject = getParentRecyclerView();
      if (localObject == null) {
        break label147;
      }
      ((RecyclerView)localObject).post(new FinderMediaBanner..ExternalSyntheticLambda3(this, paramBoolean));
      AppMethodBeat.o(344134);
      return;
      localObject = Boolean.valueOf(((RecyclerView)localObject).isInLayout());
      break;
    }
    label133:
    localObject = getParentRecyclerView();
    if (localObject != null) {
      ((RecyclerView)localObject).setLayoutFrozen(paramBoolean);
    }
    label147:
    AppMethodBeat.o(344134);
  }
  
  public final void setLongVideoSeekBar(FinderLongVideoPlayerSeekBar paramFinderLongVideoPlayerSeekBar)
  {
    this.GqC = paramFinderLongVideoPlayerSeekBar;
  }
  
  public final void setNeedSpaceView(boolean paramBoolean)
  {
    AppMethodBeat.i(344110);
    this.GBp = paramBoolean;
    if (!paramBoolean)
    {
      LinearLayout localLinearLayout = getContainer();
      if (localLinearLayout != null) {
        localLinearLayout.removeView(this.GBn);
      }
    }
    AppMethodBeat.o(344110);
  }
  
  public final void setOnDoubleClickListener(HardTouchableLayout.b paramb)
  {
    this.GBs = paramb;
  }
  
  public final void setOnLongClickListener(HardTouchableLayout.d paramd)
  {
    this.GBt = paramd;
  }
  
  public final void setOnSingleClickListener(HardTouchableLayout.g paramg)
  {
    this.GBr = paramg;
  }
  
  public final void setRefFeedInfo(brq parambrq)
  {
    AppMethodBeat.i(168373);
    this.FSj = parambrq;
    fkZ();
    AppMethodBeat.o(168373);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/GestureDetector;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<GestureDetector>
  {
    a(FinderMediaBanner paramFinderMediaBanner)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderMediaBanner
 * JD-Core Version:    0.7.0.1
 */