package android.support.v4.content;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class e$b
  extends Handler
{
  e$b()
  {
    super(Looper.getMainLooper());
  }
  
  public final void handleMessage(Message paramMessage)
  {
    e.a locala = (e.a)paramMessage.obj;
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    locala.zY.n(locala.zZ[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     android.support.v4.content.e.b
 * JD-Core Version:    0.7.0.1
 */