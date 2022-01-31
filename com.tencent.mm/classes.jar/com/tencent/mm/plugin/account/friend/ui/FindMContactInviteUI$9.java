package com.tencent.mm.plugin.account.friend.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.account.friend.a.i;
import com.tencent.mm.ui.applet.b;

final class FindMContactInviteUI$9
  implements View.OnTouchListener
{
  FindMContactInviteUI$9(FindMContactInviteUI paramFindMContactInviteUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(108546);
    if (FindMContactInviteUI.b(this.gzf) != null)
    {
      paramView = FindMContactInviteUI.b(this.gzf);
      if (paramView.gxo != null) {
        paramView.gxo.onTouchEvent(paramMotionEvent);
      }
    }
    AppMethodBeat.o(108546);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.FindMContactInviteUI.9
 * JD-Core Version:    0.7.0.1
 */