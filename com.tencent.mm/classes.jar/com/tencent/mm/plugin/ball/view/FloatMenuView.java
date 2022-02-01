package com.tencent.mm.plugin.ball.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.os.ResultReceiver;
import android.os.Vibrator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.d.c;
import com.tencent.mm.plugin.ball.f.e.a;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class FloatMenuView
  extends RelativeLayout
  implements com.tencent.mm.plugin.ball.c.e
{
  public boolean nEY;
  public boolean nEZ;
  private boolean nFc;
  private Vibrator nKv;
  public int nLT;
  public int nLU;
  private RecyclerView nLV;
  private com.tencent.mm.plugin.ball.a.a nLW;
  private LinearLayoutManager nLX;
  private List<BallInfo> nLY;
  public Set<com.tencent.mm.plugin.ball.d.d> nLZ;
  private String nLd;
  private com.tencent.mm.plugin.ball.d.e nMa;
  private LayoutAnimationController nMb;
  private LayoutAnimationController nMc;
  private LayoutAnimationController nMd;
  private LayoutAnimationController nMe;
  private int nMf;
  public int nMg;
  public View nMh;
  public int nMi;
  public boolean nMj;
  private volatile boolean nMk;
  private ResultReceiver nMl;
  private boolean nMm;
  
  public FloatMenuView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FloatMenuView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FloatMenuView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(106490);
    this.nLZ = new CopyOnWriteArraySet();
    this.nMa = null;
    this.nFc = true;
    this.nMi = -1;
    this.nMj = false;
    this.nMk = false;
    this.nMl = null;
    this.nMm = false;
    View.inflate(paramContext, 2131494561, this);
    setBackgroundColor(android.support.v4.content.b.n(paramContext, 2131100381));
    setOnClickListener(new FloatMenuView.1(this));
    this.nKv = ((Vibrator)paramContext.getSystemService("vibrator"));
    this.nLV = ((RecyclerView)findViewById(2131302236));
    this.nLV.setOverScrollMode(2);
    setClipChildren(false);
    this.nLV.setClipChildren(false);
    this.nLW = new com.tencent.mm.plugin.ball.a.a(paramContext);
    this.nLW.nFc = this.nFc;
    if (!this.nFc) {
      this.nLV.setItemAnimator(null);
    }
    for (;;)
    {
      this.nLW.nFb = new c()
      {
        public final void a(BallInfo paramAnonymousBallInfo, int paramAnonymousInt)
        {
          AppMethodBeat.i(106486);
          FloatMenuView.a(FloatMenuView.this, paramAnonymousBallInfo, paramAnonymousInt);
          AppMethodBeat.o(106486);
        }
        
        public final void e(BallInfo paramAnonymousBallInfo)
        {
          AppMethodBeat.i(106487);
          FloatMenuView.b(FloatMenuView.this, paramAnonymousBallInfo);
          AppMethodBeat.o(106487);
        }
        
        public final void u(BallInfo paramAnonymousBallInfo)
        {
          AppMethodBeat.i(106485);
          FloatMenuView.a(FloatMenuView.this, paramAnonymousBallInfo);
          AppMethodBeat.o(106485);
        }
      };
      this.nLV.setAdapter(this.nLW);
      this.nLX = new FloatMenuView.3(this);
      this.nLX.setOrientation(1);
      this.nLV.setLayoutManager(this.nLX);
      this.nMf = (com.tencent.mm.cc.a.ay(paramContext, 2131166364) + com.tencent.mm.cc.a.ay(paramContext, 2131166380) + com.tencent.mm.cc.a.ay(paramContext, 2131166378));
      this.nMb = AnimationUtils.loadLayoutAnimation(paramContext, 2130772057);
      this.nMd = AnimationUtils.loadLayoutAnimation(paramContext, 2130772058);
      this.nMc = AnimationUtils.loadLayoutAnimation(paramContext, 2130772055);
      this.nMe = AnimationUtils.loadLayoutAnimation(paramContext, 2130772056);
      AppMethodBeat.o(106490);
      return;
      paramAttributeSet = new FloatMenuView.4(this);
      d locald = new d();
      locald.atc = 200L;
      locald.atd = 200L;
      locald.atf = 200L;
      locald.ate = 200L;
      locald.ate = 160L;
      locald.nFd = paramAttributeSet;
      this.nLW.nFd = paramAttributeSet;
      this.nLV.setItemAnimator(locald);
    }
  }
  
  private void I(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106513);
    Iterator localIterator = this.nLZ.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.plugin.ball.d.d)localIterator.next()).e(paramBallInfo);
    }
    AppMethodBeat.o(106513);
  }
  
  private static void a(RelativeLayout.LayoutParams paramLayoutParams, int paramInt)
  {
    AppMethodBeat.i(106508);
    paramLayoutParams.setMargins(0, 0, 0, 0);
    paramLayoutParams.rightMargin = 0;
    paramLayoutParams.topMargin = paramInt;
    paramLayoutParams.addRule(11);
    AppMethodBeat.o(106508);
  }
  
  private static void b(RelativeLayout.LayoutParams paramLayoutParams, int paramInt)
  {
    AppMethodBeat.i(106509);
    paramLayoutParams.setMargins(0, 0, 0, 0);
    paramLayoutParams.leftMargin = 0;
    paramLayoutParams.topMargin = paramInt;
    paramLayoutParams.addRule(9);
    AppMethodBeat.o(106509);
  }
  
  private void bLQ()
  {
    AppMethodBeat.i(106502);
    if (this.nEY) {
      this.nLV.setLayoutAnimation(this.nMb);
    }
    for (;;)
    {
      this.nLV.startLayoutAnimation();
      if (!com.tencent.mm.plugin.ball.f.d.h(this.nLY)) {
        break;
      }
      Iterator localIterator = this.nLY.iterator();
      while (localIterator.hasNext()) {
        I((BallInfo)localIterator.next());
      }
      this.nLV.setLayoutAnimation(this.nMd);
    }
    AppMethodBeat.o(106502);
  }
  
  private void bLR()
  {
    AppMethodBeat.i(106503);
    if (this.nEY) {
      this.nLV.setLayoutAnimation(this.nMc);
    }
    for (;;)
    {
      this.nLV.startLayoutAnimation();
      AppMethodBeat.o(106503);
      return;
      this.nLV.setLayoutAnimation(this.nMe);
    }
  }
  
  private int bLT()
  {
    AppMethodBeat.i(106506);
    if (com.tencent.mm.plugin.ball.f.d.h(this.nLY))
    {
      int i = this.nLY.size();
      int j = this.nMf;
      AppMethodBeat.o(106506);
      return i * j;
    }
    AppMethodBeat.o(106506);
    return 0;
  }
  
  private void bLU()
  {
    AppMethodBeat.i(106507);
    if (this.nLV == null)
    {
      AppMethodBeat.o(106507);
      return;
    }
    if (getVisibility() == 0)
    {
      ad.i("MicroMsg.FloatMenuView", "updateMenuContentView, ignore when visible");
      AppMethodBeat.o(106507);
      return;
    }
    this.nMk = false;
    int j;
    e.a locala;
    RelativeLayout.LayoutParams localLayoutParams;
    int k;
    boolean bool;
    if (this.nMg == 0)
    {
      i = com.tencent.mm.plugin.ball.f.e.nIm;
      j = bLT();
      locala = com.tencent.mm.plugin.ball.f.d.S(this.nLT, this.nLU, i);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      k = com.tencent.mm.cc.a.iq(aj.getContext()) - com.tencent.mm.plugin.ball.f.e.nIl;
      if (this.nLU + i + j <= k) {
        break label457;
      }
      if (this.nLU - j < com.tencent.mm.plugin.ball.f.e.nIx) {
        break label348;
      }
      i = this.nLU - j;
      if (i >= com.tencent.mm.plugin.ball.f.e.nIl) {
        break label322;
      }
      bool = true;
      label143:
      this.nMk = bool;
      if (i >= com.tencent.mm.plugin.ball.f.e.nIl) {
        break label328;
      }
      i = com.tencent.mm.plugin.ball.f.e.nIl;
      label160:
      if ((locala != e.a.nIA) && (locala != e.a.nIC)) {
        break label331;
      }
      b(localLayoutParams, i);
      this.nMb.setOrder(1);
    }
    for (;;)
    {
      this.nLX.ao(true);
      this.nLV.setLayoutManager(this.nLX);
      ad.i("MicroMsg.FloatMenuView", "updateMenuContentView, anchorView:[%s, %s], margins:[%s, %s, %s, %s], enableScroll:%b", new Object[] { Integer.valueOf(this.nLT), Integer.valueOf(this.nLU), Integer.valueOf(localLayoutParams.leftMargin), Integer.valueOf(localLayoutParams.topMargin), Integer.valueOf(localLayoutParams.rightMargin), Integer.valueOf(localLayoutParams.bottomMargin), Boolean.valueOf(this.nMk) });
      this.nLV.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(106507);
      return;
      i = this.nMg;
      break;
      label322:
      bool = false;
      break label143;
      label328:
      break label160;
      label331:
      a(localLayoutParams, i);
      this.nMd.setOrder(1);
    }
    label348:
    int i = k - j;
    if (i < com.tencent.mm.plugin.ball.f.e.nIl)
    {
      bool = true;
      label362:
      this.nMk = bool;
      if (i >= com.tencent.mm.plugin.ball.f.e.nIl) {
        break label437;
      }
      i = com.tencent.mm.plugin.ball.f.e.nIl;
      label379:
      if ((locala != e.a.nIA) && (locala != e.a.nIC)) {
        break label440;
      }
      b(localLayoutParams, i);
      this.nMb.setOrder(0);
    }
    for (;;)
    {
      this.nLX.ao(false);
      this.nLV.setLayoutManager(this.nLX);
      break;
      bool = false;
      break label362;
      label437:
      break label379;
      label440:
      a(localLayoutParams, i);
      this.nMd.setOrder(0);
    }
    label457:
    i += this.nLU;
    if ((locala == e.a.nIA) || (locala == e.a.nIC))
    {
      b(localLayoutParams, i);
      this.nMb.setOrder(0);
    }
    for (;;)
    {
      this.nLX.ao(false);
      this.nLV.setLayoutManager(this.nLX);
      break;
      a(localLayoutParams, i);
      this.nMd.setOrder(0);
    }
  }
  
  private void bLV()
  {
    AppMethodBeat.i(106510);
    if (this.nKv != null) {
      this.nKv.vibrate(10L);
    }
    AppMethodBeat.o(106510);
  }
  
  private static String cb(List<BallInfo> paramList)
  {
    AppMethodBeat.i(106494);
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramList.size())
    {
      BallInfo localBallInfo = (BallInfo)paramList.get(i);
      localStringBuilder.append(localBallInfo.key).append(localBallInfo.type).append(localBallInfo.dDH).append(localBallInfo.lZt).append(localBallInfo.name).append(localBallInfo.tag).append(localBallInfo.state).append(localBallInfo.nFX).append(localBallInfo.nFY).append(localBallInfo.progress).append("|");
      i += 1;
    }
    paramList = ai.ee(localStringBuilder.toString());
    AppMethodBeat.o(106494);
    return paramList;
  }
  
  private void d(int paramInt, View paramView)
  {
    AppMethodBeat.i(106497);
    if (paramInt == -1) {
      dy(this.nMh);
    }
    for (;;)
    {
      this.nMi = paramInt;
      this.nMh = paramView;
      AppMethodBeat.o(106497);
      return;
      if (paramInt != this.nMi)
      {
        dy(this.nMh);
        dx(paramView);
      }
    }
  }
  
  private void dx(View paramView)
  {
    AppMethodBeat.i(106498);
    if (paramView != null)
    {
      paramView.clearAnimation();
      if (((paramView.getTag() instanceof BallInfo)) && (!((BallInfo)paramView.getTag()).nFX))
      {
        paramView.animate().scaleX(1.1F).scaleY(1.1F).setDuration(100L).start();
        bLV();
      }
    }
    AppMethodBeat.o(106498);
  }
  
  public static void dy(View paramView)
  {
    AppMethodBeat.i(106499);
    if (paramView != null)
    {
      paramView.clearAnimation();
      paramView.animate().scaleX(1.0F).scaleY(1.0F).setDuration(100L).start();
    }
    AppMethodBeat.o(106499);
  }
  
  private void eL(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(106505);
    this.nLT = paramInt1;
    this.nLU = paramInt2;
    bLU();
    AppMethodBeat.o(106505);
  }
  
  public final void H(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106512);
    Iterator localIterator = this.nLZ.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.plugin.ball.d.d)localIterator.next()).u(paramBallInfo);
    }
    AppMethodBeat.o(106512);
  }
  
  public final void N(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(106496);
    float f1 = paramMotionEvent.getRawX();
    float f2 = paramMotionEvent.getRawY();
    float f3 = this.nLV.getLeft();
    float f4 = this.nLV.getTop();
    paramMotionEvent = this.nLV.o(f1 - f3, f2 - f4);
    if (paramMotionEvent != null)
    {
      d(RecyclerView.bw(paramMotionEvent), paramMotionEvent);
      AppMethodBeat.o(106496);
      return;
    }
    d(-1, null);
    AppMethodBeat.o(106496);
  }
  
  public final void a(List<BallInfo> paramList, BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106493);
    List localList = com.tencent.mm.plugin.ball.f.d.bT(com.tencent.mm.plugin.ball.f.d.bS(paramList));
    String str = cb(localList);
    if (bt.lQ(str, this.nLd))
    {
      ad.i("MicroMsg.FloatMenuView", "FloatMenuView ignore refresh");
      AppMethodBeat.o(106493);
      return;
    }
    this.nLd = str;
    this.nLY = localList;
    if (com.tencent.mm.plugin.ball.f.d.h(this.nLY)) {}
    for (int i = this.nLY.size();; i = 0)
    {
      ad.i("MicroMsg.FloatMenuView", "menuBallInfoList, size:%s", new Object[] { Integer.valueOf(i) });
      this.nLW.nFa = this.nLY;
      this.nLW.asY.notifyChanged();
      if (com.tencent.mm.plugin.ball.f.d.h(com.tencent.mm.plugin.ball.f.d.d(paramList, paramBallInfo))) {
        break;
      }
      d(null);
      AppMethodBeat.o(106493);
      return;
    }
    eL(this.nLT, this.nLU);
    AppMethodBeat.o(106493);
  }
  
  public final void bLP()
  {
    AppMethodBeat.i(106500);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(null);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ball/view/FloatMenuView", "com/tencent/mm/plugin/ball/view/FloatMenuView", "show", "(Landroid/animation/AnimatorListenerAdapter;)V", this, localb.ahq());
    c(null);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ball/view/FloatMenuView", "com/tencent/mm/plugin/ball/view/FloatMenuView", "show", "(Landroid/animation/AnimatorListenerAdapter;)V");
    AppMethodBeat.o(106500);
  }
  
  public final void bLS()
  {
    AppMethodBeat.i(217352);
    if (getVisibility() == 8)
    {
      ad.i("MicroMsg.FloatMenuView", "float menu already hide");
      AppMethodBeat.o(217352);
      return;
    }
    setVisibility(8);
    AppMethodBeat.o(217352);
  }
  
  public final void bLW()
  {
    AppMethodBeat.i(106511);
    Iterator localIterator = this.nLZ.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.plugin.ball.d.d)localIterator.next()).bKm();
    }
    AppMethodBeat.o(106511);
  }
  
  public final void c(ResultReceiver paramResultReceiver)
  {
    AppMethodBeat.i(217351);
    if (getVisibility() == 0)
    {
      ad.i("MicroMsg.FloatMenuView", "float menu already show");
      AppMethodBeat.o(217351);
      return;
    }
    this.nMl = paramResultReceiver;
    setVisibility(0);
    paramResultReceiver = ObjectAnimator.ofFloat(this, "alpha", new float[] { 0.0F, 1.0F });
    paramResultReceiver.setDuration(200L);
    paramResultReceiver.addListener(new com.tencent.mm.plugin.ball.b.e(this));
    paramResultReceiver.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(217349);
        FloatMenuView.a(FloatMenuView.this, true);
        AppMethodBeat.o(217349);
      }
    });
    paramResultReceiver.start();
    bLQ();
    AppMethodBeat.o(217351);
  }
  
  public final void d(AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(106501);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnimatorListenerAdapter);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ball/view/FloatMenuView", "com/tencent/mm/plugin/ball/view/FloatMenuView", "hide", "(Landroid/animation/AnimatorListenerAdapter;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
    if (getVisibility() == 8)
    {
      ad.i("MicroMsg.FloatMenuView", "float menu already hide");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ball/view/FloatMenuView", "com/tencent/mm/plugin/ball/view/FloatMenuView", "hide", "(Landroid/animation/AnimatorListenerAdapter;)V");
      AppMethodBeat.o(106501);
      return;
    }
    bLR();
    localObject = ObjectAnimator.ofFloat(this, "alpha", new float[] { 1.0F, 0.0F });
    ((Animator)localObject).setDuration(200L);
    ((Animator)localObject).addListener(new com.tencent.mm.plugin.ball.b.d(this, paramAnimatorListenerAdapter));
    ((Animator)localObject).addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(217350);
        FloatMenuView.a(FloatMenuView.this, false);
        FloatMenuView.f(FloatMenuView.this);
        AppMethodBeat.o(217350);
      }
    });
    ((Animator)localObject).start();
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ball/view/FloatMenuView", "com/tencent/mm/plugin/ball/view/FloatMenuView", "hide", "(Landroid/animation/AnimatorListenerAdapter;)V");
    AppMethodBeat.o(106501);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(106491);
    if (((paramKeyEvent.getKeyCode() == 4) || (paramKeyEvent.getKeyCode() == 3) || (paramKeyEvent.getKeyCode() == 82)) && (paramKeyEvent.getAction() == 0))
    {
      bLW();
      AppMethodBeat.o(106491);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(106491);
    return bool;
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(106492);
    int i = paramConfiguration.orientation;
    paramConfiguration = this.nLZ.iterator();
    while (paramConfiguration.hasNext()) {
      ((com.tencent.mm.plugin.ball.d.d)paramConfiguration.next()).nL(i);
    }
    AppMethodBeat.o(106492);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(184625);
    super.onMeasure(paramInt1, paramInt2);
    if (this.nMa != null) {
      this.nMa.bKn();
    }
    AppMethodBeat.o(184625);
  }
  
  public void setCanAddFloatBallWhenHide(boolean paramBoolean)
  {
    this.nMm = paramBoolean;
  }
  
  public void setForceShowFloatMenu(boolean paramBoolean)
  {
    this.nMj = paramBoolean;
  }
  
  public void setInLongPressMode(boolean paramBoolean)
  {
    AppMethodBeat.i(106495);
    this.nEZ = paramBoolean;
    this.nLW.nEZ = paramBoolean;
    this.nLW.asY.notifyChanged();
    AppMethodBeat.o(106495);
  }
  
  public void setOnMeasuredListener(com.tencent.mm.plugin.ball.d.e parame)
  {
    this.nMa = parame;
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(106504);
    super.setVisibility(paramInt);
    if (paramInt == 8)
    {
      ad.i("MicroMsg.FloatMenuView", "setVisibility, updateMenuContentView when GONE");
      eL(this.nLT, this.nLU);
      setForceShowFloatMenu(false);
    }
    AppMethodBeat.o(106504);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.view.FloatMenuView
 * JD-Core Version:    0.7.0.1
 */