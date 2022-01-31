package com.google.android.exoplayer2;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.g.g;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

final class h$1
  extends Handler
{
  h$1(h paramh, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    Object localObject = this.atA;
    switch (paramMessage.what)
    {
    default: 
      throw new IllegalStateException();
    case 0: 
      ((h)localObject).atq -= 1;
    }
    for (;;)
    {
      return;
      ((h)localObject).ato = paramMessage.arg1;
      paramMessage = ((h)localObject).atj.iterator();
      while (paramMessage.hasNext()) {
        ((q.a)paramMessage.next()).b(((h)localObject).atn, ((h)localObject).ato);
      }
      continue;
      if (paramMessage.arg1 != 0) {}
      for (boolean bool = true;; bool = false)
      {
        ((h)localObject).isLoading = bool;
        paramMessage = ((h)localObject).atj.iterator();
        while (paramMessage.hasNext()) {
          ((q.a)paramMessage.next()).aw(((h)localObject).isLoading);
        }
        break;
      }
      if (((h)localObject).atq == 0)
      {
        paramMessage = (com.google.android.exoplayer2.g.h)paramMessage.obj;
        ((h)localObject).atm = true;
        ((h)localObject).att = paramMessage.aQI;
        ((h)localObject).atu = paramMessage.aQJ;
        ((h)localObject).atg.Q(paramMessage.aQK);
        paramMessage = ((h)localObject).atj.iterator();
        while (paramMessage.hasNext()) {
          paramMessage.next();
        }
        continue;
        int i = ((h)localObject).atp - 1;
        ((h)localObject).atp = i;
        if (i == 0)
        {
          ((h)localObject).atw = ((i.b)paramMessage.obj);
          if (((h)localObject).atr.isEmpty())
          {
            ((h)localObject).aty = 0;
            ((h)localObject).atx = 0;
            ((h)localObject).atz = 0L;
          }
          if (paramMessage.arg1 != 0)
          {
            paramMessage = ((h)localObject).atj.iterator();
            while (paramMessage.hasNext()) {
              ((q.a)paramMessage.next()).kT();
            }
            continue;
            if (((h)localObject).atp == 0)
            {
              ((h)localObject).atw = ((i.b)paramMessage.obj);
              paramMessage = ((h)localObject).atj.iterator();
              while (paramMessage.hasNext()) {
                ((q.a)paramMessage.next()).kT();
              }
              continue;
              paramMessage = (i.d)paramMessage.obj;
              ((h)localObject).atp -= paramMessage.aum;
              if (((h)localObject).atq == 0)
              {
                ((h)localObject).atr = paramMessage.atr;
                ((h)localObject).ats = paramMessage.ats;
                ((h)localObject).atw = paramMessage.atw;
                if ((((h)localObject).atp == 0) && (((h)localObject).atr.isEmpty()))
                {
                  ((h)localObject).aty = 0;
                  ((h)localObject).atx = 0;
                  ((h)localObject).atz = 0L;
                }
                paramMessage = ((h)localObject).atj.iterator();
                while (paramMessage.hasNext()) {
                  paramMessage.next();
                }
                continue;
                paramMessage = (p)paramMessage.obj;
                if (!((h)localObject).atv.equals(paramMessage))
                {
                  ((h)localObject).atv = paramMessage;
                  localObject = ((h)localObject).atj.iterator();
                  while (((Iterator)localObject).hasNext()) {
                    ((q.a)((Iterator)localObject).next()).a(paramMessage);
                  }
                  continue;
                  paramMessage = (e)paramMessage.obj;
                  localObject = ((h)localObject).atj.iterator();
                  while (((Iterator)localObject).hasNext()) {
                    ((q.a)((Iterator)localObject).next()).a(paramMessage);
                  }
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.exoplayer2.h.1
 * JD-Core Version:    0.7.0.1
 */