package com.tencent.mm.bb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.nn;
import com.tencent.mm.f.a.nn.b;
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
        nn localnn = new nn();
        localnn.fLT.action = 6;
        localnn.fLT.fLV = this.lVl;
        EventCenter.instance.publish(localnn);
        AppMethodBeat.o(136988);
      }
    });
    AppMethodBeat.o(136995);
  }
  
  public static void b(f paramf)
  {
    AppMethodBeat.i(257263);
    nn localnn = new nn();
    localnn.fLT.action = 16;
    localnn.fLT.fLV = paramf;
    EventCenter.instance.publish(localnn);
    AppMethodBeat.o(257263);
  }
  
  public static f bnA()
  {
    AppMethodBeat.i(136999);
    Object localObject = new nn();
    ((nn)localObject).fLT.action = -2;
    EventCenter.instance.publish((IEvent)localObject);
    localObject = ((nn)localObject).fLU.fLV;
    AppMethodBeat.o(136999);
    return localObject;
  }
  
  public static c bnB()
  {
    AppMethodBeat.i(137003);
    Object localObject = new nn();
    ((nn)localObject).fLT.action = 8;
    EventCenter.instance.publish((IEvent)localObject);
    localObject = ((nn)localObject).fLU.fLZ;
    AppMethodBeat.o(137003);
    return localObject;
  }
  
  public static final void bnt()
  {
    AppMethodBeat.i(136991);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(136981);
        nn localnn = new nn();
        localnn.fLT.action = 1;
        EventCenter.instance.publish(localnn);
        AppMethodBeat.o(136981);
      }
    });
    AppMethodBeat.o(136991);
  }
  
  public static final void bnu()
  {
    AppMethodBeat.i(136992);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(136983);
        nn localnn = new nn();
        localnn.fLT.action = 2;
        EventCenter.instance.publish(localnn);
        AppMethodBeat.o(136983);
      }
    });
    AppMethodBeat.o(136992);
  }
  
  public static final void bnv()
  {
    AppMethodBeat.i(136993);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(136984);
        nn localnn = new nn();
        localnn.fLT.action = -1;
        EventCenter.instance.publish(localnn);
        AppMethodBeat.o(136984);
      }
    });
    AppMethodBeat.o(136993);
  }
  
  public static final void bnw()
  {
    AppMethodBeat.i(136994);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(136987);
        nn localnn = new nn();
        localnn.fLT.action = 11;
        EventCenter.instance.publish(localnn);
        AppMethodBeat.o(136987);
      }
    });
    AppMethodBeat.o(136994);
  }
  
  public static boolean bnx()
  {
    AppMethodBeat.i(136996);
    nn localnn = new nn();
    localnn.fLT.action = -3;
    EventCenter.instance.publish(localnn);
    boolean bool = localnn.fLU.result;
    AppMethodBeat.o(136996);
    return bool;
  }
  
  public static boolean bny()
  {
    AppMethodBeat.i(136997);
    nn localnn = new nn();
    localnn.fLT.action = 10;
    EventCenter.instance.publish(localnn);
    boolean bool = localnn.fLU.result;
    AppMethodBeat.o(136997);
    return bool;
  }
  
  public static boolean bnz()
  {
    AppMethodBeat.i(136998);
    nn localnn = new nn();
    localnn.fLT.action = 9;
    EventCenter.instance.publish(localnn);
    boolean bool = localnn.fLU.result;
    AppMethodBeat.o(136998);
    return bool;
  }
  
  public static void c(f paramf)
  {
    AppMethodBeat.i(137000);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(136989);
        nn localnn = new nn();
        localnn.fLT.action = 0;
        localnn.fLT.fLV = this.lVh;
        EventCenter.instance.publish(localnn);
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
        nn localnn = new nn();
        localnn.fLT.action = 3;
        localnn.fLT.fLV = this.lVh;
        EventCenter.instance.publish(localnn);
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
    switch (paramf.lVr)
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
        nn localnn = new nn();
        localnn.fLT.action = 4;
        localnn.fLT.fEp = this.lVm;
        localnn.fLT.fLW = paramInt;
        EventCenter.instance.publish(localnn);
        AppMethodBeat.o(136990);
      }
    });
    AppMethodBeat.o(182547);
  }
  
  public static boolean wG(int paramInt)
  {
    AppMethodBeat.i(137002);
    nn localnn = new nn();
    localnn.fLT.action = 7;
    localnn.fLT.position = paramInt;
    EventCenter.instance.publish(localnn);
    boolean bool = localnn.fLU.result;
    AppMethodBeat.o(137002);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.bb.a
 * JD-Core Version:    0.7.0.1
 */