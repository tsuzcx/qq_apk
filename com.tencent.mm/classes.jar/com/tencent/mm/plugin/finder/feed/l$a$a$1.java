package com.tencent.mm.plugin.finder.feed;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.i.f;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.d;
import d.g.a.a;
import d.g.b.k;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"refreshUI", "", "invoke"})
final class l$a$a$1
  extends d.g.b.l
  implements a<y>
{
  l$a$a$1(l.a.a parama)
  {
    super(0);
  }
  
  public final void invoke()
  {
    AppMethodBeat.i(198094);
    Object localObject = this.KPw.qxD.qxA;
    if (localObject != null) {
      ((l.b)localObject).yC(false);
    }
    localObject = this.KPw.qxD.qxA;
    if (localObject == null) {
      k.fvU();
    }
    localObject = ((l.b)localObject).qul;
    if (localObject == null) {
      k.fvU();
    }
    int i = ((d)localObject).Ibl.size();
    this.KPw.qxE.setIncrementList((List)l.a.a(this.KPw.qxD, this.KPw.qxE.getIncrementList()));
    localObject = this.KPw.qxE.getIncrementList();
    if (localObject != null) {
      this.KPw.qxD.dataList.addAll((Collection)localObject);
    }
    localObject = this.KPw.qxD.qxA;
    if (localObject != null)
    {
      localObject = ((l.b)localObject).qul;
      if (localObject != null)
      {
        ((WxRecyclerAdapter)localObject).aq(i, this.KPw.qxD.dataList.size());
        AppMethodBeat.o(198094);
        return;
      }
    }
    AppMethodBeat.o(198094);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.l.a.a.1
 * JD-Core Version:    0.7.0.1
 */