package com.tencent.mm.plugin.finder.live.plugin;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
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
import com.tencent.mm.autogen.mmdata.rpt.di;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.live.model.l.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.live.p.d;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.report.q.bu;
import com.tencent.mm.plugin.finder.live.util.f;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.a;
import com.tencent.mm.plugin.finder.loader.n;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.storage.v;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.acl;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.bf;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.ah.d;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.j.c.a;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveLikeConfettiPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "confettiBitmapManager", "Lcom/tencent/mm/plugin/finder/live/widget/manager/ConfettiBitmapManager;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/plugin/finder/live/widget/manager/ConfettiBitmapManager;)V", "CONFETTI_INTERVAL", "", "HEAD_HEAD_LIKE_INTERVAL", "", "HL_CHEER_MAX_COUNT", "HL_LIKE_ANIMATION_DURATION", "HL_LIKE_DESTINATION_Y", "HL_LIKE_END_OFFSET_X", "HL_LIKE_SIZE", "HL_OFFSET_X_MAX", "LIKE_EXIT_APPLAUD_MODE", "LIKE_FROM_OTHER", "LIKE_INTERNAL", "LIKE_MANNUAL", "SCREEN_HEIGHT", "", "TAG", "", "applaudBitmaps", "Ljava/util/ArrayList;", "Landroid/graphics/Bitmap;", "Lkotlin/collections/ArrayList;", "callBack", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler$CallBack;", "confettiBitmaps", "confettiManager", "Lcom/tencent/mm/particles/ConfettiManager;", "confettiRoot", "Landroid/widget/FrameLayout;", "kotlin.jvm.PlatformType", "getConfettiRoot", "()Landroid/widget/FrameLayout;", "confettiRoot$delegate", "Lkotlin/Lazy;", "count", "customConfettiBitmaps", "customConfettiRate", "customTotalRate", "hadler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "highLightLikeRoot", "Landroid/widget/RelativeLayout;", "getHighLightLikeRoot", "()Landroid/widget/RelativeLayout;", "highLightLikeRoot$delegate", "isInApplaudMode", "", "isUnMount", "likeXyArray", "", "liking", "normalLikeShowCount", "postLikeWork", "timeHandler", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "getTimeHandler", "()Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "timeHandler$delegate", "waitingHlCheerList", "calculateNormalPoint", "Landroid/graphics/PointF;", "t", "start", "end", "canClearScreen", "checkEmitHighLightCheer", "", "x", "y", "checkXyArray", "emitHightLightLike", "emitLikeConfetti", "needHalfAlpha", "emitLikeConfettiMsg", "genHighLightLikeControlPoint", "startPoint", "endPoint", "initLikeXyArray", "loadOthersAvatar", "headUrl", "loadSelfAvatar", "username", "mount", "nextInt", "next", "onClearForSideBar", "clear", "rollNextBitmap", "setVisible", "visible", "setupConfig", "cheerIconInfos", "", "Lcom/tencent/mm/protocal/protobuf/CheerIconInfo;", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "stopLikeTimer", "tryEmitHightLightLikeByOthers", "hlCheerList", "", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "unMount", "updateCheerInfos", "LineInterpolator", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class az
  extends b
{
  private final j Bwl;
  private volatile boolean CVa;
  private final int DdA;
  private final int DdB;
  private volatile boolean DdC;
  private volatile boolean DdD;
  private final long DdE;
  private final int DdF;
  private final int DdG;
  private final int DdH;
  private final int DdI;
  private final long DdJ;
  private final int DdK;
  private final ArrayList<String> DdL;
  private final int[] DdM;
  private final int DdN;
  private int DdO;
  private volatile boolean DdP;
  private MTimerHandler.CallBack DdQ;
  private MMHandler DdR;
  private float Ddr;
  private final j Dds;
  private final j Ddt;
  private ArrayList<Bitmap> Ddu;
  private ArrayList<Bitmap> Ddv;
  private ArrayList<Integer> Ddw;
  private int Ddx;
  private final int Ddy;
  private final int Ddz;
  private final String TAG;
  private final com.tencent.mm.plugin.finder.live.widget.manager.a confettiBitmapManager;
  private volatile long count;
  private final com.tencent.mm.live.b.b nfT;
  private com.tencent.mm.particles.c niE;
  private final ArrayList<Bitmap> niF;
  
  public az(ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb, com.tencent.mm.plugin.finder.live.widget.manager.a parama)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(354970);
    this.nfT = paramb;
    this.confettiBitmapManager = parama;
    this.TAG = "Finder.FinderLiveLikeConfettiPlugin";
    this.Ddr = bf.bf(MMApplicationContext.getContext()).y;
    this.Dds = kotlin.k.cm((kotlin.g.a.a)new c(paramViewGroup));
    this.Ddt = kotlin.k.cm((kotlin.g.a.a)new d(paramViewGroup));
    paramb = this.confettiBitmapManager;
    if (paramb == null)
    {
      paramb = null;
      parama = paramb;
      if (paramb == null) {
        parama = new ArrayList();
      }
      this.niF = parama;
      paramb = this.confettiBitmapManager;
      if (paramb != null) {
        break label406;
      }
    }
    label406:
    for (paramb = null;; paramb = paramb.Ddu)
    {
      parama = paramb;
      if (paramb == null) {
        parama = new ArrayList();
      }
      this.Ddu = parama;
      this.Ddv = new ArrayList();
      this.Ddw = new ArrayList();
      this.Ddx = 100;
      this.Ddy = 1;
      this.Ddz = 2;
      this.DdA = 3;
      this.DdB = 4;
      this.DdE = 200L;
      this.DdF = bd.fromDPToPix(paramViewGroup.getContext(), 48);
      this.DdG = bd.fromDPToPix(paramViewGroup.getContext(), 48);
      this.DdH = (bf.bf(paramViewGroup.getContext()).y / 2 - bd.fromDPToPix(paramViewGroup.getContext(), 24));
      this.DdI = bd.fromDPToPix(paramViewGroup.getContext(), 60);
      this.DdJ = 2500L;
      this.DdK = 3;
      this.DdL = new ArrayList();
      this.DdM = new int[] { 0, 0 };
      this.DdN = 8;
      this.DdQ = new az..ExternalSyntheticLambda5(this);
      this.Bwl = kotlin.k.cm((kotlin.g.a.a)new g(this));
      paramb = com.tencent.mm.plugin.finder.live.g.Bwn;
      if (!com.tencent.mm.plugin.finder.live.g.egZ()) {
        paramViewGroup.post(new az..ExternalSyntheticLambda8(this));
      }
      this.DdR = new MMHandler(Looper.getMainLooper(), new az..ExternalSyntheticLambda4(this));
      AppMethodBeat.o(354970);
      return;
      paramb = paramb.niF;
      break;
    }
  }
  
  private final int Pa(int paramInt)
  {
    AppMethodBeat.i(355043);
    if (paramInt <= 0)
    {
      Log.i(this.TAG, "[nextInt] param:" + paramInt + " is not positive,stack:");
      Log.printInfoStack(this.TAG, "nextInt", new Object[0]);
      AppMethodBeat.o(355043);
      return 0;
    }
    paramInt = kotlin.j.c.aixl.qq(0, paramInt);
    AppMethodBeat.o(355043);
    return paramInt;
  }
  
  private static PointF a(float paramFloat, PointF paramPointF1, PointF paramPointF2)
  {
    AppMethodBeat.i(355057);
    PointF localPointF = new PointF();
    localPointF.x = paramPointF1.x;
    paramPointF1.y -= (paramPointF1.y - paramPointF2.y) * paramFloat;
    AppMethodBeat.o(355057);
    return localPointF;
  }
  
  private static final com.tencent.mm.particles.a.b a(Bitmap paramBitmap, boolean paramBoolean, Random paramRandom)
  {
    AppMethodBeat.i(355109);
    kotlin.g.b.s.u(paramBitmap, "$bitmap");
    if (paramBoolean) {}
    for (float f = 0.5F;; f = 1.0F)
    {
      paramBitmap = (com.tencent.mm.particles.a.b)new com.tencent.mm.live.view.b.a(paramBitmap, f);
      AppMethodBeat.o(355109);
      return paramBitmap;
    }
  }
  
  private static final void a(final ImageView paramImageView, az paramaz, PointF paramPointF1, PointF paramPointF2)
  {
    AppMethodBeat.i(355134);
    kotlin.g.b.s.u(paramImageView, "$hightLightLikeImage");
    kotlin.g.b.s.u(paramaz, "this$0");
    kotlin.g.b.s.u(paramPointF1, "$startPoint");
    kotlin.g.b.s.u(paramPointF2, "$endPoint");
    paramImageView.animate().setDuration(paramaz.DdJ).setInterpolator((TimeInterpolator)new az.a(new PointF(0.18F, 0.3F))).setUpdateListener(new az..ExternalSyntheticLambda0(paramImageView, paramaz, paramPointF1, paramPointF2)).setListener((Animator.AnimatorListener)new f(paramaz, paramImageView)).start();
    AppMethodBeat.o(355134);
  }
  
  private static final void a(ImageView paramImageView, az paramaz, PointF paramPointF1, PointF paramPointF2, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(355125);
    kotlin.g.b.s.u(paramImageView, "$hightLightLikeImage");
    kotlin.g.b.s.u(paramaz, "this$0");
    kotlin.g.b.s.u(paramPointF1, "$startPoint");
    kotlin.g.b.s.u(paramPointF2, "$endPoint");
    if ((paramValueAnimator.getAnimatedValue() instanceof Float))
    {
      paramaz = paramValueAnimator.getAnimatedValue();
      if (paramaz == null)
      {
        paramImageView = new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(355125);
        throw paramImageView;
      }
      float f = ((Float)paramaz).floatValue();
      if (f <= 0.3F)
      {
        paramImageView.setAlpha(3.333333F * f);
        paramImageView.setScaleX(3.333333F * f);
        paramImageView.setScaleY(3.333333F * f);
      }
      for (;;)
      {
        paramaz = a(f, paramPointF1, paramPointF2);
        paramPointF1 = paramImageView.getLayoutParams();
        if (paramPointF1 != null) {
          break;
        }
        paramImageView = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(355125);
        throw paramImageView;
        if (f > 0.7F)
        {
          paramImageView.setAlpha((1.0F - f) * 3.333333F);
          paramImageView.setScaleX(kotlin.k.k.bu(1.0F - (0.3F - (1.0F - f)) * 0.6666666F, 1.0F));
          paramImageView.setScaleY(kotlin.k.k.bu(1.0F - (0.3F - (1.0F - f)) * 0.6666666F, 1.0F));
        }
        else
        {
          paramImageView.setAlpha(1.0F);
          paramImageView.setScaleX(1.0F);
          paramImageView.setScaleY(1.0F);
        }
      }
      ((ViewGroup.MarginLayoutParams)paramPointF1).setMarginStart((int)paramaz.x);
      paramPointF1 = paramImageView.getLayoutParams();
      if (paramPointF1 == null)
      {
        paramImageView = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(355125);
        throw paramImageView;
      }
      ((ViewGroup.MarginLayoutParams)paramPointF1).topMargin = ((int)paramaz.y);
      paramImageView.requestLayout();
    }
    AppMethodBeat.o(355125);
  }
  
  private static final void a(az paramaz, int paramInt, com.tencent.mm.loader.g.a.a arg2, com.tencent.mm.loader.d.b.g paramg, Bitmap paramBitmap)
  {
    AppMethodBeat.i(355102);
    kotlin.g.b.s.u(paramaz, "this$0");
    if (paramBitmap != null) {
      synchronized (paramaz.Ddv)
      {
        paramg = l.b.mYf;
        int i = l.b.bhn();
        paramg = l.b.mYf;
        paramg = Bitmap.createScaledBitmap(paramBitmap, i, l.b.bhn(), true);
        paramaz.Ddv.add(paramg);
        paramaz.Ddw.add(Integer.valueOf(paramInt));
        AppMethodBeat.o(355102);
        return;
      }
    }
    AppMethodBeat.o(355102);
  }
  
  private static final void a(final az paramaz, final String paramString, final int paramInt1, final int paramInt2, final PointF paramPointF1, final PointF paramPointF2, final PointF paramPointF3, final PointF paramPointF4, final PointF paramPointF5, com.tencent.mm.loader.g.a.a parama, com.tencent.mm.loader.d.b.g paramg, Bitmap paramBitmap)
  {
    AppMethodBeat.i(355143);
    kotlin.g.b.s.u(paramaz, "this$0");
    kotlin.g.b.s.u(paramString, "$headUrl");
    kotlin.g.b.s.u(paramPointF1, "$startPoint");
    kotlin.g.b.s.u(paramPointF2, "$endPoint");
    kotlin.g.b.s.u(paramPointF3, "$bezierStartPoint");
    kotlin.g.b.s.u(paramPointF4, "$controlPoint");
    kotlin.g.b.s.u(paramPointF5, "$bezierEndPoint");
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new e(paramBitmap, paramaz, paramString, paramInt1, paramInt2, paramPointF1, paramPointF2, paramPointF3, paramPointF4, paramPointF5));
    AppMethodBeat.o(355143);
  }
  
  private static final boolean a(az paramaz)
  {
    AppMethodBeat.i(355068);
    kotlin.g.b.s.u(paramaz, "this$0");
    if ((paramaz.DdM[0] == 0) || (paramaz.DdM[1] == 0))
    {
      AppMethodBeat.o(355068);
      return true;
    }
    if (paramaz.count > 0L)
    {
      paramaz.count -= 1L;
      if (!paramaz.DdC) {
        paramaz.y(paramaz.DdM[0], paramaz.DdM[1], true);
      }
      paramaz.DdO += 1;
      if (paramaz.DdO % paramaz.DdN == 0)
      {
        paramaz.hI(paramaz.DdM[0], paramaz.DdM[1]);
        paramaz.DdO = 0;
        paramaz.DdL.clear();
      }
      AppMethodBeat.o(355068);
      return true;
    }
    paramaz.DdD = false;
    AppMethodBeat.o(355068);
    return false;
  }
  
  private static final boolean a(az paramaz, Message paramMessage)
  {
    AppMethodBeat.i(355088);
    kotlin.g.b.s.u(paramaz, "this$0");
    kotlin.g.b.s.u(paramMessage, "it");
    int i = paramMessage.what;
    if (i == paramaz.Ddy) {
      paramaz.DdC = false;
    }
    for (;;)
    {
      AppMethodBeat.o(355088);
      return true;
      if (i == paramaz.Ddz)
      {
        if (!paramaz.DdD)
        {
          paramaz.DdD = true;
          paramaz.getTimeHandler().stopTimer();
          if (!paramaz.DdP) {
            paramaz.getTimeHandler().startTimer(paramaz.DdE);
          }
        }
        paramaz.eqH();
        paramMessage = paramMessage.obj;
        if (paramMessage == null)
        {
          paramaz = new NullPointerException("null cannot be cast to non-null type kotlin.Long");
          AppMethodBeat.o(355088);
          throw paramaz;
        }
        paramaz.count = (((Long)paramMessage).longValue() + paramaz.count);
      }
      else if (i == paramaz.DdB)
      {
        paramaz.CVa = false;
      }
    }
  }
  
  private static final void b(az paramaz)
  {
    AppMethodBeat.i(355074);
    kotlin.g.b.s.u(paramaz, "this$0");
    paramaz.eqI();
    AppMethodBeat.o(355074);
  }
  
  private static final void c(az paramaz)
  {
    AppMethodBeat.i(355077);
    kotlin.g.b.s.u(paramaz, "this$0");
    paramaz.eqI();
    AppMethodBeat.o(355077);
  }
  
  private final RelativeLayout eqG()
  {
    AppMethodBeat.i(354987);
    RelativeLayout localRelativeLayout = (RelativeLayout)this.Ddt.getValue();
    AppMethodBeat.o(354987);
    return localRelativeLayout;
  }
  
  private final void eqH()
  {
    AppMethodBeat.i(355001);
    if ((this.DdM[0] <= 0) || (this.DdM[1] <= 0) || (this.DdM[1] >= this.Ddr)) {
      eqI();
    }
    AppMethodBeat.o(355001);
  }
  
  private final Bitmap eqL()
  {
    AppMethodBeat.i(355027);
    Object localObject1;
    if (this.CVa) {
      if (Pa(100) < 25) {
        localObject1 = (Bitmap)this.Ddu.get(0);
      }
    }
    Object localObject3;
    for (;;)
    {
      kotlin.g.b.s.s(localObject1, "if(isInApplaudMode){\n   …iBitmaps.size)]\n        }");
      if ((this.Ddv.size() <= 0) || (this.Ddx <= 0)) {
        break label407;
      }
      synchronized (this.Ddv)
      {
        localIterator = ((Iterable)this.Ddw).iterator();
        if (localIterator.hasNext()) {
          break;
        }
        localObject1 = (Throwable)new UnsupportedOperationException("Empty collection can't be reduced.");
        AppMethodBeat.o(355027);
        throw ((Throwable)localObject1);
      }
      localObject3 = (Bitmap)this.Ddu.get(1);
      continue;
      localObject3 = (Bitmap)this.niF.get(Pa(this.niF.size()));
    }
    for (Object localObject4 = localIterator.next(); localIterator.hasNext(); localObject4 = Integer.valueOf(((Number)localObject4).intValue() + i)) {
      i = ((Number)localIterator.next()).intValue();
    }
    int j = ((Number)localObject4).intValue();
    if (j < 100) {}
    for (int i = 100;; i = j)
    {
      localObject4 = new ah.d();
      ((ah.d)localObject4).aixb = Pa(i);
      i = ((ah.d)localObject4).aixb;
      if (i <= j) {
        break;
      }
      AppMethodBeat.o(355027);
      return localObject3;
    }
    Iterator localIterator = ((Iterable)this.Ddw).iterator();
    i = 0;
    while (localIterator.hasNext())
    {
      Object localObject5 = localIterator.next();
      if (i < 0) {
        kotlin.a.p.kkW();
      }
      j = ((Number)localObject5).intValue();
      if (((ah.d)localObject4).aixb <= j)
      {
        localObject4 = (Bitmap)kotlin.a.p.ae((List)this.Ddv, i);
        if (localObject4 == null) {}
        for (;;)
        {
          AppMethodBeat.o(355027);
          return localObject3;
          localObject3 = localObject4;
        }
      }
      ((ah.d)localObject4).aixb -= j;
      i += 1;
    }
    localObject4 = ah.aiuX;
    label407:
    AppMethodBeat.o(355027);
    return localObject3;
  }
  
  private final void eqM()
  {
    AppMethodBeat.i(355049);
    getTimeHandler().stopTimer();
    this.DdQ = null;
    this.count = 0L;
    this.DdD = false;
    AppMethodBeat.o(355049);
  }
  
  private final MTimerHandler getTimeHandler()
  {
    AppMethodBeat.i(354993);
    MTimerHandler localMTimerHandler = (MTimerHandler)this.Bwl.getValue();
    AppMethodBeat.o(354993);
    return localMTimerHandler;
  }
  
  private final void hI(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(355018);
    Log.v(this.TAG, kotlin.g.b.s.X("checkEmitHighLightCheer waitingHlCheerList.size:", Integer.valueOf(this.DdL.size())));
    int i;
    Object localObject1;
    if (!((Collection)this.DdL).isEmpty())
    {
      i = 1;
      if (i == 0) {
        break label509;
      }
      localObject1 = this.DdL.remove(0);
      kotlin.g.b.s.s(localObject1, "waitingHlCheerList.removeAt(0)");
      localObject1 = (String)localObject1;
      if (((CharSequence)localObject1).length() <= 0) {
        break label251;
      }
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        if (Util.isEqual((String)localObject1, z.bAM()))
        {
          localPointF1 = new PointF(paramInt1, paramInt2);
          localPointF2 = new PointF(paramInt1, this.DdH);
          localObject2 = new ImageView(this.mJe.getContext());
          a.b.h((ImageView)localObject2, (String)localObject1);
          localObject1 = new ViewGroup.MarginLayoutParams(this.DdF, this.DdF);
          ((ViewGroup.MarginLayoutParams)localObject1).setMarginStart(paramInt1);
          ((ViewGroup.MarginLayoutParams)localObject1).topMargin = paramInt2;
          ((ImageView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
          eqG().addView((View)localObject2);
          ((ImageView)localObject2).setAlpha(0.0F);
          ((ImageView)localObject2).post(new az..ExternalSyntheticLambda6((ImageView)localObject2, this, localPointF1, localPointF2));
          AppMethodBeat.o(355018);
          return;
          i = 0;
          break;
          label251:
          i = 0;
          continue;
        }
        PointF localPointF1 = new PointF(paramInt1, paramInt2);
        PointF localPointF2 = new PointF(paramInt1, this.DdH);
        Object localObject2 = new PointF(paramInt1, paramInt2 - (paramInt2 - this.DdH) * 0.3F);
        PointF localPointF3 = new PointF(paramInt1 - Pa(this.DdG), this.DdH);
        float f1 = ((PointF)localObject2).x;
        i = Pa((int)(kotlin.k.k.bt(((PointF)localObject2).y - localPointF3.y, 1.0F) / 2.0F));
        float f2 = localPointF3.y;
        float f3 = ((PointF)localObject2).y;
        float f4 = localPointF3.y;
        float f5 = i;
        PointF localPointF4 = new PointF(kotlin.k.k.bu(f1, bf.bf(this.mJe.getContext()).x - this.DdF), f5 + (f2 + (f3 - f4) * 0.25F));
        Object localObject3 = com.tencent.mm.plugin.finder.loader.p.ExI;
        localObject3 = com.tencent.mm.plugin.finder.loader.p.eCp();
        com.tencent.mm.plugin.finder.loader.b localb = new com.tencent.mm.plugin.finder.loader.b((String)localObject1);
        com.tencent.mm.plugin.finder.loader.p localp = com.tencent.mm.plugin.finder.loader.p.ExI;
        ((com.tencent.mm.loader.d)localObject3).a(localb, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExM)).a(new az..ExternalSyntheticLambda2(this, (String)localObject1, paramInt1, paramInt2, localPointF1, localPointF2, (PointF)localObject2, localPointF4, localPointF3)).Td();
      }
    }
    label509:
    AppMethodBeat.o(355018);
  }
  
  private void y(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(355036);
    Log.d(this.TAG, "emitLikeConfetti containerMiddleX=" + paramInt1 + " containerMiddleY=" + paramInt2);
    Object localObject1 = new com.tencent.mm.particles.d(paramInt1, paramInt2);
    az..ExternalSyntheticLambda3 localExternalSyntheticLambda3 = new az..ExternalSyntheticLambda3(eqL(), paramBoolean);
    Object localObject2 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    localObject2 = this.mJe.getContext();
    kotlin.g.b.s.s(localObject2, "root.context");
    FrameLayout localFrameLayout = (FrameLayout)this.Dds.getValue();
    kotlin.g.b.s.s(localFrameLayout, "confettiRoot");
    this.niE = com.tencent.mm.plugin.finder.live.utils.a.a((Context)localObject2, localExternalSyntheticLambda3, (com.tencent.mm.particles.d)localObject1, (ViewGroup)localFrameLayout);
    localObject1 = this.niE;
    if (localObject1 != null) {
      ((com.tencent.mm.particles.c)localObject1).bSI();
    }
    AppMethodBeat.o(355036);
  }
  
  public final boolean eoI()
  {
    return true;
  }
  
  public final void eqI()
  {
    AppMethodBeat.i(355264);
    int[] arrayOfInt;
    Object localObject2;
    try
    {
      arrayOfInt = new int[2];
      arrayOfInt[0] = 0;
      arrayOfInt[1] = 0;
      Object localObject1 = this.mJe.getParent();
      if (localObject1 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type android.view.View");
        AppMethodBeat.o(355264);
        throw ((Throwable)localObject1);
      }
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace(this.TAG, (Throwable)localException, "FinderLiveLikeConfettiPlugin LIKE_FROM_OTHER", new Object[0]);
      localObject2 = new di();
      ((di)localObject2).nq("2");
      ((di)localObject2).izr = 10004L;
      ((di)localObject2).bMH();
    }
    for (;;)
    {
      AppMethodBeat.o(355264);
      return;
      localObject2 = ((View)localObject2).findViewById(p.e.BMA);
      if ((localObject2 == null) || (((e)business(e.class)).DUe))
      {
        localObject2 = this.mJe.getParent();
        if (localObject2 == null)
        {
          localObject2 = new NullPointerException("null cannot be cast to non-null type android.view.View");
          AppMethodBeat.o(355264);
          throw ((Throwable)localObject2);
        }
        localObject2 = ((View)localObject2).findViewById(p.e.BFn);
      }
      while (localObject2 != null)
      {
        ((View)localObject2).getLocationOnScreen(arrayOfInt);
        int i = arrayOfInt[0];
        float f = ((View)localObject2).getWidth();
        int j = (int)(((View)localObject2).getScaleX() * f / 2.0F);
        localObject2 = l.b.mYf;
        int k = l.b.bhn() / 2;
        int m = arrayOfInt[1];
        int n = bd.fromDPToPix(this.mJe.getContext(), 16);
        this.DdM[0] = (j + i - k);
        this.DdM[1] = (m - n);
        AppMethodBeat.o(355264);
        return;
      }
    }
  }
  
  public final void eqJ()
  {
    AppMethodBeat.i(355284);
    Bitmap localBitmap;
    Object localObject1;
    int i;
    Object localObject2;
    if (this.niF.size() == 0)
    {
      localBitmap = BitmapFactory.decodeResource(this.mJe.getContext().getResources(), p.d.live_like_icon1);
      localObject1 = l.b.mYf;
      i = l.b.bhn();
      localObject1 = l.b.mYf;
      localBitmap = Bitmap.createScaledBitmap(localBitmap, i, l.b.bhn(), true);
      localObject1 = BitmapFactory.decodeResource(this.mJe.getContext().getResources(), p.d.live_like_icon2);
      localObject2 = l.b.mYf;
      i = l.b.bhn();
      localObject2 = l.b.mYf;
      localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject1, i, l.b.bhn(), true);
      localObject2 = BitmapFactory.decodeResource(this.mJe.getContext().getResources(), p.d.live_like_icon3);
      Object localObject3 = l.b.mYf;
      i = l.b.bhn();
      localObject3 = l.b.mYf;
      localObject2 = Bitmap.createScaledBitmap((Bitmap)localObject2, i, l.b.bhn(), true);
      localObject3 = BitmapFactory.decodeResource(this.mJe.getContext().getResources(), p.d.live_like_icon4);
      Object localObject4 = l.b.mYf;
      i = l.b.bhn();
      localObject4 = l.b.mYf;
      localObject3 = Bitmap.createScaledBitmap((Bitmap)localObject3, i, l.b.bhn(), true);
      localObject4 = BitmapFactory.decodeResource(this.mJe.getContext().getResources(), p.d.live_like_icon5);
      Object localObject5 = l.b.mYf;
      i = l.b.bhn();
      localObject5 = l.b.mYf;
      localObject4 = Bitmap.createScaledBitmap((Bitmap)localObject4, i, l.b.bhn(), true);
      localObject5 = BitmapFactory.decodeResource(this.mJe.getContext().getResources(), p.d.live_like_icon6);
      l.b localb = l.b.mYf;
      i = l.b.bhn();
      localb = l.b.mYf;
      localObject5 = Bitmap.createScaledBitmap((Bitmap)localObject5, i, l.b.bhn(), true);
      this.niF.add(localBitmap);
      this.niF.add(localObject1);
      this.niF.add(localObject2);
      this.niF.add(localObject3);
      this.niF.add(localObject4);
      this.niF.add(localObject5);
    }
    if (this.Ddu.size() == 0)
    {
      localBitmap = BitmapFactory.decodeResource(this.mJe.getContext().getResources(), p.d.live_like_icon5);
      localObject1 = l.b.mYf;
      i = l.b.bhn();
      localObject1 = l.b.mYf;
      localBitmap = Bitmap.createScaledBitmap(localBitmap, i, l.b.bhn(), true);
      localObject1 = BitmapFactory.decodeResource(this.mJe.getContext().getResources(), p.d.live_like_icon7);
      localObject2 = l.b.mYf;
      i = l.b.bhn();
      localObject2 = l.b.mYf;
      localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject1, i, l.b.bhn(), true);
      this.Ddu.add(localBitmap);
      this.Ddu.add(localObject1);
    }
    AppMethodBeat.o(355284);
  }
  
  public final void eqK()
  {
    AppMethodBeat.i(355304);
    if (((e)business(e.class)).EdA.tXv)
    {
      if (((e)business(e.class)).EdA.lTH == 0)
      {
        this.Ddv.clear();
        this.Ddw.clear();
        this.Ddx = 0;
        AppMethodBeat.o(355304);
        return;
      }
      gA(((e)business(e.class)).EdA.EeP);
    }
    AppMethodBeat.o(355304);
  }
  
  public final void gA(List<? extends acl> paramList)
  {
    AppMethodBeat.i(355296);
    kotlin.g.b.s.u(paramList, "cheerIconInfos");
    this.Ddv = new ArrayList();
    this.Ddw = new ArrayList();
    this.Ddx = 0;
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      Object localObject2 = (acl)paramList.next();
      this.Ddx += ((acl)localObject2).ZkN;
      Object localObject1 = ((acl)localObject2).icon_url;
      int i = ((acl)localObject2).ZkN;
      localObject2 = new dji();
      ((dji)localObject2).mediaId = MD5Util.getMD5String((String)localObject1);
      ((dji)localObject2).url = ((String)localObject1);
      ((dji)localObject2).thumbUrl = ((String)localObject1);
      localObject1 = new n((dji)localObject2, v.FKZ, null, null, 12);
      localObject2 = com.tencent.mm.plugin.finder.loader.p.ExI;
      localObject1 = com.tencent.mm.plugin.finder.loader.p.eCl().dk(localObject1);
      localObject2 = com.tencent.mm.plugin.finder.loader.p.ExI;
      ((com.tencent.mm.loader.a.b)localObject1).a(com.tencent.mm.plugin.finder.loader.p.a(p.a.ExJ)).a(new az..ExternalSyntheticLambda1(this, i)).blg();
    }
    AppMethodBeat.o(355296);
  }
  
  public final void gB(final List<bdm> paramList)
  {
    AppMethodBeat.i(355311);
    kotlin.g.b.s.u(paramList, "hlCheerList");
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new h(this, paramList));
    AppMethodBeat.o(355311);
  }
  
  public final void mount()
  {
    AppMethodBeat.i(355318);
    super.mount();
    this.DdP = false;
    AppMethodBeat.o(355318);
  }
  
  public final void qU(boolean paramBoolean)
  {
    AppMethodBeat.i(355253);
    super.qU(paramBoolean);
    if (!paramBoolean) {
      this.mJe.post(new az..ExternalSyntheticLambda7(this));
    }
    AppMethodBeat.o(355253);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    int i = 100;
    AppMethodBeat.i(355349);
    kotlin.g.b.s.u(paramc, "status");
    super.statusChange(paramc, paramBundle);
    int j;
    label259:
    switch (b.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    default: 
      AppMethodBeat.o(355349);
      return;
    case 1: 
      if (paramBundle == null)
      {
        j = 100;
        if (paramBundle != null) {
          break label201;
        }
        y(j, i, false);
        this.DdC = true;
        if (!this.CVa) {
          break label212;
        }
        paramc = com.tencent.mm.plugin.finder.live.report.k.Doi;
        paramc = new JSONObject();
        paramc.put("trigger", 1);
        com.tencent.mm.plugin.finder.live.report.k.a(q.bu.DCj, null, 0L, paramc.toString(), null, null, 52);
      }
      for (com.tencent.mm.plugin.finder.live.report.k.Doq += 1;; com.tencent.mm.plugin.finder.live.report.k.Doq += 1)
      {
        this.DdR.removeMessages(this.Ddy);
        this.DdR.sendEmptyMessageDelayed(this.Ddy, 1000L);
        AppMethodBeat.o(355349);
        return;
        j = paramBundle.getInt("PARAM_LIVE_LIKE_CONFETTI_X");
        break;
        i = paramBundle.getInt("PARAM_LIVE_LIKE_CONFETTI_Y");
        break label91;
        paramc = com.tencent.mm.plugin.finder.live.report.k.Doi;
        com.tencent.mm.plugin.finder.live.report.k.a(q.bu.DCj, "1", 0L, null, null, null, 60);
      }
    case 2: 
      label91:
      if ((paramBundle != null) && (!paramBundle.getBoolean("PARAM_FINDER_LIVE_LIKE_ENABLE", true)))
      {
        i = 1;
        if (i != 0) {
          break label290;
        }
        ((e)business(e.class)).Ecy = true;
      }
      label201:
      label212:
      break;
    }
    for (;;)
    {
      tO(0);
      break;
      i = 0;
      break label259;
      label290:
      tO(8);
      AppMethodBeat.o(355349);
      return;
      long l;
      if ((((e)business(e.class)).Ecx) && (!com.tencent.mm.ae.d.ee(((e)business(e.class)).Ecp, 512)))
      {
        tO(0);
        l = ((e)getBuContext().business(e.class)).EcE;
        if ((l <= 0L) || (this.DdC)) {
          AppMethodBeat.o(355349);
        }
      }
      else
      {
        tO(8);
        AppMethodBeat.o(355349);
        return;
      }
      paramc = this.DdR.obtainMessage(this.Ddz, Long.valueOf(l));
      this.DdR.sendMessageDelayed(paramc, 300L);
      AppMethodBeat.o(355349);
      return;
      this.DdR.removeMessages(this.Ddz);
      this.DdR.removeMessages(this.Ddy);
      eqM();
      Log.i(this.TAG, "CLOSE_LIVE " + this + " ,postLikeWork:" + this.DdD);
      AppMethodBeat.o(355349);
      return;
      if (paramBundle == null)
      {
        paramc = "";
        if (paramBundle != null) {
          break label569;
        }
        j = 100;
        label520:
        if (paramBundle != null) {
          break label581;
        }
      }
      for (;;)
      {
        this.DdL.add(0, paramc);
        hI(j, i);
        AppMethodBeat.o(355349);
        return;
        paramc = paramBundle.getString("PARAM_FINDER_LIVE_HEAD_URL");
        if (paramc == null)
        {
          paramc = "";
          break;
        }
        break;
        label569:
        j = paramBundle.getInt("PARAM_LIVE_LIKE_CONFETTI_X");
        break label520;
        label581:
        i = paramBundle.getInt("PARAM_LIVE_LIKE_CONFETTI_Y");
      }
      this.CVa = true;
      this.DdR.removeMessages(this.DdB);
      this.DdR.sendEmptyMessageDelayed(this.DdB, 10000L);
      AppMethodBeat.o(355349);
      return;
      if ((paramBundle != null) && (paramBundle.getBoolean("isShow") == true)) {}
      for (i = 1; i != 0; i = 0)
      {
        tO(8);
        AppMethodBeat.o(355349);
        return;
      }
    }
  }
  
  public final void tO(int paramInt)
  {
    AppMethodBeat.i(371453);
    if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.s)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.s.class)).kLm())
    {
      super.tO(8);
      AppMethodBeat.o(371453);
      return;
    }
    super.tO(paramInt);
    AppMethodBeat.o(371453);
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(355330);
    super.unMount();
    this.Ddv.clear();
    this.Ddw.clear();
    this.Ddx = 0;
    this.DdP = true;
    eqM();
    Log.i(this.TAG, "unMount " + this + " ,postLikeWork:" + this.DdD);
    this.DdR.removeMessages(this.Ddz);
    this.DdR.removeMessages(this.Ddy);
    AppMethodBeat.o(355330);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/FrameLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<FrameLayout>
  {
    c(ViewGroup paramViewGroup)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<RelativeLayout>
  {
    d(ViewGroup paramViewGroup)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<ah>
  {
    e(Bitmap paramBitmap, az paramaz, String paramString, int paramInt1, int paramInt2, PointF paramPointF1, PointF paramPointF2, PointF paramPointF3, PointF paramPointF4, PointF paramPointF5)
    {
      super();
    }
    
    private static final void a(final ImageView paramImageView, az paramaz, PointF paramPointF1, PointF paramPointF2, PointF paramPointF3, PointF paramPointF4, PointF paramPointF5)
    {
      AppMethodBeat.i(355826);
      kotlin.g.b.s.u(paramImageView, "$hightLightLikeImage");
      kotlin.g.b.s.u(paramaz, "this$0");
      kotlin.g.b.s.u(paramPointF1, "$startPoint");
      kotlin.g.b.s.u(paramPointF2, "$endPoint");
      kotlin.g.b.s.u(paramPointF3, "$bezierStartPoint");
      kotlin.g.b.s.u(paramPointF4, "$controlPoint");
      kotlin.g.b.s.u(paramPointF5, "$bezierEndPoint");
      paramImageView.animate().setDuration(az.i(paramaz)).setInterpolator((TimeInterpolator)new az.a(new PointF(0.18F, 0.3F))).setUpdateListener(new az.e..ExternalSyntheticLambda0(paramImageView, paramaz, paramPointF1, paramPointF2, paramPointF3, paramPointF4, paramPointF5)).setListener((Animator.AnimatorListener)new a(paramaz, paramImageView)).start();
      AppMethodBeat.o(355826);
    }
    
    private static final void a(ImageView paramImageView, az paramaz, PointF paramPointF1, PointF paramPointF2, PointF paramPointF3, PointF paramPointF4, PointF paramPointF5, ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(355817);
      kotlin.g.b.s.u(paramImageView, "$hightLightLikeImage");
      kotlin.g.b.s.u(paramaz, "this$0");
      kotlin.g.b.s.u(paramPointF1, "$startPoint");
      kotlin.g.b.s.u(paramPointF2, "$endPoint");
      kotlin.g.b.s.u(paramPointF3, "$bezierStartPoint");
      kotlin.g.b.s.u(paramPointF4, "$controlPoint");
      kotlin.g.b.s.u(paramPointF5, "$bezierEndPoint");
      if ((paramValueAnimator.getAnimatedValue() instanceof Float))
      {
        paramaz = paramValueAnimator.getAnimatedValue();
        if (paramaz == null)
        {
          paramImageView = new NullPointerException("null cannot be cast to non-null type kotlin.Float");
          AppMethodBeat.o(355817);
          throw paramImageView;
        }
        float f1 = ((Float)paramaz).floatValue();
        if (f1 <= 0.3F)
        {
          paramImageView.setAlpha(3.333333F * f1);
          paramImageView.setScaleX(3.333333F * f1);
          paramImageView.setScaleY(3.333333F * f1);
          if (f1 >= 0.3F) {
            break label254;
          }
          paramaz = az.b(f1, paramPointF1, paramPointF2);
        }
        for (;;)
        {
          paramPointF1 = paramImageView.getLayoutParams();
          if (paramPointF1 != null) {
            break label396;
          }
          paramImageView = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
          AppMethodBeat.o(355817);
          throw paramImageView;
          if (f1 > 0.7F)
          {
            paramImageView.setAlpha((1.0F - f1) * 3.333333F);
            paramImageView.setScaleX(kotlin.k.k.bu(1.0F - (0.3F - (1.0F - f1)) * 0.6666666F, 1.0F));
            paramImageView.setScaleY(kotlin.k.k.bu(1.0F - (0.3F - (1.0F - f1)) * 0.6666666F, 1.0F));
            break;
          }
          paramImageView.setAlpha(1.0F);
          paramImageView.setScaleX(1.0F);
          paramImageView.setScaleY(1.0F);
          break;
          label254:
          f1 = (f1 - 0.3F) / 0.7F;
          paramaz = f.DIo;
          kotlin.g.b.s.u(paramPointF3, "p0");
          kotlin.g.b.s.u(paramPointF4, "p1");
          kotlin.g.b.s.u(paramPointF5, "p2");
          paramaz = new PointF();
          float f2 = 1.0F - f1;
          paramaz.x = (f2 * f2 * paramPointF3.x + 2.0F * f1 * f2 * paramPointF4.x + f1 * f1 * paramPointF5.x);
          float f3 = paramPointF3.y;
          float f4 = paramPointF4.y;
          paramaz.y = (f1 * f1 * paramPointF5.y + (f2 * (2.0F * f1) * f4 + f2 * f2 * f3));
        }
        label396:
        ((ViewGroup.MarginLayoutParams)paramPointF1).setMarginStart((int)paramaz.x);
        paramPointF1 = paramImageView.getLayoutParams();
        if (paramPointF1 == null)
        {
          paramImageView = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
          AppMethodBeat.o(355817);
          throw paramImageView;
        }
        ((ViewGroup.MarginLayoutParams)paramPointF1).topMargin = ((int)paramaz.y);
        paramImageView.requestLayout();
      }
      AppMethodBeat.o(355817);
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveLikeConfettiPlugin$loadOthersAvatar$1$1$2$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      extends AnimatorListenerAdapter
    {
      a(az paramaz, ImageView paramImageView) {}
      
      public final void onAnimationCancel(Animator paramAnimator)
      {
        AppMethodBeat.i(353770);
        az.f(this.DdU).removeView((View)paramImageView);
        AppMethodBeat.o(353770);
      }
      
      public final void onAnimationEnd(Animator paramAnimator)
      {
        AppMethodBeat.i(353765);
        az.f(this.DdU).removeView((View)paramImageView);
        AppMethodBeat.o(353765);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveLikeConfettiPlugin$loadSelfAvatar$2$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    extends AnimatorListenerAdapter
  {
    f(az paramaz, ImageView paramImageView) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(355860);
      az.f(this.DdU).removeView((View)paramImageView);
      AppMethodBeat.o(355860);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(355853);
      az.f(this.DdU).removeView((View)paramImageView);
      AppMethodBeat.o(355853);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<MTimerHandler>
  {
    g(az paramaz)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<ah>
  {
    h(az paramaz, List<bdm> paramList)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.az
 * JD-Core Version:    0.7.0.1
 */