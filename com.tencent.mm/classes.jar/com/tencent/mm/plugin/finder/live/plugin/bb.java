package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.live.b.b.b;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.model.ap;
import com.tencent.mm.plugin.finder.live.model.cgi.ad.a;
import com.tencent.mm.plugin.finder.live.p.d;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.k;
import com.tencent.mm.plugin.finder.live.viewmodel.data.m;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.protocal.protobuf.bib;
import com.tencent.mm.protocal.protobuf.bjc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.d;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import org.libpag.PAGFile;
import org.libpag.PAGView;
import org.libpag.PAGView.PAGViewListener;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveLotteryCardPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "BIG_ANIMATION_FILE", "", "getBIG_ANIMATION_FILE", "()Ljava/lang/String;", "LANDSCAPE_SCALE_SIZE", "", "getLANDSCAPE_SCALE_SIZE", "()F", "PORTRAIT_HEIGHT", "getPORTRAIT_HEIGHT", "PORTRAIT_WIDTH", "getPORTRAIT_WIDTH", "TAG", "getTAG", "animationCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryInfo;", "Lkotlin/ParameterName;", "name", "lotteryInfo", "", "getAnimationCallback", "()Lkotlin/jvm/functions/Function1;", "setAnimationCallback", "(Lkotlin/jvm/functions/Function1;)V", "bigAnim", "Lorg/libpag/PAGView;", "getBigAnim", "()Lorg/libpag/PAGView;", "setBigAnim", "(Lorg/libpag/PAGView;)V", "bigAnimContainer", "Landroid/widget/FrameLayout;", "getBigAnimContainer", "()Landroid/widget/FrameLayout;", "setBigAnimContainer", "(Landroid/widget/FrameLayout;)V", "bigAnimListener", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveLotteryCardPlugin$BigAnimListener;", "getBigAnimListener", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveLotteryCardPlugin$BigAnimListener;", "setBigAnimListener", "(Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveLotteryCardPlugin$BigAnimListener;)V", "card", "Landroid/view/View;", "getCard", "()Landroid/view/View;", "setCard", "(Landroid/view/View;)V", "cardContainer", "getCardContainer", "setCardContainer", "closeBtn", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getCloseBtn", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setCloseBtn", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "lottering", "", "getLottering", "()Z", "setLottering", "(Z)V", "getLotteryInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryInfo;", "setLotteryInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryInfo;)V", "adjustLayout", "canClearScreen", "changeToUnvisible", "getLotteryRecord", "callback", "Lkotlin/Function0;", "initBigAnim", "initView", "isLotteryFinish", "mount", "onCloseClick", "openCard", "statusChange", "openCardImpl", "lotteryInfoWrapper", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/LotteryInfoWrapper;", "playLotteringAnim", "status", "", "reset", "setVisible", "visible", "showLottering", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "unMount", "updateCard", "BigAnimListener", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class bb
  extends b
{
  bjc Bhm;
  View DeA;
  private View DeB;
  kotlin.g.a.b<? super bjc, ah> DeC;
  private final float Des;
  private final float Det;
  private final float Deu;
  private final String Dev;
  FrameLayout Dew;
  PAGView Dex;
  volatile boolean Dey;
  private a Dez;
  private final String TAG;
  private final com.tencent.mm.live.b.b nfT;
  private WeImageView ngN;
  
  public bb(ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb)
  {
    super(paramViewGroup, paramb);
    this.nfT = paramb;
    this.TAG = "FinderLiveLotteryCardPlugin";
    this.Des = 0.81F;
    this.Det = 320.0F;
    this.Deu = 424.0F;
    this.Dev = "big_lottery_anim.pag";
    this.Bhm = new bjc();
    paramViewGroup = aw.Gjk;
    aw.aBW("FinderLiveLotteryCardPlugin");
    initView();
  }
  
  private static final void a(bb parambb, View paramView)
  {
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parambb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveLotteryCardPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parambb, "this$0");
    parambb.eqV();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveLotteryCardPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
  }
  
  private static final void b(bb parambb, View paramView)
  {
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parambb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveLotteryCardPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parambb, "this$0");
    parambb.eqV();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveLotteryCardPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
  }
  
  private final void bk(kotlin.g.a.a<ah> parama)
  {
    reset();
    eqU();
    tO(0);
    Object localObject = this.DeA;
    if (localObject != null) {
      ((View)localObject).setVisibility(4);
    }
    localObject = this.Dez;
    if (localObject != null) {
      ((a)localObject).bl(parama);
    }
    parama = this.Dex;
    if (parama != null) {
      parama.setProgress(0.0D);
    }
    parama = this.Dex;
    if (parama != null) {
      parama.flush();
    }
    parama = this.Dex;
    if (parama != null) {
      parama.play();
    }
  }
  
  private final void eqU()
  {
    if (this.Dex == null)
    {
      this.Dex = new PAGView(this.mJe.getContext());
      this.Dez = new a(this);
      localObject = this.Dex;
      if (localObject != null) {
        ((PAGView)localObject).addListener((PAGView.PAGViewListener)this.Dez);
      }
    }
    Object localObject = this.Dew;
    if ((localObject != null) && (((FrameLayout)localObject).indexOfChild((View)this.Dex) == -1)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject = new FrameLayout.LayoutParams(-1, -1);
        PAGView localPAGView = this.Dex;
        if (localPAGView != null) {
          localPAGView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        localObject = this.Dex;
        if (localObject != null) {
          ((PAGView)localObject).setFile(PAGFile.Load(MMApplicationContext.getContext().getResources().getAssets(), this.Dev));
        }
        localObject = this.Dew;
        if (localObject != null) {
          ((FrameLayout)localObject).addView((View)this.Dex);
        }
        localObject = this.Dew;
        if (localObject != null) {
          ((FrameLayout)localObject).setClickable(true);
        }
      }
      return;
    }
  }
  
  private final void eqV()
  {
    tO(8);
    b.b.a(this.nfT, b.c.neo);
  }
  
  public final void a(m paramm, final bjc parambjc, final int paramInt, kotlin.g.a.b<? super bjc, ah> paramb)
  {
    s.u(paramm, "lotteryInfoWrapper");
    s.u(parambjc, "lotteryInfo");
    s.u(paramb, "callback");
    this.DeC = paramb;
    this.Bhm = parambjc;
    boolean bool2 = paramm.EbU;
    boolean bool1;
    Boolean localBoolean;
    if (this.mJe.getVisibility() == 0)
    {
      bool1 = true;
      localBoolean = ((cn)h.az(cn.class)).isPagEnable();
      String str = getTAG();
      StringBuilder localStringBuilder = new StringBuilder("playLotteringAnim id:").append(parambjc.id).append(" status:").append(paramInt).append(", haveLottering:").append(bool2).append(", isCardShowing:").append(bool1).append(", lottering:").append(this.Dey).append(",callback:");
      paramb = this.DeC;
      if (paramb != null) {
        break label198;
      }
      paramb = null;
      label158:
      Log.i(str, paramb + ",isPagEnable:" + localBoolean);
      if (!this.Dey) {
        break label211;
      }
    }
    label198:
    label211:
    label240:
    do
    {
      do
      {
        do
        {
          return;
          bool1 = false;
          break;
          paramb = Integer.valueOf(paramb.hashCode());
          break label158;
          if (localBoolean.booleanValue()) {
            break label240;
          }
          paramm = this.DeC;
        } while (paramm == null);
        paramm.invoke(this.Bhm);
        return;
        if (!bool2) {
          break label266;
        }
        paramm = this.DeC;
      } while (paramm == null);
      paramm.invoke(this.Bhm);
      return;
      paramm.EbU = true;
      if (!bool1) {
        break label297;
      }
      paramm = this.DeC;
    } while (paramm == null);
    label266:
    paramm.invoke(this.Bhm);
    return;
    label297:
    this.Dey = true;
    bk((kotlin.g.a.a)new d(this, parambjc, paramInt));
  }
  
  public void a(boolean paramBoolean, m paramm)
  {
    s.u(paramm, "lotteryInfoWrapper");
    switch (paramm.CBc)
    {
    default: 
      return;
    case 2: 
      paramm = this.nfT;
      localObject1 = b.c.nel;
      localObject2 = new Bundle();
      ((Bundle)localObject2).putBoolean("PARAM_FINDER_LIVE_LOTTERY_VISIBILITY_CACHE", true);
      localObject3 = ah.aiuX;
      paramm.statusChange((b.c)localObject1, (Bundle)localObject2);
      return;
    }
    Object localObject1 = this.nfT;
    Object localObject2 = b.c.nel;
    Object localObject3 = new Bundle();
    ((Bundle)localObject3).putBoolean("PARAM_FINDER_LIVE_LOTTERY_VISIBILITY_CACHE", true);
    ah localah = ah.aiuX;
    ((com.tencent.mm.live.b.b)localObject1).statusChange((b.c)localObject2, (Bundle)localObject3);
    localObject1 = (k)business(k.class);
    paramm = paramm.Bhm;
    if (paramm == null) {}
    for (paramm = null;; paramm = paramm.id)
    {
      ((k)localObject1).ayu(paramm);
      return;
    }
  }
  
  public final void bj(final kotlin.g.a.a<ah> parama)
  {
    s.u(parama, "callback");
    Object localObject = aj.CGT;
    ap localap = aj.getFinderLiveAssistant();
    if (localap != null)
    {
      localObject = ((k)business(k.class)).Egp;
      if (localObject != null) {
        break label62;
      }
      localObject = "";
    }
    for (;;)
    {
      localap.a((String)localObject, null, (ad.a)new c(this, parama));
      return;
      label62:
      localObject = ((m)localObject).Bhm;
      if (localObject == null)
      {
        localObject = "";
      }
      else
      {
        localObject = ((bjc)localObject).id;
        if (localObject == null) {
          localObject = "";
        }
      }
    }
  }
  
  public final boolean eoI()
  {
    return false;
  }
  
  public final View eqT()
  {
    return this.DeB;
  }
  
  public void eqW()
  {
    Log.i(getTAG(), "changeToUnvisible");
  }
  
  public String getTAG()
  {
    return this.TAG;
  }
  
  public void initView()
  {
    this.mJe.setOnClickListener(new bb..ExternalSyntheticLambda0(this));
    this.DeA = this.mJe.findViewById(p.e.card_container);
    this.DeB = this.mJe.findViewById(p.e.card);
    this.Dew = ((FrameLayout)this.mJe.findViewById(p.e.BNq));
    this.ngN = ((WeImageView)this.mJe.findViewById(p.e.close));
    Object localObject = this.ngN;
    if (localObject != null) {
      ((WeImageView)localObject).setOnClickListener(new bb..ExternalSyntheticLambda1(this));
    }
    float f1;
    int i;
    float f2;
    if (isLandscape())
    {
      f1 = bf.bf(this.mJe.getContext()).y * this.Des;
      i = d.e(MMApplicationContext.getContext(), this.Deu);
      f2 = f1 / i;
      if (f2 <= 0.0F) {
        Log.i(getTAG(), "adjustLayout invalid scale:" + f2 + ",targetHeight:" + f1 + ",sourceHeight:" + i);
      }
    }
    do
    {
      float f7;
      do
      {
        return;
        int j = d.e(MMApplicationContext.getContext(), this.Det);
        float f3 = j * f2;
        float f4 = i - f1;
        float f5 = j - f3;
        float f6 = f4 / 2.0F;
        f7 = -(f5 / 2.0F);
        Log.i(getTAG(), "adjustLayout targetHeight:" + f1 + ",targetWidth:" + f3 + ",sourceHeight:" + i + ",sourceWidth:" + j + ",scale:" + f2 + ",diffHeight:" + f4 + ",translationY:" + f6 + ",diffWidth:" + f5 + ',' + f7);
        localObject = this.DeB;
        if (localObject != null) {
          ((View)localObject).setScaleX(f2);
        }
        localObject = this.DeB;
        if (localObject != null) {
          ((View)localObject).setScaleY(f2);
        }
        localObject = this.ngN;
        if (localObject != null) {
          ((WeImageView)localObject).setTranslationY(f6);
        }
        localObject = this.ngN;
      } while (localObject == null);
      ((WeImageView)localObject).setTranslationX(f7);
      return;
      localObject = this.DeB;
      if (localObject != null) {
        ((View)localObject).setScaleX(1.0F);
      }
      localObject = this.DeB;
      if (localObject != null) {
        ((View)localObject).setScaleY(1.0F);
      }
      localObject = this.ngN;
    } while (localObject == null);
    ((WeImageView)localObject).setTranslationY(0.0F);
  }
  
  public final void mount()
  {
    Object localObject2 = null;
    super.mount();
    View localView = this.DeB;
    Object localObject1;
    if (localView != null)
    {
      localObject1 = this.DeB;
      if (localObject1 != null) {
        break label32;
      }
      localObject1 = localObject2;
    }
    for (;;)
    {
      localView.setBackground((Drawable)localObject1);
      return;
      label32:
      Object localObject3 = ((View)localObject1).getContext();
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject3 = ((Context)localObject3).getResources();
        localObject1 = localObject2;
        if (localObject3 != null) {
          localObject1 = ((Resources)localObject3).getDrawable(p.d.icon_live_lottery_card_bg);
        }
      }
    }
  }
  
  public final void reset()
  {
    int i = 1;
    PAGView localPAGView = this.Dex;
    if ((localPAGView != null) && (localPAGView.isPlaying() == true)) {}
    for (;;)
    {
      if (i != 0)
      {
        localPAGView = this.Dex;
        if (localPAGView != null) {
          localPAGView.stop();
        }
      }
      return;
      i = 0;
    }
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    Object localObject = null;
    boolean bool2 = true;
    s.u(paramc, "status");
    switch (b.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    label98:
    label106:
    do
    {
      return;
      if (paramBundle == null)
      {
        bool1 = true;
        paramBundle = ((k)business(k.class)).Egp;
        if (paramBundle != null) {
          break label98;
        }
      }
      for (paramc = localObject;; paramc = paramBundle.Bhm)
      {
        if (paramc == null) {
          break label106;
        }
        a(bool1, paramBundle);
        return;
        bool1 = paramBundle.getBoolean("PARAM_FINDER_LIVE_LOTTERY_CARD_SHOW_STATUS");
        break;
      }
      tO(8);
      paramc = getTAG();
      paramBundle = new StringBuilder("openCard statusChange:").append(bool1).append(" lotteryInfo is empty:");
      if (this.Bhm == null) {}
      for (boolean bool1 = bool2;; bool1 = false)
      {
        Log.i(paramc, bool1 + '!');
        return;
      }
      tO(4);
      return;
    } while (this.mJe.getVisibility() != 0);
    paramBundle = ((k)business(k.class)).Egp;
    if (paramBundle == null) {}
    for (paramc = null; paramc != null; paramc = paramBundle.Bhm)
    {
      a(false, paramBundle);
      return;
    }
    tO(8);
    Log.i(getTAG(), "updateCard lotteryInfo is empty!");
  }
  
  public void tO(int paramInt)
  {
    Bundle localBundle = null;
    boolean bool2 = true;
    int j = this.mJe.getVisibility();
    Object localObject1 = ((k)business(k.class)).Egp;
    int i;
    label80:
    label87:
    label110:
    Object localObject2;
    label133:
    label292:
    Object localObject3;
    if ((localObject1 != null) && (((m)localObject1).CBc == 1))
    {
      i = 1;
      if (i != 0) {
        break label412;
      }
      localObject1 = ((k)business(k.class)).Egp;
      if ((localObject1 == null) || (((m)localObject1).CBc != 2)) {
        break label407;
      }
      i = 1;
      if (i != 0) {
        break label412;
      }
      bool1 = true;
      localObject1 = ((k)business(k.class)).Egp;
      if (localObject1 != null) {
        break label418;
      }
      localObject1 = null;
      localObject2 = ((k)business(k.class)).Egp;
      if (localObject2 != null) {
        break label431;
      }
      localObject2 = null;
      i = ((k)business(k.class)).Ego.size();
      Log.i(getTAG(), "curVisibility:" + j + ",lastVisibility:" + paramInt + ",lastDoneLottery:" + localObject2 + ",remoteSize:" + i + ",isLotteryFinish:" + bool1 + ",bubbleFinish:" + localObject1);
      if ((j == 0) && (paramInt != 0))
      {
        if ((bool1) && ((s.p(localObject1, Boolean.TRUE)) || (i > 1)))
        {
          localObject2 = (k)business(k.class);
          localObject1 = ((k)business(k.class)).Egp;
          if (localObject1 != null) {
            break label444;
          }
          localObject1 = localBundle;
          ((k)localObject2).bB((String)localObject1, ((k)business(k.class)).ezf());
        }
        localObject1 = this.nfT;
        localObject2 = b.c.nek;
        localBundle = new Bundle();
        localBundle.putBoolean("PARAM_FINDER_LIVE_LOTTERY_VISIBILITY_CACHE", true);
        localObject3 = ah.aiuX;
        ((com.tencent.mm.live.b.b)localObject1).statusChange((b.c)localObject2, localBundle);
        eqW();
      }
      localObject1 = ((k)business(k.class)).Egp;
      if (localObject1 != null) {
        if (paramInt != 0) {
          break label470;
        }
      }
    }
    label407:
    label412:
    label418:
    label431:
    label444:
    label470:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((m)localObject1).EbW = bool1;
      super.tO(paramInt);
      return;
      i = 0;
      break;
      i = 0;
      break label80;
      bool1 = false;
      break label87;
      localObject1 = Boolean.valueOf(((m)localObject1).EbX);
      break label110;
      localObject2 = Boolean.valueOf(((m)localObject2).EbV);
      break label133;
      localObject3 = ((m)localObject1).Bhm;
      localObject1 = localBundle;
      if (localObject3 == null) {
        break label292;
      }
      localObject1 = ((bjc)localObject3).id;
      break label292;
    }
  }
  
  public final void unMount()
  {
    super.unMount();
    View localView = this.DeB;
    if (localView != null) {
      localView.setBackground(null);
    }
    reset();
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveLotteryCardPlugin$BigAnimListener;", "Lorg/libpag/PAGView$PAGViewListener;", "plugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveLotteryCardPlugin;", "(Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveLotteryCardPlugin;Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveLotteryCardPlugin;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "animCallback", "Lkotlin/Function0;", "", "getAnimCallback", "()Lkotlin/jvm/functions/Function0;", "setAnimCallback", "(Lkotlin/jvm/functions/Function0;)V", "rPlugin", "Ljava/lang/ref/WeakReference;", "getRPlugin", "()Ljava/lang/ref/WeakReference;", "setRPlugin", "(Ljava/lang/ref/WeakReference;)V", "onAnimationCancel", "view", "Lorg/libpag/PAGView;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "setCallback", "callback", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class a
    implements PAGView.PAGViewListener
  {
    private kotlin.g.a.a<ah> CBk;
    private WeakReference<bb> DeD;
    private final String TAG;
    
    public a()
    {
      AppMethodBeat.i(354065);
      this.TAG = "FinderLiveLotteryCardPlugin";
      this.DeD = new WeakReference(localObject);
      AppMethodBeat.o(354065);
    }
    
    public final void bl(kotlin.g.a.a<ah> parama)
    {
      AppMethodBeat.i(354068);
      s.u(parama, "callback");
      this.CBk = parama;
      AppMethodBeat.o(354068);
    }
    
    public final void onAnimationCancel(PAGView paramPAGView)
    {
      AppMethodBeat.i(354083);
      bb localbb = (bb)this.DeD.get();
      paramPAGView = this.TAG;
      boolean bool;
      if (localbb == null)
      {
        bool = true;
        Log.i(paramPAGView, s.X("BigAnimListener onAnimationCancel ViewCallback is null:", Boolean.valueOf(bool)));
        if (localbb != null) {
          break label99;
        }
        paramPAGView = null;
        label46:
        if (paramPAGView != null) {
          paramPAGView.setVisibility(8);
        }
        if (localbb != null) {
          break label107;
        }
      }
      label99:
      label107:
      for (paramPAGView = null;; paramPAGView = localbb.Dex)
      {
        if (paramPAGView != null) {
          paramPAGView.setVisibility(8);
        }
        paramPAGView = this.CBk;
        if (paramPAGView != null) {
          paramPAGView.invoke();
        }
        AppMethodBeat.o(354083);
        return;
        bool = false;
        break;
        paramPAGView = localbb.Dew;
        break label46;
      }
    }
    
    public final void onAnimationEnd(PAGView paramPAGView)
    {
      AppMethodBeat.i(354078);
      bb localbb = (bb)this.DeD.get();
      paramPAGView = this.TAG;
      boolean bool;
      if (localbb == null)
      {
        bool = true;
        Log.i(paramPAGView, s.X("BigAnimListener onAnimationEnd ViewCallback is null:", Boolean.valueOf(bool)));
        if (localbb != null) {
          break label99;
        }
        paramPAGView = null;
        label46:
        if (paramPAGView != null) {
          paramPAGView.setVisibility(8);
        }
        if (localbb != null) {
          break label107;
        }
      }
      label99:
      label107:
      for (paramPAGView = null;; paramPAGView = localbb.Dex)
      {
        if (paramPAGView != null) {
          paramPAGView.setVisibility(8);
        }
        paramPAGView = this.CBk;
        if (paramPAGView != null) {
          paramPAGView.invoke();
        }
        AppMethodBeat.o(354078);
        return;
        bool = false;
        break;
        paramPAGView = localbb.Dew;
        break label46;
      }
    }
    
    public final void onAnimationRepeat(PAGView paramPAGView) {}
    
    public final void onAnimationStart(PAGView paramPAGView)
    {
      AppMethodBeat.i(354090);
      bb localbb = (bb)this.DeD.get();
      paramPAGView = this.TAG;
      boolean bool;
      if (localbb == null)
      {
        bool = true;
        Log.i(paramPAGView, s.X("BigAnimListener onAnimationStart ViewCallback is null:", Boolean.valueOf(bool)));
        if (localbb != null) {
          break label99;
        }
        paramPAGView = null;
        label46:
        if (paramPAGView != null) {
          paramPAGView.setVisibility(0);
        }
        if (localbb != null) {
          break label107;
        }
      }
      label99:
      label107:
      for (paramPAGView = null;; paramPAGView = localbb.Dex)
      {
        if (paramPAGView != null) {
          paramPAGView.setVisibility(0);
        }
        if (localbb != null)
        {
          paramPAGView = localbb.Dex;
          if (paramPAGView != null) {
            paramPAGView.flush();
          }
        }
        AppMethodBeat.o(354090);
        return;
        bool = false;
        break;
        paramPAGView = localbb.Dew;
        break label46;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveLotteryCardPlugin$getLotteryRecord$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetLotteryRecord$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetLotteryRecordResponse;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements ad.a
  {
    c(bb parambb, kotlin.g.a.a<ah> parama) {}
    
    public final void a(int paramInt1, int paramInt2, bib parambib)
    {
      AppMethodBeat.i(353365);
      s.u(parambib, "resp");
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        ((k)this.DeE.business(k.class)).a(parambib.Bhm);
        ((k)this.DeE.business(k.class)).d(parambib);
      }
      parama.invoke();
      AppMethodBeat.o(353365);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(bb parambb, bjc parambjc, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.bb
 * JD-Core Version:    0.7.0.1
 */