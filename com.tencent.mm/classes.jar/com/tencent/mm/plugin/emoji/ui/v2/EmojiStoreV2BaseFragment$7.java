package com.tencent.mm.plugin.emoji.ui.v2;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class EmojiStoreV2BaseFragment$7
  implements View.OnTouchListener
{
  EmojiStoreV2BaseFragment$7(EmojiStoreV2BaseFragment paramEmojiStoreV2BaseFragment) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(194889);
    b localb = new b();
    localb.bd(paramView);
    localb.bd(paramMotionEvent);
    a.b("com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2BaseFragment$6", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
    a.a(false, this, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2BaseFragment$6", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(194889);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2BaseFragment.7
 * JD-Core Version:    0.7.0.1
 */