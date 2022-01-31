package com.facebook.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;

class WorkQueue$1
  implements Runnable
{
  WorkQueue$1(WorkQueue paramWorkQueue, WorkQueue.WorkNode paramWorkNode) {}
  
  public void run()
  {
    AppMethodBeat.i(72594);
    try
    {
      this.val$node.getCallback().run();
      return;
    }
    finally
    {
      WorkQueue.access$000(this.this$0, this.val$node);
      AppMethodBeat.o(72594);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.facebook.internal.WorkQueue.1
 * JD-Core Version:    0.7.0.1
 */