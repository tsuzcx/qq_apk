package com.tencent.mm.plugin.finder.presenter.contract;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.model.ah;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.h;
import com.tencent.mm.view.recyclerview.h.c;
import com.tencent.mm.view.recyclerview.i;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveTagConstract$Presenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveTagConstract$ViewCallback;", "tagData", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "hasNextAction", "", "(Ljava/util/ArrayList;Z)V", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "setAdapter", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "getHasNextAction", "()Z", "setHasNextAction", "(Z)V", "liveData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "getLiveData", "()Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "setLiveData", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "getTagData", "()Ljava/util/ArrayList;", "viewCallback", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveTagConstract$ViewCallback;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveTagConstract$ViewCallback;)V", "getData", "gotoSubTagUI", "", "tagIndex", "", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onAttach", "callback", "onDetach", "parseSubTagList", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTagInfo;", "Companion", "plugin-finder_release"})
public final class FinderLiveTagConstract$Presenter
  implements com.tencent.mm.plugin.finder.presenter.base.a<FinderLiveTagConstract.ViewCallback>
{
  public static final Companion zNU;
  public com.tencent.mm.plugin.finder.live.model.context.a xYp;
  public WxRecyclerAdapter<bu> xnR;
  private final ArrayList<bu> zNJ;
  boolean zNK;
  public FinderLiveTagConstract.ViewCallback zNT;
  
  static
  {
    AppMethodBeat.i(288993);
    zNU = new Companion((byte)0);
    AppMethodBeat.o(288993);
  }
  
  public FinderLiveTagConstract$Presenter(ArrayList<bu> paramArrayList, boolean paramBoolean)
  {
    AppMethodBeat.i(288992);
    this.zNJ = paramArrayList;
    this.zNK = paramBoolean;
    AppMethodBeat.o(288992);
  }
  
  public final void a(FinderLiveTagConstract.ViewCallback paramViewCallback)
  {
    AppMethodBeat.i(288990);
    p.k(paramViewCallback, "callback");
    Log.i("FinderLiveTagConstract.Presenter", "onAttach tagData:" + this.zNJ + " hasNextAction:" + this.zNK);
    Object localObject = ah.yhC;
    com.tencent.mm.plugin.finder.live.model.context.a locala = ah.dzj();
    localObject = locala;
    if (locala == null) {
      localObject = new com.tencent.mm.plugin.finder.live.model.context.a("FinderLiveTagConstract");
    }
    this.xYp = ((com.tencent.mm.plugin.finder.live.model.context.a)localObject);
    localObject = new WxRecyclerAdapter((f)new FinderLiveTagConstract.Presenter.onAttach.1(), this.zNJ);
    ((h)localObject).YSn = ((h.c)new h.c() {});
    this.xnR = ((WxRecyclerAdapter)localObject);
    this.zNT = paramViewCallback;
    paramViewCallback = this.zNT;
    if (paramViewCallback != null)
    {
      paramViewCallback.initView();
      AppMethodBeat.o(288990);
      return;
    }
    AppMethodBeat.o(288990);
  }
  
  public final WxRecyclerAdapter<bu> getAdapter()
  {
    AppMethodBeat.i(288988);
    WxRecyclerAdapter localWxRecyclerAdapter = this.xnR;
    if (localWxRecyclerAdapter == null) {
      p.bGy("adapter");
    }
    AppMethodBeat.o(288988);
    return localWxRecyclerAdapter;
  }
  
  public final com.tencent.mm.plugin.finder.live.model.context.a getLiveData()
  {
    AppMethodBeat.i(288989);
    com.tencent.mm.plugin.finder.live.model.context.a locala = this.xYp;
    if (locala == null) {
      p.bGy("liveData");
    }
    AppMethodBeat.o(288989);
    return locala;
  }
  
  public final void onDetach() {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveTagConstract$Presenter$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class Companion {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.presenter.contract.FinderLiveTagConstract.Presenter
 * JD-Core Version:    0.7.0.1
 */