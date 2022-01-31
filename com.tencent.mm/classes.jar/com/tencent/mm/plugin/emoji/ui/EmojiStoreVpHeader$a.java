package com.tencent.mm.plugin.emoji.ui;

import android.os.Message;
import android.support.v4.view.ViewPager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.a.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.LinkedList;

final class EmojiStoreVpHeader$a
  extends ak
{
  private EmojiStoreVpHeader$a(EmojiStoreVpHeader paramEmojiStoreVpHeader) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(53510);
    if ((!EmojiStoreVpHeader.d(this.lnS)) && (paramMessage.what != 0))
    {
      AppMethodBeat.o(53510);
      return;
    }
    if ((EmojiStoreVpHeader.b(this.lnS) == null) || (EmojiStoreVpHeader.b(this.lnS).size() <= 1))
    {
      ab.w("MicroMsg.emoji.EmojiStoreVpHeader", "list is null");
      AppMethodBeat.o(53510);
      return;
    }
    if (EmojiStoreVpHeader.a(this.lnS) == null)
    {
      ab.w("MicroMsg.emoji.EmojiStoreVpHeader", "adapter is null");
      AppMethodBeat.o(53510);
      return;
    }
    int j = EmojiStoreVpHeader.e(this.lnS).getCurrentItem() + 1;
    int i = j;
    if (j >= EmojiStoreVpHeader.a(this.lnS).getCount()) {
      i = EmojiStoreVpHeader.b(this.lnS).size() * i.leD / 2;
    }
    EmojiStoreVpHeader.e(this.lnS).setCurrentItem(i);
    if ((EmojiStoreVpHeader.d(this.lnS)) && (EmojiStoreVpHeader.f(this.lnS) != null)) {
      sendMessageDelayed(EmojiStoreVpHeader.f(this.lnS).obtainMessage(0), 5000L);
    }
    AppMethodBeat.o(53510);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiStoreVpHeader.a
 * JD-Core Version:    0.7.0.1
 */