package com.tencent.mm.plugin.finder.viewmodel.component;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.megavideo.floatball.a.a;
import com.tencent.mm.plugin.finder.megavideo.ui.FinderMegaVideoMiniView;
import com.tencent.mm.plugin.finder.video.FinderThumbPlayerProxy;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.ui.component.UIComponent;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderSpeedControlUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "animTranslateY", "", "getAnimTranslateY", "()I", "animTranslateY$delegate", "Lkotlin/Lazy;", "ctrlItemNormalHeight", "getCtrlItemNormalHeight", "ctrlItemNormalHeight$delegate", "ctrlItemNormalWidth", "getCtrlItemNormalWidth", "ctrlItemNormalWidth$delegate", "ctrlLayoutPadding", "getCtrlLayoutPadding", "ctrlLayoutPadding$delegate", "currRotation", "hideViewList", "", "Landroid/view/View;", "speedCtrlLayout", "kotlin.jvm.PlatformType", "getSpeedCtrlLayout", "()Landroid/view/View;", "speedCtrlLayout$delegate", "hideSpeedControlArea", "", "needAnim", "", "reShowHideView", "chooseSpeedRatio", "", "onBackPressed", "showSpeedControlArea", "viewsToHide", "targetVideoView", "Lcom/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy;", "rotation", "isFromHorizontal", "onSelect", "Lkotlin/Function0;", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class av
  extends UIComponent
{
  public static final a GUq;
  private int GRO;
  private List<? extends View> GUr;
  private final kotlin.j GUs;
  private final kotlin.j GUt;
  private final kotlin.j GUu;
  private final kotlin.j GUv;
  private final kotlin.j GUw;
  
  static
  {
    AppMethodBeat.i(338175);
    GUq = new a((byte)0);
    AppMethodBeat.o(338175);
  }
  
  public av(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(338047);
    this.GUs = k.cm((kotlin.g.a.a)new i(paramAppCompatActivity));
    this.GUt = k.cm((kotlin.g.a.a)b.GUx);
    this.GUu = k.cm((kotlin.g.a.a)e.GUA);
    this.GUv = k.cm((kotlin.g.a.a)d.GUz);
    this.GUw = k.cm((kotlin.g.a.a)c.GUy);
    AppMethodBeat.o(338047);
  }
  
  private static final void a(av paramav, View paramView)
  {
    AppMethodBeat.i(338157);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramav);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderSpeedControlUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramav, "this$0");
    a(paramav, false, false, 0.0F, 7);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/viewmodel/component/FinderSpeedControlUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(338157);
  }
  
  private static final void a(List paramList, FinderThumbPlayerProxy paramFinderThumbPlayerProxy, av paramav, kotlin.g.a.a parama, View paramView)
  {
    AppMethodBeat.i(338147);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramList);
    localb.cH(paramFinderThumbPlayerProxy);
    localb.cH(paramav);
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderSpeedControlUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramList, "$viewList");
    s.u(paramFinderThumbPlayerProxy, "$targetVideoView");
    s.u(paramav, "this$0");
    localObject = paramView.getTag();
    if (localObject == null)
    {
      paramList = new NullPointerException("null cannot be cast to non-null type kotlin.Float");
      AppMethodBeat.o(338147);
      throw paramList;
    }
    float f = ((Float)localObject).floatValue();
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      localObject = (TextView)paramList.next();
      if (s.p(localObject, paramView))
      {
        if (localObject != null) {
          ((TextView)localObject).setTextColor(paramav.getContext().getResources().getColor(e.b.hot_tab_Orange_100));
        }
      }
      else if (localObject != null) {
        ((TextView)localObject).setTextColor(-1);
      }
    }
    paramFinderThumbPlayerProxy.setPlaySpeed(f);
    paramFinderThumbPlayerProxy = paramFinderThumbPlayerProxy.getVideoMediaId();
    paramList = com.tencent.mm.plugin.finder.megavideo.floatball.a.Ezy;
    paramList = a.a.eCH().egj().getVideoView();
    if (paramList == null) {}
    for (paramList = null;; paramList = paramList.getVideoMediaId())
    {
      if (s.p(paramFinderThumbPlayerProxy, paramList))
      {
        paramList = com.tencent.mm.plugin.finder.megavideo.floatball.a.Ezy;
        a.a.eCH().setPlaySpeed(f);
      }
      a(paramav, false, false, f, 3);
      if (parama != null) {
        parama.invoke();
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/viewmodel/component/FinderSpeedControlUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(338147);
      return;
    }
  }
  
  private final View foS()
  {
    AppMethodBeat.i(338053);
    View localView = (View)this.GUs.getValue();
    AppMethodBeat.o(338053);
    return localView;
  }
  
  private final int foT()
  {
    AppMethodBeat.i(338059);
    int i = ((Number)this.GUt.getValue()).intValue();
    AppMethodBeat.o(338059);
    return i;
  }
  
  private final int foU()
  {
    AppMethodBeat.i(338069);
    int i = ((Number)this.GUu.getValue()).intValue();
    AppMethodBeat.o(338069);
    return i;
  }
  
  private final int foV()
  {
    AppMethodBeat.i(338075);
    int i = ((Number)this.GUv.getValue()).intValue();
    AppMethodBeat.o(338075);
    return i;
  }
  
  private final int foW()
  {
    AppMethodBeat.i(338080);
    int i = ((Number)this.GUw.getValue()).intValue();
    AppMethodBeat.o(338080);
    return i;
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(338208);
    if (this.GUr != null)
    {
      a(this, false, false, 0.0F, 7);
      AppMethodBeat.o(338208);
      return true;
    }
    boolean bool = super.onBackPressed();
    AppMethodBeat.o(338208);
    return bool;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderSpeedControlUIC$Companion;", "", "()V", "ANIM_DURATION", "", "PLAY_SPEED_0_5", "", "PLAY_SPEED_1", "PLAY_SPEED_1_5", "PLAY_SPEED_2", "TAG", "", "getCurrentPlaySpeedRatio", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getCurrentPlaySpeedText", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    private static float G(RecyclerView paramRecyclerView)
    {
      AppMethodBeat.i(337518);
      s.u(paramRecyclerView, "recyclerView");
      Object localObject = paramRecyclerView.getLayoutManager();
      if ((localObject instanceof FinderLinearLayoutManager))
      {
        localObject = (FinderLinearLayoutManager)localObject;
        if (localObject == null) {
          break label126;
        }
        paramRecyclerView = paramRecyclerView.w(((FinderLinearLayoutManager)localObject).Ju(), false);
        if (!(paramRecyclerView instanceof com.tencent.mm.view.recyclerview.j)) {
          break label108;
        }
        paramRecyclerView = (com.tencent.mm.view.recyclerview.j)paramRecyclerView;
        label54:
        if (paramRecyclerView == null) {
          break label126;
        }
        paramRecyclerView = (FinderVideoLayout)paramRecyclerView.UH(e.e.finder_banner_video_layout);
        if (paramRecyclerView != null) {
          break label113;
        }
        paramRecyclerView = null;
        label75:
        if (!(paramRecyclerView instanceof FinderThumbPlayerProxy)) {
          break label121;
        }
      }
      label108:
      label113:
      label121:
      for (paramRecyclerView = (FinderThumbPlayerProxy)paramRecyclerView;; paramRecyclerView = null)
      {
        if (paramRecyclerView == null) {
          break label126;
        }
        float f = paramRecyclerView.getPlaySpeedRatio();
        AppMethodBeat.o(337518);
        return f;
        localObject = null;
        break;
        paramRecyclerView = null;
        break label54;
        paramRecyclerView = paramRecyclerView.getVideoView();
        break label75;
      }
      label126:
      AppMethodBeat.o(337518);
      return 1.0F;
    }
    
    public static String H(RecyclerView paramRecyclerView)
    {
      int j = 1;
      AppMethodBeat.i(337524);
      s.u(paramRecyclerView, "recyclerView");
      Context localContext = paramRecyclerView.getContext();
      float f = G(paramRecyclerView);
      if (f == 0.5F) {}
      for (int i = 1; i != 0; i = 0)
      {
        paramRecyclerView = localContext.getString(e.h.mega_video_play_speed_0_5);
        s.s(paramRecyclerView, "context.getString(R.stri…ega_video_play_speed_0_5)");
        AppMethodBeat.o(337524);
        return paramRecyclerView;
      }
      if (f == 1.0F)
      {
        i = 1;
        if (i != 0) {
          break label160;
        }
        if (f != 1.5F) {
          break label116;
        }
      }
      label116:
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label121;
        }
        paramRecyclerView = localContext.getString(e.h.mega_video_play_speed_1_5);
        s.s(paramRecyclerView, "context.getString(R.stri…ega_video_play_speed_1_5)");
        AppMethodBeat.o(337524);
        return paramRecyclerView;
        i = 0;
        break;
      }
      label121:
      if (f == 2.0F) {}
      for (i = j; i != 0; i = 0)
      {
        paramRecyclerView = localContext.getString(e.h.mega_video_play_speed_2);
        s.s(paramRecyclerView, "context.getString(R.stri….mega_video_play_speed_2)");
        AppMethodBeat.o(337524);
        return paramRecyclerView;
      }
      label160:
      paramRecyclerView = localContext.getString(e.h.mega_video_play_speed_text);
      s.s(paramRecyclerView, "context.getString(R.stri…ga_video_play_speed_text)");
      AppMethodBeat.o(337524);
      return paramRecyclerView;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<Integer>
  {
    public static final b GUx;
    
    static
    {
      AppMethodBeat.i(337506);
      GUx = new b();
      AppMethodBeat.o(337506);
    }
    
    b()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<Integer>
  {
    public static final c GUy;
    
    static
    {
      AppMethodBeat.i(337513);
      GUy = new c();
      AppMethodBeat.o(337513);
    }
    
    c()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<Integer>
  {
    public static final d GUz;
    
    static
    {
      AppMethodBeat.i(337509);
      GUz = new d();
      AppMethodBeat.o(337509);
    }
    
    d()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<Integer>
  {
    public static final e GUA;
    
    static
    {
      AppMethodBeat.i(337499);
      GUA = new e();
      AppMethodBeat.o(337499);
    }
    
    e()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/viewmodel/component/FinderSpeedControlUIC$hideSpeedControlArea$1$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    extends AnimatorListenerAdapter
  {
    f(View paramView) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(337497);
      this.DjW.setAlpha(1.0F);
      this.DjW.animate().setListener(null).cancel();
      AppMethodBeat.o(337497);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/viewmodel/component/FinderSpeedControlUIC$hideSpeedControlArea$2$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    extends AnimatorListenerAdapter
  {
    g(av paramav, View paramView) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(337496);
      paramAnimator = this.GUB.getActivity().getWindow().getDecorView();
      if ((paramAnimator instanceof ViewGroup)) {}
      for (paramAnimator = (ViewGroup)paramAnimator;; paramAnimator = null)
      {
        if (paramAnimator != null) {
          paramAnimator.removeView(av.a(this.GUB));
        }
        this.DjW.animate().setListener(null).cancel();
        AppMethodBeat.o(337496);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/viewmodel/component/FinderSpeedControlUIC$showSpeedControlArea$3$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class h
    extends AnimatorListenerAdapter
  {
    h(View paramView) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(337517);
      this.DjW.setVisibility(8);
      this.DjW.setAlpha(1.0F);
      this.DjW.animate().setListener(null).cancel();
      AppMethodBeat.o(337517);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.a<View>
  {
    i(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.av
 * JD-Core Version:    0.7.0.1
 */