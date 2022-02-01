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
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.t;
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
  private static final int nJF;
  private static final int nJG;
  private static final int nJH;
  private static final int nJI;
  private static final int nJJ;
  private static final int nJK;
  private static final int nJL;
  private static final int nJM;
  private static final int nJN;
  private static final int nJO;
  private static final int nJP;
  private static final int nJQ;
  private static final int nJR;
  private static final int nJS;
  private static final int nJT;
  private static final int nJU;
  private static final int nJV;
  private static final int nJW;
  private static final int nJX;
  private static final int nJY;
  private static final int nJZ;
  private static final int nKa;
  private static final int nKb;
  private static final int nKc;
  private static final int nKd;
  private static final int nKe;
  private static final int nKf;
  private static final int nKg;
  private static final int nKh;
  private static final int nKi;
  private static final int nKj;
  private static final int nKk;
  private static final int nKl;
  private static final int nKm;
  private static final int nKn;
  private static final int nKo;
  private static final int nKp;
  private static final int nKq;
  private static final int nKr;
  private static final int nKs;
  private Handler cAO;
  public Set<com.tencent.mm.plugin.ball.d.b> cAT;
  private int gNO;
  private View kke;
  private long mYb;
  private boolean nEZ;
  public boolean nHK;
  public int nJD;
  private int nJE;
  private LinearLayout nKA;
  public FrameLayout nKB;
  private FrameLayout nKC;
  private FrameLayout nKD;
  private FrameLayout nKE;
  private CircleAnimateView nKF;
  private CircleAnimateView nKG;
  private CircleAnimateView nKH;
  private CircleAnimateView nKI;
  private Drawable nKJ;
  private Drawable nKK;
  private Drawable nKL;
  private Drawable nKM;
  private Drawable nKN;
  private Drawable nKO;
  private Drawable nKP;
  private Drawable nKQ;
  private Drawable nKR;
  private Drawable nKS;
  private Drawable nKT;
  private Drawable nKU;
  private Drawable nKV;
  private Drawable nKW;
  private Drawable nKX;
  private Drawable nKY;
  private Drawable nKZ;
  private int nKt;
  private int nKu;
  private Vibrator nKv;
  private ValueAnimator nKw;
  public com.tencent.mm.plugin.ball.b.b nKx;
  private View nKy;
  private View nKz;
  private Runnable nLA;
  private boolean nLB;
  private boolean nLC;
  private boolean nLD;
  private int nLE;
  private Drawable nLa;
  private BallInfo nLb;
  private BallInfo nLc;
  private String nLd;
  private List<BallInfo> nLe;
  private LayoutTransition nLf;
  private boolean nLg;
  public boolean nLh;
  private Point nLi;
  private PointF nLj;
  private Point nLk;
  private float nLl;
  private int nLm;
  private boolean nLn;
  private boolean nLo;
  private boolean nLp;
  private int nLq;
  private int nLr;
  private Point nLs;
  public int nLt;
  private boolean nLu;
  private boolean nLv;
  private boolean nLw;
  private int nLx;
  private boolean nLy;
  private Handler nLz;
  private WindowManager windowManager;
  
  static
  {
    AppMethodBeat.i(106478);
    nJF = com.tencent.mm.cc.a.ay(aj.getContext(), 2131166306);
    nJG = com.tencent.mm.cc.a.ay(aj.getContext(), 2131166303);
    nJH = com.tencent.mm.cc.a.ay(aj.getContext(), 2131166305);
    nJI = com.tencent.mm.cc.a.ay(aj.getContext(), 2131166304);
    nJJ = com.tencent.mm.cc.a.ay(aj.getContext(), 2131166325);
    nJK = com.tencent.mm.cc.a.ay(aj.getContext(), 2131166324);
    nJL = com.tencent.mm.cc.a.ay(aj.getContext(), 2131166337);
    nJM = com.tencent.mm.cc.a.ay(aj.getContext(), 2131166336);
    nJN = com.tencent.mm.cc.a.ay(aj.getContext(), 2131166333);
    nJO = com.tencent.mm.cc.a.ay(aj.getContext(), 2131166332);
    nJP = com.tencent.mm.cc.a.ay(aj.getContext(), 2131166345);
    nJQ = com.tencent.mm.cc.a.ay(aj.getContext(), 2131166344);
    nJR = com.tencent.mm.cc.a.ay(aj.getContext(), 2131166348);
    nJS = com.tencent.mm.cc.a.ay(aj.getContext(), 2131166346);
    nJT = com.tencent.mm.cc.a.ay(aj.getContext(), 2131166349);
    nJU = com.tencent.mm.cc.a.ay(aj.getContext(), 2131166347);
    nJV = com.tencent.mm.cc.a.ay(aj.getContext(), 2131166339);
    nJW = com.tencent.mm.cc.a.ay(aj.getContext(), 2131166338);
    nJX = com.tencent.mm.cc.a.ay(aj.getContext(), 2131166342);
    nJY = com.tencent.mm.cc.a.ay(aj.getContext(), 2131166340);
    nJZ = com.tencent.mm.cc.a.ay(aj.getContext(), 2131166343);
    nKa = com.tencent.mm.cc.a.ay(aj.getContext(), 2131166341);
    nKb = com.tencent.mm.cc.a.ay(aj.getContext(), 2131166356);
    nKc = com.tencent.mm.cc.a.ay(aj.getContext(), 2131166354);
    nKd = com.tencent.mm.cc.a.ay(aj.getContext(), 2131166357);
    nKe = com.tencent.mm.cc.a.ay(aj.getContext(), 2131166355);
    nKf = com.tencent.mm.cc.a.ay(aj.getContext(), 2131166352);
    nKg = com.tencent.mm.cc.a.ay(aj.getContext(), 2131166350);
    nKh = com.tencent.mm.cc.a.ay(aj.getContext(), 2131166353);
    nKi = com.tencent.mm.cc.a.ay(aj.getContext(), 2131166351);
    nKj = com.tencent.mm.cc.a.ay(aj.getContext(), 2131166331);
    nKk = com.tencent.mm.cc.a.ay(aj.getContext(), 2131166307);
    nKl = com.tencent.mm.cc.a.ay(aj.getContext(), 2131166320);
    nKm = com.tencent.mm.cc.a.ay(aj.getContext(), 2131166321);
    nKn = com.tencent.mm.cc.a.ay(aj.getContext(), 2131166318);
    nKo = com.tencent.mm.cc.a.ay(aj.getContext(), 2131166319);
    nKp = com.tencent.mm.cc.a.ay(aj.getContext(), 2131166309);
    nKq = com.tencent.mm.cc.a.ay(aj.getContext(), 2131166311);
    nKr = com.tencent.mm.cc.a.ay(aj.getContext(), 2131166310);
    nKs = com.tencent.mm.cc.a.ax(aj.getContext(), 2131167064);
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
    this.nJD = 0;
    this.nJE = 0;
    this.cAT = new CopyOnWriteArraySet();
    this.nLj = new PointF();
    this.nLk = new Point();
    this.nLl = -1.0F;
    this.nLm = 0;
    this.nLn = false;
    this.nHK = false;
    this.nLo = true;
    this.nLp = false;
    this.nLq = 0;
    this.nLr = 0;
    this.nLs = new Point();
    this.nLt = 16;
    this.cAO = new Handler(Looper.getMainLooper());
    this.nLu = false;
    this.nLv = false;
    this.nLw = false;
    this.nLx = 0;
    this.nLy = false;
    this.nEZ = false;
    this.nLz = new Handler(Looper.getMainLooper());
    this.nLA = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106430);
        FloatBallView.a(FloatBallView.this);
        FloatBallView.b(FloatBallView.this);
        Iterator localIterator = FloatBallView.this.cAT.iterator();
        while (localIterator.hasNext()) {
          ((com.tencent.mm.plugin.ball.d.b)localIterator.next()).bKi();
        }
        AppMethodBeat.o(106430);
      }
    };
    this.nLB = false;
    this.nLC = false;
    this.nLD = false;
    this.nLE = 0;
    View.inflate(paramContext, 2131494557, this);
    this.nKJ = com.tencent.mm.cc.a.l(paramContext, 2131232399);
    this.nKK = com.tencent.mm.cc.a.l(paramContext, 2131232401);
    this.nKL = com.tencent.mm.cc.a.l(paramContext, 2131232403);
    this.nKM = com.tencent.mm.cc.a.l(paramContext, 2131232400);
    this.nKN = com.tencent.mm.cc.a.l(paramContext, 2131232402);
    this.nKO = com.tencent.mm.cc.a.l(paramContext, 2131232404);
    this.nKP = com.tencent.mm.cc.a.l(paramContext, 2131232393);
    this.nKQ = com.tencent.mm.cc.a.l(paramContext, 2131232395);
    this.nKR = com.tencent.mm.cc.a.l(paramContext, 2131232397);
    this.nKS = com.tencent.mm.cc.a.l(paramContext, 2131232394);
    this.nKT = com.tencent.mm.cc.a.l(paramContext, 2131232396);
    this.nKU = com.tencent.mm.cc.a.l(paramContext, 2131232398);
    this.nKV = com.tencent.mm.cc.a.l(paramContext, 2131232415);
    this.nKW = com.tencent.mm.cc.a.l(paramContext, 2131232416);
    this.nKX = com.tencent.mm.cc.a.l(paramContext, 2131232417);
    this.nKY = com.tencent.mm.cc.a.l(paramContext, 2131232415);
    this.nKZ = com.tencent.mm.cc.a.l(paramContext, 2131232416);
    this.nLa = com.tencent.mm.cc.a.l(paramContext, 2131232417);
    this.nKA = ((LinearLayout)findViewById(2131297110));
    this.nKD = ((FrameLayout)findViewById(2131297109));
    this.nKB = ((FrameLayout)findViewById(2131306552));
    this.nKC = ((FrameLayout)findViewById(2131303096));
    this.kke = findViewById(2131299156);
    this.nKE = ((FrameLayout)findViewById(2131297111));
    this.nKF = ((CircleAnimateView)findViewById(2131305994));
    this.nKG = ((CircleAnimateView)findViewById(2131297430));
    this.nKH = ((CircleAnimateView)findViewById(2131305769));
    this.nKI = ((CircleAnimateView)findViewById(2131307194));
    this.nKx = new com.tencent.mm.plugin.ball.b.b(this);
    this.nKv = ((Vibrator)paramContext.getSystemService("vibrator"));
    this.windowManager = ((WindowManager)paramContext.getSystemService("window"));
    this.nKt = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.nLi = al.ci(paramContext);
    this.nKu = ViewConfiguration.getLongPressTimeout();
    this.nLf = new LayoutTransition();
    this.nKA.setLayoutTransition(this.nLf);
    this.gNO = getResources().getConfiguration().orientation;
    AppMethodBeat.o(106438);
  }
  
  private void C(boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 1;
    int i = 1;
    AppMethodBeat.i(217326);
    int k = this.nKA.getPaddingLeft();
    int m = this.nKA.getPaddingRight();
    int n = this.nKA.getPaddingTop();
    int i1 = this.nKA.getPaddingBottom();
    label470:
    Object localObject;
    if (yA(this.nJD))
    {
      if (paramBoolean2) {}
      for (i = this.nLt | 0x800003;; i = this.nLt | 0x800005)
      {
        yj(i);
        if (!paramBoolean1) {
          break label470;
        }
        if (!paramBoolean2) {
          break;
        }
        this.nKA.setPadding(getExtendWidth(), n, m, i1);
        this.nKA.setLayoutTransition(this.nLf);
        bLB();
        AppMethodBeat.o(217326);
        return;
      }
      this.nKA.setPadding(k, n, getExtendWidth(), i1);
      if (((yC(this.nJE)) && (yG(this.nJD))) || ((yD(this.nJE)) && (yH(this.nJD))) || ((yE(this.nJE)) && (yI(this.nJD))) || ((yF(this.nJE)) && (yJ(this.nJD))))
      {
        this.nKA.setLayoutTransition(null);
        bLD();
        AppMethodBeat.o(217326);
        return;
      }
      if (((yB(this.nJE)) && (yG(this.nJD))) || ((yB(this.nJE)) && (yH(this.nJD))) || ((yB(this.nJE)) && (yI(this.nJD))) || ((yB(this.nJE)) && (yJ(this.nJD))))
      {
        this.nKA.setLayoutTransition(null);
        bLD();
        AppMethodBeat.o(217326);
        return;
      }
      if (((yG(this.nJE)) && (yB(this.nJD))) || ((yH(this.nJE)) && (yB(this.nJD))) || ((yI(this.nJE)) && (yB(this.nJD))) || ((yJ(this.nJE)) && (yB(this.nJD))))
      {
        this.nKA.setLayoutTransition(null);
        bLD();
        AppMethodBeat.o(217326);
        return;
      }
      this.nKA.setLayoutTransition(this.nLf);
      bLD();
      AppMethodBeat.o(217326);
      return;
      if ((yG(this.nJD)) || (yH(this.nJD)) || (yI(this.nJD)) || (yJ(this.nJD)))
      {
        if (paramBoolean2)
        {
          bLF();
          AppMethodBeat.o(217326);
          return;
        }
        bLG();
        AppMethodBeat.o(217326);
        return;
      }
      if ((yC(this.nJD)) || (yD(this.nJD)) || (yE(this.nJD)) || (yF(this.nJD)))
      {
        D(paramBoolean2, false);
        AppMethodBeat.o(217326);
        return;
      }
      if (yB(this.nJD))
      {
        localObject = (FrameLayout.LayoutParams)this.nKD.getLayoutParams();
        ((FrameLayout.LayoutParams)localObject).gravity = 17;
        i = nKm;
        j = nKm;
        ((FrameLayout.LayoutParams)localObject).setMargins(i, i, j, j);
        this.nKD.setLayoutParams((ViewGroup.LayoutParams)localObject);
        AppMethodBeat.o(217326);
      }
    }
    else
    {
      if (paramBoolean1)
      {
        if (paramBoolean2)
        {
          this.nKA.setPadding(getExtendWidth(), n, m, i1);
          this.nKA.setLayoutTransition(this.nLf);
          yj(this.nLt | 0x800003);
          this.kke.setVisibility(8);
          if (ys(this.nJD))
          {
            this.nKC.setVisibility(0);
            this.nKD.setVisibility(8);
            this.nKE.setVisibility(0);
            localObject = (LinearLayout.LayoutParams)this.nKC.getLayoutParams();
            ((LinearLayout.LayoutParams)localObject).gravity = 8388627;
            this.nKC.setLayoutParams((ViewGroup.LayoutParams)localObject);
            D(true, true);
            this.nKB.setVisibility(0);
            localObject = (LinearLayout.LayoutParams)this.nKB.getLayoutParams();
            if ((!yq(this.nJD)) || (!yy(this.nJD))) {
              break label911;
            }
            label823:
            if (!yu(this.nJD)) {
              break label931;
            }
            if (i == 0) {
              break label916;
            }
            j = nKd;
            label842:
            ((LinearLayout.LayoutParams)localObject).width = j;
            if (i == 0) {
              break label924;
            }
          }
          label911:
          label916:
          label924:
          for (i = nKe;; i = nKc)
          {
            ((LinearLayout.LayoutParams)localObject).height = i;
            i = nKm;
            j = nKm;
            ((LinearLayout.LayoutParams)localObject).setMargins(i, i, j, j);
            this.nKB.setLayoutParams((ViewGroup.LayoutParams)localObject);
            AppMethodBeat.o(217326);
            return;
            this.nKC.setVisibility(8);
            break;
            i = 0;
            break label823;
            j = nKb;
            break label842;
          }
          label931:
          if (yv(this.nJD))
          {
            if (i != 0)
            {
              j = nKh;
              ((LinearLayout.LayoutParams)localObject).width = j;
              if (i == 0) {
                break label1015;
              }
            }
            label1015:
            for (i = nKi;; i = nKg)
            {
              ((LinearLayout.LayoutParams)localObject).height = i;
              i = nKm;
              j = nKm;
              ((LinearLayout.LayoutParams)localObject).setMargins(i, i, j, j);
              this.nKB.setLayoutParams((ViewGroup.LayoutParams)localObject);
              AppMethodBeat.o(217326);
              return;
              j = nKf;
              break;
            }
          }
          this.nKB.setVisibility(8);
          AppMethodBeat.o(217326);
          return;
        }
        this.nKA.setPadding(k, n, getExtendWidth(), i1);
        this.nKA.setLayoutTransition(this.nLf);
        yj(this.nLt | 0x800005);
        this.kke.setVisibility(8);
        if (ys(this.nJD))
        {
          this.nKC.setVisibility(0);
          this.nKD.setVisibility(8);
          this.nKE.setVisibility(0);
          localObject = (LinearLayout.LayoutParams)this.nKC.getLayoutParams();
          ((LinearLayout.LayoutParams)localObject).gravity = 8388629;
          this.nKC.setLayoutParams((ViewGroup.LayoutParams)localObject);
          D(false, true);
          bLH();
          this.nKB.setVisibility(0);
          localObject = (LinearLayout.LayoutParams)this.nKB.getLayoutParams();
          if ((!yq(this.nJD)) || (!yy(this.nJD))) {
            break label1294;
          }
          i = j;
          label1206:
          if (!yu(this.nJD)) {
            break label1314;
          }
          if (i == 0) {
            break label1299;
          }
          j = nKd;
          label1225:
          ((LinearLayout.LayoutParams)localObject).width = j;
          if (i == 0) {
            break label1307;
          }
        }
        label1294:
        label1299:
        label1307:
        for (i = nKe;; i = nKc)
        {
          ((LinearLayout.LayoutParams)localObject).height = i;
          i = nKm;
          j = nKm;
          ((LinearLayout.LayoutParams)localObject).setMargins(i, i, j, j);
          this.nKB.setLayoutParams((ViewGroup.LayoutParams)localObject);
          AppMethodBeat.o(217326);
          return;
          this.nKC.setVisibility(8);
          break;
          i = 0;
          break label1206;
          j = nKb;
          break label1225;
        }
        label1314:
        if (yv(this.nJD))
        {
          if (i != 0)
          {
            j = nKh;
            ((LinearLayout.LayoutParams)localObject).width = j;
            if (i == 0) {
              break label1398;
            }
          }
          label1398:
          for (i = nKi;; i = nKg)
          {
            ((LinearLayout.LayoutParams)localObject).height = i;
            i = nKm;
            j = nKm;
            ((LinearLayout.LayoutParams)localObject).setMargins(i, i, j, j);
            this.nKB.setLayoutParams((ViewGroup.LayoutParams)localObject);
            AppMethodBeat.o(217326);
            return;
            j = nKf;
            break;
          }
        }
        this.nKB.setVisibility(8);
        AppMethodBeat.o(217326);
        return;
      }
      yj(this.nLt | 0x1);
    }
    AppMethodBeat.o(217326);
  }
  
  private int D(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(176983);
    this.nKE.setVisibility(0);
    boolean bool1 = yz(this.nJD);
    boolean bool2 = yy(this.nJD);
    boolean bool3 = yx(this.nJD);
    boolean bool4 = yw(this.nJD);
    boolean bool5 = yq(this.nJD);
    boolean bool6 = yt(this.nJD);
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
      if ((yA(this.nJD)) || (!ys(this.nJD))) {
        break label364;
      }
      k = 1;
      if ((!bool4) && (k == 0)) {
        break label370;
      }
      i2 = nKn;
      if ((paramBoolean2) || (bool5) || (bool6)) {
        break label385;
      }
      if ((!bool4) && (!bool2) && (!bool1) && (k == 0)) {
        break label378;
      }
      i = nKn;
      m = i;
      j = i;
      i = m;
      if ((!bool4) && (k == 0)) {
        break label473;
      }
      this.nKF.setVisibility(0);
      this.nKG.setVisibility(8);
      this.nKH.setVisibility(8);
      this.nKI.setVisibility(8);
      m = 0;
      k = m;
      if (!yA(this.nJD))
      {
        k = m;
        if (ys(this.nJD)) {
          k = getAppBrandVoipBallInfoIndex();
        }
      }
      a(this.nKF, k);
      localLayoutParams1 = (FrameLayout.LayoutParams)this.nKF.getLayoutParams();
      localLayoutParams1.setMargins(j, i2, i, i2);
      localLayoutParams1.gravity = i1;
      this.nKF.setLayoutParams(localLayoutParams1);
    }
    label364:
    label370:
    label378:
    while ((!bool3) && (!bool2) && (!bool1))
    {
      localLayoutParams1 = (FrameLayout.LayoutParams)this.nKE.getLayoutParams();
      localLayoutParams1.gravity = (i1 | 0x10);
      this.nKE.setLayoutParams(localLayoutParams1);
      if ((!bool2) && (!bool1)) {
        break label959;
      }
      k = nKj;
      AppMethodBeat.o(176983);
      return k * 2 + j + i;
      i1 = 8388613;
      break;
      k = 0;
      break label100;
      i2 = nKl;
      break label115;
      i = nKo;
      break label153;
      if (paramBoolean1)
      {
        if ((bool5) && (!bool6))
        {
          j = nKl;
          if (!bool5) {
            break label424;
          }
        }
        for (i = nKl;; i = nKn)
        {
          break;
          j = nKm;
          break label404;
        }
      }
      if (bool5)
      {
        j = nKl;
        if ((!bool5) || (bool6)) {
          break label466;
        }
      }
      for (i = nKl;; i = nKm)
      {
        break;
        j = nKn;
        break label441;
      }
    }
    label385:
    label404:
    label424:
    label441:
    label466:
    label473:
    this.nKF.setVisibility(0);
    this.nKG.setVisibility(0);
    a(this.nKF, 0);
    a(this.nKG, 1);
    int n;
    int i3;
    if (bool2)
    {
      this.nKH.setVisibility(0);
      this.nKI.setVisibility(8);
      a(this.nKH, 2);
      if (paramBoolean1)
      {
        m = j + nKj;
        n = 0;
        k = i;
        i3 = j;
        label575:
        localLayoutParams1 = (FrameLayout.LayoutParams)this.nKH.getLayoutParams();
        localLayoutParams1.setMargins(i3, 0, n, 0);
        localLayoutParams1.gravity = (i1 | 0x10);
        this.nKH.setLayoutParams(localLayoutParams1);
        n = m;
        m = k;
      }
    }
    for (;;)
    {
      localLayoutParams1 = (FrameLayout.LayoutParams)this.nKF.getLayoutParams();
      localLayoutParams1.setMargins(n, i2, m, 0);
      localLayoutParams1.gravity = i1;
      this.nKF.setLayoutParams(localLayoutParams1);
      FrameLayout.LayoutParams localLayoutParams2 = (FrameLayout.LayoutParams)this.nKG.getLayoutParams();
      k = nKj;
      localLayoutParams2.setMargins(n, localLayoutParams1.topMargin + k, m, i2);
      localLayoutParams2.gravity = i1;
      this.nKG.setLayoutParams(localLayoutParams2);
      break;
      i3 = 0;
      k = nKj;
      n = i;
      k += i;
      m = j;
      break label575;
      if (bool1)
      {
        this.nKH.setVisibility(0);
        this.nKI.setVisibility(0);
        a(this.nKH, 2);
        a(this.nKI, 3);
        if (paramBoolean1)
        {
          k = nKj;
          n = 0;
          m = i;
          k += j;
        }
        for (i3 = j;; i3 = 0)
        {
          localLayoutParams1 = (FrameLayout.LayoutParams)this.nKH.getLayoutParams();
          localLayoutParams1.setMargins(i3, i2, n, 0);
          localLayoutParams1.gravity = i1;
          this.nKH.setLayoutParams(localLayoutParams1);
          localLayoutParams2 = (FrameLayout.LayoutParams)this.nKI.getLayoutParams();
          int i4 = nKj;
          localLayoutParams2.setMargins(i3, localLayoutParams1.topMargin + i4, n, 0);
          localLayoutParams2.gravity = i1;
          this.nKI.setLayoutParams(localLayoutParams2);
          n = k;
          break;
          k = nKj;
          n = i;
          m = k + i;
          k = j;
        }
      }
      this.nKI.setVisibility(8);
      this.nKH.setVisibility(8);
      m = i;
      n = j;
    }
    label959:
    int k = nKj;
    AppMethodBeat.o(176983);
    return k + j + i;
  }
  
  private boolean E(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(106453);
    if ((Math.abs(paramMotionEvent.getRawX() - this.nLj.x) > this.nKt) || (Math.abs(paramMotionEvent.getRawY() - this.nLj.y) > this.nKt))
    {
      AppMethodBeat.o(106453);
      return true;
    }
    AppMethodBeat.o(106453);
    return false;
  }
  
  private int F(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(106454);
    int i = (int)Math.max(Math.min(this.nLk.x + paramMotionEvent.getRawX() - this.nLj.x, this.nLi.x), 0.0F);
    AppMethodBeat.o(106454);
    return i;
  }
  
  private int G(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(106455);
    int i = (int)Math.max(Math.min(this.nLk.y + paramMotionEvent.getRawY() - this.nLj.y, this.nLi.y), 0.0F);
    AppMethodBeat.o(106455);
    return i;
  }
  
  private void J(int paramInt, long paramLong)
  {
    AppMethodBeat.i(176984);
    if (paramInt == 0)
    {
      a(this.nKF, paramLong);
      AppMethodBeat.o(176984);
      return;
    }
    if (paramInt == 1)
    {
      a(this.nKG, paramLong);
      AppMethodBeat.o(176984);
      return;
    }
    if (paramInt == 2)
    {
      a(this.nKH, paramLong);
      AppMethodBeat.o(176984);
      return;
    }
    if (paramInt == 3) {
      a(this.nKI, paramLong);
    }
    AppMethodBeat.o(176984);
  }
  
  private void M(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(106475);
    Iterator localIterator = this.cAT.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.plugin.ball.d.b)localIterator.next()).L(paramMotionEvent);
    }
    AppMethodBeat.o(106475);
  }
  
  private void Q(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.nLl = (paramInt / this.nLi.y);
    }
    this.nLm = paramInt;
  }
  
  private void a(CircleAnimateView paramCircleAnimateView, int paramInt)
  {
    AppMethodBeat.i(176986);
    if ((d.h(this.nLe)) && (this.nLe.size() > paramInt))
    {
      BallInfo localBallInfo = (BallInfo)this.nLe.get(paramInt);
      paramInt = d.yd(localBallInfo.state);
      if (-1 != paramInt)
      {
        com.tencent.mm.svg.a.a locala = new com.tencent.mm.svg.a.a();
        if ((!t.aE(aj.getContext(), paramInt)) && (locala.i(getResources(), paramInt))) {
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
    if ((this.nLC == paramBoolean1) && (this.nLD == paramBoolean2) && (this.nLB == paramBoolean3) && (this.nLE == paramInt))
    {
      AppMethodBeat.o(176989);
      return;
    }
    ad.i("MicroMsg.FloatBallView", "updateFloatBallBackground, isSettled:%s, isDockLeft:%s, isManual:%s, state:%s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3), Integer.valueOf(paramInt) });
    this.nLE = paramInt;
    this.nLB = paramBoolean3;
    this.nLC = paramBoolean1;
    this.nLD = paramBoolean2;
    boolean bool1 = yt(paramInt);
    boolean bool2 = yC(paramInt);
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        if (paramBoolean3)
        {
          if (bool1)
          {
            this.nKA.setBackground(this.nKY);
            AppMethodBeat.o(176989);
            return;
          }
          if (bool2)
          {
            this.nKA.setBackground(this.nKS);
            AppMethodBeat.o(176989);
            return;
          }
          this.nKA.setBackground(this.nKM);
          AppMethodBeat.o(176989);
          return;
        }
        if (bool1)
        {
          this.nKA.setBackground(this.nKV);
          AppMethodBeat.o(176989);
          return;
        }
        if (bool2)
        {
          this.nKA.setBackground(this.nKP);
          AppMethodBeat.o(176989);
          return;
        }
        this.nKA.setBackground(this.nKJ);
        AppMethodBeat.o(176989);
        return;
      }
      if (paramBoolean3)
      {
        if (bool1)
        {
          this.nKA.setBackground(this.nKZ);
          AppMethodBeat.o(176989);
          return;
        }
        if (bool2)
        {
          this.nKA.setBackground(this.nKT);
          AppMethodBeat.o(176989);
          return;
        }
        this.nKA.setBackground(this.nKN);
        AppMethodBeat.o(176989);
        return;
      }
      if (bool1)
      {
        this.nKA.setBackground(this.nKW);
        AppMethodBeat.o(176989);
        return;
      }
      if (bool2)
      {
        this.nKA.setBackground(this.nKQ);
        AppMethodBeat.o(176989);
        return;
      }
      this.nKA.setBackground(this.nKK);
      AppMethodBeat.o(176989);
      return;
    }
    if (paramBoolean3)
    {
      if (bool1)
      {
        this.nKA.setBackground(this.nLa);
        AppMethodBeat.o(176989);
        return;
      }
      if (bool2)
      {
        this.nKA.setBackground(this.nKU);
        AppMethodBeat.o(176989);
        return;
      }
      this.nKA.setBackground(this.nKO);
      AppMethodBeat.o(176989);
      return;
    }
    if (bool1)
    {
      this.nKA.setBackground(this.nKX);
      AppMethodBeat.o(176989);
      return;
    }
    if (bool2)
    {
      this.nKA.setBackground(this.nKR);
      AppMethodBeat.o(176989);
      return;
    }
    this.nKA.setBackground(this.nKL);
    AppMethodBeat.o(176989);
  }
  
  private void bLB()
  {
    AppMethodBeat.i(176977);
    if (yt(this.nJD))
    {
      this.kke.setVisibility(0);
      this.nKB.setVisibility(0);
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.nKB.getLayoutParams();
      int j;
      if ((yq(this.nJD)) && (yy(this.nJD)))
      {
        i = 1;
        if (!yu(this.nJD)) {
          break label261;
        }
        if (!yK(this.nJD)) {
          break label178;
        }
        this.kke.setVisibility(4);
        if (i == 0) {
          break label164;
        }
        j = nKd;
        label101:
        localLayoutParams.width = j;
        if (i == 0) {
          break label171;
        }
      }
      label164:
      label171:
      for (int i = nKe;; i = nKc)
      {
        localLayoutParams.height = i;
        i = nKm;
        j = nKm;
        localLayoutParams.setMargins(i, i, j, j);
        this.nKB.setLayoutParams(localLayoutParams);
        this.nKC.setVisibility(8);
        AppMethodBeat.o(176977);
        return;
        i = 0;
        break;
        j = nKb;
        break label101;
      }
      label178:
      if (i != 0)
      {
        j = nKd;
        localLayoutParams.width = j;
        if (i == 0) {
          break label254;
        }
      }
      label254:
      for (i = nKe;; i = nKc)
      {
        localLayoutParams.height = i;
        i = nKm;
        j = nKm;
        localLayoutParams.setMargins(i, i, j, j);
        this.nKB.setLayoutParams(localLayoutParams);
        this.nKC.setVisibility(0);
        bLC();
        AppMethodBeat.o(176977);
        return;
        j = nKb;
        break;
      }
      label261:
      if (yL(this.nJD))
      {
        this.kke.setVisibility(4);
        if (i != 0)
        {
          j = nKh;
          localLayoutParams.width = j;
          if (i == 0) {
            break label352;
          }
        }
        label352:
        for (i = nKi;; i = nKg)
        {
          localLayoutParams.height = i;
          i = nKm;
          j = nKm;
          localLayoutParams.setMargins(i, i, j, j);
          this.nKB.setLayoutParams(localLayoutParams);
          this.nKC.setVisibility(8);
          AppMethodBeat.o(176977);
          return;
          j = nKf;
          break;
        }
      }
      if (i != 0)
      {
        j = nKh;
        localLayoutParams.width = j;
        if (i == 0) {
          break label435;
        }
      }
      label435:
      for (i = nKi;; i = nKg)
      {
        localLayoutParams.height = i;
        i = nKm;
        j = nKm;
        localLayoutParams.setMargins(i, i, j, j);
        this.nKB.setLayoutParams(localLayoutParams);
        this.nKC.setVisibility(0);
        bLC();
        AppMethodBeat.o(176977);
        return;
        j = nKf;
        break;
      }
    }
    this.kke.setVisibility(8);
    this.nKB.setVisibility(8);
    this.nKC.setVisibility(0);
    bLC();
    AppMethodBeat.o(176977);
  }
  
  private void bLC()
  {
    AppMethodBeat.i(176978);
    Object localObject = (LinearLayout.LayoutParams)this.nKC.getLayoutParams();
    if (yt(this.nJD)) {}
    for (int i = 8388629;; i = 8388627)
    {
      ((LinearLayout.LayoutParams)localObject).gravity = i;
      this.nKC.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if ((!yq(this.nJD)) || (!yr(this.nJD))) {
        break;
      }
      bLF();
      AppMethodBeat.o(176978);
      return;
    }
    if ((yM(this.nJD)) || (yB(this.nJD)))
    {
      this.nKE.setVisibility(8);
      this.nKD.setVisibility(0);
      localObject = (FrameLayout.LayoutParams)this.nKD.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).gravity = 8388629;
      i = nKm;
      int j = nKm;
      ((FrameLayout.LayoutParams)localObject).setMargins(i, i, j, j);
      this.nKD.setLayoutParams((ViewGroup.LayoutParams)localObject);
      AppMethodBeat.o(176978);
      return;
    }
    if (yr(this.nJD))
    {
      this.nKD.setVisibility(8);
      D(true, true);
    }
    AppMethodBeat.o(176978);
  }
  
  private void bLD()
  {
    AppMethodBeat.i(176979);
    LinearLayout.LayoutParams localLayoutParams;
    int i;
    int j;
    if (yt(this.nJD))
    {
      this.kke.setVisibility(0);
      this.nKB.setVisibility(0);
      localLayoutParams = (LinearLayout.LayoutParams)this.nKB.getLayoutParams();
      if ((yq(this.nJD)) && (yy(this.nJD)))
      {
        i = 1;
        if (!yu(this.nJD)) {
          break label262;
        }
        if (!yK(this.nJD)) {
          break label183;
        }
        this.kke.setVisibility(4);
        if (i == 0) {
          break label169;
        }
        j = nKd;
        label101:
        localLayoutParams.width = j;
        if (i == 0) {
          break label176;
        }
        i = nKe;
        label114:
        localLayoutParams.height = i;
        i = nKm;
        j = nKm;
        localLayoutParams.setMargins(i, i, j, j);
        this.nKB.setLayoutParams(localLayoutParams);
        this.nKC.setVisibility(8);
      }
    }
    for (;;)
    {
      bLH();
      AppMethodBeat.o(176979);
      return;
      i = 0;
      break;
      label169:
      j = nKb;
      break label101;
      label176:
      i = nKc;
      break label114;
      label183:
      if (i != 0)
      {
        j = nKd;
        label191:
        localLayoutParams.width = j;
        if (i == 0) {
          break label255;
        }
      }
      label255:
      for (i = nKe;; i = nKc)
      {
        localLayoutParams.height = i;
        i = nKm;
        j = nKm;
        localLayoutParams.setMargins(i, i, j, j);
        this.nKB.setLayoutParams(localLayoutParams);
        this.nKC.setVisibility(0);
        bLE();
        break;
        j = nKb;
        break label191;
      }
      label262:
      if (yL(this.nJD))
      {
        this.kke.setVisibility(4);
        if (i != 0)
        {
          j = nKh;
          label288:
          localLayoutParams.width = j;
          if (i == 0) {
            break label349;
          }
        }
        label349:
        for (i = nKi;; i = nKg)
        {
          localLayoutParams.height = i;
          i = nKm;
          j = nKm;
          localLayoutParams.setMargins(i, i, j, j);
          this.nKB.setLayoutParams(localLayoutParams);
          this.nKC.setVisibility(8);
          break;
          j = nKf;
          break label288;
        }
      }
      if (i != 0)
      {
        j = nKh;
        label364:
        localLayoutParams.width = j;
        if (i == 0) {
          break label428;
        }
      }
      label428:
      for (i = nKi;; i = nKg)
      {
        localLayoutParams.height = i;
        i = nKm;
        j = nKm;
        localLayoutParams.setMargins(i, i, j, j);
        this.nKB.setLayoutParams(localLayoutParams);
        this.nKC.setVisibility(0);
        bLE();
        break;
        j = nKf;
        break label364;
      }
      this.kke.setVisibility(8);
      this.nKB.setVisibility(8);
      this.nKC.setVisibility(0);
      bLE();
    }
  }
  
  private void bLE()
  {
    AppMethodBeat.i(176980);
    Object localObject = (LinearLayout.LayoutParams)this.nKC.getLayoutParams();
    if (yt(this.nJD)) {}
    for (int i = 8388627;; i = 8388629)
    {
      ((LinearLayout.LayoutParams)localObject).gravity = i;
      this.nKC.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if ((!yq(this.nJD)) || (!yr(this.nJD))) {
        break;
      }
      bLG();
      AppMethodBeat.o(176980);
      return;
    }
    if ((yM(this.nJD)) || (yB(this.nJD)))
    {
      this.nKE.setVisibility(8);
      this.nKD.setVisibility(0);
      localObject = (FrameLayout.LayoutParams)this.nKD.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).gravity = 8388629;
      i = nKm;
      int j = nKm;
      ((FrameLayout.LayoutParams)localObject).setMargins(i, i, j, j);
      this.nKD.setLayoutParams((ViewGroup.LayoutParams)localObject);
      AppMethodBeat.o(176980);
      return;
    }
    if (yr(this.nJD))
    {
      this.nKD.setVisibility(8);
      D(false, true);
    }
    AppMethodBeat.o(176980);
  }
  
  private void bLF()
  {
    AppMethodBeat.i(176981);
    int i = D(true, true);
    this.nKD.setVisibility(0);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.nKD.getLayoutParams();
    localLayoutParams.gravity = 8388627;
    int j = nKm;
    localLayoutParams.setMargins(i, j, j, nKm);
    this.nKD.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(176981);
  }
  
  private void bLG()
  {
    AppMethodBeat.i(176982);
    int i = D(false, true);
    this.nKD.setVisibility(0);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.nKD.getLayoutParams();
    localLayoutParams.gravity = 8388629;
    int j = nKm;
    localLayoutParams.setMargins(j, j, i, nKm);
    this.nKD.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(176982);
  }
  
  private boolean bLH()
  {
    AppMethodBeat.i(106451);
    WindowManager.LayoutParams localLayoutParams = (WindowManager.LayoutParams)getLayoutParams();
    int i = localLayoutParams.x;
    int j = localLayoutParams.y;
    if (yk(i))
    {
      i = Math.max(Math.min(i, this.nLi.x), 0);
      j = Math.max(Math.min(j, this.nLi.y), 0);
      int k = yn(i);
      int m = ym(j);
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
  
  private void bLI()
  {
    AppMethodBeat.i(176990);
    int i = 0;
    while (i < this.nLe.size())
    {
      long l = ((BallInfo)this.nLe.get(i)).progress;
      if (l >= 0L) {
        J(i, l);
      }
      i += 1;
    }
    AppMethodBeat.o(176990);
  }
  
  private void bLJ()
  {
    AppMethodBeat.i(217330);
    if (this.nHK) {
      bLK();
    }
    AppMethodBeat.o(217330);
  }
  
  private void bLK()
  {
    AppMethodBeat.i(217332);
    ad.i("MicroMsg.FloatBallView", "alvinluo showByTranslation");
    setNeedTranslateAnimation(false);
    if (getVisibility() == 0)
    {
      ad.i("MicroMsg.FloatBallView", "showByTranslation float ball already show");
      AppMethodBeat.o(217332);
      return;
    }
    if (this.nKx != null)
    {
      boolean bool = yl(((WindowManager.LayoutParams)getLayoutParams()).x);
      this.nKx.P(getCurrentStateWidth(), bool);
    }
    AppMethodBeat.o(217332);
  }
  
  private void bLM()
  {
    AppMethodBeat.i(106468);
    int i;
    int j;
    if (yA(this.nJD)) {
      if (yK(this.nJD))
      {
        i = nKb;
        j = nKm * 2 + i;
        i = nKc + nKm * 2;
      }
    }
    for (;;)
    {
      int n = com.tencent.mm.plugin.ball.f.e.nIp;
      int k = com.tencent.mm.plugin.ball.f.e.nIn;
      int m = com.tencent.mm.plugin.ball.f.e.nIo;
      if ((j != 0) && (i != 0))
      {
        int i1 = getExtendWidth();
        j = this.nLs.x + (j + (n + n) + i1);
        i = this.nLs.y + (i + (k + m));
      }
      for (;;)
      {
        eK(j, i);
        AppMethodBeat.o(106468);
        return;
        if (yL(this.nJD))
        {
          i = nKf;
          j = nKm * 2 + i;
          i = nKg + nKm * 2;
          break;
        }
        if ((yu(this.nJD)) && (yq(this.nJD)) && (yy(this.nJD)))
        {
          i = nKd;
          j = nKm * 2 + i;
          i = nKe + nKk + nKm * 4 + nKs;
          break;
        }
        if ((yv(this.nJD)) && (yq(this.nJD)) && (yy(this.nJD)))
        {
          i = nKh;
          j = nKm * 2 + i;
          i = nKi + nKk + nKm * 4 + nKs;
          break;
        }
        if ((yu(this.nJD)) && ((yq(this.nJD)) || (yr(this.nJD))))
        {
          i = nKb;
          j = nKm * 2 + i;
          i = nKc + nKk + nKm * 4 + nKs;
          break;
        }
        if ((yv(this.nJD)) && ((yq(this.nJD)) || (yr(this.nJD))))
        {
          i = nKf;
          j = nKm * 2 + i;
          i = nKg + nKk + nKm * 4 + nKs;
          break;
        }
        if (yB(this.nJD))
        {
          j = nJF;
          i = nJG;
          break;
        }
        if (yC(this.nJD))
        {
          j = nKp;
          i = nKp;
          break;
        }
        if (yD(this.nJD))
        {
          j = nKq;
          i = nKq;
          break;
        }
        if ((yE(this.nJD)) || (yF(this.nJD)))
        {
          j = nKr;
          i = nKq;
          break;
        }
        if ((yG(this.nJD)) || (yH(this.nJD)))
        {
          j = nJH;
          i = nJI;
          break;
        }
        if ((!yI(this.nJD)) && (!yJ(this.nJD))) {
          break label838;
        }
        i = nJH;
        j = nKj + i;
        i = nJI;
        break;
        if (yK(this.nJD))
        {
          i = nKb;
          j = nKm * 2 + i;
          i = nKc + nKm * 2;
          break;
        }
        if (yL(this.nJD))
        {
          i = nKf;
          j = nKm * 2 + i;
          i = nKg + nKm * 2;
          break;
        }
        if ((yu(this.nJD)) && (ys(this.nJD)))
        {
          i = nKb;
          j = nKm * 2 + i;
          i = nKc + nKm * 2;
          break;
        }
        if ((yv(this.nJD)) && (ys(this.nJD)))
        {
          i = nKf;
          j = nKm * 2 + i;
          i = nKc + nKk + nKm * 4 + nKs;
          break;
        }
        if (yu(this.nJD))
        {
          i = nKb;
          j = nKm * 2 + i;
          i = nKc + nKm * 2;
          break;
        }
        if (yv(this.nJD))
        {
          i = nKf;
          j = nKm * 2 + i;
          i = nKg + nKm * 2;
          break;
        }
        if (!ys(this.nJD)) {
          break label838;
        }
        j = nKp;
        i = nKp;
        break;
        i = 0;
        j = 0;
      }
      label838:
      i = 0;
      j = 0;
    }
  }
  
  private void bLN()
  {
    AppMethodBeat.i(217334);
    if (((int)getAlpha() == 1) && (getVisibility() == 0))
    {
      int i = getResources().getConfiguration().orientation;
      if (i != this.gNO)
      {
        ad.i("MicroMsg.FloatBallView", "alvinluo checkOrientationIfNeed currentOrientation: %d, lastOrientation: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(this.gNO) });
        yi(i);
      }
    }
    AppMethodBeat.o(217334);
  }
  
  private void bLO()
  {
    AppMethodBeat.i(217335);
    try
    {
      WindowManager.LayoutParams localLayoutParams;
      int i;
      if ((this.nLs.x != 0) || (this.nLs.y != 0))
      {
        localLayoutParams = (WindowManager.LayoutParams)getLayoutParams();
        if (!this.nLh) {
          break label101;
        }
        i = 0;
      }
      for (;;)
      {
        int j = localLayoutParams.y;
        int k = this.nLs.y;
        this.nLs.x = 0;
        this.nLs.y = 0;
        this.nLt = 16;
        bLM();
        e(i, j + k, true, false);
        AppMethodBeat.o(217335);
        return;
        label101:
        i = localLayoutParams.x;
        j = this.nLs.x;
        i += j;
      }
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.FloatBallView", localException, "alvinluo resetFloatBallViewSizeAndPosition", new Object[0]);
      AppMethodBeat.o(217335);
    }
  }
  
  private void ca(List<BallInfo> paramList)
  {
    AppMethodBeat.i(106443);
    this.nJE = this.nJD;
    this.nJD = 0;
    if (AppForegroundDelegate.cSQ.cAU) {
      this.nJD |= 0x20;
    }
    List localList = d.bT(d.bR(d.bS(paramList)));
    this.nLe = d.bO(localList);
    int i = d.yb(d.bX(localList));
    boolean bool3 = d.bP(d.bW(paramList));
    if (bool3) {
      this.nJD |= 0x1;
    }
    boolean bool1;
    label136:
    boolean bool2;
    if (i == 1)
    {
      this.nJD |= 0x2;
      this.nLb = d.bU(paramList);
      if ((this.nLb == null) || (this.nLb.state != 4)) {
        break label384;
      }
      bool1 = true;
      if ((this.nLb == null) || (this.nLb.state != 8)) {
        break label389;
      }
      bool2 = true;
      label158:
      if (bool1) {
        this.nJD |= 0x8;
      }
      if (bool2) {
        this.nJD |= 0x10;
      }
      if ((this.nLb != null) && (this.nLb.vd != null)) {
        setVOIPView(this.nLb.vd);
      }
      this.nLc = d.bV(paramList);
      if (this.nLc != null)
      {
        if (this.nLc.state != 32) {
          break label395;
        }
        this.nJD |= 0x100;
      }
    }
    for (;;)
    {
      ad.i("MicroMsg.FloatBallView", ">>> updateFloatBallViewLayoutState, state:[%s => %s], active:%s, passiveCnt:%d, video:%s, audio:%s <<<", new Object[] { Integer.valueOf(this.nJE), Integer.valueOf(this.nJD), Boolean.valueOf(bool3), Integer.valueOf(i), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      AppMethodBeat.o(106443);
      return;
      if (i == 2)
      {
        this.nJD |= 0x4;
        break;
      }
      if (i == 3)
      {
        this.nJD |= 0x40;
        break;
      }
      if (i != 4) {
        break;
      }
      this.nJD |= 0x80;
      break;
      label384:
      bool1 = false;
      break label136;
      label389:
      bool2 = false;
      break label158;
      label395:
      if (this.nLc.state == 64) {
        this.nJD |= 0x200;
      }
    }
  }
  
  private static String cb(List<BallInfo> paramList)
  {
    AppMethodBeat.i(106474);
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramList.size())
    {
      BallInfo localBallInfo = (BallInfo)paramList.get(i);
      localStringBuilder.append(localBallInfo.key).append(localBallInfo.type).append(localBallInfo.dDH).append(localBallInfo.lZt).append(localBallInfo.state).append(localBallInfo.nFX).append(localBallInfo.nFY).append(localBallInfo.progress);
      if ((localBallInfo.type == 9) && (localBallInfo.vd != null)) {
        localStringBuilder.append(localBallInfo.vd.hashCode());
      }
      localStringBuilder.append("|");
      i += 1;
    }
    paramList = ai.ee(localStringBuilder.toString());
    AppMethodBeat.o(106474);
    return paramList;
  }
  
  private void d(boolean paramBoolean, final int paramInt1, final int paramInt2, final int paramInt3, final int paramInt4)
  {
    AppMethodBeat.i(106464);
    ad.i("MicroMsg.FloatBallView", "start StickyAnimation, stickToLeft:%s, startPositionY: %d, targetPositionY: %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2), Integer.valueOf(paramInt4) });
    if ((this.nKw != null) && (this.nKw.isRunning()))
    {
      ad.i("MicroMsg.FloatBallView", "cancel StickyAnimation");
      this.nKw.cancel();
    }
    this.nKw = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.nKw.setInterpolator(new AccelerateDecelerateInterpolator());
    this.nKw.setDuration(100L);
    this.nKw.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
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
    this.nKw.addListener(new AnimatorListenerAdapter()
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
    this.nKw.start();
    AppMethodBeat.o(106464);
  }
  
  private void eK(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(217333);
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
        ad.i("MicroMsg.FloatBallView", "updateFloatBallViewSize, width:%s, height:%s", new Object[] { Integer.valueOf(localLayoutParams.width), Integer.valueOf(localLayoutParams.height) });
        Iterator localIterator = this.cAT.iterator();
        while (localIterator.hasNext()) {
          ((com.tencent.mm.plugin.ball.d.b)localIterator.next()).a(localLayoutParams.x, localLayoutParams.y, localLayoutParams.height, this.nLv, this.nLh);
        }
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
      AppMethodBeat.o(217333);
    }
  }
  
  private void f(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(217329);
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
        AppMethodBeat.o(217329);
        return;
      }
      catch (Throwable localThrowable)
      {
        ad.printErrStackTrace("MicroMsg.FloatBallView", localThrowable, "updateBallPosition fail", new Object[0]);
      }
    }
    AppMethodBeat.o(217329);
  }
  
  private void f(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(217325);
    if ((this.nLv == paramBoolean1) && (this.nLw == paramBoolean2) && (this.nLu == paramBoolean3) && (this.nLx != 0) && (this.nLx == this.nJD))
    {
      ad.d("MicroMsg.FloatBallView", "<<< updateFloatBallViewLayout, ignore layout %b %b;%b %b; %b %b; %d %d", new Object[] { Boolean.valueOf(this.nLC), Boolean.valueOf(paramBoolean1), Boolean.valueOf(this.nLw), Boolean.valueOf(paramBoolean2), Boolean.valueOf(this.nLu), Boolean.valueOf(paramBoolean3), Integer.valueOf(this.nLx), Integer.valueOf(this.nJD) });
      AppMethodBeat.o(217325);
      return;
    }
    ad.i("MicroMsg.FloatBallView", ">>> updateFloatBallViewLayout, isSettled:%s, isDockLeft:%s, isManual:%s, lastLayoutState:%s, currentLayoutState:%s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3), Integer.valueOf(this.nLx), Integer.valueOf(this.nJD) });
    this.nLu = paramBoolean3;
    this.nLv = paramBoolean1;
    this.nLw = paramBoolean2;
    this.nLx = this.nJD;
    bLM();
    C(paramBoolean1, paramBoolean2);
    AppMethodBeat.o(217325);
  }
  
  private int getAppBrandVoipBallInfoIndex()
  {
    AppMethodBeat.i(217328);
    if (d.h(this.nLe))
    {
      int i = 0;
      while (i < this.nLe.size())
      {
        BallInfo localBallInfo = (BallInfo)this.nLe.get(i);
        if ((localBallInfo != null) && (localBallInfo.type == 17))
        {
          AppMethodBeat.o(217328);
          return i;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(217328);
    return 0;
  }
  
  private int getCurrentStateHeight()
  {
    AppMethodBeat.i(176991);
    int j = this.nJD;
    ad.v("MicroMsg.FloatBallView", "getStateHeight state: %d", new Object[] { Integer.valueOf(j) });
    int i = getHeight();
    if (yK(j)) {
      i = nKc + nKm * 2;
    }
    for (;;)
    {
      j = com.tencent.mm.plugin.ball.f.e.nIn;
      int k = com.tencent.mm.plugin.ball.f.e.nIo;
      AppMethodBeat.o(176991);
      return i + j + k;
      if (yL(j)) {
        i = nKg + nKm * 2;
      } else if ((yu(j)) && ((yq(j)) || (yr(j)))) {
        i = nKe + nKk + nKm * 4 + nKs;
      } else if ((yv(j)) && ((yq(j)) || (yr(j)))) {
        i = nKi + nKk + nKm * 4 + nKs;
      } else if (yB(j)) {
        i = nJG;
      } else if (yC(j)) {
        i = nJK;
      } else if (yD(j)) {
        i = nJM;
      } else if ((yE(j)) || (yF(j))) {
        i = nJO;
      } else if ((yG(j)) || (yH(j)) || (yI(j)) || (yJ(j))) {
        i = nJI;
      }
    }
  }
  
  private int getExtendWidth()
  {
    AppMethodBeat.i(106469);
    if (!this.nLn)
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
    if (((this.nLh) && (i == 1)) || ((!this.nLh) && (i == 3)))
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
    if (!this.nLh) {
      i = this.nLi.x - getCurrentStateWidth();
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
  
  private static boolean yA(int paramInt)
  {
    return (paramInt & 0x20) != 0;
  }
  
  private static boolean yB(int paramInt)
  {
    AppMethodBeat.i(176996);
    if ((yq(paramInt)) && (!yt(paramInt)) && (!yr(paramInt)))
    {
      AppMethodBeat.o(176996);
      return true;
    }
    AppMethodBeat.o(176996);
    return false;
  }
  
  private static boolean yC(int paramInt)
  {
    AppMethodBeat.i(176997);
    if ((yw(paramInt)) && (!yt(paramInt)) && (!yq(paramInt)))
    {
      AppMethodBeat.o(176997);
      return true;
    }
    AppMethodBeat.o(176997);
    return false;
  }
  
  private static boolean yD(int paramInt)
  {
    AppMethodBeat.i(176998);
    if ((yx(paramInt)) && (!yt(paramInt)) && (!yq(paramInt)))
    {
      AppMethodBeat.o(176998);
      return true;
    }
    AppMethodBeat.o(176998);
    return false;
  }
  
  private static boolean yE(int paramInt)
  {
    AppMethodBeat.i(176999);
    if ((yy(paramInt)) && (!yt(paramInt)) && (!yq(paramInt)))
    {
      AppMethodBeat.o(176999);
      return true;
    }
    AppMethodBeat.o(176999);
    return false;
  }
  
  private static boolean yF(int paramInt)
  {
    AppMethodBeat.i(217340);
    if ((yz(paramInt)) && (!yt(paramInt)) && (!yq(paramInt)))
    {
      AppMethodBeat.o(217340);
      return true;
    }
    AppMethodBeat.o(217340);
    return false;
  }
  
  private static boolean yG(int paramInt)
  {
    AppMethodBeat.i(177000);
    if ((yw(paramInt)) && (yq(paramInt)) && (!yt(paramInt)))
    {
      AppMethodBeat.o(177000);
      return true;
    }
    AppMethodBeat.o(177000);
    return false;
  }
  
  private static boolean yH(int paramInt)
  {
    AppMethodBeat.i(177001);
    if ((yx(paramInt)) && (yq(paramInt)) && (!yt(paramInt)))
    {
      AppMethodBeat.o(177001);
      return true;
    }
    AppMethodBeat.o(177001);
    return false;
  }
  
  private static boolean yI(int paramInt)
  {
    AppMethodBeat.i(177002);
    if ((yy(paramInt)) && (yq(paramInt)) && (!yt(paramInt)))
    {
      AppMethodBeat.o(177002);
      return true;
    }
    AppMethodBeat.o(177002);
    return false;
  }
  
  private static boolean yJ(int paramInt)
  {
    AppMethodBeat.i(217341);
    if ((yz(paramInt)) && (yq(paramInt)) && (!yt(paramInt)))
    {
      AppMethodBeat.o(217341);
      return true;
    }
    AppMethodBeat.o(217341);
    return false;
  }
  
  private static boolean yK(int paramInt)
  {
    AppMethodBeat.i(177003);
    if ((yu(paramInt)) && (!yq(paramInt)) && (!yr(paramInt)))
    {
      AppMethodBeat.o(177003);
      return true;
    }
    AppMethodBeat.o(177003);
    return false;
  }
  
  private static boolean yL(int paramInt)
  {
    AppMethodBeat.i(177004);
    if ((yv(paramInt)) && (!yq(paramInt)) && (!yr(paramInt)))
    {
      AppMethodBeat.o(177004);
      return true;
    }
    AppMethodBeat.o(177004);
    return false;
  }
  
  private static boolean yM(int paramInt)
  {
    AppMethodBeat.i(177005);
    if ((yq(paramInt)) && (yt(paramInt)) && (!yr(paramInt)))
    {
      AppMethodBeat.o(177005);
      return true;
    }
    AppMethodBeat.o(177005);
    return false;
  }
  
  private void yi(int paramInt)
  {
    AppMethodBeat.i(217324);
    Point localPoint1 = this.nLi;
    this.nLi = al.ci(getContext());
    Point localPoint2 = this.nLi;
    Object localObject;
    int i;
    int j;
    int k;
    if (localPoint1 != null)
    {
      localObject = localPoint1;
      ad.i("MicroMsg.FloatBallView", "processOrientationChanged, screenResolution: %s, lastResolution: %s", new Object[] { localPoint2, localObject });
      if ((this.gNO != paramInt) || ((localPoint1 != null) && ((localPoint1.x != this.nLi.x) || (localPoint1.y != this.nLi.y))))
      {
        this.gNO = paramInt;
        this.nLn = true;
        localObject = (WindowManager.LayoutParams)getLayoutParams();
        paramInt = ((WindowManager.LayoutParams)localObject).x;
        i = (int)(this.nLi.y * this.nLl);
        paramInt = Math.max(Math.min(paramInt, this.nLi.x), 0);
        i = Math.max(Math.min(i, this.nLi.y), 0);
        j = getTargetPositionXWhenOrientationChanged();
        k = ym(i);
        if (j != 0) {
          break label294;
        }
      }
    }
    label294:
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.FloatBallView", "processOrientationChanged, layoutParams.x: %s, layoutParams.y: %s, stickToLeft:%s, startSticky:[%s, %s]=>[%s, %s]", new Object[] { Integer.valueOf(((WindowManager.LayoutParams)localObject).x), Integer.valueOf(((WindowManager.LayoutParams)localObject).y), Boolean.valueOf(bool), Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
      d(bool, paramInt, i, j, k);
      AppMethodBeat.o(217324);
      return;
      localObject = "null";
      break;
    }
  }
  
  private boolean yk(int paramInt)
  {
    AppMethodBeat.i(176987);
    if (getCurrentStateWidth() + paramInt != this.nLi.x)
    {
      AppMethodBeat.o(176987);
      return true;
    }
    AppMethodBeat.o(176987);
    return false;
  }
  
  private static int ym(int paramInt)
  {
    int i;
    if (paramInt < com.tencent.mm.plugin.ball.f.e.nIu) {
      i = com.tencent.mm.plugin.ball.f.e.nIu;
    }
    do
    {
      return i;
      i = paramInt;
    } while (paramInt <= com.tencent.mm.plugin.ball.f.e.nIv);
    return com.tencent.mm.plugin.ball.f.e.nIv;
  }
  
  private int yn(int paramInt)
  {
    AppMethodBeat.i(106465);
    int i = 0;
    if (!yl(paramInt)) {
      i = this.nLi.x - getCurrentStateWidth();
    }
    AppMethodBeat.o(106465);
    return i;
  }
  
  private static int yo(int paramInt)
  {
    AppMethodBeat.i(217338);
    int j = 0;
    int i;
    if (yK(paramInt)) {
      i = nKb;
    }
    for (;;)
    {
      AppMethodBeat.o(217338);
      return i;
      if (!yL(paramInt))
      {
        if ((yu(paramInt)) && (yq(paramInt)) && (yy(paramInt)))
        {
          i = nKd;
          continue;
        }
        if ((yv(paramInt)) && (yq(paramInt)) && (yy(paramInt)))
        {
          i = nKh;
          continue;
        }
        if ((yu(paramInt)) && ((yq(paramInt)) || (yr(paramInt))))
        {
          i = nKb;
          continue;
        }
        i = j;
        if (!yv(paramInt)) {
          continue;
        }
        if (!yq(paramInt))
        {
          i = j;
          if (!yr(paramInt)) {
            continue;
          }
        }
      }
      i = nKf;
    }
  }
  
  private static int yp(int paramInt)
  {
    AppMethodBeat.i(217339);
    int j = 0;
    int i;
    if (yK(paramInt)) {
      i = nKc;
    }
    for (;;)
    {
      AppMethodBeat.o(217339);
      return i;
      if (!yL(paramInt))
      {
        if ((yu(paramInt)) && (yq(paramInt)) && (yy(paramInt)))
        {
          i = nKe;
          continue;
        }
        if ((yv(paramInt)) && (yq(paramInt)) && (yy(paramInt)))
        {
          i = nKi;
          continue;
        }
        if ((yu(paramInt)) && ((yq(paramInt)) || (yr(paramInt))))
        {
          i = nKc;
          continue;
        }
        i = j;
        if (!yv(paramInt)) {
          continue;
        }
        if (!yq(paramInt))
        {
          i = j;
          if (!yr(paramInt)) {
            continue;
          }
        }
      }
      i = nKg;
    }
  }
  
  private static boolean yq(int paramInt)
  {
    return (paramInt & 0x1) != 0;
  }
  
  private static boolean yr(int paramInt)
  {
    AppMethodBeat.i(176994);
    if ((yw(paramInt)) || (yx(paramInt)) || (yy(paramInt)) || (yz(paramInt)))
    {
      AppMethodBeat.o(176994);
      return true;
    }
    AppMethodBeat.o(176994);
    return false;
  }
  
  public static boolean ys(int paramInt)
  {
    return ((paramInt & 0x100) != 0) || ((paramInt & 0x200) != 0);
  }
  
  private static boolean yt(int paramInt)
  {
    AppMethodBeat.i(176995);
    if ((yu(paramInt)) || (yv(paramInt)))
    {
      AppMethodBeat.o(176995);
      return true;
    }
    AppMethodBeat.o(176995);
    return false;
  }
  
  private static boolean yu(int paramInt)
  {
    return (paramInt & 0x8) != 0;
  }
  
  private static boolean yv(int paramInt)
  {
    return (paramInt & 0x10) != 0;
  }
  
  private static boolean yw(int paramInt)
  {
    return (paramInt & 0x2) != 0;
  }
  
  private static boolean yx(int paramInt)
  {
    return (paramInt & 0x4) != 0;
  }
  
  private static boolean yy(int paramInt)
  {
    return (paramInt & 0x40) != 0;
  }
  
  private static boolean yz(int paramInt)
  {
    return (paramInt & 0x80) != 0;
  }
  
  public final void a(List<BallInfo> paramList, BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106442);
    paramBallInfo = cb(paramList);
    if (bt.lQ(paramBallInfo, this.nLd))
    {
      ad.d("MicroMsg.FloatBallView", "<<< onFloatBallInfoChanged, ignore refresh");
      AppMethodBeat.o(106442);
      return;
    }
    ad.i("MicroMsg.FloatBallView", ">>> onFloatBallInfoChanged, ballInfoList:%s", new Object[] { paramList });
    this.nLd = paramBallInfo;
    ca(paramList);
    bLI();
    boolean bool = yl(((WindowManager.LayoutParams)getLayoutParams()).x);
    f(true, bool, false);
    a(true, bool, false, this.nJD);
    bLJ();
    AppMethodBeat.o(106442);
  }
  
  public final void b(boolean paramBoolean, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(184624);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.dw(paramBoolean);
    localb.bd(paramAnimatorListenerAdapter);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ball/view/FloatBallView", "com/tencent/mm/plugin/ball/view/FloatBallView", "hide", "(ZLandroid/animation/AnimatorListenerAdapter;)V", this, localb.ahq());
    if (getVisibility() == 8)
    {
      ad.i("MicroMsg.FloatBallView", "float ball already hide");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ball/view/FloatBallView", "com/tencent/mm/plugin/ball/view/FloatBallView", "hide", "(ZLandroid/animation/AnimatorListenerAdapter;)V");
      AppMethodBeat.o(184624);
      return;
    }
    if ((paramBoolean) && (this.nKx != null))
    {
      ad.i("MicroMsg.FloatBallView", "hide with animation");
      this.nKx.b(paramAnimatorListenerAdapter);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ball/view/FloatBallView", "com/tencent/mm/plugin/ball/view/FloatBallView", "hide", "(ZLandroid/animation/AnimatorListenerAdapter;)V");
      AppMethodBeat.o(184624);
      return;
      ad.i("MicroMsg.FloatBallView", "hide without animation");
      setVisibility(8);
      bLO();
    }
  }
  
  public final void bLL()
  {
    AppMethodBeat.i(184622);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.dw(false);
    localb.bd(null);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ball/view/FloatBallView", "com/tencent/mm/plugin/ball/view/FloatBallView", "show", "(ZLandroid/animation/AnimatorListenerAdapter;)V", this, localb.ahq());
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
    if ((paramBoolean1) && (this.nKx != null))
    {
      ad.i("MicroMsg.FloatBallView", "show with animation");
      this.nKx.a(paramAnimatorListenerAdapter);
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
    f(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
    AppMethodBeat.o(106456);
  }
  
  public final void g(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(106457);
    this.nLh = yl(paramInt1);
    a(paramBoolean1, this.nLh, paramBoolean2, this.nJD);
    f(paramBoolean1, this.nLh, paramBoolean2);
    Q(paramInt2, paramBoolean1);
    ad.i("MicroMsg.FloatBallView", "notifyBallPositionChanged, x:%s, y:%s, isSettled:%s, isManual:%s, isDockLeft:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(this.nLh) });
    Iterator localIterator = this.cAT.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.plugin.ball.d.b)localIterator.next()).a(paramInt1, paramInt2, getCurrentStateHeight(), paramBoolean1, this.nLh);
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
    if (this.nLh)
    {
      if (yu(this.nJD))
      {
        localObject = new Point(((WindowManager.LayoutParams)localObject).x, ((WindowManager.LayoutParams)localObject).y + com.tencent.mm.plugin.ball.f.e.nIn + nKc);
        AppMethodBeat.o(106470);
        return localObject;
      }
      if (yv(this.nJD))
      {
        localObject = new Point(((WindowManager.LayoutParams)localObject).x, ((WindowManager.LayoutParams)localObject).y + com.tencent.mm.plugin.ball.f.e.nIn + nKg);
        AppMethodBeat.o(106470);
        return localObject;
      }
      localObject = new Point(((WindowManager.LayoutParams)localObject).x, ((WindowManager.LayoutParams)localObject).y + com.tencent.mm.plugin.ball.f.e.nIn);
      AppMethodBeat.o(106470);
      return localObject;
    }
    if (yu(this.nJD))
    {
      localObject = new Point(((WindowManager.LayoutParams)localObject).x + com.tencent.mm.plugin.ball.f.e.nIp, ((WindowManager.LayoutParams)localObject).y + com.tencent.mm.plugin.ball.f.e.nIn + nKc);
      AppMethodBeat.o(106470);
      return localObject;
    }
    if (yv(this.nJD))
    {
      localObject = new Point(((WindowManager.LayoutParams)localObject).x + com.tencent.mm.plugin.ball.f.e.nIp, ((WindowManager.LayoutParams)localObject).y + com.tencent.mm.plugin.ball.f.e.nIn + nKg);
      AppMethodBeat.o(106470);
      return localObject;
    }
    localObject = new Point(((WindowManager.LayoutParams)localObject).x + com.tencent.mm.plugin.ball.f.e.nIp, ((WindowManager.LayoutParams)localObject).y + com.tencent.mm.plugin.ball.f.e.nIn);
    AppMethodBeat.o(106470);
    return localObject;
  }
  
  public int getCurrentStateWidth()
  {
    AppMethodBeat.i(106467);
    int j = this.nJD;
    ad.v("MicroMsg.FloatBallView", "getStateWidth state: %d", new Object[] { Integer.valueOf(j) });
    int i = getWidth();
    if ((!yA(j)) && (ys(j)))
    {
      if (yu(j)) {
        i = nKb + nKm * 2;
      }
      for (;;)
      {
        j = com.tencent.mm.plugin.ball.f.e.nIp;
        AppMethodBeat.o(106467);
        return i + j;
        if (yv(j)) {
          i = nKf + nKm * 2;
        } else {
          i = nJJ;
        }
      }
    }
    if (yK(j)) {
      i = nKb + nKm * 2;
    }
    for (;;)
    {
      j = com.tencent.mm.plugin.ball.f.e.nIp;
      AppMethodBeat.o(106467);
      return i + j;
      if (yL(j)) {
        i = nKf + nKm * 2;
      } else if ((yu(j)) && (yq(j)) && (yy(j))) {
        i = nKd + nKm * 2;
      } else if ((yv(j)) && (yq(j)) && (yy(j))) {
        i = nKh + nKm * 2;
      } else if ((yu(j)) && ((yq(j)) || (yr(j)))) {
        i = nKb + nKm * 2;
      } else if ((yv(j)) && ((yq(j)) || (yr(j)))) {
        i = nKf + nKm * 2;
      } else if (yB(j)) {
        i = nJF;
      } else if (yC(j)) {
        i = nJJ;
      } else if (yD(j)) {
        i = nJL;
      } else if ((yE(j)) || (yF(j))) {
        i = nJN;
      } else if ((yG(j)) || (yH(j))) {
        i = nJH;
      } else if ((yI(j)) || (yJ(j))) {
        i = nJH + nKj;
      }
    }
  }
  
  public float getPosYPercentOfScreen()
  {
    return this.nLl;
  }
  
  public int getPositionY()
  {
    return this.nLm;
  }
  
  public Point getVoipAudioViewSize()
  {
    AppMethodBeat.i(217337);
    int i = this.nJD & 0xFFFFFFF7 | 0x10;
    Point localPoint = new Point(yo(i), yp(i));
    AppMethodBeat.o(217337);
    return localPoint;
  }
  
  public Point getVoipVideoViewSize()
  {
    AppMethodBeat.i(217336);
    int i = this.nJD & 0xFFFFFFEF | 0x8;
    Point localPoint = new Point(yo(i), yp(i));
    AppMethodBeat.o(217336);
    return localPoint;
  }
  
  public final void iS(boolean paramBoolean)
  {
    AppMethodBeat.i(176992);
    ad.i("MicroMsg.FloatBallView", "markWechatInForeground, visibility:%s, inForeground:%s", new Object[] { Integer.valueOf(getVisibility()), Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
      this.nJD |= 0x20;
    }
    for (;;)
    {
      f(this.nLv, this.nLw, this.nLu);
      AppMethodBeat.o(176992);
      return;
      this.nJD &= 0xFFFFFFDF;
      if ((yt(this.nJD)) || (ys(this.nJD)))
      {
        bLL();
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
    ad.i("MicroMsg.FloatBallView", "onConfigurationChanged, orientation:%d, lastOrientation: %d", new Object[] { Integer.valueOf(paramConfiguration.orientation), Integer.valueOf(this.gNO) });
    yi(paramConfiguration.orientation);
    int i = paramConfiguration.orientation;
    paramConfiguration = this.cAT.iterator();
    while (paramConfiguration.hasNext()) {
      ((com.tencent.mm.plugin.ball.d.b)paramConfiguration.next()).nL(i);
    }
    AppMethodBeat.o(106441);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(106440);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ball/view/FloatBallView", "com/tencent/mm/plugin/ball/view/FloatBallView", "onDetachedFromWindow", "()V", this);
    super.onDetachedFromWindow();
    if (this.nKw != null)
    {
      this.nKw.cancel();
      this.nKw = null;
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
    if (!this.nLg)
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
      this.nLy = false;
      this.nLj.x = paramMotionEvent.getRawX();
      this.nLj.y = paramMotionEvent.getRawY();
      paramMotionEvent = (WindowManager.LayoutParams)getLayoutParams();
      this.nLk.x = paramMotionEvent.x;
      this.nLk.y = paramMotionEvent.y;
      a(true, this.nLh, true, this.nJD);
      if (this.nLn) {
        f(true, this.nLh, true);
      }
      this.nEZ = false;
      if ((yA(this.nJD)) && (!yK(this.nJD)) && (!yL(this.nJD)))
      {
        this.nLz.postDelayed(this.nLA, this.nKu);
        continue;
        if (this.nEZ)
        {
          M(paramMotionEvent);
        }
        else
        {
          if ((!this.nLy) && (E(paramMotionEvent)))
          {
            this.nLz.removeCallbacks(this.nLA);
            this.nLy = true;
            i = this.nLk.x;
            i = this.nLk.y;
            localIterator = this.cAT.iterator();
            while (localIterator.hasNext()) {
              ((com.tencent.mm.plugin.ball.d.b)localIterator.next()).bKj();
            }
          }
          if (this.nLy)
          {
            e(F(paramMotionEvent), G(paramMotionEvent), false, true);
            continue;
            if (this.nEZ)
            {
              a(true, this.nLh, false, this.nJD);
              if (this.nLn) {
                f(true, this.nLh, false);
              }
              M(paramMotionEvent);
            }
            else
            {
              this.nLz.removeCallbacks(this.nLA);
              if ((this.nLy) || (E(paramMotionEvent))) {
                break;
              }
              a(true, this.nLh, false, this.nJD);
              if (this.nLn) {
                f(true, this.nLh, false);
              }
              e(this.nLk.x, this.nLk.y, true, false);
              if (this.nLo)
              {
                float f1 = this.nLj.x;
                float f2 = this.nLj.y;
                long l = System.currentTimeMillis();
                if (l > this.mYb + 800L)
                {
                  this.mYb = l;
                  if (d.r(this.nKz, (int)f1, (int)f2))
                  {
                    ad.i("MicroMsg.FloatBallView", "notifyBallClickedIfNeed, you clicked voip");
                    if ((this.nLb != null) && (g.ab(c.class) != null))
                    {
                      this.nLb.nFZ.opType = 3;
                      ((c)g.ab(c.class)).n(this.nLb);
                    }
                    this.nKz.callOnClick();
                  }
                  else if ((yL(this.nJD)) || (yK(this.nJD)))
                  {
                    ad.i("MicroMsg.FloatBallView", "notifyBallClickedIfNeed, ignore click");
                  }
                  else if (yA(this.nJD))
                  {
                    ad.i("MicroMsg.FloatBallView", "notifyBallClickedIfNeed, wechat in foreground");
                    paramMotionEvent = this.cAT.iterator();
                    while (paramMotionEvent.hasNext()) {
                      ((com.tencent.mm.plugin.ball.d.b)paramMotionEvent.next()).bKh();
                    }
                  }
                  else if ((this.nLc != null) && (g.ab(c.class) != null))
                  {
                    ad.i("MicroMsg.FloatBallView", "notifyBallClickedIfNeed, you clicked appbrand voip");
                    this.nLc.nFZ.opType = 3;
                    ((c)g.ab(c.class)).n(this.nLc);
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
    a(false, this.nLh, false, this.nJD);
    if (this.nLy)
    {
      this.nLy = false;
      localIterator = this.cAT.iterator();
      while (localIterator.hasNext()) {
        ((com.tencent.mm.plugin.ball.d.b)localIterator.next()).bKk();
      }
    }
    int i = F(paramMotionEvent);
    int j = G(paramMotionEvent);
    int k = yn(i);
    int m = ym(j);
    if (k == 0) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.FloatBallView", "onTouchEvent, stickToLeft:%s, startSticky:[%s, %s]=>[%s, %s]", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m) });
      d(bool, i, j, k, m);
      break;
    }
  }
  
  public void setAlpha(float paramFloat)
  {
    AppMethodBeat.i(106473);
    super.setAlpha(paramFloat);
    ad.m("MicroMsg.FloatBallView", "setAlpha:%s", new Object[] { Float.valueOf(paramFloat) });
    bLN();
    AppMethodBeat.o(106473);
  }
  
  public void setEnableClick(boolean paramBoolean)
  {
    AppMethodBeat.i(217331);
    ad.d("MicroMsg.FloatBallView", "alvinluo setEnableClick enable: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.nLo = paramBoolean;
    AppMethodBeat.o(217331);
  }
  
  public void setFloatBallAlpha(final float paramFloat)
  {
    AppMethodBeat.i(106460);
    com.tencent.mm.plugin.ball.b.b localb = this.nKx;
    if ((localb.bJR()) || (localb.bJS())) {}
    for (int i = 1; i != 0; i = 0)
    {
      ad.m("MicroMsg.FloatBallView", "setFloatBallAlpha later, alpha:%s", new Object[] { Float.valueOf(paramFloat) });
      localb = this.nKx;
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
      localb.nFR.add(local2);
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
    if (paramView == this.nKy)
    {
      AppMethodBeat.o(106471);
      return;
    }
    this.nKD.removeAllViews();
    this.nKy = paramView;
    if (this.nKy != null)
    {
      paramView = new FrameLayout.LayoutParams(-1, -1);
      paramView.gravity = 17;
      this.nKD.addView(this.nKy, paramView);
    }
    AppMethodBeat.o(106471);
  }
  
  public void setNeedTranslateAnimation(boolean paramBoolean)
  {
    this.nHK = paramBoolean;
  }
  
  public void setVOIPView(View paramView)
  {
    AppMethodBeat.i(176993);
    if (paramView == this.nKz)
    {
      AppMethodBeat.o(176993);
      return;
    }
    if ((paramView.getParent() != null) && ((paramView.getParent() instanceof ViewGroup)))
    {
      ad.i("MicroMsg.FloatBallView", "setVOIPView remove from parent first");
      ((ViewGroup)paramView.getParent()).removeView(paramView);
    }
    this.nKB.removeAllViews();
    this.nKz = paramView;
    if (this.nKz != null)
    {
      paramView = new FrameLayout.LayoutParams(-1, -1);
      paramView.gravity = 17;
      this.nKB.addView(this.nKz, paramView);
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
      this.nLg = false;
      ad.m("MicroMsg.FloatBallView", "setVisibility:%s, alphaInt:%s, disableTouch", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      AppMethodBeat.o(106472);
      return;
    }
    if (i == 1)
    {
      this.nLg = true;
      ad.m("MicroMsg.FloatBallView", "setVisibility:%s, alphaInt:%s, enableTouch", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      bLN();
    }
    AppMethodBeat.o(106472);
  }
  
  public final void yj(int paramInt)
  {
    AppMethodBeat.i(217327);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.nKA.getLayoutParams();
    localLayoutParams.gravity = paramInt;
    this.nKA.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(217327);
  }
  
  public final boolean yl(int paramInt)
  {
    AppMethodBeat.i(106459);
    if (getCurrentStateWidth() / 2 + paramInt <= this.nLi.x / 2)
    {
      AppMethodBeat.o(106459);
      return true;
    }
    AppMethodBeat.o(106459);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.view.FloatBallView
 * JD-Core Version:    0.7.0.1
 */