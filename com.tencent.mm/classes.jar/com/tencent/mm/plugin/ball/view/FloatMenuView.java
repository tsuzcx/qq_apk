package com.tencent.mm.plugin.ball.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.os.ResultReceiver;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.a.b;
import com.tencent.mm.plugin.ball.a.c;
import com.tencent.mm.plugin.ball.a.e;
import com.tencent.mm.plugin.ball.a.f;
import com.tencent.mm.plugin.ball.d.c;
import com.tencent.mm.plugin.ball.f.e.a;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class FloatMenuView
  extends RelativeLayout
  implements com.tencent.mm.plugin.ball.c.d
{
  private Vibrator uAL;
  public boolean viE;
  public boolean viF;
  private boolean viI;
  private String voX;
  public int vqe;
  public int vqf;
  private RecyclerView vqg;
  private com.tencent.mm.plugin.ball.a.a vqh;
  private LinearLayoutManager vqi;
  private List<BallInfo> vqj;
  public Set<c> vqk;
  private com.tencent.mm.plugin.ball.d.d vql;
  private LayoutAnimationController vqm;
  private LayoutAnimationController vqn;
  private LayoutAnimationController vqo;
  private LayoutAnimationController vqp;
  private int vqq;
  public int vqr;
  public View vqs;
  public int vqt;
  public boolean vqu;
  private volatile boolean vqv;
  private ResultReceiver vqw;
  private boolean vqx;
  
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
    this.vqk = new CopyOnWriteArraySet();
    this.vql = null;
    this.viI = true;
    this.vqt = -1;
    this.vqu = false;
    this.vqv = false;
    this.vqw = null;
    this.vqx = false;
    View.inflate(paramContext, a.f.layout_float_menu_view, this);
    setBackgroundColor(androidx.core.content.a.w(paramContext, a.b.float_menu_view_background));
    setOnClickListener(new FloatMenuView.1(this));
    this.uAL = ((Vibrator)paramContext.getSystemService("vibrator"));
    this.vqg = ((RecyclerView)findViewById(a.e.menuRecyclerView));
    this.vqg.setOverScrollMode(2);
    setClipChildren(false);
    this.vqg.setClipChildren(false);
    this.vqh = new com.tencent.mm.plugin.ball.a.a(paramContext);
    this.vqh.viI = this.viI;
    if (!this.viI) {
      this.vqg.setItemAnimator(null);
    }
    for (;;)
    {
      this.vqh.viH = new com.tencent.mm.plugin.ball.d.b()
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
      this.vqg.setAdapter(this.vqh);
      this.vqi = new LinearLayoutManager()
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
      this.vqi.setOrientation(1);
      this.vqg.setLayoutManager(this.vqi);
      this.vqq = (com.tencent.mm.cd.a.bs(paramContext, a.c.float_menu_item_height_active) + com.tencent.mm.cd.a.bs(paramContext, a.c.float_menu_item_shadow_top) + com.tencent.mm.cd.a.bs(paramContext, a.c.float_menu_item_shadow_bottom));
      this.vqm = AnimationUtils.loadLayoutAnimation(paramContext, com.tencent.mm.plugin.ball.a.a.float_menu_layout_show_animation_left);
      this.vqo = AnimationUtils.loadLayoutAnimation(paramContext, com.tencent.mm.plugin.ball.a.a.float_menu_layout_show_animation_right);
      this.vqn = AnimationUtils.loadLayoutAnimation(paramContext, com.tencent.mm.plugin.ball.a.a.float_menu_layout_hide_animation_left);
      this.vqp = AnimationUtils.loadLayoutAnimation(paramContext, com.tencent.mm.plugin.ball.a.a.float_menu_layout_hide_animation_right);
      AppMethodBeat.o(106490);
      return;
      paramAttributeSet = new d.b()
      {
        public final boolean a(final RecyclerView.v paramAnonymousv, final Animator.AnimatorListener paramAnonymousAnimatorListener)
        {
          AppMethodBeat.i(288504);
          if ((paramAnonymousv == null) || (paramAnonymousv.caK == null))
          {
            AppMethodBeat.o(288504);
            return false;
          }
          float f2 = paramAnonymousv.caK.getMeasuredWidth();
          float f1 = f2;
          if (f2 <= 0.0F) {
            f1 = FloatMenuView.this.getMeasuredWidth();
          }
          f2 = f1;
          if (FloatMenuView.c(FloatMenuView.this)) {
            f2 = -f1;
          }
          Log.i("MicroMsg.FloatMenuView", "alvinluo animateRemove tranX: %f", new Object[] { Float.valueOf(f2) });
          paramAnonymousv.caK.animate().alpha(0.0F).translationX(f2).setListener(new Animator.AnimatorListener()
          {
            public final void onAnimationCancel(Animator paramAnonymous2Animator)
            {
              AppMethodBeat.i(288460);
              if (paramAnonymousAnimatorListener != null) {
                paramAnonymousAnimatorListener.onAnimationCancel(paramAnonymous2Animator);
              }
              AppMethodBeat.o(288460);
            }
            
            public final void onAnimationEnd(Animator paramAnonymous2Animator)
            {
              AppMethodBeat.i(288457);
              if (paramAnonymousAnimatorListener != null) {
                paramAnonymousAnimatorListener.onAnimationEnd(paramAnonymous2Animator);
              }
              long l = 200L;
              if (!com.tencent.mm.plugin.ball.f.d.checkListNotEmpty(FloatMenuView.d(FloatMenuView.this))) {
                l = 0L;
              }
              h.ahAA.o(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(288442);
                  if (((FloatMenuView.4.1.this.bUU instanceof com.tencent.mm.plugin.ball.a.a.a)) && (((com.tencent.mm.plugin.ball.a.a.a)FloatMenuView.4.1.this.bUU).vjd != null)) {
                    FloatMenuView.a(FloatMenuView.this, ((com.tencent.mm.plugin.ball.a.a.a)FloatMenuView.4.1.this.bUU).vjd, ((com.tencent.mm.plugin.ball.a.a.a)FloatMenuView.4.1.this.bUU).position);
                  }
                  AppMethodBeat.o(288442);
                }
              }, l);
              AppMethodBeat.o(288457);
            }
            
            public final void onAnimationRepeat(Animator paramAnonymous2Animator)
            {
              AppMethodBeat.i(288462);
              if (paramAnonymousAnimatorListener != null) {
                paramAnonymousAnimatorListener.onAnimationRepeat(paramAnonymous2Animator);
              }
              AppMethodBeat.o(288462);
            }
            
            public final void onAnimationStart(Animator paramAnonymous2Animator)
            {
              AppMethodBeat.i(288452);
              if (paramAnonymousAnimatorListener != null) {
                paramAnonymousAnimatorListener.onAnimationStart(paramAnonymous2Animator);
              }
              AppMethodBeat.o(288452);
            }
          }).start();
          AppMethodBeat.o(288504);
          return true;
        }
      };
      d locald = new d();
      locald.bZI = 200L;
      locald.bZJ = 200L;
      locald.bZL = 200L;
      locald.bZK = 200L;
      locald.bZK = 160L;
      locald.viJ = paramAttributeSet;
      this.vqh.viJ = paramAttributeSet;
      this.vqg.setItemAnimator(locald);
    }
  }
  
  private void R(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106513);
    Iterator localIterator = this.vqk.iterator();
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
  
  private void cZG()
  {
    AppMethodBeat.i(106502);
    if (this.viE) {
      this.vqg.setLayoutAnimation(this.vqm);
    }
    for (;;)
    {
      this.vqg.startLayoutAnimation();
      if (!com.tencent.mm.plugin.ball.f.d.checkListNotEmpty(this.vqj)) {
        break;
      }
      Iterator localIterator = this.vqj.iterator();
      while (localIterator.hasNext()) {
        R((BallInfo)localIterator.next());
      }
      this.vqg.setLayoutAnimation(this.vqo);
    }
    AppMethodBeat.o(106502);
  }
  
  private void cZH()
  {
    AppMethodBeat.i(106503);
    if (this.viE) {
      this.vqg.setLayoutAnimation(this.vqn);
    }
    for (;;)
    {
      this.vqg.startLayoutAnimation();
      AppMethodBeat.o(106503);
      return;
      this.vqg.setLayoutAnimation(this.vqp);
    }
  }
  
  private int cZJ()
  {
    AppMethodBeat.i(106506);
    if (com.tencent.mm.plugin.ball.f.d.checkListNotEmpty(this.vqj))
    {
      int i = this.vqj.size();
      int j = this.vqq;
      AppMethodBeat.o(106506);
      return i * j;
    }
    AppMethodBeat.o(106506);
    return 0;
  }
  
  private void cZK()
  {
    AppMethodBeat.i(106507);
    if (this.vqg == null)
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
    this.vqv = false;
    int j;
    e.a locala;
    RelativeLayout.LayoutParams localLayoutParams;
    int k;
    boolean bool;
    if (this.vqr == 0)
    {
      i = com.tencent.mm.plugin.ball.f.e.vmd;
      j = cZJ();
      locala = com.tencent.mm.plugin.ball.f.d.al(this.vqe, this.vqf, i);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      k = com.tencent.mm.cd.a.mt(MMApplicationContext.getContext()) - com.tencent.mm.plugin.ball.f.e.vmc;
      if (this.vqf + i + j <= k) {
        break label457;
      }
      if (this.vqf - j < com.tencent.mm.plugin.ball.f.e.vmo) {
        break label348;
      }
      i = this.vqf - j;
      if (i >= com.tencent.mm.plugin.ball.f.e.vmc) {
        break label322;
      }
      bool = true;
      label143:
      this.vqv = bool;
      if (i >= com.tencent.mm.plugin.ball.f.e.vmc) {
        break label328;
      }
      i = com.tencent.mm.plugin.ball.f.e.vmc;
      label160:
      if ((locala != e.a.vmq) && (locala != e.a.vms)) {
        break label331;
      }
      b(localLayoutParams, i);
      this.vqm.setOrder(1);
    }
    for (;;)
    {
      this.vqi.aY(true);
      this.vqg.setLayoutManager(this.vqi);
      Log.i("MicroMsg.FloatMenuView", "updateMenuContentView, anchorView:[%s, %s], margins:[%s, %s, %s, %s], enableScroll:%b", new Object[] { Integer.valueOf(this.vqe), Integer.valueOf(this.vqf), Integer.valueOf(localLayoutParams.leftMargin), Integer.valueOf(localLayoutParams.topMargin), Integer.valueOf(localLayoutParams.rightMargin), Integer.valueOf(localLayoutParams.bottomMargin), Boolean.valueOf(this.vqv) });
      this.vqg.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(106507);
      return;
      i = this.vqr;
      break;
      label322:
      bool = false;
      break label143;
      label328:
      break label160;
      label331:
      a(localLayoutParams, i);
      this.vqo.setOrder(1);
    }
    label348:
    int i = k - j;
    if (i < com.tencent.mm.plugin.ball.f.e.vmc)
    {
      bool = true;
      label362:
      this.vqv = bool;
      if (i >= com.tencent.mm.plugin.ball.f.e.vmc) {
        break label437;
      }
      i = com.tencent.mm.plugin.ball.f.e.vmc;
      label379:
      if ((locala != e.a.vmq) && (locala != e.a.vms)) {
        break label440;
      }
      b(localLayoutParams, i);
      this.vqm.setOrder(0);
    }
    for (;;)
    {
      this.vqi.aY(false);
      this.vqg.setLayoutManager(this.vqi);
      break;
      bool = false;
      break label362;
      label437:
      break label379;
      label440:
      a(localLayoutParams, i);
      this.vqo.setOrder(0);
    }
    label457:
    i += this.vqf;
    if ((locala == e.a.vmq) || (locala == e.a.vms))
    {
      b(localLayoutParams, i);
      this.vqm.setOrder(0);
    }
    for (;;)
    {
      this.vqi.aY(false);
      this.vqg.setLayoutManager(this.vqi);
      break;
      a(localLayoutParams, i);
      this.vqo.setOrder(0);
    }
  }
  
  private void cZL()
  {
    AppMethodBeat.i(106510);
    if (this.uAL != null) {
      this.uAL.vibrate(10L);
    }
    AppMethodBeat.o(106510);
  }
  
  private static String eg(List<BallInfo> paramList)
  {
    AppMethodBeat.i(106494);
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramList.size())
    {
      BallInfo localBallInfo = (BallInfo)paramList.get(i);
      localStringBuilder.append(localBallInfo.key).append(localBallInfo.type).append(localBallInfo.icon).append(localBallInfo.tus).append(localBallInfo.name).append(localBallInfo.tag).append(localBallInfo.state).append(localBallInfo.vjH).append(localBallInfo.trn).append(localBallInfo.hQO).append("|");
      i += 1;
    }
    paramList = MD5Util.getMD5String(localStringBuilder.toString());
    AppMethodBeat.o(106494);
    return paramList;
  }
  
  private void ey(View paramView)
  {
    AppMethodBeat.i(106498);
    if (paramView != null)
    {
      paramView.clearAnimation();
      if (((paramView.getTag() instanceof BallInfo)) && (!((BallInfo)paramView.getTag()).vjH))
      {
        paramView.animate().scaleX(1.1F).scaleY(1.1F).setDuration(100L).start();
        cZL();
      }
    }
    AppMethodBeat.o(106498);
  }
  
  public static void ez(View paramView)
  {
    AppMethodBeat.i(106499);
    if (paramView != null)
    {
      paramView.clearAnimation();
      paramView.animate().scaleX(1.0F).scaleY(1.0F).setDuration(100L).start();
    }
    AppMethodBeat.o(106499);
  }
  
  private void f(int paramInt, View paramView)
  {
    AppMethodBeat.i(106497);
    if (paramInt == -1) {
      ez(this.vqs);
    }
    for (;;)
    {
      this.vqt = paramInt;
      this.vqs = paramView;
      AppMethodBeat.o(106497);
      return;
      if (paramInt != this.vqt)
      {
        ez(this.vqs);
        ey(paramView);
      }
    }
  }
  
  private void gq(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(106505);
    this.vqe = paramInt1;
    this.vqf = paramInt2;
    cZK();
    AppMethodBeat.o(106505);
  }
  
  public final void Q(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106512);
    Iterator localIterator = this.vqk.iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).v(paramBallInfo);
    }
    AppMethodBeat.o(106512);
  }
  
  public final void Y(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(106496);
    float f1 = paramMotionEvent.getRawX();
    float f2 = paramMotionEvent.getRawY();
    float f3 = this.vqg.getLeft();
    float f4 = this.vqg.getTop();
    paramMotionEvent = this.vqg.Q(f1 - f3, f2 - f4);
    if (paramMotionEvent != null)
    {
      f(RecyclerView.bA(paramMotionEvent), paramMotionEvent);
      AppMethodBeat.o(106496);
      return;
    }
    f(-1, null);
    AppMethodBeat.o(106496);
  }
  
  public final void a(List<BallInfo> paramList, BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106493);
    List localList = com.tencent.mm.plugin.ball.f.d.dX(com.tencent.mm.plugin.ball.f.d.dW(paramList));
    String str = eg(localList);
    if (Util.isEqual(str, this.voX))
    {
      Log.i("MicroMsg.FloatMenuView", "FloatMenuView ignore refresh");
      AppMethodBeat.o(106493);
      return;
    }
    this.voX = str;
    this.vqj = localList;
    if (com.tencent.mm.plugin.ball.f.d.checkListNotEmpty(this.vqj)) {}
    for (int i = this.vqj.size();; i = 0)
    {
      Log.i("MicroMsg.FloatMenuView", "menuBallInfoList, size:%s", new Object[] { Integer.valueOf(i) });
      this.vqh.viG = this.vqj;
      this.vqh.bZE.notifyChanged();
      if (com.tencent.mm.plugin.ball.f.d.checkListNotEmpty(com.tencent.mm.plugin.ball.f.d.d(paramList, paramBallInfo))) {
        break;
      }
      e(null);
      AppMethodBeat.o(106493);
      return;
    }
    gq(this.vqe, this.vqf);
    AppMethodBeat.o(106493);
  }
  
  public final void cZF()
  {
    AppMethodBeat.i(106500);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(null);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/ball/view/FloatMenuView", "com/tencent/mm/plugin/ball/view/FloatMenuView", "show", "(Landroid/animation/AnimatorListenerAdapter;)V", this, localb.aYj());
    d(null);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ball/view/FloatMenuView", "com/tencent/mm/plugin/ball/view/FloatMenuView", "show", "(Landroid/animation/AnimatorListenerAdapter;)V");
    AppMethodBeat.o(106500);
  }
  
  public final void cZI()
  {
    AppMethodBeat.i(288650);
    if (getVisibility() == 8)
    {
      Log.i("MicroMsg.FloatMenuView", "float menu already hide");
      AppMethodBeat.o(288650);
      return;
    }
    setVisibility(8);
    AppMethodBeat.o(288650);
  }
  
  public final void cZM()
  {
    AppMethodBeat.i(106511);
    Iterator localIterator = this.vqk.iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).cYa();
    }
    AppMethodBeat.o(106511);
  }
  
  public final void d(ResultReceiver paramResultReceiver)
  {
    AppMethodBeat.i(288641);
    if (getVisibility() == 0)
    {
      Log.i("MicroMsg.FloatMenuView", "float menu already show");
      AppMethodBeat.o(288641);
      return;
    }
    this.vqw = paramResultReceiver;
    setVisibility(0);
    paramResultReceiver = ObjectAnimator.ofFloat(this, "alpha", new float[] { 0.0F, 1.0F });
    paramResultReceiver.setDuration(200L);
    paramResultReceiver.addListener(new com.tencent.mm.plugin.ball.b.e(this, null));
    paramResultReceiver.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(288500);
        FloatMenuView.a(FloatMenuView.this, true);
        AppMethodBeat.o(288500);
      }
    });
    paramResultReceiver.start();
    cZG();
    AppMethodBeat.o(288641);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(106491);
    if (((paramKeyEvent.getKeyCode() == 4) || (paramKeyEvent.getKeyCode() == 3) || (paramKeyEvent.getKeyCode() == 82)) && (paramKeyEvent.getAction() == 0))
    {
      cZM();
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
    ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnimatorListenerAdapter);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/ball/view/FloatMenuView", "com/tencent/mm/plugin/ball/view/FloatMenuView", "hide", "(Landroid/animation/AnimatorListenerAdapter;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
    if (getVisibility() == 8)
    {
      Log.i("MicroMsg.FloatMenuView", "float menu already hide");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ball/view/FloatMenuView", "com/tencent/mm/plugin/ball/view/FloatMenuView", "hide", "(Landroid/animation/AnimatorListenerAdapter;)V");
      AppMethodBeat.o(106501);
      return;
    }
    cZH();
    localObject = ObjectAnimator.ofFloat(this, "alpha", new float[] { 1.0F, 0.0F });
    ((Animator)localObject).setDuration(200L);
    ((Animator)localObject).addListener(new com.tencent.mm.plugin.ball.b.d(this, paramAnimatorListenerAdapter));
    ((Animator)localObject).addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(288486);
        FloatMenuView.a(FloatMenuView.this, false);
        FloatMenuView.f(FloatMenuView.this);
        AppMethodBeat.o(288486);
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
    paramConfiguration = this.vqk.iterator();
    while (paramConfiguration.hasNext()) {
      ((c)paramConfiguration.next()).onOrientationChange(i);
    }
    AppMethodBeat.o(106492);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(184625);
    super.onMeasure(paramInt1, paramInt2);
    if (this.vql != null) {
      this.vql.cYb();
    }
    AppMethodBeat.o(184625);
  }
  
  public void setCanAddFloatBallWhenHide(boolean paramBoolean)
  {
    this.vqx = paramBoolean;
  }
  
  public void setForceShowFloatMenu(boolean paramBoolean)
  {
    this.vqu = paramBoolean;
  }
  
  public void setInLongPressMode(boolean paramBoolean)
  {
    AppMethodBeat.i(106495);
    this.viF = paramBoolean;
    this.vqh.viF = paramBoolean;
    this.vqh.bZE.notifyChanged();
    AppMethodBeat.o(106495);
  }
  
  public void setOnMeasuredListener(com.tencent.mm.plugin.ball.d.d paramd)
  {
    this.vql = paramd;
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(106504);
    super.setVisibility(paramInt);
    if (paramInt == 8)
    {
      Log.i("MicroMsg.FloatMenuView", "setVisibility, updateMenuContentView when GONE");
      gq(this.vqe, this.vqf);
      setForceShowFloatMenu(false);
    }
    AppMethodBeat.o(106504);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.view.FloatMenuView
 * JD-Core Version:    0.7.0.1
 */