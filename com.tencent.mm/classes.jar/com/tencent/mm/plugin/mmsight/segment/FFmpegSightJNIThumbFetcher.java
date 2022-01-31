package com.tencent.mm.plugin.mmsight.segment;

import android.graphics.Bitmap;
import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.o;
import com.tencent.mm.memory.o.b;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ab;

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
    AppMethodBeat.i(3630);
    if (paramPoint == null)
    {
      paramPoint = new IllegalArgumentException("FFmpegThumbFetcherImpl : Point to calculateScaledLength can not be null.");
      AppMethodBeat.o(3630);
      throw paramPoint;
    }
    if ((paramInt2 <= 0) && (paramInt1 <= 0))
    {
      paramPoint.x = paramInt3;
      paramPoint.y = paramInt4;
      AppMethodBeat.o(3630);
      return paramPoint;
    }
    if (paramInt1 <= 0)
    {
      paramPoint.x = ((int)(paramInt2 / paramInt4 * paramInt3));
      paramPoint.y = paramInt2;
      AppMethodBeat.o(3630);
      return paramPoint;
    }
    if (paramInt2 <= 0)
    {
      paramPoint.x = paramInt1;
      paramPoint.y = ((int)(paramInt1 / paramInt3 * paramInt4));
      AppMethodBeat.o(3630);
      return paramPoint;
    }
    if (paramInt2 / paramInt1 > paramInt4 / paramInt3) {
      paramPoint.x = ((int)(paramInt3 * paramInt2 / paramInt4));
    }
    for (paramPoint.y = paramInt2;; paramPoint.y = ((int)(paramInt4 * paramInt1 / paramInt3)))
    {
      AppMethodBeat.o(3630);
      return paramPoint;
      paramPoint.x = paramInt1;
    }
  }
  
  public int getDurationMs()
  {
    AppMethodBeat.i(3633);
    ab.i("MicroMsg.FFmpegSightJNIThumbFetcher", "getDurationMs() returned: " + this.mDurationMs);
    int i = this.mDurationMs;
    AppMethodBeat.o(3633);
    return i;
  }
  
  public Bitmap getFrameAtTime(long paramLong)
  {
    long l = 0L;
    AppMethodBeat.i(3632);
    ab.i("MicroMsg.FFmpegSightJNIThumbFetcher", "getFrameAtTime() called with: timeMs = [%d], mBufId = [%d]", new Object[] { Long.valueOf(paramLong), Integer.valueOf(this.mBufId) });
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
        ab.i("MicroMsg.FFmpegSightJNIThumbFetcher", "getFrameAtTime() seekStream return %d", new Object[] { Integer.valueOf(SightVideoJNI.seekStreamWithFlag((float)paramLong / 1000.0F, 1, this.mBufId)) });
        if ((this.mReusedBitmap == null) || (this.mReusedBitmap.isRecycled()) || (this.mReusedBitmap.getWidth() != this.mScaledWidth) || (this.mReusedBitmap.getHeight() != this.mScaledHeight))
        {
          if ((this.mReusedBitmap != null) && (!this.mReusedBitmap.isRecycled())) {
            o.fdX.t(this.mReusedBitmap);
          }
          this.mReusedBitmap = o.fdX.a(new o.b(this.mScaledWidth, this.mScaledHeight));
        }
        ab.i("MicroMsg.FFmpegSightJNIThumbFetcher", "getFrameAtTime() dr return %d", new Object[] { Integer.valueOf(SightVideoJNI.drawScaledFrame(this.mBufId, this.mReusedBitmap, this.mScaledWidth, this.mScaledHeight)) });
        Bitmap localBitmap = this.mReusedBitmap;
        this.mReusedBitmap = null;
        AppMethodBeat.o(3632);
        return localBitmap;
      }
    }
  }
  
  public int getScaledHeight()
  {
    AppMethodBeat.i(3635);
    ab.i("MicroMsg.FFmpegSightJNIThumbFetcher", "getScaledHeight() returned: " + this.mScaledHeight);
    int i = this.mScaledHeight;
    AppMethodBeat.o(3635);
    return i;
  }
  
  public int getScaledWidth()
  {
    AppMethodBeat.i(3634);
    ab.i("MicroMsg.FFmpegSightJNIThumbFetcher", "getScaledWidth() returned: " + this.mScaledWidth);
    int i = this.mScaledWidth;
    AppMethodBeat.o(3634);
    return i;
  }
  
  public void init(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(3629);
    ab.i("MicroMsg.FFmpegSightJNIThumbFetcher", "init() called with: path = [" + paramString + "], segment_interval = [" + paramInt1 + "], width = [" + paramInt2 + "], height = [" + paramInt3 + "]");
    this.mBufId = SightVideoJNI.openFile(paramString, 1, 16, false);
    if (this.mBufId < 0)
    {
      paramString = new p("open file error.");
      AppMethodBeat.o(3629);
      throw paramString;
    }
    paramInt1 = SightVideoJNI.getVideoWidth(this.mBufId);
    int i = SightVideoJNI.getVideoHeight(this.mBufId);
    this.mDurationMs = ((int)(SightVideoJNI.getVideoDuration(this.mBufId) * 1000.0D));
    paramString = calculateScaledLength(paramInt2, paramInt3, paramInt1, i, new Point());
    this.mScaledWidth = paramString.x;
    this.mScaledHeight = paramString.y;
    ab.i("MicroMsg.FFmpegSightJNIThumbFetcher", "FFmpegSightJNIThumbFetcher.init. scaled size is (%d, %d); raw size is (%d, %d)", new Object[] { Integer.valueOf(this.mScaledWidth), Integer.valueOf(this.mScaledHeight), Integer.valueOf(paramInt1), Integer.valueOf(i) });
    AppMethodBeat.o(3629);
  }
  
  public void release()
  {
    AppMethodBeat.i(3636);
    ab.i("MicroMsg.FFmpegSightJNIThumbFetcher", "release() called");
    com.tencent.mm.sdk.g.d.post(new FFmpegSightJNIThumbFetcher.ReleaseRunnable(this.mReusedBitmap, this.mBufId, null), "release");
    AppMethodBeat.o(3636);
  }
  
  public void reuseBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(3631);
    ab.i("MicroMsg.FFmpegSightJNIThumbFetcher", "reuseBitmap() called with: bitmap = [" + paramBitmap + "]");
    if (paramBitmap == null)
    {
      AppMethodBeat.o(3631);
      return;
    }
    this.mReusedBitmap = paramBitmap;
    AppMethodBeat.o(3631);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.FFmpegSightJNIThumbFetcher
 * JD-Core Version:    0.7.0.1
 */