package com.tencent.mm.plugin.ball.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.LayoutTransition;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.ball.c.c;
import com.tencent.mm.plugin.ball.f.d;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.t;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArraySet;

public class FloatBallView
  extends FrameLayout
  implements com.tencent.mm.plugin.ball.c.e
{
  private static final int mHA;
  private static final int mHB;
  private static final int mHC;
  private static final int mHD;
  private static final int mHE;
  private static final int mHF;
  private static final int mHG;
  private static final int mHH;
  private static final int mHI;
  private static final int mHJ;
  private static final int mHK;
  private static final int mHL;
  private static final int mHM;
  private static final int mHN;
  private static final int mHO;
  private static final int mHP;
  private static final int mHQ;
  private static final int mHe;
  private static final int mHf;
  private static final int mHg;
  private static final int mHh;
  private static final int mHi;
  private static final int mHj;
  private static final int mHk;
  private static final int mHl;
  private static final int mHm;
  private static final int mHn;
  private static final int mHo;
  private static final int mHp;
  private static final int mHq;
  private static final int mHr;
  private static final int mHs;
  private static final int mHt;
  private static final int mHu;
  private static final int mHv;
  private static final int mHw;
  private static final int mHx;
  private static final int mHy;
  private static final int mHz;
  public Set<com.tencent.mm.plugin.ball.d.b> csT;
  private int iHo;
  private View jpE;
  private long lVv;
  private boolean mCB;
  public boolean mFj;
  private int mHR;
  private int mHS;
  private Vibrator mHT;
  private ValueAnimator mHU;
  public com.tencent.mm.plugin.ball.b.b mHV;
  private View mHW;
  private View mHX;
  private LinearLayout mHY;
  public FrameLayout mHZ;
  public int mHc;
  private int mHd;
  private BallInfo mIA;
  private BallInfo mIB;
  private String mIC;
  private List<BallInfo> mIE;
  private LayoutTransition mIF;
  private boolean mIG;
  private boolean mIH;
  private Point mII;
  private PointF mIJ;
  private Point mIK;
  private float mIL;
  private int mIM;
  private boolean mIN;
  private boolean mIO;
  private boolean mIP;
  private boolean mIQ;
  private boolean mIR;
  private int mIS;
  private boolean mIT;
  private Handler mIU;
  private Runnable mIV;
  private boolean mIW;
  private boolean mIX;
  private boolean mIY;
  private int mIZ;
  private FrameLayout mIa;
  private FrameLayout mIb;
  private FrameLayout mIc;
  private CircleAnimateView mIe;
  private CircleAnimateView mIf;
  private CircleAnimateView mIg;
  private CircleAnimateView mIh;
  private Drawable mIi;
  private Drawable mIj;
  private Drawable mIk;
  private Drawable mIl;
  private Drawable mIm;
  private Drawable mIn;
  private Drawable mIo;
  private Drawable mIp;
  private Drawable mIq;
  private Drawable mIr;
  private Drawable mIs;
  private Drawable mIt;
  private Drawable mIu;
  private Drawable mIv;
  private Drawable mIw;
  private Drawable mIx;
  private Drawable mIy;
  private Drawable mIz;
  private WindowManager windowManager;
  
  static
  {
    AppMethodBeat.i(106478);
    mHe = com.tencent.mm.cd.a.ap(aj.getContext(), 2131166306);
    mHf = com.tencent.mm.cd.a.ap(aj.getContext(), 2131166303);
    mHg = com.tencent.mm.cd.a.ap(aj.getContext(), 2131166305);
    mHh = com.tencent.mm.cd.a.ap(aj.getContext(), 2131166304);
    mHi = com.tencent.mm.cd.a.ap(aj.getContext(), 2131166325);
    mHj = com.tencent.mm.cd.a.ap(aj.getContext(), 2131166324);
    mHk = com.tencent.mm.cd.a.ap(aj.getContext(), 2131166337);
    mHl = com.tencent.mm.cd.a.ap(aj.getContext(), 2131166336);
    mHm = com.tencent.mm.cd.a.ap(aj.getContext(), 2131166333);
    mHn = com.tencent.mm.cd.a.ap(aj.getContext(), 2131166332);
    mHo = com.tencent.mm.cd.a.ap(aj.getContext(), 2131166345);
    mHp = com.tencent.mm.cd.a.ap(aj.getContext(), 2131166344);
    mHq = com.tencent.mm.cd.a.ap(aj.getContext(), 2131166348);
    mHr = com.tencent.mm.cd.a.ap(aj.getContext(), 2131166346);
    mHs = com.tencent.mm.cd.a.ap(aj.getContext(), 2131166349);
    mHt = com.tencent.mm.cd.a.ap(aj.getContext(), 2131166347);
    mHu = com.tencent.mm.cd.a.ap(aj.getContext(), 2131166339);
    mHv = com.tencent.mm.cd.a.ap(aj.getContext(), 2131166338);
    mHw = com.tencent.mm.cd.a.ap(aj.getContext(), 2131166342);
    mHx = com.tencent.mm.cd.a.ap(aj.getContext(), 2131166340);
    mHy = com.tencent.mm.cd.a.ap(aj.getContext(), 2131166343);
    mHz = com.tencent.mm.cd.a.ap(aj.getContext(), 2131166341);
    mHA = com.tencent.mm.cd.a.ap(aj.getContext(), 2131166356);
    mHB = com.tencent.mm.cd.a.ap(aj.getContext(), 2131166354);
    mHC = com.tencent.mm.cd.a.ap(aj.getContext(), 2131166357);
    mHD = com.tencent.mm.cd.a.ap(aj.getContext(), 2131166355);
    mHE = com.tencent.mm.cd.a.ap(aj.getContext(), 2131166352);
    mHF = com.tencent.mm.cd.a.ap(aj.getContext(), 2131166350);
    mHG = com.tencent.mm.cd.a.ap(aj.getContext(), 2131166353);
    mHH = com.tencent.mm.cd.a.ap(aj.getContext(), 2131166351);
    mHI = com.tencent.mm.cd.a.ap(aj.getContext(), 2131166331);
    mHJ = com.tencent.mm.cd.a.ap(aj.getContext(), 2131166307);
    mHK = com.tencent.mm.cd.a.ap(aj.getContext(), 2131166320);
    mHL = com.tencent.mm.cd.a.ap(aj.getContext(), 2131166321);
    mHM = com.tencent.mm.cd.a.ap(aj.getContext(), 2131166318);
    mHN = com.tencent.mm.cd.a.ap(aj.getContext(), 2131166319);
    mHO = com.tencent.mm.cd.a.ap(aj.getContext(), 2131166309);
    mHP = com.tencent.mm.cd.a.ap(aj.getContext(), 2131166311);
    mHQ = com.tencent.mm.cd.a.ap(aj.getContext(), 2131166310);
    AppMethodBeat.o(106478);
  }
  
  public FloatBallView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FloatBallView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FloatBallView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(106438);
    this.mHc = 0;
    this.mHd = 0;
    this.csT = new CopyOnWriteArraySet();
    this.mIJ = new PointF();
    this.mIK = new Point();
    this.mIL = -1.0F;
    this.mIM = 0;
    this.mIN = false;
    this.mFj = false;
    this.mIO = true;
    this.mIP = false;
    this.mIQ = false;
    this.mIR = false;
    this.mIS = 0;
    this.mIT = false;
    this.mCB = false;
    this.mIU = new Handler(Looper.getMainLooper());
    this.mIV = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106430);
        FloatBallView.a(FloatBallView.this);
        FloatBallView.b(FloatBallView.this);
        Iterator localIterator = FloatBallView.this.csT.iterator();
        while (localIterator.hasNext()) {
          ((com.tencent.mm.plugin.ball.d.b)localIterator.next()).bzb();
        }
        AppMethodBeat.o(106430);
      }
    };
    this.mIW = false;
    this.mIX = false;
    this.mIY = false;
    this.mIZ = 0;
    View.inflate(paramContext, 2131494557, this);
    this.mIi = com.tencent.mm.cd.a.l(paramContext, 2131232399);
    this.mIj = com.tencent.mm.cd.a.l(paramContext, 2131232401);
    this.mIk = com.tencent.mm.cd.a.l(paramContext, 2131232403);
    this.mIl = com.tencent.mm.cd.a.l(paramContext, 2131232400);
    this.mIm = com.tencent.mm.cd.a.l(paramContext, 2131232402);
    this.mIn = com.tencent.mm.cd.a.l(paramContext, 2131232404);
    this.mIo = com.tencent.mm.cd.a.l(paramContext, 2131232393);
    this.mIp = com.tencent.mm.cd.a.l(paramContext, 2131232395);
    this.mIq = com.tencent.mm.cd.a.l(paramContext, 2131232397);
    this.mIr = com.tencent.mm.cd.a.l(paramContext, 2131232394);
    this.mIs = com.tencent.mm.cd.a.l(paramContext, 2131232396);
    this.mIt = com.tencent.mm.cd.a.l(paramContext, 2131232398);
    this.mIu = com.tencent.mm.cd.a.l(paramContext, 2131232415);
    this.mIv = com.tencent.mm.cd.a.l(paramContext, 2131232416);
    this.mIw = com.tencent.mm.cd.a.l(paramContext, 2131232417);
    this.mIx = com.tencent.mm.cd.a.l(paramContext, 2131232415);
    this.mIy = com.tencent.mm.cd.a.l(paramContext, 2131232416);
    this.mIz = com.tencent.mm.cd.a.l(paramContext, 2131232417);
    this.mHY = ((LinearLayout)findViewById(2131297110));
    this.mIb = ((FrameLayout)findViewById(2131297109));
    this.mHZ = ((FrameLayout)findViewById(2131306552));
    this.mIa = ((FrameLayout)findViewById(2131303096));
    this.jpE = findViewById(2131299156);
    this.mIc = ((FrameLayout)findViewById(2131297111));
    this.mIe = ((CircleAnimateView)findViewById(2131305994));
    this.mIf = ((CircleAnimateView)findViewById(2131297430));
    this.mIg = ((CircleAnimateView)findViewById(2131305769));
    this.mIh = ((CircleAnimateView)findViewById(2131307194));
    this.mHV = new com.tencent.mm.plugin.ball.b.b(this);
    this.mHT = ((Vibrator)paramContext.getSystemService("vibrator"));
    this.windowManager = ((WindowManager)paramContext.getSystemService("window"));
    this.mHR = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.mII = com.tencent.mm.ui.ai.cf(paramContext);
    this.mHS = ViewConfiguration.getLongPressTimeout();
    this.mIF = new LayoutTransition();
    this.mHY.setLayoutTransition(this.mIF);
    this.iHo = getResources().getConfiguration().orientation;
    AppMethodBeat.o(106438);
  }
  
  private int B(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(176983);
    this.mIc.setVisibility(0);
    boolean bool1 = wY(this.mHc);
    boolean bool2 = wX(this.mHc);
    boolean bool3 = wW(this.mHc);
    boolean bool4 = wV(this.mHc);
    boolean bool5 = wP(this.mHc);
    boolean bool6 = wS(this.mHc);
    int i1;
    label100:
    int i2;
    label115:
    int i;
    label153:
    int m;
    int j;
    FrameLayout.LayoutParams localLayoutParams1;
    if (paramBoolean1)
    {
      i1 = 8388611;
      if ((wZ(this.mHc)) || (!wR(this.mHc))) {
        break label364;
      }
      k = 1;
      if ((!bool4) && (k == 0)) {
        break label370;
      }
      i2 = mHM;
      if ((paramBoolean2) || (bool5) || (bool6)) {
        break label385;
      }
      if ((!bool4) && (!bool2) && (!bool1) && (k == 0)) {
        break label378;
      }
      i = mHM;
      m = i;
      j = i;
      i = m;
      if ((!bool4) && (k == 0)) {
        break label473;
      }
      this.mIe.setVisibility(0);
      this.mIf.setVisibility(8);
      this.mIg.setVisibility(8);
      this.mIh.setVisibility(8);
      m = 0;
      k = m;
      if (!wZ(this.mHc))
      {
        k = m;
        if (wR(this.mHc)) {
          k = getAppBrandVoipBallInfoIndex();
        }
      }
      a(this.mIe, k);
      localLayoutParams1 = (FrameLayout.LayoutParams)this.mIe.getLayoutParams();
      localLayoutParams1.setMargins(j, i2, i, i2);
      localLayoutParams1.gravity = i1;
      this.mIe.setLayoutParams(localLayoutParams1);
    }
    label364:
    label370:
    label378:
    while ((!bool3) && (!bool2) && (!bool1))
    {
      localLayoutParams1 = (FrameLayout.LayoutParams)this.mIc.getLayoutParams();
      localLayoutParams1.gravity = (i1 | 0x10);
      this.mIc.setLayoutParams(localLayoutParams1);
      if ((!bool2) && (!bool1)) {
        break label959;
      }
      k = mHI;
      AppMethodBeat.o(176983);
      return k * 2 + j + i;
      i1 = 8388613;
      break;
      k = 0;
      break label100;
      i2 = mHK;
      break label115;
      i = mHN;
      break label153;
      if (paramBoolean1)
      {
        if ((bool5) && (!bool6))
        {
          j = mHK;
          if (!bool5) {
            break label424;
          }
        }
        for (i = mHK;; i = mHM)
        {
          break;
          j = mHL;
          break label404;
        }
      }
      if (bool5)
      {
        j = mHK;
        if ((!bool5) || (bool6)) {
          break label466;
        }
      }
      for (i = mHK;; i = mHL)
      {
        break;
        j = mHM;
        break label441;
      }
    }
    label385:
    label404:
    label424:
    label441:
    label466:
    label473:
    this.mIe.setVisibility(0);
    this.mIf.setVisibility(0);
    a(this.mIe, 0);
    a(this.mIf, 1);
    int n;
    int i3;
    if (bool2)
    {
      this.mIg.setVisibility(0);
      this.mIh.setVisibility(8);
      a(this.mIg, 2);
      if (paramBoolean1)
      {
        m = j + mHI;
        n = 0;
        k = i;
        i3 = j;
        label575:
        localLayoutParams1 = (FrameLayout.LayoutParams)this.mIg.getLayoutParams();
        localLayoutParams1.setMargins(i3, 0, n, 0);
        localLayoutParams1.gravity = (i1 | 0x10);
        this.mIg.setLayoutParams(localLayoutParams1);
        n = m;
        m = k;
      }
    }
    for (;;)
    {
      localLayoutParams1 = (FrameLayout.LayoutParams)this.mIe.getLayoutParams();
      localLayoutParams1.setMargins(n, i2, m, 0);
      localLayoutParams1.gravity = i1;
      this.mIe.setLayoutParams(localLayoutParams1);
      FrameLayout.LayoutParams localLayoutParams2 = (FrameLayout.LayoutParams)this.mIf.getLayoutParams();
      k = mHI;
      localLayoutParams2.setMargins(n, localLayoutParams1.topMargin + k, m, i2);
      localLayoutParams2.gravity = i1;
      this.mIf.setLayoutParams(localLayoutParams2);
      break;
      i3 = 0;
      k = mHI;
      n = i;
      k += i;
      m = j;
      break label575;
      if (bool1)
      {
        this.mIg.setVisibility(0);
        this.mIh.setVisibility(0);
        a(this.mIg, 2);
        a(this.mIh, 3);
        if (paramBoolean1)
        {
          k = mHI;
          n = 0;
          m = i;
          k += j;
        }
        for (i3 = j;; i3 = 0)
        {
          localLayoutParams1 = (FrameLayout.LayoutParams)this.mIg.getLayoutParams();
          localLayoutParams1.setMargins(i3, i2, n, 0);
          localLayoutParams1.gravity = i1;
          this.mIg.setLayoutParams(localLayoutParams1);
          localLayoutParams2 = (FrameLayout.LayoutParams)this.mIh.getLayoutParams();
          int i4 = mHI;
          localLayoutParams2.setMargins(i3, localLayoutParams1.topMargin + i4, n, 0);
          localLayoutParams2.gravity = i1;
          this.mIh.setLayoutParams(localLayoutParams2);
          n = k;
          break;
          k = mHI;
          n = i;
          m = k + i;
          k = j;
        }
      }
      this.mIh.setVisibility(8);
      this.mIg.setVisibility(8);
      m = i;
      n = j;
    }
    label959:
    int k = mHI;
    AppMethodBeat.o(176983);
    return k + j + i;
  }
  
  private void I(int paramInt, long paramLong)
  {
    AppMethodBeat.i(176984);
    if (paramInt == 0)
    {
      a(this.mIe, paramLong);
      AppMethodBeat.o(176984);
      return;
    }
    if (paramInt == 1)
    {
      a(this.mIf, paramLong);
      AppMethodBeat.o(176984);
      return;
    }
    if (paramInt == 2)
    {
      a(this.mIg, paramLong);
      AppMethodBeat.o(176984);
      return;
    }
    if (paramInt == 3) {
      a(this.mIh, paramLong);
    }
    AppMethodBeat.o(176984);
  }
  
  private boolean I(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(106453);
    if ((Math.abs(paramMotionEvent.getRawX() - this.mIJ.x) > this.mHR) || (Math.abs(paramMotionEvent.getRawY() - this.mIJ.y) > this.mHR))
    {
      AppMethodBeat.o(106453);
      return true;
    }
    AppMethodBeat.o(106453);
    return false;
  }
  
  private int J(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(106454);
    int i = (int)Math.max(Math.min(this.mIK.x + paramMotionEvent.getRawX() - this.mIJ.x, this.mII.x), 0.0F);
    AppMethodBeat.o(106454);
    return i;
  }
  
  private int K(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(106455);
    int i = (int)Math.max(Math.min(this.mIK.y + paramMotionEvent.getRawY() - this.mIJ.y, this.mII.y), 0.0F);
    AppMethodBeat.o(106455);
    return i;
  }
  
  private void Q(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.mIL = (paramInt / this.mII.y);
    }
    this.mIM = paramInt;
  }
  
  private void Q(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(106475);
    Iterator localIterator = this.csT.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.plugin.ball.d.b)localIterator.next()).P(paramMotionEvent);
    }
    AppMethodBeat.o(106475);
  }
  
  private void a(CircleAnimateView paramCircleAnimateView, int paramInt)
  {
    AppMethodBeat.i(176986);
    if ((d.h(this.mIE)) && (this.mIE.size() > paramInt))
    {
      BallInfo localBallInfo = (BallInfo)this.mIE.get(paramInt);
      paramInt = d.wG(localBallInfo.state);
      if (-1 != paramInt)
      {
        com.tencent.mm.svg.a.a locala = new com.tencent.mm.svg.a.a();
        if ((!t.av(aj.getContext(), paramInt)) && (locala.i(getResources(), paramInt))) {
          break label117;
        }
        paramCircleAnimateView.setImageResource(paramInt);
      }
      while (localBallInfo.progress >= 0L)
      {
        paramCircleAnimateView.setProgress(localBallInfo.progress);
        AppMethodBeat.o(176986);
        return;
        label117:
        paramCircleAnimateView.setImageBitmap(com.tencent.mm.svg.a.a.h(getResources(), paramInt));
      }
      paramCircleAnimateView.setProgress(-2147483648L);
    }
    AppMethodBeat.o(176986);
  }
  
  private static void a(CircleAnimateView paramCircleAnimateView, long paramLong)
  {
    AppMethodBeat.i(176985);
    if (paramLong >= 0L)
    {
      paramCircleAnimateView.setProgress(paramLong);
      AppMethodBeat.o(176985);
      return;
    }
    paramCircleAnimateView.setProgress(-2147483648L);
    AppMethodBeat.o(176985);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt)
  {
    AppMethodBeat.i(176989);
    if ((this.mIX == paramBoolean1) && (this.mIY == paramBoolean2) && (this.mIW == paramBoolean3) && (this.mIZ == paramInt))
    {
      AppMethodBeat.o(176989);
      return;
    }
    ad.i("MicroMsg.FloatBallView", "updateFloatBallBackground, isSettled:%s, isDockLeft:%s, isManual:%s, state:%s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3), Integer.valueOf(paramInt) });
    this.mIZ = paramInt;
    this.mIW = paramBoolean3;
    this.mIX = paramBoolean1;
    this.mIY = paramBoolean2;
    boolean bool1 = wS(paramInt);
    boolean bool2 = xb(paramInt);
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        if (paramBoolean3)
        {
          if (bool1)
          {
            this.mHY.setBackground(this.mIx);
            AppMethodBeat.o(176989);
            return;
          }
          if (bool2)
          {
            this.mHY.setBackground(this.mIr);
            AppMethodBeat.o(176989);
            return;
          }
          this.mHY.setBackground(this.mIl);
          AppMethodBeat.o(176989);
          return;
        }
        if (bool1)
        {
          this.mHY.setBackground(this.mIu);
          AppMethodBeat.o(176989);
          return;
        }
        if (bool2)
        {
          this.mHY.setBackground(this.mIo);
          AppMethodBeat.o(176989);
          return;
        }
        this.mHY.setBackground(this.mIi);
        AppMethodBeat.o(176989);
        return;
      }
      if (paramBoolean3)
      {
        if (bool1)
        {
          this.mHY.setBackground(this.mIy);
          AppMethodBeat.o(176989);
          return;
        }
        if (bool2)
        {
          this.mHY.setBackground(this.mIs);
          AppMethodBeat.o(176989);
          return;
        }
        this.mHY.setBackground(this.mIm);
        AppMethodBeat.o(176989);
        return;
      }
      if (bool1)
      {
        this.mHY.setBackground(this.mIv);
        AppMethodBeat.o(176989);
        return;
      }
      if (bool2)
      {
        this.mHY.setBackground(this.mIp);
        AppMethodBeat.o(176989);
        return;
      }
      this.mHY.setBackground(this.mIj);
      AppMethodBeat.o(176989);
      return;
    }
    if (paramBoolean3)
    {
      if (bool1)
      {
        this.mHY.setBackground(this.mIz);
        AppMethodBeat.o(176989);
        return;
      }
      if (bool2)
      {
        this.mHY.setBackground(this.mIt);
        AppMethodBeat.o(176989);
        return;
      }
      this.mHY.setBackground(this.mIn);
      AppMethodBeat.o(176989);
      return;
    }
    if (bool1)
    {
      this.mHY.setBackground(this.mIw);
      AppMethodBeat.o(176989);
      return;
    }
    if (bool2)
    {
      this.mHY.setBackground(this.mIq);
      AppMethodBeat.o(176989);
      return;
    }
    this.mHY.setBackground(this.mIk);
    AppMethodBeat.o(176989);
  }
  
  private void bAA()
  {
    AppMethodBeat.i(176982);
    int i = B(false, true);
    this.mIb.setVisibility(0);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.mIb.getLayoutParams();
    localLayoutParams.gravity = 8388629;
    int j = mHL;
    localLayoutParams.setMargins(j, j, i, mHL);
    this.mIb.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(176982);
  }
  
  private boolean bAB()
  {
    AppMethodBeat.i(106451);
    WindowManager.LayoutParams localLayoutParams = (WindowManager.LayoutParams)getLayoutParams();
    int i = localLayoutParams.x;
    int j = localLayoutParams.y;
    if (wM(i))
    {
      i = Math.max(Math.min(i, this.mII.x), 0);
      j = Math.max(Math.min(j, this.mII.y), 0);
      int k = wO(i);
      int m = wN(j);
      ad.i("MicroMsg.FloatBallView", "stickToScreenEdgeIfNeed, start:[%s, %s], target:[%s, %s]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m) });
      if ((i != k) || (j != m)) {
        e(k, m, true, false);
      }
      AppMethodBeat.o(106451);
      return true;
    }
    AppMethodBeat.o(106451);
    return false;
  }
  
  private void bAC()
  {
    AppMethodBeat.i(176990);
    int i = 0;
    while (i < this.mIE.size())
    {
      long l = ((BallInfo)this.mIE.get(i)).progress;
      if (l >= 0L) {
        I(i, l);
      }
      i += 1;
    }
    AppMethodBeat.o(176990);
  }
  
  private void bAD()
  {
    AppMethodBeat.i(190674);
    if (this.mFj) {
      bAE();
    }
    AppMethodBeat.o(190674);
  }
  
  private void bAE()
  {
    AppMethodBeat.i(190676);
    ad.i("MicroMsg.FloatBallView", "alvinluo showByTranslation");
    setNeedTranslateAnimation(false);
    if (getVisibility() == 0)
    {
      ad.i("MicroMsg.FloatBallView", "showByTranslation float ball already show");
      AppMethodBeat.o(190676);
      return;
    }
    if (this.mHV != null)
    {
      boolean bool = ut(((WindowManager.LayoutParams)getLayoutParams()).x);
      this.mHV.P(getCurrentStateWidth(), bool);
    }
    AppMethodBeat.o(190676);
  }
  
  private void bAG()
  {
    AppMethodBeat.i(106468);
    int j;
    int i;
    if (wZ(this.mHc)) {
      if (xj(this.mHc))
      {
        j = mHo;
        i = mHp;
      }
    }
    for (;;)
    {
      WindowManager.LayoutParams localLayoutParams = (WindowManager.LayoutParams)getLayoutParams();
      int k = com.tencent.mm.plugin.ball.f.e.mFO;
      int m = com.tencent.mm.plugin.ball.f.e.mFM;
      int n = com.tencent.mm.plugin.ball.f.e.mFN;
      if ((j != 0) && (i != 0))
      {
        localLayoutParams.width = (k + k + j + getExtendWidth());
        localLayoutParams.height = (i + (m + n));
      }
      try
      {
        for (;;)
        {
          this.windowManager.updateViewLayout(this, localLayoutParams);
          ad.i("MicroMsg.FloatBallView", "updateFloatBallViewSize, width:%s, height:%s", new Object[] { Integer.valueOf(localLayoutParams.width), Integer.valueOf(localLayoutParams.height) });
          Iterator localIterator = this.csT.iterator();
          while (localIterator.hasNext()) {
            ((com.tencent.mm.plugin.ball.d.b)localIterator.next()).a(localLayoutParams.x, localLayoutParams.y, localLayoutParams.height, this.mIQ, this.mIH);
          }
          if (xk(this.mHc))
          {
            j = mHu;
            i = mHv;
            break;
          }
          if ((wT(this.mHc)) && (wP(this.mHc)) && (wX(this.mHc)))
          {
            j = mHs;
            i = mHt;
            break;
          }
          if ((wU(this.mHc)) && (wP(this.mHc)) && (wX(this.mHc)))
          {
            j = mHy;
            i = mHz;
            break;
          }
          if ((wT(this.mHc)) && ((wP(this.mHc)) || (wQ(this.mHc))))
          {
            j = mHq;
            i = mHr;
            break;
          }
          if ((wU(this.mHc)) && ((wP(this.mHc)) || (wQ(this.mHc))))
          {
            j = mHw;
            i = mHx;
            break;
          }
          if (xa(this.mHc))
          {
            j = mHe;
            i = mHf;
            break;
          }
          if (xb(this.mHc))
          {
            j = mHO;
            i = mHO;
            break;
          }
          if (xc(this.mHc))
          {
            j = mHP;
            i = mHP;
            break;
          }
          if ((xd(this.mHc)) || (xe(this.mHc)))
          {
            j = mHQ;
            i = mHP;
            break;
          }
          if ((xf(this.mHc)) || (xg(this.mHc)))
          {
            j = mHg;
            i = mHh;
            break;
          }
          if ((!xh(this.mHc)) && (!xi(this.mHc))) {
            break label755;
          }
          j = mHg + mHI;
          i = mHh;
          break;
          if (xj(this.mHc))
          {
            j = mHo;
            i = mHp;
            break;
          }
          if (xk(this.mHc))
          {
            j = mHu;
            i = mHv;
            break;
          }
          if ((wT(this.mHc)) && (wR(this.mHc)))
          {
            j = mHq;
            i = mHr;
            break;
          }
          if ((wU(this.mHc)) && (wR(this.mHc)))
          {
            j = mHw;
            i = mHx;
            break;
          }
          if (wT(this.mHc))
          {
            j = mHo;
            i = mHp;
            break;
          }
          if (wU(this.mHc))
          {
            j = mHu;
            i = mHv;
            break;
          }
          if (!wR(this.mHc)) {
            break label755;
          }
          j = mHO;
          i = mHO;
          break;
          localLayoutParams.width = 0;
          localLayoutParams.height = 0;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.FloatBallView", localException, "updateFloatBallViewSize exception", new Object[0]);
        }
        AppMethodBeat.o(106468);
        return;
      }
      label755:
      i = 0;
      j = 0;
    }
  }
  
  private void bAH()
  {
    AppMethodBeat.i(190677);
    if (((int)getAlpha() == 1) && (getVisibility() == 0))
    {
      int i = getResources().getConfiguration().orientation;
      if (i != this.iHo)
      {
        ad.i("MicroMsg.FloatBallView", "alvinluo checkOrientationIfNeed currentOrientation: %d, lastOrientation: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(this.iHo) });
        wL(i);
      }
    }
    AppMethodBeat.o(190677);
  }
  
  private void bAv()
  {
    AppMethodBeat.i(176977);
    if (wS(this.mHc))
    {
      this.jpE.setVisibility(0);
      this.mHZ.setVisibility(0);
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.mHZ.getLayoutParams();
      int j;
      if ((wP(this.mHc)) && (wX(this.mHc)))
      {
        i = 1;
        if (!wT(this.mHc)) {
          break label253;
        }
        if (!xj(this.mHc)) {
          break label170;
        }
        if (i == 0) {
          break label156;
        }
        j = mHC;
        label93:
        localLayoutParams.width = j;
        if (i == 0) {
          break label163;
        }
      }
      label156:
      label163:
      for (int i = mHD;; i = mHB)
      {
        localLayoutParams.height = i;
        i = mHL;
        j = mHL;
        localLayoutParams.setMargins(i, i, j, j);
        this.mHZ.setLayoutParams(localLayoutParams);
        this.mIa.setVisibility(8);
        AppMethodBeat.o(176977);
        return;
        i = 0;
        break;
        j = mHA;
        break label93;
      }
      label170:
      if (i != 0)
      {
        j = mHC;
        localLayoutParams.width = j;
        if (i == 0) {
          break label246;
        }
      }
      label246:
      for (i = mHD;; i = mHB)
      {
        localLayoutParams.height = i;
        i = mHL;
        j = mHL;
        localLayoutParams.setMargins(i, i, j, j);
        this.mHZ.setLayoutParams(localLayoutParams);
        this.mIa.setVisibility(0);
        bAw();
        AppMethodBeat.o(176977);
        return;
        j = mHA;
        break;
      }
      label253:
      if (xk(this.mHc))
      {
        if (i != 0)
        {
          j = mHG;
          localLayoutParams.width = j;
          if (i == 0) {
            break label336;
          }
        }
        for (i = mHH;; i = mHF)
        {
          localLayoutParams.height = i;
          i = mHL;
          j = mHL;
          localLayoutParams.setMargins(i, i, j, j);
          this.mHZ.setLayoutParams(localLayoutParams);
          this.mIa.setVisibility(8);
          AppMethodBeat.o(176977);
          return;
          j = mHE;
          break;
        }
      }
      label336:
      if (i != 0)
      {
        j = mHG;
        localLayoutParams.width = j;
        if (i == 0) {
          break label419;
        }
      }
      label419:
      for (i = mHH;; i = mHF)
      {
        localLayoutParams.height = i;
        i = mHL;
        j = mHL;
        localLayoutParams.setMargins(i, i, j, j);
        this.mHZ.setLayoutParams(localLayoutParams);
        this.mIa.setVisibility(0);
        bAw();
        AppMethodBeat.o(176977);
        return;
        j = mHE;
        break;
      }
    }
    this.jpE.setVisibility(8);
    this.mHZ.setVisibility(8);
    this.mIa.setVisibility(0);
    bAw();
    AppMethodBeat.o(176977);
  }
  
  private void bAw()
  {
    AppMethodBeat.i(176978);
    Object localObject = (LinearLayout.LayoutParams)this.mIa.getLayoutParams();
    if (wS(this.mHc)) {}
    for (int i = 8388629;; i = 8388627)
    {
      ((LinearLayout.LayoutParams)localObject).gravity = i;
      this.mIa.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if ((!wP(this.mHc)) || (!wQ(this.mHc))) {
        break;
      }
      bAz();
      AppMethodBeat.o(176978);
      return;
    }
    if ((xl(this.mHc)) || (xa(this.mHc)))
    {
      this.mIc.setVisibility(8);
      this.mIb.setVisibility(0);
      localObject = (FrameLayout.LayoutParams)this.mIb.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).gravity = 8388629;
      i = mHL;
      int j = mHL;
      ((FrameLayout.LayoutParams)localObject).setMargins(i, i, j, j);
      this.mIb.setLayoutParams((ViewGroup.LayoutParams)localObject);
      AppMethodBeat.o(176978);
      return;
    }
    if (wQ(this.mHc))
    {
      this.mIb.setVisibility(8);
      B(true, true);
    }
    AppMethodBeat.o(176978);
  }
  
  private void bAx()
  {
    AppMethodBeat.i(176979);
    LinearLayout.LayoutParams localLayoutParams;
    int i;
    int j;
    if (wS(this.mHc))
    {
      this.jpE.setVisibility(0);
      this.mHZ.setVisibility(0);
      localLayoutParams = (LinearLayout.LayoutParams)this.mHZ.getLayoutParams();
      if ((wP(this.mHc)) && (wX(this.mHc)))
      {
        i = 1;
        if (!wT(this.mHc)) {
          break label254;
        }
        if (!xj(this.mHc)) {
          break label175;
        }
        if (i == 0) {
          break label161;
        }
        j = mHC;
        label93:
        localLayoutParams.width = j;
        if (i == 0) {
          break label168;
        }
        i = mHD;
        label106:
        localLayoutParams.height = i;
        i = mHL;
        j = mHL;
        localLayoutParams.setMargins(i, i, j, j);
        this.mHZ.setLayoutParams(localLayoutParams);
        this.mIa.setVisibility(8);
      }
    }
    for (;;)
    {
      bAB();
      AppMethodBeat.o(176979);
      return;
      i = 0;
      break;
      label161:
      j = mHA;
      break label93;
      label168:
      i = mHB;
      break label106;
      label175:
      if (i != 0)
      {
        j = mHC;
        label183:
        localLayoutParams.width = j;
        if (i == 0) {
          break label247;
        }
      }
      label247:
      for (i = mHD;; i = mHB)
      {
        localLayoutParams.height = i;
        i = mHL;
        j = mHL;
        localLayoutParams.setMargins(i, i, j, j);
        this.mHZ.setLayoutParams(localLayoutParams);
        this.mIa.setVisibility(0);
        bAy();
        break;
        j = mHA;
        break label183;
      }
      label254:
      if (xk(this.mHc))
      {
        if (i != 0)
        {
          j = mHG;
          localLayoutParams.width = j;
          if (i == 0) {
            break label333;
          }
        }
        for (i = mHH;; i = mHF)
        {
          localLayoutParams.height = i;
          i = mHL;
          j = mHL;
          localLayoutParams.setMargins(i, i, j, j);
          this.mHZ.setLayoutParams(localLayoutParams);
          this.mIa.setVisibility(8);
          break;
          j = mHE;
          break label272;
        }
      }
      label272:
      label333:
      if (i != 0)
      {
        j = mHG;
        label348:
        localLayoutParams.width = j;
        if (i == 0) {
          break label412;
        }
      }
      label412:
      for (i = mHH;; i = mHF)
      {
        localLayoutParams.height = i;
        i = mHL;
        j = mHL;
        localLayoutParams.setMargins(i, i, j, j);
        this.mHZ.setLayoutParams(localLayoutParams);
        this.mIa.setVisibility(0);
        bAy();
        break;
        j = mHE;
        break label348;
      }
      this.jpE.setVisibility(8);
      this.mHZ.setVisibility(8);
      this.mIa.setVisibility(0);
      bAy();
    }
  }
  
  private void bAy()
  {
    AppMethodBeat.i(176980);
    Object localObject = (LinearLayout.LayoutParams)this.mIa.getLayoutParams();
    if (wS(this.mHc)) {}
    for (int i = 8388627;; i = 8388629)
    {
      ((LinearLayout.LayoutParams)localObject).gravity = i;
      this.mIa.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if ((!wP(this.mHc)) || (!wQ(this.mHc))) {
        break;
      }
      bAA();
      AppMethodBeat.o(176980);
      return;
    }
    if ((xl(this.mHc)) || (xa(this.mHc)))
    {
      this.mIc.setVisibility(8);
      this.mIb.setVisibility(0);
      localObject = (FrameLayout.LayoutParams)this.mIb.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).gravity = 8388629;
      i = mHL;
      int j = mHL;
      ((FrameLayout.LayoutParams)localObject).setMargins(i, i, j, j);
      this.mIb.setLayoutParams((ViewGroup.LayoutParams)localObject);
      AppMethodBeat.o(176980);
      return;
    }
    if (wQ(this.mHc))
    {
      this.mIb.setVisibility(8);
      B(false, true);
    }
    AppMethodBeat.o(176980);
  }
  
  private void bAz()
  {
    AppMethodBeat.i(176981);
    int i = B(true, true);
    this.mIb.setVisibility(0);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.mIb.getLayoutParams();
    localLayoutParams.gravity = 8388627;
    int j = mHL;
    localLayoutParams.setMargins(i, j, j, mHL);
    this.mIb.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(176981);
  }
  
  private void bZ(List<BallInfo> paramList)
  {
    AppMethodBeat.i(106443);
    this.mHd = this.mHc;
    this.mHc = 0;
    if (AppForegroundDelegate.cKE.csU) {
      this.mHc |= 0x20;
    }
    List localList = d.bS(d.bQ(d.bR(paramList)));
    this.mIE = d.bN(localList);
    int i = d.wE(d.bW(localList));
    boolean bool3 = d.bO(d.bV(paramList));
    if (bool3) {
      this.mHc |= 0x1;
    }
    boolean bool1;
    label136:
    boolean bool2;
    if (i == 1)
    {
      this.mHc |= 0x2;
      this.mIA = d.bT(paramList);
      if ((this.mIA == null) || (this.mIA.state != 4)) {
        break label384;
      }
      bool1 = true;
      if ((this.mIA == null) || (this.mIA.state != 8)) {
        break label389;
      }
      bool2 = true;
      label158:
      if (bool1) {
        this.mHc |= 0x8;
      }
      if (bool2) {
        this.mHc |= 0x10;
      }
      if ((this.mIA != null) && (this.mIA.sk != null)) {
        setVOIPView(this.mIA.sk);
      }
      this.mIB = d.bU(paramList);
      if (this.mIB != null)
      {
        if (this.mIB.state != 32) {
          break label395;
        }
        this.mHc |= 0x100;
      }
    }
    for (;;)
    {
      ad.i("MicroMsg.FloatBallView", ">>> updateFloatBallViewLayoutState, state:[%s => %s], active:%s, passiveCnt:%d, video:%s, audio:%s <<<", new Object[] { Integer.valueOf(this.mHd), Integer.valueOf(this.mHc), Boolean.valueOf(bool3), Integer.valueOf(i), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      AppMethodBeat.o(106443);
      return;
      if (i == 2)
      {
        this.mHc |= 0x4;
        break;
      }
      if (i == 3)
      {
        this.mHc |= 0x40;
        break;
      }
      if (i != 4) {
        break;
      }
      this.mHc |= 0x80;
      break;
      label384:
      bool1 = false;
      break label136;
      label389:
      bool2 = false;
      break label158;
      label395:
      if (this.mIB.state == 64) {
        this.mHc |= 0x200;
      }
    }
  }
  
  private static String ca(List<BallInfo> paramList)
  {
    AppMethodBeat.i(106474);
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramList.size())
    {
      BallInfo localBallInfo = (BallInfo)paramList.get(i);
      localStringBuilder.append(localBallInfo.key).append(localBallInfo.type).append(localBallInfo.dub).append(localBallInfo.kYl).append(localBallInfo.state).append(localBallInfo.mDu).append(localBallInfo.mDv).append(localBallInfo.progress);
      if ((localBallInfo.type == 9) && (localBallInfo.sk != null)) {
        localStringBuilder.append(localBallInfo.sk.hashCode());
      }
      localStringBuilder.append("|");
      i += 1;
    }
    paramList = com.tencent.mm.sdk.platformtools.ai.du(localStringBuilder.toString());
    AppMethodBeat.o(106474);
    return paramList;
  }
  
  private void e(boolean paramBoolean, final int paramInt1, final int paramInt2, final int paramInt3, final int paramInt4)
  {
    AppMethodBeat.i(106464);
    ad.i("MicroMsg.FloatBallView", "start StickyAnimation, stickToLeft:%s, startPositionY: %d, targetPositionY: %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2), Integer.valueOf(paramInt4) });
    if ((this.mHU != null) && (this.mHU.isRunning()))
    {
      ad.i("MicroMsg.FloatBallView", "cancel StickyAnimation");
      this.mHU.cancel();
    }
    this.mHU = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.mHU.setInterpolator(new AccelerateDecelerateInterpolator());
    this.mHU.setDuration(100L);
    this.mHU.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(106432);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        int i = paramInt1;
        int j = (int)((paramInt3 * 1.0F - paramInt1) * f);
        int k = paramInt2;
        int m = (int)(f * (paramInt4 * 1.0F - paramInt2));
        FloatBallView.this.e(i + j, m + k, false, false);
        AppMethodBeat.o(106432);
      }
    });
    this.mHU.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(106433);
        super.onAnimationEnd(paramAnonymousAnimator);
        paramAnonymousAnimator = (WindowManager.LayoutParams)FloatBallView.this.getLayoutParams();
        FloatBallView.this.f(paramAnonymousAnimator.x, paramAnonymousAnimator.y, true, false);
        AppMethodBeat.o(106433);
      }
    });
    this.mHU.start();
    AppMethodBeat.o(106464);
  }
  
  private void e(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int i = 8388627;
    int j = 1;
    AppMethodBeat.i(106444);
    if ((this.mIQ == paramBoolean1) && (this.mIR == paramBoolean2) && (this.mIP == paramBoolean3) && (this.mIS != 0) && (this.mIS == this.mHc))
    {
      ad.d("MicroMsg.FloatBallView", "<<< updateFloatBallViewLayout, ignore layout %b %b;%b %b; %b %b; %d %d", new Object[] { Boolean.valueOf(this.mIX), Boolean.valueOf(paramBoolean1), Boolean.valueOf(this.mIR), Boolean.valueOf(paramBoolean2), Boolean.valueOf(this.mIP), Boolean.valueOf(paramBoolean3), Integer.valueOf(this.mIS), Integer.valueOf(this.mHc) });
      AppMethodBeat.o(106444);
      return;
    }
    ad.i("MicroMsg.FloatBallView", ">>> updateFloatBallViewLayout, isSettled:%s, isDockLeft:%s, isManual:%s, lastLayoutState:%s, currentLayoutState:%s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3), Integer.valueOf(this.mIS), Integer.valueOf(this.mHc) });
    this.mIP = paramBoolean3;
    this.mIQ = paramBoolean1;
    this.mIR = paramBoolean2;
    this.mIS = this.mHc;
    bAG();
    int k = this.mHY.getPaddingLeft();
    int m = this.mHY.getPaddingRight();
    int n = this.mHY.getPaddingTop();
    int i1 = this.mHY.getPaddingBottom();
    if (wZ(this.mHc))
    {
      localObject = (FrameLayout.LayoutParams)this.mHY.getLayoutParams();
      if (paramBoolean2) {}
      for (;;)
      {
        ((FrameLayout.LayoutParams)localObject).gravity = i;
        this.mHY.setLayoutParams((ViewGroup.LayoutParams)localObject);
        if (!paramBoolean1) {
          break label700;
        }
        if (!paramBoolean2) {
          break;
        }
        this.mHY.setPadding(getExtendWidth(), n, m, i1);
        this.mHY.setLayoutTransition(this.mIF);
        bAv();
        AppMethodBeat.o(106444);
        return;
        i = 8388629;
      }
      this.mHY.setPadding(k, n, getExtendWidth(), i1);
      if (((xb(this.mHd)) && (xf(this.mHc))) || ((xc(this.mHd)) && (xg(this.mHc))) || ((xd(this.mHd)) && (xh(this.mHc))) || ((xe(this.mHd)) && (xi(this.mHc))))
      {
        this.mHY.setLayoutTransition(null);
        bAx();
        AppMethodBeat.o(106444);
        return;
      }
      if (((xa(this.mHd)) && (xf(this.mHc))) || ((xa(this.mHd)) && (xg(this.mHc))) || ((xa(this.mHd)) && (xh(this.mHc))) || ((xa(this.mHd)) && (xi(this.mHc))))
      {
        this.mHY.setLayoutTransition(null);
        bAx();
        AppMethodBeat.o(106444);
        return;
      }
      if (((xf(this.mHd)) && (xa(this.mHc))) || ((xg(this.mHd)) && (xa(this.mHc))) || ((xh(this.mHd)) && (xa(this.mHc))) || ((xi(this.mHd)) && (xa(this.mHc))))
      {
        this.mHY.setLayoutTransition(null);
        bAx();
        AppMethodBeat.o(106444);
        return;
      }
      this.mHY.setLayoutTransition(this.mIF);
      bAx();
      AppMethodBeat.o(106444);
      return;
      label700:
      if ((xf(this.mHc)) || (xg(this.mHc)) || (xh(this.mHc)) || (xi(this.mHc)))
      {
        if (paramBoolean2)
        {
          bAz();
          AppMethodBeat.o(106444);
          return;
        }
        bAA();
        AppMethodBeat.o(106444);
        return;
      }
      if ((xb(this.mHc)) || (xc(this.mHc)) || (xd(this.mHc)) || (xe(this.mHc)))
      {
        B(paramBoolean2, false);
        AppMethodBeat.o(106444);
        return;
      }
      if (xa(this.mHc))
      {
        localObject = (FrameLayout.LayoutParams)this.mIb.getLayoutParams();
        ((FrameLayout.LayoutParams)localObject).gravity = 17;
        i = mHL;
        j = mHL;
        ((FrameLayout.LayoutParams)localObject).setMargins(i, i, j, j);
        this.mIb.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      AppMethodBeat.o(106444);
      return;
    }
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        this.mHY.setPadding(getExtendWidth(), n, m, i1);
        this.mHY.setLayoutTransition(this.mIF);
        localObject = (FrameLayout.LayoutParams)this.mHY.getLayoutParams();
        ((FrameLayout.LayoutParams)localObject).gravity = 8388627;
        this.mHY.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.jpE.setVisibility(8);
        if (wR(this.mHc))
        {
          this.mIa.setVisibility(0);
          this.mIb.setVisibility(8);
          this.mIc.setVisibility(0);
          localObject = (LinearLayout.LayoutParams)this.mIa.getLayoutParams();
          ((LinearLayout.LayoutParams)localObject).gravity = 8388627;
          this.mIa.setLayoutParams((ViewGroup.LayoutParams)localObject);
          B(true, true);
          this.mHZ.setVisibility(0);
          localObject = (LinearLayout.LayoutParams)this.mHZ.getLayoutParams();
          if ((!wP(this.mHc)) || (!wX(this.mHc))) {
            break label1171;
          }
          i = 1;
          label1076:
          if (!wT(this.mHc)) {
            break label1193;
          }
          if (i == 0) {
            break label1177;
          }
          j = mHC;
          label1096:
          ((LinearLayout.LayoutParams)localObject).width = j;
          if (i == 0) {
            break label1185;
          }
        }
        label1171:
        label1177:
        label1185:
        for (i = mHD;; i = mHB)
        {
          ((LinearLayout.LayoutParams)localObject).height = i;
          i = mHL;
          j = mHL;
          ((LinearLayout.LayoutParams)localObject).setMargins(i, i, j, j);
          this.mHZ.setLayoutParams((ViewGroup.LayoutParams)localObject);
          AppMethodBeat.o(106444);
          return;
          this.mIa.setVisibility(8);
          break;
          i = 0;
          break label1076;
          j = mHA;
          break label1096;
        }
        label1193:
        if (wU(this.mHc))
        {
          if (i != 0)
          {
            j = mHG;
            ((LinearLayout.LayoutParams)localObject).width = j;
            if (i == 0) {
              break label1284;
            }
          }
          for (i = mHH;; i = mHF)
          {
            ((LinearLayout.LayoutParams)localObject).height = i;
            i = mHL;
            j = mHL;
            ((LinearLayout.LayoutParams)localObject).setMargins(i, i, j, j);
            this.mHZ.setLayoutParams((ViewGroup.LayoutParams)localObject);
            AppMethodBeat.o(106444);
            return;
            j = mHE;
            break;
          }
        }
        label1284:
        this.mHZ.setVisibility(8);
        AppMethodBeat.o(106444);
        return;
      }
      this.mHY.setPadding(k, n, getExtendWidth(), i1);
      this.mHY.setLayoutTransition(this.mIF);
      localObject = (FrameLayout.LayoutParams)this.mHY.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).gravity = 8388629;
      this.mHY.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jpE.setVisibility(8);
      if (wR(this.mHc))
      {
        this.mIa.setVisibility(0);
        this.mIb.setVisibility(8);
        this.mIc.setVisibility(0);
        localObject = (LinearLayout.LayoutParams)this.mIa.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject).gravity = 8388629;
        this.mIa.setLayoutParams((ViewGroup.LayoutParams)localObject);
        B(false, true);
        bAB();
        this.mHZ.setVisibility(0);
        localObject = (LinearLayout.LayoutParams)this.mHZ.getLayoutParams();
        if ((!wP(this.mHc)) || (!wX(this.mHc))) {
          break label1589;
        }
        i = j;
        label1494:
        if (!wT(this.mHc)) {
          break label1611;
        }
        if (i == 0) {
          break label1595;
        }
        j = mHC;
        label1514:
        ((LinearLayout.LayoutParams)localObject).width = j;
        if (i == 0) {
          break label1603;
        }
      }
      label1589:
      label1595:
      label1603:
      for (i = mHD;; i = mHB)
      {
        ((LinearLayout.LayoutParams)localObject).height = i;
        i = mHL;
        j = mHL;
        ((LinearLayout.LayoutParams)localObject).setMargins(i, i, j, j);
        this.mHZ.setLayoutParams((ViewGroup.LayoutParams)localObject);
        AppMethodBeat.o(106444);
        return;
        this.mIa.setVisibility(8);
        break;
        i = 0;
        break label1494;
        j = mHA;
        break label1514;
      }
      label1611:
      if (wU(this.mHc))
      {
        if (i != 0)
        {
          j = mHG;
          ((LinearLayout.LayoutParams)localObject).width = j;
          if (i == 0) {
            break label1702;
          }
        }
        for (i = mHH;; i = mHF)
        {
          ((LinearLayout.LayoutParams)localObject).height = i;
          i = mHL;
          j = mHL;
          ((LinearLayout.LayoutParams)localObject).setMargins(i, i, j, j);
          this.mHZ.setLayoutParams((ViewGroup.LayoutParams)localObject);
          AppMethodBeat.o(106444);
          return;
          j = mHE;
          break;
        }
      }
      label1702:
      this.mHZ.setVisibility(8);
      AppMethodBeat.o(106444);
      return;
    }
    Object localObject = (FrameLayout.LayoutParams)this.mHY.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject).gravity = 17;
    this.mHY.setLayoutParams((ViewGroup.LayoutParams)localObject);
    AppMethodBeat.o(106444);
  }
  
  private int getAppBrandVoipBallInfoIndex()
  {
    AppMethodBeat.i(190673);
    if (d.h(this.mIE))
    {
      int i = 0;
      while (i < this.mIE.size())
      {
        BallInfo localBallInfo = (BallInfo)this.mIE.get(i);
        if ((localBallInfo != null) && (localBallInfo.type == 17))
        {
          AppMethodBeat.o(190673);
          return i;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(190673);
    return 0;
  }
  
  private int getCurrentStateHeight()
  {
    AppMethodBeat.i(176991);
    int i = getHeight();
    if (xj(this.mHc)) {
      i = mHp;
    }
    for (;;)
    {
      int j = com.tencent.mm.plugin.ball.f.e.mFM;
      int k = com.tencent.mm.plugin.ball.f.e.mFN;
      AppMethodBeat.o(176991);
      return i + j + k;
      if (xk(this.mHc)) {
        i = mHv;
      } else if ((wT(this.mHc)) && ((wP(this.mHc)) || (wQ(this.mHc)))) {
        i = mHr;
      } else if ((wU(this.mHc)) && ((wP(this.mHc)) || (wQ(this.mHc)))) {
        i = mHx;
      } else if (xa(this.mHc)) {
        i = mHf;
      } else if (xb(this.mHc)) {
        i = mHj;
      } else if (xc(this.mHc)) {
        i = mHl;
      } else if ((xd(this.mHc)) || (xe(this.mHc))) {
        i = mHn;
      } else if ((xf(this.mHc)) || (xg(this.mHc)) || (xh(this.mHc)) || (xi(this.mHc))) {
        i = mHh;
      }
    }
  }
  
  private int getExtendWidth()
  {
    AppMethodBeat.i(106469);
    if (!this.mIN)
    {
      AppMethodBeat.o(106469);
      return 0;
    }
    if (!d.ea(getContext()))
    {
      AppMethodBeat.o(106469);
      return 0;
    }
    int i = this.windowManager.getDefaultDisplay().getRotation();
    if (((this.mIH) && (i == 1)) || ((!this.mIH) && (i == 3)))
    {
      i = d.aE(getContext());
      AppMethodBeat.o(106469);
      return i;
    }
    AppMethodBeat.o(106469);
    return 0;
  }
  
  private int getTargetPositionXWhenOrientationChanged()
  {
    AppMethodBeat.i(106466);
    int i = 0;
    if (!this.mIH) {
      i = this.mII.x - getCurrentStateWidth();
    }
    AppMethodBeat.o(106466);
    return i;
  }
  
  private void setFloatBallAlphaInternal(float paramFloat)
  {
    AppMethodBeat.i(106461);
    setAlpha(paramFloat);
    if (paramFloat == 0.0F)
    {
      ad.i("MicroMsg.FloatBallView", "setFloatBallAlphaInternal, GONE");
      setVisibility(8);
      AppMethodBeat.o(106461);
      return;
    }
    ad.i("MicroMsg.FloatBallView", "setFloatBallAlphaInternal, VISIBLE, alpha:%s", new Object[] { Float.valueOf(paramFloat) });
    setVisibility(0);
    AppMethodBeat.o(106461);
  }
  
  private void wL(int paramInt)
  {
    AppMethodBeat.i(190672);
    Point localPoint1 = this.mII;
    this.mII = com.tencent.mm.ui.ai.cf(getContext());
    Point localPoint2 = this.mII;
    Object localObject;
    int i;
    int j;
    int k;
    if (localPoint1 != null)
    {
      localObject = localPoint1;
      ad.i("MicroMsg.FloatBallView", "processOrientationChanged, screenResolution: %s, lastResolution: %s", new Object[] { localPoint2, localObject });
      if ((this.iHo != paramInt) || ((localPoint1 != null) && ((localPoint1.x != this.mII.x) || (localPoint1.y != this.mII.y))))
      {
        this.iHo = paramInt;
        this.mIN = true;
        localObject = (WindowManager.LayoutParams)getLayoutParams();
        paramInt = ((WindowManager.LayoutParams)localObject).x;
        i = (int)(this.mII.y * this.mIL);
        paramInt = Math.max(Math.min(paramInt, this.mII.x), 0);
        i = Math.max(Math.min(i, this.mII.y), 0);
        j = getTargetPositionXWhenOrientationChanged();
        k = wN(i);
        if (j != 0) {
          break label294;
        }
      }
    }
    label294:
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.FloatBallView", "processOrientationChanged, layoutParams.x: %s, layoutParams.y: %s, stickToLeft:%s, startSticky:[%s, %s]=>[%s, %s]", new Object[] { Integer.valueOf(((WindowManager.LayoutParams)localObject).x), Integer.valueOf(((WindowManager.LayoutParams)localObject).y), Boolean.valueOf(bool), Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
      e(bool, paramInt, i, j, k);
      AppMethodBeat.o(190672);
      return;
      localObject = "null";
      break;
    }
  }
  
  private boolean wM(int paramInt)
  {
    AppMethodBeat.i(176987);
    if (getCurrentStateWidth() + paramInt != this.mII.x)
    {
      AppMethodBeat.o(176987);
      return true;
    }
    AppMethodBeat.o(176987);
    return false;
  }
  
  private static int wN(int paramInt)
  {
    int i;
    if (paramInt < com.tencent.mm.plugin.ball.f.e.mFT) {
      i = com.tencent.mm.plugin.ball.f.e.mFT;
    }
    do
    {
      return i;
      i = paramInt;
    } while (paramInt <= com.tencent.mm.plugin.ball.f.e.mFU);
    return com.tencent.mm.plugin.ball.f.e.mFU;
  }
  
  private int wO(int paramInt)
  {
    AppMethodBeat.i(106465);
    int i = 0;
    if (!ut(paramInt)) {
      i = this.mII.x - getCurrentStateWidth();
    }
    AppMethodBeat.o(106465);
    return i;
  }
  
  private static boolean wP(int paramInt)
  {
    return (paramInt & 0x1) != 0;
  }
  
  private static boolean wQ(int paramInt)
  {
    AppMethodBeat.i(176994);
    if ((wV(paramInt)) || (wW(paramInt)) || (wX(paramInt)) || (wY(paramInt)))
    {
      AppMethodBeat.o(176994);
      return true;
    }
    AppMethodBeat.o(176994);
    return false;
  }
  
  public static boolean wR(int paramInt)
  {
    return ((paramInt & 0x100) != 0) || ((paramInt & 0x200) != 0);
  }
  
  private static boolean wS(int paramInt)
  {
    AppMethodBeat.i(176995);
    if ((wT(paramInt)) || (wU(paramInt)))
    {
      AppMethodBeat.o(176995);
      return true;
    }
    AppMethodBeat.o(176995);
    return false;
  }
  
  private static boolean wT(int paramInt)
  {
    return (paramInt & 0x8) != 0;
  }
  
  private static boolean wU(int paramInt)
  {
    return (paramInt & 0x10) != 0;
  }
  
  private static boolean wV(int paramInt)
  {
    return (paramInt & 0x2) != 0;
  }
  
  private static boolean wW(int paramInt)
  {
    return (paramInt & 0x4) != 0;
  }
  
  private static boolean wX(int paramInt)
  {
    return (paramInt & 0x40) != 0;
  }
  
  private static boolean wY(int paramInt)
  {
    return (paramInt & 0x80) != 0;
  }
  
  private static boolean wZ(int paramInt)
  {
    return (paramInt & 0x20) != 0;
  }
  
  private static boolean xa(int paramInt)
  {
    AppMethodBeat.i(176996);
    if ((wP(paramInt)) && (!wS(paramInt)) && (!wQ(paramInt)))
    {
      AppMethodBeat.o(176996);
      return true;
    }
    AppMethodBeat.o(176996);
    return false;
  }
  
  private static boolean xb(int paramInt)
  {
    AppMethodBeat.i(176997);
    if ((wV(paramInt)) && (!wS(paramInt)) && (!wP(paramInt)))
    {
      AppMethodBeat.o(176997);
      return true;
    }
    AppMethodBeat.o(176997);
    return false;
  }
  
  private static boolean xc(int paramInt)
  {
    AppMethodBeat.i(176998);
    if ((wW(paramInt)) && (!wS(paramInt)) && (!wP(paramInt)))
    {
      AppMethodBeat.o(176998);
      return true;
    }
    AppMethodBeat.o(176998);
    return false;
  }
  
  private static boolean xd(int paramInt)
  {
    AppMethodBeat.i(176999);
    if ((wX(paramInt)) && (!wS(paramInt)) && (!wP(paramInt)))
    {
      AppMethodBeat.o(176999);
      return true;
    }
    AppMethodBeat.o(176999);
    return false;
  }
  
  private static boolean xe(int paramInt)
  {
    AppMethodBeat.i(190678);
    if ((wY(paramInt)) && (!wS(paramInt)) && (!wP(paramInt)))
    {
      AppMethodBeat.o(190678);
      return true;
    }
    AppMethodBeat.o(190678);
    return false;
  }
  
  private static boolean xf(int paramInt)
  {
    AppMethodBeat.i(177000);
    if ((wV(paramInt)) && (wP(paramInt)) && (!wS(paramInt)))
    {
      AppMethodBeat.o(177000);
      return true;
    }
    AppMethodBeat.o(177000);
    return false;
  }
  
  private static boolean xg(int paramInt)
  {
    AppMethodBeat.i(177001);
    if ((wW(paramInt)) && (wP(paramInt)) && (!wS(paramInt)))
    {
      AppMethodBeat.o(177001);
      return true;
    }
    AppMethodBeat.o(177001);
    return false;
  }
  
  private static boolean xh(int paramInt)
  {
    AppMethodBeat.i(177002);
    if ((wX(paramInt)) && (wP(paramInt)) && (!wS(paramInt)))
    {
      AppMethodBeat.o(177002);
      return true;
    }
    AppMethodBeat.o(177002);
    return false;
  }
  
  private static boolean xi(int paramInt)
  {
    AppMethodBeat.i(190679);
    if ((wY(paramInt)) && (wP(paramInt)) && (!wS(paramInt)))
    {
      AppMethodBeat.o(190679);
      return true;
    }
    AppMethodBeat.o(190679);
    return false;
  }
  
  private static boolean xj(int paramInt)
  {
    AppMethodBeat.i(177003);
    if ((wT(paramInt)) && (!wP(paramInt)) && (!wQ(paramInt)))
    {
      AppMethodBeat.o(177003);
      return true;
    }
    AppMethodBeat.o(177003);
    return false;
  }
  
  private static boolean xk(int paramInt)
  {
    AppMethodBeat.i(177004);
    if ((wU(paramInt)) && (!wP(paramInt)) && (!wQ(paramInt)))
    {
      AppMethodBeat.o(177004);
      return true;
    }
    AppMethodBeat.o(177004);
    return false;
  }
  
  private static boolean xl(int paramInt)
  {
    AppMethodBeat.i(177005);
    if ((wP(paramInt)) && (wS(paramInt)) && (!wQ(paramInt)))
    {
      AppMethodBeat.o(177005);
      return true;
    }
    AppMethodBeat.o(177005);
    return false;
  }
  
  public final void a(List<BallInfo> paramList, BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106442);
    paramBallInfo = ca(paramList);
    if (bt.kU(paramBallInfo, this.mIC))
    {
      ad.d("MicroMsg.FloatBallView", "<<< onFloatBallInfoChanged, ignore refresh");
      AppMethodBeat.o(106442);
      return;
    }
    ad.i("MicroMsg.FloatBallView", ">>> onFloatBallInfoChanged, ballInfoList:%s", new Object[] { paramList });
    this.mIC = paramBallInfo;
    bZ(paramList);
    bAC();
    boolean bool = ut(((WindowManager.LayoutParams)getLayoutParams()).x);
    e(true, bool, false);
    a(true, bool, false, this.mHc);
    bAD();
    AppMethodBeat.o(106442);
  }
  
  public final void b(boolean paramBoolean, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(184624);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.du(paramBoolean);
    localb.be(paramAnimatorListenerAdapter);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ball/view/FloatBallView", "com/tencent/mm/plugin/ball/view/FloatBallView", "hide", "(ZLandroid/animation/AnimatorListenerAdapter;)V", this, localb.ado());
    if (getVisibility() == 8)
    {
      ad.i("MicroMsg.FloatBallView", "float ball already hide");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ball/view/FloatBallView", "com/tencent/mm/plugin/ball/view/FloatBallView", "hide", "(ZLandroid/animation/AnimatorListenerAdapter;)V");
      AppMethodBeat.o(184624);
      return;
    }
    if ((paramBoolean) && (this.mHV != null))
    {
      ad.i("MicroMsg.FloatBallView", "hide with animation");
      this.mHV.b(paramAnimatorListenerAdapter);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ball/view/FloatBallView", "com/tencent/mm/plugin/ball/view/FloatBallView", "hide", "(ZLandroid/animation/AnimatorListenerAdapter;)V");
      AppMethodBeat.o(184624);
      return;
      ad.i("MicroMsg.FloatBallView", "hide without animation");
      setVisibility(8);
    }
  }
  
  public final void bAF()
  {
    AppMethodBeat.i(184622);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.du(false);
    localb.be(null);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ball/view/FloatBallView", "com/tencent/mm/plugin/ball/view/FloatBallView", "show", "(ZLandroid/animation/AnimatorListenerAdapter;)V", this, localb.ado());
    c(false, false, null);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ball/view/FloatBallView", "com/tencent/mm/plugin/ball/view/FloatBallView", "show", "(ZLandroid/animation/AnimatorListenerAdapter;)V");
    AppMethodBeat.o(184622);
  }
  
  public final void c(boolean paramBoolean1, boolean paramBoolean2, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(184623);
    if ((getVisibility() == 0) && (paramBoolean2))
    {
      ad.i("MicroMsg.FloatBallView", "float ball already show");
      AppMethodBeat.o(184623);
      return;
    }
    if ((paramBoolean1) && (this.mHV != null))
    {
      ad.i("MicroMsg.FloatBallView", "show with animation");
      this.mHV.a(paramAnimatorListenerAdapter);
      AppMethodBeat.o(184623);
      return;
    }
    ad.i("MicroMsg.FloatBallView", "show without animation");
    setVisibility(0);
    AppMethodBeat.o(184623);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(176988);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(176988);
    return bool;
  }
  
  public final void e(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(106456);
    WindowManager.LayoutParams localLayoutParams = (WindowManager.LayoutParams)getLayoutParams();
    int i = localLayoutParams.x;
    int j = localLayoutParams.y;
    if ((this.windowManager != null) && ((i != paramInt1) || (j != paramInt2)))
    {
      localLayoutParams.x = paramInt1;
      localLayoutParams.y = paramInt2;
      try
      {
        this.windowManager.updateViewLayout(this, localLayoutParams);
        f(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
        AppMethodBeat.o(106456);
        return;
      }
      catch (Throwable localThrowable)
      {
        ad.printErrStackTrace("MicroMsg.FloatBallView", localThrowable, "updateBallPosition fail", new Object[0]);
      }
    }
    AppMethodBeat.o(106456);
  }
  
  public final void f(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(106457);
    this.mIH = ut(paramInt1);
    a(paramBoolean1, this.mIH, paramBoolean2, this.mHc);
    e(paramBoolean1, this.mIH, paramBoolean2);
    Q(paramInt2, paramBoolean1);
    ad.i("MicroMsg.FloatBallView", "notifyBallPositionChanged, x:%s, y:%s, isSettled:%s, isManual:%s, isDockLeft:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(this.mIH) });
    Iterator localIterator = this.csT.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.plugin.ball.d.b)localIterator.next()).a(paramInt1, paramInt2, getCurrentStateHeight(), paramBoolean1, this.mIH);
    }
    AppMethodBeat.o(106457);
  }
  
  public Point getBallPosition()
  {
    AppMethodBeat.i(106470);
    Object localObject = (WindowManager.LayoutParams)getLayoutParams();
    if (localObject == null)
    {
      AppMethodBeat.o(106470);
      return null;
    }
    if (this.mIH)
    {
      if (wT(this.mHc))
      {
        localObject = new Point(((WindowManager.LayoutParams)localObject).x, ((WindowManager.LayoutParams)localObject).y + com.tencent.mm.plugin.ball.f.e.mFM + mHB);
        AppMethodBeat.o(106470);
        return localObject;
      }
      if (wU(this.mHc))
      {
        localObject = new Point(((WindowManager.LayoutParams)localObject).x, ((WindowManager.LayoutParams)localObject).y + com.tencent.mm.plugin.ball.f.e.mFM + mHF);
        AppMethodBeat.o(106470);
        return localObject;
      }
      localObject = new Point(((WindowManager.LayoutParams)localObject).x, ((WindowManager.LayoutParams)localObject).y + com.tencent.mm.plugin.ball.f.e.mFM);
      AppMethodBeat.o(106470);
      return localObject;
    }
    if (wT(this.mHc))
    {
      localObject = new Point(((WindowManager.LayoutParams)localObject).x + com.tencent.mm.plugin.ball.f.e.mFO, ((WindowManager.LayoutParams)localObject).y + com.tencent.mm.plugin.ball.f.e.mFM + mHB);
      AppMethodBeat.o(106470);
      return localObject;
    }
    if (wU(this.mHc))
    {
      localObject = new Point(((WindowManager.LayoutParams)localObject).x + com.tencent.mm.plugin.ball.f.e.mFO, ((WindowManager.LayoutParams)localObject).y + com.tencent.mm.plugin.ball.f.e.mFM + mHF);
      AppMethodBeat.o(106470);
      return localObject;
    }
    localObject = new Point(((WindowManager.LayoutParams)localObject).x + com.tencent.mm.plugin.ball.f.e.mFO, ((WindowManager.LayoutParams)localObject).y + com.tencent.mm.plugin.ball.f.e.mFM);
    AppMethodBeat.o(106470);
    return localObject;
  }
  
  public int getCurrentStateWidth()
  {
    AppMethodBeat.i(106467);
    int i = getWidth();
    int j;
    if ((!wZ(this.mHc)) && (wR(this.mHc)))
    {
      if (wT(this.mHc)) {
        i = mHq;
      }
      for (;;)
      {
        j = com.tencent.mm.plugin.ball.f.e.mFO;
        AppMethodBeat.o(106467);
        return i + j;
        if (wU(this.mHc)) {
          i = mHw;
        } else {
          i = mHi;
        }
      }
    }
    if (xj(this.mHc)) {
      i = mHo;
    }
    for (;;)
    {
      j = com.tencent.mm.plugin.ball.f.e.mFO;
      AppMethodBeat.o(106467);
      return i + j;
      if (xk(this.mHc)) {
        i = mHu;
      } else if ((wT(this.mHc)) && (wP(this.mHc)) && (wX(this.mHc))) {
        i = mHs;
      } else if ((wU(this.mHc)) && (wP(this.mHc)) && (wX(this.mHc))) {
        i = mHy;
      } else if ((wT(this.mHc)) && ((wP(this.mHc)) || (wQ(this.mHc)))) {
        i = mHq;
      } else if ((wU(this.mHc)) && ((wP(this.mHc)) || (wQ(this.mHc)))) {
        i = mHw;
      } else if (xa(this.mHc)) {
        i = mHe;
      } else if (xb(this.mHc)) {
        i = mHi;
      } else if (xc(this.mHc)) {
        i = mHk;
      } else if ((xd(this.mHc)) || (xe(this.mHc))) {
        i = mHm;
      } else if ((xf(this.mHc)) || (xg(this.mHc))) {
        i = mHg;
      } else if ((xh(this.mHc)) || (xi(this.mHc))) {
        i = mHg + mHI;
      }
    }
  }
  
  public float getPosYPercentOfScreen()
  {
    return this.mIL;
  }
  
  public int getPositionY()
  {
    return this.mIM;
  }
  
  public final void ij(boolean paramBoolean)
  {
    AppMethodBeat.i(176992);
    ad.i("MicroMsg.FloatBallView", "markWechatInForeground, visibility:%s, inForeground:%s", new Object[] { Integer.valueOf(getVisibility()), Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
      this.mHc |= 0x20;
    }
    for (;;)
    {
      e(this.mIQ, this.mIR, this.mIP);
      AppMethodBeat.o(176992);
      return;
      this.mHc &= 0xFFFFFFDF;
      if ((wS(this.mHc)) || (wR(this.mHc)))
      {
        bAF();
        if ((int)getAlpha() == 0) {
          setAlpha(1.0F);
        }
      }
    }
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(106439);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ball/view/FloatBallView", "com/tencent/mm/plugin/ball/view/FloatBallView", "onAttachedToWindow", "()V", this);
    super.onAttachedToWindow();
    WindowManager.LayoutParams localLayoutParams = (WindowManager.LayoutParams)getLayoutParams();
    f(localLayoutParams.x, localLayoutParams.y, true, false);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ball/view/FloatBallView", "com/tencent/mm/plugin/ball/view/FloatBallView", "onAttachedToWindow", "()V");
    AppMethodBeat.o(106439);
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(106441);
    ad.i("MicroMsg.FloatBallView", "onConfigurationChanged, orientation:%d, lastOrientation: %d", new Object[] { Integer.valueOf(paramConfiguration.orientation), Integer.valueOf(this.iHo) });
    wL(paramConfiguration.orientation);
    int i = paramConfiguration.orientation;
    paramConfiguration = this.csT.iterator();
    while (paramConfiguration.hasNext()) {
      ((com.tencent.mm.plugin.ball.d.b)paramConfiguration.next()).wy(i);
    }
    AppMethodBeat.o(106441);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(106440);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ball/view/FloatBallView", "com/tencent/mm/plugin/ball/view/FloatBallView", "onDetachedFromWindow", "()V", this);
    super.onDetachedFromWindow();
    if (this.mHU != null)
    {
      this.mHU.cancel();
      this.mHU = null;
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ball/view/FloatBallView", "com/tencent/mm/plugin/ball/view/FloatBallView", "onDetachedFromWindow", "()V");
    AppMethodBeat.o(106440);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(106452);
    if (!this.mIG)
    {
      bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(106452);
      return bool;
    }
    switch (paramMotionEvent.getAction())
    {
    }
    Iterator localIterator;
    for (;;)
    {
      AppMethodBeat.o(106452);
      return true;
      this.mIT = false;
      this.mIJ.x = paramMotionEvent.getRawX();
      this.mIJ.y = paramMotionEvent.getRawY();
      paramMotionEvent = (WindowManager.LayoutParams)getLayoutParams();
      this.mIK.x = paramMotionEvent.x;
      this.mIK.y = paramMotionEvent.y;
      a(true, this.mIH, true, this.mHc);
      if (this.mIN) {
        e(true, this.mIH, true);
      }
      this.mCB = false;
      if ((wZ(this.mHc)) && (!xj(this.mHc)) && (!xk(this.mHc)))
      {
        this.mIU.postDelayed(this.mIV, this.mHS);
        continue;
        if (this.mCB)
        {
          Q(paramMotionEvent);
        }
        else
        {
          if ((!this.mIT) && (I(paramMotionEvent)))
          {
            this.mIU.removeCallbacks(this.mIV);
            this.mIT = true;
            i = this.mIK.x;
            i = this.mIK.y;
            localIterator = this.csT.iterator();
            while (localIterator.hasNext()) {
              ((com.tencent.mm.plugin.ball.d.b)localIterator.next()).bzc();
            }
          }
          if (this.mIT)
          {
            e(J(paramMotionEvent), K(paramMotionEvent), false, true);
            continue;
            if (this.mCB)
            {
              a(true, this.mIH, false, this.mHc);
              if (this.mIN) {
                e(true, this.mIH, false);
              }
              Q(paramMotionEvent);
            }
            else
            {
              this.mIU.removeCallbacks(this.mIV);
              if ((this.mIT) || (I(paramMotionEvent))) {
                break;
              }
              a(true, this.mIH, false, this.mHc);
              if (this.mIN) {
                e(true, this.mIH, false);
              }
              e(this.mIK.x, this.mIK.y, true, false);
              if (this.mIO)
              {
                float f1 = this.mIJ.x;
                float f2 = this.mIJ.y;
                long l = System.currentTimeMillis();
                if (l > this.lVv + 800L)
                {
                  this.lVv = l;
                  if (d.r(this.mHX, (int)f1, (int)f2))
                  {
                    ad.i("MicroMsg.FloatBallView", "notifyBallClickedIfNeed, you clicked voip");
                    if ((this.mIA != null) && (g.ab(c.class) != null))
                    {
                      this.mIA.mDw.opType = 3;
                      ((c)g.ab(c.class)).l(this.mIA);
                    }
                    this.mHX.callOnClick();
                  }
                  else if ((xk(this.mHc)) || (xj(this.mHc)))
                  {
                    ad.i("MicroMsg.FloatBallView", "notifyBallClickedIfNeed, ignore click");
                  }
                  else if (wZ(this.mHc))
                  {
                    ad.i("MicroMsg.FloatBallView", "notifyBallClickedIfNeed, wechat in foreground");
                    paramMotionEvent = this.csT.iterator();
                    while (paramMotionEvent.hasNext()) {
                      ((com.tencent.mm.plugin.ball.d.b)paramMotionEvent.next()).bza();
                    }
                  }
                  else if ((this.mIB != null) && (g.ab(c.class) != null))
                  {
                    ad.i("MicroMsg.FloatBallView", "notifyBallClickedIfNeed, you clicked appbrand voip");
                    this.mIB.mDw.opType = 3;
                    ((c)g.ab(c.class)).l(this.mIB);
                  }
                }
                else
                {
                  ad.i("MicroMsg.FloatBallView", "notifyBallClickedIfNeed, you clicked too fast!");
                }
              }
            }
          }
        }
      }
    }
    a(false, this.mIH, false, this.mHc);
    if (this.mIT)
    {
      this.mIT = false;
      localIterator = this.csT.iterator();
      while (localIterator.hasNext()) {
        ((com.tencent.mm.plugin.ball.d.b)localIterator.next()).bzd();
      }
    }
    int i = J(paramMotionEvent);
    int j = K(paramMotionEvent);
    int k = wO(i);
    int m = wN(j);
    if (k == 0) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.FloatBallView", "onTouchEvent, stickToLeft:%s, startSticky:[%s, %s]=>[%s, %s]", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m) });
      e(bool, i, j, k, m);
      break;
    }
  }
  
  public void setAlpha(float paramFloat)
  {
    AppMethodBeat.i(106473);
    super.setAlpha(paramFloat);
    ad.m("MicroMsg.FloatBallView", "setAlpha:%s", new Object[] { Float.valueOf(paramFloat) });
    bAH();
    AppMethodBeat.o(106473);
  }
  
  public void setEnableClick(boolean paramBoolean)
  {
    AppMethodBeat.i(190675);
    ad.d("MicroMsg.FloatBallView", "alvinluo setEnableClick enable: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.mIO = paramBoolean;
    AppMethodBeat.o(190675);
  }
  
  public void setFloatBallAlpha(final float paramFloat)
  {
    AppMethodBeat.i(106460);
    com.tencent.mm.plugin.ball.b.b localb = this.mHV;
    if ((localb.byL()) || (localb.byM())) {}
    for (int i = 1; i != 0; i = 0)
    {
      ad.m("MicroMsg.FloatBallView", "setFloatBallAlpha later, alpha:%s", new Object[] { Float.valueOf(paramFloat) });
      localb = this.mHV;
      Runnable local2 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(106431);
          ad.i("MicroMsg.FloatBallView", "setFloatBallAlpha when animation ends, alpha:%s", new Object[] { Float.valueOf(paramFloat) });
          FloatBallView.a(FloatBallView.this, paramFloat);
          AppMethodBeat.o(106431);
        }
      };
      localb.mDp.add(local2);
      AppMethodBeat.o(106460);
      return;
    }
    ad.m("MicroMsg.FloatBallView", "setFloatBallAlpha right now, alpha:%s", new Object[] { Float.valueOf(paramFloat) });
    setFloatBallAlphaInternal(paramFloat);
    AppMethodBeat.o(106460);
  }
  
  public void setInnerView(View paramView)
  {
    AppMethodBeat.i(106471);
    if (paramView == this.mHW)
    {
      AppMethodBeat.o(106471);
      return;
    }
    this.mIb.removeAllViews();
    this.mHW = paramView;
    if (this.mHW != null)
    {
      paramView = new FrameLayout.LayoutParams(-1, -1);
      paramView.gravity = 17;
      this.mIb.addView(this.mHW, paramView);
    }
    AppMethodBeat.o(106471);
  }
  
  public void setNeedTranslateAnimation(boolean paramBoolean)
  {
    this.mFj = paramBoolean;
  }
  
  public void setVOIPView(View paramView)
  {
    AppMethodBeat.i(176993);
    if (paramView == this.mHX)
    {
      AppMethodBeat.o(176993);
      return;
    }
    if ((paramView.getParent() != null) && ((paramView.getParent() instanceof ViewGroup)))
    {
      ad.i("MicroMsg.FloatBallView", "setVOIPView remove from parent first");
      ((ViewGroup)paramView.getParent()).removeView(paramView);
    }
    this.mHZ.removeAllViews();
    this.mHX = paramView;
    if (this.mHX != null)
    {
      paramView = new FrameLayout.LayoutParams(-1, -1);
      paramView.gravity = 17;
      this.mHZ.addView(this.mHX, paramView);
    }
    AppMethodBeat.o(176993);
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(106472);
    super.setVisibility(paramInt);
    int i = (int)getAlpha();
    if (i == 0)
    {
      this.mIG = false;
      ad.m("MicroMsg.FloatBallView", "setVisibility:%s, alphaInt:%s, disableTouch", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      AppMethodBeat.o(106472);
      return;
    }
    if (i == 1)
    {
      this.mIG = true;
      ad.m("MicroMsg.FloatBallView", "setVisibility:%s, alphaInt:%s, enableTouch", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      bAH();
    }
    AppMethodBeat.o(106472);
  }
  
  public final boolean ut(int paramInt)
  {
    AppMethodBeat.i(106459);
    if (getCurrentStateWidth() / 2 + paramInt <= this.mII.x / 2)
    {
      AppMethodBeat.o(106459);
      return true;
    }
    AppMethodBeat.o(106459);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.view.FloatBallView
 * JD-Core Version:    0.7.0.1
 */