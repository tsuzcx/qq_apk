package com.tencent.mm.plugin.mmsight.model.a;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class i$1
  extends ak
{
  i$1(i parami) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(76585);
    if (this.oJo.oIY != null)
    {
      this.oJo.oIY.XF();
      this.oJo.oIY = null;
    }
    AppMethodBeat.o(76585);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.i.1
 * JD-Core Version:    0.7.0.1
 */