package com.tencent.mm.plugin.finder.presenter.contract;

import android.content.Context;
import android.content.Intent;
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
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveTagConstract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveTagConstract$Presenter;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveTagConstract$Presenter;)V", "actionBtn", "Landroid/widget/TextView;", "getActionBtn", "()Landroid/widget/TextView;", "setActionBtn", "(Landroid/widget/TextView;)V", "cancelBtn", "getCancelBtn", "setCancelBtn", "header", "Landroid/widget/RelativeLayout;", "getHeader", "()Landroid/widget/RelativeLayout;", "setHeader", "(Landroid/widget/RelativeLayout;)V", "tagRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getTagRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setTagRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "titleTv", "getTitleTv", "setTitleTv", "finishWithResult", "", "getActivity", "getPresenter", "initView", "Companion", "plugin-finder_release"})
public final class FinderLiveTagConstract$ViewCallback
  implements c<FinderLiveTagConstract.Presenter>
{
  public static final Companion zNW;
  final MMActivity activity;
  public TextView mRJ;
  public TextView titleTv;
  private final FinderLiveTagConstract.Presenter ycH;
  public RelativeLayout zNN;
  public TextView zNP;
  public RecyclerView zNQ;
  
  static
  {
    AppMethodBeat.i(258147);
    zNW = new Companion((byte)0);
    AppMethodBeat.o(258147);
  }
  
  public FinderLiveTagConstract$ViewCallback(MMActivity paramMMActivity, FinderLiveTagConstract.Presenter paramPresenter)
  {
    AppMethodBeat.i(258146);
    this.activity = paramMMActivity;
    this.ycH = paramPresenter;
    AppMethodBeat.o(258146);
  }
  
  public final void asU()
  {
    AppMethodBeat.i(258144);
    Log.i("FinderLiveTagConstract.ViewCallback", "finishWithResult hasNextAction:" + this.ycH.zNK);
    if (this.ycH.zNK)
    {
      new Intent();
      Intent localIntent = new Intent();
      localIntent.putExtra("KEY_START_LIVE", true);
      this.activity.setResult(-1, localIntent);
      this.activity.finish();
      AppMethodBeat.o(258144);
      return;
    }
    this.activity.setResult(-1);
    this.activity.finish();
    AppMethodBeat.o(258144);
  }
  
  public final void initView()
  {
    AppMethodBeat.i(258143);
    Object localObject1 = this.activity.findViewById(b.f.finder_live_tag_ui_header);
    p.j(localObject1, "activity.findViewById(R.…inder_live_tag_ui_header)");
    this.zNN = ((RelativeLayout)localObject1);
    localObject1 = this.activity.findViewById(b.f.finder_live_tag_ui_header_cancel);
    p.j(localObject1, "activity.findViewById(R.…ive_tag_ui_header_cancel)");
    this.mRJ = ((TextView)localObject1);
    localObject1 = this.activity.findViewById(b.f.finder_live_tag_ui_header_title);
    p.j(localObject1, "activity.findViewById(R.…live_tag_ui_header_title)");
    this.titleTv = ((TextView)localObject1);
    localObject1 = this.activity.findViewById(b.f.finder_live_tag_ui_header_action_btn);
    p.j(localObject1, "activity.findViewById(R.…tag_ui_header_action_btn)");
    this.zNP = ((TextView)localObject1);
    localObject1 = this.activity.findViewById(b.f.finder_live_tag_ui_content);
    p.j(localObject1, "activity.findViewById(R.…nder_live_tag_ui_content)");
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
    ((RecyclerView)localObject1).setAdapter((RecyclerView.a)this.ycH.getAdapter());
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
    localObject1 = this.mRJ;
    if (localObject1 == null) {
      p.bGy("cancelBtn");
    }
    ((TextView)localObject1).setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(265301);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/presenter/contract/FinderLiveTagConstract$ViewCallback$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        FinderLiveTagConstract.ViewCallback.b(this.zNX).setResult(0);
        FinderLiveTagConstract.ViewCallback.b(this.zNX).finish();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/presenter/contract/FinderLiveTagConstract$ViewCallback$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(265301);
      }
    });
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
    localObject1 = this.zNP;
    if (localObject1 == null) {
      p.bGy("actionBtn");
    }
    if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.ycH.getLiveData().business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).yeG != null)
    {
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.ycH.getLiveData().business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).yeG;
      if (localObject2 != null)
      {
        localObject2 = ((bda)localObject2).ugl;
        localObject2 = (CharSequence)localObject2;
        if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
          break label549;
        }
        i = 1;
        label436:
        if (i != 0) {
          break label554;
        }
      }
    }
    label549:
    label554:
    for (boolean bool = true;; bool = false)
    {
      ((TextView)localObject1).setEnabled(bool);
      if (!this.ycH.zNK) {
        break label559;
      }
      localObject1 = this.zNP;
      if (localObject1 == null) {
        p.bGy("actionBtn");
      }
      localObject2 = this.activity.getContext();
      p.j(localObject2, "activity.context");
      ((TextView)localObject1).setText((CharSequence)((AppCompatActivity)localObject2).getResources().getString(b.j.finder_tag_start_live));
      localObject1 = this.zNP;
      if (localObject1 == null) {
        p.bGy("actionBtn");
      }
      ((TextView)localObject1).setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(225920);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/presenter/contract/FinderLiveTagConstract$ViewCallback$initView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          this.zNX.asU();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/presenter/contract/FinderLiveTagConstract$ViewCallback$initView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(225920);
        }
      });
      AppMethodBeat.o(258143);
      return;
      localObject2 = null;
      break;
      i = 0;
      break label436;
    }
    label559:
    localObject1 = this.zNP;
    if (localObject1 == null) {
      p.bGy("actionBtn");
    }
    localObject2 = this.activity.getContext();
    p.j(localObject2, "activity.context");
    ((TextView)localObject1).setText((CharSequence)((AppCompatActivity)localObject2).getResources().getString(b.j.app_finish));
    localObject1 = this.zNP;
    if (localObject1 == null) {
      p.bGy("actionBtn");
    }
    ((TextView)localObject1).setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(290082);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/presenter/contract/FinderLiveTagConstract$ViewCallback$initView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        this.zNX.asU();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/presenter/contract/FinderLiveTagConstract$ViewCallback$initView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(290082);
      }
    });
    AppMethodBeat.o(258143);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveTagConstract$ViewCallback$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class Companion {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.presenter.contract.FinderLiveTagConstract.ViewCallback
 * JD-Core Version:    0.7.0.1
 */