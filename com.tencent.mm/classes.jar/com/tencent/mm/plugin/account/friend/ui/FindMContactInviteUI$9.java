package com.tencent.mm.plugin.account.friend.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.plugin.account.friend.a.i;
import com.tencent.mm.ui.applet.b;

final class FindMContactInviteUI$9
  implements View.OnTouchListener
{
  FindMContactInviteUI$9(FindMContactInviteUI paramFindMContactInviteUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (FindMContactInviteUI.b(this.fhx) != null)
    {
      paramView = FindMContactInviteUI.b(this.fhx);
      if (paramView.ffG != null) {
        paramView.ffG.onTouchEvent(paramMotionEvent);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.FindMContactInviteUI.9
 * JD-Core Version:    0.7.0.1
 */