package com.b.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.Iterator;
import java.util.List;

final class g$a
  extends Handler
  implements b
{
  private final List<b> listeners;
  private final String url;
  
  public g$a(String paramString, List<b> paramList)
  {
    super(Looper.getMainLooper());
    AppMethodBeat.i(183577);
    this.url = paramString;
    this.listeners = paramList;
    AppMethodBeat.o(183577);
  }
  
  public final void c(File paramFile, int paramInt)
  {
    AppMethodBeat.i(183578);
    Message localMessage = obtainMessage();
    localMessage.arg1 = paramInt;
    localMessage.obj = paramFile;
    sendMessage(localMessage);
    AppMethodBeat.o(183578);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(183579);
    Iterator localIterator = this.listeners.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).c((File)paramMessage.obj, paramMessage.arg1);
    }
    AppMethodBeat.o(183579);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.b.a.g.a
 * JD-Core Version:    0.7.0.1
 */