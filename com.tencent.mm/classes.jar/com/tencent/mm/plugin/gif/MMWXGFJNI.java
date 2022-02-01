package com.tencent.mm.plugin.gif;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.q;
import com.tencent.mm.sdk.platformtools.ae;

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
    ae.i("MicroMsg.JNI.MMWXGF", "static MMWXGFJNI");
    if (!mIsInit)
    {
      int i = nativeInit("libvoipCodec.so");
      mECode = i;
      if (i >= 0) {}
      for (boolean bool = true;; bool = false)
      {
        mIsInit = bool;
        ae.i("MicroMsg.JNI.MMWXGF", "native init MMWXGF mECode:%d result:%b :%s", new Object[] { Integer.valueOf(mECode), Boolean.valueOf(mIsInit), "libvoipCodec.so" });
        AppMethodBeat.o(104681);
        return;
      }
    }
    ae.d("MicroMsg.JNI.MMWXGF", "MMWXGF has init.");
    AppMethodBeat.o(104681);
  }
  
  public static int getErrorCode()
  {
    return mECode;
  }
  
  private static native int nativeAV2Gif(String paramString1, String paramString2);
  
  private static native int nativeAV2Gif(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
  
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
  
  private static native int nativePic2Wxam(String paramString1, String paramString2, int paramInt1, int paramInt2);
  
  private static native int nativePic2WxamWithWH(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  private static native int nativePic2WxamWithWH(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7);
  
  public static native int nativeRewindBuffer(long paramLong);
  
  public static native int nativeUninit(long paramLong);
  
  private static native int nativeWxam2Pic(String paramString1, String paramString2);
  
  public static native byte[] nativeWxam2PicBuf(byte[] paramArrayOfByte);
  
  public static native byte[] nativeWxamToGif(byte[] paramArrayOfByte);
  
  public static int pic2Wxam(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(188501);
    paramInt1 = nativePic2Wxam(q.k(paramString1, false), q.k(paramString2, true), paramInt1, paramInt2);
    AppMethodBeat.o(188501);
    return paramInt1;
  }
  
  public static int pic2WxamWithWH(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(188503);
    paramInt1 = nativePic2WxamWithWH(q.k(paramString1, false), q.k(paramString2, true), paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(188503);
    return paramInt1;
  }
  
  public static int pic2WxamWithWH(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    AppMethodBeat.i(188504);
    paramInt1 = nativePic2WxamWithWH(q.k(paramString, true), paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7);
    AppMethodBeat.o(188504);
    return paramInt1;
  }
  
  public static int wxam2Pic(String paramString1, String paramString2)
  {
    AppMethodBeat.i(188502);
    int i = nativeWxam2Pic(q.k(paramString1, false), q.k(paramString2, true));
    AppMethodBeat.o(188502);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gif.MMWXGFJNI
 * JD-Core Version:    0.7.0.1
 */