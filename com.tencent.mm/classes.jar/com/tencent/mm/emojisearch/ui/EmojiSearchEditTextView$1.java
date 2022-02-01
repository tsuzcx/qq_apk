package com.tencent.mm.emojisearch.ui;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class EmojiSearchEditTextView$1
  implements View.OnKeyListener
{
  EmojiSearchEditTextView$1(EmojiSearchEditTextView paramEmojiSearchEditTextView) {}
  
  public final boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(230698);
    b localb = new b();
    localb.bn(paramView);
    localb.sg(paramInt);
    localb.bn(paramKeyEvent);
    a.c("com/tencent/mm/emojisearch/ui/EmojiSearchEditTextView$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.aFi());
    paramKeyEvent.getAction();
    a.a(false, this, "com/tencent/mm/emojisearch/ui/EmojiSearchEditTextView$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
    AppMethodBeat.o(230698);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emojisearch.ui.EmojiSearchEditTextView.1
 * JD-Core Version:    0.7.0.1
 */