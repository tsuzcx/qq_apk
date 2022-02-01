package com.facebook.jni;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.concurrent.atomic.AtomicReference;

public class DestructorThread
{
  private static final DestructorList sDestructorList;
  private static final DestructorStack sDestructorStack;
  private static final ReferenceQueue sReferenceQueue;
  private static final Thread sThread;
  
  static
  {
    AppMethodBeat.i(208070);
    sDestructorStack = new DestructorStack(null);
    sReferenceQueue = new ReferenceQueue();
    sDestructorList = new DestructorList();
    Thread local1 = new Thread("HybridData DestructorThread")
    {
      public final void run()
      {
        AppMethodBeat.i(208047);
        try
        {
          for (;;)
          {
            DestructorThread.Destructor localDestructor = (DestructorThread.Destructor)DestructorThread.sReferenceQueue.remove();
            localDestructor.destruct();
            if (DestructorThread.Destructor.access$300(localDestructor) == null) {
              DestructorThread.sDestructorStack.transferAllToList();
            }
            DestructorThread.DestructorList.access$400(localDestructor);
          }
        }
        catch (InterruptedException localInterruptedException) {}
      }
    };
    sThread = local1;
    local1.start();
    AppMethodBeat.o(208070);
  }
  
  public static abstract class Destructor
    extends PhantomReference<Object>
  {
    private Destructor next;
    private Destructor previous;
    
    private Destructor()
    {
      super(DestructorThread.sReferenceQueue);
    }
    
    public Destructor(Object paramObject)
    {
      super(DestructorThread.sReferenceQueue);
      DestructorThread.sDestructorStack.push(this);
    }
    
    protected abstract void destruct();
  }
  
  static class DestructorList
  {
    private final DestructorThread.Destructor mHead;
    
    public DestructorList()
    {
      AppMethodBeat.i(208043);
      this.mHead = new DestructorThread.Terminus(null);
      DestructorThread.Destructor.access$602(this.mHead, new DestructorThread.Terminus(null));
      DestructorThread.Destructor.access$302(this.mHead.next, this.mHead);
      AppMethodBeat.o(208043);
    }
    
    private static void drop(DestructorThread.Destructor paramDestructor)
    {
      AppMethodBeat.i(208048);
      DestructorThread.Destructor.access$302(paramDestructor.next, paramDestructor.previous);
      DestructorThread.Destructor.access$602(paramDestructor.previous, paramDestructor.next);
      AppMethodBeat.o(208048);
    }
    
    public void enqueue(DestructorThread.Destructor paramDestructor)
    {
      AppMethodBeat.i(208058);
      DestructorThread.Destructor.access$602(paramDestructor, this.mHead.next);
      DestructorThread.Destructor.access$602(this.mHead, paramDestructor);
      DestructorThread.Destructor.access$302(paramDestructor.next, paramDestructor);
      DestructorThread.Destructor.access$302(paramDestructor, this.mHead);
      AppMethodBeat.o(208058);
    }
  }
  
  static class DestructorStack
  {
    private final AtomicReference<DestructorThread.Destructor> mHead;
    
    private DestructorStack()
    {
      AppMethodBeat.i(208036);
      this.mHead = new AtomicReference();
      AppMethodBeat.o(208036);
    }
    
    public void push(DestructorThread.Destructor paramDestructor)
    {
      AppMethodBeat.i(208049);
      DestructorThread.Destructor localDestructor;
      do
      {
        localDestructor = (DestructorThread.Destructor)this.mHead.get();
        DestructorThread.Destructor.access$602(paramDestructor, localDestructor);
      } while (!this.mHead.compareAndSet(localDestructor, paramDestructor));
      AppMethodBeat.o(208049);
    }
    
    public void transferAllToList()
    {
      AppMethodBeat.i(208056);
      DestructorThread.Destructor localDestructor;
      for (Object localObject = (DestructorThread.Destructor)this.mHead.getAndSet(null); localObject != null; localObject = localDestructor)
      {
        localDestructor = ((DestructorThread.Destructor)localObject).next;
        DestructorThread.sDestructorList.enqueue((DestructorThread.Destructor)localObject);
      }
      AppMethodBeat.o(208056);
    }
  }
  
  static class Terminus
    extends DestructorThread.Destructor
  {
    private Terminus()
    {
      super();
    }
    
    protected void destruct()
    {
      AppMethodBeat.i(208064);
      IllegalStateException localIllegalStateException = new IllegalStateException("Cannot destroy Terminus Destructor.");
      AppMethodBeat.o(208064);
      throw localIllegalStateException;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.facebook.jni.DestructorThread
 * JD-Core Version:    0.7.0.1
 */