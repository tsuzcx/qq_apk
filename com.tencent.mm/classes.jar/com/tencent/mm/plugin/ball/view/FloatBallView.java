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
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArraySet;

public class FloatBallView
  extends FrameLayout
  implements com.tencent.mm.plugin.ball.c.d
{
  private static final int vnA;
  private static final int vnB;
  private static final int vnC;
  private static final int vnD;
  private static final int vnE;
  private static final int vnF;
  private static final int vnG;
  private static final int vnH;
  private static final int vnI;
  private static final int vnJ;
  private static final int vnK;
  private static final int vnL;
  private static final int vnM;
  private static final int vnN;
  private static final int vnO;
  private static final int vnP;
  private static final int vnQ;
  private static final int vnR;
  private static final int vnS;
  private static final int vnT;
  private static final int vnU;
  public static final int vnV;
  private static final int vnW;
  private static final int vnX;
  private static final int vnY;
  public static final int vnZ;
  private static final int vnx;
  private static final int vny;
  private static final int vnz;
  public static final int voa;
  private static final int vob;
  private static final int voc;
  private static final int vod;
  private static final int voe;
  private static final int vof;
  private static final int vog;
  private static final int voh;
  private static final int voi;
  private static final int voj;
  private static final int vok;
  public static final int vol;
  private static final int vom;
  public View dyK;
  private Handler eLs;
  private long lastClickTime;
  private int lastOrientation;
  public Set<g> listeners;
  private boolean mlX;
  private int pvk;
  private View rpv;
  private Vibrator uAL;
  private boolean viF;
  private Point vjC;
  public boolean vlB;
  public int vnu;
  private int vnv;
  private int vnw;
  private CircleAnimateView voA;
  private CircleAnimateView voB;
  private CircleAnimateView voC;
  private WeImageView voD;
  private int voE;
  private Drawable voF;
  private Drawable voG;
  private Drawable voH;
  private Drawable voI;
  private Drawable voJ;
  private Drawable voK;
  private Drawable voL;
  private Drawable voM;
  private Drawable voN;
  private Drawable voO;
  private Drawable voP;
  private Drawable voQ;
  private Drawable voR;
  private Drawable voS;
  private Drawable voT;
  private Drawable voU;
  private Drawable voV;
  private Drawable voW;
  private String voX;
  private List<BallInfo> voY;
  private LayoutTransition voZ;
  private int von;
  private int voo;
  private ValueAnimator vop;
  public com.tencent.mm.plugin.ball.b.b voq;
  private View vor;
  public FrameLayout vos;
  private LinearLayout vot;
  private LinearLayout vou;
  public FrameLayout vov;
  private FrameLayout vow;
  private FrameLayout vox;
  private FrameLayout voy;
  private CircleAnimateView voz;
  private int vpA;
  private Handler vpB;
  private Runnable vpC;
  private boolean vpD;
  private boolean vpE;
  private boolean vpF;
  private int vpG;
  private boolean vpa;
  private int vpb;
  private int vpc;
  private boolean vpd;
  public boolean vpe;
  private Point vpf;
  private PointF vpg;
  private Point vph;
  private float vpi;
  private int vpj;
  private boolean vpk;
  private boolean vpl;
  private boolean vpm;
  private int vpn;
  private BallInfo vpo;
  private BallInfo vpp;
  private Point vpq;
  private int vpr;
  private boolean vps;
  public int vpt;
  private int vpu;
  private int vpv;
  private boolean vpw;
  private boolean vpx;
  private boolean vpy;
  private boolean vpz;
  private WindowManager windowManager;
  
  static
  {
    AppMethodBeat.i(106478);
    vnx = com.tencent.mm.cd.a.bs(MMApplicationContext.getContext(), a.c.float_ball_active_width);
    vny = com.tencent.mm.cd.a.bs(MMApplicationContext.getContext(), a.c.float_ball_active_height);
    vnz = com.tencent.mm.cd.a.bs(MMApplicationContext.getContext(), a.c.float_ball_active_passive_width);
    vnA = com.tencent.mm.cd.a.bs(MMApplicationContext.getContext(), a.c.float_ball_active_passive_height);
    vnB = com.tencent.mm.cd.a.bs(MMApplicationContext.getContext(), a.c.float_ball_one_passive_width);
    vnC = com.tencent.mm.cd.a.bs(MMApplicationContext.getContext(), a.c.float_ball_one_passive_height);
    vnD = com.tencent.mm.cd.a.bs(MMApplicationContext.getContext(), a.c.float_ball_two_passive_width);
    vnE = com.tencent.mm.cd.a.bs(MMApplicationContext.getContext(), a.c.float_ball_two_passive_height);
    vnF = com.tencent.mm.cd.a.bs(MMApplicationContext.getContext(), a.c.float_ball_three_passive_width);
    vnG = com.tencent.mm.cd.a.bs(MMApplicationContext.getContext(), a.c.float_ball_three_passive_height);
    vnH = com.tencent.mm.cd.a.bs(MMApplicationContext.getContext(), a.c.float_ball_voip_video_width);
    vnI = com.tencent.mm.cd.a.bs(MMApplicationContext.getContext(), a.c.float_ball_voip_video_height);
    vnJ = com.tencent.mm.cd.a.bs(MMApplicationContext.getContext(), a.c.float_ball_voip_video_with_others_width);
    vnK = com.tencent.mm.cd.a.bs(MMApplicationContext.getContext(), a.c.float_ball_voip_video_with_others_height);
    vnL = com.tencent.mm.cd.a.bs(MMApplicationContext.getContext(), a.c.float_ball_voip_video_with_others_width_large);
    vnM = com.tencent.mm.cd.a.bs(MMApplicationContext.getContext(), a.c.float_ball_voip_video_with_others_height_large);
    vnN = com.tencent.mm.cd.a.bs(MMApplicationContext.getContext(), a.c.float_ball_voip_audio_width);
    vnO = com.tencent.mm.cd.a.bs(MMApplicationContext.getContext(), a.c.float_ball_voip_audio_height);
    vnP = com.tencent.mm.cd.a.bs(MMApplicationContext.getContext(), a.c.float_ball_voip_audio_with_others_width);
    vnQ = com.tencent.mm.cd.a.bs(MMApplicationContext.getContext(), a.c.float_ball_voip_audio_with_others_height);
    vnR = com.tencent.mm.cd.a.bs(MMApplicationContext.getContext(), a.c.float_ball_voip_audio_with_others_width_large);
    vnS = com.tencent.mm.cd.a.bs(MMApplicationContext.getContext(), a.c.float_ball_voip_audio_with_others_height_large);
    vnT = com.tencent.mm.cd.a.bs(MMApplicationContext.getContext(), a.c.float_ball_voip_view_video_width);
    vnU = com.tencent.mm.cd.a.bs(MMApplicationContext.getContext(), a.c.float_ball_voip_view_video_height);
    vnV = com.tencent.mm.cd.a.bs(MMApplicationContext.getContext(), a.c.float_ball_voip_view_video_width_large);
    vnW = com.tencent.mm.cd.a.bs(MMApplicationContext.getContext(), a.c.float_ball_voip_view_video_height_large);
    vnX = com.tencent.mm.cd.a.bs(MMApplicationContext.getContext(), a.c.float_ball_voip_view_audio_width);
    vnY = com.tencent.mm.cd.a.bs(MMApplicationContext.getContext(), a.c.float_ball_voip_view_audio_height);
    vnZ = com.tencent.mm.cd.a.bs(MMApplicationContext.getContext(), a.c.float_ball_voip_view_audio_width_large);
    voa = com.tencent.mm.cd.a.bs(MMApplicationContext.getContext(), a.c.float_ball_voip_view_audio_height_large);
    vob = com.tencent.mm.cd.a.bs(MMApplicationContext.getContext(), a.c.float_ball_state_icon_size);
    voc = com.tencent.mm.cd.a.bs(MMApplicationContext.getContext(), a.c.float_ball_content_view_size);
    vod = com.tencent.mm.cd.a.bs(MMApplicationContext.getContext(), a.c.float_ball_inner_margin_4);
    voe = com.tencent.mm.cd.a.bs(MMApplicationContext.getContext(), a.c.float_ball_inner_margin_8);
    vof = com.tencent.mm.cd.a.bs(MMApplicationContext.getContext(), a.c.float_ball_inner_margin_12);
    vog = com.tencent.mm.cd.a.bs(MMApplicationContext.getContext(), a.c.float_ball_inner_margin_16);
    voh = com.tencent.mm.cd.a.bs(MMApplicationContext.getContext(), a.c.float_ball_dragging_size_one_passive);
    voi = com.tencent.mm.cd.a.bs(MMApplicationContext.getContext(), a.c.float_ball_dragging_size_two_passive);
    voj = com.tencent.mm.cd.a.bs(MMApplicationContext.getContext(), a.c.float_ball_dragging_size_three_passive);
    vok = com.tencent.mm.cd.a.br(MMApplicationContext.getContext(), a.c.float_ball_divider_view_height);
    vol = voe;
    vom = com.tencent.mm.cd.a.bs(MMApplicationContext.getContext(), a.c.float_ball_collapse_layout_width);
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
    this.vnu = 0;
    this.vnv = 0;
    this.vnw = 0;
    this.listeners = new CopyOnWriteArraySet();
    this.vpa = false;
    this.vpb = 0;
    this.vpc = 0;
    this.vpg = new PointF();
    this.vph = new Point();
    this.vpi = -1.0F;
    this.vpj = 0;
    this.vpk = false;
    this.vlB = false;
    this.vpl = false;
    this.vpm = true;
    this.pvk = 0;
    this.vpn = 0;
    this.vjC = null;
    this.vpq = new Point();
    this.vpr = 0;
    this.vps = false;
    this.vpt = 80;
    this.vpu = -1;
    this.vpv = 0;
    this.vpw = false;
    this.eLs = new Handler(Looper.getMainLooper());
    this.vpx = false;
    this.vpy = false;
    this.vpz = false;
    this.vpA = 0;
    this.mlX = false;
    this.viF = false;
    this.vpB = new Handler(Looper.getMainLooper());
    this.vpC = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(288458);
        FloatBallView.a(FloatBallView.this);
        FloatBallView.b(FloatBallView.this);
        Iterator localIterator = FloatBallView.this.listeners.iterator();
        while (localIterator.hasNext()) {
          ((g)localIterator.next()).cXW();
        }
        AppMethodBeat.o(288458);
      }
    };
    this.vpD = false;
    this.vpE = false;
    this.vpF = false;
    this.vpG = 0;
    View.inflate(paramContext, a.f.layout_float_ball_view, this);
    this.voF = com.tencent.mm.cd.a.m(paramContext, a.d.float_window_56_background_left);
    this.voG = com.tencent.mm.cd.a.m(paramContext, a.d.float_window_56_background_right);
    this.voH = com.tencent.mm.cd.a.m(paramContext, a.d.float_window_56_background_round);
    this.voI = com.tencent.mm.cd.a.m(paramContext, a.d.float_window_56_background_left_press);
    this.voJ = com.tencent.mm.cd.a.m(paramContext, a.d.float_window_56_background_right_press);
    this.voK = com.tencent.mm.cd.a.m(paramContext, a.d.float_window_56_background_round_press);
    this.voL = com.tencent.mm.cd.a.m(paramContext, a.d.float_window_48_background_left);
    this.voM = com.tencent.mm.cd.a.m(paramContext, a.d.float_window_48_background_right);
    this.voN = com.tencent.mm.cd.a.m(paramContext, a.d.float_window_48_background_round);
    this.voO = com.tencent.mm.cd.a.m(paramContext, a.d.float_window_48_background_left_press);
    this.voP = com.tencent.mm.cd.a.m(paramContext, a.d.float_window_48_background_right_press);
    this.voQ = com.tencent.mm.cd.a.m(paramContext, a.d.float_window_48_background_round_press);
    this.voR = com.tencent.mm.cd.a.m(paramContext, a.d.float_window_voip_background_left);
    this.voS = com.tencent.mm.cd.a.m(paramContext, a.d.float_window_voip_background_right);
    this.voT = com.tencent.mm.cd.a.m(paramContext, a.d.float_window_voip_background_round);
    this.voU = com.tencent.mm.cd.a.m(paramContext, a.d.float_window_voip_background_left);
    this.voV = com.tencent.mm.cd.a.m(paramContext, a.d.float_window_voip_background_right);
    this.voW = com.tencent.mm.cd.a.m(paramContext, a.d.float_window_voip_background_round);
    this.vos = ((FrameLayout)findViewById(a.e.ballRootView));
    this.vot = ((LinearLayout)findViewById(a.e.ball_container));
    this.vox = ((FrameLayout)findViewById(a.e.ballContentView));
    this.vov = ((FrameLayout)findViewById(a.e.voipContentView));
    this.vow = ((FrameLayout)findViewById(a.e.otherContentView));
    this.rpv = findViewById(a.e.dividerView);
    this.voy = ((FrameLayout)findViewById(a.e.ballStateView));
    this.voz = ((CircleAnimateView)findViewById(a.e.topStateImageView));
    this.voA = ((CircleAnimateView)findViewById(a.e.bottomStateImageView));
    this.voB = ((CircleAnimateView)findViewById(a.e.thirdStateImageView));
    this.voC = ((CircleAnimateView)findViewById(a.e.fourthStateImageView));
    this.vou = ((LinearLayout)findViewById(a.e.ball_collapse_layout));
    this.voD = ((WeImageView)findViewById(a.e.ball_collapse_arrow));
    cZp();
    this.voq = new com.tencent.mm.plugin.ball.b.b(this);
    this.uAL = ((Vibrator)paramContext.getSystemService("vibrator"));
    this.windowManager = ((WindowManager)paramContext.getSystemService("window"));
    this.von = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.vpf = aw.bf(paramContext);
    if ((aw.jlc()) && (aw.mO(paramContext))) {
      this.vpf.x = aw.getDeviceWidth();
    }
    if (aw.jkS()) {
      this.vpf.x = aw.getDeviceHeight();
    }
    this.voo = ViewConfiguration.getLongPressTimeout();
    this.voZ = new LayoutTransition();
    this.vos.setLayoutTransition(this.voZ);
    this.lastOrientation = getResources().getConfiguration().orientation;
    this.pvk = aw.bk(getContext());
    this.vpn = aw.getStatusBarHeight(getContext());
    Log.v("MicroMsg.FloatBallView", "initFloatBallView navigationBar: %s, statusBar: %s", new Object[] { Integer.valueOf(this.pvk), Integer.valueOf(this.vpn) });
    AppMethodBeat.o(106438);
  }
  
  private boolean F(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(106453);
    if ((Math.abs(paramMotionEvent.getRawX() - this.vpg.x) > this.von) || (Math.abs(paramMotionEvent.getRawY() - this.vpg.y) > this.von))
    {
      AppMethodBeat.o(106453);
      return true;
    }
    AppMethodBeat.o(106453);
    return false;
  }
  
  private void FQ(int paramInt)
  {
    this.vpu = this.vpv;
    this.vpv = paramInt;
  }
  
  private void FR(int paramInt)
  {
    AppMethodBeat.i(288508);
    Point localPoint1 = this.vpf;
    this.vpf = aw.bf(getContext());
    if ((aw.jlc()) && (aw.mO(getContext()))) {
      this.vpf.x = aw.getDeviceWidth();
    }
    if (aw.jkS()) {
      this.vpf.x = aw.getDeviceHeight();
    }
    Point localPoint2 = this.vpf;
    Object localObject;
    int i;
    boolean bool1;
    label206:
    int j;
    int k;
    if (localPoint1 != null)
    {
      localObject = localPoint1;
      Log.i("MicroMsg.FloatBallView", "processOrientationChanged, screenResolution: %s, lastResolution: %s", new Object[] { localPoint2, localObject });
      if ((this.lastOrientation != paramInt) || ((localPoint1 != null) && ((localPoint1.x != this.vpf.x) || (localPoint1.y != this.vpf.y))))
      {
        this.lastOrientation = paramInt;
        this.vpk = true;
        localObject = (WindowManager.LayoutParams)getLayoutParams();
        paramInt = ((WindowManager.LayoutParams)localObject).x;
        i = (int)(this.vpf.y * this.vpi);
        if ((!this.vpw) || (!com.tencent.mm.plugin.ball.model.a.FG(this.vpv))) {
          break label361;
        }
        bool1 = true;
        paramInt = Math.max(Math.min(paramInt, this.vpf.x), 0);
        i = Math.max(Math.min(i, this.vpf.y), 0);
        j = FU(i);
        k = mB(bool1);
        if (k > 0) {
          break label367;
        }
      }
    }
    label361:
    label367:
    for (boolean bool2 = true;; bool2 = false)
    {
      Log.i("MicroMsg.FloatBallView", "processOrientationChanged, layoutParams.x: %s, layoutParams.y: %s, stickToLeft:%s, startSticky:[%s, %s]=>[%s, %s]", new Object[] { Integer.valueOf(((WindowManager.LayoutParams)localObject).x), Integer.valueOf(((WindowManager.LayoutParams)localObject).y), Boolean.valueOf(bool2), Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(j) });
      b(bool2, bool1, paramInt, i, k, j);
      AppMethodBeat.o(288508);
      return;
      localObject = "null";
      break;
      bool1 = false;
      break label206;
    }
  }
  
  private boolean FS(int paramInt)
  {
    AppMethodBeat.i(176987);
    if (getCurrentStateWidth() + paramInt != this.vpf.x)
    {
      AppMethodBeat.o(176987);
      return true;
    }
    AppMethodBeat.o(176987);
    return false;
  }
  
  private static int FU(int paramInt)
  {
    int i;
    if (paramInt < e.vml) {
      i = e.vml;
    }
    do
    {
      return i;
      i = paramInt;
    } while (paramInt <= e.vmm);
    return e.vmm;
  }
  
  private int FV(int paramInt)
  {
    AppMethodBeat.i(288644);
    int i = paramInt;
    if (this.lastOrientation == 2)
    {
      int j = this.windowManager.getDefaultDisplay().getRotation();
      Log.v("MicroMsg.FloatBallView", "fixPositionXWhenLandscape rotation: %s, cutoutHeight: %d, isCurrentDockLeft: %s", new Object[] { Integer.valueOf(j), Integer.valueOf(com.tencent.mm.plugin.ball.f.d.bw(getContext())), Boolean.valueOf(this.vpe) });
      i = paramInt;
      if (!this.vpe)
      {
        i = paramInt;
        if (j == 3) {
          i = paramInt - this.pvk;
        }
      }
    }
    AppMethodBeat.o(288644);
    return i;
  }
  
  private int FW(int paramInt)
  {
    AppMethodBeat.i(288647);
    int i = getWidth();
    if (Gr(paramInt)) {
      i = vnx;
    }
    for (;;)
    {
      AppMethodBeat.o(288647);
      return i;
      if ((Gs(paramInt)) || ((!Gq(paramInt)) && (Gf(paramInt)))) {
        i = voh;
      } else if (Gt(paramInt)) {
        i = voi;
      } else if ((Gu(paramInt)) || (Gv(paramInt))) {
        i = voj;
      } else if ((Gw(paramInt)) || (Gx(paramInt))) {
        i = vnz;
      } else if ((Gy(paramInt)) || (Gz(paramInt))) {
        i = vnz + vob;
      }
    }
  }
  
  private int FX(int paramInt)
  {
    AppMethodBeat.i(288649);
    int i = getHeight();
    if (Gr(paramInt)) {
      paramInt = vny;
    }
    for (;;)
    {
      AppMethodBeat.o(288649);
      return paramInt;
      if (Gs(paramInt))
      {
        paramInt = voh;
      }
      else if (Gt(paramInt))
      {
        paramInt = voi;
      }
      else if ((Gu(paramInt)) || (Gv(paramInt)))
      {
        paramInt = voi;
      }
      else if ((Gw(paramInt)) || (Gx(paramInt)) || (Gy(paramInt)) || (Gz(paramInt)))
      {
        paramInt = vnA;
      }
      else if (!Gy(this.vnu))
      {
        paramInt = i;
        if (!Gz(this.vnu)) {}
      }
      else
      {
        paramInt = vnA;
      }
    }
  }
  
  private void FY(int paramInt)
  {
    this.vnu &= (paramInt ^ 0xFFFFFFFF);
  }
  
  private void FZ(int paramInt)
  {
    this.vnu |= paramInt;
  }
  
  private int G(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(106454);
    int i = (int)Math.max(Math.min(this.vph.x + paramMotionEvent.getRawX() - this.vpg.x, this.vpf.x), -getLayoutParams().width);
    AppMethodBeat.o(106454);
    return i;
  }
  
  private static boolean GA(int paramInt)
  {
    AppMethodBeat.i(288716);
    if ((Gi(paramInt)) && (!Gd(paramInt)) && (!Ge(paramInt)))
    {
      AppMethodBeat.o(288716);
      return true;
    }
    AppMethodBeat.o(288716);
    return false;
  }
  
  private static boolean GB(int paramInt)
  {
    AppMethodBeat.i(288724);
    if ((Gl(paramInt)) && (!Gd(paramInt)) && (!Ge(paramInt)))
    {
      AppMethodBeat.o(288724);
      return true;
    }
    AppMethodBeat.o(288724);
    return false;
  }
  
  private static boolean GC(int paramInt)
  {
    AppMethodBeat.i(288726);
    if ((Gh(paramInt)) && (!Gd(paramInt)) && (!Ge(paramInt)))
    {
      AppMethodBeat.o(288726);
      return true;
    }
    AppMethodBeat.o(288726);
    return false;
  }
  
  private static boolean GD(int paramInt)
  {
    AppMethodBeat.i(288730);
    if ((Gd(paramInt)) && (Gg(paramInt)) && (!Ge(paramInt)))
    {
      AppMethodBeat.o(288730);
      return true;
    }
    AppMethodBeat.o(288730);
    return false;
  }
  
  private int Ga(int paramInt)
  {
    AppMethodBeat.i(288679);
    if ((Gi(paramInt)) || (Gh(paramInt))) {}
    for (boolean bool = true;; bool = false)
    {
      paramInt = g(bool, Gl(paramInt), Gc(paramInt));
      AppMethodBeat.o(288679);
      return paramInt;
    }
  }
  
  private int Gb(int paramInt)
  {
    AppMethodBeat.i(288680);
    if ((Gi(paramInt)) || (Gh(paramInt))) {}
    for (boolean bool = true;; bool = false)
    {
      paramInt = a(paramInt, bool, Gl(paramInt), Gc(paramInt));
      AppMethodBeat.o(288680);
      return paramInt;
    }
  }
  
  private static boolean Gd(int paramInt)
  {
    return (paramInt & 0x1) != 0;
  }
  
  private static boolean Ge(int paramInt)
  {
    AppMethodBeat.i(176994);
    if ((Gm(paramInt)) || (Gn(paramInt)) || (Go(paramInt)) || (Gp(paramInt)))
    {
      AppMethodBeat.o(176994);
      return true;
    }
    AppMethodBeat.o(176994);
    return false;
  }
  
  private static boolean Gf(int paramInt)
  {
    return ((paramInt & 0x100) != 0) || ((paramInt & 0x200) != 0);
  }
  
  private static boolean Gg(int paramInt)
  {
    AppMethodBeat.i(288681);
    if ((Gi(paramInt)) || (Gl(paramInt)) || (Gh(paramInt)))
    {
      AppMethodBeat.o(288681);
      return true;
    }
    AppMethodBeat.o(288681);
    return false;
  }
  
  private static boolean Gh(int paramInt)
  {
    return (paramInt & 0x1000) != 0;
  }
  
  public static boolean Gi(int paramInt)
  {
    return (paramInt & 0x8) != 0;
  }
  
  private static boolean Gj(int paramInt)
  {
    return (paramInt & 0x400) != 0;
  }
  
  private static boolean Gk(int paramInt)
  {
    return (paramInt & 0x800) != 0;
  }
  
  public static boolean Gl(int paramInt)
  {
    return (paramInt & 0x10) != 0;
  }
  
  private static boolean Gm(int paramInt)
  {
    return (paramInt & 0x2) != 0;
  }
  
  private static boolean Gn(int paramInt)
  {
    return (paramInt & 0x4) != 0;
  }
  
  private static boolean Go(int paramInt)
  {
    return (paramInt & 0x40) != 0;
  }
  
  private static boolean Gp(int paramInt)
  {
    return (paramInt & 0x80) != 0;
  }
  
  private static boolean Gq(int paramInt)
  {
    return (paramInt & 0x20) != 0;
  }
  
  private static boolean Gr(int paramInt)
  {
    AppMethodBeat.i(176996);
    if ((Gd(paramInt)) && (!Gg(paramInt)) && (!Ge(paramInt)))
    {
      AppMethodBeat.o(176996);
      return true;
    }
    AppMethodBeat.o(176996);
    return false;
  }
  
  private static boolean Gs(int paramInt)
  {
    AppMethodBeat.i(176997);
    if ((Gm(paramInt)) && (!Gg(paramInt)) && (!Gd(paramInt)))
    {
      AppMethodBeat.o(176997);
      return true;
    }
    AppMethodBeat.o(176997);
    return false;
  }
  
  private static boolean Gt(int paramInt)
  {
    AppMethodBeat.i(176998);
    if ((Gn(paramInt)) && (!Gg(paramInt)) && (!Gd(paramInt)))
    {
      AppMethodBeat.o(176998);
      return true;
    }
    AppMethodBeat.o(176998);
    return false;
  }
  
  private static boolean Gu(int paramInt)
  {
    AppMethodBeat.i(176999);
    if ((Go(paramInt)) && (!Gg(paramInt)) && (!Gd(paramInt)))
    {
      AppMethodBeat.o(176999);
      return true;
    }
    AppMethodBeat.o(176999);
    return false;
  }
  
  private static boolean Gv(int paramInt)
  {
    AppMethodBeat.i(288703);
    if ((Gp(paramInt)) && (!Gg(paramInt)) && (!Gd(paramInt)))
    {
      AppMethodBeat.o(288703);
      return true;
    }
    AppMethodBeat.o(288703);
    return false;
  }
  
  private static boolean Gw(int paramInt)
  {
    AppMethodBeat.i(177000);
    if ((Gm(paramInt)) && (Gd(paramInt)) && (!Gg(paramInt)))
    {
      AppMethodBeat.o(177000);
      return true;
    }
    AppMethodBeat.o(177000);
    return false;
  }
  
  private static boolean Gx(int paramInt)
  {
    AppMethodBeat.i(177001);
    if ((Gn(paramInt)) && (Gd(paramInt)) && (!Gg(paramInt)))
    {
      AppMethodBeat.o(177001);
      return true;
    }
    AppMethodBeat.o(177001);
    return false;
  }
  
  private static boolean Gy(int paramInt)
  {
    AppMethodBeat.i(177002);
    if ((Go(paramInt)) && (Gd(paramInt)) && (!Gg(paramInt)))
    {
      AppMethodBeat.o(177002);
      return true;
    }
    AppMethodBeat.o(177002);
    return false;
  }
  
  private static boolean Gz(int paramInt)
  {
    AppMethodBeat.i(288712);
    if ((Gp(paramInt)) && (Gd(paramInt)) && (!Gg(paramInt)))
    {
      AppMethodBeat.o(288712);
      return true;
    }
    AppMethodBeat.o(288712);
    return false;
  }
  
  private int H(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(106455);
    int i = (int)Math.max(Math.min(this.vph.y + paramMotionEvent.getRawY() - this.vpg.y, this.vpf.y), -getLayoutParams().height);
    AppMethodBeat.o(106455);
    return i;
  }
  
  private void L(boolean paramBoolean1, final boolean paramBoolean2)
  {
    AppMethodBeat.i(288519);
    int j = this.vos.getPaddingLeft();
    int k = this.vos.getPaddingRight();
    int m = this.vos.getPaddingTop();
    int n = this.vos.getPaddingBottom();
    label487:
    Object localObject;
    if (Gq(this.vnu))
    {
      if (paramBoolean2) {}
      for (int i = this.vpt | 0x800003;; i = this.vpt | 0x800005)
      {
        an(i, true);
        if (!paramBoolean1) {
          break label487;
        }
        if (!paramBoolean2) {
          break;
        }
        mx(true);
        this.vos.setPadding(j + getExtendWidth(), m, k, n);
        this.vos.setLayoutTransition(this.voZ);
        my(true);
        AppMethodBeat.o(288519);
        return;
      }
      this.vos.setPadding(j, m, k + getExtendWidth(), n);
      if (((Gs(this.vnv)) && (Gw(this.vnu))) || ((Gt(this.vnv)) && (Gx(this.vnu))) || ((Gu(this.vnv)) && (Gy(this.vnu))) || ((Gv(this.vnv)) && (Gz(this.vnu))))
      {
        this.vos.setLayoutTransition(null);
        mz(true);
        AppMethodBeat.o(288519);
        return;
      }
      if (((Gr(this.vnv)) && (Gw(this.vnu))) || ((Gr(this.vnv)) && (Gx(this.vnu))) || ((Gr(this.vnv)) && (Gy(this.vnu))) || ((Gr(this.vnv)) && (Gz(this.vnu))))
      {
        this.vos.setLayoutTransition(null);
        mz(true);
        AppMethodBeat.o(288519);
        return;
      }
      if (((Gw(this.vnv)) && (Gr(this.vnu))) || ((Gx(this.vnv)) && (Gr(this.vnu))) || ((Gy(this.vnv)) && (Gr(this.vnu))) || ((Gz(this.vnv)) && (Gr(this.vnu))))
      {
        this.vos.setLayoutTransition(null);
        mz(true);
        AppMethodBeat.o(288519);
        return;
      }
      mx(false);
      this.vos.setLayoutTransition(this.voZ);
      mz(true);
      AppMethodBeat.o(288519);
      return;
      if ((Gg(this.vnu)) && ((Gd(this.vnu)) || (Ge(this.vnu)))) {
        if (paramBoolean2) {
          my(false);
        }
      }
      while (this.vpw)
      {
        Log.v("MicroMsg.FloatBallView", "doUpdateFloatBallViewLayout last: %d, current: %d", new Object[] { Integer.valueOf(this.vpu), Integer.valueOf(this.vpv) });
        if (this.vpu == this.vpv) {
          break;
        }
        this.vos.setLayoutTransition(this.voZ);
        this.vou.setVisibility(8);
        post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(106430);
            FloatBallView.a(FloatBallView.this, paramBoolean2);
            AppMethodBeat.o(106430);
          }
        });
        AppMethodBeat.o(288519);
        return;
        mz(false);
        continue;
        if ((Gw(this.vnu)) || (Gx(this.vnu)) || (Gy(this.vnu)) || (Gz(this.vnu)))
        {
          if (paramBoolean2) {
            cZt();
          } else {
            cZu();
          }
        }
        else if ((Gs(this.vnu)) || (Gt(this.vnu)) || (Gu(this.vnu)) || (Gv(this.vnu)))
        {
          M(paramBoolean2, false);
        }
        else if (Gr(this.vnu))
        {
          localObject = (FrameLayout.LayoutParams)this.vox.getLayoutParams();
          ((FrameLayout.LayoutParams)localObject).gravity = 17;
          i = voe;
          j = voe;
          ((FrameLayout.LayoutParams)localObject).setMargins(i, i, j, j);
          this.vox.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
    }
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        this.vos.setPadding(j + getExtendWidth(), m, k, n);
        this.vos.setLayoutTransition(this.voZ);
        an(this.vpt | 0x800003, true);
        this.rpv.setVisibility(8);
        if (Gf(this.vnu))
        {
          this.vow.setVisibility(0);
          this.vox.setVisibility(8);
          this.voy.setVisibility(0);
          localObject = (LinearLayout.LayoutParams)this.vow.getLayoutParams();
          ((LinearLayout.LayoutParams)localObject).gravity = 8388627;
          this.vow.setLayoutParams((ViewGroup.LayoutParams)localObject);
          M(true, true);
          this.vov.setVisibility(0);
          if ((this.vpo == null) || (this.vpo.vjK)) {
            break label1062;
          }
          this.vov.setVisibility(0);
          paramBoolean1 = Gc(this.vnu);
          if ((!Gi(this.vnu)) && (!Gh(this.vnu))) {
            break label1030;
          }
          f(true, false, paramBoolean1);
        }
        for (;;)
        {
          if (this.vov.getVisibility() == 0) {
            mx(true);
          }
          AppMethodBeat.o(288519);
          return;
          this.vow.setVisibility(8);
          break;
          label1030:
          if (Gl(this.vnu)) {
            f(false, true, paramBoolean1);
          } else {
            this.vov.setVisibility(8);
          }
        }
        label1062:
        this.vov.setVisibility(8);
        AppMethodBeat.o(288519);
        return;
      }
      this.vos.setPadding(j, m, k + getExtendWidth(), n);
      this.vos.setLayoutTransition(this.voZ);
      an(this.vpt | 0x800005, true);
      this.rpv.setVisibility(8);
      if (Gf(this.vnu))
      {
        this.vow.setVisibility(0);
        this.vox.setVisibility(8);
        this.voy.setVisibility(0);
        localObject = (LinearLayout.LayoutParams)this.vow.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject).gravity = 8388629;
        this.vow.setLayoutParams((ViewGroup.LayoutParams)localObject);
        M(false, true);
        mA(false);
        this.vov.setVisibility(0);
        if ((this.vpo == null) || (this.vpo.vjK)) {
          break label1343;
        }
        this.vov.setVisibility(0);
        paramBoolean1 = Gc(this.vnu);
        if ((!Gi(this.vnu)) && (!Gh(this.vnu))) {
          break label1311;
        }
        f(true, false, paramBoolean1);
      }
      for (;;)
      {
        if (this.vov.getVisibility() == 0) {
          mx(false);
        }
        AppMethodBeat.o(288519);
        return;
        this.vow.setVisibility(8);
        break;
        label1311:
        if (Gl(this.vnu)) {
          f(false, true, paramBoolean1);
        } else {
          this.vov.setVisibility(8);
        }
      }
      label1343:
      this.vov.setVisibility(8);
      AppMethodBeat.o(288519);
      return;
    }
    an(this.vpt | 0x1, false);
    if (this.vpw)
    {
      Log.v("MicroMsg.FloatBallView", "doUpdateFloatBallViewLayout last: %d, current: %d", new Object[] { Integer.valueOf(this.vpu), Integer.valueOf(this.vpv) });
      if (this.vpu != this.vpv)
      {
        this.vos.setLayoutTransition(this.voZ);
        this.vou.setVisibility(8);
        post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(106431);
            FloatBallView.a(FloatBallView.this, paramBoolean2);
            AppMethodBeat.o(106431);
          }
        });
      }
    }
    AppMethodBeat.o(288519);
  }
  
  private int M(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(176983);
    this.voy.setVisibility(0);
    boolean bool1 = Gp(this.vnu);
    boolean bool2 = Go(this.vnu);
    boolean bool3 = Gn(this.vnu);
    boolean bool4 = Gm(this.vnu);
    boolean bool5 = Gd(this.vnu);
    boolean bool6 = Gg(this.vnu);
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
      if ((Gq(this.vnu)) || (!Gf(this.vnu))) {
        break label364;
      }
      k = 1;
      if ((!bool4) && (k == 0)) {
        break label370;
      }
      i2 = vof;
      if ((paramBoolean2) || (bool5) || (bool6)) {
        break label385;
      }
      if ((!bool4) && (!bool2) && (!bool1) && (k == 0)) {
        break label378;
      }
      i = vof;
      m = i;
      j = i;
      i = m;
      if ((!bool4) && (k == 0)) {
        break label473;
      }
      this.voz.setVisibility(0);
      this.voA.setVisibility(8);
      this.voB.setVisibility(8);
      this.voC.setVisibility(8);
      m = 0;
      k = m;
      if (!Gq(this.vnu))
      {
        k = m;
        if (Gf(this.vnu)) {
          k = getAppBrandVoipBallInfoIndex();
        }
      }
      a(this.voz, k);
      localLayoutParams1 = (FrameLayout.LayoutParams)this.voz.getLayoutParams();
      localLayoutParams1.setMargins(j, i2, i, i2);
      localLayoutParams1.gravity = i1;
      this.voz.setLayoutParams(localLayoutParams1);
    }
    label364:
    label370:
    label378:
    while ((!bool3) && (!bool2) && (!bool1))
    {
      localLayoutParams1 = (FrameLayout.LayoutParams)this.voy.getLayoutParams();
      localLayoutParams1.gravity = (i1 | 0x10);
      this.voy.setLayoutParams(localLayoutParams1);
      if ((!bool2) && (!bool1)) {
        break label959;
      }
      k = vob;
      AppMethodBeat.o(176983);
      return k * 2 + j + i;
      i1 = 8388613;
      break;
      k = 0;
      break label100;
      i2 = vod;
      break label115;
      i = vog;
      break label153;
      if (paramBoolean1)
      {
        if ((bool5) && (!bool6))
        {
          j = vod;
          if (!bool5) {
            break label424;
          }
        }
        for (i = vod;; i = vof)
        {
          break;
          j = voe;
          break label404;
        }
      }
      if (bool5)
      {
        j = vod;
        if ((!bool5) || (bool6)) {
          break label466;
        }
      }
      for (i = vod;; i = voe)
      {
        break;
        j = vof;
        break label441;
      }
    }
    label385:
    label404:
    label424:
    label441:
    label466:
    label473:
    this.voz.setVisibility(0);
    this.voA.setVisibility(0);
    a(this.voz, 0);
    a(this.voA, 1);
    int n;
    int i3;
    if (bool2)
    {
      this.voB.setVisibility(0);
      this.voC.setVisibility(8);
      a(this.voB, 2);
      if (paramBoolean1)
      {
        m = j + vob;
        n = 0;
        k = i;
        i3 = j;
        label575:
        localLayoutParams1 = (FrameLayout.LayoutParams)this.voB.getLayoutParams();
        localLayoutParams1.setMargins(i3, 0, n, 0);
        localLayoutParams1.gravity = (i1 | 0x10);
        this.voB.setLayoutParams(localLayoutParams1);
        n = m;
        m = k;
      }
    }
    for (;;)
    {
      localLayoutParams1 = (FrameLayout.LayoutParams)this.voz.getLayoutParams();
      localLayoutParams1.setMargins(n, i2, m, 0);
      localLayoutParams1.gravity = i1;
      this.voz.setLayoutParams(localLayoutParams1);
      FrameLayout.LayoutParams localLayoutParams2 = (FrameLayout.LayoutParams)this.voA.getLayoutParams();
      k = vob;
      localLayoutParams2.setMargins(n, localLayoutParams1.topMargin + k, m, i2);
      localLayoutParams2.gravity = i1;
      this.voA.setLayoutParams(localLayoutParams2);
      break;
      i3 = 0;
      k = vob;
      n = i;
      k += i;
      m = j;
      break label575;
      if (bool1)
      {
        this.voB.setVisibility(0);
        this.voC.setVisibility(0);
        a(this.voB, 2);
        a(this.voC, 3);
        if (paramBoolean1)
        {
          k = vob;
          n = 0;
          m = i;
          k += j;
        }
        for (i3 = j;; i3 = 0)
        {
          localLayoutParams1 = (FrameLayout.LayoutParams)this.voB.getLayoutParams();
          localLayoutParams1.setMargins(i3, i2, n, 0);
          localLayoutParams1.gravity = i1;
          this.voB.setLayoutParams(localLayoutParams1);
          localLayoutParams2 = (FrameLayout.LayoutParams)this.voC.getLayoutParams();
          int i4 = vob;
          localLayoutParams2.setMargins(i3, localLayoutParams1.topMargin + i4, n, 0);
          localLayoutParams2.gravity = i1;
          this.voC.setLayoutParams(localLayoutParams2);
          n = k;
          break;
          k = vob;
          n = i;
          m = k + i;
          k = j;
        }
      }
      this.voC.setVisibility(8);
      this.voB.setVisibility(8);
      m = i;
      n = j;
    }
    label959:
    int k = vob;
    AppMethodBeat.o(176983);
    return k + j + i;
  }
  
  private static boolean M(BallInfo paramBallInfo)
  {
    return (paramBallInfo != null) && (paramBallInfo.state == 2048);
  }
  
  private static boolean N(BallInfo paramBallInfo)
  {
    return (paramBallInfo != null) && ((paramBallInfo.state == 4) || (paramBallInfo.state == 512));
  }
  
  private static boolean O(BallInfo paramBallInfo)
  {
    return (paramBallInfo != null) && ((paramBallInfo.state == 8) || (paramBallInfo.state == 1024));
  }
  
  private void P(int paramInt, long paramLong)
  {
    AppMethodBeat.i(176984);
    if (paramInt == 0)
    {
      a(this.voz, paramLong);
      AppMethodBeat.o(176984);
      return;
    }
    if (paramInt == 1)
    {
      a(this.voA, paramLong);
      AppMethodBeat.o(176984);
      return;
    }
    if (paramInt == 2)
    {
      a(this.voB, paramLong);
      AppMethodBeat.o(176984);
      return;
    }
    if (paramInt == 3) {
      a(this.voC, paramLong);
    }
    AppMethodBeat.o(176984);
  }
  
  private void P(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(288667);
    if ((paramBallInfo.vjC != null) && (this.vjC != null) && (paramBallInfo.vjC.x == this.vjC.x) && (paramBallInfo.vjC.y == this.vjC.y))
    {
      AppMethodBeat.o(288667);
      return;
    }
    if (paramBallInfo.vjC == null) {}
    for (this.vjC = null;; this.vjC = new Point(paramBallInfo.vjC.x, paramBallInfo.vjC.y))
    {
      this.vps = true;
      this.vpa = true;
      cZE();
      if (this.vpo.vjJ != null)
      {
        paramBallInfo = this.vpo.vjJ.vjL;
        Point localPoint = this.vpo.vjJ.vjM;
        if ((i(paramBallInfo)) && (i(localPoint)))
        {
          this.vpt = 80;
          if ((paramBallInfo.x < localPoint.x) && (paramBallInfo.y < localPoint.y))
          {
            this.vpq.x = (localPoint.x - paramBallInfo.x);
            this.vpq.y = (localPoint.y - paramBallInfo.y);
            this.vps = false;
          }
        }
        Log.v("MicroMsg.FloatBallView", "alvinluo updateVoipViewParams startSize: %s, endSize: %s, extraSize: %s, voipViewSize: %s", new Object[] { paramBallInfo, localPoint, this.vpq, this.vjC });
      }
      mA(true);
      AppMethodBeat.o(288667);
      return;
    }
  }
  
  private void W(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(288603);
    this.vpg.x = paramMotionEvent.getRawX();
    this.vpg.y = paramMotionEvent.getRawY();
    paramMotionEvent = (WindowManager.LayoutParams)getLayoutParams();
    this.vph.x = paramMotionEvent.x;
    this.vph.y = paramMotionEvent.y;
    AppMethodBeat.o(288603);
  }
  
  private void X(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(106475);
    Iterator localIterator = this.listeners.iterator();
    while (localIterator.hasNext()) {
      ((g)localIterator.next()).V(paramMotionEvent);
    }
    AppMethodBeat.o(106475);
  }
  
  private void a(CircleAnimateView paramCircleAnimateView, int paramInt)
  {
    AppMethodBeat.i(176986);
    if ((com.tencent.mm.plugin.ball.f.d.checkListNotEmpty(this.voY)) && (this.voY.size() > paramInt))
    {
      BallInfo localBallInfo = (BallInfo)this.voY.get(paramInt);
      paramInt = com.tencent.mm.plugin.ball.f.d.K(localBallInfo);
      if (-1 != paramInt)
      {
        com.tencent.mm.svg.a.a locala = new com.tencent.mm.svg.a.a();
        if ((!ImgUtil.isGif(MMApplicationContext.getContext(), paramInt)) && (locala.k(getResources(), paramInt))) {
          break label114;
        }
        paramCircleAnimateView.setImageResource(paramInt);
      }
      while (localBallInfo.hQO >= 0L)
      {
        paramCircleAnimateView.setProgress(localBallInfo.hQO);
        AppMethodBeat.o(176986);
        return;
        label114:
        paramCircleAnimateView.setImageDrawable(getResources().getDrawable(paramInt));
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
    if ((this.vpE == paramBoolean1) && (this.vpF == paramBoolean2) && (this.vpD == paramBoolean3) && (this.vpG == paramInt))
    {
      AppMethodBeat.o(176989);
      return;
    }
    Log.i("MicroMsg.FloatBallView", "updateFloatBallBackground, isSettled:%s, isDockLeft:%s, isManual:%s, state:%s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3), Integer.valueOf(paramInt) });
    this.vpG = paramInt;
    this.vpD = paramBoolean3;
    this.vpE = paramBoolean1;
    this.vpF = paramBoolean2;
    boolean bool1 = Gg(paramInt);
    boolean bool2 = Gs(paramInt);
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        if (paramBoolean3)
        {
          if (bool1)
          {
            this.vos.setBackground(this.voU);
            AppMethodBeat.o(176989);
            return;
          }
          if (bool2)
          {
            this.vos.setBackground(this.voO);
            AppMethodBeat.o(176989);
            return;
          }
          this.vos.setBackground(this.voI);
          AppMethodBeat.o(176989);
          return;
        }
        if (bool1)
        {
          this.vos.setBackground(this.voR);
          AppMethodBeat.o(176989);
          return;
        }
        if (bool2)
        {
          this.vos.setBackground(this.voL);
          AppMethodBeat.o(176989);
          return;
        }
        this.vos.setBackground(this.voF);
        AppMethodBeat.o(176989);
        return;
      }
      if (paramBoolean3)
      {
        if (bool1)
        {
          this.vos.setBackground(this.voV);
          AppMethodBeat.o(176989);
          return;
        }
        if (bool2)
        {
          this.vos.setBackground(this.voP);
          AppMethodBeat.o(176989);
          return;
        }
        this.vos.setBackground(this.voJ);
        AppMethodBeat.o(176989);
        return;
      }
      if (bool1)
      {
        this.vos.setBackground(this.voS);
        AppMethodBeat.o(176989);
        return;
      }
      if (bool2)
      {
        this.vos.setBackground(this.voM);
        AppMethodBeat.o(176989);
        return;
      }
      this.vos.setBackground(this.voG);
      AppMethodBeat.o(176989);
      return;
    }
    if (paramBoolean3)
    {
      if (bool1)
      {
        this.vos.setBackground(this.voW);
        AppMethodBeat.o(176989);
        return;
      }
      if (bool2)
      {
        this.vos.setBackground(this.voQ);
        AppMethodBeat.o(176989);
        return;
      }
      this.vos.setBackground(this.voK);
      AppMethodBeat.o(176989);
      return;
    }
    if (bool1)
    {
      this.vos.setBackground(this.voT);
      AppMethodBeat.o(176989);
      return;
    }
    if (bool2)
    {
      this.vos.setBackground(this.voN);
      AppMethodBeat.o(176989);
      return;
    }
    this.vos.setBackground(this.voH);
    AppMethodBeat.o(176989);
  }
  
  private void ao(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.vpi = (paramInt / this.vpf.y);
    }
    this.vpj = paramInt;
  }
  
  private int ap(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(288637);
    int i;
    if (!this.vpw)
    {
      if (FT(paramInt)) {
        break label251;
      }
      i = this.vpf.x - e.vmg - getCurrentStateWidth();
    }
    for (;;)
    {
      i = FV(i);
      Log.v("MicroMsg.FloatBallView", "getTargetPositionX startX: %d, screen.x: %d, horizontalShadowSize: %d, width: %d, needCollapse: %s, lastOrientation: %s, isCurrentDockLeft: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.vpf.x), Integer.valueOf(e.vmg), Integer.valueOf(getLayoutParams().width), Boolean.valueOf(paramBoolean), Integer.valueOf(this.lastOrientation), Boolean.valueOf(this.vpe) });
      AppMethodBeat.o(288637);
      return i;
      if (paramBoolean)
      {
        i = Ga(this.vnu);
        if (FT(paramInt)) {
          i = vol + 0 - i - e.vmg;
        } else {
          i = i + this.vpf.x + e.vmg - vol - getLayoutParams().width;
        }
      }
      else if (FT(paramInt))
      {
        i = 0 - e.vmg - getCollapseLayoutWidth();
      }
      else
      {
        i = this.vpf.x + e.vmg + getCollapseLayoutWidth() - getLayoutParams().width;
        continue;
        label251:
        i = 0;
      }
    }
  }
  
  private void b(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    AppMethodBeat.i(288535);
    setCustomViewLayoutAlpha(com.tencent.mm.plugin.ball.f.d.a(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5));
    AppMethodBeat.o(288535);
  }
  
  private void b(final boolean paramBoolean1, final boolean paramBoolean2, final int paramInt1, final int paramInt2, final int paramInt3, final int paramInt4)
  {
    AppMethodBeat.i(288633);
    Log.i("MicroMsg.FloatBallView", "startStickyAnimation, stickToLeft:%s, needCollapse: %s, startPositionX: %s, targetPositionX: %s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt3) });
    if ((this.vop != null) && (this.vop.isRunning()))
    {
      Log.i("MicroMsg.FloatBallView", "cancelStickyAnimation");
      this.vop.cancel();
    }
    final FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.vot.getLayoutParams();
    final int i;
    final boolean bool;
    label137:
    final float f2;
    if (paramBoolean1)
    {
      i = localLayoutParams.getMarginEnd();
      f1 = getCustomViewAlphaAnimationStartX();
      if (((!paramBoolean1) || (paramInt1 >= f1)) && ((paramBoolean1) || (paramInt1 <= f1))) {
        break label309;
      }
      bool = true;
      Log.v("MicroMsg.FloatBallView", "startStickyAnimation marginAnimationStartValue: %d, needCustomViewLayoutAlphaAnimation: %s, customViewAlphaAnimationStartX: %s", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool), Float.valueOf(f1) });
      f2 = this.vov.getAlpha();
      if (!paramBoolean2) {
        break label315;
      }
    }
    label309:
    label315:
    for (final float f1 = 0.0F;; f1 = 1.0F)
    {
      this.vop = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.vop.setInterpolator(new AccelerateDecelerateInterpolator());
      this.vop.setDuration(200L);
      this.vop.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(288476);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          int i = paramInt1 + (int)((paramInt3 * 1.0F - paramInt1) * f);
          int j = paramInt2 + (int)((paramInt4 * 1.0F - paramInt2) * f);
          FloatBallView.this.d(i, j, false, false);
          int k;
          if (!paramBoolean2)
          {
            k = i + (int)((this.vpL * 1.0F - i) * f);
            if (paramBoolean1)
            {
              localLayoutParams.setMarginEnd(k);
              localLayoutParams.setMarginStart(i - k);
              FloatBallView.c(FloatBallView.this).setAlpha(1.0F - f);
              Log.v("MicroMsg.FloatBallView", "startStickyAnimation onAnimationUpdate factor: %s, targetMargin: %s, currentX: %s, currentY: %s", new Object[] { Float.valueOf(f), Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(j) });
            }
          }
          for (;;)
          {
            if (bool) {
              FloatBallView.a(FloatBallView.this, f2, f1, i, paramInt1, paramInt3);
            }
            AppMethodBeat.o(288476);
            return;
            localLayoutParams.setMarginStart(k);
            localLayoutParams.setMarginEnd(i - k);
            break;
            if (f > 0.5F) {
              if ((paramBoolean1) && (FloatBallView.d(FloatBallView.this) != 0))
              {
                FloatBallView.a(FloatBallView.this, 0);
                FloatBallView.e(FloatBallView.this).setRotation(FloatBallView.d(FloatBallView.this));
              }
              else if ((!paramBoolean1) && (FloatBallView.d(FloatBallView.this) != 180))
              {
                FloatBallView.a(FloatBallView.this, 180);
                FloatBallView.e(FloatBallView.this).setRotation(FloatBallView.d(FloatBallView.this));
              }
            }
          }
        }
      });
      this.vop.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(288479);
          super.onAnimationEnd(paramAnonymousAnimator);
          FloatBallView.c(FloatBallView.this, paramBoolean2);
          paramAnonymousAnimator = (LinearLayout.LayoutParams)FloatBallView.f(FloatBallView.this).getLayoutParams();
          if (FloatBallView.g(FloatBallView.this))
          {
            localLayoutParams.gravity = 8388611;
            paramAnonymousAnimator.setMarginStart(0);
            paramAnonymousAnimator.setMarginEnd(FloatBallView.aDd());
          }
          for (;;)
          {
            FloatBallView.h(FloatBallView.this).setLayoutParams(localLayoutParams);
            FloatBallView.f(FloatBallView.this).setLayoutParams(paramAnonymousAnimator);
            paramAnonymousAnimator = (WindowManager.LayoutParams)FloatBallView.this.getLayoutParams();
            FloatBallView.this.f(paramAnonymousAnimator.x, paramAnonymousAnimator.y, true, false);
            AppMethodBeat.o(288479);
            return;
            localLayoutParams.gravity = 8388613;
            paramAnonymousAnimator.setMarginStart(FloatBallView.aDd());
            paramAnonymousAnimator.setMarginEnd(0);
          }
        }
      });
      this.vop.start();
      AppMethodBeat.o(288633);
      return;
      i = localLayoutParams.getMarginStart();
      break;
      bool = false;
      break label137;
    }
  }
  
  private void c(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    AppMethodBeat.i(288514);
    if ((!paramBoolean4) && (this.vpy == paramBoolean1) && (this.vpz == paramBoolean2) && (this.vpx == paramBoolean3) && (this.vpA != 0) && (this.vpA == this.vnu) && (this.vpu != -1) && (this.vpu == this.vpv))
    {
      Log.d("MicroMsg.FloatBallView", "<<< updateFloatBallViewLayout, ignore layout %b %b;%b %b; %b %b; %d %d", new Object[] { Boolean.valueOf(this.vpE), Boolean.valueOf(paramBoolean1), Boolean.valueOf(this.vpz), Boolean.valueOf(paramBoolean2), Boolean.valueOf(this.vpx), Boolean.valueOf(paramBoolean3), Integer.valueOf(this.vpA), Integer.valueOf(this.vnu) });
      AppMethodBeat.o(288514);
      return;
    }
    Log.i("MicroMsg.FloatBallView", ">>> updateFloatBallViewLayout, isSettled:%s, isDockLeft:%s, isManual:%s, lastLayoutState:%s, currentLayoutState:%s, collapseState: %d", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3), Integer.valueOf(this.vpA), Integer.valueOf(this.vnu), Integer.valueOf(this.vpv) });
    this.vpx = paramBoolean3;
    this.vpy = paramBoolean1;
    this.vpz = paramBoolean2;
    this.vpA = this.vnu;
    cZB();
    L(paramBoolean1, paramBoolean2);
    this.vpu = this.vpv;
    AppMethodBeat.o(288514);
  }
  
  private void cZB()
  {
    AppMethodBeat.i(106468);
    int i;
    int k;
    int m;
    int j;
    if (Gq(this.vnu)) {
      if (Gg(this.vnu))
      {
        i = Ga(this.vnu);
        k = this.vpr * 2 + i;
        m = Gb(this.vnu) + this.vpr * 2;
        if (!Gd(this.vnu))
        {
          i = m;
          j = k;
          if (!Ge(this.vnu)) {}
        }
        else
        {
          i = m + (voc + voe * 2 + vok);
          j = k;
        }
      }
    }
    for (;;)
    {
      m = getHorizontalShadowSize();
      int n = getVerticalShadowSize();
      if ((j != 0) && (i != 0))
      {
        k = j + m + getExtendWidth() + this.vpq.x + getCollapseLayoutWidth();
        i = i + n + this.vpq.y;
      }
      for (;;)
      {
        Log.i("MicroMsg.FloatBallView", "updateFloatBallViewSize finalWidth: %d, viewWidth: %d, shadowWidth: %d, collapseLayoutWidth: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(m), Integer.valueOf(getCollapseLayoutWidth()) });
        gp(k, i);
        AppMethodBeat.o(106468);
        return;
        j = FW(this.vnu);
        i = FX(this.vnu);
        break;
        if (Gg(this.vnu))
        {
          if ((this.vpo != null) && (this.vpo.vjK))
          {
            i = 0;
            j = 0;
            break;
          }
          i = Ga(this.vnu);
          j = this.vpr * 2 + i;
          i = Gb(this.vnu) + this.vpr * 2;
          break;
        }
        if (!Gf(this.vnu)) {
          break label339;
        }
        j = voh;
        i = voh;
        break;
        i = 0;
        k = 0;
      }
      label339:
      i = 0;
      j = 0;
    }
  }
  
  private void cZC()
  {
    AppMethodBeat.i(288671);
    if (((int)getAlpha() == 1) && (getVisibility() == 0))
    {
      int i = getResources().getConfiguration().orientation;
      if (i != this.lastOrientation)
      {
        Log.i("MicroMsg.FloatBallView", "alvinluo checkOrientationIfNeed currentOrientation: %d, lastOrientation: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(this.lastOrientation) });
        FR(i);
      }
    }
    AppMethodBeat.o(288671);
  }
  
  private void cZD()
  {
    AppMethodBeat.i(288675);
    if (!this.vps)
    {
      AppMethodBeat.o(288675);
      return;
    }
    try
    {
      WindowManager.LayoutParams localLayoutParams;
      int i;
      if ((this.vpq.x != 0) || (this.vpq.y != 0))
      {
        localLayoutParams = (WindowManager.LayoutParams)getLayoutParams();
        if (!this.vpe) {
          break label103;
        }
        i = 0;
      }
      for (;;)
      {
        int j = localLayoutParams.y;
        int k = this.vpq.y;
        cZE();
        this.vpt = 80;
        cZB();
        d(i, j + k, true, false);
        AppMethodBeat.o(288675);
        return;
        label103:
        i = localLayoutParams.x;
        j = this.vpq.x;
        i += j;
      }
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.FloatBallView", localException, "alvinluo resetFloatBallViewSizeAndPosition", new Object[0]);
      AppMethodBeat.o(288675);
    }
  }
  
  private void cZE()
  {
    AppMethodBeat.i(288678);
    Log.v("MicroMsg.FloatBallView", "alvinluo resetExtraSize");
    this.vpq.x = 0;
    this.vpq.y = 0;
    AppMethodBeat.o(288678);
  }
  
  private void cZo()
  {
    AppMethodBeat.i(288488);
    if (this.vpv == 0) {
      cZp();
    }
    for (;;)
    {
      Log.v("MicroMsg.FloatBallView", "updateCollapseLayout collapseState: %d, collapseIconRotation: %s", new Object[] { Integer.valueOf(this.vpv), Integer.valueOf(this.voE) });
      AppMethodBeat.o(288488);
      return;
      if (this.vou.getVisibility() != 0)
      {
        this.vou.setVisibility(0);
        this.vou.setAlpha(1.0F);
      }
      if ((this.vpv == 3) || (this.vpv == 1))
      {
        this.voE = 0;
        this.voD.setRotation(this.voE);
      }
      else if ((this.vpv == 4) || (this.vpv == 2))
      {
        this.voE = 180;
        this.voD.setRotation(this.voE);
      }
    }
  }
  
  private void cZp()
  {
    AppMethodBeat.i(288499);
    this.vos.setLayoutTransition(null);
    this.vou.setVisibility(8);
    AppMethodBeat.o(288499);
  }
  
  private void cZq()
  {
    AppMethodBeat.i(288503);
    if ((this.mlX) && (this.vpz != this.vpe)) {
      if (!this.vpe) {
        break label78;
      }
    }
    label78:
    for (int i = 4;; i = 3)
    {
      FQ(i);
      Log.i("MicroMsg.FloatBallView", "updateCollapseStateWhenPositionChanged last: %d, current: %d", new Object[] { Integer.valueOf(this.vpu), Integer.valueOf(this.vpv) });
      AppMethodBeat.o(288503);
      return;
    }
  }
  
  private void cZr()
  {
    AppMethodBeat.i(176978);
    Object localObject = (LinearLayout.LayoutParams)this.vow.getLayoutParams();
    if (Gg(this.vnu)) {}
    for (int i = 8388629;; i = 8388627)
    {
      ((LinearLayout.LayoutParams)localObject).gravity = i;
      this.vow.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if ((!Gd(this.vnu)) || (!Ge(this.vnu))) {
        break;
      }
      cZt();
      AppMethodBeat.o(176978);
      return;
    }
    if ((GD(this.vnu)) || (Gr(this.vnu)))
    {
      this.voy.setVisibility(8);
      this.vox.setVisibility(0);
      localObject = (FrameLayout.LayoutParams)this.vox.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).gravity = 8388629;
      i = voe;
      int j = voe;
      ((FrameLayout.LayoutParams)localObject).setMargins(i, i, j, j);
      this.vox.setLayoutParams((ViewGroup.LayoutParams)localObject);
      AppMethodBeat.o(176978);
      return;
    }
    if (Ge(this.vnu))
    {
      this.vox.setVisibility(8);
      M(true, true);
    }
    AppMethodBeat.o(176978);
  }
  
  private void cZs()
  {
    AppMethodBeat.i(176980);
    Object localObject = (LinearLayout.LayoutParams)this.vow.getLayoutParams();
    if (Gg(this.vnu)) {}
    for (int i = 8388627;; i = 8388629)
    {
      ((LinearLayout.LayoutParams)localObject).gravity = i;
      this.vow.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if ((!Gd(this.vnu)) || (!Ge(this.vnu))) {
        break;
      }
      cZu();
      AppMethodBeat.o(176980);
      return;
    }
    if ((GD(this.vnu)) || (Gr(this.vnu)))
    {
      this.voy.setVisibility(8);
      this.vox.setVisibility(0);
      localObject = (FrameLayout.LayoutParams)this.vox.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).gravity = 8388629;
      i = voe;
      int j = voe;
      ((FrameLayout.LayoutParams)localObject).setMargins(i, i, j, j);
      this.vox.setLayoutParams((ViewGroup.LayoutParams)localObject);
      AppMethodBeat.o(176980);
      return;
    }
    if (Ge(this.vnu))
    {
      this.vox.setVisibility(8);
      M(false, true);
    }
    AppMethodBeat.o(176980);
  }
  
  private void cZt()
  {
    AppMethodBeat.i(176981);
    int i = M(true, true);
    this.vox.setVisibility(0);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.vox.getLayoutParams();
    localLayoutParams.gravity = 8388627;
    int j = voe;
    localLayoutParams.setMargins(i, j, j, voe);
    this.vox.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(176981);
  }
  
  private void cZu()
  {
    AppMethodBeat.i(176982);
    int i = M(false, true);
    this.vox.setVisibility(0);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.vox.getLayoutParams();
    localLayoutParams.gravity = 8388629;
    int j = voe;
    localLayoutParams.setMargins(j, j, i, voe);
    this.vox.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(176982);
  }
  
  private void cZv()
  {
    AppMethodBeat.i(176990);
    int i = 0;
    while (i < this.voY.size())
    {
      long l = ((BallInfo)this.voY.get(i)).hQO;
      if (l >= 0L) {
        P(i, l);
      }
      i += 1;
    }
    AppMethodBeat.o(176990);
  }
  
  private void cZw()
  {
    AppMethodBeat.i(288615);
    if ((h.ax(com.tencent.mm.plugin.ball.c.b.class) != null) && (((com.tencent.mm.plugin.ball.c.b)h.ax(com.tencent.mm.plugin.ball.c.b.class)).cXR()))
    {
      Log.w("MicroMsg.FloatBallView", "checkDoTranslateAnimation forceHideAllFloatBall and ignore");
      AppMethodBeat.o(288615);
      return;
    }
    if (this.vlB) {
      d(new AnimatorListenerAdapter()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(288473);
          super.onAnimationCancel(paramAnonymousAnimator);
          FloatBallView.b(FloatBallView.this, false);
          AppMethodBeat.o(288473);
        }
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(106433);
          super.onAnimationEnd(paramAnonymousAnimator);
          FloatBallView.b(FloatBallView.this, false);
          AppMethodBeat.o(106433);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(288464);
          super.onAnimationStart(paramAnonymousAnimator);
          FloatBallView.b(FloatBallView.this, true);
          AppMethodBeat.o(288464);
        }
      });
    }
    AppMethodBeat.o(288615);
  }
  
  private void cZx()
  {
    AppMethodBeat.i(288621);
    if ((this.vpc != this.vpb) && (com.tencent.mm.plugin.ball.model.a.FG(this.vpv))) {
      cZy();
    }
    AppMethodBeat.o(288621);
  }
  
  private void cZy()
  {
    AppMethodBeat.i(288625);
    WindowManager.LayoutParams localLayoutParams = (WindowManager.LayoutParams)getLayoutParams();
    b(this.vpe, false, localLayoutParams.x, localLayoutParams.y, ap(localLayoutParams.x, false), localLayoutParams.y);
    AppMethodBeat.o(288625);
  }
  
  private float cc(float paramFloat)
  {
    AppMethodBeat.i(288533);
    int i = this.vot.getMeasuredWidth() + getCollapseLayoutWidth();
    if (this.vpe)
    {
      f = i;
      AppMethodBeat.o(288533);
      return paramFloat - f * 0.4F;
    }
    float f = i;
    AppMethodBeat.o(288533);
    return f * 0.4F + paramFloat;
  }
  
  private void d(AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(288629);
    Log.i("MicroMsg.FloatBallView", "alvinluo showByTranslation");
    setNeedTranslateAnimation(false);
    if (this.voq != null)
    {
      boolean bool = FT(((WindowManager.LayoutParams)getLayoutParams()).x);
      this.voq.a(getCurrentStateWidth(), bool, paramAnimatorListenerAdapter);
    }
    AppMethodBeat.o(288629);
  }
  
  private void e(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(288606);
    WindowManager.LayoutParams localLayoutParams = (WindowManager.LayoutParams)getLayoutParams();
    int i = localLayoutParams.x;
    int j = localLayoutParams.y;
    if ((this.windowManager != null) && ((i != paramInt1) || (j != paramInt2)))
    {
      localLayoutParams.x = paramInt1;
      localLayoutParams.y = paramInt2;
      Log.d("MicroMsg.FloatBallView", "updateBallPosition, x:%s, y:%s, dockLeft:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(this.vpe) });
      try
      {
        this.windowManager.updateViewLayout(this, localLayoutParams);
        f(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
        AppMethodBeat.o(288606);
        return;
      }
      finally
      {
        Log.printErrStackTrace("MicroMsg.FloatBallView", localThrowable, "updateBallPosition fail", new Object[0]);
      }
    }
    AppMethodBeat.o(288606);
  }
  
  private void e(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(106444);
    c(paramBoolean1, paramBoolean2, paramBoolean3, false);
    AppMethodBeat.o(106444);
  }
  
  private void ef(List<BallInfo> paramList)
  {
    AppMethodBeat.i(106443);
    this.vnv = this.vnu;
    this.vnu = 0;
    if (AppForegroundDelegate.heY.eLx) {
      this.vnu |= 0x20;
    }
    Object localObject = com.tencent.mm.plugin.ball.f.d.dW(paramList);
    this.vpc = this.vpb;
    this.vpb = ((List)localObject).size();
    localObject = com.tencent.mm.plugin.ball.f.d.dX(com.tencent.mm.plugin.ball.f.d.dV((List)localObject));
    this.voY = com.tencent.mm.plugin.ball.f.d.dS((List)localObject);
    int i = com.tencent.mm.plugin.ball.f.d.FM(com.tencent.mm.plugin.ball.f.d.ec((List)localObject));
    boolean bool2 = com.tencent.mm.plugin.ball.f.d.dT(com.tencent.mm.plugin.ball.f.d.ea(paramList));
    if (bool2) {
      this.vnu |= 0x1;
    }
    boolean bool4;
    boolean bool5;
    boolean bool1;
    if (i == 1)
    {
      this.vnu |= 0x2;
      this.vnw = i;
      this.vpo = com.tencent.mm.plugin.ball.f.d.dY(paramList);
      boolean bool3 = M(this.vpo);
      bool4 = N(this.vpo);
      bool5 = O(this.vpo);
      if ((!bool3) && (!bool4) && (!bool5)) {
        break label491;
      }
      bool1 = true;
      label188:
      this.vpw = bool1;
      if (!this.vpw) {
        FQ(0);
      }
      if (!bool3) {
        break label496;
      }
      this.vnu |= 0x1000;
      label222:
      if (this.vpo != null)
      {
        if (this.vpo.state != 512) {
          break label531;
        }
        this.vnu |= 0x400;
      }
      label254:
      if ((this.vpo != null) && (this.vpo.dyK != null)) {
        setCustomView(this.vpo);
      }
      localObject = this.voY.iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((BallInfo)((Iterator)localObject).next()).type == 20) {
          this.vpa = true;
        }
      }
      this.vpp = com.tencent.mm.plugin.ball.f.d.dZ(paramList);
      if (this.vpp != null)
      {
        if (this.vpp.state != 32) {
          break label559;
        }
        this.vnu |= 0x100;
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.FloatBallView", ">>> updateFloatBallViewLayoutState, state:[%s => %s], active:%s, passiveCnt:%d, video:%s, audio:%s <<<", new Object[] { Integer.valueOf(this.vnv), Integer.valueOf(this.vnu), Boolean.valueOf(bool2), Integer.valueOf(i), Boolean.valueOf(bool4), Boolean.valueOf(bool5) });
      AppMethodBeat.o(106443);
      return;
      if (i == 2)
      {
        this.vnu |= 0x4;
        break;
      }
      if (i == 3)
      {
        this.vnu |= 0x40;
        break;
      }
      if (i != 4) {
        break;
      }
      this.vnu |= 0x80;
      break;
      label491:
      bool1 = false;
      break label188;
      label496:
      if (bool4) {
        this.vnu |= 0x8;
      }
      if (!bool5) {
        break label222;
      }
      this.vnu |= 0x10;
      break label222;
      label531:
      if (this.vpo.state != 1024) {
        break label254;
      }
      this.vnu |= 0x800;
      break label254;
      label559:
      if (this.vpp.state == 64) {
        this.vnu |= 0x200;
      }
    }
  }
  
  private static String eg(List<BallInfo> paramList)
  {
    AppMethodBeat.i(106474);
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramList.size())
    {
      BallInfo localBallInfo = (BallInfo)paramList.get(i);
      localStringBuilder.append(localBallInfo.key).append(localBallInfo.type).append(localBallInfo.icon).append(localBallInfo.tus).append(localBallInfo.state).append(localBallInfo.vjH).append(localBallInfo.trn).append(localBallInfo.hQO);
      if ((com.tencent.mm.plugin.ball.f.d.H(localBallInfo)) && (localBallInfo.dyK != null))
      {
        localStringBuilder.append(localBallInfo.dyK.hashCode());
        if (localBallInfo.vjC != null) {
          localStringBuilder.append(localBallInfo.vjC.x).append(localBallInfo.vjC.y);
        }
      }
      localStringBuilder.append("|");
      i += 1;
    }
    paramList = MD5Util.getMD5String(localStringBuilder.toString());
    AppMethodBeat.o(106474);
    return paramList;
  }
  
  private void f(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(288526);
    int i = g(paramBoolean1, paramBoolean2, paramBoolean3);
    int j = a(this.vnu, paramBoolean1, paramBoolean2, paramBoolean3);
    Log.v("MicroMsg.FloatBallView", "alvinluo updateCustomViewLayout width: %d, height: %d, margin: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(this.vpr) });
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.vov.getLayoutParams();
    localLayoutParams.width = i;
    localLayoutParams.height = j;
    if (this.vpr > 0) {
      localLayoutParams.setMargins(this.vpr, this.vpr, this.vpr, this.vpr);
    }
    this.vov.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(288526);
  }
  
  private int getAppBrandVoipBallInfoIndex()
  {
    AppMethodBeat.i(288583);
    if (com.tencent.mm.plugin.ball.f.d.checkListNotEmpty(this.voY))
    {
      int i = 0;
      while (i < this.voY.size())
      {
        BallInfo localBallInfo = (BallInfo)this.voY.get(i);
        if ((localBallInfo != null) && (localBallInfo.type == 17))
        {
          AppMethodBeat.o(288583);
          return i;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(288583);
    return 0;
  }
  
  private int getCollapseLayoutWidth()
  {
    AppMethodBeat.i(288661);
    if (this.vpw) {}
    for (int i = vom - vol;; i = 0)
    {
      Log.v("MicroMsg.FloatBallView", "getCollapseLayoutWidth collapseState: %d, needCollapse: %s, collapseLayoutWidth: %d", new Object[] { Integer.valueOf(this.vpv), Boolean.valueOf(this.vpw), Integer.valueOf(i) });
      AppMethodBeat.o(288661);
      return i;
    }
  }
  
  private int getCurrentStateHeight()
  {
    AppMethodBeat.i(176991);
    int k = this.vnu;
    int j;
    if (Gg(k))
    {
      j = Gb(k) + this.vpr * 2;
      if (!Gd(k))
      {
        i = j;
        if (!Ge(k)) {
          break label63;
        }
      }
    }
    for (int i = j + (voc + voe * 2 + vok);; i = FX(k))
    {
      label63:
      j = e.vme;
      k = e.vmf;
      AppMethodBeat.o(176991);
      return i + j + k;
    }
  }
  
  private float getCustomViewAlphaAnimationStartX()
  {
    AppMethodBeat.i(288530);
    if (this.vpe)
    {
      f = -this.vos.getPaddingLeft();
      AppMethodBeat.o(288530);
      return f;
    }
    int j = this.vpf.x + this.vos.getPaddingLeft() - getLayoutParams().width;
    int i = j;
    if (this.lastOrientation == 2)
    {
      i = j;
      if (!this.vpe) {
        i = j - this.pvk;
      }
    }
    float f = i;
    AppMethodBeat.o(288530);
    return f;
  }
  
  private int getExtendWidth()
  {
    AppMethodBeat.i(106469);
    if (!this.vpk)
    {
      AppMethodBeat.o(106469);
      return 0;
    }
    if (!com.tencent.mm.plugin.ball.f.d.fD(getContext()))
    {
      AppMethodBeat.o(106469);
      return 0;
    }
    int i = this.windowManager.getDefaultDisplay().getRotation();
    if (((this.vpe) && (i == 1)) || ((!this.vpe) && (i == 3)))
    {
      i = com.tencent.mm.plugin.ball.f.d.bw(getContext());
      AppMethodBeat.o(106469);
      return i;
    }
    AppMethodBeat.o(106469);
    return 0;
  }
  
  private int getHorizontalShadowSize()
  {
    if ((this.vpo != null) && (this.vpo.vjD != null))
    {
      if (this.vpo.vjD.y > 0) {
        return this.vpo.vjD.y;
      }
      return e.vmg * 2;
    }
    return e.vmg * 2;
  }
  
  private int getVerticalShadowSize()
  {
    if ((this.vpo != null) && (this.vpo.vjD != null))
    {
      if (this.vpo.vjD.x > 0) {
        return this.vpo.vjD.x;
      }
      return e.vme + e.vmf;
    }
    return e.vme + e.vmf;
  }
  
  private void gp(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(288666);
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
        Log.i("MicroMsg.FloatBallView", "updateFloatBallViewSize, width:%s, height:%s, notify: %b", new Object[] { Integer.valueOf(localLayoutParams.width), Integer.valueOf(localLayoutParams.height), Boolean.TRUE });
        Iterator localIterator = this.listeners.iterator();
        while (localIterator.hasNext()) {
          ((g)localIterator.next()).a(localLayoutParams.x, localLayoutParams.y, localLayoutParams.height, this.vpy, this.vpe, this.vpv);
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
      AppMethodBeat.o(288666);
    }
  }
  
  public static boolean i(Point paramPoint)
  {
    return (paramPoint != null) && (paramPoint.x > 0) && (paramPoint.y > 0);
  }
  
  private boolean mA(boolean paramBoolean)
  {
    AppMethodBeat.i(288591);
    WindowManager.LayoutParams localLayoutParams = (WindowManager.LayoutParams)getLayoutParams();
    int i = localLayoutParams.x;
    int j = localLayoutParams.y;
    if ((FS(i)) || (paramBoolean))
    {
      i = Math.max(Math.min(i, this.vpf.x), -getLayoutParams().width);
      j = Math.max(Math.min(j, this.vpf.y), 0);
      if ((this.vpw) && (com.tencent.mm.plugin.ball.model.a.FG(this.vpv))) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        int k = ap(i, paramBoolean);
        int m = FU(j);
        Log.i("MicroMsg.FloatBallView", "stickToScreenEdgeIfNeed, start:[%s, %s], target:[%s, %s]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m) });
        if ((i != k) || (j != m)) {
          d(k, m, true, false);
        }
        AppMethodBeat.o(288591);
        return true;
      }
    }
    AppMethodBeat.o(288591);
    return false;
  }
  
  private int mB(boolean paramBoolean)
  {
    AppMethodBeat.i(288642);
    int i;
    if (!this.vpw)
    {
      if (this.vpe) {
        break label226;
      }
      i = this.vpf.x - e.vmg - getCurrentStateWidth();
    }
    for (;;)
    {
      i = FV(i);
      Log.v("MicroMsg.FloatBallView", "getTargetPositionXWhenOrientationChanged screen.x: %d, horizontalShadowSize: %d, width: %d, needCollapse: %s, targetX: %s", new Object[] { Integer.valueOf(this.vpf.x), Integer.valueOf(e.vmg), Integer.valueOf(getLayoutParams().width), Boolean.valueOf(paramBoolean), Integer.valueOf(i) });
      AppMethodBeat.o(288642);
      return i;
      if (paramBoolean)
      {
        i = Ga(this.vnu);
        if (this.vpe) {
          i = vol + 0 - i - e.vmg;
        } else {
          i = i + this.vpf.x + e.vmg - vol - getLayoutParams().width;
        }
      }
      else if (this.vpe)
      {
        i = 0 - e.vmg - getCollapseLayoutWidth();
      }
      else
      {
        i = this.vpf.x + e.vmg + getCollapseLayoutWidth() - getLayoutParams().width;
        continue;
        label226:
        i = 0;
      }
    }
  }
  
  private void mx(boolean paramBoolean)
  {
    AppMethodBeat.i(288494);
    cZo();
    Object localObject;
    if (!com.tencent.mm.plugin.ball.model.a.FG(this.vpv))
    {
      localObject = (LinearLayout.LayoutParams)this.rpv.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).setMarginStart(0);
      ((LinearLayout.LayoutParams)localObject).setMarginEnd(0);
      this.rpv.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    if (!this.vpw)
    {
      localObject = (FrameLayout.LayoutParams)this.vot.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).setMarginStart(0);
      ((FrameLayout.LayoutParams)localObject).setMarginEnd(0);
      this.vot.setLayoutParams((ViewGroup.LayoutParams)localObject);
      AppMethodBeat.o(288494);
      return;
    }
    this.vos.setLayoutTransition(this.voZ);
    int i;
    if (this.vpv == 0)
    {
      i = getCollapseLayoutWidth();
      localObject = (FrameLayout.LayoutParams)this.vot.getLayoutParams();
      if (!paramBoolean) {
        break label162;
      }
      ((FrameLayout.LayoutParams)localObject).gravity = 8388611;
      ((FrameLayout.LayoutParams)localObject).setMarginStart(i);
      ((FrameLayout.LayoutParams)localObject).setMarginEnd(0);
    }
    for (;;)
    {
      this.vot.setLayoutParams((ViewGroup.LayoutParams)localObject);
      AppMethodBeat.o(288494);
      return;
      label162:
      ((FrameLayout.LayoutParams)localObject).gravity = 8388613;
      ((FrameLayout.LayoutParams)localObject).setMarginStart(0);
      ((FrameLayout.LayoutParams)localObject).setMarginEnd(i);
    }
  }
  
  private void my(boolean paramBoolean)
  {
    AppMethodBeat.i(288544);
    int i;
    boolean bool;
    if (Gg(this.vnu))
    {
      View localView = this.rpv;
      if ((Gd(this.vnu)) || (Ge(this.vnu)))
      {
        i = 0;
        localView.setVisibility(i);
        this.vov.setVisibility(0);
        bool = Gc(this.vnu);
        if ((!Gi(this.vnu)) && (!Gh(this.vnu))) {
          break label215;
        }
        if ((!GA(this.vnu)) && (!GC(this.vnu))) {
          break label193;
        }
        this.rpv.setVisibility(4);
        f(true, false, bool);
        this.vow.setVisibility(8);
      }
    }
    for (;;)
    {
      if (paramBoolean)
      {
        if ((!Gg(this.vnv)) && (Gg(this.vnu)) && ((Gd(this.vnu)) || (Ge(this.vnu))))
        {
          mA(true);
          AppMethodBeat.o(288544);
          return;
          i = 4;
          break;
          label193:
          f(true, false, bool);
          this.vow.setVisibility(0);
          cZr();
          continue;
          label215:
          if (!Gl(this.vnu)) {
            continue;
          }
          if (GB(this.vnu))
          {
            this.rpv.setVisibility(4);
            f(false, true, bool);
            this.vow.setVisibility(8);
            continue;
          }
          f(false, true, bool);
          this.vow.setVisibility(0);
          cZr();
          continue;
          this.rpv.setVisibility(8);
          this.vov.setVisibility(8);
          this.vow.setVisibility(0);
          cZr();
          continue;
        }
        if ((Gg(this.vnv)) && ((Gd(this.vnv)) || (Ge(this.vnv))) && (!Gg(this.vnu))) {
          mA(true);
        }
      }
    }
    AppMethodBeat.o(288544);
  }
  
  private void mz(boolean paramBoolean)
  {
    AppMethodBeat.i(288547);
    int i;
    boolean bool;
    if (Gg(this.vnu))
    {
      View localView = this.rpv;
      if ((Gd(this.vnu)) || (Ge(this.vnu)))
      {
        i = 0;
        localView.setVisibility(i);
        this.vov.setVisibility(0);
        bool = Gc(this.vnu);
        if ((!Gi(this.vnu)) && (!Gh(this.vnu))) {
          break label175;
        }
        if ((!GA(this.vnu)) && (!GC(this.vnu))) {
          break label153;
        }
        this.rpv.setVisibility(4);
        f(true, false, bool);
        this.vow.setVisibility(8);
      }
    }
    for (;;)
    {
      if (paramBoolean) {
        mA(false);
      }
      AppMethodBeat.o(288547);
      return;
      i = 4;
      break;
      label153:
      f(true, false, bool);
      this.vow.setVisibility(0);
      cZs();
      continue;
      label175:
      if (GB(this.vnu))
      {
        this.rpv.setVisibility(4);
        f(false, true, bool);
        this.vow.setVisibility(8);
      }
      else
      {
        f(false, true, bool);
        this.vow.setVisibility(0);
        cZs();
        continue;
        this.rpv.setVisibility(8);
        this.vov.setVisibility(8);
        this.vow.setVisibility(0);
        cZs();
      }
    }
  }
  
  private void setCustomViewLayoutAlpha(float paramFloat)
  {
    AppMethodBeat.i(288538);
    this.vov.setAlpha(paramFloat);
    AppMethodBeat.o(288538);
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
  
  public final boolean FT(int paramInt)
  {
    AppMethodBeat.i(106459);
    if (getCurrentStateWidth() / 2 + paramInt <= this.vpf.x / 2)
    {
      AppMethodBeat.o(106459);
      return true;
    }
    AppMethodBeat.o(106459);
    return false;
  }
  
  public final boolean Gc(int paramInt)
  {
    AppMethodBeat.i(288811);
    if ((Gd(paramInt)) && (this.vnw >= 3))
    {
      AppMethodBeat.o(288811);
      return true;
    }
    AppMethodBeat.o(288811);
    return false;
  }
  
  public final int a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(288807);
    int i = 0;
    if ((paramBoolean1) || (paramBoolean2))
    {
      if ((this.vjC != null) && (this.vjC.x > 0) && (this.vjC.y > 0)) {
        i = this.vjC.y;
      }
      while (paramBoolean3)
      {
        if ((!Gj(paramInt)) && (!Gk(paramInt))) {
          break label167;
        }
        if ((this.vjC != null) && (this.vjC.x > 0) && (this.vjC.y > 0))
        {
          paramInt = this.vjC.y;
          AppMethodBeat.o(288807);
          return paramInt;
          if (paramBoolean1) {
            i = vnU + vol * 2;
          } else {
            i = vnY + vol * 2;
          }
        }
        else
        {
          i = vnY + vol * 2;
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(288807);
      return i;
      label167:
      if ((this.vjC != null) && (this.vjC.x > 0) && (this.vjC.y > 0) && (this.vjC.x >= this.vjC.y))
      {
        paramInt = this.vjC.y;
        AppMethodBeat.o(288807);
        return paramInt;
      }
      if (paramBoolean1) {
        i = vnW + vol * 2;
      } else {
        i = voa + vol * 2;
      }
    }
  }
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(288813);
    this.listeners.add(paramg);
    AppMethodBeat.o(288813);
  }
  
  public final void a(List<BallInfo> paramList, BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106442);
    paramBallInfo = eg(paramList);
    if (Util.isEqual(paramBallInfo, this.voX))
    {
      Log.d("MicroMsg.FloatBallView", "<<< onFloatBallInfoChanged, ignore refresh");
      AppMethodBeat.o(106442);
      return;
    }
    Log.i("MicroMsg.FloatBallView", ">>> onFloatBallInfoChanged, ballInfoList:%s", new Object[] { paramList });
    this.voX = paramBallInfo;
    ef(paramList);
    cZv();
    boolean bool = FT(((WindowManager.LayoutParams)getLayoutParams()).x);
    c(true, bool, false, this.vpa);
    this.vpa = false;
    a(true, bool, false, this.vnu);
    cZw();
    cZx();
    AppMethodBeat.o(106442);
  }
  
  public final void an(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(288753);
    Log.i("MicroMsg.FloatBallView", "updateBallRootViewLayout gravity: %d, isSettled: %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    Object localObject = (FrameLayout.LayoutParams)this.vos.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject).gravity = paramInt;
    this.vos.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if ((!paramBoolean) && (!Gq(this.vnu)) && (this.vow.getVisibility() == 0))
    {
      localObject = (LinearLayout.LayoutParams)this.vow.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).gravity = 17;
      this.vow.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    AppMethodBeat.o(288753);
  }
  
  public final void b(boolean paramBoolean, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(184624);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.fv(paramBoolean);
    localb.cH(paramAnimatorListenerAdapter);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/ball/view/FloatBallView", "com/tencent/mm/plugin/ball/view/FloatBallView", "hide", "(ZLandroid/animation/AnimatorListenerAdapter;)V", this, localb.aYj());
    if (getVisibility() == 8)
    {
      Log.i("MicroMsg.FloatBallView", "float ball already hide");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ball/view/FloatBallView", "com/tencent/mm/plugin/ball/view/FloatBallView", "hide", "(ZLandroid/animation/AnimatorListenerAdapter;)V");
      AppMethodBeat.o(184624);
      return;
    }
    if ((paramBoolean) && (this.voq != null))
    {
      Log.i("MicroMsg.FloatBallView", "hide with animation");
      this.voq.b(paramAnimatorListenerAdapter);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ball/view/FloatBallView", "com/tencent/mm/plugin/ball/view/FloatBallView", "hide", "(ZLandroid/animation/AnimatorListenerAdapter;)V");
      AppMethodBeat.o(184624);
      return;
      Log.i("MicroMsg.FloatBallView", "hide without animation");
      setVisibility(8);
      cZD();
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
    if ((paramBoolean1) && (this.voq != null))
    {
      Log.i("MicroMsg.FloatBallView", "show with animation");
      this.voq.a(paramAnimatorListenerAdapter);
      AppMethodBeat.o(184623);
      return;
    }
    Log.i("MicroMsg.FloatBallView", "show without animation");
    setVisibility(0);
    AppMethodBeat.o(184623);
  }
  
  public final void cZA()
  {
    AppMethodBeat.i(184622);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.fv(false);
    localb.cH(null);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/ball/view/FloatBallView", "com/tencent/mm/plugin/ball/view/FloatBallView", "show", "(ZLandroid/animation/AnimatorListenerAdapter;)V", this, localb.aYj());
    c(false, false, null);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ball/view/FloatBallView", "com/tencent/mm/plugin/ball/view/FloatBallView", "show", "(ZLandroid/animation/AnimatorListenerAdapter;)V");
    AppMethodBeat.o(184622);
  }
  
  public final void cZz()
  {
    AppMethodBeat.i(288767);
    super.setVisibility(0);
    AppMethodBeat.o(288767);
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
    this.vpe = FT(paramInt1);
    cZq();
    a(paramBoolean1, this.vpe, paramBoolean2, this.vnu);
    e(paramBoolean1, this.vpe, paramBoolean2);
    ao(paramInt2, paramBoolean1);
    Log.i("MicroMsg.FloatBallView", "notifyBallPositionChanged, x:%s, y:%s, isSettled:%s, isManual:%s, isDockLeft:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(this.vpe) });
    Iterator localIterator = this.listeners.iterator();
    while (localIterator.hasNext()) {
      ((g)localIterator.next()).a(paramInt1, paramInt2, getCurrentStateHeight(), paramBoolean1, this.vpe, this.vpv);
    }
    AppMethodBeat.o(106457);
  }
  
  public final int g(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int i = 0;
    int j;
    if ((paramBoolean1) || (paramBoolean2))
    {
      if ((this.vjC == null) || (this.vjC.x <= 0) || (this.vjC.y <= 0)) {
        break label90;
      }
      j = this.vjC.x;
      if (!paramBoolean3) {
        break label142;
      }
      if (!paramBoolean1) {
        break label76;
      }
      i = vnV + vol * 2;
    }
    while (j < i)
    {
      return i;
      label76:
      i = vnZ + vol * 2;
      continue;
      label90:
      if (paramBoolean1)
      {
        if (paramBoolean3) {
          return vnV + vol * 2;
        }
        return vnT + vol * 2;
      }
      if (paramBoolean3) {
        return vnZ + vol * 2;
      }
      return vnX + vol * 2;
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
    if (this.vpe)
    {
      if ((Gi(this.vnu)) || (Gh(this.vnu)))
      {
        localObject = new Point(((WindowManager.LayoutParams)localObject).x, ((WindowManager.LayoutParams)localObject).y + e.vme + vnU);
        AppMethodBeat.o(106470);
        return localObject;
      }
      if (Gl(this.vnu))
      {
        localObject = new Point(((WindowManager.LayoutParams)localObject).x, ((WindowManager.LayoutParams)localObject).y + e.vme + vnY);
        AppMethodBeat.o(106470);
        return localObject;
      }
      localObject = new Point(((WindowManager.LayoutParams)localObject).x, ((WindowManager.LayoutParams)localObject).y + e.vme);
      AppMethodBeat.o(106470);
      return localObject;
    }
    if ((Gi(this.vnu)) || (Gh(this.vnu)))
    {
      localObject = new Point(((WindowManager.LayoutParams)localObject).x + e.vmg, ((WindowManager.LayoutParams)localObject).y + e.vme + vnU);
      AppMethodBeat.o(106470);
      return localObject;
    }
    if (Gl(this.vnu))
    {
      localObject = new Point(((WindowManager.LayoutParams)localObject).x + e.vmg, ((WindowManager.LayoutParams)localObject).y + e.vme + vnY);
      AppMethodBeat.o(106470);
      return localObject;
    }
    localObject = new Point(((WindowManager.LayoutParams)localObject).x + e.vmg, ((WindowManager.LayoutParams)localObject).y + e.vme);
    AppMethodBeat.o(106470);
    return localObject;
  }
  
  public Point getBallSize()
  {
    AppMethodBeat.i(288781);
    Log.v("MicroMsg.FloatBallView", "alvinluo getBallSize stateWidth: %d, stateHeight: %d", new Object[] { Integer.valueOf(getCurrentStateWidth()), Integer.valueOf(getCurrentStateHeight()) });
    Point localPoint = new Point(getCurrentStateWidth() - e.vmg, getCurrentStateHeight() - e.vme - e.vmf);
    AppMethodBeat.o(288781);
    return localPoint;
  }
  
  public int getCurrentStateWidth()
  {
    AppMethodBeat.i(106467);
    int i = this.vnu;
    if (Gg(i)) {}
    for (i = Ga(i) + getHorizontalShadowSize() + getExtendWidth() + this.vpq.x + getCollapseLayoutWidth();; i = FW(i) + e.vmg)
    {
      AppMethodBeat.o(106467);
      return i;
    }
  }
  
  public Point getFloatBallPosition()
  {
    AppMethodBeat.i(288779);
    Object localObject = (WindowManager.LayoutParams)getLayoutParams();
    if (localObject == null)
    {
      AppMethodBeat.o(288779);
      return null;
    }
    if (this.vpe)
    {
      localObject = new Point(((WindowManager.LayoutParams)localObject).x, ((WindowManager.LayoutParams)localObject).y + e.vme);
      AppMethodBeat.o(288779);
      return localObject;
    }
    localObject = new Point(((WindowManager.LayoutParams)localObject).x + e.vmg, ((WindowManager.LayoutParams)localObject).y + e.vme);
    AppMethodBeat.o(288779);
    return localObject;
  }
  
  public float getPosYPercentOfScreen()
  {
    return this.vpi;
  }
  
  public int getPositionY()
  {
    return this.vpj;
  }
  
  public final void mn(boolean paramBoolean)
  {
    AppMethodBeat.i(176992);
    Log.i("MicroMsg.FloatBallView", "markWechatInForeground, visibility:%s, inForeground:%s", new Object[] { Integer.valueOf(getVisibility()), Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
      this.vnu |= 0x20;
    }
    for (;;)
    {
      e(this.vpy, this.vpz, this.vpx);
      AppMethodBeat.o(176992);
      return;
      this.vnu &= 0xFFFFFFDF;
      if ((Gg(this.vnu)) || (Gf(this.vnu)))
      {
        cZA();
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
    int i = ap(localLayoutParams.x, false);
    Log.i("MicroMsg.FloatBallView", "onAttachedToWindow targetX: %s", new Object[] { Integer.valueOf(i) });
    if (localLayoutParams.x != i) {
      d(i, localLayoutParams.y, true, false);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ball/view/FloatBallView", "com/tencent/mm/plugin/ball/view/FloatBallView", "onAttachedToWindow", "()V");
      AppMethodBeat.o(106439);
      return;
      f(localLayoutParams.x, localLayoutParams.y, true, false);
    }
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(106441);
    Log.i("MicroMsg.FloatBallView", "onConfigurationChanged, orientation:%d, lastOrientation: %d", new Object[] { Integer.valueOf(paramConfiguration.orientation), Integer.valueOf(this.lastOrientation) });
    FR(paramConfiguration.orientation);
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
    if (this.vop != null)
    {
      this.vop.cancel();
      this.vop = null;
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ball/view/FloatBallView", "com/tencent/mm/plugin/ball/view/FloatBallView", "onDetachedFromWindow", "()V");
    AppMethodBeat.o(106440);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(288756);
    if (com.tencent.mm.plugin.ball.model.a.FG(this.vpv))
    {
      AppMethodBeat.o(288756);
      return true;
    }
    int i = (int)paramMotionEvent.getRawX();
    int j = (int)paramMotionEvent.getRawY();
    if (paramMotionEvent.getAction() == 0) {
      W(paramMotionEvent);
    }
    if (com.tencent.mm.plugin.ball.f.d.q(this.dyK, i, j))
    {
      if (paramMotionEvent.getAction() != 2)
      {
        AppMethodBeat.o(288756);
        return false;
      }
      boolean bool = F(paramMotionEvent);
      AppMethodBeat.o(288756);
      return bool;
    }
    AppMethodBeat.o(288756);
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(106452);
    boolean bool1;
    if (!this.vpd)
    {
      bool1 = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(106452);
      return bool1;
    }
    switch (paramMotionEvent.getAction())
    {
    }
    Iterator localIterator;
    label324:
    float f2;
    for (;;)
    {
      AppMethodBeat.o(106452);
      return true;
      this.mlX = false;
      W(paramMotionEvent);
      a(true, this.vpe, true, this.vnu);
      if (this.vpk) {
        e(true, this.vpe, true);
      }
      this.viF = false;
      if ((Gq(this.vnu)) && (!GA(this.vnu)) && (!GB(this.vnu)) && (!GC(this.vnu)))
      {
        this.vpB.postDelayed(this.vpC, this.voo);
        continue;
        if (this.viF)
        {
          X(paramMotionEvent);
        }
        else
        {
          if ((!this.mlX) && (F(paramMotionEvent)))
          {
            this.vpB.removeCallbacks(this.vpC);
            this.mlX = true;
            this.vou.setVisibility(8);
            if (this.vpw)
            {
              this.vos.setLayoutTransition(this.voZ);
              if (!this.vpe) {
                break label324;
              }
            }
            for (i = 4;; i = 3)
            {
              FQ(i);
              i = this.vph.x;
              i = this.vph.y;
              localIterator = this.listeners.iterator();
              while (localIterator.hasNext()) {
                ((g)localIterator.next()).cXX();
              }
            }
          }
          if (this.mlX)
          {
            i = G(paramMotionEvent);
            d(i, H(paramMotionEvent), false, true);
            f1 = i;
            f2 = getCustomViewAlphaAnimationStartX();
            b(1.0F, 0.0F, f1, f2, cc(f2));
            continue;
            if (this.viF)
            {
              a(true, this.vpe, false, this.vnu);
              if (this.vpk) {
                e(true, this.vpe, false);
              }
              X(paramMotionEvent);
            }
            else
            {
              this.vpB.removeCallbacks(this.vpC);
              if ((this.mlX) || (F(paramMotionEvent))) {
                break;
              }
              a(true, this.vpe, false, this.vnu);
              if (this.vpk) {
                e(true, this.vpe, false);
              }
              d(this.vph.x, this.vph.y, true, false);
              if (this.vpm)
              {
                f1 = this.vpg.x;
                f2 = this.vpg.y;
                long l = System.currentTimeMillis();
                if (l > this.lastClickTime + 800L)
                {
                  this.lastClickTime = l;
                  if (com.tencent.mm.plugin.ball.model.a.FG(this.vpv))
                  {
                    Log.i("MicroMsg.FloatBallView", "notifyBallClickedIfNeed, click collapseLayout");
                    cZy();
                  }
                  else if (com.tencent.mm.plugin.ball.f.d.q(this.dyK, (int)f1, (int)f2))
                  {
                    Log.w("MicroMsg.FloatBallView", "notifyBallClickedIfNeed, click voip unexpectedly");
                  }
                  else if ((GB(this.vnu)) || (GA(this.vnu)) || (GC(this.vnu)))
                  {
                    Log.i("MicroMsg.FloatBallView", "notifyBallClickedIfNeed, ignore click");
                  }
                  else if (Gq(this.vnu))
                  {
                    Log.i("MicroMsg.FloatBallView", "notifyBallClickedIfNeed, wechat in foreground");
                    paramMotionEvent = this.listeners.iterator();
                    while (paramMotionEvent.hasNext()) {
                      ((g)paramMotionEvent.next()).cXV();
                    }
                  }
                  else if ((this.vpp != null) && (h.ax(com.tencent.mm.plugin.ball.c.b.class) != null))
                  {
                    Log.i("MicroMsg.FloatBallView", "notifyBallClickedIfNeed, you clicked appbrand voip");
                    this.vpp.vjI.opType = 3;
                    ((com.tencent.mm.plugin.ball.c.b)h.ax(com.tencent.mm.plugin.ball.c.b.class)).m(this.vpp);
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
    a(false, this.vpe, false, this.vnu);
    if (this.mlX)
    {
      this.mlX = false;
      localIterator = this.listeners.iterator();
      while (localIterator.hasNext()) {
        ((g)localIterator.next()).cXY();
      }
    }
    int i = G(paramMotionEvent);
    int j = H(paramMotionEvent);
    float f1 = i;
    label886:
    int k;
    int m;
    if (this.vpw)
    {
      f2 = cc(getCustomViewAlphaAnimationStartX());
      if (this.vpe) {
        if (f1 <= f2)
        {
          bool1 = true;
          k = ap(i, bool1);
          m = FU(j);
          if (k > 0) {
            break label1007;
          }
        }
      }
    }
    label1007:
    for (boolean bool2 = true;; bool2 = false)
    {
      Log.i("MicroMsg.FloatBallView", "onTouchEvent, stickToLeft:%s, startSticky:[%s, %s]=>[%s, %s]", new Object[] { Boolean.valueOf(bool2), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m) });
      b(bool2, bool1, i, j, k, m);
      break;
      bool1 = false;
      break label886;
      if (f1 >= f2)
      {
        bool1 = true;
        break label886;
      }
      bool1 = false;
      break label886;
    }
  }
  
  public void setAlpha(float paramFloat)
  {
    AppMethodBeat.i(106473);
    super.setAlpha(paramFloat);
    Log.printInfoStack("MicroMsg.FloatBallView", "setAlpha:%s", new Object[] { Float.valueOf(paramFloat) });
    cZC();
    AppMethodBeat.o(106473);
  }
  
  public void setCustomView(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(288795);
    Object localObject = paramBallInfo.dyK;
    if (localObject == this.dyK)
    {
      Log.w("MicroMsg.FloatBallView", "setCustomView voipView not changed");
      P(paramBallInfo);
      AppMethodBeat.o(288795);
      return;
    }
    if ((((View)localObject).getParent() != null) && ((((View)localObject).getParent() instanceof ViewGroup)))
    {
      Log.i("MicroMsg.FloatBallView", "setCustomView remove from parent first");
      ((ViewGroup)((View)localObject).getParent()).removeView((View)localObject);
    }
    this.vov.removeAllViews();
    this.dyK = ((View)localObject);
    localObject = new FrameLayout.LayoutParams(-1, -1);
    ((FrameLayout.LayoutParams)localObject).gravity = 17;
    this.vov.addView(this.dyK, (ViewGroup.LayoutParams)localObject);
    setCustomViewLayoutAlpha(1.0F);
    P(paramBallInfo);
    AppMethodBeat.o(288795);
  }
  
  public void setEnableClick(boolean paramBoolean)
  {
    AppMethodBeat.i(288764);
    Log.d("MicroMsg.FloatBallView", "alvinluo setEnableClick enable: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.vpm = paramBoolean;
    AppMethodBeat.o(288764);
  }
  
  public void setFloatBallAlpha(final float paramFloat)
  {
    AppMethodBeat.i(106460);
    com.tencent.mm.plugin.ball.b.b localb = this.voq;
    if ((localb.cXD()) || (localb.cXE())) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.printInfoStack("MicroMsg.FloatBallView", "setFloatBallAlpha later, alpha:%s", new Object[] { Float.valueOf(paramFloat) });
      localb = this.voq;
      Runnable local5 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(288469);
          Log.i("MicroMsg.FloatBallView", "setFloatBallAlpha when animation ends, alpha:%s", new Object[] { Float.valueOf(paramFloat) });
          FloatBallView.a(FloatBallView.this, paramFloat);
          AppMethodBeat.o(288469);
        }
      };
      localb.vjy.add(local5);
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
    if (paramView == this.vor)
    {
      AppMethodBeat.o(106471);
      return;
    }
    this.vox.removeAllViews();
    this.vor = paramView;
    if (this.vor != null)
    {
      paramView = new FrameLayout.LayoutParams(-1, -1);
      paramView.gravity = 17;
      this.vox.addView(this.vor, paramView);
    }
    AppMethodBeat.o(106471);
  }
  
  public void setNeedTranslateAnimation(boolean paramBoolean)
  {
    this.vlB = paramBoolean;
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(106472);
    if ((!this.vpl) && (h.ax(com.tencent.mm.plugin.ball.c.b.class) != null) && (((com.tencent.mm.plugin.ball.c.b)h.ax(com.tencent.mm.plugin.ball.c.b.class)).cXR()))
    {
      super.setVisibility(8);
      AppMethodBeat.o(106472);
      return;
    }
    super.setVisibility(paramInt);
    int i = (int)getAlpha();
    if (i == 0)
    {
      this.vpd = false;
      Log.printInfoStack("MicroMsg.FloatBallView", "setVisibility:%s, alphaInt:%s, disableTouch", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      AppMethodBeat.o(106472);
      return;
    }
    if (i == 1)
    {
      this.vpd = true;
      Log.printInfoStack("MicroMsg.FloatBallView", "setVisibility:%s, alphaInt:%s, enableTouch", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      cZC();
    }
    AppMethodBeat.o(106472);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.view.FloatBallView
 * JD-Core Version:    0.7.0.1
 */