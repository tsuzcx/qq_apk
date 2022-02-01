package com.tencent.mm.plugin.gif;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.ac;

public class MMWXGFJNI
{
  public static final int PIC_TYPE_JPG = 0;
  public static final int PIC_TYPE_PNG = 1;
  private static final String TAG = "MicroMsg.JNI.MMWXGF";
  static int mECode;
  static boolean mIsInit;
  
  static
  {
    AppMethodBeat.i(104681);
    mIsInit = false;
    mECode = -1;
    ac.i("MicroMsg.JNI.MMWXGF", "static MMWXGFJNI");
    if (!mIsInit)
    {
      String str = b.aoY() + "lib/libvoipCodec.so";
      int i = nativeInit(str);
      mECode = i;
      if (i >= 0) {}
      for (boolean bool = true;; bool = false)
      {
        mIsInit = bool;
        ac.i("MicroMsg.JNI.MMWXGF", "native init MMWXGF mECode:%d result:%b :%s", new Object[] { Integer.valueOf(mECode), Boolean.valueOf(mIsInit), str });
        AppMethodBeat.o(104681);
        return;
      }
    }
    ac.d("MicroMsg.JNI.MMWXGF", "MMWXGF has init.");
    AppMethodBeat.o(104681);
  }
  
  public static int getErrorCode()
  {
    return mECode;
  }
  
  public static native int nativeAV2Gif(String paramString1, String paramString2);
  
  public static native int nativeAV2Gif(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
  
  public static native int nativeAddGifEncodeRgbaFrame(long paramLong1, int paramInt1, int paramInt2, byte[] paramArrayOfByte, long paramLong2);
  
  public static native int nativeAddWxAMEncodeRgbaFrame(long paramLong1, int paramInt1, int paramInt2, byte[] paramArrayOfByte, long paramLong2);
  
  public static native int nativeDecodeBufferFrame(long paramLong, byte[] paramArrayOfByte, int paramInt, Bitmap paramBitmap, int[] paramArrayOfInt);
  
  public static native int nativeDecodeBufferHeader(long paramLong, byte[] paramArrayOfByte, int paramInt);
  
  public static native byte[] nativeFinishGifEncode(long paramLong);
  
  public static native byte[] nativeFinishWxAMEncode(long paramLong);
  
  public static native int nativeGetOption(long paramLong, byte[] paramArrayOfByte, int paramInt, int[] paramArrayOfInt);
  
  public static native int nativeInit(String paramString);
  
  public static native long nativeInitGifEncode(int paramInt1, int paramInt2, long paramLong);
  
  public static native long nativeInitWxAMDecoder();
  
  public static native long nativeInitWxAMEncoder(int paramInt1, int paramInt2, long paramLong, int paramInt3);
  
  public static native boolean nativeIsWXGF(byte[] paramArrayOfByte, int paramInt);
  
  public static native int nativePic2Wxam(String paramString1, String paramString2, int paramInt1, int paramInt2);
  
  public static native int nativePic2WxamWithWH(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public static native int nativePic2WxamWithWH(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7);
  
  public static native int nativeRewindBuffer(long paramLong);
  
  public static native int nativeUninit(long paramLong);
  
  public static native int nativeWxam2Pic(String paramString1, String paramString2);
  
  public static native byte[] nativeWxam2PicBuf(byte[] paramArrayOfByte);
  
  public static native byte[] nativeWxamToGif(byte[] paramArrayOfByte);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.gif.MMWXGFJNI
 * JD-Core Version:    0.7.0.1
 */