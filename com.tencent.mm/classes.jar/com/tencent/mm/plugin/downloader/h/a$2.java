package com.tencent.mm.plugin.downloader.h;

import android.content.Context;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;

final class a$2
  implements Runnable
{
  a$2(Context paramContext, f paramf, WXMediaMessage paramWXMediaMessage, am paramam) {}
  
  public final void run()
  {
    g.a(this.val$context, this.iRp.field_packageName, this.iRq, this.iRp.field_appId, this.iRp.field_openId, 0, this.iRo, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.h.a.2
 * JD-Core Version:    0.7.0.1
 */