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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.s;
import com.tencent.mm.ui.aj;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArraySet;

public class FloatBallView
  extends FrameLayout
  implements com.tencent.mm.plugin.ball.c.e
{
  private static final int njA;
  private static final int njB;
  private static final int njC;
  private static final int njD;
  private static final int njE;
  private static final int njF;
  private static final int njG;
  private static final int njH;
  private static final int njI;
  private static final int njJ;
  private static final int njK;
  private static final int njL;
  private static final int njM;
  private static final int njN;
  private static final int njO;
  private static final int njP;
  private static final int njQ;
  private static final int njR;
  private static final int njS;
  private static final int njT;
  private static final int njU;
  private static final int njV;
  private static final int njj;
  private static final int njk;
  private static final int njl;
  private static final int njm;
  private static final int njn;
  private static final int njo;
  private static final int njp;
  private static final int njq;
  private static final int njr;
  private static final int njs;
  private static final int njt;
  private static final int nju;
  private static final int njv;
  private static final int njw;
  private static final int njx;
  private static final int njy;
  private static final int njz;
  public Set<com.tencent.mm.plugin.ball.d.b> cqb;
  private int gud;
  private View jPT;
  private long mxx;
  private boolean neD;
  public boolean nho;
  private int njW;
  private int njX;
  private Vibrator njY;
  private ValueAnimator njZ;
  public int njh;
  private int nji;
  private Drawable nkA;
  private Drawable nkB;
  private Drawable nkC;
  private Drawable nkD;
  private BallInfo nkE;
  private BallInfo nkF;
  private String nkG;
  private List<BallInfo> nkH;
  private LayoutTransition nkI;
  private boolean nkJ;
  private boolean nkK;
  private Point nkL;
  private PointF nkM;
  private Point nkN;
  private float nkO;
  private int nkP;
  private boolean nkQ;
  private boolean nkR;
  private boolean nkS;
  private boolean nkT;
  private boolean nkU;
  private int nkV;
  private boolean nkW;
  private Handler nkX;
  private Runnable nkY;
  private boolean nkZ;
  public com.tencent.mm.plugin.ball.b.b nka;
  private View nkb;
  private View nkc;
  private LinearLayout nkd;
  public FrameLayout nke;
  private FrameLayout nkf;
  private FrameLayout nkg;
  private FrameLayout nkh;
  private CircleAnimateView nki;
  private CircleAnimateView nkj;
  private CircleAnimateView nkk;
  private CircleAnimateView nkl;
  private Drawable nkm;
  private Drawable nkn;
  private Drawable nko;
  private Drawable nkp;
  private Drawable nkq;
  private Drawable nkr;
  private Drawable nks;
  private Drawable nkt;
  private Drawable nku;
  private Drawable nkv;
  private Drawable nkw;
  private Drawable nkx;
  private Drawable nky;
  private Drawable nkz;
  private boolean nla;
  private boolean nlb;
  private int nlc;
  private WindowManager windowManager;
  
  static
  {
    AppMethodBeat.i(106478);
    njj = com.tencent.mm.cc.a.av(ai.getContext(), 2131166306);
    njk = com.tencent.mm.cc.a.av(ai.getContext(), 2131166303);
    njl = com.tencent.mm.cc.a.av(ai.getContext(), 2131166305);
    njm = com.tencent.mm.cc.a.av(ai.getContext(), 2131166304);
    njn = com.tencent.mm.cc.a.av(ai.getContext(), 2131166325);
    njo = com.tencent.mm.cc.a.av(ai.getContext(), 2131166324);
    njp = com.tencent.mm.cc.a.av(ai.getContext(), 2131166337);
    njq = com.tencent.mm.cc.a.av(ai.getContext(), 2131166336);
    njr = com.tencent.mm.cc.a.av(ai.getContext(), 2131166333);
    njs = com.tencent.mm.cc.a.av(ai.getContext(), 2131166332);
    njt = com.tencent.mm.cc.a.av(ai.getContext(), 2131166345);
    nju = com.tencent.mm.cc.a.av(ai.getContext(), 2131166344);
    njv = com.tencent.mm.cc.a.av(ai.getContext(), 2131166348);
    njw = com.tencent.mm.cc.a.av(ai.getContext(), 2131166346);
    njx = com.tencent.mm.cc.a.av(ai.getContext(), 2131166349);
    njy = com.tencent.mm.cc.a.av(ai.getContext(), 2131166347);
    njz = com.tencent.mm.cc.a.av(ai.getContext(), 2131166339);
    njA = com.tencent.mm.cc.a.av(ai.getContext(), 2131166338);
    njB = com.tencent.mm.cc.a.av(ai.getContext(), 2131166342);
    njC = com.tencent.mm.cc.a.av(ai.getContext(), 2131166340);
    njD = com.tencent.mm.cc.a.av(ai.getContext(), 2131166343);
    njE = com.tencent.mm.cc.a.av(ai.getContext(), 2131166341);
    njF = com.tencent.mm.cc.a.av(ai.getContext(), 2131166356);
    njG = com.tencent.mm.cc.a.av(ai.getContext(), 2131166354);
    njH = com.tencent.mm.cc.a.av(ai.getContext(), 2131166357);
    njI = com.tencent.mm.cc.a.av(ai.getContext(), 2131166355);
    njJ = com.tencent.mm.cc.a.av(ai.getContext(), 2131166352);
    njK = com.tencent.mm.cc.a.av(ai.getContext(), 2131166350);
    njL = com.tencent.mm.cc.a.av(ai.getContext(), 2131166353);
    njM = com.tencent.mm.cc.a.av(ai.getContext(), 2131166351);
    njN = com.tencent.mm.cc.a.av(ai.getContext(), 2131166331);
    njO = com.tencent.mm.cc.a.av(ai.getContext(), 2131166307);
    njP = com.tencent.mm.cc.a.av(ai.getContext(), 2131166320);
    njQ = com.tencent.mm.cc.a.av(ai.getContext(), 2131166321);
    njR = com.tencent.mm.cc.a.av(ai.getContext(), 2131166318);
    njS = com.tencent.mm.cc.a.av(ai.getContext(), 2131166319);
    njT = com.tencent.mm.cc.a.av(ai.getContext(), 2131166309);
    njU = com.tencent.mm.cc.a.av(ai.getContext(), 2131166311);
    njV = com.tencent.mm.cc.a.av(ai.getContext(), 2131166310);
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
    this.njh = 0;
    this.nji = 0;
    this.cqb = new CopyOnWriteArraySet();
    this.nkM = new PointF();
    this.nkN = new Point();
    this.nkO = -1.0F;
    this.nkP = 0;
    this.nkQ = false;
    this.nho = false;
    this.nkR = true;
    this.nkS = false;
    this.nkT = false;
    this.nkU = false;
    this.nkV = 0;
    this.nkW = false;
    this.neD = false;
    this.nkX = new Handler(Looper.getMainLooper());
    this.nkY = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106430);
        FloatBallView.a(FloatBallView.this);
        FloatBallView.b(FloatBallView.this);
        Iterator localIterator = FloatBallView.this.cqb.iterator();
        while (localIterator.hasNext()) {
          ((com.tencent.mm.plugin.ball.d.b)localIterator.next()).bFX();
        }
        AppMethodBeat.o(106430);
      }
    };
    this.nkZ = false;
    this.nla = false;
    this.nlb = false;
    this.nlc = 0;
    View.inflate(paramContext, 2131494557, this);
    this.nkm = com.tencent.mm.cc.a.l(paramContext, 2131232399);
    this.nkn = com.tencent.mm.cc.a.l(paramContext, 2131232401);
    this.nko = com.tencent.mm.cc.a.l(paramContext, 2131232403);
    this.nkp = com.tencent.mm.cc.a.l(paramContext, 2131232400);
    this.nkq = com.tencent.mm.cc.a.l(paramContext, 2131232402);
    this.nkr = com.tencent.mm.cc.a.l(paramContext, 2131232404);
    this.nks = com.tencent.mm.cc.a.l(paramContext, 2131232393);
    this.nkt = com.tencent.mm.cc.a.l(paramContext, 2131232395);
    this.nku = com.tencent.mm.cc.a.l(paramContext, 2131232397);
    this.nkv = com.tencent.mm.cc.a.l(paramContext, 2131232394);
    this.nkw = com.tencent.mm.cc.a.l(paramContext, 2131232396);
    this.nkx = com.tencent.mm.cc.a.l(paramContext, 2131232398);
    this.nky = com.tencent.mm.cc.a.l(paramContext, 2131232415);
    this.nkz = com.tencent.mm.cc.a.l(paramContext, 2131232416);
    this.nkA = com.tencent.mm.cc.a.l(paramContext, 2131232417);
    this.nkB = com.tencent.mm.cc.a.l(paramContext, 2131232415);
    this.nkC = com.tencent.mm.cc.a.l(paramContext, 2131232416);
    this.nkD = com.tencent.mm.cc.a.l(paramContext, 2131232417);
    this.nkd = ((LinearLayout)findViewById(2131297110));
    this.nkg = ((FrameLayout)findViewById(2131297109));
    this.nke = ((FrameLayout)findViewById(2131306552));
    this.nkf = ((FrameLayout)findViewById(2131303096));
    this.jPT = findViewById(2131299156);
    this.nkh = ((FrameLayout)findViewById(2131297111));
    this.nki = ((CircleAnimateView)findViewById(2131305994));
    this.nkj = ((CircleAnimateView)findViewById(2131297430));
    this.nkk = ((CircleAnimateView)findViewById(2131305769));
    this.nkl = ((CircleAnimateView)findViewById(2131307194));
    this.nka = new com.tencent.mm.plugin.ball.b.b(this);
    this.njY = ((Vibrator)paramContext.getSystemService("vibrator"));
    this.windowManager = ((WindowManager)paramContext.getSystemService("window"));
    this.njW = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.nkL = aj.cl(paramContext);
    this.njX = ViewConfiguration.getLongPressTimeout();
    this.nkI = new LayoutTransition();
    this.nkd.setLayoutTransition(this.nkI);
    this.gud = getResources().getConfiguration().orientation;
    AppMethodBeat.o(106438);
  }
  
  private int C(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(176983);
    this.nkh.setVisibility(0);
    boolean bool1 = xQ(this.njh);
    boolean bool2 = xP(this.njh);
    boolean bool3 = xO(this.njh);
    boolean bool4 = xN(this.njh);
    boolean bool5 = xH(this.njh);
    boolean bool6 = xK(this.njh);
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
      if ((xR(this.njh)) || (!xJ(this.njh))) {
        break label364;
      }
      k = 1;
      if ((!bool4) && (k == 0)) {
        break label370;
      }
      i2 = njR;
      if ((paramBoolean2) || (bool5) || (bool6)) {
        break label385;
      }
      if ((!bool4) && (!bool2) && (!bool1) && (k == 0)) {
        break label378;
      }
      i = njR;
      m = i;
      j = i;
      i = m;
      if ((!bool4) && (k == 0)) {
        break label473;
      }
      this.nki.setVisibility(0);
      this.nkj.setVisibility(8);
      this.nkk.setVisibility(8);
      this.nkl.setVisibility(8);
      m = 0;
      k = m;
      if (!xR(this.njh))
      {
        k = m;
        if (xJ(this.njh)) {
          k = getAppBrandVoipBallInfoIndex();
        }
      }
      a(this.nki, k);
      localLayoutParams1 = (FrameLayout.LayoutParams)this.nki.getLayoutParams();
      localLayoutParams1.setMargins(j, i2, i, i2);
      localLayoutParams1.gravity = i1;
      this.nki.setLayoutParams(localLayoutParams1);
    }
    label364:
    label370:
    label378:
    while ((!bool3) && (!bool2) && (!bool1))
    {
      localLayoutParams1 = (FrameLayout.LayoutParams)this.nkh.getLayoutParams();
      localLayoutParams1.gravity = (i1 | 0x10);
      this.nkh.setLayoutParams(localLayoutParams1);
      if ((!bool2) && (!bool1)) {
        break label959;
      }
      k = njN;
      AppMethodBeat.o(176983);
      return k * 2 + j + i;
      i1 = 8388613;
      break;
      k = 0;
      break label100;
      i2 = njP;
      break label115;
      i = njS;
      break label153;
      if (paramBoolean1)
      {
        if ((bool5) && (!bool6))
        {
          j = njP;
          if (!bool5) {
            break label424;
          }
        }
        for (i = njP;; i = njR)
        {
          break;
          j = njQ;
          break label404;
        }
      }
      if (bool5)
      {
        j = njP;
        if ((!bool5) || (bool6)) {
          break label466;
        }
      }
      for (i = njP;; i = njQ)
      {
        break;
        j = njR;
        break label441;
      }
    }
    label385:
    label404:
    label424:
    label441:
    label466:
    label473:
    this.nki.setVisibility(0);
    this.nkj.setVisibility(0);
    a(this.nki, 0);
    a(this.nkj, 1);
    int n;
    int i3;
    if (bool2)
    {
      this.nkk.setVisibility(0);
      this.nkl.setVisibility(8);
      a(this.nkk, 2);
      if (paramBoolean1)
      {
        m = j + njN;
        n = 0;
        k = i;
        i3 = j;
        label575:
        localLayoutParams1 = (FrameLayout.LayoutParams)this.nkk.getLayoutParams();
        localLayoutParams1.setMargins(i3, 0, n, 0);
        localLayoutParams1.gravity = (i1 | 0x10);
        this.nkk.setLayoutParams(localLayoutParams1);
        n = m;
        m = k;
      }
    }
    for (;;)
    {
      localLayoutParams1 = (FrameLayout.LayoutParams)this.nki.getLayoutParams();
      localLayoutParams1.setMargins(n, i2, m, 0);
      localLayoutParams1.gravity = i1;
      this.nki.setLayoutParams(localLayoutParams1);
      FrameLayout.LayoutParams localLayoutParams2 = (FrameLayout.LayoutParams)this.nkj.getLayoutParams();
      k = njN;
      localLayoutParams2.setMargins(n, localLayoutParams1.topMargin + k, m, i2);
      localLayoutParams2.gravity = i1;
      this.nkj.setLayoutParams(localLayoutParams2);
      break;
      i3 = 0;
      k = njN;
      n = i;
      k += i;
      m = j;
      break label575;
      if (bool1)
      {
        this.nkk.setVisibility(0);
        this.nkl.setVisibility(0);
        a(this.nkk, 2);
        a(this.nkl, 3);
        if (paramBoolean1)
        {
          k = njN;
          n = 0;
          m = i;
          k += j;
        }
        for (i3 = j;; i3 = 0)
        {
          localLayoutParams1 = (FrameLayout.LayoutParams)this.nkk.getLayoutParams();
          localLayoutParams1.setMargins(i3, i2, n, 0);
          localLayoutParams1.gravity = i1;
          this.nkk.setLayoutParams(localLayoutParams1);
          localLayoutParams2 = (FrameLayout.LayoutParams)this.nkl.getLayoutParams();
          int i4 = njN;
          localLayoutParams2.setMargins(i3, localLayoutParams1.topMargin + i4, n, 0);
          localLayoutParams2.gravity = i1;
          this.nkl.setLayoutParams(localLayoutParams2);
          n = k;
          break;
          k = njN;
          n = i;
          m = k + i;
          k = j;
        }
      }
      this.nkl.setVisibility(8);
      this.nkk.setVisibility(8);
      m = i;
      n = j;
    }
    label959:
    int k = njN;
    AppMethodBeat.o(176983);
    return k + j + i;
  }
  
  private boolean G(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(106453);
    if ((Math.abs(paramMotionEvent.getRawX() - this.nkM.x) > this.njW) || (Math.abs(paramMotionEvent.getRawY() - this.nkM.y) > this.njW))
    {
      AppMethodBeat.o(106453);
      return true;
    }
    AppMethodBeat.o(106453);
    return false;
  }
  
  private int H(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(106454);
    int i = (int)Math.max(Math.min(this.nkN.x + paramMotionEvent.getRawX() - this.nkM.x, this.nkL.x), 0.0F);
    AppMethodBeat.o(106454);
    return i;
  }
  
  private void H(int paramInt, long paramLong)
  {
    AppMethodBeat.i(176984);
    if (paramInt == 0)
    {
      a(this.nki, paramLong);
      AppMethodBeat.o(176984);
      return;
    }
    if (paramInt == 1)
    {
      a(this.nkj, paramLong);
      AppMethodBeat.o(176984);
      return;
    }
    if (paramInt == 2)
    {
      a(this.nkk, paramLong);
      AppMethodBeat.o(176984);
      return;
    }
    if (paramInt == 3) {
      a(this.nkl, paramLong);
    }
    AppMethodBeat.o(176984);
  }
  
  private int I(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(106455);
    int i = (int)Math.max(Math.min(this.nkN.y + paramMotionEvent.getRawY() - this.nkM.y, this.nkL.y), 0.0F);
    AppMethodBeat.o(106455);
    return i;
  }
  
  private void O(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(106475);
    Iterator localIterator = this.cqb.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.plugin.ball.d.b)localIterator.next()).N(paramMotionEvent);
    }
    AppMethodBeat.o(106475);
  }
  
  private void Q(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.nkO = (paramInt / this.nkL.y);
    }
    this.nkP = paramInt;
  }
  
  private void a(CircleAnimateView paramCircleAnimateView, int paramInt)
  {
    AppMethodBeat.i(176986);
    if ((d.h(this.nkH)) && (this.nkH.size() > paramInt))
    {
      BallInfo localBallInfo = (BallInfo)this.nkH.get(paramInt);
      paramInt = d.xx(localBallInfo.state);
      if (-1 != paramInt)
      {
        com.tencent.mm.svg.a.a locala = new com.tencent.mm.svg.a.a();
        if ((!s.aB(ai.getContext(), paramInt)) && (locala.i(getResources(), paramInt))) {
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
    if ((this.nla == paramBoolean1) && (this.nlb == paramBoolean2) && (this.nkZ == paramBoolean3) && (this.nlc == paramInt))
    {
      AppMethodBeat.o(176989);
      return;
    }
    ac.i("MicroMsg.FloatBallView", "updateFloatBallBackground, isSettled:%s, isDockLeft:%s, isManual:%s, state:%s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3), Integer.valueOf(paramInt) });
    this.nlc = paramInt;
    this.nkZ = paramBoolean3;
    this.nla = paramBoolean1;
    this.nlb = paramBoolean2;
    boolean bool1 = xK(paramInt);
    boolean bool2 = xT(paramInt);
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        if (paramBoolean3)
        {
          if (bool1)
          {
            this.nkd.setBackground(this.nkB);
            AppMethodBeat.o(176989);
            return;
          }
          if (bool2)
          {
            this.nkd.setBackground(this.nkv);
            AppMethodBeat.o(176989);
            return;
          }
          this.nkd.setBackground(this.nkp);
          AppMethodBeat.o(176989);
          return;
        }
        if (bool1)
        {
          this.nkd.setBackground(this.nky);
          AppMethodBeat.o(176989);
          return;
        }
        if (bool2)
        {
          this.nkd.setBackground(this.nks);
          AppMethodBeat.o(176989);
          return;
        }
        this.nkd.setBackground(this.nkm);
        AppMethodBeat.o(176989);
        return;
      }
      if (paramBoolean3)
      {
        if (bool1)
        {
          this.nkd.setBackground(this.nkC);
          AppMethodBeat.o(176989);
          return;
        }
        if (bool2)
        {
          this.nkd.setBackground(this.nkw);
          AppMethodBeat.o(176989);
          return;
        }
        this.nkd.setBackground(this.nkq);
        AppMethodBeat.o(176989);
        return;
      }
      if (bool1)
      {
        this.nkd.setBackground(this.nkz);
        AppMethodBeat.o(176989);
        return;
      }
      if (bool2)
      {
        this.nkd.setBackground(this.nkt);
        AppMethodBeat.o(176989);
        return;
      }
      this.nkd.setBackground(this.nkn);
      AppMethodBeat.o(176989);
      return;
    }
    if (paramBoolean3)
    {
      if (bool1)
      {
        this.nkd.setBackground(this.nkD);
        AppMethodBeat.o(176989);
        return;
      }
      if (bool2)
      {
        this.nkd.setBackground(this.nkx);
        AppMethodBeat.o(176989);
        return;
      }
      this.nkd.setBackground(this.nkr);
      AppMethodBeat.o(176989);
      return;
    }
    if (bool1)
    {
      this.nkd.setBackground(this.nkA);
      AppMethodBeat.o(176989);
      return;
    }
    if (bool2)
    {
      this.nkd.setBackground(this.nku);
      AppMethodBeat.o(176989);
      return;
    }
    this.nkd.setBackground(this.nko);
    AppMethodBeat.o(176989);
  }
  
  private void bHA()
  {
    AppMethodBeat.i(208041);
    ac.i("MicroMsg.FloatBallView", "alvinluo showByTranslation");
    setNeedTranslateAnimation(false);
    if (getVisibility() == 0)
    {
      ac.i("MicroMsg.FloatBallView", "showByTranslation float ball already show");
      AppMethodBeat.o(208041);
      return;
    }
    if (this.nka != null)
    {
      boolean bool = xE(((WindowManager.LayoutParams)getLayoutParams()).x);
      this.nka.P(getCurrentStateWidth(), bool);
    }
    AppMethodBeat.o(208041);
  }
  
  private void bHC()
  {
    AppMethodBeat.i(106468);
    int j;
    int i;
    if (xR(this.njh)) {
      if (yb(this.njh))
      {
        j = njt;
        i = nju;
      }
    }
    for (;;)
    {
      WindowManager.LayoutParams localLayoutParams = (WindowManager.LayoutParams)getLayoutParams();
      int k = com.tencent.mm.plugin.ball.f.e.nhT;
      int m = com.tencent.mm.plugin.ball.f.e.nhR;
      int n = com.tencent.mm.plugin.ball.f.e.nhS;
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
          ac.i("MicroMsg.FloatBallView", "updateFloatBallViewSize, width:%s, height:%s", new Object[] { Integer.valueOf(localLayoutParams.width), Integer.valueOf(localLayoutParams.height) });
          Iterator localIterator = this.cqb.iterator();
          while (localIterator.hasNext()) {
            ((com.tencent.mm.plugin.ball.d.b)localIterator.next()).a(localLayoutParams.x, localLayoutParams.y, localLayoutParams.height, this.nkT, this.nkK);
          }
          if (yc(this.njh))
          {
            j = njz;
            i = njA;
            break;
          }
          if ((xL(this.njh)) && (xH(this.njh)) && (xP(this.njh)))
          {
            j = njx;
            i = njy;
            break;
          }
          if ((xM(this.njh)) && (xH(this.njh)) && (xP(this.njh)))
          {
            j = njD;
            i = njE;
            break;
          }
          if ((xL(this.njh)) && ((xH(this.njh)) || (xI(this.njh))))
          {
            j = njv;
            i = njw;
            break;
          }
          if ((xM(this.njh)) && ((xH(this.njh)) || (xI(this.njh))))
          {
            j = njB;
            i = njC;
            break;
          }
          if (xS(this.njh))
          {
            j = njj;
            i = njk;
            break;
          }
          if (xT(this.njh))
          {
            j = njT;
            i = njT;
            break;
          }
          if (xU(this.njh))
          {
            j = njU;
            i = njU;
            break;
          }
          if ((xV(this.njh)) || (xW(this.njh)))
          {
            j = njV;
            i = njU;
            break;
          }
          if ((xX(this.njh)) || (xY(this.njh)))
          {
            j = njl;
            i = njm;
            break;
          }
          if ((!xZ(this.njh)) && (!ya(this.njh))) {
            break label755;
          }
          j = njl + njN;
          i = njm;
          break;
          if (yb(this.njh))
          {
            j = njt;
            i = nju;
            break;
          }
          if (yc(this.njh))
          {
            j = njz;
            i = njA;
            break;
          }
          if ((xL(this.njh)) && (xJ(this.njh)))
          {
            j = njv;
            i = njw;
            break;
          }
          if ((xM(this.njh)) && (xJ(this.njh)))
          {
            j = njB;
            i = njC;
            break;
          }
          if (xL(this.njh))
          {
            j = njt;
            i = nju;
            break;
          }
          if (xM(this.njh))
          {
            j = njz;
            i = njA;
            break;
          }
          if (!xJ(this.njh)) {
            break label755;
          }
          j = njT;
          i = njT;
          break;
          localLayoutParams.width = 0;
          localLayoutParams.height = 0;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ac.printErrStackTrace("MicroMsg.FloatBallView", localException, "updateFloatBallViewSize exception", new Object[0]);
        }
        AppMethodBeat.o(106468);
        return;
      }
      label755:
      i = 0;
      j = 0;
    }
  }
  
  private void bHD()
  {
    AppMethodBeat.i(208042);
    if (((int)getAlpha() == 1) && (getVisibility() == 0))
    {
      int i = getResources().getConfiguration().orientation;
      if (i != this.gud)
      {
        ac.i("MicroMsg.FloatBallView", "alvinluo checkOrientationIfNeed currentOrientation: %d, lastOrientation: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(this.gud) });
        xC(i);
      }
    }
    AppMethodBeat.o(208042);
  }
  
  private void bHr()
  {
    AppMethodBeat.i(176977);
    if (xK(this.njh))
    {
      this.jPT.setVisibility(0);
      this.nke.setVisibility(0);
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.nke.getLayoutParams();
      int j;
      if ((xH(this.njh)) && (xP(this.njh)))
      {
        i = 1;
        if (!xL(this.njh)) {
          break label253;
        }
        if (!yb(this.njh)) {
          break label170;
        }
        if (i == 0) {
          break label156;
        }
        j = njH;
        label93:
        localLayoutParams.width = j;
        if (i == 0) {
          break label163;
        }
      }
      label156:
      label163:
      for (int i = njI;; i = njG)
      {
        localLayoutParams.height = i;
        i = njQ;
        j = njQ;
        localLayoutParams.setMargins(i, i, j, j);
        this.nke.setLayoutParams(localLayoutParams);
        this.nkf.setVisibility(8);
        AppMethodBeat.o(176977);
        return;
        i = 0;
        break;
        j = njF;
        break label93;
      }
      label170:
      if (i != 0)
      {
        j = njH;
        localLayoutParams.width = j;
        if (i == 0) {
          break label246;
        }
      }
      label246:
      for (i = njI;; i = njG)
      {
        localLayoutParams.height = i;
        i = njQ;
        j = njQ;
        localLayoutParams.setMargins(i, i, j, j);
        this.nke.setLayoutParams(localLayoutParams);
        this.nkf.setVisibility(0);
        bHs();
        AppMethodBeat.o(176977);
        return;
        j = njF;
        break;
      }
      label253:
      if (yc(this.njh))
      {
        if (i != 0)
        {
          j = njL;
          localLayoutParams.width = j;
          if (i == 0) {
            break label336;
          }
        }
        for (i = njM;; i = njK)
        {
          localLayoutParams.height = i;
          i = njQ;
          j = njQ;
          localLayoutParams.setMargins(i, i, j, j);
          this.nke.setLayoutParams(localLayoutParams);
          this.nkf.setVisibility(8);
          AppMethodBeat.o(176977);
          return;
          j = njJ;
          break;
        }
      }
      label336:
      if (i != 0)
      {
        j = njL;
        localLayoutParams.width = j;
        if (i == 0) {
          break label419;
        }
      }
      label419:
      for (i = njM;; i = njK)
      {
        localLayoutParams.height = i;
        i = njQ;
        j = njQ;
        localLayoutParams.setMargins(i, i, j, j);
        this.nke.setLayoutParams(localLayoutParams);
        this.nkf.setVisibility(0);
        bHs();
        AppMethodBeat.o(176977);
        return;
        j = njJ;
        break;
      }
    }
    this.jPT.setVisibility(8);
    this.nke.setVisibility(8);
    this.nkf.setVisibility(0);
    bHs();
    AppMethodBeat.o(176977);
  }
  
  private void bHs()
  {
    AppMethodBeat.i(176978);
    Object localObject = (LinearLayout.LayoutParams)this.nkf.getLayoutParams();
    if (xK(this.njh)) {}
    for (int i = 8388629;; i = 8388627)
    {
      ((LinearLayout.LayoutParams)localObject).gravity = i;
      this.nkf.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if ((!xH(this.njh)) || (!xI(this.njh))) {
        break;
      }
      bHv();
      AppMethodBeat.o(176978);
      return;
    }
    if ((yd(this.njh)) || (xS(this.njh)))
    {
      this.nkh.setVisibility(8);
      this.nkg.setVisibility(0);
      localObject = (FrameLayout.LayoutParams)this.nkg.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).gravity = 8388629;
      i = njQ;
      int j = njQ;
      ((FrameLayout.LayoutParams)localObject).setMargins(i, i, j, j);
      this.nkg.setLayoutParams((ViewGroup.LayoutParams)localObject);
      AppMethodBeat.o(176978);
      return;
    }
    if (xI(this.njh))
    {
      this.nkg.setVisibility(8);
      C(true, true);
    }
    AppMethodBeat.o(176978);
  }
  
  private void bHt()
  {
    AppMethodBeat.i(176979);
    LinearLayout.LayoutParams localLayoutParams;
    int i;
    int j;
    if (xK(this.njh))
    {
      this.jPT.setVisibility(0);
      this.nke.setVisibility(0);
      localLayoutParams = (LinearLayout.LayoutParams)this.nke.getLayoutParams();
      if ((xH(this.njh)) && (xP(this.njh)))
      {
        i = 1;
        if (!xL(this.njh)) {
          break label254;
        }
        if (!yb(this.njh)) {
          break label175;
        }
        if (i == 0) {
          break label161;
        }
        j = njH;
        label93:
        localLayoutParams.width = j;
        if (i == 0) {
          break label168;
        }
        i = njI;
        label106:
        localLayoutParams.height = i;
        i = njQ;
        j = njQ;
        localLayoutParams.setMargins(i, i, j, j);
        this.nke.setLayoutParams(localLayoutParams);
        this.nkf.setVisibility(8);
      }
    }
    for (;;)
    {
      bHx();
      AppMethodBeat.o(176979);
      return;
      i = 0;
      break;
      label161:
      j = njF;
      break label93;
      label168:
      i = njG;
      break label106;
      label175:
      if (i != 0)
      {
        j = njH;
        label183:
        localLayoutParams.width = j;
        if (i == 0) {
          break label247;
        }
      }
      label247:
      for (i = njI;; i = njG)
      {
        localLayoutParams.height = i;
        i = njQ;
        j = njQ;
        localLayoutParams.setMargins(i, i, j, j);
        this.nke.setLayoutParams(localLayoutParams);
        this.nkf.setVisibility(0);
        bHu();
        break;
        j = njF;
        break label183;
      }
      label254:
      if (yc(this.njh))
      {
        if (i != 0)
        {
          j = njL;
          localLayoutParams.width = j;
          if (i == 0) {
            break label333;
          }
        }
        for (i = njM;; i = njK)
        {
          localLayoutParams.height = i;
          i = njQ;
          j = njQ;
          localLayoutParams.setMargins(i, i, j, j);
          this.nke.setLayoutParams(localLayoutParams);
          this.nkf.setVisibility(8);
          break;
          j = njJ;
          break label272;
        }
      }
      label272:
      label333:
      if (i != 0)
      {
        j = njL;
        label348:
        localLayoutParams.width = j;
        if (i == 0) {
          break label412;
        }
      }
      label412:
      for (i = njM;; i = njK)
      {
        localLayoutParams.height = i;
        i = njQ;
        j = njQ;
        localLayoutParams.setMargins(i, i, j, j);
        this.nke.setLayoutParams(localLayoutParams);
        this.nkf.setVisibility(0);
        bHu();
        break;
        j = njJ;
        break label348;
      }
      this.jPT.setVisibility(8);
      this.nke.setVisibility(8);
      this.nkf.setVisibility(0);
      bHu();
    }
  }
  
  private void bHu()
  {
    AppMethodBeat.i(176980);
    Object localObject = (LinearLayout.LayoutParams)this.nkf.getLayoutParams();
    if (xK(this.njh)) {}
    for (int i = 8388627;; i = 8388629)
    {
      ((LinearLayout.LayoutParams)localObject).gravity = i;
      this.nkf.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if ((!xH(this.njh)) || (!xI(this.njh))) {
        break;
      }
      bHw();
      AppMethodBeat.o(176980);
      return;
    }
    if ((yd(this.njh)) || (xS(this.njh)))
    {
      this.nkh.setVisibility(8);
      this.nkg.setVisibility(0);
      localObject = (FrameLayout.LayoutParams)this.nkg.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).gravity = 8388629;
      i = njQ;
      int j = njQ;
      ((FrameLayout.LayoutParams)localObject).setMargins(i, i, j, j);
      this.nkg.setLayoutParams((ViewGroup.LayoutParams)localObject);
      AppMethodBeat.o(176980);
      return;
    }
    if (xI(this.njh))
    {
      this.nkg.setVisibility(8);
      C(false, true);
    }
    AppMethodBeat.o(176980);
  }
  
  private void bHv()
  {
    AppMethodBeat.i(176981);
    int i = C(true, true);
    this.nkg.setVisibility(0);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.nkg.getLayoutParams();
    localLayoutParams.gravity = 8388627;
    int j = njQ;
    localLayoutParams.setMargins(i, j, j, njQ);
    this.nkg.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(176981);
  }
  
  private void bHw()
  {
    AppMethodBeat.i(176982);
    int i = C(false, true);
    this.nkg.setVisibility(0);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.nkg.getLayoutParams();
    localLayoutParams.gravity = 8388629;
    int j = njQ;
    localLayoutParams.setMargins(j, j, i, njQ);
    this.nkg.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(176982);
  }
  
  private boolean bHx()
  {
    AppMethodBeat.i(106451);
    WindowManager.LayoutParams localLayoutParams = (WindowManager.LayoutParams)getLayoutParams();
    int i = localLayoutParams.x;
    int j = localLayoutParams.y;
    if (xD(i))
    {
      i = Math.max(Math.min(i, this.nkL.x), 0);
      j = Math.max(Math.min(j, this.nkL.y), 0);
      int k = xG(i);
      int m = xF(j);
      ac.i("MicroMsg.FloatBallView", "stickToScreenEdgeIfNeed, start:[%s, %s], target:[%s, %s]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m) });
      if ((i != k) || (j != m)) {
        e(k, m, true, false);
      }
      AppMethodBeat.o(106451);
      return true;
    }
    AppMethodBeat.o(106451);
    return false;
  }
  
  private void bHy()
  {
    AppMethodBeat.i(176990);
    int i = 0;
    while (i < this.nkH.size())
    {
      long l = ((BallInfo)this.nkH.get(i)).progress;
      if (l >= 0L) {
        H(i, l);
      }
      i += 1;
    }
    AppMethodBeat.o(176990);
  }
  
  private void bHz()
  {
    AppMethodBeat.i(208039);
    if (this.nho) {
      bHA();
    }
    AppMethodBeat.o(208039);
  }
  
  private void bZ(List<BallInfo> paramList)
  {
    AppMethodBeat.i(106443);
    this.nji = this.njh;
    this.njh = 0;
    if (AppForegroundDelegate.cHM.cqc) {
      this.njh |= 0x20;
    }
    List localList = d.bS(d.bQ(d.bR(paramList)));
    this.nkH = d.bN(localList);
    int i = d.xv(d.bW(localList));
    boolean bool3 = d.bO(d.bV(paramList));
    if (bool3) {
      this.njh |= 0x1;
    }
    boolean bool1;
    label136:
    boolean bool2;
    if (i == 1)
    {
      this.njh |= 0x2;
      this.nkE = d.bT(paramList);
      if ((this.nkE == null) || (this.nkE.state != 4)) {
        break label384;
      }
      bool1 = true;
      if ((this.nkE == null) || (this.nkE.state != 8)) {
        break label389;
      }
      bool2 = true;
      label158:
      if (bool1) {
        this.njh |= 0x8;
      }
      if (bool2) {
        this.njh |= 0x10;
      }
      if ((this.nkE != null) && (this.nkE.tk != null)) {
        setVOIPView(this.nkE.tk);
      }
      this.nkF = d.bU(paramList);
      if (this.nkF != null)
      {
        if (this.nkF.state != 32) {
          break label395;
        }
        this.njh |= 0x100;
      }
    }
    for (;;)
    {
      ac.i("MicroMsg.FloatBallView", ">>> updateFloatBallViewLayoutState, state:[%s => %s], active:%s, passiveCnt:%d, video:%s, audio:%s <<<", new Object[] { Integer.valueOf(this.nji), Integer.valueOf(this.njh), Boolean.valueOf(bool3), Integer.valueOf(i), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      AppMethodBeat.o(106443);
      return;
      if (i == 2)
      {
        this.njh |= 0x4;
        break;
      }
      if (i == 3)
      {
        this.njh |= 0x40;
        break;
      }
      if (i != 4) {
        break;
      }
      this.njh |= 0x80;
      break;
      label384:
      bool1 = false;
      break label136;
      label389:
      bool2 = false;
      break label158;
      label395:
      if (this.nkF.state == 64) {
        this.njh |= 0x200;
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
      localStringBuilder.append(localBallInfo.key).append(localBallInfo.type).append(localBallInfo.drM).append(localBallInfo.lzV).append(localBallInfo.state).append(localBallInfo.nfB).append(localBallInfo.nfC).append(localBallInfo.progress);
      if ((localBallInfo.type == 9) && (localBallInfo.tk != null)) {
        localStringBuilder.append(localBallInfo.tk.hashCode());
      }
      localStringBuilder.append("|");
      i += 1;
    }
    paramList = ah.dg(localStringBuilder.toString());
    AppMethodBeat.o(106474);
    return paramList;
  }
  
  private void e(boolean paramBoolean, final int paramInt1, final int paramInt2, final int paramInt3, final int paramInt4)
  {
    AppMethodBeat.i(106464);
    ac.i("MicroMsg.FloatBallView", "start StickyAnimation, stickToLeft:%s, startPositionY: %d, targetPositionY: %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2), Integer.valueOf(paramInt4) });
    if ((this.njZ != null) && (this.njZ.isRunning()))
    {
      ac.i("MicroMsg.FloatBallView", "cancel StickyAnimation");
      this.njZ.cancel();
    }
    this.njZ = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.njZ.setInterpolator(new AccelerateDecelerateInterpolator());
    this.njZ.setDuration(100L);
    this.njZ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
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
    this.njZ.addListener(new AnimatorListenerAdapter()
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
    this.njZ.start();
    AppMethodBeat.o(106464);
  }
  
  private void f(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int i = 8388627;
    int j = 1;
    AppMethodBeat.i(106444);
    if ((this.nkT == paramBoolean1) && (this.nkU == paramBoolean2) && (this.nkS == paramBoolean3) && (this.nkV != 0) && (this.nkV == this.njh))
    {
      ac.d("MicroMsg.FloatBallView", "<<< updateFloatBallViewLayout, ignore layout %b %b;%b %b; %b %b; %d %d", new Object[] { Boolean.valueOf(this.nla), Boolean.valueOf(paramBoolean1), Boolean.valueOf(this.nkU), Boolean.valueOf(paramBoolean2), Boolean.valueOf(this.nkS), Boolean.valueOf(paramBoolean3), Integer.valueOf(this.nkV), Integer.valueOf(this.njh) });
      AppMethodBeat.o(106444);
      return;
    }
    ac.i("MicroMsg.FloatBallView", ">>> updateFloatBallViewLayout, isSettled:%s, isDockLeft:%s, isManual:%s, lastLayoutState:%s, currentLayoutState:%s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3), Integer.valueOf(this.nkV), Integer.valueOf(this.njh) });
    this.nkS = paramBoolean3;
    this.nkT = paramBoolean1;
    this.nkU = paramBoolean2;
    this.nkV = this.njh;
    bHC();
    int k = this.nkd.getPaddingLeft();
    int m = this.nkd.getPaddingRight();
    int n = this.nkd.getPaddingTop();
    int i1 = this.nkd.getPaddingBottom();
    if (xR(this.njh))
    {
      localObject = (FrameLayout.LayoutParams)this.nkd.getLayoutParams();
      if (paramBoolean2) {}
      for (;;)
      {
        ((FrameLayout.LayoutParams)localObject).gravity = i;
        this.nkd.setLayoutParams((ViewGroup.LayoutParams)localObject);
        if (!paramBoolean1) {
          break label700;
        }
        if (!paramBoolean2) {
          break;
        }
        this.nkd.setPadding(getExtendWidth(), n, m, i1);
        this.nkd.setLayoutTransition(this.nkI);
        bHr();
        AppMethodBeat.o(106444);
        return;
        i = 8388629;
      }
      this.nkd.setPadding(k, n, getExtendWidth(), i1);
      if (((xT(this.nji)) && (xX(this.njh))) || ((xU(this.nji)) && (xY(this.njh))) || ((xV(this.nji)) && (xZ(this.njh))) || ((xW(this.nji)) && (ya(this.njh))))
      {
        this.nkd.setLayoutTransition(null);
        bHt();
        AppMethodBeat.o(106444);
        return;
      }
      if (((xS(this.nji)) && (xX(this.njh))) || ((xS(this.nji)) && (xY(this.njh))) || ((xS(this.nji)) && (xZ(this.njh))) || ((xS(this.nji)) && (ya(this.njh))))
      {
        this.nkd.setLayoutTransition(null);
        bHt();
        AppMethodBeat.o(106444);
        return;
      }
      if (((xX(this.nji)) && (xS(this.njh))) || ((xY(this.nji)) && (xS(this.njh))) || ((xZ(this.nji)) && (xS(this.njh))) || ((ya(this.nji)) && (xS(this.njh))))
      {
        this.nkd.setLayoutTransition(null);
        bHt();
        AppMethodBeat.o(106444);
        return;
      }
      this.nkd.setLayoutTransition(this.nkI);
      bHt();
      AppMethodBeat.o(106444);
      return;
      label700:
      if ((xX(this.njh)) || (xY(this.njh)) || (xZ(this.njh)) || (ya(this.njh)))
      {
        if (paramBoolean2)
        {
          bHv();
          AppMethodBeat.o(106444);
          return;
        }
        bHw();
        AppMethodBeat.o(106444);
        return;
      }
      if ((xT(this.njh)) || (xU(this.njh)) || (xV(this.njh)) || (xW(this.njh)))
      {
        C(paramBoolean2, false);
        AppMethodBeat.o(106444);
        return;
      }
      if (xS(this.njh))
      {
        localObject = (FrameLayout.LayoutParams)this.nkg.getLayoutParams();
        ((FrameLayout.LayoutParams)localObject).gravity = 17;
        i = njQ;
        j = njQ;
        ((FrameLayout.LayoutParams)localObject).setMargins(i, i, j, j);
        this.nkg.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      AppMethodBeat.o(106444);
      return;
    }
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        this.nkd.setPadding(getExtendWidth(), n, m, i1);
        this.nkd.setLayoutTransition(this.nkI);
        localObject = (FrameLayout.LayoutParams)this.nkd.getLayoutParams();
        ((FrameLayout.LayoutParams)localObject).gravity = 8388627;
        this.nkd.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.jPT.setVisibility(8);
        if (xJ(this.njh))
        {
          this.nkf.setVisibility(0);
          this.nkg.setVisibility(8);
          this.nkh.setVisibility(0);
          localObject = (LinearLayout.LayoutParams)this.nkf.getLayoutParams();
          ((LinearLayout.LayoutParams)localObject).gravity = 8388627;
          this.nkf.setLayoutParams((ViewGroup.LayoutParams)localObject);
          C(true, true);
          this.nke.setVisibility(0);
          localObject = (LinearLayout.LayoutParams)this.nke.getLayoutParams();
          if ((!xH(this.njh)) || (!xP(this.njh))) {
            break label1171;
          }
          i = 1;
          label1076:
          if (!xL(this.njh)) {
            break label1193;
          }
          if (i == 0) {
            break label1177;
          }
          j = njH;
          label1096:
          ((LinearLayout.LayoutParams)localObject).width = j;
          if (i == 0) {
            break label1185;
          }
        }
        label1171:
        label1177:
        label1185:
        for (i = njI;; i = njG)
        {
          ((LinearLayout.LayoutParams)localObject).height = i;
          i = njQ;
          j = njQ;
          ((LinearLayout.LayoutParams)localObject).setMargins(i, i, j, j);
          this.nke.setLayoutParams((ViewGroup.LayoutParams)localObject);
          AppMethodBeat.o(106444);
          return;
          this.nkf.setVisibility(8);
          break;
          i = 0;
          break label1076;
          j = njF;
          break label1096;
        }
        label1193:
        if (xM(this.njh))
        {
          if (i != 0)
          {
            j = njL;
            ((LinearLayout.LayoutParams)localObject).width = j;
            if (i == 0) {
              break label1284;
            }
          }
          for (i = njM;; i = njK)
          {
            ((LinearLayout.LayoutParams)localObject).height = i;
            i = njQ;
            j = njQ;
            ((LinearLayout.LayoutParams)localObject).setMargins(i, i, j, j);
            this.nke.setLayoutParams((ViewGroup.LayoutParams)localObject);
            AppMethodBeat.o(106444);
            return;
            j = njJ;
            break;
          }
        }
        label1284:
        this.nke.setVisibility(8);
        AppMethodBeat.o(106444);
        return;
      }
      this.nkd.setPadding(k, n, getExtendWidth(), i1);
      this.nkd.setLayoutTransition(this.nkI);
      localObject = (FrameLayout.LayoutParams)this.nkd.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).gravity = 8388629;
      this.nkd.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jPT.setVisibility(8);
      if (xJ(this.njh))
      {
        this.nkf.setVisibility(0);
        this.nkg.setVisibility(8);
        this.nkh.setVisibility(0);
        localObject = (LinearLayout.LayoutParams)this.nkf.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject).gravity = 8388629;
        this.nkf.setLayoutParams((ViewGroup.LayoutParams)localObject);
        C(false, true);
        bHx();
        this.nke.setVisibility(0);
        localObject = (LinearLayout.LayoutParams)this.nke.getLayoutParams();
        if ((!xH(this.njh)) || (!xP(this.njh))) {
          break label1589;
        }
        i = j;
        label1494:
        if (!xL(this.njh)) {
          break label1611;
        }
        if (i == 0) {
          break label1595;
        }
        j = njH;
        label1514:
        ((LinearLayout.LayoutParams)localObject).width = j;
        if (i == 0) {
          break label1603;
        }
      }
      label1589:
      label1595:
      label1603:
      for (i = njI;; i = njG)
      {
        ((LinearLayout.LayoutParams)localObject).height = i;
        i = njQ;
        j = njQ;
        ((LinearLayout.LayoutParams)localObject).setMargins(i, i, j, j);
        this.nke.setLayoutParams((ViewGroup.LayoutParams)localObject);
        AppMethodBeat.o(106444);
        return;
        this.nkf.setVisibility(8);
        break;
        i = 0;
        break label1494;
        j = njF;
        break label1514;
      }
      label1611:
      if (xM(this.njh))
      {
        if (i != 0)
        {
          j = njL;
          ((LinearLayout.LayoutParams)localObject).width = j;
          if (i == 0) {
            break label1702;
          }
        }
        for (i = njM;; i = njK)
        {
          ((LinearLayout.LayoutParams)localObject).height = i;
          i = njQ;
          j = njQ;
          ((LinearLayout.LayoutParams)localObject).setMargins(i, i, j, j);
          this.nke.setLayoutParams((ViewGroup.LayoutParams)localObject);
          AppMethodBeat.o(106444);
          return;
          j = njJ;
          break;
        }
      }
      label1702:
      this.nke.setVisibility(8);
      AppMethodBeat.o(106444);
      return;
    }
    Object localObject = (FrameLayout.LayoutParams)this.nkd.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject).gravity = 17;
    this.nkd.setLayoutParams((ViewGroup.LayoutParams)localObject);
    AppMethodBeat.o(106444);
  }
  
  private int getAppBrandVoipBallInfoIndex()
  {
    AppMethodBeat.i(208038);
    if (d.h(this.nkH))
    {
      int i = 0;
      while (i < this.nkH.size())
      {
        BallInfo localBallInfo = (BallInfo)this.nkH.get(i);
        if ((localBallInfo != null) && (localBallInfo.type == 17))
        {
          AppMethodBeat.o(208038);
          return i;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(208038);
    return 0;
  }
  
  private int getCurrentStateHeight()
  {
    AppMethodBeat.i(176991);
    int i = getHeight();
    if (yb(this.njh)) {
      i = nju;
    }
    for (;;)
    {
      int j = com.tencent.mm.plugin.ball.f.e.nhR;
      int k = com.tencent.mm.plugin.ball.f.e.nhS;
      AppMethodBeat.o(176991);
      return i + j + k;
      if (yc(this.njh)) {
        i = njA;
      } else if ((xL(this.njh)) && ((xH(this.njh)) || (xI(this.njh)))) {
        i = njw;
      } else if ((xM(this.njh)) && ((xH(this.njh)) || (xI(this.njh)))) {
        i = njC;
      } else if (xS(this.njh)) {
        i = njk;
      } else if (xT(this.njh)) {
        i = njo;
      } else if (xU(this.njh)) {
        i = njq;
      } else if ((xV(this.njh)) || (xW(this.njh))) {
        i = njs;
      } else if ((xX(this.njh)) || (xY(this.njh)) || (xZ(this.njh)) || (ya(this.njh))) {
        i = njm;
      }
    }
  }
  
  private int getExtendWidth()
  {
    AppMethodBeat.i(106469);
    if (!this.nkQ)
    {
      AppMethodBeat.o(106469);
      return 0;
    }
    if (!d.ei(getContext()))
    {
      AppMethodBeat.o(106469);
      return 0;
    }
    int i = this.windowManager.getDefaultDisplay().getRotation();
    if (((this.nkK) && (i == 1)) || ((!this.nkK) && (i == 3)))
    {
      i = d.aF(getContext());
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
    if (!this.nkK) {
      i = this.nkL.x - getCurrentStateWidth();
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
      ac.i("MicroMsg.FloatBallView", "setFloatBallAlphaInternal, GONE");
      setVisibility(8);
      AppMethodBeat.o(106461);
      return;
    }
    ac.i("MicroMsg.FloatBallView", "setFloatBallAlphaInternal, VISIBLE, alpha:%s", new Object[] { Float.valueOf(paramFloat) });
    setVisibility(0);
    AppMethodBeat.o(106461);
  }
  
  private void xC(int paramInt)
  {
    AppMethodBeat.i(208037);
    Point localPoint1 = this.nkL;
    this.nkL = aj.cl(getContext());
    Point localPoint2 = this.nkL;
    Object localObject;
    int i;
    int j;
    int k;
    if (localPoint1 != null)
    {
      localObject = localPoint1;
      ac.i("MicroMsg.FloatBallView", "processOrientationChanged, screenResolution: %s, lastResolution: %s", new Object[] { localPoint2, localObject });
      if ((this.gud != paramInt) || ((localPoint1 != null) && ((localPoint1.x != this.nkL.x) || (localPoint1.y != this.nkL.y))))
      {
        this.gud = paramInt;
        this.nkQ = true;
        localObject = (WindowManager.LayoutParams)getLayoutParams();
        paramInt = ((WindowManager.LayoutParams)localObject).x;
        i = (int)(this.nkL.y * this.nkO);
        paramInt = Math.max(Math.min(paramInt, this.nkL.x), 0);
        i = Math.max(Math.min(i, this.nkL.y), 0);
        j = getTargetPositionXWhenOrientationChanged();
        k = xF(i);
        if (j != 0) {
          break label294;
        }
      }
    }
    label294:
    for (boolean bool = true;; bool = false)
    {
      ac.i("MicroMsg.FloatBallView", "processOrientationChanged, layoutParams.x: %s, layoutParams.y: %s, stickToLeft:%s, startSticky:[%s, %s]=>[%s, %s]", new Object[] { Integer.valueOf(((WindowManager.LayoutParams)localObject).x), Integer.valueOf(((WindowManager.LayoutParams)localObject).y), Boolean.valueOf(bool), Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
      e(bool, paramInt, i, j, k);
      AppMethodBeat.o(208037);
      return;
      localObject = "null";
      break;
    }
  }
  
  private boolean xD(int paramInt)
  {
    AppMethodBeat.i(176987);
    if (getCurrentStateWidth() + paramInt != this.nkL.x)
    {
      AppMethodBeat.o(176987);
      return true;
    }
    AppMethodBeat.o(176987);
    return false;
  }
  
  private static int xF(int paramInt)
  {
    int i;
    if (paramInt < com.tencent.mm.plugin.ball.f.e.nhY) {
      i = com.tencent.mm.plugin.ball.f.e.nhY;
    }
    do
    {
      return i;
      i = paramInt;
    } while (paramInt <= com.tencent.mm.plugin.ball.f.e.nhZ);
    return com.tencent.mm.plugin.ball.f.e.nhZ;
  }
  
  private int xG(int paramInt)
  {
    AppMethodBeat.i(106465);
    int i = 0;
    if (!xE(paramInt)) {
      i = this.nkL.x - getCurrentStateWidth();
    }
    AppMethodBeat.o(106465);
    return i;
  }
  
  private static boolean xH(int paramInt)
  {
    return (paramInt & 0x1) != 0;
  }
  
  private static boolean xI(int paramInt)
  {
    AppMethodBeat.i(176994);
    if ((xN(paramInt)) || (xO(paramInt)) || (xP(paramInt)) || (xQ(paramInt)))
    {
      AppMethodBeat.o(176994);
      return true;
    }
    AppMethodBeat.o(176994);
    return false;
  }
  
  public static boolean xJ(int paramInt)
  {
    return ((paramInt & 0x100) != 0) || ((paramInt & 0x200) != 0);
  }
  
  private static boolean xK(int paramInt)
  {
    AppMethodBeat.i(176995);
    if ((xL(paramInt)) || (xM(paramInt)))
    {
      AppMethodBeat.o(176995);
      return true;
    }
    AppMethodBeat.o(176995);
    return false;
  }
  
  private static boolean xL(int paramInt)
  {
    return (paramInt & 0x8) != 0;
  }
  
  private static boolean xM(int paramInt)
  {
    return (paramInt & 0x10) != 0;
  }
  
  private static boolean xN(int paramInt)
  {
    return (paramInt & 0x2) != 0;
  }
  
  private static boolean xO(int paramInt)
  {
    return (paramInt & 0x4) != 0;
  }
  
  private static boolean xP(int paramInt)
  {
    return (paramInt & 0x40) != 0;
  }
  
  private static boolean xQ(int paramInt)
  {
    return (paramInt & 0x80) != 0;
  }
  
  private static boolean xR(int paramInt)
  {
    return (paramInt & 0x20) != 0;
  }
  
  private static boolean xS(int paramInt)
  {
    AppMethodBeat.i(176996);
    if ((xH(paramInt)) && (!xK(paramInt)) && (!xI(paramInt)))
    {
      AppMethodBeat.o(176996);
      return true;
    }
    AppMethodBeat.o(176996);
    return false;
  }
  
  private static boolean xT(int paramInt)
  {
    AppMethodBeat.i(176997);
    if ((xN(paramInt)) && (!xK(paramInt)) && (!xH(paramInt)))
    {
      AppMethodBeat.o(176997);
      return true;
    }
    AppMethodBeat.o(176997);
    return false;
  }
  
  private static boolean xU(int paramInt)
  {
    AppMethodBeat.i(176998);
    if ((xO(paramInt)) && (!xK(paramInt)) && (!xH(paramInt)))
    {
      AppMethodBeat.o(176998);
      return true;
    }
    AppMethodBeat.o(176998);
    return false;
  }
  
  private static boolean xV(int paramInt)
  {
    AppMethodBeat.i(176999);
    if ((xP(paramInt)) && (!xK(paramInt)) && (!xH(paramInt)))
    {
      AppMethodBeat.o(176999);
      return true;
    }
    AppMethodBeat.o(176999);
    return false;
  }
  
  private static boolean xW(int paramInt)
  {
    AppMethodBeat.i(208043);
    if ((xQ(paramInt)) && (!xK(paramInt)) && (!xH(paramInt)))
    {
      AppMethodBeat.o(208043);
      return true;
    }
    AppMethodBeat.o(208043);
    return false;
  }
  
  private static boolean xX(int paramInt)
  {
    AppMethodBeat.i(177000);
    if ((xN(paramInt)) && (xH(paramInt)) && (!xK(paramInt)))
    {
      AppMethodBeat.o(177000);
      return true;
    }
    AppMethodBeat.o(177000);
    return false;
  }
  
  private static boolean xY(int paramInt)
  {
    AppMethodBeat.i(177001);
    if ((xO(paramInt)) && (xH(paramInt)) && (!xK(paramInt)))
    {
      AppMethodBeat.o(177001);
      return true;
    }
    AppMethodBeat.o(177001);
    return false;
  }
  
  private static boolean xZ(int paramInt)
  {
    AppMethodBeat.i(177002);
    if ((xP(paramInt)) && (xH(paramInt)) && (!xK(paramInt)))
    {
      AppMethodBeat.o(177002);
      return true;
    }
    AppMethodBeat.o(177002);
    return false;
  }
  
  private static boolean ya(int paramInt)
  {
    AppMethodBeat.i(208044);
    if ((xQ(paramInt)) && (xH(paramInt)) && (!xK(paramInt)))
    {
      AppMethodBeat.o(208044);
      return true;
    }
    AppMethodBeat.o(208044);
    return false;
  }
  
  private static boolean yb(int paramInt)
  {
    AppMethodBeat.i(177003);
    if ((xL(paramInt)) && (!xH(paramInt)) && (!xI(paramInt)))
    {
      AppMethodBeat.o(177003);
      return true;
    }
    AppMethodBeat.o(177003);
    return false;
  }
  
  private static boolean yc(int paramInt)
  {
    AppMethodBeat.i(177004);
    if ((xM(paramInt)) && (!xH(paramInt)) && (!xI(paramInt)))
    {
      AppMethodBeat.o(177004);
      return true;
    }
    AppMethodBeat.o(177004);
    return false;
  }
  
  private static boolean yd(int paramInt)
  {
    AppMethodBeat.i(177005);
    if ((xH(paramInt)) && (xK(paramInt)) && (!xI(paramInt)))
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
    if (bs.lr(paramBallInfo, this.nkG))
    {
      ac.d("MicroMsg.FloatBallView", "<<< onFloatBallInfoChanged, ignore refresh");
      AppMethodBeat.o(106442);
      return;
    }
    ac.i("MicroMsg.FloatBallView", ">>> onFloatBallInfoChanged, ballInfoList:%s", new Object[] { paramList });
    this.nkG = paramBallInfo;
    bZ(paramList);
    bHy();
    boolean bool = xE(((WindowManager.LayoutParams)getLayoutParams()).x);
    f(true, bool, false);
    a(true, bool, false, this.njh);
    bHz();
    AppMethodBeat.o(106442);
  }
  
  public final void b(boolean paramBoolean, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(184624);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.du(paramBoolean);
    localb.bb(paramAnimatorListenerAdapter);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ball/view/FloatBallView", "com/tencent/mm/plugin/ball/view/FloatBallView", "hide", "(ZLandroid/animation/AnimatorListenerAdapter;)V", this, localb.aeE());
    if (getVisibility() == 8)
    {
      ac.i("MicroMsg.FloatBallView", "float ball already hide");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ball/view/FloatBallView", "com/tencent/mm/plugin/ball/view/FloatBallView", "hide", "(ZLandroid/animation/AnimatorListenerAdapter;)V");
      AppMethodBeat.o(184624);
      return;
    }
    if ((paramBoolean) && (this.nka != null))
    {
      ac.i("MicroMsg.FloatBallView", "hide with animation");
      this.nka.b(paramAnimatorListenerAdapter);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ball/view/FloatBallView", "com/tencent/mm/plugin/ball/view/FloatBallView", "hide", "(ZLandroid/animation/AnimatorListenerAdapter;)V");
      AppMethodBeat.o(184624);
      return;
      ac.i("MicroMsg.FloatBallView", "hide without animation");
      setVisibility(8);
    }
  }
  
  public final void bHB()
  {
    AppMethodBeat.i(184622);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.du(false);
    localb.bb(null);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ball/view/FloatBallView", "com/tencent/mm/plugin/ball/view/FloatBallView", "show", "(ZLandroid/animation/AnimatorListenerAdapter;)V", this, localb.aeE());
    c(false, false, null);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ball/view/FloatBallView", "com/tencent/mm/plugin/ball/view/FloatBallView", "show", "(ZLandroid/animation/AnimatorListenerAdapter;)V");
    AppMethodBeat.o(184622);
  }
  
  public final void c(boolean paramBoolean1, boolean paramBoolean2, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(184623);
    if ((getVisibility() == 0) && (paramBoolean2))
    {
      ac.i("MicroMsg.FloatBallView", "float ball already show");
      AppMethodBeat.o(184623);
      return;
    }
    if ((paramBoolean1) && (this.nka != null))
    {
      ac.i("MicroMsg.FloatBallView", "show with animation");
      this.nka.a(paramAnimatorListenerAdapter);
      AppMethodBeat.o(184623);
      return;
    }
    ac.i("MicroMsg.FloatBallView", "show without animation");
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
        ac.printErrStackTrace("MicroMsg.FloatBallView", localThrowable, "updateBallPosition fail", new Object[0]);
      }
    }
    AppMethodBeat.o(106456);
  }
  
  public final void f(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(106457);
    this.nkK = xE(paramInt1);
    a(paramBoolean1, this.nkK, paramBoolean2, this.njh);
    f(paramBoolean1, this.nkK, paramBoolean2);
    Q(paramInt2, paramBoolean1);
    ac.i("MicroMsg.FloatBallView", "notifyBallPositionChanged, x:%s, y:%s, isSettled:%s, isManual:%s, isDockLeft:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(this.nkK) });
    Iterator localIterator = this.cqb.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.plugin.ball.d.b)localIterator.next()).a(paramInt1, paramInt2, getCurrentStateHeight(), paramBoolean1, this.nkK);
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
    if (this.nkK)
    {
      if (xL(this.njh))
      {
        localObject = new Point(((WindowManager.LayoutParams)localObject).x, ((WindowManager.LayoutParams)localObject).y + com.tencent.mm.plugin.ball.f.e.nhR + njG);
        AppMethodBeat.o(106470);
        return localObject;
      }
      if (xM(this.njh))
      {
        localObject = new Point(((WindowManager.LayoutParams)localObject).x, ((WindowManager.LayoutParams)localObject).y + com.tencent.mm.plugin.ball.f.e.nhR + njK);
        AppMethodBeat.o(106470);
        return localObject;
      }
      localObject = new Point(((WindowManager.LayoutParams)localObject).x, ((WindowManager.LayoutParams)localObject).y + com.tencent.mm.plugin.ball.f.e.nhR);
      AppMethodBeat.o(106470);
      return localObject;
    }
    if (xL(this.njh))
    {
      localObject = new Point(((WindowManager.LayoutParams)localObject).x + com.tencent.mm.plugin.ball.f.e.nhT, ((WindowManager.LayoutParams)localObject).y + com.tencent.mm.plugin.ball.f.e.nhR + njG);
      AppMethodBeat.o(106470);
      return localObject;
    }
    if (xM(this.njh))
    {
      localObject = new Point(((WindowManager.LayoutParams)localObject).x + com.tencent.mm.plugin.ball.f.e.nhT, ((WindowManager.LayoutParams)localObject).y + com.tencent.mm.plugin.ball.f.e.nhR + njK);
      AppMethodBeat.o(106470);
      return localObject;
    }
    localObject = new Point(((WindowManager.LayoutParams)localObject).x + com.tencent.mm.plugin.ball.f.e.nhT, ((WindowManager.LayoutParams)localObject).y + com.tencent.mm.plugin.ball.f.e.nhR);
    AppMethodBeat.o(106470);
    return localObject;
  }
  
  public int getCurrentStateWidth()
  {
    AppMethodBeat.i(106467);
    int i = getWidth();
    int j;
    if ((!xR(this.njh)) && (xJ(this.njh)))
    {
      if (xL(this.njh)) {
        i = njv;
      }
      for (;;)
      {
        j = com.tencent.mm.plugin.ball.f.e.nhT;
        AppMethodBeat.o(106467);
        return i + j;
        if (xM(this.njh)) {
          i = njB;
        } else {
          i = njn;
        }
      }
    }
    if (yb(this.njh)) {
      i = njt;
    }
    for (;;)
    {
      j = com.tencent.mm.plugin.ball.f.e.nhT;
      AppMethodBeat.o(106467);
      return i + j;
      if (yc(this.njh)) {
        i = njz;
      } else if ((xL(this.njh)) && (xH(this.njh)) && (xP(this.njh))) {
        i = njx;
      } else if ((xM(this.njh)) && (xH(this.njh)) && (xP(this.njh))) {
        i = njD;
      } else if ((xL(this.njh)) && ((xH(this.njh)) || (xI(this.njh)))) {
        i = njv;
      } else if ((xM(this.njh)) && ((xH(this.njh)) || (xI(this.njh)))) {
        i = njB;
      } else if (xS(this.njh)) {
        i = njj;
      } else if (xT(this.njh)) {
        i = njn;
      } else if (xU(this.njh)) {
        i = njp;
      } else if ((xV(this.njh)) || (xW(this.njh))) {
        i = njr;
      } else if ((xX(this.njh)) || (xY(this.njh))) {
        i = njl;
      } else if ((xZ(this.njh)) || (ya(this.njh))) {
        i = njl + njN;
      }
    }
  }
  
  public float getPosYPercentOfScreen()
  {
    return this.nkO;
  }
  
  public int getPositionY()
  {
    return this.nkP;
  }
  
  public final void iJ(boolean paramBoolean)
  {
    AppMethodBeat.i(176992);
    ac.i("MicroMsg.FloatBallView", "markWechatInForeground, visibility:%s, inForeground:%s", new Object[] { Integer.valueOf(getVisibility()), Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
      this.njh |= 0x20;
    }
    for (;;)
    {
      f(this.nkT, this.nkU, this.nkS);
      AppMethodBeat.o(176992);
      return;
      this.njh &= 0xFFFFFFDF;
      if ((xK(this.njh)) || (xJ(this.njh)))
      {
        bHB();
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
    ac.i("MicroMsg.FloatBallView", "onConfigurationChanged, orientation:%d, lastOrientation: %d", new Object[] { Integer.valueOf(paramConfiguration.orientation), Integer.valueOf(this.gud) });
    xC(paramConfiguration.orientation);
    int i = paramConfiguration.orientation;
    paramConfiguration = this.cqb.iterator();
    while (paramConfiguration.hasNext()) {
      ((com.tencent.mm.plugin.ball.d.b)paramConfiguration.next()).nm(i);
    }
    AppMethodBeat.o(106441);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(106440);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ball/view/FloatBallView", "com/tencent/mm/plugin/ball/view/FloatBallView", "onDetachedFromWindow", "()V", this);
    super.onDetachedFromWindow();
    if (this.njZ != null)
    {
      this.njZ.cancel();
      this.njZ = null;
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
    if (!this.nkJ)
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
      this.nkW = false;
      this.nkM.x = paramMotionEvent.getRawX();
      this.nkM.y = paramMotionEvent.getRawY();
      paramMotionEvent = (WindowManager.LayoutParams)getLayoutParams();
      this.nkN.x = paramMotionEvent.x;
      this.nkN.y = paramMotionEvent.y;
      a(true, this.nkK, true, this.njh);
      if (this.nkQ) {
        f(true, this.nkK, true);
      }
      this.neD = false;
      if ((xR(this.njh)) && (!yb(this.njh)) && (!yc(this.njh)))
      {
        this.nkX.postDelayed(this.nkY, this.njX);
        continue;
        if (this.neD)
        {
          O(paramMotionEvent);
        }
        else
        {
          if ((!this.nkW) && (G(paramMotionEvent)))
          {
            this.nkX.removeCallbacks(this.nkY);
            this.nkW = true;
            i = this.nkN.x;
            i = this.nkN.y;
            localIterator = this.cqb.iterator();
            while (localIterator.hasNext()) {
              ((com.tencent.mm.plugin.ball.d.b)localIterator.next()).bFY();
            }
          }
          if (this.nkW)
          {
            e(H(paramMotionEvent), I(paramMotionEvent), false, true);
            continue;
            if (this.neD)
            {
              a(true, this.nkK, false, this.njh);
              if (this.nkQ) {
                f(true, this.nkK, false);
              }
              O(paramMotionEvent);
            }
            else
            {
              this.nkX.removeCallbacks(this.nkY);
              if ((this.nkW) || (G(paramMotionEvent))) {
                break;
              }
              a(true, this.nkK, false, this.njh);
              if (this.nkQ) {
                f(true, this.nkK, false);
              }
              e(this.nkN.x, this.nkN.y, true, false);
              if (this.nkR)
              {
                float f1 = this.nkM.x;
                float f2 = this.nkM.y;
                long l = System.currentTimeMillis();
                if (l > this.mxx + 800L)
                {
                  this.mxx = l;
                  if (d.r(this.nkc, (int)f1, (int)f2))
                  {
                    ac.i("MicroMsg.FloatBallView", "notifyBallClickedIfNeed, you clicked voip");
                    if ((this.nkE != null) && (g.ab(c.class) != null))
                    {
                      this.nkE.nfD.opType = 3;
                      ((c)g.ab(c.class)).m(this.nkE);
                    }
                    this.nkc.callOnClick();
                  }
                  else if ((yc(this.njh)) || (yb(this.njh)))
                  {
                    ac.i("MicroMsg.FloatBallView", "notifyBallClickedIfNeed, ignore click");
                  }
                  else if (xR(this.njh))
                  {
                    ac.i("MicroMsg.FloatBallView", "notifyBallClickedIfNeed, wechat in foreground");
                    paramMotionEvent = this.cqb.iterator();
                    while (paramMotionEvent.hasNext()) {
                      ((com.tencent.mm.plugin.ball.d.b)paramMotionEvent.next()).bFW();
                    }
                  }
                  else if ((this.nkF != null) && (g.ab(c.class) != null))
                  {
                    ac.i("MicroMsg.FloatBallView", "notifyBallClickedIfNeed, you clicked appbrand voip");
                    this.nkF.nfD.opType = 3;
                    ((c)g.ab(c.class)).m(this.nkF);
                  }
                }
                else
                {
                  ac.i("MicroMsg.FloatBallView", "notifyBallClickedIfNeed, you clicked too fast!");
                }
              }
            }
          }
        }
      }
    }
    a(false, this.nkK, false, this.njh);
    if (this.nkW)
    {
      this.nkW = false;
      localIterator = this.cqb.iterator();
      while (localIterator.hasNext()) {
        ((com.tencent.mm.plugin.ball.d.b)localIterator.next()).bFZ();
      }
    }
    int i = H(paramMotionEvent);
    int j = I(paramMotionEvent);
    int k = xG(i);
    int m = xF(j);
    if (k == 0) {}
    for (boolean bool = true;; bool = false)
    {
      ac.i("MicroMsg.FloatBallView", "onTouchEvent, stickToLeft:%s, startSticky:[%s, %s]=>[%s, %s]", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m) });
      e(bool, i, j, k, m);
      break;
    }
  }
  
  public void setAlpha(float paramFloat)
  {
    AppMethodBeat.i(106473);
    super.setAlpha(paramFloat);
    ac.m("MicroMsg.FloatBallView", "setAlpha:%s", new Object[] { Float.valueOf(paramFloat) });
    bHD();
    AppMethodBeat.o(106473);
  }
  
  public void setEnableClick(boolean paramBoolean)
  {
    AppMethodBeat.i(208040);
    ac.d("MicroMsg.FloatBallView", "alvinluo setEnableClick enable: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.nkR = paramBoolean;
    AppMethodBeat.o(208040);
  }
  
  public void setFloatBallAlpha(final float paramFloat)
  {
    AppMethodBeat.i(106460);
    com.tencent.mm.plugin.ball.b.b localb = this.nka;
    if ((localb.bFH()) || (localb.bFI())) {}
    for (int i = 1; i != 0; i = 0)
    {
      ac.m("MicroMsg.FloatBallView", "setFloatBallAlpha later, alpha:%s", new Object[] { Float.valueOf(paramFloat) });
      localb = this.nka;
      Runnable local2 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(106431);
          ac.i("MicroMsg.FloatBallView", "setFloatBallAlpha when animation ends, alpha:%s", new Object[] { Float.valueOf(paramFloat) });
          FloatBallView.a(FloatBallView.this, paramFloat);
          AppMethodBeat.o(106431);
        }
      };
      localb.nfv.add(local2);
      AppMethodBeat.o(106460);
      return;
    }
    ac.m("MicroMsg.FloatBallView", "setFloatBallAlpha right now, alpha:%s", new Object[] { Float.valueOf(paramFloat) });
    setFloatBallAlphaInternal(paramFloat);
    AppMethodBeat.o(106460);
  }
  
  public void setInnerView(View paramView)
  {
    AppMethodBeat.i(106471);
    if (paramView == this.nkb)
    {
      AppMethodBeat.o(106471);
      return;
    }
    this.nkg.removeAllViews();
    this.nkb = paramView;
    if (this.nkb != null)
    {
      paramView = new FrameLayout.LayoutParams(-1, -1);
      paramView.gravity = 17;
      this.nkg.addView(this.nkb, paramView);
    }
    AppMethodBeat.o(106471);
  }
  
  public void setNeedTranslateAnimation(boolean paramBoolean)
  {
    this.nho = paramBoolean;
  }
  
  public void setVOIPView(View paramView)
  {
    AppMethodBeat.i(176993);
    if (paramView == this.nkc)
    {
      AppMethodBeat.o(176993);
      return;
    }
    if ((paramView.getParent() != null) && ((paramView.getParent() instanceof ViewGroup)))
    {
      ac.i("MicroMsg.FloatBallView", "setVOIPView remove from parent first");
      ((ViewGroup)paramView.getParent()).removeView(paramView);
    }
    this.nke.removeAllViews();
    this.nkc = paramView;
    if (this.nkc != null)
    {
      paramView = new FrameLayout.LayoutParams(-1, -1);
      paramView.gravity = 17;
      this.nke.addView(this.nkc, paramView);
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
      this.nkJ = false;
      ac.m("MicroMsg.FloatBallView", "setVisibility:%s, alphaInt:%s, disableTouch", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      AppMethodBeat.o(106472);
      return;
    }
    if (i == 1)
    {
      this.nkJ = true;
      ac.m("MicroMsg.FloatBallView", "setVisibility:%s, alphaInt:%s, enableTouch", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      bHD();
    }
    AppMethodBeat.o(106472);
  }
  
  public final boolean xE(int paramInt)
  {
    AppMethodBeat.i(106459);
    if (getCurrentStateWidth() / 2 + paramInt <= this.nkL.x / 2)
    {
      AppMethodBeat.o(106459);
      return true;
    }
    AppMethodBeat.o(106459);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.view.FloatBallView
 * JD-Core Version:    0.7.0.1
 */