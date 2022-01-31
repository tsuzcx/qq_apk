package com.tencent.mm.plugin.downloader_app.d;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.kernel.g;

final class a$5$1
  implements Runnable
{
  a$5$1(a.5 param5) {}
  
  public final void run()
  {
    this.iUj.iUi.awY();
    this.iUj.iMq.dismiss();
    if (this.iUj.hZO)
    {
      ((com.tencent.mm.plugin.downloader_app.a.a)g.r(com.tencent.mm.plugin.downloader_app.a.a.class)).aGd();
      Bundle localBundle = ((Activity)this.iUj.val$context).getIntent().getBundleExtra("download_params");
      if (localBundle != null) {
        ((com.tencent.mm.plugin.downloader_app.a.a)g.r(com.tencent.mm.plugin.downloader_app.a.a.class)).a(this.iUj.val$context, new Intent().putExtras(localBundle), null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.d.a.5.1
 * JD-Core Version:    0.7.0.1
 */