package com.tencent.mm.plugin.card.ui;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.d.c;
import com.tencent.mm.plugin.card.d.d;
import com.tencent.mm.plugin.card.ui.view.g;
import com.tencent.mm.sdk.platformtools.ak;

final class e$3
  extends ak
{
  e$3(e parame) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(88337);
    if ((paramMessage.obj != null) && ((paramMessage.obj instanceof e.c)))
    {
      paramMessage = (e.c)paramMessage.obj;
      if (paramMessage.kug == e.b.kue)
      {
        if (this.ktX.ktz != null)
        {
          d.a(this.ktX.kts, paramMessage.errMsg, false);
          this.ktX.ktz.bft();
          AppMethodBeat.o(88337);
        }
      }
      else if (paramMessage.kug == e.b.kuc)
      {
        if (this.ktX.ktz != null)
        {
          this.ktX.ktz.d(c.kBZ);
          AppMethodBeat.o(88337);
        }
      }
      else if (this.ktX.ktz != null) {
        this.ktX.ktz.d(paramMessage.kuh);
      }
    }
    AppMethodBeat.o(88337);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.e.3
 * JD-Core Version:    0.7.0.1
 */