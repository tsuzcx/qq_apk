package com.tencent.mm.plugin.appbrand.media.record.a;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import com.tencent.mm.plugin.appbrand.media.encode.M4aAudioFormatJni;
import com.tencent.mm.plugin.appbrand.media.record.j;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class a
  extends b
{
  int gOq = 2;
  private MediaCodec gOr;
  private final int gOs = 100;
  MediaCodec.BufferInfo mBufferInfo;
  private String mFilePath = "";
  
  public final boolean a(boolean paramBoolean, byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte == null)
    {
      y.e("MicroMsg.Record.AACAudioEncoder", "pcm is null");
      return false;
    }
    if (this.gOr != null)
    {
      y.i("MicroMsg.Record.AACAudioEncoder", "encodePCMToAAC endOfStream:%b", new Object[] { Boolean.valueOf(paramBoolean) });
      Object localObject2 = this.gOr.getInputBuffers();
      Object localObject1 = this.gOr.getOutputBuffers();
      paramInt = this.gOr.dequeueInputBuffer(100L);
      if (paramInt >= 0)
      {
        localObject2 = localObject2[paramInt];
        ((ByteBuffer)localObject2).clear();
        ((ByteBuffer)localObject2).put(paramArrayOfByte);
        ((ByteBuffer)localObject2).position(0);
        ((ByteBuffer)localObject2).limit(paramArrayOfByte.length);
        y.i("MicroMsg.Record.AACAudioEncoder", "inputBufferIndex:%d, data length:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfByte.length) });
        if (paramBoolean)
        {
          this.gOr.queueInputBuffer(paramInt, 0, paramArrayOfByte.length, System.nanoTime(), 4);
          paramArrayOfByte = (byte[])localObject1;
          paramInt = this.gOr.dequeueOutputBuffer(this.mBufferInfo, 100L);
          if (paramInt != -1) {
            break label227;
          }
          y.d("MicroMsg.Record.AACAudioEncoder", "no output available, break");
        }
      }
      for (;;)
      {
        label180:
        return true;
        this.gOr.queueInputBuffer(paramInt, 0, paramArrayOfByte.length, System.nanoTime(), 0);
        paramArrayOfByte = (byte[])localObject1;
        break;
        y.e("MicroMsg.Record.AACAudioEncoder", "inputBufferIndex %d", new Object[] { Integer.valueOf(paramInt) });
        paramArrayOfByte = (byte[])localObject1;
        break;
        label227:
        if (paramInt == -3)
        {
          y.e("MicroMsg.Record.AACAudioEncoder", "output buff change");
          paramArrayOfByte = this.gOr.getOutputBuffers();
          break;
        }
        if (paramInt == -2)
        {
          localObject1 = this.gOr.getOutputFormat();
          y.e("MicroMsg.Record.AACAudioEncoder", "encoder output format changed: " + localObject1);
          break;
        }
        if (paramInt < 0)
        {
          y.e("MicroMsg.Record.AACAudioEncoder", "unexpected result from encoder.dequeueOutputBuffer: %s", new Object[] { Integer.valueOf(paramInt) });
          break;
        }
        y.i("MicroMsg.Record.AACAudioEncoder", "outputBufferIndex %d", new Object[] { Integer.valueOf(paramInt) });
        localObject1 = paramArrayOfByte[paramInt];
        if (localObject1 == null) {
          throw new RuntimeException("outputBuffer " + paramInt + " was null");
        }
        if ((this.mBufferInfo.flags & 0x2) != 0) {
          y.e("MicroMsg.Record.AACAudioEncoder", "flags is BUFFER_FLAG_CODEC_CONFIG, don't writ data into file");
        }
        for (;;)
        {
          this.gOr.releaseOutputBuffer(paramInt, false);
          if ((this.mBufferInfo.flags & 0x4) == 0) {
            break;
          }
          if (paramBoolean) {
            break label496;
          }
          y.w("MicroMsg.Record.AACAudioEncoder", "reached end of stream unexpectedly");
          break label180;
          int i = this.mBufferInfo.size;
          localObject2 = new byte[i];
          ((ByteBuffer)localObject1).get((byte[])localObject2, 0, i);
          int j = M4aAudioFormatJni.writeAudioBuff((byte[])localObject2, i);
          d((byte[])localObject2, i, false);
          if (j == 0) {
            y.i("MicroMsg.Record.AACAudioEncoder", "writeAudioBuff buff ok,");
          } else {
            y.i("MicroMsg.Record.AACAudioEncoder", "writeAudioBuff buff fail,");
          }
        }
        label496:
        y.e("MicroMsg.Record.AACAudioEncoder", "reach the end, and end to encode the data");
      }
    }
    y.e("MicroMsg.Record.AACAudioEncoder", "mEncoder is null");
    return false;
  }
  
  public final void close()
  {
    y.i("MicroMsg.Record.AACAudioEncoder", "close");
    if (this.gOr != null)
    {
      this.gOr.stop();
      this.gOr.release();
      this.gOr = null;
    }
    M4aAudioFormatJni.closeM4aFile();
  }
  
  public final boolean f(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    y.i("MicroMsg.Record.AACAudioEncoder", "init, filePath:%s, sampleRate:%d, channelCount:%d, bitRate:%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.mFilePath = paramString;
    try
    {
      y.i("MicroMsg.Record.AACAudioEncoder", "initCodec");
      this.mBufferInfo = new MediaCodec.BufferInfo();
      MediaFormat localMediaFormat = MediaFormat.createAudioFormat(this.gOt, paramInt1, paramInt2);
      localMediaFormat.setInteger("bitrate", paramInt3);
      localMediaFormat.setInteger("aac-profile", this.gOq);
      this.gOr = MediaCodec.createEncoderByType(this.gOt);
      this.gOr.configure(localMediaFormat, null, null, 1);
      this.gOr.start();
      y.i("MicroMsg.Record.AACAudioEncoder", "encoder start to work");
      paramInt3 = 0;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.Record.AACAudioEncoder", localIOException, "initCodec", new Object[0]);
        paramInt3 = -1;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.Record.AACAudioEncoder", localException, "initCodec", new Object[0]);
        paramInt3 = -1;
      }
      y.i("MicroMsg.Record.AACAudioEncoder", "initCodec ok");
      if (M4aAudioFormatJni.createM4aFile(paramString, paramInt2, paramInt1, this.gOq) != 0) {
        break label224;
      }
      y.i("MicroMsg.Record.AACAudioEncoder", "createM4aFile m4a jni api ok,");
      return true;
      label224:
      y.i("MicroMsg.Record.AACAudioEncoder", "createM4aFile m4a jni api fail,");
      j.lU(22);
    }
    if (paramInt3 == -1)
    {
      y.i("MicroMsg.Record.AACAudioEncoder", "initCodec  fail,");
      j.lU(21);
      return false;
    }
    return false;
  }
  
  public final void flush()
  {
    y.i("MicroMsg.Record.AACAudioEncoder", "flush");
    d(new byte[0], 0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.a.a
 * JD-Core Version:    0.7.0.1
 */