package com.tencent.mm.plugin.fav.ui.detail;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.plugin.fav.ui.l;
import com.tencent.mm.plugin.fav.ui.n.e;
import com.tencent.mm.plugin.fav.ui.n.i;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;

final class FavoriteFileDetailUI$14$1
  implements Runnable
{
  FavoriteFileDetailUI$14$1(FavoriteFileDetailUI.14 param14) {}
  
  public final void run()
  {
    h.h(this.kfE.kfu.mController.uMN, n.i.video_file_play_faile, n.i.video_play_err);
    Bitmap localBitmap = l.a(FavoriteFileDetailUI.a(this.kfE.kfu), FavoriteFileDetailUI.b(this.kfE.kfu));
    ImageView localImageView = (ImageView)this.kfE.kfu.findViewById(n.e.videoplayer_maskview);
    if (localImageView != null)
    {
      localImageView.setImageBitmap(localBitmap);
      localImageView.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI.14.1
 * JD-Core Version:    0.7.0.1
 */