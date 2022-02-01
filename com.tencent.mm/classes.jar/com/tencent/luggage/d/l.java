package com.tencent.luggage.d;

import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class l
{
  public ConcurrentHashMap<f, Boolean> chE;
  private Handler mMainHandler;
  
  public l()
  {
    AppMethodBeat.i(140410);
    this.chE = new ConcurrentHashMap();
    this.mMainHandler = new Handler(Looper.getMainLooper());
    AppMethodBeat.o(140410);
  }
  
  private static boolean Ch()
  {
    AppMethodBeat.i(140411);
    if (Looper.getMainLooper().getThread() == Thread.currentThread())
    {
      AppMethodBeat.o(140411);
      return true;
    }
    AppMethodBeat.o(140411);
    return false;
  }
  
  final boolean O(Class<? extends f> paramClass)
  {
    AppMethodBeat.i(140413);
    if (!Ch())
    {
      ad.e("LuggagePageEventBus", "notifyListener on non-UI thread");
      AppMethodBeat.o(140413);
      return false;
    }
    Iterator localIterator = this.chE.keySet().iterator();
    while (localIterator.hasNext())
    {
      f localf = (f)localIterator.next();
      if (paramClass.isInstance(localf))
      {
        boolean bool = localf.call();
        if (((Boolean)this.chE.get(localf)).booleanValue()) {
          this.chE.remove(localf);
        }
        if (bool)
        {
          AppMethodBeat.o(140413);
          return true;
        }
      }
    }
    AppMethodBeat.o(140413);
    return false;
  }
  
  public final void a(f paramf)
  {
    AppMethodBeat.i(140412);
    this.chE.put(paramf, Boolean.TRUE);
    AppMethodBeat.o(140412);
  }
  
  public static abstract class a
    extends l.f
  {
    public a()
    {
      super();
    }
    
    public final boolean call()
    {
      return onBackPressed();
    }
    
    public abstract boolean onBackPressed();
  }
  
  public static abstract class b
    extends l.f
  {
    public b()
    {
      super();
    }
  }
  
  public static abstract class c
    extends l.f
  {
    public c()
    {
      super();
    }
  }
  
  public static abstract class d
    extends l.f
  {
    public d()
    {
      super();
    }
  }
  
  public static abstract class e
    extends l.f
  {
    public e()
    {
      super();
    }
    
    public final boolean call()
    {
      onReady();
      return false;
    }
    
    public abstract void onReady();
  }
  
  public static abstract class f
  {
    public abstract boolean call();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.d.l
 * JD-Core Version:    0.7.0.1
 */