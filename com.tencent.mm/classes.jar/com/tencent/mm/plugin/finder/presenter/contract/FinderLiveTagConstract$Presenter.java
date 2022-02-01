package com.tencent.mm.plugin.finder.presenter.contract;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.mm.view.recyclerview.i;
import com.tencent.mm.view.recyclerview.i.c;
import com.tencent.mm.view.recyclerview.j;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveTagConstract$Presenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveTagConstract$ViewCallback;", "tagData", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "hasNextAction", "", "(Ljava/util/ArrayList;Z)V", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "setAdapter", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "getHasNextAction", "()Z", "setHasNextAction", "(Z)V", "liveData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "getLiveData", "()Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "setLiveData", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "getTagData", "()Ljava/util/ArrayList;", "viewCallback", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveTagConstract$ViewCallback;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveTagConstract$ViewCallback;)V", "getData", "gotoSubTagUI", "", "tagIndex", "", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onAttach", "callback", "onDetach", "parseSubTagList", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTagInfo;", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveTagConstract$Presenter
  implements com.tencent.mm.plugin.finder.presenter.base.a<FinderLiveTagConstract.ViewCallback>
{
  public static final FinderLiveTagConstract.Presenter.Companion EYK;
  public WxRecyclerAdapter<cc> ALE;
  public com.tencent.mm.plugin.finder.live.model.context.a CvU;
  private final ArrayList<cc> EYB;
  boolean EYC;
  public FinderLiveTagConstract.ViewCallback EYL;
  
  static
  {
    AppMethodBeat.i(343984);
    EYK = new FinderLiveTagConstract.Presenter.Companion((byte)0);
    AppMethodBeat.o(343984);
  }
  
  public FinderLiveTagConstract$Presenter(ArrayList<cc> paramArrayList, boolean paramBoolean)
  {
    AppMethodBeat.i(343934);
    this.EYB = paramArrayList;
    this.EYC = paramBoolean;
    AppMethodBeat.o(343934);
  }
  
  private void setAdapter(WxRecyclerAdapter<cc> paramWxRecyclerAdapter)
  {
    AppMethodBeat.i(343945);
    s.u(paramWxRecyclerAdapter, "<set-?>");
    this.ALE = paramWxRecyclerAdapter;
    AppMethodBeat.o(343945);
  }
  
  private void setLiveData(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    AppMethodBeat.i(343958);
    s.u(parama, "<set-?>");
    this.CvU = parama;
    AppMethodBeat.o(343958);
  }
  
  public final void a(FinderLiveTagConstract.ViewCallback paramViewCallback)
  {
    AppMethodBeat.i(344004);
    s.u(paramViewCallback, "callback");
    Log.i("FinderLiveTagConstract.Presenter", "onAttach tagData:" + this.EYB + " hasNextAction:" + this.EYC);
    Object localObject1 = aj.CGT;
    Object localObject2 = aj.elr();
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new com.tencent.mm.plugin.finder.live.model.context.a("FinderLiveTagConstract");
    }
    setLiveData((com.tencent.mm.plugin.finder.live.model.context.a)localObject1);
    localObject1 = new WxRecyclerAdapter((g)new FinderLiveTagConstract.Presenter.onAttach.1(), this.EYB);
    ((i)localObject1).agOe = ((i.c)new i.c() {});
    localObject2 = ah.aiuX;
    setAdapter((WxRecyclerAdapter)localObject1);
    this.EYL = paramViewCallback;
    paramViewCallback = this.EYL;
    if (paramViewCallback != null) {
      paramViewCallback.initView();
    }
    AppMethodBeat.o(344004);
  }
  
  public final com.tencent.mm.plugin.finder.live.model.context.a getLiveData()
  {
    AppMethodBeat.i(343992);
    com.tencent.mm.plugin.finder.live.model.context.a locala = this.CvU;
    if (locala != null)
    {
      AppMethodBeat.o(343992);
      return locala;
    }
    s.bIx("liveData");
    AppMethodBeat.o(343992);
    return null;
  }
  
  public final void onDetach() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.presenter.contract.FinderLiveTagConstract.Presenter
 * JD-Core Version:    0.7.0.1
 */