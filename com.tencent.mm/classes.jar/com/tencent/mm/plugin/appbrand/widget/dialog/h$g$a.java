package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.a.j;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class h$g$a
  implements View.OnClickListener
{
  h$g$a(h.g paramg, h.a parama, int paramInt, kotlin.g.a.b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(245589);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramView);
    a.c("com/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ViewHolder$applyData$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
    this.rsC.msB = true;
    h.g.a(this.rsB, this.rsC.msB, this.rsC);
    paramView = new ArrayList();
    localObject1 = ((Iterable)this.rsB.lxh).iterator();
    int i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      int j = i + 1;
      if (i < 0) {
        j.iBO();
      }
      localObject2 = (h.a)localObject2;
      paramView.add(Integer.valueOf(i));
      if (this.jEN != i)
      {
        if (localObject2 == null) {
          break label181;
        }
        if (((h.a)localObject2).msB == true)
        {
          ((h.a)localObject2).msB = false;
          paramView.add(Integer.valueOf(this.jEN));
        }
      }
      i = j;
      continue;
      label181:
      i = j;
    }
    this.rsD.invoke(paramView);
    a.a(this, "com/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ViewHolder$applyData$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(245589);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.h.g.a
 * JD-Core Version:    0.7.0.1
 */