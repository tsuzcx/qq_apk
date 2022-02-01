package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import d.a.j;
import d.l;
import java.util.ArrayList;
import java.util.Iterator;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class o$d$b
  implements View.OnClickListener
{
  o$d$b(o.d paramd, o.a parama, int paramInt, d.g.a.b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(183086);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramView);
    a.b("com/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$ViewHolder$applyData$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
    this.nhv.iGv = true;
    o.d.a(this.nhu, this.nhv.iGv, this.nhv);
    paramView = new ArrayList();
    localObject1 = ((Iterable)this.nhu.hMc).iterator();
    int i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      int j = i + 1;
      if (i < 0) {
        j.gkd();
      }
      localObject2 = (o.a)localObject2;
      paramView.add(Integer.valueOf(i));
      if (this.gke != i)
      {
        if (localObject2 == null) {
          break label181;
        }
        if (((o.a)localObject2).iGv == true)
        {
          ((o.a)localObject2).iGv = false;
          paramView.add(Integer.valueOf(this.gke));
        }
      }
      i = j;
      continue;
      label181:
      i = j;
    }
    this.nhw.invoke(paramView);
    a.a(this, "com/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$ViewHolder$applyData$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(183086);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.o.d.b
 * JD-Core Version:    0.7.0.1
 */