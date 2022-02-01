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
import com.tencent.mm.kernel.h;
import com.tencent.mm.live.c.b.b;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.live.model.ah;
import com.tencent.mm.plugin.finder.live.model.an;
import com.tencent.mm.plugin.finder.live.model.cgi.x.a;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.g;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.protocal.protobuf.azs;
import com.tencent.mm.protocal.protobuf.bal;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.ax;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;
import org.libpag.PAGFile;
import org.libpag.PAGView;
import org.libpag.PAGView.PAGViewListener;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveLotteryCardPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "BIG_ANIMATION_FILE", "", "getBIG_ANIMATION_FILE", "()Ljava/lang/String;", "LANDSCAPE_SCALE_SIZE", "", "getLANDSCAPE_SCALE_SIZE", "()F", "PORTRAIT_HEIGHT", "getPORTRAIT_HEIGHT", "PORTRAIT_WIDTH", "getPORTRAIT_WIDTH", "TAG", "getTAG", "animationCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryInfo;", "Lkotlin/ParameterName;", "name", "lotteryInfo", "", "getAnimationCallback", "()Lkotlin/jvm/functions/Function1;", "setAnimationCallback", "(Lkotlin/jvm/functions/Function1;)V", "bigAnim", "Lorg/libpag/PAGView;", "getBigAnim", "()Lorg/libpag/PAGView;", "setBigAnim", "(Lorg/libpag/PAGView;)V", "bigAnimContainer", "Landroid/widget/FrameLayout;", "getBigAnimContainer", "()Landroid/widget/FrameLayout;", "setBigAnimContainer", "(Landroid/widget/FrameLayout;)V", "bigAnimListener", "Lcom/tencent/mm/plugin/finder/live/plugin/BigAnimListener;", "getBigAnimListener", "()Lcom/tencent/mm/plugin/finder/live/plugin/BigAnimListener;", "setBigAnimListener", "(Lcom/tencent/mm/plugin/finder/live/plugin/BigAnimListener;)V", "card", "Landroid/view/View;", "getCard", "()Landroid/view/View;", "setCard", "(Landroid/view/View;)V", "cardContainer", "getCardContainer", "setCardContainer", "closeBtn", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getCloseBtn", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setCloseBtn", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "lottering", "", "getLottering", "()Z", "setLottering", "(Z)V", "getLotteryInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryInfo;", "setLotteryInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryInfo;)V", "adjustLayout", "canClearScreen", "changeToUnvisible", "getLotteryRecord", "callback", "Lkotlin/Function0;", "initBigAnim", "initView", "isLotteryFinish", "onCloseClick", "openCard", "statusChange", "openCardImpl", "lotteryInfoWrapper", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/LotteryInfoWrapper;", "playLotteringAnim", "status", "", "reset", "setVisible", "visible", "showLottering", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "unMount", "updateCard", "plugin-finder_release"})
public abstract class bm
  extends d
{
  private final String TAG;
  private final com.tencent.mm.live.c.b kCL;
  private WeImageView kDx;
  bal xHW;
  private final float ytW;
  private final float ytX;
  private final float ytY;
  private final String ytZ;
  FrameLayout yua;
  PAGView yub;
  volatile boolean yuc;
  private a yud;
  View yue;
  private View yuf;
  kotlin.g.a.b<? super bal, x> yug;
  
  public bm(ViewGroup paramViewGroup, com.tencent.mm.live.c.b paramb)
  {
    super(paramViewGroup, paramb);
    this.kCL = paramb;
    this.TAG = "FinderLiveLotteryCardPlugin";
    this.ytW = 0.81F;
    this.ytX = 320.0F;
    this.ytY = 424.0F;
    this.ytZ = "big_lottery_anim.pag";
    this.xHW = new bal();
    paramViewGroup = aj.AGc;
    aj.aFQ("FinderLiveLotteryCardPlugin");
    initView();
  }
  
  private void P(kotlin.g.a.a<x> parama)
  {
    p.k(parama, "callback");
    reset();
    dBV();
    tU(0);
    Object localObject = this.yue;
    if (localObject != null) {
      ((View)localObject).setVisibility(4);
    }
    localObject = this.yud;
    if (localObject != null) {
      ((a)localObject).M(parama);
    }
    parama = this.yub;
    if (parama != null) {
      parama.setProgress(0.0D);
    }
    parama = this.yub;
    if (parama != null) {
      parama.flush();
    }
    parama = this.yub;
    if (parama != null) {
      parama.play();
    }
  }
  
  private final void dBV()
  {
    if (this.yub == null)
    {
      this.yub = new PAGView(this.kiF.getContext());
      this.yud = new a(this);
      localObject1 = this.yub;
      if (localObject1 != null) {
        ((PAGView)localObject1).addListener((PAGView.PAGViewListener)this.yud);
      }
    }
    Object localObject1 = this.yua;
    if ((localObject1 != null) && (((FrameLayout)localObject1).indexOfChild((View)this.yub) == -1))
    {
      localObject1 = new FrameLayout.LayoutParams(-1, -1);
      Object localObject2 = this.yub;
      if (localObject2 != null) {
        ((PAGView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      localObject1 = this.yub;
      if (localObject1 != null)
      {
        localObject2 = MMApplicationContext.getContext();
        p.j(localObject2, "MMApplicationContext.getContext()");
        localObject2 = ((Context)localObject2).getResources();
        p.j(localObject2, "MMApplicationContext.getContext().resources");
        ((PAGView)localObject1).setFile(PAGFile.Load(((Resources)localObject2).getAssets(), this.ytZ));
      }
      localObject1 = this.yua;
      if (localObject1 != null) {
        ((FrameLayout)localObject1).addView((View)this.yub);
      }
      localObject1 = this.yua;
      if (localObject1 != null) {
        ((FrameLayout)localObject1).setClickable(true);
      }
    }
  }
  
  public final void O(final kotlin.g.a.a<x> parama)
  {
    p.k(parama, "callback");
    Object localObject = ah.yhC;
    an localan = ah.getFinderLiveAssistant();
    if (localan != null)
    {
      localObject = ((g)business(g.class)).zic;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.l)localObject).xHW;
        if (localObject != null)
        {
          localObject = ((bal)localObject).id;
          if (localObject != null) {
            break label79;
          }
        }
      }
      localObject = "";
    }
    label79:
    for (;;)
    {
      localan.a((String)localObject, null, (x.a)new a(this, parama));
      return;
    }
  }
  
  public final void a(com.tencent.mm.plugin.finder.live.viewmodel.data.l paraml, final bal parambal, final int paramInt, kotlin.g.a.b<? super bal, x> paramb)
  {
    p.k(paraml, "lotteryInfoWrapper");
    p.k(parambal, "lotteryInfo");
    p.k(paramb, "callback");
    this.yug = paramb;
    this.xHW = parambal;
    boolean bool2 = paraml.zeP;
    boolean bool1;
    boolean bool3;
    if (this.kiF.getVisibility() == 0)
    {
      bool1 = true;
      paramb = h.ag(PluginFinder.class);
      p.j(paramb, "MMKernel.plugin(PluginFinder::class.java)");
      bool3 = ((PluginFinder)paramb).isPagEnable();
      String str = getTAG();
      StringBuilder localStringBuilder = new StringBuilder("playLotteringAnim id:").append(parambal.id).append(" status:").append(paramInt).append(", haveLottering:").append(bool2).append(", isCardShowing:").append(bool1).append(", lottering:").append(this.yuc).append(",callback:");
      paramb = this.yug;
      if (paramb == null) {
        break label214;
      }
      paramb = Integer.valueOf(paramb.hashCode());
      label174:
      Log.i(str, paramb + ",isPagEnable:" + bool3);
      if (!this.yuc) {
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
          paraml = this.yug;
        } while (paraml == null);
        paraml.invoke(this.xHW);
        return;
        if (!bool2) {
          break label272;
        }
        paraml = this.yug;
      } while (paraml == null);
      paraml.invoke(this.xHW);
      return;
      paraml.zeP = true;
      if (!bool1) {
        break label303;
      }
      paraml = this.yug;
    } while (paraml == null);
    label272:
    paraml.invoke(this.xHW);
    return;
    label303:
    this.yuc = true;
    P((kotlin.g.a.a)new d(this, parambal, paramInt));
  }
  
  public void a(boolean paramBoolean, com.tencent.mm.plugin.finder.live.viewmodel.data.l paraml)
  {
    p.k(paraml, "lotteryInfoWrapper");
    switch (paraml.ycO)
    {
    default: 
      return;
    case 2: 
      paraml = this.kCL;
      localObject1 = b.c.kAO;
      localObject2 = new Bundle();
      ((Bundle)localObject2).putBoolean("PARAM_FINDER_LIVE_LOTTERY_VISIBILITY_CACHE", true);
      paraml.statusChange((b.c)localObject1, (Bundle)localObject2);
      return;
    }
    Object localObject1 = this.kCL;
    Object localObject2 = b.c.kAO;
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("PARAM_FINDER_LIVE_LOTTERY_VISIBILITY_CACHE", true);
    ((com.tencent.mm.live.c.b)localObject1).statusChange((b.c)localObject2, localBundle);
    localObject1 = (g)business(g.class);
    paraml = paraml.xHW;
    if (paraml != null) {}
    for (paraml = paraml.id;; paraml = null)
    {
      ((g)localObject1).aDc(paraml);
      return;
    }
  }
  
  public final boolean dAo()
  {
    return false;
  }
  
  public final View dBU()
  {
    return this.yuf;
  }
  
  public final void dBW()
  {
    tU(8);
    b.b.a(this.kCL, b.c.kAR);
  }
  
  public void dBX()
  {
    Log.i(getTAG(), "changeToUnvisible");
  }
  
  public String getTAG()
  {
    return this.TAG;
  }
  
  public void initView()
  {
    this.kiF.setOnClickListener((View.OnClickListener)new b(this));
    this.yue = this.kiF.findViewById(b.f.card_container);
    this.yuf = this.kiF.findViewById(b.f.card);
    this.yua = ((FrameLayout)this.kiF.findViewById(b.f.finder_live_lottery_big_anim));
    this.kDx = ((WeImageView)this.kiF.findViewById(b.f.close));
    Object localObject = this.kDx;
    if (localObject != null) {
      ((WeImageView)localObject).setOnClickListener((View.OnClickListener)new c(this));
    }
    float f1;
    int i;
    float f2;
    if (isLandscape())
    {
      f1 = ax.au(this.kiF.getContext()).y * this.ytW;
      i = com.tencent.mm.view.d.e(MMApplicationContext.getContext(), this.ytY);
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
        int j = com.tencent.mm.view.d.e(MMApplicationContext.getContext(), this.ytX);
        float f3 = j * f2;
        float f4 = i - f1;
        float f5 = j - f3;
        float f6 = f4 / 2.0F;
        f7 = -(f5 / 2.0F);
        Log.i(getTAG(), "adjustLayout targetHeight:" + f1 + ",targetWidth:" + f3 + ",sourceHeight:" + i + ",sourceWidth:" + j + ',' + "scale:" + f2 + ",diffHeight:" + f4 + ",translationY:" + f6 + ",diffWidth:" + f5 + ',' + f7);
        localObject = this.yuf;
        if (localObject != null) {
          ((View)localObject).setScaleX(f2);
        }
        localObject = this.yuf;
        if (localObject != null) {
          ((View)localObject).setScaleY(f2);
        }
        localObject = this.kDx;
        if (localObject != null) {
          ((WeImageView)localObject).setTranslationY(f6);
        }
        localObject = this.kDx;
      } while (localObject == null);
      ((WeImageView)localObject).setTranslationX(f7);
      return;
      localObject = this.yuf;
      if (localObject != null) {
        ((View)localObject).setScaleX(1.0F);
      }
      localObject = this.yuf;
      if (localObject != null) {
        ((View)localObject).setScaleY(1.0F);
      }
      localObject = this.kDx;
    } while (localObject == null);
    ((WeImageView)localObject).setTranslationY(0.0F);
  }
  
  public final void reset()
  {
    PAGView localPAGView = this.yub;
    if ((localPAGView != null) && (localPAGView.isPlaying() == true))
    {
      localPAGView = this.yub;
      if (localPAGView != null) {
        localPAGView.stop();
      }
    }
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    Object localObject = null;
    boolean bool2 = true;
    p.k(paramc, "status");
    switch (bn.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    do
    {
      return;
      if (paramBundle != null) {}
      for (boolean bool1 = paramBundle.getBoolean("PARAM_FINDER_LIVE_LOTTERY_CARD_SHOW_STATUS");; bool1 = true)
      {
        paramBundle = ((g)business(g.class)).zic;
        paramc = localObject;
        if (paramBundle != null) {
          paramc = paramBundle.xHW;
        }
        if (paramc == null) {
          break;
        }
        a(bool1, paramBundle);
        return;
      }
      tU(8);
      paramc = getTAG();
      paramBundle = new StringBuilder("openCard statusChange:").append(bool1).append(" lotteryInfo is empty:");
      if (this.xHW == null) {}
      for (bool1 = bool2;; bool1 = false)
      {
        Log.i(paramc, bool1 + '!');
        return;
      }
      tU(4);
      return;
    } while (this.kiF.getVisibility() != 0);
    paramBundle = ((g)business(g.class)).zic;
    if (paramBundle != null) {}
    for (paramc = paramBundle.xHW; paramc != null; paramc = null)
    {
      a(false, paramBundle);
      return;
    }
    tU(8);
    Log.i(getTAG(), "updateCard lotteryInfo is empty!");
  }
  
  public void tU(int paramInt)
  {
    Bundle localBundle = null;
    boolean bool2 = true;
    int i = this.kiF.getVisibility();
    Object localObject1 = ((g)business(g.class)).zic;
    label105:
    Object localObject2;
    if ((localObject1 == null) || (((com.tencent.mm.plugin.finder.live.viewmodel.data.l)localObject1).ycO != 1))
    {
      localObject1 = ((g)business(g.class)).zic;
      if ((localObject1 == null) || (((com.tencent.mm.plugin.finder.live.viewmodel.data.l)localObject1).ycO != 2))
      {
        bool1 = true;
        localObject1 = ((g)business(g.class)).zic;
        if (localObject1 == null) {
          break label428;
        }
        localObject1 = Boolean.valueOf(((com.tencent.mm.plugin.finder.live.viewmodel.data.l)localObject1).zeS);
        localObject2 = ((g)business(g.class)).zic;
        if (localObject2 == null) {
          break label434;
        }
        localObject2 = Boolean.valueOf(((com.tencent.mm.plugin.finder.live.viewmodel.data.l)localObject2).zeQ);
        label135:
        int j = ((g)business(g.class)).zib.size();
        Log.i(getTAG(), "curVisibility:" + i + ",lastVisibility:" + paramInt + ",lastDoneLottery:" + localObject2 + ",remoteSize:" + j + ",isLotteryFinish:" + bool1 + ",bubbleFinish:" + localObject1);
        if ((i == 0) && (paramInt != 0))
        {
          if ((bool1) && ((p.h(localObject1, Boolean.TRUE)) || (j > 1)))
          {
            localObject2 = (g)business(g.class);
            Object localObject3 = ((g)business(g.class)).zic;
            localObject1 = localBundle;
            if (localObject3 != null)
            {
              localObject3 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.l)localObject3).xHW;
              localObject1 = localBundle;
              if (localObject3 != null) {
                localObject1 = ((bal)localObject3).id;
              }
            }
            ((g)localObject2).bn((String)localObject1, ((g)business(g.class)).dHj());
          }
          localObject1 = this.kCL;
          localObject2 = b.c.kAN;
          localBundle = new Bundle();
          localBundle.putBoolean("PARAM_FINDER_LIVE_LOTTERY_VISIBILITY_CACHE", true);
          ((com.tencent.mm.live.c.b)localObject1).statusChange((b.c)localObject2, localBundle);
          dBX();
        }
        localObject1 = ((g)business(g.class)).zic;
        if (localObject1 != null) {
          if (paramInt != 0) {
            break label440;
          }
        }
      }
    }
    label428:
    label434:
    label440:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.l)localObject1).zeR = bool1;
      super.tU(paramInt);
      return;
      bool1 = false;
      break;
      localObject1 = null;
      break label105;
      localObject2 = null;
      break label135;
    }
  }
  
  public final void unMount()
  {
    super.unMount();
    reset();
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveLotteryCardPlugin$getLotteryRecord$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetLotteryRecord$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetLotteryRecordResponse;", "plugin-finder_release"})
  public static final class a
    implements x.a
  {
    a(kotlin.g.a.a parama) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, azs paramazs)
    {
      AppMethodBeat.i(268165);
      p.k(paramazs, "resp");
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        ((g)this.yuh.business(g.class)).a(paramazs.xHW);
        ((g)this.yuh.business(g.class)).d(paramazs);
      }
      parama.invoke();
      AppMethodBeat.o(268165);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(bm parambm) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(291270);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveLotteryCardPlugin$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      this.yuh.dBW();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveLotteryCardPlugin$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(291270);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(bm parambm) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(285874);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveLotteryCardPlugin$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      this.yuh.dBW();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveLotteryCardPlugin$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(285874);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<x>
  {
    d(bm parambm, bal parambal, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.bm
 * JD-Core Version:    0.7.0.1
 */