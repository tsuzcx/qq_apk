package com.tencent.mm.plugin.game.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.model.app.ai;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;

final class e$2
  implements Runnable
{
  e$2(Context paramContext, f paramf, WXMediaMessage paramWXMediaMessage, ai paramai) {}
  
  public final void run()
  {
    AppMethodBeat.i(111197);
    g.a(this.val$context, this.kZO.field_packageName, this.kZP, this.kZO.field_appId, this.kZO.field_openId, 0, this.kZN, null);
    AppMethodBeat.o(111197);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.e.2
 * JD-Core Version:    0.7.0.1
 */