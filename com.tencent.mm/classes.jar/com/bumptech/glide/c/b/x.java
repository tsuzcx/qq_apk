package com.bumptech.glide.c.b;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.bumptech.glide.h.j;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class x
{
  private boolean aGt;
  private final Handler handler;
  
  x()
  {
    AppMethodBeat.i(77057);
    this.handler = new Handler(Looper.getMainLooper(), new a());
    AppMethodBeat.o(77057);
  }
  
  final void e(u<?> paramu)
  {
    AppMethodBeat.i(77058);
    j.qa();
    if (this.aGt)
    {
      this.handler.obtainMessage(1, paramu).sendToTarget();
      AppMethodBeat.o(77058);
      return;
    }
    this.aGt = true;
    paramu.recycle();
    this.aGt = false;
    AppMethodBeat.o(77058);
  }
  
  static final class a
    implements Handler.Callback
  {
    public final boolean handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(77056);
      if (paramMessage.what == 1)
      {
        ((u)paramMessage.obj).recycle();
        AppMethodBeat.o(77056);
        return true;
      }
      AppMethodBeat.o(77056);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.c.b.x
 * JD-Core Version:    0.7.0.1
 */