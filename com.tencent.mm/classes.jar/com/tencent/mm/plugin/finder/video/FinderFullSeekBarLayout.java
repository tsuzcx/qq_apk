package com.tencent.mm.plugin.finder.video;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.m.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.report.aj;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.upload.action.j;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.azu;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import kotlin.f;
import kotlin.g.b.ae;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout;", "Landroid/widget/FrameLayout;", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "Landroid/view/GestureDetector$OnGestureListener;", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoSeekBar;", "Landroid/view/GestureDetector$OnDoubleTapListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "allSec", "allTimeLongTv", "Landroid/widget/TextView;", "getAllTimeLongTv", "()Landroid/widget/TextView;", "allTimeLongTv$delegate", "Lkotlin/Lazy;", "allTimeTv", "getAllTimeTv", "allTimeTv$delegate", "awesomeGroundLayout", "Landroid/view/View;", "getAwesomeGroundLayout", "()Landroid/view/View;", "awesomeGroundLayout$delegate", "awesomeIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getAwesomeIcon", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "awesomeIcon$delegate", "currentTimeTv", "getCurrentTimeTv", "currentTimeTv$delegate", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "ignoreThisEvent", "", "isPlayingCallback", "Lkotlin/Function0;", "()Lkotlin/jvm/functions/Function0;", "setPlayingCallback", "(Lkotlin/jvm/functions/Function0;)V", "isSeekBarTrackingTouch", "isSeekMode", "longVideoLayout", "getLongVideoLayout", "longVideoLayout$delegate", "onLongVideoBtnClickListener", "", "getOnLongVideoBtnClickListener", "setOnLongVideoBtnClickListener", "onPauseClickListener", "getOnPauseClickListener", "setOnPauseClickListener", "onPrivateLikeClickListener", "getOnPrivateLikeClickListener", "setOnPrivateLikeClickListener", "pauseClickByUser", "pauseIcon", "getPauseIcon", "pauseIcon$delegate", "pauseLayout", "getPauseLayout", "pauseLayout$delegate", "rect", "Landroid/graphics/Rect;", "seekBar", "Landroid/widget/SeekBar;", "getSeekBar", "()Landroid/widget/SeekBar;", "seekBar$delegate", "seekBarCallback", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoSeekBar$SeekBarCallback;", "seekBarTouchListener", "Landroid/view/View$OnTouchListener;", "seekLayout", "Landroid/view/ViewGroup;", "getSeekLayout", "()Landroid/view/ViewGroup;", "seekLayout$delegate", "setTmpMaxProgress", "touchDetector", "Landroid/view/GestureDetector;", "getTouchDetector", "()Landroid/view/GestureDetector;", "touchDetector$delegate", "checkShowGroupLikeTips", "dismissGroupLikeTips", "dismissProgressBar", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "enterSeekMode", "exitSeekMode", "reason", "", "formatSecToMin", "second", "getCurrentProgress", "getSeekPercent", "", "hideOtherView", "hidePauseIcon", "hideSeekLayout", "isInSeekMode", "isPauseIconStatus", "isSeekingMode", "isShownSeekBar", "onAttachedToWindow", "onDoubleTap", "e", "onDoubleTapEvent", "onDown", "onFling", "e1", "e2", "velocityX", "velocityY", "onInterceptTouchEvent", "ev", "onLongPress", "onProgressChanged", "progress", "fromUser", "onScroll", "distanceX", "distanceY", "onShowPress", "onSingleTapConfirmed", "onSingleTapUp", "onStartTrackingTouch", "onStopTrackingTouch", "refreshAwesome", "isLike", "refreshFinderFeed", "item", "reportPauseClick", "setFinderFeed", "setPlaying", "isPlaying", "setProgress", "target", "setSeekBarCallback", "callback", "showOtherView", "showPauseIcon", "showProgressBar", "isShowThumb", "showSeekLayout", "updateAllTime", "offsetSec", "updateCurrentTime", "updateProgressMs", "percent", "offsetMs", "", "allMs", "updateProgressSec", "updateSeekTime", "Companion", "plugin-finder_release"})
@SuppressLint({"ResourceType"})
public final class FinderFullSeekBarLayout
  extends FrameLayout
  implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, SeekBar.OnSeekBarChangeListener, q
{
  private static final HashMap<Long, Integer> wbM;
  public static final a wbN;
  private final Rect rect;
  public BaseFinderFeed tNO;
  private final f vMb;
  private boolean wbA;
  private final f wbB;
  private final f wbC;
  private final f wbD;
  private boolean wbE;
  private q.a wbF;
  public boolean wbG;
  private final f wbH;
  @SuppressLint({"ClickableViewAccessibility"})
  private final View.OnTouchListener wbI;
  private int wbJ;
  private int wbK;
  private boolean wbL;
  private kotlin.g.a.a<Boolean> wbq;
  private kotlin.g.a.a<Boolean> wbr;
  private kotlin.g.a.a<Boolean> wbs;
  private kotlin.g.a.a<kotlin.x> wbt;
  private final f wbu;
  private final f wbv;
  private final f wbw;
  private final f wbx;
  private final f wby;
  private final f wbz;
  
  static
  {
    AppMethodBeat.i(253965);
    wbN = new a((byte)0);
    wbM = new HashMap();
    AppMethodBeat.o(253965);
  }
  
  public FinderFullSeekBarLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(253963);
    this.vMb = kotlin.g.ah((kotlin.g.a.a)new u(this));
    this.wbq = ((kotlin.g.a.a)p.wcb);
    this.wbr = ((kotlin.g.a.a)o.wca);
    this.wbs = ((kotlin.g.a.a)l.wbX);
    this.wbt = ((kotlin.g.a.a)n.wbZ);
    this.wbu = kotlin.g.ah((kotlin.g.a.a)new w(this));
    this.wbv = kotlin.g.ah((kotlin.g.a.a)new g(this));
    this.wbw = kotlin.g.ah((kotlin.g.a.a)new c(this));
    this.wbx = kotlin.g.ah((kotlin.g.a.a)new b(this));
    this.wby = kotlin.g.ah((kotlin.g.a.a)new m(this));
    this.wbz = kotlin.g.ah((kotlin.g.a.a)new d(this));
    this.wbA = true;
    this.wbB = kotlin.g.ah((kotlin.g.a.a)new s(this));
    this.wbC = kotlin.g.ah((kotlin.g.a.a)new r(this));
    this.wbD = kotlin.g.ah((kotlin.g.a.a)new e(this));
    this.rect = new Rect();
    this.wbH = kotlin.g.ah((kotlin.g.a.a)new z(this));
    this.wbI = ((View.OnTouchListener)new v(this));
    AppMethodBeat.o(253963);
  }
  
  public FinderFullSeekBarLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(253964);
    this.vMb = kotlin.g.ah((kotlin.g.a.a)new u(this));
    this.wbq = ((kotlin.g.a.a)p.wcb);
    this.wbr = ((kotlin.g.a.a)o.wca);
    this.wbs = ((kotlin.g.a.a)l.wbX);
    this.wbt = ((kotlin.g.a.a)n.wbZ);
    this.wbu = kotlin.g.ah((kotlin.g.a.a)new w(this));
    this.wbv = kotlin.g.ah((kotlin.g.a.a)new g(this));
    this.wbw = kotlin.g.ah((kotlin.g.a.a)new c(this));
    this.wbx = kotlin.g.ah((kotlin.g.a.a)new b(this));
    this.wby = kotlin.g.ah((kotlin.g.a.a)new m(this));
    this.wbz = kotlin.g.ah((kotlin.g.a.a)new d(this));
    this.wbA = true;
    this.wbB = kotlin.g.ah((kotlin.g.a.a)new s(this));
    this.wbC = kotlin.g.ah((kotlin.g.a.a)new r(this));
    this.wbD = kotlin.g.ah((kotlin.g.a.a)new e(this));
    this.rect = new Rect();
    this.wbH = kotlin.g.ah((kotlin.g.a.a)new z(this));
    this.wbI = ((View.OnTouchListener)new v(this));
    AppMethodBeat.o(253964);
  }
  
  private final void Mb(int paramInt)
  {
    AppMethodBeat.i(253959);
    getCurrentTimeTv().setText((CharSequence)formatSecToMin(paramInt));
    AppMethodBeat.o(253959);
  }
  
  private final void dFb()
  {
    AppMethodBeat.i(253957);
    Object localObject1 = getParent();
    if (localObject1 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(253957);
      throw ((Throwable)localObject1);
    }
    localObject1 = ((View)localObject1).findViewById(2131300829);
    if (localObject1 != null)
    {
      localObject2 = ((View)localObject1).animate();
      if (localObject2 != null) {
        ((ViewPropertyAnimator)localObject2).cancel();
      }
      ((View)localObject1).animate().alpha(1.0F).setDuration(220L).start();
    }
    localObject1 = getParent();
    if (localObject1 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(253957);
      throw ((Throwable)localObject1);
    }
    localObject1 = ((View)localObject1).findViewById(2131301504);
    if (localObject1 != null)
    {
      localObject2 = ((View)localObject1).animate();
      if (localObject2 != null) {
        ((ViewPropertyAnimator)localObject2).cancel();
      }
      ((View)localObject1).animate().alpha(1.0F).setDuration(220L).start();
    }
    localObject1 = getParent();
    if (localObject1 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(253957);
      throw ((Throwable)localObject1);
    }
    Object localObject2 = ((View)localObject1).findViewById(2131300827);
    localObject1 = localObject2;
    if (!(localObject2 instanceof ViewGroup)) {
      localObject1 = null;
    }
    localObject1 = (ViewGroup)localObject1;
    if (localObject1 != null)
    {
      int j = ((ViewGroup)localObject1).getChildCount();
      int i = 0;
      while (i < j)
      {
        localObject2 = ((ViewGroup)localObject1).getChildAt(i);
        if (kotlin.g.b.p.j(((View)localObject2).getTag(2131301467), Boolean.TRUE))
        {
          ViewPropertyAnimator localViewPropertyAnimator = ((View)localObject2).animate();
          if (localViewPropertyAnimator != null) {
            localViewPropertyAnimator.cancel();
          }
          kotlin.g.b.p.g(localObject2, "child");
          ((View)localObject2).setVisibility(0);
          ((View)localObject2).animate().alpha(1.0F).setListener((Animator.AnimatorListener)new x((View)localObject2)).setDuration(220L).start();
        }
        i += 1;
      }
      AppMethodBeat.o(253957);
      return;
    }
    AppMethodBeat.o(253957);
  }
  
  private final void dFc()
  {
    AppMethodBeat.i(253958);
    dFd();
    Object localObject1 = getSeekLayout().findViewById(2131305784);
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = ((View)localObject1).animate();
      if (localObject2 != null) {
        ((ViewPropertyAnimator)localObject2).cancel();
      }
      ((View)localObject1).animate().alpha(0.0F).setDuration(130L).setListener((Animator.AnimatorListener)new j((View)localObject1)).start();
    }
    localObject1 = (ViewGroup)getSeekLayout().findViewById(2131305786);
    kotlin.g.b.p.g(localObject1, "partTopLayout");
    int j = ((ViewGroup)localObject1).getChildCount();
    int i = 0;
    while (i < j)
    {
      localObject2 = ((ViewGroup)localObject1).getChildAt(i);
      kotlin.g.b.p.g(localObject2, "child");
      if ((((View)localObject2).getId() != 2131301824) && (((View)localObject2).getVisibility() == 0))
      {
        ViewPropertyAnimator localViewPropertyAnimator = ((View)localObject2).animate();
        if (localViewPropertyAnimator != null) {
          localViewPropertyAnimator.cancel();
        }
        ((View)localObject2).animate().alpha(0.0F).setDuration(130L).setListener((Animator.AnimatorListener)new k((View)localObject2)).start();
      }
      i += 1;
    }
    if (!((Boolean)this.wbs.invoke()).booleanValue())
    {
      this.wbA = false;
      getPauseLayout().callOnClick();
    }
    AppMethodBeat.o(253958);
  }
  
  private final void dFd()
  {
    AppMethodBeat.i(253962);
    Log.i("Finder.FullSeekBarLayout", "[dismissGroupLikeTips]");
    Object localObject2 = getParent();
    Object localObject1 = localObject2;
    if (!(localObject2 instanceof ViewGroup)) {
      localObject1 = null;
    }
    localObject1 = (ViewGroup)localObject1;
    if (localObject1 != null)
    {
      localObject2 = ((ViewGroup)localObject1).findViewById(2131300828);
      if (localObject2 != null)
      {
        ((View)localObject2).post((Runnable)new h((View)localObject2, (ViewGroup)localObject1));
        AppMethodBeat.o(253962);
        return;
      }
    }
    AppMethodBeat.o(253962);
  }
  
  private static String formatSecToMin(int paramInt)
  {
    AppMethodBeat.i(253961);
    Object localObject = ae.SYK;
    localObject = String.format("%02d:%02d", Arrays.copyOf(new Object[] { Long.valueOf(paramInt / 60L), Long.valueOf(paramInt % 60L) }, 2));
    kotlin.g.b.p.g(localObject, "java.lang.String.format(format, *args)");
    AppMethodBeat.o(253961);
    return localObject;
  }
  
  private final TextView getAllTimeLongTv()
  {
    AppMethodBeat.i(253925);
    TextView localTextView = (TextView)this.wbx.getValue();
    AppMethodBeat.o(253925);
    return localTextView;
  }
  
  private final TextView getAllTimeTv()
  {
    AppMethodBeat.i(253924);
    TextView localTextView = (TextView)this.wbw.getValue();
    AppMethodBeat.o(253924);
    return localTextView;
  }
  
  private final View getAwesomeGroundLayout()
  {
    AppMethodBeat.i(253927);
    View localView = (View)this.wbz.getValue();
    AppMethodBeat.o(253927);
    return localView;
  }
  
  private final WeImageView getAwesomeIcon()
  {
    AppMethodBeat.i(253930);
    WeImageView localWeImageView = (WeImageView)this.wbD.getValue();
    AppMethodBeat.o(253930);
    return localWeImageView;
  }
  
  private final TextView getCurrentTimeTv()
  {
    AppMethodBeat.i(253923);
    TextView localTextView = (TextView)this.wbv.getValue();
    AppMethodBeat.o(253923);
    return localTextView;
  }
  
  private final View getLongVideoLayout()
  {
    AppMethodBeat.i(253926);
    View localView = (View)this.wby.getValue();
    AppMethodBeat.o(253926);
    return localView;
  }
  
  private final View getPauseLayout()
  {
    AppMethodBeat.i(253928);
    View localView = (View)this.wbB.getValue();
    AppMethodBeat.o(253928);
    return localView;
  }
  
  private final SeekBar getSeekBar()
  {
    AppMethodBeat.i(253917);
    SeekBar localSeekBar = (SeekBar)this.vMb.getValue();
    AppMethodBeat.o(253917);
    return localSeekBar;
  }
  
  private final ViewGroup getSeekLayout()
  {
    AppMethodBeat.i(253922);
    ViewGroup localViewGroup = (ViewGroup)this.wbu.getValue();
    AppMethodBeat.o(253922);
    return localViewGroup;
  }
  
  private final float getSeekPercent()
  {
    AppMethodBeat.i(253956);
    SeekBar localSeekBar = getSeekBar();
    if (localSeekBar == null)
    {
      AppMethodBeat.o(253956);
      return 0.0F;
    }
    float f = 1.0F * localSeekBar.getProgress() / localSeekBar.getMax();
    AppMethodBeat.o(253956);
    return f;
  }
  
  private final GestureDetector getTouchDetector()
  {
    AppMethodBeat.i(253937);
    GestureDetector localGestureDetector = (GestureDetector)this.wbH.getValue();
    AppMethodBeat.o(253937);
    return localGestureDetector;
  }
  
  private final void gt(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(253960);
    Object localObject = formatSecToMin(paramInt2);
    getAllTimeTv().setText((CharSequence)localObject);
    if (paramInt1 < 60)
    {
      BaseFinderFeed localBaseFinderFeed = this.tNO;
      if ((localBaseFinderFeed == null) || (localBaseFinderFeed.isHasLongVideoTimeBack != true)) {}
    }
    else
    {
      localObject = this.tNO;
      if (localObject != null) {
        ((BaseFinderFeed)localObject).isHasLongVideoTimeBack = true;
      }
      getAllTimeLongTv().setText((CharSequence)formatSecToMin(paramInt2 - paramInt1));
      AppMethodBeat.o(253960);
      return;
    }
    getAllTimeLongTv().setText((CharSequence)localObject);
    AppMethodBeat.o(253960);
  }
  
  private final void oH(boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(253932);
    Object localObject1 = com.tencent.mm.plugin.finder.storage.logic.g.vGW;
    localObject1 = this.tNO;
    int i;
    if (localObject1 != null)
    {
      localObject1 = ((BaseFinderFeed)localObject1).feedObject;
      if (localObject1 != null)
      {
        localObject1 = ((FinderItem)localObject1).getFeedObject();
        if (localObject1 != null)
        {
          i = ((FinderObject)localObject1).objectType;
          localObject1 = com.tencent.mm.plugin.finder.storage.logic.g.Lj(i);
          if (localObject1 == null) {
            break label188;
          }
        }
      }
    }
    Object localObject3;
    label188:
    for (localObject1 = ((azu)localObject1).LJJ;; localObject1 = null)
    {
      Log.i("Finder.FullSeekBarLayout", "[refreshAwesome] isLike=" + paramBoolean + " groupLikeIconUrl=" + (String)localObject1);
      if (!paramBoolean) {
        break label247;
      }
      if (localObject1 == null) {
        break label194;
      }
      getAwesomeIcon().setLayerPaint(null);
      localObject2 = m.uJa;
      localObject2 = m.djY();
      localObject1 = new com.tencent.mm.plugin.finder.loader.p((String)localObject1, com.tencent.mm.plugin.finder.storage.x.vEn);
      localObject3 = (ImageView)getAwesomeIcon();
      m localm = m.uJa;
      ((d)localObject2).a(localObject1, (ImageView)localObject3, m.a(m.a.uJb));
      AppMethodBeat.o(253932);
      return;
      i = 0;
      break;
    }
    label194:
    getAwesomeIcon().setImageResource(2131690578);
    localObject1 = getAwesomeIcon();
    Object localObject2 = getContext();
    kotlin.g.b.p.g(localObject2, "context");
    ((WeImageView)localObject1).setIconColor(((Context)localObject2).getResources().getColor(2131099824));
    AppMethodBeat.o(253932);
    return;
    label247:
    localObject2 = (CharSequence)localObject1;
    if (localObject2 != null)
    {
      i = j;
      if (((CharSequence)localObject2).length() != 0) {}
    }
    else
    {
      i = 1;
    }
    if (i != 0) {
      getAwesomeIcon().setImageResource(2131690578);
    }
    for (;;)
    {
      localObject1 = getAwesomeIcon();
      localObject2 = getContext();
      kotlin.g.b.p.g(localObject2, "context");
      ((WeImageView)localObject1).setIconColor(((Context)localObject2).getResources().getColor(2131100620));
      AppMethodBeat.o(253932);
      return;
      getAwesomeIcon().setLayerPaint(null);
      localObject2 = m.uJa;
      localObject2 = m.djY();
      localObject1 = new com.tencent.mm.plugin.finder.loader.p((String)localObject1, com.tencent.mm.plugin.finder.storage.x.vEn);
      localObject3 = m.uJa;
      ((d)localObject2).a(localObject1, m.a(m.a.uJb)).a((com.tencent.mm.loader.f.e)new t(this)).c((ImageView)getAwesomeIcon());
    }
  }
  
  public final void awG(String paramString)
  {
    AppMethodBeat.i(253951);
    kotlin.g.b.p.h(paramString, "reason");
    if (!this.wbG)
    {
      AppMethodBeat.o(253951);
      return;
    }
    Log.i("Finder.FullSeekBarLayout", "[exitSeekMode] reason=".concat(String.valueOf(paramString)));
    this.wbG = false;
    dFb();
    dFc();
    getSeekLayout().setClickable(false);
    AppMethodBeat.o(253951);
  }
  
  public final void bm(float paramFloat)
  {
    AppMethodBeat.i(253950);
    getSeekBar().setProgress(kotlin.h.a.cR(getSeekBar().getMax() * paramFloat));
    AppMethodBeat.o(253950);
  }
  
  public final void dEX() {}
  
  public final boolean dEY()
  {
    return true;
  }
  
  public final boolean dEZ()
  {
    return this.wbE;
  }
  
  public final void dFa()
  {
    AppMethodBeat.i(253952);
    if (this.wbG)
    {
      AppMethodBeat.o(253952);
      return;
    }
    this.wbG = true;
    Object localObject1 = getParent();
    if (localObject1 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(253952);
      throw ((Throwable)localObject1);
    }
    localObject1 = ((View)localObject1).findViewById(2131300829);
    if (localObject1 != null)
    {
      localObject2 = ((View)localObject1).animate();
      if (localObject2 != null) {
        ((ViewPropertyAnimator)localObject2).cancel();
      }
      ((View)localObject1).setAlpha(0.0F);
    }
    localObject1 = getParent();
    if (localObject1 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(253952);
      throw ((Throwable)localObject1);
    }
    localObject1 = ((View)localObject1).findViewById(2131301504);
    if (localObject1 != null)
    {
      localObject2 = ((View)localObject1).animate();
      if (localObject2 != null) {
        ((ViewPropertyAnimator)localObject2).cancel();
      }
      ((View)localObject1).setAlpha(0.0F);
    }
    localObject1 = getParent();
    if (localObject1 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(253952);
      throw ((Throwable)localObject1);
    }
    Object localObject2 = ((View)localObject1).findViewById(2131300827);
    localObject1 = localObject2;
    if (!(localObject2 instanceof ViewGroup)) {
      localObject1 = null;
    }
    localObject1 = (ViewGroup)localObject1;
    final int j;
    Object localObject3;
    if (localObject1 != null)
    {
      j = ((ViewGroup)localObject1).getChildCount();
      i = 0;
      while (i < j)
      {
        localObject2 = ((ViewGroup)localObject1).getChildAt(i);
        kotlin.g.b.p.g(localObject2, "child");
        if ((((View)localObject2).getId() != 2131304900) && (((View)localObject2).getVisibility() == 0))
        {
          localObject3 = ((View)localObject2).animate();
          if (localObject3 != null) {
            ((ViewPropertyAnimator)localObject3).cancel();
          }
          ((View)localObject2).animate().alpha(0.0F).setDuration(220L).setListener((Animator.AnimatorListener)new i((View)localObject2)).start();
        }
        i += 1;
      }
    }
    localObject1 = this.tNO;
    if (localObject1 != null)
    {
      localObject1 = ((BaseFinderFeed)localObject1).feedObject;
      if ((localObject1 != null) && (((FinderItem)localObject1).isLongVideo() == true))
      {
        getAllTimeTv().setVisibility(8);
        getLongVideoLayout().setVisibility(0);
      }
    }
    for (;;)
    {
      localObject1 = com.tencent.mm.kernel.g.aAh();
      kotlin.g.b.p.g(localObject1, "MMKernel.storage()");
      j = ((com.tencent.mm.kernel.e)localObject1).azQ().getInt(ar.a.OjC, 0);
      if (j >= 3) {
        break label588;
      }
      localObject1 = getParent();
      if (localObject1 != null) {
        break;
      }
      localObject1 = new t("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(253952);
      throw ((Throwable)localObject1);
      getLongVideoLayout().setVisibility(8);
      getAllTimeTv().setVisibility(0);
    }
    localObject1 = (ViewGroup)localObject1;
    if (((ViewGroup)localObject1).findViewById(2131300828) != null) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject2 = new Rect();
        if (getAwesomeGroundLayout().getGlobalVisibleRect((Rect)localObject2))
        {
          localObject3 = aa.jQ(getContext()).inflate(2131494339, (ViewGroup)localObject1, false);
          kotlin.g.b.p.g(localObject3, "tipsLayout");
          ((View)localObject3).setAlpha(0.0F);
          ((ViewGroup)localObject1).addView((View)localObject3);
          ((View)localObject3).post((Runnable)new f(this, (Rect)localObject2, (View)localObject3, j, (ViewGroup)localObject1));
        }
      }
      label588:
      localObject1 = (ViewGroup)getSeekLayout().findViewById(2131305786);
      kotlin.g.b.p.g(localObject1, "partTopLayout");
      j = ((ViewGroup)localObject1).getChildCount();
      i = 0;
      while (i < j)
      {
        localObject2 = ((ViewGroup)localObject1).getChildAt(i);
        kotlin.g.b.p.g(localObject2, "child");
        if (((View)localObject2).getId() != 2131301824)
        {
          localObject3 = this.tNO;
          if (localObject3 != null)
          {
            localObject3 = ((BaseFinderFeed)localObject3).feedObject;
            if ((localObject3 != null) && (!((FinderItem)localObject3).isLongVideo())) {}
          }
          else
          {
            if (((View)localObject2).getId() == getAllTimeTv().getId()) {
              break label748;
            }
          }
          localObject3 = ((View)localObject2).animate();
          if (localObject3 != null) {
            ((ViewPropertyAnimator)localObject3).cancel();
          }
          ((View)localObject2).setVisibility(0);
          ((View)localObject2).setAlpha(0.0F);
          ((View)localObject2).animate().alpha(1.0F).setDuration(130L).setListener(null).start();
        }
        label748:
        i += 1;
      }
    }
    localObject1 = getSeekLayout().findViewById(2131305784);
    if (localObject1 != null)
    {
      localObject2 = ((View)localObject1).animate();
      if (localObject2 != null) {
        ((ViewPropertyAnimator)localObject2).cancel();
      }
      ((View)localObject1).setVisibility(0);
      ((View)localObject1).setAlpha(0.0F);
      ((View)localObject1).animate().alpha(1.0F).setDuration(130L).setListener((Animator.AnimatorListener)new y(this)).start();
    }
    localObject1 = this.tNO;
    if (localObject1 != null)
    {
      localObject1 = ((BaseFinderFeed)localObject1).feedObject;
      if (localObject1 != null)
      {
        localObject1 = ((FinderItem)localObject1).getFeedObject();
        if (localObject1 != null)
        {
          localObject2 = j.vUw;
          localObject1 = j.dBt().m((FinderObject)localObject1);
          bool1 = ((Boolean)((kotlin.o)localObject1).first).booleanValue();
          boolean bool2 = ((Boolean)((kotlin.o)localObject1).second).booleanValue();
          if ((!bool1) || (!bool2)) {
            break label975;
          }
        }
      }
    }
    label975:
    for (boolean bool1 = true;; bool1 = false)
    {
      oH(bool1);
      if (((Boolean)this.wbs.invoke()).booleanValue())
      {
        this.wbA = false;
        getPauseLayout().callOnClick();
      }
      getSeekLayout().setClickable(true);
      AppMethodBeat.o(253952);
      return;
    }
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(253935);
    kotlin.g.b.p.h(paramMotionEvent, "event");
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    if ((!bool) && (this.wbI.onTouch((View)this, paramMotionEvent)))
    {
      AppMethodBeat.o(253935);
      return true;
    }
    AppMethodBeat.o(253935);
    return bool;
  }
  
  public final int getCurrentProgress()
  {
    AppMethodBeat.i(253947);
    int i = getSeekBar().getProgress();
    AppMethodBeat.o(253947);
    return i;
  }
  
  public final kotlin.g.a.a<kotlin.x> getOnLongVideoBtnClickListener()
  {
    return this.wbt;
  }
  
  public final kotlin.g.a.a<Boolean> getOnPauseClickListener()
  {
    return this.wbr;
  }
  
  public final kotlin.g.a.a<Boolean> getOnPrivateLikeClickListener()
  {
    return this.wbq;
  }
  
  public final WeImageView getPauseIcon()
  {
    AppMethodBeat.i(253929);
    WeImageView localWeImageView = (WeImageView)this.wbC.getValue();
    AppMethodBeat.o(253929);
    return localWeImageView;
  }
  
  public final void gs(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(253949);
    this.wbK = paramInt2;
    gt(paramInt1, paramInt2);
    Mb(paramInt1);
    setPlaying(true);
    AppMethodBeat.o(253949);
  }
  
  public final void oI(boolean paramBoolean) {}
  
  protected final void onAttachedToWindow()
  {
    AppMethodBeat.i(253931);
    super.onAttachedToWindow();
    BaseFinderFeed localBaseFinderFeed = this.tNO;
    if (localBaseFinderFeed != null)
    {
      if (!localBaseFinderFeed.isPreview) {
        getAwesomeGroundLayout().setVisibility(0);
      }
      AppMethodBeat.o(253931);
      return;
    }
    AppMethodBeat.o(253931);
  }
  
  public final boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(253955);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bm(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(253955);
    return false;
  }
  
  public final boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public final boolean onDown(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(253941);
    kotlin.g.b.p.h(paramMotionEvent, "e");
    AppMethodBeat.o(253941);
    return true;
  }
  
  public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(253945);
    kotlin.g.b.p.h(paramMotionEvent1, "e1");
    kotlin.g.b.p.h(paramMotionEvent2, "e2");
    AppMethodBeat.o(253945);
    return false;
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(253936);
    kotlin.g.b.p.h(paramMotionEvent, "ev");
    if ((this.wbG) && (getSeekLayout().getGlobalVisibleRect(this.rect)))
    {
      if (this.rect.bottom < paramMotionEvent.getY())
      {
        AppMethodBeat.o(253936);
        return true;
      }
      AppMethodBeat.o(253936);
      return false;
    }
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
    AppMethodBeat.o(253936);
    return bool;
  }
  
  public final void onLongPress(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(253944);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bm(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.axR());
    kotlin.g.b.p.h(paramMotionEvent, "e");
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
    AppMethodBeat.o(253944);
  }
  
  public final void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(253939);
    kotlin.g.b.p.h(paramSeekBar, "seekBar");
    if (paramBoolean)
    {
      paramInt = this.wbK;
      float f1 = getSeekBar().getProgress() / getSeekBar().getMax();
      float f2 = paramInt;
      Mb((int)android.support.v4.b.a.j(f1 * f2, f2 - 1.0F));
    }
    AppMethodBeat.o(253939);
  }
  
  public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(253943);
    kotlin.g.b.p.h(paramMotionEvent1, "e1");
    kotlin.g.b.p.h(paramMotionEvent2, "e2");
    AppMethodBeat.o(253943);
    return false;
  }
  
  public final void onShowPress(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(253942);
    kotlin.g.b.p.h(paramMotionEvent, "e");
    AppMethodBeat.o(253942);
  }
  
  public final boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(253954);
    kotlin.g.b.p.h(paramMotionEvent, "e");
    if (this.wbL)
    {
      this.wbL = false;
      AppMethodBeat.o(253954);
      return false;
    }
    if (!this.wbG) {
      dFa();
    }
    AppMethodBeat.o(253954);
    return true;
  }
  
  public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(253953);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bm(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
    kotlin.g.b.p.h(paramMotionEvent, "e");
    if (this.wbG)
    {
      post((Runnable)new q(this));
      this.wbL = true;
    }
    com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(253953);
    return true;
  }
  
  public final void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    AppMethodBeat.i(253938);
    kotlin.g.b.p.h(paramSeekBar, "seekBar");
    this.wbE = true;
    paramSeekBar = this.wbF;
    if (paramSeekBar != null)
    {
      paramSeekBar.dFH();
      AppMethodBeat.o(253938);
      return;
    }
    AppMethodBeat.o(253938);
  }
  
  public final void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    AppMethodBeat.i(253940);
    kotlin.g.b.p.h(paramSeekBar, "seekBar");
    this.wbE = false;
    paramSeekBar = this.wbF;
    if (paramSeekBar != null)
    {
      paramSeekBar.bn(getSeekPercent());
      AppMethodBeat.o(253940);
      return;
    }
    AppMethodBeat.o(253940);
  }
  
  public final void setFinderFeed(BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(253933);
    this.tNO = paramBaseFinderFeed;
    getAllTimeTv().setVisibility(8);
    if (paramBaseFinderFeed != null)
    {
      FinderItem localFinderItem = paramBaseFinderFeed.feedObject;
      if ((localFinderItem != null) && (localFinderItem.isLongVideo() == true))
      {
        getLongVideoLayout().setVisibility(0);
        gt(0, ((cjl)paramBaseFinderFeed.feedObject.getLongVideoMediaList().getFirst()).videoDuration);
        AppMethodBeat.o(253933);
        return;
      }
    }
    getLongVideoLayout().setVisibility(8);
    AppMethodBeat.o(253933);
  }
  
  public final void setOnLongVideoBtnClickListener(kotlin.g.a.a<kotlin.x> parama)
  {
    AppMethodBeat.i(253921);
    kotlin.g.b.p.h(parama, "<set-?>");
    this.wbt = parama;
    AppMethodBeat.o(253921);
  }
  
  public final void setOnPauseClickListener(kotlin.g.a.a<Boolean> parama)
  {
    AppMethodBeat.i(253919);
    kotlin.g.b.p.h(parama, "<set-?>");
    this.wbr = parama;
    AppMethodBeat.o(253919);
  }
  
  public final void setOnPrivateLikeClickListener(kotlin.g.a.a<Boolean> parama)
  {
    AppMethodBeat.i(253918);
    kotlin.g.b.p.h(parama, "<set-?>");
    this.wbq = parama;
    AppMethodBeat.o(253918);
  }
  
  public final void setPlaying(boolean paramBoolean)
  {
    AppMethodBeat.i(253934);
    if (!paramBoolean)
    {
      getPauseIcon().setImageResource(2131690647);
      getPauseIcon().setTag(Integer.valueOf(0));
      AppMethodBeat.o(253934);
      return;
    }
    getPauseIcon().setTag(Integer.valueOf(1));
    getPauseIcon().setImageResource(2131690631);
    AppMethodBeat.o(253934);
  }
  
  public final void setPlayingCallback(kotlin.g.a.a<Boolean> parama)
  {
    AppMethodBeat.i(253920);
    kotlin.g.b.p.h(parama, "<set-?>");
    this.wbs = parama;
    AppMethodBeat.o(253920);
  }
  
  public final void setProgress(int paramInt)
  {
    AppMethodBeat.i(253946);
    this.wbJ = paramInt;
    getSeekBar().setProgress(paramInt);
    AppMethodBeat.o(253946);
  }
  
  public final void setSeekBarCallback(q.a parama)
  {
    AppMethodBeat.i(253948);
    kotlin.g.b.p.h(parama, "callback");
    this.wbF = parama;
    AppMethodBeat.o(253948);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout$Companion;", "", "()V", "ANIMATION_DURATION", "", "ANIMATION_SEEK_LAYOUT_DURATION", "TAG", "", "showGroupTipsSet", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getShowGroupTipsSet", "()Ljava/util/HashMap;", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<TextView>
  {
    b(FinderFullSeekBarLayout paramFinderFullSeekBarLayout)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.a<TextView>
  {
    c(FinderFullSeekBarLayout paramFinderFullSeekBarLayout)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.a<View>
  {
    d(FinderFullSeekBarLayout paramFinderFullSeekBarLayout)
    {
      super();
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout$awesomeGroundLayout$2$1$1"})
    static final class a
      implements View.OnClickListener
    {
      a(FinderFullSeekBarLayout.d paramd) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(253887);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout$awesomeGroundLayout$2$$special$$inlined$also$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        boolean bool = ((Boolean)this.wbP.wbO.getOnPrivateLikeClickListener().invoke()).booleanValue();
        if (bool)
        {
          localObject = FinderFullSeekBarLayout.b(this.wbP.wbO);
          if (localObject != null)
          {
            paramView = aj.viU;
            paramView = FinderReporterUIC.wzC;
            paramView = this.wbP.wbO.getContext();
            kotlin.g.b.p.g(paramView, "context");
            paramView = FinderReporterUIC.a.fH(paramView);
            if (paramView == null) {
              break label164;
            }
          }
        }
        label164:
        for (paramView = paramView.dIx();; paramView = null)
        {
          aj.a(paramView, "private_like", false, ((BaseFinderFeed)localObject).lT());
          FinderFullSeekBarLayout.d(this.wbP.wbO);
          FinderFullSeekBarLayout.a(this.wbP.wbO, bool);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout$awesomeGroundLayout$2$$special$$inlined$also$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(253887);
          return;
        }
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.a<WeImageView>
  {
    e(FinderFullSeekBarLayout paramFinderFullSeekBarLayout)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(FinderFullSeekBarLayout paramFinderFullSeekBarLayout, Rect paramRect, View paramView, int paramInt, ViewGroup paramViewGroup) {}
    
    public final void run()
    {
      AppMethodBeat.i(253892);
      float f1 = this.wbQ.centerX();
      Object localObject = this.wbR;
      kotlin.g.b.p.g(localObject, "tipsLayout");
      float f2 = ((View)localObject).getWidth() / 2.0F;
      float f3 = this.wbQ.centerY();
      localObject = this.wbR;
      kotlin.g.b.p.g(localObject, "tipsLayout");
      float f4 = ((View)localObject).getHeight() / 2.0F;
      localObject = this.wbO.getContext();
      kotlin.g.b.p.g(localObject, "context");
      float f5 = ((Context)localObject).getResources().getDimension(2131165312);
      localObject = this.wbR;
      kotlin.g.b.p.g(localObject, "tipsLayout");
      ((View)localObject).setTranslationX(f1 - f2);
      localObject = this.wbR;
      kotlin.g.b.p.g(localObject, "tipsLayout");
      ((View)localObject).setTranslationY(f3 - f4 - f5);
      localObject = FinderFullSeekBarLayout.b(this.wbO);
      if (localObject != null) {}
      for (long l = ((BaseFinderFeed)localObject).lT();; l = 0L)
      {
        localObject = FinderFullSeekBarLayout.wbN;
        Integer localInteger = (Integer)FinderFullSeekBarLayout.dFe().get(Long.valueOf(l));
        localObject = localInteger;
        if (localInteger == null) {
          localObject = Integer.valueOf(0);
        }
        kotlin.g.b.p.g(localObject, "showGroupTipsSet[feedId] ?: 0");
        int i = ((Integer)localObject).intValue();
        if (i == 0)
        {
          localObject = com.tencent.mm.kernel.g.aAh();
          kotlin.g.b.p.g(localObject, "MMKernel.storage()");
          ((com.tencent.mm.kernel.e)localObject).azQ().set(ar.a.OjC, Integer.valueOf(j + 1));
          localObject = FinderFullSeekBarLayout.wbN;
          ((Map)FinderFullSeekBarLayout.dFe()).put(Long.valueOf(l), Integer.valueOf(1));
          Log.i("Finder.FullSeekBarLayout", "[checkShowGroupLikeTips] record count=" + (j + 1));
        }
        localObject = FinderFullSeekBarLayout.wbN;
        ((Map)FinderFullSeekBarLayout.dFe()).put(Long.valueOf(l), Integer.valueOf(i + 1));
        if (i < 3) {
          this.wbR.animate().setStartDelay(0L).setDuration(220L).alpha(1.0F).setListener((Animator.AnimatorListener)new com.tencent.mm.plugin.finder.animation.a()
          {
            public final void onAnimationEnd(Animator paramAnonymousAnimator)
            {
              AppMethodBeat.i(253891);
              kotlin.g.b.p.h(paramAnonymousAnimator, "animation");
              Log.i("Finder.FullSeekBarLayout", "[onAnimationEnd]");
              this.wbT.wbR.postDelayed((Runnable)new a(this), 5000L);
              AppMethodBeat.o(253891);
            }
            
            @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
            static final class a
              implements Runnable
            {
              a(FinderFullSeekBarLayout.f.1 param1) {}
              
              public final void run()
              {
                AppMethodBeat.i(253890);
                this.wbU.wbT.hVi.removeView(this.wbU.wbT.wbR);
                AppMethodBeat.o(253890);
              }
            }
          }).start();
        }
        AppMethodBeat.o(253892);
        return;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class g
    extends kotlin.g.b.q
    implements kotlin.g.a.a<TextView>
  {
    g(FinderFullSeekBarLayout paramFinderFullSeekBarLayout)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout$dismissGroupLikeTips$1$1"})
  static final class h
    implements Runnable
  {
    h(View paramView, ViewGroup paramViewGroup) {}
    
    public final void run()
    {
      AppMethodBeat.i(253894);
      this.tzy.animate().cancel();
      this.wbV.removeView(this.tzy);
      AppMethodBeat.o(253894);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout$hideOtherView$1$1", "Lcom/tencent/mm/plugin/finder/animation/AnimatorEndListener;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"})
  public static final class i
    extends com.tencent.mm.plugin.finder.animation.a
  {
    i(View paramView) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(253895);
      kotlin.g.b.p.h(paramAnimator, "animation");
      paramAnimator = this.wbW;
      kotlin.g.b.p.g(paramAnimator, "child");
      paramAnimator.setVisibility(4);
      this.wbW.setTag(2131301467, Boolean.TRUE);
      AppMethodBeat.o(253895);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout$hideSeekLayout$1$1", "Lcom/tencent/mm/plugin/finder/animation/AnimatorEndListener;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"})
  public static final class j
    extends com.tencent.mm.plugin.finder.animation.a
  {
    j(View paramView) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(253896);
      this.tzy.setVisibility(4);
      this.tzy.setAlpha(1.0F);
      AppMethodBeat.o(253896);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout$hideSeekLayout$2", "Lcom/tencent/mm/plugin/finder/animation/AnimatorEndListener;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"})
  public static final class k
    extends com.tencent.mm.plugin.finder.animation.a
  {
    k(View paramView) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(253897);
      paramAnimator = this.wbW;
      kotlin.g.b.p.g(paramAnimator, "child");
      paramAnimator.setVisibility(4);
      paramAnimator = this.wbW;
      kotlin.g.b.p.g(paramAnimator, "child");
      paramAnimator.setAlpha(1.0F);
      AppMethodBeat.o(253897);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class l
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Boolean>
  {
    public static final l wbX;
    
    static
    {
      AppMethodBeat.i(253898);
      wbX = new l();
      AppMethodBeat.o(253898);
    }
    
    l()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class m
    extends kotlin.g.b.q
    implements kotlin.g.a.a<View>
  {
    m(FinderFullSeekBarLayout paramFinderFullSeekBarLayout)
    {
      super();
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout$longVideoLayout$2$1$1"})
    static final class a
      implements View.OnClickListener
    {
      a(FinderFullSeekBarLayout.m paramm) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(253899);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout$longVideoLayout$2$$special$$inlined$also$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        this.wbY.wbO.getOnLongVideoBtnClickListener().invoke();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout$longVideoLayout$2$$special$$inlined$also$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(253899);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class n
    extends kotlin.g.b.q
    implements kotlin.g.a.a<kotlin.x>
  {
    public static final n wbZ;
    
    static
    {
      AppMethodBeat.i(253901);
      wbZ = new n();
      AppMethodBeat.o(253901);
    }
    
    n()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class o
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Boolean>
  {
    public static final o wca;
    
    static
    {
      AppMethodBeat.i(253902);
      wca = new o();
      AppMethodBeat.o(253902);
    }
    
    o()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class p
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Boolean>
  {
    public static final p wcb;
    
    static
    {
      AppMethodBeat.i(253903);
      wcb = new p();
      AppMethodBeat.o(253903);
    }
    
    p()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class q
    implements Runnable
  {
    q(FinderFullSeekBarLayout paramFinderFullSeekBarLayout) {}
    
    public final void run()
    {
      AppMethodBeat.i(253904);
      this.wbO.awG("onSingleTapUp");
      AppMethodBeat.o(253904);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class r
    extends kotlin.g.b.q
    implements kotlin.g.a.a<WeImageView>
  {
    r(FinderFullSeekBarLayout paramFinderFullSeekBarLayout)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class s
    extends kotlin.g.b.q
    implements kotlin.g.a.a<View>
  {
    s(FinderFullSeekBarLayout paramFinderFullSeekBarLayout)
    {
      super();
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout$pauseLayout$2$1$1"})
    static final class a
      implements View.OnClickListener
    {
      a(FinderFullSeekBarLayout.s params) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(253906);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout$pauseLayout$2$$special$$inlined$also$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (((Boolean)this.wcc.wbO.getOnPauseClickListener().invoke()).booleanValue())
        {
          FinderFullSeekBarLayout.e(this.wcc.wbO);
          FinderFullSeekBarLayout.f(this.wcc.wbO).setImageResource(2131690647);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout$pauseLayout$2$$special$$inlined$also$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(253906);
          return;
          FinderFullSeekBarLayout.f(this.wcc.wbO).setImageResource(2131690631);
        }
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "kotlin.jvm.PlatformType", "view", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "resource", "Landroid/graphics/Bitmap;", "onImageLoadComplete"})
  static final class t<T, R>
    implements com.tencent.mm.loader.f.e<com.tencent.mm.plugin.finder.loader.o, Bitmap>
  {
    t(FinderFullSeekBarLayout paramFinderFullSeekBarLayout) {}
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout$refreshAwesome$1$1$1"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.a<kotlin.x>
    {
      a(FinderFullSeekBarLayout.t paramt)
      {
        super();
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/SeekBar;", "kotlin.jvm.PlatformType", "invoke"})
  static final class u
    extends kotlin.g.b.q
    implements kotlin.g.a.a<SeekBar>
  {
    u(FinderFullSeekBarLayout paramFinderFullSeekBarLayout)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
  static final class v
    implements View.OnTouchListener
  {
    v(FinderFullSeekBarLayout paramFinderFullSeekBarLayout) {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(253912);
      paramView = FinderFullSeekBarLayout.g(this.wbO);
      paramMotionEvent = new com.tencent.mm.hellhoundlib.b.a().bl(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(paramView, paramMotionEvent.axQ(), "com/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout$seekBarTouchListener$1", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      com.tencent.mm.hellhoundlib.a.a.a(paramView, paramView.onTouchEvent((MotionEvent)paramMotionEvent.pG(0)), "com/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout$seekBarTouchListener$1", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(253912);
      return true;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", "invoke"})
  static final class w
    extends kotlin.g.b.q
    implements kotlin.g.a.a<ViewGroup>
  {
    w(FinderFullSeekBarLayout paramFinderFullSeekBarLayout)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout$showOtherView$1$1", "Lcom/tencent/mm/plugin/finder/animation/AnimatorEndListener;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"})
  public static final class x
    extends com.tencent.mm.plugin.finder.animation.a
  {
    x(View paramView) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(253914);
      kotlin.g.b.p.h(paramAnimator, "animation");
      paramAnimator = this.wbW;
      kotlin.g.b.p.g(paramAnimator, "child");
      paramAnimator.setVisibility(0);
      AppMethodBeat.o(253914);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout$showSeekLayout$1$1", "Lcom/tencent/mm/plugin/finder/animation/AnimatorEndListener;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"})
  public static final class y
    extends com.tencent.mm.plugin.finder.animation.a
  {
    y(FinderFullSeekBarLayout paramFinderFullSeekBarLayout) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(253915);
      BaseFinderFeed localBaseFinderFeed = FinderFullSeekBarLayout.b(this.wbO);
      if (localBaseFinderFeed != null)
      {
        paramAnimator = FinderReporterUIC.wzC;
        paramAnimator = this.wbO.getContext();
        kotlin.g.b.p.g(paramAnimator, "context");
        paramAnimator = FinderReporterUIC.a.fH(paramAnimator);
        if (paramAnimator != null) {}
        for (paramAnimator = paramAnimator.dIx();; paramAnimator = null)
        {
          aj localaj = aj.viU;
          aj.a(paramAnimator, "pause_by_icon", true, localBaseFinderFeed.lT());
          localaj = aj.viU;
          aj.a(paramAnimator, "private_like", true, localBaseFinderFeed.lT());
          AppMethodBeat.o(253915);
          return;
        }
      }
      AppMethodBeat.o(253915);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/view/GestureDetector;", "invoke"})
  static final class z
    extends kotlin.g.b.q
    implements kotlin.g.a.a<GestureDetector>
  {
    z(FinderFullSeekBarLayout paramFinderFullSeekBarLayout)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.FinderFullSeekBarLayout
 * JD-Core Version:    0.7.0.1
 */