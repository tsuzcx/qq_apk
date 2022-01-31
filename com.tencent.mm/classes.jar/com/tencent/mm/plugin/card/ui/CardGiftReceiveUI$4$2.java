package com.tencent.mm.plugin.card.ui;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.plugin.card.a.f;
import com.tencent.mm.plugin.card.model.CardGiftInfo;
import com.tencent.mm.sdk.platformtools.bk;

final class CardGiftReceiveUI$4$2
  implements Runnable
{
  CardGiftReceiveUI$4$2(CardGiftReceiveUI.4 param4, String paramString1, String paramString2) {}
  
  public final void run()
  {
    if (CardGiftReceiveUI.f(this.iuw.iuv).getVisibility() != 8) {
      CardGiftReceiveUI.f(this.iuw.iuv).setVisibility(8);
    }
    if ((!bk.bl(this.eGX)) && (!bk.bl(CardGiftReceiveUI.b(this.iuw.iuv).ilI)) && (this.eGX.equals(CardGiftReceiveUI.b(this.iuw.iuv).ilI))) {
      CardGiftReceiveUI.h(this.iuw.iuv).setVisibility(0);
    }
    Bitmap localBitmap;
    for (;;)
    {
      localBitmap = x.pg(this.val$filePath);
      if (localBitmap != null) {
        break;
      }
      CardGiftReceiveUI.i(this.iuw.iuv).setImageResource(a.f.download_image_icon);
      return;
      CardGiftReceiveUI.h(this.iuw.iuv).setVisibility(8);
    }
    CardGiftReceiveUI.i(this.iuw.iuv).setImageBitmap(localBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardGiftReceiveUI.4.2
 * JD-Core Version:    0.7.0.1
 */