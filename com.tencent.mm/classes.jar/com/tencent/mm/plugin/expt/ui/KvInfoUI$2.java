package com.tencent.mm.plugin.expt.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.widget.picker.c;
import com.tencent.mm.ui.widget.picker.c.a;
import java.util.ArrayList;
import java.util.HashMap;

final class KvInfoUI$2
  implements View.OnClickListener
{
  KvInfoUI$2(KvInfoUI paramKvInfoUI) {}
  
  public final void onClick(final View paramView)
  {
    AppMethodBeat.i(210564);
    Object localObject = new b();
    ((b)localObject).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/expt/ui/KvInfoUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
    paramView = com.tencent.mm.plugin.expt.e.a.cqU().rah;
    if ((paramView != null) && (paramView.size() > 0))
    {
      paramView = new ArrayList(paramView.keySet());
      localObject = new c(this.rcm.getContext(), paramView);
      ((c)localObject).afD(0);
      ((c)localObject).LaQ = new c.a()
      {
        public final void onResult(boolean paramAnonymousBoolean, Object paramAnonymousObject1, Object paramAnonymousObject2)
        {
          AppMethodBeat.i(210563);
          this.nqO.hide();
          int i = this.nqO.fMM();
          paramAnonymousObject1 = (String)paramView.get(i);
          KvInfoUI.a(KvInfoUI.2.this.rcm, paramAnonymousObject1);
          AppMethodBeat.o(210563);
        }
      };
      ((c)localObject).show();
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/expt/ui/KvInfoUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(210564);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.ui.KvInfoUI.2
 * JD-Core Version:    0.7.0.1
 */