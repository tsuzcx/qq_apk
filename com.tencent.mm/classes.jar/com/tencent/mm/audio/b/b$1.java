package com.tencent.mm.audio.b;

import android.media.MediaRecorder;
import android.media.MediaRecorder.OnErrorListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class b$1
  implements MediaRecorder.OnErrorListener
{
  b$1(b paramb) {}
  
  public final void onError(MediaRecorder paramMediaRecorder, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(116473);
    if (b.a(this.ciZ) != null) {
      b.a(this.ciZ).onError();
    }
    try
    {
      b.b(this.ciZ).release();
      b.a(this.ciZ, b.b.cje);
      AppMethodBeat.o(116473);
      return;
    }
    catch (Exception paramMediaRecorder)
    {
      for (;;)
      {
        ab.e("MicroMsg.MMAudioRecorder", paramMediaRecorder.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.audio.b.b.1
 * JD-Core Version:    0.7.0.1
 */