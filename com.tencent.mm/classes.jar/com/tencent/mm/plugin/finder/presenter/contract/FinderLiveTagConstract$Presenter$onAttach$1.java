package com.tencent.mm.plugin.finder.presenter.contract;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.convert.aw;
import com.tencent.mm.plugin.finder.live.model.context.a;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.b;
import com.tencent.mm.protocal.protobuf.bda;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.f;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/presenter/contract/FinderLiveTagConstract$Presenter$onAttach$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
public final class FinderLiveTagConstract$Presenter$onAttach$1
  implements f
{
  public final e<?> yx(int paramInt)
  {
    AppMethodBeat.i(243559);
    Object localObject = a.ykr;
    localObject = a.dAc();
    if (localObject != null)
    {
      localObject = (b)((a)localObject).business(b.class);
      if (localObject == null) {}
    }
    for (localObject = ((b)localObject).yeG;; localObject = null)
    {
      localObject = (e)new aw((bda)localObject);
      AppMethodBeat.o(243559);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.presenter.contract.FinderLiveTagConstract.Presenter.onAttach.1
 * JD-Core Version:    0.7.0.1
 */