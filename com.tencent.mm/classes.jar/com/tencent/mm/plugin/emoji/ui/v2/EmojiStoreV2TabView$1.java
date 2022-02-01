package com.tencent.mm.plugin.emoji.ui.v2;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class EmojiStoreV2TabView$1
  implements View.OnClickListener
{
  EmojiStoreV2TabView$1(EmojiStoreV2TabView paramEmojiStoreV2TabView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(109371);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2TabView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    int i = ((Integer)paramView.getTag()).intValue();
    if (EmojiStoreV2TabView.a(this.uQe) != null) {
      EmojiStoreV2TabView.a(this.uQe).onTabClick(i);
    }
    a.a(this, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2TabView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(109371);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2TabView.1
 * JD-Core Version:    0.7.0.1
 */