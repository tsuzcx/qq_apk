package com.google.android.exoplayer2.i;

import java.util.concurrent.ThreadFactory;

final class t$1
  implements ThreadFactory
{
  t$1(String paramString) {}
  
  public final Thread newThread(Runnable paramRunnable)
  {
    return new Thread(paramRunnable, this.aSX);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.i.t.1
 * JD-Core Version:    0.7.0.1
 */