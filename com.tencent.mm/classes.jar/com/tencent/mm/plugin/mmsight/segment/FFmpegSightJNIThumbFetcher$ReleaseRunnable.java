package com.tencent.mm.plugin.mmsight.segment;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.o;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;

class FFmpegSightJNIThumbFetcher$ReleaseRunnable
  implements Runnable
{
  int mBufId;
  Bitmap mReusedBitmap;
  
  private FFmpegSightJNIThumbFetcher$ReleaseRunnable(Bitmap paramBitmap, int paramInt)
  {
    this.mReusedBitmap = paramBitmap;
    this.mBufId = paramInt;
  }
  
  public void run()
  {
    AppMethodBeat.i(3628);
    if ((this.mReusedBitmap != null) && (!this.mReusedBitmap.isRecycled())) {
      o.fdX.t(this.mReusedBitmap);
    }
    SightVideoJNI.freeObj(this.mBufId);
    AppMethodBeat.o(3628);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.FFmpegSightJNIThumbFetcher.ReleaseRunnable
 * JD-Core Version:    0.7.0.1
 */