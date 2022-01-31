package com.tencent.mm.plugin.mmsight.model.a;

import android.annotation.TargetApi;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.nio.ByteBuffer;

@Deprecated
@TargetApi(18)
public final class o
  implements e
{
  boolean bSr;
  private MediaMuxer mkm;
  private int mkn;
  private int mko;
  long mkp;
  
  public final boolean bjx()
  {
    return false;
  }
  
  public final void c(MediaFormat paramMediaFormat)
  {
    try
    {
      if ((this.mkm != null) && (this.mkn == -1))
      {
        this.mkn = this.mkm.addTrack(paramMediaFormat);
        y.i("MicroMsg.MMSightSystemMediaMuxer", "addX264Track, x264TrackIndex: %s", new Object[] { Integer.valueOf(this.mkn) });
        if ((!this.bSr) && (this.mkn != -1) && (this.mko != -1))
        {
          y.i("MicroMsg.MMSightSystemMediaMuxer", "start!");
          this.mkm.start();
          this.bSr = true;
        }
      }
      return;
    }
    catch (Exception paramMediaFormat)
    {
      for (;;)
      {
        y.e("MicroMsg.MMSightSystemMediaMuxer", "addX264Track error: %s", new Object[] { paramMediaFormat.getMessage() });
      }
    }
    finally {}
  }
  
  public final void d(MediaFormat paramMediaFormat)
  {
    try
    {
      if ((this.mkm != null) && (this.mko == -1))
      {
        this.mko = this.mkm.addTrack(paramMediaFormat);
        y.i("MicroMsg.MMSightSystemMediaMuxer", "addAACTrack, aacTrackIndex: %s", new Object[] { Integer.valueOf(this.mko) });
        if ((!this.bSr) && (this.mko != -1) && (this.mkn != -1))
        {
          y.i("MicroMsg.MMSightSystemMediaMuxer", "start!");
          this.mkm.start();
          this.bSr = true;
        }
      }
      return;
    }
    catch (Exception paramMediaFormat)
    {
      for (;;)
      {
        y.e("MicroMsg.MMSightSystemMediaMuxer", "addAACTrack error: %s", new Object[] { paramMediaFormat.getMessage() });
      }
    }
    finally {}
  }
  
  public final void f(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    try
    {
      if ((this.mkm != null) && (this.mko != -1) && (this.bSr) && (paramByteBuffer != null) && (paramBufferInfo != null))
      {
        long l1 = paramBufferInfo.presentationTimeUs;
        paramBufferInfo.presentationTimeUs = ((System.nanoTime() - this.mkp) / 1000L);
        long l2 = bk.UZ();
        this.mkm.writeSampleData(this.mko, paramByteBuffer, paramBufferInfo);
        y.v("MicroMsg.MMSightSystemMediaMuxer", "writeAACSampleData size: %s used %dms oldpts %s fix pts: %s", new Object[] { Integer.valueOf(paramBufferInfo.size), Long.valueOf(bk.cp(l2)), Long.valueOf(l1), Long.valueOf(paramBufferInfo.presentationTimeUs) });
      }
    }
    catch (Exception paramByteBuffer)
    {
      for (;;)
      {
        y.e("MicroMsg.MMSightSystemMediaMuxer", "writeAACSampleData error: %s", new Object[] { paramByteBuffer.getMessage() });
      }
    }
    finally {}
  }
  
  public final void g(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    int j = 1;
    for (;;)
    {
      try
      {
        if ((this.mkm == null) || (this.mkn == -1) || (!this.bSr)) {
          continue;
        }
        if (paramByteBuffer == null) {
          continue;
        }
        i = 1;
      }
      catch (Exception paramByteBuffer)
      {
        int i;
        long l1;
        long l2;
        y.e("MicroMsg.MMSightSystemMediaMuxer", "writeX264SampleData error: %s", new Object[] { paramByteBuffer.getMessage() });
        continue;
      }
      finally {}
      if ((j & i) != 0)
      {
        l1 = paramBufferInfo.presentationTimeUs;
        paramBufferInfo.presentationTimeUs = ((System.nanoTime() - this.mkp) / 1000L);
        paramBufferInfo.flags = 1;
        l2 = bk.UZ();
        this.mkm.writeSampleData(this.mkn, paramByteBuffer, paramBufferInfo);
        y.v("MicroMsg.MMSightSystemMediaMuxer", "writeAACSampleData size: %s used %dms oldpts %s fix pts: %s", new Object[] { Integer.valueOf(paramBufferInfo.size), Long.valueOf(bk.cp(l2)), Long.valueOf(l1), Long.valueOf(paramBufferInfo.presentationTimeUs) });
      }
      return;
      i = 0;
      break label179;
      j = 0;
      continue;
      label179:
      if (paramBufferInfo == null) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.o
 * JD-Core Version:    0.7.0.1
 */