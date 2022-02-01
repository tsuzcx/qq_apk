package com.tencent.mm.plugin.finder.presenter.contract;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.convert.ar;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.protocal.protobuf.bno;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.mm.view.recyclerview.i;
import com.tencent.mm.view.recyclerview.i.c;
import com.tencent.mm.view.recyclerview.j;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveSubTagConstract$Presenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveSubTagConstract$ViewCallback;", "parentTag", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTagInfo;", "tagData", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "hasNextAction", "", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveTagInfo;Ljava/util/ArrayList;Z)V", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "setAdapter", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "convert", "Lcom/tencent/mm/plugin/finder/convert/FinderLiveSubTagConvert;", "getHasNextAction", "()Z", "setHasNextAction", "(Z)V", "liveData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "getLiveData", "()Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "setLiveData", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "getParentTag", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveTagInfo;", "selectedTag", "getSelectedTag", "setSelectedTag", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveTagInfo;)V", "getTagData", "()Ljava/util/ArrayList;", "viewCallback", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveSubTagConstract$ViewCallback;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveSubTagConstract$ViewCallback;)V", "getData", "onAttach", "", "callback", "onDetach", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveSubTagConstract$Presenter
  implements com.tencent.mm.plugin.finder.presenter.base.a<FinderLiveSubTagConstract.ViewCallback>
{
  public static final FinderLiveSubTagConstract.Presenter.Companion EYz;
  public WxRecyclerAdapter<cc> ALE;
  public com.tencent.mm.plugin.finder.live.model.context.a CvU;
  final bno EYA;
  private final ArrayList<cc> EYB;
  boolean EYC;
  bno EYD;
  private ar EYE;
  FinderLiveSubTagConstract.ViewCallback EYF;
  
  static
  {
    AppMethodBeat.i(343505);
    EYz = new FinderLiveSubTagConstract.Presenter.Companion((byte)0);
    AppMethodBeat.o(343505);
  }
  
  public FinderLiveSubTagConstract$Presenter(bno parambno, ArrayList<cc> paramArrayList, boolean paramBoolean)
  {
    AppMethodBeat.i(343486);
    this.EYA = parambno;
    this.EYB = paramArrayList;
    this.EYC = paramBoolean;
    AppMethodBeat.o(343486);
  }
  
  private void setAdapter(WxRecyclerAdapter<cc> paramWxRecyclerAdapter)
  {
    AppMethodBeat.i(343490);
    s.u(paramWxRecyclerAdapter, "<set-?>");
    this.ALE = paramWxRecyclerAdapter;
    AppMethodBeat.o(343490);
  }
  
  private void setLiveData(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    AppMethodBeat.i(343497);
    s.u(parama, "<set-?>");
    this.CvU = parama;
    AppMethodBeat.o(343497);
  }
  
  public final void a(FinderLiveSubTagConstract.ViewCallback paramViewCallback)
  {
    AppMethodBeat.i(343522);
    s.u(paramViewCallback, "callback");
    Object localObject2 = new StringBuilder("onAttach parentTag:");
    Object localObject1 = this.EYA;
    if (localObject1 == null) {}
    for (localObject1 = null;; localObject1 = ((bno)localObject1).xms)
    {
      Log.i("FinderLiveSubTagConstract.Presenter", localObject1 + " tagData:" + this.EYB + " hasNextAction:" + this.EYC);
      localObject1 = aj.CGT;
      localObject2 = aj.elr();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new com.tencent.mm.plugin.finder.live.model.context.a("FinderLiveSubTagConstract");
      }
      setLiveData((com.tencent.mm.plugin.finder.live.model.context.a)localObject1);
      this.EYD = ((e)getLiveData().business(e.class)).CFe;
      this.EYE = new ar(this.EYD);
      localObject1 = new WxRecyclerAdapter((g)new g()
      {
        public final f<?> yF(int paramAnonymousInt)
        {
          AppMethodBeat.i(343696);
          ar localar = FinderLiveSubTagConstract.Presenter.a(this.EYG);
          Object localObject = localar;
          if (localar == null)
          {
            s.bIx("convert");
            localObject = null;
          }
          localObject = (f)localObject;
          AppMethodBeat.o(343696);
          return localObject;
        }
      }, this.EYB);
      ((i)localObject1).agOe = ((i.c)new i.c() {});
      localObject2 = ah.aiuX;
      setAdapter((WxRecyclerAdapter)localObject1);
      this.EYF = paramViewCallback;
      paramViewCallback = this.EYF;
      if (paramViewCallback != null) {
        paramViewCallback.initView();
      }
      AppMethodBeat.o(343522);
      return;
    }
  }
  
  public final com.tencent.mm.plugin.finder.live.model.context.a getLiveData()
  {
    AppMethodBeat.i(343514);
    com.tencent.mm.plugin.finder.live.model.context.a locala = this.CvU;
    if (locala != null)
    {
      AppMethodBeat.o(343514);
      return locala;
    }
    s.bIx("liveData");
    AppMethodBeat.o(343514);
    return null;
  }
  
  public final void onDetach() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.presenter.contract.FinderLiveSubTagConstract.Presenter
 * JD-Core Version:    0.7.0.1
 */