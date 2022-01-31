package com.tencent.mm.plugin.label.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ContactLabelManagerUI$11
  implements View.OnTouchListener
{
  ContactLabelManagerUI$11(ContactLabelManagerUI paramContactLabelManagerUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(22596);
    if (paramMotionEvent.getAction() == 0)
    {
      ContactLabelManagerUI.a(this.nYI, (int)paramMotionEvent.getRawX());
      ContactLabelManagerUI.b(this.nYI, (int)paramMotionEvent.getRawY());
    }
    AppMethodBeat.o(22596);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.ContactLabelManagerUI.11
 * JD-Core Version:    0.7.0.1
 */