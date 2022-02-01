package com.tencent.mm.plugin.finder.live.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
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

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulDetailsViewV2;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "adapter", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulDetailsViewV2$BeautyAdapter;", "btnResetLayout", "Landroid/view/View;", "btnResetTextLayout", "value", "", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulDetailsViewV2$EffectInfo;", "effectItems", "getEffectItems", "()Ljava/util/List;", "setEffectItems", "(Ljava/util/List;)V", "onBackClick", "Lkotlin/Function0;", "", "getOnBackClick", "()Lkotlin/jvm/functions/Function0;", "setOnBackClick", "(Lkotlin/jvm/functions/Function0;)V", "onRequestCheckIsDefault", "", "getOnRequestCheckIsDefault", "setOnRequestCheckIsDefault", "onRequestDefaultSeekByKey", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "key", "getOnRequestDefaultSeekByKey", "()Lkotlin/jvm/functions/Function1;", "setOnRequestDefaultSeekByKey", "(Lkotlin/jvm/functions/Function1;)V", "onRequestReset", "getOnRequestReset", "setOnRequestReset", "onRequestSeekByKey", "getOnRequestSeekByKey", "setOnRequestSeekByKey", "onSeekChanging", "Lkotlin/Function2;", "seek", "getOnSeekChanging", "()Lkotlin/jvm/functions/Function2;", "setOnSeekChanging", "(Lkotlin/jvm/functions/Function2;)V", "onSeekDone", "getOnSeekDone", "setOnSeekDone", "parentView", "seekBar", "Lcom/tencent/mm/ui/widget/seekbar/BothSidesSeekBar;", "selectedEffect", "getSelectedEffect", "()Lcom/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulDetailsViewV2$EffectInfo;", "setSelectedEffect", "(Lcom/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulDetailsViewV2$EffectInfo;)V", "visibilityAnimator", "Landroid/animation/Animator;", "executeVisibleAnimator", "isHide", "hideSelf", "isAnimator", "reload", "reloadResetTextLayout", "setAndMoveDefaultValueIcon", "progress", "setAndMoveSeekValueText", "showSelf", "transRealValueToViewProgress", "realValue", "isBothSides", "viewProgressMax", "transViewProgressToRealValue", "BeautyAdapter", "CameraOptBeautyViewHolder", "Companion", "EffectInfo", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveCameraOptBeautyPowerfulDetailsViewV2
  extends RelativeLayout
{
  public static final FinderLiveCameraOptBeautyPowerfulDetailsViewV2.c DLE;
  private kotlin.g.a.a<ah> DLA;
  private final FinderLiveCameraOptBeautyPowerfulDetailsViewV2.a DLF;
  private FinderLiveCameraOptBeautyPowerfulDetailsViewV2.d DLG;
  private kotlin.g.a.a<Boolean> DLH;
  private kotlin.g.a.a<ah> DLI;
  private View DLJ;
  private View DLK;
  private BothSidesSeekBar DLL;
  private Animator DLt;
  private List<FinderLiveCameraOptBeautyPowerfulDetailsViewV2.d> DLv;
  private kotlin.g.a.b<? super Integer, Integer> DLw;
  private kotlin.g.a.b<? super Integer, Integer> DLx;
  private m<? super Integer, ? super Integer, ah> DLy;
  private m<? super Integer, ? super Integer, ah> DLz;
  private View uJh;
  
  static
  {
    AppMethodBeat.i(358150);
    DLE = new FinderLiveCameraOptBeautyPowerfulDetailsViewV2.c((byte)0);
    AppMethodBeat.o(358150);
  }
  
  public FinderLiveCameraOptBeautyPowerfulDetailsViewV2(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, (byte)0);
    AppMethodBeat.i(358071);
    AppMethodBeat.o(358071);
  }
  
  public FinderLiveCameraOptBeautyPowerfulDetailsViewV2(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(358001);
    this.DLF = new FinderLiveCameraOptBeautyPowerfulDetailsViewV2.a(this);
    this.DLv = ((List)new ArrayList());
    paramAttributeSet = View.inflate(paramContext, p.f.Cdh, (ViewGroup)this);
    s.s(paramAttributeSet, "inflate(context, R.layou…el_details_view_v2, this)");
    this.uJh = paramAttributeSet;
    rW(false);
    paramAttributeSet = findViewById(p.e.BHJ);
    s.s(paramAttributeSet, "findViewById(R.id.finder…etails_reset_text_layout)");
    this.DLK = paramAttributeSet;
    paramAttributeSet = findViewById(p.e.BHL);
    s.s(paramAttributeSet, "findViewById(\n          …etails_seek_bar\n        )");
    this.DLL = ((BothSidesSeekBar)paramAttributeSet);
    paramAttributeSet = (RecyclerView)findViewById(p.e.BHK);
    paramAttributeSet.setAdapter((RecyclerView.a)this.DLF);
    paramAttributeSet.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(0, false));
    this.DLL.setOnSeekBarChangeListener((SeekBar.OnSeekBarChangeListener)new SeekBar.OnSeekBarChangeListener()
    {
      public final void onProgressChanged(SeekBar paramAnonymousSeekBar, int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        int i = 0;
        AppMethodBeat.i(357926);
        FinderLiveCameraOptBeautyPowerfulDetailsViewV2.d locald = this.DLM.getSelectedEffect();
        boolean bool;
        if (locald == null)
        {
          bool = false;
          if (paramAnonymousSeekBar != null) {
            break label128;
          }
          label29:
          i = FinderLiveCameraOptBeautyPowerfulDetailsViewV2.i(paramAnonymousInt, bool, i);
          locald = this.DLM.getSelectedEffect();
          if (locald != null)
          {
            paramAnonymousSeekBar = this.DLM.getOnSeekChanging();
            if (paramAnonymousSeekBar != null) {
              if (!paramAnonymousBoolean) {
                break label137;
              }
            }
          }
        }
        for (;;)
        {
          if (paramAnonymousSeekBar != null) {
            paramAnonymousSeekBar.invoke(Integer.valueOf(locald.DLC), Integer.valueOf(i));
          }
          FinderLiveCameraOptBeautyPowerfulDetailsViewV2.a(this.DLM, paramAnonymousInt);
          if (!paramAnonymousBoolean) {
            FinderLiveCameraOptBeautyPowerfulDetailsViewV2.a(this.DLM);
          }
          AppMethodBeat.o(357926);
          return;
          bool = locald.DLD;
          break;
          label128:
          i = paramAnonymousSeekBar.getMax();
          break label29;
          label137:
          paramAnonymousSeekBar = null;
        }
      }
      
      public final void onStartTrackingTouch(SeekBar paramAnonymousSeekBar) {}
      
      public final void onStopTrackingTouch(SeekBar paramAnonymousSeekBar)
      {
        boolean bool = false;
        int i = 0;
        AppMethodBeat.i(357941);
        if (paramAnonymousSeekBar == null)
        {
          Log.i("Finder.FinderLiveCameraOptBeautyPowerfulDetailsView", s.X("#onStopTrackingTouch progress=", Integer.valueOf(i)));
          paramAnonymousSeekBar = this.DLM.getSelectedEffect();
          if (paramAnonymousSeekBar != null)
          {
            localObject = this.DLM.getOnSeekDone();
            if (localObject != null) {
              ((m)localObject).invoke(Integer.valueOf(paramAnonymousSeekBar.DLC), Integer.valueOf(i));
            }
          }
          FinderLiveCameraOptBeautyPowerfulDetailsViewV2.a(this.DLM);
          AppMethodBeat.o(357941);
          return;
        }
        Object localObject = this.DLM;
        i = paramAnonymousSeekBar.getProgress();
        localObject = ((FinderLiveCameraOptBeautyPowerfulDetailsViewV2)localObject).getSelectedEffect();
        if (localObject == null) {}
        for (;;)
        {
          i = FinderLiveCameraOptBeautyPowerfulDetailsViewV2.i(i, bool, paramAnonymousSeekBar.getMax());
          break;
          bool = ((FinderLiveCameraOptBeautyPowerfulDetailsViewV2.d)localObject).DLD;
        }
      }
    });
    paramAttributeSet = findViewById(p.e.BHI);
    s.s(paramAttributeSet, "findViewById(R.id.finder…rful_panel_details_reset)");
    this.DLJ = paramAttributeSet;
    this.DLJ.setOnClickListener(new FinderLiveCameraOptBeautyPowerfulDetailsViewV2..ExternalSyntheticLambda2(this, paramContext));
    findViewById(p.e.BHH).setOnClickListener(new FinderLiveCameraOptBeautyPowerfulDetailsViewV2..ExternalSyntheticLambda1(this));
    AppMethodBeat.o(358001);
  }
  
  private static final void V(boolean paramBoolean, String paramString) {}
  
  private static final void a(FinderLiveCameraOptBeautyPowerfulDetailsViewV2 paramFinderLiveCameraOptBeautyPowerfulDetailsViewV2, Context paramContext, View paramView)
  {
    AppMethodBeat.i(358092);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderLiveCameraOptBeautyPowerfulDetailsViewV2);
    localb.cH(paramContext);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulDetailsViewV2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderLiveCameraOptBeautyPowerfulDetailsViewV2, "this$0");
    s.u(paramContext, "$context");
    paramView = paramFinderLiveCameraOptBeautyPowerfulDetailsViewV2.getOnRequestCheckIsDefault();
    if ((paramView != null) && (((Boolean)paramView.invoke()).booleanValue() == true)) {}
    for (int i = 1; i != 0; i = 0)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulDetailsViewV2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(358092);
      return;
    }
    paramView = new g.a(paramContext);
    paramView.bDJ(paramContext.getString(p.h.Cnr));
    paramView.bDI(paramContext.getString(p.h.Cnv));
    paramView.bDE(paramContext.getString(p.h.Cnt));
    paramView.a(FinderLiveCameraOptBeautyPowerfulDetailsViewV2..ExternalSyntheticLambda4.INSTANCE, new FinderLiveCameraOptBeautyPowerfulDetailsViewV2..ExternalSyntheticLambda3(paramFinderLiveCameraOptBeautyPowerfulDetailsViewV2, paramContext)).jHM().show();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulDetailsViewV2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(358092);
  }
  
  private static final void a(FinderLiveCameraOptBeautyPowerfulDetailsViewV2 paramFinderLiveCameraOptBeautyPowerfulDetailsViewV2, Context paramContext, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(358084);
    s.u(paramFinderLiveCameraOptBeautyPowerfulDetailsViewV2, "this$0");
    s.u(paramContext, "$context");
    paramFinderLiveCameraOptBeautyPowerfulDetailsViewV2 = paramFinderLiveCameraOptBeautyPowerfulDetailsViewV2.getOnRequestReset();
    if (paramFinderLiveCameraOptBeautyPowerfulDetailsViewV2 != null) {
      paramFinderLiveCameraOptBeautyPowerfulDetailsViewV2.invoke();
    }
    com.tencent.mm.ui.base.k.cZ(paramContext, paramContext.getString(p.h.Cnu));
    AppMethodBeat.o(358084);
  }
  
  private static final void a(FinderLiveCameraOptBeautyPowerfulDetailsViewV2 paramFinderLiveCameraOptBeautyPowerfulDetailsViewV2, View paramView)
  {
    AppMethodBeat.i(358098);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderLiveCameraOptBeautyPowerfulDetailsViewV2);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulDetailsViewV2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderLiveCameraOptBeautyPowerfulDetailsViewV2, "this$0");
    paramFinderLiveCameraOptBeautyPowerfulDetailsViewV2 = paramFinderLiveCameraOptBeautyPowerfulDetailsViewV2.getOnBackClick();
    if (paramFinderLiveCameraOptBeautyPowerfulDetailsViewV2 != null) {
      paramFinderLiveCameraOptBeautyPowerfulDetailsViewV2.invoke();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulDetailsViewV2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(358098);
  }
  
  private static final void a(FinderLiveCameraOptBeautyPowerfulDetailsViewV2 paramFinderLiveCameraOptBeautyPowerfulDetailsViewV2, boolean paramBoolean, float paramFloat)
  {
    AppMethodBeat.i(358108);
    paramFinderLiveCameraOptBeautyPowerfulDetailsViewV2.setTranslationX((1.0F - paramFloat) * paramFinderLiveCameraOptBeautyPowerfulDetailsViewV2.getMeasuredWidth());
    if (paramBoolean) {}
    for (paramFloat = Math.max(1.0F, paramFloat * 10.0F);; paramFloat = Math.min(1.0F, paramFloat * 10.0F))
    {
      paramFinderLiveCameraOptBeautyPowerfulDetailsViewV2.setAlpha(paramFloat);
      paramFinderLiveCameraOptBeautyPowerfulDetailsViewV2.setAndMoveSeekValueText(paramFinderLiveCameraOptBeautyPowerfulDetailsViewV2.DLL.getProgress());
      AppMethodBeat.o(358108);
      return;
    }
  }
  
  private static final void a(FinderLiveCameraOptBeautyPowerfulDetailsViewV2 paramFinderLiveCameraOptBeautyPowerfulDetailsViewV2, boolean paramBoolean, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(358115);
    s.u(paramFinderLiveCameraOptBeautyPowerfulDetailsViewV2, "this$0");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramFinderLiveCameraOptBeautyPowerfulDetailsViewV2 = new NullPointerException("null cannot be cast to non-null type kotlin.Float");
      AppMethodBeat.o(358115);
      throw paramFinderLiveCameraOptBeautyPowerfulDetailsViewV2;
    }
    a(paramFinderLiveCameraOptBeautyPowerfulDetailsViewV2, paramBoolean, ((Float)paramValueAnimator).floatValue());
    AppMethodBeat.o(358115);
  }
  
  private final void evd()
  {
    AppMethodBeat.i(358014);
    View localView = this.DLK;
    kotlin.g.a.a locala = this.DLH;
    int i;
    if ((locala != null) && (((Boolean)locala.invoke()).booleanValue() == true))
    {
      i = 1;
      if (i == 0) {
        break label66;
      }
    }
    label66:
    for (float f = 0.3F;; f = 1.0F)
    {
      localView.setAlpha(f);
      AppMethodBeat.o(358014);
      return;
      i = 0;
      break;
    }
  }
  
  private static int f(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(358050);
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
      AppMethodBeat.o(358050);
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
  
  private final void rX(final boolean paramBoolean)
  {
    AppMethodBeat.i(358045);
    float f1;
    if (paramBoolean)
    {
      f1 = 1.0F;
      if (!paramBoolean) {
        break label123;
      }
    }
    label123:
    for (final float f2 = 0.0F;; f2 = 1.0F)
    {
      Object localObject = this.DLt;
      if (localObject != null) {
        ((Animator)localObject).cancel();
      }
      localObject = ValueAnimator.ofFloat(new float[] { f1, f2 });
      ((ValueAnimator)localObject).addUpdateListener(new FinderLiveCameraOptBeautyPowerfulDetailsViewV2..ExternalSyntheticLambda0(this, paramBoolean));
      ((ValueAnimator)localObject).addListener((Animator.AnimatorListener)new e(f1, this, f2, paramBoolean));
      ((ValueAnimator)localObject).setDuration(360L);
      ((ValueAnimator)localObject).start();
      ah localah = ah.aiuX;
      this.DLt = ((Animator)localObject);
      AppMethodBeat.o(358045);
      return;
      f1 = 0.0F;
      break;
    }
  }
  
  private final void setAndMoveDefaultValueIcon(int paramInt)
  {
    AppMethodBeat.i(358033);
    ImageView localImageView = (ImageView)findViewById(p.e.BHM);
    int i = this.DLL.getWidth();
    int j = localImageView.getWidth();
    float f = paramInt / this.DLL.getMax() * (this.DLL.getMeasuredWidth() - this.DLL.getPaddingStart() - this.DLL.getPaddingEnd()) + this.DLL.getThumbOffset();
    Log.i("Finder.FinderLiveCameraOptBeautyPowerfulDetailsView", "#setAndMoveDefaultValueIcon progress:" + paramInt + " translationX:" + f);
    localImageView.setTranslationX(kotlin.k.k.bu(f, i - j));
    AppMethodBeat.o(358033);
  }
  
  private final void setAndMoveSeekValueText(int paramInt)
  {
    AppMethodBeat.i(358025);
    TextView localTextView = (TextView)findViewById(p.e.BHN);
    Object localObject = this.DLG;
    boolean bool;
    int i;
    if (localObject == null)
    {
      bool = false;
      i = f(paramInt, bool, this.DLL.getMax());
      if (i <= 0) {
        break label188;
      }
    }
    label188:
    for (localObject = (CharSequence)s.X("+", Integer.valueOf(i));; localObject = (CharSequence)String.valueOf(i))
    {
      localTextView.setText((CharSequence)localObject);
      i = this.DLL.getWidth();
      int j = localTextView.getWidth();
      float f = paramInt / this.DLL.getMax() * (this.DLL.getMeasuredWidth() - this.DLL.getPaddingStart() - this.DLL.getPaddingEnd());
      Log.i("Finder.FinderLiveCameraOptBeautyPowerfulDetailsView", "#setAndMoveSeekValueText progress:" + paramInt + " translationX:" + f);
      localTextView.setTranslationX(kotlin.k.k.bu(f, i - j));
      AppMethodBeat.o(358025);
      return;
      bool = ((FinderLiveCameraOptBeautyPowerfulDetailsViewV2.d)localObject).DLD;
      break;
    }
  }
  
  public final void eve()
  {
    int i = 1;
    AppMethodBeat.i(358262);
    Log.i("Finder.FinderLiveCameraOptBeautyPowerfulDetailsView", "#showSelf");
    Animator localAnimator = this.DLt;
    if ((localAnimator != null) && (localAnimator.isRunning() == true)) {}
    while (i != 0)
    {
      Log.i("Finder.FinderLiveCameraOptBeautyPowerfulDetailsView", "#showSelf visibilityAnimator isRunning");
      AppMethodBeat.o(358262);
      return;
      i = 0;
    }
    rX(false);
    AppMethodBeat.o(358262);
  }
  
  public final List<FinderLiveCameraOptBeautyPowerfulDetailsViewV2.d> getEffectItems()
  {
    return this.DLv;
  }
  
  public final kotlin.g.a.a<ah> getOnBackClick()
  {
    return this.DLI;
  }
  
  public final kotlin.g.a.a<Boolean> getOnRequestCheckIsDefault()
  {
    return this.DLH;
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
  
  public final FinderLiveCameraOptBeautyPowerfulDetailsViewV2.d getSelectedEffect()
  {
    return this.DLG;
  }
  
  public final void rW(boolean paramBoolean)
  {
    AppMethodBeat.i(358271);
    Log.i("Finder.FinderLiveCameraOptBeautyPowerfulDetailsView", s.X("#hideSelf isAnimator=", Boolean.valueOf(paramBoolean)));
    Animator localAnimator = this.DLt;
    if ((localAnimator != null) && (localAnimator.isRunning() == true)) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.i("Finder.FinderLiveCameraOptBeautyPowerfulDetailsView", "#hideSelf visibilityAnimator isRunning");
      AppMethodBeat.o(358271);
      return;
    }
    if (!paramBoolean)
    {
      setAlpha(0.0F);
      setVisibility(4);
      AppMethodBeat.o(358271);
      return;
    }
    rX(true);
    AppMethodBeat.o(358271);
  }
  
  public final void reload()
  {
    AppMethodBeat.i(358257);
    Log.i("Finder.FinderLiveCameraOptBeautyPowerfulDetailsView", "#reload");
    setSelectedEffect(this.DLG);
    evd();
    AppMethodBeat.o(358257);
  }
  
  public final void setEffectItems(List<FinderLiveCameraOptBeautyPowerfulDetailsViewV2.d> paramList)
  {
    AppMethodBeat.i(358197);
    s.u(paramList, "value");
    this.DLv.clear();
    this.DLv.addAll((Collection)paramList);
    setSelectedEffect((FinderLiveCameraOptBeautyPowerfulDetailsViewV2.d)p.oL(this.DLv));
    this.DLF.bZE.notifyChanged();
    AppMethodBeat.o(358197);
  }
  
  public final void setOnBackClick(kotlin.g.a.a<ah> parama)
  {
    this.DLI = parama;
  }
  
  public final void setOnRequestCheckIsDefault(kotlin.g.a.a<Boolean> parama)
  {
    this.DLH = parama;
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
  
  public final void setSelectedEffect(FinderLiveCameraOptBeautyPowerfulDetailsViewV2.d paramd)
  {
    AppMethodBeat.i(358186);
    Log.i("Finder.FinderLiveCameraOptBeautyPowerfulDetailsView", s.X("#selectedEffect set ", paramd));
    this.DLG = paramd;
    this.DLF.bZE.notifyChanged();
    paramd = this.DLG;
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
          this.DLL.setBothSidesMode(paramd.DLD);
          this.DLL.setProgress(g(i, paramd.DLD, this.DLL.getMax()));
          setAndMoveSeekValueText(this.DLL.getProgress());
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
          setAndMoveDefaultValueIcon(g(i, paramd.DLD, this.DLL.getMax()));
        }
      }
    }
    AppMethodBeat.o(358186);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulDetailsViewV2$executeVisibleAnimator$1$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "onAnimationStart", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    extends AnimatorListenerAdapter
  {
    e(float paramFloat1, FinderLiveCameraOptBeautyPowerfulDetailsViewV2 paramFinderLiveCameraOptBeautyPowerfulDetailsViewV2, float paramFloat2, boolean paramBoolean) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(357846);
      super.onAnimationEnd(paramAnimator);
      FinderLiveCameraOptBeautyPowerfulDetailsViewV2.b(jdField_this, paramBoolean, f2);
      paramAnimator = jdField_this;
      if (paramBoolean) {}
      for (int i = 4;; i = 0)
      {
        paramAnimator.setVisibility(i);
        jdField_this.reload();
        AppMethodBeat.o(357846);
        return;
      }
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(357836);
      super.onAnimationStart(paramAnimator);
      FinderLiveCameraOptBeautyPowerfulDetailsViewV2.b(jdField_this, paramBoolean, this.DLN);
      jdField_this.setVisibility(0);
      AppMethodBeat.o(357836);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.FinderLiveCameraOptBeautyPowerfulDetailsViewV2
 * JD-Core Version:    0.7.0.1
 */