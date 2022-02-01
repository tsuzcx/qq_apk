package com.tencent.mm.plugin.mmsight.segment;

import android.graphics.Bitmap;
import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.o.b;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.thread.ThreadPool;

public class FFmpegSightJNIThumbFetcher
  implements d
{
  private static final String TAG = "MicroMsg.FFmpegSightJNIThumbFetcher";
  private int mBufId;
  private int mDurationMs;
  private Bitmap mReusedBitmap;
  private int mScaledHeight;
  private int mScaledWidth;
  
  private Point calculateScaledLength(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Point paramPoint)
  {
    AppMethodBeat.i(107631);
    if (paramPoint == null)
    {
      paramPoint = new IllegalArgumentException("FFmpegThumbFetcherImpl : Point to calculateScaledLength can not be null.");
      AppMethodBeat.o(107631);
      throw paramPoint;
    }
    if ((paramInt2 <= 0) && (paramInt1 <= 0))
    {
      paramPoint.x = paramInt3;
      paramPoint.y = paramInt4;
      AppMethodBeat.o(107631);
      return paramPoint;
    }
    if (paramInt1 <= 0)
    {
      paramPoint.x = ((int)(paramInt2 / paramInt4 * paramInt3));
      paramPoint.y = paramInt2;
      AppMethodBeat.o(107631);
      return paramPoint;
    }
    if (paramInt2 <= 0)
    {
      paramPoint.x = paramInt1;
      paramPoint.y = ((int)(paramInt1 / paramInt3 * paramInt4));
      AppMethodBeat.o(107631);
      return paramPoint;
    }
    if (paramInt2 / paramInt1 > paramInt4 / paramInt3) {
      paramPoint.x = ((int)(paramInt3 * paramInt2 / paramInt4));
    }
    for (paramPoint.y = paramInt2;; paramPoint.y = ((int)(paramInt4 * paramInt1 / paramInt3)))
    {
      AppMethodBeat.o(107631);
      return paramPoint;
      paramPoint.x = paramInt1;
    }
  }
  
  public int getDurationMs()
  {
    AppMethodBeat.i(107634);
    Log.i("MicroMsg.FFmpegSightJNIThumbFetcher", "getDurationMs() returned: " + this.mDurationMs);
    int i = this.mDurationMs;
    AppMethodBeat.o(107634);
    return i;
  }
  
  public Bitmap getFrameAtTime(long paramLong)
  {
    long l = 0L;
    AppMethodBeat.i(107633);
    Log.i("MicroMsg.FFmpegSightJNIThumbFetcher", "getFrameAtTime() called with: timeMs = [%d], mBufId = [%d]", new Object[] { Long.valueOf(paramLong), Integer.valueOf(this.mBufId) });
    if (paramLong > this.mDurationMs) {
      paramLong = this.mDurationMs;
    }
    for (;;)
    {
      if (paramLong < 0L) {
        paramLong = l;
      }
      for (;;)
      {
        Log.i("MicroMsg.FFmpegSightJNIThumbFetcher", "getFrameAtTime() seekStream return %d", new Object[] { Integer.valueOf(SightVideoJNI.seekStreamWithFlag((float)paramLong / 1000.0F, 1, this.mBufId)) });
        if ((this.mReusedBitmap == null) || (this.mReusedBitmap.isRecycled()) || (this.mReusedBitmap.getWidth() != this.mScaledWidth) || (this.mReusedBitmap.getHeight() != this.mScaledHeight))
        {
          if ((this.mReusedBitmap != null) && (!this.mReusedBitmap.isRecycled())) {
            com.tencent.mm.memory.o.itM.f(this.mReusedBitmap);
          }
          this.mReusedBitmap = com.tencent.mm.memory.o.itM.a(new o.b(this.mScaledWidth, this.mScaledHeight));
        }
        Log.i("MicroMsg.FFmpegSightJNIThumbFetcher", "getFrameAtTime() dr return %d", new Object[] { Integer.valueOf(SightVideoJNI.drawScaledFrame(this.mBufId, this.mReusedBitmap, this.mScaledWidth, this.mScaledHeight)) });
        Bitmap localBitmap = this.mReusedBitmap;
        this.mReusedBitmap = null;
        AppMethodBeat.o(107633);
        return localBitmap;
      }
    }
  }
  
  public int getScaledHeight()
  {
    AppMethodBeat.i(107636);
    Log.i("MicroMsg.FFmpegSightJNIThumbFetcher", "getScaledHeight() returned: " + this.mScaledHeight);
    int i = this.mScaledHeight;
    AppMethodBeat.o(107636);
    return i;
  }
  
  public int getScaledWidth()
  {
    AppMethodBeat.i(107635);
    Log.i("MicroMsg.FFmpegSightJNIThumbFetcher", "getScaledWidth() returned: " + this.mScaledWidth);
    int i = this.mScaledWidth;
    AppMethodBeat.o(107635);
    return i;
  }
  
  public void init(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(107630);
    Log.i("MicroMsg.FFmpegSightJNIThumbFetcher", "init() called with: path = [" + paramString + "], segment_interval = [" + paramInt1 + "], width = [" + paramInt2 + "], height = [" + paramInt3 + "]");
    this.mBufId = SightVideoJNI.openFileVFS(paramString, 1, 16, false);
    if (this.mBufId < 0)
    {
      paramString = new o("open file error.");
      AppMethodBeat.o(107630);
      throw paramString;
    }
    paramInt1 = SightVideoJNI.getVideoWidth(this.mBufId);
    int i = SightVideoJNI.getVideoHeight(this.mBufId);
    this.mDurationMs = ((int)(SightVideoJNI.getVideoDuration(this.mBufId) * 1000.0D));
    paramString = calculateScaledLength(paramInt2, paramInt3, paramInt1, i, new Point());
    this.mScaledWidth = paramString.x;
    this.mScaledHeight = paramString.y;
    Log.i("MicroMsg.FFmpegSightJNIThumbFetcher", "FFmpegSightJNIThumbFetcher.init. scaled size is (%d, %d); raw size is (%d, %d)", new Object[] { Integer.valueOf(this.mScaledWidth), Integer.valueOf(this.mScaledHeight), Integer.valueOf(paramInt1), Integer.valueOf(i) });
    AppMethodBeat.o(107630);
  }
  
  public void release()
  {
    AppMethodBeat.i(107637);
    Log.i("MicroMsg.FFmpegSightJNIThumbFetcher", "release() called");
    ThreadPool.post(new ReleaseRunnable(this.mReusedBitmap, this.mBufId, null), "release");
    AppMethodBeat.o(107637);
  }
  
  public void reuseBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(107632);
    Log.i("MicroMsg.FFmpegSightJNIThumbFetcher", "reuseBitmap() called with: bitmap = [" + paramBitmap + "]");
    if (paramBitmap == null)
    {
      AppMethodBeat.o(107632);
      return;
    }
    this.mReusedBitmap = paramBitmap;
    AppMethodBeat.o(107632);
  }
  
  static class ReleaseRunnable
    implements Runnable
  {
    int mBufId;
    Bitmap mReusedBitmap;
    
    private ReleaseRunnable(Bitmap paramBitmap, int paramInt)
    {
      this.mReusedBitmap = paramBitmap;
      this.mBufId = paramInt;
    }
    
    public void run()
    {
      AppMethodBeat.i(107629);
      if ((this.mReusedBitmap != null) && (!this.mReusedBitmap.isRecycled())) {
        com.tencent.mm.memory.o.itM.f(this.mReusedBitmap);
      }
      SightVideoJNI.freeObj(this.mBufId);
      AppMethodBeat.o(107629);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.FFmpegSightJNIThumbFetcher
 * JD-Core Version:    0.7.0.1
 */