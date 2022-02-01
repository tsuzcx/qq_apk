package com.tencent.mm.emojisearch.ui;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class EmojiSearchEditTextView$5
  implements Runnable
{
  EmojiSearchEditTextView$5(EmojiSearchEditTextView paramEmojiSearchEditTextView) {}
  
  public final void run()
  {
    AppMethodBeat.i(231452);
    ((InputMethodManager)this.mpl.getContext().getSystemService("input_method")).showSoftInput(EmojiSearchEditTextView.e(this.mpl), 1);
    AppMethodBeat.o(231452);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emojisearch.ui.EmojiSearchEditTextView.5
 * JD-Core Version:    0.7.0.1
 */