package com.tencent.mm.plugin.finder.live.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
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
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.a.j;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.k.i;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulDetailsView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "adapter", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulDetailsView$BeautyAdapter;", "value", "", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulDetailsView$EffectInfo;", "effectItems", "getEffectItems", "()Ljava/util/List;", "setEffectItems", "(Ljava/util/List;)V", "onRequestDefaultSeekByKey", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "key", "getOnRequestDefaultSeekByKey", "()Lkotlin/jvm/functions/Function1;", "setOnRequestDefaultSeekByKey", "(Lkotlin/jvm/functions/Function1;)V", "onRequestReset", "Lkotlin/Function0;", "", "getOnRequestReset", "()Lkotlin/jvm/functions/Function0;", "setOnRequestReset", "(Lkotlin/jvm/functions/Function0;)V", "onRequestSeekByKey", "getOnRequestSeekByKey", "setOnRequestSeekByKey", "onSeekChanging", "Lkotlin/Function2;", "seek", "getOnSeekChanging", "()Lkotlin/jvm/functions/Function2;", "setOnSeekChanging", "(Lkotlin/jvm/functions/Function2;)V", "onSeekDone", "getOnSeekDone", "setOnSeekDone", "selectedEffect", "getSelectedEffect", "()Lcom/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulDetailsView$EffectInfo;", "setSelectedEffect", "(Lcom/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulDetailsView$EffectInfo;)V", "visibilityAnimator", "Landroid/animation/Animator;", "hideSelf", "isAnimator", "", "reload", "setAndMoveDefaultValueIcon", "progress", "setAndMoveSeekValueText", "showSelf", "BeautyAdapter", "CameraOptBeautyViewHolder", "Companion", "EffectInfo", "plugin-finder_release"})
public final class FinderLiveCameraOptBeautyPowerfulDetailsView
  extends RelativeLayout
{
  public static final c yTi;
  private HashMap _$_findViewCache;
  private final a ySZ;
  private Animator yTa;
  private FinderLiveCameraOptBeautyPowerfulDetailsView.d yTb;
  private List<FinderLiveCameraOptBeautyPowerfulDetailsView.d> yTc;
  private kotlin.g.a.b<? super Integer, Integer> yTd;
  private kotlin.g.a.b<? super Integer, Integer> yTe;
  private m<? super Integer, ? super Integer, x> yTf;
  private m<? super Integer, ? super Integer, x> yTg;
  private kotlin.g.a.a<x> yTh;
  
  static
  {
    AppMethodBeat.i(288060);
    yTi = new c((byte)0);
    AppMethodBeat.o(288060);
  }
  
  public FinderLiveCameraOptBeautyPowerfulDetailsView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, (byte)0);
  }
  
  public FinderLiveCameraOptBeautyPowerfulDetailsView(final Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(288059);
    this.ySZ = new a();
    this.yTc = ((List)new ArrayList());
    View.inflate(paramContext, b.g.finder_live_beauty_powerful_panel_details_view, (ViewGroup)this);
    pu(false);
    paramAttributeSet = (RecyclerView)_$_findCachedViewById(b.f.finder_live_beauty_powerful_panel_details_rv);
    p.j(paramAttributeSet, "it");
    paramAttributeSet.setAdapter((RecyclerView.a)this.ySZ);
    paramAttributeSet.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(0, false));
    ((SeekBar)_$_findCachedViewById(b.f.finder_live_beauty_powerful_panel_details_seek_bar)).setOnSeekBarChangeListener((SeekBar.OnSeekBarChangeListener)new SeekBar.OnSeekBarChangeListener()
    {
      public final void onProgressChanged(SeekBar paramAnonymousSeekBar, int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(279099);
        FinderLiveCameraOptBeautyPowerfulDetailsView.d locald = this.yTj.getSelectedEffect();
        if (locald != null)
        {
          paramAnonymousSeekBar = this.yTj.getOnSeekChanging();
          if (paramAnonymousSeekBar != null) {
            if (!paramAnonymousBoolean) {
              break label72;
            }
          }
        }
        for (;;)
        {
          if (paramAnonymousSeekBar != null) {
            paramAnonymousSeekBar.invoke(Integer.valueOf(locald.yTn), Integer.valueOf(paramAnonymousInt));
          }
          FinderLiveCameraOptBeautyPowerfulDetailsView.a(this.yTj, paramAnonymousInt);
          AppMethodBeat.o(279099);
          return;
          label72:
          paramAnonymousSeekBar = null;
        }
      }
      
      public final void onStartTrackingTouch(SeekBar paramAnonymousSeekBar) {}
      
      public final void onStopTrackingTouch(SeekBar paramAnonymousSeekBar)
      {
        AppMethodBeat.i(279100);
        if (paramAnonymousSeekBar != null) {}
        for (int i = paramAnonymousSeekBar.getProgress();; i = 0)
        {
          Log.i("Finder.FinderLiveCameraOptBeautyPowerfulDetailsView", "#onStopTrackingTouch progress=".concat(String.valueOf(i)));
          paramAnonymousSeekBar = this.yTj.getSelectedEffect();
          if (paramAnonymousSeekBar == null) {
            break label87;
          }
          m localm = this.yTj.getOnSeekDone();
          if (localm == null) {
            break;
          }
          localm.invoke(Integer.valueOf(paramAnonymousSeekBar.yTn), Integer.valueOf(i));
          AppMethodBeat.o(279100);
          return;
        }
        AppMethodBeat.o(279100);
        return;
        label87:
        AppMethodBeat.o(279100);
      }
    });
    ((WeImageView)_$_findCachedViewById(b.f.finder_live_beauty_powerful_panel_details_reset)).setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(283858);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulDetailsView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = new f.a(paramContext);
        paramAnonymousView.bBq(paramContext.getString(b.j.finder_live_menu_opt_beauty_reset_cancel));
        paramAnonymousView.bBp(paramContext.getString(b.j.finder_live_menu_opt_beauty_reset_ok));
        paramAnonymousView.bBl(paramContext.getString(b.j.finder_live_menu_opt_beauty_reset_content));
        paramAnonymousView.a((f.c)1.yTk, (f.c)new f.c()
        {
          public final void g(boolean paramAnonymous2Boolean, String paramAnonymous2String)
          {
            AppMethodBeat.i(238582);
            paramAnonymous2String = this.yTl.yTj.getOnRequestReset();
            if (paramAnonymous2String != null) {
              paramAnonymous2String.invoke();
            }
            h.cM(this.yTl.$context, this.yTl.$context.getString(b.j.finder_live_menu_opt_beauty_reset_done));
            AppMethodBeat.o(238582);
          }
        }).icF().show();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulDetailsView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(283858);
      }
    });
    AppMethodBeat.o(288059);
  }
  
  private View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(288062);
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    AppMethodBeat.o(288062);
    return localView1;
  }
  
  private final void setAndMoveDefaultValueIcon(int paramInt)
  {
    AppMethodBeat.i(288055);
    SeekBar localSeekBar = (SeekBar)_$_findCachedViewById(b.f.finder_live_beauty_powerful_panel_details_seek_bar);
    ImageView localImageView = (ImageView)_$_findCachedViewById(b.f.finder_live_beauty_powerful_panel_details_seek_bar_default_icon);
    p.j(localSeekBar, "seekBar");
    int i = localSeekBar.getWidth();
    p.j(localImageView, "seekDefaultIcon");
    int j = localImageView.getWidth();
    float f = paramInt / localSeekBar.getMax();
    f = (localSeekBar.getMeasuredWidth() - localSeekBar.getPaddingStart() - localSeekBar.getPaddingEnd()) * f;
    Log.i("Finder.FinderLiveCameraOptBeautyPowerfulDetailsView", "#setAndMoveDefaultValueIcon progress:" + paramInt + " translationX:" + f);
    localImageView.setTranslationX(i.aQ(f, i - j));
    AppMethodBeat.o(288055);
  }
  
  private final void setAndMoveSeekValueText(int paramInt)
  {
    AppMethodBeat.i(288054);
    Object localObject = (SeekBar)_$_findCachedViewById(b.f.finder_live_beauty_powerful_panel_details_seek_bar);
    TextView localTextView1 = (TextView)_$_findCachedViewById(b.f.finder_live_beauty_powerful_panel_details_seek_value_tv);
    p.j(localObject, "seekBar");
    int i = ((SeekBar)localObject).getWidth();
    p.j(localTextView1, "seekValueText");
    int j = localTextView1.getWidth();
    float f = paramInt / ((SeekBar)localObject).getMax() * (((SeekBar)localObject).getMeasuredWidth() - ((SeekBar)localObject).getPaddingStart() - ((SeekBar)localObject).getPaddingEnd());
    Log.i("Finder.FinderLiveCameraOptBeautyPowerfulDetailsView", "#setAndMoveSeekValueText progress:" + paramInt + " translationX:" + f);
    TextView localTextView2 = (TextView)_$_findCachedViewById(b.f.finder_live_beauty_powerful_panel_details_seek_value_tv);
    p.j(localTextView2, "finder_live_beauty_power…nel_details_seek_value_tv");
    if (paramInt <= 0) {}
    for (localObject = (CharSequence)"0";; localObject = (CharSequence)"+".concat(String.valueOf(paramInt)))
    {
      localTextView2.setText((CharSequence)localObject);
      localTextView1.setTranslationX(i.aQ(f, i - j));
      AppMethodBeat.o(288054);
      return;
    }
  }
  
  public final void dEX()
  {
    AppMethodBeat.i(288057);
    Log.i("Finder.FinderLiveCameraOptBeautyPowerfulDetailsView", "#showSelf");
    Object localObject = this.yTa;
    if ((localObject != null) && (((Animator)localObject).isRunning() == true))
    {
      Log.i("Finder.FinderLiveCameraOptBeautyPowerfulDetailsView", "#showSelf visibilityAnimator isRunning");
      AppMethodBeat.o(288057);
      return;
    }
    localObject = ObjectAnimator.ofFloat(this, "alpha", new float[] { 0.0F, 1.0F });
    ((ObjectAnimator)localObject).addListener((Animator.AnimatorListener)new f(this));
    ((ObjectAnimator)localObject).start();
    this.yTa = ((Animator)localObject);
    AppMethodBeat.o(288057);
  }
  
  public final List<FinderLiveCameraOptBeautyPowerfulDetailsView.d> getEffectItems()
  {
    return this.yTc;
  }
  
  public final kotlin.g.a.b<Integer, Integer> getOnRequestDefaultSeekByKey()
  {
    return this.yTe;
  }
  
  public final kotlin.g.a.a<x> getOnRequestReset()
  {
    return this.yTh;
  }
  
  public final kotlin.g.a.b<Integer, Integer> getOnRequestSeekByKey()
  {
    return this.yTd;
  }
  
  public final m<Integer, Integer, x> getOnSeekChanging()
  {
    return this.yTf;
  }
  
  public final m<Integer, Integer, x> getOnSeekDone()
  {
    return this.yTg;
  }
  
  public final FinderLiveCameraOptBeautyPowerfulDetailsView.d getSelectedEffect()
  {
    return this.yTb;
  }
  
  public final void pu(boolean paramBoolean)
  {
    AppMethodBeat.i(288058);
    Log.i("Finder.FinderLiveCameraOptBeautyPowerfulDetailsView", "#hideSelf isAnimator=".concat(String.valueOf(paramBoolean)));
    Object localObject = this.yTa;
    if ((localObject != null) && (((Animator)localObject).isRunning() == true))
    {
      Log.i("Finder.FinderLiveCameraOptBeautyPowerfulDetailsView", "#hideSelf visibilityAnimator isRunning");
      AppMethodBeat.o(288058);
      return;
    }
    if (!paramBoolean)
    {
      setVisibility(8);
      AppMethodBeat.o(288058);
      return;
    }
    localObject = ObjectAnimator.ofFloat(this, "alpha", new float[] { 1.0F, 0.0F });
    ((ObjectAnimator)localObject).addListener((Animator.AnimatorListener)new e(this));
    ((ObjectAnimator)localObject).start();
    this.yTa = ((Animator)localObject);
    AppMethodBeat.o(288058);
  }
  
  public final void reload()
  {
    AppMethodBeat.i(288056);
    Log.i("Finder.FinderLiveCameraOptBeautyPowerfulDetailsView", "#reload");
    setSelectedEffect(this.yTb);
    AppMethodBeat.o(288056);
  }
  
  public final void setEffectItems(List<FinderLiveCameraOptBeautyPowerfulDetailsView.d> paramList)
  {
    AppMethodBeat.i(288053);
    p.k(paramList, "value");
    this.yTc.clear();
    this.yTc.addAll((Collection)paramList);
    setSelectedEffect((FinderLiveCameraOptBeautyPowerfulDetailsView.d)j.lp(this.yTc));
    this.ySZ.notifyDataSetChanged();
    AppMethodBeat.o(288053);
  }
  
  public final void setOnRequestDefaultSeekByKey(kotlin.g.a.b<? super Integer, Integer> paramb)
  {
    this.yTe = paramb;
  }
  
  public final void setOnRequestReset(kotlin.g.a.a<x> parama)
  {
    this.yTh = parama;
  }
  
  public final void setOnRequestSeekByKey(kotlin.g.a.b<? super Integer, Integer> paramb)
  {
    this.yTd = paramb;
  }
  
  public final void setOnSeekChanging(m<? super Integer, ? super Integer, x> paramm)
  {
    this.yTf = paramm;
  }
  
  public final void setOnSeekDone(m<? super Integer, ? super Integer, x> paramm)
  {
    this.yTg = paramm;
  }
  
  public final void setSelectedEffect(FinderLiveCameraOptBeautyPowerfulDetailsView.d paramd)
  {
    AppMethodBeat.i(288052);
    Log.i("Finder.FinderLiveCameraOptBeautyPowerfulDetailsView", "#selectedEffect set ".concat(String.valueOf(paramd)));
    this.yTb = paramd;
    this.ySZ.notifyDataSetChanged();
    paramd = this.yTb;
    if (paramd != null)
    {
      Object localObject = this.yTd;
      int i;
      if (localObject != null)
      {
        localObject = (Integer)((kotlin.g.a.b)localObject).invoke(Integer.valueOf(paramd.yTn));
        if (localObject != null)
        {
          i = ((Number)localObject).intValue();
          Log.i("Finder.FinderLiveCameraOptBeautyPowerfulDetailsView", "#selectedEffect set onRequestSeekByKey ".concat(String.valueOf(i)));
          localObject = (SeekBar)_$_findCachedViewById(b.f.finder_live_beauty_powerful_panel_details_seek_bar);
          p.j(localObject, "finder_live_beauty_powerful_panel_details_seek_bar");
          ((SeekBar)localObject).setProgress(i);
          setAndMoveSeekValueText(i);
        }
      }
      localObject = this.yTe;
      if (localObject != null)
      {
        paramd = (Integer)((kotlin.g.a.b)localObject).invoke(Integer.valueOf(paramd.yTn));
        if (paramd != null)
        {
          i = ((Number)paramd).intValue();
          Log.i("Finder.FinderLiveCameraOptBeautyPowerfulDetailsView", "#selectedEffect set onRequestDefaultSeekByKey ".concat(String.valueOf(i)));
          setAndMoveDefaultValueIcon(i);
          AppMethodBeat.o(288052);
          return;
        }
      }
      AppMethodBeat.o(288052);
      return;
    }
    AppMethodBeat.o(288052);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulDetailsView$BeautyAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulDetailsView$CameraOptBeautyViewHolder;", "(Lcom/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulDetailsView;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "type", "plugin-finder_release"})
  final class a
    extends RecyclerView.a<FinderLiveCameraOptBeautyPowerfulDetailsView.b>
  {
    public final int getItemCount()
    {
      AppMethodBeat.i(241345);
      int i = this.yTj.getEffectItems().size();
      AppMethodBeat.o(241345);
      return i;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(FinderLiveCameraOptBeautyPowerfulDetailsView.a parama, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(268570);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulDetailsView$BeautyAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        this.yTm.yTj.setSelectedEffect((FinderLiveCameraOptBeautyPowerfulDetailsView.d)j.M(this.yTm.yTj.getEffectItems(), this.jEN));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulDetailsView$BeautyAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(268570);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulDetailsView$CameraOptBeautyViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "plugin-finder_release"})
  static final class b
    extends RecyclerView.v
  {
    final TextView jMg;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(279196);
      paramView = paramView.findViewById(b.f.finder_live_camera_opt_beauty_item_title);
      p.j(paramView, "itemView.findViewById(R.…ra_opt_beauty_item_title)");
      this.jMg = ((TextView)paramView);
      AppMethodBeat.o(279196);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulDetailsView$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class c {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulDetailsView$hideSelf$1$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "onAnimationStart", "plugin-finder_release"})
  public static final class e
    extends AnimatorListenerAdapter
  {
    e(FinderLiveCameraOptBeautyPowerfulDetailsView paramFinderLiveCameraOptBeautyPowerfulDetailsView) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(277007);
      super.onAnimationEnd(paramAnimator);
      this.yTj.setVisibility(8);
      AppMethodBeat.o(277007);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(277006);
      super.onAnimationStart(paramAnimator);
      AppMethodBeat.o(277006);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulDetailsView$showSelf$1$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "onAnimationStart", "plugin-finder_release"})
  public static final class f
    extends AnimatorListenerAdapter
  {
    f(FinderLiveCameraOptBeautyPowerfulDetailsView paramFinderLiveCameraOptBeautyPowerfulDetailsView) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(291698);
      super.onAnimationEnd(paramAnimator);
      this.yTj.setAlpha(1.0F);
      this.yTj.reload();
      AppMethodBeat.o(291698);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(291697);
      super.onAnimationStart(paramAnimator);
      this.yTj.setAlpha(0.0F);
      this.yTj.setVisibility(0);
      AppMethodBeat.o(291697);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.FinderLiveCameraOptBeautyPowerfulDetailsView
 * JD-Core Version:    0.7.0.1
 */