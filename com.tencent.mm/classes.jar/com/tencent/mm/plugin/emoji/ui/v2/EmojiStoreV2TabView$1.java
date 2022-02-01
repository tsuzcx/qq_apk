package com.tencent.mm.plugin.emoji.ui.v2;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class EmojiStoreV2TabView$1
  implements View.OnClickListener
{
  EmojiStoreV2TabView$1(EmojiStoreV2TabView paramEmojiStoreV2TabView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(109371);
    int i = ((Integer)paramView.getTag()).intValue();
    if (EmojiStoreV2TabView.a(this.oIo) != null) {
      EmojiStoreV2TabView.a(this.oIo).onTabClick(i);
    }
    AppMethodBeat.o(109371);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2TabView.1
 * JD-Core Version:    0.7.0.1
 */