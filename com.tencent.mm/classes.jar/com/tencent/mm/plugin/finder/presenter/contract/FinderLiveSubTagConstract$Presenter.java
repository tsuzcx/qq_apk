package com.tencent.mm.plugin.finder.presenter.contract;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.convert.av;
import com.tencent.mm.plugin.finder.live.model.ah;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.b;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.protocal.protobuf.bda;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.h;
import com.tencent.mm.view.recyclerview.h.c;
import com.tencent.mm.view.recyclerview.i;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveSubTagConstract$Presenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveSubTagConstract$ViewCallback;", "parentTag", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTagInfo;", "tagData", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "hasNextAction", "", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveTagInfo;Ljava/util/ArrayList;Z)V", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "setAdapter", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "convert", "Lcom/tencent/mm/plugin/finder/convert/FinderLiveSubTagConvert;", "getHasNextAction", "()Z", "setHasNextAction", "(Z)V", "liveData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "getLiveData", "()Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "setLiveData", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "getParentTag", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveTagInfo;", "selectedTag", "getSelectedTag", "setSelectedTag", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveTagInfo;)V", "getTagData", "()Ljava/util/ArrayList;", "viewCallback", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveSubTagConstract$ViewCallback;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveSubTagConstract$ViewCallback;)V", "getData", "onAttach", "", "callback", "onDetach", "Companion", "plugin-finder_release"})
public final class FinderLiveSubTagConstract$Presenter
  implements com.tencent.mm.plugin.finder.presenter.base.a<FinderLiveSubTagConstract.ViewCallback>
{
  public static final Companion zNL;
  public com.tencent.mm.plugin.finder.live.model.context.a xYp;
  public WxRecyclerAdapter<bu> xnR;
  bda zNF;
  private av zNG;
  FinderLiveSubTagConstract.ViewCallback zNH;
  final bda zNI;
  private final ArrayList<bu> zNJ;
  boolean zNK;
  
  static
  {
    AppMethodBeat.i(267094);
    zNL = new Companion((byte)0);
    AppMethodBeat.o(267094);
  }
  
  public FinderLiveSubTagConstract$Presenter(bda parambda, ArrayList<bu> paramArrayList, boolean paramBoolean)
  {
    AppMethodBeat.i(267093);
    this.zNI = parambda;
    this.zNJ = paramArrayList;
    this.zNK = paramBoolean;
    AppMethodBeat.o(267093);
  }
  
  public final void a(FinderLiveSubTagConstract.ViewCallback paramViewCallback)
  {
    AppMethodBeat.i(267091);
    p.k(paramViewCallback, "callback");
    Object localObject2 = new StringBuilder("onAttach parentTag:");
    Object localObject1 = this.zNI;
    if (localObject1 != null) {}
    for (localObject1 = ((bda)localObject1).ugl;; localObject1 = null)
    {
      Log.i("FinderLiveSubTagConstract.Presenter", (String)localObject1 + " tagData:" + this.zNJ + " hasNextAction:" + this.zNK);
      localObject1 = ah.yhC;
      localObject2 = ah.dzj();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new com.tencent.mm.plugin.finder.live.model.context.a("FinderLiveSubTagConstract");
      }
      this.xYp = ((com.tencent.mm.plugin.finder.live.model.context.a)localObject1);
      localObject1 = this.xYp;
      if (localObject1 == null) {
        p.bGy("liveData");
      }
      this.zNF = ((b)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(b.class)).yeG;
      this.zNG = new av(this.zNF);
      localObject1 = new WxRecyclerAdapter((f)new f()
      {
        public final e<?> yx(int paramAnonymousInt)
        {
          AppMethodBeat.i(284964);
          e locale = (e)FinderLiveSubTagConstract.Presenter.a(this.zNM);
          AppMethodBeat.o(284964);
          return locale;
        }
      }, this.zNJ);
      ((h)localObject1).YSn = ((h.c)new h.c() {});
      this.xnR = ((WxRecyclerAdapter)localObject1);
      this.zNH = paramViewCallback;
      paramViewCallback = this.zNH;
      if (paramViewCallback == null) {
        break;
      }
      paramViewCallback.initView();
      AppMethodBeat.o(267091);
      return;
    }
    AppMethodBeat.o(267091);
  }
  
  public final WxRecyclerAdapter<bu> getAdapter()
  {
    AppMethodBeat.i(267088);
    WxRecyclerAdapter localWxRecyclerAdapter = this.xnR;
    if (localWxRecyclerAdapter == null) {
      p.bGy("adapter");
    }
    AppMethodBeat.o(267088);
    return localWxRecyclerAdapter;
  }
  
  public final com.tencent.mm.plugin.finder.live.model.context.a getLiveData()
  {
    AppMethodBeat.i(267089);
    com.tencent.mm.plugin.finder.live.model.context.a locala = this.xYp;
    if (locala == null) {
      p.bGy("liveData");
    }
    AppMethodBeat.o(267089);
    return locala;
  }
  
  public final void onDetach() {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveSubTagConstract$Presenter$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class Companion {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.presenter.contract.FinderLiveSubTagConstract.Presenter
 * JD-Core Version:    0.7.0.1
 */