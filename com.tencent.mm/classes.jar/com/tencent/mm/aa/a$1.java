package com.tencent.mm.aa;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.storage.at.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

final class a$1
  extends MMHandler
{
  a$1(a parama, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(150037);
    if ((paramMessage.what == 0) && ((paramMessage.obj instanceof a.b)))
    {
      paramMessage = (a.b)paramMessage.obj;
      if (paramMessage.mxy != null)
      {
        a locala = this.mxw;
        Object localObject2 = paramMessage.mxy;
        paramMessage = null;
        Iterator localIterator = locala.listeners.iterator();
        Object localObject1;
        while (localIterator.hasNext())
        {
          WeakReference localWeakReference = (WeakReference)localIterator.next();
          if ((localWeakReference != null) && (localWeakReference.get() != null))
          {
            ((a.a)localWeakReference.get()).b((at.a)localObject2);
          }
          else
          {
            localObject1 = paramMessage;
            if (paramMessage == null) {
              localObject1 = new ArrayList();
            }
            ((ArrayList)localObject1).add(localWeakReference);
            paramMessage = (Message)localObject1;
          }
        }
        if (paramMessage != null)
        {
          localObject1 = paramMessage.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (WeakReference)((Iterator)localObject1).next();
            locala.listeners.remove(localObject2);
          }
          paramMessage.clear();
        }
        AppMethodBeat.o(150037);
        return;
      }
      a.a(this.mxw, paramMessage.mxx, paramMessage.value);
    }
    AppMethodBeat.o(150037);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.aa.a.1
 * JD-Core Version:    0.7.0.1
 */