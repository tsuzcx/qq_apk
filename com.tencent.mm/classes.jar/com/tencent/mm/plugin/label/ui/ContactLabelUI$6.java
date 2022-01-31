package com.tencent.mm.plugin.label.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ContactLabelUI$6
  implements View.OnTouchListener
{
  ContactLabelUI$6(ContactLabelUI paramContactLabelUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(22663);
    if (paramMotionEvent.getAction() == 2) {
      this.nZv.hideVKB();
    }
    AppMethodBeat.o(22663);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.ContactLabelUI.6
 * JD-Core Version:    0.7.0.1
 */