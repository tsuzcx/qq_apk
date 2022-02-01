package com.tencent.mm.plugin.finder.live.plugin;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import androidx.lifecycle.r;
import androidx.lifecycle.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.live.component.m.a;
import com.tencent.mm.plugin.finder.live.component.m.b;
import com.tencent.mm.plugin.finder.live.component.n;
import com.tencent.mm.plugin.finder.live.component.o;
import com.tencent.mm.plugin.finder.live.report.m;
import com.tencent.mm.plugin.finder.live.report.s.bm;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.t;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveLotteryBubblePlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "cacheVisible", "", "getCacheVisible", "()Z", "setCacheVisible", "(Z)V", "layoutChangeListener", "Landroid/view/View$OnLayoutChangeListener;", "presenter", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryBubbleContract$Presenter;", "getPresenter", "()Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryBubbleContract$Presenter;", "setPresenter", "(Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryBubbleContract$Presenter;)V", "showingLocation", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveLotteryBubblePlugin$ShowingLocation;", "getShowingLocation", "()Landroidx/lifecycle/MutableLiveData;", "viewCallback", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryBubbleContract$ViewCallback;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryBubbleContract$ViewCallback;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryBubbleContract$ViewCallback;)V", "canClearScreen", "getBottomLocation", "", "mount", "", "printLotteryInfo", "action", "resumeLottery", "setVisible", "visible", "", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "unMount", "updateLottery", "watchLuckyMoneyBubbleShowingLocation", "Companion", "ShowingLocation", "plugin-finder_release"})
public final class bk
  extends d
{
  private static final float ytP;
  public static final a ytQ;
  private final String TAG;
  private final com.tencent.mm.live.c.b kCL;
  m.a yaC;
  private m.b yai;
  public final r<b> ytM;
  private final View.OnLayoutChangeListener ytN;
  private volatile boolean ytO;
  
  static
  {
    AppMethodBeat.i(247816);
    ytQ = new a((byte)0);
    ytP = -MMApplicationContext.getResources().getDimension(b.d.Edge_6_5_A);
    AppMethodBeat.o(247816);
  }
  
  public bk(final ViewGroup paramViewGroup, com.tencent.mm.live.c.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(247815);
    this.kCL = paramb;
    this.TAG = "FinderLiveLotteryBubblePlugin";
    this.ytM = new r();
    this.yaC = ((m.a)new n(getBuContext(), this.kCL));
    paramb = (View)paramViewGroup;
    Object localObject = paramViewGroup.getContext();
    if (localObject == null)
    {
      paramViewGroup = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(247815);
      throw paramViewGroup;
    }
    this.yai = ((m.b)new o(paramb, (MMActivity)localObject, this.yaC));
    paramb = this.yaC;
    if (paramb != null)
    {
      localObject = this.yai;
      if (localObject == null) {
        p.iCn();
      }
      paramb.onAttach(localObject);
    }
    paramb = com.tencent.mm.plugin.finder.live.utils.a.yRm;
    com.tencent.mm.plugin.finder.live.utils.a.a((d)this, true);
    this.ytM.setValue(b.ytS);
    this.ytN = ((View.OnLayoutChangeListener)new View.OnLayoutChangeListener()
    {
      public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
      {
        AppMethodBeat.i(285348);
        if ((paramAnonymousInt6 == paramAnonymousInt2) && (paramAnonymousInt8 == paramAnonymousInt4))
        {
          AppMethodBeat.o(285348);
          return;
        }
        Log.i(bk.a(this.ytR), "onLayoutChange: oldTop = " + paramAnonymousInt6 + ", oldBottom = " + paramAnonymousInt8 + ", top = " + paramAnonymousInt2 + ", bottom = " + paramAnonymousInt4);
        if ((paramAnonymousInt6 == 0) || ((bk.b)this.ytR.ytM.getValue() == bk.b.ytU))
        {
          paramAnonymousView = (bo)this.ytR.getPlugin(bo.class);
          float f;
          if (paramAnonymousView != null)
          {
            f = paramAnonymousView.dBZ();
            paramAnonymousView = (bo)this.ytR.getPlugin(bo.class);
            if (paramAnonymousView == null) {
              break label213;
            }
            paramAnonymousView = paramAnonymousView.yui;
            if (paramAnonymousView == null) {
              break label213;
            }
          }
          label213:
          for (paramAnonymousView = (bo.b)paramAnonymousView.getValue();; paramAnonymousView = null)
          {
            if ((paramAnonymousView != bo.b.yul) || (f <= 0.0F)) {
              break label218;
            }
            paramViewGroup.setY(f + bk.dBT());
            this.ytR.ytM.setValue(bk.b.ytU);
            AppMethodBeat.o(285348);
            return;
            f = 0.0F;
            break;
          }
          label218:
          paramViewGroup.setTranslationY(0.0F);
          this.ytR.ytM.setValue(bk.b.ytT);
          AppMethodBeat.o(285348);
          return;
        }
        this.ytR.ytM.setValue(this.ytR.ytM.getValue());
        AppMethodBeat.o(285348);
      }
    });
    Log.i(this.TAG, "enable :" + ((g)business(g.class)).zig + ",useUpdateStrategy:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfX);
    AppMethodBeat.o(247815);
  }
  
  private final void aCs(String paramString)
  {
    AppMethodBeat.i(247812);
    Object localObject = ((g)business(g.class)).zic;
    if (localObject != null) {}
    for (localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.l)localObject).xHW;; localObject = null)
    {
      if (localObject == null) {
        Log.i(this.TAG, paramString + " lotteryInfo is empty!");
      }
      AppMethodBeat.o(247812);
      return;
    }
  }
  
  public final boolean dAo()
  {
    return true;
  }
  
  public final void dBR()
  {
    AppMethodBeat.i(247807);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new d(this));
    AppMethodBeat.o(247807);
  }
  
  public final void dBS()
  {
    AppMethodBeat.i(247808);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new c(this));
    AppMethodBeat.o(247808);
  }
  
  public final float dxG()
  {
    AppMethodBeat.i(247810);
    float f1 = com.tencent.mm.ae.d.cE((View)this.kiF)[1];
    float f2 = this.kiF.getHeight();
    AppMethodBeat.o(247810);
    return f1 + f2;
  }
  
  public final void mount()
  {
    boolean bool2 = true;
    AppMethodBeat.i(247803);
    Object localObject1 = this.TAG;
    Object localObject2 = new StringBuilder("mount ").append(hashCode()).append(" presenter is empty:");
    if (this.yaC == null)
    {
      bool1 = true;
      localObject2 = ((StringBuilder)localObject2).append(bool1).append(",viewCallback is empty:");
      if (this.yai != null) {
        break label168;
      }
    }
    label168:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Log.i((String)localObject1, bool1);
      super.mount();
      if ((this.yaC != null) && (this.yai != null)) {
        break label197;
      }
      this.yaC = ((m.a)new n(getBuContext(), this.kCL));
      localObject1 = (View)this.kiF;
      localObject2 = this.kiF.getContext();
      if (localObject2 != null) {
        break label173;
      }
      localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(247803);
      throw ((Throwable)localObject1);
      bool1 = false;
      break;
    }
    label173:
    this.yai = ((m.b)new o((View)localObject1, (MMActivity)localObject2, this.yaC));
    label197:
    localObject1 = this.yaC;
    if (localObject1 != null)
    {
      localObject2 = this.yai;
      if (localObject2 == null) {
        p.iCn();
      }
      ((m.a)localObject1).onAttach(localObject2);
    }
    this.kiF.addOnLayoutChangeListener(this.ytN);
    AppMethodBeat.o(247803);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    boolean bool = false;
    AppMethodBeat.i(247806);
    p.k(paramc, "status");
    switch (bl.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    label219:
    label364:
    label496:
    do
    {
      AppMethodBeat.o(247806);
      return;
      paramc = (bo)getPlugin(bo.class);
      if (paramc != null)
      {
        paramc = paramc.yui;
        if (paramc != null)
        {
          paramBundle = this.kiF.getContext();
          if (paramBundle == null)
          {
            paramc = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(247806);
            throw paramc;
          }
          paramc.a((androidx.lifecycle.l)paramBundle, (s)new e(this));
          AppMethodBeat.o(247806);
          return;
        }
      }
      AppMethodBeat.o(247806);
      return;
      aCs("FINDER_LIVE_CREATE_LOTTERY_SUCCESS");
      dBR();
      AppMethodBeat.o(247806);
      return;
      aCs("FINDER_LIVE_CANCEL_LOTTERY_SUCCESS");
      dBR();
      AppMethodBeat.o(247806);
      return;
      float f;
      if (paramBundle != null)
      {
        bool = paramBundle.getBoolean("PARAM_FINDER_LIVE_LOTTERY_VISIBILITY_CACHE", false);
        this.ytO = bool;
        Log.i(this.TAG, "FINDER_LIVE_LOTTERY_BUBBLE_SHOW cacheVisibility:" + this.ytO + ",screenclear:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfm);
        aCs("FINDER_LIVE_LOTTERY_BUBBLE_SHOW cacheVisibility:" + this.ytO);
        if (!this.ytO) {
          break label478;
        }
        if (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfm)
        {
          this.yla = 65535;
          tU(this.ykZ);
        }
        if (this.kiF.getVisibility() == 0)
        {
          paramc = (bo)getPlugin(bo.class);
          if (paramc == null) {
            break label486;
          }
          f = paramc.dBZ();
          paramc = (bo)getPlugin(bo.class);
          if (paramc == null) {
            break label491;
          }
          paramc = paramc.yui;
          if (paramc == null) {
            break label491;
          }
          paramc = (bo.b)paramc.getValue();
          if ((paramc != bo.b.yul) || (f <= 0.0F) || (this.kiF.getTop() == 0)) {
            break label496;
          }
          this.kiF.setY(f + ytP);
          this.ytM.setValue(b.ytU);
        }
      }
      while (this.kCL.getLiveRole() == 0)
      {
        m.yCt.a(s.bm.yMN, "");
        AppMethodBeat.o(247806);
        return;
        bool = false;
        break label219;
        tU(0);
        break label334;
        f = 0.0F;
        break label364;
        paramc = null;
        break label396;
        this.kiF.setTranslationY(0.0F);
        this.ytM.setValue(b.ytT);
      }
      if (paramBundle != null) {
        bool = paramBundle.getBoolean("PARAM_FINDER_LIVE_LOTTERY_VISIBILITY_CACHE", false);
      }
      this.ytO = bool;
      Log.i(this.TAG, "FINDER_LIVE_LOTTERY_BUBBLE_HIDE cacheVisibility:" + this.ytO + ",screenclear:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfm);
      aCs("FINDER_LIVE_LOTTERY_BUBBLE_HIDE cacheVisibility:" + this.ytO);
      if (this.ytO)
      {
        this.yla = 8;
        tU(this.ykZ);
      }
      while (this.kiF.getVisibility() == 8)
      {
        this.ytM.setValue(b.ytS);
        AppMethodBeat.o(247806);
        return;
        tU(8);
      }
      aCs("FINDER_LIVE_LOTTERY_UPDATE");
      dBR();
      AppMethodBeat.o(247806);
      return;
      paramc = this.yaC;
    } while (paramc == null);
    label334:
    label478:
    label486:
    label491:
    paramc.onDetach();
    label396:
    AppMethodBeat.o(247806);
  }
  
  public final void tU(int paramInt)
  {
    AppMethodBeat.i(247814);
    com.tencent.mm.kernel.c.a locala = h.ae(com.tencent.mm.plugin.teenmode.a.b.class);
    p.j(locala, "MMKernel.service(ITeenModeService::class.java)");
    if (((com.tencent.mm.plugin.teenmode.a.b)locala).ZM())
    {
      this.kiF.setVisibility(8);
      Log.w(this.TAG, "setVisible return for isTeenMode");
      AppMethodBeat.o(247814);
      return;
    }
    super.tU(paramInt);
    AppMethodBeat.o(247814);
  }
  
  public final void unMount()
  {
    boolean bool2 = true;
    AppMethodBeat.i(247804);
    Object localObject = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("unMount ").append(hashCode()).append(" presenter is empty:");
    if (this.yaC == null)
    {
      bool1 = true;
      localStringBuilder = localStringBuilder.append(bool1).append(",viewCallback is empty:");
      if (this.yai != null) {
        break label125;
      }
    }
    label125:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Log.i((String)localObject, bool1);
      super.unMount();
      localObject = this.yaC;
      if (localObject != null) {
        ((m.a)localObject).onDetach();
      }
      this.kiF.removeOnLayoutChangeListener(this.ytN);
      AppMethodBeat.o(247804);
      return;
      bool1 = false;
      break;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveLotteryBubblePlugin$Companion;", "", "()V", "ON_LUCKY_MONEY_BUBBLE_SHOWN_TRANSLATION_Y", "", "TRANSLATION_DURATION", "", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveLotteryBubblePlugin$ShowingLocation;", "", "(Ljava/lang/String;I)V", "GONE", "DEFAULT_LOCATION", "TRANSLATED_LOCATION", "plugin-finder_release"})
  public static enum b
  {
    static
    {
      AppMethodBeat.i(276971);
      b localb1 = new b("GONE", 0);
      ytS = localb1;
      b localb2 = new b("DEFAULT_LOCATION", 1);
      ytT = localb2;
      b localb3 = new b("TRANSLATED_LOCATION", 2);
      ytU = localb3;
      ytV = new b[] { localb1, localb2, localb3 };
      AppMethodBeat.o(276971);
    }
    
    private b() {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<x>
  {
    c(bk parambk)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<x>
  {
    d(bk parambk)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveLuckyMoneyBubblePlugin$ShowingLocation;", "kotlin.jvm.PlatformType", "onChanged"})
  static final class e<T>
    implements s<bo.b>
  {
    e(bk parambk) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.bk
 * JD-Core Version:    0.7.0.1
 */