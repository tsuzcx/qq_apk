package com.tencent.mm.plugin.fav.ui.widget;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.plugin.fav.ui.n.i;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h;
import java.io.File;

final class FavVideoView$3
  implements Runnable
{
  FavVideoView$3(FavVideoView paramFavVideoView, String paramString) {}
  
  public final void run()
  {
    Intent localIntent = new Intent();
    localIntent.setAction("android.intent.action.VIEW");
    localIntent.setDataAndType(Uri.fromFile(new File(this.kjY)), "video/*");
    try
    {
      this.kjX.getContext().startActivity(localIntent);
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.FavVideoView", "startActivity fail, activity not found");
      h.h(this.kjX.getContext(), n.i.favorite_no_match_msg, n.i.favorite_no_match_title);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.widget.FavVideoView.3
 * JD-Core Version:    0.7.0.1
 */