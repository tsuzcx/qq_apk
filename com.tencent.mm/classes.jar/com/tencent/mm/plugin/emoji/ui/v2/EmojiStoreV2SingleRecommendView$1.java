package com.tencent.mm.plugin.emoji.ui.v2;

import android.os.Bundle;
import android.os.Message;
import android.widget.Button;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;

final class EmojiStoreV2SingleRecommendView$1
  extends ak
{
  EmojiStoreV2SingleRecommendView$1(EmojiStoreV2SingleRecommendView paramEmojiStoreV2SingleRecommendView) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(53783);
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(53783);
      return;
      AppMethodBeat.o(53783);
      return;
      int i = paramMessage.getData().getInt("progress");
      if (bo.isNullOrNil(paramMessage.getData().getString("product_id")))
      {
        ab.w("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "product id is null");
        AppMethodBeat.o(53783);
        return;
      }
      if (EmojiStoreV2SingleRecommendView.a(this.lrJ) != null) {
        EmojiStoreV2SingleRecommendView.a(this.lrJ).setVisibility(8);
      }
      if (EmojiStoreV2SingleRecommendView.b(this.lrJ) != null)
      {
        EmojiStoreV2SingleRecommendView.b(this.lrJ).setVisibility(0);
        EmojiStoreV2SingleRecommendView.b(this.lrJ).setProgress(i);
        AppMethodBeat.o(53783);
        return;
        paramMessage.getData().getInt("status");
        if (bo.isNullOrNil(paramMessage.getData().getString("product_id")))
        {
          ab.w("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "product id is null");
          AppMethodBeat.o(53783);
          return;
        }
        if (EmojiStoreV2SingleRecommendView.a(this.lrJ) != null)
        {
          EmojiStoreV2SingleRecommendView.a(this.lrJ).setVisibility(0);
          EmojiStoreV2SingleRecommendView.bnr();
        }
        if (EmojiStoreV2SingleRecommendView.b(this.lrJ) != null)
        {
          EmojiStoreV2SingleRecommendView.b(this.lrJ).setVisibility(8);
          EmojiStoreV2SingleRecommendView.b(this.lrJ).setProgress(0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleRecommendView.1
 * JD-Core Version:    0.7.0.1
 */