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
import com.tencent.mm.plugin.ball.f.e;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.model.BallInfo.a;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.aw;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArraySet;

public class FloatBallView
  extends FrameLayout
  implements com.tencent.mm.plugin.ball.c.d
{
  public static final int paA;
  private static final int paB;
  private static final int paC;
  private static final int paD;
  public static final int paE;
  public static final int paF;
  private static final int paG;
  private static final int paH;
  private static final int paI;
  private static final int paJ;
  private static final int paK;
  private static final int paL;
  private static final int paM;
  private static final int paN;
  private static final int paO;
  private static final int paP;
  public static final int paQ;
  private static final int pac;
  private static final int pad;
  private static final int pae;
  private static final int paf;
  private static final int pag;
  private static final int pah;
  private static final int pai;
  private static final int paj;
  private static final int pak;
  private static final int pal;
  private static final int pam;
  private static final int pan;
  private static final int pao;
  private static final int pap;
  private static final int paq;
  private static final int par;
  private static final int pas;
  private static final int pat;
  private static final int pau;
  private static final int pav;
  private static final int paw;
  private static final int pax;
  private static final int pay;
  private static final int paz;
  private Handler cPw;
  private boolean hbN;
  private long lastClickTime;
  private int lastOrientation;
  public Set<com.tencent.mm.plugin.ball.c.g> listeners;
  private View lrc;
  private boolean oVp;
  private Point oWm;
  public boolean oYj;
  public int oZZ;
  private int paR;
  private int paS;
  private Vibrator paT;
  private ValueAnimator paU;
  public com.tencent.mm.plugin.ball.b.b paV;
  private View paW;
  private LinearLayout paX;
  public FrameLayout paY;
  private FrameLayout paZ;
  private int paa;
  private int pab;
  private LayoutTransition pbA;
  private boolean pbB;
  public boolean pbC;
  private Point pbD;
  private PointF pbE;
  private Point pbF;
  private float pbG;
  private int pbH;
  private boolean pbI;
  private boolean pbJ;
  private boolean pbK;
  private BallInfo pbL;
  private BallInfo pbM;
  private Point pbN;
  private int pbO;
  private boolean pbP;
  public int pbQ;
  private boolean pbR;
  private boolean pbS;
  private boolean pbT;
  private int pbU;
  private Handler pbV;
  private Runnable pbW;
  private boolean pbX;
  private boolean pbY;
  private boolean pbZ;
  private FrameLayout pba;
  private FrameLayout pbb;
  private CircleAnimateView pbc;
  private CircleAnimateView pbd;
  private CircleAnimateView pbe;
  private CircleAnimateView pbf;
  private Drawable pbg;
  private Drawable pbh;
  private Drawable pbi;
  private Drawable pbj;
  private Drawable pbk;
  private Drawable pbl;
  private Drawable pbm;
  private Drawable pbn;
  private Drawable pbo;
  private Drawable pbp;
  private Drawable pbq;
  private Drawable pbr;
  private Drawable pbs;
  private Drawable pbt;
  private Drawable pbu;
  private Drawable pbv;
  private Drawable pbw;
  private Drawable pbx;
  private String pby;
  private List<BallInfo> pbz;
  private int pca;
  public View vk;
  private WindowManager windowManager;
  
  static
  {
    AppMethodBeat.i(106478);
    pac = com.tencent.mm.cb.a.aH(MMApplicationContext.getContext(), 2131166389);
    pad = com.tencent.mm.cb.a.aH(MMApplicationContext.getContext(), 2131166386);
    pae = com.tencent.mm.cb.a.aH(MMApplicationContext.getContext(), 2131166388);
    paf = com.tencent.mm.cb.a.aH(MMApplicationContext.getContext(), 2131166387);
    pag = com.tencent.mm.cb.a.aH(MMApplicationContext.getContext(), 2131166413);
    pah = com.tencent.mm.cb.a.aH(MMApplicationContext.getContext(), 2131166412);
    pai = com.tencent.mm.cb.a.aH(MMApplicationContext.getContext(), 2131166426);
    paj = com.tencent.mm.cb.a.aH(MMApplicationContext.getContext(), 2131166425);
    pak = com.tencent.mm.cb.a.aH(MMApplicationContext.getContext(), 2131166422);
    pal = com.tencent.mm.cb.a.aH(MMApplicationContext.getContext(), 2131166421);
    pam = com.tencent.mm.cb.a.aH(MMApplicationContext.getContext(), 2131166434);
    pan = com.tencent.mm.cb.a.aH(MMApplicationContext.getContext(), 2131166433);
    pao = com.tencent.mm.cb.a.aH(MMApplicationContext.getContext(), 2131166437);
    pap = com.tencent.mm.cb.a.aH(MMApplicationContext.getContext(), 2131166435);
    paq = com.tencent.mm.cb.a.aH(MMApplicationContext.getContext(), 2131166438);
    par = com.tencent.mm.cb.a.aH(MMApplicationContext.getContext(), 2131166436);
    pas = com.tencent.mm.cb.a.aH(MMApplicationContext.getContext(), 2131166428);
    pat = com.tencent.mm.cb.a.aH(MMApplicationContext.getContext(), 2131166427);
    pau = com.tencent.mm.cb.a.aH(MMApplicationContext.getContext(), 2131166431);
    pav = com.tencent.mm.cb.a.aH(MMApplicationContext.getContext(), 2131166429);
    paw = com.tencent.mm.cb.a.aH(MMApplicationContext.getContext(), 2131166432);
    pax = com.tencent.mm.cb.a.aH(MMApplicationContext.getContext(), 2131166430);
    pay = com.tencent.mm.cb.a.aH(MMApplicationContext.getContext(), 2131166448);
    paz = com.tencent.mm.cb.a.aH(MMApplicationContext.getContext(), 2131166446);
    paA = com.tencent.mm.cb.a.aH(MMApplicationContext.getContext(), 2131166449);
    paB = com.tencent.mm.cb.a.aH(MMApplicationContext.getContext(), 2131166447);
    paC = com.tencent.mm.cb.a.aH(MMApplicationContext.getContext(), 2131166441);
    paD = com.tencent.mm.cb.a.aH(MMApplicationContext.getContext(), 2131166439);
    paE = com.tencent.mm.cb.a.aH(MMApplicationContext.getContext(), 2131166442);
    paF = com.tencent.mm.cb.a.aH(MMApplicationContext.getContext(), 2131166440);
    paG = com.tencent.mm.cb.a.aH(MMApplicationContext.getContext(), 2131166420);
    paH = com.tencent.mm.cb.a.aH(MMApplicationContext.getContext(), 2131166390);
    paI = com.tencent.mm.cb.a.aH(MMApplicationContext.getContext(), 2131166404);
    paJ = com.tencent.mm.cb.a.aH(MMApplicationContext.getContext(), 2131166405);
    paK = com.tencent.mm.cb.a.aH(MMApplicationContext.getContext(), 2131166402);
    paL = com.tencent.mm.cb.a.aH(MMApplicationContext.getContext(), 2131166403);
    paM = com.tencent.mm.cb.a.aH(MMApplicationContext.getContext(), 2131166393);
    paN = com.tencent.mm.cb.a.aH(MMApplicationContext.getContext(), 2131166395);
    paO = com.tencent.mm.cb.a.aH(MMApplicationContext.getContext(), 2131166394);
    paP = com.tencent.mm.cb.a.aG(MMApplicationContext.getContext(), 2131166392);
    paQ = paJ;
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
    this.oZZ = 0;
    this.paa = 0;
    this.pab = 0;
    this.listeners = new CopyOnWriteArraySet();
    this.pbE = new PointF();
    this.pbF = new Point();
    this.pbG = -1.0F;
    this.pbH = 0;
    this.pbI = false;
    this.oYj = false;
    this.pbJ = false;
    this.pbK = true;
    this.oWm = null;
    this.pbN = new Point();
    this.pbO = 0;
    this.pbP = false;
    this.pbQ = 16;
    this.cPw = new Handler(Looper.getMainLooper());
    this.pbR = false;
    this.pbS = false;
    this.pbT = false;
    this.pbU = 0;
    this.hbN = false;
    this.oVp = false;
    this.pbV = new Handler(Looper.getMainLooper());
    this.pbW = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106430);
        FloatBallView.a(FloatBallView.this);
        FloatBallView.b(FloatBallView.this);
        Iterator localIterator = FloatBallView.this.listeners.iterator();
        while (localIterator.hasNext()) {
          ((com.tencent.mm.plugin.ball.c.g)localIterator.next()).chZ();
        }
        AppMethodBeat.o(106430);
      }
    };
    this.pbX = false;
    this.pbY = false;
    this.pbZ = false;
    this.pca = 0;
    View.inflate(paramContext, 2131495173, this);
    this.pbg = com.tencent.mm.cb.a.l(paramContext, 2131232776);
    this.pbh = com.tencent.mm.cb.a.l(paramContext, 2131232778);
    this.pbi = com.tencent.mm.cb.a.l(paramContext, 2131232780);
    this.pbj = com.tencent.mm.cb.a.l(paramContext, 2131232777);
    this.pbk = com.tencent.mm.cb.a.l(paramContext, 2131232779);
    this.pbl = com.tencent.mm.cb.a.l(paramContext, 2131232781);
    this.pbm = com.tencent.mm.cb.a.l(paramContext, 2131232770);
    this.pbn = com.tencent.mm.cb.a.l(paramContext, 2131232772);
    this.pbo = com.tencent.mm.cb.a.l(paramContext, 2131232774);
    this.pbp = com.tencent.mm.cb.a.l(paramContext, 2131232771);
    this.pbq = com.tencent.mm.cb.a.l(paramContext, 2131232773);
    this.pbr = com.tencent.mm.cb.a.l(paramContext, 2131232775);
    this.pbs = com.tencent.mm.cb.a.l(paramContext, 2131232793);
    this.pbt = com.tencent.mm.cb.a.l(paramContext, 2131232794);
    this.pbu = com.tencent.mm.cb.a.l(paramContext, 2131232795);
    this.pbv = com.tencent.mm.cb.a.l(paramContext, 2131232793);
    this.pbw = com.tencent.mm.cb.a.l(paramContext, 2131232794);
    this.pbx = com.tencent.mm.cb.a.l(paramContext, 2131232795);
    this.paX = ((LinearLayout)findViewById(2131297255));
    this.pba = ((FrameLayout)findViewById(2131297254));
    this.paY = ((FrameLayout)findViewById(2131310012));
    this.paZ = ((FrameLayout)findViewById(2131305726));
    this.lrc = findViewById(2131299698);
    this.pbb = ((FrameLayout)findViewById(2131297256));
    this.pbc = ((CircleAnimateView)findViewById(2131309301));
    this.pbd = ((CircleAnimateView)findViewById(2131297658));
    this.pbe = ((CircleAnimateView)findViewById(2131309040));
    this.pbf = ((CircleAnimateView)findViewById(2131301709));
    this.paV = new com.tencent.mm.plugin.ball.b.b(this);
    this.paT = ((Vibrator)paramContext.getSystemService("vibrator"));
    this.windowManager = ((WindowManager)paramContext.getSystemService("window"));
    this.paR = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.pbD = ao.az(paramContext);
    if ((ao.gJN()) && (aw.kB(paramContext))) {
      this.pbD.x = ao.getDeviceWidth();
    }
    if (ao.gJK()) {
      this.pbD.x = ao.getDeviceHeight();
    }
    this.paS = ViewConfiguration.getLongPressTimeout();
    this.pbA = new LayoutTransition();
    this.paX.setLayoutTransition(this.pbA);
    this.lastOrientation = getResources().getConfiguration().orientation;
    AppMethodBeat.o(106438);
  }
  
  private void B(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(217078);
    int j = this.paX.getPaddingLeft();
    int k = this.paX.getPaddingRight();
    int m = this.paX.getPaddingTop();
    int n = this.paX.getPaddingBottom();
    label466:
    Object localObject;
    if (Cp(this.oZZ))
    {
      if (paramBoolean2) {}
      for (int i = this.pbQ | 0x800003;; i = this.pbQ | 0x800005)
      {
        X(i, true);
        if (!paramBoolean1) {
          break label466;
        }
        if (!paramBoolean2) {
          break;
        }
        this.paX.setPadding(getExtendWidth(), m, k, n);
        this.paX.setLayoutTransition(this.pbA);
        cjp();
        AppMethodBeat.o(217078);
        return;
      }
      this.paX.setPadding(j, m, getExtendWidth(), n);
      if (((Cr(this.paa)) && (Cv(this.oZZ))) || ((Cs(this.paa)) && (Cw(this.oZZ))) || ((Ct(this.paa)) && (Cx(this.oZZ))) || ((Cu(this.paa)) && (Cy(this.oZZ))))
      {
        this.paX.setLayoutTransition(null);
        cjr();
        AppMethodBeat.o(217078);
        return;
      }
      if (((Cq(this.paa)) && (Cv(this.oZZ))) || ((Cq(this.paa)) && (Cw(this.oZZ))) || ((Cq(this.paa)) && (Cx(this.oZZ))) || ((Cq(this.paa)) && (Cy(this.oZZ))))
      {
        this.paX.setLayoutTransition(null);
        cjr();
        AppMethodBeat.o(217078);
        return;
      }
      if (((Cv(this.paa)) && (Cq(this.oZZ))) || ((Cw(this.paa)) && (Cq(this.oZZ))) || ((Cx(this.paa)) && (Cq(this.oZZ))) || ((Cy(this.paa)) && (Cq(this.oZZ))))
      {
        this.paX.setLayoutTransition(null);
        cjr();
        AppMethodBeat.o(217078);
        return;
      }
      this.paX.setLayoutTransition(this.pbA);
      cjr();
      AppMethodBeat.o(217078);
      return;
      if ((Cv(this.oZZ)) || (Cw(this.oZZ)) || (Cx(this.oZZ)) || (Cy(this.oZZ)))
      {
        if (paramBoolean2)
        {
          cjt();
          AppMethodBeat.o(217078);
          return;
        }
        cju();
        AppMethodBeat.o(217078);
        return;
      }
      if ((Cr(this.oZZ)) || (Cs(this.oZZ)) || (Ct(this.oZZ)) || (Cu(this.oZZ)))
      {
        C(paramBoolean2, false);
        AppMethodBeat.o(217078);
        return;
      }
      if (Cq(this.oZZ))
      {
        localObject = (FrameLayout.LayoutParams)this.pba.getLayoutParams();
        ((FrameLayout.LayoutParams)localObject).gravity = 17;
        i = paJ;
        j = paJ;
        ((FrameLayout.LayoutParams)localObject).setMargins(i, i, j, j);
        this.pba.setLayoutParams((ViewGroup.LayoutParams)localObject);
        AppMethodBeat.o(217078);
      }
    }
    else
    {
      if (paramBoolean1)
      {
        if (paramBoolean2)
        {
          this.paX.setPadding(getExtendWidth(), m, k, n);
          this.paX.setLayoutTransition(this.pbA);
          X(this.pbQ | 0x800003, true);
          this.lrc.setVisibility(8);
          if (Cf(this.oZZ))
          {
            this.paZ.setVisibility(0);
            this.pba.setVisibility(8);
            this.pbb.setVisibility(0);
            localObject = (LinearLayout.LayoutParams)this.paZ.getLayoutParams();
            ((LinearLayout.LayoutParams)localObject).gravity = 8388627;
            this.paZ.setLayoutParams((ViewGroup.LayoutParams)localObject);
            C(true, true);
          }
          for (;;)
          {
            this.paY.setVisibility(0);
            if ((this.pbL == null) || (this.pbL.oWu)) {
              break label898;
            }
            this.paY.setVisibility(0);
            paramBoolean1 = Cc(this.oZZ);
            if (!Ch(this.oZZ)) {
              break;
            }
            g(true, false, paramBoolean1);
            AppMethodBeat.o(217078);
            return;
            this.paZ.setVisibility(8);
          }
          if (Ck(this.oZZ))
          {
            g(false, true, paramBoolean1);
            AppMethodBeat.o(217078);
            return;
          }
          this.paY.setVisibility(8);
          AppMethodBeat.o(217078);
          return;
          label898:
          this.paY.setVisibility(8);
          AppMethodBeat.o(217078);
          return;
        }
        this.paX.setPadding(j, m, getExtendWidth(), n);
        this.paX.setLayoutTransition(this.pbA);
        X(this.pbQ | 0x800005, true);
        this.lrc.setVisibility(8);
        if (Cf(this.oZZ))
        {
          this.paZ.setVisibility(0);
          this.pba.setVisibility(8);
          this.pbb.setVisibility(0);
          localObject = (LinearLayout.LayoutParams)this.paZ.getLayoutParams();
          ((LinearLayout.LayoutParams)localObject).gravity = 8388629;
          this.paZ.setLayoutParams((ViewGroup.LayoutParams)localObject);
          C(false, true);
          cjv();
          this.paY.setVisibility(0);
          if ((this.pbL == null) || (this.pbL.oWu)) {
            break label1176;
          }
          this.paY.setVisibility(0);
          paramBoolean1 = Cc(this.oZZ);
          if (!Ch(this.oZZ)) {
            break label1144;
          }
          g(true, false, paramBoolean1);
        }
        label1176:
        for (;;)
        {
          paramBoolean1 = Cc(this.oZZ);
          if (!Ch(this.oZZ)) {
            break label1188;
          }
          g(true, false, paramBoolean1);
          AppMethodBeat.o(217078);
          return;
          this.paZ.setVisibility(8);
          break;
          label1144:
          if (Ck(this.oZZ))
          {
            g(false, true, paramBoolean1);
          }
          else
          {
            this.paY.setVisibility(8);
            continue;
            this.paY.setVisibility(8);
          }
        }
        label1188:
        if (Ck(this.oZZ))
        {
          g(false, true, paramBoolean1);
          AppMethodBeat.o(217078);
          return;
        }
        this.paY.setVisibility(8);
        AppMethodBeat.o(217078);
        return;
      }
      X(this.pbQ | 0x1, false);
    }
    AppMethodBeat.o(217078);
  }
  
  private void BR(int paramInt)
  {
    AppMethodBeat.i(217076);
    Point localPoint1 = this.pbD;
    this.pbD = ao.az(getContext());
    if ((ao.gJN()) && (aw.kB(getContext()))) {
      this.pbD.x = ao.getDeviceWidth();
    }
    if (ao.gJK()) {
      this.pbD.x = ao.getDeviceHeight();
    }
    Point localPoint2 = this.pbD;
    Object localObject;
    int i;
    int j;
    int k;
    if (localPoint1 != null)
    {
      localObject = localPoint1;
      Log.i("MicroMsg.FloatBallView", "processOrientationChanged, screenResolution: %s, lastResolution: %s", new Object[] { localPoint2, localObject });
      if ((this.lastOrientation != paramInt) || ((localPoint1 != null) && ((localPoint1.x != this.pbD.x) || (localPoint1.y != this.pbD.y))))
      {
        this.lastOrientation = paramInt;
        this.pbI = true;
        localObject = (WindowManager.LayoutParams)getLayoutParams();
        paramInt = ((WindowManager.LayoutParams)localObject).x;
        i = (int)(this.pbD.y * this.pbG);
        paramInt = Math.max(Math.min(paramInt, this.pbD.x), 0);
        i = Math.max(Math.min(i, this.pbD.y), 0);
        j = getTargetPositionXWhenOrientationChanged();
        k = BU(i);
        if (j != 0) {
          break label336;
        }
      }
    }
    label336:
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.FloatBallView", "processOrientationChanged, layoutParams.x: %s, layoutParams.y: %s, stickToLeft:%s, startSticky:[%s, %s]=>[%s, %s]", new Object[] { Integer.valueOf(((WindowManager.LayoutParams)localObject).x), Integer.valueOf(((WindowManager.LayoutParams)localObject).y), Boolean.valueOf(bool), Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
      d(bool, paramInt, i, j, k);
      AppMethodBeat.o(217076);
      return;
      localObject = "null";
      break;
    }
  }
  
  private boolean BS(int paramInt)
  {
    AppMethodBeat.i(176987);
    if (getCurrentStateWidth() + paramInt != this.pbD.x)
    {
      AppMethodBeat.o(176987);
      return true;
    }
    AppMethodBeat.o(176987);
    return false;
  }
  
  private static int BU(int paramInt)
  {
    int i;
    if (paramInt < e.oYS) {
      i = e.oYS;
    }
    do
    {
      return i;
      i = paramInt;
    } while (paramInt <= e.oYT);
    return e.oYT;
  }
  
  private int BV(int paramInt)
  {
    AppMethodBeat.i(106465);
    int i = 0;
    if (!BT(paramInt)) {
      i = this.pbD.x - getCurrentStateWidth();
    }
    AppMethodBeat.o(106465);
    return i;
  }
  
  private int BW(int paramInt)
  {
    AppMethodBeat.i(217088);
    int i = getWidth();
    if (Cq(paramInt)) {
      i = pac;
    }
    for (;;)
    {
      AppMethodBeat.o(217088);
      return i;
      if ((Cr(paramInt)) || ((!Cp(paramInt)) && (Cf(paramInt)))) {
        i = paM;
      } else if (Cs(paramInt)) {
        i = paN;
      } else if ((Ct(paramInt)) || (Cu(paramInt))) {
        i = paO;
      } else if ((Cv(paramInt)) || (Cw(paramInt))) {
        i = pae;
      } else if ((Cx(paramInt)) || (Cy(paramInt))) {
        i = pae + paG;
      }
    }
  }
  
  private int BX(int paramInt)
  {
    AppMethodBeat.i(217089);
    int i = getHeight();
    if (Cq(paramInt)) {
      paramInt = pad;
    }
    for (;;)
    {
      AppMethodBeat.o(217089);
      return paramInt;
      if (Cr(paramInt))
      {
        paramInt = paM;
      }
      else if (Cs(paramInt))
      {
        paramInt = paN;
      }
      else if ((Ct(paramInt)) || (Cu(paramInt)))
      {
        paramInt = paN;
      }
      else if ((Cv(paramInt)) || (Cw(paramInt)) || (Cx(paramInt)) || (Cy(paramInt)))
      {
        paramInt = paf;
      }
      else if (!Cx(this.oZZ))
      {
        paramInt = i;
        if (!Cy(this.oZZ)) {}
      }
      else
      {
        paramInt = paf;
      }
    }
  }
  
  private void BY(int paramInt)
  {
    this.oZZ &= (paramInt ^ 0xFFFFFFFF);
  }
  
  private void BZ(int paramInt)
  {
    this.oZZ |= paramInt;
  }
  
  private int C(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(176983);
    this.pbb.setVisibility(0);
    boolean bool1 = Co(this.oZZ);
    boolean bool2 = Cn(this.oZZ);
    boolean bool3 = Cm(this.oZZ);
    boolean bool4 = Cl(this.oZZ);
    boolean bool5 = Cd(this.oZZ);
    boolean bool6 = Cg(this.oZZ);
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
      if ((Cp(this.oZZ)) || (!Cf(this.oZZ))) {
        break label364;
      }
      k = 1;
      if ((!bool4) && (k == 0)) {
        break label370;
      }
      i2 = paK;
      if ((paramBoolean2) || (bool5) || (bool6)) {
        break label385;
      }
      if ((!bool4) && (!bool2) && (!bool1) && (k == 0)) {
        break label378;
      }
      i = paK;
      m = i;
      j = i;
      i = m;
      if ((!bool4) && (k == 0)) {
        break label473;
      }
      this.pbc.setVisibility(0);
      this.pbd.setVisibility(8);
      this.pbe.setVisibility(8);
      this.pbf.setVisibility(8);
      m = 0;
      k = m;
      if (!Cp(this.oZZ))
      {
        k = m;
        if (Cf(this.oZZ)) {
          k = getAppBrandVoipBallInfoIndex();
        }
      }
      a(this.pbc, k);
      localLayoutParams1 = (FrameLayout.LayoutParams)this.pbc.getLayoutParams();
      localLayoutParams1.setMargins(j, i2, i, i2);
      localLayoutParams1.gravity = i1;
      this.pbc.setLayoutParams(localLayoutParams1);
    }
    label364:
    label370:
    label378:
    while ((!bool3) && (!bool2) && (!bool1))
    {
      localLayoutParams1 = (FrameLayout.LayoutParams)this.pbb.getLayoutParams();
      localLayoutParams1.gravity = (i1 | 0x10);
      this.pbb.setLayoutParams(localLayoutParams1);
      if ((!bool2) && (!bool1)) {
        break label959;
      }
      k = paG;
      AppMethodBeat.o(176983);
      return k * 2 + j + i;
      i1 = 8388613;
      break;
      k = 0;
      break label100;
      i2 = paI;
      break label115;
      i = paL;
      break label153;
      if (paramBoolean1)
      {
        if ((bool5) && (!bool6))
        {
          j = paI;
          if (!bool5) {
            break label424;
          }
        }
        for (i = paI;; i = paK)
        {
          break;
          j = paJ;
          break label404;
        }
      }
      if (bool5)
      {
        j = paI;
        if ((!bool5) || (bool6)) {
          break label466;
        }
      }
      for (i = paI;; i = paJ)
      {
        break;
        j = paK;
        break label441;
      }
    }
    label385:
    label404:
    label424:
    label441:
    label466:
    label473:
    this.pbc.setVisibility(0);
    this.pbd.setVisibility(0);
    a(this.pbc, 0);
    a(this.pbd, 1);
    int n;
    int i3;
    if (bool2)
    {
      this.pbe.setVisibility(0);
      this.pbf.setVisibility(8);
      a(this.pbe, 2);
      if (paramBoolean1)
      {
        m = j + paG;
        n = 0;
        k = i;
        i3 = j;
        label575:
        localLayoutParams1 = (FrameLayout.LayoutParams)this.pbe.getLayoutParams();
        localLayoutParams1.setMargins(i3, 0, n, 0);
        localLayoutParams1.gravity = (i1 | 0x10);
        this.pbe.setLayoutParams(localLayoutParams1);
        n = m;
        m = k;
      }
    }
    for (;;)
    {
      localLayoutParams1 = (FrameLayout.LayoutParams)this.pbc.getLayoutParams();
      localLayoutParams1.setMargins(n, i2, m, 0);
      localLayoutParams1.gravity = i1;
      this.pbc.setLayoutParams(localLayoutParams1);
      FrameLayout.LayoutParams localLayoutParams2 = (FrameLayout.LayoutParams)this.pbd.getLayoutParams();
      k = paG;
      localLayoutParams2.setMargins(n, localLayoutParams1.topMargin + k, m, i2);
      localLayoutParams2.gravity = i1;
      this.pbd.setLayoutParams(localLayoutParams2);
      break;
      i3 = 0;
      k = paG;
      n = i;
      k += i;
      m = j;
      break label575;
      if (bool1)
      {
        this.pbe.setVisibility(0);
        this.pbf.setVisibility(0);
        a(this.pbe, 2);
        a(this.pbf, 3);
        if (paramBoolean1)
        {
          k = paG;
          n = 0;
          m = i;
          k += j;
        }
        for (i3 = j;; i3 = 0)
        {
          localLayoutParams1 = (FrameLayout.LayoutParams)this.pbe.getLayoutParams();
          localLayoutParams1.setMargins(i3, i2, n, 0);
          localLayoutParams1.gravity = i1;
          this.pbe.setLayoutParams(localLayoutParams1);
          localLayoutParams2 = (FrameLayout.LayoutParams)this.pbf.getLayoutParams();
          int i4 = paG;
          localLayoutParams2.setMargins(i3, localLayoutParams1.topMargin + i4, n, 0);
          localLayoutParams2.gravity = i1;
          this.pbf.setLayoutParams(localLayoutParams2);
          n = k;
          break;
          k = paG;
          n = i;
          m = k + i;
          k = j;
        }
      }
      this.pbf.setVisibility(8);
      this.pbe.setVisibility(8);
      m = i;
      n = j;
    }
    label959:
    int k = paG;
    AppMethodBeat.o(176983);
    return k + j + i;
  }
  
  private static boolean CA(int paramInt)
  {
    AppMethodBeat.i(217106);
    if ((Ck(paramInt)) && (!Cd(paramInt)) && (!Ce(paramInt)))
    {
      AppMethodBeat.o(217106);
      return true;
    }
    AppMethodBeat.o(217106);
    return false;
  }
  
  private static boolean CB(int paramInt)
  {
    AppMethodBeat.i(217107);
    if ((Cd(paramInt)) && (Cg(paramInt)) && (!Ce(paramInt)))
    {
      AppMethodBeat.o(217107);
      return true;
    }
    AppMethodBeat.o(217107);
    return false;
  }
  
  private int Ca(int paramInt)
  {
    AppMethodBeat.i(217097);
    paramInt = h(Ch(paramInt), Ck(paramInt), Cc(paramInt));
    AppMethodBeat.o(217097);
    return paramInt;
  }
  
  private int Cb(int paramInt)
  {
    AppMethodBeat.i(217098);
    paramInt = a(paramInt, Ch(paramInt), Ck(paramInt), Cc(paramInt));
    AppMethodBeat.o(217098);
    return paramInt;
  }
  
  private static boolean Cd(int paramInt)
  {
    return (paramInt & 0x1) != 0;
  }
  
  private static boolean Ce(int paramInt)
  {
    AppMethodBeat.i(176994);
    if ((Cl(paramInt)) || (Cm(paramInt)) || (Cn(paramInt)) || (Co(paramInt)))
    {
      AppMethodBeat.o(176994);
      return true;
    }
    AppMethodBeat.o(176994);
    return false;
  }
  
  private static boolean Cf(int paramInt)
  {
    return ((paramInt & 0x100) != 0) || ((paramInt & 0x200) != 0);
  }
  
  private static boolean Cg(int paramInt)
  {
    AppMethodBeat.i(217102);
    if ((Ch(paramInt)) || (Ck(paramInt)))
    {
      AppMethodBeat.o(217102);
      return true;
    }
    AppMethodBeat.o(217102);
    return false;
  }
  
  public static boolean Ch(int paramInt)
  {
    return (paramInt & 0x8) != 0;
  }
  
  private static boolean Ci(int paramInt)
  {
    return (paramInt & 0x400) != 0;
  }
  
  private static boolean Cj(int paramInt)
  {
    return (paramInt & 0x800) != 0;
  }
  
  public static boolean Ck(int paramInt)
  {
    return (paramInt & 0x10) != 0;
  }
  
  private static boolean Cl(int paramInt)
  {
    return (paramInt & 0x2) != 0;
  }
  
  private static boolean Cm(int paramInt)
  {
    return (paramInt & 0x4) != 0;
  }
  
  private static boolean Cn(int paramInt)
  {
    return (paramInt & 0x40) != 0;
  }
  
  private static boolean Co(int paramInt)
  {
    return (paramInt & 0x80) != 0;
  }
  
  private static boolean Cp(int paramInt)
  {
    return (paramInt & 0x20) != 0;
  }
  
  private static boolean Cq(int paramInt)
  {
    AppMethodBeat.i(176996);
    if ((Cd(paramInt)) && (!Cg(paramInt)) && (!Ce(paramInt)))
    {
      AppMethodBeat.o(176996);
      return true;
    }
    AppMethodBeat.o(176996);
    return false;
  }
  
  private static boolean Cr(int paramInt)
  {
    AppMethodBeat.i(176997);
    if ((Cl(paramInt)) && (!Cg(paramInt)) && (!Cd(paramInt)))
    {
      AppMethodBeat.o(176997);
      return true;
    }
    AppMethodBeat.o(176997);
    return false;
  }
  
  private static boolean Cs(int paramInt)
  {
    AppMethodBeat.i(176998);
    if ((Cm(paramInt)) && (!Cg(paramInt)) && (!Cd(paramInt)))
    {
      AppMethodBeat.o(176998);
      return true;
    }
    AppMethodBeat.o(176998);
    return false;
  }
  
  private static boolean Ct(int paramInt)
  {
    AppMethodBeat.i(176999);
    if ((Cn(paramInt)) && (!Cg(paramInt)) && (!Cd(paramInt)))
    {
      AppMethodBeat.o(176999);
      return true;
    }
    AppMethodBeat.o(176999);
    return false;
  }
  
  private static boolean Cu(int paramInt)
  {
    AppMethodBeat.i(217103);
    if ((Co(paramInt)) && (!Cg(paramInt)) && (!Cd(paramInt)))
    {
      AppMethodBeat.o(217103);
      return true;
    }
    AppMethodBeat.o(217103);
    return false;
  }
  
  private static boolean Cv(int paramInt)
  {
    AppMethodBeat.i(177000);
    if ((Cl(paramInt)) && (Cd(paramInt)) && (!Cg(paramInt)))
    {
      AppMethodBeat.o(177000);
      return true;
    }
    AppMethodBeat.o(177000);
    return false;
  }
  
  private static boolean Cw(int paramInt)
  {
    AppMethodBeat.i(177001);
    if ((Cm(paramInt)) && (Cd(paramInt)) && (!Cg(paramInt)))
    {
      AppMethodBeat.o(177001);
      return true;
    }
    AppMethodBeat.o(177001);
    return false;
  }
  
  private static boolean Cx(int paramInt)
  {
    AppMethodBeat.i(177002);
    if ((Cn(paramInt)) && (Cd(paramInt)) && (!Cg(paramInt)))
    {
      AppMethodBeat.o(177002);
      return true;
    }
    AppMethodBeat.o(177002);
    return false;
  }
  
  private static boolean Cy(int paramInt)
  {
    AppMethodBeat.i(217104);
    if ((Co(paramInt)) && (Cd(paramInt)) && (!Cg(paramInt)))
    {
      AppMethodBeat.o(217104);
      return true;
    }
    AppMethodBeat.o(217104);
    return false;
  }
  
  private static boolean Cz(int paramInt)
  {
    AppMethodBeat.i(217105);
    if ((Ch(paramInt)) && (!Cd(paramInt)) && (!Ce(paramInt)))
    {
      AppMethodBeat.o(217105);
      return true;
    }
    AppMethodBeat.o(217105);
    return false;
  }
  
  private boolean G(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(106453);
    if ((Math.abs(paramMotionEvent.getRawX() - this.pbE.x) > this.paR) || (Math.abs(paramMotionEvent.getRawY() - this.pbE.y) > this.paR))
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
    int i = (int)Math.max(Math.min(this.pbF.x + paramMotionEvent.getRawX() - this.pbE.x, this.pbD.x), 0.0F);
    AppMethodBeat.o(106454);
    return i;
  }
  
  private int I(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(106455);
    int i = (int)Math.max(Math.min(this.pbF.y + paramMotionEvent.getRawY() - this.pbE.y, this.pbD.y), 0.0F);
    AppMethodBeat.o(106455);
    return i;
  }
  
  private static boolean K(BallInfo paramBallInfo)
  {
    return (paramBallInfo != null) && ((paramBallInfo.state == 4) || (paramBallInfo.state == 512));
  }
  
  private void L(int paramInt, long paramLong)
  {
    AppMethodBeat.i(176984);
    if (paramInt == 0)
    {
      a(this.pbc, paramLong);
      AppMethodBeat.o(176984);
      return;
    }
    if (paramInt == 1)
    {
      a(this.pbd, paramLong);
      AppMethodBeat.o(176984);
      return;
    }
    if (paramInt == 2)
    {
      a(this.pbe, paramLong);
      AppMethodBeat.o(176984);
      return;
    }
    if (paramInt == 3) {
      a(this.pbf, paramLong);
    }
    AppMethodBeat.o(176984);
  }
  
  private static boolean L(BallInfo paramBallInfo)
  {
    return (paramBallInfo != null) && ((paramBallInfo.state == 8) || (paramBallInfo.state == 1024));
  }
  
  private void N(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(217083);
    this.pbE.x = paramMotionEvent.getRawX();
    this.pbE.y = paramMotionEvent.getRawY();
    paramMotionEvent = (WindowManager.LayoutParams)getLayoutParams();
    this.pbF.x = paramMotionEvent.x;
    this.pbF.y = paramMotionEvent.y;
    AppMethodBeat.o(217083);
  }
  
  private void O(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(106475);
    Iterator localIterator = this.listeners.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.plugin.ball.c.g)localIterator.next()).M(paramMotionEvent);
    }
    AppMethodBeat.o(106475);
  }
  
  private void Y(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.pbG = (paramInt / this.pbD.y);
    }
    this.pbH = paramInt;
  }
  
  private void a(CircleAnimateView paramCircleAnimateView, int paramInt)
  {
    AppMethodBeat.i(176986);
    if ((com.tencent.mm.plugin.ball.f.d.h(this.pbz)) && (this.pbz.size() > paramInt))
    {
      BallInfo localBallInfo = (BallInfo)this.pbz.get(paramInt);
      paramInt = com.tencent.mm.plugin.ball.f.d.BM(localBallInfo.state);
      if (-1 != paramInt)
      {
        com.tencent.mm.svg.a.a locala = new com.tencent.mm.svg.a.a();
        if ((!ImgUtil.isGif(MMApplicationContext.getContext(), paramInt)) && (locala.j(getResources(), paramInt))) {
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
        paramCircleAnimateView.setImageBitmap(com.tencent.mm.svg.a.a.i(getResources(), paramInt));
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
    if ((this.pbY == paramBoolean1) && (this.pbZ == paramBoolean2) && (this.pbX == paramBoolean3) && (this.pca == paramInt))
    {
      AppMethodBeat.o(176989);
      return;
    }
    Log.i("MicroMsg.FloatBallView", "updateFloatBallBackground, isSettled:%s, isDockLeft:%s, isManual:%s, state:%s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3), Integer.valueOf(paramInt) });
    this.pca = paramInt;
    this.pbX = paramBoolean3;
    this.pbY = paramBoolean1;
    this.pbZ = paramBoolean2;
    boolean bool1 = Cg(paramInt);
    boolean bool2 = Cr(paramInt);
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        if (paramBoolean3)
        {
          if (bool1)
          {
            this.paX.setBackground(this.pbv);
            AppMethodBeat.o(176989);
            return;
          }
          if (bool2)
          {
            this.paX.setBackground(this.pbp);
            AppMethodBeat.o(176989);
            return;
          }
          this.paX.setBackground(this.pbj);
          AppMethodBeat.o(176989);
          return;
        }
        if (bool1)
        {
          this.paX.setBackground(this.pbs);
          AppMethodBeat.o(176989);
          return;
        }
        if (bool2)
        {
          this.paX.setBackground(this.pbm);
          AppMethodBeat.o(176989);
          return;
        }
        this.paX.setBackground(this.pbg);
        AppMethodBeat.o(176989);
        return;
      }
      if (paramBoolean3)
      {
        if (bool1)
        {
          this.paX.setBackground(this.pbw);
          AppMethodBeat.o(176989);
          return;
        }
        if (bool2)
        {
          this.paX.setBackground(this.pbq);
          AppMethodBeat.o(176989);
          return;
        }
        this.paX.setBackground(this.pbk);
        AppMethodBeat.o(176989);
        return;
      }
      if (bool1)
      {
        this.paX.setBackground(this.pbt);
        AppMethodBeat.o(176989);
        return;
      }
      if (bool2)
      {
        this.paX.setBackground(this.pbn);
        AppMethodBeat.o(176989);
        return;
      }
      this.paX.setBackground(this.pbh);
      AppMethodBeat.o(176989);
      return;
    }
    if (paramBoolean3)
    {
      if (bool1)
      {
        this.paX.setBackground(this.pbx);
        AppMethodBeat.o(176989);
        return;
      }
      if (bool2)
      {
        this.paX.setBackground(this.pbr);
        AppMethodBeat.o(176989);
        return;
      }
      this.paX.setBackground(this.pbl);
      AppMethodBeat.o(176989);
      return;
    }
    if (bool1)
    {
      this.paX.setBackground(this.pbu);
      AppMethodBeat.o(176989);
      return;
    }
    if (bool2)
    {
      this.paX.setBackground(this.pbo);
      AppMethodBeat.o(176989);
      return;
    }
    this.paX.setBackground(this.pbi);
    AppMethodBeat.o(176989);
  }
  
  private void cjA()
  {
    AppMethodBeat.i(217094);
    if (((int)getAlpha() == 1) && (getVisibility() == 0))
    {
      int i = getResources().getConfiguration().orientation;
      if (i != this.lastOrientation)
      {
        Log.i("MicroMsg.FloatBallView", "alvinluo checkOrientationIfNeed currentOrientation: %d, lastOrientation: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(this.lastOrientation) });
        BR(i);
      }
    }
    AppMethodBeat.o(217094);
  }
  
  private void cjB()
  {
    AppMethodBeat.i(217095);
    if (!this.pbP)
    {
      AppMethodBeat.o(217095);
      return;
    }
    try
    {
      WindowManager.LayoutParams localLayoutParams;
      int i;
      if ((this.pbN.x != 0) || (this.pbN.y != 0))
      {
        localLayoutParams = (WindowManager.LayoutParams)getLayoutParams();
        if (!this.pbC) {
          break label103;
        }
        i = 0;
      }
      for (;;)
      {
        int j = localLayoutParams.y;
        int k = this.pbN.y;
        cjC();
        this.pbQ = 16;
        cjz();
        e(i, j + k, true, false);
        AppMethodBeat.o(217095);
        return;
        label103:
        i = localLayoutParams.x;
        j = this.pbN.x;
        i += j;
      }
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.FloatBallView", localException, "alvinluo resetFloatBallViewSizeAndPosition", new Object[0]);
      AppMethodBeat.o(217095);
    }
  }
  
  private void cjC()
  {
    AppMethodBeat.i(217096);
    Log.v("MicroMsg.FloatBallView", "alvinluo resetExtraSize");
    this.pbN.x = 0;
    this.pbN.y = 0;
    AppMethodBeat.o(217096);
  }
  
  private void cjp()
  {
    AppMethodBeat.i(176977);
    if (Cg(this.oZZ))
    {
      View localView = this.lrc;
      if ((Cd(this.oZZ)) || (Ce(this.oZZ))) {}
      boolean bool;
      for (int i = 0;; i = 4)
      {
        localView.setVisibility(i);
        this.paY.setVisibility(0);
        bool = Cc(this.oZZ);
        if (!Ch(this.oZZ)) {
          break label147;
        }
        if (!Cz(this.oZZ)) {
          break;
        }
        this.lrc.setVisibility(4);
        g(true, false, bool);
        this.paZ.setVisibility(8);
        AppMethodBeat.o(176977);
        return;
      }
      g(true, false, bool);
      this.paZ.setVisibility(0);
      cjq();
      AppMethodBeat.o(176977);
      return;
      label147:
      if (CA(this.oZZ))
      {
        this.lrc.setVisibility(4);
        g(false, true, bool);
        this.paZ.setVisibility(8);
        AppMethodBeat.o(176977);
        return;
      }
      g(false, true, bool);
      this.paZ.setVisibility(0);
      cjq();
      AppMethodBeat.o(176977);
      return;
    }
    this.lrc.setVisibility(8);
    this.paY.setVisibility(8);
    this.paZ.setVisibility(0);
    cjq();
    AppMethodBeat.o(176977);
  }
  
  private void cjq()
  {
    AppMethodBeat.i(176978);
    Object localObject = (LinearLayout.LayoutParams)this.paZ.getLayoutParams();
    if (Cg(this.oZZ)) {}
    for (int i = 8388629;; i = 8388627)
    {
      ((LinearLayout.LayoutParams)localObject).gravity = i;
      this.paZ.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if ((!Cd(this.oZZ)) || (!Ce(this.oZZ))) {
        break;
      }
      cjt();
      AppMethodBeat.o(176978);
      return;
    }
    if ((CB(this.oZZ)) || (Cq(this.oZZ)))
    {
      this.pbb.setVisibility(8);
      this.pba.setVisibility(0);
      localObject = (FrameLayout.LayoutParams)this.pba.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).gravity = 8388629;
      i = paJ;
      int j = paJ;
      ((FrameLayout.LayoutParams)localObject).setMargins(i, i, j, j);
      this.pba.setLayoutParams((ViewGroup.LayoutParams)localObject);
      AppMethodBeat.o(176978);
      return;
    }
    if (Ce(this.oZZ))
    {
      this.pba.setVisibility(8);
      C(true, true);
    }
    AppMethodBeat.o(176978);
  }
  
  private void cjr()
  {
    AppMethodBeat.i(176979);
    int i;
    boolean bool;
    if (Cg(this.oZZ))
    {
      View localView = this.lrc;
      if ((Cd(this.oZZ)) || (Ce(this.oZZ)))
      {
        i = 0;
        localView.setVisibility(i);
        this.paY.setVisibility(0);
        bool = Cc(this.oZZ);
        if (!Ch(this.oZZ)) {
          break label148;
        }
        if (!Cz(this.oZZ)) {
          break label126;
        }
        this.lrc.setVisibility(4);
        g(true, false, bool);
        this.paZ.setVisibility(8);
      }
    }
    for (;;)
    {
      cjv();
      AppMethodBeat.o(176979);
      return;
      i = 4;
      break;
      label126:
      g(true, false, bool);
      this.paZ.setVisibility(0);
      cjs();
      continue;
      label148:
      if (CA(this.oZZ))
      {
        this.lrc.setVisibility(4);
        g(false, true, bool);
        this.paZ.setVisibility(8);
      }
      else
      {
        g(false, true, bool);
        this.paZ.setVisibility(0);
        cjs();
        continue;
        this.lrc.setVisibility(8);
        this.paY.setVisibility(8);
        this.paZ.setVisibility(0);
        cjs();
      }
    }
  }
  
  private void cjs()
  {
    AppMethodBeat.i(176980);
    Object localObject = (LinearLayout.LayoutParams)this.paZ.getLayoutParams();
    if (Cg(this.oZZ)) {}
    for (int i = 8388627;; i = 8388629)
    {
      ((LinearLayout.LayoutParams)localObject).gravity = i;
      this.paZ.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if ((!Cd(this.oZZ)) || (!Ce(this.oZZ))) {
        break;
      }
      cju();
      AppMethodBeat.o(176980);
      return;
    }
    if ((CB(this.oZZ)) || (Cq(this.oZZ)))
    {
      this.pbb.setVisibility(8);
      this.pba.setVisibility(0);
      localObject = (FrameLayout.LayoutParams)this.pba.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).gravity = 8388629;
      i = paJ;
      int j = paJ;
      ((FrameLayout.LayoutParams)localObject).setMargins(i, i, j, j);
      this.pba.setLayoutParams((ViewGroup.LayoutParams)localObject);
      AppMethodBeat.o(176980);
      return;
    }
    if (Ce(this.oZZ))
    {
      this.pba.setVisibility(8);
      C(false, true);
    }
    AppMethodBeat.o(176980);
  }
  
  private void cjt()
  {
    AppMethodBeat.i(176981);
    int i = C(true, true);
    this.pba.setVisibility(0);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.pba.getLayoutParams();
    localLayoutParams.gravity = 8388627;
    int j = paJ;
    localLayoutParams.setMargins(i, j, j, paJ);
    this.pba.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(176981);
  }
  
  private void cju()
  {
    AppMethodBeat.i(176982);
    int i = C(false, true);
    this.pba.setVisibility(0);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.pba.getLayoutParams();
    localLayoutParams.gravity = 8388629;
    int j = paJ;
    localLayoutParams.setMargins(j, j, i, paJ);
    this.pba.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(176982);
  }
  
  private boolean cjv()
  {
    AppMethodBeat.i(106451);
    WindowManager.LayoutParams localLayoutParams = (WindowManager.LayoutParams)getLayoutParams();
    int i = localLayoutParams.x;
    int j = localLayoutParams.y;
    if (BS(i))
    {
      i = Math.max(Math.min(i, this.pbD.x), 0);
      j = Math.max(Math.min(j, this.pbD.y), 0);
      int k = BV(i);
      int m = BU(j);
      Log.i("MicroMsg.FloatBallView", "stickToScreenEdgeIfNeed, start:[%s, %s], target:[%s, %s]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m) });
      if ((i != k) || (j != m)) {
        e(k, m, true, false);
      }
      AppMethodBeat.o(106451);
      return true;
    }
    AppMethodBeat.o(106451);
    return false;
  }
  
  private void cjw()
  {
    AppMethodBeat.i(176990);
    int i = 0;
    while (i < this.pbz.size())
    {
      long l = ((BallInfo)this.pbz.get(i)).progress;
      if (l >= 0L) {
        L(i, l);
      }
      i += 1;
    }
    AppMethodBeat.o(176990);
  }
  
  private void cjx()
  {
    AppMethodBeat.i(217085);
    if (this.oYj) {
      d(new AnimatorListenerAdapter()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(217069);
          super.onAnimationCancel(paramAnonymousAnimator);
          FloatBallView.a(FloatBallView.this, false);
          AppMethodBeat.o(217069);
        }
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(217068);
          super.onAnimationEnd(paramAnonymousAnimator);
          FloatBallView.a(FloatBallView.this, false);
          AppMethodBeat.o(217068);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(217067);
          super.onAnimationStart(paramAnonymousAnimator);
          FloatBallView.a(FloatBallView.this, true);
          AppMethodBeat.o(217067);
        }
      });
    }
    AppMethodBeat.o(217085);
  }
  
  private void cjz()
  {
    AppMethodBeat.i(106468);
    int i;
    int k;
    int m;
    int j;
    if (Cp(this.oZZ)) {
      if (Cg(this.oZZ))
      {
        i = Ca(this.oZZ);
        k = this.pbO * 2 + i;
        m = Cb(this.oZZ) + this.pbO * 2;
        if (!Cd(this.oZZ))
        {
          i = m;
          j = k;
          if (!Ce(this.oZZ)) {}
        }
        else
        {
          i = m + (paH + paJ * 2 + paP);
          j = k;
        }
      }
    }
    for (;;)
    {
      m = getVerticalShadowSize();
      k = getHorizontalShadowSize();
      if ((j != 0) && (i != 0))
      {
        int n = getExtendWidth();
        j = this.pbN.x + (j + m + n);
        i = this.pbN.y + (i + k);
      }
      for (;;)
      {
        eY(j, i);
        AppMethodBeat.o(106468);
        return;
        j = BW(this.oZZ);
        i = BX(this.oZZ);
        break;
        if (Cg(this.oZZ))
        {
          if ((this.pbL != null) && (this.pbL.oWu))
          {
            i = 0;
            j = 0;
            break;
          }
          i = Ca(this.oZZ);
          j = this.pbO * 2 + i;
          i = Cb(this.oZZ) + this.pbO * 2;
          break;
        }
        if (!Cf(this.oZZ)) {
          break label291;
        }
        j = paM;
        i = paM;
        break;
        i = 0;
        j = 0;
      }
      label291:
      i = 0;
      j = 0;
    }
  }
  
  private void cr(List<BallInfo> paramList)
  {
    AppMethodBeat.i(106443);
    this.paa = this.oZZ;
    this.oZZ = 0;
    if (AppForegroundDelegate.djR.cPB) {
      this.oZZ |= 0x20;
    }
    List localList = com.tencent.mm.plugin.ball.f.d.cj(com.tencent.mm.plugin.ball.f.d.ch(com.tencent.mm.plugin.ball.f.d.ci(paramList)));
    this.pbz = com.tencent.mm.plugin.ball.f.d.ce(localList);
    int i = com.tencent.mm.plugin.ball.f.d.BK(com.tencent.mm.plugin.ball.f.d.co(localList));
    boolean bool1 = com.tencent.mm.plugin.ball.f.d.cf(com.tencent.mm.plugin.ball.f.d.cm(paramList));
    if (bool1) {
      this.oZZ |= 0x1;
    }
    boolean bool2;
    boolean bool3;
    if (i == 1)
    {
      this.oZZ |= 0x2;
      this.pab = i;
      this.pbL = com.tencent.mm.plugin.ball.f.d.ck(paramList);
      bool2 = K(this.pbL);
      bool3 = L(this.pbL);
      if (bool2) {
        this.oZZ |= 0x8;
      }
      if (bool3) {
        this.oZZ |= 0x10;
      }
      if (this.pbL != null)
      {
        if (this.pbL.state != 512) {
          break label393;
        }
        this.oZZ |= 0x400;
      }
      label201:
      if ((this.pbL != null) && (this.pbL.vk != null)) {
        setCustomView(this.pbL);
      }
      this.pbM = com.tencent.mm.plugin.ball.f.d.cl(paramList);
      if (this.pbM != null)
      {
        if (this.pbM.state != 32) {
          break label421;
        }
        this.oZZ |= 0x100;
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.FloatBallView", ">>> updateFloatBallViewLayoutState, state:[%s => %s], active:%s, passiveCnt:%d, video:%s, audio:%s <<<", new Object[] { Integer.valueOf(this.paa), Integer.valueOf(this.oZZ), Boolean.valueOf(bool1), Integer.valueOf(i), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
      AppMethodBeat.o(106443);
      return;
      if (i == 2)
      {
        this.oZZ |= 0x4;
        break;
      }
      if (i == 3)
      {
        this.oZZ |= 0x40;
        break;
      }
      if (i != 4) {
        break;
      }
      this.oZZ |= 0x80;
      break;
      label393:
      if (this.pbL.state != 1024) {
        break label201;
      }
      this.oZZ |= 0x800;
      break label201;
      label421:
      if (this.pbM.state == 64) {
        this.oZZ |= 0x200;
      }
    }
  }
  
  private static String cs(List<BallInfo> paramList)
  {
    AppMethodBeat.i(106474);
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramList.size())
    {
      BallInfo localBallInfo = (BallInfo)paramList.get(i);
      localStringBuilder.append(localBallInfo.key).append(localBallInfo.type).append(localBallInfo.icon).append(localBallInfo.noe).append(localBallInfo.state).append(localBallInfo.oWr).append(localBallInfo.nno).append(localBallInfo.progress);
      if ((com.tencent.mm.plugin.ball.f.d.H(localBallInfo)) && (localBallInfo.vk != null)) {
        localStringBuilder.append(localBallInfo.vk.hashCode());
      }
      localStringBuilder.append("|");
      i += 1;
    }
    paramList = MD5Util.getMD5String(localStringBuilder.toString());
    AppMethodBeat.o(106474);
    return paramList;
  }
  
  private void d(AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(217087);
    Log.i("MicroMsg.FloatBallView", "alvinluo showByTranslation");
    setNeedTranslateAnimation(false);
    if (this.paV != null)
    {
      boolean bool = BT(((WindowManager.LayoutParams)getLayoutParams()).x);
      this.paV.a(getCurrentStateWidth(), bool, paramAnimatorListenerAdapter);
    }
    AppMethodBeat.o(217087);
  }
  
  private void d(boolean paramBoolean, final int paramInt1, final int paramInt2, final int paramInt3, final int paramInt4)
  {
    AppMethodBeat.i(106464);
    Log.i("MicroMsg.FloatBallView", "start StickyAnimation, stickToLeft:%s, startPositionY: %d, targetPositionY: %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2), Integer.valueOf(paramInt4) });
    if ((this.paU != null) && (this.paU.isRunning()))
    {
      Log.i("MicroMsg.FloatBallView", "cancel StickyAnimation");
      this.paU.cancel();
    }
    this.paU = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.paU.setInterpolator(new AccelerateDecelerateInterpolator());
    this.paU.setDuration(100L);
    this.paU.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(217071);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        int i = paramInt1;
        int j = (int)((paramInt3 * 1.0F - paramInt1) * f);
        int k = paramInt2;
        int m = (int)(f * (paramInt4 * 1.0F - paramInt2));
        FloatBallView.this.e(i + j, m + k, false, false);
        AppMethodBeat.o(217071);
      }
    });
    this.paU.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(217072);
        super.onAnimationEnd(paramAnonymousAnimator);
        paramAnonymousAnimator = (WindowManager.LayoutParams)FloatBallView.this.getLayoutParams();
        FloatBallView.this.g(paramAnonymousAnimator.x, paramAnonymousAnimator.y, true, false);
        AppMethodBeat.o(217072);
      }
    });
    this.paU.start();
    AppMethodBeat.o(106464);
  }
  
  private void eY(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(217090);
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
        Log.i("MicroMsg.FloatBallView", "updateFloatBallViewSize, width:%s, height:%s", new Object[] { Integer.valueOf(localLayoutParams.width), Integer.valueOf(localLayoutParams.height) });
        Iterator localIterator = this.listeners.iterator();
        while (localIterator.hasNext()) {
          ((com.tencent.mm.plugin.ball.c.g)localIterator.next()).a(localLayoutParams.x, localLayoutParams.y, localLayoutParams.height, this.pbS, this.pbC);
        }
        localLayoutParams.width = 0;
        localLayoutParams.height = 0;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.FloatBallView", localException, "updateFloatBallViewSize exception", new Object[0]);
      }
      AppMethodBeat.o(217090);
    }
  }
  
  private void f(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(217084);
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
        AppMethodBeat.o(217084);
        return;
      }
      catch (Throwable localThrowable)
      {
        Log.printErrStackTrace("MicroMsg.FloatBallView", localThrowable, "updateBallPosition fail", new Object[0]);
      }
    }
    AppMethodBeat.o(217084);
  }
  
  private void f(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(217077);
    if ((this.pbS == paramBoolean1) && (this.pbT == paramBoolean2) && (this.pbR == paramBoolean3) && (this.pbU != 0) && (this.pbU == this.oZZ))
    {
      Log.d("MicroMsg.FloatBallView", "<<< updateFloatBallViewLayout, ignore layout %b %b;%b %b; %b %b; %d %d", new Object[] { Boolean.valueOf(this.pbY), Boolean.valueOf(paramBoolean1), Boolean.valueOf(this.pbT), Boolean.valueOf(paramBoolean2), Boolean.valueOf(this.pbR), Boolean.valueOf(paramBoolean3), Integer.valueOf(this.pbU), Integer.valueOf(this.oZZ) });
      AppMethodBeat.o(217077);
      return;
    }
    Log.i("MicroMsg.FloatBallView", ">>> updateFloatBallViewLayout, isSettled:%s, isDockLeft:%s, isManual:%s, lastLayoutState:%s, currentLayoutState:%s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3), Integer.valueOf(this.pbU), Integer.valueOf(this.oZZ) });
    this.pbR = paramBoolean3;
    this.pbS = paramBoolean1;
    this.pbT = paramBoolean2;
    this.pbU = this.oZZ;
    cjz();
    B(paramBoolean1, paramBoolean2);
    AppMethodBeat.o(217077);
  }
  
  private void g(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(217080);
    int i = h(paramBoolean1, paramBoolean2, paramBoolean3);
    int j = a(this.oZZ, paramBoolean1, paramBoolean2, paramBoolean3);
    Log.v("MicroMsg.FloatBallView", "alvinluo updateCustomViewLayout width: %d, height: %d, margin: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(this.pbO) });
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.paY.getLayoutParams();
    localLayoutParams.width = i;
    localLayoutParams.height = j;
    if (this.pbO > 0) {
      localLayoutParams.setMargins(this.pbO, this.pbO, this.pbO, this.pbO);
    }
    this.paY.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(217080);
  }
  
  private int getAppBrandVoipBallInfoIndex()
  {
    AppMethodBeat.i(217081);
    if (com.tencent.mm.plugin.ball.f.d.h(this.pbz))
    {
      int i = 0;
      while (i < this.pbz.size())
      {
        BallInfo localBallInfo = (BallInfo)this.pbz.get(i);
        if ((localBallInfo != null) && (localBallInfo.type == 17))
        {
          AppMethodBeat.o(217081);
          return i;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(217081);
    return 0;
  }
  
  private int getCurrentStateHeight()
  {
    AppMethodBeat.i(176991);
    int k = this.oZZ;
    Log.v("MicroMsg.FloatBallView", "getStateHeight state: %d", new Object[] { Integer.valueOf(k) });
    int j;
    if (Cg(k))
    {
      j = Cb(k) + this.pbO * 2;
      if (!Cd(k))
      {
        i = j;
        if (!Ce(k)) {
          break label83;
        }
      }
    }
    for (int i = j + (paH + paJ * 2 + paP);; i = BX(k))
    {
      label83:
      j = e.oYL;
      k = e.oYM;
      AppMethodBeat.o(176991);
      return i + j + k;
    }
  }
  
  private int getExtendWidth()
  {
    AppMethodBeat.i(106469);
    if (!this.pbI)
    {
      AppMethodBeat.o(106469);
      return 0;
    }
    if (!com.tencent.mm.plugin.ball.f.d.eF(getContext()))
    {
      AppMethodBeat.o(106469);
      return 0;
    }
    int i = this.windowManager.getDefaultDisplay().getRotation();
    if (((this.pbC) && (i == 1)) || ((!this.pbC) && (i == 3)))
    {
      i = com.tencent.mm.plugin.ball.f.d.aP(getContext());
      AppMethodBeat.o(106469);
      return i;
    }
    AppMethodBeat.o(106469);
    return 0;
  }
  
  private int getHorizontalShadowSize()
  {
    if ((this.pbL != null) && (this.pbL.oWn != null))
    {
      if (this.pbL.oWn.y > 0) {
        return this.pbL.oWn.y;
      }
      return e.oYN * 2;
    }
    return e.oYN * 2;
  }
  
  private int getTargetPositionXWhenOrientationChanged()
  {
    AppMethodBeat.i(106466);
    int i = 0;
    if (!this.pbC) {
      i = this.pbD.x - getCurrentStateWidth();
    }
    AppMethodBeat.o(106466);
    return i;
  }
  
  private int getVerticalShadowSize()
  {
    if ((this.pbL != null) && (this.pbL.oWn != null))
    {
      if (this.pbL.oWn.x > 0) {
        return this.pbL.oWn.x;
      }
      return e.oYL + e.oYM;
    }
    return e.oYL + e.oYM;
  }
  
  public static boolean h(Point paramPoint)
  {
    return (paramPoint != null) && (paramPoint.x > 0) && (paramPoint.y > 0);
  }
  
  private void setFloatBallAlphaInternal(float paramFloat)
  {
    AppMethodBeat.i(106461);
    setAlpha(paramFloat);
    if (paramFloat == 0.0F)
    {
      Log.i("MicroMsg.FloatBallView", "setFloatBallAlphaInternal, GONE");
      setVisibility(8);
      AppMethodBeat.o(106461);
      return;
    }
    Log.i("MicroMsg.FloatBallView", "setFloatBallAlphaInternal, VISIBLE, alpha:%s", new Object[] { Float.valueOf(paramFloat) });
    setVisibility(0);
    AppMethodBeat.o(106461);
  }
  
  public final boolean BT(int paramInt)
  {
    AppMethodBeat.i(106459);
    if (getCurrentStateWidth() / 2 + paramInt <= this.pbD.x / 2)
    {
      AppMethodBeat.o(106459);
      return true;
    }
    AppMethodBeat.o(106459);
    return false;
  }
  
  public final boolean Cc(int paramInt)
  {
    AppMethodBeat.i(217100);
    if ((Cd(paramInt)) && (this.pab >= 3))
    {
      AppMethodBeat.o(217100);
      return true;
    }
    AppMethodBeat.o(217100);
    return false;
  }
  
  public final void X(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(217079);
    Object localObject = (FrameLayout.LayoutParams)this.paX.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject).gravity = paramInt;
    this.paX.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if ((!paramBoolean) && (!Cp(this.oZZ)) && (this.paZ.getVisibility() == 0))
    {
      localObject = (LinearLayout.LayoutParams)this.paZ.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).gravity = 17;
      this.paZ.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    AppMethodBeat.o(217079);
  }
  
  public final int a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(217099);
    int i = 0;
    if ((paramBoolean1) || (paramBoolean2))
    {
      if ((this.oWm != null) && (this.oWm.x > 0) && (this.oWm.y > 0)) {
        i = this.oWm.y;
      }
      while (paramBoolean3)
      {
        if ((!Ci(paramInt)) && (!Cj(paramInt))) {
          break label167;
        }
        if ((this.oWm != null) && (this.oWm.x > 0) && (this.oWm.y > 0))
        {
          paramInt = this.oWm.y;
          AppMethodBeat.o(217099);
          return paramInt;
          if (paramBoolean1) {
            i = paz + paQ * 2;
          } else {
            i = paD + paQ * 2;
          }
        }
        else
        {
          i = paD + paQ * 2;
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(217099);
      return i;
      label167:
      if (paramBoolean1) {
        i = paB + paQ * 2;
      } else {
        i = paF + paQ * 2;
      }
    }
  }
  
  public final void a(com.tencent.mm.plugin.ball.c.g paramg)
  {
    AppMethodBeat.i(217101);
    this.listeners.add(paramg);
    AppMethodBeat.o(217101);
  }
  
  public final void a(List<BallInfo> paramList, BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106442);
    paramBallInfo = cs(paramList);
    if (Util.isEqual(paramBallInfo, this.pby))
    {
      Log.d("MicroMsg.FloatBallView", "<<< onFloatBallInfoChanged, ignore refresh");
      AppMethodBeat.o(106442);
      return;
    }
    Log.i("MicroMsg.FloatBallView", ">>> onFloatBallInfoChanged, ballInfoList:%s", new Object[] { paramList });
    this.pby = paramBallInfo;
    cr(paramList);
    cjw();
    boolean bool = BT(((WindowManager.LayoutParams)getLayoutParams()).x);
    f(true, bool, false);
    a(true, bool, false, this.oZZ);
    cjx();
    AppMethodBeat.o(106442);
  }
  
  public final void b(boolean paramBoolean, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(184624);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.en(paramBoolean);
    localb.bm(paramAnimatorListenerAdapter);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ball/view/FloatBallView", "com/tencent/mm/plugin/ball/view/FloatBallView", "hide", "(ZLandroid/animation/AnimatorListenerAdapter;)V", this, localb.axR());
    if (getVisibility() == 8)
    {
      Log.i("MicroMsg.FloatBallView", "float ball already hide");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ball/view/FloatBallView", "com/tencent/mm/plugin/ball/view/FloatBallView", "hide", "(ZLandroid/animation/AnimatorListenerAdapter;)V");
      AppMethodBeat.o(184624);
      return;
    }
    if ((paramBoolean) && (this.paV != null))
    {
      Log.i("MicroMsg.FloatBallView", "hide with animation");
      this.paV.b(paramAnimatorListenerAdapter);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ball/view/FloatBallView", "com/tencent/mm/plugin/ball/view/FloatBallView", "hide", "(ZLandroid/animation/AnimatorListenerAdapter;)V");
      AppMethodBeat.o(184624);
      return;
      Log.i("MicroMsg.FloatBallView", "hide without animation");
      setVisibility(8);
      cjB();
    }
  }
  
  public final void c(boolean paramBoolean1, boolean paramBoolean2, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(184623);
    if ((getVisibility() == 0) && (paramBoolean2))
    {
      Log.i("MicroMsg.FloatBallView", "float ball already show");
      AppMethodBeat.o(184623);
      return;
    }
    if ((paramBoolean1) && (this.paV != null))
    {
      Log.i("MicroMsg.FloatBallView", "show with animation");
      this.paV.a(paramAnimatorListenerAdapter);
      AppMethodBeat.o(184623);
      return;
    }
    Log.i("MicroMsg.FloatBallView", "show without animation");
    setVisibility(0);
    AppMethodBeat.o(184623);
  }
  
  public final void cjy()
  {
    AppMethodBeat.i(184622);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.en(false);
    localb.bm(null);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ball/view/FloatBallView", "com/tencent/mm/plugin/ball/view/FloatBallView", "show", "(ZLandroid/animation/AnimatorListenerAdapter;)V", this, localb.axR());
    c(false, false, null);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ball/view/FloatBallView", "com/tencent/mm/plugin/ball/view/FloatBallView", "show", "(ZLandroid/animation/AnimatorListenerAdapter;)V");
    AppMethodBeat.o(184622);
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
    this.pbC = BT(paramInt1);
    a(paramBoolean1, this.pbC, paramBoolean2, this.oZZ);
    f(paramBoolean1, this.pbC, paramBoolean2);
    Y(paramInt2, paramBoolean1);
    Log.i("MicroMsg.FloatBallView", "notifyBallPositionChanged, x:%s, y:%s, isSettled:%s, isManual:%s, isDockLeft:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(this.pbC) });
    Iterator localIterator = this.listeners.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.plugin.ball.c.g)localIterator.next()).a(paramInt1, paramInt2, getCurrentStateHeight(), paramBoolean1, this.pbC);
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
    if (this.pbC)
    {
      if (Ch(this.oZZ))
      {
        localObject = new Point(((WindowManager.LayoutParams)localObject).x, ((WindowManager.LayoutParams)localObject).y + e.oYL + paz);
        AppMethodBeat.o(106470);
        return localObject;
      }
      if (Ck(this.oZZ))
      {
        localObject = new Point(((WindowManager.LayoutParams)localObject).x, ((WindowManager.LayoutParams)localObject).y + e.oYL + paD);
        AppMethodBeat.o(106470);
        return localObject;
      }
      localObject = new Point(((WindowManager.LayoutParams)localObject).x, ((WindowManager.LayoutParams)localObject).y + e.oYL);
      AppMethodBeat.o(106470);
      return localObject;
    }
    if (Ch(this.oZZ))
    {
      localObject = new Point(((WindowManager.LayoutParams)localObject).x + e.oYN, ((WindowManager.LayoutParams)localObject).y + e.oYL + paz);
      AppMethodBeat.o(106470);
      return localObject;
    }
    if (Ck(this.oZZ))
    {
      localObject = new Point(((WindowManager.LayoutParams)localObject).x + e.oYN, ((WindowManager.LayoutParams)localObject).y + e.oYL + paD);
      AppMethodBeat.o(106470);
      return localObject;
    }
    localObject = new Point(((WindowManager.LayoutParams)localObject).x + e.oYN, ((WindowManager.LayoutParams)localObject).y + e.oYL);
    AppMethodBeat.o(106470);
    return localObject;
  }
  
  public Point getBallSize()
  {
    AppMethodBeat.i(217092);
    Log.v("MicroMsg.FloatBallView", "alvinluo getBallSize stateWidth: %d, stateHeight: %d", new Object[] { Integer.valueOf(getCurrentStateWidth()), Integer.valueOf(getCurrentStateHeight()) });
    Point localPoint = new Point(getCurrentStateWidth() - e.oYN, getCurrentStateHeight() - e.oYL - e.oYM);
    AppMethodBeat.o(217092);
    return localPoint;
  }
  
  public int getCurrentStateWidth()
  {
    AppMethodBeat.i(106467);
    int i = this.oZZ;
    Log.v("MicroMsg.FloatBallView", "getStateWidth state: %d", new Object[] { Integer.valueOf(i) });
    if (Cg(i)) {}
    for (i = Ca(i) + this.pbO * 2;; i = BW(i))
    {
      int j = e.oYN;
      AppMethodBeat.o(106467);
      return i + j;
    }
  }
  
  public Point getFloatBallPosition()
  {
    AppMethodBeat.i(217091);
    Object localObject = (WindowManager.LayoutParams)getLayoutParams();
    if (localObject == null)
    {
      AppMethodBeat.o(217091);
      return null;
    }
    if (this.pbC)
    {
      localObject = new Point(((WindowManager.LayoutParams)localObject).x, ((WindowManager.LayoutParams)localObject).y + e.oYL);
      AppMethodBeat.o(217091);
      return localObject;
    }
    localObject = new Point(((WindowManager.LayoutParams)localObject).x + e.oYN, ((WindowManager.LayoutParams)localObject).y + e.oYL);
    AppMethodBeat.o(217091);
    return localObject;
  }
  
  public float getPosYPercentOfScreen()
  {
    return this.pbG;
  }
  
  public int getPositionY()
  {
    return this.pbH;
  }
  
  public final int h(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int i = 0;
    int j;
    if ((paramBoolean1) || (paramBoolean2))
    {
      if ((this.oWm == null) || (this.oWm.x <= 0) || (this.oWm.y <= 0)) {
        break label90;
      }
      j = this.oWm.x;
      if (!paramBoolean3) {
        break label142;
      }
      if (!paramBoolean1) {
        break label76;
      }
      i = paA + paQ * 2;
    }
    while (j < i)
    {
      return i;
      label76:
      i = paE + paQ * 2;
      continue;
      label90:
      if (paramBoolean1)
      {
        if (paramBoolean3) {
          return paA + paQ * 2;
        }
        return pay + paQ * 2;
      }
      if (paramBoolean3) {
        return paE + paQ * 2;
      }
      return paC + paQ * 2;
    }
    label142:
    return j;
  }
  
  public final void jQ(boolean paramBoolean)
  {
    AppMethodBeat.i(176992);
    Log.i("MicroMsg.FloatBallView", "markWechatInForeground, visibility:%s, inForeground:%s", new Object[] { Integer.valueOf(getVisibility()), Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
      this.oZZ |= 0x20;
    }
    for (;;)
    {
      f(this.pbS, this.pbT, this.pbR);
      AppMethodBeat.o(176992);
      return;
      this.oZZ &= 0xFFFFFFDF;
      if ((Cg(this.oZZ)) || (Cf(this.oZZ)))
      {
        cjy();
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
    Log.i("MicroMsg.FloatBallView", "onConfigurationChanged, orientation:%d, lastOrientation: %d", new Object[] { Integer.valueOf(paramConfiguration.orientation), Integer.valueOf(this.lastOrientation) });
    BR(paramConfiguration.orientation);
    int i = paramConfiguration.orientation;
    paramConfiguration = this.listeners.iterator();
    while (paramConfiguration.hasNext()) {
      ((com.tencent.mm.plugin.ball.c.g)paramConfiguration.next()).onOrientationChange(i);
    }
    AppMethodBeat.o(106441);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(106440);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ball/view/FloatBallView", "com/tencent/mm/plugin/ball/view/FloatBallView", "onDetachedFromWindow", "()V", this);
    super.onDetachedFromWindow();
    if (this.paU != null)
    {
      this.paU.cancel();
      this.paU = null;
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ball/view/FloatBallView", "com/tencent/mm/plugin/ball/view/FloatBallView", "onDetachedFromWindow", "()V");
    AppMethodBeat.o(106440);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(217082);
    int i = (int)paramMotionEvent.getRawX();
    int j = (int)paramMotionEvent.getRawY();
    if (paramMotionEvent.getAction() == 0) {
      N(paramMotionEvent);
    }
    if (com.tencent.mm.plugin.ball.f.d.q(this.vk, i, j))
    {
      if (paramMotionEvent.getAction() != 2)
      {
        AppMethodBeat.o(217082);
        return false;
      }
      boolean bool = G(paramMotionEvent);
      AppMethodBeat.o(217082);
      return bool;
    }
    AppMethodBeat.o(217082);
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(106452);
    if (!this.pbB)
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
      this.hbN = false;
      N(paramMotionEvent);
      a(true, this.pbC, true, this.oZZ);
      if (this.pbI) {
        f(true, this.pbC, true);
      }
      this.oVp = false;
      if ((Cp(this.oZZ)) && (!Cz(this.oZZ)) && (!CA(this.oZZ)))
      {
        this.pbV.postDelayed(this.pbW, this.paS);
        continue;
        if (this.oVp)
        {
          O(paramMotionEvent);
        }
        else
        {
          if ((!this.hbN) && (G(paramMotionEvent)))
          {
            this.pbV.removeCallbacks(this.pbW);
            this.hbN = true;
            i = this.pbF.x;
            i = this.pbF.y;
            localIterator = this.listeners.iterator();
            while (localIterator.hasNext()) {
              ((com.tencent.mm.plugin.ball.c.g)localIterator.next()).cia();
            }
          }
          if (this.hbN)
          {
            e(H(paramMotionEvent), I(paramMotionEvent), false, true);
            continue;
            if (this.oVp)
            {
              a(true, this.pbC, false, this.oZZ);
              if (this.pbI) {
                f(true, this.pbC, false);
              }
              O(paramMotionEvent);
            }
            else
            {
              this.pbV.removeCallbacks(this.pbW);
              if ((this.hbN) || (G(paramMotionEvent))) {
                break;
              }
              a(true, this.pbC, false, this.oZZ);
              if (this.pbI) {
                f(true, this.pbC, false);
              }
              e(this.pbF.x, this.pbF.y, true, false);
              if (this.pbK)
              {
                float f1 = this.pbE.x;
                float f2 = this.pbE.y;
                long l = System.currentTimeMillis();
                if (l > this.lastClickTime + 800L)
                {
                  this.lastClickTime = l;
                  if (com.tencent.mm.plugin.ball.f.d.q(this.vk, (int)f1, (int)f2))
                  {
                    Log.w("MicroMsg.FloatBallView", "notifyBallClickedIfNeed, click voip unexpectedly");
                  }
                  else if ((CA(this.oZZ)) || (Cz(this.oZZ)))
                  {
                    Log.i("MicroMsg.FloatBallView", "notifyBallClickedIfNeed, ignore click");
                  }
                  else if (Cp(this.oZZ))
                  {
                    Log.i("MicroMsg.FloatBallView", "notifyBallClickedIfNeed, wechat in foreground");
                    paramMotionEvent = this.listeners.iterator();
                    while (paramMotionEvent.hasNext()) {
                      ((com.tencent.mm.plugin.ball.c.g)paramMotionEvent.next()).chY();
                    }
                  }
                  else if ((this.pbM != null) && (com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.ball.c.b.class) != null))
                  {
                    Log.i("MicroMsg.FloatBallView", "notifyBallClickedIfNeed, you clicked appbrand voip");
                    this.pbM.oWs.opType = 3;
                    ((com.tencent.mm.plugin.ball.c.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.ball.c.b.class)).m(this.pbM);
                  }
                }
                else
                {
                  Log.i("MicroMsg.FloatBallView", "notifyBallClickedIfNeed, you clicked too fast!");
                }
              }
            }
          }
        }
      }
    }
    a(false, this.pbC, false, this.oZZ);
    if (this.hbN)
    {
      this.hbN = false;
      localIterator = this.listeners.iterator();
      while (localIterator.hasNext()) {
        ((com.tencent.mm.plugin.ball.c.g)localIterator.next()).cib();
      }
    }
    int i = H(paramMotionEvent);
    int j = I(paramMotionEvent);
    int k = BV(i);
    int m = BU(j);
    if (k == 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.FloatBallView", "onTouchEvent, stickToLeft:%s, startSticky:[%s, %s]=>[%s, %s]", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m) });
      d(bool, i, j, k, m);
      break;
    }
  }
  
  public void setAlpha(float paramFloat)
  {
    AppMethodBeat.i(106473);
    super.setAlpha(paramFloat);
    Log.printInfoStack("MicroMsg.FloatBallView", "setAlpha:%s", new Object[] { Float.valueOf(paramFloat) });
    cjA();
    AppMethodBeat.o(106473);
  }
  
  public void setCustomView(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(217093);
    Object localObject = paramBallInfo.vk;
    if (localObject == this.vk)
    {
      Log.w("MicroMsg.FloatBallView", "setCustomView voipView not changed");
      AppMethodBeat.o(217093);
      return;
    }
    if ((((View)localObject).getParent() != null) && ((((View)localObject).getParent() instanceof ViewGroup)))
    {
      Log.i("MicroMsg.FloatBallView", "setCustomView remove from parent first");
      ((ViewGroup)((View)localObject).getParent()).removeView((View)localObject);
    }
    this.paY.removeAllViews();
    this.vk = ((View)localObject);
    localObject = new FrameLayout.LayoutParams(-1, -1);
    ((FrameLayout.LayoutParams)localObject).gravity = 17;
    this.paY.addView(this.vk, (ViewGroup.LayoutParams)localObject);
    this.oWm = paramBallInfo.oWm;
    this.pbP = true;
    cjC();
    if (this.pbL.oWt != null)
    {
      paramBallInfo = this.pbL.oWt.oWv;
      localObject = this.pbL.oWt.oWw;
      if ((h(paramBallInfo)) && (h((Point)localObject)))
      {
        this.pbQ = 80;
        if ((paramBallInfo.x < ((Point)localObject).x) && (paramBallInfo.y < ((Point)localObject).y))
        {
          this.pbN.x = (((Point)localObject).x - paramBallInfo.x);
          this.pbN.y = (((Point)localObject).y - paramBallInfo.y);
          this.pbP = false;
        }
      }
      Log.v("MicroMsg.FloatBallView", "alvinluo updateVoipViewParams startSize: %s, endSize: %s, extraSize: %s, voipViewSize: %s", new Object[] { paramBallInfo, localObject, this.pbN, this.oWm });
    }
    AppMethodBeat.o(217093);
  }
  
  public void setEnableClick(boolean paramBoolean)
  {
    AppMethodBeat.i(217086);
    Log.d("MicroMsg.FloatBallView", "alvinluo setEnableClick enable: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.pbK = paramBoolean;
    AppMethodBeat.o(217086);
  }
  
  public void setFloatBallAlpha(final float paramFloat)
  {
    AppMethodBeat.i(106460);
    com.tencent.mm.plugin.ball.b.b localb = this.paV;
    if ((localb.chI()) || (localb.chJ())) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.printInfoStack("MicroMsg.FloatBallView", "setFloatBallAlpha later, alpha:%s", new Object[] { Float.valueOf(paramFloat) });
      localb = this.paV;
      Runnable local3 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(217070);
          Log.i("MicroMsg.FloatBallView", "setFloatBallAlpha when animation ends, alpha:%s", new Object[] { Float.valueOf(paramFloat) });
          FloatBallView.a(FloatBallView.this, paramFloat);
          AppMethodBeat.o(217070);
        }
      };
      localb.oWi.add(local3);
      AppMethodBeat.o(106460);
      return;
    }
    Log.printInfoStack("MicroMsg.FloatBallView", "setFloatBallAlpha right now, alpha:%s", new Object[] { Float.valueOf(paramFloat) });
    setFloatBallAlphaInternal(paramFloat);
    AppMethodBeat.o(106460);
  }
  
  public void setInnerView(View paramView)
  {
    AppMethodBeat.i(106471);
    if (paramView == this.paW)
    {
      AppMethodBeat.o(106471);
      return;
    }
    this.pba.removeAllViews();
    this.paW = paramView;
    if (this.paW != null)
    {
      paramView = new FrameLayout.LayoutParams(-1, -1);
      paramView.gravity = 17;
      this.pba.addView(this.paW, paramView);
    }
    AppMethodBeat.o(106471);
  }
  
  public void setNeedTranslateAnimation(boolean paramBoolean)
  {
    this.oYj = paramBoolean;
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(106472);
    if ((com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.ball.c.b.class) != null) && (((com.tencent.mm.plugin.ball.c.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.ball.c.b.class)).chV()))
    {
      super.setVisibility(8);
      AppMethodBeat.o(106472);
      return;
    }
    super.setVisibility(paramInt);
    int i = (int)getAlpha();
    if (i == 0)
    {
      this.pbB = false;
      Log.printInfoStack("MicroMsg.FloatBallView", "setVisibility:%s, alphaInt:%s, disableTouch", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      AppMethodBeat.o(106472);
      return;
    }
    if (i == 1)
    {
      this.pbB = true;
      Log.printInfoStack("MicroMsg.FloatBallView", "setVisibility:%s, alphaInt:%s, enableTouch", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      cjA();
    }
    AppMethodBeat.o(106472);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.view.FloatBallView
 * JD-Core Version:    0.7.0.1
 */