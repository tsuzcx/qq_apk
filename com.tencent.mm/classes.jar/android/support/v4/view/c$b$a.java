package android.support.v4.view;

import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;

final class c$b$a
  extends Handler
{
  c$b$a(c.b paramb) {}
  
  public final void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      throw new RuntimeException("Unknown message " + paramMessage);
    case 1: 
      this.Fg.ER.onShowPress(this.Fg.EY);
    }
    do
    {
      return;
      paramMessage = this.Fg;
      paramMessage.mHandler.removeMessages(3);
      paramMessage.EU = false;
      paramMessage.EV = true;
      paramMessage.ER.onLongPress(paramMessage.EY);
      return;
    } while (this.Fg.ES == null);
    if (!this.Fg.ET)
    {
      this.Fg.ES.onSingleTapConfirmed(this.Fg.EY);
      return;
    }
    this.Fg.EU = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     android.support.v4.view.c.b.a
 * JD-Core Version:    0.7.0.1
 */