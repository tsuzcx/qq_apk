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
public class p
  implements e
{
  protected boolean isStart;
  protected MediaMuxer vQp;
  protected int vQq;
  protected int vQr;
  protected boolean vQs;
  protected boolean vQt;
  protected long vQu;
  
  public p(String paramString)
  {
    AppMethodBeat.i(213680);
    this.isStart = false;
    this.vQq = -1;
    this.vQr = -1;
    this.vQs = false;
    this.vQt = false;
    this.vQu = 0L;
    try
    {
      this.vQp = new MediaMuxer(paramString, 0);
      this.vQp.setOrientationHint(0);
      ad.d("MicroMsg.MMSightSystemMediaMuxer", "create muxer, orientation: %s, filename: %s", new Object[] { Integer.valueOf(0), paramString });
      AppMethodBeat.o(213680);
      return;
    }
    catch (Exception paramString)
    {
      ad.e("MicroMsg.MMSightSystemMediaMuxer", "new muxer error: %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(213680);
    }
  }
  
  public final boolean dnk()
  {
    return false;
  }
  
  public final long dnt()
  {
    return this.vQu;
  }
  
  public final void dnu()
  {
    AppMethodBeat.i(213682);
    this.vQu = System.nanoTime();
    AppMethodBeat.o(213682);
  }
  
  public final boolean dnv()
  {
    return this.isStart;
  }
  
  public void f(MediaFormat paramMediaFormat)
  {
    try
    {
      AppMethodBeat.i(89574);
      try
      {
        if ((this.vQp != null) && (this.vQr == -1))
        {
          this.vQr = this.vQp.addTrack(paramMediaFormat);
          ad.i("MicroMsg.MMSightSystemMediaMuxer", "addAACTrack, aacTrackIndex: %s", new Object[] { Integer.valueOf(this.vQr) });
          if ((!this.isStart) && (this.vQr != -1) && (this.vQq != -1))
          {
            ad.i("MicroMsg.MMSightSystemMediaMuxer", "start!");
            this.vQp.start();
            this.isStart = true;
          }
        }
        AppMethodBeat.o(89574);
      }
      catch (Exception paramMediaFormat)
      {
        for (;;)
        {
          ad.e("MicroMsg.MMSightSystemMediaMuxer", "addAACTrack error: %s", new Object[] { paramMediaFormat.getMessage() });
          AppMethodBeat.o(89574);
        }
      }
      return;
    }
    finally {}
  }
  
  public final void finish()
  {
    try
    {
      AppMethodBeat.i(213683);
      try
      {
        ad.i("MicroMsg.MMSightSystemMediaMuxer", "finish");
        this.isStart = false;
        if (this.vQp != null)
        {
          this.vQp.stop();
          this.vQp.release();
        }
        AppMethodBeat.o(213683);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ad.e("MicroMsg.MMSightSystemMediaMuxer", "stop error: %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(213683);
        }
      }
      return;
    }
    finally {}
  }
  
  public final void g(MediaFormat paramMediaFormat)
  {
    try
    {
      AppMethodBeat.i(89573);
      try
      {
        if ((this.vQp != null) && (this.vQq == -1))
        {
          this.vQq = this.vQp.addTrack(paramMediaFormat);
          ad.i("MicroMsg.MMSightSystemMediaMuxer", "addX264Track, x264TrackIndex: %s", new Object[] { Integer.valueOf(this.vQq) });
          if ((!this.isStart) && (this.vQq != -1) && (this.vQr != -1))
          {
            ad.i("MicroMsg.MMSightSystemMediaMuxer", "start!");
            this.vQp.start();
            this.isStart = true;
          }
        }
        AppMethodBeat.o(89573);
      }
      catch (Exception paramMediaFormat)
      {
        for (;;)
        {
          ad.e("MicroMsg.MMSightSystemMediaMuxer", "addX264Track error: %s", new Object[] { paramMediaFormat.getMessage() });
          AppMethodBeat.o(89573);
        }
      }
      return;
    }
    finally {}
  }
  
  public final void j(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    try
    {
      AppMethodBeat.i(89575);
      try
      {
        if ((this.vQp != null) && (this.vQr != -1) && (this.isStart) && (paramByteBuffer != null) && (paramBufferInfo != null))
        {
          long l1 = paramBufferInfo.presentationTimeUs;
          paramBufferInfo.presentationTimeUs = ((System.nanoTime() - this.vQu) / 1000L);
          long l2 = bt.HI();
          this.vQp.writeSampleData(this.vQr, paramByteBuffer, paramBufferInfo);
          ad.v("MicroMsg.MMSightSystemMediaMuxer", "writeAACSampleData size: %s used %dms oldpts %s fix pts: %s", new Object[] { Integer.valueOf(paramBufferInfo.size), Long.valueOf(bt.aO(l2)), Long.valueOf(l1), Long.valueOf(paramBufferInfo.presentationTimeUs) });
        }
        AppMethodBeat.o(89575);
      }
      catch (Exception paramByteBuffer)
      {
        for (;;)
        {
          ad.e("MicroMsg.MMSightSystemMediaMuxer", "writeAACSampleData error: %s", new Object[] { paramByteBuffer.getMessage() });
          AppMethodBeat.o(89575);
        }
      }
      return;
    }
    finally {}
  }
  
  public final void k(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    int j = 1;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(213681);
        try
        {
          if ((this.vQp != null) && (this.vQq != -1) && (this.isStart))
          {
            if (paramByteBuffer == null) {
              continue;
            }
            i = 1;
            break label194;
            if ((j & i) != 0)
            {
              long l1 = paramBufferInfo.presentationTimeUs;
              paramBufferInfo.presentationTimeUs = ((System.nanoTime() - this.vQu) / 1000L);
              paramBufferInfo.flags = 1;
              long l2 = bt.HI();
              this.vQp.writeSampleData(this.vQq, paramByteBuffer, paramBufferInfo);
              ad.v("MicroMsg.MMSightSystemMediaMuxer", "writeAACSampleData size: %s used %dms oldpts %s fix pts: %s", new Object[] { Integer.valueOf(paramBufferInfo.size), Long.valueOf(bt.aO(l2)), Long.valueOf(l1), Long.valueOf(paramBufferInfo.presentationTimeUs) });
            }
          }
          AppMethodBeat.o(213681);
        }
        catch (Exception paramByteBuffer)
        {
          int i;
          ad.e("MicroMsg.MMSightSystemMediaMuxer", "writeX264SampleData error: %s", new Object[] { paramByteBuffer.getMessage() });
          AppMethodBeat.o(213681);
          continue;
        }
        return;
      }
      finally {}
      i = 0;
      break label194;
      j = 0;
      continue;
      label194:
      if (paramBufferInfo == null) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.p
 * JD-Core Version:    0.7.0.1
 */