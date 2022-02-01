package com.tencent.mm.plugin.appbrand.media.record.a;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.z;
import com.tencent.mm.plugin.appbrand.media.encode.M4aAudioFormatJni;
import com.tencent.mm.plugin.appbrand.media.record.j;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class a
  extends c
{
  private final int TIMEOUT_USEC = 100;
  int kRp = 2;
  private z kRq;
  MediaCodec.BufferInfo kRr;
  private String mFilePath = "";
  
  public final boolean a(boolean paramBoolean, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(146338);
    if (paramArrayOfByte == null)
    {
      ad.e("MicroMsg.Record.AACAudioEncoder", "pcm is null");
      AppMethodBeat.o(146338);
      return false;
    }
    if (this.kRq != null)
    {
      ad.i("MicroMsg.Record.AACAudioEncoder", "encodePCMToAAC endOfStream:%b", new Object[] { Boolean.valueOf(paramBoolean) });
      Object localObject2 = this.kRq.getInputBuffers();
      Object localObject1 = this.kRq.getOutputBuffers();
      paramInt = this.kRq.dequeueInputBuffer(100L);
      if (paramInt >= 0)
      {
        localObject2 = localObject2[paramInt];
        ((ByteBuffer)localObject2).clear();
        ((ByteBuffer)localObject2).put(paramArrayOfByte);
        ((ByteBuffer)localObject2).position(0);
        ((ByteBuffer)localObject2).limit(paramArrayOfByte.length);
        ad.i("MicroMsg.Record.AACAudioEncoder", "inputBufferIndex:%d, data length:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfByte.length) });
        if (paramBoolean)
        {
          this.kRq.a(paramInt, paramArrayOfByte.length, System.nanoTime(), 4);
          paramArrayOfByte = (byte[])localObject1;
          paramInt = this.kRq.dequeueOutputBuffer(this.kRr, 100L);
          if (paramInt != -1) {
            break label240;
          }
          ad.d("MicroMsg.Record.AACAudioEncoder", "no output available, break");
        }
      }
      for (;;)
      {
        label189:
        AppMethodBeat.o(146338);
        return true;
        this.kRq.a(paramInt, paramArrayOfByte.length, System.nanoTime(), 0);
        paramArrayOfByte = (byte[])localObject1;
        break;
        ad.e("MicroMsg.Record.AACAudioEncoder", "inputBufferIndex %d", new Object[] { Integer.valueOf(paramInt) });
        paramArrayOfByte = (byte[])localObject1;
        break;
        label240:
        if (paramInt == -3)
        {
          ad.e("MicroMsg.Record.AACAudioEncoder", "output buff change");
          paramArrayOfByte = this.kRq.getOutputBuffers();
          break;
        }
        if (paramInt == -2)
        {
          ad.e("MicroMsg.Record.AACAudioEncoder", "encoder output format changed: ".concat(String.valueOf(this.kRq.getOutputFormat())));
          break;
        }
        if (paramInt < 0)
        {
          ad.e("MicroMsg.Record.AACAudioEncoder", "unexpected result from encoder.dequeueOutputBuffer: %s", new Object[] { Integer.valueOf(paramInt) });
          break;
        }
        ad.i("MicroMsg.Record.AACAudioEncoder", "outputBufferIndex %d", new Object[] { Integer.valueOf(paramInt) });
        localObject1 = paramArrayOfByte[paramInt];
        if (localObject1 == null)
        {
          paramArrayOfByte = new RuntimeException("outputBuffer " + paramInt + " was null");
          AppMethodBeat.o(146338);
          throw paramArrayOfByte;
        }
        if ((this.kRr.flags & 0x2) != 0) {
          ad.e("MicroMsg.Record.AACAudioEncoder", "flags is BUFFER_FLAG_CODEC_CONFIG, don't writ data into file");
        }
        for (;;)
        {
          this.kRq.releaseOutputBuffer(paramInt, false);
          if ((this.kRr.flags & 0x4) == 0) {
            break;
          }
          if (paramBoolean) {
            break label505;
          }
          ad.w("MicroMsg.Record.AACAudioEncoder", "reached end of stream unexpectedly");
          break label189;
          int i = this.kRr.size;
          localObject2 = new byte[i];
          ((ByteBuffer)localObject1).get((byte[])localObject2, 0, i);
          int j = M4aAudioFormatJni.writeAudioBuff((byte[])localObject2, i);
          d((byte[])localObject2, i, false);
          if (j == 0) {
            ad.i("MicroMsg.Record.AACAudioEncoder", "writeAudioBuff buff ok,");
          } else {
            ad.i("MicroMsg.Record.AACAudioEncoder", "writeAudioBuff buff fail,");
          }
        }
        label505:
        ad.e("MicroMsg.Record.AACAudioEncoder", "reach the end, and end to encode the data");
      }
    }
    ad.e("MicroMsg.Record.AACAudioEncoder", "mEncoder is null");
    AppMethodBeat.o(146338);
    return false;
  }
  
  public final void close()
  {
    AppMethodBeat.i(146340);
    ad.i("MicroMsg.Record.AACAudioEncoder", "close");
    if (this.kRq != null)
    {
      this.kRq.stop();
      this.kRq.release();
      this.kRq = null;
    }
    M4aAudioFormatJni.closeM4aFile();
    AppMethodBeat.o(146340);
  }
  
  public final void flush()
  {
    AppMethodBeat.i(146339);
    ad.i("MicroMsg.Record.AACAudioEncoder", "flush");
    d(new byte[0], 0, true);
    AppMethodBeat.o(146339);
  }
  
  public final boolean i(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(146337);
    ad.i("MicroMsg.Record.AACAudioEncoder", "init, filePath:%s, sampleRate:%d, channelCount:%d, bitRate:%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.mFilePath = paramString;
    try
    {
      ad.i("MicroMsg.Record.AACAudioEncoder", "initCodec");
      this.kRr = new MediaCodec.BufferInfo();
      MediaFormat localMediaFormat = MediaFormat.createAudioFormat(this.kRt, paramInt1, paramInt2);
      localMediaFormat.setInteger("bitrate", paramInt3);
      localMediaFormat.setInteger("aac-profile", this.kRp);
      this.kRq = z.q(this.kRt, false);
      this.kRq.a(localMediaFormat, null, 1);
      this.kRq.start();
      ad.i("MicroMsg.Record.AACAudioEncoder", "encoder start to work");
      paramInt3 = 0;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.Record.AACAudioEncoder", localIOException, "initCodec", new Object[0]);
        paramInt3 = -1;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.Record.AACAudioEncoder", localException, "initCodec", new Object[0]);
        paramInt3 = -1;
      }
      ad.i("MicroMsg.Record.AACAudioEncoder", "initCodec ok");
      if (M4aAudioFormatJni.createM4aFile(paramString, paramInt2, paramInt1, this.kRp) != 0) {
        break label241;
      }
      ad.i("MicroMsg.Record.AACAudioEncoder", "createM4aFile m4a jni api ok,");
      AppMethodBeat.o(146337);
      return true;
      ad.i("MicroMsg.Record.AACAudioEncoder", "createM4aFile m4a jni api fail,");
      j.th(22);
      AppMethodBeat.o(146337);
    }
    if (paramInt3 == -1)
    {
      ad.i("MicroMsg.Record.AACAudioEncoder", "initCodec  fail,");
      j.th(21);
      AppMethodBeat.o(146337);
      return false;
    }
    label241:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.a.a
 * JD-Core Version:    0.7.0.1
 */