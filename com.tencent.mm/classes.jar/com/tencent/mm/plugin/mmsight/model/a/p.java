package com.tencent.mm.plugin.mmsight.model.a;

import android.annotation.TargetApi;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.nio.ByteBuffer;

@Deprecated
@TargetApi(18)
public class p
  implements e
{
  protected boolean isStart;
  protected MediaMuxer wct;
  protected int wcu;
  protected int wcv;
  protected boolean wcw;
  protected boolean wcx;
  protected long wcy;
  
  public p(String paramString)
  {
    AppMethodBeat.i(210682);
    this.isStart = false;
    this.wcu = -1;
    this.wcv = -1;
    this.wcw = false;
    this.wcx = false;
    this.wcy = 0L;
    try
    {
      this.wct = new MediaMuxer(paramString, 0);
      this.wct.setOrientationHint(0);
      ae.d("MicroMsg.MMSightSystemMediaMuxer", "create muxer, orientation: %s, filename: %s", new Object[] { Integer.valueOf(0), paramString });
      AppMethodBeat.o(210682);
      return;
    }
    catch (Exception paramString)
    {
      ae.e("MicroMsg.MMSightSystemMediaMuxer", "new muxer error: %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(210682);
    }
  }
  
  public final boolean dqi()
  {
    return false;
  }
  
  public final long dqr()
  {
    return this.wcy;
  }
  
  public final void dqs()
  {
    AppMethodBeat.i(210684);
    this.wcy = System.nanoTime();
    AppMethodBeat.o(210684);
  }
  
  public final boolean dqt()
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
        if ((this.wct != null) && (this.wcv == -1))
        {
          this.wcv = this.wct.addTrack(paramMediaFormat);
          ae.i("MicroMsg.MMSightSystemMediaMuxer", "addAACTrack, aacTrackIndex: %s", new Object[] { Integer.valueOf(this.wcv) });
          if ((!this.isStart) && (this.wcv != -1) && (this.wcu != -1))
          {
            ae.i("MicroMsg.MMSightSystemMediaMuxer", "start!");
            this.wct.start();
            this.isStart = true;
          }
        }
        AppMethodBeat.o(89574);
      }
      catch (Exception paramMediaFormat)
      {
        for (;;)
        {
          ae.e("MicroMsg.MMSightSystemMediaMuxer", "addAACTrack error: %s", new Object[] { paramMediaFormat.getMessage() });
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
      AppMethodBeat.i(210685);
      try
      {
        ae.i("MicroMsg.MMSightSystemMediaMuxer", "finish");
        this.isStart = false;
        if (this.wct != null)
        {
          this.wct.stop();
          this.wct.release();
        }
        AppMethodBeat.o(210685);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ae.e("MicroMsg.MMSightSystemMediaMuxer", "stop error: %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(210685);
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
        if ((this.wct != null) && (this.wcu == -1))
        {
          this.wcu = this.wct.addTrack(paramMediaFormat);
          ae.i("MicroMsg.MMSightSystemMediaMuxer", "addX264Track, x264TrackIndex: %s", new Object[] { Integer.valueOf(this.wcu) });
          if ((!this.isStart) && (this.wcu != -1) && (this.wcv != -1))
          {
            ae.i("MicroMsg.MMSightSystemMediaMuxer", "start!");
            this.wct.start();
            this.isStart = true;
          }
        }
        AppMethodBeat.o(89573);
      }
      catch (Exception paramMediaFormat)
      {
        for (;;)
        {
          ae.e("MicroMsg.MMSightSystemMediaMuxer", "addX264Track error: %s", new Object[] { paramMediaFormat.getMessage() });
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
        if ((this.wct != null) && (this.wcv != -1) && (this.isStart) && (paramByteBuffer != null) && (paramBufferInfo != null))
        {
          long l1 = paramBufferInfo.presentationTimeUs;
          paramBufferInfo.presentationTimeUs = ((System.nanoTime() - this.wcy) / 1000L);
          long l2 = bu.HQ();
          this.wct.writeSampleData(this.wcv, paramByteBuffer, paramBufferInfo);
          ae.v("MicroMsg.MMSightSystemMediaMuxer", "writeAACSampleData size: %s used %dms oldpts %s fix pts: %s", new Object[] { Integer.valueOf(paramBufferInfo.size), Long.valueOf(bu.aO(l2)), Long.valueOf(l1), Long.valueOf(paramBufferInfo.presentationTimeUs) });
        }
        AppMethodBeat.o(89575);
      }
      catch (Exception paramByteBuffer)
      {
        for (;;)
        {
          ae.e("MicroMsg.MMSightSystemMediaMuxer", "writeAACSampleData error: %s", new Object[] { paramByteBuffer.getMessage() });
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
        AppMethodBeat.i(210683);
        try
        {
          if ((this.wct != null) && (this.wcu != -1) && (this.isStart))
          {
            if (paramByteBuffer == null) {
              continue;
            }
            i = 1;
            break label194;
            if ((j & i) != 0)
            {
              long l1 = paramBufferInfo.presentationTimeUs;
              paramBufferInfo.presentationTimeUs = ((System.nanoTime() - this.wcy) / 1000L);
              paramBufferInfo.flags = 1;
              long l2 = bu.HQ();
              this.wct.writeSampleData(this.wcu, paramByteBuffer, paramBufferInfo);
              ae.v("MicroMsg.MMSightSystemMediaMuxer", "writeAACSampleData size: %s used %dms oldpts %s fix pts: %s", new Object[] { Integer.valueOf(paramBufferInfo.size), Long.valueOf(bu.aO(l2)), Long.valueOf(l1), Long.valueOf(paramBufferInfo.presentationTimeUs) });
            }
          }
          AppMethodBeat.o(210683);
        }
        catch (Exception paramByteBuffer)
        {
          int i;
          ae.e("MicroMsg.MMSightSystemMediaMuxer", "writeX264SampleData error: %s", new Object[] { paramByteBuffer.getMessage() });
          AppMethodBeat.o(210683);
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