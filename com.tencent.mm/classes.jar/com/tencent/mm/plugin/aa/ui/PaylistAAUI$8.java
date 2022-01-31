package com.tencent.mm.plugin.aa.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.ui.w;
import com.tencent.mm.ui.widget.b.e.a;

final class PaylistAAUI$8
  implements a.a
{
  PaylistAAUI$8(PaylistAAUI paramPaylistAAUI) {}
  
  public final void aoW()
  {
    AppMethodBeat.i(40873);
    if (!t.lA(PaylistAAUI.a(this.grF))) {}
    for (int i = 2131304450;; i = 2131304449)
    {
      e.a locala = new e.a(this.grF);
      locala.aj(this.grF.getString(2131304451));
      View localView = w.hM(this.grF).inflate(2130971055, null);
      ImageView localImageView = (ImageView)localView.findViewById(2131820629);
      TextView localTextView = (TextView)localView.findViewById(2131820676);
      localImageView.setImageResource(2130839908);
      localTextView.setText(i);
      locala.fv(localView);
      locala.Rm(2131297067);
      locala.AHt = this.grF.getString(2131296888);
      locala.AHv = false;
      locala.a(new PaylistAAUI.8.1(this), new PaylistAAUI.8.2(this));
      locala.show();
      h.qsU.e(13721, new Object[] { Integer.valueOf(4), Integer.valueOf(7) });
      AppMethodBeat.o(40873);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.PaylistAAUI.8
 * JD-Core Version:    0.7.0.1
 */