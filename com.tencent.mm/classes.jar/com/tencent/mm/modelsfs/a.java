package com.tencent.mm.modelsfs;

import com.tencent.mm.plugin.imgenc.MMIMAGEENCJNI;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class a
{
  private static boolean eyq = false;
  private long eyr = 0L;
  private String eys;
  private long eyt = 0L;
  private long mNativePtr = 0L;
  
  public a(long paramLong)
  {
    this.eys = String.valueOf(paramLong);
    init();
  }
  
  public a(String paramString)
  {
    this.eys = paramString;
    init();
  }
  
  private void init()
  {
    y.i("MicroMsg.EncEngine", "init  key  enckey " + this.eys + "  hashcode " + hashCode());
    this.mNativePtr = MMIMAGEENCJNI.open(this.eys);
    try
    {
      y.i("MicroMsg.EncEngine", "mNativePtr " + this.mNativePtr + " " + hashCode());
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.EncEngine", "exception " + localException.getMessage());
    }
  }
  
  public final long Qa()
  {
    this.eyt = this.eyr;
    return this.eyt;
  }
  
  public final void free()
  {
    y.i("MicroMsg.EncEngine", "free mNativePtr: " + this.mNativePtr + " hashcode " + hashCode());
    MMIMAGEENCJNI.free(this.mNativePtr);
    this.mNativePtr = 0L;
  }
  
  public final void reset()
  {
    y.i("MicroMsg.EncEngine", "reset " + bk.csb());
    free();
    if (this.eyt == 0L)
    {
      init();
      this.eyr = 0L;
      return;
    }
    init();
    MMIMAGEENCJNI.seek(this.mNativePtr, this.eyt, 1);
    this.eyr = this.eyt;
  }
  
  public final void seek(long paramLong)
  {
    this.eyr = paramLong;
    MMIMAGEENCJNI.seek(this.mNativePtr, paramLong, 1);
  }
  
  public final int x(byte[] paramArrayOfByte, int paramInt)
  {
    if (this.mNativePtr == 0L) {
      y.i("MicroMsg.EncEngine", "transFor " + bk.csb().toString());
    }
    if (eyq) {
      y.i("MicroMsg.EncEngine", "trans for  " + hashCode() + " " + paramArrayOfByte.length);
    }
    if ((eyq) && (this.eyr < 64L)) {
      y.d("MicroMsg.EncEngine", "dump before _offset " + this.eyr + "  length:" + paramInt + " " + bk.bD(paramArrayOfByte) + " hashcode " + hashCode());
    }
    MMIMAGEENCJNI.transFor(this.mNativePtr, paramArrayOfByte, this.eyr, paramInt);
    if ((eyq) && (this.eyr < 64L)) {
      y.d("MicroMsg.EncEngine", "dump after _offset " + this.eyr + "  length:" + paramInt + " " + bk.bD(paramArrayOfByte) + " hashcode " + hashCode());
    }
    this.eyr += paramInt;
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelsfs.a
 * JD-Core Version:    0.7.0.1
 */