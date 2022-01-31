package com.tencent.matrix.trace.b;

import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.matrix.trace.core.MethodBeat;

public final class a
  implements Handler.Callback
{
  private static boolean isCreated = false;
  private final Handler.Callback brg;
  
  public a(Handler.Callback paramCallback)
  {
    this.brg = paramCallback;
  }
  
  public final boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 100) {
      b.brh = false;
    }
    for (;;)
    {
      if ((!isCreated) && ((paramMessage.what == 100) || (paramMessage.what == 114) || (paramMessage.what == 113)))
      {
        b.brk = System.currentTimeMillis();
        b.brl = MethodBeat.getCurIndex();
        b.brm = paramMessage.what;
        isCreated = true;
      }
      if (this.brg != null) {
        break;
      }
      return false;
      if (paramMessage.what == 149) {
        b.brh = true;
      }
    }
    return this.brg.handleMessage(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.trace.b.a
 * JD-Core Version:    0.7.0.1
 */