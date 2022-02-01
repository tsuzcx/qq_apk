package com.tencent.mm.plugin.finder.live.plugin;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.c.b.b;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.live.model.e;
import com.tencent.mm.plugin.finder.live.util.p.a;
import com.tencent.mm.plugin.finder.live.util.p.b;
import com.tencent.mm.plugin.finder.live.util.p.c;
import com.tencent.mm.plugin.finder.live.view.FinderLiveGiftTextView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
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
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.g.a.a;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.m.h;
import kotlin.m.i;
import kotlin.x;
import org.libpag.PAGView;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftQueuePlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue$GiftAddingObserver;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "iGiftQueue", "Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue;", "isVisitor", "", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue;Z)V", "NICK_NAME_LENGTH", "", "bulletInAnimatorMap", "", "Landroid/animation/ObjectAnimator;", "bulletInfoMap", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftQueuePlugin$BulletShowingInfo;", "bulletOutAnimatorMap", "comboIdBackToLiveMap", "", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftQueuePlugin$comboIdBackToLiveInfo;", "comboIdList", "Ljava/util/LinkedList;", "containerOne", "Landroid/widget/RelativeLayout;", "containerThree", "containerTwo", "timer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "calculatePreciousGiftRemainingTime", "", "entry", "", "canClearScreen", "checkIfPreciousGiftTimeOver", "checkIfSelfPreciousGiftForceReplace", "", "checkInfoFromComboIdBackToLiveMap", "comboId", "checkStatusWhenMaximizeWindow", "createBulletInAnimator", "target", "createBulletOutAnimator", "findCurrentShowingPreciousGift", "findNextSuitableBulletSpace", "giftShowInfo", "Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue$GiftShowInfo;", "isPreciousGiftShowing", "launchBulletInAnimation", "space", "matchBackupGiftType", "mount", "onGiftAdding", "giftType", "Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue$GiftType;", "pollNextGiftShowInfo", "relaunchBulletInAnimation", "replaceBullet", "unMount", "updateBulletShowingInfo", "bulletShowingInfo", "isForceReplace", "updatePreciousGiftTotalShowingTime", "giftId", "BulletShowingInfo", "BulletViewHolder", "Companion", "comboIdBackToLiveInfo", "plugin-finder_release"})
public final class ae
  extends d
  implements p.a
{
  private static final int ulA;
  private static final int upL;
  public static final c upM;
  private final com.tencent.mm.live.c.b hOp;
  private final MTimerHandler timer;
  private final int upA;
  private final RelativeLayout upB;
  private final RelativeLayout upC;
  private final RelativeLayout upD;
  private final Map<ViewGroup, a> upE;
  private final Map<ViewGroup, ObjectAnimator> upF;
  private final Map<ViewGroup, ObjectAnimator> upG;
  private final Map<String, f> upH;
  private final LinkedList<String> upI;
  private final com.tencent.mm.plugin.finder.live.util.p upJ;
  private final boolean upK;
  
  static
  {
    AppMethodBeat.i(246720);
    upM = new c((byte)0);
    com.tencent.mm.plugin.finder.storage.c localc = com.tencent.mm.plugin.finder.storage.c.vCb;
    ulA = ((Number)com.tencent.mm.plugin.finder.storage.c.dvY().value()).intValue() * 1000;
    upL = 500 / (ulA + 500);
    AppMethodBeat.o(246720);
  }
  
  public ae(ViewGroup paramViewGroup, com.tencent.mm.live.c.b paramb, com.tencent.mm.plugin.finder.live.util.p paramp, boolean paramBoolean)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(246719);
    this.hOp = paramb;
    this.upJ = paramp;
    this.upK = paramBoolean;
    paramb = com.tencent.mm.plugin.finder.storage.c.vCb;
    this.upA = ((Number)com.tencent.mm.plugin.finder.storage.c.dvZ().value()).intValue();
    this.upI = new LinkedList();
    this.timer = new MTimerHandler("FinderLiveGiftQueuePlugin::Timer", (MTimerHandler.CallBack)new o(this), false);
    paramb = paramViewGroup.findViewById(2131301018);
    kotlin.g.b.p.g(paramb, "root.findViewById(R.id.f…ve_gift_queue_bullet_one)");
    this.upB = ((RelativeLayout)paramb);
    paramb = paramViewGroup.findViewById(2131301020);
    kotlin.g.b.p.g(paramb, "root.findViewById(R.id.f…ve_gift_queue_bullet_two)");
    this.upC = ((RelativeLayout)paramb);
    paramViewGroup = paramViewGroup.findViewById(2131301019);
    kotlin.g.b.p.g(paramViewGroup, "root.findViewById(R.id.f…_gift_queue_bullet_three)");
    this.upD = ((RelativeLayout)paramViewGroup);
    paramViewGroup = Collections.synchronizedMap((Map)new LinkedHashMap(3));
    kotlin.g.b.p.g(paramViewGroup, "Collections.synchronizedMap(LinkedHashMap(3))");
    this.upE = paramViewGroup;
    this.upE.put(this.upB, new a((ViewGroup)this.upB, 0, this.upK));
    this.upE.put(this.upC, new a((ViewGroup)this.upC, 1, this.upK));
    this.upE.put(this.upD, new a((ViewGroup)this.upD, 2, this.upK, true));
    this.upF = ((Map)new HashMap(3));
    this.upF.put(this.upB, r((ViewGroup)this.upB));
    this.upF.put(this.upC, r((ViewGroup)this.upC));
    this.upF.put(this.upD, r((ViewGroup)this.upD));
    this.upG = ((Map)new HashMap(3));
    this.upG.put(this.upB, s((ViewGroup)this.upB));
    this.upG.put(this.upC, s((ViewGroup)this.upC));
    this.upG.put(this.upD, s((ViewGroup)this.upD));
    paramViewGroup = Collections.synchronizedMap((Map)new LinkedHashMap());
    kotlin.g.b.p.g(paramViewGroup, "Collections.synchronizedMap(LinkedHashMap())");
    this.upH = paramViewGroup;
    paramViewGroup = ((Iterable)this.upE.values()).iterator();
    while (paramViewGroup.hasNext())
    {
      paramb = (a)paramViewGroup.next();
      paramp = com.tencent.mm.plugin.finder.utils.m.vVH;
      com.tencent.mm.plugin.finder.utils.m.p((TextView)paramb.upV.uqj);
    }
    AppMethodBeat.o(246719);
  }
  
  private final ViewGroup a(p.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(246709);
    Object localObject2 = this.upE;
    Object localObject1 = new LinkedHashMap();
    localObject2 = ((Map)localObject2).entrySet().iterator();
    Map.Entry localEntry;
    int i;
    label108:
    while (((Iterator)localObject2).hasNext())
    {
      localEntry = (Map.Entry)((Iterator)localObject2).next();
      if (!((a)localEntry.getValue()).upN.get()) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label108;
        }
        ((LinkedHashMap)localObject1).put(localEntry.getKey(), localEntry.getValue());
        break;
      }
    }
    localObject2 = (Map)localObject1;
    localObject1 = new LinkedHashMap();
    localObject2 = ((Map)localObject2).entrySet().iterator();
    label189:
    label223:
    label232:
    label235:
    while (((Iterator)localObject2).hasNext())
    {
      localEntry = (Map.Entry)((Iterator)localObject2).next();
      boolean bool;
      if (((a)localEntry.getValue()).upW)
      {
        if (paramBoolean) {
          break label232;
        }
        if (paramb != null) {
          break label223;
        }
        bool = false;
        if (!bool) {
          break label232;
        }
      }
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label235;
        }
        ((LinkedHashMap)localObject1).put(localEntry.getKey(), localEntry.getValue());
        break;
        bool = paramb.uwW;
        break label189;
      }
    }
    localObject1 = (Map)localObject1;
    if (!((Map)localObject1).isEmpty()) {
      i = 1;
    }
    while (i != 0)
    {
      paramb = (Collection)new ArrayList(((Map)localObject1).size());
      localObject1 = ((Map)localObject1).entrySet().iterator();
      for (;;)
      {
        if (((Iterator)localObject1).hasNext())
        {
          paramb.add((ViewGroup)((Map.Entry)((Iterator)localObject1).next()).getKey());
          continue;
          i = 0;
          break;
        }
      }
      paramb = (ViewGroup)((List)paramb).get(0);
      Log.i("Finder.FinderLiveGiftQueuePlugin", "findNextSuitableBulletSpace: BulletShowingInfo=" + (a)this.upE.get(paramb) + ", isPreciousGiftShowing=" + paramBoolean);
      AppMethodBeat.o(246709);
      return paramb;
    }
    AppMethodBeat.o(246709);
    return null;
  }
  
  private final void a(final ViewGroup paramViewGroup, final p.b paramb)
  {
    AppMethodBeat.i(246710);
    if ((paramViewGroup == null) || (paramb == null))
    {
      AppMethodBeat.o(246710);
      return;
    }
    com.tencent.mm.ac.d.h((a)new m(this, paramViewGroup, paramb));
    AppMethodBeat.o(246710);
  }
  
  private static void a(String paramString, a parama)
  {
    AppMethodBeat.i(246711);
    Object localObject = com.tencent.mm.plugin.finder.storage.c.vCb;
    long l2 = ((Number)com.tencent.mm.plugin.finder.storage.c.dwc().value()).longValue();
    localObject = e.uiD;
    localObject = (Long)e.dfx().get(paramString);
    if (localObject != null) {}
    for (long l1 = ((Long)localObject).longValue() / 1000L;; l1 = l2)
    {
      long l3 = l1;
      if (0L == l1)
      {
        localObject = new StringBuilder("updatePreciousGiftTotalShowingTime: giftFullPagDurationMap value = ");
        e locale = e.uiD;
        Log.i("Finder.FinderLiveGiftQueuePlugin", (Long)e.dfx().get(paramString));
        l3 = l2;
      }
      parama.upX = (((float)l3 * 0.9F * (parama.upS - parama.upU)));
      Log.i("Finder.FinderLiveGiftQueuePlugin", "updatePreciousGiftTotalShowingTime: giftId=" + paramString + ',' + " durationMs=" + l3 + ", totalShowingTime=" + parama.upX);
      AppMethodBeat.o(246711);
      return;
    }
  }
  
  private final void dhm()
  {
    int i;
    Object localObject3;
    Object localObject4;
    Object localObject5;
    a locala;
    label343:
    label480:
    boolean bool;
    label434:
    label598:
    Object localObject2;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(246708);
        Object localObject1 = dhn();
        if (localObject1 != null)
        {
          i = 1;
          if ((i == 0) || (localObject1 == null) || (((a)((Map.Entry)localObject1).getValue()).upQ))
          {
            Log.i("Finder.FinderLiveGiftQueuePlugin", "pollNextGiftShowInfo: current bulletInfo = " + this.upE + " \n current gift queue size: " + this.upJ.size());
            localObject1 = this.upJ.dij();
            if (localObject1 != null) {
              break label343;
            }
            AppMethodBeat.o(246708);
          }
        }
        else
        {
          i = 0;
          continue;
        }
        localObject3 = this.upJ.dii();
        if ((localObject3 == null) || (((p.c)localObject3).compareTo((Enum)p.c.uxa) >= 0)) {
          continue;
        }
        localObject4 = (ViewGroup)((Map.Entry)localObject1).getKey();
        localObject5 = this.upJ.dik();
        if ((localObject4 == null) || (localObject5 == null)) {
          continue;
        }
        localObject1 = (a)this.upE.get(localObject4);
        if (localObject1 != null) {
          ((a)localObject1).reset();
        }
        localObject1 = (a)this.upE.get(localObject4);
        if (localObject1 != null)
        {
          localObject1 = ((a)localObject1).upN;
          if (localObject1 != null) {
            ((AtomicBoolean)localObject1).getAndSet(true);
          }
        }
        localObject1 = (a)this.upE.get(localObject4);
        if (localObject1 != null)
        {
          localObject1 = ((a)localObject1).upP;
          if (localObject1 != null) {
            ((AtomicBoolean)localObject1).getAndSet(((p.b)localObject5).uwW);
          }
        }
        locala = (a)this.upE.get(localObject4);
        if (locala != null)
        {
          localObject3 = ((p.b)localObject5).upR;
          localObject1 = localObject3;
          if (localObject3 == null) {
            localObject1 = "";
          }
          locala.atJ((String)localObject1);
        }
        com.tencent.mm.ac.d.h((a)new n(this, (ViewGroup)localObject4, (p.b)localObject5));
        continue;
        localObject4 = this.upE;
      }
      finally {}
      localObject3 = new LinkedHashMap();
      localObject4 = ((Map)localObject4).entrySet().iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (Map.Entry)((Iterator)localObject4).next();
        locala = (a)((Map.Entry)localObject5).getValue();
        if ((!locala.upN.get()) || (!locala.upR.equals(localb.upR))) {
          break label1112;
        }
        i = 1;
        if (i == 0) {
          break label1115;
        }
        ((LinkedHashMap)localObject3).put(((Map.Entry)localObject5).getKey(), ((Map.Entry)localObject5).getValue());
      }
      localObject4 = (Map)localObject3;
      if (((Map)localObject4).isEmpty()) {
        break label1117;
      }
      i = 1;
      if (i != 0)
      {
        localObject3 = (Collection)new ArrayList(((Map)localObject4).size());
        localObject4 = ((Map)localObject4).entrySet().iterator();
        while (((Iterator)localObject4).hasNext()) {
          ((Collection)localObject3).add((ViewGroup)((Map.Entry)((Iterator)localObject4).next()).getKey());
        }
        a((ViewGroup)((List)localObject3).get(0), localb);
        this.upJ.b(localb);
      }
      else
      {
        if (dhn() == null) {
          break label1122;
        }
        bool = true;
        if (bool)
        {
          localObject3 = this.upJ.dil();
          if (localObject3 == null)
          {
            AppMethodBeat.o(246708);
            continue;
          }
          localObject4 = this.upE;
          localObject2 = new LinkedHashMap();
          localObject4 = ((Map)localObject4).entrySet().iterator();
          label655:
          while (((Iterator)localObject4).hasNext())
          {
            localObject5 = (Map.Entry)((Iterator)localObject4).next();
            locala = (a)((Map.Entry)localObject5).getValue();
            if ((!locala.upN.get()) || (!locala.upR.equals(((p.b)localObject3).upR))) {
              break label1127;
            }
            i = 1;
            label718:
            if (i == 0) {
              break label1130;
            }
            ((LinkedHashMap)localObject2).put(((Map.Entry)localObject5).getKey(), ((Map.Entry)localObject5).getValue());
          }
          localObject4 = (Map)localObject2;
          if (((Map)localObject4).isEmpty()) {
            break label1132;
          }
          i = 1;
          label762:
          localObject2 = localObject3;
          if (i != 0)
          {
            localObject2 = (Collection)new ArrayList(((Map)localObject4).size());
            localObject4 = ((Map)localObject4).entrySet().iterator();
            while (((Iterator)localObject4).hasNext()) {
              ((Collection)localObject2).add((ViewGroup)((Map.Entry)((Iterator)localObject4).next()).getKey());
            }
            a((ViewGroup)((List)localObject2).get(0), (p.b)localObject3);
            this.upJ.b((p.b)localObject3);
            continue;
          }
        }
        localObject5 = a((p.b)localObject2, bool);
        if (localObject5 != null) {
          break label1137;
        }
        AppMethodBeat.o(246708);
      }
    }
    for (;;)
    {
      label895:
      this.upJ.b((p.b)localObject2);
      break;
      label1112:
      label1115:
      label1117:
      label1122:
      label1127:
      label1130:
      label1132:
      label1137:
      do
      {
        localObject3 = (a)this.upE.get(localObject5);
        if (localObject3 != null)
        {
          localObject3 = ((a)localObject3).upN;
          if ((localObject3 != null) && (true == ((AtomicBoolean)localObject3).get()))
          {
            a((ViewGroup)localObject5, (p.b)localObject2);
            break label895;
          }
        }
        localObject3 = (a)this.upE.get(localObject5);
        if (localObject3 != null)
        {
          localObject3 = ((a)localObject3).upN;
          if (localObject3 != null) {
            ((AtomicBoolean)localObject3).getAndSet(true);
          }
        }
        localObject3 = (a)this.upE.get(localObject5);
        if (localObject3 != null)
        {
          localObject3 = ((a)localObject3).upP;
          if (localObject3 != null) {
            ((AtomicBoolean)localObject3).getAndSet(((p.b)localObject2).uwW);
          }
        }
        locala = (a)this.upE.get(localObject5);
        if (locala != null)
        {
          localObject4 = ((p.b)localObject2).upR;
          localObject3 = localObject4;
          if (localObject4 == null) {
            localObject3 = "";
          }
          locala.atJ((String)localObject3);
        }
        com.tencent.mm.ac.d.h((a)new k(this, (ViewGroup)localObject5, (p.b)localObject2));
        break label895;
        i = 0;
        break label434;
        break;
        i = 0;
        break label480;
        bool = false;
        break label598;
        i = 0;
        break label718;
        break label655;
        i = 0;
        break label762;
        if (localObject5 == null) {
          break label895;
        }
      } while (localObject2 != null);
    }
  }
  
  private final Map.Entry<ViewGroup, a> dhn()
  {
    AppMethodBeat.i(246712);
    Object localObject = i.c(i.a(kotlin.a.ae.cw(this.upE), (kotlin.g.a.b)j.uqp));
    if (!((Collection)localObject).isEmpty()) {}
    for (int i = 1; i != 0; i = 0)
    {
      localObject = (Map.Entry)((List)localObject).get(0);
      AppMethodBeat.o(246712);
      return localObject;
    }
    AppMethodBeat.o(246712);
    return null;
  }
  
  private final boolean g(Map.Entry<? extends ViewGroup, a> paramEntry)
  {
    AppMethodBeat.i(246713);
    Object localObject = paramEntry;
    if (paramEntry == null) {
      localObject = dhn();
    }
    if (localObject != null)
    {
      long l = ((a)((Map.Entry)localObject).getValue()).upX - (cl.aWA() - ((a)((Map.Entry)localObject).getValue()).upY);
      Log.i("Finder.FinderLiveGiftQueuePlugin", "checkIfPreciousGiftTimeOver: remainingTime=" + l + ", entry=" + localObject);
      if (l > 100L)
      {
        this.timer.startTimer(l);
        AppMethodBeat.o(246713);
        return true;
      }
      paramEntry = (ObjectAnimator)this.upG.get(((Map.Entry)localObject).getKey());
      if ((paramEntry != null) && (!paramEntry.isRunning())) {
        com.tencent.mm.ac.d.h((a)new d(paramEntry));
      }
      AppMethodBeat.o(246713);
      return false;
    }
    AppMethodBeat.o(246713);
    return false;
  }
  
  private final ObjectAnimator r(final ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(246706);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramViewGroup, "translationX", new float[] { -500.0F, 0.0F });
    kotlin.g.b.p.g(localObjectAnimator, "bulletInAnim");
    localObjectAnimator.setDuration(ulA + 500);
    localObjectAnimator.setInterpolator((TimeInterpolator)new DecelerateInterpolator());
    localObjectAnimator.setEvaluator((TypeEvaluator)new c(500, ulA, (kotlin.g.a.m)new g(this, paramViewGroup)));
    localObjectAnimator.addListener((Animator.AnimatorListener)new h(this, paramViewGroup));
    AppMethodBeat.o(246706);
    return localObjectAnimator;
  }
  
  private final ObjectAnimator s(final ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(246707);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramViewGroup, "alpha", new float[] { 1.0F, 0.0F });
    kotlin.g.b.p.g(localObjectAnimator, "bulletOutAnim");
    localObjectAnimator.setDuration(500L);
    localObjectAnimator.addListener((Animator.AnimatorListener)new i(this, paramViewGroup));
    AppMethodBeat.o(246707);
    return localObjectAnimator;
  }
  
  public final void a(p.c paramc)
  {
    AppMethodBeat.i(246717);
    kotlin.g.b.p.h(paramc, "giftType");
    com.tencent.mm.ac.d.h((a)new l(this));
    dhm();
    AppMethodBeat.o(246717);
  }
  
  public final boolean dgK()
  {
    return true;
  }
  
  public final void dho()
  {
    AppMethodBeat.i(246718);
    if (this.upJ.hasNext())
    {
      com.tencent.mm.ac.d.h((a)new e(this));
      dhm();
    }
    AppMethodBeat.o(246718);
  }
  
  public final void mount()
  {
    AppMethodBeat.i(246715);
    super.mount();
    this.upJ.a((p.a)this);
    AppMethodBeat.o(246715);
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(246716);
    super.unMount();
    this.timer.stopTimer();
    com.tencent.mm.ac.d.h((a)new p(this));
    this.upJ.b((p.a)this);
    AppMethodBeat.o(246716);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftQueuePlugin$BulletShowingInfo;", "", "container", "Landroid/view/ViewGroup;", "index", "", "isVisitor", "", "backup", "(Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftQueuePlugin;Landroid/view/ViewGroup;IZZ)V", "value", "bulletFlying", "getBulletFlying", "()Z", "setBulletFlying", "(Z)V", "cntQueue", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "getCntQueue", "()Ljava/util/concurrent/ConcurrentLinkedDeque;", "setCntQueue", "(Ljava/util/concurrent/ConcurrentLinkedDeque;)V", "cntTransferAnimatorSet", "Landroid/animation/AnimatorSet;", "getCntTransferAnimatorSet", "()Landroid/animation/AnimatorSet;", "setCntTransferAnimatorSet", "(Landroid/animation/AnimatorSet;)V", "cntTransferAniming", "getCntTransferAniming", "setCntTransferAniming", "comboId", "", "getComboId", "()Ljava/lang/String;", "setComboId", "(Ljava/lang/String;)V", "comboSumCount", "getComboSumCount", "()I", "setComboSumCount", "(I)V", "giftId", "getGiftId", "setGiftId", "getIndex", "isBackup", "setBackup", "isBulletInAnimationEnd", "setBulletInAnimationEnd", "isPreciousGift", "Ljava/util/concurrent/atomic/AtomicBoolean;", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "setPreciousGift", "(Ljava/util/concurrent/atomic/AtomicBoolean;)V", "isSelfSend", "setSelfSend", "isShowing", "setShowing", "lastCountOnBackToLive", "getLastCountOnBackToLive", "setLastCountOnBackToLive", "startShowingTime", "", "getStartShowingTime", "()J", "setStartShowingTime", "(J)V", "totalShowingTime", "getTotalShowingTime", "setTotalShowingTime", "viewHolder", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftQueuePlugin$BulletViewHolder;", "getViewHolder", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftQueuePlugin$BulletViewHolder;", "reset", "", "saveBackToLiveInfo", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftQueuePlugin$comboIdBackToLiveInfo;", "destinationCnt", "localSend", "startTransferCnt", "prefix", "toString", "plugin-finder_release"})
  final class a
  {
    private final int index;
    AtomicBoolean upN;
    volatile boolean upO;
    AtomicBoolean upP;
    volatile boolean upQ;
    volatile String upR;
    volatile int upS;
    private ConcurrentLinkedDeque<Integer> upT;
    volatile int upU;
    final ae.b upV;
    boolean upW;
    volatile long upX;
    volatile long upY;
    volatile String upZ;
    AnimatorSet uqa;
    private volatile boolean uqb;
    volatile boolean uqc;
    
    public a(final int paramInt, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(246682);
      this.index = paramBoolean1;
      this.upN = new AtomicBoolean(false);
      this.upP = new AtomicBoolean(false);
      this.upR = "";
      this.upT = new ConcurrentLinkedDeque();
      this.upV = new ae.b(paramInt, paramBoolean2);
      boolean bool;
      this.upW = bool;
      this.upZ = "";
      this.uqa = new AnimatorSet();
      this$1 = ObjectAnimator.ofFloat(this.upV.uqj, "scaleX", new float[] { 0.0F, 1.1F }).setDuration(125L);
      kotlin.g.b.p.g(ae.this, "ObjectAnimator.ofFloat(v…f, 1.1f).setDuration(125)");
      paramInt = ObjectAnimator.ofFloat(this.upV.uqj, "scaleY", new float[] { 0.0F, 1.1F }).setDuration(125L);
      kotlin.g.b.p.g(paramInt, "ObjectAnimator.ofFloat(v…f, 1.1f).setDuration(125)");
      ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.upV.uqj, "scaleX", new float[] { 1.1F, 1.0F }).setDuration(83L);
      kotlin.g.b.p.g(localObjectAnimator1, "ObjectAnimator.ofFloat(v…1f, 1.0f).setDuration(83)");
      localObjectAnimator1.setStartDelay(125L);
      ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.upV.uqj, "scaleY", new float[] { 1.1F, 1.0F }).setDuration(83L);
      kotlin.g.b.p.g(localObjectAnimator2, "ObjectAnimator.ofFloat(v…1f, 1.0f).setDuration(83)");
      localObjectAnimator2.setStartDelay(125L);
      final ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(this.upV.uqj, "alpha", new float[] { 0.0F, 1.0F }).setDuration(208L);
      kotlin.g.b.p.g(localObjectAnimator3, "ObjectAnimator.ofFloat(v…f, 1.0f).setDuration(208)");
      this.upV.uqj.setPivotX(0.0F);
      this.upV.uqj.setPivotY(this.upV.uqj.getMeasuredHeight());
      this.uqa.playTogether(new Animator[] { (Animator)ae.this, (Animator)paramInt, (Animator)localObjectAnimator1, (Animator)localObjectAnimator2, (Animator)localObjectAnimator3 });
      this.uqa.addListener((Animator.AnimatorListener)new Animator.AnimatorListener()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(246671);
          this.uqe.ns(false);
          Object localObject = localObjectAnimator3.getTarget();
          paramAnonymousAnimator = localObject;
          if (!(localObject instanceof View)) {
            paramAnonymousAnimator = null;
          }
          paramAnonymousAnimator = (View)paramAnonymousAnimator;
          if (paramAnonymousAnimator != null) {
            paramAnonymousAnimator.setAlpha(1.0F);
          }
          localObject = this.uqg.getTarget();
          paramAnonymousAnimator = localObject;
          if (!(localObject instanceof View)) {
            paramAnonymousAnimator = null;
          }
          paramAnonymousAnimator = (View)paramAnonymousAnimator;
          if (paramAnonymousAnimator != null) {
            paramAnonymousAnimator.setScaleX(1.0F);
          }
          localObject = paramInt.getTarget();
          paramAnonymousAnimator = localObject;
          if (!(localObject instanceof View)) {
            paramAnonymousAnimator = null;
          }
          paramAnonymousAnimator = (View)paramAnonymousAnimator;
          if (paramAnonymousAnimator != null)
          {
            paramAnonymousAnimator.setScaleY(1.0F);
            AppMethodBeat.o(246671);
            return;
          }
          AppMethodBeat.o(246671);
        }
        
        public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(246670);
          this.uqe.ns(true);
          AppMethodBeat.o(246670);
        }
      });
      AppMethodBeat.o(246682);
    }
    
    private void atK(String paramString)
    {
      AppMethodBeat.i(246678);
      kotlin.g.b.p.h(paramString, "prefix");
      boolean bool = this.upT.isEmpty();
      if ((bool) || (this.uqb) || (this.uqc))
      {
        Log.i("Finder.FinderLiveGiftQueuePlugin", "startTransferCnt(" + paramString + ") cntQueueEmpty:" + bool + ",cntTransferAniming:" + this.uqb + ",bulletFlying:" + this.uqc);
        AppMethodBeat.o(246678);
        return;
      }
      Integer localInteger = (Integer)this.upT.pollFirst();
      if (localInteger != null) {}
      for (int i = localInteger.intValue();; i = this.upS)
      {
        Log.i("Finder.FinderLiveGiftQueuePlugin", "startTransferCnt(" + paramString + ") number:" + i + ",cntQueueEmpty:" + bool + ",cntTransferAniming:" + this.uqb + ",bulletFlying:" + this.uqc);
        this.upV.uqj.setText((CharSequence)"x".concat(String.valueOf(i)));
        this.upV.uqj.setTag(Integer.valueOf(i));
        this.upV.uqj.setPivotX(0.0F);
        this.upV.uqj.setPivotY(this.upV.uqj.getMeasuredHeight());
        this.uqa.start();
        AppMethodBeat.o(246678);
        return;
      }
    }
    
    private final ae.f dhp()
    {
      AppMethodBeat.i(246680);
      ae.f localf = new ae.f();
      localf.upP.getAndSet(this.upP.get());
      localf.dJM = this.upQ;
      localf.upS = this.upS;
      localf.jmU = cl.aWA();
      localf.atL(this.upZ);
      AppMethodBeat.o(246680);
      return localf;
    }
    
    public final void ak(int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(246677);
      Object localObject2 = this.upV.uqj.getTag();
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
          break label103;
        }
        bool = true;
        i = 1;
      }
      for (;;)
      {
        if (paramInt > i) {
          break label109;
        }
        this.upV.uqj.setText((CharSequence)"x".concat(String.valueOf(i)));
        AppMethodBeat.o(246677);
        return;
        i = this.upU;
        break;
        label103:
        bool = false;
      }
      label109:
      localObject1 = new StringBuilder("localSend:" + paramBoolean + ",startCnt:" + i + ",lastCountOnBackToLive:" + this.upU + ",firstGift:" + bool + ';');
      this.upT.clear();
      if (!paramBoolean)
      {
        int k = kotlin.k.j.mZ(1, (int)Math.ceil((paramInt - i) / 5.0D));
        int j = i;
        if (!bool) {
          j = i + k;
        }
        while (j < paramInt)
        {
          this.upT.offer(Integer.valueOf(j));
          ((StringBuilder)localObject1).append(j + ',');
          j += k;
        }
      }
      this.upT.offer(Integer.valueOf(paramInt));
      ((StringBuilder)localObject1).append(paramInt);
      Log.i("Finder.FinderLiveGiftQueuePlugin", "setCntQueue ".concat(String.valueOf(localObject1)));
      atK("setCntQueue");
      AppMethodBeat.o(246677);
    }
    
    public final void atJ(String paramString)
    {
      AppMethodBeat.i(246674);
      kotlin.g.b.p.h(paramString, "<set-?>");
      this.upR = paramString;
      AppMethodBeat.o(246674);
    }
    
    public final void ns(boolean paramBoolean)
    {
      AppMethodBeat.i(246675);
      if (paramBoolean != this.uqb) {
        Log.i("Finder.FinderLiveGiftQueuePlugin", "cntTransferAniming origin value:" + this.uqb + ",value:" + paramBoolean);
      }
      this.uqb = paramBoolean;
      if (!this.uqb) {
        atK("cntTransferAnim end");
      }
      AppMethodBeat.o(246675);
    }
    
    public final void nt(boolean paramBoolean)
    {
      AppMethodBeat.i(246676);
      int j = 0;
      int i = j;
      if (paramBoolean != this.uqc)
      {
        Log.i("Finder.FinderLiveGiftQueuePlugin", "bulletFlying origin value:" + this.uqc + ",value:" + paramBoolean);
        i = j;
        if (!paramBoolean) {
          i = 1;
        }
      }
      this.uqc = paramBoolean;
      if (i != 0) {
        atK("bulletFlying Stop");
      }
      AppMethodBeat.o(246676);
    }
    
    public final void reset()
    {
      AppMethodBeat.i(246679);
      ae.b(ae.this).put(this.upR, dhp());
      com.tencent.mm.ac.d.c("giftQueueMapClear", (a)new a(this));
      Integer localInteger = (Integer)this.upT.peekLast();
      if (localInteger != null) {
        this.upV.uqj.setText((CharSequence)"x".concat(String.valueOf(localInteger)));
      }
      this.upN.getAndSet(false);
      this.upO = false;
      this.upP.getAndSet(false);
      this.upQ = false;
      this.upR = "";
      this.upS = 0;
      this.upU = 0;
      this.upT.clear();
      this.upX = 0L;
      this.upY = 0L;
      this.upZ = "";
      com.tencent.mm.ac.d.h((a)new b(this));
      ns(false);
      nt(false);
      this.upV.uqj.setTag(null);
      AppMethodBeat.o(246679);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(246681);
      String str = "\n" + new StringBuilder("index = ").append(this.index).toString() + ", " + new StringBuilder("giftId = ").append(this.upZ).toString() + ", " + new StringBuilder("isShowing = ").append(this.upN).toString() + ", " + new StringBuilder("isPreciousGift = ").append(this.upP).toString() + ", " + new StringBuilder("isAnimationEnd = ").append(this.upO).toString() + ", " + new StringBuilder("comboId = ").append(this.upR).toString() + ", " + new StringBuilder("comboSumCount = ").append(this.upS).toString() + ", " + new StringBuilder("lastCountOnBackToLive = ").append(this.upU).toString() + ", " + new StringBuilder("totalShowingTime = ").append(this.upX).toString() + ", " + new StringBuilder("cntTransferAniming = ").append(this.uqb).toString() + ", " + new StringBuilder("bulletFlying = ").append(this.uqc).toString() + "\n";
      kotlin.g.b.p.g(str, "StringBuilder().append(\"…              .toString()");
      AppMethodBeat.o(246681);
      return str;
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements a<x>
    {
      a(ae.a parama)
      {
        super();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class b
      extends q
      implements a<x>
    {
      b(ae.a parama)
      {
        super();
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftQueuePlugin$BulletViewHolder;", "", "container", "Landroid/view/ViewGroup;", "isVisitor", "", "(Landroid/view/ViewGroup;Z)V", "cntTv", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveGiftTextView;", "getCntTv", "()Lcom/tencent/mm/plugin/finder/live/view/FinderLiveGiftTextView;", "contentTv", "Landroid/widget/TextView;", "getContentTv", "()Landroid/widget/TextView;", "nameTv", "getNameTv", "pagView", "Lorg/libpag/PAGView;", "getPagView", "()Lorg/libpag/PAGView;", "plugin-finder_release"})
  static final class b
  {
    final TextView gxs;
    final TextView hXC;
    final PAGView uqi;
    final FinderLiveGiftTextView uqj;
    
    public b(ViewGroup paramViewGroup, boolean paramBoolean)
    {
      AppMethodBeat.i(246683);
      View localView = paramViewGroup.findViewById(2131300991);
      kotlin.g.b.p.g(localView, "container.findViewById(R…ve_gift_bullut_desc_name)");
      this.gxs = ((TextView)localView);
      localView = paramViewGroup.findViewById(2131300992);
      kotlin.g.b.p.g(localView, "container.findViewById(R…ive_gift_bullut_desc_tip)");
      this.hXC = ((TextView)localView);
      localView = paramViewGroup.findViewById(2131300993);
      kotlin.g.b.p.g(localView, "container.findViewById(R…der_live_gift_bullut_pag)");
      this.uqi = ((PAGView)localView);
      paramViewGroup = paramViewGroup.findViewById(2131300989);
      kotlin.g.b.p.g(paramViewGroup, "container.findViewById(R…_live_gift_bullut_cnt_tv)");
      this.uqj = ((FinderLiveGiftTextView)paramViewGroup);
      if (paramBoolean)
      {
        this.gxs.setTextSize(1, 15.0F);
        this.hXC.setTextSize(1, 15.0F);
      }
      for (;;)
      {
        this.uqj.setTextSize(1, 22.0F);
        AppMethodBeat.o(246683);
        return;
        this.gxs.setTextSize(1, 17.0F);
        this.hXC.setTextSize(1, 17.0F);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftQueuePlugin$Companion;", "", "()V", "ANIMATION_DURATION", "", "ANIMATION_STAY_START_TIME", "", "BULLET_FLY_DISTANCE", "", "FLY_FRACTION", "PRECIOUS_GIFT_REMAINING_TIME_THRESHHOLD", "STAY_DURATION", "TAG", "", "plugin-finder_release"})
  public static final class c {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements a<x>
  {
    d(ObjectAnimator paramObjectAnimator)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements a<x>
  {
    e(ae paramae)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftQueuePlugin$comboIdBackToLiveInfo;", "", "()V", "comboSumCount", "", "getComboSumCount", "()I", "setComboSumCount", "(I)V", "giftId", "", "getGiftId", "()Ljava/lang/String;", "setGiftId", "(Ljava/lang/String;)V", "isPreciousGift", "Ljava/util/concurrent/atomic/AtomicBoolean;", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "setPreciousGift", "(Ljava/util/concurrent/atomic/AtomicBoolean;)V", "isSelf", "", "()Z", "setSelf", "(Z)V", "quitTime", "", "getQuitTime", "()J", "setQuitTime", "(J)V", "plugin-finder_release"})
  static final class f
  {
    volatile boolean dJM;
    long jmU;
    AtomicBoolean upP;
    volatile int upS;
    private volatile String upZ;
    
    public f()
    {
      AppMethodBeat.i(246687);
      this.upP = new AtomicBoolean(false);
      this.upZ = "";
      AppMethodBeat.o(246687);
    }
    
    public final void atL(String paramString)
    {
      AppMethodBeat.i(246686);
      kotlin.g.b.p.h(paramString, "<set-?>");
      this.upZ = paramString;
      AppMethodBeat.o(246686);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "fraction", "", "flying", "", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.m<Float, Boolean, x>
  {
    g(ae paramae, ViewGroup paramViewGroup)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftQueuePlugin$createBulletInAnimator$2", "Landroid/animation/Animator$AnimatorListener;", "isCanceling", "", "()Z", "setCanceling", "(Z)V", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class h
    implements Animator.AnimatorListener
  {
    private boolean uqm;
    
    h(ViewGroup paramViewGroup) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(246691);
      this.uqm = true;
      Log.i("Finder.FinderLiveGiftQueuePlugin", "BulletInAnimator onAnimationCancel: isCancel=" + this.uqm + ", bulletShowInfo:" + (ae.a)ae.d(this.uqd).get(paramViewGroup));
      AppMethodBeat.o(246691);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(246690);
      Log.i("Finder.FinderLiveGiftQueuePlugin", "BulletInAnimator onAnimationEnd: isCancel=" + this.uqm + ", bulletShowInfo: " + (ae.a)ae.d(this.uqd).get(paramViewGroup));
      if (this.uqm)
      {
        this.uqm = false;
        AppMethodBeat.o(246690);
        return;
      }
      paramAnimator = (ae.a)ae.d(this.uqd).get(paramViewGroup);
      if (paramAnimator != null) {
        paramAnimator.upO = true;
      }
      paramAnimator = (ae.a)ae.d(this.uqd).get(paramViewGroup);
      if (paramAnimator != null)
      {
        paramAnimator = paramAnimator.upP;
        if ((paramAnimator != null) && (true == paramAnimator.get()))
        {
          Iterator localIterator = kotlin.a.j.z((Iterable)ae.d(this.uqd).entrySet()).iterator();
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
            paramAnimator = localIterator.next();
          } while (!kotlin.g.b.p.j((ViewGroup)((Map.Entry)paramAnimator).getKey(), paramViewGroup));
          for (;;)
          {
            paramAnimator = (Map.Entry)paramAnimator;
            ae.a(this.uqd, paramAnimator);
            AppMethodBeat.o(246690);
            return;
            paramAnimator = null;
          }
        }
      }
      paramAnimator = (ObjectAnimator)ae.e(this.uqd).get(paramViewGroup);
      if (paramAnimator != null)
      {
        paramAnimator.start();
        AppMethodBeat.o(246690);
        return;
      }
      AppMethodBeat.o(246690);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(246692);
      Log.i("Finder.FinderLiveGiftQueuePlugin", "BulletInAnimator onAnimationStart: " + (ae.a)ae.d(this.uqd).get(paramViewGroup));
      com.tencent.mm.ac.d.h((a)new a(this));
      AppMethodBeat.o(246692);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements a<x>
    {
      a(ae.h paramh)
      {
        super();
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftQueuePlugin$createBulletOutAnimator$1", "Landroid/animation/Animator$AnimatorListener;", "isCanceling", "", "()Z", "setCanceling", "(Z)V", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class i
    implements Animator.AnimatorListener
  {
    private boolean uqm;
    
    i(ViewGroup paramViewGroup) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(246695);
      this.uqm = true;
      Log.i("Finder.FinderLiveGiftQueuePlugin", "BulletOutAnimator onAnimationCancel: isCancel=" + this.uqm + ", bulletShowInfo:" + (ae.a)ae.d(this.uqd).get(paramViewGroup));
      AppMethodBeat.o(246695);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(246694);
      Log.i("Finder.FinderLiveGiftQueuePlugin", "BulletOutAnimator onAnimationEnd: isCancel=" + this.uqm + ", bulletShowInfo: " + (ae.a)ae.d(this.uqd).get(paramViewGroup));
      if (this.uqm)
      {
        this.uqm = false;
        AppMethodBeat.o(246694);
        return;
      }
      com.tencent.mm.ac.d.h((a)new a(this));
      paramAnimator = (ae.a)ae.d(this.uqd).get(paramViewGroup);
      if (paramAnimator != null)
      {
        paramAnimator = paramAnimator.upP;
        if ((paramAnimator != null) && (true == paramAnimator.get())) {
          b.b.a(ae.f(this.uqd), b.c.hML);
        }
      }
      paramAnimator = (ae.a)ae.d(this.uqd).get(paramViewGroup);
      if (paramAnimator != null) {
        paramAnimator.reset();
      }
      ae.g(this.uqd);
      AppMethodBeat.o(246694);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(246696);
      Log.i("Finder.FinderLiveGiftQueuePlugin", "BulletOutAnimator onAnimationStart: " + (ae.a)ae.d(this.uqd).get(paramViewGroup));
      AppMethodBeat.o(246696);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements a<x>
    {
      a(ae.i parami)
      {
        super();
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "Landroid/view/ViewGroup;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftQueuePlugin$BulletShowingInfo;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftQueuePlugin;", "invoke"})
  static final class j
    extends q
    implements kotlin.g.a.b<Map.Entry<? extends ViewGroup, ? extends ae.a>, Boolean>
  {
    public static final j uqp;
    
    static
    {
      AppMethodBeat.i(246698);
      uqp = new j();
      AppMethodBeat.o(246698);
    }
    
    j()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class k
    extends q
    implements a<x>
  {
    k(ae paramae, ViewGroup paramViewGroup, p.b paramb)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class l
    extends q
    implements a<x>
  {
    l(ae paramae)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class m
    extends q
    implements a<x>
  {
    m(ae paramae, ViewGroup paramViewGroup, p.b paramb)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class n
    extends q
    implements a<x>
  {
    n(ae paramae, ViewGroup paramViewGroup, p.b paramb)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftQueuePlugin$timer$1", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler$CallBack;", "onTimerExpired", "", "plugin-finder_release"})
  public static final class o
    implements MTimerHandler.CallBack
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(246704);
      com.tencent.mm.ac.d.h((a)new a(this));
      AppMethodBeat.o(246704);
      return false;
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements a<x>
    {
      a(ae.o paramo)
      {
        super();
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class p
    extends q
    implements a<x>
  {
    p(ae paramae)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.ae
 * JD-Core Version:    0.7.0.1
 */