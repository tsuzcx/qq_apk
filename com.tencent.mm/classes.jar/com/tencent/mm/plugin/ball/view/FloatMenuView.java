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
import android.view.View.OnClickListener;
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
  public boolean mCA;
  public boolean mCB;
  private Vibrator mHT;
  private String mIC;
  private volatile boolean mJA;
  private ResultReceiver mJB;
  private boolean mJC;
  public int mJj;
  public int mJk;
  private RecyclerView mJl;
  private com.tencent.mm.plugin.ball.a.a mJm;
  private LinearLayoutManager mJn;
  private List<BallInfo> mJo;
  public Set<com.tencent.mm.plugin.ball.d.d> mJp;
  private com.tencent.mm.plugin.ball.d.e mJq;
  private LayoutAnimationController mJr;
  private LayoutAnimationController mJs;
  private LayoutAnimationController mJt;
  private LayoutAnimationController mJu;
  private int mJv;
  public int mJw;
  public View mJx;
  public int mJy;
  public boolean mJz;
  
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
    this.mJp = new CopyOnWriteArraySet();
    this.mJq = null;
    this.mJy = -1;
    this.mJz = false;
    this.mJA = false;
    this.mJB = null;
    this.mJC = false;
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
    this.mHT = ((Vibrator)paramContext.getSystemService("vibrator"));
    this.mJl = ((RecyclerView)findViewById(2131302236));
    this.mJl.setOverScrollMode(2);
    setClipChildren(false);
    this.mJl.setClipChildren(false);
    this.mJm = new com.tencent.mm.plugin.ball.a.a(paramContext);
    this.mJm.mCD = new c()
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
    this.mJl.setAdapter(this.mJm);
    this.mJn = new LinearLayoutManager()
    {
      public final boolean jE()
      {
        return false;
      }
      
      public final boolean jF()
      {
        AppMethodBeat.i(106488);
        boolean bool = FloatMenuView.b(FloatMenuView.this);
        AppMethodBeat.o(106488);
        return bool;
      }
    };
    this.mJn.setOrientation(1);
    this.mJl.setLayoutManager(this.mJn);
    this.mJv = (com.tencent.mm.cd.a.ap(paramContext, 2131166364) + com.tencent.mm.cd.a.ap(paramContext, 2131166380) + com.tencent.mm.cd.a.ap(paramContext, 2131166378));
    this.mJr = AnimationUtils.loadLayoutAnimation(paramContext, 2130772057);
    this.mJt = AnimationUtils.loadLayoutAnimation(paramContext, 2130772058);
    this.mJs = AnimationUtils.loadLayoutAnimation(paramContext, 2130772055);
    this.mJu = AnimationUtils.loadLayoutAnimation(paramContext, 2130772056);
    AppMethodBeat.o(106490);
  }
  
  private void H(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106513);
    Iterator localIterator = this.mJp.iterator();
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
  
  private void bAJ()
  {
    AppMethodBeat.i(106502);
    if (this.mCA) {
      this.mJl.setLayoutAnimation(this.mJr);
    }
    for (;;)
    {
      this.mJl.startLayoutAnimation();
      if (!com.tencent.mm.plugin.ball.f.d.h(this.mJo)) {
        break;
      }
      Iterator localIterator = this.mJo.iterator();
      while (localIterator.hasNext()) {
        H((BallInfo)localIterator.next());
      }
      this.mJl.setLayoutAnimation(this.mJt);
    }
    AppMethodBeat.o(106502);
  }
  
  private void bAK()
  {
    AppMethodBeat.i(106503);
    if (this.mCA) {
      this.mJl.setLayoutAnimation(this.mJs);
    }
    for (;;)
    {
      this.mJl.startLayoutAnimation();
      AppMethodBeat.o(106503);
      return;
      this.mJl.setLayoutAnimation(this.mJu);
    }
  }
  
  private int bAM()
  {
    AppMethodBeat.i(106506);
    if (com.tencent.mm.plugin.ball.f.d.h(this.mJo))
    {
      int i = this.mJo.size();
      int j = this.mJv;
      AppMethodBeat.o(106506);
      return i * j;
    }
    AppMethodBeat.o(106506);
    return 0;
  }
  
  private void bAN()
  {
    AppMethodBeat.i(106507);
    if (this.mJl == null)
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
    this.mJA = false;
    int j;
    e.a locala;
    RelativeLayout.LayoutParams localLayoutParams;
    int k;
    boolean bool;
    if (this.mJw == 0)
    {
      i = com.tencent.mm.plugin.ball.f.e.mFL;
      j = bAM();
      locala = com.tencent.mm.plugin.ball.f.d.P(this.mJj, this.mJk, i);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      k = com.tencent.mm.cd.a.hW(aj.getContext()) - com.tencent.mm.plugin.ball.f.e.mFK;
      if (this.mJk + i + j <= k) {
        break label457;
      }
      if (this.mJk - j < com.tencent.mm.plugin.ball.f.e.mFW) {
        break label348;
      }
      i = this.mJk - j;
      if (i >= com.tencent.mm.plugin.ball.f.e.mFK) {
        break label322;
      }
      bool = true;
      label143:
      this.mJA = bool;
      if (i >= com.tencent.mm.plugin.ball.f.e.mFK) {
        break label328;
      }
      i = com.tencent.mm.plugin.ball.f.e.mFK;
      label160:
      if ((locala != e.a.mFZ) && (locala != e.a.mGb)) {
        break label331;
      }
      b(localLayoutParams, i);
      this.mJr.setOrder(1);
    }
    for (;;)
    {
      this.mJn.ao(true);
      this.mJl.setLayoutManager(this.mJn);
      ad.i("MicroMsg.FloatMenuView", "updateMenuContentView, anchorView:[%s, %s], margins:[%s, %s, %s, %s], enableScroll:%b", new Object[] { Integer.valueOf(this.mJj), Integer.valueOf(this.mJk), Integer.valueOf(localLayoutParams.leftMargin), Integer.valueOf(localLayoutParams.topMargin), Integer.valueOf(localLayoutParams.rightMargin), Integer.valueOf(localLayoutParams.bottomMargin), Boolean.valueOf(this.mJA) });
      this.mJl.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(106507);
      return;
      i = this.mJw;
      break;
      label322:
      bool = false;
      break label143;
      label328:
      break label160;
      label331:
      a(localLayoutParams, i);
      this.mJt.setOrder(1);
    }
    label348:
    int i = k - j;
    if (i < com.tencent.mm.plugin.ball.f.e.mFK)
    {
      bool = true;
      label362:
      this.mJA = bool;
      if (i >= com.tencent.mm.plugin.ball.f.e.mFK) {
        break label437;
      }
      i = com.tencent.mm.plugin.ball.f.e.mFK;
      label379:
      if ((locala != e.a.mFZ) && (locala != e.a.mGb)) {
        break label440;
      }
      b(localLayoutParams, i);
      this.mJr.setOrder(0);
    }
    for (;;)
    {
      this.mJn.ao(false);
      this.mJl.setLayoutManager(this.mJn);
      break;
      bool = false;
      break label362;
      label437:
      break label379;
      label440:
      a(localLayoutParams, i);
      this.mJt.setOrder(0);
    }
    label457:
    i += this.mJk;
    if ((locala == e.a.mFZ) || (locala == e.a.mGb))
    {
      b(localLayoutParams, i);
      this.mJr.setOrder(0);
    }
    for (;;)
    {
      this.mJn.ao(false);
      this.mJl.setLayoutManager(this.mJn);
      break;
      a(localLayoutParams, i);
      this.mJt.setOrder(0);
    }
  }
  
  private void bAO()
  {
    AppMethodBeat.i(106510);
    if (this.mHT != null) {
      this.mHT.vibrate(10L);
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
      localStringBuilder.append(localBallInfo.key).append(localBallInfo.type).append(localBallInfo.dub).append(localBallInfo.kYl).append(localBallInfo.name).append(localBallInfo.tag).append(localBallInfo.state).append(localBallInfo.mDu).append(localBallInfo.mDv).append(localBallInfo.progress).append("|");
      i += 1;
    }
    paramList = ai.du(localStringBuilder.toString());
    AppMethodBeat.o(106494);
    return paramList;
  }
  
  private void d(int paramInt, View paramView)
  {
    AppMethodBeat.i(106497);
    if (paramInt == -1) {
      du(this.mJx);
    }
    for (;;)
    {
      this.mJy = paramInt;
      this.mJx = paramView;
      AppMethodBeat.o(106497);
      return;
      if (paramInt != this.mJy)
      {
        du(this.mJx);
        dt(paramView);
      }
    }
  }
  
  private void dt(View paramView)
  {
    AppMethodBeat.i(106498);
    if (paramView != null)
    {
      paramView.clearAnimation();
      if (((paramView.getTag() instanceof BallInfo)) && (!((BallInfo)paramView.getTag()).mDu))
      {
        paramView.animate().scaleX(1.1F).scaleY(1.1F).setDuration(100L).start();
        bAO();
      }
    }
    AppMethodBeat.o(106498);
  }
  
  public static void du(View paramView)
  {
    AppMethodBeat.i(106499);
    if (paramView != null)
    {
      paramView.clearAnimation();
      paramView.animate().scaleX(1.0F).scaleY(1.0F).setDuration(100L).start();
    }
    AppMethodBeat.o(106499);
  }
  
  private void eE(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(106505);
    this.mJj = paramInt1;
    this.mJk = paramInt2;
    bAN();
    AppMethodBeat.o(106505);
  }
  
  public final void G(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106512);
    Iterator localIterator = this.mJp.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.plugin.ball.d.d)localIterator.next()).t(paramBallInfo);
    }
    AppMethodBeat.o(106512);
  }
  
  public final void R(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(106496);
    float f1 = paramMotionEvent.getRawX();
    float f2 = paramMotionEvent.getRawY();
    float f3 = this.mJl.getLeft();
    float f4 = this.mJl.getTop();
    paramMotionEvent = this.mJl.o(f1 - f3, f2 - f4);
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
    if (bt.kU(str, this.mIC))
    {
      ad.i("MicroMsg.FloatMenuView", "FloatMenuView ignore refresh");
      AppMethodBeat.o(106493);
      return;
    }
    this.mIC = str;
    this.mJo = localList;
    if (com.tencent.mm.plugin.ball.f.d.h(this.mJo)) {}
    for (int i = this.mJo.size();; i = 0)
    {
      ad.i("MicroMsg.FloatMenuView", "menuBallInfoList, size:%s", new Object[] { Integer.valueOf(i) });
      this.mJm.mCC = this.mJo;
      this.mJm.aql.notifyChanged();
      if (com.tencent.mm.plugin.ball.f.d.h(com.tencent.mm.plugin.ball.f.d.d(paramList, paramBallInfo))) {
        break;
      }
      d(null);
      AppMethodBeat.o(106493);
      return;
    }
    eE(this.mJj, this.mJk);
    AppMethodBeat.o(106493);
  }
  
  public final void bAI()
  {
    AppMethodBeat.i(106500);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.be(null);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ball/view/FloatMenuView", "com/tencent/mm/plugin/ball/view/FloatMenuView", "show", "(Landroid/animation/AnimatorListenerAdapter;)V", this, localb.ado());
    c(null);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ball/view/FloatMenuView", "com/tencent/mm/plugin/ball/view/FloatMenuView", "show", "(Landroid/animation/AnimatorListenerAdapter;)V");
    AppMethodBeat.o(106500);
  }
  
  public final void bAL()
  {
    AppMethodBeat.i(190683);
    if (getVisibility() == 8)
    {
      ad.i("MicroMsg.FloatMenuView", "float menu already hide");
      AppMethodBeat.o(190683);
      return;
    }
    setVisibility(8);
    AppMethodBeat.o(190683);
  }
  
  public final void bAP()
  {
    AppMethodBeat.i(106511);
    Iterator localIterator = this.mJp.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.plugin.ball.d.d)localIterator.next()).bzf();
    }
    AppMethodBeat.o(106511);
  }
  
  public final void c(ResultReceiver paramResultReceiver)
  {
    AppMethodBeat.i(190682);
    if (getVisibility() == 0)
    {
      ad.i("MicroMsg.FloatMenuView", "float menu already show");
      AppMethodBeat.o(190682);
      return;
    }
    this.mJB = paramResultReceiver;
    setVisibility(0);
    paramResultReceiver = ObjectAnimator.ofFloat(this, "alpha", new float[] { 0.0F, 1.0F });
    paramResultReceiver.setDuration(200L);
    paramResultReceiver.addListener(new com.tencent.mm.plugin.ball.b.e(this));
    paramResultReceiver.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(190680);
        FloatMenuView.a(FloatMenuView.this, true);
        AppMethodBeat.o(190680);
      }
    });
    paramResultReceiver.start();
    bAJ();
    AppMethodBeat.o(190682);
  }
  
  public final void d(AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(106501);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).be(paramAnimatorListenerAdapter);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ball/view/FloatMenuView", "com/tencent/mm/plugin/ball/view/FloatMenuView", "hide", "(Landroid/animation/AnimatorListenerAdapter;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ado());
    if (getVisibility() == 8)
    {
      ad.i("MicroMsg.FloatMenuView", "float menu already hide");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ball/view/FloatMenuView", "com/tencent/mm/plugin/ball/view/FloatMenuView", "hide", "(Landroid/animation/AnimatorListenerAdapter;)V");
      AppMethodBeat.o(106501);
      return;
    }
    bAK();
    localObject = ObjectAnimator.ofFloat(this, "alpha", new float[] { 1.0F, 0.0F });
    ((Animator)localObject).setDuration(200L);
    ((Animator)localObject).addListener(new com.tencent.mm.plugin.ball.b.d(this, paramAnimatorListenerAdapter));
    ((Animator)localObject).addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(190681);
        FloatMenuView.a(FloatMenuView.this, false);
        FloatMenuView.d(FloatMenuView.this);
        AppMethodBeat.o(190681);
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
      bAP();
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
    paramConfiguration = this.mJp.iterator();
    while (paramConfiguration.hasNext()) {
      ((com.tencent.mm.plugin.ball.d.d)paramConfiguration.next()).wy(i);
    }
    AppMethodBeat.o(106492);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(184625);
    super.onMeasure(paramInt1, paramInt2);
    if (this.mJq != null) {
      this.mJq.bzg();
    }
    AppMethodBeat.o(184625);
  }
  
  public void setCanAddFloatBallWhenHide(boolean paramBoolean)
  {
    this.mJC = paramBoolean;
  }
  
  public void setForceShowFloatMenu(boolean paramBoolean)
  {
    this.mJz = paramBoolean;
  }
  
  public void setInLongPressMode(boolean paramBoolean)
  {
    AppMethodBeat.i(106495);
    this.mCB = paramBoolean;
    this.mJm.mCB = paramBoolean;
    this.mJm.aql.notifyChanged();
    AppMethodBeat.o(106495);
  }
  
  public void setOnMeasuredListener(com.tencent.mm.plugin.ball.d.e parame)
  {
    this.mJq = parame;
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(106504);
    super.setVisibility(paramInt);
    if (paramInt == 8)
    {
      ad.i("MicroMsg.FloatMenuView", "setVisibility, updateMenuContentView when GONE");
      eE(this.mJj, this.mJk);
      setForceShowFloatMenu(false);
    }
    AppMethodBeat.o(106504);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.view.FloatMenuView
 * JD-Core Version:    0.7.0.1
 */