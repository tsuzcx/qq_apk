package com.tencent.mm.plugin.finder.live.plugin;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.PointF;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.ch;
import com.tencent.mm.live.b.l.b;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.b.e;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.live.report.m;
import com.tencent.mm.plugin.finder.live.report.s.bf;
import com.tencent.mm.plugin.finder.loader.r;
import com.tencent.mm.plugin.finder.loader.t.a;
import com.tencent.mm.plugin.finder.loader.w;
import com.tencent.mm.plugin.finder.storage.u;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.aal;
import com.tencent.mm.protocal.protobuf.axe;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandler.Callback;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.ax;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g;
import kotlin.g.b.aa.d;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.j.c.b;
import kotlin.k.i;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveLikeConfettiPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "CONFETTI_INTERVAL", "", "HEAD_HEAD_LIKE_INTERVAL", "", "HL_CHEER_MAX_COUNT", "HL_LIKE_ANIMATION_DURATION", "HL_LIKE_DESTINATION_Y", "HL_LIKE_END_OFFSET_X", "HL_LIKE_SIZE", "HL_OFFSET_X_MAX", "LIKE_FROM_OTHER", "LIKE_INTERNAL", "LIKE_MANNUAL", "SCREEN_HEIGHT", "", "TAG", "", "callBack", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler$CallBack;", "confettiBitmaps", "Ljava/util/ArrayList;", "Landroid/graphics/Bitmap;", "Lkotlin/collections/ArrayList;", "confettiManager", "Lcom/tencent/mm/particles/ConfettiManager;", "confettiRoot", "Landroid/widget/FrameLayout;", "kotlin.jvm.PlatformType", "count", "customConfettiBitmaps", "customConfettiRate", "customTotalRate", "hadler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "highLightLikeRoot", "Landroid/widget/RelativeLayout;", "isUnMount", "", "likeXyArray", "", "liking", "normalLikeShowCount", "postLikeWork", "timeHandler", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "getTimeHandler", "()Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "timeHandler$delegate", "Lkotlin/Lazy;", "waitingHlCheerList", "calculateNormalPoint", "Landroid/graphics/PointF;", "t", "start", "end", "canClearScreen", "checkEmitHighLightCheer", "", "x", "y", "checkXyArray", "emitHightLightLike", "emitLikeConfetti", "needHalfAlpha", "emitLikeConfettiMsg", "genHighLightLikeControlPoint", "startPoint", "endPoint", "initLikeXyArray", "loadOthersAvatar", "headUrl", "loadSelfAvatar", "username", "mount", "nextInt", "next", "rollNextBitmap", "setupConfig", "cheerIconInfos", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/CheerIconInfo;", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "stopLikeTimer", "tryEmitHightLightLikeByOthers", "hlCheerList", "", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "unMount", "LineInterpolator", "plugin-finder_release"})
public final class bi
  extends d
{
  private final String TAG;
  private long count;
  private final com.tencent.mm.live.c.b kCL;
  private final FrameLayout kFC;
  private com.tencent.mm.particles.c kFD;
  private final ArrayList<Bitmap> kFE;
  private final kotlin.f xVz;
  private float ysW;
  private final RelativeLayout ysX;
  private ArrayList<Bitmap> ysY;
  private ArrayList<Integer> ysZ;
  private int yta;
  private final int ytb;
  private final int ytc;
  private final int ytd;
  private volatile boolean yte;
  volatile boolean ytf;
  final long ytg;
  private final int yth;
  private final int yti;
  private final int ytj;
  private final int ytk;
  private final long ytl;
  private final int ytm;
  private final ArrayList<String> ytn;
  private final int[] yto;
  private final int ytp;
  private int ytq;
  volatile boolean ytr;
  private MTimerHandler.CallBack yts;
  private MMHandler ytt;
  
  public bi(ViewGroup paramViewGroup, com.tencent.mm.live.c.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(284525);
    this.kCL = paramb;
    this.TAG = "Finder.FinderLiveLikeConfettiPlugin";
    this.ysW = ax.au(MMApplicationContext.getContext()).y;
    this.kFC = ((FrameLayout)paramViewGroup.findViewById(b.f.live_like_confetti_container));
    this.ysX = ((RelativeLayout)paramViewGroup.findViewById(b.f.live_like_high_light_like_container));
    this.kFE = new ArrayList();
    this.ysY = new ArrayList();
    this.ysZ = new ArrayList();
    this.yta = 100;
    this.ytb = 1;
    this.ytc = 2;
    this.ytd = 3;
    this.ytg = 200L;
    this.yth = aw.fromDPToPix(paramViewGroup.getContext(), 48);
    this.yti = aw.fromDPToPix(paramViewGroup.getContext(), 48);
    this.ytj = (ax.au(paramViewGroup.getContext()).y / 2 - aw.fromDPToPix(paramViewGroup.getContext(), 24));
    this.ytk = aw.fromDPToPix(paramViewGroup.getContext(), 60);
    this.ytl = 2500L;
    this.ytm = 3;
    this.ytn = new ArrayList();
    this.yto = new int[] { 0, 0 };
    this.ytp = 8;
    this.yts = ((MTimerHandler.CallBack)new b(this));
    this.xVz = g.ar((kotlin.g.a.a)new h(this));
    paramb = com.tencent.mm.plugin.finder.live.j.xVS;
    if (!com.tencent.mm.plugin.finder.live.j.dwI()) {
      paramViewGroup.post((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(227164);
          bi.n(this.ytu);
          AppMethodBeat.o(227164);
        }
      });
    }
    this.ytt = new MMHandler(Looper.getMainLooper(), (MMHandler.Callback)new d(this));
    AppMethodBeat.o(284525);
  }
  
  private final int Nz(int paramInt)
  {
    AppMethodBeat.i(284519);
    if (paramInt <= 0)
    {
      Log.i(this.TAG, "[nextInt] param:" + paramInt + " is not positive,stack:");
      Log.printInfoStack(this.TAG, "nextInt", new Object[0]);
      AppMethodBeat.o(284519);
      return 0;
    }
    paramInt = kotlin.j.c.aaBL.os(0, paramInt);
    AppMethodBeat.o(284519);
    return paramInt;
  }
  
  private final void dBO()
  {
    AppMethodBeat.i(284511);
    Object localObject4;
    try
    {
      localObject4 = new int[2];
      Object tmp13_11 = localObject4;
      tmp13_11[0] = 0;
      Object tmp17_13 = tmp13_11;
      tmp17_13[1] = 0;
      tmp17_13;
      Object localObject1 = this.kiF.getParent();
      if (localObject1 == null)
      {
        localObject1 = new kotlin.t("null cannot be cast to non-null type android.view.View");
        AppMethodBeat.o(284511);
        throw ((Throwable)localObject1);
      }
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace(this.TAG, (Throwable)localException, "FinderLiveLikeConfettiPlugin LIKE_FROM_OTHER", new Object[0]);
      localObject2 = new ch();
      ((ch)localObject2).mh("2");
      ((ch)localObject2).fk(10004L);
      ((ch)localObject2).bpa();
      AppMethodBeat.o(284511);
      return;
    }
    Object localObject3 = ((View)localObject2).findViewById(b.f.finder_live_like_click_area);
    Object localObject2 = localObject3;
    if (localObject3 == null)
    {
      localObject2 = this.kiF.getParent();
      if (localObject2 == null)
      {
        localObject2 = new kotlin.t("null cannot be cast to non-null type android.view.View");
        AppMethodBeat.o(284511);
        throw ((Throwable)localObject2);
      }
      localObject2 = ((View)localObject2).findViewById(b.f.finder_live_anchor_like_indicator_icon);
    }
    int j;
    int k;
    int m;
    int n;
    int i1;
    if (localObject2 != null)
    {
      ((View)localObject2).getLocationOnScreen((int[])localObject4);
      j = localObject4[0];
      float f = ((View)localObject2).getWidth();
      k = (int)(((View)localObject2).getScaleX() * f / 2.0F);
      localObject2 = l.b.kum;
      m = l.b.aNC() / 2;
      n = localObject4[1];
      i1 = aw.fromDPToPix(this.kiF.getContext(), 16);
      localObject2 = this.yto;
      if (isLandscape())
      {
        localObject3 = com.tencent.mm.plugin.finder.live.utils.a.yRm;
        localObject3 = this.kiF.getContext();
        p.j(localObject3, "root.context");
        localObject4 = com.tencent.mm.plugin.finder.live.utils.a.yRm;
        if (com.tencent.mm.plugin.finder.live.utils.a.k(getBuContext())) {
          break label381;
        }
        localObject4 = com.tencent.mm.plugin.finder.live.utils.a.yRm;
        if (com.tencent.mm.plugin.finder.live.utils.a.l(getBuContext())) {
          break label381;
        }
      }
    }
    for (;;)
    {
      for (int i = com.tencent.mm.plugin.finder.live.utils.a.E((Context)localObject3, bool);; i = 0)
      {
        localObject2[0] = (k + j - m - i);
        this.yto[1] = (n - i1);
        AppMethodBeat.o(284511);
        return;
        bool = false;
        break;
      }
      AppMethodBeat.o(284511);
      return;
      label381:
      boolean bool = true;
    }
  }
  
  private final Bitmap dBP()
  {
    AppMethodBeat.i(284516);
    Object localObject1 = this.kFE.get(Nz(this.kFE.size()));
    p.j(localObject1, "confettiBitmaps[nextInt(confettiBitmaps.size)]");
    Bitmap localBitmap = (Bitmap)localObject1;
    Object localObject3;
    int i;
    int j;
    if ((this.ysY.size() > 0) && (this.yta > 0))
    {
      synchronized (this.ysY)
      {
        localObject4 = ((Iterable)this.ysZ).iterator();
        if (!((Iterator)localObject4).hasNext())
        {
          localObject1 = (Throwable)new UnsupportedOperationException("Empty collection can't be reduced.");
          AppMethodBeat.o(284516);
          throw ((Throwable)localObject1);
        }
      }
      for (localObject3 = ((Iterator)localObject4).next(); ((Iterator)localObject4).hasNext(); localObject3 = Integer.valueOf(((Number)localObject3).intValue() + i)) {
        i = ((Number)((Iterator)localObject4).next()).intValue();
      }
      j = ((Number)localObject3).intValue();
      if (j < 100) {}
      for (i = 100;; i = j)
      {
        localObject3 = new aa.d();
        ((aa.d)localObject3).aaBA = Nz(i);
        i = ((aa.d)localObject3).aaBA;
        if (i <= j) {
          break;
        }
        AppMethodBeat.o(284516);
        return localBitmap;
      }
      Object localObject4 = (Iterable)this.ysZ;
      i = 0;
      localObject4 = ((Iterable)localObject4).iterator();
      if (((Iterator)localObject4).hasNext())
      {
        Object localObject5 = ((Iterator)localObject4).next();
        if (i < 0) {
          kotlin.a.j.iBO();
        }
        j = ((Number)localObject5).intValue();
        if (((aa.d)localObject3).aaBA <= j)
        {
          localObject3 = (Bitmap)kotlin.a.j.M((List)this.ysY, i);
          if (localObject3 != null) {
            break label360;
          }
          localObject3 = localBitmap;
        }
      }
    }
    label360:
    for (;;)
    {
      AppMethodBeat.o(284516);
      return localObject3;
      ((aa.d)localObject3).aaBA -= j;
      i += 1;
      break;
      localObject3 = x.aazN;
      AppMethodBeat.o(284516);
      return localBitmap;
    }
  }
  
  private final void dBQ()
  {
    AppMethodBeat.i(284524);
    getTimeHandler().stopTimer();
    this.yts = null;
    this.count = 0L;
    this.ytf = false;
    AppMethodBeat.o(284524);
  }
  
  private final void gH(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(284512);
    Log.v(this.TAG, "checkEmitHighLightCheer waitingHlCheerList.size:" + this.ytn.size());
    int i;
    Object localObject1;
    if (!((Collection)this.ytn).isEmpty())
    {
      i = 1;
      if (i == 0) {
        break label522;
      }
      localObject1 = this.ytn.remove(0);
      p.j(localObject1, "waitingHlCheerList.removeAt(0)");
      localObject1 = (String)localObject1;
      if (((CharSequence)localObject1).length() <= 0) {
        break label261;
      }
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        if (Util.isEqual((String)localObject1, z.bcZ()))
        {
          localPointF1 = new PointF(paramInt1, paramInt2);
          localPointF2 = new PointF(paramInt1, this.ytj);
          localObject2 = new ImageView(this.kiF.getContext());
          a.b.d((ImageView)localObject2, (String)localObject1);
          localObject1 = new ViewGroup.MarginLayoutParams(this.yth, this.yth);
          ((ViewGroup.MarginLayoutParams)localObject1).setMarginStart(paramInt1);
          ((ViewGroup.MarginLayoutParams)localObject1).topMargin = paramInt2;
          ((ImageView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
          this.ysX.addView((View)localObject2);
          ((ImageView)localObject2).setAlpha(0.0F);
          ((ImageView)localObject2).post((Runnable)new f(this, (ImageView)localObject2, localPointF1, localPointF2));
          AppMethodBeat.o(284512);
          return;
          i = 0;
          break;
          label261:
          i = 0;
          continue;
        }
        final PointF localPointF1 = new PointF(paramInt1, paramInt2);
        final PointF localPointF2 = new PointF(paramInt1, this.ytj);
        Object localObject2 = new PointF(paramInt1, paramInt2 - (paramInt2 - this.ytj) * 0.3F);
        final PointF localPointF3 = new PointF(paramInt1 - Nz(this.yti), this.ytj);
        float f1 = ((PointF)localObject2).x;
        i = Nz((int)(i.aP(((PointF)localObject2).y - localPointF3.y, 1.0F) / 2.0F));
        float f2 = localPointF3.y;
        float f3 = ((PointF)localObject2).y;
        float f4 = localPointF3.y;
        float f5 = i;
        final PointF localPointF4 = new PointF(i.aQ(f1, ax.au(this.kiF.getContext()).x - this.yth), f5 + (f2 + (f3 - f4) * 0.25F));
        Object localObject3 = com.tencent.mm.plugin.finder.loader.t.ztT;
        localObject3 = com.tencent.mm.plugin.finder.loader.t.dJh();
        com.tencent.mm.plugin.finder.loader.e locale = new com.tencent.mm.plugin.finder.loader.e((String)localObject1);
        com.tencent.mm.plugin.finder.loader.t localt = com.tencent.mm.plugin.finder.loader.t.ztT;
        ((com.tencent.mm.loader.d)localObject3).a(locale, com.tencent.mm.plugin.finder.loader.t.a(t.a.ztX)).a((com.tencent.mm.loader.f.e)new e(this, paramInt1, paramInt2, localPointF1, localPointF2, (PointF)localObject2, localPointF4, localPointF3, (String)localObject1)).tA();
      }
    }
    label522:
    AppMethodBeat.o(284512);
  }
  
  public final void ao(LinkedList<aal> paramLinkedList)
  {
    AppMethodBeat.i(284515);
    p.k(paramLinkedList, "cheerIconInfos");
    this.ysY = new ArrayList();
    this.ysZ = new ArrayList();
    this.yta = 0;
    paramLinkedList = ((Iterable)paramLinkedList).iterator();
    while (paramLinkedList.hasNext())
    {
      Object localObject2 = (aal)paramLinkedList.next();
      this.yta += ((aal)localObject2).SmB;
      Object localObject1 = ((aal)localObject2).ufC;
      int i = ((aal)localObject2).SmB;
      localObject2 = new csg();
      ((csg)localObject2).mediaId = MD5Util.getMD5String((String)localObject1);
      ((csg)localObject2).url = ((String)localObject1);
      ((csg)localObject2).thumbUrl = ((String)localObject1);
      localObject1 = new r((csg)localObject2, u.Alz, null, null, 12);
      localObject2 = com.tencent.mm.plugin.finder.loader.t.ztT;
      localObject1 = com.tencent.mm.plugin.finder.loader.t.dJe().bQ(localObject1);
      localObject2 = com.tencent.mm.plugin.finder.loader.t.ztT;
      ((com.tencent.mm.loader.a.b)localObject1).a(com.tencent.mm.plugin.finder.loader.t.a(t.a.ztU)).a((com.tencent.mm.loader.f.e)new g(i, this)).aRr();
    }
    AppMethodBeat.o(284515);
  }
  
  public final boolean dAo()
  {
    return true;
  }
  
  public final void dBs()
  {
    AppMethodBeat.i(284514);
    Object localObject1 = this.kiF.getContext();
    p.j(localObject1, "root.context");
    localObject1 = BitmapFactory.decodeResource(((Context)localObject1).getResources(), b.e.live_like_icon1);
    Object localObject2 = l.b.kum;
    int i = l.b.aNC();
    localObject2 = l.b.kum;
    localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject1, i, l.b.aNC(), true);
    localObject2 = this.kiF.getContext();
    p.j(localObject2, "root.context");
    localObject2 = BitmapFactory.decodeResource(((Context)localObject2).getResources(), b.e.live_like_icon2);
    Object localObject3 = l.b.kum;
    i = l.b.aNC();
    localObject3 = l.b.kum;
    localObject2 = Bitmap.createScaledBitmap((Bitmap)localObject2, i, l.b.aNC(), true);
    localObject3 = this.kiF.getContext();
    p.j(localObject3, "root.context");
    localObject3 = BitmapFactory.decodeResource(((Context)localObject3).getResources(), b.e.live_like_icon3);
    Object localObject4 = l.b.kum;
    i = l.b.aNC();
    localObject4 = l.b.kum;
    localObject3 = Bitmap.createScaledBitmap((Bitmap)localObject3, i, l.b.aNC(), true);
    localObject4 = this.kiF.getContext();
    p.j(localObject4, "root.context");
    localObject4 = BitmapFactory.decodeResource(((Context)localObject4).getResources(), b.e.live_like_icon4);
    Object localObject5 = l.b.kum;
    i = l.b.aNC();
    localObject5 = l.b.kum;
    localObject4 = Bitmap.createScaledBitmap((Bitmap)localObject4, i, l.b.aNC(), true);
    localObject5 = this.kiF.getContext();
    p.j(localObject5, "root.context");
    localObject5 = BitmapFactory.decodeResource(((Context)localObject5).getResources(), b.e.live_like_icon5);
    Object localObject6 = l.b.kum;
    i = l.b.aNC();
    localObject6 = l.b.kum;
    localObject5 = Bitmap.createScaledBitmap((Bitmap)localObject5, i, l.b.aNC(), true);
    localObject6 = this.kiF.getContext();
    p.j(localObject6, "root.context");
    localObject6 = BitmapFactory.decodeResource(((Context)localObject6).getResources(), b.e.live_like_icon6);
    l.b localb = l.b.kum;
    i = l.b.aNC();
    localb = l.b.kum;
    localObject6 = Bitmap.createScaledBitmap((Bitmap)localObject6, i, l.b.aNC(), true);
    this.kFE.add(localObject1);
    this.kFE.add(localObject2);
    this.kFE.add(localObject3);
    this.kFE.add(localObject4);
    this.kFE.add(localObject5);
    this.kFE.add(localObject6);
    AppMethodBeat.o(284514);
  }
  
  public final void es(final List<axe> paramList)
  {
    AppMethodBeat.i(284518);
    p.k(paramList, "hlCheerList");
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new i(this, paramList));
    AppMethodBeat.o(284518);
  }
  
  final MTimerHandler getTimeHandler()
  {
    AppMethodBeat.i(284510);
    MTimerHandler localMTimerHandler = (MTimerHandler)this.xVz.getValue();
    AppMethodBeat.o(284510);
    return localMTimerHandler;
  }
  
  public final void mount()
  {
    AppMethodBeat.i(284520);
    super.mount();
    this.ytr = false;
    AppMethodBeat.o(284520);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    int i = 100;
    AppMethodBeat.i(284523);
    p.k(paramc, "status");
    super.statusChange(paramc, paramBundle);
    switch (bj.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    default: 
      AppMethodBeat.o(284523);
      return;
    case 1: 
      if (paramBundle != null) {}
      for (j = paramBundle.getInt("PARAM_LIVE_LIKE_CONFETTI_X");; j = 100)
      {
        if (paramBundle != null) {
          i = paramBundle.getInt("PARAM_LIVE_LIKE_CONFETTI_Y");
        }
        x(j, i, false);
        this.yte = true;
        paramc = m.yCt;
        m.a(s.bf.yLa, "1");
        m.yBv += 1;
        this.ytt.removeMessages(this.ytb);
        this.ytt.sendEmptyMessageDelayed(this.ytb, 1000L);
        AppMethodBeat.o(284523);
        return;
      }
    case 2: 
      if ((paramBundle == null) || (paramBundle.getBoolean("PARAM_FINDER_LIVE_LIKE_ENABLE", true)))
      {
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfg = true;
        tU(0);
        AppMethodBeat.o(284523);
        return;
      }
      tU(8);
      AppMethodBeat.o(284523);
      return;
    case 3: 
      long l;
      if ((((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zff) && (!com.tencent.mm.ae.d.dr(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfa, 512)))
      {
        tU(0);
        l = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)getBuContext().business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfj;
        if ((l <= 0L) || (this.yte)) {
          AppMethodBeat.o(284523);
        }
      }
      else
      {
        tU(8);
        AppMethodBeat.o(284523);
        return;
      }
      paramc = this.ytt.obtainMessage(this.ytc, Long.valueOf(l));
      this.ytt.sendMessageDelayed(paramc, 300L);
      AppMethodBeat.o(284523);
      return;
    case 4: 
      this.ytt.removeMessages(this.ytc);
      this.ytt.removeMessages(this.ytb);
      dBQ();
      Log.i(this.TAG, "CLOSE_LIVE " + this + " ,postLikeWork:" + this.ytf);
      AppMethodBeat.o(284523);
      return;
    }
    if (paramBundle != null)
    {
      String str = paramBundle.getString("PARAM_FINDER_LIVE_HEAD_URL");
      paramc = str;
      if (str != null) {}
    }
    else
    {
      paramc = "";
    }
    p.j(paramc, "param?.getString(ILiveSt…NDER_LIVE_HEAD_URL) ?: \"\"");
    if (paramBundle != null) {}
    for (int j = paramBundle.getInt("PARAM_LIVE_LIKE_CONFETTI_X");; j = 100)
    {
      if (paramBundle != null) {
        i = paramBundle.getInt("PARAM_LIVE_LIKE_CONFETTI_Y");
      }
      this.ytn.add(0, paramc);
      gH(j, i);
      break;
    }
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(284521);
    super.unMount();
    this.ytr = true;
    dBQ();
    Log.i(this.TAG, "unMount " + this + " ,postLikeWork:" + this.ytf);
    this.ytt.removeMessages(this.ytc);
    this.ytt.removeMessages(this.ytb);
    AppMethodBeat.o(284521);
  }
  
  public final void x(int paramInt1, int paramInt2, final boolean paramBoolean)
  {
    AppMethodBeat.i(284517);
    Log.d(this.TAG, "emitLikeConfetti containerMiddleX=" + paramInt1 + " containerMiddleY=" + paramInt2);
    Object localObject1 = new com.tencent.mm.particles.d(paramInt1, paramInt2);
    com.tencent.mm.particles.b localb = (com.tencent.mm.particles.b)new c(dBP(), paramBoolean);
    Object localObject2 = com.tencent.mm.plugin.finder.live.utils.a.yRm;
    localObject2 = this.kiF.getContext();
    p.j(localObject2, "root.context");
    FrameLayout localFrameLayout = this.kFC;
    p.j(localFrameLayout, "confettiRoot");
    this.kFD = com.tencent.mm.plugin.finder.live.utils.a.a((Context)localObject2, localb, (com.tencent.mm.particles.d)localObject1, (ViewGroup)localFrameLayout);
    localObject1 = this.kFD;
    if (localObject1 != null)
    {
      ((com.tencent.mm.particles.c)localObject1).bux();
      AppMethodBeat.o(284517);
      return;
    }
    AppMethodBeat.o(284517);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onTimerExpired"})
  static final class b
    implements MTimerHandler.CallBack
  {
    b(bi parambi) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(286763);
      if ((bi.i(this.ytu) > 0L) && (bi.j(this.ytu)[0] != 0) && (bi.j(this.ytu)[1] != 0))
      {
        bi localbi = this.ytu;
        bi.a(localbi, bi.i(localbi) - 1L);
        this.ytu.x(bi.j(this.ytu)[0], bi.j(this.ytu)[1], true);
        localbi = this.ytu;
        bi.a(localbi, bi.k(localbi) + 1);
        if (bi.k(this.ytu) % bi.l(this.ytu) == 0)
        {
          bi.a(this.ytu, bi.j(this.ytu)[0], bi.j(this.ytu)[1]);
          bi.a(this.ytu, 0);
          bi.d(this.ytu).clear();
        }
      }
      AppMethodBeat.o(286763);
      return true;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/live/view/confetti/LiveLikeConfetti;", "it", "Ljava/util/Random;", "kotlin.jvm.PlatformType", "generateConfetti"})
  static final class c
    implements com.tencent.mm.particles.b
  {
    c(Bitmap paramBitmap, boolean paramBoolean) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"})
  static final class d
    implements MMHandler.Callback
  {
    d(bi parambi) {}
    
    public final boolean handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(287308);
      int i = paramMessage.what;
      if (i == bi.o(this.ytu)) {
        bi.p(this.ytu);
      }
      for (;;)
      {
        AppMethodBeat.o(287308);
        return true;
        if (i == bi.q(this.ytu))
        {
          bi localbi = this.ytu;
          if (!localbi.ytf)
          {
            localbi.ytf = true;
            localbi.getTimeHandler().stopTimer();
            if (!localbi.ytr) {
              localbi.getTimeHandler().startTimer(localbi.ytg);
            }
          }
          bi.c(this.ytu);
          paramMessage = paramMessage.obj;
          if (paramMessage == null)
          {
            paramMessage = new kotlin.t("null cannot be cast to non-null type kotlin.Long");
            AppMethodBeat.o(287308);
            throw paramMessage;
          }
          long l = ((Long)paramMessage).longValue();
          paramMessage = this.ytu;
          bi.a(paramMessage, l + bi.i(paramMessage));
        }
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/loader/model/data/DataItem;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "resource", "Landroid/graphics/Bitmap;", "onImageLoadComplete"})
  static final class e<T, R>
    implements com.tencent.mm.loader.f.e<w, Bitmap>
  {
    e(bi parambi, int paramInt1, int paramInt2, PointF paramPointF1, PointF paramPointF2, PointF paramPointF3, PointF paramPointF4, PointF paramPointF5, String paramString) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(bi parambi, ImageView paramImageView, PointF paramPointF1, PointF paramPointF2) {}
    
    public final void run()
    {
      AppMethodBeat.i(261131);
      this.ytH.animate().setDuration(bi.e(this.ytu)).setInterpolator((TimeInterpolator)new bi.a(new PointF(0.18F, 0.3F))).setUpdateListener((ValueAnimator.AnimatorUpdateListener)new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(292050);
          p.j(paramAnonymousValueAnimator, "it");
          if ((paramAnonymousValueAnimator.getAnimatedValue() instanceof Float))
          {
            paramAnonymousValueAnimator = paramAnonymousValueAnimator.getAnimatedValue();
            if (paramAnonymousValueAnimator == null)
            {
              paramAnonymousValueAnimator = new kotlin.t("null cannot be cast to non-null type kotlin.Float");
              AppMethodBeat.o(292050);
              throw paramAnonymousValueAnimator;
            }
            float f = ((Float)paramAnonymousValueAnimator).floatValue();
            if (f <= 0.3F)
            {
              this.ytJ.ytH.setAlpha(3.333333F * f);
              this.ytJ.ytH.setScaleX(3.333333F * f);
              this.ytJ.ytH.setScaleY(3.333333F * f);
            }
            for (;;)
            {
              paramAnonymousValueAnimator = bi.a(f, this.ytJ.ytz, this.ytJ.ytA);
              localLayoutParams = this.ytJ.ytH.getLayoutParams();
              if (localLayoutParams != null) {
                break;
              }
              paramAnonymousValueAnimator = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
              AppMethodBeat.o(292050);
              throw paramAnonymousValueAnimator;
              if (f > 0.7F)
              {
                this.ytJ.ytH.setAlpha((1.0F - f) * 3.333333F);
                this.ytJ.ytH.setScaleX(i.aQ(1.0F - (0.3F - (1.0F - f)) * 0.6666666F, 1.0F));
                this.ytJ.ytH.setScaleY(i.aQ(1.0F - (0.3F - (1.0F - f)) * 0.6666666F, 1.0F));
              }
              else
              {
                this.ytJ.ytH.setAlpha(1.0F);
                this.ytJ.ytH.setScaleX(1.0F);
                this.ytJ.ytH.setScaleY(1.0F);
              }
            }
            ((ViewGroup.MarginLayoutParams)localLayoutParams).setMarginStart((int)paramAnonymousValueAnimator.x);
            ViewGroup.LayoutParams localLayoutParams = this.ytJ.ytH.getLayoutParams();
            if (localLayoutParams == null)
            {
              paramAnonymousValueAnimator = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
              AppMethodBeat.o(292050);
              throw paramAnonymousValueAnimator;
            }
            ((ViewGroup.MarginLayoutParams)localLayoutParams).topMargin = ((int)paramAnonymousValueAnimator.y);
            this.ytJ.ytH.requestLayout();
          }
          AppMethodBeat.o(292050);
        }
      }).setListener((Animator.AnimatorListener)new AnimatorListenerAdapter()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(269769);
          bi.f(this.ytJ.ytu).removeView((View)this.ytJ.ytH);
          AppMethodBeat.o(269769);
        }
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(269768);
          bi.f(this.ytJ.ytu).removeView((View)this.ytJ.ytH);
          AppMethodBeat.o(269768);
        }
      }).start();
      AppMethodBeat.o(261131);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "kotlin.jvm.PlatformType", "view", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "resource", "Landroid/graphics/Bitmap;", "onImageLoadComplete", "com/tencent/mm/plugin/finder/live/plugin/FinderLiveLikeConfettiPlugin$setupConfig$1$1"})
  static final class g<T, R>
    implements com.tencent.mm.loader.f.e<w, Bitmap>
  {
    g(int paramInt, bi parambi) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.a<MTimerHandler>
  {
    h(bi parambi)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class i
    extends q
    implements kotlin.g.a.a<x>
  {
    i(bi parambi, List paramList)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.bi
 * JD-Core Version:    0.7.0.1
 */