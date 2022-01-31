package com.tencent.mm.plugin.emoji.ui;

import android.os.Message;
import android.support.v4.view.ViewPager;
import com.tencent.mm.plugin.emoji.a.i;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

final class EmojiStoreVpHeader$a
  extends ah
{
  private EmojiStoreVpHeader$a(EmojiStoreVpHeader paramEmojiStoreVpHeader) {}
  
  public final void handleMessage(Message paramMessage)
  {
    if ((!EmojiStoreVpHeader.d(this.jfc)) && (paramMessage.what != 0)) {}
    do
    {
      return;
      if ((EmojiStoreVpHeader.b(this.jfc) == null) || (EmojiStoreVpHeader.b(this.jfc).size() <= 1))
      {
        y.w("MicroMsg.emoji.EmojiStoreVpHeader", "list is null");
        return;
      }
      if (EmojiStoreVpHeader.a(this.jfc) == null)
      {
        y.w("MicroMsg.emoji.EmojiStoreVpHeader", "adapter is null");
        return;
      }
      int j = EmojiStoreVpHeader.e(this.jfc).getCurrentItem() + 1;
      int i = j;
      if (j >= EmojiStoreVpHeader.a(this.jfc).getCount()) {
        i = EmojiStoreVpHeader.b(this.jfc).size() * i.iVy / 2;
      }
      EmojiStoreVpHeader.e(this.jfc).setCurrentItem(i);
    } while ((!EmojiStoreVpHeader.d(this.jfc)) || (EmojiStoreVpHeader.f(this.jfc) == null));
    sendMessageDelayed(EmojiStoreVpHeader.f(this.jfc).obtainMessage(0), 5000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiStoreVpHeader.a
 * JD-Core Version:    0.7.0.1
 */