package com.tencent.mm.plugin.finder.live.plugin;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
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
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.b.b;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.model.q;
import com.tencent.mm.plugin.finder.live.p.c;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.util.s.a;
import com.tencent.mm.plugin.finder.live.util.s.b;
import com.tencent.mm.plugin.finder.live.util.s.c;
import com.tencent.mm.plugin.finder.live.view.FinderLiveGiftTextView;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.j;
import com.tencent.mm.protocal.protobuf.bek;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.component.k.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.ah.f;
import kotlin.g.b.u;
import org.libpag.PAGView;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftQueuePlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue$GiftAddingObserver;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "iGiftQueue", "Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue;", "outerSpaceParent", "isVisitor", "", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue;Landroid/view/ViewGroup;Z)V", "NICK_NAME_LENGTH", "", "bulletInAnimatorMap", "", "Landroid/animation/ObjectAnimator;", "bulletInfoMap", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftQueuePlugin$BulletShowingInfo;", "bulletOutAnimatorMap", "cacheOuterVisibility", "comboIdBackToLiveMap", "", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftQueuePlugin$ComboIdBackToLiveInfo;", "comboIdList", "Ljava/util/LinkedList;", "containerFake", "Landroid/widget/RelativeLayout;", "containerOne", "containerThree", "containerTwo", "flushMainThreadBelowApi25Config", "initialMapSize", "outerSpaceMap", "Ljava/util/concurrent/ConcurrentHashMap;", "preciousGiftBulletOutHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "preciousGiftBulletOutHandlerProcessing", "timer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "adjustGiftfromUserMargin", "", "fromUserTv", "Landroid/widget/TextView;", "haveSImageSpan", "adjustLayoutForLinkMic", "needResize", "viewHolder", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftQueuePlugin$BulletViewHolder;", "adjustOuterSpaceContainerLocation", "container", "rect", "Landroid/graphics/Rect;", "micUser", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveLinkMicUser;", "calculatePreciousGiftRemainingTime", "", "entry", "", "canClearScreen", "checkIfNeedPreserveShowingPreciousGift", "info", "checkIfOuterSpacePreciousGiftForceReplace", "checkIfPreciousGiftTimeOver", "checkIfSelfPreciousGiftForceReplace", "checkInfoFromComboIdBackToLiveMap", "comboId", "checkStatusWhenMaximizeWindow", "cloneToFakeContainer", "createBulletInAnimator", "target", "isOuterSpace", "createBulletOutAnimator", "disableContainer", "enableContainer", "enoughSpaceForGiftText", "bulletShowingInfo", "nickname", "userLevelSpan", "Landroid/text/style/ImageSpan;", "enoughSpaceForRelaunch", "findCurrentShowingPreciousGift", "getDisplayNickName", "", "contact", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "textView", "getOuterSpaceContainer", "parent", "launchBulletInAnimation", "space", "giftShowInfo", "Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue$GiftShowInfo;", "matchBackupGiftType", "mount", "onGiftAdding", "giftType", "Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue$GiftType;", "onMicUserChanged", "micUserMap", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "isPkAnchor", "pollNextGiftShowInfo", "registerBulletInAnimatorListener", "bulletInAnim", "registerBulletOutAnimatorListener", "bulletOutAnim", "registerOuterSpace", "targetUserName", "direction", "outSpaceWidth", "relaunchBulletInAnimation", "replaceBullet", "originSpace", "setOuterVisible", "visible", "setVisible", "showFullScreenPreciousGift", "isForceReplace", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "textViewShowLines", "width", "takePlaceWidth", "targetTv", "msg", "tryToAdjustGiftName", "sameValue", "unMount", "unregisterOuterSpace", "updateBulletShowingInfo", "updatePreciousGiftTotalShowingTime", "giftId", "diffCnt", "visibleInCurrentLiveMode", "BulletFadeInEvaluator", "BulletShowingInfo", "BulletViewHolder", "ComboIdBackToLiveInfo", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class aw
  extends b
  implements s.a
{
  public static final aw.e DaN;
  private static final int Dbh;
  private static final int Dbi;
  private static final float Dbj;
  private static final float Dbk;
  private static final float Dbl;
  private static final float Dbm;
  private static final int Dbn;
  private static final int Dbo;
  private static final int Dbp;
  private static final boolean Dbq;
  private final com.tencent.mm.plugin.finder.live.util.s DaO;
  private final ViewGroup DaP;
  private final boolean DaQ;
  private final int DaR;
  private final int DaS;
  private final RelativeLayout DaT;
  private final RelativeLayout DaU;
  private final RelativeLayout DaV;
  private final RelativeLayout DaW;
  private final int DaX;
  private final Map<ViewGroup, b> DaY;
  private final Map<ViewGroup, ObjectAnimator> DaZ;
  private final Map<ViewGroup, ObjectAnimator> Dba;
  private final Map<String, d> Dbb;
  private final LinkedList<String> Dbc;
  private final ConcurrentHashMap<String, ViewGroup> Dbd;
  private final MMHandler Dbe;
  private volatile boolean Dbf;
  private int Dbg;
  private final com.tencent.mm.live.b.b nfT;
  private final MTimerHandler timer;
  
  static
  {
    AppMethodBeat.i(355260);
    DaN = new aw.e((byte)0);
    Object localObject = com.tencent.d.a.a.a.a.a.ahiX;
    Dbh = ((Number)com.tencent.d.a.a.a.a.a.jSs().bmg()).intValue() * 1000;
    Dbi = 500 / (Dbh + 500);
    Dbj = MMApplicationContext.getResources().getDimension(p.c.Edge_2A);
    float f = MMApplicationContext.getResources().getDimension(p.c.Edge_5A);
    Dbk = f;
    Dbl = f;
    Dbm = MMApplicationContext.getResources().getDimension(p.c.Edge_5A);
    Dbn = MMApplicationContext.getResources().getDimensionPixelOffset(p.c.Edge_1_5_A);
    Dbo = com.tencent.mm.view.d.e(MMApplicationContext.getContext(), 3.0F);
    Dbp = (int)MMApplicationContext.getResources().getDimension(p.c.Edge_23A);
    localObject = com.tencent.d.a.a.a.a.a.ahiX;
    if (((Number)com.tencent.d.a.a.a.a.a.jRR().bmg()).intValue() == 0)
    {
      localObject = aj.CGT;
      if (aj.elM() == null) {}
    }
    for (boolean bool = true;; bool = false)
    {
      Dbq = bool;
      AppMethodBeat.o(355260);
      return;
    }
  }
  
  public aw(ViewGroup paramViewGroup1, com.tencent.mm.live.b.b paramb, com.tencent.mm.plugin.finder.live.util.s params, ViewGroup paramViewGroup2, boolean paramBoolean)
  {
    super(paramViewGroup1, paramb);
    AppMethodBeat.i(354887);
    this.nfT = paramb;
    this.DaO = params;
    this.DaP = paramViewGroup2;
    this.DaQ = paramBoolean;
    paramb = com.tencent.d.a.a.a.a.a.ahiX;
    this.DaR = ((Number)com.tencent.d.a.a.a.a.a.jSt().bmg()).intValue();
    paramb = com.tencent.d.a.a.a.a.a.ahiX;
    this.DaS = ((Number)com.tencent.d.a.a.a.a.a.jSu().bmg()).intValue();
    this.Dbc = new LinkedList();
    this.Dbd = new ConcurrentHashMap();
    this.timer = new MTimerHandler("FinderLiveGiftQueuePlugin::Timer", (MTimerHandler.CallBack)new p(this), false);
    paramb = paramViewGroup1.findViewById(p.e.BLW);
    kotlin.g.b.s.s(paramb, "root.findViewById(R.id.f…ve_gift_queue_bullet_one)");
    this.DaT = ((RelativeLayout)paramb);
    paramb = paramViewGroup1.findViewById(p.e.BLY);
    kotlin.g.b.s.s(paramb, "root.findViewById(R.id.f…ve_gift_queue_bullet_two)");
    this.DaU = ((RelativeLayout)paramb);
    paramb = paramViewGroup1.findViewById(p.e.BLX);
    kotlin.g.b.s.s(paramb, "root.findViewById(R.id.f…_gift_queue_bullet_three)");
    this.DaV = ((RelativeLayout)paramb);
    paramViewGroup1 = LayoutInflater.from(paramViewGroup1.getContext()).inflate(p.f.CdV, paramViewGroup1, false);
    if (paramViewGroup1 == null)
    {
      paramViewGroup1 = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout");
      AppMethodBeat.o(354887);
      throw paramViewGroup1;
    }
    this.DaW = ((RelativeLayout)paramViewGroup1);
    paramViewGroup1 = Collections.synchronizedMap((Map)new LinkedHashMap(3));
    kotlin.g.b.s.s(paramViewGroup1, "synchronizedMap(LinkedHashMap(3))");
    this.DaY = paramViewGroup1;
    this.DaY.put(this.DaT, new b((ViewGroup)this.DaT, 0, this.DaQ, false, false, 0, 56));
    this.DaY.put(this.DaU, new b((ViewGroup)this.DaU, 1, this.DaQ, false, false, 0, 56));
    this.DaY.put(this.DaV, new b((ViewGroup)this.DaV, 2, this.DaQ, true, false, 0, 48));
    paramViewGroup1 = this.DaY;
    paramb = this.DaW;
    params = new b((ViewGroup)this.DaW, 1000, this.DaQ, false, false, 0, 56);
    params.DbI = true;
    params.Dbv.getAndSet(true);
    params.awW("");
    paramViewGroup1.put(paramb, params);
    this.DaX = this.DaY.size();
    this.DaZ = ((Map)new ConcurrentHashMap(3));
    this.DaZ.put(this.DaT, f((ViewGroup)this.DaT, false));
    this.DaZ.put(this.DaU, f((ViewGroup)this.DaU, false));
    this.DaZ.put(this.DaV, f((ViewGroup)this.DaV, false));
    this.Dba = ((Map)new ConcurrentHashMap(3));
    this.Dba.put(this.DaT, z((ViewGroup)this.DaT));
    this.Dba.put(this.DaU, z((ViewGroup)this.DaU));
    this.Dba.put(this.DaV, z((ViewGroup)this.DaV));
    paramViewGroup1 = Collections.synchronizedMap((Map)new LinkedHashMap());
    kotlin.g.b.s.s(paramViewGroup1, "synchronizedMap(LinkedHashMap())");
    this.Dbb = paramViewGroup1;
    paramViewGroup1 = ((Iterable)this.DaY.values()).iterator();
    while (paramViewGroup1.hasNext())
    {
      paramb = (b)paramViewGroup1.next();
      params = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      com.tencent.mm.plugin.finder.live.utils.a.v((TextView)paramb.DbB.DbX);
    }
    this.Dbe = new MMHandler(Looper.getMainLooper(), new aw..ExternalSyntheticLambda0(this));
    this.Dbe.setLogging(false);
    if (Dbq)
    {
      paramViewGroup1 = this.DaT;
      if (paramViewGroup1 != null) {
        paramViewGroup1.setVisibility(8);
      }
      paramViewGroup1 = this.DaU;
      if (paramViewGroup1 != null) {
        paramViewGroup1.setVisibility(8);
      }
      paramViewGroup1 = this.DaV;
      if (paramViewGroup1 != null) {
        paramViewGroup1.setVisibility(8);
      }
    }
    Log.i("Finder.FinderLiveGiftQueuePlugin", kotlin.g.b.s.X("ENABLE_TEST:", Boolean.valueOf(Dbq)));
    this.Dbg = 8;
    AppMethodBeat.o(354887);
  }
  
  private final void A(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(355101);
    b localb = (b)this.DaY.get(paramViewGroup);
    if (localb != null)
    {
      localb.reset();
      localb.DbH.getAndSet(false);
    }
    paramViewGroup.setVisibility(8);
    AppMethodBeat.o(355101);
  }
  
  private final void B(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(355113);
    if (!this.DaY.containsKey(paramViewGroup))
    {
      AppMethodBeat.o(355113);
      return;
    }
    Object localObject = (b)this.DaY.get(paramViewGroup);
    a((b)localObject);
    if (localObject != null) {
      ((b)localObject).eqA();
    }
    Log.i("Finder.FinderLiveGiftQueuePlugin", kotlin.g.b.s.X("unregisterOuterSpace: info:", localObject));
    this.DaY.remove(paramViewGroup);
    localObject = (ObjectAnimator)this.DaZ.get(paramViewGroup);
    if (localObject != null) {
      ((ObjectAnimator)localObject).removeAllListeners();
    }
    this.DaZ.remove(paramViewGroup);
    localObject = (ObjectAnimator)this.Dba.get(paramViewGroup);
    if (localObject != null) {
      ((ObjectAnimator)localObject).removeAllListeners();
    }
    this.Dba.remove(paramViewGroup);
    this.DaP.removeView((View)paramViewGroup);
    if (this.DaY.size() == this.DaX)
    {
      Log.i("Finder.FinderLiveGiftQueuePlugin", "unregisterOuterSpace: enable origin three container");
      C((ViewGroup)this.DaT);
      C((ViewGroup)this.DaU);
      C((ViewGroup)this.DaV);
      OZ(8);
    }
    AppMethodBeat.o(355113);
  }
  
  private final void C(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(355123);
    paramViewGroup = (b)this.DaY.get(paramViewGroup);
    if (paramViewGroup != null) {
      paramViewGroup.DbH.getAndSet(true);
    }
    AppMethodBeat.o(355123);
  }
  
  private void OZ(int paramInt)
  {
    AppMethodBeat.i(355157);
    this.Dbg = paramInt;
    Object localObject = com.tencent.mm.ui.component.k.aeZF;
    localObject = this.mJe.getContext();
    kotlin.g.b.s.s(localObject, "root.context");
    if (((com.tencent.mm.plugin.finder.live.sidebar.d)com.tencent.mm.ui.component.k.nq((Context)localObject).q(com.tencent.mm.plugin.finder.live.sidebar.d.class)).DGD) {
      paramInt = 8;
    }
    this.DaP.setVisibility(paramInt);
    AppMethodBeat.o(355157);
  }
  
  private static int a(int paramInt1, int paramInt2, TextView paramTextView, String paramString)
  {
    int j = 0;
    AppMethodBeat.i(355031);
    int k = paramTextView.getPaddingLeft();
    int m = paramTextView.getPaddingRight();
    Object localObject = paramTextView.getParent();
    int i;
    if ((localObject instanceof ViewGroup))
    {
      localObject = (ViewGroup)localObject;
      if (localObject != null) {
        break label139;
      }
      i = 0;
      label50:
      localObject = paramTextView.getParent();
      if (!(localObject instanceof ViewGroup)) {
        break label149;
      }
      localObject = (ViewGroup)localObject;
      label71:
      if (localObject != null) {
        break label155;
      }
    }
    for (;;)
    {
      paramInt1 = paramInt1 - paramInt2 - k - m - i - j - 6;
      if (paramInt1 <= 0) {
        break label165;
      }
      paramInt1 = new StaticLayout((CharSequence)paramString, paramTextView.getPaint(), paramInt1, Layout.Alignment.ALIGN_NORMAL, 1.0F, 1.0F, true).getLineCount();
      AppMethodBeat.o(355031);
      return paramInt1;
      localObject = null;
      break;
      label139:
      i = ((ViewGroup)localObject).getPaddingLeft();
      break label50;
      label149:
      localObject = null;
      break label71;
      label155:
      j = ((ViewGroup)localObject).getPaddingRight();
    }
    label165:
    AppMethodBeat.o(355031);
    return 2147483647;
  }
  
  private final void a(ObjectAnimator paramObjectAnimator, final ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(354921);
    if (paramObjectAnimator != null) {
      paramObjectAnimator.addListener((Animator.AnimatorListener)new m(this, paramViewGroup));
    }
    AppMethodBeat.o(354921);
  }
  
  private final void a(ObjectAnimator paramObjectAnimator, final ViewGroup paramViewGroup, final boolean paramBoolean)
  {
    AppMethodBeat.i(354908);
    if (paramObjectAnimator != null) {
      paramObjectAnimator.addListener((Animator.AnimatorListener)new l(this, paramViewGroup, paramBoolean));
    }
    AppMethodBeat.o(354908);
  }
  
  private final void a(ViewGroup paramViewGroup, Rect paramRect, com.tencent.mm.plugin.finder.live.viewmodel.data.h paramh)
  {
    String str = null;
    AppMethodBeat.i(355132);
    if (paramViewGroup == null)
    {
      AppMethodBeat.o(355132);
      return;
    }
    Object localObject1 = paramViewGroup.getLayoutParams();
    if (localObject1 == null)
    {
      paramViewGroup = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(355132);
      throw paramViewGroup;
    }
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localObject1;
    paramViewGroup.measure(View.MeasureSpec.makeMeasureSpec(paramRect.width(), -2147483648), View.MeasureSpec.makeMeasureSpec(paramRect.height(), -2147483648));
    localMarginLayoutParams.topMargin = (paramRect.bottom - paramViewGroup.getMeasuredHeight());
    paramViewGroup.setTag(paramRect);
    localObject1 = (b)this.DaY.get(paramViewGroup);
    if (localObject1 != null) {
      ((b)localObject1).DbB.DbU = paramRect.width();
    }
    label167:
    label179:
    Object localObject2;
    if ((paramh != null) && (paramh.mXM == 2))
    {
      i = 1;
      if (i == 0)
      {
        if ((paramh == null) || (paramh.mXM != 1)) {
          break label272;
        }
        i = 1;
        if (i != 0)
        {
          if (paramh != null) {
            break label278;
          }
          localObject1 = null;
          localObject2 = getBuContext();
          if (localObject2 != null) {
            break label287;
          }
          label190:
          if (Util.isEqual((String)localObject1, str)) {}
        }
        else
        {
          if ((paramh == null) || (paramh.EbD != true)) {
            break label315;
          }
        }
      }
    }
    label272:
    label278:
    label287:
    label315:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        localMarginLayoutParams.topMargin -= (int)Dbm;
      }
      localMarginLayoutParams.setMarginStart(paramRect.left + (int)paramViewGroup.getContext().getResources().getDimension(p.c.Edge_A));
      AppMethodBeat.o(355132);
      return;
      i = 0;
      break;
      i = 0;
      break label167;
      localObject1 = paramh.mXL;
      break label179;
      localObject2 = (e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject2).business(e.class);
      if (localObject2 == null) {
        break label190;
      }
      str = ((e)localObject2).eyF();
      break label190;
    }
  }
  
  private final void a(final ViewGroup paramViewGroup, final s.b paramb)
  {
    AppMethodBeat.i(354944);
    if ((paramViewGroup == null) || (paramb == null))
    {
      AppMethodBeat.o(354944);
      return;
    }
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new n(this, paramViewGroup, paramb));
    AppMethodBeat.o(354944);
  }
  
  private final void a(b paramb)
  {
    AppMethodBeat.i(355141);
    if (paramb == null)
    {
      AppMethodBeat.o(355141);
      return;
    }
    if ((paramb.Dbt.get()) && (paramb.Dbv.get()) && (!paramb.DbI)) {
      b(paramb);
    }
    AppMethodBeat.o(355141);
  }
  
  private final void a(s.b paramb)
  {
    String str = null;
    AppMethodBeat.i(355048);
    Object localObject1;
    Object localObject3;
    Object localObject2;
    if (paramb == null)
    {
      localObject1 = null;
      localObject3 = new StringBuilder("showFullScreenPreciousGift giftId:").append(localObject1).append(" targetUsername:");
      if (paramb != null) {
        break label220;
      }
      localObject2 = null;
      label44:
      localObject3 = ((StringBuilder)localObject3).append(localObject2).append(" curPkUser:");
      localObject2 = ((j)business(j.class)).Efv;
      if (localObject2 != null) {
        break label229;
      }
      localObject2 = null;
      label82:
      Log.i("Finder.FinderLiveGiftQueuePlugin", localObject2);
      if (paramb != null) {
        break label239;
      }
      localObject2 = null;
      label105:
      localObject3 = ((j)business(j.class)).Efv;
      if (localObject3 != null) {
        break label248;
      }
      label125:
      if (!Util.isEqual((String)localObject2, str))
      {
        localObject2 = new Bundle();
        ((Bundle)localObject2).putString("PARAM_LIVE_GIFT_INFO", (String)localObject1);
        ((Bundle)localObject2).putBoolean("PARAM_LIVE_GIFT_IS_FORCE_REPLACE", true);
        if (paramb != null) {
          break label258;
        }
      }
    }
    label258:
    for (boolean bool = false;; bool = paramb.Dbw)
    {
      ((Bundle)localObject2).putBoolean("PARAM_LIVE_GIFT_IS_FROM_SELF", bool);
      this.nfT.statusChange(b.c.nds, (Bundle)localObject2);
      AppMethodBeat.o(355048);
      return;
      localObject1 = paramb.DJn;
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = ((bek)localObject1).ZOC;
      break;
      label220:
      localObject2 = paramb.DbG;
      break label44;
      label229:
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject2).username;
      break label82;
      label239:
      localObject2 = paramb.DbG;
      break label105;
      label248:
      str = ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject3).username;
      break label125;
    }
  }
  
  private static void a(String paramString, b paramb, int paramInt)
  {
    AppMethodBeat.i(355067);
    Object localObject = com.tencent.d.a.a.a.a.a.ahiX;
    long l2 = ((Number)com.tencent.d.a.a.a.a.a.jSx().bmg()).longValue();
    localObject = q.CFU;
    localObject = (Long)q.ekM().get(paramString);
    if (localObject == null) {}
    for (long l1 = l2;; l1 = ((Long)localObject).longValue() / 1000L)
    {
      long l3 = l1;
      if (0L == l1)
      {
        localObject = q.CFU;
        Log.i("Finder.FinderLiveGiftQueuePlugin", kotlin.g.b.s.X("updatePreciousGiftTotalShowingTime: giftFullPagDurationMap value = ", q.ekM().get(paramString)));
        l3 = l2;
      }
      paramb.DbD += paramInt * l3;
      Log.i("Finder.FinderLiveGiftQueuePlugin", "updatePreciousGiftTotalShowingTime: giftId=" + paramString + ", durationMs=" + l3 + ", totalShowingTime=" + paramb.DbD);
      AppMethodBeat.o(355067);
      return;
    }
  }
  
  private final void a(boolean paramBoolean, c paramc)
  {
    int j = 0;
    AppMethodBeat.i(355039);
    Object localObject = paramc.CAn.getLayoutParams();
    label61:
    label91:
    label105:
    float f;
    if ((localObject instanceof ViewGroup.MarginLayoutParams))
    {
      localObject = (ViewGroup.MarginLayoutParams)localObject;
      if (localObject != null)
      {
        if (!paramBoolean) {
          break label210;
        }
        i = (int)this.mJe.getContext().getResources().getDimension(p.c.Edge_2_5_A);
        ((ViewGroup.MarginLayoutParams)localObject).width = i;
        if (!paramBoolean) {
          break label232;
        }
        i = (int)this.mJe.getContext().getResources().getDimension(p.c.Edge_2_5_A);
        ((ViewGroup.MarginLayoutParams)localObject).height = i;
        if (!paramBoolean) {
          break label254;
        }
        i = 0;
        ((ViewGroup.MarginLayoutParams)localObject).setMarginStart(i);
      }
      localObject = paramc.DbX;
      if (!paramBoolean) {
        break label276;
      }
      f = 14.0F;
      label126:
      ((FinderLiveGiftTextView)localObject).setTextSize(1, f);
      localObject = paramc.DbX.getLayoutParams();
      if (!(localObject instanceof ViewGroup.MarginLayoutParams)) {
        break label283;
      }
      localObject = (ViewGroup.MarginLayoutParams)localObject;
      label157:
      if (localObject != null) {
        if (!paramBoolean) {
          break label289;
        }
      }
    }
    label276:
    label283:
    label289:
    for (int i = j;; i = (int)this.mJe.getContext().getResources().getDimension(p.c.Edge_0_5_A))
    {
      ((ViewGroup.MarginLayoutParams)localObject).setMarginStart(i);
      paramc.AhP.getLayoutParams().width = kotlin.k.k.qv(paramc.DbU, Dbp);
      AppMethodBeat.o(355039);
      return;
      localObject = null;
      break;
      label210:
      i = (int)this.mJe.getContext().getResources().getDimension(p.c.Edge_5A);
      break label61;
      label232:
      i = (int)this.mJe.getContext().getResources().getDimension(p.c.Edge_5A);
      break label91;
      label254:
      i = (int)this.mJe.getContext().getResources().getDimension(p.c.Edge_0_5_A);
      break label105;
      f = 17.0F;
      break label126;
      localObject = null;
      break label157;
    }
  }
  
  private static final boolean a(aw paramaw, Message paramMessage)
  {
    Object localObject = null;
    AppMethodBeat.i(355163);
    kotlin.g.b.s.u(paramaw, "this$0");
    kotlin.g.b.s.u(paramMessage, "it");
    paramMessage = paramMessage.obj;
    ObjectAnimator localObjectAnimator;
    if ((paramMessage instanceof ViewGroup))
    {
      paramMessage = (ViewGroup)paramMessage;
      localObjectAnimator = (ObjectAnimator)paramaw.Dba.get(paramMessage);
      paramMessage = new StringBuilder("preciousGiftBulletOutHandler: container:").append(paramMessage).append(", animator.isRunning:");
      if (localObjectAnimator != null) {
        break label122;
      }
    }
    label122:
    for (paramaw = localObject;; paramaw = Boolean.valueOf(localObjectAnimator.isRunning()))
    {
      Log.i("Finder.FinderLiveGiftQueuePlugin", paramaw);
      if ((localObjectAnimator != null) && (!localObjectAnimator.isRunning())) {
        localObjectAnimator.start();
      }
      AppMethodBeat.o(355163);
      return true;
      paramMessage = null;
      break;
    }
  }
  
  private final void b(final ViewGroup paramViewGroup, final s.b paramb)
  {
    AppMethodBeat.i(354957);
    if ((paramViewGroup == null) || (paramb == null))
    {
      AppMethodBeat.o(354957);
      return;
    }
    Log.i("Finder.FinderLiveGiftQueuePlugin", "replaceBullet, originSpace BulletShowingInfo=" + this.DaY.get(paramViewGroup) + ", giftShowInfo=" + paramb);
    final ah.f localf = new ah.f();
    localf.aqH = paramViewGroup;
    Object localObject2 = paramb.DbG;
    Object localObject1 = (b)this.DaY.get(paramViewGroup);
    if (localObject1 == null) {
      localObject1 = null;
    }
    while (!((String)localObject2).equals(localObject1))
    {
      localObject2 = this.DaY;
      localObject1 = new LinkedHashMap();
      localObject2 = ((Map)localObject2).entrySet().iterator();
      for (;;)
      {
        if (((Iterator)localObject2).hasNext())
        {
          localObject3 = (Map.Entry)((Iterator)localObject2).next();
          if (((b)((Map.Entry)localObject3).getValue()).DbG.equals(paramb.DbG))
          {
            ((LinkedHashMap)localObject1).put(((Map.Entry)localObject3).getKey(), ((Map.Entry)localObject3).getValue());
            continue;
            localObject1 = ((b)localObject1).DbG;
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
        AppMethodBeat.o(354957);
        return;
      }
      localf.aqH = ((List)localObject1).get(0);
    }
    if (!kotlin.g.b.s.p(localf.aqH, paramViewGroup))
    {
      Log.i("Finder.FinderLiveGiftQueuePlugin", kotlin.g.b.s.X("replaceBullet, targetSpace BulletShowingInfo=", this.DaY.get(localf.aqH)));
      localObject1 = (b)this.DaY.get(paramViewGroup);
      if (localObject1 != null) {
        ((b)localObject1).reset();
      }
    }
    localObject1 = (b)this.DaY.get(localf.aqH);
    if (localObject1 != null) {
      ((b)localObject1).reset();
    }
    localObject1 = (b)this.DaY.get(localf.aqH);
    if (localObject1 != null) {
      ((b)localObject1).Dbt.getAndSet(true);
    }
    localObject1 = (b)this.DaY.get(localf.aqH);
    if (localObject1 != null) {
      ((b)localObject1).Dbv.getAndSet(paramb.DJp);
    }
    Object localObject3 = (b)this.DaY.get(localf.aqH);
    if (localObject3 != null)
    {
      localObject2 = paramb.Dbx;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      ((b)localObject3).awV((String)localObject1);
    }
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new o(this, localf, paramViewGroup, paramb));
    AppMethodBeat.o(354957);
  }
  
  private static void b(TextView paramTextView, boolean paramBoolean)
  {
    AppMethodBeat.i(354967);
    paramTextView = paramTextView.getLayoutParams();
    if ((paramTextView instanceof ViewGroup.MarginLayoutParams))
    {
      paramTextView = (ViewGroup.MarginLayoutParams)paramTextView;
      if (paramTextView != null) {
        if (!paramBoolean) {
          break label52;
        }
      }
    }
    label52:
    for (int i = Dbo;; i = Dbn)
    {
      paramTextView.leftMargin = i;
      AppMethodBeat.o(354967);
      return;
      paramTextView = null;
      break;
    }
  }
  
  private final void b(b paramb)
  {
    AppMethodBeat.i(355150);
    if (!paramb.Dbv.get())
    {
      AppMethodBeat.o(355150);
      return;
    }
    Log.i("Finder.FinderLiveGiftQueuePlugin", kotlin.g.b.s.X("cloneToFakeContainer: origin info = ", paramb));
    Object localObject = (b)this.DaY.get(this.DaW);
    if (localObject != null)
    {
      ((b)localObject).DbD = paramb.DbD;
      ((b)localObject).DbE = paramb.DbE;
      ((b)localObject).Dbt.getAndSet(true);
      if (this.timer.stopped())
      {
        localObject = p.A((Iterable)this.DaY.entrySet()).iterator();
        do
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          paramb = ((Iterator)localObject).next();
        } while (!kotlin.g.b.s.p(((Map.Entry)paramb).getKey(), this.DaW));
      }
    }
    for (;;)
    {
      l((Map.Entry)paramb);
      AppMethodBeat.o(355150);
      return;
      paramb = null;
    }
  }
  
  private final void equ()
  {
    Object localObject4;
    Object localObject5;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(354941);
        Object localObject1 = eqv();
        if (localObject1 != null)
        {
          i = 1;
          if ((i != 0) && (localObject1 != null) && (!((b)((Map.Entry)localObject1).getValue()).Dbw)) {
            break label143;
          }
          localObject4 = this.DaY;
          localObject1 = new LinkedHashMap();
          localObject4 = ((Map)localObject4).entrySet().iterator();
          if (!((Iterator)localObject4).hasNext()) {
            break;
          }
          localObject5 = (Map.Entry)((Iterator)localObject4).next();
          if (!((b)((Map.Entry)localObject5).getValue()).DbH.get()) {
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
      localObject4 = this.DaO.euw();
      if ((localObject4 != null) && (((s.c)localObject4).compareTo((Enum)s.c.DJs) < 0)) {
        b((ViewGroup)localObject2.getKey(), this.DaO.eux());
      }
    }
    Iterator localIterator = ((Map)localObject2).entrySet().iterator();
    label320:
    boolean bool;
    label332:
    Object localObject3;
    label431:
    label449:
    label477:
    Object localObject6;
    b localb;
    while (localIterator.hasNext())
    {
      localObject4 = (Map.Entry)localIterator.next();
      Log.i("Finder.FinderLiveGiftQueuePlugin", "pollNextGiftShowInfo: index = " + ((b)((Map.Entry)localObject4).getValue()).index + ", current bulletInfo = " + this.DaY + ", current gift queue size: " + this.DaO.size());
      if (!this.DaO.hasNext())
      {
        AppMethodBeat.o(354941);
        return;
      }
      if (eqv() == null) {
        break label1102;
      }
      bool = true;
      Log.i("Finder.FinderLiveGiftQueuePlugin", kotlin.g.b.s.X("pollNextGiftShowInfo: isPreciousGiftShowing = ", Boolean.valueOf(bool)));
      if ((this.Dbd.containsValue(((Map.Entry)localObject4).getKey())) && (!bool))
      {
        if ((localObject4 == null) || (!((b)((Map.Entry)localObject4).getValue()).Dbt.get()) || (((b)((Map.Entry)localObject4).getValue()).Dbw)) {
          break label1085;
        }
        if (((b)((Map.Entry)localObject4).getValue()).Dbv.get()) {
          break label1085;
        }
      }
      else
      {
        for (;;)
        {
          Log.i("Finder.FinderLiveGiftQueuePlugin", kotlin.g.b.s.X("checkIfOuterSpacePreciousGiftForceReplace: entry fail, ", localObject2));
          i = 0;
          break label1095;
          localObject5 = this.DaY;
          localObject3 = new LinkedHashMap();
          localObject5 = ((Map)localObject5).entrySet().iterator();
          while (((Iterator)localObject5).hasNext())
          {
            localObject6 = (Map.Entry)((Iterator)localObject5).next();
            localb = (b)((Map.Entry)localObject6).getValue();
            if ((!localb.DbH.get()) || (!localb.Dbt.get())) {
              break label1107;
            }
            i = 1;
            label535:
            if (i == 0) {
              break label1110;
            }
            ((LinkedHashMap)localObject3).put(((Map.Entry)localObject6).getKey(), ((Map.Entry)localObject6).getValue());
          }
          label561:
          localObject3 = (b)((Map.Entry)localObject4).getValue();
        }
      }
      localObject3 = this.DaO.axO(((b)((Map.Entry)localObject4).getValue()).DbG);
      if (localObject3 == null)
      {
        i = 0;
        break label1095;
      }
      if (!((s.b)localObject3).DJp)
      {
        i = 0;
        break label1095;
      }
      b((ViewGroup)((Map.Entry)localObject4).getKey(), (s.b)localObject3);
      this.DaO.c((s.b)localObject3);
      i = 1;
      break label1095;
      localObject3 = ((Map)localObject3).entrySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject5 = (Map.Entry)((Iterator)localObject3).next();
        localObject6 = this.DaO.axQ(((b)((Map.Entry)localObject5).getValue()).Dbx);
        if (localObject6 != null) {
          a((ViewGroup)((Map.Entry)localObject5).getKey(), (s.b)localObject6);
        }
      }
      if (!((b)((Map.Entry)localObject4).getValue()).Dbt.get())
      {
        if (bool) {}
        for (localObject3 = this.DaO.axN(((b)((Map.Entry)localObject4).getValue()).DbG);; localObject3 = this.DaO.axO(((b)((Map.Entry)localObject4).getValue()).DbG))
        {
          if (localObject3 == null) {
            break label884;
          }
          Log.i("Finder.FinderLiveGiftQueuePlugin", kotlin.g.b.s.X("pollNextGiftShowInfo: giftShowInfo = ", localObject3));
          if (((b)((Map.Entry)localObject4).getValue()).DbC)
          {
            if (bool) {
              break;
            }
            if (localObject3 != null) {
              break label886;
            }
            bool = false;
            break label1112;
          }
          label825:
          localObject6 = (ViewGroup)((Map.Entry)localObject4).getKey();
          if ((localObject6 != null) && (localObject3 != null)) {
            break label894;
          }
          label846:
          this.DaO.c((s.b)localObject3);
          break;
        }
        label884:
        continue;
        label886:
        bool = ((s.b)localObject3).DJp;
        break label1112;
        label894:
        localObject4 = (b)this.DaY.get(localObject6);
        if ((localObject4 == null) || (true != ((b)localObject4).Dbt.get())) {
          break label1119;
        }
      }
    }
    label1085:
    label1095:
    label1102:
    label1107:
    label1110:
    label1112:
    label1119:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        a((ViewGroup)localObject6, (s.b)localObject3);
        break label846;
      }
      localObject4 = (b)this.DaY.get(localObject6);
      if (localObject4 != null) {
        ((b)localObject4).Dbt.getAndSet(true);
      }
      localObject4 = (b)this.DaY.get(localObject6);
      if (localObject4 != null) {
        ((b)localObject4).Dbv.getAndSet(((s.b)localObject3).DJp);
      }
      localb = (b)this.DaY.get(localObject6);
      if (localb != null)
      {
        localObject5 = ((s.b)localObject3).Dbx;
        localObject4 = localObject5;
        if (localObject5 == null) {
          localObject4 = "";
        }
        localb.awV((String)localObject4);
      }
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new j((ViewGroup)localObject6, this, (s.b)localObject3));
      break label846;
      AppMethodBeat.o(354941);
      break label320;
      if (localObject4 != null) {
        break label561;
      }
      localObject3 = null;
      break label431;
      if (i != 0) {
        break;
      }
      break label449;
      bool = false;
      break label332;
      i = 0;
      break label535;
      break label477;
      if (!bool) {
        break;
      }
      break label825;
    }
  }
  
  private final Map.Entry<ViewGroup, b> eqv()
  {
    AppMethodBeat.i(355075);
    Object localObject = kotlin.m.k.d(kotlin.m.k.a(ak.dz(this.DaY), (kotlin.g.a.b)i.Dcb));
    if (!((Collection)localObject).isEmpty()) {}
    for (int i = 1; i != 0; i = 0)
    {
      localObject = (Map.Entry)((List)localObject).get(0);
      AppMethodBeat.o(355075);
      return localObject;
    }
    AppMethodBeat.o(355075);
    return null;
  }
  
  private final ObjectAnimator f(final ViewGroup paramViewGroup, boolean paramBoolean)
  {
    AppMethodBeat.i(354900);
    ObjectAnimator localObjectAnimator;
    if (paramBoolean)
    {
      localObjectAnimator = ObjectAnimator.ofFloat(paramViewGroup, "alpha", new float[] { 0.0F, 1.0F });
      localObjectAnimator.setDuration(Dbh + 500);
      if (!paramBoolean) {
        break label114;
      }
      localObjectAnimator.setEvaluator((TypeEvaluator)new aw.a(Dbh, (m)new g(this, paramViewGroup)));
    }
    for (;;)
    {
      kotlin.g.b.s.s(localObjectAnimator, "bulletInAnim");
      AppMethodBeat.o(354900);
      return localObjectAnimator;
      localObjectAnimator = ObjectAnimator.ofFloat(paramViewGroup, "translationX", new float[] { -500.0F, 0.0F });
      break;
      label114:
      localObjectAnimator.setInterpolator((TimeInterpolator)new DecelerateInterpolator());
      localObjectAnimator.setEvaluator((TypeEvaluator)new com.tencent.mm.plugin.finder.live.widget.a(Dbh, (m)new h(this, paramViewGroup)));
    }
  }
  
  private final boolean l(Map.Entry<? extends ViewGroup, b> paramEntry)
  {
    AppMethodBeat.i(355082);
    Object localObject = paramEntry;
    if (paramEntry == null) {
      localObject = eqv();
    }
    if (localObject == null)
    {
      AppMethodBeat.o(355082);
      return false;
    }
    long l = ((b)((Map.Entry)localObject).getValue()).DbD - (cn.bDw() - ((b)((Map.Entry)localObject).getValue()).DbE);
    Log.i("Finder.FinderLiveGiftQueuePlugin", "checkIfPreciousGiftTimeOver: remainingTime=" + l + ", entry=" + localObject);
    if (l > 100L)
    {
      this.timer.startTimer(l);
      AppMethodBeat.o(355082);
      return true;
    }
    b.b.a(this.nfT, b.c.ndt);
    ((b)((Map.Entry)localObject).getValue()).DbD = 0L;
    ((b)((Map.Entry)localObject).getValue()).DbE = 0L;
    if (((b)((Map.Entry)localObject).getValue()).DbI)
    {
      Log.i("Finder.FinderLiveGiftQueuePlugin", "checkIfPreciousGiftTimeOver: fake container");
      ((b)((Map.Entry)localObject).getValue()).Dbt.getAndSet(false);
      equ();
    }
    for (;;)
    {
      AppMethodBeat.o(355082);
      return false;
      if (this.Dbf)
      {
        Log.i("Finder.FinderLiveGiftQueuePlugin", "checkIfPreciousGiftTimeOver: preciousGiftBulletOutHandlerProcessing is true, skip");
      }
      else
      {
        this.Dbf = true;
        paramEntry = this.Dbe.obtainMessage();
        paramEntry.obj = ((Map.Entry)localObject).getKey();
        this.Dbe.sendMessageDelayed(paramEntry, 2000L);
        Log.i("Finder.FinderLiveGiftQueuePlugin", kotlin.g.b.s.X("checkIfPreciousGiftTimeOver: handler msg.obj = ", paramEntry.obj));
      }
    }
  }
  
  private static ObjectAnimator z(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(354912);
    paramViewGroup = ObjectAnimator.ofFloat(paramViewGroup, "alpha", new float[] { 1.0F, 0.0F });
    paramViewGroup.setDuration(500L);
    kotlin.g.b.s.s(paramViewGroup, "bulletOutAnim");
    AppMethodBeat.o(354912);
    return paramViewGroup;
  }
  
  public final void a(s.c paramc)
  {
    AppMethodBeat.i(355313);
    kotlin.g.b.s.u(paramc, "giftType");
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new k(this));
    equ();
    AppMethodBeat.o(355313);
  }
  
  public final void a(LinkedHashMap<String, Rect> paramLinkedHashMap, boolean paramBoolean)
  {
    AppMethodBeat.i(355347);
    kotlin.g.b.s.u(paramLinkedHashMap, "micUserMap");
    List localList = ((j)business(j.class)).Efw;
    com.tencent.mm.plugin.finder.live.viewmodel.data.h localh = ((j)business(j.class)).Efv;
    Log.i("Finder.FinderLiveGiftQueuePlugin", "onMicUserChanged: micUserMap size:" + paramLinkedHashMap.size() + ", audienceLinkMicUserList size:" + localList.size() + ", pkMicUser:" + localh);
    if (paramLinkedHashMap.size() <= 1)
    {
      paramLinkedHashMap = ((Map)this.Dbd).entrySet().iterator();
      while (paramLinkedHashMap.hasNext()) {
        B((ViewGroup)((Map.Entry)paramLinkedHashMap.next()).getValue());
      }
      this.Dbd.clear();
      AppMethodBeat.o(355347);
      return;
    }
    OZ(0);
    Object localObject3 = ((Map)this.Dbd).entrySet().iterator();
    Object localObject4;
    Object localObject5;
    Object localObject1;
    label264:
    int i;
    label277:
    label307:
    label441:
    label443:
    label451:
    label453:
    label457:
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (ViewGroup)((Map.Entry)((Iterator)localObject3).next()).getValue();
      localObject5 = (b)this.DaY.get(localObject4);
      if (localh != null)
      {
        localObject2 = localh.username;
        if (localObject2 != null) {
          if (localObject5 == null)
          {
            localObject1 = null;
            if (((String)localObject2).equals(localObject1) != true) {
              break label428;
            }
            i = 1;
            if (i != 0) {
              break label431;
            }
            localObject2 = (CharSequence)((e)business(e.class)).mIC;
            if (localObject5 != null) {
              break label433;
            }
            localObject1 = null;
            if (TextUtils.equals((CharSequence)localObject2, (CharSequence)localObject1)) {
              break label441;
            }
            kotlin.g.b.s.s(localList, "linkMicList");
            Iterator localIterator = ((Iterable)localList).iterator();
            label340:
            if (!localIterator.hasNext()) {
              break label453;
            }
            localObject2 = localIterator.next();
            CharSequence localCharSequence = (CharSequence)((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject2).username;
            if (localObject5 != null) {
              break label443;
            }
            localObject1 = null;
            label380:
            if (!TextUtils.equals(localCharSequence, (CharSequence)localObject1)) {
              break label451;
            }
          }
        }
      }
      for (localObject1 = localObject2;; localObject1 = null)
      {
        if (localObject1 != null) {
          break label457;
        }
        B((ViewGroup)localObject4);
        ((Iterator)localObject3).remove();
        break;
        localObject1 = ((b)localObject5).DbG;
        break label264;
        i = 0;
        break label277;
        break;
        localObject1 = ((b)localObject5).DbG;
        break label307;
        break;
        localObject1 = ((b)localObject5).DbG;
        break label380;
        break label340;
      }
    }
    label428:
    label431:
    label433:
    Object localObject2 = ((Map)paramLinkedHashMap).entrySet().iterator();
    if (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Map.Entry)((Iterator)localObject2).next();
      localObject1 = ((Map.Entry)localObject3).getKey();
      if (localh == null) {}
      for (paramLinkedHashMap = null;; paramLinkedHashMap = localh.mXL)
      {
        if (!kotlin.g.b.s.p(localObject1, paramLinkedHashMap)) {
          break label605;
        }
        paramLinkedHashMap = localh;
        if (!this.Dbd.containsKey(((Map.Entry)localObject3).getKey())) {
          break label683;
        }
        Log.i("Finder.FinderLiveGiftQueuePlugin", kotlin.g.b.s.X("onMicUserChanged: adjustContainerLocation, sdkUserId = ", ((Map.Entry)localObject3).getKey()));
        a((ViewGroup)this.Dbd.get(((Map.Entry)localObject3).getKey()), (Rect)((Map.Entry)localObject3).getValue(), paramLinkedHashMap);
        break;
      }
      label605:
      kotlin.g.b.s.s(localList, "linkMicList");
      localObject1 = ((Iterable)localList).iterator();
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        paramLinkedHashMap = ((Iterator)localObject1).next();
        localObject4 = (com.tencent.mm.plugin.finder.live.viewmodel.data.h)paramLinkedHashMap;
      } while (!((String)((Map.Entry)localObject3).getKey()).equals(((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject4).mXL));
      for (;;)
      {
        paramLinkedHashMap = (com.tencent.mm.plugin.finder.live.viewmodel.data.h)paramLinkedHashMap;
        break;
        paramLinkedHashMap = null;
      }
      label683:
      localObject1 = (Rect)((Map.Entry)localObject3).getValue();
      localObject5 = this.DaP;
      localObject4 = LayoutInflater.from(((ViewGroup)localObject5).getContext()).inflate(p.f.CdV, (ViewGroup)localObject5, false);
      if (localObject4 == null)
      {
        paramLinkedHashMap = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(355347);
        throw paramLinkedHashMap;
      }
      localObject4 = (ViewGroup)localObject4;
      ((ViewGroup)localObject5).addView((View)localObject4);
      a((ViewGroup)localObject4, (Rect)localObject1, paramLinkedHashMap);
      ((ViewGroup)localObject4).setVisibility(8);
      if (paramLinkedHashMap == null)
      {
        paramLinkedHashMap = null;
        label783:
        if (paramLinkedHashMap != null) {
          break label1196;
        }
        paramLinkedHashMap = ((e)business(e.class)).mIC;
        label801:
        i = ((Rect)((Map.Entry)localObject3).getValue()).width();
        if (this.DaY.size() == this.DaX)
        {
          Log.i("Finder.FinderLiveGiftQueuePlugin", "registerOuterSpace: disable origin three container");
          localObject1 = eqv();
          if (localObject1 != null) {
            break label1199;
          }
        }
      }
      label1196:
      label1199:
      for (localObject1 = null;; localObject1 = (b)((Map.Entry)localObject1).getValue())
      {
        a((b)localObject1);
        A((ViewGroup)this.DaT);
        A((ViewGroup)this.DaU);
        A((ViewGroup)this.DaV);
        localObject1 = this.DaY;
        localObject5 = new b((ViewGroup)localObject4, this.DaY.size(), this.DaQ, false, true, i, 8);
        ((b)localObject5).eqz();
        ((Map)localObject1).put(localObject4, localObject5);
        localObject1 = (b)this.DaY.get(localObject4);
        if (localObject1 != null) {
          ((b)localObject1).awW(paramLinkedHashMap);
        }
        Log.i("Finder.FinderLiveGiftQueuePlugin", kotlin.g.b.s.X("registerOuterSpace: info:", this.DaY.get(localObject4)));
        paramLinkedHashMap = this.DaZ;
        localObject1 = f((ViewGroup)localObject4, true);
        a((ObjectAnimator)localObject1, (ViewGroup)localObject4, true);
        paramLinkedHashMap.put(localObject4, localObject1);
        paramLinkedHashMap = this.Dba;
        localObject1 = z((ViewGroup)localObject4);
        a((ObjectAnimator)localObject1, (ViewGroup)localObject4);
        paramLinkedHashMap.put(localObject4, localObject1);
        paramLinkedHashMap = (b)this.DaY.get(localObject4);
        if (paramLinkedHashMap != null)
        {
          localObject1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
          com.tencent.mm.plugin.finder.live.utils.a.v((TextView)paramLinkedHashMap.DbB.DbX);
        }
        ((Map)this.Dbd).put(((Map.Entry)localObject3).getKey(), localObject4);
        Log.i("Finder.FinderLiveGiftQueuePlugin", "onMicUserChanged: outerSpaceMap add new entry, key = " + (String)((Map.Entry)localObject3).getKey() + ", value = " + localObject4 + ", outSpaceWidth:" + ((Rect)((Map.Entry)localObject3).getValue()).width());
        break;
        paramLinkedHashMap = paramLinkedHashMap.username;
        break label783;
        break label801;
      }
    }
    AppMethodBeat.o(355347);
  }
  
  public final boolean eoI()
  {
    return true;
  }
  
  public final boolean eoJ()
  {
    return true;
  }
  
  public final void eqw()
  {
    AppMethodBeat.i(355320);
    if (this.DaO.hasNext())
    {
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new f(this));
      equ();
    }
    AppMethodBeat.o(355320);
  }
  
  public final void mount()
  {
    AppMethodBeat.i(355280);
    Log.i("Finder.FinderLiveGiftQueuePlugin", "mount");
    super.mount();
    this.DaO.a((s.a)this);
    Iterator localIterator = ((Iterable)this.DaY.values()).iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).eqz();
    }
    localIterator = ((Iterable)this.DaZ.entrySet()).iterator();
    Object localObject1;
    if (localIterator.hasNext())
    {
      Object localObject2 = (Map.Entry)localIterator.next();
      localObject1 = (ObjectAnimator)((Map.Entry)localObject2).getValue();
      ViewGroup localViewGroup = (ViewGroup)((Map.Entry)localObject2).getKey();
      localObject2 = (b)this.DaY.get(((Map.Entry)localObject2).getKey());
      if (localObject2 == null) {}
      for (boolean bool = false;; bool = ((b)localObject2).Dbs)
      {
        a((ObjectAnimator)localObject1, localViewGroup, bool);
        break;
      }
    }
    localIterator = ((Iterable)this.Dba.entrySet()).iterator();
    while (localIterator.hasNext())
    {
      localObject1 = (Map.Entry)localIterator.next();
      a((ObjectAnimator)((Map.Entry)localObject1).getValue(), (ViewGroup)((Map.Entry)localObject1).getKey());
    }
    AppMethodBeat.o(355280);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    int i = 1;
    AppMethodBeat.i(371498);
    kotlin.g.b.s.u(paramc, "status");
    super.statusChange(paramc, paramBundle);
    if (aw.s.$EnumSwitchMapping$0[paramc.ordinal()] == 1)
    {
      if ((paramBundle != null) && (paramBundle.getBoolean("isShow") == true)) {}
      while (i != 0)
      {
        tO(8);
        AppMethodBeat.o(371498);
        return;
        i = 0;
      }
      tO(0);
    }
    AppMethodBeat.o(371498);
  }
  
  public final void tO(int paramInt)
  {
    AppMethodBeat.i(355357);
    if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.s)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.s.class)).kLm())
    {
      super.tO(8);
      AppMethodBeat.o(355357);
      return;
    }
    super.tO(paramInt);
    Object localObject = com.tencent.mm.ui.component.k.aeZF;
    localObject = this.mJe.getContext();
    kotlin.g.b.s.s(localObject, "root.context");
    if (!((com.tencent.mm.plugin.finder.live.sidebar.d)com.tencent.mm.ui.component.k.nq((Context)localObject).q(com.tencent.mm.plugin.finder.live.sidebar.d.class)).DGD)
    {
      OZ(this.Dbg);
      AppMethodBeat.o(355357);
      return;
    }
    this.DaP.setVisibility(8);
    AppMethodBeat.o(355357);
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(355291);
    Log.i("Finder.FinderLiveGiftQueuePlugin", "unMount");
    super.unMount();
    this.timer.stopTimer();
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new q(this));
    this.DaO.b((s.a)this);
    Iterator localIterator = ((Iterable)this.DaY.values()).iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).eqA();
    }
    localIterator = ((Iterable)this.DaZ.entrySet()).iterator();
    while (localIterator.hasNext()) {
      ((ObjectAnimator)((Map.Entry)localIterator.next()).getValue()).removeAllListeners();
    }
    localIterator = ((Iterable)this.Dba.entrySet()).iterator();
    while (localIterator.hasNext()) {
      ((ObjectAnimator)((Map.Entry)localIterator.next()).getValue()).removeAllListeners();
    }
    AppMethodBeat.o(355291);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftQueuePlugin$BulletShowingInfo;", "", "container", "Landroid/view/ViewGroup;", "index", "", "isVisitor", "", "backup", "isOuterSpace", "outSpaceWidth", "(Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftQueuePlugin;Landroid/view/ViewGroup;IZZZI)V", "alpha1", "Landroid/animation/ObjectAnimator;", "value", "bulletFlying", "getBulletFlying", "()Z", "setBulletFlying", "(Z)V", "cntQueue", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "getCntQueue", "()Ljava/util/concurrent/ConcurrentLinkedDeque;", "setCntQueue", "(Ljava/util/concurrent/ConcurrentLinkedDeque;)V", "cntTransferAnimatorSet", "Landroid/animation/AnimatorSet;", "cntTransferAnimatorSetListener", "Landroid/animation/Animator$AnimatorListener;", "cntTransferAniming", "getCntTransferAniming", "setCntTransferAniming", "comboId", "", "getComboId", "()Ljava/lang/String;", "setComboId", "(Ljava/lang/String;)V", "comboSumCount", "getComboSumCount", "()I", "setComboSumCount", "(I)V", "enabled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getEnabled", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "setEnabled", "(Ljava/util/concurrent/atomic/AtomicBoolean;)V", "giftId", "getGiftId", "setGiftId", "getIndex", "isBackup", "setBackup", "isBulletInAnimationEnd", "setBulletInAnimationEnd", "isFakeContainer", "setFakeContainer", "isPreciousGift", "setPreciousGift", "isSelfSend", "setSelfSend", "isShowing", "setShowing", "lastCountOnBackToLive", "getLastCountOnBackToLive", "setLastCountOnBackToLive", "scalex1", "scaley1", "startShowingTime", "", "getStartShowingTime", "()J", "setStartShowingTime", "(J)V", "targetUserName", "getTargetUserName", "setTargetUserName", "totalShowingTime", "getTotalShowingTime", "setTotalShowingTime", "viewHolder", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftQueuePlugin$BulletViewHolder;", "getViewHolder", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftQueuePlugin$BulletViewHolder;", "registerCntTransferAnimatorSetListener", "", "reset", "saveBackToLiveInfo", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftQueuePlugin$ComboIdBackToLiveInfo;", "destinationCnt", "localSend", "startTransferCnt", "prefix", "toString", "unregisterCntTransferAnimatorSetListener", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  final class b
  {
    volatile int DbA;
    final aw.c DbB;
    boolean DbC;
    volatile long DbD;
    volatile long DbE;
    volatile String DbF;
    volatile String DbG;
    AtomicBoolean DbH;
    boolean DbI;
    AnimatorSet DbJ;
    private Animator.AnimatorListener DbK;
    final ObjectAnimator DbL;
    final ObjectAnimator DbM;
    final ObjectAnimator DbN;
    private volatile boolean DbO;
    volatile boolean DbP;
    final boolean Dbs;
    AtomicBoolean Dbt;
    volatile boolean Dbu;
    AtomicBoolean Dbv;
    volatile boolean Dbw;
    volatile String Dbx;
    volatile int Dby;
    private ConcurrentLinkedDeque<Integer> Dbz;
    final int index;
    
    private b(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt2)
    {
      AppMethodBeat.i(353606);
      this.index = paramBoolean1;
      this.Dbs = paramInt2;
      this.Dbt = new AtomicBoolean(false);
      this.Dbv = new AtomicBoolean(false);
      this.Dbx = "";
      this.Dbz = new ConcurrentLinkedDeque();
      int i;
      this.DbB = new aw.c(paramInt1, paramBoolean2, this.Dbs, i);
      this.DbC = paramBoolean3;
      this.DbF = "";
      this.DbG = ((e)aw.this.business(e.class)).mIC;
      this.DbH = new AtomicBoolean(true);
      this.DbJ = new AnimatorSet();
      this$1 = ObjectAnimator.ofFloat(this.DbB.DbX, "scaleX", new float[] { 0.0F, 1.1F }).setDuration(125L);
      kotlin.g.b.s.s(aw.this, "ofFloat(viewHolder.cntTv…f, 1.1f).setDuration(125)");
      this.DbL = aw.this;
      this$1 = ObjectAnimator.ofFloat(this.DbB.DbX, "scaleY", new float[] { 0.0F, 1.1F }).setDuration(125L);
      kotlin.g.b.s.s(aw.this, "ofFloat(viewHolder.cntTv…f, 1.1f).setDuration(125)");
      this.DbM = aw.this;
      this$1 = ObjectAnimator.ofFloat(this.DbB.DbX, "alpha", new float[] { 0.0F, 1.0F }).setDuration(208L);
      kotlin.g.b.s.s(aw.this, "ofFloat(viewHolder.cntTv…f, 1.0f).setDuration(208)");
      this.DbN = aw.this;
      this$1 = ObjectAnimator.ofFloat(this.DbB.DbX, "scaleX", new float[] { 1.1F, 1.0F }).setDuration(83L);
      kotlin.g.b.s.s(aw.this, "ofFloat(viewHolder.cntTv…1f, 1.0f).setDuration(83)");
      aw.this.setStartDelay(125L);
      paramInt1 = ObjectAnimator.ofFloat(this.DbB.DbX, "scaleY", new float[] { 1.1F, 1.0F }).setDuration(83L);
      kotlin.g.b.s.s(paramInt1, "ofFloat(viewHolder.cntTv…1f, 1.0f).setDuration(83)");
      paramInt1.setStartDelay(125L);
      this.DbB.DbX.setPivotX(0.0F);
      this.DbB.DbX.setPivotY(this.DbB.DbX.getMeasuredHeight());
      this.DbJ.playTogether(new Animator[] { (Animator)this.DbL, (Animator)this.DbM, (Animator)aw.this, (Animator)paramInt1, (Animator)this.DbN });
      AppMethodBeat.o(353606);
    }
    
    private void awX(String paramString)
    {
      AppMethodBeat.i(353623);
      kotlin.g.b.s.u(paramString, "prefix");
      boolean bool1 = this.Dbz.isEmpty();
      if ((bool1) || (this.DbO) || (this.DbP))
      {
        Log.i("Finder.FinderLiveGiftQueuePlugin", "startTransferCnt(" + paramString + ") cntQueueEmpty:" + bool1 + ",cntTransferAniming:" + this.DbO + ",bulletFlying:" + this.DbP);
        AppMethodBeat.o(353623);
        return;
      }
      Integer localInteger = (Integer)this.Dbz.pollFirst();
      if (localInteger == null) {}
      for (int i = this.Dby;; i = localInteger.intValue())
      {
        boolean bool2 = kotlin.g.b.s.p(this.DbB.DbX.getText(), kotlin.g.b.s.X("x", Integer.valueOf(i)));
        Log.i("Finder.FinderLiveGiftQueuePlugin", "startTransferCnt(" + paramString + ") number:" + i + ", sameValue:" + bool2 + ", cntQueueEmpty:" + bool1 + ",cntTransferAniming:" + this.DbO + ",bulletFlying:" + this.DbP);
        this.DbB.DbX.setText((CharSequence)kotlin.g.b.s.X("x", Integer.valueOf(i)));
        this.DbB.DbX.setTag(Integer.valueOf(i));
        this.DbB.DbX.setPivotX(0.0F);
        this.DbB.DbX.setPivotY(this.DbB.DbX.getMeasuredHeight());
        this.DbJ.start();
        aw.a(aw.this, bool2, this);
        AppMethodBeat.o(353623);
        return;
      }
    }
    
    private final aw.d eqB()
    {
      AppMethodBeat.i(353628);
      aw.d locald = new aw.d();
      locald.Dbv.getAndSet(this.Dbv.get());
      locald.hHq = this.Dbw;
      locald.Dby = this.Dby;
      locald.oVP = cn.bDw();
      locald.awY(this.DbF);
      AppMethodBeat.o(353628);
      return locald;
    }
    
    public final void aD(int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(353653);
      Object localObject = this.DbB.DbX.getTag();
      int i;
      label43:
      boolean bool;
      if ((localObject instanceof Integer))
      {
        localObject = (Integer)localObject;
        if (localObject != null) {
          break label107;
        }
        i = this.DbA;
        if (i > 0) {
          break label116;
        }
        bool = true;
        i = 1;
      }
      for (;;)
      {
        if (paramInt > i) {
          break label122;
        }
        this.DbB.DbX.setText((CharSequence)kotlin.g.b.s.X("x", Integer.valueOf(i)));
        this.DbB.DbX.setTag(Integer.valueOf(i));
        AppMethodBeat.o(353653);
        return;
        localObject = null;
        break;
        label107:
        i = ((Integer)localObject).intValue();
        break label43;
        label116:
        bool = false;
      }
      label122:
      localObject = new StringBuilder("localSend:" + paramBoolean + ",startCnt:" + i + ",lastCountOnBackToLive:" + this.DbA + ",firstGift:" + bool + ';');
      this.Dbz.clear();
      int j;
      if (!paramBoolean)
      {
        j = kotlin.k.k.qu(1, (int)Math.ceil((paramInt - i) / 5.0D));
        if (bool) {
          break label324;
        }
        i += j;
      }
      label324:
      for (;;)
      {
        if (i < paramInt)
        {
          this.Dbz.offer(Integer.valueOf(i));
          ((StringBuilder)localObject).append(i + ',');
          i += j;
        }
        else
        {
          this.Dbz.offer(Integer.valueOf(paramInt));
          ((StringBuilder)localObject).append(paramInt);
          Log.i("Finder.FinderLiveGiftQueuePlugin", kotlin.g.b.s.X("setCntQueue ", localObject));
          awX("setCntQueue");
          AppMethodBeat.o(353653);
          return;
        }
      }
    }
    
    public final void awV(String paramString)
    {
      AppMethodBeat.i(353632);
      kotlin.g.b.s.u(paramString, "<set-?>");
      this.Dbx = paramString;
      AppMethodBeat.o(353632);
    }
    
    public final void awW(String paramString)
    {
      AppMethodBeat.i(353638);
      kotlin.g.b.s.u(paramString, "<set-?>");
      this.DbG = paramString;
      AppMethodBeat.o(353638);
    }
    
    public final void eqA()
    {
      AppMethodBeat.i(353663);
      this.DbK = null;
      this.DbJ.removeAllListeners();
      AppMethodBeat.o(353663);
    }
    
    public final void eqz()
    {
      AppMethodBeat.i(353659);
      this.DbK = ((Animator.AnimatorListener)new a(this));
      this.DbJ.addListener(this.DbK);
      AppMethodBeat.o(353659);
    }
    
    public final void reset()
    {
      AppMethodBeat.i(353673);
      aw.b(aw.this).put(this.Dbx, eqB());
      com.tencent.mm.ae.d.e("giftQueueMapClear", (kotlin.g.a.a)new b(aw.this, this));
      final Integer localInteger = (Integer)this.Dbz.peekLast();
      if (localInteger != null) {
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new c(this, localInteger));
      }
      this.Dbt.getAndSet(false);
      this.Dbu = false;
      this.Dbv.getAndSet(false);
      this.Dbw = false;
      this.Dbx = "";
      this.Dby = 0;
      this.DbA = 0;
      this.Dbz.clear();
      this.DbD = 0L;
      this.DbE = 0L;
      this.DbF = "";
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new d(this));
      ro(false);
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new e(this));
      this.DbB.DbX.setTag(null);
      AppMethodBeat.o(353673);
    }
    
    public final void ro(boolean paramBoolean)
    {
      AppMethodBeat.i(353645);
      if (paramBoolean != this.DbO) {
        Log.i("Finder.FinderLiveGiftQueuePlugin", "cntTransferAniming origin value:" + this.DbO + ",value:" + paramBoolean);
      }
      this.DbO = paramBoolean;
      if (!this.DbO) {
        awX("cntTransferAnim end");
      }
      AppMethodBeat.o(353645);
    }
    
    public final void rp(boolean paramBoolean)
    {
      AppMethodBeat.i(353647);
      int j = 0;
      int i = j;
      if (paramBoolean != this.DbP)
      {
        Log.i("Finder.FinderLiveGiftQueuePlugin", "bulletFlying origin value:" + this.DbP + ",value:" + paramBoolean);
        i = j;
        if (!paramBoolean) {
          i = 1;
        }
      }
      this.DbP = paramBoolean;
      if (i != 0) {
        awX("bulletFlying Stop");
      }
      AppMethodBeat.o(353647);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(353685);
      String str = kotlin.g.b.s.X("index = ", Integer.valueOf(this.index)) + ", " + kotlin.g.b.s.X("giftId = ", this.DbF) + ", " + kotlin.g.b.s.X("isShowing = ", this.Dbt) + ", " + kotlin.g.b.s.X("isPreciousGift = ", this.Dbv) + ", " + kotlin.g.b.s.X("isAnimationEnd = ", Boolean.valueOf(this.Dbu)) + ", " + kotlin.g.b.s.X("comboId = ", this.Dbx) + ", " + kotlin.g.b.s.X("comboSumCount = ", Integer.valueOf(this.Dby)) + ", " + kotlin.g.b.s.X("lastCountOnBackToLive = ", Integer.valueOf(this.DbA)) + ", " + kotlin.g.b.s.X("totalShowingTime = ", Long.valueOf(this.DbD)) + ", " + kotlin.g.b.s.X("cntTransferAniming = ", Boolean.valueOf(this.DbO)) + ", " + kotlin.g.b.s.X("bulletFlying = ", Boolean.valueOf(this.DbP)) + ", " + kotlin.g.b.s.X("targetUserName = ", this.DbG) + ", " + kotlin.g.b.s.X("enabled = ", this.DbH);
      kotlin.g.b.s.s(str, "StringBuilder()\n        …              .toString()");
      AppMethodBeat.o(353685);
      return str;
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftQueuePlugin$BulletShowingInfo$registerCntTransferAnimatorSetListener$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "p0", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements Animator.AnimatorListener
    {
      a(aw.b paramb) {}
      
      public final void onAnimationCancel(Animator paramAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnimator)
      {
        AppMethodBeat.i(355062);
        this.DbR.ro(false);
        paramAnimator = this.DbR.DbN.getTarget();
        if ((paramAnimator instanceof View))
        {
          paramAnimator = (View)paramAnimator;
          if (paramAnimator != null) {
            paramAnimator.setAlpha(1.0F);
          }
          paramAnimator = this.DbR.DbL.getTarget();
          if (!(paramAnimator instanceof View)) {
            break label120;
          }
          paramAnimator = (View)paramAnimator;
          label68:
          if (paramAnimator != null) {
            paramAnimator.setScaleX(1.0F);
          }
          paramAnimator = this.DbR.DbM.getTarget();
          if (!(paramAnimator instanceof View)) {
            break label125;
          }
        }
        label120:
        label125:
        for (paramAnimator = (View)paramAnimator;; paramAnimator = null)
        {
          if (paramAnimator != null) {
            paramAnimator.setScaleY(1.0F);
          }
          AppMethodBeat.o(355062);
          return;
          paramAnimator = null;
          break;
          paramAnimator = null;
          break label68;
        }
      }
      
      public final void onAnimationRepeat(Animator paramAnimator) {}
      
      public final void onAnimationStart(Animator paramAnimator)
      {
        AppMethodBeat.i(355051);
        this.DbR.ro(true);
        AppMethodBeat.o(355051);
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends u
      implements kotlin.g.a.a<ah>
    {
      b(aw paramaw, aw.b paramb)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class c
      extends u
      implements kotlin.g.a.a<ah>
    {
      c(aw.b paramb, Integer paramInteger)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class d
      extends u
      implements kotlin.g.a.a<ah>
    {
      d(aw.b paramb)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class e
      extends u
      implements kotlin.g.a.a<ah>
    {
      e(aw.b paramb)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftQueuePlugin$BulletViewHolder;", "", "container", "Landroid/view/ViewGroup;", "isVisitor", "", "isOuterSpace", "outSpaceWidth", "", "(Landroid/view/ViewGroup;ZZI)V", "bgView", "Landroid/view/View;", "getBgView", "()Landroid/view/View;", "cntTv", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveGiftTextView;", "getCntTv", "()Lcom/tencent/mm/plugin/finder/live/view/FinderLiveGiftTextView;", "getContainer", "()Landroid/view/ViewGroup;", "descGroup", "Landroid/widget/LinearLayout;", "getDescGroup", "()Landroid/widget/LinearLayout;", "descWrapper", "getDescWrapper", "fromUserTv", "Landroid/widget/TextView;", "getFromUserTv", "()Landroid/widget/TextView;", "giftNameTv", "getGiftNameTv", "()Z", "getOutSpaceWidth", "()I", "setOutSpaceWidth", "(I)V", "pagView", "Lorg/libpag/PAGView;", "getPagView", "()Lorg/libpag/PAGView;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class c
  {
    final View AhP;
    final ViewGroup CAj;
    final PAGView CAn;
    int DbU;
    final TextView DbV;
    final TextView DbW;
    final FinderLiveGiftTextView DbX;
    final LinearLayout DbY;
    final LinearLayout DbZ;
    final boolean Dbs;
    
    public c(ViewGroup paramViewGroup, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
    {
      AppMethodBeat.i(353593);
      this.CAj = paramViewGroup;
      this.Dbs = paramBoolean2;
      this.DbU = paramInt;
      paramViewGroup = this.CAj.findViewById(p.e.BLt);
      kotlin.g.b.s.s(paramViewGroup, "container.findViewById(R…ft_bullut_desc_from_user)");
      this.DbV = ((TextView)paramViewGroup);
      paramViewGroup = this.CAj.findViewById(p.e.BLu);
      kotlin.g.b.s.s(paramViewGroup, "container.findViewById(R…ft_bullut_desc_gift_name)");
      this.DbW = ((TextView)paramViewGroup);
      paramViewGroup = this.CAj.findViewById(p.e.BLx);
      kotlin.g.b.s.s(paramViewGroup, "container.findViewById(R…der_live_gift_bullut_pag)");
      this.CAn = ((PAGView)paramViewGroup);
      paramViewGroup = this.CAj.findViewById(p.e.BLs);
      kotlin.g.b.s.s(paramViewGroup, "container.findViewById(R…_live_gift_bullut_cnt_tv)");
      this.DbX = ((FinderLiveGiftTextView)paramViewGroup);
      paramViewGroup = this.CAj.findViewById(p.e.BBO);
      kotlin.g.b.s.s(paramViewGroup, "container.findViewById(R.id.bg_view)");
      this.AhP = paramViewGroup;
      paramViewGroup = this.CAj.findViewById(p.e.BLw);
      kotlin.g.b.s.s(paramViewGroup, "container.findViewById(R…gift_bullut_desc_wrapper)");
      this.DbY = ((LinearLayout)paramViewGroup);
      paramViewGroup = this.CAj.findViewById(p.e.BLv);
      kotlin.g.b.s.s(paramViewGroup, "container.findViewById(R…e_gift_bullut_desc_group)");
      this.DbZ = ((LinearLayout)paramViewGroup);
      if (this.Dbs)
      {
        this.DbV.setTextSize(1, 12.0F);
        this.DbW.setTextSize(1, 12.0F);
        this.CAn.getLayoutParams().width = ((int)this.CAj.getContext().getResources().getDimension(p.c.Edge_5A));
        this.CAn.getLayoutParams().height = ((int)this.CAj.getContext().getResources().getDimension(p.c.Edge_5A));
        this.DbX.setTextSize(1, 17.0F);
        this.CAj.getLayoutParams().height = ((int)this.CAj.getContext().getResources().getDimension(p.c.Edge_5A));
        paramViewGroup = this.CAj.findViewById(p.e.BBO);
        if (paramViewGroup == null)
        {
          paramViewGroup = null;
          if (paramViewGroup != null) {
            paramViewGroup.width = aw.eqx();
          }
          paramViewGroup = this.CAj.findViewById(p.e.BBO);
          if (paramViewGroup != null) {
            break label412;
          }
        }
        label412:
        for (paramViewGroup = localObject1;; paramViewGroup = paramViewGroup.getLayoutParams())
        {
          if (paramViewGroup == null) {
            break label497;
          }
          paramViewGroup.height = ((int)this.CAj.getContext().getResources().getDimension(p.c.Edge_3A));
          AppMethodBeat.o(353593);
          return;
          paramViewGroup = paramViewGroup.getLayoutParams();
          break;
        }
      }
      if (paramBoolean1)
      {
        this.DbV.setTextSize(1, 15.0F);
        this.DbW.setTextSize(1, 15.0F);
        paramViewGroup = this.CAj.findViewById(p.e.BBO);
        if (paramViewGroup == null)
        {
          paramViewGroup = localObject2;
          if (paramViewGroup != null) {
            paramViewGroup.height = ((int)this.CAj.getContext().getResources().getDimension(p.c.Edge_3A));
          }
        }
      }
      label582:
      for (;;)
      {
        this.DbX.setTextSize(1, 22.0F);
        label497:
        AppMethodBeat.o(353593);
        return;
        paramViewGroup = paramViewGroup.getLayoutParams();
        break;
        this.DbV.setTextSize(1, 17.0F);
        this.DbW.setTextSize(1, 17.0F);
        paramViewGroup = this.CAj.findViewById(p.e.BBO);
        if (paramViewGroup == null) {}
        for (paramViewGroup = null;; paramViewGroup = paramViewGroup.getLayoutParams())
        {
          if (paramViewGroup == null) {
            break label582;
          }
          paramViewGroup.height = ((int)this.CAj.getContext().getResources().getDimension(p.c.Edge_4A));
          break;
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftQueuePlugin$ComboIdBackToLiveInfo;", "", "()V", "comboSumCount", "", "getComboSumCount", "()I", "setComboSumCount", "(I)V", "giftId", "", "getGiftId", "()Ljava/lang/String;", "setGiftId", "(Ljava/lang/String;)V", "isPreciousGift", "Ljava/util/concurrent/atomic/AtomicBoolean;", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "setPreciousGift", "(Ljava/util/concurrent/atomic/AtomicBoolean;)V", "isSelf", "", "()Z", "setSelf", "(Z)V", "quitTime", "", "getQuitTime", "()J", "setQuitTime", "(J)V", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class d
  {
    private volatile String DbF;
    AtomicBoolean Dbv;
    volatile int Dby;
    volatile boolean hHq;
    long oVP;
    
    public d()
    {
      AppMethodBeat.i(353594);
      this.Dbv = new AtomicBoolean(false);
      this.DbF = "";
      AppMethodBeat.o(353594);
    }
    
    public final void awY(String paramString)
    {
      AppMethodBeat.i(353599);
      kotlin.g.b.s.u(paramString, "<set-?>");
      this.DbF = paramString;
      AppMethodBeat.o(353599);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<ah>
  {
    f(aw paramaw)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "fraction", "", "flying", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements m<Float, Boolean, ah>
  {
    g(aw paramaw, ViewGroup paramViewGroup)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "fraction", "", "flying", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements m<Float, Boolean, ah>
  {
    h(aw paramaw, ViewGroup paramViewGroup)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "", "Landroid/view/ViewGroup;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftQueuePlugin$BulletShowingInfo;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftQueuePlugin;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.b<Map.Entry<? extends ViewGroup, ? extends aw.b>, Boolean>
  {
    public static final i Dcb;
    
    static
    {
      AppMethodBeat.i(353676);
      Dcb = new i();
      AppMethodBeat.o(353676);
    }
    
    i()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements kotlin.g.a.a<ah>
  {
    j(ViewGroup paramViewGroup, aw paramaw, s.b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends u
    implements kotlin.g.a.a<ah>
  {
    k(aw paramaw)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftQueuePlugin$registerBulletInAnimatorListener$1", "Landroid/animation/Animator$AnimatorListener;", "isCanceling", "", "()Z", "setCanceling", "(Z)V", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class l
    implements Animator.AnimatorListener
  {
    private boolean Dce;
    
    l(aw paramaw, ViewGroup paramViewGroup, boolean paramBoolean) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(353674);
      this.Dce = true;
      Log.i("Finder.FinderLiveGiftQueuePlugin", "BulletInAnimator onAnimationCancel: isCancel=" + this.Dce + ", bulletShowInfo:" + aw.d(this.DbQ).get(paramViewGroup));
      AppMethodBeat.o(353674);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(353665);
      Log.i("Finder.FinderLiveGiftQueuePlugin", "BulletInAnimator onAnimationEnd: isCancel=" + this.Dce + ", bulletShowInfo: " + aw.d(this.DbQ).get(paramViewGroup));
      if (this.Dce)
      {
        this.Dce = false;
        AppMethodBeat.o(353665);
        return;
      }
      paramAnimator = (aw.b)aw.d(this.DbQ).get(paramViewGroup);
      if (paramAnimator != null) {
        paramAnimator.Dbu = true;
      }
      paramAnimator = (aw.b)aw.d(this.DbQ).get(paramViewGroup);
      if ((paramAnimator != null) && (true == paramAnimator.Dbv.get())) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0)
        {
          paramAnimator = (ObjectAnimator)aw.e(this.DbQ).get(paramViewGroup);
          if (paramAnimator != null) {
            paramAnimator.start();
          }
        }
        AppMethodBeat.o(353665);
        return;
      }
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(353684);
      Log.i("Finder.FinderLiveGiftQueuePlugin", kotlin.g.b.s.X("BulletInAnimator onAnimationStart: ", aw.d(this.DbQ).get(paramViewGroup)));
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(paramBoolean, paramViewGroup));
      AppMethodBeat.o(353684);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(boolean paramBoolean, ViewGroup paramViewGroup)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftQueuePlugin$registerBulletOutAnimatorListener$1", "Landroid/animation/Animator$AnimatorListener;", "isCanceling", "", "()Z", "setCanceling", "(Z)V", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class m
    implements Animator.AnimatorListener
  {
    private boolean Dce;
    
    m(aw paramaw, ViewGroup paramViewGroup) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(353671);
      this.Dce = true;
      Log.i("Finder.FinderLiveGiftQueuePlugin", "BulletOutAnimator onAnimationCancel: isCancel=" + this.Dce + ", bulletShowInfo:" + aw.d(this.DbQ).get(paramViewGroup));
      AppMethodBeat.o(353671);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(353664);
      Log.i("Finder.FinderLiveGiftQueuePlugin", "BulletOutAnimator onAnimationEnd: isCancel=" + this.Dce + ", bulletShowInfo: " + aw.d(this.DbQ).get(paramViewGroup));
      if (this.Dce)
      {
        this.Dce = false;
        AppMethodBeat.o(353664);
        return;
      }
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(paramViewGroup));
      paramAnimator = (aw.b)aw.d(this.DbQ).get(paramViewGroup);
      if ((paramAnimator != null) && (true == paramAnimator.Dbv.get())) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          aw.f(this.DbQ);
        }
        paramAnimator = (aw.b)aw.d(this.DbQ).get(paramViewGroup);
        if (paramAnimator != null) {
          paramAnimator.reset();
        }
        aw.g(this.DbQ);
        AppMethodBeat.o(353664);
        return;
      }
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(353680);
      Log.i("Finder.FinderLiveGiftQueuePlugin", kotlin.g.b.s.X("BulletOutAnimator onAnimationStart: ", aw.d(this.DbQ).get(paramViewGroup)));
      AppMethodBeat.o(353680);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(ViewGroup paramViewGroup)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class n
    extends u
    implements kotlin.g.a.a<ah>
  {
    n(aw paramaw, ViewGroup paramViewGroup, s.b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class o
    extends u
    implements kotlin.g.a.a<ah>
  {
    o(aw paramaw, ah.f<ViewGroup> paramf, ViewGroup paramViewGroup, s.b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftQueuePlugin$timer$1", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler$CallBack;", "onTimerExpired", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class p
    implements MTimerHandler.CallBack
  {
    p(aw paramaw) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(353726);
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(this.DbQ));
      AppMethodBeat.o(353726);
      return false;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(aw paramaw)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class q
    extends u
    implements kotlin.g.a.a<ah>
  {
    q(aw paramaw)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class r
    extends u
    implements kotlin.g.a.a<ah>
  {
    r(aw.b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.aw
 * JD-Core Version:    0.7.0.1
 */