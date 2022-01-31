package com.tencent.mm.plugin.emoji.ui.v2;

import android.os.Bundle;
import android.os.Message;
import android.widget.Button;
import android.widget.ProgressBar;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class EmojiStoreV2SingleRecommendView$1
  extends ah
{
  EmojiStoreV2SingleRecommendView$1(EmojiStoreV2SingleRecommendView paramEmojiStoreV2SingleRecommendView) {}
  
  public final void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      int i;
      do
      {
        return;
        i = paramMessage.getData().getInt("progress");
        if (bk.bl(paramMessage.getData().getString("product_id")))
        {
          y.w("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "product id is null");
          return;
        }
        if (EmojiStoreV2SingleRecommendView.a(this.jiS) != null) {
          EmojiStoreV2SingleRecommendView.a(this.jiS).setVisibility(8);
        }
      } while (EmojiStoreV2SingleRecommendView.b(this.jiS) == null);
      EmojiStoreV2SingleRecommendView.b(this.jiS).setVisibility(0);
      EmojiStoreV2SingleRecommendView.b(this.jiS).setProgress(i);
      return;
      paramMessage.getData().getInt("status");
      if (bk.bl(paramMessage.getData().getString("product_id")))
      {
        y.w("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "product id is null");
        return;
      }
      if (EmojiStoreV2SingleRecommendView.a(this.jiS) != null) {
        EmojiStoreV2SingleRecommendView.a(this.jiS).setVisibility(0);
      }
    } while (EmojiStoreV2SingleRecommendView.b(this.jiS) == null);
    EmojiStoreV2SingleRecommendView.b(this.jiS).setVisibility(8);
    EmojiStoreV2SingleRecommendView.b(this.jiS).setProgress(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleRecommendView.1
 * JD-Core Version:    0.7.0.1
 */