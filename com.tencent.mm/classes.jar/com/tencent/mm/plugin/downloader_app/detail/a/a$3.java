package com.tencent.mm.plugin.downloader_app.detail.a;

import android.content.Context;
import android.widget.Toast;
import com.tencent.mm.plugin.downloader_app.b.h;

final class a$3
  implements Runnable
{
  a$3(a parama, Context paramContext) {}
  
  public final void run()
  {
    Toast.makeText(this.val$context, this.val$context.getString(b.h.game_download_not_enough_space), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.detail.a.a.3
 * JD-Core Version:    0.7.0.1
 */