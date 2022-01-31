package com.google.android.exoplayer2.h;

import android.os.Handler;
import android.os.Message;

final class r$e
  extends Handler
  implements Runnable
{
  private final r.d aSb;
  
  public r$e(r.d paramd)
  {
    this.aSb = paramd;
  }
  
  public final void handleMessage(Message paramMessage)
  {
    this.aSb.nc();
  }
  
  public final void run()
  {
    sendEmptyMessage(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.h.r.e
 * JD-Core Version:    0.7.0.1
 */