package com.tencent.mm.picker.base.c;

import android.os.Handler;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.picker.base.view.WheelView;
import com.tencent.mm.picker.base.view.WheelView.1;
import com.tencent.mm.picker.base.view.WheelView.a;

public final class b
  extends Handler
{
  private final WheelView irq;
  
  public b(WheelView paramWheelView)
  {
    this.irq = paramWheelView;
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
      this.irq.invalidate();
      AppMethodBeat.o(175297);
      return;
      this.irq.a(WheelView.a.irZ);
      AppMethodBeat.o(175297);
      return;
      paramMessage = this.irq;
      if (paramMessage.irB != null) {
        paramMessage.postDelayed(new WheelView.1(paramMessage), 200L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.picker.base.c.b
 * JD-Core Version:    0.7.0.1
 */