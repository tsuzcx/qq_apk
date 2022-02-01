package com.tencent.mm.plugin.mmsight.model.a;

import android.annotation.TargetApi;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.ByteBuffer;

@Deprecated
@TargetApi(18)
public class p
  implements e
{
  protected boolean isStart;
  protected MediaMuxer mediaMuxer;
  protected int zwv;
  protected int zww;
  protected boolean zwx;
  protected boolean zwy;
  protected long zwz;
  
  public p(String paramString)
  {
    AppMethodBeat.i(241184);
    this.isStart = false;
    this.zwv = -1;
    this.zww = -1;
    this.zwx = false;
    this.zwy = false;
    this.zwz = 0L;
    try
    {
      this.mediaMuxer = new MediaMuxer(paramString, 0);
      this.mediaMuxer.setOrientationHint(0);
      Log.d("MicroMsg.MMSightSystemMediaMuxer", "create muxer, orientation: %s, filename: %s", new Object[] { Integer.valueOf(0), paramString });
      AppMethodBeat.o(241184);
      return;
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.MMSightSystemMediaMuxer", "new muxer error: %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(241184);
    }
  }
  
  public final boolean ejY()
  {
    return false;
  }
  
  public final long ekh()
  {
    return this.zwz;
  }
  
  public final void eki()
  {
    AppMethodBeat.i(241186);
    this.zwz = System.nanoTime();
    AppMethodBeat.o(241186);
  }
  
  public final boolean ekj()
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
        if ((this.mediaMuxer != null) && (this.zww == -1))
        {
          this.zww = this.mediaMuxer.addTrack(paramMediaFormat);
          Log.i("MicroMsg.MMSightSystemMediaMuxer", "addAACTrack, aacTrackIndex: %s", new Object[] { Integer.valueOf(this.zww) });
          if ((!this.isStart) && (this.zww != -1) && (this.zwv != -1))
          {
            Log.i("MicroMsg.MMSightSystemMediaMuxer", "start!");
            this.mediaMuxer.start();
            this.isStart = true;
          }
        }
        AppMethodBeat.o(89574);
      }
      catch (Exception paramMediaFormat)
      {
        for (;;)
        {
          Log.e("MicroMsg.MMSightSystemMediaMuxer", "addAACTrack error: %s", new Object[] { paramMediaFormat.getMessage() });
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
      AppMethodBeat.i(241187);
      try
      {
        Log.i("MicroMsg.MMSightSystemMediaMuxer", "finish");
        this.isStart = false;
        if (this.mediaMuxer != null)
        {
          this.mediaMuxer.stop();
          this.mediaMuxer.release();
        }
        AppMethodBeat.o(241187);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e("MicroMsg.MMSightSystemMediaMuxer", "stop error: %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(241187);
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
        if ((this.mediaMuxer != null) && (this.zwv == -1))
        {
          this.zwv = this.mediaMuxer.addTrack(paramMediaFormat);
          Log.i("MicroMsg.MMSightSystemMediaMuxer", "addX264Track, x264TrackIndex: %s", new Object[] { Integer.valueOf(this.zwv) });
          if ((!this.isStart) && (this.zwv != -1) && (this.zww != -1))
          {
            Log.i("MicroMsg.MMSightSystemMediaMuxer", "start!");
            this.mediaMuxer.start();
            this.isStart = true;
          }
        }
        AppMethodBeat.o(89573);
      }
      catch (Exception paramMediaFormat)
      {
        for (;;)
        {
          Log.e("MicroMsg.MMSightSystemMediaMuxer", "addX264Track error: %s", new Object[] { paramMediaFormat.getMessage() });
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
        if ((this.mediaMuxer != null) && (this.zww != -1) && (this.isStart) && (paramByteBuffer != null) && (paramBufferInfo != null))
        {
          long l1 = paramBufferInfo.presentationTimeUs;
          paramBufferInfo.presentationTimeUs = ((System.nanoTime() - this.zwz) / 1000L);
          long l2 = Util.currentTicks();
          this.mediaMuxer.writeSampleData(this.zww, paramByteBuffer, paramBufferInfo);
          Log.v("MicroMsg.MMSightSystemMediaMuxer", "writeAACSampleData size: %s used %dms oldpts %s fix pts: %s", new Object[] { Integer.valueOf(paramBufferInfo.size), Long.valueOf(Util.ticksToNow(l2)), Long.valueOf(l1), Long.valueOf(paramBufferInfo.presentationTimeUs) });
        }
        AppMethodBeat.o(89575);
      }
      catch (Exception paramByteBuffer)
      {
        for (;;)
        {
          Log.e("MicroMsg.MMSightSystemMediaMuxer", "writeAACSampleData error: %s", new Object[] { paramByteBuffer.getMessage() });
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
        AppMethodBeat.i(241185);
        try
        {
          if ((this.mediaMuxer != null) && (this.zwv != -1) && (this.isStart))
          {
            if (paramByteBuffer == null) {
              continue;
            }
            i = 1;
            break label194;
            if ((j & i) != 0)
            {
              long l1 = paramBufferInfo.presentationTimeUs;
              paramBufferInfo.presentationTimeUs = ((System.nanoTime() - this.zwz) / 1000L);
              paramBufferInfo.flags = 1;
              long l2 = Util.currentTicks();
              this.mediaMuxer.writeSampleData(this.zwv, paramByteBuffer, paramBufferInfo);
              Log.v("MicroMsg.MMSightSystemMediaMuxer", "writeAACSampleData size: %s used %dms oldpts %s fix pts: %s", new Object[] { Integer.valueOf(paramBufferInfo.size), Long.valueOf(Util.ticksToNow(l2)), Long.valueOf(l1), Long.valueOf(paramBufferInfo.presentationTimeUs) });
            }
          }
          AppMethodBeat.o(241185);
        }
        catch (Exception paramByteBuffer)
        {
          int i;
          Log.e("MicroMsg.MMSightSystemMediaMuxer", "writeX264SampleData error: %s", new Object[] { paramByteBuffer.getMessage() });
          AppMethodBeat.o(241185);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.p
 * JD-Core Version:    0.7.0.1
 */