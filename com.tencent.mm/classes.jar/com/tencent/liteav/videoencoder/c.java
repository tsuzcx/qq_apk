package com.tencent.liteav.videoencoder;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import com.tencent.liteav.basic.d.g;
import com.tencent.liteav.basic.module.a;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public class c
  extends a
{
  protected g mEncodeFilter;
  private boolean mEncodeFirstGOP = false;
  protected Object mGLContextExternal = null;
  protected boolean mInit;
  protected g mInputFilter;
  protected int mInputHeight = 0;
  protected int mInputTextureID = -1;
  protected int mInputWidth = 0;
  protected d mListener = null;
  protected int mOutputHeight = 0;
  protected int mOutputWidth = 0;
  protected int mRotation = 0;
  private int mStreamType = 2;
  private long mVideoGOPEncode = 0L;
  
  protected void callDelegate(int paramInt)
  {
    AppMethodBeat.i(67442);
    callDelegate(null, 0, 0L, 0L, 0L, 0L, 0L, 0L, paramInt, null, null);
    AppMethodBeat.o(67442);
  }
  
  protected void callDelegate(MediaFormat paramMediaFormat)
  {
    AppMethodBeat.i(67444);
    if (this.mListener != null) {
      this.mListener.a(paramMediaFormat);
    }
    AppMethodBeat.o(67444);
  }
  
  protected void callDelegate(byte[] paramArrayOfByte, int paramInt1, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, int paramInt2, ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    AppMethodBeat.i(67443);
    if (paramByteBuffer == null)
    {
      paramByteBuffer = null;
      if (paramBufferInfo != null) {
        break label251;
      }
    }
    label251:
    for (MediaCodec.BufferInfo localBufferInfo = null;; localBufferInfo = new MediaCodec.BufferInfo())
    {
      if (localBufferInfo != null) {
        localBufferInfo.set(paramBufferInfo.offset, paramBufferInfo.size, paramBufferInfo.presentationTimeUs, paramBufferInfo.flags);
      }
      paramBufferInfo = this.mListener;
      if (paramBufferInfo == null) {
        break label295;
      }
      TXSNALPacket localTXSNALPacket = new TXSNALPacket();
      localTXSNALPacket.nalData = paramArrayOfByte;
      localTXSNALPacket.nalType = paramInt1;
      localTXSNALPacket.gopIndex = paramLong1;
      localTXSNALPacket.gopFrameIndex = paramLong2;
      localTXSNALPacket.frameIndex = paramLong3;
      localTXSNALPacket.refFremeIndex = paramLong4;
      localTXSNALPacket.pts = paramLong5;
      localTXSNALPacket.dts = paramLong6;
      localTXSNALPacket.buffer = paramByteBuffer;
      localTXSNALPacket.streamType = this.mStreamType;
      if (localBufferInfo != null) {
        localTXSNALPacket.info = localBufferInfo;
      }
      paramBufferInfo.a(localTXSNALPacket, paramInt2);
      setStatusValue(4002, Long.valueOf(getRealBitrate()));
      setStatusValue(4001, this.mStreamType, Double.valueOf(getRealFPS()));
      if (paramInt1 != 0) {
        break label263;
      }
      if (this.mVideoGOPEncode != 0L)
      {
        this.mEncodeFirstGOP = true;
        setStatusValue(4006, Long.valueOf(this.mVideoGOPEncode));
      }
      this.mVideoGOPEncode = 1L;
      AppMethodBeat.o(67443);
      return;
      paramByteBuffer = paramByteBuffer.asReadOnlyBuffer();
      break;
    }
    label263:
    this.mVideoGOPEncode += 1L;
    if (!this.mEncodeFirstGOP) {
      setStatusValue(4006, Long.valueOf(this.mVideoGOPEncode));
    }
    label295:
    AppMethodBeat.o(67443);
  }
  
  public void enableNearestRPS(int paramInt) {}
  
  public long getRealBitrate()
  {
    return 0L;
  }
  
  public double getRealFPS()
  {
    return 0.0D;
  }
  
  public int getVideoHeight()
  {
    return this.mOutputHeight;
  }
  
  public int getVideoWidth()
  {
    return this.mOutputWidth;
  }
  
  protected void onEncodeFinished(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(146307);
    if (this.mListener != null) {
      this.mListener.a(paramLong1, paramLong2, paramLong3);
    }
    AppMethodBeat.o(146307);
  }
  
  public long pushVideoFrame(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    return 10000002L;
  }
  
  public long pushVideoFrameSync(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    return 10000002L;
  }
  
  public void restartIDR() {}
  
  public void setBitrate(int paramInt) {}
  
  public void setBitrateFromQos(int paramInt1, int paramInt2) {}
  
  public void setEncodeIdrFpsFromQos(int paramInt) {}
  
  public void setFPS(int paramInt) {}
  
  public void setListener(d paramd)
  {
    this.mListener = paramd;
  }
  
  public void setRPSRefBitmap(int paramInt1, int paramInt2, long paramLong) {}
  
  public void setRotation(int paramInt)
  {
    this.mRotation = paramInt;
  }
  
  public void signalEOSAndFlush() {}
  
  public int start(TXSVideoEncoderParam paramTXSVideoEncoderParam)
  {
    if (paramTXSVideoEncoderParam != null)
    {
      this.mOutputWidth = paramTXSVideoEncoderParam.width;
      this.mOutputHeight = paramTXSVideoEncoderParam.height;
      this.mInputWidth = paramTXSVideoEncoderParam.width;
      this.mInputHeight = paramTXSVideoEncoderParam.height;
      this.mGLContextExternal = paramTXSVideoEncoderParam.glContext;
      this.mStreamType = paramTXSVideoEncoderParam.streamType;
    }
    this.mVideoGOPEncode = 0L;
    this.mEncodeFirstGOP = false;
    return 10000002;
  }
  
  public void stop() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.liteav.videoencoder.c
 * JD-Core Version:    0.7.0.1
 */