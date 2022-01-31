package com.tencent.liteav.videoencoder;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import com.tencent.liteav.basic.f.b;
import com.tencent.liteav.basic.module.a;
import java.nio.ByteBuffer;

public class c
  extends a
{
  protected com.tencent.liteav.basic.d.d mEncodeFilter;
  private boolean mEncodeFirstGOP = false;
  protected Object mGLContextExternal = null;
  protected boolean mInit;
  protected com.tencent.liteav.basic.d.d mInputFilter;
  protected int mInputHeight = 0;
  protected int mInputTextureID = -1;
  protected int mInputWidth = 0;
  protected d mListener = null;
  protected int mOutputHeight = 0;
  protected int mOutputWidth = 0;
  private long mVideoGOPEncode = 0L;
  
  protected void callDelegate(int paramInt)
  {
    callDelegate(null, 0, 0L, 0L, 0L, 0L, 0L, 0L, paramInt, null, null);
  }
  
  protected void callDelegate(MediaFormat paramMediaFormat)
  {
    if (this.mListener != null) {
      this.mListener.a(paramMediaFormat);
    }
  }
  
  protected void callDelegate(byte[] paramArrayOfByte, int paramInt1, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, int paramInt2, ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    MediaCodec.BufferInfo localBufferInfo;
    if (paramByteBuffer == null)
    {
      paramByteBuffer = null;
      if (paramBufferInfo != null) {
        break label229;
      }
      localBufferInfo = null;
      label16:
      if (localBufferInfo != null) {
        localBufferInfo.set(paramBufferInfo.offset, paramBufferInfo.size, paramBufferInfo.presentationTimeUs, paramBufferInfo.flags);
      }
      paramBufferInfo = this.mListener;
      if (paramBufferInfo != null)
      {
        b localb = new b();
        localb.a = paramArrayOfByte;
        localb.b = paramInt1;
        localb.c = paramLong1;
        localb.d = paramLong2;
        localb.e = paramLong3;
        localb.f = paramLong4;
        localb.g = paramLong5;
        localb.h = paramLong6;
        localb.j = paramByteBuffer;
        if (localBufferInfo != null) {
          localb.k = localBufferInfo;
        }
        paramBufferInfo.a(localb, paramInt2);
        setStatusValue(4002, Long.valueOf(getRealBitrate()));
        setStatusValue(4001, Double.valueOf(getRealFPS()));
        if (paramInt1 != 0) {
          break label241;
        }
        if (this.mVideoGOPEncode != 0L)
        {
          this.mEncodeFirstGOP = true;
          setStatusValue(4003, Long.valueOf(this.mVideoGOPEncode));
        }
        this.mVideoGOPEncode = 1L;
      }
    }
    label229:
    label241:
    do
    {
      return;
      paramByteBuffer = paramByteBuffer.asReadOnlyBuffer();
      break;
      localBufferInfo = new MediaCodec.BufferInfo();
      break label16;
      this.mVideoGOPEncode += 1L;
    } while (this.mEncodeFirstGOP);
    setStatusValue(4003, Long.valueOf(this.mVideoGOPEncode));
  }
  
  public long getRealBitrate()
  {
    return 0L;
  }
  
  public long getRealFPS()
  {
    return 0L;
  }
  
  public int getVideoHeight()
  {
    return this.mOutputHeight;
  }
  
  public int getVideoWidth()
  {
    return this.mOutputWidth;
  }
  
  public long pushVideoFrame(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    return 10000002L;
  }
  
  public long pushVideoFrameSync(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    return 10000002L;
  }
  
  public void setBitrate(int paramInt) {}
  
  public void setFPS(int paramInt) {}
  
  public void setListener(d paramd)
  {
    this.mListener = paramd;
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
    }
    this.mVideoGOPEncode = 0L;
    this.mEncodeFirstGOP = false;
    return 10000002;
  }
  
  public void stop() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.liteav.videoencoder.c
 * JD-Core Version:    0.7.0.1
 */