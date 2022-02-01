package com.danikula.videocache;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.Iterator;
import java.util.List;

final class HttpProxyCacheServerClients$UiListenerHandler
  extends Handler
  implements CacheListener
{
  private final List<CacheListener> listeners;
  private final String url;
  
  public HttpProxyCacheServerClients$UiListenerHandler(String paramString, List<CacheListener> paramList)
  {
    super(Looper.getMainLooper());
    AppMethodBeat.i(183577);
    this.url = paramString;
    this.listeners = paramList;
    AppMethodBeat.o(183577);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(183579);
    Iterator localIterator = this.listeners.iterator();
    while (localIterator.hasNext()) {
      ((CacheListener)localIterator.next()).onCacheAvailable((File)paramMessage.obj, this.url, paramMessage.arg1);
    }
    AppMethodBeat.o(183579);
  }
  
  public final void onCacheAvailable(File paramFile, String paramString, int paramInt)
  {
    AppMethodBeat.i(190306);
    paramString = obtainMessage();
    paramString.arg1 = paramInt;
    paramString.obj = paramFile;
    sendMessage(paramString);
    AppMethodBeat.o(190306);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.danikula.videocache.HttpProxyCacheServerClients.UiListenerHandler
 * JD-Core Version:    0.7.0.1
 */