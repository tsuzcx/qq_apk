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
import com.tencent.e.h;
import com.tencent.e.i;
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
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class FloatMenuView
  extends RelativeLayout
  implements com.tencent.mm.plugin.ball.c.d
{
  public boolean rXn;
  public boolean rXo;
  private boolean rXr;
  private Vibrator rqC;
  private String sdy;
  private LayoutAnimationController seA;
  private LayoutAnimationController seB;
  private int seC;
  public int seD;
  public View seE;
  public int seF;
  public boolean seG;
  private volatile boolean seH;
  private ResultReceiver seI;
  private boolean seJ;
  public int seo;
  public int sep;
  private RecyclerView ser;
  private com.tencent.mm.plugin.ball.a.a ses;
  private LinearLayoutManager set;
  private List<BallInfo> seu;
  public Set<c> sev;
  private com.tencent.mm.plugin.ball.d.d sew;
  private LayoutAnimationController sey;
  private LayoutAnimationController sez;
  
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
    this.sev = new CopyOnWriteArraySet();
    this.sew = null;
    this.rXr = true;
    this.seF = -1;
    this.seG = false;
    this.seH = false;
    this.seI = null;
    this.seJ = false;
    View.inflate(paramContext, a.f.layout_float_menu_view, this);
    setBackgroundColor(androidx.core.content.a.w(paramContext, a.b.float_menu_view_background));
    setOnClickListener(new FloatMenuView.1(this));
    this.rqC = ((Vibrator)paramContext.getSystemService("vibrator"));
    this.ser = ((RecyclerView)findViewById(a.e.menuRecyclerView));
    this.ser.setOverScrollMode(2);
    setClipChildren(false);
    this.ser.setClipChildren(false);
    this.ses = new com.tencent.mm.plugin.ball.a.a(paramContext);
    this.ses.rXr = this.rXr;
    if (!this.rXr) {
      this.ser.setItemAnimator(null);
    }
    for (;;)
    {
      this.ses.rXq = new com.tencent.mm.plugin.ball.d.b()
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
      this.ser.setAdapter(this.ses);
      this.set = new LinearLayoutManager()
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
      this.set.setOrientation(1);
      this.ser.setLayoutManager(this.set);
      this.seC = (com.tencent.mm.ci.a.aZ(paramContext, a.c.float_menu_item_height_active) + com.tencent.mm.ci.a.aZ(paramContext, a.c.float_menu_item_shadow_top) + com.tencent.mm.ci.a.aZ(paramContext, a.c.float_menu_item_shadow_bottom));
      this.sey = AnimationUtils.loadLayoutAnimation(paramContext, com.tencent.mm.plugin.ball.a.a.float_menu_layout_show_animation_left);
      this.seA = AnimationUtils.loadLayoutAnimation(paramContext, com.tencent.mm.plugin.ball.a.a.float_menu_layout_show_animation_right);
      this.sez = AnimationUtils.loadLayoutAnimation(paramContext, com.tencent.mm.plugin.ball.a.a.float_menu_layout_hide_animation_left);
      this.seB = AnimationUtils.loadLayoutAnimation(paramContext, com.tencent.mm.plugin.ball.a.a.float_menu_layout_hide_animation_right);
      AppMethodBeat.o(106490);
      return;
      paramAttributeSet = new d.b()
      {
        public final boolean a(final RecyclerView.v paramAnonymousv, final Animator.AnimatorListener paramAnonymousAnimatorListener)
        {
          AppMethodBeat.i(187491);
          if ((paramAnonymousv == null) || (paramAnonymousv.amk == null))
          {
            AppMethodBeat.o(187491);
            return false;
          }
          float f2 = paramAnonymousv.amk.getMeasuredWidth();
          float f1 = f2;
          if (f2 <= 0.0F) {
            f1 = FloatMenuView.this.getMeasuredWidth();
          }
          f2 = f1;
          if (FloatMenuView.c(FloatMenuView.this)) {
            f2 = -f1;
          }
          Log.i("MicroMsg.FloatMenuView", "alvinluo animateRemove tranX: %f", new Object[] { Float.valueOf(f2) });
          paramAnonymousv.amk.animate().alpha(0.0F).translationX(f2).setListener(new Animator.AnimatorListener()
          {
            public final void onAnimationCancel(Animator paramAnonymous2Animator)
            {
              AppMethodBeat.i(187444);
              if (paramAnonymousAnimatorListener != null) {
                paramAnonymousAnimatorListener.onAnimationCancel(paramAnonymous2Animator);
              }
              AppMethodBeat.o(187444);
            }
            
            public final void onAnimationEnd(Animator paramAnonymous2Animator)
            {
              AppMethodBeat.i(187443);
              if (paramAnonymousAnimatorListener != null) {
                paramAnonymousAnimatorListener.onAnimationEnd(paramAnonymous2Animator);
              }
              long l = 200L;
              if (!com.tencent.mm.plugin.ball.f.d.checkListNotEmpty(FloatMenuView.d(FloatMenuView.this))) {
                l = 0L;
              }
              h.ZvG.n(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(186230);
                  if (((FloatMenuView.4.1.this.ago instanceof com.tencent.mm.plugin.ball.a.a.a)) && (((com.tencent.mm.plugin.ball.a.a.a)FloatMenuView.4.1.this.ago).rXN != null)) {
                    FloatMenuView.a(FloatMenuView.this, ((com.tencent.mm.plugin.ball.a.a.a)FloatMenuView.4.1.this.ago).rXN, ((com.tencent.mm.plugin.ball.a.a.a)FloatMenuView.4.1.this.ago).position);
                  }
                  AppMethodBeat.o(186230);
                }
              }, l);
              AppMethodBeat.o(187443);
            }
            
            public final void onAnimationRepeat(Animator paramAnonymous2Animator)
            {
              AppMethodBeat.i(187445);
              if (paramAnonymousAnimatorListener != null) {
                paramAnonymousAnimatorListener.onAnimationRepeat(paramAnonymous2Animator);
              }
              AppMethodBeat.o(187445);
            }
            
            public final void onAnimationStart(Animator paramAnonymous2Animator)
            {
              AppMethodBeat.i(187437);
              if (paramAnonymousAnimatorListener != null) {
                paramAnonymousAnimatorListener.onAnimationStart(paramAnonymous2Animator);
              }
              AppMethodBeat.o(187437);
            }
          }).start();
          AppMethodBeat.o(187491);
          return true;
        }
      };
      d locald = new d();
      locald.alg = 200L;
      locald.alh = 200L;
      locald.alj = 200L;
      locald.ali = 200L;
      locald.ali = 160L;
      locald.rXs = paramAttributeSet;
      this.ses.rXs = paramAttributeSet;
      this.ser.setItemAnimator(locald);
    }
  }
  
  private void O(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106513);
    Iterator localIterator = this.sev.iterator();
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
  
  private static String co(List<BallInfo> paramList)
  {
    AppMethodBeat.i(106494);
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramList.size())
    {
      BallInfo localBallInfo = (BallInfo)paramList.get(i);
      localStringBuilder.append(localBallInfo.key).append(localBallInfo.type).append(localBallInfo.icon).append(localBallInfo.qpN).append(localBallInfo.name).append(localBallInfo.tag).append(localBallInfo.state).append(localBallInfo.rYr).append(localBallInfo.qmt).append(localBallInfo.progress).append("|");
      i += 1;
    }
    paramList = MD5Util.getMD5String(localStringBuilder.toString());
    AppMethodBeat.o(106494);
    return paramList;
  }
  
  private void cwV()
  {
    AppMethodBeat.i(106502);
    if (this.rXn) {
      this.ser.setLayoutAnimation(this.sey);
    }
    for (;;)
    {
      this.ser.startLayoutAnimation();
      if (!com.tencent.mm.plugin.ball.f.d.checkListNotEmpty(this.seu)) {
        break;
      }
      Iterator localIterator = this.seu.iterator();
      while (localIterator.hasNext()) {
        O((BallInfo)localIterator.next());
      }
      this.ser.setLayoutAnimation(this.seA);
    }
    AppMethodBeat.o(106502);
  }
  
  private void cwW()
  {
    AppMethodBeat.i(106503);
    if (this.rXn) {
      this.ser.setLayoutAnimation(this.sez);
    }
    for (;;)
    {
      this.ser.startLayoutAnimation();
      AppMethodBeat.o(106503);
      return;
      this.ser.setLayoutAnimation(this.seB);
    }
  }
  
  private int cwY()
  {
    AppMethodBeat.i(106506);
    if (com.tencent.mm.plugin.ball.f.d.checkListNotEmpty(this.seu))
    {
      int i = this.seu.size();
      int j = this.seC;
      AppMethodBeat.o(106506);
      return i * j;
    }
    AppMethodBeat.o(106506);
    return 0;
  }
  
  private void cwZ()
  {
    AppMethodBeat.i(106507);
    if (this.ser == null)
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
    this.seH = false;
    int j;
    e.a locala;
    RelativeLayout.LayoutParams localLayoutParams;
    int k;
    boolean bool;
    if (this.seD == 0)
    {
      i = com.tencent.mm.plugin.ball.f.e.saL;
      j = cwY();
      locala = com.tencent.mm.plugin.ball.f.d.U(this.seo, this.sep, i);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      k = com.tencent.mm.ci.a.ks(MMApplicationContext.getContext()) - com.tencent.mm.plugin.ball.f.e.saK;
      if (this.sep + i + j <= k) {
        break label457;
      }
      if (this.sep - j < com.tencent.mm.plugin.ball.f.e.saW) {
        break label348;
      }
      i = this.sep - j;
      if (i >= com.tencent.mm.plugin.ball.f.e.saK) {
        break label322;
      }
      bool = true;
      label143:
      this.seH = bool;
      if (i >= com.tencent.mm.plugin.ball.f.e.saK) {
        break label328;
      }
      i = com.tencent.mm.plugin.ball.f.e.saK;
      label160:
      if ((locala != e.a.saY) && (locala != e.a.sba)) {
        break label331;
      }
      b(localLayoutParams, i);
      this.sey.setOrder(1);
    }
    for (;;)
    {
      this.set.ap(true);
      this.ser.setLayoutManager(this.set);
      Log.i("MicroMsg.FloatMenuView", "updateMenuContentView, anchorView:[%s, %s], margins:[%s, %s, %s, %s], enableScroll:%b", new Object[] { Integer.valueOf(this.seo), Integer.valueOf(this.sep), Integer.valueOf(localLayoutParams.leftMargin), Integer.valueOf(localLayoutParams.topMargin), Integer.valueOf(localLayoutParams.rightMargin), Integer.valueOf(localLayoutParams.bottomMargin), Boolean.valueOf(this.seH) });
      this.ser.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(106507);
      return;
      i = this.seD;
      break;
      label322:
      bool = false;
      break label143;
      label328:
      break label160;
      label331:
      a(localLayoutParams, i);
      this.seA.setOrder(1);
    }
    label348:
    int i = k - j;
    if (i < com.tencent.mm.plugin.ball.f.e.saK)
    {
      bool = true;
      label362:
      this.seH = bool;
      if (i >= com.tencent.mm.plugin.ball.f.e.saK) {
        break label437;
      }
      i = com.tencent.mm.plugin.ball.f.e.saK;
      label379:
      if ((locala != e.a.saY) && (locala != e.a.sba)) {
        break label440;
      }
      b(localLayoutParams, i);
      this.sey.setOrder(0);
    }
    for (;;)
    {
      this.set.ap(false);
      this.ser.setLayoutManager(this.set);
      break;
      bool = false;
      break label362;
      label437:
      break label379;
      label440:
      a(localLayoutParams, i);
      this.seA.setOrder(0);
    }
    label457:
    i += this.sep;
    if ((locala == e.a.saY) || (locala == e.a.sba))
    {
      b(localLayoutParams, i);
      this.sey.setOrder(0);
    }
    for (;;)
    {
      this.set.ap(false);
      this.ser.setLayoutManager(this.set);
      break;
      a(localLayoutParams, i);
      this.seA.setOrder(0);
    }
  }
  
  private void cxa()
  {
    AppMethodBeat.i(106510);
    if (this.rqC != null) {
      this.rqC.vibrate(10L);
    }
    AppMethodBeat.o(106510);
  }
  
  private void d(int paramInt, View paramView)
  {
    AppMethodBeat.i(106497);
    if (paramInt == -1) {
      dM(this.seE);
    }
    for (;;)
    {
      this.seF = paramInt;
      this.seE = paramView;
      AppMethodBeat.o(106497);
      return;
      if (paramInt != this.seF)
      {
        dM(this.seE);
        dL(paramView);
      }
    }
  }
  
  private void dL(View paramView)
  {
    AppMethodBeat.i(106498);
    if (paramView != null)
    {
      paramView.clearAnimation();
      if (((paramView.getTag() instanceof BallInfo)) && (!((BallInfo)paramView.getTag()).rYr))
      {
        paramView.animate().scaleX(1.1F).scaleY(1.1F).setDuration(100L).start();
        cxa();
      }
    }
    AppMethodBeat.o(106498);
  }
  
  public static void dM(View paramView)
  {
    AppMethodBeat.i(106499);
    if (paramView != null)
    {
      paramView.clearAnimation();
      paramView.animate().scaleX(1.0F).scaleY(1.0F).setDuration(100L).start();
    }
    AppMethodBeat.o(106499);
  }
  
  private void fy(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(106505);
    this.seo = paramInt1;
    this.sep = paramInt2;
    cwZ();
    AppMethodBeat.o(106505);
  }
  
  public final void N(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106512);
    Iterator localIterator = this.sev.iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).v(paramBallInfo);
    }
    AppMethodBeat.o(106512);
  }
  
  public final void W(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(106496);
    float f1 = paramMotionEvent.getRawX();
    float f2 = paramMotionEvent.getRawY();
    float f3 = this.ser.getLeft();
    float f4 = this.ser.getTop();
    paramMotionEvent = this.ser.h(f1 - f3, f2 - f4);
    if (paramMotionEvent != null)
    {
      d(RecyclerView.bh(paramMotionEvent), paramMotionEvent);
      AppMethodBeat.o(106496);
      return;
    }
    d(-1, null);
    AppMethodBeat.o(106496);
  }
  
  public final void a(List<BallInfo> paramList, BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106493);
    List localList = com.tencent.mm.plugin.ball.f.d.cf(com.tencent.mm.plugin.ball.f.d.ce(paramList));
    String str = co(localList);
    if (Util.isEqual(str, this.sdy))
    {
      Log.i("MicroMsg.FloatMenuView", "FloatMenuView ignore refresh");
      AppMethodBeat.o(106493);
      return;
    }
    this.sdy = str;
    this.seu = localList;
    if (com.tencent.mm.plugin.ball.f.d.checkListNotEmpty(this.seu)) {}
    for (int i = this.seu.size();; i = 0)
    {
      Log.i("MicroMsg.FloatMenuView", "menuBallInfoList, size:%s", new Object[] { Integer.valueOf(i) });
      this.ses.rXp = this.seu;
      this.ses.alc.notifyChanged();
      if (com.tencent.mm.plugin.ball.f.d.checkListNotEmpty(com.tencent.mm.plugin.ball.f.d.d(paramList, paramBallInfo))) {
        break;
      }
      e(null);
      AppMethodBeat.o(106493);
      return;
    }
    fy(this.seo, this.sep);
    AppMethodBeat.o(106493);
  }
  
  public final void c(ResultReceiver paramResultReceiver)
  {
    AppMethodBeat.i(187666);
    if (getVisibility() == 0)
    {
      Log.i("MicroMsg.FloatMenuView", "float menu already show");
      AppMethodBeat.o(187666);
      return;
    }
    this.seI = paramResultReceiver;
    setVisibility(0);
    paramResultReceiver = ObjectAnimator.ofFloat(this, "alpha", new float[] { 0.0F, 1.0F });
    paramResultReceiver.setDuration(200L);
    paramResultReceiver.addListener(new com.tencent.mm.plugin.ball.b.e(this, null));
    paramResultReceiver.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(188079);
        FloatMenuView.a(FloatMenuView.this, true);
        AppMethodBeat.o(188079);
      }
    });
    paramResultReceiver.start();
    cwV();
    AppMethodBeat.o(187666);
  }
  
  public final void cwU()
  {
    AppMethodBeat.i(106500);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(null);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/ball/view/FloatMenuView", "com/tencent/mm/plugin/ball/view/FloatMenuView", "show", "(Landroid/animation/AnimatorListenerAdapter;)V", this, localb.aFi());
    c(null);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ball/view/FloatMenuView", "com/tencent/mm/plugin/ball/view/FloatMenuView", "show", "(Landroid/animation/AnimatorListenerAdapter;)V");
    AppMethodBeat.o(106500);
  }
  
  public final void cwX()
  {
    AppMethodBeat.i(187669);
    if (getVisibility() == 8)
    {
      Log.i("MicroMsg.FloatMenuView", "float menu already hide");
      AppMethodBeat.o(187669);
      return;
    }
    setVisibility(8);
    AppMethodBeat.o(187669);
  }
  
  public final void cxb()
  {
    AppMethodBeat.i(106511);
    Iterator localIterator = this.sev.iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).cvp();
    }
    AppMethodBeat.o(106511);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(106491);
    if (((paramKeyEvent.getKeyCode() == 4) || (paramKeyEvent.getKeyCode() == 3) || (paramKeyEvent.getKeyCode() == 82)) && (paramKeyEvent.getAction() == 0))
    {
      cxb();
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
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnimatorListenerAdapter);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/ball/view/FloatMenuView", "com/tencent/mm/plugin/ball/view/FloatMenuView", "hide", "(Landroid/animation/AnimatorListenerAdapter;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
    if (getVisibility() == 8)
    {
      Log.i("MicroMsg.FloatMenuView", "float menu already hide");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ball/view/FloatMenuView", "com/tencent/mm/plugin/ball/view/FloatMenuView", "hide", "(Landroid/animation/AnimatorListenerAdapter;)V");
      AppMethodBeat.o(106501);
      return;
    }
    cwW();
    localObject = ObjectAnimator.ofFloat(this, "alpha", new float[] { 1.0F, 0.0F });
    ((Animator)localObject).setDuration(200L);
    ((Animator)localObject).addListener(new com.tencent.mm.plugin.ball.b.d(this, paramAnimatorListenerAdapter));
    ((Animator)localObject).addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(186756);
        FloatMenuView.a(FloatMenuView.this, false);
        FloatMenuView.f(FloatMenuView.this);
        AppMethodBeat.o(186756);
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
    paramConfiguration = this.sev.iterator();
    while (paramConfiguration.hasNext()) {
      ((c)paramConfiguration.next()).onOrientationChange(i);
    }
    AppMethodBeat.o(106492);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(184625);
    super.onMeasure(paramInt1, paramInt2);
    if (this.sew != null) {
      this.sew.cvq();
    }
    AppMethodBeat.o(184625);
  }
  
  public void setCanAddFloatBallWhenHide(boolean paramBoolean)
  {
    this.seJ = paramBoolean;
  }
  
  public void setForceShowFloatMenu(boolean paramBoolean)
  {
    this.seG = paramBoolean;
  }
  
  public void setInLongPressMode(boolean paramBoolean)
  {
    AppMethodBeat.i(106495);
    this.rXo = paramBoolean;
    this.ses.rXo = paramBoolean;
    this.ses.alc.notifyChanged();
    AppMethodBeat.o(106495);
  }
  
  public void setOnMeasuredListener(com.tencent.mm.plugin.ball.d.d paramd)
  {
    this.sew = paramd;
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(106504);
    super.setVisibility(paramInt);
    if (paramInt == 8)
    {
      Log.i("MicroMsg.FloatMenuView", "setVisibility, updateMenuContentView when GONE");
      fy(this.seo, this.sep);
      setForceShowFloatMenu(false);
    }
    AppMethodBeat.o(106504);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.view.FloatMenuView
 * JD-Core Version:    0.7.0.1
 */