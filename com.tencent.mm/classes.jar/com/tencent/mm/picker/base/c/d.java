package com.tencent.mm.picker.base.c;

import android.os.Handler;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.picker.base.view.WheelView;
import com.tencent.mm.picker.base.view.WheelView.1;
import com.tencent.mm.picker.base.view.WheelView.a;

public final class d
  extends Handler
{
  private final WheelView pxN;
  
  public d(WheelView paramWheelView)
  {
    this.pxN = paramWheelView;
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(175297);
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(175297);
      return;
      this.pxN.invalidate();
      AppMethodBeat.o(175297);
      return;
      this.pxN.a(WheelView.a.pyw);
      AppMethodBeat.o(175297);
      return;
      paramMessage = this.pxN;
      paramMessage.bSR();
      if (paramMessage.pxX != null) {
        paramMessage.postDelayed(new WheelView.1(paramMessage), 200L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.picker.base.c.d
 * JD-Core Version:    0.7.0.1
 */