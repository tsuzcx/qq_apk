package com.tencent.mobileqq.pic;

import java.nio.ByteBuffer;

public abstract interface JpegDataDest
{
  public abstract void dataArrived(ByteBuffer paramByteBuffer, boolean paramBoolean, Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pic.JpegDataDest
 * JD-Core Version:    0.7.0.1
 */