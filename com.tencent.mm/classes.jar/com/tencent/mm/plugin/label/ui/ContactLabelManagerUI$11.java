package com.tencent.mm.plugin.label.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

final class ContactLabelManagerUI$11
  implements View.OnTouchListener
{
  ContactLabelManagerUI$11(ContactLabelManagerUI paramContactLabelManagerUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      ContactLabelManagerUI.a(this.lBw, (int)paramMotionEvent.getRawX());
      ContactLabelManagerUI.b(this.lBw, (int)paramMotionEvent.getRawY());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.ContactLabelManagerUI.11
 * JD-Core Version:    0.7.0.1
 */