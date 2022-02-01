package com.tencent.mm.plugin.finder.presenter.contract;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.presenter.base.c;
import com.tencent.mm.protocal.protobuf.bda;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ax;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveSubTagConstract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveSubTagConstract$Presenter;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveSubTagConstract$Presenter;)V", "actionBtn", "Landroid/widget/TextView;", "getActionBtn", "()Landroid/widget/TextView;", "setActionBtn", "(Landroid/widget/TextView;)V", "cancelBtn", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getCancelBtn", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setCancelBtn", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "header", "Landroid/widget/RelativeLayout;", "getHeader", "()Landroid/widget/RelativeLayout;", "setHeader", "(Landroid/widget/RelativeLayout;)V", "tagRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getTagRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setTagRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "titleTv", "getTitleTv", "setTitleTv", "getActivity", "getPresenter", "initView", "", "refreshActionBtn", "Companion", "plugin-finder_release"})
public final class FinderLiveSubTagConstract$ViewCallback
  implements c<FinderLiveSubTagConstract.Presenter>
{
  public static final Companion zNR;
  private final MMActivity activity;
  public TextView titleTv;
  private final FinderLiveSubTagConstract.Presenter ycF;
  public RelativeLayout zNN;
  public WeImageView zNO;
  public TextView zNP;
  public RecyclerView zNQ;
  
  static
  {
    AppMethodBeat.i(271214);
    zNR = new Companion((byte)0);
    AppMethodBeat.o(271214);
  }
  
  public FinderLiveSubTagConstract$ViewCallback(MMActivity paramMMActivity, FinderLiveSubTagConstract.Presenter paramPresenter)
  {
    AppMethodBeat.i(271213);
    this.activity = paramMMActivity;
    this.ycF = paramPresenter;
    AppMethodBeat.o(271213);
  }
  
  public final void dMZ()
  {
    boolean bool = true;
    AppMethodBeat.i(271210);
    TextView localTextView = this.zNP;
    if (localTextView == null) {
      p.bGy("actionBtn");
    }
    Object localObject;
    int i;
    if (this.ycF.zNF != null)
    {
      localObject = this.ycF.zNF;
      if (localObject != null)
      {
        localObject = ((bda)localObject).ugl;
        localObject = (CharSequence)localObject;
        if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
          break label97;
        }
        i = 1;
        label76:
        if (i != 0) {
          break label102;
        }
      }
    }
    for (;;)
    {
      localTextView.setEnabled(bool);
      AppMethodBeat.o(271210);
      return;
      localObject = null;
      break;
      label97:
      i = 0;
      break label76;
      label102:
      bool = false;
    }
  }
  
  public final void initView()
  {
    AppMethodBeat.i(271212);
    Object localObject1 = this.activity.findViewById(b.f.finder_live_sub_tag_ui_header);
    p.j(localObject1, "activity.findViewById(R.…r_live_sub_tag_ui_header)");
    this.zNN = ((RelativeLayout)localObject1);
    localObject1 = this.activity.findViewById(b.f.finder_live_sub_tag_ui_header_cancel);
    p.j(localObject1, "activity.findViewById(R.…sub_tag_ui_header_cancel)");
    this.zNO = ((WeImageView)localObject1);
    localObject1 = this.activity.findViewById(b.f.finder_live_sub_tag_ui_header_title);
    p.j(localObject1, "activity.findViewById(R.…_sub_tag_ui_header_title)");
    this.titleTv = ((TextView)localObject1);
    localObject1 = this.activity.findViewById(b.f.finder_live_sub_tag_ui_header_action_btn);
    p.j(localObject1, "activity.findViewById(R.…tag_ui_header_action_btn)");
    this.zNP = ((TextView)localObject1);
    localObject1 = this.activity.findViewById(b.f.finder_live_sub_tag_ui_content);
    p.j(localObject1, "activity.findViewById(R.…_live_sub_tag_ui_content)");
    this.zNQ = ((RecyclerView)localObject1);
    localObject1 = this.zNQ;
    if (localObject1 == null) {
      p.bGy("tagRecyclerView");
    }
    ((RecyclerView)localObject1).setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    localObject1 = this.zNQ;
    if (localObject1 == null) {
      p.bGy("tagRecyclerView");
    }
    ((RecyclerView)localObject1).setAdapter((RecyclerView.a)this.ycF.getAdapter());
    localObject1 = this.zNQ;
    if (localObject1 == null) {
      p.bGy("tagRecyclerView");
    }
    Object localObject2 = ((RecyclerView)localObject1).getLayoutParams();
    localObject1 = localObject2;
    if (!(localObject2 instanceof ViewGroup.MarginLayoutParams)) {
      localObject1 = null;
    }
    localObject1 = (ViewGroup.MarginLayoutParams)localObject1;
    int i;
    if (localObject1 != null)
    {
      i = ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin;
      ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin = (ax.aB((Context)this.activity) + i);
    }
    localObject2 = this.titleTv;
    if (localObject2 == null) {
      p.bGy("titleTv");
    }
    localObject1 = this.ycF.zNI;
    if (localObject1 != null)
    {
      localObject1 = ((bda)localObject1).ugl;
      ((TextView)localObject2).setText((CharSequence)localObject1);
      localObject1 = this.zNN;
      if (localObject1 == null) {
        p.bGy("header");
      }
      localObject2 = ((RelativeLayout)localObject1).getLayoutParams();
      localObject1 = localObject2;
      if (!(localObject2 instanceof ViewGroup.MarginLayoutParams)) {
        localObject1 = null;
      }
      localObject1 = (ViewGroup.MarginLayoutParams)localObject1;
      if (localObject1 != null)
      {
        i = ((ViewGroup.MarginLayoutParams)localObject1).topMargin;
        ((ViewGroup.MarginLayoutParams)localObject1).topMargin = (ax.getStatusBarHeight((Context)this.activity) + i);
      }
      localObject1 = this.zNO;
      if (localObject1 == null) {
        p.bGy("cancelBtn");
      }
      ((WeImageView)localObject1).setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(286577);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/presenter/contract/FinderLiveSubTagConstract$ViewCallback$initView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          FinderLiveSubTagConstract.ViewCallback.b(this.zNS).setResult(0);
          FinderLiveSubTagConstract.ViewCallback.b(this.zNS).finish();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/presenter/contract/FinderLiveSubTagConstract$ViewCallback$initView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(286577);
        }
      });
      dMZ();
      if (!this.ycF.zNK) {
        break label474;
      }
      localObject1 = this.zNP;
      if (localObject1 == null) {
        p.bGy("actionBtn");
      }
      localObject2 = this.activity.getContext();
      p.j(localObject2, "activity.context");
      ((TextView)localObject1).setText((CharSequence)((AppCompatActivity)localObject2).getResources().getString(b.j.finder_tag_start_live));
    }
    for (;;)
    {
      localObject1 = this.zNP;
      if (localObject1 == null) {
        p.bGy("actionBtn");
      }
      ((TextView)localObject1).setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          Object localObject1 = null;
          AppMethodBeat.i(274482);
          Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject2).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/presenter/contract/FinderLiveSubTagConstract$ViewCallback$initView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aFi());
          localObject2 = new StringBuilder("select live tag finish. lastTag:[");
          paramAnonymousView = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)FinderLiveSubTagConstract.ViewCallback.c(this.zNS).getLiveData().business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).yeG;
          if (paramAnonymousView != null)
          {
            paramAnonymousView = paramAnonymousView.ugl;
            localObject2 = ((StringBuilder)localObject2).append(paramAnonymousView).append('-');
            paramAnonymousView = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)FinderLiveSubTagConstract.ViewCallback.c(this.zNS).getLiveData().business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).yeG;
            if (paramAnonymousView == null) {
              break label302;
            }
            paramAnonymousView = paramAnonymousView.SOk;
            if (paramAnonymousView == null) {
              break label302;
            }
            paramAnonymousView = paramAnonymousView.ugl;
            label128:
            localObject2 = ((StringBuilder)localObject2).append(paramAnonymousView).append("] selectedTag:[");
            paramAnonymousView = FinderLiveSubTagConstract.ViewCallback.c(this.zNS).zNF;
            if (paramAnonymousView == null) {
              break label307;
            }
          }
          label302:
          label307:
          for (paramAnonymousView = paramAnonymousView.ugl;; paramAnonymousView = null)
          {
            localObject2 = ((StringBuilder)localObject2).append(paramAnonymousView).append('-');
            bda localbda = FinderLiveSubTagConstract.ViewCallback.c(this.zNS).zNF;
            paramAnonymousView = localObject1;
            if (localbda != null)
            {
              localbda = localbda.SOk;
              paramAnonymousView = localObject1;
              if (localbda != null) {
                paramAnonymousView = localbda.ugl;
              }
            }
            Log.i("FinderLiveSubTagConstract.ViewCallback", paramAnonymousView + ']');
            ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)FinderLiveSubTagConstract.ViewCallback.c(this.zNS).getLiveData().business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).yeG = FinderLiveSubTagConstract.ViewCallback.c(this.zNS).zNF;
            FinderLiveSubTagConstract.ViewCallback.b(this.zNS).setResult(-1);
            FinderLiveSubTagConstract.ViewCallback.b(this.zNS).finish();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/presenter/contract/FinderLiveSubTagConstract$ViewCallback$initView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(274482);
            return;
            paramAnonymousView = null;
            break;
            paramAnonymousView = null;
            break label128;
          }
        }
      });
      AppMethodBeat.o(271212);
      return;
      localObject1 = null;
      break;
      label474:
      localObject1 = this.zNP;
      if (localObject1 == null) {
        p.bGy("actionBtn");
      }
      localObject2 = this.activity.getContext();
      p.j(localObject2, "activity.context");
      ((TextView)localObject1).setText((CharSequence)((AppCompatActivity)localObject2).getResources().getString(b.j.app_finish));
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveSubTagConstract$ViewCallback$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class Companion {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.presenter.contract.FinderLiveSubTagConstract.ViewCallback
 * JD-Core Version:    0.7.0.1
 */