package android.support.v4.content;

import android.content.BroadcastReceiver;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;

final class d$1
  extends Handler
{
  d$1(d paramd, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      super.handleMessage(paramMessage);
      return;
    }
    paramMessage = this.zK;
    for (;;)
    {
      synchronized (paramMessage.zG)
      {
        i = paramMessage.zI.size();
        if (i <= 0) {
          return;
        }
      }
      d.a[] arrayOfa = new d.a[i];
      paramMessage.zI.toArray(arrayOfa);
      paramMessage.zI.clear();
      int i = 0;
      while (i < arrayOfa.length)
      {
        ??? = arrayOfa[i];
        int k = ???.zL.size();
        int j = 0;
        while (j < k)
        {
          d.b localb = (d.b)???.zL.get(j);
          if (!localb.zN) {
            localb.receiver.onReceive(paramMessage.zF, ???.intent);
          }
          j += 1;
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v4.content.d.1
 * JD-Core Version:    0.7.0.1
 */