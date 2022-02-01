package com.tencent.mm.plugin.finder.presenter.contract;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.convert.at;
import com.tencent.mm.plugin.finder.live.model.o;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.presenter.base.a;
import com.tencent.mm.protocal.protobuf.axk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.g.c;
import com.tencent.mm.view.recyclerview.h;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveSubTagConstract$Presenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveSubTagConstract$ViewCallback;", "parentTag", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTagInfo;", "tagData", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "hasNextAction", "", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveTagInfo;Ljava/util/ArrayList;Z)V", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "setAdapter", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "convert", "Lcom/tencent/mm/plugin/finder/convert/FinderLiveSubTagConvert;", "getHasNextAction", "()Z", "setHasNextAction", "(Z)V", "liveData", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;", "getLiveData", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;", "setLiveData", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;)V", "getParentTag", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveTagInfo;", "selectedTag", "getSelectedTag", "setSelectedTag", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveTagInfo;)V", "getTagData", "()Ljava/util/ArrayList;", "viewCallback", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveSubTagConstract$ViewCallback;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveSubTagConstract$ViewCallback;)V", "getData", "onAttach", "", "callback", "onDetach", "Companion", "plugin-finder_release"})
public final class FinderLiveSubTagConstract$Presenter
  implements a<FinderLiveSubTagConstract.ViewCallback>
{
  public static final Companion uXw;
  public com.tencent.mm.plugin.finder.live.viewmodel.g liveData;
  public WxRecyclerAdapter<bo> tFp;
  axk uXq;
  private at uXr;
  FinderLiveSubTagConstract.ViewCallback uXs;
  final axk uXt;
  private final ArrayList<bo> uXu;
  boolean uXv;
  
  static
  {
    AppMethodBeat.i(249809);
    uXw = new Companion((byte)0);
    AppMethodBeat.o(249809);
  }
  
  public FinderLiveSubTagConstract$Presenter(axk paramaxk, ArrayList<bo> paramArrayList, boolean paramBoolean)
  {
    AppMethodBeat.i(249808);
    this.uXt = paramaxk;
    this.uXu = paramArrayList;
    this.uXv = paramBoolean;
    AppMethodBeat.o(249808);
  }
  
  public final void a(FinderLiveSubTagConstract.ViewCallback paramViewCallback)
  {
    AppMethodBeat.i(249806);
    p.h(paramViewCallback, "callback");
    Object localObject2 = new StringBuilder("onAttach parentTag:");
    Object localObject1 = this.uXt;
    if (localObject1 != null)
    {
      localObject1 = ((axk)localObject1).qHk;
      Log.i("FinderLiveSubTagConstract.Presenter", (String)localObject1 + " tagData:" + this.uXu + " hasNextAction:" + this.uXv);
      localObject1 = o.ujN;
      localObject2 = o.dfZ();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new com.tencent.mm.plugin.finder.live.viewmodel.g();
      }
      this.liveData = ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject1);
      localObject1 = this.liveData;
      if (localObject1 == null) {
        p.btv("liveData");
      }
      this.uXq = ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject1).uix;
      this.uXr = new at(this.uXq);
      localObject1 = new WxRecyclerAdapter((f)new f()
      {
        public final e<?> EC(int paramAnonymousInt)
        {
          AppMethodBeat.i(249804);
          e locale = (e)FinderLiveSubTagConstract.Presenter.a(this.uXx);
          AppMethodBeat.o(249804);
          return locale;
        }
      }, this.uXu);
      ((com.tencent.mm.view.recyclerview.g)localObject1).RqP = ((g.c)new g.c() {});
      this.tFp = ((WxRecyclerAdapter)localObject1);
      this.uXs = paramViewCallback;
      localObject2 = this.uXs;
      if (localObject2 == null) {
        break label774;
      }
      paramViewCallback = ((FinderLiveSubTagConstract.ViewCallback)localObject2).activity.findViewById(2131301277);
      p.g(paramViewCallback, "activity.findViewById(R.…r_live_sub_tag_ui_header)");
      ((FinderLiveSubTagConstract.ViewCallback)localObject2).uXy = ((RelativeLayout)paramViewCallback);
      paramViewCallback = ((FinderLiveSubTagConstract.ViewCallback)localObject2).activity.findViewById(2131301279);
      p.g(paramViewCallback, "activity.findViewById(R.…sub_tag_ui_header_cancel)");
      ((FinderLiveSubTagConstract.ViewCallback)localObject2).uXz = ((WeImageView)paramViewCallback);
      paramViewCallback = ((FinderLiveSubTagConstract.ViewCallback)localObject2).activity.findViewById(2131301280);
      p.g(paramViewCallback, "activity.findViewById(R.…_sub_tag_ui_header_title)");
      ((FinderLiveSubTagConstract.ViewCallback)localObject2).titleTv = ((TextView)paramViewCallback);
      paramViewCallback = ((FinderLiveSubTagConstract.ViewCallback)localObject2).activity.findViewById(2131301278);
      p.g(paramViewCallback, "activity.findViewById(R.…tag_ui_header_action_btn)");
      ((FinderLiveSubTagConstract.ViewCallback)localObject2).uXA = ((TextView)paramViewCallback);
      paramViewCallback = ((FinderLiveSubTagConstract.ViewCallback)localObject2).activity.findViewById(2131301276);
      p.g(paramViewCallback, "activity.findViewById(R.…_live_sub_tag_ui_content)");
      ((FinderLiveSubTagConstract.ViewCallback)localObject2).uXB = ((RecyclerView)paramViewCallback);
      paramViewCallback = ((FinderLiveSubTagConstract.ViewCallback)localObject2).uXB;
      if (paramViewCallback == null) {
        p.btv("tagRecyclerView");
      }
      paramViewCallback.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
      paramViewCallback = ((FinderLiveSubTagConstract.ViewCallback)localObject2).uXB;
      if (paramViewCallback == null) {
        p.btv("tagRecyclerView");
      }
      localObject1 = ((FinderLiveSubTagConstract.ViewCallback)localObject2).uXC.tFp;
      if (localObject1 == null) {
        p.btv("adapter");
      }
      paramViewCallback.setAdapter((RecyclerView.a)localObject1);
      paramViewCallback = ((FinderLiveSubTagConstract.ViewCallback)localObject2).uXB;
      if (paramViewCallback == null) {
        p.btv("tagRecyclerView");
      }
      localObject1 = paramViewCallback.getLayoutParams();
      paramViewCallback = (FinderLiveSubTagConstract.ViewCallback)localObject1;
      if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
        paramViewCallback = null;
      }
      paramViewCallback = (ViewGroup.MarginLayoutParams)paramViewCallback;
      int i;
      if (paramViewCallback != null)
      {
        i = paramViewCallback.bottomMargin;
        paramViewCallback.bottomMargin = (au.aD((Context)((FinderLiveSubTagConstract.ViewCallback)localObject2).activity) + i);
      }
      localObject1 = ((FinderLiveSubTagConstract.ViewCallback)localObject2).titleTv;
      if (localObject1 == null) {
        p.btv("titleTv");
      }
      paramViewCallback = ((FinderLiveSubTagConstract.ViewCallback)localObject2).uXC.uXt;
      if (paramViewCallback == null) {
        break label717;
      }
      paramViewCallback = paramViewCallback.qHk;
      label506:
      ((TextView)localObject1).setText((CharSequence)paramViewCallback);
      paramViewCallback = ((FinderLiveSubTagConstract.ViewCallback)localObject2).uXy;
      if (paramViewCallback == null) {
        p.btv("header");
      }
      localObject1 = paramViewCallback.getLayoutParams();
      paramViewCallback = (FinderLiveSubTagConstract.ViewCallback)localObject1;
      if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
        paramViewCallback = null;
      }
      paramViewCallback = (ViewGroup.MarginLayoutParams)paramViewCallback;
      if (paramViewCallback != null)
      {
        i = paramViewCallback.topMargin;
        paramViewCallback.topMargin = (au.getStatusBarHeight((Context)((FinderLiveSubTagConstract.ViewCallback)localObject2).activity) + i);
      }
      paramViewCallback = ((FinderLiveSubTagConstract.ViewCallback)localObject2).uXz;
      if (paramViewCallback == null) {
        p.btv("cancelBtn");
      }
      paramViewCallback.setOnClickListener((View.OnClickListener)new FinderLiveSubTagConstract.ViewCallback.initView.3((FinderLiveSubTagConstract.ViewCallback)localObject2));
      ((FinderLiveSubTagConstract.ViewCallback)localObject2).dlV();
      if (!((FinderLiveSubTagConstract.ViewCallback)localObject2).uXC.uXv) {
        break label722;
      }
      paramViewCallback = ((FinderLiveSubTagConstract.ViewCallback)localObject2).uXA;
      if (paramViewCallback == null) {
        p.btv("actionBtn");
      }
      localObject1 = ((FinderLiveSubTagConstract.ViewCallback)localObject2).activity.getContext();
      p.g(localObject1, "activity.context");
      paramViewCallback.setText((CharSequence)((AppCompatActivity)localObject1).getResources().getString(2131760620));
    }
    for (;;)
    {
      paramViewCallback = ((FinderLiveSubTagConstract.ViewCallback)localObject2).uXA;
      if (paramViewCallback == null) {
        p.btv("actionBtn");
      }
      paramViewCallback.setOnClickListener((View.OnClickListener)new FinderLiveSubTagConstract.ViewCallback.initView.4((FinderLiveSubTagConstract.ViewCallback)localObject2));
      AppMethodBeat.o(249806);
      return;
      localObject1 = null;
      break;
      label717:
      paramViewCallback = null;
      break label506;
      label722:
      paramViewCallback = ((FinderLiveSubTagConstract.ViewCallback)localObject2).uXA;
      if (paramViewCallback == null) {
        p.btv("actionBtn");
      }
      localObject1 = ((FinderLiveSubTagConstract.ViewCallback)localObject2).activity.getContext();
      p.g(localObject1, "activity.context");
      paramViewCallback.setText((CharSequence)((AppCompatActivity)localObject1).getResources().getString(2131755858));
    }
    label774:
    AppMethodBeat.o(249806);
  }
  
  public final com.tencent.mm.plugin.finder.live.viewmodel.g getLiveData()
  {
    AppMethodBeat.i(249805);
    com.tencent.mm.plugin.finder.live.viewmodel.g localg = this.liveData;
    if (localg == null) {
      p.btv("liveData");
    }
    AppMethodBeat.o(249805);
    return localg;
  }
  
  public final void onDetach() {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveSubTagConstract$Presenter$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class Companion {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.presenter.contract.FinderLiveSubTagConstract.Presenter
 * JD-Core Version:    0.7.0.1
 */