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
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.b.o.b;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.loader.f.e;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.loader.m.a;
import com.tencent.mm.plugin.finder.loader.o;
import com.tencent.mm.plugin.finder.report.live.s.ar;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.aut;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandler.Callback;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.au;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.j.c.b;
import kotlin.k.j;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveLikeConfettiPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "CONFETTI_INTERVAL", "", "HL_CHEER_MAX_COUNT", "", "HL_LIKE_ANIMATION_DURATION", "HL_LIKE_DESTINATION_Y", "HL_LIKE_END_OFFSET_X", "HL_LIKE_SIZE", "HL_OFFSET_X_MAX", "LIKE_FROM_OTHER", "LIKE_INTERNAL", "LIKE_MANNUAL", "TAG", "", "confettiBitmaps", "Ljava/util/ArrayList;", "Landroid/graphics/Bitmap;", "Lkotlin/collections/ArrayList;", "confettiManager", "Lcom/tencent/mm/particles/ConfettiManager;", "confettiRoot", "Landroid/widget/FrameLayout;", "kotlin.jvm.PlatformType", "count", "hadler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "highLightLikeRoot", "Landroid/widget/RelativeLayout;", "likeXyArray", "", "liking", "", "postLikeWork", "timeHandler", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "getTimeHandler", "()Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "timeHandler$delegate", "Lkotlin/Lazy;", "waitingHlCheerList", "calculateNormalPoint", "Landroid/graphics/PointF;", "t", "", "start", "end", "canClearScreen", "checkEmitHighLightCheer", "", "x", "y", "emitHightLightLike", "emitLikeConfetti", "needHalfAlpha", "emitLikeConfettiMsg", "genHighLightLikeControlPoint", "startPoint", "endPoint", "initLikeXyArray", "loadOthersAvatar", "headUrl", "loadSelfAvatar", "username", "nextInt", "next", "setupConfig", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "stopLikeTimer", "tryEmitHightLightLikeByOthers", "hlCheerList", "", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "unMount", "LineInterpolator", "plugin-finder_release"})
public final class aj
  extends d
{
  final String TAG;
  int count;
  private final com.tencent.mm.live.c.b hOp;
  private final FrameLayout hRf;
  private com.tencent.mm.particles.c hRg;
  private final ArrayList<Bitmap> hRh;
  final RelativeLayout ura;
  final int urb;
  final int urc;
  private final int urd;
  volatile boolean ure;
  volatile boolean urf;
  final long urg;
  final int urh;
  private final int urj;
  private final int urk;
  private final int urm;
  final long urn;
  private final int uro;
  final ArrayList<String> urp;
  final int[] urq;
  private final kotlin.f urr;
  private MMHandler urs;
  
  public aj(ViewGroup paramViewGroup, com.tencent.mm.live.c.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(246829);
    this.hOp = paramb;
    this.TAG = "Finder.FinderLiveLikeConfettiPlugin";
    this.hRf = ((FrameLayout)paramViewGroup.findViewById(2131303419));
    this.ura = ((RelativeLayout)paramViewGroup.findViewById(2131303421));
    this.hRh = new ArrayList();
    this.urb = 1;
    this.urc = 2;
    this.urd = 3;
    this.urg = 200L;
    this.urh = at.fromDPToPix(paramViewGroup.getContext(), 48);
    this.urj = at.fromDPToPix(paramViewGroup.getContext(), 48);
    this.urk = (au.az(paramViewGroup.getContext()).y / 2 - at.fromDPToPix(paramViewGroup.getContext(), 24));
    this.urm = at.fromDPToPix(paramViewGroup.getContext(), 60);
    this.urn = 2500L;
    this.uro = 3;
    this.urp = new ArrayList();
    this.urq = new int[] { 0, 0 };
    this.urr = kotlin.g.ah((kotlin.g.a.a)new f(this));
    paramViewGroup.post((Runnable)new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(246802);
        aj.a(this.urt);
        AppMethodBeat.o(246802);
      }
    });
    this.urs = new MMHandler(Looper.getMainLooper(), (MMHandler.Callback)new c(this));
    AppMethodBeat.o(246829);
  }
  
  private final void dhs()
  {
    AppMethodBeat.i(246828);
    dhr().stopTimer();
    this.count = 0;
    this.urf = false;
    AppMethodBeat.o(246828);
  }
  
  private final int nextInt(int paramInt)
  {
    AppMethodBeat.i(246825);
    if (paramInt <= 0)
    {
      Log.i(this.TAG, "[nextInt] param:" + paramInt + " is not positive,stack:");
      Log.printInfoStack(this.TAG, "nextInt", new Object[0]);
      AppMethodBeat.o(246825);
      return 0;
    }
    paramInt = kotlin.j.c.SYP.nextInt(0, paramInt);
    AppMethodBeat.o(246825);
    return paramInt;
  }
  
  public final void a(LiveConfig paramLiveConfig)
  {
    AppMethodBeat.i(246822);
    p.h(paramLiveConfig, "config");
    paramLiveConfig = this.hwr.getContext();
    p.g(paramLiveConfig, "root.context");
    paramLiveConfig = BitmapFactory.decodeResource(paramLiveConfig.getResources(), 2131233355);
    Object localObject1 = o.b.hGo;
    int i = o.b.aFl();
    localObject1 = o.b.hGo;
    paramLiveConfig = Bitmap.createScaledBitmap(paramLiveConfig, i, o.b.aFl(), true);
    localObject1 = this.hwr.getContext();
    p.g(localObject1, "root.context");
    localObject1 = BitmapFactory.decodeResource(((Context)localObject1).getResources(), 2131233356);
    Object localObject2 = o.b.hGo;
    i = o.b.aFl();
    localObject2 = o.b.hGo;
    localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject1, i, o.b.aFl(), true);
    localObject2 = this.hwr.getContext();
    p.g(localObject2, "root.context");
    localObject2 = BitmapFactory.decodeResource(((Context)localObject2).getResources(), 2131233357);
    Object localObject3 = o.b.hGo;
    i = o.b.aFl();
    localObject3 = o.b.hGo;
    localObject2 = Bitmap.createScaledBitmap((Bitmap)localObject2, i, o.b.aFl(), true);
    localObject3 = this.hwr.getContext();
    p.g(localObject3, "root.context");
    localObject3 = BitmapFactory.decodeResource(((Context)localObject3).getResources(), 2131233358);
    Object localObject4 = o.b.hGo;
    i = o.b.aFl();
    localObject4 = o.b.hGo;
    localObject3 = Bitmap.createScaledBitmap((Bitmap)localObject3, i, o.b.aFl(), true);
    localObject4 = this.hwr.getContext();
    p.g(localObject4, "root.context");
    localObject4 = BitmapFactory.decodeResource(((Context)localObject4).getResources(), 2131233359);
    Object localObject5 = o.b.hGo;
    i = o.b.aFl();
    localObject5 = o.b.hGo;
    localObject4 = Bitmap.createScaledBitmap((Bitmap)localObject4, i, o.b.aFl(), true);
    localObject5 = this.hwr.getContext();
    p.g(localObject5, "root.context");
    localObject5 = BitmapFactory.decodeResource(((Context)localObject5).getResources(), 2131233360);
    o.b localb = o.b.hGo;
    i = o.b.aFl();
    localb = o.b.hGo;
    localObject5 = Bitmap.createScaledBitmap((Bitmap)localObject5, i, o.b.aFl(), true);
    this.hRh.add(paramLiveConfig);
    this.hRh.add(localObject1);
    this.hRh.add(localObject2);
    this.hRh.add(localObject3);
    this.hRh.add(localObject4);
    this.hRh.add(localObject5);
    AppMethodBeat.o(246822);
  }
  
  public final boolean dgK()
  {
    return true;
  }
  
  final MTimerHandler dhr()
  {
    AppMethodBeat.i(246820);
    MTimerHandler localMTimerHandler = (MTimerHandler)this.urr.getValue();
    AppMethodBeat.o(246820);
    return localMTimerHandler;
  }
  
  public final void ed(final List<aut> paramList)
  {
    AppMethodBeat.i(246824);
    p.h(paramList, "hlCheerList");
    com.tencent.mm.ac.d.h((kotlin.g.a.a)new g(this, paramList));
    AppMethodBeat.o(246824);
  }
  
  final void ga(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(246821);
    Log.v(this.TAG, "checkEmitHighLightCheer waitingHlCheerList.size:" + this.urp.size());
    int i;
    Object localObject1;
    if (!((Collection)this.urp).isEmpty())
    {
      i = 1;
      if (i == 0) {
        break label522;
      }
      localObject1 = this.urp.remove(0);
      p.g(localObject1, "waitingHlCheerList.removeAt(0)");
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
        if (Util.isEqual((String)localObject1, z.aTY()))
        {
          localPointF1 = new PointF(paramInt1, paramInt2);
          localPointF2 = new PointF(paramInt1, this.urk);
          localObject2 = new ImageView(this.hwr.getContext());
          a.b.d((ImageView)localObject2, (String)localObject1);
          localObject1 = new ViewGroup.MarginLayoutParams(this.urh, this.urh);
          ((ViewGroup.MarginLayoutParams)localObject1).setMarginStart(paramInt1);
          ((ViewGroup.MarginLayoutParams)localObject1).topMargin = paramInt2;
          ((ImageView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
          this.ura.addView((View)localObject2);
          ((ImageView)localObject2).setAlpha(0.0F);
          ((ImageView)localObject2).post((Runnable)new e(this, (ImageView)localObject2, localPointF1, localPointF2));
          AppMethodBeat.o(246821);
          return;
          i = 0;
          break;
          label261:
          i = 0;
          continue;
        }
        final PointF localPointF1 = new PointF(paramInt1, paramInt2);
        final PointF localPointF2 = new PointF(paramInt1, this.urk);
        Object localObject2 = new PointF(paramInt1, paramInt2 - (paramInt2 - this.urk) * 0.3F);
        final PointF localPointF3 = new PointF(paramInt1 - nextInt(this.urj), this.urk);
        float f1 = ((PointF)localObject2).x;
        i = nextInt((int)(j.aI(((PointF)localObject2).y - localPointF3.y, 1.0F) / 2.0F));
        float f2 = localPointF3.y;
        float f3 = ((PointF)localObject2).y;
        float f4 = localPointF3.y;
        float f5 = i;
        final PointF localPointF4 = new PointF(j.aJ(f1, au.az(this.hwr.getContext()).x - this.urh), f5 + (f2 + (f3 - f4) * 0.25F));
        Object localObject3 = com.tencent.mm.plugin.finder.loader.m.uJa;
        localObject3 = com.tencent.mm.plugin.finder.loader.m.dka();
        com.tencent.mm.plugin.finder.loader.a locala = new com.tencent.mm.plugin.finder.loader.a((String)localObject1);
        com.tencent.mm.plugin.finder.loader.m localm = com.tencent.mm.plugin.finder.loader.m.uJa;
        ((com.tencent.mm.loader.d)localObject3).a(locala, com.tencent.mm.plugin.finder.loader.m.a(m.a.uJe)).a((e)new d(this, paramInt1, paramInt2, localPointF1, localPointF2, (PointF)localObject2, localPointF4, localPointF3, (String)localObject1)).vC();
      }
    }
    label522:
    AppMethodBeat.o(246821);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    int i = 100;
    AppMethodBeat.i(246827);
    p.h(paramc, "status");
    super.statusChange(paramc, paramBundle);
    switch (ak.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    default: 
      AppMethodBeat.o(246827);
      return;
    case 1: 
      if (paramBundle != null) {}
      for (j = paramBundle.getInt("PARAM_LIVE_LIKE_CONFETTI_X");; j = 100)
      {
        if (paramBundle != null) {
          i = paramBundle.getInt("PARAM_LIVE_LIKE_CONFETTI_Y");
        }
        v(j, i, false);
        this.ure = true;
        paramc = com.tencent.mm.plugin.finder.report.live.m.vli;
        com.tencent.mm.plugin.finder.report.live.m.a(s.ar.vrk, "1");
        com.tencent.mm.plugin.finder.report.live.m.vkn += 1;
        this.urs.removeMessages(this.urb);
        this.urs.sendEmptyMessageDelayed(this.urb, 1000L);
        AppMethodBeat.o(246827);
        return;
      }
    case 2: 
      i = getLiveData().uDP;
      if ((i <= 0) || (this.ure))
      {
        AppMethodBeat.o(246827);
        return;
      }
      paramc = this.urs.obtainMessage(this.urc, Integer.valueOf(i));
      this.urs.sendMessageDelayed(paramc, 300L);
      AppMethodBeat.o(246827);
      return;
    case 3: 
      this.urs.removeMessages(this.urc);
      this.urs.removeMessages(this.urb);
      dhs();
      Log.i(this.TAG, "CLOSE_LIVE " + this + " ,postLikeWork:" + this.urf);
      AppMethodBeat.o(246827);
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
    p.g(paramc, "param?.getString(ILiveSt…NDER_LIVE_HEAD_URL) ?: \"\"");
    if (paramBundle != null) {}
    for (int j = paramBundle.getInt("PARAM_LIVE_LIKE_CONFETTI_X");; j = 100)
    {
      if (paramBundle != null) {
        i = paramBundle.getInt("PARAM_LIVE_LIKE_CONFETTI_Y");
      }
      this.urp.add(0, paramc);
      ga(j, i);
      break;
    }
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(246826);
    super.unMount();
    dhs();
    Log.i(this.TAG, "unMount " + this + " ,postLikeWork:" + this.urf);
    this.urs.removeMessages(this.urc);
    this.urs.removeMessages(this.urb);
    AppMethodBeat.o(246826);
  }
  
  public final void v(int paramInt1, int paramInt2, final boolean paramBoolean)
  {
    AppMethodBeat.i(246823);
    Log.d(this.TAG, "emitLikeConfetti containerMiddleX=" + paramInt1 + " containerMiddleY=" + paramInt2);
    com.tencent.mm.particles.d locald = new com.tencent.mm.particles.d(paramInt1, paramInt2);
    Object localObject = this.hRh.get(nextInt(this.hRh.size()));
    p.g(localObject, "confettiBitmaps[nextInt(confettiBitmaps.size)]");
    localObject = (com.tencent.mm.particles.b)new b((Bitmap)localObject, paramBoolean);
    this.hRg = new com.tencent.mm.particles.c(this.hwr.getContext(), (com.tencent.mm.particles.b)localObject, locald, (ViewGroup)this.hRf).ax(1.0F).bkF().H(-360.0F, 50.0F).AQ(1000L).bkD().bkJ();
    AppMethodBeat.o(246823);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveLikeConfettiPlugin$LineInterpolator;", "Landroid/view/animation/Interpolator;", "divide", "Landroid/graphics/PointF;", "(Landroid/graphics/PointF;)V", "divideInput", "", "divideOutput", "getInterpolation", "input", "plugin-finder_release"})
  public static final class a
    implements Interpolator
  {
    private final float uru;
    private final float urv;
    
    public a(PointF paramPointF)
    {
      AppMethodBeat.i(246803);
      this.uru = paramPointF.x;
      this.urv = paramPointF.y;
      AppMethodBeat.o(246803);
    }
    
    public final float getInterpolation(float paramFloat)
    {
      if (paramFloat < this.uru) {
        return paramFloat / this.uru * this.urv;
      }
      return this.urv + (paramFloat - this.uru) / (1.0F - this.uru) * (1.0F - this.urv);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/live/view/confetti/LiveLikeConfetti;", "it", "Ljava/util/Random;", "kotlin.jvm.PlatformType", "generateConfetti"})
  static final class b
    implements com.tencent.mm.particles.b
  {
    b(Bitmap paramBitmap, boolean paramBoolean) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"})
  static final class c
    implements MMHandler.Callback
  {
    c(aj paramaj) {}
    
    public final boolean handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(246806);
      int i = paramMessage.what;
      if (i == this.urt.urb) {
        this.urt.ure = false;
      }
      for (;;)
      {
        AppMethodBeat.o(246806);
        return true;
        if (i == this.urt.urc)
        {
          aj localaj = this.urt;
          if (!localaj.urf)
          {
            localaj.urf = true;
            localaj.dhr().stopTimer();
            localaj.dhr().startTimer(localaj.urg);
          }
          if ((this.urt.urq[0] <= 0) || (this.urt.urq[1] <= 0)) {
            aj.a(this.urt);
          }
          paramMessage = paramMessage.obj;
          if (paramMessage == null)
          {
            paramMessage = new t("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(246806);
            throw paramMessage;
          }
          i = ((Integer)paramMessage).intValue();
          paramMessage = this.urt;
          paramMessage.count = (i + paramMessage.count);
        }
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/loader/model/data/DataItem;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "resource", "Landroid/graphics/Bitmap;", "onImageLoadComplete"})
  static final class d<T, R>
    implements e<o, Bitmap>
  {
    d(aj paramaj, int paramInt1, int paramInt2, PointF paramPointF1, PointF paramPointF2, PointF paramPointF3, PointF paramPointF4, PointF paramPointF5, String paramString) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(aj paramaj, ImageView paramImageView, PointF paramPointF1, PointF paramPointF2) {}
    
    public final void run()
    {
      AppMethodBeat.i(246816);
      this.urG.animate().setDuration(this.urt.urn).setInterpolator((TimeInterpolator)new aj.a(new PointF(0.18F, 0.3F))).setUpdateListener((ValueAnimator.AnimatorUpdateListener)new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(246813);
          p.g(paramAnonymousValueAnimator, "it");
          if ((paramAnonymousValueAnimator.getAnimatedValue() instanceof Float))
          {
            paramAnonymousValueAnimator = paramAnonymousValueAnimator.getAnimatedValue();
            if (paramAnonymousValueAnimator == null)
            {
              paramAnonymousValueAnimator = new t("null cannot be cast to non-null type kotlin.Float");
              AppMethodBeat.o(246813);
              throw paramAnonymousValueAnimator;
            }
            float f = ((Float)paramAnonymousValueAnimator).floatValue();
            if (f <= 0.3F)
            {
              this.urI.urG.setAlpha(3.333333F * f);
              this.urI.urG.setScaleX(3.333333F * f);
              this.urI.urG.setScaleY(3.333333F * f);
            }
            for (;;)
            {
              paramAnonymousValueAnimator = aj.a(f, this.urI.ury, this.urI.urz);
              localLayoutParams = this.urI.urG.getLayoutParams();
              if (localLayoutParams != null) {
                break;
              }
              paramAnonymousValueAnimator = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
              AppMethodBeat.o(246813);
              throw paramAnonymousValueAnimator;
              if (f > 0.7F)
              {
                this.urI.urG.setAlpha((1.0F - f) * 3.333333F);
                this.urI.urG.setScaleX(j.aJ(1.0F - (0.3F - (1.0F - f)) * 0.6666666F, 1.0F));
                this.urI.urG.setScaleY(j.aJ(1.0F - (0.3F - (1.0F - f)) * 0.6666666F, 1.0F));
              }
              else
              {
                this.urI.urG.setAlpha(1.0F);
                this.urI.urG.setScaleX(1.0F);
                this.urI.urG.setScaleY(1.0F);
              }
            }
            ((ViewGroup.MarginLayoutParams)localLayoutParams).setMarginStart((int)paramAnonymousValueAnimator.x);
            ViewGroup.LayoutParams localLayoutParams = this.urI.urG.getLayoutParams();
            if (localLayoutParams == null)
            {
              paramAnonymousValueAnimator = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
              AppMethodBeat.o(246813);
              throw paramAnonymousValueAnimator;
            }
            ((ViewGroup.MarginLayoutParams)localLayoutParams).topMargin = ((int)paramAnonymousValueAnimator.y);
            this.urI.urG.requestLayout();
          }
          AppMethodBeat.o(246813);
        }
      }).setListener((Animator.AnimatorListener)new AnimatorListenerAdapter()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(246815);
          this.urI.urt.ura.removeView((View)this.urI.urG);
          AppMethodBeat.o(246815);
        }
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(246814);
          this.urI.urt.ura.removeView((View)this.urI.urG);
          AppMethodBeat.o(246814);
        }
      }).start();
      AppMethodBeat.o(246816);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<MTimerHandler>
  {
    f(aj paramaj)
    {
      super();
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onTimerExpired"})
    static final class a
      implements MTimerHandler.CallBack
    {
      a(aj.f paramf) {}
      
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(246817);
        if ((this.urJ.urt.count > 0) && (this.urJ.urt.urq[0] != 0) && (this.urJ.urt.urq[1] != 0))
        {
          aj localaj = this.urJ.urt;
          localaj.count -= 1;
          this.urJ.urt.v(this.urJ.urt.urq[0], this.urJ.urt.urq[1], true);
          this.urJ.urt.ga(this.urJ.urt.urq[0], this.urJ.urt.urq[1]);
        }
        AppMethodBeat.o(246817);
        return true;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.a<x>
  {
    g(aj paramaj, List paramList)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.aj
 * JD-Core Version:    0.7.0.1
 */