package android.support.design.widget;

import android.os.Handler.Callback;
import android.os.Message;

final class l$1
  implements Handler.Callback
{
  l$1(l paraml) {}
  
  public final boolean handleMessage(Message arg1)
  {
    switch (???.what)
    {
    default: 
      return false;
    }
    l locall = this.kF;
    l.b localb = (l.b)???.obj;
    synchronized (locall.mLock)
    {
      if ((locall.kD == localb) || (locall.kE == localb)) {
        locall.a(localb);
      }
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.design.widget.l.1
 * JD-Core Version:    0.7.0.1
 */