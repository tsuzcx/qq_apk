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
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.ball.a.c;
import com.tencent.mm.plugin.ball.a.d;
import com.tencent.mm.plugin.ball.a.e;
import com.tencent.mm.plugin.ball.a.f;
import com.tencent.mm.plugin.ball.c.g;
import com.tencent.mm.plugin.ball.f.e;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.model.BallInfo.a;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArraySet;

public class FloatBallView
  extends FrameLayout
  implements com.tencent.mm.plugin.ball.c.d
{
  private static final int scA;
  public static final int scB;
  private static final int scC;
  private static final int scD;
  private static final int scE;
  public static final int scF;
  public static final int scG;
  private static final int scH;
  private static final int scI;
  private static final int scJ;
  private static final int scK;
  private static final int scL;
  private static final int scM;
  private static final int scN;
  private static final int scO;
  private static final int scP;
  private static final int scQ;
  public static final int scR;
  private static final int scd;
  private static final int sce;
  private static final int scf;
  private static final int scg;
  private static final int sch;
  private static final int sci;
  private static final int scj;
  private static final int sck;
  private static final int scl;
  private static final int scm;
  private static final int scn;
  private static final int sco;
  private static final int scp;
  private static final int scq;
  private static final int scr;
  private static final int scs;
  private static final int sct;
  private static final int scu;
  private static final int scv;
  private static final int scw;
  private static final int scx;
  private static final int scy;
  private static final int scz;
  public View bFK;
  private Handler cQo;
  private boolean jMX;
  private long lastClickTime;
  private int lastOrientation;
  public Set<g> listeners;
  private View olM;
  private boolean rXo;
  private Point rYm;
  private Vibrator rqC;
  public boolean sak;
  private int scS;
  private int scT;
  private ValueAnimator scU;
  public com.tencent.mm.plugin.ball.b.b scV;
  private View scW;
  private LinearLayout scX;
  public FrameLayout scY;
  private FrameLayout scZ;
  public int sca;
  private int scb;
  private int scc;
  private LayoutTransition sdA;
  private boolean sdB;
  public boolean sdC;
  private Point sdD;
  private PointF sdE;
  private Point sdF;
  private float sdG;
  private int sdH;
  private boolean sdI;
  private boolean sdJ;
  private boolean sdK;
  private BallInfo sdL;
  private BallInfo sdM;
  private Point sdN;
  private int sdO;
  private boolean sdP;
  public int sdQ;
  private boolean sdR;
  private boolean sdS;
  private boolean sdT;
  private int sdU;
  private Handler sdV;
  private Runnable sdW;
  private boolean sdX;
  private boolean sdY;
  private boolean sdZ;
  private FrameLayout sda;
  private FrameLayout sdb;
  private CircleAnimateView sdc;
  private CircleAnimateView sdd;
  private CircleAnimateView sde;
  private CircleAnimateView sdf;
  private Drawable sdg;
  private Drawable sdh;
  private Drawable sdi;
  private Drawable sdj;
  private Drawable sdk;
  private Drawable sdl;
  private Drawable sdm;
  private Drawable sdn;
  private Drawable sdo;
  private Drawable sdp;
  private Drawable sdq;
  private Drawable sdr;
  private Drawable sds;
  private Drawable sdt;
  private Drawable sdu;
  private Drawable sdv;
  private Drawable sdw;
  private Drawable sdx;
  private String sdy;
  private List<BallInfo> sdz;
  private int sea;
  private WindowManager windowManager;
  
  static
  {
    AppMethodBeat.i(106478);
    scd = com.tencent.mm.ci.a.aZ(MMApplicationContext.getContext(), a.c.float_ball_active_width);
    sce = com.tencent.mm.ci.a.aZ(MMApplicationContext.getContext(), a.c.float_ball_active_height);
    scf = com.tencent.mm.ci.a.aZ(MMApplicationContext.getContext(), a.c.float_ball_active_passive_width);
    scg = com.tencent.mm.ci.a.aZ(MMApplicationContext.getContext(), a.c.float_ball_active_passive_height);
    sch = com.tencent.mm.ci.a.aZ(MMApplicationContext.getContext(), a.c.float_ball_one_passive_width);
    sci = com.tencent.mm.ci.a.aZ(MMApplicationContext.getContext(), a.c.float_ball_one_passive_height);
    scj = com.tencent.mm.ci.a.aZ(MMApplicationContext.getContext(), a.c.float_ball_two_passive_width);
    sck = com.tencent.mm.ci.a.aZ(MMApplicationContext.getContext(), a.c.float_ball_two_passive_height);
    scl = com.tencent.mm.ci.a.aZ(MMApplicationContext.getContext(), a.c.float_ball_three_passive_width);
    scm = com.tencent.mm.ci.a.aZ(MMApplicationContext.getContext(), a.c.float_ball_three_passive_height);
    scn = com.tencent.mm.ci.a.aZ(MMApplicationContext.getContext(), a.c.float_ball_voip_video_width);
    sco = com.tencent.mm.ci.a.aZ(MMApplicationContext.getContext(), a.c.float_ball_voip_video_height);
    scp = com.tencent.mm.ci.a.aZ(MMApplicationContext.getContext(), a.c.float_ball_voip_video_with_others_width);
    scq = com.tencent.mm.ci.a.aZ(MMApplicationContext.getContext(), a.c.float_ball_voip_video_with_others_height);
    scr = com.tencent.mm.ci.a.aZ(MMApplicationContext.getContext(), a.c.float_ball_voip_video_with_others_width_large);
    scs = com.tencent.mm.ci.a.aZ(MMApplicationContext.getContext(), a.c.float_ball_voip_video_with_others_height_large);
    sct = com.tencent.mm.ci.a.aZ(MMApplicationContext.getContext(), a.c.float_ball_voip_audio_width);
    scu = com.tencent.mm.ci.a.aZ(MMApplicationContext.getContext(), a.c.float_ball_voip_audio_height);
    scv = com.tencent.mm.ci.a.aZ(MMApplicationContext.getContext(), a.c.float_ball_voip_audio_with_others_width);
    scw = com.tencent.mm.ci.a.aZ(MMApplicationContext.getContext(), a.c.float_ball_voip_audio_with_others_height);
    scx = com.tencent.mm.ci.a.aZ(MMApplicationContext.getContext(), a.c.float_ball_voip_audio_with_others_width_large);
    scy = com.tencent.mm.ci.a.aZ(MMApplicationContext.getContext(), a.c.float_ball_voip_audio_with_others_height_large);
    scz = com.tencent.mm.ci.a.aZ(MMApplicationContext.getContext(), a.c.float_ball_voip_view_video_width);
    scA = com.tencent.mm.ci.a.aZ(MMApplicationContext.getContext(), a.c.float_ball_voip_view_video_height);
    scB = com.tencent.mm.ci.a.aZ(MMApplicationContext.getContext(), a.c.float_ball_voip_view_video_width_large);
    scC = com.tencent.mm.ci.a.aZ(MMApplicationContext.getContext(), a.c.float_ball_voip_view_video_height_large);
    scD = com.tencent.mm.ci.a.aZ(MMApplicationContext.getContext(), a.c.float_ball_voip_view_audio_width);
    scE = com.tencent.mm.ci.a.aZ(MMApplicationContext.getContext(), a.c.float_ball_voip_view_audio_height);
    scF = com.tencent.mm.ci.a.aZ(MMApplicationContext.getContext(), a.c.float_ball_voip_view_audio_width_large);
    scG = com.tencent.mm.ci.a.aZ(MMApplicationContext.getContext(), a.c.float_ball_voip_view_audio_height_large);
    scH = com.tencent.mm.ci.a.aZ(MMApplicationContext.getContext(), a.c.float_ball_state_icon_size);
    scI = com.tencent.mm.ci.a.aZ(MMApplicationContext.getContext(), a.c.float_ball_content_view_size);
    scJ = com.tencent.mm.ci.a.aZ(MMApplicationContext.getContext(), a.c.float_ball_inner_margin_4);
    scK = com.tencent.mm.ci.a.aZ(MMApplicationContext.getContext(), a.c.float_ball_inner_margin_8);
    scL = com.tencent.mm.ci.a.aZ(MMApplicationContext.getContext(), a.c.float_ball_inner_margin_12);
    scM = com.tencent.mm.ci.a.aZ(MMApplicationContext.getContext(), a.c.float_ball_inner_margin_16);
    scN = com.tencent.mm.ci.a.aZ(MMApplicationContext.getContext(), a.c.float_ball_dragging_size_one_passive);
    scO = com.tencent.mm.ci.a.aZ(MMApplicationContext.getContext(), a.c.float_ball_dragging_size_two_passive);
    scP = com.tencent.mm.ci.a.aZ(MMApplicationContext.getContext(), a.c.float_ball_dragging_size_three_passive);
    scQ = com.tencent.mm.ci.a.aY(MMApplicationContext.getContext(), a.c.float_ball_divider_view_height);
    scR = scK;
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
    this.sca = 0;
    this.scb = 0;
    this.scc = 0;
    this.listeners = new CopyOnWriteArraySet();
    this.sdE = new PointF();
    this.sdF = new Point();
    this.sdG = -1.0F;
    this.sdH = 0;
    this.sdI = false;
    this.sak = false;
    this.sdJ = false;
    this.sdK = true;
    this.rYm = null;
    this.sdN = new Point();
    this.sdO = 0;
    this.sdP = false;
    this.sdQ = 16;
    this.cQo = new Handler(Looper.getMainLooper());
    this.sdR = false;
    this.sdS = false;
    this.sdT = false;
    this.sdU = 0;
    this.jMX = false;
    this.rXo = false;
    this.sdV = new Handler(Looper.getMainLooper());
    this.sdW = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106430);
        FloatBallView.a(FloatBallView.this);
        FloatBallView.b(FloatBallView.this);
        Iterator localIterator = FloatBallView.this.listeners.iterator();
        while (localIterator.hasNext()) {
          ((g)localIterator.next()).cvl();
        }
        AppMethodBeat.o(106430);
      }
    };
    this.sdX = false;
    this.sdY = false;
    this.sdZ = false;
    this.sea = 0;
    View.inflate(paramContext, a.f.layout_float_ball_view, this);
    this.sdg = com.tencent.mm.ci.a.m(paramContext, a.d.float_window_56_background_left);
    this.sdh = com.tencent.mm.ci.a.m(paramContext, a.d.float_window_56_background_right);
    this.sdi = com.tencent.mm.ci.a.m(paramContext, a.d.float_window_56_background_round);
    this.sdj = com.tencent.mm.ci.a.m(paramContext, a.d.float_window_56_background_left_press);
    this.sdk = com.tencent.mm.ci.a.m(paramContext, a.d.float_window_56_background_right_press);
    this.sdl = com.tencent.mm.ci.a.m(paramContext, a.d.float_window_56_background_round_press);
    this.sdm = com.tencent.mm.ci.a.m(paramContext, a.d.float_window_48_background_left);
    this.sdn = com.tencent.mm.ci.a.m(paramContext, a.d.float_window_48_background_right);
    this.sdo = com.tencent.mm.ci.a.m(paramContext, a.d.float_window_48_background_round);
    this.sdp = com.tencent.mm.ci.a.m(paramContext, a.d.float_window_48_background_left_press);
    this.sdq = com.tencent.mm.ci.a.m(paramContext, a.d.float_window_48_background_right_press);
    this.sdr = com.tencent.mm.ci.a.m(paramContext, a.d.float_window_48_background_round_press);
    this.sds = com.tencent.mm.ci.a.m(paramContext, a.d.float_window_voip_background_left);
    this.sdt = com.tencent.mm.ci.a.m(paramContext, a.d.float_window_voip_background_right);
    this.sdu = com.tencent.mm.ci.a.m(paramContext, a.d.float_window_voip_background_round);
    this.sdv = com.tencent.mm.ci.a.m(paramContext, a.d.float_window_voip_background_left);
    this.sdw = com.tencent.mm.ci.a.m(paramContext, a.d.float_window_voip_background_right);
    this.sdx = com.tencent.mm.ci.a.m(paramContext, a.d.float_window_voip_background_round);
    this.scX = ((LinearLayout)findViewById(a.e.ballRootView));
    this.sda = ((FrameLayout)findViewById(a.e.ballContentView));
    this.scY = ((FrameLayout)findViewById(a.e.voipContentView));
    this.scZ = ((FrameLayout)findViewById(a.e.otherContentView));
    this.olM = findViewById(a.e.dividerView);
    this.sdb = ((FrameLayout)findViewById(a.e.ballStateView));
    this.sdc = ((CircleAnimateView)findViewById(a.e.topStateImageView));
    this.sdd = ((CircleAnimateView)findViewById(a.e.bottomStateImageView));
    this.sde = ((CircleAnimateView)findViewById(a.e.thirdStateImageView));
    this.sdf = ((CircleAnimateView)findViewById(a.e.fourthStateImageView));
    this.scV = new com.tencent.mm.plugin.ball.b.b(this);
    this.rqC = ((Vibrator)paramContext.getSystemService("vibrator"));
    this.windowManager = ((WindowManager)paramContext.getSystemService("window"));
    this.scS = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.sdD = ar.au(paramContext);
    if ((ar.hIO()) && (ar.kL(paramContext))) {
      this.sdD.x = ar.getDeviceWidth();
    }
    if (ar.hIH()) {
      this.sdD.x = ar.getDeviceHeight();
    }
    this.scT = ViewConfiguration.getLongPressTimeout();
    this.sdA = new LayoutTransition();
    this.scX.setLayoutTransition(this.sdA);
    this.lastOrientation = getResources().getConfiguration().orientation;
    AppMethodBeat.o(106438);
  }
  
  private void F(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(186950);
    int j = this.scX.getPaddingLeft();
    int k = this.scX.getPaddingRight();
    int m = this.scX.getPaddingTop();
    int n = this.scX.getPaddingBottom();
    label466:
    Object localObject;
    if (FR(this.sca))
    {
      if (paramBoolean2) {}
      for (int i = this.sdQ | 0x800003;; i = this.sdQ | 0x800005)
      {
        X(i, true);
        if (!paramBoolean1) {
          break label466;
        }
        if (!paramBoolean2) {
          break;
        }
        this.scX.setPadding(getExtendWidth(), m, k, n);
        this.scX.setLayoutTransition(this.sdA);
        cwG();
        AppMethodBeat.o(186950);
        return;
      }
      this.scX.setPadding(j, m, getExtendWidth(), n);
      if (((FT(this.scb)) && (FX(this.sca))) || ((FU(this.scb)) && (FY(this.sca))) || ((FV(this.scb)) && (FZ(this.sca))) || ((FW(this.scb)) && (Ga(this.sca))))
      {
        this.scX.setLayoutTransition(null);
        cwI();
        AppMethodBeat.o(186950);
        return;
      }
      if (((FS(this.scb)) && (FX(this.sca))) || ((FS(this.scb)) && (FY(this.sca))) || ((FS(this.scb)) && (FZ(this.sca))) || ((FS(this.scb)) && (Ga(this.sca))))
      {
        this.scX.setLayoutTransition(null);
        cwI();
        AppMethodBeat.o(186950);
        return;
      }
      if (((FX(this.scb)) && (FS(this.sca))) || ((FY(this.scb)) && (FS(this.sca))) || ((FZ(this.scb)) && (FS(this.sca))) || ((Ga(this.scb)) && (FS(this.sca))))
      {
        this.scX.setLayoutTransition(null);
        cwI();
        AppMethodBeat.o(186950);
        return;
      }
      this.scX.setLayoutTransition(this.sdA);
      cwI();
      AppMethodBeat.o(186950);
      return;
      if ((FX(this.sca)) || (FY(this.sca)) || (FZ(this.sca)) || (Ga(this.sca)))
      {
        if (paramBoolean2)
        {
          cwK();
          AppMethodBeat.o(186950);
          return;
        }
        cwL();
        AppMethodBeat.o(186950);
        return;
      }
      if ((FT(this.sca)) || (FU(this.sca)) || (FV(this.sca)) || (FW(this.sca)))
      {
        G(paramBoolean2, false);
        AppMethodBeat.o(186950);
        return;
      }
      if (FS(this.sca))
      {
        localObject = (FrameLayout.LayoutParams)this.sda.getLayoutParams();
        ((FrameLayout.LayoutParams)localObject).gravity = 17;
        i = scK;
        j = scK;
        ((FrameLayout.LayoutParams)localObject).setMargins(i, i, j, j);
        this.sda.setLayoutParams((ViewGroup.LayoutParams)localObject);
        AppMethodBeat.o(186950);
      }
    }
    else
    {
      if (paramBoolean1)
      {
        if (paramBoolean2)
        {
          this.scX.setPadding(getExtendWidth(), m, k, n);
          this.scX.setLayoutTransition(this.sdA);
          X(this.sdQ | 0x800003, true);
          this.olM.setVisibility(8);
          if (FG(this.sca))
          {
            this.scZ.setVisibility(0);
            this.sda.setVisibility(8);
            this.sdb.setVisibility(0);
            localObject = (LinearLayout.LayoutParams)this.scZ.getLayoutParams();
            ((LinearLayout.LayoutParams)localObject).gravity = 8388627;
            this.scZ.setLayoutParams((ViewGroup.LayoutParams)localObject);
            G(true, true);
          }
          for (;;)
          {
            this.scY.setVisibility(0);
            if ((this.sdL == null) || (this.sdL.rYu)) {
              break label908;
            }
            this.scY.setVisibility(0);
            paramBoolean1 = FD(this.sca);
            if ((!FJ(this.sca)) && (!FI(this.sca))) {
              break;
            }
            f(true, false, paramBoolean1);
            AppMethodBeat.o(186950);
            return;
            this.scZ.setVisibility(8);
          }
          if (FM(this.sca))
          {
            f(false, true, paramBoolean1);
            AppMethodBeat.o(186950);
            return;
          }
          this.scY.setVisibility(8);
          AppMethodBeat.o(186950);
          return;
          label908:
          this.scY.setVisibility(8);
          AppMethodBeat.o(186950);
          return;
        }
        this.scX.setPadding(j, m, getExtendWidth(), n);
        this.scX.setLayoutTransition(this.sdA);
        X(this.sdQ | 0x800005, true);
        this.olM.setVisibility(8);
        if (FG(this.sca))
        {
          this.scZ.setVisibility(0);
          this.sda.setVisibility(8);
          this.sdb.setVisibility(0);
          localObject = (LinearLayout.LayoutParams)this.scZ.getLayoutParams();
          ((LinearLayout.LayoutParams)localObject).gravity = 8388629;
          this.scZ.setLayoutParams((ViewGroup.LayoutParams)localObject);
          G(false, true);
          cwM();
          this.scY.setVisibility(0);
          if ((this.sdL == null) || (this.sdL.rYu)) {
            break label1206;
          }
          this.scY.setVisibility(0);
          paramBoolean1 = FD(this.sca);
          if ((!FJ(this.sca)) && (!FI(this.sca))) {
            break label1174;
          }
          f(true, false, paramBoolean1);
        }
        for (;;)
        {
          paramBoolean1 = FD(this.sca);
          if ((!FJ(this.sca)) && (!FI(this.sca))) {
            break label1218;
          }
          f(true, false, paramBoolean1);
          AppMethodBeat.o(186950);
          return;
          this.scZ.setVisibility(8);
          break;
          label1174:
          if (FM(this.sca))
          {
            f(false, true, paramBoolean1);
          }
          else
          {
            this.scY.setVisibility(8);
            continue;
            label1206:
            this.scY.setVisibility(8);
          }
        }
        label1218:
        if (FM(this.sca))
        {
          f(false, true, paramBoolean1);
          AppMethodBeat.o(186950);
          return;
        }
        this.scY.setVisibility(8);
        AppMethodBeat.o(186950);
        return;
      }
      X(this.sdQ | 0x1, false);
    }
    AppMethodBeat.o(186950);
  }
  
  private boolean F(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(106453);
    if ((Math.abs(paramMotionEvent.getRawX() - this.sdE.x) > this.scS) || (Math.abs(paramMotionEvent.getRawY() - this.sdE.y) > this.scS))
    {
      AppMethodBeat.o(106453);
      return true;
    }
    AppMethodBeat.o(106453);
    return false;
  }
  
  private void FA(int paramInt)
  {
    this.sca |= paramInt;
  }
  
  private int FB(int paramInt)
  {
    AppMethodBeat.i(187058);
    if ((FJ(paramInt)) || (FI(paramInt))) {}
    for (boolean bool = true;; bool = false)
    {
      paramInt = g(bool, FM(paramInt), FD(paramInt));
      AppMethodBeat.o(187058);
      return paramInt;
    }
  }
  
  private int FC(int paramInt)
  {
    AppMethodBeat.i(187059);
    if ((FJ(paramInt)) || (FI(paramInt))) {}
    for (boolean bool = true;; bool = false)
    {
      paramInt = a(paramInt, bool, FM(paramInt), FD(paramInt));
      AppMethodBeat.o(187059);
      return paramInt;
    }
  }
  
  private static boolean FE(int paramInt)
  {
    return (paramInt & 0x1) != 0;
  }
  
  private static boolean FF(int paramInt)
  {
    AppMethodBeat.i(176994);
    if ((FN(paramInt)) || (FO(paramInt)) || (FP(paramInt)) || (FQ(paramInt)))
    {
      AppMethodBeat.o(176994);
      return true;
    }
    AppMethodBeat.o(176994);
    return false;
  }
  
  private static boolean FG(int paramInt)
  {
    return ((paramInt & 0x100) != 0) || ((paramInt & 0x200) != 0);
  }
  
  private static boolean FH(int paramInt)
  {
    AppMethodBeat.i(187086);
    if ((FJ(paramInt)) || (FM(paramInt)) || (FI(paramInt)))
    {
      AppMethodBeat.o(187086);
      return true;
    }
    AppMethodBeat.o(187086);
    return false;
  }
  
  private static boolean FI(int paramInt)
  {
    return (paramInt & 0x1000) != 0;
  }
  
  public static boolean FJ(int paramInt)
  {
    return (paramInt & 0x8) != 0;
  }
  
  private static boolean FK(int paramInt)
  {
    return (paramInt & 0x400) != 0;
  }
  
  private static boolean FL(int paramInt)
  {
    return (paramInt & 0x800) != 0;
  }
  
  public static boolean FM(int paramInt)
  {
    return (paramInt & 0x10) != 0;
  }
  
  private static boolean FN(int paramInt)
  {
    return (paramInt & 0x2) != 0;
  }
  
  private static boolean FO(int paramInt)
  {
    return (paramInt & 0x4) != 0;
  }
  
  private static boolean FP(int paramInt)
  {
    return (paramInt & 0x40) != 0;
  }
  
  private static boolean FQ(int paramInt)
  {
    return (paramInt & 0x80) != 0;
  }
  
  private static boolean FR(int paramInt)
  {
    return (paramInt & 0x20) != 0;
  }
  
  private static boolean FS(int paramInt)
  {
    AppMethodBeat.i(176996);
    if ((FE(paramInt)) && (!FH(paramInt)) && (!FF(paramInt)))
    {
      AppMethodBeat.o(176996);
      return true;
    }
    AppMethodBeat.o(176996);
    return false;
  }
  
  private static boolean FT(int paramInt)
  {
    AppMethodBeat.i(176997);
    if ((FN(paramInt)) && (!FH(paramInt)) && (!FE(paramInt)))
    {
      AppMethodBeat.o(176997);
      return true;
    }
    AppMethodBeat.o(176997);
    return false;
  }
  
  private static boolean FU(int paramInt)
  {
    AppMethodBeat.i(176998);
    if ((FO(paramInt)) && (!FH(paramInt)) && (!FE(paramInt)))
    {
      AppMethodBeat.o(176998);
      return true;
    }
    AppMethodBeat.o(176998);
    return false;
  }
  
  private static boolean FV(int paramInt)
  {
    AppMethodBeat.i(176999);
    if ((FP(paramInt)) && (!FH(paramInt)) && (!FE(paramInt)))
    {
      AppMethodBeat.o(176999);
      return true;
    }
    AppMethodBeat.o(176999);
    return false;
  }
  
  private static boolean FW(int paramInt)
  {
    AppMethodBeat.i(187116);
    if ((FQ(paramInt)) && (!FH(paramInt)) && (!FE(paramInt)))
    {
      AppMethodBeat.o(187116);
      return true;
    }
    AppMethodBeat.o(187116);
    return false;
  }
  
  private static boolean FX(int paramInt)
  {
    AppMethodBeat.i(177000);
    if ((FN(paramInt)) && (FE(paramInt)) && (!FH(paramInt)))
    {
      AppMethodBeat.o(177000);
      return true;
    }
    AppMethodBeat.o(177000);
    return false;
  }
  
  private static boolean FY(int paramInt)
  {
    AppMethodBeat.i(177001);
    if ((FO(paramInt)) && (FE(paramInt)) && (!FH(paramInt)))
    {
      AppMethodBeat.o(177001);
      return true;
    }
    AppMethodBeat.o(177001);
    return false;
  }
  
  private static boolean FZ(int paramInt)
  {
    AppMethodBeat.i(177002);
    if ((FP(paramInt)) && (FE(paramInt)) && (!FH(paramInt)))
    {
      AppMethodBeat.o(177002);
      return true;
    }
    AppMethodBeat.o(177002);
    return false;
  }
  
  private void Fs(int paramInt)
  {
    AppMethodBeat.i(186940);
    Point localPoint1 = this.sdD;
    this.sdD = ar.au(getContext());
    if ((ar.hIO()) && (ar.kL(getContext()))) {
      this.sdD.x = ar.getDeviceWidth();
    }
    if (ar.hIH()) {
      this.sdD.x = ar.getDeviceHeight();
    }
    Point localPoint2 = this.sdD;
    Object localObject;
    int i;
    int j;
    int k;
    if (localPoint1 != null)
    {
      localObject = localPoint1;
      Log.i("MicroMsg.FloatBallView", "processOrientationChanged, screenResolution: %s, lastResolution: %s", new Object[] { localPoint2, localObject });
      if ((this.lastOrientation != paramInt) || ((localPoint1 != null) && ((localPoint1.x != this.sdD.x) || (localPoint1.y != this.sdD.y))))
      {
        this.lastOrientation = paramInt;
        this.sdI = true;
        localObject = (WindowManager.LayoutParams)getLayoutParams();
        paramInt = ((WindowManager.LayoutParams)localObject).x;
        i = (int)(this.sdD.y * this.sdG);
        paramInt = Math.max(Math.min(paramInt, this.sdD.x), 0);
        i = Math.max(Math.min(i, this.sdD.y), 0);
        j = getTargetPositionXWhenOrientationChanged();
        k = Fv(i);
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
      AppMethodBeat.o(186940);
      return;
      localObject = "null";
      break;
    }
  }
  
  private boolean Ft(int paramInt)
  {
    AppMethodBeat.i(176987);
    if (getCurrentStateWidth() + paramInt != this.sdD.x)
    {
      AppMethodBeat.o(176987);
      return true;
    }
    AppMethodBeat.o(176987);
    return false;
  }
  
  private static int Fv(int paramInt)
  {
    int i;
    if (paramInt < e.saT) {
      i = e.saT;
    }
    do
    {
      return i;
      i = paramInt;
    } while (paramInt <= e.saU);
    return e.saU;
  }
  
  private int Fw(int paramInt)
  {
    AppMethodBeat.i(106465);
    int i = 0;
    if (!Fu(paramInt)) {
      i = this.sdD.x - getCurrentStateWidth();
    }
    AppMethodBeat.o(106465);
    return i;
  }
  
  private int Fx(int paramInt)
  {
    AppMethodBeat.i(187004);
    int i = getWidth();
    if (FS(paramInt)) {
      i = scd;
    }
    for (;;)
    {
      AppMethodBeat.o(187004);
      return i;
      if ((FT(paramInt)) || ((!FR(paramInt)) && (FG(paramInt)))) {
        i = scN;
      } else if (FU(paramInt)) {
        i = scO;
      } else if ((FV(paramInt)) || (FW(paramInt))) {
        i = scP;
      } else if ((FX(paramInt)) || (FY(paramInt))) {
        i = scf;
      } else if ((FZ(paramInt)) || (Ga(paramInt))) {
        i = scf + scH;
      }
    }
  }
  
  private int Fy(int paramInt)
  {
    AppMethodBeat.i(187006);
    int i = getHeight();
    if (FS(paramInt)) {
      paramInt = sce;
    }
    for (;;)
    {
      AppMethodBeat.o(187006);
      return paramInt;
      if (FT(paramInt))
      {
        paramInt = scN;
      }
      else if (FU(paramInt))
      {
        paramInt = scO;
      }
      else if ((FV(paramInt)) || (FW(paramInt)))
      {
        paramInt = scO;
      }
      else if ((FX(paramInt)) || (FY(paramInt)) || (FZ(paramInt)) || (Ga(paramInt)))
      {
        paramInt = scg;
      }
      else if (!FZ(this.sca))
      {
        paramInt = i;
        if (!Ga(this.sca)) {}
      }
      else
      {
        paramInt = scg;
      }
    }
  }
  
  private void Fz(int paramInt)
  {
    this.sca &= (paramInt ^ 0xFFFFFFFF);
  }
  
  private int G(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(106454);
    int i = (int)Math.max(Math.min(this.sdF.x + paramMotionEvent.getRawX() - this.sdE.x, this.sdD.x), 0.0F);
    AppMethodBeat.o(106454);
    return i;
  }
  
  private int G(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(176983);
    this.sdb.setVisibility(0);
    boolean bool1 = FQ(this.sca);
    boolean bool2 = FP(this.sca);
    boolean bool3 = FO(this.sca);
    boolean bool4 = FN(this.sca);
    boolean bool5 = FE(this.sca);
    boolean bool6 = FH(this.sca);
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
      if ((FR(this.sca)) || (!FG(this.sca))) {
        break label364;
      }
      k = 1;
      if ((!bool4) && (k == 0)) {
        break label370;
      }
      i2 = scL;
      if ((paramBoolean2) || (bool5) || (bool6)) {
        break label385;
      }
      if ((!bool4) && (!bool2) && (!bool1) && (k == 0)) {
        break label378;
      }
      i = scL;
      m = i;
      j = i;
      i = m;
      if ((!bool4) && (k == 0)) {
        break label473;
      }
      this.sdc.setVisibility(0);
      this.sdd.setVisibility(8);
      this.sde.setVisibility(8);
      this.sdf.setVisibility(8);
      m = 0;
      k = m;
      if (!FR(this.sca))
      {
        k = m;
        if (FG(this.sca)) {
          k = getAppBrandVoipBallInfoIndex();
        }
      }
      a(this.sdc, k);
      localLayoutParams1 = (FrameLayout.LayoutParams)this.sdc.getLayoutParams();
      localLayoutParams1.setMargins(j, i2, i, i2);
      localLayoutParams1.gravity = i1;
      this.sdc.setLayoutParams(localLayoutParams1);
    }
    label364:
    label370:
    label378:
    while ((!bool3) && (!bool2) && (!bool1))
    {
      localLayoutParams1 = (FrameLayout.LayoutParams)this.sdb.getLayoutParams();
      localLayoutParams1.gravity = (i1 | 0x10);
      this.sdb.setLayoutParams(localLayoutParams1);
      if ((!bool2) && (!bool1)) {
        break label959;
      }
      k = scH;
      AppMethodBeat.o(176983);
      return k * 2 + j + i;
      i1 = 8388613;
      break;
      k = 0;
      break label100;
      i2 = scJ;
      break label115;
      i = scM;
      break label153;
      if (paramBoolean1)
      {
        if ((bool5) && (!bool6))
        {
          j = scJ;
          if (!bool5) {
            break label424;
          }
        }
        for (i = scJ;; i = scL)
        {
          break;
          j = scK;
          break label404;
        }
      }
      if (bool5)
      {
        j = scJ;
        if ((!bool5) || (bool6)) {
          break label466;
        }
      }
      for (i = scJ;; i = scK)
      {
        break;
        j = scL;
        break label441;
      }
    }
    label385:
    label404:
    label424:
    label441:
    label466:
    label473:
    this.sdc.setVisibility(0);
    this.sdd.setVisibility(0);
    a(this.sdc, 0);
    a(this.sdd, 1);
    int n;
    int i3;
    if (bool2)
    {
      this.sde.setVisibility(0);
      this.sdf.setVisibility(8);
      a(this.sde, 2);
      if (paramBoolean1)
      {
        m = j + scH;
        n = 0;
        k = i;
        i3 = j;
        label575:
        localLayoutParams1 = (FrameLayout.LayoutParams)this.sde.getLayoutParams();
        localLayoutParams1.setMargins(i3, 0, n, 0);
        localLayoutParams1.gravity = (i1 | 0x10);
        this.sde.setLayoutParams(localLayoutParams1);
        n = m;
        m = k;
      }
    }
    for (;;)
    {
      localLayoutParams1 = (FrameLayout.LayoutParams)this.sdc.getLayoutParams();
      localLayoutParams1.setMargins(n, i2, m, 0);
      localLayoutParams1.gravity = i1;
      this.sdc.setLayoutParams(localLayoutParams1);
      FrameLayout.LayoutParams localLayoutParams2 = (FrameLayout.LayoutParams)this.sdd.getLayoutParams();
      k = scH;
      localLayoutParams2.setMargins(n, localLayoutParams1.topMargin + k, m, i2);
      localLayoutParams2.gravity = i1;
      this.sdd.setLayoutParams(localLayoutParams2);
      break;
      i3 = 0;
      k = scH;
      n = i;
      k += i;
      m = j;
      break label575;
      if (bool1)
      {
        this.sde.setVisibility(0);
        this.sdf.setVisibility(0);
        a(this.sde, 2);
        a(this.sdf, 3);
        if (paramBoolean1)
        {
          k = scH;
          n = 0;
          m = i;
          k += j;
        }
        for (i3 = j;; i3 = 0)
        {
          localLayoutParams1 = (FrameLayout.LayoutParams)this.sde.getLayoutParams();
          localLayoutParams1.setMargins(i3, i2, n, 0);
          localLayoutParams1.gravity = i1;
          this.sde.setLayoutParams(localLayoutParams1);
          localLayoutParams2 = (FrameLayout.LayoutParams)this.sdf.getLayoutParams();
          int i4 = scH;
          localLayoutParams2.setMargins(i3, localLayoutParams1.topMargin + i4, n, 0);
          localLayoutParams2.gravity = i1;
          this.sdf.setLayoutParams(localLayoutParams2);
          n = k;
          break;
          k = scH;
          n = i;
          m = k + i;
          k = j;
        }
      }
      this.sdf.setVisibility(8);
      this.sde.setVisibility(8);
      m = i;
      n = j;
    }
    label959:
    int k = scH;
    AppMethodBeat.o(176983);
    return k + j + i;
  }
  
  private static boolean Ga(int paramInt)
  {
    AppMethodBeat.i(187121);
    if ((FQ(paramInt)) && (FE(paramInt)) && (!FH(paramInt)))
    {
      AppMethodBeat.o(187121);
      return true;
    }
    AppMethodBeat.o(187121);
    return false;
  }
  
  private static boolean Gb(int paramInt)
  {
    AppMethodBeat.i(187123);
    if ((FJ(paramInt)) && (!FE(paramInt)) && (!FF(paramInt)))
    {
      AppMethodBeat.o(187123);
      return true;
    }
    AppMethodBeat.o(187123);
    return false;
  }
  
  private static boolean Gc(int paramInt)
  {
    AppMethodBeat.i(187125);
    if ((FM(paramInt)) && (!FE(paramInt)) && (!FF(paramInt)))
    {
      AppMethodBeat.o(187125);
      return true;
    }
    AppMethodBeat.o(187125);
    return false;
  }
  
  private static boolean Gd(int paramInt)
  {
    AppMethodBeat.i(187128);
    if ((FI(paramInt)) && (!FE(paramInt)) && (!FF(paramInt)))
    {
      AppMethodBeat.o(187128);
      return true;
    }
    AppMethodBeat.o(187128);
    return false;
  }
  
  private static boolean Ge(int paramInt)
  {
    AppMethodBeat.i(187139);
    if ((FE(paramInt)) && (FH(paramInt)) && (!FF(paramInt)))
    {
      AppMethodBeat.o(187139);
      return true;
    }
    AppMethodBeat.o(187139);
    return false;
  }
  
  private int H(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(106455);
    int i = (int)Math.max(Math.min(this.sdF.y + paramMotionEvent.getRawY() - this.sdE.y, this.sdD.y), 0.0F);
    AppMethodBeat.o(106455);
    return i;
  }
  
  private static boolean K(BallInfo paramBallInfo)
  {
    return (paramBallInfo != null) && (paramBallInfo.state == 2048);
  }
  
  private void L(int paramInt, long paramLong)
  {
    AppMethodBeat.i(176984);
    if (paramInt == 0)
    {
      a(this.sdc, paramLong);
      AppMethodBeat.o(176984);
      return;
    }
    if (paramInt == 1)
    {
      a(this.sdd, paramLong);
      AppMethodBeat.o(176984);
      return;
    }
    if (paramInt == 2)
    {
      a(this.sde, paramLong);
      AppMethodBeat.o(176984);
      return;
    }
    if (paramInt == 3) {
      a(this.sdf, paramLong);
    }
    AppMethodBeat.o(176984);
  }
  
  private static boolean L(BallInfo paramBallInfo)
  {
    return (paramBallInfo != null) && ((paramBallInfo.state == 4) || (paramBallInfo.state == 512));
  }
  
  private static boolean M(BallInfo paramBallInfo)
  {
    return (paramBallInfo != null) && ((paramBallInfo.state == 8) || (paramBallInfo.state == 1024));
  }
  
  private void U(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(186983);
    this.sdE.x = paramMotionEvent.getRawX();
    this.sdE.y = paramMotionEvent.getRawY();
    paramMotionEvent = (WindowManager.LayoutParams)getLayoutParams();
    this.sdF.x = paramMotionEvent.x;
    this.sdF.y = paramMotionEvent.y;
    AppMethodBeat.o(186983);
  }
  
  private void V(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(106475);
    Iterator localIterator = this.listeners.iterator();
    while (localIterator.hasNext()) {
      ((g)localIterator.next()).T(paramMotionEvent);
    }
    AppMethodBeat.o(106475);
  }
  
  private void Y(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.sdG = (paramInt / this.sdD.y);
    }
    this.sdH = paramInt;
  }
  
  private void a(CircleAnimateView paramCircleAnimateView, int paramInt)
  {
    AppMethodBeat.i(176986);
    if ((com.tencent.mm.plugin.ball.f.d.checkListNotEmpty(this.sdz)) && (this.sdz.size() > paramInt))
    {
      BallInfo localBallInfo = (BallInfo)this.sdz.get(paramInt);
      paramInt = com.tencent.mm.plugin.ball.f.d.Fn(localBallInfo.state);
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
    if ((this.sdY == paramBoolean1) && (this.sdZ == paramBoolean2) && (this.sdX == paramBoolean3) && (this.sea == paramInt))
    {
      AppMethodBeat.o(176989);
      return;
    }
    Log.i("MicroMsg.FloatBallView", "updateFloatBallBackground, isSettled:%s, isDockLeft:%s, isManual:%s, state:%s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3), Integer.valueOf(paramInt) });
    this.sea = paramInt;
    this.sdX = paramBoolean3;
    this.sdY = paramBoolean1;
    this.sdZ = paramBoolean2;
    boolean bool1 = FH(paramInt);
    boolean bool2 = FT(paramInt);
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        if (paramBoolean3)
        {
          if (bool1)
          {
            this.scX.setBackground(this.sdv);
            AppMethodBeat.o(176989);
            return;
          }
          if (bool2)
          {
            this.scX.setBackground(this.sdp);
            AppMethodBeat.o(176989);
            return;
          }
          this.scX.setBackground(this.sdj);
          AppMethodBeat.o(176989);
          return;
        }
        if (bool1)
        {
          this.scX.setBackground(this.sds);
          AppMethodBeat.o(176989);
          return;
        }
        if (bool2)
        {
          this.scX.setBackground(this.sdm);
          AppMethodBeat.o(176989);
          return;
        }
        this.scX.setBackground(this.sdg);
        AppMethodBeat.o(176989);
        return;
      }
      if (paramBoolean3)
      {
        if (bool1)
        {
          this.scX.setBackground(this.sdw);
          AppMethodBeat.o(176989);
          return;
        }
        if (bool2)
        {
          this.scX.setBackground(this.sdq);
          AppMethodBeat.o(176989);
          return;
        }
        this.scX.setBackground(this.sdk);
        AppMethodBeat.o(176989);
        return;
      }
      if (bool1)
      {
        this.scX.setBackground(this.sdt);
        AppMethodBeat.o(176989);
        return;
      }
      if (bool2)
      {
        this.scX.setBackground(this.sdn);
        AppMethodBeat.o(176989);
        return;
      }
      this.scX.setBackground(this.sdh);
      AppMethodBeat.o(176989);
      return;
    }
    if (paramBoolean3)
    {
      if (bool1)
      {
        this.scX.setBackground(this.sdx);
        AppMethodBeat.o(176989);
        return;
      }
      if (bool2)
      {
        this.scX.setBackground(this.sdr);
        AppMethodBeat.o(176989);
        return;
      }
      this.scX.setBackground(this.sdl);
      AppMethodBeat.o(176989);
      return;
    }
    if (bool1)
    {
      this.scX.setBackground(this.sdu);
      AppMethodBeat.o(176989);
      return;
    }
    if (bool2)
    {
      this.scX.setBackground(this.sdo);
      AppMethodBeat.o(176989);
      return;
    }
    this.scX.setBackground(this.sdi);
    AppMethodBeat.o(176989);
  }
  
  private void cn(List<BallInfo> paramList)
  {
    AppMethodBeat.i(106443);
    this.scb = this.sca;
    this.sca = 0;
    if (AppForegroundDelegate.fby.cQt) {
      this.sca |= 0x20;
    }
    List localList = com.tencent.mm.plugin.ball.f.d.cf(com.tencent.mm.plugin.ball.f.d.cd(com.tencent.mm.plugin.ball.f.d.ce(paramList)));
    this.sdz = com.tencent.mm.plugin.ball.f.d.ca(localList);
    int i = com.tencent.mm.plugin.ball.f.d.Fl(com.tencent.mm.plugin.ball.f.d.ck(localList));
    boolean bool1 = com.tencent.mm.plugin.ball.f.d.cb(com.tencent.mm.plugin.ball.f.d.ci(paramList));
    if (bool1) {
      this.sca |= 0x1;
    }
    boolean bool3;
    boolean bool4;
    if (i == 1)
    {
      this.sca |= 0x2;
      this.scc = i;
      this.sdL = com.tencent.mm.plugin.ball.f.d.cg(paramList);
      boolean bool2 = K(this.sdL);
      bool3 = L(this.sdL);
      bool4 = M(this.sdL);
      if (!bool2) {
        break label387;
      }
      this.sca |= 0x1000;
      label163:
      if (this.sdL != null)
      {
        if (this.sdL.state != 512) {
          break label422;
        }
        this.sca |= 0x400;
      }
      label195:
      if ((this.sdL != null) && (this.sdL.bFK != null)) {
        setCustomView(this.sdL);
      }
      this.sdM = com.tencent.mm.plugin.ball.f.d.ch(paramList);
      if (this.sdM != null)
      {
        if (this.sdM.state != 32) {
          break label450;
        }
        this.sca |= 0x100;
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.FloatBallView", ">>> updateFloatBallViewLayoutState, state:[%s => %s], active:%s, passiveCnt:%d, video:%s, audio:%s <<<", new Object[] { Integer.valueOf(this.scb), Integer.valueOf(this.sca), Boolean.valueOf(bool1), Integer.valueOf(i), Boolean.valueOf(bool3), Boolean.valueOf(bool4) });
      AppMethodBeat.o(106443);
      return;
      if (i == 2)
      {
        this.sca |= 0x4;
        break;
      }
      if (i == 3)
      {
        this.sca |= 0x40;
        break;
      }
      if (i != 4) {
        break;
      }
      this.sca |= 0x80;
      break;
      label387:
      if (bool3) {
        this.sca |= 0x8;
      }
      if (!bool4) {
        break label163;
      }
      this.sca |= 0x10;
      break label163;
      label422:
      if (this.sdL.state != 1024) {
        break label195;
      }
      this.sca |= 0x800;
      break label195;
      label450:
      if (this.sdM.state == 64) {
        this.sca |= 0x200;
      }
    }
  }
  
  private static String co(List<BallInfo> paramList)
  {
    AppMethodBeat.i(106474);
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramList.size())
    {
      BallInfo localBallInfo = (BallInfo)paramList.get(i);
      localStringBuilder.append(localBallInfo.key).append(localBallInfo.type).append(localBallInfo.icon).append(localBallInfo.qpN).append(localBallInfo.state).append(localBallInfo.rYr).append(localBallInfo.qmt).append(localBallInfo.progress);
      if ((com.tencent.mm.plugin.ball.f.d.H(localBallInfo)) && (localBallInfo.bFK != null)) {
        localStringBuilder.append(localBallInfo.bFK.hashCode());
      }
      localStringBuilder.append("|");
      i += 1;
    }
    paramList = MD5Util.getMD5String(localStringBuilder.toString());
    AppMethodBeat.o(106474);
    return paramList;
  }
  
  private void cwG()
  {
    AppMethodBeat.i(176977);
    if (FH(this.sca))
    {
      View localView = this.olM;
      if ((FE(this.sca)) || (FF(this.sca))) {}
      boolean bool;
      for (int i = 0;; i = 4)
      {
        localView.setVisibility(i);
        this.scY.setVisibility(0);
        bool = FD(this.sca);
        if ((!FJ(this.sca)) && (!FI(this.sca))) {
          break label167;
        }
        if ((!Gb(this.sca)) && (!Gd(this.sca))) {
          break;
        }
        this.olM.setVisibility(4);
        f(true, false, bool);
        this.scZ.setVisibility(8);
        AppMethodBeat.o(176977);
        return;
      }
      f(true, false, bool);
      this.scZ.setVisibility(0);
      cwH();
      AppMethodBeat.o(176977);
      return;
      label167:
      if (FM(this.sca))
      {
        if (Gc(this.sca))
        {
          this.olM.setVisibility(4);
          f(false, true, bool);
          this.scZ.setVisibility(8);
          AppMethodBeat.o(176977);
          return;
        }
        f(false, true, bool);
        this.scZ.setVisibility(0);
        cwH();
      }
      AppMethodBeat.o(176977);
      return;
    }
    this.olM.setVisibility(8);
    this.scY.setVisibility(8);
    this.scZ.setVisibility(0);
    cwH();
    AppMethodBeat.o(176977);
  }
  
  private void cwH()
  {
    AppMethodBeat.i(176978);
    Object localObject = (LinearLayout.LayoutParams)this.scZ.getLayoutParams();
    if (FH(this.sca)) {}
    for (int i = 8388629;; i = 8388627)
    {
      ((LinearLayout.LayoutParams)localObject).gravity = i;
      this.scZ.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if ((!FE(this.sca)) || (!FF(this.sca))) {
        break;
      }
      cwK();
      AppMethodBeat.o(176978);
      return;
    }
    if ((Ge(this.sca)) || (FS(this.sca)))
    {
      this.sdb.setVisibility(8);
      this.sda.setVisibility(0);
      localObject = (FrameLayout.LayoutParams)this.sda.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).gravity = 8388629;
      i = scK;
      int j = scK;
      ((FrameLayout.LayoutParams)localObject).setMargins(i, i, j, j);
      this.sda.setLayoutParams((ViewGroup.LayoutParams)localObject);
      AppMethodBeat.o(176978);
      return;
    }
    if (FF(this.sca))
    {
      this.sda.setVisibility(8);
      G(true, true);
    }
    AppMethodBeat.o(176978);
  }
  
  private void cwI()
  {
    AppMethodBeat.i(176979);
    int i;
    boolean bool;
    if (FH(this.sca))
    {
      View localView = this.olM;
      if ((FE(this.sca)) || (FF(this.sca)))
      {
        i = 0;
        localView.setVisibility(i);
        this.scY.setVisibility(0);
        bool = FD(this.sca);
        if ((!FJ(this.sca)) && (!FI(this.sca))) {
          break label168;
        }
        if ((!Gb(this.sca)) && (!Gd(this.sca))) {
          break label146;
        }
        this.olM.setVisibility(4);
        f(true, false, bool);
        this.scZ.setVisibility(8);
      }
    }
    for (;;)
    {
      cwM();
      AppMethodBeat.o(176979);
      return;
      i = 4;
      break;
      label146:
      f(true, false, bool);
      this.scZ.setVisibility(0);
      cwJ();
      continue;
      label168:
      if (Gc(this.sca))
      {
        this.olM.setVisibility(4);
        f(false, true, bool);
        this.scZ.setVisibility(8);
      }
      else
      {
        f(false, true, bool);
        this.scZ.setVisibility(0);
        cwJ();
        continue;
        this.olM.setVisibility(8);
        this.scY.setVisibility(8);
        this.scZ.setVisibility(0);
        cwJ();
      }
    }
  }
  
  private void cwJ()
  {
    AppMethodBeat.i(176980);
    Object localObject = (LinearLayout.LayoutParams)this.scZ.getLayoutParams();
    if (FH(this.sca)) {}
    for (int i = 8388627;; i = 8388629)
    {
      ((LinearLayout.LayoutParams)localObject).gravity = i;
      this.scZ.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if ((!FE(this.sca)) || (!FF(this.sca))) {
        break;
      }
      cwL();
      AppMethodBeat.o(176980);
      return;
    }
    if ((Ge(this.sca)) || (FS(this.sca)))
    {
      this.sdb.setVisibility(8);
      this.sda.setVisibility(0);
      localObject = (FrameLayout.LayoutParams)this.sda.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).gravity = 8388629;
      i = scK;
      int j = scK;
      ((FrameLayout.LayoutParams)localObject).setMargins(i, i, j, j);
      this.sda.setLayoutParams((ViewGroup.LayoutParams)localObject);
      AppMethodBeat.o(176980);
      return;
    }
    if (FF(this.sca))
    {
      this.sda.setVisibility(8);
      G(false, true);
    }
    AppMethodBeat.o(176980);
  }
  
  private void cwK()
  {
    AppMethodBeat.i(176981);
    int i = G(true, true);
    this.sda.setVisibility(0);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.sda.getLayoutParams();
    localLayoutParams.gravity = 8388627;
    int j = scK;
    localLayoutParams.setMargins(i, j, j, scK);
    this.sda.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(176981);
  }
  
  private void cwL()
  {
    AppMethodBeat.i(176982);
    int i = G(false, true);
    this.sda.setVisibility(0);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.sda.getLayoutParams();
    localLayoutParams.gravity = 8388629;
    int j = scK;
    localLayoutParams.setMargins(j, j, i, scK);
    this.sda.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(176982);
  }
  
  private boolean cwM()
  {
    AppMethodBeat.i(106451);
    WindowManager.LayoutParams localLayoutParams = (WindowManager.LayoutParams)getLayoutParams();
    int i = localLayoutParams.x;
    int j = localLayoutParams.y;
    if (Ft(i))
    {
      i = Math.max(Math.min(i, this.sdD.x), 0);
      j = Math.max(Math.min(j, this.sdD.y), 0);
      int k = Fw(i);
      int m = Fv(j);
      Log.i("MicroMsg.FloatBallView", "stickToScreenEdgeIfNeed, start:[%s, %s], target:[%s, %s]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m) });
      if ((i != k) || (j != m)) {
        d(k, m, true, false);
      }
      AppMethodBeat.o(106451);
      return true;
    }
    AppMethodBeat.o(106451);
    return false;
  }
  
  private void cwN()
  {
    AppMethodBeat.i(176990);
    int i = 0;
    while (i < this.sdz.size())
    {
      long l = ((BallInfo)this.sdz.get(i)).progress;
      if (l >= 0L) {
        L(i, l);
      }
      i += 1;
    }
    AppMethodBeat.o(176990);
  }
  
  private void cwO()
  {
    AppMethodBeat.i(186991);
    if (this.sak) {
      d(new AnimatorListenerAdapter()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(188846);
          super.onAnimationCancel(paramAnonymousAnimator);
          FloatBallView.a(FloatBallView.this, false);
          AppMethodBeat.o(188846);
        }
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(188844);
          super.onAnimationEnd(paramAnonymousAnimator);
          FloatBallView.a(FloatBallView.this, false);
          AppMethodBeat.o(188844);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(188842);
          super.onAnimationStart(paramAnonymousAnimator);
          FloatBallView.a(FloatBallView.this, true);
          AppMethodBeat.o(188842);
        }
      });
    }
    AppMethodBeat.o(186991);
  }
  
  private void cwQ()
  {
    AppMethodBeat.i(106468);
    int i;
    int k;
    int m;
    int j;
    if (FR(this.sca)) {
      if (FH(this.sca))
      {
        i = FB(this.sca);
        k = this.sdO * 2 + i;
        m = FC(this.sca) + this.sdO * 2;
        if (!FE(this.sca))
        {
          i = m;
          j = k;
          if (!FF(this.sca)) {}
        }
        else
        {
          i = m + (scI + scK * 2 + scQ);
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
        j = this.sdN.x + (j + m + n);
        i = this.sdN.y + (i + k);
      }
      for (;;)
      {
        fx(j, i);
        AppMethodBeat.o(106468);
        return;
        j = Fx(this.sca);
        i = Fy(this.sca);
        break;
        if (FH(this.sca))
        {
          if ((this.sdL != null) && (this.sdL.rYu))
          {
            i = 0;
            j = 0;
            break;
          }
          i = FB(this.sca);
          j = this.sdO * 2 + i;
          i = FC(this.sca) + this.sdO * 2;
          break;
        }
        if (!FG(this.sca)) {
          break label291;
        }
        j = scN;
        i = scN;
        break;
        i = 0;
        j = 0;
      }
      label291:
      i = 0;
      j = 0;
    }
  }
  
  private void cwR()
  {
    AppMethodBeat.i(187043);
    if (((int)getAlpha() == 1) && (getVisibility() == 0))
    {
      int i = getResources().getConfiguration().orientation;
      if (i != this.lastOrientation)
      {
        Log.i("MicroMsg.FloatBallView", "alvinluo checkOrientationIfNeed currentOrientation: %d, lastOrientation: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(this.lastOrientation) });
        Fs(i);
      }
    }
    AppMethodBeat.o(187043);
  }
  
  private void cwS()
  {
    AppMethodBeat.i(187050);
    if (!this.sdP)
    {
      AppMethodBeat.o(187050);
      return;
    }
    try
    {
      WindowManager.LayoutParams localLayoutParams;
      int i;
      if ((this.sdN.x != 0) || (this.sdN.y != 0))
      {
        localLayoutParams = (WindowManager.LayoutParams)getLayoutParams();
        if (!this.sdC) {
          break label103;
        }
        i = 0;
      }
      for (;;)
      {
        int j = localLayoutParams.y;
        int k = this.sdN.y;
        cwT();
        this.sdQ = 16;
        cwQ();
        d(i, j + k, true, false);
        AppMethodBeat.o(187050);
        return;
        label103:
        i = localLayoutParams.x;
        j = this.sdN.x;
        i += j;
      }
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.FloatBallView", localException, "alvinluo resetFloatBallViewSizeAndPosition", new Object[0]);
      AppMethodBeat.o(187050);
    }
  }
  
  private void cwT()
  {
    AppMethodBeat.i(187053);
    Log.v("MicroMsg.FloatBallView", "alvinluo resetExtraSize");
    this.sdN.x = 0;
    this.sdN.y = 0;
    AppMethodBeat.o(187053);
  }
  
  private void d(AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(186999);
    Log.i("MicroMsg.FloatBallView", "alvinluo showByTranslation");
    setNeedTranslateAnimation(false);
    if (this.scV != null)
    {
      boolean bool = Fu(((WindowManager.LayoutParams)getLayoutParams()).x);
      this.scV.a(getCurrentStateWidth(), bool, paramAnimatorListenerAdapter);
    }
    AppMethodBeat.o(186999);
  }
  
  private void d(boolean paramBoolean, final int paramInt1, final int paramInt2, final int paramInt3, final int paramInt4)
  {
    AppMethodBeat.i(106464);
    Log.i("MicroMsg.FloatBallView", "start StickyAnimation, stickToLeft:%s, startPositionY: %d, targetPositionY: %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2), Integer.valueOf(paramInt4) });
    if ((this.scU != null) && (this.scU.isRunning()))
    {
      Log.i("MicroMsg.FloatBallView", "cancel StickyAnimation");
      this.scU.cancel();
    }
    this.scU = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.scU.setInterpolator(new AccelerateDecelerateInterpolator());
    this.scU.setDuration(100L);
    this.scU.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(186519);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        int i = paramInt1;
        int j = (int)((paramInt3 * 1.0F - paramInt1) * f);
        int k = paramInt2;
        int m = (int)(f * (paramInt4 * 1.0F - paramInt2));
        FloatBallView.this.d(i + j, m + k, false, false);
        AppMethodBeat.o(186519);
      }
    });
    this.scU.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(186908);
        super.onAnimationEnd(paramAnonymousAnimator);
        paramAnonymousAnimator = (WindowManager.LayoutParams)FloatBallView.this.getLayoutParams();
        FloatBallView.this.f(paramAnonymousAnimator.x, paramAnonymousAnimator.y, true, false);
        AppMethodBeat.o(186908);
      }
    });
    this.scU.start();
    AppMethodBeat.o(106464);
  }
  
  private void e(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(186986);
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
        AppMethodBeat.o(186986);
        return;
      }
      catch (Throwable localThrowable)
      {
        Log.printErrStackTrace("MicroMsg.FloatBallView", localThrowable, "updateBallPosition fail", new Object[0]);
      }
    }
    AppMethodBeat.o(186986);
  }
  
  private void e(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(186947);
    if ((this.sdS == paramBoolean1) && (this.sdT == paramBoolean2) && (this.sdR == paramBoolean3) && (this.sdU != 0) && (this.sdU == this.sca))
    {
      Log.d("MicroMsg.FloatBallView", "<<< updateFloatBallViewLayout, ignore layout %b %b;%b %b; %b %b; %d %d", new Object[] { Boolean.valueOf(this.sdY), Boolean.valueOf(paramBoolean1), Boolean.valueOf(this.sdT), Boolean.valueOf(paramBoolean2), Boolean.valueOf(this.sdR), Boolean.valueOf(paramBoolean3), Integer.valueOf(this.sdU), Integer.valueOf(this.sca) });
      AppMethodBeat.o(186947);
      return;
    }
    Log.i("MicroMsg.FloatBallView", ">>> updateFloatBallViewLayout, isSettled:%s, isDockLeft:%s, isManual:%s, lastLayoutState:%s, currentLayoutState:%s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3), Integer.valueOf(this.sdU), Integer.valueOf(this.sca) });
    this.sdR = paramBoolean3;
    this.sdS = paramBoolean1;
    this.sdT = paramBoolean2;
    this.sdU = this.sca;
    cwQ();
    F(paramBoolean1, paramBoolean2);
    AppMethodBeat.o(186947);
  }
  
  private void f(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(186953);
    int i = g(paramBoolean1, paramBoolean2, paramBoolean3);
    int j = a(this.sca, paramBoolean1, paramBoolean2, paramBoolean3);
    Log.v("MicroMsg.FloatBallView", "alvinluo updateCustomViewLayout width: %d, height: %d, margin: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(this.sdO) });
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.scY.getLayoutParams();
    localLayoutParams.width = i;
    localLayoutParams.height = j;
    if (this.sdO > 0) {
      localLayoutParams.setMargins(this.sdO, this.sdO, this.sdO, this.sdO);
    }
    this.scY.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(186953);
  }
  
  private void fx(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(187013);
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
          ((g)localIterator.next()).a(localLayoutParams.x, localLayoutParams.y, localLayoutParams.height, this.sdS, this.sdC);
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
      AppMethodBeat.o(187013);
    }
  }
  
  private int getAppBrandVoipBallInfoIndex()
  {
    AppMethodBeat.i(186976);
    if (com.tencent.mm.plugin.ball.f.d.checkListNotEmpty(this.sdz))
    {
      int i = 0;
      while (i < this.sdz.size())
      {
        BallInfo localBallInfo = (BallInfo)this.sdz.get(i);
        if ((localBallInfo != null) && (localBallInfo.type == 17))
        {
          AppMethodBeat.o(186976);
          return i;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(186976);
    return 0;
  }
  
  private int getCurrentStateHeight()
  {
    AppMethodBeat.i(176991);
    int k = this.sca;
    Log.v("MicroMsg.FloatBallView", "getStateHeight state: %d", new Object[] { Integer.valueOf(k) });
    int j;
    if (FH(k))
    {
      j = FC(k) + this.sdO * 2;
      if (!FE(k))
      {
        i = j;
        if (!FF(k)) {
          break label83;
        }
      }
    }
    for (int i = j + (scI + scK * 2 + scQ);; i = Fy(k))
    {
      label83:
      j = e.saM;
      k = e.saN;
      AppMethodBeat.o(176991);
      return i + j + k;
    }
  }
  
  private int getExtendWidth()
  {
    AppMethodBeat.i(106469);
    if (!this.sdI)
    {
      AppMethodBeat.o(106469);
      return 0;
    }
    if (!com.tencent.mm.plugin.ball.f.d.eI(getContext()))
    {
      AppMethodBeat.o(106469);
      return 0;
    }
    int i = this.windowManager.getDefaultDisplay().getRotation();
    if (((this.sdC) && (i == 1)) || ((!this.sdC) && (i == 3)))
    {
      i = com.tencent.mm.plugin.ball.f.d.aM(getContext());
      AppMethodBeat.o(106469);
      return i;
    }
    AppMethodBeat.o(106469);
    return 0;
  }
  
  private int getHorizontalShadowSize()
  {
    if ((this.sdL != null) && (this.sdL.rYn != null))
    {
      if (this.sdL.rYn.y > 0) {
        return this.sdL.rYn.y;
      }
      return e.saO * 2;
    }
    return e.saO * 2;
  }
  
  private int getTargetPositionXWhenOrientationChanged()
  {
    AppMethodBeat.i(106466);
    int i = 0;
    if (!this.sdC) {
      i = this.sdD.x - getCurrentStateWidth();
    }
    AppMethodBeat.o(106466);
    return i;
  }
  
  private int getVerticalShadowSize()
  {
    if ((this.sdL != null) && (this.sdL.rYn != null))
    {
      if (this.sdL.rYn.x > 0) {
        return this.sdL.rYn.x;
      }
      return e.saM + e.saN;
    }
    return e.saM + e.saN;
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
  
  public final boolean FD(int paramInt)
  {
    AppMethodBeat.i(187067);
    if ((FE(paramInt)) && (this.scc >= 3))
    {
      AppMethodBeat.o(187067);
      return true;
    }
    AppMethodBeat.o(187067);
    return false;
  }
  
  public final boolean Fu(int paramInt)
  {
    AppMethodBeat.i(106459);
    if (getCurrentStateWidth() / 2 + paramInt <= this.sdD.x / 2)
    {
      AppMethodBeat.o(106459);
      return true;
    }
    AppMethodBeat.o(106459);
    return false;
  }
  
  public final void X(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(186951);
    Object localObject = (FrameLayout.LayoutParams)this.scX.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject).gravity = paramInt;
    this.scX.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if ((!paramBoolean) && (!FR(this.sca)) && (this.scZ.getVisibility() == 0))
    {
      localObject = (LinearLayout.LayoutParams)this.scZ.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).gravity = 17;
      this.scZ.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    AppMethodBeat.o(186951);
  }
  
  public final int a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(187060);
    int i = 0;
    if ((paramBoolean1) || (paramBoolean2))
    {
      if ((this.rYm != null) && (this.rYm.x > 0) && (this.rYm.y > 0)) {
        i = this.rYm.y;
      }
      while (paramBoolean3)
      {
        if ((!FK(paramInt)) && (!FL(paramInt))) {
          break label167;
        }
        if ((this.rYm != null) && (this.rYm.x > 0) && (this.rYm.y > 0))
        {
          paramInt = this.rYm.y;
          AppMethodBeat.o(187060);
          return paramInt;
          if (paramBoolean1) {
            i = scA + scR * 2;
          } else {
            i = scE + scR * 2;
          }
        }
        else
        {
          i = scE + scR * 2;
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(187060);
      return i;
      label167:
      if (paramBoolean1) {
        i = scC + scR * 2;
      } else {
        i = scG + scR * 2;
      }
    }
  }
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(187071);
    this.listeners.add(paramg);
    AppMethodBeat.o(187071);
  }
  
  public final void a(List<BallInfo> paramList, BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106442);
    paramBallInfo = co(paramList);
    if (Util.isEqual(paramBallInfo, this.sdy))
    {
      Log.d("MicroMsg.FloatBallView", "<<< onFloatBallInfoChanged, ignore refresh");
      AppMethodBeat.o(106442);
      return;
    }
    Log.i("MicroMsg.FloatBallView", ">>> onFloatBallInfoChanged, ballInfoList:%s", new Object[] { paramList });
    this.sdy = paramBallInfo;
    cn(paramList);
    cwN();
    boolean bool = Fu(((WindowManager.LayoutParams)getLayoutParams()).x);
    e(true, bool, false);
    a(true, bool, false, this.sca);
    cwO();
    AppMethodBeat.o(106442);
  }
  
  public final void b(boolean paramBoolean, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(184624);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.eL(paramBoolean);
    localb.bn(paramAnimatorListenerAdapter);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/ball/view/FloatBallView", "com/tencent/mm/plugin/ball/view/FloatBallView", "hide", "(ZLandroid/animation/AnimatorListenerAdapter;)V", this, localb.aFi());
    if (getVisibility() == 8)
    {
      Log.i("MicroMsg.FloatBallView", "float ball already hide");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ball/view/FloatBallView", "com/tencent/mm/plugin/ball/view/FloatBallView", "hide", "(ZLandroid/animation/AnimatorListenerAdapter;)V");
      AppMethodBeat.o(184624);
      return;
    }
    if ((paramBoolean) && (this.scV != null))
    {
      Log.i("MicroMsg.FloatBallView", "hide with animation");
      this.scV.b(paramAnimatorListenerAdapter);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ball/view/FloatBallView", "com/tencent/mm/plugin/ball/view/FloatBallView", "hide", "(ZLandroid/animation/AnimatorListenerAdapter;)V");
      AppMethodBeat.o(184624);
      return;
      Log.i("MicroMsg.FloatBallView", "hide without animation");
      setVisibility(8);
      cwS();
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
    if ((paramBoolean1) && (this.scV != null))
    {
      Log.i("MicroMsg.FloatBallView", "show with animation");
      this.scV.a(paramAnimatorListenerAdapter);
      AppMethodBeat.o(184623);
      return;
    }
    Log.i("MicroMsg.FloatBallView", "show without animation");
    setVisibility(0);
    AppMethodBeat.o(184623);
  }
  
  public final void cwP()
  {
    AppMethodBeat.i(184622);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.eL(false);
    localb.bn(null);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/ball/view/FloatBallView", "com/tencent/mm/plugin/ball/view/FloatBallView", "show", "(ZLandroid/animation/AnimatorListenerAdapter;)V", this, localb.aFi());
    c(false, false, null);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ball/view/FloatBallView", "com/tencent/mm/plugin/ball/view/FloatBallView", "show", "(ZLandroid/animation/AnimatorListenerAdapter;)V");
    AppMethodBeat.o(184622);
  }
  
  public final void d(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(106456);
    e(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
    AppMethodBeat.o(106456);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(176988);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(176988);
    return bool;
  }
  
  public final void f(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(106457);
    this.sdC = Fu(paramInt1);
    a(paramBoolean1, this.sdC, paramBoolean2, this.sca);
    e(paramBoolean1, this.sdC, paramBoolean2);
    Y(paramInt2, paramBoolean1);
    Log.i("MicroMsg.FloatBallView", "notifyBallPositionChanged, x:%s, y:%s, isSettled:%s, isManual:%s, isDockLeft:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(this.sdC) });
    Iterator localIterator = this.listeners.iterator();
    while (localIterator.hasNext()) {
      ((g)localIterator.next()).a(paramInt1, paramInt2, getCurrentStateHeight(), paramBoolean1, this.sdC);
    }
    AppMethodBeat.o(106457);
  }
  
  public final int g(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int i = 0;
    int j;
    if ((paramBoolean1) || (paramBoolean2))
    {
      if ((this.rYm == null) || (this.rYm.x <= 0) || (this.rYm.y <= 0)) {
        break label90;
      }
      j = this.rYm.x;
      if (!paramBoolean3) {
        break label142;
      }
      if (!paramBoolean1) {
        break label76;
      }
      i = scB + scR * 2;
    }
    while (j < i)
    {
      return i;
      label76:
      i = scF + scR * 2;
      continue;
      label90:
      if (paramBoolean1)
      {
        if (paramBoolean3) {
          return scB + scR * 2;
        }
        return scz + scR * 2;
      }
      if (paramBoolean3) {
        return scF + scR * 2;
      }
      return scD + scR * 2;
    }
    label142:
    return j;
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
    if (this.sdC)
    {
      if ((FJ(this.sca)) || (FI(this.sca)))
      {
        localObject = new Point(((WindowManager.LayoutParams)localObject).x, ((WindowManager.LayoutParams)localObject).y + e.saM + scA);
        AppMethodBeat.o(106470);
        return localObject;
      }
      if (FM(this.sca))
      {
        localObject = new Point(((WindowManager.LayoutParams)localObject).x, ((WindowManager.LayoutParams)localObject).y + e.saM + scE);
        AppMethodBeat.o(106470);
        return localObject;
      }
      localObject = new Point(((WindowManager.LayoutParams)localObject).x, ((WindowManager.LayoutParams)localObject).y + e.saM);
      AppMethodBeat.o(106470);
      return localObject;
    }
    if ((FJ(this.sca)) || (FI(this.sca)))
    {
      localObject = new Point(((WindowManager.LayoutParams)localObject).x + e.saO, ((WindowManager.LayoutParams)localObject).y + e.saM + scA);
      AppMethodBeat.o(106470);
      return localObject;
    }
    if (FM(this.sca))
    {
      localObject = new Point(((WindowManager.LayoutParams)localObject).x + e.saO, ((WindowManager.LayoutParams)localObject).y + e.saM + scE);
      AppMethodBeat.o(106470);
      return localObject;
    }
    localObject = new Point(((WindowManager.LayoutParams)localObject).x + e.saO, ((WindowManager.LayoutParams)localObject).y + e.saM);
    AppMethodBeat.o(106470);
    return localObject;
  }
  
  public Point getBallSize()
  {
    AppMethodBeat.i(187018);
    Log.v("MicroMsg.FloatBallView", "alvinluo getBallSize stateWidth: %d, stateHeight: %d", new Object[] { Integer.valueOf(getCurrentStateWidth()), Integer.valueOf(getCurrentStateHeight()) });
    Point localPoint = new Point(getCurrentStateWidth() - e.saO, getCurrentStateHeight() - e.saM - e.saN);
    AppMethodBeat.o(187018);
    return localPoint;
  }
  
  public int getCurrentStateWidth()
  {
    AppMethodBeat.i(106467);
    int i = this.sca;
    Log.v("MicroMsg.FloatBallView", "getStateWidth state: %d", new Object[] { Integer.valueOf(i) });
    if (FH(i)) {}
    for (i = FB(i) + this.sdO * 2;; i = Fx(i))
    {
      int j = e.saO;
      AppMethodBeat.o(106467);
      return i + j;
    }
  }
  
  public Point getFloatBallPosition()
  {
    AppMethodBeat.i(187015);
    Object localObject = (WindowManager.LayoutParams)getLayoutParams();
    if (localObject == null)
    {
      AppMethodBeat.o(187015);
      return null;
    }
    if (this.sdC)
    {
      localObject = new Point(((WindowManager.LayoutParams)localObject).x, ((WindowManager.LayoutParams)localObject).y + e.saM);
      AppMethodBeat.o(187015);
      return localObject;
    }
    localObject = new Point(((WindowManager.LayoutParams)localObject).x + e.saO, ((WindowManager.LayoutParams)localObject).y + e.saM);
    AppMethodBeat.o(187015);
    return localObject;
  }
  
  public float getPosYPercentOfScreen()
  {
    return this.sdG;
  }
  
  public int getPositionY()
  {
    return this.sdH;
  }
  
  public final void la(boolean paramBoolean)
  {
    AppMethodBeat.i(176992);
    Log.i("MicroMsg.FloatBallView", "markWechatInForeground, visibility:%s, inForeground:%s", new Object[] { Integer.valueOf(getVisibility()), Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
      this.sca |= 0x20;
    }
    for (;;)
    {
      e(this.sdS, this.sdT, this.sdR);
      AppMethodBeat.o(176992);
      return;
      this.sca &= 0xFFFFFFDF;
      if ((FH(this.sca)) || (FG(this.sca)))
      {
        cwP();
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
    Log.i("MicroMsg.FloatBallView", "onConfigurationChanged, orientation:%d, lastOrientation: %d", new Object[] { Integer.valueOf(paramConfiguration.orientation), Integer.valueOf(this.lastOrientation) });
    Fs(paramConfiguration.orientation);
    int i = paramConfiguration.orientation;
    paramConfiguration = this.listeners.iterator();
    while (paramConfiguration.hasNext()) {
      ((g)paramConfiguration.next()).onOrientationChange(i);
    }
    AppMethodBeat.o(106441);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(106440);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ball/view/FloatBallView", "com/tencent/mm/plugin/ball/view/FloatBallView", "onDetachedFromWindow", "()V", this);
    super.onDetachedFromWindow();
    if (this.scU != null)
    {
      this.scU.cancel();
      this.scU = null;
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ball/view/FloatBallView", "com/tencent/mm/plugin/ball/view/FloatBallView", "onDetachedFromWindow", "()V");
    AppMethodBeat.o(106440);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(186980);
    int i = (int)paramMotionEvent.getRawX();
    int j = (int)paramMotionEvent.getRawY();
    if (paramMotionEvent.getAction() == 0) {
      U(paramMotionEvent);
    }
    if (com.tencent.mm.plugin.ball.f.d.q(this.bFK, i, j))
    {
      if (paramMotionEvent.getAction() != 2)
      {
        AppMethodBeat.o(186980);
        return false;
      }
      boolean bool = F(paramMotionEvent);
      AppMethodBeat.o(186980);
      return bool;
    }
    AppMethodBeat.o(186980);
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(106452);
    if (!this.sdB)
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
      this.jMX = false;
      U(paramMotionEvent);
      a(true, this.sdC, true, this.sca);
      if (this.sdI) {
        e(true, this.sdC, true);
      }
      this.rXo = false;
      if ((FR(this.sca)) && (!Gb(this.sca)) && (!Gc(this.sca)) && (!Gd(this.sca)))
      {
        this.sdV.postDelayed(this.sdW, this.scT);
        continue;
        if (this.rXo)
        {
          V(paramMotionEvent);
        }
        else
        {
          if ((!this.jMX) && (F(paramMotionEvent)))
          {
            this.sdV.removeCallbacks(this.sdW);
            this.jMX = true;
            i = this.sdF.x;
            i = this.sdF.y;
            localIterator = this.listeners.iterator();
            while (localIterator.hasNext()) {
              ((g)localIterator.next()).cvm();
            }
          }
          if (this.jMX)
          {
            d(G(paramMotionEvent), H(paramMotionEvent), false, true);
            continue;
            if (this.rXo)
            {
              a(true, this.sdC, false, this.sca);
              if (this.sdI) {
                e(true, this.sdC, false);
              }
              V(paramMotionEvent);
            }
            else
            {
              this.sdV.removeCallbacks(this.sdW);
              if ((this.jMX) || (F(paramMotionEvent))) {
                break;
              }
              a(true, this.sdC, false, this.sca);
              if (this.sdI) {
                e(true, this.sdC, false);
              }
              d(this.sdF.x, this.sdF.y, true, false);
              if (this.sdK)
              {
                float f1 = this.sdE.x;
                float f2 = this.sdE.y;
                long l = System.currentTimeMillis();
                if (l > this.lastClickTime + 800L)
                {
                  this.lastClickTime = l;
                  if (com.tencent.mm.plugin.ball.f.d.q(this.bFK, (int)f1, (int)f2))
                  {
                    Log.w("MicroMsg.FloatBallView", "notifyBallClickedIfNeed, click voip unexpectedly");
                  }
                  else if ((Gc(this.sca)) || (Gb(this.sca)) || (Gd(this.sca)))
                  {
                    Log.i("MicroMsg.FloatBallView", "notifyBallClickedIfNeed, ignore click");
                  }
                  else if (FR(this.sca))
                  {
                    Log.i("MicroMsg.FloatBallView", "notifyBallClickedIfNeed, wechat in foreground");
                    paramMotionEvent = this.listeners.iterator();
                    while (paramMotionEvent.hasNext()) {
                      ((g)paramMotionEvent.next()).cvk();
                    }
                  }
                  else if ((this.sdM != null) && (h.ae(com.tencent.mm.plugin.ball.c.b.class) != null))
                  {
                    Log.i("MicroMsg.FloatBallView", "notifyBallClickedIfNeed, you clicked appbrand voip");
                    this.sdM.rYs.opType = 3;
                    ((com.tencent.mm.plugin.ball.c.b)h.ae(com.tencent.mm.plugin.ball.c.b.class)).m(this.sdM);
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
    a(false, this.sdC, false, this.sca);
    if (this.jMX)
    {
      this.jMX = false;
      localIterator = this.listeners.iterator();
      while (localIterator.hasNext()) {
        ((g)localIterator.next()).cvn();
      }
    }
    int i = G(paramMotionEvent);
    int j = H(paramMotionEvent);
    int k = Fw(i);
    int m = Fv(j);
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
    cwR();
    AppMethodBeat.o(106473);
  }
  
  public void setCustomView(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(187029);
    Object localObject = paramBallInfo.bFK;
    if (localObject == this.bFK)
    {
      Log.w("MicroMsg.FloatBallView", "setCustomView voipView not changed");
      AppMethodBeat.o(187029);
      return;
    }
    if ((((View)localObject).getParent() != null) && ((((View)localObject).getParent() instanceof ViewGroup)))
    {
      Log.i("MicroMsg.FloatBallView", "setCustomView remove from parent first");
      ((ViewGroup)((View)localObject).getParent()).removeView((View)localObject);
    }
    this.scY.removeAllViews();
    this.bFK = ((View)localObject);
    localObject = new FrameLayout.LayoutParams(-1, -1);
    ((FrameLayout.LayoutParams)localObject).gravity = 17;
    this.scY.addView(this.bFK, (ViewGroup.LayoutParams)localObject);
    this.rYm = paramBallInfo.rYm;
    this.sdP = true;
    cwT();
    if (this.sdL.rYt != null)
    {
      paramBallInfo = this.sdL.rYt.rYv;
      localObject = this.sdL.rYt.rYw;
      if ((h(paramBallInfo)) && (h((Point)localObject)))
      {
        this.sdQ = 80;
        if ((paramBallInfo.x < ((Point)localObject).x) && (paramBallInfo.y < ((Point)localObject).y))
        {
          this.sdN.x = (((Point)localObject).x - paramBallInfo.x);
          this.sdN.y = (((Point)localObject).y - paramBallInfo.y);
          this.sdP = false;
        }
      }
      Log.v("MicroMsg.FloatBallView", "alvinluo updateVoipViewParams startSize: %s, endSize: %s, extraSize: %s, voipViewSize: %s", new Object[] { paramBallInfo, localObject, this.sdN, this.rYm });
    }
    AppMethodBeat.o(187029);
  }
  
  public void setEnableClick(boolean paramBoolean)
  {
    AppMethodBeat.i(186993);
    Log.d("MicroMsg.FloatBallView", "alvinluo setEnableClick enable: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.sdK = paramBoolean;
    AppMethodBeat.o(186993);
  }
  
  public void setFloatBallAlpha(final float paramFloat)
  {
    AppMethodBeat.i(106460);
    com.tencent.mm.plugin.ball.b.b localb = this.scV;
    if ((localb.cuT()) || (localb.cuU())) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.printInfoStack("MicroMsg.FloatBallView", "setFloatBallAlpha later, alpha:%s", new Object[] { Float.valueOf(paramFloat) });
      localb = this.scV;
      Runnable local3 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(186783);
          Log.i("MicroMsg.FloatBallView", "setFloatBallAlpha when animation ends, alpha:%s", new Object[] { Float.valueOf(paramFloat) });
          FloatBallView.a(FloatBallView.this, paramFloat);
          AppMethodBeat.o(186783);
        }
      };
      localb.rYi.add(local3);
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
    if (paramView == this.scW)
    {
      AppMethodBeat.o(106471);
      return;
    }
    this.sda.removeAllViews();
    this.scW = paramView;
    if (this.scW != null)
    {
      paramView = new FrameLayout.LayoutParams(-1, -1);
      paramView.gravity = 17;
      this.sda.addView(this.scW, paramView);
    }
    AppMethodBeat.o(106471);
  }
  
  public void setNeedTranslateAnimation(boolean paramBoolean)
  {
    this.sak = paramBoolean;
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(106472);
    if ((h.ae(com.tencent.mm.plugin.ball.c.b.class) != null) && (((com.tencent.mm.plugin.ball.c.b)h.ae(com.tencent.mm.plugin.ball.c.b.class)).cvh()))
    {
      super.setVisibility(8);
      AppMethodBeat.o(106472);
      return;
    }
    super.setVisibility(paramInt);
    int i = (int)getAlpha();
    if (i == 0)
    {
      this.sdB = false;
      Log.printInfoStack("MicroMsg.FloatBallView", "setVisibility:%s, alphaInt:%s, disableTouch", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      AppMethodBeat.o(106472);
      return;
    }
    if (i == 1)
    {
      this.sdB = true;
      Log.printInfoStack("MicroMsg.FloatBallView", "setVisibility:%s, alphaInt:%s, enableTouch", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      cwR();
    }
    AppMethodBeat.o(106472);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.view.FloatBallView
 * JD-Core Version:    0.7.0.1
 */