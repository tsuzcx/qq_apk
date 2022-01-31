package com.tencent.mm.plugin.account.model;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.ah;

final class g$1
  extends ah
{
  g$1(g paramg) {}
  
  public final void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return;
      } while (this.fjz.fjy == null);
      this.fjz.fjy.onError(paramMessage.arg1, (String)paramMessage.obj);
      return;
    } while (this.fjz.fjy == null);
    this.fjz.fjy.l(paramMessage.getData());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.model.g.1
 * JD-Core Version:    0.7.0.1
 */