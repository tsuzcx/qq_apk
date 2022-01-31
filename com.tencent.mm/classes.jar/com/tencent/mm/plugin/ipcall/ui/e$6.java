package com.tencent.mm.plugin.ipcall.ui;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

final class e$6
  implements Runnable
{
  e$6(e parame) {}
  
  public final void run()
  {
    AppMethodBeat.i(22038);
    aw.aaz();
    if (((Boolean)c.Ru().get(ac.a.yAf, Boolean.FALSE)).booleanValue()) {
      this.nRH.nRG.setVisibility(0);
    }
    String str2;
    for (;;)
    {
      aw.aaz();
      String str1 = (String)c.Ru().get(ac.a.yAh, "");
      aw.aaz();
      str2 = (String)c.Ru().get(ac.a.yAi, "");
      if (bo.isNullOrNil(str1)) {
        break;
      }
      this.nRH.nRF.setText(str1);
      this.nRH.nRE.setVisibility(0);
      AppMethodBeat.o(22038);
      return;
      this.nRH.nRG.setVisibility(8);
    }
    if (!bo.isNullOrNil(str2))
    {
      this.nRH.nRF.setText(str2);
      this.nRH.nRE.setVisibility(0);
      AppMethodBeat.o(22038);
      return;
    }
    this.nRH.nRF.setText("");
    this.nRH.nRE.setVisibility(8);
    AppMethodBeat.o(22038);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.e.6
 * JD-Core Version:    0.7.0.1
 */