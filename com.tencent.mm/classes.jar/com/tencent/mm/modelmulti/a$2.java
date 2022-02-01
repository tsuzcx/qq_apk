package com.tencent.mm.modelmulti;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.g;
import com.tencent.mm.by.c;
import com.tencent.mm.plugin.hld.a.f;
import com.tencent.mm.plugin.hld.model.WxImeInterService;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class a$2
  implements Runnable
{
  a$2(a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(276490);
    if (g.gL(MMApplicationContext.getApplicationId() + f.Duh) != -1)
    {
      Intent localIntent = new Intent(MMApplicationContext.getContext(), WxImeInterService.class);
      localIntent.putExtra("ime_reset_ime_setting", true);
      c.l(localIntent, "hld");
      AppMethodBeat.o(276490);
      return;
    }
    Log.i("MicroMsg.BigBallOfMudSyncExtension", "ime process no exist");
    AppMethodBeat.o(276490);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelmulti.a.2
 * JD-Core Version:    0.7.0.1
 */