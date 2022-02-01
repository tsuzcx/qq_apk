package com.tencent.mm.plugin.downloader.i;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.h;

final class a$3
  implements Runnable
{
  a$3(Context paramContext, g paramg, WXMediaMessage paramWXMediaMessage, al paramal) {}
  
  public final void run()
  {
    AppMethodBeat.i(89132);
    h.a(this.val$context, this.qJW.field_packageName, this.qJX, this.qJW.field_appId, this.qJW.field_openId, 0, this.qJV, null);
    AppMethodBeat.o(89132);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.i.a.3
 * JD-Core Version:    0.7.0.1
 */