package com.tencent.mm.plugin.emoji.ui.v2;

import android.os.Bundle;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.a.a.a;
import com.tencent.mm.plugin.emoji.ui.EmojiStoreVpHeader;
import com.tencent.mm.sdk.platformtools.ak;

final class EmojiStoreV2BaseFragment$1
  extends ak
{
  EmojiStoreV2BaseFragment$1(EmojiStoreV2BaseFragment paramEmojiStoreV2BaseFragment) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(53571);
    EmojiStoreV2BaseFragment localEmojiStoreV2BaseFragment = this.loZ;
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(53571);
      return;
      if (localEmojiStoreV2BaseFragment.lhv != null)
      {
        localEmojiStoreV2BaseFragment.lhv.notifyDataSetChanged();
        AppMethodBeat.o(53571);
        return;
        if ((localEmojiStoreV2BaseFragment.lhv == null) || (paramMessage.getData() == null))
        {
          AppMethodBeat.o(53571);
          return;
        }
        String str = paramMessage.getData().getString("product_id");
        if (str != null)
        {
          int i = paramMessage.getData().getInt("progress");
          localEmojiStoreV2BaseFragment.lhv.bY(str, i);
          AppMethodBeat.o(53571);
          return;
          if ((localEmojiStoreV2BaseFragment.lhv == null) || (paramMessage.getData() == null))
          {
            AppMethodBeat.o(53571);
            return;
          }
          str = paramMessage.getData().getString("product_id");
          if (str != null)
          {
            i = paramMessage.getData().getInt("status");
            localEmojiStoreV2BaseFragment.lhv.bX(str, i);
            AppMethodBeat.o(53571);
            return;
            if (localEmojiStoreV2BaseFragment.ljQ != null) {
              localEmojiStoreV2BaseFragment.ljQ.bmW();
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2BaseFragment.1
 * JD-Core Version:    0.7.0.1
 */