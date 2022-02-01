package com.tencent.luggage.d;

import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class i
{
  public ConcurrentHashMap<f, Boolean> car;
  private Handler mMainHandler;
  
  public i()
  {
    AppMethodBeat.i(140410);
    this.car = new ConcurrentHashMap();
    this.mMainHandler = new Handler(Looper.getMainLooper());
    AppMethodBeat.o(140410);
  }
  
  private static boolean Be()
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
    if (!Be())
    {
      ad.e("LuggagePageEventBus", "notifyListener on non-UI thread");
      AppMethodBeat.o(140413);
      return false;
    }
    Iterator localIterator = this.car.keySet().iterator();
    while (localIterator.hasNext())
    {
      f localf = (f)localIterator.next();
      if (paramClass.isInstance(localf))
      {
        boolean bool = localf.call();
        if (((Boolean)this.car.get(localf)).booleanValue()) {
          this.car.remove(localf);
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
    this.car.put(paramf, Boolean.TRUE);
    AppMethodBeat.o(140412);
  }
  
  public static abstract class a
    extends i.f
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
    extends i.f
  {
    public b()
    {
      super();
    }
  }
  
  public static abstract class c
    extends i.f
  {
    public c()
    {
      super();
    }
  }
  
  public static abstract class d
    extends i.f
  {
    public d()
    {
      super();
    }
  }
  
  public static abstract class e
    extends i.f
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
 * Qualified Name:     com.tencent.luggage.d.i
 * JD-Core Version:    0.7.0.1
 */