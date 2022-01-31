package com.tencent.mm.plugin.location.model;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class o$1
  extends ak
{
  o$1(o paramo, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(113383);
    super.handleMessage(paramMessage);
    if (paramMessage == null)
    {
      AppMethodBeat.o(113383);
      return;
    }
    o localo = this.obx;
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(113383);
      return;
      localo.bLA();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.o.1
 * JD-Core Version:    0.7.0.1
 */