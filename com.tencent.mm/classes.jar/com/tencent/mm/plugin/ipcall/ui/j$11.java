package com.tencent.mm.plugin.ipcall.ui;

import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

final class j$11
  implements IPCallFuncButton.a
{
  j$11(j paramj) {}
  
  public final void iL(boolean paramBoolean)
  {
    AppMethodBeat.i(22409);
    if (paramBoolean)
    {
      localj = this.nXs;
      if (localj.nWM == null) {
        localj.ehv.setVisibility(8);
      }
      for (;;)
      {
        localj.ehv.setVisibility(8);
        localj.nWX.setVisibility(8);
        localj.nWV.setText("");
        localj.nWW.setText("");
        localj.nQw.setVisibility(0);
        h.qsU.e(12057, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0) });
        AppMethodBeat.o(22409);
        return;
        localj.ehv.setVisibility(4);
      }
    }
    j localj = this.nXs;
    if (localj.nWM != null)
    {
      localj.ehv.setVisibility(0);
      localj.nWX.setVisibility(8);
    }
    for (;;)
    {
      localj.Rw(localj.nXg);
      localj.nQw.setVisibility(4);
      break;
      localj.nWX.setVisibility(0);
      localj.ehv.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.j.11
 * JD-Core Version:    0.7.0.1
 */