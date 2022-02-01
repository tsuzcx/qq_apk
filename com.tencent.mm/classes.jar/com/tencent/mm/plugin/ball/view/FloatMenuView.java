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
import android.support.v7.widget.RecyclerView.v;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.a.a.a;
import com.tencent.mm.plugin.ball.d.c;
import com.tencent.mm.plugin.ball.f.e.a;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class FloatMenuView
  extends RelativeLayout
  implements com.tencent.mm.plugin.ball.c.d
{
  public boolean oVo;
  public boolean oVp;
  private boolean oVs;
  private Vibrator paT;
  private String pby;
  private int pcA;
  public int pcB;
  public View pcC;
  public int pcD;
  public boolean pcE;
  private volatile boolean pcF;
  private ResultReceiver pcG;
  private boolean pcH;
  public int pco;
  public int pcp;
  private RecyclerView pcq;
  private com.tencent.mm.plugin.ball.a.a pcr;
  private LinearLayoutManager pcs;
  private List<BallInfo> pct;
  public Set<c> pcu;
  private com.tencent.mm.plugin.ball.d.d pcv;
  private LayoutAnimationController pcw;
  private LayoutAnimationController pcx;
  private LayoutAnimationController pcy;
  private LayoutAnimationController pcz;
  
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
    this.pcu = new CopyOnWriteArraySet();
    this.pcv = null;
    this.oVs = true;
    this.pcD = -1;
    this.pcE = false;
    this.pcF = false;
    this.pcG = null;
    this.pcH = false;
    View.inflate(paramContext, 2131495177, this);
    setBackgroundColor(android.support.v4.content.b.n(paramContext, 2131100481));
    setOnClickListener(new FloatMenuView.1(this));
    this.paT = ((Vibrator)paramContext.getSystemService("vibrator"));
    this.pcq = ((RecyclerView)findViewById(2131304602));
    this.pcq.setOverScrollMode(2);
    setClipChildren(false);
    this.pcq.setClipChildren(false);
    this.pcr = new com.tencent.mm.plugin.ball.a.a(paramContext);
    this.pcr.oVs = this.oVs;
    if (!this.oVs) {
      this.pcq.setItemAnimator(null);
    }
    for (;;)
    {
      this.pcr.oVr = new com.tencent.mm.plugin.ball.d.b()
      {
        public final void a(BallInfo paramAnonymousBallInfo, int paramAnonymousInt)
        {
          AppMethodBeat.i(106486);
          FloatMenuView.a(FloatMenuView.this, paramAnonymousBallInfo, paramAnonymousInt);
          AppMethodBeat.o(106486);
        }
        
        public final void d(BallInfo paramAnonymousBallInfo)
        {
          AppMethodBeat.i(106487);
          FloatMenuView.b(FloatMenuView.this, paramAnonymousBallInfo);
          AppMethodBeat.o(106487);
        }
        
        public final void v(BallInfo paramAnonymousBallInfo)
        {
          AppMethodBeat.i(106485);
          FloatMenuView.a(FloatMenuView.this, paramAnonymousBallInfo);
          AppMethodBeat.o(106485);
        }
      };
      this.pcq.setAdapter(this.pcr);
      this.pcs = new LinearLayoutManager()
      {
        public final boolean canScrollHorizontally()
        {
          return false;
        }
        
        public final boolean canScrollVertically()
        {
          AppMethodBeat.i(106488);
          boolean bool = FloatMenuView.b(FloatMenuView.this);
          AppMethodBeat.o(106488);
          return bool;
        }
      };
      this.pcs.setOrientation(1);
      this.pcq.setLayoutManager(this.pcs);
      this.pcA = (com.tencent.mm.cb.a.aH(paramContext, 2131166456) + com.tencent.mm.cb.a.aH(paramContext, 2131166472) + com.tencent.mm.cb.a.aH(paramContext, 2131166470));
      this.pcw = AnimationUtils.loadLayoutAnimation(paramContext, 2130772069);
      this.pcy = AnimationUtils.loadLayoutAnimation(paramContext, 2130772070);
      this.pcx = AnimationUtils.loadLayoutAnimation(paramContext, 2130772067);
      this.pcz = AnimationUtils.loadLayoutAnimation(paramContext, 2130772068);
      AppMethodBeat.o(106490);
      return;
      paramAttributeSet = new d.b()
      {
        public final boolean a(final RecyclerView.v paramAnonymousv, final Animator.AnimatorListener paramAnonymousAnimatorListener)
        {
          AppMethodBeat.i(217116);
          if ((paramAnonymousv == null) || (paramAnonymousv.aus == null))
          {
            AppMethodBeat.o(217116);
            return false;
          }
          float f2 = paramAnonymousv.aus.getMeasuredWidth();
          float f1 = f2;
          if (f2 <= 0.0F) {
            f1 = FloatMenuView.this.getMeasuredWidth();
          }
          f2 = f1;
          if (FloatMenuView.c(FloatMenuView.this)) {
            f2 = -f1;
          }
          Log.i("MicroMsg.FloatMenuView", "alvinluo animateRemove tranX: %f", new Object[] { Float.valueOf(f2) });
          paramAnonymousv.aus.animate().alpha(0.0F).translationX(f2).setListener(new Animator.AnimatorListener()
          {
            public final void onAnimationCancel(Animator paramAnonymous2Animator)
            {
              AppMethodBeat.i(217114);
              if (paramAnonymousAnimatorListener != null) {
                paramAnonymousAnimatorListener.onAnimationCancel(paramAnonymous2Animator);
              }
              AppMethodBeat.o(217114);
            }
            
            public final void onAnimationEnd(Animator paramAnonymous2Animator)
            {
              AppMethodBeat.i(217113);
              if (paramAnonymousAnimatorListener != null) {
                paramAnonymousAnimatorListener.onAnimationEnd(paramAnonymous2Animator);
              }
              long l = 200L;
              if (!com.tencent.mm.plugin.ball.f.d.h(FloatMenuView.d(FloatMenuView.this))) {
                l = 0L;
              }
              h.RTc.n(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(217111);
                  if (((FloatMenuView.4.1.this.amA instanceof a.a)) && (((a.a)FloatMenuView.4.1.this.amA).oVO != null)) {
                    FloatMenuView.a(FloatMenuView.this, ((a.a)FloatMenuView.4.1.this.amA).oVO, ((a.a)FloatMenuView.4.1.this.amA).position);
                  }
                  AppMethodBeat.o(217111);
                }
              }, l);
              AppMethodBeat.o(217113);
            }
            
            public final void onAnimationRepeat(Animator paramAnonymous2Animator)
            {
              AppMethodBeat.i(217115);
              if (paramAnonymousAnimatorListener != null) {
                paramAnonymousAnimatorListener.onAnimationRepeat(paramAnonymous2Animator);
              }
              AppMethodBeat.o(217115);
            }
            
            public final void onAnimationStart(Animator paramAnonymous2Animator)
            {
              AppMethodBeat.i(217112);
              if (paramAnonymousAnimatorListener != null) {
                paramAnonymousAnimatorListener.onAnimationStart(paramAnonymous2Animator);
              }
              AppMethodBeat.o(217112);
            }
          }).start();
          AppMethodBeat.o(217116);
          return true;
        }
      };
      d locald = new d();
      locald.atn = 200L;
      locald.ato = 200L;
      locald.atq = 200L;
      locald.atp = 200L;
      locald.atp = 160L;
      locald.oVt = paramAttributeSet;
      this.pcr.oVt = paramAttributeSet;
      this.pcq.setItemAnimator(locald);
    }
  }
  
  private void N(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106513);
    Iterator localIterator = this.pcu.iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).d(paramBallInfo);
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
  
  private void cjE()
  {
    AppMethodBeat.i(106502);
    if (this.oVo) {
      this.pcq.setLayoutAnimation(this.pcw);
    }
    for (;;)
    {
      this.pcq.startLayoutAnimation();
      if (!com.tencent.mm.plugin.ball.f.d.h(this.pct)) {
        break;
      }
      Iterator localIterator = this.pct.iterator();
      while (localIterator.hasNext()) {
        N((BallInfo)localIterator.next());
      }
      this.pcq.setLayoutAnimation(this.pcy);
    }
    AppMethodBeat.o(106502);
  }
  
  private void cjF()
  {
    AppMethodBeat.i(106503);
    if (this.oVo) {
      this.pcq.setLayoutAnimation(this.pcx);
    }
    for (;;)
    {
      this.pcq.startLayoutAnimation();
      AppMethodBeat.o(106503);
      return;
      this.pcq.setLayoutAnimation(this.pcz);
    }
  }
  
  private int cjH()
  {
    AppMethodBeat.i(106506);
    if (com.tencent.mm.plugin.ball.f.d.h(this.pct))
    {
      int i = this.pct.size();
      int j = this.pcA;
      AppMethodBeat.o(106506);
      return i * j;
    }
    AppMethodBeat.o(106506);
    return 0;
  }
  
  private void cjI()
  {
    AppMethodBeat.i(106507);
    if (this.pcq == null)
    {
      AppMethodBeat.o(106507);
      return;
    }
    if (getVisibility() == 0)
    {
      Log.i("MicroMsg.FloatMenuView", "updateMenuContentView, ignore when visible");
      AppMethodBeat.o(106507);
      return;
    }
    this.pcF = false;
    int j;
    e.a locala;
    RelativeLayout.LayoutParams localLayoutParams;
    int k;
    boolean bool;
    if (this.pcB == 0)
    {
      i = com.tencent.mm.plugin.ball.f.e.oYK;
      j = cjH();
      locala = com.tencent.mm.plugin.ball.f.d.T(this.pco, this.pcp, i);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      k = com.tencent.mm.cb.a.jo(MMApplicationContext.getContext()) - com.tencent.mm.plugin.ball.f.e.oYJ;
      if (this.pcp + i + j <= k) {
        break label457;
      }
      if (this.pcp - j < com.tencent.mm.plugin.ball.f.e.oYV) {
        break label348;
      }
      i = this.pcp - j;
      if (i >= com.tencent.mm.plugin.ball.f.e.oYJ) {
        break label322;
      }
      bool = true;
      label143:
      this.pcF = bool;
      if (i >= com.tencent.mm.plugin.ball.f.e.oYJ) {
        break label328;
      }
      i = com.tencent.mm.plugin.ball.f.e.oYJ;
      label160:
      if ((locala != e.a.oYX) && (locala != e.a.oYZ)) {
        break label331;
      }
      b(localLayoutParams, i);
      this.pcw.setOrder(1);
    }
    for (;;)
    {
      this.pcs.an(true);
      this.pcq.setLayoutManager(this.pcs);
      Log.i("MicroMsg.FloatMenuView", "updateMenuContentView, anchorView:[%s, %s], margins:[%s, %s, %s, %s], enableScroll:%b", new Object[] { Integer.valueOf(this.pco), Integer.valueOf(this.pcp), Integer.valueOf(localLayoutParams.leftMargin), Integer.valueOf(localLayoutParams.topMargin), Integer.valueOf(localLayoutParams.rightMargin), Integer.valueOf(localLayoutParams.bottomMargin), Boolean.valueOf(this.pcF) });
      this.pcq.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(106507);
      return;
      i = this.pcB;
      break;
      label322:
      bool = false;
      break label143;
      label328:
      break label160;
      label331:
      a(localLayoutParams, i);
      this.pcy.setOrder(1);
    }
    label348:
    int i = k - j;
    if (i < com.tencent.mm.plugin.ball.f.e.oYJ)
    {
      bool = true;
      label362:
      this.pcF = bool;
      if (i >= com.tencent.mm.plugin.ball.f.e.oYJ) {
        break label437;
      }
      i = com.tencent.mm.plugin.ball.f.e.oYJ;
      label379:
      if ((locala != e.a.oYX) && (locala != e.a.oYZ)) {
        break label440;
      }
      b(localLayoutParams, i);
      this.pcw.setOrder(0);
    }
    for (;;)
    {
      this.pcs.an(false);
      this.pcq.setLayoutManager(this.pcs);
      break;
      bool = false;
      break label362;
      label437:
      break label379;
      label440:
      a(localLayoutParams, i);
      this.pcy.setOrder(0);
    }
    label457:
    i += this.pcp;
    if ((locala == e.a.oYX) || (locala == e.a.oYZ))
    {
      b(localLayoutParams, i);
      this.pcw.setOrder(0);
    }
    for (;;)
    {
      this.pcs.an(false);
      this.pcq.setLayoutManager(this.pcs);
      break;
      a(localLayoutParams, i);
      this.pcy.setOrder(0);
    }
  }
  
  private void cjJ()
  {
    AppMethodBeat.i(106510);
    if (this.paT != null) {
      this.paT.vibrate(10L);
    }
    AppMethodBeat.o(106510);
  }
  
  private static String cs(List<BallInfo> paramList)
  {
    AppMethodBeat.i(106494);
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramList.size())
    {
      BallInfo localBallInfo = (BallInfo)paramList.get(i);
      localStringBuilder.append(localBallInfo.key).append(localBallInfo.type).append(localBallInfo.icon).append(localBallInfo.noe).append(localBallInfo.name).append(localBallInfo.tag).append(localBallInfo.state).append(localBallInfo.oWr).append(localBallInfo.nno).append(localBallInfo.progress).append("|");
      i += 1;
    }
    paramList = MD5Util.getMD5String(localStringBuilder.toString());
    AppMethodBeat.o(106494);
    return paramList;
  }
  
  private void d(int paramInt, View paramView)
  {
    AppMethodBeat.i(106497);
    if (paramInt == -1) {
      dp(this.pcC);
    }
    for (;;)
    {
      this.pcD = paramInt;
      this.pcC = paramView;
      AppMethodBeat.o(106497);
      return;
      if (paramInt != this.pcD)
      {
        dp(this.pcC);
        jdMethod_do(paramView);
      }
    }
  }
  
  private void jdMethod_do(View paramView)
  {
    AppMethodBeat.i(106498);
    if (paramView != null)
    {
      paramView.clearAnimation();
      if (((paramView.getTag() instanceof BallInfo)) && (!((BallInfo)paramView.getTag()).oWr))
      {
        paramView.animate().scaleX(1.1F).scaleY(1.1F).setDuration(100L).start();
        cjJ();
      }
    }
    AppMethodBeat.o(106498);
  }
  
  public static void dp(View paramView)
  {
    AppMethodBeat.i(106499);
    if (paramView != null)
    {
      paramView.clearAnimation();
      paramView.animate().scaleX(1.0F).scaleY(1.0F).setDuration(100L).start();
    }
    AppMethodBeat.o(106499);
  }
  
  private void eZ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(106505);
    this.pco = paramInt1;
    this.pcp = paramInt2;
    cjI();
    AppMethodBeat.o(106505);
  }
  
  public final void M(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106512);
    Iterator localIterator = this.pcu.iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).v(paramBallInfo);
    }
    AppMethodBeat.o(106512);
  }
  
  public final void P(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(106496);
    float f1 = paramMotionEvent.getRawX();
    float f2 = paramMotionEvent.getRawY();
    float f3 = this.pcq.getLeft();
    float f4 = this.pcq.getTop();
    paramMotionEvent = this.pcq.o(f1 - f3, f2 - f4);
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
    List localList = com.tencent.mm.plugin.ball.f.d.cj(com.tencent.mm.plugin.ball.f.d.ci(paramList));
    String str = cs(localList);
    if (Util.isEqual(str, this.pby))
    {
      Log.i("MicroMsg.FloatMenuView", "FloatMenuView ignore refresh");
      AppMethodBeat.o(106493);
      return;
    }
    this.pby = str;
    this.pct = localList;
    if (com.tencent.mm.plugin.ball.f.d.h(this.pct)) {}
    for (int i = this.pct.size();; i = 0)
    {
      Log.i("MicroMsg.FloatMenuView", "menuBallInfoList, size:%s", new Object[] { Integer.valueOf(i) });
      this.pcr.oVq = this.pct;
      this.pcr.atj.notifyChanged();
      if (com.tencent.mm.plugin.ball.f.d.h(com.tencent.mm.plugin.ball.f.d.d(paramList, paramBallInfo))) {
        break;
      }
      e(null);
      AppMethodBeat.o(106493);
      return;
    }
    eZ(this.pco, this.pcp);
    AppMethodBeat.o(106493);
  }
  
  public final void c(ResultReceiver paramResultReceiver)
  {
    AppMethodBeat.i(217120);
    if (getVisibility() == 0)
    {
      Log.i("MicroMsg.FloatMenuView", "float menu already show");
      AppMethodBeat.o(217120);
      return;
    }
    this.pcG = paramResultReceiver;
    setVisibility(0);
    paramResultReceiver = ObjectAnimator.ofFloat(this, "alpha", new float[] { 0.0F, 1.0F });
    paramResultReceiver.setDuration(200L);
    paramResultReceiver.addListener(new com.tencent.mm.plugin.ball.b.e(this, null));
    paramResultReceiver.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(217118);
        FloatMenuView.a(FloatMenuView.this, true);
        AppMethodBeat.o(217118);
      }
    });
    paramResultReceiver.start();
    cjE();
    AppMethodBeat.o(217120);
  }
  
  public final void cjD()
  {
    AppMethodBeat.i(106500);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bm(null);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ball/view/FloatMenuView", "com/tencent/mm/plugin/ball/view/FloatMenuView", "show", "(Landroid/animation/AnimatorListenerAdapter;)V", this, localb.axR());
    c(null);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ball/view/FloatMenuView", "com/tencent/mm/plugin/ball/view/FloatMenuView", "show", "(Landroid/animation/AnimatorListenerAdapter;)V");
    AppMethodBeat.o(106500);
  }
  
  public final void cjG()
  {
    AppMethodBeat.i(217121);
    if (getVisibility() == 8)
    {
      Log.i("MicroMsg.FloatMenuView", "float menu already hide");
      AppMethodBeat.o(217121);
      return;
    }
    setVisibility(8);
    AppMethodBeat.o(217121);
  }
  
  public final void cjK()
  {
    AppMethodBeat.i(106511);
    Iterator localIterator = this.pcu.iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).cid();
    }
    AppMethodBeat.o(106511);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(106491);
    if (((paramKeyEvent.getKeyCode() == 4) || (paramKeyEvent.getKeyCode() == 3) || (paramKeyEvent.getKeyCode() == 82)) && (paramKeyEvent.getAction() == 0))
    {
      cjK();
      AppMethodBeat.o(106491);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(106491);
    return bool;
  }
  
  public final void e(AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(106501);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnimatorListenerAdapter);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ball/view/FloatMenuView", "com/tencent/mm/plugin/ball/view/FloatMenuView", "hide", "(Landroid/animation/AnimatorListenerAdapter;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
    if (getVisibility() == 8)
    {
      Log.i("MicroMsg.FloatMenuView", "float menu already hide");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ball/view/FloatMenuView", "com/tencent/mm/plugin/ball/view/FloatMenuView", "hide", "(Landroid/animation/AnimatorListenerAdapter;)V");
      AppMethodBeat.o(106501);
      return;
    }
    cjF();
    localObject = ObjectAnimator.ofFloat(this, "alpha", new float[] { 1.0F, 0.0F });
    ((Animator)localObject).setDuration(200L);
    ((Animator)localObject).addListener(new com.tencent.mm.plugin.ball.b.d(this, paramAnimatorListenerAdapter));
    ((Animator)localObject).addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(217119);
        FloatMenuView.a(FloatMenuView.this, false);
        FloatMenuView.f(FloatMenuView.this);
        AppMethodBeat.o(217119);
      }
    });
    ((Animator)localObject).start();
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ball/view/FloatMenuView", "com/tencent/mm/plugin/ball/view/FloatMenuView", "hide", "(Landroid/animation/AnimatorListenerAdapter;)V");
    AppMethodBeat.o(106501);
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(106492);
    int i = paramConfiguration.orientation;
    paramConfiguration = this.pcu.iterator();
    while (paramConfiguration.hasNext()) {
      ((c)paramConfiguration.next()).onOrientationChange(i);
    }
    AppMethodBeat.o(106492);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(184625);
    super.onMeasure(paramInt1, paramInt2);
    if (this.pcv != null) {
      this.pcv.cie();
    }
    AppMethodBeat.o(184625);
  }
  
  public void setCanAddFloatBallWhenHide(boolean paramBoolean)
  {
    this.pcH = paramBoolean;
  }
  
  public void setForceShowFloatMenu(boolean paramBoolean)
  {
    this.pcE = paramBoolean;
  }
  
  public void setInLongPressMode(boolean paramBoolean)
  {
    AppMethodBeat.i(106495);
    this.oVp = paramBoolean;
    this.pcr.oVp = paramBoolean;
    this.pcr.atj.notifyChanged();
    AppMethodBeat.o(106495);
  }
  
  public void setOnMeasuredListener(com.tencent.mm.plugin.ball.d.d paramd)
  {
    this.pcv = paramd;
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(106504);
    super.setVisibility(paramInt);
    if (paramInt == 8)
    {
      Log.i("MicroMsg.FloatMenuView", "setVisibility, updateMenuContentView when GONE");
      eZ(this.pco, this.pcp);
      setForceShowFloatMenu(false);
    }
    AppMethodBeat.o(106504);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.view.FloatMenuView
 * JD-Core Version:    0.7.0.1
 */