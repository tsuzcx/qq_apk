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
      throw new RuntimeException("Unknown message ".concat(String.valueOf(paramMessage)));
    case 1: 
      this.FP.FA.onShowPress(this.FP.FH);
    }
    do
    {
      return;
      paramMessage = this.FP;
      paramMessage.mHandler.removeMessages(3);
      paramMessage.FD = false;
      paramMessage.FE = true;
      paramMessage.FA.onLongPress(paramMessage.FH);
      return;
    } while (this.FP.FB == null);
    if (!this.FP.FC)
    {
      this.FP.FB.onSingleTapConfirmed(this.FP.FH);
      return;
    }
    this.FP.FD = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.v4.view.c.b.a
 * JD-Core Version:    0.7.0.1
 */