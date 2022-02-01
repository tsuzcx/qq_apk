package com.tencent.mm.plugin.mmsight.model.a;

import android.annotation.TargetApi;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.z;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar.a;
import java.nio.ByteBuffer;

@TargetApi(16)
public class s
  implements f
{
  private ByteBuffer[] bfQ;
  private int bitrate;
  private ByteBuffer[] btv;
  private MediaCodec.BufferInfo bufferInfo;
  int colorFormat;
  boolean dyL;
  int frameCount;
  private int frameRate;
  private long hlh;
  private int idB;
  protected z ieT;
  private final Object iff;
  boolean isQ;
  private boolean isStart;
  private int jtj;
  private int jtk;
  private boolean jtl;
  private int kxW;
  private int kxX;
  protected MediaFormat mediaFormat;
  private long startTime;
  int targetHeight;
  int targetWidth;
  private p zvN;
  private boolean zvP;
  private boolean zvR;
  int zwB;
  int zwC;
  int zwD;
  int zwE;
  a zwF;
  f.a zwG;
  private a.a zwH;
  private long zwc;
  
  public s(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, boolean paramBoolean)
  {
    AppMethodBeat.i(89588);
    this.startTime = 0L;
    this.hlh = 0L;
    this.jtj = -1;
    this.jtk = -1;
    this.bitrate = 0;
    this.isStart = false;
    this.dyL = false;
    this.jtl = false;
    this.zwB = -1;
    this.zwC = -1;
    this.zwD = -1;
    this.zwE = -1;
    this.isQ = false;
    this.iff = new Object();
    this.zvP = false;
    this.zvR = true;
    this.zwc = 0L;
    this.zwH = new a.a()
    {
      public final void output(byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(89586);
        long l = Util.currentTicks();
        boolean bool2 = s.this.zwF.ejV();
        s locals = s.this;
        if ((bool2) && (s.this.dyL)) {}
        for (boolean bool1 = true;; bool1 = false)
        {
          locals.d(paramAnonymousArrayOfByte, bool1);
          com.tencent.mm.bk.b.jtf.k(paramAnonymousArrayOfByte);
          Log.i("MicroMsg.MMSightYUVMediaCodecRecorder", "markStop: %s isEnd %s costTime %d", new Object[] { Boolean.valueOf(s.this.dyL), Boolean.valueOf(bool2), Long.valueOf(Util.ticksToNow(l)) });
          if ((bool2) && (s.this.dyL)) {
            s.this.ekk();
          }
          AppMethodBeat.o(89586);
          return;
        }
      }
    };
    this.zwF = new a(this.zwH);
    this.kxW = paramInt1;
    this.kxX = paramInt2;
    Log.i("MicroMsg.MMSightYUVMediaCodecRecorder", "create MMSightYUVMediaCodecRecorder, init targetWidth: %d, targetHeight: %d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    Log.i("MicroMsg.MMSightYUVMediaCodecRecorder", "create MMSightYUVMediaCodecRecorder, after align 16, targetWidth: %d, targetHeight: %d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    this.targetWidth = paramInt3;
    this.targetHeight = paramInt4;
    this.frameRate = paramInt7;
    this.idB = paramInt6;
    this.zvN = null;
    this.bufferInfo = new MediaCodec.BufferInfo();
    this.bitrate = paramInt5;
    this.isQ = paramBoolean;
    this.zvR = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rYK, true);
    Log.i("MicroMsg.MMSightYUVMediaCodecRecorder", "create BigSightMediaCodecYUVRecorder, frameWidth: %s, frameHeight: %s, targetWidth: %s, targetHeight: %s, bitrate: %s, needRotateEachFrame: %s, muxer: %s", new Object[] { Integer.valueOf(this.kxW), Integer.valueOf(this.kxX), Integer.valueOf(this.targetWidth), Integer.valueOf(this.targetHeight), Integer.valueOf(paramInt5), Boolean.valueOf(paramBoolean), null });
    AppMethodBeat.o(89588);
  }
  
  private void aMi()
  {
    AppMethodBeat.i(89599);
    if (this.zvR)
    {
      ekl();
      AppMethodBeat.o(89599);
      return;
    }
    synchronized (this.iff)
    {
      if ((this.zvP) || (0L == this.startTime))
      {
        AppMethodBeat.o(89599);
        return;
      }
      this.zvP = true;
      ekl();
      AppMethodBeat.o(89599);
      return;
    }
  }
  
  private void aMn()
  {
    AppMethodBeat.i(89593);
    this.jtk = this.ieT.dequeueOutputBuffer(this.bufferInfo, 100L);
    Log.v("MicroMsg.MMSightYUVMediaCodecRecorder", "outputBufferIndex-->" + this.jtk);
    do
    {
      if (this.jtk != -1) {
        break label149;
      }
      Log.d("MicroMsg.MMSightYUVMediaCodecRecorder", "no output from encoder available, break encoderEndStream %s", new Object[] { Boolean.valueOf(this.jtl) });
      if (!this.jtl) {
        break;
      }
      this.jtk = this.ieT.dequeueOutputBuffer(this.bufferInfo, 100L);
      if (this.jtk <= 0) {
        Log.v("MicroMsg.MMSightYUVMediaCodecRecorder", "get outputBufferIndex %d", new Object[] { Integer.valueOf(this.jtk) });
      }
    } while ((this.jtk >= 0) || (this.jtl));
    label149:
    do
    {
      AppMethodBeat.o(89593);
      return;
      if (this.jtk == -3)
      {
        this.bfQ = this.ieT.getOutputBuffers();
        Log.d("MicroMsg.MMSightYUVMediaCodecRecorder", "encoder output buffers changed");
        break;
      }
      if (this.jtk == -2)
      {
        localObject = this.ieT.getOutputFormat();
        Log.d("MicroMsg.MMSightYUVMediaCodecRecorder", "encoder output format changed: ".concat(String.valueOf(localObject)));
        if (this.zvN == null) {
          break;
        }
        this.zvN.g((MediaFormat)localObject);
        break;
      }
      if (this.jtk < 0)
      {
        Log.w("MicroMsg.MMSightYUVMediaCodecRecorder", "unexpected result from encoder.dequeueOutputBuffer: " + this.jtk);
        break;
      }
      Log.v("MicroMsg.MMSightYUVMediaCodecRecorder", "perform encoding");
      Object localObject = this.bfQ[this.jtk];
      if (localObject == null)
      {
        localObject = new RuntimeException("encoderOutputBuffer " + this.jtk + " was null");
        AppMethodBeat.o(89593);
        throw ((Throwable)localObject);
      }
      this.frameCount += 1;
      if ((this.bufferInfo.flags & 0x2) != 0) {
        Log.v("MicroMsg.MMSightYUVMediaCodecRecorder", "ignoring BUFFER_FLAG_CODEC_CONFIG, size: %s, %s", new Object[] { Integer.valueOf(this.bufferInfo.size), Boolean.FALSE });
      }
      if (this.bufferInfo.size != 0)
      {
        if ((this.zvN != null) && (!this.zvN.ekj()))
        {
          MediaFormat localMediaFormat = this.ieT.getOutputFormat();
          this.zvN.g(localMediaFormat);
        }
        ((ByteBuffer)localObject).position(this.bufferInfo.offset);
        ((ByteBuffer)localObject).limit(this.bufferInfo.offset + this.bufferInfo.size);
        i((ByteBuffer)localObject, this.bufferInfo);
      }
      this.ieT.releaseOutputBuffer(this.jtk, false);
      if ((this.bufferInfo.flags & 0x4) == 0) {
        break;
      }
      if (!this.dyL)
      {
        Log.e("MicroMsg.MMSightYUVMediaCodecRecorder", "reached end of stream unexpectedly");
        AppMethodBeat.o(89593);
        return;
      }
      Log.w("MicroMsg.MMSightYUVMediaCodecRecorder", "do stop encoder");
      aMi();
    } while (this.zwG == null);
    this.zwG.ejZ();
    this.zwG = null;
    AppMethodBeat.o(89593);
  }
  
  private int bhL()
  {
    AppMethodBeat.i(89591);
    long l1 = Util.currentTicks();
    int k = MediaCodecList.getCodecCount();
    int i = 0;
    Object localObject2;
    if (i < k)
    {
      ??? = MediaCodecList.getCodecInfoAt(i);
      if (((MediaCodecInfo)???).isEncoder())
      {
        localObject2 = ((MediaCodecInfo)???).getSupportedTypes();
        j = 0;
        label45:
        if (j < localObject2.length) {
          if (!localObject2[j].equalsIgnoreCase("video/avc")) {}
        }
      }
    }
    for (;;)
    {
      if (??? != null) {
        break label109;
      }
      Log.e("MicroMsg.MMSightYUVMediaCodecRecorder", "Unable to find an appropriate codec for video/avc");
      l.aNJ();
      AppMethodBeat.o(89591);
      return -1;
      j += 1;
      break label45;
      i += 1;
      break;
      ??? = null;
    }
    label109:
    Log.i("MicroMsg.MMSightYUVMediaCodecRecorder", "found codec: %s, used %sms", new Object[] { ((MediaCodecInfo)???).getName(), Long.valueOf(Util.ticksToNow(l1)) });
    l1 = Util.currentTicks();
    i = -1;
    if (CaptureMMProxy.getInstance() != null) {
      i = CaptureMMProxy.getInstance().getInt(ar.a.NZq, -1);
    }
    Log.i("MicroMsg.MMSightYUVMediaCodecRecorder", "saveColorFormat: %s", new Object[] { Integer.valueOf(i) });
    if (i > 0)
    {
      this.colorFormat = i;
      l1 = Util.ticksToNow(l1);
      if ((this.colorFormat > 0) && (l1 > 200L) && (CaptureMMProxy.getInstance() != null)) {
        CaptureMMProxy.getInstance().set(ar.a.NZq, Integer.valueOf(this.colorFormat));
      }
      Log.i("MicroMsg.MMSightYUVMediaCodecRecorder", "found colorFormat: %s, used %sms", new Object[] { Integer.valueOf(this.colorFormat), Long.valueOf(l1) });
      l1 = Util.currentTicks();
      Log.i("MicroMsg.MMSightYUVMediaCodecRecorder", "initRotate: %s", new Object[] { Integer.valueOf(this.zwB) });
      if (!this.isQ) {
        break label813;
      }
      if ((this.zwB != 180) && (this.zwB != 0)) {
        break label797;
      }
      i = this.targetWidth;
      label324:
      if ((this.zwB != 180) && (this.zwB != 0)) {
        break label805;
      }
      j = this.targetHeight;
      label346:
      this.mediaFormat = MediaFormat.createVideoFormat("video/avc", i, j);
      label358:
      Log.i("MicroMsg.MMSightYUVMediaCodecRecorder", "createVideoFormat used %sms", new Object[] { Long.valueOf(Util.ticksToNow(l1)) });
      if ((??? != null) && (!d.oD(23))) {
        break label974;
      }
    }
    for (;;)
    {
      try
      {
        localObject2 = ((MediaCodecInfo)???).getCapabilitiesForType("video/avc");
        if (localObject2 == null) {
          continue;
        }
        localObject2 = ((MediaCodecInfo.CodecCapabilities)localObject2).profileLevels;
        if (localObject2 == null) {
          continue;
        }
        localCodecProfileLevel = new MediaCodecInfo.CodecProfileLevel();
        localCodecProfileLevel.level = 0;
        localCodecProfileLevel.profile = 0;
        k = localObject2.length;
        i = 0;
        if (i >= k) {
          continue;
        }
        Object localObject4 = localObject2[i];
        m = localObject4.profile;
        n = localObject4.level;
        Log.i("MicroMsg.MMSightYUVMediaCodecRecorder", "profile: %s, level: %s", new Object[] { Integer.valueOf(m), Integer.valueOf(n) });
        switch (m)
        {
        }
      }
      catch (Exception localException1)
      {
        try
        {
          MediaCodecInfo.CodecProfileLevel localCodecProfileLevel;
          int m;
          int n;
          long l2;
          label797:
          label805:
          label813:
          if (d.oD(21)) {
            this.mediaFormat.setInteger("bitrate-mode", 1);
          }
          this.mediaFormat.setInteger("bitrate", this.bitrate);
          this.mediaFormat.setInteger("frame-rate", this.frameRate);
          this.mediaFormat.setInteger("color-format", this.colorFormat);
          this.mediaFormat.setInteger("i-frame-interval", this.idB);
          Log.i("MicroMsg.MMSightYUVMediaCodecRecorder", "mediaFormat: %s", new Object[] { this.mediaFormat });
          this.ieT = z.Eb(((MediaCodecInfo)???).getName());
          this.ieT.a(this.mediaFormat, null, 1);
          this.ieT.start();
          if (this.zvR)
          {
            AppMethodBeat.o(89591);
            return 0;
            localException1 = localException1;
            Log.e("MicroMsg.MMSightYUVMediaCodecRecorder", "trySetProfile error: %s", new Object[] { localException1.getMessage() });
            continue;
          }
        }
        catch (Exception localException2)
        {
          Log.e("MicroMsg.MMSightYUVMediaCodecRecorder", "trySetBitRateMode error: %s", new Object[] { localException2.getMessage() });
          continue;
          synchronized (this.iff)
          {
            this.zvP = false;
            AppMethodBeat.o(89591);
            return 0;
          }
        }
        j = 0;
        continue;
      }
      if ((j != 0) && (m >= localCodecProfileLevel.profile) && (n >= localCodecProfileLevel.level))
      {
        localCodecProfileLevel.profile = m;
        localCodecProfileLevel.level = n;
      }
      i += 1;
      continue;
      i = 0;
      l2 = Util.currentTicks();
      localObject2 = ((MediaCodecInfo)???).getCapabilitiesForType("video/avc");
      Log.i("MicroMsg.MMSightYUVMediaCodecRecorder", "getCapabilitiesForType used %sms", new Object[] { Long.valueOf(Util.ticksToNow(l2)) });
      Log.i("MicroMsg.MMSightYUVMediaCodecRecorder", "color format length: %s", new Object[] { Integer.valueOf(((MediaCodecInfo.CodecCapabilities)localObject2).colorFormats.length) });
      j = 0;
      if (j < ((MediaCodecInfo.CodecCapabilities)localObject2).colorFormats.length)
      {
        n = localObject2.colorFormats[j];
        Log.i("MicroMsg.MMSightYUVMediaCodecRecorder", "capabilities colorFormat: %s", new Object[] { Integer.valueOf(n) });
        switch (n)
        {
        default: 
          m = 0;
          k = i;
          if (m != 0) {
            if (n <= i)
            {
              k = i;
              if (n != 21) {}
            }
            else
            {
              k = n;
            }
          }
          j += 1;
          i = k;
          break;
        case 19: 
        case 21: 
        case 2130706688: 
          m = 1;
          break;
        }
      }
      else
      {
        Log.i("MicroMsg.MMSightYUVMediaCodecRecorder", "codec: %s, colorFormat: %s", new Object[] { ((MediaCodecInfo)???).getName(), Integer.valueOf(i) });
        break;
        i = this.targetHeight;
        break label324;
        j = this.targetWidth;
        break label346;
        if ((this.zwB == 180) || (this.zwB == 0))
        {
          i = this.targetHeight;
          if ((this.zwB != 180) && (this.zwB != 0)) {
            continue;
          }
          j = this.targetWidth;
          this.mediaFormat = MediaFormat.createVideoFormat("video/avc", i, j);
          break label358;
        }
        i = this.targetWidth;
        continue;
        j = this.targetHeight;
        continue;
        j = 1;
      }
    }
    Log.i("MicroMsg.MMSightYUVMediaCodecRecorder", "best profile: %s, level: %s", new Object[] { Integer.valueOf(localCodecProfileLevel.profile), Integer.valueOf(localCodecProfileLevel.level) });
    if ((localCodecProfileLevel.profile > 0) && (localCodecProfileLevel.level >= 256))
    {
      this.mediaFormat.setInteger("profile", localCodecProfileLevel.profile);
      this.mediaFormat.setInteger("level", 256);
    }
  }
  
  private void ekl()
  {
    AppMethodBeat.i(89600);
    try
    {
      if (this.zwF != null) {
        this.zwF.stop();
      }
      if (this.ieT != null)
      {
        Log.i("MicroMsg.MMSightYUVMediaCodecRecorder", "stop encoder");
        this.ieT.stop();
        this.ieT.release();
        this.isStart = false;
        this.ieT = null;
      }
      AppMethodBeat.o(89600);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.MMSightYUVMediaCodecRecorder", "clear error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(89600);
    }
  }
  
  public final void a(f.a parama)
  {
    AppMethodBeat.i(89595);
    this.zwG = parama;
    this.dyL = true;
    boolean bool = this.zwF.ejV();
    Log.i("MicroMsg.MMSightYUVMediaCodecRecorder", "!!!stop, isStart!!: %s %s isEnd %s", new Object[] { Boolean.valueOf(this.isStart), this.zwG, Boolean.valueOf(bool) });
    if (bool) {
      ekk();
    }
    AppMethodBeat.o(89595);
  }
  
  public final long aMm()
  {
    AppMethodBeat.i(89597);
    if (this.startTime <= 0L)
    {
      Log.w("MicroMsg.MMSightYUVMediaCodecRecorder", "do not start record");
      AppMethodBeat.o(89597);
      return 0L;
    }
    long l = (System.nanoTime() - this.startTime) / 1000000L;
    AppMethodBeat.o(89597);
    return l;
  }
  
  public void clear()
  {
    AppMethodBeat.i(89598);
    Log.i("MicroMsg.MMSightYUVMediaCodecRecorder", "clear");
    aMi();
    AppMethodBeat.o(89598);
  }
  
  public final void d(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    AppMethodBeat.i(89592);
    if (!this.zvR) {
      synchronized (this.iff)
      {
        if (this.zvP)
        {
          AppMethodBeat.o(89592);
          return;
        }
      }
    }
    for (;;)
    {
      try
      {
        if (!this.isStart)
        {
          Log.e("MicroMsg.MMSightYUVMediaCodecRecorder", "writeData, not start!");
          AppMethodBeat.o(89592);
          return;
          paramArrayOfByte = finally;
          AppMethodBeat.o(89592);
          throw paramArrayOfByte;
        }
        if (this.ieT == null)
        {
          Log.e("MicroMsg.MMSightYUVMediaCodecRecorder", "encoder is null");
          AppMethodBeat.o(89592);
          return;
        }
        if ((this.zvN != null) && (this.zvN.ekh() <= 0L)) {
          this.zvN.eki();
        }
        long l2 = Util.currentTicks();
        this.btv = this.ieT.getInputBuffers();
        this.bfQ = this.ieT.getOutputBuffers();
        int i = this.ieT.dequeueInputBuffer(100L);
        this.jtj = i;
        if (i < 0)
        {
          Log.i("MicroMsg.MMSightYUVMediaCodecRecorder", "video no input available, drain first");
          aMn();
        }
        if (this.ieT == null)
        {
          Log.e("MicroMsg.MMSightYUVMediaCodecRecorder", "encoder is null");
          AppMethodBeat.o(89592);
          return;
        }
        Log.v("MicroMsg.MMSightYUVMediaCodecRecorder", "inputBufferIndex: %s", new Object[] { Integer.valueOf(this.jtj) });
        long l3 = Util.currentTicks();
        if (this.jtj >= 0)
        {
          long l4 = System.nanoTime();
          long l5 = paramArrayOfByte.length * 1000000000L / 1600000L;
          long l1;
          if (this.zvN != null)
          {
            l1 = this.zvN.ekh();
            l1 = (l4 - l5 - l1) / 1000L;
            if ((l1 < 0L) && (this.zwc <= 0L)) {
              this.zwc = (-l1);
            }
            l1 += this.zwc;
            Log.v("MicroMsg.MMSightYUVMediaCodecRecorder", "presentationTime: ".concat(String.valueOf(l1)));
            ??? = this.btv[this.jtj];
            ((ByteBuffer)???).clear();
            ((ByteBuffer)???).put(paramArrayOfByte);
            ((ByteBuffer)???).position(0);
            if ((this.isStart) && (!paramBoolean))
            {
              this.ieT.a(this.jtj, paramArrayOfByte.length, l1, 0);
              aMn();
              Log.v("MicroMsg.MMSightYUVMediaCodecRecorder", "encoder used %sms %sms", new Object[] { Long.valueOf(Util.ticksToNow(l2)), Long.valueOf(Util.ticksToNow(l3)) });
              AppMethodBeat.o(89592);
            }
          }
          else
          {
            l1 = this.startTime;
            continue;
          }
          Log.v("MicroMsg.MMSightYUVMediaCodecRecorder", "end of stream");
          this.jtl = true;
          this.ieT.a(this.jtj, paramArrayOfByte.length, l1, 4);
          continue;
        }
        Log.v("MicroMsg.MMSightYUVMediaCodecRecorder", "input buffer not available");
      }
      catch (Exception paramArrayOfByte)
      {
        l.aNK();
        Log.e("MicroMsg.MMSightYUVMediaCodecRecorder", "writeData error: %s", new Object[] { paramArrayOfByte.getMessage() });
        Log.printErrStackTrace("MicroMsg.MMSightYUVMediaCodecRecorder", paramArrayOfByte, "", new Object[0]);
        AppMethodBeat.o(89592);
        return;
      }
    }
  }
  
  final void ekk()
  {
    AppMethodBeat.i(89596);
    Log.i("MicroMsg.MMSightYUVMediaCodecRecorder", "stopImp %s  isStart:%b", new Object[] { Util.getStack().toString(), Boolean.valueOf(this.isStart) });
    try
    {
      if (this.isStart) {
        MMHandlerThread.postToMainThreadDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(89587);
            s.a(s.this);
            if (s.this.zwG != null)
            {
              s.this.zwG.ejZ();
              s.this.zwG = null;
            }
            AppMethodBeat.o(89587);
          }
        }, 500L);
      }
      AppMethodBeat.o(89596);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.MMSightYUVMediaCodecRecorder", "stop error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(89596);
    }
  }
  
  public int ha(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(89590);
    try
    {
      this.zwB = paramInt2;
      paramInt1 = bhL();
      AppMethodBeat.o(89590);
      return paramInt1;
    }
    catch (Exception localException1)
    {
      Log.e("MicroMsg.MMSightYUVMediaCodecRecorder", "init error: %s, try to re-init again", new Object[] { localException1.getMessage() });
      try
      {
        if (CaptureMMProxy.getInstance() != null) {
          CaptureMMProxy.getInstance().set(ar.a.NZq, Integer.valueOf(-1));
        }
        paramInt1 = bhL();
        AppMethodBeat.o(89590);
        return paramInt1;
      }
      catch (Exception localException2)
      {
        Log.e("MicroMsg.MMSightYUVMediaCodecRecorder", "re-init again error: %s", new Object[] { localException2.getMessage() });
        l.aNJ();
        AppMethodBeat.o(89590);
      }
    }
    return -1;
  }
  
  protected void i(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    AppMethodBeat.i(89594);
    if ((this.zvN != null) && ((paramBufferInfo.flags & 0x4) == 0)) {
      this.zvN.k(paramByteBuffer, paramBufferInfo);
    }
    AppMethodBeat.o(89594);
  }
  
  public final void start()
  {
    AppMethodBeat.i(89589);
    Log.i("MicroMsg.MMSightYUVMediaCodecRecorder", "Start");
    this.isStart = true;
    Log.i("MicroMsg.MMSightYUVMediaCodecRecorder", "Start：isStart：" + this.isStart);
    this.startTime = System.nanoTime();
    AppMethodBeat.o(89589);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.s
 * JD-Core Version:    0.7.0.1
 */