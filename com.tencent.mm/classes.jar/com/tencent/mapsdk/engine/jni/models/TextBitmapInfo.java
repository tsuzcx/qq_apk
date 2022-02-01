package com.tencent.mapsdk.engine.jni.models;

import com.tencent.mapsdk.internal.lz;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public class TextBitmapInfo
{
  public boolean bold;
  public float density;
  public int height;
  byte[] mData;
  public int pitch;
  public int width;
  
  public TextBitmapInfo()
  {
    AppMethodBeat.i(221100);
    this.mData = new byte[4];
    AppMethodBeat.o(221100);
  }
  
  public void fill(byte[] paramArrayOfByte)
  {
    boolean bool = true;
    AppMethodBeat.i(221106);
    Arrays.fill(this.mData, (byte)0);
    System.arraycopy(paramArrayOfByte, 0, this.mData, 0, 4);
    this.density = Float.intBitsToFloat(lz.a(this.mData));
    System.arraycopy(paramArrayOfByte, 4, this.mData, 0, 4);
    this.width = lz.a(this.mData);
    System.arraycopy(paramArrayOfByte, 8, this.mData, 0, 4);
    this.height = lz.a(this.mData);
    System.arraycopy(paramArrayOfByte, 12, this.mData, 0, 4);
    this.pitch = lz.a(this.mData);
    System.arraycopy(paramArrayOfByte, 16, this.mData, 0, 1);
    if (this.mData[0] > 0) {}
    for (;;)
    {
      this.bold = bool;
      AppMethodBeat.o(221106);
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.engine.jni.models.TextBitmapInfo
 * JD-Core Version:    0.7.0.1
 */