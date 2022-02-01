package com.tencent.mm.plugin.label.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ContactLabelUI$14
  implements View.OnTouchListener
{
  ContactLabelUI$14(ContactLabelUI paramContactLabelUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(230177);
    if (paramMotionEvent.getAction() == 2) {
      this.EeV.hideVKB();
    }
    AppMethodBeat.o(230177);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.ContactLabelUI.14
 * JD-Core Version:    0.7.0.1
 */