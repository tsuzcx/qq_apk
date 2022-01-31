package com.tencent.mm.plugin.mmsight.model.b;

import android.graphics.Point;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecList;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.nio.ByteBuffer;

public final class e
  implements a
{
  protected long aRW;
  protected String eFp = null;
  protected MediaCodec.BufferInfo eIJ = new MediaCodec.BufferInfo();
  protected MediaExtractor eIP;
  protected long eIR;
  protected MediaFormat eIS;
  protected MediaCodec eIT;
  protected int eIU = -1;
  protected int eIV;
  private byte[] eIW;
  private int frameCount = 0;
  protected h mkZ;
  private boolean mlc = false;
  protected int sampleSize;
  
  private boolean ST()
  {
    if (this.eIT == null)
    {
      y.e("MicroMsg.MMSightRemuxMediaCodecDecoder", "drainDecoder, decoder is null");
      return true;
    }
    Object localObject = this.eIT.getOutputBuffers();
    y.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "decoderOutputByteBuffers length: %s", new Object[] { Integer.valueOf(localObject.length) });
    int i = this.eIT.dequeueOutputBuffer(this.eIJ, 60000L);
    y.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "outputBufferIndex-->" + i);
    if (i == -1)
    {
      y.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "no output from decoder available, break");
      label93:
      return false;
    }
    if (i == -3)
    {
      localObject = this.eIT.getOutputBuffers();
      y.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "decoder output buffers changed");
    }
    for (;;)
    {
      int j = this.eIT.dequeueOutputBuffer(this.eIJ, 60000L);
      i = j;
      if (j >= 0) {
        break;
      }
      break label93;
      if (i == -2)
      {
        this.eIS = this.eIT.getOutputFormat();
        y.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "decoder output format changed: " + this.eIS);
      }
      else if (i < 0)
      {
        y.w("MicroMsg.MMSightRemuxMediaCodecDecoder", "unexpected result from decoder.dequeueOutputBuffer: " + i);
      }
      else
      {
        y.v("MicroMsg.MMSightRemuxMediaCodecDecoder", "perform decoding");
        h localh = localObject[i];
        if (localh == null) {
          break label93;
        }
        long l1 = this.eIJ.presentationTimeUs;
        if ((l1 < this.aRW * 1000L) && ((this.eIJ.flags & 0x4) == 0))
        {
          this.eIT.releaseOutputBuffer(i, false);
          y.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "decoder pts: %s, not reach start: %s", new Object[] { Long.valueOf(l1), Long.valueOf(this.aRW * 1000L) });
          return false;
        }
        if (this.eIJ.size != 0)
        {
          localh.position(this.eIJ.offset);
          localh.limit(this.eIJ.offset + this.eIJ.size);
          long l2 = bk.UZ();
          localObject = this.eIJ;
          if (localh == null) {
            y.e("MicroMsg.MMSightRemuxMediaCodecDecoder", "processDecodeOutputBuffer error! byteBuffer is null");
          }
          for (;;)
          {
            y.v("MicroMsg.MMSightRemuxMediaCodecDecoder", "processDecodeOutputBuffer %s", new Object[] { Long.valueOf(bk.cp(l2)) });
            this.eIT.releaseOutputBuffer(i, false);
            if ((this.eIR != 1L) && (l1 >= this.eIR * 1000L))
            {
              y.e("MicroMsg.MMSightRemuxMediaCodecDecoder", "exceed endTimeMs");
              this.mlc = true;
              return true;
              this.frameCount += 1;
              if ((this.eIV > 1) && (this.frameCount % this.eIV == 0)) {
                continue;
              }
              if (this.eIW == null) {
                this.eIW = new byte[localh.remaining()];
              }
              long l3 = bk.UZ();
              try
              {
                this.eIS = this.eIT.getOutputFormat();
                localh.get(this.eIW, 0, localh.remaining());
                y.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "processDecodeOutputBuffer, byteBuffer: %s, bufferInfo: %s, size: %d cost %d", new Object[] { localh, localObject, Integer.valueOf(((MediaCodec.BufferInfo)localObject).size), Long.valueOf(bk.cp(l3)) });
                if (this.mkZ != null) {
                  if ((this.eIR != 1L) && (((MediaCodec.BufferInfo)localObject).presentationTimeUs >= this.eIR * 1000L))
                  {
                    j = 1;
                    localh = this.mkZ;
                    byte[] arrayOfByte = this.eIW;
                    if ((this.eIW != null) && (!this.mlc) && (j == 0)) {
                      break label672;
                    }
                    bool = true;
                    localh.a(arrayOfByte, bool, ((MediaCodec.BufferInfo)localObject).presentationTimeUs / 1000L);
                  }
                }
              }
              catch (Exception localException2)
              {
                for (;;)
                {
                  y.e("MicroMsg.MMSightRemuxMediaCodecDecoder", "get output format error");
                  continue;
                  j = 0;
                  continue;
                  label672:
                  boolean bool = false;
                }
              }
            }
          }
          if ((this.eIJ.flags & 0x4) != 0)
          {
            y.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "receive end of stream");
            try
            {
              this.eIT.stop();
              this.eIT.release();
              this.mlc = true;
              this.eIT = null;
              return true;
            }
            catch (Exception localException1)
            {
              for (;;)
              {
                y.e("MicroMsg.MMSightRemuxMediaCodecDecoder", "stop and release decoder error: %s", new Object[] { localException1.getMessage() });
              }
            }
          }
          return false;
        }
        this.eIT.releaseOutputBuffer(i, false);
      }
    }
  }
  
  private static int a(MediaCodecInfo paramMediaCodecInfo, String paramString)
  {
    y.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "selectColorFormat, mimeType: %s, codecInfo: %s", new Object[] { paramString, paramMediaCodecInfo });
    long l = bk.UZ();
    paramString = paramMediaCodecInfo.getCapabilitiesForType(paramString);
    y.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "getCapabilitiesForType used %sms", new Object[] { Long.valueOf(bk.cp(l)) });
    y.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "color format length: %s", new Object[] { Integer.valueOf(paramString.colorFormats.length) });
    int i = 0;
    int j = 0;
    if (i < paramString.colorFormats.length)
    {
      int n = paramString.colorFormats[i];
      y.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "capabilities colorFormat: %s", new Object[] { Integer.valueOf(n) });
      switch (n)
      {
      }
      for (int m = 0;; m = 1)
      {
        int k = j;
        if (m != 0) {
          if (n <= j)
          {
            k = j;
            if (n != 21) {}
          }
          else
          {
            k = n;
          }
        }
        i += 1;
        j = k;
        break;
      }
    }
    y.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "codec: %s, colorFormat: %s", new Object[] { paramMediaCodecInfo.getName(), Integer.valueOf(j) });
    return j;
  }
  
  private static MediaCodecInfo ol(String paramString)
  {
    int k = MediaCodecList.getCodecCount();
    int i = 0;
    while (i < k)
    {
      MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
      if (!localMediaCodecInfo.isEncoder())
      {
        String[] arrayOfString = localMediaCodecInfo.getSupportedTypes();
        int j = 0;
        while (j < arrayOfString.length)
        {
          if (arrayOfString[j].equalsIgnoreCase(paramString)) {
            return localMediaCodecInfo;
          }
          j += 1;
        }
      }
      i += 1;
    }
    return null;
  }
  
  public final Point SP()
  {
    return new Point(this.eIS.getInteger("width"), this.eIS.getInteger("height"));
  }
  
  public final int SQ()
  {
    int i = this.eIS.getInteger("color-format");
    y.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "src color format: %s", new Object[] { Integer.valueOf(i) });
    switch (i)
    {
    case 21: 
    case 2130706688: 
    default: 
      return 1;
    }
    return 2;
  }
  
  public final void a(h paramh)
  {
    this.mkZ = paramh;
  }
  
  public final void bjJ()
  {
    this.frameCount = 0;
    this.mlc = false;
    Object localObject1 = this.eIP;
    if (this.eIT == null) {
      y.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "input decoder is null");
    }
    Object localObject2;
    long l;
    for (boolean bool1 = true;; bool1 = false)
    {
      if (!bool1)
      {
        this.eIP.advance();
        if (this.eIP.getSampleTrackIndex() == this.eIU) {
          break;
        }
        y.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "track index not match, break");
      }
      localObject1 = this.eIP;
      y.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "sendDecoderEOS");
      localObject2 = this.eIT.getInputBuffers();
      i = this.eIT.dequeueInputBuffer(60000L);
      if (i < 0)
      {
        y.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "check decoder input buffer index = %d count = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(0) });
        if (ST()) {}
      }
      else
      {
        if (i >= 0)
        {
          localObject2 = localObject2[i];
          ((ByteBuffer)localObject2).clear();
          this.sampleSize = ((MediaExtractor)localObject1).readSampleData((ByteBuffer)localObject2, 0);
          ((ByteBuffer)localObject2).position(0);
          l = ((MediaExtractor)localObject1).getSampleTime();
          if (i < 0) {
            break label569;
          }
          y.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "send EOS, decoderInputBufferIndex: %s", new Object[] { Integer.valueOf(i) });
          this.eIT.queueInputBuffer(i, 0, 0, l * 1000L, 4);
        }
        label222:
        this.mlc = true;
        ST();
      }
      ai.l(new e.1(this), 500L);
      this.eIP.release();
      return;
      localObject2 = this.eIT.getInputBuffers();
      if (localObject2 != null) {
        break label274;
      }
    }
    label274:
    y.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "decoderInputByteBuffers size: %d", new Object[] { Integer.valueOf(localObject2.length) });
    int i = 0;
    int j;
    for (;;)
    {
      j = this.eIT.dequeueInputBuffer(60000L);
      if ((j >= 0) || (i >= 15)) {
        break label370;
      }
      l = bk.UZ();
      bool1 = ST();
      y.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "drain cost1 %d", new Object[] { Long.valueOf(bk.cp(l)) });
      if (bool1)
      {
        bool1 = true;
        break;
      }
      i += 1;
    }
    label370:
    if (j >= 0)
    {
      localObject2 = localObject2[j];
      ((ByteBuffer)localObject2).clear();
      this.sampleSize = ((MediaExtractor)localObject1).readSampleData((ByteBuffer)localObject2, 0);
      ((ByteBuffer)localObject2).position(0);
      l = ((MediaExtractor)localObject1).getSampleTime();
      y.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "sampleTime: %s", new Object[] { Long.valueOf(l) });
      if ((this.sampleSize >= 0) && (l < this.eIR * 1000L)) {
        break label580;
      }
    }
    label569:
    label580:
    for (bool1 = true;; bool1 = false)
    {
      y.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "sawInputEOS: %s", new Object[] { Boolean.valueOf(bool1) });
      localObject1 = this.eIT;
      int k = this.sampleSize;
      if (bool1)
      {
        i = 4;
        label494:
        ((MediaCodec)localObject1).queueInputBuffer(j, 0, k, l, i);
      }
      for (;;)
      {
        l = bk.UZ();
        boolean bool2 = ST();
        y.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "drain cost2 %d", new Object[] { Long.valueOf(bk.cp(l)) });
        if (!bool2) {
          break;
        }
        bool1 = true;
        break;
        i = 0;
        break label494;
        y.w("MicroMsg.MMSightRemuxMediaCodecDecoder", "input buffer not available");
        bool1 = false;
      }
      y.w("MicroMsg.MMSightRemuxMediaCodecDecoder", "input buffer not available");
      break label222;
    }
  }
  
  public final int e(String paramString, long paramLong1, long paramLong2, int paramInt)
  {
    if (!bk.bl(paramString)) {
      y.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "initDecoder, srcFilePath: %s, startTime: %s, endTime: %s, videoFps: %s", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt) });
    }
    for (;;)
    {
      try
      {
        this.eIP = new MediaExtractor();
        this.eIP.setDataSource(paramString);
        paramInt = 0;
        if (paramInt < this.eIP.getTrackCount())
        {
          localObject = this.eIP.getTrackFormat(paramInt);
          if (!((MediaFormat)localObject).getString("mime").toLowerCase().startsWith("video/")) {
            break label314;
          }
          this.eIU = paramInt;
          this.eIS = ((MediaFormat)localObject);
        }
        if (this.eIU < 0) {
          return -1;
        }
        this.eFp = paramString;
        this.aRW = paramLong1;
        this.eIR = paramLong2;
        this.eIP.selectTrack(this.eIU);
        paramString = this.eIS.getString("mime");
        this.eIT = MediaCodec.createDecoderByType(paramString);
        Object localObject = ol(paramString);
        y.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "found codec: %s", new Object[] { localObject });
        if (localObject != null)
        {
          y.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "codec name: %s", new Object[] { ((MediaCodecInfo)localObject).getName() });
          paramInt = a((MediaCodecInfo)localObject, paramString);
          y.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "found colorFormat: %s", new Object[] { Integer.valueOf(paramInt) });
          this.eIS.setInteger("color-format", paramInt);
        }
        this.eIT.configure(this.eIS, null, null, 0);
        this.eIT.start();
        return 0;
      }
      catch (Exception paramString)
      {
        y.printErrStackTrace("MicroMsg.MMSightRemuxMediaCodecDecoder", paramString, "Init decoder failed : %s", new Object[] { paramString.getMessage() });
        return -1;
      }
      return -1;
      label314:
      paramInt += 1;
    }
  }
  
  public final void ju(int paramInt)
  {
    y.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "setFrameDropInterval: %s", new Object[] { Integer.valueOf(paramInt) });
    this.eIV = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.b.e
 * JD-Core Version:    0.7.0.1
 */