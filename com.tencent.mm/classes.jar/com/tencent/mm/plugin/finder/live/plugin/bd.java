package com.tencent.mm.plugin.finder.live.plugin;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.c.b.b;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.live.model.ah;
import com.tencent.mm.plugin.finder.live.util.p.a;
import com.tencent.mm.plugin.finder.live.util.p.b;
import com.tencent.mm.plugin.finder.live.util.p.c;
import com.tencent.mm.plugin.finder.live.view.FinderLiveGiftTextView;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.f;
import com.tencent.mm.protocal.protobuf.axu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandler.Callback;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashMap<Ljava.lang.String;Landroid.graphics.Rect;>;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.a.ae;
import kotlin.a.j;
import kotlin.g.b.aa.f;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;
import org.libpag.PAGView;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftQueuePlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue$GiftAddingObserver;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "iGiftQueue", "Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue;", "outerSpaceParent", "isVisitor", "", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue;Landroid/view/ViewGroup;Z)V", "NICK_NAME_LENGTH", "", "bulletInAnimatorMap", "", "Landroid/animation/ObjectAnimator;", "bulletInfoMap", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftQueuePlugin$BulletShowingInfo;", "bulletOutAnimatorMap", "comboIdBackToLiveMap", "", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftQueuePlugin$ComboIdBackToLiveInfo;", "comboIdList", "Ljava/util/LinkedList;", "containerFake", "Landroid/widget/RelativeLayout;", "containerOne", "containerThree", "containerTwo", "initialMapSize", "outerSpaceMap", "Ljava/util/concurrent/ConcurrentHashMap;", "preciousGiftBulletOutHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "timer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "adjustContainerLocation", "", "container", "rect", "Landroid/graphics/Rect;", "micUser", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveLinkMicUser;", "adjustGiftfromUserMargin", "fromUserTv", "Landroid/widget/TextView;", "haveSImageSpan", "calculatePreciousGiftRemainingTime", "", "entry", "", "canClearScreen", "checkIfNeedPreserveShowingPreciousGift", "info", "checkIfOuterSpacePreciousGiftForceReplace", "checkIfPreciousGiftTimeOver", "checkIfSelfPreciousGiftForceReplace", "checkInfoFromComboIdBackToLiveMap", "comboId", "checkStatusWhenMaximizeWindow", "cloneToFakeContainer", "createBulletInAnimator", "target", "isOuterSpace", "createBulletOutAnimator", "disableContainer", "enableContainer", "enoughSpaceForGiftText", "bulletShowingInfo", "nickname", "userLevelSpan", "Landroid/text/style/ImageSpan;", "enoughSpaceForRelaunch", "findCurrentShowingPreciousGift", "getDisplayNickName", "", "contact", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "textView", "getOuterSpaceContainer", "parent", "launchBulletInAnimation", "space", "giftShowInfo", "Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue$GiftShowInfo;", "matchBackupGiftType", "mount", "onGiftAdding", "giftType", "Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue$GiftType;", "onMicUserChanged", "micUserMap", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "isPkAnchor", "pollNextGiftShowInfo", "registerOuterSpace", "targetUserName", "direction", "outSpaceWidth", "relaunchBulletInAnimation", "replaceBullet", "originSpace", "showFullScreenPreciousGift", "isForceReplace", "textViewShowLines", "width", "takePlaceWidth", "targetTv", "msg", "tryToAdjustGiftName", "sameValue", "unMount", "unregisterOuterSpace", "updateBulletShowingInfo", "updatePreciousGiftTotalShowingTime", "giftId", "diffCnt", "BulletFadeInEvaluator", "BulletShowingInfo", "BulletViewHolder", "ComboIdBackToLiveInfo", "Companion", "plugin-finder_release"})
public final class bd
  extends d
  implements p.a
{
  private static final int yrd;
  private static final int yre;
  private static final float yrf;
  private static final float yrg;
  private static final float yrh;
  private static final float yri;
  private static final int yrj;
  private static final int yrk;
  private static final int yrl;
  private static final boolean yrm;
  public static final e yrn;
  private final com.tencent.mm.live.c.b kCL;
  private final MTimerHandler timer;
  private final int yqN;
  private final RelativeLayout yqO;
  private final RelativeLayout yqP;
  private final RelativeLayout yqQ;
  private final RelativeLayout yqR;
  private final int yqS;
  private final Map<ViewGroup, b> yqT;
  private final Map<ViewGroup, ObjectAnimator> yqU;
  private final Map<ViewGroup, ObjectAnimator> yqV;
  private final Map<String, d> yqW;
  private final LinkedList<String> yqX;
  private final ConcurrentHashMap<String, ViewGroup> yqY;
  private final MMHandler yqZ;
  private final com.tencent.mm.plugin.finder.live.util.p yra;
  private final ViewGroup yrb;
  private final boolean yrc;
  
  static
  {
    AppMethodBeat.i(265828);
    yrn = new e((byte)0);
    Object localObject = com.tencent.c.a.a.a.a.a.Zlt;
    yrd = ((Number)com.tencent.c.a.a.a.a.a.ilQ().aSr()).intValue() * 1000;
    yre = 500 / (yrd + 500);
    yrf = MMApplicationContext.getResources().getDimension(b.d.Edge_2A);
    float f = MMApplicationContext.getResources().getDimension(b.d.Edge_5A);
    yrg = f;
    yrh = f;
    yri = MMApplicationContext.getResources().getDimension(b.d.Edge_5A);
    yrj = MMApplicationContext.getResources().getDimensionPixelOffset(b.d.Edge_1_5_A);
    yrk = com.tencent.mm.view.d.e(MMApplicationContext.getContext(), 3.0F);
    yrl = (int)MMApplicationContext.getResources().getDimension(b.d.Edge_23A);
    localObject = com.tencent.c.a.a.a.a.a.Zlt;
    if (((Number)com.tencent.c.a.a.a.a.a.ilq().aSr()).intValue() == 0)
    {
      localObject = ah.yhC;
      if (ah.dzB() == null) {}
    }
    for (boolean bool = true;; bool = false)
    {
      yrm = bool;
      AppMethodBeat.o(265828);
      return;
    }
  }
  
  public bd(ViewGroup paramViewGroup1, com.tencent.mm.live.c.b paramb, com.tencent.mm.plugin.finder.live.util.p paramp, ViewGroup paramViewGroup2, boolean paramBoolean)
  {
    super(paramViewGroup1, paramb);
    AppMethodBeat.i(265827);
    this.kCL = paramb;
    this.yra = paramp;
    this.yrb = paramViewGroup2;
    this.yrc = paramBoolean;
    paramb = com.tencent.c.a.a.a.a.a.Zlt;
    this.yqN = ((Number)com.tencent.c.a.a.a.a.a.ilR().aSr()).intValue();
    this.yqX = new LinkedList();
    this.yqY = new ConcurrentHashMap();
    this.timer = new MTimerHandler("FinderLiveGiftQueuePlugin::Timer", (MTimerHandler.CallBack)new p(this), false);
    paramb = paramViewGroup1.findViewById(b.f.finder_live_gift_queue_bullet_one);
    kotlin.g.b.p.j(paramb, "root.findViewById(R.id.f…ve_gift_queue_bullet_one)");
    this.yqO = ((RelativeLayout)paramb);
    paramb = paramViewGroup1.findViewById(b.f.finder_live_gift_queue_bullet_two);
    kotlin.g.b.p.j(paramb, "root.findViewById(R.id.f…ve_gift_queue_bullet_two)");
    this.yqP = ((RelativeLayout)paramb);
    paramb = paramViewGroup1.findViewById(b.f.finder_live_gift_queue_bullet_three);
    kotlin.g.b.p.j(paramb, "root.findViewById(R.id.f…_gift_queue_bullet_three)");
    this.yqQ = ((RelativeLayout)paramb);
    paramViewGroup1 = LayoutInflater.from(paramViewGroup1.getContext()).inflate(b.g.finder_live_gift_bullut_ui, paramViewGroup1, false);
    if (paramViewGroup1 == null)
    {
      paramViewGroup1 = new t("null cannot be cast to non-null type android.widget.RelativeLayout");
      AppMethodBeat.o(265827);
      throw paramViewGroup1;
    }
    this.yqR = ((RelativeLayout)paramViewGroup1);
    paramViewGroup1 = Collections.synchronizedMap((Map)new LinkedHashMap(3));
    kotlin.g.b.p.j(paramViewGroup1, "Collections.synchronizedMap(LinkedHashMap(3))");
    this.yqT = paramViewGroup1;
    this.yqT.put(this.yqO, new b((ViewGroup)this.yqO, 0, this.yrc, false, false, 0, 56));
    this.yqT.put(this.yqP, new b((ViewGroup)this.yqP, 1, this.yrc, false, false, 0, 56));
    this.yqT.put(this.yqQ, new b((ViewGroup)this.yqQ, 2, this.yrc, true, false, 0, 48));
    paramViewGroup1 = this.yqT;
    paramb = this.yqR;
    paramp = new b((ViewGroup)this.yqR, 1000, this.yrc, false, false, 0, 56);
    paramp.yrF = true;
    paramp.yrs.getAndSet(true);
    paramp.aCo("");
    paramViewGroup1.put(paramb, paramp);
    this.yqS = this.yqT.size();
    this.yqU = ((Map)new ConcurrentHashMap(3));
    this.yqU.put(this.yqO, e((ViewGroup)this.yqO, false));
    this.yqU.put(this.yqP, e((ViewGroup)this.yqP, false));
    this.yqU.put(this.yqQ, e((ViewGroup)this.yqQ, false));
    this.yqV = ((Map)new ConcurrentHashMap(3));
    this.yqV.put(this.yqO, u((ViewGroup)this.yqO));
    this.yqV.put(this.yqP, u((ViewGroup)this.yqP));
    this.yqV.put(this.yqQ, u((ViewGroup)this.yqQ));
    paramViewGroup1 = Collections.synchronizedMap((Map)new LinkedHashMap());
    kotlin.g.b.p.j(paramViewGroup1, "Collections.synchronizedMap(LinkedHashMap())");
    this.yqW = paramViewGroup1;
    paramViewGroup1 = ((Iterable)this.yqT.values()).iterator();
    while (paramViewGroup1.hasNext())
    {
      paramb = (b)paramViewGroup1.next();
      paramp = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      com.tencent.mm.plugin.finder.live.utils.a.q((TextView)paramb.yry.yrQ);
    }
    this.yqZ = new MMHandler(Looper.getMainLooper(), (MMHandler.Callback)new MMHandler.Callback()
    {
      public final boolean handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(283696);
        Object localObject = paramAnonymousMessage.obj;
        paramAnonymousMessage = localObject;
        if (!(localObject instanceof ViewGroup)) {
          paramAnonymousMessage = null;
        }
        paramAnonymousMessage = (ViewGroup)paramAnonymousMessage;
        paramAnonymousMessage = (ObjectAnimator)bd.e(this.yro).get(paramAnonymousMessage);
        if ((paramAnonymousMessage != null) && (!paramAnonymousMessage.isRunning())) {
          paramAnonymousMessage.start();
        }
        AppMethodBeat.o(283696);
        return true;
      }
    });
    this.yqZ.setLogging(false);
    if (yrm)
    {
      paramViewGroup1 = this.yqO;
      if (paramViewGroup1 != null) {
        paramViewGroup1.setVisibility(8);
      }
      paramViewGroup1 = this.yqP;
      if (paramViewGroup1 != null) {
        paramViewGroup1.setVisibility(8);
      }
      paramViewGroup1 = this.yqQ;
      if (paramViewGroup1 != null) {
        paramViewGroup1.setVisibility(8);
      }
    }
    Log.i("Finder.FinderLiveGiftQueuePlugin", "ENABLE_TEST:" + yrm);
    AppMethodBeat.o(265827);
  }
  
  private static int a(int paramInt1, int paramInt2, TextView paramTextView, String paramString)
  {
    int j = 0;
    AppMethodBeat.i(265802);
    int k = paramTextView.getPaddingLeft();
    int m = paramTextView.getPaddingRight();
    ViewParent localViewParent = paramTextView.getParent();
    Object localObject = localViewParent;
    if (!(localViewParent instanceof ViewGroup)) {
      localObject = null;
    }
    localObject = (ViewGroup)localObject;
    if (localObject != null) {}
    for (int i = ((ViewGroup)localObject).getPaddingLeft();; i = 0)
    {
      localViewParent = paramTextView.getParent();
      localObject = localViewParent;
      if (!(localViewParent instanceof ViewGroup)) {
        localObject = null;
      }
      localObject = (ViewGroup)localObject;
      if (localObject != null) {
        j = ((ViewGroup)localObject).getPaddingRight();
      }
      paramInt1 = paramInt1 - paramInt2 - k - m - i - j - 6;
      if (paramInt1 <= 0) {
        break;
      }
      paramInt1 = new StaticLayout((CharSequence)paramString, paramTextView.getPaint(), paramInt1, Layout.Alignment.ALIGN_NORMAL, 1.0F, 1.0F, true).getLineCount();
      AppMethodBeat.o(265802);
      return paramInt1;
    }
    AppMethodBeat.o(265802);
    return 2147483647;
  }
  
  private final ViewGroup a(Rect paramRect, ViewGroup paramViewGroup, com.tencent.mm.plugin.finder.live.viewmodel.data.h paramh)
  {
    AppMethodBeat.i(265823);
    Object localObject = LayoutInflater.from(paramViewGroup.getContext()).inflate(b.g.finder_live_gift_bullut_ui, paramViewGroup, false);
    if (localObject == null)
    {
      paramRect = new t("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(265823);
      throw paramRect;
    }
    localObject = (ViewGroup)localObject;
    paramViewGroup.addView((View)localObject);
    a((ViewGroup)localObject, paramRect, paramh);
    ((ViewGroup)localObject).setVisibility(8);
    AppMethodBeat.o(265823);
    return localObject;
  }
  
  private final void a(ViewGroup paramViewGroup, Rect paramRect, com.tencent.mm.plugin.finder.live.viewmodel.data.h paramh)
  {
    AppMethodBeat.i(265824);
    if (paramViewGroup == null)
    {
      AppMethodBeat.o(265824);
      return;
    }
    Object localObject = paramViewGroup.getLayoutParams();
    if (localObject == null)
    {
      paramViewGroup = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(265824);
      throw paramViewGroup;
    }
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localObject;
    localMarginLayoutParams.topMargin = ((int)(paramRect.bottom - yrh));
    String str;
    if ((paramh == null) || (paramh.ktS != 2)) {
      if ((paramh != null) && (paramh.ktS == 1))
      {
        str = paramh.ktR;
        localObject = getBuContext();
        if (localObject == null) {
          break label216;
        }
        localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)((com.tencent.mm.plugin.finder.live.model.context.a)localObject).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
        if (localObject == null) {
          break label216;
        }
      }
    }
    label216:
    for (localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).dGU();; localObject = null)
    {
      if (!Util.isEqual(str, (String)localObject))
      {
        if ((paramh == null) || (paramh.zeF != true)) {}
      }
      else {
        localMarginLayoutParams.topMargin -= (int)yri;
      }
      int i = paramRect.left;
      paramViewGroup = paramViewGroup.getContext();
      kotlin.g.b.p.j(paramViewGroup, "container.context");
      localMarginLayoutParams.setMarginStart(i + (int)paramViewGroup.getResources().getDimension(b.d.Edge_A));
      AppMethodBeat.o(265824);
      return;
    }
  }
  
  private final void a(final ViewGroup paramViewGroup, final p.b paramb)
  {
    AppMethodBeat.i(265797);
    if ((paramViewGroup == null) || (paramb == null))
    {
      AppMethodBeat.o(265797);
      return;
    }
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new n(this, paramViewGroup, paramb));
    AppMethodBeat.o(265797);
  }
  
  private final void a(b paramb)
  {
    AppMethodBeat.i(265825);
    if (paramb == null)
    {
      AppMethodBeat.o(265825);
      return;
    }
    if ((paramb.yrq.get()) && (paramb.yrs.get()) && (!paramb.yrF)) {
      b(paramb);
    }
    AppMethodBeat.o(265825);
  }
  
  private final void a(p.b paramb)
  {
    Object localObject3 = null;
    AppMethodBeat.i(265805);
    Object localObject1;
    Object localObject4;
    Object localObject2;
    if (paramb != null)
    {
      localObject1 = paramb.yQC;
      if (localObject1 != null)
      {
        localObject1 = ((axu)localObject1).SKd;
        localObject4 = new StringBuilder("showFullScreenPreciousGift giftId:").append((String)localObject1).append(" targetUsername:");
        if (paramb == null) {
          break label205;
        }
        localObject2 = paramb.yrD;
        label58:
        localObject4 = ((StringBuilder)localObject4).append((String)localObject2).append(" curPkUser:");
        localObject2 = ((f)business(f.class)).zhl;
        if (localObject2 == null) {
          break label210;
        }
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject2).username;
        label95:
        Log.i("Finder.FinderLiveGiftQueuePlugin", (String)localObject2);
        if (paramb == null) {
          break label215;
        }
      }
    }
    label205:
    label210:
    label215:
    for (paramb = paramb.yrD;; paramb = null)
    {
      localObject4 = ((f)business(f.class)).zhl;
      localObject2 = localObject3;
      if (localObject4 != null) {
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject4).username;
      }
      if (!Util.isEqual(paramb, (String)localObject2))
      {
        paramb = new Bundle();
        paramb.putString("PARAM_LIVE_GIFT_INFO", (String)localObject1);
        paramb.putBoolean("PARAM_LIVE_GIFT_IS_FORCE_REPLACE", true);
        this.kCL.statusChange(b.c.kAc, paramb);
      }
      AppMethodBeat.o(265805);
      return;
      localObject1 = null;
      break;
      localObject2 = null;
      break label58;
      localObject2 = null;
      break label95;
    }
  }
  
  private static void a(String paramString, b paramb, int paramInt)
  {
    AppMethodBeat.i(265809);
    Object localObject = com.tencent.c.a.a.a.a.a.Zlt;
    long l2 = ((Number)com.tencent.c.a.a.a.a.a.ilU().aSr()).longValue();
    localObject = com.tencent.mm.plugin.finder.live.model.m.yfw;
    localObject = (Long)com.tencent.mm.plugin.finder.live.model.m.dyv().get(paramString);
    if (localObject != null) {}
    for (long l1 = ((Long)localObject).longValue() / 1000L;; l1 = l2)
    {
      long l3 = l1;
      if (0L == l1)
      {
        localObject = new StringBuilder("updatePreciousGiftTotalShowingTime: giftFullPagDurationMap value = ");
        com.tencent.mm.plugin.finder.live.model.m localm = com.tencent.mm.plugin.finder.live.model.m.yfw;
        Log.i("Finder.FinderLiveGiftQueuePlugin", (Long)com.tencent.mm.plugin.finder.live.model.m.dyv().get(paramString));
        l3 = l2;
      }
      paramb.yrA += ((float)l3 * 0.9F * paramInt);
      Log.i("Finder.FinderLiveGiftQueuePlugin", "updatePreciousGiftTotalShowingTime: giftId=" + paramString + ',' + " durationMs=" + l3 + ", totalShowingTime=" + paramb.yrA);
      AppMethodBeat.o(265809);
      return;
    }
  }
  
  private final void b(final ViewGroup paramViewGroup, final p.b paramb)
  {
    AppMethodBeat.i(265798);
    if ((paramViewGroup == null) || (paramb == null))
    {
      AppMethodBeat.o(265798);
      return;
    }
    Log.i("Finder.FinderLiveGiftQueuePlugin", "replaceBullet, originSpace BulletShowingInfo=" + (b)this.yqT.get(paramViewGroup) + ", giftShowInfo=" + paramb);
    final aa.f localf = new aa.f();
    localf.aaBC = paramViewGroup;
    Object localObject2 = paramb.yrD;
    Object localObject1 = (b)this.yqT.get(paramViewGroup);
    if (localObject1 != null) {
      localObject1 = ((b)localObject1).yrD;
    }
    while (!((String)localObject2).equals(localObject1))
    {
      localObject2 = this.yqT;
      localObject1 = new LinkedHashMap();
      localObject2 = ((Map)localObject2).entrySet().iterator();
      for (;;)
      {
        if (((Iterator)localObject2).hasNext())
        {
          localObject3 = (Map.Entry)((Iterator)localObject2).next();
          if (((b)((Map.Entry)localObject3).getValue()).yrD.equals(paramb.yrD))
          {
            ((LinkedHashMap)localObject1).put(((Map.Entry)localObject3).getKey(), ((Map.Entry)localObject3).getValue());
            continue;
            localObject1 = null;
            break;
          }
        }
      }
      localObject2 = (Map)localObject1;
      localObject1 = (Collection)new ArrayList(((Map)localObject2).size());
      localObject2 = ((Map)localObject2).entrySet().iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((Collection)localObject1).add((ViewGroup)((Map.Entry)((Iterator)localObject2).next()).getKey());
      }
      localObject1 = (List)localObject1;
      if (((List)localObject1).isEmpty())
      {
        AppMethodBeat.o(265798);
        return;
      }
      localf.aaBC = ((ViewGroup)((List)localObject1).get(0));
    }
    if ((kotlin.g.b.p.h((ViewGroup)localf.aaBC, paramViewGroup) ^ true))
    {
      Log.i("Finder.FinderLiveGiftQueuePlugin", "replaceBullet, targetSpace BulletShowingInfo=" + (b)this.yqT.get((ViewGroup)localf.aaBC));
      localObject1 = (b)this.yqT.get(paramViewGroup);
      if (localObject1 != null) {
        ((b)localObject1).reset();
      }
    }
    localObject1 = (b)this.yqT.get((ViewGroup)localf.aaBC);
    if (localObject1 != null) {
      ((b)localObject1).reset();
    }
    localObject1 = (b)this.yqT.get((ViewGroup)localf.aaBC);
    if (localObject1 != null)
    {
      localObject1 = ((b)localObject1).yrq;
      if (localObject1 != null) {
        ((AtomicBoolean)localObject1).getAndSet(true);
      }
    }
    localObject1 = (b)this.yqT.get((ViewGroup)localf.aaBC);
    if (localObject1 != null)
    {
      localObject1 = ((b)localObject1).yrs;
      if (localObject1 != null) {
        ((AtomicBoolean)localObject1).getAndSet(paramb.yQE);
      }
    }
    Object localObject3 = (b)this.yqT.get((ViewGroup)localf.aaBC);
    if (localObject3 != null)
    {
      localObject2 = paramb.yru;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      ((b)localObject3).aCn((String)localObject1);
    }
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new o(this, localf, paramViewGroup, paramb));
    AppMethodBeat.o(265798);
  }
  
  private static void b(TextView paramTextView, boolean paramBoolean)
  {
    AppMethodBeat.i(265799);
    ViewGroup.LayoutParams localLayoutParams = paramTextView.getLayoutParams();
    paramTextView = localLayoutParams;
    if (!(localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      paramTextView = null;
    }
    paramTextView = (ViewGroup.MarginLayoutParams)paramTextView;
    if (paramTextView != null)
    {
      if (paramBoolean) {}
      for (int i = yrk;; i = yrj)
      {
        paramTextView.leftMargin = i;
        AppMethodBeat.o(265799);
        return;
      }
    }
    AppMethodBeat.o(265799);
  }
  
  private final void b(b paramb)
  {
    AppMethodBeat.i(265826);
    if (!paramb.yrs.get())
    {
      AppMethodBeat.o(265826);
      return;
    }
    Log.i("Finder.FinderLiveGiftQueuePlugin", "cloneToFakeContainer: origin info = ".concat(String.valueOf(paramb)));
    Object localObject = (b)this.yqT.get(this.yqR);
    if (localObject != null)
    {
      ((b)localObject).yrA = paramb.yrA;
      ((b)localObject).yrB = paramb.yrB;
      ((b)localObject).yrq.getAndSet(true);
      if (this.timer.stopped())
      {
        localObject = j.z((Iterable)this.yqT.entrySet()).iterator();
        do
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          paramb = ((Iterator)localObject).next();
        } while (!kotlin.g.b.p.h((ViewGroup)((Map.Entry)paramb).getKey(), this.yqR));
      }
      for (;;)
      {
        h((Map.Entry)paramb);
        AppMethodBeat.o(265826);
        return;
        paramb = null;
      }
    }
    AppMethodBeat.o(265826);
  }
  
  private final void dBH()
  {
    int i;
    Object localObject4;
    Object localObject5;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(265796);
        Object localObject1 = dBI();
        if (localObject1 != null)
        {
          i = 1;
          if ((i != 0) && (localObject1 != null) && (!((b)((Map.Entry)localObject1).getValue()).yrt)) {
            break label143;
          }
          localObject4 = this.yqT;
          localObject1 = new LinkedHashMap();
          localObject4 = ((Map)localObject4).entrySet().iterator();
          if (!((Iterator)localObject4).hasNext()) {
            break;
          }
          localObject5 = (Map.Entry)((Iterator)localObject4).next();
          if (!((b)((Map.Entry)localObject5).getValue()).yrE.get()) {
            continue;
          }
          ((LinkedHashMap)localObject1).put(((Map.Entry)localObject5).getKey(), ((Map.Entry)localObject5).getValue());
          continue;
        }
        i = 0;
      }
      finally {}
      continue;
      label143:
      localObject4 = this.yra.dEu();
      if ((localObject4 != null) && (((p.c)localObject4).compareTo((Enum)p.c.yQI) < 0)) {
        b((ViewGroup)localObject2.getKey(), this.yra.dEv());
      }
    }
    Iterator localIterator = ((Map)localObject2).entrySet().iterator();
    label320:
    boolean bool;
    label332:
    Object localObject3;
    label456:
    label476:
    label504:
    Object localObject6;
    b localb;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localObject4 = (Map.Entry)localIterator.next();
        Log.i("Finder.FinderLiveGiftQueuePlugin", "pollNextGiftShowInfo: index = " + ((b)((Map.Entry)localObject4).getValue()).index + " \n current bulletInfo = " + this.yqT + " \n current gift queue size: " + this.yra.size());
        if (!this.yra.hasNext())
        {
          AppMethodBeat.o(265796);
          return;
        }
        if (dBI() == null) {
          break label1129;
        }
        bool = true;
        Log.i("Finder.FinderLiveGiftQueuePlugin", "pollNextGiftShowInfo: isPreciousGiftShowing = ".concat(String.valueOf(bool)));
        if ((this.yqY.containsValue(((Map.Entry)localObject4).getKey())) && (!bool))
        {
          if ((localObject4 == null) || (!((b)((Map.Entry)localObject4).getValue()).yrq.get()) || (((b)((Map.Entry)localObject4).getValue()).yrt) || (((b)((Map.Entry)localObject4).getValue()).yrs.get()))
          {
            localObject5 = new StringBuilder("checkIfOuterSpacePreciousGiftForceReplace: entry fail, ");
            if (localObject4 == null) {
              break label1134;
            }
            localObject3 = (b)((Map.Entry)localObject4).getValue();
            Log.i("Finder.FinderLiveGiftQueuePlugin", localObject3);
            i = 0;
            break label1122;
          }
        }
        else
        {
          localObject5 = this.yqT;
          localObject3 = new LinkedHashMap();
          localObject5 = ((Map)localObject5).entrySet().iterator();
        }
        while (((Iterator)localObject5).hasNext())
        {
          localObject6 = (Map.Entry)((Iterator)localObject5).next();
          localb = (b)((Map.Entry)localObject6).getValue();
          if ((!localb.yrE.get()) || (!localb.yrq.get())) {
            break label1139;
          }
          i = 1;
          label562:
          if (i == 0) {
            break label1142;
          }
          ((LinkedHashMap)localObject3).put(((Map.Entry)localObject6).getKey(), ((Map.Entry)localObject6).getValue());
          continue;
          localObject3 = this.yra.aCN(((b)((Map.Entry)localObject4).getValue()).yrD);
          if (localObject3 == null)
          {
            i = 0;
            break label1122;
          }
          if (!((p.b)localObject3).yQE)
          {
            i = 0;
            break label1122;
          }
          b((ViewGroup)((Map.Entry)localObject4).getKey(), (p.b)localObject3);
          this.yra.c((p.b)localObject3);
          i = 1;
          break label1122;
        }
        localObject3 = ((Map)localObject3).entrySet().iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject5 = (Map.Entry)((Iterator)localObject3).next();
          localObject6 = this.yra.aCP(((b)((Map.Entry)localObject5).getValue()).yru);
          if (localObject6 != null) {
            a((ViewGroup)((Map.Entry)localObject5).getKey(), (p.b)localObject6);
          }
        }
        if (!((b)((Map.Entry)localObject4).getValue()).yrq.get()) {
          if (bool)
          {
            localObject3 = this.yra.aCM(((b)((Map.Entry)localObject4).getValue()).yrD);
            label792:
            if (localObject3 == null) {
              break label900;
            }
            Log.i("Finder.FinderLiveGiftQueuePlugin", "pollNextGiftShowInfo: giftShowInfo = ".concat(String.valueOf(localObject3)));
            if (((b)((Map.Entry)localObject4).getValue()).yrz)
            {
              if (bool) {
                continue;
              }
              if (localObject3 != null) {
                break label902;
              }
              bool = false;
              break label1144;
            }
          }
        }
      }
    }
    for (;;)
    {
      localObject6 = (ViewGroup)((Map.Entry)localObject4).getKey();
      if ((localObject6 == null) || (localObject3 == null)) {}
      for (;;)
      {
        this.yra.c((p.b)localObject3);
        break;
        localObject3 = this.yra.aCN(((b)((Map.Entry)localObject4).getValue()).yrD);
        break label792;
        label900:
        break;
        label902:
        bool = ((p.b)localObject3).yQE;
        break label1144;
        localObject4 = (b)this.yqT.get(localObject6);
        if (localObject4 != null)
        {
          localObject4 = ((b)localObject4).yrq;
          if ((localObject4 != null) && (true == ((AtomicBoolean)localObject4).get()))
          {
            a((ViewGroup)localObject6, (p.b)localObject3);
            continue;
          }
        }
        localObject4 = (b)this.yqT.get(localObject6);
        if (localObject4 != null)
        {
          localObject4 = ((b)localObject4).yrq;
          if (localObject4 != null) {
            ((AtomicBoolean)localObject4).getAndSet(true);
          }
        }
        localObject4 = (b)this.yqT.get(localObject6);
        if (localObject4 != null)
        {
          localObject4 = ((b)localObject4).yrs;
          if (localObject4 != null) {
            ((AtomicBoolean)localObject4).getAndSet(((p.b)localObject3).yQE);
          }
        }
        localb = (b)this.yqT.get(localObject6);
        if (localb != null)
        {
          localObject5 = ((p.b)localObject3).yru;
          localObject4 = localObject5;
          if (localObject5 == null) {
            localObject4 = "";
          }
          localb.aCn((String)localObject4);
        }
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new l(this, (ViewGroup)localObject6, (p.b)localObject3));
      }
      AppMethodBeat.o(265796);
      break label320;
      label1122:
      if (i != 0) {
        break;
      }
      break label476;
      label1129:
      bool = false;
      break label332;
      label1134:
      localObject3 = null;
      break label456;
      label1139:
      i = 0;
      break label562;
      label1142:
      break label504;
      label1144:
      if (!bool) {
        break;
      }
    }
  }
  
  private final Map.Entry<ViewGroup, b> dBI()
  {
    AppMethodBeat.i(265810);
    Object localObject = kotlin.m.i.c(kotlin.m.i.a(ae.cD(this.yqT), (kotlin.g.a.b)k.yrY));
    if (!((Collection)localObject).isEmpty()) {}
    for (int i = 1; i != 0; i = 0)
    {
      localObject = (Map.Entry)((List)localObject).get(0);
      AppMethodBeat.o(265810);
      return localObject;
    }
    AppMethodBeat.o(265810);
    return null;
  }
  
  private final ObjectAnimator e(final ViewGroup paramViewGroup, final boolean paramBoolean)
  {
    AppMethodBeat.i(265793);
    ObjectAnimator localObjectAnimator;
    if (paramBoolean)
    {
      localObjectAnimator = ObjectAnimator.ofFloat(paramViewGroup, "alpha", new float[] { 0.0F, 1.0F });
      kotlin.g.b.p.j(localObjectAnimator, "bulletInAnim");
      localObjectAnimator.setDuration(yrd + 500);
      if (!paramBoolean) {
        break label131;
      }
      localObjectAnimator.setEvaluator((TypeEvaluator)new a(yrd, (kotlin.g.a.m)new g(this, paramViewGroup)));
    }
    for (;;)
    {
      localObjectAnimator.addListener((Animator.AnimatorListener)new i(this, paramViewGroup, paramBoolean));
      AppMethodBeat.o(265793);
      return localObjectAnimator;
      localObjectAnimator = ObjectAnimator.ofFloat(paramViewGroup, "translationX", new float[] { -500.0F, 0.0F });
      break;
      label131:
      localObjectAnimator.setInterpolator((TimeInterpolator)new DecelerateInterpolator());
      localObjectAnimator.setEvaluator((TypeEvaluator)new c(yrd, (kotlin.g.a.m)new h(this, paramViewGroup)));
    }
  }
  
  private final boolean h(Map.Entry<? extends ViewGroup, b> paramEntry)
  {
    AppMethodBeat.i(265811);
    Object localObject = paramEntry;
    if (paramEntry == null) {
      localObject = dBI();
    }
    if (localObject != null)
    {
      long l = ((b)((Map.Entry)localObject).getValue()).yrA - (cm.bfE() - ((b)((Map.Entry)localObject).getValue()).yrB);
      Log.i("Finder.FinderLiveGiftQueuePlugin", "checkIfPreciousGiftTimeOver: remainingTime=" + l + ", entry=" + localObject);
      if (l > 100L)
      {
        this.timer.startTimer(l);
        AppMethodBeat.o(265811);
        return true;
      }
      b.b.a(this.kCL, b.c.kAd);
      ((b)((Map.Entry)localObject).getValue()).yrA = 0L;
      ((b)((Map.Entry)localObject).getValue()).yrB = 0L;
      if (((b)((Map.Entry)localObject).getValue()).yrF)
      {
        Log.i("Finder.FinderLiveGiftQueuePlugin", "checkIfPreciousGiftTimeOver: fake container");
        ((b)((Map.Entry)localObject).getValue()).yrq.getAndSet(false);
        dBH();
      }
      for (;;)
      {
        AppMethodBeat.o(265811);
        return false;
        paramEntry = this.yqZ.obtainMessage();
        paramEntry.obj = ((Map.Entry)localObject).getKey();
        this.yqZ.sendMessageDelayed(paramEntry, 2000L);
        Log.i("Finder.FinderLiveGiftQueuePlugin", "checkIfPreciousGiftTimeOver: handler msg.obj = " + paramEntry.obj);
      }
    }
    AppMethodBeat.o(265811);
    return false;
  }
  
  private final ObjectAnimator u(final ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(265795);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramViewGroup, "alpha", new float[] { 1.0F, 0.0F });
    kotlin.g.b.p.j(localObjectAnimator, "bulletOutAnim");
    localObjectAnimator.setDuration(500L);
    localObjectAnimator.addListener((Animator.AnimatorListener)new j(this, paramViewGroup));
    AppMethodBeat.o(265795);
    return localObjectAnimator;
  }
  
  private final void v(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(265819);
    b localb = (b)this.yqT.get(paramViewGroup);
    if (localb != null)
    {
      localb.reset();
      localb.yrE.getAndSet(false);
    }
    paramViewGroup.setVisibility(8);
    AppMethodBeat.o(265819);
  }
  
  private final void w(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(265820);
    if (!this.yqT.containsKey(paramViewGroup))
    {
      AppMethodBeat.o(265820);
      return;
    }
    a((b)this.yqT.get(paramViewGroup));
    Log.i("Finder.FinderLiveGiftQueuePlugin", "unregisterOuterSpace: info:" + (b)this.yqT.get(paramViewGroup));
    this.yqT.remove(paramViewGroup);
    this.yqU.remove(paramViewGroup);
    this.yqV.remove(paramViewGroup);
    this.yrb.removeView((View)paramViewGroup);
    if (this.yqT.size() == this.yqS)
    {
      Log.i("Finder.FinderLiveGiftQueuePlugin", "unregisterOuterSpace: enable origin three container");
      x((ViewGroup)this.yqO);
      x((ViewGroup)this.yqP);
      x((ViewGroup)this.yqQ);
      this.yrb.setVisibility(8);
    }
    AppMethodBeat.o(265820);
  }
  
  private final void x(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(265821);
    paramViewGroup = (b)this.yqT.get(paramViewGroup);
    if (paramViewGroup != null)
    {
      paramViewGroup.yrE.getAndSet(true);
      AppMethodBeat.o(265821);
      return;
    }
    AppMethodBeat.o(265821);
  }
  
  public final void a(p.c paramc)
  {
    AppMethodBeat.i(265815);
    kotlin.g.b.p.k(paramc, "giftType");
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new m(this));
    dBH();
    AppMethodBeat.o(265815);
  }
  
  public final void a(LinkedHashMap<String, Rect> paramLinkedHashMap, boolean paramBoolean)
  {
    AppMethodBeat.i(265822);
    kotlin.g.b.p.k(paramLinkedHashMap, "micUserMap");
    Object localObject3 = ((f)business(f.class)).zhm;
    Object localObject2 = ((f)business(f.class)).zhl;
    Log.i("Finder.FinderLiveGiftQueuePlugin", "onAudienceMicUserChanged: linkMicList size:" + ((List)localObject3).size() + " pkMicUser:" + localObject2);
    Object localObject4;
    Object localObject1;
    Object localObject5;
    if (paramBoolean)
    {
      if (localObject2 == null)
      {
        paramLinkedHashMap = ((Map)this.yqY).entrySet().iterator();
        while (paramLinkedHashMap.hasNext()) {
          w((ViewGroup)((Map.Entry)paramLinkedHashMap.next()).getValue());
        }
        this.yqY.clear();
        AppMethodBeat.o(265822);
        return;
      }
      this.yrb.setVisibility(0);
      localObject3 = ((Map)this.yqY).entrySet().iterator();
      label279:
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (ViewGroup)((Map.Entry)((Iterator)localObject3).next()).getValue();
        localObject1 = (b)this.yqT.get(localObject4);
        localObject5 = (CharSequence)((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject2).username;
        if (localObject1 != null) {}
        for (localObject1 = ((b)localObject1).yrD;; localObject1 = null)
        {
          if (TextUtils.equals((CharSequence)localObject5, (CharSequence)localObject1)) {
            break label279;
          }
          w((ViewGroup)localObject4);
          ((Iterator)localObject3).remove();
          break;
        }
      }
      localObject1 = ((Map)paramLinkedHashMap).entrySet().iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject1).next();
        if (kotlin.g.b.p.h((String)((Map.Entry)localObject3).getKey(), ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject2).ktR)) {}
        for (paramLinkedHashMap = (LinkedHashMap<String, Rect>)localObject2;; paramLinkedHashMap = null)
        {
          if (!this.yqY.containsKey(((Map.Entry)localObject3).getKey())) {
            break label429;
          }
          Log.i("Finder.FinderLiveGiftQueuePlugin", "onAudienceMicUserChanged: adjustContainerLocation, sdkUserId = " + (String)((Map.Entry)localObject3).getKey());
          a((ViewGroup)this.yqY.get(((Map.Entry)localObject3).getKey()), (Rect)((Map.Entry)localObject3).getValue(), paramLinkedHashMap);
          break;
        }
        label429:
        localObject4 = a((Rect)((Map.Entry)localObject3).getValue(), this.yrb, paramLinkedHashMap);
        if (paramLinkedHashMap != null)
        {
          paramLinkedHashMap = paramLinkedHashMap.username;
          if (paramLinkedHashMap != null) {
            break label1212;
          }
        }
        paramLinkedHashMap = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).kig;
      }
    }
    label805:
    label1209:
    label1212:
    for (;;)
    {
      a(this, (ViewGroup)localObject4, paramLinkedHashMap, ((Rect)((Map.Entry)localObject3).getValue()).width());
      ((Map)this.yqY).put(((Map.Entry)localObject3).getKey(), localObject4);
      Log.i("Finder.FinderLiveGiftQueuePlugin", "onAudienceMicUserChanged: outerSpaceMap add new entry, key = " + (String)((Map.Entry)localObject3).getKey() + ", value = " + localObject4 + ", outSpaceWidth:" + ((Rect)((Map.Entry)localObject3).getValue()).width());
      break;
      AppMethodBeat.o(265822);
      return;
      if (((List)localObject3).isEmpty())
      {
        paramLinkedHashMap = ((Map)this.yqY).entrySet().iterator();
        while (paramLinkedHashMap.hasNext()) {
          w((ViewGroup)((Map.Entry)paramLinkedHashMap.next()).getValue());
        }
        this.yqY.clear();
        AppMethodBeat.o(265822);
        return;
      }
      this.yrb.setVisibility(0);
      localObject4 = ((Map)this.yqY).entrySet().iterator();
      label843:
      label848:
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (ViewGroup)((Map.Entry)((Iterator)localObject4).next()).getValue();
        b localb = (b)this.yqT.get(localObject5);
        kotlin.g.b.p.j(localObject3, "linkMicList");
        Iterator localIterator = ((Iterable)localObject3).iterator();
        label762:
        if (localIterator.hasNext())
        {
          localObject2 = localIterator.next();
          CharSequence localCharSequence = (CharSequence)((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject2).username;
          if (localb != null)
          {
            localObject1 = localb.yrD;
            if (!TextUtils.equals(localCharSequence, (CharSequence)localObject1)) {
              break label843;
            }
          }
        }
        for (localObject1 = localObject2;; localObject1 = null)
        {
          if (localObject1 != null) {
            break label848;
          }
          w((ViewGroup)localObject5);
          ((Iterator)localObject4).remove();
          break;
          localObject1 = null;
          break label805;
          break label762;
        }
      }
      localObject1 = ((Map)paramLinkedHashMap).entrySet().iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        kotlin.g.b.p.j(localObject3, "linkMicList");
        localObject4 = ((Iterable)localObject3).iterator();
        do
        {
          if (!((Iterator)localObject4).hasNext()) {
            break;
          }
          paramLinkedHashMap = ((Iterator)localObject4).next();
          localObject5 = (com.tencent.mm.plugin.finder.live.viewmodel.data.h)paramLinkedHashMap;
        } while (!((String)((Map.Entry)localObject2).getKey()).equals(((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject5).ktR));
        for (;;)
        {
          paramLinkedHashMap = (com.tencent.mm.plugin.finder.live.viewmodel.data.h)paramLinkedHashMap;
          if (!this.yqY.containsKey(((Map.Entry)localObject2).getKey())) {
            break label1044;
          }
          Log.i("Finder.FinderLiveGiftQueuePlugin", "onAudienceMicUserChanged: adjustContainerLocation, sdkUserId = " + (String)((Map.Entry)localObject2).getKey());
          a((ViewGroup)this.yqY.get(((Map.Entry)localObject2).getKey()), (Rect)((Map.Entry)localObject2).getValue(), paramLinkedHashMap);
          break;
          paramLinkedHashMap = null;
        }
        localObject4 = a((Rect)((Map.Entry)localObject2).getValue(), this.yrb, paramLinkedHashMap);
        if (paramLinkedHashMap != null)
        {
          paramLinkedHashMap = paramLinkedHashMap.username;
          if (paramLinkedHashMap != null) {
            break label1209;
          }
        }
        paramLinkedHashMap = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).kig;
      }
      for (;;)
      {
        a(this, (ViewGroup)localObject4, paramLinkedHashMap, ((Rect)((Map.Entry)localObject2).getValue()).width());
        ((Map)this.yqY).put(((Map.Entry)localObject2).getKey(), localObject4);
        Log.i("Finder.FinderLiveGiftQueuePlugin", "onAudienceMicUserChanged: outerSpaceMap add new entry, key = " + (String)((Map.Entry)localObject2).getKey() + ", value = " + localObject4 + ", outSpaceWidth:" + ((Rect)((Map.Entry)localObject2).getValue()).width());
        break;
        AppMethodBeat.o(265822);
        return;
      }
    }
  }
  
  public final boolean dAo()
  {
    return true;
  }
  
  public final void dBJ()
  {
    AppMethodBeat.i(265816);
    if (this.yra.hasNext())
    {
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new f(this));
      dBH();
    }
    AppMethodBeat.o(265816);
  }
  
  public final void mount()
  {
    AppMethodBeat.i(265813);
    super.mount();
    this.yra.a((p.a)this);
    AppMethodBeat.o(265813);
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(265814);
    super.unMount();
    this.timer.stopTimer();
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new q(this));
    this.yra.b((p.a)this);
    AppMethodBeat.o(265814);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftQueuePlugin$BulletFadeInEvaluator;", "Landroid/animation/FloatEvaluator;", "fadeDuration", "", "stayDuration", "callback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "fraction", "", "flying", "", "(IILkotlin/jvm/functions/Function2;)V", "getCallback", "()Lkotlin/jvm/functions/Function2;", "setCallback", "(Lkotlin/jvm/functions/Function2;)V", "fadeFraction", "evaluate", "startValue", "", "endValue", "(FLjava/lang/Number;Ljava/lang/Number;)Ljava/lang/Float;", "plugin-finder_release"})
  static final class a
    extends FloatEvaluator
  {
    private kotlin.g.a.m<? super Float, ? super Boolean, x> jHk;
    private final float yrp;
    
    public a(int paramInt, kotlin.g.a.m<? super Float, ? super Boolean, x> paramm)
    {
      AppMethodBeat.i(278011);
      this.jHk = paramm;
      this.yrp = (500.0F / (paramInt + 500));
      AppMethodBeat.o(278011);
    }
    
    public final Float evaluate(float paramFloat, Number paramNumber1, Number paramNumber2)
    {
      AppMethodBeat.i(278009);
      if (paramFloat < this.yrp)
      {
        kotlin.g.a.m localm = this.jHk;
        if (localm != null) {
          localm.invoke(Float.valueOf(paramFloat), Boolean.TRUE);
        }
        if ((paramNumber1 == null) || (paramNumber2 == null))
        {
          AppMethodBeat.o(278009);
          return Float.valueOf(0.0F);
        }
        paramFloat = paramNumber1.floatValue() + (paramNumber2.floatValue() - paramNumber1.floatValue()) * paramFloat / this.yrp;
        AppMethodBeat.o(278009);
        return Float.valueOf(paramFloat);
      }
      paramNumber1 = this.jHk;
      if (paramNumber1 != null) {
        paramNumber1.invoke(Float.valueOf(paramFloat), Boolean.FALSE);
      }
      if (!(paramNumber2 instanceof Float)) {}
      for (paramNumber1 = null;; paramNumber1 = paramNumber2)
      {
        paramNumber1 = (Float)paramNumber1;
        if (paramNumber1 != null)
        {
          paramFloat = paramNumber1.floatValue();
          break;
        }
        paramFloat = 1.0F;
        break;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftQueuePlugin$BulletShowingInfo;", "", "container", "Landroid/view/ViewGroup;", "index", "", "isVisitor", "", "backup", "isOuterSpace", "outSpaceWidth", "(Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftQueuePlugin;Landroid/view/ViewGroup;IZZZI)V", "value", "bulletFlying", "getBulletFlying", "()Z", "setBulletFlying", "(Z)V", "cntQueue", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "getCntQueue", "()Ljava/util/concurrent/ConcurrentLinkedDeque;", "setCntQueue", "(Ljava/util/concurrent/ConcurrentLinkedDeque;)V", "cntTransferAnimatorSet", "Landroid/animation/AnimatorSet;", "getCntTransferAnimatorSet", "()Landroid/animation/AnimatorSet;", "setCntTransferAnimatorSet", "(Landroid/animation/AnimatorSet;)V", "cntTransferAniming", "getCntTransferAniming", "setCntTransferAniming", "comboId", "", "getComboId", "()Ljava/lang/String;", "setComboId", "(Ljava/lang/String;)V", "comboSumCount", "getComboSumCount", "()I", "setComboSumCount", "(I)V", "enabled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getEnabled", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "setEnabled", "(Ljava/util/concurrent/atomic/AtomicBoolean;)V", "giftId", "getGiftId", "setGiftId", "getIndex", "isBackup", "setBackup", "isBulletInAnimationEnd", "setBulletInAnimationEnd", "isFakeContainer", "setFakeContainer", "isPreciousGift", "setPreciousGift", "isSelfSend", "setSelfSend", "isShowing", "setShowing", "lastCountOnBackToLive", "getLastCountOnBackToLive", "setLastCountOnBackToLive", "startShowingTime", "", "getStartShowingTime", "()J", "setStartShowingTime", "(J)V", "targetUserName", "getTargetUserName", "setTargetUserName", "totalShowingTime", "getTotalShowingTime", "setTotalShowingTime", "viewHolder", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftQueuePlugin$BulletViewHolder;", "getViewHolder", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftQueuePlugin$BulletViewHolder;", "reset", "", "saveBackToLiveInfo", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftQueuePlugin$ComboIdBackToLiveInfo;", "destinationCnt", "localSend", "startTransferCnt", "prefix", "toString", "plugin-finder_release"})
  final class b
  {
    final int index;
    volatile long yrA;
    volatile long yrB;
    volatile String yrC;
    volatile String yrD;
    AtomicBoolean yrE;
    boolean yrF;
    AnimatorSet yrG;
    private volatile boolean yrH;
    volatile boolean yrI;
    AtomicBoolean yrq;
    volatile boolean yrr;
    AtomicBoolean yrs;
    volatile boolean yrt;
    volatile String yru;
    volatile int yrv;
    private ConcurrentLinkedDeque<Integer> yrw;
    volatile int yrx;
    final bd.c yry;
    boolean yrz;
    
    private b(final int paramInt1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt2)
    {
      AppMethodBeat.i(287148);
      this.index = paramBoolean1;
      this.yrq = new AtomicBoolean(false);
      this.yrs = new AtomicBoolean(false);
      this.yru = "";
      this.yrw = new ConcurrentLinkedDeque();
      int i;
      this.yry = new bd.c(paramInt1, paramBoolean2, paramInt2, i);
      this.yrz = paramBoolean3;
      this.yrC = "";
      this.yrD = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)bd.this.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).kig;
      this.yrE = new AtomicBoolean(true);
      this.yrG = new AnimatorSet();
      this$1 = ObjectAnimator.ofFloat(this.yry.yrQ, "scaleX", new float[] { 0.0F, 1.1F }).setDuration(125L);
      kotlin.g.b.p.j(bd.this, "ObjectAnimator.ofFloat(v…f, 1.1f).setDuration(125)");
      paramInt1 = ObjectAnimator.ofFloat(this.yry.yrQ, "scaleY", new float[] { 0.0F, 1.1F }).setDuration(125L);
      kotlin.g.b.p.j(paramInt1, "ObjectAnimator.ofFloat(v…f, 1.1f).setDuration(125)");
      ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.yry.yrQ, "scaleX", new float[] { 1.1F, 1.0F }).setDuration(83L);
      kotlin.g.b.p.j(localObjectAnimator1, "ObjectAnimator.ofFloat(v…1f, 1.0f).setDuration(83)");
      localObjectAnimator1.setStartDelay(125L);
      ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.yry.yrQ, "scaleY", new float[] { 1.1F, 1.0F }).setDuration(83L);
      kotlin.g.b.p.j(localObjectAnimator2, "ObjectAnimator.ofFloat(v…1f, 1.0f).setDuration(83)");
      localObjectAnimator2.setStartDelay(125L);
      final ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(this.yry.yrQ, "alpha", new float[] { 0.0F, 1.0F }).setDuration(208L);
      kotlin.g.b.p.j(localObjectAnimator3, "ObjectAnimator.ofFloat(v…f, 1.0f).setDuration(208)");
      this.yry.yrQ.setPivotX(0.0F);
      this.yry.yrQ.setPivotY(this.yry.yrQ.getMeasuredHeight());
      this.yrG.playTogether(new Animator[] { (Animator)bd.this, (Animator)paramInt1, (Animator)localObjectAnimator1, (Animator)localObjectAnimator2, (Animator)localObjectAnimator3 });
      this.yrG.addListener((Animator.AnimatorListener)new Animator.AnimatorListener()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(290056);
          this.yrJ.pf(false);
          Object localObject = localObjectAnimator3.getTarget();
          paramAnonymousAnimator = localObject;
          if (!(localObject instanceof View)) {
            paramAnonymousAnimator = null;
          }
          paramAnonymousAnimator = (View)paramAnonymousAnimator;
          if (paramAnonymousAnimator != null) {
            paramAnonymousAnimator.setAlpha(1.0F);
          }
          localObject = this.yrL.getTarget();
          paramAnonymousAnimator = localObject;
          if (!(localObject instanceof View)) {
            paramAnonymousAnimator = null;
          }
          paramAnonymousAnimator = (View)paramAnonymousAnimator;
          if (paramAnonymousAnimator != null) {
            paramAnonymousAnimator.setScaleX(1.0F);
          }
          localObject = paramInt1.getTarget();
          paramAnonymousAnimator = localObject;
          if (!(localObject instanceof View)) {
            paramAnonymousAnimator = null;
          }
          paramAnonymousAnimator = (View)paramAnonymousAnimator;
          if (paramAnonymousAnimator != null)
          {
            paramAnonymousAnimator.setScaleY(1.0F);
            AppMethodBeat.o(290056);
            return;
          }
          AppMethodBeat.o(290056);
        }
        
        public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(290055);
          this.yrJ.pf(true);
          AppMethodBeat.o(290055);
        }
      });
      AppMethodBeat.o(287148);
    }
    
    private void aCp(String paramString)
    {
      AppMethodBeat.i(287144);
      kotlin.g.b.p.k(paramString, "prefix");
      boolean bool1 = this.yrw.isEmpty();
      if ((bool1) || (this.yrH) || (this.yrI))
      {
        Log.i("Finder.FinderLiveGiftQueuePlugin", "startTransferCnt(" + paramString + ") cntQueueEmpty:" + bool1 + ",cntTransferAniming:" + this.yrH + ",bulletFlying:" + this.yrI);
        AppMethodBeat.o(287144);
        return;
      }
      Integer localInteger = (Integer)this.yrw.pollFirst();
      if (localInteger != null) {}
      for (int i = localInteger.intValue();; i = this.yrv)
      {
        boolean bool2 = kotlin.g.b.p.h(this.yry.yrQ.getText(), "x".concat(String.valueOf(i)));
        Log.i("Finder.FinderLiveGiftQueuePlugin", "startTransferCnt(" + paramString + ") number:" + i + ", sameValue:" + bool2 + ", cntQueueEmpty:" + bool1 + ",cntTransferAniming:" + this.yrH + ",bulletFlying:" + this.yrI);
        this.yry.yrQ.setText((CharSequence)"x".concat(String.valueOf(i)));
        this.yry.yrQ.setTag(Integer.valueOf(i));
        this.yry.yrQ.setPivotX(0.0F);
        this.yry.yrQ.setPivotY(this.yry.yrQ.getMeasuredHeight());
        this.yrG.start();
        bd.a(bool2, this);
        AppMethodBeat.o(287144);
        return;
      }
    }
    
    private final bd.d dBM()
    {
      AppMethodBeat.i(287146);
      bd.d locald = new bd.d();
      locald.yrs.getAndSet(this.yrs.get());
      locald.fCB = this.yrt;
      locald.yrv = this.yrv;
      locald.mcV = cm.bfE();
      locald.aCq(this.yrC);
      AppMethodBeat.o(287146);
      return locald;
    }
    
    public final void aCn(String paramString)
    {
      AppMethodBeat.i(287139);
      kotlin.g.b.p.k(paramString, "<set-?>");
      this.yru = paramString;
      AppMethodBeat.o(287139);
    }
    
    public final void aCo(String paramString)
    {
      AppMethodBeat.i(287140);
      kotlin.g.b.p.k(paramString, "<set-?>");
      this.yrD = paramString;
      AppMethodBeat.o(287140);
    }
    
    public final void ak(int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(287143);
      Object localObject2 = this.yry.yrQ.getTag();
      Object localObject1 = localObject2;
      if (!(localObject2 instanceof Integer)) {
        localObject1 = null;
      }
      localObject1 = (Integer)localObject1;
      int i;
      boolean bool;
      if (localObject1 != null)
      {
        i = ((Integer)localObject1).intValue();
        if (i > 0) {
          break label117;
        }
        bool = true;
        i = 1;
      }
      for (;;)
      {
        if (paramInt > i) {
          break label123;
        }
        this.yry.yrQ.setText((CharSequence)"x".concat(String.valueOf(i)));
        this.yry.yrQ.setTag(Integer.valueOf(i));
        AppMethodBeat.o(287143);
        return;
        i = this.yrx;
        break;
        label117:
        bool = false;
      }
      label123:
      localObject1 = new StringBuilder("localSend:" + paramBoolean + ",startCnt:" + i + ",lastCountOnBackToLive:" + this.yrx + ",firstGift:" + bool + ';');
      this.yrw.clear();
      int j;
      if (!paramBoolean)
      {
        j = kotlin.k.i.ov(1, (int)Math.ceil((paramInt - i) / 5.0D));
        if (bool) {
          break label328;
        }
        i += j;
      }
      label328:
      for (;;)
      {
        if (i < paramInt)
        {
          this.yrw.offer(Integer.valueOf(i));
          ((StringBuilder)localObject1).append(i + ',');
          i += j;
        }
        else
        {
          this.yrw.offer(Integer.valueOf(paramInt));
          ((StringBuilder)localObject1).append(paramInt);
          Log.i("Finder.FinderLiveGiftQueuePlugin", "setCntQueue ".concat(String.valueOf(localObject1)));
          aCp("setCntQueue");
          AppMethodBeat.o(287143);
          return;
        }
      }
    }
    
    public final void pf(boolean paramBoolean)
    {
      AppMethodBeat.i(287141);
      if (paramBoolean != this.yrH) {
        Log.i("Finder.FinderLiveGiftQueuePlugin", "cntTransferAniming origin value:" + this.yrH + ",value:" + paramBoolean);
      }
      this.yrH = paramBoolean;
      if (!this.yrH) {
        aCp("cntTransferAnim end");
      }
      AppMethodBeat.o(287141);
    }
    
    public final void pg(boolean paramBoolean)
    {
      AppMethodBeat.i(287142);
      int j = 0;
      int i = j;
      if (paramBoolean != this.yrI)
      {
        Log.i("Finder.FinderLiveGiftQueuePlugin", "bulletFlying origin value:" + this.yrI + ",value:" + paramBoolean);
        i = j;
        if (!paramBoolean) {
          i = 1;
        }
      }
      this.yrI = paramBoolean;
      if (i != 0) {
        aCp("bulletFlying Stop");
      }
      AppMethodBeat.o(287142);
    }
    
    public final void reset()
    {
      AppMethodBeat.i(287145);
      bd.b(bd.this).put(this.yru, dBM());
      com.tencent.mm.ae.d.c("giftQueueMapClear", (kotlin.g.a.a)new a(this));
      final Integer localInteger = (Integer)this.yrw.peekLast();
      if (localInteger != null) {
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b(this, localInteger));
      }
      this.yrq.getAndSet(false);
      this.yrr = false;
      this.yrs.getAndSet(false);
      this.yrt = false;
      this.yru = "";
      this.yrv = 0;
      this.yrx = 0;
      this.yrw.clear();
      this.yrA = 0L;
      this.yrB = 0L;
      this.yrC = "";
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new c(this));
      pf(false);
      pg(false);
      this.yry.yrQ.setTag(null);
      AppMethodBeat.o(287145);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(287147);
      String str = "\n" + new StringBuilder("index = ").append(this.index).toString() + ", " + new StringBuilder("giftId = ").append(this.yrC).toString() + ", " + new StringBuilder("isShowing = ").append(this.yrq).toString() + ", " + new StringBuilder("isPreciousGift = ").append(this.yrs).toString() + ", " + new StringBuilder("isAnimationEnd = ").append(this.yrr).toString() + ", " + new StringBuilder("comboId = ").append(this.yru).toString() + ", " + new StringBuilder("comboSumCount = ").append(this.yrv).toString() + ", " + new StringBuilder("lastCountOnBackToLive = ").append(this.yrx).toString() + ", " + new StringBuilder("totalShowingTime = ").append(this.yrA).toString() + ", " + new StringBuilder("cntTransferAniming = ").append(this.yrH).toString() + ", " + new StringBuilder("bulletFlying = ").append(this.yrI).toString() + ", " + new StringBuilder("targetUserName = ").append(this.yrD).toString() + ", " + new StringBuilder("enabled = ").append(this.yrE).toString() + "\n";
      kotlin.g.b.p.j(str, "StringBuilder().append(\"…              .toString()");
      AppMethodBeat.o(287147);
      return str;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.a<x>
    {
      a(bd.b paramb)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class b
      extends q
      implements kotlin.g.a.a<x>
    {
      b(bd.b paramb, Integer paramInteger)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class c
      extends q
      implements kotlin.g.a.a<x>
    {
      c(bd.b paramb)
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftQueuePlugin$BulletViewHolder;", "", "container", "Landroid/view/ViewGroup;", "isVisitor", "", "isOuterSpace", "outSpaceWidth", "", "(Landroid/view/ViewGroup;ZZI)V", "bgView", "Landroid/view/View;", "getBgView", "()Landroid/view/View;", "cntTv", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveGiftTextView;", "getCntTv", "()Lcom/tencent/mm/plugin/finder/live/view/FinderLiveGiftTextView;", "fromUserTv", "Landroid/widget/TextView;", "getFromUserTv", "()Landroid/widget/TextView;", "giftNameTv", "getGiftNameTv", "()Z", "getOutSpaceWidth", "()I", "pagView", "Lorg/libpag/PAGView;", "getPagView", "()Lorg/libpag/PAGView;", "plugin-finder_release"})
  static final class c
  {
    final View cCj;
    final PAGView ybU;
    final TextView yrO;
    final TextView yrP;
    final FinderLiveGiftTextView yrQ;
    final boolean yrR;
    final int yrS;
    
    public c(ViewGroup paramViewGroup, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
    {
      AppMethodBeat.i(287277);
      this.yrR = paramBoolean2;
      this.yrS = paramInt;
      Object localObject = paramViewGroup.findViewById(b.f.finder_live_gift_bullut_desc_from_user);
      kotlin.g.b.p.j(localObject, "container.findViewById(R…ft_bullut_desc_from_user)");
      this.yrO = ((TextView)localObject);
      localObject = paramViewGroup.findViewById(b.f.finder_live_gift_bullut_desc_gift_name);
      kotlin.g.b.p.j(localObject, "container.findViewById(R…ft_bullut_desc_gift_name)");
      this.yrP = ((TextView)localObject);
      localObject = paramViewGroup.findViewById(b.f.finder_live_gift_bullut_pag);
      kotlin.g.b.p.j(localObject, "container.findViewById(R…der_live_gift_bullut_pag)");
      this.ybU = ((PAGView)localObject);
      localObject = paramViewGroup.findViewById(b.f.finder_live_gift_bullut_cnt_tv);
      kotlin.g.b.p.j(localObject, "container.findViewById(R…_live_gift_bullut_cnt_tv)");
      this.yrQ = ((FinderLiveGiftTextView)localObject);
      localObject = paramViewGroup.findViewById(b.f.bg_view);
      kotlin.g.b.p.j(localObject, "container.findViewById(R.id.bg_view)");
      this.cCj = ((View)localObject);
      if (this.yrR)
      {
        this.yrO.setTextSize(1, 12.0F);
        this.yrP.setTextSize(1, 12.0F);
        localObject = this.ybU.getLayoutParams();
        Context localContext = paramViewGroup.getContext();
        kotlin.g.b.p.j(localContext, "container.context");
        ((ViewGroup.LayoutParams)localObject).width = ((int)localContext.getResources().getDimension(b.d.Edge_5A));
        localObject = this.ybU.getLayoutParams();
        localContext = paramViewGroup.getContext();
        kotlin.g.b.p.j(localContext, "container.context");
        ((ViewGroup.LayoutParams)localObject).height = ((int)localContext.getResources().getDimension(b.d.Edge_5A));
        this.yrQ.setTextSize(1, 17.0F);
        localObject = paramViewGroup.getLayoutParams();
        localContext = paramViewGroup.getContext();
        kotlin.g.b.p.j(localContext, "container.context");
        ((ViewGroup.LayoutParams)localObject).height = ((int)localContext.getResources().getDimension(b.d.Edge_5A));
        localObject = paramViewGroup.findViewById(b.f.bg_view);
        if (localObject != null)
        {
          localObject = ((View)localObject).getLayoutParams();
          if (localObject != null) {
            ((ViewGroup.LayoutParams)localObject).width = bd.dBK();
          }
        }
        localObject = paramViewGroup.findViewById(b.f.bg_view);
        if (localObject != null)
        {
          localObject = ((View)localObject).getLayoutParams();
          if (localObject != null)
          {
            paramViewGroup = paramViewGroup.getContext();
            kotlin.g.b.p.j(paramViewGroup, "container.context");
            ((ViewGroup.LayoutParams)localObject).height = ((int)paramViewGroup.getResources().getDimension(b.d.Edge_3A));
            AppMethodBeat.o(287277);
            return;
          }
        }
        AppMethodBeat.o(287277);
        return;
      }
      if (paramBoolean1)
      {
        this.yrO.setTextSize(1, 15.0F);
        this.yrP.setTextSize(1, 15.0F);
        localObject = paramViewGroup.findViewById(b.f.bg_view);
        if (localObject != null)
        {
          localObject = ((View)localObject).getLayoutParams();
          if (localObject != null)
          {
            paramViewGroup = paramViewGroup.getContext();
            kotlin.g.b.p.j(paramViewGroup, "container.context");
            ((ViewGroup.LayoutParams)localObject).height = ((int)paramViewGroup.getResources().getDimension(b.d.Edge_3A));
          }
        }
      }
      for (;;)
      {
        this.yrQ.setTextSize(1, 22.0F);
        AppMethodBeat.o(287277);
        return;
        this.yrO.setTextSize(1, 17.0F);
        this.yrP.setTextSize(1, 17.0F);
        localObject = paramViewGroup.findViewById(b.f.bg_view);
        if (localObject != null)
        {
          localObject = ((View)localObject).getLayoutParams();
          if (localObject != null)
          {
            paramViewGroup = paramViewGroup.getContext();
            kotlin.g.b.p.j(paramViewGroup, "container.context");
            ((ViewGroup.LayoutParams)localObject).height = ((int)paramViewGroup.getResources().getDimension(b.d.Edge_4A));
          }
        }
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftQueuePlugin$ComboIdBackToLiveInfo;", "", "()V", "comboSumCount", "", "getComboSumCount", "()I", "setComboSumCount", "(I)V", "giftId", "", "getGiftId", "()Ljava/lang/String;", "setGiftId", "(Ljava/lang/String;)V", "isPreciousGift", "Ljava/util/concurrent/atomic/AtomicBoolean;", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "setPreciousGift", "(Ljava/util/concurrent/atomic/AtomicBoolean;)V", "isSelf", "", "()Z", "setSelf", "(Z)V", "quitTime", "", "getQuitTime", "()J", "setQuitTime", "(J)V", "plugin-finder_release"})
  static final class d
  {
    volatile boolean fCB;
    long mcV;
    private volatile String yrC;
    AtomicBoolean yrs;
    volatile int yrv;
    
    public d()
    {
      AppMethodBeat.i(292243);
      this.yrs = new AtomicBoolean(false);
      this.yrC = "";
      AppMethodBeat.o(292243);
    }
    
    public final void aCq(String paramString)
    {
      AppMethodBeat.i(292242);
      kotlin.g.b.p.k(paramString, "<set-?>");
      this.yrC = paramString;
      AppMethodBeat.o(292242);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftQueuePlugin$Companion;", "", "()V", "ANIMATION_DURATION", "", "ANIMATION_STAY_START_TIME", "", "BULLET_FLY_DISTANCE", "", "BULLET_UI_HEIGHT", "D_2A", "D_5A", "ENABLE_TEST", "", "FLY_FRACTION", "GIFT_FROM_USER_LEFT_MARGIN", "GIFT_FROM_USER_WITH_SPAN_LEFT_MARGIN", "LINK_MIC_USER_MARGIN_BOTTOM", "OUTER_SPACE_NICK_NAME_MAX_LENGTH", "OUTSPACE_GIFT_BG_WIDTH", "PRECIOUS_GIFT_BULLET_OUT_DELAY", "PRECIOUS_GIFT_REMAINING_TIME_THRESHHOLD", "STAY_DURATION", "TAG", "", "plugin-finder_release"})
  public static final class e {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<x>
  {
    f(bd parambd)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "fraction", "", "flying", "", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.m<Float, Boolean, x>
  {
    g(bd parambd, ViewGroup paramViewGroup)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "fraction", "", "flying", "", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.m<Float, Boolean, x>
  {
    h(bd parambd, ViewGroup paramViewGroup)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftQueuePlugin$createBulletInAnimator$3", "Landroid/animation/Animator$AnimatorListener;", "isCanceling", "", "()Z", "setCanceling", "(Z)V", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class i
    implements Animator.AnimatorListener
  {
    private boolean yrU;
    
    i(ViewGroup paramViewGroup, boolean paramBoolean) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(283691);
      this.yrU = true;
      Log.i("Finder.FinderLiveGiftQueuePlugin", "BulletInAnimator onAnimationCancel: isCancel=" + this.yrU + ", bulletShowInfo:" + (bd.b)bd.d(this.yro).get(paramViewGroup));
      AppMethodBeat.o(283691);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(283690);
      Log.i("Finder.FinderLiveGiftQueuePlugin", "BulletInAnimator onAnimationEnd: isCancel=" + this.yrU + ", bulletShowInfo: " + (bd.b)bd.d(this.yro).get(paramViewGroup));
      if (this.yrU)
      {
        this.yrU = false;
        AppMethodBeat.o(283690);
        return;
      }
      paramAnimator = (bd.b)bd.d(this.yro).get(paramViewGroup);
      if (paramAnimator != null) {
        paramAnimator.yrr = true;
      }
      paramAnimator = (bd.b)bd.d(this.yro).get(paramViewGroup);
      if (paramAnimator != null)
      {
        paramAnimator = paramAnimator.yrs;
        if ((paramAnimator != null) && (true == paramAnimator.get()))
        {
          Iterator localIterator = j.z((Iterable)bd.d(this.yro).entrySet()).iterator();
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
            paramAnimator = localIterator.next();
          } while (!kotlin.g.b.p.h((ViewGroup)((Map.Entry)paramAnimator).getKey(), paramViewGroup));
          for (;;)
          {
            paramAnimator = (Map.Entry)paramAnimator;
            bd.a(this.yro, paramAnimator);
            AppMethodBeat.o(283690);
            return;
            paramAnimator = null;
          }
        }
      }
      paramAnimator = (ObjectAnimator)bd.e(this.yro).get(paramViewGroup);
      if (paramAnimator != null)
      {
        paramAnimator.start();
        AppMethodBeat.o(283690);
        return;
      }
      AppMethodBeat.o(283690);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(283692);
      Log.i("Finder.FinderLiveGiftQueuePlugin", "BulletInAnimator onAnimationStart: " + (bd.b)bd.d(this.yro).get(paramViewGroup));
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(this));
      AppMethodBeat.o(283692);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.a<x>
    {
      a(bd.i parami)
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftQueuePlugin$createBulletOutAnimator$1", "Landroid/animation/Animator$AnimatorListener;", "isCanceling", "", "()Z", "setCanceling", "(Z)V", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class j
    implements Animator.AnimatorListener
  {
    private boolean yrU;
    
    j(ViewGroup paramViewGroup) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(265159);
      this.yrU = true;
      Log.i("Finder.FinderLiveGiftQueuePlugin", "BulletOutAnimator onAnimationCancel: isCancel=" + this.yrU + ", bulletShowInfo:" + (bd.b)bd.d(this.yro).get(paramViewGroup));
      AppMethodBeat.o(265159);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(265158);
      Log.i("Finder.FinderLiveGiftQueuePlugin", "BulletOutAnimator onAnimationEnd: isCancel=" + this.yrU + ", bulletShowInfo: " + (bd.b)bd.d(this.yro).get(paramViewGroup));
      if (this.yrU)
      {
        this.yrU = false;
        AppMethodBeat.o(265158);
        return;
      }
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(this));
      paramAnimator = (bd.b)bd.d(this.yro).get(paramViewGroup);
      if (paramAnimator != null) {
        paramAnimator.reset();
      }
      bd.f(this.yro);
      AppMethodBeat.o(265158);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(265161);
      Log.i("Finder.FinderLiveGiftQueuePlugin", "BulletOutAnimator onAnimationStart: " + (bd.b)bd.d(this.yro).get(paramViewGroup));
      AppMethodBeat.o(265161);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.a<x>
    {
      a(bd.j paramj)
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "Landroid/view/ViewGroup;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftQueuePlugin$BulletShowingInfo;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftQueuePlugin;", "invoke"})
  static final class k
    extends q
    implements kotlin.g.a.b<Map.Entry<? extends ViewGroup, ? extends bd.b>, Boolean>
  {
    public static final k yrY;
    
    static
    {
      AppMethodBeat.i(285409);
      yrY = new k();
      AppMethodBeat.o(285409);
    }
    
    k()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class l
    extends q
    implements kotlin.g.a.a<x>
  {
    l(bd parambd, ViewGroup paramViewGroup, p.b paramb)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class m
    extends q
    implements kotlin.g.a.a<x>
  {
    m(bd parambd)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class n
    extends q
    implements kotlin.g.a.a<x>
  {
    n(bd parambd, ViewGroup paramViewGroup, p.b paramb)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class o
    extends q
    implements kotlin.g.a.a<x>
  {
    o(bd parambd, aa.f paramf, ViewGroup paramViewGroup, p.b paramb)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftQueuePlugin$timer$1", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler$CallBack;", "onTimerExpired", "", "plugin-finder_release"})
  public static final class p
    implements MTimerHandler.CallBack
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(245733);
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(this));
      AppMethodBeat.o(245733);
      return false;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.a<x>
    {
      a(bd.p paramp)
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class q
    extends q
    implements kotlin.g.a.a<x>
  {
    q(bd parambd)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.bd
 * JD-Core Version:    0.7.0.1
 */