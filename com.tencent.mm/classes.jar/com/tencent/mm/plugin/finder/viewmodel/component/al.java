package com.tencent.mm.plugin.finder.viewmodel.component;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.megavideo.floatball.a.a;
import com.tencent.mm.plugin.finder.megavideo.ui.FinderMegaVideoMiniView;
import com.tencent.mm.plugin.finder.report.am;
import com.tencent.mm.plugin.finder.video.FinderThumbPlayerProxy;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.view.recyclerview.i;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderSpeedControlUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "animTranslateY", "", "getAnimTranslateY", "()I", "animTranslateY$delegate", "Lkotlin/Lazy;", "ctrlItemNormalHeight", "getCtrlItemNormalHeight", "ctrlItemNormalHeight$delegate", "ctrlItemNormalWidth", "getCtrlItemNormalWidth", "ctrlItemNormalWidth$delegate", "ctrlLayoutPadding", "getCtrlLayoutPadding", "ctrlLayoutPadding$delegate", "currRotation", "hideViewList", "", "Landroid/view/View;", "speedCtrlLayout", "kotlin.jvm.PlatformType", "getSpeedCtrlLayout", "()Landroid/view/View;", "speedCtrlLayout$delegate", "hideSpeedControlArea", "", "needAnim", "", "reShowHideView", "chooseSpeedRatio", "", "onBackPressed", "showSpeedControlArea", "viewsToHide", "targetVideoView", "Lcom/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy;", "rotation", "isFromHorizontal", "Companion", "plugin-finder_release"})
public final class al
  extends UIComponent
{
  public static final a Bou;
  private int BlM;
  private List<? extends View> Boo;
  private final f Bop;
  private final f Boq;
  private final f Bor;
  private final f Bos;
  private final f Bot;
  
  static
  {
    AppMethodBeat.i(230910);
    Bou = new a((byte)0);
    AppMethodBeat.o(230910);
  }
  
  public al(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(230907);
    this.Bop = g.ar((kotlin.g.a.a)new k(paramAppCompatActivity));
    this.Boq = g.ar((kotlin.g.a.a)al.b.Bov);
    this.Bor = g.ar((kotlin.g.a.a)al.e.Boy);
    this.Bos = g.ar((kotlin.g.a.a)al.d.Box);
    this.Bot = g.ar((kotlin.g.a.a)al.c.Bow);
    AppMethodBeat.o(230907);
  }
  
  private final View elm()
  {
    AppMethodBeat.i(230885);
    View localView = (View)this.Bop.getValue();
    AppMethodBeat.o(230885);
    return localView;
  }
  
  private final int eln()
  {
    AppMethodBeat.i(230887);
    int i = ((Number)this.Boq.getValue()).intValue();
    AppMethodBeat.o(230887);
    return i;
  }
  
  private final int elo()
  {
    AppMethodBeat.i(230892);
    int i = ((Number)this.Bor.getValue()).intValue();
    AppMethodBeat.o(230892);
    return i;
  }
  
  private final int elp()
  {
    AppMethodBeat.i(230896);
    int i = ((Number)this.Bos.getValue()).intValue();
    AppMethodBeat.o(230896);
    return i;
  }
  
  private final int elq()
  {
    AppMethodBeat.i(230897);
    int i = ((Number)this.Bot.getValue()).intValue();
    AppMethodBeat.o(230897);
    return i;
  }
  
  public final void a(List<? extends View> paramList, final FinderThumbPlayerProxy paramFinderThumbPlayerProxy, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(230902);
    p.k(paramList, "viewsToHide");
    p.k(paramFinderThumbPlayerProxy, "targetVideoView");
    Object localObject1 = am.zZN;
    localObject1 = aj.Bnu;
    localObject1 = aj.a.fZ((Context)getActivity());
    Object localObject2;
    label80:
    TextView localTextView;
    if (localObject1 != null)
    {
      localObject1 = ((aj)localObject1).ekY();
      if (!paramBoolean) {
        break label267;
      }
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("ref_eid", "transpose_video_card");
      am.a((bid)localObject1, "speedplay", 1, (JSONObject)localObject2);
      this.Boo = paramList;
      this.BlM = paramInt;
      localObject1 = j.listOf(new TextView[] { (TextView)elm().findViewById(b.f.speed_0_5), (TextView)elm().findViewById(b.f.speed_1), (TextView)elm().findViewById(b.f.speed_1_5), (TextView)elm().findViewById(b.f.speed_2) });
      localObject2 = (View.OnClickListener)new j(this, (List)localObject1, paramFinderThumbPlayerProxy);
      f = paramFinderThumbPlayerProxy.getPlaySpeedRatio();
      paramFinderThumbPlayerProxy = ((Iterable)localObject1).iterator();
      if (!paramFinderThumbPlayerProxy.hasNext()) {
        break label330;
      }
      localTextView = (TextView)paramFinderThumbPlayerProxy.next();
      if (localTextView == null) {
        break label273;
      }
    }
    label267:
    label273:
    for (paramList = localTextView.getTag();; paramList = null)
    {
      if (paramList != null) {
        break label278;
      }
      paramList = new t("null cannot be cast to non-null type kotlin.Float");
      AppMethodBeat.o(230902);
      throw paramList;
      localObject1 = null;
      break;
      localObject2 = null;
      break label80;
    }
    label278:
    if (Float.compare(f, ((Float)paramList).floatValue()) == 0) {
      localTextView.setTextColor(getContext().getResources().getColor(b.c.hot_tab_Orange_100));
    }
    for (;;)
    {
      localTextView.setOnClickListener((View.OnClickListener)localObject2);
      break;
      localTextView.setTextColor(-1);
    }
    label330:
    paramList = this.Boo;
    if (paramList != null)
    {
      paramList = ((Iterable)paramList).iterator();
      while (paramList.hasNext())
      {
        paramFinderThumbPlayerProxy = (View)paramList.next();
        paramFinderThumbPlayerProxy.animate().alpha(0.0F).setDuration(300L).setListener((Animator.AnimatorListener)new al.h(paramFinderThumbPlayerProxy)).start();
      }
    }
    paramList = getActivity().getWindow();
    p.j(paramList, "activity.window");
    paramFinderThumbPlayerProxy = paramList.getDecorView();
    paramList = paramFinderThumbPlayerProxy;
    if (!(paramFinderThumbPlayerProxy instanceof ViewGroup)) {
      paramList = null;
    }
    paramList = (ViewGroup)paramList;
    if (paramList != null) {
      paramList.addView(elm(), (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    }
    paramList = elm().findViewById(b.f.play_speed_control_container);
    if (paramList != null)
    {
      if (paramInt != -90) {
        break label693;
      }
      paramFinderThumbPlayerProxy = paramList.getLayoutParams();
      if (paramFinderThumbPlayerProxy == null)
      {
        paramList = new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        AppMethodBeat.o(230902);
        throw paramList;
      }
      ((FrameLayout.LayoutParams)paramFinderThumbPlayerProxy).gravity = 48;
      paramList.setPadding(0, elo(), 0, 0);
      paramFinderThumbPlayerProxy = ((Iterable)localObject1).iterator();
      while (paramFinderThumbPlayerProxy.hasNext())
      {
        localObject1 = (TextView)paramFinderThumbPlayerProxy.next();
        if (localObject1 != null) {
          ((TextView)localObject1).setRotation(paramInt);
        }
        if (localObject1 != null)
        {
          localObject2 = ((TextView)localObject1).getLayoutParams();
          if (localObject2 != null) {
            ((ViewGroup.LayoutParams)localObject2).width = elq();
          }
        }
        if (localObject1 != null)
        {
          localObject1 = ((TextView)localObject1).getLayoutParams();
          if (localObject1 != null) {
            ((ViewGroup.LayoutParams)localObject1).height = elp();
          }
        }
      }
    }
    for (float f = -eln();; f = eln())
    {
      paramList.setTranslationY(f);
      paramList.animate().translationY(0.0F).translationX(0.0F).setDuration(300L).setListener(null).start();
      elm().setOnClickListener((View.OnClickListener)new i(this));
      AppMethodBeat.o(230902);
      return;
      label693:
      paramFinderThumbPlayerProxy = paramList.getLayoutParams();
      if (paramFinderThumbPlayerProxy == null)
      {
        paramList = new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        AppMethodBeat.o(230902);
        throw paramList;
      }
      ((FrameLayout.LayoutParams)paramFinderThumbPlayerProxy).gravity = 80;
      paramList.setPadding(0, 0, 0, elo());
      paramList.setRotation(0.0F);
      paramFinderThumbPlayerProxy = ((Iterable)localObject1).iterator();
      if (paramFinderThumbPlayerProxy.hasNext())
      {
        localObject1 = (TextView)paramFinderThumbPlayerProxy.next();
        if (localObject1 != null) {
          ((TextView)localObject1).setRotation(paramInt);
        }
        if (localObject1 != null)
        {
          localObject2 = ((TextView)localObject1).getLayoutParams();
          if (localObject2 != null)
          {
            if (paramInt != 0) {
              break label870;
            }
            i = elp();
            label816:
            ((ViewGroup.LayoutParams)localObject2).width = i;
          }
        }
        if (localObject1 != null)
        {
          localObject2 = ((TextView)localObject1).getLayoutParams();
          if (localObject2 != null) {
            if (paramInt != 0) {
              break label879;
            }
          }
        }
        label870:
        label879:
        for (int i = elq();; i = elp())
        {
          ((ViewGroup.LayoutParams)localObject2).height = i;
          if (localObject1 == null) {
            break;
          }
          ((TextView)localObject1).requestLayout();
          break;
          i = elq();
          break label816;
        }
      }
    }
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(230906);
    if (this.Boo != null)
    {
      a(this, false, false, 0.0F, 7);
      AppMethodBeat.o(230906);
      return true;
    }
    boolean bool = super.onBackPressed();
    AppMethodBeat.o(230906);
    return bool;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderSpeedControlUIC$Companion;", "", "()V", "ANIM_DURATION", "", "PLAY_SPEED_0_5", "", "PLAY_SPEED_1", "PLAY_SPEED_1_5", "PLAY_SPEED_2", "TAG", "", "getCurrentPlaySpeedRatio", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getCurrentPlaySpeedText", "plugin-finder_release"})
  public static final class a
  {
    private static float v(RecyclerView paramRecyclerView)
    {
      AppMethodBeat.i(273062);
      p.k(paramRecyclerView, "recyclerView");
      RecyclerView.LayoutManager localLayoutManager = paramRecyclerView.getLayoutManager();
      Object localObject = localLayoutManager;
      if (!(localLayoutManager instanceof FinderLinearLayoutManager)) {
        localObject = null;
      }
      localObject = (FinderLinearLayoutManager)localObject;
      if (localObject != null)
      {
        localObject = paramRecyclerView.cJ(((FinderLinearLayoutManager)localObject).kJ());
        paramRecyclerView = (RecyclerView)localObject;
        if (!(localObject instanceof i)) {
          paramRecyclerView = null;
        }
        paramRecyclerView = (i)paramRecyclerView;
        if (paramRecyclerView != null)
        {
          paramRecyclerView = (FinderVideoLayout)paramRecyclerView.RD(b.f.finder_banner_video_layout);
          if (paramRecyclerView != null) {}
          for (paramRecyclerView = paramRecyclerView.getVideoView();; paramRecyclerView = null)
          {
            localObject = paramRecyclerView;
            if (!(paramRecyclerView instanceof FinderThumbPlayerProxy)) {
              localObject = null;
            }
            paramRecyclerView = (FinderThumbPlayerProxy)localObject;
            if (paramRecyclerView == null) {
              break;
            }
            float f = paramRecyclerView.getPlaySpeedRatio();
            AppMethodBeat.o(273062);
            return f;
          }
        }
      }
      AppMethodBeat.o(273062);
      return 1.0F;
    }
    
    public static String w(RecyclerView paramRecyclerView)
    {
      AppMethodBeat.i(273063);
      p.k(paramRecyclerView, "recyclerView");
      Context localContext = paramRecyclerView.getContext();
      float f = v(paramRecyclerView);
      if (f == 0.5F)
      {
        paramRecyclerView = localContext.getString(b.j.mega_video_play_speed_0_5);
        p.j(paramRecyclerView, "context.getString(R.stri…ega_video_play_speed_0_5)");
        AppMethodBeat.o(273063);
        return paramRecyclerView;
      }
      if (f != 1.0F)
      {
        if (f == 1.5F)
        {
          paramRecyclerView = localContext.getString(b.j.mega_video_play_speed_1_5);
          p.j(paramRecyclerView, "context.getString(R.stri…ega_video_play_speed_1_5)");
          AppMethodBeat.o(273063);
          return paramRecyclerView;
        }
        if (f == 2.0F)
        {
          paramRecyclerView = localContext.getString(b.j.mega_video_play_speed_2);
          p.j(paramRecyclerView, "context.getString(R.stri….mega_video_play_speed_2)");
          AppMethodBeat.o(273063);
          return paramRecyclerView;
        }
      }
      paramRecyclerView = localContext.getString(b.j.mega_video_play_speed_text);
      p.j(paramRecyclerView, "context.getString(R.stri…ga_video_play_speed_text)");
      AppMethodBeat.o(273063);
      return paramRecyclerView;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/viewmodel/component/FinderSpeedControlUIC$hideSpeedControlArea$2$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"})
  public static final class f
    extends AnimatorListenerAdapter
  {
    f(View paramView, al paramal, boolean paramBoolean) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(282324);
      paramAnimator = this.Boz.getActivity().getWindow();
      p.j(paramAnimator, "activity.window");
      View localView = paramAnimator.getDecorView();
      paramAnimator = localView;
      if (!(localView instanceof ViewGroup)) {
        paramAnimator = null;
      }
      paramAnimator = (ViewGroup)paramAnimator;
      if (paramAnimator != null) {
        paramAnimator.removeView(al.a(this.Boz));
      }
      this.kJS.animate().setListener(null).cancel();
      AppMethodBeat.o(282324);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class i
    implements View.OnClickListener
  {
    i(al paramal) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(289805);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderSpeedControlUIC$showSpeedControlArea$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      al.a(this.Boz, false, false, 0.0F, 7);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderSpeedControlUIC$showSpeedControlArea$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(289805);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class j
    implements View.OnClickListener
  {
    j(al paramal, List paramList, FinderThumbPlayerProxy paramFinderThumbPlayerProxy) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(279221);
      Object localObject = new b();
      ((b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderSpeedControlUIC$showSpeedControlArea$onClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
      p.j(paramView, "it");
      localObject = paramView.getTag();
      if (localObject == null)
      {
        paramView = new t("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(279221);
        throw paramView;
      }
      float f = ((Float)localObject).floatValue();
      localObject = ((Iterable)this.zwg).iterator();
      while (((Iterator)localObject).hasNext())
      {
        TextView localTextView = (TextView)((Iterator)localObject).next();
        if (p.h(localTextView, paramView))
        {
          if (localTextView != null) {
            localTextView.setTextColor(this.Boz.getContext().getResources().getColor(b.c.hot_tab_Orange_100));
          }
        }
        else if (localTextView != null) {
          localTextView.setTextColor(-1);
        }
      }
      paramFinderThumbPlayerProxy.setPlaySpeed(f);
      localObject = paramFinderThumbPlayerProxy.getVideoMediaId();
      paramView = com.tencent.mm.plugin.finder.megavideo.floatball.a.zwo;
      paramView = a.a.dJH().dJD().getVideoView();
      if (paramView != null) {}
      for (paramView = paramView.getVideoMediaId();; paramView = null)
      {
        if (p.h(localObject, paramView))
        {
          paramView = com.tencent.mm.plugin.finder.megavideo.floatball.a.zwo;
          a.a.dJH().setPlaySpeed(f);
        }
        al.a(this.Boz, false, false, f, 3);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderSpeedControlUIC$showSpeedControlArea$onClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(279221);
        return;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class k
    extends q
    implements kotlin.g.a.a<View>
  {
    k(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.al
 * JD-Core Version:    0.7.0.1
 */