package com.tencent.mm.plugin.finder.ui;

import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "v", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "actionId", "", "event", "Landroid/view/KeyEvent;", "onEditorAction"})
final class FinderCreateContactUI$d
  implements TextView.OnEditorActionListener
{
  FinderCreateContactUI$d(FinderCreateContactUI paramFinderCreateContactUI) {}
  
  public final boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(167162);
    if (5 == paramInt) {
      FinderCreateContactUI.d(this.sMR).clearFocus();
    }
    AppMethodBeat.o(167162);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderCreateContactUI.d
 * JD-Core Version:    0.7.0.1
 */