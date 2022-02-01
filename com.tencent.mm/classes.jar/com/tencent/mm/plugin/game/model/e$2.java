package com.tencent.mm.plugin.game.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.h;

final class e$2
  implements Runnable
{
  e$2(Context paramContext, g paramg, WXMediaMessage paramWXMediaMessage, al paramal) {}
  
  public final void run()
  {
    AppMethodBeat.i(41359);
    h.a(this.val$context, this.qJW.field_packageName, this.qJX, this.qJW.field_appId, this.qJW.field_openId, 0, this.qJV, null);
    AppMethodBeat.o(41359);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.e.2
 * JD-Core Version:    0.7.0.1
 */