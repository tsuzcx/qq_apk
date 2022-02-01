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
import com.tencent.mm.plugin.ball.c.h;
import com.tencent.mm.plugin.ball.f.d;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.model.BallInfo.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.ui.al;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArraySet;

public class FloatBallView
  extends FrameLayout
  implements com.tencent.mm.plugin.ball.c.e
{
  private static final int nPA;
  private static final int nPB;
  private static final int nPC;
  private static final int nPD;
  private static final int nPE;
  private static final int nPF;
  private static final int nPG;
  public static final int nPH;
  private static final int nPI;
  private static final int nPJ;
  private static final int nPK;
  public static final int nPL;
  public static final int nPM;
  private static final int nPN;
  private static final int nPO;
  private static final int nPP;
  private static final int nPQ;
  private static final int nPR;
  private static final int nPS;
  private static final int nPT;
  private static final int nPU;
  private static final int nPV;
  private static final int nPW;
  public static final int nPX;
  private static final int nPj;
  private static final int nPk;
  private static final int nPl;
  private static final int nPm;
  private static final int nPn;
  private static final int nPo;
  private static final int nPp;
  private static final int nPq;
  private static final int nPr;
  private static final int nPs;
  private static final int nPt;
  private static final int nPu;
  private static final int nPv;
  private static final int nPw;
  private static final int nPx;
  private static final int nPy;
  private static final int nPz;
  public Set<h> cBA;
  private Handler cBv;
  private int cpv;
  private View knu;
  private boolean nKu;
  public boolean nNn;
  private int nPY;
  private int nPZ;
  public int nPg;
  private int nPh;
  private int nPi;
  private Drawable nQA;
  private Drawable nQB;
  private Drawable nQC;
  private Drawable nQD;
  private Drawable nQE;
  private Drawable nQF;
  private String nQG;
  private List<BallInfo> nQH;
  private LayoutTransition nQI;
  private boolean nQJ;
  public boolean nQK;
  private Point nQL;
  private PointF nQM;
  private Point nQN;
  private float nQO;
  private int nQP;
  private boolean nQQ;
  private boolean nQR;
  private BallInfo nQS;
  private BallInfo nQT;
  private Point nQU;
  private Point nQV;
  private int nQW;
  private boolean nQX;
  public int nQY;
  private boolean nQZ;
  private Vibrator nQa;
  private ValueAnimator nQb;
  public com.tencent.mm.plugin.ball.b.b nQc;
  private View nQd;
  private View nQe;
  private LinearLayout nQf;
  public FrameLayout nQg;
  private FrameLayout nQh;
  private FrameLayout nQi;
  private FrameLayout nQj;
  private CircleAnimateView nQk;
  private CircleAnimateView nQl;
  private CircleAnimateView nQm;
  private CircleAnimateView nQn;
  private Drawable nQo;
  private Drawable nQp;
  private Drawable nQq;
  private Drawable nQr;
  private Drawable nQs;
  private Drawable nQt;
  private Drawable nQu;
  private Drawable nQv;
  private Drawable nQw;
  private Drawable nQx;
  private Drawable nQy;
  private Drawable nQz;
  private boolean nRa;
  private boolean nRb;
  private int nRc;
  private boolean nRd;
  private Handler nRe;
  private Runnable nRf;
  private boolean nRg;
  private boolean nRh;
  private boolean nRi;
  private int nRj;
  private long ndi;
  private WindowManager windowManager;
  
  static
  {
    AppMethodBeat.i(106478);
    nPj = com.tencent.mm.cb.a.ay(ak.getContext(), 2131166306);
    nPk = com.tencent.mm.cb.a.ay(ak.getContext(), 2131166303);
    nPl = com.tencent.mm.cb.a.ay(ak.getContext(), 2131166305);
    nPm = com.tencent.mm.cb.a.ay(ak.getContext(), 2131166304);
    nPn = com.tencent.mm.cb.a.ay(ak.getContext(), 2131166325);
    nPo = com.tencent.mm.cb.a.ay(ak.getContext(), 2131166324);
    nPp = com.tencent.mm.cb.a.ay(ak.getContext(), 2131166337);
    nPq = com.tencent.mm.cb.a.ay(ak.getContext(), 2131166336);
    nPr = com.tencent.mm.cb.a.ay(ak.getContext(), 2131166333);
    nPs = com.tencent.mm.cb.a.ay(ak.getContext(), 2131166332);
    nPt = com.tencent.mm.cb.a.ay(ak.getContext(), 2131166345);
    nPu = com.tencent.mm.cb.a.ay(ak.getContext(), 2131166344);
    nPv = com.tencent.mm.cb.a.ay(ak.getContext(), 2131166348);
    nPw = com.tencent.mm.cb.a.ay(ak.getContext(), 2131166346);
    nPx = com.tencent.mm.cb.a.ay(ak.getContext(), 2131166349);
    nPy = com.tencent.mm.cb.a.ay(ak.getContext(), 2131166347);
    nPz = com.tencent.mm.cb.a.ay(ak.getContext(), 2131166339);
    nPA = com.tencent.mm.cb.a.ay(ak.getContext(), 2131166338);
    nPB = com.tencent.mm.cb.a.ay(ak.getContext(), 2131166342);
    nPC = com.tencent.mm.cb.a.ay(ak.getContext(), 2131166340);
    nPD = com.tencent.mm.cb.a.ay(ak.getContext(), 2131166343);
    nPE = com.tencent.mm.cb.a.ay(ak.getContext(), 2131166341);
    nPF = com.tencent.mm.cb.a.ay(ak.getContext(), 2131166356);
    nPG = com.tencent.mm.cb.a.ay(ak.getContext(), 2131166354);
    nPH = com.tencent.mm.cb.a.ay(ak.getContext(), 2131166357);
    nPI = com.tencent.mm.cb.a.ay(ak.getContext(), 2131166355);
    nPJ = com.tencent.mm.cb.a.ay(ak.getContext(), 2131166352);
    nPK = com.tencent.mm.cb.a.ay(ak.getContext(), 2131166350);
    nPL = com.tencent.mm.cb.a.ay(ak.getContext(), 2131166353);
    nPM = com.tencent.mm.cb.a.ay(ak.getContext(), 2131166351);
    nPN = com.tencent.mm.cb.a.ay(ak.getContext(), 2131166331);
    nPO = com.tencent.mm.cb.a.ay(ak.getContext(), 2131166307);
    nPP = com.tencent.mm.cb.a.ay(ak.getContext(), 2131166320);
    nPQ = com.tencent.mm.cb.a.ay(ak.getContext(), 2131166321);
    nPR = com.tencent.mm.cb.a.ay(ak.getContext(), 2131166318);
    nPS = com.tencent.mm.cb.a.ay(ak.getContext(), 2131166319);
    nPT = com.tencent.mm.cb.a.ay(ak.getContext(), 2131166309);
    nPU = com.tencent.mm.cb.a.ay(ak.getContext(), 2131166311);
    nPV = com.tencent.mm.cb.a.ay(ak.getContext(), 2131166310);
    nPW = com.tencent.mm.cb.a.ax(ak.getContext(), 2131167064);
    nPX = nPQ;
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
    this.nPg = 0;
    this.nPh = 0;
    this.nPi = 0;
    this.cBA = new CopyOnWriteArraySet();
    this.nQM = new PointF();
    this.nQN = new Point();
    this.nQO = -1.0F;
    this.nQP = 0;
    this.nQQ = false;
    this.nNn = false;
    this.nQR = true;
    this.nQU = null;
    this.nQV = new Point();
    this.nQW = 0;
    this.nQX = false;
    this.nQY = 16;
    this.cBv = new Handler(Looper.getMainLooper());
    this.nQZ = false;
    this.nRa = false;
    this.nRb = false;
    this.nRc = 0;
    this.nRd = false;
    this.nKu = false;
    this.nRe = new Handler(Looper.getMainLooper());
    this.nRf = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106430);
        FloatBallView.a(FloatBallView.this);
        FloatBallView.b(FloatBallView.this);
        Iterator localIterator = FloatBallView.this.cBA.iterator();
        while (localIterator.hasNext()) {
          ((h)localIterator.next()).bLf();
        }
        AppMethodBeat.o(106430);
      }
    };
    this.nRg = false;
    this.nRh = false;
    this.nRi = false;
    this.nRj = 0;
    View.inflate(paramContext, 2131494557, this);
    this.nQo = com.tencent.mm.cb.a.l(paramContext, 2131232399);
    this.nQp = com.tencent.mm.cb.a.l(paramContext, 2131232401);
    this.nQq = com.tencent.mm.cb.a.l(paramContext, 2131232403);
    this.nQr = com.tencent.mm.cb.a.l(paramContext, 2131232400);
    this.nQs = com.tencent.mm.cb.a.l(paramContext, 2131232402);
    this.nQt = com.tencent.mm.cb.a.l(paramContext, 2131232404);
    this.nQu = com.tencent.mm.cb.a.l(paramContext, 2131232393);
    this.nQv = com.tencent.mm.cb.a.l(paramContext, 2131232395);
    this.nQw = com.tencent.mm.cb.a.l(paramContext, 2131232397);
    this.nQx = com.tencent.mm.cb.a.l(paramContext, 2131232394);
    this.nQy = com.tencent.mm.cb.a.l(paramContext, 2131232396);
    this.nQz = com.tencent.mm.cb.a.l(paramContext, 2131232398);
    this.nQA = com.tencent.mm.cb.a.l(paramContext, 2131232415);
    this.nQB = com.tencent.mm.cb.a.l(paramContext, 2131232416);
    this.nQC = com.tencent.mm.cb.a.l(paramContext, 2131232417);
    this.nQD = com.tencent.mm.cb.a.l(paramContext, 2131232415);
    this.nQE = com.tencent.mm.cb.a.l(paramContext, 2131232416);
    this.nQF = com.tencent.mm.cb.a.l(paramContext, 2131232417);
    this.nQf = ((LinearLayout)findViewById(2131297110));
    this.nQi = ((FrameLayout)findViewById(2131297109));
    this.nQg = ((FrameLayout)findViewById(2131306552));
    this.nQh = ((FrameLayout)findViewById(2131303096));
    this.knu = findViewById(2131299156);
    this.nQj = ((FrameLayout)findViewById(2131297111));
    this.nQk = ((CircleAnimateView)findViewById(2131305994));
    this.nQl = ((CircleAnimateView)findViewById(2131297430));
    this.nQm = ((CircleAnimateView)findViewById(2131305769));
    this.nQn = ((CircleAnimateView)findViewById(2131307194));
    this.nQc = new com.tencent.mm.plugin.ball.b.b(this);
    this.nQa = ((Vibrator)paramContext.getSystemService("vibrator"));
    this.windowManager = ((WindowManager)paramContext.getSystemService("window"));
    this.nPY = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.nQL = al.ck(paramContext);
    this.nPZ = ViewConfiguration.getLongPressTimeout();
    this.nQI = new LayoutTransition();
    this.nQf.setLayoutTransition(this.nQI);
    this.cpv = getResources().getConfiguration().orientation;
    AppMethodBeat.o(106438);
  }
  
  private void C(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(209516);
    int j = this.nQf.getPaddingLeft();
    int k = this.nQf.getPaddingRight();
    int m = this.nQf.getPaddingTop();
    int n = this.nQf.getPaddingBottom();
    label466:
    Object localObject;
    if (yJ(this.nPg))
    {
      if (paramBoolean2) {}
      for (int i = this.nQY | 0x800003;; i = this.nQY | 0x800005)
      {
        R(i, true);
        if (!paramBoolean1) {
          break label466;
        }
        if (!paramBoolean2) {
          break;
        }
        this.nQf.setPadding(getExtendWidth(), m, k, n);
        this.nQf.setLayoutTransition(this.nQI);
        bMy();
        AppMethodBeat.o(209516);
        return;
      }
      this.nQf.setPadding(j, m, getExtendWidth(), n);
      if (((yL(this.nPh)) && (yP(this.nPg))) || ((yM(this.nPh)) && (yQ(this.nPg))) || ((yN(this.nPh)) && (yR(this.nPg))) || ((yO(this.nPh)) && (yS(this.nPg))))
      {
        this.nQf.setLayoutTransition(null);
        bMA();
        AppMethodBeat.o(209516);
        return;
      }
      if (((yK(this.nPh)) && (yP(this.nPg))) || ((yK(this.nPh)) && (yQ(this.nPg))) || ((yK(this.nPh)) && (yR(this.nPg))) || ((yK(this.nPh)) && (yS(this.nPg))))
      {
        this.nQf.setLayoutTransition(null);
        bMA();
        AppMethodBeat.o(209516);
        return;
      }
      if (((yP(this.nPh)) && (yK(this.nPg))) || ((yQ(this.nPh)) && (yK(this.nPg))) || ((yR(this.nPh)) && (yK(this.nPg))) || ((yS(this.nPh)) && (yK(this.nPg))))
      {
        this.nQf.setLayoutTransition(null);
        bMA();
        AppMethodBeat.o(209516);
        return;
      }
      this.nQf.setLayoutTransition(this.nQI);
      bMA();
      AppMethodBeat.o(209516);
      return;
      if ((yP(this.nPg)) || (yQ(this.nPg)) || (yR(this.nPg)) || (yS(this.nPg)))
      {
        if (paramBoolean2)
        {
          bMC();
          AppMethodBeat.o(209516);
          return;
        }
        bMD();
        AppMethodBeat.o(209516);
        return;
      }
      if ((yL(this.nPg)) || (yM(this.nPg)) || (yN(this.nPg)) || (yO(this.nPg)))
      {
        D(paramBoolean2, false);
        AppMethodBeat.o(209516);
        return;
      }
      if (yK(this.nPg))
      {
        localObject = (FrameLayout.LayoutParams)this.nQi.getLayoutParams();
        ((FrameLayout.LayoutParams)localObject).gravity = 17;
        i = nPQ;
        j = nPQ;
        ((FrameLayout.LayoutParams)localObject).setMargins(i, i, j, j);
        this.nQi.setLayoutParams((ViewGroup.LayoutParams)localObject);
        AppMethodBeat.o(209516);
      }
    }
    else
    {
      if (paramBoolean1)
      {
        if (paramBoolean2)
        {
          this.nQf.setPadding(getExtendWidth(), m, k, n);
          this.nQf.setLayoutTransition(this.nQI);
          R(this.nQY | 0x800003, true);
          this.knu.setVisibility(8);
          if (yz(this.nPg))
          {
            this.nQh.setVisibility(0);
            this.nQi.setVisibility(8);
            this.nQj.setVisibility(0);
            localObject = (LinearLayout.LayoutParams)this.nQh.getLayoutParams();
            ((LinearLayout.LayoutParams)localObject).gravity = 8388627;
            this.nQh.setLayoutParams((ViewGroup.LayoutParams)localObject);
            D(true, true);
          }
          for (;;)
          {
            this.nQg.setVisibility(0);
            paramBoolean1 = yw(this.nPg);
            if (!yB(this.nPg)) {
              break;
            }
            g(true, false, paramBoolean1);
            AppMethodBeat.o(209516);
            return;
            this.nQh.setVisibility(8);
          }
          if (yE(this.nPg))
          {
            g(false, true, paramBoolean1);
            AppMethodBeat.o(209516);
            return;
          }
          this.nQg.setVisibility(8);
          AppMethodBeat.o(209516);
          return;
        }
        this.nQf.setPadding(j, m, getExtendWidth(), n);
        this.nQf.setLayoutTransition(this.nQI);
        R(this.nQY | 0x800005, true);
        this.knu.setVisibility(8);
        if (yz(this.nPg))
        {
          this.nQh.setVisibility(0);
          this.nQi.setVisibility(8);
          this.nQj.setVisibility(0);
          localObject = (LinearLayout.LayoutParams)this.nQh.getLayoutParams();
          ((LinearLayout.LayoutParams)localObject).gravity = 8388629;
          this.nQh.setLayoutParams((ViewGroup.LayoutParams)localObject);
          D(false, true);
          bME();
        }
        for (;;)
        {
          this.nQg.setVisibility(0);
          paramBoolean1 = yw(this.nPg);
          if (!yB(this.nPg)) {
            break;
          }
          g(true, false, paramBoolean1);
          AppMethodBeat.o(209516);
          return;
          this.nQh.setVisibility(8);
        }
        if (yE(this.nPg))
        {
          g(false, true, paramBoolean1);
          AppMethodBeat.o(209516);
          return;
        }
        this.nQg.setVisibility(8);
        AppMethodBeat.o(209516);
        return;
      }
      R(this.nQY | 0x1, false);
    }
    AppMethodBeat.o(209516);
  }
  
  private boolean C(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(106453);
    if ((Math.abs(paramMotionEvent.getRawX() - this.nQM.x) > this.nPY) || (Math.abs(paramMotionEvent.getRawY() - this.nQM.y) > this.nPY))
    {
      AppMethodBeat.o(106453);
      return true;
    }
    AppMethodBeat.o(106453);
    return false;
  }
  
  private int D(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(106454);
    int i = (int)Math.max(Math.min(this.nQN.x + paramMotionEvent.getRawX() - this.nQM.x, this.nQL.x), 0.0F);
    AppMethodBeat.o(106454);
    return i;
  }
  
  private int D(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(176983);
    this.nQj.setVisibility(0);
    boolean bool1 = yI(this.nPg);
    boolean bool2 = yH(this.nPg);
    boolean bool3 = yG(this.nPg);
    boolean bool4 = yF(this.nPg);
    boolean bool5 = yx(this.nPg);
    boolean bool6 = yA(this.nPg);
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
      if ((yJ(this.nPg)) || (!yz(this.nPg))) {
        break label364;
      }
      k = 1;
      if ((!bool4) && (k == 0)) {
        break label370;
      }
      i2 = nPR;
      if ((paramBoolean2) || (bool5) || (bool6)) {
        break label385;
      }
      if ((!bool4) && (!bool2) && (!bool1) && (k == 0)) {
        break label378;
      }
      i = nPR;
      m = i;
      j = i;
      i = m;
      if ((!bool4) && (k == 0)) {
        break label473;
      }
      this.nQk.setVisibility(0);
      this.nQl.setVisibility(8);
      this.nQm.setVisibility(8);
      this.nQn.setVisibility(8);
      m = 0;
      k = m;
      if (!yJ(this.nPg))
      {
        k = m;
        if (yz(this.nPg)) {
          k = getAppBrandVoipBallInfoIndex();
        }
      }
      a(this.nQk, k);
      localLayoutParams1 = (FrameLayout.LayoutParams)this.nQk.getLayoutParams();
      localLayoutParams1.setMargins(j, i2, i, i2);
      localLayoutParams1.gravity = i1;
      this.nQk.setLayoutParams(localLayoutParams1);
    }
    label364:
    label370:
    label378:
    while ((!bool3) && (!bool2) && (!bool1))
    {
      localLayoutParams1 = (FrameLayout.LayoutParams)this.nQj.getLayoutParams();
      localLayoutParams1.gravity = (i1 | 0x10);
      this.nQj.setLayoutParams(localLayoutParams1);
      if ((!bool2) && (!bool1)) {
        break label959;
      }
      k = nPN;
      AppMethodBeat.o(176983);
      return k * 2 + j + i;
      i1 = 8388613;
      break;
      k = 0;
      break label100;
      i2 = nPP;
      break label115;
      i = nPS;
      break label153;
      if (paramBoolean1)
      {
        if ((bool5) && (!bool6))
        {
          j = nPP;
          if (!bool5) {
            break label424;
          }
        }
        for (i = nPP;; i = nPR)
        {
          break;
          j = nPQ;
          break label404;
        }
      }
      if (bool5)
      {
        j = nPP;
        if ((!bool5) || (bool6)) {
          break label466;
        }
      }
      for (i = nPP;; i = nPQ)
      {
        break;
        j = nPR;
        break label441;
      }
    }
    label385:
    label404:
    label424:
    label441:
    label466:
    label473:
    this.nQk.setVisibility(0);
    this.nQl.setVisibility(0);
    a(this.nQk, 0);
    a(this.nQl, 1);
    int n;
    int i3;
    if (bool2)
    {
      this.nQm.setVisibility(0);
      this.nQn.setVisibility(8);
      a(this.nQm, 2);
      if (paramBoolean1)
      {
        m = j + nPN;
        n = 0;
        k = i;
        i3 = j;
        label575:
        localLayoutParams1 = (FrameLayout.LayoutParams)this.nQm.getLayoutParams();
        localLayoutParams1.setMargins(i3, 0, n, 0);
        localLayoutParams1.gravity = (i1 | 0x10);
        this.nQm.setLayoutParams(localLayoutParams1);
        n = m;
        m = k;
      }
    }
    for (;;)
    {
      localLayoutParams1 = (FrameLayout.LayoutParams)this.nQk.getLayoutParams();
      localLayoutParams1.setMargins(n, i2, m, 0);
      localLayoutParams1.gravity = i1;
      this.nQk.setLayoutParams(localLayoutParams1);
      FrameLayout.LayoutParams localLayoutParams2 = (FrameLayout.LayoutParams)this.nQl.getLayoutParams();
      k = nPN;
      localLayoutParams2.setMargins(n, localLayoutParams1.topMargin + k, m, i2);
      localLayoutParams2.gravity = i1;
      this.nQl.setLayoutParams(localLayoutParams2);
      break;
      i3 = 0;
      k = nPN;
      n = i;
      k += i;
      m = j;
      break label575;
      if (bool1)
      {
        this.nQm.setVisibility(0);
        this.nQn.setVisibility(0);
        a(this.nQm, 2);
        a(this.nQn, 3);
        if (paramBoolean1)
        {
          k = nPN;
          n = 0;
          m = i;
          k += j;
        }
        for (i3 = j;; i3 = 0)
        {
          localLayoutParams1 = (FrameLayout.LayoutParams)this.nQm.getLayoutParams();
          localLayoutParams1.setMargins(i3, i2, n, 0);
          localLayoutParams1.gravity = i1;
          this.nQm.setLayoutParams(localLayoutParams1);
          localLayoutParams2 = (FrameLayout.LayoutParams)this.nQn.getLayoutParams();
          int i4 = nPN;
          localLayoutParams2.setMargins(i3, localLayoutParams1.topMargin + i4, n, 0);
          localLayoutParams2.gravity = i1;
          this.nQn.setLayoutParams(localLayoutParams2);
          n = k;
          break;
          k = nPN;
          n = i;
          m = k + i;
          k = j;
        }
      }
      this.nQn.setVisibility(8);
      this.nQm.setVisibility(8);
      m = i;
      n = j;
    }
    label959:
    int k = nPN;
    AppMethodBeat.o(176983);
    return k + j + i;
  }
  
  private int E(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(106455);
    int i = (int)Math.max(Math.min(this.nQN.y + paramMotionEvent.getRawY() - this.nQM.y, this.nQL.y), 0.0F);
    AppMethodBeat.o(106455);
    return i;
  }
  
  private void I(int paramInt, long paramLong)
  {
    AppMethodBeat.i(176984);
    if (paramInt == 0)
    {
      a(this.nQk, paramLong);
      AppMethodBeat.o(176984);
      return;
    }
    if (paramInt == 1)
    {
      a(this.nQl, paramLong);
      AppMethodBeat.o(176984);
      return;
    }
    if (paramInt == 2)
    {
      a(this.nQm, paramLong);
      AppMethodBeat.o(176984);
      return;
    }
    if (paramInt == 3) {
      a(this.nQn, paramLong);
    }
    AppMethodBeat.o(176984);
  }
  
  private void K(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(106475);
    Iterator localIterator = this.cBA.iterator();
    while (localIterator.hasNext()) {
      ((h)localIterator.next()).J(paramMotionEvent);
    }
    AppMethodBeat.o(106475);
  }
  
  private void S(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.nQO = (paramInt / this.nQL.y);
    }
    this.nQP = paramInt;
  }
  
  private void a(CircleAnimateView paramCircleAnimateView, int paramInt)
  {
    AppMethodBeat.i(176986);
    if ((d.h(this.nQH)) && (this.nQH.size() > paramInt))
    {
      BallInfo localBallInfo = (BallInfo)this.nQH.get(paramInt);
      paramInt = d.yg(localBallInfo.state);
      if (-1 != paramInt)
      {
        com.tencent.mm.svg.a.a locala = new com.tencent.mm.svg.a.a();
        if ((!u.aE(ak.getContext(), paramInt)) && (locala.i(getResources(), paramInt))) {
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
    if ((this.nRh == paramBoolean1) && (this.nRi == paramBoolean2) && (this.nRg == paramBoolean3) && (this.nRj == paramInt))
    {
      AppMethodBeat.o(176989);
      return;
    }
    ae.i("MicroMsg.FloatBallView", "updateFloatBallBackground, isSettled:%s, isDockLeft:%s, isManual:%s, state:%s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3), Integer.valueOf(paramInt) });
    this.nRj = paramInt;
    this.nRg = paramBoolean3;
    this.nRh = paramBoolean1;
    this.nRi = paramBoolean2;
    boolean bool1 = yA(paramInt);
    boolean bool2 = yL(paramInt);
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        if (paramBoolean3)
        {
          if (bool1)
          {
            this.nQf.setBackground(this.nQD);
            AppMethodBeat.o(176989);
            return;
          }
          if (bool2)
          {
            this.nQf.setBackground(this.nQx);
            AppMethodBeat.o(176989);
            return;
          }
          this.nQf.setBackground(this.nQr);
          AppMethodBeat.o(176989);
          return;
        }
        if (bool1)
        {
          this.nQf.setBackground(this.nQA);
          AppMethodBeat.o(176989);
          return;
        }
        if (bool2)
        {
          this.nQf.setBackground(this.nQu);
          AppMethodBeat.o(176989);
          return;
        }
        this.nQf.setBackground(this.nQo);
        AppMethodBeat.o(176989);
        return;
      }
      if (paramBoolean3)
      {
        if (bool1)
        {
          this.nQf.setBackground(this.nQE);
          AppMethodBeat.o(176989);
          return;
        }
        if (bool2)
        {
          this.nQf.setBackground(this.nQy);
          AppMethodBeat.o(176989);
          return;
        }
        this.nQf.setBackground(this.nQs);
        AppMethodBeat.o(176989);
        return;
      }
      if (bool1)
      {
        this.nQf.setBackground(this.nQB);
        AppMethodBeat.o(176989);
        return;
      }
      if (bool2)
      {
        this.nQf.setBackground(this.nQv);
        AppMethodBeat.o(176989);
        return;
      }
      this.nQf.setBackground(this.nQp);
      AppMethodBeat.o(176989);
      return;
    }
    if (paramBoolean3)
    {
      if (bool1)
      {
        this.nQf.setBackground(this.nQF);
        AppMethodBeat.o(176989);
        return;
      }
      if (bool2)
      {
        this.nQf.setBackground(this.nQz);
        AppMethodBeat.o(176989);
        return;
      }
      this.nQf.setBackground(this.nQt);
      AppMethodBeat.o(176989);
      return;
    }
    if (bool1)
    {
      this.nQf.setBackground(this.nQC);
      AppMethodBeat.o(176989);
      return;
    }
    if (bool2)
    {
      this.nQf.setBackground(this.nQw);
      AppMethodBeat.o(176989);
      return;
    }
    this.nQf.setBackground(this.nQq);
    AppMethodBeat.o(176989);
  }
  
  private void bMA()
  {
    AppMethodBeat.i(176979);
    int i;
    boolean bool;
    if (yA(this.nPg))
    {
      View localView = this.knu;
      if ((yx(this.nPg)) || (yy(this.nPg)))
      {
        i = 0;
        localView.setVisibility(i);
        this.nQg.setVisibility(0);
        bool = yw(this.nPg);
        if (!yB(this.nPg)) {
          break label148;
        }
        if (!yT(this.nPg)) {
          break label126;
        }
        this.knu.setVisibility(4);
        g(true, false, bool);
        this.nQh.setVisibility(8);
      }
    }
    for (;;)
    {
      bME();
      AppMethodBeat.o(176979);
      return;
      i = 4;
      break;
      label126:
      g(true, false, bool);
      this.nQh.setVisibility(0);
      bMB();
      continue;
      label148:
      if (yU(this.nPg))
      {
        this.knu.setVisibility(4);
        g(false, true, bool);
        this.nQh.setVisibility(8);
      }
      else
      {
        g(false, true, bool);
        this.nQh.setVisibility(0);
        bMB();
        continue;
        this.knu.setVisibility(8);
        this.nQg.setVisibility(8);
        this.nQh.setVisibility(0);
        bMB();
      }
    }
  }
  
  private void bMB()
  {
    AppMethodBeat.i(176980);
    Object localObject = (LinearLayout.LayoutParams)this.nQh.getLayoutParams();
    if (yA(this.nPg)) {}
    for (int i = 8388627;; i = 8388629)
    {
      ((LinearLayout.LayoutParams)localObject).gravity = i;
      this.nQh.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if ((!yx(this.nPg)) || (!yy(this.nPg))) {
        break;
      }
      bMD();
      AppMethodBeat.o(176980);
      return;
    }
    if ((yV(this.nPg)) || (yK(this.nPg)))
    {
      this.nQj.setVisibility(8);
      this.nQi.setVisibility(0);
      localObject = (FrameLayout.LayoutParams)this.nQi.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).gravity = 8388629;
      i = nPQ;
      int j = nPQ;
      ((FrameLayout.LayoutParams)localObject).setMargins(i, i, j, j);
      this.nQi.setLayoutParams((ViewGroup.LayoutParams)localObject);
      AppMethodBeat.o(176980);
      return;
    }
    if (yy(this.nPg))
    {
      this.nQi.setVisibility(8);
      D(false, true);
    }
    AppMethodBeat.o(176980);
  }
  
  private void bMC()
  {
    AppMethodBeat.i(176981);
    int i = D(true, true);
    this.nQi.setVisibility(0);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.nQi.getLayoutParams();
    localLayoutParams.gravity = 8388627;
    int j = nPQ;
    localLayoutParams.setMargins(i, j, j, nPQ);
    this.nQi.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(176981);
  }
  
  private void bMD()
  {
    AppMethodBeat.i(176982);
    int i = D(false, true);
    this.nQi.setVisibility(0);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.nQi.getLayoutParams();
    localLayoutParams.gravity = 8388629;
    int j = nPQ;
    localLayoutParams.setMargins(j, j, i, nPQ);
    this.nQi.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(176982);
  }
  
  private boolean bME()
  {
    AppMethodBeat.i(106451);
    WindowManager.LayoutParams localLayoutParams = (WindowManager.LayoutParams)getLayoutParams();
    int i = localLayoutParams.x;
    int j = localLayoutParams.y;
    if (ym(i))
    {
      i = Math.max(Math.min(i, this.nQL.x), 0);
      j = Math.max(Math.min(j, this.nQL.y), 0);
      int k = yp(i);
      int m = yo(j);
      ae.i("MicroMsg.FloatBallView", "stickToScreenEdgeIfNeed, start:[%s, %s], target:[%s, %s]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m) });
      if ((i != k) || (j != m)) {
        e(k, m, true, false);
      }
      AppMethodBeat.o(106451);
      return true;
    }
    AppMethodBeat.o(106451);
    return false;
  }
  
  private void bMF()
  {
    AppMethodBeat.i(176990);
    int i = 0;
    while (i < this.nQH.size())
    {
      long l = ((BallInfo)this.nQH.get(i)).progress;
      if (l >= 0L) {
        I(i, l);
      }
      i += 1;
    }
    AppMethodBeat.o(176990);
  }
  
  private void bMG()
  {
    AppMethodBeat.i(209521);
    if (this.nNn) {
      bMH();
    }
    AppMethodBeat.o(209521);
  }
  
  private void bMH()
  {
    AppMethodBeat.i(209523);
    ae.i("MicroMsg.FloatBallView", "alvinluo showByTranslation");
    setNeedTranslateAnimation(false);
    if (getVisibility() == 0)
    {
      ae.i("MicroMsg.FloatBallView", "showByTranslation float ball already show");
      AppMethodBeat.o(209523);
      return;
    }
    if (this.nQc != null)
    {
      boolean bool = yn(((WindowManager.LayoutParams)getLayoutParams()).x);
      this.nQc.Q(getCurrentStateWidth(), bool);
    }
    AppMethodBeat.o(209523);
  }
  
  private void bMJ()
  {
    AppMethodBeat.i(106468);
    int i;
    int k;
    int m;
    int j;
    if (yJ(this.nPg)) {
      if (yA(this.nPg))
      {
        i = yu(this.nPg);
        k = this.nQW * 2 + i;
        m = yv(this.nPg) + this.nQW * 2;
        if (!yx(this.nPg))
        {
          i = m;
          j = k;
          if (!yy(this.nPg)) {}
        }
        else
        {
          i = m + (nPO + nPQ * 2 + nPW);
          j = k;
        }
      }
    }
    for (;;)
    {
      int n = com.tencent.mm.plugin.ball.f.e.nNS;
      k = com.tencent.mm.plugin.ball.f.e.nNQ;
      m = com.tencent.mm.plugin.ball.f.e.nNR;
      if ((j != 0) && (i != 0))
      {
        int i1 = getExtendWidth();
        j = this.nQV.x + (j + (n + n) + i1);
        i = this.nQV.y + (i + (k + m));
      }
      for (;;)
      {
        eL(j, i);
        AppMethodBeat.o(106468);
        return;
        j = yq(this.nPg);
        i = yr(this.nPg);
        break;
        if (yA(this.nPg))
        {
          i = yu(this.nPg);
          j = this.nQW * 2 + i;
          i = yv(this.nPg) + this.nQW * 2;
          break;
        }
        if (!yz(this.nPg)) {
          break label276;
        }
        j = nPT;
        i = nPT;
        break;
        i = 0;
        j = 0;
      }
      label276:
      i = 0;
      j = 0;
    }
  }
  
  private void bMK()
  {
    AppMethodBeat.i(209528);
    if (((int)getAlpha() == 1) && (getVisibility() == 0))
    {
      int i = getResources().getConfiguration().orientation;
      if (i != this.cpv)
      {
        ae.i("MicroMsg.FloatBallView", "alvinluo checkOrientationIfNeed currentOrientation: %d, lastOrientation: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(this.cpv) });
        yl(i);
      }
    }
    AppMethodBeat.o(209528);
  }
  
  private void bML()
  {
    AppMethodBeat.i(209529);
    if (!this.nQX)
    {
      AppMethodBeat.o(209529);
      return;
    }
    try
    {
      WindowManager.LayoutParams localLayoutParams;
      int i;
      if ((this.nQV.x != 0) || (this.nQV.y != 0))
      {
        localLayoutParams = (WindowManager.LayoutParams)getLayoutParams();
        if (!this.nQK) {
          break label103;
        }
        i = 0;
      }
      for (;;)
      {
        int j = localLayoutParams.y;
        int k = this.nQV.y;
        bMM();
        this.nQY = 16;
        bMJ();
        e(i, j + k, true, false);
        AppMethodBeat.o(209529);
        return;
        label103:
        i = localLayoutParams.x;
        j = this.nQV.x;
        i += j;
      }
      return;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.FloatBallView", localException, "alvinluo resetFloatBallViewSizeAndPosition", new Object[0]);
      AppMethodBeat.o(209529);
    }
  }
  
  private void bMM()
  {
    AppMethodBeat.i(209530);
    ae.v("MicroMsg.FloatBallView", "alvinluo resetExtraSize");
    this.nQV.x = 0;
    this.nQV.y = 0;
    AppMethodBeat.o(209530);
  }
  
  private void bMy()
  {
    AppMethodBeat.i(176977);
    if (yA(this.nPg))
    {
      View localView = this.knu;
      if ((yx(this.nPg)) || (yy(this.nPg))) {}
      boolean bool;
      for (int i = 0;; i = 4)
      {
        localView.setVisibility(i);
        this.nQg.setVisibility(0);
        bool = yw(this.nPg);
        if (!yB(this.nPg)) {
          break label147;
        }
        if (!yT(this.nPg)) {
          break;
        }
        this.knu.setVisibility(4);
        g(true, false, bool);
        this.nQh.setVisibility(8);
        AppMethodBeat.o(176977);
        return;
      }
      g(true, false, bool);
      this.nQh.setVisibility(0);
      bMz();
      AppMethodBeat.o(176977);
      return;
      label147:
      if (yU(this.nPg))
      {
        this.knu.setVisibility(4);
        g(false, true, bool);
        this.nQh.setVisibility(8);
        AppMethodBeat.o(176977);
        return;
      }
      g(false, true, bool);
      this.nQh.setVisibility(0);
      bMz();
      AppMethodBeat.o(176977);
      return;
    }
    this.knu.setVisibility(8);
    this.nQg.setVisibility(8);
    this.nQh.setVisibility(0);
    bMz();
    AppMethodBeat.o(176977);
  }
  
  private void bMz()
  {
    AppMethodBeat.i(176978);
    Object localObject = (LinearLayout.LayoutParams)this.nQh.getLayoutParams();
    if (yA(this.nPg)) {}
    for (int i = 8388629;; i = 8388627)
    {
      ((LinearLayout.LayoutParams)localObject).gravity = i;
      this.nQh.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if ((!yx(this.nPg)) || (!yy(this.nPg))) {
        break;
      }
      bMC();
      AppMethodBeat.o(176978);
      return;
    }
    if ((yV(this.nPg)) || (yK(this.nPg)))
    {
      this.nQj.setVisibility(8);
      this.nQi.setVisibility(0);
      localObject = (FrameLayout.LayoutParams)this.nQi.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).gravity = 8388629;
      i = nPQ;
      int j = nPQ;
      ((FrameLayout.LayoutParams)localObject).setMargins(i, i, j, j);
      this.nQi.setLayoutParams((ViewGroup.LayoutParams)localObject);
      AppMethodBeat.o(176978);
      return;
    }
    if (yy(this.nPg))
    {
      this.nQi.setVisibility(8);
      D(true, true);
    }
    AppMethodBeat.o(176978);
  }
  
  private void cc(List<BallInfo> paramList)
  {
    AppMethodBeat.i(106443);
    this.nPh = this.nPg;
    this.nPg = 0;
    if (AppForegroundDelegate.cTA.cBB) {
      this.nPg |= 0x20;
    }
    List localList = d.bV(d.bT(d.bU(paramList)));
    this.nQH = d.bQ(localList);
    int i = d.ye(d.bZ(localList));
    boolean bool3 = d.bR(d.bY(paramList));
    if (bool3) {
      this.nPg |= 0x1;
    }
    boolean bool1;
    label154:
    boolean bool2;
    if (i == 1)
    {
      this.nPg |= 0x2;
      this.nPi = i;
      this.nQS = d.bW(paramList);
      if ((this.nQS == null) || ((this.nQS.state != 4) && (this.nQS.state != 512))) {
        break label444;
      }
      bool1 = true;
      if ((this.nQS == null) || ((this.nQS.state != 8) && (this.nQS.state != 1024))) {
        break label449;
      }
      bool2 = true;
      label189:
      if (bool1) {
        this.nPg |= 0x8;
      }
      if (bool2) {
        this.nPg |= 0x10;
      }
      if (this.nQS != null)
      {
        if (this.nQS.state != 512) {
          break label455;
        }
        this.nPg |= 0x400;
      }
      label252:
      if ((this.nQS != null) && (this.nQS.vd != null)) {
        setVOIPView(this.nQS);
      }
      this.nQT = d.bX(paramList);
      if (this.nQT != null)
      {
        if (this.nQT.state != 32) {
          break label483;
        }
        this.nPg |= 0x100;
      }
    }
    for (;;)
    {
      ae.i("MicroMsg.FloatBallView", ">>> updateFloatBallViewLayoutState, state:[%s => %s], active:%s, passiveCnt:%d, video:%s, audio:%s <<<", new Object[] { Integer.valueOf(this.nPh), Integer.valueOf(this.nPg), Boolean.valueOf(bool3), Integer.valueOf(i), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      AppMethodBeat.o(106443);
      return;
      if (i == 2)
      {
        this.nPg |= 0x4;
        break;
      }
      if (i == 3)
      {
        this.nPg |= 0x40;
        break;
      }
      if (i != 4) {
        break;
      }
      this.nPg |= 0x80;
      break;
      label444:
      bool1 = false;
      break label154;
      label449:
      bool2 = false;
      break label189;
      label455:
      if (this.nQS.state != 1024) {
        break label252;
      }
      this.nPg |= 0x800;
      break label252;
      label483:
      if (this.nQT.state == 64) {
        this.nPg |= 0x200;
      }
    }
  }
  
  private static String cd(List<BallInfo> paramList)
  {
    AppMethodBeat.i(106474);
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramList.size())
    {
      BallInfo localBallInfo = (BallInfo)paramList.get(i);
      localStringBuilder.append(localBallInfo.key).append(localBallInfo.type).append(localBallInfo.dEM).append(localBallInfo.mdM).append(localBallInfo.state).append(localBallInfo.nLu).append(localBallInfo.nLv).append(localBallInfo.progress);
      if ((localBallInfo.type == 9) && (localBallInfo.vd != null)) {
        localStringBuilder.append(localBallInfo.vd.hashCode());
      }
      localStringBuilder.append("|");
      i += 1;
    }
    paramList = aj.ej(localStringBuilder.toString());
    AppMethodBeat.o(106474);
    return paramList;
  }
  
  private void d(boolean paramBoolean, final int paramInt1, final int paramInt2, final int paramInt3, final int paramInt4)
  {
    AppMethodBeat.i(106464);
    ae.i("MicroMsg.FloatBallView", "start StickyAnimation, stickToLeft:%s, startPositionY: %d, targetPositionY: %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2), Integer.valueOf(paramInt4) });
    if ((this.nQb != null) && (this.nQb.isRunning()))
    {
      ae.i("MicroMsg.FloatBallView", "cancel StickyAnimation");
      this.nQb.cancel();
    }
    this.nQb = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.nQb.setInterpolator(new AccelerateDecelerateInterpolator());
    this.nQb.setDuration(100L);
    this.nQb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
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
    this.nQb.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(106433);
        super.onAnimationEnd(paramAnonymousAnimator);
        paramAnonymousAnimator = (WindowManager.LayoutParams)FloatBallView.this.getLayoutParams();
        FloatBallView.this.g(paramAnonymousAnimator.x, paramAnonymousAnimator.y, true, false);
        AppMethodBeat.o(106433);
      }
    });
    this.nQb.start();
    AppMethodBeat.o(106464);
  }
  
  private void eL(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(209526);
    WindowManager.LayoutParams localLayoutParams = (WindowManager.LayoutParams)getLayoutParams();
    if ((paramInt1 != 0) && (paramInt2 != 0))
    {
      localLayoutParams.width = paramInt1;
      localLayoutParams.height = paramInt2;
    }
    try
    {
      for (;;)
      {
        this.windowManager.updateViewLayout(this, localLayoutParams);
        ae.i("MicroMsg.FloatBallView", "updateFloatBallViewSize, width:%s, height:%s", new Object[] { Integer.valueOf(localLayoutParams.width), Integer.valueOf(localLayoutParams.height) });
        Iterator localIterator = this.cBA.iterator();
        while (localIterator.hasNext()) {
          ((h)localIterator.next()).a(localLayoutParams.x, localLayoutParams.y, localLayoutParams.height, this.nRa, this.nQK);
        }
        localLayoutParams.width = 0;
        localLayoutParams.height = 0;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.FloatBallView", localException, "updateFloatBallViewSize exception", new Object[0]);
      }
      AppMethodBeat.o(209526);
    }
  }
  
  private void f(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(209520);
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
        g(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
        AppMethodBeat.o(209520);
        return;
      }
      catch (Throwable localThrowable)
      {
        ae.printErrStackTrace("MicroMsg.FloatBallView", localThrowable, "updateBallPosition fail", new Object[0]);
      }
    }
    AppMethodBeat.o(209520);
  }
  
  private void f(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(209515);
    if ((this.nRa == paramBoolean1) && (this.nRb == paramBoolean2) && (this.nQZ == paramBoolean3) && (this.nRc != 0) && (this.nRc == this.nPg))
    {
      ae.d("MicroMsg.FloatBallView", "<<< updateFloatBallViewLayout, ignore layout %b %b;%b %b; %b %b; %d %d", new Object[] { Boolean.valueOf(this.nRh), Boolean.valueOf(paramBoolean1), Boolean.valueOf(this.nRb), Boolean.valueOf(paramBoolean2), Boolean.valueOf(this.nQZ), Boolean.valueOf(paramBoolean3), Integer.valueOf(this.nRc), Integer.valueOf(this.nPg) });
      AppMethodBeat.o(209515);
      return;
    }
    ae.i("MicroMsg.FloatBallView", ">>> updateFloatBallViewLayout, isSettled:%s, isDockLeft:%s, isManual:%s, lastLayoutState:%s, currentLayoutState:%s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3), Integer.valueOf(this.nRc), Integer.valueOf(this.nPg) });
    this.nQZ = paramBoolean3;
    this.nRa = paramBoolean1;
    this.nRb = paramBoolean2;
    this.nRc = this.nPg;
    bMJ();
    C(paramBoolean1, paramBoolean2);
    AppMethodBeat.o(209515);
  }
  
  private void g(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(209518);
    int i = h(paramBoolean1, paramBoolean2, paramBoolean3);
    int j = a(this.nPg, paramBoolean1, paramBoolean2, paramBoolean3);
    ae.v("MicroMsg.FloatBallView", "alvinluo updateVoipLayout width: %d, height: %d, margin: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(this.nQW) });
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.nQg.getLayoutParams();
    localLayoutParams.width = i;
    localLayoutParams.height = j;
    if (this.nQW > 0) {
      localLayoutParams.setMargins(this.nQW, this.nQW, this.nQW, this.nQW);
    }
    this.nQg.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(209518);
  }
  
  public static boolean g(Point paramPoint)
  {
    return (paramPoint != null) && (paramPoint.x > 0) && (paramPoint.y > 0);
  }
  
  private int getAppBrandVoipBallInfoIndex()
  {
    AppMethodBeat.i(209519);
    if (d.h(this.nQH))
    {
      int i = 0;
      while (i < this.nQH.size())
      {
        BallInfo localBallInfo = (BallInfo)this.nQH.get(i);
        if ((localBallInfo != null) && (localBallInfo.type == 17))
        {
          AppMethodBeat.o(209519);
          return i;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(209519);
    return 0;
  }
  
  private int getCurrentStateHeight()
  {
    AppMethodBeat.i(176991);
    int k = this.nPg;
    ae.v("MicroMsg.FloatBallView", "getStateHeight state: %d", new Object[] { Integer.valueOf(k) });
    int j;
    if (yA(k))
    {
      j = yv(k) + this.nQW * 2;
      if (!yx(k))
      {
        i = j;
        if (!yy(k)) {
          break label83;
        }
      }
    }
    for (int i = j + (nPO + nPQ * 2 + nPW);; i = yr(k))
    {
      label83:
      j = com.tencent.mm.plugin.ball.f.e.nNQ;
      k = com.tencent.mm.plugin.ball.f.e.nNR;
      AppMethodBeat.o(176991);
      return i + j + k;
    }
  }
  
  private int getExtendWidth()
  {
    AppMethodBeat.i(106469);
    if (!this.nQQ)
    {
      AppMethodBeat.o(106469);
      return 0;
    }
    if (!d.em(getContext()))
    {
      AppMethodBeat.o(106469);
      return 0;
    }
    int i = this.windowManager.getDefaultDisplay().getRotation();
    if (((this.nQK) && (i == 1)) || ((!this.nQK) && (i == 3)))
    {
      i = d.aG(getContext());
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
    if (!this.nQK) {
      i = this.nQL.x - getCurrentStateWidth();
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
      ae.i("MicroMsg.FloatBallView", "setFloatBallAlphaInternal, GONE");
      setVisibility(8);
      AppMethodBeat.o(106461);
      return;
    }
    ae.i("MicroMsg.FloatBallView", "setFloatBallAlphaInternal, VISIBLE, alpha:%s", new Object[] { Float.valueOf(paramFloat) });
    setVisibility(0);
    AppMethodBeat.o(106461);
  }
  
  private static boolean yA(int paramInt)
  {
    AppMethodBeat.i(176995);
    if ((yB(paramInt)) || (yE(paramInt)))
    {
      AppMethodBeat.o(176995);
      return true;
    }
    AppMethodBeat.o(176995);
    return false;
  }
  
  public static boolean yB(int paramInt)
  {
    return (paramInt & 0x8) != 0;
  }
  
  private static boolean yC(int paramInt)
  {
    return (paramInt & 0x400) != 0;
  }
  
  private static boolean yD(int paramInt)
  {
    return (paramInt & 0x800) != 0;
  }
  
  public static boolean yE(int paramInt)
  {
    return (paramInt & 0x10) != 0;
  }
  
  private static boolean yF(int paramInt)
  {
    return (paramInt & 0x2) != 0;
  }
  
  private static boolean yG(int paramInt)
  {
    return (paramInt & 0x4) != 0;
  }
  
  private static boolean yH(int paramInt)
  {
    return (paramInt & 0x40) != 0;
  }
  
  private static boolean yI(int paramInt)
  {
    return (paramInt & 0x80) != 0;
  }
  
  private static boolean yJ(int paramInt)
  {
    return (paramInt & 0x20) != 0;
  }
  
  private static boolean yK(int paramInt)
  {
    AppMethodBeat.i(176996);
    if ((yx(paramInt)) && (!yA(paramInt)) && (!yy(paramInt)))
    {
      AppMethodBeat.o(176996);
      return true;
    }
    AppMethodBeat.o(176996);
    return false;
  }
  
  private static boolean yL(int paramInt)
  {
    AppMethodBeat.i(176997);
    if ((yF(paramInt)) && (!yA(paramInt)) && (!yx(paramInt)))
    {
      AppMethodBeat.o(176997);
      return true;
    }
    AppMethodBeat.o(176997);
    return false;
  }
  
  private static boolean yM(int paramInt)
  {
    AppMethodBeat.i(176998);
    if ((yG(paramInt)) && (!yA(paramInt)) && (!yx(paramInt)))
    {
      AppMethodBeat.o(176998);
      return true;
    }
    AppMethodBeat.o(176998);
    return false;
  }
  
  private static boolean yN(int paramInt)
  {
    AppMethodBeat.i(176999);
    if ((yH(paramInt)) && (!yA(paramInt)) && (!yx(paramInt)))
    {
      AppMethodBeat.o(176999);
      return true;
    }
    AppMethodBeat.o(176999);
    return false;
  }
  
  private static boolean yO(int paramInt)
  {
    AppMethodBeat.i(209535);
    if ((yI(paramInt)) && (!yA(paramInt)) && (!yx(paramInt)))
    {
      AppMethodBeat.o(209535);
      return true;
    }
    AppMethodBeat.o(209535);
    return false;
  }
  
  private static boolean yP(int paramInt)
  {
    AppMethodBeat.i(177000);
    if ((yF(paramInt)) && (yx(paramInt)) && (!yA(paramInt)))
    {
      AppMethodBeat.o(177000);
      return true;
    }
    AppMethodBeat.o(177000);
    return false;
  }
  
  private static boolean yQ(int paramInt)
  {
    AppMethodBeat.i(177001);
    if ((yG(paramInt)) && (yx(paramInt)) && (!yA(paramInt)))
    {
      AppMethodBeat.o(177001);
      return true;
    }
    AppMethodBeat.o(177001);
    return false;
  }
  
  private static boolean yR(int paramInt)
  {
    AppMethodBeat.i(177002);
    if ((yH(paramInt)) && (yx(paramInt)) && (!yA(paramInt)))
    {
      AppMethodBeat.o(177002);
      return true;
    }
    AppMethodBeat.o(177002);
    return false;
  }
  
  private static boolean yS(int paramInt)
  {
    AppMethodBeat.i(209536);
    if ((yI(paramInt)) && (yx(paramInt)) && (!yA(paramInt)))
    {
      AppMethodBeat.o(209536);
      return true;
    }
    AppMethodBeat.o(209536);
    return false;
  }
  
  private static boolean yT(int paramInt)
  {
    AppMethodBeat.i(177003);
    if ((yB(paramInt)) && (!yx(paramInt)) && (!yy(paramInt)))
    {
      AppMethodBeat.o(177003);
      return true;
    }
    AppMethodBeat.o(177003);
    return false;
  }
  
  private static boolean yU(int paramInt)
  {
    AppMethodBeat.i(177004);
    if ((yE(paramInt)) && (!yx(paramInt)) && (!yy(paramInt)))
    {
      AppMethodBeat.o(177004);
      return true;
    }
    AppMethodBeat.o(177004);
    return false;
  }
  
  private static boolean yV(int paramInt)
  {
    AppMethodBeat.i(177005);
    if ((yx(paramInt)) && (yA(paramInt)) && (!yy(paramInt)))
    {
      AppMethodBeat.o(177005);
      return true;
    }
    AppMethodBeat.o(177005);
    return false;
  }
  
  private void yl(int paramInt)
  {
    AppMethodBeat.i(209514);
    Point localPoint1 = this.nQL;
    this.nQL = al.ck(getContext());
    Point localPoint2 = this.nQL;
    Object localObject;
    int i;
    int j;
    int k;
    if (localPoint1 != null)
    {
      localObject = localPoint1;
      ae.i("MicroMsg.FloatBallView", "processOrientationChanged, screenResolution: %s, lastResolution: %s", new Object[] { localPoint2, localObject });
      if ((this.cpv != paramInt) || ((localPoint1 != null) && ((localPoint1.x != this.nQL.x) || (localPoint1.y != this.nQL.y))))
      {
        this.cpv = paramInt;
        this.nQQ = true;
        localObject = (WindowManager.LayoutParams)getLayoutParams();
        paramInt = ((WindowManager.LayoutParams)localObject).x;
        i = (int)(this.nQL.y * this.nQO);
        paramInt = Math.max(Math.min(paramInt, this.nQL.x), 0);
        i = Math.max(Math.min(i, this.nQL.y), 0);
        j = getTargetPositionXWhenOrientationChanged();
        k = yo(i);
        if (j != 0) {
          break label294;
        }
      }
    }
    label294:
    for (boolean bool = true;; bool = false)
    {
      ae.i("MicroMsg.FloatBallView", "processOrientationChanged, layoutParams.x: %s, layoutParams.y: %s, stickToLeft:%s, startSticky:[%s, %s]=>[%s, %s]", new Object[] { Integer.valueOf(((WindowManager.LayoutParams)localObject).x), Integer.valueOf(((WindowManager.LayoutParams)localObject).y), Boolean.valueOf(bool), Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
      d(bool, paramInt, i, j, k);
      AppMethodBeat.o(209514);
      return;
      localObject = "null";
      break;
    }
  }
  
  private boolean ym(int paramInt)
  {
    AppMethodBeat.i(176987);
    if (getCurrentStateWidth() + paramInt != this.nQL.x)
    {
      AppMethodBeat.o(176987);
      return true;
    }
    AppMethodBeat.o(176987);
    return false;
  }
  
  private static int yo(int paramInt)
  {
    int i;
    if (paramInt < com.tencent.mm.plugin.ball.f.e.nNX) {
      i = com.tencent.mm.plugin.ball.f.e.nNX;
    }
    do
    {
      return i;
      i = paramInt;
    } while (paramInt <= com.tencent.mm.plugin.ball.f.e.nNY);
    return com.tencent.mm.plugin.ball.f.e.nNY;
  }
  
  private int yp(int paramInt)
  {
    AppMethodBeat.i(106465);
    int i = 0;
    if (!yn(paramInt)) {
      i = this.nQL.x - getCurrentStateWidth();
    }
    AppMethodBeat.o(106465);
    return i;
  }
  
  private int yq(int paramInt)
  {
    AppMethodBeat.i(209524);
    int i = getWidth();
    if (yK(paramInt)) {
      i = nPj;
    }
    for (;;)
    {
      AppMethodBeat.o(209524);
      return i;
      if ((yL(paramInt)) || ((!yJ(paramInt)) && (yz(paramInt)))) {
        i = nPT;
      } else if (yM(paramInt)) {
        i = nPU;
      } else if ((yN(paramInt)) || (yO(paramInt))) {
        i = nPV;
      } else if ((yP(paramInt)) || (yQ(paramInt))) {
        i = nPl;
      } else if ((yR(paramInt)) || (yS(paramInt))) {
        i = nPl + nPN;
      }
    }
  }
  
  private int yr(int paramInt)
  {
    AppMethodBeat.i(209525);
    int i = getHeight();
    if (yK(paramInt)) {
      paramInt = nPk;
    }
    for (;;)
    {
      AppMethodBeat.o(209525);
      return paramInt;
      if (yL(paramInt))
      {
        paramInt = nPT;
      }
      else if (yM(paramInt))
      {
        paramInt = nPU;
      }
      else if ((yN(paramInt)) || (yO(paramInt)))
      {
        paramInt = nPU;
      }
      else if ((yP(paramInt)) || (yQ(paramInt)) || (yR(paramInt)) || (yS(paramInt)))
      {
        paramInt = nPm;
      }
      else if (!yR(this.nPg))
      {
        paramInt = i;
        if (!yS(this.nPg)) {}
      }
      else
      {
        paramInt = nPm;
      }
    }
  }
  
  private void ys(int paramInt)
  {
    this.nPg &= (paramInt ^ 0xFFFFFFFF);
  }
  
  private void yt(int paramInt)
  {
    this.nPg |= paramInt;
  }
  
  private int yu(int paramInt)
  {
    AppMethodBeat.i(209531);
    paramInt = h(yB(paramInt), yE(paramInt), yw(paramInt));
    AppMethodBeat.o(209531);
    return paramInt;
  }
  
  private int yv(int paramInt)
  {
    AppMethodBeat.i(209532);
    paramInt = a(paramInt, yB(paramInt), yE(paramInt), yw(paramInt));
    AppMethodBeat.o(209532);
    return paramInt;
  }
  
  private static boolean yx(int paramInt)
  {
    return (paramInt & 0x1) != 0;
  }
  
  private static boolean yy(int paramInt)
  {
    AppMethodBeat.i(176994);
    if ((yF(paramInt)) || (yG(paramInt)) || (yH(paramInt)) || (yI(paramInt)))
    {
      AppMethodBeat.o(176994);
      return true;
    }
    AppMethodBeat.o(176994);
    return false;
  }
  
  private static boolean yz(int paramInt)
  {
    return ((paramInt & 0x100) != 0) || ((paramInt & 0x200) != 0);
  }
  
  public final void R(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(209517);
    Object localObject = (FrameLayout.LayoutParams)this.nQf.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject).gravity = paramInt;
    this.nQf.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if ((!paramBoolean) && (!yJ(this.nPg)) && (this.nQh.getVisibility() == 0))
    {
      localObject = (LinearLayout.LayoutParams)this.nQh.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).gravity = 17;
      this.nQh.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    AppMethodBeat.o(209517);
  }
  
  public final int a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(209533);
    int i = 0;
    if ((paramBoolean1) || (paramBoolean2))
    {
      if ((this.nQU != null) && (this.nQU.x > 0) && (this.nQU.y > 0)) {
        i = this.nQU.y;
      }
      while (paramBoolean3)
      {
        if ((!yC(paramInt)) && (!yD(paramInt))) {
          break label167;
        }
        if ((this.nQU != null) && (this.nQU.x > 0) && (this.nQU.y > 0))
        {
          paramInt = this.nQU.y;
          AppMethodBeat.o(209533);
          return paramInt;
          if (paramBoolean1) {
            i = nPG + nPX * 2;
          } else {
            i = nPK + nPX * 2;
          }
        }
        else
        {
          i = nPK + nPX * 2;
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(209533);
      return i;
      label167:
      if (paramBoolean1) {
        i = nPI + nPX * 2;
      } else {
        i = nPM + nPX * 2;
      }
    }
  }
  
  public final void a(List<BallInfo> paramList, BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106442);
    paramBallInfo = cd(paramList);
    if (bu.lX(paramBallInfo, this.nQG))
    {
      ae.d("MicroMsg.FloatBallView", "<<< onFloatBallInfoChanged, ignore refresh");
      AppMethodBeat.o(106442);
      return;
    }
    ae.i("MicroMsg.FloatBallView", ">>> onFloatBallInfoChanged, ballInfoList:%s", new Object[] { paramList });
    this.nQG = paramBallInfo;
    cc(paramList);
    bMF();
    boolean bool = yn(((WindowManager.LayoutParams)getLayoutParams()).x);
    f(true, bool, false);
    a(true, bool, false, this.nPg);
    bMG();
    AppMethodBeat.o(106442);
  }
  
  public final void b(boolean paramBoolean, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(184624);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.dx(paramBoolean);
    localb.bd(paramAnimatorListenerAdapter);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ball/view/FloatBallView", "com/tencent/mm/plugin/ball/view/FloatBallView", "hide", "(ZLandroid/animation/AnimatorListenerAdapter;)V", this, localb.ahF());
    if (getVisibility() == 8)
    {
      ae.i("MicroMsg.FloatBallView", "float ball already hide");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ball/view/FloatBallView", "com/tencent/mm/plugin/ball/view/FloatBallView", "hide", "(ZLandroid/animation/AnimatorListenerAdapter;)V");
      AppMethodBeat.o(184624);
      return;
    }
    if ((paramBoolean) && (this.nQc != null))
    {
      ae.i("MicroMsg.FloatBallView", "hide with animation");
      this.nQc.b(paramAnimatorListenerAdapter);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ball/view/FloatBallView", "com/tencent/mm/plugin/ball/view/FloatBallView", "hide", "(ZLandroid/animation/AnimatorListenerAdapter;)V");
      AppMethodBeat.o(184624);
      return;
      ae.i("MicroMsg.FloatBallView", "hide without animation");
      setVisibility(8);
      bML();
    }
  }
  
  public final void bMI()
  {
    AppMethodBeat.i(184622);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.dx(false);
    localb.bd(null);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ball/view/FloatBallView", "com/tencent/mm/plugin/ball/view/FloatBallView", "show", "(ZLandroid/animation/AnimatorListenerAdapter;)V", this, localb.ahF());
    c(false, false, null);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ball/view/FloatBallView", "com/tencent/mm/plugin/ball/view/FloatBallView", "show", "(ZLandroid/animation/AnimatorListenerAdapter;)V");
    AppMethodBeat.o(184622);
  }
  
  public final void c(boolean paramBoolean1, boolean paramBoolean2, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(184623);
    if ((getVisibility() == 0) && (paramBoolean2))
    {
      ae.i("MicroMsg.FloatBallView", "float ball already show");
      AppMethodBeat.o(184623);
      return;
    }
    if ((paramBoolean1) && (this.nQc != null))
    {
      ae.i("MicroMsg.FloatBallView", "show with animation");
      this.nQc.a(paramAnimatorListenerAdapter);
      AppMethodBeat.o(184623);
      return;
    }
    ae.i("MicroMsg.FloatBallView", "show without animation");
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
    f(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
    AppMethodBeat.o(106456);
  }
  
  public final void g(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(106457);
    this.nQK = yn(paramInt1);
    a(paramBoolean1, this.nQK, paramBoolean2, this.nPg);
    f(paramBoolean1, this.nQK, paramBoolean2);
    S(paramInt2, paramBoolean1);
    ae.i("MicroMsg.FloatBallView", "notifyBallPositionChanged, x:%s, y:%s, isSettled:%s, isManual:%s, isDockLeft:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(this.nQK) });
    Iterator localIterator = this.cBA.iterator();
    while (localIterator.hasNext()) {
      ((h)localIterator.next()).a(paramInt1, paramInt2, getCurrentStateHeight(), paramBoolean1, this.nQK);
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
    if (this.nQK)
    {
      if (yB(this.nPg))
      {
        localObject = new Point(((WindowManager.LayoutParams)localObject).x, ((WindowManager.LayoutParams)localObject).y + com.tencent.mm.plugin.ball.f.e.nNQ + nPG);
        AppMethodBeat.o(106470);
        return localObject;
      }
      if (yE(this.nPg))
      {
        localObject = new Point(((WindowManager.LayoutParams)localObject).x, ((WindowManager.LayoutParams)localObject).y + com.tencent.mm.plugin.ball.f.e.nNQ + nPK);
        AppMethodBeat.o(106470);
        return localObject;
      }
      localObject = new Point(((WindowManager.LayoutParams)localObject).x, ((WindowManager.LayoutParams)localObject).y + com.tencent.mm.plugin.ball.f.e.nNQ);
      AppMethodBeat.o(106470);
      return localObject;
    }
    if (yB(this.nPg))
    {
      localObject = new Point(((WindowManager.LayoutParams)localObject).x + com.tencent.mm.plugin.ball.f.e.nNS, ((WindowManager.LayoutParams)localObject).y + com.tencent.mm.plugin.ball.f.e.nNQ + nPG);
      AppMethodBeat.o(106470);
      return localObject;
    }
    if (yE(this.nPg))
    {
      localObject = new Point(((WindowManager.LayoutParams)localObject).x + com.tencent.mm.plugin.ball.f.e.nNS, ((WindowManager.LayoutParams)localObject).y + com.tencent.mm.plugin.ball.f.e.nNQ + nPK);
      AppMethodBeat.o(106470);
      return localObject;
    }
    localObject = new Point(((WindowManager.LayoutParams)localObject).x + com.tencent.mm.plugin.ball.f.e.nNS, ((WindowManager.LayoutParams)localObject).y + com.tencent.mm.plugin.ball.f.e.nNQ);
    AppMethodBeat.o(106470);
    return localObject;
  }
  
  public int getCurrentStateWidth()
  {
    AppMethodBeat.i(106467);
    int i = this.nPg;
    ae.v("MicroMsg.FloatBallView", "getStateWidth state: %d", new Object[] { Integer.valueOf(i) });
    if (yA(i)) {}
    for (i = yu(i) + this.nQW * 2;; i = yq(i))
    {
      int j = com.tencent.mm.plugin.ball.f.e.nNS;
      AppMethodBeat.o(106467);
      return i + j;
    }
  }
  
  public float getPosYPercentOfScreen()
  {
    return this.nQO;
  }
  
  public int getPositionY()
  {
    return this.nQP;
  }
  
  public final int h(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int i = 0;
    int j;
    if ((paramBoolean1) || (paramBoolean2))
    {
      if ((this.nQU == null) || (this.nQU.x <= 0) || (this.nQU.y <= 0)) {
        break label90;
      }
      j = this.nQU.x;
      if (!paramBoolean3) {
        break label142;
      }
      if (!paramBoolean1) {
        break label76;
      }
      i = nPH + nPX * 2;
    }
    while (j < i)
    {
      return i;
      label76:
      i = nPL + nPX * 2;
      continue;
      label90:
      if (paramBoolean1)
      {
        if (paramBoolean3) {
          return nPH + nPX * 2;
        }
        return nPF + nPX * 2;
      }
      if (paramBoolean3) {
        return nPL + nPX * 2;
      }
      return nPJ + nPX * 2;
    }
    label142:
    return j;
  }
  
  public final void iR(boolean paramBoolean)
  {
    AppMethodBeat.i(176992);
    ae.i("MicroMsg.FloatBallView", "markWechatInForeground, visibility:%s, inForeground:%s", new Object[] { Integer.valueOf(getVisibility()), Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
      this.nPg |= 0x20;
    }
    for (;;)
    {
      f(this.nRa, this.nRb, this.nQZ);
      AppMethodBeat.o(176992);
      return;
      this.nPg &= 0xFFFFFFDF;
      if ((yA(this.nPg)) || (yz(this.nPg)))
      {
        bMI();
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
    g(localLayoutParams.x, localLayoutParams.y, true, false);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ball/view/FloatBallView", "com/tencent/mm/plugin/ball/view/FloatBallView", "onAttachedToWindow", "()V");
    AppMethodBeat.o(106439);
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(106441);
    ae.i("MicroMsg.FloatBallView", "onConfigurationChanged, orientation:%d, lastOrientation: %d", new Object[] { Integer.valueOf(paramConfiguration.orientation), Integer.valueOf(this.cpv) });
    yl(paramConfiguration.orientation);
    int i = paramConfiguration.orientation;
    paramConfiguration = this.cBA.iterator();
    while (paramConfiguration.hasNext()) {
      ((h)paramConfiguration.next()).nO(i);
    }
    AppMethodBeat.o(106441);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(106440);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ball/view/FloatBallView", "com/tencent/mm/plugin/ball/view/FloatBallView", "onDetachedFromWindow", "()V", this);
    super.onDetachedFromWindow();
    if (this.nQb != null)
    {
      this.nQb.cancel();
      this.nQb = null;
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
    if (!this.nQJ)
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
      this.nRd = false;
      this.nQM.x = paramMotionEvent.getRawX();
      this.nQM.y = paramMotionEvent.getRawY();
      paramMotionEvent = (WindowManager.LayoutParams)getLayoutParams();
      this.nQN.x = paramMotionEvent.x;
      this.nQN.y = paramMotionEvent.y;
      a(true, this.nQK, true, this.nPg);
      if (this.nQQ) {
        f(true, this.nQK, true);
      }
      this.nKu = false;
      if ((yJ(this.nPg)) && (!yT(this.nPg)) && (!yU(this.nPg)))
      {
        this.nRe.postDelayed(this.nRf, this.nPZ);
        continue;
        if (this.nKu)
        {
          K(paramMotionEvent);
        }
        else
        {
          if ((!this.nRd) && (C(paramMotionEvent)))
          {
            this.nRe.removeCallbacks(this.nRf);
            this.nRd = true;
            i = this.nQN.x;
            i = this.nQN.y;
            localIterator = this.cBA.iterator();
            while (localIterator.hasNext()) {
              ((h)localIterator.next()).bLg();
            }
          }
          if (this.nRd)
          {
            e(D(paramMotionEvent), E(paramMotionEvent), false, true);
            continue;
            if (this.nKu)
            {
              a(true, this.nQK, false, this.nPg);
              if (this.nQQ) {
                f(true, this.nQK, false);
              }
              K(paramMotionEvent);
            }
            else
            {
              this.nRe.removeCallbacks(this.nRf);
              if ((this.nRd) || (C(paramMotionEvent))) {
                break;
              }
              a(true, this.nQK, false, this.nPg);
              if (this.nQQ) {
                f(true, this.nQK, false);
              }
              e(this.nQN.x, this.nQN.y, true, false);
              if (this.nQR)
              {
                float f1 = this.nQM.x;
                float f2 = this.nQM.y;
                long l = System.currentTimeMillis();
                if (l > this.ndi + 800L)
                {
                  this.ndi = l;
                  if (d.q(this.nQe, (int)f1, (int)f2))
                  {
                    ae.i("MicroMsg.FloatBallView", "notifyBallClickedIfNeed, you clicked voip");
                    if ((this.nQS != null) && (g.ab(c.class) != null))
                    {
                      this.nQS.nLw.opType = 3;
                      ((c)g.ab(c.class)).n(this.nQS);
                    }
                    this.nQe.callOnClick();
                  }
                  else if ((yU(this.nPg)) || (yT(this.nPg)))
                  {
                    ae.i("MicroMsg.FloatBallView", "notifyBallClickedIfNeed, ignore click");
                  }
                  else if (yJ(this.nPg))
                  {
                    ae.i("MicroMsg.FloatBallView", "notifyBallClickedIfNeed, wechat in foreground");
                    paramMotionEvent = this.cBA.iterator();
                    while (paramMotionEvent.hasNext()) {
                      ((h)paramMotionEvent.next()).bLe();
                    }
                  }
                  else if ((this.nQT != null) && (g.ab(c.class) != null))
                  {
                    ae.i("MicroMsg.FloatBallView", "notifyBallClickedIfNeed, you clicked appbrand voip");
                    this.nQT.nLw.opType = 3;
                    ((c)g.ab(c.class)).n(this.nQT);
                  }
                }
                else
                {
                  ae.i("MicroMsg.FloatBallView", "notifyBallClickedIfNeed, you clicked too fast!");
                }
              }
            }
          }
        }
      }
    }
    a(false, this.nQK, false, this.nPg);
    if (this.nRd)
    {
      this.nRd = false;
      localIterator = this.cBA.iterator();
      while (localIterator.hasNext()) {
        ((h)localIterator.next()).bLh();
      }
    }
    int i = D(paramMotionEvent);
    int j = E(paramMotionEvent);
    int k = yp(i);
    int m = yo(j);
    if (k == 0) {}
    for (boolean bool = true;; bool = false)
    {
      ae.i("MicroMsg.FloatBallView", "onTouchEvent, stickToLeft:%s, startSticky:[%s, %s]=>[%s, %s]", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m) });
      d(bool, i, j, k, m);
      break;
    }
  }
  
  public void setAlpha(float paramFloat)
  {
    AppMethodBeat.i(106473);
    super.setAlpha(paramFloat);
    ae.m("MicroMsg.FloatBallView", "setAlpha:%s", new Object[] { Float.valueOf(paramFloat) });
    bMK();
    AppMethodBeat.o(106473);
  }
  
  public void setEnableClick(boolean paramBoolean)
  {
    AppMethodBeat.i(209522);
    ae.d("MicroMsg.FloatBallView", "alvinluo setEnableClick enable: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.nQR = paramBoolean;
    AppMethodBeat.o(209522);
  }
  
  public void setFloatBallAlpha(final float paramFloat)
  {
    AppMethodBeat.i(106460);
    com.tencent.mm.plugin.ball.b.b localb = this.nQc;
    if ((localb.bKP()) || (localb.bKQ())) {}
    for (int i = 1; i != 0; i = 0)
    {
      ae.m("MicroMsg.FloatBallView", "setFloatBallAlpha later, alpha:%s", new Object[] { Float.valueOf(paramFloat) });
      localb = this.nQc;
      Runnable local2 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(106431);
          ae.i("MicroMsg.FloatBallView", "setFloatBallAlpha when animation ends, alpha:%s", new Object[] { Float.valueOf(paramFloat) });
          FloatBallView.a(FloatBallView.this, paramFloat);
          AppMethodBeat.o(106431);
        }
      };
      localb.nLm.add(local2);
      AppMethodBeat.o(106460);
      return;
    }
    ae.m("MicroMsg.FloatBallView", "setFloatBallAlpha right now, alpha:%s", new Object[] { Float.valueOf(paramFloat) });
    setFloatBallAlphaInternal(paramFloat);
    AppMethodBeat.o(106460);
  }
  
  public void setInnerView(View paramView)
  {
    AppMethodBeat.i(106471);
    if (paramView == this.nQd)
    {
      AppMethodBeat.o(106471);
      return;
    }
    this.nQi.removeAllViews();
    this.nQd = paramView;
    if (this.nQd != null)
    {
      paramView = new FrameLayout.LayoutParams(-1, -1);
      paramView.gravity = 17;
      this.nQi.addView(this.nQd, paramView);
    }
    AppMethodBeat.o(106471);
  }
  
  public void setNeedTranslateAnimation(boolean paramBoolean)
  {
    this.nNn = paramBoolean;
  }
  
  public void setVOIPView(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(209527);
    Object localObject = paramBallInfo.vd;
    if (localObject == this.nQe)
    {
      ae.w("MicroMsg.FloatBallView", "setVOIPView voipView not changed");
      AppMethodBeat.o(209527);
      return;
    }
    if ((((View)localObject).getParent() != null) && ((((View)localObject).getParent() instanceof ViewGroup)))
    {
      ae.i("MicroMsg.FloatBallView", "setVOIPView remove from parent first");
      ((ViewGroup)((View)localObject).getParent()).removeView((View)localObject);
    }
    this.nQg.removeAllViews();
    this.nQe = ((View)localObject);
    if (this.nQe != null)
    {
      localObject = new FrameLayout.LayoutParams(-1, -1);
      ((FrameLayout.LayoutParams)localObject).gravity = 17;
      this.nQg.addView(this.nQe, (ViewGroup.LayoutParams)localObject);
      this.nQU = paramBallInfo.nLq;
      this.nQX = true;
      bMM();
      if (this.nQS.nLx != null)
      {
        paramBallInfo = this.nQS.nLx.nLy;
        localObject = this.nQS.nLx.nLz;
        if ((g(paramBallInfo)) && (g((Point)localObject)))
        {
          this.nQY = 80;
          if ((paramBallInfo.x < ((Point)localObject).x) && (paramBallInfo.y < ((Point)localObject).y))
          {
            this.nQV.x = (((Point)localObject).x - paramBallInfo.x);
            this.nQV.y = (((Point)localObject).y - paramBallInfo.y);
            this.nQX = false;
          }
        }
        ae.v("MicroMsg.FloatBallView", "alvinluo updateVoipViewParams startSize: %s, endSize: %s, extraSize: %s, voipViewSize: %s", new Object[] { paramBallInfo, localObject, this.nQV, this.nQU });
      }
    }
    AppMethodBeat.o(209527);
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(106472);
    super.setVisibility(paramInt);
    int i = (int)getAlpha();
    if (i == 0)
    {
      this.nQJ = false;
      ae.m("MicroMsg.FloatBallView", "setVisibility:%s, alphaInt:%s, disableTouch", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      AppMethodBeat.o(106472);
      return;
    }
    if (i == 1)
    {
      this.nQJ = true;
      ae.m("MicroMsg.FloatBallView", "setVisibility:%s, alphaInt:%s, enableTouch", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      bMK();
    }
    AppMethodBeat.o(106472);
  }
  
  public final boolean yn(int paramInt)
  {
    AppMethodBeat.i(106459);
    if (getCurrentStateWidth() / 2 + paramInt <= this.nQL.x / 2)
    {
      AppMethodBeat.o(106459);
      return true;
    }
    AppMethodBeat.o(106459);
    return false;
  }
  
  public final boolean yw(int paramInt)
  {
    AppMethodBeat.i(209534);
    if ((yx(paramInt)) && (this.nPi >= 3))
    {
      AppMethodBeat.o(209534);
      return true;
    }
    AppMethodBeat.o(209534);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.view.FloatBallView
 * JD-Core Version:    0.7.0.1
 */