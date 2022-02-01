package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.c.b.b;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.live.model.cgi.o.a;
import com.tencent.mm.plugin.finder.live.model.o;
import com.tencent.mm.plugin.finder.live.model.s;
import com.tencent.mm.plugin.finder.live.viewmodel.i;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.avy;
import com.tencent.mm.protocal.protobuf.awi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;
import org.libpag.PAGFile;
import org.libpag.PAGView;
import org.libpag.PAGView.PAGViewListener;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveLotteryCardPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "BIG_ANIMATION_FILE", "", "getBIG_ANIMATION_FILE", "()Ljava/lang/String;", "LANDSCAPE_SCALE_SIZE", "", "getLANDSCAPE_SCALE_SIZE", "()F", "PORTRAIT_HEIGHT", "getPORTRAIT_HEIGHT", "PORTRAIT_WIDTH", "getPORTRAIT_WIDTH", "TAG", "getTAG", "animationCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryInfo;", "Lkotlin/ParameterName;", "name", "lotteryInfo", "", "getAnimationCallback", "()Lkotlin/jvm/functions/Function1;", "setAnimationCallback", "(Lkotlin/jvm/functions/Function1;)V", "bigAnim", "Lorg/libpag/PAGView;", "getBigAnim", "()Lorg/libpag/PAGView;", "setBigAnim", "(Lorg/libpag/PAGView;)V", "bigAnimContainer", "Landroid/widget/FrameLayout;", "getBigAnimContainer", "()Landroid/widget/FrameLayout;", "setBigAnimContainer", "(Landroid/widget/FrameLayout;)V", "bigAnimListener", "Lcom/tencent/mm/plugin/finder/live/plugin/BigAnimListener;", "getBigAnimListener", "()Lcom/tencent/mm/plugin/finder/live/plugin/BigAnimListener;", "setBigAnimListener", "(Lcom/tencent/mm/plugin/finder/live/plugin/BigAnimListener;)V", "card", "Landroid/view/View;", "getCard", "()Landroid/view/View;", "setCard", "(Landroid/view/View;)V", "cardContainer", "getCardContainer", "setCardContainer", "closeBtn", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getCloseBtn", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setCloseBtn", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "lottering", "", "getLottering", "()Z", "setLottering", "(Z)V", "getLotteryInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryInfo;", "setLotteryInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryInfo;)V", "adjustLayout", "canClearScreen", "changeToUnvisible", "getLotteryRecord", "callback", "Lkotlin/Function0;", "initBigAnim", "initView", "isLotteryFinish", "onCloseClick", "openCard", "statusChange", "openCardImpl", "lotteryInfoWrapper", "Lcom/tencent/mm/plugin/finder/live/viewmodel/LotteryInfoWrapper;", "playLotteringAnim", "status", "", "reset", "setVisible", "visible", "showLottering", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "unMount", "updateCard", "plugin-finder_release"})
public abstract class an
  extends d
{
  private final String TAG;
  private final com.tencent.mm.live.c.b hOp;
  private WeImageView hPb;
  awi tWe;
  private final float urN;
  private final float urO;
  private final float urP;
  private final String urQ;
  FrameLayout urR;
  PAGView urS;
  volatile boolean urT;
  private a urU;
  View urV;
  View urW;
  kotlin.g.a.b<? super awi, x> urX;
  
  public an(ViewGroup paramViewGroup, com.tencent.mm.live.c.b paramb)
  {
    super(paramViewGroup, paramb);
    this.hOp = paramb;
    this.TAG = "FinderLiveLotteryCardPlugin";
    this.urN = 0.81F;
    this.urO = 320.0F;
    this.urP = 424.0F;
    this.urQ = "big_lottery_anim.pag";
    this.tWe = new awi();
    paramViewGroup = y.vXH;
    y.awu("FinderLiveLotteryCardPlugin");
    initView();
  }
  
  private void P(kotlin.g.a.a<x> parama)
  {
    p.h(parama, "callback");
    reset();
    dhv();
    rg(0);
    Object localObject = this.urV;
    if (localObject != null) {
      ((View)localObject).setVisibility(4);
    }
    localObject = this.urU;
    if (localObject != null) {
      ((a)localObject).N(parama);
    }
    parama = this.urS;
    if (parama != null) {
      parama.setProgress(0.0D);
    }
    parama = this.urS;
    if (parama != null) {
      parama.flush();
    }
    parama = this.urS;
    if (parama != null) {
      parama.play();
    }
  }
  
  private final void dhv()
  {
    if (this.urS == null)
    {
      this.urS = new PAGView(this.hwr.getContext());
      this.urU = new a(this);
      localObject1 = this.urS;
      if (localObject1 != null) {
        ((PAGView)localObject1).addListener((PAGView.PAGViewListener)this.urU);
      }
    }
    Object localObject1 = this.urR;
    if ((localObject1 != null) && (((FrameLayout)localObject1).indexOfChild((View)this.urS) == -1))
    {
      localObject1 = new FrameLayout.LayoutParams(-1, -1);
      Object localObject2 = this.urS;
      if (localObject2 != null) {
        ((PAGView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      localObject1 = this.urS;
      if (localObject1 != null)
      {
        localObject2 = MMApplicationContext.getContext();
        p.g(localObject2, "MMApplicationContext.getContext()");
        localObject2 = ((Context)localObject2).getResources();
        p.g(localObject2, "MMApplicationContext.getContext().resources");
        ((PAGView)localObject1).setFile(PAGFile.Load(((Resources)localObject2).getAssets(), this.urQ));
      }
      localObject1 = this.urR;
      if (localObject1 != null) {
        ((FrameLayout)localObject1).addView((View)this.urS);
      }
      localObject1 = this.urR;
      if (localObject1 != null) {
        ((FrameLayout)localObject1).setClickable(true);
      }
    }
  }
  
  private final boolean dhy()
  {
    i locali = getLiveData().uEa;
    if ((locali == null) || (locali.uhD != 1))
    {
      locali = getLiveData().uEa;
      if ((locali == null) || (locali.uhD != 2)) {
        return true;
      }
    }
    return false;
  }
  
  public final void O(final kotlin.g.a.a<x> parama)
  {
    p.h(parama, "callback");
    Object localObject = o.ujN;
    s locals = o.getFinderLiveAssistant();
    if (locals != null)
    {
      localObject = getLiveData().uEa;
      if (localObject != null)
      {
        localObject = ((i)localObject).tWe;
        if (localObject != null)
        {
          localObject = ((awi)localObject).id;
          if (localObject != null) {
            break label73;
          }
        }
      }
      localObject = "";
    }
    label73:
    for (;;)
    {
      locals.a((String)localObject, null, (o.a)new a(this, parama));
      return;
    }
  }
  
  public final void a(i parami, final awi paramawi, final int paramInt, kotlin.g.a.b<? super awi, x> paramb)
  {
    p.h(parami, "lotteryInfoWrapper");
    p.h(paramawi, "lotteryInfo");
    p.h(paramb, "callback");
    this.urX = paramb;
    this.tWe = paramawi;
    boolean bool2 = parami.uFs;
    boolean bool1;
    boolean bool3;
    if (this.hwr.getVisibility() == 0)
    {
      bool1 = true;
      paramb = com.tencent.mm.kernel.g.ah(PluginFinder.class);
      p.g(paramb, "MMKernel.plugin(PluginFinder::class.java)");
      bool3 = ((PluginFinder)paramb).isPagEnable();
      String str = getTAG();
      StringBuilder localStringBuilder = new StringBuilder("playLotteringAnim id:").append(paramawi.id).append(" status:").append(paramInt).append(", haveLottering:").append(bool2).append(", isCardShowing:").append(bool1).append(", lottering:").append(this.urT).append(",callback:");
      paramb = this.urX;
      if (paramb == null) {
        break label214;
      }
      paramb = Integer.valueOf(paramb.hashCode());
      label174:
      Log.i(str, paramb + ",isPagEnable:" + bool3);
      if (!this.urT) {
        break label220;
      }
    }
    label214:
    label220:
    label246:
    do
    {
      do
      {
        do
        {
          return;
          bool1 = false;
          break;
          paramb = null;
          break label174;
          if (bool3) {
            break label246;
          }
          parami = this.urX;
        } while (parami == null);
        parami.invoke(this.tWe);
        return;
        if (!bool2) {
          break label272;
        }
        parami = this.urX;
      } while (parami == null);
      parami.invoke(this.tWe);
      return;
      parami.uFs = true;
      if (!bool1) {
        break label303;
      }
      parami = this.urX;
    } while (parami == null);
    label272:
    parami.invoke(this.tWe);
    return;
    label303:
    this.urT = true;
    P((kotlin.g.a.a)new d(this, paramawi, paramInt));
  }
  
  public void a(boolean paramBoolean, i parami)
  {
    p.h(parami, "lotteryInfoWrapper");
    switch (parami.uhD)
    {
    default: 
      return;
    case 2: 
      parami = this.hOp;
      localObject1 = b.c.hND;
      localObject2 = new Bundle();
      ((Bundle)localObject2).putBoolean("PARAM_FINDER_LIVE_LOTTERY_VISIBILITY_CACHE", true);
      parami.statusChange((b.c)localObject1, (Bundle)localObject2);
      return;
    }
    Object localObject1 = this.hOp;
    Object localObject2 = b.c.hND;
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("PARAM_FINDER_LIVE_LOTTERY_VISIBILITY_CACHE", true);
    ((com.tencent.mm.live.c.b)localObject1).statusChange((b.c)localObject2, localBundle);
    localObject1 = getLiveData();
    parami = parami.tWe;
    if (parami != null) {}
    for (parami = parami.id;; parami = null)
    {
      ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject1).atY(parami);
      return;
    }
  }
  
  public final boolean dgK()
  {
    return false;
  }
  
  public final void dhw()
  {
    rg(8);
    b.b.a(this.hOp, b.c.hNG);
  }
  
  public void dhx()
  {
    Log.i(getTAG(), "changeToUnvisible");
  }
  
  public String getTAG()
  {
    return this.TAG;
  }
  
  public void initView()
  {
    this.hwr.setOnClickListener((View.OnClickListener)new b(this));
    this.urV = this.hwr.findViewById(2131298085);
    this.urW = this.hwr.findViewById(2131298006);
    this.urR = ((FrameLayout)this.hwr.findViewById(2131301138));
    this.hPb = ((WeImageView)this.hwr.findViewById(2131298763));
    Object localObject = this.hPb;
    if (localObject != null) {
      ((WeImageView)localObject).setOnClickListener((View.OnClickListener)new c(this));
    }
    float f1;
    int i;
    float f2;
    if (isLandscape())
    {
      f1 = au.az(this.hwr.getContext()).y * this.urN;
      i = com.tencent.mm.view.d.e(MMApplicationContext.getContext(), this.urP);
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
        int j = com.tencent.mm.view.d.e(MMApplicationContext.getContext(), this.urO);
        float f3 = j * f2;
        float f4 = i - f1;
        float f5 = j - f3;
        float f6 = f4 / 2.0F;
        f7 = -(f5 / 2.0F);
        Log.i(getTAG(), "adjustLayout targetHeight:" + f1 + ",targetWidth:" + f3 + ",sourceHeight:" + i + ",sourceWidth:" + j + ',' + "scale:" + f2 + ",diffHeight:" + f4 + ",translationY:" + f6 + ",diffWidth:" + f5 + ',' + f7);
        localObject = this.urW;
        if (localObject != null) {
          ((View)localObject).setScaleX(f2);
        }
        localObject = this.urW;
        if (localObject != null) {
          ((View)localObject).setScaleY(f2);
        }
        localObject = this.hPb;
        if (localObject != null) {
          ((WeImageView)localObject).setTranslationY(f6);
        }
        localObject = this.hPb;
      } while (localObject == null);
      ((WeImageView)localObject).setTranslationX(f7);
      return;
      localObject = this.urW;
      if (localObject != null) {
        ((View)localObject).setScaleX(1.0F);
      }
      localObject = this.urW;
      if (localObject != null) {
        ((View)localObject).setScaleY(1.0F);
      }
      localObject = this.hPb;
    } while (localObject == null);
    ((WeImageView)localObject).setTranslationY(0.0F);
  }
  
  public final void reset()
  {
    PAGView localPAGView = this.urS;
    if ((localPAGView != null) && (localPAGView.isPlaying() == true))
    {
      localPAGView = this.urS;
      if (localPAGView != null) {
        localPAGView.stop();
      }
    }
  }
  
  public final void rg(int paramInt)
  {
    Bundle localBundle = null;
    int i = this.hwr.getVisibility();
    boolean bool = dhy();
    Object localObject1 = getLiveData().uEa;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = Boolean.valueOf(((i)localObject1).uFv);
      localObject2 = getLiveData().uEa;
      if (localObject2 == null) {
        break label327;
      }
      localObject2 = Boolean.valueOf(((i)localObject2).uFt);
      label65:
      int j = getLiveData().uDZ.size();
      Log.i(getTAG(), "curVisibility:" + i + ",lastVisibility:" + paramInt + ",lastDoneLottery:" + localObject2 + ",remoteSize:" + j + ",isLotteryFinish:" + bool + ",bubbleFinish:" + localObject1);
      if ((i == 0) && (paramInt != 0))
      {
        if ((bool) && ((p.j(localObject1, Boolean.TRUE)) || (j > 1)))
        {
          localObject2 = getLiveData();
          Object localObject3 = getLiveData().uEa;
          localObject1 = localBundle;
          if (localObject3 != null)
          {
            localObject3 = ((i)localObject3).tWe;
            localObject1 = localBundle;
            if (localObject3 != null) {
              localObject1 = ((awi)localObject3).id;
            }
          }
          ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject2).bj((String)localObject1, getLiveData().djh());
        }
        localObject1 = this.hOp;
        localObject2 = b.c.hNC;
        localBundle = new Bundle();
        localBundle.putBoolean("PARAM_FINDER_LIVE_LOTTERY_VISIBILITY_CACHE", true);
        ((com.tencent.mm.live.c.b)localObject1).statusChange((b.c)localObject2, localBundle);
        dhx();
      }
      localObject1 = getLiveData().uEa;
      if (localObject1 != null) {
        if (paramInt != 0) {
          break label333;
        }
      }
    }
    label327:
    label333:
    for (bool = true;; bool = false)
    {
      ((i)localObject1).uFu = bool;
      super.rg(paramInt);
      return;
      localObject1 = null;
      break;
      localObject2 = null;
      break label65;
    }
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    Object localObject = null;
    boolean bool2 = true;
    p.h(paramc, "status");
    switch (ao.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    do
    {
      return;
      if (paramBundle != null) {}
      for (boolean bool1 = paramBundle.getBoolean("PARAM_FINDER_LIVE_LOTTERY_CARD_SHOW_STATUS");; bool1 = true)
      {
        paramBundle = getLiveData().uEa;
        paramc = localObject;
        if (paramBundle != null) {
          paramc = paramBundle.tWe;
        }
        if (paramc == null) {
          break;
        }
        a(bool1, paramBundle);
        return;
      }
      rg(8);
      paramc = getTAG();
      paramBundle = new StringBuilder("openCard statusChange:").append(bool1).append(" lotteryInfo is empty:");
      if (this.tWe == null) {}
      for (bool1 = bool2;; bool1 = false)
      {
        Log.i(paramc, bool1 + '!');
        return;
      }
      rg(4);
      return;
    } while (this.hwr.getVisibility() != 0);
    paramBundle = getLiveData().uEa;
    if (paramBundle != null) {}
    for (paramc = paramBundle.tWe; paramc != null; paramc = null)
    {
      a(false, paramBundle);
      return;
    }
    rg(8);
    Log.i(getTAG(), "updateCard lotteryInfo is empty!");
  }
  
  public final void unMount()
  {
    super.unMount();
    reset();
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveLotteryCardPlugin$getLotteryRecord$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetLotteryRecord$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetLotteryRecordResponse;", "plugin-finder_release"})
  public static final class a
    implements o.a
  {
    a(kotlin.g.a.a parama) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, avy paramavy)
    {
      AppMethodBeat.i(246842);
      p.h(paramavy, "resp");
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.urY.getLiveData().a(paramavy.tWe);
        this.urY.getLiveData().d(paramavy);
      }
      parama.invoke();
      AppMethodBeat.o(246842);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(an paraman) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(246843);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveLotteryCardPlugin$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      this.urY.dhw();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveLotteryCardPlugin$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(246843);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(an paraman) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(246844);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveLotteryCardPlugin$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      this.urY.dhw();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveLotteryCardPlugin$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(246844);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<x>
  {
    d(an paraman, awi paramawi, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.an
 * JD-Core Version:    0.7.0.1
 */