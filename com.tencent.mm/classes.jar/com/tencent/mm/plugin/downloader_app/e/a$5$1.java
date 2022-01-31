package com.tencent.mm.plugin.downloader_app.e;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader_app.a.d;

final class a$5$1
  implements Runnable
{
  a$5$1(a.5 param5) {}
  
  public final void run()
  {
    AppMethodBeat.i(136320);
    this.ldn.ldl.bkc();
    this.ldn.kTo.dismiss();
    if (this.ldn.ldm)
    {
      ((d)g.E(d.class)).bjE();
      Bundle localBundle = ((Activity)this.ldn.val$context).getIntent().getBundleExtra("download_params");
      if (localBundle != null) {
        ((d)g.E(d.class)).a(this.ldn.val$context, new Intent().putExtras(localBundle), null);
      }
    }
    AppMethodBeat.o(136320);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.e.a.5.1
 * JD-Core Version:    0.7.0.1
 */