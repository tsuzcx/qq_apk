package com.tencent.liteav.videoencoder;

import android.media.MediaCodec;

class a$5
  implements Runnable
{
  a$5(a parama) {}
  
  public void run()
  {
    if (a.c(this.a) == null) {
      return;
    }
    try
    {
      a.c(this.a).signalEndOfInputStream();
      label21:
      while (a.c(this.a, 10) >= 0) {}
      a.a(this.a);
      return;
    }
    catch (Exception localException)
    {
      break label21;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.liteav.videoencoder.a.5
 * JD-Core Version:    0.7.0.1
 */