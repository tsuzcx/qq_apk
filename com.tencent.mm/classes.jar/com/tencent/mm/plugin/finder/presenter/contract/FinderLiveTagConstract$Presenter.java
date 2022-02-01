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
import com.tencent.mm.plugin.finder.live.model.o;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.presenter.base.a;
import com.tencent.mm.protocal.protobuf.axk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.g.c;
import com.tencent.mm.view.recyclerview.h;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveTagConstract$Presenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveTagConstract$ViewCallback;", "tagData", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "hasNextAction", "", "(Ljava/util/ArrayList;Z)V", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "setAdapter", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "getHasNextAction", "()Z", "setHasNextAction", "(Z)V", "liveData", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;", "getLiveData", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;", "setLiveData", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;)V", "getTagData", "()Ljava/util/ArrayList;", "viewCallback", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveTagConstract$ViewCallback;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveTagConstract$ViewCallback;)V", "getData", "gotoSubTagUI", "", "tagIndex", "", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onAttach", "callback", "onDetach", "parseSubTagList", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTagInfo;", "Companion", "plugin-finder_release"})
public final class FinderLiveTagConstract$Presenter
  implements a<FinderLiveTagConstract.ViewCallback>
{
  public static final Companion uXG;
  public com.tencent.mm.plugin.finder.live.viewmodel.g liveData;
  public WxRecyclerAdapter<bo> tFp;
  public FinderLiveTagConstract.ViewCallback uXF;
  private final ArrayList<bo> uXu;
  boolean uXv;
  
  static
  {
    AppMethodBeat.i(249822);
    uXG = new Companion((byte)0);
    AppMethodBeat.o(249822);
  }
  
  public FinderLiveTagConstract$Presenter(ArrayList<bo> paramArrayList, boolean paramBoolean)
  {
    AppMethodBeat.i(249821);
    this.uXu = paramArrayList;
    this.uXv = paramBoolean;
    AppMethodBeat.o(249821);
  }
  
  private com.tencent.mm.plugin.finder.live.viewmodel.g getLiveData()
  {
    AppMethodBeat.i(249818);
    com.tencent.mm.plugin.finder.live.viewmodel.g localg = this.liveData;
    if (localg == null) {
      p.btv("liveData");
    }
    AppMethodBeat.o(249818);
    return localg;
  }
  
  public final void a(FinderLiveTagConstract.ViewCallback paramViewCallback)
  {
    AppMethodBeat.i(249819);
    p.h(paramViewCallback, "callback");
    Log.i("FinderLiveTagConstract.Presenter", "onAttach tagData:" + this.uXu + " hasNextAction:" + this.uXv);
    Object localObject1 = o.ujN;
    Object localObject2 = o.dfZ();
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new com.tencent.mm.plugin.finder.live.viewmodel.g();
    }
    this.liveData = ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject1);
    localObject1 = new WxRecyclerAdapter((f)new f()
    {
      public final e<?> EC(int paramAnonymousInt)
      {
        AppMethodBeat.i(249817);
        Object localObject = o.ujN;
        localObject = o.dfZ();
        if (localObject != null) {}
        for (localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject).uix;; localObject = null)
        {
          localObject = (e)new com.tencent.mm.plugin.finder.convert.au((axk)localObject);
          AppMethodBeat.o(249817);
          return localObject;
        }
      }
    }, this.uXu);
    ((com.tencent.mm.view.recyclerview.g)localObject1).RqP = ((g.c)new g.c() {});
    this.tFp = ((WxRecyclerAdapter)localObject1);
    this.uXF = paramViewCallback;
    localObject2 = this.uXF;
    if (localObject2 != null)
    {
      paramViewCallback = ((FinderLiveTagConstract.ViewCallback)localObject2).activity.findViewById(2131301291);
      p.g(paramViewCallback, "activity.findViewById(R.…inder_live_tag_ui_header)");
      ((FinderLiveTagConstract.ViewCallback)localObject2).uXy = ((RelativeLayout)paramViewCallback);
      paramViewCallback = ((FinderLiveTagConstract.ViewCallback)localObject2).activity.findViewById(2131301293);
      p.g(paramViewCallback, "activity.findViewById(R.…ive_tag_ui_header_cancel)");
      ((FinderLiveTagConstract.ViewCallback)localObject2).kaq = ((TextView)paramViewCallback);
      paramViewCallback = ((FinderLiveTagConstract.ViewCallback)localObject2).activity.findViewById(2131301294);
      p.g(paramViewCallback, "activity.findViewById(R.…live_tag_ui_header_title)");
      ((FinderLiveTagConstract.ViewCallback)localObject2).titleTv = ((TextView)paramViewCallback);
      paramViewCallback = ((FinderLiveTagConstract.ViewCallback)localObject2).activity.findViewById(2131301292);
      p.g(paramViewCallback, "activity.findViewById(R.…tag_ui_header_action_btn)");
      ((FinderLiveTagConstract.ViewCallback)localObject2).uXA = ((TextView)paramViewCallback);
      paramViewCallback = ((FinderLiveTagConstract.ViewCallback)localObject2).activity.findViewById(2131301290);
      p.g(paramViewCallback, "activity.findViewById(R.…nder_live_tag_ui_content)");
      ((FinderLiveTagConstract.ViewCallback)localObject2).uXB = ((RecyclerView)paramViewCallback);
      paramViewCallback = ((FinderLiveTagConstract.ViewCallback)localObject2).uXB;
      if (paramViewCallback == null) {
        p.btv("tagRecyclerView");
      }
      paramViewCallback.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
      paramViewCallback = ((FinderLiveTagConstract.ViewCallback)localObject2).uXB;
      if (paramViewCallback == null) {
        p.btv("tagRecyclerView");
      }
      localObject1 = ((FinderLiveTagConstract.ViewCallback)localObject2).uXI.tFp;
      if (localObject1 == null) {
        p.btv("adapter");
      }
      paramViewCallback.setAdapter((RecyclerView.a)localObject1);
      paramViewCallback = ((FinderLiveTagConstract.ViewCallback)localObject2).uXB;
      if (paramViewCallback == null) {
        p.btv("tagRecyclerView");
      }
      localObject1 = paramViewCallback.getLayoutParams();
      paramViewCallback = (FinderLiveTagConstract.ViewCallback)localObject1;
      if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
        paramViewCallback = null;
      }
      paramViewCallback = (ViewGroup.MarginLayoutParams)paramViewCallback;
      int i;
      if (paramViewCallback != null)
      {
        i = paramViewCallback.bottomMargin;
        paramViewCallback.bottomMargin = (com.tencent.mm.ui.au.aD((Context)((FinderLiveTagConstract.ViewCallback)localObject2).activity) + i);
      }
      paramViewCallback = ((FinderLiveTagConstract.ViewCallback)localObject2).kaq;
      if (paramViewCallback == null) {
        p.btv("cancelBtn");
      }
      paramViewCallback.setOnClickListener((View.OnClickListener)new FinderLiveTagConstract.ViewCallback.initView.2((FinderLiveTagConstract.ViewCallback)localObject2));
      paramViewCallback = ((FinderLiveTagConstract.ViewCallback)localObject2).uXy;
      if (paramViewCallback == null) {
        p.btv("header");
      }
      localObject1 = paramViewCallback.getLayoutParams();
      paramViewCallback = (FinderLiveTagConstract.ViewCallback)localObject1;
      if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
        paramViewCallback = null;
      }
      paramViewCallback = (ViewGroup.MarginLayoutParams)paramViewCallback;
      if (paramViewCallback != null)
      {
        i = paramViewCallback.topMargin;
        paramViewCallback.topMargin = (com.tencent.mm.ui.au.getStatusBarHeight((Context)((FinderLiveTagConstract.ViewCallback)localObject2).activity) + i);
      }
      paramViewCallback = ((FinderLiveTagConstract.ViewCallback)localObject2).uXA;
      if (paramViewCallback == null) {
        p.btv("actionBtn");
      }
      if (((FinderLiveTagConstract.ViewCallback)localObject2).uXI.getLiveData().uix != null)
      {
        localObject1 = ((FinderLiveTagConstract.ViewCallback)localObject2).uXI.getLiveData().uix;
        if (localObject1 != null)
        {
          localObject1 = ((axk)localObject1).qHk;
          localObject1 = (CharSequence)localObject1;
          if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
            break label719;
          }
          i = 1;
          label601:
          if (i != 0) {
            break label724;
          }
        }
      }
      label719:
      label724:
      for (boolean bool = true;; bool = false)
      {
        paramViewCallback.setEnabled(bool);
        if (!((FinderLiveTagConstract.ViewCallback)localObject2).uXI.uXv) {
          break label729;
        }
        paramViewCallback = ((FinderLiveTagConstract.ViewCallback)localObject2).uXA;
        if (paramViewCallback == null) {
          p.btv("actionBtn");
        }
        localObject1 = ((FinderLiveTagConstract.ViewCallback)localObject2).activity.getContext();
        p.g(localObject1, "activity.context");
        paramViewCallback.setText((CharSequence)((AppCompatActivity)localObject1).getResources().getString(2131760620));
        paramViewCallback = ((FinderLiveTagConstract.ViewCallback)localObject2).uXA;
        if (paramViewCallback == null) {
          p.btv("actionBtn");
        }
        paramViewCallback.setOnClickListener((View.OnClickListener)new FinderLiveTagConstract.ViewCallback.initView.4((FinderLiveTagConstract.ViewCallback)localObject2));
        AppMethodBeat.o(249819);
        return;
        localObject1 = null;
        break;
        i = 0;
        break label601;
      }
      label729:
      paramViewCallback = ((FinderLiveTagConstract.ViewCallback)localObject2).uXA;
      if (paramViewCallback == null) {
        p.btv("actionBtn");
      }
      localObject1 = ((FinderLiveTagConstract.ViewCallback)localObject2).activity.getContext();
      p.g(localObject1, "activity.context");
      paramViewCallback.setText((CharSequence)((AppCompatActivity)localObject1).getResources().getString(2131755858));
      paramViewCallback = ((FinderLiveTagConstract.ViewCallback)localObject2).uXA;
      if (paramViewCallback == null) {
        p.btv("actionBtn");
      }
      paramViewCallback.setOnClickListener((View.OnClickListener)new FinderLiveTagConstract.ViewCallback.initView.5((FinderLiveTagConstract.ViewCallback)localObject2));
      AppMethodBeat.o(249819);
      return;
    }
    AppMethodBeat.o(249819);
  }
  
  public final void onDetach() {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveTagConstract$Presenter$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class Companion {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.presenter.contract.FinderLiveTagConstract.Presenter
 * JD-Core Version:    0.7.0.1
 */