package com.tencent.mm.plugin.downloader_app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.plugin.downloader_app.detail.DownloadDetailUI;

final class a$4
  implements Runnable
{
  a$4(a parama, Context paramContext, Bundle paramBundle) {}
  
  public final void run()
  {
    Intent localIntent = new Intent(this.val$context, DownloadDetailUI.class);
    localIntent.putExtras(this.gBV);
    this.val$context.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.a.4
 * JD-Core Version:    0.7.0.1
 */