package com.tencent.mm.plugin.mmsight.segment;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public final class MP4MuxerJNI
{
  public static final int SEGMENT_COLOR_FORMAT_YUV420P = 2;
  public static final int SEGMENT_COLOR_FORMAT_YUV420SP = 1;
  private static final Object lock;
  
  static
  {
    AppMethodBeat.i(117300);
    lock = new Object();
    AppMethodBeat.o(117300);
  }
  
  public static native boolean ffmpegCheckIfReachEndTimestamp();
  
  public static boolean ffmpegCheckIfReachEndTimestampLock()
  {
    AppMethodBeat.i(117297);
    synchronized (lock)
    {
      boolean bool = ffmpegCheckIfReachEndTimestamp();
      AppMethodBeat.o(117297);
      return bool;
    }
  }
  
  public static native byte[] ffmpegGetNextVideoFrameData(byte[] paramArrayOfByte);
  
  public static byte[] ffmpegGetNextVideoFrameDataLock(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(117296);
    synchronized (lock)
    {
      paramArrayOfByte = ffmpegGetNextVideoFrameData(paramArrayOfByte);
      AppMethodBeat.o(117296);
      return paramArrayOfByte;
    }
  }
  
  public static native int ffmpegGetVideoHeight();
  
  public static int ffmpegGetVideoHeightLock()
  {
    AppMethodBeat.i(117299);
    synchronized (lock)
    {
      int i = ffmpegGetVideoHeight();
      AppMethodBeat.o(117299);
      return i;
    }
  }
  
  public static native int ffmpegGetVideoWidth();
  
  public static int ffmpegGetVideoWidthLock()
  {
    AppMethodBeat.i(117298);
    synchronized (lock)
    {
      int i = ffmpegGetVideoWidth();
      AppMethodBeat.o(117298);
      return i;
    }
  }
  
  public static native int ffmpegOpenAndSeekFile(String paramString, double paramDouble1, double paramDouble2);
  
  public static int ffmpegOpenAndSeekFileLock(String paramString, double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(117295);
    synchronized (lock)
    {
      int i = ffmpegOpenAndSeekFile(paramString, paramDouble1, paramDouble2);
      AppMethodBeat.o(117295);
      return i;
    }
  }
  
  public static native byte[] getVideoThumb(String paramString, int paramInt1, int paramInt2);
  
  public static native int initDataBuf(int paramInt);
  
  public static int initDataBufLock(int paramInt)
  {
    AppMethodBeat.i(117285);
    synchronized (lock)
    {
      paramInt = initDataBuf(paramInt);
      AppMethodBeat.o(117285);
      return paramInt;
    }
  }
  
  public static native int initH264Encoder(int paramInt1, int paramInt2, float paramFloat1, int paramInt3, int paramInt4, int paramInt5, int paramInt6, float paramFloat2, int paramInt7, int paramInt8);
  
  public static int initH264EncoderLock(int paramInt1, int paramInt2, float paramFloat1, int paramInt3, int paramInt4, int paramInt5, int paramInt6, float paramFloat2, int paramInt7, int paramInt8)
  {
    AppMethodBeat.i(140308);
    synchronized (lock)
    {
      paramInt1 = initH264Encoder(paramInt1, paramInt2, paramFloat1, paramInt3, paramInt4, paramInt5, paramInt6, paramFloat2, paramInt7, paramInt8);
      AppMethodBeat.o(140308);
      return paramInt1;
    }
  }
  
  public static native int muxing(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString, float paramFloat, byte[] paramArrayOfByte, int paramInt6);
  
  public static native int muxingForX264(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString, float paramFloat, int paramInt5, byte[] paramArrayOfByte, int paramInt6);
  
  public static int muxingForX264Lock(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString, float paramFloat, int paramInt5, byte[] paramArrayOfByte, int paramInt6)
  {
    AppMethodBeat.i(117291);
    synchronized (lock)
    {
      paramInt1 = muxingForX264(paramInt1, paramInt2, paramInt3, paramInt4, paramString, paramFloat, paramInt5, paramArrayOfByte, paramInt6);
      AppMethodBeat.o(117291);
      return paramInt1;
    }
  }
  
  public static int muxingLock(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString, float paramFloat, byte[] paramArrayOfByte, int paramInt6)
  {
    AppMethodBeat.i(117289);
    synchronized (lock)
    {
      paramInt1 = muxing(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramString, paramFloat, paramArrayOfByte, paramInt6);
      AppMethodBeat.o(117289);
      return paramInt1;
    }
  }
  
  public static native void releaseDataBuf(int paramInt);
  
  public static void releaseDataBufLock(int paramInt)
  {
    AppMethodBeat.i(117288);
    synchronized (lock)
    {
      releaseDataBuf(paramInt);
      AppMethodBeat.o(117288);
      return;
    }
  }
  
  public static native int triggerEncodeForSegment(int paramInt, boolean paramBoolean);
  
  public static int triggerEncodeForSegmentLock(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(117294);
    synchronized (lock)
    {
      paramInt = triggerEncodeForSegment(paramInt, paramBoolean);
      AppMethodBeat.o(117294);
      return paramInt;
    }
  }
  
  public static native void writeAACData(int paramInt1, ByteBuffer paramByteBuffer, int paramInt2);
  
  public static void writeAACDataLock(int paramInt1, ByteBuffer paramByteBuffer, int paramInt2)
  {
    AppMethodBeat.i(117287);
    synchronized (lock)
    {
      writeAACData(paramInt1, paramByteBuffer, paramInt2);
      AppMethodBeat.o(117287);
      return;
    }
  }
  
  public static native void writeH264Data(int paramInt1, ByteBuffer paramByteBuffer, int paramInt2);
  
  public static void writeH264DataLock(int paramInt1, ByteBuffer paramByteBuffer, int paramInt2)
  {
    AppMethodBeat.i(117286);
    synchronized (lock)
    {
      writeH264Data(paramInt1, paramByteBuffer, paramInt2);
      AppMethodBeat.o(117286);
      return;
    }
  }
  
  public static native int writeYuvDataForSegment(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7);
  
  public static int writeYuvDataForSegmentLock(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    AppMethodBeat.i(117292);
    synchronized (lock)
    {
      paramInt1 = writeYuvDataForSegment(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7);
      AppMethodBeat.o(117292);
      return paramInt1;
    }
  }
  
  public static native void yuv420pTo420XXAndScale(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8);
  
  public static void yuv420pTo420XXAndScaleLock(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    AppMethodBeat.i(117293);
    synchronized (lock)
    {
      yuv420pTo420XXAndScale(paramArrayOfByte1, paramInt1, paramArrayOfByte2, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8);
      AppMethodBeat.o(117293);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.MP4MuxerJNI
 * JD-Core Version:    0.7.0.1
 */