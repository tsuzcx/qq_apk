package com.tencent.mm.plugin.finder.live.component;

import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.model.at;
import com.tencent.mm.plugin.finder.view.ad;
import com.tencent.mm.plugin.finder.view.ai;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAnchorSearchMusicViewCallback;", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAnchorSearchMusicContract$ViewCallback;", "Landroid/view/View$OnClickListener;", "root", "Landroid/view/View;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAnchorSearchMusicContract$Presenter;", "(Landroid/view/View;Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAnchorSearchMusicContract$Presenter;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "animationHelper", "Lcom/tencent/mm/plugin/finder/view/FinderSlideAnimHelper;", "getAnimationHelper", "()Lcom/tencent/mm/plugin/finder/view/FinderSlideAnimHelper;", "setAnimationHelper", "(Lcom/tencent/mm/plugin/finder/view/FinderSlideAnimHelper;)V", "back", "getBack", "()Landroid/view/View;", "setBack", "(Landroid/view/View;)V", "blankClickArea", "getBlankClickArea", "setBlankClickArea", "mainContentArea", "getMainContentArea", "setMainContentArea", "musicRv", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "getMusicRv", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "setMusicRv", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerView;)V", "musicRvWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorMusicRvWidget;", "getMusicRvWidget", "()Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorMusicRvWidget;", "setMusicRvWidget", "(Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorMusicRvWidget;)V", "searchDeleteIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getSearchDeleteIcon", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setSearchDeleteIcon", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "searchET", "Landroid/widget/EditText;", "getSearchET", "()Landroid/widget/EditText;", "setSearchET", "(Landroid/widget/EditText;)V", "searchViewContainer", "Landroid/widget/RelativeLayout;", "getSearchViewContainer", "()Landroid/widget/RelativeLayout;", "setSearchViewContainer", "(Landroid/widget/RelativeLayout;)V", "getActivity", "Lcom/tencent/mm/ui/MMFragmentActivity;", "getPresenter", "hideInput", "", "et", "initView", "onClick", "v", "showInput", "showSearchView", "showSuggestView", "suggestList", "", "Lcom/tencent/mm/plugin/finder/live/model/MusicItem;", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class p
  implements View.OnClickListener, n.b
{
  public static final p.a Cxr;
  private RelativeLayout Boj;
  private View CwQ;
  private View CwU;
  WxRecyclerView Cxi;
  private com.tencent.mm.plugin.finder.live.widget.n Cxj;
  final n.a Cxs;
  private View Cxt;
  EditText Cxu;
  WeImageView Cxv;
  private com.tencent.mm.plugin.finder.view.n Cxw;
  private final String TAG;
  private final MMActivity activity;
  private final View lBX;
  
  static
  {
    AppMethodBeat.i(352973);
    Cxr = new p.a((byte)0);
    AppMethodBeat.o(352973);
  }
  
  public p(View paramView, MMActivity paramMMActivity, n.a parama)
  {
    AppMethodBeat.i(352903);
    this.lBX = paramView;
    this.activity = paramMMActivity;
    this.Cxs = parama;
    this.TAG = "FinderLiveAnchorSearchMusicViewCallback";
    AppMethodBeat.o(352903);
  }
  
  private static final void a(p paramp, View paramView)
  {
    AppMethodBeat.i(352933);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramp);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/component/FinderLiveAnchorSearchMusicViewCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramp, "this$0");
    d(paramp.Cxu);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/component/FinderLiveAnchorSearchMusicViewCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(352933);
  }
  
  private static final boolean a(p paramp, TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(352941);
    s.u(paramp, "this$0");
    if (paramInt == 6) {
      e(paramp.Cxu);
    }
    AppMethodBeat.o(352941);
    return false;
  }
  
  private static void d(EditText paramEditText)
  {
    Object localObject = null;
    AppMethodBeat.i(352918);
    if (paramEditText != null) {
      paramEditText.requestFocus();
    }
    if (paramEditText == null) {}
    for (;;)
    {
      localObject = (InputMethodManager)localObject;
      if (localObject != null) {
        ((InputMethodManager)localObject).showSoftInput((View)paramEditText, 0);
      }
      AppMethodBeat.o(352918);
      return;
      Context localContext = paramEditText.getContext();
      if (localContext != null) {
        localObject = localContext.getSystemService("input_method");
      }
    }
  }
  
  private static void e(EditText paramEditText)
  {
    Object localObject2 = null;
    AppMethodBeat.i(352927);
    Object localObject1;
    if (paramEditText == null)
    {
      localObject1 = null;
      localObject1 = (InputMethodManager)localObject1;
      if (localObject1 != null) {
        if (paramEditText != null) {
          break label65;
        }
      }
    }
    label65:
    for (paramEditText = localObject2;; paramEditText = paramEditText.getWindowToken())
    {
      ((InputMethodManager)localObject1).hideSoftInputFromWindow(paramEditText, 0);
      AppMethodBeat.o(352927);
      return;
      localObject1 = paramEditText.getContext();
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = ((Context)localObject1).getSystemService("input_method");
      break;
    }
  }
  
  public final MMFragmentActivity dUP()
  {
    return (MMFragmentActivity)this.activity;
  }
  
  public final void ehD()
  {
    AppMethodBeat.i(353017);
    com.tencent.mm.plugin.finder.view.n localn = this.Cxw;
    View localView;
    kotlin.g.a.a locala;
    Object localObject;
    if (localn != null)
    {
      localView = this.lBX;
      locala = (kotlin.g.a.a)new f(this);
      s.u(localView, "view");
      s.u(localView, "view");
      if (localn.GCf == null) {
        break label172;
      }
      localObject = localn.GCf;
      if (localObject != null) {
        break label159;
      }
      localObject = null;
      if (!(localObject instanceof View)) {
        break label167;
      }
      localObject = (View)localObject;
      label80:
      if (!s.p(localObject, localView)) {
        break label172;
      }
      com.tencent.mm.plugin.finder.view.n.hQ("FinderLiveSlideAnimHelper", "slideFromRight view:" + localView.hashCode() + " reuseAnim");
    }
    for (;;)
    {
      localObject = localn.GCg;
      if (localObject != null) {
        ((ad)localObject).b(localView, locala);
      }
      localObject = localn.GCf;
      if (localObject != null) {
        ((ObjectAnimator)localObject).start();
      }
      AppMethodBeat.o(353017);
      return;
      label159:
      localObject = ((ObjectAnimator)localObject).getTarget();
      break;
      label167:
      localObject = null;
      break label80;
      label172:
      localn.GCf = ObjectAnimator.ofFloat(localView, "translationX", new float[] { com.tencent.mm.plugin.finder.view.n.getWIDTH(), 0.0F });
      ad localad = localn.GCg;
      localObject = localad;
      if (localad == null) {
        localObject = new ad();
      }
      localn.GCg = ((ad)localObject);
      localObject = localn.GCf;
      if (localObject != null) {
        ((ObjectAnimator)localObject).addListener((Animator.AnimatorListener)localn.GCg);
      }
      localObject = localn.GCf;
      if (localObject != null) {
        ((ObjectAnimator)localObject).setTarget(localView);
      }
    }
  }
  
  public final void gm(List<at> paramList)
  {
    AppMethodBeat.i(353024);
    s.u(paramList, "suggestList");
    paramList = this.Cxi;
    if (paramList != null) {
      paramList.setVisibility(0);
    }
    AppMethodBeat.o(353024);
  }
  
  public final void initView()
  {
    AppMethodBeat.i(353006);
    this.CwQ = this.lBX.findViewById(com.tencent.mm.plugin.finder.live.p.e.BGu);
    Object localObject = this.CwQ;
    if (localObject != null) {
      ((View)localObject).setOnClickListener((View.OnClickListener)this);
    }
    this.Cxt = this.lBX.findViewById(com.tencent.mm.plugin.finder.live.p.e.BGv);
    localObject = this.Cxt;
    if (localObject != null) {
      ((View)localObject).setOnClickListener((View.OnClickListener)this);
    }
    this.CwU = this.lBX.findViewById(com.tencent.mm.plugin.finder.live.p.e.CaD);
    localObject = this.CwU;
    if (localObject != null) {
      ((View)localObject).setOnClickListener((View.OnClickListener)this);
    }
    localObject = this.CwU;
    if (localObject != null)
    {
      com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      com.tencent.mm.plugin.finder.live.utils.a.gf((View)localObject);
    }
    this.Boj = ((RelativeLayout)this.lBX.findViewById(com.tencent.mm.plugin.finder.live.p.e.CaF));
    localObject = this.Boj;
    if (localObject != null) {
      ((RelativeLayout)localObject).setOnClickListener(new p..ExternalSyntheticLambda0(this));
    }
    this.Cxu = ((EditText)this.lBX.findViewById(com.tencent.mm.plugin.finder.live.p.e.CaG));
    localObject = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    com.tencent.mm.plugin.finder.live.utils.a.a(this.Cxu, 200, 100, (kotlin.g.a.a)new b(this));
    localObject = this.Cxu;
    if (localObject != null) {
      ((EditText)localObject).setOnEditorActionListener(new p..ExternalSyntheticLambda1(this));
    }
    this.Cxv = ((WeImageView)this.lBX.findViewById(com.tencent.mm.plugin.finder.live.p.e.CaE));
    localObject = this.Cxv;
    if (localObject != null) {
      ((WeImageView)localObject).setVisibility(0);
    }
    localObject = this.Cxv;
    if (localObject != null) {
      ((WeImageView)localObject).setOnClickListener((View.OnClickListener)this);
    }
    localObject = this.lBX.findViewById(com.tencent.mm.plugin.finder.live.p.e.BPp);
    s.s(localObject, "root.findViewById<Relati…inder_live_music_rv_root)");
    this.Cxj = new com.tencent.mm.plugin.finder.live.widget.n((ViewGroup)localObject, (k)this.Cxs, (kotlin.g.a.b)new c(this));
    localObject = this.Cxj;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((com.tencent.mm.plugin.finder.live.widget.n)localObject).Cxi)
    {
      this.Cxi = ((WxRecyclerView)localObject);
      this.Cxw = new com.tencent.mm.plugin.finder.view.n();
      AppMethodBeat.o(353006);
      return;
    }
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(353047);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/component/FinderLiveAnchorSearchMusicViewCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
    int i;
    if (paramView == null)
    {
      paramView = null;
      i = com.tencent.mm.plugin.finder.live.p.e.BGu;
      if (paramView != null) {
        break label95;
      }
      label49:
      i = com.tencent.mm.plugin.finder.live.p.e.CaD;
      if (paramView != null) {
        break label409;
      }
      label57:
      i = com.tencent.mm.plugin.finder.live.p.e.CaE;
      if (paramView != null) {
        break label719;
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/component/FinderLiveAnchorSearchMusicViewCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(353047);
      return;
      paramView = Integer.valueOf(paramView.getId());
      break;
      label95:
      if (paramView.intValue() != i) {
        break label49;
      }
      paramView = this.Cxs;
      if (paramView != null) {
        paramView.hide();
      }
      e(this.Cxu);
      paramView = this.Cxu;
      if (paramView != null) {
        paramView.setText((CharSequence)"");
      }
      com.tencent.mm.plugin.finder.view.n localn = this.Cxw;
      if (localn != null)
      {
        View localView = this.lBX;
        kotlin.g.a.a locala = (kotlin.g.a.a)new d(this);
        s.u(localView, "view");
        if (localn.GCj != null)
        {
          paramView = localn.GCj;
          if (paramView == null)
          {
            paramView = null;
            label202:
            if (!(paramView instanceof View)) {
              break label311;
            }
            paramView = (View)paramView;
            label214:
            if (!s.p(paramView, localView)) {
              break label316;
            }
            com.tencent.mm.plugin.finder.view.n.hQ("FinderLiveSlideAnimHelper", "slideToBottomAnim view:" + localView.hashCode() + " reuseAnim");
          }
        }
        for (;;)
        {
          paramView = localn.GCk;
          if (paramView != null)
          {
            s.u(localView, "view");
            paramView.view = localView;
            paramView.GEC = locala;
          }
          paramView = localn.GCj;
          if (paramView == null) {
            break;
          }
          paramView.start();
          break;
          paramView = paramView.getTarget();
          break label202;
          label311:
          paramView = null;
          break label214;
          label316:
          localn.GCj = ObjectAnimator.ofFloat(localView, "translationY", new float[] { 0.0F, com.tencent.mm.plugin.finder.view.n.getHEIGHT() });
          localObject = localn.GCk;
          paramView = (View)localObject;
          if (localObject == null) {
            paramView = new ai();
          }
          localn.GCk = paramView;
          paramView = localn.GCj;
          if (paramView != null) {
            paramView.addListener((Animator.AnimatorListener)localn.GCk);
          }
          paramView = localn.GCj;
          if (paramView != null) {
            paramView.setTarget(localView);
          }
        }
        label409:
        if (paramView.intValue() != i) {
          break label57;
        }
        paramView = this.Cxs;
        if (paramView != null) {
          paramView.cLO();
        }
        e(this.Cxu);
        paramView = this.Cxu;
        if (paramView != null) {
          paramView.setText((CharSequence)"");
        }
        localn = this.Cxw;
        if (localn != null)
        {
          localView = this.lBX;
          locala = (kotlin.g.a.a)new e(this);
          s.u(localView, "view");
          s.u(localView, "view");
          if (localn.GCh != null)
          {
            paramView = localn.GCh;
            if (paramView == null)
            {
              paramView = null;
              label524:
              if (!(paramView instanceof View)) {
                break label621;
              }
              paramView = (View)paramView;
              label536:
              if (!s.p(paramView, localView)) {
                break label626;
              }
              com.tencent.mm.plugin.finder.view.n.hQ("FinderLiveSlideAnimHelper", "slideToRightAnim view:" + localView.hashCode() + " reuseAnim");
            }
          }
          for (;;)
          {
            paramView = localn.GCi;
            if (paramView != null) {
              paramView.b(localView, locala);
            }
            paramView = localn.GCh;
            if (paramView == null) {
              break;
            }
            paramView.start();
            break;
            paramView = paramView.getTarget();
            break label524;
            label621:
            paramView = null;
            break label536;
            label626:
            localn.GCh = ObjectAnimator.ofFloat(localView, "translationX", new float[] { 0.0F, com.tencent.mm.plugin.finder.view.n.getWIDTH() });
            localObject = localn.GCi;
            paramView = (View)localObject;
            if (localObject == null) {
              paramView = new ad();
            }
            localn.GCi = paramView;
            paramView = localn.GCh;
            if (paramView != null) {
              paramView.addListener((Animator.AnimatorListener)localn.GCi);
            }
            paramView = localn.GCh;
            if (paramView != null) {
              paramView.setTarget(localView);
            }
          }
          label719:
          if (paramView.intValue() == i)
          {
            paramView = this.Cxu;
            if (paramView != null) {
              paramView.setText((CharSequence)"");
            }
          }
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(p paramp)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<Integer, ah>
  {
    c(p paramp)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(p paramp)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<ah>
  {
    e(p paramp)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<ah>
  {
    f(p paramp)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.p
 * JD-Core Version:    0.7.0.1
 */