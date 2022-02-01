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
    AppMethodBeat.i(199756);
    b localb = new b();
    localb.bm(paramView);
    localb.pH(paramInt);
    localb.bm(paramKeyEvent);
    a.b("com/tencent/mm/emojisearch/ui/EmojiSearchEditTextView$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.axR());
    paramKeyEvent.getAction();
    a.a(false, this, "com/tencent/mm/emojisearch/ui/EmojiSearchEditTextView$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
    AppMethodBeat.o(199756);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.emojisearch.ui.EmojiSearchEditTextView.1
 * JD-Core Version:    0.7.0.1
 */