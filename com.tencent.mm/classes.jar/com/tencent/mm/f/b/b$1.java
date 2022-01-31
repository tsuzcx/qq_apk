package com.tencent.mm.f.b;

import android.media.MediaRecorder;
import android.media.MediaRecorder.OnErrorListener;
import com.tencent.mm.sdk.platformtools.y;

final class b$1
  implements MediaRecorder.OnErrorListener
{
  b$1(b paramb) {}
  
  public final void onError(MediaRecorder paramMediaRecorder, int paramInt1, int paramInt2)
  {
    if (b.a(this.bCl) != null) {
      b.a(this.bCl).onError();
    }
    try
    {
      b.b(this.bCl).release();
      b.a(this.bCl, b.b.bCq);
      return;
    }
    catch (Exception paramMediaRecorder)
    {
      for (;;)
      {
        y.e("MicroMsg.MMAudioRecorder", paramMediaRecorder.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.f.b.b.1
 * JD-Core Version:    0.7.0.1
 */