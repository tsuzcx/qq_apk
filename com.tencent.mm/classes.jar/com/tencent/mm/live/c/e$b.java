package com.tencent.mm.live.c;

import android.content.Context;
import android.content.res.Resources;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.n.c;
import d.g.b.k;
import java.util.ArrayList;
import java.util.Collection;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
final class e$b
  implements n.c
{
  e$b(e parame, ArrayList paramArrayList1, ArrayList paramArrayList2) {}
  
  public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
  {
    AppMethodBeat.i(190026);
    Object localObject = this.gzl.gzh;
    if (localObject != null) {
      ((com.tencent.mm.ui.widget.a.e)localObject).setFooterView(null);
    }
    paraml.clear();
    int i = 0;
    int j = ((Collection)this.gzn).size();
    while (i < j)
    {
      localObject = this.gzo.get(i);
      k.g(localObject, "ids[i]");
      int k = ((Number)localObject).intValue();
      localObject = this.gzl.gnb.getContext();
      k.g(localObject, "root.context");
      paraml.a(k, ((Context)localObject).getResources().getColor(2131101209), (CharSequence)this.gzn.get(i));
      i += 1;
    }
    AppMethodBeat.o(190026);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.c.e.b
 * JD-Core Version:    0.7.0.1
 */