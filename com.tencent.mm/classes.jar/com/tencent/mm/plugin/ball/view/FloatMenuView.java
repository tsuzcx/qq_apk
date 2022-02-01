package com.tencent.mm.plugin.ball.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
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
import android.support.v7.widget.RecyclerView.w;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.a.a.a;
import com.tencent.mm.plugin.ball.d.c;
import com.tencent.mm.plugin.ball.f.e.a;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class FloatMenuView
  extends RelativeLayout
  implements com.tencent.mm.plugin.ball.c.e
{
  public boolean nKt;
  public boolean nKu;
  private boolean nKx;
  private String nQG;
  private Vibrator nQa;
  private RecyclerView nRA;
  private com.tencent.mm.plugin.ball.a.a nRB;
  private LinearLayoutManager nRC;
  private List<BallInfo> nRD;
  public Set<c> nRE;
  private com.tencent.mm.plugin.ball.d.d nRF;
  private LayoutAnimationController nRG;
  private LayoutAnimationController nRH;
  private LayoutAnimationController nRI;
  private LayoutAnimationController nRJ;
  private int nRK;
  public int nRL;
  public View nRM;
  public int nRN;
  public boolean nRO;
  private volatile boolean nRP;
  private ResultReceiver nRQ;
  private boolean nRR;
  public int nRy;
  public int nRz;
  
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
    this.nRE = new CopyOnWriteArraySet();
    this.nRF = null;
    this.nKx = true;
    this.nRN = -1;
    this.nRO = false;
    this.nRP = false;
    this.nRQ = null;
    this.nRR = false;
    View.inflate(paramContext, 2131494561, this);
    setBackgroundColor(android.support.v4.content.b.n(paramContext, 2131100381));
    setOnClickListener(new FloatMenuView.1(this));
    this.nQa = ((Vibrator)paramContext.getSystemService("vibrator"));
    this.nRA = ((RecyclerView)findViewById(2131302236));
    this.nRA.setOverScrollMode(2);
    setClipChildren(false);
    this.nRA.setClipChildren(false);
    this.nRB = new com.tencent.mm.plugin.ball.a.a(paramContext);
    this.nRB.nKx = this.nKx;
    if (!this.nKx) {
      this.nRA.setItemAnimator(null);
    }
    for (;;)
    {
      this.nRB.nKw = new com.tencent.mm.plugin.ball.d.b()
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
        
        public final void w(BallInfo paramAnonymousBallInfo)
        {
          AppMethodBeat.i(106485);
          FloatMenuView.a(FloatMenuView.this, paramAnonymousBallInfo);
          AppMethodBeat.o(106485);
        }
      };
      this.nRA.setAdapter(this.nRB);
      this.nRC = new LinearLayoutManager()
      {
        public final boolean kc()
        {
          return false;
        }
        
        public final boolean kd()
        {
          AppMethodBeat.i(106488);
          boolean bool = FloatMenuView.b(FloatMenuView.this);
          AppMethodBeat.o(106488);
          return bool;
        }
      };
      this.nRC.setOrientation(1);
      this.nRA.setLayoutManager(this.nRC);
      this.nRK = (com.tencent.mm.cb.a.ay(paramContext, 2131166364) + com.tencent.mm.cb.a.ay(paramContext, 2131166380) + com.tencent.mm.cb.a.ay(paramContext, 2131166378));
      this.nRG = AnimationUtils.loadLayoutAnimation(paramContext, 2130772057);
      this.nRI = AnimationUtils.loadLayoutAnimation(paramContext, 2130772058);
      this.nRH = AnimationUtils.loadLayoutAnimation(paramContext, 2130772055);
      this.nRJ = AnimationUtils.loadLayoutAnimation(paramContext, 2130772056);
      AppMethodBeat.o(106490);
      return;
      paramAttributeSet = new d.b()
      {
        public final boolean a(final RecyclerView.w paramAnonymousw, final Animator.AnimatorListener paramAnonymousAnimatorListener)
        {
          AppMethodBeat.i(209544);
          if ((paramAnonymousw == null) || (paramAnonymousw.auu == null))
          {
            AppMethodBeat.o(209544);
            return false;
          }
          float f2 = paramAnonymousw.auu.getMeasuredWidth();
          float f1 = f2;
          if (f2 <= 0.0F) {
            f1 = FloatMenuView.this.getMeasuredWidth();
          }
          f2 = f1;
          if (FloatMenuView.c(FloatMenuView.this)) {
            f2 = -f1;
          }
          ae.i("MicroMsg.FloatMenuView", "alvinluo animateRemove tranX: %f", new Object[] { Float.valueOf(f2) });
          paramAnonymousw.auu.animate().alpha(0.0F).translationX(f2).setListener(new Animator.AnimatorListener()
          {
            public final void onAnimationCancel(Animator paramAnonymous2Animator)
            {
              AppMethodBeat.i(209542);
              if (paramAnonymousAnimatorListener != null) {
                paramAnonymousAnimatorListener.onAnimationCancel(paramAnonymous2Animator);
              }
              AppMethodBeat.o(209542);
            }
            
            public final void onAnimationEnd(Animator paramAnonymous2Animator)
            {
              AppMethodBeat.i(209541);
              if (paramAnonymousAnimatorListener != null) {
                paramAnonymousAnimatorListener.onAnimationEnd(paramAnonymous2Animator);
              }
              long l = 200L;
              if (!com.tencent.mm.plugin.ball.f.d.h(FloatMenuView.d(FloatMenuView.this))) {
                l = 0L;
              }
              h.MqF.q(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(209539);
                  if (((FloatMenuView.4.1.this.amn instanceof a.a)) && (((a.a)FloatMenuView.4.1.this.amn).nKT != null)) {
                    FloatMenuView.a(FloatMenuView.this, ((a.a)FloatMenuView.4.1.this.amn).nKT, ((a.a)FloatMenuView.4.1.this.amn).position);
                  }
                  AppMethodBeat.o(209539);
                }
              }, l);
              AppMethodBeat.o(209541);
            }
            
            public final void onAnimationRepeat(Animator paramAnonymous2Animator)
            {
              AppMethodBeat.i(209543);
              if (paramAnonymousAnimatorListener != null) {
                paramAnonymousAnimatorListener.onAnimationRepeat(paramAnonymous2Animator);
              }
              AppMethodBeat.o(209543);
            }
            
            public final void onAnimationStart(Animator paramAnonymous2Animator)
            {
              AppMethodBeat.i(209540);
              if (paramAnonymousAnimatorListener != null) {
                paramAnonymousAnimatorListener.onAnimationStart(paramAnonymous2Animator);
              }
              AppMethodBeat.o(209540);
            }
          }).start();
          AppMethodBeat.o(209544);
          return true;
        }
      };
      d locald = new d();
      locald.atc = 200L;
      locald.atd = 200L;
      locald.atf = 200L;
      locald.ate = 200L;
      locald.ate = 160L;
      locald.nKy = paramAttributeSet;
      this.nRB.nKy = paramAttributeSet;
      this.nRA.setItemAnimator(locald);
    }
  }
  
  private void K(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106513);
    Iterator localIterator = this.nRE.iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).e(paramBallInfo);
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
  
  private void bMO()
  {
    AppMethodBeat.i(106502);
    if (this.nKt) {
      this.nRA.setLayoutAnimation(this.nRG);
    }
    for (;;)
    {
      this.nRA.startLayoutAnimation();
      if (!com.tencent.mm.plugin.ball.f.d.h(this.nRD)) {
        break;
      }
      Iterator localIterator = this.nRD.iterator();
      while (localIterator.hasNext()) {
        K((BallInfo)localIterator.next());
      }
      this.nRA.setLayoutAnimation(this.nRI);
    }
    AppMethodBeat.o(106502);
  }
  
  private void bMP()
  {
    AppMethodBeat.i(106503);
    if (this.nKt) {
      this.nRA.setLayoutAnimation(this.nRH);
    }
    for (;;)
    {
      this.nRA.startLayoutAnimation();
      AppMethodBeat.o(106503);
      return;
      this.nRA.setLayoutAnimation(this.nRJ);
    }
  }
  
  private int bMR()
  {
    AppMethodBeat.i(106506);
    if (com.tencent.mm.plugin.ball.f.d.h(this.nRD))
    {
      int i = this.nRD.size();
      int j = this.nRK;
      AppMethodBeat.o(106506);
      return i * j;
    }
    AppMethodBeat.o(106506);
    return 0;
  }
  
  private void bMS()
  {
    AppMethodBeat.i(106507);
    if (this.nRA == null)
    {
      AppMethodBeat.o(106507);
      return;
    }
    if (getVisibility() == 0)
    {
      ae.i("MicroMsg.FloatMenuView", "updateMenuContentView, ignore when visible");
      AppMethodBeat.o(106507);
      return;
    }
    this.nRP = false;
    int j;
    e.a locala;
    RelativeLayout.LayoutParams localLayoutParams;
    int k;
    boolean bool;
    if (this.nRL == 0)
    {
      i = com.tencent.mm.plugin.ball.f.e.nNP;
      j = bMR();
      locala = com.tencent.mm.plugin.ball.f.d.S(this.nRy, this.nRz, i);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      k = com.tencent.mm.cb.a.iv(ak.getContext()) - com.tencent.mm.plugin.ball.f.e.nNO;
      if (this.nRz + i + j <= k) {
        break label457;
      }
      if (this.nRz - j < com.tencent.mm.plugin.ball.f.e.nOa) {
        break label348;
      }
      i = this.nRz - j;
      if (i >= com.tencent.mm.plugin.ball.f.e.nNO) {
        break label322;
      }
      bool = true;
      label143:
      this.nRP = bool;
      if (i >= com.tencent.mm.plugin.ball.f.e.nNO) {
        break label328;
      }
      i = com.tencent.mm.plugin.ball.f.e.nNO;
      label160:
      if ((locala != e.a.nOd) && (locala != e.a.nOf)) {
        break label331;
      }
      b(localLayoutParams, i);
      this.nRG.setOrder(1);
    }
    for (;;)
    {
      this.nRC.ao(true);
      this.nRA.setLayoutManager(this.nRC);
      ae.i("MicroMsg.FloatMenuView", "updateMenuContentView, anchorView:[%s, %s], margins:[%s, %s, %s, %s], enableScroll:%b", new Object[] { Integer.valueOf(this.nRy), Integer.valueOf(this.nRz), Integer.valueOf(localLayoutParams.leftMargin), Integer.valueOf(localLayoutParams.topMargin), Integer.valueOf(localLayoutParams.rightMargin), Integer.valueOf(localLayoutParams.bottomMargin), Boolean.valueOf(this.nRP) });
      this.nRA.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(106507);
      return;
      i = this.nRL;
      break;
      label322:
      bool = false;
      break label143;
      label328:
      break label160;
      label331:
      a(localLayoutParams, i);
      this.nRI.setOrder(1);
    }
    label348:
    int i = k - j;
    if (i < com.tencent.mm.plugin.ball.f.e.nNO)
    {
      bool = true;
      label362:
      this.nRP = bool;
      if (i >= com.tencent.mm.plugin.ball.f.e.nNO) {
        break label437;
      }
      i = com.tencent.mm.plugin.ball.f.e.nNO;
      label379:
      if ((locala != e.a.nOd) && (locala != e.a.nOf)) {
        break label440;
      }
      b(localLayoutParams, i);
      this.nRG.setOrder(0);
    }
    for (;;)
    {
      this.nRC.ao(false);
      this.nRA.setLayoutManager(this.nRC);
      break;
      bool = false;
      break label362;
      label437:
      break label379;
      label440:
      a(localLayoutParams, i);
      this.nRI.setOrder(0);
    }
    label457:
    i += this.nRz;
    if ((locala == e.a.nOd) || (locala == e.a.nOf))
    {
      b(localLayoutParams, i);
      this.nRG.setOrder(0);
    }
    for (;;)
    {
      this.nRC.ao(false);
      this.nRA.setLayoutManager(this.nRC);
      break;
      a(localLayoutParams, i);
      this.nRI.setOrder(0);
    }
  }
  
  private void bMT()
  {
    AppMethodBeat.i(106510);
    if (this.nQa != null) {
      this.nQa.vibrate(10L);
    }
    AppMethodBeat.o(106510);
  }
  
  private static String cd(List<BallInfo> paramList)
  {
    AppMethodBeat.i(106494);
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramList.size())
    {
      BallInfo localBallInfo = (BallInfo)paramList.get(i);
      localStringBuilder.append(localBallInfo.key).append(localBallInfo.type).append(localBallInfo.dEM).append(localBallInfo.mdM).append(localBallInfo.name).append(localBallInfo.tag).append(localBallInfo.state).append(localBallInfo.nLu).append(localBallInfo.nLv).append(localBallInfo.progress).append("|");
      i += 1;
    }
    paramList = aj.ej(localStringBuilder.toString());
    AppMethodBeat.o(106494);
    return paramList;
  }
  
  private void d(int paramInt, View paramView)
  {
    AppMethodBeat.i(106497);
    if (paramInt == -1) {
      dy(this.nRM);
    }
    for (;;)
    {
      this.nRN = paramInt;
      this.nRM = paramView;
      AppMethodBeat.o(106497);
      return;
      if (paramInt != this.nRN)
      {
        dy(this.nRM);
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
      if (((paramView.getTag() instanceof BallInfo)) && (!((BallInfo)paramView.getTag()).nLu))
      {
        paramView.animate().scaleX(1.1F).scaleY(1.1F).setDuration(100L).start();
        bMT();
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
  
  private void eM(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(106505);
    this.nRy = paramInt1;
    this.nRz = paramInt2;
    bMS();
    AppMethodBeat.o(106505);
  }
  
  public final void J(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106512);
    Iterator localIterator = this.nRE.iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).w(paramBallInfo);
    }
    AppMethodBeat.o(106512);
  }
  
  public final void L(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(106496);
    float f1 = paramMotionEvent.getRawX();
    float f2 = paramMotionEvent.getRawY();
    float f3 = this.nRA.getLeft();
    float f4 = this.nRA.getTop();
    paramMotionEvent = this.nRA.o(f1 - f3, f2 - f4);
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
    List localList = com.tencent.mm.plugin.ball.f.d.bV(com.tencent.mm.plugin.ball.f.d.bU(paramList));
    String str = cd(localList);
    if (bu.lX(str, this.nQG))
    {
      ae.i("MicroMsg.FloatMenuView", "FloatMenuView ignore refresh");
      AppMethodBeat.o(106493);
      return;
    }
    this.nQG = str;
    this.nRD = localList;
    if (com.tencent.mm.plugin.ball.f.d.h(this.nRD)) {}
    for (int i = this.nRD.size();; i = 0)
    {
      ae.i("MicroMsg.FloatMenuView", "menuBallInfoList, size:%s", new Object[] { Integer.valueOf(i) });
      this.nRB.nKv = this.nRD;
      this.nRB.asY.notifyChanged();
      if (com.tencent.mm.plugin.ball.f.d.h(com.tencent.mm.plugin.ball.f.d.d(paramList, paramBallInfo))) {
        break;
      }
      d(null);
      AppMethodBeat.o(106493);
      return;
    }
    eM(this.nRy, this.nRz);
    AppMethodBeat.o(106493);
  }
  
  public final void bMN()
  {
    AppMethodBeat.i(106500);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(null);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ball/view/FloatMenuView", "com/tencent/mm/plugin/ball/view/FloatMenuView", "show", "(Landroid/animation/AnimatorListenerAdapter;)V", this, localb.ahF());
    c(null);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ball/view/FloatMenuView", "com/tencent/mm/plugin/ball/view/FloatMenuView", "show", "(Landroid/animation/AnimatorListenerAdapter;)V");
    AppMethodBeat.o(106500);
  }
  
  public final void bMQ()
  {
    AppMethodBeat.i(209549);
    if (getVisibility() == 8)
    {
      ae.i("MicroMsg.FloatMenuView", "float menu already hide");
      AppMethodBeat.o(209549);
      return;
    }
    setVisibility(8);
    AppMethodBeat.o(209549);
  }
  
  public final void bMU()
  {
    AppMethodBeat.i(106511);
    Iterator localIterator = this.nRE.iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).bLj();
    }
    AppMethodBeat.o(106511);
  }
  
  public final void c(ResultReceiver paramResultReceiver)
  {
    AppMethodBeat.i(209548);
    if (getVisibility() == 0)
    {
      ae.i("MicroMsg.FloatMenuView", "float menu already show");
      AppMethodBeat.o(209548);
      return;
    }
    this.nRQ = paramResultReceiver;
    setVisibility(0);
    paramResultReceiver = ObjectAnimator.ofFloat(this, "alpha", new float[] { 0.0F, 1.0F });
    paramResultReceiver.setDuration(200L);
    paramResultReceiver.addListener(new com.tencent.mm.plugin.ball.b.e(this));
    paramResultReceiver.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(209546);
        FloatMenuView.a(FloatMenuView.this, true);
        AppMethodBeat.o(209546);
      }
    });
    paramResultReceiver.start();
    bMO();
    AppMethodBeat.o(209548);
  }
  
  public final void d(AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(106501);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnimatorListenerAdapter);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ball/view/FloatMenuView", "com/tencent/mm/plugin/ball/view/FloatMenuView", "hide", "(Landroid/animation/AnimatorListenerAdapter;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
    if (getVisibility() == 8)
    {
      ae.i("MicroMsg.FloatMenuView", "float menu already hide");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ball/view/FloatMenuView", "com/tencent/mm/plugin/ball/view/FloatMenuView", "hide", "(Landroid/animation/AnimatorListenerAdapter;)V");
      AppMethodBeat.o(106501);
      return;
    }
    bMP();
    localObject = ObjectAnimator.ofFloat(this, "alpha", new float[] { 1.0F, 0.0F });
    ((Animator)localObject).setDuration(200L);
    ((Animator)localObject).addListener(new com.tencent.mm.plugin.ball.b.d(this, paramAnimatorListenerAdapter));
    ((Animator)localObject).addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(209547);
        FloatMenuView.a(FloatMenuView.this, false);
        FloatMenuView.f(FloatMenuView.this);
        AppMethodBeat.o(209547);
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
      bMU();
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
    paramConfiguration = this.nRE.iterator();
    while (paramConfiguration.hasNext()) {
      ((c)paramConfiguration.next()).nO(i);
    }
    AppMethodBeat.o(106492);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(184625);
    super.onMeasure(paramInt1, paramInt2);
    if (this.nRF != null) {
      this.nRF.bLk();
    }
    AppMethodBeat.o(184625);
  }
  
  public void setCanAddFloatBallWhenHide(boolean paramBoolean)
  {
    this.nRR = paramBoolean;
  }
  
  public void setForceShowFloatMenu(boolean paramBoolean)
  {
    this.nRO = paramBoolean;
  }
  
  public void setInLongPressMode(boolean paramBoolean)
  {
    AppMethodBeat.i(106495);
    this.nKu = paramBoolean;
    this.nRB.nKu = paramBoolean;
    this.nRB.asY.notifyChanged();
    AppMethodBeat.o(106495);
  }
  
  public void setOnMeasuredListener(com.tencent.mm.plugin.ball.d.d paramd)
  {
    this.nRF = paramd;
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(106504);
    super.setVisibility(paramInt);
    if (paramInt == 8)
    {
      ae.i("MicroMsg.FloatMenuView", "setVisibility, updateMenuContentView when GONE");
      eM(this.nRy, this.nRz);
      setForceShowFloatMenu(false);
    }
    AppMethodBeat.o(106504);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.view.FloatMenuView
 * JD-Core Version:    0.7.0.1
 */