package com.tencent.mm.plugin.finder.view;

import android.annotation.SuppressLint;
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
import android.view.View.OnClickListener;
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
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.video.FinderLongVideoPlayerSeekBar;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout.b;
import com.tencent.mm.plugin.finder.video.FinderVideoSeekBar;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.bge;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ad;
import com.tencent.mm.view.HardTouchableLayout.b;
import com.tencent.mm.view.HardTouchableLayout.g;
import com.tencent.mm.view.MediaBanner;
import com.tencent.mm.view.RecyclerHorizontalViewPager;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/FinderMediaBanner;", "Lcom/tencent/mm/view/MediaBanner;", "Lcom/tencent/mm/ui/base/adapter/ViewWrapper;", "Lcom/tencent/mm/plugin/finder/view/FinderViewPager$CheckScrollHorizontally;", "Landroid/view/GestureDetector$OnGestureListener;", "Landroid/view/GestureDetector$OnDoubleTapListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "hideTextFuture", "Lcom/tencent/threadpool/runnable/FutureEx;", "value", "", "isFrozenRecyclerView", "()Z", "setFrozenRecyclerView", "(Z)V", "isNeedSpaceView", "setNeedSpaceView", "lastDownTime", "", "longVideoSeekBar", "Lcom/tencent/mm/plugin/finder/video/FinderLongVideoPlayerSeekBar;", "getLongVideoSeekBar", "()Lcom/tencent/mm/plugin/finder/video/FinderLongVideoPlayerSeekBar;", "setLongVideoSeekBar", "(Lcom/tencent/mm/plugin/finder/video/FinderLongVideoPlayerSeekBar;)V", "onDoubleClickListener", "Lcom/tencent/mm/view/HardTouchableLayout$OnDoubleClickListener;", "getOnDoubleClickListener", "()Lcom/tencent/mm/view/HardTouchableLayout$OnDoubleClickListener;", "setOnDoubleClickListener", "(Lcom/tencent/mm/view/HardTouchableLayout$OnDoubleClickListener;)V", "onSingleClickListener", "Lcom/tencent/mm/view/HardTouchableLayout$OnSingleClickListener;", "getOnSingleClickListener", "()Lcom/tencent/mm/view/HardTouchableLayout$OnSingleClickListener;", "setOnSingleClickListener", "(Lcom/tencent/mm/view/HardTouchableLayout$OnSingleClickListener;)V", "refDeleteTip", "Landroid/widget/TextView;", "refDeleteTipLayout", "Landroid/view/View;", "Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;", "refFeedInfo", "getRefFeedInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;", "setRefFeedInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;)V", "refFromTv", "refLayout", "seekBarLayout", "Lcom/tencent/mm/plugin/finder/video/FinderVideoSeekBar;", "spaceView", "getSpaceView", "()Landroid/view/View;", "topLayer", "touchDetector", "Landroid/view/GestureDetector;", "getTouchDetector", "()Landroid/view/GestureDetector;", "touchDetector$delegate", "Lkotlin/Lazy;", "typeIconIv", "Landroid/widget/ImageView;", "getTypeIconIv", "()Landroid/widget/ImageView;", "warnContainer", "canScrollHorizontally", "direction", "parent", "Landroid/view/ViewGroup;", "x", "", "y", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "getContentDescription", "", "getLinearLayoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "onDoubleTap", "e", "onDoubleTapEvent", "onDown", "onFling", "e1", "e2", "velocityX", "velocityY", "onLongPress", "", "onScroll", "distanceX", "distanceY", "onShowPress", "onSingleTapConfirmed", "onSingleTapUp", "refreshRefUI", "removeSeekBar", "startLoopPlay", "stopLoopPlay", "plugin-finder_release"})
public class FinderMediaBanner
  extends MediaBanner<com.tencent.mm.ui.base.a.b>
  implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, FinderViewPager.a
{
  private final f AOG;
  private FinderLongVideoPlayerSeekBar AOa;
  private final View AZc;
  private final View AZd;
  private final View AZe;
  private final TextView AZf;
  private final View AZg;
  private final TextView AZh;
  private com.tencent.e.i.d<?> AZi;
  private long AZj;
  private final ImageView AZk;
  private final View AZl;
  public final FinderVideoSeekBar AZm;
  private boolean AZn;
  private boolean AZo;
  private HardTouchableLayout.g AZp;
  private HardTouchableLayout.b AZq;
  private bge AsP;
  private final String TAG;
  
  public FinderMediaBanner(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(168377);
    this.TAG = "Finder.FinderMediaBanner";
    paramContext = LayoutInflater.from(getContext()).inflate(b.g.finder_feed_banner_top_layer, null);
    p.j(paramContext, "LayoutInflater.from(cont…d_banner_top_layer, null)");
    this.AZc = paramContext;
    paramContext = LayoutInflater.from(getContext()).inflate(b.g.finder_feed_warn_container, null);
    p.j(paramContext, "LayoutInflater.from(cont…eed_warn_container, null)");
    this.AZd = paramContext;
    this.AZj = -1L;
    this.AZk = new ImageView(getContext());
    this.AZl = new View(getContext());
    paramContext = getContext();
    p.j(paramContext, "context");
    this.AZm = new FinderVideoSeekBar(paramContext);
    this.AZn = true;
    setImportantForAccessibility(1);
    addView(this.AZc, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    paramContext = this.AZc.findViewById(b.f.reprint_layout);
    p.j(paramContext, "topLayer.findViewById(R.id.reprint_layout)");
    this.AZe = paramContext;
    setId(b.f.media_banner);
    paramContext = this.AZc.findViewById(b.f.reprint_from_tv);
    p.j(paramContext, "topLayer.findViewById(R.id.reprint_from_tv)");
    this.AZf = ((TextView)paramContext);
    paramContext = this.AZc.findViewById(b.f.deleted_tips_layout);
    p.j(paramContext, "topLayer.findViewById(R.id.deleted_tips_layout)");
    this.AZg = paramContext;
    paramContext = this.AZc.findViewById(b.f.deleted_tips_tv);
    p.j(paramContext, "topLayer.findViewById(R.id.deleted_tips_tv)");
    this.AZh = ((TextView)paramContext);
    eiW();
    getPagerView().setOverScrollMode(0);
    getPagerView().setNestedScrollingEnabled(false);
    getPagerView().setImportantForAccessibility(2);
    paramContext = getContext();
    p.j(paramContext, "context");
    int i = (int)paramContext.getResources().getDimension(b.d.Edge_3A);
    paramContext = getContext();
    p.j(paramContext, "context");
    paramContext = new FrameLayout.LayoutParams(i, (int)paramContext.getResources().getDimension(b.d.Edge_3A));
    paramAttributeSet = getContext();
    p.j(paramAttributeSet, "context");
    float f = paramAttributeSet.getResources().getDimension(b.d.Edge_2A);
    paramAttributeSet = getContext();
    p.j(paramAttributeSet, "context");
    i = (int)(f + paramAttributeSet.getResources().getDimension(b.d.Edge_0_5_A));
    paramContext.rightMargin = i;
    paramContext.topMargin = i;
    paramContext.gravity = 53;
    this.AZk.setVisibility(8);
    addView((View)this.AZk, (ViewGroup.LayoutParams)paramContext);
    this.AZm.setVisibility(8);
    addView((View)this.AZm);
    paramContext = ad.kS(getContext()).inflate(b.g.finder_feed_fav_snake_bar, null);
    paramAttributeSet = new FrameLayout.LayoutParams(-1, -2);
    paramAttributeSet.gravity = 80;
    getPagerViewContainer().addView(paramContext, (ViewGroup.LayoutParams)paramAttributeSet);
    if (this.AZn)
    {
      this.AZl.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(0, com.tencent.mm.ci.a.fromDPToPix(getContext(), 10)));
      paramContext = getContainer();
      if (paramContext != null) {
        paramContext.addView(this.AZl);
      }
      paramContext = getContainer();
      if (paramContext != null) {
        paramContext.addView(this.AZd, 1);
      }
    }
    for (;;)
    {
      this.AOG = g.ar((kotlin.g.a.a)new e(this));
      AppMethodBeat.o(168377);
      return;
      paramContext = getContainer();
      if (paramContext != null) {
        paramContext.addView(this.AZd);
      }
    }
  }
  
  public FinderMediaBanner(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(168378);
    this.TAG = "Finder.FinderMediaBanner";
    paramContext = LayoutInflater.from(getContext()).inflate(b.g.finder_feed_banner_top_layer, null);
    p.j(paramContext, "LayoutInflater.from(cont…d_banner_top_layer, null)");
    this.AZc = paramContext;
    paramContext = LayoutInflater.from(getContext()).inflate(b.g.finder_feed_warn_container, null);
    p.j(paramContext, "LayoutInflater.from(cont…eed_warn_container, null)");
    this.AZd = paramContext;
    this.AZj = -1L;
    this.AZk = new ImageView(getContext());
    this.AZl = new View(getContext());
    paramContext = getContext();
    p.j(paramContext, "context");
    this.AZm = new FinderVideoSeekBar(paramContext);
    this.AZn = true;
    setImportantForAccessibility(1);
    addView(this.AZc, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    paramContext = this.AZc.findViewById(b.f.reprint_layout);
    p.j(paramContext, "topLayer.findViewById(R.id.reprint_layout)");
    this.AZe = paramContext;
    setId(b.f.media_banner);
    paramContext = this.AZc.findViewById(b.f.reprint_from_tv);
    p.j(paramContext, "topLayer.findViewById(R.id.reprint_from_tv)");
    this.AZf = ((TextView)paramContext);
    paramContext = this.AZc.findViewById(b.f.deleted_tips_layout);
    p.j(paramContext, "topLayer.findViewById(R.id.deleted_tips_layout)");
    this.AZg = paramContext;
    paramContext = this.AZc.findViewById(b.f.deleted_tips_tv);
    p.j(paramContext, "topLayer.findViewById(R.id.deleted_tips_tv)");
    this.AZh = ((TextView)paramContext);
    eiW();
    getPagerView().setOverScrollMode(0);
    getPagerView().setNestedScrollingEnabled(false);
    getPagerView().setImportantForAccessibility(2);
    paramContext = getContext();
    p.j(paramContext, "context");
    paramInt = (int)paramContext.getResources().getDimension(b.d.Edge_3A);
    paramContext = getContext();
    p.j(paramContext, "context");
    paramContext = new FrameLayout.LayoutParams(paramInt, (int)paramContext.getResources().getDimension(b.d.Edge_3A));
    paramAttributeSet = getContext();
    p.j(paramAttributeSet, "context");
    float f = paramAttributeSet.getResources().getDimension(b.d.Edge_2A);
    paramAttributeSet = getContext();
    p.j(paramAttributeSet, "context");
    paramInt = (int)(f + paramAttributeSet.getResources().getDimension(b.d.Edge_0_5_A));
    paramContext.rightMargin = paramInt;
    paramContext.topMargin = paramInt;
    paramContext.gravity = 53;
    this.AZk.setVisibility(8);
    addView((View)this.AZk, (ViewGroup.LayoutParams)paramContext);
    this.AZm.setVisibility(8);
    addView((View)this.AZm);
    paramContext = ad.kS(getContext()).inflate(b.g.finder_feed_fav_snake_bar, null);
    paramAttributeSet = new FrameLayout.LayoutParams(-1, -2);
    paramAttributeSet.gravity = 80;
    getPagerViewContainer().addView(paramContext, (ViewGroup.LayoutParams)paramAttributeSet);
    if (this.AZn)
    {
      this.AZl.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(0, com.tencent.mm.ci.a.fromDPToPix(getContext(), 10)));
      paramContext = getContainer();
      if (paramContext != null) {
        paramContext.addView(this.AZl);
      }
      paramContext = getContainer();
      if (paramContext != null) {
        paramContext.addView(this.AZd, 1);
      }
    }
    for (;;)
    {
      this.AOG = g.ar((kotlin.g.a.a)new e(this));
      AppMethodBeat.o(168378);
      return;
      paramContext = getContainer();
      if (paramContext != null) {
        paramContext.addView(this.AZd);
      }
    }
  }
  
  private void eiW()
  {
    AppMethodBeat.i(168374);
    Object localObject1 = this.AZi;
    if (localObject1 != null) {
      ((com.tencent.e.i.d)localObject1).cancel(false);
    }
    Object localObject2 = this.TAG;
    localObject1 = new StringBuilder("refreshRefUI ");
    boolean bool;
    if (this.AsP == null)
    {
      bool = true;
      Object localObject3 = ((StringBuilder)localObject1).append(bool).append(' ');
      localObject1 = this.AsP;
      if (localObject1 == null) {
        break label194;
      }
      localObject1 = ((bge)localObject1).refObjectContact;
      label74:
      localObject1 = ((StringBuilder)localObject3).append(localObject1).append(' ');
      localObject3 = this.AsP;
      if ((localObject3 == null) || (((bge)localObject3).refObjectFlag != 0L)) {
        break label199;
      }
      bool = true;
      label109:
      Log.i((String)localObject2, bool);
      if (this.AsP != null)
      {
        localObject1 = this.AsP;
        if (localObject1 == null) {
          break label204;
        }
      }
    }
    label194:
    label199:
    label204:
    for (localObject1 = ((bge)localObject1).refObjectContact;; localObject1 = null)
    {
      if (localObject1 != null)
      {
        localObject1 = this.AsP;
        if ((localObject1 == null) || (((bge)localObject1).refObjectFlag != 0L)) {
          break label209;
        }
      }
      this.AZe.setVisibility(8);
      this.AZg.setVisibility(8);
      AppMethodBeat.o(168374);
      return;
      bool = false;
      break;
      localObject1 = null;
      break label74;
      bool = false;
      break label109;
    }
    label209:
    this.AZe.setVisibility(0);
    localObject2 = getContext();
    localObject1 = this.AsP;
    if (localObject1 == null) {
      p.iCn();
    }
    localObject1 = ((bge)localObject1).refObjectContact;
    if (localObject1 != null)
    {
      localObject1 = ((FinderContact)localObject1).nickname;
      if (localObject1 == null) {}
    }
    for (localObject1 = (CharSequence)localObject1;; localObject1 = (CharSequence)"")
    {
      localObject1 = com.tencent.mm.pluginsdk.ui.span.l.c((Context)localObject2, (CharSequence)localObject1);
      localObject2 = getContext().getString(b.j.finder_reprint_from, new Object[] { localObject1 });
      p.j(localObject2, "context.getString(R.stri…r_reprint_from, fromName)");
      this.AZf.setText((CharSequence)localObject2);
      this.AZf.setVisibility(0);
      this.AZi = h.ZvG.n((Runnable)new b(this), 3000L);
      localObject2 = this.AsP;
      if (localObject2 == null) {
        p.iCn();
      }
      if (((bge)localObject2).refObjectFlag != 2L) {
        break;
      }
      this.AZg.setVisibility(0);
      this.AZe.setVisibility(8);
      this.AZh.setText((CharSequence)localObject1);
      this.AZg.setOnClickListener((View.OnClickListener)new c(this));
      AppMethodBeat.o(168374);
      return;
    }
    this.AZg.setVisibility(8);
    this.AZe.setOnClickListener((View.OnClickListener)new d(this));
    AppMethodBeat.o(168374);
  }
  
  private final GestureDetector getTouchDetector()
  {
    AppMethodBeat.i(281653);
    GestureDetector localGestureDetector = (GestureDetector)this.AOG.getValue();
    AppMethodBeat.o(281653);
    return localGestureDetector;
  }
  
  public final boolean a(int paramInt, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(281650);
    p.k(paramViewGroup, "parent");
    if (!getManager().canScrollHorizontally())
    {
      AppMethodBeat.o(281650);
      return false;
    }
    int i = getManager().kJ();
    paramViewGroup = getAdapter();
    if ((paramViewGroup != null) && (i >= 0) && (i < paramViewGroup.getItemCount()) && (paramViewGroup.getItemViewType(i) == 2))
    {
      AppMethodBeat.o(281650);
      return true;
    }
    if (getManager().getItemCount() <= 1)
    {
      paramViewGroup = com.tencent.mm.plugin.finder.storage.d.AjH;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.dTP().aSr()).intValue() != 1)
      {
        AppMethodBeat.o(281650);
        return true;
      }
      AppMethodBeat.o(281650);
      return false;
    }
    if ((paramInt > 0) && (getManager().kM() == getManager().getItemCount() - 1))
    {
      paramViewGroup = com.tencent.mm.plugin.finder.storage.d.AjH;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.dTP().aSr()).intValue() != 1)
      {
        AppMethodBeat.o(281650);
        return true;
      }
      AppMethodBeat.o(281650);
      return false;
    }
    if ((paramInt < 0) && (i == 0) && (getManager().kK() == 0))
    {
      paramViewGroup = com.tencent.mm.plugin.finder.storage.d.AjH;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.dTP().aSr()).intValue() != 1)
      {
        AppMethodBeat.o(281650);
        return true;
      }
      AppMethodBeat.o(281650);
      return false;
    }
    AppMethodBeat.o(281650);
    return true;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(281654);
    super.dispatchTouchEvent(paramMotionEvent);
    GestureDetector localGestureDetector = getTouchDetector();
    paramMotionEvent = new com.tencent.mm.hellhoundlib.b.a().bm(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b(localGestureDetector, paramMotionEvent.aFh(), "com/tencent/mm/plugin/finder/view/FinderMediaBanner", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)paramMotionEvent.sf(0)), "com/tencent/mm/plugin/finder/view/FinderMediaBanner", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(281654);
    return true;
  }
  
  public final void eiX()
  {
    AppMethodBeat.i(281651);
    super.eiX();
    setKeepScreenOn(true);
    AppMethodBeat.o(281651);
  }
  
  public final void eiY()
  {
    AppMethodBeat.i(281652);
    super.eiY();
    setKeepScreenOn(false);
    AppMethodBeat.o(281652);
  }
  
  public final LinearLayoutManager fW(Context paramContext)
  {
    AppMethodBeat.i(281649);
    p.k(paramContext, "context");
    paramContext = new FinderLinearLayoutManager(paramContext);
    paramContext.BdV = 50.0F;
    paramContext = (LinearLayoutManager)paramContext;
    AppMethodBeat.o(281649);
    return paramContext;
  }
  
  @SuppressLint({"GetContentDescriptionOverride"})
  public CharSequence getContentDescription()
  {
    AppMethodBeat.i(281645);
    Object localObject = getPagerView().cK(getFocusPosition());
    if (localObject != null)
    {
      localObject = (FinderVideoLayout)((RecyclerView.v)localObject).amk.findViewById(b.f.finder_banner_video_layout);
      if (localObject != null)
      {
        localObject = ((FinderVideoLayout)localObject).getPlayInfo();
        if ((localObject != null) && (((FinderVideoLayout.b)localObject).AOk == true))
        {
          localObject = getResources().getString(b.j.app_play);
          p.j(localObject, "resources.getString(R.string.app_play)");
          localObject = (CharSequence)localObject;
          AppMethodBeat.o(281645);
          return localObject;
        }
      }
      localObject = getResources().getString(b.j.app_pause);
      p.j(localObject, "resources.getString(R.string.app_pause)");
      localObject = (CharSequence)localObject;
      AppMethodBeat.o(281645);
      return localObject;
    }
    localObject = (CharSequence)"";
    AppMethodBeat.o(281645);
    return localObject;
  }
  
  public final FinderLongVideoPlayerSeekBar getLongVideoSeekBar()
  {
    return this.AOa;
  }
  
  public final HardTouchableLayout.b getOnDoubleClickListener()
  {
    return this.AZq;
  }
  
  public final HardTouchableLayout.g getOnSingleClickListener()
  {
    return this.AZp;
  }
  
  public final bge getRefFeedInfo()
  {
    return this.AsP;
  }
  
  public final View getSpaceView()
  {
    return this.AZl;
  }
  
  public final ImageView getTypeIconIv()
  {
    return this.AZk;
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(281659);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderMediaBanner", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
    p.k(paramMotionEvent, "e");
    long l = SystemClock.elapsedRealtime() - this.AZj;
    if (211L > l) {}
    while (300L <= l)
    {
      localObject = this.AZq;
      if (localObject != null) {
        ((HardTouchableLayout.b)localObject).a((View)this, paramMotionEvent);
      }
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/finder/view/FinderMediaBanner", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(281659);
      return true;
    }
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/finder/view/FinderMediaBanner", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(281659);
    return false;
  }
  
  public boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(281657);
    this.AZj = SystemClock.elapsedRealtime();
    AppMethodBeat.o(281657);
    return true;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(281658);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderMediaBanner", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.aFi());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderMediaBanner", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
    AppMethodBeat.o(281658);
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(281660);
    paramMotionEvent = this.AZp;
    if (paramMotionEvent != null) {
      paramMotionEvent.et((View)this);
    }
    AppMethodBeat.o(281660);
    return true;
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(281655);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderMediaBanner", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
    com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/finder/view/FinderMediaBanner", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(281655);
    return true;
  }
  
  public final void setFrozenRecyclerView(final boolean paramBoolean)
  {
    AppMethodBeat.i(281648);
    this.AZo = paramBoolean;
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("[SET] isPassTouchEvent=").append(paramBoolean).append(" isInLayout=");
    Object localObject = getParentRecyclerView();
    if (localObject != null) {}
    for (localObject = Boolean.valueOf(((RecyclerView)localObject).isInLayout());; localObject = null)
    {
      Log.i(str, localObject);
      localObject = getParentRecyclerView();
      if ((localObject == null) || (((RecyclerView)localObject).isInLayout() != true)) {
        break label130;
      }
      localObject = getParentRecyclerView();
      if (localObject == null) {
        break;
      }
      ((RecyclerView)localObject).post((Runnable)new a(this, paramBoolean));
      AppMethodBeat.o(281648);
      return;
    }
    AppMethodBeat.o(281648);
    return;
    label130:
    localObject = getParentRecyclerView();
    if (localObject != null)
    {
      ((RecyclerView)localObject).setLayoutFrozen(paramBoolean);
      AppMethodBeat.o(281648);
      return;
    }
    AppMethodBeat.o(281648);
  }
  
  public final void setLongVideoSeekBar(FinderLongVideoPlayerSeekBar paramFinderLongVideoPlayerSeekBar)
  {
    this.AOa = paramFinderLongVideoPlayerSeekBar;
  }
  
  public final void setNeedSpaceView(boolean paramBoolean)
  {
    AppMethodBeat.i(281642);
    this.AZn = paramBoolean;
    if (!paramBoolean)
    {
      LinearLayout localLinearLayout = getContainer();
      if (localLinearLayout != null)
      {
        localLinearLayout.removeView(this.AZl);
        AppMethodBeat.o(281642);
        return;
      }
    }
    AppMethodBeat.o(281642);
  }
  
  public final void setOnDoubleClickListener(HardTouchableLayout.b paramb)
  {
    this.AZq = paramb;
  }
  
  public final void setOnSingleClickListener(HardTouchableLayout.g paramg)
  {
    this.AZp = paramg;
  }
  
  public final void setRefFeedInfo(bge parambge)
  {
    AppMethodBeat.i(168373);
    this.AsP = parambge;
    eiW();
    AppMethodBeat.o(168373);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(FinderMediaBanner paramFinderMediaBanner, boolean paramBoolean) {}
    
    public final void run()
    {
      AppMethodBeat.i(267399);
      RecyclerView localRecyclerView = this.AZr.getParentRecyclerView();
      if (localRecyclerView != null)
      {
        localRecyclerView.setLayoutFrozen(paramBoolean);
        AppMethodBeat.o(267399);
        return;
      }
      AppMethodBeat.o(267399);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(FinderMediaBanner paramFinderMediaBanner) {}
    
    public final void run()
    {
      AppMethodBeat.i(290485);
      FinderMediaBanner.a(this.AZr).setVisibility(8);
      AppMethodBeat.o(290485);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(FinderMediaBanner paramFinderMediaBanner) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168371);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderMediaBanner$refreshRefUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      Intent localIntent = new Intent();
      paramView = this.AZr.getRefFeedInfo();
      if (paramView == null) {
        p.iCn();
      }
      paramView = paramView.refObjectContact;
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
      localObject = paramView;
      if (paramView == null) {
        localObject = "";
      }
      localIntent.putExtra("finder_username", (String)localObject);
      paramView = aj.Bnu;
      paramView = this.AZr.getContext();
      p.j(paramView, "context");
      aj.a.a(paramView, localIntent, 0L, 0, false, 124);
      paramView = com.tencent.mm.plugin.finder.utils.a.ACH;
      paramView = this.AZr.getContext();
      p.j(paramView, "context");
      com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI(paramView, localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderMediaBanner$refreshRefUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(168371);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(FinderMediaBanner paramFinderMediaBanner) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168372);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderMediaBanner$refreshRefUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      Intent localIntent = new Intent();
      paramView = this.AZr.getRefFeedInfo();
      if (paramView == null) {
        p.iCn();
      }
      localIntent.putExtra("KEY_REF_OBJ_ID", paramView.refObjectId);
      paramView = this.AZr.getRefFeedInfo();
      if (paramView == null) {
        p.iCn();
      }
      localIntent.putExtra("KEY_REF_OBJ_NONCE_ID", paramView.refObjectNonceId);
      paramView = this.AZr.getRefFeedInfo();
      if (paramView == null) {
        p.iCn();
      }
      paramView = paramView.refObjectContact;
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
      localObject = paramView;
      if (paramView == null) {
        localObject = "";
      }
      localIntent.putExtra("KEY_TARGET_USERNAME", (String)localObject);
      paramView = this.AZr.getRefFeedInfo();
      if (paramView == null) {
        p.iCn();
      }
      paramView = paramView.refObjectContact;
      if (paramView != null)
      {
        localObject = paramView.nickname;
        paramView = (View)localObject;
        if (localObject != null) {}
      }
      else
      {
        paramView = "";
      }
      localObject = paramView;
      if (paramView == null) {
        localObject = "";
      }
      localIntent.putExtra("KEY_TARGET_NICKNAME", (String)localObject);
      paramView = com.tencent.mm.plugin.finder.utils.a.ACH;
      paramView = this.AZr.getContext();
      p.j(paramView, "context");
      com.tencent.mm.plugin.finder.utils.a.G(paramView, localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderMediaBanner$refreshRefUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(168372);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/GestureDetector;", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<GestureDetector>
  {
    e(FinderMediaBanner paramFinderMediaBanner)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderMediaBanner
 * JD-Core Version:    0.7.0.1
 */