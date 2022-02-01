package com.tencent.mm.live.c;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.widget.a.e;
import d.g.b.k;
import java.util.ArrayList;
import java.util.Collection;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
final class i$b
  implements n.c
{
  i$b(i parami, ArrayList paramArrayList1, ArrayList paramArrayList2) {}
  
  public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
  {
    AppMethodBeat.i(190053);
    Object localObject = this.gzI.gzh;
    if (localObject != null) {
      ((e)localObject).setFooterView(null);
    }
    paraml.clear();
    int i = 0;
    int j = ((Collection)this.gzn).size();
    while (i < j)
    {
      localObject = this.gzo.get(i);
      k.g(localObject, "ids[i]");
      int k = ((Number)localObject).intValue();
      localObject = this.gzI.context;
      k.g(localObject, "context");
      paraml.a(k, ((Context)localObject).getResources().getColor(2131101209), (CharSequence)this.gzn.get(i));
      i += 1;
    }
    AppMethodBeat.o(190053);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.c.i.b
 * JD-Core Version:    0.7.0.1
 */