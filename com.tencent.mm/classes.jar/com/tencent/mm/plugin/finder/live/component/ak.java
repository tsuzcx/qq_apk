package com.tencent.mm.plugin.finder.live.component;

import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.graphics.PointF;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.live.p.c;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.plugin.ba.b;
import com.tencent.mm.plugin.finder.live.plugin.bc.b;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import org.libpag.PAGFile;
import org.libpag.PAGView;
import org.libpag.PAGView.PAGViewListener;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLuckyMoneyBubbleViewCallback;", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLuckyMoneyBubbleContract$ViewCallback;", "container", "Landroid/view/ViewGroup;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLuckyMoneyBubbleContract$Presenter;", "refPoint", "Landroid/graphics/PointF;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLuckyMoneyBubbleContract$Presenter;Landroid/graphics/PointF;)V", "animListener", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLuckyMoneyBubbleViewCallback$AnimListener;", "cntTv", "Landroid/widget/TextView;", "currentCnt", "", "isPagEnable", "", "kotlin.jvm.PlatformType", "Ljava/lang/Boolean;", "pagView", "Lorg/libpag/PAGView;", "rootView", "selfShowingLocation", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveLuckyMoneyBubblePlugin$ShowingLocation;", "getSelfShowingLocation", "()Landroidx/lifecycle/MutableLiveData;", "setSelfShowingLocation", "(Landroidx/lifecycle/MutableLiveData;)V", "getActivity", "Lcom/tencent/mm/ui/MMFragmentActivity;", "getBottomLocation", "", "getPresenter", "initView", "", "release", "reset", "updateLotteryStatus", "showingLocation", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveLotteryBubblePlugin$ShowingLocation;", "updateLuckyMoneyCount", "count", "updateRefPoint", "AnimListener", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ak
  implements ai.c
{
  public static final ak.b CAi;
  private static final float CAr;
  private static final float CAs;
  private static final float CAt;
  private final ViewGroup CAj;
  private final ai.b CAk;
  private final PointF CAl;
  private TextView CAm;
  private PAGView CAn;
  private a CAo;
  private int CAp;
  public x<bc.b> CAq;
  private final Boolean CyU;
  private final MMActivity activity;
  private final ViewGroup pzj;
  
  static
  {
    AppMethodBeat.i(352806);
    CAi = new ak.b((byte)0);
    CAr = -MMApplicationContext.getResources().getDimension(p.c.Edge_0_5_A);
    CAs = -MMApplicationContext.getResources().getDimension(p.c.Edge_0_5_A);
    CAt = -MMApplicationContext.getResources().getDimension(p.c.Edge_0_5_A);
    AppMethodBeat.o(352806);
  }
  
  public ak(ViewGroup paramViewGroup, MMActivity paramMMActivity, ai.b paramb, PointF paramPointF)
  {
    AppMethodBeat.i(352764);
    this.CAj = paramViewGroup;
    this.activity = paramMMActivity;
    this.CAk = paramb;
    this.CAl = paramPointF;
    this.CyU = ((cn)h.az(cn.class)).isPagEnable();
    Log.i("Finder.FinderLiveLuckyMoneyBubbleViewCallback", s.X("init: refPoint:", this.CAl));
    paramViewGroup = aw.Gjk;
    aw.aBW("FinderLiveLuckyMoneyBubbleViewCallback");
    paramViewGroup = LayoutInflater.from(this.CAj.getContext()).inflate(p.f.CeB, this.CAj, false);
    if (paramViewGroup == null)
    {
      paramViewGroup = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(352764);
      throw paramViewGroup;
    }
    this.pzj = ((ViewGroup)paramViewGroup);
    this.CAj.addView((View)this.pzj);
    this.pzj.setTranslationX(this.CAl.x + CAs);
    this.pzj.setTranslationY(this.CAl.y + CAr);
    AppMethodBeat.o(352764);
  }
  
  private static final void a(ak paramak, View paramView)
  {
    AppMethodBeat.i(352773);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramak);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/component/FinderLiveLuckyMoneyBubbleViewCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramak, "this$0");
    paramak = paramak.CAk;
    if (paramak != null) {
      paramak.eij();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/component/FinderLiveLuckyMoneyBubbleViewCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(352773);
  }
  
  public final void OI(int paramInt)
  {
    AppMethodBeat.i(352851);
    Log.i("Finder.FinderLiveLuckyMoneyBubbleViewCallback", "updateLuckyMoneyCount: count:" + paramInt + ", currentCnt=" + this.CAp + ", pagView:" + this.CAn + ", isPagEnable:" + this.CyU + ", refPoint:" + this.CAl);
    Object localObject = this.CAn;
    if ((localObject != null) && (((PAGView)localObject).isPlaying() == true)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject = this.CAn;
        if (localObject != null) {
          ((PAGView)localObject).stop();
        }
      }
      localObject = this.CAn;
      if (localObject != null) {
        ((PAGView)localObject).removeListener((PAGView.PAGViewListener)this.CAo);
      }
      if (paramInt > 0) {
        break;
      }
      this.pzj.setVisibility(8);
      localObject = this.CAq;
      if (localObject != null) {
        ((x)localObject).setValue(bc.b.DeI);
      }
      AppMethodBeat.o(352851);
      return;
    }
    PAGView localPAGView;
    label227:
    float f;
    if (paramInt == 1)
    {
      localPAGView = this.CAn;
      if (localPAGView != null)
      {
        localObject = PAGFile.Load(this.activity.getAssets(), "finder_live_lucky_money_section_1.pag");
        localPAGView.setFile((PAGFile)localObject);
      }
      this.CAp = paramInt;
      localObject = this.CAn;
      if (localObject != null) {
        ((PAGView)localObject).setRepeatCount(1);
      }
      localObject = this.CAn;
      if (localObject != null) {
        ((PAGView)localObject).play();
      }
      localObject = this.CAn;
      if (localObject != null) {
        ((PAGView)localObject).addListener((PAGView.PAGViewListener)this.CAo);
      }
      if ((this.pzj.getVisibility() != 0) && (this.CAq != null))
      {
        localObject = this.CAk;
        if (localObject != null) {
          break label499;
        }
        localObject = null;
        label319:
        if (localObject != ba.b.Deo) {
          break label520;
        }
        localObject = this.CAk.eiH();
        if (localObject != null) {
          break label511;
        }
        f = 0.0F;
        label345:
        this.pzj.setTranslationY(f + CAt);
        localObject = this.CAq;
        if (localObject != null) {
          ((x)localObject).setValue(bc.b.DeK);
        }
      }
      label376:
      this.pzj.setVisibility(0);
      localObject = this.CAm;
      if (localObject != null) {
        ((TextView)localObject).setText((CharSequence)s.X("x", Integer.valueOf(paramInt)));
      }
      localObject = this.CAm;
      if (localObject != null) {
        if (paramInt != 1) {
          break label560;
        }
      }
    }
    label520:
    label560:
    for (paramInt = 8;; paramInt = 0)
    {
      ((TextView)localObject).setVisibility(paramInt);
      AppMethodBeat.o(352851);
      return;
      localPAGView = this.CAn;
      if (localPAGView == null) {
        break label227;
      }
      if (this.CAp <= 0)
      {
        localObject = PAGFile.Load(this.activity.getAssets(), "finder_live_lucky_money_complete.pag");
        break;
      }
      localObject = PAGFile.Load(this.activity.getAssets(), "finder_live_lucky_money_section_2.pag");
      break;
      label499:
      localObject = ((ai.b)localObject).eiG();
      break label319;
      label511:
      f = ((Float)localObject).floatValue();
      break label345;
      this.pzj.setTranslationY(this.CAl.y + CAr);
      localObject = this.CAq;
      if (localObject == null) {
        break label376;
      }
      ((x)localObject).setValue(bc.b.DeJ);
      break label376;
    }
  }
  
  public final void a(ba.b paramb)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    AppMethodBeat.i(352861);
    s.u(paramb, "showingLocation");
    switch (c.$EnumSwitchMapping$0[paramb.ordinal()])
    {
    default: 
      AppMethodBeat.o(352861);
      return;
    case 1: 
      paramb = this.CAq;
      if (paramb == null) {}
      for (paramb = localObject1; paramb == bc.b.DeK; paramb = (bc.b)paramb.getValue())
      {
        ObjectAnimator.ofFloat(this.pzj, "translationY", new float[] { this.pzj.getTranslationY(), this.CAl.y + CAr }).setDuration(500L).start();
        paramb = this.CAq;
        if (paramb == null) {
          break;
        }
        paramb.setValue(bc.b.DeJ);
        AppMethodBeat.o(352861);
        return;
      }
    }
    paramb = this.CAq;
    label165:
    float f;
    if (paramb == null)
    {
      paramb = localObject2;
      if (paramb != bc.b.DeK) {
        break label207;
      }
      paramb = this.CAk;
      if (paramb != null) {
        break label209;
      }
      f = 0.0F;
    }
    for (;;)
    {
      this.pzj.setTranslationY(f + CAt);
      break;
      paramb = (bc.b)paramb.getValue();
      break label165;
      label207:
      break;
      label209:
      paramb = paramb.eiH();
      if (paramb == null) {
        f = 0.0F;
      } else {
        f = paramb.floatValue();
      }
    }
  }
  
  public final void b(PointF paramPointF)
  {
    AppMethodBeat.i(352820);
    s.u(paramPointF, "refPoint");
    Log.i("Finder.FinderLiveLuckyMoneyBubbleViewCallback", s.X("updateRefPoint refPoint:", paramPointF));
    this.CAl.set(paramPointF);
    this.pzj.setTranslationX(this.CAl.x + CAs);
    this.pzj.setTranslationY(this.CAl.y + CAr);
    AppMethodBeat.o(352820);
  }
  
  public final MMFragmentActivity dUP()
  {
    return (MMFragmentActivity)this.activity;
  }
  
  public final float eiI()
  {
    AppMethodBeat.i(352868);
    float f1 = this.pzj.getY();
    float f2 = this.pzj.getHeight();
    AppMethodBeat.o(352868);
    return f1 + f2;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(352831);
    this.CAm = ((TextView)this.pzj.findViewById(p.e.BCn));
    Object localObject = this.CAm;
    if (localObject != null) {
      ((TextView)localObject).setTextSize(1, 22.0F);
    }
    localObject = this.CAm;
    if (localObject != null)
    {
      com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      com.tencent.mm.plugin.finder.live.utils.a.v((TextView)localObject);
    }
    this.CAn = ((PAGView)this.pzj.findViewById(p.e.BXR));
    this.CAo = new a(this);
    localObject = this.CAn;
    if (localObject != null) {
      ((PAGView)localObject).addListener((PAGView.PAGViewListener)this.CAo);
    }
    localObject = this.CAn;
    if (localObject != null) {
      ((PAGView)localObject).setOnClickListener(new ak..ExternalSyntheticLambda0(this));
    }
    AppMethodBeat.o(352831);
  }
  
  public final void release()
  {
    AppMethodBeat.i(352836);
    d.uiThread((kotlin.g.a.a)new d(this));
    AppMethodBeat.o(352836);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLuckyMoneyBubbleViewCallback$AnimListener;", "Lorg/libpag/PAGView$PAGViewListener;", "viewCallback", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLuckyMoneyBubbleViewCallback;", "(Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLuckyMoneyBubbleViewCallback;)V", "rViewCallback", "Ljava/lang/ref/WeakReference;", "getRViewCallback", "()Ljava/lang/ref/WeakReference;", "setRViewCallback", "(Ljava/lang/ref/WeakReference;)V", "onAnimationCancel", "", "view", "Lorg/libpag/PAGView;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements PAGView.PAGViewListener
  {
    private WeakReference<ak> CAu;
    
    public a(ak paramak)
    {
      AppMethodBeat.i(352681);
      this.CAu = new WeakReference(paramak);
      AppMethodBeat.o(352681);
    }
    
    public final void onAnimationCancel(PAGView paramPAGView) {}
    
    public final void onAnimationEnd(PAGView paramPAGView)
    {
      AppMethodBeat.i(352694);
      ak localak = (ak)this.CAu.get();
      boolean bool;
      PAGView localPAGView;
      if (localak == null)
      {
        bool = true;
        Log.i("Finder.FinderLiveLuckyMoneyBubbleViewCallback", s.X("onAnimationEnd emptyViewCallback:", Boolean.valueOf(bool)));
        if (localak != null)
        {
          localPAGView = ak.c(localak);
          if (localPAGView != null) {
            if (ak.d(localak) != 1) {
              break label133;
            }
          }
        }
      }
      label133:
      for (paramPAGView = PAGFile.Load(ak.e(localak).getAssets(), "finder_live_lucky_money_repeated_1.pag");; paramPAGView = PAGFile.Load(ak.e(localak).getAssets(), "finder_live_lucky_money_repeated_2.pag"))
      {
        localPAGView.setFile(paramPAGView);
        paramPAGView = ak.c(localak);
        if (paramPAGView != null) {
          paramPAGView.removeListener((PAGView.PAGViewListener)this);
        }
        paramPAGView = ak.c(localak);
        if (paramPAGView != null) {
          paramPAGView.setRepeatCount(0);
        }
        paramPAGView = ak.c(localak);
        if (paramPAGView != null) {
          paramPAGView.play();
        }
        AppMethodBeat.o(352694);
        return;
        bool = false;
        break;
      }
    }
    
    public final void onAnimationRepeat(PAGView paramPAGView) {}
    
    public final void onAnimationStart(PAGView paramPAGView) {}
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(ak paramak)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.ak
 * JD-Core Version:    0.7.0.1
 */