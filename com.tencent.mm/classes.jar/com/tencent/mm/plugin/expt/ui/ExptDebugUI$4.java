package com.tencent.mm.plugin.expt.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.widget.picker.c;
import com.tencent.mm.ui.widget.picker.c.a;
import java.util.ArrayList;

final class ExptDebugUI$4
  implements View.OnClickListener
{
  ExptDebugUI$4(ExptDebugUI paramExptDebugUI) {}
  
  public final void onClick(final View paramView)
  {
    AppMethodBeat.i(122474);
    Object localObject = new b();
    ((b)localObject).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/expt/ui/ExptDebugUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
    localObject = com.tencent.mm.plugin.expt.f.a.cqZ().crc();
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      paramView = new String[((ArrayList)localObject).size()];
      int i = 0;
      while (i < paramView.length)
      {
        paramView[i] = ((ArrayList)localObject).get(i);
        i += 1;
      }
      localObject = new c(this.rca.getContext(), paramView);
      ((c)localObject).afD(0);
      ((c)localObject).LaQ = new c.a()
      {
        public final void onResult(boolean paramAnonymousBoolean, Object paramAnonymousObject1, Object paramAnonymousObject2)
        {
          AppMethodBeat.i(122473);
          this.nqO.hide();
          int i = this.nqO.fMM();
          paramAnonymousObject1 = paramView[i];
          ExptDebugUI.a(ExptDebugUI.4.this.rca, bt.getInt(paramAnonymousObject1, 0));
          AppMethodBeat.o(122473);
        }
      };
      ((c)localObject).show();
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/expt/ui/ExptDebugUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(122474);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.ui.ExptDebugUI.4
 * JD-Core Version:    0.7.0.1
 */