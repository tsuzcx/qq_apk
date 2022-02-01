package com.tencent.mm.plugin.finder.presenter.contract;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.convert.as;
import com.tencent.mm.plugin.finder.live.model.context.a;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.protocal.protobuf.bno;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.g;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/presenter/contract/FinderLiveTagConstract$Presenter$onAttach$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveTagConstract$Presenter$onAttach$1
  implements g
{
  public final f<?> yF(int paramInt)
  {
    AppMethodBeat.i(343682);
    Object localObject = a.CMm;
    localObject = a.emY();
    if (localObject == null) {
      localObject = null;
    }
    for (;;)
    {
      localObject = (f)new as((bno)localObject);
      AppMethodBeat.o(343682);
      return localObject;
      localObject = (e)((a)localObject).business(e.class);
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = ((e)localObject).CFe;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.presenter.contract.FinderLiveTagConstract.Presenter.onAttach.1
 * JD-Core Version:    0.7.0.1
 */