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
  private final WheelView jKa;
  
  public d(WheelView paramWheelView)
  {
    this.jKa = paramWheelView;
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
      this.jKa.invalidate();
      AppMethodBeat.o(175297);
      return;
      this.jKa.a(WheelView.a.jKJ);
      AppMethodBeat.o(175297);
      return;
      paramMessage = this.jKa;
      if (paramMessage.jKl != null) {
        paramMessage.postDelayed(new WheelView.1(paramMessage), 200L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.picker.base.c.d
 * JD-Core Version:    0.7.0.1
 */