package com.tencent.mm.plugin.ipcall.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class g$6
  implements View.OnClickListener
{
  g$6(g paramg) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(25774);
    Object localObject = new b();
    ((b)localObject).bm(paramView);
    a.b("com/tencent/mm/plugin/ipcall/ui/IPCallFeedbackDialog$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
    localObject = (g.a)paramView.getTag();
    if (!((g.a)localObject).ywh) {}
    for (((g.a)localObject).ywh = true;; ((g.a)localObject).ywh = false)
    {
      g.a(this.ywg, (TextView)paramView);
      a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallFeedbackDialog$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(25774);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.g.6
 * JD-Core Version:    0.7.0.1
 */