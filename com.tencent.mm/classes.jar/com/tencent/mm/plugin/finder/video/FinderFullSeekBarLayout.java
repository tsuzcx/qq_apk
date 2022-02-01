package com.tencent.mm.plugin.finder.video;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.loader.d.b.g;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.g;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.loader.p;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.report.bb;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.v;
import com.tencent.mm.plugin.finder.upload.action.l;
import com.tencent.mm.plugin.finder.view.FinderViewPager.a;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.brk;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.threadpool.i;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.am;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.n.n;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout;", "Landroid/widget/FrameLayout;", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoSeekBar;", "Lcom/tencent/mm/plugin/finder/view/FinderViewPager$CheckScrollHorizontally;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ENLARGE_OFFSET", "allSec", "allTimeLongTv", "Landroid/widget/TextView;", "getAllTimeLongTv", "()Landroid/widget/TextView;", "allTimeLongTv$delegate", "Lkotlin/Lazy;", "allTimeTv", "getAllTimeTv", "allTimeTv$delegate", "awesomePrivateLayout", "Landroid/view/View;", "getAwesomePrivateLayout", "()Landroid/view/View;", "awesomePrivateLayout$delegate", "currentTimeTv", "getCurrentTimeTv", "currentTimeTv$delegate", "enlargeSeekBarListener", "Landroid/view/View$OnTouchListener;", "excludeIDs", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "fakeFloatPlayIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "floatPlayIcon", "hideHorizontalHintTask", "Ljava/lang/Runnable;", "hidePrivateLike", "", "getHidePrivateLike", "()Z", "setHidePrivateLike", "(Z)V", "hideSeekbarTask", "Lcom/tencent/threadpool/runnable/FutureEx;", "getHideSeekbarTask", "()Lcom/tencent/threadpool/runnable/FutureEx;", "setHideSeekbarTask", "(Lcom/tencent/threadpool/runnable/FutureEx;)V", "horizontalHint", "kotlin.jvm.PlatformType", "getHorizontalHint", "horizontalHint$delegate", "isDraggingSeekBar", "isFinderSelfScene", "isInHeadsetStateChangePauseState", "isPendingExitMode", "isPlaying", "isPlayingCallback", "Lkotlin/Function0;", "()Lkotlin/jvm/functions/Function0;", "setPlayingCallback", "(Lkotlin/jvm/functions/Function0;)V", "isPrivateAwesome", "isSeekBarTrackingTouch", "isSeekMode", "lastProgress", "getLastProgress", "()I", "setLastProgress", "(I)V", "longVideoLayout", "getLongVideoLayout", "longVideoLayout$delegate", "miniWindowBtn", "getMiniWindowBtn", "miniWindowBtn$delegate", "onLongVideoBtnClickListener", "", "getOnLongVideoBtnClickListener", "setOnLongVideoBtnClickListener", "onPauseClickListener", "getOnPauseClickListener", "setOnPauseClickListener", "onPrivateLikeClickListener", "getOnPrivateLikeClickListener", "setOnPrivateLikeClickListener", "onResumePlayListener", "getOnResumePlayListener", "setOnResumePlayListener", "pauseClickByUser", "pauseIcon", "getPauseIcon", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "pauseIcon$delegate", "playCtrlBtn", "getPlayCtrlBtn", "playCtrlBtn$delegate", "privateAweSomeTv", "getPrivateAweSomeTv", "privateAweSomeTv$delegate", "privateAwesomeIcon", "getPrivateAwesomeIcon", "privateAwesomeIcon$delegate", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "seekBar", "Landroid/widget/SeekBar;", "getSeekBar", "()Landroid/widget/SeekBar;", "seekBar$delegate", "seekBarCallback", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoSeekBar$SeekBarCallback;", "seekLayout", "Landroid/view/ViewGroup;", "getSeekLayout", "()Landroid/view/ViewGroup;", "seekLayout$delegate", "seekRect", "Landroid/graphics/Rect;", "tmpMaxProgress", "canScrollHorizontally", "direction", "parent", "x", "", "y", "checkBelongSeekBar", "v", "event", "Landroid/view/MotionEvent;", "checkShowGroupLikeTips", "checkShowHorizontalHint", "dismissGroupLikeTips", "dismissProgressBar", "dispatchTouchEvent", "ev", "enterOnHeadsetStateChangePauseState", "enterSeekMode", "exitOnHeadsetStateChangePauseState", "exitSeekMode", "reason", "", "formatSecToMin", "second", "getCurrentProgress", "getMaxProgress", "getSeekPercent", "hideAwesomePrivateLayout", "isShow", "hideGroupLikeTips", "hideHorizontalHint", "needAnimate", "hideSeekLayout", "isInSeekMode", "isNewsObject", "item", "isSeekingMode", "isShownSeekBar", "onAttachedToWindow", "onDetachedFromWindow", "onHalfEnjoy", "onInterceptTouchEvent", "onProgressChanged", "progress", "fromUser", "onStartTrackingTouch", "onStopTrackingTouch", "onTouchEvent", "refreshAwesome", "refreshFinderFeed", "reportPauseClick", "setExcludeIDs", "set", "", "setFakeFloatPlayIcon", "icon", "setFinderFeed", "setFloatPlayIcon", "setIconState", "view", "setPlayIconState", "setPlayingStatus", "setProgress", "target", "setRecyclerView", "setSeekBarCallback", "callback", "showProgressBar", "isShowThumb", "showSeekLayout", "toggleSeekMode", "updateAllTime", "offsetSec", "updateCurrentTime", "updateProgressMs", "percent", "offsetMs", "", "allMs", "updateProgressSec", "updateSeekTime", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderFullSeekBarLayout
  extends FrameLayout
  implements SeekBar.OnSeekBarChangeListener, s, FinderViewPager.a
{
  public static final FinderFullSeekBarLayout.a GmL;
  private static final HashMap<Long, Integer> GnA;
  private static final int Gnx;
  private static final int Gny;
  private static final int Gnz;
  public BaseFinderFeed AUZ;
  private final j FSi;
  private kotlin.g.a.a<ah> GmM;
  private kotlin.g.a.a<Boolean> GmN;
  private kotlin.g.a.a<Boolean> GmO;
  private kotlin.g.a.a<Boolean> GmP;
  private kotlin.g.a.a<ah> GmQ;
  private final j GmR;
  private final j GmS;
  private final j GmT;
  private final j GmU;
  private final j GmV;
  private final j GmW;
  private final j GmX;
  private final j GmY;
  public final Runnable GmZ;
  private final j Gna;
  private boolean Gnb;
  private final j Gnc;
  private final j Gnd;
  private final j Gne;
  private WeImageView Gnf;
  private boolean Gng;
  private boolean Gnh;
  private WeImageView Gni;
  private boolean Gnj;
  private boolean Gnk;
  private boolean Gnl;
  private s.a Gnm;
  public boolean Gnn;
  public com.tencent.threadpool.i.d<?> Gno;
  private int Gnp;
  private int Gnq;
  public boolean Gnr;
  private final HashSet<Integer> Gns;
  private final Rect Gnt;
  private boolean Gnu;
  private final int Gnv;
  private final View.OnTouchListener Gnw;
  public boolean hLy;
  private RecyclerView mkw;
  private int xmM;
  
  static
  {
    AppMethodBeat.i(335329);
    GmL = new FinderFullSeekBarLayout.a((byte)0);
    Gnx = (int)MMApplicationContext.getContext().getResources().getDimension(e.c.Edge_5A);
    Gny = (int)MMApplicationContext.getContext().getResources().getDimension(e.c.Edge_4A);
    Gnz = (int)MMApplicationContext.getContext().getResources().getDimension(e.c.Edge_1_5_A);
    GnA = new HashMap();
    AppMethodBeat.o(335329);
  }
  
  public FinderFullSeekBarLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(335090);
    this.FSi = kotlin.k.cm((kotlin.g.a.a)new y(this));
    this.GmM = ((kotlin.g.a.a)FinderFullSeekBarLayout.s.GnJ);
    this.GmN = ((kotlin.g.a.a)FinderFullSeekBarLayout.r.GnI);
    this.GmO = ((kotlin.g.a.a)FinderFullSeekBarLayout.q.GnH);
    this.GmP = ((kotlin.g.a.a)FinderFullSeekBarLayout.m.GnF);
    this.GmQ = ((kotlin.g.a.a)FinderFullSeekBarLayout.p.GnG);
    this.xmM = -1;
    this.GmR = kotlin.k.cm((kotlin.g.a.a)new z(this));
    this.GmS = kotlin.k.cm((kotlin.g.a.a)new f(this));
    this.GmT = kotlin.k.cm((kotlin.g.a.a)new c(this));
    this.GmU = kotlin.k.cm((kotlin.g.a.a)new b(this));
    this.GmV = kotlin.k.cm((kotlin.g.a.a)new n(this));
    this.GmW = kotlin.k.cm((kotlin.g.a.a)new o(this));
    this.GmX = kotlin.k.cm((kotlin.g.a.a)new u(this));
    this.GmY = kotlin.k.cm((kotlin.g.a.a)new l(this));
    this.GmZ = new FinderFullSeekBarLayout..ExternalSyntheticLambda5(this);
    this.Gna = kotlin.k.cm((kotlin.g.a.a)new d(this));
    this.Gnb = true;
    this.Gnc = kotlin.k.cm((kotlin.g.a.a)new t(this));
    this.Gnd = kotlin.k.cm((kotlin.g.a.a)new w(this));
    this.Gne = kotlin.k.cm((kotlin.g.a.a)new v(this));
    this.Gnp = -1;
    this.Gns = new HashSet();
    this.Gnt = new Rect();
    this.Gnv = 80;
    this.Gnw = new FinderFullSeekBarLayout..ExternalSyntheticLambda0(this);
    AppMethodBeat.o(335090);
  }
  
  public FinderFullSeekBarLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(335096);
    this.FSi = kotlin.k.cm((kotlin.g.a.a)new y(this));
    this.GmM = ((kotlin.g.a.a)FinderFullSeekBarLayout.s.GnJ);
    this.GmN = ((kotlin.g.a.a)FinderFullSeekBarLayout.r.GnI);
    this.GmO = ((kotlin.g.a.a)FinderFullSeekBarLayout.q.GnH);
    this.GmP = ((kotlin.g.a.a)FinderFullSeekBarLayout.m.GnF);
    this.GmQ = ((kotlin.g.a.a)FinderFullSeekBarLayout.p.GnG);
    this.xmM = -1;
    this.GmR = kotlin.k.cm((kotlin.g.a.a)new z(this));
    this.GmS = kotlin.k.cm((kotlin.g.a.a)new f(this));
    this.GmT = kotlin.k.cm((kotlin.g.a.a)new c(this));
    this.GmU = kotlin.k.cm((kotlin.g.a.a)new b(this));
    this.GmV = kotlin.k.cm((kotlin.g.a.a)new n(this));
    this.GmW = kotlin.k.cm((kotlin.g.a.a)new o(this));
    this.GmX = kotlin.k.cm((kotlin.g.a.a)new u(this));
    this.GmY = kotlin.k.cm((kotlin.g.a.a)new l(this));
    this.GmZ = new FinderFullSeekBarLayout..ExternalSyntheticLambda5(this);
    this.Gna = kotlin.k.cm((kotlin.g.a.a)new d(this));
    this.Gnb = true;
    this.Gnc = kotlin.k.cm((kotlin.g.a.a)new t(this));
    this.Gnd = kotlin.k.cm((kotlin.g.a.a)new w(this));
    this.Gne = kotlin.k.cm((kotlin.g.a.a)new v(this));
    this.Gnp = -1;
    this.Gns = new HashSet();
    this.Gnt = new Rect();
    this.Gnv = 80;
    this.Gnw = new FinderFullSeekBarLayout..ExternalSyntheticLambda0(this);
    AppMethodBeat.o(335096);
  }
  
  private final void Uz(int paramInt)
  {
    AppMethodBeat.i(335210);
    getCurrentTimeTv().setText((CharSequence)formatSecToMin(paramInt));
    AppMethodBeat.o(335210);
  }
  
  private static final void a(FinderFullSeekBarLayout paramFinderFullSeekBarLayout)
  {
    AppMethodBeat.i(335242);
    kotlin.g.b.s.u(paramFinderFullSeekBarLayout, "this$0");
    paramFinderFullSeekBarLayout.uz(true);
    AppMethodBeat.o(335242);
  }
  
  private static final void a(FinderFullSeekBarLayout paramFinderFullSeekBarLayout, Rect paramRect, View paramView, int paramInt, final ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(335270);
    kotlin.g.b.s.u(paramFinderFullSeekBarLayout, "this$0");
    kotlin.g.b.s.u(paramRect, "$rect");
    kotlin.g.b.s.u(paramViewGroup, "$parent");
    if (!paramFinderFullSeekBarLayout.Gnn)
    {
      AppMethodBeat.o(335270);
      return;
    }
    View localView = paramFinderFullSeekBarLayout.getAwesomePrivateLayout();
    if (localView != null) {
      localView.getGlobalVisibleRect(paramRect);
    }
    float f1 = paramRect.centerX();
    float f2 = paramView.getWidth() / 2.0F;
    float f3 = paramRect.centerY();
    float f4 = paramView.getHeight() / 2.0F;
    float f5 = paramFinderFullSeekBarLayout.getContext().getResources().getDimension(e.c.Edge_8A);
    paramView.setTranslationX(f1 - f2);
    paramView.setTranslationY(f3 - f4 - f5);
    paramFinderFullSeekBarLayout = paramFinderFullSeekBarLayout.AUZ;
    if (paramFinderFullSeekBarLayout == null) {}
    for (long l = 0L;; l = paramFinderFullSeekBarLayout.bZA())
    {
      paramRect = (Integer)GnA.get(Long.valueOf(l));
      paramFinderFullSeekBarLayout = paramRect;
      if (paramRect == null) {
        paramFinderFullSeekBarLayout = Integer.valueOf(0);
      }
      int i = ((Number)paramFinderFullSeekBarLayout).intValue();
      if (i == 0)
      {
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acZG, Integer.valueOf(paramInt + 1));
        ((Map)GnA).put(Long.valueOf(l), Integer.valueOf(1));
        Log.i("Finder.FullSeekBarLayout", kotlin.g.b.s.X("[checkShowGroupLikeTips] record count=", Integer.valueOf(paramInt + 1)));
      }
      ((Map)GnA).put(Long.valueOf(l), Integer.valueOf(i + 1));
      if (i < 3) {
        paramView.animate().setStartDelay(0L).setDuration(200L).alpha(1.0F).setListener((Animator.AnimatorListener)new e(paramView, paramViewGroup)).start();
      }
      AppMethodBeat.o(335270);
      return;
    }
  }
  
  private static final void a(WeImageView paramWeImageView, FinderFullSeekBarLayout paramFinderFullSeekBarLayout, com.tencent.mm.loader.g.a.a parama, g paramg, Bitmap paramBitmap)
  {
    AppMethodBeat.i(335249);
    kotlin.g.b.s.u(paramWeImageView, "$icon");
    kotlin.g.b.s.u(paramFinderFullSeekBarLayout, "this$0");
    paramWeImageView.setIconColor(paramFinderFullSeekBarLayout.getContext().getResources().getColor(e.b.Red_90));
    AppMethodBeat.o(335249);
  }
  
  private static final boolean a(FinderFullSeekBarLayout paramFinderFullSeekBarLayout, View paramView, MotionEvent paramMotionEvent)
  {
    float f1 = 0.0F;
    AppMethodBeat.i(335283);
    kotlin.g.b.s.u(paramFinderFullSeekBarLayout, "this$0");
    float f3;
    float f4;
    float f2;
    if ((paramFinderFullSeekBarLayout.Gnn) && (paramFinderFullSeekBarLayout.f(paramView, paramMotionEvent)))
    {
      f3 = paramFinderFullSeekBarLayout.Gnt.top;
      f4 = paramFinderFullSeekBarLayout.Gnt.height() / 2.0F;
      f2 = paramMotionEvent.getX() - paramFinderFullSeekBarLayout.Gnt.left;
      if (f2 >= 0.0F) {}
    }
    for (;;)
    {
      paramView = MotionEvent.obtain(paramMotionEvent.getDownTime(), paramMotionEvent.getEventTime(), paramMotionEvent.getAction(), f1, f3 + f4, paramMotionEvent.getMetaState());
      paramFinderFullSeekBarLayout.getSeekBar().onTouchEvent(paramView);
      for (boolean bool = true;; bool = false)
      {
        if ((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1)) {
          paramFinderFullSeekBarLayout.Gnu = false;
        }
        if (!paramFinderFullSeekBarLayout.Gnu) {
          paramFinderFullSeekBarLayout.getParent().requestDisallowInterceptTouchEvent(false);
        }
        AppMethodBeat.o(335283);
        return bool;
        if (f2 <= paramFinderFullSeekBarLayout.Gnt.width()) {
          break label197;
        }
        f1 = paramFinderFullSeekBarLayout.Gnt.width();
        break;
        paramFinderFullSeekBarLayout.Gnu = false;
      }
      label197:
      f1 = f2;
    }
  }
  
  private static final void b(FinderFullSeekBarLayout paramFinderFullSeekBarLayout)
  {
    AppMethodBeat.i(335260);
    kotlin.g.b.s.u(paramFinderFullSeekBarLayout, "this$0");
    paramFinderFullSeekBarLayout.aCk("onStopTrackingTouch");
    paramFinderFullSeekBarLayout.Gnh = false;
    AppMethodBeat.o(335260);
  }
  
  private static final void b(WeImageView paramWeImageView, final FinderFullSeekBarLayout paramFinderFullSeekBarLayout, com.tencent.mm.loader.g.a.a parama, g paramg, Bitmap paramBitmap)
  {
    AppMethodBeat.i(335258);
    kotlin.g.b.s.u(paramWeImageView, "$icon");
    kotlin.g.b.s.u(paramFinderFullSeekBarLayout, "this$0");
    if (paramBitmap != null) {
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new x(paramWeImageView, paramFinderFullSeekBarLayout));
    }
    AppMethodBeat.o(335258);
  }
  
  private static final void d(View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(335276);
    kotlin.g.b.s.u(paramView, "$it");
    paramView.animate().cancel();
    paramViewGroup.removeView(paramView);
    AppMethodBeat.o(335276);
  }
  
  private final boolean f(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(335235);
    if (paramView == null)
    {
      AppMethodBeat.o(335235);
      return false;
    }
    if (paramMotionEvent == null)
    {
      AppMethodBeat.o(335235);
      return false;
    }
    if (!this.Gnn)
    {
      AppMethodBeat.o(335235);
      return false;
    }
    if (paramMotionEvent.getAction() == 0)
    {
      if (!kotlin.g.b.s.p(paramView, getSeekLayout())) {
        break label190;
      }
      getSeekBar().getHitRect(this.Gnt);
    }
    for (;;)
    {
      if ((!this.Gnu) && (paramMotionEvent.getAction() == 0) && (paramMotionEvent.getY() >= this.Gnt.top - this.Gnv) && (paramMotionEvent.getY() <= this.Gnt.bottom + this.Gnv) && (paramMotionEvent.getX() >= this.Gnt.left) && (paramMotionEvent.getX() <= this.Gnt.right))
      {
        this.Gnu = true;
        getParent().requestDisallowInterceptTouchEvent(true);
      }
      boolean bool = this.Gnu;
      AppMethodBeat.o(335235);
      return bool;
      label190:
      getSeekBar().getGlobalVisibleRect(this.Gnt);
    }
  }
  
  private final void fiD()
  {
    AppMethodBeat.i(335127);
    String str;
    BaseFinderFeed localBaseFinderFeed;
    if (this.Gnb)
    {
      str = "pause_by_icon";
      localBaseFinderFeed = this.AUZ;
      if (localBaseFinderFeed != null)
      {
        localObject = bb.FuK;
        localObject = as.GSQ;
        localObject = getContext();
        kotlin.g.b.s.s(localObject, "context");
        localObject = as.a.hu((Context)localObject);
        if (localObject != null) {
          break label86;
        }
      }
    }
    label86:
    for (Object localObject = null;; localObject = ((as)localObject).fou())
    {
      bb.a((bui)localObject, str, false, localBaseFinderFeed.bZA());
      AppMethodBeat.o(335127);
      return;
      this.Gnb = true;
      str = "pause_by_clckscreen";
      break;
    }
  }
  
  private final void fiJ()
  {
    AppMethodBeat.i(335157);
    Object localObject = getParent();
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(335157);
      throw ((Throwable)localObject);
    }
    localObject = (ViewGroup)localObject;
    View localView = ((ViewGroup)localObject).findViewById(e.e.finder_feed_full_group_like_tips_layout);
    if (localView != null) {
      ((ViewGroup)localObject).removeView(localView);
    }
    AppMethodBeat.o(335157);
  }
  
  private final void fiK()
  {
    AppMethodBeat.i(335201);
    Object localObject1 = this.AUZ;
    label78:
    label107:
    int k;
    if (localObject1 != null)
    {
      localObject1 = ((BaseFinderFeed)localObject1).feedObject;
      if ((localObject1 != null) && (((FinderItem)localObject1).isLongVideo() == true))
      {
        i = 1;
        if (i == 0) {
          break label543;
        }
        localObject1 = this.AUZ;
        if (localObject1 == null) {
          break label538;
        }
        localObject1 = ((BaseFinderFeed)localObject1).feedObject;
        if ((localObject1 == null) || (((FinderItem)localObject1).isPostFinish() != true)) {
          break label538;
        }
        i = 1;
        if (i == 0) {
          break label543;
        }
        getAllTimeTv().setVisibility(8);
        getLongVideoLayout().setVisibility(0);
        getPlayCtrlBtn().setVisibility(0);
        uz(false);
        localObject1 = (ViewGroup)getSeekLayout().findViewById(e.e.part_top_layout);
        k = ((ViewGroup)localObject1).getChildCount();
        if (k <= 0) {}
      }
    }
    int j;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      Object localObject2 = ((ViewGroup)localObject1).getChildAt(i);
      if ((((View)localObject2).getId() != e.e.horizontal_hint_layout) && (((View)localObject2).getId() != e.e.full_long_video_layout))
      {
        Object localObject3 = this.AUZ;
        if (localObject3 == null) {
          break label572;
        }
        localObject3 = ((BaseFinderFeed)localObject3).feedObject;
        if ((localObject3 == null) || (((FinderItem)localObject3).isLongVideo())) {
          break label572;
        }
        i = 1;
        label206:
        if (((i != 0) || (((View)localObject2).getId() != getAllTimeTv().getId())) && (((View)localObject2).getVisibility() != 0))
        {
          localObject3 = ((View)localObject2).animate();
          if (localObject3 != null) {
            ((ViewPropertyAnimator)localObject3).cancel();
          }
          ((View)localObject2).setVisibility(0);
          ((View)localObject2).setAlpha(0.0F);
          ((View)localObject2).animate().alpha(1.0F).setDuration(130L).setListener(null).start();
        }
      }
      if (j >= k)
      {
        localObject1 = getSeekLayout().findViewById(e.e.part_bottom_layout);
        if ((localObject1 != null) && (((View)localObject1).getVisibility() != 0))
        {
          localObject2 = ((View)localObject1).animate();
          if (localObject2 != null) {
            ((ViewPropertyAnimator)localObject2).cancel();
          }
          ((View)localObject1).setVisibility(0);
          ((View)localObject1).setAlpha(0.0F);
          ((View)localObject1).animate().alpha(1.0F).setDuration(130L).setListener((Animator.AnimatorListener)new ab(this)).start();
        }
        localObject1 = this.AUZ;
        if (localObject1 != null)
        {
          localObject1 = ((BaseFinderFeed)localObject1).feedObject;
          if (localObject1 != null)
          {
            localObject1 = ((FinderItem)localObject1).getFeedObject();
            if (localObject1 != null)
            {
              localObject2 = l.Gdj;
              localObject1 = l.fek().u((FinderObject)localObject1);
              bool1 = ((Boolean)((r)localObject1).bsC).booleanValue();
              boolean bool2 = ((Boolean)((r)localObject1).bsD).booleanValue();
              if ((!bool1) || (!bool2)) {
                break label577;
              }
            }
          }
        }
        label538:
        label543:
        label572:
        label577:
        for (boolean bool1 = true;; bool1 = false)
        {
          uw(bool1);
          if ((((Boolean)this.GmP.invoke()).booleanValue()) || (this.Gnr))
          {
            this.Gnb = false;
            if (((Boolean)this.GmO.invoke()).booleanValue()) {
              fiD();
            }
          }
          fiM();
          AppMethodBeat.o(335201);
          return;
          i = 0;
          break;
          i = 0;
          break label78;
          getLongVideoLayout().setVisibility(8);
          getAllTimeTv().setVisibility(0);
          getPlayCtrlBtn().setVisibility(8);
          break label107;
          i = 0;
          break label206;
        }
      }
    }
  }
  
  private final void fiL()
  {
    AppMethodBeat.i(335205);
    fiN();
    Object localObject1 = getSeekLayout().findViewById(e.e.part_bottom_layout);
    Object localObject2;
    if ((localObject1 != null) && (((View)localObject1).getVisibility() == 0))
    {
      localObject2 = ((View)localObject1).animate();
      if (localObject2 != null) {
        ((ViewPropertyAnimator)localObject2).cancel();
      }
      ((View)localObject1).animate().alpha(0.0F).setDuration(130L).setListener((Animator.AnimatorListener)new i((View)localObject1)).start();
    }
    localObject1 = (ViewGroup)getSeekLayout().findViewById(e.e.part_top_layout);
    int k = ((ViewGroup)localObject1).getChildCount();
    if (k > 0) {}
    int j;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      localObject2 = ((ViewGroup)localObject1).getChildAt(i);
      if ((((View)localObject2).getId() != e.e.horizontal_hint_layout) && (((View)localObject2).getId() != e.e.full_long_video_layout) && (((View)localObject2).getVisibility() == 0) && (((View)localObject2).getVisibility() == 0))
      {
        ViewPropertyAnimator localViewPropertyAnimator = ((View)localObject2).animate();
        if (localViewPropertyAnimator != null) {
          localViewPropertyAnimator.cancel();
        }
        ((View)localObject2).animate().alpha(0.0F).setDuration(130L).setListener((Animator.AnimatorListener)new j((View)localObject2)).start();
      }
      if (j >= k)
      {
        if (getPlayCtrlBtn().getVisibility() == 0) {
          getPlayCtrlBtn().animate().alpha(0.0F).setDuration(130L).setListener((Animator.AnimatorListener)new k(this)).start();
        }
        if (!((Boolean)this.GmP.invoke()).booleanValue())
        {
          this.Gnb = false;
          if (((Boolean)this.GmO.invoke()).booleanValue())
          {
            fiD();
            AppMethodBeat.o(335205);
          }
        }
        else
        {
          Log.i("Finder.FullSeekBarLayout", "isPlayingCallback false.");
        }
        AppMethodBeat.o(335205);
        return;
      }
    }
  }
  
  private final void fiM()
  {
    int j = 1;
    AppMethodBeat.i(335231);
    if (!this.Gnk)
    {
      localObject = this.AUZ;
      if ((localObject == null) || (((BaseFinderFeed)localObject).isPreview != true)) {
        break label55;
      }
    }
    label55:
    for (int i = 1; (i != 0) || (this.Gnl); i = 0)
    {
      AppMethodBeat.o(335231);
      return;
    }
    if (this.Gnj)
    {
      AppMethodBeat.o(335231);
      return;
    }
    Object localObject = getAwesomePrivateLayout();
    if ((localObject != null) && (((View)localObject).getVisibility() == 0)) {}
    for (i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(335231);
      return;
    }
    int k = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.acZG, 0);
    if (k < 3)
    {
      localObject = getParent();
      if (localObject == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(335231);
        throw ((Throwable)localObject);
      }
      localObject = (ViewGroup)localObject;
      if (((ViewGroup)localObject).findViewById(e.e.finder_feed_full_group_like_tips_layout) != null) {}
      for (i = j; i != 0; i = 0)
      {
        AppMethodBeat.o(335231);
        return;
      }
      Rect localRect = new Rect();
      View localView = af.mU(getContext()).inflate(e.f.finder_group_like_tips_layout, (ViewGroup)localObject, false);
      localView.setAlpha(0.0F);
      ((ViewGroup)localObject).addView(localView);
      localView.postDelayed(new FinderFullSeekBarLayout..ExternalSyntheticLambda6(this, localRect, localView, k, (ViewGroup)localObject), 600L);
    }
    AppMethodBeat.o(335231);
  }
  
  private static String formatSecToMin(int paramInt)
  {
    AppMethodBeat.i(335223);
    Object localObject = am.aixg;
    localObject = String.format("%02d:%02d", Arrays.copyOf(new Object[] { Long.valueOf(paramInt / 60L), Long.valueOf(paramInt % 60L) }, 2));
    kotlin.g.b.s.s(localObject, "java.lang.String.format(format, *args)");
    AppMethodBeat.o(335223);
    return localObject;
  }
  
  private final TextView getAllTimeLongTv()
  {
    AppMethodBeat.i(335109);
    Object localObject = this.GmU.getValue();
    kotlin.g.b.s.s(localObject, "<get-allTimeLongTv>(...)");
    localObject = (TextView)localObject;
    AppMethodBeat.o(335109);
    return localObject;
  }
  
  private final TextView getAllTimeTv()
  {
    AppMethodBeat.i(335107);
    Object localObject = this.GmT.getValue();
    kotlin.g.b.s.s(localObject, "<get-allTimeTv>(...)");
    localObject = (TextView)localObject;
    AppMethodBeat.o(335107);
    return localObject;
  }
  
  private final View getAwesomePrivateLayout()
  {
    AppMethodBeat.i(335120);
    View localView = (View)this.Gna.getValue();
    AppMethodBeat.o(335120);
    return localView;
  }
  
  private final TextView getCurrentTimeTv()
  {
    AppMethodBeat.i(335102);
    Object localObject = this.GmS.getValue();
    kotlin.g.b.s.s(localObject, "<get-currentTimeTv>(...)");
    localObject = (TextView)localObject;
    AppMethodBeat.o(335102);
    return localObject;
  }
  
  private final View getLongVideoLayout()
  {
    AppMethodBeat.i(335114);
    Object localObject = this.GmV.getValue();
    kotlin.g.b.s.s(localObject, "<get-longVideoLayout>(...)");
    localObject = (View)localObject;
    AppMethodBeat.o(335114);
    return localObject;
  }
  
  private final WeImageView getPauseIcon()
  {
    AppMethodBeat.i(335133);
    WeImageView localWeImageView = (WeImageView)this.Gnc.getValue();
    AppMethodBeat.o(335133);
    return localWeImageView;
  }
  
  private final TextView getPrivateAweSomeTv()
  {
    AppMethodBeat.i(335142);
    TextView localTextView = (TextView)this.Gne.getValue();
    AppMethodBeat.o(335142);
    return localTextView;
  }
  
  private final WeImageView getPrivateAwesomeIcon()
  {
    AppMethodBeat.i(335139);
    WeImageView localWeImageView = (WeImageView)this.Gnd.getValue();
    AppMethodBeat.o(335139);
    return localWeImageView;
  }
  
  private final SeekBar getSeekBar()
  {
    AppMethodBeat.i(335099);
    Object localObject = this.FSi.getValue();
    kotlin.g.b.s.s(localObject, "<get-seekBar>(...)");
    localObject = (SeekBar)localObject;
    AppMethodBeat.o(335099);
    return localObject;
  }
  
  private final float getSeekPercent()
  {
    AppMethodBeat.i(335148);
    SeekBar localSeekBar = getSeekBar();
    if (localSeekBar == null)
    {
      AppMethodBeat.o(335148);
      return 0.0F;
    }
    float f = 1.0F * localSeekBar.getProgress() / localSeekBar.getMax();
    AppMethodBeat.o(335148);
    return f;
  }
  
  private final void ix(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(335215);
    Object localObject = formatSecToMin(paramInt2);
    getAllTimeTv().setText((CharSequence)localObject);
    getAllTimeLongTv().setText((CharSequence)formatSecToMin(paramInt2 - paramInt1));
    localObject = this.AUZ;
    if (localObject != null) {
      ((BaseFinderFeed)localObject).isHasLongVideoTimeBack = true;
    }
    AppMethodBeat.o(335215);
  }
  
  private final void setPlayIconState(boolean paramBoolean)
  {
    AppMethodBeat.i(335174);
    if (this.Gni != null)
    {
      u((View)this.Gni, paramBoolean);
      AppMethodBeat.o(335174);
      return;
    }
    u((View)this.Gnf, paramBoolean);
    AppMethodBeat.o(335174);
  }
  
  private final void u(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(335185);
    if (paramView != null)
    {
      ViewPropertyAnimator localViewPropertyAnimator;
      if (paramBoolean)
      {
        localViewPropertyAnimator = paramView.animate();
        if (localViewPropertyAnimator != null) {
          localViewPropertyAnimator.cancel();
        }
        paramView.setVisibility(0);
        paramView.setAlpha(0.0F);
        paramView = paramView.animate();
        if (paramView != null)
        {
          paramView = paramView.alpha(1.0F);
          if (paramView != null)
          {
            paramView = paramView.setDuration(200L);
            if (paramView != null)
            {
              paramView = paramView.setListener(null);
              if (paramView != null)
              {
                paramView.start();
                AppMethodBeat.o(335185);
              }
            }
          }
        }
      }
      else
      {
        localViewPropertyAnimator = paramView.animate();
        if (localViewPropertyAnimator != null) {
          localViewPropertyAnimator.cancel();
        }
        paramView.setAlpha(1.0F);
        paramView = paramView.animate();
        if (paramView != null)
        {
          paramView = paramView.alpha(0.0F);
          if (paramView != null)
          {
            paramView = paramView.setDuration(200L);
            if (paramView != null)
            {
              paramView = paramView.setListener((Animator.AnimatorListener)new aa(this));
              if (paramView != null) {
                paramView.start();
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(335185);
  }
  
  private final void uy(boolean paramBoolean)
  {
    int j = 1;
    AppMethodBeat.i(335169);
    Object localObject = this.AUZ;
    if ((localObject != null) && (((BaseFinderFeed)localObject).isPreview == true))
    {
      i = 1;
      if ((i == 0) && (!this.Gnk))
      {
        localObject = this.AUZ;
        if (localObject == null) {
          break label182;
        }
        localObject = ((BaseFinderFeed)localObject).feedObject;
        if ((localObject == null) || (((FinderItem)localObject).isPostFinish() != true)) {
          break label182;
        }
      }
    }
    label182:
    for (int i = j;; i = 0)
    {
      if ((i != 0) && (!this.Gnl))
      {
        localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
        if (((Number)com.tencent.mm.plugin.finder.storage.d.eXL().bmg()).intValue() != 0) {
          break label187;
        }
      }
      localObject = getAwesomePrivateLayout();
      if (localObject != null)
      {
        localObject = ((View)localObject).animate();
        if (localObject != null) {
          ((ViewPropertyAnimator)localObject).cancel();
        }
      }
      localObject = getAwesomePrivateLayout();
      if (localObject != null) {
        ((View)localObject).setTag(Boolean.FALSE);
      }
      localObject = getAwesomePrivateLayout();
      if (localObject != null) {
        ((View)localObject).setVisibility(4);
      }
      AppMethodBeat.o(335169);
      return;
      i = 0;
      break;
    }
    label187:
    localObject = getParent();
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(335169);
      throw ((Throwable)localObject);
    }
    localObject = ((ViewGroup)localObject).findViewById(e.e.image_banner_indicator);
    if (localObject != null)
    {
      if (paramBoolean) {
        ((View)localObject).setVisibility(8);
      }
    }
    else
    {
      localObject = getAwesomePrivateLayout();
      if (localObject != null) {
        break label443;
      }
    }
    label443:
    for (localObject = null;; localObject = ((View)localObject).getTag())
    {
      if ((!paramBoolean) || (kotlin.g.b.s.p(localObject, Boolean.TRUE))) {
        break label453;
      }
      localObject = getAwesomePrivateLayout();
      if (localObject != null)
      {
        localObject = ((View)localObject).animate();
        if (localObject != null) {
          ((ViewPropertyAnimator)localObject).cancel();
        }
      }
      localObject = getAwesomePrivateLayout();
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      localObject = getAwesomePrivateLayout();
      if (localObject != null) {
        ((View)localObject).setAlpha(0.0F);
      }
      localObject = getAwesomePrivateLayout();
      if (localObject != null) {
        ((View)localObject).setTag(Boolean.TRUE);
      }
      localObject = getAwesomePrivateLayout();
      if (localObject == null) {
        break label611;
      }
      localObject = ((View)localObject).animate();
      if (localObject == null) {
        break label611;
      }
      localObject = ((ViewPropertyAnimator)localObject).alpha(1.0F);
      if (localObject == null) {
        break label611;
      }
      localObject = ((ViewPropertyAnimator)localObject).setDuration(200L);
      if (localObject == null) {
        break label611;
      }
      localObject = ((ViewPropertyAnimator)localObject).setListener(null);
      if (localObject == null) {
        break label611;
      }
      ((ViewPropertyAnimator)localObject).start();
      AppMethodBeat.o(335169);
      return;
      ((View)localObject).setVisibility(0);
      break;
    }
    label453:
    if ((!paramBoolean) && (!kotlin.g.b.s.p(localObject, Boolean.FALSE)))
    {
      localObject = getAwesomePrivateLayout();
      if (localObject != null)
      {
        localObject = ((View)localObject).animate();
        if (localObject != null) {
          ((ViewPropertyAnimator)localObject).cancel();
        }
      }
      localObject = getAwesomePrivateLayout();
      if (localObject != null) {
        ((View)localObject).setAlpha(1.0F);
      }
      localObject = getAwesomePrivateLayout();
      if (localObject != null) {
        ((View)localObject).setTag(Boolean.FALSE);
      }
      localObject = getAwesomePrivateLayout();
      if (localObject != null)
      {
        localObject = ((View)localObject).animate();
        if (localObject != null)
        {
          localObject = ((ViewPropertyAnimator)localObject).alpha(0.0F);
          if (localObject != null)
          {
            localObject = ((ViewPropertyAnimator)localObject).setDuration(200L);
            if (localObject != null)
            {
              localObject = ((ViewPropertyAnimator)localObject).setListener((Animator.AnimatorListener)new g(this));
              if (localObject != null) {
                ((ViewPropertyAnimator)localObject).start();
              }
            }
          }
        }
      }
    }
    label611:
    AppMethodBeat.o(335169);
  }
  
  private final void uz(boolean paramBoolean)
  {
    AppMethodBeat.i(335190);
    if (paramBoolean)
    {
      getHorizontalHint().setAlpha(1.0F);
      getHorizontalHint().animate().alpha(0.0F).setDuration(300L).setListener((Animator.AnimatorListener)new h(this)).start();
      AppMethodBeat.o(335190);
      return;
    }
    getHorizontalHint().animate().cancel();
    getHorizontalHint().removeCallbacks(this.GmZ);
    getHorizontalHint().setVisibility(8);
    AppMethodBeat.o(335190);
  }
  
  public final void a(boolean paramBoolean, BaseFinderFeed paramBaseFinderFeed)
  {
    int i = 1;
    AppMethodBeat.i(335568);
    this.Gnk = paramBoolean;
    this.AUZ = paramBaseFinderFeed;
    getAllTimeTv().setVisibility(8);
    uz(false);
    getPlayCtrlBtn().setVisibility(8);
    if (paramBaseFinderFeed != null)
    {
      FinderItem localFinderItem = paramBaseFinderFeed.feedObject;
      if ((localFinderItem != null) && (localFinderItem.isLongVideo() == true))
      {
        if (i == 0) {
          break label123;
        }
        getLongVideoLayout().setVisibility(0);
        ix(0, ((dji)paramBaseFinderFeed.feedObject.getLongVideoMediaList().getFirst()).videoDuration);
        getAllTimeLongTv().setTranslationX(0.0F);
      }
    }
    for (;;)
    {
      this.xmM = -1;
      AppMethodBeat.o(335568);
      return;
      i = 0;
      break;
      label123:
      getLongVideoLayout().setVisibility(8);
    }
  }
  
  public final boolean a(int paramInt, ViewGroup paramViewGroup, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(335758);
    kotlin.g.b.s.u(paramViewGroup, "parent");
    if (this.Gnn)
    {
      if (this.Gnt.isEmpty()) {
        getSeekBar().getGlobalVisibleRect(this.Gnt);
      }
      if ((paramFloat2 >= this.Gnt.top - this.Gnv) && (paramFloat2 <= this.Gnt.bottom + this.Gnv) && (paramFloat1 >= this.Gnt.left) && (paramFloat1 <= this.Gnt.right))
      {
        AppMethodBeat.o(335758);
        return true;
      }
    }
    AppMethodBeat.o(335758);
    return false;
  }
  
  public final void aCk(String paramString)
  {
    AppMethodBeat.i(335704);
    kotlin.g.b.s.u(paramString, "reason");
    this.Gnp = -1;
    this.Gnu = false;
    if (!this.Gnn)
    {
      AppMethodBeat.o(335704);
      return;
    }
    Log.i("Finder.FullSeekBarLayout", kotlin.g.b.s.X("[exitSeekMode] reason=", paramString));
    this.Gnn = false;
    fiL();
    uy(false);
    fiJ();
    getSeekLayout().setClickable(false);
    this.Gnh = false;
    if ((n.U(paramString, "onSingleTapUp", false)) && (this.xmM != -1) && (this.xmM != getSeekBar().getProgress()))
    {
      paramString = this.Gnm;
      if (paramString != null) {
        paramString.cq(getSeekPercent());
      }
    }
    this.xmM = -1;
    AppMethodBeat.o(335704);
  }
  
  public final void co(float paramFloat)
  {
    AppMethodBeat.i(335693);
    setProgress(kotlin.h.a.eH(getSeekBar().getMax() * paramFloat));
    AppMethodBeat.o(335693);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(335481);
    if (f((View)this, paramMotionEvent))
    {
      super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(335481);
      return true;
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(335481);
    return bool;
  }
  
  public final void fiE() {}
  
  public final boolean fiF()
  {
    return true;
  }
  
  public final boolean fiG()
  {
    return this.Gng;
  }
  
  public final void fiH()
  {
    AppMethodBeat.i(335715);
    if ((this.Gnn) && (!this.Gnh))
    {
      AppMethodBeat.o(335715);
      return;
    }
    this.Gnn = true;
    setPlayingStatus(false);
    fiK();
    getSeekLayout().setClickable(true);
    this.xmM = getSeekBar().getProgress();
    AppMethodBeat.o(335715);
  }
  
  public final void fiI()
  {
    AppMethodBeat.i(335726);
    Object localObject = getContext();
    if ((localObject instanceof MMActivity))
    {
      localObject = (MMActivity)localObject;
      if ((localObject == null) || (((MMActivity)localObject).isPaused() != true)) {
        break label62;
      }
    }
    label62:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label67;
      }
      Log.w("Finder.FullSeekBarLayout", "[toggleSeekMode] Activity is paused!");
      AppMethodBeat.o(335726);
      return;
      localObject = null;
      break;
    }
    label67:
    localObject = this.Gno;
    if (localObject != null) {
      ((com.tencent.threadpool.i.d)localObject).cancel(false);
    }
    if ((this.Gnn) && (!this.Gnh))
    {
      aCk(kotlin.g.b.s.X("onSingleTapUp#isClickable=", Boolean.valueOf(getSeekLayout().isClickable())));
      if (this.Gnn) {
        break label161;
      }
      announceForAccessibility((CharSequence)getContext().getString(e.h.finder_resumed));
    }
    for (;;)
    {
      this.Gnh = false;
      AppMethodBeat.o(335726);
      return;
      fiH();
      break;
      label161:
      announceForAccessibility((CharSequence)getContext().getString(e.h.finder_paused));
    }
  }
  
  public final void fiN()
  {
    AppMethodBeat.i(335742);
    Log.i("Finder.FullSeekBarLayout", "[dismissGroupLikeTips]");
    Object localObject = getParent();
    if ((localObject instanceof ViewGroup)) {}
    for (localObject = (ViewGroup)localObject;; localObject = null)
    {
      if (localObject != null)
      {
        View localView = ((ViewGroup)localObject).findViewById(e.e.finder_feed_full_group_like_tips_layout);
        if (localView != null) {
          localView.post(new FinderFullSeekBarLayout..ExternalSyntheticLambda3(localView, (ViewGroup)localObject));
        }
      }
      AppMethodBeat.o(335742);
      return;
    }
  }
  
  public final int getCurrentProgress()
  {
    AppMethodBeat.i(335650);
    int i = getSeekBar().getProgress();
    AppMethodBeat.o(335650);
    return i;
  }
  
  public final boolean getHidePrivateLike()
  {
    return this.Gnl;
  }
  
  public final com.tencent.threadpool.i.d<?> getHideSeekbarTask()
  {
    return this.Gno;
  }
  
  public final View getHorizontalHint()
  {
    AppMethodBeat.i(335466);
    View localView = (View)this.GmY.getValue();
    AppMethodBeat.o(335466);
    return localView;
  }
  
  public final int getLastProgress()
  {
    return this.xmM;
  }
  
  public final int getMaxProgress()
  {
    AppMethodBeat.i(335657);
    int i = getSeekBar().getMax();
    AppMethodBeat.o(335657);
    return i;
  }
  
  public final View getMiniWindowBtn()
  {
    AppMethodBeat.i(335451);
    Object localObject = this.GmW.getValue();
    kotlin.g.b.s.s(localObject, "<get-miniWindowBtn>(...)");
    localObject = (View)localObject;
    AppMethodBeat.o(335451);
    return localObject;
  }
  
  public final kotlin.g.a.a<ah> getOnLongVideoBtnClickListener()
  {
    return this.GmQ;
  }
  
  public final kotlin.g.a.a<Boolean> getOnPauseClickListener()
  {
    return this.GmO;
  }
  
  public final kotlin.g.a.a<Boolean> getOnPrivateLikeClickListener()
  {
    return this.GmN;
  }
  
  public final kotlin.g.a.a<ah> getOnResumePlayListener()
  {
    return this.GmM;
  }
  
  public final View getPlayCtrlBtn()
  {
    AppMethodBeat.i(335460);
    Object localObject = this.GmX.getValue();
    kotlin.g.b.s.s(localObject, "<get-playCtrlBtn>(...)");
    localObject = (View)localObject;
    AppMethodBeat.o(335460);
    return localObject;
  }
  
  public final ViewGroup getSeekLayout()
  {
    AppMethodBeat.i(335444);
    Object localObject = this.GmR.getValue();
    kotlin.g.b.s.s(localObject, "<get-seekLayout>(...)");
    localObject = (ViewGroup)localObject;
    AppMethodBeat.o(335444);
    return localObject;
  }
  
  public final void iw(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(335683);
    this.Gnq = paramInt2;
    if (paramInt1 <= 1) {
      this.Gnp = -1;
    }
    ix(paramInt1, paramInt2);
    Uz(paramInt1);
    Object localObject = com.tencent.mm.ui.component.k.aeZF;
    localObject = getContext();
    kotlin.g.b.s.s(localObject, "context");
    localObject = (com.tencent.mm.plugin.finder.viewmodel.component.s)com.tencent.mm.ui.component.k.nq((Context)localObject).cp(com.tencent.mm.plugin.finder.viewmodel.component.s.class);
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.viewmodel.component.s)localObject).GPo.put(Long.valueOf(((com.tencent.mm.plugin.finder.viewmodel.component.s)localObject).GPk), Integer.valueOf(paramInt1));
    }
    AppMethodBeat.o(335683);
  }
  
  protected final void onAttachedToWindow()
  {
    AppMethodBeat.i(335501);
    super.onAttachedToWindow();
    getAllTimeLongTv().setTextSize(1, 14.0F);
    getAllTimeTv().setTextSize(1, 14.0F);
    getCurrentTimeTv().setTextSize(1, 14.0F);
    AppMethodBeat.o(335501);
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(335749);
    super.onDetachedFromWindow();
    fiN();
    if (this.Gnh)
    {
      com.tencent.threadpool.i.d locald = this.Gno;
      if (locald != null) {
        locald.cancel(false);
      }
      aCk("hideSeekbarTask");
    }
    AppMethodBeat.o(335749);
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(335472);
    if ((this.Gnu) || (super.onInterceptTouchEvent(paramMotionEvent)))
    {
      AppMethodBeat.o(335472);
      return true;
    }
    AppMethodBeat.o(335472);
    return false;
  }
  
  public final void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(335607);
    kotlin.g.b.s.u(paramSeekBar, "seekBar");
    if (paramBoolean)
    {
      paramInt = this.Gnq;
      float f1 = getSeekBar().getProgress() / getSeekBar().getMax();
      float f2 = paramInt;
      Uz((int)androidx.core.b.a.g(f1 * f2, 0.0F, f2 - 1.0F));
    }
    AppMethodBeat.o(335607);
  }
  
  public final void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    AppMethodBeat.i(335598);
    kotlin.g.b.s.u(paramSeekBar, "seekBar");
    this.Gng = true;
    paramSeekBar = this.Gnm;
    if (paramSeekBar != null) {
      paramSeekBar.fjz();
    }
    paramSeekBar = this.Gno;
    if (paramSeekBar != null) {
      paramSeekBar.cancel(false);
    }
    fiN();
    AppMethodBeat.o(335598);
  }
  
  public final void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    AppMethodBeat.i(335615);
    kotlin.g.b.s.u(paramSeekBar, "seekBar");
    this.Gng = false;
    this.Gnp = paramSeekBar.getProgress();
    this.Gnh = true;
    paramSeekBar = this.Gnm;
    if (paramSeekBar != null) {
      paramSeekBar.cq(getSeekPercent());
    }
    this.xmM = -1;
    this.GmM.invoke();
    paramSeekBar = this.Gnf;
    if (paramSeekBar != null) {
      paramSeekBar.setVisibility(8);
    }
    paramSeekBar = this.Gno;
    if (paramSeekBar != null) {
      paramSeekBar.cancel(false);
    }
    this.Gno = com.tencent.threadpool.h.ahAA.o(new FinderFullSeekBarLayout..ExternalSyntheticLambda4(this), 3000L);
    AppMethodBeat.o(335615);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(335490);
    if ((this.Gnw.onTouch((View)this, paramMotionEvent)) || (super.onTouchEvent(paramMotionEvent)))
    {
      AppMethodBeat.o(335490);
      return true;
    }
    AppMethodBeat.o(335490);
    return false;
  }
  
  public final void setExcludeIDs(Set<Integer> paramSet)
  {
    AppMethodBeat.i(335734);
    kotlin.g.b.s.u(paramSet, "set");
    this.Gns.addAll((Collection)paramSet);
    AppMethodBeat.o(335734);
  }
  
  public final void setFakeFloatPlayIcon(WeImageView paramWeImageView)
  {
    this.Gni = paramWeImageView;
  }
  
  public final void setFloatPlayIcon(WeImageView paramWeImageView)
  {
    this.Gnf = paramWeImageView;
  }
  
  public final void setHidePrivateLike(boolean paramBoolean)
  {
    this.Gnl = paramBoolean;
  }
  
  public final void setHideSeekbarTask(com.tencent.threadpool.i.d<?> paramd)
  {
    this.Gno = paramd;
  }
  
  public final void setLastProgress(int paramInt)
  {
    this.xmM = paramInt;
  }
  
  public final void setOnLongVideoBtnClickListener(kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(335424);
    kotlin.g.b.s.u(parama, "<set-?>");
    this.GmQ = parama;
    AppMethodBeat.o(335424);
  }
  
  public final void setOnPauseClickListener(kotlin.g.a.a<Boolean> parama)
  {
    AppMethodBeat.i(335403);
    kotlin.g.b.s.u(parama, "<set-?>");
    this.GmO = parama;
    AppMethodBeat.o(335403);
  }
  
  public final void setOnPrivateLikeClickListener(kotlin.g.a.a<Boolean> parama)
  {
    AppMethodBeat.i(335392);
    kotlin.g.b.s.u(parama, "<set-?>");
    this.GmN = parama;
    AppMethodBeat.o(335392);
  }
  
  public final void setOnResumePlayListener(kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(335387);
    kotlin.g.b.s.u(parama, "<set-?>");
    this.GmM = parama;
    AppMethodBeat.o(335387);
  }
  
  public final void setPlayingCallback(kotlin.g.a.a<Boolean> parama)
  {
    AppMethodBeat.i(335410);
    kotlin.g.b.s.u(parama, "<set-?>");
    this.GmP = parama;
    AppMethodBeat.o(335410);
  }
  
  public final void setPlayingStatus(boolean paramBoolean)
  {
    AppMethodBeat.i(335579);
    this.hLy = paramBoolean;
    if (!paramBoolean)
    {
      localWeImageView = getPauseIcon();
      if (localWeImageView != null) {
        localWeImageView.setImageResource(e.g.icons_filled_play);
      }
      setPlayIconState(true);
      uy(true);
      AppMethodBeat.o(335579);
      return;
    }
    WeImageView localWeImageView = getPauseIcon();
    if (localWeImageView != null) {
      localWeImageView.setImageResource(e.g.icons_filled_pause);
    }
    setPlayIconState(false);
    uy(false);
    AppMethodBeat.o(335579);
  }
  
  public final void setProgress(int paramInt)
  {
    AppMethodBeat.i(335631);
    if (paramInt <= 1) {
      this.Gnp = -1;
    }
    getSeekBar().setProgress(Math.max(this.Gnp, paramInt));
    AppMethodBeat.o(335631);
  }
  
  public final void setRecyclerView(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(335507);
    kotlin.g.b.s.u(paramRecyclerView, "recyclerView");
    this.mkw = paramRecyclerView;
    AppMethodBeat.o(335507);
  }
  
  public final void setSeekBarCallback(s.a parama)
  {
    AppMethodBeat.i(335668);
    kotlin.g.b.s.u(parama, "callback");
    this.Gnm = parama;
    AppMethodBeat.o(335668);
  }
  
  public final void uw(boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(335541);
    Object localObject1 = com.tencent.mm.plugin.finder.storage.logic.h.FNM;
    localObject1 = this.AUZ;
    int i;
    label40:
    Object localObject2;
    if (localObject1 == null)
    {
      i = 0;
      localObject1 = com.tencent.mm.plugin.finder.storage.logic.h.TA(i);
      if (localObject1 != null) {
        break label308;
      }
      localObject1 = null;
      this.Gnj = paramBoolean;
      Log.i("Finder.FullSeekBarLayout", "[refreshAwesome] isLike=" + paramBoolean + " groupLikeIconUrl=" + localObject1);
      localObject3 = getPrivateAweSomeTv();
      if (localObject3 != null)
      {
        localObject2 = this.AUZ;
        if (localObject2 == null) {
          break label318;
        }
        localObject2 = ((BaseFinderFeed)localObject2).feedObject;
        if (localObject2 == null) {
          break label318;
        }
        localObject2 = ((FinderItem)localObject2).getFeedObject();
        if ((localObject2 == null) || (((FinderObject)localObject2).objectType != 1)) {
          break label318;
        }
        i = 1;
        label136:
        if (i == 0) {
          break label323;
        }
        localObject2 = (CharSequence)getResources().getString(e.h.finder_awesome_ground_title_news);
        label155:
        ((TextView)localObject3).setText((CharSequence)localObject2);
      }
      localObject2 = getPrivateAwesomeIcon();
      if (localObject2 != null)
      {
        if (!paramBoolean) {
          break label370;
        }
        if (localObject1 == null) {
          break label341;
        }
        ((WeImageView)localObject2).setLayerPaint(null);
        localObject3 = p.ExI;
        localObject1 = p.eCl().dk(new com.tencent.mm.plugin.finder.loader.s((String)localObject1, v.FKY));
        localObject3 = p.ExI;
        ((com.tencent.mm.loader.a.b)localObject1).a(p.a(p.a.ExJ)).a(new FinderFullSeekBarLayout..ExternalSyntheticLambda2((WeImageView)localObject2, this)).d((ImageView)localObject2);
      }
    }
    for (;;)
    {
      fiN();
      AppMethodBeat.o(335541);
      return;
      localObject1 = ((BaseFinderFeed)localObject1).feedObject;
      if (localObject1 == null)
      {
        i = 0;
        break;
      }
      localObject1 = ((FinderItem)localObject1).getFeedObject();
      if (localObject1 == null)
      {
        i = 0;
        break;
      }
      i = ((FinderObject)localObject1).objectType;
      break;
      label308:
      localObject1 = ((brk)localObject1).ZZC;
      break label40;
      label318:
      i = 0;
      break label136;
      label323:
      localObject2 = (CharSequence)getResources().getString(e.h.finder_awesome_ground_title);
      break label155;
      label341:
      ((WeImageView)localObject2).setImageResource(e.g.icons_filled_like_group);
      ((WeImageView)localObject2).setIconColor(getContext().getResources().getColor(e.b.Red_90));
    }
    label370:
    Object localObject3 = (CharSequence)localObject1;
    if (localObject3 != null)
    {
      i = j;
      if (((CharSequence)localObject3).length() != 0) {}
    }
    else
    {
      i = 1;
    }
    if (i != 0) {
      ((WeImageView)localObject2).setImageResource(e.g.icons_filled_like_group);
    }
    for (;;)
    {
      ((WeImageView)localObject2).setIconColor(getContext().getResources().getColor(e.b.hot_tab_BW_100_Alpha_0_8));
      break;
      ((WeImageView)localObject2).setLayerPaint(null);
      localObject3 = p.ExI;
      localObject3 = p.eCl();
      localObject1 = new com.tencent.mm.plugin.finder.loader.s((String)localObject1, v.FKY);
      p localp = p.ExI;
      ((com.tencent.mm.loader.d)localObject3).a(localObject1, p.a(p.a.ExJ)).a(new FinderFullSeekBarLayout..ExternalSyntheticLambda1((WeImageView)localObject2, this)).d((ImageView)localObject2);
    }
  }
  
  public final void ux(boolean paramBoolean) {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout$setIconState$1$1", "Lcom/tencent/mm/plugin/finder/animation/AnimatorEndListener;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class aa
    extends com.tencent.mm.plugin.finder.animation.a
  {
    aa(FinderFullSeekBarLayout paramFinderFullSeekBarLayout) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(335799);
      paramAnimator = FinderFullSeekBarLayout.f(this.GnB);
      if (paramAnimator != null) {
        paramAnimator.setVisibility(4);
      }
      AppMethodBeat.o(335799);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout$showSeekLayout$1$1", "Lcom/tencent/mm/plugin/finder/animation/AnimatorEndListener;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class ab
    extends com.tencent.mm.plugin.finder.animation.a
  {
    ab(FinderFullSeekBarLayout paramFinderFullSeekBarLayout) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(335800);
      BaseFinderFeed localBaseFinderFeed = FinderFullSeekBarLayout.g(this.GnB);
      Object localObject;
      if (localBaseFinderFeed != null)
      {
        paramAnimator = this.GnB;
        localObject = as.GSQ;
        paramAnimator = paramAnimator.getContext();
        kotlin.g.b.s.s(paramAnimator, "context");
        paramAnimator = as.a.hu(paramAnimator);
        if (paramAnimator != null) {
          break label84;
        }
      }
      label84:
      for (paramAnimator = null;; paramAnimator = paramAnimator.fou())
      {
        localObject = bb.FuK;
        bb.a(paramAnimator, "pause_by_icon", true, localBaseFinderFeed.bZA());
        localObject = bb.FuK;
        bb.a(paramAnimator, "private_like", true, localBaseFinderFeed.bZA());
        AppMethodBeat.o(335800);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<TextView>
  {
    b(FinderFullSeekBarLayout paramFinderFullSeekBarLayout)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<TextView>
  {
    c(FinderFullSeekBarLayout paramFinderFullSeekBarLayout)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<View>
  {
    d(FinderFullSeekBarLayout paramFinderFullSeekBarLayout)
    {
      super();
    }
    
    private static final void a(boolean[] paramArrayOfBoolean, FinderFullSeekBarLayout paramFinderFullSeekBarLayout, View paramView)
    {
      AppMethodBeat.i(334881);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramArrayOfBoolean);
      localb.cH(paramFinderFullSeekBarLayout);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout$awesomePrivateLayout$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      kotlin.g.b.s.u(paramArrayOfBoolean, "$likeOnTouchDownCalled");
      kotlin.g.b.s.u(paramFinderFullSeekBarLayout, "this$0");
      if (paramArrayOfBoolean[0] != 0)
      {
        paramArrayOfBoolean[0] = false;
        boolean bool = ((Boolean)paramFinderFullSeekBarLayout.getOnPrivateLikeClickListener().invoke()).booleanValue();
        paramFinderFullSeekBarLayout.fiN();
        paramFinderFullSeekBarLayout.uw(bool);
        if (bool)
        {
          paramView = FinderFullSeekBarLayout.g(paramFinderFullSeekBarLayout);
          if (paramView != null)
          {
            paramArrayOfBoolean = bb.FuK;
            paramArrayOfBoolean = as.GSQ;
            paramArrayOfBoolean = paramFinderFullSeekBarLayout.getContext();
            kotlin.g.b.s.s(paramArrayOfBoolean, "context");
            paramArrayOfBoolean = as.a.hu(paramArrayOfBoolean);
            if (paramArrayOfBoolean != null) {
              break label295;
            }
          }
        }
      }
      label295:
      for (paramArrayOfBoolean = null;; paramArrayOfBoolean = paramArrayOfBoolean.fou())
      {
        bb.a(paramArrayOfBoolean, "private_like", false, paramView.bZA());
        paramFinderFullSeekBarLayout.getOnResumePlayListener().invoke();
        paramArrayOfBoolean = FinderFullSeekBarLayout.f(paramFinderFullSeekBarLayout);
        if (paramArrayOfBoolean != null) {
          paramArrayOfBoolean.setVisibility(8);
        }
        FinderFullSeekBarLayout.a(paramFinderFullSeekBarLayout, true);
        paramArrayOfBoolean = paramFinderFullSeekBarLayout.getHideSeekbarTask();
        if (paramArrayOfBoolean != null) {
          paramArrayOfBoolean.cancel(false);
        }
        paramFinderFullSeekBarLayout.setHideSeekbarTask(com.tencent.threadpool.h.ahAA.o(new FinderFullSeekBarLayout.d..ExternalSyntheticLambda2(paramFinderFullSeekBarLayout), 3000L));
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout$awesomePrivateLayout$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(334881);
        return;
        com.tencent.mm.plugin.normsg.a.d.MtP.kI("ce_feed_like", "<FeedLike>");
        paramArrayOfBoolean = MotionEvent.obtain(0L, 0L, 1, 0.0F, 0.0F, 65535);
        com.tencent.mm.plugin.normsg.a.d.MtP.a("ce_feed_like", paramArrayOfBoolean);
        com.tencent.mm.plugin.normsg.a.d.MtP.aQm("ce_feed_like");
        break;
      }
    }
    
    private static final boolean e(boolean[] paramArrayOfBoolean, View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(334865);
      kotlin.g.b.s.u(paramArrayOfBoolean, "$likeOnTouchDownCalled");
      switch (paramMotionEvent.getAction())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(334865);
        return false;
        paramArrayOfBoolean[0] = true;
        com.tencent.mm.plugin.normsg.a.d.MtP.kI("ce_feed_like", "<FeedLike>");
        continue;
        com.tencent.mm.plugin.normsg.a.d.MtP.a("ce_feed_like", paramMotionEvent);
        com.tencent.mm.plugin.normsg.a.d.MtP.aQm("ce_feed_like");
      }
    }
    
    private static final void i(FinderFullSeekBarLayout paramFinderFullSeekBarLayout)
    {
      AppMethodBeat.i(334868);
      kotlin.g.b.s.u(paramFinderFullSeekBarLayout, "this$0");
      paramFinderFullSeekBarLayout.aCk("hideSeekbarTask");
      FinderFullSeekBarLayout.a(paramFinderFullSeekBarLayout, false);
      AppMethodBeat.o(334868);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout$checkShowGroupLikeTips$1$1", "Lcom/tencent/mm/plugin/finder/animation/AnimatorEndListener;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    extends com.tencent.mm.plugin.finder.animation.a
  {
    e(View paramView, ViewGroup paramViewGroup) {}
    
    private static final void d(ViewGroup paramViewGroup, View paramView)
    {
      AppMethodBeat.i(334844);
      kotlin.g.b.s.u(paramViewGroup, "$parent");
      paramViewGroup.removeView(paramView);
      AppMethodBeat.o(334844);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(334855);
      kotlin.g.b.s.u(paramAnimator, "animation");
      Log.i("Finder.FullSeekBarLayout", "[onAnimationEnd]");
      this.GnC.postDelayed(new FinderFullSeekBarLayout.e..ExternalSyntheticLambda0(paramViewGroup, this.GnC), 5000L);
      AppMethodBeat.o(334855);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<TextView>
  {
    f(FinderFullSeekBarLayout paramFinderFullSeekBarLayout)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout$hideAwesomePrivateLayout$2", "Lcom/tencent/mm/plugin/finder/animation/AnimatorEndListener;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    extends com.tencent.mm.plugin.finder.animation.a
  {
    g(FinderFullSeekBarLayout paramFinderFullSeekBarLayout) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(334890);
      paramAnimator = FinderFullSeekBarLayout.c(this.GnB);
      if (paramAnimator != null) {
        paramAnimator.setVisibility(4);
      }
      AppMethodBeat.o(334890);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout$hideHorizontalHint$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class h
    extends AnimatorListenerAdapter
  {
    h(FinderFullSeekBarLayout paramFinderFullSeekBarLayout) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(334899);
      super.onAnimationEnd(paramAnimator);
      FinderFullSeekBarLayout.d(this.GnB).setVisibility(8);
      FinderFullSeekBarLayout.d(this.GnB).removeCallbacks(FinderFullSeekBarLayout.e(this.GnB));
      AppMethodBeat.o(334899);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout$hideSeekLayout$1$1", "Lcom/tencent/mm/plugin/finder/animation/AnimatorEndListener;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class i
    extends com.tencent.mm.plugin.finder.animation.a
  {
    i(View paramView) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(334869);
      this.DjW.setVisibility(4);
      this.DjW.setAlpha(1.0F);
      AppMethodBeat.o(334869);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout$hideSeekLayout$2", "Lcom/tencent/mm/plugin/finder/animation/AnimatorEndListener;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class j
    extends com.tencent.mm.plugin.finder.animation.a
  {
    j(View paramView) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(334874);
      paramAnimator = this.GnE;
      if (this.GnE.getId() == e.e.video_current_tv) {}
      for (int i = 8;; i = 4)
      {
        paramAnimator.setVisibility(i);
        this.GnE.setAlpha(1.0F);
        AppMethodBeat.o(334874);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout$hideSeekLayout$3", "Lcom/tencent/mm/plugin/finder/animation/AnimatorEndListener;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class k
    extends com.tencent.mm.plugin.finder.animation.a
  {
    k(FinderFullSeekBarLayout paramFinderFullSeekBarLayout) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(334821);
      this.GnB.getPlayCtrlBtn().setVisibility(8);
      this.GnB.getPlayCtrlBtn().setAlpha(1.0F);
      AppMethodBeat.o(334821);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class l
    extends u
    implements kotlin.g.a.a<View>
  {
    l(FinderFullSeekBarLayout paramFinderFullSeekBarLayout)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class n
    extends u
    implements kotlin.g.a.a<View>
  {
    n(FinderFullSeekBarLayout paramFinderFullSeekBarLayout)
    {
      super();
    }
    
    private static final void a(FinderFullSeekBarLayout paramFinderFullSeekBarLayout, View paramView)
    {
      AppMethodBeat.i(334806);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramFinderFullSeekBarLayout);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout$longVideoLayout$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      kotlin.g.b.s.u(paramFinderFullSeekBarLayout, "this$0");
      paramFinderFullSeekBarLayout.getOnLongVideoBtnClickListener().invoke();
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout$longVideoLayout$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(334806);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class o
    extends u
    implements kotlin.g.a.a<View>
  {
    o(FinderFullSeekBarLayout paramFinderFullSeekBarLayout)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class t
    extends u
    implements kotlin.g.a.a<WeImageView>
  {
    t(FinderFullSeekBarLayout paramFinderFullSeekBarLayout)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class u
    extends u
    implements kotlin.g.a.a<View>
  {
    u(FinderFullSeekBarLayout paramFinderFullSeekBarLayout)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class v
    extends u
    implements kotlin.g.a.a<TextView>
  {
    v(FinderFullSeekBarLayout paramFinderFullSeekBarLayout)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class w
    extends u
    implements kotlin.g.a.a<WeImageView>
  {
    w(FinderFullSeekBarLayout paramFinderFullSeekBarLayout)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class x
    extends u
    implements kotlin.g.a.a<ah>
  {
    x(WeImageView paramWeImageView, FinderFullSeekBarLayout paramFinderFullSeekBarLayout)
    {
      super();
    }
    
    private static final void a(WeImageView paramWeImageView, FinderFullSeekBarLayout paramFinderFullSeekBarLayout)
    {
      AppMethodBeat.i(334769);
      kotlin.g.b.s.u(paramWeImageView, "$icon");
      kotlin.g.b.s.u(paramFinderFullSeekBarLayout, "this$0");
      paramWeImageView.setIconColor(paramFinderFullSeekBarLayout.getContext().getResources().getColor(e.b.hot_tab_BW_100_Alpha_0_8));
      AppMethodBeat.o(334769);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/SeekBar;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class y
    extends u
    implements kotlin.g.a.a<SeekBar>
  {
    y(FinderFullSeekBarLayout paramFinderFullSeekBarLayout)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class z
    extends u
    implements kotlin.g.a.a<ViewGroup>
  {
    z(FinderFullSeekBarLayout paramFinderFullSeekBarLayout)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.FinderFullSeekBarLayout
 * JD-Core Version:    0.7.0.1
 */