package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$1
  implements View.OnTouchListener
{
  b$1(b paramb) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(127864);
    if (paramMotionEvent.getAction() == 0)
    {
      ((TextView)paramView.findViewById(2131296716)).setTextColor(b.a(this.kjT).getResources().getColor(2131100245));
      AppMethodBeat.o(127864);
      return false;
    }
    if (paramMotionEvent.getAction() == 1)
    {
      ((TextView)paramView.findViewById(2131296716)).setTextColor(b.a(this.kjT).getResources().getColor(2131101427));
      AppMethodBeat.o(127864);
      return false;
    }
    AppMethodBeat.o(127864);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.b.1
 * JD-Core Version:    0.7.0.1
 */