package com.tencent.mm.plugin.appbrand.media.record.a;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.media.encode.M4aAudioFormatJni;
import com.tencent.mm.plugin.appbrand.media.record.j;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class a
  extends c
{
  private final int TIMEOUT_USEC = 100;
  int iqc = 2;
  private MediaCodec iqd;
  MediaCodec.BufferInfo mBufferInfo;
  private String mFilePath = "";
  
  public final boolean a(boolean paramBoolean, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(105646);
    if (paramArrayOfByte == null)
    {
      ab.e("MicroMsg.Record.AACAudioEncoder", "pcm is null");
      AppMethodBeat.o(105646);
      return false;
    }
    if (this.iqd != null)
    {
      ab.i("MicroMsg.Record.AACAudioEncoder", "encodePCMToAAC endOfStream:%b", new Object[] { Boolean.valueOf(paramBoolean) });
      Object localObject2 = this.iqd.getInputBuffers();
      Object localObject1 = this.iqd.getOutputBuffers();
      paramInt = this.iqd.dequeueInputBuffer(100L);
      if (paramInt >= 0)
      {
        localObject2 = localObject2[paramInt];
        ((ByteBuffer)localObject2).clear();
        ((ByteBuffer)localObject2).put(paramArrayOfByte);
        ((ByteBuffer)localObject2).position(0);
        ((ByteBuffer)localObject2).limit(paramArrayOfByte.length);
        ab.i("MicroMsg.Record.AACAudioEncoder", "inputBufferIndex:%d, data length:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfByte.length) });
        if (paramBoolean)
        {
          this.iqd.queueInputBuffer(paramInt, 0, paramArrayOfByte.length, System.nanoTime(), 4);
          paramArrayOfByte = (byte[])localObject1;
          paramInt = this.iqd.dequeueOutputBuffer(this.mBufferInfo, 100L);
          if (paramInt != -1) {
            break label242;
          }
          ab.d("MicroMsg.Record.AACAudioEncoder", "no output available, break");
        }
      }
      for (;;)
      {
        label190:
        AppMethodBeat.o(105646);
        return true;
        this.iqd.queueInputBuffer(paramInt, 0, paramArrayOfByte.length, System.nanoTime(), 0);
        paramArrayOfByte = (byte[])localObject1;
        break;
        ab.e("MicroMsg.Record.AACAudioEncoder", "inputBufferIndex %d", new Object[] { Integer.valueOf(paramInt) });
        paramArrayOfByte = (byte[])localObject1;
        break;
        label242:
        if (paramInt == -3)
        {
          ab.e("MicroMsg.Record.AACAudioEncoder", "output buff change");
          paramArrayOfByte = this.iqd.getOutputBuffers();
          break;
        }
        if (paramInt == -2)
        {
          ab.e("MicroMsg.Record.AACAudioEncoder", "encoder output format changed: ".concat(String.valueOf(this.iqd.getOutputFormat())));
          break;
        }
        if (paramInt < 0)
        {
          ab.e("MicroMsg.Record.AACAudioEncoder", "unexpected result from encoder.dequeueOutputBuffer: %s", new Object[] { Integer.valueOf(paramInt) });
          break;
        }
        ab.i("MicroMsg.Record.AACAudioEncoder", "outputBufferIndex %d", new Object[] { Integer.valueOf(paramInt) });
        localObject1 = paramArrayOfByte[paramInt];
        if (localObject1 == null)
        {
          paramArrayOfByte = new RuntimeException("outputBuffer " + paramInt + " was null");
          AppMethodBeat.o(105646);
          throw paramArrayOfByte;
        }
        if ((this.mBufferInfo.flags & 0x2) != 0) {
          ab.e("MicroMsg.Record.AACAudioEncoder", "flags is BUFFER_FLAG_CODEC_CONFIG, don't writ data into file");
        }
        for (;;)
        {
          this.iqd.releaseOutputBuffer(paramInt, false);
          if ((this.mBufferInfo.flags & 0x4) == 0) {
            break;
          }
          if (paramBoolean) {
            break label507;
          }
          ab.w("MicroMsg.Record.AACAudioEncoder", "reached end of stream unexpectedly");
          break label190;
          int i = this.mBufferInfo.size;
          localObject2 = new byte[i];
          ((ByteBuffer)localObject1).get((byte[])localObject2, 0, i);
          int j = M4aAudioFormatJni.writeAudioBuff((byte[])localObject2, i);
          f((byte[])localObject2, i, false);
          if (j == 0) {
            ab.i("MicroMsg.Record.AACAudioEncoder", "writeAudioBuff buff ok,");
          } else {
            ab.i("MicroMsg.Record.AACAudioEncoder", "writeAudioBuff buff fail,");
          }
        }
        label507:
        ab.e("MicroMsg.Record.AACAudioEncoder", "reach the end, and end to encode the data");
      }
    }
    ab.e("MicroMsg.Record.AACAudioEncoder", "mEncoder is null");
    AppMethodBeat.o(105646);
    return false;
  }
  
  public final void close()
  {
    AppMethodBeat.i(105648);
    ab.i("MicroMsg.Record.AACAudioEncoder", "close");
    if (this.iqd != null)
    {
      this.iqd.stop();
      this.iqd.release();
      this.iqd = null;
    }
    M4aAudioFormatJni.closeM4aFile();
    AppMethodBeat.o(105648);
  }
  
  public final void flush()
  {
    AppMethodBeat.i(105647);
    ab.i("MicroMsg.Record.AACAudioEncoder", "flush");
    f(new byte[0], 0, true);
    AppMethodBeat.o(105647);
  }
  
  public final boolean h(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(105645);
    ab.i("MicroMsg.Record.AACAudioEncoder", "init, filePath:%s, sampleRate:%d, channelCount:%d, bitRate:%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.mFilePath = paramString;
    try
    {
      ab.i("MicroMsg.Record.AACAudioEncoder", "initCodec");
      this.mBufferInfo = new MediaCodec.BufferInfo();
      MediaFormat localMediaFormat = MediaFormat.createAudioFormat(this.iqf, paramInt1, paramInt2);
      localMediaFormat.setInteger("bitrate", paramInt3);
      localMediaFormat.setInteger("aac-profile", this.iqc);
      this.iqd = MediaCodec.createEncoderByType(this.iqf);
      this.iqd.configure(localMediaFormat, null, null, 1);
      this.iqd.start();
      ab.i("MicroMsg.Record.AACAudioEncoder", "encoder start to work");
      paramInt3 = 0;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.Record.AACAudioEncoder", localIOException, "initCodec", new Object[0]);
        paramInt3 = -1;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.Record.AACAudioEncoder", localException, "initCodec", new Object[0]);
        paramInt3 = -1;
      }
      ab.i("MicroMsg.Record.AACAudioEncoder", "initCodec ok");
      if (M4aAudioFormatJni.createM4aFile(paramString, paramInt2, paramInt1, this.iqc) != 0) {
        break label242;
      }
      ab.i("MicroMsg.Record.AACAudioEncoder", "createM4aFile m4a jni api ok,");
      AppMethodBeat.o(105645);
      return true;
      ab.i("MicroMsg.Record.AACAudioEncoder", "createM4aFile m4a jni api fail,");
      j.oS(22);
      AppMethodBeat.o(105645);
    }
    if (paramInt3 == -1)
    {
      ab.i("MicroMsg.Record.AACAudioEncoder", "initCodec  fail,");
      j.oS(21);
      AppMethodBeat.o(105645);
      return false;
    }
    label242:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.a.a
 * JD-Core Version:    0.7.0.1
 */