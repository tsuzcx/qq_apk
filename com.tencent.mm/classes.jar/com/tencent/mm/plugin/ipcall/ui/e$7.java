package com.tencent.mm.plugin.ipcall.ui;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ipcall.b.c;
import com.tencent.mm.protocal.protobuf.ash;
import com.tencent.mm.sdk.platformtools.bo;

final class e$7
  implements Runnable
{
  e$7(e parame) {}
  
  public final void run()
  {
    AppMethodBeat.i(22039);
    ash localash = c.bKP();
    if (localash != null)
    {
      this.nRH.nRC.setText(localash.xhs);
      if (!bo.isNullOrNil(localash.xhA))
      {
        this.nRH.nRD.setText(localash.xhA);
        this.nRH.nRD.setVisibility(0);
        AppMethodBeat.o(22039);
        return;
      }
      this.nRH.nRD.setText("");
      this.nRH.nRD.setVisibility(8);
      AppMethodBeat.o(22039);
      return;
    }
    this.nRH.nRC.setText("");
    this.nRH.nRD.setText("");
    this.nRH.nRD.setVisibility(8);
    AppMethodBeat.o(22039);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.e.7
 * JD-Core Version:    0.7.0.1
 */