package com.c.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public final class a$a
  extends Handler
{
  private final int aUY = 2001;
  private final int aUZ = 2002;
  private final int aVa = 2003;
  private final int aVb = 2004;
  private final int aVc = 2005;
  private final int aVd = 2006;
  
  public a$a(a parama, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    int i = 2005;
    new StringBuilder("what = ").append(paramMessage.what);
    switch (paramMessage.what)
    {
    case 4: 
    case 5: 
    default: 
    case 1: 
    case 2: 
    case 3: 
      do
      {
        do
        {
          do
          {
            return;
          } while (this.aUX.aUU == null);
          return;
        } while (this.aUX.aUU == null);
        return;
      } while (this.aUX.aUU == null);
      return;
    case 6: 
      if (this.aUX.aUU != null) {
        this.aUX.aUU.aR(0, paramMessage.arg1);
      }
      removeMessages(8);
      return;
    case 7: 
      if (this.aUX.aUU != null) {
        switch (paramMessage.arg1)
        {
        default: 
          i = 2020;
        }
      }
      for (;;)
      {
        this.aUX.aUU.aR(i, -1);
        removeMessages(8);
        return;
        i = 2002;
        continue;
        i = 2003;
        continue;
        i = 2000;
        continue;
        i = 2006;
      }
    }
    if (this.aUX.aUU != null) {
      this.aUX.aUU.aR(2001, -1);
    }
    removeMessages(8);
    this.aUX.abort();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.c.a.a.a
 * JD-Core Version:    0.7.0.1
 */