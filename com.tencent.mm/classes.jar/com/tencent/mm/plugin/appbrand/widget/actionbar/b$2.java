package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Iterator;

final class b$2
  implements View.OnClickListener
{
  b$2(b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(87450);
    Object localObject = this.jbs.jbl;
    paramView = this.jbs.jbd;
    if (((c)localObject).jbv.isEmpty()) {}
    for (int i = 0;; i = 1)
    {
      if (i == 0) {
        this.jbs.jbl.cE(this.jbs.jbd);
      }
      AppMethodBeat.o(87450);
      return;
      localObject = ((c)localObject).jbv.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((View.OnClickListener)((Iterator)localObject).next()).onClick(paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.actionbar.b.2
 * JD-Core Version:    0.7.0.1
 */