package com.tencent.mm.media.e;

import android.media.MediaCodec.BufferInfo;
import android.os.HandlerThread;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.aa;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/encoder/MediaCodecTransEncoder;", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "videoCodecConfig", "Lcom/tencent/mm/media/config/VideoCodecConfig;", "init", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(Lcom/tencent/mm/media/config/VideoCodecConfig;Lkotlin/jvm/functions/Function1;)V", "TAG", "", "TIMEOUT", "", "TIMEOUT$1", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "encodeHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "encodeThread", "Landroid/os/HandlerThread;", "encoder", "Lcom/tencent/mm/compatible/deviceinfo/MediaCodecProxy;", "receivedEOS", "", "startTime", "drainEncoder", "encodeFrame", "pts", "finalize", "finishEncode", "getRecordTimes", "releaseEncoder", "Companion", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends b
{
  public static final e.a nzN;
  private final String TAG;
  private final MediaCodec.BufferInfo bufferInfo;
  private HandlerThread nxt;
  private MMHandler nxu;
  private final long nzO;
  private boolean nzP;
  private aa nzs;
  private long startTime;
  
  static
  {
    AppMethodBeat.i(93646);
    nzN = new e.a((byte)0);
    AppMethodBeat.o(93646);
  }
  
  public e(com.tencent.mm.media.b.d paramd, kotlin.g.a.b<? super b, ah> paramb)
  {
    super(paramd, paramb);
    AppMethodBeat.i(236969);
    this.TAG = "MicroMsg.MediaCodecTransEncoder";
    this.nzO = 50000L;
    this.bufferInfo = new MediaCodec.BufferInfo();
    Object localObject = com.tencent.threadpool.c.d.jx("MediaCodecTransEncoder_encodeThread", 0);
    s.s(localObject, "createMediaCodecThread(\"….THREAD_PRIORITY_DEFAULT)");
    this.nxt = ((HandlerThread)localObject);
    localObject = com.tencent.mm.media.util.f.nFE;
    com.tencent.mm.media.util.f.bry();
    Log.i(this.TAG, s.X("create mp4encoder ", Integer.valueOf(hashCode())));
    localObject = aa.Dx(paramd.name);
    s.s(localObject, "createByCodecName(videoCodecConfig.name)");
    this.nzs = ((aa)localObject);
    this.nzs.a(paramd.boH(), null, 1);
    if ((MMApplicationContext.isMainProcess()) && (s.p(h.baE().ban().get(at.a.acOH, Integer.valueOf(-1)), Integer.valueOf(1))))
    {
      Toast.makeText(MMApplicationContext.getContext(), (CharSequence)"remuxer 抛出异常", 0).show();
      paramd = new IllegalStateException("leex test error");
      AppMethodBeat.o(236969);
      throw paramd;
    }
    paramd = this.nzs.createInputSurface();
    s.s(paramd, "encoder.createInputSurface()");
    l(paramd);
    this.nzs.start();
    this.nxt.start();
    this.nxu = new MMHandler(this.nxt.getLooper());
    Log.i(this.TAG, s.X("create mp4encoder finish ", Integer.valueOf(hashCode())));
    paramb.invoke(this);
    AppMethodBeat.o(236969);
  }
  
  private static final void a(e parame)
  {
    AppMethodBeat.i(236982);
    s.u(parame, "this$0");
    long l = Util.currentTicks();
    synchronized (parame.bpg())
    {
      if ((parame.bpe()) || (parame.bpc()))
      {
        Log.i(parame.TAG, "encodeFrame() stop encodeFrame " + parame.hashCode() + ", isRelease:" + parame.bpe() + ", isFinishEncode:" + parame.bpc());
        AppMethodBeat.o(236982);
        return;
      }
      ah localah = ah.aiuX;
      parame.bpk();
      Log.d(parame.TAG, " drainEncoder cost " + Util.ticksToNow(l) + "  " + parame.hashCode());
      AppMethodBeat.o(236982);
      return;
    }
  }
  
  private static final void b(e parame)
  {
    AppMethodBeat.i(236988);
    s.u(parame, "this$0");
    synchronized (parame.bpg())
    {
      if ((parame.bpc()) || (parame.bpe()) || (0L == parame.startTime))
      {
        Log.i(parame.TAG, "finishEncode() already finish " + parame.hashCode() + ", isFinishEncode:" + parame.bpc() + ", isRelease:" + parame.bpe() + ", startTime:" + parame.startTime);
        AppMethodBeat.o(236988);
        return;
      }
      ah localah = ah.aiuX;
    }
  }
  
  private final void bpk()
  {
    AppMethodBeat.i(236978);
    for (;;)
    {
      int k;
      int j;
      int m;
      int i;
      Object localObject;
      try
      {
        k = this.nzs.dequeueOutputBuffer(this.bufferInfo, this.nzO);
        Log.i(this.TAG, s.X("drainEncoder  outputBufferIndex : ", Integer.valueOf(k)));
        j = 0;
        if (k == -1)
        {
          Log.i(this.TAG, "outputBuffer try again later");
          m = this.nzs.dequeueOutputBuffer(this.bufferInfo, this.nzO);
          Log.i(this.TAG, "dequeueOutputBuffer start  outputBufferIndex:" + m + "  timeout:" + j + "  " + hashCode());
          if (m >= 0) {
            break label591;
          }
          i = j + 1;
          break label593;
          if ((bpc()) && (i >= 3))
          {
            Log.i(this.TAG, "isFinishEncode && timeout >= 3");
            bpa();
            AppMethodBeat.o(236978);
          }
        }
        else
        {
          if (k != -2) {
            break label269;
          }
          Log.i(this.TAG, s.X("encoder output format changed ", this.nzs.getOutputFormat()));
          continue;
        }
        if (k == -3) {
          continue;
        }
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace(this.TAG, (Throwable)localException, "drainEncoder error " + hashCode() + ", \n " + localException.getMessage(), new Object[0]);
        if (this.nyT)
        {
          localObject = com.tencent.mm.media.util.f.nFE;
          com.tencent.mm.media.util.f.brZ();
        }
        AppMethodBeat.o(236978);
        return;
      }
      label269:
      if (k < 0)
      {
        Log.e(this.TAG, "outputBufferIndex " + k + ", ignore");
      }
      else
      {
        Log.d(this.TAG, s.X("outputBuffer index: ", Integer.valueOf(k)));
        localObject = this.nzs.aPE();
        Log.d(this.TAG, "getOutputBuffers");
        localObject = localObject[k];
        if (localObject == null)
        {
          localObject = new RuntimeException("encoderOutputBuffer " + k + " was null");
          AppMethodBeat.o(236978);
          throw ((Throwable)localObject);
        }
        Log.d(this.TAG, "outputBuffers[" + k + ']');
        if ((this.bufferInfo.flags & 0x2) != 0) {
          Log.i(this.TAG, "codec config!");
        }
        Log.i(this.TAG, s.X("bufferInfo.flags : ", Integer.valueOf(this.bufferInfo.flags & 0x4)));
        if (this.bufferInfo.size != 0)
        {
          ((ByteBuffer)localObject).position(this.bufferInfo.offset);
          ((ByteBuffer)localObject).limit(this.bufferInfo.offset + this.bufferInfo.size);
          f((ByteBuffer)localObject, this.bufferInfo);
          this.nzs.releaseOutputBuffer(k, true);
        }
        else if ((this.bufferInfo.flags & 0x4) != 0)
        {
          this.nzP = true;
          Log.i(this.TAG, "encode end of stream");
          bpa();
          i = j;
        }
        else
        {
          Log.d(this.TAG, "bufferInfo.size == 0");
          continue;
          label591:
          i = 0;
          label593:
          j = i;
          k = m;
          if (m < 0)
          {
            j = i;
            k = m;
            if (i < 3) {}
          }
        }
      }
    }
  }
  
  private static final void c(e parame)
  {
    AppMethodBeat.i(236995);
    s.u(parame, "this$0");
    long l;
    synchronized (parame.bpg())
    {
      if (parame.bpe())
      {
        Log.i(parame.TAG, s.X("releaseEncoder(), already finished ", Integer.valueOf(parame.hashCode())));
        AppMethodBeat.o(236995);
        return;
      }
      ah localah = ah.aiuX;
    }
  }
  
  public final void boZ()
  {
    AppMethodBeat.i(93641);
    if (this.nzP)
    {
      Log.e(this.TAG, "has received eos");
      AppMethodBeat.o(93641);
      return;
    }
    this.nxu.removeCallbacksAndMessages(null);
    this.nxu.post(new e..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(93641);
  }
  
  public final void bpa()
  {
    AppMethodBeat.i(93642);
    Log.i(this.TAG, s.X("try to release ", Integer.valueOf(hashCode())));
    this.nxu.post(new e..ExternalSyntheticLambda1(this));
    AppMethodBeat.o(93642);
  }
  
  public final void bpi()
  {
    AppMethodBeat.i(93640);
    if (0L == this.startTime) {
      this.startTime = Util.currentTicks();
    }
    this.nxu.post(new e..ExternalSyntheticLambda2(this));
    AppMethodBeat.o(93640);
  }
  
  public final long bpj()
  {
    AppMethodBeat.i(93644);
    long l1 = Util.currentTicks();
    long l2 = this.startTime;
    AppMethodBeat.o(93644);
    return l1 - l2;
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(93643);
    Log.i(this.TAG, "finalize");
    if (!bpe()) {
      this.nzs.release();
    }
    AppMethodBeat.o(93643);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.e.e
 * JD-Core Version:    0.7.0.1
 */