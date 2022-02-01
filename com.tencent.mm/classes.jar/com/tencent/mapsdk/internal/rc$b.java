package com.tencent.mapsdk.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

final class rc$b
  extends Handler
{
  WeakReference<rc> a;
  
  public rc$b(rc paramrc)
  {
    super(Looper.myLooper());
    AppMethodBeat.i(222588);
    this.a = new WeakReference(paramrc);
    AppMethodBeat.o(222588);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(222601);
    super.handleMessage(paramMessage);
    rc localrc = (rc)this.a.get();
    if ((localrc != null) && (paramMessage.what != 0))
    {
      String str = (String)paramMessage.obj;
      int i = paramMessage.arg2;
      if (paramMessage.arg1 > 0)
      {
        if (i > 0)
        {
          kh.b("TDL", "循环刷新[" + str + "]次数[" + i + "]");
          rc.a(localrc, str);
        }
        paramMessage.arg2 = (i + 1);
        paramMessage = Message.obtain(paramMessage);
        sendMessageDelayed(paramMessage, paramMessage.arg1);
      }
    }
    AppMethodBeat.o(222601);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mapsdk.internal.rc.b
 * JD-Core Version:    0.7.0.1
 */