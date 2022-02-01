package com.tencent.mm.plugin.finder.live.component;

import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.live.model.aq;
import com.tencent.mm.plugin.finder.live.widget.i;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAnchorSearchMusicViewCallback;", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAnchorSearchMusicContract$ViewCallback;", "Landroid/view/View$OnClickListener;", "root", "Landroid/view/View;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAnchorSearchMusicContract$Presenter;", "(Landroid/view/View;Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAnchorSearchMusicContract$Presenter;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "animationHelper", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveSearchMusicSlideAnimHelper;", "getAnimationHelper", "()Lcom/tencent/mm/plugin/finder/live/component/FinderLiveSearchMusicSlideAnimHelper;", "setAnimationHelper", "(Lcom/tencent/mm/plugin/finder/live/component/FinderLiveSearchMusicSlideAnimHelper;)V", "back", "getBack", "()Landroid/view/View;", "setBack", "(Landroid/view/View;)V", "blankClickArea", "getBlankClickArea", "setBlankClickArea", "mainContentArea", "getMainContentArea", "setMainContentArea", "musicRv", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "getMusicRv", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "setMusicRv", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerView;)V", "musicRvWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorMusicRvWidget;", "getMusicRvWidget", "()Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorMusicRvWidget;", "setMusicRvWidget", "(Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorMusicRvWidget;)V", "searchDeleteIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getSearchDeleteIcon", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setSearchDeleteIcon", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "searchET", "Landroid/widget/EditText;", "getSearchET", "()Landroid/widget/EditText;", "setSearchET", "(Landroid/widget/EditText;)V", "searchViewContainer", "Landroid/widget/RelativeLayout;", "getSearchViewContainer", "()Landroid/widget/RelativeLayout;", "setSearchViewContainer", "(Landroid/widget/RelativeLayout;)V", "getActivity", "Lcom/tencent/mm/ui/MMFragmentActivity;", "getPresenter", "hideInput", "", "et", "initView", "onClick", "v", "showInput", "showSearchView", "showSuggestView", "suggestList", "", "Lcom/tencent/mm/plugin/finder/live/model/MusicItem;", "Companion", "plugin-finder_release"})
public final class g
  implements View.OnClickListener, e.b
{
  public static final a xZm;
  private final String TAG;
  private final MMActivity activity;
  private final View jac;
  private RelativeLayout xOh;
  private View xYC;
  WxRecyclerView xYQ;
  private i xYR;
  private View xYy;
  private View xZh;
  EditText xZi;
  WeImageView xZj;
  private ab xZk;
  final e.a xZl;
  
  static
  {
    AppMethodBeat.i(289972);
    xZm = new a((byte)0);
    AppMethodBeat.o(289972);
  }
  
  public g(View paramView, MMActivity paramMMActivity, e.a parama)
  {
    AppMethodBeat.i(289971);
    this.jac = paramView;
    this.activity = paramMMActivity;
    this.xZl = parama;
    this.TAG = "FinderLiveAnchorSearchMusicViewCallback";
    AppMethodBeat.o(289971);
  }
  
  private static void d(EditText paramEditText)
  {
    Object localObject2 = null;
    AppMethodBeat.i(289967);
    if (paramEditText != null)
    {
      localObject1 = paramEditText.getContext();
      if (localObject1 == null) {}
    }
    for (Object localObject1 = ((Context)localObject1).getSystemService("input_method");; localObject1 = null)
    {
      InputMethodManager localInputMethodManager = (InputMethodManager)localObject1;
      if (localInputMethodManager == null) {
        break;
      }
      localObject1 = localObject2;
      if (paramEditText != null) {
        localObject1 = paramEditText.getWindowToken();
      }
      localInputMethodManager.hideSoftInputFromWindow((IBinder)localObject1, 0);
      AppMethodBeat.o(289967);
      return;
    }
    AppMethodBeat.o(289967);
  }
  
  public final MMFragmentActivity dsB()
  {
    return (MMFragmentActivity)this.activity;
  }
  
  public final void dwW()
  {
    AppMethodBeat.i(289968);
    ab localab = this.xZk;
    if (localab != null)
    {
      View localView = this.jac;
      kotlin.g.a.a locala = (kotlin.g.a.a)new h(this);
      p.k(localView, "view");
      Object localObject1;
      Object localObject2;
      if (localab.ycy != null)
      {
        localObject1 = localab.ycy;
        if (localObject1 != null)
        {
          localObject1 = ((ObjectAnimator)localObject1).getTarget();
          localObject2 = localObject1;
          if (!(localObject1 instanceof View)) {
            localObject2 = null;
          }
          if (!p.h((View)localObject2, localView)) {
            break label160;
          }
          localObject1 = com.tencent.mm.plugin.finder.live.utils.a.yRm;
          com.tencent.mm.plugin.finder.live.utils.a.ha("FinderLiveSlideAnimHelper", "slideFromRight view:" + localView.hashCode() + " reuseAnim");
        }
      }
      for (;;)
      {
        localObject1 = localab.ycz;
        if (localObject1 != null) {
          ((af)localObject1).c(localView, locala);
        }
        localObject1 = localab.ycy;
        if (localObject1 == null) {
          break label248;
        }
        ((ObjectAnimator)localObject1).start();
        AppMethodBeat.o(289968);
        return;
        localObject1 = null;
        break;
        label160:
        localab.ycy = ObjectAnimator.ofFloat(localView, "translationX", new float[] { localab.ycw, 0.0F });
        localObject2 = localab.ycz;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new af();
        }
        localab.ycz = ((af)localObject1);
        localObject1 = localab.ycy;
        if (localObject1 != null) {
          ((ObjectAnimator)localObject1).addListener((Animator.AnimatorListener)localab.ycz);
        }
        localObject1 = localab.ycy;
        if (localObject1 != null) {
          ((ObjectAnimator)localObject1).setTarget(localView);
        }
      }
      label248:
      AppMethodBeat.o(289968);
      return;
    }
    AppMethodBeat.o(289968);
  }
  
  public final void ek(List<aq> paramList)
  {
    AppMethodBeat.i(289969);
    p.k(paramList, "suggestList");
    paramList = this.xYQ;
    if (paramList != null)
    {
      paramList.setVisibility(0);
      AppMethodBeat.o(289969);
      return;
    }
    AppMethodBeat.o(289969);
  }
  
  public final void initView()
  {
    AppMethodBeat.i(289966);
    this.xYy = this.jac.findViewById(b.f.finder_live_anchor_search_music_blank_area);
    Object localObject = this.xYy;
    if (localObject != null) {
      ((View)localObject).setOnClickListener((View.OnClickListener)this);
    }
    this.xZh = this.jac.findViewById(b.f.finder_live_anchor_search_music_content_area);
    localObject = this.xZh;
    if (localObject != null) {
      ((View)localObject).setOnClickListener((View.OnClickListener)this);
    }
    this.xYC = this.jac.findViewById(b.f.search_music_back_btn);
    localObject = this.xYC;
    if (localObject != null) {
      ((View)localObject).setOnClickListener((View.OnClickListener)this);
    }
    localObject = this.xYC;
    if (localObject != null)
    {
      com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      com.tencent.mm.plugin.finder.live.utils.a.eB((View)localObject);
    }
    this.xOh = ((RelativeLayout)this.jac.findViewById(b.f.search_music_search_group));
    localObject = this.xOh;
    if (localObject != null) {
      ((RelativeLayout)localObject).setOnClickListener((View.OnClickListener)new b(this));
    }
    this.xZi = ((EditText)this.jac.findViewById(b.f.search_music_search_view));
    localObject = com.tencent.mm.plugin.finder.live.utils.a.yRm;
    com.tencent.mm.plugin.finder.live.utils.a.a(this.xZi, null, 200, 100, (kotlin.g.a.a)new c(this));
    localObject = this.xZi;
    if (localObject != null) {
      ((EditText)localObject).setOnEditorActionListener((TextView.OnEditorActionListener)new d(this));
    }
    this.xZj = ((WeImageView)this.jac.findViewById(b.f.search_music_delete_icon));
    localObject = this.xZj;
    if (localObject != null) {
      ((WeImageView)localObject).setVisibility(0);
    }
    localObject = this.xZj;
    if (localObject != null) {
      ((WeImageView)localObject).setOnClickListener((View.OnClickListener)this);
    }
    localObject = this.jac.findViewById(b.f.finder_live_music_rv_root);
    p.j(localObject, "root.findViewById<Relati…inder_live_music_rv_root)");
    this.xYR = new i((ViewGroup)localObject, (b)this.xZl, (kotlin.g.a.b)new e(this));
    localObject = this.xYR;
    if (localObject != null) {}
    for (localObject = ((i)localObject).xYQ;; localObject = null)
    {
      this.xYQ = ((WxRecyclerView)localObject);
      this.xZk = new ab();
      AppMethodBeat.o(289966);
      return;
    }
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(289970);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/component/FinderLiveAnchorSearchMusicViewCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
    int i;
    if (paramView != null)
    {
      paramView = Integer.valueOf(paramView.getId());
      i = b.f.finder_live_anchor_search_music_blank_area;
      if (paramView != null) {
        break label103;
      }
      label59:
      i = b.f.search_music_back_btn;
      if (paramView != null) {
        break label417;
      }
      label67:
      i = b.f.search_music_delete_icon;
      if (paramView != null) {
        break label720;
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/component/FinderLiveAnchorSearchMusicViewCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(289970);
      return;
      paramView = null;
      break;
      label103:
      if (paramView.intValue() != i) {
        break label59;
      }
      paramView = this.xZl;
      if (paramView != null) {
        paramView.hide();
      }
      d(this.xZi);
      paramView = this.xZi;
      if (paramView != null) {
        paramView.setText((CharSequence)"");
      }
      ab localab = this.xZk;
      if (localab != null)
      {
        View localView = this.jac;
        kotlin.g.a.a locala = (kotlin.g.a.a)new f(this);
        p.k(localView, "view");
        if (localab.ycC != null)
        {
          paramView = localab.ycC;
          if (paramView != null)
          {
            paramView = paramView.getTarget();
            label212:
            localObject = paramView;
            if (!(paramView instanceof View)) {
              localObject = null;
            }
            if (!p.h((View)localObject, localView)) {
              break label322;
            }
            paramView = com.tencent.mm.plugin.finder.live.utils.a.yRm;
            com.tencent.mm.plugin.finder.live.utils.a.ha("FinderLiveSlideAnimHelper", "slideToBottomAnim view:" + localView.hashCode() + " reuseAnim");
          }
        }
        for (;;)
        {
          paramView = localab.ycD;
          if (paramView != null)
          {
            p.k(localView, "view");
            paramView.view = localView;
            paramView.ycL = locala;
          }
          paramView = localab.ycC;
          if (paramView == null) {
            break;
          }
          paramView.start();
          break;
          paramView = null;
          break label212;
          label322:
          localab.ycC = ObjectAnimator.ofFloat(localView, "translationY", new float[] { 0.0F, localab.ycx });
          localObject = localab.ycD;
          paramView = (View)localObject;
          if (localObject == null) {
            paramView = new ai();
          }
          localab.ycD = paramView;
          paramView = localab.ycC;
          if (paramView != null) {
            paramView.addListener((Animator.AnimatorListener)localab.ycD);
          }
          paramView = localab.ycC;
          if (paramView != null) {
            paramView.setTarget(localView);
          }
        }
        label417:
        if (paramView.intValue() != i) {
          break label67;
        }
        paramView = this.xZl;
        if (paramView != null) {
          paramView.ckA();
        }
        d(this.xZi);
        paramView = this.xZi;
        if (paramView != null) {
          paramView.setText((CharSequence)"");
        }
        localab = this.xZk;
        if (localab != null)
        {
          localView = this.jac;
          locala = (kotlin.g.a.a)new g(this);
          p.k(localView, "view");
          if (localab.ycA != null)
          {
            paramView = localab.ycA;
            if (paramView != null)
            {
              paramView = paramView.getTarget();
              label526:
              localObject = paramView;
              if (!(paramView instanceof View)) {
                localObject = null;
              }
              if (!p.h((View)localObject, localView)) {
                break label625;
              }
              paramView = com.tencent.mm.plugin.finder.live.utils.a.yRm;
              com.tencent.mm.plugin.finder.live.utils.a.ha("FinderLiveSlideAnimHelper", "slideToRightAnim view:" + localView.hashCode() + " reuseAnim");
            }
          }
          for (;;)
          {
            paramView = localab.ycB;
            if (paramView != null) {
              paramView.c(localView, locala);
            }
            paramView = localab.ycA;
            if (paramView == null) {
              break;
            }
            paramView.start();
            break;
            paramView = null;
            break label526;
            label625:
            localab.ycA = ObjectAnimator.ofFloat(localView, "translationX", new float[] { 0.0F, localab.ycw });
            localObject = localab.ycB;
            paramView = (View)localObject;
            if (localObject == null) {
              paramView = new af();
            }
            localab.ycB = paramView;
            paramView = localab.ycA;
            if (paramView != null) {
              paramView.addListener((Animator.AnimatorListener)localab.ycB);
            }
            paramView = localab.ycA;
            if (paramView != null) {
              paramView.setTarget(localView);
            }
          }
          label720:
          if (paramView.intValue() == i)
          {
            paramView = this.xZi;
            if (paramView != null) {
              paramView.setText((CharSequence)"");
            }
          }
        }
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAnchorSearchMusicViewCallback$Companion;", "", "()V", "MAX_INPUT_LENGTH", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(g paramg) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(264552);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/component/FinderLiveAnchorSearchMusicViewCallback$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      g.e(this.xZn.xZi);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/component/FinderLiveAnchorSearchMusicViewCallback$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(264552);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<x>
  {
    c(g paramg)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "v", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "actionId", "", "event", "Landroid/view/KeyEvent;", "onEditorAction"})
  static final class d
    implements TextView.OnEditorActionListener
  {
    d(g paramg) {}
    
    public final boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
    {
      AppMethodBeat.i(285776);
      if (paramInt == 6) {
        g.f(this.xZn.xZi);
      }
      AppMethodBeat.o(285776);
      return false;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.b<Integer, x>
  {
    e(g paramg)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<x>
  {
    f(g paramg)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.a<x>
  {
    g(g paramg)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.a<x>
  {
    h(g paramg)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.g
 * JD-Core Version:    0.7.0.1
 */