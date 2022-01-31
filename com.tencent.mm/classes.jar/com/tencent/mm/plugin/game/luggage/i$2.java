package com.tencent.mm.plugin.game.luggage;

import android.text.TextUtils;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.LinkedList;

final class i$2
  implements Runnable
{
  i$2(Class paramClass, String paramString, i.a parama) {}
  
  public final void run()
  {
    h localh = new h(ae.getContext(), this.kNc);
    i.aYI().put(this.val$url, localh);
    i.aYJ().remove(this.val$url);
    if (!TextUtils.isEmpty(this.val$url))
    {
      y.i("MicroMsg.PreloadGameWebCoreHelp", "loadUrl: %s", new Object[] { this.val$url });
      localh.loadUrl(this.val$url);
    }
    if (this.kNb != null) {
      this.kNb.pQ();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.i.2
 * JD-Core Version:    0.7.0.1
 */