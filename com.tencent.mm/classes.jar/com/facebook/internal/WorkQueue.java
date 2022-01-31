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
    AppMethodBeat.i(72610);
    if (!WorkQueue.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(72610);
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
    AppMethodBeat.i(72601);
    AppMethodBeat.o(72601);
  }
  
  public WorkQueue(int paramInt, Executor paramExecutor)
  {
    AppMethodBeat.i(72602);
    this.workLock = new Object();
    this.runningJobs = null;
    this.runningCount = 0;
    this.maxConcurrent = paramInt;
    this.executor = paramExecutor;
    AppMethodBeat.o(72602);
  }
  
  private void execute(WorkNode paramWorkNode)
  {
    AppMethodBeat.i(72608);
    this.executor.execute(new WorkQueue.1(this, paramWorkNode));
    AppMethodBeat.o(72608);
  }
  
  private void finishItemAndStartNew(WorkNode paramWorkNode)
  {
    AppMethodBeat.i(72607);
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
      AppMethodBeat.o(72607);
      return;
    }
    finally
    {
      AppMethodBeat.o(72607);
    }
  }
  
  private void startItem()
  {
    AppMethodBeat.i(72606);
    finishItemAndStartNew(null);
    AppMethodBeat.o(72606);
  }
  
  public WorkQueue.WorkItem addActiveWorkItem(Runnable paramRunnable)
  {
    AppMethodBeat.i(72603);
    paramRunnable = addActiveWorkItem(paramRunnable, true);
    AppMethodBeat.o(72603);
    return paramRunnable;
  }
  
  public WorkQueue.WorkItem addActiveWorkItem(Runnable arg1, boolean paramBoolean)
  {
    AppMethodBeat.i(72604);
    WorkNode localWorkNode = new WorkNode(???);
    synchronized (this.workLock)
    {
      this.pendingJobs = localWorkNode.addToList(this.pendingJobs, paramBoolean);
      startItem();
      AppMethodBeat.o(72604);
      return localWorkNode;
    }
  }
  
  public void validate()
  {
    AppMethodBeat.i(72605);
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
        AppMethodBeat.o(72605);
        throw ((Throwable)localObject1);
      }
    }
    finally
    {
      AppMethodBeat.o(72605);
    }
    AppMethodBeat.o(72605);
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
      AppMethodBeat.i(72600);
      if (!WorkQueue.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        AppMethodBeat.o(72600);
        return;
      }
    }
    
    WorkNode(Runnable paramRunnable)
    {
      this.callback = paramRunnable;
    }
    
    WorkNode addToList(WorkNode paramWorkNode, boolean paramBoolean)
    {
      AppMethodBeat.i(72597);
      if ((!$assertionsDisabled) && (this.next != null))
      {
        paramWorkNode = new AssertionError();
        AppMethodBeat.o(72597);
        throw paramWorkNode;
      }
      if ((!$assertionsDisabled) && (this.prev != null))
      {
        paramWorkNode = new AssertionError();
        AppMethodBeat.o(72597);
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
        AppMethodBeat.o(72597);
        return this;
        this.next = paramWorkNode;
        this.prev = paramWorkNode.prev;
        WorkNode localWorkNode = this.next;
        this.prev.next = this;
        localWorkNode.prev = this;
      }
      AppMethodBeat.o(72597);
      return paramWorkNode;
    }
    
    public boolean cancel()
    {
      AppMethodBeat.i(72595);
      synchronized (WorkQueue.this.workLock)
      {
        if (!isRunning())
        {
          WorkQueue.access$202(WorkQueue.this, removeFromList(WorkQueue.this.pendingJobs));
          AppMethodBeat.o(72595);
          return true;
        }
        AppMethodBeat.o(72595);
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
      AppMethodBeat.i(72596);
      synchronized (WorkQueue.this.workLock)
      {
        if (!isRunning())
        {
          WorkQueue.access$202(WorkQueue.this, removeFromList(WorkQueue.this.pendingJobs));
          WorkQueue.access$202(WorkQueue.this, addToList(WorkQueue.this.pendingJobs, true));
        }
        AppMethodBeat.o(72596);
        return;
      }
    }
    
    WorkNode removeFromList(WorkNode paramWorkNode)
    {
      AppMethodBeat.i(72598);
      if ((!$assertionsDisabled) && (this.next == null))
      {
        paramWorkNode = new AssertionError();
        AppMethodBeat.o(72598);
        throw paramWorkNode;
      }
      if ((!$assertionsDisabled) && (this.prev == null))
      {
        paramWorkNode = new AssertionError();
        AppMethodBeat.o(72598);
        throw paramWorkNode;
      }
      WorkNode localWorkNode = paramWorkNode;
      if (paramWorkNode == this) {
        if (this.next != this) {
          break label117;
        }
      }
      label117:
      for (localWorkNode = null;; localWorkNode = this.next)
      {
        this.next.prev = this.prev;
        this.prev.next = this.next;
        this.prev = null;
        this.next = null;
        AppMethodBeat.o(72598);
        return localWorkNode;
      }
    }
    
    void setIsRunning(boolean paramBoolean)
    {
      this.isRunning = paramBoolean;
    }
    
    void verify(boolean paramBoolean)
    {
      AppMethodBeat.i(72599);
      AssertionError localAssertionError;
      if ((!$assertionsDisabled) && (this.prev.next != this))
      {
        localAssertionError = new AssertionError();
        AppMethodBeat.o(72599);
        throw localAssertionError;
      }
      if ((!$assertionsDisabled) && (this.next.prev != this))
      {
        localAssertionError = new AssertionError();
        AppMethodBeat.o(72599);
        throw localAssertionError;
      }
      if ((!$assertionsDisabled) && (isRunning() != paramBoolean))
      {
        localAssertionError = new AssertionError();
        AppMethodBeat.o(72599);
        throw localAssertionError;
      }
      AppMethodBeat.o(72599);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.facebook.internal.WorkQueue
 * JD-Core Version:    0.7.0.1
 */