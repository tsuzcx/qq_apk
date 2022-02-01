package com.tencent.mm.plugin.finder.live.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.ui.widget.seekbar.BothSidesSeekBar;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulDetailsView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "adapter", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulDetailsView$BeautyAdapter;", "value", "", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulDetailsView$EffectInfo;", "effectItems", "getEffectItems", "()Ljava/util/List;", "setEffectItems", "(Ljava/util/List;)V", "onRequestDefaultSeekByKey", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "key", "getOnRequestDefaultSeekByKey", "()Lkotlin/jvm/functions/Function1;", "setOnRequestDefaultSeekByKey", "(Lkotlin/jvm/functions/Function1;)V", "onRequestReset", "Lkotlin/Function0;", "", "getOnRequestReset", "()Lkotlin/jvm/functions/Function0;", "setOnRequestReset", "(Lkotlin/jvm/functions/Function0;)V", "onRequestSeekByKey", "getOnRequestSeekByKey", "setOnRequestSeekByKey", "onSeekChanging", "Lkotlin/Function2;", "seek", "getOnSeekChanging", "()Lkotlin/jvm/functions/Function2;", "setOnSeekChanging", "(Lkotlin/jvm/functions/Function2;)V", "onSeekDone", "getOnSeekDone", "setOnSeekDone", "selectedEffect", "getSelectedEffect", "()Lcom/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulDetailsView$EffectInfo;", "setSelectedEffect", "(Lcom/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulDetailsView$EffectInfo;)V", "visibilityAnimator", "Landroid/animation/Animator;", "hideSelf", "isAnimator", "", "reload", "setAndMoveDefaultValueIcon", "progress", "setAndMoveSeekValueText", "showSelf", "transRealValueToViewProgress", "realValue", "isBothSides", "viewProgressMax", "transViewProgressToRealValue", "BeautyAdapter", "CameraOptBeautyViewHolder", "Companion", "EffectInfo", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveCameraOptBeautyPowerfulDetailsView
  extends RelativeLayout
{
  public static final FinderLiveCameraOptBeautyPowerfulDetailsView.c DLr;
  private kotlin.g.a.a<ah> DLA;
  private final FinderLiveCameraOptBeautyPowerfulDetailsView.a DLs;
  public Animator DLt;
  private FinderLiveCameraOptBeautyPowerfulDetailsView.d DLu;
  private List<FinderLiveCameraOptBeautyPowerfulDetailsView.d> DLv;
  private kotlin.g.a.b<? super Integer, Integer> DLw;
  private kotlin.g.a.b<? super Integer, Integer> DLx;
  private m<? super Integer, ? super Integer, ah> DLy;
  private m<? super Integer, ? super Integer, ah> DLz;
  
  static
  {
    AppMethodBeat.i(357887);
    DLr = new FinderLiveCameraOptBeautyPowerfulDetailsView.c((byte)0);
    AppMethodBeat.o(357887);
  }
  
  public FinderLiveCameraOptBeautyPowerfulDetailsView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, (byte)0);
    AppMethodBeat.i(357843);
    AppMethodBeat.o(357843);
  }
  
  public FinderLiveCameraOptBeautyPowerfulDetailsView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(357797);
    this.DLs = new FinderLiveCameraOptBeautyPowerfulDetailsView.a(this);
    this.DLv = ((List)new ArrayList());
    View.inflate(paramContext, p.f.Cdf, (ViewGroup)this);
    rW(false);
    paramAttributeSet = (RecyclerView)findViewById(p.e.BHK);
    paramAttributeSet.setAdapter((RecyclerView.a)this.DLs);
    paramAttributeSet.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(0, false));
    ((BothSidesSeekBar)findViewById(p.e.BHL)).setOnSeekBarChangeListener((SeekBar.OnSeekBarChangeListener)new SeekBar.OnSeekBarChangeListener()
    {
      public final void onProgressChanged(SeekBar paramAnonymousSeekBar, int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        int i = 0;
        AppMethodBeat.i(357485);
        FinderLiveCameraOptBeautyPowerfulDetailsView.d locald = this.DLB.getSelectedEffect();
        boolean bool;
        if (locald == null)
        {
          bool = false;
          if (paramAnonymousSeekBar != null) {
            break label117;
          }
          label29:
          i = FinderLiveCameraOptBeautyPowerfulDetailsView.h(paramAnonymousInt, bool, i);
          locald = this.DLB.getSelectedEffect();
          if (locald != null)
          {
            paramAnonymousSeekBar = this.DLB.getOnSeekChanging();
            if (paramAnonymousSeekBar != null) {
              if (!paramAnonymousBoolean) {
                break label126;
              }
            }
          }
        }
        for (;;)
        {
          if (paramAnonymousSeekBar != null) {
            paramAnonymousSeekBar.invoke(Integer.valueOf(locald.DLC), Integer.valueOf(i));
          }
          FinderLiveCameraOptBeautyPowerfulDetailsView.a(this.DLB, paramAnonymousInt);
          AppMethodBeat.o(357485);
          return;
          bool = locald.DLD;
          break;
          label117:
          i = paramAnonymousSeekBar.getMax();
          break label29;
          label126:
          paramAnonymousSeekBar = null;
        }
      }
      
      public final void onStartTrackingTouch(SeekBar paramAnonymousSeekBar) {}
      
      public final void onStopTrackingTouch(SeekBar paramAnonymousSeekBar)
      {
        boolean bool = false;
        int i = 0;
        AppMethodBeat.i(357497);
        if (paramAnonymousSeekBar == null)
        {
          Log.i("Finder.FinderLiveCameraOptBeautyPowerfulDetailsView", s.X("#onStopTrackingTouch progress=", Integer.valueOf(i)));
          paramAnonymousSeekBar = this.DLB.getSelectedEffect();
          if (paramAnonymousSeekBar != null)
          {
            localObject = this.DLB.getOnSeekDone();
            if (localObject != null) {
              ((m)localObject).invoke(Integer.valueOf(paramAnonymousSeekBar.DLC), Integer.valueOf(i));
            }
          }
          AppMethodBeat.o(357497);
          return;
        }
        Object localObject = this.DLB;
        i = paramAnonymousSeekBar.getProgress();
        localObject = ((FinderLiveCameraOptBeautyPowerfulDetailsView)localObject).getSelectedEffect();
        if (localObject == null) {}
        for (;;)
        {
          i = FinderLiveCameraOptBeautyPowerfulDetailsView.h(i, bool, paramAnonymousSeekBar.getMax());
          break;
          bool = ((FinderLiveCameraOptBeautyPowerfulDetailsView.d)localObject).DLD;
        }
      }
    });
    findViewById(p.e.BHI).setOnClickListener(new FinderLiveCameraOptBeautyPowerfulDetailsView..ExternalSyntheticLambda0(paramContext, this));
    AppMethodBeat.o(357797);
  }
  
  private static final void U(boolean paramBoolean, String paramString) {}
  
  private static final void a(Context paramContext, FinderLiveCameraOptBeautyPowerfulDetailsView paramFinderLiveCameraOptBeautyPowerfulDetailsView, View paramView)
  {
    AppMethodBeat.i(357869);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramContext);
    localb.cH(paramFinderLiveCameraOptBeautyPowerfulDetailsView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulDetailsView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramContext, "$context");
    s.u(paramFinderLiveCameraOptBeautyPowerfulDetailsView, "this$0");
    paramView = new g.a(paramContext);
    paramView.bDJ(paramContext.getString(p.h.Cnr));
    paramView.bDI(paramContext.getString(p.h.Cnv));
    paramView.bDE(paramContext.getString(p.h.Cns));
    paramView.a(FinderLiveCameraOptBeautyPowerfulDetailsView..ExternalSyntheticLambda2.INSTANCE, new FinderLiveCameraOptBeautyPowerfulDetailsView..ExternalSyntheticLambda1(paramFinderLiveCameraOptBeautyPowerfulDetailsView, paramContext)).jHM().show();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulDetailsView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(357869);
  }
  
  private static final void a(FinderLiveCameraOptBeautyPowerfulDetailsView paramFinderLiveCameraOptBeautyPowerfulDetailsView, Context paramContext, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(357859);
    s.u(paramFinderLiveCameraOptBeautyPowerfulDetailsView, "this$0");
    s.u(paramContext, "$context");
    paramFinderLiveCameraOptBeautyPowerfulDetailsView = paramFinderLiveCameraOptBeautyPowerfulDetailsView.getOnRequestReset();
    if (paramFinderLiveCameraOptBeautyPowerfulDetailsView != null) {
      paramFinderLiveCameraOptBeautyPowerfulDetailsView.invoke();
    }
    com.tencent.mm.ui.base.k.cZ(paramContext, paramContext.getString(p.h.Cnu));
    AppMethodBeat.o(357859);
  }
  
  private static int f(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(357830);
    float f = paramInt2 / 2.0F;
    Object localObject;
    if (paramBoolean) {
      if (paramInt1 < f) {
        localObject = Float.valueOf(paramInt1 / f * 100.0F - 100.0F);
      }
    }
    for (;;)
    {
      paramInt1 = ((Number)localObject).intValue();
      AppMethodBeat.o(357830);
      return paramInt1;
      if (paramInt1 > f)
      {
        localObject = Float.valueOf((paramInt1 - f) / f * 100.0F);
      }
      else
      {
        localObject = Integer.valueOf(0);
        continue;
        localObject = Float.valueOf(paramInt1 / paramInt2 * 100.0F);
      }
    }
  }
  
  private static int g(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    float f1 = paramInt2 / 2.0F;
    float f2;
    if (paramBoolean)
    {
      f2 = f1 / 100.0F;
      if (paramInt1 != 0) {}
    }
    for (;;)
    {
      return (int)f1;
      f1 += f2 * paramInt1;
      continue;
      f1 = paramInt2 / 100.0F * paramInt1;
    }
  }
  
  private final void setAndMoveDefaultValueIcon(int paramInt)
  {
    AppMethodBeat.i(357823);
    BothSidesSeekBar localBothSidesSeekBar = (BothSidesSeekBar)findViewById(p.e.BHL);
    ImageView localImageView = (ImageView)findViewById(p.e.BHM);
    int i = localBothSidesSeekBar.getWidth();
    int j = localImageView.getWidth();
    float f = paramInt / localBothSidesSeekBar.getMax();
    f = (localBothSidesSeekBar.getMeasuredWidth() - localBothSidesSeekBar.getPaddingStart() - localBothSidesSeekBar.getPaddingEnd()) * f;
    Log.i("Finder.FinderLiveCameraOptBeautyPowerfulDetailsView", "#setAndMoveDefaultValueIcon progress:" + paramInt + " translationX:" + f);
    localImageView.setTranslationX(kotlin.k.k.bu(f, i - j));
    AppMethodBeat.o(357823);
  }
  
  private final void setAndMoveSeekValueText(int paramInt)
  {
    AppMethodBeat.i(357813);
    BothSidesSeekBar localBothSidesSeekBar = (BothSidesSeekBar)findViewById(p.e.BHL);
    TextView localTextView = (TextView)findViewById(p.e.BHN);
    int i = localBothSidesSeekBar.getWidth();
    int j = localTextView.getWidth();
    float f = paramInt / localBothSidesSeekBar.getMax();
    f = (localBothSidesSeekBar.getMeasuredWidth() - localBothSidesSeekBar.getPaddingStart() - localBothSidesSeekBar.getPaddingEnd()) * f;
    Log.i("Finder.FinderLiveCameraOptBeautyPowerfulDetailsView", "#setAndMoveSeekValueText progress:" + paramInt + " translationX:" + f);
    FinderLiveCameraOptBeautyPowerfulDetailsView.d locald = this.DLu;
    if (locald == null) {}
    for (boolean bool = false;; bool = locald.DLD)
    {
      localTextView.setText((CharSequence)String.valueOf(f(paramInt, bool, localBothSidesSeekBar.getMax())));
      localTextView.setTranslationX(kotlin.k.k.bu(f, i - j));
      AppMethodBeat.o(357813);
      return;
    }
  }
  
  public final List<FinderLiveCameraOptBeautyPowerfulDetailsView.d> getEffectItems()
  {
    return this.DLv;
  }
  
  public final kotlin.g.a.b<Integer, Integer> getOnRequestDefaultSeekByKey()
  {
    return this.DLx;
  }
  
  public final kotlin.g.a.a<ah> getOnRequestReset()
  {
    return this.DLA;
  }
  
  public final kotlin.g.a.b<Integer, Integer> getOnRequestSeekByKey()
  {
    return this.DLw;
  }
  
  public final m<Integer, Integer, ah> getOnSeekChanging()
  {
    return this.DLy;
  }
  
  public final m<Integer, Integer, ah> getOnSeekDone()
  {
    return this.DLz;
  }
  
  public final FinderLiveCameraOptBeautyPowerfulDetailsView.d getSelectedEffect()
  {
    return this.DLu;
  }
  
  public final void rW(boolean paramBoolean)
  {
    AppMethodBeat.i(358006);
    Log.i("Finder.FinderLiveCameraOptBeautyPowerfulDetailsView", s.X("#hideSelf isAnimator=", Boolean.valueOf(paramBoolean)));
    Object localObject = this.DLt;
    if ((localObject != null) && (((Animator)localObject).isRunning() == true)) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.i("Finder.FinderLiveCameraOptBeautyPowerfulDetailsView", "#hideSelf visibilityAnimator isRunning");
      AppMethodBeat.o(358006);
      return;
    }
    if (!paramBoolean)
    {
      setVisibility(8);
      AppMethodBeat.o(358006);
      return;
    }
    localObject = ObjectAnimator.ofFloat(this, "alpha", new float[] { 1.0F, 0.0F });
    ((ObjectAnimator)localObject).addListener((Animator.AnimatorListener)new e(this));
    ((ObjectAnimator)localObject).start();
    ah localah = ah.aiuX;
    this.DLt = ((Animator)localObject);
    AppMethodBeat.o(358006);
  }
  
  public final void reload()
  {
    AppMethodBeat.i(357996);
    Log.i("Finder.FinderLiveCameraOptBeautyPowerfulDetailsView", "#reload");
    setSelectedEffect(this.DLu);
    AppMethodBeat.o(357996);
  }
  
  public final void setEffectItems(List<FinderLiveCameraOptBeautyPowerfulDetailsView.d> paramList)
  {
    AppMethodBeat.i(357939);
    s.u(paramList, "value");
    this.DLv.clear();
    this.DLv.addAll((Collection)paramList);
    setSelectedEffect((FinderLiveCameraOptBeautyPowerfulDetailsView.d)p.oL(this.DLv));
    this.DLs.bZE.notifyChanged();
    AppMethodBeat.o(357939);
  }
  
  public final void setOnRequestDefaultSeekByKey(kotlin.g.a.b<? super Integer, Integer> paramb)
  {
    this.DLx = paramb;
  }
  
  public final void setOnRequestReset(kotlin.g.a.a<ah> parama)
  {
    this.DLA = parama;
  }
  
  public final void setOnRequestSeekByKey(kotlin.g.a.b<? super Integer, Integer> paramb)
  {
    this.DLw = paramb;
  }
  
  public final void setOnSeekChanging(m<? super Integer, ? super Integer, ah> paramm)
  {
    this.DLy = paramm;
  }
  
  public final void setOnSeekDone(m<? super Integer, ? super Integer, ah> paramm)
  {
    this.DLz = paramm;
  }
  
  public final void setSelectedEffect(FinderLiveCameraOptBeautyPowerfulDetailsView.d paramd)
  {
    AppMethodBeat.i(357925);
    Log.i("Finder.FinderLiveCameraOptBeautyPowerfulDetailsView", s.X("#selectedEffect set ", paramd));
    this.DLu = paramd;
    this.DLs.bZE.notifyChanged();
    paramd = this.DLu;
    if (paramd != null)
    {
      Object localObject = getOnRequestSeekByKey();
      int i;
      if (localObject != null)
      {
        localObject = (Integer)((kotlin.g.a.b)localObject).invoke(Integer.valueOf(paramd.DLC));
        if (localObject != null)
        {
          i = ((Number)localObject).intValue();
          Log.i("Finder.FinderLiveCameraOptBeautyPowerfulDetailsView", s.X("#selectedEffect set onRequestSeekByKey ", Integer.valueOf(i)));
          localObject = (BothSidesSeekBar)findViewById(p.e.BHL);
          if (localObject != null)
          {
            ((BothSidesSeekBar)localObject).setBothSidesMode(paramd.DLD);
            ((BothSidesSeekBar)localObject).setProgress(g(i, paramd.DLD, ((BothSidesSeekBar)localObject).getMax()));
            setAndMoveSeekValueText(((BothSidesSeekBar)localObject).getProgress());
          }
        }
      }
      localObject = getOnRequestDefaultSeekByKey();
      if (localObject != null)
      {
        localObject = (Integer)((kotlin.g.a.b)localObject).invoke(Integer.valueOf(paramd.DLC));
        if (localObject != null)
        {
          i = ((Number)localObject).intValue();
          Log.i("Finder.FinderLiveCameraOptBeautyPowerfulDetailsView", s.X("#selectedEffect set onRequestDefaultSeekByKey ", Integer.valueOf(i)));
          localObject = (BothSidesSeekBar)findViewById(p.e.BHL);
          if (localObject != null) {
            setAndMoveDefaultValueIcon(g(i, paramd.DLD, ((BothSidesSeekBar)localObject).getMax()));
          }
        }
      }
    }
    AppMethodBeat.o(357925);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulDetailsView$hideSelf$1$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "onAnimationStart", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    extends AnimatorListenerAdapter
  {
    e(FinderLiveCameraOptBeautyPowerfulDetailsView paramFinderLiveCameraOptBeautyPowerfulDetailsView) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(357537);
      super.onAnimationEnd(paramAnimator);
      this.DLB.setVisibility(8);
      AppMethodBeat.o(357537);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(357530);
      super.onAnimationStart(paramAnimator);
      AppMethodBeat.o(357530);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulDetailsView$showSelf$1$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "onAnimationStart", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    extends AnimatorListenerAdapter
  {
    public f(FinderLiveCameraOptBeautyPowerfulDetailsView paramFinderLiveCameraOptBeautyPowerfulDetailsView) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(357546);
      super.onAnimationEnd(paramAnimator);
      this.DLB.setAlpha(1.0F);
      this.DLB.reload();
      AppMethodBeat.o(357546);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(357541);
      super.onAnimationStart(paramAnimator);
      this.DLB.setAlpha(0.0F);
      this.DLB.setVisibility(0);
      AppMethodBeat.o(357541);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.FinderLiveCameraOptBeautyPowerfulDetailsView
 * JD-Core Version:    0.7.0.1
 */