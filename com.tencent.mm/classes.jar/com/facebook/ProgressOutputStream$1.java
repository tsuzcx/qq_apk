package com.facebook;

import com.tencent.matrix.trace.core.AppMethodBeat;

class ProgressOutputStream$1
  implements Runnable
{
  ProgressOutputStream$1(ProgressOutputStream paramProgressOutputStream, GraphRequestBatch.OnProgressCallback paramOnProgressCallback) {}
  
  public void run()
  {
    AppMethodBeat.i(71838);
    this.val$progressCallback.onBatchProgress(ProgressOutputStream.access$000(this.this$0), ProgressOutputStream.access$100(this.this$0), ProgressOutputStream.access$200(this.this$0));
    AppMethodBeat.o(71838);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.facebook.ProgressOutputStream.1
 * JD-Core Version:    0.7.0.1
 */