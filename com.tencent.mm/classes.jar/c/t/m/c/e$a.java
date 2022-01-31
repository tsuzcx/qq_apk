package c.t.m.c;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;

class e$a
  extends Handler
{
  private StringBuilder b;
  
  public e$a(e parame, Looper paramLooper)
  {
    super(paramLooper);
    AppMethodBeat.i(136343);
    this.b = new StringBuilder(1024);
    AppMethodBeat.o(136343);
  }
  
  public void a(Message paramMessage)
  {
    AppMethodBeat.i(136345);
    try
    {
      int i = paramMessage.what;
      switch (i)
      {
      default: 
        AppMethodBeat.o(136345);
        return;
      }
    }
    catch (Throwable paramMessage)
    {
      AppMethodBeat.o(136345);
      return;
    }
    AppMethodBeat.o(136345);
    return;
    AppMethodBeat.o(136345);
    return;
    AppMethodBeat.o(136345);
    return;
    AppMethodBeat.o(136345);
    return;
    new h(e.a(this.a)).a();
    AppMethodBeat.o(136345);
    return;
    AppMethodBeat.o(136345);
    return;
    AppMethodBeat.o(136345);
  }
  
  public void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(136344);
    super.handleMessage(paramMessage);
    a(paramMessage);
    AppMethodBeat.o(136344);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     c.t.m.c.e.a
 * JD-Core Version:    0.7.0.1
 */