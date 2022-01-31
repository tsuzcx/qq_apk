package com.tencent.luggage.d;

import android.os.Handler;
import android.os.Looper;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class i
{
  public ConcurrentHashMap<i.f, Boolean> bzb;
  private Handler mMainHandler;
  
  public i()
  {
    AppMethodBeat.i(90809);
    this.bzb = new ConcurrentHashMap();
    this.mMainHandler = new Handler(Looper.getMainLooper());
    AppMethodBeat.o(90809);
  }
  
  private static boolean uq()
  {
    AppMethodBeat.i(90810);
    if (Looper.getMainLooper().getThread() == Thread.currentThread())
    {
      AppMethodBeat.o(90810);
      return true;
    }
    AppMethodBeat.o(90810);
    return false;
  }
  
  public final void a(i.f paramf)
  {
    AppMethodBeat.i(90811);
    this.bzb.put(paramf, Boolean.TRUE);
    AppMethodBeat.o(90811);
  }
  
  final boolean u(Class<? extends i.f> paramClass)
  {
    AppMethodBeat.i(90812);
    if (!uq())
    {
      d.e("LuggagePageEventBus", "notifyListener on non-UI thread");
      AppMethodBeat.o(90812);
      return false;
    }
    Iterator localIterator = this.bzb.keySet().iterator();
    while (localIterator.hasNext())
    {
      i.f localf = (i.f)localIterator.next();
      if (paramClass.isInstance(localf))
      {
        boolean bool = localf.call();
        if (((Boolean)this.bzb.get(localf)).booleanValue()) {
          this.bzb.remove(localf);
        }
        if (bool)
        {
          AppMethodBeat.o(90812);
          return true;
        }
      }
    }
    AppMethodBeat.o(90812);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.d.i
 * JD-Core Version:    0.7.0.1
 */