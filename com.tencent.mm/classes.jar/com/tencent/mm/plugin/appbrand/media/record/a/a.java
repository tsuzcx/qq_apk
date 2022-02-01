package com.tencent.mm.plugin.appbrand.media.record.a;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.z;
import com.tencent.mm.plugin.appbrand.media.encode.M4aAudioFormatJni;
import com.tencent.mm.plugin.appbrand.media.record.j;
import com.tencent.mm.sdk.platformtools.ae;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class a
  extends c
{
  private final int TIMEOUT_USEC = 100;
  private z lWA;
  MediaCodec.BufferInfo lWB;
  int lWz = 2;
  private String mFilePath = "";
  
  public final boolean a(boolean paramBoolean, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(146338);
    if (paramArrayOfByte == null)
    {
      ae.e("MicroMsg.Record.AACAudioEncoder", "pcm is null");
      AppMethodBeat.o(146338);
      return false;
    }
    if (this.lWA != null)
    {
      ae.i("MicroMsg.Record.AACAudioEncoder", "encodePCMToAAC endOfStream:%b", new Object[] { Boolean.valueOf(paramBoolean) });
      Object localObject2 = this.lWA.getInputBuffers();
      Object localObject1 = this.lWA.getOutputBuffers();
      paramInt = this.lWA.dequeueInputBuffer(100L);
      if (paramInt >= 0)
      {
        localObject2 = localObject2[paramInt];
        ((ByteBuffer)localObject2).clear();
        ((ByteBuffer)localObject2).put(paramArrayOfByte);
        ((ByteBuffer)localObject2).position(0);
        ((ByteBuffer)localObject2).limit(paramArrayOfByte.length);
        ae.i("MicroMsg.Record.AACAudioEncoder", "inputBufferIndex:%d, data length:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfByte.length) });
        if (paramBoolean)
        {
          this.lWA.a(paramInt, paramArrayOfByte.length, System.nanoTime(), 4);
          paramArrayOfByte = (byte[])localObject1;
          paramInt = this.lWA.dequeueOutputBuffer(this.lWB, 100L);
          if (paramInt != -1) {
            break label240;
          }
          ae.d("MicroMsg.Record.AACAudioEncoder", "no output available, break");
        }
      }
      for (;;)
      {
        label189:
        AppMethodBeat.o(146338);
        return true;
        this.lWA.a(paramInt, paramArrayOfByte.length, System.nanoTime(), 0);
        paramArrayOfByte = (byte[])localObject1;
        break;
        ae.e("MicroMsg.Record.AACAudioEncoder", "inputBufferIndex %d", new Object[] { Integer.valueOf(paramInt) });
        paramArrayOfByte = (byte[])localObject1;
        break;
        label240:
        if (paramInt == -3)
        {
          ae.e("MicroMsg.Record.AACAudioEncoder", "output buff change");
          paramArrayOfByte = this.lWA.getOutputBuffers();
          break;
        }
        if (paramInt == -2)
        {
          ae.e("MicroMsg.Record.AACAudioEncoder", "encoder output format changed: ".concat(String.valueOf(this.lWA.getOutputFormat())));
          break;
        }
        if (paramInt < 0)
        {
          ae.e("MicroMsg.Record.AACAudioEncoder", "unexpected result from encoder.dequeueOutputBuffer: %s", new Object[] { Integer.valueOf(paramInt) });
          break;
        }
        ae.i("MicroMsg.Record.AACAudioEncoder", "outputBufferIndex %d", new Object[] { Integer.valueOf(paramInt) });
        localObject1 = paramArrayOfByte[paramInt];
        if (localObject1 == null)
        {
          paramArrayOfByte = new RuntimeException("outputBuffer " + paramInt + " was null");
          AppMethodBeat.o(146338);
          throw paramArrayOfByte;
        }
        if ((this.lWB.flags & 0x2) != 0) {
          ae.e("MicroMsg.Record.AACAudioEncoder", "flags is BUFFER_FLAG_CODEC_CONFIG, don't writ data into file");
        }
        for (;;)
        {
          this.lWA.releaseOutputBuffer(paramInt, false);
          if ((this.lWB.flags & 0x4) == 0) {
            break;
          }
          if (paramBoolean) {
            break label505;
          }
          ae.w("MicroMsg.Record.AACAudioEncoder", "reached end of stream unexpectedly");
          break label189;
          int i = this.lWB.size;
          localObject2 = new byte[i];
          ((ByteBuffer)localObject1).get((byte[])localObject2, 0, i);
          int j = M4aAudioFormatJni.writeAudioBuff((byte[])localObject2, i);
          d((byte[])localObject2, i, false);
          if (j == 0) {
            ae.i("MicroMsg.Record.AACAudioEncoder", "writeAudioBuff buff ok,");
          } else {
            ae.i("MicroMsg.Record.AACAudioEncoder", "writeAudioBuff buff fail,");
          }
        }
        label505:
        ae.e("MicroMsg.Record.AACAudioEncoder", "reach the end, and end to encode the data");
      }
    }
    ae.e("MicroMsg.Record.AACAudioEncoder", "mEncoder is null");
    AppMethodBeat.o(146338);
    return false;
  }
  
  public final void close()
  {
    AppMethodBeat.i(146340);
    ae.i("MicroMsg.Record.AACAudioEncoder", "close");
    if (this.lWA != null)
    {
      this.lWA.stop();
      this.lWA.release();
      this.lWA = null;
    }
    M4aAudioFormatJni.closeM4aFile();
    AppMethodBeat.o(146340);
  }
  
  public final void flush()
  {
    AppMethodBeat.i(146339);
    ae.i("MicroMsg.Record.AACAudioEncoder", "flush");
    d(new byte[0], 0, true);
    AppMethodBeat.o(146339);
  }
  
  public final boolean i(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(146337);
    ae.i("MicroMsg.Record.AACAudioEncoder", "init, filePath:%s, sampleRate:%d, channelCount:%d, bitRate:%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.mFilePath = paramString;
    try
    {
      ae.i("MicroMsg.Record.AACAudioEncoder", "initCodec");
      this.lWB = new MediaCodec.BufferInfo();
      MediaFormat localMediaFormat = MediaFormat.createAudioFormat(this.lWD, paramInt1, paramInt2);
      localMediaFormat.setInteger("bitrate", paramInt3);
      localMediaFormat.setInteger("aac-profile", this.lWz);
      this.lWA = z.q(this.lWD, false);
      this.lWA.a(localMediaFormat, null, 1);
      this.lWA.start();
      ae.i("MicroMsg.Record.AACAudioEncoder", "encoder start to work");
      paramInt3 = 0;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.Record.AACAudioEncoder", localIOException, "initCodec", new Object[0]);
        paramInt3 = -1;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.Record.AACAudioEncoder", localException, "initCodec", new Object[0]);
        paramInt3 = -1;
      }
      ae.i("MicroMsg.Record.AACAudioEncoder", "initCodec ok");
      if (M4aAudioFormatJni.createM4aFile(paramString, paramInt2, paramInt1, this.lWz) != 0) {
        break label241;
      }
      ae.i("MicroMsg.Record.AACAudioEncoder", "createM4aFile m4a jni api ok,");
      AppMethodBeat.o(146337);
      return true;
      ae.i("MicroMsg.Record.AACAudioEncoder", "createM4aFile m4a jni api fail,");
      j.uI(22);
      AppMethodBeat.o(146337);
    }
    if (paramInt3 == -1)
    {
      ae.i("MicroMsg.Record.AACAudioEncoder", "initCodec  fail,");
      j.uI(21);
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