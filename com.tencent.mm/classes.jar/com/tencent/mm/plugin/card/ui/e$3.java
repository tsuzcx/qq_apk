package com.tencent.mm.plugin.card.ui;

import android.os.Message;
import com.tencent.mm.plugin.card.d.c;
import com.tencent.mm.plugin.card.d.d;
import com.tencent.mm.plugin.card.ui.view.g;
import com.tencent.mm.sdk.platformtools.ah;

final class e$3
  extends ah
{
  e$3(e parame) {}
  
  public final void handleMessage(Message paramMessage)
  {
    if ((paramMessage.obj != null) && ((paramMessage.obj instanceof e.c)))
    {
      paramMessage = (e.c)paramMessage.obj;
      if (paramMessage.isZ != e.b.isX) {
        break label71;
      }
      if (this.isQ.iss != null)
      {
        d.a(this.isQ.isl, paramMessage.aox, false);
        this.isQ.iss.aCX();
      }
    }
    label71:
    do
    {
      do
      {
        return;
        if (paramMessage.isZ != e.b.isV) {
          break;
        }
      } while (this.isQ.iss == null);
      this.isQ.iss.d(c.iyS);
      return;
    } while (this.isQ.iss == null);
    this.isQ.iss.d(paramMessage.ita);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.e.3
 * JD-Core Version:    0.7.0.1
 */