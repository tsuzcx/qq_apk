package com.tencent.mm.plugin.card.ui;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.plugin.card.model.CardGiftInfo;
import com.tencent.mm.sdk.platformtools.bo;

final class CardGiftReceiveUI$4$2
  implements Runnable
{
  CardGiftReceiveUI$4$2(CardGiftReceiveUI.4 param4, String paramString1, String paramString2) {}
  
  public final void run()
  {
    AppMethodBeat.i(88419);
    if (CardGiftReceiveUI.f(this.kvB.kvA).getVisibility() != 8) {
      CardGiftReceiveUI.f(this.kvB.kvA).setVisibility(8);
    }
    if ((!bo.isNullOrNil(this.fWN)) && (!bo.isNullOrNil(CardGiftReceiveUI.b(this.kvB.kvA).kmF)) && (this.fWN.equals(CardGiftReceiveUI.b(this.kvB.kvA).kmF))) {
      CardGiftReceiveUI.h(this.kvB.kvA).setVisibility(0);
    }
    Bitmap localBitmap;
    for (;;)
    {
      localBitmap = x.wx(this.val$filePath);
      if (localBitmap != null) {
        break;
      }
      CardGiftReceiveUI.i(this.kvB.kvA).setImageResource(2131231253);
      AppMethodBeat.o(88419);
      return;
      CardGiftReceiveUI.h(this.kvB.kvA).setVisibility(8);
    }
    CardGiftReceiveUI.i(this.kvB.kvA).setImageBitmap(localBitmap);
    AppMethodBeat.o(88419);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardGiftReceiveUI.4.2
 * JD-Core Version:    0.7.0.1
 */