package com.tencent.mm.plugin.finder.video;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.f.e;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.i;
import com.tencent.mm.plugin.finder.loader.t.a;
import com.tencent.mm.plugin.finder.loader.w;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.report.am;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.u;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bfz;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.o;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout;", "Landroid/widget/FrameLayout;", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoSeekBar;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "allSec", "allTimeLongTv", "Landroid/widget/TextView;", "getAllTimeLongTv", "()Landroid/widget/TextView;", "allTimeLongTv$delegate", "Lkotlin/Lazy;", "allTimeTv", "getAllTimeTv", "allTimeTv$delegate", "awesomePrivateLayout", "Landroid/view/View;", "getAwesomePrivateLayout", "()Landroid/view/View;", "awesomePrivateLayout$delegate", "currentTimeTv", "getCurrentTimeTv", "currentTimeTv$delegate", "excludeIDs", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "floatPlayIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "hidePrivateLike", "", "getHidePrivateLike", "()Z", "setHidePrivateLike", "(Z)V", "hideSeekbarTask", "Lcom/tencent/threadpool/runnable/FutureEx;", "getHideSeekbarTask", "()Lcom/tencent/threadpool/runnable/FutureEx;", "setHideSeekbarTask", "(Lcom/tencent/threadpool/runnable/FutureEx;)V", "isFinderSelfScene", "isInHeadsetStateChangePauseState", "isPendingExitMode", "isPlaying", "isPlayingCallback", "Lkotlin/Function0;", "()Lkotlin/jvm/functions/Function0;", "setPlayingCallback", "(Lkotlin/jvm/functions/Function0;)V", "isPrivateAwesome", "isSeekBarTrackingTouch", "isSeekMode", "longVideoLayout", "getLongVideoLayout", "longVideoLayout$delegate", "onLongVideoBtnClickListener", "", "getOnLongVideoBtnClickListener", "setOnLongVideoBtnClickListener", "onPauseClickListener", "getOnPauseClickListener", "setOnPauseClickListener", "onPrivateLikeClickListener", "getOnPrivateLikeClickListener", "setOnPrivateLikeClickListener", "onResumePlayListener", "getOnResumePlayListener", "setOnResumePlayListener", "pauseClickByUser", "pauseIcon", "getPauseIcon", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "pauseIcon$delegate", "privateAwesomeIcon", "getPrivateAwesomeIcon", "privateAwesomeIcon$delegate", "seekBar", "Landroid/widget/SeekBar;", "getSeekBar", "()Landroid/widget/SeekBar;", "seekBar$delegate", "seekBarCallback", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoSeekBar$SeekBarCallback;", "seekLayout", "Landroid/view/ViewGroup;", "getSeekLayout", "()Landroid/view/ViewGroup;", "seekLayout$delegate", "tmpMaxProgress", "checkShowGroupLikeTips", "dismissGroupLikeTips", "dismissProgressBar", "enterOnHeadsetStateChangePauseState", "enterSeekMode", "exitOnHeadsetStateChangePauseState", "exitSeekMode", "reason", "", "formatSecToMin", "second", "getCurrentProgress", "getMaxProgress", "getSeekPercent", "", "hideAwesomePrivateLayout", "isShow", "hideGroupLikeTips", "hideSeekLayout", "isInSeekMode", "isSeekingMode", "isShownSeekBar", "onAttachedToWindow", "onDetachedFromWindow", "onProgressChanged", "progress", "fromUser", "onStartTrackingTouch", "onStopTrackingTouch", "refreshAwesome", "refreshFinderFeed", "item", "reportPauseClick", "setExcludeIDs", "set", "", "setFinderFeed", "setFloatPlayIcon", "icon", "setPlayingStatus", "setProgress", "target", "setSeekBarCallback", "callback", "showProgressBar", "isShowThumb", "showSeekLayout", "toggleSeekMode", "updateAllTime", "offsetSec", "updateCurrentTime", "updateProgressMs", "percent", "offsetMs", "", "allMs", "updateProgressSec", "updateSeekTime", "Companion", "plugin-finder_release"})
@SuppressLint({"ResourceType"})
public final class FinderFullSeekBarLayout
  extends FrameLayout
  implements SeekBar.OnSeekBarChangeListener, r
{
  private static final int AKB;
  private static final int AKC;
  private static final int AKD;
  private static final HashMap<Long, Integer> AKE;
  public static final a AKF;
  private final HashSet<Integer> AKA;
  private kotlin.g.a.a<kotlin.x> AKa;
  private kotlin.g.a.a<Boolean> AKb;
  private kotlin.g.a.a<Boolean> AKc;
  private kotlin.g.a.a<Boolean> AKd;
  private kotlin.g.a.a<kotlin.x> AKe;
  private final kotlin.f AKf;
  private final kotlin.f AKg;
  private final kotlin.f AKh;
  private final kotlin.f AKi;
  private final kotlin.f AKj;
  private final kotlin.f AKk;
  private boolean AKl;
  private final kotlin.f AKm;
  private final kotlin.f AKn;
  private WeImageView AKo;
  private boolean AKp;
  private boolean AKq;
  private boolean AKr;
  private boolean AKs;
  private boolean AKt;
  private r.a AKu;
  public boolean AKv;
  private com.tencent.e.i.d<?> AKw;
  private int AKx;
  private int AKy;
  public boolean AKz;
  private final kotlin.f AsO;
  public boolean fGh;
  public BaseFinderFeed xxO;
  
  static
  {
    AppMethodBeat.i(286627);
    AKF = new a((byte)0);
    Context localContext = MMApplicationContext.getContext();
    p.j(localContext, "MMApplicationContext.getContext()");
    AKB = (int)localContext.getResources().getDimension(b.d.Edge_5A);
    localContext = MMApplicationContext.getContext();
    p.j(localContext, "MMApplicationContext.getContext()");
    AKC = (int)localContext.getResources().getDimension(b.d.Edge_4A);
    localContext = MMApplicationContext.getContext();
    p.j(localContext, "MMApplicationContext.getContext()");
    AKD = (int)localContext.getResources().getDimension(b.d.Edge_1_5_A);
    AKE = new HashMap();
    AppMethodBeat.o(286627);
  }
  
  public FinderFullSeekBarLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(286625);
    this.AsO = kotlin.g.ar((kotlin.g.a.a)new w(this));
    this.AKa = ((kotlin.g.a.a)q.AKV);
    this.AKb = ((kotlin.g.a.a)p.AKU);
    this.AKc = ((kotlin.g.a.a)o.AKT);
    this.AKd = ((kotlin.g.a.a)l.AKQ);
    this.AKe = ((kotlin.g.a.a)n.AKS);
    this.AKf = kotlin.g.ar((kotlin.g.a.a)new x(this));
    this.AKg = kotlin.g.ar((kotlin.g.a.a)new f(this));
    this.AKh = kotlin.g.ar((kotlin.g.a.a)new c(this));
    this.AKi = kotlin.g.ar((kotlin.g.a.a)new b(this));
    this.AKj = kotlin.g.ar((kotlin.g.a.a)new m(this));
    this.AKk = kotlin.g.ar((kotlin.g.a.a)new d(this));
    this.AKl = true;
    this.AKm = kotlin.g.ar((kotlin.g.a.a)new s(this));
    this.AKn = kotlin.g.ar((kotlin.g.a.a)new t(this));
    this.AKx = -1;
    this.AKA = new HashSet();
    AppMethodBeat.o(286625);
  }
  
  public FinderFullSeekBarLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(286626);
    this.AsO = kotlin.g.ar((kotlin.g.a.a)new w(this));
    this.AKa = ((kotlin.g.a.a)q.AKV);
    this.AKb = ((kotlin.g.a.a)p.AKU);
    this.AKc = ((kotlin.g.a.a)o.AKT);
    this.AKd = ((kotlin.g.a.a)l.AKQ);
    this.AKe = ((kotlin.g.a.a)n.AKS);
    this.AKf = kotlin.g.ar((kotlin.g.a.a)new x(this));
    this.AKg = kotlin.g.ar((kotlin.g.a.a)new f(this));
    this.AKh = kotlin.g.ar((kotlin.g.a.a)new c(this));
    this.AKi = kotlin.g.ar((kotlin.g.a.a)new b(this));
    this.AKj = kotlin.g.ar((kotlin.g.a.a)new m(this));
    this.AKk = kotlin.g.ar((kotlin.g.a.a)new d(this));
    this.AKl = true;
    this.AKm = kotlin.g.ar((kotlin.g.a.a)new s(this));
    this.AKn = kotlin.g.ar((kotlin.g.a.a)new t(this));
    this.AKx = -1;
    this.AKA = new HashSet();
    AppMethodBeat.o(286626);
  }
  
  private final void Rr(int paramInt)
  {
    AppMethodBeat.i(286619);
    getCurrentTimeTv().setText((CharSequence)formatSecToMin(paramInt));
    AppMethodBeat.o(286619);
  }
  
  private final void egG()
  {
    AppMethodBeat.i(286594);
    String str;
    BaseFinderFeed localBaseFinderFeed;
    if (this.AKl)
    {
      str = "pause_by_icon";
      localBaseFinderFeed = this.xxO;
      if (localBaseFinderFeed == null) {
        break label94;
      }
      localObject = am.zZN;
      localObject = aj.Bnu;
      localObject = getContext();
      p.j(localObject, "context");
      localObject = aj.a.fZ((Context)localObject);
      if (localObject == null) {
        break label89;
      }
    }
    label89:
    for (Object localObject = ((aj)localObject).ekY();; localObject = null)
    {
      am.a((bid)localObject, str, false, localBaseFinderFeed.mf());
      AppMethodBeat.o(286594);
      return;
      this.AKl = true;
      str = "pause_by_clckscreen";
      break;
    }
    label94:
    AppMethodBeat.o(286594);
  }
  
  private final void egM()
  {
    AppMethodBeat.i(286615);
    Object localObject = getParent();
    if (localObject == null)
    {
      localObject = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(286615);
      throw ((Throwable)localObject);
    }
    localObject = (ViewGroup)localObject;
    View localView = ((ViewGroup)localObject).findViewById(b.f.finder_feed_full_group_like_tips_layout);
    if (localView != null)
    {
      ((ViewGroup)localObject).removeView(localView);
      AppMethodBeat.o(286615);
      return;
    }
    AppMethodBeat.o(286615);
  }
  
  private final void egN()
  {
    AppMethodBeat.i(286617);
    Object localObject1 = this.xxO;
    if (localObject1 != null)
    {
      localObject1 = ((BaseFinderFeed)localObject1).feedObject;
      if ((localObject1 != null) && (((FinderItem)localObject1).isLongVideo() == true))
      {
        localObject1 = com.tencent.mm.plugin.finder.storage.d.AjH;
        if (((Number)com.tencent.mm.plugin.finder.storage.d.dXx().aSr()).intValue() != 0)
        {
          localObject1 = this.xxO;
          if (localObject1 != null)
          {
            localObject1 = ((BaseFinderFeed)localObject1).feedObject;
            if ((localObject1 == null) || (((FinderItem)localObject1).isPostFinish() != true)) {}
          }
        }
        else
        {
          getAllTimeTv().setVisibility(8);
          getLongVideoLayout().setVisibility(0);
        }
      }
    }
    Object localObject2;
    for (;;)
    {
      localObject1 = (ViewGroup)getSeekLayout().findViewById(b.f.part_top_layout);
      p.j(localObject1, "partTopLayout");
      int j = ((ViewGroup)localObject1).getChildCount();
      int i = 0;
      while (i < j)
      {
        localObject2 = ((ViewGroup)localObject1).getChildAt(i);
        p.j(localObject2, "child");
        if (((View)localObject2).getId() != b.f.full_long_video_layout)
        {
          Object localObject3 = this.xxO;
          if (localObject3 != null)
          {
            localObject3 = ((BaseFinderFeed)localObject3).feedObject;
            if ((localObject3 != null) && (!((FinderItem)localObject3).isLongVideo())) {
              break label216;
            }
          }
          label216:
          if ((((View)localObject2).getId() != getAllTimeTv().getId()) && (((View)localObject2).getVisibility() != 0))
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
        i += 1;
      }
      getLongVideoLayout().setVisibility(8);
      getAllTimeTv().setVisibility(0);
    }
    localObject1 = com.tencent.mm.plugin.finder.storage.d.AjH;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.dXx().aSr()).intValue() == 1)
    {
      localObject1 = this.xxO;
      if ((localObject1 != null) && (((BaseFinderFeed)localObject1).bAQ() == 4))
      {
        localObject1 = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("offset", new float[] { 0.0F, 1.0F }) });
        p.j(localObject1, "animator");
        ((ValueAnimator)localObject1).setInterpolator((TimeInterpolator)new LinearInterpolator());
        ((ValueAnimator)localObject1).setDuration(200L);
        ((ValueAnimator)localObject1).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new z(this));
        ((ValueAnimator)localObject1).start();
      }
    }
    localObject1 = getSeekLayout().findViewById(b.f.part_bottom_layout);
    if ((localObject1 != null) && (((View)localObject1).getVisibility() != 0))
    {
      localObject2 = ((View)localObject1).animate();
      if (localObject2 != null) {
        ((ViewPropertyAnimator)localObject2).cancel();
      }
      ((View)localObject1).setVisibility(0);
      ((View)localObject1).setAlpha(0.0F);
      ((View)localObject1).animate().alpha(1.0F).setDuration(130L).setListener((Animator.AnimatorListener)new y(this)).start();
    }
    localObject1 = this.xxO;
    if (localObject1 != null)
    {
      localObject1 = ((BaseFinderFeed)localObject1).feedObject;
      if (localObject1 != null)
      {
        localObject1 = ((FinderItem)localObject1).getFeedObject();
        if (localObject1 != null)
        {
          localObject2 = com.tencent.mm.plugin.finder.upload.action.l.ACj;
          localObject1 = com.tencent.mm.plugin.finder.upload.action.l.ecG().r((FinderObject)localObject1);
          bool1 = ((Boolean)((o)localObject1).Mx).booleanValue();
          boolean bool2 = ((Boolean)((o)localObject1).My).booleanValue();
          if ((!bool1) || (!bool2)) {
            break label665;
          }
        }
      }
    }
    label665:
    for (boolean bool1 = true;; bool1 = false)
    {
      qV(bool1);
      if ((((Boolean)this.AKd.invoke()).booleanValue()) || (this.AKz))
      {
        this.AKl = false;
        if (((Boolean)this.AKc.invoke()).booleanValue()) {
          egG();
        }
      }
      egP();
      AppMethodBeat.o(286617);
      return;
    }
  }
  
  private final void egO()
  {
    AppMethodBeat.i(286618);
    egQ();
    Object localObject1 = getSeekLayout().findViewById(b.f.part_bottom_layout);
    Object localObject2;
    if ((localObject1 != null) && (((View)localObject1).getVisibility() == 0))
    {
      localObject2 = ((View)localObject1).animate();
      if (localObject2 != null) {
        ((ViewPropertyAnimator)localObject2).cancel();
      }
      ((View)localObject1).animate().alpha(0.0F).setDuration(130L).setListener((Animator.AnimatorListener)new i((View)localObject1)).start();
    }
    localObject1 = com.tencent.mm.plugin.finder.storage.d.AjH;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.dXx().aSr()).intValue() == 1)
    {
      localObject1 = this.xxO;
      if ((localObject1 != null) && (((BaseFinderFeed)localObject1).bAQ() == 4))
      {
        localObject1 = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("offset", new float[] { 1.0F, 0.0F }) });
        p.j(localObject1, "animator");
        ((ValueAnimator)localObject1).setInterpolator((TimeInterpolator)new LinearInterpolator());
        ((ValueAnimator)localObject1).setDuration(200L);
        ((ValueAnimator)localObject1).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new j(this));
        ((ValueAnimator)localObject1).start();
      }
    }
    localObject1 = (ViewGroup)getSeekLayout().findViewById(b.f.part_top_layout);
    p.j(localObject1, "partTopLayout");
    int j = ((ViewGroup)localObject1).getChildCount();
    int i = 0;
    while (i < j)
    {
      localObject2 = ((ViewGroup)localObject1).getChildAt(i);
      p.j(localObject2, "child");
      if ((((View)localObject2).getId() != b.f.full_long_video_layout) && (((View)localObject2).getVisibility() == 0) && (((View)localObject2).getVisibility() == 0))
      {
        ViewPropertyAnimator localViewPropertyAnimator = ((View)localObject2).animate();
        if (localViewPropertyAnimator != null) {
          localViewPropertyAnimator.cancel();
        }
        ((View)localObject2).animate().alpha(0.0F).setDuration(130L).setListener((Animator.AnimatorListener)new k((View)localObject2)).start();
      }
      i += 1;
    }
    if (!((Boolean)this.AKd.invoke()).booleanValue())
    {
      this.AKl = false;
      if (((Boolean)this.AKc.invoke()).booleanValue()) {
        egG();
      }
    }
    AppMethodBeat.o(286618);
  }
  
  private final void egP()
  {
    int i = 1;
    AppMethodBeat.i(286622);
    if (!this.AKs)
    {
      localObject = this.xxO;
      if (((localObject == null) || (((BaseFinderFeed)localObject).isPreview != true)) && (!this.AKt)) {}
    }
    else
    {
      AppMethodBeat.o(286622);
      return;
    }
    if (this.AKr)
    {
      AppMethodBeat.o(286622);
      return;
    }
    Object localObject = getAwesomePrivateLayout();
    if (localObject != null)
    {
      if (((View)localObject).getVisibility() != 0) {
        AppMethodBeat.o(286622);
      }
    }
    else
    {
      AppMethodBeat.o(286622);
      return;
    }
    localObject = com.tencent.mm.kernel.h.aHG();
    p.j(localObject, "MMKernel.storage()");
    final int j = ((com.tencent.mm.kernel.f)localObject).aHp().getInt(ar.a.VxS, 0);
    if (j < 3)
    {
      localObject = getParent();
      if (localObject == null)
      {
        localObject = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(286622);
        throw ((Throwable)localObject);
      }
      localObject = (ViewGroup)localObject;
      if (((ViewGroup)localObject).findViewById(b.f.finder_feed_full_group_like_tips_layout) != null) {}
      while (i != 0)
      {
        AppMethodBeat.o(286622);
        return;
        i = 0;
      }
      final Rect localRect = new Rect();
      final View localView = ad.kS(getContext()).inflate(b.g.finder_group_like_tips_layout, (ViewGroup)localObject, false);
      p.j(localView, "tipsLayout");
      localView.setAlpha(0.0F);
      ((ViewGroup)localObject).addView(localView);
      localView.postDelayed((Runnable)new e(this, localRect, localView, j, (ViewGroup)localObject), 600L);
    }
    AppMethodBeat.o(286622);
  }
  
  private final void egQ()
  {
    AppMethodBeat.i(286623);
    Log.i("Finder.FullSeekBarLayout", "[dismissGroupLikeTips]");
    Object localObject2 = getParent();
    Object localObject1 = localObject2;
    if (!(localObject2 instanceof ViewGroup)) {
      localObject1 = null;
    }
    localObject1 = (ViewGroup)localObject1;
    if (localObject1 != null)
    {
      localObject2 = ((ViewGroup)localObject1).findViewById(b.f.finder_feed_full_group_like_tips_layout);
      if (localObject2 != null)
      {
        ((View)localObject2).post((Runnable)new g((View)localObject2, (ViewGroup)localObject1));
        AppMethodBeat.o(286623);
        return;
      }
    }
    AppMethodBeat.o(286623);
  }
  
  private static String formatSecToMin(int paramInt)
  {
    AppMethodBeat.i(286621);
    Object localObject = af.aaBG;
    localObject = String.format("%02d:%02d", Arrays.copyOf(new Object[] { Long.valueOf(paramInt / 60L), Long.valueOf(paramInt % 60L) }, 2));
    p.j(localObject, "java.lang.String.format(format, *args)");
    AppMethodBeat.o(286621);
    return localObject;
  }
  
  private final TextView getAllTimeLongTv()
  {
    AppMethodBeat.i(286591);
    TextView localTextView = (TextView)this.AKi.getValue();
    AppMethodBeat.o(286591);
    return localTextView;
  }
  
  private final TextView getAllTimeTv()
  {
    AppMethodBeat.i(286590);
    TextView localTextView = (TextView)this.AKh.getValue();
    AppMethodBeat.o(286590);
    return localTextView;
  }
  
  private final View getAwesomePrivateLayout()
  {
    AppMethodBeat.i(286593);
    View localView = (View)this.AKk.getValue();
    AppMethodBeat.o(286593);
    return localView;
  }
  
  private final TextView getCurrentTimeTv()
  {
    AppMethodBeat.i(286589);
    TextView localTextView = (TextView)this.AKg.getValue();
    AppMethodBeat.o(286589);
    return localTextView;
  }
  
  private final View getLongVideoLayout()
  {
    AppMethodBeat.i(286592);
    View localView = (View)this.AKj.getValue();
    AppMethodBeat.o(286592);
    return localView;
  }
  
  private final WeImageView getPauseIcon()
  {
    AppMethodBeat.i(286595);
    WeImageView localWeImageView = (WeImageView)this.AKm.getValue();
    AppMethodBeat.o(286595);
    return localWeImageView;
  }
  
  private final WeImageView getPrivateAwesomeIcon()
  {
    AppMethodBeat.i(286596);
    WeImageView localWeImageView = (WeImageView)this.AKn.getValue();
    AppMethodBeat.o(286596);
    return localWeImageView;
  }
  
  private final SeekBar getSeekBar()
  {
    AppMethodBeat.i(286582);
    SeekBar localSeekBar = (SeekBar)this.AsO.getValue();
    AppMethodBeat.o(286582);
    return localSeekBar;
  }
  
  private final ViewGroup getSeekLayout()
  {
    AppMethodBeat.i(286588);
    ViewGroup localViewGroup = (ViewGroup)this.AKf.getValue();
    AppMethodBeat.o(286588);
    return localViewGroup;
  }
  
  private final float getSeekPercent()
  {
    AppMethodBeat.i(286613);
    SeekBar localSeekBar = getSeekBar();
    if (localSeekBar == null)
    {
      AppMethodBeat.o(286613);
      return 0.0F;
    }
    float f = 1.0F * localSeekBar.getProgress() / localSeekBar.getMax();
    AppMethodBeat.o(286613);
    return f;
  }
  
  private final void hf(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(286620);
    Object localObject = formatSecToMin(paramInt2);
    getAllTimeTv().setText((CharSequence)localObject);
    getAllTimeLongTv().setText((CharSequence)formatSecToMin(paramInt2 - paramInt1));
    localObject = this.xxO;
    if (localObject != null)
    {
      ((BaseFinderFeed)localObject).isHasLongVideoTimeBack = true;
      AppMethodBeat.o(286620);
      return;
    }
    AppMethodBeat.o(286620);
  }
  
  private final void qX(boolean paramBoolean)
  {
    AppMethodBeat.i(286616);
    Object localObject = this.xxO;
    if (((localObject == null) || (((BaseFinderFeed)localObject).isPreview != true)) && (!this.AKs))
    {
      localObject = this.xxO;
      if (localObject != null)
      {
        localObject = ((BaseFinderFeed)localObject).feedObject;
        if ((localObject != null) && (((FinderItem)localObject).isPostFinish() == true) && (!this.AKt)) {
          break label129;
        }
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
    if (localObject != null)
    {
      ((View)localObject).setVisibility(4);
      AppMethodBeat.o(286616);
      return;
    }
    AppMethodBeat.o(286616);
    return;
    label129:
    localObject = getParent();
    if (localObject == null)
    {
      localObject = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(286616);
      throw ((Throwable)localObject);
    }
    localObject = ((ViewGroup)localObject).findViewById(b.f.image_banner_indicator);
    if (localObject != null)
    {
      if (paramBoolean) {
        ((View)localObject).setVisibility(8);
      }
    }
    else
    {
      localObject = getAwesomePrivateLayout();
      if (localObject == null) {
        break label347;
      }
      localObject = ((View)localObject).getTag();
    }
    for (;;)
    {
      if ((paramBoolean) && ((p.h(localObject, Boolean.TRUE) ^ true)))
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
        if (localObject != null)
        {
          localObject = ((View)localObject).animate();
          if (localObject != null)
          {
            localObject = ((ViewPropertyAnimator)localObject).alpha(1.0F);
            if (localObject != null)
            {
              localObject = ((ViewPropertyAnimator)localObject).setDuration(200L);
              if (localObject != null)
              {
                localObject = ((ViewPropertyAnimator)localObject).setListener(null);
                if (localObject != null)
                {
                  ((ViewPropertyAnimator)localObject).start();
                  AppMethodBeat.o(286616);
                  return;
                  ((View)localObject).setVisibility(0);
                  break;
                  label347:
                  localObject = null;
                  continue;
                }
              }
            }
          }
        }
        AppMethodBeat.o(286616);
        return;
      }
    }
    if ((!paramBoolean) && ((p.h(localObject, Boolean.FALSE) ^ true)))
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
              localObject = ((ViewPropertyAnimator)localObject).setListener((Animator.AnimatorListener)new h(this));
              if (localObject != null)
              {
                ((ViewPropertyAnimator)localObject).start();
                AppMethodBeat.o(286616);
                return;
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(286616);
  }
  
  public final void aGh(String paramString)
  {
    AppMethodBeat.i(286610);
    p.k(paramString, "reason");
    this.AKx = -1;
    if (!this.AKv)
    {
      AppMethodBeat.o(286610);
      return;
    }
    Log.i("Finder.FullSeekBarLayout", "[exitSeekMode] reason=".concat(String.valueOf(paramString)));
    this.AKv = false;
    egO();
    qX(false);
    egM();
    getSeekLayout().setClickable(false);
    this.AKq = false;
    AppMethodBeat.o(286610);
  }
  
  public final void b(boolean paramBoolean, BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(286599);
    this.AKs = paramBoolean;
    this.xxO = paramBaseFinderFeed;
    getAllTimeTv().setVisibility(8);
    if (paramBaseFinderFeed != null)
    {
      FinderItem localFinderItem = paramBaseFinderFeed.feedObject;
      if ((localFinderItem != null) && (localFinderItem.isLongVideo() == true))
      {
        getLongVideoLayout().setVisibility(0);
        hf(0, ((csg)paramBaseFinderFeed.feedObject.getLongVideoMediaList().getFirst()).videoDuration);
        AppMethodBeat.o(286599);
        return;
      }
    }
    getLongVideoLayout().setVisibility(8);
    AppMethodBeat.o(286599);
  }
  
  public final void bk(float paramFloat)
  {
    AppMethodBeat.i(286609);
    setProgress(kotlin.h.a.dm(getSeekBar().getMax() * paramFloat));
    AppMethodBeat.o(286609);
  }
  
  public final void egH() {}
  
  public final boolean egI()
  {
    return true;
  }
  
  public final boolean egJ()
  {
    return this.AKp;
  }
  
  public final void egK()
  {
    AppMethodBeat.i(286611);
    if ((this.AKv) && (!this.AKq))
    {
      AppMethodBeat.o(286611);
      return;
    }
    this.AKv = true;
    setPlayingStatus(false);
    egN();
    getSeekLayout().setClickable(true);
    AppMethodBeat.o(286611);
  }
  
  public final void egL()
  {
    AppMethodBeat.i(286612);
    Context localContext = getContext();
    Object localObject = localContext;
    if (!(localContext instanceof MMActivity)) {
      localObject = null;
    }
    localObject = (MMActivity)localObject;
    if ((localObject != null) && (((MMActivity)localObject).isPaused() == true))
    {
      Log.w("Finder.FullSeekBarLayout", "[toggleSeekMode] Activity is paused!");
      AppMethodBeat.o(286612);
      return;
    }
    localObject = this.AKw;
    if (localObject != null) {
      ((com.tencent.e.i.d)localObject).cancel(false);
    }
    if ((this.AKv) && (!this.AKq)) {
      aGh("onSingleTapUp#isClickable=" + getSeekLayout().isClickable());
    }
    for (;;)
    {
      this.AKq = false;
      AppMethodBeat.o(286612);
      return;
      egK();
    }
  }
  
  public final int getCurrentProgress()
  {
    AppMethodBeat.i(286605);
    int i = getSeekBar().getProgress();
    AppMethodBeat.o(286605);
    return i;
  }
  
  public final boolean getHidePrivateLike()
  {
    return this.AKt;
  }
  
  public final com.tencent.e.i.d<?> getHideSeekbarTask()
  {
    return this.AKw;
  }
  
  public final int getMaxProgress()
  {
    AppMethodBeat.i(286606);
    int i = getSeekBar().getMax();
    AppMethodBeat.o(286606);
    return i;
  }
  
  public final kotlin.g.a.a<kotlin.x> getOnLongVideoBtnClickListener()
  {
    return this.AKe;
  }
  
  public final kotlin.g.a.a<Boolean> getOnPauseClickListener()
  {
    return this.AKc;
  }
  
  public final kotlin.g.a.a<Boolean> getOnPrivateLikeClickListener()
  {
    return this.AKb;
  }
  
  public final kotlin.g.a.a<kotlin.x> getOnResumePlayListener()
  {
    return this.AKa;
  }
  
  public final void he(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(286608);
    this.AKy = paramInt2;
    if (paramInt1 <= 1) {
      this.AKx = -1;
    }
    hf(paramInt1, paramInt2);
    Rr(paramInt1);
    AppMethodBeat.o(286608);
  }
  
  protected final void onAttachedToWindow()
  {
    AppMethodBeat.i(286597);
    super.onAttachedToWindow();
    getAllTimeLongTv().setTextSize(1, 14.0F);
    getAllTimeTv().setTextSize(1, 14.0F);
    getCurrentTimeTv().setTextSize(1, 14.0F);
    AppMethodBeat.o(286597);
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(286624);
    super.onDetachedFromWindow();
    egQ();
    if (this.AKq)
    {
      com.tencent.e.i.d locald = this.AKw;
      if (locald != null) {
        locald.cancel(false);
      }
      aGh("hideSeekbarTask");
    }
    AppMethodBeat.o(286624);
  }
  
  public final void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(286602);
    p.k(paramSeekBar, "seekBar");
    if (paramBoolean)
    {
      paramInt = this.AKy;
      float f1 = getSeekBar().getProgress() / getSeekBar().getMax();
      float f2 = paramInt;
      Rr((int)androidx.core.b.a.c(f1 * f2, 0.0F, f2 - 1.0F));
    }
    AppMethodBeat.o(286602);
  }
  
  public final void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    AppMethodBeat.i(286601);
    p.k(paramSeekBar, "seekBar");
    this.AKp = true;
    paramSeekBar = this.AKu;
    if (paramSeekBar != null) {
      paramSeekBar.ehv();
    }
    paramSeekBar = this.AKw;
    if (paramSeekBar != null)
    {
      paramSeekBar.cancel(false);
      AppMethodBeat.o(286601);
      return;
    }
    AppMethodBeat.o(286601);
  }
  
  public final void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    AppMethodBeat.i(286603);
    p.k(paramSeekBar, "seekBar");
    this.AKp = false;
    this.AKx = paramSeekBar.getProgress();
    this.AKq = true;
    paramSeekBar = this.AKu;
    if (paramSeekBar != null) {
      paramSeekBar.bl(getSeekPercent());
    }
    this.AKa.invoke();
    paramSeekBar = this.AKo;
    if (paramSeekBar != null) {
      paramSeekBar.setVisibility(8);
    }
    paramSeekBar = this.AKw;
    if (paramSeekBar != null) {
      paramSeekBar.cancel(false);
    }
    this.AKw = com.tencent.e.h.ZvG.n((Runnable)new r(this), 3000L);
    AppMethodBeat.o(286603);
  }
  
  public final void qV(final boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(286598);
    Object localObject1 = com.tencent.mm.plugin.finder.storage.logic.g.AnT;
    localObject1 = this.xxO;
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
          localObject1 = com.tencent.mm.plugin.finder.storage.logic.g.Qt(i);
          if (localObject1 == null) {
            break label221;
          }
        }
      }
    }
    WeImageView localWeImageView;
    Object localObject3;
    label221:
    for (localObject1 = ((bfz)localObject1).SQP;; localObject1 = null)
    {
      this.AKr = paramBoolean;
      Log.i("Finder.FullSeekBarLayout", "[refreshAwesome] isLike=" + paramBoolean + " groupLikeIconUrl=" + (String)localObject1);
      localWeImageView = getPrivateAwesomeIcon();
      if (localWeImageView == null) {
        break label427;
      }
      if (!paramBoolean) {
        break label272;
      }
      if (localObject1 == null) {
        break label227;
      }
      localWeImageView.setLayerPaint(null);
      localObject2 = com.tencent.mm.plugin.finder.loader.t.ztT;
      localObject2 = com.tencent.mm.plugin.finder.loader.t.dJe().bQ(new com.tencent.mm.plugin.finder.loader.x((String)localObject1, u.Aly));
      localObject3 = com.tencent.mm.plugin.finder.loader.t.ztT;
      ((com.tencent.mm.loader.a.b)localObject2).a(com.tencent.mm.plugin.finder.loader.t.a(t.a.ztU)).a((e)new u(localWeImageView, this, paramBoolean, (String)localObject1)).c((ImageView)localWeImageView);
      AppMethodBeat.o(286598);
      return;
      i = 0;
      break;
    }
    label227:
    localWeImageView.setImageResource(b.i.icons_filled_like_group);
    localObject1 = getContext();
    p.j(localObject1, "context");
    localWeImageView.setIconColor(((Context)localObject1).getResources().getColor(b.c.Red_90));
    AppMethodBeat.o(286598);
    return;
    label272:
    Object localObject2 = (CharSequence)localObject1;
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
      localWeImageView.setImageResource(b.i.icons_filled_like_group);
    }
    for (;;)
    {
      localObject1 = getContext();
      p.j(localObject1, "context");
      localWeImageView.setIconColor(((Context)localObject1).getResources().getColor(b.c.hot_tab_BW_100_Alpha_0_8));
      AppMethodBeat.o(286598);
      return;
      localWeImageView.setLayerPaint(null);
      localObject2 = com.tencent.mm.plugin.finder.loader.t.ztT;
      localObject2 = com.tencent.mm.plugin.finder.loader.t.dJe();
      localObject3 = new com.tencent.mm.plugin.finder.loader.x((String)localObject1, u.Aly);
      com.tencent.mm.plugin.finder.loader.t localt = com.tencent.mm.plugin.finder.loader.t.ztT;
      ((com.tencent.mm.loader.d)localObject2).a(localObject3, com.tencent.mm.plugin.finder.loader.t.a(t.a.ztU)).a((e)new v(localWeImageView, this, paramBoolean, (String)localObject1)).c((ImageView)localWeImageView);
    }
    label427:
    AppMethodBeat.o(286598);
  }
  
  public final void qW(boolean paramBoolean) {}
  
  public final void setExcludeIDs(Set<Integer> paramSet)
  {
    AppMethodBeat.i(286614);
    p.k(paramSet, "set");
    this.AKA.addAll((Collection)paramSet);
    AppMethodBeat.o(286614);
  }
  
  public final void setFloatPlayIcon(WeImageView paramWeImageView)
  {
    this.AKo = paramWeImageView;
  }
  
  public final void setHidePrivateLike(boolean paramBoolean)
  {
    this.AKt = paramBoolean;
  }
  
  public final void setHideSeekbarTask(com.tencent.e.i.d<?> paramd)
  {
    this.AKw = paramd;
  }
  
  public final void setOnLongVideoBtnClickListener(kotlin.g.a.a<kotlin.x> parama)
  {
    AppMethodBeat.i(286587);
    p.k(parama, "<set-?>");
    this.AKe = parama;
    AppMethodBeat.o(286587);
  }
  
  public final void setOnPauseClickListener(kotlin.g.a.a<Boolean> parama)
  {
    AppMethodBeat.i(286585);
    p.k(parama, "<set-?>");
    this.AKc = parama;
    AppMethodBeat.o(286585);
  }
  
  public final void setOnPrivateLikeClickListener(kotlin.g.a.a<Boolean> parama)
  {
    AppMethodBeat.i(286584);
    p.k(parama, "<set-?>");
    this.AKb = parama;
    AppMethodBeat.o(286584);
  }
  
  public final void setOnResumePlayListener(kotlin.g.a.a<kotlin.x> parama)
  {
    AppMethodBeat.i(286583);
    p.k(parama, "<set-?>");
    this.AKa = parama;
    AppMethodBeat.o(286583);
  }
  
  public final void setPlayingCallback(kotlin.g.a.a<Boolean> parama)
  {
    AppMethodBeat.i(286586);
    p.k(parama, "<set-?>");
    this.AKd = parama;
    AppMethodBeat.o(286586);
  }
  
  public final void setPlayingStatus(boolean paramBoolean)
  {
    AppMethodBeat.i(286600);
    this.fGh = paramBoolean;
    if (!paramBoolean)
    {
      localWeImageView = getPauseIcon();
      if (localWeImageView != null) {
        localWeImageView.setImageResource(b.i.icons_filled_play);
      }
      localWeImageView = this.AKo;
      if (localWeImageView != null) {
        localWeImageView.setVisibility(0);
      }
      qX(true);
      AppMethodBeat.o(286600);
      return;
    }
    WeImageView localWeImageView = getPauseIcon();
    if (localWeImageView != null) {
      localWeImageView.setImageResource(b.i.icons_filled_pause);
    }
    localWeImageView = this.AKo;
    if (localWeImageView != null) {
      localWeImageView.setVisibility(8);
    }
    qX(false);
    AppMethodBeat.o(286600);
  }
  
  public final void setProgress(int paramInt)
  {
    AppMethodBeat.i(286604);
    if (paramInt <= 1) {
      this.AKx = -1;
    }
    getSeekBar().setProgress(Math.max(this.AKx, paramInt));
    AppMethodBeat.o(286604);
  }
  
  public final void setSeekBarCallback(r.a parama)
  {
    AppMethodBeat.i(286607);
    p.k(parama, "callback");
    this.AKu = parama;
    AppMethodBeat.o(286607);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout$Companion;", "", "()V", "ANIMATION_DURATION", "", "ANIMATION_SEEK_LAYOUT_DURATION", "TAG", "", "_1_5_A_PADDING", "", "get_1_5_A_PADDING", "()I", "_4A_PADDING", "get_4A_PADDING", "_6A_PADDING", "get_6A_PADDING", "showGroupTipsSet", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getShowGroupTipsSet", "()Ljava/util/HashMap;", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<TextView>
  {
    b(FinderFullSeekBarLayout paramFinderFullSeekBarLayout)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<TextView>
  {
    c(FinderFullSeekBarLayout paramFinderFullSeekBarLayout)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<View>
  {
    d(FinderFullSeekBarLayout paramFinderFullSeekBarLayout)
    {
      super();
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout$awesomePrivateLayout$2$1$1"})
    static final class a
      implements View.OnClickListener
    {
      a(FinderFullSeekBarLayout.d paramd) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(265667);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout$awesomePrivateLayout$2$$special$$inlined$also$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        boolean bool = ((Boolean)this.AKH.AKG.getOnPrivateLikeClickListener().invoke()).booleanValue();
        FinderFullSeekBarLayout.e(this.AKH.AKG);
        this.AKH.AKG.qV(bool);
        if (bool)
        {
          localObject = FinderFullSeekBarLayout.d(this.AKH.AKG);
          if (localObject != null)
          {
            paramView = am.zZN;
            paramView = aj.Bnu;
            paramView = this.AKH.AKG.getContext();
            p.j(paramView, "context");
            paramView = aj.a.fZ(paramView);
            if (paramView == null) {
              break label267;
            }
          }
        }
        label267:
        for (paramView = paramView.ekY();; paramView = null)
        {
          am.a(paramView, "private_like", false, ((BaseFinderFeed)localObject).mf());
          this.AKH.AKG.getOnResumePlayListener().invoke();
          paramView = FinderFullSeekBarLayout.f(this.AKH.AKG);
          if (paramView != null) {
            paramView.setVisibility(8);
          }
          FinderFullSeekBarLayout.a(this.AKH.AKG, true);
          paramView = this.AKH.AKG.getHideSeekbarTask();
          if (paramView != null) {
            paramView.cancel(false);
          }
          this.AKH.AKG.setHideSeekbarTask(com.tencent.e.h.ZvG.n((Runnable)new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(270241);
              this.AKI.AKH.AKG.aGh("hideSeekbarTask");
              FinderFullSeekBarLayout.a(this.AKI.AKH.AKG, false);
              AppMethodBeat.o(270241);
            }
          }, 3000L));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout$awesomePrivateLayout$2$$special$$inlined$also$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(265667);
          return;
        }
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(FinderFullSeekBarLayout paramFinderFullSeekBarLayout, Rect paramRect, View paramView, int paramInt, ViewGroup paramViewGroup) {}
    
    public final void run()
    {
      AppMethodBeat.i(287696);
      if (!this.AKG.AKv)
      {
        AppMethodBeat.o(287696);
        return;
      }
      Object localObject = FinderFullSeekBarLayout.a(this.AKG);
      if (localObject != null) {
        ((View)localObject).getGlobalVisibleRect(localRect);
      }
      localObject = com.tencent.mm.plugin.finder.storage.d.AjH;
      int i;
      float f1;
      float f2;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.dXx().aSr()).intValue() == 1)
      {
        i = localRect.left;
        localObject = localView;
        p.j(localObject, "tipsLayout");
        f1 = i - ((View)localObject).getWidth();
        localObject = this.AKG.getContext();
        p.j(localObject, "context");
        f1 -= ((Context)localObject).getResources().getDimension(b.d.Edge_A);
        localObject = com.tencent.mm.plugin.finder.storage.d.AjH;
        if (((Number)com.tencent.mm.plugin.finder.storage.d.dXx().aSr()).intValue() != 1) {
          break label501;
        }
        f2 = localRect.centerY();
        localObject = this.AKG.getContext();
        p.j(localObject, "context");
        f2 -= ((Context)localObject).getResources().getDimension(b.d.Edge_3A);
        label188:
        localObject = localView;
        p.j(localObject, "tipsLayout");
        ((View)localObject).setTranslationX(f1);
        localObject = localView;
        p.j(localObject, "tipsLayout");
        ((View)localObject).setTranslationY(f2);
        localObject = FinderFullSeekBarLayout.d(this.AKG);
        if (localObject == null) {
          break label567;
        }
      }
      label567:
      for (long l = ((BaseFinderFeed)localObject).mf();; l = 0L)
      {
        localObject = FinderFullSeekBarLayout.AKF;
        Integer localInteger = (Integer)FinderFullSeekBarLayout.egU().get(Long.valueOf(l));
        localObject = localInteger;
        if (localInteger == null) {
          localObject = Integer.valueOf(0);
        }
        p.j(localObject, "showGroupTipsSet[feedId] ?: 0");
        i = ((Integer)localObject).intValue();
        if (i == 0)
        {
          localObject = com.tencent.mm.kernel.h.aHG();
          p.j(localObject, "MMKernel.storage()");
          ((com.tencent.mm.kernel.f)localObject).aHp().set(ar.a.VxS, Integer.valueOf(j + 1));
          localObject = FinderFullSeekBarLayout.AKF;
          ((Map)FinderFullSeekBarLayout.egU()).put(Long.valueOf(l), Integer.valueOf(1));
          Log.i("Finder.FullSeekBarLayout", "[checkShowGroupLikeTips] record count=" + (j + 1));
        }
        localObject = FinderFullSeekBarLayout.AKF;
        ((Map)FinderFullSeekBarLayout.egU()).put(Long.valueOf(l), Integer.valueOf(i + 1));
        if (i < 3) {
          localView.animate().setStartDelay(0L).setDuration(200L).alpha(1.0F).setListener((Animator.AnimatorListener)new com.tencent.mm.plugin.finder.animation.a()
          {
            public final void onAnimationEnd(Animator paramAnonymousAnimator)
            {
              AppMethodBeat.i(269974);
              p.k(paramAnonymousAnimator, "animation");
              Log.i("Finder.FullSeekBarLayout", "[onAnimationEnd]");
              this.AKM.AKK.postDelayed((Runnable)new a(this), 5000L);
              AppMethodBeat.o(269974);
            }
            
            @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
            static final class a
              implements Runnable
            {
              a(FinderFullSeekBarLayout.e.1 param1) {}
              
              public final void run()
              {
                AppMethodBeat.i(287093);
                this.AKN.AKM.kJH.removeView(this.AKN.AKM.AKK);
                AppMethodBeat.o(287093);
              }
            }
          }).start();
        }
        AppMethodBeat.o(287696);
        return;
        f1 = localRect.centerX();
        localObject = localView;
        p.j(localObject, "tipsLayout");
        f1 -= ((View)localObject).getWidth() / 2.0F;
        break;
        label501:
        f2 = localRect.centerY();
        localObject = localView;
        p.j(localObject, "tipsLayout");
        float f3 = ((View)localObject).getHeight() / 2.0F;
        localObject = this.AKG.getContext();
        p.j(localObject, "context");
        f2 = f2 - f3 - ((Context)localObject).getResources().getDimension(b.d.Edge_8A);
        break label188;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<TextView>
  {
    f(FinderFullSeekBarLayout paramFinderFullSeekBarLayout)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout$dismissGroupLikeTips$1$1"})
  static final class g
    implements Runnable
  {
    g(View paramView, ViewGroup paramViewGroup) {}
    
    public final void run()
    {
      AppMethodBeat.i(280835);
      this.kJS.animate().cancel();
      this.AKO.removeView(this.kJS);
      AppMethodBeat.o(280835);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout$hideAwesomePrivateLayout$2", "Lcom/tencent/mm/plugin/finder/animation/AnimatorEndListener;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"})
  public static final class h
    extends com.tencent.mm.plugin.finder.animation.a
  {
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(274687);
      paramAnimator = FinderFullSeekBarLayout.a(this.AKG);
      if (paramAnimator != null)
      {
        paramAnimator.setVisibility(4);
        AppMethodBeat.o(274687);
        return;
      }
      AppMethodBeat.o(274687);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout$hideSeekLayout$1$1", "Lcom/tencent/mm/plugin/finder/animation/AnimatorEndListener;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"})
  public static final class i
    extends com.tencent.mm.plugin.finder.animation.a
  {
    i(View paramView) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(290873);
      this.kJS.setVisibility(4);
      this.kJS.setAlpha(1.0F);
      AppMethodBeat.o(290873);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class j
    implements ValueAnimator.AnimatorUpdateListener
  {
    j(FinderFullSeekBarLayout paramFinderFullSeekBarLayout) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(262227);
      paramValueAnimator = paramValueAnimator.getAnimatedValue("offset");
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new kotlin.t("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(262227);
        throw paramValueAnimator;
      }
      float f1 = ((Float)paramValueAnimator).floatValue();
      if (FinderFullSeekBarLayout.b(this.AKG)) {
        paramValueAnimator = FinderFullSeekBarLayout.AKF;
      }
      for (int i = FinderFullSeekBarLayout.egS();; i = FinderFullSeekBarLayout.egR())
      {
        paramValueAnimator = FinderFullSeekBarLayout.c(this.AKG).getLayoutParams();
        if (paramValueAnimator != null) {
          break;
        }
        paramValueAnimator = new kotlin.t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        AppMethodBeat.o(262227);
        throw paramValueAnimator;
        paramValueAnimator = FinderFullSeekBarLayout.AKF;
      }
      paramValueAnimator = (FrameLayout.LayoutParams)paramValueAnimator;
      float f2 = i;
      FinderFullSeekBarLayout.a locala = FinderFullSeekBarLayout.AKF;
      paramValueAnimator.bottomMargin = kotlin.h.a.dm(f2 * f1 + FinderFullSeekBarLayout.egT());
      FinderFullSeekBarLayout.c(this.AKG).requestLayout();
      AppMethodBeat.o(262227);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout$hideSeekLayout$3", "Lcom/tencent/mm/plugin/finder/animation/AnimatorEndListener;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"})
  public static final class k
    extends com.tencent.mm.plugin.finder.animation.a
  {
    k(View paramView) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(221143);
      paramAnimator = this.AKP;
      p.j(paramAnimator, "child");
      paramAnimator.setVisibility(4);
      paramAnimator = this.AKP;
      p.j(paramAnimator, "child");
      paramAnimator.setAlpha(1.0F);
      AppMethodBeat.o(221143);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class l
    extends q
    implements kotlin.g.a.a<Boolean>
  {
    public static final l AKQ;
    
    static
    {
      AppMethodBeat.i(282011);
      AKQ = new l();
      AppMethodBeat.o(282011);
    }
    
    l()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class m
    extends q
    implements kotlin.g.a.a<View>
  {
    m(FinderFullSeekBarLayout paramFinderFullSeekBarLayout)
    {
      super();
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout$longVideoLayout$2$1$1"})
    static final class a
      implements View.OnClickListener
    {
      a(FinderFullSeekBarLayout.m paramm) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(269573);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout$longVideoLayout$2$$special$$inlined$also$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        this.AKR.AKG.getOnLongVideoBtnClickListener().invoke();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout$longVideoLayout$2$$special$$inlined$also$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(269573);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class n
    extends q
    implements kotlin.g.a.a<kotlin.x>
  {
    public static final n AKS;
    
    static
    {
      AppMethodBeat.i(265326);
      AKS = new n();
      AppMethodBeat.o(265326);
    }
    
    n()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class o
    extends q
    implements kotlin.g.a.a<Boolean>
  {
    public static final o AKT;
    
    static
    {
      AppMethodBeat.i(270666);
      AKT = new o();
      AppMethodBeat.o(270666);
    }
    
    o()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class p
    extends q
    implements kotlin.g.a.a<Boolean>
  {
    public static final p AKU;
    
    static
    {
      AppMethodBeat.i(280614);
      AKU = new p();
      AppMethodBeat.o(280614);
    }
    
    p()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class q
    extends q
    implements kotlin.g.a.a<kotlin.x>
  {
    public static final q AKV;
    
    static
    {
      AppMethodBeat.i(279930);
      AKV = new q();
      AppMethodBeat.o(279930);
    }
    
    q()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class r
    implements Runnable
  {
    r(FinderFullSeekBarLayout paramFinderFullSeekBarLayout) {}
    
    public final void run()
    {
      AppMethodBeat.i(290469);
      this.AKG.aGh("onStopTrackingTouch");
      FinderFullSeekBarLayout.a(this.AKG, false);
      AppMethodBeat.o(290469);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class s
    extends q
    implements kotlin.g.a.a<WeImageView>
  {
    s(FinderFullSeekBarLayout paramFinderFullSeekBarLayout)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "invoke"})
  static final class t
    extends q
    implements kotlin.g.a.a<WeImageView>
  {
    t(FinderFullSeekBarLayout paramFinderFullSeekBarLayout)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "kotlin.jvm.PlatformType", "view", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "resource", "Landroid/graphics/Bitmap;", "onImageLoadComplete", "com/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout$refreshAwesome$1$1"})
  static final class u<T, R>
    implements e<w, Bitmap>
  {
    u(WeImageView paramWeImageView, FinderFullSeekBarLayout paramFinderFullSeekBarLayout, boolean paramBoolean, String paramString) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "kotlin.jvm.PlatformType", "view", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "resource", "Landroid/graphics/Bitmap;", "onImageLoadComplete", "com/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout$refreshAwesome$1$2"})
  static final class v<T, R>
    implements e<w, Bitmap>
  {
    v(WeImageView paramWeImageView, FinderFullSeekBarLayout paramFinderFullSeekBarLayout, boolean paramBoolean, String paramString) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/SeekBar;", "kotlin.jvm.PlatformType", "invoke"})
  static final class w
    extends q
    implements kotlin.g.a.a<SeekBar>
  {
    w(FinderFullSeekBarLayout paramFinderFullSeekBarLayout)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", "invoke"})
  static final class x
    extends q
    implements kotlin.g.a.a<ViewGroup>
  {
    x(FinderFullSeekBarLayout paramFinderFullSeekBarLayout)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout$showSeekLayout$2$1", "Lcom/tencent/mm/plugin/finder/animation/AnimatorEndListener;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"})
  public static final class y
    extends com.tencent.mm.plugin.finder.animation.a
  {
    y(FinderFullSeekBarLayout paramFinderFullSeekBarLayout) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(271037);
      BaseFinderFeed localBaseFinderFeed = FinderFullSeekBarLayout.d(this.AKG);
      if (localBaseFinderFeed != null)
      {
        paramAnimator = aj.Bnu;
        paramAnimator = this.AKG.getContext();
        p.j(paramAnimator, "context");
        paramAnimator = aj.a.fZ(paramAnimator);
        if (paramAnimator != null) {}
        for (paramAnimator = paramAnimator.ekY();; paramAnimator = null)
        {
          am localam = am.zZN;
          am.a(paramAnimator, "pause_by_icon", true, localBaseFinderFeed.mf());
          localam = am.zZN;
          am.a(paramAnimator, "private_like", true, localBaseFinderFeed.mf());
          AppMethodBeat.o(271037);
          return;
        }
      }
      AppMethodBeat.o(271037);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class z
    implements ValueAnimator.AnimatorUpdateListener
  {
    z(FinderFullSeekBarLayout paramFinderFullSeekBarLayout) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(289324);
      paramValueAnimator = paramValueAnimator.getAnimatedValue("offset");
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new kotlin.t("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(289324);
        throw paramValueAnimator;
      }
      float f1 = ((Float)paramValueAnimator).floatValue();
      if (FinderFullSeekBarLayout.b(this.AKG)) {
        paramValueAnimator = FinderFullSeekBarLayout.AKF;
      }
      for (int i = FinderFullSeekBarLayout.egS();; i = FinderFullSeekBarLayout.egR())
      {
        paramValueAnimator = FinderFullSeekBarLayout.c(this.AKG).getLayoutParams();
        if (paramValueAnimator != null) {
          break;
        }
        paramValueAnimator = new kotlin.t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        AppMethodBeat.o(289324);
        throw paramValueAnimator;
        paramValueAnimator = FinderFullSeekBarLayout.AKF;
      }
      paramValueAnimator = (FrameLayout.LayoutParams)paramValueAnimator;
      float f2 = i;
      FinderFullSeekBarLayout.a locala = FinderFullSeekBarLayout.AKF;
      paramValueAnimator.bottomMargin = kotlin.h.a.dm(f2 * f1 + FinderFullSeekBarLayout.egT());
      FinderFullSeekBarLayout.c(this.AKG).requestLayout();
      AppMethodBeat.o(289324);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.FinderFullSeekBarLayout
 * JD-Core Version:    0.7.0.1
 */