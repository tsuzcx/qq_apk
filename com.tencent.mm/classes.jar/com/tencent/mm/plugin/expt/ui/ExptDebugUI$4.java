package com.tencent.mm.plugin.expt.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.e.d;
import com.tencent.mm.ui.widget.picker.b;
import java.util.ArrayList;

final class ExptDebugUI$4
  implements View.OnClickListener
{
  ExptDebugUI$4(ExptDebugUI paramExptDebugUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(73636);
    paramView = com.tencent.mm.plugin.expt.b.a.bsG();
    if (paramView.mbQ != null) {
      paramView = paramView.mbQ.btp();
    }
    while ((paramView != null) && (paramView.size() > 0))
    {
      String[] arrayOfString = new String[paramView.size()];
      int i = 0;
      for (;;)
      {
        if (i < arrayOfString.length)
        {
          arrayOfString[i] = paramView.get(i);
          i += 1;
          continue;
          paramView = null;
          break;
        }
      }
      paramView = new b(this.mdp.getContext(), arrayOfString);
      paramView.Rw(0);
      paramView.AIW = new ExptDebugUI.4.1(this, paramView, arrayOfString);
      paramView.Rv(com.tencent.mm.cb.a.fromDPToPix(this.mdp.getContext(), 288));
      paramView.show();
    }
    AppMethodBeat.o(73636);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.ui.ExptDebugUI.4
 * JD-Core Version:    0.7.0.1
 */