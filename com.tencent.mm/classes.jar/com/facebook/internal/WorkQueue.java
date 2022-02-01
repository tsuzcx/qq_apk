package com.facebook.internal;

import com.facebook.FacebookSdk;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executor;

public class WorkQueue
{
  public static final int DEFAULT_MAX_CONCURRENT = 8;
  private final Executor executor;
  private final int maxConcurrent;
  private WorkNode pendingJobs;
  private int runningCount;
  private WorkNode runningJobs;
  private final Object workLock;
  
  static
  {
    AppMethodBeat.i(18046);
    if (!WorkQueue.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(18046);
      return;
    }
  }
  
  public WorkQueue()
  {
    this(8);
  }
  
  public WorkQueue(int paramInt)
  {
    this(paramInt, FacebookSdk.getExecutor());
    AppMethodBeat.i(18037);
    AppMethodBeat.o(18037);
  }
  
  public WorkQueue(int paramInt, Executor paramExecutor)
  {
    AppMethodBeat.i(18038);
    this.workLock = new Object();
    this.runningJobs = null;
    this.runningCount = 0;
    this.maxConcurrent = paramInt;
    this.executor = paramExecutor;
    AppMethodBeat.o(18038);
  }
  
  private void execute(final WorkNode paramWorkNode)
  {
    AppMethodBeat.i(18044);
    this.executor.execute(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(18030);
        try
        {
          paramWorkNode.getCallback().run();
          return;
        }
        finally
        {
          WorkQueue.access$000(WorkQueue.this, paramWorkNode);
          AppMethodBeat.o(18030);
        }
      }
    });
    AppMethodBeat.o(18044);
  }
  
  private void finishItemAndStartNew(WorkNode paramWorkNode)
  {
    AppMethodBeat.i(18043);
    WorkNode localWorkNode = null;
    Object localObject = this.workLock;
    if (paramWorkNode != null) {}
    try
    {
      this.runningJobs = paramWorkNode.removeFromList(this.runningJobs);
      this.runningCount -= 1;
      paramWorkNode = localWorkNode;
      if (this.runningCount < this.maxConcurrent)
      {
        localWorkNode = this.pendingJobs;
        paramWorkNode = localWorkNode;
        if (localWorkNode != null)
        {
          this.pendingJobs = localWorkNode.removeFromList(this.pendingJobs);
          this.runningJobs = localWorkNode.addToList(this.runningJobs, false);
          this.runningCount += 1;
          localWorkNode.setIsRunning(true);
          paramWorkNode = localWorkNode;
        }
      }
      if (paramWorkNode != null) {
        execute(paramWorkNode);
      }
      AppMethodBeat.o(18043);
      return;
    }
    finally
    {
      AppMethodBeat.o(18043);
    }
  }
  
  private void startItem()
  {
    AppMethodBeat.i(18042);
    finishItemAndStartNew(null);
    AppMethodBeat.o(18042);
  }
  
  public WorkQueue.WorkItem addActiveWorkItem(Runnable paramRunnable)
  {
    AppMethodBeat.i(18039);
    paramRunnable = addActiveWorkItem(paramRunnable, true);
    AppMethodBeat.o(18039);
    return paramRunnable;
  }
  
  public WorkQueue.WorkItem addActiveWorkItem(Runnable arg1, boolean paramBoolean)
  {
    AppMethodBeat.i(18040);
    WorkNode localWorkNode = new WorkNode(???);
    synchronized (this.workLock)
    {
      this.pendingJobs = localWorkNode.addToList(this.pendingJobs, paramBoolean);
      startItem();
      AppMethodBeat.o(18040);
      return localWorkNode;
    }
  }
  
  public void validate()
  {
    AppMethodBeat.i(18041);
    Object localObject3 = this.workLock;
    int j = 0;
    int i = 0;
    try
    {
      Object localObject1;
      if (this.runningJobs != null)
      {
        localObject1 = this.runningJobs;
        WorkNode localWorkNode;
        do
        {
          ((WorkNode)localObject1).verify(true);
          j = i + 1;
          localWorkNode = ((WorkNode)localObject1).getNext();
          i = j;
          localObject1 = localWorkNode;
        } while (localWorkNode != this.runningJobs);
      }
      if ((!$assertionsDisabled) && (this.runningCount != j))
      {
        localObject1 = new AssertionError();
        AppMethodBeat.o(18041);
        throw ((Throwable)localObject1);
      }
    }
    finally
    {
      AppMethodBeat.o(18041);
    }
    AppMethodBeat.o(18041);
  }
  
  class WorkNode
    implements WorkQueue.WorkItem
  {
    private final Runnable callback;
    private boolean isRunning;
    private WorkNode next;
    private WorkNode prev;
    
    static
    {
      AppMethodBeat.i(18036);
      if (!WorkQueue.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        AppMethodBeat.o(18036);
        return;
      }
    }
    
    WorkNode(Runnable paramRunnable)
    {
      this.callback = paramRunnable;
    }
    
    WorkNode addToList(WorkNode paramWorkNode, boolean paramBoolean)
    {
      AppMethodBeat.i(18033);
      if ((!$assertionsDisabled) && (this.next != null))
      {
        paramWorkNode = new AssertionError();
        AppMethodBeat.o(18033);
        throw paramWorkNode;
      }
      if ((!$assertionsDisabled) && (this.prev != null))
      {
        paramWorkNode = new AssertionError();
        AppMethodBeat.o(18033);
        throw paramWorkNode;
      }
      if (paramWorkNode == null)
      {
        this.prev = this;
        this.next = this;
        paramWorkNode = this;
      }
      while (paramBoolean)
      {
        AppMethodBeat.o(18033);
        return this;
        this.next = paramWorkNode;
        this.prev = paramWorkNode.prev;
        WorkNode localWorkNode = this.next;
        this.prev.next = this;
        localWorkNode.prev = this;
      }
      AppMethodBeat.o(18033);
      return paramWorkNode;
    }
    
    public boolean cancel()
    {
      AppMethodBeat.i(18031);
      synchronized (WorkQueue.this.workLock)
      {
        if (!isRunning())
        {
          WorkQueue.access$202(WorkQueue.this, removeFromList(WorkQueue.this.pendingJobs));
          AppMethodBeat.o(18031);
          return true;
        }
        AppMethodBeat.o(18031);
        return false;
      }
    }
    
    Runnable getCallback()
    {
      return this.callback;
    }
    
    WorkNode getNext()
    {
      return this.next;
    }
    
    public boolean isRunning()
    {
      return this.isRunning;
    }
    
    public void moveToFront()
    {
      AppMethodBeat.i(18032);
      synchronized (WorkQueue.this.workLock)
      {
        if (!isRunning())
        {
          WorkQueue.access$202(WorkQueue.this, removeFromList(WorkQueue.this.pendingJobs));
          WorkQueue.access$202(WorkQueue.this, addToList(WorkQueue.this.pendingJobs, true));
        }
        AppMethodBeat.o(18032);
        return;
      }
    }
    
    WorkNode removeFromList(WorkNode paramWorkNode)
    {
      AppMethodBeat.i(18034);
      if ((!$assertionsDisabled) && (this.next == null))
      {
        paramWorkNode = new AssertionError();
        AppMethodBeat.o(18034);
        throw paramWorkNode;
      }
      if ((!$assertionsDisabled) && (this.prev == null))
      {
        paramWorkNode = new AssertionError();
        AppMethodBeat.o(18034);
        throw paramWorkNode;
      }
      WorkNode localWorkNode = paramWorkNode;
      if (paramWorkNode == this) {
        if (this.next != this) {
          break label121;
        }
      }
      label121:
      for (localWorkNode = null;; localWorkNode = this.next)
      {
        this.next.prev = this.prev;
        this.prev.next = this.next;
        this.prev = null;
        this.next = null;
        AppMethodBeat.o(18034);
        return localWorkNode;
      }
    }
    
    void setIsRunning(boolean paramBoolean)
    {
      this.isRunning = paramBoolean;
    }
    
    void verify(boolean paramBoolean)
    {
      AppMethodBeat.i(18035);
      AssertionError localAssertionError;
      if ((!$assertionsDisabled) && (this.prev.next != this))
      {
        localAssertionError = new AssertionError();
        AppMethodBeat.o(18035);
        throw localAssertionError;
      }
      if ((!$assertionsDisabled) && (this.next.prev != this))
      {
        localAssertionError = new AssertionError();
        AppMethodBeat.o(18035);
        throw localAssertionError;
      }
      if ((!$assertionsDisabled) && (isRunning() != paramBoolean))
      {
        localAssertionError = new AssertionError();
        AppMethodBeat.o(18035);
        throw localAssertionError;
      }
      AppMethodBeat.o(18035);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.facebook.internal.WorkQueue
 * JD-Core Version:    0.7.0.1
 */