package com.tencent.mm.plugin.freewifi.b;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.ai;

final class b$1
  implements Runnable
{
  b$1(b paramb, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(24745);
    Intent localIntent = new Intent();
    localIntent.putExtra("free_wifi_ap_key", this.spt);
    localIntent.putExtra("free_wifi_sessionkey", m.cIG());
    localIntent.putExtra("free_wifi_source", 6);
    localIntent.addFlags(67108864);
    d.b(ai.getContext(), "freewifi", ".ui.FreeWifiEntryUI", localIntent);
    AppMethodBeat.o(24745);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.b.b.1
 * JD-Core Version:    0.7.0.1
 */