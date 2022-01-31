package com.tencent.mm.plugin.mmsight.segment;

import android.graphics.Bitmap;
import android.graphics.Point;
import com.tencent.mm.memory.o;
import com.tencent.mm.memory.o.b;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.y;

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
    if (paramPoint == null) {
      throw new IllegalArgumentException("FFmpegThumbFetcherImpl : Point to calculateScaledLength can not be null.");
    }
    if ((paramInt2 <= 0) && (paramInt1 <= 0))
    {
      paramPoint.x = paramInt3;
      paramPoint.y = paramInt4;
      return paramPoint;
    }
    if (paramInt1 <= 0)
    {
      paramPoint.x = ((int)(paramInt2 / paramInt4 * paramInt3));
      paramPoint.y = paramInt2;
      return paramPoint;
    }
    if (paramInt2 <= 0)
    {
      paramPoint.x = paramInt1;
      paramPoint.y = ((int)(paramInt1 / paramInt3 * paramInt4));
      return paramPoint;
    }
    if (paramInt2 / paramInt1 > paramInt4 / paramInt3)
    {
      paramPoint.x = ((int)(paramInt3 * paramInt2 / paramInt4));
      paramPoint.y = paramInt2;
      return paramPoint;
    }
    paramPoint.x = paramInt1;
    paramPoint.y = ((int)(paramInt4 * paramInt1 / paramInt3));
    return paramPoint;
  }
  
  public int getDurationMs()
  {
    y.i("MicroMsg.FFmpegSightJNIThumbFetcher", "getDurationMs() returned: " + this.mDurationMs);
    return this.mDurationMs;
  }
  
  public Bitmap getFrameAtTime(long paramLong)
  {
    long l = 0L;
    y.i("MicroMsg.FFmpegSightJNIThumbFetcher", "getFrameAtTime() called with: timeMs = [%d], mBufId = [%d]", new Object[] { Long.valueOf(paramLong), Integer.valueOf(this.mBufId) });
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
        y.i("MicroMsg.FFmpegSightJNIThumbFetcher", "getFrameAtTime() seekStream return %d", new Object[] { Integer.valueOf(SightVideoJNI.seekStreamWithFlag((float)paramLong / 1000.0F, 1, this.mBufId)) });
        if ((this.mReusedBitmap == null) || (this.mReusedBitmap.isRecycled()) || (this.mReusedBitmap.getWidth() != this.mScaledWidth) || (this.mReusedBitmap.getHeight() != this.mScaledHeight))
        {
          if ((this.mReusedBitmap != null) && (!this.mReusedBitmap.isRecycled())) {
            o.dPr.m(this.mReusedBitmap);
          }
          this.mReusedBitmap = o.dPr.a(new o.b(this.mScaledWidth, this.mScaledHeight));
        }
        y.i("MicroMsg.FFmpegSightJNIThumbFetcher", "getFrameAtTime() dr return %d", new Object[] { Integer.valueOf(SightVideoJNI.drawScaledFrame(this.mBufId, this.mReusedBitmap, this.mScaledWidth, this.mScaledHeight)) });
        Bitmap localBitmap = this.mReusedBitmap;
        this.mReusedBitmap = null;
        return localBitmap;
      }
    }
  }
  
  public int getScaledHeight()
  {
    y.i("MicroMsg.FFmpegSightJNIThumbFetcher", "getScaledHeight() returned: " + this.mScaledHeight);
    return this.mScaledHeight;
  }
  
  public int getScaledWidth()
  {
    y.i("MicroMsg.FFmpegSightJNIThumbFetcher", "getScaledWidth() returned: " + this.mScaledWidth);
    return this.mScaledWidth;
  }
  
  public void init(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    y.i("MicroMsg.FFmpegSightJNIThumbFetcher", "init() called with: path = [" + paramString + "], segment_interval = [" + paramInt1 + "], width = [" + paramInt2 + "], height = [" + paramInt3 + "]");
    this.mBufId = SightVideoJNI.openFile(paramString, 1, 16, false);
    if (this.mBufId < 0) {
      throw new p("open file error.");
    }
    paramInt1 = SightVideoJNI.getVideoWidth(this.mBufId);
    int i = SightVideoJNI.getVideoHeight(this.mBufId);
    this.mDurationMs = ((int)(SightVideoJNI.getVideoDuration(this.mBufId) * 1000.0D));
    paramString = calculateScaledLength(paramInt2, paramInt3, paramInt1, i, new Point());
    this.mScaledWidth = paramString.x;
    this.mScaledHeight = paramString.y;
    y.i("MicroMsg.FFmpegSightJNIThumbFetcher", "FFmpegSightJNIThumbFetcher.init. scaled size is (%d, %d); raw size is (%d, %d)", new Object[] { Integer.valueOf(this.mScaledWidth), Integer.valueOf(this.mScaledHeight), Integer.valueOf(paramInt1), Integer.valueOf(i) });
  }
  
  public void release()
  {
    y.i("MicroMsg.FFmpegSightJNIThumbFetcher", "release() called");
    e.post(new ReleaseRunnable(this.mReusedBitmap, this.mBufId, null), "release");
  }
  
  public void reuseBitmap(Bitmap paramBitmap)
  {
    y.i("MicroMsg.FFmpegSightJNIThumbFetcher", "reuseBitmap() called with: bitmap = [" + paramBitmap + "]");
    if (paramBitmap == null) {
      return;
    }
    this.mReusedBitmap = paramBitmap;
  }
  
  private static class ReleaseRunnable
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
      if ((this.mReusedBitmap != null) && (!this.mReusedBitmap.isRecycled())) {
        o.dPr.m(this.mReusedBitmap);
      }
      SightVideoJNI.freeObj(this.mBufId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.FFmpegSightJNIThumbFetcher
 * JD-Core Version:    0.7.0.1
 */