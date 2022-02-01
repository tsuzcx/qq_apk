package com.tencent.mm.plugin.mmsight.model.a;

import android.annotation.TargetApi;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.nio.ByteBuffer;

@Deprecated
@TargetApi(18)
public final class o
  implements e
{
  boolean isStart;
  MediaMuxer tEN;
  int tEO;
  private int tEP;
  long tEQ;
  
  public final boolean cQg()
  {
    return false;
  }
  
  public final void j(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    AppMethodBeat.i(89575);
    try
    {
      if ((this.tEN != null) && (this.tEP != -1) && (this.isStart) && (paramByteBuffer != null) && (paramBufferInfo != null))
      {
        long l1 = paramBufferInfo.presentationTimeUs;
        paramBufferInfo.presentationTimeUs = ((System.nanoTime() - this.tEQ) / 1000L);
        long l2 = bt.GC();
        this.tEN.writeSampleData(this.tEP, paramByteBuffer, paramBufferInfo);
        ad.v("MicroMsg.MMSightSystemMediaMuxer", "writeAACSampleData size: %s used %dms oldpts %s fix pts: %s", new Object[] { Integer.valueOf(paramBufferInfo.size), Long.valueOf(bt.aS(l2)), Long.valueOf(l1), Long.valueOf(paramBufferInfo.presentationTimeUs) });
      }
      AppMethodBeat.o(89575);
      return;
    }
    catch (Exception paramByteBuffer)
    {
      ad.e("MicroMsg.MMSightSystemMediaMuxer", "writeAACSampleData error: %s", new Object[] { paramByteBuffer.getMessage() });
      AppMethodBeat.o(89575);
    }
  }
  
  public final void k(MediaFormat paramMediaFormat)
  {
    AppMethodBeat.i(89573);
    try
    {
      if ((this.tEN != null) && (this.tEO == -1))
      {
        this.tEO = this.tEN.addTrack(paramMediaFormat);
        ad.i("MicroMsg.MMSightSystemMediaMuxer", "addX264Track, x264TrackIndex: %s", new Object[] { Integer.valueOf(this.tEO) });
        if ((!this.isStart) && (this.tEO != -1) && (this.tEP != -1))
        {
          ad.i("MicroMsg.MMSightSystemMediaMuxer", "start!");
          this.tEN.start();
          this.isStart = true;
        }
      }
      AppMethodBeat.o(89573);
      return;
    }
    catch (Exception paramMediaFormat)
    {
      ad.e("MicroMsg.MMSightSystemMediaMuxer", "addX264Track error: %s", new Object[] { paramMediaFormat.getMessage() });
      AppMethodBeat.o(89573);
    }
  }
  
  public final void l(MediaFormat paramMediaFormat)
  {
    AppMethodBeat.i(89574);
    try
    {
      if ((this.tEN != null) && (this.tEP == -1))
      {
        this.tEP = this.tEN.addTrack(paramMediaFormat);
        ad.i("MicroMsg.MMSightSystemMediaMuxer", "addAACTrack, aacTrackIndex: %s", new Object[] { Integer.valueOf(this.tEP) });
        if ((!this.isStart) && (this.tEP != -1) && (this.tEO != -1))
        {
          ad.i("MicroMsg.MMSightSystemMediaMuxer", "start!");
          this.tEN.start();
          this.isStart = true;
        }
      }
      AppMethodBeat.o(89574);
      return;
    }
    catch (Exception paramMediaFormat)
    {
      ad.e("MicroMsg.MMSightSystemMediaMuxer", "addAACTrack error: %s", new Object[] { paramMediaFormat.getMessage() });
      AppMethodBeat.o(89574);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.o
 * JD-Core Version:    0.7.0.1
 */