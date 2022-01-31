package com.tencent.mm.plugin.appbrand.widget.input.c;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class a$1
  extends ak
{
  a$1(a parama, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(77442);
    if (1000 == paramMessage.what)
    {
      String str = (String)paramMessage.obj;
      int i = paramMessage.arg1;
      if (this.jpH.jpG != null) {
        this.jpH.jpG.bg(str, i);
      }
    }
    AppMethodBeat.o(77442);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.c.a.1
 * JD-Core Version:    0.7.0.1
 */