package com.tencent.mm.plugin.mmsight.model.a;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class h$1
  extends ak
{
  h$1(h paramh, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(76573);
    if (this.oJl.oIY != null)
    {
      this.oJl.oIY.XF();
      this.oJl.oIY = null;
    }
    AppMethodBeat.o(76573);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.h.1
 * JD-Core Version:    0.7.0.1
 */