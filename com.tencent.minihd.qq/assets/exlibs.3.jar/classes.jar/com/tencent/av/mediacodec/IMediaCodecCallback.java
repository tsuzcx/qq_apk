package com.tencent.av.mediacodec;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;

public abstract interface IMediaCodecCallback
{
  public abstract void onError(MediaCodec paramMediaCodec, Exception paramException);
  
  public abstract void onInputBufferAvailable(MediaCodec paramMediaCodec, int paramInt);
  
  public abstract void onOutputBufferAvailable(MediaCodec paramMediaCodec, int paramInt, MediaCodec.BufferInfo paramBufferInfo);
  
  public abstract void onOutputFormatChanged(MediaCodec paramMediaCodec, MediaFormat paramMediaFormat);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.av.mediacodec.IMediaCodecCallback
 * JD-Core Version:    0.7.0.1
 */