package com.tencent.mm.plugin.gif;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.mm.compatible.e.m;
import com.tencent.mm.compatible.loader.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import junit.framework.Assert;

public class MMWXGFJNI
{
  public static final int PIC_TYPE_JPG = 0;
  public static final int PIC_TYPE_PNG = 1;
  private static final String TAG = "MicroMsg.JNI.MMWXGF";
  static int mECode;
  static boolean mIsInit = false;
  
  static
  {
    mECode = -1;
    y.i("MicroMsg.JNI.MMWXGF", "static MMWXGFJNI");
    if (!mIsInit)
    {
      int i = m.yR();
      y.i("MicroMsg.JNI.MMWXGF", "loadVoipCodecLib cpuFlag:" + i);
      String str;
      if ((i & 0x400) != 0)
      {
        d.v(ae.getContext(), "libvoipCodec_v7a.so");
        str = new File(ae.getContext().getDir("lib", 0), "libvoipCodec_v7a.so").getAbsolutePath();
        i = nativeInit(str);
        mECode = i;
        if (i < 0) {
          break label182;
        }
      }
      label182:
      for (boolean bool = true;; bool = false)
      {
        mIsInit = bool;
        y.i("MicroMsg.JNI.MMWXGF", "native init MMWXGF mECode:%d result:%b :%s", new Object[] { Integer.valueOf(mECode), Boolean.valueOf(mIsInit), str });
        return;
        if ((i & 0x200) != 0)
        {
          d.v(ae.getContext(), "libvoipCodec.so");
          Assert.assertTrue("Can't remove libvoipCodec.so yet.", false);
          break;
        }
        d.v(ae.getContext(), "libvoipCodec_v5.so");
        Assert.assertTrue("Can't remove libvoipCodec.so yet.", false);
        break;
      }
    }
    y.d("MicroMsg.JNI.MMWXGF", "MMWXGF has init.");
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
  
  public static native int nativeRewindBuffer(long paramLong);
  
  public static native int nativeUninit(long paramLong);
  
  public static native int nativeWxam2Pic(String paramString1, String paramString2);
  
  public static native byte[] nativeWxamToGif(byte[] paramArrayOfByte);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gif.MMWXGFJNI
 * JD-Core Version:    0.7.0.1
 */