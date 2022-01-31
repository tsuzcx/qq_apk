package com.tencent.mm.plugin.downloader_app;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.i.a;

final class b$1
  implements Runnable
{
  b$1(b paramb, Context paramContext, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(136013);
    a.a(this.val$context, this.val$appId, null);
    AppMethodBeat.o(136013);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.b.1
 * JD-Core Version:    0.7.0.1
 */