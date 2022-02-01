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
import android.view.View.OnClickListener;
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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class FloatMenuView
  extends RelativeLayout
  implements com.tencent.mm.plugin.ball.c.e
{
  public boolean neC;
  public boolean neD;
  private boolean neG;
  private Vibrator njY;
  private String nkG;
  public View nlA;
  public int nlB;
  public boolean nlC;
  private volatile boolean nlD;
  private ResultReceiver nlE;
  private boolean nlF;
  public int nlm;
  public int nln;
  private RecyclerView nlo;
  private com.tencent.mm.plugin.ball.a.a nlp;
  private LinearLayoutManager nlq;
  private List<BallInfo> nlr;
  public Set<com.tencent.mm.plugin.ball.d.d> nls;
  private com.tencent.mm.plugin.ball.d.e nlt;
  private LayoutAnimationController nlu;
  private LayoutAnimationController nlv;
  private LayoutAnimationController nlw;
  private LayoutAnimationController nlx;
  private int nly;
  public int nlz;
  
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
    this.nls = new CopyOnWriteArraySet();
    this.nlt = null;
    this.neG = true;
    this.nlB = -1;
    this.nlC = false;
    this.nlD = false;
    this.nlE = null;
    this.nlF = false;
    View.inflate(paramContext, 2131494561, this);
    setBackgroundColor(android.support.v4.content.b.n(paramContext, 2131100381));
    setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(106484);
        FloatMenuView.a(FloatMenuView.this);
        AppMethodBeat.o(106484);
      }
    });
    this.njY = ((Vibrator)paramContext.getSystemService("vibrator"));
    this.nlo = ((RecyclerView)findViewById(2131302236));
    this.nlo.setOverScrollMode(2);
    setClipChildren(false);
    this.nlo.setClipChildren(false);
    this.nlp = new com.tencent.mm.plugin.ball.a.a(paramContext);
    this.nlp.neG = this.neG;
    if (!this.neG) {
      this.nlo.setItemAnimator(null);
    }
    for (;;)
    {
      this.nlp.neF = new c()
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
        
        public final void t(BallInfo paramAnonymousBallInfo)
        {
          AppMethodBeat.i(106485);
          FloatMenuView.a(FloatMenuView.this, paramAnonymousBallInfo);
          AppMethodBeat.o(106485);
        }
      };
      this.nlo.setAdapter(this.nlp);
      this.nlq = new LinearLayoutManager()
      {
        public final boolean jM()
        {
          return false;
        }
        
        public final boolean jN()
        {
          AppMethodBeat.i(106488);
          boolean bool = FloatMenuView.b(FloatMenuView.this);
          AppMethodBeat.o(106488);
          return bool;
        }
      };
      this.nlq.setOrientation(1);
      this.nlo.setLayoutManager(this.nlq);
      this.nly = (com.tencent.mm.cc.a.av(paramContext, 2131166364) + com.tencent.mm.cc.a.av(paramContext, 2131166380) + com.tencent.mm.cc.a.av(paramContext, 2131166378));
      this.nlu = AnimationUtils.loadLayoutAnimation(paramContext, 2130772057);
      this.nlw = AnimationUtils.loadLayoutAnimation(paramContext, 2130772058);
      this.nlv = AnimationUtils.loadLayoutAnimation(paramContext, 2130772055);
      this.nlx = AnimationUtils.loadLayoutAnimation(paramContext, 2130772056);
      AppMethodBeat.o(106490);
      return;
      paramAttributeSet = new d.b()
      {
        public final boolean a(final RecyclerView.w paramAnonymousw, final Animator.AnimatorListener paramAnonymousAnimatorListener)
        {
          AppMethodBeat.i(208050);
          if ((paramAnonymousw == null) || (paramAnonymousw.asD == null))
          {
            AppMethodBeat.o(208050);
            return false;
          }
          float f2 = paramAnonymousw.asD.getMeasuredWidth();
          float f1 = f2;
          if (f2 <= 0.0F) {
            f1 = FloatMenuView.this.getMeasuredWidth();
          }
          f2 = f1;
          if (FloatMenuView.c(FloatMenuView.this)) {
            f2 = -f1;
          }
          ac.i("MicroMsg.FloatMenuView", "alvinluo animateRemove tranX: %f", new Object[] { Float.valueOf(f2) });
          paramAnonymousw.asD.animate().alpha(0.0F).translationX(f2).setListener(new Animator.AnimatorListener()
          {
            public final void onAnimationCancel(Animator paramAnonymous2Animator)
            {
              AppMethodBeat.i(208048);
              if (paramAnonymousAnimatorListener != null) {
                paramAnonymousAnimatorListener.onAnimationCancel(paramAnonymous2Animator);
              }
              AppMethodBeat.o(208048);
            }
            
            public final void onAnimationEnd(Animator paramAnonymous2Animator)
            {
              AppMethodBeat.i(208047);
              if (paramAnonymousAnimatorListener != null) {
                paramAnonymousAnimatorListener.onAnimationEnd(paramAnonymous2Animator);
              }
              long l = 200L;
              if (!com.tencent.mm.plugin.ball.f.d.h(FloatMenuView.d(FloatMenuView.this))) {
                l = 0L;
              }
              h.JZN.p(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(208045);
                  if (((FloatMenuView.4.1.this.akw instanceof a.a)) && (((a.a)FloatMenuView.4.1.this.akw).nfc != null)) {
                    FloatMenuView.a(FloatMenuView.this, ((a.a)FloatMenuView.4.1.this.akw).nfc, ((a.a)FloatMenuView.4.1.this.akw).position);
                  }
                  AppMethodBeat.o(208045);
                }
              }, l);
              AppMethodBeat.o(208047);
            }
            
            public final void onAnimationRepeat(Animator paramAnonymous2Animator)
            {
              AppMethodBeat.i(208049);
              if (paramAnonymousAnimatorListener != null) {
                paramAnonymousAnimatorListener.onAnimationRepeat(paramAnonymous2Animator);
              }
              AppMethodBeat.o(208049);
            }
            
            public final void onAnimationStart(Animator paramAnonymous2Animator)
            {
              AppMethodBeat.i(208046);
              if (paramAnonymousAnimatorListener != null) {
                paramAnonymousAnimatorListener.onAnimationStart(paramAnonymous2Animator);
              }
              AppMethodBeat.o(208046);
            }
          }).start();
          AppMethodBeat.o(208050);
          return true;
        }
      };
      d locald = new d();
      locald.ark = 200L;
      locald.arl = 200L;
      locald.arn = 200L;
      locald.arm = 200L;
      locald.arm = 160L;
      locald.neH = paramAttributeSet;
      this.nlp.neH = paramAttributeSet;
      this.nlo.setItemAnimator(locald);
    }
  }
  
  private void H(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106513);
    Iterator localIterator = this.nls.iterator();
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
  
  private void bHF()
  {
    AppMethodBeat.i(106502);
    if (this.neC) {
      this.nlo.setLayoutAnimation(this.nlu);
    }
    for (;;)
    {
      this.nlo.startLayoutAnimation();
      if (!com.tencent.mm.plugin.ball.f.d.h(this.nlr)) {
        break;
      }
      Iterator localIterator = this.nlr.iterator();
      while (localIterator.hasNext()) {
        H((BallInfo)localIterator.next());
      }
      this.nlo.setLayoutAnimation(this.nlw);
    }
    AppMethodBeat.o(106502);
  }
  
  private void bHG()
  {
    AppMethodBeat.i(106503);
    if (this.neC) {
      this.nlo.setLayoutAnimation(this.nlv);
    }
    for (;;)
    {
      this.nlo.startLayoutAnimation();
      AppMethodBeat.o(106503);
      return;
      this.nlo.setLayoutAnimation(this.nlx);
    }
  }
  
  private int bHI()
  {
    AppMethodBeat.i(106506);
    if (com.tencent.mm.plugin.ball.f.d.h(this.nlr))
    {
      int i = this.nlr.size();
      int j = this.nly;
      AppMethodBeat.o(106506);
      return i * j;
    }
    AppMethodBeat.o(106506);
    return 0;
  }
  
  private void bHJ()
  {
    AppMethodBeat.i(106507);
    if (this.nlo == null)
    {
      AppMethodBeat.o(106507);
      return;
    }
    if (getVisibility() == 0)
    {
      ac.i("MicroMsg.FloatMenuView", "updateMenuContentView, ignore when visible");
      AppMethodBeat.o(106507);
      return;
    }
    this.nlD = false;
    int j;
    e.a locala;
    RelativeLayout.LayoutParams localLayoutParams;
    int k;
    boolean bool;
    if (this.nlz == 0)
    {
      i = com.tencent.mm.plugin.ball.f.e.nhQ;
      j = bHI();
      locala = com.tencent.mm.plugin.ball.f.d.Q(this.nlm, this.nln, i);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      k = com.tencent.mm.cc.a.ih(ai.getContext()) - com.tencent.mm.plugin.ball.f.e.nhP;
      if (this.nln + i + j <= k) {
        break label457;
      }
      if (this.nln - j < com.tencent.mm.plugin.ball.f.e.nib) {
        break label348;
      }
      i = this.nln - j;
      if (i >= com.tencent.mm.plugin.ball.f.e.nhP) {
        break label322;
      }
      bool = true;
      label143:
      this.nlD = bool;
      if (i >= com.tencent.mm.plugin.ball.f.e.nhP) {
        break label328;
      }
      i = com.tencent.mm.plugin.ball.f.e.nhP;
      label160:
      if ((locala != e.a.nie) && (locala != e.a.nig)) {
        break label331;
      }
      b(localLayoutParams, i);
      this.nlu.setOrder(1);
    }
    for (;;)
    {
      this.nlq.ao(true);
      this.nlo.setLayoutManager(this.nlq);
      ac.i("MicroMsg.FloatMenuView", "updateMenuContentView, anchorView:[%s, %s], margins:[%s, %s, %s, %s], enableScroll:%b", new Object[] { Integer.valueOf(this.nlm), Integer.valueOf(this.nln), Integer.valueOf(localLayoutParams.leftMargin), Integer.valueOf(localLayoutParams.topMargin), Integer.valueOf(localLayoutParams.rightMargin), Integer.valueOf(localLayoutParams.bottomMargin), Boolean.valueOf(this.nlD) });
      this.nlo.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(106507);
      return;
      i = this.nlz;
      break;
      label322:
      bool = false;
      break label143;
      label328:
      break label160;
      label331:
      a(localLayoutParams, i);
      this.nlw.setOrder(1);
    }
    label348:
    int i = k - j;
    if (i < com.tencent.mm.plugin.ball.f.e.nhP)
    {
      bool = true;
      label362:
      this.nlD = bool;
      if (i >= com.tencent.mm.plugin.ball.f.e.nhP) {
        break label437;
      }
      i = com.tencent.mm.plugin.ball.f.e.nhP;
      label379:
      if ((locala != e.a.nie) && (locala != e.a.nig)) {
        break label440;
      }
      b(localLayoutParams, i);
      this.nlu.setOrder(0);
    }
    for (;;)
    {
      this.nlq.ao(false);
      this.nlo.setLayoutManager(this.nlq);
      break;
      bool = false;
      break label362;
      label437:
      break label379;
      label440:
      a(localLayoutParams, i);
      this.nlw.setOrder(0);
    }
    label457:
    i += this.nln;
    if ((locala == e.a.nie) || (locala == e.a.nig))
    {
      b(localLayoutParams, i);
      this.nlu.setOrder(0);
    }
    for (;;)
    {
      this.nlq.ao(false);
      this.nlo.setLayoutManager(this.nlq);
      break;
      a(localLayoutParams, i);
      this.nlw.setOrder(0);
    }
  }
  
  private void bHK()
  {
    AppMethodBeat.i(106510);
    if (this.njY != null) {
      this.njY.vibrate(10L);
    }
    AppMethodBeat.o(106510);
  }
  
  private static String ca(List<BallInfo> paramList)
  {
    AppMethodBeat.i(106494);
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramList.size())
    {
      BallInfo localBallInfo = (BallInfo)paramList.get(i);
      localStringBuilder.append(localBallInfo.key).append(localBallInfo.type).append(localBallInfo.drM).append(localBallInfo.lzV).append(localBallInfo.name).append(localBallInfo.tag).append(localBallInfo.state).append(localBallInfo.nfB).append(localBallInfo.nfC).append(localBallInfo.progress).append("|");
      i += 1;
    }
    paramList = ah.dg(localStringBuilder.toString());
    AppMethodBeat.o(106494);
    return paramList;
  }
  
  private void d(int paramInt, View paramView)
  {
    AppMethodBeat.i(106497);
    if (paramInt == -1) {
      dw(this.nlA);
    }
    for (;;)
    {
      this.nlB = paramInt;
      this.nlA = paramView;
      AppMethodBeat.o(106497);
      return;
      if (paramInt != this.nlB)
      {
        dw(this.nlA);
        dv(paramView);
      }
    }
  }
  
  private void dv(View paramView)
  {
    AppMethodBeat.i(106498);
    if (paramView != null)
    {
      paramView.clearAnimation();
      if (((paramView.getTag() instanceof BallInfo)) && (!((BallInfo)paramView.getTag()).nfB))
      {
        paramView.animate().scaleX(1.1F).scaleY(1.1F).setDuration(100L).start();
        bHK();
      }
    }
    AppMethodBeat.o(106498);
  }
  
  public static void dw(View paramView)
  {
    AppMethodBeat.i(106499);
    if (paramView != null)
    {
      paramView.clearAnimation();
      paramView.animate().scaleX(1.0F).scaleY(1.0F).setDuration(100L).start();
    }
    AppMethodBeat.o(106499);
  }
  
  private void eH(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(106505);
    this.nlm = paramInt1;
    this.nln = paramInt2;
    bHJ();
    AppMethodBeat.o(106505);
  }
  
  public final void G(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106512);
    Iterator localIterator = this.nls.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.plugin.ball.d.d)localIterator.next()).t(paramBallInfo);
    }
    AppMethodBeat.o(106512);
  }
  
  public final void P(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(106496);
    float f1 = paramMotionEvent.getRawX();
    float f2 = paramMotionEvent.getRawY();
    float f3 = this.nlo.getLeft();
    float f4 = this.nlo.getTop();
    paramMotionEvent = this.nlo.o(f1 - f3, f2 - f4);
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
    List localList = com.tencent.mm.plugin.ball.f.d.bS(com.tencent.mm.plugin.ball.f.d.bR(paramList));
    String str = ca(localList);
    if (bs.lr(str, this.nkG))
    {
      ac.i("MicroMsg.FloatMenuView", "FloatMenuView ignore refresh");
      AppMethodBeat.o(106493);
      return;
    }
    this.nkG = str;
    this.nlr = localList;
    if (com.tencent.mm.plugin.ball.f.d.h(this.nlr)) {}
    for (int i = this.nlr.size();; i = 0)
    {
      ac.i("MicroMsg.FloatMenuView", "menuBallInfoList, size:%s", new Object[] { Integer.valueOf(i) });
      this.nlp.neE = this.nlr;
      this.nlp.arg.notifyChanged();
      if (com.tencent.mm.plugin.ball.f.d.h(com.tencent.mm.plugin.ball.f.d.d(paramList, paramBallInfo))) {
        break;
      }
      d(null);
      AppMethodBeat.o(106493);
      return;
    }
    eH(this.nlm, this.nln);
    AppMethodBeat.o(106493);
  }
  
  public final void bHE()
  {
    AppMethodBeat.i(106500);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bb(null);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ball/view/FloatMenuView", "com/tencent/mm/plugin/ball/view/FloatMenuView", "show", "(Landroid/animation/AnimatorListenerAdapter;)V", this, localb.aeE());
    c(null);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ball/view/FloatMenuView", "com/tencent/mm/plugin/ball/view/FloatMenuView", "show", "(Landroid/animation/AnimatorListenerAdapter;)V");
    AppMethodBeat.o(106500);
  }
  
  public final void bHH()
  {
    AppMethodBeat.i(208055);
    if (getVisibility() == 8)
    {
      ac.i("MicroMsg.FloatMenuView", "float menu already hide");
      AppMethodBeat.o(208055);
      return;
    }
    setVisibility(8);
    AppMethodBeat.o(208055);
  }
  
  public final void bHL()
  {
    AppMethodBeat.i(106511);
    Iterator localIterator = this.nls.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.plugin.ball.d.d)localIterator.next()).bGb();
    }
    AppMethodBeat.o(106511);
  }
  
  public final void c(ResultReceiver paramResultReceiver)
  {
    AppMethodBeat.i(208054);
    if (getVisibility() == 0)
    {
      ac.i("MicroMsg.FloatMenuView", "float menu already show");
      AppMethodBeat.o(208054);
      return;
    }
    this.nlE = paramResultReceiver;
    setVisibility(0);
    paramResultReceiver = ObjectAnimator.ofFloat(this, "alpha", new float[] { 0.0F, 1.0F });
    paramResultReceiver.setDuration(200L);
    paramResultReceiver.addListener(new com.tencent.mm.plugin.ball.b.e(this));
    paramResultReceiver.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(208052);
        FloatMenuView.a(FloatMenuView.this, true);
        AppMethodBeat.o(208052);
      }
    });
    paramResultReceiver.start();
    bHF();
    AppMethodBeat.o(208054);
  }
  
  public final void d(AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(106501);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bb(paramAnimatorListenerAdapter);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ball/view/FloatMenuView", "com/tencent/mm/plugin/ball/view/FloatMenuView", "hide", "(Landroid/animation/AnimatorListenerAdapter;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aeE());
    if (getVisibility() == 8)
    {
      ac.i("MicroMsg.FloatMenuView", "float menu already hide");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ball/view/FloatMenuView", "com/tencent/mm/plugin/ball/view/FloatMenuView", "hide", "(Landroid/animation/AnimatorListenerAdapter;)V");
      AppMethodBeat.o(106501);
      return;
    }
    bHG();
    localObject = ObjectAnimator.ofFloat(this, "alpha", new float[] { 1.0F, 0.0F });
    ((Animator)localObject).setDuration(200L);
    ((Animator)localObject).addListener(new com.tencent.mm.plugin.ball.b.d(this, paramAnimatorListenerAdapter));
    ((Animator)localObject).addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(208053);
        FloatMenuView.a(FloatMenuView.this, false);
        FloatMenuView.f(FloatMenuView.this);
        AppMethodBeat.o(208053);
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
      bHL();
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
    paramConfiguration = this.nls.iterator();
    while (paramConfiguration.hasNext()) {
      ((com.tencent.mm.plugin.ball.d.d)paramConfiguration.next()).nm(i);
    }
    AppMethodBeat.o(106492);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(184625);
    super.onMeasure(paramInt1, paramInt2);
    if (this.nlt != null) {
      this.nlt.bGc();
    }
    AppMethodBeat.o(184625);
  }
  
  public void setCanAddFloatBallWhenHide(boolean paramBoolean)
  {
    this.nlF = paramBoolean;
  }
  
  public void setForceShowFloatMenu(boolean paramBoolean)
  {
    this.nlC = paramBoolean;
  }
  
  public void setInLongPressMode(boolean paramBoolean)
  {
    AppMethodBeat.i(106495);
    this.neD = paramBoolean;
    this.nlp.neD = paramBoolean;
    this.nlp.arg.notifyChanged();
    AppMethodBeat.o(106495);
  }
  
  public void setOnMeasuredListener(com.tencent.mm.plugin.ball.d.e parame)
  {
    this.nlt = parame;
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(106504);
    super.setVisibility(paramInt);
    if (paramInt == 8)
    {
      ac.i("MicroMsg.FloatMenuView", "setVisibility, updateMenuContentView when GONE");
      eH(this.nlm, this.nln);
      setForceShowFloatMenu(false);
    }
    AppMethodBeat.o(106504);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.view.FloatMenuView
 * JD-Core Version:    0.7.0.1
 */