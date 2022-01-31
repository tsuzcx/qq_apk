package com.google.android.exoplayer2;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.g.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
    AppMethodBeat.i(94777);
    Object localObject = this.avS;
    switch (paramMessage.what)
    {
    default: 
      paramMessage = new IllegalStateException();
      AppMethodBeat.o(94777);
      throw paramMessage;
    case 0: 
      ((h)localObject).avI -= 1;
      AppMethodBeat.o(94777);
      return;
    case 1: 
      ((h)localObject).avG = paramMessage.arg1;
      paramMessage = ((h)localObject).avB.iterator();
      while (paramMessage.hasNext()) {
        ((q.a)paramMessage.next()).b(((h)localObject).avF, ((h)localObject).avG);
      }
      AppMethodBeat.o(94777);
      return;
    case 2: 
      if (paramMessage.arg1 != 0) {}
      for (boolean bool = true;; bool = false)
      {
        ((h)localObject).isLoading = bool;
        paramMessage = ((h)localObject).avB.iterator();
        while (paramMessage.hasNext()) {
          ((q.a)paramMessage.next()).aF(((h)localObject).isLoading);
        }
      }
      AppMethodBeat.o(94777);
      return;
    case 3: 
      if (((h)localObject).avI == 0)
      {
        paramMessage = (i)paramMessage.obj;
        ((h)localObject).avE = true;
        ((h)localObject).avL = paramMessage.aYm;
        ((h)localObject).avM = paramMessage.aYn;
        ((h)localObject).avy.Q(paramMessage.info);
        paramMessage = ((h)localObject).avB.iterator();
        while (paramMessage.hasNext()) {
          ((q.a)paramMessage.next()).nb();
        }
        AppMethodBeat.o(94777);
        return;
      }
      break;
    case 4: 
      int i = ((h)localObject).avH - 1;
      ((h)localObject).avH = i;
      if (i == 0)
      {
        ((h)localObject).avO = ((i.b)paramMessage.obj);
        if (((h)localObject).avJ.isEmpty())
        {
          ((h)localObject).avQ = 0;
          ((h)localObject).avP = 0;
          ((h)localObject).avR = 0L;
        }
        if (paramMessage.arg1 != 0)
        {
          paramMessage = ((h)localObject).avB.iterator();
          while (paramMessage.hasNext()) {
            ((q.a)paramMessage.next()).nc();
          }
          AppMethodBeat.o(94777);
          return;
        }
      }
      break;
    case 5: 
      if (((h)localObject).avH == 0)
      {
        ((h)localObject).avO = ((i.b)paramMessage.obj);
        paramMessage = ((h)localObject).avB.iterator();
        while (paramMessage.hasNext()) {
          ((q.a)paramMessage.next()).nc();
        }
        AppMethodBeat.o(94777);
        return;
      }
      break;
    case 6: 
      paramMessage = (i.d)paramMessage.obj;
      ((h)localObject).avH -= paramMessage.awE;
      if (((h)localObject).avI == 0)
      {
        ((h)localObject).avJ = paramMessage.avJ;
        ((h)localObject).avK = paramMessage.avK;
        ((h)localObject).avO = paramMessage.avO;
        if ((((h)localObject).avH == 0) && (((h)localObject).avJ.isEmpty()))
        {
          ((h)localObject).avQ = 0;
          ((h)localObject).avP = 0;
          ((h)localObject).avR = 0L;
        }
        paramMessage = ((h)localObject).avB.iterator();
        while (paramMessage.hasNext()) {
          ((q.a)paramMessage.next()).na();
        }
        AppMethodBeat.o(94777);
        return;
      }
      break;
    case 7: 
      paramMessage = (p)paramMessage.obj;
      if (!((h)localObject).avN.equals(paramMessage))
      {
        ((h)localObject).avN = paramMessage;
        localObject = ((h)localObject).avB.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((q.a)((Iterator)localObject).next()).b(paramMessage);
        }
        AppMethodBeat.o(94777);
        return;
      }
      break;
    case 8: 
      paramMessage = (e)paramMessage.obj;
      localObject = ((h)localObject).avB.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((q.a)((Iterator)localObject).next()).a(paramMessage);
      }
      AppMethodBeat.o(94777);
      return;
    }
    AppMethodBeat.o(94777);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.exoplayer2.h.1
 * JD-Core Version:    0.7.0.1
 */