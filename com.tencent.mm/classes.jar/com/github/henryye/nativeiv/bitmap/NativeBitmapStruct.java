package com.github.henryye.nativeiv.bitmap;

import android.support.annotation.Keep;

public class NativeBitmapStruct
{
  @Keep
  public int glFormat;
  @Keep
  public int glType;
  @Keep
  public int height;
  @Keep
  public long ptr;
  @Keep
  public int width;
  
  @Keep
  public static abstract interface GLType
  {
    public static final int GL_UNSIGNED_BYTE = 5121;
    public static final int GL_UNSIGNED_SHORT_4_4_4_4 = 32819;
    public static final int GL_UNSIGNED_SHORT_5_5_5_1 = 32820;
    public static final int GL_UNSIGNED_SHORT_5_6_5 = 33635;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.github.henryye.nativeiv.bitmap.NativeBitmapStruct
 * JD-Core Version:    0.7.0.1
 */