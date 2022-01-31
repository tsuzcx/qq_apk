package com.tencent.mm.plugin.account.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;

final class a$1
  implements View.OnTouchListener
{
  a$1(a parama) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      ((TextView)paramView.findViewById(q.f.alias_tv)).setTextColor(-10395295);
    }
    while (paramMotionEvent.getAction() != 1) {
      return false;
    }
    ((TextView)paramView.findViewById(q.f.alias_tv)).setTextColor(-1);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.a.1
 * JD-Core Version:    0.7.0.1
 */