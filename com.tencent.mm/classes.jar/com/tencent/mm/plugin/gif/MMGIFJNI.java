package com.tencent.mm.plugin.gif;

import android.graphics.Bitmap;
import java.io.FileDescriptor;
import java.io.InputStream;

public class MMGIFJNI
{
  public static native byte[] decFile(String paramString1, String paramString2);
  
  public static native boolean drawFrameBitmap(long paramLong, Bitmap paramBitmap, int[] paramArrayOfInt);
  
  public static native boolean drawFramePixels(long paramLong, int[] paramArrayOfInt1, int[] paramArrayOfInt2);
  
  public static native void encFile(String paramString1, String paramString2);
  
  public static native String encodeString(String paramString);
  
  public static native int getCurrentFrameDuration(long paramLong);
  
  public static native int getCurrentFrameIndex(long paramLong);
  
  public static native int getHeight(long paramLong);
  
  public static native int getTotalFrameCount(long paramLong);
  
  public static native int getWidth(long paramLong);
  
  public static native void isEncFile(String paramString);
  
  public static native boolean isGif(long paramLong);
  
  public static native void lockBitmap(Bitmap paramBitmap);
  
  public static native long openByByteArray(byte[] paramArrayOfByte, int[] paramArrayOfInt);
  
  public static native long openByFileDescroptor(FileDescriptor paramFileDescriptor, long paramLong, int[] paramArrayOfInt);
  
  public static native long openByFilePath(String paramString, int[] paramArrayOfInt);
  
  public static native long openByInputStrem(InputStream paramInputStream, int[] paramArrayOfInt);
  
  public static native void recycle(long paramLong);
  
  public static native void reset(long paramLong);
  
  public static native void restoreRemainder(long paramLong);
  
  public static native void saveRemainder(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gif.MMGIFJNI
 * JD-Core Version:    0.7.0.1
 */