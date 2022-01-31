package com.tencent.mm.media.d;

import a.f.a.a;
import a.f.b.j;
import a.l;
import a.y;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import java.nio.ByteBuffer;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/media/encoder/MediaCodecTransEncoder;", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "videoCodecConfig", "Lcom/tencent/mm/media/config/VideoCodecConfig;", "highPriority", "", "init", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(Lcom/tencent/mm/media/config/VideoCodecConfig;ZLkotlin/jvm/functions/Function1;)V", "TAG", "", "TIMEOUT", "", "TIMEOUT$1", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "encodeHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "encodeThread", "Landroid/os/HandlerThread;", "encoder", "Landroid/media/MediaCodec;", "encoderLock", "Ljava/lang/Object;", "hasFinished", "isEnd", "startTime", "drainEncoder", "encodeFrame", "pts", "finishEncode", "finishWithEncodeLastFrame", "getRecordTimes", "release", "releaseEncoder", "Companion", "plugin-mediaeditor_release"})
public final class e
  extends b
{
  public static final e.a eUC;
  private final String TAG;
  private final MediaCodec.BufferInfo eRL;
  private HandlerThread eRb;
  private ak eRc;
  private boolean eRq;
  private boolean eUA;
  private final Object eUB;
  private MediaCodec eUg;
  private final long eUz;
  private long startTime;
  
  static
  {
    AppMethodBeat.i(12951);
    eUC = new e.a((byte)0);
    AppMethodBeat.o(12951);
  }
  
  public e(com.tencent.mm.media.b.c paramc, boolean paramBoolean, a.f.a.b<? super b, y> paramb)
  {
    super(paramc, paramb);
    AppMethodBeat.i(12950);
    this.TAG = "MicroMsg.MediaCodecTransEncoder";
    this.eUz = 10000L;
    this.eRL = new MediaCodec.BufferInfo();
    if (paramBoolean) {}
    for (int i = -2;; i = 0)
    {
      Object localObject = d.ey("MediaCodecTransEncoder_encodeThread", i);
      j.p(localObject, "ThreadPool.newFreeHandle….THREAD_PRIORITY_DEFAULT)");
      this.eRb = ((HandlerThread)localObject);
      this.eUB = new Object();
      localObject = MediaCodec.createByCodecName(paramc.name);
      j.p(localObject, "MediaCodec.createByCodec…me(videoCodecConfig.name)");
      this.eUg = ((MediaCodec)localObject);
      this.eUg.configure(paramc.Ux(), null, null, 1);
      paramc = this.eUg.createInputSurface();
      j.p(paramc, "encoder.createInputSurface()");
      e(paramc);
      this.eUg.start();
      this.eRb.start();
      this.eRc = new ak(this.eRb.getLooper());
      if (paramb == null) {
        break;
      }
      paramb.S(this);
      AppMethodBeat.o(12950);
      return;
    }
    AppMethodBeat.o(12950);
  }
  
  private final void UR()
  {
    AppMethodBeat.i(12948);
    try
    {
      i = this.eUg.dequeueOutputBuffer(this.eRL, this.eUz);
      ab.i(this.TAG, "drainEncoder  outputBufferIndex : ".concat(String.valueOf(i)));
      if (i != -1) {
        break label63;
      }
      ab.i(this.TAG, "outputBuffer try again later");
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i;
        label52:
        ab.e(this.TAG, "drainEncoder error");
        if (this.eSb)
        {
          Object localObject = com.tencent.mm.media.i.c.eZC;
          com.tencent.mm.media.i.c.Wy();
          continue;
          ab.d(this.TAG, "outputBuffer index: ".concat(String.valueOf(i)));
          localObject = this.eUg.getOutputBuffers();
          ab.d(this.TAG, "getOutputBuffers");
          localObject = localObject[i];
          if (localObject == null)
          {
            localObject = (Throwable)new RuntimeException("encoderOutputBuffer " + i + " was null");
            AppMethodBeat.o(12948);
            throw ((Throwable)localObject);
          }
          ab.d(this.TAG, "outputBuffers[outputBufferIndex]");
          if ((this.eRL.flags & 0x2) != 0) {
            ab.i(this.TAG, "codec config!");
          }
          ab.i(this.TAG, "bufferInfo.flags : " + (this.eRL.flags & 0x4));
          if (this.eRL.size != 0)
          {
            ((ByteBuffer)localObject).position(this.eRL.offset);
            ((ByteBuffer)localObject).limit(this.eRL.offset + this.eRL.size);
            f((ByteBuffer)localObject, this.eRL);
            this.eUg.releaseOutputBuffer(i, false);
          }
          else if ((this.eRL.flags & 0x4) != 0)
          {
            ab.i(this.TAG, "encode end of stream");
            US();
          }
          else
          {
            ab.d(this.TAG, "bufferInfo.size == 0");
          }
        }
      }
    }
    US();
    AppMethodBeat.o(12948);
    return;
    label63:
    if (i == -2) {
      ab.i(this.TAG, "encoder output format changed " + this.eUg.getOutputFormat());
    }
    for (;;)
    {
      ab.d(this.TAG, "dequeueOutputBuffer start");
      int j = this.eUg.dequeueOutputBuffer(this.eRL, this.eUz);
      i = j;
      if (j >= 0) {
        break;
      }
      break label52;
      if (i != -3)
      {
        if (i >= 0) {
          break label200;
        }
        ab.e(this.TAG, "outputBufferIndex " + i + ", ignore");
      }
    }
  }
  
  private final void US()
  {
    AppMethodBeat.i(12946);
    ab.d(this.TAG, "finishWithEncodeLastFrame  ,isEnd:" + this.eRq + "   ,hasFinished: " + this.eUA);
    synchronized (this.eUB)
    {
      if (this.eRq)
      {
        boolean bool = this.eUA;
        if (!bool) {}
      }
      else
      {
        AppMethodBeat.o(12946);
        return;
      }
      release();
      a locala = this.eUp;
      if (locala != null) {
        locala.invoke();
      }
      AppMethodBeat.o(12946);
      return;
    }
  }
  
  public final void UN()
  {
    AppMethodBeat.i(12945);
    ab.i(this.TAG, "finishEncode ");
    synchronized (this.eUB)
    {
      if ((!this.eRq) && (!this.eUA))
      {
        long l = this.startTime;
        if (0L != l) {}
      }
      else
      {
        AppMethodBeat.o(12945);
        return;
      }
      try
      {
        this.eRq = true;
        this.eUg.signalEndOfInputStream();
        UR();
        y localy = y.BMg;
        AppMethodBeat.o(12945);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ab.printErrStackTrace(this.TAG, (Throwable)localException, "finishEncode signalEndOfInputStream error:" + localException.getMessage(), new Object[0]);
        }
      }
    }
  }
  
  public final void UP()
  {
    AppMethodBeat.i(12944);
    if (0L == this.startTime) {
      this.startTime = bo.yB();
    }
    this.eRc.post((Runnable)new e.b(this));
    AppMethodBeat.o(12944);
  }
  
  public final long UQ()
  {
    AppMethodBeat.i(12949);
    long l1 = bo.yB();
    long l2 = this.startTime;
    AppMethodBeat.o(12949);
    return l1 - l2;
  }
  
  public final void release()
  {
    AppMethodBeat.i(12947);
    ab.i(this.TAG, "try to release");
    synchronized (this.eUB)
    {
      if (this.eUA)
      {
        ab.i(this.TAG, "release, already finished");
        AppMethodBeat.o(12947);
        return;
      }
      try
      {
        this.eUA = true;
        this.eUg.stop();
        this.eUg.release();
        this.eRc.removeCallbacksAndMessages(null);
        this.eRb.quitSafely();
        ab.i(this.TAG, "do release finishing");
        y localy = y.BMg;
        AppMethodBeat.o(12947);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ab.e(this.TAG, "release encoder error " + localException.getMessage());
        }
      }
    }
  }
  
  public final void releaseEncoder()
  {
    AppMethodBeat.i(156655);
    release();
    AppMethodBeat.o(156655);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.media.d.e
 * JD-Core Version:    0.7.0.1
 */