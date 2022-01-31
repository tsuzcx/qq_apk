package com.tencent.mm.plugin.fav.ui.detail;

import android.support.v7.app.AppCompatActivity;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.ui.n.i;
import com.tencent.mm.plugin.scanner.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.s;

final class FavoriteImgDetailUI$7
  implements n.c
{
  FavoriteImgDetailUI$7(FavoriteImgDetailUI paramFavoriteImgDetailUI, FavoriteImgDetailUI.a parama) {}
  
  public final void a(l paraml)
  {
    if (FavoriteImgDetailUI.a(this.kfM))
    {
      if (FavoriteImgDetailUI.b(this.kfM).aPX()) {
        paraml.e(2, this.kfM.mController.uMN.getString(n.i.favorite_share_with_friend));
      }
      if (FavoriteImgDetailUI.b(this.kfM).aPY()) {
        paraml.e(1, this.kfM.mController.uMN.getString(n.i.favorite_post_to_sns));
      }
      paraml.e(3, this.kfM.mController.uMN.getString(n.i.favorite_save_image));
      if (!bk.bl(this.kfR.kfV))
      {
        if (!a.wM(this.kfR.bIj)) {
          break label145;
        }
        paraml.e(4, this.kfM.getString(n.i.favorite_reconize_image_qrcode));
      }
    }
    return;
    label145:
    if (a.aD(this.kfR.bIj, this.kfR.kfV))
    {
      paraml.e(4, this.kfM.getString(n.i.favorite_reconize_image_wxcode));
      return;
    }
    if (a.wL(this.kfR.bIj))
    {
      paraml.e(4, this.kfM.getString(n.i.favorite_reconize_image_barcode));
      return;
    }
    paraml.e(4, this.kfM.getString(n.i.favorite_reconize_image_qrcode));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteImgDetailUI.7
 * JD-Core Version:    0.7.0.1
 */