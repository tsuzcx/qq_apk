package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ipcall.a.f;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.ipcall.c;
import com.tencent.mm.plugin.ipcall.e;
import com.tencent.mm.plugin.voip.b;
import com.tencent.mm.plugin.voip.ui.d;
import com.tencent.mm.sdk.platformtools.ah;

final class j$8
  implements View.OnClickListener
{
  j$8(j paramj) {}
  
  public final void onClick(View arg1)
  {
    AppMethodBeat.i(22406);
    c localc = i.bJs();
    synchronized (localc.iiG)
    {
      if (i.bJr().bJh())
      {
        if (localc.nLK)
        {
          localc.bIP();
          AppMethodBeat.o(22406);
          return;
        }
        localc.nLK = true;
        Toast.makeText(ah.getContext(), 2131301689, 0).show();
        Intent localIntent = new Intent();
        localIntent.setFlags(268435456);
        localIntent.setClass(ah.getContext(), IPCallTalkUI.class);
        localIntent.putExtra("IPCallTalkUI_isFromMiniNotification", true);
        b.cLD().a(localIntent, localc.nLL);
        localc.bIP();
        if (localc.nLC != null) {
          localc.nLC.bIW();
        }
      }
      AppMethodBeat.o(22406);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.j.8
 * JD-Core Version:    0.7.0.1
 */