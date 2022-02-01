package com.tencent.mm.plugin.mmsight.model.a;

import android.annotation.TargetApi;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.nio.ByteBuffer;

@Deprecated
@TargetApi(18)
public final class o
  implements e
{
  boolean isStart;
  MediaMuxer uNi;
  int uNj;
  private int uNk;
  long uNl;
  
  public final boolean ddO()
  {
    return false;
  }
  
  public final void f(MediaFormat paramMediaFormat)
  {
    AppMethodBeat.i(89573);
    try
    {
      if ((this.uNi != null) && (this.uNj == -1))
      {
        this.uNj = this.uNi.addTrack(paramMediaFormat);
        ac.i("MicroMsg.MMSightSystemMediaMuxer", "addX264Track, x264TrackIndex: %s", new Object[] { Integer.valueOf(this.uNj) });
        if ((!this.isStart) && (this.uNj != -1) && (this.uNk != -1))
        {
          ac.i("MicroMsg.MMSightSystemMediaMuxer", "start!");
          this.uNi.start();
          this.isStart = true;
        }
      }
      AppMethodBeat.o(89573);
      return;
    }
    catch (Exception paramMediaFormat)
    {
      ac.e("MicroMsg.MMSightSystemMediaMuxer", "addX264Track error: %s", new Object[] { paramMediaFormat.getMessage() });
      AppMethodBeat.o(89573);
    }
  }
  
  public final void g(MediaFormat paramMediaFormat)
  {
    AppMethodBeat.i(89574);
    try
    {
      if ((this.uNi != null) && (this.uNk == -1))
      {
        this.uNk = this.uNi.addTrack(paramMediaFormat);
        ac.i("MicroMsg.MMSightSystemMediaMuxer", "addAACTrack, aacTrackIndex: %s", new Object[] { Integer.valueOf(this.uNk) });
        if ((!this.isStart) && (this.uNk != -1) && (this.uNj != -1))
        {
          ac.i("MicroMsg.MMSightSystemMediaMuxer", "start!");
          this.uNi.start();
          this.isStart = true;
        }
      }
      AppMethodBeat.o(89574);
      return;
    }
    catch (Exception paramMediaFormat)
    {
      ac.e("MicroMsg.MMSightSystemMediaMuxer", "addAACTrack error: %s", new Object[] { paramMediaFormat.getMessage() });
      AppMethodBeat.o(89574);
    }
  }
  
  public final void j(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    AppMethodBeat.i(89575);
    try
    {
      if ((this.uNi != null) && (this.uNk != -1) && (this.isStart) && (paramByteBuffer != null) && (paramBufferInfo != null))
      {
        long l1 = paramBufferInfo.presentationTimeUs;
        paramBufferInfo.presentationTimeUs = ((System.nanoTime() - this.uNl) / 1000L);
        long l2 = bs.Gn();
        this.uNi.writeSampleData(this.uNk, paramByteBuffer, paramBufferInfo);
        ac.v("MicroMsg.MMSightSystemMediaMuxer", "writeAACSampleData size: %s used %dms oldpts %s fix pts: %s", new Object[] { Integer.valueOf(paramBufferInfo.size), Long.valueOf(bs.aO(l2)), Long.valueOf(l1), Long.valueOf(paramBufferInfo.presentationTimeUs) });
      }
      AppMethodBeat.o(89575);
      return;
    }
    catch (Exception paramByteBuffer)
    {
      ac.e("MicroMsg.MMSightSystemMediaMuxer", "writeAACSampleData error: %s", new Object[] { paramByteBuffer.getMessage() });
      AppMethodBeat.o(89575);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.o
 * JD-Core Version:    0.7.0.1
 */