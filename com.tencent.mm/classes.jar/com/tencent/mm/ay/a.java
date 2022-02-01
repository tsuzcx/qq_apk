package com.tencent.mm.ay;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mw;
import com.tencent.mm.g.a.mw.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.List;

public final class a
{
  public static final void a(f paramf)
  {
    AppMethodBeat.i(136995);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(136988);
        mw localmw = new mw();
        localmw.dSw.action = 6;
        localmw.dSw.dSy = this.jeM;
        EventCenter.instance.publish(localmw);
        AppMethodBeat.o(136988);
      }
    });
    AppMethodBeat.o(136995);
  }
  
  public static void b(f paramf)
  {
    AppMethodBeat.i(198132);
    mw localmw = new mw();
    localmw.dSw.action = 16;
    localmw.dSw.dSy = paramf;
    EventCenter.instance.publish(localmw);
    AppMethodBeat.o(198132);
  }
  
  public static final void bdY()
  {
    AppMethodBeat.i(136991);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(136981);
        mw localmw = new mw();
        localmw.dSw.action = 1;
        EventCenter.instance.publish(localmw);
        AppMethodBeat.o(136981);
      }
    });
    AppMethodBeat.o(136991);
  }
  
  public static final void bdZ()
  {
    AppMethodBeat.i(136992);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(136983);
        mw localmw = new mw();
        localmw.dSw.action = 2;
        EventCenter.instance.publish(localmw);
        AppMethodBeat.o(136983);
      }
    });
    AppMethodBeat.o(136992);
  }
  
  public static final void bea()
  {
    AppMethodBeat.i(136993);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(136984);
        mw localmw = new mw();
        localmw.dSw.action = -1;
        EventCenter.instance.publish(localmw);
        AppMethodBeat.o(136984);
      }
    });
    AppMethodBeat.o(136993);
  }
  
  public static final void beb()
  {
    AppMethodBeat.i(136994);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(136987);
        mw localmw = new mw();
        localmw.dSw.action = 11;
        EventCenter.instance.publish(localmw);
        AppMethodBeat.o(136987);
      }
    });
    AppMethodBeat.o(136994);
  }
  
  public static boolean bec()
  {
    AppMethodBeat.i(136996);
    mw localmw = new mw();
    localmw.dSw.action = -3;
    EventCenter.instance.publish(localmw);
    boolean bool = localmw.dSx.result;
    AppMethodBeat.o(136996);
    return bool;
  }
  
  public static boolean bed()
  {
    AppMethodBeat.i(136997);
    mw localmw = new mw();
    localmw.dSw.action = 10;
    EventCenter.instance.publish(localmw);
    boolean bool = localmw.dSx.result;
    AppMethodBeat.o(136997);
    return bool;
  }
  
  public static boolean bee()
  {
    AppMethodBeat.i(136998);
    mw localmw = new mw();
    localmw.dSw.action = 9;
    EventCenter.instance.publish(localmw);
    boolean bool = localmw.dSx.result;
    AppMethodBeat.o(136998);
    return bool;
  }
  
  public static f bef()
  {
    AppMethodBeat.i(136999);
    Object localObject = new mw();
    ((mw)localObject).dSw.action = -2;
    EventCenter.instance.publish((IEvent)localObject);
    localObject = ((mw)localObject).dSx.dSy;
    AppMethodBeat.o(136999);
    return localObject;
  }
  
  public static c beg()
  {
    AppMethodBeat.i(137003);
    Object localObject = new mw();
    ((mw)localObject).dSw.action = 8;
    EventCenter.instance.publish((IEvent)localObject);
    localObject = ((mw)localObject).dSx.dSC;
    AppMethodBeat.o(137003);
    return localObject;
  }
  
  public static void c(f paramf)
  {
    AppMethodBeat.i(137000);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(136989);
        mw localmw = new mw();
        localmw.dSw.action = 0;
        localmw.dSw.dSy = this.jeI;
        EventCenter.instance.publish(localmw);
        AppMethodBeat.o(136989);
      }
    });
    AppMethodBeat.o(137000);
  }
  
  public static void d(f paramf)
  {
    AppMethodBeat.i(137001);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(136982);
        mw localmw = new mw();
        localmw.dSw.action = 3;
        localmw.dSw.dSy = this.jeI;
        EventCenter.instance.publish(localmw);
        AppMethodBeat.o(136982);
      }
    });
    AppMethodBeat.o(137001);
  }
  
  public static boolean e(f paramf)
  {
    if (paramf == null) {
      return false;
    }
    switch (paramf.jeT)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static void f(List<f> paramList, final int paramInt)
  {
    AppMethodBeat.i(182547);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(136990);
        mw localmw = new mw();
        localmw.dSw.action = 4;
        localmw.dSw.dLA = this.jeN;
        localmw.dSw.dSz = paramInt;
        EventCenter.instance.publish(localmw);
        AppMethodBeat.o(136990);
      }
    });
    AppMethodBeat.o(182547);
  }
  
  public static boolean tG(int paramInt)
  {
    AppMethodBeat.i(137002);
    mw localmw = new mw();
    localmw.dSw.action = 7;
    localmw.dSw.position = paramInt;
    EventCenter.instance.publish(localmw);
    boolean bool = localmw.dSx.result;
    AppMethodBeat.o(137002);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ay.a
 * JD-Core Version:    0.7.0.1
 */