package com.tencent.mm.plugin.emojicapture.ui.editor;

import a.l;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class EditorChangeTextView$4
  implements View.OnClickListener
{
  EditorChangeTextView$4(EditorChangeTextView paramEditorChangeTextView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(3058);
    paramView = EditorChangeTextView.b(this.lzA).getText();
    EditorChangeTextView.a locala = this.lzA.getCallback();
    if (locala != null) {
      locala.i((CharSequence)paramView, EditorChangeTextView.c(this.lzA));
    }
    EditorChangeTextView.b(this.lzA).clearFocus();
    if (this.lzA.getTextChanged()) {
      EmojiCaptureReporter.a(16, this.lzA.getReporter().eyh, 0L, 0L, 0L, 0L, 0L, 0, 0, this.lzA.getReporter().scene);
    }
    EmojiCaptureReporter.a(15, this.lzA.getReporter().eyh, 0L, 0L, 0L, 0L, 0L, 0, 0, this.lzA.getReporter().scene);
    AppMethodBeat.o(3058);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.editor.EditorChangeTextView.4
 * JD-Core Version:    0.7.0.1
 */